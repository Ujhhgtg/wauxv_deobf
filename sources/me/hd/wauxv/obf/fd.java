package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fd extends Drawable.ConstantState {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ fd(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).canApplyTheme();
            default:
                return super.canApplyTheme();
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        switch (this.a) {
            case 0:
                return ((Drawable.ConstantState) this.b).getChangingConfigurations();
            default:
                return 0;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        switch (this.a) {
            case 0:
                fe feVar = new fe(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable();
                feVar.f = drawableNewDrawable;
                drawableNewDrawable.setCallback(feVar.e);
                return feVar;
            default:
                return new bha(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        switch (this.a) {
            case 0:
                fe feVar = new fe(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources);
                feVar.f = drawableNewDrawable;
                drawableNewDrawable.setCallback(feVar.e);
                return feVar;
            default:
                return new bha(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        switch (this.a) {
            case 0:
                fe feVar = new fe(null, 0);
                Drawable drawableNewDrawable = ((Drawable.ConstantState) this.b).newDrawable(resources, theme);
                feVar.f = drawableNewDrawable;
                drawableNewDrawable.setCallback(feVar.e);
                return feVar;
            default:
                return super.newDrawable(resources, theme);
        }
    }
}
