package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ana implements cqg {
    public final /* synthetic */ anc a;

    public ana(anc ancVar) {
        this.a = ancVar;
    }

    @Override // me.hd.wauxv.obf.cqg
    public final void b(Object obj) {
        if (((bup) obj) != null) {
            anc ancVar = this.a;
            if (ancVar.o) {
                View viewDd = ancVar.dd();
                if (viewDd.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (ancVar.s != null) {
                    if (beg.ar(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + ancVar.s);
                    }
                    ancVar.s.setContentView(viewDd);
                }
            }
        }
    }
}
