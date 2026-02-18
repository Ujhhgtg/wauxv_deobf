package net.bytebuddy.dynamic.loading;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldManifestation;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.module.ModuleDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoaderDecorator;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ModuleLayerFromSingleClassLoaderDecorator implements ClassLoaderDecorator {
    private static final boolean ACCESS_CONTROLLER;
    private static final Configuration CONFIGURATION;
    private static final ModuleDescriptor MODULE_DESCRIPTOR;
    private static final ModuleFinder MODULE_FINDER;
    private static final ModuleLayer MODULE_LAYER;
    private static final ModuleLayerController MODULE_LAYER_CONTROLLER;
    private static final Optional OPTIONAL;
    private static final Path PATH;
    private static final SimpleModuleFinder SIMPLE_MODULE_FINDER;
    private static final SimpleModuleReference SIMPLE_MODULE_REFERENCE;
    private static final Stream STREAM;

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;
    private final Object moduleLayer;
    private final String name;
    private final Set<String> packages;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractModuleFinder {
        private final Object moduleReference;
        private final String name;

        public AbstractModuleFinder(String str, Object obj) {
            this.name = str;
            this.moduleReference = obj;
        }

        @MaybeNull
        public Object doFind(String str) {
            return str.equals(this.name) ? ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.of(this.moduleReference) : ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.empty();
        }

        public Set<?> doFindAll() {
            return Collections.singleton(this.moduleReference);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractModuleReader implements Closeable {
        private final Map<String, byte[]> types;

        public AbstractModuleReader(Map<String, byte[]> map) {
            this.types = map;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public Object doFind(String str) {
            if (str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                if (this.types.get(str.substring(0, str.length() - 6).replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)) != null) {
                    return ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.of(URI.create("bytebuddy://".concat(str)));
                }
            }
            return ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.empty();
        }

        public Object doList() {
            return ModuleLayerFromSingleClassLoaderDecorator.STREAM.empty();
        }

        public Object doOpen(String str) {
            if (str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                byte[] bArr = this.types.get(str.substring(0, str.length() - 6).replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                if (bArr != null) {
                    return ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.of(new ByteArrayInputStream(bArr));
                }
            }
            return ModuleLayerFromSingleClassLoaderDecorator.OPTIONAL.empty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.module.Configuration")
    public interface Configuration {
        @JavaDispatcher.Proxied("resolve")
        Object resolve(Object obj, @JavaDispatcher.Proxied("java.lang.module.ModuleFinder") Object obj2, @JavaDispatcher.Proxied("java.lang.module.ModuleFinder") Object obj3, Collection<String> collection);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Factory implements ClassLoaderDecorator.Factory {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator.Factory
        public ClassLoaderDecorator make(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
            if (!map.containsKey(ModuleDescription.MODULE_CLASS_NAME)) {
                return new ClassLoaderDecorator.NoOp(classLoader);
            }
            try {
                Object obj = ModuleLayerFromSingleClassLoaderDecorator.MODULE_DESCRIPTOR.read(new ByteArrayInputStream(map.get(ModuleDescription.MODULE_CLASS_NAME)));
                return new ModuleLayerFromSingleClassLoaderDecorator(classLoader, ModuleLayerFromSingleClassLoaderDecorator.MODULE_LAYER_CONTROLLER.layer(ModuleLayerFromSingleClassLoaderDecorator.MODULE_LAYER.defineModulesWithOneLoader(ModuleLayerFromSingleClassLoaderDecorator.CONFIGURATION.resolve(ModuleLayerFromSingleClassLoaderDecorator.MODULE_LAYER.configuration(ModuleLayerFromSingleClassLoaderDecorator.MODULE_LAYER.boot()), ModuleLayerFromSingleClassLoaderDecorator.SIMPLE_MODULE_FINDER.newInstance(ModuleLayerFromSingleClassLoaderDecorator.MODULE_DESCRIPTOR.name(obj), ModuleLayerFromSingleClassLoaderDecorator.SIMPLE_MODULE_REFERENCE.newInstance(obj, null, map)), ModuleLayerFromSingleClassLoaderDecorator.MODULE_FINDER.of(ModuleLayerFromSingleClassLoaderDecorator.PATH.of(0)), Collections.singleton(ModuleLayerFromSingleClassLoaderDecorator.MODULE_DESCRIPTOR.name(obj))), Collections.singletonList(ModuleLayerFromSingleClassLoaderDecorator.MODULE_LAYER.boot()), classLoader)), ModuleLayerFromSingleClassLoaderDecorator.MODULE_DESCRIPTOR.name(obj), ModuleLayerFromSingleClassLoaderDecorator.MODULE_DESCRIPTOR.packages(obj));
            } catch (IOException e) {
                throw new IllegalStateException("Failed to create module layer", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor")
    public interface ModuleDescriptor {
        @JavaDispatcher.Proxied("name")
        String name(Object obj);

        @JavaDispatcher.Proxied("packages")
        Set<String> packages(Object obj);

        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("read")
        Object read(InputStream inputStream);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.module.ModuleFinder")
    public interface ModuleFinder {
        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("of")
        Object of(@JavaDispatcher.Proxied("java.nio.file.Path") Object[] objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.ModuleLayer")
    public interface ModuleLayer {
        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("boot")
        Object boot();

        @JavaDispatcher.Proxied("configuration")
        Object configuration(Object obj);

        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("defineModulesWithOneLoader")
        Object defineModulesWithOneLoader(@JavaDispatcher.Proxied("java.lang.module.Configuration") Object obj, List<?> list, @MaybeNull ClassLoader classLoader);

        @MaybeNull
        @JavaDispatcher.Proxied("findLoader")
        ClassLoader findLoader(Object obj, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.lang.ModuleLayer$Controller")
    public interface ModuleLayerController {
        @JavaDispatcher.Proxied("layer")
        Object layer(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.util.Optional")
    public interface Optional {
        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("empty")
        Object empty();

        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("of")
        Object of(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.nio.file.Path")
    public interface Path {
        @JavaDispatcher.Container
        @JavaDispatcher.Proxied("of")
        Object[] of(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("net.bytebuddy.dynamic.loading.SimpleModuleFinder")
    public interface SimpleModuleFinder {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum CreationAction implements PrivilegedAction<ClassLoader> {
            INSTANCE;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            @MaybeNull
            public ClassLoader run() {
                try {
                    DynamicType.Builder.MethodDefinition.ImplementationDefinition implementationDefinitionMethod = new ByteBuddy().subclass(AbstractModuleFinder.class, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).implement(Class.forName("java.lang.module.ModuleFinder")).name("net.bytebuddy.dynamic.loading.SimpleModuleFinder").method(ElementMatchers.named("find").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class})));
                    MethodCall methodCallWithAllArguments = MethodCall.invoke(AbstractModuleFinder.class.getDeclaredMethod("doFind", String.class)).withAllArguments();
                    Assigner assigner = Assigner.DEFAULT;
                    Assigner.Typing typing = Assigner.Typing.DYNAMIC;
                    return implementationDefinitionMethod.intercept(methodCallWithAllArguments.withAssigner(assigner, typing)).method(ElementMatchers.named("findAll").and(ElementMatchers.takesArguments(0))).intercept(MethodCall.invoke(AbstractModuleFinder.class.getDeclaredMethod("doFindAll", null)).withAllArguments().withAssigner(assigner, typing)).make().load(ModuleLayerFromSingleClassLoaderDecorator.class.getClassLoader()).getLoaded().getClassLoader();
                } catch (Exception unused) {
                    return null;
                }
            }
        }

        @JavaDispatcher.IsConstructor
        @JavaDispatcher.Proxied(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME)
        Object newInstance(String str, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("net.bytebuddy.dynamic.loading.SimpleModuleReference")
    public interface SimpleModuleReference {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum CreationAction implements PrivilegedAction<ClassLoader> {
            INSTANCE;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            @MaybeNull
            public ClassLoader run() {
                try {
                    ByteBuddy byteBuddy = new ByteBuddy();
                    DynamicType.Builder.MethodDefinition.ImplementationDefinition implementationDefinitionMethod = byteBuddy.subclass(AbstractModuleReader.class, (ConstructorStrategy) ConstructorStrategy.Default.IMITATE_SUPER_CLASS_OPENING).implement(Class.forName("java.lang.module.ModuleReader")).name("net.bytebuddy.dynamic.loading.SimpleModuleReader").method(ElementMatchers.named("open").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class})));
                    MethodCall methodCallWithAllArguments = MethodCall.invoke(AbstractModuleReader.class.getDeclaredMethod("doOpen", String.class)).withAllArguments();
                    Assigner assigner = Assigner.DEFAULT;
                    Assigner.Typing typing = Assigner.Typing.DYNAMIC;
                    DynamicType dynamicTypeMake = implementationDefinitionMethod.intercept(methodCallWithAllArguments.withAssigner(assigner, typing)).method(ElementMatchers.named("list").and(ElementMatchers.takesArguments(0))).intercept(MethodCall.invoke(AbstractModuleReader.class.getDeclaredMethod("doList", null)).withAllArguments().withAssigner(assigner, typing)).method(ElementMatchers.named("find").and(ElementMatchers.takesArguments((Class<?>[]) new Class[]{String.class}))).intercept(MethodCall.invoke(AbstractModuleReader.class.getDeclaredMethod("doFind", String.class)).withAllArguments().withAssigner(assigner, typing)).make();
                    Class<?> cls = Class.forName("java.lang.module.ModuleDescriptor");
                    Class<?> cls2 = Class.forName("java.lang.module.ModuleReference");
                    return byteBuddy.subclass((Class) cls2, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name("net.bytebuddy.dynamic.loading.SimpleModuleReference").defineField("types", Map.class, Visibility.PRIVATE, FieldManifestation.FINAL).defineConstructor(Visibility.PUBLIC).withParameters(cls, URI.class, Map.class).intercept(MethodCall.invoke(cls2.getDeclaredConstructor(cls, URI.class)).onSuper().withArgument(0, 1).andThen(FieldAccessor.ofField("types").setsArgumentAt(2))).method(ElementMatchers.named("open")).intercept(MethodCall.construct((MethodDescription) dynamicTypeMake.getTypeDescription().getDeclaredMethods().filter(ElementMatchers.isConstructor()).getOnly()).withField("types").withAssigner(assigner, typing)).make().include(dynamicTypeMake).load(ModuleLayerFromSingleClassLoaderDecorator.class.getClassLoader()).getLoaded().getClassLoader();
                } catch (Exception unused) {
                    return null;
                }
            }
        }

        @JavaDispatcher.IsConstructor
        @JavaDispatcher.Proxied(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_NAME)
        Object newInstance(@JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor") Object obj, @MaybeNull URI uri, Map<String, byte[]> map);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @JavaDispatcher.Proxied("java.util.stream.Stream")
    public interface Stream {
        @JavaDispatcher.IsStatic
        @JavaDispatcher.Proxied("empty")
        Object empty();
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
        MODULE_FINDER = (ModuleFinder) doPrivileged(JavaDispatcher.of(ModuleFinder.class));
        MODULE_DESCRIPTOR = (ModuleDescriptor) doPrivileged(JavaDispatcher.of(ModuleDescriptor.class));
        MODULE_LAYER = (ModuleLayer) doPrivileged(JavaDispatcher.of(ModuleLayer.class));
        MODULE_LAYER_CONTROLLER = (ModuleLayerController) doPrivileged(JavaDispatcher.of(ModuleLayerController.class));
        CONFIGURATION = (Configuration) doPrivileged(JavaDispatcher.of(Configuration.class));
        OPTIONAL = (Optional) doPrivileged(JavaDispatcher.of(Optional.class));
        STREAM = (Stream) doPrivileged(JavaDispatcher.of(Stream.class));
        PATH = (Path) doPrivileged(JavaDispatcher.of(Path.class));
        SIMPLE_MODULE_REFERENCE = (SimpleModuleReference) doPrivileged(JavaDispatcher.of(SimpleModuleReference.class, (ClassLoader) doPrivileged(SimpleModuleReference.CreationAction.INSTANCE)));
        SIMPLE_MODULE_FINDER = (SimpleModuleFinder) doPrivileged(JavaDispatcher.of(SimpleModuleFinder.class, (ClassLoader) doPrivileged(SimpleModuleFinder.CreationAction.INSTANCE)));
    }

    public ModuleLayerFromSingleClassLoaderDecorator(@MaybeNull ClassLoader classLoader, Object obj, String str, Set<String> set) {
        this.classLoader = classLoader;
        this.moduleLayer = obj;
        this.name = str;
        this.packages = set;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator
    @MaybeNull
    public ClassLoader apply(TypeDescription typeDescription) {
        PackageDescription packageDescription = typeDescription.getPackage();
        return (packageDescription == null || !this.packages.contains(packageDescription.getName())) ? this.classLoader : MODULE_LAYER.findLoader(this.moduleLayer, this.name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r2 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L4
            return r0
        L4:
            r1 = 0
            if (r5 != 0) goto L8
            return r1
        L8:
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L13
            return r1
        L13:
            java.lang.String r2 = r4.name
            net.bytebuddy.dynamic.loading.ModuleLayerFromSingleClassLoaderDecorator r5 = (net.bytebuddy.dynamic.loading.ModuleLayerFromSingleClassLoaderDecorator) r5
            java.lang.String r3 = r5.name
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L20
            return r1
        L20:
            java.lang.ClassLoader r2 = r4.classLoader
            java.lang.ClassLoader r3 = r5.classLoader
            if (r3 == 0) goto L2f
            if (r2 == 0) goto L31
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L32
            return r1
        L2f:
            if (r2 == 0) goto L32
        L31:
            return r1
        L32:
            java.lang.Object r2 = r4.moduleLayer
            java.lang.Object r3 = r5.moduleLayer
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3d
            return r1
        L3d:
            java.util.Set<java.lang.String> r2 = r4.packages
            java.util.Set<java.lang.String> r5 = r5.packages
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L48
            return r1
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ModuleLayerFromSingleClassLoaderDecorator.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int iHashCode = getClass().hashCode() * 31;
        ClassLoader classLoader = this.classLoader;
        if (classLoader != null) {
            iHashCode += classLoader.hashCode();
        }
        return this.packages.hashCode() + bjs.e(this.name, (this.moduleLayer.hashCode() + (iHashCode * 31)) * 31, 31);
    }

    @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator
    public boolean isSkipped(TypeDescription typeDescription) {
        return typeDescription.isModuleType();
    }
}
