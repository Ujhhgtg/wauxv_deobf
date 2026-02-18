package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.TypedConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AttConstantValue extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "ConstantValue";
    private final TypedConstant constantValue;

    public AttConstantValue(TypedConstant typedConstant) {
        super(ATTRIBUTE_NAME);
        if ((typedConstant instanceof CstString) || (typedConstant instanceof CstInteger) || (typedConstant instanceof CstLong) || (typedConstant instanceof CstFloat) || (typedConstant instanceof CstDouble)) {
            this.constantValue = typedConstant;
        } else {
            if (typedConstant != null) {
                throw new IllegalArgumentException("bad type for constantValue");
            }
            throw new NullPointerException("constantValue == null");
        }
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 8;
    }

    public TypedConstant getConstantValue() {
        return this.constantValue;
    }
}
