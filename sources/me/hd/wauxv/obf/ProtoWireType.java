package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtoWireType {
    public static final cbm a;
    public static final ProtoWireType[] b;
    public static final ProtoWireType ENUM_INVALID;
    public static final ProtoWireType ENUM_VARINT;
    public static final ProtoWireType ENUM_FIXED64;
    public static final ProtoWireType ENUM_LENGTH_DELIMITED;
    public static final ProtoWireType ENUM_FIXED32;
    public static final /* synthetic */ ProtoWireType[] h;
    public static final /* synthetic */ awn i;
    public final int value;

    static {
        Object next;
        ProtoWireType protoWireTypeVar = new ProtoWireType("INVALID", 0, -1);
        ENUM_INVALID = protoWireTypeVar;
        ProtoWireType protoWireTypeVar2 = new ProtoWireType("VARINT", 1, 0);
        ENUM_VARINT = protoWireTypeVar2;
        ProtoWireType protoWireTypeVar3 = new ProtoWireType("i64", 2, 1);
        ENUM_FIXED64 = protoWireTypeVar3;
        ProtoWireType protoWireTypeVar4 = new ProtoWireType("SIZE_DELIMITED", 3, 2);
        ENUM_LENGTH_DELIMITED = protoWireTypeVar4;
        ProtoWireType protoWireTypeVar5 = new ProtoWireType("i32", 4, 5);
        ENUM_FIXED32 = protoWireTypeVar5;
        ProtoWireType[] protoWireTypeVarArr = {protoWireTypeVar, protoWireTypeVar2, protoWireTypeVar3, protoWireTypeVar4, protoWireTypeVar5};
        h = protoWireTypeVarArr;
        i = new awn(protoWireTypeVarArr);
        a = new cbm(15);
        ProtoWireType[] protoWireTypeVarArr2 = new ProtoWireType[8];
        for (int i2 = 0; i2 < 8; i2++) {
            awn awnVar = i;
            awnVar.getClass();
            z zVar = new z(awnVar, 0);
            do {
                if (!zVar.hasNext()) {
                    next = null;
                    break;
                }
                next = zVar.next();
            } while (((ProtoWireType) next).value != i2);
            ProtoWireType protoWireTypeVar6 = (ProtoWireType) next;
            if (protoWireTypeVar6 == null) {
                protoWireTypeVar6 = ENUM_INVALID;
            }
            protoWireTypeVarArr2[i2] = protoWireTypeVar6;
        }
        b = protoWireTypeVarArr2;
    }

    public ProtoWireType(String str, int i2, int i3) {
        this.value = i3;
    }

    public static ProtoWireType valueOf(String str) {
        return (ProtoWireType) Enum.valueOf(ProtoWireType.class, str);
    }

    public static ProtoWireType[] values() {
        return (ProtoWireType[]) h.clone();
    }

    public final int makeTag(int i2) {
        return (i2 << 3) | this.value;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append('(');
        return dkz.v(sb, this.value, ')');
    }
}
