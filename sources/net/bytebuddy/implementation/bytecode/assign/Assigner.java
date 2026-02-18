package net.bytebuddy.implementation.bytecode.assign;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.GenericTypeAwareAssigner;
import net.bytebuddy.implementation.bytecode.assign.reference.ReferenceTypeAwareAssigner;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Assigner {
    public static final Assigner DEFAULT = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(ReferenceTypeAwareAssigner.INSTANCE));
    public static final Assigner GENERICS_AWARE = new VoidAwareAssigner(new PrimitiveTypeAwareAssigner(GenericTypeAwareAssigner.INSTANCE));

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum EqualTypesOnly implements Assigner {
        GENERIC { // from class: net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly.1
            @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
            public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
                return generic.equals(generic2) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        },
        ERASURE { // from class: net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly.2
            @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
            public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
                return generic.asErasure().equals(generic2.asErasure()) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Refusing implements Assigner {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
        public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing) {
            return StackManipulation.Illegal.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Typing {
        STATIC(false),
        DYNAMIC(true);

        private final boolean dynamic;

        Typing(boolean z) {
            this.dynamic = z;
        }

        public static Typing of(boolean z) {
            return z ? DYNAMIC : STATIC;
        }

        public boolean isDynamic() {
            return this.dynamic;
        }
    }

    StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Typing typing);
}
