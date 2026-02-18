package me.hd.wauxv.obf;

import android.os.Looper;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class chv {
    public static final Object a = new Object();
    public final Object b = new Object();
    public final dee c = new dee();
    public int d = 0;
    public boolean e;
    public volatile Object f;
    public volatile Object g;
    public int h;
    public boolean i;
    public boolean j;

    public chv() {
        Object obj = a;
        this.g = obj;
        this.f = obj;
        this.h = -1;
    }

    public static void k(String str) {
        ((kj) kj.c().b).getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(concat("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void l(bwr bwrVar) {
        if (bwrVar.h) {
            if (!bwrVar.a()) {
                bwrVar.k(false);
                return;
            }
            int i = bwrVar.i;
            int i2 = this.h;
            if (i >= i2) {
                return;
            }
            bwrVar.i = i2;
            bwrVar.g.b(this.f);
        }
    }

    public final void m(bwr bwrVar) {
        if (this.i) {
            this.j = true;
            return;
        }
        this.i = true;
        do {
            this.j = false;
            if (bwrVar != null) {
                l(bwrVar);
                bwrVar = null;
            } else {
                dee deeVar = this.c;
                deeVar.getClass();
                dec decVar = new dec(deeVar);
                deeVar.f.put(decVar, Boolean.FALSE);
                while (decVar.hasNext()) {
                    l((bwr) ((Map.Entry) decVar.next()).getValue());
                    if (this.j) {
                        break;
                    }
                }
            }
        } while (this.j);
        this.i = false;
    }
}
