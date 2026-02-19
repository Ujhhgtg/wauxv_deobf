package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class blx implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ blx(int i) {
        this.a = i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v0 java.lang.Class, still in use, count: 3, list:
          (r3v0 java.lang.Class) from 0x044e: INVOKE (r3v0 java.lang.Class) STATIC call: me.hd.wauxv.obf.dal.b(java.lang.Class):me.hd.wauxv.obf.zc A[MD:(java.lang.Class):me.hd.wauxv.obf.zc (m), WRAPPED] (LINE:1103)
          (r3v0 java.lang.Class) from 0x01c0: INVOKE (r3v0 java.lang.Class) STATIC call: me.hd.wauxv.obf.dal.b(java.lang.Class):me.hd.wauxv.obf.zc A[MD:(java.lang.Class):me.hd.wauxv.obf.zc (m), WRAPPED] (LINE:449)
          (r3v0 java.lang.Class) from ?: TERNARY null = ((r4v34 java.lang.Class<java.lang.Boolean>) == (null java.lang.Class<java.lang.Boolean>)) ? (r3v0 java.lang.Class) : (r4v34 java.lang.Class<java.lang.Boolean>)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:106)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:90)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:106)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:90)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.utils.InsnRemover.unbindAllArgs(InsnRemover.java:106)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:90)
        	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:174)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:141)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:116)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyArgs(SimplifyVisitor.java:114)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:132)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    @Override // me.hd.wauxv.obf.bgf
    public final java.lang.Object invoke(java.lang.Object r17) {
        /*
            Method dump skipped, instruction units count: 1209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.blx.invoke(java.lang.Object):java.lang.Object");
    }
}
