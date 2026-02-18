package me.hd.wauxv.obf;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eok implements cdv {
    public static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final cdv b;

    public eok(cdv cdvVar) {
        this.b = cdvVar;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        return a.contains(((Uri) obj).getScheme());
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        return this.b.e(new bid(((Uri) obj).toString()), i, i2, crwVar);
    }
}
