package me.hd.wauxv.plugin.api.method;

import android.content.Context;
import com.drake.net.exception.ConvertException;
import com.drake.net.exception.NetException;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import me.hd.wauxv.obf.afw;
import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.ajm;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.bgj;
import me.hd.wauxv.obf.bhs;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.ckv;
import me.hd.wauxv.obf.ckw;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cue;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dam;
import me.hd.wauxv.obf.dbv;
import me.hd.wauxv.obf.doi;
import me.hd.wauxv.obf.eme;
import me.hd.wauxv.obf.StaticHelpers7;
import me.hd.wauxv.obf.KotlinUnit;
import me.hd.wauxv.obf.eoj;
import me.hd.wauxv.obf.zc;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ajm(c = "com.drake.net.NetCoroutineKt$Get$1", f = "NetCoroutine.kt", l = {}, m = "invokeSuspend")
public final class PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1 extends doi implements bgj {
    public /* synthetic */ Object a;
    public final /* synthetic */ String d;
    public final /* synthetic */ cue e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1(String str, cue cueVar, afw afwVar) {
        super(2, afwVar);
        this.d = str;
        this.e = cueVar;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        return ((PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1) h((ahp) obj, (afw) obj2)).i(KotlinUnit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1 pluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1 = new PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1(this.d, this.e, afwVar);
        pluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1.a = obj;
        return pluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1;
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
        dam damVar = dal.a;
        zc zcVarB = dal.b(File.class);
        List list = Collections.EMPTY_LIST;
        damVar.getClass();
        dbv.a(eojVar.d, new eme(zcVarB, true));
        Response responseExecute = eojVar.e.newCall(eojVar.f()).execute();
        try {
            ckw ckwVarP = bhs.p(responseExecute.request());
            zc zcVarB2 = dal.b(File.class);
            damVar.getClass();
            return (File) ckwVarP.b(StaticHelpers7.am(new eme(zcVarB2, true)), responseExecute);
        } catch (NetException e) {
            throw e;
        } catch (CancellationException e2) {
            throw e2;
        } catch (Throwable th) {
            throw new ConvertException(responseExecute, "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* "An unexpected error occurred in the converter" /* cnb.z(-396927992593194L)  */, th, null, 8, null);
        }
    }
}
