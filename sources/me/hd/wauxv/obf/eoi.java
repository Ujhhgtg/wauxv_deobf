package me.hd.wauxv.obf;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eoi implements cdv {
    public static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));
    public final Object b;

    public eoi(eoh eohVar) {
        this.b = eohVar;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        return a.contains(((Uri) obj).getScheme());
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        ajb lcVar;
        Uri uri = (Uri) obj;
        cpi cpiVar = new cpi(uri);
        eoh eohVar = (eoh) this.b;
        switch (eohVar.a) {
            case 0:
                lcVar = new lc(eohVar.b, uri, eohVar.c, 0);
                break;
            case 1:
                lcVar = new lc(eohVar.b, uri, eohVar.c, 1);
                break;
            default:
                lcVar = new dmw(eohVar.b, uri, eohVar.c);
                break;
        }
        return new cdu(cpiVar, lcVar);
    }
}
