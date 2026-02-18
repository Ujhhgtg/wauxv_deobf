package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CstInteger extends CstLiteral32 {
    private static final CstInteger[] cache = new CstInteger[511];
    public static final CstInteger VALUE_M1 = make(-1);
    public static final CstInteger VALUE_0 = make(0);
    public static final CstInteger VALUE_1 = make(1);
    public static final CstInteger VALUE_2 = make(2);
    public static final CstInteger VALUE_3 = make(3);
    public static final CstInteger VALUE_4 = make(4);
    public static final CstInteger VALUE_5 = make(5);

    private CstInteger(int i) {
        super(i);
    }

    public static CstInteger make(int i) {
        CstInteger[] cstIntegerArr = cache;
        int length = (Integer.MAX_VALUE & i) % cstIntegerArr.length;
        CstInteger cstInteger = cstIntegerArr[length];
        if (cstInteger != null && cstInteger.getValue() == i) {
            return cstInteger;
        }
        CstInteger cstInteger2 = new CstInteger(i);
        cstIntegerArr[length] = cstInteger2;
        return cstInteger2;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.INT;
    }

    public int getValue() {
        return getIntBits();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        int intBits = getIntBits();
        return "int{0x" + Hex.u4(intBits) + " / " + intBits + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "int";
    }
}
