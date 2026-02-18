package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cvl extends aax {
    public final cvk o;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public cvl(btd btdVar) {
        super(btdVar);
        throwIfVar1IsNull(btdVar, "primitiveSerializer");
        this.o = new cvk(btdVar.getDescriptor());
    }

    @Override // me.hd.wauxv.obf.s
    public final int _s(Object obj) {
        cvj cvjVar = (cvj) obj;
        throwIfVar1IsNull(cvjVar, "<this>");
        return cvjVar.e();
    }

    @Override // me.hd.wauxv.obf.s, me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        return f(ajtVar, null);
    }

    @Override // me.hd.wauxv.obf.s
    public final Object b() {
        return (cvj) h(k());
    }

    @Override // me.hd.wauxv.obf.aax, me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        int iE = e(obj);
        cvk cvkVar = this.o;
        acn acnVarV = avtVar.v(cvkVar, iE);
        m(acnVarV, obj, iE);
        acnVarV.a(cvkVar);
    }

    @Override // me.hd.wauxv.obf.s
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.o;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object i(Object obj) {
        cvj cvjVar = (cvj) obj;
        throwIfVar1IsNull(cvjVar, "<this>");
        return cvjVar.c();
    }

    public abstract Object k();

    @Override // me.hd.wauxv.obf.aax
    public final void l(Object obj, int i, Object obj2) {
        throwIfVar1IsNull((cvj) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract void m(acn acnVar, Object obj, int i);
}
