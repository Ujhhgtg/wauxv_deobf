package me.hd.wauxv.obf;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SomeFragmentManager implements ComponentCallbacks, View.OnCreateContextMenuListener, bup, err, bkg, dep {
    public static final Object ar = new Object();
    public Bundle at;
    public SparseArray au;
    public Bundle av;
    public Bundle ax;
    public SomeFragmentManager ay;
    public int ba;
    public boolean bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    public boolean bg;
    public boolean bh;
    public boolean bi;
    public boolean bj;
    public boolean bk;
    public int bl;
    public beg bm;
    public bdm bn;
    public SomeFragmentManager bp;
    public int bq;
    public int br;
    public String bs;
    public boolean bt;
    public boolean bu;
    public boolean bv;
    public boolean bx;
    public ViewGroup by;
    public View bz;
    public boolean ca;
    public bdg cc;
    public boolean cd;
    public boolean ce;
    public String cf;
    public buh cg;
    public bur ch;
    public bfg ci;
    public final chv cj;
    public but ck;
    public final AtomicInteger cl;
    public final ArrayList cm;
    public final bdd cn;
    public int as = -1;
    public String aw = UUID.randomUUID().toString();
    public String az = null;
    public Boolean bb = null;
    public beg bo = new beg();
    public boolean bw = true;
    public boolean cb = true;

    public SomeFragmentManager() {
        new dc(this, 7);
        this.cg = buh.e;
        this.cj = new chv();
        this.cl = new AtomicInteger();
        this.cm = new ArrayList();
        this.cn = new bdd(this);
        ct();
    }

    public LayoutInflater aa(Bundle bundle) {
        bdm bdmVar = this.bn;
        if (bdmVar == null) {
            throw new IllegalStateException(
                    "onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        hb hbVar = bdmVar.h;
        LayoutInflater layoutInflaterCloneInContext = hbVar.getLayoutInflater().cloneInContext(hbVar);
        layoutInflaterCloneInContext.setFactory2(this.bo.f);
        return layoutInflaterCloneInContext;
    }

    public void ab() {
        this.bx = true;
    }

    public void ac() {
        this.bx = true;
    }

    public void ad(Bundle bundle) {
        this.bx = true;
    }

    public void ae(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.bo.ck();
        this.bk = true;
        this.ci = new bfg(this, aj(), new dh(this, 13));
        View viewG = g(layoutInflater, viewGroup);
        this.bz = viewG;
        if (viewG == null) {
            if (this.ci.d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.ci = null;
            return;
        }
        this.ci.g();
        if (beg.ar(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.bz + " for Fragment " + this);
        }
        View view = this.bz;
        bfg bfgVar = this.ci;
        throwIfVar1IsNull(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, bfgVar);
        View view2 = this.bz;
        bfg bfgVar2 = this.ci;
        throwIfVar1IsNull(view2, "<this>");
        view2.setTag(R.id.view_tree_view_model_store_owner, bfgVar2);
        View view3 = this.bz;
        bfg bfgVar3 = this.ci;
        throwIfVar1IsNull(view3, "<this>");
        view3.setTag(R.id.view_tree_saved_state_registry_owner, bfgVar3);
        chv chvVar = this.cj;
        bfg bfgVar4 = this.ci;
        chvVar.getClass();
        chv.k("setValue");
        chvVar.h++;
        chvVar.f = bfgVar4;
        chvVar.m(null);
    }

    @Override // me.hd.wauxv.obf.bkg
    public final chq ai() {
        Application application;
        Context applicationContext = dc().getApplicationContext();
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
        if (application == null && beg.ar(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + dc().getApplicationContext()
                    + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        chq chqVar = new chq(0);
        LinkedHashMap linkedHashMap = chqVar.c;
        if (application != null) {
            linkedHashMap.put(ern.n, application);
        }
        linkedHashMap.put(aye.d, this);
        linkedHashMap.put(aye.e, this);
        Bundle bundle = this.ax;
        if (bundle != null) {
            linkedHashMap.put(aye.f, bundle);
        }
        return chqVar;
    }

    @Override // me.hd.wauxv.obf.err
    public final erq aj() {
        if (this.bm == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (cr() == 1) {
            throw new IllegalStateException(
                    "Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.bm.ao.d;
        erq erqVar = (erq) map.get(this.aw);
        if (erqVar != null) {
            return erqVar;
        }
        erq erqVar2 = new erq();
        map.put(this.aw, erqVar2);
        return erqVar2;
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        return (but) this.ck.c;
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.ch;
    }

    public final bdg co() {
        if (this.cc == null) {
            bdg bdgVar = new bdg();
            Object obj = ar;
            bdgVar.g = obj;
            bdgVar.h = obj;
            bdgVar.i = obj;
            bdgVar.j = 1.0f;
            bdgVar.k = null;
            this.cc = bdgVar;
        }
        return this.cc;
    }

    public final beg cp() {
        if (this.bn != null) {
            return this.bo;
        }
        throw new IllegalStateException(yg.l("Fragment ", this, " has not been attached yet."));
    }

    public final Context cq() {
        bdm bdmVar = this.bn;
        if (bdmVar == null) {
            return null;
        }
        return bdmVar.e;
    }

    public final int cr() {
        buh buhVar = this.cg;
        return (buhVar == buh.b || this.bp == null) ? buhVar.ordinal() : Math.min(buhVar.ordinal(), this.bp.cr());
    }

    public final beg cs() {
        beg begVar = this.bm;
        if (begVar != null) {
            return begVar;
        }
        throw new IllegalStateException(yg.l("Fragment ", this, " not associated with a fragment manager."));
    }

    public final void ct() {
        this.ch = new bur(this);
        this.ck = new but(new deo(this, new cfx(this, 12)), 10);
        ArrayList arrayList = this.cm;
        bdd bddVar = this.cn;
        if (arrayList.contains(bddVar)) {
            return;
        }
        if (this.as >= 0) {
            bddVar.b();
        } else {
            arrayList.add(bddVar);
        }
    }

    public final void cu() {
        ct();
        this.cf = this.aw;
        this.aw = UUID.randomUUID().toString();
        this.bc = false;
        this.bd = false;
        this.bg = false;
        this.bh = false;
        this.bj = false;
        this.bl = 0;
        this.bm = null;
        this.bo = new beg();
        this.bn = null;
        this.bq = 0;
        this.br = 0;
        this.bs = null;
        this.bt = false;
        this.bu = false;
    }

    public final boolean cv() {
        return this.bn != null && this.bc;
    }

    public final boolean cw() {
        if (this.bt) {
            return true;
        }
        beg begVar = this.bm;
        if (begVar != null) {
            SomeFragmentManager someFragmentManagerVar = this.bp;
            begVar.getClass();
            if (someFragmentManagerVar == null ? false : someFragmentManagerVar.cw()) {
                return true;
            }
        }
        return false;
    }

    public final boolean cx() {
        return this.bl > 0;
    }

    public final void cy(int i, int i2, Intent intent) {
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: "
                    + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void cz() {
        this.bx = true;
    }

    public final bdc da(dq dqVar, bhs bhsVar) {
        j jVar = (j) this;
        erp erpVar = new erp(jVar, 24);
        if (this.as > 1) {
            throw new IllegalStateException(yg.l("Fragment ", this,
                    " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        bdf bdfVar = new bdf(jVar, erpVar, atomicReference, bhsVar, dqVar);
        if (this.as >= 0) {
            bdfVar.b();
        } else {
            this.cm.add(bdfVar);
        }
        return new bdc(atomicReference);
    }

    public final hb db() {
        bdm bdmVar = this.bn;
        hb hbVar = bdmVar == null ? null : bdmVar.a;
        if (hbVar != null) {
            return hbVar;
        }
        throw new IllegalStateException(yg.l("Fragment ", this, " not attached to an activity."));
    }

    public final Context dc() {
        Context contextCq = cq();
        if (contextCq != null) {
            return contextCq;
        }
        throw new IllegalStateException(yg.l("Fragment ", this, " not attached to a context."));
    }

    public final View dd() {
        View view = this.bz;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(yg.l("Fragment ", this,
                " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public final void de(int i, int i2, int i3, int i4) {
        if (this.cc == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        co().b = i;
        co().c = i2;
        co().d = i3;
        co().e = i4;
    }

    public final void df(Bundle bundle) {
        beg begVar = this.bm;
        if (begVar != null) {
            if (begVar == null ? false : begVar.ci()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.ax = bundle;
    }

    public void e(Context context) {
        this.bx = true;
        bdm bdmVar = this.bn;
        if ((bdmVar == null ? null : bdmVar.a) != null) {
            this.bx = true;
        }
    }

    public void f(Bundle bundle) {
        Bundle bundle2;
        this.bx = true;
        Bundle bundle3 = this.at;
        if (bundle3 != null && (bundle2 = bundle3.getBundle("childFragmentManager")) != null) {
            this.bo.cq(bundle2);
            beg begVar = this.bo;
            begVar.ah = false;
            begVar.ai = false;
            begVar.ao.g = false;
            begVar.bq(1);
        }
        beg begVar2 = this.bo;
        if (begVar2.v >= 1) {
            return;
        }
        begVar2.ah = false;
        begVar2.ai = false;
        begVar2.ao.g = false;
        begVar2.bq(1);
    }

    public View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    public void h() {
        this.bx = true;
    }

    public void i(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.bx = true;
        bdm bdmVar = this.bn;
        if ((bdmVar == null ? null : bdmVar.a) != null) {
            this.bx = true;
        }
    }

    public void j(Bundle bundle) {
    }

    public void k(View view) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.bx = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view,
            ContextMenu.ContextMenuInfo contextMenuInfo) {
        db().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.bx = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.aw);
        if (this.bq != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.bq));
        }
        if (this.bs != null) {
            sb.append(" tag=");
            sb.append(this.bs);
        }
        sb.append(")");
        return sb.toString();
    }

    public cnb x() {
        return new bde(this);
    }

    public void y() {
        this.bx = true;
    }

    public void z() {
        this.bx = true;
    }
}
