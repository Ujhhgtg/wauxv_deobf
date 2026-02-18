package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hp implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ic b;

    public /* synthetic */ hp(ic icVar, int i) {
        this.a = i;
        this.b = icVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.a) {
            case 0:
                ic icVar = this.b;
                if ((icVar.bm & 1) != 0) {
                    icVar.ce(0);
                }
                if ((icVar.bm & 4096) != 0) {
                    icVar.ce(108);
                }
                icVar.bl = false;
                icVar.bm = 0;
                break;
            default:
                ic icVar2 = this.b;
                icVar2.aj.showAtLocation(icVar2.ai, 55, 0, 0);
                esg esgVar = icVar2.al;
                if (esgVar != null) {
                    esgVar.c();
                }
                if (icVar2.am && (viewGroup = icVar2.an) != null && viewGroup.isLaidOut()) {
                    icVar2.ai.setAlpha(0.0f);
                    esg esgVarG = eqz.g(icVar2.ai);
                    esgVarG.b(1.0f);
                    icVar2.al = esgVarG;
                    esgVarG.e(new hr(this, 0));
                } else {
                    icVar2.ai.setAlpha(1.0f);
                    icVar2.ai.setVisibility(0);
                }
                break;
        }
    }
}
