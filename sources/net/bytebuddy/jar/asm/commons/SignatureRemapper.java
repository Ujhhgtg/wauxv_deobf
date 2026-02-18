package net.bytebuddy.jar.asm.commons;

import java.util.ArrayList;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class SignatureRemapper extends SignatureVisitor {
    private ArrayList<String> classNames;
    private final Remapper remapper;
    private final SignatureVisitor signatureVisitor;

    public SignatureRemapper(SignatureVisitor signatureVisitor, Remapper remapper) {
        this(Opcodes.ASM9, signatureVisitor, remapper);
    }

    private static /* synthetic */ String stringConcat$0(String str, String str2) {
        return str + "$" + str2;
    }

    private static /* synthetic */ String stringConcat$1(String str) {
        return dkz.s(str, "$");
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitArrayType() {
        this.signatureVisitor.visitArrayType();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitBaseType(char c) {
        this.signatureVisitor.visitBaseType(c);
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitClassBound() {
        this.signatureVisitor.visitClassBound();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitClassType(String str) {
        this.classNames.add(str);
        this.signatureVisitor.visitClassType(this.remapper.mapType(str));
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitEnd() {
        this.signatureVisitor.visitEnd();
        this.classNames.remove(r0.size() - 1);
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitExceptionType() {
        this.signatureVisitor.visitExceptionType();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitFormalTypeParameter(String str) {
        this.signatureVisitor.visitFormalTypeParameter(str);
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitInnerClassType(String str) {
        String strRemove = this.classNames.remove(r0.size() - 1);
        String strStringConcat$0 = stringConcat$0(strRemove, str);
        this.classNames.add(strStringConcat$0);
        String strStringConcat$1 = stringConcat$1(this.remapper.mapType(strRemove));
        String strMapType = this.remapper.mapType(strStringConcat$0);
        this.signatureVisitor.visitInnerClassType(strMapType.substring(strMapType.startsWith(strStringConcat$1) ? strStringConcat$1.length() : strMapType.lastIndexOf(36) + 1));
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterface() {
        this.signatureVisitor.visitInterface();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitInterfaceBound() {
        this.signatureVisitor.visitInterfaceBound();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitParameterType() {
        this.signatureVisitor.visitParameterType();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitReturnType() {
        this.signatureVisitor.visitReturnType();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitSuperclass() {
        this.signatureVisitor.visitSuperclass();
        return this;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitTypeArgument() {
        this.signatureVisitor.visitTypeArgument();
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public void visitTypeVariable(String str) {
        this.signatureVisitor.visitTypeVariable(str);
    }

    public SignatureRemapper(int i, SignatureVisitor signatureVisitor, Remapper remapper) {
        super(i);
        this.classNames = new ArrayList<>();
        this.signatureVisitor = signatureVisitor;
        this.remapper = remapper;
    }

    @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
    public SignatureVisitor visitTypeArgument(char c) {
        this.signatureVisitor.visitTypeArgument(c);
        return this;
    }
}
