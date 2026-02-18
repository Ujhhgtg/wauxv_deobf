package me.hd.wauxv.obf;

import android.view.ContextMenu;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ahu extends ua {
    public final ContextMenu a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ahu(CodeEditor codeEditor, ContextMenu contextMenu, ud udVar) {
        super(codeEditor);
        bzo.q(contextMenu, "menu");
        this.a = contextMenu;
    }
}
