package bsh.org.objectweb.asm;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MethodVisitor {
    private static final String REQUIRES_ASM5 = "This feature requires ASM5";
    protected final int api;
    protected MethodVisitor mv;

    public MethodVisitor(int i) {
        this(i, null);
    }

    public void visitAnnotableParameterCount(int i, boolean z) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitAnnotableParameterCount(i, z);
        }
    }

    public void visitAttribute(Attribute attribute) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitAttribute(attribute);
        }
    }

    public void visitCode() {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitCode();
        }
    }

    public void visitEnd() {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitEnd();
        }
    }

    public void visitFieldInsn(int i, String str, String str2, String str3) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitFieldInsn(i, str, str2, str3);
        }
    }

    public void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitFrame(i, i2, objArr, i3, objArr2);
        }
    }

    public void visitIincInsn(int i, int i2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitIincInsn(i, i2);
        }
    }

    public void visitInsn(int i) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitInsn(i);
        }
    }

    public void visitIntInsn(int i, int i2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitIntInsn(i, i2);
        }
    }

    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitInvokeDynamicInsn(str, str2, handle, objArr);
        }
    }

    public void visitJumpInsn(int i, Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitJumpInsn(i, label);
        }
    }

    public void visitLabel(Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLabel(label);
        }
    }

    public void visitLdcInsn(Object obj) {
        if (this.api < 327680 && ((obj instanceof Handle) || ((obj instanceof Type) && ((Type) obj).getSort() == 11))) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLdcInsn(obj);
        }
    }

    public void visitLineNumber(int i, Label label) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLineNumber(i, label);
        }
    }

    public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLocalVariable(str, str2, str3, label, label2, i);
        }
    }

    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitLookupSwitchInsn(label, iArr, labelArr);
        }
    }

    public void visitMaxs(int i, int i2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMaxs(i, i2);
        }
    }

    @Deprecated
    public void visitMethodInsn(int i, String str, String str2, String str3) {
        if (this.api >= 327680) {
            visitMethodInsn(i, str, str2, str3, i == 185);
            return;
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(i, str, str2, str3);
        }
    }

    public void visitMultiANewArrayInsn(String str, int i) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMultiANewArrayInsn(str, i);
        }
    }

    public void visitParameter(String str, int i) {
        if (this.api < 327680) {
            throw new UnsupportedOperationException(REQUIRES_ASM5);
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitParameter(str, i);
        }
    }

    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTableSwitchInsn(i, i2, label, labelArr);
        }
    }

    public void visitTryCatchBlock(Label label, Label label2, Label label3, String str) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTryCatchBlock(label, label2, label3, str);
        }
    }

    public void visitTypeInsn(int i, String str) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitTypeInsn(i, str);
        }
    }

    public void visitVarInsn(int i, int i2) {
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitVarInsn(i, i2);
        }
    }

    public MethodVisitor(int i, MethodVisitor methodVisitor) {
        if (i != 393216 && i != 327680 && i != 262144) {
            throw new IllegalArgumentException();
        }
        this.api = i;
        this.mv = methodVisitor;
    }

    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        if (this.api < 327680) {
            if (z == (i == 185)) {
                visitMethodInsn(i, str, str2, str3);
                return;
            }
            throw new IllegalArgumentException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(i, str, str2, str3, z);
        }
    }
}
