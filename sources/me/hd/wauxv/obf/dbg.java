package me.hd.wauxv.obf;

import android.os.Build;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbg {
    public final ik a = new ik((byte) 0, 7);
    public final jx b;

    public dbg(CodeEditor codeEditor) {
        this.b = Build.VERSION.SDK_INT >= 29 ? new jx(codeEditor, 18) : null;
    }

    public final void c() {
        jx jxVar;
        if (Build.VERSION.SDK_INT < 29 || (jxVar = this.b) == null) {
            return;
        }
        Iterator it = ((ArrayList) jxVar.f).iterator();
        while (it.hasNext()) {
            ((dbh) it.next()).c = true;
        }
    }
}
