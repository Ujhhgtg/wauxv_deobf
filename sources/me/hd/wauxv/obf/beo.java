package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class beo implements IInvokable {
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
                Pair pairVar = (Pair) obj;
                throwIfVar1IsNull(pairVar, "it");
                return Boolean.valueOf(nullSafeIsEqual(pairVar.first, this.b));
            case 1:
                eoj eojVar = (eoj) obj;
                eojVar.h(dip.a.o());
                String str = this.b;
                throwIfVar1IsNull(str, "name");
                eojVar.d.tag(cne.class, new cne(str));
                return Kotlin$Unit.INSTANCE;
            case 2:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
            case 3:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
            case 4:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
            case 5:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
            case 6:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
            default:
                ((eoj) obj).h(this.b);
                return Kotlin$Unit.INSTANCE;
        }
    }
}
