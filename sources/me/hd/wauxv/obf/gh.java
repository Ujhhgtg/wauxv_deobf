package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gh extends SwitchHook implements IDatabaseOperationsListener {
    public static final gh a = new gh("AntiSnsDeleteHook" /* "AntiSnsDeleteHook" /* "AntiSnsDeleteHook" /* cnb.z(-545009875024682L)  */);
    public static final String b = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-544674867575594L)  */;
    public static final String c = "拦截朋友圈删除" /* "拦截朋友圈删除" /* "拦截朋友圈删除" /* cnb.z(-544692047444778L)  */;
    public static final String d = "拦截朋友晚上偷偷删除的美图及其热评" /* "拦截朋友晚上偷偷删除的美图及其热评" /* "拦截朋友晚上偷偷删除的美图及其热评" /* cnb.z(-544657687706410L)  */;
    public static final bn h = new bn(28);

    public static Pair i(int i, byte[] bArr) {
        int i2 = bArr[i];
        int i3 = 1;
        if (i2 < 0) {
            i2 = (i2 & 127) + (bArr[i + 1] << 7);
            i3 = 2;
        }
        return new Pair(Integer.valueOf(i3), Integer.valueOf(i2));
    }

    public static byte[] k(int i) {
        int i2 = i >> 7;
        return i2 > 0 ? new byte[] { (byte) ((i & 127) | 128), (byte) i2 } : new byte[] { (byte) i };
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void j(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr, int i) {
        m(str, contentValues);
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void l(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr, int i) {
        m(str, contentValues);
    }

    public final void m(String str, ContentValues contentValues) {
        if (getIsEnabled()) {
            byte[] bArrV = null;
            if (str.equals("SnsInfo" /* "SnsInfo" /* "SnsInfo" /* cnb.z(-544881026005802L)  */)) {
                if (aaz.tryGetClassByName(
                        OtherStaticHelpers.argsToList(Integer.valueOf(ewj.a.h), Integer.valueOf(ewj.b.h), Integer.valueOf(ewj.c.h),
                                Integer.valueOf(ewj.d.h), Integer.valueOf(ewj.f.h)),
                        contentValues.get("type" /* "type" /* "type" /* cnb.z(-544846666267434L)  */))
                        && nullSafeIsEqual(contentValues.get("sourceType" /* "sourceType" /* "sourceType" /* cnb.z(-544876731038506L)  */), 0)) {
                    byte[] bArr = (byte[]) contentValues.get("content" /* "content" /* "content" /* cnb.z(-545327702604586L)  */);
                    contentValues.remove("sourceType" /* "sourceType" /* "sourceType" /* cnb.z(-545293342866218L)  */);
                    String strZ = "content" /* "content" /* "content" /* cnb.z(-545280457964330L)  */;
                    String strO = gg.a.o();
                    if (bArr != null) {
                        int iR = SomeStaticHelpers.r(bArr, (byte) 42) + 1;
                        Pair pairVarI = i(iR, bArr);
                        int iIntValue = ((Number) pairVarI.first).intValue();
                        int iIntValue2 = ((Number) pairVarI.second).intValue();
                        int i = iIntValue + iR;
                        byte[] bArrX = SomeStaticHelpers.x(bArr, dqc.bm(i, bArr.length));
                        Charset charset = uj.a;
                        if (dnr.bp(new String(bArrX, charset), strO, false)) {
                            bArrV = bArr;
                        } else {
                            byte[] bytes = strO.concat(" ").getBytes(charset);
                            throwIfVar1IsNull(bytes, "getBytes(...)" /* "getBytes(...)" /* "getBytes(...)" /* cnb.z(-544430054439722L)  */);
                            byte[] bArrV2 = SomeStaticHelpers.v(SomeStaticHelpers._ap(0, iR, bArr), k(bytes.length + iIntValue2));
                            byte[] bytes2 = strO.concat(" ").getBytes(charset);
                            throwIfVar1IsNull(bytes2, "getBytes(...)" /* "getBytes(...)" /* "getBytes(...)" /* cnb.z(-544352745028394L)  */);
                            bArrV = SomeStaticHelpers.v(SomeStaticHelpers.v(bArrV2, bytes2), SomeStaticHelpers._ap(i, bArr.length, bArr));
                        }
                    }
                    contentValues.put(strZ, bArrV);
                    return;
                }
                return;
            }
            if (str.equals("SnsComment" /* "SnsComment" /* "SnsComment" /* cnb.z(-545246098225962L)  */)
                    && !nullSafeIsEqual(contentValues.get("type" /* "type" /* "type" /* cnb.z(-545216033454890L)  */), 1)
                    && nullSafeIsEqual(contentValues.get("commentflag" /* "commentflag" /* "commentflag" /* cnb.z(-545177378749226L)  */), 1)) {
                byte[] bArr2 = (byte[]) contentValues.get("curActionBuf" /* "curActionBuf" /* "curActionBuf" /* cnb.z(-545091479403306L)  */);
                contentValues.remove("commentflag" /* "commentflag" /* "commentflag" /* cnb.z(-544520248752938L)  */);
                String strZ2 = "curActionBuf" /* "curActionBuf" /* "curActionBuf" /* cnb.z(-544434349407018L)  */;
                String strO2 = gg.a.o();
                if (bArr2 != null) {
                    int iR2 = SomeStaticHelpers.r(bArr2, (byte) 34);
                    int i2 = iR2 + bArr2[iR2 + 1] + 13;
                    Pair pairVarI2 = i(i2, bArr2);
                    int iIntValue3 = ((Number) pairVarI2.first).intValue();
                    int iIntValue4 = ((Number) pairVarI2.second).intValue();
                    int i3 = iIntValue3 + i2;
                    byte[] bArrX2 = SomeStaticHelpers.x(bArr2, dqc.bm(i3, bArr2.length));
                    Charset charset2 = uj.a;
                    if (dnr.bp(new String(bArrX2, charset2), strO2, false)) {
                        bArrV = bArr2;
                    } else {
                        byte[] bytes3 = strO2.concat(" ").getBytes(charset2);
                        throwIfVar1IsNull(bytes3, "getBytes(...)" /* "getBytes(...)" /* "getBytes(...)" /* cnb.z(-544275435617066L)  */);
                        byte[] bArrV3 = SomeStaticHelpers.v(SomeStaticHelpers._ap(0, i2, bArr2), k(bytes3.length + iIntValue4));
                        byte[] bytes4 = strO2.concat(" ").getBytes(charset2);
                        throwIfVar1IsNull(bytes4, "getBytes(...)" /* "getBytes(...)" /* "getBytes(...)" /* cnb.z(-544747882019626L)  */);
                        bArrV = SomeStaticHelpers.v(SomeStaticHelpers.v(bArrV3, bytes4), SomeStaticHelpers._ap(i3, bArr2.length, bArr2));
                    }
                }
                contentValues.put(strZ2, bArrV);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return h;
    }
}
