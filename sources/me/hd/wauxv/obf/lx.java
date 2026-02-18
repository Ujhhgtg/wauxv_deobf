package me.hd.wauxv.obf;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lx extends SwitchHook implements Runnable {
    public static final lx a = new lx("AutoCleanHook" /* cnb.z(-511217072339754L) */);
    public static final String b = "杂项" /* cnb.z(-511161237764906L) */;
    public static final String c = "自动瘦身" /* cnb.z(-511165532732202L) */;
    public static final String d = "致敬瘦身模块 'KitsunePie-QQCleaner' " /* cnb.z(-511126878026538L) */;
    public static final gi h = new gi(22);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        ((Handler) bij.a.getValue()).postDelayed(this, 30000L);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IHasInvokeMethod p() {
        return h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        lv lvVar = lv.a;
        if (jCurrentTimeMillis - lvVar.l() > lu.a.l() * 1000) {
            lvVar.s(System.currentTimeMillis());
            alc alcVar = aou.a;
            akq akqVar = akq.f;
            lw lwVar = new lw(2, null, 0);
            ahh ahhVarT = KotlinHelpers.t(auz.a, akqVar, true);
            alc alcVar2 = aou.a;
            if (ahhVarT != alcVar2 && ahhVarT._w(arj.a) == null) {
                ahhVarT = ahhVarT._v(alcVar2);
            }
            t dmfVar = new dmf(ahhVarT, true);
            dmfVar.h(ahs.a, dmfVar, lwVar);
        }
        ((Handler) bij.a.getValue()).postDelayed(this, 600000L);
    }
}
