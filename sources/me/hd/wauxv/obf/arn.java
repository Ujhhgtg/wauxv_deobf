package me.hd.wauxv.obf;

import android.util.Log;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class arn extends Thread {
    public final ud a;
    public final btq b;
    public final afq c;
    public final abw d;
    public long e;
    public boolean f;
    public final /* synthetic */ aro g;

    public arn(aro aroVar, long j, abw abwVar) {
        this.g = aroVar;
        this.e = j;
        CodeEditor codeEditor = aroVar.a;
        this.a = codeEditor.getCursor().c.d();
        this.b = codeEditor.getEditorLanguage();
        afq afqVar = new afq(codeEditor.getText());
        this.c = afqVar;
        afqVar.e = this;
        this.d = abwVar;
        codeEditor.getExtraArguments();
        this.f = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        aro aroVar = this.g;
        CodeEditor codeEditor = aroVar.a;
        abw abwVar = this.d;
        try {
            this.b.f(this.c, this.a, abwVar);
            if (abwVar.b.size() + abwVar.a.size() <= 0) {
                codeEditor.ei(new arm(aroVar, 3));
            } else if (aroVar.e == Thread.currentThread()) {
                abwVar.l(true);
            }
            codeEditor.ei(new dh(this, 7));
        } catch (Exception e) {
            if (e instanceof abs) {
                Log.v("CompletionThread", "Completion is cancelled");
            } else {
                Log.e("CompletionThread", "Completion failed", e);
            }
        }
    }
}
