package net.bytebuddy.asm;

import com.umeng.analytics.pro.f;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.MultipleParentClassLoader;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.ExceptionMethod;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ConstantDynamic;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public abstract class ClassVisitorFactory<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final String DELEGATE = "delegate";
    private static final String LABELS = "labels";
    private static final String WRAP = "wrap";
    private final Class<?> type;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class AttributeTranslator implements ByteCodeAppender {
        protected static final String NAME = "attribute";
        private final Class<?> sourceAttribute;
        private final TypeDescription sourceWrapper;
        private final Class<?> targetAttribute;
        private final TypeDescription targetWrapper;

        public AttributeTranslator(Class<?> cls, Class<?> cls2, TypeDescription typeDescription, TypeDescription typeDescription2) {
            this.sourceAttribute = cls;
            this.targetAttribute = cls2;
            this.sourceWrapper = typeDescription;
            this.targetWrapper = typeDescription2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitTypeInsn(193, this.targetWrapper.getInternalName());
            methodVisitor.visitJumpInsn(153, label2);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitTypeInsn(192, this.targetWrapper.getInternalName());
            methodVisitor.visitFieldInsn(180, this.targetWrapper.getInternalName(), "delegate", Type.getDescriptor(this.sourceAttribute));
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitTypeInsn(187, this.sourceWrapper.getInternalName());
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(183, this.sourceWrapper.getInternalName(), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(this.targetAttribute)), false);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(3, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            AttributeTranslator attributeTranslator = (AttributeTranslator) obj;
            return this.sourceAttribute.equals(attributeTranslator.sourceAttribute) && this.targetAttribute.equals(attributeTranslator.targetAttribute) && this.sourceWrapper.equals(attributeTranslator.sourceWrapper) && this.targetWrapper.equals(attributeTranslator.targetWrapper);
        }

        public int hashCode() {
            return this.targetWrapper.hashCode() + dkz.f(this.sourceWrapper, bjs.d(bjs.d(getClass().hashCode() * 31, 31, this.sourceAttribute), 31, this.targetAttribute), 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantArrayTranslator implements ByteCodeAppender {
        protected static final String NAME = "constants";

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitInsn(190);
            methodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
            methodVisitor.visitVarInsn(58, 1);
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, 2);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor, Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(Integer.TYPE)), methodDescription.getParameters().asTypeList());
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitJumpInsn(162, label3);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitInsn(50);
            methodVisitor.visitMethodInsn(184, context.getInstrumentedType().getInternalName(), "constant", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object.class)), false);
            methodVisitor.visitInsn(83);
            methodVisitor.visitIincInsn(2, 1);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label3);
            context.getFrameGeneration().chop(methodVisitor, 1, CompoundList.of(methodDescription.getParameters().asTypeList(), TypeDescription.ForLoadedType.of(Object[].class)));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(4, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantDynamicTranslator implements ByteCodeAppender {
        protected static final String NAME = "constantDyanmic";
        private final Class<?> sourceConstantDynamic;
        private final Class<?> sourceHandle;
        private final Class<?> targetConstantDynamic;
        private final Class<?> targetHandle;

        public ConstantDynamicTranslator(Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4) {
            this.sourceConstantDynamic = cls;
            this.targetConstantDynamic = cls2;
            this.sourceHandle = cls3;
            this.targetHandle = cls4;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            String internalName = Type.getInternalName(this.sourceConstantDynamic);
            Type type = Type.INT_TYPE;
            methodVisitor.visitMethodInsn(182, internalName, "getBootstrapMethodArgumentCount", Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
            methodVisitor.visitVarInsn(58, 1);
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, 2);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().append(methodVisitor, Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(Integer.TYPE)), methodDescription.getParameters().asTypeList());
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitJumpInsn(162, label2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(21, 2);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethodArgument", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), type), false);
            methodVisitor.visitMethodInsn(184, context.getInstrumentedType().getInternalName(), "ldc", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object.class)), false);
            methodVisitor.visitInsn(83);
            methodVisitor.visitIincInsn(2, 1);
            methodVisitor.visitJumpInsn(167, label);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().chop(methodVisitor, 1, CompoundList.of(methodDescription.getParameters().asTypeList(), TypeDescription.ForLoadedType.of(Object[].class)));
            methodVisitor.visitTypeInsn(187, Type.getInternalName(this.targetConstantDynamic));
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceConstantDynamic), "getName", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceConstantDynamic), "getDescriptor", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceConstantDynamic), "getBootstrapMethod", Type.getMethodDescriptor(Type.getType(this.sourceHandle), new Type[0]), false);
            methodVisitor.visitMethodInsn(184, context.getInstrumentedType().getInternalName(), "handle", Type.getMethodDescriptor(Type.getType(this.targetHandle), Type.getType(this.sourceHandle)), false);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitMethodInsn(183, Type.getInternalName(this.targetConstantDynamic), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) String.class), Type.getType((Class<?>) String.class), Type.getType(this.targetHandle), Type.getType((Class<?>) Object[].class)), false);
            methodVisitor.visitInsn(176);
            methodVisitor.visitMaxs(6, 3);
            return new ByteCodeAppender.Size(6, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ConstantDynamicTranslator constantDynamicTranslator = (ConstantDynamicTranslator) obj;
            return this.sourceConstantDynamic.equals(constantDynamicTranslator.sourceConstantDynamic) && this.targetConstantDynamic.equals(constantDynamicTranslator.targetConstantDynamic) && this.sourceHandle.equals(constantDynamicTranslator.sourceHandle) && this.targetHandle.equals(constantDynamicTranslator.targetHandle);
        }

        public int hashCode() {
            return this.targetHandle.hashCode() + bjs.d(bjs.d(bjs.d(getClass().hashCode() * 31, 31, this.sourceConstantDynamic), 31, this.targetConstantDynamic), 31, this.sourceHandle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ConstantTranslator implements ByteCodeAppender {
        protected static final String NAME = "constant";

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> sourceConstantDynamic;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> sourceHandle;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> sourceType;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> targetConstantDynamic;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> targetHandle;

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final Class<?> targetType;

        public ConstantTranslator(@MaybeNull Class<?> cls, @MaybeNull Class<?> cls2, @MaybeNull Class<?> cls3, @MaybeNull Class<?> cls4, @MaybeNull Class<?> cls5, @MaybeNull Class<?> cls6) {
            this.sourceHandle = cls;
            this.targetHandle = cls2;
            this.sourceType = cls3;
            this.targetType = cls4;
            this.sourceConstantDynamic = cls5;
            this.targetConstantDynamic = cls6;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            MethodVisitor methodVisitor2 = methodVisitor;
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            if (this.sourceType != null && this.targetType != null) {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(193, Type.getInternalName(this.sourceType));
                methodVisitor2.visitJumpInsn(153, label);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceType));
                methodVisitor2.visitMethodInsn(182, Type.getInternalName(this.sourceType), "getDescriptor", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
                methodVisitor2 = methodVisitor;
                methodVisitor2.visitMethodInsn(184, Type.getInternalName(this.targetType), "getType", Type.getMethodDescriptor(Type.getType(this.targetType), Type.getType((Class<?>) String.class)), false);
                methodVisitor2.visitInsn(176);
                methodVisitor2.visitLabel(label);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            if (this.sourceHandle != null && this.targetHandle != null) {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(193, Type.getInternalName(this.sourceHandle));
                methodVisitor2.visitJumpInsn(153, label2);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceHandle));
                methodVisitor2.visitMethodInsn(184, context.getInstrumentedType().getInternalName(), "handle", Type.getMethodDescriptor(Type.getType(this.targetHandle), Type.getType(this.sourceHandle)), false);
                methodVisitor2.visitInsn(176);
                methodVisitor2.visitLabel(label2);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            if (this.sourceConstantDynamic != null && this.targetConstantDynamic != null) {
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(193, Type.getInternalName(this.sourceConstantDynamic));
                methodVisitor2.visitJumpInsn(153, label3);
                methodVisitor2.visitVarInsn(25, 0);
                methodVisitor2.visitTypeInsn(192, Type.getInternalName(this.sourceConstantDynamic));
                methodVisitor2.visitMethodInsn(184, context.getInstrumentedType().getInternalName(), "constantDyanmic", Type.getMethodDescriptor(Type.getType(this.targetConstantDynamic), Type.getType(this.sourceConstantDynamic)), false);
                methodVisitor2.visitInsn(176);
                methodVisitor2.visitLabel(label3);
                context.getFrameGeneration().same(methodVisitor2, methodDescription.getParameters().asTypeList());
            }
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitInsn(176);
            return new ByteCodeAppender.Size(1, 1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
        
            if (r2 != null) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
        
            if (r2 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        
            if (r2 != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x005a, code lost:
        
            if (r2 != null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x006c, code lost:
        
            if (r2 != null) goto L50;
         */
        /* JADX WARN: Found duplicated region for block: B:59:0x0081 A[RETURN] */
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
                java.lang.Class<?> r2 = r4.sourceHandle
                net.bytebuddy.asm.ClassVisitorFactory$ConstantTranslator r5 = (net.bytebuddy.asm.ClassVisitorFactory.ConstantTranslator) r5
                java.lang.Class<?> r3 = r5.sourceHandle
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
                java.lang.Class<?> r2 = r4.targetHandle
                java.lang.Class<?> r3 = r5.targetHandle
                if (r3 == 0) goto L36
                if (r2 == 0) goto L38
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L39
                return r1
            L36:
                if (r2 == 0) goto L39
            L38:
                return r1
            L39:
                java.lang.Class<?> r2 = r4.sourceType
                java.lang.Class<?> r3 = r5.sourceType
                if (r3 == 0) goto L48
                if (r2 == 0) goto L4a
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L4b
                return r1
            L48:
                if (r2 == 0) goto L4b
            L4a:
                return r1
            L4b:
                java.lang.Class<?> r2 = r4.targetType
                java.lang.Class<?> r3 = r5.targetType
                if (r3 == 0) goto L5a
                if (r2 == 0) goto L5c
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L5d
                return r1
            L5a:
                if (r2 == 0) goto L5d
            L5c:
                return r1
            L5d:
                java.lang.Class<?> r2 = r4.sourceConstantDynamic
                java.lang.Class<?> r3 = r5.sourceConstantDynamic
                if (r3 == 0) goto L6c
                if (r2 == 0) goto L6e
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L6f
                return r1
            L6c:
                if (r2 == 0) goto L6f
            L6e:
                return r1
            L6f:
                java.lang.Class<?> r2 = r4.targetConstantDynamic
                java.lang.Class<?> r5 = r5.targetConstantDynamic
                if (r5 == 0) goto L7e
                if (r2 == 0) goto L80
                boolean r5 = r2.equals(r5)
                if (r5 != 0) goto L81
                return r1
            L7e:
                if (r2 == 0) goto L81
            L80:
                return r1
            L81:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.asm.ClassVisitorFactory.ConstantTranslator.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int iHashCode = getClass().hashCode() * 31;
            Class<?> cls = this.sourceHandle;
            if (cls != null) {
                iHashCode += cls.hashCode();
            }
            int iHashCode2 = iHashCode * 31;
            Class<?> cls2 = this.targetHandle;
            if (cls2 != null) {
                iHashCode2 += cls2.hashCode();
            }
            int iHashCode3 = iHashCode2 * 31;
            Class<?> cls3 = this.sourceType;
            if (cls3 != null) {
                iHashCode3 += cls3.hashCode();
            }
            int iHashCode4 = iHashCode3 * 31;
            Class<?> cls4 = this.targetType;
            if (cls4 != null) {
                iHashCode4 += cls4.hashCode();
            }
            int iHashCode5 = iHashCode4 * 31;
            Class<?> cls5 = this.sourceConstantDynamic;
            if (cls5 != null) {
                iHashCode5 += cls5.hashCode();
            }
            int i = iHashCode5 * 31;
            Class<?> cls6 = this.targetConstantDynamic;
            return cls6 != null ? cls6.hashCode() + i : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class CreateClassVisitorFactory<S> implements PrivilegedAction<ClassVisitorFactory<S>> {
        private final ByteBuddy byteBuddy;
        private final Class<S> classVisitor;

        public CreateClassVisitorFactory(Class<S> cls, ByteBuddy byteBuddy) {
            this.classVisitor = cls;
            this.byteBuddy = byteBuddy;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CreateClassVisitorFactory createClassVisitorFactory = (CreateClassVisitorFactory) obj;
            return this.classVisitor.equals(createClassVisitorFactory.classVisitor) && this.byteBuddy.equals(createClassVisitorFactory.byteBuddy);
        }

        public int hashCode() {
            return this.byteBuddy.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.classVisitor);
        }

        /* JADX WARN: Found duplicated region for block: B:107:0x05ab A[Catch: Exception -> 0x0293, TryCatch #6 {Exception -> 0x0293, blocks: (B:43:0x0252, B:47:0x029a, B:48:0x02a2, B:51:0x02aa, B:53:0x02e4, B:130:0x06cd, B:57:0x0312, B:58:0x0334, B:60:0x0337, B:62:0x033d, B:64:0x0341, B:104:0x05a5, B:120:0x05ff, B:122:0x0613, B:125:0x062f, B:127:0x065b, B:129:0x06b0, B:118:0x05ef, B:107:0x05ab, B:109:0x05b1, B:68:0x0391, B:70:0x039b, B:72:0x03a1, B:74:0x03e8, B:76:0x03f0, B:77:0x042e, B:79:0x0438, B:81:0x043c, B:82:0x047a, B:84:0x0484, B:86:0x0488, B:87:0x04bc, B:89:0x04c4, B:92:0x04ca, B:94:0x04da, B:95:0x0512, B:96:0x054c, B:98:0x055a, B:101:0x0566, B:103:0x058f, B:131:0x06f2, B:132:0x0758), top: B:166:0x0252 }] */
        /* JADX WARN: Found duplicated region for block: B:109:0x05b1 A[Catch: Exception -> 0x0293, TRY_LEAVE, TryCatch #6 {Exception -> 0x0293, blocks: (B:43:0x0252, B:47:0x029a, B:48:0x02a2, B:51:0x02aa, B:53:0x02e4, B:130:0x06cd, B:57:0x0312, B:58:0x0334, B:60:0x0337, B:62:0x033d, B:64:0x0341, B:104:0x05a5, B:120:0x05ff, B:122:0x0613, B:125:0x062f, B:127:0x065b, B:129:0x06b0, B:118:0x05ef, B:107:0x05ab, B:109:0x05b1, B:68:0x0391, B:70:0x039b, B:72:0x03a1, B:74:0x03e8, B:76:0x03f0, B:77:0x042e, B:79:0x0438, B:81:0x043c, B:82:0x047a, B:84:0x0484, B:86:0x0488, B:87:0x04bc, B:89:0x04c4, B:92:0x04ca, B:94:0x04da, B:95:0x0512, B:96:0x054c, B:98:0x055a, B:101:0x0566, B:103:0x058f, B:131:0x06f2, B:132:0x0758), top: B:166:0x0252 }] */
        /* JADX WARN: Found duplicated region for block: B:113:0x05b8  */
        /* JADX WARN: Found duplicated region for block: B:182:0x05a9 A[SYNTHETIC] */
        @Override // java.security.PrivilegedAction
        public ClassVisitorFactory<S> run() {
            String name;
            HashMap map;
            Iterator it;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Class<Label[]> cls;
            String str6;
            HashMap map2;
            HashMap map3;
            Iterator it2;
            Class<Handle> cls2;
            String str7;
            Class<TypePath> cls3;
            String str8;
            String str9;
            Class<Label[]> cls4;
            ArrayList arrayList;
            HashMap map4;
            DynamicType attributeWrapper;
            DynamicType attributeWrapper2;
            Iterator it3;
            DynamicType.Builder builderIntercept;
            String str10;
            ArrayList arrayList2;
            HashMap map5;
            Class<Label> cls5;
            String str11;
            String str12;
            String str13;
            String str14;
            Class<Handle> cls6;
            String str15;
            String str16;
            String str17;
            Class<TypePath> cls7;
            boolean z;
            Method method;
            String str18;
            HashMap map6;
            Method method2;
            DynamicType.Builder builderIntercept2;
            Class<?>[] clsArr;
            String str19;
            String str20;
            DynamicType.Builder visitorBuilder;
            DynamicType.Builder visitorBuilder2;
            Class<?> cls8;
            Class cls9;
            String str21;
            CreateClassVisitorFactory<S> createClassVisitorFactory = this;
            String str22 = "delegate";
            String str23 = "attribute";
            String str24 = "constants";
            String str25 = "frames";
            String str26 = "handle";
            String str27 = "typePath";
            String str28 = ClassVisitorFactory.LABELS;
            String str29 = "label";
            Class<Label> cls10 = Label.class;
            if (!"ClassVisitor".equals(createClassVisitorFactory.classVisitor.getSimpleName())) {
                throw new IllegalArgumentException("Expected a class named ClassVisitor: " + createClassVisitorFactory.classVisitor);
            }
            try {
                name = createClassVisitorFactory.classVisitor.getPackage().getName();
                map = new HashMap();
                it = Arrays.asList(Attribute.class, Label.class, Type.class, TypePath.class, Handle.class, ConstantDynamic.class).iterator();
                str4 = str24;
                str5 = str25;
                cls = Label[].class;
                if (map.containsKey(cls10)) {
                    str6 = "constant";
                    map.put(cls, Class.forName("[L" + ((Class) map.get(cls10)).getName() + ";", false, createClassVisitorFactory.classVisitor.getClassLoader()));
                } else {
                    str6 = "constant";
                }
                map2 = new HashMap();
                map3 = new HashMap();
                it2 = Arrays.asList(ClassVisitor.class, AnnotationVisitor.class, ModuleVisitor.class, RecordComponentVisitor.class, FieldVisitor.class, MethodVisitor.class).iterator();
                cls4 = cls;
                arrayList = new ArrayList();
                map4 = new HashMap();
                if (map.containsKey(Attribute.class)) {
                    try {
                        ByteBuddy byteBuddy = createClassVisitorFactory.byteBuddy;
                        ConstructorStrategy.Default r11 = ConstructorStrategy.Default.NO_CONSTRUCTORS;
                        DynamicType.Builder<T> builderSubclass = byteBuddy.subclass((Class) Attribute.class, (ConstructorStrategy) r11);
                        DynamicType.Builder<T> builderSubclass2 = createClassVisitorFactory.byteBuddy.subclass((Class) map.get(Attribute.class), (ConstructorStrategy) r11);
                        attributeWrapper = ClassVisitorFactory.toAttributeWrapper(builderSubclass, Attribute.class, (Class) map.get(Attribute.class), builderSubclass.toTypeDescription(), builderSubclass2.toTypeDescription());
                        arrayList.add(attributeWrapper);
                        attributeWrapper2 = ClassVisitorFactory.toAttributeWrapper(builderSubclass2, (Class) map.get(Attribute.class), Attribute.class, builderSubclass2.toTypeDescription(), builderSubclass.toTypeDescription());
                        arrayList.add(attributeWrapper2);
                    } catch (Exception e) {
                        e = e;
                        createClassVisitorFactory = this;
                    }
                } else {
                    attributeWrapper = null;
                    attributeWrapper2 = null;
                }
                it3 = map2.entrySet().iterator();
                HashMap map7 = map4;
                ArrayList arrayList3 = arrayList;
                createClassVisitorFactory = this;
                ClassLoader classLoaderBuild = new MultipleParentClassLoader.Builder(false).appendMostSpecific(ClassVisitor.class, createClassVisitorFactory.classVisitor).build();
                ClassVisitorFactory<S> classVisitorFactory = (ClassVisitorFactory) createClassVisitorFactory.byteBuddy.subclass((Class) ClassVisitorFactory.class, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).method(ElementMatchers.named(ClassVisitorFactory.WRAP)).intercept(MethodCall.construct((MethodDescription) ((TypeDescription) map7.get(createClassVisitorFactory.classVisitor)).getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()).withArgument(0)).method(ElementMatchers.named("unwrap")).intercept(MethodCall.construct((MethodDescription) ((TypeDescription) map7.get(ClassVisitor.class)).getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()).withArgument(0).withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).make().include(arrayList3).load(classLoaderBuild).getLoaded().getConstructor(Class.class).newInstance(createClassVisitorFactory.classVisitor);
                if ((classLoaderBuild instanceof MultipleParentClassLoader) && classLoaderBuild != ClassVisitor.class.getClassLoader() && classLoaderBuild != createClassVisitorFactory.classVisitor.getClassLoader() && !((MultipleParentClassLoader) classLoaderBuild).seal()) {
                    throw new IllegalStateException("Failed to seal multiple parent class loader: " + classLoaderBuild);
                }
                return classVisitorFactory;
            } catch (Exception e2) {
                e = e2;
            }
            while (true) {
                str = str22;
                str2 = ".";
                str3 = str23;
                if (!it.hasNext()) {
                    break;
                }
                Class cls11 = (Class) it.next();
                String str30 = str24;
                try {
                    str21 = str25;
                    try {
                        map.put(cls11, Class.forName(name + "." + cls11.getSimpleName(), false, createClassVisitorFactory.classVisitor.getClassLoader()));
                    } catch (ClassNotFoundException unused) {
                    }
                } catch (ClassNotFoundException unused2) {
                    str21 = str25;
                }
                str24 = str30;
                str22 = str;
                str23 = str3;
                str25 = str21;
                throw new IllegalArgumentException("Failed to generate factory for ".concat(createClassVisitorFactory.classVisitor.getName()), e);
            }
            while (true) {
                boolean zHasNext = it2.hasNext();
                Iterator it4 = it2;
                cls2 = Handle.class;
                str7 = str26;
                cls3 = TypePath.class;
                str8 = str27;
                str9 = str28;
                if (!zHasNext) {
                    break;
                }
                Class cls12 = (Class) it4.next();
                Class<Label[]> cls13 = cls;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(name);
                    sb.append(str2);
                    str19 = str2;
                    try {
                        sb.append(cls12.getSimpleName());
                        str20 = name;
                        try {
                            Class<?> cls14 = Class.forName(sb.toString(), false, createClassVisitorFactory.classVisitor.getClassLoader());
                            if (cls12 == MethodVisitor.class) {
                                visitorBuilder = ClassVisitorFactory.toMethodVisitorBuilder(createClassVisitorFactory.byteBuddy, cls12, cls14, TypePath.class, (Class) map.get(cls3), Label.class, (Class) map.get(cls10), Type.class, (Class) map.get(Type.class), Handle.class, (Class) map.get(cls2), ConstantDynamic.class, (Class) map.get(ConstantDynamic.class));
                                visitorBuilder2 = ClassVisitorFactory.toMethodVisitorBuilder(createClassVisitorFactory.byteBuddy, cls14, cls12, (Class) map.get(cls3), TypePath.class, (Class) map.get(cls10), Label.class, (Class) map.get(Type.class), Type.class, (Class) map.get(cls2), Handle.class, (Class) map.get(ConstantDynamic.class), ConstantDynamic.class);
                                cls8 = cls14;
                                cls9 = cls12;
                            } else {
                                ByteBuddy byteBuddy2 = createClassVisitorFactory.byteBuddy;
                                Class cls15 = (Class) map.get(cls3);
                                MethodReturn methodReturn = MethodReturn.VOID;
                                visitorBuilder = ClassVisitorFactory.toVisitorBuilder(byteBuddy2, cls12, cls14, TypePath.class, cls15, new Implementation.Simple(methodReturn));
                                visitorBuilder2 = ClassVisitorFactory.toVisitorBuilder(createClassVisitorFactory.byteBuddy, cls14, cls12, (Class) map.get(cls3), TypePath.class, new Implementation.Simple(methodReturn));
                                cls8 = cls14;
                                cls9 = cls12;
                            }
                            map2.put(cls9, cls8);
                            map3.put(cls9, visitorBuilder);
                            map3.put(cls8, visitorBuilder2);
                        } catch (ClassNotFoundException unused3) {
                        }
                    } catch (ClassNotFoundException unused4) {
                        str20 = name;
                    }
                } catch (ClassNotFoundException unused5) {
                    str19 = str2;
                }
                cls = cls13;
                it2 = it4;
                str26 = str7;
                str27 = str8;
                str28 = str9;
                str2 = str19;
                name = str20;
                throw new IllegalArgumentException("Failed to generate factory for ".concat(createClassVisitorFactory.classVisitor.getName()), e);
            }
            while (true) {
                boolean zHasNext2 = it3.hasNext();
                String str31 = ClassVisitorFactory.WRAP;
                if (!zHasNext2) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it3.next();
                DynamicType dynamicType = attributeWrapper;
                DynamicType.Builder builder = (DynamicType.Builder) map3.get(entry.getKey());
                DynamicType.Builder builder2 = (DynamicType.Builder) map3.get(entry.getValue());
                Method[] methods = ((Class) entry.getKey()).getMethods();
                DynamicType dynamicType2 = attributeWrapper2;
                int length = methods.length;
                Iterator it5 = it3;
                DynamicType.Builder builder3 = builder2;
                int i = 0;
                while (i < length) {
                    builderIntercept = builder;
                    Method method3 = methods[i];
                    int i2 = length;
                    int i3 = i;
                    if (method3.getDeclaringClass() == Object.class) {
                        arrayList2 = arrayList;
                        map5 = map4;
                        map6 = map2;
                        builderIntercept2 = builder3;
                        str10 = str31;
                        cls5 = cls10;
                        str18 = str;
                        str11 = str8;
                        str12 = str9;
                        str13 = str29;
                        str14 = str7;
                        cls6 = cls2;
                        str15 = str3;
                        str16 = str4;
                        str17 = str5;
                        cls7 = cls3;
                    } else {
                        Class<?>[] parameterTypes = method3.getParameterTypes();
                        str10 = str31;
                        int length2 = parameterTypes.length;
                        arrayList2 = arrayList;
                        Class<?>[] clsArr2 = new Class[length2];
                        map5 = map4;
                        HashMap map8 = map2;
                        ArrayList arrayList4 = new ArrayList(parameterTypes.length);
                        ArrayList arrayList5 = new ArrayList(length2);
                        DynamicType.Builder builder4 = builderIntercept;
                        DynamicType.Builder builder5 = builder3;
                        int i4 = 0;
                        int i5 = 1;
                        boolean z2 = false;
                        while (true) {
                            if (i4 >= parameterTypes.length) {
                                cls5 = cls10;
                                str11 = str8;
                                str12 = str9;
                                str13 = str29;
                                str14 = str7;
                                cls6 = cls2;
                                str15 = str3;
                                str16 = str4;
                                str17 = str5;
                                cls7 = cls3;
                                z = false;
                                break;
                            }
                            if (entry.getKey() == MethodVisitor.class && parameterTypes[i4] == cls10) {
                                clsArr2[i4] = (Class) map.get(cls10);
                                clsArr = parameterTypes;
                                cls5 = cls10;
                                arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), clsArr2[i4], str29, i5, true));
                                arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), clsArr[i4], str29, i5, true));
                                str11 = str8;
                                str12 = str9;
                                str13 = str29;
                            } else {
                                clsArr = parameterTypes;
                                cls5 = cls10;
                                if (entry.getKey() == MethodVisitor.class) {
                                    Class<Label[]> cls16 = cls4;
                                    if (clsArr[i4] == cls16) {
                                        clsArr2[i4] = (Class) map.get(cls16);
                                        cls4 = cls16;
                                        String str32 = str9;
                                        str13 = str29;
                                        arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), clsArr2[i4], str32, i5, true));
                                        arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), clsArr[i4], str32, i5, true));
                                        str14 = str7;
                                        str11 = str8;
                                        str12 = str32;
                                    } else {
                                        cls4 = cls16;
                                    }
                                    cls6 = cls2;
                                    str15 = str3;
                                    str16 = str4;
                                    str17 = str5;
                                    cls7 = cls3;
                                    if (clsArr2[i4] == null) {
                                        z = true;
                                        break;
                                    }
                                    Class<?> cls17 = clsArr[i4];
                                    i5 += (cls17 != Long.TYPE || cls17 == Double.TYPE) ? 2 : 1;
                                    i4++;
                                    cls3 = cls7;
                                    parameterTypes = clsArr;
                                    str5 = str17;
                                    str4 = str16;
                                    str3 = str15;
                                    cls2 = cls6;
                                    str7 = str14;
                                    str29 = str13;
                                    str9 = str12;
                                    str8 = str11;
                                    cls10 = cls5;
                                }
                                String str33 = str9;
                                str13 = str29;
                                if (clsArr[i4] == cls3) {
                                    clsArr2[i4] = (Class) map.get(cls3);
                                    str11 = str8;
                                    str12 = str33;
                                    arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), clsArr2[i4], str11, i5, false));
                                    arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), clsArr[i4], str11, i5, false));
                                } else {
                                    str11 = str8;
                                    str12 = str33;
                                    if (entry.getKey() == MethodVisitor.class && clsArr[i4] == cls2) {
                                        clsArr2[i4] = (Class) map.get(cls2);
                                        str14 = str7;
                                        cls6 = cls2;
                                        arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), clsArr2[i4], str14, i5, false));
                                        arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), clsArr[i4], str14, i5, false));
                                    } else {
                                        str14 = str7;
                                        cls6 = cls2;
                                        if (entry.getKey() == MethodVisitor.class && clsArr[i4] == Object.class) {
                                            clsArr2[i4] = Object.class;
                                            String str34 = str6;
                                            arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), Object.class, str34, i5, false));
                                            arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), Object.class, str34, i5, false));
                                            str6 = str34;
                                        } else {
                                            String str35 = str6;
                                            if (entry.getKey() == MethodVisitor.class && clsArr[i4] == Object[].class) {
                                                clsArr2[i4] = Object[].class;
                                                str6 = str35;
                                                if (method3.getName().equals("visitFrame")) {
                                                    String str36 = str5;
                                                    cls7 = cls3;
                                                    arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), Object[].class, str36, i5, true));
                                                    arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), Object[].class, str36, i5, true));
                                                    str15 = str3;
                                                    str16 = str4;
                                                    str17 = str36;
                                                } else {
                                                    String str37 = str5;
                                                    cls7 = cls3;
                                                    String str38 = str4;
                                                    str17 = str37;
                                                    arrayList4.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getKey())).toTypeDescription(), Object[].class, str38, i5, false));
                                                    arrayList5.add(ClassVisitorFactory.toConvertedParameter(((DynamicType.Builder) map3.get(entry.getValue())).toTypeDescription(), Object[].class, str38, i5, false));
                                                    str15 = str3;
                                                    str16 = str38;
                                                }
                                            } else {
                                                String str39 = str5;
                                                cls7 = cls3;
                                                String str40 = str4;
                                                str17 = str39;
                                                str6 = str35;
                                                Class<?> cls18 = clsArr[i4];
                                                if (cls18 == Attribute.class) {
                                                    clsArr2[i4] = (Class) map.get(Attribute.class);
                                                    if (dynamicType == null || dynamicType2 == null) {
                                                        str15 = str3;
                                                        str16 = str40;
                                                        z2 = true;
                                                    } else {
                                                        str15 = str3;
                                                        str16 = str40;
                                                        arrayList4.add(ClassVisitorFactory.toConvertedParameter(dynamicType2.getTypeDescription(), (Class) map.get(Attribute.class), str15, i5, false));
                                                        arrayList5.add(ClassVisitorFactory.toConvertedParameter(dynamicType.getTypeDescription(), Attribute.class, str15, i5, false));
                                                    }
                                                } else {
                                                    str15 = str3;
                                                    str16 = str40;
                                                    clsArr2[i4] = cls18;
                                                    arrayList4.add(new MethodCall.ArgumentLoader.ForMethodParameter.Factory(i4));
                                                    arrayList5.add(new MethodCall.ArgumentLoader.ForMethodParameter.Factory(i4));
                                                }
                                            }
                                        }
                                    }
                                    str15 = str3;
                                    str16 = str4;
                                    str17 = str5;
                                    cls7 = cls3;
                                }
                                if (clsArr2[i4] == null) {
                                    z = true;
                                    break;
                                }
                                Class<?> cls172 = clsArr[i4];
                                i5 += (cls172 != Long.TYPE || cls172 == Double.TYPE) ? 2 : 1;
                                i4++;
                                cls3 = cls7;
                                parameterTypes = clsArr;
                                str5 = str17;
                                str4 = str16;
                                str3 = str15;
                                cls2 = cls6;
                                str7 = str14;
                                str29 = str13;
                                str9 = str12;
                                str8 = str11;
                                cls10 = cls5;
                            }
                            str14 = str7;
                            cls6 = cls2;
                            str15 = str3;
                            str16 = str4;
                            str17 = str5;
                            cls7 = cls3;
                            if (clsArr2[i4] == null) {
                                z = true;
                                break;
                            }
                            Class<?> cls1722 = clsArr[i4];
                            i5 += (cls1722 != Long.TYPE || cls1722 == Double.TYPE) ? 2 : 1;
                            i4++;
                            cls3 = cls7;
                            parameterTypes = clsArr;
                            str5 = str17;
                            str4 = str16;
                            str3 = str15;
                            cls2 = cls6;
                            str7 = str14;
                            str29 = str13;
                            str9 = str12;
                            str8 = str11;
                            cls10 = cls5;
                        }
                        if (z) {
                            method = null;
                            z2 = true;
                        } else {
                            try {
                                method = ((Class) entry.getValue()).getMethod(method3.getName(), clsArr2);
                            } catch (NoSuchMethodException unused6) {
                                method = null;
                                z2 = true;
                            }
                        }
                        if (z2) {
                            builderIntercept = builder4.method(ElementMatchers.is(method3)).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) UnsupportedOperationException.class));
                            builderIntercept2 = method != null ? builder5.method(ElementMatchers.is(method)).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) UnsupportedOperationException.class)) : builder5;
                            str18 = str;
                            map6 = map8;
                        } else {
                            str18 = str;
                            MethodCall methodCallWith = MethodCall.invoke(method).onField(str18).with(arrayList4);
                            MethodCall methodCallWith2 = MethodCall.invoke(method3).onField(str18).with(arrayList5);
                            map6 = map8;
                            Class cls19 = (Class) map6.get(method3.getReturnType());
                            if (cls19 != null) {
                                method2 = method;
                                methodCallWith = MethodCall.invoke((MethodDescription) ((DynamicType.Builder) map3.get(method3.getReturnType())).toTypeDescription().getDeclaredMethods().filter(ElementMatchers.named(str10)).getOnly()).withMethodCall(methodCallWith);
                                methodCallWith2 = MethodCall.invoke((MethodDescription) ((DynamicType.Builder) map3.get(cls19)).toTypeDescription().getDeclaredMethods().filter(ElementMatchers.named(str10)).getOnly()).withMethodCall(methodCallWith2);
                            } else {
                                method2 = method;
                            }
                            builderIntercept = builder4.method(ElementMatchers.is(method3)).intercept(methodCallWith);
                            builderIntercept2 = builder5.method(ElementMatchers.is(method2)).intercept(methodCallWith2);
                        }
                    }
                    str = str18;
                    map2 = map6;
                    cls3 = cls7;
                    length = i2;
                    str31 = str10;
                    builder3 = builderIntercept2;
                    i = i3 + 1;
                    str5 = str17;
                    str4 = str16;
                    arrayList = arrayList2;
                    map4 = map5;
                    str3 = str15;
                    cls2 = cls6;
                    str7 = str14;
                    str29 = str13;
                    str9 = str12;
                    str8 = str11;
                    cls10 = cls5;
                }
                builderIntercept = builder;
                ArrayList arrayList6 = arrayList;
                HashMap map9 = map4;
                Class<Label> cls20 = cls10;
                String str41 = str8;
                String str42 = str9;
                String str43 = str29;
                String str44 = str7;
                Class<Handle> cls21 = cls2;
                String str45 = str3;
                DynamicType.Unloaded<T> unloadedMake = builderIntercept.make();
                DynamicType.Unloaded<T> unloadedMake2 = builder3.make();
                map9.put(entry.getKey(), unloadedMake.getTypeDescription());
                map9.put(entry.getValue(), unloadedMake2.getTypeDescription());
                arrayList6.add(unloadedMake);
                arrayList6.add(unloadedMake2);
                arrayList = arrayList6;
                map4 = map9;
                str = str;
                map2 = map2;
                cls3 = cls3;
                attributeWrapper = dynamicType;
                it3 = it5;
                attributeWrapper2 = dynamicType2;
                str5 = str5;
                str4 = str4;
                str3 = str45;
                cls2 = cls21;
                str7 = str44;
                str29 = str43;
                str9 = str42;
                str8 = str41;
                cls10 = cls20;
                throw new IllegalArgumentException("Failed to generate factory for ".concat(createClassVisitorFactory.classVisitor.getName()), e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class FrameTranslator implements ByteCodeAppender {
        protected static final String NAME = "frames";
        private final Class<?> sourceLabel;
        private final Class<?> targetLabel;

        public FrameTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceLabel = cls;
            this.targetLabel = cls2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitTypeInsn(189, Type.getInternalName(Object.class));
            methodVisitor.visitVarInsn(58, 2);
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, 3);
            methodVisitor.visitLabel(label2);
            Implementation.Context.FrameGeneration frameGeneration = context.getFrameGeneration();
            TypeDescription typeDescriptionOf = TypeDescription.ForLoadedType.of(Object[].class);
            Class cls = Integer.TYPE;
            frameGeneration.append(methodVisitor, Arrays.asList(typeDescriptionOf, TypeDescription.ForLoadedType.of(cls)), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitJumpInsn(162, label4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitInsn(50);
            methodVisitor.visitTypeInsn(193, Type.getInternalName(this.sourceLabel));
            methodVisitor.visitJumpInsn(153, label5);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitInsn(50);
            methodVisitor.visitTypeInsn(192, Type.getInternalName(this.sourceLabel));
            methodVisitor.visitMethodInsn(183, context.getInstrumentedType().getInternalName(), "label", Type.getMethodDescriptor(Type.getType(this.targetLabel), Type.getType(this.sourceLabel)), false);
            methodVisitor.visitJumpInsn(167, label3);
            methodVisitor.visitLabel(label5);
            context.getFrameGeneration().full(methodVisitor, Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(cls)), CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(cls))));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitInsn(50);
            methodVisitor.visitLabel(label3);
            context.getFrameGeneration().full(methodVisitor, Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Object.class)), CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Arrays.asList(TypeDescription.ForLoadedType.of(Object[].class), TypeDescription.ForLoadedType.of(cls))));
            methodVisitor.visitInsn(83);
            methodVisitor.visitIincInsn(3, 1);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label4);
            context.getFrameGeneration().chop(methodVisitor, 1, CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Collections.singletonList(TypeDescription.ForLoadedType.of(Object[].class))));
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(5, 4);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FrameTranslator frameTranslator = (FrameTranslator) obj;
            return this.sourceLabel.equals(frameTranslator.sourceLabel) && this.targetLabel.equals(frameTranslator.targetLabel);
        }

        public int hashCode() {
            return this.targetLabel.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.sourceLabel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class HandleTranslator implements ByteCodeAppender {
        protected static final String NAME = "handle";
        private final Class<?> sourceHandle;
        private final Class<?> targetHandle;

        public HandleTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceHandle = cls;
            this.targetHandle = cls2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitTypeInsn(187, Type.getInternalName(this.targetHandle));
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            String internalName = Type.getInternalName(this.sourceHandle);
            Type type = Type.INT_TYPE;
            methodVisitor.visitMethodInsn(182, internalName, "getTag", Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceHandle), "getOwner", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceHandle), "getName", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceHandle), "getDesc", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitVarInsn(25, 0);
            String internalName2 = Type.getInternalName(this.sourceHandle);
            Type type2 = Type.BOOLEAN_TYPE;
            methodVisitor.visitMethodInsn(182, internalName2, "isInterface", Type.getMethodDescriptor(type2, new Type[0]), false);
            methodVisitor.visitMethodInsn(183, Type.getInternalName(this.targetHandle), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, type, Type.getType((Class<?>) String.class), Type.getType((Class<?>) String.class), Type.getType((Class<?>) String.class), type2), false);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(7, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            HandleTranslator handleTranslator = (HandleTranslator) obj;
            return this.sourceHandle.equals(handleTranslator.sourceHandle) && this.targetHandle.equals(handleTranslator.targetHandle);
        }

        public int hashCode() {
            return this.targetHandle.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.sourceHandle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class LabelArrayTranslator implements ByteCodeAppender {
        protected static final String NAME = "labels";
        private final Class<?> sourceLabel;
        private final Class<?> targetLabel;

        public LabelArrayTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceLabel = cls;
            this.targetLabel = cls2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitTypeInsn(189, Type.getInternalName(this.targetLabel));
            methodVisitor.visitVarInsn(58, 2);
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, 3);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor, Arrays.asList(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)), TypeDescription.ForLoadedType.of(Integer.TYPE)), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitInsn(190);
            methodVisitor.visitJumpInsn(162, label3);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(21, 3);
            methodVisitor.visitInsn(50);
            methodVisitor.visitMethodInsn(183, context.getInstrumentedType().getInternalName(), "label", Type.getMethodDescriptor(Type.getType(this.targetLabel), Type.getType(this.sourceLabel)), false);
            methodVisitor.visitInsn(83);
            methodVisitor.visitIincInsn(3, 1);
            methodVisitor.visitJumpInsn(167, label2);
            methodVisitor.visitLabel(label3);
            context.getFrameGeneration().chop(methodVisitor, 1, CompoundList.of(Collections.singletonList(context.getInstrumentedType()), methodDescription.getParameters().asTypeList(), Collections.singletonList(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(this.targetLabel)))));
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(5, 4);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            LabelArrayTranslator labelArrayTranslator = (LabelArrayTranslator) obj;
            return this.sourceLabel.equals(labelArrayTranslator.sourceLabel) && this.targetLabel.equals(labelArrayTranslator.targetLabel);
        }

        public int hashCode() {
            return this.targetLabel.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.sourceLabel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class LabelTranslator implements ByteCodeAppender {
        protected static final String NAME = "label";
        private final Class<?> target;

        public LabelTranslator(Class<?> cls) {
            this.target = cls;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.getInstrumentedType().getInternalName(), ClassVisitorFactory.LABELS, Type.getDescriptor(Map.class));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitMethodInsn(185, Type.getInternalName(Map.class), "get", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object.class)), true);
            methodVisitor.visitTypeInsn(192, Type.getInternalName(this.target));
            methodVisitor.visitVarInsn(58, 2);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitJumpInsn(199, label2);
            methodVisitor.visitTypeInsn(187, Type.getInternalName(this.target));
            methodVisitor.visitInsn(89);
            methodVisitor.visitMethodInsn(183, Type.getInternalName(this.target), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", false);
            methodVisitor.visitVarInsn(58, 2);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.getInstrumentedType().getInternalName(), ClassVisitorFactory.LABELS, Type.getDescriptor(Map.class));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(185, Type.getInternalName(Map.class), "put", Type.getMethodDescriptor(Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object.class), Type.getType((Class<?>) Object.class)), true);
            methodVisitor.visitInsn(87);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().append(methodVisitor, Collections.singletonList(TypeDescription.ForLoadedType.of(this.target)), CompoundList.of(context.getInstrumentedType(), methodDescription.getParameters().asTypeList()));
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(3, 3);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((LabelTranslator) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode() + (getClass().hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class NullCheckedConstruction implements ByteCodeAppender {
        private final Class<?> type;

        public NullCheckedConstruction(Class<?> cls) {
            this.type = cls;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            methodVisitor.visitVarInsn(25, 0);
            Label label = new Label();
            methodVisitor.visitJumpInsn(198, label);
            methodVisitor.visitTypeInsn(187, context.getInstrumentedType().getInternalName());
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(183, context.getInstrumentedType().getInternalName(), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(this.type)), false);
            methodVisitor.visitInsn(176);
            methodVisitor.visitLabel(label);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(3, 1);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.type.equals(((NullCheckedConstruction) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode() + (getClass().hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class TypePathTranslator implements ByteCodeAppender {
        protected static final String NAME = "typePath";
        private final Class<?> sourceTypePath;
        private final Class<?> targetTypePath;

        public TypePathTranslator(Class<?> cls, Class<?> cls2) {
            this.sourceTypePath = cls;
            this.targetTypePath = cls2;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitJumpInsn(199, label);
            methodVisitor.visitInsn(1);
            methodVisitor.visitJumpInsn(167, label2);
            context.getFrameGeneration().same(methodVisitor, methodDescription.getParameters().asTypeList());
            methodVisitor.visitLabel(label);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitMethodInsn(182, Type.getInternalName(this.sourceTypePath), "toString", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), new Type[0]), false);
            methodVisitor.visitMethodInsn(184, Type.getInternalName(this.targetTypePath), "fromString", Type.getMethodDescriptor(Type.getType(this.targetTypePath), Type.getType((Class<?>) String.class)), false);
            methodVisitor.visitLabel(label2);
            context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(this.targetTypePath), methodDescription.getParameters().asTypeList());
            methodVisitor.visitInsn(176);
            return new ByteCodeAppender.Size(1, 2);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypePathTranslator typePathTranslator = (TypePathTranslator) obj;
            return this.sourceTypePath.equals(typePathTranslator.sourceTypePath) && this.targetTypePath.equals(typePathTranslator.targetTypePath);
        }

        public int hashCode() {
            return this.targetTypePath.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.sourceTypePath);
        }
    }

    static {
        boolean z = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z;
        } catch (SecurityException unused2) {
            z = true;
            ACCESS_CONTROLLER = z;
        }
    }

    public ClassVisitorFactory(Class<?> cls) {
        this.type = cls;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <S> ClassVisitorFactory<S> of(Class<S> cls) {
        return of(cls, new ByteBuddy().with(TypeValidation.DISABLED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicType toAttributeWrapper(DynamicType.Builder<?> builder, Class<?> cls, Class<?> cls2, TypeDescription typeDescription, TypeDescription typeDescription2) {
        Visibility visibility = Visibility.PUBLIC;
        return builder.defineField("delegate", cls2, visibility, FieldManifestation.FINAL).defineConstructor(visibility).withParameters(cls2).intercept(MethodCall.invoke(cls.getDeclaredConstructor(String.class)).onSuper().with(new StackManipulation.Compound(MethodVariableAccess.REFERENCE.loadFrom(1), FieldAccess.forField((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(cls2.getField(f.y))).read()), String.class).andThen(FieldAccessor.ofField("delegate").setsArgumentAt(0))).defineMethod("attribute", cls, visibility, Ownership.STATIC).withParameters(cls2).intercept(new Implementation.Simple(new AttributeTranslator(cls, cls2, typeDescription, typeDescription2))).method(ElementMatchers.isProtected()).intercept(ExceptionMethod.throwing((Class<? extends Throwable>) UnsupportedOperationException.class)).method(ElementMatchers.named("isUnknown")).intercept(MethodCall.invoke(cls2.getMethod("isUnknown", null)).onField("delegate")).method(ElementMatchers.named("isCodeAttribute")).intercept(MethodCall.invoke(cls2.getMethod("isCodeAttribute", null)).onField("delegate")).make();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MethodCall.ArgumentLoader.Factory toConvertedParameter(TypeDescription typeDescription, Class<?> cls, String str, int i, boolean z) {
        return new MethodCall.ArgumentLoader.ForStackManipulation(new StackManipulation.Compound(z ? MethodVariableAccess.loadThis() : StackManipulation.Trivial.INSTANCE, MethodVariableAccess.REFERENCE.loadFrom(i), MethodInvocation.invoke((MethodDescription.InDefinedShape) typeDescription.getDeclaredMethods().filter(ElementMatchers.named(str)).getOnly())), cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicType.Builder<?> toMethodVisitorBuilder(ByteBuddy byteBuddy, Class<?> cls, Class<?> cls2, @MaybeNull Class<?> cls3, @MaybeNull Class<?> cls4, @MaybeNull Class<?> cls5, @MaybeNull Class<?> cls6, @MaybeNull Class<?> cls7, @MaybeNull Class<?> cls8, @MaybeNull Class<?> cls9, @MaybeNull Class<?> cls10, @MaybeNull Class<?> cls11, @MaybeNull Class<?> cls12) {
        DynamicType.Builder visitorBuilder = toVisitorBuilder(byteBuddy, cls, cls2, cls3, cls4, FieldAccessor.ofField(LABELS).setsValue(new StackManipulation.Compound(TypeCreation.of(TypeDescription.ForLoadedType.of(HashMap.class)), Duplication.SINGLE, MethodInvocation.invoke((MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(HashMap.class).getDeclaredMethods().filter(ElementMatchers.isConstructor().and(ElementMatchers.takesArguments(0))).getOnly())), Map.class));
        if (cls5 != null && cls6 != null) {
            Visibility visibility = Visibility.PRIVATE;
            visitorBuilder = visitorBuilder.defineField(LABELS, Map.class, visibility, FieldManifestation.FINAL).defineMethod("label", cls6, visibility).withParameters(cls5).intercept(new Implementation.Simple(new LabelTranslator(cls6))).defineMethod(LABELS, TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(cls6)), visibility).withParameters(TypeDescription.ArrayProjection.of(TypeDescription.ForLoadedType.of(cls5))).intercept(new Implementation.Simple(new LabelArrayTranslator(cls5, cls6))).defineMethod("frames", Object[].class, visibility).withParameters(Object[].class).intercept(new Implementation.Simple(new FrameTranslator(cls5, cls6)));
        }
        if (cls9 != null && cls10 != null) {
            visitorBuilder = visitorBuilder.defineMethod("handle", cls10, Visibility.PRIVATE, Ownership.STATIC).withParameters(cls9).intercept(new Implementation.Simple(new HandleTranslator(cls9, cls10)));
        }
        if (cls11 != null && cls12 != null && cls9 != null && cls10 != null) {
            visitorBuilder = visitorBuilder.defineMethod("constantDyanmic", cls12, Visibility.PRIVATE, Ownership.STATIC).withParameters(cls11).intercept(new Implementation.Simple(new ConstantDynamicTranslator(cls11, cls12, cls9, cls10)));
        }
        Visibility visibility2 = Visibility.PRIVATE;
        Ownership ownership = Ownership.STATIC;
        return visitorBuilder.defineMethod("constant", Object.class, visibility2, ownership).withParameters(Object.class).intercept(new Implementation.Simple(new ConstantTranslator(cls9, cls10, cls7, cls8, cls11, cls12))).defineMethod("constants", Object[].class, visibility2, ownership).withParameters(Object[].class).intercept(new Implementation.Simple(new ConstantArrayTranslator()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DynamicType.Builder<?> toVisitorBuilder(ByteBuddy byteBuddy, Class<?> cls, Class<?> cls2, @MaybeNull Class<?> cls3, @MaybeNull Class<?> cls4, Implementation implementation) {
        DynamicType.Builder<T> builderSubclass = byteBuddy.subclass((Class) cls, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS);
        Visibility visibility = Visibility.PRIVATE;
        DynamicType.Builder.FieldDefinition.Optional.Valuable<T> valuableDefineField = builderSubclass.defineField("delegate", cls2, visibility, FieldManifestation.FINAL);
        Visibility visibility2 = Visibility.PUBLIC;
        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<T> receiverTypeDefinitionIntercept = valuableDefineField.defineConstructor(visibility2).withParameters(cls2).intercept(MethodCall.invoke(cls.getDeclaredConstructor(Integer.TYPE)).with(Integer.valueOf(OpenedClassReader.ASM_API)).andThen(FieldAccessor.ofField("delegate").setsArgumentAt(0)).andThen(implementation));
        Ownership ownership = Ownership.STATIC;
        DynamicType.Builder.MethodDefinition.ReceiverTypeDefinition<T> receiverTypeDefinitionIntercept2 = receiverTypeDefinitionIntercept.defineMethod(WRAP, cls, visibility2, ownership).withParameters(cls2).intercept(new Implementation.Simple(new NullCheckedConstruction(cls2)));
        return (cls3 == null || cls4 == null) ? receiverTypeDefinitionIntercept2 : receiverTypeDefinitionIntercept2.defineMethod("typePath", cls4, visibility, ownership).withParameters(cls3).intercept(new Implementation.Simple(new TypePathTranslator(cls3, cls4)));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.type.equals(((ClassVisitorFactory) obj).type);
    }

    public Class<?> getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + (getClass().hashCode() * 31);
    }

    public abstract ClassVisitor unwrap(T t);

    public abstract T wrap(ClassVisitor classVisitor);

    public static <S> ClassVisitorFactory<S> of(Class<S> cls, ByteBuddy byteBuddy) {
        return (ClassVisitorFactory) doPrivileged(new CreateClassVisitorFactory(cls, byteBuddy));
    }
}
