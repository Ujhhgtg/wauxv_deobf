package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.DateUtils;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Arrays;
import me.hd.wauxv.obf.bjs;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class JSONReaderUTF16 extends JSONReader {
    static final long CHAR_MASK;
    private int cacheIndex;
    protected final char[] chars;
    protected final int end;
    private Closeable input;
    protected final int length;
    private int nameBegin;
    private int nameEnd;
    private int nameLength;
    private int referenceBegin;
    protected final int start;
    protected final String str;

    static {
        CHAR_MASK = JDKUtils.BIG_ENDIAN ? 71777214294589695L : -71777214294589696L;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONReaderUTF16(JSONReader.Context context, byte[] bArr, int i, int i2) {
        char c;
        super(context, false, false);
        int i3 = 0;
        this.cacheIndex = -1;
        this.str = null;
        this.chars = new char[i2 / 2];
        int i4 = i + i2;
        int i5 = i;
        while (i5 < i4) {
            this.chars[i3] = (char) (((bArr[i5] & 255) << 8) | (bArr[i5 + 1] & 255));
            i5 += 2;
            i3++;
        }
        this.start = i;
        this.length = i3;
        this.end = i3;
        int i6 = this.offset;
        if (i6 >= i3) {
            this.ch = (char) 26;
            return;
        }
        this.ch = this.chars[i6];
        while (true) {
            char c2 = this.ch;
            if (c2 > ' ' || ((1 << c2) & 4294981376L) == 0) {
                break;
            }
            int i7 = this.offset + 1;
            this.offset = i7;
            if (i7 >= i2) {
                this.ch = (char) 26;
                return;
            }
            this.ch = this.chars[i7];
        }
        while (true) {
            c = this.ch;
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            int i8 = this.offset + 1;
            this.offset = i8;
            if (i8 >= i2) {
                this.ch = (char) 26;
                return;
            }
            this.ch = this.chars[i8];
        }
        this.offset++;
        if (c == 65534 || c == 65279) {
            next();
        }
        if (this.ch == '/') {
            skipComment();
        }
    }

    public static int getInt(char[] cArr, int i) {
        long longUnaligned = IOUtils.getLongUnaligned(cArr, i);
        if ((CHAR_MASK & longUnaligned) != 0) {
            return 0;
        }
        if (JDKUtils.BIG_ENDIAN) {
            longUnaligned >>= 8;
        }
        return (int) (((longUnaligned & 71776119061217280L) >> 24) | ((16711680 & longUnaligned) >> 8) | (255 & longUnaligned) | ((1095216660480L & longUnaligned) >> 16));
    }

    public static long getLong(char[] cArr, int i) {
        long longUnaligned = IOUtils.getLongUnaligned(cArr, i);
        long longUnaligned2 = IOUtils.getLongUnaligned(cArr, i + 4);
        if (((longUnaligned | longUnaligned2) & CHAR_MASK) != 0) {
            return 0L;
        }
        if (JDKUtils.BIG_ENDIAN) {
            longUnaligned >>= 8;
            longUnaligned2 >>= 8;
        }
        return ((longUnaligned & 71776119061217280L) >> 24) | (longUnaligned & 255) | ((longUnaligned & 16711680) >> 8) | ((longUnaligned & 1095216660480L) >> 16) | ((255 & longUnaligned2) << 32) | ((longUnaligned2 & 16711680) << 24) | ((longUnaligned2 & 1095216660480L) << 16) | ((longUnaligned2 & 71776119061217280L) << 8);
    }

    private boolean isReference0(char[] cArr, int i, int i2, char c) {
        int i3;
        int i4;
        char c2;
        int i5 = i + 6;
        char c3 = cArr[i5];
        while (c3 <= ' ' && ((1 << c3) & 4294981376L) != 0) {
            i5++;
            if (i5 >= i2) {
                return false;
            }
            c3 = cArr[i5];
        }
        if (c3 == ':' && (i3 = i5 + 1) < i2) {
            char c4 = cArr[i3];
            while (c4 <= ' ' && ((1 << c4) & 4294981376L) != 0) {
                i3++;
                if (i3 >= i2) {
                    return false;
                }
                c4 = cArr[i3];
            }
            if (c4 == c && ((i4 = i3 + 1) >= i2 || (c2 = cArr[i4]) == '$' || c2 == '.' || c2 == '@')) {
                this.referenceBegin = i3;
                return true;
            }
        }
        return false;
    }

    private static long parse4Nibbles(char[] cArr, int i) {
        byte[] bArr = JSONFactory.NIBBLES;
        char c = cArr[i];
        char c2 = cArr[i + 1];
        char c3 = cArr[i + 2];
        if ((c | c2 | c3 | cArr[i + 3]) > 255) {
            return -1L;
        }
        return bArr[r5] | (bArr[c] << 12) | (bArr[c2] << 8) | (bArr[c3] << 4);
    }

    private LocalDate readLocalDate0(int i, char[] cArr, char c) {
        int i2;
        int iMin = Math.min(i + 17, this.end);
        int i3 = -1;
        for (int i4 = i; i4 < iMin; i4++) {
            if (cArr[i4] == c) {
                i3 = i4;
            }
        }
        if (i3 == -1 || (i2 = i3 - i) <= 10 || cArr[i3 - 6] != '-' || cArr[i3 - 3] != '-') {
            return null;
        }
        LocalDate localDateOf = LocalDate.of(TypeUtils.parseInt(cArr, i, i2 - 6), IOUtils.digit2(cArr, i3 - 5), IOUtils.digit2(cArr, i3 - 2));
        this.offset = i3 + 1;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateOf;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0031 -> B:8:0x0017). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:11:0x0028
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipArray(com.alibaba.fastjson2.JSONReaderUTF16 r18, char[] r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            int r3 = next(r18, r19, r20, r21)
            r4 = 0
            r5 = r4
        Lc:
            char r6 = r0.ch
            r7 = 93
            if (r6 != r7) goto L84
            r5 = 26
            if (r3 != r2) goto L19
            r6 = r3
        L17:
            r3 = r5
            goto L1d
        L19:
            int r6 = r3 + 1
            char r3 = r1[r3]
        L1d:
            r8 = 0
            r10 = 4294981376(0x100003700, double:2.1220027474E-314)
            r12 = 1
            r14 = 32
            if (r3 > r14) goto L3e
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r15 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r15 == 0) goto L3e
            if (r6 != r2) goto L34
            goto L17
        L34:
            int r3 = r6 + 1
            char r6 = r1[r6]
            r17 = r6
            r6 = r3
            r3 = r17
            goto L1d
        L3e:
            r15 = 44
            if (r3 != r15) goto L60
            if (r6 != r2) goto L46
            r4 = r5
            goto L4b
        L46:
            int r3 = r6 + 1
            char r4 = r1[r6]
            goto L5d
        L4b:
            r3 = r4
        L4c:
            if (r3 > r14) goto L5f
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r4 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r4 == 0) goto L5f
            if (r6 != r2) goto L59
            r3 = r5
            goto L4c
        L59:
            int r3 = r6 + 1
            char r4 = r1[r6]
        L5d:
            r6 = r3
            goto L4b
        L5f:
            r4 = 1
        L60:
            r1 = 125(0x7d, float:1.75E-43)
            if (r4 != 0) goto L70
            if (r3 == r1) goto L70
            if (r3 == r7) goto L70
            if (r3 != r5) goto L6b
            goto L70
        L6b:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r6, r3)
            throw r0
        L70:
            if (r4 == 0) goto L7e
            if (r3 == r1) goto L79
            if (r3 == r7) goto L79
            if (r3 == r5) goto L79
            goto L7e
        L79:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r6, r3)
            throw r0
        L7e:
            r0.comma = r4
            char r1 = (char) r3
            r0.ch = r1
            return r6
        L84:
            if (r5 == 0) goto L90
            boolean r6 = r0.comma
            if (r6 == 0) goto L8b
            goto L90
        L8b:
            com.alibaba.fastjson2.JSONException r0 = r0.valueError()
            throw r0
        L90:
            int r3 = skipValue(r0, r1, r3, r2)
            int r5 = r5 + 1
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipArray(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:9:0x0013). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:12:0x0024
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipFalse(com.alibaba.fastjson2.JSONReaderUTF16 r18, char[] r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r21
            int r2 = r20 + 4
            if (r2 > r1) goto L82
            boolean r3 = com.alibaba.fastjson2.util.IOUtils.notALSE(r19, r20)
            if (r3 != 0) goto L82
            r3 = 26
            if (r2 != r1) goto L15
            r4 = r2
        L13:
            r2 = r3
            goto L19
        L15:
            int r4 = r20 + 5
            char r2 = r19[r2]
        L19:
            r5 = 0
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            r9 = 1
            r11 = 32
            if (r2 > r11) goto L3a
            long r12 = r9 << r2
            long r12 = r12 & r7
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 == 0) goto L3a
            if (r4 != r1) goto L30
            goto L13
        L30:
            int r2 = r4 + 1
            char r4 = r19[r4]
            r17 = r4
            r4 = r2
            r2 = r17
            goto L19
        L3a:
            r12 = 44
            r13 = 93
            r14 = 125(0x7d, float:1.75E-43)
            if (r2 != r12) goto L6f
            if (r4 != r1) goto L47
            r2 = r4
            r4 = r3
            goto L4b
        L47:
            int r2 = r4 + 1
            char r4 = r19[r4]
        L4b:
            r17 = r4
            r4 = r2
            r2 = r17
        L50:
            if (r2 > r11) goto L62
            long r15 = r9 << r2
            long r15 = r15 & r7
            int r12 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r12 == 0) goto L62
            if (r4 != r1) goto L5d
            r2 = r3
            goto L50
        L5d:
            int r2 = r4 + 1
            char r4 = r19[r4]
            goto L4b
        L62:
            if (r2 == r14) goto L6a
            if (r2 == r13) goto L6a
            if (r2 == r3) goto L6a
            r1 = 1
            goto L7c
        L6a:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r4, r2)
            throw r0
        L6f:
            if (r2 == r14) goto L7b
            if (r2 == r13) goto L7b
            if (r2 != r3) goto L76
            goto L7b
        L76:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r4, r2)
            throw r0
        L7b:
            r1 = 0
        L7c:
            r0.comma = r1
            char r1 = (char) r2
            r0.ch = r1
            return r4
        L82:
            com.alibaba.fastjson2.JSONException r0 = r0.error()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipFalse(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0031 -> B:9:0x0017). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:12:0x0028
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipNull(com.alibaba.fastjson2.JSONReaderUTF16 r19, char[] r20, int r21, int r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r22
            int r3 = r21 + 3
            if (r3 > r2) goto L87
            int r4 = r21 + (-1)
            boolean r4 = com.alibaba.fastjson2.util.IOUtils.notNULL(r1, r4)
            if (r4 != 0) goto L87
            r4 = 26
            if (r3 != r2) goto L19
            r5 = r3
        L17:
            r3 = r4
            goto L1d
        L19:
            int r5 = r21 + 4
            char r3 = r1[r3]
        L1d:
            r6 = 0
            r8 = 4294981376(0x100003700, double:2.1220027474E-314)
            r10 = 1
            r12 = 32
            if (r3 > r12) goto L3e
            long r13 = r10 << r3
            long r13 = r13 & r8
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 == 0) goto L3e
            if (r5 != r2) goto L34
            goto L17
        L34:
            int r3 = r5 + 1
            char r5 = r1[r5]
            r18 = r5
            r5 = r3
            r3 = r18
            goto L1d
        L3e:
            r13 = 44
            r14 = 93
            r15 = 125(0x7d, float:1.75E-43)
            if (r3 != r13) goto L74
            if (r5 != r2) goto L4b
            r3 = r5
            r5 = r4
            goto L4f
        L4b:
            int r3 = r5 + 1
            char r5 = r1[r5]
        L4f:
            r18 = r5
            r5 = r3
            r3 = r18
        L54:
            if (r3 > r12) goto L67
            long r16 = r10 << r3
            long r16 = r16 & r8
            int r13 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r13 == 0) goto L67
            if (r5 != r2) goto L62
            r3 = r4
            goto L54
        L62:
            int r3 = r5 + 1
            char r5 = r1[r5]
            goto L4f
        L67:
            if (r3 == r15) goto L6f
            if (r3 == r14) goto L6f
            if (r3 == r4) goto L6f
            r1 = 1
            goto L81
        L6f:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r5, r3)
            throw r0
        L74:
            if (r3 == r15) goto L80
            if (r3 == r14) goto L80
            if (r3 != r4) goto L7b
            goto L80
        L7b:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r5, r3)
            throw r0
        L80:
            r1 = 0
        L81:
            r0.comma = r1
            char r1 = (char) r3
            r0.ch = r1
            return r5
        L87:
            com.alibaba.fastjson2.JSONException r0 = r0.error()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipNull(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Found duplicated region for block: B:46:0x007a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:47:0x007c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Found duplicated region for block: B:49:0x0081  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:51:0x008a
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipNumber(com.alibaba.fastjson2.JSONReaderUTF16 r19, char[] r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipNumber(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0030 -> B:8:0x0016). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:11:0x0027
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipObject(com.alibaba.fastjson2.JSONReaderUTF16 r18, char[] r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r21
            int r3 = next(r18, r19, r20, r21)
            r5 = 0
        Lb:
            char r6 = r0.ch
            r7 = 125(0x7d, float:1.75E-43)
            if (r6 != r7) goto L83
            r5 = 26
            if (r3 != r2) goto L18
            r6 = r3
        L16:
            r3 = r5
            goto L1c
        L18:
            int r6 = r3 + 1
            char r3 = r1[r3]
        L1c:
            r8 = 0
            r10 = 4294981376(0x100003700, double:2.1220027474E-314)
            r12 = 1
            r14 = 32
            if (r3 > r14) goto L3d
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r15 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r15 == 0) goto L3d
            if (r6 != r2) goto L33
            goto L16
        L33:
            int r3 = r6 + 1
            char r6 = r1[r6]
            r17 = r6
            r6 = r3
            r3 = r17
            goto L1c
        L3d:
            r15 = 44
            r4 = 93
            if (r3 != r15) goto L70
            if (r6 != r2) goto L48
            r3 = r6
            r6 = r5
            goto L4c
        L48:
            int r3 = r6 + 1
            char r6 = r1[r6]
        L4c:
            r17 = r6
            r6 = r3
            r3 = r17
        L51:
            if (r3 > r14) goto L63
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r15 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r15 == 0) goto L63
            if (r6 != r2) goto L5e
            r3 = r5
            goto L51
        L5e:
            int r3 = r6 + 1
            char r6 = r1[r6]
            goto L4c
        L63:
            if (r3 == r7) goto L6b
            if (r3 == r4) goto L6b
            if (r3 == r5) goto L6b
            r4 = 1
            goto L7d
        L6b:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r6, r3)
            throw r0
        L70:
            if (r3 == r7) goto L7c
            if (r3 == r4) goto L7c
            if (r3 != r5) goto L77
            goto L7c
        L77:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r6, r3)
            throw r0
        L7c:
            r4 = 0
        L7d:
            r0.comma = r4
            char r1 = (char) r3
            r0.ch = r1
            return r6
        L83:
            if (r5 == 0) goto L8f
            boolean r4 = r0.comma
            if (r4 == 0) goto L8a
            goto L8f
        L8a:
            com.alibaba.fastjson2.JSONException r0 = r0.valueError()
            throw r0
        L8f:
            int r3 = skipName(r0, r1, r3, r2)
            int r3 = skipValue(r0, r1, r3, r2)
            int r5 = r5 + 1
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipObject(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    private static int skipSet(JSONReaderUTF16 jSONReaderUTF16, char[] cArr, int i, int i2) {
        if (nextIfSet(jSONReaderUTF16, cArr, i, i2)) {
            return skipArray(jSONReaderUTF16, cArr, jSONReaderUTF16.offset, i2);
        }
        throw jSONReaderUTF16.error();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0057 -> B:22:0x003d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:25:0x004e
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipString(com.alibaba.fastjson2.JSONReaderUTF16 r18, char[] r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r20
            r2 = r21
            char r3 = r0.ch
            r4 = 26
            if (r1 != r2) goto Le
            r5 = r4
            goto L14
        Le:
            int r5 = r1 + 1
            char r1 = r19[r1]
            goto Laf
        L14:
            r6 = 92
            if (r5 != r6) goto L38
            int r5 = r1 + 1
            char r7 = r19[r1]
            r8 = 117(0x75, float:1.64E-43)
            if (r7 != r8) goto L23
            int r5 = r1 + 5
            goto L33
        L23:
            r8 = 120(0x78, float:1.68E-43)
            if (r7 != r8) goto L2a
            int r5 = r1 + 3
            goto L33
        L2a:
            if (r7 == r6) goto L33
            r1 = 34
            if (r7 == r1) goto L33
            r0.char1(r7)
        L33:
            int r1 = r5 + 1
            char r5 = r19[r5]
            goto L14
        L38:
            if (r5 != r3) goto Lab
            if (r1 != r2) goto L3f
            r3 = r1
        L3d:
            r1 = r4
            goto L43
        L3f:
            int r3 = r1 + 1
            char r1 = r19[r1]
        L43:
            r5 = 0
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            r9 = 1
            r11 = 32
            if (r1 > r11) goto L64
            long r12 = r9 << r1
            long r12 = r12 & r7
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 == 0) goto L64
            if (r3 != r2) goto L5a
            goto L3d
        L5a:
            int r1 = r3 + 1
            char r3 = r19[r3]
            r17 = r3
            r3 = r1
            r1 = r17
            goto L43
        L64:
            r12 = 44
            r13 = 93
            r14 = 125(0x7d, float:1.75E-43)
            if (r1 != r12) goto L99
            if (r3 != r2) goto L71
            r1 = r3
            r3 = r4
            goto L75
        L71:
            int r1 = r3 + 1
            char r3 = r19[r3]
        L75:
            r17 = r3
            r3 = r1
            r1 = r17
        L7a:
            if (r1 > r11) goto L8c
            long r15 = r9 << r1
            long r15 = r15 & r7
            int r12 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r12 == 0) goto L8c
            if (r3 != r2) goto L87
            r1 = r4
            goto L7a
        L87:
            int r1 = r3 + 1
            char r3 = r19[r3]
            goto L75
        L8c:
            if (r1 == r14) goto L94
            if (r1 == r13) goto L94
            if (r1 == r4) goto L94
            r2 = 1
            goto La6
        L94:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r3, r1)
            throw r0
        L99:
            if (r1 == r14) goto La5
            if (r1 == r13) goto La5
            if (r1 != r4) goto La0
            goto La5
        La0:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r3, r1)
            throw r0
        La5:
            r2 = 0
        La6:
            r0.comma = r2
            r0.ch = r1
            return r3
        Lab:
            int r5 = r1 + 1
            char r1 = r19[r1]
        Laf:
            r17 = r5
            r5 = r1
            r1 = r17
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipString(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    private static int skipStringEscaped(JSONReaderUTF16 jSONReaderUTF16, char[] cArr, int i, int i2) {
        int i3 = i + 1;
        char c = cArr[i];
        while (true) {
            if (c == '\\') {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == 'u') {
                    i4 = i3 + 5;
                } else if (c2 == 'x') {
                    i4 = i3 + 3;
                } else if (c2 != '\\' && c2 != '\"') {
                    jSONReaderUTF16.char1(c2);
                }
                i3 = i4 + 1;
                c = cArr[i4];
            } else {
                if (c == i2) {
                    return i3;
                }
                int i5 = i3 + 1;
                char c3 = cArr[i3];
                i3 = i5;
                c = c3;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0031 -> B:9:0x0017). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:12:0x0028
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipTrue(com.alibaba.fastjson2.JSONReaderUTF16 r19, char[] r20, int r21, int r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r22
            int r3 = r21 + 3
            if (r3 > r2) goto L87
            int r4 = r21 + (-1)
            boolean r4 = com.alibaba.fastjson2.util.IOUtils.notTRUE(r1, r4)
            if (r4 != 0) goto L87
            r4 = 26
            if (r3 != r2) goto L19
            r5 = r3
        L17:
            r3 = r4
            goto L1d
        L19:
            int r5 = r21 + 4
            char r3 = r1[r3]
        L1d:
            r6 = 0
            r8 = 4294981376(0x100003700, double:2.1220027474E-314)
            r10 = 1
            r12 = 32
            if (r3 > r12) goto L3e
            long r13 = r10 << r3
            long r13 = r13 & r8
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 == 0) goto L3e
            if (r5 != r2) goto L34
            goto L17
        L34:
            int r3 = r5 + 1
            char r5 = r1[r5]
            r18 = r5
            r5 = r3
            r3 = r18
            goto L1d
        L3e:
            r13 = 44
            r14 = 93
            r15 = 125(0x7d, float:1.75E-43)
            if (r3 != r13) goto L74
            if (r5 != r2) goto L4b
            r3 = r5
            r5 = r4
            goto L4f
        L4b:
            int r3 = r5 + 1
            char r5 = r1[r5]
        L4f:
            r18 = r5
            r5 = r3
            r3 = r18
        L54:
            if (r3 > r12) goto L67
            long r16 = r10 << r3
            long r16 = r16 & r8
            int r13 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r13 == 0) goto L67
            if (r5 != r2) goto L62
            r3 = r4
            goto L54
        L62:
            int r3 = r5 + 1
            char r5 = r1[r5]
            goto L4f
        L67:
            if (r3 == r15) goto L6f
            if (r3 == r14) goto L6f
            if (r3 == r4) goto L6f
            r1 = 1
            goto L81
        L6f:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r5, r3)
            throw r0
        L74:
            if (r3 == r15) goto L80
            if (r3 == r14) goto L80
            if (r3 != r4) goto L7b
            goto L80
        L7b:
            com.alibaba.fastjson2.JSONException r0 = r0.error(r5, r3)
            throw r0
        L80:
            r1 = 0
        L81:
            r0.comma = r1
            char r1 = (char) r3
            r0.ch = r1
            return r5
        L87:
            com.alibaba.fastjson2.JSONException r0 = r0.error()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipTrue(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    private static int skipValue(JSONReaderUTF16 jSONReaderUTF16, char[] cArr, int i, int i2) {
        char c = jSONReaderUTF16.ch;
        return (c == '\"' || c == '\'') ? skipString(jSONReaderUTF16, cArr, i, i2) : c != 'S' ? c != '[' ? c != 'f' ? c != 'n' ? c != 't' ? c != '{' ? skipNumber(jSONReaderUTF16, cArr, i, i2) : skipObject(jSONReaderUTF16, cArr, i, i2) : skipTrue(jSONReaderUTF16, cArr, i, i2) : skipNull(jSONReaderUTF16, cArr, i, i2) : skipFalse(jSONReaderUTF16, cArr, i, i2) : skipArray(jSONReaderUTF16, cArr, i, i2) : skipSet(jSONReaderUTF16, cArr, i, i2);
    }

    @Override // com.alibaba.fastjson2.JSONReader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i = this.cacheIndex;
        if (i != -1) {
            char[] cArr = this.chars;
            if (cArr.length < 8388608) {
                JSONFactory.CHARS_UPDATER.lazySet(JSONFactory.CACHE_ITEMS[i], cArr);
            }
        }
        Closeable closeable = this.input;
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:31:0x0076 A[FALL_THROUGH] */
    /* JADX WARN: Switch 'out' block B:31:0x0076 for B:26:0x004b already processed. Defaulting to fallback option. */
    @Override // com.alibaba.fastjson2.JSONReader
    public final String getFieldName() {
        if (!this.nameEscape) {
            String str = this.str;
            if (str != null) {
                return str.substring(this.nameBegin, this.nameEnd);
            }
            char[] cArr = this.chars;
            int i = this.nameBegin;
            return new String(cArr, i, this.nameEnd - i);
        }
        char[] cArr2 = new char[this.nameLength];
        char[] cArr3 = this.chars;
        int i2 = this.nameBegin;
        int i3 = 0;
        while (i2 < this.nameEnd) {
            char cHexDigit4 = cArr3[i2];
            if (cHexDigit4 == '\\') {
                int i4 = i2 + 1;
                char c = cArr3[i4];
                if (c == '\"' || c == ':' || c == '@' || c == '\\') {
                    i2 = i4;
                    cHexDigit4 = c;
                } else if (c == 'u') {
                    cHexDigit4 = (char) IOUtils.hexDigit4(cArr3, JSONReaderJSONB.check3(i2 + 2, this.end));
                    i2 += 5;
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
                                    i2 = i4;
                                    continue;
                            }
                        case '*':
                        case '+':
                        case ',':
                        case '-':
                        case '.':
                        case '/':
                            i2 = i4;
                            cHexDigit4 = c;
                            break;
                    }
                } else {
                    char c2 = cArr3[i2 + 2];
                    i2 += 3;
                    cHexDigit4 = JSONReader.char2(c2, cArr3[i2]);
                }
            } else if (cHexDigit4 == '\"') {
                return new String(cArr2);
            }
            cArr2[i3] = cHexDigit4;
            i2++;
            i3++;
        }
        return new String(cArr2);
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final long getNameHashCodeLCase() {
        char c;
        char c2;
        long j;
        long j2;
        int i = this.nameBegin;
        char[] cArr = this.chars;
        char c3 = '\"';
        char c4 = (i <= 0 || cArr[i + (-1)] != '\'') ? '\"' : '\'';
        int i2 = 0;
        long j3 = 0;
        while (true) {
            int i3 = this.end;
            if (i < i3) {
                char cHexDigit4 = cArr[i];
                if (cHexDigit4 == '\\') {
                    int i4 = i + 1;
                    char c5 = cArr[i4];
                    if (c5 == 'u') {
                        cHexDigit4 = (char) IOUtils.hexDigit4(cArr, JSONReaderJSONB.check3(i + 2, i3));
                        i += 5;
                    } else if (c5 != 'x') {
                        cHexDigit4 = char1(c5);
                        i = i4;
                    } else {
                        char c6 = cArr[i + 2];
                        i += 3;
                        cHexDigit4 = JSONReader.char2(c6, cArr[i]);
                    }
                } else if (cHexDigit4 == c4) {
                }
                if (cHexDigit4 > 255 || i2 >= 8 || (i2 == 0 && cHexDigit4 == 0)) {
                    i = this.nameBegin;
                    j3 = 0;
                } else {
                    if ((cHexDigit4 != '_' && cHexDigit4 != '-' && cHexDigit4 != ' ') || (c2 = cArr[i + 1]) == '\"' || c2 == '\'' || c2 == cHexDigit4) {
                        if (cHexDigit4 >= 'A' && cHexDigit4 <= 'Z') {
                            cHexDigit4 = (char) (cHexDigit4 + ' ');
                        }
                        switch (i2) {
                            case 0:
                                j3 = (byte) cHexDigit4;
                                break;
                            case 1:
                                j = ((byte) cHexDigit4) << 8;
                                j2 = 255;
                                j3 = (j3 & j2) + j;
                                break;
                            case 2:
                                j = ((byte) cHexDigit4) << 16;
                                j2 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                                j3 = (j3 & j2) + j;
                                break;
                            case 3:
                                j = ((byte) cHexDigit4) << 24;
                                j2 = 16777215;
                                j3 = (j3 & j2) + j;
                                break;
                            case 4:
                                j = ((long) ((byte) cHexDigit4)) << 32;
                                j2 = 4294967295L;
                                j3 = (j3 & j2) + j;
                                break;
                            case 5:
                                j = ((long) ((byte) cHexDigit4)) << 40;
                                j2 = 1099511627775L;
                                j3 = (j3 & j2) + j;
                                break;
                            case 6:
                                j = ((long) ((byte) cHexDigit4)) << 48;
                                j2 = 281474976710655L;
                                j3 = (j3 & j2) + j;
                                break;
                            case 7:
                                j = ((long) ((byte) cHexDigit4)) << 56;
                                j2 = 72057594037927935L;
                                j3 = (j3 & j2) + j;
                                break;
                        }
                        i2++;
                    }
                    i++;
                }
            }
        }
        if (j3 != 0) {
            return j3;
        }
        long j4 = Fnv.MAGIC_HASH_CODE;
        while (true) {
            int i5 = this.end;
            if (i < i5) {
                char cHexDigit42 = cArr[i];
                if (cHexDigit42 == '\\') {
                    int i6 = i + 1;
                    char c7 = cArr[i6];
                    if (c7 == 'u') {
                        cHexDigit42 = (char) IOUtils.hexDigit4(cArr, JSONReaderJSONB.check3(i + 2, i5));
                        i += 5;
                    } else if (c7 != 'x') {
                        cHexDigit42 = char1(c7);
                        i = i6;
                    } else {
                        char c8 = cArr[i + 2];
                        i += 3;
                        cHexDigit42 = JSONReader.char2(c8, cArr[i]);
                    }
                } else if (cHexDigit42 == c4) {
                }
                i++;
                if (cHexDigit42 == '_' || cHexDigit42 == '-' || cHexDigit42 == ' ') {
                    char c9 = cArr[i];
                    if (c9 == c3 || c9 == '\'' || c9 == cHexDigit42) {
                        c = 'A';
                    }
                } else {
                    c = 'A';
                }
                if (cHexDigit42 >= c && cHexDigit42 <= 'Z') {
                    cHexDigit42 = (char) (cHexDigit42 + ' ');
                }
                j4 = Fnv.MAGIC_PRIME * (((long) cHexDigit42) ^ j4);
                c3 = '\"';
            }
        }
        return j4;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final int getRawInt() {
        int i = this.offset;
        int i2 = i + 3;
        char[] cArr = this.chars;
        if (i2 < cArr.length) {
            return getInt(cArr, i - 1);
        }
        return 0;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final long getRawLong() {
        int i = this.offset;
        int i2 = i + 7;
        char[] cArr = this.chars;
        if (i2 < cArr.length) {
            return getLong(cArr, i - 1);
        }
        return 0L;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final String getString() {
        String str = this.stringValue;
        if (str != null) {
            return str;
        }
        int i = this.nameEnd;
        int i2 = this.nameBegin;
        int i3 = i - i2;
        if (!this.nameEscape) {
            return new String(this.chars, i2, i3);
        }
        char[] cArr = this.chars;
        char[] cArr2 = new char[this.nameLength];
        int i4 = 0;
        while (true) {
            char cHexDigit4 = cArr[i2];
            if (cHexDigit4 == '\\') {
                int i5 = i2 + 1;
                char c = cArr[i5];
                if (c == '\"' || c == '\\') {
                    i2 = i5;
                    cHexDigit4 = c;
                } else if (c == 'u') {
                    cHexDigit4 = (char) IOUtils.hexDigit4(cArr, JSONReaderJSONB.check3(i2 + 2, this.end));
                    i2 += 5;
                } else if (c != 'x') {
                    cHexDigit4 = char1(c);
                    i2 = i5;
                } else {
                    char c2 = cArr[i2 + 2];
                    i2 += 3;
                    cHexDigit4 = JSONReader.char2(c2, cArr[i2]);
                }
            } else if (cHexDigit4 == '\"') {
                String str2 = new String(cArr2);
                this.stringValue = str2;
                return str2;
            }
            cArr2[i4] = cHexDigit4;
            i2++;
            i4++;
        }
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final int getStringLength() {
        int i;
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("string length only support string input");
        }
        int i2 = this.offset;
        char[] cArr = this.chars;
        int i3 = i2 + 8;
        if (i3 >= this.end || i3 >= cArr.length || cArr[i2] == c || cArr[i2 + 1] == c || cArr[i2 + 2] == c || cArr[i2 + 3] == c || cArr[i2 + 4] == c || cArr[i2 + 5] == c || cArr[i2 + 6] == c || cArr[i2 + 7] == c) {
            i = 0;
        } else {
            i = 8;
            i2 = i3;
        }
        while (i2 < this.end && cArr[i2] != c) {
            i2++;
            i++;
        }
        return i;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public String info(String str) {
        int i = 1;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!(i2 < this.offset) || !(i2 < this.end)) {
                break;
            }
            if (this.chars[i2] == '\n') {
                i++;
                i3 = 0;
            }
            i2++;
            i3++;
        }
        StringBuilder sb = new StringBuilder();
        if (str != null && !str.isEmpty()) {
            sb.append(str);
            sb.append(", ");
        }
        sb.append("offset ");
        sb.append(this.offset);
        sb.append(", character ");
        sb.append(this.ch);
        sb.append(", line ");
        sb.append(i);
        sb.append(", column ");
        sb.append(i3);
        sb.append(", fastjson-version 2.0.60");
        sb.append(i <= 1 ? ' ' : '\n');
        sb.append(this.chars, this.start, Math.min(this.length, 65535));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean isNull() {
        int i;
        return this.ch == 'n' && (i = this.offset) < this.end && this.chars[i] == 'u';
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean isReference() {
        int i;
        int i2;
        if ((this.context.features & 8589934592L) != 0) {
            return false;
        }
        char[] cArr = this.chars;
        if (this.ch != '{' || (i = this.offset) == (i2 = this.end)) {
            return false;
        }
        char c = cArr[i];
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i++;
            if (i >= i2) {
                return false;
            }
            c = cArr[i];
        }
        if (i + 6 < i2 && cArr[i + 1] == '$' && cArr[i + 2] == 'r' && cArr[i + 3] == 'e' && cArr[i + 4] == 'f' && cArr[i + 5] == c) {
            return isReference0(cArr, i, i2, c);
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x0038 A[LOOP:0: B:7:0x0011->B:20:0x0038, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:21:0x000b A[EDGE_INSN: B:21:0x000b->B:5:0x000b BREAK  A[LOOP:0: B:7:0x0011->B:20:0x0038], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:8:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0035 -> B:5:0x000b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:21:0x000b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final void next() {
        /*
            r9 = this;
            int r0 = r9.offset
            char[] r1 = r9.chars
            int r2 = r9.end
            r3 = 26
            if (r0 < r2) goto Ld
            r2 = r0
        Lb:
            r0 = r3
            goto L11
        Ld:
            int r2 = r0 + 1
            char r0 = r1[r0]
        L11:
            if (r0 == 0) goto L33
            r4 = 32
            if (r0 > r4) goto L27
            r4 = 1
            long r4 = r4 << r0
            r6 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r4 = r4 & r6
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L27
            goto L33
        L27:
            r9.offset = r2
            r9.ch = r0
            r1 = 47
            if (r0 != r1) goto L32
            r9.skipComment()
        L32:
            return
        L33:
            int r0 = r9.end
            if (r2 != r0) goto L38
            goto Lb
        L38:
            int r0 = r2 + 1
            char r2 = r1[r2]
            r8 = r2
            r2 = r0
            r0 = r8
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.next():void");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Found duplicated region for block: B:39:0x0070 A[LOOP:0: B:11:0x001b->B:39:0x0070, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:40:0x0015 A[EDGE_INSN: B:40:0x0015->B:9:0x0015 BREAK  A[LOOP:0: B:11:0x001b->B:39:0x0070], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x006d -> B:9:0x0015). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x0015
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfArrayEnd() {
        /*
            r17 = this;
            r0 = r17
            char r1 = r0.ch
            r2 = 93
            if (r1 == r2) goto La
            r1 = 0
            return r1
        La:
            int r1 = r0.offset
            char[] r2 = r0.chars
            int r3 = r0.end
            r4 = 26
            if (r1 != r3) goto L17
            r3 = r1
        L15:
            r1 = r4
            goto L1b
        L17:
            int r3 = r1 + 1
            char r1 = r2[r1]
        L1b:
            if (r1 == 0) goto L6b
            r5 = 0
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            r9 = 1
            r11 = 32
            if (r1 > r11) goto L32
            long r12 = r9 << r1
            long r12 = r12 & r7
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 == 0) goto L32
            goto L6b
        L32:
            r12 = 44
            r13 = 1
            if (r1 != r12) goto L5f
            r0.comma = r13
            int r1 = r0.end
            if (r3 != r1) goto L40
            r1 = r3
            r3 = r4
            goto L44
        L40:
            int r1 = r3 + 1
            char r3 = r2[r3]
        L44:
            r16 = r3
            r3 = r1
            r1 = r16
        L49:
            if (r1 == 0) goto L54
            if (r1 > r11) goto L5f
            long r14 = r9 << r1
            long r14 = r14 & r7
            int r12 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r12 == 0) goto L5f
        L54:
            int r1 = r0.end
            if (r3 != r1) goto L5a
            r1 = r4
            goto L49
        L5a:
            int r1 = r3 + 1
            char r3 = r2[r3]
            goto L44
        L5f:
            r0.ch = r1
            r0.offset = r3
            r2 = 47
            if (r1 != r2) goto L6a
            r0.skipComment()
        L6a:
            return r13
        L6b:
            int r1 = r0.end
            if (r3 != r1) goto L70
            goto L15
        L70:
            int r1 = r3 + 1
            char r3 = r2[r3]
            r16 = r3
            r3 = r1
            r1 = r16
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfArrayEnd():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0041 A[LOOP:0: B:11:0x0019->B:25:0x0041, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:26:0x0013 A[EDGE_INSN: B:26:0x0013->B:9:0x0013 BREAK  A[LOOP:0: B:11:0x0019->B:25:0x0041], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x003e -> B:9:0x0013). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0013
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfArrayStart() {
        /*
            r9 = this;
            char r0 = r9.ch
            r1 = 91
            if (r0 == r1) goto L8
            r0 = 0
            return r0
        L8:
            char[] r0 = r9.chars
            int r1 = r9.offset
            int r2 = r9.end
            r3 = 26
            if (r1 != r2) goto L15
            r2 = r1
        L13:
            r1 = r3
            goto L19
        L15:
            int r2 = r1 + 1
            char r1 = r0[r1]
        L19:
            if (r1 == 0) goto L3c
            r4 = 32
            if (r1 > r4) goto L2f
            r4 = 1
            long r4 = r4 << r1
            r6 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r4 = r4 & r6
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L2f
            goto L3c
        L2f:
            r9.ch = r1
            r9.offset = r2
            r0 = 47
            if (r1 != r0) goto L3a
            r9.skipComment()
        L3a:
            r0 = 1
            return r0
        L3c:
            int r1 = r9.end
            if (r2 != r1) goto L41
            goto L13
        L41:
            int r1 = r2 + 1
            char r2 = r0[r2]
            r8 = r2
            r2 = r1
            r1 = r8
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfArrayStart():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0041 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:33:0x005d A[LOOP:1: B:20:0x003f->B:33:0x005d, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:43:0x0039 A[EDGE_INSN: B:43:0x0039->B:18:0x0039 BREAK  A[LOOP:1: B:20:0x003f->B:33:0x005d], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x005a -> B:18:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:30:0x0058
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfComma() {
        /*
            r14 = this;
            char[] r0 = r14.chars
            int r1 = r14.offset
            char r2 = r14.ch
        L6:
            r3 = 0
            r5 = 4294981376(0x100003700, double:2.1220027474E-314)
            r7 = 1
            r9 = 32
            r10 = 26
            if (r2 > r9) goto L2a
            long r11 = r7 << r2
            long r11 = r11 & r5
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 == 0) goto L2a
            int r2 = r14.end
            if (r1 != r2) goto L22
            r2 = r10
            goto L6
        L22:
            int r2 = r1 + 1
            char r1 = r0[r1]
            r13 = r2
            r2 = r1
            r1 = r13
            goto L6
        L2a:
            r11 = 44
            if (r2 == r11) goto L34
            r14.offset = r1
            r14.ch = r2
            r0 = 0
            return r0
        L34:
            int r2 = r14.end
            if (r1 != r2) goto L3b
            r2 = r1
        L39:
            r1 = r10
            goto L3f
        L3b:
            int r2 = r1 + 1
            char r1 = r0[r1]
        L3f:
            if (r1 == 0) goto L58
            if (r1 > r9) goto L4b
            long r11 = r7 << r1
            long r11 = r11 & r5
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 == 0) goto L4b
            goto L58
        L4b:
            r14.offset = r2
            r14.ch = r1
            r0 = 47
            if (r1 != r0) goto L56
            r14.skipComment()
        L56:
            r0 = 1
            return r0
        L58:
            int r1 = r14.end
            if (r2 != r1) goto L5d
            goto L39
        L5d:
            int r1 = r2 + 1
            char r2 = r0[r2]
            r13 = r2
            r2 = r1
            r1 = r13
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfComma():boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0062 -> B:23:0x0047). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:26:0x004f
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfInfinity() {
        /*
            r10 = this;
            char[] r0 = r10.chars
            int r1 = r10.offset
            char r2 = r10.ch
            r3 = 73
            if (r2 != r3) goto L73
            int r2 = r1 + 6
            int r3 = r10.end
            if (r2 >= r3) goto L73
            char r4 = r0[r1]
            r5 = 110(0x6e, float:1.54E-43)
            if (r4 != r5) goto L73
            int r4 = r1 + 1
            char r4 = r0[r4]
            r6 = 102(0x66, float:1.43E-43)
            if (r4 != r6) goto L73
            int r4 = r1 + 2
            char r4 = r0[r4]
            r6 = 105(0x69, float:1.47E-43)
            if (r4 != r6) goto L73
            int r4 = r1 + 3
            char r4 = r0[r4]
            if (r4 != r5) goto L73
            int r4 = r1 + 4
            char r4 = r0[r4]
            if (r4 != r6) goto L73
            int r4 = r1 + 5
            char r4 = r0[r4]
            r5 = 116(0x74, float:1.63E-43)
            if (r4 != r5) goto L73
            char r2 = r0[r2]
            r4 = 121(0x79, float:1.7E-43)
            if (r2 != r4) goto L73
            int r2 = r1 + 7
            r4 = 26
            if (r2 != r3) goto L49
            r1 = r2
        L47:
            r2 = r4
            goto L4d
        L49:
            int r1 = r1 + 8
            char r2 = r0[r2]
        L4d:
            r3 = 32
            if (r2 > r3) goto L6d
            r5 = 1
            long r5 = r5 << r2
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r5 = r5 & r7
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L6d
            int r2 = r10.end
            if (r1 != r2) goto L65
            goto L47
        L65:
            int r2 = r1 + 1
            char r1 = r0[r1]
            r9 = r2
            r2 = r1
            r1 = r9
            goto L4d
        L6d:
            r10.offset = r1
            r10.ch = r2
            r0 = 1
            return r0
        L73:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfInfinity():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x003b A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:32:0x0057 A[LOOP:1: B:19:0x0039->B:32:0x0057, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:42:0x0033 A[EDGE_INSN: B:42:0x0033->B:17:0x0033 BREAK  A[LOOP:1: B:19:0x0039->B:32:0x0057], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0054 -> B:17:0x0033). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:20:0x003b
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatch(char r15) {
        /*
            r14 = this;
            char[] r0 = r14.chars
            int r1 = r14.offset
            char r2 = r14.ch
        L6:
            r3 = 0
            r5 = 4294981376(0x100003700, double:2.1220027474E-314)
            r7 = 1
            r9 = 32
            r10 = 26
            if (r2 > r9) goto L2a
            long r11 = r7 << r2
            long r11 = r11 & r5
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 == 0) goto L2a
            int r2 = r14.end
            if (r1 != r2) goto L22
            r2 = r10
            goto L6
        L22:
            int r2 = r1 + 1
            char r1 = r0[r1]
            r13 = r2
            r2 = r1
            r1 = r13
            goto L6
        L2a:
            if (r2 == r15) goto L2e
            r15 = 0
            return r15
        L2e:
            int r15 = r14.end
            if (r1 != r15) goto L35
            r15 = r1
        L33:
            r1 = r10
            goto L39
        L35:
            int r15 = r1 + 1
            char r1 = r0[r1]
        L39:
            if (r1 == 0) goto L52
            if (r1 > r9) goto L45
            long r11 = r7 << r1
            long r11 = r11 & r5
            int r2 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r2 == 0) goto L45
            goto L52
        L45:
            r14.offset = r15
            r14.ch = r1
            r15 = 47
            if (r1 != r15) goto L50
            r14.skipComment()
        L50:
            r15 = 1
            return r15
        L52:
            int r1 = r14.end
            if (r15 != r1) goto L57
            goto L33
        L57:
            int r1 = r15 + 1
            char r15 = r0[r15]
            r13 = r1
            r1 = r15
            r15 = r13
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatch(char):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0035 -> B:13:0x001a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:16:0x0022
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatchIdent(char r9, char r10) {
        /*
            r8 = this;
            char r0 = r8.ch
            r1 = 0
            if (r0 == r9) goto L6
            return r1
        L6:
            char[] r9 = r8.chars
            int r0 = r8.offset
            int r2 = r0 + 1
            int r3 = r8.end
            if (r2 > r3) goto L67
            char r4 = r9[r0]
            if (r4 == r10) goto L15
            goto L67
        L15:
            r10 = 26
            if (r2 != r3) goto L1c
            r0 = r2
        L1a:
            r2 = r10
            goto L20
        L1c:
            int r0 = r0 + 2
            char r2 = r9[r2]
        L20:
            r3 = 32
            if (r2 > r3) goto L40
            r3 = 1
            long r3 = r3 << r2
            r5 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r3 = r3 & r5
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L40
            int r2 = r8.end
            if (r0 != r2) goto L38
            goto L1a
        L38:
            int r2 = r0 + 1
            char r0 = r9[r0]
            r7 = r2
            r2 = r0
            r0 = r7
            goto L20
        L40:
            int r9 = r8.offset
            int r9 = r9 + 2
            if (r0 != r9) goto L61
            if (r2 == r10) goto L61
            r9 = 40
            if (r2 == r9) goto L61
            r9 = 91
            if (r2 == r9) goto L61
            r9 = 93
            if (r2 == r9) goto L61
            r9 = 41
            if (r2 == r9) goto L61
            r9 = 58
            if (r2 == r9) goto L61
            r9 = 44
            if (r2 == r9) goto L61
            return r1
        L61:
            r8.offset = r0
            r8.ch = r2
            r9 = 1
            return r9
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatchIdent(char, char):boolean");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match10(long j) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 12;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || cArr[i2 + 11] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match11(long j) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 13;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || cArr[i2 + 11] != '\"' || cArr[i2 + 12] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match12(long j, byte b) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 14;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || cArr[i2 + 11] != b || cArr[i2 + 12] != '\"' || cArr[i2 + 13] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match13(long j, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 15;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getInt(cArr, i3 + 11) != i) {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match14(long j, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 16;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getInt(cArr, i3 + 11) != i || cArr[i3 + 15] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match15(long j, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 17;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getInt(cArr, i3 + 11) != i || cArr[i3 + 15] != '\"' || cArr[i3 + 16] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match16(long j, int i, byte b) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 18;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getInt(cArr, i3 + 11) != i || cArr[i3 + 15] != b || cArr[i3 + 16] != '\"' || cArr[i3 + 17] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match17(long j, long j2) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 19;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2) {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match18(long j, long j2) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 20;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || cArr[i2 + 19] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match19(long j, long j2) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 21;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || cArr[i2 + 19] != '\"' || cArr[i2 + 20] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match2() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 4;
        if (i3 >= this.end || cArr[i2 + 3] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match20(long j, long j2, byte b) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 22;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || cArr[i2 + 19] != b || cArr[i2 + 20] != '\"' || cArr[i2 + 21] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match21(long j, long j2, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 23;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getInt(cArr, i3 + 19) != i) {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match22(long j, long j2, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 24;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getInt(cArr, i3 + 19) != i || cArr[i3 + 23] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match23(long j, long j2, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 25;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getInt(cArr, i3 + 19) != i || cArr[i3 + 23] != '\"' || cArr[i3 + 24] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match24(long j, long j2, int i, byte b) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 26;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getInt(cArr, i3 + 19) != i || cArr[i3 + 23] != b || cArr[i3 + 24] != '\"' || cArr[i3 + 25] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match25(long j, long j2, long j3) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 27;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3) {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match26(long j, long j2, long j3) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 28;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || cArr[i2 + 27] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = this.chars[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match27(long j, long j2, long j3) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 29;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || cArr[i2 + 27] != '\"' || cArr[i2 + 28] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = this.chars[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match28(long j, long j2, long j3, byte b) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 30;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || cArr[i2 + 27] != b || cArr[i2 + 28] != '\"' || cArr[i2 + 29] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match29(long j, long j2, long j3, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 31;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getInt(cArr, i3 + 27) != i) {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match3() {
        char c;
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 5;
        if (i2 >= this.end || cArr[i + 3] != '\"' || cArr[i + 4] != ':') {
            return false;
        }
        while (true) {
            c = cArr[i2];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i2++;
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match30(long j, long j2, long j3, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 32;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getInt(cArr, i3 + 27) != i || cArr[i3 + 31] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match31(long j, long j2, long j3, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 33;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getInt(cArr, i3 + 27) != i || cArr[i3 + 31] != '\"' || cArr[i3 + 32] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match32(long j, long j2, long j3, int i, byte b) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 34;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getInt(cArr, i3 + 27) != i || cArr[i3 + 31] != b || cArr[i3 + 32] != '\"' || cArr[i3 + 33] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match33(long j, long j2, long j3, long j4) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 35;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4) {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match34(long j, long j2, long j3, long j4) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 36;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || cArr[i2 + 35] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match35(long j, long j2, long j3, long j4) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 37;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || cArr[i2 + 35] != '\"' || cArr[i2 + 36] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match36(long j, long j2, long j3, long j4, byte b) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 38;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || cArr[i2 + 35] != b || cArr[i2 + 36] != '\"' || cArr[i2 + 37] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match37(long j, long j2, long j3, long j4, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 39;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getLong(cArr, i3 + 27) != j4 || getInt(cArr, i3 + 35) != i) {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match38(long j, long j2, long j3, long j4, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 40;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getLong(cArr, i3 + 27) != j4 || getInt(cArr, i3 + 35) != i || cArr[i3 + 39] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match39(long j, long j2, long j3, long j4, int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 41;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getLong(cArr, i3 + 27) != j4 || getInt(cArr, i3 + 35) != i || cArr[i3 + 39] != '\"' || cArr[i3 + 40] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match4(byte b) {
        char c;
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 6;
        if (i2 >= this.end || cArr[i + 3] != b || cArr[i + 4] != '\"' || cArr[i + 5] != ':') {
            return false;
        }
        while (true) {
            c = cArr[i2];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i2++;
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match40(long j, long j2, long j3, long j4, int i, byte b) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 42;
        if (i4 >= this.end || getLong(cArr, i3 + 3) != j || getLong(cArr, i3 + 11) != j2 || getLong(cArr, i3 + 19) != j3 || getLong(cArr, i3 + 27) != j4 || getInt(cArr, i3 + 35) != i || cArr[i3 + 39] != b || cArr[i3 + 40] != '\"' || cArr[i3 + 41] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match41(long j, long j2, long j3, long j4, long j5) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 43;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || getLong(cArr, i2 + 35) != j5) {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match42(long j, long j2, long j3, long j4, long j5) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 44;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || getLong(cArr, i2 + 35) != j5 || cArr[i2 + 43] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match43(long j, long j2, long j3, long j4, long j5) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 45;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j || getLong(cArr, i2 + 11) != j2 || getLong(cArr, i2 + 19) != j3 || getLong(cArr, i2 + 27) != j4 || getLong(cArr, i2 + 35) != j5 || cArr[i2 + 43] != '\"' || cArr[i2 + 44] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match5(int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 7;
        if (i4 >= this.end || getInt(cArr, i3 + 3) != i) {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match6(int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 8;
        if (i4 >= this.end || getInt(cArr, i3 + 3) != i || cArr[i3 + 7] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match7(int i) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 9;
        if (i4 >= this.end || getInt(cArr, i3 + 3) != i || cArr[i3 + 7] != '\"' || cArr[i3 + 8] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match8(int i, byte b) {
        int i2;
        char c;
        char[] cArr = this.chars;
        int i3 = this.offset;
        int i4 = i3 + 10;
        if (i4 >= this.end || getInt(cArr, i3 + 3) != i || cArr[i3 + 7] != b || cArr[i3 + 8] != '\"' || cArr[i3 + 9] != ':') {
            return false;
        }
        while (true) {
            i2 = i4 + 1;
            c = cArr[i4];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i4 = i2;
        }
        this.offset = i2;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName4Match9(long j) {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 11;
        if (i3 >= this.end || getLong(cArr, i2 + 3) != j) {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName8Match0() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset + 7;
        if (i2 == this.end) {
            this.ch = (char) 26;
            return false;
        }
        while (true) {
            i = i2 + 1;
            c = cArr[i2];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i2 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName8Match1() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 8;
        if (i3 >= this.end || cArr[i2 + 7] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfName8Match2() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 9;
        if (i3 >= this.end || cArr[i2 + 7] != '\"' || cArr[i2 + 8] != ':') {
            return false;
        }
        while (true) {
            i = i3 + 1;
            c = cArr[i3];
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            i3 = i;
        }
        this.offset = i;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfNull() {
        if (this.ch != 'n') {
            return false;
        }
        int i = this.offset;
        if (i + 2 >= this.end || this.chars[i] != 'u') {
            return false;
        }
        readNull();
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x006a -> B:33:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:36:0x0061
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfNullOrEmptyString() {
        /*
            r18 = this;
            r0 = r18
            char r1 = r0.ch
            int r2 = r0.end
            int r3 = r0.offset
            char[] r4 = r0.chars
            r5 = 110(0x6e, float:1.54E-43)
            r6 = 0
            r7 = 1
            if (r1 != r5) goto L29
            int r5 = r3 + 2
            if (r5 >= r2) goto L29
            char r8 = r4[r3]
            r9 = 117(0x75, float:1.64E-43)
            if (r8 != r9) goto L29
            int r8 = r3 + 1
            char r8 = r4[r8]
            r9 = 108(0x6c, float:1.51E-43)
            if (r8 != r9) goto L29
            char r5 = r4[r5]
            if (r5 != r9) goto L29
            int r3 = r3 + 3
            goto L4b
        L29:
            r5 = 34
            if (r1 == r5) goto L33
            r5 = 39
            if (r1 != r5) goto L32
            goto L33
        L32:
            return r6
        L33:
            if (r3 >= r2) goto L3b
            char r5 = r4[r3]
            if (r5 != r1) goto L3b
            int r3 = r3 + r7
            goto L4b
        L3b:
            int r5 = r3 + 4
            if (r5 >= r2) goto La3
            boolean r8 = com.alibaba.fastjson2.util.IOUtils.isNULL(r4, r3)
            if (r8 == 0) goto La3
            char r5 = r4[r5]
            if (r5 != r1) goto La3
            int r3 = r3 + 5
        L4b:
            r1 = 26
            if (r3 != r2) goto L52
            r5 = r3
        L50:
            r3 = r1
            goto L56
        L52:
            int r5 = r3 + 1
            char r3 = r4[r3]
        L56:
            r8 = 0
            r10 = 4294981376(0x100003700, double:2.1220027474E-314)
            r12 = 1
            r14 = 32
            if (r3 > r14) goto L77
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r15 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r15 == 0) goto L77
            if (r5 != r2) goto L6d
            goto L50
        L6d:
            int r3 = r5 + 1
            char r5 = r4[r5]
            r17 = r5
            r5 = r3
            r3 = r17
            goto L56
        L77:
            r15 = 44
            if (r3 != r15) goto L7c
            r6 = r7
        L7c:
            r0.comma = r6
            if (r6 == 0) goto L8d
            if (r5 != r2) goto L84
        L82:
            r3 = r1
            goto L8d
        L84:
            int r3 = r5 + 1
            char r5 = r4[r5]
        L88:
            r17 = r5
            r5 = r3
            r3 = r17
        L8d:
            if (r3 > r14) goto L9e
            long r15 = r12 << r3
            long r15 = r15 & r10
            int r6 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r6 == 0) goto L9e
            if (r5 != r2) goto L99
            goto L82
        L99:
            int r3 = r5 + 1
            char r5 = r4[r5]
            goto L88
        L9e:
            r0.offset = r5
            r0.ch = r3
            return r7
        La3:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfNullOrEmptyString():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Found duplicated region for block: B:39:0x0070 A[LOOP:0: B:11:0x001b->B:39:0x0070, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:40:0x0015 A[EDGE_INSN: B:40:0x0015->B:9:0x0015 BREAK  A[LOOP:0: B:11:0x001b->B:39:0x0070], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x006d -> B:9:0x0015). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x0015
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfObjectEnd() {
        /*
            r17 = this;
            r0 = r17
            char r1 = r0.ch
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto La
            r1 = 0
            return r1
        La:
            int r1 = r0.offset
            char[] r2 = r0.chars
            int r3 = r0.end
            r4 = 26
            if (r1 != r3) goto L17
            r3 = r1
        L15:
            r1 = r4
            goto L1b
        L17:
            int r3 = r1 + 1
            char r1 = r2[r1]
        L1b:
            if (r1 == 0) goto L6b
            r5 = 0
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            r9 = 1
            r11 = 32
            if (r1 > r11) goto L32
            long r12 = r9 << r1
            long r12 = r12 & r7
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 == 0) goto L32
            goto L6b
        L32:
            r12 = 44
            r13 = 1
            if (r1 != r12) goto L5f
            r0.comma = r13
            int r1 = r0.end
            if (r3 != r1) goto L40
            r1 = r3
            r3 = r4
            goto L44
        L40:
            int r1 = r3 + 1
            char r3 = r2[r3]
        L44:
            r16 = r3
            r3 = r1
            r1 = r16
        L49:
            if (r1 == 0) goto L54
            if (r1 > r11) goto L5f
            long r14 = r9 << r1
            long r14 = r14 & r7
            int r12 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r12 == 0) goto L5f
        L54:
            int r1 = r0.end
            if (r3 != r1) goto L5a
            r1 = r4
            goto L49
        L5a:
            int r1 = r3 + 1
            char r3 = r2[r3]
            goto L44
        L5f:
            r0.ch = r1
            r0.offset = r3
            r2 = 47
            if (r1 != r2) goto L6a
            r0.skipComment()
        L6a:
            return r13
        L6b:
            int r1 = r0.end
            if (r3 != r1) goto L70
            goto L15
        L70:
            int r1 = r3 + 1
            char r3 = r2[r3]
            r16 = r3
            r3 = r1
            r1 = r16
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfObjectEnd():boolean");
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0041 A[LOOP:0: B:11:0x0019->B:25:0x0041, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:26:0x0013 A[EDGE_INSN: B:26:0x0013->B:9:0x0013 BREAK  A[LOOP:0: B:11:0x0019->B:25:0x0041], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x003e -> B:9:0x0013). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x0013
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfObjectStart() {
        /*
            r9 = this;
            char r0 = r9.ch
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L8
            r0 = 0
            return r0
        L8:
            char[] r0 = r9.chars
            int r1 = r9.offset
            int r2 = r9.end
            r3 = 26
            if (r1 != r2) goto L15
            r2 = r1
        L13:
            r1 = r3
            goto L19
        L15:
            int r2 = r1 + 1
            char r1 = r0[r1]
        L19:
            if (r1 == 0) goto L3c
            r4 = 32
            if (r1 > r4) goto L2f
            r4 = 1
            long r4 = r4 << r1
            r6 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r4 = r4 & r6
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L2f
            goto L3c
        L2f:
            r9.ch = r1
            r9.offset = r2
            r0 = 47
            if (r1 != r0) goto L3a
            r9.skipComment()
        L3a:
            r0 = 1
            return r0
        L3c:
            int r1 = r9.end
            if (r2 != r1) goto L41
            goto L13
        L41:
            int r1 = r2 + 1
            char r2 = r0[r2]
            r8 = r2
            r2 = r1
            r1 = r8
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfObjectStart():boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x003e -> B:13:0x0023). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:16:0x002b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfSet() {
        /*
            r10 = this;
            char[] r0 = r10.chars
            int r1 = r10.offset
            char r2 = r10.ch
            r3 = 83
            if (r2 != r3) goto L4f
            int r2 = r1 + 1
            int r3 = r10.end
            if (r2 >= r3) goto L4f
            char r4 = r0[r1]
            r5 = 101(0x65, float:1.42E-43)
            if (r4 != r5) goto L4f
            char r2 = r0[r2]
            r4 = 116(0x74, float:1.63E-43)
            if (r2 != r4) goto L4f
            int r2 = r1 + 2
            r4 = 26
            if (r2 != r3) goto L25
            r1 = r2
        L23:
            r2 = r4
            goto L29
        L25:
            int r1 = r1 + 3
            char r2 = r0[r2]
        L29:
            r3 = 32
            if (r2 > r3) goto L49
            r5 = 1
            long r5 = r5 << r2
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r5 = r5 & r7
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L49
            int r2 = r10.end
            if (r1 != r2) goto L41
            goto L23
        L41:
            int r2 = r1 + 1
            char r1 = r0[r1]
            r9 = r2
            r2 = r1
            r1 = r9
            goto L29
        L49:
            r10.offset = r1
            r10.ch = r2
            r0 = 1
            return r0
        L4f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfSet():boolean");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match10(long j) {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 11;
        if (i2 >= this.end || getLong(cArr, i + 3) != j) {
            return false;
        }
        char c = cArr[i2];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i2 = i + 12;
            c = i2 == this.end ? (char) 26 : cArr[i2];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i2++;
            c = cArr[i2];
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match11(long j) {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 12;
        if (i2 >= this.end || getLong(cArr, i + 3) != j || cArr[i + 11] != '\"') {
            return false;
        }
        char c = cArr[i2];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i2 = i + 13;
            c = i2 == this.end ? (char) 26 : cArr[i2];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i2++;
            c = cArr[i2];
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match2() {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 3;
        int i3 = this.end;
        if (i2 >= i3) {
            return false;
        }
        char c = cArr[i2];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i2 = i + 4;
            c = i2 == i3 ? (char) 26 : cArr[i2];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i2++;
            c = cArr[i2];
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match3() {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 4;
        int i3 = this.end;
        if (i2 >= i3 || cArr[i + 3] != '\"') {
            return false;
        }
        char c = cArr[i2];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i2 = i + 5;
            c = i2 == i3 ? (char) 26 : cArr[i2];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i2++;
            c = cArr[i2];
        }
        this.offset = i2 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match4(byte b) {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 5;
        int i3 = this.end;
        boolean z = false;
        if (i2 >= i3) {
            return false;
        }
        if (cArr[i + 3] == b && cArr[i + 4] == '\"') {
            char c = cArr[i2];
            if (c != ',' && c != '}' && c != ']') {
                return false;
            }
            z = true;
            if (c == ',') {
                this.comma = true;
                i2 = i + 6;
                c = i2 == i3 ? (char) 26 : cArr[i2];
            }
            while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
                i2++;
                c = cArr[i2];
            }
            this.offset = i2 + 1;
            this.ch = c;
        }
        return z;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match5(byte b, byte b2) {
        char[] cArr = this.chars;
        int i = this.offset;
        int i2 = i + 6;
        int i3 = this.end;
        boolean z = false;
        if (i2 >= i3) {
            return false;
        }
        if (cArr[i + 3] == b && cArr[i + 4] == b2 && cArr[i + 5] == '\"') {
            char c = cArr[i2];
            if (c != ',' && c != '}' && c != ']') {
                return false;
            }
            z = true;
            if (c == ',') {
                this.comma = true;
                i2 = i + 7;
                c = i2 == i3 ? (char) 26 : cArr[i2];
            }
            while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
                i2++;
                c = cArr[i2];
            }
            this.offset = i2 + 1;
            this.ch = c;
        }
        return z;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match6(int i) {
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 7;
        if (i3 >= this.end || getInt(cArr, i2 + 3) != i) {
            return false;
        }
        char c = cArr[i3];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i3 = i2 + 8;
            c = i3 == this.end ? (char) 26 : cArr[i3];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i3++;
            c = cArr[i3];
        }
        this.offset = i3 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match7(int i) {
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 8;
        boolean z = false;
        if (i3 >= this.end) {
            return false;
        }
        if (getInt(cArr, i2 + 3) == i && cArr[i2 + 7] == '\"') {
            char c = cArr[i3];
            if (c != ',' && c != '}' && c != ']') {
                return false;
            }
            z = true;
            if (c == ',') {
                this.comma = true;
                i3 = i2 + 9;
                c = i3 == this.end ? (char) 26 : cArr[i3];
            }
            while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
                i3++;
                c = cArr[i3];
            }
            this.offset = i3 + 1;
            this.ch = c;
        }
        return z;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match8(int i, byte b) {
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 9;
        if (i3 >= this.end || getInt(cArr, i2 + 3) != i || cArr[i2 + 7] != b || cArr[i2 + 8] != '\"') {
            return false;
        }
        char c = cArr[i3];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i3 = i2 + 10;
            c = i3 == this.end ? (char) 26 : cArr[i3];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i3++;
            c = cArr[i3];
        }
        this.offset = i3 + 1;
        this.ch = c;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfValue4Match9(int i, byte b, byte b2) {
        char[] cArr = this.chars;
        int i2 = this.offset;
        int i3 = i2 + 10;
        if (i3 >= this.end || getInt(cArr, i2 + 3) != i || cArr[i2 + 7] != b || cArr[i2 + 8] != b2 || cArr[i2 + 9] != '\"') {
            return false;
        }
        char c = cArr[i3];
        if (c != ',' && c != '}' && c != ']') {
            return false;
        }
        if (c == ',') {
            this.comma = true;
            i3 = i2 + 11;
            c = i3 == this.end ? (char) 26 : cArr[i3];
        }
        while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
            i3++;
            c = cArr[i3];
        }
        this.offset = i3 + 1;
        this.ch = c;
        return true;
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x0031 A[LOOP:0: B:7:0x0011->B:18:0x0031, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:19:0x000b A[EDGE_INSN: B:19:0x000b->B:5:0x000b BREAK  A[LOOP:0: B:7:0x0011->B:18:0x0031], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:8:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002e -> B:5:0x000b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:8:0x0013
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final void nextWithoutComment() {
        /*
            r9 = this;
            int r0 = r9.offset
            char[] r1 = r9.chars
            int r2 = r9.end
            r3 = 26
            if (r0 < r2) goto Ld
            r2 = r0
        Lb:
            r0 = r3
            goto L11
        Ld:
            int r2 = r0 + 1
            char r0 = r1[r0]
        L11:
            if (r0 == 0) goto L2c
            r4 = 32
            if (r0 > r4) goto L27
            r4 = 1
            long r4 = r4 << r0
            r6 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r4 = r4 & r6
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L27
            goto L2c
        L27:
            r9.offset = r2
            r9.ch = r0
            return
        L2c:
            int r0 = r9.end
            if (r2 != r0) goto L31
            goto Lb
        L31:
            int r0 = r2 + 1
            char r2 = r1[r2]
            r8 = r2
            r2 = r0
            r0 = r8
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextWithoutComment():void");
    }

    /* JADX WARN: Found duplicated region for block: B:114:0x019f A[PHI: r8
      0x019f: PHI (r8v16 int) = (r8v15 int), (r8v18 int) binds: [B:99:0x0161, B:103:0x016d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:212:0x02c9 -> B:203:0x02a7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:208:0x02bc
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final java.math.BigDecimal readBigDecimal() {
        /*
            Method dump skipped, instruction units count: 787
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readBigDecimal():java.math.BigDecimal");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x014f -> B:94:0x013d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0123 -> B:77:0x0109). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:97:0x0144
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean readBoolValue() {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readBoolValue():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x020a, code lost:
    
        r14 = -r14;
     */
    /* JADX WARN: Found duplicated region for block: B:154:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:155:0x01d9  */
    /* JADX WARN: Found duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Found duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Found duplicated region for block: B:160:0x01ea A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:161:0x01ec  */
    /* JADX WARN: Found duplicated region for block: B:169:0x0201  */
    /* JADX WARN: Found duplicated region for block: B:170:0x0204 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:171:0x0206  */
    /* JADX WARN: Found duplicated region for block: B:174:0x020c A[ADDED_TO_REGION] */
    @Override // com.alibaba.fastjson2.JSONReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public double readDoubleValue() {
        /*
            Method dump skipped, instruction units count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readDoubleValue():double");
    }

    /* JADX WARN: Found duplicated region for block: B:349:0x0822 A[PHI: r18 r21 r27 r28 r29
      0x0822: PHI (r18v19 long) = 
      (r18v0 long)
      (r18v0 long)
      (r18v0 long)
      (r18v1 long)
      (r18v1 long)
      (r18v1 long)
      (r18v1 long)
      (r18v2 long)
      (r18v2 long)
      (r18v2 long)
      (r18v2 long)
      (r18v2 long)
      (r18v3 long)
      (r18v3 long)
      (r18v3 long)
      (r18v3 long)
      (r18v3 long)
      (r18v3 long)
      (r18v4 long)
      (r18v4 long)
      (r18v4 long)
      (r18v4 long)
      (r18v4 long)
      (r18v4 long)
      (r18v4 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v6 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v7 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v8 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v9 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v10 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v11 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v12 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v15 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v17 long)
      (r18v20 long)
     binds: [B:343:0x080f, B:345:0x0813, B:347:0x0817, B:334:0x07d9, B:336:0x07dd, B:338:0x07e1, B:340:0x07e5, B:323:0x0791, B:325:0x0795, B:327:0x0799, B:329:0x079d, B:331:0x07a1, B:310:0x073d, B:312:0x0741, B:314:0x0745, B:316:0x0749, B:318:0x074d, B:320:0x0751, B:295:0x06dc, B:297:0x06e0, B:299:0x06e4, B:301:0x06e8, B:303:0x06ec, B:305:0x06f0, B:307:0x06f4, B:277:0x0669, B:279:0x066d, B:281:0x0671, B:283:0x0675, B:285:0x0679, B:287:0x067d, B:289:0x0681, B:291:0x0685, B:258:0x05ee, B:260:0x05f2, B:262:0x05f6, B:264:0x05fa, B:266:0x05fe, B:268:0x0602, B:270:0x0606, B:272:0x060a, B:274:0x060e, B:237:0x0568, B:239:0x056c, B:241:0x0570, B:243:0x0574, B:245:0x0578, B:247:0x057c, B:249:0x0580, B:251:0x0584, B:253:0x0588, B:255:0x058c, B:214:0x04d7, B:216:0x04db, B:218:0x04df, B:220:0x04e3, B:222:0x04e7, B:224:0x04eb, B:226:0x04ef, B:228:0x04f3, B:230:0x04f7, B:232:0x04fb, B:234:0x04ff, B:189:0x043d, B:191:0x0441, B:193:0x0445, B:195:0x0449, B:197:0x044d, B:199:0x0451, B:201:0x0455, B:203:0x0459, B:205:0x045d, B:207:0x0461, B:209:0x0465, B:211:0x0469, B:162:0x0394, B:164:0x0398, B:166:0x039c, B:168:0x03a0, B:170:0x03a4, B:172:0x03a8, B:174:0x03ac, B:176:0x03b0, B:178:0x03b4, B:180:0x03b8, B:182:0x03bc, B:184:0x03c0, B:186:0x03c4, B:133:0x02df, B:135:0x02e3, B:137:0x02e7, B:139:0x02eb, B:141:0x02ef, B:143:0x02f3, B:145:0x02f7, B:147:0x02fb, B:149:0x02ff, B:151:0x0303, B:153:0x0307, B:155:0x030b, B:157:0x030f, B:159:0x0313, B:100:0x0216, B:102:0x021a, B:104:0x021e, B:106:0x0222, B:108:0x0226, B:110:0x022a, B:112:0x022e, B:114:0x0232, B:116:0x0236, B:118:0x023a, B:120:0x023e, B:122:0x0242, B:124:0x0246, B:126:0x024a, B:128:0x024e, B:66:0x013d, B:68:0x0141, B:70:0x0145, B:72:0x0149, B:74:0x014d, B:76:0x0151, B:78:0x0155, B:80:0x0159, B:82:0x015d, B:84:0x0161, B:86:0x0165, B:88:0x0169, B:90:0x016d, B:92:0x0171, B:94:0x0175, B:96:0x017d, B:64:0x00d5] A[DONT_GENERATE, DONT_INLINE]
      0x0822: PHI (r21v19 char) = 
      (r21v0 char)
      (r21v0 char)
      (r21v0 char)
      (r21v1 char)
      (r21v1 char)
      (r21v1 char)
      (r21v1 char)
      (r21v2 char)
      (r21v2 char)
      (r21v2 char)
      (r21v2 char)
      (r21v2 char)
      (r21v3 char)
      (r21v3 char)
      (r21v3 char)
      (r21v3 char)
      (r21v3 char)
      (r21v3 char)
      (r21v4 char)
      (r21v4 char)
      (r21v4 char)
      (r21v4 char)
      (r21v4 char)
      (r21v4 char)
      (r21v4 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v6 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v7 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v8 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v9 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v10 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v11 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v12 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v15 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v17 char)
      (r21v20 char)
     binds: [B:343:0x080f, B:345:0x0813, B:347:0x0817, B:334:0x07d9, B:336:0x07dd, B:338:0x07e1, B:340:0x07e5, B:323:0x0791, B:325:0x0795, B:327:0x0799, B:329:0x079d, B:331:0x07a1, B:310:0x073d, B:312:0x0741, B:314:0x0745, B:316:0x0749, B:318:0x074d, B:320:0x0751, B:295:0x06dc, B:297:0x06e0, B:299:0x06e4, B:301:0x06e8, B:303:0x06ec, B:305:0x06f0, B:307:0x06f4, B:277:0x0669, B:279:0x066d, B:281:0x0671, B:283:0x0675, B:285:0x0679, B:287:0x067d, B:289:0x0681, B:291:0x0685, B:258:0x05ee, B:260:0x05f2, B:262:0x05f6, B:264:0x05fa, B:266:0x05fe, B:268:0x0602, B:270:0x0606, B:272:0x060a, B:274:0x060e, B:237:0x0568, B:239:0x056c, B:241:0x0570, B:243:0x0574, B:245:0x0578, B:247:0x057c, B:249:0x0580, B:251:0x0584, B:253:0x0588, B:255:0x058c, B:214:0x04d7, B:216:0x04db, B:218:0x04df, B:220:0x04e3, B:222:0x04e7, B:224:0x04eb, B:226:0x04ef, B:228:0x04f3, B:230:0x04f7, B:232:0x04fb, B:234:0x04ff, B:189:0x043d, B:191:0x0441, B:193:0x0445, B:195:0x0449, B:197:0x044d, B:199:0x0451, B:201:0x0455, B:203:0x0459, B:205:0x045d, B:207:0x0461, B:209:0x0465, B:211:0x0469, B:162:0x0394, B:164:0x0398, B:166:0x039c, B:168:0x03a0, B:170:0x03a4, B:172:0x03a8, B:174:0x03ac, B:176:0x03b0, B:178:0x03b4, B:180:0x03b8, B:182:0x03bc, B:184:0x03c0, B:186:0x03c4, B:133:0x02df, B:135:0x02e3, B:137:0x02e7, B:139:0x02eb, B:141:0x02ef, B:143:0x02f3, B:145:0x02f7, B:147:0x02fb, B:149:0x02ff, B:151:0x0303, B:153:0x0307, B:155:0x030b, B:157:0x030f, B:159:0x0313, B:100:0x0216, B:102:0x021a, B:104:0x021e, B:106:0x0222, B:108:0x0226, B:110:0x022a, B:112:0x022e, B:114:0x0232, B:116:0x0236, B:118:0x023a, B:120:0x023e, B:122:0x0242, B:124:0x0246, B:126:0x024a, B:128:0x024e, B:66:0x013d, B:68:0x0141, B:70:0x0145, B:72:0x0149, B:74:0x014d, B:76:0x0151, B:78:0x0155, B:80:0x0159, B:82:0x015d, B:84:0x0161, B:86:0x0165, B:88:0x0169, B:90:0x016d, B:92:0x0171, B:94:0x0175, B:96:0x017d, B:64:0x00d5] A[DONT_GENERATE, DONT_INLINE]
      0x0822: PHI (r27v19 char[]) = 
      (r27v0 char[])
      (r27v0 char[])
      (r27v0 char[])
      (r27v1 char[])
      (r27v1 char[])
      (r27v1 char[])
      (r27v1 char[])
      (r27v2 char[])
      (r27v2 char[])
      (r27v2 char[])
      (r27v2 char[])
      (r27v2 char[])
      (r27v3 char[])
      (r27v3 char[])
      (r27v3 char[])
      (r27v3 char[])
      (r27v3 char[])
      (r27v3 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v4 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v6 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v7 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v8 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v9 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v10 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v11 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v12 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v15 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v17 char[])
      (r27v20 char[])
     binds: [B:343:0x080f, B:345:0x0813, B:347:0x0817, B:334:0x07d9, B:336:0x07dd, B:338:0x07e1, B:340:0x07e5, B:323:0x0791, B:325:0x0795, B:327:0x0799, B:329:0x079d, B:331:0x07a1, B:310:0x073d, B:312:0x0741, B:314:0x0745, B:316:0x0749, B:318:0x074d, B:320:0x0751, B:295:0x06dc, B:297:0x06e0, B:299:0x06e4, B:301:0x06e8, B:303:0x06ec, B:305:0x06f0, B:307:0x06f4, B:277:0x0669, B:279:0x066d, B:281:0x0671, B:283:0x0675, B:285:0x0679, B:287:0x067d, B:289:0x0681, B:291:0x0685, B:258:0x05ee, B:260:0x05f2, B:262:0x05f6, B:264:0x05fa, B:266:0x05fe, B:268:0x0602, B:270:0x0606, B:272:0x060a, B:274:0x060e, B:237:0x0568, B:239:0x056c, B:241:0x0570, B:243:0x0574, B:245:0x0578, B:247:0x057c, B:249:0x0580, B:251:0x0584, B:253:0x0588, B:255:0x058c, B:214:0x04d7, B:216:0x04db, B:218:0x04df, B:220:0x04e3, B:222:0x04e7, B:224:0x04eb, B:226:0x04ef, B:228:0x04f3, B:230:0x04f7, B:232:0x04fb, B:234:0x04ff, B:189:0x043d, B:191:0x0441, B:193:0x0445, B:195:0x0449, B:197:0x044d, B:199:0x0451, B:201:0x0455, B:203:0x0459, B:205:0x045d, B:207:0x0461, B:209:0x0465, B:211:0x0469, B:162:0x0394, B:164:0x0398, B:166:0x039c, B:168:0x03a0, B:170:0x03a4, B:172:0x03a8, B:174:0x03ac, B:176:0x03b0, B:178:0x03b4, B:180:0x03b8, B:182:0x03bc, B:184:0x03c0, B:186:0x03c4, B:133:0x02df, B:135:0x02e3, B:137:0x02e7, B:139:0x02eb, B:141:0x02ef, B:143:0x02f3, B:145:0x02f7, B:147:0x02fb, B:149:0x02ff, B:151:0x0303, B:153:0x0307, B:155:0x030b, B:157:0x030f, B:159:0x0313, B:100:0x0216, B:102:0x021a, B:104:0x021e, B:106:0x0222, B:108:0x0226, B:110:0x022a, B:112:0x022e, B:114:0x0232, B:116:0x0236, B:118:0x023a, B:120:0x023e, B:122:0x0242, B:124:0x0246, B:126:0x024a, B:128:0x024e, B:66:0x013d, B:68:0x0141, B:70:0x0145, B:72:0x0149, B:74:0x014d, B:76:0x0151, B:78:0x0155, B:80:0x0159, B:82:0x015d, B:84:0x0161, B:86:0x0165, B:88:0x0169, B:90:0x016d, B:92:0x0171, B:94:0x0175, B:96:0x017d, B:64:0x00d5] A[DONT_GENERATE, DONT_INLINE]
      0x0822: PHI (r28v19 int) = 
      (r28v0 int)
      (r28v0 int)
      (r28v0 int)
      (r28v1 int)
      (r28v1 int)
      (r28v1 int)
      (r28v1 int)
      (r28v2 int)
      (r28v2 int)
      (r28v2 int)
      (r28v2 int)
      (r28v2 int)
      (r28v3 int)
      (r28v3 int)
      (r28v3 int)
      (r28v3 int)
      (r28v3 int)
      (r28v3 int)
      (r28v4 int)
      (r28v4 int)
      (r28v4 int)
      (r28v4 int)
      (r28v4 int)
      (r28v4 int)
      (r28v4 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v6 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v7 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v8 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v9 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v10 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v11 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v12 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v15 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v17 int)
      (r28v20 int)
     binds: [B:343:0x080f, B:345:0x0813, B:347:0x0817, B:334:0x07d9, B:336:0x07dd, B:338:0x07e1, B:340:0x07e5, B:323:0x0791, B:325:0x0795, B:327:0x0799, B:329:0x079d, B:331:0x07a1, B:310:0x073d, B:312:0x0741, B:314:0x0745, B:316:0x0749, B:318:0x074d, B:320:0x0751, B:295:0x06dc, B:297:0x06e0, B:299:0x06e4, B:301:0x06e8, B:303:0x06ec, B:305:0x06f0, B:307:0x06f4, B:277:0x0669, B:279:0x066d, B:281:0x0671, B:283:0x0675, B:285:0x0679, B:287:0x067d, B:289:0x0681, B:291:0x0685, B:258:0x05ee, B:260:0x05f2, B:262:0x05f6, B:264:0x05fa, B:266:0x05fe, B:268:0x0602, B:270:0x0606, B:272:0x060a, B:274:0x060e, B:237:0x0568, B:239:0x056c, B:241:0x0570, B:243:0x0574, B:245:0x0578, B:247:0x057c, B:249:0x0580, B:251:0x0584, B:253:0x0588, B:255:0x058c, B:214:0x04d7, B:216:0x04db, B:218:0x04df, B:220:0x04e3, B:222:0x04e7, B:224:0x04eb, B:226:0x04ef, B:228:0x04f3, B:230:0x04f7, B:232:0x04fb, B:234:0x04ff, B:189:0x043d, B:191:0x0441, B:193:0x0445, B:195:0x0449, B:197:0x044d, B:199:0x0451, B:201:0x0455, B:203:0x0459, B:205:0x045d, B:207:0x0461, B:209:0x0465, B:211:0x0469, B:162:0x0394, B:164:0x0398, B:166:0x039c, B:168:0x03a0, B:170:0x03a4, B:172:0x03a8, B:174:0x03ac, B:176:0x03b0, B:178:0x03b4, B:180:0x03b8, B:182:0x03bc, B:184:0x03c0, B:186:0x03c4, B:133:0x02df, B:135:0x02e3, B:137:0x02e7, B:139:0x02eb, B:141:0x02ef, B:143:0x02f3, B:145:0x02f7, B:147:0x02fb, B:149:0x02ff, B:151:0x0303, B:153:0x0307, B:155:0x030b, B:157:0x030f, B:159:0x0313, B:100:0x0216, B:102:0x021a, B:104:0x021e, B:106:0x0222, B:108:0x0226, B:110:0x022a, B:112:0x022e, B:114:0x0232, B:116:0x0236, B:118:0x023a, B:120:0x023e, B:122:0x0242, B:124:0x0246, B:126:0x024a, B:128:0x024e, B:66:0x013d, B:68:0x0141, B:70:0x0145, B:72:0x0149, B:74:0x014d, B:76:0x0151, B:78:0x0155, B:80:0x0159, B:82:0x015d, B:84:0x0161, B:86:0x0165, B:88:0x0169, B:90:0x016d, B:92:0x0171, B:94:0x0175, B:96:0x017d, B:64:0x00d5] A[DONT_GENERATE, DONT_INLINE]
      0x0822: PHI (r29v19 int) = 
      (r29v0 int)
      (r29v0 int)
      (r29v0 int)
      (r29v1 int)
      (r29v1 int)
      (r29v1 int)
      (r29v1 int)
      (r29v2 int)
      (r29v2 int)
      (r29v2 int)
      (r29v2 int)
      (r29v2 int)
      (r29v3 int)
      (r29v3 int)
      (r29v3 int)
      (r29v3 int)
      (r29v3 int)
      (r29v3 int)
      (r29v4 int)
      (r29v4 int)
      (r29v4 int)
      (r29v4 int)
      (r29v4 int)
      (r29v4 int)
      (r29v4 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v6 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v7 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v8 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v9 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v10 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v11 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v12 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v15 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v17 int)
      (r29v20 int)
     binds: [B:343:0x080f, B:345:0x0813, B:347:0x0817, B:334:0x07d9, B:336:0x07dd, B:338:0x07e1, B:340:0x07e5, B:323:0x0791, B:325:0x0795, B:327:0x0799, B:329:0x079d, B:331:0x07a1, B:310:0x073d, B:312:0x0741, B:314:0x0745, B:316:0x0749, B:318:0x074d, B:320:0x0751, B:295:0x06dc, B:297:0x06e0, B:299:0x06e4, B:301:0x06e8, B:303:0x06ec, B:305:0x06f0, B:307:0x06f4, B:277:0x0669, B:279:0x066d, B:281:0x0671, B:283:0x0675, B:285:0x0679, B:287:0x067d, B:289:0x0681, B:291:0x0685, B:258:0x05ee, B:260:0x05f2, B:262:0x05f6, B:264:0x05fa, B:266:0x05fe, B:268:0x0602, B:270:0x0606, B:272:0x060a, B:274:0x060e, B:237:0x0568, B:239:0x056c, B:241:0x0570, B:243:0x0574, B:245:0x0578, B:247:0x057c, B:249:0x0580, B:251:0x0584, B:253:0x0588, B:255:0x058c, B:214:0x04d7, B:216:0x04db, B:218:0x04df, B:220:0x04e3, B:222:0x04e7, B:224:0x04eb, B:226:0x04ef, B:228:0x04f3, B:230:0x04f7, B:232:0x04fb, B:234:0x04ff, B:189:0x043d, B:191:0x0441, B:193:0x0445, B:195:0x0449, B:197:0x044d, B:199:0x0451, B:201:0x0455, B:203:0x0459, B:205:0x045d, B:207:0x0461, B:209:0x0465, B:211:0x0469, B:162:0x0394, B:164:0x0398, B:166:0x039c, B:168:0x03a0, B:170:0x03a4, B:172:0x03a8, B:174:0x03ac, B:176:0x03b0, B:178:0x03b4, B:180:0x03b8, B:182:0x03bc, B:184:0x03c0, B:186:0x03c4, B:133:0x02df, B:135:0x02e3, B:137:0x02e7, B:139:0x02eb, B:141:0x02ef, B:143:0x02f3, B:145:0x02f7, B:147:0x02fb, B:149:0x02ff, B:151:0x0303, B:153:0x0307, B:155:0x030b, B:157:0x030f, B:159:0x0313, B:100:0x0216, B:102:0x021a, B:104:0x021e, B:106:0x0222, B:108:0x0226, B:110:0x022a, B:112:0x022e, B:114:0x0232, B:116:0x0236, B:118:0x023a, B:120:0x023e, B:122:0x0242, B:124:0x0246, B:126:0x024a, B:128:0x024e, B:66:0x013d, B:68:0x0141, B:70:0x0145, B:72:0x0149, B:74:0x014d, B:76:0x0151, B:78:0x0155, B:80:0x0159, B:82:0x015d, B:84:0x0161, B:86:0x0165, B:88:0x0169, B:90:0x016d, B:92:0x0171, B:94:0x0175, B:96:0x017d, B:64:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:352:0x0829  */
    /* JADX WARN: Found duplicated region for block: B:354:0x082d  */
    /* JADX WARN: Found duplicated region for block: B:356:0x083e A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:358:0x0844  */
    /* JADX WARN: Found duplicated region for block: B:360:0x084e  */
    /* JADX WARN: Found duplicated region for block: B:363:0x0863  */
    /* JADX WARN: Found duplicated region for block: B:365:0x0871  */
    /* JADX WARN: Found duplicated region for block: B:369:0x087a  */
    /* JADX WARN: Found duplicated region for block: B:371:0x0890  */
    /* JADX WARN: Found duplicated region for block: B:373:0x0894  */
    /* JADX WARN: Found duplicated region for block: B:374:0x0899  */
    /* JADX WARN: Found duplicated region for block: B:377:0x08a9  */
    /* JADX WARN: Found duplicated region for block: B:379:0x08af  */
    /* JADX WARN: Found duplicated region for block: B:381:0x08b2  */
    /* JADX WARN: Found duplicated region for block: B:384:0x08be  */
    /* JADX WARN: Found duplicated region for block: B:386:0x08c3  */
    @Override // com.alibaba.fastjson2.JSONReader
    public final String readFieldName() {
        int i;
        char[] cArr;
        int i2;
        char c;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        JSONReaderUTF16 jSONReaderUTF16;
        char[] cArr2;
        int i3;
        int i4;
        JSONFactory.NameCacheEntry[] nameCacheEntryArr;
        int length;
        JSONFactory.NameCacheEntry nameCacheEntry;
        JSONFactory.NameCacheEntry2[] nameCacheEntry2Arr;
        int length2;
        JSONFactory.NameCacheEntry2 nameCacheEntry2;
        String str;
        String str2;
        char c2 = this.ch;
        if (c2 == '\'' && (this.context.features & JSONReader.Feature.DisableSingleQuote.mask) != 0) {
            throw notSupportName();
        }
        if (c2 != '\"' && c2 != '\'') {
            if ((this.context.features & JSONReader.Feature.AllowUnQuotedFieldNames.mask) == 0 || !JSONReader.isFirstIdentifier(c2)) {
                return null;
            }
            return readFieldNameUnquote();
        }
        char[] cArr3 = this.chars;
        this.nameEscape = false;
        int i5 = this.offset;
        this.nameBegin = i5;
        int i6 = this.end;
        int i7 = 0;
        int i8 = i5;
        while (i8 < i6) {
            char c3 = cArr3[i8];
            if (c3 == '\\') {
                this.nameEscape = true;
                char c4 = cArr3[i8 + 1];
                i8 += c4 == 'u' ? 6 : c4 == 'x' ? 4 : 2;
            } else {
                if (c3 == c2) {
                    this.nameLength = i7;
                    this.nameEnd = i8;
                    int i9 = i8 + 1;
                    char c5 = i9 < i6 ? cArr3[i9] : (char) 26;
                    while (c5 <= ' ' && ((1 << c5) & 4294981376L) != 0) {
                        i9++;
                        c5 = cArr3[i9];
                    }
                    if (c5 != ':') {
                        throw new JSONException(bjs.i(i9, "syntax error : "));
                    }
                    i8 = i9 + 1;
                    char c6 = i8 == i6 ? (char) 26 : cArr3[i8];
                    while (c6 <= ' ' && ((1 << c6) & 4294981376L) != 0) {
                        i8++;
                        c6 = cArr3[i8];
                    }
                    this.offset = i8 + 1;
                    this.ch = c6;
                    break;
                }
                i8++;
            }
            i7++;
        }
        int i10 = this.nameEnd;
        if (i10 < i5) {
            throw new JSONException(bjs.i(i8, "syntax error : "));
        }
        if (this.nameEscape) {
            return getFieldName();
        }
        switch (this.nameLength) {
            case 1:
                return TypeUtils.toString(cArr3[i5]);
            case 2:
                return TypeUtils.toString(cArr3[i5], cArr3[i5 + 1]);
            case 3:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c7 = cArr[i2];
                char c8 = cArr[i2 + 1];
                char c9 = cArr[i2 + 2];
                if ((c7 & 255) == c7 && (c8 & 255) == c8 && (c9 & 255) == c9) {
                    j2 = (c9 << 16) + (c8 << '\b') + c7;
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j11 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j11 ^ (j11 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i11 = i2;
                            str2 = new String(cArr, i11, i - i11);
                        }
                        String str3 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str3, j3, j4);
                        return str3;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3 && nameCacheEntry2.value1 == j4) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str4 = jSONReaderUTF16.str;
                        String strSubstring = str4 != null ? str4.substring(i4, i3) : new String(cArr2, i4, i3 - i4);
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str5 = jSONReaderUTF16.str;
                return str5 != null ? str5.substring(i4, i3) : new String(cArr2, i4, i3 - i4);
            case 4:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c10 = cArr[i2];
                char c11 = cArr[i2 + 1];
                char c12 = cArr[i2 + 2];
                char c13 = cArr[i2 + 3];
                if ((c10 & 255) == c10 && (c11 & 255) == c11 && (c12 & 255) == c12 && (c13 & 255) == c13) {
                    j2 = (c13 << 24) + (c12 << 16) + (c11 << '\b') + c10;
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j112 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j112 ^ (j112 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i112 = i2;
                            str2 = new String(cArr, i112, i - i112);
                        }
                        String str32 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str32, j3, j4);
                        return str32;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str42 = jSONReaderUTF16.str;
                        if (str42 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str52 = jSONReaderUTF16.str;
                if (str52 != null) {
                }
            case 5:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c14 = cArr[i2];
                char c15 = cArr[i2 + 1];
                char c16 = cArr[i2 + 2];
                char c17 = cArr[i2 + 3];
                char c18 = cArr[i2 + 4];
                if ((c14 & 255) == c14 && (c15 & 255) == c15 && (c16 & 255) == c16 && (c17 & 255) == c17 && (c18 & 255) == c18) {
                    j2 = (((long) c18) << 32) + (((long) c17) << 24) + (((long) c16) << 16) + (((long) c15) << 8) + ((long) c14);
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j1122 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j1122 ^ (j1122 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i1122 = i2;
                            str2 = new String(cArr, i1122, i - i1122);
                        }
                        String str322 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str322, j3, j4);
                        return str322;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str422 = jSONReaderUTF16.str;
                        if (str422 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str522 = jSONReaderUTF16.str;
                if (str522 != null) {
                }
            case 6:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c19 = cArr[i2];
                char c20 = cArr[i2 + 1];
                char c21 = cArr[i2 + 2];
                char c22 = cArr[i2 + 3];
                char c23 = cArr[i2 + 4];
                char c24 = cArr[i2 + 5];
                if ((c19 & 255) == c19 && (c20 & 255) == c20 && (c21 & 255) == c21 && (c22 & 255) == c22 && (c23 & 255) == c23 && (c24 & 255) == c24) {
                    j2 = (((long) c24) << 40) + (((long) c23) << 32) + (((long) c22) << 24) + (((long) c21) << 16) + (((long) c20) << 8) + ((long) c19);
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j11222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j11222 ^ (j11222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i11222 = i2;
                            str2 = new String(cArr, i11222, i - i11222);
                        }
                        String str3222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str3222, j3, j4);
                        return str3222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str4222 = jSONReaderUTF16.str;
                        if (str4222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str5222 = jSONReaderUTF16.str;
                if (str5222 != null) {
                }
            case 7:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c25 = cArr[i2];
                char c26 = cArr[i2 + 1];
                char c27 = cArr[i2 + 2];
                char c28 = cArr[i2 + 3];
                char c29 = cArr[i2 + 4];
                char c30 = cArr[i2 + 5];
                char c31 = cArr[i2 + 6];
                if ((c25 & 255) == c25 && (c26 & 255) == c26 && (c27 & 255) == c27 && (c28 & 255) == c28 && (c29 & 255) == c29 && (c30 & 255) == c30 && (c31 & 255) == c31) {
                    j2 = (((long) c31) << 48) + (((long) c30) << 40) + (((long) c29) << 32) + (((long) c28) << 24) + (((long) c27) << 16) + (((long) c26) << 8) + ((long) c25);
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j112222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j112222 ^ (j112222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i112222 = i2;
                            str2 = new String(cArr, i112222, i - i112222);
                        }
                        String str32222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str32222, j3, j4);
                        return str32222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str42222 = jSONReaderUTF16.str;
                        if (str42222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str52222 = jSONReaderUTF16.str;
                if (str52222 != null) {
                }
            case 8:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c32 = cArr[i2];
                char c33 = cArr[i2 + 1];
                char c34 = cArr[i2 + 2];
                char c35 = cArr[i2 + 3];
                char c36 = cArr[i2 + 4];
                char c37 = cArr[i2 + 5];
                char c38 = cArr[i2 + 6];
                char c39 = cArr[i2 + 7];
                if ((c32 & 255) == c32 && (c33 & 255) == c33 && (c34 & 255) == c34 && (c35 & 255) == c35 && (c36 & 255) == c36 && (c37 & 255) == c37 && (c38 & 255) == c38 && (c39 & 255) == c39) {
                    j2 = (((long) c39) << 56) + (((long) c38) << 48) + (((long) c37) << 40) + (((long) c36) << 32) + (((long) c35) << 24) + (((long) c34) << 16) + (((long) c33) << 8) + ((long) c32);
                    j3 = j2;
                    j4 = j;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j1122222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j1122222 ^ (j1122222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i1122222 = i2;
                            str2 = new String(cArr, i1122222, i - i1122222);
                        }
                        String str322222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str322222, j3, j4);
                        return str322222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str422222 = jSONReaderUTF16.str;
                        if (str422222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str522222 = jSONReaderUTF16.str;
                if (str522222 != null) {
                }
            case 9:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c40 = cArr[i2];
                char c41 = cArr[i2 + 1];
                char c42 = cArr[i2 + 2];
                char c43 = cArr[i2 + 3];
                char c44 = cArr[i2 + 4];
                char c45 = cArr[i2 + 5];
                char c46 = cArr[i2 + 6];
                char c47 = cArr[i2 + 7];
                char c48 = cArr[i2 + 8];
                if ((c40 & 255) == c40 && (c41 & 255) == c41 && (c42 & 255) == c42 && (c43 & 255) == c43 && (c44 & 255) == c44 && (c45 & 255) == c45 && (c46 & 255) == c46 && (c47 & 255) == c47 && (c48 & 255) == c48) {
                    j5 = c40;
                    j6 = (((long) c48) << 56) + (((long) c47) << 48) + (((long) c46) << 40) + (((long) c45) << 32) + (((long) c44) << 24) + (((long) c43) << 16) + (((long) c42) << 8) + ((long) c41);
                    j4 = j6;
                    j3 = j5;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j11222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j11222222 ^ (j11222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i11222222 = i2;
                            str2 = new String(cArr, i11222222, i - i11222222);
                        }
                        String str3222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str3222222, j3, j4);
                        return str3222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str4222222 = jSONReaderUTF16.str;
                        if (str4222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str5222222 = jSONReaderUTF16.str;
                if (str5222222 != null) {
                }
            case 10:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c49 = cArr[i2];
                char c50 = cArr[i2 + 1];
                char c51 = cArr[i2 + 2];
                char c52 = cArr[i2 + 3];
                char c53 = cArr[i2 + 4];
                char c54 = cArr[i2 + 5];
                char c55 = cArr[i2 + 6];
                char c56 = cArr[i2 + 7];
                char c57 = cArr[i2 + 8];
                char c58 = cArr[i2 + 9];
                if ((c49 & 255) == c49 && (c50 & 255) == c50 && (c51 & 255) == c51 && (c52 & 255) == c52 && (c53 & 255) == c53 && (c54 & 255) == c54 && (c55 & 255) == c55 && (c56 & 255) == c56 && (c57 & 255) == c57 && (c58 & 255) == c58) {
                    j5 = (c50 << '\b') + c49;
                    j6 = (((long) c58) << 56) + (((long) c57) << 48) + (((long) c56) << 40) + (((long) c55) << 32) + (((long) c54) << 24) + (((long) c53) << 16) + (((long) c52) << 8) + ((long) c51);
                    j4 = j6;
                    j3 = j5;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j112222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j112222222 ^ (j112222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i112222222 = i2;
                            str2 = new String(cArr, i112222222, i - i112222222);
                        }
                        String str32222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str32222222, j3, j4);
                        return str32222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str42222222 = jSONReaderUTF16.str;
                        if (str42222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str52222222 = jSONReaderUTF16.str;
                if (str52222222 != null) {
                }
            case 11:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c59 = cArr[i2];
                char c60 = cArr[i2 + 1];
                char c61 = cArr[i2 + 2];
                char c62 = cArr[i2 + 3];
                char c63 = cArr[i2 + 4];
                char c64 = cArr[i2 + 5];
                char c65 = cArr[i2 + 6];
                char c66 = cArr[i2 + 7];
                char c67 = cArr[i2 + 8];
                char c68 = cArr[i2 + 9];
                char c69 = cArr[i2 + 10];
                if ((c59 & 255) == c59 && (c60 & 255) == c60 && (c61 & 255) == c61 && (c62 & 255) == c62 && (c63 & 255) == c63 && (c64 & 255) == c64 && (c65 & 255) == c65 && (c66 & 255) == c66 && (c67 & 255) == c67 && (c68 & 255) == c68 && (c69 & 255) == c69) {
                    j7 = (c61 << 16) + (c60 << '\b') + c59;
                    j8 = (((long) c69) << 56) + (((long) c68) << 48) + (((long) c67) << 40) + (((long) c66) << 32) + (((long) c65) << 24) + (((long) c64) << 16) + (((long) c63) << 8) + ((long) c62);
                    j4 = j8;
                    j3 = j7;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j1122222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j1122222222 ^ (j1122222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i1122222222 = i2;
                            str2 = new String(cArr, i1122222222, i - i1122222222);
                        }
                        String str322222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str322222222, j3, j4);
                        return str322222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str422222222 = jSONReaderUTF16.str;
                        if (str422222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str522222222 = jSONReaderUTF16.str;
                if (str522222222 != null) {
                }
            case 12:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c70 = cArr[i2];
                char c71 = cArr[i2 + 1];
                char c72 = cArr[i2 + 2];
                char c73 = cArr[i2 + 3];
                char c74 = cArr[i2 + 4];
                char c75 = cArr[i2 + 5];
                char c76 = cArr[i2 + 6];
                char c77 = cArr[i2 + 7];
                char c78 = cArr[i2 + 8];
                char c79 = cArr[i2 + 9];
                char c80 = cArr[i2 + 10];
                char c81 = cArr[i2 + 11];
                if ((c70 & 255) == c70 && (c71 & 255) == c71 && (c72 & 255) == c72 && (c73 & 255) == c73 && (c74 & 255) == c74 && (c75 & 255) == c75 && (c76 & 255) == c76 && (c77 & 255) == c77 && (c78 & 255) == c78 && (c79 & 255) == c79 && (c80 & 255) == c80 && (c81 & 255) == c81) {
                    j7 = (c73 << 24) + (c72 << 16) + (c71 << '\b') + c70;
                    j9 = (((long) c81) << 56) + (((long) c80) << 48) + (((long) c79) << 40) + (((long) c78) << 32) + (((long) c77) << 24) + (((long) c76) << 16) + (((long) c75) << 8);
                    j10 = c74;
                    j8 = j9 + j10;
                    j4 = j8;
                    j3 = j7;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j11222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j11222222222 ^ (j11222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i11222222222 = i2;
                            str2 = new String(cArr, i11222222222, i - i11222222222);
                        }
                        String str3222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str3222222222, j3, j4);
                        return str3222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str4222222222 = jSONReaderUTF16.str;
                        if (str4222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str5222222222 = jSONReaderUTF16.str;
                if (str5222222222 != null) {
                }
            case 13:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c82 = cArr[i2];
                char c83 = cArr[i2 + 1];
                char c84 = cArr[i2 + 2];
                char c85 = cArr[i2 + 3];
                char c86 = cArr[i2 + 4];
                char c87 = cArr[i2 + 5];
                char c88 = cArr[i2 + 6];
                char c89 = cArr[i2 + 7];
                char c90 = cArr[i2 + 8];
                char c91 = cArr[i2 + 9];
                char c92 = cArr[i2 + 10];
                char c93 = cArr[i2 + 11];
                char c94 = cArr[i2 + 12];
                if ((c82 & 255) == c82 && (c83 & 255) == c83 && (c84 & 255) == c84 && (c85 & 255) == c85 && (c86 & 255) == c86 && (c87 & 255) == c87 && (c88 & 255) == c88 && (c89 & 255) == c89 && (c90 & 255) == c90 && (c91 & 255) == c91 && (c92 & 255) == c92 && (c93 & 255) == c93 && (c94 & 255) == c94) {
                    j7 = ((long) c82) + (((long) c86) << 32) + (((long) c85) << 24) + (((long) c84) << 16) + (((long) c83) << 8);
                    j9 = (((long) c94) << 56) + (((long) c93) << 48) + (((long) c92) << 40) + (((long) c91) << 32) + (((long) c90) << 24) + (((long) c89) << 16) + (((long) c88) << 8);
                    j10 = c87;
                    j8 = j9 + j10;
                    j4 = j8;
                    j3 = j7;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j112222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j112222222222 ^ (j112222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i112222222222 = i2;
                            str2 = new String(cArr, i112222222222, i - i112222222222);
                        }
                        String str32222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str32222222222, j3, j4);
                        return str32222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str42222222222 = jSONReaderUTF16.str;
                        if (str42222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str52222222222 = jSONReaderUTF16.str;
                if (str52222222222 != null) {
                }
            case 14:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c95 = cArr[i2];
                char c96 = cArr[i2 + 1];
                char c97 = cArr[i2 + 2];
                char c98 = cArr[i2 + 3];
                char c99 = cArr[i2 + 4];
                char c100 = cArr[i2 + 5];
                char c101 = cArr[i2 + 6];
                char c102 = cArr[i2 + 7];
                char c103 = cArr[i2 + 8];
                char c104 = cArr[i2 + 9];
                char c105 = cArr[i2 + 10];
                char c106 = cArr[i2 + 11];
                char c107 = cArr[i2 + 12];
                char c108 = cArr[i2 + 13];
                if ((c95 & 255) == c95 && (c96 & 255) == c96 && (c97 & 255) == c97 && (c98 & 255) == c98 && (c99 & 255) == c99 && (c100 & 255) == c100 && (c101 & 255) == c101 && (c102 & 255) == c102 && (c103 & 255) == c103 && (c104 & 255) == c104 && (c105 & 255) == c105 && (c106 & 255) == c106 && (c107 & 255) == c107 && (c108 & 255) == c108) {
                    j7 = ((long) c95) + (((long) c100) << 40) + (((long) c99) << 32) + (((long) c98) << 24) + (((long) c97) << 16) + (((long) c96) << 8);
                    j9 = (((long) c108) << 56) + (((long) c107) << 48) + (((long) c106) << 40) + (((long) c105) << 32) + (((long) c104) << 24) + (((long) c103) << 16) + (((long) c102) << 8);
                    j10 = c101;
                    j8 = j9 + j10;
                    j4 = j8;
                    j3 = j7;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j1122222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j1122222222222 ^ (j1122222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i1122222222222 = i2;
                            str2 = new String(cArr, i1122222222222, i - i1122222222222);
                        }
                        String str322222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str322222222222, j3, j4);
                        return str322222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str422222222222 = jSONReaderUTF16.str;
                        if (str422222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str522222222222 = jSONReaderUTF16.str;
                if (str522222222222 != null) {
                }
            case 15:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                char c109 = cArr[i2];
                char c110 = cArr[i2 + 1];
                char c111 = cArr[i2 + 2];
                char c112 = cArr[i2 + 3];
                char c113 = cArr[i2 + 4];
                char c114 = cArr[i2 + 5];
                char c115 = cArr[i2 + 6];
                char c116 = cArr[i2 + 7];
                char c117 = cArr[i2 + 8];
                char c118 = cArr[i2 + 9];
                char c119 = cArr[i2 + 10];
                char c120 = cArr[i2 + 11];
                char c121 = cArr[i2 + 12];
                char c122 = cArr[i2 + 13];
                char c123 = cArr[i2 + 14];
                if ((c109 & 255) == c109 && (c110 & 255) == c110 && (c111 & 255) == c111 && (c112 & 255) == c112 && (c113 & 255) == c113 && (c114 & 255) == c114 && (c115 & 255) == c115 && (c116 & 255) == c116 && (c117 & 255) == c117 && (c118 & 255) == c118 && (c119 & 255) == c119 && (c120 & 255) == c120 && (c121 & 255) == c121 && (c122 & 255) == c122 && (c123 & 255) == c123) {
                    j7 = ((long) c109) + (((long) c115) << 48) + (((long) c114) << 40) + (((long) c113) << 32) + (((long) c112) << 24) + (((long) c111) << 16) + (((long) c110) << 8);
                    j9 = (((long) c123) << 56) + (((long) c122) << 48) + (((long) c121) << 40) + (((long) c120) << 32) + (((long) c119) << 24) + (((long) c118) << 16) + (((long) c117) << 8);
                    j10 = c116;
                    j8 = j9 + j10;
                    j4 = j8;
                    j3 = j7;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j11222222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j11222222222222 ^ (j11222222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i11222222222222 = i2;
                            str2 = new String(cArr, i11222222222222, i - i11222222222222);
                        }
                        String str3222222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str3222222222222, j3, j4);
                        return str3222222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str4222222222222 = jSONReaderUTF16.str;
                        if (str4222222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str5222222222222 = jSONReaderUTF16.str;
                if (str5222222222222 != null) {
                }
            case 16:
                char c124 = cArr3[i5];
                char c125 = cArr3[i5 + 1];
                char c126 = cArr3[i5 + 2];
                j = -1;
                char c127 = cArr3[i5 + 3];
                char c128 = cArr3[i5 + 4];
                char c129 = cArr3[i5 + 5];
                c = ' ';
                char c130 = cArr3[i5 + 6];
                char c131 = cArr3[i5 + 7];
                char c132 = cArr3[i5 + 8];
                char c133 = cArr3[i5 + 9];
                char c134 = cArr3[i5 + 10];
                char c135 = cArr3[i5 + 11];
                cArr = cArr3;
                char c136 = cArr[i5 + 12];
                i = i10;
                char c137 = cArr[i5 + 13];
                i2 = i5;
                char c138 = cArr[i5 + 14];
                char c139 = cArr[i2 + 15];
                if ((c124 & 255) == c124 && (c125 & 255) == c125 && (c126 & 255) == c126 && (c127 & 255) == c127 && (c128 & 255) == c128 && (c129 & 255) == c129 && (c130 & 255) == c130 && (c131 & 255) == c131 && (c132 & 255) == c132 && (c133 & 255) == c133 && (c134 & 255) == c134 && (c135 & 255) == c135 && (c136 & 255) == c136 && (c137 & 255) == c137 && (c138 & 255) == c138 && (c139 & 255) == c139) {
                    j5 = (((long) c131) << 56) + (((long) c130) << 48) + (((long) c129) << 40) + (((long) c128) << 32) + (((long) c127) << 24) + (((long) c126) << 16) + (((long) c125) << 8) + ((long) c124);
                    j6 = (((long) c139) << 56) + (((long) c138) << 48) + (((long) c137) << 40) + (((long) c136) << 32) + (((long) c135) << 24) + (((long) c134) << 16) + (((long) c133) << 8) + ((long) c132);
                    j4 = j6;
                    j3 = j5;
                } else {
                    j3 = j;
                    j4 = j3;
                }
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j112222222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j112222222222222 ^ (j112222222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i112222222222222 = i2;
                            str2 = new String(cArr, i112222222222222, i - i112222222222222);
                        }
                        String str32222222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str32222222222222, j3, j4);
                        return str32222222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str42222222222222 = jSONReaderUTF16.str;
                        if (str42222222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str52222222222222 = jSONReaderUTF16.str;
                if (str52222222222222 != null) {
                }
            default:
                i = i10;
                cArr = cArr3;
                i2 = i5;
                c = ' ';
                j = -1;
                j3 = j;
                j4 = j3;
                if (j3 == j) {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                } else if (j4 != j) {
                    long j1122222222222222 = j3 ^ j4;
                    nameCacheEntry2Arr = JSONFactory.NAME_CACHE2;
                    length2 = ((int) (j1122222222222222 ^ (j1122222222222222 >>> c))) & (nameCacheEntry2Arr.length - 1);
                    nameCacheEntry2 = nameCacheEntry2Arr[length2];
                    if (nameCacheEntry2 == null) {
                        str = this.str;
                        if (str != null) {
                            str2 = str.substring(i2, i);
                        } else {
                            int i1122222222222222 = i2;
                            str2 = new String(cArr, i1122222222222222, i - i1122222222222222);
                        }
                        String str322222222222222 = str2;
                        nameCacheEntry2Arr[length2] = new JSONFactory.NameCacheEntry2(str322222222222222, j3, j4);
                        return str322222222222222;
                    }
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    if (nameCacheEntry2.value0 == j3) {
                        return nameCacheEntry2.name;
                    }
                } else {
                    jSONReaderUTF16 = this;
                    cArr2 = cArr;
                    i3 = i;
                    i4 = i2;
                    nameCacheEntryArr = JSONFactory.NAME_CACHE;
                    length = ((int) ((j3 >>> c) ^ j3)) & (nameCacheEntryArr.length - 1);
                    nameCacheEntry = nameCacheEntryArr[length];
                    if (nameCacheEntry == null) {
                        String str422222222222222 = jSONReaderUTF16.str;
                        if (str422222222222222 != null) {
                        }
                        nameCacheEntryArr[length] = new JSONFactory.NameCacheEntry(strSubstring, j3);
                        return strSubstring;
                    }
                    if (nameCacheEntry.value == j3) {
                        return nameCacheEntry.name;
                    }
                }
                String str522222222222222 = jSONReaderUTF16.str;
                if (str522222222222222 != null) {
                }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:159:0x029e  */
    /* JADX WARN: Found duplicated region for block: B:161:0x02a3  */
    /* JADX WARN: Found duplicated region for block: B:164:0x02a9  */
    /* JADX WARN: Found duplicated region for block: B:166:0x02af  */
    /* JADX WARN: Found duplicated region for block: B:167:0x02b6  */
    /* JADX WARN: Found duplicated region for block: B:169:0x02ba  */
    /* JADX WARN: Found duplicated region for block: B:171:0x02c3 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:172:0x02c5 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:173:0x02cc A[PHI: r6 r9
      0x02cc: PHI (r6v28 int) = (r6v24 int), (r6v33 int), (r6v35 int) binds: [B:168:0x02b8, B:175:0x02d1, B:172:0x02c5] A[DONT_GENERATE, DONT_INLINE]
      0x02cc: PHI (r9v14 char) = (r9v13 char), (r9v33 char), (r9v34 char) binds: [B:168:0x02b8, B:175:0x02d1, B:172:0x02c5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:175:0x02d1  */
    /* JADX WARN: Found duplicated region for block: B:176:0x02de  */
    /* JADX WARN: Found duplicated region for block: B:197:0x035a  */
    /* JADX WARN: Found duplicated region for block: B:201:0x0363  */
    /* JADX WARN: Found duplicated region for block: B:204:0x0370  */
    /* JADX WARN: Found duplicated region for block: B:206:0x0379 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:207:0x037b  */
    /* JADX WARN: Found duplicated region for block: B:209:0x0382  */
    /* JADX WARN: Found duplicated region for block: B:211:0x0394  */
    /* JADX WARN: Found duplicated region for block: B:213:0x03b1  */
    /* JADX WARN: Found duplicated region for block: B:218:0x03bf  */
    /* JADX WARN: Found duplicated region for block: B:219:0x03c2  */
    /* JADX WARN: Found duplicated region for block: B:225:0x03d9  */
    /* JADX WARN: Found duplicated region for block: B:226:0x03db A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:230:0x03eb A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:231:0x03ed  */
    /* JADX WARN: Found duplicated region for block: B:232:0x03f0  */
    /* JADX WARN: Found duplicated region for block: B:242:0x0418  */
    /* JADX WARN: Found duplicated region for block: B:244:0x0430  */
    /* JADX WARN: Found duplicated region for block: B:246:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:247:0x02a7 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:251:0x03b5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:260:0x0409 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:261:0x0407 A[SYNTHETIC] */
    @Override // com.alibaba.fastjson2.JSONReader
    public final long readFieldNameHashCode() {
        char[] cArr;
        int i;
        int i2;
        char c;
        char c2;
        char c3;
        char c4;
        int i3;
        long j;
        char[] cArr2;
        int i4;
        int i5;
        char c5;
        char c6;
        int i6;
        char c7;
        int i7;
        int i8;
        char c8;
        char c9;
        char c10;
        char cHexDigit4;
        int i9;
        char cChar1;
        int i10;
        char cHexDigit42;
        long j2;
        long j3;
        int i11;
        char c11;
        char c12;
        char[] cArr3 = this.chars;
        char c13 = this.ch;
        if (c13 == '/') {
            skipComment();
            c13 = this.ch;
        }
        if (c13 == '\'' && (this.context.features & JSONReader.Feature.DisableSingleQuote.mask) != 0) {
            throw notSupportName();
        }
        if (c13 != '\"' && c13 != '\'') {
            if ((this.context.features & JSONReader.Feature.AllowUnQuotedFieldNames.mask) != 0 && JSONReader.isFirstIdentifier(c13)) {
                return readFieldNameHashCodeUnquote();
            }
            if (c13 == '}' || isNull()) {
                return -1L;
            }
            throw new JSONException(info((c13 != '[' || this.nameBegin <= 0) ? "illegal fieldName input" + c13 : "illegal fieldName input " + c13 + ", previous fieldName " + getFieldName()));
        }
        this.stringValue = null;
        this.nameEscape = false;
        int i12 = this.offset;
        this.nameBegin = i12;
        int i13 = this.end;
        int i14 = i12 + 9;
        if (i14 < i13) {
            c = '8';
            char c14 = cArr3[i12];
            c2 = '0';
            int i15 = i12 + 1;
            c3 = '(';
            char c15 = cArr3[i15];
            int i16 = i12 + 2;
            char c16 = cArr3[i16];
            c4 = ' ';
            int i17 = i12 + 3;
            char c17 = cArr3[i17];
            int i18 = i12 + 4;
            char c18 = cArr3[i18];
            int i19 = i12 + 5;
            i = i12;
            char c19 = cArr3[i19];
            int i20 = i + 6;
            cArr = cArr3;
            char c20 = cArr[i20];
            i2 = i13;
            int i21 = i + 7;
            char c21 = cArr[i21];
            int i22 = i + 8;
            char c22 = cArr[i22];
            if (c14 != c13) {
                if (c15 != c13 || c14 == 0) {
                    c12 = c22;
                } else {
                    c12 = c22;
                    if (c14 != '\\' && c14 <= 255) {
                        j = (byte) c14;
                        this.nameLength = 1;
                        this.nameEnd = i15;
                        i3 = i16;
                    }
                }
                if (c16 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c14 <= 255 && c15 <= 255) {
                    j = (((byte) c15) << 8) + c14;
                    this.nameLength = 2;
                    this.nameEnd = i16;
                    i3 = i17;
                } else if (c17 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255) {
                    this.nameLength = 3;
                    this.nameEnd = i17;
                    i3 = i18;
                    j = (((byte) c16) << 16) + (c15 << '\b') + c14;
                } else if (c18 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c17 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255 && c17 <= 255) {
                    this.nameLength = 4;
                    this.nameEnd = i18;
                    j = (((byte) c17) << 24) + (c16 << 16) + (c15 << '\b') + c14;
                    i3 = i19;
                } else if (c19 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c17 != '\\' && c18 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255 && c17 <= 255 && c18 <= 255) {
                    j = (((long) ((byte) c18)) << 32) + (((long) c17) << 24) + (((long) c16) << 16) + (((long) c15) << 8) + ((long) c14);
                    this.nameLength = 5;
                    this.nameEnd = i19;
                    i3 = i20;
                } else if (c20 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c17 != '\\' && c18 != '\\' && c19 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255 && c17 <= 255 && c18 <= 255 && c19 <= 255) {
                    j = ((long) c14) + (((long) ((byte) c19)) << 40) + (((long) c18) << 32) + (((long) c17) << 24) + (((long) c16) << 16) + (((long) c15) << 8);
                    this.nameLength = 6;
                    this.nameEnd = i20;
                    i3 = i21;
                } else if (c21 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c17 != '\\' && c18 != '\\' && c19 != '\\' && c20 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255 && c17 <= 255 && c18 <= 255 && c19 <= 255 && c20 <= 255) {
                    j = ((long) c14) + (((long) ((byte) c20)) << 48) + (((long) c19) << 40) + (((long) c18) << 32) + (((long) c17) << 24) + (((long) c16) << 16) + (((long) c15) << 8);
                    this.nameLength = 7;
                    this.nameEnd = i21;
                    i3 = i22;
                } else if (c12 == c13 && c14 != 0 && c14 != '\\' && c15 != '\\' && c16 != '\\' && c17 != '\\' && c18 != '\\' && c19 != '\\' && c20 != '\\' && c21 != '\\' && c14 <= 255 && c15 <= 255 && c16 <= 255 && c17 <= 255 && c18 <= 255 && c19 <= 255 && c20 <= 255 && c21 <= 255) {
                    j = ((long) c14) + (((long) ((byte) c21)) << 56) + (((long) c20) << 48) + (((long) c19) << 40) + (((long) c18) << 32) + (((long) c17) << 24) + (((long) c16) << 16) + (((long) c15) << 8);
                    this.nameLength = 8;
                    this.nameEnd = i22;
                    i3 = i14;
                }
            }
            if (j == 0) {
                i4 = i2;
                i10 = 0;
                while (true) {
                    if (i3 >= i4) {
                        cHexDigit42 = cArr[i3];
                        if (cHexDigit42 == c13) {
                            if (cHexDigit42 == '\\') {
                                this.nameEscape = true;
                                i11 = i3 + 1;
                                c11 = cArr[i11];
                                if (c11 != 'u') {
                                    if (c11 != 'x') {
                                        cHexDigit42 = char1(c11);
                                        i3 = i11;
                                    } else {
                                        char c23 = cArr[i3 + 2];
                                        i3 += 3;
                                        cHexDigit42 = JSONReader.char2(c23, cArr[i3]);
                                    }
                                    cArr2 = cArr;
                                } else {
                                    cArr2 = cArr;
                                    cHexDigit42 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i3 + 2, i4));
                                    i3 += 5;
                                }
                            } else {
                                cArr2 = cArr;
                            }
                            if (cHexDigit42 <= 255 || i10 >= 8 || (i10 == 0 && cHexDigit42 == 0)) {
                                i3 = this.nameBegin;
                                j = 0;
                            } else {
                                switch (i10) {
                                    case 0:
                                        j = (byte) cHexDigit42;
                                        break;
                                    case 1:
                                        j = ((long) (((byte) cHexDigit42) << 8)) + (j & 255);
                                        break;
                                    case 2:
                                        j2 = ((byte) cHexDigit42) << 16;
                                        j3 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                                        j = j2 + (j & j3);
                                        break;
                                    case 3:
                                        j2 = ((byte) cHexDigit42) << 24;
                                        j3 = 16777215;
                                        j = j2 + (j & j3);
                                        break;
                                    case 4:
                                        j2 = ((long) ((byte) cHexDigit42)) << c4;
                                        j3 = 4294967295L;
                                        j = j2 + (j & j3);
                                        break;
                                    case 5:
                                        j2 = ((long) ((byte) cHexDigit42)) << c3;
                                        j3 = 1099511627775L;
                                        j = j2 + (j & j3);
                                        break;
                                    case 6:
                                        j2 = ((long) ((byte) cHexDigit42)) << c2;
                                        j3 = 281474976710655L;
                                        j = j2 + (j & j3);
                                        break;
                                    case 7:
                                        j2 = ((long) ((byte) cHexDigit42)) << c;
                                        j3 = 72057594037927935L;
                                        j = j2 + (j & j3);
                                        break;
                                    default:
                                        break;
                                }
                                i3++;
                                i10++;
                                cArr = cArr2;
                            }
                        } else if (i10 == 0) {
                            i3 = this.nameBegin;
                        } else {
                            this.nameLength = i10;
                            this.nameEnd = i3;
                            i3++;
                        }
                    }
                    cArr2 = cArr;
                }
            } else {
                cArr2 = cArr;
                i4 = i2;
            }
            if (j == 0) {
                j = Fnv.MAGIC_HASH_CODE;
                i7 = i3;
                i8 = 0;
                while (true) {
                    c8 = cArr2[i7];
                    if (c8 == '\\') {
                        this.nameEscape = true;
                        int i23 = i7 + 1;
                        c10 = cArr2[i23];
                        if (c10 != 'u') {
                            if (c10 != 'x') {
                                cChar1 = char1(c10);
                            } else {
                                char c24 = cArr2[i7 + 2];
                                i9 = i7 + 3;
                                cHexDigit4 = JSONReader.char2(c24, cArr2[i9]);
                            }
                            j = (j ^ ((long) cChar1)) * Fnv.MAGIC_PRIME;
                            i7 = i23 + 1;
                            c9 = c4;
                        } else {
                            cHexDigit4 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i7 + 2, i4));
                            i9 = i7 + 5;
                        }
                        char c25 = cHexDigit4;
                        i23 = i9;
                        cChar1 = c25;
                        j = (j ^ ((long) cChar1)) * Fnv.MAGIC_PRIME;
                        i7 = i23 + 1;
                        c9 = c4;
                    } else if (c8 == c13) {
                        this.nameLength = i8;
                        this.nameEnd = i7;
                        i3 = i7 + 1;
                    } else {
                        c9 = c4;
                        i7++;
                        j = (j ^ ((long) c8)) * Fnv.MAGIC_PRIME;
                    }
                    i8++;
                    c4 = c9;
                }
            }
            if (i3 == i4) {
                i5 = i3;
                c5 = 26;
            } else {
                i5 = i3 + 1;
                c5 = cArr2[i3];
            }
            for (c6 = c4; c5 <= c6 && ((1 << c5) & 4294981376L) != 0; c6 = ' ') {
                if (i5 == i4) {
                    c5 = 26;
                } else {
                    c5 = cArr2[i5];
                    i5++;
                }
            }
            if (c5 == ':') {
                throw new JSONException(info("expect ':', but " + c5));
            }
            if (i5 == i4) {
                i6 = i5;
                c7 = 26;
            } else {
                i6 = i5 + 1;
                c7 = cArr2[i5];
            }
            while (c7 <= ' ' && ((1 << c7) & 4294981376L) != 0) {
                if (i6 == i4) {
                    c7 = 26;
                } else {
                    int i24 = i6 + 1;
                    char c26 = cArr2[i6];
                    i6 = i24;
                    c7 = c26;
                }
            }
            this.offset = i6;
            this.ch = c7;
            return j;
        }
        cArr = cArr3;
        i = i12;
        i2 = i13;
        c = '8';
        c2 = '0';
        c3 = '(';
        c4 = ' ';
        j = 0;
        i3 = i;
        if (j == 0) {
            i4 = i2;
            i10 = 0;
            while (true) {
                if (i3 >= i4) {
                    cHexDigit42 = cArr[i3];
                    if (cHexDigit42 == c13) {
                        if (cHexDigit42 == '\\') {
                            this.nameEscape = true;
                            i11 = i3 + 1;
                            c11 = cArr[i11];
                            if (c11 != 'u') {
                                if (c11 != 'x') {
                                    cHexDigit42 = char1(c11);
                                    i3 = i11;
                                } else {
                                    char c232 = cArr[i3 + 2];
                                    i3 += 3;
                                    cHexDigit42 = JSONReader.char2(c232, cArr[i3]);
                                }
                                cArr2 = cArr;
                            } else {
                                cArr2 = cArr;
                                cHexDigit42 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i3 + 2, i4));
                                i3 += 5;
                            }
                        } else {
                            cArr2 = cArr;
                        }
                        if (cHexDigit42 <= 255) {
                        }
                        i3 = this.nameBegin;
                        j = 0;
                    } else if (i10 == 0) {
                        i3 = this.nameBegin;
                    } else {
                        this.nameLength = i10;
                        this.nameEnd = i3;
                        i3++;
                    }
                }
                cArr2 = cArr;
                i3++;
                i10++;
                cArr = cArr2;
            }
        } else {
            cArr2 = cArr;
            i4 = i2;
        }
        if (j == 0) {
            j = Fnv.MAGIC_HASH_CODE;
            i7 = i3;
            i8 = 0;
            while (true) {
                c8 = cArr2[i7];
                if (c8 == '\\') {
                    this.nameEscape = true;
                    int i232 = i7 + 1;
                    c10 = cArr2[i232];
                    if (c10 != 'u') {
                        if (c10 != 'x') {
                            cChar1 = char1(c10);
                        } else {
                            char c242 = cArr2[i7 + 2];
                            i9 = i7 + 3;
                            cHexDigit4 = JSONReader.char2(c242, cArr2[i9]);
                        }
                        j = (j ^ ((long) cChar1)) * Fnv.MAGIC_PRIME;
                        i7 = i232 + 1;
                        c9 = c4;
                    } else {
                        cHexDigit4 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i7 + 2, i4));
                        i9 = i7 + 5;
                    }
                    char c252 = cHexDigit4;
                    i232 = i9;
                    cChar1 = c252;
                    j = (j ^ ((long) cChar1)) * Fnv.MAGIC_PRIME;
                    i7 = i232 + 1;
                    c9 = c4;
                } else if (c8 == c13) {
                    this.nameLength = i8;
                    this.nameEnd = i7;
                    i3 = i7 + 1;
                } else {
                    c9 = c4;
                    i7++;
                    j = (j ^ ((long) c8)) * Fnv.MAGIC_PRIME;
                }
                i8++;
                c4 = c9;
            }
        }
        if (i3 == i4) {
            i5 = i3;
            c5 = 26;
        } else {
            i5 = i3 + 1;
            c5 = cArr2[i3];
        }
        while (c5 <= c6) {
            if (i5 == i4) {
                c5 = 26;
            } else {
                c5 = cArr2[i5];
                i5++;
            }
        }
        if (c5 == ':') {
            throw new JSONException(info("expect ':', but " + c5));
        }
        if (i5 == i4) {
            i6 = i5;
            c7 = 26;
        } else {
            i6 = i5 + 1;
            c7 = cArr2[i5];
        }
        while (c7 <= ' ') {
            if (i6 == i4) {
                c7 = 26;
            } else {
                int i242 = i6 + 1;
                char c262 = cArr2[i6];
                i6 = i242;
                c7 = c262;
            }
        }
        this.offset = i6;
        this.ch = c7;
        return j;
    }

    /* JADX WARN: Found duplicated region for block: B:109:0x01a7  */
    /* JADX WARN: Found duplicated region for block: B:110:0x01aa  */
    /* JADX WARN: Found duplicated region for block: B:112:0x01b6  */
    /* JADX WARN: Found duplicated region for block: B:141:0x020a  */
    /* JADX WARN: Found duplicated region for block: B:142:0x020c  */
    /* JADX WARN: Found duplicated region for block: B:153:0x022d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:154:0x022f  */
    /* JADX WARN: Found duplicated region for block: B:155:0x0232  */
    /* JADX WARN: Found duplicated region for block: B:202:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:203:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:42:0x00a0  */
    /* JADX WARN: Found duplicated region for block: B:42:0x00a0 A[FALL_THROUGH] */
    /* JADX WARN: Found duplicated region for block: B:82:0x0134  */
    /* JADX WARN: Found duplicated region for block: B:84:0x0141  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:158:0x023a
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final long readFieldNameHashCodeUnquote() {
        /*
            Method dump skipped, instruction units count: 746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readFieldNameHashCodeUnquote():long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x0209, code lost:
    
        r14 = -r11;
     */
    /* JADX WARN: Found duplicated region for block: B:154:0x01d6 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Found duplicated region for block: B:157:0x01de  */
    /* JADX WARN: Found duplicated region for block: B:160:0x01e8  */
    /* JADX WARN: Found duplicated region for block: B:160:0x01e8 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:161:0x01ea  */
    /* JADX WARN: Found duplicated region for block: B:170:0x0203 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:171:0x0205  */
    /* JADX WARN: Found duplicated region for block: B:174:0x020b A[ADDED_TO_REGION] */
    @Override // com.alibaba.fastjson2.JSONReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float readFloatValue() {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readFloatValue():float");
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x003c A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Found duplicated region for block: B:30:0x004b A[LOOP:0: B:20:0x0036->B:30:0x004b, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:90:0x0030 A[EDGE_INSN: B:90:0x0030->B:18:0x0030 BREAK  A[LOOP:0: B:20:0x0036->B:30:0x004b], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0048 -> B:18:0x0030). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x00e2 -> B:67:0x00c2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:22:0x003c
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final byte[] readHex() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readHex():byte[]");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean readIfNull() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        if (this.ch != 'n' || cArr[i2] != 'u' || cArr[i2 + 1] != 'l' || cArr[i2 + 2] != 'l') {
            return false;
        }
        int i3 = i2 + 3;
        char c2 = i3 == this.end ? (char) 26 : cArr[i3];
        int i4 = i2 + 4;
        while (c2 <= ' ' && ((1 << c2) & 4294981376L) != 0) {
            if (i4 == this.end) {
                c2 = 26;
            } else {
                c2 = cArr[i4];
                i4++;
            }
        }
        boolean z = c2 == ',';
        this.comma = z;
        if (z) {
            if (i4 == this.end) {
                i = i4;
                c = 26;
            } else {
                i = i4 + 1;
                c = cArr[i4];
            }
            loop1: while (true) {
                int i5 = i;
                c2 = c;
                i4 = i5;
                while (true) {
                    if (c2 > ' ' || ((1 << c2) & 4294981376L) == 0) {
                        break loop1;
                    }
                    if (i4 == this.end) {
                        c2 = 26;
                    }
                }
                i = i4 + 1;
                c = cArr[i4];
            }
        }
        this.ch = c2;
        this.offset = i4;
        return true;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final Integer readInt32() {
        char c = this.ch;
        if ((c == '\"' || c == '\'' || c == 'n') && nextIfNullOrEmptyString()) {
            return null;
        }
        return Integer.valueOf(readInt32Value());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x00d3 -> B:74:0x00b7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:78:0x00c9
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final int readInt32Value() {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readInt32Value():int");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final Long readInt64() {
        char c = this.ch;
        if ((c == '\"' || c == '\'' || c == 'n') && nextIfNullOrEmptyString()) {
            return null;
        }
        return Long.valueOf(readInt64Value());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x00ee -> B:77:0x00d5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:81:0x00e4
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final long readInt64Value() {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readInt64Value():long");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDate readLocalDate() {
        LocalDate localDateOf;
        char[] cArr = this.chars;
        int i = this.offset;
        char c = this.ch;
        if ((c == '\"' || c == '\'') && !this.context.formatComplex) {
            int i2 = i + 10;
            if (i2 < cArr.length && i2 < this.end && cArr[i + 4] == '-' && cArr[i + 7] == '-' && cArr[i2] == c) {
                int iDigit4 = IOUtils.digit4(cArr, i);
                int iDigit2 = IOUtils.digit2(cArr, i + 5);
                int iDigit22 = IOUtils.digit2(cArr, i + 8);
                int i3 = iDigit4 | iDigit2 | iDigit22;
                if (i3 < 0) {
                    throw new JSONException(info("read date error"));
                }
                if (i3 == 0) {
                    localDateOf = null;
                } else {
                    try {
                        localDateOf = LocalDate.of(iDigit4, iDigit2, iDigit22);
                    } catch (DateTimeException e) {
                        throw new JSONException(info("read date error"), e);
                    }
                }
                this.offset = i + 11;
                next();
                boolean z = this.ch == ',';
                this.comma = z;
                if (z) {
                    next();
                }
                return localDateOf;
            }
            LocalDate localDate0 = readLocalDate0(i, cArr, c);
            if (localDate0 != null) {
                return localDate0;
            }
        }
        return super.readLocalDate();
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDate readLocalDate10() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localDate only support string input");
        }
        try {
            LocalDate localDate10 = DateUtils.parseLocalDate10(this.chars, this.offset);
            if (localDate10 == null) {
                return null;
            }
            this.offset += 11;
            next();
            boolean z = this.ch == ',';
            this.comma = z;
            if (z) {
                next();
            }
            return localDate10;
        } catch (DateTimeException e) {
            throw new JSONException(info("read date error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDate readLocalDate11() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localDate only support string input");
        }
        LocalDate localDate11 = DateUtils.parseLocalDate11(this.chars, this.offset);
        if (localDate11 == null) {
            return null;
        }
        this.offset += 12;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDate11;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDate readLocalDate8() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localDate only support string input");
        }
        try {
            LocalDate localDate8 = DateUtils.parseLocalDate8(this.chars, this.offset);
            this.offset += 9;
            next();
            boolean z = this.ch == ',';
            this.comma = z;
            if (z) {
                next();
            }
            return localDate8;
        } catch (DateTimeException e) {
            throw new JSONException(info("read date error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDate readLocalDate9() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localDate only support string input");
        }
        try {
            LocalDate localDate9 = DateUtils.parseLocalDate9(this.chars, this.offset);
            this.offset += 10;
            next();
            boolean z = this.ch == ',';
            this.comma = z;
            if (z) {
                next();
            }
            return localDate9;
        } catch (DateTimeException e) {
            throw new JSONException(info("read date error"), e);
        }
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime12() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime12 = DateUtils.parseLocalDateTime12(this.chars, this.offset);
        if (localDateTime12 == null) {
            return null;
        }
        this.offset += 13;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime12;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime14() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime14 = DateUtils.parseLocalDateTime14(this.chars, this.offset);
        if (localDateTime14 == null) {
            return null;
        }
        this.offset += 15;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime14;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime16() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime16 = DateUtils.parseLocalDateTime16(this.chars, this.offset);
        if (localDateTime16 == null) {
            return null;
        }
        this.offset += 17;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime16;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime17() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime17 = DateUtils.parseLocalDateTime17(this.chars, this.offset);
        if (localDateTime17 == null) {
            return null;
        }
        this.offset += 18;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime17;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime18() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime18 = DateUtils.parseLocalDateTime18(this.chars, this.offset);
        this.offset += 19;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime18;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime19() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime19 = DateUtils.parseLocalDateTime19(this.chars, this.offset);
        if (localDateTime19 == null) {
            return null;
        }
        this.offset += 20;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime19;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTime20() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        LocalDateTime localDateTime20 = DateUtils.parseLocalDateTime20(this.chars, this.offset);
        if (localDateTime20 == null) {
            return null;
        }
        this.offset += 21;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime20;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalDateTime readLocalDateTimeX(int i) {
        LocalDateTime localDateTimeX;
        LocalDateTime localDateTime;
        ChronoLocalDateTime<LocalDate> localDateTime2;
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        char[] cArr = this.chars;
        int i2 = this.offset;
        boolean z = true;
        if (cArr[(i2 + i) - 1] == 'Z') {
            localDateTime2 = DateUtils.parseZonedDateTime(cArr, i2, i).toInstant().atZone(this.context.getZoneId()).toLocalDateTime();
        } else {
            localDateTimeX = DateUtils.parseLocalDateTimeX(cArr, i2, i);
        }
        if (localDateTime == 0) {
            localDateTime = localDateTimeX;
            localDateTime = localDateTime2;
            return null;
        }
        localDateTime = localDateTimeX;
        this.offset = i + 1 + this.offset;
        next();
        if (this.ch != ',') {
            localDateTime = localDateTime2;
            z = false;
        }
        localDateTime = localDateTime2;
        this.comma = z;
        if (z) {
            next();
        }
        return localDateTime;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime10() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime10 = DateUtils.parseLocalTime10(this.chars, this.offset);
        if (localTime10 == null) {
            return null;
        }
        this.offset += 11;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime10;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime11() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime11 = DateUtils.parseLocalTime11(this.chars, this.offset);
        if (localTime11 == null) {
            return null;
        }
        this.offset += 12;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime11;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime12() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime12 = DateUtils.parseLocalTime12(this.chars, this.offset);
        if (localTime12 == null) {
            return null;
        }
        this.offset += 13;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime12;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime15() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime15 = DateUtils.parseLocalTime15(this.chars, this.offset);
        if (localTime15 == null) {
            return null;
        }
        this.offset += 16;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime15;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime18() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime18 = DateUtils.parseLocalTime18(this.chars, this.offset);
        if (localTime18 == null) {
            return null;
        }
        this.offset += 19;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime18;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime5() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime5 = DateUtils.parseLocalTime5(this.chars, this.offset);
        if (localTime5 == null) {
            return null;
        }
        this.offset += 6;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime5;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime6() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime6 = DateUtils.parseLocalTime6(this.chars, this.offset);
        if (localTime6 == null) {
            return null;
        }
        this.offset += 7;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime6;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime7() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime7 = DateUtils.parseLocalTime7(this.chars, this.offset);
        if (localTime7 == null) {
            return null;
        }
        this.offset += 8;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime7;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime8() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime8 = DateUtils.parseLocalTime8(this.chars, this.offset);
        if (localTime8 == null) {
            return null;
        }
        this.offset += 9;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime8;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final LocalTime readLocalTime9() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("localTime only support string input");
        }
        LocalTime localTime8 = DateUtils.parseLocalTime8(this.chars, this.offset);
        if (localTime8 == null) {
            return null;
        }
        this.offset += 10;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return localTime8;
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final long readMillis19() {
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        int i = this.offset;
        if (i + 18 >= this.end) {
            this.wasNull = true;
            return 0L;
        }
        long millis19 = DateUtils.parseMillis19(this.chars, i, this.context.zoneId);
        char[] cArr = this.chars;
        int i2 = this.offset;
        if (cArr[i2 + 19] != c) {
            throw new JSONException(info("illegal date input"));
        }
        this.offset = i2 + 20;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return millis19;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:9:0x001b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:12:0x002c
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final double readNaN() {
        /*
            r14 = this;
            char[] r0 = r14.chars
            int r1 = r14.offset
            char r2 = r0[r1]
            r3 = 97
            if (r2 != r3) goto L77
            int r2 = r1 + 1
            char r2 = r0[r2]
            r3 = 78
            if (r2 != r3) goto L77
            int r2 = r1 + 2
            int r3 = r14.end
            r4 = 26
            if (r2 != r3) goto L1d
            r1 = r2
        L1b:
            r2 = r4
            goto L21
        L1d:
            int r1 = r1 + 3
            char r2 = r0[r2]
        L21:
            r5 = 0
            r7 = 4294981376(0x100003700, double:2.1220027474E-314)
            r9 = 1
            r3 = 32
            if (r2 > r3) goto L42
            long r11 = r9 << r2
            long r11 = r11 & r7
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 == 0) goto L42
            int r2 = r14.end
            if (r1 < r2) goto L3a
            goto L1b
        L3a:
            int r2 = r1 + 1
            char r1 = r0[r1]
            r13 = r2
            r2 = r1
            r1 = r13
            goto L21
        L42:
            r11 = 44
            if (r2 != r11) goto L48
            r11 = 1
            goto L49
        L48:
            r11 = 0
        L49:
            r14.comma = r11
            if (r11 == 0) goto L6f
            int r2 = r14.end
            if (r1 < r2) goto L54
            r2 = r1
            r1 = r4
            goto L58
        L54:
            int r2 = r1 + 1
            char r1 = r0[r1]
        L58:
            r13 = r2
            r2 = r1
            r1 = r13
        L5b:
            if (r2 > r3) goto L6f
            long r11 = r9 << r2
            long r11 = r11 & r7
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 == 0) goto L6f
            int r2 = r14.end
            if (r1 < r2) goto L6a
            r2 = r4
            goto L5b
        L6a:
            int r2 = r1 + 1
            char r1 = r0[r1]
            goto L58
        L6f:
            char r0 = (char) r2
            r14.ch = r0
            r14.offset = r1
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            return r0
        L77:
            com.alibaba.fastjson2.JSONException r0 = new com.alibaba.fastjson2.JSONException
            java.lang.String r2 = "json syntax error, not NaN "
            java.lang.String r1 = me.hd.wauxv.obf.bjs.i(r1, r2)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readNaN():double");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final void readNull() {
        int i;
        char c;
        char[] cArr = this.chars;
        int i2 = this.offset;
        if (cArr[i2] != 'u' || cArr[i2 + 1] != 'l' || cArr[i2 + 2] != 'l') {
            throw new JSONException(bjs.i(i2, "json syntax error, not match null, offset "));
        }
        int i3 = i2 + 3;
        char c2 = i3 == this.end ? (char) 26 : cArr[i3];
        int i4 = i2 + 4;
        while (c2 <= ' ' && ((1 << c2) & 4294981376L) != 0) {
            if (i4 == this.end) {
                c2 = 26;
            } else {
                c2 = cArr[i4];
                i4++;
            }
        }
        boolean z = c2 == ',';
        this.comma = z;
        if (z) {
            if (i4 == this.end) {
                i = i4;
                c = 26;
            } else {
                i = i4 + 1;
                c = cArr[i4];
            }
            loop1: while (true) {
                int i5 = i;
                c2 = c;
                i4 = i5;
                while (true) {
                    if (c2 > ' ' || ((1 << c2) & 4294981376L) == 0) {
                        break loop1;
                    } else if (i4 == this.end) {
                        c2 = 26;
                    }
                }
                i = i4 + 1;
                c = cArr[i4];
            }
        }
        this.ch = c2;
        this.offset = i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0051, code lost:
    
        r3 = 26;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x009f -> B:44:0x0090). Please report as a decompilation issue!!! */
    @Override // com.alibaba.fastjson2.JSONReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Date readNullOrNewDate() {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readNullOrNewDate():java.util.Date");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:12:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:14:0x0048
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final void readNumber0() {
        /*
            Method dump skipped, instruction units count: 865
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readNumber0():void");
    }

    /* JADX WARN: Found duplicated region for block: B:82:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:84:0x0133  */
    /* JADX WARN: Found duplicated region for block: B:96:0x00de A[EDGE_INSN: B:96:0x00de->B:55:0x00de BREAK  A[LOOP:1: B:58:0x00e5->B:57:0x00e4], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x011b -> B:71:0x010a). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$BranchConn.match(Pattern.java:4725)
        	at java.base/java.util.regex.Pattern$GroupTail.match(Pattern.java:4847)
        	at java.base/java.util.regex.Pattern$BmpCharPropertyGreedy.match(Pattern.java:4356)
        	at java.base/java.util.regex.Pattern$GroupHead.match(Pattern.java:4816)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$BranchConn.match(Pattern.java:4725)
        	at java.base/java.util.regex.Pattern$GroupTail.match(Pattern.java:4847)
        	at java.base/java.util.regex.Pattern$BmpCharPropertyGreedy.match(Pattern.java:4356)
        	at java.base/java.util.regex.Pattern$GroupHead.match(Pattern.java:4816)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4759)
        	at java.base/java.util.regex.Pattern$BmpCharProperty.match(Pattern.java:3982)
        	at java.base/java.util.regex.Pattern$Start.match(Pattern.java:3635)
        	at java.base/java.util.regex.Matcher.search(Matcher.java:1728)
        	at java.base/java.util.regex.Matcher.find(Matcher.java:772)
        	at java.base/java.util.Formatter.parse(Formatter.java:2746)
        	at java.base/java.util.Formatter.format(Formatter.java:2671)
        	at java.base/java.util.Formatter.format(Formatter.java:2625)
        	at java.base/java.lang.String.format(String.java:4145)
        	at jadx.core.utils.InsnUtils.formatOffset(InsnUtils.java:40)
        	at jadx.core.dex.nodes.BlockNode.toString(BlockNode.java:280)
        	at java.base/java.lang.String.valueOf(String.java:4220)
        	at jadx.core.dex.attributes.nodes.LoopInfo.toString(LoopInfo.java:109)
        	at java.base/java.lang.String.valueOf(String.java:4220)
        	at java.base/java.util.Objects.toString(Objects.java:147)
        	at jadx.core.utils.Utils.listToString(Utils.java:207)
        	at jadx.core.utils.Utils.listToString(Utils.java:193)
        	at jadx.core.utils.Utils.listToString(Utils.java:184)
        	at jadx.core.dex.attributes.AttrList.toString(AttrList.java:32)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final java.time.OffsetDateTime readOffsetDateTime() {
        /*
            Method dump skipped, instruction units count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readOffsetDateTime():java.time.OffsetDateTime");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final OffsetTime readOffsetTime() {
        int i;
        int i2;
        char[] cArr = this.chars;
        int i3 = this.offset;
        JSONReader.Context context = this.context;
        char c = this.ch;
        if ((c != '\"' && c != '\'') || context.dateFormat != null || (i = i3 + 8) >= cArr.length || i >= this.end || cArr[i3 + 2] != ':' || cArr[i3 + 5] != ':') {
            throw new JSONException(info("illegal offsetTime"));
        }
        char c2 = cArr[i3];
        char c3 = cArr[i3 + 1];
        char c4 = cArr[i3 + 3];
        char c5 = cArr[i3 + 4];
        char c6 = cArr[i3 + 6];
        char c7 = cArr[i3 + 7];
        if (c2 < '0' || c2 > '9' || c3 < '0' || c3 > '9') {
            throw new JSONException(info("illegal offsetTime"));
        }
        int i4 = (c3 - '0') + ((c2 - '0') * 10);
        if (c4 < '0' || c4 > '9' || c5 < '0' || c5 > '9') {
            throw new JSONException(info("illegal offsetTime"));
        }
        int i5 = (c5 - '0') + ((c4 - '0') * 10);
        if (c6 < '0' || c6 > '9' || c7 < '0' || c7 > '9') {
            throw new JSONException(info("illegal offsetTime"));
        }
        int i6 = (c7 - '0') + ((c6 - '0') * 10);
        int i7 = i3 + 25;
        int i8 = i;
        int i9 = -1;
        while (true) {
            if (i8 >= i7 || i8 >= this.end || i8 >= cArr.length) {
                i2 = 0;
                break;
            }
            char c8 = cArr[i8];
            if (i9 == -1 && (c8 == 'Z' || c8 == '+' || c8 == '-')) {
                i9 = (i8 - i) - 1;
            }
            if (c8 == c) {
                i2 = i8 - i3;
                break;
            }
            i8++;
        }
        int i10 = (i2 - 9) - i9;
        OffsetTime offsetTimeOf = OffsetTime.of(LocalTime.of(i4, i5, i6, i9 <= 0 ? 0 : DateUtils.readNanos(cArr, i9, i3 + 9)), i10 <= 1 ? ZoneOffset.UTC : ZoneOffset.of(new String(cArr, i3 + 9 + i9, i10)));
        this.offset = i2 + 1 + this.offset;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return offsetTimeOf;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0043 -> B:14:0x0027). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:17:0x0038
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final java.lang.String readPattern() {
        /*
            r15 = this;
            char r0 = r15.ch
            r1 = 47
            if (r0 != r1) goto L80
            char[] r0 = r15.chars
            int r2 = r15.offset
            r3 = r2
        Lb:
            int r4 = r15.end
            if (r3 >= r4) goto L17
            char r4 = r0[r3]
            if (r4 != r1) goto L14
            goto L17
        L14:
            int r3 = r3 + 1
            goto Lb
        L17:
            java.lang.String r1 = new java.lang.String
            int r4 = r3 - r2
            r1.<init>(r0, r2, r4)
            int r2 = r3 + 1
            int r4 = r15.end
            r5 = 26
            if (r2 != r4) goto L29
            r3 = r2
        L27:
            r2 = r5
            goto L2d
        L29:
            int r3 = r3 + 2
            char r2 = r0[r2]
        L2d:
            r6 = 0
            r8 = 4294981376(0x100003700, double:2.1220027474E-314)
            r10 = 1
            r4 = 32
            if (r2 > r4) goto L4e
            long r12 = r10 << r2
            long r12 = r12 & r8
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 == 0) goto L4e
            int r2 = r15.end
            if (r3 != r2) goto L46
            goto L27
        L46:
            int r2 = r3 + 1
            char r3 = r0[r3]
            r14 = r3
            r3 = r2
            r2 = r14
            goto L2d
        L4e:
            r12 = 44
            if (r2 != r12) goto L54
            r12 = 1
            goto L55
        L54:
            r12 = 0
        L55:
            r15.comma = r12
            if (r12 == 0) goto L7b
            int r2 = r15.end
            if (r3 != r2) goto L60
            r2 = r3
            r3 = r5
            goto L64
        L60:
            int r2 = r3 + 1
            char r3 = r0[r3]
        L64:
            r14 = r3
            r3 = r2
            r2 = r14
        L67:
            if (r2 > r4) goto L7b
            long r12 = r10 << r2
            long r12 = r12 & r8
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 == 0) goto L7b
            int r2 = r15.end
            if (r3 != r2) goto L76
            r2 = r5
            goto L67
        L76:
            int r2 = r3 + 1
            char r3 = r0[r3]
            goto L64
        L7b:
            r15.offset = r3
            r15.ch = r2
            return r1
        L80:
            com.alibaba.fastjson2.JSONException r0 = new com.alibaba.fastjson2.JSONException
            java.lang.String r1 = "illegal pattern"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readPattern():java.lang.String");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0058 -> B:20:0x0047). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:22:0x004d
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final java.lang.String readReference() {
        /*
            r15 = this;
            int r0 = r15.referenceBegin
            int r1 = r15.end
            if (r0 != r1) goto L8
            r0 = 0
            return r0
        L8:
            char[] r1 = r15.chars
            int r2 = r0 + 1
            r15.offset = r2
            char r0 = r1[r0]
            r15.ch = r0
            java.lang.String r0 = r15.readString()
            char r2 = r15.ch
            int r3 = r15.offset
        L1a:
            r4 = 0
            r6 = 4294981376(0x100003700, double:2.1220027474E-314)
            r8 = 1
            r10 = 32
            r11 = 26
            if (r2 > r10) goto L3e
            long r12 = r8 << r2
            long r12 = r12 & r6
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 == 0) goto L3e
            int r2 = r15.end
            if (r3 != r2) goto L36
            r2 = r11
            goto L1a
        L36:
            int r2 = r3 + 1
            char r3 = r1[r3]
            r14 = r3
            r3 = r2
            r2 = r14
            goto L1a
        L3e:
            r12 = 125(0x7d, float:1.75E-43)
            if (r2 != r12) goto L95
            int r2 = r15.end
            if (r3 != r2) goto L49
            r2 = r3
        L47:
            r3 = r11
            goto L4d
        L49:
            int r2 = r3 + 1
            char r3 = r1[r3]
        L4d:
            if (r3 > r10) goto L63
            long r12 = r8 << r3
            long r12 = r12 & r6
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 == 0) goto L63
            int r3 = r15.end
            if (r2 != r3) goto L5b
            goto L47
        L5b:
            int r3 = r2 + 1
            char r2 = r1[r2]
            r14 = r3
            r3 = r2
            r2 = r14
            goto L4d
        L63:
            r12 = 44
            if (r3 != r12) goto L69
            r12 = 1
            goto L6a
        L69:
            r12 = 0
        L6a:
            r15.comma = r12
            if (r12 == 0) goto L90
            int r3 = r15.end
            if (r2 != r3) goto L75
            r3 = r2
            r2 = r11
            goto L79
        L75:
            int r3 = r2 + 1
            char r2 = r1[r2]
        L79:
            r14 = r3
            r3 = r2
            r2 = r14
        L7c:
            if (r3 > r10) goto L90
            long r12 = r8 << r3
            long r12 = r12 & r6
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 == 0) goto L90
            int r3 = r15.end
            if (r2 != r3) goto L8b
            r3 = r11
            goto L7c
        L8b:
            int r3 = r2 + 1
            char r2 = r1[r2]
            goto L79
        L90:
            r15.ch = r3
            r15.offset = r2
            return r0
        L95:
            com.alibaba.fastjson2.JSONException r1 = new com.alibaba.fastjson2.JSONException
            java.lang.String r2 = "illegal reference : "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readReference():java.lang.String");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x015e -> B:91:0x0147). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:94:0x0155
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public java.lang.String readString() {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readString():java.lang.String");
    }

    public final void readString0() {
        String str;
        char[] cArr = this.chars;
        char c = this.ch;
        int i = this.offset;
        int i2 = 0;
        this.valueEscape = false;
        int i3 = i;
        int i4 = 0;
        while (true) {
            char c2 = cArr[i3];
            int i5 = 2;
            if (c2 == '\\') {
                this.valueEscape = true;
                char c3 = cArr[i3 + 1];
                if (c3 == 'u') {
                    i5 = 6;
                } else if (c3 == 'x') {
                    i5 = 4;
                }
                i3 += i5;
            } else if (c2 == c) {
                break;
            } else {
                i3++;
            }
            i4++;
            i2 = 0;
        }
        if (this.valueEscape) {
            char[] cArr2 = new char[i4];
            int i6 = i2;
            while (true) {
                char[] cArr3 = this.chars;
                char cChar1 = cArr3[i];
                if (cChar1 == '\\') {
                    int i7 = i + 1;
                    char c4 = cArr3[i7];
                    if (c4 == 'u') {
                        cChar1 = (char) IOUtils.hexDigit4(cArr, JSONReaderJSONB.check3(i + 2, this.end));
                        i += 5;
                    } else if (c4 == 'x') {
                        char c5 = cArr[i + 2];
                        i += 3;
                        cChar1 = JSONReader.char2(c5, cArr[i]);
                    } else if (c4 == '\\' || c4 == '\"') {
                        i = i7;
                        cChar1 = c4;
                    } else {
                        cChar1 = char1(c4);
                        i = i7;
                    }
                } else if (cChar1 == '\"') {
                    break;
                }
                cArr2[i6] = cChar1;
                i++;
                i6++;
            }
            str = new String(cArr2);
            i3 = i;
        } else {
            int i8 = this.offset;
            str = new String(cArr, i8, i3 - i8);
        }
        int i9 = i3 + 1;
        char c6 = i9 == this.end ? (char) 26 : cArr[i9];
        while (c6 <= ' ' && ((1 << c6) & 4294981376L) != 0) {
            i9++;
            c6 = cArr[i9];
        }
        boolean z = c6 == ',';
        this.comma = z;
        if (z) {
            this.offset = i9 + 2;
            this.ch = cArr[i9 + 1];
            while (true) {
                char c7 = this.ch;
                if (c7 > ' ' || ((1 << c7) & 4294981376L) == 0) {
                    break;
                }
                int i10 = this.offset;
                if (i10 >= this.end) {
                    this.ch = (char) 26;
                } else {
                    this.offset = i10 + 1;
                    this.ch = cArr[i10];
                }
            }
        } else {
            this.offset = i9 + 1;
            this.ch = c6;
        }
        this.stringValue = str;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00d2 -> B:33:0x00b6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:36:0x00bf
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final java.util.UUID readUUID() {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.readUUID():java.util.UUID");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final long readValueHashCode() {
        boolean z;
        boolean z2;
        char[] cArr;
        char cHexDigit4;
        long j;
        long j2;
        char c = this.ch;
        char c2 = '\"';
        if (c != '\"' && c != '\'') {
            return -1L;
        }
        char[] cArr2 = this.chars;
        this.nameEscape = false;
        int i = this.offset;
        this.nameBegin = i;
        int i2 = this.end;
        int i3 = 0;
        long j3 = 0;
        while (true) {
            z = true;
            if (i < i2) {
                char cHexDigit42 = cArr2[i];
                if (cHexDigit42 != c) {
                    if (cHexDigit42 == '\\') {
                        this.nameEscape = true;
                        int i4 = i + 1;
                        char c3 = cArr2[i4];
                        if (c3 == 'u') {
                            cHexDigit42 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i + 2, i2));
                            i += 5;
                        } else if (c3 != 'x') {
                            cHexDigit42 = char1(c3);
                            i = i4;
                        } else {
                            char c4 = cArr2[i + 2];
                            i += 3;
                            cHexDigit42 = JSONReader.char2(c4, cArr2[i]);
                        }
                    }
                    if (cHexDigit42 > 255 || i3 >= 8 || (i3 == 0 && cHexDigit42 == 0)) {
                        i = this.nameBegin;
                    } else {
                        switch (i3) {
                            case 0:
                                j3 = (byte) cHexDigit42;
                                continue;
                                i++;
                                i3++;
                                break;
                            case 1:
                                j = ((byte) cHexDigit42) << 8;
                                j2 = 255;
                                break;
                            case 2:
                                j = ((byte) cHexDigit42) << 16;
                                j2 = WebSocketProtocol.PAYLOAD_SHORT_MAX;
                                break;
                            case 3:
                                j = ((byte) cHexDigit42) << 24;
                                j2 = 16777215;
                                break;
                            case 4:
                                j = ((long) ((byte) cHexDigit42)) << 32;
                                j2 = 4294967295L;
                                break;
                            case 5:
                                j = ((long) ((byte) cHexDigit42)) << 40;
                                j2 = 1099511627775L;
                                break;
                            case 6:
                                j = ((long) ((byte) cHexDigit42)) << 48;
                                j2 = 281474976710655L;
                                break;
                            case 7:
                                j = ((long) ((byte) cHexDigit42)) << 56;
                                j2 = 72057594037927935L;
                                break;
                            default:
                                continue;
                                i++;
                                i3++;
                                break;
                        }
                        j3 = (j3 & j2) + j;
                        i++;
                        i3++;
                    }
                } else if (i3 == 0) {
                    i = this.nameBegin;
                } else {
                    this.nameLength = i3;
                    this.nameEnd = i;
                    i++;
                }
                j3 = 0;
            }
        }
        if (j3 != 0) {
            z2 = true;
        } else {
            j3 = -3750763034362895579L;
            int i5 = 0;
            while (true) {
                char c5 = cArr2[i];
                if (c5 == '\\') {
                    this.nameEscape = z;
                    int i6 = i + 1;
                    z2 = z;
                    char c6 = cArr2[i6];
                    if (c6 == 'u') {
                        cHexDigit4 = (char) IOUtils.hexDigit4(cArr2, JSONReaderJSONB.check3(i + 2, i2));
                        i6 = i + 5;
                    } else if (c6 != 'x') {
                        cHexDigit4 = char1(c6);
                    } else {
                        i6 = i + 3;
                        cHexDigit4 = JSONReader.char2(cArr2[i + 2], cArr2[i6]);
                    }
                    cArr = cArr2;
                    j3 = (((long) cHexDigit4) ^ j3) * Fnv.MAGIC_PRIME;
                    i = i6 + 1;
                } else {
                    z2 = z;
                    if (c5 == c2) {
                        this.nameLength = i5;
                        this.nameEnd = i;
                        this.stringValue = null;
                        i++;
                    } else {
                        i++;
                        cArr = cArr2;
                        j3 = (((long) c5) ^ j3) * Fnv.MAGIC_PRIME;
                    }
                }
                i5++;
                z = z2;
                cArr2 = cArr;
                c2 = '\"';
            }
        }
        char c7 = i == i2 ? (char) 26 : cArr2[i];
        while (c7 <= ' ' && ((1 << c7) & 4294981376L) != 0) {
            i++;
            c7 = cArr2[i];
        }
        boolean z3 = c7 == ',' ? z2 : false;
        this.comma = z3;
        if (z3) {
            i++;
            char c8 = i != i2 ? cArr2[i] : (char) 26;
            while (c8 <= ' ' && ((1 << c8) & 4294981376L) != 0) {
                i++;
                c8 = cArr2[i];
            }
            c7 = c8;
        }
        this.offset = i + 1;
        this.ch = c7;
        return j3;
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Found duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Found duplicated region for block: B:21:0x0040  */
    /* JADX WARN: Found duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Found duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Found duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Found duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Found duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Found duplicated region for block: B:32:0x0079  */
    @Override // com.alibaba.fastjson2.JSONReader
    public final ZonedDateTime readZonedDateTimeX(int i) {
        ZonedDateTime zonedDateTimeOf;
        int i2;
        int i3;
        char c = this.ch;
        if (c != '\"' && c != '\'') {
            throw new JSONException("date only support string input");
        }
        if (i < 19) {
            return null;
        }
        char[] cArr = this.chars;
        if (i == 30) {
            int i4 = this.offset;
            if (cArr[i4 + 29] == 'Z') {
                zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime29(cArr, i4), ZoneOffset.UTC);
            } else if (i == 29) {
                i3 = this.offset;
                if (cArr[i3 + 28] == 'Z') {
                    zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime28(cArr, i3), ZoneOffset.UTC);
                } else if (i == 28) {
                    i2 = this.offset;
                    if (cArr[i2 + 27] == 'Z') {
                        zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime27(cArr, i2), ZoneOffset.UTC);
                    } else if (i == 27) {
                        int i5 = this.offset;
                        zonedDateTimeOf = cArr[i5 + 26] == 'Z' ? ZonedDateTime.of(DateUtils.parseLocalDateTime26(cArr, i5), ZoneOffset.UTC) : DateUtils.parseZonedDateTime(cArr, this.offset, i, this.context.zoneId);
                    }
                } else if (i == 27) {
                    int i52 = this.offset;
                    if (cArr[i52 + 26] == 'Z') {
                    }
                }
            } else if (i == 28) {
                i2 = this.offset;
                if (cArr[i2 + 27] == 'Z') {
                    zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime27(cArr, i2), ZoneOffset.UTC);
                } else if (i == 27) {
                    int i522 = this.offset;
                    if (cArr[i522 + 26] == 'Z') {
                    }
                }
            } else if (i == 27) {
                int i5222 = this.offset;
                if (cArr[i5222 + 26] == 'Z') {
                }
            }
        } else if (i == 29) {
            i3 = this.offset;
            if (cArr[i3 + 28] == 'Z') {
                zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime28(cArr, i3), ZoneOffset.UTC);
            } else if (i == 28) {
                i2 = this.offset;
                if (cArr[i2 + 27] == 'Z') {
                    zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime27(cArr, i2), ZoneOffset.UTC);
                } else if (i == 27) {
                    int i52222 = this.offset;
                    if (cArr[i52222 + 26] == 'Z') {
                    }
                }
            } else if (i == 27) {
                int i522222 = this.offset;
                if (cArr[i522222 + 26] == 'Z') {
                }
            }
        } else if (i == 28) {
            i2 = this.offset;
            if (cArr[i2 + 27] == 'Z') {
                zonedDateTimeOf = ZonedDateTime.of(DateUtils.parseLocalDateTime27(cArr, i2), ZoneOffset.UTC);
            } else if (i == 27) {
                int i5222222 = this.offset;
                if (cArr[i5222222 + 26] == 'Z') {
                }
            }
        } else if (i == 27) {
            int i52222222 = this.offset;
            if (cArr[i52222222 + 26] == 'Z') {
            }
        }
        if (zonedDateTimeOf == null) {
            return null;
        }
        this.offset = i + 1 + this.offset;
        next();
        boolean z = this.ch == ',';
        this.comma = z;
        if (z) {
            next();
        }
        return zonedDateTimeOf;
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x002d  */
    @Override // com.alibaba.fastjson2.JSONReader
    public final void skipComment() {
        boolean z;
        boolean z2;
        char c;
        int i = this.offset;
        int i2 = i + 1;
        if (i2 >= this.end) {
            throw new JSONException(info());
        }
        char[] cArr = this.chars;
        char c2 = cArr[i];
        if (c2 == '*') {
            z = true;
        } else {
            if (c2 != '/') {
                throw new JSONException(info("parse comment error"));
            }
            z = false;
        }
        int i3 = i + 2;
        char c3 = cArr[i2];
        while (true) {
            if (!z) {
                z2 = c3 == '\n';
            } else if (c3 == '*' && i3 <= this.end && cArr[i3] == '/') {
                i3++;
            }
            c = 26;
            if (z2) {
                if (i3 >= this.end) {
                    break;
                }
                char c4 = cArr[i3];
                while (true) {
                    if (c4 > ' ' || ((1 << c4) & 4294981376L) == 0) {
                        c = c4;
                        break;
                    }
                    i3++;
                    if (i3 >= this.end) {
                        break;
                    } else {
                        c4 = cArr[i3];
                    }
                }
                i3++;
                break;
            }
            if (i3 >= this.end) {
                break;
            }
            c3 = cArr[i3];
            i3++;
        }
        this.ch = c;
        this.offset = i3;
        if (c == '/') {
            skipComment();
        }
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean skipName() {
        this.offset = skipName(this, this.chars, this.offset, this.end);
        return true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0045 -> B:20:0x002b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0066 -> B:33:0x0057). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:35:0x005d
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static int skipName(com.alibaba.fastjson2.JSONReaderUTF16 r12, char[] r13, int r14, int r15) {
        /*
            char r0 = r12.ch
            boolean r1 = r12.checkNameBegin(r0)
            if (r1 == 0) goto Lb
            int r12 = r12.offset
            return r12
        Lb:
            int r1 = r14 + 1
            char r2 = r13[r14]
            r3 = 92
            if (r2 != r3) goto L24
            char r14 = r13[r1]
            r2 = 117(0x75, float:1.64E-43)
            if (r14 != r2) goto L1b
            r14 = 5
            goto L22
        L1b:
            r2 = 120(0x78, float:1.68E-43)
            if (r14 != r2) goto L21
            r14 = 3
            goto L22
        L21:
            r14 = 1
        L22:
            int r14 = r14 + r1
            goto Lb
        L24:
            if (r2 != r0) goto L79
            r0 = 26
            if (r1 != r15) goto L2d
            r14 = r1
        L2b:
            r1 = r0
            goto L31
        L2d:
            int r14 = r14 + 2
            char r1 = r13[r1]
        L31:
            r2 = 0
            r4 = 4294981376(0x100003700, double:2.1220027474E-314)
            r6 = 1
            r8 = 32
            if (r1 > r8) goto L50
            long r9 = r6 << r1
            long r9 = r9 & r4
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 == 0) goto L50
            if (r14 != r15) goto L48
            goto L2b
        L48:
            int r1 = r14 + 1
            char r14 = r13[r14]
            r11 = r1
            r1 = r14
            r14 = r11
            goto L31
        L50:
            r9 = 58
            if (r1 != r9) goto L74
            if (r14 != r15) goto L59
            r1 = r14
        L57:
            r14 = r0
            goto L5d
        L59:
            int r1 = r14 + 1
            char r14 = r13[r14]
        L5d:
            if (r14 > r8) goto L71
            long r9 = r6 << r14
            long r9 = r9 & r4
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 == 0) goto L71
            if (r1 != r15) goto L69
            goto L57
        L69:
            int r14 = r1 + 1
            char r1 = r13[r1]
            r11 = r1
            r1 = r14
            r14 = r11
            goto L5d
        L71:
            r12.ch = r14
            return r1
        L74:
            com.alibaba.fastjson2.JSONException r12 = com.alibaba.fastjson2.JSONReader.syntaxError(r1)
            throw r12
        L79:
            r14 = r1
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.skipName(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:20:0x0034 A[LOOP:0: B:7:0x000b->B:20:0x0034, LOOP_END, MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:22:0x0005 A[EDGE_INSN: B:22:0x0005->B:5:0x0005 BREAK  A[LOOP:0: B:7:0x000b->B:20:0x0034], SYNTHETIC] */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at java.base/java.util.regex.Pattern$BmpCharProperty.match(Pattern.java:3981)
        	at java.base/java.util.regex.Pattern$GroupHead.match(Pattern.java:4816)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4759)
        	at java.base/java.util.regex.Pattern$BranchConn.match(Pattern.java:4725)
        	at java.base/java.util.regex.Pattern$GroupTail.match(Pattern.java:4847)
        	at java.base/java.util.regex.Pattern$BmpCharPropertyGreedy.match(Pattern.java:4356)
        	at java.base/java.util.regex.Pattern$GroupHead.match(Pattern.java:4816)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$BranchConn.match(Pattern.java:4725)
        	at java.base/java.util.regex.Pattern$GroupTail.match(Pattern.java:4847)
        	at java.base/java.util.regex.Pattern$BmpCharPropertyGreedy.match(Pattern.java:4356)
        	at java.base/java.util.regex.Pattern$GroupHead.match(Pattern.java:4816)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4761)
        	at java.base/java.util.regex.Pattern$Branch.match(Pattern.java:4759)
        	at java.base/java.util.regex.Pattern$BmpCharProperty.match(Pattern.java:3982)
        	at java.base/java.util.regex.Pattern$Start.match(Pattern.java:3635)
        	at java.base/java.util.regex.Matcher.search(Matcher.java:1728)
        	at java.base/java.util.regex.Matcher.find(Matcher.java:772)
        	at java.base/java.util.Formatter.parse(Formatter.java:2746)
        	at java.base/java.util.Formatter.format(Formatter.java:2671)
        	at java.base/java.util.Formatter.format(Formatter.java:2625)
        	at java.base/java.lang.String.format(String.java:4145)
        	at jadx.core.utils.InsnUtils.formatOffset(InsnUtils.java:40)
        	at jadx.core.dex.nodes.BlockNode.toString(BlockNode.java:280)
        	at java.base/java.lang.String.valueOf(String.java:4220)
        	at jadx.core.dex.attributes.nodes.LoopInfo.toString(LoopInfo.java:109)
        	at java.base/java.lang.String.valueOf(String.java:4220)
        	at java.base/java.util.Objects.toString(Objects.java:147)
        	at jadx.core.utils.Utils.listToString(Utils.java:207)
        	at jadx.core.utils.Utils.listToString(Utils.java:193)
        	at jadx.core.utils.Utils.listToString(Utils.java:184)
        	at jadx.core.dex.attributes.AttrList.toString(AttrList.java:32)
        */
    public static int next(com.alibaba.fastjson2.JSONReaderUTF16 r7, char[] r8, int r9, int r10) {
        /*
            r0 = 26
            if (r9 != r10) goto L7
            r1 = r9
        L5:
            r9 = r0
            goto Lb
        L7:
            int r1 = r9 + 1
            char r9 = r8[r9]
        Lb:
            if (r9 == 0) goto L31
            r2 = 32
            if (r9 > r2) goto L21
            r2 = 1
            long r2 = r2 << r9
            r4 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r2 = r2 & r4
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            goto L31
        L21:
            char r8 = (char) r9
            r7.ch = r8
            r8 = 47
            if (r9 != r8) goto L30
            r7.offset = r1
            r7.skipComment()
            int r7 = r7.offset
            return r7
        L30:
            return r1
        L31:
            if (r1 != r10) goto L34
            goto L5
        L34:
            int r9 = r1 + 1
            char r1 = r8[r1]
            r6 = r1
            r1 = r9
            r9 = r6
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.next(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):int");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0030 -> B:11:0x0017). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:14:0x001f
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean nextIfSet(com.alibaba.fastjson2.JSONReaderUTF16 r7, char[] r8, int r9, int r10) {
        /*
            int r0 = r9 + 1
            if (r0 >= r10) goto L41
            char r1 = r8[r9]
            r2 = 101(0x65, float:1.42E-43)
            if (r1 != r2) goto L41
            char r0 = r8[r0]
            r1 = 116(0x74, float:1.63E-43)
            if (r0 != r1) goto L41
            int r0 = r9 + 2
            r1 = 26
            if (r0 != r10) goto L19
            r9 = r0
        L17:
            r0 = r1
            goto L1d
        L19:
            int r9 = r9 + 3
            char r0 = r8[r0]
        L1d:
            r2 = 32
            if (r0 > r2) goto L3b
            r2 = 1
            long r2 = r2 << r0
            r4 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r2 = r2 & r4
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L3b
            if (r9 != r10) goto L33
            goto L17
        L33:
            int r0 = r9 + 1
            char r9 = r8[r9]
            r6 = r0
            r0 = r9
            r9 = r6
            goto L1d
        L3b:
            r7.offset = r9
            r7.ch = r0
            r7 = 1
            return r7
        L41:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfSet(com.alibaba.fastjson2.JSONReaderUTF16, char[], int, int):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003b -> B:14:0x001f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:17:0x0028
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatchIdent(char r8, char r9, char r10) {
        /*
            r7 = this;
            char r0 = r7.ch
            r1 = 0
            if (r0 == r8) goto L6
            return r1
        L6:
            char[] r8 = r7.chars
            int r0 = r7.offset
            int r2 = r0 + 2
            int r3 = r7.end
            if (r2 > r3) goto L6c
            char r4 = r8[r0]
            if (r4 != r9) goto L6c
            int r9 = r0 + 1
            char r9 = r8[r9]
            if (r9 == r10) goto L1b
            goto L6c
        L1b:
            r9 = 26
            if (r2 != r3) goto L21
        L1f:
            r10 = r9
            goto L26
        L21:
            int r0 = r0 + 3
            char r10 = r8[r2]
            r2 = r0
        L26:
            r0 = 32
            if (r10 > r0) goto L45
            r3 = 1
            long r3 = r3 << r10
            r5 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r3 = r3 & r5
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L45
            int r10 = r7.end
            if (r2 != r10) goto L3e
            goto L1f
        L3e:
            int r10 = r2 + 1
            char r0 = r8[r2]
            r2 = r10
            r10 = r0
            goto L26
        L45:
            int r8 = r7.offset
            int r8 = r8 + 3
            if (r2 != r8) goto L66
            if (r10 == r9) goto L66
            r8 = 40
            if (r10 == r8) goto L66
            r8 = 91
            if (r10 == r8) goto L66
            r8 = 93
            if (r10 == r8) goto L66
            r8 = 41
            if (r10 == r8) goto L66
            r8 = 58
            if (r10 == r8) goto L66
            r8 = 44
            if (r10 == r8) goto L66
            return r1
        L66:
            r7.offset = r2
            r7.ch = r10
            r8 = 1
            return r8
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatchIdent(char, char, char):boolean");
    }

    @Override // com.alibaba.fastjson2.JSONReader
    public final void skipValue() {
        this.offset = skipValue(this, this.chars, this.offset, this.end);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0041 -> B:16:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:19:0x002e
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatchIdent(char r8, char r9, char r10, char r11) {
        /*
            r7 = this;
            char r0 = r7.ch
            r1 = 0
            if (r0 == r8) goto L6
            return r1
        L6:
            char[] r8 = r7.chars
            int r0 = r7.offset
            int r2 = r0 + 3
            int r3 = r7.end
            if (r2 > r3) goto L72
            char r4 = r8[r0]
            if (r4 != r9) goto L72
            int r9 = r0 + 1
            char r9 = r8[r9]
            if (r9 != r10) goto L72
            int r9 = r0 + 2
            char r9 = r8[r9]
            if (r9 == r11) goto L21
            goto L72
        L21:
            r9 = 26
            if (r2 != r3) goto L27
        L25:
            r10 = r9
            goto L2c
        L27:
            int r0 = r0 + 4
            char r10 = r8[r2]
            r2 = r0
        L2c:
            r11 = 32
            if (r10 > r11) goto L4b
            r3 = 1
            long r3 = r3 << r10
            r5 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r3 = r3 & r5
            r5 = 0
            int r11 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r11 == 0) goto L4b
            int r10 = r7.end
            if (r2 != r10) goto L44
            goto L25
        L44:
            int r10 = r2 + 1
            char r11 = r8[r2]
            r2 = r10
            r10 = r11
            goto L2c
        L4b:
            int r8 = r7.offset
            int r8 = r8 + 4
            if (r2 != r8) goto L6c
            if (r10 == r9) goto L6c
            r8 = 40
            if (r10 == r8) goto L6c
            r8 = 91
            if (r10 == r8) goto L6c
            r8 = 93
            if (r10 == r8) goto L6c
            r8 = 41
            if (r10 == r8) goto L6c
            r8 = 58
            if (r10 == r8) goto L6c
            r8 = 44
            if (r10 == r8) goto L6c
            return r1
        L6c:
            r7.offset = r2
            r7.ch = r10
            r8 = 1
            return r8
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatchIdent(char, char, char, char):boolean");
    }

    public JSONReaderUTF16(JSONReader.Context context, Reader reader) {
        char c;
        super(context, false, false);
        this.cacheIndex = -1;
        this.input = reader;
        int iIdentityHashCode = System.identityHashCode(Thread.currentThread());
        JSONFactory.CacheItem[] cacheItemArr = JSONFactory.CACHE_ITEMS;
        int length = iIdentityHashCode & (cacheItemArr.length - 1);
        this.cacheIndex = length;
        char[] andSet = JSONFactory.CHARS_UPDATER.getAndSet(cacheItemArr[length], null);
        andSet = andSet == null ? new char[8192] : andSet;
        int i = 0;
        while (true) {
            try {
                int i2 = reader.read(andSet, i, andSet.length - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
                if (i == andSet.length) {
                    int length2 = andSet.length;
                    andSet = Arrays.copyOf(andSet, length2 + (length2 >> 1));
                }
            } catch (IOException e) {
                throw new JSONException("read error", e);
            }
        }
        this.str = null;
        this.chars = andSet;
        this.offset = 0;
        this.length = i;
        this.start = 0;
        this.end = i;
        if (i <= 0) {
            this.ch = (char) 26;
            return;
        }
        this.ch = andSet[0];
        while (true) {
            c = this.ch;
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            int i3 = this.offset + 1;
            this.offset = i3;
            if (i3 >= this.length) {
                this.ch = (char) 26;
                return;
            }
            this.ch = andSet[i3];
        }
        this.offset++;
        if (c == 65534 || c == 65279) {
            next();
        }
        if (this.ch == '/') {
            skipComment();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0047 -> B:18:0x002b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:21:0x0034
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatchIdent(char r6, char r7, char r8, char r9, char r10) {
        /*
            r5 = this;
            char r0 = r5.ch
            r1 = 0
            if (r0 == r6) goto L6
            return r1
        L6:
            char[] r6 = r5.chars
            int r0 = r5.offset
            int r2 = r0 + 4
            int r3 = r5.end
            if (r2 > r3) goto L78
            char r4 = r6[r0]
            if (r4 != r7) goto L78
            int r7 = r0 + 1
            char r7 = r6[r7]
            if (r7 != r8) goto L78
            int r7 = r0 + 2
            char r7 = r6[r7]
            if (r7 != r9) goto L78
            int r7 = r0 + 3
            char r7 = r6[r7]
            if (r7 == r10) goto L27
            goto L78
        L27:
            r7 = 26
            if (r2 != r3) goto L2d
        L2b:
            r8 = r7
            goto L32
        L2d:
            int r0 = r0 + 5
            char r8 = r6[r2]
            r2 = r0
        L32:
            r9 = 32
            if (r8 > r9) goto L51
            r9 = 1
            long r9 = r9 << r8
            r3 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r9 = r9 & r3
            r3 = 0
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 == 0) goto L51
            int r8 = r5.end
            if (r2 != r8) goto L4a
            goto L2b
        L4a:
            int r8 = r2 + 1
            char r9 = r6[r2]
            r2 = r8
            r8 = r9
            goto L32
        L51:
            int r6 = r5.offset
            int r6 = r6 + 5
            if (r2 != r6) goto L72
            if (r8 == r7) goto L72
            r6 = 40
            if (r8 == r6) goto L72
            r6 = 91
            if (r8 == r6) goto L72
            r6 = 93
            if (r8 == r6) goto L72
            r6 = 41
            if (r8 == r6) goto L72
            r6 = 58
            if (r8 == r6) goto L72
            r6 = 44
            if (r8 == r6) goto L72
            return r1
        L72:
            r5.offset = r2
            r5.ch = r8
            r6 = 1
            return r6
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatchIdent(char, char, char, char, char):boolean");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x004d -> B:20:0x0031). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:23:0x003a
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:118)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:108)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:68)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // com.alibaba.fastjson2.JSONReader
    public final boolean nextIfMatchIdent(char r6, char r7, char r8, char r9, char r10, char r11) {
        /*
            r5 = this;
            char r0 = r5.ch
            r1 = 0
            if (r0 == r6) goto L6
            return r1
        L6:
            char[] r6 = r5.chars
            int r0 = r5.offset
            int r2 = r0 + 5
            int r3 = r5.end
            if (r2 > r3) goto L7e
            char r4 = r6[r0]
            if (r4 != r7) goto L7e
            int r7 = r0 + 1
            char r7 = r6[r7]
            if (r7 != r8) goto L7e
            int r7 = r0 + 2
            char r7 = r6[r7]
            if (r7 != r9) goto L7e
            int r7 = r0 + 3
            char r7 = r6[r7]
            if (r7 != r10) goto L7e
            int r7 = r0 + 4
            char r7 = r6[r7]
            if (r7 == r11) goto L2d
            goto L7e
        L2d:
            r7 = 26
            if (r2 != r3) goto L33
        L31:
            r8 = r7
            goto L38
        L33:
            int r0 = r0 + 6
            char r8 = r6[r2]
            r2 = r0
        L38:
            r9 = 32
            if (r8 > r9) goto L57
            r9 = 1
            long r9 = r9 << r8
            r3 = 4294981376(0x100003700, double:2.1220027474E-314)
            long r9 = r9 & r3
            r3 = 0
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 == 0) goto L57
            int r8 = r5.end
            if (r2 != r8) goto L50
            goto L31
        L50:
            int r8 = r2 + 1
            char r9 = r6[r2]
            r2 = r8
            r8 = r9
            goto L38
        L57:
            int r6 = r5.offset
            int r6 = r6 + 6
            if (r2 != r6) goto L78
            if (r8 == r7) goto L78
            r6 = 40
            if (r8 == r6) goto L78
            r6 = 91
            if (r8 == r6) goto L78
            r6 = 93
            if (r8 == r6) goto L78
            r6 = 41
            if (r8 == r6) goto L78
            r6 = 58
            if (r8 == r6) goto L78
            r6 = 44
            if (r8 == r6) goto L78
            return r1
        L78:
            r5.offset = r2
            r5.ch = r8
            r6 = 1
            return r6
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONReaderUTF16.nextIfMatchIdent(char, char, char, char, char, char):boolean");
    }

    public JSONReaderUTF16(JSONReader.Context context, String str, int i, int i2) {
        char c;
        super(context, false, false);
        this.cacheIndex = -1;
        int iIdentityHashCode = System.identityHashCode(Thread.currentThread());
        JSONFactory.CacheItem[] cacheItemArr = JSONFactory.CACHE_ITEMS;
        int length = iIdentityHashCode & (cacheItemArr.length - 1);
        this.cacheIndex = length;
        char[] andSet = JSONFactory.CHARS_UPDATER.getAndSet(cacheItemArr[length], null);
        andSet = (andSet == null || andSet.length < i2) ? new char[Math.max(i2, 8192)] : andSet;
        str.getChars(i, i + i2, andSet, 0);
        this.str = i != 0 ? null : str;
        this.chars = andSet;
        this.offset = 0;
        this.length = i2;
        this.start = 0;
        this.end = i2;
        if (i2 <= 0) {
            this.ch = (char) 26;
            return;
        }
        this.ch = andSet[0];
        while (true) {
            c = this.ch;
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            int i3 = this.offset + 1;
            this.offset = i3;
            if (i3 >= this.length) {
                this.ch = (char) 26;
                return;
            }
            this.ch = andSet[i3];
        }
        this.offset++;
        if (c == 65534 || c == 65279) {
            next();
        }
        if (this.ch == '/') {
            skipComment();
        }
    }

    public JSONReaderUTF16(JSONReader.Context context, String str, char[] cArr, int i, int i2) {
        char c;
        super(context, false, false);
        this.cacheIndex = -1;
        this.str = str;
        this.chars = cArr;
        this.offset = i;
        this.length = i2;
        this.start = i;
        int i3 = i + i2;
        this.end = i3;
        if (i >= i3) {
            this.ch = (char) 26;
            return;
        }
        this.ch = cArr[i];
        while (true) {
            c = this.ch;
            if (c > ' ' || ((1 << c) & 4294981376L) == 0) {
                break;
            }
            int i4 = this.offset + 1;
            this.offset = i4;
            if (i4 >= i2) {
                this.ch = (char) 26;
                return;
            }
            this.ch = cArr[i4];
        }
        this.offset++;
        if (c == 65534 || c == 65279) {
            next();
        }
        if (this.ch == '/') {
            skipComment();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSONReaderUTF16(JSONReader.Context context, InputStream inputStream) {
        super(context, false, false);
        int i = 0;
        this.cacheIndex = -1;
        this.input = inputStream;
        int iIdentityHashCode = System.identityHashCode(Thread.currentThread());
        JSONFactory.CacheItem[] cacheItemArr = JSONFactory.CACHE_ITEMS;
        JSONFactory.CacheItem cacheItem = cacheItemArr[iIdentityHashCode & (cacheItemArr.length - 1)];
        byte[] andSet = JSONFactory.BYTES_UPDATER.getAndSet(cacheItem, null);
        int i2 = context.bufferSize;
        andSet = andSet == null ? new byte[i2] : andSet;
        int i3 = 0;
        while (true) {
            try {
                try {
                    int i4 = inputStream.read(andSet, i3, andSet.length - i3);
                    if (i4 == -1) {
                        break;
                    }
                    i3 += i4;
                    if (i3 == andSet.length) {
                        andSet = Arrays.copyOf(andSet, andSet.length + i2);
                    }
                } catch (IOException e) {
                    throw new JSONException("read error", e);
                }
            } catch (Throwable th) {
                JSONFactory.BYTES_UPDATER.lazySet(cacheItem, andSet);
                throw th;
            }
        }
        if (i3 % 2 != 1) {
            int i5 = i3 / 2;
            char[] cArr = new char[i5];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i3) {
                cArr[i7] = (char) (((andSet[i6] & 255) << 8) | (andSet[i6 + 1] & 255));
                i6 += 2;
                i7++;
            }
            JSONFactory.BYTES_UPDATER.lazySet(cacheItem, andSet);
            this.str = null;
            this.chars = cArr;
            this.offset = 0;
            this.length = i5;
            this.start = 0;
            this.end = i5;
            if (i5 == 0) {
                this.ch = (char) 26;
                return;
            }
            char c = cArr[0];
            while (c <= ' ' && ((1 << c) & 4294981376L) != 0) {
                i++;
                if (i >= i5) {
                    this.ch = (char) 26;
                    return;
                }
                c = cArr[i];
            }
            this.ch = c;
            this.offset++;
            if (c == 65534 || c == 65279) {
                next();
            }
            if (this.ch == '/') {
                skipComment();
                return;
            }
            return;
        }
        throw new JSONException("illegal input utf16 bytes, length " + i3);
    }
}
