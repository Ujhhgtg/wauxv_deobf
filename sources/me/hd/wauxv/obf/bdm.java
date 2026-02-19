package me.hd.wauxv.obf;

import android.os.Handler;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdm extends cnb implements err, bup, dep, beu {
    public final hb a;
    public final hb e;
    public final Handler f;
    public final beg g;
    public final /* synthetic */ hb h;

    public bdm(hb hbVar) {
        this.h = hbVar;
        Handler handler = new Handler();
        this.a = hbVar;
        this.e = hbVar;
        this.f = handler;
        this.g = new beg();
    }

    @Override // me.hd.wauxv.obf.err
    public final erq aj() {
        return this.h.aj();
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        return (but) this.h.t.c;
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.h.d;
    }

    @Override // me.hd.wauxv.obf.beu
    public final void b(beg begVar, SomeFragmentManager someFragmentManagerVar) {
    }

    @Override // me.hd.wauxv.obf.cnb
    public final View c(int i) {
        return this.h.findViewById(i);
    }

    @Override // me.hd.wauxv.obf.cnb
    public final boolean d() {
        Window window = this.h.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
