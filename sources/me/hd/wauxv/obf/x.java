package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class x {
    public final int a;
    public final Object[] b;
    public final w c;
    public int d = 0;
    public int e = 0;

    public x(int i, w wVar) {
        this.a = i;
        this.b = new Object[i];
        this.c = wVar;
    }

    public final synchronized void f(Object obj) {
        Object[] objArr = this.b;
        int i = this.d;
        int i2 = i + 1;
        this.d = i2;
        objArr[i] = obj;
        if (i2 == this.a) {
            this.c.a(objArr, this.e);
        }
    }
}
