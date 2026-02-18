package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfg implements ahz, ValueAnimator.AnimatorUpdateListener {
    public final CodeEditor a;
    public float g;
    public float h;
    public float i;
    public float j;
    public long k;
    public ValueAnimator c = new ValueAnimator();
    public ValueAnimator d = new ValueAnimator();
    public ValueAnimator f = new ValueAnimator();
    public ValueAnimator e = new ValueAnimator();
    public final long b = 120;

    public cfg(CodeEditor codeEditor) {
        this.a = codeEditor;
    }

    public final void l() {
        this.c.cancel();
        this.d.cancel();
        this.f.cancel();
        this.e.cancel();
    }

    public final boolean m() {
        return this.c.isRunning() || this.d.isRunning() || this.f.isRunning() || this.e.isRunning();
    }

    public final void n() {
        CodeEditor codeEditor = this.a;
        if (codeEditor.ax) {
            if (m()) {
                this.g = ((Float) this.c.getAnimatedValue()).floatValue();
                this.h = ((Float) this.d.getAnimatedValue()).floatValue();
                this.i = ((Float) this.f.getAnimatedValue()).floatValue();
                this.j = ((Float) this.e.getAnimatedValue()).floatValue();
                l();
            }
            if (System.currentTimeMillis() - this.k < 100) {
                return;
            }
            int i = codeEditor.getCursor().c.b;
            this.c.removeAllUpdateListeners();
            float[] fArrR = codeEditor.getLayout().r(codeEditor.getCursor().c.b, codeEditor.getCursor().c.c);
            this.c = ValueAnimator.ofFloat(this.g, codeEditor.eb() + fArrR[1]);
            float f = this.h;
            float f2 = fArrR[0];
            codeEditor.getProps().getClass();
            this.d = ValueAnimator.ofFloat(f, f2 - 0.0f);
            this.f = ValueAnimator.ofFloat(this.i, codeEditor.getRowHeight() * codeEditor.getLayout().k(codeEditor.getCursor().c.b));
            this.e = ValueAnimator.ofFloat(this.j, codeEditor.getLayout().r(i, codeEditor.getText().y(i).b)[0]);
            this.c.addUpdateListener(this);
            ValueAnimator valueAnimator = this.c;
            long j = this.b;
            valueAnimator.setDuration(j);
            this.d.setDuration(j);
            this.f.setDuration(j);
            this.e.setDuration(j);
        }
    }

    public final void o() {
        CodeEditor codeEditor = this.a;
        int i = codeEditor.getCursor().c.b;
        float[] fArrR = codeEditor.getLayout().r(i, codeEditor.getCursor().c.c);
        this.g = codeEditor.eb() + fArrR[1];
        float f = fArrR[0];
        codeEditor.getProps().getClass();
        this.h = f - 0.0f;
        this.i = codeEditor.getRowHeight() * codeEditor.getLayout().k(i);
        this.j = codeEditor.getLayout().r(i, codeEditor.getText().y(i).b)[0];
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.postInvalidateOnAnimation();
    }

    public final void p() {
        if (!this.a.ax || System.currentTimeMillis() - this.k < 100) {
            this.k = System.currentTimeMillis();
            return;
        }
        this.c.start();
        this.d.start();
        this.f.start();
        this.e.start();
        this.k = System.currentTimeMillis();
    }
}
