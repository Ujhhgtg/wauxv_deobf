package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class drp {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(drp.class,
            "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public Delayed[] c;

    public final void d(Delayed delayedVar) {
        delayedVar.g((awt) this);
        Delayed[] delayedVarArr = this.c;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (delayedVarArr == null) {
            delayedVarArr = new Delayed[4];
            this.c = delayedVarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= delayedVarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(delayedVarArr, atomicIntegerFieldUpdater.get(this) * 2);
            throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            delayedVarArr = (Delayed[]) objArrCopyOf;
            this.c = delayedVarArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        delayedVarArr[i] = delayedVar;
        delayedVar.d = i;
        f(i);
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x0045 */
    /* JADX WARN: Found duplicated region for block: B:14:0x0052 */
    /* JADX WARN: Found duplicated region for block: B:17:0x0063 */
    /*
     * JADX WARN: Found duplicated region for block: B:21:0x0075 A[LOOP:0:
     * B:9:0x003a->B:21:0x0075, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:24:0x007a A[EDGE_INSN:
     * B:24:0x007a->B:22:0x007a BREAK A[LOOP:0: B:9:0x003a->B:21:0x0075], SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:25:0x007a A[EDGE_INSN:
     * B:25:0x007a->B:22:0x007a BREAK A[LOOP:0: B:9:0x003a->B:21:0x0075], SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:26:? A[SYNTHETIC] */
    public final Delayed e(int i) {
        int i2;
        int i3;
        Object[] objArr;
        int i4;
        Comparable comparable;
        Comparable comparable2;
        Comparable comparable3;
        Object obj;
        Object[] objArr2 = this.c;
        throwIfVar1IsNull(objArr2);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        atomicIntegerFieldUpdater.set(this, atomicIntegerFieldUpdater.get(this) - 1);
        if (i < atomicIntegerFieldUpdater.get(this)) {
            g(i, atomicIntegerFieldUpdater.get(this));
            int i5 = (i - 1) / 2;
            if (i > 0) {
                Delayed delayedVar = objArr2[i];
                throwIfVar1IsNull(delayedVar);
                Object obj2 = objArr2[i5];
                throwIfVar1IsNull(obj2);
                if (delayedVar.compareTo(obj2) < 0) {
                    g(i, i5);
                    f(i5);
                } else {
                    while (true) {
                        i2 = i * 2;
                        i3 = i2 + 1;
                        if (i3 >= atomicIntegerFieldUpdater.get(this)) {
                            break;
                        }
                        objArr = this.c;
                        throwIfVar1IsNull(objArr);
                        i4 = i2 + 2;
                        if (i4 < atomicIntegerFieldUpdater.get(this)) {
                            comparable3 = objArr[i4];
                            throwIfVar1IsNull(comparable3);
                            obj = objArr[i3];
                            throwIfVar1IsNull(obj);
                            if (comparable3.compareTo(obj) >= 0) {
                                i4 = i3;
                            }
                        } else {
                            i4 = i3;
                        }
                        comparable = objArr[i];
                        throwIfVar1IsNull(comparable);
                        comparable2 = objArr[i4];
                        throwIfVar1IsNull(comparable2);
                        if (comparable.compareTo(comparable2) <= 0) {
                            break;
                        }
                        g(i, i4);
                        i = i4;
                    }
                }
            } else {
                while (true) {
                    i2 = i * 2;
                    i3 = i2 + 1;
                    if (i3 >= atomicIntegerFieldUpdater.get(this)) {
                        break;
                        break;
                    }
                    objArr = this.c;
                    throwIfVar1IsNull(objArr);
                    i4 = i2 + 2;
                    if (i4 < atomicIntegerFieldUpdater.get(this)) {
                        comparable3 = objArr[i4];
                        throwIfVar1IsNull(comparable3);
                        obj = objArr[i3];
                        throwIfVar1IsNull(obj);
                        if (comparable3.compareTo(obj) >= 0) {
                            i4 = i3;
                        }
                    } else {
                        i4 = i3;
                    }
                    comparable = objArr[i];
                    throwIfVar1IsNull(comparable);
                    comparable2 = objArr[i4];
                    throwIfVar1IsNull(comparable2);
                    if (comparable.compareTo(comparable2) <= 0) {
                        break;
                        break;
                    }
                    g(i, i4);
                    i = i4;
                }
            }
        }
        Delayed delayedVar2 = objArr2[atomicIntegerFieldUpdater.get(this)];
        throwIfVar1IsNull(delayedVar2);
        delayedVar2.g(null);
        delayedVar2.d = -1;
        objArr2[atomicIntegerFieldUpdater.get(this)] = null;
        return delayedVar2;
    }

    public final void f(int i) {
        while (i > 0) {
            Delayed[] delayedVarArr = this.c;
            throwIfVar1IsNull(delayedVarArr);
            int i2 = (i - 1) / 2;
            Delayed delayedVar = delayedVarArr[i2];
            throwIfVar1IsNull(delayedVar);
            Delayed delayedVar2 = delayedVarArr[i];
            throwIfVar1IsNull(delayedVar2);
            if (delayedVar.compareTo(delayedVar2) <= 0) {
                return;
            }
            g(i, i2);
            i = i2;
        }
    }

    public final void g(int i, int i2) {
        Delayed[] delayedVarArr = this.c;
        throwIfVar1IsNull(delayedVarArr);
        Delayed delayedVar = delayedVarArr[i2];
        throwIfVar1IsNull(delayedVar);
        Delayed delayedVar2 = delayedVarArr[i];
        throwIfVar1IsNull(delayedVar2);
        delayedVarArr[i] = delayedVar;
        delayedVarArr[i2] = delayedVar2;
        delayedVar.d = i;
        delayedVar2.d = i2;
    }
}
