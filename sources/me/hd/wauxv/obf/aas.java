package me.hd.wauxv.obf;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aas {
    public final /* synthetic */ int a;
    public final /* synthetic */ aat b;

    public /* synthetic */ aas(aat aatVar, int i) {
        this.a = i;
        this.b = aatVar;
    }

    public final void c(Typeface typeface) {
        switch (this.a) {
            case 0:
                aat aatVar = this.b;
                if (aatVar.cd(typeface)) {
                    aatVar.bz(false);
                }
                break;
            default:
                aat aatVar2 = this.b;
                if (aatVar2.cf(typeface)) {
                    aatVar2.bz(false);
                }
                break;
        }
    }
}
