package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final class azu extends SwitchHook implements IHandlesHookParam {
    public static final azu a = new azu("FileSrcBtnEntrance" /* "FileSrcBtnEntrance" /* "FileSrcBtnEntrance" /* "FileSrcBtnEntrance" /* cnb.z(-644915109296938L)   */);
    public static final String b = "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* "测试-配置修复-v65-chatting" /* cnb.z(-645220051974954L)   */;
    public static final String c = "「查看包含该图片/视频/文件的聊天」入口" /* "「查看包含该图片/视频/文件的聊天」入口" /* "「查看包含该图片/视频/文件的聊天」入口" /* "「查看包含该图片/视频/文件的聊天」入口" /* cnb.z(-644562921978666L)   */;

    @Override // me.hd.wauxv.obf.IHandlesHookParam
    public final void handleHookParam(HookParam hookParam, String str) {
        if (getIsEnabled() && str.equals("RepairerConfig_FileSrcBtnEntrance_Int" /* "RepairerConfig_FileSrcBtnEntrance_Int" /* "RepairerConfig_FileSrcBtnEntrance_Int" /* "RepairerConfig_FileSrcBtnEntrance_Int" /* cnb.z(-645400440601386L)   */)) {
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
