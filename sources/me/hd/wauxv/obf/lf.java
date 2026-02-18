package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lf implements alw {
    public final char a;

    public lf(char c) {
        this.a = c;
    }

    @Override // me.hd.wauxv.obf.alw
    public final void b(dqe dqeVar, dqe dqeVar2, int i) {
        String.valueOf(this.a);
        coi auvVar = i == 1 ? new auv() : new dns();
        coi coiVar = dqeVar.m;
        while (coiVar != null && coiVar != dqeVar2) {
            coi coiVar2 = coiVar.m;
            auvVar.n(coiVar);
            coiVar = coiVar2;
        }
        auvVar.o();
        coi coiVar3 = dqeVar.m;
        auvVar.m = coiVar3;
        if (coiVar3 != null) {
            coiVar3.l = auvVar;
        }
        auvVar.l = dqeVar;
        dqeVar.m = auvVar;
        coi coiVar4 = dqeVar.i;
        auvVar.i = coiVar4;
        if (auvVar.m == null) {
            coiVar4.k = auvVar;
        }
    }

    @Override // me.hd.wauxv.obf.alw
    public final char c() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.alw
    public final int d(alv alvVar, alv alvVar2) {
        if (alvVar.d || alvVar2.c) {
            int i = alvVar2.h;
            if (i % 3 != 0 && (alvVar.h + i) % 3 == 0) {
                return 0;
            }
        }
        return (alvVar.g < 2 || alvVar2.g < 2) ? 1 : 2;
    }

    @Override // me.hd.wauxv.obf.alw
    public final int e() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.alw
    public final char f() {
        return this.a;
    }
}
