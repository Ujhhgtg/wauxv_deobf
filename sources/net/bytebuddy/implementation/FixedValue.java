package net.bytebuddy.implementation;

import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.constant.ClassConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.ConstantValue;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public abstract class FixedValue implements Implementation {
    protected final Assigner assigner;
    protected final Assigner.Typing typing;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface AssignerConfigurable extends Implementation {
        Implementation withAssigner(Assigner assigner, Assigner.Typing typing);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForArgument extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final int index;

        public ForArgument(int i) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, i);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.getParameters().size() <= this.index) {
                throw new IllegalStateException(methodDescription + " does not define a parameter with index " + this.index);
            }
            ParameterDescription parameterDescription = (ParameterDescription) methodDescription.getParameters().get(this.index);
            StackManipulation.Compound compound = new StackManipulation.Compound(MethodVariableAccess.load(parameterDescription), this.assigner.assign(parameterDescription.getType(), methodDescription.getReturnType(), this.typing), MethodReturn.of(methodDescription.getReturnType()));
            if (compound.isValid()) {
                return new ByteCodeAppender.Size(compound.apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
            }
            throw new IllegalStateException("Cannot assign " + methodDescription.getReturnType() + " to " + parameterDescription);
        }

        @Override // net.bytebuddy.implementation.FixedValue
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.index == ((ForArgument) obj).index;
        }

        @Override // net.bytebuddy.implementation.FixedValue
        public int hashCode() {
            return (super.hashCode() * 31) + this.index;
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.FixedValue.AssignerConfigurable
        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForArgument(assigner, typing, this.index);
        }

        private ForArgument(Assigner assigner, Assigner.Typing typing, int i) {
            super(assigner, typing);
            this.index = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForConstantValue extends FixedValue implements AssignerConfigurable, ByteCodeAppender {
        private final TypeDescription loadedType;
        private final StackManipulation valueLoadInstruction;

        public ForConstantValue(StackManipulation stackManipulation, Class<?> cls) {
            this(stackManipulation, TypeDescription.ForLoadedType.of(cls));
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return apply(methodVisitor, context, methodDescription, this.loadedType.asGenericType(), this.valueLoadInstruction);
        }

        @Override // net.bytebuddy.implementation.FixedValue
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
            ForConstantValue forConstantValue = (ForConstantValue) obj;
            return this.valueLoadInstruction.equals(forConstantValue.valueLoadInstruction) && this.loadedType.equals(forConstantValue.loadedType);
        }

        @Override // net.bytebuddy.implementation.FixedValue
        public int hashCode() {
            return this.loadedType.hashCode() + dkz.g(this.valueLoadInstruction, super.hashCode() * 31, 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.FixedValue.AssignerConfigurable
        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForConstantValue(assigner, typing, this.valueLoadInstruction, this.loadedType);
        }

        public ForConstantValue(StackManipulation stackManipulation, TypeDescription typeDescription) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, stackManipulation, typeDescription);
        }

        private ForConstantValue(Assigner assigner, Assigner.Typing typing, StackManipulation stackManipulation, TypeDescription typeDescription) {
            super(assigner, typing);
            this.valueLoadInstruction = stackManipulation;
            this.loadedType = typeDescription;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum ForNullValue implements Implementation, ByteCodeAppender {
        INSTANCE;

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return this;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            if (methodDescription.getReturnType().isPrimitive()) {
                throw new IllegalStateException(dkz.t("Cannot return null from ", methodDescription));
            }
            return new ByteCodeAppender.Simple(NullConstant.INSTANCE, MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForOriginType extends FixedValue implements AssignerConfigurable {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
        public class Appender implements ByteCodeAppender {
            private final TypeDescription originType;

            public Appender(TypeDescription typeDescription) {
                this.originType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                return ForOriginType.this.apply(methodVisitor, context, methodDescription, TypeDescription.ForLoadedType.of(Class.class).asGenericType(), ClassConstant.of(this.originType));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Appender appender = (Appender) obj;
                return this.originType.equals(appender.originType) && ForOriginType.this.equals(ForOriginType.this);
            }

            public int hashCode() {
                return ForOriginType.this.hashCode() + dkz.f(this.originType, getClass().hashCode() * 31, 31);
            }
        }

        public ForOriginType() {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getOriginType().asErasure());
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.FixedValue.AssignerConfigurable
        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForOriginType(assigner, typing);
        }

        private ForOriginType(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForThisValue extends FixedValue implements AssignerConfigurable {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Appender implements ByteCodeAppender {
            private final TypeDescription instrumentedType;

            public Appender(TypeDescription typeDescription) {
                this.instrumentedType = typeDescription;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                if (methodDescription.isStatic() || !this.instrumentedType.isAssignableTo(methodDescription.getReturnType().asErasure())) {
                    throw new IllegalStateException(dkz.t("Cannot return 'this' from ", methodDescription));
                }
                return new ByteCodeAppender.Simple(MethodVariableAccess.loadThis(), MethodReturn.REFERENCE).apply(methodVisitor, context, methodDescription);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.instrumentedType.equals(((Appender) obj).instrumentedType);
            }

            public int hashCode() {
                return this.instrumentedType.hashCode() + (getClass().hashCode() * 31);
            }
        }

        public ForThisValue() {
            super(Assigner.DEFAULT, Assigner.Typing.STATIC);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new Appender(target.getInstrumentedType());
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType;
        }

        @Override // net.bytebuddy.implementation.FixedValue.AssignerConfigurable
        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForThisValue(assigner, typing);
        }

        private ForThisValue(Assigner assigner, Assigner.Typing typing) {
            super(assigner, typing);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForValue extends FixedValue implements AssignerConfigurable {
        private static final String PREFIX = "value";
        private final String name;
        private final Object value;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public class StaticFieldByteCodeAppender implements ByteCodeAppender {
            private final StackManipulation fieldGetAccess;

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                ForValue forValue = ForValue.this;
                return forValue.apply(methodVisitor, context, methodDescription, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(forValue.value.getClass()), this.fieldGetAccess);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.fieldGetAccess.equals(((StaticFieldByteCodeAppender) obj).fieldGetAccess);
            }

            public int hashCode() {
                return this.fieldGetAccess.hashCode() + (getClass().hashCode() * 31);
            }

            private StaticFieldByteCodeAppender(TypeDescription typeDescription) {
                this.fieldGetAccess = FieldAccess.forField((FieldDescription.InDefinedShape) typeDescription.getDeclaredFields().filter(ElementMatchers.named(ForValue.this.name)).getOnly()).read();
            }
        }

        public ForValue(Object obj, String str) {
            this(Assigner.DEFAULT, Assigner.Typing.STATIC, obj, str);
        }

        @Override // net.bytebuddy.implementation.Implementation
        public ByteCodeAppender appender(Implementation.Target target) {
            return new StaticFieldByteCodeAppender(target.getInstrumentedType());
        }

        @Override // net.bytebuddy.implementation.FixedValue
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
            ForValue forValue = (ForValue) obj;
            return this.name.equals(forValue.name) && this.value.equals(forValue.value);
        }

        @Override // net.bytebuddy.implementation.FixedValue
        public int hashCode() {
            return this.value.hashCode() + bjs.e(this.name, super.hashCode() * 31, 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.InstrumentedType.Prepareable
        public InstrumentedType prepare(InstrumentedType instrumentedType) {
            return instrumentedType.withAuxiliaryField(new FieldDescription.Token(this.name, 4169, TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(this.value.getClass())), this.value);
        }

        @Override // net.bytebuddy.implementation.FixedValue.AssignerConfigurable
        public Implementation withAssigner(Assigner assigner, Assigner.Typing typing) {
            return new ForValue(assigner, typing, this.value, this.name);
        }

        private ForValue(Assigner assigner, Assigner.Typing typing, Object obj, String str) {
            super(assigner, typing);
            this.name = str;
            this.value = obj;
        }
    }

    public FixedValue(Assigner assigner, Assigner.Typing typing) {
        this.assigner = assigner;
        this.typing = typing;
    }

    public static AssignerConfigurable argument(int i) {
        if (i >= 0) {
            return new ForArgument(i);
        }
        throw new IllegalArgumentException(bjs.i(i, "Argument index cannot be negative: "));
    }

    public static Implementation nullValue() {
        return ForNullValue.INSTANCE;
    }

    public static AssignerConfigurable originType() {
        return new ForOriginType();
    }

    public static AssignerConfigurable reference(Object obj) {
        return reference(obj, "value$" + RandomString.hashOf(obj));
    }

    public static AssignerConfigurable self() {
        return new ForThisValue();
    }

    public static AssignerConfigurable value(Object obj) {
        ConstantValue constantValueWrapOrNull = ConstantValue.Simple.wrapOrNull(obj);
        return constantValueWrapOrNull == null ? reference(obj) : new ForConstantValue(constantValueWrapOrNull.toStackManipulation(), constantValueWrapOrNull.getTypeDescription());
    }

    public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription, TypeDescription.Generic generic, StackManipulation stackManipulation) {
        StackManipulation stackManipulationAssign = this.assigner.assign(generic, methodDescription.getReturnType(), this.typing);
        if (stackManipulationAssign.isValid()) {
            return new ByteCodeAppender.Size(new StackManipulation.Compound(stackManipulation, stackManipulationAssign, MethodReturn.of(methodDescription.getReturnType())).apply(methodVisitor, context).getMaximalSize(), methodDescription.getStackSize());
        }
        throw new IllegalArgumentException("Cannot return value of type " + generic + " for " + methodDescription);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FixedValue fixedValue = (FixedValue) obj;
        return this.typing.equals(fixedValue.typing) && this.assigner.equals(fixedValue.assigner);
    }

    public int hashCode() {
        return this.typing.hashCode() + dkz.h(this.assigner, getClass().hashCode() * 31, 31);
    }

    public static AssignerConfigurable reference(Object obj, String str) {
        return new ForValue(obj, str);
    }

    public static AssignerConfigurable value(TypeDescription typeDescription) {
        return new ForConstantValue(ClassConstant.of(typeDescription), TypeDescription.ForLoadedType.of(Class.class));
    }

    public static AssignerConfigurable value(ConstantValue constantValue) {
        return new ForConstantValue(constantValue.toStackManipulation(), constantValue.getTypeDescription());
    }

    public static AssignerConfigurable value(JavaConstant javaConstant) {
        return value((ConstantValue) javaConstant);
    }
}
