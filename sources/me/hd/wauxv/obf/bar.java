package me.hd.wauxv.obf;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bar implements bfh {
    public final Set a = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean b;

    @Override // me.hd.wauxv.obf.bfh
    public final void t(hb hbVar) {
        if (!this.b && this.a.add(hbVar)) {
            View decorView = hbVar.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new baq(this, decorView));
        }
    }
}
