package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ct extends il implements cx {
    public final /* synthetic */ cw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ct(cw cwVar, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.a = cwVar;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        eku.a(this, getContentDescription());
        setOnTouchListener(new co(this, this));
    }

    @Override // me.hd.wauxv.obf.cx
    public final boolean l() {
        return false;
    }

    @Override // me.hd.wauxv.obf.cx
    public final boolean m() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.a.am();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}
