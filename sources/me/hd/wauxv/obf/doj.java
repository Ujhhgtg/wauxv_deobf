package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class doj extends BaseHook implements bny {
    public static final doj a = new doj("SwipeBackLikeIOSAnim" /* cnb.z(-614270517639978L) */);
    public static final String b = "测试-配置修复-old-chatting" /* cnb.z(-614541100579626L) */;
    public static final String c = "滑动返回优化" /* cnb.z(-614485266004778L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_SwipeBackLikeIOSAnim_Int" /* cnb.z(-614163143457578L) */)) {
            hookParam.setResult(1);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }
}
