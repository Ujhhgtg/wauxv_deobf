package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aia implements Runnable, awz {
    public final CodeEditor a;
    public boolean c;
    public int e;
    public float[] f;
    public long d = 0;
    public boolean b = true;

    public aia(CodeEditor codeEditor, int i) {
        this.a = codeEditor;
        this.e = i;
        codeEditor.i.l(dfn.class, this);
    }

    @Override // me.hd.wauxv.obf.awz
    public final void g(ua uaVar, afc afcVar) {
        this.d = System.currentTimeMillis();
        this.b = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.c || this.e <= 0) {
            this.b = true;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.d;
        long j = ((long) this.e) * 2;
        CodeEditor codeEditor = this.a;
        if (jCurrentTimeMillis >= j) {
            this.b = !this.b;
            ud udVarD = codeEditor.getCursor().c.d();
            this.f = codeEditor.getLayout().h(udVarD.b, udVarD.c, this.f);
            if (!codeEditor.getCursor().h() && this.f[0] >= codeEditor.getOffsetY()) {
                if (this.f[0] - codeEditor.getRowHeight() <= codeEditor.getHeight() + codeEditor.getOffsetY() && this.f[1] >= codeEditor.getOffsetX()) {
                    if (this.f[1] - 100.0f <= codeEditor.getWidth() + codeEditor.getOffsetX()) {
                        codeEditor.postInvalidate();
                    }
                }
            }
        } else {
            this.b = true;
        }
        codeEditor.eh(this, this.e);
    }
}
