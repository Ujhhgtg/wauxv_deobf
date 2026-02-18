package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhr {
    public yp a;
    public CharSequence b;
    public final String c;
    public abu d;
    public int e;
    public dlb f;
    public final /* synthetic */ int g;
    public final Object h;

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public dhr(String str, String str2, dil dilVar) {
        this(str, str2);
        this.g = 1;
        this.h = dilVar;
        this.d = abu.c;
    }

    private final void k(aff affVar, int i, int i2) {
    }

    public void i(abu abuVar) {
        this.d = abuVar;
        if (this.a == null) {
            throwIfVar1IsNull(abuVar, "kind");
            this.a = new yp(abuVar);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:118:0x02c3 */
    /* JADX WARN: Found duplicated region for block: B:120:0x02cd A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:122:0x02dd */
    /* JADX WARN: Found duplicated region for block: B:124:0x02fd */
    /* JADX WARN: Found duplicated region for block: B:125:0x0308 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:132:0x0349 */
    /*
     * JADX WARN: Found duplicated region for block: B:137:0x0385 A[PHI: r16 r18
     * 0x0385: PHI (r16v2 java.lang.String) = (r16v0 java.lang.String), (r16v0
     * java.lang.String), (r16v3 java.lang.String) binds: [B:139:0x038f,
     * B:141:0x039b, B:136:0x0366] A[DONT_GENERATE, DONT_INLINE]
     * 0x0385: PHI (r18v2 java.lang.String) = (r18v0 java.lang.String), (r18v0
     * java.lang.String), (r18v4 java.lang.String) binds: [B:139:0x038f,
     * B:141:0x039b, B:136:0x0366] A[DONT_GENERATE, DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:138:0x0389 */
    /* JADX WARN: Found duplicated region for block: B:140:0x0391 */
    /* JADX WARN: Found duplicated region for block: B:143:0x039e */
    /* JADX WARN: Found duplicated region for block: B:146:0x03b2 */
    /* JADX WARN: Found duplicated region for block: B:150:0x03cf */
    /* JADX WARN: Found duplicated region for block: B:154:0x03e1 */
    /* JADX WARN: Found duplicated region for block: B:155:0x03e6 */
    /* JADX WARN: Found duplicated region for block: B:157:0x03ec */
    /* JADX WARN: Found duplicated region for block: B:158:0x03ef */
    /* JADX WARN: Found duplicated region for block: B:161:0x03f4 */
    /* JADX WARN: Found duplicated region for block: B:163:0x03f7 */
    /* JADX WARN: Found duplicated region for block: B:165:0x040a */
    /* JADX WARN: Found duplicated region for block: B:171:0x0443 */
    /* JADX WARN: Found duplicated region for block: B:178:0x0460 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:187:0x0493 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:195:0x04ad */
    /* JADX WARN: Found duplicated region for block: B:199:0x04d7 */
    /* JADX WARN: Found duplicated region for block: B:212:0x051d */
    /* JADX WARN: Found duplicated region for block: B:213:0x0521 */
    /* JADX WARN: Found duplicated region for block: B:253:0x0356 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:254:0x0351 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:261:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:262:0x03be A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:263:0x03cc A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:268:0x044d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:269:0x0456 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:270:0x0475 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:272:0x043d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:273:0x043d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:274:0x043d A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:276:0x0472 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:279:0x04a8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:286:0x04e9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:287:0x04e1 A[SYNTHETIC] */
    /*
     * JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r10v9
     * java.lang.Object, still in use, count: 2, list:
     * (r10v9 java.lang.Object) from 0x0473: PHI (r10v8 java.lang.Object) = (r10v7
     * java.lang.Object), (r10v9 java.lang.Object) binds: [B:181:0x0472,
     * B:277:0x0473] A[DONT_GENERATE, DONT_INLINE]
     * (r10v9 java.lang.Object) from 0x0465: CHECK_CAST (me.hd.wauxv.obf.ctr) (r10v9
     * java.lang.Object)
     * at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
     * at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
     * at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:
     * 114)
     * at
     * jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
     * at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:67)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at
     * java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.
     * java:1093)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at
     * jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0
     * (DepthRegionTraversal.java:68)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(
     * DepthRegionTraversal.java:68)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(
     * DepthRegionTraversal.java:19)
     * at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
     * at
     * jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:
     * 44)
     * at
     * jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
     */
    public void j(DefaultConfig.github.rosemoe.sora.widget.CodeEditor r21, me.hd.wauxv.obf.aff r22,
            me.hd.wauxv.obf.ud r23) {
        /*
         * Method dump skipped, instruction units count: 1330
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.dhr.j(io.github.rosemoe.sora.widget.CodeEditor, me.hd.wauxv.obf.aff, me.hd.wauxv.obf.ud):void");
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public dhr(int i, String str, String str2, String str3) {
        this(str, str2);
        this.g = 0;
        this.h = str3;
        this.e = i;
    }

    public dhr(CharSequence charSequence, String str) {
        this.e = 0;
        this.b = charSequence;
        this.c = str;
        this.a = null;
    }
}
