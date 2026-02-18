package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class drp {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(drp.class,
            "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public aws[] c;

    public final void d(aws awsVar) {
        awsVar.g((awt) this);
        aws[] awsVarArr = this.c;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
        if (awsVarArr == null) {
            awsVarArr = new aws[4];
            this.c = awsVarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= awsVarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(awsVarArr, atomicIntegerFieldUpdater.get(this) * 2);
            throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
            awsVarArr = (aws[]) objArrCopyOf;
            this.c = awsVarArr;
        }
        int i = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i + 1);
        awsVarArr[i] = awsVar;
        awsVar.d = i;
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
    public final aws e(int i) {
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
                aws awsVar = objArr2[i];
                throwIfVar1IsNull(awsVar);
                Object obj2 = objArr2[i5];
                throwIfVar1IsNull(obj2);
                if (awsVar.compareTo(obj2) < 0) {
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
        aws awsVar2 = objArr2[atomicIntegerFieldUpdater.get(this)];
        throwIfVar1IsNull(awsVar2);
        awsVar2.g(null);
        awsVar2.d = -1;
        objArr2[atomicIntegerFieldUpdater.get(this)] = null;
        return awsVar2;
    }

    public final void f(int i) {
        while (i > 0) {
            aws[] awsVarArr = this.c;
            throwIfVar1IsNull(awsVarArr);
            int i2 = (i - 1) / 2;
            aws awsVar = awsVarArr[i2];
            throwIfVar1IsNull(awsVar);
            aws awsVar2 = awsVarArr[i];
            throwIfVar1IsNull(awsVar2);
            if (awsVar.compareTo(awsVar2) <= 0) {
                return;
            }
            g(i, i2);
            i = i2;
        }
    }

    public final void g(int i, int i2) {
        aws[] awsVarArr = this.c;
        throwIfVar1IsNull(awsVarArr);
        aws awsVar = awsVarArr[i2];
        throwIfVar1IsNull(awsVar);
        aws awsVar2 = awsVarArr[i];
        throwIfVar1IsNull(awsVar2);
        awsVarArr[i] = awsVar;
        awsVarArr[i2] = awsVar2;
        awsVar.d = i;
        awsVar2.d = i2;
    }
}
