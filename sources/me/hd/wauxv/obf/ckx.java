package me.hd.wauxv.obf;

import android.util.Pair;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ckx extends doi implements bgj {
    public final /* synthetic */ int a = 1;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Serializable o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ckx(Pair pair, String str, String str2, afw afwVar) {
        super(2, afwVar);
        this.e = pair;
        this.f = str;
        this.o = str2;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((ckx) h(ahpVar, afwVar)).i(ens.a);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [me.hd.wauxv.obf.bgj, me.hd.wauxv.obf.doi] */
    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                ckx ckxVar = new ckx((cky) this.f, (bgj) this.o, afwVar);
                ckxVar.e = obj;
                return ckxVar;
            case 1:
                return new ckx((Pair) this.e, (String) this.f, (String) this.o, afwVar);
            default:
                ckx ckxVar2 = new ckx((String) this.f, (String) this.o, afwVar);
                ckxVar2.e = obj;
                return ckxVar2;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [me.hd.wauxv.obf.bgj, me.hd.wauxv.obf.doi] */
    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        ahp ahpVar;
        int i = this.a;
        Object obj2 = this.f;
        afw afwVar = null;
        ens ensVar = ens.a;
        Serializable serializable = this.o;
        ahq ahqVar = ahq.a;
        int i2 = 1;
        switch (i) {
            case 0:
                int i3 = this.d;
                if (i3 == 0) {
                    bhu.bd(obj);
                    ahpVar = (ahp) this.e;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        bhu.bd(obj);
                        return ensVar;
                    }
                    ahpVar = (ahp) this.e;
                    bhu.bd(obj);
                }
                this.e = null;
                this.d = 2;
                return ((doi) serializable).g(ahpVar, this) == ahqVar ? ahqVar : ensVar;
            case 1:
                String str = (String) serializable;
                String str2 = (String) obj2;
                Pair pair = (Pair) this.e;
                int i4 = this.d;
                if (i4 == 0) {
                    bhu.bd(obj);
                    cmn.a.getClass();
                    cme.b(cme.a, emn.ba(cmm.a).newInstance(pair, str2, str, 1));
                    this.d = 1;
                    if (dqc.ba(5000L, this) == ahqVar) {
                        return ahqVar;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException(cnb.z(-116024246532906L));
                    }
                    bhu.bd(obj);
                }
                cmn.a.getClass();
                cme.b(cme.a, emn.ba(cmm.a).newInstance(pair, str2, str, 0));
                return ensVar;
            default:
                ahp ahpVar2 = (ahp) this.e;
                int i5 = this.d;
                if (i5 != 0) {
                    if (i5 != 1) {
                        throw new IllegalStateException(cnb.z(-541230303804202L));
                    }
                    bhu.bd(obj);
                    return ensVar;
                }
                bhu.bd(obj);
                beo beoVar = new beo((String) serializable, i2);
                alc alcVar = aou.a;
                akq akqVar = akq.f;
                dob dobVar = new dob();
                akqVar.getClass();
                cla claVar = new cla(ajn.g(ahpVar2, bmy.aa(akqVar, dobVar), new bhn((String) obj2, beoVar, afwVar, i2)));
                this.e = null;
                this.d = 1;
                return claVar._be(this) == ahqVar ? ahqVar : ensVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ckx(String str, String str2, afw afwVar) {
        super(2, afwVar);
        this.f = str;
        this.o = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ckx(cky ckyVar, bgj bgjVar, afw afwVar) {
        super(2, afwVar);
        this.f = ckyVar;
        this.o = (doi) bgjVar;
    }
}
