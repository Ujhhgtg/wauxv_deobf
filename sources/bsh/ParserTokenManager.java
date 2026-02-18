package bsh;

import com.alibaba.fastjson2.codec.FieldInfo;
import java.io.IOException;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ParserTokenManager implements ParserConstants {
    protected int curChar;
    int curLexState;
    int defaultLexState;
    private StringBuilder image;
    protected JavaCharStream input_stream;
    private final StringBuilder jjimage;
    private int jjimageLen;
    int jjmatchedKind;
    int jjmatchedPos;
    int jjnewStateCnt;
    int jjround;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    private int lengthOfMatch;
    static final long[] jjbitVec0 = {0, 0, -1, -1};
    static final long[] jjbitVec1 = {-2, -1, -1, -1};
    static final long[] jjbitVec3 = {2301339413881290750L, -16384, 4294967295L, 432345564227567616L};
    static final long[] jjbitVec4 = {0, 0, 0, -36028797027352577L};
    static final long[] jjbitVec5 = {0, -1, -1, -1};
    static final long[] jjbitVec6 = {-1, -1, WebSocketProtocol.PAYLOAD_SHORT_MAX, 0};
    static final long[] jjbitVec7 = {-1, -1, 0, 0};
    static final long[] jjbitVec8 = {70368744177663L, 0, 0, 0};
    public static final String[] jjstrLiteralImages = {"", null, null, null, null, null, null, null, null, null, null, "abstract", "boolean", "break", "class", "byte", "case", "catch", "char", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "switch", "synchronized", "transient", "throw", "throws", "true", "try", "void", "volatile", "while", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "(", ")", "{", "}", "[", "]", ";", ",", ".", "=", ">", "@gt", "<", "@lt", "!", "~", "==", "<=", "@lteq", ">=", "@gteq", "!=", "||", "@or", "&&", "@and", "++", "--", "+", "-", "*", "/", "&", "@bitwise_and", "|", "@bitwise_or", "^", "@bitwise_xor", "%", "@mod", "**", "@pow", "<<", "@left_shift", ">>", "@right_shift", ">>>", "@right_unsigned_shift", "+=", "-=", "*=", "/=", "&=", "@and_assign", "|=", "@or_assign", "^=", "@xor_assign", "%=", "@mod_assign", "**=", "@pow_assign", "<<=", "@left_shift_assign", ">>=", "@right_shift_assign", ">>>=", "@right_unsigned_shift_assign", "->", "<=>", "??=", "??", "?:", TypeDescription.Generic.OfWildcardType.SYMBOL, ":", "::", "...", "?.", "default:"};
    static final int[] jjnextStates = {2, 4, 6, 7, 65, 66, 68, 44, 45, 50, 51, 54, 55, 64, 77, 78, 85, 24, 25, 27, 57, 59, 62, 16, 29, 30, 32, 9, 10, 12, 18, 19, 22, 34, 35, 38, 46, 47, 22, 60, 61, 16, 71, 72, 74, 70, 71, 72, 74, 75, 81, 82, 84, 20, 21, 48, 49, 52, 53};
    public static final String[] lexStateNames = {"DEFAULT"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    static final long[] jjtoToken = {4611686018427385857L, -3100, 134217727};
    static final long[] jjtoSkip = {2046, 0, 0};
    static final long[] jjtoSpecial = {1792, 0, 0};
    static final long[] jjtoMore = {0, 0, 0};

    public ParserTokenManager(JavaCharStream javaCharStream) {
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.jjrounds = new int[86];
        this.jjstateSet = new int[172];
        StringBuilder sb = new StringBuilder();
        this.jjimage = sb;
        this.image = sb;
        this.input_stream = javaCharStream;
    }

    private void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 86;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            this.jjrounds[i2] = Integer.MIN_VALUE;
            i = i2;
        }
    }

    private void jjAddStates(int i, int i2) {
        while (true) {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[i];
            int i4 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i4;
            }
        }
    }

    private static final boolean jjCanMove_0(int i, int i2, int i3, long j, long j2) {
        return i == 0 && (jjbitVec0[i3] & j2) != 0;
    }

    private static final boolean jjCanMove_1(int i, int i2, int i3, long j, long j2) {
        return i != 0 ? (jjbitVec1[i2] & j) != 0 : (jjbitVec0[i3] & j2) != 0;
    }

    private static final boolean jjCanMove_2(int i, int i2, int i3, long j, long j2) {
        return i != 0 ? i != 51 ? i != 61 ? i != 48 ? i != 49 ? (jjbitVec3[i2] & j) != 0 : (jjbitVec6[i3] & j2) != 0 : (jjbitVec5[i3] & j2) != 0 : (jjbitVec8[i3] & j2) != 0 : (jjbitVec7[i3] & j2) != 0 : (jjbitVec4[i3] & j2) != 0;
    }

    private void jjCheckNAdd(int i) {
        int[] iArr = this.jjrounds;
        int i2 = iArr[i];
        int i3 = this.jjround;
        if (i2 != i3) {
            int[] iArr2 = this.jjstateSet;
            int i4 = this.jjnewStateCnt;
            this.jjnewStateCnt = i4 + 1;
            iArr2[i4] = i;
            iArr[i] = i3;
        }
    }

    private void jjCheckNAddStates(int i, int i2) {
        while (true) {
            jjCheckNAdd(jjnextStates[i]);
            int i3 = i + 1;
            if (i == i2) {
                return;
            } else {
                i = i3;
            }
        }
    }

    private void jjCheckNAddTwoStates(int i, int i2) {
        jjCheckNAdd(i);
        jjCheckNAdd(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x04db, code lost:
    
        if (r4 > 9) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x04dd, code lost:
    
        r2 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x04eb, code lost:
    
        if (r4 > 9) goto L293;
     */
    /* JADX WARN: Found duplicated region for block: B:409:0x0692 A[PHI: r2
      0x0692: PHI (r2v67 char) = (r2v63 char), (r2v68 char) binds: [B:415:0x06af, B:408:0x0690] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:587:0x096a  */
    /* JADX WARN: Found duplicated region for block: B:596:0x097d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:598:0x0988 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:88:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int jjMoveNfa_0(int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 2746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.ParserTokenManager.jjMoveNfa_0(int, int):int");
    }

    private int jjMoveStringLiteralDfa0_0() {
        int i = this.curChar;
        if (i == 9) {
            return jjStartNfaWithStates_0(0, 2, 0);
        }
        if (i == 10) {
            return jjStartNfaWithStates_0(0, 5, 0);
        }
        if (i == 12) {
            return jjStartNfaWithStates_0(0, 4, 0);
        }
        if (i == 13) {
            return jjStartNfaWithStates_0(0, 3, 0);
        }
        if (i == 32) {
            return jjStartNfaWithStates_0(0, 1, 0);
        }
        if (i == 33) {
            this.jjmatchedKind = 90;
            return jjMoveStringLiteralDfa1_0(0L, 8589934592L, 0L);
        }
        if (i == 37) {
            this.jjmatchedKind = 114;
            return jjMoveStringLiteralDfa1_0(0L, 0L, 64L);
        }
        if (i == 38) {
            this.jjmatchedKind = 108;
            return jjMoveStringLiteralDfa1_0(0L, 68719476736L, 1L);
        }
        if (i == 93) {
            return jjStopAtPos(0, 81);
        }
        if (i == 94) {
            this.jjmatchedKind = 112;
            return jjMoveStringLiteralDfa1_0(0L, 0L, 16L);
        }
        if (i == 118) {
            return jjMoveStringLiteralDfa1_0(864691128455135232L, 0L, 0L);
        }
        if (i == 119) {
            return jjMoveStringLiteralDfa1_0(FieldInfo.DISABLE_JSONB, 0L, 0L);
        }
        switch (i) {
            case 40:
                return jjStopAtPos(0, 76);
            case 41:
                return jjStopAtPos(0, 77);
            case 42:
                this.jjmatchedKind = 106;
                return jjMoveStringLiteralDfa1_0(0L, 4616189618054758400L, 256L);
            case 43:
                this.jjmatchedKind = 104;
                return jjMoveStringLiteralDfa1_0(0L, 1152921779484753920L, 0L);
            case 44:
                return jjStopAtPos(0, 83);
            case 45:
                this.jjmatchedKind = 105;
                return jjMoveStringLiteralDfa1_0(0L, 2305843558969507840L, 65536L);
            case 46:
                this.jjmatchedKind = 84;
                return jjMoveStringLiteralDfa1_0(0L, 0L, 16777216L);
            case 47:
                this.jjmatchedKind = 107;
                return jjMoveStringLiteralDfa1_0(0L, Long.MIN_VALUE, 0L);
            case 91:
                return jjStopAtPos(0, 80);
            case 105:
                return jjMoveStringLiteralDfa1_0(541165879296L, 0L, 0L);
            case 108:
                return jjMoveStringLiteralDfa1_0(549755813888L, 0L, 0L);
            case 110:
                return jjMoveStringLiteralDfa1_0(7696581394432L, 0L, 0L);
            case 112:
                return jjMoveStringLiteralDfa1_0(131941395333120L, 0L, 0L);
            case 123:
                return jjStopAtPos(0, 78);
            case 124:
                this.jjmatchedKind = 110;
                return jjMoveStringLiteralDfa1_0(0L, 17179869184L, 4L);
            case 125:
                return jjStopAtPos(0, 79);
            case 126:
                return jjStopAtPos(0, 91);
            default:
                switch (i) {
                    case 58:
                        this.jjmatchedKind = 150;
                        return jjMoveStringLiteralDfa1_0(0L, 0L, 8388608L);
                    case 59:
                        return jjStopAtPos(0, 82);
                    case 60:
                        this.jjmatchedKind = 88;
                        return jjMoveStringLiteralDfa1_0(0L, 18014399046352896L, 132096L);
                    case 61:
                        this.jjmatchedKind = 85;
                        return jjMoveStringLiteralDfa1_0(0L, 268435456L, 0L);
                    case 62:
                        this.jjmatchedKind = 86;
                        return jjMoveStringLiteralDfa1_0(0L, 360287972337123328L, 20480L);
                    case 63:
                        this.jjmatchedKind = 149;
                        return jjMoveStringLiteralDfa1_0(0L, 0L, 35389440L);
                    case 64:
                        return jjMoveStringLiteralDfa1_0(0L, 768602785489879040L, 43690L);
                    default:
                        switch (i) {
                            case 97:
                                return jjMoveStringLiteralDfa1_0(2048L, 0L, 0L);
                            case 98:
                                return jjMoveStringLiteralDfa1_0(45056L, 0L, 0L);
                            case 99:
                                return jjMoveStringLiteralDfa1_0(2048000L, 0L, 0L);
                            case 100:
                                return jjMoveStringLiteralDfa1_0(14680064L, 0L, 67108864L);
                            case 101:
                                return jjMoveStringLiteralDfa1_0(117440512L, 0L, 0L);
                            case 102:
                                return jjMoveStringLiteralDfa1_0(4160749568L, 0L, 0L);
                            case 103:
                                return jjMoveStringLiteralDfa1_0(4294967296L, 0L, 0L);
                            default:
                                switch (i) {
                                    case 114:
                                        return jjMoveStringLiteralDfa1_0(140737488355328L, 0L, 0L);
                                    case 115:
                                        return jjMoveStringLiteralDfa1_0(8725724278030336L, 0L, 0L);
                                    case 116:
                                        return jjMoveStringLiteralDfa1_0(279223176896970752L, 0L, 0L);
                                    default:
                                        return jjMoveNfa_0(1, 0);
                                }
                        }
                }
        }
    }

    private int jjMoveStringLiteralDfa10_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(8, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c == 'e') {
                return jjMoveStringLiteralDfa11_0(j7, FieldInfo.FIELD_MASK, j8, 0L, j9, 0L);
            }
            if (c == 'f') {
                return jjMoveStringLiteralDfa11_0(j7, 0L, j8, FieldInfo.DISABLE_REFERENCE_DETECT, j9, 8192L);
            }
            if (c == 'i') {
                return jjMoveStringLiteralDfa11_0(j7, 0L, j8, FieldInfo.DISABLE_AUTO_TYPE, j9, 32768L);
            }
            if (c != 'r') {
                if (c == 't') {
                    if ((FieldInfo.DISABLE_UNSAFE & j8) != 0) {
                        this.jjmatchedKind = 119;
                        this.jjmatchedPos = 10;
                    }
                    return jjMoveStringLiteralDfa11_0(j7, 0L, j8, 0L, j9, 2048L);
                }
                if (c == 'n') {
                    return (2 & j9) != 0 ? jjStopAtPos(10, 129) : (32 & j9) != 0 ? jjStopAtPos(10, 133) : (128 & j9) != 0 ? jjStopAtPos(10, 135) : (512 & j9) != 0 ? jjStopAtPos(10, 137) : jjMoveStringLiteralDfa11_0(j7, 0L, j8, 35184372088832L, j9, 0L);
                }
                if (c == 'o') {
                    return jjMoveStringLiteralDfa11_0(j7, 0L, j8, FieldInfo.UNWRAPPED_MASK, j9, 0L);
                }
            } else if ((140737488355328L & j8) != 0) {
                return jjStopAtPos(10, 111);
            }
            return jjStartNfa_0(9, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(9, j7, j8, j9);
            return 10;
        }
    }

    private int jjMoveStringLiteralDfa11_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(9, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c == '_') {
                return jjMoveStringLiteralDfa12_0(j7, 0L, j8, 0L, j9, 2048L);
            }
            if (c != 'd') {
                if (c == 'g') {
                    return jjMoveStringLiteralDfa12_0(j7, 0L, j8, FieldInfo.DISABLE_AUTO_TYPE, j9, 32768L);
                }
                if (c != 'r') {
                    if (c == 't') {
                        if ((FieldInfo.DISABLE_REFERENCE_DETECT & j8) != 0) {
                            this.jjmatchedKind = 121;
                            this.jjmatchedPos = 11;
                        }
                        return jjMoveStringLiteralDfa12_0(j7, 0L, j8, 0L, j9, 8192L);
                    }
                } else if ((FieldInfo.UNWRAPPED_MASK & j8) != 0) {
                    return jjStopAtPos(11, 113);
                }
            } else {
                if ((FieldInfo.FIELD_MASK & j7) != 0) {
                    return jjStartNfaWithStates_0(11, 52, 42);
                }
                if ((35184372088832L & j8) != 0) {
                    return jjStopAtPos(11, 109);
                }
            }
            return jjStartNfa_0(10, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(10, j7, j8, j9);
            return 11;
        }
    }

    private int jjMoveStringLiteralDfa12_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j4 & j3;
        long j8 = j6 & j5;
        if (((j2 & j) | j7 | j8) == 0) {
            return jjStartNfa_0(10, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != '_' ? c != 'a' ? c != 'n' ? jjStartNfa_0(11, 0L, j7, j8) : jjMoveStringLiteralDfa13_0(j7, FieldInfo.DISABLE_AUTO_TYPE, j8, 32768L) : jjMoveStringLiteralDfa13_0(j7, 0L, j8, 2048L) : jjMoveStringLiteralDfa13_0(j7, 0L, j8, 8192L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(11, 0L, j7, j8);
            return 12;
        }
    }

    private int jjMoveStringLiteralDfa13_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(11, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'a' ? c != 'e' ? c != 's' ? jjStartNfa_0(12, 0L, j5, j6) : jjMoveStringLiteralDfa14_0(j5, 0L, j6, 2048L) : jjMoveStringLiteralDfa14_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L) : jjMoveStringLiteralDfa14_0(j5, 0L, j6, 8192L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(12, 0L, j5, j6);
            return 13;
        }
    }

    private int jjMoveStringLiteralDfa14_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(12, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'd' ? c != 's' ? jjStartNfa_0(13, 0L, j5, j6) : jjMoveStringLiteralDfa15_0(j5, 0L, j6, 10240L) : jjMoveStringLiteralDfa15_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(13, 0L, j5, j6);
            return 14;
        }
    }

    private int jjMoveStringLiteralDfa15_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(13, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != '_' ? c != 'i' ? c != 's' ? jjStartNfa_0(14, 0L, j5, j6) : jjMoveStringLiteralDfa16_0(j5, 0L, j6, 8192L) : jjMoveStringLiteralDfa16_0(j5, 0L, j6, 2048L) : jjMoveStringLiteralDfa16_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(14, 0L, j5, j6);
            return 15;
        }
    }

    private int jjMoveStringLiteralDfa16_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(14, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'g' ? c != 'i' ? c != 's' ? jjStartNfa_0(15, 0L, j5, j6) : jjMoveStringLiteralDfa17_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L) : jjMoveStringLiteralDfa17_0(j5, 0L, j6, 8192L) : jjMoveStringLiteralDfa17_0(j5, 0L, j6, 2048L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(15, 0L, j5, j6);
            return 16;
        }
    }

    private int jjMoveStringLiteralDfa17_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(15, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'g' ? c != 'h' ? (c == 'n' && (2048 & j6) != 0) ? jjStopAtPos(17, 139) : jjStartNfa_0(16, 0L, j5, j6) : jjMoveStringLiteralDfa18_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L) : jjMoveStringLiteralDfa18_0(j5, 0L, j6, 8192L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(16, 0L, j5, j6);
            return 17;
        }
    }

    private int jjMoveStringLiteralDfa18_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(16, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'i' ? (c == 'n' && (8192 & j6) != 0) ? jjStopAtPos(18, 141) : jjStartNfa_0(17, 0L, j5, j6) : jjMoveStringLiteralDfa19_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(17, 0L, j5, j6);
            return 18;
        }
    }

    private int jjMoveStringLiteralDfa19_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(17, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'f' ? jjStartNfa_0(18, 0L, j5, j6) : jjMoveStringLiteralDfa20_0(j5, FieldInfo.DISABLE_AUTO_TYPE, j6, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(18, 0L, j5, j6);
            return 19;
        }
    }

    private int jjMoveStringLiteralDfa1_0(long j, long j2, long j3) {
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c != '&') {
                if (c != ':') {
                    if (c == 'r') {
                        return jjMoveStringLiteralDfa2_0(j, 225232757926666240L, j2, 720575940379279360L, j3, 40960L);
                    }
                    if (c != '|') {
                        if (c == '*') {
                            if ((j2 & FieldInfo.FIELD_MASK) != 0) {
                                this.jjmatchedKind = 116;
                                this.jjmatchedPos = 1;
                            }
                            return jjMoveStringLiteralDfa2_0(j, 0L, j2, 0L, j3, 256L);
                        }
                        if (c != '+') {
                            if (c != '-') {
                                if (c == '.') {
                                    return (j3 & 33554432) != 0 ? jjStopAtPos(1, 153) : jjMoveStringLiteralDfa2_0(j, 0L, j2, 0L, j3, 16777216L);
                                }
                                if (c == 'a') {
                                    return jjMoveStringLiteralDfa2_0(j, 9895739064320L, j2, 137438953472L, j3, 2L);
                                }
                                if (c == 'b') {
                                    return jjMoveStringLiteralDfa2_0(j, 2048L, j2, 738871813865472L, j3, 0L);
                                }
                                if (c == 't') {
                                    return jjMoveStringLiteralDfa2_0(j, 1688849860263936L, j2, 0L, j3, 0L);
                                }
                                if (c == 'u') {
                                    return jjMoveStringLiteralDfa2_0(j, 74766790688768L, j2, 0L, j3, 0L);
                                }
                                switch (c) {
                                    case '<':
                                        if ((j2 & FieldInfo.JIT) != 0) {
                                            this.jjmatchedKind = 118;
                                            this.jjmatchedPos = 1;
                                        }
                                        return jjMoveStringLiteralDfa2_0(j, 0L, j2, 0L, j3, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
                                    case '=':
                                        if ((j2 & 268435456) != 0) {
                                            return jjStopAtPos(1, 92);
                                        }
                                        if ((j2 & 536870912) != 0) {
                                            this.jjmatchedKind = 93;
                                            this.jjmatchedPos = 1;
                                        } else {
                                            if ((j2 & 2147483648L) != 0) {
                                                return jjStopAtPos(1, 95);
                                            }
                                            if ((j2 & 8589934592L) != 0) {
                                                return jjStopAtPos(1, 97);
                                            }
                                            if ((j2 & FieldInfo.DISABLE_JSONB) != 0) {
                                                return jjStopAtPos(1, 124);
                                            }
                                            if ((j2 & FieldInfo.BACKR_EFERENCE) != 0) {
                                                return jjStopAtPos(1, 125);
                                            }
                                            if ((j2 & FieldInfo.RECORD) != 0) {
                                                return jjStopAtPos(1, 126);
                                            }
                                            if ((j2 & Long.MIN_VALUE) != 0) {
                                                return jjStopAtPos(1, 127);
                                            }
                                            if ((j3 & 1) != 0) {
                                                return jjStopAtPos(1, 128);
                                            }
                                            if ((j3 & 4) != 0) {
                                                return jjStopAtPos(1, 130);
                                            }
                                            if ((j3 & 16) != 0) {
                                                return jjStopAtPos(1, 132);
                                            }
                                            if ((j3 & 64) != 0) {
                                                return jjStopAtPos(1, 134);
                                            }
                                        }
                                        return jjMoveStringLiteralDfa2_0(j, 0L, j2, 0L, j3, 131072L);
                                    case '>':
                                        if ((j2 & FieldInfo.READ_ONLY) != 0) {
                                            this.jjmatchedKind = 120;
                                            this.jjmatchedPos = 1;
                                        } else if ((j3 & 65536) != 0) {
                                            return jjStopAtPos(1, 144);
                                        }
                                        return jjMoveStringLiteralDfa2_0(j, 0L, j2, FieldInfo.DISABLE_ARRAY_MAPPING, j3, 20480L);
                                    case '?':
                                        if ((j3 & 524288) != 0) {
                                            this.jjmatchedKind = 147;
                                            this.jjmatchedPos = 1;
                                        }
                                        return jjMoveStringLiteralDfa2_0(j, 0L, j2, 0L, j3, 262144L);
                                    default:
                                        switch (c) {
                                            case 'e':
                                                return jjMoveStringLiteralDfa2_0(j, 142936513708032L, j2, 0L, j3, 67108864L);
                                            case 'f':
                                                if ((j & 8589934592L) != 0) {
                                                    return jjStartNfaWithStates_0(1, 33, 42);
                                                }
                                                break;
                                            case 'g':
                                                return jjMoveStringLiteralDfa2_0(j, 0L, j2, 4303355904L, j3, 0L);
                                            case 'h':
                                                return jjMoveStringLiteralDfa2_0(j, 1207246175112265728L, j2, 0L, j3, 0L);
                                            case 'i':
                                                return jjMoveStringLiteralDfa2_0(j, 805306368L, j2, 0L, j3, 0L);
                                            default:
                                                switch (c) {
                                                    case 'l':
                                                        return jjMoveStringLiteralDfa2_0(j, 1090535424L, j2, 36028798126260224L, j3, 2048L);
                                                    case 'm':
                                                        return jjMoveStringLiteralDfa2_0(j, 51539607552L, j2, FieldInfo.READ_USING_MASK, j3, 128L);
                                                    case 'n':
                                                        return jjMoveStringLiteralDfa2_0(j, 481069891584L, j2, 0L, j3, 0L);
                                                    case 'o':
                                                        if ((4194304 & j) != 0) {
                                                            this.jjmatchedKind = 22;
                                                            this.jjmatchedPos = 1;
                                                        }
                                                        return jjMoveStringLiteralDfa2_0(j, 864691684663365632L, j2, 34359738368L, j3, 8L);
                                                    case 'p':
                                                        return jjMoveStringLiteralDfa2_0(j, 0L, j2, FieldInfo.DISABLE_SMART_MATCH, j3, 512L);
                                                    default:
                                                        switch (c) {
                                                            case 'w':
                                                                return jjMoveStringLiteralDfa2_0(j, FieldInfo.READ_USING_MASK, j2, 0L, j3, 0L);
                                                            case 'x':
                                                                return jjMoveStringLiteralDfa2_0(j, 67108864L, j2, 0L, j3, 32L);
                                                            case 'y':
                                                                return jjMoveStringLiteralDfa2_0(j, 4503599627403264L, j2, 0L, j3, 0L);
                                                        }
                                                }
                                        }
                                        break;
                                }
                            } else if ((j2 & 549755813888L) != 0) {
                                return jjStopAtPos(1, 103);
                            }
                        } else if ((j2 & 274877906944L) != 0) {
                            return jjStopAtPos(1, 102);
                        }
                    } else if ((j2 & 17179869184L) != 0) {
                        return jjStopAtPos(1, 98);
                    }
                } else {
                    if ((j3 & 1048576) != 0) {
                        return jjStopAtPos(1, 148);
                    }
                    if ((j3 & 8388608) != 0) {
                        return jjStopAtPos(1, 151);
                    }
                }
            } else if ((j2 & 68719476736L) != 0) {
                return jjStopAtPos(1, 100);
            }
            return jjStartNfa_0(0, j, j2, j3);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(0, j, j2, j3);
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa20_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        long j6 = j4 & j3;
        if ((j5 | j6) == 0) {
            return jjStartNfa_0(18, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c != 't') {
                return jjStartNfa_0(19, 0L, j5, j6);
            }
            if ((FieldInfo.DISABLE_AUTO_TYPE & j5) != 0) {
                this.jjmatchedKind = 123;
                this.jjmatchedPos = 20;
            }
            return jjMoveStringLiteralDfa21_0(j5, 0L, j6, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(19, 0L, j5, j6);
            return 20;
        }
    }

    private int jjMoveStringLiteralDfa21_0(long j, long j2, long j3, long j4) {
        long j5 = j4 & j3;
        if (((j2 & j) | j5) == 0) {
            return jjStartNfa_0(19, 0L, j, j3);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != '_' ? jjStartNfa_0(20, 0L, 0L, j5) : jjMoveStringLiteralDfa22_0(j5, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(20, 0L, 0L, j5);
            return 21;
        }
    }

    private int jjMoveStringLiteralDfa22_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(20, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'a' ? jjStartNfa_0(21, 0L, 0L, j3) : jjMoveStringLiteralDfa23_0(j3, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(21, 0L, 0L, j3);
            return 22;
        }
    }

    private int jjMoveStringLiteralDfa23_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(21, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 's' ? jjStartNfa_0(22, 0L, 0L, j3) : jjMoveStringLiteralDfa24_0(j3, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(22, 0L, 0L, j3);
            return 23;
        }
    }

    private int jjMoveStringLiteralDfa24_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(22, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 's' ? jjStartNfa_0(23, 0L, 0L, j3) : jjMoveStringLiteralDfa25_0(j3, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(23, 0L, 0L, j3);
            return 24;
        }
    }

    private int jjMoveStringLiteralDfa25_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(23, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'i' ? jjStartNfa_0(24, 0L, 0L, j3) : jjMoveStringLiteralDfa26_0(j3, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(24, 0L, 0L, j3);
            return 25;
        }
    }

    private int jjMoveStringLiteralDfa26_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(24, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return c != 'g' ? jjStartNfa_0(25, 0L, 0L, j3) : jjMoveStringLiteralDfa27_0(j3, 32768L);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(25, 0L, 0L, j3);
            return 26;
        }
    }

    private int jjMoveStringLiteralDfa27_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(25, 0L, 0L, j);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            return (c == 'n' && (32768 & j3) != 0) ? jjStopAtPos(27, 143) : jjStartNfa_0(26, 0L, 0L, j3);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(26, 0L, 0L, j3);
            return 27;
        }
    }

    private int jjMoveStringLiteralDfa2_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(0, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c != '.') {
                if (c == 'i') {
                    return jjMoveStringLiteralDfa3_0(j7, 1443421272758288384L, j8, 721314812193144832L, j9, 40960L);
                }
                if (c == 'l') {
                    return jjMoveStringLiteralDfa3_0(j7, 576465150484152320L, j8, 0L, j9, 0L);
                }
                if (c != 'w') {
                    if (c != 'y') {
                        if (c != '=') {
                            if (c == '>') {
                                if ((FieldInfo.DISABLE_ARRAY_MAPPING & j8) != 0) {
                                    this.jjmatchedKind = 122;
                                    this.jjmatchedPos = 2;
                                } else if ((131072 & j9) != 0) {
                                    return jjStopAtPos(2, 145);
                                }
                                return jjMoveStringLiteralDfa3_0(j7, 0L, j8, 0L, j9, Http2Stream.EMIT_BUFFER_SIZE);
                            }
                            if (c == 'e') {
                                return jjMoveStringLiteralDfa3_0(j7, 8192L, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
                            }
                            if (c == 'f') {
                                return jjMoveStringLiteralDfa3_0(j7, 2097152L, j8, 0L, j9, 67108864L);
                            }
                            switch (c) {
                                case 'a':
                                    return jjMoveStringLiteralDfa3_0(j7, 9570149208440832L, j8, 0L, j9, 0L);
                                case 'b':
                                    return jjMoveStringLiteralDfa3_0(j7, 70368744177664L, j8, 0L, j9, 0L);
                                case 'c':
                                    return jjMoveStringLiteralDfa3_0(j7, 8796093022208L, j8, 0L, j9, 0L);
                                default:
                                    switch (c) {
                                        case 'n':
                                            return jjMoveStringLiteralDfa3_0(j7, 4504150190063616L, j8, 137438953472L, j9, 2L);
                                        case 'o':
                                            return jjMoveStringLiteralDfa3_0(j7, 316660422545408L, j8, 11258999068426240L, j9, 672L);
                                        case 'p':
                                            return jjMoveStringLiteralDfa3_0(j7, 51539607552L, j8, 0L, j9, 0L);
                                        default:
                                            switch (c) {
                                                case 'r':
                                                    if ((2147483648L & j7) != 0) {
                                                        return jjStartNfaWithStates_0(2, 31, 42);
                                                    }
                                                    if ((34359738368L & j8) != 0) {
                                                        this.jjmatchedKind = 99;
                                                        this.jjmatchedPos = 2;
                                                    }
                                                    return jjMoveStringLiteralDfa3_0(j7, 55169095435288576L, j8, 0L, j9, 8L);
                                                case 's':
                                                    return jjMoveStringLiteralDfa3_0(j7, 68736321536L, j8, 0L, j9, 0L);
                                                case 't':
                                                    if ((137438953472L & j7) != 0) {
                                                        this.jjmatchedKind = 37;
                                                        this.jjmatchedPos = 2;
                                                    } else if ((8388608 & j8) != 0) {
                                                        this.jjmatchedKind = 87;
                                                        this.jjmatchedPos = 2;
                                                    } else if ((33554432 & j8) != 0) {
                                                        this.jjmatchedKind = 89;
                                                        this.jjmatchedPos = 2;
                                                    }
                                                    return jjMoveStringLiteralDfa3_0(j7, 142116240130048L, j8, 5368709120L, j9, 0L);
                                                case 'u':
                                                    return jjMoveStringLiteralDfa3_0(j7, 72057594079870976L, j8, 0L, j9, 0L);
                                            }
                                    }
                            }
                        }
                        if ((256 & j9) != 0) {
                            return jjStopAtPos(2, 136);
                        }
                        if ((RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE & j9) != 0) {
                            return jjStopAtPos(2, 138);
                        }
                        if ((4096 & j9) != 0) {
                            return jjStopAtPos(2, 140);
                        }
                        if ((262144 & j9) != 0) {
                            return jjStopAtPos(2, 146);
                        }
                    } else if ((FieldInfo.DISABLE_REFERENCE_DETECT & j7) != 0) {
                        return jjStartNfaWithStates_0(2, 57, 42);
                    }
                } else if ((2199023255552L & j7) != 0) {
                    return jjStartNfaWithStates_0(2, 41, 42);
                }
            } else if ((16777216 & j9) != 0) {
                return jjStopAtPos(2, 152);
            }
            return jjStartNfa_0(1, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(1, j7, j8, j9);
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(1, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c != '=') {
                if (c == '_') {
                    return jjMoveStringLiteralDfa4_0(j7, 0L, j8, 0L, j9, 8L);
                }
                if (c == 'i') {
                    return jjMoveStringLiteralDfa4_0(j7, 1126999418470400L, j8, 0L, j9, 0L);
                }
                switch (c) {
                    case 'a':
                        return jjMoveStringLiteralDfa4_0(j7, 576460754184577024L, j8, 0L, j9, 67108864L);
                    case 'b':
                        return jjMoveStringLiteralDfa4_0(j7, 8388608L, j8, 0L, j9, 0L);
                    case 'c':
                        return jjMoveStringLiteralDfa4_0(j7, 4503599627501568L, j8, 0L, j9, 0L);
                    case 'd':
                        if ((FieldInfo.DISABLE_ARRAY_MAPPING & j7) != 0) {
                            return jjStartNfaWithStates_0(3, 58, 42);
                        }
                        if ((137438953472L & j8) != 0) {
                            this.jjmatchedKind = 101;
                            this.jjmatchedPos = 3;
                        } else if ((FieldInfo.READ_USING_MASK & j8) != 0) {
                            this.jjmatchedKind = 115;
                            this.jjmatchedPos = 3;
                        }
                        return jjMoveStringLiteralDfa4_0(j7, 0L, j8, 0L, j9, 130L);
                    case 'e':
                        return (32768 & j7) != 0 ? jjStartNfaWithStates_0(3, 15, 42) : (65536 & j7) != 0 ? jjStartNfaWithStates_0(3, 16, 42) : (16777216 & j7) != 0 ? jjStartNfaWithStates_0(3, 24, 42) : (FieldInfo.READ_ONLY & j7) != 0 ? jjStartNfaWithStates_0(3, 56, 42) : jjMoveStringLiteralDfa4_0(j7, 274945015808L, j8, 5368709120L, j9, 0L);
                    case 'f':
                        return jjMoveStringLiteralDfa4_0(j7, 0L, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
                    case 'g':
                        return (549755813888L & j7) != 0 ? jjStartNfaWithStates_0(3, 39, 42) : jjMoveStringLiteralDfa4_0(j7, 0L, j8, 720575940379279360L, j9, 40960L);
                    default:
                        switch (c) {
                            case 'k':
                                return jjMoveStringLiteralDfa4_0(j7, 8796093022208L, j8, 0L, j9, 0L);
                            case 'l':
                                return (4398046511104L & j7) != 0 ? jjStartNfaWithStates_0(3, 42, 42) : jjMoveStringLiteralDfa4_0(j7, 1152991890530897920L, j8, 0L, j9, 0L);
                            case 'm':
                                if ((33554432 & j7) != 0) {
                                    return jjStartNfaWithStates_0(3, 25, 42);
                                }
                                break;
                            case 'n':
                                return jjMoveStringLiteralDfa4_0(j7, FieldInfo.DISABLE_SMART_MATCH, j8, 0L, j9, 0L);
                            case 'o':
                                return (4294967296L & j7) != 0 ? jjStartNfaWithStates_0(3, 32, 42) : jjMoveStringLiteralDfa4_0(j7, 54043229888184320L, j8, 0L, j9, 0L);
                            default:
                                switch (c) {
                                    case 'r':
                                        return (262144 & j7) != 0 ? jjStartNfaWithStates_0(3, 18, 42) : jjMoveStringLiteralDfa4_0(j7, FieldInfo.VALUE_MASK, j8, 0L, j9, 32L);
                                    case 's':
                                        return jjMoveStringLiteralDfa4_0(j7, 134758400L, j8, 0L, j9, 0L);
                                    case 't':
                                        return jjMoveStringLiteralDfa4_0(j7, 2850002859722752L, j8, 738871813865472L, j9, 0L);
                                    case 'u':
                                        return jjMoveStringLiteralDfa4_0(j7, 140737488355328L, j8, 0L, j9, 0L);
                                    case 'v':
                                        return jjMoveStringLiteralDfa4_0(j7, 17592186044416L, j8, 0L, j9, 0L);
                                    case 'w':
                                        if ((FieldInfo.DISABLE_SMART_MATCH & j8) != 0) {
                                            this.jjmatchedKind = 117;
                                            this.jjmatchedPos = 3;
                                        }
                                        return jjMoveStringLiteralDfa4_0(j7, 0L, j8, 0L, j9, 512L);
                                }
                        }
                        break;
                }
            } else if ((Http2Stream.EMIT_BUFFER_SIZE & j9) != 0) {
                return jjStopAtPos(3, 142);
            }
            return jjStartNfa_0(2, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(2, j7, j8, j9);
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa4_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(2, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            switch (c) {
                case '_':
                    return jjMoveStringLiteralDfa5_0(j7, 0L, j8, 0L, j9, 674L);
                case 'a':
                    return jjMoveStringLiteralDfa5_0(j7, 26456998543360L, j8, 0L, j9, 8L);
                case 'c':
                    return jjMoveStringLiteralDfa5_0(j7, 3377699720527872L, j8, 0L, j9, 0L);
                case 'e':
                    return (134217728 & j7) != 0 ? jjStartNfaWithStates_0(4, 27, 42) : (FieldInfo.DISABLE_JSONB & j7) != 0 ? jjStartNfaWithStates_0(4, 60, 42) : jjMoveStringLiteralDfa5_0(j7, 35201551962112L, j8, 0L, j9, 0L);
                case 'h':
                    return (131072 & j7) != 0 ? jjStartNfaWithStates_0(4, 17, 42) : jjMoveStringLiteralDfa5_0(j7, FieldInfo.FIELD_MASK, j8, 720575940379279360L, j9, 40960L);
                case 'i':
                    return jjMoveStringLiteralDfa5_0(j7, 633318698647552L, j8, 0L, j9, 0L);
                case 'k':
                    if ((8192 & j7) != 0) {
                        return jjStartNfaWithStates_0(4, 13, 42);
                    }
                    break;
                case 'l':
                    if ((268435456 & j7) != 0) {
                        this.jjmatchedKind = 28;
                        this.jjmatchedPos = 4;
                    }
                    return jjMoveStringLiteralDfa5_0(j7, 545259520L, j8, 0L, j9, 0L);
                case 'n':
                    return jjMoveStringLiteralDfa5_0(j7, 67108864L, j8, 0L, j9, 0L);
                case 'q':
                    if ((1073741824 & j8) != 0) {
                        return jjStopAtPos(4, 94);
                    }
                    if ((4294967296L & j8) != 0) {
                        return jjStopAtPos(4, 96);
                    }
                    break;
                case 'r':
                    return jjMoveStringLiteralDfa5_0(j7, 141046726002688L, j8, 0L, j9, 0L);
                case 's':
                    return (Http2Stream.EMIT_BUFFER_SIZE & j7) != 0 ? jjStartNfaWithStates_0(4, 14, 42) : jjMoveStringLiteralDfa5_0(j7, FieldInfo.DISABLE_SMART_MATCH, j8, 0L, j9, 0L);
                case 't':
                    return (524288 & j7) != 0 ? jjStartNfaWithStates_0(4, 19, 42) : (1073741824 & j7) != 0 ? jjStartNfaWithStates_0(4, 30, 42) : (FieldInfo.VALUE_MASK & j7) != 0 ? jjStartNfaWithStates_0(4, 48, 42) : jjMoveStringLiteralDfa5_0(j7, FieldInfo.DISABLE_AUTO_TYPE, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
                case 'u':
                    return jjMoveStringLiteralDfa5_0(j7, 2097152L, j8, 0L, j9, 67108864L);
                case 'v':
                    return jjMoveStringLiteralDfa5_0(j7, 1099511627776L, j8, 0L, j9, 0L);
                case 'w':
                    if ((FieldInfo.JIT & j7) != 0) {
                        this.jjmatchedKind = 54;
                        this.jjmatchedPos = 4;
                    }
                    return jjMoveStringLiteralDfa5_0(j7, FieldInfo.DISABLE_UNSAFE, j8, 738871813865472L, j9, 0L);
            }
            return jjStartNfa_0(3, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(3, j7, j8, j9);
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa5_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(3, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            switch (c) {
                case '_':
                    return jjMoveStringLiteralDfa6_0(j7, 0L, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
                case 'a':
                    return jjMoveStringLiteralDfa6_0(j7, 6144L, j8, 0L, j9, 674L);
                case 'c':
                    return (70368744177664L & j7) != 0 ? jjStartNfaWithStates_0(5, 46, 42) : (FieldInfo.UNWRAPPED_MASK & j7) != 0 ? jjStartNfaWithStates_0(5, 49, 42) : jjMoveStringLiteralDfa6_0(j7, 35184372088832L, j8, 0L, j9, 0L);
                case 'd':
                    return jjMoveStringLiteralDfa6_0(j7, 67108864L, j8, 0L, j9, 0L);
                case 'e':
                    if ((8388608 & j7) != 0) {
                        return jjStartNfaWithStates_0(5, 23, 42);
                    }
                    if ((1099511627776L & j7) != 0) {
                        return jjStartNfaWithStates_0(5, 40, 42);
                    }
                    break;
                case 'f':
                    return jjMoveStringLiteralDfa6_0(j7, 274877906944L, j8, 0L, j9, 0L);
                case 'g':
                    return jjMoveStringLiteralDfa6_0(j7, 8796093022208L, j8, 0L, j9, 0L);
                case 'h':
                    if ((FieldInfo.READ_USING_MASK & j7) != 0) {
                        return jjStartNfaWithStates_0(5, 51, 42);
                    }
                    break;
                case 'i':
                    return jjMoveStringLiteralDfa6_0(j7, 585467951558164480L, j8, 738871813865472L, j9, 0L);
                case 'l':
                    return jjMoveStringLiteralDfa6_0(j7, 538968064L, j8, 0L, j9, 67108864L);
                case 'm':
                    return jjMoveStringLiteralDfa6_0(j7, 17179869184L, j8, 0L, j9, 0L);
                case 'n':
                    return (140737488355328L & j7) != 0 ? jjStartNfaWithStates_0(5, 47, 42) : jjMoveStringLiteralDfa6_0(j7, 68720525312L, j8, 0L, j9, 0L);
                case 'r':
                    return jjMoveStringLiteralDfa6_0(j7, FieldInfo.FIELD_MASK, j8, 0L, j9, 0L);
                case 's':
                    return (FieldInfo.DISABLE_UNSAFE & j7) != 0 ? jjStartNfaWithStates_0(5, 55, 42) : jjMoveStringLiteralDfa6_0(j7, 0L, j8, 0L, j9, 8L);
                case 't':
                    return (34359738368L & j7) != 0 ? jjStartNfaWithStates_0(5, 35, 42) : jjMoveStringLiteralDfa6_0(j7, 1143492092887040L, j8, 720575940379279360L, j9, 40960L);
            }
            return jjStartNfa_0(4, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(4, j7, j8, j9);
            return 5;
        }
    }

    private int jjMoveStringLiteralDfa6_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(4, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c == '_') {
                return jjMoveStringLiteralDfa7_0(j7, 0L, j8, 720575940379279360L, j9, 40960L);
            }
            if (c == 'a') {
                return jjMoveStringLiteralDfa7_0(j7, 274877906944L, j8, 0L, j9, 0L);
            }
            if (c == 'c') {
                return jjMoveStringLiteralDfa7_0(j7, 68719478784L, j8, 0L, j9, 0L);
            }
            if (c == 'l') {
                return jjMoveStringLiteralDfa7_0(j7, FieldInfo.DISABLE_AUTO_TYPE, j8, 0L, j9, 0L);
            }
            if (c != 'y') {
                if (c == 'e') {
                    return (8796093022208L & j7) != 0 ? jjStartNfaWithStates_0(6, 43, 42) : (17592186044416L & j7) != 0 ? jjStartNfaWithStates_0(6, 44, 42) : jjMoveStringLiteralDfa7_0(j7, 9007216434610176L, j8, 0L, j9, 0L);
                }
                if (c == 'f') {
                    return jjMoveStringLiteralDfa7_0(j7, FieldInfo.RAW_VALUE_MASK, j8, 0L, j9, 0L);
                }
                if (c != 'n') {
                    if (c == 'o') {
                        return jjMoveStringLiteralDfa7_0(j7, FieldInfo.FIELD_MASK, j8, 0L, j9, 0L);
                    }
                    switch (c) {
                        case 's':
                            return (67108864 & j7) != 0 ? jjStartNfaWithStates_0(6, 26, 42) : jjMoveStringLiteralDfa7_0(j7, 0L, j8, 36767668832829440L, j9, 2730L);
                        case 't':
                            if ((2097152 & j7) != 0) {
                                this.jjmatchedKind = 21;
                                this.jjmatchedPos = 6;
                            }
                            return jjMoveStringLiteralDfa7_0(j7, 35184372088832L, j8, 0L, j9, 67108864L);
                        case 'u':
                            return jjMoveStringLiteralDfa7_0(j7, 1048576L, j8, 0L, j9, 0L);
                    }
                }
                if ((4096 & j7) != 0) {
                    return jjStartNfaWithStates_0(6, 12, 42);
                }
            } else if ((536870912 & j7) != 0) {
                return jjStartNfaWithStates_0(6, 29, 42);
            }
            return jjStartNfa_0(5, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(5, j7, j8, j9);
            return 6;
        }
    }

    private int jjMoveStringLiteralDfa7_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(5, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c != ':') {
                if (c == 'c') {
                    return jjMoveStringLiteralDfa8_0(j7, 274877906944L, j8, 0L, j9, 0L);
                }
                if (c == 'e') {
                    return (1048576 & j7) != 0 ? jjStartNfaWithStates_0(7, 20, 42) : (FieldInfo.DISABLE_AUTO_TYPE & j7) != 0 ? jjStartNfaWithStates_0(7, 59, 42) : jjMoveStringLiteralDfa8_0(j7, 35253091565568L, j8, 738871813865472L, j9, 0L);
                }
                if (c == 'n') {
                    return jjMoveStringLiteralDfa8_0(j7, 13510816061980672L, j8, 0L, j9, 0L);
                }
                if (c != 'p') {
                    if (c == 'h') {
                        return jjMoveStringLiteralDfa8_0(j7, 0L, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
                    }
                    if (c == 'i') {
                        return jjMoveStringLiteralDfa8_0(j7, 0L, j8, 0L, j9, 8L);
                    }
                    switch (c) {
                        case 's':
                            return jjMoveStringLiteralDfa8_0(j7, 0L, j8, FieldInfo.DISABLE_REFERENCE_DETECT, j9, 8866L);
                        case 't':
                            if ((2048 & j7) != 0) {
                                return jjStartNfaWithStates_0(7, 11, 42);
                            }
                            break;
                        case 'u':
                            return jjMoveStringLiteralDfa8_0(j7, 0L, j8, FieldInfo.DISABLE_AUTO_TYPE, j9, 32768L);
                    }
                } else if ((FieldInfo.RAW_VALUE_MASK & j7) != 0) {
                    return jjStartNfaWithStates_0(7, 50, 42);
                }
            } else if ((67108864 & j9) != 0) {
                return jjStopAtPos(7, 154);
            }
            return jjStartNfa_0(6, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(6, j7, j8, j9);
            return 7;
        }
    }

    private int jjMoveStringLiteralDfa8_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(6, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c == '_') {
                return jjMoveStringLiteralDfa9_0(j7, 0L, j8, 738871813865472L, j9, 0L);
            }
            if (c == 't') {
                return (FieldInfo.DISABLE_SMART_MATCH & j7) != 0 ? jjStartNfaWithStates_0(8, 53, 42) : jjMoveStringLiteralDfa9_0(j7, 17179869184L, j8, 0L, j9, 0L);
            }
            if (c != 'd') {
                if (c != 'e') {
                    if (c == 'n') {
                        return jjMoveStringLiteralDfa9_0(j7, 0L, j8, FieldInfo.DISABLE_AUTO_TYPE, j9, 32768L);
                    }
                    if (c == 'o') {
                        return jjMoveStringLiteralDfa9_0(j7, 68719476736L, j8, 0L, j9, 0L);
                    }
                    switch (c) {
                        case 'g':
                            return jjMoveStringLiteralDfa9_0(j7, 0L, j8, 0L, j9, 8L);
                        case 'h':
                            return jjMoveStringLiteralDfa9_0(j7, 0L, j8, FieldInfo.DISABLE_REFERENCE_DETECT, j9, 8192L);
                        case 'i':
                            return jjMoveStringLiteralDfa9_0(j7, FieldInfo.FIELD_MASK, j8, FieldInfo.DISABLE_UNSAFE, j9, 2722L);
                    }
                }
                if ((274877906944L & j7) != 0) {
                    return jjStartNfaWithStates_0(8, 38, 42);
                }
            } else if ((35184372088832L & j7) != 0) {
                return jjStartNfaWithStates_0(8, 45, 42);
            }
            return jjStartNfa_0(7, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(7, j7, j8, j9);
            return 8;
        }
    }

    private int jjMoveStringLiteralDfa9_0(long j, long j2, long j3, long j4, long j5, long j6) {
        long j7 = j2 & j;
        long j8 = j4 & j3;
        long j9 = j6 & j5;
        if ((j7 | j8 | j9) == 0) {
            return jjStartNfa_0(7, j, j3, j5);
        }
        try {
            char c = this.input_stream.readChar();
            this.curChar = c;
            if (c == 'a') {
                return jjMoveStringLiteralDfa10_0(j7, 0L, j8, 35184372088832L, j9, 0L);
            }
            if (c == 'i') {
                return jjMoveStringLiteralDfa10_0(j7, 0L, j8, FieldInfo.DISABLE_REFERENCE_DETECT, j9, 8192L);
            }
            if (c == 's') {
                return (17179869184L & j7) != 0 ? jjStartNfaWithStates_0(9, 34, 42) : jjMoveStringLiteralDfa10_0(j7, 0L, j8, FieldInfo.DISABLE_AUTO_TYPE, j9, 32768L);
            }
            if (c == 'x') {
                return jjMoveStringLiteralDfa10_0(j7, 0L, j8, FieldInfo.UNWRAPPED_MASK, j9, 0L);
            }
            if (c == 'z') {
                return jjMoveStringLiteralDfa10_0(j7, FieldInfo.FIELD_MASK, j8, 0L, j9, 0L);
            }
            if (c == 'f') {
                return (68719476736L & j7) != 0 ? jjStartNfaWithStates_0(9, 36, 42) : jjMoveStringLiteralDfa10_0(j7, 0L, j8, FieldInfo.DISABLE_UNSAFE, j9, 2048L);
            }
            if (c == 'g') {
                return jjMoveStringLiteralDfa10_0(j7, 0L, j8, 0L, j9, 674L);
            }
            if (c != 'n') {
                if (c == 'o') {
                    return jjMoveStringLiteralDfa10_0(j7, 0L, j8, 140737488355328L, j9, 0L);
                }
            } else if ((8 & j9) != 0) {
                return jjStopAtPos(9, 131);
            }
            return jjStartNfa_0(8, j7, j8, j9);
        } catch (IOException unused) {
            jjStopStringLiteralDfa_0(8, j7, j8, j9);
            return 9;
        }
    }

    private int jjStartNfaWithStates_0(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(i3, i + 1);
        } catch (IOException unused) {
            return i + 1;
        }
    }

    private final int jjStartNfa_0(int i, long j, long j2, long j3) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j, j2, j3), i + 1);
    }

    private int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private final int jjStopStringLiteralDfa_0(int i, long j, long j2, long j3) {
        switch (i) {
            case 0:
                if (((-9223363240761753600L) & j2) != 0) {
                    return 64;
                }
                if ((18014399063130112L & j2) != 0 || (j3 & 132096) != 0) {
                    return 86;
                }
                if ((j2 & 1048576) != 0 || (j3 & 16777216) != 0) {
                    return 18;
                }
                if ((2305843009213691904L & j) == 0 && (j3 & 67108864) == 0) {
                    return (j & 62) != 0 ? 0 : -1;
                }
                this.jjmatchedKind = 73;
                return 42;
            case 1:
                if ((j2 & FieldInfo.JIT) != 0 || (j3 & RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) != 0) {
                    return 86;
                }
                if ((8602517504L & j) != 0) {
                    return 42;
                }
                if ((j & 2305843000611174400L) == 0 && (j3 & 67108864) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 1) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 1;
                }
                return 42;
            case 2:
                if ((144117801563455488L & j) != 0) {
                    return 42;
                }
                if ((j & 2161725199056107520L) == 0 && (j3 & 67108864) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 2) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 2;
                }
                return 42;
            case 3:
                if ((360292922337624064L & j) != 0) {
                    return 42;
                }
                if ((j & 1801432551596390400L) == 0 && (j3 & 67108864) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 3) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 3;
                }
                return 42;
            case 4:
                if ((1207246177125949440L & j) != 0) {
                    return 42;
                }
                if ((j & 594186374470440960L) == 0 && (j3 & 67108864) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 4) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 4;
                }
                return 42;
            case 5:
                if ((591159385127917568L & j) == 0 && (j3 & 67108864) == 0) {
                    return (j & 39055786898358272L) != 0 ? 42 : -1;
                }
                this.jjmatchedKind = 73;
                this.jjmatchedPos = 5;
                return 42;
            case 6:
                if ((26388885147648L & j) != 0 || (j3 & 67108864) != 0) {
                    return 42;
                }
                if ((j & 591132996242769920L) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 6) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 6;
                }
                return 42;
            case 7:
                if ((577586652211316736L & j) != 0) {
                    return 42;
                }
                if ((j & 13546344031453184L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 73;
                this.jjmatchedPos = 7;
                return 42;
            case 8:
                if ((9042658504736768L & j) != 0) {
                    return 42;
                }
                if ((j & 4503685526716416L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 73;
                this.jjmatchedPos = 8;
                return 42;
            case 9:
                if ((85899345920L & j) != 0) {
                    return 42;
                }
                if ((j & FieldInfo.FIELD_MASK) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 73;
                this.jjmatchedPos = 9;
                return 42;
            case 10:
                if ((j & FieldInfo.FIELD_MASK) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos != 10) {
                    this.jjmatchedKind = 73;
                    this.jjmatchedPos = 10;
                }
                return 42;
            case 11:
                return (j & FieldInfo.FIELD_MASK) != 0 ? 42 : -1;
            default:
                return -1;
        }
    }

    public void MoreLexicalActions() {
        int i = this.jjimageLen;
        int i2 = this.jjmatchedPos + 1;
        this.lengthOfMatch = i2;
        this.jjimageLen = i + i2;
    }

    public void ReInit(JavaCharStream javaCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = javaCharStream;
        ReInitRounds();
    }

    public void SkipLexicalActions(Token token) {
    }

    public void SwitchTo(int i) {
        if (i >= 1 || i < 0) {
            throw new TokenMgrException(yg.f(i, "Error: Ignoring invalid lexical state : ", ". State unchanged."), 2);
        }
        this.curLexState = i;
    }

    public void TokenLexicalActions(Token token) {
    }

    public Token getNextToken() {
        int i;
        int i2;
        boolean z;
        String image;
        String image2 = null;
        Token token = null;
        while (true) {
            int i3 = 0;
            try {
                this.curChar = this.input_stream.beginToken();
                this.jjmatchedKind = Integer.MAX_VALUE;
                this.jjmatchedPos = 0;
                int iJjMoveStringLiteralDfa0_0 = jjMoveStringLiteralDfa0_0();
                if (this.jjmatchedKind == Integer.MAX_VALUE) {
                    int endLine = this.input_stream.getEndLine();
                    int endColumn = this.input_stream.getEndColumn();
                    try {
                        this.input_stream.readChar();
                        this.input_stream.backup(1);
                        i = endLine;
                        z = false;
                        i2 = endColumn;
                    } catch (IOException unused) {
                        image2 = iJjMoveStringLiteralDfa0_0 <= 1 ? "" : this.input_stream.getImage();
                        int i4 = this.curChar;
                        if (i4 == 10 || i4 == 13) {
                            endLine++;
                        } else {
                            i3 = endColumn + 1;
                        }
                        i = endLine;
                        i2 = i3;
                        z = true;
                    }
                    if (z) {
                        image = image2;
                    } else {
                        this.input_stream.backup(1);
                        image = iJjMoveStringLiteralDfa0_0 > 1 ? this.input_stream.getImage() : "";
                    }
                    throw new TokenMgrException(z, this.curLexState, i, i2, image, this.curChar, 0);
                }
                int i5 = this.jjmatchedPos;
                if (i5 + 1 < iJjMoveStringLiteralDfa0_0) {
                    this.input_stream.backup((iJjMoveStringLiteralDfa0_0 - i5) - 1);
                }
                long[] jArr = jjtoToken;
                int i6 = this.jjmatchedKind;
                if ((jArr[i6 >> 6] & (1 << (i6 & 63))) != 0) {
                    Token tokenJjFillToken = jjFillToken();
                    tokenJjFillToken.specialToken = token;
                    return tokenJjFillToken;
                }
                if (((1 << (i6 & 63)) & jjtoSpecial[i6 >> 6]) != 0) {
                    Token tokenJjFillToken2 = jjFillToken();
                    if (token != null) {
                        tokenJjFillToken2.specialToken = token;
                        token.next = tokenJjFillToken2;
                    }
                    token = tokenJjFillToken2;
                }
            } catch (Exception unused2) {
                this.jjmatchedKind = 0;
                this.jjmatchedPos = -1;
                Token tokenJjFillToken3 = jjFillToken();
                tokenJjFillToken3.specialToken = token;
                return tokenJjFillToken3;
            }
        }
    }

    public Token jjFillToken() {
        String image = jjstrLiteralImages[this.jjmatchedKind];
        if (image == null) {
            image = this.input_stream.getImage();
        }
        int beginLine = this.input_stream.getBeginLine();
        int beginColumn = this.input_stream.getBeginColumn();
        int endLine = this.input_stream.getEndLine();
        int endColumn = this.input_stream.getEndColumn();
        Token tokenNewToken = Token.newToken(this.jjmatchedKind);
        tokenNewToken.kind = this.jjmatchedKind;
        tokenNewToken.image = image;
        tokenNewToken.beginLine = beginLine;
        tokenNewToken.endLine = endLine;
        tokenNewToken.beginColumn = beginColumn;
        tokenNewToken.endColumn = endColumn;
        return tokenNewToken;
    }

    public void ReInit(JavaCharStream javaCharStream, int i) {
        ReInit(javaCharStream);
        SwitchTo(i);
    }

    public ParserTokenManager(JavaCharStream javaCharStream, int i) {
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.jjrounds = new int[86];
        this.jjstateSet = new int[172];
        StringBuilder sb = new StringBuilder();
        this.jjimage = sb;
        this.image = sb;
        ReInit(javaCharStream);
        SwitchTo(i);
    }
}
