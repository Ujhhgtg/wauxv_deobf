package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brl implements bou {
    public static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(brl.class, "_isCompleting$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(brl.class, Object.class, "_rootCause$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(brl.class, Object.class, "_exceptionsHolder$volatile");
    private volatile /* synthetic */ Object _exceptionsHolder$volatile;
    private volatile /* synthetic */ int _isCompleting$volatile = 0;
    private volatile /* synthetic */ Object _rootCause$volatile;
    public final cok f;

    public brl(cok cokVar, Throwable th) {
        this.f = cokVar;
        this._rootCause$volatile = th;
    }

    @Override // me.hd.wauxv.obf.bou
    public final boolean b() {
        return h() == null;
    }

    @Override // me.hd.wauxv.obf.bou
    public final cok c() {
        return this.f;
    }

    public final void g(Throwable th) {
        Throwable thH = h();
        if (thH == null) {
            d.set(this, th);
            return;
        }
        if (th == thH) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    public final Throwable h() {
        return (Throwable) d.get(this);
    }

    public final boolean i() {
        return h() != null;
    }

    public final ArrayList j(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable thH = h();
        if (thH != null) {
            arrayList.add(0, thH);
        }
        if (th != null && !th.equals(thH)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, bhv.n);
        return arrayList;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Finishing[cancelling=");
        sb.append(i());
        sb.append(", completing=");
        sb.append(a.get(this) == 1);
        sb.append(", rootCause=");
        sb.append(h());
        sb.append(", exceptions=");
        sb.append(e.get(this));
        sb.append(", list=");
        sb.append(this.f);
        sb.append(']');
        return sb.toString();
    }
}
