package me.hd.wauxv.obf;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eqx {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static afm b(View view, afm afmVar) {
        ContentInfo contentInfo_ag = afmVar.a._ag();
        Objects.requireNonNull(contentInfo_ag);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfo_ag);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfo_ag ? afmVar : new afm(new erp(contentInfoPerformReceiveContent));
    }
}
