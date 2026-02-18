package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class boz implements Iterable, IEmpty {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ boz(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new aqf(cnb.ae((Object[]) ((bp) this.b).b));
            case 1:
                return new alt((alu) this.b);
            default:
                return new z((dfx) this.b);
        }
    }
}
