package me.hd.wauxv.obf;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajs {
    public final Class a;
    public final List b;
    public final dcq c;
    public final cuv d;
    public final String e;

    public ajs(Class cls, Class cls2, Class cls3, List list, dcq dcqVar, cuv cuvVar) {
        this.a = cls;
        this.b = list;
        this.c = dcqVar;
        this.d = cuvVar;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final dcg f(int i, int i2, ek ekVar, ajh ajhVar, crw crwVar) {
        dcg dcgVarA;
        elc elcVar;
        int iX;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Object aizVar;
        cuv cuvVar = this.d;
        List list = (List) cuvVar.acquire();
        cmz.n(list, "Argument must not be null");
        try {
            dcg dcgVarG = g(ajhVar, i, i2, crwVar, list);
            cuvVar.l(list);
            ajr ajrVar = (ajr) ekVar.d;
            int i3 = ekVar.c;
            ajp ajpVar = ajrVar.d;
            Class<?> cls = dcgVarG.get().getClass();
            dcm dcmVarB = null;
            if (i3 != 4) {
                elc elcVarW = ajpVar.w(cls);
                elcVar = elcVarW;
                dcgVarA = elcVarW.a(ajrVar.k, dcgVarG, ajrVar.o, ajrVar.p);
            } else {
                dcgVarA = dcgVarG;
                elcVar = null;
            }
            if (!dcgVarG.equals(dcgVarA)) {
                dcgVarG.c();
            }
            if (ajpVar.c.l().d.b(dcgVarA.e()) != null) {
                dcmVarB = ajpVar.c.l().d.b(dcgVarA.e());
                if (dcmVarB == null) {
                    throw new dar(dcgVarA.e());
                }
                iX = dcmVarB.x(ajrVar.r);
            } else {
                iX = 3;
            }
            dcm dcmVar = dcmVarB;
            btj btjVar = ajrVar.z;
            ArrayList arrayListT = ajpVar.t();
            int size = arrayListT.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    z = false;
                    break;
                }
                if (((cdu) arrayListT.get(i4)).a.equals(btjVar)) {
                    z = true;
                    break;
                }
                i4++;
            }
            switch (ajrVar.q.d) {
                default:
                    z2 = true;
                    if (((z || i3 != 3) && i3 != 1) || iX != 2) {
                    }
                case 0:
                case 1:
                    z2 = false;
                    break;
            }
            if (z2) {
                if (dcmVar == null) {
                    throw new dar(dcgVarA.get().getClass());
                }
                int iAe = StaticHelpers6.ae(iX);
                if (iAe == 0) {
                    z3 = false;
                    z4 = true;
                    aizVar = new aiz(ajrVar.z, ajrVar.l);
                } else {
                    if (iAe != 1) {
                        throw new IllegalArgumentException("Unknown strategy: ".concat(iX != 1 ? iX != 2 ? iX != 3 ? "null" : "NONE" : "TRANSFORMED" : "SOURCE"));
                    }
                    z3 = false;
                    z4 = true;
                    aizVar = new dci(ajpVar.c.b, ajrVar.z, ajrVar.l, ajrVar.o, ajrVar.p, elcVar, cls, ajrVar.r);
                }
                bxp bxpVar = (bxp) bxp.a.acquire();
                bxpVar.h = z3;
                bxpVar.g = z4;
                bxpVar.f = dcgVarA;
                FactoryPools factoryPoolsVar = ajrVar.i;
                factoryPoolsVar.e = aizVar;
                factoryPoolsVar.f = dcmVar;
                factoryPoolsVar.h = bxpVar;
                dcgVarA = bxpVar;
            }
            return this.c.g(dcgVarA, crwVar);
        } catch (Throwable th) {
            cuvVar.l(list);
            throw th;
        }
    }

    public final dcg g(ajh ajhVar, int i, int i2, crw crwVar, List list) throws bhy {
        List list2 = this.b;
        int size = list2.size();
        dcg dcgVarC = null;
        for (int i3 = 0; i3 < size; i3++) {
            dcj dcjVar = (dcj) list2.get(i3);
            try {
                if (dcjVar.d(ajhVar.d(), crwVar)) {
                    dcgVarC = dcjVar.c(ajhVar.d(), i, i2, crwVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + dcjVar, e);
                }
                list.add(e);
            }
            if (dcgVarC != null) {
                break;
            }
        }
        if (dcgVarC != null) {
            return dcgVarC;
        }
        throw new bhy(this.e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
