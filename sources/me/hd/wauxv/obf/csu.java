package me.hd.wauxv.obf;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class csu extends bgr implements IInvokable {
    public static final csu a = new csu(1, emn.class, "typeToString",
            "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Type type = (Type) obj;
        throwIfVar1IsNull(type, "p0");
        return emn.ad(type);
    }
}
