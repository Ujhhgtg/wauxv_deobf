package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class CstInsn extends Insn {
    private final Constant cst;

    public CstInsn(Rop rop, SourcePosition sourcePosition, RegisterSpec registerSpec, RegisterSpecList registerSpecList, Constant constant) {
        super(rop, sourcePosition, registerSpec, registerSpecList);
        if (constant == null) {
            throw new NullPointerException("cst == null");
        }
        this.cst = constant;
    }

    @Override // com.android.dx.rop.code.Insn
    public boolean contentEquals(Insn insn) {
        return super.contentEquals(insn) && this.cst.equals(((CstInsn) insn).getConstant());
    }

    public Constant getConstant() {
        return this.cst;
    }

    @Override // com.android.dx.rop.code.Insn
    public String getInlineString() {
        return this.cst.toHuman();
    }
}
