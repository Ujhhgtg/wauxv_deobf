package me.hd.wauxv.plugin.api.method;

import android.content.Context;
import com.drake.net.exception.ConvertException;
import com.drake.net.exception.NetException;
import java.util.concurrent.CancellationException;
import me.hd.wauxv.obf.kotlinx$coroutines$internal$DispatchedContinuation;
import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.ajm;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bgj;
import me.hd.wauxv.obf.bhs;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.cbb;
import me.hd.wauxv.obf.ckv;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cue;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dbv;
import me.hd.wauxv.obf.doi;
import me.hd.wauxv.obf.StaticHelpers7;
import me.hd.wauxv.obf.Kotlin$Unit;
import me.hd.wauxv.obf.pq;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ajm(c = "com.drake.net.NetCoroutineKt$Post$1", f = "NetCoroutine.kt", l = {}, m = "invokeSuspend")
public final class PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1 extends doi implements bgj {
    public /* synthetic */ Object a;
    public final /* synthetic */ String d;
    public final /* synthetic */ cue e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1(String str, cue cueVar, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(2, afwVar);
        this.d = str;
        this.e = cueVar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        return ((PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1) h((ahp) obj, (kotlinx$coroutines$internal$DispatchedContinuation) obj2)).i(Kotlin$Unit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final kotlinx$coroutines$internal$DispatchedContinuation h(Object obj, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1 pluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1 = new PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1(this.d, this.e, afwVar);
        pluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1.a = obj;
        return pluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1;
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        FastKV.bd(obj);
        ahp ahpVar = (ahp) this.a;
        cna.q(ahpVar.e());
        pq pqVar = new pq();
        pqVar.m = new MultipartBody.Builder(null, 1, null);
        pqVar.n = new FormBody.Builder(null, 1, null);
        pqVar.o = cbb.b;
        pqVar.p = 5;
        pqVar.j(this.d);
        pqVar.p = 5;
        pqVar.i(ahpVar.e()._w(arj.b));
        pqVar.k(null);
        this.e.invoke(pqVar);
        Context context = ckv.a;
        dbv.a(pqVar.d, dal.c(Response.class));
        Response responseExecute = pqVar.e.newCall(pqVar.f()).execute();
        try {
            Object objB = bhs.p(responseExecute.request()).b(StaticHelpers7.am(dal.c(Response.class)), responseExecute);
            if (objB != null) {
                return (Response) objB;
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.Response" /* "null cannot be cast to non-null type okhttp3.Response" /* "null cannot be cast to non-null type okhttp3.Response" /* cnb.z(-404289566538538L)  */);
        } catch (NetException e) {
            throw e;
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new ConvertException(responseExecute, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-404590214249258L)  */, th, null, 8, null);
        }
    }
}
