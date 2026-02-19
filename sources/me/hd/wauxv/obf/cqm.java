package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqm extends btp implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ cqt b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cqm(cqt cqtVar, int i) {
        super(0);
        this.a = i;
        this.b = cqtVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                this.b.i();
                break;
            case 1:
                this.b.h();
                break;
            default:
                this.b.i();
                break;
        }
        return Kotlin$Unit.INSTANCE;
    }
}
