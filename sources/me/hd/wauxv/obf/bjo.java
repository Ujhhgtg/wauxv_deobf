package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjo extends View {
    public boolean a;

    public bjo(Context context) {
        super(context);
        this.a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.a = z;
    }

    public void setGuidelineBegin(int i) {
        adf adfVar = (adf) getLayoutParams();
        if (this.a && adfVar.a == i) {
            return;
        }
        adfVar.a = i;
        setLayoutParams(adfVar);
    }

    public void setGuidelineEnd(int i) {
        adf adfVar = (adf) getLayoutParams();
        if (this.a && adfVar.b == i) {
            return;
        }
        adfVar.b = i;
        setLayoutParams(adfVar);
    }

    public void setGuidelinePercent(float f) {
        adf adfVar = (adf) getLayoutParams();
        if (this.a && adfVar.c == f) {
            return;
        }
        adfVar.c = f;
        setLayoutParams(adfVar);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }
}
