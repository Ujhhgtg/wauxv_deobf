package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csf extends ckn {
    public csf(long j, SyntheticPileOfMess bmuVar, cwd cwdVar, dfx dfxVar) {
        rw rwVar = new rw();
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "writer");
        throwIfVar1IsNull(dfxVar, "descriptor");
        super(cwdVar, bmuVar, j, dfxVar, rwVar);
    }

    @Override // me.hd.wauxv.obf.cwn
    public final void _cb(long j, String str) {
        throwIfVar1IsNull(str, "value");
        throw new SomeIllegalArgumentException("Packing only supports primitive number types");
    }

    @Override // me.hd.wauxv.obf.ckn, me.hd.wauxv.obf.cwn
    public final long ae(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        return 19500L;
    }

    @Override // me.hd.wauxv.obf.ckn, me.hd.wauxv.obf.cwn
    public final void aj(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        if (this.ai.c > 0) {
            super.aj(dfxVar);
        }
    }

    @Override // me.hd.wauxv.obf.cwn, me.hd.wauxv.obf.avt
    public final acn o(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throw new SomeIllegalArgumentException("Packing only supports primitive number types");
    }

    @Override // me.hd.wauxv.obf.cwn, me.hd.wauxv.obf.avt
    public final acn v(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throw new SomeIllegalArgumentException("Packing only supports primitive number types");
    }
}
