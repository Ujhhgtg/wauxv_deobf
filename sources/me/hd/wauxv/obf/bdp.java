package me.hd.wauxv.obf;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.MaterialToolbar;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdp implements eqj {
    public final CoordinatorLayout a;
    public final CodeEditor b;
    public final MaterialToolbar c;

    public bdp(CoordinatorLayout coordinatorLayout, CodeEditor codeEditor, MaterialToolbar materialToolbar) {
        this.a = coordinatorLayout;
        this.b = codeEditor;
        this.c = materialToolbar;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
