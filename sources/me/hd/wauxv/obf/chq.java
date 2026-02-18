package me.hd.wauxv.obf;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class chq extends ahx {
    public chq(ahx ahxVar) {
        bzo.q(ahxVar, "initialExtras");
        LinkedHashMap linkedHashMap = ahxVar.c;
        bzo.q(linkedHashMap, "initialExtras");
        this.c.putAll(linkedHashMap);
    }

    @Override // me.hd.wauxv.obf.ahx
    public final Object b(ahw ahwVar) {
        return this.c.get(ahwVar);
    }

    public /* synthetic */ chq(int i) {
        this(ahv.a);
    }
}
