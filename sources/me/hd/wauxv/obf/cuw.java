package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cuw implements cuv {
    public final Object[] a;
    public int b;

    public cuw(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[i];
    }

    @Override // me.hd.wauxv.obf.cuv
    public Object acquire() {
        int i = this.b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.a;
        Object obj = objArr[i2];
        bzo.o(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i2] = null;
        this.b--;
        return obj;
    }

    public void c(kw kwVar) {
        int i = this.b;
        Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = kwVar;
            this.b = i + 1;
        }
    }

    @Override // me.hd.wauxv.obf.cuv
    public boolean l(Object obj) {
        Object[] objArr;
        boolean z;
        bzo.q(obj, "instance");
        int i = this.b;
        int i2 = 0;
        while (true) {
            objArr = this.a;
            if (i2 >= i) {
                z = false;
                break;
            }
            if (objArr[i2] == obj) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.b;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.b = i3 + 1;
        return true;
    }

    public cuw() {
        this.a = new Object[256];
    }
}
