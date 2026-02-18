package me.hd.wauxv.obf;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cih {
    public final /* synthetic */ int a;
    public final bno b;

    public cih(int i) {
        this.a = i;
        switch (i) {
            case 1:
                this.b = new dny();
                new ConcurrentHashMap();
                new ThreadLocal();
                new oe();
                break;
            default:
                this.b = new cbm(3);
                new ConcurrentHashMap();
                break;
        }
    }
}
