package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ddw implements cwg {
    @Override // java.lang.annotation.Annotation
    public final /* synthetic */ Class annotationType() {
        return cwg.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        return (obj instanceof cwg) && 1 == ((cwg) obj).number();
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return ("number" /* cnb.z(-364187456895786L) */.hashCode() * 127) ^ Integer.hashCode(1);
    }

    @Override // me.hd.wauxv.obf.cwg
    public final /* synthetic */ int number() {
        return 1;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@kotlinx.serialization.protobuf.ProtoNumber(number=" /* cnb.z(-364208931732266L) */.concat("1)");
    }
}
