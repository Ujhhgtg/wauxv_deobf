package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lb implements dft {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ lb(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return cnb.ae((Object[]) this.b);
            case 1:
                return ((Iterable) this.b).iterator();
            case 2:
                return (Iterator) this.b;
            default:
                return new z((don) this.b, 8);
        }
    }
}
