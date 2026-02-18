package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class emm extends bgr implements bgf {
    public static final emm a = new emm(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls = (Class) obj;
        bzo.q(cls, "p0");
        return cls.getComponentType();
    }
}
