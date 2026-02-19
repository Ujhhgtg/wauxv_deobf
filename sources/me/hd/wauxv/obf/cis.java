package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cis implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ cjl b;

    public /* synthetic */ cis(cjl cjlVar, int i) {
        this.a = i;
        this.b = cjlVar;
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Type inference failed for: r0v2, types: [me.hd.wauxv.obf.bfu, me.hd.wauxv.obf.bgr] */
    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        boolean z;
        switch (this.a) {
            case 0:
                cjl cjlVar = this.b;
                bdx bdxVar = cjlVar.f;
                if (cjlVar.g) {
                    z = cjlVar.i() > 1;
                }
                bdxVar.a = z;
                ?? r0 = bdxVar.c;
                if (r0 != 0) {
                    r0.invoke();
                }
                return Kotlin$Unit.INSTANCE;
            default:
                cjl cjlVar2 = this.b;
                return new cjm(cjlVar2.a, cjlVar2.b.r);
        }
    }
}
