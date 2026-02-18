package me.hd.wauxv.obf;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aiw extends cat {
    public final RectF a;

    public aiw(dgm dgmVar, RectF rectF) {
        super(dgmVar);
        this.a = rectF;
    }

    @Override // me.hd.wauxv.obf.cat, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        aix aixVar = new aix(this);
        aixVar.b = this;
        aixVar.invalidateSelf();
        return aixVar;
    }

    public aiw(aiw aiwVar) {
        super(aiwVar);
        this.a = aiwVar.a;
    }
}
