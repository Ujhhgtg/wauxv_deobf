package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collections;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.member.Invokedynamic;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DynamicConstant {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<DynamicConstant> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape BOOTSTRAP_NAME;
        private static final MethodDescription.InDefinedShape BOOTSTRAP_OWNER;
        private static final MethodDescription.InDefinedShape BOOTSTRAP_PARAMETER_TYPES;
        private static final MethodDescription.InDefinedShape BOOTSTRAP_RETURN_TYPE;
        private static final MethodDescription.InDefinedShape BOOTSTRAP_TYPE;
        private static final MethodDescription.InDefinedShape INVOKEDYNAMIC;
        private static final MethodDescription.InDefinedShape NAME;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(DynamicConstant.class).getDeclaredMethods();
            NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("name")).getOnly();
            BOOTSTRAP_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bootstrapType")).getOnly();
            BOOTSTRAP_OWNER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bootstrapOwner")).getOnly();
            BOOTSTRAP_NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bootstrapName")).getOnly();
            BOOTSTRAP_RETURN_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bootstrapReturnType")).getOnly();
            BOOTSTRAP_PARAMETER_TYPES = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bootstrapParameterTypes")).getOnly();
            INVOKEDYNAMIC = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("invokedynamic")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<DynamicConstant> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            TypeDescription instrumentedType = (TypeDescription) loadable.getValue(BOOTSTRAP_OWNER).resolve(TypeDescription.class);
            boolean zBooleanValue = ((Boolean) loadable.getValue(INVOKEDYNAMIC).resolve(Boolean.class)).booleanValue();
            Class cls = Void.TYPE;
            if (zBooleanValue) {
                String str = (String) loadable.getValue(NAME).resolve(String.class);
                JavaConstant.MethodType methodTypeOf = JavaConstant.MethodType.of(parameterDescription.getType().asErasure(), new TypeDescription[0]);
                JavaConstant.MethodHandle.HandleType handleType = (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(BOOTSTRAP_TYPE).resolve(EnumerationDescription.class)).load(JavaConstant.MethodHandle.HandleType.class);
                if (instrumentedType.represents(cls)) {
                    instrumentedType = target.getInstrumentedType();
                }
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new Invokedynamic(str, methodTypeOf, new JavaConstant.MethodHandle(handleType, instrumentedType, (String) loadable.getValue(BOOTSTRAP_NAME).resolve(String.class), (TypeDescription) loadable.getValue(BOOTSTRAP_RETURN_TYPE).resolve(TypeDescription.class), Arrays.asList((Object[]) loadable.getValue(BOOTSTRAP_PARAMETER_TYPES).resolve(TypeDescription[].class))), Collections.EMPTY_LIST));
            }
            String str2 = (String) loadable.getValue(NAME).resolve(String.class);
            TypeDescription typeDescriptionAsErasure = parameterDescription.getType().asErasure();
            JavaConstant.MethodHandle.HandleType handleType2 = (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(BOOTSTRAP_TYPE).resolve(EnumerationDescription.class)).load(JavaConstant.MethodHandle.HandleType.class);
            if (instrumentedType.represents(cls)) {
                instrumentedType = target.getInstrumentedType();
            }
            return new MethodDelegationBinder.ParameterBinding.Anonymous(new JavaConstantValue(new JavaConstant.Dynamic(str2, typeDescriptionAsErasure, new JavaConstant.MethodHandle(handleType2, instrumentedType, (String) loadable.getValue(BOOTSTRAP_NAME).resolve(String.class), (TypeDescription) loadable.getValue(BOOTSTRAP_RETURN_TYPE).resolve(TypeDescription.class), Arrays.asList((Object[]) loadable.getValue(BOOTSTRAP_PARAMETER_TYPES).resolve(TypeDescription[].class))), Collections.EMPTY_LIST)));
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<DynamicConstant> getHandledType() {
            return DynamicConstant.class;
        }
    }

    String bootstrapName();

    Class<?> bootstrapOwner() default void.class;

    Class<?>[] bootstrapParameterTypes();

    Class<?> bootstrapReturnType();

    JavaConstant.MethodHandle.HandleType bootstrapType();

    boolean invokedynamic() default false;

    String name() default "_";
}
