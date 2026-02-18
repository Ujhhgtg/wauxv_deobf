package net.bytebuddy.utility.dispatcher;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.Invoker;
import net.bytebuddy.utility.MethodComparator;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class JavaDispatcher<T> implements PrivilegedAction<T> {
    private static final boolean ACCESS_CONTROLLER;
    private static final boolean GENERATE;
    public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
    private static final Invoker INVOKER;
    private static final DynamicClassLoader.Resolver RESOLVER;

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;
    private final boolean generate;
    private final Class<T> proxy;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Container {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Defaults {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class DirectInvoker implements Invoker {
        private DirectInvoker() {
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

        @Override // net.bytebuddy.utility.Invoker
        public Object invoke(Method method, @MaybeNull Object obj, @MaybeNull Object[] objArr) {
            return method.invoke(obj, objArr);
        }

        @Override // net.bytebuddy.utility.Invoker
        public Object newInstance(Constructor<?> constructor, Object[] objArr) {
            return constructor.newInstance(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Dispatcher {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForConstructor implements Dispatcher {
            private final Constructor<?> constructor;

            public ForConstructor(Constructor<?> constructor) {
                this.constructor = constructor;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.constructor.getParameterTypes();
                methodVisitor.visitTypeInsn(187, Type.getInternalName(this.constructor.getDeclaringClass()));
                methodVisitor.visitInsn(89);
                int size = 1;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    Class<?> cls = parameterTypes[i];
                    Class<?> cls2 = parameterTypes2[i];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    size += type.getSize();
                }
                methodVisitor.visitMethodInsn(183, Type.getInternalName(this.constructor.getDeclaringClass()), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getConstructorDescriptor(this.constructor), false);
                methodVisitor.visitInsn(176);
                return size + 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForConstructor) obj).constructor);
            }

            public int hashCode() {
                return this.constructor.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return JavaDispatcher.INVOKER.newInstance(this.constructor, objArr);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForContainerCreation implements Dispatcher {
            private final Class<?> target;

            public ForContainerCreation(Class<?> cls) {
                this.target = cls;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitTypeInsn(189, Type.getInternalName(this.target));
                methodVisitor.visitInsn(176);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForContainerCreation) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return Array.newInstance(this.target, ((Integer) objArr[0]).intValue());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForDefaultValue implements Dispatcher {
            VOID(null, 0, 177, 0),
            BOOLEAN(Boolean.FALSE, 3, 172, 1),
            BOOLEAN_REVERSE(Boolean.TRUE, 4, 172, 1),
            BYTE((byte) 0, 3, 172, 1),
            SHORT((short) 0, 3, 172, 1),
            CHARACTER((char) 0, 3, 172, 1),
            INTEGER(0, 3, 172, 1),
            LONG(0L, 9, 173, 2),
            FLOAT(Float.valueOf(0.0f), 11, 174, 1),
            DOUBLE(Double.valueOf(0.0d), 14, 175, 2),
            REFERENCE(null, 1, 176, 1);

            private final int load;
            private final int returned;
            private final int size;

            @MaybeNull
            private final Object value;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class OfNonPrimitiveArray implements Dispatcher {
                private final Class<?> componentType;

                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
                private final Object value;

                public OfNonPrimitiveArray(Object obj, Class<?> cls) {
                    this.value = obj;
                    this.componentType = cls;
                }

                public static Dispatcher of(Class<?> cls) {
                    return new OfNonPrimitiveArray(Array.newInstance(cls, 0), cls);
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType));
                    methodVisitor.visitInsn(176);
                    return 1;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfNonPrimitiveArray) obj).componentType);
                }

                public int hashCode() {
                    return this.componentType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum OfPrimitiveArray implements Dispatcher {
                BOOLEAN(new boolean[0], 4),
                BYTE(new byte[0], 8),
                SHORT(new short[0], 9),
                CHARACTER(new char[0], 5),
                INTEGER(new int[0], 10),
                LONG(new long[0], 11),
                FLOAT(new float[0], 6),
                DOUBLE(new double[0], 7);

                private final int operand;
                private final Object value;

                OfPrimitiveArray(Object obj, int i) {
                    this.value = obj;
                    this.operand = i;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitIntInsn(188, this.operand);
                    methodVisitor.visitInsn(176);
                    return 1;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] objArr) {
                    return this.value;
                }
            }

            ForDefaultValue(@MaybeNull Object obj, int i, int i2, int i3) {
                this.value = obj;
                this.load = i;
                this.returned = i2;
                this.size = i3;
            }

            public static Dispatcher of(Class<?> cls) {
                if (cls == Void.TYPE) {
                    return VOID;
                }
                Class<?> cls2 = Boolean.TYPE;
                if (cls == cls2) {
                    return BOOLEAN;
                }
                Class<?> cls3 = Byte.TYPE;
                if (cls == cls3) {
                    return BYTE;
                }
                Class<?> cls4 = Short.TYPE;
                if (cls == cls4) {
                    return SHORT;
                }
                Class<?> cls5 = Character.TYPE;
                if (cls == cls5) {
                    return CHARACTER;
                }
                Class<?> cls6 = Integer.TYPE;
                if (cls == cls6) {
                    return INTEGER;
                }
                Class<?> cls7 = Long.TYPE;
                if (cls == cls7) {
                    return LONG;
                }
                Class<?> cls8 = Float.TYPE;
                if (cls == cls8) {
                    return FLOAT;
                }
                Class<?> cls9 = Double.TYPE;
                return cls == cls9 ? DOUBLE : cls.isArray() ? cls.getComponentType() == cls2 ? OfPrimitiveArray.BOOLEAN : cls.getComponentType() == cls3 ? OfPrimitiveArray.BYTE : cls.getComponentType() == cls4 ? OfPrimitiveArray.SHORT : cls.getComponentType() == cls5 ? OfPrimitiveArray.CHARACTER : cls.getComponentType() == cls6 ? OfPrimitiveArray.INTEGER : cls.getComponentType() == cls7 ? OfPrimitiveArray.LONG : cls.getComponentType() == cls8 ? OfPrimitiveArray.FLOAT : cls.getComponentType() == cls9 ? OfPrimitiveArray.DOUBLE : OfNonPrimitiveArray.of(cls.getComponentType()) : REFERENCE;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                int i = this.load;
                if (i != 0) {
                    methodVisitor.visitInsn(i);
                }
                methodVisitor.visitInsn(this.returned);
                return this.size;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            @MaybeNull
            public Object invoke(Object[] objArr) {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForInstanceCheck implements Dispatcher {
            private final Class<?> target;

            public ForInstanceCheck(Class<?> cls) {
                this.target = cls;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(193, Type.getInternalName(this.target));
                methodVisitor.visitInsn(172);
                return 1;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForInstanceCheck) obj).target);
            }

            public int hashCode() {
                return this.target.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                return Boolean.valueOf(this.target.isInstance(objArr[0]));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForNonStaticMethod implements Dispatcher {
            private static final Object[] NO_ARGUMENTS = new Object[0];
            private final Method method;

            public ForNonStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int i = 0;
                int size = 1;
                while (i < parameterTypes.length) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    if (parameterTypes[i] != (i == 0 ? this.method.getDeclaringClass() : parameterTypes2[i - 1])) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(i == 0 ? this.method.getDeclaringClass() : parameterTypes2[i - 1]));
                    }
                    size += type.getSize();
                    i++;
                }
                methodVisitor.visitMethodInsn(this.method.getDeclaringClass().isInterface() ? 185 : 182, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(size - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForNonStaticMethod) obj).method);
            }

            public int hashCode() {
                return this.method.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                Object[] objArr2;
                if (objArr.length == 1) {
                    objArr2 = NO_ARGUMENTS;
                } else {
                    int length = objArr.length - 1;
                    Object[] objArr3 = new Object[length];
                    System.arraycopy(objArr, 1, objArr3, 0, length);
                    objArr2 = objArr3;
                }
                return JavaDispatcher.INVOKER.invoke(this.method, objArr[0], objArr2);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForStaticMethod implements Dispatcher {
            private final Method method;

            public ForStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?>[] parameterTypes2 = this.method.getParameterTypes();
                int size = 1;
                for (int i = 0; i < parameterTypes.length; i++) {
                    Type type = Type.getType(parameterTypes[i]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), size);
                    Class<?> cls = parameterTypes[i];
                    Class<?> cls2 = parameterTypes2[i];
                    if (cls != cls2) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(cls2));
                    }
                    size += type.getSize();
                }
                methodVisitor.visitMethodInsn(184, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(size - 1, Type.getReturnType(this.method).getSize());
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForStaticMethod) obj).method);
            }

            public int hashCode() {
                return this.method.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            @MaybeNull
            public Object invoke(Object[] objArr) {
                return JavaDispatcher.INVOKER.invoke(this.method, null, objArr);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForUnresolvedMethod implements Dispatcher {
            private final String message;

            public ForUnresolvedMethod(String str) {
                this.message = str;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitTypeInsn(187, Type.getInternalName(IllegalStateException.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(this.message);
                methodVisitor.visitMethodInsn(183, Type.getInternalName(IllegalStateException.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType((Class<?>) String.class)), false);
                methodVisitor.visitInsn(191);
                return 3;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((ForUnresolvedMethod) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] objArr) {
                throw new IllegalStateException("Could not invoke proxy: " + this.message);
            }
        }

        int apply(MethodVisitor methodVisitor, Method method);

        @MaybeNull
        Object invoke(Object[] objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class DynamicClassLoader extends ClassLoader {

        @MaybeNull
        private static final String DUMP_FOLDER;
        private static final Class<?>[] NO_PARAMETER = new Class[0];
        private static final Object[] NO_ARGUMENT = new Object[0];

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Resolver {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum CreationAction implements PrivilegedAction<Resolver> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                public Resolver run() {
                    try {
                        Class<?> cls = Class.forName("java.lang.Module", false, null);
                        return new ForModuleSystem(Class.class.getMethod("getModule", null), cls.getMethod("isExported", String.class), cls.getMethod("addExports", String.class, cls), ClassLoader.class.getMethod("getUnnamedModule", null));
                    } catch (Exception unused) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForModuleSystem implements Resolver {
                private final Method addExports;
                private final Method getModule;
                private final Method getUnnamedModule;
                private final Method isExported;

                public ForModuleSystem(Method method, Method method2, Method method3, Method method4) {
                    this.getModule = method;
                    this.isExported = method2;
                    this.addExports = method3;
                    this.getUnnamedModule = method4;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.Resolver
                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                    Package r0 = cls.getPackage();
                    if (r0 != null) {
                        try {
                            Object objInvoke = this.getModule.invoke(cls, null);
                            if (((Boolean) this.isExported.invoke(objInvoke, r0.getName())).booleanValue()) {
                                return;
                            }
                            this.addExports.invoke(objInvoke, r0.getName(), this.getUnnamedModule.invoke(classLoader, null));
                        } catch (Exception e) {
                            throw new IllegalStateException("Failed to adjust module graph for dispatcher", e);
                        }
                    }
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForModuleSystem forModuleSystem = (ForModuleSystem) obj;
                    return this.getModule.equals(forModuleSystem.getModule) && this.isExported.equals(forModuleSystem.isExported) && this.addExports.equals(forModuleSystem.addExports) && this.getUnnamedModule.equals(forModuleSystem.getUnnamedModule);
                }

                public int hashCode() {
                    return this.getUnnamedModule.hashCode() + ((this.addExports.hashCode() + ((this.isExported.hashCode() + ((this.getModule.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum NoOp implements Resolver {
                INSTANCE;

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.DynamicClassLoader.Resolver
                public void accept(@MaybeNull ClassLoader classLoader, Class<?> cls) {
                }
            }

            void accept(@MaybeNull ClassLoader classLoader, Class<?> cls);
        }

        static {
            String str;
            try {
                str = (String) JavaDispatcher.doPrivileged(new GetSystemPropertyAction(TypeWriter.DUMP_PROPERTY));
            } catch (Throwable unused) {
                str = null;
            }
            DUMP_FOLDER = str;
        }

        public DynamicClassLoader(Class<?> cls) {
            super(cls.getClassLoader());
            JavaDispatcher.RESOLVER.accept(this, cls);
        }

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException
        	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
        	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
        	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
        	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
         */
        public static Invoker invoker() {
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.ofThisVm().getMinorMajorVersion(), 1, Type.getInternalName(Invoker.class) + "$Dispatcher", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(Invoker.class)});
            Method[] methodArr = (Method[]) GraalImageCode.getCurrent().sorted(Invoker.class.getMethods(), MethodComparator.INSTANCE);
            int length = methodArr.length;
            int i = 0;
            while (true) {
                int size = 1;
                if (i >= length) {
                    break;
                }
                Method method = methodArr[i];
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i2 = 0; i2 < exceptionTypes.length; i2++) {
                    strArr[i2] = Type.getInternalName(exceptionTypes[i2]);
                }
                MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), null, strArr);
                methodVisitorVisitMethod.visitCode();
                Type[] typeArr = new Type[method.getParameterTypes().length - 1];
                for (int i3 = 0; i3 < method.getParameterTypes().length; i3++) {
                    Type type = Type.getType(method.getParameterTypes()[i3]);
                    if (i3 > 0) {
                        typeArr[i3 - 1] = type;
                    }
                    methodVisitorVisitMethod.visitVarInsn(type.getOpcode(21), size);
                    size += type.getSize();
                }
                methodVisitorVisitMethod.visitMethodInsn(182, Type.getInternalName(method.getParameterTypes()[0]), method.getName(), Type.getMethodDescriptor(Type.getReturnType(method), typeArr), false);
                methodVisitorVisitMethod.visitInsn(Type.getReturnType(method).getOpcode(172));
                methodVisitorVisitMethod.visitMaxs(Math.max(size - 1, Type.getReturnType(method).getSize()), size);
                methodVisitorVisitMethod.visitEnd();
                i++;
            }
            Type type2 = Type.VOID_TYPE;
            MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), null, null);
            methodVisitorVisitMethod2.visitCode();
            methodVisitorVisitMethod2.visitVarInsn(25, 0);
            methodVisitorVisitMethod2.visitMethodInsn(183, Type.getInternalName(Object.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type2, new Type[0]), false);
            methodVisitorVisitMethod2.visitInsn(177);
            methodVisitorVisitMethod2.visitMaxs(1, 1);
            methodVisitorVisitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            try {
                String property = System.getProperty(TypeWriter.DUMP_PROPERTY);
                if (property != null) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(property, Invoker.class.getName() + "$Dispatcher.class"));
                    try {
                        fileOutputStream.write(byteArray);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                return (Invoker) new DynamicClassLoader(Invoker.class).defineClass(Invoker.class.getName() + "$Dispatcher", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (UnsupportedOperationException unused2) {
                return new DirectInvoker();
            } catch (Exception e) {
                throw new IllegalStateException("Failed to create invoker for ".concat(Invoker.class.getName()), e);
            }
        }

        public static Object proxy(Class<?> cls, Map<Method, Dispatcher> map) {
            Class<?> cls2;
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.JAVA_V5.getMinorMajorVersion(), 1, Type.getInternalName(cls) + "$Proxy", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(cls)});
            Iterator<Map.Entry<Method, Dispatcher>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Method, Dispatcher> next = it.next();
                Class<?>[] exceptionTypes = next.getKey().getExceptionTypes();
                String[] strArr = new String[exceptionTypes.length];
                for (int i = 0; i < exceptionTypes.length; i++) {
                    strArr[i] = Type.getInternalName(exceptionTypes[i]);
                }
                MethodVisitor methodVisitorVisitMethod = classWriter.visitMethod(1, next.getKey().getName(), Type.getMethodDescriptor(next.getKey()), null, strArr);
                methodVisitorVisitMethod.visitCode();
                int size = (next.getKey().getModifiers() & 8) != 0 ? 0 : 1;
                for (Class<?> cls3 : next.getKey().getParameterTypes()) {
                    size += Type.getType(cls3).getSize();
                }
                methodVisitorVisitMethod.visitMaxs(next.getValue().apply(methodVisitorVisitMethod, next.getKey()), size);
                methodVisitorVisitMethod.visitEnd();
            }
            Type type = Type.VOID_TYPE;
            MethodVisitor methodVisitorVisitMethod2 = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type, new Type[0]), null, null);
            methodVisitorVisitMethod2.visitCode();
            methodVisitorVisitMethod2.visitVarInsn(25, 0);
            methodVisitorVisitMethod2.visitMethodInsn(183, Type.getInternalName(Object.class), MethodDescription.CONSTRUCTOR_INTERNAL_NAME, Type.getMethodDescriptor(type, new Type[0]), false);
            methodVisitorVisitMethod2.visitInsn(177);
            methodVisitorVisitMethod2.visitMaxs(1, 1);
            methodVisitorVisitMethod2.visitEnd();
            classWriter.visitEnd();
            byte[] byteArray = classWriter.toByteArray();
            String str = DUMP_FOLDER;
            if (str != null) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(str, cls.getName() + "$Proxy.class"));
                    try {
                        fileOutputStream.write(byteArray);
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        fileOutputStream.close();
                        throw th;
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                cls2 = cls;
            } catch (Exception e) {
                e = e;
                cls2 = cls;
            }
            try {
                return new DynamicClassLoader(cls2).defineClass(cls2.getName() + "$Proxy", byteArray, 0, byteArray.length, JavaDispatcher.class.getProtectionDomain()).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (Exception e2) {
                e = e2;
                throw new IllegalStateException("Failed to create proxy for ".concat(cls2.getName()), e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Instance {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class InvokerCreationAction implements PrivilegedAction<Invoker> {
        private InvokerCreationAction() {
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

        @Override // java.security.PrivilegedAction
        public Invoker run() {
            return DynamicClassLoader.invoker();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsConstructor {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IsStatic {
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Proxied {
        String value();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ProxiedInvocationHandler implements InvocationHandler {
        private static final Object[] NO_ARGUMENTS = new Object[0];
        private final String name;
        private final Map<Method, Dispatcher> targets;

        public ProxiedInvocationHandler(String str, Map<Method, Dispatcher> map) {
            this.name = str;
            this.targets = map;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ProxiedInvocationHandler proxiedInvocationHandler = (ProxiedInvocationHandler) obj;
            return this.name.equals(proxiedInvocationHandler.name) && this.targets.equals(proxiedInvocationHandler.targets);
        }

        public int hashCode() {
            return this.targets.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31);
        }

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
        	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
         */
        @Override // java.lang.reflect.InvocationHandler
        @MaybeNull
        public Object invoke(Object obj, Method method, @MaybeNull Object[] objArr) {
            z = false;
            z = false;
            boolean z = false;
            if (method.getDeclaringClass() == Object.class) {
                if (method.getName().equals("hashCode")) {
                    return Integer.valueOf(hashCode());
                }
                if (method.getName().equals("equals")) {
                    Object obj2 = objArr[0];
                    if (obj2 != null && Proxy.isProxyClass(obj2.getClass()) && Proxy.getInvocationHandler(objArr[0]).equals(this)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
                if (method.getName().equals("toString")) {
                    return "Call proxy for " + this.name;
                }
                throw new IllegalStateException("Unexpected object method: " + method);
            }
            Dispatcher dispatcher = this.targets.get(method);
            try {
                try {
                    if (dispatcher != null) {
                        if (objArr == null) {
                            objArr = NO_ARGUMENTS;
                        }
                        return dispatcher.invoke(objArr);
                    }
                    throw new IllegalStateException("No proxy target found for " + method);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                }
            } catch (Error e2) {
                throw e2;
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Throwable th) {
                for (Class<?> cls : method.getExceptionTypes()) {
                    if (cls.isInstance(th)) {
                        throw th;
                    }
                }
                throw new IllegalStateException("Failed to invoke proxy for " + method, th);
            }
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
        GENERATE = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(GENERATE_PROPERTY)));
        RESOLVER = (DynamicClassLoader.Resolver) doPrivileged(DynamicClassLoader.Resolver.CreationAction.INSTANCE);
        INVOKER = (Invoker) doPrivileged(new InvokerCreationAction());
    }

    public JavaDispatcher(Class<T> cls, @MaybeNull ClassLoader classLoader, boolean z) {
        this.proxy = cls;
        this.classLoader = classLoader;
        this.generate = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls) {
        return of(cls, null);
    }

    /* JADX WARN: Found duplicated region for block: B:25:0x0039 A[RETURN] */
    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JavaDispatcher javaDispatcher = (JavaDispatcher) obj;
        if (this.generate != javaDispatcher.generate || !this.proxy.equals(javaDispatcher.proxy)) {
            return false;
        }
        ClassLoader classLoader = this.classLoader;
        ClassLoader classLoader2 = javaDispatcher.classLoader;
        if (classLoader2 != null) {
            return classLoader != null && classLoader.equals(classLoader2);
        }
        if (classLoader != null) {
            return false;
        }
    }

    public int hashCode() {
        int iD = bjs.d(getClass().hashCode() * 31, 31, this.proxy);
        ClassLoader classLoader = this.classLoader;
        if (classLoader != null) {
            iD += classLoader.hashCode();
        }
        return (iD * 31) + (this.generate ? 1 : 0);
    }

    /* JADX WARN: Found duplicated region for block: B:135:0x02c9 A[Catch: all -> 0x0206, NoSuchMethodException -> 0x0211, ClassNotFoundException -> 0x021c, TryCatch #21 {ClassNotFoundException -> 0x021c, NoSuchMethodException -> 0x0211, all -> 0x0206, blocks: (B:90:0x01ff, B:132:0x02c1, B:133:0x02c6, B:135:0x02c9, B:137:0x02d5, B:140:0x02e0, B:142:0x02e8, B:146:0x02fb, B:148:0x0303, B:121:0x0266, B:122:0x028a, B:123:0x028b, B:124:0x02a7), top: B:332:0x01ff }] */
    /* JADX WARN: Found duplicated region for block: B:137:0x02d5 A[Catch: all -> 0x0206, NoSuchMethodException -> 0x0211, ClassNotFoundException -> 0x021c, TryCatch #21 {ClassNotFoundException -> 0x021c, NoSuchMethodException -> 0x0211, all -> 0x0206, blocks: (B:90:0x01ff, B:132:0x02c1, B:133:0x02c6, B:135:0x02c9, B:137:0x02d5, B:140:0x02e0, B:142:0x02e8, B:146:0x02fb, B:148:0x0303, B:121:0x0266, B:122:0x028a, B:123:0x028b, B:124:0x02a7), top: B:332:0x01ff }] */
    /* JADX WARN: Found duplicated region for block: B:142:0x02e8 A[Catch: all -> 0x0206, NoSuchMethodException -> 0x0211, ClassNotFoundException -> 0x021c, LOOP:3: B:140:0x02e0->B:142:0x02e8, LOOP_END, TRY_LEAVE, TryCatch #21 {ClassNotFoundException -> 0x021c, NoSuchMethodException -> 0x0211, all -> 0x0206, blocks: (B:90:0x01ff, B:132:0x02c1, B:133:0x02c6, B:135:0x02c9, B:137:0x02d5, B:140:0x02e0, B:142:0x02e8, B:146:0x02fb, B:148:0x0303, B:121:0x0266, B:122:0x028a, B:123:0x028b, B:124:0x02a7), top: B:332:0x01ff }] */
    /* JADX WARN: Found duplicated region for block: B:146:0x02fb A[Catch: all -> 0x0206, NoSuchMethodException -> 0x0211, ClassNotFoundException -> 0x021c, TRY_ENTER, TryCatch #21 {ClassNotFoundException -> 0x021c, NoSuchMethodException -> 0x0211, all -> 0x0206, blocks: (B:90:0x01ff, B:132:0x02c1, B:133:0x02c6, B:135:0x02c9, B:137:0x02d5, B:140:0x02e0, B:142:0x02e8, B:146:0x02fb, B:148:0x0303, B:121:0x0266, B:122:0x028a, B:123:0x028b, B:124:0x02a7), top: B:332:0x01ff }] */
    /* JADX WARN: Found duplicated region for block: B:148:0x0303 A[Catch: all -> 0x0206, NoSuchMethodException -> 0x0211, ClassNotFoundException -> 0x021c, MOVE_INLINED, TRY_LEAVE, TryCatch #21 {ClassNotFoundException -> 0x021c, NoSuchMethodException -> 0x0211, all -> 0x0206, blocks: (B:90:0x01ff, B:132:0x02c1, B:133:0x02c6, B:135:0x02c9, B:137:0x02d5, B:140:0x02e0, B:142:0x02e8, B:146:0x02fb, B:148:0x0303, B:121:0x0266, B:122:0x028a, B:123:0x028b, B:124:0x02a7), top: B:332:0x01ff }] */
    /* JADX WARN: Found duplicated region for block: B:156:0x0322 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:159:0x032d A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, LOOP:4: B:157:0x0329->B:159:0x032d, LOOP_END, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:183:0x03c1 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, MOVE_INLINED, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:185:0x03de A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:188:0x0408 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, LOOP:2: B:136:0x02d3->B:188:0x0408, LOOP_END, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:194:0x0438 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TRY_ENTER, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:196:0x0446 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:202:0x0459 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TRY_LEAVE, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:214:0x0493 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:216:0x049b A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:217:0x04a0 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:220:0x04b6 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TRY_LEAVE, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:224:0x04c0 A[Catch: all -> 0x0334, NoSuchMethodException -> 0x0337, ClassNotFoundException -> 0x033a, TRY_ENTER, TryCatch #22 {ClassNotFoundException -> 0x033a, NoSuchMethodException -> 0x0337, all -> 0x0334, blocks: (B:154:0x0318, B:156:0x0322, B:157:0x0329, B:159:0x032d, B:166:0x033d, B:190:0x041a, B:167:0x0361, B:168:0x038b, B:181:0x039e, B:182:0x03c0, B:183:0x03c1, B:185:0x03de, B:186:0x03e1, B:187:0x0407, B:188:0x0408, B:191:0x0428, B:194:0x0438, B:196:0x0446, B:198:0x044e, B:202:0x0459, B:212:0x0470, B:213:0x0492, B:214:0x0493, B:216:0x049b, B:218:0x04a4, B:220:0x04b6, B:224:0x04c0, B:226:0x04ca, B:229:0x04d5, B:231:0x04dd, B:237:0x050e, B:234:0x04e8, B:235:0x04ed, B:236:0x050d, B:238:0x0513, B:240:0x051d, B:244:0x052e, B:258:0x0596, B:259:0x05b8, B:217:0x04a0), top: B:331:0x0318 }] */
    /* JADX WARN: Found duplicated region for block: B:228:0x04d2  */
    /* JADX WARN: Found duplicated region for block: B:242:0x0529  */
    /* JADX WARN: Found duplicated region for block: B:248:0x053c A[Catch: all -> 0x0467, NoSuchMethodException -> 0x046a, ClassNotFoundException -> 0x046d, TryCatch #13 {ClassNotFoundException -> 0x046d, NoSuchMethodException -> 0x046a, all -> 0x0467, blocks: (B:204:0x045d, B:246:0x0532, B:248:0x053c, B:250:0x0542, B:251:0x054c, B:252:0x0568, B:253:0x0569, B:255:0x056f, B:256:0x0579, B:257:0x0595), top: B:345:0x045d }] */
    /* JADX WARN: Found duplicated region for block: B:250:0x0542 A[Catch: all -> 0x0467, NoSuchMethodException -> 0x046a, ClassNotFoundException -> 0x046d, TryCatch #13 {ClassNotFoundException -> 0x046d, NoSuchMethodException -> 0x046a, all -> 0x0467, blocks: (B:204:0x045d, B:246:0x0532, B:248:0x053c, B:250:0x0542, B:251:0x054c, B:252:0x0568, B:253:0x0569, B:255:0x056f, B:256:0x0579, B:257:0x0595), top: B:345:0x045d }] */
    /* JADX WARN: Found duplicated region for block: B:253:0x0569 A[Catch: all -> 0x0467, NoSuchMethodException -> 0x046a, ClassNotFoundException -> 0x046d, TryCatch #13 {ClassNotFoundException -> 0x046d, NoSuchMethodException -> 0x046a, all -> 0x0467, blocks: (B:204:0x045d, B:246:0x0532, B:248:0x053c, B:250:0x0542, B:251:0x054c, B:252:0x0568, B:253:0x0569, B:255:0x056f, B:256:0x0579, B:257:0x0595), top: B:345:0x045d }] */
    /* JADX WARN: Found duplicated region for block: B:255:0x056f A[Catch: all -> 0x0467, NoSuchMethodException -> 0x046a, ClassNotFoundException -> 0x046d, TryCatch #13 {ClassNotFoundException -> 0x046d, NoSuchMethodException -> 0x046a, all -> 0x0467, blocks: (B:204:0x045d, B:246:0x0532, B:248:0x053c, B:250:0x0542, B:251:0x054c, B:252:0x0568, B:253:0x0569, B:255:0x056f, B:256:0x0579, B:257:0x0595), top: B:345:0x045d }] */
    /* JADX WARN: Found duplicated region for block: B:268:0x0606  */
    /* JADX WARN: Found duplicated region for block: B:272:0x0625  */
    /* JADX WARN: Found duplicated region for block: B:275:0x0633  */
    /* JADX WARN: Found duplicated region for block: B:279:0x0652  */
    /* JADX WARN: Found duplicated region for block: B:359:0x039e A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:360:0x0361 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:361:0x03e1 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:362:0x0470 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:363:0x0596 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:365:0x054c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:366:0x0579 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:378:0x0414 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:379:0x02df A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:381:0x033d A[EDGE_INSN: B:381:0x033d->B:166:0x033d BREAK  A[LOOP:4: B:157:0x0329->B:159:0x032d], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:80:0x01d5  */
    @Override // java.security.PrivilegedAction
    public T run() {
        Class<Instance> cls;
        String str;
        String str2;
        Class<?> cls2;
        Method[] methodArr;
        Object objOf;
        int i;
        Method[] methods;
        Method[] methodArr2;
        String str3;
        String str4;
        Class<?> cls3;
        Class<Instance> cls4;
        Class<?> cls5;
        int i2;
        Object objOf2;
        Object objOf3;
        Class<?>[] parameterTypes;
        boolean z;
        int i3;
        Annotation[][] parameterAnnotations;
        int i4;
        Method method;
        Class<?>[] exceptionTypes;
        int length;
        int i5;
        Class<?> cls6;
        Class<?>[] clsArr;
        Constructor<?> constructor;
        Annotation[] annotationArr;
        int length2;
        int i6;
        int i7;
        Annotation annotation;
        int i8;
        int i9;
        Class<?> cls7;
        int i10;
        StringBuilder sb;
        int i11;
        int i12;
        String str5 = "Instance check requires a single regular-typed argument: ";
        String str6 = "Instance check requires a boolean return type: ";
        Class<?> cls8 = Boolean.TYPE;
        Class<Instance> cls9 = Instance.class;
        Class<?> cls10 = Object.class;
        try {
            Object objInvoke = System.class.getMethod("getSecurityManager", null).invoke(null, null);
            if (objInvoke != null) {
                Class.forName("java.lang.SecurityManager").getMethod("checkPermission", Permission.class).invoke(objInvoke, Class.forName("java.lang.RuntimePermission").getConstructor(String.class).newInstance("net.bytebuddy.createJavaDispatcher"));
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to access security manager", e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException("Failed to instantiate runtime permission", e2);
        } catch (InvocationTargetException e3) {
            Throwable targetException = e3.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            throw new IllegalStateException("Failed to assert access rights using security manager", targetException);
        }
        Map linkedHashMap = this.generate ? new LinkedHashMap() : new HashMap();
        boolean zIsAnnotationPresent = this.proxy.isAnnotationPresent(Defaults.class);
        String strValue = ((Proxied) this.proxy.getAnnotation(Proxied.class)).value();
        try {
            Class<?> cls11 = Class.forName(strValue, false, this.classLoader);
            boolean z2 = this.generate;
            if (z2) {
                i = 0;
                methods = (Method[]) GraalImageCode.getCurrent().sorted(this.proxy.getMethods(), MethodComparator.INSTANCE);
            } else {
                i = 0;
                methods = this.proxy.getMethods();
            }
            int length3 = methods.length;
            boolean z3 = z2;
            int i13 = i;
            while (i13 < length3) {
                int i14 = i13;
                Method method2 = methods[i14];
                if (method2.getDeclaringClass() == cls10) {
                    methodArr2 = methods;
                } else if (method2.isAnnotationPresent(cls9)) {
                    methodArr2 = methods;
                    if (method2.getParameterTypes().length != 1 || !method2.getParameterTypes()[i].isAssignableFrom(cls11)) {
                        throw new IllegalStateException(str5 + method2);
                    }
                    if (method2.getReturnType() != cls8) {
                        throw new IllegalStateException(str6 + method2);
                    }
                    linkedHashMap.put(method2, new Dispatcher.ForInstanceCheck(cls11));
                } else {
                    methodArr2 = methods;
                    if (method2.isAnnotationPresent(Container.class)) {
                        if (method2.getParameterTypes().length != 1 || method2.getParameterTypes()[i] != Integer.TYPE) {
                            throw new IllegalStateException("Container creation requires a single int-typed argument: " + method2);
                        }
                        if (!method2.getReturnType().isArray() || !method2.getReturnType().getComponentType().isAssignableFrom(cls11)) {
                            throw new IllegalStateException("Container creation requires an assignable array as return value: " + method2);
                        }
                        linkedHashMap.put(method2, new Dispatcher.ForContainerCreation(cls11));
                    } else {
                        if (cls11.getName().equals("java.lang.invoke.MethodHandles") && method2.getName().equals("lookup")) {
                            throw new UnsupportedOperationException("Cannot resolve Byte Buddy lookup via dispatcher");
                        }
                        try {
                            parameterTypes = method2.getParameterTypes();
                        } catch (ClassNotFoundException e4) {
                            e = e4;
                            str3 = str5;
                            str4 = str6;
                            cls3 = cls8;
                            cls4 = cls9;
                            cls5 = cls10;
                            i2 = length3;
                        } catch (NoSuchMethodException e5) {
                            e = e5;
                            str3 = str5;
                            str4 = str6;
                            cls3 = cls8;
                            cls4 = cls9;
                            cls5 = cls10;
                            i2 = length3;
                        } catch (Throwable th) {
                            th = th;
                            str3 = str5;
                            str4 = str6;
                            cls3 = cls8;
                            cls4 = cls9;
                            cls5 = cls10;
                            i2 = length3;
                        }
                        if (method2.isAnnotationPresent(IsStatic.class)) {
                            str3 = str5;
                            str4 = str6;
                            i2 = length3;
                            z = z3;
                            i3 = 0;
                            parameterAnnotations = method2.getParameterAnnotations();
                            i4 = 0;
                            while (i4 < parameterTypes.length) {
                                annotationArr = parameterAnnotations[i4 + i3];
                                int i15 = i3;
                                length2 = annotationArr.length;
                                Annotation[][] annotationArr2 = parameterAnnotations;
                                i6 = 0;
                                while (true) {
                                    if (i6 < length2) {
                                        cls3 = cls8;
                                        cls4 = cls9;
                                        cls5 = cls10;
                                        break;
                                        break;
                                    }
                                    i7 = length2;
                                    annotation = annotationArr[i6];
                                    i8 = i6;
                                    if (annotation instanceof Proxied) {
                                        i9 = 0;
                                        while (parameterTypes[i4].isArray()) {
                                            i9++;
                                            parameterTypes[i4] = parameterTypes[i4].getComponentType();
                                        }
                                        if (i9 > 0) {
                                            cls3 = cls8;
                                            cls4 = cls9;
                                            cls5 = cls10;
                                            cls7 = Class.forName(((Proxied) annotation).value(), false, this.classLoader);
                                            if (parameterTypes[i4].isAssignableFrom(cls7)) {
                                                parameterTypes[i4] = cls7;
                                                break;
                                                break;
                                            }
                                            throw new IllegalStateException("Cannot resolve to type: " + cls7.getName() + " at " + i4 + " of " + method2);
                                        }
                                        if (!parameterTypes[i4].isPrimitive()) {
                                            throw new IllegalStateException("Primitive values are not supposed to be proxied: " + i4 + " of " + method2);
                                        }
                                        i10 = i9;
                                        cls3 = cls8;
                                        cls4 = cls9;
                                        cls5 = cls10;
                                        if (parameterTypes[i4].isAssignableFrom(Class.forName(((Proxied) annotation).value(), false, this.classLoader))) {
                                            throw new IllegalStateException("Cannot resolve to component type: " + ((Proxied) annotation).value() + " at " + i4 + " of " + method2);
                                        }
                                        sb = new StringBuilder();
                                        i11 = i10;
                                        while (true) {
                                            i12 = i11 - 1;
                                            if (i11 > 0) {
                                                break;
                                                break;
                                            }
                                            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                                            i11 = i12;
                                        }
                                        sb.append('L');
                                        sb.append(((Proxied) annotation).value());
                                        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                                        parameterTypes[i4] = Class.forName(sb.toString(), false, this.classLoader);
                                        break;
                                        break;
                                    }
                                    i6 = i8 + 1;
                                    length2 = i7;
                                }
                                i4++;
                                i3 = i15;
                                parameterAnnotations = annotationArr2;
                                cls8 = cls3;
                                cls9 = cls4;
                                cls10 = cls5;
                            }
                            cls3 = cls8;
                            cls4 = cls9;
                            cls5 = cls10;
                            if (method2.isAnnotationPresent(IsConstructor.class)) {
                                constructor = cls11.getConstructor(parameterTypes);
                                if (method2.getReturnType().isAssignableFrom(cls11)) {
                                    throw new IllegalStateException("Cannot assign " + constructor.getDeclaringClass().getName() + " to " + method2);
                                }
                                if ((constructor.getModifiers() & 1) != 0) {
                                    constructor.setAccessible(true);
                                    z3 = false;
                                } else {
                                    constructor.setAccessible(true);
                                    z3 = false;
                                }
                                linkedHashMap.put(method2, new Dispatcher.ForConstructor(constructor));
                            } else {
                                Proxied proxied = (Proxied) method2.getAnnotation(Proxied.class);
                                method = cls11.getMethod(proxied == null ? method2.getName() : proxied.value(), parameterTypes);
                                if (method2.getReturnType().isAssignableFrom(method.getReturnType())) {
                                    throw new IllegalStateException("Cannot assign " + method.getReturnType().getName() + " to " + method2);
                                }
                                exceptionTypes = method.getExceptionTypes();
                                length = exceptionTypes.length;
                                i5 = 0;
                                while (i5 < length) {
                                    cls6 = exceptionTypes[i5];
                                    clsArr = RuntimeException.class.isAssignableFrom(cls6) ? exceptionTypes : exceptionTypes;
                                    i5++;
                                    exceptionTypes = clsArr;
                                }
                                if ((method.getModifiers() & 1) != 0) {
                                    method.setAccessible(true);
                                    z3 = false;
                                } else {
                                    method.setAccessible(true);
                                    z3 = false;
                                }
                                if (Modifier.isStatic(method.getModifiers())) {
                                    if (method2.isAnnotationPresent(IsStatic.class)) {
                                        throw new IllegalStateException("Resolved method for " + method2 + " was expected to be static: " + method);
                                    }
                                    linkedHashMap.put(method2, new Dispatcher.ForStaticMethod(method));
                                } else {
                                    if (!method2.isAnnotationPresent(IsStatic.class)) {
                                        throw new IllegalStateException("Resolved method for " + method2 + " was expected to be virtual: " + method);
                                    }
                                    linkedHashMap.put(method2, new Dispatcher.ForNonStaticMethod(method));
                                }
                            }
                        } else {
                            try {
                                parameterAnnotations = method2.getParameterAnnotations();
                                i4 = 0;
                                while (i4 < parameterTypes.length) {
                                    annotationArr = parameterAnnotations[i4 + i3];
                                    int i152 = i3;
                                    length2 = annotationArr.length;
                                    Annotation[][] annotationArr22 = parameterAnnotations;
                                    i6 = 0;
                                    while (true) {
                                        if (i6 < length2) {
                                            cls3 = cls8;
                                            cls4 = cls9;
                                            cls5 = cls10;
                                            break;
                                        }
                                        i7 = length2;
                                        annotation = annotationArr[i6];
                                        i8 = i6;
                                        if (annotation instanceof Proxied) {
                                            i9 = 0;
                                            while (parameterTypes[i4].isArray()) {
                                                i9++;
                                                parameterTypes[i4] = parameterTypes[i4].getComponentType();
                                            }
                                            if (i9 > 0) {
                                                cls3 = cls8;
                                                cls4 = cls9;
                                                cls5 = cls10;
                                                cls7 = Class.forName(((Proxied) annotation).value(), false, this.classLoader);
                                                if (parameterTypes[i4].isAssignableFrom(cls7)) {
                                                    parameterTypes[i4] = cls7;
                                                    break;
                                                }
                                                throw new IllegalStateException("Cannot resolve to type: " + cls7.getName() + " at " + i4 + " of " + method2);
                                            }
                                            if (!parameterTypes[i4].isPrimitive()) {
                                                throw new IllegalStateException("Primitive values are not supposed to be proxied: " + i4 + " of " + method2);
                                            }
                                            i10 = i9;
                                            cls3 = cls8;
                                            try {
                                                cls4 = cls9;
                                            } catch (ClassNotFoundException e6) {
                                                e = e6;
                                                cls4 = cls9;
                                                cls5 = cls10;
                                                z3 = z;
                                                objOf3 = zIsAnnotationPresent ? Dispatcher.ForDefaultValue.of(method2.getReturnType()) : Dispatcher.ForDefaultValue.of(method2.getReturnType());
                                                linkedHashMap.put(method2, objOf3);
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            } catch (NoSuchMethodException e7) {
                                                e = e7;
                                                cls4 = cls9;
                                                cls5 = cls10;
                                                z3 = z;
                                                objOf2 = zIsAnnotationPresent ? Dispatcher.ForDefaultValue.of(method2.getReturnType()) : Dispatcher.ForDefaultValue.of(method2.getReturnType());
                                                linkedHashMap.put(method2, objOf2);
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                cls4 = cls9;
                                                cls5 = cls10;
                                                z3 = z;
                                                linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            }
                                            try {
                                                cls5 = cls10;
                                                try {
                                                    if (parameterTypes[i4].isAssignableFrom(Class.forName(((Proxied) annotation).value(), false, this.classLoader))) {
                                                        throw new IllegalStateException("Cannot resolve to component type: " + ((Proxied) annotation).value() + " at " + i4 + " of " + method2);
                                                    }
                                                    sb = new StringBuilder();
                                                    i11 = i10;
                                                    while (true) {
                                                        i12 = i11 - 1;
                                                        if (i11 > 0) {
                                                            break;
                                                        }
                                                        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
                                                        i11 = i12;
                                                    }
                                                    sb.append('L');
                                                    sb.append(((Proxied) annotation).value());
                                                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                                                    parameterTypes[i4] = Class.forName(sb.toString(), false, this.classLoader);
                                                    break;
                                                } catch (ClassNotFoundException e8) {
                                                    e = e8;
                                                    z3 = z;
                                                    if (zIsAnnotationPresent) {
                                                    }
                                                    linkedHashMap.put(method2, objOf3);
                                                    i13 = i14 + 1;
                                                    methods = methodArr2;
                                                    length3 = i2;
                                                    str5 = str3;
                                                    str6 = str4;
                                                    cls8 = cls3;
                                                    cls9 = cls4;
                                                    cls10 = cls5;
                                                    i = 0;
                                                } catch (NoSuchMethodException e9) {
                                                    e = e9;
                                                    z3 = z;
                                                    if (zIsAnnotationPresent && !method2.isAnnotationPresent(Defaults.class)) {
                                                        objOf2 = new Dispatcher.ForUnresolvedMethod("Method not available on current VM: " + e.getMessage());
                                                    }
                                                    linkedHashMap.put(method2, objOf2);
                                                    i13 = i14 + 1;
                                                    methods = methodArr2;
                                                    length3 = i2;
                                                    str5 = str3;
                                                    str6 = str4;
                                                    cls8 = cls3;
                                                    cls9 = cls4;
                                                    cls10 = cls5;
                                                    i = 0;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    z3 = z;
                                                    linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                                    i13 = i14 + 1;
                                                    methods = methodArr2;
                                                    length3 = i2;
                                                    str5 = str3;
                                                    str6 = str4;
                                                    cls8 = cls3;
                                                    cls9 = cls4;
                                                    cls10 = cls5;
                                                    i = 0;
                                                }
                                            } catch (ClassNotFoundException e10) {
                                                e = e10;
                                                cls5 = cls10;
                                                z3 = z;
                                                if (zIsAnnotationPresent) {
                                                }
                                                linkedHashMap.put(method2, objOf3);
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            } catch (NoSuchMethodException e11) {
                                                e = e11;
                                                cls5 = cls10;
                                                z3 = z;
                                                if (zIsAnnotationPresent) {
                                                }
                                                linkedHashMap.put(method2, objOf2);
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                cls5 = cls10;
                                                z3 = z;
                                                linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                                i13 = i14 + 1;
                                                methods = methodArr2;
                                                length3 = i2;
                                                str5 = str3;
                                                str6 = str4;
                                                cls8 = cls3;
                                                cls9 = cls4;
                                                cls10 = cls5;
                                                i = 0;
                                            }
                                        } else {
                                            i6 = i8 + 1;
                                            length2 = i7;
                                        }
                                    }
                                    i4++;
                                    i3 = i152;
                                    parameterAnnotations = annotationArr22;
                                    cls8 = cls3;
                                    cls9 = cls4;
                                    cls10 = cls5;
                                }
                                cls3 = cls8;
                                cls4 = cls9;
                                cls5 = cls10;
                                if (method2.isAnnotationPresent(IsConstructor.class)) {
                                    constructor = cls11.getConstructor(parameterTypes);
                                    if (method2.getReturnType().isAssignableFrom(cls11)) {
                                        throw new IllegalStateException("Cannot assign " + constructor.getDeclaringClass().getName() + " to " + method2);
                                    }
                                    if ((constructor.getModifiers() & 1) != 0 || (cls11.getModifiers() & 1) == 0) {
                                        constructor.setAccessible(true);
                                        z3 = false;
                                    } else {
                                        z3 = z;
                                    }
                                    try {
                                        linkedHashMap.put(method2, new Dispatcher.ForConstructor(constructor));
                                    } catch (ClassNotFoundException e12) {
                                        e = e12;
                                        if (zIsAnnotationPresent) {
                                        }
                                        linkedHashMap.put(method2, objOf3);
                                    } catch (NoSuchMethodException e13) {
                                        e = e13;
                                        if (zIsAnnotationPresent) {
                                        }
                                        linkedHashMap.put(method2, objOf2);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                    }
                                } else {
                                    Proxied proxied2 = (Proxied) method2.getAnnotation(Proxied.class);
                                    method = cls11.getMethod(proxied2 == null ? method2.getName() : proxied2.value(), parameterTypes);
                                    if (method2.getReturnType().isAssignableFrom(method.getReturnType())) {
                                        throw new IllegalStateException("Cannot assign " + method.getReturnType().getName() + " to " + method2);
                                    }
                                    exceptionTypes = method.getExceptionTypes();
                                    length = exceptionTypes.length;
                                    i5 = 0;
                                    while (i5 < length) {
                                        cls6 = exceptionTypes[i5];
                                        if (RuntimeException.class.isAssignableFrom(cls6) && !Error.class.isAssignableFrom(cls6)) {
                                            Class<?>[] exceptionTypes2 = method2.getExceptionTypes();
                                            int length4 = exceptionTypes2.length;
                                            int i16 = 0;
                                            while (true) {
                                                if (i16 >= length4) {
                                                    throw new IllegalStateException("Resolved method for " + method2 + " throws undeclared checked exception " + cls6.getName());
                                                }
                                                clsArr = exceptionTypes;
                                                if (exceptionTypes2[i16].isAssignableFrom(cls6)) {
                                                    break;
                                                }
                                                i16++;
                                                exceptionTypes = clsArr;
                                            }
                                        }
                                        i5++;
                                        exceptionTypes = clsArr;
                                    }
                                    if ((method.getModifiers() & 1) != 0 || (method.getDeclaringClass().getModifiers() & 1) == 0) {
                                        method.setAccessible(true);
                                        z3 = false;
                                    } else {
                                        z3 = z;
                                    }
                                    if (Modifier.isStatic(method.getModifiers())) {
                                        if (method2.isAnnotationPresent(IsStatic.class)) {
                                            throw new IllegalStateException("Resolved method for " + method2 + " was expected to be static: " + method);
                                        }
                                        linkedHashMap.put(method2, new Dispatcher.ForStaticMethod(method));
                                    } else {
                                        if (!method2.isAnnotationPresent(IsStatic.class)) {
                                            throw new IllegalStateException("Resolved method for " + method2 + " was expected to be virtual: " + method);
                                        }
                                        linkedHashMap.put(method2, new Dispatcher.ForNonStaticMethod(method));
                                    }
                                }
                            } catch (ClassNotFoundException e14) {
                                e = e14;
                                str3 = str5;
                                str4 = str6;
                                i2 = length3;
                            } catch (NoSuchMethodException e15) {
                                e = e15;
                                str3 = str5;
                                str4 = str6;
                                i2 = length3;
                            } catch (Throwable th6) {
                                th = th6;
                                str3 = str5;
                                str4 = str6;
                                i2 = length3;
                            }
                            if (method2.isAnnotationPresent(IsConstructor.class)) {
                                str3 = str5;
                                str4 = str6;
                                i2 = length3;
                                z = z3;
                                i3 = 0;
                            } else {
                                i2 = length3;
                                try {
                                    if (parameterTypes.length == 0) {
                                        throw new IllegalStateException("Expected self type: " + method2);
                                    }
                                    if (!parameterTypes[i].isAssignableFrom(cls11)) {
                                        throw new IllegalStateException("Cannot assign self type: " + cls11 + " on " + method2);
                                    }
                                    int length5 = parameterTypes.length - 1;
                                    z = z3;
                                    try {
                                        Class<?>[] clsArr2 = new Class[length5];
                                        str3 = str5;
                                        str4 = str6;
                                        try {
                                            System.arraycopy(parameterTypes, 1, clsArr2, i, length5);
                                            parameterTypes = clsArr2;
                                            i3 = 1;
                                        } catch (ClassNotFoundException e16) {
                                            e = e16;
                                            cls3 = cls8;
                                            cls4 = cls9;
                                            cls5 = cls10;
                                            z3 = z;
                                            if (zIsAnnotationPresent) {
                                            }
                                            linkedHashMap.put(method2, objOf3);
                                            i13 = i14 + 1;
                                            methods = methodArr2;
                                            length3 = i2;
                                            str5 = str3;
                                            str6 = str4;
                                            cls8 = cls3;
                                            cls9 = cls4;
                                            cls10 = cls5;
                                            i = 0;
                                        } catch (NoSuchMethodException e17) {
                                            e = e17;
                                            cls3 = cls8;
                                            cls4 = cls9;
                                            cls5 = cls10;
                                            z3 = z;
                                            if (zIsAnnotationPresent) {
                                            }
                                            linkedHashMap.put(method2, objOf2);
                                            i13 = i14 + 1;
                                            methods = methodArr2;
                                            length3 = i2;
                                            str5 = str3;
                                            str6 = str4;
                                            cls8 = cls3;
                                            cls9 = cls4;
                                            cls10 = cls5;
                                            i = 0;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            cls3 = cls8;
                                            cls4 = cls9;
                                            cls5 = cls10;
                                            z3 = z;
                                            linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                            i13 = i14 + 1;
                                            methods = methodArr2;
                                            length3 = i2;
                                            str5 = str3;
                                            str6 = str4;
                                            cls8 = cls3;
                                            cls9 = cls4;
                                            cls10 = cls5;
                                            i = 0;
                                        }
                                    } catch (ClassNotFoundException e18) {
                                        e = e18;
                                        str3 = str5;
                                        str4 = str6;
                                    } catch (NoSuchMethodException e19) {
                                        e = e19;
                                        str3 = str5;
                                        str4 = str6;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        str3 = str5;
                                        str4 = str6;
                                    }
                                } catch (ClassNotFoundException e20) {
                                    e = e20;
                                    str3 = str5;
                                    str4 = str6;
                                    cls3 = cls8;
                                    cls4 = cls9;
                                    cls5 = cls10;
                                } catch (NoSuchMethodException e21) {
                                    e = e21;
                                    str3 = str5;
                                    str4 = str6;
                                    cls3 = cls8;
                                    cls4 = cls9;
                                    cls5 = cls10;
                                    if (zIsAnnotationPresent) {
                                    }
                                    linkedHashMap.put(method2, objOf2);
                                    i13 = i14 + 1;
                                    methods = methodArr2;
                                    length3 = i2;
                                    str5 = str3;
                                    str6 = str4;
                                    cls8 = cls3;
                                    cls9 = cls4;
                                    cls10 = cls5;
                                    i = 0;
                                } catch (Throwable th9) {
                                    th = th9;
                                    str3 = str5;
                                    str4 = str6;
                                    cls3 = cls8;
                                    cls4 = cls9;
                                    cls5 = cls10;
                                    linkedHashMap.put(method2, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + th.getMessage()));
                                    i13 = i14 + 1;
                                    methods = methodArr2;
                                    length3 = i2;
                                    str5 = str3;
                                    str6 = str4;
                                    cls8 = cls3;
                                    cls9 = cls4;
                                    cls10 = cls5;
                                    i = 0;
                                }
                                if (zIsAnnotationPresent && !method2.isAnnotationPresent(Defaults.class)) {
                                    objOf3 = new Dispatcher.ForUnresolvedMethod("Class not available on current VM: " + e.getMessage());
                                }
                                linkedHashMap.put(method2, objOf3);
                            }
                        }
                    }
                    i13 = i14 + 1;
                    methods = methodArr2;
                    length3 = i2;
                    str5 = str3;
                    str6 = str4;
                    cls8 = cls3;
                    cls9 = cls4;
                    cls10 = cls5;
                    i = 0;
                }
                str3 = str5;
                str4 = str6;
                cls3 = cls8;
                cls4 = cls9;
                cls5 = cls10;
                i2 = length3;
                i13 = i14 + 1;
                methods = methodArr2;
                length3 = i2;
                str5 = str3;
                str6 = str4;
                cls8 = cls3;
                cls9 = cls4;
                cls10 = cls5;
                i = 0;
            }
            return z3 ? (T) DynamicClassLoader.proxy(this.proxy, linkedHashMap) : (T) Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[]{this.proxy}, new ProxiedInvocationHandler(cls11.getName(), linkedHashMap));
        } catch (ClassNotFoundException e22) {
            String str7 = "Instance check requires a single regular-typed argument: ";
            String str8 = "Instance check requires a boolean return type: ";
            Class<?> cls12 = cls8;
            Class<Instance> cls13 = cls9;
            Class<?> cls14 = cls10;
            Method[] methods2 = this.generate ? (Method[]) GraalImageCode.getCurrent().sorted(this.proxy.getMethods(), MethodComparator.INSTANCE) : this.proxy.getMethods();
            int length6 = methods2.length;
            int i17 = 0;
            while (i17 < length6) {
                Method method3 = methods2[i17];
                Class<?> cls15 = cls14;
                if (method3.getDeclaringClass() == cls15) {
                    methodArr = methods2;
                    str = str7;
                    str2 = str8;
                    cls2 = cls12;
                    cls = cls13;
                } else {
                    cls = cls13;
                    if (!method3.isAnnotationPresent(cls)) {
                        str = str7;
                        str2 = str8;
                        cls2 = cls12;
                        if (zIsAnnotationPresent || method3.isAnnotationPresent(Defaults.class)) {
                            methodArr = methods2;
                            objOf = Dispatcher.ForDefaultValue.of(method3.getReturnType());
                        } else {
                            methodArr = methods2;
                            objOf = new Dispatcher.ForUnresolvedMethod("Type not available on current VM: " + e22.getMessage());
                        }
                        linkedHashMap.put(method3, objOf);
                    } else {
                        if (method3.getParameterTypes().length != 1 || method3.getParameterTypes()[0].isPrimitive() || method3.getParameterTypes()[0].isArray()) {
                            throw new IllegalStateException(str7 + method3);
                        }
                        cls2 = cls12;
                        if (method3.getReturnType() != cls2) {
                            throw new IllegalStateException(str8 + method3);
                        }
                        linkedHashMap.put(method3, Dispatcher.ForDefaultValue.BOOLEAN);
                        methodArr = methods2;
                        str = str7;
                        str2 = str8;
                    }
                }
                i17++;
                cls13 = cls;
                cls14 = cls15;
                str8 = str2;
                cls12 = cls2;
                str7 = str;
                methods2 = methodArr;
            }
            return this.generate ? (T) DynamicClassLoader.proxy(this.proxy, linkedHashMap) : (T) Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[]{this.proxy}, new ProxiedInvocationHandler(strValue, linkedHashMap));
        }
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader) {
        return of(cls, classLoader, GENERATE);
    }

    public static <T> PrivilegedAction<T> of(Class<T> cls, @MaybeNull ClassLoader classLoader, boolean z) {
        if (cls.isInterface()) {
            if (!cls.isAnnotationPresent(Proxied.class)) {
                throw new IllegalArgumentException("Expected " + cls.getName() + " to be annotated with " + Proxied.class.getName());
            }
            if (!((Proxied) cls.getAnnotation(Proxied.class)).value().startsWith("java.security.")) {
                return new JavaDispatcher(cls, classLoader, z);
            }
            throw new IllegalArgumentException("Classes related to Java security cannot be proxied: ".concat(cls.getName()));
        }
        throw new IllegalArgumentException(bjs.l(cls, "Expected an interface instead of "));
    }
}
