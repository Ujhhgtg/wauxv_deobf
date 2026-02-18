package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cq extends ccg {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ cw b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(cw cwVar, Context context, cbw cbwVar, View view) {
        super(context, cbwVar, view, true, R.attr.actionOverflowMenuStyle, 0);
        this.b = cwVar;
        this.i = 8388613;
        erp erpVar = cwVar.x;
        this.k = erpVar;
        cce cceVar = this.l;
        if (cceVar != null) {
            cceVar.ak(erpVar);
        }
    }

    @Override // me.hd.wauxv.obf.ccg
    public final void c() {
        switch (this.a) {
            case 0:
                cw cwVar = this.b;
                cwVar.u = null;
                cwVar.y = 0;
                super.c();
                break;
            default:
                cw cwVar2 = this.b;
                cbw cbwVar = cwVar2.c;
                if (cbwVar != null) {
                    cbwVar.ab(true);
                }
                cwVar2.t = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cq(cw cwVar, Context context, dnw dnwVar, View view) {
        super(context, dnwVar, view, false, R.attr.actionOverflowMenuStyle, 0);
        this.b = cwVar;
        if ((dnwVar.ax.z & 32) != 32) {
            View view2 = cwVar.j;
            this.h = view2 == null ? (View) cwVar.h : view2;
        }
        erp erpVar = cwVar.x;
        this.k = erpVar;
        cce cceVar = this.l;
        if (cceVar != null) {
            cceVar.ak(erpVar);
        }
    }
}
