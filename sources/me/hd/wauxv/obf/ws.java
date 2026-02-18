package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ws implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ ws(int i) {
        this.a = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Found duplicated region for block: B:274:0x0904  */
    /* JADX WARN: Found duplicated region for block: B:287:0x094d  */
    /* JADX WARN: Found duplicated region for block: B:297:0x0985  */
    /* JADX WARN: Found duplicated region for block: B:304:0x09ac  */
    /* JADX WARN: Found duplicated region for block: B:317:0x09f5  */
    /* JADX WARN: Found duplicated region for block: B:327:0x0a2d  */
    /* JADX WARN: Found duplicated region for block: B:334:0x0a54  */
    /* JADX WARN: Found duplicated region for block: B:344:0x0a8c  */
    /* JADX WARN: Found duplicated region for block: B:351:0x0ab3  */
    /* JADX WARN: Found duplicated region for block: B:355:0x0ac7  */
    /* JADX WARN: Found duplicated region for block: B:362:0x0aec  */
    /* JADX WARN: Found duplicated region for block: B:366:0x0b00  */
    /* JADX WARN: Found duplicated region for block: B:370:0x0b14  */
    /* JADX WARN: Found duplicated region for block: B:374:0x0b28  */
    /* JADX WARN: Found duplicated region for block: B:377:0x0b3b  */
    /* JADX WARN: Found duplicated region for block: B:378:0x0b3f  */
    /* JADX WARN: Found duplicated region for block: B:399:0x0bd6  */
    /* JADX WARN: Found duplicated region for block: B:507:0x0c70 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:509:0x0c45 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:61:0x0192  */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r6v15 java.lang.Object, still in use, count: 2, list:
          (r6v15 java.lang.Object) from 0x0c6c: PHI (r6v13 java.lang.Object) = (r6v12 java.lang.Object), (r6v15 java.lang.Object) binds: [B:424:0x0c6b, B:512:0x0c6c] A[DONT_GENERATE, DONT_INLINE]
          (r6v15 java.lang.Object) from 0x0c60: CHECK_CAST (me.hd.wauxv.obf.wz) (r6v15 java.lang.Object)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:114)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    @Override // me.hd.wauxv.obf.bgf
    public final java.lang.Object invoke(java.lang.Object r27) throws java.lang.IllegalAccessException, me.hd.wauxv.obf.cth {
        /*
            Method dump skipped, instruction units count: 4006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.ws.invoke(java.lang.Object):java.lang.Object");
    }
}
