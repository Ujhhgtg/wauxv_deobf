package com.android.dx.rop.cst;

import com.android.dx.rop.type.TypeBearer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypedConstant extends Constant implements TypeBearer {
    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicFrameType() {
        return getType().getBasicFrameType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final int getBasicType() {
        return getType().getBasicType();
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final TypeBearer getFrameType() {
        return this;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public final boolean isConstant() {
        return true;
    }
}
