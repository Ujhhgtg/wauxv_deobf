package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bwv extends erk {
    public static final bei a = new bei(1);
    public final dlo b = new dlo(0);

    @Override // me.hd.wauxv.obf.erk
    public final void h() {
        dlo dloVar = this.b;
        if (dloVar.i() > 0) {
            dloVar.j(0).getClass();
            throw new ClassCastException();
        }
        int i = dloVar.d;
        Object[] objArr = dloVar.c;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        dloVar.d = 0;
        dloVar.a = false;
    }
}
