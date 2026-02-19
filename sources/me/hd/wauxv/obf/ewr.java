package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewr implements Serializable {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final Throwable h;
    public boolean i;

    public ewr(String str, String str2, String str3, Throwable th, int i) {
        String strI;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Integer num;
        str = (i & 4) != 0 ? cna.d : str;
        this.a = 0L;
        this.b = "";
        this.c = str;
        this.d = str2;
        this.e = "";
        int iIntValue = 0;
        this.f = 0;
        this.g = str3;
        this.h = th;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a = jCurrentTimeMillis;
        this.b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ROOT).format(new Date(jCurrentTimeMillis));
        if (exm.l() && exm.c) {
            strI = "android-zygote";
        } else {
            ki.a.getClass();
            strI = ki.i();
        }
        this.e = strI;
        ki.a.getClass();
        String strI2 = ki.i();
        int i2 = 0;
        FactoryPools factoryPoolsVar = ki.e;
        btc btcVar = ki.b[0];
        SyntheticPileOfMess bmuVarBh = dqc.bh(factoryPoolsVar.w());
        Kotlin$Lazy kotlin$LazyVar = ep.a;
        ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
        bmuVarBh.setHookOptional(true);
        MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "currentActivityThread";
        methodResolverVarT.y();
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
        Context context = null;
        Object objE = methodHookWrapperVar != null ? methodHookWrapperVar.e(new Object[0]) : null;
        MethodResolver methodResolverVarT2 = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "getSystemContext";
        methodResolverVarT2.y();
        MethodHookWrapper methodHookWrapperVar2 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT2.findMethods());
        if (methodHookWrapperVar2 != null) {
            methodHookWrapperVar2.bindInstance(objE);
            context = (Context) methodHookWrapperVar2.i(new Object[0]);
        }
        if (context != null && (packageManager = context.getPackageManager()) != null
                && (applicationInfo = packageManager.getApplicationInfo(strI2, 1)) != null) {
            int i3 = applicationInfo.uid;
            SyntheticPileOfMess bmuVarBg = dqc.bg(dal.b(UserHandle.class));
            ((Configuration) bmuVarBg.obj).processorResolver = FastKV.aa();
            bmuVarBg.setHookOptional(true);
            MethodResolver methodResolverVarT3 = bmuVarBg.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT3.name = "getUserId";
            methodResolverVarT3.setParams(Arrays.copyOf(new Object[] { dal.b(Integer.TYPE) }, 1));
            MethodHookWrapper methodHookWrapperVar3 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT3.findMethods());
            if (methodHookWrapperVar3 != null && (num = (Integer) methodHookWrapperVar3.j(Integer.valueOf(i3))) != null) {
                iIntValue = num.intValue();
            }
        }
        this.f = iIntValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ewr)) {
            return false;
        }
        ewr ewrVar = (ewr) obj;
        return this.a == ewrVar.a && nullSafeIsEqual(this.b, ewrVar.b) && nullSafeIsEqual(this.c, ewrVar.c)
                && nullSafeIsEqual(this.d, ewrVar.d) && nullSafeIsEqual(this.e, ewrVar.e) && this.f == ewrVar.f
                && nullSafeIsEqual(this.g, ewrVar.g) && nullSafeIsEqual(this.h, ewrVar.h);
    }

    public final int hashCode() {
        int iE = bjs.e(this.g,
                dts.a(this.f, bjs.e(this.e,
                        bjs.e(this.d, bjs.e(this.c, bjs.e(this.b, Long.hashCode(this.a) * 31, 31), 31), 31), 31), 31),
                31);
        Throwable th = this.h;
        return iE + (th == null ? 0 : th.hashCode());
    }

    public final String toString() {
        int i;
        String str = "";
        for (Integer num : cna.e) {
            int iIntValue = num.intValue();
            if (iIntValue == 1000) {
                str = ((Object) str) + "[" + this.c + "]";
            }
            if (iIntValue == 1001) {
                str = ((Object) str) + "[" + this.d + "]";
            }
            if (iIntValue == 1002 && !this.i) {
                String str2 = this.e;
                if (!dnj.ak(str2)) {
                    str = ((Object) str) + "[" + str2 + "]";
                }
            }
            if (iIntValue == 1003 && !this.i && (i = this.f) != 0) {
                str = ((Object) str) + "[" + i + "]";
            }
        }
        String str3 = !dnj.ak(str) ? str : null;
        String str4 = this.g;
        if (str3 != null) {
            String str5 = ((Object) str) + " " + str4;
            if (str5 != null) {
                return str5;
            }
        }
        return str4;
    }
}
