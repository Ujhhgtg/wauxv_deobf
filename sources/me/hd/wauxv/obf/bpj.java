package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpj extends cuc {
    public final boolean c;

    public bpj(String str, bpk bpkVar) {
        super(str, bpkVar, 1);
        this.c = true;
    }

    @Override // me.hd.wauxv.obf.cuc, me.hd.wauxv.obf.dfx
    public final boolean d() {
        return this.c;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, me.hd.wauxv.obf.btt] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, me.hd.wauxv.obf.btt] */
    @Override // me.hd.wauxv.obf.cuc
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bpj) {
            dfx dfxVar = (dfx) obj;
            if (this.e.equals(dfxVar.b())) {
                bpj bpjVar = (bpj) obj;
                if (bpjVar.c && Arrays.equals((dfx[]) this.v.getValue(), (dfx[]) bpjVar.v.getValue())) {
                    int i = dfxVar.i();
                    int i2 = this.o;
                    if (i2 == i) {
                        for (int i3 = 0; i3 < i2; i3++) {
                            if (bzo.f(l(i3).b(), dfxVar.l(i3).b()) && bzo.f(l(i3).h(), dfxVar.l(i3).h())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.cuc
    public final int hashCode() {
        return super.hashCode() * 31;
    }
}
