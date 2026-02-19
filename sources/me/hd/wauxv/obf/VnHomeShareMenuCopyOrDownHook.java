package me.hd.wauxv.obf;

import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class VnHomeShareMenuCopyOrDownHook extends SwitchHook implements bnm {
    public static final VnHomeShareMenuCopyOrDownHook a = new VnHomeShareMenuCopyOrDownHook(
            "VnHomeShareMenuCopyOrDownHook" /* "VnHomeShareMenuCopyOrDownHook" /* "VnHomeShareMenuCopyOrDownHook" /* cnb.z(-589179318696746L)  */);
    public static final String b;
    public static final String c;
    public static final String h;
    public static final String i;
    public static final epy j;

    static {
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        b = PathUtils.getModuleSubDir("Download" /* "Download" /* "Download" /* cnb.z(-46699179408170L)  */, "VideoNumber" /* "VideoNumber" /* "VideoNumber" /* cnb.z(-46677704571690L)  */);
        c = "视频号" /* "视频号" /* "视频号" /* cnb.z(-584991725583146L)  */;
        h = "主页分享菜单复制下载" /* "主页分享菜单复制下载" /* "主页分享菜单复制下载" /* cnb.z(-585008905452330L)  */;
        i = "为视频号菜单添加复制链接或下载视频" /* "为视频号菜单添加复制链接或下载视频" /* "为视频号菜单添加复制链接或下载视频" /* cnb.z(-585459877018410L)  */;
        j = new epy(2);
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
        return !z() ? EmptyReadonlyList.INSTANCE
                : OtherStaticHelpers.argsToList(
                        new bam(R.id.MenuItem_VideoNumber_CopyLink, "复制链接" /* "复制链接" /* "复制链接" /* cnb.z(-588483533994794L)  */,
                                R.drawable.ic_menu_copy_24dp, new dfq(13)),
                        new bam(R.id.MenuItem_VideoNumber_Download, "下载视频" /* "下载视频" /* "下载视频" /* cnb.z(-588513598765866L)  */,
                                R.drawable.ic_menu_save_24dp, new dfq(14)));
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
