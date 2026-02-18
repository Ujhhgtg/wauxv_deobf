package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dci implements btj {
    public static final byi a = new byi(50);
    public final bva b;
    public final btj c;
    public final btj e;
    public final int f;
    public final int g;
    public final Class h;
    public final crw i;
    public final elc j;

    public dci(bva bvaVar, btj btjVar, btj btjVar2, int i, int i2, elc elcVar, Class cls, crw crwVar) {
        this.b = bvaVar;
        this.c = btjVar;
        this.e = btjVar2;
        this.f = i;
        this.g = i2;
        this.j = elcVar;
        this.h = cls;
        this.i = crwVar;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        Object objK;
        bva bvaVar = this.b;
        synchronized (bvaVar) {
            byf byfVar = (byf) bvaVar.d;
            cut cutVarB = (cut) ((ArrayDeque) byfVar.g).poll();
            if (cutVarB == null) {
                cutVarB = byfVar.b();
            }
            bye byeVar = (bye) cutVarB;
            byeVar.b = 8;
            byeVar.c = byte[].class;
            objK = bvaVar.k(byeVar, byte[].class);
        }
        byte[] bArr = (byte[]) objK;
        ByteBuffer.wrap(bArr).putInt(this.f).putInt(this.g).array();
        this.e.d(messageDigest);
        this.c.d(messageDigest);
        messageDigest.update(bArr);
        elc elcVar = this.j;
        if (elcVar != null) {
            elcVar.d(messageDigest);
        }
        this.i.d(messageDigest);
        byi byiVar = a;
        Class cls = this.h;
        byte[] bytes = (byte[]) byiVar.d(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(btj.k);
            byiVar.g(cls, bytes);
        }
        messageDigest.update(bytes);
        this.b.m(bArr);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof dci) {
            dci dciVar = (dci) obj;
            if (this.g == dciVar.g && this.f == dciVar.f && eot.e(this.j, dciVar.j) && this.h.equals(dciVar.h) && this.c.equals(dciVar.c) && this.e.equals(dciVar.e) && this.i.equals(dciVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        int iHashCode = ((((this.e.hashCode() + (this.c.hashCode() * 31)) * 31) + this.f) * 31) + this.g;
        elc elcVar = this.j;
        if (elcVar != null) {
            iHashCode = (iHashCode * 31) + elcVar.hashCode();
        }
        return this.i.a.hashCode() + bjs.d(iHashCode * 31, 31, this.h);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.e + ", width=" + this.f + ", height=" + this.g + ", decodedResourceClass=" + this.h + ", transformation='" + this.j + "', options=" + this.i + '}';
    }
}
