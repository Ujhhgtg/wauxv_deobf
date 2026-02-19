package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cse extends cwl {
    public int ac;

    @Override // me.hd.wauxv.obf.cwl
    public final long ad(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        return 19500L;
    }

    @Override // me.hd.wauxv.obf.cwl
    public final String ag(long j) {
        throw new SomeIllegalArgumentException("Packing only supports primitive number types. The actual reading is for string.");
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        ProtoReader protoReaderVar = this.ai;
        if (!protoReaderVar.isPushed) {
            SourceBuffer sourceBufferVar = protoReaderVar.sourceBuffer;
            if (sourceBufferVar.a - sourceBufferVar.b == 0) {
                return -1;
            }
        }
        int i = this.ac;
        this.ac = i + 1;
        return i;
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.ajt
    public final acm p(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throw new SomeIllegalArgumentException("Packing only supports primitive number types. The input type however was a struct: " + dfxVar);
    }
}
