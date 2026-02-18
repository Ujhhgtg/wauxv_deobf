package com.android.dx.dex.code;

import com.android.dx.rop.code.RegisterSpecList;
import com.android.dx.rop.code.SourcePosition;
import com.android.dx.util.AnnotatedOutput;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FixedSizeInsn extends DalvInsn {
    public FixedSizeInsn(Dop dop, SourcePosition sourcePosition, RegisterSpecList registerSpecList) {
        super(dop, sourcePosition, registerSpecList);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public final int codeSize() {
        return getOpcode().getFormat().codeSize();
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public final String listingString0(boolean z) {
        return getOpcode().getFormat().listingString(this, z);
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public final DalvInsn withRegisterOffset(int i) {
        return withRegisters(getRegisters().withOffset(i));
    }

    @Override // com.android.dx.dex.code.DalvInsn
    public final void writeTo(AnnotatedOutput annotatedOutput) {
        getOpcode().getFormat().writeTo(annotatedOutput, this);
    }
}
