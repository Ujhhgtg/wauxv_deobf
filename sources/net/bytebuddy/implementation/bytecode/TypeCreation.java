package net.bytebuddy.implementation.bytecode;

import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class TypeCreation extends StackManipulation.AbstractBase {
    private final TypeDescription typeDescription;

    public TypeCreation(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    public static StackManipulation of(TypeDescription typeDescription) {
        if (typeDescription.isArray() || typeDescription.isPrimitive() || typeDescription.isAbstract()) {
            throw new IllegalArgumentException(dkz.x(typeDescription, " is not instantiable"));
        }
        return new TypeCreation(typeDescription);
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitTypeInsn(187, this.typeDescription.getInternalName());
        return new StackManipulation.Size(1, 1);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((TypeCreation) obj).typeDescription);
    }

    public int hashCode() {
        return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
    }
}
