package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ack extends cxc {
    public final boolean a;

    public ack(ek ekVar, boolean z) {
        super(ekVar);
        this.a = z;
    }

    @Override // me.hd.wauxv.obf.cxc
    public final void b(String str) {
        bzo.q(str, "value");
        if (this.a) {
            super.b(str);
        } else {
            n(str);
        }
    }
}
