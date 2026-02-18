package net.bytebuddy.asm;

import com.umeng.analytics.pro.f;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.SafeVarargsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.dynamic.scaffold.FieldLocator;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.collection.ArrayFactory;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import net.bytebuddy.implementation.bytecode.constant.FieldConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.JavaConstantValue;
import net.bytebuddy.implementation.bytecode.constant.MethodConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.SerializedConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.Invokedynamic;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.visitor.LocalVariableAwareMethodVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class MemberSubstitution implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
    protected static final int THIS_REFERENCE = 0;
    private final boolean failIfNoMatch;
    private final MethodGraph.Compiler methodGraphCompiler;
    private final Replacement.Factory replacementFactory;
    private final boolean strict;
    private final TypePoolResolver typePoolResolver;

    /* JADX INFO: renamed from: net.bytebuddy.asm.MemberSubstitution$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType;

        static {
            int[] iArr = new int[Replacement.InvocationType.values().length];
            $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType = iArr;
            try {
                iArr[Replacement.InvocationType.VIRTUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType[Replacement.InvocationType.SUPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AllArguments {
        boolean includeSelf() default false;

        boolean nullIfEmpty() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Argument {
        boolean optional() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        int value();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Current {
        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DynamicConstant {
        String bootstrapName();

        Class<?> bootstrapOwner() default void.class;

        Class<?>[] bootstrapParameterTypes();

        Class<?> bootstrapReturnType();

        JavaConstant.MethodHandle.HandleType bootstrapType();

        boolean invokedynamic() default false;

        String name() default "_";
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldGetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldSetterHandle {
        Class<?> declaringType() default void.class;

        String value() default "";
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldValue {
        Class<?> declaringType() default void.class;

        Assigner.Typing typing() default Assigner.Typing.STATIC;

        String value() default "";
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Handle {
        String name();

        Class<?> owner() default void.class;

        Class<?>[] parameterTypes();

        Class<?> returnType();

        JavaConstant.MethodHandle.HandleType type();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class LambdaMetaFactoryMatcher implements ElementMatcher<JavaConstant.MethodHandle> {
        @Override // net.bytebuddy.matcher.ElementMatcher
        public boolean matches(@MaybeNull JavaConstant.MethodHandle methodHandle) {
            return methodHandle != null && methodHandle.getOwnerType().getName().equals("java.lang.invoke.LambdaMetafactory");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Origin {
        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SelfCallHandle {
        boolean bound() default true;

        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Source {
        SUBSTITUTED_ELEMENT { // from class: net.bytebuddy.asm.MemberSubstitution.Source.1
            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            @MaybeNull
            public Value argument(int i, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                if (i < generic.size() - (!target.isStaticDispatch() ? 1 : 0)) {
                    return new Value(generic.get((!target.isStaticDispatch() ? 1 : 0) + i), map.get(Integer.valueOf(i + (!target.isStaticDispatch() ? 1 : 0))).intValue());
                }
                return null;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public List<Value> arguments(boolean z, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                int i = 0;
                ArrayList arrayList = new ArrayList(generic.size() - ((z || !target.isStaticDispatch()) ? 0 : 1));
                if (!target.isStaticDispatch() && !z) {
                    i = 1;
                }
                while (i < generic.size()) {
                    arrayList.add(new Value(generic.get(i), map.get(Integer.valueOf(i)).intValue()));
                    i++;
                }
                return arrayList;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription) {
                return methodHandle;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, MethodDescription methodDescription) {
                return (target instanceof Target.ForMember) && sort.isRepresentable(((Target.ForMember) target).getMember());
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription) {
                return sort.resolve(((Target.ForMember) target).getMember(), generic.asErasures(), generic2.asErasure());
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            @MaybeNull
            public Value self(TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                if (target.isStaticDispatch()) {
                    return null;
                }
                return new Value(generic.get(0), map.get(0).intValue());
            }
        },
        ENCLOSING_METHOD { // from class: net.bytebuddy.asm.MemberSubstitution.Source.2
            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            @MaybeNull
            public Value argument(int i, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                if (i >= methodDescription.getParameters().size()) {
                    return null;
                }
                ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(i);
                return new Value(parameterDescription.getType(), parameterDescription.getOffset());
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public List<Value> arguments(boolean z, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                ArrayList arrayList;
                if (!z || methodDescription.isStatic()) {
                    arrayList = new ArrayList(methodDescription.getParameters().size());
                } else {
                    arrayList = new ArrayList(methodDescription.getParameters().size() + 1);
                    arrayList.add(new Value(methodDescription.getDeclaringType().asGenericType(), 0));
                }
                Iterator<?> it = methodDescription.getParameters().iterator();
                while (it.hasNext()) {
                    ParameterDescription parameterDescription = (ParameterDescription) it.next();
                    arrayList.add(new Value(parameterDescription.getType(), parameterDescription.getOffset()));
                }
                return arrayList;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription) {
                return JavaConstant.MethodHandle.of(methodDescription.asDefined());
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, MethodDescription methodDescription) {
                return sort.isRepresentable(methodDescription);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            public StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription) {
                return sort.resolve(methodDescription, (methodDescription.isStatic() || methodDescription.isConstructor()) ? methodDescription.getParameters().asTypeList().asErasures() : CompoundList.of(methodDescription.getDeclaringType().asErasure(), methodDescription.getParameters().asTypeList().asErasures()), methodDescription.isConstructor() ? methodDescription.getDeclaringType().asErasure() : methodDescription.getReturnType().asErasure());
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Source
            @MaybeNull
            public Value self(TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription) {
                if (methodDescription.isStatic()) {
                    return null;
                }
                return new Value(methodDescription.getDeclaringType().asGenericType(), 0);
            }
        };

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Value {
            private final int offset;
            private final TypeDescription.Generic typeDescription;

            public Value(TypeDescription.Generic generic, int i) {
                this.typeDescription = generic;
                this.offset = i;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Value value = (Value) obj;
                return this.offset == value.offset && this.typeDescription.equals(value.typeDescription);
            }

            public int getOffset() {
                return this.offset;
            }

            public TypeDescription.Generic getTypeDescription() {
                return this.typeDescription;
            }

            public int hashCode() {
                return dkz.e(this.typeDescription, getClass().hashCode() * 31, 31) + this.offset;
            }
        }

        @MaybeNull
        public abstract Value argument(int i, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription);

        public abstract List<Value> arguments(boolean z, TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription);

        public abstract JavaConstant.MethodHandle handle(JavaConstant.MethodHandle methodHandle, MethodDescription methodDescription);

        public abstract boolean isRepresentable(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, MethodDescription methodDescription);

        public abstract StackManipulation resolve(Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort sort, Target target, TypeList.Generic generic, TypeDescription.Generic generic2, MethodDescription methodDescription);

        @MaybeNull
        public abstract Value self(TypeList.Generic generic, Map<Integer, Integer> map, Target target, MethodDescription methodDescription);

        /* synthetic */ Source(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface StubValue {
        Source source() default Source.SUBSTITUTED_ELEMENT;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class SubstitutingMethodVisitor extends LocalVariableAwareMethodVisitor {
        private final boolean failIfNoMatch;
        private final Implementation.Context implementationContext;
        private final MethodDescription instrumentedMethod;
        private final TypeDescription instrumentedType;
        private int localVariableExtension;
        private boolean matched;
        private final MethodGraph.Compiler methodGraphCompiler;
        private final Replacement replacement;
        private int stackSizeBuffer;
        private final boolean strict;
        private final TypePool typePool;
        private final boolean virtualPrivateCalls;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public class LocalVariableTracingMethodVisitor extends MethodVisitor {
            public /* synthetic */ LocalVariableTracingMethodVisitor(SubstitutingMethodVisitor substitutingMethodVisitor, MethodVisitor methodVisitor, AnonymousClass1 anonymousClass1) {
                this(methodVisitor);
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitVarInsn(int i, int i2) {
                switch (i) {
                    case 54:
                    case 56:
                    case 58:
                        SubstitutingMethodVisitor substitutingMethodVisitor = SubstitutingMethodVisitor.this;
                        substitutingMethodVisitor.localVariableExtension = Math.max(substitutingMethodVisitor.localVariableExtension, i2 + 1);
                        break;
                    case 55:
                    case 57:
                        SubstitutingMethodVisitor substitutingMethodVisitor2 = SubstitutingMethodVisitor.this;
                        substitutingMethodVisitor2.localVariableExtension = Math.max(substitutingMethodVisitor2.localVariableExtension, i2 + 2);
                        break;
                }
                super.visitVarInsn(i, i2);
            }

            private LocalVariableTracingMethodVisitor(MethodVisitor methodVisitor) {
                super(OpenedClassReader.ASM_API, methodVisitor);
            }
        }

        public SubstitutingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription methodDescription, MethodGraph.Compiler compiler, boolean z, boolean z2, Replacement replacement, Implementation.Context context, TypePool typePool, boolean z3) {
            super(methodVisitor, methodDescription);
            this.instrumentedType = typeDescription;
            this.instrumentedMethod = methodDescription;
            this.methodGraphCompiler = compiler;
            this.strict = z;
            this.failIfNoMatch = z2;
            this.replacement = replacement;
            this.implementationContext = context;
            this.typePool = typePool;
            this.virtualPrivateCalls = z3;
            this.stackSizeBuffer = 0;
            this.localVariableExtension = 0;
        }

        /* JADX WARN: Found duplicated region for block: B:36:0x011b  */
        /* JADX WARN: Found duplicated region for block: B:38:0x012e  */
        /* JADX WARN: Found duplicated region for block: B:40:0x0141  */
        /* JADX WARN: Found duplicated region for block: B:42:0x0152  */
        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitFieldInsn(int i, String str, String str2, String str3) {
            FieldList fieldListFilter;
            TypeList.Generic empty;
            TypeDescription.Generic type;
            TypeList.Generic.Explicit explicit;
            TypeDescription.Generic genericOf;
            TypeList.Generic generic;
            TypeDescription.Generic generic2;
            TypePool.Resolution resolutionDescribe = this.typePool.describe(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
            if (resolutionDescribe.isResolved()) {
                Iterator<TypeDefinition> it = resolutionDescribe.resolve().iterator();
                do {
                    fieldListFilter = it.next().getDeclaredFields().filter(this.strict ? ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                    if (!it.hasNext()) {
                        break;
                    }
                } while (fieldListFilter.isEmpty());
                if (!fieldListFilter.isEmpty()) {
                    boolean z = false;
                    Replacement.Binding bindingBind = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, resolutionDescribe.resolve(), (FieldDescription) fieldListFilter.getOnly(), i == 181 || i == 179);
                    if (bindingBind.isBound()) {
                        Class cls = Void.TYPE;
                        switch (i) {
                            case 178:
                                empty = new TypeList.Generic.Empty();
                                type = ((FieldDescription) fieldListFilter.getOnly()).getType();
                                generic = empty;
                                generic2 = type;
                                z = true;
                                this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bindingBind.make(generic, generic2, z ? JavaConstant.MethodHandle.ofGetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()) : JavaConstant.MethodHandle.ofSetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()), z ? FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).read() : FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).write(), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, null), this.implementationContext).getMaximalSize());
                                this.matched = true;
                                return;
                            case 179:
                                explicit = new TypeList.Generic.Explicit(((FieldDescription) fieldListFilter.getOnly()).getType());
                                genericOf = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls);
                                generic = explicit;
                                generic2 = genericOf;
                                this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bindingBind.make(generic, generic2, z ? JavaConstant.MethodHandle.ofGetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()) : JavaConstant.MethodHandle.ofSetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()), z ? FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).read() : FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).write(), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, null), this.implementationContext).getMaximalSize());
                                this.matched = true;
                                return;
                            case 180:
                                empty = new TypeList.Generic.Explicit(((FieldDescription) fieldListFilter.getOnly()).getDeclaringType());
                                type = ((FieldDescription) fieldListFilter.getOnly()).getType();
                                generic = empty;
                                generic2 = type;
                                z = true;
                                this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bindingBind.make(generic, generic2, z ? JavaConstant.MethodHandle.ofGetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()) : JavaConstant.MethodHandle.ofSetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()), z ? FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).read() : FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).write(), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, null), this.implementationContext).getMaximalSize());
                                this.matched = true;
                                return;
                            case 181:
                                explicit = new TypeList.Generic.Explicit(((FieldDescription) fieldListFilter.getOnly()).getDeclaringType(), ((FieldDescription) fieldListFilter.getOnly()).getType());
                                genericOf = TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(cls);
                                generic = explicit;
                                generic2 = genericOf;
                                this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bindingBind.make(generic, generic2, z ? JavaConstant.MethodHandle.ofGetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()) : JavaConstant.MethodHandle.ofSetter(((FieldDescription) fieldListFilter.getOnly()).asDefined()), z ? FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).read() : FieldAccess.forField((FieldDescription) fieldListFilter.getOnly()).write(), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, null), this.implementationContext).getMaximalSize());
                                this.matched = true;
                                return;
                            default:
                                throw new IllegalStateException(bjs.i(i, "Unexpected opcode: "));
                        }
                    }
                } else if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) + "." + str2 + str3 + " using " + this.typePool);
                }
            } else if (this.strict) {
                throw new IllegalStateException("Could not resolve " + str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) + " using " + this.typePool);
            }
            super.visitFieldInsn(i, str, str2, str3);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitInvokeDynamicInsn(String str, String str2, net.bytebuddy.jar.asm.Handle handle, Object... objArr) {
            JavaConstant.MethodType methodType;
            JavaConstant.MethodHandle methodHandle;
            ArrayList arrayList = new ArrayList(objArr.length);
            AnonymousClass1 anonymousClass1 = null;
            try {
                try {
                    JavaConstant.MethodHandle methodHandleOfAsm = JavaConstant.MethodHandle.ofAsm(this.typePool, handle);
                    JavaConstant.MethodType methodTypeOfAsm = JavaConstant.MethodType.ofAsm(this.typePool, Type.getMethodType(str2));
                    for (Object obj : objArr) {
                        arrayList.add(JavaConstant.Simple.ofAsm(this.typePool, obj));
                    }
                    methodHandle = methodHandleOfAsm;
                    methodType = methodTypeOfAsm;
                } catch (TypePool.Resolution.NoSuchTypeException e) {
                    e = e;
                    if (this.strict) {
                        throw new IllegalStateException("Could not resolve " + e.getName() + " using " + this.typePool);
                    }
                    methodType = null;
                    methodHandle = null;
                }
            } catch (TypePool.Resolution.NoSuchTypeException e2) {
                e = e2;
            }
            if (methodHandle != null && methodType != null && arrayList.size() == objArr.length) {
                Replacement.Binding bindingBind = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, methodHandle, methodType, str, arrayList);
                if (bindingBind.isBound()) {
                    this.stackSizeBuffer = Math.max(this.stackSizeBuffer, bindingBind.make(methodType.getParameterTypes().asGenericTypes(), methodType.getReturnType().asGenericType(), methodHandle, new Invokedynamic(str, methodType, methodHandle, arrayList), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, anonymousClass1), this.implementationContext).getMaximalSize());
                    this.matched = true;
                    return;
                }
            }
            super.visitInvokeDynamicInsn(str, str2, handle, objArr);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitMaxs(int i, int i2) {
            if (!this.failIfNoMatch || this.matched) {
                super.visitMaxs(i + this.stackSizeBuffer, Math.max(this.localVariableExtension, i2));
                return;
            }
            throw new IllegalStateException("No substitution found within " + this.instrumentedMethod + " of " + this.instrumentedType);
        }

        @Override // net.bytebuddy.jar.asm.MethodVisitor
        public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
            MethodList methodListFilter;
            MethodList methodList;
            TypePool.Resolution resolutionDescribe = this.typePool.describe(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
            if (resolutionDescribe.isResolved()) {
                if (i == 183 && str2.equals(MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) {
                    methodListFilter = resolutionDescribe.resolve().getDeclaredMethods().filter(this.strict ? ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.isConstructor().and(ElementMatchers.hasDescriptor(str3))));
                } else if (i == 184) {
                    Iterator<TypeDefinition> it = resolutionDescribe.resolve().iterator();
                    do {
                        methodList = (MethodList) it.next().getDeclaredMethods().filter(this.strict ? ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                        if (!it.hasNext()) {
                            break;
                        }
                    } while (methodList.isEmpty());
                    methodListFilter = methodList;
                } else if (i == 183) {
                    methodListFilter = resolutionDescribe.resolve().getDeclaredMethods().filter(this.strict ? ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                } else if (this.virtualPrivateCalls) {
                    methodListFilter = resolutionDescribe.resolve().getDeclaredMethods().filter(this.strict ? ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))) : ElementMatchers.failSafe(ElementMatchers.isPrivate().and(ElementMatchers.not(ElementMatchers.isStatic())).and(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)))));
                    if (methodListFilter.isEmpty()) {
                        methodListFilter = (MethodList) this.methodGraphCompiler.compile((TypeDefinition) resolutionDescribe.resolve(), this.instrumentedType).listNodes().asMethodList().filter(this.strict ? ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                    }
                } else {
                    methodListFilter = this.methodGraphCompiler.compile((TypeDefinition) resolutionDescribe.resolve(), this.instrumentedType).listNodes().asMethodList().filter(this.strict ? ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3)) : ElementMatchers.failSafe(ElementMatchers.named(str2).and(ElementMatchers.hasDescriptor(str3))));
                }
                if (!methodListFilter.isEmpty()) {
                    Replacement.Binding bindingBind = this.replacement.bind(this.instrumentedType, this.instrumentedMethod, resolutionDescribe.resolve(), (MethodDescription) methodListFilter.getOnly(), Replacement.InvocationType.of(i, (MethodDescription) methodListFilter.getOnly()));
                    if (bindingBind.isBound()) {
                        StackManipulation.Size sizeApply = bindingBind.make((((MethodDescription) methodListFilter.getOnly()).isStatic() || ((MethodDescription) methodListFilter.getOnly()).isConstructor()) ? ((MethodDescription) methodListFilter.getOnly()).getParameters().asTypeList() : new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(resolutionDescribe.resolve(), ((MethodDescription) methodListFilter.getOnly()).getParameters().asTypeList())), ((MethodDescription) methodListFilter.getOnly()).isConstructor() ? ((MethodDescription) methodListFilter.getOnly()).getDeclaringType().asGenericType() : ((MethodDescription) methodListFilter.getOnly()).getReturnType(), (i == 183 && ((MethodDescription) methodListFilter.getOnly()).isMethod() && !((MethodDescription) methodListFilter.getOnly()).isPrivate()) ? JavaConstant.MethodHandle.ofSpecial(((MethodDescription) methodListFilter.getOnly()).asDefined(), resolutionDescribe.resolve()) : JavaConstant.MethodHandle.of(((MethodDescription) methodListFilter.getOnly()).asDefined()), (i == 183 && ((MethodDescription) methodListFilter.getOnly()).isMethod() && !((MethodDescription) methodListFilter.getOnly()).isPrivate()) ? MethodInvocation.invoke((MethodDescription) methodListFilter.getOnly()).special(resolutionDescribe.resolve()) : MethodInvocation.invoke((MethodDescription) methodListFilter.getOnly()), getFreeOffset()).apply(new LocalVariableTracingMethodVisitor(this, this.mv, null), this.implementationContext);
                        if (((MethodDescription) methodListFilter.getOnly()).isConstructor()) {
                            int iMax = Math.max(this.stackSizeBuffer, sizeApply.getMaximalSize() + 2);
                            this.stackSizeBuffer = iMax;
                            Duplication duplication = Duplication.SINGLE;
                            StackManipulation stackManipulationFlipOver = duplication.flipOver(TypeDescription.ForLoadedType.of(Object.class));
                            StackManipulation stackManipulationFlipOver2 = duplication.flipOver(TypeDescription.ForLoadedType.of(Object.class));
                            Removal removal = Removal.SINGLE;
                            this.stackSizeBuffer = Math.max(iMax, StackSize.SINGLE.getSize() + new StackManipulation.Compound(stackManipulationFlipOver, removal, removal, stackManipulationFlipOver2, removal, removal).apply(this.mv, this.implementationContext).getMaximalSize());
                        } else {
                            this.stackSizeBuffer = Math.max(this.stackSizeBuffer, sizeApply.getMaximalSize());
                        }
                        this.matched = true;
                        return;
                    }
                } else if (this.strict) {
                    throw new IllegalStateException("Could not resolve " + str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) + "." + str2 + str3 + " using " + this.typePool);
                }
            } else if (this.strict) {
                throw new IllegalStateException("Could not resolve " + str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) + " using " + this.typePool);
            }
            super.visitMethodInsn(i, str, str2, str3, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Substitution<T extends Target> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Chain<S extends Target> implements Substitution<S> {
            private final Assigner assigner;
            private final List<Step<? super S>> steps;
            private final Assigner.Typing typing;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory<U extends Target> implements Factory<U> {
                private final Assigner assigner;
                private final List<Step.Factory<? super U>> steps;
                private final Assigner.Typing typing;

                public Factory(Assigner assigner, Assigner.Typing typing, List<Step.Factory<? super U>> list) {
                    this.assigner = assigner;
                    this.typing = typing;
                    this.steps = list;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.typing.equals(factory.typing) && this.assigner.equals(factory.assigner) && this.steps.equals(factory.steps);
                }

                @SafeVarargs
                @SafeVarargsPlugin.Enhance
                public final Factory<U> executing(Step.Factory<? super U>... factoryArr) {
                    return executing(Arrays.asList(factoryArr));
                }

                public int hashCode() {
                    return this.steps.hashCode() + ((this.typing.hashCode() + dkz.h(this.assigner, getClass().hashCode() * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<? super U> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    if (this.steps.isEmpty()) {
                        return Stubbing.INSTANCE;
                    }
                    ArrayList arrayList = new ArrayList(this.steps.size());
                    Iterator<Step.Factory<? super U>> it = this.steps.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().make(this.assigner, this.typing, typeDescription, methodDescription));
                    }
                    return new Chain(this.assigner, this.typing, arrayList);
                }

                public Factory<U> executing(List<? extends Step.Factory<? super U>> list) {
                    return new Factory<>(this.assigner, this.typing, CompoundList.of((List) this.steps, (List) list));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Step<U extends Target> {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Factory<V extends Target> {
                    Step<V> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription);
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForArgumentLoading implements Step<Target>, Factory<Target> {
                    private final int index;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class OfInstrumentedMethod implements Factory<Target> {
                        private final int index;

                        public OfInstrumentedMethod(int i) {
                            this.index = i;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.index == ((OfInstrumentedMethod) obj).index;
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.index;
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            if (methodDescription.getParameters().size() >= this.index) {
                                ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(this.index);
                                return new Simple(MethodVariableAccess.load(parameterDescription), parameterDescription.getType());
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(methodDescription);
                            sb.append(" does not declare ");
                            throw new IllegalStateException(yg.m(sb, " parameters", this.index));
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public enum OfInstrumentedMethodThis implements Factory<Target> {
                        INSTANCE;

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            if (!methodDescription.isStatic()) {
                                return new Simple(MethodVariableAccess.loadThis(), typeDescription.asGenericType());
                            }
                            throw new IllegalStateException(methodDescription + " is static and does not define a this reference");
                        }
                    }

                    public ForArgumentLoading(int i) {
                        this.index = i;
                    }

                    public static Factory<Target> ofInstrumentedMethod(int i) {
                        if (i >= 0) {
                            return new OfInstrumentedMethod(i);
                        }
                        throw new IllegalArgumentException(bjs.i(i, "Argument index cannot be negative: "));
                    }

                    public static Factory<Target> ofTarget(int i) {
                        if (i >= 0) {
                            return new ForArgumentLoading(i);
                        }
                        throw new IllegalArgumentException(bjs.i(i, "Argument index cannot be negative: "));
                    }

                    public static Factory<Target> ofThis() {
                        return OfInstrumentedMethodThis.INSTANCE;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((ForArgumentLoading) obj).index;
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.index;
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                    public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        if (this.index < generic.size()) {
                            return new Simple(new StackManipulation.Compound(Removal.of(generic3), MethodVariableAccess.of(generic.get(this.index)).loadFrom(map.get(Integer.valueOf(this.index)).intValue())), generic.get(this.index));
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(target);
                        sb.append(" has not ");
                        throw new IllegalStateException(yg.m(sb, " arguments", this.index));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForArgumentSubstitution implements Step<Target> {
                    private final Assigner assigner;
                    private final int index;
                    private final StackManipulation substitution;
                    private final TypeDescription.Generic typeDescription;
                    private final Assigner.Typing typing;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory<Target> {
                        private final int index;
                        private final StackManipulation stackManipulation;
                        private final TypeDescription.Generic typeDescription;

                        public Factory(StackManipulation stackManipulation, java.lang.reflect.Type type, int i) {
                            this(stackManipulation, TypeDefinition.Sort.describe(type), i);
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.index == factory.index && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                        }

                        public int hashCode() {
                            return dkz.e(this.typeDescription, dkz.g(this.stackManipulation, getClass().hashCode() * 31, 31), 31) + this.index;
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            return new ForArgumentSubstitution(this.stackManipulation, this.typeDescription, this.index, assigner, typing);
                        }

                        public Factory(StackManipulation stackManipulation, TypeDescription.Generic generic, int i) {
                            this.stackManipulation = stackManipulation;
                            this.typeDescription = generic;
                            this.index = i;
                        }
                    }

                    public ForArgumentSubstitution(StackManipulation stackManipulation, TypeDescription.Generic generic, int i, Assigner assigner, Assigner.Typing typing) {
                        this.substitution = stackManipulation;
                        this.typeDescription = generic;
                        this.index = i;
                        this.assigner = assigner;
                        this.typing = typing;
                    }

                    public static Factory<Target> of(Object obj, int i) {
                        if (i < 0) {
                            throw new IllegalArgumentException(bjs.i(i, "Index cannot be negative: "));
                        }
                        ConstantValue constantValueWrap = ConstantValue.Simple.wrap(obj);
                        return new Factory(constantValueWrap.toStackManipulation(), constantValueWrap.getTypeDescription().asGenericType(), i);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForArgumentSubstitution forArgumentSubstitution = (ForArgumentSubstitution) obj;
                        return this.index == forArgumentSubstitution.index && this.typing.equals(forArgumentSubstitution.typing) && this.substitution.equals(forArgumentSubstitution.substitution) && this.typeDescription.equals(forArgumentSubstitution.typeDescription) && this.assigner.equals(forArgumentSubstitution.assigner);
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + dkz.h(this.assigner, (dkz.e(this.typeDescription, dkz.g(this.substitution, getClass().hashCode() * 31, 31), 31) + this.index) * 31, 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        if (this.index >= generic.size()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(target);
                            sb.append(" has not ");
                            throw new IllegalStateException(yg.m(sb, " arguments", this.index));
                        }
                        StackManipulation stackManipulationAssign = this.assigner.assign(this.typeDescription, generic.get(this.index), this.typing);
                        if (stackManipulationAssign.isValid()) {
                            return new Simple(new StackManipulation.Compound(this.substitution, stackManipulationAssign, MethodVariableAccess.of(generic.get(this.index)).storeAt(map.get(Integer.valueOf(this.index)).intValue())), generic3);
                        }
                        throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + generic.get(this.index));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForAssignment implements Step<Target> {
                    private final Assigner assigner;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final TypeDescription.Generic result;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory<Target> {

                        @MaybeNull
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final TypeDescription.Generic result;

                        public Factory(@MaybeNull TypeDescription.Generic generic) {
                            this.result = generic;
                        }

                        /* JADX WARN: Found duplicated region for block: B:19:0x0027 A[RETURN] */
                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            TypeDescription.Generic generic = this.result;
                            TypeDescription.Generic generic2 = ((Factory) obj).result;
                            if (generic2 != null) {
                                return generic != null && generic.equals(generic2);
                            }
                            if (generic != null) {
                                return false;
                            }
                        }

                        public int hashCode() {
                            int iHashCode = getClass().hashCode() * 31;
                            TypeDescription.Generic generic = this.result;
                            return generic != null ? generic.hashCode() + iHashCode : iHashCode;
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            return new ForAssignment(this.result, assigner);
                        }
                    }

                    public ForAssignment(@MaybeNull TypeDescription.Generic generic, Assigner assigner) {
                        this.result = generic;
                        this.assigner = assigner;
                    }

                    public static Factory<Target> castTo(java.lang.reflect.Type type) {
                        return new Factory(TypeDefinition.Sort.describe(type));
                    }

                    public static Factory<Target> castToSubstitutionResult() {
                        return new Factory(null);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                    
                        if (r2 != null) goto L18;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                        /*
                            r4 = this;
                            r0 = 1
                            if (r4 != r5) goto L4
                            return r0
                        L4:
                            r1 = 0
                            if (r5 != 0) goto L8
                            return r1
                        L8:
                            java.lang.Class r2 = r4.getClass()
                            java.lang.Class r3 = r5.getClass()
                            if (r2 == r3) goto L13
                            return r1
                        L13:
                            net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.result
                            net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForAssignment r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment) r5
                            net.bytebuddy.description.type.TypeDescription$Generic r3 = r5.result
                            if (r3 == 0) goto L24
                            if (r2 == 0) goto L26
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L27
                            return r1
                        L24:
                            if (r2 == 0) goto L27
                        L26:
                            return r1
                        L27:
                            net.bytebuddy.implementation.bytecode.assign.Assigner r2 = r4.assigner
                            net.bytebuddy.implementation.bytecode.assign.Assigner r5 = r5.assigner
                            boolean r5 = r2.equals(r5)
                            if (r5 != 0) goto L32
                            return r1
                        L32:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForAssignment.equals(java.lang.Object):boolean");
                    }

                    public int hashCode() {
                        int iHashCode = getClass().hashCode() * 31;
                        TypeDescription.Generic generic = this.result;
                        if (generic != null) {
                            iHashCode += generic.hashCode();
                        }
                        return this.assigner.hashCode() + (iHashCode * 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        Assigner assigner = this.assigner;
                        TypeDescription.Generic generic4 = this.result;
                        if (generic4 == null) {
                            generic4 = generic2;
                        }
                        StackManipulation stackManipulationAssign = assigner.assign(generic3, generic4, Assigner.Typing.DYNAMIC);
                        if (stackManipulationAssign.isValid()) {
                            TypeDescription.Generic generic5 = this.result;
                            if (generic5 != null) {
                                generic2 = generic5;
                            }
                            return new Simple(stackManipulationAssign, generic2);
                        }
                        StringBuilder sb = new StringBuilder("Failed to assign ");
                        sb.append(generic3);
                        sb.append(" to ");
                        TypeDescription.Generic generic6 = this.result;
                        if (generic6 != null) {
                            generic2 = generic6;
                        }
                        sb.append(generic2);
                        throw new IllegalStateException(sb.toString());
                    }

                    public static Factory<Target> castTo(TypeDescription.Generic generic) {
                        return new Factory(generic);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForDelegation implements Step<Target> {
                    private final Dispatcher.Resolved dispatcher;
                    private final List<OffsetMapping.Resolved> offsetMappings;
                    private final TypeDescription.Generic returned;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface BootstrapArgumentResolver {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Factory {
                            BootstrapArgumentResolver make(MethodDescription.InDefinedShape inDefinedShape);
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForDefaultValues implements BootstrapArgumentResolver {
                            private final MethodDescription.InDefinedShape delegate;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory {
                                INSTANCE;

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.BootstrapArgumentResolver.Factory
                                public BootstrapArgumentResolver make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForDefaultValues(inDefinedShape);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final MethodDescription.InDefinedShape delegate;
                                private final MethodDescription instrumentedMethod;
                                private final TypeDescription instrumentedType;

                                public Resolved(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodDescription methodDescription) {
                                    this.delegate = inDefinedShape;
                                    this.instrumentedType = typeDescription;
                                    this.instrumentedMethod = methodDescription;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.delegate.equals(resolved.delegate) && this.instrumentedType.equals(resolved.instrumentedType) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + dkz.f(this.instrumentedType, dkz.b(this.delegate, getClass().hashCode() * 31, 31), 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.BootstrapArgumentResolver.Resolved
                                public List<JavaConstant> make(Target target, JavaConstant.MethodHandle methodHandle) {
                                    boolean zIsTypeInitializer = this.instrumentedMethod.isTypeInitializer();
                                    Class cls = Void.TYPE;
                                    if (zIsTypeInitializer) {
                                        return Arrays.asList(JavaConstant.Simple.ofLoaded(this.delegate.getDeclaringType().getName()), JavaConstant.Simple.of(target instanceof Target.ForMember ? ((Target.ForMember) target).getReceiverType() : TypeDescription.ForLoadedType.of(cls)), JavaConstant.Simple.ofLoaded(target.getName()), methodHandle, JavaConstant.Simple.of(this.instrumentedType), JavaConstant.Simple.ofLoaded(this.instrumentedMethod.getInternalName()));
                                    }
                                    return Arrays.asList(JavaConstant.Simple.ofLoaded(this.delegate.getDeclaringType().getName()), JavaConstant.Simple.of(target instanceof Target.ForMember ? ((Target.ForMember) target).getReceiverType() : TypeDescription.ForLoadedType.of(cls)), JavaConstant.Simple.ofLoaded(target.getName()), methodHandle, JavaConstant.Simple.of(this.instrumentedType), JavaConstant.Simple.ofLoaded(this.instrumentedMethod.getInternalName()), JavaConstant.MethodHandle.of(this.instrumentedMethod.asDefined()));
                                }
                            }

                            public ForDefaultValues(MethodDescription.InDefinedShape inDefinedShape) {
                                this.delegate = inDefinedShape;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((ForDefaultValues) obj).delegate);
                            }

                            public int hashCode() {
                                return this.delegate.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.BootstrapArgumentResolver
                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.delegate, typeDescription, methodDescription);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Resolved {
                            List<JavaConstant> make(Target target, JavaConstant.MethodHandle methodHandle);
                        }

                        Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface Dispatcher {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Factory {
                            Dispatcher make(MethodDescription.InDefinedShape inDefinedShape);
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForDynamicInvocation implements Dispatcher {
                            private final MethodDescription.InDefinedShape bootstrapMethod;
                            private final MethodDescription.InDefinedShape delegate;
                            private final BootstrapArgumentResolver resolver;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Factory implements Factory {
                                private final MethodDescription.InDefinedShape bootstrapMethod;
                                private final BootstrapArgumentResolver.Factory resolverFactory;

                                public Factory(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                                    this.bootstrapMethod = inDefinedShape;
                                    this.resolverFactory = factory;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Factory factory = (Factory) obj;
                                    return this.bootstrapMethod.equals(factory.bootstrapMethod) && this.resolverFactory.equals(factory.resolverFactory);
                                }

                                public int hashCode() {
                                    return this.resolverFactory.hashCode() + dkz.b(this.bootstrapMethod, getClass().hashCode() * 31, 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Factory
                                public Dispatcher make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForDynamicInvocation(this.bootstrapMethod, inDefinedShape, this.resolverFactory.make(inDefinedShape));
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final MethodDescription.InDefinedShape bootstrapMethod;
                                private final MethodDescription.InDefinedShape delegate;
                                private final BootstrapArgumentResolver.Resolved resolver;

                                public Resolved(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2, BootstrapArgumentResolver.Resolved resolved) {
                                    this.bootstrapMethod = inDefinedShape;
                                    this.delegate = inDefinedShape2;
                                    this.resolver = resolved;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Resolved
                                public StackManipulation apply(Target target, JavaConstant.MethodHandle methodHandle) {
                                    List<JavaConstant> listMake = this.resolver.make(target, methodHandle);
                                    if (this.bootstrapMethod.isInvokeBootstrap(TypeList.Explicit.of((List<? extends JavaConstant>) listMake))) {
                                        return MethodInvocation.invoke(this.bootstrapMethod).dynamic(this.delegate.getInternalName(), this.delegate.getReturnType().asErasure(), this.delegate.getParameters().asTypeList().asErasures(), listMake);
                                    }
                                    throw new IllegalArgumentException(this.bootstrapMethod + " is not accepting advice bootstrap arguments: " + listMake);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.bootstrapMethod.equals(resolved.bootstrapMethod) && this.delegate.equals(resolved.delegate) && this.resolver.equals(resolved.resolver);
                                }

                                public int hashCode() {
                                    return this.resolver.hashCode() + dkz.b(this.delegate, dkz.b(this.bootstrapMethod, getClass().hashCode() * 31, 31), 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Resolved
                                public StackManipulation initialize() {
                                    return StackManipulation.Trivial.INSTANCE;
                                }
                            }

                            public ForDynamicInvocation(MethodDescription.InDefinedShape inDefinedShape, MethodDescription.InDefinedShape inDefinedShape2, BootstrapArgumentResolver bootstrapArgumentResolver) {
                                this.bootstrapMethod = inDefinedShape;
                                this.delegate = inDefinedShape2;
                                this.resolver = bootstrapArgumentResolver;
                            }

                            public static Factory of(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                                if (inDefinedShape.isInvokeBootstrap()) {
                                    return new Factory(inDefinedShape, factory);
                                }
                                throw new IllegalStateException("Not a bootstrap method: " + inDefinedShape);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                                return this.bootstrapMethod.equals(forDynamicInvocation.bootstrapMethod) && this.delegate.equals(forDynamicInvocation.delegate) && this.resolver.equals(forDynamicInvocation.resolver);
                            }

                            public int hashCode() {
                                return this.resolver.hashCode() + dkz.b(this.delegate, dkz.b(this.bootstrapMethod, getClass().hashCode() * 31, 31), 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher
                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.bootstrapMethod, this.delegate, this.resolver.resolve(typeDescription, methodDescription));
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForRegularInvocation implements Dispatcher, Resolved {
                            private final MethodDescription delegate;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory {
                                INSTANCE;

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Factory
                                public Dispatcher make(MethodDescription.InDefinedShape inDefinedShape) {
                                    return new ForRegularInvocation(inDefinedShape);
                                }
                            }

                            public ForRegularInvocation(MethodDescription methodDescription) {
                                this.delegate = methodDescription;
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Resolved
                            public StackManipulation apply(Target target, JavaConstant.MethodHandle methodHandle) {
                                return MethodInvocation.invoke(this.delegate);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((ForRegularInvocation) obj).delegate);
                            }

                            public int hashCode() {
                                return this.delegate.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher.Resolved
                            public StackManipulation initialize() {
                                return this.delegate.isConstructor() ? new StackManipulation.Compound(TypeCreation.of(this.delegate.getDeclaringType().asErasure()), Duplication.SINGLE) : StackManipulation.Trivial.INSTANCE;
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.Dispatcher
                            public Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                return this;
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Resolved {
                            StackManipulation apply(Target target, JavaConstant.MethodHandle methodHandle);

                            StackManipulation initialize();
                        }

                        Resolved resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory<Target> {
                        private final MethodDescription.InDefinedShape delegate;
                        private final Dispatcher dispatcher;
                        private final List<OffsetMapping> offsetMappings;

                        public Factory(MethodDescription.InDefinedShape inDefinedShape, Dispatcher dispatcher, List<? extends OffsetMapping.Factory<?>> list) {
                            HashMap map = new HashMap();
                            for (OffsetMapping.Factory<?> factory : list) {
                                map.put(TypeDescription.ForLoadedType.of(factory.getAnnotationType()), factory);
                            }
                            this.offsetMappings = new ArrayList(list.size());
                            if (inDefinedShape.isMethod() && !inDefinedShape.isStatic()) {
                                OffsetMapping offsetMapping = null;
                                for (AnnotationDescription annotationDescription : inDefinedShape.getDeclaredAnnotations()) {
                                    OffsetMapping.Factory factory2 = (OffsetMapping.Factory) map.get(annotationDescription.getAnnotationType());
                                    if (factory2 != null) {
                                        OffsetMapping offsetMappingMake = factory2.make(inDefinedShape, annotationDescription.prepare(factory2.getAnnotationType()));
                                        if (offsetMapping != null) {
                                            throw new IllegalStateException(inDefinedShape + " is bound to both " + offsetMappingMake + " and " + offsetMapping);
                                        }
                                        offsetMapping = offsetMappingMake;
                                    }
                                }
                                this.offsetMappings.add(offsetMapping == null ? new OffsetMapping.ForThisReference(inDefinedShape.getDeclaringType().asGenericType(), null, Source.SUBSTITUTED_ELEMENT, false) : offsetMapping);
                            }
                            for (int i = 0; i < inDefinedShape.getParameters().size(); i++) {
                                ParameterDescription.InDefinedShape inDefinedShape2 = inDefinedShape.getParameters().get(i);
                                OffsetMapping forArgument = null;
                                for (AnnotationDescription annotationDescription2 : inDefinedShape2.getDeclaredAnnotations()) {
                                    OffsetMapping.Factory factory3 = (OffsetMapping.Factory) map.get(annotationDescription2.getAnnotationType());
                                    if (factory3 != null) {
                                        OffsetMapping offsetMappingMake2 = factory3.make(inDefinedShape2, annotationDescription2.prepare(factory3.getAnnotationType()));
                                        if (forArgument != null) {
                                            throw new IllegalStateException(inDefinedShape2 + " is bound to both " + offsetMappingMake2 + " and " + forArgument);
                                        }
                                        forArgument = offsetMappingMake2;
                                    }
                                }
                                List<OffsetMapping> list2 = this.offsetMappings;
                                if (forArgument == null) {
                                    forArgument = new OffsetMapping.ForArgument(inDefinedShape2.getType(), i, null, Source.SUBSTITUTED_ELEMENT, false);
                                }
                                list2.add(forArgument);
                            }
                            this.delegate = inDefinedShape;
                            this.dispatcher = dispatcher;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.delegate.equals(factory.delegate) && this.dispatcher.equals(factory.dispatcher) && this.offsetMappings.equals(factory.offsetMappings);
                        }

                        public int hashCode() {
                            return this.offsetMappings.hashCode() + ((this.dispatcher.hashCode() + dkz.b(this.delegate, getClass().hashCode() * 31, 31)) * 31);
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            ArrayList arrayList = new ArrayList(this.offsetMappings.size());
                            Iterator<OffsetMapping> it = this.offsetMappings.iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().resolve(assigner, typing, typeDescription, methodDescription));
                            }
                            return new ForDelegation(this.delegate.getReturnType(), this.dispatcher.resolve(typeDescription, methodDescription), arrayList);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class WithCustomMapping {
                        private final Dispatcher.Factory dispatcherFactory;
                        private final Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> offsetMappings;

                        public WithCustomMapping(Dispatcher.Factory factory, Map<Class<? extends Annotation>, OffsetMapping.Factory<?>> map) {
                            this.dispatcherFactory = factory;
                            this.offsetMappings = map;
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, @MaybeNull Object obj) {
                            return bind(OffsetMapping.ForStackManipulation.of(cls, obj));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, Object... objArr) {
                            return bindDynamic(cls, method, Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2) {
                            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2));
                        }

                        public <T extends Annotation> WithCustomMapping bindProperty(Class<T> cls, String str) {
                            return bind(OffsetMapping.ForStackManipulation.OfAnnotationProperty.of(cls, str));
                        }

                        public <T extends Annotation> WithCustomMapping bindSerialized(Class<T> cls, Serializable serializable) {
                            return bindSerialized(cls, serializable, serializable.getClass());
                        }

                        public WithCustomMapping bootstrap(Constructor<?> constructor) {
                            return bootstrap(new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public Factory<Target> to(Method method) {
                            return to(new MethodDescription.ForLoadedMethod(method));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Field field) {
                            return bind((Class) cls, (FieldDescription) new FieldDescription.ForLoadedField(field));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Method method, List<?> list) {
                            return bindDynamic(cls, new MethodDescription.ForLoadedMethod(method), list);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Constructor<?> constructor, Class<?> cls2, MethodGraph.Compiler compiler) {
                            return bindLambda(cls, new MethodDescription.ForLoadedConstructor(constructor), TypeDescription.ForLoadedType.of(cls2), compiler);
                        }

                        /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/annotation/Annotation;S::Ljava/io/Serializable;>(Ljava/lang/Class<TT;>;TS;Ljava/lang/Class<-TS;>;)Lnet/bytebuddy/asm/MemberSubstitution$Substitution$Chain$Step$ForDelegation$WithCustomMapping; */
                        public WithCustomMapping bindSerialized(Class cls, Serializable serializable, Class cls2) {
                            return bind(OffsetMapping.ForStackManipulation.OfSerializedConstant.of(cls, serializable, cls2));
                        }

                        public WithCustomMapping bootstrap(Constructor<?> constructor, BootstrapArgumentResolver.Factory factory) {
                            return bootstrap(new MethodDescription.ForLoadedConstructor(constructor), factory);
                        }

                        public Factory<Target> to(Constructor<?> constructor) {
                            return to(new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, FieldDescription fieldDescription) {
                            return bind(new OffsetMapping.ForField.Resolved.Factory(cls, fieldDescription));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, Object... objArr) {
                            return bindDynamic(cls, constructor, Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2) {
                            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2));
                        }

                        public WithCustomMapping bootstrap(Method method) {
                            return bootstrap(new MethodDescription.ForLoadedMethod(method));
                        }

                        public Factory<Target> to(MethodDescription.InDefinedShape inDefinedShape) {
                            return ForDelegation.to(inDefinedShape, this.dispatcherFactory, new ArrayList(this.offsetMappings.values()));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Class<?> cls2) {
                            return bind((Class) cls, TypeDescription.ForLoadedType.of(cls2));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, Constructor<?> constructor, List<?> list) {
                            return bindDynamic(cls, new MethodDescription.ForLoadedConstructor(constructor), list);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, Method method, Class<?> cls2, MethodGraph.Compiler compiler) {
                            return bindLambda(cls, new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.of(cls2), compiler);
                        }

                        public WithCustomMapping bootstrap(Method method, BootstrapArgumentResolver.Factory factory) {
                            return bootstrap(new MethodDescription.ForLoadedMethod(method), factory);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, TypeDescription typeDescription) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, ConstantValue.Simple.wrap(typeDescription)));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, Object... objArr) {
                            return bindDynamic(cls, inDefinedShape, Arrays.asList(objArr));
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
                            return bindLambda(cls, inDefinedShape, typeDescription, MethodGraph.Compiler.DEFAULT);
                        }

                        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape) {
                            return bootstrap(inDefinedShape, BootstrapArgumentResolver.ForDefaultValues.Factory.INSTANCE);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, Enum<?> r3) {
                            return bind((Class) cls, (EnumerationDescription) new EnumerationDescription.ForLoadedEnumeration(r3));
                        }

                        public <T extends Annotation> WithCustomMapping bindDynamic(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<?> list) {
                            List<JavaConstant> listWrap = JavaConstant.Simple.wrap(list);
                            if (inDefinedShape.isInvokeBootstrap(TypeList.Explicit.of((List<? extends JavaConstant>) listWrap))) {
                                return bind(new OffsetMapping.ForStackManipulation.OfDynamicInvocation(cls, inDefinedShape, listWrap));
                            }
                            throw new IllegalArgumentException("Not a valid bootstrap method " + inDefinedShape + " for " + listWrap);
                        }

                        public <T extends Annotation> WithCustomMapping bindLambda(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription, MethodGraph.Compiler compiler) {
                            if (typeDescription.isInterface()) {
                                MethodList methodListFilter = compiler.compile((TypeDefinition) typeDescription).listNodes().asMethodList().filter(ElementMatchers.isAbstract());
                                if (methodListFilter.size() == 1) {
                                    TypeDescription.Latent latent = new TypeDescription.Latent("java.lang.invoke.LambdaMetafactory", 1, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class), new TypeDescription.Generic[0]);
                                    List list = Collections.EMPTY_LIST;
                                    TypeDescription.Generic genericAsGenericType = JavaType.CALL_SITE.getTypeStub().asGenericType();
                                    ParameterDescription.Token token = new ParameterDescription.Token(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType());
                                    ParameterDescription.Token token2 = new ParameterDescription.Token(TypeDescription.ForLoadedType.of(String.class).asGenericType());
                                    JavaType javaType = JavaType.METHOD_TYPE;
                                    return bindDynamic(cls, new MethodDescription.Latent(latent, "metafactory", 9, list, genericAsGenericType, Arrays.asList(token, token2, new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType()), new ParameterDescription.Token(JavaType.METHOD_HANDLE.getTypeStub().asGenericType()), new ParameterDescription.Token(javaType.getTypeStub().asGenericType())), list, list, AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED), JavaConstant.MethodType.ofSignature(methodListFilter.asDefined().getOnly()), JavaConstant.MethodHandle.of(inDefinedShape), JavaConstant.MethodType.ofSignature(methodListFilter.asDefined().getOnly()));
                                }
                                throw new IllegalArgumentException(typeDescription + " does not define exactly one abstract method: " + methodListFilter);
                            }
                            throw new IllegalArgumentException(dkz.x(typeDescription, " is not an interface type"));
                        }

                        public WithCustomMapping bootstrap(MethodDescription.InDefinedShape inDefinedShape, BootstrapArgumentResolver.Factory factory) {
                            return new WithCustomMapping(Dispatcher.ForDynamicInvocation.of(inDefinedShape, factory), this.offsetMappings);
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, EnumerationDescription enumerationDescription) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, ConstantValue.Simple.wrap(enumerationDescription)));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, ConstantValue constantValue) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType()));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, java.lang.reflect.Type type) {
                            return bind(cls, stackManipulation, TypeDefinition.Sort.describe(type));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                            return bind(new OffsetMapping.ForStackManipulation.Factory(cls, stackManipulation, generic));
                        }

                        public <T extends Annotation> WithCustomMapping bind(Class<T> cls, OffsetMapping offsetMapping) {
                            return bind(new OffsetMapping.Factory.Simple(cls, offsetMapping));
                        }

                        public WithCustomMapping bind(OffsetMapping.Factory<?> factory) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap(this.offsetMappings);
                            if (factory.getAnnotationType().isAnnotation()) {
                                if (linkedHashMap.put(factory.getAnnotationType(), factory) == null) {
                                    return new WithCustomMapping(this.dispatcherFactory, linkedHashMap);
                                }
                                throw new IllegalArgumentException("Annotation type already mapped: " + factory.getAnnotationType());
                            }
                            throw new IllegalArgumentException("Not an annotation type: " + factory.getAnnotationType());
                        }
                    }

                    public ForDelegation(TypeDescription.Generic generic, Dispatcher.Resolved resolved, List<OffsetMapping.Resolved> list) {
                        this.returned = generic;
                        this.dispatcher = resolved;
                        this.offsetMappings = list;
                    }

                    public static Factory<Target> to(Method method) {
                        return to(new MethodDescription.ForLoadedMethod(method));
                    }

                    public static WithCustomMapping withCustomMapping() {
                        return new WithCustomMapping(Dispatcher.ForRegularInvocation.Factory.INSTANCE, Collections.EMPTY_MAP);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForDelegation forDelegation = (ForDelegation) obj;
                        return this.returned.equals(forDelegation.returned) && this.dispatcher.equals(forDelegation.dispatcher) && this.offsetMappings.equals(forDelegation.offsetMappings);
                    }

                    public int hashCode() {
                        return this.offsetMappings.hashCode() + ((this.dispatcher.hashCode() + dkz.e(this.returned, getClass().hashCode() * 31, 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        int i2;
                        StackManipulation stackManipulationStoreAt;
                        ArrayList arrayList = new ArrayList(this.offsetMappings.size() + 3);
                        if (generic3.represents(Void.TYPE)) {
                            stackManipulationStoreAt = StackManipulation.Trivial.INSTANCE;
                            i2 = i;
                        } else {
                            i2 = i;
                            stackManipulationStoreAt = MethodVariableAccess.of(generic3).storeAt(i2);
                        }
                        arrayList.add(stackManipulationStoreAt);
                        arrayList.add(this.dispatcher.initialize());
                        Iterator<OffsetMapping.Resolved> it = this.offsetMappings.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().apply(target, generic, generic2, generic3, methodHandle, map, i2));
                            i2 = i;
                        }
                        arrayList.add(this.dispatcher.apply(target, methodHandle));
                        return new Simple(new StackManipulation.Compound(arrayList), this.returned);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface OffsetMapping {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Factory<T extends Annotation> {

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public static abstract class AbstractBase<S extends Annotation> implements Factory<S> {
                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    return make(inDefinedShape.getDeclaringType().asGenericType(), loadable);
                                }

                                public abstract OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<S> loadable);

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    return make(inDefinedShape.getType(), loadable);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Simple<S extends Annotation> extends AbstractBase<S> {
                                private final Class<S> annotationType;
                                private final OffsetMapping offsetMapping;

                                public Simple(Class<S> cls, OffsetMapping offsetMapping) {
                                    this.annotationType = cls;
                                    this.offsetMapping = offsetMapping;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Simple simple = (Simple) obj;
                                    return this.annotationType.equals(simple.annotationType) && this.offsetMapping.equals(simple.offsetMapping);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<S> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.offsetMapping.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory.AbstractBase
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<S> loadable) {
                                    return this.offsetMapping;
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public static abstract class WithParameterSupportOnly<S extends Annotation> implements Factory<S> {
                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<S> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }
                            }

                            Class<T> getAnnotationType();

                            OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable);

                            OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable);
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForAllArguments implements OffsetMapping {
                            private final boolean includeSelf;
                            private final boolean nullIfEmpty;
                            private final Source source;
                            private final TypeDescription.Generic targetComponentType;

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            private final Assigner.Typing typing;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<AllArguments> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_INCLUDE_SELF;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_NULL_IF_EMPTY;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_SOURCE;
                                private static final MethodDescription.InDefinedShape ALL_ARGUMENTS_TYPING;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(AllArguments.class).getDeclaredMethods();
                                    ALL_ARGUMENTS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                                    ALL_ARGUMENTS_SOURCE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("source")).getOnly();
                                    ALL_ARGUMENTS_INCLUDE_SELF = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("includeSelf")).getOnly();
                                    ALL_ARGUMENTS_NULL_IF_EMPTY = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("nullIfEmpty")).getOnly();
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<AllArguments> getAnnotationType() {
                                    return AllArguments.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<AllArguments> loadable) {
                                    if (inDefinedShape.getType().isArray()) {
                                        return new ForAllArguments(inDefinedShape.getType().getComponentType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ALL_ARGUMENTS_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ALL_ARGUMENTS_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(ALL_ARGUMENTS_INCLUDE_SELF).resolve(Boolean.class)).booleanValue(), ((Boolean) loadable.getValue(ALL_ARGUMENTS_NULL_IF_EMPTY).resolve(Boolean.class)).booleanValue());
                                    }
                                    throw new IllegalStateException("Expected array as parameter type for " + inDefinedShape);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final boolean includeSelf;
                                private final MethodDescription instrumentedMethod;
                                private final boolean nullIfEmpty;
                                private final Source source;
                                private final TypeDescription.Generic targetComponentType;
                                private final Assigner.Typing typing;

                                public Resolved(TypeDescription.Generic generic, Assigner.Typing typing, Source source, boolean z, boolean z2, Assigner assigner, MethodDescription methodDescription) {
                                    this.targetComponentType = generic;
                                    this.typing = typing;
                                    this.source = source;
                                    this.includeSelf = z;
                                    this.nullIfEmpty = z2;
                                    this.assigner = assigner;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    List<Source.Value> listArguments = this.source.arguments(this.includeSelf, generic, map, target, this.instrumentedMethod);
                                    if (this.nullIfEmpty && listArguments.isEmpty()) {
                                        return NullConstant.INSTANCE;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (Source.Value value : listArguments) {
                                        StackManipulation stackManipulationAssign = this.assigner.assign(value.getTypeDescription(), this.targetComponentType, this.typing);
                                        if (!stackManipulationAssign.isValid()) {
                                            throw new IllegalStateException("Cannot assign " + value.getTypeDescription() + " to " + this.targetComponentType);
                                        }
                                        arrayList.add(new StackManipulation.Compound(MethodVariableAccess.of(value.getTypeDescription()).loadFrom(value.getOffset()), stackManipulationAssign));
                                    }
                                    return ArrayFactory.forType(this.targetComponentType).withValues(arrayList);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.includeSelf == resolved.includeSelf && this.nullIfEmpty == resolved.nullIfEmpty && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetComponentType.equals(resolved.targetComponentType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + dkz.h(this.assigner, (((((this.source.hashCode() + ((this.typing.hashCode() + dkz.e(this.targetComponentType, getClass().hashCode() * 31, 31)) * 31)) * 31) + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0)) * 31, 31);
                                }
                            }

                            public ForAllArguments(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing, Source source, boolean z, boolean z2) {
                                this.targetComponentType = generic;
                                this.typing = typing;
                                this.source = source;
                                this.includeSelf = z;
                                this.nullIfEmpty = z2;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
                            
                                if (r2 != null) goto L24;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L4
                                    return r0
                                L4:
                                    r1 = 0
                                    if (r5 != 0) goto L8
                                    return r1
                                L8:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L13
                                    return r1
                                L13:
                                    boolean r2 = r4.includeSelf
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForAllArguments r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForAllArguments) r5
                                    boolean r3 = r5.includeSelf
                                    if (r2 == r3) goto L1c
                                    return r1
                                L1c:
                                    boolean r2 = r4.nullIfEmpty
                                    boolean r3 = r5.nullIfEmpty
                                    if (r2 == r3) goto L23
                                    return r1
                                L23:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L32
                                    if (r2 == 0) goto L34
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L35
                                    return r1
                                L32:
                                    if (r2 == 0) goto L35
                                L34:
                                    return r1
                                L35:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L40
                                    return r1
                                L40:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetComponentType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetComponentType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L4b
                                    return r1
                                L4b:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForAllArguments.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int iE = dkz.e(this.targetComponentType, getClass().hashCode() * 31, 31);
                                Assigner.Typing typing = this.typing;
                                if (typing != null) {
                                    iE += typing.hashCode();
                                }
                                return ((((this.source.hashCode() + (iE * 31)) * 31) + (this.includeSelf ? 1 : 0)) * 31) + (this.nullIfEmpty ? 1 : 0);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetComponentType;
                                Assigner.Typing typing2 = this.typing;
                                return new Resolved(generic, typing2 == null ? typing : typing2, this.source, this.includeSelf, this.nullIfEmpty, assigner, methodDescription);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForCurrent implements OffsetMapping {
                            private final TypeDescription.Generic targetType;

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            private final Assigner.Typing typing;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                public Resolved(TypeDescription.Generic generic, Assigner assigner, Assigner.Typing typing) {
                                    this.targetType = generic;
                                    this.assigner = assigner;
                                    this.typing = typing;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    StackManipulation stackManipulationAssign = this.assigner.assign(generic3, this.targetType, this.typing);
                                    if (stackManipulationAssign.isValid()) {
                                        return new StackManipulation.Compound(MethodVariableAccess.of(generic3).loadFrom(i), stackManipulationAssign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.typing.equals(resolved.typing) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner);
                                }

                                public int hashCode() {
                                    return this.typing.hashCode() + dkz.h(this.assigner, dkz.e(this.targetType, getClass().hashCode() * 31, 31), 31);
                                }
                            }

                            public ForCurrent(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing) {
                                this.targetType = generic;
                                this.typing = typing;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                            
                                if (r2 != null) goto L18;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L4
                                    return r0
                                L4:
                                    r1 = 0
                                    if (r5 != 0) goto L8
                                    return r1
                                L8:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L13
                                    return r1
                                L13:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForCurrent r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForCurrent) r5
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L24
                                    if (r2 == 0) goto L26
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L27
                                    return r1
                                L24:
                                    if (r2 == 0) goto L27
                                L26:
                                    return r1
                                L27:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L32
                                    return r1
                                L32:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForCurrent.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int iE = dkz.e(this.targetType, getClass().hashCode() * 31, 31);
                                Assigner.Typing typing = this.typing;
                                return typing != null ? typing.hashCode() + iE : iE;
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                Assigner.Typing typing2 = this.typing;
                                if (typing2 != null) {
                                    typing = typing2;
                                }
                                return new Resolved(generic, assigner, typing);
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<Current> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape CURRENT_TYPING = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Current.class).getDeclaredMethods().filter(ElementMatchers.named("typing")).getOnly();

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<Current> getAnnotationType() {
                                    return Current.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Current> loadable) {
                                    return new ForCurrent(inDefinedShape.getDeclaringType().asGenericType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(CURRENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Current> loadable) {
                                    return new ForCurrent(inDefinedShape.getType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(CURRENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class));
                                }
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForDynamicConstant implements OffsetMapping {
                            private final List<JavaConstant> arguments;
                            private final String bootstrapName;
                            private final TypeDescription bootstrapOwner;
                            private final List<? extends TypeDescription> bootstrapParameterTypes;
                            private final TypeDescription bootstrapReturnType;
                            private final JavaConstant.MethodHandle.HandleType bootstrapType;
                            private final boolean invokedynamic;
                            private final String name;
                            private final TypeDescription typeDescription;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<DynamicConstant> {
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

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<DynamicConstant> getAnnotationType() {
                                    return DynamicConstant.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<DynamicConstant> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<DynamicConstant> loadable) {
                                    return new ForDynamicConstant((String) loadable.getValue(NAME).resolve(String.class), inDefinedShape.getType().asErasure(), (JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(BOOTSTRAP_TYPE).resolve(EnumerationDescription.class)).load(JavaConstant.MethodHandle.HandleType.class), (TypeDescription) loadable.getValue(BOOTSTRAP_OWNER).resolve(TypeDescription.class), (String) loadable.getValue(BOOTSTRAP_NAME).resolve(String.class), (TypeDescription) loadable.getValue(BOOTSTRAP_RETURN_TYPE).resolve(TypeDescription.class), Arrays.asList((Object[]) loadable.getValue(BOOTSTRAP_PARAMETER_TYPES).resolve(TypeDescription[].class)), Collections.EMPTY_LIST, ((Boolean) loadable.getValue(INVOKEDYNAMIC).resolve(Boolean.class)).booleanValue());
                                }
                            }

                            public ForDynamicConstant(String str, TypeDescription typeDescription, JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription2, String str2, TypeDescription typeDescription3, List<? extends TypeDescription> list, List<JavaConstant> list2, boolean z) {
                                this.name = str;
                                this.typeDescription = typeDescription;
                                this.bootstrapType = handleType;
                                this.bootstrapOwner = typeDescription2;
                                this.bootstrapName = str2;
                                this.bootstrapReturnType = typeDescription3;
                                this.bootstrapParameterTypes = list;
                                this.arguments = list2;
                                this.invokedynamic = z;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForDynamicConstant forDynamicConstant = (ForDynamicConstant) obj;
                                return this.invokedynamic == forDynamicConstant.invokedynamic && this.bootstrapType.equals(forDynamicConstant.bootstrapType) && this.name.equals(forDynamicConstant.name) && this.bootstrapName.equals(forDynamicConstant.bootstrapName) && this.typeDescription.equals(forDynamicConstant.typeDescription) && this.bootstrapOwner.equals(forDynamicConstant.bootstrapOwner) && this.bootstrapReturnType.equals(forDynamicConstant.bootstrapReturnType) && this.bootstrapParameterTypes.equals(forDynamicConstant.bootstrapParameterTypes) && this.arguments.equals(forDynamicConstant.arguments);
                            }

                            public int hashCode() {
                                return bjs.g(this.arguments, bjs.g(this.bootstrapParameterTypes, dkz.f(this.bootstrapReturnType, bjs.e(this.bootstrapName, dkz.f(this.bootstrapOwner, (this.bootstrapType.hashCode() + dkz.f(this.typeDescription, bjs.e(this.name, getClass().hashCode() * 31, 31), 31)) * 31, 31), 31), 31), 31), 31) + (this.invokedynamic ? 1 : 0);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                boolean z = this.invokedynamic;
                                Class cls = Void.TYPE;
                                if (z) {
                                    String str = this.name;
                                    JavaConstant.MethodType methodTypeOf = JavaConstant.MethodType.of(this.typeDescription, new TypeDescription[0]);
                                    JavaConstant.MethodHandle.HandleType handleType = this.bootstrapType;
                                    if (!this.bootstrapOwner.represents(cls)) {
                                        typeDescription = this.bootstrapOwner;
                                    }
                                    return new Resolved.ForStackManipulation(new Invokedynamic(str, methodTypeOf, new JavaConstant.MethodHandle(handleType, typeDescription, this.bootstrapName, this.bootstrapReturnType, this.bootstrapParameterTypes), this.arguments));
                                }
                                String str2 = this.name;
                                TypeDescription typeDescription2 = this.typeDescription;
                                JavaConstant.MethodHandle.HandleType handleType2 = this.bootstrapType;
                                if (!this.bootstrapOwner.represents(cls)) {
                                    typeDescription = this.bootstrapOwner;
                                }
                                return new Resolved.ForStackManipulation(new JavaConstantValue(new JavaConstant.Dynamic(str2, typeDescription2, new JavaConstant.MethodHandle(handleType2, typeDescription, this.bootstrapName, this.bootstrapReturnType, this.bootstrapParameterTypes), this.arguments)));
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class ForField implements OffsetMapping {
                            private static final MethodDescription.InDefinedShape FIELD_VALUE_DECLARING_TYPE;
                            private static final MethodDescription.InDefinedShape FIELD_VALUE_TYPING;
                            private static final MethodDescription.InDefinedShape FIELD_VALUE_VALUE;
                            private final TypeDescription.Generic target;

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            private final Assigner.Typing typing;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved extends ForField {
                                private final FieldDescription fieldDescription;

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                @HashCodeAndEqualsPlugin.Enhance
                                public static class Factory<T extends Annotation> extends Factory.AbstractBase<T> {
                                    private final Class<T> annotationType;
                                    private final FieldDescription fieldDescription;
                                    private final Assigner.Typing typing;

                                    public Factory(Class<T> cls, FieldDescription fieldDescription) {
                                        this(cls, fieldDescription, Assigner.Typing.STATIC);
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        if (obj == null || getClass() != obj.getClass()) {
                                            return false;
                                        }
                                        Factory factory = (Factory) obj;
                                        return this.typing.equals(factory.typing) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public Class<T> getAnnotationType() {
                                        return this.annotationType;
                                    }

                                    public int hashCode() {
                                        return this.typing.hashCode() + ((this.fieldDescription.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType)) * 31);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory.AbstractBase
                                    public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                        return new Resolved(generic, this.typing, this.fieldDescription);
                                    }

                                    public Factory(Class<T> cls, FieldDescription fieldDescription, Assigner.Typing typing) {
                                        this.annotationType = cls;
                                        this.fieldDescription = fieldDescription;
                                        this.typing = typing;
                                    }
                                }

                                public Resolved(TypeDescription.Generic generic, Assigner.Typing typing, FieldDescription fieldDescription) {
                                    super(generic, typing);
                                    this.fieldDescription = fieldDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public int hashCode() {
                                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                                    }
                                    if (this.fieldDescription.isVisibleTo(typeDescription)) {
                                        return this.fieldDescription;
                                    }
                                    throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                                }
                            }

                            static {
                                MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldValue.class).getDeclaredMethods();
                                FIELD_VALUE_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                                FIELD_VALUE_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
                                FIELD_VALUE_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                            }

                            public ForField(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing) {
                                this.target = generic;
                                this.typing = typing;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                            
                                if (r2 != null) goto L18;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L4
                                    return r0
                                L4:
                                    r1 = 0
                                    if (r5 != 0) goto L8
                                    return r1
                                L8:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L13
                                    return r1
                                L13:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForField r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField) r5
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L24
                                    if (r2 == 0) goto L26
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L27
                                    return r1
                                L24:
                                    if (r2 == 0) goto L27
                                L26:
                                    return r1
                                L27:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.target
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.target
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L32
                                    return r1
                                L32:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int iE = dkz.e(this.target, getClass().hashCode() * 31, 31);
                                Assigner.Typing typing = this.typing;
                                return typing != null ? typing.hashCode() + iE : iE;
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                FieldDescription fieldDescriptionResolve = resolve(typeDescription, methodDescription);
                                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                                    throw new IllegalStateException("Cannot access non-static field " + fieldDescriptionResolve + " from static method " + methodDescription);
                                }
                                TypeDescription.Generic type = fieldDescriptionResolve.getType();
                                TypeDescription.Generic generic = this.target;
                                Assigner.Typing typing2 = this.typing;
                                if (typing2 != null) {
                                    typing = typing2;
                                }
                                StackManipulation stackManipulationAssign = assigner.assign(type, generic, typing);
                                if (stackManipulationAssign.isValid()) {
                                    return new Resolved.ForStackManipulation(new StackManipulation.Compound(fieldDescriptionResolve.isStatic() ? StackManipulation.Trivial.INSTANCE : MethodVariableAccess.loadThis(), FieldAccess.forField(fieldDescriptionResolve).read(), stackManipulationAssign));
                                }
                                throw new IllegalStateException("Cannot assign " + fieldDescriptionResolve + " to " + this.target);
                            }

                            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static abstract class Unresolved extends ForField {
                                protected static final String BEAN_PROPERTY = "";
                                private final String name;

                                public Unresolved(TypeDescription.Generic generic, Assigner.Typing typing, String str) {
                                    super(generic, typing);
                                    this.name = str;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                                }

                                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public int hashCode() {
                                    return this.name.hashCode() + (super.hashCode() * 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                                    FieldLocator.Resolution resolutionOfBeanAccessor = this.name.equals("") ? FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription) : fieldLocator.locate(this.name);
                                    if (resolutionOfBeanAccessor.isResolved()) {
                                        return resolutionOfBeanAccessor.getField();
                                    }
                                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                @HashCodeAndEqualsPlugin.Enhance
                                public static class WithExplicitType extends Unresolved {
                                    private final TypeDescription declaringType;

                                    public WithExplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable, TypeDescription typeDescription) {
                                        this(generic, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_VALUE_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE_VALUE).resolve(String.class), typeDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.Unresolved, net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                    public boolean equals(@MaybeNull Object obj) {
                                        if (!super.equals(obj)) {
                                            return false;
                                        }
                                        if (this == obj) {
                                            return true;
                                        }
                                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.Unresolved
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                                        }
                                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.Unresolved, net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField
                                    public int hashCode() {
                                        return this.declaringType.hashCode() + (super.hashCode() * 31);
                                    }

                                    public WithExplicitType(TypeDescription.Generic generic, Assigner.Typing typing, String str, TypeDescription typeDescription) {
                                        super(generic, typing, str);
                                        this.declaringType = typeDescription;
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                public static class WithImplicitType extends Unresolved {
                                    public WithImplicitType(TypeDescription.Generic generic, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        this(generic, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ForField.FIELD_VALUE_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (String) loadable.getValue(ForField.FIELD_VALUE_VALUE).resolve(String.class));
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForField.Unresolved
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        return new FieldLocator.ForClassHierarchy(typeDescription);
                                    }

                                    public WithImplicitType(TypeDescription.Generic generic, Assigner.Typing typing, String str) {
                                        super(generic, typing, str);
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                public enum Factory implements Factory<FieldValue> {
                                    INSTANCE;

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public Class<FieldValue> getAnnotationType() {
                                        return FieldValue.class;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.FIELD_VALUE_DECLARING_TYPE).resolve(TypeDescription.class);
                                        return typeDescription.represents(Void.TYPE) ? new WithImplicitType(inDefinedShape.getDeclaringType().asGenericType(), loadable) : new WithExplicitType(inDefinedShape.getDeclaringType().asGenericType(), loadable, typeDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldValue> loadable) {
                                        TypeDescription typeDescription = (TypeDescription) loadable.getValue(ForField.FIELD_VALUE_DECLARING_TYPE).resolve(TypeDescription.class);
                                        if (typeDescription.represents(Void.TYPE)) {
                                            return new WithImplicitType(inDefinedShape.getType(), loadable);
                                        }
                                        return new WithExplicitType(inDefinedShape.getType(), loadable, typeDescription);
                                    }
                                }
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static abstract class ForFieldHandle implements OffsetMapping {
                            private final Access access;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Access {
                                GETTER { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Access.1
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Access
                                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                                        return JavaConstant.MethodHandle.ofGetter(inDefinedShape);
                                    }
                                },
                                SETTER { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Access.2
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Access
                                    public JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape) {
                                        return JavaConstant.MethodHandle.ofSetter(inDefinedShape);
                                    }
                                };

                                public abstract JavaConstant.MethodHandle resolve(FieldDescription.InDefinedShape inDefinedShape);

                                /* synthetic */ Access(AnonymousClass1 anonymousClass1) {
                                    this();
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved extends ForFieldHandle {
                                private final FieldDescription fieldDescription;

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                @HashCodeAndEqualsPlugin.Enhance
                                public static class Factory<T extends Annotation> implements Factory<T> {
                                    private final Access access;
                                    private final Class<T> annotationType;
                                    private final FieldDescription fieldDescription;

                                    public Factory(Class<T> cls, FieldDescription fieldDescription, Access access) {
                                        this.annotationType = cls;
                                        this.fieldDescription = fieldDescription;
                                        this.access = access;
                                    }

                                    public boolean equals(@MaybeNull Object obj) {
                                        if (this == obj) {
                                            return true;
                                        }
                                        if (obj == null || getClass() != obj.getClass()) {
                                            return false;
                                        }
                                        Factory factory = (Factory) obj;
                                        return this.access.equals(factory.access) && this.annotationType.equals(factory.annotationType) && this.fieldDescription.equals(factory.fieldDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public Class<T> getAnnotationType() {
                                        return this.annotationType;
                                    }

                                    public int hashCode() {
                                        return this.access.hashCode() + ((this.fieldDescription.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType)) * 31);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            return new Resolved(this.access, this.fieldDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                public Resolved(Access access, FieldDescription fieldDescription) {
                                    super(access);
                                    this.fieldDescription = fieldDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Resolved) obj).fieldDescription);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public int hashCode() {
                                    return this.fieldDescription.hashCode() + (super.hashCode() * 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    if (!this.fieldDescription.isStatic() && !this.fieldDescription.getDeclaringType().asErasure().isAssignableFrom(typeDescription)) {
                                        throw new IllegalStateException(this.fieldDescription + " is no member of " + typeDescription);
                                    }
                                    if (this.fieldDescription.isVisibleTo(typeDescription)) {
                                        return this.fieldDescription;
                                    }
                                    throw new IllegalStateException("Cannot access " + this.fieldDescription + " from " + typeDescription);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static abstract class Unresolved extends ForFieldHandle {
                                protected static final String BEAN_PROPERTY = "";
                                private final String name;

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                public enum GetterFactory implements Factory<FieldGetterHandle> {
                                    INSTANCE;

                                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_DECLARING_TYPE;
                                    private static final MethodDescription.InDefinedShape FIELD_GETTER_HANDLE_VALUE;

                                    static {
                                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldGetterHandle.class).getDeclaredMethods();
                                        FIELD_GETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                                        FIELD_GETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public Class<FieldGetterHandle> getAnnotationType() {
                                        return FieldGetterHandle.class;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldGetterHandle> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldGetterHandle> loadable) {
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_GETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                                            return typeDescription.represents(Void.TYPE) ? new WithImplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(String.class)) : new WithExplicitType(Access.GETTER, (String) loadable.getValue(FIELD_GETTER_HANDLE_VALUE).resolve(String.class), typeDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                public enum SetterFactory implements Factory<FieldSetterHandle> {
                                    INSTANCE;

                                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_DECLARING_TYPE;
                                    private static final MethodDescription.InDefinedShape FIELD_SETTER_HANDLE_VALUE;

                                    static {
                                        MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(FieldSetterHandle.class).getDeclaredMethods();
                                        FIELD_SETTER_HANDLE_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                                        FIELD_SETTER_HANDLE_DECLARING_TYPE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("declaringType")).getOnly();
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public Class<FieldSetterHandle> getAnnotationType() {
                                        return FieldSetterHandle.class;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                                        throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                    public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<FieldSetterHandle> loadable) {
                                        if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                            TypeDescription typeDescription = (TypeDescription) loadable.getValue(FIELD_SETTER_HANDLE_DECLARING_TYPE).resolve(TypeDescription.class);
                                            return typeDescription.represents(Void.TYPE) ? new WithImplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(String.class)) : new WithExplicitType(Access.SETTER, (String) loadable.getValue(FIELD_SETTER_HANDLE_VALUE).resolve(String.class), typeDescription);
                                        }
                                        throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                @HashCodeAndEqualsPlugin.Enhance
                                public static class WithExplicitType extends Unresolved {
                                    private final TypeDescription declaringType;

                                    public WithExplicitType(Access access, String str, TypeDescription typeDescription) {
                                        super(access, str);
                                        this.declaringType = typeDescription;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Unresolved, net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                    public boolean equals(@MaybeNull Object obj) {
                                        if (!super.equals(obj)) {
                                            return false;
                                        }
                                        if (this == obj) {
                                            return true;
                                        }
                                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((WithExplicitType) obj).declaringType);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Unresolved
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        if (this.declaringType.represents(TargetType.class) || typeDescription.isAssignableTo(this.declaringType)) {
                                            return new FieldLocator.ForExactType(TargetType.resolve(this.declaringType, typeDescription));
                                        }
                                        throw new IllegalStateException(this.declaringType + " is no super type of " + typeDescription);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Unresolved, net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                    public int hashCode() {
                                        return this.declaringType.hashCode() + (super.hashCode() * 31);
                                    }
                                }

                                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                                public static class WithImplicitType extends Unresolved {
                                    public WithImplicitType(Access access, String str) {
                                        super(access, str);
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle.Unresolved
                                    public FieldLocator fieldLocator(TypeDescription typeDescription) {
                                        return new FieldLocator.ForClassHierarchy(typeDescription);
                                    }
                                }

                                public Unresolved(Access access, String str) {
                                    super(access);
                                    this.name = str;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public boolean equals(@MaybeNull Object obj) {
                                    if (!super.equals(obj)) {
                                        return false;
                                    }
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.name.equals(((Unresolved) obj).name);
                                }

                                public abstract FieldLocator fieldLocator(TypeDescription typeDescription);

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public int hashCode() {
                                    return this.name.hashCode() + (super.hashCode() * 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForFieldHandle
                                public FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription) {
                                    FieldLocator fieldLocator = fieldLocator(typeDescription);
                                    FieldLocator.Resolution resolutionOfBeanAccessor = this.name.equals("") ? FieldLocator.Resolution.Simple.ofBeanAccessor(fieldLocator, methodDescription) : fieldLocator.locate(this.name);
                                    if (resolutionOfBeanAccessor.isResolved()) {
                                        return resolutionOfBeanAccessor.getField();
                                    }
                                    throw new IllegalStateException("Cannot locate field named " + this.name + " for " + typeDescription);
                                }
                            }

                            public ForFieldHandle(Access access) {
                                this.access = access;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.access.equals(((ForFieldHandle) obj).access);
                            }

                            public int hashCode() {
                                return this.access.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                FieldDescription fieldDescriptionResolve = resolve(typeDescription, methodDescription);
                                if (!fieldDescriptionResolve.isStatic() && methodDescription.isStatic()) {
                                    throw new IllegalStateException("Cannot access non-static field " + fieldDescriptionResolve + " from static method " + methodDescription);
                                }
                                if (fieldDescriptionResolve.isStatic()) {
                                    return new Resolved.ForStackManipulation(this.access.resolve(fieldDescriptionResolve.asDefined()).toStackManipulation());
                                }
                                StackManipulation stackManipulation = this.access.resolve(fieldDescriptionResolve.asDefined()).toStackManipulation();
                                StackManipulation stackManipulationLoadFrom = MethodVariableAccess.REFERENCE.loadFrom(0);
                                JavaType javaType = JavaType.METHOD_HANDLE;
                                return new Resolved.ForStackManipulation(new StackManipulation.Compound(stackManipulation, stackManipulationLoadFrom, MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class)))))));
                            }

                            public abstract FieldDescription resolve(TypeDescription typeDescription, MethodDescription methodDescription);
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForHandle implements OffsetMapping {
                            private final String name;
                            private final TypeDescription owner;
                            private final List<? extends TypeDescription> parameterTypes;
                            private final TypeDescription returnType;
                            private final JavaConstant.MethodHandle.HandleType type;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<Handle> {
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

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<Handle> getAnnotationType() {
                                    return Handle.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Handle> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Handle> loadable) {
                                    if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                        return new ForHandle((JavaConstant.MethodHandle.HandleType) ((EnumerationDescription) loadable.getValue(HANDLE_TYPE).resolve(EnumerationDescription.class)).load(JavaConstant.MethodHandle.HandleType.class), (TypeDescription) loadable.getValue(HANDLE_OWNER).resolve(TypeDescription.class), (String) loadable.getValue(HANDLE_NAME).resolve(String.class), (TypeDescription) loadable.getValue(HANDLE_RETURN_TYPE).resolve(TypeDescription.class), Arrays.asList((Object[]) loadable.getValue(HANDLE_PARAMETER_TYPES).resolve(TypeDescription[].class)));
                                    }
                                    throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                }
                            }

                            public ForHandle(JavaConstant.MethodHandle.HandleType handleType, TypeDescription typeDescription, String str, TypeDescription typeDescription2, List<? extends TypeDescription> list) {
                                this.type = handleType;
                                this.owner = typeDescription;
                                this.name = str;
                                this.returnType = typeDescription2;
                                this.parameterTypes = list;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForHandle forHandle = (ForHandle) obj;
                                return this.type.equals(forHandle.type) && this.name.equals(forHandle.name) && this.owner.equals(forHandle.owner) && this.returnType.equals(forHandle.returnType) && this.parameterTypes.equals(forHandle.parameterTypes);
                            }

                            public int hashCode() {
                                return this.parameterTypes.hashCode() + dkz.f(this.returnType, bjs.e(this.name, dkz.f(this.owner, (this.type.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31), 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                JavaConstant.MethodHandle.HandleType handleType = this.type;
                                if (!this.owner.represents(Void.TYPE)) {
                                    typeDescription = this.owner;
                                }
                                return new Resolved.ForStackManipulation(new JavaConstantValue(new JavaConstant.MethodHandle(handleType, typeDescription, this.name, this.returnType, this.parameterTypes)));
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForOrigin implements OffsetMapping {
                            private final Sort sort;
                            private final Source source;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<Origin> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape ORIGIN_TYPE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Origin.class).getDeclaredMethods().filter(ElementMatchers.named("source")).getOnly();

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<Origin> getAnnotationType() {
                                    return Origin.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Origin> loadable) {
                                    Sort sort;
                                    if (inDefinedShape.getType().asErasure().represents(Class.class)) {
                                        sort = Sort.TYPE;
                                    } else if (inDefinedShape.getType().asErasure().represents(Method.class)) {
                                        sort = Sort.METHOD;
                                    } else if (inDefinedShape.getType().asErasure().represents(Constructor.class)) {
                                        sort = Sort.CONSTRUCTOR;
                                    } else if (inDefinedShape.getType().asErasure().represents(Field.class)) {
                                        sort = Sort.FIELD;
                                    } else if (inDefinedShape.getType().asErasure().represents(Integer.TYPE)) {
                                        sort = Sort.MODIFIERS;
                                    } else if (JavaType.EXECUTABLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.EXECUTABLE;
                                    } else if (JavaType.METHOD_HANDLE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.METHOD_HANDLE;
                                    } else if (JavaType.METHOD_TYPE.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.METHOD_TYPE;
                                    } else if (JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().equals(inDefinedShape.getType().asErasure())) {
                                        sort = Sort.LOOKUP;
                                    } else {
                                        if (!inDefinedShape.getType().asErasure().isAssignableFrom(String.class)) {
                                            throw new IllegalStateException("Non-supported type " + inDefinedShape.getType() + " for @Origin annotation");
                                        }
                                        sort = Sort.STRING;
                                    }
                                    return new ForOrigin(sort, (Source) ((EnumerationDescription) loadable.getValue(ORIGIN_TYPE).resolve(EnumerationDescription.class)).load(Source.class));
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Sort sort;
                                private final Source source;

                                public Resolved(Sort sort, Source source, MethodDescription methodDescription) {
                                    this.sort = sort;
                                    this.source = source;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    if (this.source.isRepresentable(this.sort, target, this.instrumentedMethod)) {
                                        return this.source.resolve(this.sort, target, generic, generic2, this.instrumentedMethod);
                                    }
                                    throw new IllegalStateException("Cannot represent " + this.sort + " for " + this.source + " in " + this.instrumentedMethod);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.sort.equals(resolved.sort) && this.source.equals(resolved.source) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + ((this.source.hashCode() + ((this.sort.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Sort {
                                METHOD { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.1
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return (member instanceof MethodDescription) && ((MethodDescription) member).isMethod();
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of(((MethodDescription) member).asDefined());
                                    }
                                },
                                CONSTRUCTOR { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.2
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return (member instanceof MethodDescription) && ((MethodDescription) member).isConstructor();
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of(((MethodDescription) member).asDefined());
                                    }
                                },
                                FIELD { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.3
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return member instanceof FieldDescription;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return new FieldConstant(((FieldDescription) member).asDefined());
                                    }
                                },
                                MODIFIERS { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.4
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return IntegerConstant.forValue(member.getModifiers());
                                    }
                                },
                                EXECUTABLE { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.5
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return member instanceof MethodDescription;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodConstant.of(((MethodDescription) member).asDefined());
                                    }
                                },
                                TYPE { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.6
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return ClassConstant.of(member.getDeclaringType().asErasure());
                                    }
                                },
                                LOOKUP { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.7
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return MethodInvocation.lookup();
                                    }
                                },
                                METHOD_HANDLE { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.8
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        JavaConstant.MethodHandle methodHandleOfSetter;
                                        if (member instanceof MethodDescription) {
                                            methodHandleOfSetter = JavaConstant.MethodHandle.of(((MethodDescription) member).asDefined());
                                        } else {
                                            if (!(member instanceof FieldDescription)) {
                                                throw new IllegalStateException("Unexpected byte code element: " + member);
                                            }
                                            methodHandleOfSetter = typeDescription.represents(Void.TYPE) ? JavaConstant.MethodHandle.ofSetter(((FieldDescription) member).asDefined()) : JavaConstant.MethodHandle.ofGetter(((FieldDescription) member).asDefined());
                                        }
                                        return methodHandleOfSetter.toStackManipulation();
                                    }
                                },
                                METHOD_TYPE { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.9
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return JavaConstant.MethodType.of(typeDescription, list).toStackManipulation();
                                    }
                                },
                                STRING { // from class: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort.10
                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public boolean isRepresentable(ByteCodeElement.Member member) {
                                        return true;
                                    }

                                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForOrigin.Sort
                                    public StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription) {
                                        return new TextConstant(member.toString());
                                    }
                                };

                                public abstract boolean isRepresentable(ByteCodeElement.Member member);

                                public abstract StackManipulation resolve(ByteCodeElement.Member member, List<TypeDescription> list, TypeDescription typeDescription);

                                /* synthetic */ Sort(AnonymousClass1 anonymousClass1) {
                                    this();
                                }
                            }

                            public ForOrigin(Sort sort, Source source) {
                                this.sort = sort;
                                this.source = source;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForOrigin forOrigin = (ForOrigin) obj;
                                return this.sort.equals(forOrigin.sort) && this.source.equals(forOrigin.source);
                            }

                            public int hashCode() {
                                return this.source.hashCode() + ((this.sort.hashCode() + (getClass().hashCode() * 31)) * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.sort, this.source, methodDescription);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForSelfCallHandle implements OffsetMapping {
                            private final boolean bound;
                            private final Source source;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Bound implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                public Bound(Source source, MethodDescription methodDescription) {
                                    this.source = source;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    Source.Value valueSelf = this.source.self(generic, map, target, this.instrumentedMethod);
                                    List<Source.Value> listArguments = this.source.arguments(false, generic, map, target, this.instrumentedMethod);
                                    ArrayList arrayList = new ArrayList(listArguments.size() + (valueSelf == null ? 0 : 2) + 1 + (!listArguments.isEmpty() ? 1 : 0));
                                    arrayList.add(this.source.handle(methodHandle, this.instrumentedMethod).toStackManipulation());
                                    if (valueSelf != null) {
                                        arrayList.add(MethodVariableAccess.of(valueSelf.getTypeDescription()).loadFrom(valueSelf.getOffset()));
                                        JavaType javaType = JavaType.METHOD_HANDLE;
                                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(javaType.getTypeStub(), new MethodDescription.Token("bindTo", 1, javaType.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(TypeDefinition.Sort.describe(Object.class))))));
                                    }
                                    if (!listArguments.isEmpty()) {
                                        for (Source.Value value : listArguments) {
                                            arrayList.add(MethodVariableAccess.of(value.getTypeDescription()).loadFrom(value.getOffset()));
                                        }
                                        TypeDescription typeStub = JavaType.METHOD_HANDLES.getTypeStub();
                                        JavaType javaType2 = JavaType.METHOD_HANDLE;
                                        arrayList.add(MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(typeStub, new MethodDescription.Token("insertArguments", 9, javaType2.getTypeStub().asGenericType(), new TypeList.Generic.Explicit(javaType2.getTypeStub(), TypeDefinition.Sort.describe(Integer.TYPE), TypeDefinition.Sort.describe(Object[].class))))));
                                    }
                                    return new StackManipulation.Compound(arrayList);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Bound bound = (Bound) obj;
                                    return this.source.equals(bound.source) && this.instrumentedMethod.equals(bound.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + ((this.source.hashCode() + (getClass().hashCode() * 31)) * 31);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<SelfCallHandle> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape SELF_CALL_HANDLE_BOUND;
                                private static final MethodDescription.InDefinedShape SELF_CALL_HANDLE_SOURCE;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(SelfCallHandle.class).getDeclaredMethods();
                                    SELF_CALL_HANDLE_SOURCE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("source")).getOnly();
                                    SELF_CALL_HANDLE_BOUND = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("bound")).getOnly();
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<SelfCallHandle> getAnnotationType() {
                                    return SelfCallHandle.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<SelfCallHandle> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<SelfCallHandle> loadable) {
                                    if (inDefinedShape.getType().asErasure().isAssignableFrom(JavaType.METHOD_HANDLE.getTypeStub())) {
                                        return new ForSelfCallHandle((Source) ((EnumerationDescription) loadable.getValue(SELF_CALL_HANDLE_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(SELF_CALL_HANDLE_BOUND).resolve(Boolean.class)).booleanValue());
                                    }
                                    throw new IllegalStateException("Cannot assign method handle to " + inDefinedShape);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Unbound implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                public Unbound(Source source, MethodDescription methodDescription) {
                                    this.source = source;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    return this.source.handle(methodHandle, this.instrumentedMethod).toStackManipulation();
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Unbound unbound = (Unbound) obj;
                                    return this.source.equals(unbound.source) && this.instrumentedMethod.equals(unbound.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + ((this.source.hashCode() + (getClass().hashCode() * 31)) * 31);
                                }
                            }

                            public ForSelfCallHandle(Source source, boolean z) {
                                this.source = source;
                                this.bound = z;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForSelfCallHandle forSelfCallHandle = (ForSelfCallHandle) obj;
                                return this.bound == forSelfCallHandle.bound && this.source.equals(forSelfCallHandle.source);
                            }

                            public int hashCode() {
                                return ((this.source.hashCode() + (getClass().hashCode() * 31)) * 31) + (this.bound ? 1 : 0);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return this.bound ? new Bound(this.source, methodDescription) : new Unbound(this.source, methodDescription);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForStackManipulation implements OffsetMapping {
                            private final StackManipulation stackManipulation;
                            private final TypeDescription.Generic targetType;
                            private final TypeDescription.Generic typeDescription;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Factory<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final StackManipulation stackManipulation;
                                private final TypeDescription.Generic typeDescription;

                                public Factory(Class<T> cls, ConstantValue constantValue) {
                                    this(cls, constantValue.toStackManipulation(), constantValue.getTypeDescription().asGenericType());
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Factory factory = (Factory) obj;
                                    return this.annotationType.equals(factory.annotationType) && this.stackManipulation.equals(factory.stackManipulation) && this.typeDescription.equals(factory.typeDescription);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.typeDescription.hashCode() + dkz.g(this.stackManipulation, bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory.AbstractBase
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(this.stackManipulation, this.typeDescription, generic);
                                }

                                public Factory(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                                    this.annotationType = cls;
                                    this.stackManipulation = stackManipulation;
                                    this.typeDescription = generic;
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfAnnotationProperty<T extends Annotation> extends Factory.WithParameterSupportOnly<T> {
                                private final Class<T> annotationType;
                                private final MethodDescription.InDefinedShape property;

                                public OfAnnotationProperty(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape) {
                                    this.annotationType = cls;
                                    this.property = inDefinedShape;
                                }

                                public static <S extends Annotation> Factory<S> of(Class<S> cls, String str) {
                                    if (!cls.isAnnotation()) {
                                        throw new IllegalArgumentException(bjs.l(cls, "Not an annotation type: "));
                                    }
                                    try {
                                        return new OfAnnotationProperty(cls, new MethodDescription.ForLoadedMethod(cls.getMethod(str, null)));
                                    } catch (NoSuchMethodException e) {
                                        throw new IllegalArgumentException("Cannot find a property " + str + " on " + cls, e);
                                    }
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfAnnotationProperty ofAnnotationProperty = (OfAnnotationProperty) obj;
                                    return this.annotationType.equals(ofAnnotationProperty.annotationType) && this.property.equals(ofAnnotationProperty.property);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.property.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.annotationType);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    ConstantValue constantValueWrapOrNull = ConstantValue.Simple.wrapOrNull(loadable.getValue(this.property).resolve());
                                    if (constantValueWrapOrNull != null) {
                                        return new ForStackManipulation(constantValueWrapOrNull.toStackManipulation(), constantValueWrapOrNull.getTypeDescription().asGenericType(), inDefinedShape.getType());
                                    }
                                    throw new IllegalStateException("Not a constant value property: " + this.property);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfDefaultValue<T extends Annotation> implements Factory<T> {
                                private final Class<T> annotationType;

                                public OfDefaultValue(Class<T> cls) {
                                    this.annotationType = cls;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((OfDefaultValue) obj).annotationType);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(DefaultValue.of(inDefinedShape.getType()), inDefinedShape.getType(), inDefinedShape.getType());
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfDynamicInvocation<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final List<? extends JavaConstant> arguments;
                                private final MethodDescription.InDefinedShape bootstrapMethod;

                                public OfDynamicInvocation(Class<T> cls, MethodDescription.InDefinedShape inDefinedShape, List<? extends JavaConstant> list) {
                                    this.annotationType = cls;
                                    this.bootstrapMethod = inDefinedShape;
                                    this.arguments = list;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfDynamicInvocation ofDynamicInvocation = (OfDynamicInvocation) obj;
                                    return this.annotationType.equals(ofDynamicInvocation.annotationType) && this.bootstrapMethod.equals(ofDynamicInvocation.bootstrapMethod) && this.arguments.equals(ofDynamicInvocation.arguments);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.arguments.hashCode() + dkz.b(this.bootstrapMethod, bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory.AbstractBase
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    if (!generic.isInterface()) {
                                        throw new IllegalArgumentException(generic + " is not an interface");
                                    }
                                    if (!generic.getInterfaces().isEmpty()) {
                                        throw new IllegalArgumentException(generic + " must not extend other interfaces");
                                    }
                                    if (!generic.isPublic()) {
                                        throw new IllegalArgumentException(generic + " is mot public");
                                    }
                                    MethodList methodListFilter = generic.getDeclaredMethods().filter(ElementMatchers.isAbstract());
                                    if (methodListFilter.size() == 1) {
                                        return new ForStackManipulation(MethodInvocation.invoke(this.bootstrapMethod).dynamic(((MethodDescription) methodListFilter.getOnly()).getInternalName(), generic.asErasure(), Collections.EMPTY_LIST, this.arguments), generic, generic);
                                    }
                                    throw new IllegalArgumentException(generic + " must declare exactly one abstract method");
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class OfSerializedConstant<T extends Annotation> extends Factory.AbstractBase<T> {
                                private final Class<T> annotationType;
                                private final StackManipulation deserialization;
                                private final TypeDescription.Generic typeDescription;

                                public OfSerializedConstant(Class<T> cls, StackManipulation stackManipulation, TypeDescription.Generic generic) {
                                    this.annotationType = cls;
                                    this.deserialization = stackManipulation;
                                    this.typeDescription = generic;
                                }

                                /* JADX WARN: Incorrect types in method signature: <S::Ljava/lang/annotation/Annotation;U::Ljava/io/Serializable;>(Ljava/lang/Class<TS;>;TU;Ljava/lang/Class<-TU;>;)Lnet/bytebuddy/asm/MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$Factory<TS;>; */
                                public static Factory of(Class cls, Serializable serializable, Class cls2) {
                                    if (cls2.isInstance(serializable)) {
                                        return new OfSerializedConstant(cls, SerializedConstant.of(serializable), TypeDescription.ForLoadedType.of(cls2).asGenericType());
                                    }
                                    throw new IllegalArgumentException(serializable + " is no instance of " + cls2);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    OfSerializedConstant ofSerializedConstant = (OfSerializedConstant) obj;
                                    return this.annotationType.equals(ofSerializedConstant.annotationType) && this.deserialization.equals(ofSerializedConstant.deserialization) && this.typeDescription.equals(ofSerializedConstant.typeDescription);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<T> getAnnotationType() {
                                    return this.annotationType;
                                }

                                public int hashCode() {
                                    return this.typeDescription.hashCode() + dkz.g(this.deserialization, bjs.d(getClass().hashCode() * 31, 31, this.annotationType), 31);
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory.AbstractBase
                                public OffsetMapping make(TypeDescription.Generic generic, AnnotationDescription.Loadable<T> loadable) {
                                    return new ForStackManipulation(this.deserialization, this.typeDescription, generic);
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final StackManipulation stackManipulation;
                                private final TypeDescription.Generic targetType;
                                private final TypeDescription.Generic typeDescription;
                                private final Assigner.Typing typing;

                                public Resolved(Assigner assigner, Assigner.Typing typing, StackManipulation stackManipulation, TypeDescription.Generic generic, TypeDescription.Generic generic2) {
                                    this.assigner = assigner;
                                    this.typing = typing;
                                    this.stackManipulation = stackManipulation;
                                    this.typeDescription = generic;
                                    this.targetType = generic2;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    StackManipulation stackManipulationAssign = this.assigner.assign(this.typeDescription, this.targetType, this.typing);
                                    if (stackManipulationAssign.isValid()) {
                                        return new StackManipulation.Compound(this.stackManipulation, stackManipulationAssign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.typing.equals(resolved.typing) && this.assigner.equals(resolved.assigner) && this.stackManipulation.equals(resolved.stackManipulation) && this.typeDescription.equals(resolved.typeDescription) && this.targetType.equals(resolved.targetType);
                                }

                                public int hashCode() {
                                    return this.targetType.hashCode() + dkz.e(this.typeDescription, dkz.g(this.stackManipulation, (this.typing.hashCode() + dkz.h(this.assigner, getClass().hashCode() * 31, 31)) * 31, 31), 31);
                                }
                            }

                            public ForStackManipulation(StackManipulation stackManipulation, TypeDescription.Generic generic, TypeDescription.Generic generic2) {
                                this.targetType = generic2;
                                this.stackManipulation = stackManipulation;
                                this.typeDescription = generic;
                            }

                            public static <S extends Annotation> Factory<S> of(Class<S> cls, @MaybeNull Object obj) {
                                return obj == null ? new OfDefaultValue(cls) : new Factory(cls, ConstantValue.Simple.wrap(obj));
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                ForStackManipulation forStackManipulation = (ForStackManipulation) obj;
                                return this.stackManipulation.equals(forStackManipulation.stackManipulation) && this.typeDescription.equals(forStackManipulation.typeDescription) && this.targetType.equals(forStackManipulation.targetType);
                            }

                            public int hashCode() {
                                return this.targetType.hashCode() + dkz.e(this.typeDescription, dkz.g(this.stackManipulation, getClass().hashCode() * 31, 31), 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(assigner, typing, this.stackManipulation, this.typeDescription, this.targetType);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForStubValue implements OffsetMapping {
                            private final Source source;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public enum Factory implements Factory<StubValue> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape STUB_VALUE_SOURCE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(StubValue.class).getDeclaredMethods().filter(ElementMatchers.named("source")).getOnly();

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<StubValue> getAnnotationType() {
                                    return StubValue.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable) {
                                    throw new UnsupportedOperationException("This factory does not support binding a method receiver");
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<StubValue> loadable) {
                                    if (inDefinedShape.getType().represents(Object.class)) {
                                        return new ForStubValue((Source) ((EnumerationDescription) loadable.getValue(STUB_VALUE_SOURCE).resolve(EnumerationDescription.class)).load(Source.class));
                                    }
                                    throw new IllegalStateException("Expected " + inDefinedShape + " to declare an Object type");
                                }
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final MethodDescription instrumentedMethod;
                                private final Source source;

                                public Resolved(Source source, MethodDescription methodDescription) {
                                    this.source = source;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    return DefaultValue.of(this.source.handle(methodHandle, this.instrumentedMethod).getReturnType());
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.source.equals(resolved.source) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + ((this.source.hashCode() + (getClass().hashCode() * 31)) * 31);
                                }
                            }

                            public ForStubValue(Source source) {
                                this.source = source;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.source.equals(((ForStubValue) obj).source);
                            }

                            public int hashCode() {
                                return this.source.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Resolved(this.source, methodDescription);
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public interface Resolved {

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class ForStackManipulation implements Resolved {
                                private final StackManipulation stackManipulation;

                                public ForStackManipulation(StackManipulation stackManipulation) {
                                    this.stackManipulation = stackManipulation;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    return this.stackManipulation;
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.stackManipulation.equals(((ForStackManipulation) obj).stackManipulation);
                                }

                                public int hashCode() {
                                    return this.stackManipulation.hashCode() + (getClass().hashCode() * 31);
                                }
                            }

                            StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i);
                        }

                        Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription);

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForThisReference implements OffsetMapping {
                            private final boolean optional;
                            private final Source source;
                            private final TypeDescription.Generic targetType;

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            private final Assigner.Typing typing;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final MethodDescription instrumentedMethod;
                                private final boolean optional;
                                private final Source source;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                public Resolved(TypeDescription.Generic generic, Assigner.Typing typing, Source source, boolean z, Assigner assigner, MethodDescription methodDescription) {
                                    this.targetType = generic;
                                    this.typing = typing;
                                    this.source = source;
                                    this.optional = z;
                                    this.assigner = assigner;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    Source.Value valueSelf = this.source.self(generic, map, target, this.instrumentedMethod);
                                    if (valueSelf == null) {
                                        if (this.optional) {
                                            return DefaultValue.of(this.targetType);
                                        }
                                        throw new IllegalStateException("No this reference available for " + target);
                                    }
                                    StackManipulation stackManipulationAssign = this.assigner.assign(valueSelf.getTypeDescription(), this.targetType, this.typing);
                                    if (stackManipulationAssign.isValid()) {
                                        return new StackManipulation.Compound(MethodVariableAccess.of(valueSelf.getTypeDescription()).loadFrom(valueSelf.getOffset()), stackManipulationAssign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + valueSelf.getTypeDescription() + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.optional == resolved.optional && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + dkz.h(this.assigner, (((this.source.hashCode() + ((this.typing.hashCode() + dkz.e(this.targetType, getClass().hashCode() * 31, 31)) * 31)) * 31) + (this.optional ? 1 : 0)) * 31, 31);
                                }
                            }

                            public ForThisReference(TypeDescription.Generic generic, @MaybeNull Assigner.Typing typing, Source source, boolean z) {
                                this.targetType = generic;
                                this.typing = typing;
                                this.source = source;
                                this.optional = z;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
                            
                                if (r2 != null) goto L21;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L4
                                    return r0
                                L4:
                                    r1 = 0
                                    if (r5 != 0) goto L8
                                    return r1
                                L8:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L13
                                    return r1
                                L13:
                                    boolean r2 = r4.optional
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForThisReference r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForThisReference) r5
                                    boolean r3 = r5.optional
                                    if (r2 == r3) goto L1c
                                    return r1
                                L1c:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L2b
                                    if (r2 == 0) goto L2d
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L2e
                                    return r1
                                L2b:
                                    if (r2 == 0) goto L2e
                                L2d:
                                    return r1
                                L2e:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L39
                                    return r1
                                L39:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L44
                                    return r1
                                L44:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForThisReference.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int iE = dkz.e(this.targetType, getClass().hashCode() * 31, 31);
                                Assigner.Typing typing = this.typing;
                                if (typing != null) {
                                    iE += typing.hashCode();
                                }
                                return ((this.source.hashCode() + (iE * 31)) * 31) + (this.optional ? 1 : 0);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                Assigner.Typing typing2 = this.typing;
                                return new Resolved(generic, typing2 == null ? typing : typing2, this.source, this.optional, assigner, methodDescription);
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<This> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape THIS_OPTIONAL;
                                private static final MethodDescription.InDefinedShape THIS_SOURCE;
                                private static final MethodDescription.InDefinedShape THIS_TYPING;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(This.class).getDeclaredMethods();
                                    THIS_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                                    THIS_SOURCE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("source")).getOnly();
                                    THIS_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("optional")).getOnly();
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<This> getAnnotationType() {
                                    return This.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable) {
                                    return new ForThisReference(inDefinedShape.getDeclaringType().asGenericType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(THIS_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(THIS_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<This> loadable) {
                                    return new ForThisReference(inDefinedShape.getType(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(THIS_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(THIS_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(THIS_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }
                            }
                        }

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class ForArgument implements OffsetMapping {
                            private final int index;
                            private final boolean optional;
                            private final Source source;
                            private final TypeDescription.Generic targetType;

                            @MaybeNull
                            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                            private final Assigner.Typing typing;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            @HashCodeAndEqualsPlugin.Enhance
                            public static class Resolved implements Resolved {
                                private final Assigner assigner;
                                private final int index;
                                private final MethodDescription instrumentedMethod;
                                private final boolean optional;
                                private final Source source;
                                private final TypeDescription.Generic targetType;
                                private final Assigner.Typing typing;

                                public Resolved(TypeDescription.Generic generic, int i, Assigner.Typing typing, Source source, boolean z, Assigner assigner, MethodDescription methodDescription) {
                                    this.targetType = generic;
                                    this.index = i;
                                    this.typing = typing;
                                    this.source = source;
                                    this.optional = z;
                                    this.assigner = assigner;
                                    this.instrumentedMethod = methodDescription;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Resolved
                                public StackManipulation apply(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, TypeDescription.Generic generic3, JavaConstant.MethodHandle methodHandle, Map<Integer, Integer> map, int i) {
                                    Source.Value valueArgument = this.source.argument(this.index, generic, map, target, this.instrumentedMethod);
                                    if (valueArgument == null) {
                                        if (this.optional) {
                                            return DefaultValue.of(this.targetType);
                                        }
                                        throw new IllegalStateException("No argument with index " + this.index + " available for " + target);
                                    }
                                    StackManipulation stackManipulationAssign = this.assigner.assign(valueArgument.getTypeDescription(), this.targetType, this.typing);
                                    if (stackManipulationAssign.isValid()) {
                                        return new StackManipulation.Compound(MethodVariableAccess.of(valueArgument.getTypeDescription()).loadFrom(valueArgument.getOffset()), stackManipulationAssign);
                                    }
                                    throw new IllegalStateException("Cannot assign " + valueArgument.getTypeDescription() + " to " + this.targetType);
                                }

                                public boolean equals(@MaybeNull Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (obj == null || getClass() != obj.getClass()) {
                                        return false;
                                    }
                                    Resolved resolved = (Resolved) obj;
                                    return this.index == resolved.index && this.optional == resolved.optional && this.typing.equals(resolved.typing) && this.source.equals(resolved.source) && this.targetType.equals(resolved.targetType) && this.assigner.equals(resolved.assigner) && this.instrumentedMethod.equals(resolved.instrumentedMethod);
                                }

                                public int hashCode() {
                                    return this.instrumentedMethod.hashCode() + dkz.h(this.assigner, (((this.source.hashCode() + ((this.typing.hashCode() + ((dkz.e(this.targetType, getClass().hashCode() * 31, 31) + this.index) * 31)) * 31)) * 31) + (this.optional ? 1 : 0)) * 31, 31);
                                }
                            }

                            public ForArgument(TypeDescription.Generic generic, int i, @MaybeNull Assigner.Typing typing, Source source, boolean z) {
                                this.targetType = generic;
                                this.index = i;
                                this.typing = typing;
                                this.source = source;
                                this.optional = z;
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
                            
                                if (r2 != null) goto L24;
                             */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                                /*
                                    r4 = this;
                                    r0 = 1
                                    if (r4 != r5) goto L4
                                    return r0
                                L4:
                                    r1 = 0
                                    if (r5 != 0) goto L8
                                    return r1
                                L8:
                                    java.lang.Class r2 = r4.getClass()
                                    java.lang.Class r3 = r5.getClass()
                                    if (r2 == r3) goto L13
                                    return r1
                                L13:
                                    int r2 = r4.index
                                    net.bytebuddy.asm.MemberSubstitution$Substitution$Chain$Step$ForDelegation$OffsetMapping$ForArgument r5 = (net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForArgument) r5
                                    int r3 = r5.index
                                    if (r2 == r3) goto L1c
                                    return r1
                                L1c:
                                    boolean r2 = r4.optional
                                    boolean r3 = r5.optional
                                    if (r2 == r3) goto L23
                                    return r1
                                L23:
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r2 = r4.typing
                                    net.bytebuddy.implementation.bytecode.assign.Assigner$Typing r3 = r5.typing
                                    if (r3 == 0) goto L32
                                    if (r2 == 0) goto L34
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L35
                                    return r1
                                L32:
                                    if (r2 == 0) goto L35
                                L34:
                                    return r1
                                L35:
                                    net.bytebuddy.asm.MemberSubstitution$Source r2 = r4.source
                                    net.bytebuddy.asm.MemberSubstitution$Source r3 = r5.source
                                    boolean r2 = r2.equals(r3)
                                    if (r2 != 0) goto L40
                                    return r1
                                L40:
                                    net.bytebuddy.description.type.TypeDescription$Generic r2 = r4.targetType
                                    net.bytebuddy.description.type.TypeDescription$Generic r5 = r5.targetType
                                    boolean r5 = r2.equals(r5)
                                    if (r5 != 0) goto L4b
                                    return r1
                                L4b:
                                    return r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.ForArgument.equals(java.lang.Object):boolean");
                            }

                            public int hashCode() {
                                int iE = (dkz.e(this.targetType, getClass().hashCode() * 31, 31) + this.index) * 31;
                                Assigner.Typing typing = this.typing;
                                if (typing != null) {
                                    iE += typing.hashCode();
                                }
                                return ((this.source.hashCode() + (iE * 31)) * 31) + (this.optional ? 1 : 0);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping
                            public Resolved resolve(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                TypeDescription.Generic generic = this.targetType;
                                int i = this.index;
                                Assigner.Typing typing2 = this.typing;
                                return new Resolved(generic, i, typing2 == null ? typing : typing2, this.source, this.optional, assigner, methodDescription);
                            }

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public enum Factory implements Factory<Argument> {
                                INSTANCE;

                                private static final MethodDescription.InDefinedShape ARGUMENT_OPTIONAL;
                                private static final MethodDescription.InDefinedShape ARGUMENT_SOURCE;
                                private static final MethodDescription.InDefinedShape ARGUMENT_TYPING;
                                private static final MethodDescription.InDefinedShape ARGUMENT_VALUE;

                                static {
                                    MethodList<MethodDescription.InDefinedShape> declaredMethods = TypeDescription.ForLoadedType.of(Argument.class).getDeclaredMethods();
                                    ARGUMENT_VALUE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("value")).getOnly();
                                    ARGUMENT_TYPING = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("typing")).getOnly();
                                    ARGUMENT_SOURCE = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("source")).getOnly();
                                    ARGUMENT_OPTIONAL = (MethodDescription.InDefinedShape) declaredMethods.filter(ElementMatchers.named("optional")).getOnly();
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public Class<Argument> getAnnotationType() {
                                    return Argument.class;
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(MethodDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable) {
                                    return new ForArgument(inDefinedShape.getDeclaringType().asGenericType(), ((Integer) loadable.getValue(ARGUMENT_VALUE).resolve(Integer.class)).intValue(), (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ARGUMENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ARGUMENT_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(ARGUMENT_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                }

                                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForDelegation.OffsetMapping.Factory
                                public OffsetMapping make(ParameterDescription.InDefinedShape inDefinedShape, AnnotationDescription.Loadable<Argument> loadable) {
                                    int iIntValue = ((Integer) loadable.getValue(ARGUMENT_VALUE).resolve(Integer.class)).intValue();
                                    if (iIntValue >= 0) {
                                        return new ForArgument(inDefinedShape.getType(), iIntValue, (Assigner.Typing) ((EnumerationDescription) loadable.getValue(ARGUMENT_TYPING).resolve(EnumerationDescription.class)).load(Assigner.Typing.class), (Source) ((EnumerationDescription) loadable.getValue(ARGUMENT_SOURCE).resolve(EnumerationDescription.class)).load(Source.class), ((Boolean) loadable.getValue(ARGUMENT_OPTIONAL).resolve(Boolean.class)).booleanValue());
                                    }
                                    throw new IllegalStateException("Cannot assign negative parameter index " + iIntValue + " for " + inDefinedShape);
                                }
                            }
                        }
                    }

                    public static Factory<Target> to(Constructor<?> constructor) {
                        return to(new MethodDescription.ForLoadedConstructor(constructor));
                    }

                    public static Factory<Target> to(MethodDescription.InDefinedShape inDefinedShape) {
                        if (!inDefinedShape.isTypeInitializer()) {
                            return to(inDefinedShape, Dispatcher.ForRegularInvocation.Factory.INSTANCE, Collections.EMPTY_LIST);
                        }
                        throw new IllegalArgumentException("Cannot delegate to a type initializer: " + inDefinedShape);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static Factory<Target> to(MethodDescription.InDefinedShape inDefinedShape, Dispatcher.Factory factory, List<? extends OffsetMapping.Factory<?>> list) {
                        if (!inDefinedShape.isTypeInitializer()) {
                            return new Factory(inDefinedShape, factory.make(inDefinedShape), CompoundList.of(Arrays.asList(OffsetMapping.ForArgument.Factory.INSTANCE, OffsetMapping.ForThisReference.Factory.INSTANCE, OffsetMapping.ForAllArguments.Factory.INSTANCE, OffsetMapping.ForSelfCallHandle.Factory.INSTANCE, OffsetMapping.ForHandle.Factory.INSTANCE, OffsetMapping.ForDynamicConstant.Factory.INSTANCE, OffsetMapping.ForField.Unresolved.Factory.INSTANCE, OffsetMapping.ForFieldHandle.Unresolved.GetterFactory.INSTANCE, OffsetMapping.ForFieldHandle.Unresolved.SetterFactory.INSTANCE, OffsetMapping.ForOrigin.Factory.INSTANCE, OffsetMapping.ForStubValue.Factory.INSTANCE, new OffsetMapping.ForStackManipulation.OfDefaultValue(Unused.class), OffsetMapping.ForCurrent.Factory.INSTANCE), (List) list));
                        }
                        throw new IllegalArgumentException("Cannot delegate to type initializer: " + inDefinedShape);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static abstract class ForField implements Step<Target> {
                    protected final Assigner assigner;
                    protected final FieldDescription fieldDescription;
                    protected final Assigner.Typing typing;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Read extends ForField {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Factory implements Factory<Target> {
                            private final FieldDescription fieldDescription;

                            public Factory(Field field) {
                                this(new FieldDescription.ForLoadedField(field));
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Factory) obj).fieldDescription);
                            }

                            public int hashCode() {
                                return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                            public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Read(this.fieldDescription, assigner, typing);
                            }

                            public Factory(FieldDescription fieldDescription) {
                                this.fieldDescription = fieldDescription;
                            }
                        }

                        public Read(FieldDescription fieldDescription, Assigner assigner, Assigner.Typing typing) {
                            super(fieldDescription, assigner, typing);
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public Resolution doResolve(Target target, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation) {
                            return new Simple(new StackManipulation.Compound(stackManipulation, FieldAccess.forField(this.fieldDescription).read()), this.fieldDescription.getType());
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass();
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public int hashCode() {
                            return super.hashCode();
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Write extends ForField {
                        private final int index;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Factory implements Factory<Target> {
                            private final FieldDescription fieldDescription;
                            private final int index;

                            public Factory(Field field, int i) {
                                this(new FieldDescription.ForLoadedField(field), i);
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Factory factory = (Factory) obj;
                                return this.index == factory.index && this.fieldDescription.equals(factory.fieldDescription);
                            }

                            public int hashCode() {
                                return ((this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31) + this.index;
                            }

                            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                            public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                                return new Write(this.fieldDescription, assigner, typing, this.index);
                            }

                            public Factory(FieldDescription fieldDescription, int i) {
                                this.fieldDescription = fieldDescription;
                                this.index = i;
                            }
                        }

                        public Write(FieldDescription fieldDescription, Assigner assigner, Assigner.Typing typing, int i) {
                            super(fieldDescription, assigner, typing);
                            this.index = i;
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public Resolution doResolve(Target target, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation) {
                            int i = target.isStaticDispatch() ? this.index : this.index + 1;
                            if (i >= generic.size()) {
                                throw new IllegalStateException(bjs.i(i, "Target does not define an argument with index "));
                            }
                            StackManipulation stackManipulationAssign = this.assigner.assign(generic.get(i), this.fieldDescription.getType(), this.typing);
                            if (stackManipulationAssign.isValid()) {
                                return new Simple(new StackManipulation.Compound(stackManipulation, MethodVariableAccess.of(generic.get(i)).loadFrom(map.get(Integer.valueOf(i)).intValue()), stackManipulationAssign, FieldAccess.forField(this.fieldDescription).write()), TypeDefinition.Sort.describe(Void.TYPE));
                            }
                            throw new IllegalStateException("Cannot write " + generic.get(i) + " to " + this.fieldDescription);
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public boolean equals(@MaybeNull Object obj) {
                            if (!super.equals(obj)) {
                                return false;
                            }
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.index == ((Write) obj).index;
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField
                        public int hashCode() {
                            return (super.hashCode() * 31) + this.index;
                        }
                    }

                    public ForField(FieldDescription fieldDescription, Assigner assigner, Assigner.Typing typing) {
                        this.fieldDescription = fieldDescription;
                        this.assigner = assigner;
                        this.typing = typing;
                    }

                    public abstract Resolution doResolve(Target target, TypeList.Generic generic, Map<Integer, Integer> map, StackManipulation stackManipulation);

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForField forField = (ForField) obj;
                        return this.typing.equals(forField.typing) && this.fieldDescription.equals(forField.fieldDescription) && this.assigner.equals(forField.assigner);
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + dkz.h(this.assigner, (this.fieldDescription.hashCode() + (getClass().hashCode() * 31)) * 31, 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        ArrayList arrayList = new ArrayList(2);
                        if (this.fieldDescription.isStatic()) {
                            arrayList.add(Removal.of(generic3));
                        } else {
                            StackManipulation stackManipulationAssign = this.assigner.assign(generic3, this.fieldDescription.getDeclaringType().asGenericType(), this.typing);
                            if (!stackManipulationAssign.isValid()) {
                                throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.fieldDescription.getDeclaringType());
                            }
                            arrayList.add(stackManipulationAssign);
                        }
                        return doResolve(target, generic, map, new StackManipulation.Compound(arrayList));
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForInvocation implements Step<Target> {
                    private final Assigner assigner;
                    private final MethodDescription methodDescription;
                    private final Map<Integer, Integer> substitutions;
                    private final Assigner.Typing typing;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory<Target> {
                        private final MethodDescription methodDescription;
                        private final Map<Integer, Integer> substitutions;

                        public Factory(Method method) {
                            this(new MethodDescription.ForLoadedMethod(method));
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Factory factory = (Factory) obj;
                            return this.methodDescription.equals(factory.methodDescription) && this.substitutions.equals(factory.substitutions);
                        }

                        public int hashCode() {
                            return this.substitutions.hashCode() + dkz.c(this.methodDescription, getClass().hashCode() * 31, 31);
                        }

                        @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                        public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                            return new ForInvocation(this.methodDescription, this.substitutions, assigner, typing);
                        }

                        public Factory(Method method, Map<Integer, Integer> map) {
                            this(new MethodDescription.ForLoadedMethod(method), map);
                        }

                        public Factory(Constructor<?> constructor) {
                            this(new MethodDescription.ForLoadedConstructor(constructor));
                        }

                        public Factory(Constructor<?> constructor, Map<Integer, Integer> map) {
                            this(new MethodDescription.ForLoadedConstructor(constructor), map);
                        }

                        public Factory(MethodDescription methodDescription) {
                            this(methodDescription, (Map<Integer, Integer>) Collections.EMPTY_MAP);
                        }

                        public Factory(MethodDescription methodDescription, Map<Integer, Integer> map) {
                            this.methodDescription = methodDescription;
                            this.substitutions = map;
                        }
                    }

                    public ForInvocation(MethodDescription methodDescription, Map<Integer, Integer> map, Assigner assigner, Assigner.Typing typing) {
                        this.methodDescription = methodDescription;
                        this.substitutions = map;
                        this.assigner = assigner;
                        this.typing = typing;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForInvocation forInvocation = (ForInvocation) obj;
                        return this.typing.equals(forInvocation.typing) && this.methodDescription.equals(forInvocation.methodDescription) && this.substitutions.equals(forInvocation.substitutions) && this.assigner.equals(forInvocation.assigner);
                    }

                    public int hashCode() {
                        return this.typing.hashCode() + dkz.h(this.assigner, yg.c(this.substitutions, dkz.c(this.methodDescription, getClass().hashCode() * 31, 31), 31), 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        ArrayList arrayList = new ArrayList((generic.size() * 2) + 3);
                        if (this.methodDescription.isStatic()) {
                            arrayList.add(Removal.of(generic3));
                        } else if (this.methodDescription.isConstructor()) {
                            arrayList.add(Removal.of(generic3));
                            arrayList.add(TypeCreation.of(this.methodDescription.getDeclaringType().asErasure()));
                        } else {
                            StackManipulation stackManipulationAssign = this.assigner.assign(generic3, this.methodDescription.getDeclaringType().asGenericType(), this.typing);
                            if (!stackManipulationAssign.isValid()) {
                                throw new IllegalStateException("Cannot assign " + generic3 + " to " + this.methodDescription.getDeclaringType());
                            }
                            arrayList.add(stackManipulationAssign);
                        }
                        int i2 = !target.isStaticDispatch() ? 1 : 0;
                        for (int i3 = 0; i3 < this.methodDescription.getParameters().size(); i3++) {
                            int iIntValue = this.substitutions.containsKey(Integer.valueOf(i3 + i2)) ? this.substitutions.get(Integer.valueOf(i3 + i2)).intValue() : i3 + i2;
                            if (iIntValue >= generic.size()) {
                                throw new IllegalStateException(target + " does not support an index " + iIntValue);
                            }
                            arrayList.add(MethodVariableAccess.of(generic.get(iIntValue)).loadFrom(map.get(Integer.valueOf(iIntValue)).intValue()));
                            StackManipulation stackManipulationAssign2 = this.assigner.assign(generic.get(iIntValue), ((ParameterDescription) this.methodDescription.getParameters().get(i3)).getType(), this.typing);
                            if (!stackManipulationAssign2.isValid()) {
                                StringBuilder sbR = yg.r(i3, "Cannot assign parameter with ", " of type ");
                                sbR.append(generic.get(iIntValue));
                                sbR.append(" to ");
                                sbR.append(this.methodDescription);
                                throw new IllegalStateException(sbR.toString());
                            }
                            arrayList.add(stackManipulationAssign2);
                        }
                        arrayList.add(MethodInvocation.invoke(this.methodDescription));
                        return new Simple(new StackManipulation.Compound(arrayList), this.methodDescription.getReturnType());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum OfOriginalExpression implements Step<Target>, Factory<Target> {
                    INSTANCE;

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                    public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        ArrayList arrayList;
                        int i2 = 0;
                        if (!(target instanceof Target.ForMember)) {
                            if (!(target instanceof Target.ForDynamicInvocation)) {
                                throw new IllegalStateException("Unexpected target: " + target);
                            }
                            ArrayList arrayList2 = new ArrayList(generic.size() + 4);
                            arrayList2.add(Removal.of(generic3));
                            while (i2 < generic.size()) {
                                arrayList2.add(MethodVariableAccess.of(generic.get(i2)).loadFrom(map.get(Integer.valueOf(i2)).intValue()));
                                i2++;
                            }
                            arrayList2.add(stackManipulation);
                            return new Simple(new StackManipulation.Compound(arrayList2), ((Target.ForDynamicInvocation) target).getMethodType().getReturnType().asGenericType());
                        }
                        ByteCodeElement.Member member = ((Target.ForMember) target).getMember();
                        boolean z = member instanceof MethodDescription;
                        if (z && ((MethodDescription) member).isConstructor()) {
                            arrayList = new ArrayList(generic.size() + 4);
                            arrayList.add(Removal.of(generic3));
                            arrayList.add(TypeCreation.of(member.getDeclaringType().asErasure()));
                            arrayList.add(Duplication.SINGLE);
                        } else {
                            arrayList = new ArrayList(generic.size() + 4);
                            arrayList.add(Removal.of(generic3));
                        }
                        while (i2 < generic.size()) {
                            arrayList.add(MethodVariableAccess.of(generic.get(i2)).loadFrom(map.get(Integer.valueOf(i2)).intValue()));
                            i2++;
                        }
                        if (z) {
                            arrayList.add(stackManipulation);
                            MethodDescription methodDescription = (MethodDescription) member;
                            return new Simple(new StackManipulation.Compound(arrayList), methodDescription.isConstructor() ? member.getDeclaringType().asGenericType() : methodDescription.getReturnType());
                        }
                        if (!(member instanceof FieldDescription)) {
                            throw new IllegalStateException("Unexpected member: " + member);
                        }
                        boolean zIsStatic = member.isStatic();
                        Class cls = Void.TYPE;
                        if (zIsStatic) {
                            if (generic.isEmpty()) {
                                arrayList.add(stackManipulation);
                                return new Simple(new StackManipulation.Compound(arrayList), ((FieldDescription) member).getType());
                            }
                            arrayList.add(stackManipulation);
                            return new Simple(new StackManipulation.Compound(arrayList), TypeDefinition.Sort.describe(cls));
                        }
                        if (generic.size() != 1) {
                            arrayList.add(FieldAccess.forField((FieldDescription) member).write());
                            return new Simple(new StackManipulation.Compound(arrayList), TypeDefinition.Sort.describe(cls));
                        }
                        FieldDescription fieldDescription = (FieldDescription) member;
                        arrayList.add(FieldAccess.forField(fieldDescription).read());
                        return new Simple(new StackManipulation.Compound(arrayList), fieldDescription.getType());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Resolution {
                    TypeDescription.Generic getResultType();

                    StackManipulation getStackManipulation();
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements Step<Target>, Factory<Target>, Resolution {
                    private final TypeDescription.Generic resultType;
                    private final StackManipulation stackManipulation;

                    public Simple(StackManipulation stackManipulation, java.lang.reflect.Type type) {
                        this(stackManipulation, TypeDefinition.Sort.describe(type));
                    }

                    public static Factory<Target> of(Object obj) {
                        ConstantValue constantValueWrap = ConstantValue.Simple.wrap(obj);
                        return new Simple(constantValueWrap.toStackManipulation(), constantValueWrap.getTypeDescription().asGenericType());
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Simple simple = (Simple) obj;
                        return this.stackManipulation.equals(simple.stackManipulation) && this.resultType.equals(simple.resultType);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Resolution
                    public TypeDescription.Generic getResultType() {
                        return this.resultType;
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Resolution
                    public StackManipulation getStackManipulation() {
                        return this.stackManipulation;
                    }

                    public int hashCode() {
                        return this.resultType.hashCode() + dkz.g(this.stackManipulation, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.Factory
                    public Step<Target> make(Assigner assigner, Assigner.Typing typing, TypeDescription typeDescription, MethodDescription methodDescription) {
                        return this;
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step
                    public Resolution resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i) {
                        return generic3.represents(Void.TYPE) ? this : new Simple(new StackManipulation.Compound(Removal.of(generic3), this.stackManipulation), this.resultType);
                    }

                    public Simple(StackManipulation stackManipulation, TypeDescription.Generic generic) {
                        this.stackManipulation = stackManipulation;
                        this.resultType = generic;
                    }
                }

                Resolution resolve(U u, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, TypeDescription.Generic generic3, Map<Integer, Integer> map, int i);
            }

            public Chain(Assigner assigner, Assigner.Typing typing, List<Step<? super S>> list) {
                this.assigner = assigner;
                this.typing = typing;
                this.steps = list;
            }

            public static <U extends Target> Factory<U> with(Assigner assigner, Assigner.Typing typing) {
                return new Factory<>(assigner, typing, Collections.EMPTY_LIST);
            }

            public static <U extends Target> Factory<U> withDefaultAssigner() {
                return with(Assigner.DEFAULT, Assigner.Typing.STATIC);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Chain chain = (Chain) obj;
                return this.typing.equals(chain.typing) && this.assigner.equals(chain.assigner) && this.steps.equals(chain.steps);
            }

            public int hashCode() {
                return this.steps.hashCode() + ((this.typing.hashCode() + dkz.h(this.assigner, getClass().hashCode() * 31, 31)) * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution
            public StackManipulation resolve(S s, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                ArrayList arrayList = new ArrayList((this.steps.size() * 2) + generic.size() + 1 + (generic2.represents(Void.TYPE) ? 0 : 2));
                HashMap map = new HashMap();
                int size = i;
                for (int size2 = generic.size() - 1; size2 >= 0; size2--) {
                    arrayList.add(MethodVariableAccess.of(generic.get(size2)).storeAt(size));
                    map.put(Integer.valueOf(size2), Integer.valueOf(size));
                    size += generic.get(size2).getStackSize().getSize();
                }
                arrayList.add(DefaultValue.of(generic2));
                Iterator<Step<? super S>> it = this.steps.iterator();
                TypeDescription.Generic resultType = generic2;
                while (it.hasNext()) {
                    Step.Resolution resolutionResolve = it.next().resolve(s, generic, generic2, methodHandle, stackManipulation, resultType, map, size);
                    arrayList.add(resolutionResolve.getStackManipulation());
                    resultType = resolutionResolve.getResultType();
                }
                StackManipulation stackManipulationAssign = this.assigner.assign(resultType, generic2, this.typing);
                if (stackManipulationAssign.isValid()) {
                    arrayList.add(stackManipulationAssign);
                    return new StackManipulation.Compound(arrayList);
                }
                throw new IllegalStateException("Failed to assign " + resultType + " to " + generic2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Factory<S extends Target> {
            Substitution<? super S> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFieldAccess implements Substitution<Target> {
            private final FieldResolver fieldResolver;
            private final TypeDescription instrumentedType;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface FieldResolver {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForElementMatcher implements FieldResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super FieldDescription> matcher;

                    public ForElementMatcher(TypeDescription typeDescription, ElementMatcher<? super FieldDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForElementMatcher forElementMatcher = (ForElementMatcher) obj;
                        return this.instrumentedType.equals(forElementMatcher.instrumentedType) && this.matcher.equals(forElementMatcher.matcher);
                    }

                    public int hashCode() {
                        return this.matcher.hashCode() + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.ForFieldAccess.FieldResolver
                    public FieldDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + generic);
                        }
                        if (generic.get(0).isPrimitive() || generic.get(0).isArray()) {
                            throw new IllegalStateException("Cannot access field on primitive or array type for " + generic.get(0));
                        }
                        TypeDefinition superClass = (TypeDefinition) generic.get(0).accept(new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
                        do {
                            FieldList fieldListFilter = superClass.getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic()).and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher));
                            if (fieldListFilter.size() == 1) {
                                return (FieldDescription) fieldListFilter.getOnly();
                            }
                            if (fieldListFilter.size() > 1) {
                                throw new IllegalStateException("Ambiguous field location of " + fieldListFilter);
                            }
                            superClass = superClass.getSuperClass();
                        } while (superClass != null);
                        throw new IllegalStateException("Cannot locate field matching " + this.matcher + " on " + target);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements FieldResolver {
                    private final FieldDescription fieldDescription;

                    public Simple(FieldDescription fieldDescription) {
                        this.fieldDescription = fieldDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((Simple) obj).fieldDescription);
                    }

                    public int hashCode() {
                        return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.ForFieldAccess.FieldResolver
                    public FieldDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.fieldDescription;
                    }
                }

                FieldDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenField implements Factory<Target> {
                private final FieldDescription fieldDescription;

                public OfGivenField(FieldDescription fieldDescription) {
                    this.fieldDescription = fieldDescription;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.fieldDescription.equals(((OfGivenField) obj).fieldDescription);
                }

                public int hashCode() {
                    return this.fieldDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.Simple(this.fieldDescription));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedField implements Factory<Target> {
                private final ElementMatcher<? super FieldDescription> matcher;

                public OfMatchedField(ElementMatcher<? super FieldDescription> elementMatcher) {
                    this.matcher = elementMatcher;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.matcher.equals(((OfMatchedField) obj).matcher);
                }

                public int hashCode() {
                    return this.matcher.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForFieldAccess(typeDescription, new FieldResolver.ForElementMatcher(typeDescription, this.matcher));
                }
            }

            public ForFieldAccess(TypeDescription typeDescription, FieldResolver fieldResolver) {
                this.instrumentedType = typeDescription;
                this.fieldResolver = fieldResolver;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForFieldAccess forFieldAccess = (ForFieldAccess) obj;
                return this.instrumentedType.equals(forFieldAccess.instrumentedType) && this.fieldResolver.equals(forFieldAccess.fieldResolver);
            }

            public int hashCode() {
                return this.fieldResolver.hashCode() + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution
            public StackManipulation resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                FieldDescription fieldDescriptionResolve = this.fieldResolver.resolve(target, generic, generic2);
                if (!fieldDescriptionResolve.isAccessibleTo(this.instrumentedType)) {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + fieldDescriptionResolve);
                }
                if (generic2.represents(Void.TYPE)) {
                    if (generic.size() != (fieldDescriptionResolve.isStatic() ? 1 : 2)) {
                        throw new IllegalStateException("Cannot set " + fieldDescriptionResolve + " with " + generic);
                    }
                    if (!fieldDescriptionResolve.isStatic() && !generic.get(0).asErasure().isAssignableTo(fieldDescriptionResolve.getDeclaringType().asErasure())) {
                        throw new IllegalStateException("Cannot set " + fieldDescriptionResolve + " on " + generic.get(0));
                    }
                    if (generic.get(!fieldDescriptionResolve.isStatic() ? 1 : 0).asErasure().isAssignableTo(fieldDescriptionResolve.getType().asErasure())) {
                        return FieldAccess.forField(fieldDescriptionResolve).write();
                    }
                    throw new IllegalStateException("Cannot set " + fieldDescriptionResolve + " to " + generic.get(!fieldDescriptionResolve.isStatic() ? 1 : 0));
                }
                if (generic.size() != (1 ^ (fieldDescriptionResolve.isStatic() ? 1 : 0))) {
                    throw new IllegalStateException("Cannot set " + fieldDescriptionResolve + " with " + generic);
                }
                if (!fieldDescriptionResolve.isStatic() && !generic.get(0).asErasure().isAssignableTo(fieldDescriptionResolve.getDeclaringType().asErasure())) {
                    throw new IllegalStateException("Cannot get " + fieldDescriptionResolve + " on " + generic.get(0));
                }
                if (fieldDescriptionResolve.getType().asErasure().isAssignableTo(generic2.asErasure())) {
                    return FieldAccess.forField(fieldDescriptionResolve).read();
                }
                throw new IllegalStateException("Cannot get " + fieldDescriptionResolve + " as " + generic2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMethodInvocation implements Substitution<Target> {
            private final TypeDescription instrumentedType;
            private final MethodResolver methodResolver;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface MethodResolver {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Matching implements MethodResolver {
                    private final TypeDescription instrumentedType;
                    private final ElementMatcher<? super MethodDescription> matcher;
                    private final MethodGraph.Compiler methodGraphCompiler;

                    public Matching(TypeDescription typeDescription, MethodGraph.Compiler compiler, ElementMatcher<? super MethodDescription> elementMatcher) {
                        this.instrumentedType = typeDescription;
                        this.methodGraphCompiler = compiler;
                        this.matcher = elementMatcher;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Matching matching = (Matching) obj;
                        return this.instrumentedType.equals(matching.instrumentedType) && this.methodGraphCompiler.equals(matching.methodGraphCompiler) && this.matcher.equals(matching.matcher);
                    }

                    public int hashCode() {
                        return this.matcher.hashCode() + ((this.methodGraphCompiler.hashCode() + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver
                    public MethodDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        if (generic.isEmpty()) {
                            throw new IllegalStateException("Cannot substitute parameterless instruction with " + generic);
                        }
                        if (generic.get(0).isPrimitive() || generic.get(0).isArray()) {
                            throw new IllegalStateException("Cannot invoke method on primitive or array type for " + generic.get(0));
                        }
                        TypeDefinition typeDefinition = (TypeDefinition) generic.get(0).accept(new TypeDescription.Generic.Visitor.Substitutor.ForReplacement(this.instrumentedType));
                        List listOf = CompoundList.of(this.methodGraphCompiler.compile(typeDefinition, this.instrumentedType).listNodes().asMethodList().filter(this.matcher), typeDefinition.getDeclaredMethods().filter(ElementMatchers.isPrivate().and(ElementMatchers.isVisibleTo(this.instrumentedType)).and(this.matcher)));
                        if (listOf.size() == 1) {
                            return (MethodDescription) listOf.get(0);
                        }
                        throw new IllegalStateException("Not exactly one method that matches " + this.matcher + ": " + listOf);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Simple implements MethodResolver {
                    private final MethodDescription methodDescription;

                    public Simple(MethodDescription methodDescription) {
                        this.methodDescription = methodDescription;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((Simple) obj).methodDescription);
                    }

                    public int hashCode() {
                        return this.methodDescription.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver
                    public MethodDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2) {
                        return this.methodDescription;
                    }
                }

                MethodDescription resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfGivenMethod implements Factory<Target> {
                private final MethodDescription methodDescription;

                public OfGivenMethod(MethodDescription methodDescription) {
                    this.methodDescription = methodDescription;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.methodDescription.equals(((OfGivenMethod) obj).methodDescription);
                }

                public int hashCode() {
                    return this.methodDescription.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(this.methodDescription));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum OfInstrumentedMethod implements Factory<Target> {
                INSTANCE;

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Simple(methodDescription));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfMatchedMethod implements Factory<Target> {
                private final ElementMatcher<? super MethodDescription> matcher;
                private final MethodGraph.Compiler methodGraphCompiler;

                public OfMatchedMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
                    this.matcher = elementMatcher;
                    this.methodGraphCompiler = compiler;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    OfMatchedMethod ofMatchedMethod = (OfMatchedMethod) obj;
                    return this.matcher.equals(ofMatchedMethod.matcher) && this.methodGraphCompiler.equals(ofMatchedMethod.methodGraphCompiler);
                }

                public int hashCode() {
                    return this.methodGraphCompiler.hashCode() + dkz.i(this.matcher, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
                public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForMethodInvocation(typeDescription, new MethodResolver.Matching(typeDescription, this.methodGraphCompiler, this.matcher));
                }
            }

            public ForMethodInvocation(TypeDescription typeDescription, MethodResolver methodResolver) {
                this.instrumentedType = typeDescription;
                this.methodResolver = methodResolver;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMethodInvocation forMethodInvocation = (ForMethodInvocation) obj;
                return this.instrumentedType.equals(forMethodInvocation.instrumentedType) && this.methodResolver.equals(forMethodInvocation.methodResolver);
            }

            public int hashCode() {
                return this.methodResolver.hashCode() + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution
            public StackManipulation resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                MethodDescription methodDescriptionResolve = this.methodResolver.resolve(target, generic, generic2);
                if (!methodDescriptionResolve.isAccessibleTo(this.instrumentedType)) {
                    throw new IllegalStateException(this.instrumentedType + " cannot access " + methodDescriptionResolve);
                }
                List listAsTypeList = methodDescriptionResolve.isStatic() ? methodDescriptionResolve.getParameters().asTypeList() : new TypeList.Generic.Explicit((List<? extends TypeDefinition>) CompoundList.of(methodDescriptionResolve.getDeclaringType(), methodDescriptionResolve.getParameters().asTypeList()));
                if (!methodDescriptionResolve.getReturnType().asErasure().isAssignableTo(generic2.asErasure())) {
                    throw new IllegalStateException("Cannot assign return value of " + methodDescriptionResolve + " to " + generic2);
                }
                if (listAsTypeList.size() != generic.size()) {
                    throw new IllegalStateException("Cannot invoke " + methodDescriptionResolve + " on " + generic.size() + " parameters");
                }
                for (int i2 = 0; i2 < listAsTypeList.size(); i2++) {
                    if (!generic.get(i2).asErasure().isAssignableTo(((TypeDescription.Generic) listAsTypeList.get(i2)).asErasure())) {
                        throw new IllegalStateException("Cannot invoke " + methodDescriptionResolve + " on parameter " + i2 + " of type " + generic.get(i2));
                    }
                }
                boolean zIsVirtual = methodDescriptionResolve.isVirtual();
                MethodInvocation.WithImplicitInvocationTargetType withImplicitInvocationTargetTypeInvoke = MethodInvocation.invoke(methodDescriptionResolve);
                return zIsVirtual ? withImplicitInvocationTargetTypeInvoke.virtual(((TypeDescription.Generic) listAsTypeList.get(0)).asErasure()) : withImplicitInvocationTargetTypeInvoke;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForValue implements Substitution<Target>, Factory<Target> {
            private final StackManipulation stackManipulation;
            private final TypeDescription.Generic typeDescription;

            public ForValue(StackManipulation stackManipulation, TypeDescription.Generic generic) {
                this.stackManipulation = stackManipulation;
                this.typeDescription = generic;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForValue forValue = (ForValue) obj;
                return this.stackManipulation.equals(forValue.stackManipulation) && this.typeDescription.equals(forValue.typeDescription);
            }

            public int hashCode() {
                return this.typeDescription.hashCode() + dkz.g(this.stackManipulation, getClass().hashCode() * 31, 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
            public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution
            public StackManipulation resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                ArrayList arrayList = new ArrayList(generic.size());
                for (int size = generic.size() - 1; size >= 0; size--) {
                    arrayList.add(Removal.of(generic.get(size)));
                }
                if (this.typeDescription.asErasure().isAssignableTo(generic2.asErasure())) {
                    return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(arrayList, this.stackManipulation));
                }
                throw new IllegalStateException("Cannot assign " + this.typeDescription + " to " + generic2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Stubbing implements Substitution<Target>, Factory<Target> {
            INSTANCE;

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution.Factory
            public Substitution<Target> make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Substitution
            public StackManipulation resolve(Target target, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                ArrayList arrayList = new ArrayList(generic.size());
                for (int size = generic.size() - 1; size >= 0; size--) {
                    arrayList.add(Removal.of(generic.get(size)));
                }
                return new StackManipulation.Compound((List<? extends StackManipulation>) CompoundList.of(arrayList, DefaultValue.of(generic2.asErasure())));
            }
        }

        StackManipulation resolve(T t, TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Target {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class ForDynamicInvocation implements Target {
            private final List<? extends JavaConstant> arguments;
            private final JavaConstant.MethodType methodType;
            private final String name;

            public ForDynamicInvocation(JavaConstant.MethodType methodType, String str, List<? extends JavaConstant> list) {
                this.methodType = methodType;
                this.name = str;
                this.arguments = list;
            }

            public List<? extends JavaConstant> getArguments() {
                return this.arguments;
            }

            public JavaConstant.MethodType getMethodType() {
                return this.methodType;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Target
            public String getName() {
                return this.name;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Target
            public boolean isStaticDispatch() {
                return true;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class ForMember implements Target {
            private final ByteCodeElement.Member member;
            private final TypeDescription receiverType;

            public ForMember(TypeDescription typeDescription, ByteCodeElement.Member member) {
                this.receiverType = typeDescription;
                this.member = member;
            }

            public ByteCodeElement.Member getMember() {
                return this.member;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Target
            public String getName() {
                return this.member.getInternalName();
            }

            public TypeDescription getReceiverType() {
                return this.receiverType;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Target
            public boolean isStaticDispatch() {
                if (this.member.isStatic()) {
                    return true;
                }
                ByteCodeElement.Member member = this.member;
                return (member instanceof MethodDescription) && ((MethodDescription) member).isConstructor();
            }
        }

        String getName();

        boolean isStaticDispatch();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface This {
        boolean optional() default false;

        Source source() default Source.SUBSTITUTED_ELEMENT;

        Assigner.Typing typing() default Assigner.Typing.STATIC;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface TypePoolResolver {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForClassFileLocator implements TypePoolResolver {
            private final ClassFileLocator classFileLocator;
            private final TypePool.Default.ReaderMode readerMode;

            public ForClassFileLocator(ClassFileLocator classFileLocator) {
                this(classFileLocator, TypePool.Default.ReaderMode.FAST);
            }

            public static TypePoolResolver of(@MaybeNull ClassLoader classLoader) {
                return new ForClassFileLocator(ClassFileLocator.ForClassLoader.of(classLoader));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForClassFileLocator forClassFileLocator = (ForClassFileLocator) obj;
                return this.readerMode.equals(forClassFileLocator.readerMode) && this.classFileLocator.equals(forClassFileLocator.classFileLocator);
            }

            public int hashCode() {
                return this.readerMode.hashCode() + ((this.classFileLocator.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.TypePoolResolver
            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return new TypePool.Default(new TypePool.CacheProvider.Simple(), this.classFileLocator, this.readerMode, typePool);
            }

            public ForClassFileLocator(ClassFileLocator classFileLocator, TypePool.Default.ReaderMode readerMode) {
                this.classFileLocator = classFileLocator;
                this.readerMode = readerMode;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForExplicitPool implements TypePoolResolver {
            private final TypePool typePool;

            public ForExplicitPool(TypePool typePool) {
                this.typePool = typePool;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typePool.equals(((ForExplicitPool) obj).typePool);
            }

            public int hashCode() {
                return this.typePool.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.TypePoolResolver
            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this.typePool;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum OfImplicitPool implements TypePoolResolver {
            INSTANCE;

            @Override // net.bytebuddy.asm.MemberSubstitution.TypePoolResolver
            public TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return typePool;
            }
        }

        TypePool resolve(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @java.lang.annotation.Target({ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Unused {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class WithoutSpecification<T extends Target> {
        protected final boolean failIfNoMatch;
        protected final MethodGraph.Compiler methodGraphCompiler;
        protected final Replacement.Factory replacementFactory;
        protected final boolean strict;
        protected final TypePoolResolver typePoolResolver;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedByteCodeElement extends WithoutSpecification<Target.ForMember> {
            private final ElementMatcher<? super ByteCodeElement.Member> matcher;

            public ForMatchedByteCodeElement(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super ByteCodeElement.Member> elementMatcher) {
                super(compiler, typePoolResolver, z, z2, factory);
                this.matcher = elementMatcher;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ForMatchedByteCodeElement) obj).matcher);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public int hashCode() {
                return this.matcher.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public MemberSubstitution replaceWith(Substitution.Factory<? super Target.ForMember> factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.of(this.matcher, factory)));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedDynamicInvocation extends WithoutSpecification<Target.ForDynamicInvocation> {
            private final ElementMatcher.Junction<? super List<? extends JavaConstant>> argumentsMatcher;
            private final ElementMatcher<? super JavaConstant.MethodHandle> handleMatcher;
            private final ElementMatcher.Junction<? super String> nameMatcher;
            private final ElementMatcher.Junction<? super JavaConstant.MethodType> typeMatcher;

            public ForMatchedDynamicInvocation(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super JavaConstant.MethodHandle> elementMatcher, ElementMatcher.Junction<? super String> junction, ElementMatcher.Junction<? super JavaConstant.MethodType> junction2, ElementMatcher.Junction<? super List<? extends JavaConstant>> junction3) {
                super(compiler, typePoolResolver, z, z2, factory);
                this.handleMatcher = elementMatcher;
                this.nameMatcher = junction;
                this.typeMatcher = junction2;
                this.argumentsMatcher = junction3;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMatchedDynamicInvocation forMatchedDynamicInvocation = (ForMatchedDynamicInvocation) obj;
                return this.handleMatcher.equals(forMatchedDynamicInvocation.handleMatcher) && this.nameMatcher.equals(forMatchedDynamicInvocation.nameMatcher) && this.typeMatcher.equals(forMatchedDynamicInvocation.typeMatcher) && this.argumentsMatcher.equals(forMatchedDynamicInvocation.argumentsMatcher);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public int hashCode() {
                return this.argumentsMatcher.hashCode() + ((this.typeMatcher.hashCode() + ((this.nameMatcher.hashCode() + dkz.i(this.handleMatcher, super.hashCode() * 31, 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public MemberSubstitution replaceWith(Substitution.Factory<? super Target.ForDynamicInvocation> factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, new Replacement.Factory.Compound(this.replacementFactory, new Replacement.ForDynamicInvocation.Factory(this.handleMatcher, this.nameMatcher, this.typeMatcher, this.argumentsMatcher, factory)));
            }

            public ForMatchedDynamicInvocation withArguments(ElementMatcher<? super List<? extends JavaConstant>> elementMatcher) {
                return new ForMatchedDynamicInvocation(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, this.handleMatcher, this.nameMatcher, this.typeMatcher, this.argumentsMatcher.and(elementMatcher));
            }

            public ForMatchedDynamicInvocation withName(ElementMatcher<? super String> elementMatcher) {
                return new ForMatchedDynamicInvocation(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, this.handleMatcher, this.nameMatcher.and(elementMatcher), this.typeMatcher, this.argumentsMatcher);
            }

            public ForMatchedDynamicInvocation withType(ElementMatcher<? super JavaConstant.MethodType> elementMatcher) {
                return new ForMatchedDynamicInvocation(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, this.handleMatcher, this.nameMatcher, this.typeMatcher.and(elementMatcher), this.argumentsMatcher);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedField extends WithoutSpecification<Target.ForMember> {
            private final boolean matchRead;
            private final boolean matchWrite;
            private final ElementMatcher<? super FieldDescription> matcher;

            public ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super FieldDescription> elementMatcher) {
                this(compiler, typePoolResolver, z, z2, factory, elementMatcher, true, true);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMatchedField forMatchedField = (ForMatchedField) obj;
                return this.matchRead == forMatchedField.matchRead && this.matchWrite == forMatchedField.matchWrite && this.matcher.equals(forMatchedField.matcher);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public int hashCode() {
                return ((dkz.i(this.matcher, super.hashCode() * 31, 31) + (this.matchRead ? 1 : 0)) * 31) + (this.matchWrite ? 1 : 0);
            }

            public WithoutSpecification<Target.ForMember> onRead() {
                return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, this.matcher, true, false);
            }

            public WithoutSpecification<Target.ForMember> onWrite() {
                return new ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, this.matcher, false, true);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public MemberSubstitution replaceWith(Substitution.Factory<? super Target.ForMember> factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.ofField(this.matcher, this.matchRead, this.matchWrite, factory)));
            }

            public ForMatchedField(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super FieldDescription> elementMatcher, boolean z3, boolean z4) {
                super(compiler, typePoolResolver, z, z2, factory);
                this.matcher = elementMatcher;
                this.matchRead = z3;
                this.matchWrite = z4;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForMatchedMethod extends WithoutSpecification<Target.ForMember> {
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final ElementMatcher<? super MethodDescription> matcher;

            public ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher) {
                this(compiler, typePoolResolver, z, z2, factory, elementMatcher, true, true);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForMatchedMethod forMatchedMethod = (ForMatchedMethod) obj;
                return this.includeVirtualCalls == forMatchedMethod.includeVirtualCalls && this.includeSuperCalls == forMatchedMethod.includeSuperCalls && this.matcher.equals(forMatchedMethod.matcher);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public int hashCode() {
                return ((dkz.i(this.matcher, super.hashCode() * 31, 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0);
            }

            public WithoutSpecification<Target.ForMember> onSuperCall() {
                return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, ElementMatchers.isVirtual().and(this.matcher), false, true);
            }

            public WithoutSpecification<Target.ForMember> onVirtualCall() {
                return new ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, ElementMatchers.isVirtual().and(this.matcher), true, false);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.WithoutSpecification
            public MemberSubstitution replaceWith(Substitution.Factory<? super Target.ForMember> factory) {
                return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, new Replacement.Factory.Compound(this.replacementFactory, Replacement.ForElementMatchers.Factory.ofMethod(this.matcher, this.includeVirtualCalls, this.includeSuperCalls, factory)));
            }

            public ForMatchedMethod(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory, ElementMatcher<? super MethodDescription> elementMatcher, boolean z3, boolean z4) {
                super(compiler, typePoolResolver, z, z2, factory);
                this.matcher = elementMatcher;
                this.includeVirtualCalls = z3;
                this.includeSuperCalls = z4;
            }
        }

        public WithoutSpecification(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory) {
            this.methodGraphCompiler = compiler;
            this.typePoolResolver = typePoolResolver;
            this.strict = z;
            this.failIfNoMatch = z2;
            this.replacementFactory = factory;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WithoutSpecification withoutSpecification = (WithoutSpecification) obj;
            return this.strict == withoutSpecification.strict && this.failIfNoMatch == withoutSpecification.failIfNoMatch && this.methodGraphCompiler.equals(withoutSpecification.methodGraphCompiler) && this.typePoolResolver.equals(withoutSpecification.typePoolResolver) && this.replacementFactory.equals(withoutSpecification.replacementFactory);
        }

        public int hashCode() {
            return this.replacementFactory.hashCode() + ((((((this.typePoolResolver.hashCode() + ((this.methodGraphCompiler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31) + (this.strict ? 1 : 0)) * 31) + (this.failIfNoMatch ? 1 : 0)) * 31);
        }

        public MemberSubstitution replaceWith(Field field) {
            return replaceWith(new FieldDescription.ForLoadedField(field));
        }

        public abstract MemberSubstitution replaceWith(Substitution.Factory<? super T> factory);

        @SafeVarargs
        @SafeVarargsPlugin.Enhance
        public final MemberSubstitution replaceWithChain(Substitution.Chain.Step.Factory<? super T>... factoryArr) {
            return replaceWithChain(Arrays.asList(factoryArr));
        }

        public MemberSubstitution replaceWithConstant(Object obj) {
            ConstantValue constantValueWrap = ConstantValue.Simple.wrap(obj);
            return replaceWith(new Substitution.ForValue(constantValueWrap.toStackManipulation(), constantValueWrap.getTypeDescription().asGenericType()));
        }

        public MemberSubstitution replaceWithField(ElementMatcher<? super FieldDescription> elementMatcher) {
            return replaceWith(new Substitution.ForFieldAccess.OfMatchedField(elementMatcher));
        }

        public MemberSubstitution replaceWithInstrumentedMethod() {
            return replaceWith(Substitution.ForMethodInvocation.OfInstrumentedMethod.INSTANCE);
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher) {
            return replaceWithMethod(elementMatcher, this.methodGraphCompiler);
        }

        public MemberSubstitution stub() {
            return replaceWith(Substitution.Stubbing.INSTANCE);
        }

        public MemberSubstitution replaceWith(FieldDescription fieldDescription) {
            return replaceWith(new Substitution.ForFieldAccess.OfGivenField(fieldDescription));
        }

        public MemberSubstitution replaceWithChain(List<? extends Substitution.Chain.Step.Factory<? super T>> list) {
            return replaceWith(Substitution.Chain.withDefaultAssigner().executing(list));
        }

        public MemberSubstitution replaceWithMethod(ElementMatcher<? super MethodDescription> elementMatcher, MethodGraph.Compiler compiler) {
            return replaceWith(new Substitution.ForMethodInvocation.OfMatchedMethod(elementMatcher, compiler));
        }

        public MemberSubstitution replaceWith(Method method) {
            return replaceWith(new MethodDescription.ForLoadedMethod(method));
        }

        public MemberSubstitution replaceWith(MethodDescription methodDescription) {
            if (methodDescription.isMethod()) {
                return replaceWith(new Substitution.ForMethodInvocation.OfGivenMethod(methodDescription));
            }
            throw new IllegalArgumentException("Cannot use " + methodDescription + " as a replacement");
        }
    }

    public MemberSubstitution(boolean z) {
        this(MethodGraph.Compiler.DEFAULT, TypePoolResolver.OfImplicitPool.INSTANCE, z, false, Replacement.NoOp.INSTANCE);
    }

    public static MemberSubstitution relaxed() {
        return new MemberSubstitution(false);
    }

    public static MemberSubstitution strict() {
        return new MemberSubstitution(true);
    }

    public WithoutSpecification<Target.ForMember> constructor(ElementMatcher<? super MethodDescription> elementMatcher) {
        return invokable(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public WithoutSpecification.ForMatchedDynamicInvocation dynamic(ElementMatcher<? super JavaConstant.MethodHandle> elementMatcher) {
        return new WithoutSpecification.ForMatchedDynamicInvocation(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, elementMatcher, ElementMatchers.any(), ElementMatchers.any(), ElementMatchers.any());
    }

    public WithoutSpecification<Target.ForMember> element(ElementMatcher<? super ByteCodeElement.Member> elementMatcher) {
        return new WithoutSpecification.ForMatchedByteCodeElement(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, elementMatcher);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberSubstitution memberSubstitution = (MemberSubstitution) obj;
        return this.strict == memberSubstitution.strict && this.failIfNoMatch == memberSubstitution.failIfNoMatch && this.methodGraphCompiler.equals(memberSubstitution.methodGraphCompiler) && this.typePoolResolver.equals(memberSubstitution.typePoolResolver) && this.replacementFactory.equals(memberSubstitution.replacementFactory);
    }

    public MemberSubstitution failIfNoMatch(boolean z) {
        return new MemberSubstitution(this.methodGraphCompiler, this.typePoolResolver, this.strict, z, this.replacementFactory);
    }

    public WithoutSpecification.ForMatchedField field(ElementMatcher<? super FieldDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedField(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, elementMatcher);
    }

    public int hashCode() {
        return this.replacementFactory.hashCode() + ((((((this.typePoolResolver.hashCode() + ((this.methodGraphCompiler.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31) + (this.strict ? 1 : 0)) * 31) + (this.failIfNoMatch ? 1 : 0)) * 31);
    }

    public WithoutSpecification<Target.ForMember> invokable(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, elementMatcher);
    }

    public WithoutSpecification.ForMatchedDynamicInvocation lambdaExpression() {
        return dynamic(new LambdaMetaFactoryMatcher());
    }

    public WithoutSpecification.ForMatchedMethod method(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new WithoutSpecification.ForMatchedMethod(this.methodGraphCompiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory, elementMatcher);
    }

    public AsmVisitorWrapper.ForDeclaredMethods on(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new AsmVisitorWrapper.ForDeclaredMethods().invokable(elementMatcher, this);
    }

    public MemberSubstitution with(MethodGraph.Compiler compiler) {
        return new MemberSubstitution(compiler, this.typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory);
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
    public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i2) {
        TypePool typePoolResolve = this.typePoolResolver.resolve(typeDescription, methodDescription, typePool);
        return new SubstitutingMethodVisitor(methodVisitor, typeDescription, methodDescription, this.methodGraphCompiler, this.strict, this.failIfNoMatch, this.replacementFactory.make(typeDescription, methodDescription, typePoolResolve), context, typePoolResolve, context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11));
    }

    public MemberSubstitution(MethodGraph.Compiler compiler, TypePoolResolver typePoolResolver, boolean z, boolean z2, Replacement.Factory factory) {
        this.methodGraphCompiler = compiler;
        this.typePoolResolver = typePoolResolver;
        this.failIfNoMatch = z2;
        this.strict = z;
        this.replacementFactory = factory;
    }

    public MemberSubstitution with(TypePoolResolver typePoolResolver) {
        return new MemberSubstitution(this.methodGraphCompiler, typePoolResolver, this.strict, this.failIfNoMatch, this.replacementFactory);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Replacement {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Binding {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForDynamicInvocation implements Binding {
                private final List<JavaConstant> arguments;
                private final JavaConstant.MethodType methodType;
                private final String name;
                private final Substitution<? super Target.ForDynamicInvocation> substitution;

                public ForDynamicInvocation(JavaConstant.MethodType methodType, String str, List<JavaConstant> list, Substitution<? super Target.ForDynamicInvocation> substitution) {
                    this.methodType = methodType;
                    this.name = str;
                    this.arguments = list;
                    this.substitution = substitution;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                    return this.name.equals(forDynamicInvocation.name) && this.methodType.equals(forDynamicInvocation.methodType) && this.arguments.equals(forDynamicInvocation.arguments) && this.substitution.equals(forDynamicInvocation.substitution);
                }

                public int hashCode() {
                    return this.substitution.hashCode() + bjs.g(this.arguments, bjs.e(this.name, (this.methodType.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public boolean isBound() {
                    return true;
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                    return this.substitution.resolve(new Target.ForDynamicInvocation(this.methodType, this.name, this.arguments), generic, generic2, methodHandle, stackManipulation, i);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForMember implements Binding {
                private final ByteCodeElement.Member member;
                private final TypeDescription receiver;
                private final Substitution<? super Target.ForMember> substitution;

                public ForMember(TypeDescription typeDescription, ByteCodeElement.Member member, Substitution<? super Target.ForMember> substitution) {
                    this.receiver = typeDescription;
                    this.member = member;
                    this.substitution = substitution;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForMember forMember = (ForMember) obj;
                    return this.receiver.equals(forMember.receiver) && this.member.equals(forMember.member) && this.substitution.equals(forMember.substitution);
                }

                public int hashCode() {
                    return this.substitution.hashCode() + ((this.member.hashCode() + dkz.f(this.receiver, getClass().hashCode() * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public boolean isBound() {
                    return true;
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                    return this.substitution.resolve(new Target.ForMember(this.receiver, this.member), generic, generic2, methodHandle, stackManipulation, i);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum Unresolved implements Binding {
                INSTANCE;

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public boolean isBound() {
                    return false;
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Binding
                public StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i) {
                    throw new IllegalStateException("Cannot resolve unresolved binding");
                }
            }

            boolean isBound();

            StackManipulation make(TypeList.Generic generic, TypeDescription.Generic generic2, JavaConstant.MethodHandle methodHandle, StackManipulation stackManipulation, int i);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Factory {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Factory {
                private final List<Factory> factories;

                public Compound(Factory... factoryArr) {
                    this((List<? extends Factory>) Arrays.asList(factoryArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.factories.equals(((Compound) obj).factories);
                }

                public int hashCode() {
                    return this.factories.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Factory
                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Factory> it = this.factories.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().make(typeDescription, methodDescription, typePool));
                    }
                    return new ForFirstBinding(arrayList);
                }

                public Compound(List<? extends Factory> list) {
                    this.factories = new ArrayList();
                    for (Factory factory : list) {
                        if (factory instanceof Compound) {
                            this.factories.addAll(((Compound) factory).factories);
                        } else if (!(factory instanceof NoOp)) {
                            this.factories.add(factory);
                        }
                    }
                }
            }

            Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForDynamicInvocation implements Replacement {
            private final ElementMatcher.Junction<? super List<JavaConstant>> argumentsMatcher;
            private final ElementMatcher<? super JavaConstant.MethodHandle> handleMatcher;
            private final ElementMatcher.Junction<? super String> nameMatcher;
            private final Substitution<? super Target.ForDynamicInvocation> substitution;
            private final ElementMatcher.Junction<? super JavaConstant.MethodType> typeMatcher;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final ElementMatcher.Junction<? super List<JavaConstant>> argumentsMatcher;
                private final ElementMatcher<? super JavaConstant.MethodHandle> handleMatcher;
                private final ElementMatcher.Junction<? super String> nameMatcher;
                private final Substitution.Factory<? super Target.ForDynamicInvocation> substitutionFactory;
                private final ElementMatcher.Junction<? super JavaConstant.MethodType> typeMatcher;

                public Factory(ElementMatcher<? super JavaConstant.MethodHandle> elementMatcher, ElementMatcher.Junction<? super String> junction, ElementMatcher.Junction<? super JavaConstant.MethodType> junction2, ElementMatcher.Junction<? super List<JavaConstant>> junction3, Substitution.Factory<? super Target.ForDynamicInvocation> factory) {
                    this.handleMatcher = elementMatcher;
                    this.nameMatcher = junction;
                    this.typeMatcher = junction2;
                    this.argumentsMatcher = junction3;
                    this.substitutionFactory = factory;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.handleMatcher.equals(factory.handleMatcher) && this.nameMatcher.equals(factory.nameMatcher) && this.typeMatcher.equals(factory.typeMatcher) && this.argumentsMatcher.equals(factory.argumentsMatcher) && this.substitutionFactory.equals(factory.substitutionFactory);
                }

                public int hashCode() {
                    return this.substitutionFactory.hashCode() + ((this.argumentsMatcher.hashCode() + ((this.typeMatcher.hashCode() + ((this.nameMatcher.hashCode() + dkz.i(this.handleMatcher, getClass().hashCode() * 31, 31)) * 31)) * 31)) * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Factory
                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForDynamicInvocation(this.handleMatcher, this.nameMatcher, this.typeMatcher, this.argumentsMatcher, this.substitutionFactory.make(typeDescription, methodDescription, typePool));
                }
            }

            public ForDynamicInvocation(ElementMatcher<? super JavaConstant.MethodHandle> elementMatcher, ElementMatcher.Junction<? super String> junction, ElementMatcher.Junction<? super JavaConstant.MethodType> junction2, ElementMatcher.Junction<? super List<JavaConstant>> junction3, Substitution<? super Target.ForDynamicInvocation> substitution) {
                this.handleMatcher = elementMatcher;
                this.nameMatcher = junction;
                this.typeMatcher = junction2;
                this.argumentsMatcher = junction3;
                this.substitution = substitution;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, FieldDescription fieldDescription, boolean z) {
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForDynamicInvocation forDynamicInvocation = (ForDynamicInvocation) obj;
                return this.handleMatcher.equals(forDynamicInvocation.handleMatcher) && this.nameMatcher.equals(forDynamicInvocation.nameMatcher) && this.typeMatcher.equals(forDynamicInvocation.typeMatcher) && this.argumentsMatcher.equals(forDynamicInvocation.argumentsMatcher) && this.substitution.equals(forDynamicInvocation.substitution);
            }

            public int hashCode() {
                return this.substitution.hashCode() + ((this.argumentsMatcher.hashCode() + ((this.typeMatcher.hashCode() + ((this.nameMatcher.hashCode() + dkz.i(this.handleMatcher, getClass().hashCode() * 31, 31)) * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return Binding.Unresolved.INSTANCE;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType, String str, List<JavaConstant> list) {
                if (this.handleMatcher.matches(methodHandle) && this.nameMatcher.matches(str) && this.typeMatcher.matches(methodType) && this.argumentsMatcher.matches(list)) {
                    return new Binding.ForDynamicInvocation(methodType, str, list, this.substitution);
                }
                return Binding.Unresolved.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForElementMatchers implements Replacement {
            private final ElementMatcher<? super FieldDescription> fieldMatcher;
            private final boolean includeSuperCalls;
            private final boolean includeVirtualCalls;
            private final boolean matchFieldRead;
            private final boolean matchFieldWrite;
            private final ElementMatcher<? super MethodDescription> methodMatcher;
            private final Substitution<? super Target.ForMember> substitution;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Factory implements Factory {
                private final ElementMatcher<? super FieldDescription> fieldMatcher;
                private final boolean includeSuperCalls;
                private final boolean includeVirtualCalls;
                private final boolean matchFieldRead;
                private final boolean matchFieldWrite;
                private final ElementMatcher<? super MethodDescription> methodMatcher;
                private final Substitution.Factory<? super Target.ForMember> substitutionFactory;

                public Factory(ElementMatcher<? super FieldDescription> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z, boolean z2, boolean z3, boolean z4, Substitution.Factory<? super Target.ForMember> factory) {
                    this.fieldMatcher = elementMatcher;
                    this.methodMatcher = elementMatcher2;
                    this.matchFieldRead = z;
                    this.matchFieldWrite = z2;
                    this.includeVirtualCalls = z3;
                    this.includeSuperCalls = z4;
                    this.substitutionFactory = factory;
                }

                public static Factory of(ElementMatcher<? super ByteCodeElement.Member> elementMatcher, Substitution.Factory<? super Target.ForMember> factory) {
                    return new Factory(elementMatcher, elementMatcher, true, true, true, true, factory);
                }

                public static Factory ofField(ElementMatcher<? super FieldDescription> elementMatcher, boolean z, boolean z2, Substitution.Factory<? super Target.ForMember> factory) {
                    return new Factory(elementMatcher, ElementMatchers.none(), z, z2, false, false, factory);
                }

                public static Factory ofMethod(ElementMatcher<? super MethodDescription> elementMatcher, boolean z, boolean z2, Substitution.Factory<? super Target.ForMember> factory) {
                    return new Factory(ElementMatchers.none(), elementMatcher, false, false, z, z2, factory);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Factory factory = (Factory) obj;
                    return this.matchFieldRead == factory.matchFieldRead && this.matchFieldWrite == factory.matchFieldWrite && this.includeVirtualCalls == factory.includeVirtualCalls && this.includeSuperCalls == factory.includeSuperCalls && this.fieldMatcher.equals(factory.fieldMatcher) && this.methodMatcher.equals(factory.methodMatcher) && this.substitutionFactory.equals(factory.substitutionFactory);
                }

                public int hashCode() {
                    return this.substitutionFactory.hashCode() + ((((((((dkz.i(this.methodMatcher, dkz.i(this.fieldMatcher, getClass().hashCode() * 31, 31), 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31);
                }

                @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Factory
                public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                    return new ForElementMatchers(this.fieldMatcher, this.methodMatcher, this.matchFieldRead, this.matchFieldWrite, this.includeVirtualCalls, this.includeSuperCalls, this.substitutionFactory.make(typeDescription, methodDescription, typePool));
                }
            }

            public ForElementMatchers(ElementMatcher<? super FieldDescription> elementMatcher, ElementMatcher<? super MethodDescription> elementMatcher2, boolean z, boolean z2, boolean z3, boolean z4, Substitution<? super Target.ForMember> substitution) {
                this.fieldMatcher = elementMatcher;
                this.methodMatcher = elementMatcher2;
                this.matchFieldRead = z;
                this.matchFieldWrite = z2;
                this.includeVirtualCalls = z3;
                this.includeSuperCalls = z4;
                this.substitution = substitution;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, FieldDescription fieldDescription, boolean z) {
                if (!z ? this.matchFieldRead : this.matchFieldWrite) {
                    if (this.fieldMatcher.matches(fieldDescription)) {
                        return new Binding.ForMember(typeDescription2, fieldDescription, this.substitution);
                    }
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForElementMatchers forElementMatchers = (ForElementMatchers) obj;
                return this.matchFieldRead == forElementMatchers.matchFieldRead && this.matchFieldWrite == forElementMatchers.matchFieldWrite && this.includeVirtualCalls == forElementMatchers.includeVirtualCalls && this.includeSuperCalls == forElementMatchers.includeSuperCalls && this.fieldMatcher.equals(forElementMatchers.fieldMatcher) && this.methodMatcher.equals(forElementMatchers.methodMatcher) && this.substitution.equals(forElementMatchers.substitution);
            }

            public int hashCode() {
                return this.substitution.hashCode() + ((((((((dkz.i(this.methodMatcher, dkz.i(this.fieldMatcher, getClass().hashCode() * 31, 31), 31) + (this.matchFieldRead ? 1 : 0)) * 31) + (this.matchFieldWrite ? 1 : 0)) * 31) + (this.includeVirtualCalls ? 1 : 0)) * 31) + (this.includeSuperCalls ? 1 : 0)) * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return (invocationType.matches(this.includeVirtualCalls, this.includeSuperCalls) && this.methodMatcher.matches(methodDescription2)) ? new Binding.ForMember(typeDescription2, methodDescription2, this.substitution) : Binding.Unresolved.INSTANCE;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType, String str, List<JavaConstant> list) {
                return Binding.Unresolved.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum InvocationType {
            VIRTUAL,
            SUPER,
            OTHER;

            public static InvocationType of(int i, MethodDescription methodDescription) {
                if (i != 182) {
                    if (i == 183) {
                        return methodDescription.isVirtual() ? SUPER : OTHER;
                    }
                    if (i != 185) {
                        return OTHER;
                    }
                }
                return VIRTUAL;
            }

            public boolean matches(boolean z, boolean z2) {
                int i = AnonymousClass1.$SwitchMap$net$bytebuddy$asm$MemberSubstitution$Replacement$InvocationType[ordinal()];
                if (i == 1) {
                    return z;
                }
                if (i != 2) {
                    return true;
                }
                return z2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements Replacement, Factory {
            INSTANCE;

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, FieldDescription fieldDescription, boolean z) {
                return Binding.Unresolved.INSTANCE;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement.Factory
            public Replacement make(TypeDescription typeDescription, MethodDescription methodDescription, TypePool typePool) {
                return this;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                return Binding.Unresolved.INSTANCE;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType, String str, List<JavaConstant> list) {
                return Binding.Unresolved.INSTANCE;
            }
        }

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, FieldDescription fieldDescription, boolean z);

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType);

        Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType, String str, List<JavaConstant> list);

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFirstBinding implements Replacement {
            private final List<? extends Replacement> replacements;

            public ForFirstBinding(List<? extends Replacement> list) {
                this.replacements = list;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, FieldDescription fieldDescription, boolean z) {
                Iterator<? extends Replacement> it = this.replacements.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription3 = typeDescription;
                    MethodDescription methodDescription2 = methodDescription;
                    TypeDescription typeDescription4 = typeDescription2;
                    FieldDescription fieldDescription2 = fieldDescription;
                    boolean z2 = z;
                    Binding bindingBind = it.next().bind(typeDescription3, methodDescription2, typeDescription4, fieldDescription2, z2);
                    if (bindingBind.isBound()) {
                        return bindingBind;
                    }
                    typeDescription = typeDescription3;
                    methodDescription = methodDescription2;
                    typeDescription2 = typeDescription4;
                    fieldDescription = fieldDescription2;
                    z = z2;
                }
                return Binding.Unresolved.INSTANCE;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.replacements.equals(((ForFirstBinding) obj).replacements);
            }

            public int hashCode() {
                return this.replacements.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, TypeDescription typeDescription2, MethodDescription methodDescription2, InvocationType invocationType) {
                Iterator<? extends Replacement> it = this.replacements.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription3 = typeDescription;
                    MethodDescription methodDescription3 = methodDescription;
                    TypeDescription typeDescription4 = typeDescription2;
                    MethodDescription methodDescription4 = methodDescription2;
                    InvocationType invocationType2 = invocationType;
                    Binding bindingBind = it.next().bind(typeDescription3, methodDescription3, typeDescription4, methodDescription4, invocationType2);
                    if (bindingBind.isBound()) {
                        return bindingBind;
                    }
                    typeDescription = typeDescription3;
                    methodDescription = methodDescription3;
                    typeDescription2 = typeDescription4;
                    methodDescription2 = methodDescription4;
                    invocationType = invocationType2;
                }
                return Binding.Unresolved.INSTANCE;
            }

            @Override // net.bytebuddy.asm.MemberSubstitution.Replacement
            public Binding bind(TypeDescription typeDescription, MethodDescription methodDescription, JavaConstant.MethodHandle methodHandle, JavaConstant.MethodType methodType, String str, List<JavaConstant> list) {
                Iterator<? extends Replacement> it = this.replacements.iterator();
                while (it.hasNext()) {
                    TypeDescription typeDescription2 = typeDescription;
                    MethodDescription methodDescription2 = methodDescription;
                    JavaConstant.MethodHandle methodHandle2 = methodHandle;
                    JavaConstant.MethodType methodType2 = methodType;
                    String str2 = str;
                    List<JavaConstant> list2 = list;
                    Binding bindingBind = it.next().bind(typeDescription2, methodDescription2, methodHandle2, methodType2, str2, list2);
                    if (bindingBind.isBound()) {
                        return bindingBind;
                    }
                    typeDescription = typeDescription2;
                    methodDescription = methodDescription2;
                    methodHandle = methodHandle2;
                    methodType = methodType2;
                    str = str2;
                    list = list2;
                }
                return Binding.Unresolved.INSTANCE;
            }
        }
    }
}
