package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epj extends Drawable.ConstantState {
    public int a;
    public epi b;
    public ColorStateList c;
    public PorterDuff.Mode d;
    public boolean e;
    public Bitmap f;
    public ColorStateList g;
    public PorterDuff.Mode h;
    public int i;
    public boolean j;
    public boolean k;
    public Paint l;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new epl(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new epl(this);
    }
}
