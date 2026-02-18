package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultCallHandle {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultCallHandle> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;
        private static final MethodDescription.InDefinedShape TARGET_TYPE;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface DefaultMethodLocator {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Explicit implements DefaultMethodLocator {
                private final TypeDescription typeDescription;

                public Explicit(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Explicit) obj).typeDescription);
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultCallHandle.Binder.DefaultMethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    if (this.typeDescription.isInterface()) {
                        return target.invokeDefault(methodDescription.asSignatureToken(), this.typeDescription);
                    }
                    throw new IllegalStateException(methodDescription + " method carries default method call parameter on non-interface type");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum Implicit implements DefaultMethodLocator {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultCallHandle.Binder.DefaultMethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    return target.invokeDefault(methodDescription.asSignatureToken());
                }
            }

            Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription);
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DefaultCallHandle.class).getDeclaredMethods();
            TARGET_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("targetType")).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("nullIfImpossible")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultCallHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            StackManipulation compound;
            TypeDescription typeDescriptionAsErasure = parameterDescription.getType().asErasure();
            JavaType javaType = JavaType.METHOD_HANDLE;
            if (!typeDescriptionAsErasure.isAssignableFrom(javaType.getTypeStub())) {
                throw new IllegalStateException("Cannot assign MethodHandle type to " + parameterDescription);
            }
            if (methodDescription.isConstructor()) {
                return ((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
            TypeDescription typeDescription = (TypeDescription) loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class);
            Implementation.SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo = (typeDescription.represents(Void.TYPE) ? DefaultMethodLocator.Implicit.INSTANCE : new DefaultMethodLocator.Explicit(typeDescription)).resolve(target, methodDescription).withCheckedCompatibilityTo(methodDescription.asTypeToken());
            if (specialMethodInvocationWithCheckedCompatibilityTo.isValid()) {
                ArrayList arrayList = new ArrayList((methodDescription.getParameters().size() * 3) + 3);
                arrayList.add(specialMethodInvocationWithCheckedCompatibilityTo.toMethodHandle().toStackManipulation());
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class))))));
                if (!methodDescription.getParameters().isEmpty()) {
                    ArrayList arrayList2 = new ArrayList(methodDescription.getParameters().size());
                    Iterator<?> it = methodDescription.getParameters().iterator();
                    while (it.hasNext()) {
                        ParameterDescription parameterDescription2 = (ParameterDescription) it.next();
                        arrayList2.add(parameterDescription2.getType().isPrimitive() ? new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription2), assigner.assign(parameterDescription2.getType(), parameterDescription2.getType().asErasure().asBoxed().asGenericType(), typing)) : MethodVariableAccess.load(parameterDescription2));
                    }
                    arrayList.add(IntegerConstant.forValue(0));
                    arrayList.add(ArrayFactory.forType(TypeDescription.ForLoadedType.of(Object.class).asGenericType()).withValues(arrayList2));
                    TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                    JavaType javaType2 = JavaType.METHOD_HANDLE;
                    arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("insertArguments", 9, javaType2.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(javaType2.getTypeStub(), TypeDefinition.Sort.describe(Integer.TYPE), TypeDefinition.Sort.describe(Object[].class))))));
                }
                compound = new StackManipulation.Compound(arrayList);
            } else {
                if (!((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue()) {
                    return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                }
                compound = NullConstant.INSTANCE;
            }
            return new MethodDelegationBinder.ParameterBinding.Anonymous(compound);
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<DefaultCallHandle> getHandledType() {
            return DefaultCallHandle.class;
        }
    }

    boolean nullIfImpossible() default false;

    Class<?> targetType() default void.class;
}
