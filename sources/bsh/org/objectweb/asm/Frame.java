package bsh.org.objectweb.asm;

import me.hd.wauxv.obf.yg;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class Frame {
    static final int APPEND_FRAME = 252;
    private static final int ARRAY_OF = 268435456;
    private static final int BOOLEAN = 16777225;
    private static final int BYTE = 16777226;
    private static final int CHAR = 16777227;
    static final int CHOP_FRAME = 248;
    private static final int CONSTANT_KIND = 16777216;
    private static final int DIM_MASK = -268435456;
    private static final int DIM_SHIFT = 28;
    private static final int DOUBLE = 16777219;
    private static final int ELEMENT_OF = -268435456;
    private static final int FLAGS_MASK = 15728640;
    private static final int FLOAT = 16777218;
    static final int FULL_FRAME = 255;
    private static final int INTEGER = 16777217;
    private static final int ITEM_ASM_BOOLEAN = 9;
    private static final int ITEM_ASM_BYTE = 10;
    private static final int ITEM_ASM_CHAR = 11;
    private static final int ITEM_ASM_SHORT = 12;
    static final int ITEM_DOUBLE = 3;
    static final int ITEM_FLOAT = 2;
    static final int ITEM_INTEGER = 1;
    static final int ITEM_LONG = 4;
    static final int ITEM_NULL = 5;
    static final int ITEM_OBJECT = 7;
    static final int ITEM_TOP = 0;
    static final int ITEM_UNINITIALIZED = 8;
    static final int ITEM_UNINITIALIZED_THIS = 6;
    private static final int KIND_MASK = 251658240;
    private static final int LOCAL_KIND = 67108864;
    private static final int LONG = 16777220;
    private static final int NULL = 16777221;
    private static final int REFERENCE_KIND = 33554432;
    static final int RESERVED = 128;
    static final int SAME_FRAME = 0;
    static final int SAME_FRAME_EXTENDED = 251;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;
    static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;
    private static final int SHORT = 16777228;
    private static final int STACK_KIND = 83886080;
    private static final int TOP = 16777216;
    private static final int TOP_IF_LONG_OR_DOUBLE_FLAG = 1048576;
    private static final int UNINITIALIZED_KIND = 50331648;
    private static final int UNINITIALIZED_THIS = 16777222;
    private static final int VALUE_MASK = 1048575;
    private int initializationCount;
    private int[] initializations;
    private int[] inputLocals;
    private int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    private short outputStackStart;
    private short outputStackTop;
    Label owner;

    public Frame(Label label) {
        this.owner = label;
    }

    private void addInitializedType(int i) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int length = this.initializations.length;
        int i2 = this.initializationCount;
        if (i2 >= length) {
            int[] iArr = new int[Math.max(i2 + 1, length * 2)];
            System.arraycopy(this.initializations, 0, iArr, 0, length);
            this.initializations = iArr;
        }
        int[] iArr2 = this.initializations;
        int i3 = this.initializationCount;
        this.initializationCount = i3 + 1;
        iArr2[i3] = i;
    }

    public static int getAbstractTypeFromApiFormat(SymbolTable symbolTable, Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() | Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE : obj instanceof String ? getAbstractTypeFromDescriptor(symbolTable, Type.getObjectType((String) obj).getDescriptor(), 0) : symbolTable.addUninitializedType("", ((Label) obj).bytecodeOffset) | UNINITIALIZED_KIND;
    }

    private static int getAbstractTypeFromDescriptor(SymbolTable symbolTable, String str, int i) {
        int iAddType;
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return FLOAT;
        }
        if (cCharAt == 'L') {
            return symbolTable.addType(yg.j(str, 1, i + 1)) | REFERENCE_KIND;
        }
        if (cCharAt != 'S') {
            if (cCharAt == 'V') {
                return 0;
            }
            if (cCharAt != 'I') {
                if (cCharAt == 'J') {
                    return LONG;
                }
                if (cCharAt != 'Z') {
                    if (cCharAt == '[') {
                        int i2 = i + 1;
                        while (str.charAt(i2) == '[') {
                            i2++;
                        }
                        char cCharAt2 = str.charAt(i2);
                        if (cCharAt2 == 'F') {
                            iAddType = FLOAT;
                        } else if (cCharAt2 == 'L') {
                            iAddType = symbolTable.addType(yg.j(str, 1, i2 + 1)) | REFERENCE_KIND;
                        } else if (cCharAt2 == 'S') {
                            iAddType = SHORT;
                        } else if (cCharAt2 == 'Z') {
                            iAddType = BOOLEAN;
                        } else if (cCharAt2 == 'I') {
                            iAddType = INTEGER;
                        } else if (cCharAt2 != 'J') {
                            switch (cCharAt2) {
                                case 'B':
                                    iAddType = BYTE;
                                    break;
                                case 'C':
                                    iAddType = CHAR;
                                    break;
                                case 'D':
                                    iAddType = DOUBLE;
                                    break;
                                default:
                                    throw new IllegalArgumentException();
                            }
                        } else {
                            iAddType = LONG;
                        }
                        return ((i2 - i) << 28) | iAddType;
                    }
                    switch (cCharAt) {
                        case 'B':
                        case 'C':
                            break;
                        case 'D':
                            return DOUBLE;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
        return INTEGER;
    }

    public static int getAbstractTypeFromInternalName(SymbolTable symbolTable, String str) {
        return symbolTable.addType(str) | REFERENCE_KIND;
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Found duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Found duplicated region for block: B:23:0x0051 A[LOOP:0: B:7:0x000d->B:23:0x0051, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:25:0x0037 A[SYNTHETIC] */
    private int getInitializedType(SymbolTable symbolTable, int i) {
        int i2;
        if (i == UNINITIALIZED_THIS || ((-16777216) & i) == UNINITIALIZED_KIND) {
            for (int i3 = 0; i3 < this.initializationCount; i3++) {
                int i4 = this.initializations[i3];
                int i5 = (-268435456) & i4;
                int i6 = KIND_MASK & i4;
                int i7 = i4 & VALUE_MASK;
                if (i6 == LOCAL_KIND) {
                    i2 = this.inputLocals[i7];
                } else {
                    if (i6 == STACK_KIND) {
                        int[] iArr = this.inputStack;
                        i2 = iArr[iArr.length - i7];
                    }
                    if (i == i4) {
                        return (i == UNINITIALIZED_THIS ? symbolTable.addType(symbolTable.getClassName()) : symbolTable.addType(symbolTable.getType(i & VALUE_MASK).value)) | REFERENCE_KIND;
                    }
                }
                i4 = i2 + i5;
                if (i == i4) {
                    return (i == UNINITIALIZED_THIS ? symbolTable.addType(symbolTable.getClassName()) : symbolTable.addType(symbolTable.getType(i & VALUE_MASK).value)) | REFERENCE_KIND;
                }
            }
        }
        return i;
    }

    private int getLocal(int i) {
        int[] iArr = this.outputLocals;
        if (iArr == null || i >= iArr.length) {
            return i | LOCAL_KIND;
        }
        int i2 = iArr[i];
        if (i2 != 0) {
            return i2;
        }
        int i3 = LOCAL_KIND | i;
        iArr[i] = i3;
        return i3;
    }

    private int pop() {
        short s = this.outputStackTop;
        if (s <= 0) {
            short s2 = (short) (this.outputStackStart - 1);
            this.outputStackStart = s2;
            return (-s2) | STACK_KIND;
        }
        int[] iArr = this.outputStack;
        short s3 = (short) (s - 1);
        this.outputStackTop = s3;
        return iArr[s3];
    }

    private void push(int i) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int length = this.outputStack.length;
        short s = this.outputStackTop;
        if (s >= length) {
            int[] iArr = new int[Math.max(s + 1, length * 2)];
            System.arraycopy(this.outputStack, 0, iArr, 0, length);
            this.outputStack = iArr;
        }
        int[] iArr2 = this.outputStack;
        short s2 = this.outputStackTop;
        short s3 = (short) (s2 + 1);
        this.outputStackTop = s3;
        iArr2[s2] = i;
        short s4 = (short) (this.outputStackStart + s3);
        Label label = this.owner;
        if (s4 > label.outputStackMax) {
            label.outputStackMax = s4;
        }
    }

    public static void putAbstractType(SymbolTable symbolTable, int i, ByteVector byteVector) {
        int i2 = ((-268435456) & i) >> 28;
        if (i2 == 0) {
            int i3 = i & VALUE_MASK;
            int i4 = i & KIND_MASK;
            if (i4 == 16777216) {
                byteVector.putByte(i3);
                return;
            } else if (i4 == REFERENCE_KIND) {
                byteVector.putByte(7).putShort(symbolTable.addConstantClass(symbolTable.getType(i3).value).index);
                return;
            } else {
                if (i4 != UNINITIALIZED_KIND) {
                    throw new AssertionError();
                }
                byteVector.putByte(8).putShort((int) symbolTable.getType(i3).data);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                break;
            }
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            i2 = i5;
        }
        if ((i & KIND_MASK) == REFERENCE_KIND) {
            sb.append('L');
            sb.append(symbolTable.getType(i & VALUE_MASK).value);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
        } else {
            int i6 = i & VALUE_MASK;
            if (i6 == 1) {
                sb.append('I');
            } else if (i6 == 2) {
                sb.append('F');
            } else if (i6 == 3) {
                sb.append('D');
            } else if (i6 != 4) {
                switch (i6) {
                    case 9:
                        sb.append('Z');
                        break;
                    case 10:
                        sb.append('B');
                        break;
                    case 11:
                        sb.append('C');
                        break;
                    case 12:
                        sb.append('S');
                        break;
                    default:
                        throw new AssertionError();
                }
            } else {
                sb.append('J');
            }
        }
        byteVector.putByte(7).putShort(symbolTable.addConstantClass(sb.toString()).index);
    }

    private void setLocal(int i, int i2) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int length = this.outputLocals.length;
        if (i >= length) {
            int[] iArr = new int[Math.max(i + 1, length * 2)];
            System.arraycopy(this.outputLocals, 0, iArr, 0, length);
            this.outputLocals = iArr;
        }
        this.outputLocals[i] = i2;
    }

    public final void accept(MethodWriter methodWriter) {
        int[] iArr = this.inputLocals;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i2 >= iArr.length) {
                break;
            }
            int i6 = iArr[i2];
            if (i6 != LONG && i6 != DOUBLE) {
                i5 = 1;
            }
            i2 += i5;
            if (i6 == 16777216) {
                i4++;
            } else {
                i3 += i4 + 1;
                i4 = 0;
            }
        }
        int[] iArr2 = this.inputStack;
        int i7 = 0;
        int i8 = 0;
        while (i7 < iArr2.length) {
            int i9 = iArr2[i7];
            i7 += (i9 == LONG || i9 == DOUBLE) ? 2 : 1;
            i8++;
        }
        int iVisitFrameStart = methodWriter.visitFrameStart(this.owner.bytecodeOffset, i3, i8);
        int i10 = 0;
        while (true) {
            int i11 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            int i12 = iArr[i10];
            i10 += (i12 == LONG || i12 == DOUBLE) ? 2 : 1;
            methodWriter.visitAbstractType(iVisitFrameStart, i12);
            i3 = i11;
            iVisitFrameStart++;
        }
        while (true) {
            int i13 = i8 - 1;
            if (i8 <= 0) {
                methodWriter.visitFrameEnd();
                return;
            }
            int i14 = iArr2[i];
            i += (i14 == LONG || i14 == DOUBLE) ? 2 : 1;
            methodWriter.visitAbstractType(iVisitFrameStart, i14);
            iVisitFrameStart++;
            i8 = i13;
        }
    }

    public final void copyFrom(Frame frame) {
        this.inputLocals = frame.inputLocals;
        this.inputStack = frame.inputStack;
        this.outputStackStart = (short) 0;
        this.outputLocals = frame.outputLocals;
        this.outputStack = frame.outputStack;
        this.outputStackTop = frame.outputStackTop;
        this.initializationCount = frame.initializationCount;
        this.initializations = frame.initializations;
    }

    /* JADX WARN: Found duplicated region for block: B:141:0x027e  */
    /* JADX WARN: Found duplicated region for block: B:143:0x0288  */
    /* JADX WARN: Found duplicated region for block: B:145:0x028f  */
    /* JADX WARN: Found duplicated region for block: B:147:0x0299  */
    /* JADX WARN: Found duplicated region for block: B:174:0x0304  */
    /* JADX WARN: Found duplicated region for block: B:176:0x030b  */
    /* JADX WARN: Found duplicated region for block: B:178:0x030f  */
    /* JADX WARN: Found duplicated region for block: B:180:0x0316  */
    public void execute(int i, int i2, Symbol symbol, SymbolTable symbolTable) {
        switch (i) {
            case 0:
                return;
            case 1:
                push(NULL);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
                push(INTEGER);
                return;
            case 9:
            case 10:
                push(LONG);
                push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                return;
            case 11:
            case 12:
            case 13:
                push(FLOAT);
                return;
            case 14:
            case 15:
                push(DOUBLE);
                push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                return;
            case 18:
                int i3 = symbol.tag;
                switch (i3) {
                    case 3:
                        push(INTEGER);
                        return;
                    case 4:
                        push(FLOAT);
                        return;
                    case 5:
                        push(LONG);
                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                        return;
                    case 6:
                        push(DOUBLE);
                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                        return;
                    case 7:
                        push(symbolTable.addType(TypeProxy.SilentConstruction.Appender.JAVA_LANG_CLASS_INTERNAL_NAME) | REFERENCE_KIND);
                        return;
                    case 8:
                        push(symbolTable.addType("java/lang/String") | REFERENCE_KIND);
                        return;
                    default:
                        switch (i3) {
                            case 15:
                                push(symbolTable.addType("java/lang/invoke/MethodHandle") | REFERENCE_KIND);
                                return;
                            case 16:
                                push(symbolTable.addType("java/lang/invoke/MethodType") | REFERENCE_KIND);
                                return;
                            case 17:
                                push(symbolTable, symbol.value);
                                return;
                            default:
                                throw new AssertionError();
                        }
                }
            default:
                switch (i) {
                    case 21:
                        push(INTEGER);
                        return;
                    case 22:
                        push(LONG);
                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                        return;
                    case 23:
                        push(FLOAT);
                        return;
                    case 24:
                        push(DOUBLE);
                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                        return;
                    case 25:
                        push(getLocal(i2));
                        return;
                    default:
                        switch (i) {
                            case 46:
                            case 51:
                            case 52:
                            case 53:
                                pop(2);
                                push(INTEGER);
                                return;
                            case 47:
                                pop(2);
                                push(LONG);
                                push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                return;
                            case 48:
                                pop(2);
                                push(FLOAT);
                                return;
                            case 49:
                                pop(2);
                                push(DOUBLE);
                                push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                return;
                            case 50:
                                pop(1);
                                int iPop = pop();
                                if (iPop != NULL) {
                                    iPop -= 268435456;
                                }
                                push(iPop);
                                return;
                            case 54:
                            case 56:
                            case 58:
                                setLocal(i2, pop());
                                if (i2 > 0) {
                                    int i4 = i2 - 1;
                                    int local = getLocal(i4);
                                    if (local == LONG || local == DOUBLE) {
                                        setLocal(i4, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    }
                                    int i5 = local & KIND_MASK;
                                    if (i5 == LOCAL_KIND || i5 == STACK_KIND) {
                                        setLocal(i4, local | TOP_IF_LONG_OR_DOUBLE_FLAG);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            case 55:
                            case 57:
                                pop(1);
                                setLocal(i2, pop());
                                setLocal(i2 + 1, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                if (i2 > 0) {
                                    int i6 = i2 - 1;
                                    int local2 = getLocal(i6);
                                    if (local2 == LONG || local2 == DOUBLE) {
                                        setLocal(i6, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    }
                                    int i7 = local2 & KIND_MASK;
                                    if (i7 == LOCAL_KIND || i7 == STACK_KIND) {
                                        setLocal(i6, local2 | TOP_IF_LONG_OR_DOUBLE_FLAG);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                switch (i) {
                                    case 79:
                                    case 81:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                        pop(3);
                                        return;
                                    case 80:
                                    case 82:
                                        pop(4);
                                        return;
                                    case 87:
                                    case 153:
                                    case 154:
                                    case 155:
                                    case 156:
                                    case 157:
                                    case 158:
                                    case 170:
                                    case 171:
                                    case 172:
                                    case 174:
                                    case 176:
                                    case 191:
                                    case 194:
                                    case 195:
                                        break;
                                    case 88:
                                    case 159:
                                    case 160:
                                    case 161:
                                    case 162:
                                    case 163:
                                    case 164:
                                    case 165:
                                    case 166:
                                    case 173:
                                    case 175:
                                        pop(2);
                                        return;
                                    case 89:
                                        int iPop2 = pop();
                                        push(iPop2);
                                        push(iPop2);
                                        return;
                                    case 90:
                                        int iPop3 = pop();
                                        int iPop4 = pop();
                                        push(iPop3);
                                        push(iPop4);
                                        push(iPop3);
                                        return;
                                    case 91:
                                        int iPop5 = pop();
                                        int iPop6 = pop();
                                        int iPop7 = pop();
                                        push(iPop5);
                                        push(iPop7);
                                        push(iPop6);
                                        push(iPop5);
                                        return;
                                    case 92:
                                        int iPop8 = pop();
                                        int iPop9 = pop();
                                        push(iPop9);
                                        push(iPop8);
                                        push(iPop9);
                                        push(iPop8);
                                        return;
                                    case 93:
                                        int iPop10 = pop();
                                        int iPop11 = pop();
                                        int iPop12 = pop();
                                        push(iPop11);
                                        push(iPop10);
                                        push(iPop12);
                                        push(iPop11);
                                        push(iPop10);
                                        return;
                                    case 94:
                                        int iPop13 = pop();
                                        int iPop14 = pop();
                                        int iPop15 = pop();
                                        int iPop16 = pop();
                                        push(iPop14);
                                        push(iPop13);
                                        push(iPop16);
                                        push(iPop15);
                                        push(iPop14);
                                        push(iPop13);
                                        return;
                                    case 95:
                                        int iPop17 = pop();
                                        int iPop18 = pop();
                                        push(iPop17);
                                        push(iPop18);
                                        return;
                                    case 96:
                                    case 100:
                                    case 104:
                                    case 108:
                                    case 112:
                                    case 120:
                                    case 122:
                                    case 124:
                                    case 126:
                                    case 128:
                                    case 130:
                                    case 136:
                                    case 142:
                                    case 149:
                                    case 150:
                                        pop(2);
                                        push(INTEGER);
                                        return;
                                    case 97:
                                    case 101:
                                    case 105:
                                    case 109:
                                    case 113:
                                    case 127:
                                    case 129:
                                    case 131:
                                        pop(4);
                                        push(LONG);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 98:
                                    case 102:
                                    case 106:
                                    case 110:
                                    case 114:
                                    case 137:
                                    case 144:
                                        pop(2);
                                        push(FLOAT);
                                        return;
                                    case 99:
                                    case 103:
                                    case 107:
                                    case 111:
                                    case 115:
                                        pop(4);
                                        push(DOUBLE);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 145:
                                    case 146:
                                    case 147:
                                    case 167:
                                    case 177:
                                        return;
                                    case 121:
                                    case 123:
                                    case 125:
                                        pop(3);
                                        push(LONG);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 132:
                                        setLocal(i2, INTEGER);
                                        return;
                                    case 133:
                                    case 140:
                                        pop(1);
                                        push(LONG);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 134:
                                        pop(1);
                                        push(FLOAT);
                                        return;
                                    case 135:
                                    case 141:
                                        pop(1);
                                        push(DOUBLE);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 138:
                                        pop(2);
                                        push(DOUBLE);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 139:
                                    case 190:
                                    case 193:
                                        pop(1);
                                        push(INTEGER);
                                        return;
                                    case 143:
                                        pop(2);
                                        push(LONG);
                                        push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
                                        return;
                                    case 148:
                                    case 151:
                                    case 152:
                                        pop(4);
                                        push(INTEGER);
                                        return;
                                    case 168:
                                    case 169:
                                        throw new IllegalArgumentException("JSR/RET are not supported with computeFrames option");
                                    case 178:
                                        push(symbolTable, symbol.value);
                                        return;
                                    case 179:
                                        pop(symbol.value);
                                        return;
                                    case 180:
                                        pop(1);
                                        push(symbolTable, symbol.value);
                                        return;
                                    case 181:
                                        pop(symbol.value);
                                        pop();
                                        return;
                                    case 182:
                                    case 183:
                                    case 184:
                                    case 185:
                                        pop(symbol.value);
                                        if (i != 184) {
                                            int iPop19 = pop();
                                            if (i == 183 && symbol.name.charAt(0) == '<') {
                                                addInitializedType(iPop19);
                                            }
                                        }
                                        push(symbolTable, symbol.value);
                                        return;
                                    case 186:
                                        pop(symbol.value);
                                        push(symbolTable, symbol.value);
                                        return;
                                    case 187:
                                        push(symbolTable.addUninitializedType(symbol.value, i2) | UNINITIALIZED_KIND);
                                        return;
                                    case 188:
                                        pop();
                                        switch (i2) {
                                            case 4:
                                                push(285212681);
                                                return;
                                            case 5:
                                                push(285212683);
                                                return;
                                            case 6:
                                                push(285212674);
                                                return;
                                            case 7:
                                                push(285212675);
                                                return;
                                            case 8:
                                                push(285212682);
                                                return;
                                            case 9:
                                                push(285212684);
                                                return;
                                            case 10:
                                                push(285212673);
                                                return;
                                            case 11:
                                                push(285212676);
                                                return;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                    case 189:
                                        String str = symbol.value;
                                        pop();
                                        if (str.charAt(0) == '[') {
                                            push(symbolTable, "[".concat(str));
                                            return;
                                        } else {
                                            push(symbolTable.addType(str) | 301989888);
                                            return;
                                        }
                                    case 192:
                                        String str2 = symbol.value;
                                        pop();
                                        if (str2.charAt(0) == '[') {
                                            push(symbolTable, str2);
                                            return;
                                        } else {
                                            push(symbolTable.addType(str2) | REFERENCE_KIND);
                                            return;
                                        }
                                    default:
                                        switch (i) {
                                            case 197:
                                                pop(i2);
                                                push(symbolTable, symbol.value);
                                                return;
                                            case 198:
                                            case 199:
                                                break;
                                            default:
                                                throw new IllegalArgumentException();
                                        }
                                        break;
                                }
                                pop(1);
                                return;
                        }
                }
        }
    }

    public final int getInputStackSize() {
        return this.inputStack.length;
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Found duplicated region for block: B:65:0x00f7  */
    /* JADX WARN: Found duplicated region for block: B:66:0x00fa A[PHI: r6
      0x00fa: PHI (r6v8 int) = (r6v7 int), (r6v7 int), (r6v11 int), (r6v11 int) binds: [B:69:0x0109, B:71:0x010d, B:62:0x00f1, B:64:0x00f5] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean merge(SymbolTable symbolTable, Frame frame, int i) {
        boolean zMerge;
        int i2;
        int initializedType;
        int i3;
        int length = this.inputLocals.length;
        int length2 = this.inputStack.length;
        boolean zMerge2 = true;
        if (frame.inputLocals == null) {
            frame.inputLocals = new int[length];
            zMerge = true;
        } else {
            zMerge = false;
        }
        int i4 = 0;
        while (i4 < length) {
            int[] iArr = this.outputLocals;
            if (iArr == null || i4 >= iArr.length || (i3 = iArr[i4]) == 0) {
                initializedType = this.inputLocals[i4];
            } else {
                int i5 = i3 & (-268435456);
                int i6 = i3 & KIND_MASK;
                if (i6 == LOCAL_KIND) {
                    initializedType = i5 + this.inputLocals[i3 & VALUE_MASK];
                    if ((i3 & TOP_IF_LONG_OR_DOUBLE_FLAG) != 0 && (initializedType == LONG || initializedType == DOUBLE)) {
                        initializedType = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                    }
                } else if (i6 == STACK_KIND) {
                    initializedType = i5 + this.inputStack[length2 - (i3 & VALUE_MASK)];
                    if ((i3 & TOP_IF_LONG_OR_DOUBLE_FLAG) != 0 && (initializedType == LONG || initializedType == DOUBLE)) {
                        initializedType = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
                    }
                } else {
                    initializedType = i3;
                }
            }
            if (this.initializations != null) {
                initializedType = getInitializedType(symbolTable, initializedType);
            }
            zMerge |= merge(symbolTable, initializedType, frame.inputLocals, i4);
            i4++;
        }
        if (i > 0) {
            for (int i7 = 0; i7 < length; i7++) {
                zMerge |= merge(symbolTable, this.inputLocals[i7], frame.inputLocals, i7);
            }
            if (frame.inputStack == null) {
                frame.inputStack = new int[1];
            } else {
                zMerge2 = zMerge;
            }
            return merge(symbolTable, i, frame.inputStack, 0) | zMerge2;
        }
        int length3 = this.inputStack.length + this.outputStackStart;
        if (frame.inputStack == null) {
            frame.inputStack = new int[this.outputStackTop + length3];
        } else {
            zMerge2 = zMerge;
        }
        for (int i8 = 0; i8 < length3; i8++) {
            int initializedType2 = this.inputStack[i8];
            if (this.initializations != null) {
                initializedType2 = getInitializedType(symbolTable, initializedType2);
            }
            zMerge2 |= merge(symbolTable, initializedType2, frame.inputStack, i8);
        }
        for (int i9 = 0; i9 < this.outputStackTop; i9++) {
            int initializedType3 = this.outputStack[i9];
            int i10 = initializedType3 & (-268435456);
            int i11 = initializedType3 & KIND_MASK;
            if (i11 == LOCAL_KIND) {
                i2 = i10 + this.inputLocals[initializedType3 & VALUE_MASK];
                initializedType3 = ((initializedType3 & TOP_IF_LONG_OR_DOUBLE_FLAG) == 0 || !(i2 == LONG || i2 == DOUBLE)) ? i2 : Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
            } else if (i11 == STACK_KIND) {
                i2 = i10 + this.inputStack[length2 - (initializedType3 & VALUE_MASK)];
                if ((initializedType3 & TOP_IF_LONG_OR_DOUBLE_FLAG) == 0 || (i2 != LONG && i2 != DOUBLE)) {
                }
            }
            if (this.initializations != null) {
                initializedType3 = getInitializedType(symbolTable, initializedType3);
            }
            zMerge2 |= merge(symbolTable, initializedType3, frame.inputStack, length3 + i9);
        }
        return zMerge2;
    }

    public final void setInputFrameFromApiFormat(SymbolTable symbolTable, int i, Object[] objArr, int i2, Object[] objArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i3 + 1;
            this.inputLocals[i3] = getAbstractTypeFromApiFormat(symbolTable, objArr[i4]);
            Object obj = objArr[i4];
            if (obj == Opcodes.LONG || obj == Opcodes.DOUBLE) {
                i3 += 2;
                this.inputLocals[i5] = 16777216;
            } else {
                i3 = i5;
            }
        }
        while (true) {
            int[] iArr = this.inputLocals;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = 16777216;
            i3++;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i2; i7++) {
            Object obj2 = objArr2[i7];
            if (obj2 == Opcodes.LONG || obj2 == Opcodes.DOUBLE) {
                i6++;
            }
        }
        this.inputStack = new int[i6 + i2];
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i8 + 1;
            this.inputStack[i8] = getAbstractTypeFromApiFormat(symbolTable, objArr2[i9]);
            Object obj3 = objArr2[i9];
            if (obj3 == Opcodes.LONG || obj3 == Opcodes.DOUBLE) {
                i8 += 2;
                this.inputStack[i10] = 16777216;
            } else {
                i8 = i10;
            }
        }
        this.outputStackTop = (short) 0;
        this.initializationCount = 0;
    }

    public final void setInputFrameFromDescriptor(SymbolTable symbolTable, int i, String str, int i2) {
        int i3;
        int[] iArr = new int[i2];
        this.inputLocals = iArr;
        this.inputStack = new int[0];
        if ((i & 8) == 0) {
            i3 = 1;
            if ((i & 262144) == 0) {
                iArr[0] = symbolTable.addType(symbolTable.getClassName()) | REFERENCE_KIND;
            } else {
                iArr[0] = UNINITIALIZED_THIS;
            }
        } else {
            i3 = 0;
        }
        for (Type type : Type.getArgumentTypes(str)) {
            int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, type.getDescriptor(), 0);
            int[] iArr2 = this.inputLocals;
            int i4 = i3 + 1;
            iArr2[i3] = abstractTypeFromDescriptor;
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                i3 += 2;
                iArr2[i4] = 16777216;
            } else {
                i3 = i4;
            }
        }
        while (i3 < i2) {
            this.inputLocals[i3] = 16777216;
            i3++;
        }
    }

    private void pop(int i) {
        short s = this.outputStackTop;
        if (s >= i) {
            this.outputStackTop = (short) (s - i);
        } else {
            this.outputStackStart = (short) (this.outputStackStart - (i - s));
            this.outputStackTop = (short) 0;
        }
    }

    private void pop(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt == '(') {
            pop((Type.getArgumentsAndReturnSizes(str) >> 2) - 1);
        } else if (cCharAt != 'J' && cCharAt != 'D') {
            pop(1);
        } else {
            pop(2);
        }
    }

    private void push(SymbolTable symbolTable, String str) {
        int abstractTypeFromDescriptor = getAbstractTypeFromDescriptor(symbolTable, str, str.charAt(0) == '(' ? str.indexOf(41) + 1 : 0);
        if (abstractTypeFromDescriptor != 0) {
            push(abstractTypeFromDescriptor);
            if (abstractTypeFromDescriptor == LONG || abstractTypeFromDescriptor == DOUBLE) {
                push(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            }
        }
    }

    private static boolean merge(SymbolTable symbolTable, int i, int[] iArr, int i2) {
        int iMin;
        int iAddType;
        int i3 = iArr[i2];
        if (i3 == i) {
            return false;
        }
        if ((268435455 & i) == NULL) {
            if (i3 == NULL) {
                return false;
            }
            i = NULL;
        }
        if (i3 == 0) {
            iArr[i2] = i;
            return true;
        }
        int i4 = i3 & (-268435456);
        int iAddMergedType = Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        if (i4 != 0 || (i3 & KIND_MASK) == REFERENCE_KIND) {
            if (i == NULL) {
                return false;
            }
            if ((i & (-16777216)) != ((-16777216) & i3)) {
                int i5 = i & (-268435456);
                if (i5 != 0 || (i & KIND_MASK) == REFERENCE_KIND) {
                    if (i5 != 0 && (i & KIND_MASK) != REFERENCE_KIND) {
                        i5 -= 268435456;
                    }
                    if (i4 != 0 && (i3 & KIND_MASK) != REFERENCE_KIND) {
                        i4 -= 268435456;
                    }
                    iMin = Math.min(i5, i4) | REFERENCE_KIND;
                    iAddType = symbolTable.addType("java/lang/Object");
                    iAddMergedType = iMin | iAddType;
                }
            } else if ((i3 & KIND_MASK) == REFERENCE_KIND) {
                iAddMergedType = (i & (-268435456)) | REFERENCE_KIND | symbolTable.addMergedType(i & VALUE_MASK, VALUE_MASK & i3);
            } else {
                iMin = ((i & (-268435456)) - 268435456) | REFERENCE_KIND;
                iAddType = symbolTable.addType("java/lang/Object");
                iAddMergedType = iMin | iAddType;
            }
        } else if (i3 == NULL) {
            if ((i & (-268435456)) == 0 && (i & KIND_MASK) != REFERENCE_KIND) {
                i = 16777216;
            }
            iAddMergedType = i;
        }
        if (iAddMergedType == i3) {
            return false;
        }
        iArr[i2] = iAddMergedType;
        return true;
    }
}
