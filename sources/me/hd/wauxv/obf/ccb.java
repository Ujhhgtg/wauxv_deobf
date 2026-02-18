package me.hd.wauxv.obf;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccb extends FrameLayout implements aar {
    public final CollapsibleActionView a;

    /* JADX WARN: Multi-variable type inference failed */
    public ccb(View view) {
        super(view.getContext());
        this.a = (CollapsibleActionView) view;
        addView(view);
    }
}
