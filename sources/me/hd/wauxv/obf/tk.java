package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tk implements Runnable {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public tk(erp erpVar, tl tlVar, cbz cbzVar, cbw cbwVar) {
        this.e = erpVar;
        this.b = tlVar;
        this.c = cbzVar;
        this.d = cbwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                tm tmVar = (tm) ((erp) this.e).v;
                cbz cbzVar = (cbz) this.c;
                tl tlVar = (tl) this.b;
                if (tlVar != null) {
                    tmVar.z = true;
                    tlVar.b.ab(false);
                    tmVar.z = false;
                }
                if (cbzVar.isEnabled() && cbzVar.hasSubMenu()) {
                    ((cbw) this.d).ap(cbzVar, null, 4);
                    break;
                }
                break;
            default:
                euw.h((View) this.b, (eva) this.c, (but) this.d);
                ((ValueAnimator) this.e).start();
                break;
        }
    }

    public tk(View view, eva evaVar, but butVar, ValueAnimator valueAnimator) {
        this.b = view;
        this.c = evaVar;
        this.d = butVar;
        this.e = valueAnimator;
    }
}
