package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asr implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ass b;

    public /* synthetic */ asr(ass assVar, int i) {
        this.a = i;
        this.b = assVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ass assVar = this.b;
                CodeEditor codeEditor = assVar.a;
                if (!codeEditor.getEventHandler().be() && !codeEditor.getCursor().h()) {
                    assVar.i();
                } else if (!codeEditor.getCursor().h()) {
                    codeEditor.eh(this, 100L);
                }
                break;
            default:
                ass assVar2 = this.b;
                CodeEditor codeEditor2 = assVar2.a;
                if (!assVar2.h.ay() && !codeEditor2.getSnippetController().l() && System.currentTimeMillis() - assVar2.k > 200 && codeEditor2.getScroller().b.isFinished()) {
                    assVar2.q();
                } else {
                    codeEditor2.eh(this, 200L);
                }
                break;
        }
    }
}
