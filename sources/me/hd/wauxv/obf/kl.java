package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kl extends bwd {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kl(dfx dfxVar, int i) {
        super(dfxVar);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        switch (this.a) {
            case 0:
                return "kotlin.Array";
            case 1:
                return "kotlin.collections.ArrayList";
            default:
                return "kotlin.collections.LinkedHashSet";
        }
    }
}
