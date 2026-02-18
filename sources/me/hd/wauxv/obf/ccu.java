package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ccu extends ng {
    public bfk be;
    public String bf;
    public String bg;
    public String bh;
    public String bi;
    public df bk;
    public cct bl;
    public final boolean bc = true;
    public final ccu bd = this;
    public final float bj = anj.d;

    @Override // me.hd.wauxv.obf.ng
    public String ao() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    @Override // me.hd.wauxv.obf.ng
    public void ay() {
        if (ar() != null) {
            ng.x(ar());
            this.n = false;
        }
        RelativeLayout relativeLayout = this.bl.g;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        ViewGroup viewGroup = this.bl.f;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        int iAq = aq(ax()) != 0 ? aq(ax()) : this.o.ak(ax());
        if (iAq == 0) {
            iAq = ax() ? R.layout.layout_dialogx_material : R.layout.layout_dialogx_material_dark;
        }
        this.q = 0L;
        View viewAn = an(iAq);
        this.bl = new cct(this, viewAn);
        if (viewAn != null) {
            viewAn.setTag(this.bd);
        }
        ng.ak(viewAn);
    }

    public boolean ba() {
        return this.m;
    }

    public ccu bb(qp qpVar) {
        this.j = qpVar;
        if (this.n) {
            qpVar.f(this);
        }
        return this;
    }

    public final void bm() {
        am();
        if (ar() != null) {
            ng.ak(ar());
            return;
        }
        int iAq = aq(ax()) != 0 ? aq(ax()) : this.o.ak(ax());
        if (iAq == 0) {
            iAq = ax() ? R.layout.layout_dialogx_material : R.layout.layout_dialogx_material_dark;
        }
        View viewAn = an(iAq);
        this.bl = new cct(this, viewAn);
        if (viewAn != null) {
            viewAn.setTag(this.bd);
        }
        ng.ak(viewAn);
    }
}
