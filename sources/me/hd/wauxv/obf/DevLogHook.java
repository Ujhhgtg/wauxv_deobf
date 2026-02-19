package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class DevLogHook extends SwitchHook {
    public static final DevLogHook a = new DevLogHook("DevLogHook" /* "DevLogHook" /* "DevLogHook" /* "DevLogHook" /* cnb.z(-648501406989098L)   */);
    public static final String b = "测试-仅限开发者使用" /* "测试-仅限开发者使用" /* "测试-仅限开发者使用" /* "测试-仅限开发者使用" /* cnb.z(-647912996469546L)   */;
    public static final String c = "调试日志" /* "调试日志" /* "调试日志" /* "调试日志" /* cnb.z(-636338059606826L)   */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _z() {
        return false;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bh(ajn.tryGetClassByClassName("com.tencent.mars.xlog.Xlog" /* "com.tencent.mars.xlog.Xlog" /* "com.tencent.mars.xlog.Xlog" /* "com.tencent.mars.xlog.Xlog" /* cnb.z(-647870046796586L)   */)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "logMonitor" /* "logMonitor" /* "logMonitor" /* "logMonitor" /* cnb.z(-647771262548778L)   */;
        Class cls = Long.TYPE;
        zc zcVarB = dal.b(cls);
        Class cls2 = Integer.TYPE;
        aki akiVarAd = ad((MethodHookWrapper) StaticHelpers6.n(new Object[] { zcVarB, dal.b(cls2), dal.b(String.class), dal.b(String.class),
                dal.b(String.class), dal.b(cls2), dal.b(cls2), dal.b(cls), dal.b(cls), dal.b(String.class) }, 10,
                methodResolverVarT), HookPriorityEnum.ENUM_DEFAULT);
        a.y(akiVarAd, new amb(0));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }
}
