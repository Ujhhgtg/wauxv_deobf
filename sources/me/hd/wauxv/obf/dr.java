package me.hd.wauxv.obf;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dr extends bhs {
    public final String a;

    public dr(String str) {
        this.a = str;
    }

    @Override // me.hd.wauxv.obf.bhs
    public final Intent b(hb hbVar, String str) {
        Intent intentPutExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.a).putExtra("android.intent.extra.TITLE", str);
        bzo.p(intentPutExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
        return intentPutExtra;
    }

    @Override // me.hd.wauxv.obf.bhs
    public final bc c(hb hbVar, String str) {
        return null;
    }

    @Override // me.hd.wauxv.obf.bhs
    public final Object d(Intent intent, int i) {
        if (i != -1) {
            intent = null;
        }
        if (intent != null) {
            return intent.getData();
        }
        return null;
    }
}
