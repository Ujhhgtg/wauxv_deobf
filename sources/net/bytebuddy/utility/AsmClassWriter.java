package net.bytebuddy.utility;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AsmClassWriter {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Factory {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class Default implements Factory {
            private static final /* synthetic */ Default[] $VALUES;
            private static final boolean ACCESS_CONTROLLER;
            public static final Default ASM_FIRST;
            public static final Default ASM_ONLY;
            public static final Default CLASS_FILE_API_FIRST;
            public static final Default CLASS_FILE_API_ONLY;
            private static final Factory FACTORY;
            public static final Default IMPLICIT;

            @MaybeNull
            private static final Class<?> JDK_CLASS_READER;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum EmptyAsmClassReader implements AsmClassReader {
                INSTANCE;

                @Override // net.bytebuddy.utility.AsmClassReader
                public void accept(ClassVisitor classVisitor, int i) {
                    throw new UnsupportedOperationException();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public List<String> getInterfaceInternalNames() {
                    throw new UnsupportedOperationException();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public String getInternalName() {
                    throw new UnsupportedOperationException();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public int getModifiers() {
                    throw new UnsupportedOperationException();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public String getSuperClassInternalName() {
                    throw new UnsupportedOperationException();
                }

                @AlwaysNull
                public AsmClassWriter toWriter(int i, TypePool typePool) {
                    return null;
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                @AlwaysNull
                public <T> T unwrap(Class<T> cls) {
                    return null;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class NonRetainingAsmClassReader implements AsmClassReader {
                private final AsmClassReader delegate;

                public NonRetainingAsmClassReader(AsmClassReader asmClassReader) {
                    this.delegate = asmClassReader;
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public void accept(ClassVisitor classVisitor, int i) {
                    this.delegate.accept(classVisitor, i);
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public List<String> getInterfaceInternalNames() {
                    return this.delegate.getInterfaceInternalNames();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public String getInternalName() {
                    return this.delegate.getInternalName();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                public int getModifiers() {
                    return this.delegate.getModifiers();
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                @MaybeNull
                public String getSuperClassInternalName() {
                    return this.delegate.getSuperClassInternalName();
                }

                @AlwaysNull
                public AsmClassWriter toWriter(int i, TypePool typePool) {
                    return null;
                }

                @Override // net.bytebuddy.utility.AsmClassReader
                @MaybeNull
                public <T> T unwrap(Class<T> cls) {
                    return (T) this.delegate.unwrap(cls);
                }
            }

            static {
                String str;
                int i = 1;
                int i2 = 0;
                Class<?> cls = null;
                try {
                    Class.forName("java.security.AccessController", false, null);
                    ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                } catch (ClassNotFoundException unused) {
                    ACCESS_CONTROLLER = false;
                } catch (SecurityException unused2) {
                    ACCESS_CONTROLLER = true;
                }
                Default r3 = new Default("IMPLICIT", i2) { // from class: net.bytebuddy.utility.AsmClassWriter.Factory.Default.1
                    @Override // net.bytebuddy.utility.AsmClassWriter.Factory
                    public AsmClassWriter make(int i3, AsmClassReader asmClassReader, TypePool typePool) {
                        return (Default.FACTORY == Default.IMPLICIT ? Default.ASM_FIRST : Default.FACTORY).make(i3, asmClassReader, typePool);
                    }
                };
                IMPLICIT = r3;
                Default r4 = new Default("ASM_FIRST", i) { // from class: net.bytebuddy.utility.AsmClassWriter.Factory.Default.2
                    @Override // net.bytebuddy.utility.AsmClassWriter.Factory
                    public AsmClassWriter make(int i3, AsmClassReader asmClassReader, TypePool typePool) {
                        return ClassFileVersion.ofThisVm().isGreaterThan(ClassFileVersion.latest()) ? Default.CLASS_FILE_API_ONLY.make(i3, asmClassReader, typePool) : Default.ASM_ONLY.make(i3, asmClassReader, typePool);
                    }
                };
                ASM_FIRST = r4;
                Default r5 = new Default("CLASS_FILE_API_FIRST", 2) { // from class: net.bytebuddy.utility.AsmClassWriter.Factory.Default.3
                    @Override // net.bytebuddy.utility.AsmClassWriter.Factory
                    public AsmClassWriter make(int i3, AsmClassReader asmClassReader, TypePool typePool) {
                        return ClassFileVersion.ofThisVm().isAtLeast(ClassFileVersion.JAVA_V24) ? Default.CLASS_FILE_API_ONLY.make(i3, asmClassReader, typePool) : Default.ASM_ONLY.make(i3, asmClassReader, typePool);
                    }
                };
                CLASS_FILE_API_FIRST = r5;
                Default r6 = new Default("ASM_ONLY", 3) { // from class: net.bytebuddy.utility.AsmClassWriter.Factory.Default.4
                    @Override // net.bytebuddy.utility.AsmClassWriter.Factory
                    public AsmClassWriter make(int i3, AsmClassReader asmClassReader, TypePool typePool) {
                        ClassReader classReader = (ClassReader) asmClassReader.unwrap(ClassReader.class);
                        return new ForAsm(classReader == null ? new FrameComputingClassWriter(i3, typePool) : new FrameComputingClassWriter(classReader, i3, typePool));
                    }
                };
                ASM_ONLY = r6;
                Default r8 = new Default("CLASS_FILE_API_ONLY", 4) { // from class: net.bytebuddy.utility.AsmClassWriter.Factory.Default.5
                    @Override // net.bytebuddy.utility.AsmClassWriter.Factory
                    public AsmClassWriter make(int i3, AsmClassReader asmClassReader, TypePool typePool) {
                        Object objUnwrap = Default.JDK_CLASS_READER == null ? null : asmClassReader.unwrap(Default.JDK_CLASS_READER);
                        return objUnwrap == null ? new ForClassFileApi(ForClassFileApi.DISPATCHER.make(i3, SuperClassResolvingJdkClassWriter.GET_SUPER_CLASS, new SuperClassResolvingJdkClassWriter(typePool))) : new ForClassFileApi(ForClassFileApi.DISPATCHER.make(objUnwrap, i3, SuperClassResolvingJdkClassWriter.GET_SUPER_CLASS, new SuperClassResolvingJdkClassWriter(typePool)));
                    }
                };
                CLASS_FILE_API_ONLY = r8;
                $VALUES = new Default[]{r3, r4, r5, r6, r8};
                try {
                    str = (String) doPrivileged(new GetSystemPropertyAction(OpenedClassReader.PROCESSOR_PROPERTY));
                } catch (Throwable unused3) {
                    str = null;
                }
                FACTORY = str == null ? ASM_FIRST : valueOf(str);
                try {
                    if (ClassFileVersion.ofThisVm().isAtLeast(ClassFileVersion.JAVA_V24)) {
                        cls = Class.forName("net.bytebuddy.jar.asmjdkbridge.JdkClassReader");
                    }
                } catch (ClassNotFoundException unused4) {
                }
                JDK_CLASS_READER = cls;
            }

            private Default(String str, int i) {
            }

            @MaybeNull
            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
            }

            public static Default valueOf(String str) {
                return (Default) Enum.valueOf(Default.class, str);
            }

            public static Default[] values() {
                return (Default[]) $VALUES.clone();
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i) {
                return make(i, TypePool.Empty.INSTANCE);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i, AsmClassReader asmClassReader) {
                return make(i, asmClassReader, TypePool.Empty.INSTANCE);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i, TypePool typePool) {
                return make(i, EmptyAsmClassReader.INSTANCE, typePool);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Suppressing implements Factory {
            private final Factory delegate;

            public Suppressing(Factory factory) {
                this.delegate = factory;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((Suppressing) obj).delegate);
            }

            public int hashCode() {
                return this.delegate.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i) {
                return this.delegate.make(i);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i, AsmClassReader asmClassReader) {
                return this.delegate.make(i);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i, TypePool typePool) {
                return this.delegate.make(i, typePool);
            }

            @Override // net.bytebuddy.utility.AsmClassWriter.Factory
            public AsmClassWriter make(int i, AsmClassReader asmClassReader, TypePool typePool) {
                return this.delegate.make(i, typePool);
            }
        }

        AsmClassWriter make(int i);

        AsmClassWriter make(int i, TypePool typePool);

        AsmClassWriter make(int i, AsmClassReader asmClassReader);

        AsmClassWriter make(int i, AsmClassReader asmClassReader, TypePool typePool);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForAsm implements AsmClassWriter {
        private final ClassWriter classWriter;

        public ForAsm(ClassWriter classWriter) {
            this.classWriter = classWriter;
        }

        @Override // net.bytebuddy.utility.AsmClassWriter
        public byte[] getBinaryRepresentation() {
            return this.classWriter.toByteArray();
        }

        @Override // net.bytebuddy.utility.AsmClassWriter
        public ClassVisitor getVisitor() {
            return this.classWriter;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForClassFileApi implements AsmClassWriter {
        private static final boolean ACCESS_CONTROLLER;
        private static final JdkClassWriter DISPATCHER;
        private final ClassVisitor classWriter;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("net.bytebuddy.jar.asmjdkbridge.JdkClassWriter")
        public interface JdkClassWriter {
            @JavaDispatcher.Instance
            @JavaDispatcher.Proxied("isInstance")
            boolean isInstance(ClassVisitor classVisitor);

            @JavaDispatcher.IsConstructor
            @JavaDispatcher.Proxied(TypeProxy.REFLECTION_METHOD)
            ClassVisitor make(int i, Method method, Object obj);

            @JavaDispatcher.IsConstructor
            @JavaDispatcher.Proxied(TypeProxy.REFLECTION_METHOD)
            ClassVisitor make(@JavaDispatcher.Proxied("net.bytebuddy.jar.asmjdkbridge.JdkClassReader") Object obj, int i, Method method, Object obj2);

            @JavaDispatcher.Proxied("toByteArray")
            byte[] toByteArray(ClassVisitor classVisitor);
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
            DISPATCHER = (JdkClassWriter) doPrivileged(JavaDispatcher.of(JdkClassWriter.class, ForClassFileApi.class.getClassLoader()));
        }

        public ForClassFileApi(ClassVisitor classVisitor) {
            if (DISPATCHER.isInstance(classVisitor)) {
                this.classWriter = classVisitor;
            } else {
                throw new IllegalArgumentException("Not a JDK class writer: " + classVisitor);
            }
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        @Override // net.bytebuddy.utility.AsmClassWriter
        public byte[] getBinaryRepresentation() {
            return DISPATCHER.toByteArray(this.classWriter);
        }

        @Override // net.bytebuddy.utility.AsmClassWriter
        public ClassVisitor getVisitor() {
            return this.classWriter;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class SuperClassResolvingJdkClassWriter {
        protected static final Method GET_SUPER_CLASS;
        private final TypePool typePool;

        static {
            try {
                GET_SUPER_CLASS = SuperClassResolvingJdkClassWriter.class.getMethod("getSuperClass", String.class);
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("Failed to resolve own method", e);
            }
        }

        public SuperClassResolvingJdkClassWriter(TypePool typePool) {
            this.typePool = typePool;
        }

        @MaybeNull
        public String getSuperClass(String str) {
            TypeDescription typeDescriptionResolve = this.typePool.describe(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).resolve();
            if (typeDescriptionResolve.isInterface()) {
                return null;
            }
            return typeDescriptionResolve.getSuperClass().asErasure().getInternalName();
        }
    }

    byte[] getBinaryRepresentation();

    ClassVisitor getVisitor();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class FrameComputingClassWriter extends ClassWriter {
        private final TypePool typePool;

        public FrameComputingClassWriter(int i, TypePool typePool) {
            super(i);
            this.typePool = typePool;
        }

        @Override // net.bytebuddy.jar.asm.ClassWriter
        public String getCommonSuperClass(String str, String str2) {
            TypeDescription typeDescriptionResolve = this.typePool.describe(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).resolve();
            TypeDescription typeDescriptionResolve2 = this.typePool.describe(str2.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).resolve();
            if (typeDescriptionResolve.isAssignableFrom(typeDescriptionResolve2)) {
                return typeDescriptionResolve.getInternalName();
            }
            if (typeDescriptionResolve.isAssignableTo(typeDescriptionResolve2)) {
                return typeDescriptionResolve2.getInternalName();
            }
            if (typeDescriptionResolve.isInterface() || typeDescriptionResolve2.isInterface()) {
                return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
            }
            do {
                TypeDescription.Generic superClass = typeDescriptionResolve.getSuperClass();
                if (superClass == null) {
                    return TypeDescription.ForLoadedType.of(Object.class).getInternalName();
                }
                typeDescriptionResolve = superClass.asErasure();
            } while (!typeDescriptionResolve.isAssignableFrom(typeDescriptionResolve2));
            return typeDescriptionResolve.getInternalName();
        }

        public FrameComputingClassWriter(ClassReader classReader, int i, TypePool typePool) {
            super(classReader, i);
            this.typePool = typePool;
        }
    }
}
