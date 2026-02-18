package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aom {
    public boolean a;
    public final Object b;
    public final Object c;
    public final Object d;

    public aom(afr afrVar, dhu dhuVar) {
        this.d = new dhw(this);
        this.c = afrVar;
        this.b = dhuVar;
    }

    public void e() {
        aoo.o((aoo) this.d, this, false);
    }

    public File f() {
        File file;
        synchronized (((aoo) this.d)) {
            try {
                aon aonVar = (aon) this.b;
                if (aonVar.f != this) {
                    throw new IllegalStateException();
                }
                if (!aonVar.e) {
                    ((boolean[]) this.c)[0] = true;
                }
                file = aonVar.d[0];
                ((aoo) this.d).a.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public aom(aoo aooVar, aon aonVar) {
        this.d = aooVar;
        this.b = aonVar;
        this.c = aonVar.e ? null : new boolean[aooVar.g];
    }
}
