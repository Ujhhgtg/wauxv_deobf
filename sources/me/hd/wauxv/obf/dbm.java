package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbm extends cwl {
    public int ac;
    public final long ae;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public dbm(cwd cwdVar, cwo cwoVar, long j, dfx dfxVar) {
        super(cwdVar, cwoVar, dfxVar);
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ac = -1;
        if (j == 19500) {
            int iG = cwoVar.g(cwf.DEFAULT);
            if (iG < 0) {
                throw new IllegalArgumentException(
                        ("Expected positive length for " + dfxVar + ", but got " + iG).toString());
            }
            j = -iG;
        }
        this.ae = j;
    }

    @Override // me.hd.wauxv.obf.cwl
    public final long ad(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        long j = this.ae;
        if (j > 0) {
            return j;
        }
        return 19500L;
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        long j = this.ae;
        cwo cwoVar = this.ai;
        if (j > 0) {
            if ((this.ac == -1 ? cwoVar.b : cwoVar.t()) == ((int) (j & 2147483647L))) {
                int i = this.ac + 1;
                this.ac = i;
                return i;
            }
            cwoVar.d = true;
            int i2 = (cwoVar.b << 3) | cwoVar.c.value;
            cwoVar.v(cwoVar.e);
            cwoVar.e = i2;
            return -1;
        }
        long j2 = -j;
        int i3 = this.ac + 1;
        this.ac = i3;
        if (i3 == j2) {
            return -1;
        }
        if (!cwoVar.d) {
            ru ruVar = cwoVar.a;
            if (ruVar.a - ruVar.b == 0) {
                return -1;
            }
        }
        return i3;
    }
}
