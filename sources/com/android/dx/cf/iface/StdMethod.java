package com.android.dx.cf.iface;

import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Prototype;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class StdMethod extends StdMember implements Method {
    private final Prototype effectiveDescriptor;

    public StdMethod(CstType cstType, int i, CstNat cstNat, AttributeList attributeList) {
        super(cstType, i, cstNat, attributeList);
        this.effectiveDescriptor = Prototype.intern(getDescriptor().getString(), cstType.getClassType(), AccessFlags.isStatic(i), cstNat.isInstanceInit());
    }

    @Override // com.android.dx.cf.iface.Method
    public Prototype getEffectiveDescriptor() {
        return this.effectiveDescriptor;
    }
}
