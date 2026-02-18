package net.bytebuddy.utility.visitor;

import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.OpenedClassReader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class LocalVariableAwareMethodVisitor extends MethodVisitor {
    private int freeOffset;

    public LocalVariableAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.freeOffset = methodDescription.getStackSize();
    }

    public int getFreeOffset() {
        return this.freeOffset;
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitVarInsn(int i, int i2) {
        switch (i) {
            case 54:
            case 56:
            case 58:
                this.freeOffset = Math.max(this.freeOffset, i2 + 1);
                break;
            case 55:
            case 57:
                this.freeOffset = Math.max(this.freeOffset, i2 + 2);
                break;
        }
        super.visitVarInsn(i, i2);
    }
}
