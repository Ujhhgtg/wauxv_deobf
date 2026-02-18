package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayt {
    public static final ayp Companion = new ayp();
    public final ayo a;
    public final ays b;

    public /* synthetic */ ayt(int i, ayo ayoVar, ays aysVar) {
        if (3 != (i & 3)) {
            bht.ah(i, 3, ayl.b.getDescriptor());
            throw null;
        }
        this.a = ayoVar;
        this.b = aysVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ayt)) {
            return false;
        }
        ayt aytVar = (ayt) obj;
        return bzo.f(this.a, aytVar.a) && bzo.f(this.b, aytVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.a.hashCode() * 31);
    }

    public final String toString() {
        return "FavInfoProto(chatInfo=" /* cnb.z(-130777459194666L) */ + this.a + ", voiceInfo=" /* cnb.z(-130678674946858L) */ + this.b + ')';
    }
}
