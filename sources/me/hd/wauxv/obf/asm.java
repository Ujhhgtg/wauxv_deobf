package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asm {
    public static final dfo a = new dfo();
    public float b;
    public float c;
    public final int d;
    public final dfo e;
    public boolean f;
    public boolean g;
    public final /* synthetic */ asn h;

    public asm(asn asnVar, float f, float f2, int i, dfo dfoVar) {
        this.h = asnVar;
        this.b = f;
        this.c = f2;
        this.d = i;
        this.e = dfoVar;
    }

    public final boolean i() {
        CodeEditor codeEditor = this.h.r;
        int i = this.d;
        if (i == 1 || i == 2) {
            return false;
        }
        return codeEditor.getCursorBlink().b || codeEditor.getEventHandler().e == 0 || codeEditor.be;
    }
}
