package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aws implements Runnable, Comparable, aox {
    private volatile Object _heap;
    public long c;
    public int d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.c - ((aws) obj).c;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    @Override // me.hd.wauxv.obf.aox
    public final void e() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                auj aujVar = emc.t;
                if (obj == aujVar) {
                    return;
                }
                awt awtVar = obj instanceof awt ? (awt) obj : null;
                if (awtVar != null) {
                    synchronized (awtVar) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof drp ? (drp) obj2 : null) != null) {
                            awtVar.e(this.d);
                        }
                    }
                }
                this._heap = aujVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int f(long j, awt awtVar, awu awuVar) {
        synchronized (this) {
            if (this._heap == emc.t) {
                return 2;
            }
            synchronized (awtVar) {
                try {
                    aws[] awsVarArr = awtVar.c;
                    aws awsVar = awsVarArr != null ? awsVarArr[0] : null;
                    if (awu.r.get(awuVar) == 1) {
                        return 1;
                    }
                    if (awsVar == null) {
                        awtVar.a = j;
                    } else {
                        long j2 = awsVar.c;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        if (j - awtVar.a > 0) {
                            awtVar.a = j;
                        }
                    }
                    long j3 = this.c;
                    long j4 = awtVar.a;
                    if (j3 - j4 < 0) {
                        this.c = j4;
                    }
                    awtVar.d(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void g(awt awtVar) {
        if (this._heap == emc.t) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this._heap = awtVar;
    }

    public String toString() {
        return "Delayed[nanos=" + this.c + ']';
    }
}
