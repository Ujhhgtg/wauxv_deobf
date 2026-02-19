package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class VnPreviewShareMenuCopyOrDownHook extends SwitchHook implements bnl {
    public static final VnPreviewShareMenuCopyOrDownHook a = new VnPreviewShareMenuCopyOrDownHook(
            "VnPreviewShareMenuCopyOrDownHook" /* "VnPreviewShareMenuCopyOrDownHook" /* "VnPreviewShareMenuCopyOrDownHook" /* cnb.z(-610456586681130L)  */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Download" /* "Download" /* "Download" /* cnb.z(-46699179408170L)  */, "VideoNumber" /* "VideoNumber" /* "VideoNumber" /* cnb.z(-46677704571690L)  */);
        c = "视频号" /* "视频号" /* "视频号" /* cnb.z(-607372800162602L)  */;
        h = "预览分享菜单复制下载" /* "预览分享菜单复制下载" /* "预览分享菜单复制下载" /* cnb.z(-607321260555050L)  */;
        i = "为视频号菜单添加复制链接或下载视频" /* "为视频号菜单添加复制链接或下载视频" /* "为视频号菜单添加复制链接或下载视频" /* cnb.z(-607308375653162L)  */;
        j = new epy(3);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    public final List m() {
        return !z() ? EmptyReadonlyList.a
                : OtherStaticHelpers.argsToList(
                        new bai(R.id.MenuItem_VideoNumber_CopyLink, "复制链接" /* "复制链接" /* "复制链接" /* cnb.z(-610332032629546L)  */,
                                R.drawable.ic_menu_copy_24dp, new dfq(15)),
                        new bai(R.id.MenuItem_VideoNumber_Download, "下载视频" /* "下载视频" /* "下载视频" /* cnb.z(-610276198054698L)  */,
                                R.drawable.ic_menu_save_24dp, new dfq(16)));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
