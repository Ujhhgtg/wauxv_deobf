package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bry {
    public static final bpj a = bmy.j("kotlinx.serialization.json.JsonUnquotedLiteral", dnh.b);

    public static final bsp b(brx brxVar) {
        bsp bspVar = brxVar instanceof bsp ? (bsp) brxVar : null;
        if (bspVar != null) {
            return bspVar;
        }
        throw new IllegalArgumentException("Element " + dal.b(brxVar.getClass()) + " is not a JsonPrimitive");
    }
}
