package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ckn extends cwn {
    public final /* synthetic */ int af = 1;
    public final long ag;
    public final bmu ah;
    public final rw ai;

    public ckn(long j, bmu bmuVar, cwd cwdVar, dfx dfxVar) {
        rw rwVar = new rw();
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "parentWriter");
        throwIfVar1IsNull(dfxVar, "descriptor");
        super(cwdVar, new bmu(rwVar), dfxVar);
        this.ag = j;
        this.ah = bmuVar;
        this.ai = rwVar;
    }

    @Override // me.hd.wauxv.obf.cwn
    public long ae(dfx dfxVar, int i) {
        switch (this.af) {
            case 0:
                throwIfVar1IsNull(dfxVar, "<this>");
                return 1;
            default:
                return super.ae(dfxVar, i);
        }
    }

    @Override // me.hd.wauxv.obf.cwn
    public void aj(dfx dfxVar) {
        switch (this.af) {
            case 0:
                throwIfVar1IsNull(dfxVar, "descriptor");
                int i = (int) (this.ag & 2147483647L);
                bmu bmuVar = this.ah;
                bmuVar.getClass();
                rw rwVar = this.ai;
                throwIfVar1IsNull(rwVar, "output");
                bmuVar.n((rw) bmuVar.h, ProtoWireType.ENUM_LENGTH_DELIMITED.makeTag(i), cwf.DEFAULT);
                bmuVar.x(rwVar);
                break;
            default:
                throwIfVar1IsNull(dfxVar, "descriptor");
                long j = this.ag;
                rw rwVar2 = this.ai;
                bmu bmuVar2 = this.ah;
                if (j == 19500) {
                    bmuVar2.x(rwVar2);
                } else {
                    bmuVar2.getClass();
                    throwIfVar1IsNull(rwVar2, "output");
                    bmuVar2.n((rw) bmuVar2.h, ProtoWireType.ENUM_LENGTH_DELIMITED.makeTag((int) (j & 2147483647L)), cwf.DEFAULT);
                    bmuVar2.x(rwVar2);
                }
                break;
        }
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public ckn(cwd cwdVar, bmu bmuVar, long j, dfx dfxVar, rw rwVar) {
        super(cwdVar, new bmu(rwVar), dfxVar);
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "writer");
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ah = bmuVar;
        this.ag = j;
        this.ai = rwVar;
    }
}
