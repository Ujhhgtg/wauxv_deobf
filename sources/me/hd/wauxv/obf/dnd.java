package me.hd.wauxv.obf;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnd implements cdv {
    public final /* synthetic */ int a;
    public final cdv b;

    public /* synthetic */ dnd(cdv cdvVar, int i) {
        this.a = i;
        this.b = cdvVar;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final /* bridge */ /* synthetic */ boolean d(Object obj) {
        switch (this.a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        Uri uriFromFile;
        switch (this.a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uriFromFile = null;
                } else if (str.charAt(0) == '/') {
                    uriFromFile = Uri.fromFile(new File(str));
                } else {
                    Uri uri = Uri.parse(str);
                    uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
                }
                if (uriFromFile == null) {
                    return null;
                }
                cdv cdvVar = this.b;
                if (cdvVar.d(uriFromFile)) {
                    return cdvVar.e(uriFromFile, i, i2, crwVar);
                }
                return null;
            default:
                return this.b.e(new bid((URL) obj), i, i2, crwVar);
        }
    }
}
