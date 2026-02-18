package me.hd.wauxv.obf;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bid implements btj {
    public final bkk a;
    public final URL b;
    public final String c;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public bid(URL url) {
        btw btwVar = bkk.a;
        cmz.n(url, "Argument must not be null");
        this.b = url;
        this.c = null;
        cmz.n(btwVar, "Argument must not be null");
        this.a = btwVar;
    }

    @Override // me.hd.wauxv.obf.btj
    public final void d(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = i().getBytes(btj.k);
        }
        messageDigest.update(this.g);
    }

    @Override // me.hd.wauxv.obf.btj
    public final boolean equals(Object obj) {
        if (obj instanceof bid) {
            bid bidVar = (bid) obj;
            if (i().equals(bidVar.i()) && this.a.equals(bidVar.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.btj
    public final int hashCode() {
        if (this.h == 0) {
            int iHashCode = i().hashCode();
            this.h = iHashCode;
            this.h = this.a.hashCode() + (iHashCode * 31);
        }
        return this.h;
    }

    public final String i() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        URL url = this.b;
        cmz.n(url, "Argument must not be null");
        return url.toString();
    }

    public final URL j() {
        if (this.f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String string = this.c;
                if (TextUtils.isEmpty(string)) {
                    URL url = this.b;
                    cmz.n(url, "Argument must not be null");
                    string = url.toString();
                }
                this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$[]");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    public final String toString() {
        return i();
    }

    public bid(String str) {
        btw btwVar = bkk.a;
        this.b = null;
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            cmz.n(btwVar, "Argument must not be null");
            this.a = btwVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
