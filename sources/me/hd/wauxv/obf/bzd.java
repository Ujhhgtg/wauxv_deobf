package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzd extends bzf implements Iterator, IEmpty {
    public final /* synthetic */ int a;

    public bzd(bzg bzgVar, int i) {
        this.a = i;
        throwIfVar1IsNull(bzgVar, "map");
        this.e = bzgVar;
        this.c = -1;
        this.d = bzgVar.i;
        j();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.a) {
            case 0:
                g();
                int i = this.b;
                bzg bzgVar = (bzg) this.e;
                if (i >= bzgVar.g) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                this.c = i;
                bze bzeVar = new bze(bzgVar, i);
                j();
                return bzeVar;
            case 1:
                g();
                int i2 = this.b;
                bzg bzgVar2 = (bzg) this.e;
                if (i2 >= bzgVar2.g) {
                    throw new NoSuchElementException();
                }
                this.b = i2 + 1;
                this.c = i2;
                Object obj = bzgVar2.b[i2];
                j();
                return obj;
            default:
                g();
                int i3 = this.b;
                bzg bzgVar3 = (bzg) this.e;
                if (i3 >= bzgVar3.g) {
                    throw new NoSuchElementException();
                }
                this.b = i3 + 1;
                this.c = i3;
                Object[] objArr = bzgVar3.c;
                throwIfVar1IsNull(objArr);
                Object obj2 = objArr[this.c];
                j();
                return obj2;
        }
    }
}
