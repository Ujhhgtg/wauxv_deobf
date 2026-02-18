package com.android.dx.cf.attrib;

import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.util.ByteArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RawAttribute extends BaseAttribute {
    private final ByteArray data;
    private final ConstantPool pool;

    public RawAttribute(String str, ByteArray byteArray, ConstantPool constantPool) {
        super(str);
        if (byteArray == null) {
            throw new NullPointerException("data == null");
        }
        this.data = byteArray;
        this.pool = constantPool;
    }

    @Override // com.android.dx.cf.iface.Attribute
    public int byteLength() {
        return this.data.size() + 6;
    }

    public ByteArray getData() {
        return this.data;
    }

    public ConstantPool getPool() {
        return this.pool;
    }

    public RawAttribute(String str, ByteArray byteArray, int i, int i2, ConstantPool constantPool) {
        this(str, byteArray.slice(i, i2 + i), constantPool);
    }
}
