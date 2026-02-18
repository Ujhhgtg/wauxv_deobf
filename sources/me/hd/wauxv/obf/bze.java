package me.hd.wauxv.obf;

import java.util.ConcurrentModificationException;
import java.util.Map;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bze implements Map.Entry, IEmpty {
    public final bzg a;
    public final int b;
    public final int c;

    public bze(bzg bzgVar, int i) {
        throwIfVar1IsNull(bzgVar, "map");
        this.a = bzgVar;
        this.b = i;
        this.c = bzgVar.i;
    }

    public final void d() {
        if (this.a.i != this.c) {
            throw new ConcurrentModificationException(
                    "The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return nullSafeIsEqual(entry.getKey(), getKey()) && nullSafeIsEqual(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        d();
        return this.a.b[this.b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        d();
        Object[] objArr = this.a.c;
        throwIfVar1IsNull(objArr);
        return objArr[this.b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        d();
        bzg bzgVar = this.a;
        bzgVar.p();
        Object[] objArr = bzgVar.c;
        if (objArr == null) {
            int length = bzgVar.b.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            bzgVar.c = objArr;
        }
        int i = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(SignatureVisitor.INSTANCEOF);
        sb.append(getValue());
        return sb.toString();
    }
}
