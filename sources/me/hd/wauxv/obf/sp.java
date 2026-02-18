package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sp extends ku {
    public int f;

    @Override // me.hd.wauxv.obf.dhq, java.util.Map
    public final void clear() {
        this.f = 0;
        super.clear();
    }

    @Override // me.hd.wauxv.obf.dhq
    public final void g(ku kuVar) {
        this.f = 0;
        super.g(kuVar);
    }

    @Override // me.hd.wauxv.obf.dhq
    public final Object h(int i) {
        this.f = 0;
        return super.h(i);
    }

    @Override // me.hd.wauxv.obf.dhq, java.util.Map
    public final int hashCode() {
        if (this.f == 0) {
            this.f = super.hashCode();
        }
        return this.f;
    }

    @Override // me.hd.wauxv.obf.dhq
    public final Object i(int i, Object obj) {
        this.f = 0;
        return super.i(i, obj);
    }

    @Override // me.hd.wauxv.obf.dhq, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f = 0;
        return super.put(obj, obj2);
    }
}
