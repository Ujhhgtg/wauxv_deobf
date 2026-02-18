package me.hd.wauxv.obf;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cuf implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;

    public /* synthetic */ cuf(long j, int i) {
        this.a = i;
        this.b = j;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                OkHttpClient.Builder builder = (OkHttpClient.Builder) obj;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                long j = this.b;
                builder.connectTimeout(j, timeUnit);
                builder.readTimeout(j, timeUnit);
                builder.writeTimeout(j, timeUnit);
                break;
            case 1:
                OkHttpClient.Builder builder2 = (OkHttpClient.Builder) obj;
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                long j2 = this.b;
                builder2.connectTimeout(j2, timeUnit2);
                builder2.readTimeout(j2, timeUnit2);
                builder2.writeTimeout(j2, timeUnit2);
                break;
            case 2:
                OkHttpClient.Builder builder3 = (OkHttpClient.Builder) obj;
                TimeUnit timeUnit3 = TimeUnit.SECONDS;
                long j3 = this.b;
                builder3.connectTimeout(j3, timeUnit3);
                builder3.readTimeout(j3, timeUnit3);
                builder3.writeTimeout(j3, timeUnit3);
                break;
            default:
                cug cugVar = new cug((diz) obj, this.b, 1);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                cugVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                break;
        }
        return ens.a;
    }
}
