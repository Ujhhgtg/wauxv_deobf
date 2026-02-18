package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CstLong extends CstLiteral64 {
    public static final CstLong VALUE_0 = make(0);
    public static final CstLong VALUE_1 = make(1);

    private CstLong(long j) {
        super(j);
    }

    public static CstLong make(long j) {
        return new CstLong(j);
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.LONG;
    }

    public long getValue() {
        return getLongBits();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Long.toString(getLongBits());
    }

    public String toString() {
        long longBits = getLongBits();
        return "long{0x" + Hex.u8(longBits) + " / " + longBits + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "long";
    }
}
