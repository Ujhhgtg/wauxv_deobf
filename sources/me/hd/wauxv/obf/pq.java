package me.hd.wauxv.obf;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pq extends ni {
    public RequestBody l;
    public MultipartBody.Builder m;
    public FormBody.Builder n;
    public MediaType o;
    public int p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [okhttp3.RequestBody] */
    /* JADX WARN: Type inference failed for: r1v1, types: [okhttp3.RequestBody] */
    /* JADX WARN: Type inference failed for: r1v8, types: [okhttp3.FormBody] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [okhttp3.Request$Builder] */
    @Override // me.hd.wauxv.obf.ni
    public final Request f() {
        MultipartBody.Builder builder = this.m;
        ?? Build = this.l;
        if (Build == 0) {
            Build = this.n.build();
            try {
                builder.build();
                int size = Build.size();
                for (int i = 0; i < size; i++) {
                    builder.addFormDataPart(Build.name(i), Build.value(i));
                }
                Build = builder.setType(this.o).build();
            } catch (IllegalStateException unused) {
            }
        }
        Request.Builder builderUrl = this.d.method(bjs.z(this.p), Build).url(this.a.build());
        bzo.q(builderUrl, "<this>");
        ckw ckwVar = this.b;
        bzo.q(ckwVar, "converter");
        builderUrl.tag(ckw.class, ckwVar);
        return builderUrl.build();
    }
}
