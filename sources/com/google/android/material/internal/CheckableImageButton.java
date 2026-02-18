package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ij;
import me.hd.wauxv.obf.yb;
import me.hd.wauxv.obf.yc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends ij implements Checkable {
    public static final int[] a = {R.attr.state_checked};
    public boolean b;
    public boolean c;
    public boolean d;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, me.hd.wauxv.R.attr.imageButtonStyle);
        this.c = true;
        this.d = true;
        eqz.s(this, new yb(this, 0));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.b ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), a) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof yc)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        yc ycVar = (yc) parcelable;
        super.onRestoreInstanceState(ycVar.g);
        setChecked(ycVar.a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        yc ycVar = new yc(super.onSaveInstanceState());
        ycVar.a = this.b;
        return ycVar;
    }

    public void setCheckable(boolean z) {
        if (this.c != z) {
            this.c = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.c || this.b == z) {
            return;
        }
        this.b = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.d = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.d) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.b);
    }
}
