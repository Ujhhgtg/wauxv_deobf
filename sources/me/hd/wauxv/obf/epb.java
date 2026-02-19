package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epb extends din implements ctk {
    public final String a;
    public final String e;
    public final ConnectivityMonitor f;

    public epb(int i, String str, String str2, ConnectivityMonitor connectivityMonitorVar) {
        super(i);
        this.a = str;
        this.e = str2;
        this.f = connectivityMonitorVar;
    }

    @Override // me.hd.wauxv.obf.din
    public final din b() {
        int i = this.c;
        epb epbVar = new epb(i, this.a, this.e, null);
        int i2 = this.d;
        epbVar.c = i;
        epbVar.d = i2;
        return epbVar;
    }

    public final Object clone() {
        int i = this.c;
        epb epbVar = new epb(i, this.a, this.e, null);
        int i2 = this.d;
        epbVar.c = i;
        epbVar.d = i2;
        return epbVar;
    }
}
