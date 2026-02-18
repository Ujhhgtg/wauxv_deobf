package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CstFloat extends CstLiteral32 {
    public static final CstFloat VALUE_0 = make(Float.floatToIntBits(0.0f));
    public static final CstFloat VALUE_1 = make(Float.floatToIntBits(1.0f));
    public static final CstFloat VALUE_2 = make(Float.floatToIntBits(2.0f));

    private CstFloat(int i) {
        super(i);
    }

    public static CstFloat make(int i) {
        return new CstFloat(i);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.FLOAT;
    }

    public float getValue() {
        return Float.intBitsToFloat(getIntBits());
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Float.toString(Float.intBitsToFloat(getIntBits()));
    }

    public String toString() {
        int intBits = getIntBits();
        return "float{0x" + Hex.u4(intBits) + " / " + Float.intBitsToFloat(intBits) + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "float";
    }
}
