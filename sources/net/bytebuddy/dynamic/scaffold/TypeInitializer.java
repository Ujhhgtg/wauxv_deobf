package net.bytebuddy.dynamic.scaffold;

import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.attribute.AnnotationValueFilter;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface TypeInitializer extends ByteCodeAppender {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Drain {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Default implements Drain {
            protected final AnnotationValueFilter.Factory annotationValueFilterFactory;
            protected final TypeDescription instrumentedType;
            protected final TypeWriter.MethodPool methodPool;

            public Default(TypeDescription typeDescription, TypeWriter.MethodPool methodPool, AnnotationValueFilter.Factory factory) {
                this.instrumentedType = typeDescription;
                this.methodPool = methodPool;
                this.annotationValueFilterFactory = factory;
            }

            @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer.Drain
            public void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context) {
                typeInitializer.wrap(this.methodPool.target(new MethodDescription.Latent.TypeInitializer(this.instrumentedType))).apply(classVisitor, context, this.annotationValueFilterFactory);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                Default r5 = (Default) obj;
                return this.instrumentedType.equals(r5.instrumentedType) && this.methodPool.equals(r5.methodPool) && this.annotationValueFilterFactory.equals(r5.annotationValueFilterFactory);
            }

            public int hashCode() {
                return this.annotationValueFilterFactory.hashCode() + ((this.methodPool.hashCode() + dkz.f(this.instrumentedType, getClass().hashCode() * 31, 31)) * 31);
            }
        }

        void apply(ClassVisitor classVisitor, TypeInitializer typeInitializer, Implementation.Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum None implements TypeInitializer {
        INSTANCE;

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return ByteCodeAppender.Size.ZERO;
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public TypeInitializer expandWith(ByteCodeAppender byteCodeAppender) {
            return new Simple(byteCodeAppender);
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public boolean isDefined() {
            return false;
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record) {
            return record;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Simple implements TypeInitializer {
        private final ByteCodeAppender byteCodeAppender;

        public Simple(ByteCodeAppender byteCodeAppender) {
            this.byteCodeAppender = byteCodeAppender;
        }

        @Override // net.bytebuddy.implementation.bytecode.ByteCodeAppender
        public ByteCodeAppender.Size apply(MethodVisitor methodVisitor, Implementation.Context context, MethodDescription methodDescription) {
            return this.byteCodeAppender.apply(methodVisitor, context, methodDescription);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.byteCodeAppender.equals(((Simple) obj).byteCodeAppender);
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public TypeInitializer expandWith(ByteCodeAppender byteCodeAppender) {
            return new Simple(new ByteCodeAppender.Compound(this.byteCodeAppender, byteCodeAppender));
        }

        public int hashCode() {
            return this.byteCodeAppender.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public boolean isDefined() {
            return true;
        }

        @Override // net.bytebuddy.dynamic.scaffold.TypeInitializer
        public TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record) {
            return record.prepend(this.byteCodeAppender);
        }
    }

    TypeInitializer expandWith(ByteCodeAppender byteCodeAppender);

    boolean isDefined();

    TypeWriter.MethodPool.Record wrap(TypeWriter.MethodPool.Record record);
}
