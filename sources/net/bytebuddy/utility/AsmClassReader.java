package net.bytebuddy.utility;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.jar.asm.Attribute;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AsmClassReader {
    public static final Attribute[] NO_ATTRIBUTES = new Attribute[0];

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

            static {
                int i = 1;
                String str = null;
                int i2 = 0;
                try {
                    Class.forName("java.security.AccessController", false, null);
                    ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
                } catch (ClassNotFoundException unused) {
                    ACCESS_CONTROLLER = false;
                } catch (SecurityException unused2) {
                    ACCESS_CONTROLLER = true;
                }
                Default r3 = new Default("IMPLICIT", i2) { // from class: net.bytebuddy.utility.AsmClassReader.Factory.Default.1
                    @Override // net.bytebuddy.utility.AsmClassReader.Factory
                    public AsmClassReader make(byte[] bArr, boolean z) {
                        return (Default.FACTORY == Default.IMPLICIT ? Default.ASM_FIRST : Default.FACTORY).make(bArr, z);
                    }
                };
                IMPLICIT = r3;
                Default r4 = new Default("ASM_FIRST", i) { // from class: net.bytebuddy.utility.AsmClassReader.Factory.Default.2
                    @Override // net.bytebuddy.utility.AsmClassReader.Factory
                    public AsmClassReader make(byte[] bArr, boolean z) {
                        return ClassFileVersion.ofThisVm().isGreaterThan(ClassFileVersion.latest()) ? Default.CLASS_FILE_API_ONLY.make(bArr, z) : Default.ASM_ONLY.make(bArr, z);
                    }
                };
                ASM_FIRST = r4;
                Default r5 = new Default("CLASS_FILE_API_FIRST", 2) { // from class: net.bytebuddy.utility.AsmClassReader.Factory.Default.3
                    @Override // net.bytebuddy.utility.AsmClassReader.Factory
                    public AsmClassReader make(byte[] bArr, boolean z) {
                        return ClassFileVersion.ofThisVm().isAtLeast(ClassFileVersion.JAVA_V24) ? Default.CLASS_FILE_API_ONLY.make(bArr, z) : Default.ASM_ONLY.make(bArr, z);
                    }
                };
                CLASS_FILE_API_FIRST = r5;
                Default r6 = new Default("ASM_ONLY", 3) { // from class: net.bytebuddy.utility.AsmClassReader.Factory.Default.4
                    @Override // net.bytebuddy.utility.AsmClassReader.Factory
                    public AsmClassReader make(byte[] bArr, boolean z) {
                        return new ForAsm(OpenedClassReader.of(bArr, z));
                    }
                };
                ASM_ONLY = r6;
                Default r8 = new Default("CLASS_FILE_API_ONLY", 4) { // from class: net.bytebuddy.utility.AsmClassReader.Factory.Default.5
                    @Override // net.bytebuddy.utility.AsmClassReader.Factory
                    public AsmClassReader make(byte[] bArr, boolean z) {
                        return new ForClassFileApi(ForClassFileApi.DISPATCHER.make(bArr, AsmClassReader.NO_ATTRIBUTES));
                    }
                };
                CLASS_FILE_API_ONLY = r8;
                $VALUES = new Default[]{r3, r4, r5, r6, r8};
                try {
                    str = (String) doPrivileged(new GetSystemPropertyAction(OpenedClassReader.PROCESSOR_PROPERTY));
                } catch (Throwable unused3) {
                }
                FACTORY = str == null ? ASM_FIRST : valueOf(str);
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

            @Override // net.bytebuddy.utility.AsmClassReader.Factory
            public AsmClassReader make(byte[] bArr) {
                return make(bArr, OpenedClassReader.EXPERIMENTAL);
            }
        }

        AsmClassReader make(byte[] bArr);

        AsmClassReader make(byte[] bArr, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForAsm implements AsmClassReader {
        private final ClassReader classReader;

        public ForAsm(ClassReader classReader) {
            this.classReader = classReader;
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public void accept(ClassVisitor classVisitor, int i) {
            this.classReader.accept(classVisitor, AsmClassReader.NO_ATTRIBUTES, i);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public List<String> getInterfaceInternalNames() {
            String[] interfaces = this.classReader.getInterfaces();
            return interfaces == null ? Collections.EMPTY_LIST : Arrays.asList(interfaces);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public String getInternalName() {
            return this.classReader.getClassName();
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public int getModifiers() {
            return this.classReader.getAccess();
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public String getSuperClassInternalName() {
            return this.classReader.getSuperName();
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        @MaybeNull
        public <T> T unwrap(Class<T> cls) {
            if (cls.isInstance(this.classReader)) {
                return cls.cast(this.classReader);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassFileApi implements AsmClassReader {
        private static final boolean ACCESS_CONTROLLER;
        protected static final JdkClassReader DISPATCHER;
        private final Object classReader;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("net.bytebuddy.jar.asmjdkbridge.JdkClassReader")
        public interface JdkClassReader {
            @JavaDispatcher.Proxied("accept")
            void accept(Object obj, ClassVisitor classVisitor, int i);

            @JavaDispatcher.Proxied("getAccess")
            int getAccess(Object obj);

            @JavaDispatcher.Proxied("getClassName")
            String getClassName(Object obj);

            @MaybeNull
            @JavaDispatcher.Proxied("getInterfaces")
            String[] getInterfaces(Object obj);

            @MaybeNull
            @JavaDispatcher.Proxied("getSuperName")
            String getSuperName(Object obj);

            @JavaDispatcher.Instance
            @JavaDispatcher.Proxied("isInstance")
            boolean isInstance(Object obj);

            @JavaDispatcher.IsConstructor
            @JavaDispatcher.Proxied(TypeProxy.REFLECTION_METHOD)
            Object make(byte[] bArr, Attribute[] attributeArr);
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
            DISPATCHER = (JdkClassReader) doPrivileged(JavaDispatcher.of(JdkClassReader.class, ForClassFileApi.class.getClassLoader()));
        }

        public ForClassFileApi(Object obj) {
            if (!DISPATCHER.isInstance(obj)) {
                throw new IllegalArgumentException();
            }
            this.classReader = obj;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public void accept(ClassVisitor classVisitor, int i) {
            DISPATCHER.accept(this.classReader, classVisitor, i);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classReader.equals(((ForClassFileApi) obj).classReader);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public List<String> getInterfaceInternalNames() {
            String[] interfaces = DISPATCHER.getInterfaces(this.classReader);
            return interfaces == null ? Collections.EMPTY_LIST : Arrays.asList(interfaces);
        }

        @MaybeNull
        public String[] getInterfaceTypeName() {
            return DISPATCHER.getInterfaces(this.classReader);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public String getInternalName() {
            return DISPATCHER.getClassName(this.classReader);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        public int getModifiers() {
            return DISPATCHER.getAccess(this.classReader);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        @MaybeNull
        public String getSuperClassInternalName() {
            return DISPATCHER.getSuperName(this.classReader);
        }

        @MaybeNull
        public String getSuperClassName() {
            return DISPATCHER.getSuperName(this.classReader);
        }

        public int hashCode() {
            return this.classReader.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.utility.AsmClassReader
        @MaybeNull
        public <T> T unwrap(Class<T> cls) {
            if (cls.isInstance(this.classReader)) {
                return cls.cast(this.classReader);
            }
            return null;
        }
    }

    void accept(ClassVisitor classVisitor, int i);

    List<String> getInterfaceInternalNames();

    String getInternalName();

    int getModifiers();

    @MaybeNull
    String getSuperClassInternalName();

    @MaybeNull
    <T> T unwrap(Class<T> cls);
}
