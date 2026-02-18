package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstType;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AttEnclosingMethod extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "EnclosingMethod";
    private final CstNat method;
    private final CstType type;

    public AttEnclosingMethod(CstType cstType, CstNat cstNat) {
        super(ATTRIBUTE_NAME);
        if (cstType == null) {
            throw new NullPointerException("type == null");
        }
        this.type = cstType;
        this.method = cstNat;
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 10;
    }

    public CstType getEnclosingClass() {
        return this.type;
    }

    public CstNat getMethod() {
        return this.method;
    }
}
