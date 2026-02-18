package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class awr extends aws {
    public final tc a;
    public final /* synthetic */ awu b;

    public awr(awu awuVar, long j, tc tcVar) {
        this.b = awuVar;
        this.c = j;
        this.d = -1;
        this.a = tcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws aoq {
        this.a.y(this.b);
    }

    @Override // me.hd.wauxv.obf.aws
    public final String toString() {
        return super.toString() + this.a;
    }
}
