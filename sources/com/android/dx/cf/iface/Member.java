package com.android.dx.cf.iface;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Member extends HasAttribute {
    int getAccessFlags();

    @Override // com.android.dx.cf.iface.HasAttribute
    AttributeList getAttributes();

    CstType getDefiningClass();

    CstString getDescriptor();

    CstString getName();

    CstNat getNat();
}
