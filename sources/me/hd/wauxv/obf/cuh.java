package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cuh {
    public final String a;
    public final String b;
    public final String c;

    public cuh(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cuh)) {
            return false;
        }
        cuh cuhVar = (cuh) obj;
        return bzo.f(this.a, cuhVar.a) && bzo.f(this.b, cuhVar.b) && bzo.f(this.c, cuhVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + bjs.e(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        String strAg = cnh.ag(System.currentTimeMillis(), null, null, 3);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(strAg);
        sb2.append(cnb.z(-389837001587498L));
        yg.u(sb2, this.a, -389841296554794L);
        sb2.append(this.b);
        sb2.append(']');
        sb.append(sb2.toString());
        sb.append(cnb.z(-389794051914538L));
        sb.append(this.c);
        return sb.toString();
    }
}
