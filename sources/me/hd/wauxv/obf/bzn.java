package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzn extends ckn {
    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bzn(long j, bmu bmuVar, cwd cwdVar, dfx dfxVar) {
        super(j, bmuVar, cwdVar, dfxVar);
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "parentWriter");
        throwIfVar1IsNull(dfxVar, "descriptor");
    }

    @Override // me.hd.wauxv.obf.ckn, me.hd.wauxv.obf.cwn
    public final long ae(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        int i2 = i % 2;
        long j = this.ag;
        if (i2 == 0) {
            return ajn.r(j).e | ((long) 1);
        }
        return ((long) 2) | ajn.r(j).e;
    }
}
