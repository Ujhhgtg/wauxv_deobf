package me.hd.wauxv.obf;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ov implements dcq, cdw {
    public final /* synthetic */ int a;
    public final Resources b;

    public /* synthetic */ ov(Resources resources, int i) {
        this.a = i;
        this.b = resources;
    }

    @Override // me.hd.wauxv.obf.dcq
    public dcg g(dcg dcgVar, crw crwVar) {
        if (dcgVar == null) {
            return null;
        }
        return new pa(this.b, dcgVar);
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        switch (this.a) {
            case 1:
                return new le(this.b, chmVar.w(Uri.class, AssetFileDescriptor.class));
            case 2:
                return new le(this.b, chmVar.w(Uri.class, InputStream.class));
            default:
                return new le(this.b, ent.a);
        }
    }
}
