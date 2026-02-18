package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbx implements adv {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bbx(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.adv
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                bby bbyVar = (bby) obj;
                if (bbyVar == null) {
                    bbyVar = new bby(-3);
                }
                ((io) this.b).aq(bbyVar);
                return;
            default:
                bby bbyVar2 = (bby) obj;
                synchronized (bbz.c) {
                    try {
                        dhq dhqVar = bbz.d;
                        ArrayList arrayList = (ArrayList) dhqVar.get((String) this.b);
                        if (arrayList == null) {
                            return;
                        }
                        dhqVar.remove((String) this.b);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((adv) arrayList.get(i)).accept(bbyVar2);
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
