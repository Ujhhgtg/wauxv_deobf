package me.hd.wauxv.obf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bib {
    public final Map a;

    public bib(Map map) {
        this.a = map;
    }

    public bib(aji ajiVar) {
        this.a = Collections.unmodifiableMap(new HashMap(ajiVar.b));
    }
}
