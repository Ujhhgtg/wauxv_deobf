package me.hd.wauxv.obf;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class daj extends aax {
    public final zc j;
    public final kl k;

    public daj(zc zcVar) {
        super(dnh.b);
        this.j = zcVar;
        cvo cvoVar = dnh.d;
        throwIfVar1IsNull(cvoVar, "elementDesc");
        this.k = new kl(cvoVar, 0);
    }

    @Override // me.hd.wauxv.obf.s
    public final int _s(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        throwIfVar1IsNull(arrayList, "<this>");
        return arrayList.size();
    }

    @Override // me.hd.wauxv.obf.s
    public final Object b() {
        return new ArrayList();
    }

    @Override // me.hd.wauxv.obf.s
    public final Iterator d(Object obj) {
        Object[] objArr = (Object[]) obj;
        throwIfVar1IsNull(objArr, "<this>");
        return cnb.ae(objArr);
    }

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        Object[] objArr = (Object[]) obj;
        throwIfVar1IsNull(objArr, "<this>");
        return objArr.length;
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.k;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        Object[] objArr = (Object[]) obj;
        throwIfVar1IsNull(objArr, "<this>");
        return new ArrayList(la.a(objArr));
    }

    @Override // me.hd.wauxv.obf.s
    public final Object i(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        throwIfVar1IsNull(arrayList, "<this>");
        Object objNewInstance = Array.newInstance((Class<?>) cnf.bd(this.j), arrayList.size());
        throwIfVar1IsNull(objNewInstance,
                "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        Object[] array = arrayList.toArray((Object[]) objNewInstance);
        throwIfVar1IsNull(array, "toArray(...)");
        return array;
    }

    @Override // me.hd.wauxv.obf.aax
    public final void l(Object obj, int i, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        throwIfVar1IsNull(arrayList, "<this>");
        arrayList.add(i, obj2);
    }
}
