package net.bytebuddy.build;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class CachedReturnPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final MethodDescription.InDefinedShape ENHANCE_VALUE = (MethodDescription.InDefinedShape) TypeDescription.ForLoadedType.of(Enhance.class).getDeclaredMethods().filter(ElementMatchers.named("value")).getOnly();
    private static final String NAME_INFIX = "_";
    private final boolean ignoreExistingFields;

    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final RandomString randomString;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum AdviceResolver {
        BOOLEAN(Boolean.TYPE, 21, 54, 0, 154),
        BYTE(Byte.TYPE, 21, 54, 0, 154),
        SHORT(Short.TYPE, 21, 54, 0, 154),
        CHARACTER(Character.TYPE, 21, 54, 0, 154),
        INTEGER(Integer.TYPE, 21, 54, 0, 154),
        LONG(Long.TYPE, 22, 55, 136, 154),
        FLOAT(Float.TYPE, 23, 56, 139, 154),
        DOUBLE(Double.TYPE, 24, 57, 142, 154),
        REFERENCE(Object.class, 25, 58, 0, 199);

        private final DynamicType dynamicType;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ExitAdviceByteCodeAppender implements ByteCodeAppender {
            private final int branch;
            private final int convert;
            private final int load;
            private final int size;
            private final int store;

            public ExitAdviceByteCodeAppender(int i, int i2, int i3, int i4, int i5) {
                this.load = i;
                this.store = i2;
                this.convert = i3;
                this.branch = i4;
                this.size = i5;
            }

            @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
            public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
                Label label = new Label();
                Label label2 = new Label();
                methodVisitor.visitVarInsn(this.load, 0);
                int i = this.convert;
                if (i != 0) {
                    methodVisitor.visitInsn(i);
                }
                methodVisitor.visitJumpInsn(this.branch, label2);
                methodVisitor.visitVarInsn(this.load, this.size);
                methodVisitor.visitVarInsn(this.store, 0);
                methodVisitor.visitJumpInsn(167, label);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitLabel(label2);
                methodVisitor.visitVarInsn(this.load, 0);
                methodVisitor.visitVarInsn(this.store, this.size);
                methodVisitor.visitLabel(label);
                methodVisitor.visitFrame(3, 0, null, 0, null);
                methodVisitor.visitInsn(177);
                return new ByteCodeAppender.Size(this.size * 2, methodDescription.getStackSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ExitAdviceByteCodeAppender exitAdviceByteCodeAppender = (ExitAdviceByteCodeAppender) obj;
                return this.load == exitAdviceByteCodeAppender.load && this.store == exitAdviceByteCodeAppender.store && this.convert == exitAdviceByteCodeAppender.convert && this.branch == exitAdviceByteCodeAppender.branch && this.size == exitAdviceByteCodeAppender.size;
            }

            public int hashCode() {
                return (((((((((getClass().hashCode() * 31) + this.load) * 31) + this.store) * 31) + this.convert) * 31) + this.branch) * 31) + this.size;
            }
        }

        AdviceResolver(Class cls, int i, int i2, int i3, int i4) {
            DynamicType.Builder builderName = new ByteBuddy(ClassFileVersion.JAVA_V6).with(TypeValidation.DISABLED).subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(CachedReturnPlugin.class.getName() + "$Advice$" + this);
            Ownership ownership = Ownership.STATIC;
            this.dynamicType = builderName.defineMethod("enter", cls, ownership).withParameter(cls).annotateParameter(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) CacheField.class).build()).intercept(new Implementation.Simple(MethodVariableAccess.of(TypeDescription.ForLoadedType.of(cls)).loadFrom(0), MethodReturn.of(TypeDescription.ForLoadedType.of(cls)))).annotateMethod(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) Advice.OnMethodEnter.class).define("skipOn", Advice.OnNonDefaultValue.class).build()).defineMethod("exit", Void.TYPE, ownership).withParameter(cls).annotateParameter(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) Advice.Return.class).define("readOnly", false).define("typing", Assigner.Typing.DYNAMIC).build()).withParameter(cls).annotateParameter(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) CacheField.class).build()).intercept(new Implementation.Simple(new ExitAdviceByteCodeAppender(i, i2, i3, i4, StackSize.of((Class<?>) cls).getSize()))).annotateMethod(AnnotationDescription.Builder.ofType((Class<? extends Annotation>) Advice.OnMethodExit.class).build()).make();
        }

        public static AdviceResolver of(TypeDefinition typeDefinition) {
            if (typeDefinition.represents(Boolean.TYPE)) {
                return BOOLEAN;
            }
            if (typeDefinition.represents(Byte.TYPE)) {
                return BYTE;
            }
            if (typeDefinition.represents(Short.TYPE)) {
                return SHORT;
            }
            if (typeDefinition.represents(Character.TYPE)) {
                return CHARACTER;
            }
            if (typeDefinition.represents(Integer.TYPE)) {
                return INTEGER;
            }
            if (typeDefinition.represents(Long.TYPE)) {
                return LONG;
            }
            if (typeDefinition.represents(Float.TYPE)) {
                return FLOAT;
            }
            if (typeDefinition.represents(Double.TYPE)) {
                return DOUBLE;
            }
            if (!typeDefinition.isPrimitive()) {
                return REFERENCE;
            }
            throw new IllegalArgumentException("Unexpected advice type: " + typeDefinition);
        }

        public Advice toAdvice(String str) {
            return Advice.withCustomMapping().bind(CacheField.class, (Advice.OffsetMapping) new CacheFieldOffsetMapping(str)).to(this.dynamicType.getTypeDescription(), this.dynamicType);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CacheField {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class CacheFieldOffsetMapping implements Advice.OffsetMapping {
        private final String name;

        public CacheFieldOffsetMapping(String str) {
            this.name = str;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((CacheFieldOffsetMapping) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.asm.Advice.OffsetMapping
        public Advice.OffsetMapping.Target resolve(TypeDescription typeDescription, MethodDescription methodDescription, Assigner assigner, Advice.ArgumentHandler argumentHandler, Advice.OffsetMapping.Sort sort) {
            return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription) typeDescription.getDeclaredFields().filter(ElementMatchers.named(this.name)).getOnly());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
        String value() default "";
    }

    public CachedReturnPlugin() {
        this(false);
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        for (MethodDescription.InDefinedShape inDefinedShape : typeDescription.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isBridge()).and(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)))) {
            if (inDefinedShape.isAbstract()) {
                throw new IllegalStateException("Cannot cache the value of an abstract method: " + inDefinedShape);
            }
            if (!inDefinedShape.getParameters().isEmpty()) {
                throw new IllegalStateException("Cannot cache the value of a method with parameters: " + inDefinedShape);
            }
            if (inDefinedShape.getReturnType().represents(Void.TYPE)) {
                throw new IllegalStateException("Cannot cache void result for " + inDefinedShape);
            }
            String str = (String) inDefinedShape.getDeclaredAnnotations().ofType(Enhance.class).getValue(ENHANCE_VALUE).resolve(String.class);
            if (str.length() == 0) {
                str = inDefinedShape.getName() + "_" + this.randomString.nextString();
            } else if (this.ignoreExistingFields && !typeDescription.getDeclaredFields().filter(ElementMatchers.named(str)).isEmpty()) {
                break;
            }
            builder = builder.defineField(str, inDefinedShape.getReturnType().asErasure(), inDefinedShape.isStatic() ? Ownership.STATIC : Ownership.MEMBER, inDefinedShape.isStatic() ? FieldPersistence.PLAIN : FieldPersistence.TRANSIENT, Visibility.PRIVATE, SyntheticState.SYNTHETIC).visit(AdviceResolver.of(inDefinedShape.getReturnType()).toAdvice(str).on(ElementMatchers.is(inDefinedShape)));
        }
        return builder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.ignoreExistingFields == ((CachedReturnPlugin) obj).ignoreExistingFields;
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public int hashCode() {
        return (super.hashCode() * 31) + (this.ignoreExistingFields ? 1 : 0);
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    public CachedReturnPlugin(boolean z) {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
        this.ignoreExistingFields = z;
        this.randomString = new RandomString();
    }
}
