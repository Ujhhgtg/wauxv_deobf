package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aaj implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ CodeEditor b;
    public final /* synthetic */ Runnable c;

    public /* synthetic */ aaj(CodeEditor codeEditor, Runnable runnable, int i) {
        this.a = i;
        this.b = codeEditor;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                if (!this.b.ap) {
                    this.c.run();
                    break;
                }
                break;
            default:
                if (!this.b.ap) {
                    this.c.run();
                    break;
                }
                break;
        }
    }
}
