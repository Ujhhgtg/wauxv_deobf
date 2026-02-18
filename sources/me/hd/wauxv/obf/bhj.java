package me.hd.wauxv.obf;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhj {
    public ByteBuffer b;
    public bhi c;
    public final byte[] a = new byte[256];
    public int d = 0;

    public final boolean e() {
        return this.c.b != 0;
    }

    public final bhi f() {
        byte[] bArr;
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (e()) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) g());
        }
        if (sb.toString().startsWith("GIF")) {
            this.c.f = this.b.getShort();
            this.c.g = this.b.getShort();
            int iG = g();
            bhi bhiVar = this.c;
            bhiVar.h = (iG & 128) != 0;
            bhiVar.i = (int) Math.pow(2.0d, (iG & 7) + 1);
            this.c.j = g();
            bhi bhiVar2 = this.c;
            g();
            bhiVar2.getClass();
            if (this.c.h && !e()) {
                bhi bhiVar3 = this.c;
                bhiVar3.a = i(bhiVar3.i);
                bhi bhiVar4 = this.c;
                bhiVar4.k = bhiVar4.a[bhiVar4.j];
            }
        } else {
            this.c.b = 1;
        }
        if (!e()) {
            boolean z = false;
            while (!z && !e() && this.c.c <= Integer.MAX_VALUE) {
                int iG2 = g();
                if (iG2 == 33) {
                    int iG3 = g();
                    if (iG3 == 1) {
                        j();
                    } else if (iG3 == 249) {
                        this.c.d = new bhd();
                        g();
                        int iG4 = g();
                        bhd bhdVar = this.c.d;
                        int i2 = (iG4 & 28) >> 2;
                        bhdVar.g = i2;
                        if (i2 == 0) {
                            bhdVar.g = 1;
                        }
                        bhdVar.f = (iG4 & 1) != 0;
                        short s = this.b.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        bhd bhdVar2 = this.c.d;
                        bhdVar2.i = s * 10;
                        bhdVar2.h = g();
                        g();
                    } else if (iG3 == 254) {
                        j();
                    } else if (iG3 != 255) {
                        j();
                    } else {
                        h();
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        while (true) {
                            bArr = this.a;
                            if (i3 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i3]);
                            i3++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                h();
                                if (bArr[0] == 1) {
                                    byte b = bArr[1];
                                    byte b2 = bArr[2];
                                    this.c.getClass();
                                }
                                if (this.d <= 0) {
                                    break;
                                }
                            } while (!e());
                        } else {
                            j();
                        }
                    }
                } else if (iG2 == 44) {
                    bhi bhiVar5 = this.c;
                    if (bhiVar5.d == null) {
                        bhiVar5.d = new bhd();
                    }
                    bhiVar5.d.a = this.b.getShort();
                    this.c.d.b = this.b.getShort();
                    this.c.d.c = this.b.getShort();
                    this.c.d.d = this.b.getShort();
                    int iG5 = g();
                    boolean z2 = (iG5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iG5 & 7) + 1);
                    bhd bhdVar3 = this.c.d;
                    bhdVar3.e = (iG5 & 64) != 0;
                    if (z2) {
                        bhdVar3.k = i(iPow);
                    } else {
                        bhdVar3.k = null;
                    }
                    this.c.d.j = this.b.position();
                    g();
                    j();
                    if (!e()) {
                        bhi bhiVar6 = this.c;
                        bhiVar6.c++;
                        bhiVar6.e.add(bhiVar6.d);
                    }
                } else if (iG2 != 59) {
                    this.c.b = 1;
                } else {
                    z = true;
                }
            }
            bhi bhiVar7 = this.c;
            if (bhiVar7.c < 0) {
                bhiVar7.b = 1;
            }
        }
        return this.c;
    }

    public final int g() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void h() {
        int iG = g();
        this.d = iG;
        if (iG <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                int i3 = this.d;
                if (i >= i3) {
                    return;
                }
                i2 = i3 - i;
                this.b.get(this.a, i, i2);
                i += i2;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbQ = yg.q(i, i2, "Error Reading Block n: ", " count: ", " blockSize: ");
                    sbQ.append(this.d);
                    Log.d("GifHeaderParser", sbQ.toString(), e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    public final int[] i(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | (-16777216) | (bArr[i5] & 255);
                i2 = i7;
            }
            return iArr;
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
            return iArr;
        }
    }

    public final void j() {
        int iG;
        do {
            iG = g();
            this.b.position(Math.min(this.b.position() + iG, this.b.limit()));
        } while (iG > 0);
    }
}
