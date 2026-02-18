package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.CstString;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AttSignature extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Signature";
    private final CstString signature;

    public AttSignature(CstString cstString) {
        super(ATTRIBUTE_NAME);
        if (cstString == null) {
            throw new NullPointerException("signature == null");
        }
        this.signature = cstString;
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return 8;
    }

    public CstString getSignature() {
        return this.signature;
    }
}
