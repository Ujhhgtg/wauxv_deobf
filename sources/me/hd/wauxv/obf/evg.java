package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class evg {
    public final evr j;
    public bps[] k;

    public evg() {
        this(new evr());
    }

    public void b(bps bpsVar) {
    }

    public void c(bps bpsVar) {
    }

    public void d(bps bpsVar) {
    }

    public void e(int i, bps bpsVar) {
        if (this.k == null) {
            this.k = new bps[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.k[FastKV.ag(i2)] = bpsVar;
            }
        }
    }

    public abstract evr g();

    public abstract void h(bps bpsVar);

    public abstract void i(bps bpsVar);

    public final void l() {
        bps[] bpsVarArr = this.k;
        if (bpsVarArr != null) {
            bps bpsVarN = bpsVarArr[0];
            bps bpsVarN2 = bpsVarArr[1];
            evr evrVar = this.j;
            if (bpsVarN2 == null) {
                bpsVarN2 = evrVar.b.n(2);
            }
            if (bpsVarN == null) {
                bpsVarN = evrVar.b.n(1);
            }
            i(bps.f(bpsVarN, bpsVarN2));
            bps bpsVar = this.k[FastKV.ag(16)];
            if (bpsVar != null) {
                c(bpsVar);
            }
            bps bpsVar2 = this.k[FastKV.ag(32)];
            if (bpsVar2 != null) {
                b(bpsVar2);
            }
            bps bpsVar3 = this.k[FastKV.ag(64)];
            if (bpsVar3 != null) {
                d(bpsVar3);
            }
        }
    }

    public evg(evr evrVar) {
        this.j = evrVar;
    }
}
