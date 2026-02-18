package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bjt implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bgf b;
    public final /* synthetic */ Object c;

    public /* synthetic */ bjt(bgf bgfVar, Object obj, int i) {
        this.a = i;
        this.b = bgfVar;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                this.b.invoke(this.c);
                break;
            default:
                this.b.invoke(this.c);
                break;
        }
    }
}
