package me.hd.wauxv.obf;

import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbu extends nj {
    public final Context af;
    public final dca ag;
    public final Class ah;
    public final bhw ai;
    public bgz aj;
    public Object ak;
    public ArrayList al;
    public dbu am;
    public dbu an;
    public final boolean ao = true;
    public boolean ap;
    public boolean aq;

    static {
    }

    public dbu(com.bumptech.glide.a aVar, dca dcaVar, Class cls, Context context) {
        dcd dcdVar;
        this.ag = dcaVar;
        this.ah = cls;
        this.af = context;
        ku kuVar = dcaVar.b.e.g;
        bgz bgzVar = (bgz) kuVar.get(cls);
        if (bgzVar == null) {
            for (Map.Entry entry : (kp) kuVar.entrySet()) {
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    bgzVar = (bgz) entry.getValue();
                }
            }
        }
        this.aj = bgzVar == null ? bhw.a : bgzVar;
        this.ai = aVar.e;
        Iterator it = dcaVar.k.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            ar();
        }
        synchronized (dcaVar) {
            dcdVar = dcaVar.l;
        }
        q(dcdVar);
    }

    public final dbu ar() {
        if (this.m) {
            return clone().ar();
        }
        y();
        return this;
    }

    @Override // me.hd.wauxv.obf.nj
    /* JADX INFO: renamed from: as, reason: merged with bridge method [inline-methods] */
    public final dbu q(nj njVar) {
        cmz.m(njVar);
        return (dbu) super.q(njVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final dbs at(Object obj, dpw dpwVar, dbw dbwVar, bgz bgzVar, cvq cvqVar, int i, int i2, nj njVar) {
        dbw dbwVar2;
        dbw awoVar;
        nj njVar2;
        dbs dhtVar;
        cvq cvqVar2;
        if (this.an != null) {
            awoVar = new awo(obj, dbwVar);
            dbwVar2 = awoVar;
        } else {
            dbwVar2 = null;
            awoVar = dbwVar;
        }
        dbu dbuVar = this.am;
        if (dbuVar == null) {
            Context context = this.af;
            bhw bhwVar = this.ai;
            njVar2 = njVar;
            dhtVar = new dht(context, bhwVar, obj, this.ak, this.ah, njVar2, i, i2, cvqVar, dpwVar, this.al, awoVar, bhwVar.h, bgzVar.a);
        } else {
            if (this.aq) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            bgz bgzVar2 = dbuVar.ao ? bgzVar : dbuVar.aj;
            if (nj.p(dbuVar.a, 8)) {
                cvqVar2 = this.am.c;
            } else {
                int iOrdinal = cvqVar.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    cvqVar2 = cvq.a;
                } else if (iOrdinal == 2) {
                    cvqVar2 = cvq.b;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.c);
                    }
                    cvqVar2 = cvq.c;
                }
            }
            cvq cvqVar3 = cvqVar2;
            dbu dbuVar2 = this.am;
            int i3 = dbuVar2.f;
            int i4 = dbuVar2.e;
            if (eot.l(i, i2)) {
                dbu dbuVar3 = this.am;
                if (!eot.l(dbuVar3.f, dbuVar3.e)) {
                    i3 = njVar.f;
                    i4 = njVar.e;
                }
            }
            int i5 = i4;
            drt drtVar = new drt(obj, awoVar);
            Context context2 = this.af;
            drt drtVar2 = drtVar;
            bhw bhwVar2 = this.ai;
            dht dhtVar2 = new dht(context2, bhwVar2, obj, this.ak, this.ah, njVar, i, i2, cvqVar, dpwVar, this.al, drtVar2, bhwVar2.h, bgzVar.a);
            this.aq = true;
            dbu dbuVar4 = this.am;
            dbs dbsVarAt = dbuVar4.at(obj, dpwVar, drtVar2, bgzVar2, cvqVar3, i3, i5, dbuVar4);
            this.aq = false;
            drtVar2.c = dhtVar2;
            drtVar2.d = dbsVarAt;
            njVar2 = njVar;
            dhtVar = drtVar2;
        }
        if (dbwVar2 == null) {
            return dhtVar;
        }
        dbu dbuVar5 = this.an;
        int i6 = dbuVar5.f;
        int i7 = dbuVar5.e;
        if (eot.l(i, i2)) {
            dbu dbuVar6 = this.an;
            if (!eot.l(dbuVar6.f, dbuVar6.e)) {
                i6 = njVar2.f;
                i7 = njVar2.e;
            }
        }
        int i8 = i7;
        dbu dbuVar7 = this.an;
        awo awoVar2 = dbwVar2;
        dbs dbsVarAt2 = dbuVar7.at(obj, dpwVar, awoVar2, dbuVar7.aj, dbuVar7.c, i6, i8, dbuVar7);
        awoVar2.c = dhtVar;
        awoVar2.d = dbsVarAt2;
        return awoVar2;
    }

    @Override // me.hd.wauxv.obf.nj
    /* JADX INFO: renamed from: au, reason: merged with bridge method [inline-methods] */
    public final dbu clone() {
        dbu dbuVar = (dbu) super.clone();
        dbuVar.aj = dbuVar.aj.clone();
        if (dbuVar.al != null) {
            dbuVar.al = new ArrayList(dbuVar.al);
        }
        dbu dbuVar2 = dbuVar.am;
        if (dbuVar2 != null) {
            dbuVar.am = dbuVar2.clone();
        }
        dbu dbuVar3 = dbuVar.an;
        if (dbuVar3 != null) {
            dbuVar.an = dbuVar3.clone();
        }
        return dbuVar;
    }

    public final void av(dpw dpwVar, nj njVar) {
        cmz.m(dpwVar);
        if (!this.ap) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        dbs dbsVarAt = at(new Object(), dpwVar, null, this.aj, njVar.c, njVar.f, njVar.e, njVar);
        dbs dbsVarO = dpwVar.o();
        if (dbsVarAt.l(dbsVarO) && (njVar.d || !dbsVarO.q())) {
            cmz.n(dbsVarO, "Argument must not be null");
            if (dbsVarO.isRunning()) {
                return;
            }
            dbsVarO.n();
            return;
        }
        this.ag.n(dpwVar);
        dpwVar.h(dbsVarAt);
        dca dcaVar = this.ag;
        synchronized (dcaVar) {
            dcaVar.g.a.add(dpwVar);
            ConnectivityMonitor connectivityMonitorVar = dcaVar.e;
            ((Set) connectivityMonitorVar.d).add(dbsVarAt);
            if (connectivityMonitorVar.c) {
                dbsVarAt.clear();
                if (Log.isLoggable("RequestTracker", 2)) {
                    Log.v("RequestTracker", "Paused, delaying request");
                }
                ((HashSet) connectivityMonitorVar.e).add(dbsVarAt);
            } else {
                dbsVarAt.n();
            }
        }
    }

    public final dbu aw(Object obj) {
        if (this.m) {
            return clone().aw(obj);
        }
        this.ak = obj;
        this.ap = true;
        y();
        return this;
    }

    @Override // me.hd.wauxv.obf.nj
    public final boolean equals(Object obj) {
        if (!(obj instanceof dbu)) {
            return false;
        }
        dbu dbuVar = (dbu) obj;
        return super.equals(dbuVar) && Objects.equals(this.ah, dbuVar.ah) && this.aj.equals(dbuVar.aj) && Objects.equals(this.ak, dbuVar.ak) && Objects.equals(this.al, dbuVar.al) && Objects.equals(this.am, dbuVar.am) && Objects.equals(this.an, dbuVar.an) && this.ao == dbuVar.ao && this.ap == dbuVar.ap;
    }

    @Override // me.hd.wauxv.obf.nj
    public final int hashCode() {
        return eot.j(this.ap ? 1 : 0, eot.j(this.ao ? 1 : 0, eot.k(eot.k(eot.k(eot.k(eot.k(eot.k(eot.k(super.hashCode(), this.ah), this.aj), this.ak), this.al), this.am), this.an), null)));
    }
}
