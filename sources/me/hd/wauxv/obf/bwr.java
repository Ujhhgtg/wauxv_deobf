package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bwr {
    public final cqg g;
    public boolean h;
    public int i = -1;
    public final /* synthetic */ chv j;

    public bwr(chv chvVar, cqg cqgVar) {
        this.j = chvVar;
        this.g = cqgVar;
    }

    public abstract boolean a();

    public void d() {
    }

    public boolean f(bdj bdjVar) {
        return false;
    }

    public final void k(boolean z) {
        if (z == this.h) {
            return;
        }
        this.h = z;
        int i = z ? 1 : -1;
        chv chvVar = this.j;
        int i2 = chvVar.d;
        chvVar.d = i + i2;
        if (!chvVar.e) {
            chvVar.e = true;
            while (true) {
                try {
                    int i3 = chvVar.d;
                    if (i2 == i3) {
                        break;
                    } else {
                        i2 = i3;
                    }
                } catch (Throwable th) {
                    chvVar.e = false;
                    throw th;
                }
            }
            chvVar.e = false;
        }
        if (this.h) {
            chvVar.m(this);
        }
    }
}
