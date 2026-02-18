package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class coi {
    public coi i = null;
    public coi j = null;
    public coi k = null;
    public coi l = null;
    public coi m = null;

    public coi a() {
        return this.i;
    }

    public void b(coi coiVar) {
        this.i = coiVar;
    }

    public abstract void c(chm chmVar);

    public String f() {
        return "";
    }

    public final void n(coi coiVar) {
        coiVar.o();
        coiVar.b(this);
        coi coiVar2 = this.k;
        if (coiVar2 == null) {
            this.j = coiVar;
            this.k = coiVar;
        } else {
            coiVar2.m = coiVar;
            coiVar.l = coiVar2;
            this.k = coiVar;
        }
    }

    public final void o() {
        coi coiVar = this.l;
        if (coiVar != null) {
            coiVar.m = this.m;
        } else {
            coi coiVar2 = this.i;
            if (coiVar2 != null) {
                coiVar2.j = this.m;
            }
        }
        coi coiVar3 = this.m;
        if (coiVar3 != null) {
            coiVar3.l = coiVar;
        } else {
            coi coiVar4 = this.i;
            if (coiVar4 != null) {
                coiVar4.k = coiVar;
            }
        }
        this.i = null;
        this.m = null;
        this.l = null;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{" + f() + "}";
    }
}
