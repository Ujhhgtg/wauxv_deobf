package me.hd.wauxv.plugin.api.method;

import android.content.Context;
import com.drake.net.exception.ConvertException;
import com.drake.net.exception.NetException;
import java.util.concurrent.CancellationException;
import me.hd.wauxv.obf.afw;
import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.ajm;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bgj;
import me.hd.wauxv.obf.bhs;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.ckv;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cug;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dbv;
import me.hd.wauxv.obf.doi;
import me.hd.wauxv.obf.StaticHelpers7;
import me.hd.wauxv.obf.KotlinUnit;
import me.hd.wauxv.obf.eoj;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ajm(c = "com.drake.net.NetCoroutineKt$Get$1", f = "NetCoroutine.kt", l = {}, m = "invokeSuspend")
public final class PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1 extends doi implements bgj {
    public /* synthetic */ Object a;
    public final /* synthetic */ String d;
    public final /* synthetic */ cug e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1(String str, cug cugVar, afw afwVar) {
        super(2, afwVar);
        this.d = str;
        this.e = cugVar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        return ((PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1) h((ahp) obj, (afw) obj2)).i(KotlinUnit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1 pluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1 = new PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1(this.d, this.e, afwVar);
        pluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1.a = obj;
        return pluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1;
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        FastKV.bd(obj);
        ahp ahpVar = (ahp) this.a;
        cna.q(ahpVar.e());
        eoj eojVar = new eoj();
        eojVar.j(this.d);
        eojVar.c = 1;
        eojVar.i(ahpVar.e()._w(arj.b));
        eojVar.k(null);
        this.e.invoke(eojVar);
        Context context = ckv.a;
        dbv.a(eojVar.d, dal.c(Response.class));
        Response responseExecute = eojVar.e.newCall(eojVar.f()).execute();
        try {
            Object objB = bhs.p(responseExecute.request()).b(StaticHelpers7.am(dal.c(Response.class)), responseExecute);
            if (objB != null) {
                return (Response) objB;
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Response" /* "null cannot be cast to non-null type okhttp3.Response" /* "null cannot be cast to non-null type okhttp3.Response" /* cnb.z(-403516472425258L)  */);
        } catch (NetException e) {
            throw e;
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new ConvertException(responseExecute, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-403267364322090L)  */, th, null, 8, null);
        }
    }
}
