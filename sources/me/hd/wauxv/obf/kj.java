package me.hd.wauxv.obf;

import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kj extends bhu {
    public static volatile kj a;
    public final Object b;

    public kj(int i) {
        switch (i) {
            case 1:
                this.b = new Object();
                Executors.newFixedThreadPool(4, new alo());
                break;
            default:
                this.b = new kj(1);
                break;
        }
    }

    public static kj c() {
        if (a != null) {
            return a;
        }
        synchronized (kj.class) {
            try {
                if (a == null) {
                    a = new kj(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a;
    }
}
