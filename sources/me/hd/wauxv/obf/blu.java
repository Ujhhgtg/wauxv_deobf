package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blu {
    public static final LinkedHashMap a = new LinkedHashMap();
    public static final AtomicInteger b = new AtomicInteger(133169152);
    public static final boolean c = true;
    public final List d;
    public final LinkedHashSet e = new LinkedHashSet();
    public final LinkedHashMap f = new LinkedHashMap();
    public final LinkedHashMap g = new LinkedHashMap();

    public blu(List list) {
        this.d = list;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
     * 
     * if (r4 != null) goto L19;
     */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public static final android.view.View h(me.hd.wauxv.obf.blu r18, java.lang.Class r19, java.lang.String r20,
            android.content.Context r21) throws me.hd.wauxv.obf.cth {
        /*
         * Method dump skipped, instruction units count: 661
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.blu.h(me.hd.wauxv.obf.blu, java.lang.Class, java.lang.String, android.content.Context):android.view.View");
    }

    /* JADX WARN: Found duplicated region for block: B:18:0x00bf */
    public static final blr i(blu bluVar, Class cls, ViewGroup viewGroup, boolean z, Context context) {
        Object objF;
        blr blrVar = new blr(bluVar, cls, viewGroup, z, context);
        if (context != null) {
            ewm.a.getClass();
            if (!dnr.bi(context.getClass().getName(), "BridgeContext")) {
                ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
                ewl ewlVar = ewm.h;
                if (((Number) eu.a.getValue()).intValue() > 28 && !ewm.g) {
                    String str = applicationInfo.sourceDir;
                    boolean zB = eu.b(30);
                    cdy cdyVar = cdy.e;
                    Class cls2 = Boolean.TYPE;
                    if (zB) {
                        int i = bte.a;
                        jx jxVar = ewm.c;
                        btc btcVar = ewm.b[0];
                        bmu bmuVarBh = dqc.bh(jxVar.w());
                        ((cbg) bmuVarBh.h).c = ewlVar;
                        bmuVarBh.v(false);
                        cde cdeVarT = bmuVarBh.t();
                        cdeVarT.ab = "nativeLoad";
                        Class cls3 = Integer.TYPE;
                        cdeVarT.z(Arrays.copyOf(
                                new Object[] { dal.b(cls3), dal.b(String.class), dal.b(cls3), dal.b(evt.b()) }, 4));
                        cdeVarT.ak(cdyVar);
                        cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
                        objF = cdkVar != null ? cdkVar.f(0, str, 1, null) : null;
                    } else {
                        if (!eu.b(28)) {
                            throw new IllegalStateException("Unsupported Android version.");
                        }
                        int i2 = bte.a;
                        jx jxVar2 = ewm.c;
                        btc btcVar2 = ewm.b[0];
                        bmu bmuVarBh2 = dqc.bh(jxVar2.w());
                        ((cbg) bmuVarBh2.h).c = ewlVar;
                        bmuVarBh2.v(false);
                        cde cdeVarT2 = bmuVarBh2.t();
                        cdeVarT2.ab = "nativeLoad";
                        cdeVarT2.z(Arrays.copyOf(
                                new Object[] { dal.b(String.class), dal.b(cls2), dal.b(cls2), dal.b(cls2) }, 4));
                        cdeVarT2.ak(cdyVar);
                        cdk cdkVar2 = (cdk) aaz.g(cdeVarT2.aj());
                        if (cdkVar2 != null) {
                            Boolean bool = Boolean.FALSE;
                            objF = cdkVar2.f(str, bool, bool, bool);
                        }
                    }
                    Long l = objF instanceof Long ? (Long) objF : null;
                    if (l == null) {
                        throw new IllegalStateException("Failed to create ApkAssets.");
                    }
                    ewm.e = l;
                    jx jxVar3 = ewm.d;
                    btc btcVar3 = ewm.b[1];
                    bmu bmuVarBh3 = dqc.bh(jxVar3.w());
                    ((cbg) bmuVarBh3.h).c = ewlVar;
                    bmuVarBh3.v(false);
                    adt adtVarM = bmuVarBh3.m();
                    boolean zB2 = eu.b(36);
                    Class cls4 = Long.TYPE;
                    if (zB2) {
                        adtVarM.z(
                                Arrays.copyOf(new Object[] { dal.b(AssetManager.class), dal.b(cls4), dal.b(cls2) }, 3));
                    } else {
                        adtVarM.z(Arrays.copyOf(new Object[] { dal.b(AssetManager.class), dal.b(cls4) }, 2));
                    }
                    adu aduVar = (adu) aaz.g(adtVarM.a());
                    if (aduVar != null) {
                        AutoCloseable autoCloseable = eu.b(36) ? (AutoCloseable) aduVar.c(null, ewm.e, Boolean.FALSE)
                                : (AutoCloseable) aduVar.c(null, ewm.e);
                        if (autoCloseable != null) {
                            ewm.f = autoCloseable;
                            ewm.g = true;
                        }
                    }
                    throw new IllegalStateException("Failed to create XmlBlock$Parser.");
                }
            }
        }
        bluVar.e.add(blrVar);
        return blrVar;
    }

    public final View j(String str) throws cth {
        View view = (View) this.f.get(str);
        if (view != null) {
            return view;
        }
        throw new cth(concat("View with id \"", str, "\" not found."));
    }

    public final View k() throws cth {
        View view = (View) aaz.f(this.f.values());
        if (view != null) {
            return view;
        }
        throw new cth("No root view found, are you sure you have provided any view?");
    }
}
