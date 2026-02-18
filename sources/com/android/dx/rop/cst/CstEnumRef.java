package com.android.dx.rop.cst;

import com.android.dx.rop.type.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CstEnumRef extends CstMemberRef {
    private CstFieldRef fieldRef;

    public CstEnumRef(CstNat cstNat) {
        super(new CstType(cstNat.getFieldType()), cstNat);
        this.fieldRef = null;
    }

    public CstFieldRef getFieldRef() {
        if (this.fieldRef == null) {
            this.fieldRef = new CstFieldRef(getDefiningClass(), getNat());
        }
        return this.fieldRef;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return getDefiningClass().getClassType();
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return "enum";
    }
}
