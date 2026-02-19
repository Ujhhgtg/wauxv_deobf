package net.bytebuddy.build;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class AccessControllerPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String ACCESS_CONTROLLER = "java.security.AccessController";
    private static final Object[] EMPTY = new Object[0];
    private static final String NAME = "ACCESS_CONTROLLER";
    private static final Map<MethodDescription.SignatureToken, MethodDescription.SignatureToken> SIGNATURES;

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final String property;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class AccessControlWrapper implements AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper {
        private final String name;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class PrefixingMethodVisitor extends MethodVisitor {
            private final Implementation.Context.FrameGeneration frameGeneration;
            private final TypeDescription instrumentedType;
            private final String name;
            private final int offset;
            private final MethodDescription.SignatureToken token;

            public PrefixingMethodVisitor(MethodVisitor methodVisitor, TypeDescription typeDescription, MethodDescription.SignatureToken signatureToken, String str, int i, Implementation.Context.FrameGeneration frameGeneration) {
                super(OpenedClassReader.ASM_API, methodVisitor);
                this.instrumentedType = typeDescription;
                this.token = signatureToken;
                this.name = str;
                this.offset = i;
                this.frameGeneration = frameGeneration;
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitCode() {
                this.mv.visitCode();
                this.mv.visitFieldInsn(178, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(Boolean.TYPE));
                Label label = new Label();
                this.mv.visitJumpInsn(153, label);
                int size = this.offset;
                for (TypeDescription typeDescription : this.token.getParameterTypes()) {
                    this.mv.visitVarInsn(Type.getType(typeDescription.getDescriptor()).getOpcode(21), size);
                    if (typeDescription.equals(JavaType.ACCESS_CONTROL_CONTEXT.getTypeStub())) {
                        this.mv.visitTypeInsn(192, typeDescription.getInternalName());
                    }
                    size += typeDescription.getStackSize().getSize();
                }
                this.mv.visitMethodInsn(184, AccessControllerPlugin.ACCESS_CONTROLLER.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), this.token.getName(), this.token.getDescriptor(), false);
                this.mv.visitInsn(Type.getType(this.token.getReturnType().getDescriptor()).getOpcode(172));
                this.mv.visitLabel(label);
                this.frameGeneration.same(this.mv, this.token.getParameterTypes());
            }

            @Override // net.bytebuddy.jar.asm.MethodVisitor
            public void visitMaxs(int i, int i2) {
                this.mv.visitMaxs(Math.max(Math.max(StackSize.of(this.token.getParameterTypes()), this.token.getReturnType().getStackSize().getSize()), i), i2);
            }
        }

        public AccessControlWrapper(String str) {
            this.name = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((AccessControlWrapper) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.asm.AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
        public MethodVisitor wrap(TypeDescription typeDescription, MethodDescription methodDescription, MethodVisitor methodVisitor, Implementation.Context context, TypePool typePool, int i, int i2) {
            MethodDescription.SignatureToken signatureToken = (MethodDescription.SignatureToken) AccessControllerPlugin.SIGNATURES.get(methodDescription.asDefined().asSignatureToken());
            if (signatureToken == null) {
                throw new IllegalStateException(methodDescription + " does not have a method with a matching signature in java.security.AccessController");
            }
            if (!methodDescription.isPublic() && !methodDescription.isProtected()) {
                return new PrefixingMethodVisitor(methodVisitor, typeDescription, signatureToken, this.name, !methodDescription.isStatic() ? 1 : 0, context.getFrameGeneration());
            }
            throw new IllegalStateException(methodDescription + " is either public or protected what is not permitted to avoid context leaks");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class Initializer implements ByteCodeAppender {
        private final TypeDescription instrumentedType;
        private final String name;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithProperty extends Initializer {
            private final String property;

            public WithProperty(TypeDescription typeDescription, String str, String str2) {
                super(typeDescription, str);
                this.property = str2;
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.property.equals(((WithProperty) obj).property);
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int hashCode() {
                return this.property.hashCode() + (super.hashCode() * 31);
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int onAccessController(MethodVisitor methodVisitor) {
                methodVisitor.visitLdcInsn(this.property);
                methodVisitor.visitLdcInsn("true");
                methodVisitor.visitMethodInsn(184, Type.getInternalName(System.class), "getProperty", Type.getMethodDescriptor(Type.getType((Class<?>) String.class), Type.getType((Class<?>) String.class), Type.getType((Class<?>) String.class)), false);
                methodVisitor.visitMethodInsn(184, Type.getInternalName(Boolean.class), "parseBoolean", Type.getMethodDescriptor(Type.getType((Class<?>) Boolean.TYPE), Type.getType((Class<?>) String.class)), false);
                return 2;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithoutProperty extends Initializer {
            public WithoutProperty(TypeDescription typeDescription, String str) {
                super(typeDescription, str);
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int hashCode() {
                return super.hashCode();
            }

            @Override // net.bytebuddy.build.AccessControllerPlugin.Initializer
            public int onAccessController(MethodVisitor methodVisitor) {
                methodVisitor.visitInsn(4);
                return 1;
            }
        }

        public Initializer(TypeDescription typeDescription, String str) {
            this.instrumentedType = typeDescription;
            this.name = str;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            Label label = new Label();
            Label label2 = new Label();
            Label label3 = new Label();
            Label label4 = new Label();
            Label label5 = new Label();
            methodVisitor.visitTryCatchBlock(label, label2, label3, Type.getInternalName(ClassNotFoundException.class));
            methodVisitor.visitTryCatchBlock(label, label2, label4, Type.getInternalName(SecurityException.class));
            methodVisitor.visitLabel(label);
            methodVisitor.visitLdcInsn(AccessControllerPlugin.ACCESS_CONTROLLER);
            methodVisitor.visitInsn(3);
            methodVisitor.visitInsn(1);
            String internalName = Type.getInternalName(Class.class);
            Type type = Type.getType((Class<?>) Class.class);
            Type type2 = Type.getType((Class<?>) String.class);
            Class cls = Boolean.TYPE;
            methodVisitor.visitMethodInsn(184, internalName, "forName", Type.getMethodDescriptor(type, type2, Type.getType((Class<?>) cls), Type.getType((Class<?>) ClassLoader.class)), false);
            methodVisitor.visitInsn(87);
            int iOnAccessController = onAccessController(methodVisitor);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor.visitLabel(label2);
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label3);
            Implementation.Context.FrameGeneration frameGeneration = context.getFrameGeneration();
            TypeDescription typeDescriptionOf = TypeDescription.ForLoadedType.of(ClassNotFoundException.class);
            List<? extends TypeDefinition> list = Collections.EMPTY_LIST;
            frameGeneration.same1(methodVisitor, typeDescriptionOf, list);
            methodVisitor.visitInsn(87);
            methodVisitor.visitInsn(3);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor.visitJumpInsn(167, label5);
            methodVisitor.visitLabel(label4);
            context.getFrameGeneration().same1(methodVisitor, TypeDescription.ForLoadedType.of(SecurityException.class), list);
            methodVisitor.visitInsn(87);
            methodVisitor.visitInsn(4);
            methodVisitor.visitFieldInsn(179, this.instrumentedType.getInternalName(), this.name, Type.getDescriptor(cls));
            methodVisitor.visitLabel(label5);
            context.getFrameGeneration().same(methodVisitor, list);
            return new ByteCodeAppender.Size(Math.max(3, iOnAccessController), 0);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Initializer initializer = (Initializer) obj;
            return this.name.equals(initializer.name) && this.instrumentedType.equals(initializer.instrumentedType);
        }

        public int hashCode() {
            return this.name.hashCode() + StaticHelpers6.f(this.instrumentedType, getClass().hashCode() * 31, 31);
        }

        public abstract int onAccessController(MethodVisitor methodVisitor);
    }

    static {
        HashMap map = new HashMap();
        SIGNATURES = map;
        map.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class)));
        map.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class)));
        MethodDescription.SignatureToken signatureToken = new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(Object.class));
        TypeDescription typeDescriptionOf = TypeDescription.ForLoadedType.of(Object.class);
        TypeDescription typeDescriptionOf2 = TypeDescription.ForLoadedType.of(PrivilegedAction.class);
        JavaType javaType = JavaType.ACCESS_CONTROL_CONTEXT;
        map.put(signatureToken, new MethodDescription.SignatureToken("doPrivileged", typeDescriptionOf, typeDescriptionOf2, javaType.getTypeStub()));
        map.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        map.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class), TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        map.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)));
        map.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class)));
        map.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(Object.class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub()));
        map.put(new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivileged", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        map.put(new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(Permission[].class)), new MethodDescription.SignatureToken("doPrivilegedWithCombiner", TypeDescription.ForLoadedType.of(Object.class), TypeDescription.ForLoadedType.of(PrivilegedExceptionAction.class), javaType.getTypeStub(), TypeDescription.ForLoadedType.of(Permission[].class)));
        map.put(new MethodDescription.SignatureToken("getContext", TypeDescription.ForLoadedType.of(Object.class), new TypeDescription[0]), new MethodDescription.SignatureToken("getContext", javaType.getTypeStub(), new TypeDescription[0]));
        Class cls = Void.TYPE;
        map.put(new MethodDescription.SignatureToken("checkPermission", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission.class)), new MethodDescription.SignatureToken("checkPermission", TypeDescription.ForLoadedType.of(cls), TypeDescription.ForLoadedType.of(Permission.class)));
    }

    public AccessControllerPlugin() {
        this(null);
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        String strS = NAME;
        while (!typeDescription.getDeclaredFields().filter(ElementMatchers.named(strS)).isEmpty()) {
            strS = StaticHelpers6.concat(strS, "$");
        }
        DynamicType.Builder<?> builderVisit = builder.defineField(strS, Boolean.TYPE, Visibility.PRIVATE, Ownership.STATIC, FieldManifestation.FINAL).visit(new AsmVisitorWrapper.ForDeclaredMethods().method(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class), new AccessControlWrapper(strS)));
        String str = this.property;
        return builderVisit.initializer(str == null ? new Initializer.WithoutProperty(typeDescription, strS) : new Initializer.WithProperty(typeDescription, strS, str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x002e A[RETURN] */
    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
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
        String str = this.property;
        String str2 = ((AccessControllerPlugin) obj).property;
        if (str2 != null) {
            return str != null && str.equals(str2);
        }
        if (str != null) {
            return false;
        }
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.property;
        return str != null ? str.hashCode() + iHashCode : iHashCode;
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    @Plugin.Factory.UsingReflection.Priority(Integer.MAX_VALUE)
    public AccessControllerPlugin(@MaybeNull String str) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.property = str;
    }
}
