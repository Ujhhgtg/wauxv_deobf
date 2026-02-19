package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buq {
    public buh a;
    public bul b;

    public final void c(bup bupVar, LifeEventEnum lifeEventEnumVar) {
        buh buhVarA = lifeEventEnumVar.a();
        buh buhVar = this.a;
        throwIfVar1IsNull(buhVar, "state1");
        if (buhVarA.compareTo(buhVar) < 0) {
            buhVar = buhVarA;
        }
        this.a = buhVar;
        this.b.e(bupVar, lifeEventEnumVar);
        this.a = buhVarA;
    }
}
