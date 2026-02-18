package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epk extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public epk(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        epl eplVar = new epl();
        eplVar.f = (VectorDrawable) this.a.newDrawable();
        return eplVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        epl eplVar = new epl();
        eplVar.f = (VectorDrawable) this.a.newDrawable(resources);
        return eplVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        epl eplVar = new epl();
        eplVar.f = (VectorDrawable) this.a.newDrawable(resources, theme);
        return eplVar;
    }
}
