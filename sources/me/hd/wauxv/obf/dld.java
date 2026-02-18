package me.hd.wauxv.obf;

import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dld implements ajd, ajc {
    public final ajp c;
    public final ajr d;
    public volatile int e;
    public volatile aiy f;
    public volatile Object g;
    public volatile cdu h;
    public volatile aiz i;

    public dld(ajp ajpVar, ajr ajrVar) {
        this.c = ajpVar;
        this.d = ajrVar;
    }

    @Override // me.hd.wauxv.obf.ajc
    public final void a(btj btjVar, Object obj, ajb ajbVar, int i, btj btjVar2) {
        this.d.a(btjVar, obj, ajbVar, this.h.c.e(), btjVar);
    }

    @Override // me.hd.wauxv.obf.ajc
    public final void b(btj btjVar, Exception exc, ajb ajbVar, int i) {
        this.d.b(btjVar, exc, ajbVar, this.h.c.e());
    }

    @Override // me.hd.wauxv.obf.ajd
    public final void cancel() {
        cdu cduVar = this.h;
        if (cduVar != null) {
            cduVar.c.cancel();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:12:0x0020  */
    @Override // me.hd.wauxv.obf.ajd
    public final boolean j() {
        boolean z;
        if (this.g == null) {
            if (this.f != null) {
            }
            this.f = null;
            this.h = null;
            z = false;
            while (!z) {
                ArrayList arrayListT = this.c.t();
                int i = this.e;
                this.e = i + 1;
                this.h = (cdu) arrayListT.get(i);
                if (this.h == null) {
                }
            }
            return z;
        }
        Object obj = this.g;
        this.g = null;
        try {
        } catch (IOException e) {
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
            }
        }
        if (k(obj)) {
            if (this.f != null || !this.f.j()) {
                this.f = null;
                this.h = null;
                z = false;
                while (!z && this.e < this.c.t().size()) {
                    ArrayList arrayListT2 = this.c.t();
                    int i2 = this.e;
                    this.e = i2 + 1;
                    this.h = (cdu) arrayListT2.get(i2);
                    if (this.h == null && (this.c.p.e(this.h.c.e()) || this.c.u(this.h.c.b()) != null)) {
                        this.h.c.f(this.c.o, new but(this, this.h));
                        z = true;
                    }
                }
                return z;
            }
        }
        return true;
    }

    public final boolean k(Object obj) throws Throwable {
        Throwable th;
        int i = bxq.b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        boolean z = false;
        try {
            ajh ajhVarQ = this.c.c.l().q(obj);
            Object objD = ajhVarQ.d();
            avu avuVarV = this.c.v(objD);
            jx jxVar = new jx(avuVarV, objD, this.c.i, 4);
            btj btjVar = this.h.a;
            ajp ajpVar = this.c;
            aiz aizVar = new aiz(btjVar, ajpVar.n);
            aoh aohVarC = ajpVar.h.c();
            aohVarC.y(aizVar, jxVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + aizVar + ", data: " + obj + ", encoder: " + avuVarV + ", duration: " + bxq.c(jElapsedRealtimeNanos));
            }
            if (aohVarC.w(aizVar) != null) {
                this.i = aizVar;
                this.f = new aiy(Collections.singletonList(this.h.a), this.c, this);
                this.h.c.d();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Log.d("SourceGenerator", "Attempt to write: " + this.i + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.d.a(this.h.a, ajhVarQ.d(), this.h.c, this.h.c.e(), this.h.a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.h.c.d();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
