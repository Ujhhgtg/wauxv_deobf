package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.ArgumentTypeResolver;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.matcher.ElementMatchers;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Argument {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Argument> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape BINDING_MECHANIC;
        private static final MethodDescription.InDefinedShape VALUE;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
            VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
            BINDING_MECHANIC = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bindingMechanic")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Argument> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            MethodDescription.InDefinedShape inDefinedShape = VALUE;
            if (((Integer) loadable.getValue(inDefinedShape).resolve(Integer.class)).intValue() >= 0) {
                return methodDescription.getParameters().size() <= ((Integer) loadable.getValue(inDefinedShape).resolve(Integer.class)).intValue() ? MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE : ((BindingMechanic) loadable.getValue(BINDING_MECHANIC).load(Argument.class.getClassLoader()).resolve(BindingMechanic.class)).makeBinding(((ParameterDescription) methodDescription.getParameters().get(((Integer) loadable.getValue(inDefinedShape).resolve(Integer.class)).intValue())).getType(), parameterDescription.getType(), ((Integer) loadable.getValue(inDefinedShape).resolve(Integer.class)).intValue(), assigner, typing, ((ParameterDescription) methodDescription.getParameters().get(((Integer) loadable.getValue(inDefinedShape).resolve(Integer.class)).intValue())).getOffset());
            }
            throw new IllegalArgumentException("@Argument annotation on " + parameterDescription + " specifies negative index");
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<Argument> getHandledType() {
            return Argument.class;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum BindingMechanic {
        UNIQUE { // from class: net.bytebuddy.implementation.bind.annotation.Argument.BindingMechanic.1
            @Override // net.bytebuddy.implementation.bind.annotation.Argument.BindingMechanic
            public MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i, Assigner assigner, Assigner.Typing typing, int i2) {
                return MethodDelegationBinder.ParameterBinding.Unique.of(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(i2), assigner.assign(generic, generic2, typing)), new ArgumentTypeResolver.ParameterIndexToken(i));
            }
        },
        ANONYMOUS { // from class: net.bytebuddy.implementation.bind.annotation.Argument.BindingMechanic.2
            @Override // net.bytebuddy.implementation.bind.annotation.Argument.BindingMechanic
            public MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i, Assigner assigner, Assigner.Typing typing, int i2) {
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new StackManipulation.Compound(MethodVariableAccess.of(generic).loadFrom(i2), assigner.assign(generic, generic2, typing)));
            }
        };

        public abstract MethodDelegationBinder.ParameterBinding<?> makeBinding(TypeDescription.Generic generic, TypeDescription.Generic generic2, int i, Assigner assigner, Assigner.Typing typing, int i2);
    }

    BindingMechanic bindingMechanic() default BindingMechanic.UNIQUE;

    int value();
}
