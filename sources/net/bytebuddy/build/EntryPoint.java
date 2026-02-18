package net.bytebuddy.build;

import java.io.Serializable;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface EntryPoint extends Serializable {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Default implements EntryPoint {
        REBASE { // from class: net.bytebuddy.build.EntryPoint.Default.1
            @Override // net.bytebuddy.build.EntryPoint
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion);
            }

            @Override // net.bytebuddy.build.EntryPoint
            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.rebase(typeDescription, classFileLocator, methodNameTransformer);
            }
        },
        REDEFINE { // from class: net.bytebuddy.build.EntryPoint.Default.2
            @Override // net.bytebuddy.build.EntryPoint
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion);
            }

            @Override // net.bytebuddy.build.EntryPoint
            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.redefine(typeDescription, classFileLocator);
            }
        },
        REDEFINE_LOCAL { // from class: net.bytebuddy.build.EntryPoint.Default.3
            @Override // net.bytebuddy.build.EntryPoint
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion).with(Implementation.Context.Disabled.Factory.INSTANCE);
            }

            @Override // net.bytebuddy.build.EntryPoint
            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.redefine(typeDescription, classFileLocator).ignoreAlso(ElementMatchers.not(ElementMatchers.isDeclaredBy(typeDescription)));
            }
        },
        DECORATE { // from class: net.bytebuddy.build.EntryPoint.Default.4
            @Override // net.bytebuddy.build.EntryPoint
            public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
                return new ByteBuddy(classFileVersion).with(MethodGraph.Compiler.ForDeclaredMethods.INSTANCE).with(Implementation.Context.Disabled.Factory.INSTANCE);
            }

            @Override // net.bytebuddy.build.EntryPoint
            public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
                return byteBuddy.decorate(typeDescription, classFileLocator);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Unvalidated implements EntryPoint {
        private static final long serialVersionUID = 1;
        private final EntryPoint delegate;

        public Unvalidated(EntryPoint entryPoint) {
            this.delegate = entryPoint;
        }

        @Override // net.bytebuddy.build.EntryPoint
        public ByteBuddy byteBuddy(ClassFileVersion classFileVersion) {
            return this.delegate.byteBuddy(classFileVersion).with(TypeValidation.DISABLED);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.delegate.equals(((Unvalidated) obj).delegate);
        }

        public int hashCode() {
            return this.delegate.hashCode() + (getClass().hashCode() * 31);
        }

        public String toString() {
            return "Unvalidated:" + this.delegate;
        }

        @Override // net.bytebuddy.build.EntryPoint
        public DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer) {
            return this.delegate.transform(typeDescription, byteBuddy, classFileLocator, methodNameTransformer);
        }
    }

    ByteBuddy byteBuddy(ClassFileVersion classFileVersion);

    DynamicType.Builder<?> transform(TypeDescription typeDescription, ByteBuddy byteBuddy, ClassFileLocator classFileLocator, MethodNameTransformer methodNameTransformer);
}
