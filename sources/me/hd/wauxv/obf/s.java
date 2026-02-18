package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s implements btd {
    public abstract int _s(Object obj);

    @Override // me.hd.wauxv.obf.btd
    public Object a(ajt ajtVar) {
        return f(ajtVar, null);
    }

    public abstract Object b();

    public abstract Iterator d(Object obj);

    public abstract int e(Object obj);

    public final Object f(ajt ajtVar, Object obj) {
        Object objH = obj != null ? h(obj) : b();
        int i_s = _s(objH);
        acm acmVarP = ajtVar.p(getDescriptor());
        acmVarP.getClass();
        while (true) {
            int iF = acmVarP.f(getDescriptor());
            if (iF == -1) {
                acmVarP._bp(getDescriptor());
                return i(objH);
            }
            g(acmVarP, iF + i_s, objH);
        }
    }

    public abstract void g(acm acmVar, int i, Object obj);

    public abstract Object h(Object obj);

    public abstract Object i(Object obj);
}
