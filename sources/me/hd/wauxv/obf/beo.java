package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class beo implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ beo(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                csm csmVar = (csm) obj;
                bzo.q(csmVar, "it");
                return Boolean.valueOf(bzo.f(csmVar.a, this.b));
            case 1:
                eoj eojVar = (eoj) obj;
                eojVar.h(dip.a.o());
                String str = this.b;
                bzo.q(str, "name");
                eojVar.d.tag(cne.class, new cne(str));
                return ens.a;
            case 2:
                ((eoj) obj).h(this.b);
                return ens.a;
            case 3:
                ((eoj) obj).h(this.b);
                return ens.a;
            case 4:
                ((eoj) obj).h(this.b);
                return ens.a;
            case 5:
                ((eoj) obj).h(this.b);
                return ens.a;
            case 6:
                ((eoj) obj).h(this.b);
                return ens.a;
            default:
                ((eoj) obj).h(this.b);
                return ens.a;
        }
    }
}
