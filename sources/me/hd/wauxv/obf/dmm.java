package me.hd.wauxv.obf;

import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmm extends czx implements bfs {
    public static final /* synthetic */ int a = 0;
    public final FrameLayout b;

    public dmm(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        cbm.g(frameLayout);
        super(frameLayout);
        this.b = frameLayout;
    }
}
