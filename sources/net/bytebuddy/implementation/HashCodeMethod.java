package net.bytebuddy.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.bytecode.Addition;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Multiplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class HashCodeMethod implements Implementation {
    private static final int DEFAULT_MULTIPLIER = 31;
    private static final int DEFAULT_OFFSET = 17;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> identity;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> ignored;
    private final int multiplier;
    private final ElementMatcher.Junction<? super FieldDescription.InDefinedShape> nonNullable;
    private final OffsetProvider offsetProvider;
    private static final MethodDescription.InDefinedShape HASH_CODE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.isHashCode()).getOnly();
    private static final MethodDescription.InDefinedShape GET_CLASS = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Object.class).getDeclaredMethods().filter(ElementMatchers.named("getClass").and(ElementMatchers.takesArguments(0))).getOnly();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Appender implements ByteCodeAppender {
        private final List<FieldDescription.InDefinedShape> fieldDescriptions;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> identity;
        private final StackManipulation initialValue;
        private final int multiplier;
        private final ElementMatcher<? super FieldDescription.InDefinedShape> nonNullable;

        public Appender(StackManipulation stackManipulation, int i, List<FieldDescription.InDefinedShape> list, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher, ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher2) {
            this.initialValue = stackManipulation;
            this.multiplier = i;
            this.fieldDescriptions = list;
            this.nonNullable = elementMatcher;
            this.identity = elementMatcher2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.isStatic()) {
                throw new IllegalStateException(StaticHelpers6.concat("Hash code method must not be static: ", methodDescription));
            }
            if (!methodDescription.getReturnType().represents(Integer.TYPE)) {
                throw new IllegalStateException(StaticHelpers6.concat("Hash code method does not return primitive integer: ", methodDescription));
            }
            ArrayList arrayList = new ArrayList((this.fieldDescriptions.size() * 8) + 2);
            arrayList.add(this.initialValue);
            int iMax = 0;
            for (FieldDescription.InDefinedShape inDefinedShape : this.fieldDescriptions) {
                arrayList.add(IntegerConstant.forValue(this.multiplier));
                arrayList.add(Multiplication.INTEGER);
                arrayList.add(MethodVariableAccess.loadThis());
                arrayList.add(FieldAccess.forField(inDefinedShape).read());
                if (inDefinedShape.getType().isPrimitive() || !this.identity.matches(inDefinedShape)) {
                    NullValueGuard usingJump = (inDefinedShape.getType().isPrimitive() || inDefinedShape.getType().isArray() || this.nonNullable.matches(inDefinedShape)) ? NullValueGuard.NoOp.INSTANCE : new NullValueGuard.UsingJump(methodDescription);
                    arrayList.add(usingJump.before());
                    arrayList.add(ValueTransformer.of(inDefinedShape.getType()));
                    arrayList.add(Addition.INTEGER);
                    arrayList.add(usingJump.after());
                    iMax = Math.max(iMax, usingJump.getRequiredVariablePadding());
                } else {
                    arrayList.add(ValueTransformer.REFERENCE_IDENTITY);
                    arrayList.add(Addition.INTEGER);
                }
            }
            arrayList.add(MethodReturn.INTEGER);
            return new ByteCodeAppender.Size(new StackManipulation.Compound(arrayList).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize() + iMax);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Appender appender = (Appender) obj;
            return this.multiplier == appender.multiplier && this.initialValue.equals(appender.initialValue) && this.fieldDescriptions.equals(appender.fieldDescriptions) && this.nonNullable.equals(appender.nonNullable) && this.identity.equals(appender.identity);
        }

        public int hashCode() {
            return this.identity.hashCode() + StaticHelpers6.i(this.nonNullable, bjs.g(this.fieldDescriptions, (StaticHelpers6.g(this.initialValue, getClass().hashCode() * 31, 31) + this.multiplier) * 31, 31), 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface NullValueGuard {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements NullValueGuard {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation after() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation before() {
                return StackManipulation.Trivial.INSTANCE;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return StackSize.ZERO.getSize();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingJump implements NullValueGuard {
            private final MethodDescription instrumentedMethod;
            private final Label label = new Label();

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class AfterInstruction extends StackManipulation.AbstractBase {
                public AfterInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    methodVisitor.visitLabel(UsingJump.this.label);
                    context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(Integer.TYPE), Arrays.asList(context.getInstrumentedType(), TypeDescription.ForLoadedType.of(Object.class)));
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return UsingJump.this.hashCode() + (getClass().hashCode() * 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class BeforeInstruction extends StackManipulation.AbstractBase {
                public BeforeInstruction() {
                }

                @Override // net.bytebuddy.implementation.bytecode.StackManipulation
                public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                    methodVisitor.visitVarInsn(58, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    methodVisitor.visitJumpInsn(198, UsingJump.this.label);
                    methodVisitor.visitVarInsn(25, UsingJump.this.instrumentedMethod.getStackSize());
                    return StackManipulation.Size.ZERO;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && UsingJump.this.equals(UsingJump.this);
                }

                public int hashCode() {
                    return UsingJump.this.hashCode() + (getClass().hashCode() * 31);
                }
            }

            public UsingJump(MethodDescription methodDescription) {
                this.instrumentedMethod = methodDescription;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation after() {
                return new AfterInstruction();
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public StackManipulation before() {
                return new BeforeInstruction();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingJump usingJump = (UsingJump) obj;
                return this.instrumentedMethod.equals(usingJump.instrumentedMethod) && this.label.equals(usingJump.label);
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.NullValueGuard
            public int getRequiredVariablePadding() {
                return 1;
            }

            public int hashCode() {
                return this.label.hashCode() + StaticHelpers6.c(this.instrumentedMethod, getClass().hashCode() * 31, 31);
            }
        }

        StackManipulation after();

        StackManipulation before();

        int getRequiredVariablePadding();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface OffsetProvider {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForDynamicTypeHash implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription typeDescription) {
                return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.GET_CLASS).virtual(typeDescription), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(TypeDescription.ForLoadedType.of(Class.class)));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForFixedValue implements OffsetProvider {
            private final int value;

            public ForFixedValue(int i) {
                this.value = i;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.value == ((ForFixedValue) obj).value;
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.value;
            }

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription typeDescription) {
                return IntegerConstant.forValue(this.value);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForStaticTypeHash implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription typeDescription) {
                return new StackManipulation.Compound(ClassConstant.of(typeDescription), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(TypeDescription.ForLoadedType.of(Class.class)));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForSuperMethodCall implements OffsetProvider {
            INSTANCE;

            @Override // net.bytebuddy.implementation.HashCodeMethod.OffsetProvider
            public StackManipulation resolve(TypeDescription typeDescription) {
                TypeDescription.Generic superClass = typeDescription.getSuperClass();
                if (superClass != null) {
                    return new StackManipulation.Compound(MethodVariableAccess.loadThis(), MethodInvocation.invoke(HashCodeMethod.HASH_CODE).special(superClass.asErasure()));
                }
                throw new IllegalStateException(StaticHelpers6.concat(typeDescription, " does not declare a super class"));
            }
        }

        StackManipulation resolve(TypeDescription typeDescription);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum ValueTransformer implements StackManipulation {
        LONG { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.1
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitInsn(92);
                methodVisitor.visitIntInsn(16, 32);
                methodVisitor.visitInsn(125);
                methodVisitor.visitInsn(131);
                methodVisitor.visitInsn(136);
                return new StackManipulation.Size(-1, 3);
            }
        },
        FLOAT { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.2
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/lang/Float", "floatToIntBits", "(F)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.3
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/lang/Double", "doubleToLongBits", "(D)J", false);
                methodVisitor.visitInsn(92);
                methodVisitor.visitIntInsn(16, 32);
                methodVisitor.visitInsn(125);
                methodVisitor.visitInsn(131);
                methodVisitor.visitInsn(136);
                return new StackManipulation.Size(-1, 3);
            }
        },
        BOOLEAN_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.4
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Z)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        BYTE_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.5
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([B)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        SHORT_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.6
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([S)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        CHARACTER_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.7
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([C)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        INTEGER_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.8
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([I)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        LONG_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.9
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([J)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        FLOAT_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.10
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([F)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        DOUBLE_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.11
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([D)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        REFERENCE_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.12
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "hashCode", "([Ljava/lang/Object;)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        NESTED_ARRAY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.13
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/util/Arrays", "deepHashCode", "([Ljava/lang/Object;)I", false);
                return StackManipulation.Size.ZERO;
            }
        },
        REFERENCE_IDENTITY { // from class: net.bytebuddy.implementation.HashCodeMethod.ValueTransformer.14
            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                methodVisitor.visitMethodInsn(184, "java/lang/System", "identityHashCode", "(Ljava/lang/Object;)I", false);
                return StackManipulation.Size.ZERO;
            }
        };

        public static StackManipulation of(TypeDefinition typeDefinition) {
            return (typeDefinition.represents(Boolean.TYPE) || typeDefinition.represents(Byte.TYPE) || typeDefinition.represents(Short.TYPE) || typeDefinition.represents(Character.TYPE) || typeDefinition.represents(Integer.TYPE)) ? StackManipulation.Trivial.INSTANCE : typeDefinition.represents(Long.TYPE) ? LONG : typeDefinition.represents(Float.TYPE) ? FLOAT : typeDefinition.represents(Double.TYPE) ? DOUBLE : typeDefinition.represents(boolean[].class) ? BOOLEAN_ARRAY : typeDefinition.represents(byte[].class) ? BYTE_ARRAY : typeDefinition.represents(short[].class) ? SHORT_ARRAY : typeDefinition.represents(char[].class) ? CHARACTER_ARRAY : typeDefinition.represents(int[].class) ? INTEGER_ARRAY : typeDefinition.represents(long[].class) ? LONG_ARRAY : typeDefinition.represents(float[].class) ? FLOAT_ARRAY : typeDefinition.represents(double[].class) ? DOUBLE_ARRAY : typeDefinition.isArray() ? typeDefinition.getComponentType().isArray() ? NESTED_ARRAY : REFERENCE_ARRAY : MethodInvocation.invoke(HashCodeMethod.HASH_CODE).virtual(typeDefinition.asErasure());
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return true;
        }
    }

    public HashCodeMethod(OffsetProvider offsetProvider) {
        this(offsetProvider, 31, ElementMatchers.none(), ElementMatchers.none(), ElementMatchers.none());
    }

    public static HashCodeMethod usingDefaultOffset() {
        return usingOffset(17);
    }

    public static HashCodeMethod usingOffset(int i) {
        return new HashCodeMethod(new OffsetProvider.ForFixedValue(i));
    }

    public static HashCodeMethod usingSuperClassOffset() {
        return new HashCodeMethod(OffsetProvider.ForSuperMethodCall.INSTANCE);
    }

    public static HashCodeMethod usingTypeHashOffset(boolean z) {
        return new HashCodeMethod(z ? OffsetProvider.ForDynamicTypeHash.INSTANCE : OffsetProvider.ForStaticTypeHash.INSTANCE);
    }

    @Override // net.bytebuddy.implementation.Implementation
    public ByteCodeAppender appender(Implementation.Target target) {
        if (!target.getInstrumentedType().isInterface()) {
            return new Appender(this.offsetProvider.resolve(target.getInstrumentedType()), this.multiplier, target.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.not(ElementMatchers.isStatic().or(this.ignored))), this.nonNullable, this.identity);
        }
        throw new IllegalStateException("Cannot implement meaningful hash code method for " + target.getInstrumentedType());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HashCodeMethod hashCodeMethod = (HashCodeMethod) obj;
        return this.multiplier == hashCodeMethod.multiplier && this.offsetProvider.equals(hashCodeMethod.offsetProvider) && this.ignored.equals(hashCodeMethod.ignored) && this.nonNullable.equals(hashCodeMethod.nonNullable) && this.identity.equals(hashCodeMethod.identity);
    }

    public int hashCode() {
        return this.identity.hashCode() + ((this.nonNullable.hashCode() + ((this.ignored.hashCode() + ((((this.offsetProvider.hashCode() + (getClass().hashCode() * 31)) * 31) + this.multiplier) * 31)) * 31)) * 31);
    }

    @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    public HashCodeMethod withIdentityFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored, this.nonNullable, this.identity.or(elementMatcher));
    }

    public HashCodeMethod withIgnoredFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored.or(elementMatcher), this.nonNullable, this.identity);
    }

    public HashCodeMethod withMultiplier(int i) {
        if (i != 0) {
            return new HashCodeMethod(this.offsetProvider, i, this.ignored, this.nonNullable, this.identity);
        }
        throw new IllegalArgumentException("Hash code multiplier must not be zero");
    }

    public HashCodeMethod withNonNullableFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new HashCodeMethod(this.offsetProvider, this.multiplier, this.ignored, this.nonNullable.or(elementMatcher), this.identity);
    }

    private HashCodeMethod(OffsetProvider offsetProvider, int i, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction2, ElementMatcher.Junction<? super FieldDescription.InDefinedShape> junction3) {
        this.offsetProvider = offsetProvider;
        this.multiplier = i;
        this.ignored = junction;
        this.nonNullable = junction2;
        this.identity = junction3;
    }
}
