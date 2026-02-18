package net.bytebuddy.implementation.bytecode.assign.primitive;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class VoidAwareAssigner implements Assigner {
    private final Assigner chained;

    public VoidAwareAssigner(Assigner assigner) {
        this.chained = assigner;
    }

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        Class cls = Void.TYPE;
        return (generic.represents(cls) && generic2.represents(cls)) ? StackManipulation.Trivial.INSTANCE : generic.represents(cls) ? typing.isDynamic() ? DefaultValue.of(generic2) : StackManipulation.Illegal.INSTANCE : generic2.represents(cls) ? Removal.of(generic) : this.chained.assign(generic, generic2, typing);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.chained.equals(((VoidAwareAssigner) obj).chained);
    }

    public int hashCode() {
        return this.chained.hashCode() + (getClass().hashCode() * 31);
    }
}
