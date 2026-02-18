package me.hd.wauxv.obf;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbd implements cdv {
    public final /* synthetic */ int a;
    public final Context b;

    public cbd(Context context, int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = context.getApplicationContext();
                break;
            case 2:
                this.b = context.getApplicationContext();
                break;
            default:
                this.b = context;
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        switch (this.a) {
            case 0:
                return dqc.bd((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return dqc.bd(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return dqc.bd(uri2) && uri2.getPathSegments().contains("video");
        }
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        Long l;
        switch (this.a) {
            case 0:
                Uri uri = (Uri) obj;
                return new cdu(new cpi(uri), new cbc(this.b, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384) {
                    return null;
                }
                cpi cpiVar = new cpi(uri2);
                Context context = this.b;
                return new cdu(cpiVar, ajj.i(context, uri2, new drr(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384 || (l = (Long) crwVar.b(epu.a)) == null || l.longValue() != -1) {
                    return null;
                }
                cpi cpiVar2 = new cpi(uri3);
                Context context2 = this.b;
                return new cdu(cpiVar2, ajj.i(context2, uri3, new drr(context2.getContentResolver(), 1)));
        }
    }
}
