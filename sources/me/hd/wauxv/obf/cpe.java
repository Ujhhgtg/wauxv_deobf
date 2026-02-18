package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cpe implements btd {
    public final btd b;
    public final dfy d;

    public cpe(btd btdVar) {
        bzo.q(btdVar, "serializer");
        this.b = btdVar;
        this.d = new dfy(btdVar.getDescriptor());
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        if (ajtVar.x()) {
            return ajtVar.t(this.b);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        if (obj != null) {
            avtVar.x(this.b, obj);
        } else {
            avtVar.q();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && cpe.class == obj.getClass() && bzo.f(this.b, ((cpe) obj).b);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.d;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
