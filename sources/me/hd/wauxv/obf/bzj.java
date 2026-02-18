package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzj extends cwl {
    public final long ac;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bzj(cwd cwdVar, cwo cwoVar, long j, dfx dfxVar) {
        super(cwdVar, cwoVar, dfxVar);
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ac = j;
    }

    @Override // me.hd.wauxv.obf.cwl
    public final long ad(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        int i2 = i % 2;
        long j = this.ac;
        if (i2 == 0) {
            return ajn.r(j).e | ((long) 1);
        }
        return ((long) 2) | ajn.r(j).e;
    }
}
