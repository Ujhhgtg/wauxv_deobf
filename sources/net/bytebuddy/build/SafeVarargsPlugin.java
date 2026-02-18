package net.bytebuddy.build;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.asm.MemberAttributeExtension;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.attribute.MethodAttributeAppender;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class SafeVarargsPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Enhance {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum SafeVarargsAppender implements MethodAttributeAppender, MethodAttributeAppender.Factory {
        INSTANCE;

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender
        public void apply(MethodVisitor methodVisitor, MethodDescription methodDescription, AnnotationValueFilter annotationValueFilter) {
            if (!methodDescription.isVarArgs()) {
                throw new IllegalStateException(methodDescription + " does not have variable arguments");
            }
            if (!methodDescription.isConstructor() && !methodDescription.isStatic() && !methodDescription.isFinal()) {
                throw new IllegalStateException(methodDescription + " is neither a constructor or final and cannot declare safe varargs");
            }
            AnnotationVisitor annotationVisitorVisitAnnotation = methodVisitor.visitAnnotation("Ljava/lang/SafeVarargs;", true);
            if (annotationVisitorVisitAnnotation != null) {
                annotationVisitorVisitAnnotation.visitEnd();
            }
        }

        @Override // net.bytebuddy.implementation.attribute.MethodAttributeAppender.Factory
        public MethodAttributeAppender make(TypeDescription typeDescription) {
            return this;
        }
    }

    public SafeVarargsPlugin() {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return builder.visit(new MemberAttributeExtension.ForMethod().attribute(SafeVarargsAppender.INSTANCE).on(ElementMatchers.isAnnotatedWith((Class<? extends Annotation>) Enhance.class)));
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
        return obj != null && getClass() == obj.getClass();
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher
    public int hashCode() {
        return super.hashCode();
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }
}
