package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eph extends epg {
    public cte[] n;
    public String o;
    public int p;

    public eph() {
        this.n = null;
        this.p = 0;
    }

    public cte[] getPathData() {
        return this.n;
    }

    public String getPathName() {
        return this.o;
    }

    public void setPathData(cte[] cteVarArr) {
        if (!ajn.h(this.n, cteVarArr)) {
            this.n = ajn.m(cteVarArr);
            return;
        }
        cte[] cteVarArr2 = this.n;
        for (int i = 0; i < cteVarArr.length; i++) {
            cteVarArr2[i].a = cteVarArr[i].a;
            int i2 = 0;
            while (true) {
                float[] fArr = cteVarArr[i].b;
                if (i2 < fArr.length) {
                    cteVarArr2[i].b[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }

    public eph(eph ephVar) {
        this.n = null;
        this.p = 0;
        this.o = ephVar.o;
        this.n = ajn.m(ephVar.n);
    }
}
