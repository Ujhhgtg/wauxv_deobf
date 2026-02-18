package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cjh implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ cjd b;

    public /* synthetic */ cjh(cjd cjdVar, int i) {
        this.a = i;
        this.b = cjdVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        boolean zContains;
        String str = (String) obj;
        switch (this.a) {
            case 0:
                bzo.q(str, "key");
                zContains = this.b.z().contains(str);
                break;
            default:
                bzo.q(str, "key");
                zContains = this.b.z().contains(str);
                break;
        }
        return Boolean.valueOf(!zContains);
    }
}
