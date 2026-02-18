package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwf implements ccm, AdapterView.OnItemClickListener {
    public Context a;
    public LayoutInflater b;
    public cbw c;
    public ExpandedMenuView d;
    public ccl e;
    public bwe f;

    public bwf(ContextWrapper contextWrapper) {
        this.a = contextWrapper;
        this.b = LayoutInflater.from(contextWrapper);
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
        ccl cclVar = this.e;
        if (cclVar != null) {
            cclVar.c(cbwVar, z);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ab(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        bwe bweVar = this.f;
        if (bweVar != null) {
            bweVar.notifyDataSetChanged();
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ad() {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ae(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void af(Context context, cbw cbwVar) {
        if (this.a != null) {
            this.a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(context);
            }
        }
        this.c = cbwVar;
        bwe bweVar = this.f;
        if (bweVar != null) {
            bweVar.notifyDataSetChanged();
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        boolean zHasVisibleItems = dnwVar.hasVisibleItems();
        Context context = dnwVar.b;
        if (!zHasVisibleItems) {
            return false;
        }
        cbx cbxVar = new cbx();
        cbxVar.a = dnwVar;
        ek ekVar = new ek(context);
        eg egVar = (eg) ekVar.d;
        bwf bwfVar = new bwf(egVar.a);
        cbxVar.e = bwfVar;
        bwfVar.e = cbxVar;
        dnwVar.aa(bwfVar, context);
        bwf bwfVar2 = cbxVar.e;
        if (bwfVar2.f == null) {
            bwfVar2.f = new bwe(bwfVar2);
        }
        egVar.p = bwfVar2.f;
        egVar.q = cbxVar;
        View view = dnwVar.p;
        if (view != null) {
            egVar.e = view;
        } else {
            egVar.c = dnwVar.o;
            egVar.d = dnwVar.n;
        }
        egVar.o = cbxVar;
        el elVarI = ekVar.i();
        cbxVar.b = elVarI;
        elVarI.setOnDismissListener(cbxVar);
        WindowManager.LayoutParams attributes = cbxVar.b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        cbxVar.b.show();
        ccl cclVar = this.e;
        if (cclVar == null) {
            return true;
        }
        cclVar.d(dnwVar);
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ak(ccl cclVar) {
        throw null;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        if (this.d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final int getId() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.c.ap(this.f.getItem(i), this, 0);
    }
}
