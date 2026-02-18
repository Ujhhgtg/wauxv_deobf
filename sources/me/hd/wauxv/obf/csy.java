package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class csy extends BaseHook implements bny {
    public static final csy a = new csy("PartVideoSupportPlay" /* cnb.z(-630758897089322L) */);
    public static final String b = "测试-配置修复-v62-msgSend" /* cnb.z(-630965055519530L) */;
    public static final String c = "过期且局部下载过的视频支持播放" /* cnb.z(-630913515911978L) */;

    @Override // me.hd.wauxv.obf.bny
    public final void d(HookParamWrapper hookParam, String str) {
        if (z() && str.equals("RepairerConfig_VideoExpireAndPartDownload_support_play_Int" /*
                                                                                            * cnb.z(-630703062514474L)
                                                                                            */)) {
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
