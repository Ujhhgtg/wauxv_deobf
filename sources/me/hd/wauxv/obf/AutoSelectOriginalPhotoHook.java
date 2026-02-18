package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AutoSelectOriginalPhotoHook extends SwitchHook implements IStartActivity {
    public static final AutoSelectOriginalPhotoHook a = new AutoSelectOriginalPhotoHook(
            "AutoSelectOriginalPhotoHook" /* cnb.z(-443369473964842L) */);
    public static final String b = "聊天" /* cnb.z(-440582040189738L) */;
    public static final String c = "自动勾选原图" /* cnb.z(-440534795549482L) */;
    public static final String d = "在发送图片和视频时自动勾选原图选项" /* cnb.z(-440556270385962L) */;

    @Override // me.hd.wauxv.obf.IStartActivity
    public final void onStartActivityIntent(HookParam hookParam, Intent intent) {
        if (getIsEnabled()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != 812972616) {
                    if (iHashCode != 1600608476 || !className
                            .equals("com.tencent.mm.plugin.gallery.ui.ImagePreviewUI" /* cnb.z(-443214855142186L) */)) {
                        return;
                    }
                } else if (!className.equals("com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI" /*
                                                                                                * cnb.z(-
                                                                                                * 443558452525866L)
                                                                                                */)) {
                    return;
                }
                intent.putExtra("send_raw_img" /* cnb.z(-440603515026218L) */, true);
            }
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

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
