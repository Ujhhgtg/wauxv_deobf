package me.hd.wauxv.obf;

import android.content.Context;
import com.drake.net.exception.ConvertException;
import com.drake.net.exception.NetException;
import java.util.concurrent.CancellationException;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bho extends doi implements bgj {
    public final /* synthetic */ int a;
    public /* synthetic */ Object d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bho(String str, afw afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.e = str;
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
        return ((bho) h(ahpVar, afwVar)).i(KotlinUnit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                bho bhoVar = new bho(this.e, afwVar, 0);
                bhoVar.d = obj;
                return bhoVar;
            case 1:
                bho bhoVar2 = new bho(this.e, afwVar, 1);
                bhoVar2.d = obj;
                return bhoVar2;
            default:
                bho bhoVar3 = new bho(this.e, afwVar, 2);
                bhoVar3.d = obj;
                return bhoVar3;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        int i = this.a;
        String str = this.e;
        switch (i) {
            case 0:
                FastKV.bd(obj);
                ahp ahpVar = (ahp) this.d;
                cna.q(ahpVar.e());
                eoj eojVar = new eoj();
                eojVar.j(str);
                eojVar.c = 1;
                eojVar.i(ahpVar.e()._w(arj.b));
                eojVar.k(null);
                Context context = ckv.a;
                dbv.a(eojVar.d, dal.c(String.class));
                Response responseExecute = eojVar.e.newCall(eojVar.f()).execute();
                try {
                    Object objB = bhs.p(responseExecute.request()).b(StaticHelpers7.am(dal.c(String.class)), responseExecute);
                    if (objB != null) {
                        return (String) objB;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-44667659877162L)  */);
                } catch (NetException e) {
                    throw e;
                } catch (CancellationException e2) {
                    throw e2;
                } catch (Throwable th) {
                    throw new ConvertException(responseExecute, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-44946832751402L)  */, th, null, 8, null);
                }
            case 1:
                FastKV.bd(obj);
                ahp ahpVar2 = (ahp) this.d;
                cna.q(ahpVar2.e());
                eoj eojVar2 = new eoj();
                eojVar2.j(str);
                eojVar2.c = 1;
                eojVar2.i(ahpVar2.e()._w(arj.b));
                eojVar2.k(null);
                Context context2 = ckv.a;
                dbv.a(eojVar2.d, dal.c(String.class));
                Response responseExecute2 = eojVar2.e.newCall(eojVar2.f()).execute();
                try {
                    Object objB2 = bhs.p(responseExecute2.request()).b(StaticHelpers7.am(dal.c(String.class)), responseExecute2);
                    if (objB2 != null) {
                        return (String) objB2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-482006999759658L)  */);
                } catch (NetException e3) {
                    throw e3;
                } catch (CancellationException e4) {
                    throw e4;
                } catch (Throwable th2) {
                    throw new ConvertException(responseExecute2, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-483454403738410L)  */, th2, null, 8, null);
                }
            default:
                FastKV.bd(obj);
                ahp ahpVar3 = (ahp) this.d;
                cna.q(ahpVar3.e());
                eoj eojVar3 = new eoj();
                eojVar3.j(str);
                eojVar3.c = 1;
                eojVar3.i(ahpVar3.e()._w(arj.b));
                eojVar3.k(null);
                Context context3 = ckv.a;
                dbv.a(eojVar3.d, dal.c(String.class));
                Response responseExecute3 = eojVar3.e.newCall(eojVar3.f()).execute();
                try {
                    Object objB3 = bhs.p(responseExecute3.request()).b(StaticHelpers7.am(dal.c(String.class)), responseExecute3);
                    if (objB3 != null) {
                        return (String) objB3;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-483583252757290L)  */);
                } catch (NetException e5) {
                    throw e5;
                } catch (CancellationException e6) {
                    throw e6;
                } catch (Throwable th3) {
                    throw new ConvertException(responseExecute3, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-482848813349674L)  */, th3, null, 8, null);
                }
        }
    }
}
