package me.hd.wauxv.obf;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zs implements View.OnFocusChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ awb b;

    public /* synthetic */ zs(awb awbVar, int i) {
        this.a = i;
        this.b = awbVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.a) {
            case 0:
                zv zvVar = (zv) this.b;
                zvVar.t(zvVar.u());
                break;
            default:
                aql aqlVar = (aql) this.b;
                aqlVar.h = z;
                aqlVar.al();
                if (!z) {
                    aqlVar.ad(false);
                    aqlVar.i = false;
                }
                break;
        }
    }
}
