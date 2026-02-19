package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfj {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public dfj f;
    public dfj g;

    public dfj() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final dfj h() {
        dfj dfjVar = this.f;
        if (dfjVar == this) {
            dfjVar = null;
        }
        dfj dfjVar2 = this.g;
        throwIfVar1IsNull(dfjVar2);
        dfjVar2.f = this.f;
        dfj dfjVar3 = this.f;
        throwIfVar1IsNull(dfjVar3);
        dfjVar3.g = this.g;
        this.f = null;
        this.g = null;
        return dfjVar;
    }

    public final void i(dfj dfjVar) {
        throwIfVar1IsNull(dfjVar, "segment");
        dfjVar.g = this;
        dfjVar.f = this.f;
        dfj dfjVar2 = this.f;
        throwIfVar1IsNull(dfjVar2);
        dfjVar2.g = dfjVar;
        this.f = dfjVar;
    }

    public final dfj j() {
        this.d = true;
        return new dfj(this.a, this.b, this.c, true, false);
    }

    public final void k(dfj dfjVar, int i) {
        throwIfVar1IsNull(dfjVar, "sink");
        byte[] bArr = dfjVar.a;
        if (!dfjVar.e) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = dfjVar.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (dfjVar.d) {
                throw new IllegalArgumentException();
            }
            int i4 = dfjVar.b;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            SomeStaticHelpers._an(bArr, i4, i2, bArr, 2);
            dfjVar.c -= dfjVar.b;
            dfjVar.b = 0;
        }
        int i5 = dfjVar.c;
        int i6 = this.b;
        SomeStaticHelpers._ak(this.a, i5, i6, bArr, i6 + i);
        dfjVar.c += i;
        this.b += i;
    }

    public dfj(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        throwIfVar1IsNull(bArr, "data");
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }
}
