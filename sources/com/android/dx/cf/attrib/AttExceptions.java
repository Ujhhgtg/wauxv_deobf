package com.android.dx.cf.attrib;

import com.android.dx.rop.type.TypeList;
import com.android.dx.util.MutabilityException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AttExceptions extends BaseAttribute {
    public static final String ATTRIBUTE_NAME = "Exceptions";
    private final TypeList exceptions;

    public AttExceptions(TypeList typeList) {
        super(ATTRIBUTE_NAME);
        try {
            if (typeList.isMutable()) {
                throw new MutabilityException("exceptions.isMutable()");
            }
            this.exceptions = typeList;
        } catch (NullPointerException unused) {
            throw new NullPointerException("exceptions == null");
        }
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return (this.exceptions.size() * 2) + 8;
    }

    public TypeList getExceptions() {
        return this.exceptions;
    }
}
