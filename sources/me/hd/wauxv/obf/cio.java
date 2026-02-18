package me.hd.wauxv.obf;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cio implements bup, err, bkg, dep {
    public final anr a;
    public cjg b;
    public final Bundle c;
    public buh d;
    public final ciy e;
    public final String f;
    public final Bundle g;
    public final ciq h = new ciq(this);

    public cio(anr anrVar, cjg cjgVar, Bundle bundle, buh buhVar, ciy ciyVar, String str, Bundle bundle2) {
        this.a = anrVar;
        this.b = cjgVar;
        this.c = bundle;
        this.d = buhVar;
        this.e = ciyVar;
        this.f = str;
        this.g = bundle2;
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x0036  */
    @Override // me.hd.wauxv.obf.bkg
    public final chq ai() {
        Application application;
        ciq ciqVar = this.h;
        ciqVar.getClass();
        chq chqVar = new chq(0);
        cbm cbmVar = aye.d;
        cio cioVar = ciqVar.a;
        LinkedHashMap linkedHashMap = chqVar.c;
        linkedHashMap.put(cbmVar, cioVar);
        linkedHashMap.put(aye.e, cioVar);
        Bundle bundleL = ciqVar.l();
        if (bundleL != null) {
            linkedHashMap.put(aye.f, bundleL);
        }
        anr anrVar = this.a;
        if (anrVar != null) {
            Context applicationContext = anrVar.b.getApplicationContext();
            application = applicationContext instanceof Application ? (Application) applicationContext : null;
        }
        Application application2 = application != null ? application : null;
        if (application2 != null) {
            linkedHashMap.put(ern.n, application2);
        }
        return chqVar;
    }

    @Override // me.hd.wauxv.obf.err
    public final erq aj() {
        ciq ciqVar = this.h;
        if (!ciqVar.i) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        }
        if (ciqVar.j.c == buh.a) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
        ciy ciyVar = ciqVar.e;
        if (ciyVar == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        }
        String str = ciqVar.f;
        bzo.q(str, "backStackEntryId");
        LinkedHashMap linkedHashMap = ciyVar.a;
        erq erqVar = (erq) linkedHashMap.get(str);
        if (erqVar != null) {
            return erqVar;
        }
        erq erqVar2 = new erq();
        linkedHashMap.put(str, erqVar2);
        return erqVar2;
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        return (but) this.h.h.c;
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.h.j;
    }

    public final boolean equals(Object obj) {
        Set<String> setKeySet;
        if (obj != null && (obj instanceof cio)) {
            cio cioVar = (cio) obj;
            Bundle bundle = cioVar.c;
            if (bzo.f(this.f, cioVar.f) && bzo.f(this.b, cioVar.b) && bzo.f(this.h.j, cioVar.h.j) && bzo.f(ak(), cioVar.ak())) {
                Bundle bundle2 = this.c;
                if (bzo.f(bundle2, bundle)) {
                    return true;
                }
                if (bundle2 != null && (setKeySet = bundle2.keySet()) != null) {
                    if (setKeySet.isEmpty()) {
                        return true;
                    }
                    for (String str : setKeySet) {
                        if (!bzo.f(bundle2.get(str), bundle != null ? bundle.get(str) : null)) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Set<String> setKeySet;
        int iHashCode = this.b.hashCode() + (this.f.hashCode() * 31);
        Bundle bundle = this.c;
        if (bundle != null && (setKeySet = bundle.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                int i = iHashCode * 31;
                Object obj = bundle.get((String) it.next());
                iHashCode = i + (obj != null ? obj.hashCode() : 0);
            }
        }
        return ak().hashCode() + ((this.h.j.hashCode() + (iHashCode * 31)) * 31);
    }

    public final void i(buh buhVar) {
        ciq ciqVar = this.h;
        ciqVar.getClass();
        ciqVar.k = buhVar;
        ciqVar.m();
    }

    public final String toString() {
        return this.h.toString();
    }
}
