package me.hd.wauxv.obf;

import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfn implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bfo b;

    public /* synthetic */ bfn(bfo bfoVar, int i) {
        this.a = i;
        this.b = bfoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                bfo bfoVar = this.b;
                bfoVar.e.setY(bfoVar.c.getHeight());
                bfp bfpVar = bfoVar.l;
                if (bfpVar.be == null) {
                    bfpVar.be = new bfk(bfoVar, 0);
                }
                bfpVar.be.aq(bfpVar.bf);
                bfpVar.az(buh.e);
                break;
            default:
                bfo bfoVar2 = this.b;
                DialogXBaseRelativeLayout dialogXBaseRelativeLayout = bfoVar2.c;
                if (dialogXBaseRelativeLayout != null) {
                    dialogXBaseRelativeLayout.setVisibility(8);
                }
                ng.x(bfoVar2.l.ar());
                break;
        }
    }
}
