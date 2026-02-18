package net.bytebuddy.utility.visitor;

import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MetadataAwareClassVisitor extends ClassVisitor {
    private boolean triggerAttributes;
    private boolean triggerModule;
    private boolean triggerNestHost;
    private boolean triggerOuterClass;
    private boolean triggerSource;

    public MetadataAwareClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
        this.triggerSource = true;
        this.triggerModule = true;
        this.triggerNestHost = true;
        this.triggerOuterClass = true;
        this.triggerAttributes = true;
    }

    private void considerTriggerAfterAttributes() {
        if (this.triggerAttributes) {
            this.triggerAttributes = false;
            onAfterAttributes();
        }
    }

    private void considerTriggerModule() {
        if (this.triggerModule) {
            this.triggerModule = false;
            onModule();
        }
    }

    private void considerTriggerNestHost() {
        if (this.triggerNestHost) {
            this.triggerNestHost = false;
            onNestHost();
        }
    }

    private void considerTriggerOuterClass() {
        if (this.triggerOuterClass) {
            this.triggerOuterClass = false;
            onOuterType();
        }
    }

    private void considerTriggerSource() {
        if (this.triggerSource) {
            this.triggerSource = false;
            onSource();
        }
    }

    public void onAfterAttributes() {
    }

    public void onModule() {
    }

    public void onNestHost() {
    }

    public void onOuterType() {
    }

    public void onSource() {
    }

    @MaybeNull
    public AnnotationVisitor onVisitAnnotation(String str, boolean z) {
        return super.visitAnnotation(str, z);
    }

    public void onVisitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
    }

    public void onVisitEnd() {
        super.visitEnd();
    }

    @MaybeNull
    public FieldVisitor onVisitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
        return super.visitField(i, str, str2, str3, obj);
    }

    public void onVisitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i) {
        super.visitInnerClass(str, str2, str3, i);
    }

    @MaybeNull
    public MethodVisitor onVisitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
        return super.visitMethod(i, str, str2, str3, strArr);
    }

    @MaybeNull
    public ModuleVisitor onVisitModule(String str, int i, @MaybeNull String str2) {
        return super.visitModule(str, i, str2);
    }

    public void onVisitNestHost(String str) {
        super.visitNestHost(str);
    }

    public void onVisitNestMember(String str) {
        super.visitNestMember(str);
    }

    public void onVisitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
        super.visitOuterClass(str, str2, str3);
    }

    public void onVisitPermittedSubclass(String str) {
        super.visitPermittedSubclass(str);
    }

    @MaybeNull
    public RecordComponentVisitor onVisitRecordComponent(String str, String str2, @MaybeNull String str3) {
        return super.visitRecordComponent(str, str2, str3);
    }

    public void onVisitSource(@MaybeNull String str, @MaybeNull String str2) {
        super.visitSource(str, str2);
    }

    @MaybeNull
    public AnnotationVisitor onVisitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        return super.visitTypeAnnotation(i, typePath, str, z);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final AnnotationVisitor visitAnnotation(String str, boolean z) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitAnnotation(str, z);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        onVisitAttribute(attribute);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitEnd() {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitEnd();
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitField(i, str, str2, str3, obj);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitInnerClass(str, str2, str3, i);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitMethod(i, str, str2, str3, strArr);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final ModuleVisitor visitModule(String str, int i, @MaybeNull String str2) {
        considerTriggerSource();
        this.triggerModule = false;
        return onVisitModule(str, i, str2);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestHost(String str) {
        considerTriggerSource();
        considerTriggerModule();
        this.triggerNestHost = false;
        onVisitNestHost(str);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitNestMember(String str) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitNestMember(str);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitOuterClass(String str, @MaybeNull String str2, @MaybeNull String str3) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        this.triggerOuterClass = false;
        onVisitOuterClass(str, str2, str3);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitPermittedSubclass(String str) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        onVisitPermittedSubclass(str);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        considerTriggerAfterAttributes();
        return onVisitRecordComponent(str, str2, str3);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public final void visitSource(@MaybeNull String str, @MaybeNull String str2) {
        this.triggerSource = false;
        onVisitSource(str, str2);
    }

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    @MaybeNull
    public final AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
        considerTriggerSource();
        considerTriggerModule();
        considerTriggerNestHost();
        considerTriggerOuterClass();
        return onVisitTypeAnnotation(i, typePath, str, z);
    }
}
