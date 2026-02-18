package me.hd.wauxv.obf;

import com.alibaba.fastjson2.codec.FieldInfo;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bxo {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(bxo.class, Object.class, "_next$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater b = AtomicLongFieldUpdater.newUpdater(bxo.class, "_state$volatile");
    public static final auj c = new auj("REMOVE_FROZEN", 1);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int d;
    public final boolean e;
    public final int f;
    public final /* synthetic */ AtomicReferenceArray g;

    public bxo(int i, boolean z) {
        this.d = i;
        this.e = z;
        int i2 = i - 1;
        this.f = i2;
        this.g = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int h(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (FieldInfo.BACKR_EFERENCE & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.f;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.e;
            AtomicReferenceArray atomicReferenceArray = this.g;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                if (b.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    bxo bxoVarJ = this;
                    while ((atomicLongFieldUpdater.get(bxoVarJ) & FieldInfo.DISABLE_JSONB) != 0) {
                        bxoVarJ = bxoVarJ.j();
                        AtomicReferenceArray atomicReferenceArray2 = bxoVarJ.g;
                        int i4 = bxoVarJ.f & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof bxn) && ((bxn) obj2).a == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            bxoVarJ = null;
                        }
                        if (bxoVarJ == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i5 = this.d;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean i() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = b;
            j = atomicLongFieldUpdater.get(this);
            if ((j & FieldInfo.BACKR_EFERENCE) != 0) {
                return true;
            }
            if ((FieldInfo.DISABLE_JSONB & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, FieldInfo.BACKR_EFERENCE | j));
        return true;
    }

    public final bxo j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        bxo bxoVar;
        while (true) {
            atomicLongFieldUpdater = b;
            j = atomicLongFieldUpdater.get(this);
            if ((j & FieldInfo.DISABLE_JSONB) != 0) {
                bxoVar = this;
                break;
            }
            long j2 = FieldInfo.DISABLE_JSONB | j;
            bxoVar = this;
            if (atomicLongFieldUpdater.compareAndSet(bxoVar, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            bxo bxoVar2 = (bxo) atomicReferenceFieldUpdater.get(this);
            if (bxoVar2 != null) {
                return bxoVar2;
            }
            bxo bxoVar3 = new bxo(bxoVar.d * 2, bxoVar.e);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = bxoVar.f;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object bxnVar = bxoVar.g.get(i4);
                if (bxnVar == null) {
                    bxnVar = new bxn(i);
                }
                bxoVar3.g.set(bxoVar3.f & i, bxnVar);
                i++;
            }
            atomicLongFieldUpdater.set(bxoVar3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, bxoVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object k() {
        bxo bxoVarJ = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b;
            long j = atomicLongFieldUpdater.get(bxoVarJ);
            if ((j & FieldInfo.DISABLE_JSONB) != 0) {
                return c;
            }
            int i = (int) (j & 1073741823);
            int i2 = bxoVarJ.f;
            int i3 = i & i2;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) != i3) {
                AtomicReferenceArray atomicReferenceArray = bxoVarJ.g;
                Object obj = atomicReferenceArray.get(i3);
                boolean z = bxoVarJ.e;
                if (obj == null) {
                    if (z) {
                    }
                } else if (!(obj instanceof bxn)) {
                    long j2 = (i + 1) & 1073741823;
                    if (b.compareAndSet(bxoVarJ, j, (j & (-1073741824)) | j2)) {
                        atomicReferenceArray.set(i3, null);
                        return obj;
                    }
                    bxoVarJ = this;
                    if (z) {
                        while (true) {
                            long j3 = atomicLongFieldUpdater.get(bxoVarJ);
                            int i4 = (int) (j3 & 1073741823);
                            if ((j3 & FieldInfo.DISABLE_JSONB) != 0) {
                                bxoVarJ = bxoVarJ.j();
                            } else {
                                bxo bxoVar = bxoVarJ;
                                if (b.compareAndSet(bxoVar, j3, (j3 & (-1073741824)) | j2)) {
                                    bxoVar.g.set(i4 & bxoVar.f, null);
                                    bxoVarJ = null;
                                } else {
                                    bxoVarJ = bxoVar;
                                }
                            }
                            if (bxoVarJ == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
