package me.hd.wauxv.obf;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzh extends AbstractSet implements Set, bsx {
    public final /* synthetic */ int a;
    public final bzg b;

    public /* synthetic */ bzh(bzg bzgVar, int i) {
        this.a = i;
        this.b = bzgVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                bzo.q((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.a) {
            case 0:
                bzo.q(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                bzo.q(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.b.s((Map.Entry) obj);
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.a) {
            case 0:
                bzo.q(collection, "elements");
                return this.b.r(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.a) {
            case 0:
                break;
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                bzg bzgVar = this.b;
                bzgVar.getClass();
                return new bzd(bzgVar, 0);
            default:
                bzg bzgVar2 = this.b;
                bzgVar2.getClass();
                return new bzd(bzgVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                bzg bzgVar = this.b;
                bzgVar.getClass();
                bzgVar.p();
                int iU = bzgVar.u(entry.getKey());
                if (iU < 0) {
                    return false;
                }
                Object[] objArr = bzgVar.c;
                bzo.n(objArr);
                if (!bzo.f(objArr[iU], entry.getValue())) {
                    return false;
                }
                bzgVar.y(iU);
                return true;
            default:
                bzg bzgVar2 = this.b;
                bzgVar2.p();
                int iU2 = bzgVar2.u(obj);
                if (iU2 < 0) {
                    return false;
                }
                bzgVar2.y(iU2);
                return true;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.a) {
            case 0:
                bzo.q(collection, "elements");
                this.b.p();
                break;
            default:
                bzo.q(collection, "elements");
                this.b.p();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.a) {
            case 0:
                bzo.q(collection, "elements");
                this.b.p();
                break;
            default:
                bzo.q(collection, "elements");
                this.b.p();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.a) {
            case 0:
                break;
            default:
                break;
        }
        return this.b.j;
    }
}
