package me.hd.wauxv.obf;

import android.widget.OverScroller;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aso {
    public final CodeEditor a;
    public final OverScroller b;

    public aso(CodeEditor codeEditor) {
        this.b = new OverScroller(codeEditor.getContext());
        this.a = codeEditor;
    }

    public final void c() {
        OverScroller overScroller = this.b;
        int currX = overScroller.getCurrX();
        CodeEditor codeEditor = this.a;
        codeEditor.setScrollX(currX);
        codeEditor.setScrollY(overScroller.getCurrY());
    }

    public final void d(int i, int i2, int i3, int i4, int i5) {
        this.b.startScroll(i, i2, i3, i4, i5);
        c();
    }
}
