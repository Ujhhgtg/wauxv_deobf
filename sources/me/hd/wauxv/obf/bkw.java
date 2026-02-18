package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bkw extends adq {
    public adq[] ev = new adq[4];
    public int ew = 0;

    public void er() {
    }

    public final void ex(int i, ArrayList arrayList, eum eumVar) {
        for (int i2 = 0; i2 < this.ew; i2++) {
            adq adqVar = this.ev[i2];
            ArrayList arrayList2 = eumVar.b;
            if (!arrayList2.contains(adqVar)) {
                arrayList2.add(adqVar);
            }
        }
        for (int i3 = 0; i3 < this.ew; i3++) {
            emn.ai(this.ev[i3], i, arrayList, eumVar);
        }
    }
}
