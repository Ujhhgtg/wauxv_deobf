package me.hd.wauxv.obf;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpo extends ccu {
    @Override // me.hd.wauxv.obf.ccu, me.hd.wauxv.obf.ng
    public final String ao() {
        return bpo.class.getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    @Override // me.hd.wauxv.obf.ccu, me.hd.wauxv.obf.ng
    public final void ay() {
        EditText editText;
        if (ar() != null) {
            ng.x(ar());
            this.n = false;
        }
        RelativeLayout relativeLayout = this.bl.g;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        int iAq = aq(ax()) != 0 ? aq(ax()) : this.o.ak(ax());
        if (iAq == 0) {
            iAq = ax() ? R.layout.layout_dialogx_material : R.layout.layout_dialogx_material_dark;
        }
        cct cctVar = this.bl;
        String string = (cctVar == null || (editText = cctVar.h) == null) ? this.bi : editText.getText().toString();
        this.q = 0L;
        View viewAn = an(iAq);
        this.bl = new cct(this, viewAn);
        if (viewAn != null) {
            viewAn.setTag(this.bd);
        }
        ng.ak(viewAn);
        this.bi = string;
        if (this.bl == null) {
            return;
        }
        ng.aj(new ccq(this, 0));
    }

    @Override // me.hd.wauxv.obf.ccu
    public final boolean ba() {
        return this.m;
    }

    @Override // me.hd.wauxv.obf.ccu
    public final ccu bb(qp qpVar) {
        this.j = qpVar;
        if (this.n) {
            qpVar.f(this);
        }
        return this;
    }
}
