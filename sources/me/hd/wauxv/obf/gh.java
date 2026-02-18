package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gh extends doo implements bob {
    public static final gh a = new gh("AntiSnsDeleteHook" /* cnb.z(-545009875024682L) */);
    public static final String b = "朋友圈" /* cnb.z(-544674867575594L) */;
    public static final String c = "拦截朋友圈删除" /* cnb.z(-544692047444778L) */;
    public static final String d = "拦截朋友晚上偷偷删除的美图及其热评" /* cnb.z(-544657687706410L) */;
    public static final bn h = new bn(28);

    public static csm i(int i, byte[] bArr) {
        int i2 = bArr[i];
        int i3 = 1;
        if (i2 < 0) {
            i2 = (i2 & 127) + (bArr[i + 1] << 7);
            i3 = 2;
        }
        return new csm(Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static byte[] k(int i) {
        int i2 = i >> 7;
        return i2 > 0 ? new byte[]{(byte) ((i & 127) | 128), (byte) i2} : new byte[]{(byte) i};
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bob
    public final void j(bmm bmmVar, String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        m(str, contentValues);
    }

    @Override // me.hd.wauxv.obf.bob
    public final void l(bmm bmmVar, String str, ContentValues contentValues, String str2, String[] strArr, int i) {
        m(str, contentValues);
    }

    public final void m(String str, ContentValues contentValues) {
        if (z()) {
            byte[] bArrV = null;
            if (str.equals("SnsInfo" /* cnb.z(-544881026005802L) */)) {
                if (aaz.b(aba.ag(Integer.valueOf(ewj.a.h), Integer.valueOf(ewj.b.h), Integer.valueOf(ewj.c.h), Integer.valueOf(ewj.d.h), Integer.valueOf(ewj.f.h)), contentValues.get("type" /* cnb.z(-544846666267434L) */)) && bzo.f(contentValues.get("sourceType" /* cnb.z(-544876731038506L) */), 0)) {
                    byte[] bArr = (byte[]) contentValues.get("content" /* cnb.z(-545327702604586L) */);
                    contentValues.remove("sourceType" /* cnb.z(-545293342866218L) */);
                    String strZ = "content" /* cnb.z(-545280457964330L) */;
                    String strO = gg.a.o();
                    if (bArr != null) {
                        int iR = la.r(bArr, (byte) 42) + 1;
                        csm csmVarI = i(iR, bArr);
                        int iIntValue = ((Number) csmVarI.a).intValue();
                        int iIntValue2 = ((Number) csmVarI.b).intValue();
                        int i = iIntValue + iR;
                        byte[] bArrX = la.x(bArr, dqc.bm(i, bArr.length));
                        Charset charset = uj.a;
                        if (dnr.bp(new String(bArrX, charset), strO, false)) {
                            bArrV = bArr;
                        } else {
                            byte[] bytes = strO.concat(" ").getBytes(charset);
                            bzo.p(bytes, "getBytes(...)" /* cnb.z(-544430054439722L) */);
                            byte[] bArrV2 = la.v(la._ap(0, iR, bArr), k(bytes.length + iIntValue2));
                            byte[] bytes2 = strO.concat(" ").getBytes(charset);
                            bzo.p(bytes2, "getBytes(...)" /* cnb.z(-544352745028394L) */);
                            bArrV = la.v(la.v(bArrV2, bytes2), la._ap(i, bArr.length, bArr));
                        }
                    }
                    contentValues.put(strZ, bArrV);
                    return;
                }
                return;
            }
            if (str.equals("SnsComment" /* cnb.z(-545246098225962L) */) && !bzo.f(contentValues.get("type" /* cnb.z(-545216033454890L) */), 1) && bzo.f(contentValues.get("commentflag" /* cnb.z(-545177378749226L) */), 1)) {
                byte[] bArr2 = (byte[]) contentValues.get("curActionBuf" /* cnb.z(-545091479403306L) */);
                contentValues.remove("commentflag" /* cnb.z(-544520248752938L) */);
                String strZ2 = "curActionBuf" /* cnb.z(-544434349407018L) */;
                String strO2 = gg.a.o();
                if (bArr2 != null) {
                    int iR2 = la.r(bArr2, (byte) 34);
                    int i2 = iR2 + bArr2[iR2 + 1] + 13;
                    csm csmVarI2 = i(i2, bArr2);
                    int iIntValue3 = ((Number) csmVarI2.a).intValue();
                    int iIntValue4 = ((Number) csmVarI2.b).intValue();
                    int i3 = iIntValue3 + i2;
                    byte[] bArrX2 = la.x(bArr2, dqc.bm(i3, bArr2.length));
                    Charset charset2 = uj.a;
                    if (dnr.bp(new String(bArrX2, charset2), strO2, false)) {
                        bArrV = bArr2;
                    } else {
                        byte[] bytes3 = strO2.concat(" ").getBytes(charset2);
                        bzo.p(bytes3, "getBytes(...)" /* cnb.z(-544275435617066L) */);
                        byte[] bArrV3 = la.v(la._ap(0, i2, bArr2), k(bytes3.length + iIntValue4));
                        byte[] bytes4 = strO2.concat(" ").getBytes(charset2);
                        bzo.p(bytes4, "getBytes(...)" /* cnb.z(-544747882019626L) */);
                        bArrV = la.v(la.v(bArrV3, bytes4), la._ap(i3, bArr2.length, bArr2));
                    }
                }
                contentValues.put(strZ2, bArrV);
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return h;
    }
}
