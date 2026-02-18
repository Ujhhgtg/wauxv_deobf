package net.bytebuddy.agent.builder;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Iterator;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ResettableClassFileTransformer extends ClassFileTransformer {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractBase implements ResettableClassFileTransformer {
        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy) {
            return reset(instrumentation, redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator) {
            return reset(instrumentation, redefinitionStrategy, batchAllocator, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, batchAllocator, AgentBuilder.RedefinitionStrategy.Listener.NoOp.INSTANCE);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, redefinitionStrategy, discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator.ForTotal.INSTANCE, listener);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass.INSTANCE, batchAllocator, listener);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return reset(instrumentation, this, redefinitionStrategy, discoveryStrategy, batchAllocator, listener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Substitutable extends ResettableClassFileTransformer {
        void substitute(ResettableClassFileTransformer resettableClassFileTransformer);

        ResettableClassFileTransformer unwrap();
    }

    Iterator<AgentBuilder.Transformer> iterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.Listener listener);

    boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class WithDelegation extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        protected final ResettableClassFileTransformer classFileTransformer;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Callback<T> {
            void onAfterTransform(@MaybeNull T t, @MaybeNull JavaModule javaModule, @MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr);

            @MaybeNull
            T onBeforeTransform(@MaybeNull JavaModule javaModule, @MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Substitutable extends AbstractBase implements Substitutable {
            private static final Factory DISPATCHER = (Factory) WithDelegation.doPrivileged(Factory.CreationAction.INSTANCE);
            protected volatile ResettableClassFileTransformer classFileTransformer;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Factory {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum CreationAction implements PrivilegedAction<Factory> {
                    INSTANCE;

                    @Override // java.security.PrivilegedAction
                    public Factory run() {
                        try {
                            DynamicType.Builder builderName = new ByteBuddy().with(TypeValidation.DISABLED).subclass(Substitutable.class, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).name(Substitutable.class.getName().concat("$ByteBuddy$ModuleSupport"));
                            ElementMatcher.Junction junctionNamed = ElementMatchers.named("transform");
                            JavaType javaType = JavaType.MODULE;
                            return new ForJava9CapableVm(builderName.method(junctionNamed.and(ElementMatchers.takesArgument(0, javaType.load()))).intercept(MethodCall.invoke(ClassFileTransformer.class.getMethod("transform", javaType.load(), ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class)).onField("classFileTransformer").withAllArguments()).make().load(Substitutable.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(Substitutable.class.getProtectionDomain())).getLoaded().getConstructor(ResettableClassFileTransformer.class));
                        } catch (Exception unused) {
                            return ForLegacyVm.INSTANCE;
                        }
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava9CapableVm implements Factory {
                    private final Constructor<? extends Substitutable> substitutable;

                    public ForJava9CapableVm(Constructor<? extends Substitutable> constructor) {
                        this.substitutable = constructor;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.substitutable.equals(((ForJava9CapableVm) obj).substitutable);
                    }

                    public int hashCode() {
                        return this.substitutable.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation.Substitutable.Factory
                    public Substitutable make(ResettableClassFileTransformer resettableClassFileTransformer) {
                        try {
                            return this.substitutable.newInstance(resettableClassFileTransformer);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException("Cannot access " + this.substitutable, e);
                        } catch (InstantiationException e2) {
                            throw new IllegalStateException("Cannot instantiate " + this.substitutable.getDeclaringClass(), e2);
                        } catch (InvocationTargetException e3) {
                            throw new IllegalStateException("Cannot invoke " + this.substitutable, e3.getTargetException());
                        }
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum ForLegacyVm implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation.Substitutable.Factory
                    public Substitutable make(ResettableClassFileTransformer resettableClassFileTransformer) {
                        return new Substitutable(resettableClassFileTransformer);
                    }
                }

                Substitutable make(ResettableClassFileTransformer resettableClassFileTransformer);
            }

            public Substitutable(ResettableClassFileTransformer resettableClassFileTransformer) {
                this.classFileTransformer = resettableClassFileTransformer;
            }

            public static Substitutable of(ResettableClassFileTransformer resettableClassFileTransformer) {
                return DISPATCHER.make(resettableClassFileTransformer);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((Substitutable) obj).classFileTransformer);
            }

            public int hashCode() {
                return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
            public Iterator<AgentBuilder.Transformer> iterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain) {
                return this.classFileTransformer.iterator(typeDescription, classLoader, javaModule, cls, protectionDomain);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
            public boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
                return this.classFileTransformer.reset(instrumentation, resettableClassFileTransformer, redefinitionStrategy, discoveryStrategy, batchAllocator, listener);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.Substitutable
            public void substitute(ResettableClassFileTransformer resettableClassFileTransformer) {
                while (resettableClassFileTransformer instanceof Substitutable) {
                    resettableClassFileTransformer = ((Substitutable) resettableClassFileTransformer).unwrap();
                }
                this.classFileTransformer = resettableClassFileTransformer;
            }

            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                return this.classFileTransformer.transform(classLoader, str, cls, protectionDomain, bArr);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.Substitutable
            public ResettableClassFileTransformer unwrap() {
                return this.classFileTransformer;
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

        public WithDelegation(ResettableClassFileTransformer resettableClassFileTransformer) {
            this.classFileTransformer = resettableClassFileTransformer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @AccessControllerPlugin.Enhance
        public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ResettableClassFileTransformer of(ResettableClassFileTransformer resettableClassFileTransformer, Callback<?> callback) {
            return WithCallback.DISPATCHER.make(resettableClassFileTransformer, callback);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((WithDelegation) obj).classFileTransformer);
        }

        public int hashCode() {
            return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public Iterator<AgentBuilder.Transformer> iterator(TypeDescription typeDescription, @MaybeNull ClassLoader classLoader, @MaybeNull JavaModule javaModule, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain) {
            return this.classFileTransformer.iterator(typeDescription, classLoader, javaModule, cls, protectionDomain);
        }

        @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer
        public boolean reset(Instrumentation instrumentation, ResettableClassFileTransformer resettableClassFileTransformer, AgentBuilder.RedefinitionStrategy redefinitionStrategy, AgentBuilder.RedefinitionStrategy.DiscoveryStrategy discoveryStrategy, AgentBuilder.RedefinitionStrategy.BatchAllocator batchAllocator, AgentBuilder.RedefinitionStrategy.Listener listener) {
            return this.classFileTransformer.reset(instrumentation, resettableClassFileTransformer, redefinitionStrategy, discoveryStrategy, batchAllocator, listener);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithCallback<T> extends WithDelegation {
            private static final Factory DISPATCHER = (Factory) WithDelegation.doPrivileged(Factory.CreationAction.INSTANCE);
            private final Callback<T> callback;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface Factory {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum CreationAction implements PrivilegedAction<Factory> {
                    INSTANCE;

                    @Override // java.security.PrivilegedAction
                    public Factory run() {
                        try {
                            DynamicType.Builder<T> builderName = new ByteBuddy().with(TypeValidation.DISABLED).subclass((Class) WithCallback.class, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).name(WithCallback.class.getName().concat("$ByteBuddy$ModuleSupport"));
                            ElementMatcher.Junction junctionNamed = ElementMatchers.named("transform");
                            JavaType javaType = JavaType.MODULE;
                            return new ForJava9CapableVm(builderName.method(junctionNamed.and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{javaType.load(), ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class}))).intercept(MethodCall.invoke(WithCallback.class.getDeclaredMethod("transform", Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class)).withAllArguments()).method(ElementMatchers.named("doTransform").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{Object.class, ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class}))).intercept(MethodCall.invoke(ClassFileTransformer.class.getMethod("transform", javaType.load(), ClassLoader.class, String.class, Class.class, ProtectionDomain.class, byte[].class)).onField("classFileTransformer").withAllArguments().withAssigner(Assigner.DEFAULT, Assigner.Typing.DYNAMIC)).make().load(WithCallback.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER_PERSISTENT.with(WithCallback.class.getProtectionDomain())).getLoaded().getConstructor(ResettableClassFileTransformer.class, Callback.class));
                        } catch (Exception unused) {
                            return ForLegacyVm.INSTANCE;
                        }
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJava9CapableVm implements Factory {
                    private final Constructor<? extends ResettableClassFileTransformer> withCallback;

                    public ForJava9CapableVm(Constructor<? extends ResettableClassFileTransformer> constructor) {
                        this.withCallback = constructor;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.withCallback.equals(((ForJava9CapableVm) obj).withCallback);
                    }

                    public int hashCode() {
                        return this.withCallback.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation.WithCallback.Factory
                    public ResettableClassFileTransformer make(ResettableClassFileTransformer resettableClassFileTransformer, Callback<?> callback) {
                        try {
                            return this.withCallback.newInstance(resettableClassFileTransformer, callback);
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException("Cannot access " + this.withCallback, e);
                        } catch (InstantiationException e2) {
                            throw new IllegalStateException("Cannot instantiate " + this.withCallback.getDeclaringClass(), e2);
                        } catch (InvocationTargetException e3) {
                            throw new IllegalStateException("Cannot invoke " + this.withCallback, e3.getTargetException());
                        }
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum ForLegacyVm implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation.WithCallback.Factory
                    public ResettableClassFileTransformer make(ResettableClassFileTransformer resettableClassFileTransformer, Callback<?> callback) {
                        return new WithCallback(resettableClassFileTransformer, callback);
                    }
                }

                ResettableClassFileTransformer make(ResettableClassFileTransformer resettableClassFileTransformer, Callback<?> callback);
            }

            public WithCallback(ResettableClassFileTransformer resettableClassFileTransformer, Callback<T> callback) {
                super(resettableClassFileTransformer);
                this.callback = callback;
            }

            @MaybeNull
            public byte[] doTransform(Object obj, @MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                throw new UnsupportedOperationException();
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.callback.equals(((WithCallback) obj).callback);
            }

            @Override // net.bytebuddy.agent.builder.ResettableClassFileTransformer.WithDelegation
            public int hashCode() {
                return this.callback.hashCode() + (super.hashCode() * 31);
            }

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) throws Throwable {
                T tOnBeforeTransform = this.callback.onBeforeTransform(null, classLoader, str, cls, protectionDomain, bArr);
                Class<?> cls2 = cls;
                ProtectionDomain protectionDomain2 = protectionDomain;
                byte[] bArr2 = bArr;
                ClassLoader classLoader2 = classLoader;
                String str2 = str;
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArrTransform = this.classFileTransformer.transform(classLoader2, str2, cls2, protectionDomain2, bArr2);
                    this.callback.onAfterTransform(tOnBeforeTransform, null, classLoader2, str2, cls2, protectionDomain2, bArr2);
                    return bArrTransform;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = str2;
                    cls2 = cls2;
                    protectionDomain2 = protectionDomain2;
                    bArr2 = bArr2;
                    classLoader2 = classLoader2;
                    Throwable th3 = th;
                    this.callback.onAfterTransform(tOnBeforeTransform, null, classLoader2, str2, cls2, protectionDomain2, bArr2);
                    throw th3;
                }
            }

            @MaybeNull
            public byte[] transform(Object obj, @MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                JavaModule javaModuleOf = JavaModule.of(obj);
                T tOnBeforeTransform = this.callback.onBeforeTransform(javaModuleOf, classLoader, str, cls, protectionDomain, bArr);
                try {
                    return doTransform(obj, classLoader, str, cls, protectionDomain, bArr);
                } finally {
                    this.callback.onAfterTransform(tOnBeforeTransform, javaModuleOf, classLoader, str, cls, protectionDomain, bArr);
                }
            }
        }
    }
}
