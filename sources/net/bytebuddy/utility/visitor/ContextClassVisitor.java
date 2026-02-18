package net.bytebuddy.utility.visitor;

import java.util.List;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.utility.OpenedClassReader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextClassVisitor extends ClassVisitor {
    private boolean active;

    public ContextClassVisitor(ClassVisitor classVisitor) {
        super(OpenedClassReader.ASM_API, classVisitor);
    }

    public ContextClassVisitor active() {
        this.active = true;
        return this;
    }

    public abstract List<DynamicType> getAuxiliaryTypes();

    public abstract LoadedTypeInitializer getLoadedTypeInitializer();

    @Override // net.bytebuddy.jar.asm.ClassVisitor
    public void visitEnd() {
        super.visitEnd();
        if (this.active) {
            return;
        }
        if (!getAuxiliaryTypes().isEmpty() || getLoadedTypeInitializer().isAlive()) {
            throw new IllegalStateException(this + " is not defined 'active' but defines auxiliary types or an alive type initializer");
        }
    }
}
