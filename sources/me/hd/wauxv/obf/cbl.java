package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cbl implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ cbl(int i, int i2, int i3) {
        this.a = i3;
        this.b = i;
        this.c = i2;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                csm csmVar = (csm) obj;
                String str = (String) csmVar.a;
                String str2 = (String) csmVar.b;
                return "| " + cbp.d(this.b, str) + " | " + cbp.d(this.c, str2) + " |";
            default:
                cba cbaVar = (cba) obj;
                bzo.q(cbaVar, "it");
                int i = cbaVar.a;
                return Boolean.valueOf(this.b <= i && i <= this.c);
        }
    }
}
