package me.hd.wauxv.obf;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aop implements aoh {
    public final File b;
    public aoo e;
    public final DefaultConfig d = new DefaultConfig(14);
    public final long c = 262144000;
    public final but a = new but(8);

    public aop(File file) {
        this.b = file;
    }

    public final synchronized aoo f() {
        try {
            if (this.e == null) {
                this.e = aoo.s(this.b, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    @Override // me.hd.wauxv.obf.aoh
    public final File w(btj btjVar) {
        String strS = this.a.s(btjVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strS + " for for Key: " + btjVar);
        }
        try {
            erp erpVarV = f().v(strS);
            if (erpVarV != null) {
                return ((File[]) erpVarV.v)[0];
            }
            return null;
        } catch (IOException e) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            return null;
        }
    }

    @Override // me.hd.wauxv.obf.aoh
    public final void y(btj btjVar, FactoryPools factoryPoolsVar) {
        aoj aojVar;
        String strS = this.a.s(btjVar);
        DefaultConfig ioVar = this.d;
        synchronized (ioVar) {
            aojVar = (aoj) ((HashMap) ioVar.c).get(strS);
            if (aojVar == null) {
                sb sbVar = (sb) ioVar.d;
                synchronized (sbVar.a) {
                    aojVar = (aoj) sbVar.a.poll();
                }
                if (aojVar == null) {
                    aojVar = new aoj();
                }
                ((HashMap) ioVar.c).put(strS, aojVar);
            }
            aojVar.b++;
        }
        aojVar.a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strS + " for for Key: " + btjVar);
            }
            try {
                aoo aooVarF = f();
                if (aooVarF.v(strS) == null) {
                    aom aomVarU = aooVarF.u(strS);
                    if (aomVarU == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(strS));
                    }
                    try {
                        if (((avu) factoryPoolsVar.e).saveStreamToFile(factoryPoolsVar.f, aomVarU.f(), (crw) factoryPoolsVar.h)) {
                            aoo.o((aoo) aomVarU.d, aomVarU, true);
                            aomVarU.a = true;
                        }
                        if (!aomVarU.a) {
                            try {
                                aomVarU.e();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th) {
                        if (!aomVarU.a) {
                            try {
                                aomVarU.e();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
            this.d.au(strS);
        } catch (Throwable th2) {
            this.d.au(strS);
            throw th2;
        }
    }
}
