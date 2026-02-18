package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emt implements btd {
    public static final emt b = new emt();
    public static final bpj d = bmy.j("kotlin.UByte", si.b);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return new emp(ajtVar.u(d).y());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        avtVar.r(d).u(((emp) obj).a);
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
