package bsh;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.JavaConstant;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Parser implements ParserTreeConstants, ParserConstants {
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private static int[] jj_la1_3;
    private static int[] jj_la1_4;
    private final JJCalls[] jj_2_rtns;
    private int jj_endpos;
    private List<int[]> jj_expentries;
    private int[] jj_expentry;
    private int jj_gc;
    private int jj_gen;
    JavaCharStream jj_input_stream;
    private int jj_kind;
    private int jj_la;
    private final int[] jj_la1;
    private Token jj_lastpos;
    private int[] jj_lasttokens;
    private boolean jj_lookingAhead;
    private final LookaheadSuccess jj_ls;
    public Token jj_nt;
    private int jj_ntk;
    private boolean jj_rescan;
    private Token jj_scanpos;
    private boolean jj_semLA;
    protected JJTParserState jjtree;
    boolean retainComments;
    public Token token;
    public ParserTokenManager token_source;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class JJCalls {
        int arg;
        Token first;
        int gen;
        JJCalls next;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class LookaheadSuccess extends IllegalStateException {
        public /* synthetic */ LookaheadSuccess(int i) {
            this();
        }

        private LookaheadSuccess() {
        }
    }

    static {
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
        jj_la1_init_3();
        jj_la1_init_4();
    }

    public Parser(InputStream inputStream, Charset charset) {
        this.jjtree = new JJTParserState();
        int i = 0;
        this.retainComments = false;
        this.jj_lookingAhead = false;
        this.jj_la1 = new int[120];
        this.jj_2_rtns = new JJCalls[36];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(i);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        JavaCharStream javaCharStream = new JavaCharStream(inputStream, charset, 1, 1);
        this.jj_input_stream = javaCharStream;
        this.token_source = new ParserTokenManager(javaCharStream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    private int getRadix(String str) {
        if (str.startsWith("0b") || str.startsWith("0B")) {
            return 2;
        }
        if (str.startsWith("0x") || str.startsWith("0X")) {
            return 16;
        }
        return (!str.startsWith("0") || str.length() <= 1) ? 10 : 8;
    }

    private int getStartIdx(int i) {
        if (i == 10) {
            return 0;
        }
        return i == 8 ? 1 : 2;
    }

    private boolean jj_2_1(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_1();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(0, i);
        }
    }

    private boolean jj_2_10(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_10();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(9, i);
        }
    }

    private boolean jj_2_11(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_11();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(10, i);
        }
    }

    private boolean jj_2_12(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_12();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(11, i);
        }
    }

    private boolean jj_2_13(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_13();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(12, i);
        }
    }

    private boolean jj_2_14(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_14();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(13, i);
        }
    }

    private boolean jj_2_15(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_15();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(14, i);
        }
    }

    private boolean jj_2_16(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_16();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(15, i);
        }
    }

    private boolean jj_2_17(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_17();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(16, i);
        }
    }

    private boolean jj_2_18(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_18();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(17, i);
        }
    }

    private boolean jj_2_19(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_19();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(18, i);
        }
    }

    private boolean jj_2_2(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(1, i);
        }
    }

    private boolean jj_2_20(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_20();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(19, i);
        }
    }

    private boolean jj_2_21(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_21();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(20, i);
        }
    }

    private boolean jj_2_22(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_22();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(21, i);
        }
    }

    private boolean jj_2_23(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_23();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(22, i);
        }
    }

    private boolean jj_2_24(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_24();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(23, i);
        }
    }

    private boolean jj_2_25(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_25();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(24, i);
        }
    }

    private boolean jj_2_26(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_26();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(25, i);
        }
    }

    private boolean jj_2_27(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_27();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(26, i);
        }
    }

    private boolean jj_2_28(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_28();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(27, i);
        }
    }

    private boolean jj_2_29(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_29();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(28, i);
        }
    }

    private boolean jj_2_3(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_3();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(2, i);
        }
    }

    private boolean jj_2_30(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_30();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(29, i);
        }
    }

    private boolean jj_2_31(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_31();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(30, i);
        }
    }

    private boolean jj_2_32(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_32();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(31, i);
        }
    }

    private boolean jj_2_33(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_33();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(32, i);
        }
    }

    private boolean jj_2_34(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_34();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(33, i);
        }
    }

    private boolean jj_2_35(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_35();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(34, i);
        }
    }

    private boolean jj_2_36(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_36();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(35, i);
        }
    }

    private boolean jj_2_4(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_4();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(3, i);
        }
    }

    private boolean jj_2_5(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_5();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(4, i);
        }
    }

    private boolean jj_2_6(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_6();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(5, i);
        }
    }

    private boolean jj_2_7(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_7();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(6, i);
        }
    }

    private boolean jj_2_8(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_8();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(7, i);
        }
    }

    private boolean jj_2_9(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_9();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(8, i);
        }
    }

    private boolean jj_3R_100() {
        return jj_scan_token(72);
    }

    private boolean jj_3R_101() {
        Token token = this.jj_scanpos;
        if (!jj_3R_126()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_127()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_128()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_129()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_130()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_131()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_132()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_133();
    }

    private boolean jj_3R_102() {
        return jj_3R_135() || jj_3R_50();
    }

    private boolean jj_3R_103() {
        Token token = this.jj_scanpos;
        if (!jj_3_22()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_136()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_137();
    }

    private boolean jj_3R_104() {
        Token token;
        if (jj_3R_138()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_144());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_105() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_3_7()) {
            this.jj_scanpos = token2;
            if (jj_3R_139()) {
                return true;
            }
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_140());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_106() {
        return jj_scan_token(83) || jj_3R_105();
    }

    private boolean jj_3R_107() {
        return jj_scan_token(83) || jj_3R_38();
    }

    private boolean jj_3R_108() {
        return jj_3R_50();
    }

    private boolean jj_3R_109() {
        Token token;
        if (jj_scan_token(51) || jj_scan_token(76) || jj_3R_50() || jj_scan_token(77) || jj_scan_token(78)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_239());
        this.jj_scanpos = token;
        return jj_scan_token(79);
    }

    private boolean jj_3R_110() {
        if (jj_scan_token(33) || jj_scan_token(76) || jj_3R_50() || jj_scan_token(77)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_240()) {
            this.jj_scanpos = token;
            if (jj_3_32()) {
                return true;
            }
        }
        Token token2 = this.jj_scanpos;
        if (!jj_3R_241()) {
            return false;
        }
        this.jj_scanpos = token2;
        return false;
    }

    private boolean jj_3R_111() {
        return jj_scan_token(60) || jj_scan_token(76) || jj_3R_50() || jj_scan_token(77) || jj_3R_56();
    }

    private boolean jj_3R_112() {
        return jj_scan_token(22) || jj_3R_56() || jj_scan_token(60) || jj_scan_token(76) || jj_3R_50() || jj_scan_token(77) || jj_scan_token(82);
    }

    private boolean jj_3R_113() {
        if (jj_scan_token(31) || jj_scan_token(76)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_242()) {
            this.jj_scanpos = token;
        }
        if (jj_scan_token(82)) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_243()) {
            this.jj_scanpos = token2;
        }
        if (jj_scan_token(82)) {
            return true;
        }
        Token token3 = this.jj_scanpos;
        if (jj_3R_244()) {
            this.jj_scanpos = token3;
        }
        return jj_scan_token(77) || jj_3R_56();
    }

    private boolean jj_3R_114() {
        Token token = this.jj_scanpos;
        if (!jj_3_33()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_141();
    }

    private boolean jj_3R_115() {
        if (jj_scan_token(13)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_153()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(82);
    }

    private boolean jj_3R_116() {
        if (jj_scan_token(20)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_154()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(82);
    }

    private boolean jj_3R_117() {
        if (jj_scan_token(47)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_155()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(82);
    }

    private boolean jj_3R_118() {
        return jj_scan_token(52) || jj_scan_token(76) || jj_3R_50() || jj_scan_token(77) || jj_3R_49();
    }

    private boolean jj_3R_119() {
        return jj_scan_token(54) || jj_3R_50() || jj_scan_token(82);
    }

    private boolean jj_3R_120() {
        Token token;
        if (jj_scan_token(57)) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_156()) {
            this.jj_scanpos = token2;
        }
        if (jj_3R_49()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_245());
        this.jj_scanpos = token;
        if (!jj_3R_246()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_121() {
        Token token = this.jj_scanpos;
        if (jj_3R_142()) {
            this.jj_scanpos = token;
            if (jj_3R_143()) {
                return true;
            }
        }
        return jj_3R_49();
    }

    private boolean jj_3R_122() {
        if (jj_scan_token(25) || jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_229()) {
            this.jj_scanpos = token;
        }
        return jj_3R_230();
    }

    private boolean jj_3R_123() {
        return jj_scan_token(73);
    }

    private boolean jj_3R_124() {
        return jj_3R_53() || jj_scan_token(73);
    }

    private boolean jj_3R_125() {
        return jj_scan_token(35) || jj_scan_token(106) || jj_scan_token(82);
    }

    private boolean jj_3R_126() {
        return jj_scan_token(12);
    }

    private boolean jj_3R_127() {
        return jj_scan_token(18);
    }

    private boolean jj_3R_128() {
        return jj_scan_token(15);
    }

    private boolean jj_3R_129() {
        return jj_scan_token(48);
    }

    private boolean jj_3R_130() {
        return jj_scan_token(37);
    }

    private boolean jj_3R_131() {
        return jj_scan_token(39);
    }

    private boolean jj_3R_132() {
        return jj_scan_token(30);
    }

    private boolean jj_3R_133() {
        return jj_scan_token(23);
    }

    private boolean jj_3R_134() {
        return jj_scan_token(149) || jj_3R_50() || jj_scan_token(150) || jj_3R_76();
    }

    private boolean jj_3R_135() {
        Token token = this.jj_scanpos;
        if (!jj_scan_token(85)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(126)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(136)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(137)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(127)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(134)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(135)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(124)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(125)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(128)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(129)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(132)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(133)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(130)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(131)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(138)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(139)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(140)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(146)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(141)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(142)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(143);
    }

    private boolean jj_3R_136() {
        Token token;
        if (jj_3R_145()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_145());
        this.jj_scanpos = token;
        return jj_3R_40();
    }

    private boolean jj_3R_137() {
        return jj_3R_40();
    }

    private boolean jj_3R_138() {
        Token token;
        if (jj_3R_146()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_147());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_139() {
        return jj_scan_token(73);
    }

    private boolean jj_3R_140() {
        return jj_scan_token(80) || jj_scan_token(81);
    }

    private boolean jj_3R_141() {
        if (jj_scan_token(31) || jj_scan_token(76)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_251()) {
            this.jj_scanpos = token;
        }
        return jj_3R_43() || jj_scan_token(73) || jj_scan_token(150) || jj_3R_50() || jj_scan_token(77) || jj_3R_56();
    }

    private boolean jj_3R_142() {
        if (jj_scan_token(14) || jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_233()) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (!jj_3R_234()) {
            return false;
        }
        this.jj_scanpos = token2;
        return false;
    }

    private boolean jj_3R_143() {
        if (jj_scan_token(38) || jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_235()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_144() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(147)) {
            this.jj_scanpos = token;
            if (jj_scan_token(148)) {
                this.jj_scanpos = token;
                if (jj_scan_token(145)) {
                    return true;
                }
            }
        }
        return jj_3R_138();
    }

    private boolean jj_3R_145() {
        return jj_scan_token(80) || jj_scan_token(81);
    }

    private boolean jj_3R_146() {
        Token token;
        if (jj_3R_148()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_149());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_147() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(98)) {
            this.jj_scanpos = token;
            if (jj_scan_token(99)) {
                return true;
            }
        }
        return jj_3R_146();
    }

    private boolean jj_3R_148() {
        Token token;
        if (jj_3R_150()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_151());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_149() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(100)) {
            this.jj_scanpos = token;
            if (jj_scan_token(101)) {
                return true;
            }
        }
        return jj_3R_148();
    }

    private boolean jj_3R_150() {
        Token token;
        if (jj_3R_152()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_157());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_151() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(110)) {
            this.jj_scanpos = token;
            if (jj_scan_token(111)) {
                return true;
            }
        }
        return jj_3R_150();
    }

    private boolean jj_3R_152() {
        Token token;
        if (jj_3R_158()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_160());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_153() {
        return jj_scan_token(73);
    }

    private boolean jj_3R_154() {
        return jj_scan_token(73);
    }

    private boolean jj_3R_155() {
        return jj_3R_50();
    }

    private boolean jj_3R_156() {
        return jj_3R_159();
    }

    private boolean jj_3R_157() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(112)) {
            this.jj_scanpos = token;
            if (jj_scan_token(113)) {
                return true;
            }
        }
        return jj_3R_152();
    }

    private boolean jj_3R_158() {
        Token token;
        if (jj_3R_161()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_162());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_159() {
        Token token;
        if (jj_scan_token(76) || jj_3R_260()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_261());
        this.jj_scanpos = token;
        return jj_scan_token(77);
    }

    private boolean jj_3R_160() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(108)) {
            this.jj_scanpos = token;
            if (jj_scan_token(109)) {
                return true;
            }
        }
        return jj_3R_158();
    }

    private boolean jj_3R_161() {
        if (jj_3R_163()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_164()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_162() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(92)) {
            this.jj_scanpos = token;
            if (jj_scan_token(97)) {
                return true;
            }
        }
        return jj_3R_161();
    }

    private boolean jj_3R_163() {
        Token token;
        if (jj_3R_165()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_166());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_164() {
        return jj_scan_token(36) || jj_3R_43();
    }

    private boolean jj_3R_165() {
        Token token;
        if (jj_3R_167()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_168());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_166() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(88)) {
            this.jj_scanpos = token;
            if (jj_scan_token(89)) {
                this.jj_scanpos = token;
                if (jj_scan_token(86)) {
                    this.jj_scanpos = token;
                    if (jj_scan_token(87)) {
                        this.jj_scanpos = token;
                        if (jj_scan_token(93)) {
                            this.jj_scanpos = token;
                            if (jj_scan_token(94)) {
                                this.jj_scanpos = token;
                                if (jj_scan_token(95)) {
                                    this.jj_scanpos = token;
                                    if (jj_scan_token(96)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return jj_3R_165();
    }

    private boolean jj_3R_167() {
        Token token;
        if (jj_3R_169()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_170());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_168() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(118)) {
            this.jj_scanpos = token;
            if (jj_scan_token(119)) {
                this.jj_scanpos = token;
                if (jj_scan_token(120)) {
                    this.jj_scanpos = token;
                    if (jj_scan_token(121)) {
                        this.jj_scanpos = token;
                        if (jj_scan_token(122)) {
                            this.jj_scanpos = token;
                            if (jj_scan_token(123)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return jj_3R_167();
    }

    private boolean jj_3R_169() {
        Token token;
        if (jj_3R_171()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_172());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_170() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(104)) {
            this.jj_scanpos = token;
            if (jj_scan_token(105)) {
                return true;
            }
        }
        return jj_3R_169();
    }

    private boolean jj_3R_171() {
        Token token;
        if (jj_3R_173()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_174());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_172() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(106)) {
            this.jj_scanpos = token;
            if (jj_scan_token(107)) {
                this.jj_scanpos = token;
                if (jj_scan_token(114)) {
                    this.jj_scanpos = token;
                    if (jj_scan_token(115)) {
                        return true;
                    }
                }
            }
        }
        return jj_3R_171();
    }

    private boolean jj_3R_173() {
        Token token = this.jj_scanpos;
        if (!jj_3R_175()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_176()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_177()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_178()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_179();
    }

    private boolean jj_3R_174() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(116)) {
            this.jj_scanpos = token;
            if (jj_scan_token(117)) {
                return true;
            }
        }
        return jj_3R_173();
    }

    private boolean jj_3R_175() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(104)) {
            this.jj_scanpos = token;
            if (jj_scan_token(105)) {
                this.jj_scanpos = token;
                if (jj_scan_token(91)) {
                    this.jj_scanpos = token;
                    if (jj_scan_token(90)) {
                        return true;
                    }
                }
            }
        }
        return jj_3R_173();
    }

    private boolean jj_3R_176() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(102)) {
            this.jj_scanpos = token;
            if (jj_scan_token(103)) {
                return true;
            }
        }
        return jj_3R_182();
    }

    private boolean jj_3R_177() {
        return jj_3R_180();
    }

    private boolean jj_3R_178() {
        return jj_3R_181();
    }

    private boolean jj_3R_179() {
        if (jj_3R_182()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_183()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_180() {
        Token token = this.jj_scanpos;
        if (jj_3R_184()) {
            this.jj_scanpos = token;
            if (jj_scan_token(73)) {
                return true;
            }
        }
        if (jj_scan_token(144)) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (!jj_3R_186()) {
            return false;
        }
        this.jj_scanpos = token2;
        return jj_3R_187();
    }

    private boolean jj_3R_181() {
        return jj_scan_token(76) || jj_3R_43() || jj_scan_token(77) || jj_3R_173();
    }

    private boolean jj_3R_182() {
        Token token;
        if (jj_3R_185()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_12());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_183() {
        Token token = this.jj_scanpos;
        if (!jj_scan_token(102)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(103);
    }

    private boolean jj_3R_184() {
        return jj_3R_54();
    }

    private boolean jj_3R_185() {
        Token token = this.jj_scanpos;
        if (!jj_3R_188()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_189()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_190()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_191()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_192()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_193();
    }

    private boolean jj_3R_186() {
        return jj_3R_49();
    }

    private boolean jj_3R_187() {
        return jj_3R_50();
    }

    private boolean jj_3R_188() {
        return jj_3R_194();
    }

    private boolean jj_3R_189() {
        return jj_scan_token(76) || jj_3R_50() || jj_scan_token(77);
    }

    private boolean jj_3R_190() {
        return jj_3R_48();
    }

    private boolean jj_3R_191() {
        return jj_3R_195();
    }

    private boolean jj_3R_192() {
        return jj_3R_43();
    }

    private boolean jj_3R_193() {
        return jj_3R_38();
    }

    private boolean jj_3R_194() {
        Token token = this.jj_scanpos;
        if (!jj_3R_196()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_197()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_198()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_199()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_200()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_201()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_202()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_203();
    }

    private boolean jj_3R_195() {
        return jj_3R_38() || jj_3R_204();
    }

    private boolean jj_3R_196() {
        return jj_scan_token(61);
    }

    private boolean jj_3R_197() {
        return jj_scan_token(66);
    }

    private boolean jj_3R_198() {
        return jj_scan_token(69);
    }

    private boolean jj_3R_199() {
        return jj_scan_token(70);
    }

    private boolean jj_3R_200() {
        return jj_scan_token(71);
    }

    private boolean jj_3R_201() {
        return jj_3R_209();
    }

    private boolean jj_3R_202() {
        return jj_scan_token(42);
    }

    private boolean jj_3R_203() {
        return jj_scan_token(58);
    }

    private boolean jj_3R_204() {
        if (jj_scan_token(76)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_213()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(77);
    }

    private boolean jj_3R_205() {
        return jj_3R_50();
    }

    private boolean jj_3R_206() {
        Token token = this.jj_scanpos;
        if (!jj_3R_214()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_215();
    }

    private boolean jj_3R_207() {
        return jj_3R_204();
    }

    private boolean jj_3R_208() {
        return jj_3R_204();
    }

    private boolean jj_3R_209() {
        Token token = this.jj_scanpos;
        if (!jj_3R_216()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_217();
    }

    private boolean jj_3R_210() {
        return jj_3R_101() || jj_3R_103();
    }

    private boolean jj_3R_211() {
        if (jj_3R_38()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_218()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_219();
    }

    private boolean jj_3R_212() {
        return jj_3R_103();
    }

    private boolean jj_3R_213() {
        return jj_3R_220();
    }

    private boolean jj_3R_214() {
        if (jj_scan_token(151)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_221()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_215() {
        if (jj_scan_token(150)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_222()) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (!jj_3R_223()) {
            return false;
        }
        this.jj_scanpos = token2;
        return false;
    }

    private boolean jj_3R_216() {
        return jj_scan_token(56);
    }

    private boolean jj_3R_217() {
        return jj_scan_token(27);
    }

    private boolean jj_3R_218() {
        return jj_3R_103();
    }

    private boolean jj_3R_219() {
        if (jj_3R_204()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3_19()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_220() {
        Token token;
        if (jj_3R_50()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_224());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_221() {
        return jj_3R_50();
    }

    private boolean jj_3R_222() {
        return jj_3R_50();
    }

    private boolean jj_3R_223() {
        if (jj_scan_token(150)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_225()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_224() {
        return jj_scan_token(83) || jj_3R_50();
    }

    private boolean jj_3R_225() {
        return jj_3R_50();
    }

    private boolean jj_3R_226() {
        return jj_scan_token(55) || jj_3R_81();
    }

    private boolean jj_3R_227() {
        return jj_3R_49();
    }

    private boolean jj_3R_228() {
        return jj_scan_token(83) || jj_3R_59();
    }

    private boolean jj_3R_229() {
        return jj_scan_token(34) || jj_3R_81();
    }

    private boolean jj_3R_230() {
        Token token;
        if (jj_scan_token(78)) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_236()) {
            this.jj_scanpos = token2;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_237());
        this.jj_scanpos = token;
        if (jj_3R_238()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(79);
    }

    private boolean jj_3R_231() {
        return jj_scan_token(80) || jj_scan_token(81);
    }

    private boolean jj_3R_232() {
        return jj_scan_token(85) || jj_3R_41();
    }

    private boolean jj_3R_233() {
        return jj_scan_token(26) || jj_3R_38();
    }

    private boolean jj_3R_234() {
        return jj_scan_token(34) || jj_3R_81();
    }

    private boolean jj_3R_235() {
        return jj_scan_token(26) || jj_3R_81();
    }

    private boolean jj_3R_236() {
        return jj_3R_247();
    }

    private boolean jj_3R_237() {
        return jj_scan_token(83) || jj_3R_247();
    }

    private boolean jj_3R_238() {
        Token token;
        if (jj_scan_token(82)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_2());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_239() {
        Token token;
        if (jj_3R_248()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_31());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_240() {
        return jj_scan_token(82);
    }

    private boolean jj_3R_241() {
        return jj_scan_token(24) || jj_3R_56();
    }

    private boolean jj_3R_242() {
        return jj_3R_249();
    }

    private boolean jj_3R_243() {
        return jj_3R_50();
    }

    private boolean jj_3R_244() {
        return jj_3R_250();
    }

    private boolean jj_3R_245() {
        return jj_scan_token(17) || jj_scan_token(76) || jj_3R_252() || jj_scan_token(77) || jj_3R_49();
    }

    private boolean jj_3R_246() {
        return jj_scan_token(29) || jj_3R_49();
    }

    private boolean jj_3R_247() {
        if (jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_253()) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (!jj_3R_254()) {
            return false;
        }
        this.jj_scanpos = token2;
        return false;
    }

    private boolean jj_3R_248() {
        Token token = this.jj_scanpos;
        if (!jj_3R_255()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_256();
    }

    private boolean jj_3R_249() {
        Token token = this.jj_scanpos;
        if (!jj_3R_257()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_258();
    }

    private boolean jj_3R_250() {
        return jj_3R_259();
    }

    private boolean jj_3R_251() {
        return jj_scan_token(28);
    }

    private boolean jj_3R_252() {
        Token token = this.jj_scanpos;
        if (!jj_3_35()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_262();
    }

    private boolean jj_3R_253() {
        return jj_3R_204();
    }

    private boolean jj_3R_254() {
        return jj_3R_49();
    }

    private boolean jj_3R_255() {
        return jj_scan_token(16) || jj_3R_50() || jj_scan_token(150);
    }

    private boolean jj_3R_256() {
        return jj_scan_token(154);
    }

    private boolean jj_3R_257() {
        return jj_3R_97();
    }

    private boolean jj_3R_258() {
        return jj_3R_259();
    }

    private boolean jj_3R_259() {
        Token token;
        if (jj_3R_108()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_263());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_260() {
        Token token = this.jj_scanpos;
        if (!jj_3_36()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_264();
    }

    private boolean jj_3R_261() {
        return jj_scan_token(82) || jj_3R_260();
    }

    private boolean jj_3R_262() {
        return jj_scan_token(73);
    }

    private boolean jj_3R_263() {
        return jj_scan_token(83) || jj_3R_108();
    }

    private boolean jj_3R_264() {
        return jj_3R_59();
    }

    private boolean jj_3R_36() {
        Token token = this.jj_scanpos;
        if (!jj_3R_60()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_61()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_62()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_63()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3_30()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_64()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_65()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_66();
    }

    private boolean jj_3R_37() {
        return jj_scan_token(49);
    }

    private boolean jj_3R_38() {
        Token token;
        if (jj_scan_token(73)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_9());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_39() {
        return jj_scan_token(84) || jj_scan_token(106);
    }

    private boolean jj_3R_40() {
        if (jj_scan_token(78)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_67()) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (jj_scan_token(83)) {
            this.jj_scanpos = token2;
        }
        return jj_scan_token(79);
    }

    private boolean jj_3R_41() {
        Token token = this.jj_scanpos;
        if (!jj_3_5()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_68();
    }

    private boolean jj_3R_42() {
        return jj_scan_token(28);
    }

    private boolean jj_3R_43() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_3R_69()) {
            this.jj_scanpos = token2;
            if (jj_3R_70()) {
                return true;
            }
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_8());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_44() {
        return jj_scan_token(152);
    }

    private boolean jj_3R_45() {
        return jj_3R_54();
    }

    private boolean jj_3R_46() {
        Token token = this.jj_scanpos;
        if (jj_3_15()) {
            this.jj_scanpos = token;
            if (jj_3R_71()) {
                this.jj_scanpos = token;
                this.jj_lookingAhead = true;
                boolean z = getToken(1).kind == 151 && (getToken(2).kind == 73 || getToken(2).kind == 41) && getToken(3).kind != 81;
                this.jj_semLA = z;
                this.jj_lookingAhead = false;
                if (!z || jj_3R_72()) {
                    this.jj_scanpos = token;
                    if (jj_3_16()) {
                        this.jj_scanpos = token;
                        if (jj_3_17()) {
                            this.jj_scanpos = token;
                            if (jj_3R_73()) {
                                this.jj_scanpos = token;
                                if (jj_3_18()) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_47() {
        return jj_3R_50();
    }

    private boolean jj_3R_48() {
        Token token = this.jj_scanpos;
        if (!jj_3R_74()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_75();
    }

    private boolean jj_3R_49() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_scan_token(49)) {
            this.jj_scanpos = token2;
        }
        if (jj_scan_token(78)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_25());
        this.jj_scanpos = token;
        return jj_scan_token(79);
    }

    private boolean jj_3R_50() {
        if (jj_3R_76()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_102()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_51() {
        return jj_scan_token(73) || jj_scan_token(150) || jj_3R_56();
    }

    private boolean jj_3R_52() {
        Token token;
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_77());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_53() {
        Token token = this.jj_scanpos;
        if (!jj_3R_78()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_79();
    }

    private boolean jj_3R_54() {
        if (jj_scan_token(76)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_80()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(77);
    }

    private boolean jj_3R_55() {
        return jj_scan_token(55) || jj_3R_81();
    }

    private boolean jj_3R_56() {
        Token token = this.jj_scanpos;
        if (jj_3_23()) {
            this.jj_scanpos = token;
            if (jj_3_24()) {
                this.jj_scanpos = token;
                if (jj_scan_token(82)) {
                    this.jj_scanpos = token;
                    if (jj_3R_82()) {
                        this.jj_scanpos = token;
                        if (jj_3R_83()) {
                            this.jj_scanpos = token;
                            if (jj_3R_84()) {
                                this.jj_scanpos = token;
                                if (jj_3R_85()) {
                                    this.jj_scanpos = token;
                                    if (jj_3R_86()) {
                                        this.jj_scanpos = token;
                                        this.jj_lookingAhead = true;
                                        boolean zIsRegularForStatement = isRegularForStatement();
                                        this.jj_semLA = zIsRegularForStatement;
                                        this.jj_lookingAhead = false;
                                        if (!zIsRegularForStatement || jj_3R_87()) {
                                            this.jj_scanpos = token;
                                            if (jj_3R_88()) {
                                                this.jj_scanpos = token;
                                                if (jj_3R_89()) {
                                                    this.jj_scanpos = token;
                                                    if (jj_3R_90()) {
                                                        this.jj_scanpos = token;
                                                        if (jj_3R_91()) {
                                                            this.jj_scanpos = token;
                                                            if (jj_3R_92()) {
                                                                this.jj_scanpos = token;
                                                                if (jj_3R_93()) {
                                                                    this.jj_scanpos = token;
                                                                    if (jj_3R_94()) {
                                                                        return true;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean jj_3R_57() {
        return jj_scan_token(28);
    }

    private boolean jj_3R_58() {
        return jj_scan_token(110) || jj_3R_43();
    }

    private boolean jj_3R_59() {
        Token token;
        if (jj_scan_token(73)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_231());
        this.jj_scanpos = token;
        if (!jj_3R_232()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_60() {
        return jj_3R_95();
    }

    private boolean jj_3R_61() {
        return jj_3R_96();
    }

    private boolean jj_3R_62() {
        return jj_3R_96();
    }

    private boolean jj_3R_63() {
        return jj_3R_97() || jj_scan_token(82);
    }

    private boolean jj_3R_64() {
        return jj_3R_98();
    }

    private boolean jj_3R_65() {
        return jj_3R_99();
    }

    private boolean jj_3R_66() {
        return jj_3R_100();
    }

    private boolean jj_3R_67() {
        Token token;
        if (jj_3R_41()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_6());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_68() {
        return jj_3R_50();
    }

    private boolean jj_3R_69() {
        return jj_3R_101();
    }

    private boolean jj_3R_70() {
        return jj_3R_38();
    }

    private boolean jj_3R_71() {
        if (jj_scan_token(80)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_205()) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_206()) {
            this.jj_scanpos = token2;
        }
        return jj_scan_token(81);
    }

    private boolean jj_3R_72() {
        if (jj_scan_token(151)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_scan_token(73)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(41);
    }

    private boolean jj_3R_73() {
        return jj_scan_token(78) || jj_3R_50() || jj_scan_token(79);
    }

    private boolean jj_3R_74() {
        if (jj_scan_token(41)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_210()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_211()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_212();
    }

    private boolean jj_3R_75() {
        return jj_3R_103();
    }

    private boolean jj_3R_76() {
        if (jj_3R_104()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_134()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_77() {
        Token token = this.jj_scanpos;
        if (!jj_scan_token(44)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(45)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(46)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(52)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(28)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(40)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(53)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(59)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(11)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(49)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(50)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(21);
    }

    private boolean jj_3R_78() {
        return jj_scan_token(58);
    }

    private boolean jj_3R_79() {
        return jj_3R_43();
    }

    private boolean jj_3R_80() {
        Token token;
        if (jj_3R_105()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_106());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_81() {
        Token token;
        if (jj_3R_38()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_107());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_82() {
        return jj_3R_108() || jj_scan_token(82);
    }

    private boolean jj_3R_83() {
        return jj_3R_109();
    }

    private boolean jj_3R_84() {
        return jj_3R_110();
    }

    private boolean jj_3R_85() {
        return jj_3R_111();
    }

    private boolean jj_3R_86() {
        return jj_3R_112();
    }

    private boolean jj_3R_87() {
        return jj_3R_113();
    }

    private boolean jj_3R_88() {
        return jj_3R_114();
    }

    private boolean jj_3R_89() {
        return jj_3R_115();
    }

    private boolean jj_3R_90() {
        return jj_3R_116();
    }

    private boolean jj_3R_91() {
        return jj_3R_117();
    }

    private boolean jj_3R_92() {
        return jj_3R_118();
    }

    private boolean jj_3R_93() {
        return jj_3R_119();
    }

    private boolean jj_3R_94() {
        return jj_3R_120();
    }

    private boolean jj_3R_95() {
        if (jj_3R_52()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_121()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_122();
    }

    private boolean jj_3R_96() {
        if (jj_3R_52()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_123()) {
            this.jj_scanpos = token;
            if (jj_3R_124()) {
                return true;
            }
        }
        if (jj_3R_54()) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_226()) {
            this.jj_scanpos = token2;
        }
        Token token3 = this.jj_scanpos;
        if (!jj_3R_227()) {
            return false;
        }
        this.jj_scanpos = token3;
        return jj_scan_token(82);
    }

    private boolean jj_3R_97() {
        Token token;
        if (jj_3R_52() || jj_3R_43() || jj_3R_59()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_228());
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3R_98() {
        Token token = this.jj_scanpos;
        if (!jj_3_4()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_125();
    }

    private boolean jj_3R_99() {
        return jj_scan_token(43) || jj_3R_38();
    }

    private boolean jj_3_1() {
        return jj_3R_36();
    }

    private boolean jj_3_10() {
        Token token = this.jj_scanpos;
        if (jj_3R_45()) {
            this.jj_scanpos = token;
            if (jj_scan_token(73)) {
                return true;
            }
        }
        return jj_scan_token(144);
    }

    private boolean jj_3_11() {
        return jj_scan_token(76) || jj_3R_43() || jj_scan_token(77);
    }

    private boolean jj_3_12() {
        return jj_3R_46();
    }

    private boolean jj_3_13() {
        if (jj_3R_38() || jj_scan_token(76)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_47()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(77);
    }

    private boolean jj_3_14() {
        return jj_3R_43() || jj_scan_token(84) || jj_scan_token(14);
    }

    private boolean jj_3_15() {
        return jj_scan_token(84) || jj_scan_token(14);
    }

    private boolean jj_3_16() {
        if (jj_scan_token(153) || jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_207()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3_17() {
        if (jj_scan_token(84) || jj_scan_token(73)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_3R_208()) {
            return false;
        }
        this.jj_scanpos = token;
        return false;
    }

    private boolean jj_3_18() {
        return jj_scan_token(84) || jj_3R_48();
    }

    private boolean jj_3_19() {
        return jj_3R_49();
    }

    private boolean jj_3_2() {
        return jj_3R_36();
    }

    private boolean jj_3_20() {
        return jj_scan_token(80) || jj_3R_50() || jj_scan_token(81);
    }

    private boolean jj_3_21() {
        return jj_scan_token(80) || jj_scan_token(81);
    }

    private boolean jj_3_22() {
        Token token;
        Token token2;
        if (jj_3_20()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3_20());
        this.jj_scanpos = token;
        do {
            token2 = this.jj_scanpos;
        } while (!jj_3_21());
        this.jj_scanpos = token2;
        return false;
    }

    private boolean jj_3_23() {
        return jj_3R_51();
    }

    private boolean jj_3_24() {
        return jj_3R_49();
    }

    private boolean jj_3_25() {
        return jj_3R_36();
    }

    private boolean jj_3_26() {
        if (jj_3R_52()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (!jj_scan_token(14)) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_scan_token(38)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(25);
    }

    private boolean jj_3_27() {
        return jj_3R_52() || jj_3R_53() || jj_scan_token(73) || jj_scan_token(76);
    }

    private boolean jj_3_28() {
        if (jj_3R_52() || jj_scan_token(73) || jj_3R_54()) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_55()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(78);
    }

    private boolean jj_3_29() {
        return jj_3R_52() || jj_3R_43() || jj_scan_token(73);
    }

    private boolean jj_3_3() {
        return jj_scan_token(73) || jj_scan_token(76);
    }

    private boolean jj_3_30() {
        return jj_3R_56();
    }

    private boolean jj_3_31() {
        return jj_3R_36();
    }

    private boolean jj_3_32() {
        return jj_3R_56();
    }

    private boolean jj_3_33() {
        return jj_scan_token(31) || jj_scan_token(76) || jj_scan_token(73) || jj_scan_token(150) || jj_3R_50() || jj_scan_token(77) || jj_3R_56();
    }

    private boolean jj_3_34() {
        return jj_3R_52() || jj_3R_43() || jj_scan_token(73);
    }

    private boolean jj_3_35() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_3R_57()) {
            this.jj_scanpos = token2;
        }
        if (jj_3R_43()) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_58());
        this.jj_scanpos = token;
        return jj_scan_token(73);
    }

    private boolean jj_3_36() {
        return jj_3R_43() || jj_3R_59();
    }

    private boolean jj_3_4() {
        if (jj_scan_token(35)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_37()) {
            this.jj_scanpos = token;
        }
        if (jj_3R_38()) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_39()) {
            this.jj_scanpos = token2;
        }
        return jj_scan_token(82);
    }

    private boolean jj_3_5() {
        return jj_3R_40();
    }

    private boolean jj_3_6() {
        return jj_scan_token(83) || jj_3R_41();
    }

    private boolean jj_3_7() {
        Token token = this.jj_scanpos;
        if (jj_3R_42()) {
            this.jj_scanpos = token;
        }
        if (jj_3R_43()) {
            return true;
        }
        Token token2 = this.jj_scanpos;
        if (jj_3R_44()) {
            this.jj_scanpos = token2;
        }
        return jj_scan_token(73);
    }

    private boolean jj_3_8() {
        return jj_scan_token(80) || jj_scan_token(81);
    }

    private boolean jj_3_9() {
        return jj_scan_token(84) || jj_scan_token(73);
    }

    private void jj_add_error_token(int i, int i2) {
        if (i2 >= 100) {
            return;
        }
        int i3 = this.jj_endpos;
        if (i2 == i3 + 1) {
            int[] iArr = this.jj_lasttokens;
            this.jj_endpos = i3 + 1;
            iArr[i3] = i;
            return;
        }
        if (i3 != 0) {
            this.jj_expentry = new int[i3];
            for (int i4 = 0; i4 < this.jj_endpos; i4++) {
                this.jj_expentry[i4] = this.jj_lasttokens[i4];
            }
            loop1: for (int[] iArr2 : this.jj_expentries) {
                if (iArr2.length == this.jj_expentry.length) {
                    int i5 = 0;
                    while (true) {
                        int[] iArr3 = this.jj_expentry;
                        if (i5 >= iArr3.length) {
                            this.jj_expentries.add(iArr3);
                            break loop1;
                        } else if (iArr2[i5] != iArr3[i5]) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            }
            if (i2 != 0) {
                this.jj_endpos = i2;
                this.jj_lasttokens[i2 - 1] = i;
            }
        }
    }

    private Token jj_consume_token(int i) throws ParseException {
        Token token = this.token;
        Token token2 = token.next;
        if (token2 != null) {
            this.token = token2;
        } else {
            token.next = this.token_source.getNextToken();
            this.token = this.token.next;
        }
        this.jj_ntk = -1;
        if (this.token.kind != i) {
            this.token = token;
            this.jj_kind = i;
            throw generateParseException();
        }
        this.jj_gen++;
        int i2 = this.jj_gc + 1;
        this.jj_gc = i2;
        if (i2 > 100) {
            int i3 = 0;
            this.jj_gc = 0;
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i3 >= jJCallsArr.length) {
                    break;
                }
                for (JJCalls jJCalls = jJCallsArr[i3]; jJCalls != null; jJCalls = jJCalls.next) {
                    if (jJCalls.gen < this.jj_gen) {
                        jJCalls.first = null;
                    }
                }
                i3++;
            }
        }
        return this.token;
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{1, 270534656, 270534656, 67108864, 0, 67108864, 16384, 0, 33570816, 0, 0, 0, 0, 0, 1082429440, 0, 0, 0, 0, 0, 0, 0, 1216647168, 1216647168, 0, 0, 1350864896, 268435456, 0, 0, 1082429440, 1082429440, 1082429440, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1216647168, 0, 1216647168, 134217728, 0, 1216647168, 1216647168, 1216647168, 1216647168, 0, 0, 0, 0, 0, 0, 0, 0, 134217728, 134217728, 1216647168, 0, 0, 1082429440, 0, 0, 0, 1220841472, -2146426880, 0, 0, 65536, 65536, 0, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, 1487181824, 1216647168, 1216647168, 268435456, Integer.MIN_VALUE, 1216647168, 0, 0, 0, 0, 1216647168, 0, 131072, 536870912, 268435456, 0, 0, 0, 0};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0, 137785600, 137785600, 0, 4, 0, 64, 4, 64, 0, 131072, 0, 0, 0, 67174560, 8388608, 131072, 131072, 0, 8, 0, 0, 620824224, 620824224, 0, 0, 65696, 0, 0, 0, 65696, 67174560, 65696, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 620824224, 0, 620955296, 620758528, 0, 620824224, 620824224, 620824224, 620824224, 0, 0, 0, 512, 0, 0, 0, 0, 620758016, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, 620824224, 0, 0, 65696, 512, 0, 0, 889783970, 38830080, 131072, 2056, 0, 0, 0, 0, 758609824, 620824224, 620824224, 0, 0, 620824224, 0, 0, 0, 0, 620824224, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private static void jj_la1_init_2() {
        jj_la1_2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 4096, 16384, 512, Opcodes.ASM8, 262144, 512, 0, 278528, 0, 1048576, 0, 65536, 2097152, 201413348, 201413348, Opcodes.ASM8, Opcodes.ASM8, 512, 0, 0, 512, 512, 512, 0, Opcodes.ASM8, 2097152, 2097152, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 268435456, 268435456, 0, -473956352, -473956352, 0, 0, 0, 0, 0, 0, 0, 0, 201326592, 0, 0, 0, 201326592, 86756, 4608, 201413348, 86244, 512, 201413348, 201413348, 201413348, 201413348, 0, 0, 0, 512, 4096, 4096, 65536, 16384, 228, 0, 201413348, Opcodes.ASM8, 86016, 82432, 81920, 65536, 81920, 201675492, 0, 0, 256, 0, 0, 262144, 0, 201413348, 201413348, 201413348, 0, 0, 201413348, Opcodes.ASM8, Opcodes.ASM8, 512, 512, 201413348, 4096, 0, 0, 0, 0, 512, 262144, 512};
    }

    private static void jj_la1_init_3() {
        jj_la1_3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 960, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -268435456, -268435456, 0, 0, 0, 12, 12, 48, 48, 49152, 49152, 196608, 196608, 12288, 12288, 2, 2, 0, 1, 1, 264241152, 264241152, com.android.dx.io.Opcodes.FILL_ARRAY_DATA_PAYLOAD, com.android.dx.io.Opcodes.FILL_ARRAY_DATA_PAYLOAD, 789504, 789504, 3145728, 3145728, com.android.dx.io.Opcodes.FILL_ARRAY_DATA_PAYLOAD, 192, 192, 192, 960, 0, 0, 960, 0, 0, 960, 960, 960, 960, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 960, 0, 0, 0, 0, 0, 0, 0, 960, 960, 960, 0, 0, 960, 0, 0, 0, 0, 960, 0, 0, 0, 0, 16384, 0, 0, 0};
    }

    private static void jj_la1_init_4() {
        jj_la1_4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE, 0, 0, 0, 0, 0, 327679, 327679, 2097152, 1703936, 1703936, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4194304, 12582912, 12582912, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67108864, 67108864, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private int jj_ntk_f() {
        Token token = this.token;
        Token token2 = token.next;
        this.jj_nt = token2;
        if (token2 != null) {
            int i = token2.kind;
            this.jj_ntk = i;
            return i;
        }
        token.next = this.token_source.getNextToken();
        int i2 = this.token.next.kind;
        this.jj_ntk = i2;
        return i2;
    }

    private void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i = 0; i < 36; i++) {
            try {
                JJCalls jJCalls = this.jj_2_rtns[i];
                do {
                    if (jJCalls.gen > this.jj_gen) {
                        this.jj_la = jJCalls.arg;
                        Token token = jJCalls.first;
                        this.jj_scanpos = token;
                        this.jj_lastpos = token;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                            case 7:
                                jj_3_8();
                                break;
                            case 8:
                                jj_3_9();
                                break;
                            case 9:
                                jj_3_10();
                                break;
                            case 10:
                                jj_3_11();
                                break;
                            case 11:
                                jj_3_12();
                                break;
                            case 12:
                                jj_3_13();
                                break;
                            case 13:
                                jj_3_14();
                                break;
                            case 14:
                                jj_3_15();
                                break;
                            case 15:
                                jj_3_16();
                                break;
                            case 16:
                                jj_3_17();
                                break;
                            case 17:
                                jj_3_18();
                                break;
                            case 18:
                                jj_3_19();
                                break;
                            case 19:
                                jj_3_20();
                                break;
                            case 20:
                                jj_3_21();
                                break;
                            case 21:
                                jj_3_22();
                                break;
                            case 22:
                                jj_3_23();
                                break;
                            case 23:
                                jj_3_24();
                                break;
                            case 24:
                                jj_3_25();
                                break;
                            case 25:
                                jj_3_26();
                                break;
                            case 26:
                                jj_3_27();
                                break;
                            case 27:
                                jj_3_28();
                                break;
                            case 28:
                                jj_3_29();
                                break;
                            case 29:
                                jj_3_30();
                                break;
                            case 30:
                                jj_3_31();
                                break;
                            case 31:
                                jj_3_32();
                                break;
                            case 32:
                                jj_3_33();
                                break;
                            case 33:
                                jj_3_34();
                                break;
                            case 34:
                                jj_3_35();
                                break;
                            case 35:
                                jj_3_36();
                                break;
                        }
                    }
                    jJCalls = jJCalls.next;
                } while (jJCalls != null);
            } catch (LookaheadSuccess unused) {
            }
        }
        this.jj_rescan = false;
    }

    private void jj_save(int i, int i2) {
        JJCalls jJCalls = this.jj_2_rtns[i];
        while (jJCalls.gen > this.jj_gen) {
            JJCalls jJCalls2 = jJCalls.next;
            if (jJCalls2 == null) {
                JJCalls jJCalls3 = new JJCalls();
                jJCalls.next = jJCalls3;
                jJCalls = jJCalls3;
                break;
            }
            jJCalls = jJCalls2;
        }
        jJCalls.gen = (this.jj_gen + i2) - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = i2;
    }

    private boolean jj_scan_token(int i) {
        Token token = this.jj_scanpos;
        if (token == this.jj_lastpos) {
            this.jj_la--;
            Token token2 = token.next;
            if (token2 == null) {
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                this.jj_scanpos = nextToken;
                this.jj_lastpos = nextToken;
            } else {
                this.jj_scanpos = token2;
                this.jj_lastpos = token2;
            }
        } else {
            this.jj_scanpos = token.next;
        }
        if (this.jj_rescan) {
            Token token3 = this.token;
            int i2 = 0;
            while (token3 != null && token3 != this.jj_scanpos) {
                i2++;
                token3 = token3.next;
            }
            if (token3 != null) {
                jj_add_error_token(i, i2);
            }
        }
        Token token4 = this.jj_scanpos;
        if (token4.kind != i) {
            return true;
        }
        if (this.jj_la == 0 && token4 == this.jj_lastpos) {
            throw this.jj_ls;
        }
        return false;
    }

    public static void main(String[] strArr) throws IOException {
        int i = strArr[0].equals("-p") ? 1 : 0;
        int i2 = i;
        while (i < strArr.length) {
            FileReader fileReader = new FileReader(strArr[i]);
            Parser parser = new Parser(fileReader);
            parser.setRetainComments(true);
            while (!parser.Line()) {
                if (i2 != 0) {
                    System.out.println(parser.popNode());
                }
            }
            fileReader.close();
            i++;
        }
    }

    public final void AdditiveExpression() throws Throwable {
        Token tokenJj_consume_token;
        MultiplicativeExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 104 && iJj_ntk_f != 105) {
                this.jj_la1[56] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 104) {
                tokenJj_consume_token = jj_consume_token(104);
            } else {
                if (iJj_ntk_f2 != 105) {
                    this.jj_la1[57] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(105);
            }
            MultiplicativeExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void AllocationExpression() throws Throwable {
        boolean z;
        BSHAllocationExpression bSHAllocationExpression = new BSHAllocationExpression(26);
        this.jjtree.openNodeScope(bSHAllocationExpression);
        jjtreeOpenNodeScope(bSHAllocationExpression);
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 41) {
                if (iJj_ntk_f != 78 && iJj_ntk_f != 80) {
                    this.jj_la1[90] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                ArrayDimensions();
            } else {
                jj_consume_token(41);
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                switch (iJj_ntk_f2) {
                    case 12:
                    case 15:
                    case 18:
                    case 23:
                    case 30:
                    case 37:
                    case 39:
                    case 48:
                        PrimitiveType();
                        ArrayDimensions();
                        break;
                    case 73:
                        AmbiguousName();
                        int iJj_ntk_f3 = this.jj_ntk;
                        if (iJj_ntk_f3 == -1) {
                            iJj_ntk_f3 = jj_ntk_f();
                        }
                        if (iJj_ntk_f3 == 76) {
                            Arguments();
                            if (jj_2_19(2)) {
                                Block();
                            }
                        } else {
                            if (iJj_ntk_f3 != 78 && iJj_ntk_f3 != 80) {
                                this.jj_la1[88] = this.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                            ArrayDimensions();
                        }
                        break;
                    case 78:
                    case 80:
                        ArrayDimensions();
                        break;
                    default:
                        this.jj_la1[89] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            }
            this.jjtree.closeNodeScope((Node) bSHAllocationExpression, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHAllocationExpression);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHAllocationExpression);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHAllocationExpression, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHAllocationExpression);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void AmbiguousName() throws Throwable {
        boolean z;
        StringBuilder sb;
        BSHAmbiguousName bSHAmbiguousName = new BSHAmbiguousName(14);
        this.jjtree.openNodeScope(bSHAmbiguousName);
        jjtreeOpenNodeScope(bSHAmbiguousName);
        try {
            sb = new StringBuilder(jj_consume_token(73).image);
            while (jj_2_9(2)) {
                jj_consume_token(84);
                sb.append("." + jj_consume_token(73).image);
            }
            this.jjtree.closeNodeScope((Node) bSHAmbiguousName, true);
        } catch (Throwable th) {
            th = th;
            z = true;
        }
        try {
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHAmbiguousName);
            }
            bSHAmbiguousName.text = sb.toString();
        } catch (Throwable th2) {
            z = false;
            th = th2;
            if (z) {
                this.jjtree.closeNodeScope((Node) bSHAmbiguousName, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHAmbiguousName);
                }
            }
            throw th;
        }
    }

    public final void AndExpression() throws Throwable {
        Token tokenJj_consume_token;
        EqualityExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 108 && iJj_ntk_f != 109) {
                this.jj_la1[47] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 108) {
                tokenJj_consume_token = jj_consume_token(108);
            } else {
                if (iJj_ntk_f2 != 109) {
                    this.jj_la1[48] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(109);
            }
            EqualityExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void ArgumentList() throws Throwable {
        Expression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 83) {
                this.jj_la1[87] = this.jj_gen;
                return;
            } else {
                jj_consume_token(83);
                Expression();
            }
        }
    }

    public final void Arguments() throws Throwable {
        boolean z;
        BSHArguments bSHArguments = new BSHArguments(25);
        this.jjtree.openNodeScope(bSHArguments);
        jjtreeOpenNodeScope(bSHArguments);
        try {
            jj_consume_token(76);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    ArgumentList();
                    break;
                default:
                    this.jj_la1[86] = this.jj_gen;
                    break;
            }
            jj_consume_token(77);
            this.jjtree.closeNodeScope((Node) bSHArguments, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHArguments);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHArguments);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHArguments, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHArguments);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:111:0x009e  */
    /* JADX WARN: Found duplicated region for block: B:113:0x00ab  */
    /* JADX WARN: Found duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ArrayDimensions() throws Throwable {
        boolean z;
        int iJj_ntk_f;
        BSHArrayDimensions bSHArrayDimensions = new BSHArrayDimensions(27);
        this.jjtree.openNodeScope(bSHArrayDimensions);
        jjtreeOpenNodeScope(bSHArrayDimensions);
        boolean z2 = false;
        try {
            if (!jj_2_22(2)) {
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                if (iJj_ntk_f2 == 78) {
                    ArrayInitializer();
                    this.jjtree.closeNodeScope((Node) bSHArrayDimensions, true);
                    try {
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHArrayDimensions);
                        }
                        bSHArrayDimensions.numUndefinedDims = -1;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        try {
                            if (z) {
                                this.jjtree.clearNodeScope(bSHArrayDimensions);
                            } else {
                                this.jjtree.popNode();
                                z2 = z;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            z = th instanceof ParseException;
                            if (z) {
                                throw ((ParseException) th);
                            }
                            if (!(th instanceof RuntimeException)) {
                                throw ((Error) th);
                            }
                            throw ((RuntimeException) th);
                        } catch (Throwable th3) {
                            z = z2;
                            th = th3;
                            if (z) {
                                this.jjtree.closeNodeScope((Node) bSHArrayDimensions, true);
                                if (this.jjtree.nodeCreated()) {
                                    jjtreeCloseNodeScope(bSHArrayDimensions);
                                }
                            }
                            throw th;
                        }
                    }
                } else {
                    if (iJj_ntk_f2 != 80) {
                        this.jj_la1[92] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    do {
                        jj_consume_token(80);
                        jj_consume_token(81);
                        bSHArrayDimensions.addUndefinedDimension();
                        iJj_ntk_f = this.jj_ntk;
                        if (iJj_ntk_f == -1) {
                            iJj_ntk_f = jj_ntk_f();
                        }
                    } while (iJj_ntk_f == 80);
                    this.jj_la1[91] = this.jj_gen;
                    ArrayInitializer();
                }
                if (z2) {
                    this.jjtree.closeNodeScope((Node) bSHArrayDimensions, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHArrayDimensions);
                    }
                }
            }
            do {
                jj_consume_token(80);
                Expression();
                jj_consume_token(81);
                bSHArrayDimensions.addDefinedDimension();
            } while (jj_2_20(2));
            while (jj_2_21(2)) {
                jj_consume_token(80);
                jj_consume_token(81);
                bSHArrayDimensions.addUndefinedDimension();
            }
            z2 = true;
            if (z2) {
                this.jjtree.closeNodeScope((Node) bSHArrayDimensions, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHArrayDimensions);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void ArrayInitializer() throws Throwable {
        boolean z;
        BSHArrayInitializer bSHArrayInitializer = new BSHArrayInitializer(8);
        this.jjtree.openNodeScope(bSHArrayInitializer);
        jjtreeOpenNodeScope(bSHArrayInitializer);
        try {
            jj_consume_token(78);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    VariableInitializer();
                    while (jj_2_6(2)) {
                        jj_consume_token(83);
                        VariableInitializer();
                    }
                    break;
                default:
                    this.jj_la1[23] = this.jj_gen;
                    break;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 83) {
                this.jj_la1[24] = this.jj_gen;
            } else {
                jj_consume_token(83);
            }
            jj_consume_token(79);
            this.jjtree.closeNodeScope((Node) bSHArrayInitializer, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHArrayInitializer);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHArrayInitializer);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHArrayInitializer, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHArrayInitializer);
                    }
                }
                throw th;
            }
        }
    }

    public final int AssignmentOperator() throws ParseException {
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f == 85) {
            jj_consume_token(85);
        } else if (iJj_ntk_f != 146) {
            switch (iJj_ntk_f) {
                case 124:
                    jj_consume_token(124);
                    break;
                case 125:
                    jj_consume_token(125);
                    break;
                case 126:
                    jj_consume_token(126);
                    break;
                case 127:
                    jj_consume_token(127);
                    break;
                case 128:
                    jj_consume_token(128);
                    break;
                case 129:
                    jj_consume_token(129);
                    break;
                case 130:
                    jj_consume_token(130);
                    break;
                case 131:
                    jj_consume_token(131);
                    break;
                case 132:
                    jj_consume_token(132);
                    break;
                case 133:
                    jj_consume_token(133);
                    break;
                case 134:
                    jj_consume_token(134);
                    break;
                case 135:
                    jj_consume_token(135);
                    break;
                case 136:
                    jj_consume_token(136);
                    break;
                case 137:
                    jj_consume_token(137);
                    break;
                case 138:
                    jj_consume_token(138);
                    break;
                case 139:
                    jj_consume_token(139);
                    break;
                case 140:
                    jj_consume_token(140);
                    break;
                case 141:
                    jj_consume_token(141);
                    break;
                case 142:
                    jj_consume_token(142);
                    break;
                case 143:
                    jj_consume_token(143);
                    break;
                default:
                    this.jj_la1[35] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        } else {
            jj_consume_token(146);
        }
        return getToken(0).kind;
    }

    public final void AutoCloseable() throws Throwable {
        boolean z;
        BSHAutoCloseable bSHAutoCloseable = new BSHAutoCloseable(43);
        this.jjtree.openNodeScope(bSHAutoCloseable);
        jjtreeOpenNodeScope(bSHAutoCloseable);
        try {
            if (jj_2_36(2)) {
                Type();
                VariableDeclarator();
            } else {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 73) {
                    this.jj_la1[119] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                VariableDeclarator();
            }
            this.jjtree.closeNodeScope((Node) bSHAutoCloseable, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHAutoCloseable);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHAutoCloseable);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHAutoCloseable, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHAutoCloseable);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void Block() throws Throwable {
        boolean z;
        Token tokenJj_consume_token;
        BSHBlock bSHBlock = new BSHBlock(3);
        this.jjtree.openNodeScope(bSHBlock);
        jjtreeOpenNodeScope(bSHBlock);
        boolean z2 = false;
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 49) {
                this.jj_la1[95] = this.jj_gen;
                tokenJj_consume_token = null;
            } else {
                tokenJj_consume_token = jj_consume_token(49);
            }
            jj_consume_token(78);
            while (jj_2_25(1)) {
                BlockStatement();
            }
            jj_consume_token(79);
            this.jjtree.closeNodeScope((Node) bSHBlock, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBlock);
                }
                if (tokenJj_consume_token != null) {
                    bSHBlock.isStatic = true;
                }
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHBlock);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    z = z2;
                    th = th3;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHBlock, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHBlock);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void BlockStatement() throws Throwable {
        if (jj_2_26(Integer.MAX_VALUE)) {
            ClassDeclaration();
            return;
        }
        if (jj_2_27(Integer.MAX_VALUE)) {
            MethodDeclaration();
            return;
        }
        if (jj_2_28(Integer.MAX_VALUE)) {
            MethodDeclaration();
            return;
        }
        if (jj_2_29(Integer.MAX_VALUE)) {
            TypedVariableDeclaration();
            jj_consume_token(82);
            return;
        }
        if (jj_2_30(1)) {
            Statement();
            return;
        }
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f == 35) {
            ImportDeclaration();
            return;
        }
        if (iJj_ntk_f == 43) {
            PackageDeclaration();
        } else if (iJj_ntk_f == 72) {
            FormalComment();
        } else {
            this.jj_la1[96] = this.jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public final boolean BooleanLiteral() throws ParseException {
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f == 27) {
            jj_consume_token(27);
            return false;
        }
        if (iJj_ntk_f == 56) {
            jj_consume_token(56);
            return true;
        }
        this.jj_la1[85] = this.jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
    }

    public final void BreakStatement() throws Throwable {
        boolean z;
        BSHReturnStatement bSHReturnStatement = new BSHReturnStatement(38);
        this.jjtree.openNodeScope(bSHReturnStatement);
        jjtreeOpenNodeScope(bSHReturnStatement);
        try {
            jj_consume_token(13);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 73) {
                this.jj_la1[109] = this.jj_gen;
            } else {
                bSHReturnStatement.label = jj_consume_token(73).image;
            }
            jj_consume_token(82);
            this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
            z = false;
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHReturnStatement);
                }
                bSHReturnStatement.kind = 13;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHReturnStatement);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    public final void CastExpression() throws Throwable {
        boolean z;
        BSHCastExpression bSHCastExpression = new BSHCastExpression(19);
        this.jjtree.openNodeScope(bSHCastExpression);
        jjtreeOpenNodeScope(bSHCastExpression);
        try {
            jj_consume_token(76);
            Type();
            jj_consume_token(77);
            UnaryExpression();
            this.jjtree.closeNodeScope((Node) bSHCastExpression, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHCastExpression);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHCastExpression);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHCastExpression, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHCastExpression);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:114:0x0072 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:117:0x007a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:118:0x007c A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:120:0x008b A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:122:0x0091 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:123:0x0099 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:124:0x00a3 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:126:0x00b3 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:128:0x00c2 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:130:0x00c8 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:131:0x00d0 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:134:0x00dc A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:136:0x00e2 A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Found duplicated region for block: B:137:0x00ea A[Catch: all -> 0x001d, TryCatch #2 {all -> 0x001d, blocks: (B:92:0x000f, B:94:0x0018, B:103:0x0032, B:104:0x0042, B:105:0x0043, B:107:0x0052, B:109:0x0058, B:111:0x0069, B:139:0x00f6, B:110:0x0060, B:112:0x006e, B:114:0x0072, B:118:0x007c, B:120:0x008b, B:122:0x0091, B:138:0x00f3, B:123:0x0099, B:124:0x00a3, B:125:0x00b2, B:126:0x00b3, B:128:0x00c2, B:130:0x00c8, B:132:0x00d8, B:134:0x00dc, B:136:0x00e2, B:137:0x00ea, B:131:0x00d0), top: B:176:0x000f }] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ClassDeclaration() throws Throwable {
        boolean z;
        int iJj_ntk_f;
        Token tokenJj_consume_token;
        int iJj_ntk_f2;
        int iJj_ntk_f3;
        int iJj_ntk_f4;
        BSHClassDeclaration bSHClassDeclaration = new BSHClassDeclaration(1);
        this.jjtree.openNodeScope(bSHClassDeclaration);
        jjtreeOpenNodeScope(bSHClassDeclaration);
        boolean z2 = false;
        try {
            Modifiers Modifiers = Modifiers(0, false);
            int iJj_ntk_f5 = this.jj_ntk;
            if (iJj_ntk_f5 == -1) {
                iJj_ntk_f5 = jj_ntk_f();
            }
            if (iJj_ntk_f5 == 14) {
                iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 14) {
                    jj_consume_token(14);
                    bSHClassDeclaration.type = ClassGenerator.Type.CLASS;
                    tokenJj_consume_token = jj_consume_token(73);
                    iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    if (iJj_ntk_f2 != 26) {
                        this.jj_la1[3] = this.jj_gen;
                    } else {
                        jj_consume_token(26);
                        AmbiguousName();
                        bSHClassDeclaration.extend = true;
                    }
                    iJj_ntk_f3 = this.jj_ntk;
                    if (iJj_ntk_f3 == -1) {
                        iJj_ntk_f3 = jj_ntk_f();
                    }
                    if (iJj_ntk_f3 != 34) {
                        this.jj_la1[4] = this.jj_gen;
                    } else {
                        jj_consume_token(34);
                        bSHClassDeclaration.numInterfaces = NameList();
                    }
                } else {
                    if (iJj_ntk_f == 38) {
                        this.jj_la1[6] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    jj_consume_token(38);
                    bSHClassDeclaration.type = ClassGenerator.Type.INTERFACE;
                    tokenJj_consume_token = jj_consume_token(73);
                    iJj_ntk_f4 = this.jj_ntk;
                    if (iJj_ntk_f4 == -1) {
                        iJj_ntk_f4 = jj_ntk_f();
                    }
                    if (iJj_ntk_f4 != 26) {
                        this.jj_la1[5] = this.jj_gen;
                    } else {
                        jj_consume_token(26);
                        bSHClassDeclaration.numInterfaces = NameList();
                    }
                }
                Block();
            } else if (iJj_ntk_f5 == 25) {
                jj_consume_token(25);
                bSHClassDeclaration.type = ClassGenerator.Type.ENUM;
                tokenJj_consume_token = jj_consume_token(73);
                int iJj_ntk_f6 = this.jj_ntk;
                if (iJj_ntk_f6 == -1) {
                    iJj_ntk_f6 = jj_ntk_f();
                }
                if (iJj_ntk_f6 != 34) {
                    this.jj_la1[7] = this.jj_gen;
                } else {
                    jj_consume_token(34);
                    bSHClassDeclaration.numInterfaces = NameList();
                }
                EnumBlock();
            } else {
                if (iJj_ntk_f5 != 38) {
                    this.jj_la1[8] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 14) {
                    jj_consume_token(14);
                    bSHClassDeclaration.type = ClassGenerator.Type.CLASS;
                    tokenJj_consume_token = jj_consume_token(73);
                    iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    if (iJj_ntk_f2 != 26) {
                        this.jj_la1[3] = this.jj_gen;
                    } else {
                        jj_consume_token(26);
                        AmbiguousName();
                        bSHClassDeclaration.extend = true;
                    }
                    iJj_ntk_f3 = this.jj_ntk;
                    if (iJj_ntk_f3 == -1) {
                        iJj_ntk_f3 = jj_ntk_f();
                    }
                    if (iJj_ntk_f3 != 34) {
                        this.jj_la1[4] = this.jj_gen;
                    } else {
                        jj_consume_token(34);
                        bSHClassDeclaration.numInterfaces = NameList();
                    }
                } else {
                    if (iJj_ntk_f == 38) {
                        this.jj_la1[6] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    jj_consume_token(38);
                    bSHClassDeclaration.type = ClassGenerator.Type.INTERFACE;
                    tokenJj_consume_token = jj_consume_token(73);
                    iJj_ntk_f4 = this.jj_ntk;
                    if (iJj_ntk_f4 == -1) {
                        iJj_ntk_f4 = jj_ntk_f();
                    }
                    if (iJj_ntk_f4 != 26) {
                        this.jj_la1[5] = this.jj_gen;
                    } else {
                        jj_consume_token(26);
                        bSHClassDeclaration.numInterfaces = NameList();
                    }
                }
                Block();
            }
            this.jjtree.closeNodeScope((Node) bSHClassDeclaration, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHClassDeclaration);
                }
                if (Modifiers != null) {
                    bSHClassDeclaration.modifiers = Modifiers;
                }
                bSHClassDeclaration.name = tokenJj_consume_token.image;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHClassDeclaration);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    z = z2;
                    th = th3;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHClassDeclaration, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHClassDeclaration);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void ConditionalAndExpression() throws Throwable {
        Token tokenJj_consume_token;
        InclusiveOrExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 100 && iJj_ntk_f != 101) {
                this.jj_la1[41] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 100) {
                tokenJj_consume_token = jj_consume_token(100);
            } else {
                if (iJj_ntk_f2 != 101) {
                    this.jj_la1[42] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(101);
            }
            InclusiveOrExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void ConditionalExpression() throws Throwable {
        NullCoalesceElvisSpaceShipExpression();
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f != 149) {
            this.jj_la1[36] = this.jj_gen;
            return;
        }
        jj_consume_token(149);
        Expression();
        jj_consume_token(150);
        BSHTernaryExpression bSHTernaryExpression = new BSHTernaryExpression(16);
        this.jjtree.openNodeScope(bSHTernaryExpression);
        jjtreeOpenNodeScope(bSHTernaryExpression);
        try {
            ConditionalExpression();
            this.jjtree.closeNodeScope(bSHTernaryExpression, 3);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHTernaryExpression);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHTernaryExpression);
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th2) {
                if (1 != 0) {
                    this.jjtree.closeNodeScope(bSHTernaryExpression, 3);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHTernaryExpression);
                    }
                }
                throw th2;
            }
        }
    }

    public final void ConditionalOrExpression() throws Throwable {
        Token tokenJj_consume_token;
        ConditionalAndExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 98 && iJj_ntk_f != 99) {
                this.jj_la1[39] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 98) {
                tokenJj_consume_token = jj_consume_token(98);
            } else {
                if (iJj_ntk_f2 != 99) {
                    this.jj_la1[40] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(99);
            }
            ConditionalAndExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void ContinueStatement() throws Throwable {
        boolean z;
        BSHReturnStatement bSHReturnStatement = new BSHReturnStatement(38);
        this.jjtree.openNodeScope(bSHReturnStatement);
        jjtreeOpenNodeScope(bSHReturnStatement);
        try {
            jj_consume_token(20);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 73) {
                this.jj_la1[110] = this.jj_gen;
            } else {
                bSHReturnStatement.label = jj_consume_token(73).image;
            }
            jj_consume_token(82);
            this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
            z = false;
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHReturnStatement);
                }
                bSHReturnStatement.kind = 20;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHReturnStatement);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void DoStatement() throws Throwable {
        boolean z;
        BSHWhileStatement bSHWhileStatement = new BSHWhileStatement(33);
        this.jjtree.openNodeScope(bSHWhileStatement);
        jjtreeOpenNodeScope(bSHWhileStatement);
        boolean z2 = false;
        try {
            jj_consume_token(22);
            Statement();
            jj_consume_token(60);
            jj_consume_token(76);
            Expression();
            jj_consume_token(77);
            jj_consume_token(82);
            this.jjtree.closeNodeScope((Node) bSHWhileStatement, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHWhileStatement);
                }
                bSHWhileStatement.isDoStatement = true;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHWhileStatement);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHWhileStatement, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHWhileStatement);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void EmptyStatement() throws ParseException {
        jj_consume_token(82);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void EnhancedForStatement() throws Throwable {
        boolean z;
        BSHEnhancedForStatement bSHEnhancedForStatement = new BSHEnhancedForStatement(35);
        this.jjtree.openNodeScope(bSHEnhancedForStatement);
        jjtreeOpenNodeScope(bSHEnhancedForStatement);
        boolean z2 = false;
        try {
        } catch (Throwable th) {
            th = th;
            z = true;
        }
        try {
            if (jj_2_33(4)) {
                jj_consume_token(31);
                jj_consume_token(76);
                Token tokenJj_consume_token = jj_consume_token(73);
                jj_consume_token(150);
                Expression();
                jj_consume_token(77);
                Statement();
                this.jjtree.closeNodeScope((Node) bSHEnhancedForStatement, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHEnhancedForStatement);
                }
                bSHEnhancedForStatement.varName = tokenJj_consume_token.image;
                return;
            }
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 31) {
                this.jj_la1[105] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
            jj_consume_token(31);
            jj_consume_token(76);
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 28) {
                this.jj_la1[104] = this.jj_gen;
            } else {
                jj_consume_token(28);
                bSHEnhancedForStatement.isFinal = true;
            }
            Type();
            Token tokenJj_consume_token2 = jj_consume_token(73);
            jj_consume_token(150);
            Expression();
            jj_consume_token(77);
            Statement();
            this.jjtree.closeNodeScope((Node) bSHEnhancedForStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHEnhancedForStatement);
            }
            bSHEnhancedForStatement.varName = tokenJj_consume_token2.image;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHEnhancedForStatement);
                } else {
                    this.jjtree.popNode();
                    z2 = z;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                z = th instanceof ParseException;
                if (z) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th4) {
                th = th4;
                z = z2;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHEnhancedForStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHEnhancedForStatement);
                    }
                }
                throw th;
            }
        }
    }

    public final void EnumBlock() throws Throwable {
        boolean z;
        BSHBlock bSHBlock = new BSHBlock(3);
        this.jjtree.openNodeScope(bSHBlock);
        jjtreeOpenNodeScope(bSHBlock);
        try {
            jj_consume_token(78);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 73) {
                this.jj_la1[11] = this.jj_gen;
            } else {
                EnumConstant();
            }
            while (true) {
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                if (iJj_ntk_f2 != 83) {
                    break;
                }
                jj_consume_token(83);
                EnumConstant();
            }
            this.jj_la1[12] = this.jj_gen;
            int iJj_ntk_f3 = this.jj_ntk;
            if (iJj_ntk_f3 == -1) {
                iJj_ntk_f3 = jj_ntk_f();
            }
            if (iJj_ntk_f3 != 82) {
                this.jj_la1[13] = this.jj_gen;
            } else {
                jj_consume_token(82);
                while (jj_2_2(1)) {
                    BlockStatement();
                }
            }
            jj_consume_token(79);
            this.jjtree.closeNodeScope((Node) bSHBlock, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHBlock);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHBlock);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHBlock, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHBlock);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void EnumConstant() throws Throwable {
        boolean z;
        BSHEnumConstant bSHEnumConstant = new BSHEnumConstant(2);
        this.jjtree.openNodeScope(bSHEnumConstant);
        jjtreeOpenNodeScope(bSHEnumConstant);
        boolean z2 = false;
        try {
            Token tokenJj_consume_token = jj_consume_token(73);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 76) {
                this.jj_la1[9] = this.jj_gen;
            } else {
                Arguments();
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 49 || iJj_ntk_f2 == 78) {
                Block();
            } else {
                this.jj_la1[10] = this.jj_gen;
            }
            this.jjtree.closeNodeScope((Node) bSHEnumConstant, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHEnumConstant);
                }
                bSHEnumConstant.name = tokenJj_consume_token.image;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHEnumConstant);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHEnumConstant, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHEnumConstant);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void EqualityExpression() throws Throwable {
        Token tokenJj_consume_token;
        InstanceOfExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 92 && iJj_ntk_f != 97) {
                this.jj_la1[49] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 92) {
                tokenJj_consume_token = jj_consume_token(92);
            } else {
                if (iJj_ntk_f2 != 97) {
                    this.jj_la1[50] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(97);
            }
            InstanceOfExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void ExclusiveOrExpression() throws Throwable {
        Token tokenJj_consume_token;
        AndExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 112 && iJj_ntk_f != 113) {
                this.jj_la1[45] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 112) {
                tokenJj_consume_token = jj_consume_token(112);
            } else {
                if (iJj_ntk_f2 != 113) {
                    this.jj_la1[46] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(113);
            }
            AndExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x0033 A[Catch: all -> 0x001d, TRY_LEAVE, TryCatch #2 {all -> 0x001d, blocks: (B:3:0x0010, B:5:0x0018, B:12:0x0027, B:13:0x002a, B:14:0x0033), top: B:43:0x0010 }] */
    public final void Expression() throws Throwable {
        boolean z;
        BSHAssignment bSHAssignment = new BSHAssignment(15);
        this.jjtree.openNodeScope(bSHAssignment);
        jjtreeOpenNodeScope(bSHAssignment);
        try {
            ConditionalExpression();
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 85 && iJj_ntk_f != 146) {
                switch (iJj_ntk_f) {
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
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
                        bSHAssignment.operator = Integer.valueOf(AssignmentOperator());
                        Expression();
                        break;
                    default:
                        this.jj_la1[34] = this.jj_gen;
                        break;
                }
            } else {
                bSHAssignment.operator = Integer.valueOf(AssignmentOperator());
                Expression();
            }
            this.jjtree.closeNodeScope((Node) bSHAssignment, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHAssignment);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHAssignment);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHAssignment, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHAssignment);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void ForInit() throws Throwable {
        if (jj_2_34(Integer.MAX_VALUE)) {
            TypedVariableDeclaration();
            return;
        }
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        switch (iJj_ntk_f) {
            case 12:
            case 15:
            case 18:
            case 23:
            case 27:
            case 30:
            case 37:
            case 39:
            case 41:
            case 42:
            case 48:
            case 56:
            case 58:
            case 61:
            case 66:
            case 69:
            case 70:
            case 71:
            case 73:
            case 76:
            case 78:
            case 80:
            case 90:
            case 91:
            case 102:
            case 103:
            case 104:
            case 105:
                StatementExpressionList();
                return;
            default:
                this.jj_la1[106] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final void ForStatement() throws Throwable {
        boolean z;
        BSHForStatement bSHForStatement = new BSHForStatement(34);
        this.jjtree.openNodeScope(bSHForStatement);
        jjtreeOpenNodeScope(bSHForStatement);
        try {
            jj_consume_token(31);
            jj_consume_token(76);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 11:
                case 12:
                case 15:
                case 18:
                case 21:
                case 23:
                case 27:
                case 28:
                case 30:
                case 37:
                case 39:
                case 40:
                case 41:
                case 42:
                case 44:
                case 45:
                case 46:
                case 48:
                case 49:
                case 50:
                case 52:
                case 53:
                case 56:
                case 58:
                case 59:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    ForInit();
                    bSHForStatement.hasForInit = true;
                    break;
                default:
                    this.jj_la1[101] = this.jj_gen;
                    break;
            }
            jj_consume_token(82);
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            switch (iJj_ntk_f2) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    Expression();
                    bSHForStatement.hasExpression = true;
                    break;
                default:
                    this.jj_la1[102] = this.jj_gen;
                    break;
            }
            jj_consume_token(82);
            int iJj_ntk_f3 = this.jj_ntk;
            if (iJj_ntk_f3 == -1) {
                iJj_ntk_f3 = jj_ntk_f();
            }
            switch (iJj_ntk_f3) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    ForUpdate();
                    bSHForStatement.hasForUpdate = true;
                    break;
                default:
                    this.jj_la1[103] = this.jj_gen;
                    break;
            }
            jj_consume_token(77);
            Statement();
            this.jjtree.closeNodeScope((Node) bSHForStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHForStatement);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHForStatement);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHForStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHForStatement);
                    }
                }
                throw th;
            }
        }
    }

    public final void ForUpdate() throws Throwable {
        StatementExpressionList();
    }

    public final void FormalComment() {
        BSHFormalComment bSHFormalComment = new BSHFormalComment(29);
        this.jjtree.openNodeScope(bSHFormalComment);
        jjtreeOpenNodeScope(bSHFormalComment);
        boolean z = true;
        try {
            Token tokenJj_consume_token = jj_consume_token(72);
            this.jjtree.closeNodeScope(bSHFormalComment, this.retainComments);
            z = false;
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHFormalComment);
            }
            bSHFormalComment.text = tokenJj_consume_token.image;
        } catch (Throwable th) {
            if (z) {
                this.jjtree.closeNodeScope(bSHFormalComment, this.retainComments);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHFormalComment);
                }
            }
            throw th;
        }
    }

    public final void FormalParameter() throws Throwable {
        boolean z;
        BSHFormalParameter bSHFormalParameter = new BSHFormalParameter(10);
        this.jjtree.openNodeScope(bSHFormalParameter);
        jjtreeOpenNodeScope(bSHFormalParameter);
        try {
            if (jj_2_7(2)) {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 28) {
                    this.jj_la1[27] = this.jj_gen;
                } else {
                    jj_consume_token(28);
                    bSHFormalParameter.isFinal = true;
                }
                Type();
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                if (iJj_ntk_f2 != 152) {
                    this.jj_la1[28] = this.jj_gen;
                } else {
                    jj_consume_token(152);
                    bSHFormalParameter.isVarArgs = true;
                }
                bSHFormalParameter.name = jj_consume_token(73).image;
            } else {
                int iJj_ntk_f3 = this.jj_ntk;
                if (iJj_ntk_f3 == -1) {
                    iJj_ntk_f3 = jj_ntk_f();
                }
                if (iJj_ntk_f3 != 73) {
                    this.jj_la1[29] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                bSHFormalParameter.name = jj_consume_token(73).image;
            }
            while (isFormalParameterDimensions()) {
                jj_consume_token(80);
                jj_consume_token(81);
                bSHFormalParameter.dimensions++;
            }
            this.jjtree.closeNodeScope((Node) bSHFormalParameter, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHFormalParameter);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHFormalParameter);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHFormalParameter, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHFormalParameter);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void FormalParameters() throws Throwable {
        boolean z;
        BSHFormalParameters bSHFormalParameters = new BSHFormalParameters(9);
        this.jjtree.openNodeScope(bSHFormalParameters);
        jjtreeOpenNodeScope(bSHFormalParameters);
        try {
            jj_consume_token(76);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f == 12 || iJj_ntk_f == 15 || iJj_ntk_f == 18 || iJj_ntk_f == 23 || iJj_ntk_f == 28 || iJj_ntk_f == 30 || iJj_ntk_f == 37 || iJj_ntk_f == 39 || iJj_ntk_f == 48 || iJj_ntk_f == 73) {
                FormalParameter();
                while (true) {
                    int iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    if (iJj_ntk_f2 != 83) {
                        break;
                    }
                    jj_consume_token(83);
                    FormalParameter();
                }
                this.jj_la1[25] = this.jj_gen;
            } else {
                this.jj_la1[26] = this.jj_gen;
            }
            jj_consume_token(77);
            this.jjtree.closeNodeScope((Node) bSHFormalParameters, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHFormalParameters);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHFormalParameters);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHFormalParameters, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHFormalParameters);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void IfStatement() throws Throwable {
        boolean z;
        BSHIfStatement bSHIfStatement = new BSHIfStatement(32);
        this.jjtree.openNodeScope(bSHIfStatement);
        jjtreeOpenNodeScope(bSHIfStatement);
        try {
            jj_consume_token(33);
            jj_consume_token(76);
            Expression();
            jj_consume_token(77);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 82) {
                this.jj_la1[99] = this.jj_gen;
                if (!jj_2_32(1)) {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                Statement();
            } else {
                jj_consume_token(82);
                bSHIfStatement.isClosed = true;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 24) {
                this.jj_la1[100] = this.jj_gen;
            } else {
                jj_consume_token(24);
                Statement();
            }
            this.jjtree.closeNodeScope((Node) bSHIfStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHIfStatement);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHIfStatement);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHIfStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHIfStatement);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ImportDeclaration() throws Throwable {
        boolean z;
        BSHImportDeclaration bSHImportDeclaration = new BSHImportDeclaration(6);
        this.jjtree.openNodeScope(bSHImportDeclaration);
        jjtreeOpenNodeScope(bSHImportDeclaration);
        boolean z2 = false;
        try {
            if (jj_2_4(3)) {
                jj_consume_token(35);
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 49) {
                    this.jj_la1[17] = this.jj_gen;
                } else {
                    jj_consume_token(49);
                    bSHImportDeclaration.staticImport = true;
                }
                AmbiguousName();
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                if (iJj_ntk_f2 != 84) {
                    this.jj_la1[18] = this.jj_gen;
                } else {
                    jj_consume_token(84);
                    jj_consume_token(106);
                    bSHImportDeclaration.importPackage = true;
                }
                jj_consume_token(82);
                z2 = true;
            } else {
                int iJj_ntk_f3 = this.jj_ntk;
                if (iJj_ntk_f3 == -1) {
                    iJj_ntk_f3 = jj_ntk_f();
                }
                if (iJj_ntk_f3 != 35) {
                    this.jj_la1[19] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token(35);
                jj_consume_token(106);
                jj_consume_token(82);
                this.jjtree.closeNodeScope((Node) bSHImportDeclaration, true);
                try {
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHImportDeclaration);
                    }
                    bSHImportDeclaration.superImport = true;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    try {
                        if (z) {
                            this.jjtree.clearNodeScope(bSHImportDeclaration);
                        } else {
                            this.jjtree.popNode();
                            z2 = z;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        z = th instanceof ParseException;
                        if (z) {
                            throw ((ParseException) th);
                        }
                        if (!(th instanceof RuntimeException)) {
                            throw ((Error) th);
                        }
                        throw ((RuntimeException) th);
                    } catch (Throwable th3) {
                        th = th3;
                        z = z2;
                        if (z) {
                            this.jjtree.closeNodeScope((Node) bSHImportDeclaration, true);
                            if (this.jjtree.nodeCreated()) {
                                jjtreeCloseNodeScope(bSHImportDeclaration);
                            }
                        }
                        throw th;
                    }
                }
            }
            if (z2) {
                this.jjtree.closeNodeScope((Node) bSHImportDeclaration, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHImportDeclaration);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void InclusiveOrExpression() throws Throwable {
        Token tokenJj_consume_token;
        ExclusiveOrExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 110 && iJj_ntk_f != 111) {
                this.jj_la1[43] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 110) {
                tokenJj_consume_token = jj_consume_token(110);
            } else {
                if (iJj_ntk_f2 != 111) {
                    this.jj_la1[44] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(111);
            }
            ExclusiveOrExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void InstanceOfExpression() throws Throwable {
        RelationalExpression();
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f != 36) {
            this.jj_la1[51] = this.jj_gen;
            return;
        }
        Token tokenJj_consume_token = jj_consume_token(36);
        Type();
        BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
        this.jjtree.openNodeScope(bSHBinaryExpression);
        jjtreeOpenNodeScope(bSHBinaryExpression);
        boolean z = true;
        try {
            this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
            z = false;
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHBinaryExpression);
            }
            bSHBinaryExpression.kind = tokenJj_consume_token.kind;
        } catch (Throwable th) {
            if (z) {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void LabeledStatement() throws Throwable {
        boolean z;
        BSHLabeledStatement bSHLabeledStatement = new BSHLabeledStatement(28);
        this.jjtree.openNodeScope(bSHLabeledStatement);
        jjtreeOpenNodeScope(bSHLabeledStatement);
        boolean z2 = false;
        try {
            Token tokenJj_consume_token = jj_consume_token(73);
            jj_consume_token(150);
            Statement();
            this.jjtree.closeNodeScope((Node) bSHLabeledStatement, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHLabeledStatement);
                }
                bSHLabeledStatement.label = tokenJj_consume_token.image;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHLabeledStatement);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHLabeledStatement, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLabeledStatement);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void LambdaExpression() throws Throwable {
        boolean z;
        Token tokenJj_consume_token;
        BSHLambdaExpression bSHLambdaExpression = new BSHLambdaExpression(22);
        this.jjtree.openNodeScope(bSHLambdaExpression);
        jjtreeOpenNodeScope(bSHLambdaExpression);
        boolean z2 = false;
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f == 73) {
                tokenJj_consume_token = jj_consume_token(73);
            } else {
                if (iJj_ntk_f != 76) {
                    this.jj_la1[68] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                FormalParameters();
                tokenJj_consume_token = null;
            }
            jj_consume_token(144);
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            switch (iJj_ntk_f2) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    Expression();
                    break;
                case 49:
                case 78:
                    Block();
                    break;
                default:
                    this.jj_la1[69] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
            this.jjtree.closeNodeScope((Node) bSHLambdaExpression, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHLambdaExpression);
                }
                bSHLambdaExpression.singleParamName = tokenJj_consume_token != null ? tokenJj_consume_token.image : null;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHLambdaExpression);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    z = z2;
                    th = th3;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHLambdaExpression, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLambdaExpression);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final boolean Line() throws Throwable {
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f == 0) {
            jj_consume_token(0);
            Interpreter.debug("End of File!");
            return true;
        }
        this.jj_la1[0] = this.jj_gen;
        if (jj_2_1(1)) {
            BlockStatement();
            return false;
        }
        jj_consume_token(-1);
        throw new ParseException();
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void Literal() throws Throwable {
        boolean z;
        int iJj_ntk_f;
        BSHLiteral bSHLiteral = new BSHLiteral(24);
        this.jjtree.openNodeScope(bSHLiteral);
        jjtreeOpenNodeScope(bSHLiteral);
        boolean z2 = false;
        try {
            iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            try {
                boolean zBooleanLiteral = BooleanLiteral();
                this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHLiteral);
                }
                bSHLiteral.value = zBooleanLiteral ? Primitive.TRUE : Primitive.FALSE;
                return;
            } catch (Throwable th) {
                th = th;
                z = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        if (iJj_ntk_f != 27) {
            if (iJj_ntk_f == 42) {
                NullLiteral();
                this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHLiteral);
                }
                bSHLiteral.value = Primitive.NULL;
                return;
            }
            if (iJj_ntk_f != 56) {
                if (iJj_ntk_f == 58) {
                    VoidLiteral();
                    this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHLiteral);
                    }
                    bSHLiteral.value = Primitive.VOID;
                    return;
                }
                if (iJj_ntk_f == 61) {
                    Token tokenJj_consume_token = jj_consume_token(61);
                    this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHLiteral);
                    }
                    String strReplaceAll = tokenJj_consume_token.image.replaceAll(JavaConstant.Dynamic.DEFAULT_NAME, "");
                    int length = strReplaceAll.length() - 1;
                    char cCharAt = strReplaceAll.charAt(length);
                    try {
                        if (Types.Suffix.isIntegral(Character.valueOf(cCharAt))) {
                            bSHLiteral.value = parseIntegral(strReplaceAll.substring(0, length)).castToType(Types.Suffix.getIntegralType(Character.valueOf(cCharAt)), 0);
                            return;
                        } else {
                            bSHLiteral.value = Primitive.shrinkWrap(parseIntegral(strReplaceAll).getValue());
                            return;
                        }
                    } catch (NumberFormatException e) {
                        throw createParseException(e.getMessage(), e);
                    }
                }
                if (iJj_ntk_f == 66) {
                    Token tokenJj_consume_token2 = jj_consume_token(66);
                    this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHLiteral);
                    }
                    String str = tokenJj_consume_token2.image;
                    int length2 = str.length() - 1;
                    char cCharAt2 = str.charAt(length2);
                    try {
                        if (Types.Suffix.isFloatingPoint(Character.valueOf(cCharAt2))) {
                            bSHLiteral.value = new Primitive(new BigDecimal(str.substring(0, length2))).castToType(Types.Suffix.getFloatingPointType(Character.valueOf(cCharAt2)), 0);
                            return;
                        } else {
                            bSHLiteral.value = Primitive.shrinkWrap(new BigDecimal(str));
                            return;
                        }
                    } catch (NumberFormatException e2) {
                        throw createParseException(e2.getMessage(), e2);
                    }
                }
                switch (iJj_ntk_f) {
                    case 69:
                        Token tokenJj_consume_token3 = jj_consume_token(69);
                        this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLiteral);
                        }
                        try {
                            String str2 = tokenJj_consume_token3.image;
                            bSHLiteral.charSetup(str2.substring(1, str2.length() - 1));
                            return;
                        } catch (Exception e3) {
                            throw createParseException("Error parsing character: " + tokenJj_consume_token3.image, e3);
                        }
                    case 70:
                        Token tokenJj_consume_token4 = jj_consume_token(70);
                        this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLiteral);
                        }
                        try {
                            String str3 = tokenJj_consume_token4.image;
                            bSHLiteral.stringSetup(str3.substring(1, str3.length() - 1));
                            return;
                        } catch (Exception e4) {
                            throw createParseException("Error parsing string: " + tokenJj_consume_token4.image, e4);
                        }
                    case 71:
                        Token tokenJj_consume_token5 = jj_consume_token(71);
                        this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLiteral);
                        }
                        try {
                            String str4 = tokenJj_consume_token5.image;
                            bSHLiteral.value = str4.substring(3, str4.length() - 3);
                            return;
                        } catch (Exception e5) {
                            throw createParseException("Error parsing long string: " + tokenJj_consume_token5.image, e5);
                        }
                    default:
                        this.jj_la1[84] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHLiteral);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th4) {
                    th = th4;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHLiteral, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHLiteral);
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public final void MethodDeclaration() throws Throwable {
        BSHMethodDeclaration bSHMethodDeclaration = new BSHMethodDeclaration(4);
        this.jjtree.openNodeScope(bSHMethodDeclaration);
        jjtreeOpenNodeScope(bSHMethodDeclaration);
        boolean z = false;
        try {
            Modifiers Modifiers = Modifiers(2, false);
            if (Modifiers != null) {
                bSHMethodDeclaration.modifiers = Modifiers;
            }
            if (jj_2_3(Integer.MAX_VALUE)) {
                bSHMethodDeclaration.name = jj_consume_token(73).image;
            } else {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 12 && iJj_ntk_f != 15 && iJj_ntk_f != 18 && iJj_ntk_f != 23 && iJj_ntk_f != 30 && iJj_ntk_f != 37 && iJj_ntk_f != 39 && iJj_ntk_f != 48 && iJj_ntk_f != 58 && iJj_ntk_f != 73) {
                    this.jj_la1[14] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                ReturnType();
                bSHMethodDeclaration.name = jj_consume_token(73).image;
            }
            FormalParameters();
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 55) {
                this.jj_la1[15] = this.jj_gen;
            } else {
                jj_consume_token(55);
                bSHMethodDeclaration.numThrows = NameList();
            }
            int iJj_ntk_f3 = this.jj_ntk;
            if (iJj_ntk_f3 == -1) {
                iJj_ntk_f3 = jj_ntk_f();
            }
            if (iJj_ntk_f3 == 49 || iJj_ntk_f3 == 78) {
                Block();
            } else {
                if (iJj_ntk_f3 != 82) {
                    this.jj_la1[16] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token(82);
            }
            this.jjtree.closeNodeScope((Node) bSHMethodDeclaration, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHMethodDeclaration);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHMethodDeclaration);
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHMethodDeclaration, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHMethodDeclaration);
                    }
                }
                throw th;
            }
        }
    }

    public final void MethodInvocation() throws Throwable {
        boolean z;
        BSHMethodInvocation bSHMethodInvocation = new BSHMethodInvocation(21);
        this.jjtree.openNodeScope(bSHMethodInvocation);
        jjtreeOpenNodeScope(bSHMethodInvocation);
        try {
            AmbiguousName();
            Arguments();
            this.jjtree.closeNodeScope((Node) bSHMethodInvocation, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHMethodInvocation);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHMethodInvocation);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHMethodInvocation, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHMethodInvocation);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Switch 'out' block B:3:0x0001 for B:16:0x002e already processed. Defaulting to fallback option. */
    public final Modifiers Modifiers(int i, boolean z) throws ParseException {
        Modifiers modifiers = null;
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 11 && iJj_ntk_f != 21 && iJj_ntk_f != 28 && iJj_ntk_f != 40 && iJj_ntk_f != 59 && iJj_ntk_f != 49 && iJj_ntk_f != 50 && iJj_ntk_f != 52 && iJj_ntk_f != 53) {
                switch (iJj_ntk_f) {
                    case 44:
                    case 45:
                    case 46:
                        break;
                    default:
                        this.jj_la1[1] = this.jj_gen;
                        return modifiers;
                }
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 11) {
                jj_consume_token(11);
            } else if (iJj_ntk_f2 == 21) {
                jj_consume_token(21);
            } else if (iJj_ntk_f2 == 28) {
                jj_consume_token(28);
            } else if (iJj_ntk_f2 == 40) {
                jj_consume_token(40);
            } else if (iJj_ntk_f2 == 59) {
                jj_consume_token(59);
            } else if (iJj_ntk_f2 == 49) {
                jj_consume_token(49);
            } else if (iJj_ntk_f2 == 50) {
                jj_consume_token(50);
            } else if (iJj_ntk_f2 == 52) {
                jj_consume_token(52);
            } else if (iJj_ntk_f2 != 53) {
                switch (iJj_ntk_f2) {
                    case 44:
                        jj_consume_token(44);
                        break;
                    case 45:
                        jj_consume_token(45);
                        break;
                    case 46:
                        jj_consume_token(46);
                        break;
                    default:
                        this.jj_la1[2] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
            } else {
                jj_consume_token(53);
            }
            if (!z) {
                if (modifiers == null) {
                    try {
                        modifiers = new Modifiers(i);
                    } catch (IllegalStateException e) {
                        throw createParseException(e.getMessage(), e);
                    }
                }
                modifiers.addModifier(getToken(0).image);
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void MultiCatch() throws Throwable {
        boolean z;
        BSHMultiCatch bSHMultiCatch = new BSHMultiCatch(41);
        this.jjtree.openNodeScope(bSHMultiCatch);
        jjtreeOpenNodeScope(bSHMultiCatch);
        boolean z2 = false;
        try {
        } catch (Throwable th) {
            th = th;
            z = true;
        }
        try {
            if (!jj_2_35(2)) {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 73) {
                    this.jj_la1[117] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                Token tokenJj_consume_token = jj_consume_token(73);
                this.jjtree.closeNodeScope((Node) bSHMultiCatch, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHMultiCatch);
                }
                bSHMultiCatch.name = tokenJj_consume_token.image;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 28) {
                this.jj_la1[115] = this.jj_gen;
            } else {
                jj_consume_token(28);
                bSHMultiCatch.isFinal = true;
            }
            Type();
            while (true) {
                int iJj_ntk_f3 = this.jj_ntk;
                if (iJj_ntk_f3 == -1) {
                    iJj_ntk_f3 = jj_ntk_f();
                }
                if (iJj_ntk_f3 != 110) {
                    break;
                }
                jj_consume_token(110);
                Type();
            }
            this.jj_la1[116] = this.jj_gen;
            Token tokenJj_consume_token2 = jj_consume_token(73);
            this.jjtree.closeNodeScope((Node) bSHMultiCatch, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHMultiCatch);
            }
            bSHMultiCatch.name = tokenJj_consume_token2.image;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHMultiCatch);
                } else {
                    this.jjtree.popNode();
                    z2 = z;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                z = th instanceof ParseException;
                if (z) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th4) {
                th = th4;
                z = z2;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHMultiCatch, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHMultiCatch);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [TRUE_FALLTHROUGH B:39:0x006d -> B:30:0x007f] - Handler: None
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public final void MultiplicativeExpression() throws Throwable {
        Token tokenJj_consume_token;
        PowerExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 106 && iJj_ntk_f != 107 && iJj_ntk_f != 114 && iJj_ntk_f != 115) {
                this.jj_la1[58] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 106) {
                tokenJj_consume_token = jj_consume_token(106);
            } else if (iJj_ntk_f2 == 107) {
                tokenJj_consume_token = jj_consume_token(107);
            } else if (iJj_ntk_f2 == 114) {
                tokenJj_consume_token = jj_consume_token(114);
            } else {
                if (iJj_ntk_f2 != 115) {
                    this.jj_la1[59] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(115);
            }
            PowerExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final int NameList() throws Throwable {
        AmbiguousName();
        int i = 1;
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 83) {
                this.jj_la1[33] = this.jj_gen;
                return i;
            }
            jj_consume_token(83);
            AmbiguousName();
            i++;
        }
    }

    public final void NullCoalesceElvisSpaceShipExpression() throws Throwable {
        Token tokenJj_consume_token;
        ConditionalOrExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 145 && iJj_ntk_f != 147 && iJj_ntk_f != 148) {
                this.jj_la1[37] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 145) {
                tokenJj_consume_token = jj_consume_token(145);
            } else if (iJj_ntk_f2 == 147) {
                tokenJj_consume_token = jj_consume_token(147);
            } else {
                if (iJj_ntk_f2 != 148) {
                    this.jj_la1[38] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(148);
            }
            ConditionalOrExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void NullLiteral() throws ParseException {
        jj_consume_token(42);
    }

    public final void PackageDeclaration() throws Throwable {
        boolean z;
        BSHPackageDeclaration bSHPackageDeclaration = new BSHPackageDeclaration(5);
        this.jjtree.openNodeScope(bSHPackageDeclaration);
        jjtreeOpenNodeScope(bSHPackageDeclaration);
        try {
            jj_consume_token(43);
            AmbiguousName();
            this.jjtree.closeNodeScope((Node) bSHPackageDeclaration, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHPackageDeclaration);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHPackageDeclaration);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHPackageDeclaration, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPackageDeclaration);
                    }
                }
                throw th;
            }
        }
    }

    public final void PowerExpression() throws Throwable {
        Token tokenJj_consume_token;
        UnaryExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 116 && iJj_ntk_f != 117) {
                this.jj_la1[60] = this.jj_gen;
                return;
            }
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 == 116) {
                tokenJj_consume_token = jj_consume_token(116);
            } else {
                if (iJj_ntk_f2 != 117) {
                    this.jj_la1[61] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                tokenJj_consume_token = jj_consume_token(117);
            }
            UnaryExpression();
            BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
            this.jjtree.openNodeScope(bSHBinaryExpression);
            jjtreeOpenNodeScope(bSHBinaryExpression);
            boolean z = true;
            try {
                this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                z = false;
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBinaryExpression);
                }
                bSHBinaryExpression.kind = tokenJj_consume_token.kind;
            } catch (Throwable th) {
                if (z) {
                    this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHBinaryExpression);
                    }
                }
                throw th;
            }
        }
    }

    public final void PrimaryExpression() throws Throwable {
        boolean z;
        BSHPrimaryExpression bSHPrimaryExpression = new BSHPrimaryExpression(20);
        this.jjtree.openNodeScope(bSHPrimaryExpression);
        jjtreeOpenNodeScope(bSHPrimaryExpression);
        try {
            PrimaryPrefix();
            while (jj_2_12(1)) {
                PrimarySuffix();
            }
            this.jjtree.closeNodeScope((Node) bSHPrimaryExpression, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHPrimaryExpression);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHPrimaryExpression);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHPrimaryExpression, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHPrimaryExpression);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public final void PrimaryPrefix() throws Throwable {
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        if (iJj_ntk_f != 27 && iJj_ntk_f != 56 && iJj_ntk_f != 58 && iJj_ntk_f != 61 && iJj_ntk_f != 66) {
            if (iJj_ntk_f == 76) {
                jj_consume_token(76);
                Expression();
                jj_consume_token(77);
                return;
            }
            if (iJj_ntk_f == 78 || iJj_ntk_f == 80 || iJj_ntk_f == 41) {
                AllocationExpression();
                return;
            }
            if (iJj_ntk_f != 42) {
                switch (iJj_ntk_f) {
                    case 69:
                    case 70:
                    case 71:
                        break;
                    default:
                        this.jj_la1[70] = this.jj_gen;
                        if (jj_2_13(Integer.MAX_VALUE)) {
                            MethodInvocation();
                            return;
                        }
                        if (jj_2_14(Integer.MAX_VALUE)) {
                            Type();
                            return;
                        }
                        int iJj_ntk_f2 = this.jj_ntk;
                        if (iJj_ntk_f2 == -1) {
                            iJj_ntk_f2 = jj_ntk_f();
                        }
                        if (iJj_ntk_f2 == 73) {
                            AmbiguousName();
                            return;
                        } else {
                            this.jj_la1[71] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                }
            }
        }
        Literal();
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void PrimarySuffix() {
        boolean z;
        Token tokenJj_consume_token;
        BSHPrimarySuffix bSHPrimarySuffix = new BSHPrimarySuffix(23);
        this.jjtree.openNodeScope(bSHPrimarySuffix);
        jjtreeOpenNodeScope(bSHPrimarySuffix);
        try {
            try {
                if (jj_2_15(2)) {
                    jj_consume_token(84);
                    jj_consume_token(14);
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 6;
                    return;
                }
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f == 80) {
                    jj_consume_token(80);
                    int iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    switch (iJj_ntk_f2) {
                        case 12:
                        case 15:
                        case 18:
                        case 23:
                        case 27:
                        case 30:
                        case 37:
                        case 39:
                        case 41:
                        case 42:
                        case 48:
                        case 56:
                        case 58:
                        case 61:
                        case 66:
                        case 69:
                        case 70:
                        case 71:
                        case 73:
                        case 76:
                        case 78:
                        case 80:
                        case 90:
                        case 91:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                            Expression();
                            bSHPrimarySuffix.hasLeftIndex = true;
                            break;
                        default:
                            this.jj_la1[72] = this.jj_gen;
                            break;
                    }
                    int iJj_ntk_f3 = this.jj_ntk;
                    if (iJj_ntk_f3 == -1) {
                        iJj_ntk_f3 = jj_ntk_f();
                    }
                    if (iJj_ntk_f3 == 150 || iJj_ntk_f3 == 151) {
                        int iJj_ntk_f4 = this.jj_ntk;
                        if (iJj_ntk_f4 == -1) {
                            iJj_ntk_f4 = jj_ntk_f();
                        }
                        if (iJj_ntk_f4 == 150) {
                            jj_consume_token(150);
                            bSHPrimarySuffix.slice = true;
                            int iJj_ntk_f5 = this.jj_ntk;
                            if (iJj_ntk_f5 == -1) {
                                iJj_ntk_f5 = jj_ntk_f();
                            }
                            switch (iJj_ntk_f5) {
                                case 12:
                                case 15:
                                case 18:
                                case 23:
                                case 27:
                                case 30:
                                case 37:
                                case 39:
                                case 41:
                                case 42:
                                case 48:
                                case 56:
                                case 58:
                                case 61:
                                case 66:
                                case 69:
                                case 70:
                                case 71:
                                case 73:
                                case 76:
                                case 78:
                                case 80:
                                case 90:
                                case 91:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                    Expression();
                                    bSHPrimarySuffix.hasRightIndex = true;
                                    break;
                                default:
                                    this.jj_la1[74] = this.jj_gen;
                                    break;
                            }
                            int iJj_ntk_f6 = this.jj_ntk;
                            if (iJj_ntk_f6 == -1) {
                                iJj_ntk_f6 = jj_ntk_f();
                            }
                            if (iJj_ntk_f6 == 150) {
                                jj_consume_token(150);
                                bSHPrimarySuffix.step = true;
                                int iJj_ntk_f7 = this.jj_ntk;
                                if (iJj_ntk_f7 == -1) {
                                    iJj_ntk_f7 = jj_ntk_f();
                                }
                                switch (iJj_ntk_f7) {
                                    case 12:
                                    case 15:
                                    case 18:
                                    case 23:
                                    case 27:
                                    case 30:
                                    case 37:
                                    case 39:
                                    case 41:
                                    case 42:
                                    case 48:
                                    case 56:
                                    case 58:
                                    case 61:
                                    case 66:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 73:
                                    case 76:
                                    case 78:
                                    case 80:
                                    case 90:
                                    case 91:
                                    case 102:
                                    case 103:
                                    case 104:
                                    case 105:
                                        Expression();
                                        break;
                                    default:
                                        this.jj_la1[75] = this.jj_gen;
                                        break;
                                }
                            } else {
                                this.jj_la1[76] = this.jj_gen;
                            }
                        } else {
                            if (iJj_ntk_f4 != 151) {
                                this.jj_la1[77] = this.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                            }
                            jj_consume_token(151);
                            int iJj_ntk_f8 = this.jj_ntk;
                            if (iJj_ntk_f8 == -1) {
                                iJj_ntk_f8 = jj_ntk_f();
                            }
                            switch (iJj_ntk_f8) {
                                case 12:
                                case 15:
                                case 18:
                                case 23:
                                case 27:
                                case 30:
                                case 37:
                                case 39:
                                case 41:
                                case 42:
                                case 48:
                                case 56:
                                case 58:
                                case 61:
                                case 66:
                                case 69:
                                case 70:
                                case 71:
                                case 73:
                                case 76:
                                case 78:
                                case 80:
                                case 90:
                                case 91:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                    Expression();
                                    break;
                                default:
                                    this.jj_la1[73] = this.jj_gen;
                                    break;
                            }
                            bSHPrimarySuffix.slice = true;
                            bSHPrimarySuffix.step = true;
                        }
                    } else {
                        this.jj_la1[78] = this.jj_gen;
                    }
                    jj_consume_token(81);
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 1;
                    return;
                }
                this.jj_la1[82] = this.jj_gen;
                if (getToken(1).kind == 151 && ((getToken(2).kind == 73 || getToken(2).kind == 41) && getToken(3).kind != 81)) {
                    jj_consume_token(151);
                    int iJj_ntk_f9 = this.jj_ntk;
                    if (iJj_ntk_f9 == -1) {
                        iJj_ntk_f9 = jj_ntk_f();
                    }
                    if (iJj_ntk_f9 == 41) {
                        tokenJj_consume_token = jj_consume_token(41);
                    } else {
                        if (iJj_ntk_f9 != 73) {
                            this.jj_la1[79] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                        tokenJj_consume_token = jj_consume_token(73);
                    }
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 5;
                    bSHPrimarySuffix.field = tokenJj_consume_token.image;
                    return;
                }
                if (jj_2_16(2)) {
                    jj_consume_token(153);
                    Token tokenJj_consume_token2 = jj_consume_token(73);
                    int iJj_ntk_f10 = this.jj_ntk;
                    if (iJj_ntk_f10 == -1) {
                        iJj_ntk_f10 = jj_ntk_f();
                    }
                    if (iJj_ntk_f10 != 76) {
                        this.jj_la1[80] = this.jj_gen;
                    } else {
                        Arguments();
                    }
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 2;
                    bSHPrimarySuffix.field = tokenJj_consume_token2.image;
                    bSHPrimarySuffix.safeNavigate = true;
                    return;
                }
                if (jj_2_17(2)) {
                    jj_consume_token(84);
                    Token tokenJj_consume_token3 = jj_consume_token(73);
                    int iJj_ntk_f11 = this.jj_ntk;
                    if (iJj_ntk_f11 == -1) {
                        iJj_ntk_f11 = jj_ntk_f();
                    }
                    if (iJj_ntk_f11 != 76) {
                        this.jj_la1[81] = this.jj_gen;
                    } else {
                        Arguments();
                    }
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 2;
                    bSHPrimarySuffix.field = tokenJj_consume_token3.image;
                    return;
                }
                int iJj_ntk_f12 = this.jj_ntk;
                if (iJj_ntk_f12 == -1) {
                    iJj_ntk_f12 = jj_ntk_f();
                }
                if (iJj_ntk_f12 == 78) {
                    jj_consume_token(78);
                    Expression();
                    jj_consume_token(79);
                    this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimarySuffix);
                    }
                    bSHPrimarySuffix.operation = 3;
                    return;
                }
                this.jj_la1[83] = this.jj_gen;
                if (!jj_2_18(2)) {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token(84);
                AllocationExpression();
                this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHPrimarySuffix);
                }
                bSHPrimarySuffix.operation = 4;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHPrimarySuffix);
                    } else {
                        this.jjtree.popNode();
                    }
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHPrimarySuffix, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHPrimarySuffix);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = true;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void PrimitiveType() throws Throwable {
        boolean z;
        BSHPrimitiveType bSHPrimitiveType = new BSHPrimitiveType(13);
        this.jjtree.openNodeScope(bSHPrimitiveType);
        jjtreeOpenNodeScope(bSHPrimitiveType);
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            z = false;
            try {
                if (iJj_ntk_f == 12) {
                    jj_consume_token(12);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Boolean.TYPE;
                    return;
                }
                if (iJj_ntk_f == 15) {
                    jj_consume_token(15);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Byte.TYPE;
                    return;
                }
                if (iJj_ntk_f == 18) {
                    jj_consume_token(18);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Character.TYPE;
                    return;
                }
                if (iJj_ntk_f == 23) {
                    jj_consume_token(23);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Double.TYPE;
                    return;
                }
                if (iJj_ntk_f == 30) {
                    jj_consume_token(30);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Float.TYPE;
                    return;
                }
                if (iJj_ntk_f == 37) {
                    jj_consume_token(37);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Integer.TYPE;
                    return;
                }
                if (iJj_ntk_f == 39) {
                    jj_consume_token(39);
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                    bSHPrimitiveType.type = Long.TYPE;
                    return;
                }
                if (iJj_ntk_f != 48) {
                    this.jj_la1[32] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token(48);
                this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHPrimitiveType);
                }
                bSHPrimitiveType.type = Short.TYPE;
            } catch (Throwable th) {
                th = th;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHPrimitiveType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHPrimitiveType);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
    }

    public void ReInit(InputStream inputStream, Charset charset) {
        this.jj_input_stream.reInit(inputStream, charset, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    /* JADX WARN: Switch 'out' block B:3:0x0003 for B:6:0x000c already processed. Defaulting to fallback option. */
    public final void RelationalExpression() throws Throwable {
        Token tokenJj_consume_token;
        ShiftExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 86:
                case 87:
                case 88:
                case 89:
                case 93:
                case 94:
                case 95:
                case 96:
                    int iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    switch (iJj_ntk_f2) {
                        case 86:
                            tokenJj_consume_token = jj_consume_token(86);
                            break;
                        case 87:
                            tokenJj_consume_token = jj_consume_token(87);
                            break;
                        case 88:
                            tokenJj_consume_token = jj_consume_token(88);
                            break;
                        case 89:
                            tokenJj_consume_token = jj_consume_token(89);
                            break;
                        case 90:
                        case 91:
                        case 92:
                        default:
                            this.jj_la1[53] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        case 93:
                            tokenJj_consume_token = jj_consume_token(93);
                            break;
                        case 94:
                            tokenJj_consume_token = jj_consume_token(94);
                            break;
                        case 95:
                            tokenJj_consume_token = jj_consume_token(95);
                            break;
                        case 96:
                            tokenJj_consume_token = jj_consume_token(96);
                            break;
                    }
                    ShiftExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
                    this.jjtree.openNodeScope(bSHBinaryExpression);
                    jjtreeOpenNodeScope(bSHBinaryExpression);
                    boolean z = true;
                    try {
                        this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                        z = false;
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHBinaryExpression);
                        }
                        bSHBinaryExpression.kind = tokenJj_consume_token.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                            if (this.jjtree.nodeCreated()) {
                                jjtreeCloseNodeScope(bSHBinaryExpression);
                            }
                        }
                        throw th;
                    }
                    break;
                case 90:
                case 91:
                case 92:
                default:
                    this.jj_la1[52] = this.jj_gen;
                    return;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ReturnStatement() throws Throwable {
        boolean z;
        BSHReturnStatement bSHReturnStatement = new BSHReturnStatement(38);
        this.jjtree.openNodeScope(bSHReturnStatement);
        jjtreeOpenNodeScope(bSHReturnStatement);
        boolean z2 = false;
        try {
            jj_consume_token(47);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 12:
                case 15:
                case 18:
                case 23:
                case 27:
                case 30:
                case 37:
                case 39:
                case 41:
                case 42:
                case 48:
                case 56:
                case 58:
                case 61:
                case 66:
                case 69:
                case 70:
                case 71:
                case 73:
                case 76:
                case 78:
                case 80:
                case 90:
                case 91:
                case 102:
                case 103:
                case 104:
                case 105:
                    Expression();
                    break;
                default:
                    this.jj_la1[111] = this.jj_gen;
                    break;
            }
            jj_consume_token(82);
            this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
        } catch (Throwable th) {
            th = th;
            z = true;
        }
        try {
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHReturnStatement);
            }
            bSHReturnStatement.kind = 47;
        } catch (Throwable th2) {
            th = th2;
            z = false;
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHReturnStatement);
                } else {
                    this.jjtree.popNode();
                    z2 = z;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                z = th instanceof ParseException;
                if (z) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th4) {
                z = z2;
                th = th4;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHReturnStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHReturnStatement);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void ReturnType() throws Throwable {
        boolean z;
        BSHReturnType bSHReturnType = new BSHReturnType(12);
        this.jjtree.openNodeScope(bSHReturnType);
        jjtreeOpenNodeScope(bSHReturnType);
        boolean z2 = false;
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 12 && iJj_ntk_f != 15 && iJj_ntk_f != 18 && iJj_ntk_f != 23 && iJj_ntk_f != 30 && iJj_ntk_f != 37 && iJj_ntk_f != 39 && iJj_ntk_f != 48) {
                if (iJj_ntk_f == 58) {
                    jj_consume_token(58);
                    this.jjtree.closeNodeScope((Node) bSHReturnType, true);
                    try {
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHReturnType);
                        }
                        bSHReturnType.isVoid = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        try {
                            if (z) {
                                this.jjtree.clearNodeScope(bSHReturnType);
                            } else {
                                this.jjtree.popNode();
                                z2 = z;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            z = th instanceof ParseException;
                            if (z) {
                                throw ((ParseException) th);
                            }
                            if (!(th instanceof RuntimeException)) {
                                throw ((Error) th);
                            }
                            throw ((RuntimeException) th);
                        } catch (Throwable th3) {
                            th = th3;
                            z = z2;
                            if (z) {
                                this.jjtree.closeNodeScope((Node) bSHReturnType, true);
                                if (this.jjtree.nodeCreated()) {
                                    jjtreeCloseNodeScope(bSHReturnType);
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (iJj_ntk_f != 73) {
                    this.jj_la1[31] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            }
            Type();
            this.jjtree.closeNodeScope((Node) bSHReturnType, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHReturnType);
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    /* JADX WARN: Switch 'out' block B:3:0x0003 for B:6:0x000c already processed. Defaulting to fallback option. */
    public final void ShiftExpression() throws Throwable {
        Token tokenJj_consume_token;
        AdditiveExpression();
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            switch (iJj_ntk_f) {
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                    int iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    switch (iJj_ntk_f2) {
                        case 118:
                            tokenJj_consume_token = jj_consume_token(118);
                            break;
                        case 119:
                            tokenJj_consume_token = jj_consume_token(119);
                            break;
                        case 120:
                            tokenJj_consume_token = jj_consume_token(120);
                            break;
                        case 121:
                            tokenJj_consume_token = jj_consume_token(121);
                            break;
                        case 122:
                            tokenJj_consume_token = jj_consume_token(122);
                            break;
                        case 123:
                            tokenJj_consume_token = jj_consume_token(123);
                            break;
                        default:
                            this.jj_la1[55] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    AdditiveExpression();
                    BSHBinaryExpression bSHBinaryExpression = new BSHBinaryExpression(17);
                    this.jjtree.openNodeScope(bSHBinaryExpression);
                    jjtreeOpenNodeScope(bSHBinaryExpression);
                    boolean z = true;
                    try {
                        this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                        z = false;
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHBinaryExpression);
                        }
                        bSHBinaryExpression.kind = tokenJj_consume_token.kind;
                    } catch (Throwable th) {
                        if (z) {
                            this.jjtree.closeNodeScope(bSHBinaryExpression, 2);
                            if (this.jjtree.nodeCreated()) {
                                jjtreeCloseNodeScope(bSHBinaryExpression);
                            }
                        }
                        throw th;
                    }
                    break;
                default:
                    this.jj_la1[54] = this.jj_gen;
                    return;
            }
        }
    }

    public final void Statement() throws Throwable {
        if (jj_2_23(2)) {
            LabeledStatement();
            return;
        }
        if (jj_2_24(3)) {
            Block();
            return;
        }
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        switch (iJj_ntk_f) {
            case 12:
            case 15:
            case 18:
            case 23:
            case 27:
            case 30:
            case 37:
            case 39:
            case 41:
            case 42:
            case 48:
            case 56:
            case 58:
            case 61:
            case 66:
            case 69:
            case 70:
            case 71:
            case 73:
            case 76:
            case 78:
            case 80:
            case 90:
            case 91:
            case 102:
            case 103:
            case 104:
            case 105:
                StatementExpression();
                jj_consume_token(82);
                return;
            case 22:
                DoStatement();
                return;
            case 33:
                IfStatement();
                return;
            case 51:
                SwitchStatement();
                return;
            case 60:
                WhileStatement();
                return;
            case 82:
                EmptyStatement();
                return;
            default:
                this.jj_la1[93] = this.jj_gen;
                if (isRegularForStatement()) {
                    ForStatement();
                    return;
                }
                int iJj_ntk_f2 = this.jj_ntk;
                if (iJj_ntk_f2 == -1) {
                    iJj_ntk_f2 = jj_ntk_f();
                }
                if (iJj_ntk_f2 == 13) {
                    BreakStatement();
                    return;
                }
                if (iJj_ntk_f2 == 20) {
                    ContinueStatement();
                    return;
                }
                if (iJj_ntk_f2 == 31) {
                    EnhancedForStatement();
                    return;
                }
                if (iJj_ntk_f2 == 47) {
                    ReturnStatement();
                    return;
                }
                if (iJj_ntk_f2 == 52) {
                    SynchronizedStatement();
                    return;
                }
                if (iJj_ntk_f2 == 54) {
                    ThrowStatement();
                    return;
                } else if (iJj_ntk_f2 == 57) {
                    TryStatement();
                    return;
                } else {
                    this.jj_la1[94] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
        }
    }

    public final void StatementExpression() throws Throwable {
        Expression();
    }

    public final void StatementExpressionList() throws Throwable {
        boolean z;
        BSHStatementExpressionList bSHStatementExpressionList = new BSHStatementExpressionList(37);
        this.jjtree.openNodeScope(bSHStatementExpressionList);
        jjtreeOpenNodeScope(bSHStatementExpressionList);
        try {
            StatementExpression();
            while (true) {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 83) {
                    break;
                }
                jj_consume_token(83);
                StatementExpression();
            }
            this.jj_la1[108] = this.jj_gen;
            this.jjtree.closeNodeScope((Node) bSHStatementExpressionList, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHStatementExpressionList);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHStatementExpressionList);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHStatementExpressionList, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHStatementExpressionList);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void SwitchLabel() throws Throwable {
        boolean z;
        BSHSwitchLabel bSHSwitchLabel = new BSHSwitchLabel(31);
        this.jjtree.openNodeScope(bSHSwitchLabel);
        jjtreeOpenNodeScope(bSHSwitchLabel);
        boolean z2 = false;
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f == 16) {
                jj_consume_token(16);
                Expression();
                jj_consume_token(150);
                this.jjtree.closeNodeScope((Node) bSHSwitchLabel, true);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHSwitchLabel);
                    return;
                }
                return;
            }
            if (iJj_ntk_f != 154) {
                this.jj_la1[98] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
            jj_consume_token(154);
            this.jjtree.closeNodeScope((Node) bSHSwitchLabel, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHSwitchLabel);
                }
                bSHSwitchLabel.isDefault = true;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHSwitchLabel);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    z = z2;
                    th = th3;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHSwitchLabel, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHSwitchLabel);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void SwitchStatement() throws Throwable {
        boolean z;
        BSHSwitchStatement bSHSwitchStatement = new BSHSwitchStatement(30);
        this.jjtree.openNodeScope(bSHSwitchStatement);
        jjtreeOpenNodeScope(bSHSwitchStatement);
        try {
            jj_consume_token(51);
            jj_consume_token(76);
            Expression();
            jj_consume_token(77);
            jj_consume_token(78);
            while (true) {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 16 && iJj_ntk_f != 154) {
                    break;
                }
                SwitchLabel();
                while (jj_2_31(1)) {
                    BlockStatement();
                }
            }
            this.jj_la1[97] = this.jj_gen;
            jj_consume_token(79);
            this.jjtree.closeNodeScope((Node) bSHSwitchStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHSwitchStatement);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHSwitchStatement);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHSwitchStatement, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHSwitchStatement);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void SynchronizedStatement() throws Throwable {
        boolean z;
        BSHBlock bSHBlock = new BSHBlock(3);
        this.jjtree.openNodeScope(bSHBlock);
        jjtreeOpenNodeScope(bSHBlock);
        boolean z2 = false;
        try {
            jj_consume_token(52);
            jj_consume_token(76);
            Expression();
            jj_consume_token(77);
            Block();
            this.jjtree.closeNodeScope((Node) bSHBlock, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHBlock);
                }
                bSHBlock.isSynchronized = true;
            } catch (Throwable th) {
                th = th;
                z = false;
                try {
                    if (z) {
                        this.jjtree.clearNodeScope(bSHBlock);
                    } else {
                        this.jjtree.popNode();
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHBlock, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHBlock);
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = true;
        }
    }

    public final void ThrowStatement() throws Throwable {
        boolean z;
        BSHThrowStatement bSHThrowStatement = new BSHThrowStatement(39);
        this.jjtree.openNodeScope(bSHThrowStatement);
        jjtreeOpenNodeScope(bSHThrowStatement);
        try {
            jj_consume_token(54);
            Expression();
            jj_consume_token(82);
            this.jjtree.closeNodeScope((Node) bSHThrowStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHThrowStatement);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHThrowStatement);
                z = false;
                try {
                    if (th instanceof ParseException) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHThrowStatement, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHThrowStatement);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void TryStatement() throws Throwable {
        boolean z;
        boolean z2;
        BSHTryStatement bSHTryStatement = new BSHTryStatement(40);
        this.jjtree.openNodeScope(bSHTryStatement);
        jjtreeOpenNodeScope(bSHTryStatement);
        boolean z3 = false;
        try {
            jj_consume_token(57);
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 76) {
                this.jj_la1[112] = this.jj_gen;
            } else {
                TryWithResources();
            }
            Block();
            z2 = false;
            this.jj_la1[113] = this.jj_gen;
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 29) {
                this.jj_la1[114] = this.jj_gen;
            } else {
                jj_consume_token(29);
                Block();
                z2 = true;
            }
            this.jjtree.closeNodeScope((Node) bSHTryStatement, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHTryStatement);
                }
                if (z2) {
                    return;
                } else {
                    throw generateParseException();
                }
            } catch (Throwable th) {
                th = th;
                z = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        while (true) {
            int iJj_ntk_f3 = this.jj_ntk;
            if (iJj_ntk_f3 == -1) {
                iJj_ntk_f3 = jj_ntk_f();
            }
            if (iJj_ntk_f3 != 17) {
                break;
            }
            jj_consume_token(17);
            jj_consume_token(76);
            MultiCatch();
            jj_consume_token(77);
            Block();
            z2 = true;
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHTryStatement);
                } else {
                    this.jjtree.popNode();
                    z3 = z;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z3;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHTryStatement, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHTryStatement);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void TryWithResources() throws Throwable {
        boolean z;
        BSHTryWithResources bSHTryWithResources = new BSHTryWithResources(42);
        this.jjtree.openNodeScope(bSHTryWithResources);
        jjtreeOpenNodeScope(bSHTryWithResources);
        try {
            jj_consume_token(76);
            AutoCloseable();
            while (true) {
                int iJj_ntk_f = this.jj_ntk;
                if (iJj_ntk_f == -1) {
                    iJj_ntk_f = jj_ntk_f();
                }
                if (iJj_ntk_f != 82) {
                    break;
                }
                jj_consume_token(82);
                AutoCloseable();
            }
            this.jj_la1[118] = this.jj_gen;
            jj_consume_token(77);
            this.jjtree.closeNodeScope((Node) bSHTryWithResources, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHTryWithResources);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHTryWithResources);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHTryWithResources, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHTryWithResources);
                    }
                }
                throw th;
            }
        }
    }

    public final void Type() throws Throwable {
        boolean z;
        BSHType bSHType = new BSHType(11);
        this.jjtree.openNodeScope(bSHType);
        jjtreeOpenNodeScope(bSHType);
        try {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f == 12 || iJj_ntk_f == 15 || iJj_ntk_f == 18 || iJj_ntk_f == 23 || iJj_ntk_f == 30 || iJj_ntk_f == 37 || iJj_ntk_f == 39 || iJj_ntk_f == 48) {
                PrimitiveType();
            } else {
                if (iJj_ntk_f != 73) {
                    this.jj_la1[30] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                AmbiguousName();
            }
            while (jj_2_8(2)) {
                jj_consume_token(80);
                jj_consume_token(81);
                bSHType.addArrayDimension();
            }
            this.jjtree.closeNodeScope((Node) bSHType, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHType);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHType);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHType, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHType);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void TypedVariableDeclaration() throws Throwable {
        boolean z;
        BSHTypedVariableDeclaration bSHTypedVariableDeclaration = new BSHTypedVariableDeclaration(36);
        this.jjtree.openNodeScope(bSHTypedVariableDeclaration);
        jjtreeOpenNodeScope(bSHTypedVariableDeclaration);
        boolean z2 = false;
        try {
            Modifiers Modifiers = Modifiers(3, false);
            Type();
            VariableDeclarator();
            this.jj_la1[107] = this.jj_gen;
            this.jjtree.closeNodeScope((Node) bSHTypedVariableDeclaration, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHTypedVariableDeclaration);
                }
                if (Modifiers != null) {
                    bSHTypedVariableDeclaration.modifiers = Modifiers;
                    return;
                }
                return;
            } catch (Throwable th) {
                th = th;
                z = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        while (true) {
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 83) {
                break;
            }
            jj_consume_token(83);
            VariableDeclarator();
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHTypedVariableDeclaration);
                } else {
                    this.jjtree.popNode();
                    z2 = z;
                }
                try {
                    z = th instanceof ParseException;
                    if (z) {
                        throw ((ParseException) th);
                    }
                    if (!(th instanceof RuntimeException)) {
                        throw ((Error) th);
                    }
                    throw ((RuntimeException) th);
                } catch (Throwable th3) {
                    th = th3;
                    z = z2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) bSHTypedVariableDeclaration, true);
                        if (this.jjtree.nodeCreated()) {
                            jjtreeCloseNodeScope(bSHTypedVariableDeclaration);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void UnaryExpression() throws Throwable {
        Token tokenJj_consume_token;
        Token tokenJj_consume_token2;
        Token tokenJj_consume_token3;
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        boolean z = false;
        if (iJj_ntk_f != 90 && iJj_ntk_f != 91) {
            switch (iJj_ntk_f) {
                case 102:
                case 103:
                    int iJj_ntk_f2 = this.jj_ntk;
                    if (iJj_ntk_f2 == -1) {
                        iJj_ntk_f2 = jj_ntk_f();
                    }
                    if (iJj_ntk_f2 == 102) {
                        tokenJj_consume_token2 = jj_consume_token(102);
                    } else {
                        if (iJj_ntk_f2 != 103) {
                            this.jj_la1[63] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                        tokenJj_consume_token2 = jj_consume_token(103);
                    }
                    PrimaryExpression();
                    BSHUnaryExpression bSHUnaryExpression = new BSHUnaryExpression(18);
                    this.jjtree.openNodeScope(bSHUnaryExpression);
                    jjtreeOpenNodeScope(bSHUnaryExpression);
                    try {
                        this.jjtree.closeNodeScope(bSHUnaryExpression, 1);
                        try {
                            if (this.jjtree.nodeCreated()) {
                                jjtreeCloseNodeScope(bSHUnaryExpression);
                            }
                            bSHUnaryExpression.kind = tokenJj_consume_token2.kind;
                            return;
                        } catch (Throwable th) {
                            th = th;
                            if (z) {
                                this.jjtree.closeNodeScope(bSHUnaryExpression, 1);
                                if (this.jjtree.nodeCreated()) {
                                    jjtreeCloseNodeScope(bSHUnaryExpression);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                    break;
                case 104:
                case 105:
                    break;
                default:
                    this.jj_la1[66] = this.jj_gen;
                    if (jj_2_10(Integer.MAX_VALUE)) {
                        LambdaExpression();
                        return;
                    }
                    if (jj_2_11(Integer.MAX_VALUE)) {
                        CastExpression();
                        return;
                    }
                    int iJj_ntk_f3 = this.jj_ntk;
                    if (iJj_ntk_f3 == -1) {
                        iJj_ntk_f3 = jj_ntk_f();
                    }
                    switch (iJj_ntk_f3) {
                        case 12:
                        case 15:
                        case 18:
                        case 23:
                        case 27:
                        case 30:
                        case 37:
                        case 39:
                        case 41:
                        case 42:
                        case 48:
                        case 56:
                        case 58:
                        case 61:
                        case 66:
                        case 69:
                        case 70:
                        case 71:
                        case 73:
                        case 76:
                        case 78:
                        case 80:
                            PrimaryExpression();
                            int iJj_ntk_f4 = this.jj_ntk;
                            if (iJj_ntk_f4 == -1) {
                                iJj_ntk_f4 = jj_ntk_f();
                            }
                            if (iJj_ntk_f4 != 102 && iJj_ntk_f4 != 103) {
                                this.jj_la1[65] = this.jj_gen;
                                return;
                            }
                            int iJj_ntk_f5 = this.jj_ntk;
                            if (iJj_ntk_f5 == -1) {
                                iJj_ntk_f5 = jj_ntk_f();
                            }
                            if (iJj_ntk_f5 == 102) {
                                tokenJj_consume_token3 = jj_consume_token(102);
                            } else {
                                if (iJj_ntk_f5 != 103) {
                                    this.jj_la1[64] = this.jj_gen;
                                    jj_consume_token(-1);
                                    throw new ParseException();
                                }
                                tokenJj_consume_token3 = jj_consume_token(103);
                            }
                            BSHUnaryExpression bSHUnaryExpression2 = new BSHUnaryExpression(18);
                            this.jjtree.openNodeScope(bSHUnaryExpression2);
                            jjtreeOpenNodeScope(bSHUnaryExpression2);
                            try {
                                this.jjtree.closeNodeScope(bSHUnaryExpression2, 1);
                                try {
                                    if (this.jjtree.nodeCreated()) {
                                        jjtreeCloseNodeScope(bSHUnaryExpression2);
                                    }
                                    bSHUnaryExpression2.kind = tokenJj_consume_token3.kind;
                                    bSHUnaryExpression2.postfix = true;
                                    return;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (z) {
                                        this.jjtree.closeNodeScope(bSHUnaryExpression2, 1);
                                        if (this.jjtree.nodeCreated()) {
                                            jjtreeCloseNodeScope(bSHUnaryExpression2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                z = true;
                            }
                            break;
                        default:
                            this.jj_la1[67] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    break;
            }
        }
        int iJj_ntk_f6 = this.jj_ntk;
        if (iJj_ntk_f6 == -1) {
            iJj_ntk_f6 = jj_ntk_f();
        }
        if (iJj_ntk_f6 == 90) {
            tokenJj_consume_token = jj_consume_token(90);
        } else if (iJj_ntk_f6 == 91) {
            tokenJj_consume_token = jj_consume_token(91);
        } else if (iJj_ntk_f6 == 104) {
            tokenJj_consume_token = jj_consume_token(104);
        } else {
            if (iJj_ntk_f6 != 105) {
                this.jj_la1[62] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
            tokenJj_consume_token = jj_consume_token(105);
        }
        UnaryExpression();
        BSHUnaryExpression bSHUnaryExpression3 = new BSHUnaryExpression(18);
        this.jjtree.openNodeScope(bSHUnaryExpression3);
        jjtreeOpenNodeScope(bSHUnaryExpression3);
        try {
            this.jjtree.closeNodeScope(bSHUnaryExpression3, 1);
        } catch (Throwable th5) {
            th = th5;
            z = true;
        }
        try {
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHUnaryExpression3);
            }
            bSHUnaryExpression3.kind = tokenJj_consume_token.kind;
        } catch (Throwable th6) {
            th = th6;
            if (z) {
                this.jjtree.closeNodeScope(bSHUnaryExpression3, 1);
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHUnaryExpression3);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public final void VariableDeclarator() throws Throwable {
        boolean z;
        BSHVariableDeclarator bSHVariableDeclarator = new BSHVariableDeclarator(7);
        this.jjtree.openNodeScope(bSHVariableDeclarator);
        jjtreeOpenNodeScope(bSHVariableDeclarator);
        boolean z2 = false;
        try {
            Token tokenJj_consume_token = jj_consume_token(73);
            this.jj_la1[20] = this.jj_gen;
            int iJj_ntk_f = this.jj_ntk;
            if (iJj_ntk_f == -1) {
                iJj_ntk_f = jj_ntk_f();
            }
            if (iJj_ntk_f != 85) {
                this.jj_la1[21] = this.jj_gen;
            } else {
                jj_consume_token(85);
                VariableInitializer();
            }
            this.jjtree.closeNodeScope((Node) bSHVariableDeclarator, true);
            try {
                if (this.jjtree.nodeCreated()) {
                    jjtreeCloseNodeScope(bSHVariableDeclarator);
                }
                bSHVariableDeclarator.name = tokenJj_consume_token.image;
                return;
            } catch (Throwable th) {
                th = th;
                z = false;
            }
        } catch (Throwable th2) {
            th = th2;
            z = true;
        }
        while (true) {
            int iJj_ntk_f2 = this.jj_ntk;
            if (iJj_ntk_f2 == -1) {
                iJj_ntk_f2 = jj_ntk_f();
            }
            if (iJj_ntk_f2 != 80) {
                break;
            }
            jj_consume_token(80);
            jj_consume_token(81);
            bSHVariableDeclarator.dimensions++;
            try {
                if (z) {
                    this.jjtree.clearNodeScope(bSHVariableDeclarator);
                } else {
                    this.jjtree.popNode();
                    z2 = z;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                z = th instanceof ParseException;
                if (z) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th4) {
                th = th4;
                z = z2;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHVariableDeclarator, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHVariableDeclarator);
                    }
                }
                throw th;
            }
        }
    }

    public final void VariableInitializer() throws Throwable {
        if (jj_2_5(3)) {
            ArrayInitializer();
            return;
        }
        int iJj_ntk_f = this.jj_ntk;
        if (iJj_ntk_f == -1) {
            iJj_ntk_f = jj_ntk_f();
        }
        switch (iJj_ntk_f) {
            case 12:
            case 15:
            case 18:
            case 23:
            case 27:
            case 30:
            case 37:
            case 39:
            case 41:
            case 42:
            case 48:
            case 56:
            case 58:
            case 61:
            case 66:
            case 69:
            case 70:
            case 71:
            case 73:
            case 76:
            case 78:
            case 80:
            case 90:
            case 91:
            case 102:
            case 103:
            case 104:
            case 105:
                Expression();
                return;
            default:
                this.jj_la1[22] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final void VoidLiteral() throws ParseException {
        jj_consume_token(58);
    }

    public final void WhileStatement() throws Throwable {
        boolean z;
        BSHWhileStatement bSHWhileStatement = new BSHWhileStatement(33);
        this.jjtree.openNodeScope(bSHWhileStatement);
        jjtreeOpenNodeScope(bSHWhileStatement);
        try {
            jj_consume_token(60);
            jj_consume_token(76);
            Expression();
            jj_consume_token(77);
            Statement();
            this.jjtree.closeNodeScope((Node) bSHWhileStatement, true);
            if (this.jjtree.nodeCreated()) {
                jjtreeCloseNodeScope(bSHWhileStatement);
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(bSHWhileStatement);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof ParseException) {
                    throw ((ParseException) th);
                }
                if (!(th instanceof RuntimeException)) {
                    throw ((Error) th);
                }
                throw ((RuntimeException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) bSHWhileStatement, true);
                    if (this.jjtree.nodeCreated()) {
                        jjtreeCloseNodeScope(bSHWhileStatement);
                    }
                }
                throw th;
            }
        }
    }

    public ParseException createParseException(String str, Exception exc) {
        Token token = this.token;
        int i = token.beginLine;
        int i2 = token.beginColumn;
        if (token.kind == 0) {
            String str2 = ParserConstants.tokenImage[0];
        }
        StringBuilder sbQ = yg.concatVar31425(i, i2, "Parse error at line ", ", column ", " : ");
        sbQ.append(str);
        return new ParseException(sbQ.toString(), exc);
    }

    public final void disable_tracing() {
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        this.jj_expentries.clear();
        boolean[] zArr = new boolean[155];
        int i = this.jj_kind;
        if (i >= 0) {
            zArr[i] = true;
            this.jj_kind = -1;
        }
        for (int i2 = 0; i2 < 120; i2++) {
            if (this.jj_la1[i2] == this.jj_gen) {
                for (int i3 = 0; i3 < 32; i3++) {
                    int i4 = 1 << i3;
                    if ((jj_la1_0[i2] & i4) != 0) {
                        zArr[i3] = true;
                    }
                    if ((jj_la1_1[i2] & i4) != 0) {
                        zArr[i3 + 32] = true;
                    }
                    if ((jj_la1_2[i2] & i4) != 0) {
                        zArr[i3 + 64] = true;
                    }
                    if ((jj_la1_3[i2] & i4) != 0) {
                        zArr[i3 + 96] = true;
                    }
                    if ((jj_la1_4[i2] & i4) != 0) {
                        zArr[i3 + 128] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 155; i5++) {
            if (zArr[i5]) {
                int[] iArr = {i5};
                this.jj_expentry = iArr;
                this.jj_expentries.add(iArr);
            }
        }
        this.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] iArr2 = new int[this.jj_expentries.size()][];
        for (int i6 = 0; i6 < this.jj_expentries.size(); i6++) {
            iArr2[i6] = this.jj_expentries.get(i6);
        }
        return new ParseException(this.token, iArr2, ParserConstants.tokenImage);
    }

    public final Token getNextToken() {
        Token token = this.token;
        Token token2 = token.next;
        if (token2 != null) {
            this.token = token2;
        } else {
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token = this.jj_lookingAhead ? this.jj_scanpos : this.token;
        for (int i2 = 0; i2 < i; i2++) {
            if (token.next == null) {
                token.next = this.token_source.getNextToken();
            }
            token = token.next;
        }
        return token;
    }

    public boolean isFormalParameterDimensions() {
        if (getToken(1).kind != 80 || getToken(2).kind != 81) {
            return false;
        }
        int i = 3;
        while (true) {
            int i2 = i + 1;
            int i3 = getToken(i).kind;
            if (i3 == 0 || i3 == 85) {
                break;
            }
            if (i3 != 77) {
                if (i3 == 78 || i3 == 82) {
                    break;
                }
                if (i3 != 83) {
                    i = i2;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isRegularForStatement() {
        if (getToken(1).kind != 31 || getToken(2).kind != 76) {
            return false;
        }
        int i = 3;
        while (true) {
            int i2 = i + 1;
            int i3 = getToken(i).kind;
            if (i3 == 0) {
                return false;
            }
            if (i3 == 82) {
                return true;
            }
            if (i3 == 150) {
                return false;
            }
            i = i2;
        }
    }

    public void jjtreeCloseNodeScope(Node node) {
        ((SimpleNode) node).lastToken = getToken(0);
    }

    public void jjtreeOpenNodeScope(Node node) {
        ((SimpleNode) node).firstToken = getToken(1);
    }

    public Primitive parseIntegral(String str) {
        int radix = getRadix(str);
        return new Primitive(new BigInteger(str.substring(getStartIdx(radix)), radix));
    }

    public SimpleNode popNode() {
        if (this.jjtree.nodeArity() > 0) {
            return (SimpleNode) this.jjtree.popNode();
        }
        return null;
    }

    public void reInitInput(Reader reader) {
        ReInit(reader);
    }

    public void reInitTokenInput(Reader reader) {
        JavaCharStream javaCharStream = this.jj_input_stream;
        javaCharStream.reInit(reader, javaCharStream.getEndLine(), this.jj_input_stream.getEndColumn());
    }

    public void setRetainComments(boolean z) {
        this.retainComments = z;
    }

    public final boolean trace_enabled() {
        return false;
    }

    public void ReInit(Reader reader) {
        JavaCharStream javaCharStream = this.jj_input_stream;
        if (javaCharStream == null) {
            this.jj_input_stream = new JavaCharStream(reader, 1, 1);
        } else {
            javaCharStream.reInit(reader, 1, 1);
        }
        if (this.token_source == null) {
            this.token_source = new ParserTokenManager(this.jj_input_stream);
        }
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public Parser(Reader reader) {
        this.jjtree = new JJTParserState();
        int i = 0;
        this.retainComments = false;
        this.jj_lookingAhead = false;
        this.jj_la1 = new int[120];
        this.jj_2_rtns = new JJCalls[36];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(i);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        JavaCharStream javaCharStream = new JavaCharStream(reader, 1, 1);
        this.jj_input_stream = javaCharStream;
        this.token_source = new ParserTokenManager(javaCharStream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public void ReInit(ParserTokenManager parserTokenManager) {
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public Parser(ParserTokenManager parserTokenManager) {
        this.jjtree = new JJTParserState();
        int i = 0;
        this.retainComments = false;
        this.jj_lookingAhead = false;
        this.jj_la1 = new int[120];
        this.jj_2_rtns = new JJCalls[36];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(i);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = parserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 120; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }
}
