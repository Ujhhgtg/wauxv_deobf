package net.bytebuddy.dynamic.loading;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLStreamHandler;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.GraalImageCode;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ByteArrayClassLoader extends InjectionClassLoader {
    private static final boolean ACCESS_CONTROLLER;
    private static final int FROM_BEGINNING = 0;

    @AlwaysNull
    private static final URL NO_URL;
    private static final PackageLookupStrategy PACKAGE_LOOKUP_STRATEGY;
    protected static final SynchronizationStrategy.Initializable SYNCHRONIZATION_STRATEGY;
    public static final String URL_SCHEMA = "bytebuddy";

    @MaybeNull
    protected final Object accessControlContext;
    protected final ClassFilePostProcessor classFilePostProcessor;
    protected final PackageDefinitionStrategy packageDefinitionStrategy;
    protected final PersistenceHandler persistenceHandler;

    @MaybeNull
    protected final ProtectionDomain protectionDomain;
    protected final ConcurrentMap<String, byte[]> typeDefinitions;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ChildFirst extends ByteArrayClassLoader {
        private static final String CLASS_FILE_SUFFIX = ".class";

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class PrependingEnumeration implements Enumeration<URL> {
            private final Enumeration<URL> enumeration;

            @MaybeNull
            private URL nextElement;

            public PrependingEnumeration(URL url, Enumeration<URL> enumeration) {
                this.nextElement = url;
                this.enumeration = enumeration;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.nextElement != null && this.enumeration.hasMoreElements();
            }

            @Override // java.util.Enumeration
            public URL nextElement() {
                if (this.nextElement == null || !this.enumeration.hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                try {
                    return this.nextElement;
                } finally {
                    this.nextElement = this.enumeration.nextElement();
                }
            }
        }

        static {
            doRegisterAsParallelCapable();
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
            super(classLoader, map);
        }

        private static void doRegisterAsParallelCapable() {
            try {
                Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, null);
            } catch (Throwable unused) {
            }
        }

        private boolean isShadowed(String str) {
            boolean z = false;
            if (this.persistenceHandler.isManifest() || !str.endsWith(".class")) {
                return false;
            }
            String strSubstring = str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).substring(0, str.length() - 6);
            synchronized (ByteArrayClassLoader.SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, strSubstring)) {
                try {
                    if (this.typeDefinitions.containsKey(strSubstring)) {
                        return true;
                    }
                    Class<?> clsFindLoadedClass = findLoadedClass(strSubstring);
                    if (clsFindLoadedClass != null && clsFindLoadedClass.getClassLoader() == this) {
                        z = true;
                    }
                    return z;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
            return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String str) {
            URL url = this.persistenceHandler.url(str, this.typeDefinitions);
            return (url != null || isShadowed(str)) ? url : super.getResource(str);
        }

        @Override // java.lang.ClassLoader
        public Enumeration<URL> getResources(String str) {
            URL url = this.persistenceHandler.url(str, this.typeDefinitions);
            return url == null ? super.getResources(str) : new PrependingEnumeration(url, super.getResources(str));
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            synchronized (ByteArrayClassLoader.SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, str)) {
                Class<?> clsFindLoadedClass = findLoadedClass(str);
                if (clsFindLoadedClass != null) {
                    return clsFindLoadedClass;
                }
                try {
                    Class<?> clsFindClass = findClass(str);
                    if (z) {
                        resolveClass(clsFindClass);
                    }
                    return clsFindClass;
                } catch (ClassNotFoundException unused) {
                    return super.loadClass(str, z);
                }
            }
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map) {
            super(classLoader, z, map);
        }

        public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, boolean z, boolean z2) {
            return load(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassLoaderDecorator.Factory.NoOp.INSTANCE, z, z2);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, map, persistenceHandler);
        }

        public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassLoaderDecorator.Factory factory, boolean z, boolean z2) {
            HashMap map2 = new HashMap();
            for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                map2.put(entry.getKey().getName(), entry.getValue());
            }
            ClassLoaderDecorator classLoaderDecoratorMake = factory.make(new ChildFirst(classLoader, z2, map2, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE), map2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (TypeDescription typeDescription : map.keySet()) {
                if (!classLoaderDecoratorMake.isSkipped(typeDescription)) {
                    ClassLoader classLoaderApply = classLoaderDecoratorMake.apply(typeDescription);
                    try {
                        Class<?> cls = Class.forName(typeDescription.getName(), false, classLoaderApply);
                        if (!GraalImageCode.getCurrent().isNativeImageExecution() && z && cls.getClassLoader() != classLoaderApply) {
                            throw new IllegalStateException("Class already loaded: " + cls);
                        }
                        linkedHashMap.put(typeDescription, cls);
                    } catch (ClassNotFoundException e) {
                        throw new IllegalStateException(StaticHelpers6.concat("Cannot load class ", typeDescription), e);
                    }
                }
            }
            return linkedHashMap;
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
            super(classLoader, z, map, persistenceHandler);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
            super(classLoader, z, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }

        public ChildFirst(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
            super(classLoader, z, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
    public class ClassDefinitionAction implements PrivilegedAction<Class<?>> {
        private final byte[] binaryRepresentation;
        private final String name;

        public ClassDefinitionAction(String str, byte[] bArr) {
            this.name = str;
            this.binaryRepresentation = bArr;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassDefinitionAction classDefinitionAction = (ClassDefinitionAction) obj;
            return this.name.equals(classDefinitionAction.name) && Arrays.equals(this.binaryRepresentation, classDefinitionAction.binaryRepresentation) && ByteArrayClassLoader.this.equals(ByteArrayClassLoader.this);
        }

        public int hashCode() {
            return ByteArrayClassLoader.this.hashCode() + ((Arrays.hashCode(this.binaryRepresentation) + bjs.e(this.name, getClass().hashCode() * 31, 31)) * 31);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public Class<?> run() {
            int iLastIndexOf = this.name.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                String strSubstring = this.name.substring(0, iLastIndexOf);
                ByteArrayClassLoader byteArrayClassLoader = ByteArrayClassLoader.this;
                PackageDefinitionStrategy.Definition definitionDefine = byteArrayClassLoader.packageDefinitionStrategy.define(byteArrayClassLoader, strSubstring, this.name);
                if (definitionDefine.isDefined()) {
                    Package packageApply = ByteArrayClassLoader.PACKAGE_LOOKUP_STRATEGY.apply(ByteArrayClassLoader.this, strSubstring);
                    if (packageApply == null) {
                        ByteArrayClassLoader.this.definePackage(strSubstring, definitionDefine.getSpecificationTitle(), definitionDefine.getSpecificationVersion(), definitionDefine.getSpecificationVendor(), definitionDefine.getImplementationTitle(), definitionDefine.getImplementationVersion(), definitionDefine.getImplementationVendor(), definitionDefine.getSealBase());
                    } else if (!definitionDefine.isCompatibleTo(packageApply)) {
                        throw new SecurityException(yg.k("Sealing violation for package ", strSubstring));
                    }
                }
            }
            ByteArrayClassLoader byteArrayClassLoader2 = ByteArrayClassLoader.this;
            String str = this.name;
            byte[] bArr = this.binaryRepresentation;
            return byteArrayClassLoader2.defineClass(str, bArr, 0, bArr.length, byteArrayClassLoader2.protectionDomain);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum EmptyEnumeration implements Enumeration<URL> {
        INSTANCE;

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public URL nextElement() {
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface PackageLookupStrategy {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum CreationAction implements PrivilegedAction<PackageLookupStrategy> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            public PackageLookupStrategy run() {
                if (!JavaModule.isSupported()) {
                    return ForLegacyVm.INSTANCE;
                }
                try {
                    return new ForJava9CapableVm(ClassLoader.class.getMethod("getDefinedPackage", String.class));
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava9CapableVm implements PackageLookupStrategy {
            private final Method getDefinedPackage;

            public ForJava9CapableVm(Method method) {
                this.getDefinedPackage = method;
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PackageLookupStrategy
            @MaybeNull
            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return (Package) this.getDefinedPackage.invoke(byteArrayClassLoader, str);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2.getTargetException());
                }
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.getDefinedPackage.equals(((ForJava9CapableVm) obj).getDefinedPackage);
            }

            public int hashCode() {
                return this.getDefinedPackage.hashCode() + (getClass().hashCode() * 31);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForLegacyVm implements PackageLookupStrategy {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PackageLookupStrategy
            @MaybeNull
            public Package apply(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader.doGetPackage(str);
            }
        }

        @MaybeNull
        Package apply(ByteArrayClassLoader byteArrayClassLoader, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum PersistenceHandler {
        MANIFEST(true) { // from class: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler.1
            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.get(str);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public void release(String str, ConcurrentMap<String, byte[]> concurrentMap) {
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public URL url(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                if (!str.endsWith(".class")) {
                    return ByteArrayClassLoader.NO_URL;
                }
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                byte[] bArr = concurrentMap.get(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).substring(0, str.length() - 6));
                return bArr == null ? ByteArrayClassLoader.NO_URL : (URL) ByteArrayClassLoader.doPrivileged(new UrlDefinitionAction(str, bArr));
            }
        },
        LATENT(0 == true ? 1 : 0) { // from class: net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler.2
            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return concurrentMap.remove(str);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public void release(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                concurrentMap.remove(str);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.PersistenceHandler
            public URL url(String str, ConcurrentMap<String, byte[]> concurrentMap) {
                return ByteArrayClassLoader.NO_URL;
            }
        };

        private static final String CLASS_FILE_SUFFIX = ".class";
        private final boolean manifest;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class UrlDefinitionAction implements PrivilegedAction<URL> {
            private static final boolean ACCESS_CONTROLLER;
            private static final Dispatcher DISPATCHER;
            private static final String ENCODING = "UTF-8";
            private static final String NO_FILE = "";
            private static final int NO_PORT = -1;
            private final byte[] binaryRepresentation;
            private final String typeName;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ByteArrayUrlStreamHandler extends URLStreamHandler {
                private final byte[] binaryRepresentation;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class ByteArrayUrlConnection extends URLConnection {
                    private final InputStream inputStream;

                    public ByteArrayUrlConnection(URL url, InputStream inputStream) {
                        super(url);
                        this.inputStream = inputStream;
                    }

                    @Override // java.net.URLConnection
                    public void connect() {
                        ((URLConnection) this).connected = true;
                    }

                    @Override // java.net.URLConnection
                    public InputStream getInputStream() {
                        connect();
                        return this.inputStream;
                    }
                }

                public ByteArrayUrlStreamHandler(byte[] bArr) {
                    this.binaryRepresentation = bArr;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && Arrays.equals(this.binaryRepresentation, ((ByteArrayUrlStreamHandler) obj).binaryRepresentation);
                }

                public int hashCode() {
                    return Arrays.hashCode(this.binaryRepresentation) + (getClass().hashCode() * 31);
                }

                @Override // java.net.URLStreamHandler
                public URLConnection openConnection(URL url) {
                    return new ByteArrayUrlConnection(url, new ByteArrayInputStream(this.binaryRepresentation));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @JavaDispatcher.Proxied("java.net.URL")
            public interface Dispatcher {
                @JavaDispatcher.IsConstructor
                @JavaDispatcher.Proxied(TypeProxy.REFLECTION_METHOD)
                URL make(String str, String str2, int i, String str3, URLStreamHandler uRLStreamHandler);

                @JavaDispatcher.IsStatic
                @JavaDispatcher.Defaults
                @MaybeNull
                @JavaDispatcher.Proxied("of")
                URL of(URI uri, URLStreamHandler uRLStreamHandler);
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

            public UrlDefinitionAction(String str, byte[] bArr) {
                this.typeName = str;
                this.binaryRepresentation = bArr;
            }

            @AccessControllerPlugin.Enhance
            private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
                return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UrlDefinitionAction urlDefinitionAction = (UrlDefinitionAction) obj;
                return this.typeName.equals(urlDefinitionAction.typeName) && Arrays.equals(this.binaryRepresentation, urlDefinitionAction.binaryRepresentation);
            }

            public int hashCode() {
                return Arrays.hashCode(this.binaryRepresentation) + bjs.e(this.typeName, getClass().hashCode() * 31, 31);
            }

            @Override // java.security.PrivilegedAction
            public URL run() {
                try {
                    String strEncode = URLEncoder.encode(this.typeName.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), ENCODING);
                    ByteArrayUrlStreamHandler byteArrayUrlStreamHandler = new ByteArrayUrlStreamHandler(this.binaryRepresentation);
                    Dispatcher dispatcher = DISPATCHER;
                    URL urlOf = dispatcher.of(URI.create("bytebuddy://" + strEncode), byteArrayUrlStreamHandler);
                    return urlOf == null ? dispatcher.make(ByteArrayClassLoader.URL_SCHEMA, strEncode, -1, "", byteArrayUrlStreamHandler) : urlOf;
                } catch (UnsupportedEncodingException e) {
                    throw new IllegalStateException("Could not find encoding: UTF-8", e);
                } catch (MalformedURLException e2) {
                    throw new IllegalStateException("Cannot create URL for " + this.typeName, e2);
                }
            }
        }

        public boolean isManifest() {
            return this.manifest;
        }

        @MaybeNull
        public abstract byte[] lookup(String str, ConcurrentMap<String, byte[]> concurrentMap);

        public abstract void release(String str, ConcurrentMap<String, byte[]> concurrentMap);

        @MaybeNull
        public abstract URL url(String str, ConcurrentMap<String, byte[]> concurrentMap);

        PersistenceHandler(boolean z) {
            this.manifest = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class SingletonEnumeration implements Enumeration<URL> {

        @MaybeNull
        private URL element;

        public SingletonEnumeration(URL url) {
            this.element = url;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.element != null;
        }

        @Override // java.util.Enumeration
        public URL nextElement() {
            URL url = this.element;
            if (url == null) {
                throw new NoSuchElementException();
            }
            this.element = null;
            return url;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface SynchronizationStrategy {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum CreationAction implements PrivilegedAction<Initializable> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            public Initializable run() {
                try {
                    try {
                        Class<?> cls = Class.forName("java.lang.invoke.MethodType");
                        Class<?> cls2 = Class.forName("java.lang.invoke.MethodHandle");
                        return new ForJava8CapableVm(Class.forName("java.lang.invoke.MethodHandles$Lookup").getMethod("findVirtual", Class.class, String.class, cls).invoke(ByteArrayClassLoader.methodHandle(), ClassLoader.class, "getClassLoadingLock", cls.getMethod("methodType", Class.class, Class[].class).invoke(null, Object.class, new Class[]{String.class})), cls2.getMethod("bindTo", Object.class), cls2.getMethod("invokeWithArguments", Object[].class));
                    } catch (Exception unused) {
                        return ForLegacyVm.INSTANCE;
                    }
                } catch (Exception unused2) {
                    return (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9) && ByteArrayClassLoader.class.getClassLoader() == null) ? ForLegacyVm.INSTANCE : new ForJava7CapableVm(ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class));
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava7CapableVm implements SynchronizationStrategy, Initializable {
            private final Method method;

            public ForJava7CapableVm(Method method) {
                this.method = method;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForJava7CapableVm) obj).method);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy
            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return this.method.invoke(byteArrayClassLoader, str);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2.getTargetException());
                }
            }

            public int hashCode() {
                return this.method.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.Initializable
            public SynchronizationStrategy initialize() {
                try {
                    this.method.setAccessible(true);
                    return this;
                } catch (Exception unused) {
                    return ForLegacyVm.INSTANCE;
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForJava8CapableVm implements SynchronizationStrategy, Initializable {
            private final Method bindTo;
            private final Method invokeWithArguments;
            private final Object methodHandle;

            public ForJava8CapableVm(Object obj, Method method, Method method2) {
                this.methodHandle = obj;
                this.bindTo = method;
                this.invokeWithArguments = method2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForJava8CapableVm forJava8CapableVm = (ForJava8CapableVm) obj;
                return this.methodHandle.equals(forJava8CapableVm.methodHandle) && this.bindTo.equals(forJava8CapableVm.bindTo) && this.invokeWithArguments.equals(forJava8CapableVm.invokeWithArguments);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy
            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                try {
                    return this.invokeWithArguments.invoke(this.bindTo.invoke(this.methodHandle, byteArrayClassLoader), new Object[]{str});
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2.getTargetException());
                }
            }

            public int hashCode() {
                return this.invokeWithArguments.hashCode() + ((this.bindTo.hashCode() + ((this.methodHandle.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31);
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.Initializable
            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ForLegacyVm implements SynchronizationStrategy, Initializable {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy
            public Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str) {
                return byteArrayClassLoader;
            }

            @Override // net.bytebuddy.dynamic.loading.ByteArrayClassLoader.SynchronizationStrategy.Initializable
            public SynchronizationStrategy initialize() {
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface Initializable {
            SynchronizationStrategy initialize();
        }

        Object getClassLoadingLock(ByteArrayClassLoader byteArrayClassLoader, String str);
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
        NO_URL = null;
        PACKAGE_LOOKUP_STRATEGY = (PackageLookupStrategy) doPrivileged(PackageLookupStrategy.CreationAction.INSTANCE);
        SYNCHRONIZATION_STRATEGY = (SynchronizationStrategy.Initializable) doPrivileged(SynchronizationStrategy.CreationAction.INSTANCE);
        doRegisterAsParallelCapable();
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
        this(classLoader, true, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MaybeNull
    public Package doGetPackage(String str) {
        return getPackage(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    private static void doRegisterAsParallelCapable() {
        try {
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", null);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, null);
        } catch (Throwable unused) {
        }
    }

    @MaybeNull
    @AccessControllerPlugin.Enhance
    private static Object getContext() {
        if (ACCESS_CONTROLLER) {
            return AccessController.getContext();
        }
        return null;
    }

    public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map) {
        return load(classLoader, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, PersistenceHandler.LATENT, PackageDefinitionStrategy.Trivial.INSTANCE, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object methodHandle() {
        return Class.forName("java.lang.invoke.MethodHandles").getMethod("lookup", null).invoke(null, null);
    }

    @Override // net.bytebuddy.dynamic.loading.InjectionClassLoader
    public Map<String, Class<?>> doDefineClasses(Map<String, byte[]> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            map2.put(entry.getKey(), this.typeDefinitions.putIfAbsent(entry.getKey(), entry.getValue()));
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : map.keySet()) {
                synchronized (SYNCHRONIZATION_STRATEGY.initialize().getClassLoadingLock(this, str)) {
                    linkedHashMap.put(str, loadClass(str));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                if (entry2.getValue() == null) {
                    this.persistenceHandler.release((String) entry2.getKey(), this.typeDefinitions);
                } else {
                    this.typeDefinitions.put(entry2.getKey(), entry2.getValue());
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            for (Map.Entry entry3 : map2.entrySet()) {
                if (entry3.getValue() == null) {
                    this.persistenceHandler.release((String) entry3.getKey(), this.typeDefinitions);
                } else {
                    this.typeDefinitions.put(entry3.getKey(), entry3.getValue());
                }
            }
            throw th;
        }
    }

    @Override // java.lang.ClassLoader
    public Class<?> findClass(String str) throws ClassNotFoundException {
        byte[] bArrLookup = this.persistenceHandler.lookup(str, this.typeDefinitions);
        if (bArrLookup != null) {
            return (Class) doPrivileged(new ClassDefinitionAction(str, this.classFilePostProcessor.transform(this, str, this.protectionDomain, bArrLookup)), this.accessControlContext);
        }
        throw new ClassNotFoundException(str);
    }

    @Override // java.lang.ClassLoader
    @MaybeNull
    public URL findResource(String str) {
        return this.persistenceHandler.url(str, this.typeDefinitions);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> findResources(String str) {
        URL url = this.persistenceHandler.url(str, this.typeDefinitions);
        return url == null ? EmptyEnumeration.INSTANCE : new SingletonEnumeration(url);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map) {
        this(classLoader, z, map, PersistenceHandler.LATENT);
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction, @MaybeNull Object obj) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction, (AccessControlContext) obj) : privilegedAction.run();
    }

    public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, boolean z, boolean z2) {
        return load(classLoader, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassLoaderDecorator.Factory.NoOp.INSTANCE, z, z2);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
        this(classLoader, true, map, persistenceHandler);
    }

    public static Map<TypeDescription, Class<?>> load(@MaybeNull ClassLoader classLoader, Map<TypeDescription, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassLoaderDecorator.Factory factory, boolean z, boolean z2) {
        HashMap map2 = new HashMap();
        for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
            map2.put(entry.getKey().getName(), entry.getValue());
        }
        ClassLoaderDecorator classLoaderDecoratorMake = factory.make(new ByteArrayClassLoader(classLoader, z2, map2, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE), map2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (TypeDescription typeDescription : map.keySet()) {
            if (!classLoaderDecoratorMake.isSkipped(typeDescription)) {
                try {
                    ClassLoader classLoaderApply = classLoaderDecoratorMake.apply(typeDescription);
                    Class<?> cls = Class.forName(typeDescription.getName(), false, classLoaderApply);
                    if (!GraalImageCode.getCurrent().isNativeImageExecution() && z && cls.getClassLoader() != classLoaderApply) {
                        throw new IllegalStateException("Class already loaded: " + cls);
                    }
                    linkedHashMap.put(typeDescription, cls);
                } catch (ClassNotFoundException e) {
                    throw new IllegalStateException(StaticHelpers6.concat("Cannot load class ", typeDescription), e);
                }
            }
        }
        return linkedHashMap;
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, PersistenceHandler persistenceHandler) {
        this(classLoader, z, map, ClassLoadingStrategy.NO_PROTECTION_DOMAIN, persistenceHandler, PackageDefinitionStrategy.Trivial.INSTANCE);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
        this(classLoader, true, map, protectionDomain, persistenceHandler, packageDefinitionStrategy);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy) {
        this(classLoader, z, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, ClassFilePostProcessor.NoOp.INSTANCE);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
        this(classLoader, true, map, protectionDomain, persistenceHandler, packageDefinitionStrategy, classFilePostProcessor);
    }

    public ByteArrayClassLoader(@MaybeNull ClassLoader classLoader, boolean z, Map<String, byte[]> map, @MaybeNull ProtectionDomain protectionDomain, PersistenceHandler persistenceHandler, PackageDefinitionStrategy packageDefinitionStrategy, ClassFilePostProcessor classFilePostProcessor) {
        super(classLoader, z);
        this.typeDefinitions = new ConcurrentHashMap(map);
        this.protectionDomain = protectionDomain;
        this.persistenceHandler = persistenceHandler;
        this.packageDefinitionStrategy = packageDefinitionStrategy;
        this.classFilePostProcessor = classFilePostProcessor;
        this.accessControlContext = getContext();
    }
}
