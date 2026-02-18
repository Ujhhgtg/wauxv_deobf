package me.hd.wauxv.obf;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfg implements bkg, dep, err {
    public final bdj a;
    public final erq b;
    public final dh c;
    public bur d = null;
    public but e = null;

    public bfg(bdj bdjVar, erq erqVar, dh dhVar) {
        this.a = bdjVar;
        this.b = erqVar;
        this.c = dhVar;
    }

    @Override // me.hd.wauxv.obf.bkg
    public final chq ai() {
        Application application;
        bdj bdjVar = this.a;
        Context applicationContext = bdjVar.dc().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        chq chqVar = new chq(0);
        LinkedHashMap linkedHashMap = chqVar.c;
        if (application != null) {
            linkedHashMap.put(ern.n, application);
        }
        linkedHashMap.put(aye.d, bdjVar);
        linkedHashMap.put(aye.e, this);
        Bundle bundle = bdjVar.ax;
        if (bundle != null) {
            linkedHashMap.put(aye.f, bundle);
        }
        return chqVar;
    }

    @Override // me.hd.wauxv.obf.err
    public final erq aj() {
        g();
        return this.b;
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        g();
        return (but) this.e.c;
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        g();
        return this.d;
    }

    public final void f(bug bugVar) {
        this.d.m(bugVar);
    }

    public final void g() {
        if (this.d == null) {
            this.d = new bur(this);
            deo deoVar = new deo(this, new cfx(this, 12));
            this.e = new but(deoVar, 10);
            deoVar.i();
            this.c.run();
        }
    }
}
