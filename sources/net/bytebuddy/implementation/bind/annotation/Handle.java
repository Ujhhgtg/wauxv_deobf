package net.bytebuddy.implementation.bind.annotation;

import com.umeng.analytics.pro.f;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
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
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Handle {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<Handle> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape HANDLE_NAME;
        private static final MethodDescription.InDefinedShape HANDLE_OWNER;
        private static final MethodDescription.InDefinedShape HANDLE_PARAMETER_TYPES;
        private static final MethodDescription.InDefinedShape HANDLE_RETURN_TYPE;
        private static final MethodDescription.InDefinedShape HANDLE_TYPE;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Handle.class).getDeclaredMethods();
            HANDLE_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named(f.y)).getOnly();
            HANDLE_OWNER = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("owner")).getOnly();
            HANDLE_NAME = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("name")).getOnly();
            HANDLE_RETURN_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("returnType")).getOnly();
            HANDLE_PARAMETER_TYPES = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("parameterTypes")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<Handle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            TypeDescription typeDescriptionAsErasure = parameterDescription.getType().asErasure();
            JavaType javaType = JavaType.METHOD_HANDLE;
            if (typeDescriptionAsErasure.isAssignableFrom(javaType.getTypeStub())) {
                TypeDescription instrumentedType = (TypeDescription) loadable.getValue(HANDLE_OWNER).resolve(TypeDescription.class);
                JavaConstant.MethodHandle.HandleType handleType = (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(HANDLE_TYPE).resolve(EnumerationDescription.class)).load(JavaConstant.MethodHandle.HandleType.class);
                if (instrumentedType.represents(Void.TYPE)) {
                    instrumentedType = target.getInstrumentedType();
                }
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new JavaConstantValue(new JavaConstant.MethodHandle(handleType, instrumentedType, (String) loadable.getValue(HANDLE_NAME).resolve(String.class), (TypeDescription) loadable.getValue(HANDLE_RETURN_TYPE).resolve(TypeDescription.class), Arrays.asList((Object[]) loadable.getValue(HANDLE_PARAMETER_TYPES).resolve(TypeDescription[].class)))));
            }
            throw new IllegalStateException("Cannot assign " + parameterDescription + " to " + javaType.getTypeStub());
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public Class<Handle> getHandledType() {
            return Handle.class;
        }
    }

    String name();

    Class<?> owner() default void.class;

    Class<?>[] parameterTypes();

    Class<?> returnType();

    JavaConstant.MethodHandle.HandleType type();
}
