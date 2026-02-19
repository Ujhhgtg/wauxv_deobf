package me.hd.wauxv.plugin.api.method;

import java.io.File;
import java.util.Map;
import me.hd.wauxv.obf.afw;
import me.hd.wauxv.obf.ahp;
import me.hd.wauxv.obf.ahq;
import me.hd.wauxv.obf.ajm;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.akq;
import me.hd.wauxv.obf.alc;
import me.hd.wauxv.obf.aou;
import me.hd.wauxv.obf.bgj;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bmy;
import me.hd.wauxv.obf.cla;
import me.hd.wauxv.obf.KotlinHelpers2;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.cue;
import me.hd.wauxv.obf.cug;
import me.hd.wauxv.obf.dob;
import me.hd.wauxv.obf.doi;
import me.hd.wauxv.obf.KotlinUnit;
import me.hd.wauxv.plugin.api.callback.PluginCallBack;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginHttpMethod {

    /* JADX INFO: renamed from: me.hd.wauxv.plugin.api.method.PluginHttpMethod$download$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @ajm(c = "me.hd.wauxv.plugin.api.method.PluginHttpMethod$download$1", f = "PluginHttpMethod.kt", l = {78}, m = "invokeSuspend", v = 1)
    public static final class AnonymousClass1 extends doi implements bgj {
        public int a;
        public /* synthetic */ Object d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ String o;
        public final /* synthetic */ long p;
        public final /* synthetic */ PluginCallBack.DownloadCallback r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Map map, String str2, long j, PluginCallBack.DownloadCallback downloadCallback, afw afwVar) {
            super(2, afwVar);
            this.e = str;
            this.f = map;
            this.o = str2;
            this.p = j;
            this.r = downloadCallback;
        }

        @Override // me.hd.wauxv.obf.bgj
        public final Object g(Object obj, Object obj2) {
            return ((AnonymousClass1) h((ahp) obj, (afw) obj2)).i(KotlinUnit.INSTANCE);
        }

        @Override // me.hd.wauxv.obf.nc
        public final afw h(Object obj, afw afwVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.e, this.f, this.o, this.p, this.r, afwVar);
            anonymousClass1.d = obj;
            return anonymousClass1;
        }

        @Override // me.hd.wauxv.obf.nc
        public final Object i(Object obj) throws Exception {
            ahp ahpVar = (ahp) this.d;
            int i = this.a;
            if (i == 0) {
                bhu.bd(obj);
                cue cueVar = new cue(this.f, this.o, this.p, 0);
                alc alcVar = aou.a;
                akq akqVar = akq.f;
                dob dobVar = new dob();
                akqVar.getClass();
                cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new PluginHttpMethod$download$1$invokeSuspend$$inlined$Get$default$1(this.e, cueVar, null)));
                this.d = null;
                this.a = 1;
                obj = claVar._be(this);
                ahq ahqVar = ahq.a;
                if (obj == ahqVar) {
                    return ahqVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-403172875041578L)  */);
                }
                bhu.bd(obj);
            }
            this.r.onSuccess((File) obj);
            return KotlinUnit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: me.hd.wauxv.plugin.api.method.PluginHttpMethod$get$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @ajm(c = "me.hd.wauxv.plugin.api.method.PluginHttpMethod$get$1", f = "PluginHttpMethod.kt", l = {28}, m = "invokeSuspend", v = 1)
    public static final class C00241 extends doi implements bgj {
        public int a;
        public /* synthetic */ Object d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ long o;
        public final /* synthetic */ PluginCallBack.HttpCallback p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00241(String str, Map map, long j, PluginCallBack.HttpCallback httpCallback, afw afwVar) {
            super(2, afwVar);
            this.e = str;
            this.f = map;
            this.o = j;
            this.p = httpCallback;
        }

        @Override // me.hd.wauxv.obf.bgj
        public final Object g(Object obj, Object obj2) {
            return ((C00241) h((ahp) obj, (afw) obj2)).i(KotlinUnit.INSTANCE);
        }

        @Override // me.hd.wauxv.obf.nc
        public final afw h(Object obj, afw afwVar) {
            C00241 c00241 = new C00241(this.e, this.f, this.o, this.p, afwVar);
            c00241.d = obj;
            return c00241;
        }

        @Override // me.hd.wauxv.obf.nc
        public final Object i(Object obj) throws Exception {
            ahp ahpVar = (ahp) this.d;
            int i = this.a;
            if (i == 0) {
                bhu.bd(obj);
                cug cugVar = new cug(this.f, this.o, 0);
                alc alcVar = aou.a;
                akq akqVar = akq.f;
                dob dobVar = new dob();
                akqVar.getClass();
                cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new PluginHttpMethod$get$1$invokeSuspend$$inlined$Get$default$1(this.e, cugVar, null)));
                this.d = null;
                this.a = 1;
                obj = claVar._be(this);
                ahq ahqVar = ahq.a;
                if (obj == ahqVar) {
                    return ahqVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-402846457527082L)  */);
                }
                bhu.bd(obj);
            }
            Response response = (Response) obj;
            int iCode = response.code();
            ResponseBody responseBodyBody = response.body();
            this.p.onSuccess(iCode, responseBodyBody != null ? responseBodyBody.string() : null);
            return KotlinUnit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: me.hd.wauxv.plugin.api.method.PluginHttpMethod$post$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @ajm(c = "me.hd.wauxv.plugin.api.method.PluginHttpMethod$post$1", f = "PluginHttpMethod.kt", l = {56}, m = "invokeSuspend", v = 1)
    public static final class C00251 extends doi implements bgj {
        public int a;
        public /* synthetic */ Object d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Map f;
        public final /* synthetic */ Map o;
        public final /* synthetic */ long p;
        public final /* synthetic */ PluginCallBack.HttpCallback r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00251(String str, Map map, Map map2, long j, PluginCallBack.HttpCallback httpCallback, afw afwVar) {
            super(2, afwVar);
            this.e = str;
            this.f = map;
            this.o = map2;
            this.p = j;
            this.r = httpCallback;
        }

        @Override // me.hd.wauxv.obf.bgj
        public final Object g(Object obj, Object obj2) {
            return ((C00251) h((ahp) obj, (afw) obj2)).i(KotlinUnit.INSTANCE);
        }

        @Override // me.hd.wauxv.obf.nc
        public final afw h(Object obj, afw afwVar) {
            C00251 c00251 = new C00251(this.e, this.f, this.o, this.p, this.r, afwVar);
            c00251.d = obj;
            return c00251;
        }

        @Override // me.hd.wauxv.obf.nc
        public final Object i(Object obj) throws Exception {
            ahp ahpVar = (ahp) this.d;
            int i = this.a;
            if (i == 0) {
                bhu.bd(obj);
                cue cueVar = new cue(this.f, this.o, this.p, 1);
                alc alcVar = aou.a;
                akq akqVar = akq.f;
                dob dobVar = new dob();
                akqVar.getClass();
                cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new PluginHttpMethod$post$1$invokeSuspend$$inlined$Post$default$1(this.e, cueVar, null)));
                this.d = null;
                this.a = 1;
                obj = claVar._be(this);
                ahq ahqVar = ahq.a;
                if (obj == ahqVar) {
                    return ahqVar;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-403688271117098L)  */);
                }
                bhu.bd(obj);
            }
            Response response = (Response) obj;
            int iCode = response.code();
            ResponseBody responseBodyBody = response.body();
            this.r.onSuccess(iCode, responseBodyBody != null ? responseBodyBody.string() : null);
            return KotlinUnit.INSTANCE;
        }
    }

    @cty
    public final void download(String str, String str2, Map<String, String> map, PluginCallBack.DownloadCallback downloadCallback) {
        download(str, str2, map, 30L, downloadCallback);
    }

    @cty
    public final void get(String str, Map<String, String> map, PluginCallBack.HttpCallback httpCallback) {
        get(str, map, 30L, httpCallback);
    }

    @cty
    public final void post(String str, Map<String, String> map, Map<String, String> map2, PluginCallBack.HttpCallback httpCallback) {
        post(str, map, map2, 30L, httpCallback);
    }

    @cty
    public final void download(String str, String str2, Map<String, String> map, long j, PluginCallBack.DownloadCallback downloadCallback) {
        KotlinHelpers2.bg(new AnonymousClass1(str, map, str2, j, downloadCallback, null));
    }

    @cty
    public final void get(String str, Map<String, String> map, long j, PluginCallBack.HttpCallback httpCallback) {
        KotlinHelpers2.bg(new C00241(str, map, j, httpCallback, null));
    }

    @cty
    public final void post(String str, Map<String, String> map, Map<String, String> map2, long j, PluginCallBack.HttpCallback httpCallback) {
        KotlinHelpers2.bg(new C00251(str, map2, map, j, httpCallback, null));
    }
}
