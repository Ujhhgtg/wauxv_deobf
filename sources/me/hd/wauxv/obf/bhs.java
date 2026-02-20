package me.hd.wauxv.obf;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import de.robv.android.xposed.XposedBridge;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bhs {
    public static final kotlinx$coroutines$internal$DispatchedContinuation[] e = new kotlinx$coroutines$internal$DispatchedContinuation[0];
    public static final bmc[] f = { bmc.a };
    public static final cbm g = new cbm(22);
    public static DefaultConfig config = null;
    public static boolean i = true;
    public static Field j;
    public static boolean k;

    public static final emz aa(String str) {
        throwIfVar1IsNull(str, "<this>");
        cmz.o(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        if (KotlinHelpers.r(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long j2 = 10;
        long j3 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                if (jDivideUnsigned != 512409557603043100L) {
                    return null;
                }
                jDivideUnsigned = Long.divideUnsigned(-1L, j2);
                if (Long.compareUnsigned(j3, jDivideUnsigned) > 0) {
                    return null;
                }
            }
            long j4 = j3 * j2;
            long j5 = (((long) iDigit) & 4294967295L) + j4;
            if (Long.compareUnsigned(j5, j4) < 0) {
                return null;
            }
            i2++;
            j3 = j5;
        }
        return new emz(j3);
    }

    public static String l(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public static boolean m(dnv dnvVar, ud udVar) {
        dle dleVarU = u(dnvVar, udVar, 0);
        return dleVarU == null || (dleVarU.d() & 2199023255552L) != 0;
    }

    public static final void n(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(
                    concatVar2Var1(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] o(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    public static final ckw p(Request request) {
        throwIfVar1IsNull(request, "<this>");
        ckw ckwVar = (ckw) request.tag(ckw.class);
        return ckwVar == null ? ckv.h : ckwVar;
    }

    public static final IEmpty5 q(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "<this>");
        if (dfxVar instanceof afs) {
            return null;
        }
        if (dfxVar instanceof dfy) {
            return q(((dfy) dfxVar).c);
        }
        return null;
    }

    /* JADX WARN: Found duplicated region for block: B:16:0x002d */
    public static bmc r() {
        Object objX;
        boolean zBooleanValue;
        for (bmc bmcVar : f) {
            if (bmd.a[bmcVar.ordinal()] == 1) {
                try {
                    XposedBridge.getXposedVersion();
                    objX = Boolean.TRUE;
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                if (objX instanceof Failure) {
                    objX = null;
                }
                Boolean bool = (Boolean) objX;
                zBooleanValue = bool != null ? bool.booleanValue() : false;
            }
            if (zBooleanValue) {
                return bmcVar;
            }
        }
        return bmc.b;
    }

    public static String s() {
        String str;
        Object string;
        ClassLoader classLoader;
        ClassLoader classLoader2;
        int iOrdinal = r().ordinal();
        Object objX = "unknown";
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return "unknown";
            }
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        ki.a.getClass();
        Application applicationH = ki.tryGetApplication();
        if (applicationH != null && (classLoader2 = applicationH.getClassLoader()) != null
                && ReflectionWrapper.g(classLoader2, "me.weishu.exposed.ExposedBridge")) {
            return "TaiChi";
        }
        Application applicationH2 = ki.tryGetApplication();
        if (applicationH2 != null && (classLoader = applicationH2.getClassLoader()) != null
                && ReflectionWrapper.g(classLoader, "com.bug.load.BugLoad")) {
            return "BugXposed";
        }
        try {
            int i2 = 0;
            SyntheticPileOfMess bmuVarBg = dqc.bg(dal.getKClassFromClass(XposedBridge.class));
            bmuVarBg.setHookOptional(true);
            FieldResolver fieldResolverVarR = bmuVarBg.r();
            fieldResolverVarR.name = "TAG";
            StaticHelpers2.addAllFromVar2ToVar1(fieldResolverVarR.modifiers, (AccessModifierEnum[]) Arrays.copyOf(new AccessModifierEnum[] { AccessModifierEnum.STATIC}, 1));
            BoundField boundFieldVar = (BoundField) StaticHelpers5.g(fieldResolverVarR.resolve());
            if (boundFieldVar != null && (str = (String) boundFieldVar.getValue_()) != null) {
                if (StringsKt.isBlank(str)) {
                    str = null;
                }
                if (str != null && (string = StringsKt.ba(dnr.bo(dnr.bo(str, "Bridge", ""), "-", "")).toString()) != null) {
                    objX = string;
                }
            }
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        String str2 = (String) (objX instanceof Failure ? null : objX);
        return str2 == null ? "invalid" : str2;
    }

    public static Object t(String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 34) {
            return az.tryGetClassByName(str, bundle);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (dp.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static dle u(dnv dnvVar, ud udVar, int i2) {
        int i3 = udVar.b;
        int i4 = udVar.c;
        if (dnvVar != null) {
            DefaultConfig ioVar = new DefaultConfig(dnvVar.a, 6);
            try {
                ioVar.i(i3);
                int iN = ioVar.n() - 1;
                if (iN == -1) {
                    try {
                        ioVar.i(-1);
                        return null;
                    } catch (Exception e2) {
                        Log.e("StylesUtils", "failed to close " + ioVar, e2);
                        return null;
                    }
                }
                for (int i5 = 0; i5 < ioVar.n(); i5++) {
                    if (ioVar.ak(i5).i() > i4) {
                        iN = i5 - 1;
                        break;
                    }
                }
                int i6 = iN + i2;
                if (i6 >= 0 && i6 < ioVar.n()) {
                    dle dleVarAk = ioVar.ak(i6);
                    try {
                        ioVar.i(-1);
                        return dleVarAk;
                    } catch (Exception e3) {
                        Log.e("StylesUtils", "failed to close " + ioVar, e3);
                        return dleVarAk;
                    }
                }
                try {
                    ioVar.i(-1);
                    return null;
                } catch (Exception e4) {
                    Log.e("StylesUtils", "failed to close " + ioVar, e4);
                    return null;
                }
            } catch (Exception e5) {
                try {
                    ioVar.i(-1);
                } catch (Exception e6) {
                    e5.addSuppressed(e6);
                }
                Log.e("StylesUtils", "failed to get spans from " + ioVar + " at " + udVar, e5);
            } catch (Throwable th) {
                try {
                    ioVar.i(-1);
                } catch (Exception e7) {
                    Log.e("StylesUtils", "failed to close " + ioVar, e7);
                }
                throw th;
            }
        }
        return null;
    }

    public static String v() {
        return cnb.ac(ewh.q) ? "c00"
                /* "c00" /* "c00" /* "c00" /* cnb.z(-430351428090666L)   */ : cnb.ac(ewh.o) ? "byy"
                        /* "byy" /* "byy" /* "byy" /* cnb.z(-430299888483114L)   */ : cnb.ac(ewh.n) ? "by0"
                                /* "by0" /* "by0" /* "by0" /* cnb.z(-430317068352298L)   */ : cnb.ac(ewh.m) ? "bxb"
                                        /* "bxb" /* "bxb" /* "bxb" /* cnb.z(-430265528744746L)   */ : cnb.ac(ewh.l) ? "bw2"
                                                /* "bw2" /* "bw2" /* "bw2" /* cnb.z(-430282708613930L)   */ : cnb.ac(ewh.k) ? "bvi"
                                                        /* "bvi" /* "bvi" /* "bvi" /* cnb.z(-430231169006378L)   */ : cnb.ac(ewh.j) ? "bv1"
                                                                /* "bv1" /* "bv1" /* "bv1" /* cnb.z(-430248348875562L)   */ : cnb.ac(ewh.i) ? "bua"
                                                                        /* "bua" /* "bua" /* "bua" /* cnb.z(-430196809268010L)   */ : cnb.ac(ewh.h)
                                                                                ? "btt"
                                                                                /* "btt" /* "btt" /* "btt" /* cnb.z(-430213989137194L)   */ : cnb
                                                                                        .ac(ewh.g)
                                                                                                ? "bvo"
                                                                                                /*
                                                                                                 * cnb.z(-
                                                                                                 * 427413670460202L)
                                                                                                 */ : cnb.ac(ewh.f)
                                                                                                        ? "bv9"
                                                                                                        /*
                                                                                                         * cnb.z(-
                                                                                                         * 427430850329386L)
                                                                                                         */ : cnb.ac(
                                                                                                                ewh.e) ? "br4"
                                                                                                                        /*
                                                                                                                         * cnb
                                                                                                                         * .
                                                                                                                         * z
                                                                                                                         * (
                                                                                                                         * -
                                                                                                                         * 427379310721834L)
                                                                                                                         */ : cnb
                                                                                                                                .ac(ewh.d)
                                                                                                                                        ? "bqj"
                                                                                                                                        /*
                                                                                                                                         * cnb
                                                                                                                                         * .
                                                                                                                                         * z
                                                                                                                                         * (
                                                                                                                                         * -
                                                                                                                                         * 427396490591018L)
                                                                                                                                         */ : cnb
                                                                                                                                                .ac(ewh.c)
                                                                                                                                                        ? "bm_"
                                                                                                                                                        /*
                                                                                                                                                         * cnb
                                                                                                                                                         * .
                                                                                                                                                         * z
                                                                                                                                                         * (
                                                                                                                                                         * -
                                                                                                                                                         * 427344950983466L)
                                                                                                                                                         */ : cnb
                                                                                                                                                                .ac(ewh.b)
                                                                                                                                                                        ? "bi2"
                                                                                                                                                                        /*
                                                                                                                                                                         * cnb
                                                                                                                                                                         * .
                                                                                                                                                                         * z
                                                                                                                                                                         * (
                                                                                                                                                                         * -
                                                                                                                                                                         * 427362130852650L)
                                                                                                                                                                         */ : cnb
                                                                                                                                                                                .ac(ewh.a)
                                                                                                                                                                                        ? "bdx"
                                                                                                                                                                                        /*
                                                                                                                                                                                         * cnb
                                                                                                                                                                                         * .
                                                                                                                                                                                         * z
                                                                                                                                                                                         * (
                                                                                                                                                                                         * -
                                                                                                                                                                                         * 427310591245098L)
                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                .ab(ewk.c)
                                                                                                                                                                                                        ? "bkl"
                                                                                                                                                                                                        /*
                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                         * .
                                                                                                                                                                                                         * z
                                                                                                                                                                                                         * (
                                                                                                                                                                                                         * -
                                                                                                                                                                                                         * 427327771114282L)
                                                                                                                                                                                                         */ : "b4b" /*
                                                                                                                                                                                                                     * cnb
                                                                                                                                                                                                                     * .
                                                                                                                                                                                                                     * z
                                                                                                                                                                                                                     * (
                                                                                                                                                                                                                     * -
                                                                                                                                                                                                                     * 427276231506730L)
                                                                                                                                                                                                                     */;
    }

    public static String w() {
        return cnb.ac(ewh.q) ? "c91"
                /* "c91" /* "c91" /* "c91" /* cnb.z(-427293411375914L)   */ : cnb.ac(ewh.o) ? "c7z"
                        /* "c7z" /* "c7z" /* "c7z" /* cnb.z(-427241871768362L)   */ : cnb.ac(ewh.n) ? "c6w"
                                /* "c6w" /* "c6w" /* "c6w" /* cnb.z(-427259051637546L)   */ : cnb.ac(ewh.m) ? "c68"
                                        /* "c68" /* "c68" /* "c68" /* cnb.z(-427207512029994L)   */ : cnb.ac(ewh.l) ? "c52"
                                                /* "c52" /* "c52" /* "c52" /* cnb.z(-427224691899178L)   */ : cnb.ac(ewh.k) ? "c44"
                                                        /* "c44" /* "c44" /* "c44" /* cnb.z(-427173152291626L)   */ : cnb.ac(ewh.j) ? "c3h"
                                                                /* "c3h" /* "c3h" /* "c3h" /* cnb.z(-427190332160810L)   */ : cnb.ac(ewh.i) ? "c2l"
                                                                        /* "c2l" /* "c2l" /* "c2l" /* cnb.z(-427688548367146L)   */ : cnb.ac(ewh.h)
                                                                                ? "c20"
                                                                                /* "c20" /* "c20" /* "c20" /* cnb.z(-427705728236330L)   */ : cnb
                                                                                        .ac(ewh.g)
                                                                                                ? "c40"
                                                                                                /*
                                                                                                 * cnb.z(-
                                                                                                 * 427654188628778L)
                                                                                                 */ : cnb.ac(ewh.f)
                                                                                                        ? "c3g"
                                                                                                        /*
                                                                                                         * cnb.z(-
                                                                                                         * 427671368497962L)
                                                                                                         */ : cnb.ac(
                                                                                                                ewh.e) ? "byr"
                                                                                                                        /*
                                                                                                                         * cnb
                                                                                                                         * .
                                                                                                                         * z
                                                                                                                         * (
                                                                                                                         * -
                                                                                                                         * 427619828890410L)
                                                                                                                         */ : cnb
                                                                                                                                .ac(ewh.d)
                                                                                                                                        ? "by6"
                                                                                                                                        /*
                                                                                                                                         * cnb
                                                                                                                                         * .
                                                                                                                                         * z
                                                                                                                                         * (
                                                                                                                                         * -
                                                                                                                                         * 427637008759594L)
                                                                                                                                         */ : cnb
                                                                                                                                                .ac(ewh.c)
                                                                                                                                                        ? "bth"
                                                                                                                                                        /*
                                                                                                                                                         * cnb
                                                                                                                                                         * .
                                                                                                                                                         * z
                                                                                                                                                         * (
                                                                                                                                                         * -
                                                                                                                                                         * 427585469152042L)
                                                                                                                                                         */ : cnb
                                                                                                                                                                .ac(ewh.b)
                                                                                                                                                                        ? "bp4"
                                                                                                                                                                        /*
                                                                                                                                                                         * cnb
                                                                                                                                                                         * .
                                                                                                                                                                         * z
                                                                                                                                                                         * (
                                                                                                                                                                         * -
                                                                                                                                                                         * 427602649021226L)
                                                                                                                                                                         */ : cnb
                                                                                                                                                                                .ac(ewh.a)
                                                                                                                                                                                        ? "bl0"
                                                                                                                                                                                        /*
                                                                                                                                                                                         * cnb
                                                                                                                                                                                         * .
                                                                                                                                                                                         * z
                                                                                                                                                                                         * (
                                                                                                                                                                                         * -
                                                                                                                                                                                         * 427551109413674L)
                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                .ab(ewk.c)
                                                                                                                                                                                                        ? "brp"
                                                                                                                                                                                                        /*
                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                         * .
                                                                                                                                                                                                         * z
                                                                                                                                                                                                         * (
                                                                                                                                                                                                         * -
                                                                                                                                                                                                         * 427568289282858L)
                                                                                                                                                                                                         */ : "b9m" /*
                                                                                                                                                                                                                     * cnb
                                                                                                                                                                                                                     * .
                                                                                                                                                                                                                     * z
                                                                                                                                                                                                                     * (
                                                                                                                                                                                                                     * -
                                                                                                                                                                                                                     * 427516749675306L)
                                                                                                                                                                                                                     */;
    }

    public static String x() {
        return cnb.ac(ewh.q) ? "c8x"
                /* "c8x" /* "c8x" /* "c8x" /* cnb.z(-427533929544490L)   */ : cnb.ac(ewh.o) ? "c7v"
                        /* "c7v" /* "c7v" /* "c7v" /* cnb.z(-427482389936938L)   */ : cnb.ac(ewh.n) ? "c6s"
                                /* "c6s" /* "c6s" /* "c6s" /* cnb.z(-427499569806122L)   */ : cnb.ac(ewh.m) ? "c64"
                                        /* "c64" /* "c64" /* "c64" /* cnb.z(-427448030198570L)   */ : cnb.ac(ewh.l) ? "c4y"
                                                /* "c4y" /* "c4y" /* "c4y" /* cnb.z(-427465210067754L)   */ : cnb.ac(ewh.k) ? "c40"
                                                        /* "c40" /* "c40" /* "c40" /* cnb.z(-426863914646314L)   */ : cnb.ac(ewh.j) ? "c3d"
                                                                /* "c3d" /* "c3d" /* "c3d" /* cnb.z(-426881094515498L)   */ : cnb.ac(ewh.i) ? "c2h"
                                                                        /* "c2h" /* "c2h" /* "c2h" /* cnb.z(-426829554907946L)   */ : cnb.ac(ewh.h)
                                                                                ? "c1w"
                                                                                /* "c1w" /* "c1w" /* "c1w" /* cnb.z(-426846734777130L)   */ : cnb
                                                                                        .ac(ewh.g)
                                                                                                ? "c3w"
                                                                                                /*
                                                                                                 * cnb.z(-
                                                                                                 * 426795195169578L)
                                                                                                 */ : cnb.ac(ewh.f)
                                                                                                        ? "c3c"
                                                                                                        /*
                                                                                                         * cnb.z(-
                                                                                                         * 426812375038762L)
                                                                                                         */ : cnb.ac(
                                                                                                                ewh.e) ? "byn"
                                                                                                                        /*
                                                                                                                         * cnb
                                                                                                                         * .
                                                                                                                         * z
                                                                                                                         * (
                                                                                                                         * -
                                                                                                                         * 426760835431210L)
                                                                                                                         */ : cnb
                                                                                                                                .ac(ewh.d)
                                                                                                                                        ? "by2"
                                                                                                                                        /*
                                                                                                                                         * cnb
                                                                                                                                         * .
                                                                                                                                         * z
                                                                                                                                         * (
                                                                                                                                         * -
                                                                                                                                         * 426778015300394L)
                                                                                                                                         */ : cnb
                                                                                                                                                .ac(ewh.c)
                                                                                                                                                        ? "btd"
                                                                                                                                                        /*
                                                                                                                                                         * cnb
                                                                                                                                                         * .
                                                                                                                                                         * z
                                                                                                                                                         * (
                                                                                                                                                         * -
                                                                                                                                                         * 426726475692842L)
                                                                                                                                                         */ : cnb
                                                                                                                                                                .ac(ewh.b)
                                                                                                                                                                        ? "bp0"
                                                                                                                                                                        /*
                                                                                                                                                                         * cnb
                                                                                                                                                                         * .
                                                                                                                                                                         * z
                                                                                                                                                                         * (
                                                                                                                                                                         * -
                                                                                                                                                                         * 426743655562026L)
                                                                                                                                                                         */ : cnb
                                                                                                                                                                                .ac(ewh.a)
                                                                                                                                                                                        ? "bkw"
                                                                                                                                                                                        /*
                                                                                                                                                                                         * cnb
                                                                                                                                                                                         * .
                                                                                                                                                                                         * z
                                                                                                                                                                                         * (
                                                                                                                                                                                         * -
                                                                                                                                                                                         * 426692115954474L)
                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                .ab(ewk.c)
                                                                                                                                                                                                        ? "brl"
                                                                                                                                                                                                        /*
                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                         * .
                                                                                                                                                                                                         * z
                                                                                                                                                                                                         * (
                                                                                                                                                                                                         * -
                                                                                                                                                                                                         * 426709295823658L)
                                                                                                                                                                                                         */ : "b9i" /*
                                                                                                                                                                                                                     * cnb
                                                                                                                                                                                                                     * .
                                                                                                                                                                                                                     * z
                                                                                                                                                                                                                     * (
                                                                                                                                                                                                                     * -
                                                                                                                                                                                                                     * 426657756216106L)
                                                                                                                                                                                                                     */;
    }

    public static String y() {
        return cnb.ac(ewh.q) ? "c9b"
                /* "c9b" /* "c9b" /* "c9b" /* cnb.z(-426674936085290L)   */ : cnb.ac(ewh.o) ? "c8_"
                        /* "c8_" /* "c8_" /* "c8_" /* cnb.z(-426623396477738L)   */ : cnb.ac(ewh.n) ? "c77"
                                /* "c77" /* "c77" /* "c77" /* cnb.z(-426640576346922L)   */ : cnb.ac(ewh.m) ? "c6i"
                                        /* "c6i" /* "c6i" /* "c6i" /* cnb.z(-427138792553258L)   */ : cnb.ac(ewh.l) ? "c5c"
                                                /* "c5c" /* "c5c" /* "c5c" /* cnb.z(-427155972422442L)   */ : cnb.ac(ewh.k) ? "c4e"
                                                        /* "c4e" /* "c4e" /* "c4e" /* cnb.z(-427104432814890L)   */ : cnb.ac(ewh.j) ? "c3s"
                                                                /* "c3s" /* "c3s" /* "c3s" /* cnb.z(-427121612684074L)   */ : cnb.ac(ewh.i) ? "c2w"
                                                                        /* "c2w" /* "c2w" /* "c2w" /* cnb.z(-427070073076522L)   */ : cnb.ac(ewh.h)
                                                                                ? "c2a"
                                                                                /* "c2a" /* "c2a" /* "c2a" /* cnb.z(-427087252945706L)   */ : cnb
                                                                                        .ac(ewh.g)
                                                                                                ? "c4a"
                                                                                                /*
                                                                                                 * cnb.z(-
                                                                                                 * 427035713338154L)
                                                                                                 */ : cnb.ac(ewh.f)
                                                                                                        ? "c3r"
                                                                                                        /*
                                                                                                         * cnb.z(-
                                                                                                         * 427052893207338L)
                                                                                                         */ : cnb.ac(
                                                                                                                ewh.e) ? "bz2"
                                                                                                                        /*
                                                                                                                         * cnb
                                                                                                                         * .
                                                                                                                         * z
                                                                                                                         * (
                                                                                                                         * -
                                                                                                                         * 427001353599786L)
                                                                                                                         */ : cnb
                                                                                                                                .ac(ewh.d)
                                                                                                                                        ? "byg"
                                                                                                                                        /*
                                                                                                                                         * cnb
                                                                                                                                         * .
                                                                                                                                         * z
                                                                                                                                         * (
                                                                                                                                         * -
                                                                                                                                         * 427018533468970L)
                                                                                                                                         */ : cnb
                                                                                                                                                .ac(ewh.c)
                                                                                                                                                        ? "bts"
                                                                                                                                                        /*
                                                                                                                                                         * cnb
                                                                                                                                                         * .
                                                                                                                                                         * z
                                                                                                                                                         * (
                                                                                                                                                         * -
                                                                                                                                                         * 426966993861418L)
                                                                                                                                                         */ : cnb
                                                                                                                                                                .ac(ewh.b)
                                                                                                                                                                        ? "bpe"
                                                                                                                                                                        /*
                                                                                                                                                                         * cnb
                                                                                                                                                                         * .
                                                                                                                                                                         * z
                                                                                                                                                                         * (
                                                                                                                                                                         * -
                                                                                                                                                                         * 426984173730602L)
                                                                                                                                                                         */ : cnb
                                                                                                                                                                                .ac(ewh.a)
                                                                                                                                                                                        ? "bla"
                                                                                                                                                                                        /*
                                                                                                                                                                                         * cnb
                                                                                                                                                                                         * .
                                                                                                                                                                                         * z
                                                                                                                                                                                         * (
                                                                                                                                                                                         * -
                                                                                                                                                                                         * 426932634123050L)
                                                                                                                                                                                         */ : cnb
                                                                                                                                                                                                .ab(ewk.c)
                                                                                                                                                                                                        ? "bs0"
                                                                                                                                                                                                        /*
                                                                                                                                                                                                         * cnb
                                                                                                                                                                                                         * .
                                                                                                                                                                                                         * z
                                                                                                                                                                                                         * (
                                                                                                                                                                                                         * -
                                                                                                                                                                                                         * 426949813992234L)
                                                                                                                                                                                                         */ : "b9x" /*
                                                                                                                                                                                                                     * cnb
                                                                                                                                                                                                                     * .
                                                                                                                                                                                                                     * z
                                                                                                                                                                                                                     * (
                                                                                                                                                                                                                     * -
                                                                                                                                                                                                                     * 426898274384682L)
                                                                                                                                                                                                                     */;
    }

    public static final emu z(String str) {
        int i2;
        cmz.o(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        if (KotlinHelpers.r(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i2 = 0;
        }
        int iDivideUnsigned = 119304647;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                if (iDivideUnsigned != 119304647) {
                    return null;
                }
                iDivideUnsigned = Integer.divideUnsigned(-1, 10);
                if (Integer.compareUnsigned(i3, iDivideUnsigned) > 0) {
                    return null;
                }
            }
            int i4 = i3 * 10;
            int i5 = iDigit + i4;
            if (Integer.compareUnsigned(i5, i4) < 0) {
                return null;
            }
            i2++;
            i3 = i5;
        }
        return new emu(i3);
    }

    public float ab(View view) {
        if (i) {
            try {
                return esp.a(view);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
        return view.getAlpha();
    }

    public abstract int ac(boolean z);

    public abstract int ad(boolean z);

    public abstract int ae(boolean z);

    public void af(View view, float f2) {
        if (i) {
            try {
                esp.tryGetClassByName(view, f2);
                return;
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
        view.setAlpha(f2);
    }

    public void ag(View view, int i2) {
        if (!k) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                j = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            k = true;
        }
        Field field = j;
        if (field != null) {
            try {
                j.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract Intent b(hb hbVar, String str);

    public LateinitProperty c(hb hbVar, String str) {
        return null;
    }

    public abstract Object d(Intent intent, int i2);
}
