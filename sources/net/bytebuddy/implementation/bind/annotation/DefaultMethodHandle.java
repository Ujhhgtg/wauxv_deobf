package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultMethodHandle {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DefaultMethodHandle> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;
        private static final MethodDescription.InDefinedShape TARGET_TYPE;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface MethodLocator {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForExplicitType implements MethodLocator {
                private final TypeDescription typeDescription;

                public ForExplicitType(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForExplicitType) obj).typeDescription);
                }

                public int hashCode() {
                    return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultMethodHandle.Binder.MethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    if (this.typeDescription.isInterface()) {
                        return target.invokeDefault(methodDescription.asSignatureToken(), TargetType.resolve(this.typeDescription, target.getInstrumentedType()));
                    }
                    throw new IllegalStateException(methodDescription + " method carries default method call parameter on non-interface type");
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum ForImplicitType implements MethodLocator {
                INSTANCE;

                @Override // net.bytebuddy.implementation.bind.annotation.DefaultMethodHandle.Binder.MethodLocator
                public Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription) {
                    return target.invokeDefault(methodDescription.asSignatureToken());
                }
            }

            Implementation.SpecialMethodInvocation resolve(Implementation.Target target, MethodDescription methodDescription);
        }

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DefaultMethodHandle.class).getDeclaredMethods();
            TARGET_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("targetType")).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("nullIfImpossible")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DefaultMethodHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            if (!parameterDescription.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                throw new IllegalStateException("Cannot assign MethodHandle type to " + parameterDescription);
            }
            if (!methodDescription.isMethod()) {
                return ((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
            TypeDescription typeDescription = (TypeDescription) loadable.getValue(TARGET_TYPE).resolve(TypeDescription.class);
            Implementation.SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo = (typeDescription.represents(Void.TYPE) ? MethodLocator.ForImplicitType.INSTANCE : new MethodLocator.ForExplicitType(typeDescription)).resolve(target, methodDescription).withCheckedCompatibilityTo(methodDescription.asTypeToken());
            return specialMethodInvocationWithCheckedCompatibilityTo.isValid() ? new MethodDelegationBinder.ParameterBinding.Anonymous(specialMethodInvocationWithCheckedCompatibilityTo.toMethodHandle().toStackManipulation()) : ((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<DefaultMethodHandle> getHandledType() {
            return DefaultMethodHandle.class;
        }
    }

    boolean nullIfImpossible() default false;

    Class<?> targetType() default void.class;
}
