package net.bytebuddy.dynamic.loading;

import java.io.File;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ClassReloadingStrategy implements ClassLoadingStrategy<ClassLoader> {
    private static final boolean ACCESS_CONTROLLER;
    protected static final Dispatcher DISPATCHER;
    private final BootstrapInjection bootstrapInjection;
    private final Instrumentation instrumentation;
    private final Map<String, Class<?>> preregisteredTypes;
    private final Strategy strategy;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface BootstrapInjection {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Disabled implements BootstrapInjection {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.BootstrapInjection
            public ClassInjector make(Instrumentation instrumentation) {
                throw new IllegalStateException("Bootstrap injection is not enabled");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Enabled implements BootstrapInjection {
            private final File folder;

            public Enabled(File file) {
                this.folder = file;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.folder.equals(((Enabled) obj).folder);
            }

            public int hashCode() {
                return this.folder.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.BootstrapInjection
            public ClassInjector make(Instrumentation instrumentation) {
                return ClassInjector.UsingInstrumentation.of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, instrumentation);
            }
        }

        ClassInjector make(Instrumentation instrumentation);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
    public interface Dispatcher {
        @JavaDispatcher.Proxied("addTransformer")
        void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z);

        @JavaDispatcher.Proxied("isModifiableClass")
        boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

        @JavaDispatcher.Proxied("isRetransformClassesSupported")
        boolean isRetransformClassesSupported(Instrumentation instrumentation);

        @JavaDispatcher.Proxied("retransformClasses")
        void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Strategy {
        REDEFINITION(true) { // from class: net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy.1
            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) {
                instrumentation.redefineClasses((ClassDefinition[]) map.values().toArray(new ClassDefinition[0]));
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) {
                HashMap map = new HashMap(list.size());
                for (Class<?> cls : list) {
                    map.put(cls, new ClassDefinition(cls, classFileLocator.locate(TypeDescription.ForLoadedType.getName(cls)).resolve()));
                }
                apply(instrumentation, map);
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public Strategy validate(Instrumentation instrumentation) {
                if (instrumentation.isRedefineClassesSupported()) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support redefinition: " + instrumentation);
            }
        },
        RETRANSFORMATION(0 == true ? 1 : 0) { // from class: net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy.2
            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) {
                ClassRedefinitionTransformer classRedefinitionTransformer = new ClassRedefinitionTransformer(map);
                synchronized (this) {
                    Dispatcher dispatcher = ClassReloadingStrategy.DISPATCHER;
                    dispatcher.addTransformer(instrumentation, classRedefinitionTransformer, true);
                    try {
                        dispatcher.retransformClasses(instrumentation, (Class[]) map.keySet().toArray(new Class[0]));
                        instrumentation.removeTransformer(classRedefinitionTransformer);
                    } catch (Throwable th) {
                        instrumentation.removeTransformer(classRedefinitionTransformer);
                        throw th;
                    }
                }
                classRedefinitionTransformer.assertTransformation();
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) {
                for (Class<?> cls : list) {
                    if (!ClassReloadingStrategy.DISPATCHER.isModifiableClass(instrumentation, cls)) {
                        throw new IllegalArgumentException(bjs.l(cls, "Cannot modify type: "));
                    }
                }
                Dispatcher dispatcher = ClassReloadingStrategy.DISPATCHER;
                dispatcher.addTransformer(instrumentation, ClassResettingTransformer.INSTANCE, true);
                try {
                    dispatcher.retransformClasses(instrumentation, (Class[]) list.toArray(new Class[0]));
                } finally {
                    instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
                }
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public Strategy validate(Instrumentation instrumentation) {
                if (ClassReloadingStrategy.DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support retransformation: " + instrumentation);
            }
        };


        @AlwaysNull
        private static final byte[] NO_REDEFINITION = null;
        private static final boolean REDEFINE_CLASSES = true;
        private final boolean redefinition;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class ClassRedefinitionTransformer implements ClassFileTransformer {
            private final Map<Class<?>, ClassDefinition> redefinedClasses;

            public ClassRedefinitionTransformer(Map<Class<?>, ClassDefinition> map) {
                this.redefinedClasses = map;
            }

            public void assertTransformation() {
                if (this.redefinedClasses.isEmpty()) {
                    return;
                }
                throw new IllegalStateException("Could not transform: " + this.redefinedClasses.keySet());
            }

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                ClassDefinition classDefinitionRemove;
                if (str != null && (classDefinitionRemove = this.redefinedClasses.remove(cls)) != null) {
                    return classDefinitionRemove.getDefinitionClassFile();
                }
                return Strategy.NO_REDEFINITION;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ClassResettingTransformer implements ClassFileTransformer {
            INSTANCE;

            @MaybeNull
            public byte[] transform(@MaybeNull ClassLoader classLoader, @MaybeNull String str, @MaybeNull Class<?> cls, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
                return Strategy.NO_REDEFINITION;
            }
        }

        public abstract void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map);

        public boolean isRedefinition() {
            return this.redefinition;
        }

        public abstract void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list);

        public abstract Strategy validate(Instrumentation instrumentation);

        Strategy(boolean z) {
            this.redefinition = z;
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
        DISPATCHER = (Dispatcher) doPrivileged(JavaDispatcher.of(Dispatcher.class));
    }

    public ClassReloadingStrategy(Instrumentation instrumentation, Strategy strategy) {
        this(instrumentation, strategy, BootstrapInjection.Disabled.INSTANCE, Collections.EMPTY_MAP);
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassReloadingStrategy fromInstalledAgent() {
        return of(resolveByteBuddyAgentInstrumentation());
    }

    public static ClassReloadingStrategy of(Instrumentation instrumentation) {
        if (DISPATCHER.isRetransformClassesSupported(instrumentation)) {
            return new ClassReloadingStrategy(instrumentation, Strategy.RETRANSFORMATION);
        }
        if (instrumentation.isRedefineClassesSupported()) {
            return new ClassReloadingStrategy(instrumentation, Strategy.REDEFINITION);
        }
        throw new IllegalArgumentException("Instrumentation does not support reloading of classes: " + instrumentation);
    }

    private static Instrumentation resolveByteBuddyAgentInstrumentation() {
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass("net.bytebuddy.agent.Installer");
            JavaModule javaModuleOfType = JavaModule.ofType(AgentBuilder.class);
            JavaModule javaModuleOfType2 = JavaModule.ofType(clsLoadClass);
            if (javaModuleOfType != null && !javaModuleOfType.canRead(javaModuleOfType2)) {
                Class<?> cls = Class.forName("java.lang.Module");
                cls.getMethod("addReads", cls).invoke(javaModuleOfType.unwrap(), javaModuleOfType2.unwrap());
            }
            return (Instrumentation) clsLoadClass.getMethod("getInstrumentation", null).invoke(null, null);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", e2);
        }
    }

    public ClassReloadingStrategy enableBootstrapInjection(File file) {
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, new BootstrapInjection.Enabled(file), this.preregisteredTypes);
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassReloadingStrategy classReloadingStrategy = (ClassReloadingStrategy) obj;
        return this.strategy.equals(classReloadingStrategy.strategy) && this.instrumentation.equals(classReloadingStrategy.instrumentation) && this.bootstrapInjection.equals(classReloadingStrategy.bootstrapInjection) && this.preregisteredTypes.equals(classReloadingStrategy.preregisteredTypes);
    }

    public int hashCode() {
        return this.preregisteredTypes.hashCode() + ((this.bootstrapInjection.hashCode() + ((this.strategy.hashCode() + ((this.instrumentation.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31);
    }

    @Override // net.bytebuddy.dynamic.loading.ClassLoadingStrategy
    public Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        HashMap map2 = new HashMap(this.preregisteredTypes);
        for (Class cls : this.instrumentation.getInitiatedClasses(classLoader)) {
            map2.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        HashMap map3 = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
            Class cls2 = (Class) map2.get(entry.getKey().getName());
            if (cls2 != null) {
                concurrentHashMap.put(cls2, new ClassDefinition(cls2, entry.getValue()));
                map3.put(entry.getKey(), cls2);
            } else {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            this.strategy.apply(this.instrumentation, concurrentHashMap);
            if (!linkedHashMap.isEmpty()) {
                map3.putAll((classLoader == null ? this.bootstrapInjection.make(this.instrumentation) : new ClassInjector.UsingReflection(classLoader)).inject(linkedHashMap));
            }
            return map3;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Could not locate classes for redefinition", e);
        } catch (UnmodifiableClassException e2) {
            throw new IllegalStateException("Cannot redefine specified class", e2);
        }
    }

    public ClassReloadingStrategy preregistered(Class<?>... clsArr) {
        HashMap map = new HashMap(this.preregisteredTypes);
        for (Class<?> cls : clsArr) {
            map.put(TypeDescription.ForLoadedType.getName(cls), cls);
        }
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, this.bootstrapInjection, map);
    }

    public ClassReloadingStrategy reset(Class<?>... clsArr) {
        return clsArr.length == 0 ? this : reset(ClassFileLocator.ForClassLoader.of(clsArr[0].getClassLoader()), clsArr);
    }

    public static ClassReloadingStrategy fromInstalledAgent(Strategy strategy) {
        return new ClassReloadingStrategy(resolveByteBuddyAgentInstrumentation(), strategy);
    }

    public ClassReloadingStrategy reset(ClassFileLocator classFileLocator, Class<?>... clsArr) {
        if (clsArr.length <= 0) {
            return this;
        }
        try {
            this.strategy.reset(this.instrumentation, classFileLocator, Arrays.asList(clsArr));
            return this;
        } catch (UnmodifiableClassException e) {
            throw new IllegalStateException("Cannot reset types " + Arrays.toString(clsArr), e);
        } catch (ClassNotFoundException e2) {
            throw new IllegalArgumentException("Cannot locate types " + Arrays.toString(clsArr), e2);
        }
    }

    public ClassReloadingStrategy(Instrumentation instrumentation, Strategy strategy, BootstrapInjection bootstrapInjection, Map<String, Class<?>> map) {
        this.instrumentation = instrumentation;
        this.strategy = strategy.validate(instrumentation);
        this.bootstrapInjection = bootstrapInjection;
        this.preregisteredTypes = map;
    }
}
