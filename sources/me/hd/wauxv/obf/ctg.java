package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctg implements dlc {
    public final rm a;
    public final rh b;
    public dfj c;
    public int d;
    public boolean e;
    public long f;

    public ctg(rm rmVar) {
        this.a = rmVar;
        rh rhVarC = rmVar.c();
        this.b = rhVarC;
        dfj dfjVar = rhVarC.a;
        this.c = dfjVar;
        this.d = dfjVar != null ? dfjVar.b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.b) goto L15;
     */
    @Override // me.hd.wauxv.obf.dlc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(me.hd.wauxv.obf.rh r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            me.hd.wauxv.obf.bzo.q(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.e
            if (r3 != 0) goto L63
            me.hd.wauxv.obf.dfj r3 = r8.c
            me.hd.wauxv.obf.rh r4 = r8.b
            if (r3 == 0) goto L2b
            me.hd.wauxv.obf.dfj r5 = r4.a
            if (r3 != r5) goto L23
            int r3 = r8.d
            me.hd.wauxv.obf.bzo.n(r5)
            int r5 = r5.b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f
            r2 = 1
            long r0 = r0 + r2
            me.hd.wauxv.obf.rm r2 = r8.a
            boolean r0 = r2.x(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            me.hd.wauxv.obf.dfj r0 = r8.c
            if (r0 != 0) goto L4c
            me.hd.wauxv.obf.dfj r0 = r4.a
            if (r0 == 0) goto L4c
            r8.c = r0
            int r0 = r0.b
            r8.d = r0
        L4c:
            long r0 = r4.b
            long r2 = r8.f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            me.hd.wauxv.obf.rh r2 = r8.b
            long r3 = r8.f
            r5 = r9
            r2.l(r3, r5, r6)
            long r9 = r8.f
            long r9 = r9 + r6
            r8.f = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = me.hd.wauxv.obf.dts.b(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.ctg.read(me.hd.wauxv.obf.rh, long):long");
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return this.a.timeout();
    }
}
