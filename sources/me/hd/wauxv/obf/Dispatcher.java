package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Dispatcher extends u implements afy {
    public static final ahi h = new ahi(arj.a, new age(18));

    public Dispatcher() {
        super(arj.a);
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
     * 
     * if (((me.hd.wauxv.obf.ahf) r3.a.invoke(r2)) == null) goto L17;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
     * 
     * if (me.hd.wauxv.obf.arj.a == r3) goto L15;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
     * 
     * return me.hd.wauxv.obf.auz.a;
     */
    /*
     * JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
     * 
     * return r2;
     */
    @Override // me.hd.wauxv.obf.u, me.hd.wauxv.obf.ahh
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final me.hd.wauxv.obf.ahh _t(me.hd.wauxv.obf.ahg r3) {
        /*
         * r2 = this;
         * java.lang.String r0 = "key"
         * me.hd.wauxv.obf.throwIfVar1IsNull(r3, r0)
         * boolean r0 = r3 instanceof me.hd.wauxv.obf.ahi
         * if (r0 == 0) goto L20
         * me.hd.wauxv.obf.ahi r3 = (me.hd.wauxv.obf.ahi) r3
         * me.hd.wauxv.obf.ahg r0 = r2.a
         * if (r0 == r3) goto L15
         * me.hd.wauxv.obf.ahg r1 = r3.b
         * if (r1 != r0) goto L14
         * goto L15
         * L14:
         * return r2
         * L15:
         * me.hd.wauxv.obf.bgf r3 = r3.a
         * java.lang.Object r3 = r3.invoke(r2)
         * me.hd.wauxv.obf.ahf r3 = (me.hd.wauxv.obf.ahf) r3
         * if (r3 == 0) goto L27
         * goto L24
         * L20:
         * me.hd.wauxv.obf.arj r0 = me.hd.wauxv.obf.arj.a
         * if (r0 != r3) goto L27
         * L24:
         * me.hd.wauxv.obf.auz r3 = me.hd.wauxv.obf.auz.a
         * return r3
         * L27:
         * return r2
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.ahj._t(me.hd.wauxv.obf.ahg):me.hd.wauxv.obf.ahh");
    }

    @Override // me.hd.wauxv.obf.u, me.hd.wauxv.obf.ahh
    public final ahf _w(ahg ahgVar) {
        ahf ahfVar;
        throwIfVar1IsNull(ahgVar, "key");
        if (ahgVar instanceof ahi) {
            ahi ahiVar = (ahi) ahgVar;
            ahg ahgVar2 = this.a;
            if ((ahgVar2 == ahiVar || ahiVar.b == ahgVar2) && (ahfVar = (ahf) ahiVar.a.invoke(this)) != null) {
                return ahfVar;
            }
        } else if (arj.a == ahgVar) {
            return this;
        }
        return null;
    }

    public abstract void i(ahh ahhVar, Runnable runnable);

    public boolean j(ahh ahhVar) {
        return !(this instanceof enj);
    }

    public Dispatcher k(int i) {
        bhs.n(i);
        return new buw(this, i);
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + ajn.toHexHashCode(this);
    }
}
