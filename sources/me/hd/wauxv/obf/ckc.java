package me.hd.wauxv.obf;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ckc implements ccm {
    public cka a;
    public boolean b;
    public int c;

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ab(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        mi miVar;
        if (this.b) {
            return;
        }
        if (z) {
            this.a.aq();
            return;
        }
        cka ckaVar = this.a;
        cbw cbwVar = ckaVar.ao;
        if (cbwVar == null || ckaVar.p == null) {
            return;
        }
        int size = cbwVar.g.size();
        if (size != ckaVar.p.length) {
            ckaVar.aq();
            return;
        }
        int i = ckaVar.q;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = ckaVar.ao.getItem(i2);
            if (item.isChecked()) {
                ckaVar.q = item.getItemId();
                ckaVar.r = i2;
            }
        }
        if (i != ckaVar.q && (miVar = ckaVar.k) != null) {
            elp.d(ckaVar, miVar);
        }
        boolean zAp = cka.ap(ckaVar.o, ckaVar.ao.ak().size());
        for (int i3 = 0; i3 < size; i3++) {
            ckaVar.an.b = true;
            ckaVar.p[i3].setLabelVisibilityMode(ckaVar.o);
            ckaVar.p[i3].setShifting(zAp);
            ckaVar.p[i3].n((cbz) ckaVar.ao.getItem(i3));
            ckaVar.an.b = false;
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
        this.a.ao = cbwVar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
        if (parcelable instanceof ckb) {
            cka ckaVar = this.a;
            ckb ckbVar = (ckb) parcelable;
            int i = ckbVar.a;
            int size = ckaVar.ao.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = ckaVar.ao.getItem(i2);
                if (i == item.getItemId()) {
                    ckaVar.q = i;
                    ckaVar.r = i2;
                    item.setChecked(true);
                    break;
                }
            }
            Context context = this.a.getContext();
            csw cswVar = ckbVar.b;
            SparseArray sparseArray = new SparseArray(cswVar.size());
            for (int i3 = 0; i3 < cswVar.size(); i3++) {
                int iKeyAt = cswVar.keyAt(i3);
                my myVar = (my) cswVar.valueAt(i3);
                sparseArray.put(iKeyAt, myVar != null ? new mx(context, myVar) : null);
            }
            cka ckaVar2 = this.a;
            SparseArray sparseArray2 = ckaVar2.ac;
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                int iKeyAt2 = sparseArray.keyAt(i4);
                if (sparseArray2.indexOfKey(iKeyAt2) < 0) {
                    sparseArray2.append(iKeyAt2, (mx) sparseArray.get(iKeyAt2));
                }
            }
            cjy[] cjyVarArr = ckaVar2.p;
            if (cjyVarArr != null) {
                for (cjy cjyVar : cjyVarArr) {
                    mx mxVar = (mx) sparseArray2.get(cjyVar.getId());
                    if (mxVar != null) {
                        cjyVar.setBadge(mxVar);
                    }
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        ckb ckbVar = new ckb();
        ckbVar.a = this.a.getSelectedItemId();
        SparseArray<mx> badgeDrawables = this.a.getBadgeDrawables();
        csw cswVar = new csw();
        for (int i = 0; i < badgeDrawables.size(); i++) {
            int iKeyAt = badgeDrawables.keyAt(i);
            mx mxVarValueAt = badgeDrawables.valueAt(i);
            cswVar.put(iKeyAt, mxVarValueAt != null ? mxVarValueAt.e.a : null);
        }
        ckbVar.b = cswVar;
        return ckbVar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final int getId() {
        return this.c;
    }
}
