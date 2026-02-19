package okhttp3.internal.publicsuffix;

import com.android.dx.io.Opcodes;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.aqg;
import me.hd.wauxv.obf.aqh;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.bjr;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.cqj;
import me.hd.wauxv.obf.cyl;
import me.hd.wauxv.obf.dft;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.ekc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.ln;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = { 42 };
    private static final List<String> PREVAILING_RULE = dqc.toSingletonList("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int iAnd;
            boolean z;
            int iAnd2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iAnd = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        iAnd = Util.and(bArr2[i8][i9], Opcodes.CONST_METHOD_TYPE);
                        z = z3;
                    }
                    iAnd2 = iAnd - Util.and(bArr[i5 + i10], Opcodes.CONST_METHOD_TYPE);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset charset = StandardCharsets.UTF_8;
                                throwIfVar1IsNull(charset, "UTF_8");
                                return new String(bArr, i5, i7, charset);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strBinarySearch;
        String strBinarySearch2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str2 = list.get(i);
            Charset charset = StandardCharsets.UTF_8;
            throwIfVar1IsNull(charset, "UTF_8");
            byte[] bytes = str2.getBytes(charset);
            throwIfVar1IsNull(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strBinarySearch = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                throwLateinitPropNotInitYet("publicSuffixListBytes");
                throw null;
            }
            strBinarySearch = companion.binarySearch(bArr2, bArr, i2);
            if (strBinarySearch != null) {
                break;
            }
            i2++;
        }
        if (size <= 1) {
            strBinarySearch2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                strBinarySearch2 = null;
                break;
            }
            bArr3[i3] = WILDCARD_LABEL;
            Companion companion2 = Companion;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                throwLateinitPropNotInitYet("publicSuffixListBytes");
                throw null;
            }
            strBinarySearch2 = companion2.binarySearch(bArr4, bArr3, i3);
            if (strBinarySearch2 != null) {
                break;
            }
            i3++;
        }
        if (strBinarySearch2 != null) {
            int i4 = size - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    throwLateinitPropNotInitYet("publicSuffixExceptionListBytes");
                    throw null;
                }
                String strBinarySearch3 = companion3.binarySearch(bArr5, bArr, i5);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
            }
        }
        if (str != null) {
            return dnj.ar("!".concat(str),
                    new char[] { TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH });
        }
        if (strBinarySearch == null && strBinarySearch2 == null) {
            return PREVAILING_RULE;
        }
        List<String> listAr = EmptyReadonlyList.INSTANCE;
        List<String> listAr2 = strBinarySearch != null ? dnj.ar(strBinarySearch,
                new char[] { TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH }) : listAr;
        if (strBinarySearch2 != null) {
            listAr = dnj.ar(strBinarySearch2,
                    new char[] { TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH });
        }
        return listAr2.size() > listAr.size() ? listAr2 : listAr;
    }

    private final void readTheList() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
            if (resourceAsStream != null) {
                Logger logger = cqj.a;
                cyl cylVarAh = emc.ah(new bjr(new ln(resourceAsStream, new ekc())));
                try {
                    long j = cylVarAh.readInt();
                    cylVarAh.ah(j);
                    byte[] bArrY = cylVarAh.b.y(j);
                    long j2 = cylVarAh.readInt();
                    cylVarAh.ah(j2);
                    byte[] bArrY2 = cylVarAh.b.y(j2);
                    cylVarAh.close();
                    synchronized (this) {
                        this.publicSuffixListBytes = bArrY;
                        this.publicSuffixExceptionListBytes = bArrY2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        cnh.m(cylVarAh, th);
                        throw th2;
                    }
                }
            }
            this.readCompleteLatch.countDown();
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e);
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    private final List<String> splitDomain(String str) {
        List<String> listAr = dnj.ar(str,
                new char[] { TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH });
        if (!nullSafeIsEqual(StaticHelpers5.l(listAr), "")) {
            return listAr;
        }
        int size = listAr.size() - 1;
        return StaticHelpers5.u(size >= 0 ? size : 0, listAr);
    }

    public final String getEffectiveTldPlusOne(String str) {
        int size;
        int size2;
        throwIfVar1IsNull(str, "domain");
        String unicode = IDN.toUnicode(str);
        throwIfVar1IsNull(unicode, "unicodeDomain");
        List<String> listSplitDomain = splitDomain(unicode);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        int i = 0;
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        int i2 = size - size2;
        dft dftVarA = StaticHelpers5.a(splitDomain(str));
        if (i2 < 0) {
            throw new IllegalArgumentException(yg.f(i2, "Requested element count ", " is less than zero.").toString());
        }
        if (i2 != 0) {
            dftVarA = dftVarA instanceof aqh ? ((aqh) dftVarA).c(i2) : new aqg(dftVarA, i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : dftVarA) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ".");
            }
            aye.transformToAppend(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void setListBytes(byte[] bArr, byte[] bArr2) {
        throwIfVar1IsNull(bArr, "publicSuffixListBytes");
        throwIfVar1IsNull(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
