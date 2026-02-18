package me.hd.wauxv.obf;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cws implements cdv {
    public final Context a;
    public final cdv b;
    public final cdv c;
    public final Class f;

    public cws(Context context, cdv cdvVar, cdv cdvVar2, Class cls) {
        this.a = context.getApplicationContext();
        this.b = cdvVar;
        this.c = cdvVar2;
        this.f = cls;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && dqc.bd((Uri) obj);
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        Uri uri = (Uri) obj;
        return new cdu(new cpi(uri), new cwr(this.a, this.b, this.c, uri, i, i2, crwVar, this.f));
    }
}
