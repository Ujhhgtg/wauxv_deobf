package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
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

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SuperCallHandle {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Binder implements TargetMethodAnnotationDrivenBinder.ParameterBinder<SuperCallHandle> {
        INSTANCE;

        private static final MethodDescription.InDefinedShape FALLBACK_TO_DEFAULT;
        private static final MethodDescription.InDefinedShape NULL_IF_IMPOSSIBLE;

        static {
            MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SuperCallHandle.class).getDeclaredMethods();
            FALLBACK_TO_DEFAULT = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("fallbackToDefault")).getOnly();
            NULL_IF_IMPOSSIBLE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("nullIfImpossible")).getOnly();
        }

        @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
        public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<SuperCallHandle> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
            StackManipulation compound;
            TypeDescription typeDescriptionAsErasure = parameterDescription.getType().asErasure();
            JavaType javaType = JavaType.METHOD_HANDLE;
            if (!typeDescriptionAsErasure.isAssignableFrom(javaType.getTypeStub())) {
                throw new IllegalStateException("A method handle for a super method invocation cannot be assigned to " + parameterDescription);
            }
            if (methodDescription.isConstructor()) {
                return ((Boolean) loadable.getValue(NULL_IF_IMPOSSIBLE).resolve(Boolean.class)).booleanValue() ? new MethodDelegationBinder.ParameterBinding.Anonymous(NullConstant.INSTANCE) : MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
            }
            Implementation.SpecialMethodInvocation specialMethodInvocationWithCheckedCompatibilityTo = (((Boolean) loadable.getValue(FALLBACK_TO_DEFAULT).resolve(Boolean.class)).booleanValue() ? target.invokeDominant(methodDescription.asSignatureToken()) : target.invokeSuper(methodDescription.asSignatureToken())).withCheckedCompatibilityTo(methodDescription.asTypeToken());
            if (specialMethodInvocationWithCheckedCompatibilityTo.isValid()) {
                ArrayList arrayList = new ArrayList((methodDescription.getParameters().size() * 3) + (methodDescription.isStatic() ? 0 : 2) + 1);
                arrayList.add(specialMethodInvocationWithCheckedCompatibilityTo.toMethodHandle().toStackManipulation());
                if (!methodDescription.isStatic()) {
                    arrayList.add(MethodVariableAccess.loadThis());
                    arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class))))));
                }
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
        public Class<SuperCallHandle> getHandledType() {
            return SuperCallHandle.class;
        }
    }

    boolean fallbackToDefault() default true;

    boolean nullIfImpossible() default false;
}
