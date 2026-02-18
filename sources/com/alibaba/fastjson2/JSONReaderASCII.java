package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.android.dx.io.Opcodes;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.function.BiFunction;
import me.hd.wauxv.obf.bjs;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class JSONReaderASCII extends JSONReaderUTF8 {
    final String str;

    public JSONReaderASCII(JSONReader.Context context, String str, byte[] bArr, int i, int i2) {
        super(context, bArr, i, i2);
        this.str = str;
        this.nameAscii = true;
    }

    public static JSONReaderASCII of(JSONReader.Context context, String str, byte[] bArr, int i, int i2) {
        return new JSONReaderASCII(context, str, bArr, i, i2);
    }

    /* JADX WARN: Found duplicated region for block: B:42:0x0094 */
    /* JADX WARN: Found duplicated region for block: B:42:0x0094 A[FALL_THROUGH] */
    /* JADX WARN: Found duplicated region for block: B:48:0x00a6 */
    /* JADX WARN: Found duplicated region for block: B:67:0x00fe A[FALL_THROUGH] */
    /*
     * JADX WARN: Switch 'out' block B:42:0x0094 for B:32:0x0062 already processed.
     * Defaulting to fallback option.
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final String getFieldName() {
        int iHexDigit4;
        byte[] bArr = this.bytes;
        int i = this.nameBegin;
        int i2 = this.nameEnd;
        int i3 = i2 - i;
        if (!this.nameEscape) {
            String str = this.str;
            return str != null ? str.substring(i, i2)
                    : JDKUtils.ANDROID ? getLatin1String(i, i3) : new String(bArr, i, i3, StandardCharsets.ISO_8859_1);
        }
        byte b = 34;
        if (JDKUtils.STRING_CREATOR_JDK11 != null) {
            byte[] bArr2 = new byte[this.nameLength];
            int i4 = this.end;
            int i5 = 0;
            while (i < this.nameEnd) {
                byte bChar1 = bArr[i];
                if (bChar1 == 92) {
                    int i6 = i + 1;
                    byte b2 = bArr[i6];
                    if (b2 == b || b2 == 58 || b2 == 64 || b2 == 92) {
                        i = i6;
                        bChar1 = b2;
                    } else if (b2 == 117) {
                        iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i + 2, i4));
                        i += 5;
                        if (iHexDigit4 > 255) {
                            bArr2 = null;
                            if (bArr2 != null) {
                                return JDKUtils.STRING_CREATOR_JDK11.apply(bArr2, JDKUtils.LATIN1);
                            }
                        }
                        bChar1 = (byte) iHexDigit4;
                    } else if (b2 == 120) {
                        byte b3 = bArr[i + 2];
                        i += 3;
                        iHexDigit4 = JSONReader.char2(b3, bArr[i]);
                        if (iHexDigit4 > 255) {
                            bArr2 = null;
                            if (bArr2 != null) {
                                return JDKUtils.STRING_CREATOR_JDK11.apply(bArr2, JDKUtils.LATIN1);
                            }
                        }
                        bChar1 = (byte) iHexDigit4;
                    } else if (b2 != 42 && b2 != 43) {
                        switch (b2) {
                            default:
                                switch (b2) {
                                    case 60:
                                    case 61:
                                    case 62:
                                        break;
                                    default:
                                        bChar1 = (byte) char1(b2);
                                        i = i6;
                                        continue;
                                }
                            case 45:
                            case 46:
                            case 47:
                                i = i6;
                                bChar1 = b2;
                                break;
                        }
                    } else {
                        i = i6;
                        bChar1 = b2;
                    }
                    bArr2[i5] = bChar1;
                    i++;
                    i5++;
                    b = 34;
                } else if (bChar1 != b) {
                    bArr2[i5] = bChar1;
                    i++;
                    i5++;
                    b = 34;
                } else if (bArr2 != null) {
                    return JDKUtils.STRING_CREATOR_JDK11.apply(bArr2, JDKUtils.LATIN1);
                }
            }
            if (bArr2 != null) {
                return JDKUtils.STRING_CREATOR_JDK11.apply(bArr2, JDKUtils.LATIN1);
            }
        }
        int i7 = this.nameBegin;
        char[] cArr = new char[this.nameLength];
        int i8 = 0;
        while (i7 < this.nameEnd) {
            char cHexDigit4 = (char) (bArr[i7] & 255);
            if (cHexDigit4 == '\\') {
                int i9 = i7 + 1;
                char c = (char) bArr[i9];
                if (c == '*' || c == '+' || c == '@') {
                    i7 = i9;
                    cHexDigit4 = c;
                } else if (c == 'u') {
                    cHexDigit4 = (char) IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i7 + 2, this.end));
                    i7 += 5;
                } else if (c != 'x') {
                    switch (c) {
                        default:
                            switch (c) {
                                case '<':
                                case '=':
                                case '>':
                                    break;
                                default:
                                    cHexDigit4 = char1(c);
                                    i7 = i9;
                                    break;
                            }
                        case '-':
                        case '.':
                        case '/':
                            i7 = i9;
                            cHexDigit4 = c;
                            break;
                    }
                } else {
                    byte b4 = bArr[i7 + 2];
                    i7 += 3;
                    cHexDigit4 = JSONReader.char2(b4, bArr[i7]);
                }
            } else if (cHexDigit4 == '\"') {
                return new String(cArr);
            }
            cArr[i8] = cHexDigit4;
            i7++;
            i8++;
        }
        return new String(cArr);
    }

    /* JADX WARN: Found duplicated region for block: B:102:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:60:0x00e6 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:61:0x00e7 */
    /* JADX WARN: Found duplicated region for block: B:63:0x00ee */
    /* JADX WARN: Found duplicated region for block: B:65:0x00f4 */
    /* JADX WARN: Found duplicated region for block: B:67:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:68:0x00fc A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:69:0x0106 */
    /* JADX WARN: Found duplicated region for block: B:70:0x0113 */
    /* JADX WARN: Found duplicated region for block: B:71:0x0120 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:75:0x0127 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:79:0x012e */
    /* JADX WARN: Found duplicated region for block: B:80:0x0131 */
    /*
     * JADX WARN: Found duplicated region for block: B:84:0x0139 A[ADDED_TO_REGION]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:88:0x0142 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:91:0x0149 */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final long getNameHashCodeLCase() {
        long j;
        int iHexDigit4;
        int i;
        int i2;
        int i3;
        int i4;
        long j2;
        long j3;
        byte[] bArr = this.bytes;
        int i5 = this.nameBegin;
        int i6 = this.end;
        char c = '\"';
        int i7 = (i5 <= 0 || bArr[i5 + (-1)] != '\'') ? '\"' : '\'';
        int i8 = 0;
        long j4 = 0;
        while (i5 < i6) {
            int iHexDigit42 = bArr[i5];
            if (iHexDigit42 != 92) {
                if (iHexDigit42 == i7) {
                }
                if (j4 != 0) {
                    return j4;
                }
                j = Fnv.MAGIC_HASH_CODE;
                while (i5 < i6) {
                    iHexDigit4 = bArr[i5];
                    if (iHexDigit4 == 92) {
                        i2 = i5 + 1;
                        i3 = bArr[i2];
                        if (i3 == 117) {
                            iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i5 + 2, i6));
                            i5 += 5;
                        } else if (i3 != 120) {
                            iHexDigit4 = char1(i3);
                            i5 = i2;
                        } else {
                            int i9 = bArr[i5 + 2];
                            i5 += 3;
                            iHexDigit4 = JSONReader.char2(i9, bArr[i5]);
                        }
                    } else if (iHexDigit4 == i7) {
                        return j;
                    }
                    i5++;
                    if ((iHexDigit4 != 95 || iHexDigit4 == 45 || iHexDigit4 == 32) && (i = bArr[i5]) != c) {
                        if (i != 39 || i == iHexDigit4) {
                        }
                        c = '\"';
                    }
                    if (iHexDigit4 >= 65 && iHexDigit4 <= 90) {
                        iHexDigit4 = (char) (iHexDigit4 + 32);
                    }
                    if (iHexDigit4 < 0) {
                        iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                    }
                    j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                    i7 = i7;
                    c = '\"';
                }
                return j;
            }
            int i10 = i5 + 1;
            int i11 = bArr[i10];
            if (i11 == 117) {
                iHexDigit42 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i5 + 2, i6));
                i5 += 5;
            } else if (i11 != 120) {
                iHexDigit42 = char1(i11);
                i5 = i10;
            } else {
                int i12 = bArr[i5 + 2];
                i5 += 3;
                iHexDigit42 = JSONReader.char2(i12, bArr[i5]);
            }
            if (iHexDigit42 > 255 || iHexDigit42 < 0 || i8 >= 8 || (i8 == 0 && iHexDigit42 == 0)) {
                i5 = this.nameBegin;
                j4 = 0;
                if (j4 != 0) {
                    return j4;
                }
                j = Fnv.MAGIC_HASH_CODE;
                while (i5 < i6) {
                    iHexDigit4 = bArr[i5];
                    if (iHexDigit4 == 92) {
                        i2 = i5 + 1;
                        i3 = bArr[i2];
                        if (i3 == 117) {
                            iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i5 + 2, i6));
                            i5 += 5;
                        } else if (i3 != 120) {
                            iHexDigit4 = char1(i3);
                            i5 = i2;
                        } else {
                            int i92 = bArr[i5 + 2];
                            i5 += 3;
                            iHexDigit4 = JSONReader.char2(i92, bArr[i5]);
                        }
                    } else if (iHexDigit4 == i7) {
                        return j;
                    }
                    i5++;
                    if (iHexDigit4 != 95) {
                        if (i != 39) {
                            if (iHexDigit4 >= 65) {
                                iHexDigit4 = (char) (iHexDigit4 + 32);
                            }
                            if (iHexDigit4 < 0) {
                                iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                            }
                            j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                            i7 = i7;
                        } else {
                            if (iHexDigit4 >= 65) {
                                iHexDigit4 = (char) (iHexDigit4 + 32);
                            }
                            if (iHexDigit4 < 0) {
                                iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                            }
                            j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                            i7 = i7;
                        }
                    } else if (i != 39) {
                        if (iHexDigit4 >= 65) {
                            iHexDigit4 = (char) (iHexDigit4 + 32);
                        }
                        if (iHexDigit4 < 0) {
                            iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                        }
                        j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                        i7 = i7;
                    } else {
                        if (iHexDigit4 >= 65) {
                            iHexDigit4 = (char) (iHexDigit4 + 32);
                        }
                        if (iHexDigit4 < 0) {
                            iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                        }
                        j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                        i7 = i7;
                    }
                    c = '\"';
                }
                return j;
            }
            if ((iHexDigit42 != 95 && iHexDigit42 != 45 && iHexDigit42 != 32) || (i4 = bArr[i5 + 1]) == 34 || i4 == 39
                    || i4 == iHexDigit42) {
                if (iHexDigit42 >= 65 && iHexDigit42 <= 90) {
                    iHexDigit42 = (char) (iHexDigit42 + 32);
                }
                switch (i8) {
                    case 0:
                        j4 = (byte) iHexDigit42;
                        break;
                    case 1:
                        j2 = ((byte) iHexDigit42) << 8;
                        j3 = 255;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 2:
                        j2 = ((byte) iHexDigit42) << 16;
                        j3 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 3:
                        j2 = ((byte) iHexDigit42) << 24;
                        j3 = 16777215;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 4:
                        j2 = ((long) ((byte) iHexDigit42)) << 32;
                        j3 = 4294967295L;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 5:
                        j2 = ((long) ((byte) iHexDigit42)) << 40;
                        j3 = 1099511627775L;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 6:
                        j2 = ((long) ((byte) iHexDigit42)) << 48;
                        j3 = 281474976710655L;
                        j4 = (j4 & j3) + j2;
                        break;
                    case 7:
                        j2 = ((long) ((byte) iHexDigit42)) << 56;
                        j3 = 72057594037927935L;
                        j4 = (j4 & j3) + j2;
                        break;
                }
                i8++;
            }
            i5++;
        }
        if (j4 != 0) {
            return j4;
        }
        j = Fnv.MAGIC_HASH_CODE;
        while (i5 < i6) {
            iHexDigit4 = bArr[i5];
            if (iHexDigit4 == 92) {
                i2 = i5 + 1;
                i3 = bArr[i2];
                if (i3 == 117) {
                    iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i5 + 2, i6));
                    i5 += 5;
                } else if (i3 != 120) {
                    iHexDigit4 = char1(i3);
                    i5 = i2;
                } else {
                    int i922 = bArr[i5 + 2];
                    i5 += 3;
                    iHexDigit4 = JSONReader.char2(i922, bArr[i5]);
                }
            } else if (iHexDigit4 == i7) {
                return j;
            }
            i5++;
            if (iHexDigit4 != 95) {
                if (i != 39) {
                    if (iHexDigit4 >= 65) {
                        iHexDigit4 = (char) (iHexDigit4 + 32);
                    }
                    if (iHexDigit4 < 0) {
                        iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                    }
                    j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                    i7 = i7;
                } else {
                    if (iHexDigit4 >= 65) {
                        iHexDigit4 = (char) (iHexDigit4 + 32);
                    }
                    if (iHexDigit4 < 0) {
                        iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                    }
                    j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                    i7 = i7;
                }
            } else if (i != 39) {
                if (iHexDigit4 >= 65) {
                    iHexDigit4 = (char) (iHexDigit4 + 32);
                }
                if (iHexDigit4 < 0) {
                    iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                }
                j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                i7 = i7;
            } else {
                if (iHexDigit4 >= 65) {
                    iHexDigit4 = (char) (iHexDigit4 + 32);
                }
                if (iHexDigit4 < 0) {
                    iHexDigit4 = (iHexDigit4 == true ? 1 : 0) & Opcodes.CONST_METHOD_TYPE;
                }
                j = Fnv.MAGIC_PRIME * (j ^ ((long) iHexDigit4));
                i7 = i7;
            }
            c = '\"';
        }
        return j;
    }

    /*
     * JADX WARN: Found duplicated region for block: B:21:0x003d A[LOOP:0:
     * B:7:0x0011->B:21:0x003d, LOOP_END, MOVE_INLINED]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:22:0x000b A[EDGE_INSN:
     * B:22:0x000b->B:5:0x000b BREAK A[LOOP:0: B:7:0x0011->B:21:0x003d], SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:8:0x0013 A[ADDED_TO_REGION]
     */
    /*
     * JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x003a ->
     * B:5:0x000b). Please report as a decompilation issue!!!
     */
    /*
     * JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
     * at block B:8:0x0013
     * at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
     * at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
     * at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(
     * NotificationAttrNode.java:19)
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final void next() {
        /*
         * r9 = this;
         * byte[] r0 = r9.bytes
         * int r1 = r9.offset
         * int r2 = r9.end
         * r3 = 26
         * if (r1 < r2) goto Ld
         * r2 = r1
         * Lb:
         * r1 = r3
         * goto L11
         * Ld:
         * int r2 = r1 + 1
         * r1 = r0[r1]
         * L11:
         * if (r1 == 0) goto L38
         * if (r1 <= 0) goto L29
         * r4 = 32
         * if (r1 > r4) goto L29
         * r4 = 1
         * long r4 = r4 << r1
         * r6 = 4294981376(0x100003700, double:2.1220027474E-314)
         * long r4 = r4 & r6
         * r6 = 0
         * int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
         * if (r4 == 0) goto L29
         * goto L38
         * L29:
         * r9.offset = r2
         * r0 = r1 & 255(0xff, float:3.57E-43)
         * char r0 = (char) r0
         * r9.ch = r0
         * r0 = 47
         * if (r1 != r0) goto L37
         * r9.skipComment()
         * L37:
         * return
         * L38:
         * int r1 = r9.end
         * if (r2 != r1) goto L3d
         * goto Lb
         * L3d:
         * int r1 = r2 + 1
         * r2 = r0[r2]
         * r8 = r2
         * r2 = r1
         * r1 = r8
         * goto L11
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.next():void");
    }

    /*
     * JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x006c ->
     * B:33:0x0050). Please report as a decompilation issue!!!
     */
    /*
     * JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit
     * block: B:36:0x0061
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(
     * LoopRegionMaker.java:272)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(
     * LoopRegionMaker.java:237)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:80)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.
     * java:48)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:25)
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final boolean nextIfNullOrEmptyString() {
        /*
         * r18 = this;
         * r0 = r18
         * char r1 = r0.ch
         * int r2 = r0.end
         * int r3 = r0.offset
         * byte[] r4 = r0.bytes
         * r5 = 110(0x6e, float:1.54E-43)
         * r6 = 0
         * r7 = 1
         * if (r1 != r5) goto L29
         * int r5 = r3 + 2
         * if (r5 >= r2) goto L29
         * r8 = r4[r3]
         * r9 = 117(0x75, float:1.64E-43)
         * if (r8 != r9) goto L29
         * int r8 = r3 + 1
         * r8 = r4[r8]
         * r9 = 108(0x6c, float:1.51E-43)
         * if (r8 != r9) goto L29
         * r5 = r4[r5]
         * if (r5 != r9) goto L29
         * int r3 = r3 + 3
         * goto L4b
         * L29:
         * r5 = 34
         * if (r1 == r5) goto L33
         * r5 = 39
         * if (r1 != r5) goto L32
         * goto L33
         * L32:
         * return r6
         * L33:
         * if (r3 >= r2) goto L3b
         * r5 = r4[r3]
         * if (r5 != r1) goto L3b
         * int r3 = r3 + r7
         * goto L4b
         * L3b:
         * int r5 = r3 + 4
         * if (r5 >= r2) goto Laa
         * boolean r8 = com.alibaba.fastjson2.util.IOUtils.isNULL(r4, r3)
         * if (r8 == 0) goto Laa
         * r5 = r4[r5]
         * if (r5 != r1) goto Laa
         * int r3 = r3 + 5
         * L4b:
         * r1 = 26
         * if (r3 != r2) goto L52
         * r5 = r3
         * L50:
         * r3 = r1
         * goto L56
         * L52:
         * int r5 = r3 + 1
         * r3 = r4[r3]
         * L56:
         * r8 = 0
         * r10 = 4294981376(0x100003700, double:2.1220027474E-314)
         * r12 = 1
         * r14 = 32
         * if (r3 < 0) goto L79
         * if (r3 > r14) goto L79
         * long r15 = r12 << r3
         * long r15 = r15 & r10
         * int r15 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
         * if (r15 == 0) goto L79
         * if (r5 != r2) goto L6f
         * goto L50
         * L6f:
         * int r3 = r5 + 1
         * r5 = r4[r5]
         * r17 = r5
         * r5 = r3
         * r3 = r17
         * goto L56
         * L79:
         * r15 = 44
         * if (r3 != r15) goto L7e
         * r6 = r7
         * L7e:
         * r0.comma = r6
         * if (r6 == 0) goto L8f
         * if (r5 != r2) goto L86
         * L84:
         * r3 = r1
         * goto L8f
         * L86:
         * int r3 = r5 + 1
         * r5 = r4[r5]
         * L8a:
         * r17 = r5
         * r5 = r3
         * r3 = r17
         * L8f:
         * if (r3 < 0) goto La2
         * if (r3 > r14) goto La2
         * long r15 = r12 << r3
         * long r15 = r15 & r10
         * int r6 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
         * if (r6 == 0) goto La2
         * if (r5 != r2) goto L9d
         * goto L84
         * L9d:
         * int r3 = r5 + 1
         * r5 = r4[r5]
         * goto L8a
         * La2:
         * r0.offset = r5
         * r1 = r3 & 255(0xff, float:3.57E-43)
         * char r1 = (char) r1
         * r0.ch = r1
         * return r7
         * Laa:
         * return r6
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.nextIfNullOrEmptyString():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001b */
    /*
     * JADX WARN: Found duplicated region for block: B:25:0x0044 A[LOOP:0:
     * B:11:0x0019->B:25:0x0044, LOOP_END, MOVE_INLINED]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:26:0x0013 A[EDGE_INSN:
     * B:26:0x0013->B:9:0x0013 BREAK A[LOOP:0: B:11:0x0019->B:25:0x0044], SYNTHETIC]
     */
    /*
     * JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0041 ->
     * B:9:0x0013). Please report as a decompilation issue!!!
     */
    /*
     * JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
     * at block B:26:0x0013
     * at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
     * at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
     * at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(
     * NotificationAttrNode.java:19)
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final boolean nextIfObjectStart() {
        /*
         * r9 = this;
         * char r0 = r9.ch
         * r1 = 123(0x7b, float:1.72E-43)
         * if (r0 == r1) goto L8
         * r0 = 0
         * return r0
         * L8:
         * byte[] r0 = r9.bytes
         * int r1 = r9.offset
         * int r2 = r9.end
         * r3 = 26
         * if (r1 != r2) goto L15
         * r2 = r1
         * L13:
         * r1 = r3
         * goto L19
         * L15:
         * int r2 = r1 + 1
         * r1 = r0[r1]
         * L19:
         * if (r1 == 0) goto L3f
         * r4 = 32
         * if (r1 > r4) goto L2f
         * r4 = 1
         * long r4 = r4 << r1
         * r6 = 4294981376(0x100003700, double:2.1220027474E-314)
         * long r4 = r4 & r6
         * r6 = 0
         * int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
         * if (r4 == 0) goto L2f
         * goto L3f
         * L2f:
         * r0 = r1 & 255(0xff, float:3.57E-43)
         * char r0 = (char) r0
         * r9.ch = r0
         * r9.offset = r2
         * r0 = 47
         * if (r1 != r0) goto L3d
         * r9.skipComment()
         * L3d:
         * r0 = 1
         * return r0
         * L3f:
         * int r1 = r9.end
         * if (r2 != r1) goto L44
         * goto L13
         * L44:
         * int r1 = r2 + 1
         * r2 = r0[r2]
         * r8 = r2
         * r2 = r1
         * r1 = r8
         * goto L19
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.nextIfObjectStart():boolean");
    }

    /*
     * JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0067 ->
     * B:20:0x0050). Please report as a decompilation issue!!!
     */
    /*
     * JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit
     * block: B:23:0x005e
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(
     * LoopRegionMaker.java:272)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(
     * LoopRegionMaker.java:237)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:80)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :118)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:162)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.
     * java:48)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:25)
     */
    public final java.lang.String readEscaped(byte[] r18, int r19, int r20, int r21, int r22, int r23) {
        /*
         * r17 = this;
         * r0 = r17
         * r1 = r18
         * r2 = r21
         * r3 = r23
         * r4 = r19
         * r5 = r22
         * Lc:
         * if (r4 >= r2) goto Laf
         * r6 = r1[r4]
         * r7 = 92
         * r8 = 2
         * if (r6 != r7) goto L28
         * int r5 = r5 + 1
         * int r6 = r4 + 1
         * r6 = r1[r6]
         * r7 = 117(0x75, float:1.64E-43)
         * if (r6 != r7) goto L21
         * r8 = 6
         * goto L26
         * L21:
         * r7 = 120(0x78, float:1.68E-43)
         * if (r6 != r7) goto L26
         * r8 = 4
         * L26:
         * int r4 = r4 + r8
         * goto Lc
         * L28:
         * if (r6 != r3) goto La7
         * char[] r4 = new char[r5]
         * r6 = r20
         * int r3 = r0.readEscaped(r1, r6, r3, r4)
         * java.lang.String r5 = new java.lang.String
         * r5.<init>(r4)
         * com.alibaba.fastjson2.JSONReader$Context r4 = r0.context
         * long r6 = r4.features
         * r9 = 134234112(0x8004000, double:6.6320463E-316)
         * long r9 = r9 & r6
         * r11 = 0
         * int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
         * if (r4 == 0) goto L49
         * java.lang.String r5 = com.alibaba.fastjson2.JSONReader.stringValue(r5, r6)
         * L49:
         * int r4 = r3 + 1
         * r6 = 26
         * if (r4 != r2) goto L52
         * r3 = r4
         * L50:
         * r4 = r6
         * goto L55
         * L52:
         * int r3 = r3 + r8
         * r4 = r1[r4]
         * L55:
         * r7 = 4294981376(0x100003700, double:2.1220027474E-314)
         * r9 = 1
         * r13 = 32
         * if (r4 > r13) goto L74
         * long r14 = r9 << r4
         * long r14 = r14 & r7
         * int r14 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
         * if (r14 == 0) goto L74
         * if (r3 != r2) goto L6a
         * goto L50
         * L6a:
         * int r4 = r3 + 1
         * r3 = r1[r3]
         * r16 = r4
         * r4 = r3
         * r3 = r16
         * goto L55
         * L74:
         * r14 = 44
         * if (r4 != r14) goto L7a
         * r14 = 1
         * goto L7b
         * L7a:
         * r14 = 0
         * L7b:
         * r0.comma = r14
         * if (r14 == 0) goto L9f
         * if (r3 != r2) goto L84
         * r4 = r3
         * r3 = r6
         * goto L88
         * L84:
         * int r4 = r3 + 1
         * r3 = r1[r3]
         * L88:
         * r16 = r4
         * r4 = r3
         * r3 = r16
         * L8d:
         * if (r4 > r13) goto L9f
         * long r14 = r9 << r4
         * long r14 = r14 & r7
         * int r14 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
         * if (r14 == 0) goto L9f
         * if (r3 != r2) goto L9a
         * r4 = r6
         * goto L8d
         * L9a:
         * int r4 = r3 + 1
         * r3 = r1[r3]
         * goto L88
         * L9f:
         * r1 = r4 & 255(0xff, float:3.57E-43)
         * char r1 = (char) r1
         * r0.ch = r1
         * r0.offset = r3
         * return r5
         * La7:
         * r6 = r20
         * int r4 = r4 + 1
         * int r5 = r5 + 1
         * goto Lc
         * Laf:
         * java.lang.String r1 = "invalid escape character EOI"
         * com.alibaba.fastjson2.JSONException r1 = r0.error(r1)
         * throw r1
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.readEscaped(byte[], int, int, int, int, int):java.lang.String");
    }

    /* JADX WARN: Found duplicated region for block: B:100:0x0590 */
    /* JADX WARN: Found duplicated region for block: B:102:0x0596 */
    /* JADX WARN: Found duplicated region for block: B:106:0x059f */
    /* JADX WARN: Found duplicated region for block: B:108:0x05ac */
    /*
     * JADX WARN: Found duplicated region for block: B:110:0x05b1 A[LOOP:4:
     * B:109:0x05af->B:110:0x05b1, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:113:0x05c1 */
    /* JADX WARN: Found duplicated region for block: B:114:0x05ca */
    /* JADX WARN: Found duplicated region for block: B:117:0x05d9 */
    /* JADX WARN: Found duplicated region for block: B:119:0x05df */
    /* JADX WARN: Found duplicated region for block: B:86:0x054e */
    /* JADX WARN: Found duplicated region for block: B:88:0x0552 */
    /* JADX WARN: Found duplicated region for block: B:90:0x0561 */
    /*
     * JADX WARN: Found duplicated region for block: B:92:0x0566 A[LOOP:3:
     * B:91:0x0564->B:92:0x0566, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:95:0x0576 */
    /* JADX WARN: Found duplicated region for block: B:97:0x0580 */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final String readFieldName() {
        char c;
        long j;
        int i;
        byte b;
        long j2;
        long j3;
        byte b2;
        long j4;
        long j5;
        long j6;
        long j7;
        byte b3;
        int length;
        JSONFactory.NameCacheEntry nameCacheEntry;
        char[] cArr;
        int i2;
        int length2;
        JSONFactory.NameCacheEntry2 nameCacheEntry2;
        char[] cArr2;
        int i3;
        byte b4 = this.ch;
        if (b4 == 39 && (this.context.features & JSONReader.Feature.DisableSingleQuote.mask) != 0) {
            throw notSupportName();
        }
        if (b4 != 34 && b4 != 39) {
            if ((this.context.features & JSONReader.Feature.AllowUnQuotedFieldNames.mask) == 0
                    || !JSONReader.isFirstIdentifier(b4)) {
                return null;
            }
            return readFieldNameUnquote();
        }
        byte[] bArr = this.bytes;
        this.nameEscape = false;
        int i4 = this.offset;
        this.nameBegin = i4;
        int i5 = 0;
        int i6 = i4;
        while (true) {
            int i7 = this.end;
            if (i6 >= i7) {
                break;
            }
            byte b5 = bArr[i6];
            if (b5 == 92) {
                this.nameEscape = true;
                byte b6 = bArr[i6 + 1];
                i6 += b6 == 117 ? 6 : b6 == 120 ? 4 : 2;
            } else {
                if (b5 == b4) {
                    this.nameLength = i5;
                    this.nameEnd = i6;
                    int i8 = i6 + 1;
                    byte b7 = i8 < i7 ? bArr[i8] : (byte) 26;
                    while (b7 <= 32 && ((1 << b7) & 4294981376L) != 0) {
                        i8++;
                        b7 = bArr[i8];
                    }
                    if (b7 != 58) {
                        throw JSONReader.syntaxError(i8, this.ch);
                    }
                    i6 = i8 + 1;
                    if (i6 >= this.end) {
                        this.ch = (char) 26;
                        throw JSONReader.syntaxError(i6, 26);
                    }
                    byte b8 = bArr[i6];
                    while (b8 <= 32 && ((1 << b8) & 4294981376L) != 0) {
                        i6++;
                        b8 = bArr[i6];
                    }
                    this.offset = i6 + 1;
                    this.ch = (char) b8;
                    break;
                }
                i6++;
            }
            i5++;
        }
        int i9 = this.nameEnd;
        if (i9 < i4) {
            throw new JSONException(concatVar2Var1(i6, "syntax error : "));
        }
        if (!this.nameEscape) {
            int i10 = i9 - i4;
            switch (i10) {
                case 1:
                    return TypeUtils.toString(bArr[i4]);
                case 2:
                    return TypeUtils.toString(bArr[i4], bArr[i4 + 1]);
                case 3:
                    c = ' ';
                    j = -1;
                    i = (bArr[i4 + 2] << 16) + ((bArr[i4 + 1] & 255) << 8);
                    b = bArr[i4];
                    j2 = i + (b & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j8 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j8 ^ (j8 >>> c))) & (nameCacheEntry2Arr.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                for (i3 = 0; i3 < i10; i3++) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply = biFunction != null ? biFunction.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply, j4, j5);
                                return strApply;
                            }
                            if (nameCacheEntry2.value0 == j4 && nameCacheEntry2.value1 == j5) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr.length - 1);
                            nameCacheEntry = nameCacheEntryArr[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                for (i2 = 0; i2 < i10; i2++) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction2 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply2 = biFunction2 != null ? biFunction2.apply(cArr, Boolean.TRUE)
                                        : new String(cArr);
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 4:
                    c = ' ';
                    j = -1;
                    i = (bArr[i4 + 3] << 24) + ((bArr[i4 + 2] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8);
                    b = bArr[i4];
                    j2 = i + (b & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j82 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr2 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j82 ^ (j82 >>> c))) & (nameCacheEntry2Arr2.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr2[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction3 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply3 = biFunction3 != null ? biFunction3.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply3, j4, j5);
                                return strApply3;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr2 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr2.length - 1);
                            nameCacheEntry = nameCacheEntryArr2[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction22 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction22 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 5:
                    c = ' ';
                    j = -1;
                    j3 = (((long) bArr[i4 + 4]) << 32) + ((((long) bArr[i4 + 3]) & 255) << 24)
                            + ((((long) bArr[i4 + 2]) & 255) << 16) + ((((long) bArr[i4 + 1]) & 255) << 8);
                    b2 = bArr[i4];
                    j2 = j3 + (((long) b2) & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j822 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr22 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j822 ^ (j822 >>> c))) & (nameCacheEntry2Arr22.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr22[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction32 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply32 = biFunction32 != null ? biFunction32.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply32, j4, j5);
                                return strApply32;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr22 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr22.length - 1);
                            nameCacheEntry = nameCacheEntryArr22[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 6:
                    c = ' ';
                    j = -1;
                    j3 = (((long) bArr[i4 + 5]) << 40) + ((((long) bArr[i4 + 4]) & 255) << 32)
                            + ((((long) bArr[i4 + 3]) & 255) << 24) + ((((long) bArr[i4 + 2]) & 255) << 16)
                            + ((((long) bArr[i4 + 1]) & 255) << 8);
                    b2 = bArr[i4];
                    j2 = j3 + (((long) b2) & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j8222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j8222 ^ (j8222 >>> c))) & (nameCacheEntry2Arr222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction322 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply322 = biFunction322 != null ? biFunction322.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply322, j4, j5);
                                return strApply322;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr222.length - 1);
                            nameCacheEntry = nameCacheEntryArr222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction2222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction2222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 7:
                    c = ' ';
                    j = -1;
                    j3 = (((long) bArr[i4 + 6]) << 48) + ((((long) bArr[i4 + 5]) & 255) << 40)
                            + ((((long) bArr[i4 + 4]) & 255) << 32) + ((((long) bArr[i4 + 3]) & 255) << 24)
                            + ((((long) bArr[i4 + 2]) & 255) << 16) + ((((long) bArr[i4 + 1]) & 255) << 8);
                    b2 = bArr[i4];
                    j2 = j3 + (((long) b2) & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j82222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr2222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j82222 ^ (j82222 >>> c))) & (nameCacheEntry2Arr2222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr2222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction3222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply3222 = biFunction3222 != null ? biFunction3222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply3222, j4,
                                        j5);
                                return strApply3222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr2222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr2222.length - 1);
                            nameCacheEntry = nameCacheEntryArr2222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction22222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction22222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 8:
                    c = ' ';
                    j = -1;
                    j3 = (((long) bArr[i4 + 7]) << 56) + ((((long) bArr[i4 + 6]) & 255) << 48)
                            + ((((long) bArr[i4 + 5]) & 255) << 40) + ((((long) bArr[i4 + 4]) & 255) << 32)
                            + ((((long) bArr[i4 + 3]) & 255) << 24) + ((((long) bArr[i4 + 2]) & 255) << 16)
                            + ((((long) bArr[i4 + 1]) & 255) << 8);
                    b2 = bArr[i4];
                    j2 = j3 + (((long) b2) & 255);
                    j4 = j2;
                    j5 = j;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j822222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr22222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j822222 ^ (j822222 >>> c))) & (nameCacheEntry2Arr22222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr22222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction32222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply32222 = biFunction32222 != null
                                        ? biFunction32222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply32222, j4,
                                        j5);
                                return strApply32222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr22222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr22222.length - 1);
                            nameCacheEntry = nameCacheEntryArr22222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 9:
                    c = ' ';
                    j = -1;
                    j6 = bArr[i4];
                    j7 = (((long) bArr[i4 + 8]) << 56) + ((((long) bArr[i4 + 7]) & 255) << 48)
                            + ((((long) bArr[i4 + 6]) & 255) << 40) + ((((long) bArr[i4 + 5]) & 255) << 32)
                            + ((((long) bArr[i4 + 4]) & 255) << 24) + ((((long) bArr[i4 + 3]) & 255) << 16)
                            + ((((long) bArr[i4 + 2]) & 255) << 8);
                    b3 = bArr[i4 + 1];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j8222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j8222222 ^ (j8222222 >>> c))) & (nameCacheEntry2Arr222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction322222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply322222 = biFunction322222 != null
                                        ? biFunction322222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply322222, j4,
                                        j5);
                                return strApply322222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction2222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction2222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 10:
                    c = ' ';
                    j = -1;
                    j6 = (bArr[i4 + 1] << 8) + bArr[i4];
                    j7 = (((long) bArr[i4 + 9]) << 56) + ((((long) bArr[i4 + 8]) & 255) << 48)
                            + ((((long) bArr[i4 + 7]) & 255) << 40) + ((((long) bArr[i4 + 6]) & 255) << 32)
                            + ((((long) bArr[i4 + 5]) & 255) << 24) + ((((long) bArr[i4 + 4]) & 255) << 16)
                            + ((((long) bArr[i4 + 3]) & 255) << 8);
                    b3 = bArr[i4 + 2];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j82222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr2222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j82222222 ^ (j82222222 >>> c))) & (nameCacheEntry2Arr2222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr2222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction3222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply3222222 = biFunction3222222 != null
                                        ? biFunction3222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply3222222, j4,
                                        j5);
                                return strApply3222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr2222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr2222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr2222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction22222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction22222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 11:
                    c = ' ';
                    j = -1;
                    j6 = (bArr[i4 + 2] << 16) + (bArr[i4 + 1] << 8) + bArr[i4];
                    j7 = (((long) bArr[i4 + 10]) << 56) + ((((long) bArr[i4 + 9]) & 255) << 48)
                            + ((((long) bArr[i4 + 8]) & 255) << 40) + ((((long) bArr[i4 + 7]) & 255) << 32)
                            + ((((long) bArr[i4 + 6]) & 255) << 24) + ((((long) bArr[i4 + 5]) & 255) << 16)
                            + ((((long) bArr[i4 + 4]) & 255) << 8);
                    b3 = bArr[i4 + 3];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j822222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr22222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j822222222 ^ (j822222222 >>> c)))
                                    & (nameCacheEntry2Arr22222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr22222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction32222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply32222222 = biFunction32222222 != null
                                        ? biFunction32222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply32222222, j4,
                                        j5);
                                return strApply32222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr22222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr22222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr22222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 12:
                    c = ' ';
                    j = -1;
                    j6 = (bArr[i4 + 3] << 24) + (bArr[i4 + 2] << 16) + (bArr[i4 + 1] << 8) + bArr[i4];
                    j7 = (((long) bArr[i4 + 11]) << 56) + ((((long) bArr[i4 + 10]) & 255) << 48)
                            + ((((long) bArr[i4 + 9]) & 255) << 40) + ((((long) bArr[i4 + 8]) & 255) << 32)
                            + ((((long) bArr[i4 + 7]) & 255) << 24) + ((((long) bArr[i4 + 6]) & 255) << 16)
                            + ((((long) bArr[i4 + 5]) & 255) << 8);
                    b3 = bArr[i4 + 4];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j8222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j8222222222 ^ (j8222222222 >>> c)))
                                    & (nameCacheEntry2Arr222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction322222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply322222222 = biFunction322222222 != null
                                        ? biFunction322222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply322222222,
                                        j4, j5);
                                return strApply322222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction2222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction2222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 13:
                    c = ' ';
                    j = -1;
                    j6 = (((long) bArr[i4 + 4]) << 32) + (((long) bArr[i4 + 3]) << 24) + (((long) bArr[i4 + 2]) << 16)
                            + (((long) bArr[i4 + 1]) << 8) + ((long) bArr[i4]);
                    j7 = (((long) bArr[i4 + 12]) << 56) + ((((long) bArr[i4 + 11]) & 255) << 48)
                            + ((((long) bArr[i4 + 10]) & 255) << 40) + ((((long) bArr[i4 + 9]) & 255) << 32)
                            + ((((long) bArr[i4 + 8]) & 255) << 24) + ((((long) bArr[i4 + 7]) & 255) << 16)
                            + ((((long) bArr[i4 + 6]) & 255) << 8);
                    b3 = bArr[i4 + 5];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j82222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr2222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j82222222222 ^ (j82222222222 >>> c)))
                                    & (nameCacheEntry2Arr2222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr2222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction3222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply3222222222 = biFunction3222222222 != null
                                        ? biFunction3222222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply3222222222,
                                        j4, j5);
                                return strApply3222222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr2222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr2222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr2222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction22222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction22222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 14:
                    c = ' ';
                    j = -1;
                    j6 = (((long) bArr[i4 + 5]) << 40) + ((((long) bArr[i4 + 4]) & 255) << 32)
                            + ((((long) bArr[i4 + 3]) & 255) << 24) + ((((long) bArr[i4 + 2]) & 255) << 16)
                            + ((((long) bArr[i4 + 1]) & 255) << 8) + (((long) bArr[i4]) & 255);
                    j7 = (((long) bArr[i4 + 13]) << 56) + ((((long) bArr[i4 + 12]) & 255) << 48)
                            + ((((long) bArr[i4 + 11]) & 255) << 40) + ((((long) bArr[i4 + 10]) & 255) << 32)
                            + ((((long) bArr[i4 + 9]) & 255) << 24) + ((((long) bArr[i4 + 8]) & 255) << 16)
                            + ((((long) bArr[i4 + 7]) & 255) << 8);
                    b3 = bArr[i4 + 6];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j822222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr22222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j822222222222 ^ (j822222222222 >>> c)))
                                    & (nameCacheEntry2Arr22222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr22222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction32222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply32222222222 = biFunction32222222222 != null
                                        ? biFunction32222222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply32222222222,
                                        j4, j5);
                                return strApply32222222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr22222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr22222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr22222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction222222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 15:
                    c = ' ';
                    j = -1;
                    j6 = (((long) bArr[i4 + 6]) << 48) + ((((long) bArr[i4 + 5]) & 255) << 40)
                            + ((((long) bArr[i4 + 4]) & 255) << 32) + ((((long) bArr[i4 + 3]) & 255) << 24)
                            + ((((long) bArr[i4 + 2]) & 255) << 16) + ((((long) bArr[i4 + 1]) & 255) << 8)
                            + (((long) bArr[i4]) & 255);
                    j7 = (((long) bArr[i4 + 14]) << 56) + ((((long) bArr[i4 + 13]) & 255) << 48)
                            + ((((long) bArr[i4 + 12]) & 255) << 40) + ((((long) bArr[i4 + 11]) & 255) << 32)
                            + ((((long) bArr[i4 + 10]) & 255) << 24) + ((((long) bArr[i4 + 9]) & 255) << 16)
                            + ((((long) bArr[i4 + 8]) & 255) << 8);
                    b3 = bArr[i4 + 7];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j8222222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr222222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j8222222222222 ^ (j8222222222222 >>> c)))
                                    & (nameCacheEntry2Arr222222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr222222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction322222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply322222222222 = biFunction322222222222 != null
                                        ? biFunction322222222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(strApply322222222222,
                                        j4, j5);
                                return strApply322222222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr222222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr222222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr222222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction2222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction2222222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                case 16:
                    j = -1;
                    j6 = (((long) bArr[i4 + 7]) << 56) + ((((long) bArr[i4 + 6]) & 255) << 48)
                            + ((((long) bArr[i4 + 5]) & 255) << 40) + ((((long) bArr[i4 + 4]) & 255) << 32)
                            + ((((long) bArr[i4 + 3]) & 255) << 24) + ((((long) bArr[i4 + 2]) & 255) << 16)
                            + ((((long) bArr[i4 + 1]) & 255) << 8) + (((long) bArr[i4]) & 255);
                    c = ' ';
                    j7 = (((long) bArr[i4 + 15]) << 56) + ((((long) bArr[i4 + 14]) & 255) << 48)
                            + ((((long) bArr[i4 + 13]) & 255) << 40) + ((((long) bArr[i4 + 12]) & 255) << 32)
                            + ((((long) bArr[i4 + 11]) & 255) << 24) + ((((long) bArr[i4 + 10]) & 255) << 16)
                            + ((((long) bArr[i4 + 9]) & 255) << 8);
                    b3 = bArr[i4 + 8];
                    j4 = j6;
                    j5 = j7 + (((long) b3) & 255);
                    if (j4 != j) {
                        if (j5 != j) {
                            long j82222222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr2222222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j82222222222222 ^ (j82222222222222 >>> c)))
                                    & (nameCacheEntry2Arr2222222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr2222222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction3222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply3222222222222 = biFunction3222222222222 != null
                                        ? biFunction3222222222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(
                                        strApply3222222222222, j4, j5);
                                return strApply3222222222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr2222222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr2222222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr2222222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction22222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction22222222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
                default:
                    c = ' ';
                    j4 = -1;
                    j5 = -1;
                    j = -1;
                    if (j4 != j) {
                        if (j5 != j) {
                            long j822222222222222 = j4 ^ j5;
                            JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr22222222222222 = JSONFactory.NAME_CACHE2;
                            length2 = ((int) (j822222222222222 ^ (j822222222222222 >>> c)))
                                    & (nameCacheEntry2Arr22222222222222.length - 1);
                            nameCacheEntry2 = nameCacheEntry2Arr22222222222222[length2];
                            if (nameCacheEntry2 == null) {
                                cArr2 = new char[i10];
                                while (i3 < i10) {
                                    cArr2[i3] = (char) (bArr[i4 + i3] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction32222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                String strApply32222222222222 = biFunction32222222222222 != null
                                        ? biFunction32222222222222.apply(cArr2, Boolean.TRUE)
                                        : new String(cArr2);
                                JSONFactory.NAME_CACHE2[length2] = new JSONFactory.NameCacheEntry2(
                                        strApply32222222222222, j4, j5);
                                return strApply32222222222222;
                            }
                            if (nameCacheEntry2.value0 == j4) {
                                return nameCacheEntry2.name;
                            }
                        } else {
                            JSONFactory.NameCacheEntry[] nameCacheEntryArr22222222222222 = JSONFactory.NAME_CACHE;
                            length = ((int) ((j4 >>> c) ^ j4)) & (nameCacheEntryArr22222222222222.length - 1);
                            nameCacheEntry = nameCacheEntryArr22222222222222[length];
                            if (nameCacheEntry == null) {
                                cArr = new char[i10];
                                while (i2 < i10) {
                                    cArr[i2] = (char) (bArr[i4 + i2] & 255);
                                }
                                BiFunction<char[], Boolean, String> biFunction222222222222222 = JDKUtils.STRING_CREATOR_JDK8;
                                if (biFunction222222222222222 != null) {
                                }
                                JSONFactory.NAME_CACHE[length] = new JSONFactory.NameCacheEntry(strApply2, j4);
                                return strApply2;
                            }
                            if (nameCacheEntry.value == j4) {
                                return nameCacheEntry.name;
                            }
                        }
                    }
                    break;
            }
        }
        return getFieldName();
    }

    /* JADX WARN: Found duplicated region for block: B:136:0x0260 */
    /* JADX WARN: Found duplicated region for block: B:138:0x0263 */
    /* JADX WARN: Found duplicated region for block: B:141:0x026b */
    /*
     * JADX WARN: Found duplicated region for block: B:142:0x026d A[PHI: r5 r7
     * 0x026d: PHI (r5v2 int) = (r5v1 int), (r5v31 int), (r5v32 int), (r5v33 int)
     * binds: [B:135:0x025e, B:230:0x026d, B:143:0x0270, B:141:0x026b]
     * A[DONT_GENERATE, DONT_INLINE]
     * 0x026d: PHI (r7v3 long) = (r7v2 long), (r7v13 long), (r7v13 long), (r7v13
     * long) binds: [B:135:0x025e, B:230:0x026d, B:143:0x0270, B:141:0x026b]
     * A[DONT_GENERATE, DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:143:0x0270 */
    /* JADX WARN: Found duplicated region for block: B:144:0x0277 */
    /* JADX WARN: Found duplicated region for block: B:146:0x027b */
    /* JADX WARN: Found duplicated region for block: B:148:0x0284 */
    /* JADX WARN: Found duplicated region for block: B:150:0x0288 */
    /* JADX WARN: Found duplicated region for block: B:151:0x028f */
    /* JADX WARN: Found duplicated region for block: B:153:0x029d */
    /* JADX WARN: Found duplicated region for block: B:155:0x02ac */
    /* JADX WARN: Found duplicated region for block: B:157:0x02b3 */
    /* JADX WARN: Found duplicated region for block: B:159:0x02b7 */
    /*
     * JADX WARN: Found duplicated region for block: B:163:0x02ce A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:184:0x0330 */
    /* JADX WARN: Found duplicated region for block: B:187:0x033b */
    /* JADX WARN: Found duplicated region for block: B:189:0x0344 */
    /* JADX WARN: Found duplicated region for block: B:191:0x0348 */
    /* JADX WARN: Found duplicated region for block: B:193:0x034f */
    /* JADX WARN: Found duplicated region for block: B:195:0x0361 */
    /* JADX WARN: Found duplicated region for block: B:197:0x037d */
    /* JADX WARN: Found duplicated region for block: B:202:0x038b */
    /* JADX WARN: Found duplicated region for block: B:203:0x038e */
    /* JADX WARN: Found duplicated region for block: B:206:0x0396 */
    /* JADX WARN: Found duplicated region for block: B:209:0x03a5 */
    /* JADX WARN: Found duplicated region for block: B:210:0x03a7 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:214:0x03b7 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:215:0x03b9 */
    /* JADX WARN: Found duplicated region for block: B:216:0x03bc */
    /* JADX WARN: Found duplicated region for block: B:219:0x03c4 */
    /* JADX WARN: Found duplicated region for block: B:226:0x03e7 */
    /* JADX WARN: Found duplicated region for block: B:228:0x03f7 */
    /* JADX WARN: Found duplicated region for block: B:230:0x026d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:231:0x0269 A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:232:0x0327 A[ADDED_TO_REGION,
     * REMOVE, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:236:0x0381 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:245:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:246:0x03d3 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final long readFieldNameHashCode() {
        int i;
        char c;
        char c2;
        char c3;
        byte b;
        long j;
        int i2;
        int i3;
        int i4;
        byte b2;
        byte b3;
        int i5;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        int iHexDigit4;
        int i6;
        int iChar1;
        int i7;
        byte b8;
        int iChar12;
        long j2;
        long j3;
        int i8;
        byte b9;
        int iHexDigit42;
        byte b10;
        byte b11;
        int i9;
        long j4;
        long j5;
        int i10;
        String fieldName;
        byte[] bArr = this.bytes;
        byte b12 = this.ch;
        if (b12 == 47) {
            skipComment();
            b12 = this.ch;
        }
        if (b12 == 39 && (this.context.features & JSONReader.Feature.DisableSingleQuote.mask) != 0) {
            throw notSupportName();
        }
        if (b12 != 34 && b12 != 39) {
            if ((this.context.features & JSONReader.Feature.AllowUnQuotedFieldNames.mask) != 0
                    && JSONReader.isFirstIdentifier(b12)) {
                return readFieldNameHashCodeUnquote();
            }
            if (b12 == 125 || isNull()) {
                return -1L;
            }
            throw new JSONException(info((b12 != 91 || this.nameBegin <= 0 || (fieldName = getFieldName()) == null)
                    ? concatVar2Var1(b12, "illegal fieldName input ")
                    : "illegal fieldName input " + ((int) b12) + ", previous fieldName " + fieldName));
        }
        int i11 = this.end;
        this.nameAscii = true;
        this.nameEscape = false;
        int i12 = this.offset;
        this.nameBegin = i12;
        int i13 = i12 + 9;
        if (i13 < i11) {
            byte b13 = bArr[i12];
            if (b13 == b12) {
                i2 = i12;
                j = 0;
                c = '8';
                c2 = '0';
            } else {
                c = '8';
                int i14 = i12 + 1;
                c2 = '0';
                byte b14 = bArr[i14];
                if (b14 != b12 || b13 == 92 || b13 <= 0) {
                    i = i12;
                    int i15 = i + 2;
                    byte b15 = bArr[i15];
                    if (b15 != b12 || b13 == 92 || b14 == 92 || b13 < 0 || b14 <= 0) {
                        int i16 = i + 3;
                        byte b16 = bArr[i16];
                        if (b16 != b12 || b13 == 92 || b14 == 92 || b15 == 92 || (b13 | b14) < 0 || b15 <= 0) {
                            int i17 = i + 4;
                            c3 = '(';
                            byte b17 = bArr[i17];
                            if (b17 != b12 || b13 == 92 || b14 == 92 || b15 == 92 || b16 == 92 || (b13 | b14 | b15) < 0
                                    || b16 <= 0) {
                                int i18 = i + 5;
                                b = 32;
                                byte b18 = bArr[i18];
                                if (b18 != b12 || b13 == 92 || b14 == 92 || b15 == 92 || b16 == 92 || b17 == 92
                                        || (b13 | b14 | b15 | b16) < 0 || b17 <= 0) {
                                    int i19 = i + 6;
                                    byte b19 = bArr[i19];
                                    if (b19 != b12 || b13 == 92 || b14 == 92 || b15 == 92 || b16 == 92 || b17 == 92
                                            || b18 == 92 || (b13 | b14 | b15 | b16 | b17) < 0 || b18 <= 0) {
                                        int i20 = i + 7;
                                        byte b20 = bArr[i20];
                                        if (b20 != b12 || b13 == 92 || b14 == 92) {
                                            b10 = b13;
                                            b11 = b15;
                                        } else if (b11 == 92 || b16 == 92 || b17 == 92 || b18 == 92 || b19 == 92
                                                || (b13 | b14 | b11 | b16 | b17 | b18) < 0 || b19 <= 0) {
                                            b11 = b15;
                                            b10 = b13;
                                        } else {
                                            this.nameLength = 7;
                                            this.nameEnd = i20;
                                            i9 = i + 8;
                                            j4 = (((long) b19) << 48) + (((long) b18) << 40) + (((long) b17) << 32)
                                                    + ((long) (b16 << 24)) + ((long) (b11 << 16)) + ((long) (b14 << 8))
                                                    + ((long) b13);
                                        }
                                        int i21 = i + 8;
                                        if (bArr[i21] == b12 && b10 != 92 && b14 != 92 && b11 != 92 && b16 != 92
                                                && b17 != 92 && b18 != 92 && b19 != 92 && b20 != 92
                                                && (b10 | b14 | b11 | b16 | b17 | b18 | b19) >= 0 && b20 > 0) {
                                            this.nameLength = 8;
                                            this.nameEnd = i21;
                                            j = (((long) b20) << 56) + (((long) b19) << 48) + (((long) b18) << 40)
                                                    + (((long) b17) << 32) + ((long) (b16 << 24)) + ((long) (b11 << 16))
                                                    + ((long) (b14 << 8)) + ((long) b10);
                                            i2 = i13;
                                        }
                                    } else {
                                        this.nameLength = 6;
                                        this.nameEnd = i19;
                                        i9 = i + 7;
                                        j4 = ((long) b13) + (((long) b18) << 40) + (((long) b17) << 32)
                                                + ((long) (b16 << 24)) + ((long) (b15 << 16)) + ((long) (b14 << 8));
                                    }
                                    i2 = i9;
                                    j = j4;
                                } else {
                                    long j6 = ((long) b13) + (((long) b17) << 32) + ((long) (b16 << 24))
                                            + ((long) (b15 << 16)) + ((long) (b14 << 8));
                                    this.nameLength = 5;
                                    this.nameEnd = i18;
                                    i2 = i + 6;
                                    j = j6;
                                }
                            } else {
                                long j7 = (b16 << 24) + (b15 << 16) + (b14 << 8) + b13;
                                this.nameLength = 4;
                                this.nameEnd = i17;
                                i2 = i + 5;
                                j = j7;
                                b = 32;
                            }
                        } else {
                            j5 = (b15 << 16) + (b14 << 8) + b13;
                            this.nameLength = 3;
                            this.nameEnd = i16;
                            i10 = i + 4;
                        }
                        if (j == 0) {
                            i7 = 0;
                            while (true) {
                                if (i2 < i11) {
                                    b8 = bArr[i2];
                                    iChar12 = b8 & 255;
                                    if (iChar12 != b12) {
                                        if (iChar12 == 92) {
                                            this.nameEscape = true;
                                            i8 = i2 + 1;
                                            b9 = bArr[i8];
                                            if (b9 != 117) {
                                                if (b9 != 120) {
                                                    iChar12 = char1(b9);
                                                    i2 = i8;
                                                } else {
                                                    byte b21 = bArr[i2 + 2];
                                                    i2 += 3;
                                                    iHexDigit42 = JSONReader.char2(b21, bArr[i2]);
                                                }
                                                if (iChar12 > 255) {
                                                    this.nameAscii = false;
                                                }
                                            } else {
                                                iHexDigit42 = IOUtils.hexDigit4(bArr,
                                                        JSONReaderJSONB.check3(i2 + 2, i11));
                                                i2 += 5;
                                            }
                                            iChar12 = iHexDigit42;
                                            if (iChar12 > 255) {
                                                this.nameAscii = false;
                                            }
                                        } else {
                                            if (iChar12 != -61 || iChar12 == -62) {
                                                i2++;
                                                iChar12 = (char) (((b8 & 31) << 6)
                                                        | (bArr[i2] & JSONB.Constants.BC_INT32_BYTE_MAX));
                                                i3 = 0;
                                                this.nameAscii = false;
                                            }
                                            if (iChar12 <= 255 || iChar12 < 0 || i7 >= 8 || (i7 == 0 && iChar12 == 0)) {
                                                i2 = this.nameBegin;
                                                j = 0;
                                            } else {
                                                switch (i7) {
                                                    case 0:
                                                        j = (byte) iChar12;
                                                        break;
                                                    case 1:
                                                        j2 = ((byte) iChar12) << 8;
                                                        j3 = 255;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 2:
                                                        j2 = ((byte) iChar12) << 16;
                                                        j3 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 3:
                                                        j2 = ((byte) iChar12) << 24;
                                                        j3 = 16777215;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 4:
                                                        j2 = ((long) ((byte) iChar12)) << b;
                                                        j3 = 4294967295L;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 5:
                                                        j2 = ((long) ((byte) iChar12)) << c3;
                                                        j3 = 1099511627775L;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 6:
                                                        j2 = ((long) ((byte) iChar12)) << c2;
                                                        j3 = 281474976710655L;
                                                        j = j2 + (j & j3);
                                                        break;
                                                    case 7:
                                                        j2 = ((long) ((byte) iChar12)) << c;
                                                        j3 = 72057594037927935L;
                                                        j = j2 + (j & j3);
                                                        break;
                                                }
                                                i2++;
                                                i7++;
                                            }
                                        }
                                        i3 = 0;
                                        if (iChar12 <= 255) {
                                        }
                                        i2 = this.nameBegin;
                                        j = 0;
                                    } else if (i7 == 0) {
                                        i2 = this.nameBegin;
                                    } else {
                                        this.nameLength = i7;
                                        this.nameEnd = i2;
                                        i2++;
                                    }
                                }
                                i3 = 0;
                            }
                        } else {
                            i3 = 0;
                        }
                        if (j == 0) {
                            j = Fnv.MAGIC_HASH_CODE;
                            while (true) {
                                b5 = bArr[i2];
                                if (b5 == 92) {
                                    this.nameEscape = true;
                                    int i22 = i2 + 1;
                                    b7 = bArr[i22];
                                    if (b7 != 117) {
                                        if (b7 != 120) {
                                            iChar1 = char1(b7);
                                        } else {
                                            byte b22 = bArr[i2 + 2];
                                            i6 = i2 + 3;
                                            iHexDigit4 = JSONReader.char2(b22, bArr[i6]);
                                        }
                                        j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                                        i2 = i22 + 1;
                                        b6 = b;
                                    } else {
                                        iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i11));
                                        i6 = i2 + 5;
                                    }
                                    int i23 = i6;
                                    iChar1 = iHexDigit4;
                                    i22 = i23;
                                    j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                                    i2 = i22 + 1;
                                    b6 = b;
                                } else if (b5 == b12) {
                                    this.nameLength = i3;
                                    this.nameEnd = i2;
                                    i2++;
                                } else {
                                    b6 = b;
                                    i2++;
                                    j = (j ^ ((long) b5)) * Fnv.MAGIC_PRIME;
                                }
                                i3++;
                                b = b6;
                            }
                        }
                        if (i2 == i11) {
                            i4 = i2;
                            b2 = 26;
                        } else {
                            i4 = i2 + 1;
                            b2 = bArr[i2];
                        }
                        for (b3 = b; b2 <= b3 && ((1 << b2) & 4294981376L) != 0; b3 = 32) {
                            if (i4 == i11) {
                                b2 = 26;
                            } else {
                                b2 = bArr[i4];
                                i4++;
                            }
                        }
                        if (b2 != 58) {
                            throw new JSONException(info(concatVar2Var1(b2, "expect ':', but ")));
                        }
                        if (i4 == i11) {
                            i5 = i4;
                            b4 = 26;
                        } else {
                            i5 = i4 + 1;
                            b4 = bArr[i4];
                        }
                        while (b4 <= 32 && ((1 << b4) & 4294981376L) != 0) {
                            if (i5 == i11) {
                                b4 = 26;
                            } else {
                                int i24 = i5 + 1;
                                byte b23 = bArr[i5];
                                i5 = i24;
                                b4 = b23;
                            }
                        }
                        this.offset = i5;
                        this.ch = (char) (b4 & 255);
                        return j;
                    }
                    j5 = (b14 << 8) + b13;
                    this.nameLength = 2;
                    this.nameEnd = i15;
                    i10 = i + 3;
                    i2 = i10;
                    j = j5;
                } else {
                    j = b13;
                    this.nameLength = 1;
                    this.nameEnd = i14;
                    i2 = i12 + 2;
                }
            }
            c3 = '(';
            b = 32;
            if (j == 0) {
                i7 = 0;
                while (true) {
                    if (i2 < i11) {
                        b8 = bArr[i2];
                        iChar12 = b8 & 255;
                        if (iChar12 != b12) {
                            if (iChar12 == 92) {
                                this.nameEscape = true;
                                i8 = i2 + 1;
                                b9 = bArr[i8];
                                if (b9 != 117) {
                                    if (b9 != 120) {
                                        iChar12 = char1(b9);
                                        i2 = i8;
                                    } else {
                                        byte b212 = bArr[i2 + 2];
                                        i2 += 3;
                                        iHexDigit42 = JSONReader.char2(b212, bArr[i2]);
                                    }
                                    if (iChar12 > 255) {
                                        this.nameAscii = false;
                                    }
                                } else {
                                    iHexDigit42 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i11));
                                    i2 += 5;
                                }
                                iChar12 = iHexDigit42;
                                if (iChar12 > 255) {
                                    this.nameAscii = false;
                                }
                            } else {
                                if (iChar12 != -61) {
                                }
                                i2++;
                                iChar12 = (char) (((b8 & 31) << 6) | (bArr[i2] & JSONB.Constants.BC_INT32_BYTE_MAX));
                                i3 = 0;
                                this.nameAscii = false;
                                if (iChar12 <= 255) {
                                }
                                i2 = this.nameBegin;
                                j = 0;
                            }
                            i3 = 0;
                            if (iChar12 <= 255) {
                            }
                            i2 = this.nameBegin;
                            j = 0;
                        } else if (i7 == 0) {
                            i2 = this.nameBegin;
                        } else {
                            this.nameLength = i7;
                            this.nameEnd = i2;
                            i2++;
                        }
                    }
                    i3 = 0;
                    i2++;
                    i7++;
                }
            } else {
                i3 = 0;
            }
            if (j == 0) {
                j = Fnv.MAGIC_HASH_CODE;
                while (true) {
                    b5 = bArr[i2];
                    if (b5 == 92) {
                        this.nameEscape = true;
                        int i222 = i2 + 1;
                        b7 = bArr[i222];
                        if (b7 != 117) {
                            if (b7 != 120) {
                                iChar1 = char1(b7);
                            } else {
                                byte b222 = bArr[i2 + 2];
                                i6 = i2 + 3;
                                iHexDigit4 = JSONReader.char2(b222, bArr[i6]);
                            }
                            j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                            i2 = i222 + 1;
                            b6 = b;
                        } else {
                            iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i11));
                            i6 = i2 + 5;
                        }
                        int i232 = i6;
                        iChar1 = iHexDigit4;
                        i222 = i232;
                        j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                        i2 = i222 + 1;
                        b6 = b;
                    } else if (b5 == b12) {
                        this.nameLength = i3;
                        this.nameEnd = i2;
                        i2++;
                    } else {
                        b6 = b;
                        i2++;
                        j = (j ^ ((long) b5)) * Fnv.MAGIC_PRIME;
                    }
                    i3++;
                    b = b6;
                }
            }
            if (i2 == i11) {
                i4 = i2;
                b2 = 26;
            } else {
                i4 = i2 + 1;
                b2 = bArr[i2];
            }
            while (b2 <= b3) {
                if (i4 == i11) {
                    b2 = 26;
                } else {
                    b2 = bArr[i4];
                    i4++;
                }
            }
            if (b2 != 58) {
                throw new JSONException(info(concatVar2Var1(b2, "expect ':', but ")));
            }
            if (i4 == i11) {
                i5 = i4;
                b4 = 26;
            } else {
                i5 = i4 + 1;
                b4 = bArr[i4];
            }
            while (b4 <= 32) {
                if (i5 == i11) {
                    b4 = 26;
                } else {
                    int i242 = i5 + 1;
                    byte b232 = bArr[i5];
                    i5 = i242;
                    b4 = b232;
                }
            }
            this.offset = i5;
            this.ch = (char) (b4 & 255);
            return j;
        }
        i = i12;
        c = '8';
        c2 = '0';
        c3 = '(';
        b = 32;
        j = 0;
        i2 = i;
        if (j == 0) {
            i7 = 0;
            while (true) {
                if (i2 < i11) {
                    b8 = bArr[i2];
                    iChar12 = b8 & 255;
                    if (iChar12 != b12) {
                        if (iChar12 == 92) {
                            this.nameEscape = true;
                            i8 = i2 + 1;
                            b9 = bArr[i8];
                            if (b9 != 117) {
                                if (b9 != 120) {
                                    iChar12 = char1(b9);
                                    i2 = i8;
                                } else {
                                    byte b2122 = bArr[i2 + 2];
                                    i2 += 3;
                                    iHexDigit42 = JSONReader.char2(b2122, bArr[i2]);
                                }
                                if (iChar12 > 255) {
                                    this.nameAscii = false;
                                }
                            } else {
                                iHexDigit42 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i11));
                                i2 += 5;
                            }
                            iChar12 = iHexDigit42;
                            if (iChar12 > 255) {
                                this.nameAscii = false;
                            }
                        } else {
                            if (iChar12 != -61) {
                            }
                            i2++;
                            iChar12 = (char) (((b8 & 31) << 6) | (bArr[i2] & JSONB.Constants.BC_INT32_BYTE_MAX));
                            i3 = 0;
                            this.nameAscii = false;
                            if (iChar12 <= 255) {
                            }
                            i2 = this.nameBegin;
                            j = 0;
                        }
                        i3 = 0;
                        if (iChar12 <= 255) {
                        }
                        i2 = this.nameBegin;
                        j = 0;
                    } else if (i7 == 0) {
                        i2 = this.nameBegin;
                    } else {
                        this.nameLength = i7;
                        this.nameEnd = i2;
                        i2++;
                    }
                }
                i3 = 0;
                i2++;
                i7++;
            }
        } else {
            i3 = 0;
        }
        if (j == 0) {
            j = Fnv.MAGIC_HASH_CODE;
            while (true) {
                b5 = bArr[i2];
                if (b5 == 92) {
                    this.nameEscape = true;
                    int i2222 = i2 + 1;
                    b7 = bArr[i2222];
                    if (b7 != 117) {
                        if (b7 != 120) {
                            iChar1 = char1(b7);
                        } else {
                            byte b2222 = bArr[i2 + 2];
                            i6 = i2 + 3;
                            iHexDigit4 = JSONReader.char2(b2222, bArr[i6]);
                        }
                        j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                        i2 = i2222 + 1;
                        b6 = b;
                    } else {
                        iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i11));
                        i6 = i2 + 5;
                    }
                    int i2322 = i6;
                    iChar1 = iHexDigit4;
                    i2222 = i2322;
                    j = (j ^ ((long) iChar1)) * Fnv.MAGIC_PRIME;
                    i2 = i2222 + 1;
                    b6 = b;
                } else if (b5 == b12) {
                    this.nameLength = i3;
                    this.nameEnd = i2;
                    i2++;
                } else {
                    b6 = b;
                    i2++;
                    j = (j ^ ((long) b5)) * Fnv.MAGIC_PRIME;
                }
                i3++;
                b = b6;
            }
        }
        if (i2 == i11) {
            i4 = i2;
            b2 = 26;
        } else {
            i4 = i2 + 1;
            b2 = bArr[i2];
        }
        while (b2 <= b3) {
            if (i4 == i11) {
                b2 = 26;
            } else {
                b2 = bArr[i4];
                i4++;
            }
        }
        if (b2 != 58) {
            throw new JSONException(info(concatVar2Var1(b2, "expect ':', but ")));
        }
        if (i4 == i11) {
            i5 = i4;
            b4 = 26;
        } else {
            i5 = i4 + 1;
            b4 = bArr[i4];
        }
        while (b4 <= 32) {
            if (i5 == i11) {
                b4 = 26;
            } else {
                int i2422 = i5 + 1;
                byte b2322 = bArr[i5];
                i5 = i2422;
                b4 = b2322;
            }
        }
        this.offset = i5;
        this.ch = (char) (b4 & 255);
        return j;
    }

    /* JADX WARN: Found duplicated region for block: B:109:0x01a9 */
    /* JADX WARN: Found duplicated region for block: B:110:0x01ac */
    /* JADX WARN: Found duplicated region for block: B:112:0x01bb */
    /* JADX WARN: Found duplicated region for block: B:141:0x0212 */
    /* JADX WARN: Found duplicated region for block: B:142:0x0214 */
    /* JADX WARN: Found duplicated region for block: B:153:0x0238 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:154:0x023a */
    /* JADX WARN: Found duplicated region for block: B:155:0x023d */
    /* JADX WARN: Found duplicated region for block: B:202:0x022a A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:203:0x0228 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:43:0x00a0 */
    /* JADX WARN: Found duplicated region for block: B:43:0x00a0 A[FALL_THROUGH] */
    /* JADX WARN: Found duplicated region for block: B:82:0x0137 */
    /* JADX WARN: Found duplicated region for block: B:84:0x0144 */
    /*
     * JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit
     * block: B:158:0x0248
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(
     * LoopRegionMaker.java:272)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(
     * LoopRegionMaker.java:237)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:80)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(
     * LoopRegionMaker.java:590)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:82)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :118)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(
     * LoopRegionMaker.java:590)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:82)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.
     * java:48)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:25)
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final long readFieldNameHashCodeUnquote() {
        /*
         * Method dump skipped, instruction units count: 766
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.readFieldNameHashCodeUnquote():long");
    }

    /*
     * JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x009f ->
     * B:41:0x0087). Please report as a decompilation issue!!!
     */
    /*
     * JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit
     * block: B:44:0x0096
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(
     * LoopRegionMaker.java:272)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(
     * LoopRegionMaker.java:237)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:80)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.
     * java:48)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:25)
     */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final java.lang.String readString() {
        /*
         * Method dump skipped, instruction units count: 241
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: com.alibaba.fastjson2.JSONReaderASCII.readString():java.lang.String");
    }

    @Override // com.alibaba.fastjson2.JSONReaderUTF8
    public final void readString0() {
        String strApply;
        byte[] bArr = this.bytes;
        byte b = this.ch;
        int i = this.offset;
        this.valueEscape = false;
        int i2 = i;
        int i3 = 0;
        while (true) {
            byte b2 = bArr[i2];
            if (b2 == 92) {
                this.valueEscape = true;
                byte b3 = bArr[i2 + 1];
                i2 += b3 == 117 ? 6 : b3 == 120 ? 4 : 2;
            } else if (b2 == b) {
                break;
            } else {
                i2++;
            }
            i3++;
        }
        if (this.valueEscape) {
            char[] cArr = new char[i3];
            int i4 = 0;
            while (true) {
                char cHexDigit4 = (char) (bArr[i] & 255);
                if (cHexDigit4 == '\\') {
                    int i5 = i + 1;
                    char c = (char) bArr[i5];
                    if (c == '\"' || c == '\\') {
                        i = i5;
                        cHexDigit4 = c;
                    } else if (c == 'u') {
                        cHexDigit4 = (char) IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i + 2, this.end));
                        i += 5;
                    } else if (c != 'x') {
                        cHexDigit4 = char1(c);
                        i = i5;
                    } else {
                        byte b4 = bArr[i + 2];
                        i += 3;
                        cHexDigit4 = JSONReader.char2(b4, bArr[i]);
                    }
                } else if (cHexDigit4 == '\"') {
                    break;
                }
                cArr[i4] = cHexDigit4;
                i++;
                i4++;
            }
            strApply = new String(cArr);
            i2 = i;
        } else {
            BiFunction<byte[], Byte, String> biFunction = JDKUtils.STRING_CREATOR_JDK11;
            strApply = biFunction != null ? biFunction.apply(Arrays.copyOfRange(bArr, i, i2), JDKUtils.LATIN1)
                    : new String(bArr, i, i2 - i, StandardCharsets.ISO_8859_1);
        }
        int i6 = i2 + 1;
        byte b5 = bArr[i6];
        while (b5 > 0 && b5 <= 32 && ((1 << b5) & 4294981376L) != 0) {
            i6++;
            b5 = bArr[i6];
        }
        this.offset = i6 + 1;
        boolean z = b5 == 44;
        this.comma = z;
        if (z) {
            next();
        } else {
            this.ch = (char) b5;
        }
        this.stringValue = strApply;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.alibaba.fastjson2.JSONReaderUTF8, com.alibaba.fastjson2.JSONReader
    public final long readValueHashCode() {
        byte b;
        long j;
        ?? r12;
        int iHexDigit4;
        int i;
        int iChar1;
        ?? r122;
        byte b2;
        long j2;
        long j3;
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            return -1L;
        }
        byte[] bArr = this.bytes;
        ?? r4 = 1;
        this.nameAscii = true;
        this.nameEscape = false;
        int i2 = this.offset;
        this.nameBegin = i2;
        int i3 = 0;
        long j4 = 0;
        while (true) {
            int i4 = this.end;
            if (i2 < i4) {
                byte b3 = bArr[i2];
                b = 32;
                int iHexDigit42 = b3 & 255;
                if (iHexDigit42 != c) {
                    if (iHexDigit42 == 92) {
                        this.nameEscape = true;
                        int i5 = i2 + 1;
                        byte b4 = bArr[i5];
                        if (b4 == 117) {
                            iHexDigit42 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, i4));
                            i2 += 5;
                        } else if (b4 != 120) {
                            i2 = i5;
                            iHexDigit42 = char1(b4);
                        } else {
                            byte b5 = bArr[i2 + 2];
                            i2 += 3;
                            iHexDigit42 = JSONReader.char2(b5, bArr[i2]);
                        }
                    } else if (iHexDigit42 == -61 || iHexDigit42 == -62) {
                        i2++;
                        iHexDigit42 = (char) (((b3 & 31) << 6) | (bArr[i2] & JSONB.Constants.BC_INT32_BYTE_MAX));
                    }
                    if (iHexDigit42 > 255 || iHexDigit42 < 0 || i3 >= 8 || (i3 == 0 && iHexDigit42 == 0)) {
                        i2 = this.nameBegin;
                    } else {
                        switch (i3) {
                            case 0:
                                j4 = (byte) iHexDigit42;
                                continue;
                                i2++;
                                i3++;
                                break;
                            case 1:
                                j2 = ((byte) iHexDigit42) << 8;
                                j3 = 255;
                                break;
                            case 2:
                                j2 = ((byte) iHexDigit42) << 16;
                                j3 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                                break;
                            case 3:
                                j2 = ((byte) iHexDigit42) << 24;
                                j3 = 16777215;
                                break;
                            case 4:
                                j2 = ((long) ((byte) iHexDigit42)) << 32;
                                j3 = 4294967295L;
                                break;
                            case 5:
                                j2 = ((long) ((byte) iHexDigit42)) << 40;
                                j3 = 1099511627775L;
                                break;
                            case 6:
                                j2 = ((long) ((byte) iHexDigit42)) << 48;
                                j3 = 281474976710655L;
                                break;
                            case 7:
                                j2 = ((long) ((byte) iHexDigit42)) << 56;
                                j3 = 72057594037927935L;
                                break;
                            default:
                                continue;
                                i2++;
                                i3++;
                                break;
                        }
                        j4 = (j4 & j3) + j2;
                        i2++;
                        i3++;
                    }
                } else if (i3 == 0) {
                    i2 = this.nameBegin;
                } else {
                    this.nameLength = i3;
                    this.nameEnd = i2;
                    i2++;
                }
                j4 = 0;
            } else {
                b = 32;
            }
        }
        if (j4 != 0) {
            r122 = 1;
        } else {
            j4 = -3750763034362895579L;
            int i6 = 0;
            while (true) {
                byte b6 = bArr[i2];
                if (b6 == 92) {
                    this.nameEscape = r4;
                    int i7 = i2 + 1;
                    byte b7 = bArr[i7];
                    if (b7 != 117) {
                        if (b7 != 120) {
                            iChar1 = char1(b7);
                        } else {
                            byte b8 = bArr[i2 + 2];
                            i = i2 + 3;
                            iHexDigit4 = JSONReader.char2(b8, bArr[i]);
                        }
                        int i8 = i7 + r4;
                        r12 = r4;
                        j = (((long) iChar1) ^ j4) * Fnv.MAGIC_PRIME;
                        i2 = i8;
                    } else {
                        iHexDigit4 = IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i2 + 2, this.end));
                        i = i2 + 5;
                    }
                    int i9 = i;
                    iChar1 = iHexDigit4;
                    i7 = i9;
                    int i82 = i7 + r4;
                    r12 = r4;
                    j = (((long) iChar1) ^ j4) * Fnv.MAGIC_PRIME;
                    i2 = i82;
                } else {
                    ?? r123 = r4;
                    if (b6 == 34) {
                        this.nameLength = i6;
                        this.nameEnd = i2;
                        i2 += r123 == true ? 1 : 0;
                        r122 = r123;
                    } else {
                        i2++;
                        j = (((long) b6) ^ j4) * Fnv.MAGIC_PRIME;
                        r12 = r123;
                    }
                }
                j4 = j;
                i6++;
                r4 = r12;
            }
        }
        if (i2 == this.end) {
            b2 = 26;
        } else {
            b2 = bArr[i2];
            i2++;
        }
        while (b2 <= b && ((1 << b2) & 4294981376L) != 0) {
            if (i2 == this.end) {
                b2 = 26;
            } else {
                b2 = bArr[i2];
                i2++;
            }
            b = 32;
        }
        ?? r124 = r122;
        if (b2 != 44) {
            r124 = 0;
        }
        this.comma = r124;
        if (r124 != 0) {
            if (i2 == this.end) {
                b2 = 26;
            } else {
                b2 = bArr[i2];
                i2++;
            }
            while (b2 <= 32 && ((1 << b2) & 4294981376L) != 0) {
                if (i2 == this.end) {
                    b2 = 26;
                } else {
                    byte b9 = bArr[i2];
                    i2++;
                    b2 = b9;
                }
            }
        }
        this.offset = i2;
        this.ch = (char) (b2 & 255);
        return j4;
    }

    public static JSONReaderASCII of(JSONReader.Context context, InputStream inputStream) {
        return new JSONReaderASCII(context, inputStream);
    }

    public JSONReaderASCII(JSONReader.Context context, InputStream inputStream) {
        super(context, inputStream);
        this.nameAscii = true;
        this.str = null;
    }

    public final int readEscaped(byte[] bArr, int i, int i2, char[] cArr) {
        char cChar1;
        int i3 = 0;
        while (true) {
            char cChar2 = (char) (bArr[i] & 255);
            if (cChar2 == '\\') {
                int i4 = i + 1;
                char c = (char) bArr[i4];
                if (c == '\"' || c == '\\') {
                    i = i4;
                    cChar2 = c;
                } else {
                    if (c == 'b') {
                        cChar1 = '\b';
                    } else if (c == 'f') {
                        cChar1 = '\f';
                    } else if (c == 'n') {
                        cChar1 = '\n';
                    } else if (c == 'r') {
                        cChar1 = '\r';
                    } else if (c == 'x') {
                        byte b = bArr[i + 2];
                        i += 3;
                        cChar2 = JSONReader.char2(b, bArr[i]);
                    } else if (c == 't') {
                        cChar1 = '\t';
                    } else if (c != 'u') {
                        cChar1 = char1(c);
                    } else {
                        cChar2 = (char) IOUtils.hexDigit4(bArr, JSONReaderJSONB.check3(i + 2, this.end));
                        i += 5;
                    }
                    cChar2 = cChar1;
                    i = i4;
                }
            } else if (cChar2 == i2) {
                return i;
            }
            cArr[i3] = cChar2;
            i++;
            i3++;
        }
    }
}
