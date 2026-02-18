package me.hd.wauxv.obf;

import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akb extends ViewOutlineProvider {
    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), TypedValue.applyDimension(1, 8.0f, view.getContext().getResources().getDisplayMetrics()));
    }
}
