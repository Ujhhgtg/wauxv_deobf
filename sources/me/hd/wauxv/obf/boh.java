package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class boh extends SwitchHook implements IHandlesHookParam {
    public static final boh a = new boh("ImgDownloadHevc" /* "ImgDownloadHevc" /* "ImgDownloadHevc" /* cnb.z(-606599706049322L)  */);
    public static final String b = "测试-配置修复-v56-msgSync" /* "测试-配置修复-v56-msgSync" /* "测试-配置修复-v56-msgSync" /* cnb.z(-606415022455594L)  */;
    public static final String c = "下载图片是否支持Hevc" /* "下载图片是否支持Hevc" /* "下载图片是否支持Hevc" /* cnb.z(-606844519185194L)  */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_ImgDownloadHevc_Int" /* "RepairerConfig_ImgDownloadHevc_Int" /* "RepairerConfig_ImgDownloadHevc_Int" /* cnb.z(-606530986572586L)  */)) {
            hookParam.setResult(1);
        }
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
}
