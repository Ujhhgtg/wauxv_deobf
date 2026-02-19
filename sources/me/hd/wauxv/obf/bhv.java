package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bhv {
    public static final float[][] f = { new float[] { 0.401288f, 0.650173f, -0.051461f },
            new float[] { -0.250268f, 1.204414f, 0.045854f }, new float[] { -0.002079f, 0.048952f, 0.953127f } };
    public static final float[][] g = { new float[] { 1.8620678f, -1.0112547f, 0.14918678f },
            new float[] { 0.38752654f, 0.62144744f, -0.00897398f },
            new float[] { -0.0158415f, -0.03412294f, 1.0499644f } };
    public static final float[] h = { 95.047f, 100.0f, 108.883f };
    public static final float[][] i = { new float[] { 0.41233894f, 0.35762063f, 0.18051042f },
            new float[] { 0.2126f, 0.7152f, 0.0722f }, new float[] { 0.01932141f, 0.11916382f, 0.9503448f } };
    public static final SpecificEmojiMatcher j = new SpecificEmojiMatcher("COMPLETING_ALREADY", 1);
    public static final SpecificEmojiMatcher k = new SpecificEmojiMatcher("COMPLETING_WAITING_CHILDREN", 1);
    public static final SpecificEmojiMatcher l = new SpecificEmojiMatcher("COMPLETING_RETRY", 1);
    public static final SpecificEmojiMatcher m = new SpecificEmojiMatcher("TOO_LATE_TO_CANCEL", 1);
    public static final SpecificEmojiMatcher n = new SpecificEmojiMatcher("SEALED", 1);
    public static final aux o = new aux(false);
    public static final aux p = new aux(true);
    public static final SpecificEmojiMatcher q = new SpecificEmojiMatcher("NO_THREAD_ELEMENTS", 1);
    public static final dfq r = new dfq(10);
    public static final dfq s = new dfq(11);
    public static final dfq t = new dfq(12);

    public static ImageHeaderParser$ImageType aa(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeJ = ((bog) list.get(i2)).j(byteBuffer);
                AtomicReference atomicReference = sf.a;
                if (imageHeaderParser$ImageTypeJ != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeJ;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = sf.a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static void ab(ayd aydVar, String str) {
        Log.i("FastKV", aydVar.e + " " + str);
    }

    public static int ac(float f2) {
        if (f2 < 1.0f) {
            return -16777216;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = h;
        return abi.b(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static final void ad(CancellableContinuation cancellableContinuationVar, sz szVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = CancellableContinuation.d;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(cancellableContinuationVar);
            if (obj instanceof db) {
                while (!atomicReferenceFieldUpdater.compareAndSet(cancellableContinuationVar, obj, szVar)) {
                    if (atomicReferenceFieldUpdater.get(cancellableContinuationVar) != obj) {
                    }
                }
                return;
            }
            Throwable th = null;
            if (obj instanceof sz) {
                CancellableContinuation.h(szVar, obj);
                throw null;
            }
            if (obj instanceof abr) {
                abr abrVar = (abr) obj;
                if (!abr.b.compareAndSet(abrVar, 0, 1)) {
                    CancellableContinuation.h(szVar, obj);
                    throw null;
                }
                if (obj instanceof td) {
                    cancellableContinuationVar.p(szVar, abrVar.c);
                    return;
                }
                return;
            }
            if (!(obj instanceof abp)) {
                abp abpVar = new abp(obj, szVar, th, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(cancellableContinuationVar, obj, abpVar)) {
                    if (atomicReferenceFieldUpdater.get(cancellableContinuationVar) != obj) {
                    }
                }
                return;
            }
            abp abpVar2 = (abp) obj;
            if (abpVar2.b != null) {
                CancellableContinuation.h(szVar, obj);
                throw null;
            }
            Throwable th2 = abpVar2.e;
            if (th2 != null) {
                cancellableContinuationVar.p(szVar, th2);
                return;
            }
            abp abpVarF = abp.f(abpVar2, szVar, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(cancellableContinuationVar, obj, abpVarF)) {
                if (atomicReferenceFieldUpdater.get(cancellableContinuationVar) != obj) {
                }
            }
            return;
        }
    }

    public static float ae(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static byte[] af(File file) {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        }
        if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        }
        if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        }
        long length = file.length();
        int i2 = (int) length;
        if (i2 != length) {
            throw new RuntimeException(file + ": file too long");
        }
        byte[] bArr = new byte[i2];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int i3 = 0;
            while (i2 > 0) {
                int i4 = fileInputStream.read(bArr, i3, i2);
                if (i4 == -1) {
                    throw new RuntimeException(file + ": unexpected EOF");
                }
                i3 += i4;
                i2 -= i4;
            }
            fileInputStream.close();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(file + ": trouble reading", e);
        }
    }

    public static final void ag(ahh ahhVar, Object obj) {
        if (obj == q) {
            return;
        }
        if (!(obj instanceof drq)) {
            Object obj_u = ahhVar._u(null, s);
            throwIfVar1IsNull(obj_u,
                    "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            yg.throwIfVarNotNull(obj_u);
            throw null;
        }
        drq drqVar = (drq) obj;
        drn[] drnVarArr = drqVar.b;
        int length = drnVarArr.length - 1;
        if (length < 0) {
            return;
        }
        drn drnVar = drnVarArr[length];
        throwIfVar1IsNull(null);
        Object obj2 = drqVar.a[length];
        throw null;
    }

    public static final void ah(CancellableContinuation cancellableContinuationVar, afw afwVar, boolean z) {
        Object obj = CancellableContinuation.d.get(cancellableContinuationVar);
        Throwable thM = cancellableContinuationVar.m(obj);
        Object objX = thM != null ? FastKV.x(thM) : cancellableContinuationVar.n(obj);
        if (!z) {
            afwVar._bn(objX);
            return;
        }
        throwIfVar1IsNull(afwVar,
                "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuationVar = (DispatchedContinuation) afwVar;
        afx afxVar = dispatchedContinuationVar.e;
        Object obj2 = dispatchedContinuationVar.g;
        ahh ahhVar = afxVar.m;
        throwIfVar1IsNull(ahhVar);
        Object objAl = al(ahhVar, obj2);
        enk enkVarAu = objAl != q ? KotlinHelpers.au(afxVar, ahhVar, objAl) : null;
        try {
            afxVar._bn(objX);
        } finally {
            if (enkVarAu == null || enkVarAu.as()) {
                ag(ahhVar, objAl);
            }
        }
    }

    public static final void ai(String str) {
        throwIfVar1IsNull(str, "message");
        throw new IllegalArgumentException(str);
    }

    public static final String aj(int i2, long j2) {
        if (j2 >= 0) {
            cmz.o(i2);
            String string = Long.toString(j2, i2);
            throwIfVar1IsNull(string, "toString(...)");
            return string;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        cmz.o(i2);
        String string2 = Long.toString(j4, i2);
        throwIfVar1IsNull(string2, "toString(...)");
        cmz.o(i2);
        String string3 = Long.toString(j5, i2);
        throwIfVar1IsNull(string3, "toString(...)");
        return string2.concat(string3);
    }

    public static final Object ak(Object obj) {
        bou bouVar;
        bov bovVar = obj instanceof bov ? (bov) obj : null;
        return (bovVar == null || (bouVar = bovVar.a) == null) ? obj : bouVar;
    }

    public static final Object al(ahh ahhVar, Object obj) {
        if (obj == null) {
            obj = ahhVar._u(0, r);
            throwIfVar1IsNull(obj);
        }
        if (obj == 0) {
            return q;
        }
        if (obj instanceof Integer) {
            return ahhVar._u(new drq(ahhVar, ((Number) obj).intValue()), t);
        }
        yg.throwIfVarNotNull(obj);
        throw null;
    }

    public static float am() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static final String u(brn brnVar, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "<this>");
        throwIfVar1IsNull(brnVar, "json");
        for (Annotation annotation : dfxVar.getAnnotations()) {
            if (annotation instanceof brs) {
                return ((brs) annotation).discriminator();
            }
        }
        return brnVar.b.c;
    }

    public static void v(ayd aydVar, String str) {
        Log.e("FastKV", aydVar.e + " " + str);
    }

    public static final BaseBaseHook[] getAllBaseBaseHookInstances() {
        return new BaseBaseHook[] { ur.a, wm.a, wp.a, wr.a, aeq.a, afu.a, agi.a, aqw.a, axu.a, ayy.a, azd.a, bal.a,
                bap.a, bmb.a,
                bzc.a, cey.a, cgf.a, cgt.a, cos.a, crj.a, dbl.a, djo.a, dly.a, dmi.a, dou.a, cfw.a, euj.a, eul.a, eop.a,
                aic.a, agc.a, atz.a, cge.a, uq.a, xr.a, wv.a, xj.a, xn.a, gp.a, xv.a, xx.a, xz.a, elb.a, adz.a, byo.a,
                byr.a, byt.a, cvh.a, dds.a, ahd.a, dlx.a, atp.a, aub.a, auh.a, aup.a, dpv.a, mo.a, apn.a, agk.a, kd.a,
                acx.a, aga.a, etu.a, eoy.a, kb.a, cll.a, cln.a, clq.a, cls.a, clu.a, clw.a, cly.a, cma.a, cme.a, cmg.a,
                cmi.a, cmk.a, cmn.a, cmp.a, cmr.a, cmt.a, cmv.a, cmy.a, mq.a, aec.a, atm.a, bcp.a, bol.a, ctd.a, dgf.a,
                dis.a, dmu.a, epx.a, bub.a, diu.a, djx.a, dkc.a, dkn.a, dkt.a, dkv.a, eog.a, ms.a, xp.a, acv.a, aeg.a,
                aeo.a, agp.a, bon.a, bop.a, cgy.a, dgd.a, djj.a, djz.a, eqb.a, bym.a, bos.a, cqv.a, cqx.a, cqz.a, cra.a,
                AppBrandAntiGlobalAdHook.a, AppBrandAntiSplashAdHook.a, AppBrandForceShareHook.a,
                AppBrandVideoRewardHook.a, cf.a, BottomTabCustomHook.INSTANCE,
                BottomTabMaterialHook.a, wh.a,
                CustomBalanceHook.a,
                CustomContactCountHook.a, cfm.a,
                cfv.a, chh.a, ddh.a,
                AntiRevoke1Hook.a, ga.a,
                gd.a, lz.a, AutoSelectOriginalPhotoHook.a, mh.a, AutoViewOriginalPhotoHook.a, xg.a,
                DisableMsgClipHook.a, DisablePatHook.a,
                DisablePlayRingtoneHook.a,
                DisableSendStatusHook.a, MsgFormatHook.a, cgr.c,
                cgz.c,
                PanelEmojiHook.a, cww.a,
                cxg.a, cxl.a, dhm.a, die.a, bcu.a, ble.a, blg.a, blh.a, blk.a, blm.a, blo.a, cud.a, fs.a,
                CustomUnReadCountHook.a, azr.a,
                elx.a, un.a, uo.a, cie.a, cif.a, fp.a, cnl.a, bjm.a, bjx.a, atx.a, bxj.a, etr.a, dlv.a,
                RemoveMultiSelectLimitHook.a, dax.a,
                day.a, dbe.a, aun.a, cgc.a, chc.a, etl.a, etw.a, ctp.b, cxb.b, zr.a, cha.a, crm.a, cwy.a, cez.b, cfa.b,
                cfc.b, lx.a, md.a, zw.a, DisableBrightnessHook.a, cdo.a, cho.a, deu.a, dha.a, dpf.a, dad.a, dae.a,
                daf.a, ge.a, gf.a,
                gh.a, diq.a, div.a, diz.b, dja.b, djh.a, djv.a, SnsUploadAppInfoHook.a, dkl.a, xf.a, bbj.a, vg.a, vt.a,
                dhh.a, dhi.b,
                ShowContactInfoHook.b, VnHomeShareMenuCopyOrDownHook.a, VnPreviewShareMenuCopyOrDownHook.a, diw.a, ee.a,
                cia.a, doj.a, dok.a, bie.a,
                bii.a,
                EcsHardcodeGlobalSwitch.a, cym.a,
                cyn.a, elv.a, dhn.a, eud.a, eue.a, euf.a, elu.a, AccbilityDisableClick.a, cnq.a, xs.a, xt.a, eti.a,
                etx.a, dka.a, dkd.a,
                DistinctAtMeOrAtAllToNotify.a, ddc.a, boq.a, boh.a, cwt.a, cwu.a, eky.a, emo.a, arb.a, cou.a, cov.a,
                chb.a, cnn.a, cny.a,
                DisableDetailNotification.a,
                euc.a, ety.a, cxm.a, cxo.a, eth.a, ara.a, bcw.a, cnx.a, cxn.a, eub.a, chz.a, cxh.a, dru.a, etm.a, etn.a,
                eto.a, csy.a, epv.a, ya.a, crn.a, cro.a, crp.a, crq.a, crr.a, crs.a, lq.a, sk.a, sl.a, sm.a, eol.a,
                aqz.a, cnp.a, cno.a, dez.a, xl.a, dqr.a, cow.a, cnm.a, cvx.a, azu.a, ewu.a, ewv.a, ewx.a, avj.a, big.a,
                bih.a, coa.a, cvw.a, eww.a, ayk.a, cob.a, dgj.a, og.a, cnz.a, dda.a, xk.a, csa.a, fn.a, DevLogHook.a,
                dig.a,
                gm.a, CommandProcessorHook.a };
    }

    public static ciy x(erq erqVar) {
        SyntheticPileOfMess bmuVar = ciz.a;
        ahv ahvVar = ahv.a;
        throwIfVar1IsNull(bmuVar, "factory");
        throwIfVar1IsNull(ahvVar, "extras");
        chm chmVar = new chm(erqVar, bmuVar, ahvVar);
        zc zcVarB = dal.b(ciy.class);
        String strAo = emc.ao(zcVarB);
        if (strAo != null) {
            return (ciy) chmVar.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo), zcVarB);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public static int y(List list, InputStream inputStream, bva bvaVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new cyp(inputStream, bvaVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                int iK = ((bog) list.get(i2)).k(inputStream, bvaVar);
                inputStream.reset();
                if (iK != -1) {
                    return iK;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType z(List list, InputStream inputStream, bva bvaVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new cyp(inputStream, bvaVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeL = ((bog) list.get(i2)).l(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeL != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeL;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public abstract void a(dgw dgwVar, float f2, float f3);

    public abstract void an(boolean z);

    public abstract void ao(boolean z);

    public abstract void d(int i2);

    public abstract void e(Typeface typeface, boolean z);
}
