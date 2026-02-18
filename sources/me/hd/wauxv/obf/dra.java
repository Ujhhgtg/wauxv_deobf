package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dra {
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public dqz e;
    public dqx f;

    public final void g() {
        if (this.a) {
            return;
        }
        if (!this.f.g(this.b, this.c)) {
            this.e.c = 0.0f;
        }
        this.a = true;
        this.d = false;
    }

    public final void h(float f, float f2) {
        if (this.a) {
            if (!this.d || Math.abs(f - 0.0f) > 1.0E-6f) {
                this.b = f;
            } else {
                this.b = 0.0f;
            }
            this.c = f2;
            this.a = false;
            this.d = false;
            return;
        }
        if (!this.d && Math.abs(f - this.c) <= 1.0E-6f) {
            this.c = f2;
            return;
        }
        if (this.d && Math.abs(f - 0.0f) <= 1.0E-6f) {
            this.c = f2;
            this.d = false;
        } else {
            g();
            this.a = false;
            this.b = f;
            this.c = f2;
        }
    }
}
