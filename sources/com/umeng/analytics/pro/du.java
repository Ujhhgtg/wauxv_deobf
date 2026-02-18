package com.umeng.analytics.pro;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class du {
    public abstract int a(byte[] bArr, int i, int i2);

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b();

    public void b(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2);

    public abstract void c();

    public void d() {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }

    public int d(byte[] bArr, int i, int i2) throws dv {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new dv("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += iA;
        }
        return i3;
    }
}
