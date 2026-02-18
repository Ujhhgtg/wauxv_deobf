package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcf extends bda {
    public final /* synthetic */ bcg a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bcf(dlc dlcVar, bcg bcgVar) {
        super(dlcVar);
        this.a = bcgVar;
    }

    @Override // me.hd.wauxv.obf.bda, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.a.close();
        super.close();
    }
}
