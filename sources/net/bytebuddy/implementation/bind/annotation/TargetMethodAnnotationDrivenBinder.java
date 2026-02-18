package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Argument;
import net.bytebuddy.implementation.bind.annotation.Default;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import net.bytebuddy.implementation.bind.annotation.DefaultCallHandle;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import net.bytebuddy.implementation.bind.annotation.DefaultMethodHandle;
import net.bytebuddy.implementation.bind.annotation.DynamicConstant;
import net.bytebuddy.implementation.bind.annotation.Empty;
import net.bytebuddy.implementation.bind.annotation.FieldGetterHandle;
import net.bytebuddy.implementation.bind.annotation.FieldSetterHandle;
import net.bytebuddy.implementation.bind.annotation.FieldValue;
import net.bytebuddy.implementation.bind.annotation.Handle;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.StubValue;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.SuperCallHandle;
import net.bytebuddy.implementation.bind.annotation.SuperMethod;
import net.bytebuddy.implementation.bind.annotation.SuperMethodHandle;
import net.bytebuddy.implementation.bind.annotation.This;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class TargetMethodAnnotationDrivenBinder implements MethodDelegationBinder {
    private final DelegationProcessor delegationProcessor;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class DelegationProcessor {
        private final Map<? extends TypeDescription, ? extends ParameterBinder<?>> parameterBinders;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Handler {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Bound<T extends Annotation> implements Handler {
                private final AnnotationDescription.Loadable<T> annotation;
                private final ParameterBinder<T> parameterBinder;
                private final ParameterDescription target;
                private final Assigner.Typing typing;

                public Bound(ParameterDescription parameterDescription, ParameterBinder<T> parameterBinder, AnnotationDescription.Loadable<T> loadable, Assigner.Typing typing) {
                    this.target = parameterDescription;
                    this.parameterBinder = parameterBinder;
                    this.annotation = loadable;
                    this.typing = typing;
                }

                public static Handler of(ParameterDescription parameterDescription, ParameterBinder<?> parameterBinder, AnnotationDescription annotationDescription, Assigner.Typing typing) {
                    return new Bound(parameterDescription, parameterBinder, annotationDescription.prepare(parameterBinder.getHandledType()), typing);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler
                public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target, Assigner assigner) {
                    return this.parameterBinder.bind(this.annotation, methodDescription, this.target, target, assigner, this.typing);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Bound bound = (Bound) obj;
                    return this.typing.equals(bound.typing) && this.target.equals(bound.target) && this.parameterBinder.equals(bound.parameterBinder) && this.annotation.equals(bound.annotation);
                }

                public int hashCode() {
                    return this.typing.hashCode() + ((this.annotation.hashCode() + ((this.parameterBinder.hashCode() + ((this.target.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler
                public boolean isBound() {
                    return true;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Unbound implements Handler {
                private final ParameterDescription target;
                private final Assigner.Typing typing;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class DefaultArgument implements Argument {
                    private static final String BINDING_MECHANIC = "bindingMechanic";
                    private static final String VALUE = "value";
                    private final int parameterIndex;

                    public DefaultArgument(int i) {
                        this.parameterIndex = i;
                    }

                    @Override // java.lang.annotation.Annotation
                    public Class<Argument> annotationType() {
                        return Argument.class;
                    }

                    @Override // net.bytebuddy.implementation.bind.annotation.Argument
                    public Argument.BindingMechanic bindingMechanic() {
                        return Argument.BindingMechanic.UNIQUE;
                    }

                    @Override // java.lang.annotation.Annotation
                    public boolean equals(@MaybeNull Object obj) {
                        if (this != obj) {
                            return (obj instanceof Argument) && this.parameterIndex == ((Argument) obj).value();
                        }
                        return true;
                    }

                    @Override // java.lang.annotation.Annotation
                    public int hashCode() {
                        return (Argument.BindingMechanic.UNIQUE.hashCode() ^ 1957906263) + (1335633679 ^ this.parameterIndex);
                    }

                    @Override // java.lang.annotation.Annotation
                    public String toString() {
                        StringBuilder sb = new StringBuilder("@");
                        sb.append(Argument.class.getName());
                        sb.append("(bindingMechanic=");
                        sb.append(Argument.BindingMechanic.UNIQUE);
                        sb.append(", value=");
                        return yg.m(sb, ")", this.parameterIndex);
                    }

                    @Override // net.bytebuddy.implementation.bind.annotation.Argument
                    public int value() {
                        return this.parameterIndex;
                    }
                }

                public Unbound(ParameterDescription parameterDescription, Assigner.Typing typing) {
                    this.target = parameterDescription;
                    this.typing = typing;
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler
                public MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target, Assigner assigner) {
                    return Argument.Binder.INSTANCE.bind(AnnotationDescription.ForLoadedAnnotation.of(new DefaultArgument(this.target.getIndex())), methodDescription, this.target, target, assigner, this.typing);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Unbound unbound = (Unbound) obj;
                    return this.typing.equals(unbound.typing) && this.target.equals(unbound.target);
                }

                public int hashCode() {
                    return this.typing.hashCode() + ((this.target.hashCode() + (getClass().hashCode() * 31)) * 31);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.DelegationProcessor.Handler
                public boolean isBound() {
                    return false;
                }
            }

            MethodDelegationBinder.ParameterBinding<?> bind(MethodDescription methodDescription, Implementation.Target target, Assigner assigner);

            boolean isBound();
        }

        public DelegationProcessor(Map<? extends TypeDescription, ? extends ParameterBinder<?>> map) {
            this.parameterBinders = map;
        }

        public static DelegationProcessor of(List<? extends ParameterBinder<?>> list) {
            HashMap map = new HashMap();
            for (ParameterBinder<?> parameterBinder : list) {
                if (map.put(TypeDescription.ForLoadedType.of(parameterBinder.getHandledType()), parameterBinder) != null) {
                    throw new IllegalArgumentException("Attempt to bind two handlers to " + parameterBinder.getHandledType());
                }
            }
            return new DelegationProcessor(map);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.parameterBinders.equals(((DelegationProcessor) obj).parameterBinders);
        }

        public int hashCode() {
            return this.parameterBinders.hashCode() + (getClass().hashCode() * 31);
        }

        public Handler prepare(ParameterDescription parameterDescription) {
            Assigner.Typing typingCheck = RuntimeType.Verifier.check(parameterDescription);
            Handler unbound = new Handler.Unbound(parameterDescription, typingCheck);
            for (AnnotationDescription annotationDescription : parameterDescription.getDeclaredAnnotations()) {
                ParameterBinder<?> parameterBinder = this.parameterBinders.get(annotationDescription.getAnnotationType());
                if (parameterBinder != null && unbound.isBound()) {
                    throw new IllegalStateException("Ambiguous binding for parameter annotated with two handled annotation types");
                }
                if (parameterBinder != null) {
                    unbound = Handler.Bound.of(parameterDescription, parameterBinder, annotationDescription, typingCheck);
                }
            }
            return unbound;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ParameterBinder<T extends Annotation> {
        public static final List<ParameterBinder<?>> DEFAULTS = Collections.unmodifiableList(Arrays.asList(Argument.Binder.INSTANCE, AllArguments.Binder.INSTANCE, Origin.Binder.INSTANCE, This.Binder.INSTANCE, Super.Binder.INSTANCE, Default.Binder.INSTANCE, SuperCall.Binder.INSTANCE, SuperCallHandle.Binder.INSTANCE, DefaultCall.Binder.INSTANCE, DefaultCallHandle.Binder.INSTANCE, SuperMethod.Binder.INSTANCE, SuperMethodHandle.Binder.INSTANCE, Handle.Binder.INSTANCE, DynamicConstant.Binder.INSTANCE, DefaultMethod.Binder.INSTANCE, DefaultMethodHandle.Binder.INSTANCE, FieldValue.Binder.INSTANCE, FieldGetterHandle.Binder.INSTANCE, FieldSetterHandle.Binder.INSTANCE, StubValue.Binder.INSTANCE, Empty.Binder.INSTANCE));

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class ForFieldBinding<S extends Annotation> implements ParameterBinder<S> {
            protected static final String BEAN_PROPERTY = "";

            @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
            public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
                TypeDescription typeDescriptionDeclaringType = declaringType(loadable);
                Class cls = Void.TYPE;
                if (!typeDescriptionDeclaringType.represents(cls)) {
                    if (declaringType(loadable).isPrimitive() || declaringType(loadable).isArray()) {
                        throw new IllegalStateException(dkz.t("A primitive type or array type cannot declare a field: ", methodDescription));
                    }
                    if (!target.getInstrumentedType().isAssignableTo(declaringType(loadable))) {
                        return MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE;
                    }
                }
                FieldLocator forClassHierarchy = declaringType(loadable).represents(cls) ? new FieldLocator.ForClassHierarchy(target.getInstrumentedType()) : new FieldLocator.ForExactType(declaringType(loadable), target.getInstrumentedType());
                FieldLocator.Resolution resolutionOfBeanAccessor = fieldName(loadable).equals("") ? FieldLocator.Resolution.Simple.ofBeanAccessor(forClassHierarchy, methodDescription) : forClassHierarchy.locate(fieldName(loadable));
                return (!resolutionOfBeanAccessor.isResolved() || (methodDescription.isStatic() && !resolutionOfBeanAccessor.getField().isStatic())) ? MethodDelegationBinder.ParameterBinding.Illegal.INSTANCE : bind(resolutionOfBeanAccessor.getField(), loadable, methodDescription, parameterDescription, target, assigner);
            }

            public abstract MethodDelegationBinder.ParameterBinding<?> bind(FieldDescription fieldDescription, AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner);

            public abstract TypeDescription declaringType(AnnotationDescription.Loadable<S> loadable);

            public abstract String fieldName(AnnotationDescription.Loadable<S> loadable);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class ForFixedValue<S extends Annotation> implements ParameterBinder<S> {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfConstant<U extends Annotation> extends ForFixedValue<U> {
                private final Class<U> type;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Object value;

                public OfConstant(Class<U> cls, @MaybeNull Object obj) {
                    this.type = cls;
                    this.value = obj;
                }

                public static <V extends Annotation> ParameterBinder<V> of(Class<V> cls, @MaybeNull Object obj) {
                    return new OfConstant(cls, obj);
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder.ForFixedValue
                @MaybeNull
                public Object bind(AnnotationDescription.Loadable<U> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription) {
                    return this.value;
                }

                /* JADX WARN: Found duplicated region for block: B:22:0x0032 A[RETURN] */
                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfConstant ofConstant = (OfConstant) obj;
                    if (!this.type.equals(ofConstant.type)) {
                        return false;
                    }
                    Object obj2 = this.value;
                    Object obj3 = ofConstant.value;
                    if (obj3 != null) {
                        return obj2 != null && obj2.equals(obj3);
                    }
                    if (obj2 != null) {
                        return false;
                    }
                }

                @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
                public Class<U> getHandledType() {
                    return this.type;
                }

                public int hashCode() {
                    int iD = bjs.d(getClass().hashCode() * 31, 31, this.type);
                    Object obj = this.value;
                    return obj != null ? obj.hashCode() + iD : iD;
                }
            }

            @MaybeNull
            public abstract Object bind(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription);

            @Override // net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder.ParameterBinder
            public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<S> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing) {
                Object objBind = bind(loadable, methodDescription, parameterDescription);
                if (objBind == null) {
                    return new MethodDelegationBinder.ParameterBinding.Anonymous(DefaultValue.of(parameterDescription.getType()));
                }
                ConstantValue constantValueWrap = ConstantValue.Simple.wrap(objBind);
                return new MethodDelegationBinder.ParameterBinding.Anonymous(new StackManipulation.Compound(constantValueWrap.toStackManipulation(), assigner.assign(constantValueWrap.getTypeDescription().asGenericType(), parameterDescription.getType(), typing)));
            }
        }

        MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loadable<T> loadable, MethodDescription methodDescription, ParameterDescription parameterDescription, Implementation.Target target, Assigner assigner, Assigner.Typing typing);

        Class<T> getHandledType();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Record implements MethodDelegationBinder.Record {
        private final MethodDescription candidate;
        private final List<DelegationProcessor.Handler> handlers;
        private final Assigner.Typing typing;

        public Record(MethodDescription methodDescription, List<DelegationProcessor.Handler> list, Assigner.Typing typing) {
            this.candidate = methodDescription;
            this.handlers = list;
            this.typing = typing;
        }

        @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder.Record
        public MethodDelegationBinder.MethodBinding bind(Implementation.Target target, MethodDescription methodDescription, MethodDelegationBinder.TerminationHandler terminationHandler, MethodDelegationBinder.MethodInvoker methodInvoker, Assigner assigner) {
            if (!this.candidate.isAccessibleTo(target.getInstrumentedType())) {
                return MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
            }
            StackManipulation stackManipulationResolve = terminationHandler.resolve(assigner, this.typing, methodDescription, this.candidate);
            if (!stackManipulationResolve.isValid()) {
                return MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
            }
            MethodDelegationBinder.MethodBinding.Builder builder = new MethodDelegationBinder.MethodBinding.Builder(methodInvoker, this.candidate);
            Iterator<DelegationProcessor.Handler> it = this.handlers.iterator();
            while (it.hasNext()) {
                MethodDelegationBinder.ParameterBinding<?> parameterBindingBind = it.next().bind(methodDescription, target, assigner);
                if (!parameterBindingBind.isValid() || !builder.append(parameterBindingBind)) {
                    return MethodDelegationBinder.MethodBinding.Illegal.INSTANCE;
                }
            }
            return builder.build(stackManipulationResolve);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Record record = (Record) obj;
            return this.typing.equals(record.typing) && this.candidate.equals(record.candidate) && this.handlers.equals(record.handlers);
        }

        public int hashCode() {
            return this.typing.hashCode() + bjs.g(this.handlers, dkz.c(this.candidate, getClass().hashCode() * 31, 31), 31);
        }

        public String toString() {
            return this.candidate.toString();
        }
    }

    public TargetMethodAnnotationDrivenBinder(DelegationProcessor delegationProcessor) {
        this.delegationProcessor = delegationProcessor;
    }

    public static MethodDelegationBinder of(List<? extends ParameterBinder<?>> list) {
        return new TargetMethodAnnotationDrivenBinder(DelegationProcessor.of(list));
    }

    @Override // net.bytebuddy.implementation.bind.MethodDelegationBinder
    public MethodDelegationBinder.Record compile(MethodDescription methodDescription) {
        if (IgnoreForBinding.Verifier.check(methodDescription)) {
            return MethodDelegationBinder.Record.Illegal.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(methodDescription.getParameters().size());
        Iterator<?> it = methodDescription.getParameters().iterator();
        while (it.hasNext()) {
            arrayList.add(this.delegationProcessor.prepare((ParameterDescription) it.next()));
        }
        return new Record(methodDescription, arrayList, RuntimeType.Verifier.check(methodDescription));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.delegationProcessor.equals(((TargetMethodAnnotationDrivenBinder) obj).delegationProcessor);
    }

    public int hashCode() {
        return this.delegationProcessor.hashCode() + (getClass().hashCode() * 31);
    }
}
