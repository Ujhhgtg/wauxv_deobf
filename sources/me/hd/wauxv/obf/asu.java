package me.hd.wauxv.obf;

import android.view.MotionEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asu implements Runnable {
    public final float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public long h = 0;
    public final /* synthetic */ asv i;

    public asu(asv asvVar, int i) {
        this.i = asvVar;
        float f = i;
        this.c = f;
        this.b = f;
        this.a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f;
        float f2;
        asv asvVar = this.i;
        byw bywVar = asvVar.d;
        CodeEditor codeEditor = asvVar.a;
        int i = asvVar.x;
        float f3 = ((i & 1) != 0 ? -this.b : 0.0f) + ((i & 2) != 0 ? this.b : 0.0f);
        float f4 = ((i & 4) != 0 ? -this.c : 0.0f) + ((i & 8) != 0 ? this.c : 0.0f);
        if (f3 > 0.0f) {
            int i2 = asvVar.e;
            int i3 = (i2 == 0 || i2 == 1) ? codeEditor.getCursor().c.b : codeEditor.getCursor().d.b;
            if (asvVar.b.b.getCurrX() > (codeEditor.eb() + codeEditor.j.r(i3, codeEditor.getText().y(i3).b)[1]) - (codeEditor.getWidth() * 0.85f)) {
                f3 = 0.0f;
            }
        }
        asvVar.bb(f3, f4, false);
        if (bywVar.b.isShowing()) {
            bywVar.j();
        }
        boolean zAs = asv.as(asvVar, f3, this.d);
        float f5 = this.a;
        if (zAs) {
            float f6 = this.f;
            if (f6 < 32.0f) {
                f = 1.06f;
                f2 = 1.0f;
                if ((this.h & 1) == 0) {
                    this.f = f6 + 1.0f;
                    this.b *= 1.06f;
                }
            } else {
                f = 1.06f;
                f2 = 1.0f;
            }
        } else {
            f = 1.06f;
            f2 = 1.0f;
            this.b = f5;
            this.f = 0.0f;
        }
        if (asv.as(asvVar, f4, this.e)) {
            float f7 = this.g;
            if (f7 < 32.0f && (this.h & 1) == 0) {
                this.g = f7 + f2;
                this.c *= f;
            }
        } else {
            this.c = f5;
            this.g = 0.0f;
        }
        this.d = f3;
        this.e = f4;
        MotionEvent motionEvent = asvVar.z;
        if (motionEvent != null && !asvVar.ax(motionEvent, true)) {
            MotionEvent motionEvent2 = asvVar.z;
            int i4 = asvVar.e;
            if (i4 == 0) {
                asvVar.c.h(motionEvent2);
            } else if (i4 == 1) {
                asvVar.u.h(motionEvent2);
            } else if (i4 == 2) {
                asvVar.v.h(motionEvent2);
            }
        }
        this.h++;
        if (asvVar.x != 0) {
            codeEditor.eh(this, 10L);
        }
    }
}
