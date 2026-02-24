package me.hd.wauxv.obf;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoCleanHook extends SwitchHook implements Runnable {
    public static final AutoCleanHook INSTANCE = new AutoCleanHook("AutoCleanHook");
    public static final String b = "杂项";
    public static final String name = "自动瘦身";
    public static final String d = "致敬瘦身模块 'KitsunePie-QQCleaner' ";
    public static final gi h = new gi(22);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        ((Handler) StaticMainLooperHandlerProvider.HANDLER.getValue()).postDelayed(this, 30000L);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return name;
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
    public final IInvokable getOnClick() {
        return h;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long unixEpoch = System.currentTimeMillis();
        AutoCleanHook$ValCleanLastTime valCleanLastTime = AutoCleanHook$ValCleanLastTime.INSTANCE;
        if (unixEpoch - valCleanLastTime.getLong() > AutoCleanHook$ValCleanCycle.INSTANCE.getLong() * 1000) {
            valCleanLastTime.setLong(System.currentTimeMillis());
            Dispatchers$IO akqVar = Dispatchers$IO.INSTANCE;
            lw lwVar = new lw(2, null, 0);
            ahh ahhVarT = KotlinHelpers.t(EmptyCoroutineContext.INSTANCE, akqVar);
            Dispatchers$Default alcVar2 = StaticDefaultDispatcherProvider.DISPATCHERS_DEFAULT;
            if (ahhVarT != alcVar2 && ahhVarT._w(arj.a) == null) {
                ahhVarT = ahhVarT._v(alcVar2);
            }
            t dmfVar = new dmf(ahhVarT, true);
            dmfVar.h(SomeEnum.DEFAULT, dmfVar, lwVar);
        }
        ((Handler) StaticMainLooperHandlerProvider.HANDLER.getValue()).postDelayed(this, 600000L);
    }
}
