package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnClickListener {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                dnc.c("1.2.6.r1238.198c77c(1238)" /* "1.2.6.r1238.198c77c(1238)" /* "1.2.6.r1238.198c77c(1238)" /* cnb.z(-415821553728298L)  */);
                dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-415658344971050L)  */);
                break;
            case 1:
                dnc.c(exl.c);
                dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-415671229872938L)  */);
                break;
            case 2:
                HostInfoRegistry.INSTANCE.getClass();
                dnc.c(HostInfoRegistry.getVersionString());
                dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-415632575167274L)  */);
                break;
            case 3:
                dnc.c(PanelEmojiHook.RESOURCE_DIR);
                dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-474211634117418L)  */);
                break;
            case 4:
                String strZ = "EmojiGroupInfo" /* "EmojiGroupInfo" /* "EmojiGroupInfo" /* cnb.z(-474172979411754L)  */;
                String strZ2 = "productID = ?" /* "productID = ?" /* "productID = ?" /* cnb.z(-471411315440426L)  */;
                String[] strArr = { "wa.panel.emoji.group" /* "wa.panel.emoji.group" /* "wa.panel.emoji.group" /* cnb.z(-471334006029098L)  */ };
                int i = 0;
                dlx.a.getClass();
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dlx.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "delete" /* "delete" /* "delete" /* cnb.z(-103225243990826L)  */;
                Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(
                        new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(String.class), dal.getKClassFromClass(String[].class) }, 3, methodResolverVarT))
                        .invoke(strZ, strZ2, strArr);
                throwIfVar1IsNull(objJ);
                ((Number) objJ).intValue();
                dnc.sendToast(null, 3, "清除成功" /* "清除成功" /* "清除成功" /* cnb.z(-471226631846698L)  */);
                break;
            default:
                Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
                dnc.c(PathUtils.getModuleSubDir("Plugin" /* "Plugin" /* "Plugin" /* cnb.z(-47055661693738L)  */));
                dnc.sendToast(null, 3, "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-485060721507114L)  */);
                break;
        }
    }
}
