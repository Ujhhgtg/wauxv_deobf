package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfn extends ua {
    public final ud a;
    public final ud l;
    public final int m;

    public dfn(CodeEditor codeEditor, int i) {
        super(codeEditor);
        ahy ahyVarW = codeEditor.getText().w();
        this.a = ahyVarW.c.d();
        this.l = ahyVarW.d.d();
        this.m = i;
    }

    public final boolean n() {
        return this.a.a != this.l.a;
    }
}
