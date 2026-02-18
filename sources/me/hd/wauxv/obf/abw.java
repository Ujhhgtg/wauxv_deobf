package me.hd.wauxv.obf;

import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abw {
    public final Handler d;
    public final arm e;
    public final int f;
    public za g;
    public boolean i = false;
    public final ArrayList a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public final ReentrantLock c = new ReentrantLock(true);
    public final int h = 5;

    public abw(Handler handler, arm armVar, int i) {
        this.d = handler;
        this.e = armVar;
        this.f = i;
    }

    public final void j(dhr dhrVar) {
        ArrayList arrayList = this.b;
        k();
        if (this.i) {
            return;
        }
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            arrayList.add(dhrVar);
            reentrantLock.unlock();
            if (arrayList.size() >= this.h) {
                l(false);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void k() {
        if (Thread.interrupted() || this.i) {
            this.i = true;
            if (this.f <= 1) {
                throw new abs();
            }
        }
    }

    public final void l(final boolean z) {
        if (this.i) {
            return;
        }
        this.d.post(new Runnable() { // from class: me.hd.wauxv.obf.abv
            @Override // java.lang.Runnable
            public final void run() {
                boolean zTryLock;
                abw abwVar = this.a;
                arm armVar = abwVar.e;
                ArrayList arrayList = abwVar.a;
                ArrayList arrayList2 = abwVar.b;
                ReentrantLock reentrantLock = abwVar.c;
                if (abwVar.i) {
                    armVar.run();
                    return;
                }
                if (z) {
                    reentrantLock.lock();
                    zTryLock = true;
                } else {
                    zTryLock = reentrantLock.tryLock();
                }
                if (zTryLock) {
                    try {
                        if (arrayList2.isEmpty()) {
                            armVar.run();
                            reentrantLock.unlock();
                            return;
                        }
                        za zaVar = abwVar.g;
                        if (zaVar != null) {
                            while (!arrayList2.isEmpty()) {
                                dhr dhrVar = (dhr) arrayList2.remove(0);
                                int size = arrayList.size();
                                int i = 0;
                                int i2 = size;
                                while (i <= i2) {
                                    int i3 = (i + i2) / 2;
                                    if (i3 >= 0 && i3 < size) {
                                        int iCompare = zaVar.compare((dhr) arrayList.get(i3), dhrVar);
                                        if (iCompare < 0) {
                                            i = i3 + 1;
                                        } else if (iCompare > 0) {
                                            i2 = i3 - 1;
                                        }
                                    }
                                    i = i3;
                                    break;
                                }
                                arrayList.add(Math.max(0, Math.min(size, i)), dhrVar);
                            }
                        } else {
                            arrayList.addAll(arrayList2);
                            arrayList2.clear();
                        }
                        armVar.run();
                        reentrantLock.unlock();
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
            }
        });
    }
}
