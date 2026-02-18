package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum ShiftLeft implements StackManipulation {
    INTEGER(120, StackSize.SINGLE),
    LONG(121, StackSize.DOUBLE);

    private final int opcode;
    private final StackSize stackSize;

    ShiftLeft(int i, StackSize stackSize) {
        this.opcode = i;
        this.stackSize = stackSize;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.stackSize.toDecreasingSize();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }
}
