package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class btm extends MetaKeyKeyListener {
    public final CodeEditor a;
    public final Editable b = Editable.Factory.getInstance().newEditable("");
    public boolean c = false;

    public btm(CodeEditor codeEditor) {
        this.a = codeEditor;
    }

    public final boolean d() {
        return MetaKeyKeyListener.getMetaState(this.b, 2) == 1;
    }

    public final boolean e() {
        return MetaKeyKeyListener.getMetaState(this.b, 1) == 1;
    }
}
