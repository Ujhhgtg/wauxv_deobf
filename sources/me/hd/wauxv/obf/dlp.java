package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlp extends bqe {
    public int a;
    public final /* synthetic */ dlo b;

    public dlp(dlo dloVar) {
        this.b = dloVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.b.i();
    }

    @Override // me.hd.wauxv.obf.bqe
    public final int nextInt() {
        int i = this.a;
        this.a = i + 1;
        return this.b.g(i);
    }
}
