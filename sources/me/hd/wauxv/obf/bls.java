package me.hd.wauxv.obf;

import android.content.res.XmlResourceParser;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bls implements Serializable {
    public final String a;
    public final XmlResourceParser b;
    public final Class c;

    public bls(String str, XmlResourceParser xmlResourceParser, Class cls) {
        this.a = str;
        this.b = xmlResourceParser;
        this.c = cls;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bls)) {
            return false;
        }
        bls blsVar = (bls) obj;
        return bzo.f(this.a, blsVar.a) && this.b.equals(blsVar.b) && this.c.equals(blsVar.c);
    }

    public final int hashCode() {
        String str = this.a;
        return this.c.hashCode() + ((this.b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31);
    }

    public final String toString() {
        return "PerformerParams(id=" + this.a + ", attrs=" + this.b + ", viewClass=" + this.c + ")";
    }
}
