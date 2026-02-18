package me.hd.wauxv.obf;

import android.view.KeyEvent;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class asb extends ua {
    public Boolean a;
    public final KeyEvent l;
    public final int m;
    public final boolean n;
    public final boolean o;

    public asb(CodeEditor codeEditor, KeyEvent keyEvent, int i) {
        super(codeEditor);
        this.l = keyEvent;
        this.m = i;
        this.n = ((CodeEditor) this.c).getKeyMetaStates().initOnce();
        this.o = ((CodeEditor) this.c).getKeyMetaStates().d();
    }

    public final boolean p(boolean z) {
        Boolean bool = this.a;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        return this.b != 0 ? zBooleanValue : zBooleanValue || z;
    }
}
