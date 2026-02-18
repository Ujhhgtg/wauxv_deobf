package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class erx implements czi {
    @Override // me.hd.wauxv.obf.czi
    public final void ae(View view) {
    }

    @Override // me.hd.wauxv.obf.czi
    public final void af(View view) {
        czh czhVar = (czh) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) czhVar).width != -1 || ((ViewGroup.MarginLayoutParams) czhVar).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }
}
