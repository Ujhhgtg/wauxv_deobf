package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbn extends cwn {
    public final long af;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dbn(long j, bmu bmuVar, cwd cwdVar, dfx dfxVar) {
        super(cwdVar, bmuVar, dfxVar);
        bzo.q(cwdVar, "proto");
        bzo.q(bmuVar, "writer");
        bzo.q(dfxVar, "descriptor");
        this.af = j;
    }

    @Override // me.hd.wauxv.obf.cwn
    public final long ae(dfx dfxVar, int i) {
        bzo.q(dfxVar, "<this>");
        return this.af;
    }
}
