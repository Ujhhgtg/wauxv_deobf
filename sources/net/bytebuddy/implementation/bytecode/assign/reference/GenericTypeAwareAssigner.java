package net.bytebuddy.implementation.bytecode.assign.reference;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Queue;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.utility.QueueFactory;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum GenericTypeAwareAssigner implements Assigner {
    INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class IsAssignableToVisitor implements TypeDescription.Generic.Visitor<Boolean> {
        private final boolean polymorphic;
        private final TypeDescription.Generic typeDescription;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class OfGenericArray extends OfManifestType {
            public OfGenericArray(TypeDescription.Generic generic, boolean z) {
                super(generic, z);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                TypeDescription.Generic componentType = this.typeDescription.getComponentType();
                TypeDescription.Generic componentType2 = generic.getComponentType();
                while (componentType.getSort().isGenericArray() && componentType2.getSort().isGenericArray()) {
                    componentType = componentType.getComponentType();
                    componentType2 = componentType2.getComponentType();
                }
                return Boolean.valueOf((componentType.getSort().isGenericArray() || componentType2.getSort().isGenericArray() || !((Boolean) componentType.accept(new IsAssignableToVisitor(componentType2))).booleanValue()) ? false : true);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class OfManifestType implements TypeDescription.Generic.Visitor<Boolean> {
            protected final boolean polymorphic;
            protected final TypeDescription.Generic typeDescription;

            public OfManifestType(TypeDescription.Generic generic, boolean z) {
                this.typeDescription = generic;
                this.polymorphic = z;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                OfManifestType ofManifestType = (OfManifestType) obj;
                return this.polymorphic == ofManifestType.polymorphic && this.typeDescription.equals(ofManifestType.typeDescription);
            }

            public int hashCode() {
                return dkz.e(this.typeDescription, getClass().hashCode() * 31, 31) + (this.polymorphic ? 1 : 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                if (generic.getTypeVariableSource().isInferrable()) {
                    throw new UnsupportedOperationException("Assignability checks for type variables declared by methods arel not currently supported");
                }
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onWildcard(TypeDescription.Generic generic) {
                Iterator<TypeDescription.Generic> it = generic.getUpperBounds().iterator();
                while (it.hasNext()) {
                    if (!((Boolean) this.typeDescription.accept(new IsAssignableToVisitor(it.next()))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                Iterator<TypeDescription.Generic> it2 = generic.getLowerBounds().iterator();
                while (it2.hasNext()) {
                    if (!((Boolean) it2.next().accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                        return Boolean.FALSE;
                    }
                }
                return Boolean.TRUE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class OfNonGenericType extends OfSimpleType {
            public OfNonGenericType(TypeDescription.Generic generic, boolean z) {
                super(generic, z);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class OfParameterizedType extends OfSimpleType {
            public OfParameterizedType(TypeDescription.Generic generic, boolean z) {
                super(generic, z);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class OfSimpleType extends OfManifestType {
            public OfSimpleType(TypeDescription.Generic generic, boolean z) {
                super(generic, z);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.valueOf(this.polymorphic ? this.typeDescription.asErasure().isAssignableTo(generic.asErasure()) : this.typeDescription.asErasure().equals(generic.asErasure()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                Queue queueMake = QueueFactory.make(Collections.singleton(this.typeDescription));
                HashSet hashSet = new HashSet(Collections.singleton(this.typeDescription.asErasure()));
                do {
                    TypeDescription.Generic generic2 = (TypeDescription.Generic) queueMake.remove();
                    if (generic2.asErasure().equals(generic.asErasure())) {
                        if (generic2.getSort().isNonGeneric()) {
                            return Boolean.TRUE;
                        }
                        TypeList.Generic typeArguments = generic2.getTypeArguments();
                        TypeList.Generic typeArguments2 = generic.getTypeArguments();
                        int size = typeArguments2.size();
                        if (typeArguments.size() != size) {
                            return Boolean.FALSE;
                        }
                        for (int i = 0; i < size; i++) {
                            if (!((Boolean) typeArguments.get(i).accept(new IsAssignableToVisitor(typeArguments2.get(i), false))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        TypeDescription.Generic ownerType = generic.getOwnerType();
                        return Boolean.valueOf(ownerType == null || ((Boolean) ownerType.accept(new IsAssignableToVisitor(ownerType))).booleanValue());
                    }
                    if (this.polymorphic) {
                        TypeDescription.Generic superClass = generic2.getSuperClass();
                        if (superClass != null && hashSet.add(superClass.asErasure())) {
                            queueMake.add(superClass);
                        }
                        for (TypeDescription.Generic generic3 : generic2.getInterfaces()) {
                            if (hashSet.add(generic3.asErasure())) {
                                queueMake.add(generic3);
                            }
                        }
                    }
                } while (!queueMake.isEmpty());
                return Boolean.FALSE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class OfWildcard implements TypeDescription.Generic.Visitor<Boolean> {
            private final TypeDescription.Generic wildcard;

            public OfWildcard(TypeDescription.Generic generic) {
                this.wildcard = generic;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.wildcard.equals(((OfWildcard) obj).wildcard);
            }

            public int hashCode() {
                return this.wildcard.hashCode() + (getClass().hashCode() * 31);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onGenericArray(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onNonGenericType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onParameterizedType(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onTypeVariable(TypeDescription.Generic generic) {
                return Boolean.FALSE;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
            public Boolean onWildcard(TypeDescription.Generic generic) {
                boolean z;
                Iterator<TypeDescription.Generic> it = generic.getUpperBounds().iterator();
                boolean z2 = false;
                while (true) {
                    while (true) {
                        if (!it.hasNext()) {
                            boolean z3 = false;
                            for (TypeDescription.Generic generic2 : generic.getLowerBounds()) {
                                Iterator<TypeDescription.Generic> it2 = this.wildcard.getLowerBounds().iterator();
                                while (it2.hasNext()) {
                                    if (!((Boolean) generic2.accept(new IsAssignableToVisitor(it2.next()))).booleanValue()) {
                                        return Boolean.FALSE;
                                    }
                                }
                                z3 = true;
                            }
                            if (z) {
                                return Boolean.valueOf(this.wildcard.getLowerBounds().isEmpty());
                            }
                            if (!z3) {
                                return Boolean.TRUE;
                            }
                            TypeList.Generic upperBounds = this.wildcard.getUpperBounds();
                            if (upperBounds.size() == 0 || (upperBounds.size() == 1 && upperBounds.getOnly().represents(Object.class))) {
                                z2 = true;
                            }
                            return Boolean.valueOf(z2);
                        }
                        TypeDescription.Generic next = it.next();
                        Iterator<TypeDescription.Generic> it3 = this.wildcard.getUpperBounds().iterator();
                        while (it3.hasNext()) {
                            if (!((Boolean) it3.next().accept(new IsAssignableToVisitor(next))).booleanValue()) {
                                return Boolean.FALSE;
                            }
                        }
                        z = z || !next.represents(Object.class);
                    }
                }
            }
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic) {
            this(generic, true);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            IsAssignableToVisitor isAssignableToVisitor = (IsAssignableToVisitor) obj;
            return this.polymorphic == isAssignableToVisitor.polymorphic && this.typeDescription.equals(isAssignableToVisitor.typeDescription);
        }

        public int hashCode() {
            return dkz.e(this.typeDescription, getClass().hashCode() * 31, 31) + (this.polymorphic ? 1 : 0);
        }

        public IsAssignableToVisitor(TypeDescription.Generic generic, boolean z) {
            this.typeDescription = generic;
            this.polymorphic = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onGenericArray(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfGenericArray(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onNonGenericType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfNonGenericType(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onParameterizedType(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfParameterizedType(generic, this.polymorphic));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onTypeVariable(TypeDescription.Generic generic) {
            if (generic.getTypeVariableSource().isInferrable()) {
                throw new UnsupportedOperationException("Assignability checks for type variables declared by methods are not currently supported");
            }
            if (generic.equals(this.typeDescription)) {
                return Boolean.TRUE;
            }
            if (!this.polymorphic) {
                return Boolean.FALSE;
            }
            Queue queueMake = QueueFactory.make(generic.getUpperBounds());
            while (!queueMake.isEmpty()) {
                TypeDescription.Generic generic2 = (TypeDescription.Generic) queueMake.remove();
                if (((Boolean) generic2.accept(new IsAssignableToVisitor(this.typeDescription))).booleanValue()) {
                    return Boolean.TRUE;
                }
                if (generic2.getSort().isTypeVariable()) {
                    queueMake.addAll(generic2.getUpperBounds());
                }
            }
            return Boolean.FALSE;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
        public Boolean onWildcard(TypeDescription.Generic generic) {
            return (Boolean) this.typeDescription.accept(new OfWildcard(generic));
        }
    }

    @Override // net.bytebuddy.implementation.bytecode.assign.Assigner
    public StackManipulation assign(TypeDescription.Generic generic, TypeDescription.Generic generic2, Assigner.Typing typing) {
        return (generic.isPrimitive() || generic2.isPrimitive()) ? generic.equals(generic2) ? StackManipulation.Trivial.INSTANCE : StackManipulation.Illegal.INSTANCE : ((Boolean) generic.accept(new IsAssignableToVisitor(generic2))).booleanValue() ? StackManipulation.Trivial.INSTANCE : typing.isDynamic() ? generic.asErasure().isAssignableTo(generic2.asErasure()) ? StackManipulation.Trivial.INSTANCE : TypeCasting.to(generic2) : StackManipulation.Illegal.INSTANCE;
    }
}
