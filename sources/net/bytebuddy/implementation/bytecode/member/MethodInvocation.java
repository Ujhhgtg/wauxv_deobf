package net.bytebuddy.implementation.bytecode.member;

import java.util.List;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.JavaConstant;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum MethodInvocation {
    VIRTUAL(182, 5, 182, 5),
    INTERFACE(185, 9, 185, 9),
    STATIC(184, 6, 184, 6),
    SPECIAL(183, 7, 183, 7),
    SPECIAL_CONSTRUCTOR(183, 8, 183, 8),
    VIRTUAL_PRIVATE(182, 5, 183, 7),
    INTERFACE_PRIVATE(185, 9, 183, 7);

    private final int handle;
    private final int legacyHandle;
    private final int legacyOpcode;
    private final int opcode;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class HandleInvocation extends StackManipulation.AbstractBase {
        private static final String METHOD_HANDLE = "java/lang/invoke/MethodHandle";
        private final MethodDescription.InDefinedShape methodDescription;
        private final HandleType type;

        public HandleInvocation(MethodDescription.InDefinedShape inDefinedShape, HandleType handleType) {
            this.methodDescription = inDefinedShape;
            this.type = handleType;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            String descriptor;
            String methodName = this.type.getMethodName();
            if (this.methodDescription.isStatic() || this.methodDescription.isConstructor()) {
                descriptor = this.methodDescription.getDescriptor();
            } else {
                descriptor = "(" + this.methodDescription.getDeclaringType().getDescriptor() + this.methodDescription.getDescriptor().substring(1);
            }
            methodVisitor.visitMethodInsn(182, METHOD_HANDLE, methodName, descriptor, false);
            int size = this.methodDescription.getReturnType().getStackSize().getSize() - (this.methodDescription.getStackSize() + 1);
            return new StackManipulation.Size(size, Math.max(0, size));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HandleInvocation handleInvocation = (HandleInvocation) obj;
            return this.type.equals(handleInvocation.type) && this.methodDescription.equals(handleInvocation.methodDescription);
        }

        public int hashCode() {
            return this.type.hashCode() + StaticHelpers6.b(this.methodDescription, getClass().hashCode() * 31, 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum HandleType {
        EXACT("invokeExact"),
        REGULAR("invoke");

        private final String methodName;

        HandleType(String str) {
            this.methodName = str;
        }

        public String getMethodName() {
            return this.methodName;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum IllegalInvocation implements WithImplicitInvocationTargetType {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return StackManipulation.Illegal.INSTANCE.apply(methodVisitor, context);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            return StackManipulation.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return false;
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation onHandle(HandleType handleType) {
            return StackManipulation.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation special(TypeDescription typeDescription) {
            return StackManipulation.Illegal.INSTANCE;
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation virtual(TypeDescription typeDescription) {
            return StackManipulation.Illegal.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class Invocation extends StackManipulation.AbstractBase implements WithImplicitInvocationTargetType {
        private final MethodDescription.InDefinedShape methodDescription;
        private final TypeDescription typeDescription;

        public Invocation(MethodInvocation methodInvocation, MethodDescription.InDefinedShape inDefinedShape) {
            this(inDefinedShape, inDefinedShape.getDeclaringType());
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            methodVisitor.visitMethodInsn((MethodInvocation.this.opcode == MethodInvocation.this.legacyOpcode || context.getClassFileVersion().isAtLeast(ClassFileVersion.JAVA_V11)) ? MethodInvocation.this.opcode : MethodInvocation.this.legacyOpcode, this.typeDescription.getInternalName(), this.methodDescription.getInternalName(), this.methodDescription.getDescriptor(), this.typeDescription.isInterface());
            int size = this.methodDescription.getReturnType().getStackSize().getSize() - this.methodDescription.getStackSize();
            return new StackManipulation.Size(size, Math.max(0, size));
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            return this.methodDescription.isInvokeBootstrap(TypeList.Explicit.of(list2)) ? new Invokedynamic(str, JavaConstant.MethodType.of(typeDescription, list), JavaConstant.MethodHandle.of(this.methodDescription), list2) : StackManipulation.Illegal.INSTANCE;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Invocation invocation = (Invocation) obj;
            return MethodInvocation.this.equals(MethodInvocation.this) && this.typeDescription.equals(invocation.typeDescription) && this.methodDescription.equals(invocation.methodDescription);
        }

        public int hashCode() {
            return MethodInvocation.this.hashCode() + StaticHelpers6.b(this.methodDescription, StaticHelpers6.f(this.typeDescription, getClass().hashCode() * 31, 31), 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation onHandle(HandleType handleType) {
            return new HandleInvocation(this.methodDescription, handleType);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation special(TypeDescription typeDescription) {
            if (!this.methodDescription.isSpecializableFor(typeDescription)) {
                return StackManipulation.Illegal.INSTANCE;
            }
            MethodInvocation methodInvocation = MethodInvocation.SPECIAL;
            methodInvocation.getClass();
            return methodInvocation.new Invocation(this.methodDescription, typeDescription);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation virtual(TypeDescription typeDescription) {
            if (this.methodDescription.isConstructor() || this.methodDescription.isStatic()) {
                return StackManipulation.Illegal.INSTANCE;
            }
            if (this.methodDescription.isPrivate()) {
                if (!this.methodDescription.getDeclaringType().equals(typeDescription)) {
                    return StackManipulation.Illegal.INSTANCE;
                }
            } else {
                if (!typeDescription.isInterface()) {
                    MethodInvocation methodInvocation = MethodInvocation.VIRTUAL;
                    methodInvocation.getClass();
                    return methodInvocation.new Invocation(this.methodDescription, typeDescription);
                }
                if (!this.methodDescription.getDeclaringType().represents(Object.class)) {
                    MethodInvocation methodInvocation2 = MethodInvocation.INTERFACE;
                    methodInvocation2.getClass();
                    return methodInvocation2.new Invocation(this.methodDescription, typeDescription);
                }
            }
            return this;
        }

        public Invocation(MethodDescription.InDefinedShape inDefinedShape, TypeDescription typeDescription) {
            this.typeDescription = typeDescription;
            this.methodDescription = inDefinedShape;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class OfGenericMethod implements WithImplicitInvocationTargetType {
        private final WithImplicitInvocationTargetType invocation;
        private final TypeDescription targetType;

        public OfGenericMethod(TypeDescription typeDescription, WithImplicitInvocationTargetType withImplicitInvocationTargetType) {
            this.targetType = typeDescription;
            this.invocation = withImplicitInvocationTargetType;
        }

        public static WithImplicitInvocationTargetType of(MethodDescription methodDescription, WithImplicitInvocationTargetType withImplicitInvocationTargetType) {
            return new OfGenericMethod(methodDescription.getReturnType().asErasure(), withImplicitInvocationTargetType);
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
            return new StackManipulation.Compound(this.invocation, TypeCasting.to(this.targetType)).apply(methodVisitor, context);
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2) {
            return this.invocation.dynamic(str, typeDescription, list, list2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfGenericMethod ofGenericMethod = (OfGenericMethod) obj;
            return this.targetType.equals(ofGenericMethod.targetType) && this.invocation.equals(ofGenericMethod.invocation);
        }

        public int hashCode() {
            return this.invocation.hashCode() + StaticHelpers6.f(this.targetType, getClass().hashCode() * 31, 31);
        }

        @Override // net.bytebuddy.implementation.bytecode.StackManipulation
        public boolean isValid() {
            return this.invocation.isValid();
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation onHandle(HandleType handleType) {
            return new StackManipulation.Compound(this.invocation.onHandle(handleType), TypeCasting.to(this.targetType));
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation special(TypeDescription typeDescription) {
            return new StackManipulation.Compound(this.invocation.special(typeDescription), TypeCasting.to(this.targetType));
        }

        @Override // net.bytebuddy.implementation.bytecode.member.MethodInvocation.WithImplicitInvocationTargetType
        public StackManipulation virtual(TypeDescription typeDescription) {
            return new StackManipulation.Compound(this.invocation.virtual(typeDescription), TypeCasting.to(this.targetType));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface WithImplicitInvocationTargetType extends StackManipulation {
        StackManipulation dynamic(String str, TypeDescription typeDescription, List<? extends TypeDescription> list, List<? extends JavaConstant> list2);

        StackManipulation onHandle(HandleType handleType);

        StackManipulation special(TypeDescription typeDescription);

        StackManipulation virtual(TypeDescription typeDescription);
    }

    MethodInvocation(int i, int i2, int i3, int i4) {
        this.opcode = i;
        this.handle = i2;
        this.legacyOpcode = i3;
        this.legacyHandle = i4;
    }

    public static WithImplicitInvocationTargetType invoke(MethodDescription.InDefinedShape inDefinedShape) {
        if (inDefinedShape.isTypeInitializer()) {
            return IllegalInvocation.INSTANCE;
        }
        if (inDefinedShape.isStatic()) {
            MethodInvocation methodInvocation = STATIC;
            methodInvocation.getClass();
            return new Invocation(methodInvocation, inDefinedShape);
        }
        if (inDefinedShape.isConstructor()) {
            MethodInvocation methodInvocation2 = SPECIAL_CONSTRUCTOR;
            methodInvocation2.getClass();
            return new Invocation(methodInvocation2, inDefinedShape);
        }
        if (inDefinedShape.isPrivate()) {
            MethodInvocation methodInvocation3 = inDefinedShape.getDeclaringType().isInterface() ? INTERFACE_PRIVATE : VIRTUAL_PRIVATE;
            methodInvocation3.getClass();
            return new Invocation(methodInvocation3, inDefinedShape);
        }
        if (inDefinedShape.getDeclaringType().isInterface()) {
            MethodInvocation methodInvocation4 = INTERFACE;
            methodInvocation4.getClass();
            return new Invocation(methodInvocation4, inDefinedShape);
        }
        MethodInvocation methodInvocation5 = VIRTUAL;
        methodInvocation5.getClass();
        return new Invocation(methodInvocation5, inDefinedShape);
    }

    public static StackManipulation lookup() {
        return invoke((MethodDescription.InDefinedShape) new MethodDescription.Latent(JavaType.METHOD_HANDLES.getTypeStub(), new MethodDescription.Token("lookup", 9, JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().asGenericType())));
    }

    public static WithImplicitInvocationTargetType invoke(MethodDescription methodDescription) {
        MethodDescription.InDefinedShape inDefinedShapeAsDefined = methodDescription.asDefined();
        if (inDefinedShapeAsDefined.getReturnType().asErasure().equals(methodDescription.getReturnType().asErasure())) {
            return invoke(inDefinedShapeAsDefined);
        }
        return OfGenericMethod.of(methodDescription, invoke(inDefinedShapeAsDefined));
    }
}
