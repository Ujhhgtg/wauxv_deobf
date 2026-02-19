package net.bytebuddy.jar.asm;

import com.alibaba.fastjson2.JSONB;
import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttBootstrapMethods;
import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceDebugExtension;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import com.umeng.analytics.pro.dn;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassReader {
    static final int EXPAND_ASM_INSNS = 256;
    public static final int EXPAND_FRAMES = 8;
    private static final int INPUT_STREAM_DATA_CHUNK_SIZE = 4096;
    private static final int MAX_BUFFER_SIZE = 1048576;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;

    @Deprecated
    public final byte[] b;
    private final int[] bootstrapMethodOffsets;
    final byte[] classFileBuffer;
    private final ConstantDynamic[] constantDynamicValues;
    private final String[] constantUtf8Values;
    private final int[] cpInfoOffsets;
    public final int header;
    private final int maxStringLength;

    public ClassReader(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    private static int computeBufferSize(InputStream inputStream) throws IOException {
        int iAvailable = inputStream.available();
        if (iAvailable < 256) {
            return 4096;
        }
        return Math.min(iAvailable, MAX_BUFFER_SIZE);
    }

    private void computeImplicitFrame(Context context) {
        int i;
        String str = context.currentMethodDescriptor;
        Object[] objArr = context.currentFrameLocalTypes;
        int i2 = 0;
        if ((context.currentMethodAccessFlags & 8) == 0) {
            if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(context.currentMethodName)) {
                objArr[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                objArr[0] = readClass(this.header + 2, context.charBuffer);
            }
            i2 = 1;
        }
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt == 'F') {
                i = i2 + 1;
                objArr[i2] = Opcodes.FLOAT;
            } else if (cCharAt != 'L') {
                if (cCharAt != 'S' && cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        i = i2 + 1;
                        objArr[i2] = Opcodes.LONG;
                    } else if (cCharAt != 'Z') {
                        if (cCharAt != '[') {
                            switch (cCharAt) {
                                case 'B':
                                case 'C':
                                    break;
                                case 'D':
                                    i = i2 + 1;
                                    objArr[i2] = Opcodes.DOUBLE;
                                    break;
                                default:
                                    context.currentFrameLocalCount = i2;
                                    return;
                            }
                        } else {
                            while (str.charAt(i4) == '[') {
                                i4++;
                            }
                            if (str.charAt(i4) == 'L') {
                                do {
                                    i4++;
                                } while (str.charAt(i4) != ';');
                            }
                            int i5 = i4 + 1;
                            objArr[i2] = str.substring(i3, i5);
                            i3 = i5;
                            i2++;
                        }
                    }
                }
                i = i2 + 1;
                objArr[i2] = Opcodes.INTEGER;
            } else {
                int i6 = i4;
                while (str.charAt(i6) != ';') {
                    i6++;
                }
                objArr[i2] = str.substring(i4, i6);
                i2++;
                i3 = i6 + 1;
            }
            i2 = i;
            i3 = i4;
        }
    }

    private void createDebugLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            Label label = readLabel(i, labelArr);
            label.flags = (short) (label.flags | 1);
        }
    }

    private Label createLabel(int i, Label[] labelArr) {
        Label label = readLabel(i, labelArr);
        label.flags = (short) (label.flags & (-2));
        return label;
    }

    private int getTypeAnnotationBytecodeOffset(int[] iArr, int i) {
        if (iArr == null || i >= iArr.length || readByte(iArr[i]) < 67) {
            return -1;
        }
        return readUnsignedShort(iArr[i] + 1);
    }

    private Attribute readAttribute(Attribute[] attributeArr, String str, int i, int i2, char[] cArr, int i3,
            Label[] labelArr) {
        for (Attribute attribute : attributeArr) {
            if (attribute.type.equals(str)) {
                return attribute.read(this, i, i2, cArr, i3, labelArr);
            }
        }
        return new Attribute(str).read(this, i, i2, null, -1, null);
    }

    private int[] readBootstrapMethodsAttribute(int i) {
        char[] cArr = new char[i];
        int firstAttributeOffset = getFirstAttributeOffset();
        for (int unsignedShort = readUnsignedShort(firstAttributeOffset - 2); unsignedShort > 0; unsignedShort--) {
            String utf8 = readUTF8(firstAttributeOffset, cArr);
            int i2 = readInt(firstAttributeOffset + 2);
            int i3 = firstAttributeOffset + 6;
            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(utf8)) {
                int unsignedShort2 = readUnsignedShort(i3);
                int[] iArr = new int[unsignedShort2];
                int unsignedShort3 = firstAttributeOffset + 8;
                for (int i4 = 0; i4 < unsignedShort2; i4++) {
                    iArr[i4] = unsignedShort3;
                    unsignedShort3 += (readUnsignedShort(unsignedShort3 + 2) * 2) + 4;
                }
                return iArr;
            }
            firstAttributeOffset = i3 + i2;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Found duplicated region for block: B:148:0x03c9 */
    /* JADX WARN: Found duplicated region for block: B:150:0x03cf */
    /* JADX WARN: Found duplicated region for block: B:151:0x03db */
    /* JADX WARN: Found duplicated region for block: B:153:0x03e0 */
    /* JADX WARN: Found duplicated region for block: B:158:0x03f3 */
    /* JADX WARN: Found duplicated region for block: B:161:0x040f */
    /* JADX WARN: Found duplicated region for block: B:163:0x0413 */
    /* JADX WARN: Found duplicated region for block: B:164:0x0416 */
    /* JADX WARN: Found duplicated region for block: B:174:0x0444 */
    /* JADX WARN: Found duplicated region for block: B:176:0x0455 */
    /* JADX WARN: Found duplicated region for block: B:179:0x0470 */
    /* JADX WARN: Found duplicated region for block: B:180:0x0482 */
    /* JADX WARN: Found duplicated region for block: B:182:0x048c */
    /* JADX WARN: Found duplicated region for block: B:185:0x04ab */
    /* JADX WARN: Found duplicated region for block: B:186:0x04b7 */
    /* JADX WARN: Found duplicated region for block: B:187:0x04c5 A[MOVE_INLINED] */
    /*
     * JADX WARN: Found duplicated region for block: B:189:0x050e A[LOOP:12:
     * B:188:0x050c->B:189:0x050e, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:191:0x0528 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:193:0x0554 */
    /* JADX WARN: Found duplicated region for block: B:194:0x055a */
    /* JADX WARN: Found duplicated region for block: B:196:0x0562 */
    /* JADX WARN: Found duplicated region for block: B:198:0x0568 */
    /* JADX WARN: Found duplicated region for block: B:202:0x0572 */
    /*
     * JADX WARN: Found duplicated region for block: B:203:0x0576 A[PHI: r37 r42
     * 0x0576: PHI (r37v14 boolean) = (r37v2 boolean), (r37v4 boolean), (r37v10
     * boolean), (r37v11 boolean), (r37v15 boolean) binds: [B:221:0x0681,
     * B:219:0x0658, B:213:0x0609, B:212:0x05f5, B:201:0x0570] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x0576: PHI (r42v15 int) = (r42v3 int), (r42v5 int), (r42v11 int), (r42v12
     * int), (r42v16 int) binds: [B:221:0x0681, B:219:0x0658, B:213:0x0609,
     * B:212:0x05f5, B:201:0x0570] A[DONT_GENERATE, DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:204:0x057a */
    /*
     * JADX WARN: Found duplicated region for block: B:206:0x059c A[LOOP:13:
     * B:205:0x059a->B:206:0x059c, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:208:0x05b7 */
    /*
     * JADX WARN: Found duplicated region for block: B:210:0x05e1 A[LOOP:14:
     * B:209:0x05df->B:210:0x05e1, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:212:0x05f5 */
    /* JADX WARN: Found duplicated region for block: B:213:0x0609 */
    /* JADX WARN: Found duplicated region for block: B:214:0x061e */
    /* JADX WARN: Found duplicated region for block: B:216:0x0633 */
    /* JADX WARN: Found duplicated region for block: B:217:0x0645 */
    /* JADX WARN: Found duplicated region for block: B:219:0x0658 */
    /* JADX WARN: Found duplicated region for block: B:220:0x066d */
    /* JADX WARN: Found duplicated region for block: B:221:0x0681 */
    /* JADX WARN: Found duplicated region for block: B:222:0x0692 */
    /* JADX WARN: Found duplicated region for block: B:223:0x06a0 */
    /* JADX WARN: Found duplicated region for block: B:225:0x06ac */
    /* JADX WARN: Found duplicated region for block: B:229:0x06b3 */
    /* JADX WARN: Found duplicated region for block: B:230:0x06cf */
    /* JADX WARN: Found duplicated region for block: B:234:0x06e4 */
    /*
     * JADX WARN: Found duplicated region for block: B:236:0x06e9 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:342:0x03ed A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:354:0x0729 A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:355:0x0721 A[ADDED_TO_REGION,
     * REMOVE, SYNTHETIC]
     */
    private void readCode(MethodVisitor methodVisitor, Context context, int i) {
        int i2;
        char[] cArr;
        Attribute attribute;
        byte[] bArr;
        int i3;
        int i4;
        Label[] labelArr;
        boolean z;
        int i5;
        MethodVisitor methodVisitor2;
        int i6;
        int[] iArr;
        int i7;
        String utf8;
        int[] iArr2;
        int i8;
        boolean z2;
        int i9;
        int[] iArr3;
        int i10;
        int i11;
        boolean z3;
        int i12;
        int i13;
        boolean z4;
        int i14;
        int i15;
        Label[] labelArr2;
        int i16;
        int i17;
        int[] iArr4;
        Label[] labelArr3;
        int i18;
        int i19;
        String str;
        String utf82;
        String utf83;
        String str2;
        boolean z5;
        int unsignedShort;
        Object[] objArr;
        int i20;
        int i21;
        char c;
        int typeAnnotationBytecodeOffset;
        int i22;
        int i23;
        int i24;
        Label label;
        boolean z6;
        int i25;
        int typeAnnotationBytecodeOffset2;
        int i26;
        int i27;
        int i28;
        int[] iArr5;
        int i29;
        int i30;
        int i31;
        int i32;
        int[] iArr6;
        int i33;
        boolean z7;
        int i34;
        int[] iArr7;
        int i35;
        int i36;
        int i37;
        byte b;
        int unsignedShort2;
        int[] typeAnnotations;
        byte b2;
        ClassReader classReader;
        Label[] labelArr4;
        int i38;
        ClassReader classReader2 = this;
        MethodVisitor methodVisitor3 = methodVisitor;
        byte[] bArr2 = classReader2.classFileBuffer;
        char[] cArr2 = context.charBuffer;
        int unsignedShort3 = classReader2.readUnsignedShort(i);
        int unsignedShort4 = classReader2.readUnsignedShort(i + 2);
        int i39 = classReader2.readInt(i + 4);
        int i40 = i + 8;
        if (i39 > classReader2.classFileBuffer.length - i40) {
            throw new IllegalArgumentException();
        }
        int i41 = i40 + i39;
        Label[] labelArr5 = new Label[i39 + 1];
        context.currentMethodLabels = labelArr5;
        int i42 = i40;
        while (i42 < i41) {
            int i43 = i42 - i40;
            switch (bArr2[i42] & 255) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 177:
                case 190:
                case 191:
                case 194:
                case 195:
                    i42++;
                    break;
                case 16:
                case 18:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 169:
                case 188:
                    i42 += 2;
                    break;
                case 17:
                case 19:
                case 20:
                case 132:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 189:
                case 192:
                case 193:
                    i42 += 3;
                    break;
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 198:
                case 199:
                    classReader2.createLabel(classReader2.readShort(i42 + 1) + i43, labelArr5);
                    i42 += 3;
                    break;
                case 170:
                    int i44 = (4 - (i43 & 3)) + i42;
                    classReader2.createLabel(classReader2.readInt(i44) + i43, labelArr5);
                    int i45 = (classReader2.readInt(i44 + 8) - classReader2.readInt(i44 + 4)) + 1;
                    i38 = i44 + 12;
                    while (true) {
                        int i46 = i45 - 1;
                        if (i45 <= 0) {
                            i42 = i38;
                        } else {
                            classReader2.createLabel(classReader2.readInt(i38) + i43, labelArr5);
                            i38 += 4;
                            i45 = i46;
                        }
                        break;
                    }
                    break;
                case 171:
                    int i47 = (4 - (i43 & 3)) + i42;
                    classReader2.createLabel(classReader2.readInt(i47) + i43, labelArr5);
                    int i48 = classReader2.readInt(i47 + 4);
                    i38 = i47 + 8;
                    while (true) {
                        int i49 = i48 - 1;
                        if (i48 <= 0) {
                            i42 = i38;
                        } else {
                            classReader2.createLabel(classReader2.readInt(i38 + 4) + i43, labelArr5);
                            i38 += 8;
                            i48 = i49;
                        }
                        break;
                    }
                    break;
                case 185:
                case 186:
                    i42 += 5;
                    break;
                case 196:
                    int i50 = bArr2[i42 + 1] & 255;
                    if (i50 != 132) {
                        if (i50 != 169) {
                            switch (i50) {
                                default:
                                    switch (i50) {
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            throw new IllegalArgumentException();
                                    }
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    i42 += 4;
                                    break;
                            }
                        }
                        i42 += 4;
                    } else {
                        i42 += 6;
                    }
                    break;
                case 197:
                    i42 += 4;
                    break;
                case 200:
                case 201:
                case com.android.dx.io.Opcodes.REM_INT_LIT8 /* 220 */:
                    classReader2.createLabel(classReader2.readInt(i42 + 1) + i43, labelArr5);
                    i42 += 5;
                    break;
                case 202:
                case 203:
                case 204:
                case com.android.dx.io.Opcodes.MUL_DOUBLE_2ADDR /* 205 */:
                case com.android.dx.io.Opcodes.DIV_DOUBLE_2ADDR /* 206 */:
                case com.android.dx.io.Opcodes.REM_DOUBLE_2ADDR /* 207 */:
                case com.android.dx.io.Opcodes.ADD_INT_LIT16 /* 208 */:
                case com.android.dx.io.Opcodes.RSUB_INT /* 209 */:
                case com.android.dx.io.Opcodes.MUL_INT_LIT16 /* 210 */:
                case com.android.dx.io.Opcodes.DIV_INT_LIT16 /* 211 */:
                case com.android.dx.io.Opcodes.REM_INT_LIT16 /* 212 */:
                case com.android.dx.io.Opcodes.AND_INT_LIT16 /* 213 */:
                case com.android.dx.io.Opcodes.OR_INT_LIT16 /* 214 */:
                case com.android.dx.io.Opcodes.XOR_INT_LIT16 /* 215 */:
                case com.android.dx.io.Opcodes.ADD_INT_LIT8 /* 216 */:
                case com.android.dx.io.Opcodes.RSUB_INT_LIT8 /* 217 */:
                case com.android.dx.io.Opcodes.MUL_INT_LIT8 /* 218 */:
                case com.android.dx.io.Opcodes.DIV_INT_LIT8 /* 219 */:
                    classReader2.createLabel(classReader2.readUnsignedShort(i42 + 1) + i43, labelArr5);
                    i42 += 3;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        byte b3 = 8;
        int unsignedShort5 = classReader2.readUnsignedShort(i42);
        int i51 = i42 + 2;
        while (true) {
            int i52 = unsignedShort5 - 1;
            if (unsignedShort5 > 0) {
                Label labelCreateLabel = classReader2.createLabel(classReader2.readUnsignedShort(i51), labelArr5);
                Label labelCreateLabel2 = classReader2.createLabel(classReader2.readUnsignedShort(i51 + 2), labelArr5);
                Label labelCreateLabel3 = classReader2.createLabel(classReader2.readUnsignedShort(i51 + 4), labelArr5);
                String utf84 = classReader2
                        .readUTF8(classReader2.cpInfoOffsets[classReader2.readUnsignedShort(i51 + 6)], cArr2);
                i51 += 8;
                methodVisitor3.visitTryCatchBlock(labelCreateLabel, labelCreateLabel2, labelCreateLabel3, utf84);
                unsignedShort5 = i52;
            } else {
                int unsignedShort6 = classReader2.readUnsignedShort(i51);
                int i53 = i51 + 2;
                int[] iArr8 = null;
                int i54 = 0;
                int[] typeAnnotations2 = null;
                int i55 = 0;
                Attribute attribute2 = null;
                boolean z8 = true;
                int i56 = 0;
                int i57 = 0;
                while (true) {
                    int i58 = unsignedShort6 - 1;
                    if (unsignedShort6 <= 0) {
                        int[] iArr9 = iArr8;
                        byte b4 = b3;
                        boolean z9 = true;
                        ClassReader classReader3 = classReader2;
                        Label[] labelArr6 = labelArr5;
                        Attribute attribute3 = attribute2;
                        boolean z10 = (context.parsingOptions & b4) != 0;
                        if (i54 != 0) {
                            context.currentFrameOffset = -1;
                            context.currentFrameType = 0;
                            context.currentFrameLocalCount = 0;
                            context.currentFrameLocalCountDelta = 0;
                            context.currentFrameLocalTypes = new Object[unsignedShort4];
                            context.currentFrameStackCount = 0;
                            context.currentFrameStackTypes = new Object[unsignedShort3];
                            if (z10) {
                                classReader3.computeImplicitFrame(context);
                            }
                            int i59 = i54;
                            while (true) {
                                i2 = i55;
                                if (i59 < i2 - 2) {
                                    if (bArr2[i59] != b4
                                            || (unsignedShort2 = classReader3.readUnsignedShort(i59 + 1)) < 0
                                            || unsignedShort2 >= i39) {
                                        i37 = i59;
                                        b = b4;
                                    } else {
                                        b = b4;
                                        i37 = i59;
                                        if ((bArr2[i40 + unsignedShort2] & 255) == 187) {
                                            classReader3.createLabel(unsignedShort2, labelArr6);
                                        }
                                    }
                                    i59 = i37 + 1;
                                    i55 = i2;
                                    b4 = b;
                                }
                            }
                        } else {
                            i2 = i55;
                        }
                        if (!z10 || (context.parsingOptions & 256) == 0) {
                            cArr = cArr2;
                            attribute = attribute3;
                            bArr = bArr2;
                            i3 = unsignedShort4;
                            i4 = i39;
                            labelArr = labelArr6;
                            z = z10;
                            i5 = i2;
                            methodVisitor2 = methodVisitor;
                        } else {
                            attribute = attribute3;
                            bArr = bArr2;
                            i5 = i2;
                            z = z10;
                            i4 = i39;
                            cArr = cArr2;
                            i3 = unsignedShort4;
                            labelArr = labelArr6;
                            methodVisitor2 = methodVisitor;
                            methodVisitor2.visitFrame(-1, i3, null, 0, null);
                        }
                        int[] iArr10 = iArr9;
                        int typeAnnotationBytecodeOffset3 = classReader3.getTypeAnnotationBytecodeOffset(iArr10, 0);
                        int[] iArr11 = typeAnnotations2;
                        int typeAnnotationBytecodeOffset4 = classReader3.getTypeAnnotationBytecodeOffset(iArr11, 0);
                        int i60 = (context.parsingOptions & 256) == 0 ? 33 : 0;
                        int i61 = i54;
                        int i62 = typeAnnotationBytecodeOffset3;
                        int stackMapFrame = i61;
                        int i63 = i40;
                        int i64 = typeAnnotationBytecodeOffset4;
                        boolean z11 = false;
                        int i65 = 0;
                        int i66 = 0;
                        while (i63 < i41) {
                            int i67 = i63;
                            int i68 = i67 - i40;
                            classReader3.readBytecodeInstructionOffset(i68);
                            int[] iArr12 = iArr10;
                            Label label2 = labelArr[i68];
                            int i69 = i3;
                            if (label2 != null) {
                                label2.accept(methodVisitor2, (context.parsingOptions & 2) == 0 ? z9 : false);
                            }
                            while (stackMapFrame != 0) {
                                int i70 = context.currentFrameOffset;
                                if (i70 == i68 || i70 == -1) {
                                    if (i70 != -1) {
                                        if (!z8 || z) {
                                            iArr6 = iArr11;
                                            i33 = i40;
                                            z7 = z8;
                                            i34 = i41;
                                            iArr7 = iArr12;
                                            i35 = unsignedShort3;
                                            i36 = stackMapFrame;
                                            methodVisitor.visitFrame(-1, context.currentFrameLocalCount,
                                                    context.currentFrameLocalTypes, context.currentFrameStackCount,
                                                    context.currentFrameStackTypes);
                                        } else {
                                            iArr6 = iArr11;
                                            i33 = i40;
                                            z7 = z8;
                                            i34 = i41;
                                            iArr7 = iArr12;
                                            i35 = unsignedShort3;
                                            i36 = stackMapFrame;
                                            methodVisitor2.visitFrame(context.currentFrameType,
                                                    context.currentFrameLocalCountDelta, context.currentFrameLocalTypes,
                                                    context.currentFrameStackCount, context.currentFrameStackTypes);
                                        }
                                        z11 = false;
                                    } else {
                                        iArr6 = iArr11;
                                        i33 = i40;
                                        z7 = z8;
                                        i34 = i41;
                                        iArr7 = iArr12;
                                        i35 = unsignedShort3;
                                        i36 = stackMapFrame;
                                    }
                                    if (i36 < i5) {
                                        stackMapFrame = classReader3.readStackMapFrame(i36, z7, z, context);
                                        methodVisitor2 = methodVisitor;
                                        unsignedShort3 = i35;
                                        iArr11 = iArr6;
                                    } else {
                                        methodVisitor2 = methodVisitor;
                                        unsignedShort3 = i35;
                                        iArr11 = iArr6;
                                        stackMapFrame = 0;
                                    }
                                    iArr12 = iArr7;
                                    i41 = i34;
                                    z8 = z7;
                                    i40 = i33;
                                } else {
                                    iArr2 = iArr11;
                                    i8 = i40;
                                    z2 = z8;
                                    i9 = i41;
                                    iArr3 = iArr12;
                                    i10 = unsignedShort3;
                                    i11 = stackMapFrame;
                                    if (z11) {
                                        if ((context.parsingOptions & 8) != 0) {
                                            methodVisitor2 = methodVisitor;
                                            methodVisitor2.visitFrame(256, 0, null, 0, null);
                                        } else {
                                            methodVisitor2 = methodVisitor;
                                        }
                                        z3 = false;
                                    } else {
                                        methodVisitor2 = methodVisitor;
                                        z3 = z11;
                                    }
                                    i12 = bArr[i67] & 255;
                                    switch (i12) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                        case 14:
                                        case 15:
                                        case 46:
                                        case 47:
                                        case 48:
                                        case 49:
                                        case 50:
                                        case 51:
                                        case 52:
                                        case 53:
                                        case 79:
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                        case 85:
                                        case 86:
                                        case 87:
                                        case 88:
                                        case 89:
                                        case 90:
                                        case 91:
                                        case 92:
                                        case 93:
                                        case 94:
                                        case 95:
                                        case 96:
                                        case 97:
                                        case 98:
                                        case 99:
                                        case 100:
                                        case 101:
                                        case 102:
                                        case 103:
                                        case 104:
                                        case 105:
                                        case 106:
                                        case 107:
                                        case 108:
                                        case 109:
                                        case 110:
                                        case 111:
                                        case 112:
                                        case 113:
                                        case 114:
                                        case 115:
                                        case 116:
                                        case 117:
                                        case 118:
                                        case 119:
                                        case 120:
                                        case 121:
                                        case 122:
                                        case 123:
                                        case 124:
                                        case 125:
                                        case 126:
                                        case 127:
                                        case 128:
                                        case 129:
                                        case 130:
                                        case 131:
                                        case 133:
                                        case 134:
                                        case 135:
                                        case 136:
                                        case 137:
                                        case 138:
                                        case 139:
                                        case 140:
                                        case 141:
                                        case 142:
                                        case 143:
                                        case 144:
                                        case 145:
                                        case 146:
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        case 151:
                                        case 152:
                                        case 172:
                                        case 173:
                                        case 174:
                                        case 175:
                                        case 176:
                                        case 177:
                                        case 190:
                                        case 191:
                                        case 194:
                                        case 195:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitInsn(i12);
                                            i14 = i67 + 1;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null && i22 < iArr3.length
                                                    && typeAnnotationBytecodeOffset <= i68) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12 = z9;
                                                    classReader3
                                                            .readElementValues(
                                                                    methodVisitor2.visitInsnAnnotation(
                                                                            context.currentTypeAnnotationTarget,
                                                                            context.currentTypeAnnotationTargetPath,
                                                                            classReader3.readUTF8(typeAnnotationTarget,
                                                                                    cArr),
                                                                            z12),
                                                                    typeAnnotationTarget + 2, z12, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length || typeAnnotationBytecodeOffset2 > i68) {
                                                        i26 = i25;
                                                        i27 = typeAnnotationBytecodeOffset;
                                                        i28 = i11;
                                                    } else {
                                                        if (typeAnnotationBytecodeOffset2 == i68) {
                                                            int typeAnnotationTarget2 = classReader3
                                                                    .readTypeAnnotationTarget(context, iArr5[i25]);
                                                            i29 = i25;
                                                            i30 = typeAnnotationBytecodeOffset;
                                                            i31 = i11;
                                                            classReader3.readElementValues(
                                                                    methodVisitor2.visitInsnAnnotation(
                                                                            context.currentTypeAnnotationTarget,
                                                                            context.currentTypeAnnotationTargetPath,
                                                                            classReader3.readUTF8(typeAnnotationTarget2,
                                                                                    cArr),
                                                                            false),
                                                                    typeAnnotationTarget2 + 2, true, cArr);
                                                        } else {
                                                            i29 = i25;
                                                            i30 = typeAnnotationBytecodeOffset;
                                                            i31 = i11;
                                                        }
                                                        i25 = i29 + 1;
                                                        typeAnnotationBytecodeOffset2 = classReader3
                                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                        iArr2 = iArr5;
                                                        typeAnnotationBytecodeOffset = i30;
                                                        i11 = i31;
                                                    }
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 16:
                                        case 188:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitIntInsn(i12, bArr[i67 + 1]);
                                            i14 = i67 + 2;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122 = z9;
                                                    classReader3
                                                            .readElementValues(
                                                                    methodVisitor2.visitInsnAnnotation(
                                                                            context.currentTypeAnnotationTarget,
                                                                            context.currentTypeAnnotationTargetPath,
                                                                            classReader3.readUTF8(typeAnnotationTarget3,
                                                                                    cArr),
                                                                            z122),
                                                                    typeAnnotationTarget3 + 2, z122, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 17:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitIntInsn(i12, classReader3.readShort(i67 + 1));
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222 = z9;
                                                    classReader3
                                                            .readElementValues(
                                                                    methodVisitor2.visitInsnAnnotation(
                                                                            context.currentTypeAnnotationTarget,
                                                                            context.currentTypeAnnotationTargetPath,
                                                                            classReader3.readUTF8(
                                                                                    typeAnnotationTarget32, cArr),
                                                                            z1222),
                                                                    typeAnnotationTarget32 + 2, z1222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 18:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2
                                                    .visitLdcInsn(classReader3.readConst(bArr[i67 + 1] & 255, cArr));
                                            i14 = i67 + 2;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget322,
                                                                            cArr),
                                                                    z12222),
                                                            typeAnnotationTarget322 + 2, z12222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 19:
                                        case 20:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitLdcInsn(classReader3
                                                    .readConst(classReader3.readUnsignedShort(i67 + 1), cArr));
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget3222,
                                                                            cArr),
                                                                    z122222),
                                                            typeAnnotationTarget3222 + 2, z122222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 21:
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                        case 54:
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                        case 169:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitVarInsn(i12, bArr[i67 + 1] & 255);
                                            i14 = i67 + 2;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget32222,
                                                                            cArr),
                                                                    z1222222),
                                                            typeAnnotationTarget32222 + 2, z1222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                        case 40:
                                        case 41:
                                        case 42:
                                        case 43:
                                        case 44:
                                        case 45:
                                            i13 = i5;
                                            z4 = z;
                                            int i72 = i12 - 26;
                                            methodVisitor2.visitVarInsn((i72 >> 2) + 21, i72 & 3);
                                            i14 = i67 + 1;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget322222,
                                                                            cArr),
                                                                    z12222222),
                                                            typeAnnotationTarget322222 + 2, z12222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 59:
                                        case 60:
                                        case 61:
                                        case 62:
                                        case 63:
                                        case 64:
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                        case 77:
                                        case 78:
                                            i13 = i5;
                                            z4 = z;
                                            int i73 = i12 - 59;
                                            methodVisitor2.visitVarInsn((i73 >> 2) + 54, i73 & 3);
                                            i14 = i67 + 1;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget3222222,
                                                                            cArr),
                                                                    z122222222),
                                                            typeAnnotationTarget3222222 + 2, z122222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 132:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitIincInsn(bArr[i67 + 1] & 255, bArr[i67 + 2]);
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget32222222,
                                                                            cArr),
                                                                    z1222222222),
                                                            typeAnnotationTarget32222222 + 2, z1222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                        case 160:
                                        case 161:
                                        case 162:
                                        case 163:
                                        case 164:
                                        case 165:
                                        case 166:
                                        case 167:
                                        case 168:
                                        case 198:
                                        case 199:
                                            i13 = i5;
                                            z4 = z;
                                            methodVisitor2.visitJumpInsn(i12,
                                                    labelArr[classReader3.readShort(i67 + 1) + i68]);
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(typeAnnotationTarget322222222,
                                                                            cArr),
                                                                    z12222222222),
                                                            typeAnnotationTarget322222222 + 2, z12222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 170:
                                            i13 = i5;
                                            z4 = z;
                                            int i74 = (4 - (i68 & 3)) + i67;
                                            Label label3 = labelArr[classReader3.readInt(i74) + i68];
                                            int i75 = classReader3.readInt(i74 + 4);
                                            int i76 = classReader3.readInt(i74 + 8);
                                            i14 = i74 + 12;
                                            i15 = (i76 - i75) + 1;
                                            labelArr2 = new Label[i15];
                                            for (i16 = 0; i16 < i15; i16++) {
                                                labelArr2[i16] = labelArr[classReader3.readInt(i14) + i68];
                                                i14 += 4;
                                            }
                                            methodVisitor2.visitTableSwitchInsn(i75, i76, label3, labelArr2);
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget3222222222, cArr),
                                                                    z122222222222),
                                                            typeAnnotationTarget3222222222 + 2, z122222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 171:
                                            i13 = i5;
                                            z4 = z;
                                            int i77 = (4 - (i68 & 3)) + i67;
                                            Label label4 = labelArr[classReader3.readInt(i77) + i68];
                                            i17 = classReader3.readInt(i77 + 4);
                                            i14 = i77 + 8;
                                            iArr4 = new int[i17];
                                            labelArr3 = new Label[i17];
                                            for (i18 = 0; i18 < i17; i18++) {
                                                iArr4[i18] = classReader3.readInt(i14);
                                                labelArr3[i18] = labelArr[classReader3.readInt(i14 + 4) + i68];
                                                i14 += 8;
                                            }
                                            methodVisitor2.visitLookupSwitchInsn(label4, iArr4, labelArr3);
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget32222222222, cArr),
                                                                    z1222222222222),
                                                            typeAnnotationTarget32222222222 + 2, z1222222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 178:
                                        case 179:
                                        case 180:
                                        case 181:
                                        case 182:
                                        case 183:
                                        case 184:
                                        case 185:
                                            i13 = i5;
                                            z4 = z;
                                            i19 = classReader3.cpInfoOffsets[classReader3.readUnsignedShort(i67 + 1)];
                                            int i78 = classReader3.cpInfoOffsets[classReader3
                                                    .readUnsignedShort(i19 + 2)];
                                            str = classReader3.readClass(i19, cArr);
                                            utf82 = classReader3.readUTF8(i78, cArr);
                                            utf83 = classReader3.readUTF8(i78 + 2, cArr);
                                            if (i12 < 182) {
                                                methodVisitor2.visitFieldInsn(i12, str, utf82, utf83);
                                            } else {
                                                if (bArr[i19 - 1] == 11) {
                                                    str2 = utf83;
                                                    z5 = z9;
                                                } else {
                                                    str2 = utf83;
                                                    z5 = false;
                                                }
                                                methodVisitor2.visitMethodInsn(i12, str, utf82, str2, z5);
                                            }
                                            i14 = i12 == 185 ? i67 + 5 : i67 + 3;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget322222222222, cArr),
                                                                    z12222222222222),
                                                            typeAnnotationTarget322222222222 + 2, z12222222222222,
                                                            cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 186:
                                            int i79 = classReader3.cpInfoOffsets[classReader3
                                                    .readUnsignedShort(i67 + 1)];
                                            int i80 = classReader3.cpInfoOffsets[classReader3
                                                    .readUnsignedShort(i79 + 2)];
                                            String utf85 = classReader3.readUTF8(i80, cArr);
                                            String utf86 = classReader3.readUTF8(i80 + 2, cArr);
                                            int i81 = classReader3.bootstrapMethodOffsets[classReader3
                                                    .readUnsignedShort(i79)];
                                            Handle handle = (Handle) classReader3
                                                    .readConst(classReader3.readUnsignedShort(i81), cArr);
                                            unsignedShort = classReader3.readUnsignedShort(i81 + 2);
                                            objArr = new Object[unsignedShort];
                                            z4 = z;
                                            i20 = i81 + 4;
                                            i13 = i5;
                                            i21 = 0;
                                            while (i21 < unsignedShort) {
                                                objArr[i21] = classReader3
                                                        .readConst(classReader3.readUnsignedShort(i20), cArr);
                                                i20 += 2;
                                                i21++;
                                                unsignedShort = unsignedShort;
                                            }
                                            methodVisitor2.visitInvokeDynamicInsn(utf85, utf86, handle, objArr);
                                            i14 = i67 + 5;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget3222222222222, cArr),
                                                                    z122222222222222),
                                                            typeAnnotationTarget3222222222222 + 2, z122222222222222,
                                                            cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 187:
                                        case 189:
                                        case 192:
                                        case 193:
                                            c = 132;
                                            methodVisitor2.visitTypeInsn(i12, classReader3.readClass(i67 + 1, cArr));
                                            i14 = i67 + 3;
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget32222222222222, cArr),
                                                                    z1222222222222222),
                                                            typeAnnotationTarget32222222222222 + 2, z1222222222222222,
                                                            cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 196:
                                            i23 = bArr[i67 + 1] & 255;
                                            c = 132;
                                            if (i23 == 132) {
                                                methodVisitor2.visitIincInsn(classReader3.readUnsignedShort(i67 + 2),
                                                        classReader3.readShort(i67 + 4));
                                                i14 = i67 + 6;
                                            } else {
                                                methodVisitor2.visitVarInsn(i23,
                                                        classReader3.readUnsignedShort(i67 + 2));
                                                i14 = i67 + 4;
                                            }
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget322222222222222, cArr),
                                                                    z12222222222222222),
                                                            typeAnnotationTarget322222222222222 + 2, z12222222222222222,
                                                            cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 197:
                                            methodVisitor2.visitMultiANewArrayInsn(
                                                    classReader3.readClass(i67 + 1, cArr), bArr[i67 + 3] & 255);
                                            i14 = i67 + 4;
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget3222222222222222, cArr),
                                                                    z122222222222222222),
                                                            typeAnnotationTarget3222222222222222 + 2,
                                                            z122222222222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 200:
                                        case 201:
                                            methodVisitor2.visitJumpInsn(i12 - i60,
                                                    labelArr[classReader3.readInt(i67 + 1) + i68]);
                                            i14 = i67 + 5;
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            z11 = z3;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget32222222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z1222222222222222222 = z9;
                                                    classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(typeAnnotationTarget32222222222222222,
                                                                    cArr),
                                                            z1222222222222222222),
                                                            typeAnnotationTarget32222222222222222 + 2,
                                                            z1222222222222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i7122222222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i7122222222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case 202:
                                        case 203:
                                        case 204:
                                        case com.android.dx.io.Opcodes.MUL_DOUBLE_2ADDR /* 205 */:
                                        case com.android.dx.io.Opcodes.DIV_DOUBLE_2ADDR /* 206 */:
                                        case com.android.dx.io.Opcodes.REM_DOUBLE_2ADDR /* 207 */:
                                        case com.android.dx.io.Opcodes.ADD_INT_LIT16 /* 208 */:
                                        case com.android.dx.io.Opcodes.RSUB_INT /* 209 */:
                                        case com.android.dx.io.Opcodes.MUL_INT_LIT16 /* 210 */:
                                        case com.android.dx.io.Opcodes.DIV_INT_LIT16 /* 211 */:
                                        case com.android.dx.io.Opcodes.REM_INT_LIT16 /* 212 */:
                                        case com.android.dx.io.Opcodes.AND_INT_LIT16 /* 213 */:
                                        case com.android.dx.io.Opcodes.OR_INT_LIT16 /* 214 */:
                                        case com.android.dx.io.Opcodes.XOR_INT_LIT16 /* 215 */:
                                        case com.android.dx.io.Opcodes.ADD_INT_LIT8 /* 216 */:
                                        case com.android.dx.io.Opcodes.RSUB_INT_LIT8 /* 217 */:
                                        case com.android.dx.io.Opcodes.MUL_INT_LIT8 /* 218 */:
                                        case com.android.dx.io.Opcodes.DIV_INT_LIT8 /* 219 */:
                                            i24 = i12 < 218 ? i12 - 49 : i12 - 20;
                                            label = labelArr[classReader3.readUnsignedShort(i67 + 1) + i68];
                                            if (i24 != 167 || i24 == 168) {
                                                methodVisitor2.visitJumpInsn(i24 + 33, label);
                                                z6 = z3;
                                            } else {
                                                methodVisitor2.visitJumpInsn(i24 < 167 ? ((i24 + 1) ^ 1) - 1 : i24 ^ 1,
                                                        classReader3.createLabel(i68 + 3, labelArr));
                                                methodVisitor2.visitJumpInsn(200, label);
                                                z6 = z9;
                                            }
                                            i14 = i67 + 3;
                                            z11 = z6;
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            i22 = i65;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget322222222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z12222222222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget322222222222222222,
                                                                            cArr),
                                                                    z12222222222222222222),
                                                            typeAnnotationTarget322222222222222222 + 2,
                                                            z12222222222222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i71222222222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i71222222222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        case com.android.dx.io.Opcodes.REM_INT_LIT8 /* 220 */:
                                            methodVisitor2.visitJumpInsn(200,
                                                    labelArr[classReader3.readInt(i67 + 1) + i68]);
                                            i14 = i67 + 5;
                                            i13 = i5;
                                            z4 = z;
                                            typeAnnotationBytecodeOffset = i62;
                                            z11 = z9;
                                            i22 = i65;
                                            while (iArr3 != null) {
                                                if (typeAnnotationBytecodeOffset == i68) {
                                                    int typeAnnotationTarget3222222222222222222 = classReader3
                                                            .readTypeAnnotationTarget(context, iArr3[i22]);
                                                    i32 = i14;
                                                    boolean z122222222222222222222 = z9;
                                                    classReader3.readElementValues(
                                                            methodVisitor2.visitInsnAnnotation(
                                                                    context.currentTypeAnnotationTarget,
                                                                    context.currentTypeAnnotationTargetPath,
                                                                    classReader3.readUTF8(
                                                                            typeAnnotationTarget3222222222222222222,
                                                                            cArr),
                                                                    z122222222222222222222),
                                                            typeAnnotationTarget3222222222222222222 + 2,
                                                            z122222222222222222222, cArr);
                                                } else {
                                                    i32 = i14;
                                                }
                                                i22++;
                                                typeAnnotationBytecodeOffset = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                                i14 = i32;
                                                z9 = true;
                                            }
                                            int i712222222222222222222 = i14;
                                            i25 = i66;
                                            typeAnnotationBytecodeOffset2 = i64;
                                            while (true) {
                                                if (iArr2 != null) {
                                                    iArr5 = iArr2;
                                                    if (i25 < iArr5.length) {
                                                    }
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                } else {
                                                    i26 = i25;
                                                    i27 = typeAnnotationBytecodeOffset;
                                                    i28 = i11;
                                                    iArr5 = iArr2;
                                                }
                                                i25 = i29 + 1;
                                                typeAnnotationBytecodeOffset2 = classReader3
                                                        .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                                iArr2 = iArr5;
                                                typeAnnotationBytecodeOffset = i30;
                                                i11 = i31;
                                            }
                                            i5 = i13;
                                            i64 = typeAnnotationBytecodeOffset2;
                                            iArr11 = iArr5;
                                            iArr10 = iArr3;
                                            i63 = i712222222222222222222;
                                            i41 = i9;
                                            i62 = i27;
                                            unsignedShort3 = i10;
                                            i3 = i69;
                                            z = z4;
                                            z9 = true;
                                            z8 = z2;
                                            i66 = i26;
                                            i40 = i8;
                                            i65 = i22;
                                            stackMapFrame = i28;
                                            break;
                                        default:
                                            throw new AssertionError();
                                    }
                                }
                            }
                            iArr2 = iArr11;
                            i8 = i40;
                            z2 = z8;
                            i9 = i41;
                            iArr3 = iArr12;
                            i10 = unsignedShort3;
                            i11 = stackMapFrame;
                            if (z11) {
                                if ((context.parsingOptions & 8) != 0) {
                                    methodVisitor2 = methodVisitor;
                                    methodVisitor2.visitFrame(256, 0, null, 0, null);
                                } else {
                                    methodVisitor2 = methodVisitor;
                                }
                                z3 = false;
                            } else {
                                methodVisitor2 = methodVisitor;
                                z3 = z11;
                            }
                            i12 = bArr[i67] & 255;
                            switch (i12) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 123:
                                case 124:
                                case 125:
                                case 126:
                                case 127:
                                case 128:
                                case 129:
                                case 130:
                                case 131:
                                case 133:
                                case 134:
                                case 135:
                                case 136:
                                case 137:
                                case 138:
                                case 139:
                                case 140:
                                case 141:
                                case 142:
                                case 143:
                                case 144:
                                case 145:
                                case 146:
                                case 147:
                                case 148:
                                case 149:
                                case 150:
                                case 151:
                                case 152:
                                case 172:
                                case 173:
                                case 174:
                                case 175:
                                case 176:
                                case 177:
                                case 190:
                                case 191:
                                case 194:
                                case 195:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitInsn(i12);
                                    i14 = i67 + 1;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget32222222222222222222, cArr),
                                                            z1222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222 + 2,
                                                    z1222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 16:
                                case 188:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitIntInsn(i12, bArr[i67 + 1]);
                                    i14 = i67 + 2;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget322222222222222222222, cArr),
                                                            z12222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222 + 2,
                                                    z12222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 17:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitIntInsn(i12, classReader3.readShort(i67 + 1));
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget3222222222222222222222, cArr),
                                                            z122222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222 + 2,
                                                    z122222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 18:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitLdcInsn(classReader3.readConst(bArr[i67 + 1] & 255, cArr));
                                    i14 = i67 + 2;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget32222222222222222222222, cArr),
                                                            z1222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222 + 2,
                                                    z1222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 19:
                                case 20:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitLdcInsn(
                                            classReader3.readConst(classReader3.readUnsignedShort(i67 + 1), cArr));
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget322222222222222222222222, cArr),
                                                            z12222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222 + 2,
                                                    z12222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case 169:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitVarInsn(i12, bArr[i67 + 1] & 255);
                                    i14 = i67 + 2;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(typeAnnotationTarget3222222222222222222222222,
                                                            cArr),
                                                    z122222222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222222 + 2,
                                                    z122222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    i13 = i5;
                                    z4 = z;
                                    int i722 = i12 - 26;
                                    methodVisitor2.visitVarInsn((i722 >> 2) + 21, i722 & 3);
                                    i14 = i67 + 1;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget32222222222222222222222222,
                                                                    cArr),
                                                            z1222222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222222 + 2,
                                                    z1222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                    i13 = i5;
                                    z4 = z;
                                    int i732 = i12 - 59;
                                    methodVisitor2.visitVarInsn((i732 >> 2) + 54, i732 & 3);
                                    i14 = i67 + 1;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget322222222222222222222222222,
                                                                    cArr),
                                                            z12222222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222222 + 2,
                                                    z12222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 132:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitIincInsn(bArr[i67 + 1] & 255, bArr[i67 + 2]);
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget3222222222222222222222222222,
                                                                    cArr),
                                                            z122222222222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222222222 + 2,
                                                    z122222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 153:
                                case 154:
                                case 155:
                                case 156:
                                case 157:
                                case 158:
                                case 159:
                                case 160:
                                case 161:
                                case 162:
                                case 163:
                                case 164:
                                case 165:
                                case 166:
                                case 167:
                                case 168:
                                case 198:
                                case 199:
                                    i13 = i5;
                                    z4 = z;
                                    methodVisitor2.visitJumpInsn(i12, labelArr[classReader3.readShort(i67 + 1) + i68]);
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget32222222222222222222222222222,
                                                                    cArr),
                                                            z1222222222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222222222 + 2,
                                                    z1222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 170:
                                    i13 = i5;
                                    z4 = z;
                                    int i742 = (4 - (i68 & 3)) + i67;
                                    Label label32 = labelArr[classReader3.readInt(i742) + i68];
                                    int i752 = classReader3.readInt(i742 + 4);
                                    int i762 = classReader3.readInt(i742 + 8);
                                    i14 = i742 + 12;
                                    i15 = (i762 - i752) + 1;
                                    labelArr2 = new Label[i15];
                                    while (i16 < i15) {
                                        labelArr2[i16] = labelArr[classReader3.readInt(i14) + i68];
                                        i14 += 4;
                                    }
                                    methodVisitor2.visitTableSwitchInsn(i752, i762, label32, labelArr2);
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget322222222222222222222222222222,
                                                                    cArr),
                                                            z12222222222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222222222 + 2,
                                                    z12222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 171:
                                    i13 = i5;
                                    z4 = z;
                                    int i772 = (4 - (i68 & 3)) + i67;
                                    Label label42 = labelArr[classReader3.readInt(i772) + i68];
                                    i17 = classReader3.readInt(i772 + 4);
                                    i14 = i772 + 8;
                                    iArr4 = new int[i17];
                                    labelArr3 = new Label[i17];
                                    while (i18 < i17) {
                                        iArr4[i18] = classReader3.readInt(i14);
                                        labelArr3[i18] = labelArr[classReader3.readInt(i14 + 4) + i68];
                                        i14 += 8;
                                    }
                                    methodVisitor2.visitLookupSwitchInsn(label42, iArr4, labelArr3);
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(
                                                    methodVisitor2.visitInsnAnnotation(
                                                            context.currentTypeAnnotationTarget,
                                                            context.currentTypeAnnotationTargetPath,
                                                            classReader3.readUTF8(
                                                                    typeAnnotationTarget3222222222222222222222222222222,
                                                                    cArr),
                                                            z122222222222222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222222222222 + 2,
                                                    z122222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 178:
                                case 179:
                                case 180:
                                case 181:
                                case 182:
                                case 183:
                                case 184:
                                case 185:
                                    i13 = i5;
                                    z4 = z;
                                    i19 = classReader3.cpInfoOffsets[classReader3.readUnsignedShort(i67 + 1)];
                                    int i782 = classReader3.cpInfoOffsets[classReader3.readUnsignedShort(i19 + 2)];
                                    str = classReader3.readClass(i19, cArr);
                                    utf82 = classReader3.readUTF8(i782, cArr);
                                    utf83 = classReader3.readUTF8(i782 + 2, cArr);
                                    if (i12 < 182) {
                                        methodVisitor2.visitFieldInsn(i12, str, utf82, utf83);
                                    } else {
                                        if (bArr[i19 - 1] == 11) {
                                            str2 = utf83;
                                            z5 = z9;
                                        } else {
                                            str2 = utf83;
                                            z5 = false;
                                        }
                                        methodVisitor2.visitMethodInsn(i12, str, utf82, str2, z5);
                                    }
                                    if (i12 == 185) {
                                    }
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget32222222222222222222222222222222, cArr),
                                                    z1222222222222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222222222222 + 2,
                                                    z1222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 186:
                                    int i792 = classReader3.cpInfoOffsets[classReader3.readUnsignedShort(i67 + 1)];
                                    int i802 = classReader3.cpInfoOffsets[classReader3.readUnsignedShort(i792 + 2)];
                                    String utf852 = classReader3.readUTF8(i802, cArr);
                                    String utf862 = classReader3.readUTF8(i802 + 2, cArr);
                                    int i812 = classReader3.bootstrapMethodOffsets[classReader3
                                            .readUnsignedShort(i792)];
                                    Handle handle2 = (Handle) classReader3
                                            .readConst(classReader3.readUnsignedShort(i812), cArr);
                                    unsignedShort = classReader3.readUnsignedShort(i812 + 2);
                                    objArr = new Object[unsignedShort];
                                    z4 = z;
                                    i20 = i812 + 4;
                                    i13 = i5;
                                    i21 = 0;
                                    while (i21 < unsignedShort) {
                                        objArr[i21] = classReader3.readConst(classReader3.readUnsignedShort(i20), cArr);
                                        i20 += 2;
                                        i21++;
                                        unsignedShort = unsignedShort;
                                    }
                                    methodVisitor2.visitInvokeDynamicInsn(utf852, utf862, handle2, objArr);
                                    i14 = i67 + 5;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget322222222222222222222222222222222,
                                                            cArr),
                                                    z12222222222222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222222222222 + 2,
                                                    z12222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 187:
                                case 189:
                                case 192:
                                case 193:
                                    c = 132;
                                    methodVisitor2.visitTypeInsn(i12, classReader3.readClass(i67 + 1, cArr));
                                    i14 = i67 + 3;
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget3222222222222222222222222222222222,
                                                            cArr),
                                                    z122222222222222222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222222222222222 + 2,
                                                    z122222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 196:
                                    i23 = bArr[i67 + 1] & 255;
                                    c = 132;
                                    if (i23 == 132) {
                                        methodVisitor2.visitIincInsn(classReader3.readUnsignedShort(i67 + 2),
                                                classReader3.readShort(i67 + 4));
                                        i14 = i67 + 6;
                                    } else {
                                        methodVisitor2.visitVarInsn(i23, classReader3.readUnsignedShort(i67 + 2));
                                        i14 = i67 + 4;
                                    }
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget32222222222222222222222222222222222,
                                                            cArr),
                                                    z1222222222222222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222222222222222 + 2,
                                                    z1222222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 197:
                                    methodVisitor2.visitMultiANewArrayInsn(classReader3.readClass(i67 + 1, cArr),
                                            bArr[i67 + 3] & 255);
                                    i14 = i67 + 4;
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget322222222222222222222222222222222222,
                                                            cArr),
                                                    z12222222222222222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222222222222222 + 2,
                                                    z12222222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 200:
                                case 201:
                                    methodVisitor2.visitJumpInsn(i12 - i60,
                                            labelArr[classReader3.readInt(i67 + 1) + i68]);
                                    i14 = i67 + 5;
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    z11 = z3;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget3222222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z122222222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget3222222222222222222222222222222222222,
                                                            cArr),
                                                    z122222222222222222222222222222222222222),
                                                    typeAnnotationTarget3222222222222222222222222222222222222 + 2,
                                                    z122222222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i712222222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i712222222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case 202:
                                case 203:
                                case 204:
                                case com.android.dx.io.Opcodes.MUL_DOUBLE_2ADDR /* 205 */:
                                case com.android.dx.io.Opcodes.DIV_DOUBLE_2ADDR /* 206 */:
                                case com.android.dx.io.Opcodes.REM_DOUBLE_2ADDR /* 207 */:
                                case com.android.dx.io.Opcodes.ADD_INT_LIT16 /* 208 */:
                                case com.android.dx.io.Opcodes.RSUB_INT /* 209 */:
                                case com.android.dx.io.Opcodes.MUL_INT_LIT16 /* 210 */:
                                case com.android.dx.io.Opcodes.DIV_INT_LIT16 /* 211 */:
                                case com.android.dx.io.Opcodes.REM_INT_LIT16 /* 212 */:
                                case com.android.dx.io.Opcodes.AND_INT_LIT16 /* 213 */:
                                case com.android.dx.io.Opcodes.OR_INT_LIT16 /* 214 */:
                                case com.android.dx.io.Opcodes.XOR_INT_LIT16 /* 215 */:
                                case com.android.dx.io.Opcodes.ADD_INT_LIT8 /* 216 */:
                                case com.android.dx.io.Opcodes.RSUB_INT_LIT8 /* 217 */:
                                case com.android.dx.io.Opcodes.MUL_INT_LIT8 /* 218 */:
                                case com.android.dx.io.Opcodes.DIV_INT_LIT8 /* 219 */:
                                    if (i12 < 218) {
                                    }
                                    label = labelArr[classReader3.readUnsignedShort(i67 + 1) + i68];
                                    if (i24 != 167) {
                                        methodVisitor2.visitJumpInsn(i24 + 33, label);
                                        z6 = z3;
                                    } else {
                                        methodVisitor2.visitJumpInsn(i24 + 33, label);
                                        z6 = z3;
                                    }
                                    i14 = i67 + 3;
                                    z11 = z6;
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    i22 = i65;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget32222222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z1222222222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget32222222222222222222222222222222222222,
                                                            cArr),
                                                    z1222222222222222222222222222222222222222),
                                                    typeAnnotationTarget32222222222222222222222222222222222222 + 2,
                                                    z1222222222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i7122222222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i7122222222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                case com.android.dx.io.Opcodes.REM_INT_LIT8 /* 220 */:
                                    methodVisitor2.visitJumpInsn(200, labelArr[classReader3.readInt(i67 + 1) + i68]);
                                    i14 = i67 + 5;
                                    i13 = i5;
                                    z4 = z;
                                    typeAnnotationBytecodeOffset = i62;
                                    z11 = z9;
                                    i22 = i65;
                                    while (iArr3 != null) {
                                        if (typeAnnotationBytecodeOffset == i68) {
                                            int typeAnnotationTarget322222222222222222222222222222222222222 = classReader3
                                                    .readTypeAnnotationTarget(context, iArr3[i22]);
                                            i32 = i14;
                                            boolean z12222222222222222222222222222222222222222 = z9;
                                            classReader3.readElementValues(methodVisitor2.visitInsnAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    classReader3.readUTF8(
                                                            typeAnnotationTarget322222222222222222222222222222222222222,
                                                            cArr),
                                                    z12222222222222222222222222222222222222222),
                                                    typeAnnotationTarget322222222222222222222222222222222222222 + 2,
                                                    z12222222222222222222222222222222222222222, cArr);
                                        } else {
                                            i32 = i14;
                                        }
                                        i22++;
                                        typeAnnotationBytecodeOffset = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr3, i22);
                                        i14 = i32;
                                        z9 = true;
                                    }
                                    int i71222222222222222222222222222222222222222 = i14;
                                    i25 = i66;
                                    typeAnnotationBytecodeOffset2 = i64;
                                    while (true) {
                                        if (iArr2 != null) {
                                            iArr5 = iArr2;
                                            if (i25 < iArr5.length) {
                                            }
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                        } else {
                                            i26 = i25;
                                            i27 = typeAnnotationBytecodeOffset;
                                            i28 = i11;
                                            iArr5 = iArr2;
                                        }
                                        i25 = i29 + 1;
                                        typeAnnotationBytecodeOffset2 = classReader3
                                                .getTypeAnnotationBytecodeOffset(iArr5, i25);
                                        iArr2 = iArr5;
                                        typeAnnotationBytecodeOffset = i30;
                                        i11 = i31;
                                    }
                                    i5 = i13;
                                    i64 = typeAnnotationBytecodeOffset2;
                                    iArr11 = iArr5;
                                    iArr10 = iArr3;
                                    i63 = i71222222222222222222222222222222222222222;
                                    i41 = i9;
                                    i62 = i27;
                                    unsignedShort3 = i10;
                                    i3 = i69;
                                    z = z4;
                                    z9 = true;
                                    z8 = z2;
                                    i66 = i26;
                                    i40 = i8;
                                    i65 = i22;
                                    stackMapFrame = i28;
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        }
                        int[] iArr13 = iArr10;
                        int i82 = i3;
                        int[] iArr14 = iArr11;
                        int i83 = unsignedShort3;
                        int i84 = 0;
                        Label label5 = labelArr[i4];
                        if (label5 != null) {
                            methodVisitor2.visitLabel(label5);
                        }
                        int i85 = i56;
                        if (i85 != 0 && (context.parsingOptions & 2) == 0) {
                            int i86 = i57;
                            if (i86 != 0) {
                                int unsignedShort7 = classReader3.readUnsignedShort(i86) * 3;
                                int[] iArr15 = new int[unsignedShort7];
                                int i87 = i86 + 2;
                                while (unsignedShort7 > 0) {
                                    iArr15[unsignedShort7 - 1] = i87 + 6;
                                    iArr15[unsignedShort7 - 2] = classReader3.readUnsignedShort(i87 + 8);
                                    unsignedShort7 -= 3;
                                    iArr15[unsignedShort7] = classReader3.readUnsignedShort(i87);
                                    i87 += 10;
                                }
                                iArr = iArr15;
                            } else {
                                iArr = null;
                            }
                            int unsignedShort8 = classReader3.readUnsignedShort(i85);
                            int i88 = i85 + 2;
                            while (true) {
                                int i89 = unsignedShort8 - 1;
                                if (unsignedShort8 > 0) {
                                    int unsignedShort9 = classReader3.readUnsignedShort(i88);
                                    int unsignedShort10 = classReader3.readUnsignedShort(i88 + 2);
                                    String utf87 = classReader3.readUTF8(i88 + 4, cArr);
                                    String utf88 = classReader3.readUTF8(i88 + 6, cArr);
                                    int unsignedShort11 = classReader3.readUnsignedShort(i88 + 8);
                                    int i90 = i88 + 10;
                                    if (iArr != null) {
                                        int i91 = i84;
                                        while (true) {
                                            if (i91 >= iArr.length) {
                                                i7 = unsignedShort10;
                                                utf8 = null;
                                            } else if (iArr[i91] == unsignedShort9
                                                    && iArr[i91 + 1] == unsignedShort11) {
                                                utf8 = classReader3.readUTF8(iArr[i91 + 2], cArr);
                                                i7 = unsignedShort10;
                                            } else {
                                                i91 += 3;
                                            }
                                        }
                                    } else {
                                        i7 = unsignedShort10;
                                        utf8 = null;
                                    }
                                    methodVisitor2.visitLocalVariable(utf87, utf88, utf8, labelArr[unsignedShort9],
                                            labelArr[i7 + unsignedShort9], unsignedShort11);
                                    methodVisitor2 = methodVisitor;
                                    classReader3 = classReader3;
                                    unsignedShort8 = i89;
                                    i88 = i90;
                                    i84 = 0;
                                }
                            }
                        }
                        ClassReader classReader4 = classReader3;
                        int i92 = 65;
                        int i93 = 64;
                        if (iArr13 != null) {
                            int length = iArr13.length;
                            int i94 = 0;
                            while (i94 < length) {
                                int i95 = iArr13[i94];
                                int i96 = classReader4.readByte(i95);
                                if (i96 == 64 || i96 == i92) {
                                    int typeAnnotationTarget4 = classReader4.readTypeAnnotationTarget(context, i95);
                                    i6 = i94;
                                    classReader4.readElementValues(
                                            methodVisitor.visitLocalVariableAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    context.currentLocalVariableAnnotationRangeStarts,
                                                    context.currentLocalVariableAnnotationRangeEnds,
                                                    context.currentLocalVariableAnnotationRangeIndices,
                                                    classReader4.readUTF8(typeAnnotationTarget4, cArr), true),
                                            typeAnnotationTarget4 + 2, true, cArr);
                                } else {
                                    i6 = i94;
                                }
                                i94 = i6 + 1;
                                i92 = 65;
                            }
                        }
                        if (iArr14 != null) {
                            int length2 = iArr14.length;
                            int i97 = 0;
                            while (i97 < length2) {
                                int i98 = iArr14[i97];
                                int i99 = classReader4.readByte(i98);
                                if (i99 == i93 || i99 == 65) {
                                    int typeAnnotationTarget5 = classReader4.readTypeAnnotationTarget(context, i98);
                                    classReader4.readElementValues(
                                            methodVisitor.visitLocalVariableAnnotation(
                                                    context.currentTypeAnnotationTarget,
                                                    context.currentTypeAnnotationTargetPath,
                                                    context.currentLocalVariableAnnotationRangeStarts,
                                                    context.currentLocalVariableAnnotationRangeEnds,
                                                    context.currentLocalVariableAnnotationRangeIndices,
                                                    classReader4.readUTF8(typeAnnotationTarget5, cArr), false),
                                            typeAnnotationTarget5 + 2, true, cArr);
                                }
                                i97++;
                                i93 = 64;
                            }
                        }
                        Attribute attribute4 = attribute;
                        while (attribute4 != null) {
                            Attribute attribute5 = attribute4.nextAttribute;
                            attribute4.nextAttribute = null;
                            methodVisitor.visitAttribute(attribute4);
                            attribute4 = attribute5;
                        }
                        methodVisitor.visitMaxs(i83, i82);
                        return;
                    }
                    String utf89 = classReader2.readUTF8(i53, cArr2);
                    int i100 = classReader2.readInt(i53 + 2);
                    int i101 = i53 + 6;
                    if (AttLocalVariableTable.ATTRIBUTE_NAME.equals(utf89)) {
                        if ((context.parsingOptions & 2) == 0) {
                            int unsignedShort12 = classReader2.readUnsignedShort(i101);
                            int i102 = i53 + 8;
                            while (true) {
                                int i103 = unsignedShort12 - 1;
                                if (unsignedShort12 > 0) {
                                    int unsignedShort13 = classReader2.readUnsignedShort(i102);
                                    classReader2.createDebugLabel(unsignedShort13, labelArr5);
                                    int i104 = i102;
                                    classReader2.createDebugLabel(
                                            classReader2.readUnsignedShort(i104 + 2) + unsignedShort13, labelArr5);
                                    i102 = i104 + 10;
                                    unsignedShort12 = i103;
                                } else {
                                    i56 = i101;
                                }
                            }
                        }
                    } else if (AttLocalVariableTypeTable.ATTRIBUTE_NAME.equals(utf89)) {
                        i57 = i101;
                    } else if (!AttLineNumberTable.ATTRIBUTE_NAME.equals(utf89)) {
                        if ("RuntimeVisibleTypeAnnotations".equals(utf89)) {
                            classReader = classReader2;
                            typeAnnotations = classReader2.readTypeAnnotations(methodVisitor3, context, i101, true);
                            labelArr4 = labelArr5;
                            b2 = b3;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(utf89)) {
                            typeAnnotations2 = classReader2.readTypeAnnotations(methodVisitor3, context, i101, false);
                        } else if ("StackMapTable".equals(utf89)) {
                            if ((context.parsingOptions & 4) == 0) {
                                i54 = i53 + 8;
                                i55 = i101 + i100;
                            }
                        } else if ("StackMap".equals(utf89)) {
                            if ((context.parsingOptions & 4) == 0) {
                                i54 = i53 + 8;
                                i55 = i101 + i100;
                                typeAnnotations = iArr8;
                                b2 = b3;
                                z8 = false;
                            }
                            classReader = classReader2;
                            labelArr4 = labelArr5;
                        } else {
                            typeAnnotations = iArr8;
                            b2 = b3;
                            Attribute attribute6 = classReader2.readAttribute(context.attributePrototypes, utf89, i101,
                                    i100, cArr2, i, labelArr5);
                            classReader = classReader2;
                            labelArr4 = labelArr5;
                            attribute6.nextAttribute = attribute2;
                            attribute2 = attribute6;
                        }
                        i53 = i101 + i100;
                        labelArr5 = labelArr4;
                        classReader2 = classReader;
                        b3 = b2;
                        unsignedShort6 = i58;
                        iArr8 = typeAnnotations;
                        methodVisitor3 = methodVisitor;
                    } else if ((context.parsingOptions & 2) == 0) {
                        int unsignedShort14 = classReader2.readUnsignedShort(i101);
                        int i105 = i53 + 8;
                        while (true) {
                            int i106 = unsignedShort14 - 1;
                            if (unsignedShort14 > 0) {
                                int unsignedShort15 = classReader2.readUnsignedShort(i105);
                                int i107 = i105;
                                int unsignedShort16 = classReader2.readUnsignedShort(i107 + 2);
                                classReader2.createDebugLabel(unsignedShort15, labelArr5);
                                labelArr5[unsignedShort15].addLineNumber(unsignedShort16);
                                unsignedShort14 = i106;
                                i105 = i107 + 4;
                            }
                        }
                    }
                    typeAnnotations = iArr8;
                    b2 = b3;
                    classReader = classReader2;
                    labelArr4 = labelArr5;
                    i53 = i101 + i100;
                    labelArr5 = labelArr4;
                    classReader2 = classReader;
                    b3 = b2;
                    unsignedShort6 = i58;
                    iArr8 = typeAnnotations;
                    methodVisitor3 = methodVisitor;
                }
            }
        }
    }

    private ConstantDynamic readConstantDynamic(int i, char[] cArr) {
        ConstantDynamic constantDynamic = this.constantDynamicValues[i];
        if (constantDynamic != null) {
            return constantDynamic;
        }
        int[] iArr = this.cpInfoOffsets;
        int i2 = iArr[i];
        int i3 = iArr[readUnsignedShort(i2 + 2)];
        String utf8 = readUTF8(i3, cArr);
        String utf82 = readUTF8(i3 + 2, cArr);
        int i4 = this.bootstrapMethodOffsets[readUnsignedShort(i2)];
        Handle handle = (Handle) readConst(readUnsignedShort(i4), cArr);
        int unsignedShort = readUnsignedShort(i4 + 2);
        Object[] objArr = new Object[unsignedShort];
        int i5 = i4 + 4;
        for (int i6 = 0; i6 < unsignedShort; i6++) {
            objArr[i6] = readConst(readUnsignedShort(i5), cArr);
            i5 += 2;
        }
        ConstantDynamic[] constantDynamicArr = this.constantDynamicValues;
        ConstantDynamic constantDynamic2 = new ConstantDynamic(utf8, utf82, handle, objArr);
        constantDynamicArr[i] = constantDynamic2;
        return constantDynamic2;
    }

    private int readElementValue(AnnotationVisitor annotationVisitor, int i, String str, char[] cArr) {
        int i2 = 0;
        if (annotationVisitor == null) {
            int i3 = this.classFileBuffer[i] & 255;
            return i3 != 64 ? i3 != 91 ? i3 != 101 ? i + 3 : i + 5 : readElementValues(null, i + 1, false, cArr)
                    : readElementValues(null, i + 3, true, cArr);
        }
        int i4 = i + 1;
        int i5 = this.classFileBuffer[i] & 255;
        if (i5 == 64) {
            return readElementValues(annotationVisitor.visitAnnotation(str, readUTF8(i4, cArr)), i + 3, true, cArr);
        }
        if (i5 != 70) {
            if (i5 == 83) {
                annotationVisitor.visit(str, Short.valueOf((short) readInt(this.cpInfoOffsets[readUnsignedShort(i4)])));
                return i + 3;
            }
            if (i5 == 99) {
                annotationVisitor.visit(str, Type.getType(readUTF8(i4, cArr)));
                return i + 3;
            }
            if (i5 == 101) {
                annotationVisitor.visitEnum(str, readUTF8(i4, cArr), readUTF8(i + 3, cArr));
                return i + 5;
            }
            if (i5 == 115) {
                annotationVisitor.visit(str, readUTF8(i4, cArr));
                return i + 3;
            }
            if (i5 != 73 && i5 != 74) {
                if (i5 == 90) {
                    annotationVisitor.visit(str,
                            readInt(this.cpInfoOffsets[readUnsignedShort(i4)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                    return i + 3;
                }
                if (i5 == 91) {
                    int unsignedShort = readUnsignedShort(i4);
                    int i6 = i + 3;
                    if (unsignedShort == 0) {
                        return readElementValues(annotationVisitor.visitArray(str), i + 1, false, cArr);
                    }
                    int i7 = this.classFileBuffer[i6] & 255;
                    if (i7 == 70) {
                        float[] fArr = new float[unsignedShort];
                        while (i2 < unsignedShort) {
                            fArr[i2] = Float.intBitsToFloat(readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]));
                            i6 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, fArr);
                        return i6;
                    }
                    if (i7 == 83) {
                        short[] sArr = new short[unsignedShort];
                        while (i2 < unsignedShort) {
                            sArr[i2] = (short) readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, sArr);
                        return i6;
                    }
                    if (i7 == 90) {
                        boolean[] zArr = new boolean[unsignedShort];
                        for (int i8 = 0; i8 < unsignedShort; i8++) {
                            zArr[i8] = readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]) != 0;
                            i6 += 3;
                        }
                        annotationVisitor.visit(str, zArr);
                        return i6;
                    }
                    if (i7 == 73) {
                        int[] iArr = new int[unsignedShort];
                        while (i2 < unsignedShort) {
                            iArr[i2] = readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, iArr);
                        return i6;
                    }
                    if (i7 == 74) {
                        long[] jArr = new long[unsignedShort];
                        while (i2 < unsignedShort) {
                            jArr[i2] = readLong(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]);
                            i6 += 3;
                            i2++;
                        }
                        annotationVisitor.visit(str, jArr);
                        return i6;
                    }
                    switch (i7) {
                        case 66:
                            byte[] bArr = new byte[unsignedShort];
                            while (i2 < unsignedShort) {
                                bArr[i2] = (byte) readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, bArr);
                            return i6;
                        case 67:
                            char[] cArr2 = new char[unsignedShort];
                            while (i2 < unsignedShort) {
                                cArr2[i2] = (char) readInt(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]);
                                i6 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, cArr2);
                            return i6;
                        case 68:
                            double[] dArr = new double[unsignedShort];
                            while (i2 < unsignedShort) {
                                dArr[i2] = Double
                                        .longBitsToDouble(readLong(this.cpInfoOffsets[readUnsignedShort(i6 + 1)]));
                                i6 += 3;
                                i2++;
                            }
                            annotationVisitor.visit(str, dArr);
                            return i6;
                        default:
                            return readElementValues(annotationVisitor.visitArray(str), i + 1, false, cArr);
                    }
                }
                switch (i5) {
                    case 66:
                        annotationVisitor.visit(str,
                                Byte.valueOf((byte) readInt(this.cpInfoOffsets[readUnsignedShort(i4)])));
                        return i + 3;
                    case 67:
                        annotationVisitor.visit(str,
                                Character.valueOf((char) readInt(this.cpInfoOffsets[readUnsignedShort(i4)])));
                        return i + 3;
                    case 68:
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        annotationVisitor.visit(str, readConst(readUnsignedShort(i4), cArr));
        return i + 3;
    }

    private int readElementValues(AnnotationVisitor annotationVisitor, int i, boolean z, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        int elementValue = i + 2;
        if (!z) {
            while (true) {
                int i2 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue, null, cArr);
                unsignedShort = i2;
            }
        } else {
            while (true) {
                int i3 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                elementValue = readElementValue(annotationVisitor, elementValue + 2, readUTF8(elementValue, cArr),
                        cArr);
                unsignedShort = i3;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return elementValue;
    }

    private int readField(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        int i3;
        int i4;
        Context context2 = context;
        char[] cArr = context2.charBuffer;
        int unsignedShort = readUnsignedShort(i);
        String utf8 = readUTF8(i + 2, cArr);
        String utf82 = readUTF8(i + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i + 6);
        int i5 = i + 8;
        int i6 = unsignedShort;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        String utf83 = null;
        Object obj = null;
        Attribute attribute = null;
        while (true) {
            int i11 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            int i12 = i7;
            String utf84 = readUTF8(i5, cArr);
            int i13 = readInt(i5 + 2);
            int i14 = i5 + 6;
            if (AttConstantValue.ATTRIBUTE_NAME.equals(utf84)) {
                int unsignedShort3 = readUnsignedShort(i14);
                obj = unsignedShort3 == 0 ? null : readConst(unsignedShort3, cArr);
            } else {
                if (AttSignature.ATTRIBUTE_NAME.equals(utf84)) {
                    utf83 = readUTF8(i14, cArr);
                } else {
                    if (AttDeprecated.ATTRIBUTE_NAME.equals(utf84)) {
                        i4 = 131072 | i6;
                    } else if (AttSynthetic.ATTRIBUTE_NAME.equals(utf84)) {
                        i4 = i6 | 4096;
                    } else if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                        i7 = i14;
                        i2 = i7;
                        i14 = i8;
                        i3 = i13;
                    } else {
                        if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                            i2 = i14;
                            i9 = i2;
                        } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                            i2 = i14;
                            i3 = i13;
                            i7 = i12;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                            i2 = i14;
                            i10 = i2;
                        } else {
                            i2 = i14;
                            int i15 = i8;
                            i3 = i13;
                            Attribute attribute2 = readAttribute(context2.attributePrototypes, utf84, i2, i3, cArr, -1,
                                    null);
                            attribute2.nextAttribute = attribute;
                            attribute = attribute2;
                            i9 = i9;
                            i14 = i15;
                            i7 = i12;
                            i10 = i10;
                        }
                        i14 = i8;
                        i3 = i13;
                        i7 = i12;
                    }
                    i2 = i14;
                    i6 = i4;
                    i14 = i8;
                    i3 = i13;
                    i7 = i12;
                }
                int i16 = i2 + i3;
                context2 = context;
                i8 = i14;
                i5 = i16;
                unsignedShort2 = i11;
            }
            i2 = i14;
            i14 = i8;
            i3 = i13;
            i7 = i12;
            int i162 = i2 + i3;
            context2 = context;
            i8 = i14;
            i5 = i162;
            unsignedShort2 = i11;
        }
        int i17 = i7;
        int i18 = i8;
        int i19 = i9;
        int i20 = i10;
        FieldVisitor fieldVisitorVisitField = classVisitor.visitField(i6, utf8, utf82, utf83, obj);
        if (fieldVisitorVisitField == null) {
            return i5;
        }
        if (i17 != 0) {
            int unsignedShort4 = readUnsignedShort(i17);
            int elementValues = i17 + 2;
            while (true) {
                int i21 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                elementValues = readElementValues(
                        fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues, cArr), true), elementValues + 2,
                        true, cArr);
                unsignedShort4 = i21;
            }
        }
        if (i18 != 0) {
            int unsignedShort5 = readUnsignedShort(i18);
            int elementValues2 = i18 + 2;
            while (true) {
                int i22 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(
                        fieldVisitorVisitField.visitAnnotation(readUTF8(elementValues2, cArr), false),
                        elementValues2 + 2, true, cArr);
                unsignedShort5 = i22;
            }
        }
        if (i19 != 0) {
            int unsignedShort6 = readUnsignedShort(i19);
            int elementValues3 = i19 + 2;
            while (true) {
                int i23 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(
                        fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget, cArr), true),
                        typeAnnotationTarget + 2, true, cArr);
                unsignedShort6 = i23;
            }
        }
        if (i20 != 0) {
            int unsignedShort7 = readUnsignedShort(i20);
            int elementValues4 = i20 + 2;
            while (true) {
                int i24 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(
                        fieldVisitorVisitField.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath, readUTF8(typeAnnotationTarget2, cArr), false),
                        typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort7 = i24;
            }
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            fieldVisitorVisitField.visitAttribute(attribute);
            attribute = attribute3;
        }
        fieldVisitorVisitField.visitEnd();
        return i5;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        char[] cArr;
        int i3;
        int i4;
        int i5;
        char[] cArr2;
        ClassReader classReader = this;
        char[] cArr3 = context.charBuffer;
        context.currentMethodAccessFlags = classReader.readUnsignedShort(i);
        context.currentMethodName = classReader.readUTF8(i + 2, cArr3);
        int i6 = i + 4;
        context.currentMethodDescriptor = classReader.readUTF8(i6, cArr3);
        int unsignedShort = classReader.readUnsignedShort(i + 6);
        int i7 = i + 8;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        Attribute attribute = null;
        int unsignedShort2 = 0;
        int i12 = 0;
        int i13 = 0;
        String[] strArr = null;
        boolean z = false;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            int i19 = i8;
            String utf8 = classReader.readUTF8(i7, cArr3);
            int i20 = classReader.readInt(i7 + 2);
            int i21 = i9;
            int i22 = i7 + 6;
            int i23 = i19;
            if (AttCode.ATTRIBUTE_NAME.equals(utf8)) {
                if ((context.parsingOptions & 1) == 0) {
                    i17 = i22;
                }
            } else if (AttExceptions.ATTRIBUTE_NAME.equals(utf8)) {
                int unsignedShort3 = classReader.readUnsignedShort(i22);
                int i24 = i7 + 8;
                strArr = new String[unsignedShort3];
                for (int i25 = 0; i25 < unsignedShort3; i25++) {
                    strArr[i25] = classReader.readClass(i24, cArr3);
                    i24 += 2;
                }
                i14 = i22;
            } else if (AttSignature.ATTRIBUTE_NAME.equals(utf8)) {
                unsignedShort2 = classReader.readUnsignedShort(i22);
            } else if (AttDeprecated.ATTRIBUTE_NAME.equals(utf8)) {
                context.currentMethodAccessFlags |= 131072;
            } else if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                i23 = i22;
            } else {
                if ("RuntimeVisibleTypeAnnotations".equals(utf8)) {
                    i4 = i22;
                    cArr2 = cArr3;
                    i5 = i20;
                } else if (AttAnnotationDefault.ATTRIBUTE_NAME.equals(utf8)) {
                    i13 = i22;
                } else if (AttSynthetic.ATTRIBUTE_NAME.equals(utf8)) {
                    context.currentMethodAccessFlags |= 4096;
                    i4 = i10;
                    cArr2 = cArr3;
                    i5 = i20;
                    z = true;
                } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i21 = i22;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(utf8)) {
                    i11 = i22;
                } else if (AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i15 = i22;
                } else if (AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME.equals(utf8)) {
                    i16 = i22;
                } else if ("MethodParameters".equals(utf8)) {
                    i12 = i22;
                } else {
                    i4 = i10;
                    i5 = i20;
                    Attribute attribute2 = classReader.readAttribute(context.attributePrototypes, utf8, i22, i5, cArr3,
                            -1, null);
                    cArr2 = cArr3;
                    attribute2.nextAttribute = attribute;
                    attribute = attribute2;
                    i11 = i11;
                }
                i7 = i22 + i5;
                cArr3 = cArr2;
                unsignedShort = i18;
                i9 = i21;
                i8 = i23;
                i10 = i4;
            }
            i4 = i10;
            cArr2 = cArr3;
            i5 = i20;
            i7 = i22 + i5;
            cArr3 = cArr2;
            unsignedShort = i18;
            i9 = i21;
            i8 = i23;
            i10 = i4;
        }
        int i26 = i8;
        int i27 = i9;
        int i28 = i10;
        char[] cArr4 = cArr3;
        int i29 = i11;
        int i30 = i13;
        int i31 = i12;
        MethodVisitor methodVisitorVisitMethod = classVisitor.visitMethod(context.currentMethodAccessFlags,
                context.currentMethodName, context.currentMethodDescriptor,
                unsignedShort2 == 0 ? null : classReader.readUtf(unsignedShort2, cArr4), strArr);
        if (methodVisitorVisitMethod == null) {
            return i7;
        }
        if (methodVisitorVisitMethod instanceof MethodWriter) {
            MethodWriter methodWriter = (MethodWriter) methodVisitorVisitMethod;
            i3 = i30;
            boolean z2 = (context.currentMethodAccessFlags & 131072) != 0;
            int unsignedShort4 = classReader.readUnsignedShort(i6);
            int i32 = unsignedShort2;
            i2 = i31;
            cArr = cArr4;
            boolean zCanCopyMethodAttributes = methodWriter.canCopyMethodAttributes(classReader, z, z2, unsignedShort4,
                    i32, i14);
            classReader = classReader;
            if (zCanCopyMethodAttributes) {
                methodWriter.setMethodAttributesSource(i, i7 - i);
                return i7;
            }
        } else {
            i2 = i31;
            cArr = cArr4;
            i3 = i30;
        }
        if (i2 != 0 && (context.parsingOptions & 2) == 0) {
            int i33 = classReader.readByte(i2);
            int i34 = i2 + 1;
            while (true) {
                int i35 = i33 - 1;
                if (i33 <= 0) {
                    break;
                }
                methodVisitorVisitMethod.visitParameter(classReader.readUTF8(i34, cArr),
                        classReader.readUnsignedShort(i34 + 2));
                i34 += 4;
                i33 = i35;
            }
        }
        if (i3 != 0) {
            AnnotationVisitor annotationVisitorVisitAnnotationDefault = methodVisitorVisitMethod
                    .visitAnnotationDefault();
            classReader.readElementValue(annotationVisitorVisitAnnotationDefault, i3, null, cArr);
            if (annotationVisitorVisitAnnotationDefault != null) {
                annotationVisitorVisitAnnotationDefault.visitEnd();
            }
        }
        if (i26 != 0) {
            int unsignedShort5 = classReader.readUnsignedShort(i26);
            int elementValues = i26 + 2;
            while (true) {
                int i36 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues = classReader.readElementValues(
                        methodVisitorVisitMethod.visitAnnotation(classReader.readUTF8(elementValues, cArr), true),
                        elementValues + 2, true, cArr);
                unsignedShort5 = i36;
            }
        }
        if (i27 != 0) {
            int unsignedShort6 = classReader.readUnsignedShort(i27);
            int elementValues2 = i27 + 2;
            while (true) {
                int i37 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                elementValues2 = classReader.readElementValues(
                        methodVisitorVisitMethod.visitAnnotation(classReader.readUTF8(elementValues2, cArr), false),
                        elementValues2 + 2, true, cArr);
                unsignedShort6 = i37;
            }
        }
        if (i28 != 0) {
            int unsignedShort7 = classReader.readUnsignedShort(i28);
            int elementValues3 = i28 + 2;
            while (true) {
                int i38 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget = classReader.readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = classReader.readElementValues(
                        methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath,
                                classReader.readUTF8(typeAnnotationTarget, cArr), true),
                        typeAnnotationTarget + 2, true, cArr);
                unsignedShort7 = i38;
            }
        }
        if (i29 != 0) {
            int unsignedShort8 = classReader.readUnsignedShort(i29);
            int elementValues4 = i29 + 2;
            while (true) {
                int i39 = unsignedShort8 - 1;
                if (unsignedShort8 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = classReader.readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = classReader.readElementValues(
                        methodVisitorVisitMethod.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath,
                                classReader.readUTF8(typeAnnotationTarget2, cArr), false),
                        typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort8 = i39;
            }
        }
        int i40 = i15;
        if (i40 != 0) {
            classReader.readParameterAnnotations(methodVisitorVisitMethod, context, i40, true);
        }
        int i41 = i16;
        if (i41 != 0) {
            classReader.readParameterAnnotations(methodVisitorVisitMethod, context, i41, false);
        }
        while (attribute != null) {
            Attribute attribute3 = attribute.nextAttribute;
            attribute.nextAttribute = null;
            methodVisitorVisitMethod.visitAttribute(attribute);
            attribute = attribute3;
        }
        int i42 = i17;
        if (i42 != 0) {
            methodVisitorVisitMethod.visitCode();
            classReader.readCode(methodVisitorVisitMethod, context, i42);
        }
        methodVisitorVisitMethod.visitEnd();
        return i7;
    }

    private void readModuleAttributes(ClassVisitor classVisitor, Context context, int i, int i2, String str) {
        String[] strArr;
        char[] cArr = context.charBuffer;
        int i3 = i + 6;
        ModuleVisitor moduleVisitorVisitModule = classVisitor.visitModule(readModule(i, cArr), readUnsignedShort(i + 2),
                readUTF8(i + 4, cArr));
        if (moduleVisitorVisitModule == null) {
            return;
        }
        if (str != null) {
            moduleVisitorVisitModule.visitMainClass(str);
        }
        if (i2 != 0) {
            int unsignedShort = readUnsignedShort(i2);
            int i4 = i2 + 2;
            while (true) {
                int i5 = unsignedShort - 1;
                if (unsignedShort <= 0) {
                    break;
                }
                moduleVisitorVisitModule.visitPackage(readPackage(i4, cArr));
                i4 += 2;
                unsignedShort = i5;
            }
        }
        int unsignedShort2 = readUnsignedShort(i3);
        int i6 = i + 8;
        while (true) {
            int i7 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            String module = readModule(i6, cArr);
            int unsignedShort3 = readUnsignedShort(i6 + 2);
            String utf8 = readUTF8(i6 + 4, cArr);
            i6 += 6;
            moduleVisitorVisitModule.visitRequire(module, unsignedShort3, utf8);
            unsignedShort2 = i7;
        }
        int unsignedShort4 = readUnsignedShort(i6);
        int i8 = i6 + 2;
        while (true) {
            int i9 = unsignedShort4 - 1;
            String[] strArr2 = null;
            if (unsignedShort4 <= 0) {
                break;
            }
            String str2 = readPackage(i8, cArr);
            int unsignedShort5 = readUnsignedShort(i8 + 2);
            int unsignedShort6 = readUnsignedShort(i8 + 4);
            i8 += 6;
            if (unsignedShort6 != 0) {
                strArr2 = new String[unsignedShort6];
                for (int i10 = 0; i10 < unsignedShort6; i10++) {
                    strArr2[i10] = readModule(i8, cArr);
                    i8 += 2;
                }
            }
            moduleVisitorVisitModule.visitExport(str2, unsignedShort5, strArr2);
            unsignedShort4 = i9;
        }
        int unsignedShort7 = readUnsignedShort(i8);
        int i11 = i8 + 2;
        while (true) {
            int i12 = unsignedShort7 - 1;
            if (unsignedShort7 <= 0) {
                break;
            }
            String str3 = readPackage(i11, cArr);
            int unsignedShort8 = readUnsignedShort(i11 + 2);
            int unsignedShort9 = readUnsignedShort(i11 + 4);
            i11 += 6;
            if (unsignedShort9 != 0) {
                strArr = new String[unsignedShort9];
                for (int i13 = 0; i13 < unsignedShort9; i13++) {
                    strArr[i13] = readModule(i11, cArr);
                    i11 += 2;
                }
            } else {
                strArr = null;
            }
            moduleVisitorVisitModule.visitOpen(str3, unsignedShort8, strArr);
            unsignedShort7 = i12;
        }
        int unsignedShort10 = readUnsignedShort(i11);
        int i14 = i11 + 2;
        while (true) {
            int i15 = unsignedShort10 - 1;
            if (unsignedShort10 <= 0) {
                break;
            }
            moduleVisitorVisitModule.visitUse(readClass(i14, cArr));
            i14 += 2;
            unsignedShort10 = i15;
        }
        int unsignedShort11 = readUnsignedShort(i14);
        int i16 = i14 + 2;
        while (true) {
            int i17 = unsignedShort11 - 1;
            if (unsignedShort11 <= 0) {
                moduleVisitorVisitModule.visitEnd();
                return;
            }
            String str4 = readClass(i16, cArr);
            int unsignedShort12 = readUnsignedShort(i16 + 2);
            i16 += 4;
            String[] strArr3 = new String[unsignedShort12];
            for (int i18 = 0; i18 < unsignedShort12; i18++) {
                strArr3[i18] = readClass(i16, cArr);
                i16 += 2;
            }
            moduleVisitorVisitModule.visitProvide(str4, strArr3);
            unsignedShort11 = i17;
        }
    }

    private void readParameterAnnotations(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int elementValues = i + 1;
        int i2 = this.classFileBuffer[i] & 255;
        methodVisitor.visitAnnotableParameterCount(i2, z);
        char[] cArr = context.charBuffer;
        for (int i3 = 0; i3 < i2; i3++) {
            int unsignedShort = readUnsignedShort(elementValues);
            elementValues += 2;
            while (true) {
                int i4 = unsignedShort - 1;
                if (unsignedShort > 0) {
                    elementValues = readElementValues(
                            methodVisitor.visitParameterAnnotation(i3, readUTF8(elementValues, cArr), z),
                            elementValues + 2, true, cArr);
                    unsignedShort = i4;
                }
            }
        }
    }

    private int readRecordComponent(ClassVisitor classVisitor, Context context, int i) {
        int i2;
        int i3;
        Attribute attribute;
        char[] cArr = context.charBuffer;
        String utf8 = readUTF8(i, cArr);
        String utf82 = readUTF8(i + 2, cArr);
        int unsignedShort = readUnsignedShort(i + 4);
        int i4 = i + 6;
        int i5 = 0;
        Attribute attribute2 = null;
        int i6 = 0;
        String utf83 = null;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = unsignedShort - 1;
            if (unsignedShort <= 0) {
                break;
            }
            String utf84 = readUTF8(i4, cArr);
            int i10 = readInt(i4 + 2);
            int i11 = i4 + 6;
            if (AttSignature.ATTRIBUTE_NAME.equals(utf84)) {
                utf83 = readUTF8(i11, cArr);
                int i12 = i5;
                i2 = i11;
                i11 = i12;
            } else {
                if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                    i7 = i11;
                    attribute = attribute2;
                    i3 = i10;
                    i11 = i5;
                    i2 = i7;
                } else if ("RuntimeVisibleTypeAnnotations".equals(utf84)) {
                    i2 = i11;
                } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf84)) {
                    i8 = i11;
                    attribute = attribute2;
                    i3 = i10;
                    i11 = i5;
                    i2 = i8;
                } else if ("RuntimeInvisibleTypeAnnotations".equals(utf84)) {
                    i6 = i11;
                    attribute = attribute2;
                    i3 = i10;
                    i11 = i5;
                    i2 = i6;
                } else {
                    int i13 = i5;
                    i2 = i11;
                    Attribute attribute3 = attribute2;
                    i3 = i10;
                    Attribute attribute4 = readAttribute(context.attributePrototypes, utf84, i2, i3, cArr, -1, null);
                    attribute4.nextAttribute = attribute3;
                    attribute = attribute4;
                    i11 = i13;
                    i6 = i6;
                }
                int i14 = i2 + i3;
                i5 = i11;
                i4 = i14;
                attribute2 = attribute;
                unsignedShort = i9;
            }
            attribute = attribute2;
            i3 = i10;
            int i142 = i2 + i3;
            i5 = i11;
            i4 = i142;
            attribute2 = attribute;
            unsignedShort = i9;
        }
        int i15 = i5;
        Attribute attribute5 = attribute2;
        int i16 = i6;
        RecordComponentVisitor recordComponentVisitorVisitRecordComponent = classVisitor.visitRecordComponent(utf8,
                utf82, utf83);
        if (recordComponentVisitorVisitRecordComponent == null) {
            return i4;
        }
        if (i7 != 0) {
            int unsignedShort2 = readUnsignedShort(i7);
            int elementValues = i7 + 2;
            while (true) {
                int i17 = unsignedShort2 - 1;
                if (unsignedShort2 <= 0) {
                    break;
                }
                elementValues = readElementValues(
                        recordComponentVisitorVisitRecordComponent.visitAnnotation(readUTF8(elementValues, cArr), true),
                        elementValues + 2, true, cArr);
                unsignedShort2 = i17;
            }
        }
        if (i8 != 0) {
            int unsignedShort3 = readUnsignedShort(i8);
            int elementValues2 = i8 + 2;
            while (true) {
                int i18 = unsignedShort3 - 1;
                if (unsignedShort3 <= 0) {
                    break;
                }
                elementValues2 = readElementValues(recordComponentVisitorVisitRecordComponent
                        .visitAnnotation(readUTF8(elementValues2, cArr), false), elementValues2 + 2, true, cArr);
                unsignedShort3 = i18;
            }
        }
        if (i15 != 0) {
            int unsignedShort4 = readUnsignedShort(i15);
            int elementValues3 = i15 + 2;
            while (true) {
                int i19 = unsignedShort4 - 1;
                if (unsignedShort4 <= 0) {
                    break;
                }
                int typeAnnotationTarget = readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(
                        context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath,
                        readUTF8(typeAnnotationTarget, cArr), true), typeAnnotationTarget + 2, true, cArr);
                unsignedShort4 = i19;
            }
        }
        if (i16 != 0) {
            int unsignedShort5 = readUnsignedShort(i16);
            int elementValues4 = i16 + 2;
            while (true) {
                int i20 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = readElementValues(recordComponentVisitorVisitRecordComponent.visitTypeAnnotation(
                        context.currentTypeAnnotationTarget, context.currentTypeAnnotationTargetPath,
                        readUTF8(typeAnnotationTarget2, cArr), false), typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort5 = i20;
            }
        }
        Attribute attribute6 = attribute5;
        while (attribute6 != null) {
            Attribute attribute7 = attribute6.nextAttribute;
            attribute6.nextAttribute = null;
            recordComponentVisitorVisitRecordComponent.visitAttribute(attribute6);
            attribute6 = attribute7;
        }
        recordComponentVisitorVisitRecordComponent.visitEnd();
        return i4;
    }

    private int readStackMapFrame(int i, boolean z, boolean z2, Context context) {
        int verificationTypeInfo;
        int i2;
        char[] cArr = context.charBuffer;
        Label[] labelArr = context.currentMethodLabels;
        if (z) {
            verificationTypeInfo = i + 1;
            i2 = this.classFileBuffer[i] & 255;
        } else {
            context.currentFrameOffset = -1;
            verificationTypeInfo = i;
            i2 = 255;
        }
        context.currentFrameLocalCountDelta = 0;
        if (i2 < 64) {
            context.currentFrameType = 3;
            context.currentFrameStackCount = 0;
        } else if (i2 < 128) {
            i2 -= 64;
            verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, 0,
                    cArr, labelArr);
            context.currentFrameType = 4;
            context.currentFrameStackCount = 1;
        } else {
            if (i2 < 247) {
                throw new IllegalArgumentException();
            }
            int unsignedShort = readUnsignedShort(verificationTypeInfo);
            int i3 = verificationTypeInfo;
            verificationTypeInfo = i3 + 2;
            if (i2 == 247) {
                verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo, context.currentFrameStackTypes, 0,
                        cArr, labelArr);
                context.currentFrameType = 4;
                context.currentFrameStackCount = 1;
            } else if (i2 >= 248 && i2 < 251) {
                context.currentFrameType = 2;
                int i4 = 251 - i2;
                context.currentFrameLocalCountDelta = i4;
                context.currentFrameLocalCount -= i4;
                context.currentFrameStackCount = 0;
            } else if (i2 == 251) {
                context.currentFrameType = 3;
                context.currentFrameStackCount = 0;
            } else if (i2 < 255) {
                int i5 = i2 - 251;
                int i6 = z2 ? context.currentFrameLocalCount : 0;
                int i7 = i5;
                while (i7 > 0) {
                    verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo,
                            context.currentFrameLocalTypes, i6, cArr, labelArr);
                    i7--;
                    i6++;
                }
                context.currentFrameType = 1;
                context.currentFrameLocalCountDelta = i5;
                context.currentFrameLocalCount += i5;
                context.currentFrameStackCount = 0;
            } else {
                int unsignedShort2 = readUnsignedShort(verificationTypeInfo);
                int verificationTypeInfo2 = i3 + 4;
                context.currentFrameType = 0;
                context.currentFrameLocalCountDelta = unsignedShort2;
                context.currentFrameLocalCount = unsignedShort2;
                for (int i8 = 0; i8 < unsignedShort2; i8++) {
                    verificationTypeInfo2 = readVerificationTypeInfo(verificationTypeInfo2,
                            context.currentFrameLocalTypes, i8, cArr, labelArr);
                }
                int unsignedShort3 = readUnsignedShort(verificationTypeInfo2);
                verificationTypeInfo = verificationTypeInfo2 + 2;
                context.currentFrameStackCount = unsignedShort3;
                for (int i9 = 0; i9 < unsignedShort3; i9++) {
                    verificationTypeInfo = readVerificationTypeInfo(verificationTypeInfo,
                            context.currentFrameStackTypes, i9, cArr, labelArr);
                }
            }
            i2 = unsignedShort;
        }
        int i10 = i2 + 1 + context.currentFrameOffset;
        context.currentFrameOffset = i10;
        createLabel(i10, labelArr);
        return verificationTypeInfo;
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
     * "finallyBlockTerminus" is null
     * at
     * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
     * (TraverserActivePathState.java:253)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:422)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    private static byte[] readStream(InputStream inputStream, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IOException("Class not found");
        }
        int iComputeBufferSize = computeBufferSize(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[iComputeBufferSize];
                int i = 0;
                while (true) {
                    int i2 = inputStream.read(bArr, 0, iComputeBufferSize);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    i++;
                }
                byteArrayOutputStream.flush();
                if (i == 1) {
                    byteArrayOutputStream.close();
                    if (z) {
                        inputStream.close();
                    }
                    return bArr;
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (z) {
                    inputStream.close();
                }
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (z) {
                inputStream.close();
            }
            throw th2;
        }
    }

    private String readStringish(int i, char[] cArr) {
        return readUTF8(this.cpInfoOffsets[readUnsignedShort(i)], cArr);
    }

    /*
     * JADX WARN: Can't fix incorrect switch cases order, some code will duplicate
     */
    /* JADX WARN: Found duplicated region for block: B:17:0x006d */
    /* JADX WARN: Found duplicated region for block: B:18:0x0070 */
    private int readTypeAnnotationTarget(Context context, int i) {
        int i2;
        int i3;
        int i4 = readInt(i);
        int i5 = i4 >>> 24;
        if (i5 != 0 && i5 != 1) {
            switch (i5) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i2 = i4 & (-256);
                    i3 = i + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i2 = i4 & (-16777216);
                    i3 = i + 1;
                    break;
                case 22:
                    i2 = i4 & (-65536);
                    i3 = i + 2;
                    break;
                default:
                    switch (i5) {
                        case 64:
                        case 65:
                            i2 = i4 & (-16777216);
                            int unsignedShort = readUnsignedShort(i + 1);
                            i3 = i + 3;
                            context.currentLocalVariableAnnotationRangeStarts = new Label[unsignedShort];
                            context.currentLocalVariableAnnotationRangeEnds = new Label[unsignedShort];
                            context.currentLocalVariableAnnotationRangeIndices = new int[unsignedShort];
                            for (int i6 = 0; i6 < unsignedShort; i6++) {
                                int unsignedShort2 = readUnsignedShort(i3);
                                int unsignedShort3 = readUnsignedShort(i3 + 2);
                                int unsignedShort4 = readUnsignedShort(i3 + 4);
                                i3 += 6;
                                context.currentLocalVariableAnnotationRangeStarts[i6] = createLabel(unsignedShort2,
                                        context.currentMethodLabels);
                                context.currentLocalVariableAnnotationRangeEnds[i6] = createLabel(
                                        unsignedShort2 + unsignedShort3, context.currentMethodLabels);
                                context.currentLocalVariableAnnotationRangeIndices[i6] = unsignedShort4;
                            }
                            break;
                        case 66:
                            i2 = i4 & (-256);
                            i3 = i + 3;
                            break;
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            i2 = i4 & (-16777216);
                            i3 = i + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i2 = i4 & (-16776961);
                            i3 = i + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i2 = i4 & (-65536);
            i3 = i + 2;
        }
        context.currentTypeAnnotationTarget = i2;
        int i7 = readByte(i3);
        context.currentTypeAnnotationTargetPath = i7 == 0 ? null : new TypePath(this.classFileBuffer, i3);
        return (i7 * 2) + i3 + 1;
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x004d A[FALL_THROUGH] */
    private int[] readTypeAnnotations(MethodVisitor methodVisitor, Context context, int i, boolean z) {
        int i2;
        char[] cArr = context.charBuffer;
        int unsignedShort = readUnsignedShort(i);
        int[] iArr = new int[unsignedShort];
        int elementValues = i + 2;
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            iArr[i3] = elementValues;
            int i4 = readInt(elementValues);
            int i5 = i4 >>> 24;
            if (i5 != 23) {
                switch (i5) {
                    default:
                        switch (i5) {
                            case 64:
                            case 65:
                                int unsignedShort2 = readUnsignedShort(elementValues + 1);
                                i2 = elementValues + 3;
                                while (true) {
                                    int i6 = unsignedShort2 - 1;
                                    if (unsignedShort2 > 0) {
                                        int unsignedShort3 = readUnsignedShort(i2);
                                        int unsignedShort4 = readUnsignedShort(i2 + 2);
                                        i2 += 6;
                                        createLabel(unsignedShort3, context.currentMethodLabels);
                                        createLabel(unsignedShort3 + unsignedShort4, context.currentMethodLabels);
                                        unsignedShort2 = i6;
                                    }
                                    break;
                                }
                                break;
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i2 = elementValues + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i2 = elementValues + 3;
                        break;
                }
            } else {
                i2 = elementValues + 3;
            }
            int i7 = readByte(i2);
            if (i5 == 66) {
                TypePath typePath = i7 != 0 ? new TypePath(this.classFileBuffer, i2) : null;
                int iC = bjs.c(i7, 2, 1, i2);
                elementValues = readElementValues(
                        methodVisitor.visitTryCatchAnnotation(i4 & (-256), typePath, readUTF8(iC, cArr), z), iC + 2,
                        true, cArr);
            } else {
                elementValues = readElementValues(null, bjs.c(i7, 2, 3, i2), true, cArr);
            }
        }
        return iArr;
    }

    private int readVerificationTypeInfo(int i, Object[] objArr, int i2, char[] cArr, Label[] labelArr) {
        int i3 = i + 1;
        switch (this.classFileBuffer[i] & 255) {
            case 0:
                objArr[i2] = Opcodes.TOP;
                return i3;
            case 1:
                objArr[i2] = Opcodes.INTEGER;
                return i3;
            case 2:
                objArr[i2] = Opcodes.FLOAT;
                return i3;
            case 3:
                objArr[i2] = Opcodes.DOUBLE;
                return i3;
            case 4:
                objArr[i2] = Opcodes.LONG;
                return i3;
            case 5:
                objArr[i2] = Opcodes.NULL;
                return i3;
            case 6:
                objArr[i2] = Opcodes.UNINITIALIZED_THIS;
                return i3;
            case 7:
                objArr[i2] = readClass(i3, cArr);
                break;
            case 8:
                objArr[i2] = createLabel(readUnsignedShort(i3), labelArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i + 3;
    }

    private static /* synthetic */ String stringConcat$0(short s) {
        return concatVar2Var1(s, "Unsupported class file major version ");
    }

    private static /* synthetic */ String stringConcat$1(String str) {
        return StaticHelpers6.concat(str, ClassFileLocator.CLASS_FILE_EXTENSION);
    }

    public void accept(ClassVisitor classVisitor, int i) {
        accept(classVisitor, new Attribute[0], i);
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public final int getFirstAttributeOffset() {
        int i = this.header;
        int unsignedShort = (readUnsignedShort(i + 6) * 2) + i + 8;
        int unsignedShort2 = readUnsignedShort(unsignedShort);
        int i2 = unsignedShort + 2;
        while (true) {
            int i3 = unsignedShort2 - 1;
            if (unsignedShort2 <= 0) {
                break;
            }
            int unsignedShort3 = readUnsignedShort(i2 + 6);
            i2 += 8;
            while (true) {
                int i4 = unsignedShort3 - 1;
                if (unsignedShort3 > 0) {
                    i2 += readInt(i2 + 2) + 6;
                    unsignedShort3 = i4;
                }
            }
            unsignedShort2 = i3;
        }
        int unsignedShort4 = readUnsignedShort(i2);
        int i5 = i2 + 2;
        while (true) {
            int i6 = unsignedShort4 - 1;
            if (unsignedShort4 <= 0) {
                return i5 + 2;
            }
            int unsignedShort5 = readUnsignedShort(i5 + 6);
            i5 += 8;
            while (true) {
                int i7 = unsignedShort5 - 1;
                if (unsignedShort5 > 0) {
                    i5 += readInt(i5 + 2) + 6;
                    unsignedShort5 = i7;
                }
            }
            unsignedShort4 = i6;
        }
    }

    public String[] getInterfaces() {
        int i = this.header + 6;
        int unsignedShort = readUnsignedShort(i);
        String[] strArr = new String[unsignedShort];
        if (unsignedShort > 0) {
            char[] cArr = new char[this.maxStringLength];
            for (int i2 = 0; i2 < unsignedShort; i2++) {
                i += 2;
                strArr[i2] = readClass(i, cArr);
            }
        }
        return strArr;
    }

    public int getItem(int i) {
        return this.cpInfoOffsets[i];
    }

    public int getItemCount() {
        return this.cpInfoOffsets.length;
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public int readByte(int i) {
        return this.classFileBuffer[i] & 255;
    }

    public void readBytecodeInstructionOffset(int i) {
    }

    public byte[] readBytes(int i, int i2) {
        byte[] bArr = new byte[i2];
        System.arraycopy(this.classFileBuffer, i, bArr, 0, i2);
        return bArr;
    }

    public String readClass(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public Object readConst(int i, char[] cArr) {
        int i2 = this.cpInfoOffsets[i];
        byte b = this.classFileBuffer[i2 - 1];
        switch (b) {
            case 3:
                return Integer.valueOf(readInt(i2));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(readInt(i2)));
            case 5:
                return Long.valueOf(readLong(i2));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(readLong(i2)));
            case 7:
                return Type.getObjectType(readUTF8(i2, cArr));
            case 8:
                return readUTF8(i2, cArr);
            default:
                switch (b) {
                    case 15:
                        int i3 = readByte(i2);
                        int i4 = this.cpInfoOffsets[readUnsignedShort(i2 + 1)];
                        int i5 = this.cpInfoOffsets[readUnsignedShort(i4 + 2)];
                        return new Handle(i3, readClass(i4, cArr), readUTF8(i5, cArr), readUTF8(i5 + 2, cArr),
                                this.classFileBuffer[i4 - 1] == 11);
                    case 16:
                        return Type.getMethodType(readUTF8(i2, cArr));
                    case 17:
                        return readConstantDynamic(i, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public int readInt(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public Label readLabel(int i, Label[] labelArr) {
        if (labelArr[i] == null) {
            labelArr[i] = new Label();
        }
        return labelArr[i];
    }

    public long readLong(int i) {
        return (((long) readInt(i)) << 32) | (((long) readInt(i + 4)) & 4294967295L);
    }

    public String readModule(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public String readPackage(int i, char[] cArr) {
        return readStringish(i, cArr);
    }

    public short readShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public String readUTF8(int i, char[] cArr) {
        int unsignedShort = readUnsignedShort(i);
        if (i == 0 || unsignedShort == 0) {
            return null;
        }
        return readUtf(unsignedShort, cArr);
    }

    public int readUnsignedShort(int i) {
        byte[] bArr = this.classFileBuffer;
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public final String readUtf(int i, char[] cArr) {
        String[] strArr = this.constantUtf8Values;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int i2 = this.cpInfoOffsets[i];
        String utf = readUtf(i2 + 2, readUnsignedShort(i2), cArr);
        strArr[i] = utf;
        return utf;
    }

    public ClassReader(byte[] bArr, int i, int i2) {
        this(bArr, i, true);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attributeArr, int i) {
        Context context;
        ClassReader classReader;
        Context context2;
        String str;
        int i2;
        int i3;
        String utf8;
        int i4;
        String str2;
        String str3;
        int i5;
        Context context3 = new Context();
        context3.attributePrototypes = attributeArr;
        context3.parsingOptions = i;
        char[] cArr = new char[this.maxStringLength];
        context3.charBuffer = cArr;
        int i6 = this.header;
        int unsignedShort = readUnsignedShort(i6);
        String str4 = readClass(i6 + 2, cArr);
        String str5 = readClass(i6 + 4, cArr);
        int unsignedShort2 = readUnsignedShort(i6 + 6);
        String[] strArr = new String[unsignedShort2];
        int i7 = i6 + 8;
        for (int i8 = 0; i8 < unsignedShort2; i8++) {
            strArr[i8] = readClass(i7, cArr);
            i7 += 2;
        }
        int firstAttributeOffset = getFirstAttributeOffset();
        int unsignedShort3 = readUnsignedShort(firstAttributeOffset - 2);
        String str6 = null;
        String utf = null;
        String str7 = null;
        int i9 = 0;
        int i10 = 0;
        String utf82 = null;
        int i11 = 0;
        int i12 = 0;
        String str8 = null;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        Attribute attribute = null;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (unsignedShort3 > 0) {
            int i20 = firstAttributeOffset;
            String utf83 = readUTF8(i20, cArr);
            int i21 = readInt(i20 + 2);
            String str9 = str6;
            int i22 = i20 + 6;
            String str10 = utf;
            if (AttSourceFile.ATTRIBUTE_NAME.equals(utf83)) {
                utf8 = readUTF8(i22, cArr);
                i5 = unsignedShort;
                i3 = i22;
                str2 = str4;
                utf = str10;
                i4 = i21;
                context2 = context3;
            } else {
                if (AttInnerClasses.ATTRIBUTE_NAME.equals(utf83)) {
                    i5 = unsignedShort;
                    i3 = i22;
                    i18 = i3;
                } else if (AttEnclosingMethod.ATTRIBUTE_NAME.equals(utf83)) {
                    i5 = unsignedShort;
                    i3 = i22;
                    i10 = i3;
                } else {
                    if ("NestHost".equals(utf83)) {
                        str7 = readClass(i22, cArr);
                    } else if ("NestMembers".equals(utf83)) {
                        i5 = unsignedShort;
                        i3 = i22;
                        i16 = i3;
                    } else if ("PermittedSubclasses".equals(utf83)) {
                        i5 = unsignedShort;
                        i3 = i22;
                        i17 = i3;
                    } else if (AttSignature.ATTRIBUTE_NAME.equals(utf83)) {
                        utf82 = readUTF8(i22, cArr);
                    } else if (AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME.equals(utf83)) {
                        i5 = unsignedShort;
                        i3 = i22;
                        i9 = i3;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(utf83)) {
                        i5 = unsignedShort;
                        i3 = i22;
                        i14 = i3;
                    } else {
                        if (AttDeprecated.ATTRIBUTE_NAME.equals(utf83)) {
                            i5 = 131072 | unsignedShort;
                        } else if (AttSynthetic.ATTRIBUTE_NAME.equals(utf83)) {
                            i5 = unsignedShort | 4096;
                        } else if (AttSourceDebugExtension.ATTRIBUTE_NAME.equals(utf83)) {
                            if (i21 > this.classFileBuffer.length - i22) {
                                throw new IllegalArgumentException();
                            }
                            utf = readUtf(i22, i21, new char[i21]);
                            i5 = unsignedShort;
                            i3 = i22;
                            context2 = context3;
                            utf8 = str9;
                            i4 = i21;
                            str2 = str4;
                        } else if (AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME.equals(utf83)) {
                            i5 = unsignedShort;
                            i3 = i22;
                            i13 = i3;
                        } else if ("RuntimeInvisibleTypeAnnotations".equals(utf83)) {
                            i5 = unsignedShort;
                            i3 = i22;
                            i15 = i3;
                        } else if ("Record".equals(utf83)) {
                            i5 = 65536 | unsignedShort;
                            i3 = i22;
                            i19 = i3;
                        } else if ("Module".equals(utf83)) {
                            i5 = unsignedShort;
                            i3 = i22;
                            i11 = i3;
                        } else if ("ModuleMainClass".equals(utf83)) {
                            str8 = readClass(i22, cArr);
                        } else if ("ModulePackages".equals(utf83)) {
                            i5 = unsignedShort;
                            i3 = i22;
                            i12 = i3;
                        } else {
                            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(utf83)) {
                                context2 = context3;
                                str = str10;
                                i2 = unsignedShort;
                                i3 = i22;
                                utf8 = str9;
                                i4 = i21;
                                str2 = str4;
                                str3 = str7;
                            } else {
                                context2 = context3;
                                str = str10;
                                utf8 = str9;
                                str2 = str4;
                                str3 = str7;
                                i2 = unsignedShort;
                                i3 = i22;
                                i4 = i21;
                                Attribute attribute2 = readAttribute(attributeArr, utf83, i3, i4, cArr, -1, null);
                                attribute2.nextAttribute = attribute;
                                attribute = attribute2;
                            }
                            utf = str;
                            str7 = str3;
                            i5 = i2;
                        }
                        i3 = i22;
                    }
                    i5 = unsignedShort;
                    i3 = i22;
                }
                utf = str10;
                utf8 = str9;
                i4 = i21;
                context2 = context3;
                str2 = str4;
            }
            int i23 = i3 + i4;
            unsignedShort3--;
            unsignedShort = i5;
            str6 = utf8;
            context3 = context2;
            str4 = str2;
            firstAttributeOffset = i23;
        }
        String str11 = str6;
        Context context4 = context3;
        String str12 = str4;
        String str13 = utf;
        String str14 = str7;
        Attribute attribute3 = attribute;
        classVisitor.visit(readInt(this.cpInfoOffsets[1] - 7), unsignedShort, str12, utf82, str5, strArr);
        if ((i & 2) == 0 && (str11 != null || str13 != null)) {
            classVisitor.visitSource(str11, str13);
        }
        if (i11 != 0) {
            context = context4;
            classReader = this;
            classReader.readModuleAttributes(classVisitor, context, i11, i12, str8);
        } else {
            context = context4;
            classReader = this;
        }
        if (str14 != null) {
            classVisitor.visitNestHost(str14);
        }
        if (i10 != 0) {
            String str15 = classReader.readClass(i10, cArr);
            int unsignedShort4 = classReader.readUnsignedShort(i10 + 2);
            classVisitor.visitOuterClass(str15,
                    unsignedShort4 == 0 ? null : classReader.readUTF8(classReader.cpInfoOffsets[unsignedShort4], cArr),
                    unsignedShort4 == 0 ? null
                            : classReader.readUTF8(classReader.cpInfoOffsets[unsignedShort4] + 2, cArr));
        }
        if (i9 != 0) {
            int unsignedShort5 = classReader.readUnsignedShort(i9);
            int elementValues = i9 + 2;
            while (true) {
                int i24 = unsignedShort5 - 1;
                if (unsignedShort5 <= 0) {
                    break;
                }
                elementValues = classReader.readElementValues(
                        classVisitor.visitAnnotation(classReader.readUTF8(elementValues, cArr), true),
                        elementValues + 2, true, cArr);
                unsignedShort5 = i24;
            }
        }
        int i25 = i13;
        if (i25 != 0) {
            int unsignedShort6 = classReader.readUnsignedShort(i25);
            int elementValues2 = i25 + 2;
            while (true) {
                int i26 = unsignedShort6 - 1;
                if (unsignedShort6 <= 0) {
                    break;
                }
                elementValues2 = classReader.readElementValues(
                        classVisitor.visitAnnotation(classReader.readUTF8(elementValues2, cArr), false),
                        elementValues2 + 2, true, cArr);
                unsignedShort6 = i26;
            }
        }
        int i27 = i14;
        if (i27 != 0) {
            int unsignedShort7 = classReader.readUnsignedShort(i27);
            int elementValues3 = i27 + 2;
            while (true) {
                int i28 = unsignedShort7 - 1;
                if (unsignedShort7 <= 0) {
                    break;
                }
                int typeAnnotationTarget = classReader.readTypeAnnotationTarget(context, elementValues3);
                elementValues3 = classReader.readElementValues(
                        classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath,
                                classReader.readUTF8(typeAnnotationTarget, cArr), true),
                        typeAnnotationTarget + 2, true, cArr);
                unsignedShort7 = i28;
            }
        }
        int i29 = i15;
        if (i29 != 0) {
            int unsignedShort8 = classReader.readUnsignedShort(i29);
            int elementValues4 = i29 + 2;
            while (true) {
                int i30 = unsignedShort8 - 1;
                if (unsignedShort8 <= 0) {
                    break;
                }
                int typeAnnotationTarget2 = classReader.readTypeAnnotationTarget(context, elementValues4);
                elementValues4 = classReader.readElementValues(
                        classVisitor.visitTypeAnnotation(context.currentTypeAnnotationTarget,
                                context.currentTypeAnnotationTargetPath,
                                classReader.readUTF8(typeAnnotationTarget2, cArr), false),
                        typeAnnotationTarget2 + 2, true, cArr);
                unsignedShort8 = i30;
            }
        }
        while (attribute3 != null) {
            Attribute attribute4 = attribute3.nextAttribute;
            attribute3.nextAttribute = null;
            classVisitor.visitAttribute(attribute3);
            attribute3 = attribute4;
        }
        int i31 = i16;
        if (i31 != 0) {
            int unsignedShort9 = classReader.readUnsignedShort(i31);
            int i32 = i31 + 2;
            while (true) {
                int i33 = unsignedShort9 - 1;
                if (unsignedShort9 <= 0) {
                    break;
                }
                classVisitor.visitNestMember(classReader.readClass(i32, cArr));
                i32 += 2;
                unsignedShort9 = i33;
            }
        }
        int i34 = i17;
        if (i34 != 0) {
            int unsignedShort10 = classReader.readUnsignedShort(i34);
            int i35 = i34 + 2;
            while (true) {
                int i36 = unsignedShort10 - 1;
                if (unsignedShort10 <= 0) {
                    break;
                }
                classVisitor.visitPermittedSubclass(classReader.readClass(i35, cArr));
                i35 += 2;
                unsignedShort10 = i36;
            }
        }
        int i37 = i18;
        if (i37 != 0) {
            int unsignedShort11 = classReader.readUnsignedShort(i37);
            int i38 = i37 + 2;
            while (true) {
                int i39 = unsignedShort11 - 1;
                if (unsignedShort11 <= 0) {
                    break;
                }
                classVisitor.visitInnerClass(classReader.readClass(i38, cArr), classReader.readClass(i38 + 2, cArr),
                        classReader.readUTF8(i38 + 4, cArr), classReader.readUnsignedShort(i38 + 6));
                i38 += 8;
                unsignedShort11 = i39;
            }
        }
        int i40 = i19;
        if (i40 != 0) {
            int unsignedShort12 = classReader.readUnsignedShort(i40);
            int recordComponent = i40 + 2;
            while (true) {
                int i41 = unsignedShort12 - 1;
                if (unsignedShort12 <= 0) {
                    break;
                }
                recordComponent = classReader.readRecordComponent(classVisitor, context, recordComponent);
                unsignedShort12 = i41;
            }
        }
        int unsignedShort13 = classReader.readUnsignedShort(i7);
        int field = i7 + 2;
        while (true) {
            int i42 = unsignedShort13 - 1;
            if (unsignedShort13 <= 0) {
                break;
            }
            field = classReader.readField(classVisitor, context, field);
            unsignedShort13 = i42;
        }
        int unsignedShort14 = classReader.readUnsignedShort(field);
        int method = field + 2;
        while (true) {
            int i43 = unsignedShort14 - 1;
            if (unsignedShort14 <= 0) {
                classVisitor.visitEnd();
                return;
            } else {
                method = classReader.readMethod(classVisitor, context, method);
                unsignedShort14 = i43;
            }
        }
    }

    /*
     * JADX WARN: Can't fix incorrect switch cases order, some code will duplicate
     */
    /*
     * JADX WARN: Found duplicated region for block: B:19:0x0056 A[PHI: r8
     * 0x0056: PHI (r8v3 int) = (r8v0 int), (r8v1 int), (r8v4 int) binds:
     * [B:12:0x0045, B:22:0x0062, B:18:0x0055] A[DONT_GENERATE, DONT_INLINE]]
     */
    public ClassReader(byte[] bArr, int i, boolean z) {
        this.classFileBuffer = bArr;
        this.b = bArr;
        if (z) {
            int i2 = i + 6;
            if (readShort(i2) > 70) {
                throw new IllegalArgumentException(stringConcat$0(readShort(i2)));
            }
        }
        int unsignedShort = readUnsignedShort(i + 8);
        this.cpInfoOffsets = new int[unsignedShort];
        this.constantUtf8Values = new String[unsignedShort];
        int i3 = i + 10;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = 1;
        while (i5 < unsignedShort) {
            int i6 = i5 + 1;
            int i7 = i3 + 1;
            this.cpInfoOffsets[i5] = i7;
            int unsignedShort2 = 3;
            switch (bArr[i3]) {
                case 1:
                    unsignedShort2 = 3 + readUnsignedShort(i7);
                    if (unsignedShort2 > i4) {
                        i5 = i6;
                        i4 = unsignedShort2;
                    } else {
                        i5 = i6;
                    }
                    i3 += unsignedShort2;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    i5 = i6;
                    unsignedShort2 = 5;
                    i3 += unsignedShort2;
                    break;
                case 5:
                case 6:
                    i5 += 2;
                    unsignedShort2 = 9;
                    i3 += unsignedShort2;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i5 = i6;
                    i3 += unsignedShort2;
                    break;
                case 15:
                    unsignedShort2 = 4;
                    i5 = i6;
                    i3 += unsignedShort2;
                    break;
                case 17:
                    z2 = true;
                    z3 = true;
                    i5 = i6;
                    unsignedShort2 = 5;
                    i3 += unsignedShort2;
                    break;
                case 18:
                    z3 = true;
                    i5 = i6;
                    unsignedShort2 = 5;
                    i3 += unsignedShort2;
                    break;
            }
        }
        this.maxStringLength = i4;
        this.header = i3;
        this.constantDynamicValues = z2 ? new ConstantDynamic[unsignedShort] : null;
        this.bootstrapMethodOffsets = z3 ? readBootstrapMethodsAttribute(i4) : null;
    }

    private String readUtf(int i, int i2, char[] cArr) {
        int i3;
        int i4 = i2 + i;
        byte[] bArr = this.classFileBuffer;
        int i5 = 0;
        while (i < i4) {
            int i6 = i + 1;
            byte b = bArr[i];
            if ((b & 128) == 0) {
                cArr[i5] = (char) (b & JSONB.Constants.BC_SYMBOL);
                i5++;
                i = i6;
            } else {
                if ((b & 224) == 192) {
                    i3 = i5 + 1;
                    i += 2;
                    cArr[i5] = (char) (((b & 31) << 6) + (bArr[i6] & JSONB.Constants.BC_INT32_BYTE_MAX));
                } else {
                    i3 = i5 + 1;
                    int i7 = i + 2;
                    i += 3;
                    cArr[i5] = (char) (((b & dn.m) << 12) + ((bArr[i6] & JSONB.Constants.BC_INT32_BYTE_MAX) << 6)
                            + (bArr[i7] & JSONB.Constants.BC_INT32_BYTE_MAX));
                }
                i5 = i3;
            }
        }
        return new String(cArr, 0, i5);
    }

    public ClassReader(InputStream inputStream) {
        this(readStream(inputStream, false));
    }

    public ClassReader(String str) {
        this(readStream(
                ClassLoader.getSystemResourceAsStream(stringConcat$1(
                        str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'))),
                true));
    }
}
