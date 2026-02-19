package net.bytebuddy.build;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.TypeResolutionStrategy;
import net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer;
import net.bytebuddy.implementation.LoadedTypeInitializer;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.FileSystem;
import net.bytebuddy.utility.QueueFactory;
import net.bytebuddy.utility.StreamDrainer;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Plugin extends ElementMatcher<TypeDescription>, Closeable {

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Engine {
        public static final String PLUGIN_FILE = "META-INF/net.bytebuddy/build.plugins";

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static abstract class AbstractBase implements Engine {
            @Override // net.bytebuddy.build.Plugin.Engine
            public Summary apply(File file, File file2, Factory... factoryArr) {
                return apply(file, file2, Arrays.asList(factoryArr));
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine withErrorHandlers(ErrorHandler... errorHandlerArr) {
                return withErrorHandlers(Arrays.asList(errorHandlerArr));
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine withParallelTransformation(int i) {
                if (i >= 1) {
                    return with(new Dispatcher.ForParallelTransformation.WithThrowawayExecutorService.Factory(i));
                }
                throw new IllegalArgumentException(concatVar2Var1(i, "Number of threads must be positive: "));
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Summary apply(File file, File file2, List<? extends Factory> list) {
                return apply(file.isDirectory() ? new Source.ForFolder(file) : new Source.ForJarFile(file),
                        file2.isDirectory() ? new Target.ForFolder(file2) : new Target.ForJarFile(file2), list);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Summary apply(Source source, Target target, Factory... factoryArr) {
                return apply(source, target, Arrays.asList(factoryArr));
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Default extends AbstractBase {
            private final ByteBuddy byteBuddy;
            private final ClassFileLocator classFileLocator;

            @MaybeNull
            @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
            private final ClassFileVersion classFileVersion;
            private final Dispatcher.Factory dispatcherFactory;
            private final ErrorHandler errorHandler;
            private final ElementMatcher.Junction<? super TypeDescription> ignoredTypeMatcher;
            private final Listener listener;
            private final PoolStrategy poolStrategy;
            private final TypeStrategy typeStrategy;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public class Preprocessor implements Callable<Callable<? extends Dispatcher.Materializable>> {
                private final ClassFileLocator classFileLocator;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final ClassFileVersion classFileVersion;
                private final Source.Element element;
                private final Listener listener;
                private final List<Plugin> plugins;
                private final List<WithPreprocessor> preprocessors;
                private final String typeName;
                private final TypePool typePool;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public class Ignored implements Callable<Dispatcher.Materializable> {
                    private final TypeDescription typeDescription;

                    private Ignored(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // java.util.concurrent.Callable
                    public Dispatcher.Materializable call() {
                        try {
                            Preprocessor.this.listener.onIgnored(this.typeDescription, Preprocessor.this.plugins);
                            return new Dispatcher.Materializable.ForRetainedElement(Preprocessor.this.element);
                        } finally {
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public class Resolved implements Callable<Dispatcher.Materializable> {

                    @MaybeNull
                    private final ClassFileVersion classFileVersion;
                    private final TypeDescription typeDescription;

                    private Resolved(@MaybeNull ClassFileVersion classFileVersion, TypeDescription typeDescription) {
                        this.classFileVersion = classFileVersion;
                        this.typeDescription = typeDescription;
                    }

                    @Override // java.util.concurrent.Callable
                    public Dispatcher.Materializable call() {
                        Dispatcher.Materializable forFailedElement;
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            DynamicType.Builder<?> builder = Default.this.typeStrategy.builder(Default.this.byteBuddy,
                                    this.typeDescription, Preprocessor.this.classFileLocator);
                            for (Plugin plugin : Preprocessor.this.plugins) {
                                try {
                                    if (plugin.matches(this.typeDescription)) {
                                        builder = plugin.apply(builder, this.typeDescription,
                                                Preprocessor.this.classFileLocator);
                                        Preprocessor.this.listener.onTransformation(this.typeDescription, plugin);
                                        arrayList.add(plugin);
                                    } else {
                                        Preprocessor.this.listener.onIgnored(this.typeDescription, plugin);
                                        arrayList2.add(plugin);
                                    }
                                } catch (Throwable th) {
                                    Preprocessor.this.listener.onError(this.typeDescription, plugin, th);
                                    arrayList3.add(th);
                                }
                            }
                            if (!arrayList3.isEmpty()) {
                                Preprocessor.this.listener.onError(this.typeDescription, arrayList3);
                                forFailedElement = new Dispatcher.Materializable.ForFailedElement(
                                        Preprocessor.this.element, this.typeDescription, arrayList3);
                            } else if (arrayList.isEmpty()) {
                                Preprocessor.this.listener.onIgnored(this.typeDescription, arrayList2);
                                forFailedElement = new Dispatcher.Materializable.ForRetainedElement(
                                        Preprocessor.this.element);
                            } else {
                                try {
                                    DynamicType.Unloaded<?> unloadedMake = builder
                                            .make(TypeResolutionStrategy.Disabled.INSTANCE, Preprocessor.this.typePool);
                                    Preprocessor.this.listener.onTransformation(this.typeDescription, arrayList);
                                    for (Map.Entry<TypeDescription, LoadedTypeInitializer> entry : unloadedMake
                                            .getLoadedTypeInitializers().entrySet()) {
                                        if (entry.getValue().isAlive()) {
                                            Preprocessor.this.listener.onLiveInitializer(this.typeDescription,
                                                    entry.getKey());
                                        }
                                    }
                                    forFailedElement = new Dispatcher.Materializable.ForTransformedElement(
                                            this.classFileVersion, unloadedMake);
                                } catch (Throwable th2) {
                                    arrayList3.add(th2);
                                    Preprocessor.this.listener.onError(this.typeDescription, arrayList3);
                                    forFailedElement = new Dispatcher.Materializable.ForFailedElement(
                                            Preprocessor.this.element, this.typeDescription, arrayList3);
                                }
                            }
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            return forFailedElement;
                        } catch (Throwable th3) {
                            Preprocessor.this.listener.onComplete(this.typeDescription);
                            throw th3;
                        }
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public class Unresolved implements Callable<Dispatcher.Materializable> {
                    private Unresolved() {
                    }

                    @Override // java.util.concurrent.Callable
                    public Dispatcher.Materializable call() {
                        Preprocessor.this.listener.onUnresolved(Preprocessor.this.typeName);
                        return new Dispatcher.Materializable.ForUnresolvedElement(Preprocessor.this.element,
                                Preprocessor.this.typeName);
                    }
                }

                private Preprocessor(Source.Element element, String str, ClassFileLocator classFileLocator,
                        @MaybeNull ClassFileVersion classFileVersion, TypePool typePool, Listener listener,
                        List<Plugin> list, List<WithPreprocessor> list2) {
                    this.element = element;
                    this.typeName = str;
                    this.classFileLocator = classFileLocator;
                    this.classFileVersion = classFileVersion;
                    this.typePool = typePool;
                    this.listener = listener;
                    this.plugins = list;
                    this.preprocessors = list2;
                }

                @Override // java.util.concurrent.Callable
                public Callable<? extends Dispatcher.Materializable> call() throws Exception {
                    this.listener.onDiscovery(this.typeName);
                    TypePool.Resolution resolutionDescribe = this.typePool.describe(this.typeName);
                    if (!resolutionDescribe.isResolved()) {
                        return new Unresolved();
                    }
                    TypeDescription typeDescriptionResolve = resolutionDescribe.resolve();
                    try {
                        if (Default.this.ignoredTypeMatcher.matches(typeDescriptionResolve)) {
                            return new Ignored(typeDescriptionResolve);
                        }
                        Iterator<WithPreprocessor> it = this.preprocessors.iterator();
                        while (it.hasNext()) {
                            it.next().onPreprocess(typeDescriptionResolve, this.classFileLocator);
                        }
                        return new Resolved(this.classFileVersion, typeDescriptionResolve);
                    } catch (Throwable th) {
                        this.listener.onComplete(typeDescriptionResolve);
                        if (th instanceof Exception) {
                            throw ((Exception) th);
                        }
                        if (th instanceof Error) {
                            throw ((Error) th);
                        }
                        throw new IllegalStateException(th);
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class SourceEntryPrependingClassFileLocator implements ClassFileLocator {
                private final ClassFileLocator delegate;
                private final Source.Element element;
                private final String name;

                public SourceEntryPrependingClassFileLocator(String str, Source.Element element,
                        ClassFileLocator classFileLocator) {
                    this.name = str;
                    this.element = element;
                    this.delegate = classFileLocator;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    this.delegate.close();
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    SourceEntryPrependingClassFileLocator sourceEntryPrependingClassFileLocator = (SourceEntryPrependingClassFileLocator) obj;
                    return this.name.equals(sourceEntryPrependingClassFileLocator.name)
                            && this.element.equals(sourceEntryPrependingClassFileLocator.element)
                            && this.delegate.equals(sourceEntryPrependingClassFileLocator.delegate);
                }

                public int hashCode() {
                    return this.delegate.hashCode()
                            + ((this.element.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31)) * 31);
                }

                @Override // net.bytebuddy.dynamic.ClassFileLocator
                public ClassFileLocator.Resolution locate(String str) throws IOException {
                    if (!str.endsWith(this.name)) {
                        return this.delegate.locate(str);
                    }
                    InputStream inputStream = this.element.getInputStream();
                    try {
                        return new ClassFileLocator.Resolution.Explicit(StreamDrainer.DEFAULT.drain(inputStream));
                    } finally {
                        inputStream.close();
                    }
                }
            }

            public Default() {
                this(new ByteBuddy());
            }

            public static void main(String... strArr) {
                if (strArr.length < 2) {
                    throw new IllegalArgumentException("Expected arguments: <source> <target> [<plugin>, ...]");
                }
                ArrayList arrayList = new ArrayList(strArr.length - 2);
                Iterator it = Arrays.asList(strArr).subList(2, strArr.length).iterator();
                while (it.hasNext()) {
                    arrayList.add(new Factory.UsingReflection(Class.forName((String) it.next())));
                }
                new Default().apply(new File(strArr[0]), new File(strArr[1]), arrayList);
            }

            public static Engine of(EntryPoint entryPoint, ClassFileVersion classFileVersion,
                    MethodNameTransformer methodNameTransformer) {
                return new Default(entryPoint.byteBuddy(classFileVersion),
                        new TypeStrategy.ForEntryPoint(entryPoint, methodNameTransformer));
            }

            public static Set<String> scan(ClassLoader classLoader) throws IOException {
                HashSet hashSet = new HashSet();
                Enumeration<URL> resources = classLoader.getResources(Engine.PLUGIN_FILE);
                while (resources.hasMoreElements()) {
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(resources.nextElement().openStream(), "UTF-8"));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line != null) {
                                hashSet.add(line);
                            }
                        } catch (Throwable th) {
                            bufferedReader.close();
                            throw th;
                        }
                    }
                    bufferedReader.close();
                }
                return hashSet;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /*
             * JADX WARN: Type inference failed for: r22v0, types:
             * [net.bytebuddy.build.Plugin$Engine$Source]
             */
            /* JADX WARN: Type inference failed for: r22v1 */
            /* JADX WARN: Type inference failed for: r22v2, types: [java.io.Closeable] */
            /*
             * JADX WARN: Undo finally extract visitor
             * java.lang.NullPointerException
             */
            @Override // net.bytebuddy.build.Plugin.Engine
            public Summary apply(Source source, Target target, List<? extends Factory> list) throws IOException {
                Dispatcher dispatcher;
                int i;
                Source.Origin origin;
                Target.Sink sink;
                ClassFileLocator.Compound compound;
                ArrayList arrayList;
                Source.Element element;
                String str;
                Source.Element element2;
                String str2;
                ClassFileVersion classFileVersionOfJavaVersion;
                ClassFileVersion classFileVersion;
                Default r1 = this;
                Target.Sink sink2 = null;
                int i2 = 1;
                Listener.Compound compound2 = new Listener.Compound(r1.listener,
                        new Listener.ForErrorHandler(r1.errorHandler));
                ArrayList arrayList2 = new ArrayList();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ArrayList arrayList3 = new ArrayList();
                ArrayList<Plugin> arrayList4 = new ArrayList(list.size());
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                Object obj = null;
                try {
                    Iterator<? extends Factory> it = list.iterator();
                    while (it.hasNext()) {
                        Plugin pluginMake = it.next().make();
                        arrayList4.add(pluginMake);
                        if (pluginMake instanceof WithPreprocessor) {
                            arrayList6.add((WithPreprocessor) pluginMake);
                        }
                        if (pluginMake instanceof WithInitialization) {
                            arrayList5.add((WithInitialization) pluginMake);
                        }
                    }
                    Source.Origin origin2 = source.read();
                    try {
                        try {
                            ClassFileLocator.Compound compound3 = new ClassFileLocator.Compound(
                                    origin2.toClassFileLocator(r1.classFileVersion), r1.classFileLocator);
                            TypePool typePool = r1.poolStrategy.typePool(compound3);
                            Manifest manifest = origin2.getManifest();
                            compound2.onManifest(manifest);
                            Target.Sink sinkWrite = target.write(manifest);
                            try {
                                Iterator it2 = arrayList5.iterator();
                                while (it2.hasNext()) {
                                    sinkWrite.store(((WithInitialization) it2.next()).initialize(compound3));
                                }
                                try {
                                    Dispatcher dispatcherMake = r1.dispatcherFactory.make(sinkWrite, arrayList2,
                                            linkedHashMap, arrayList3);
                                    try {
                                        for (Source.Element element3 : origin2) {
                                            if (Thread.interrupted()) {
                                                Thread.currentThread().interrupt();
                                                throw new IllegalStateException(
                                                        "Thread interrupted during plugin engine application");
                                            }
                                            String name = element3.getName();
                                            while (name.startsWith("/")) {
                                                name = name.substring(i2);
                                            }
                                            try {
                                                if (name.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                                                    i = i2;
                                                    if (!name.startsWith("META-INF")
                                                            || name.startsWith(ClassFileLocator.META_INF_VERSIONS)) {
                                                        try {
                                                            origin = origin2;
                                                            Dispatcher dispatcher2 = dispatcherMake;
                                                            if (name.startsWith(ClassFileLocator.META_INF_VERSIONS)) {
                                                                try {
                                                                    classFileVersionOfJavaVersion = ClassFileVersion
                                                                            .ofJavaVersion(
                                                                                    Integer.parseInt(name.substring(18,
                                                                                            name.indexOf(47, 18))));
                                                                } catch (NumberFormatException unused) {
                                                                    dispatcher = dispatcher2;
                                                                    element2 = element3;
                                                                    sink = sinkWrite;
                                                                    compound = compound3;
                                                                    arrayList = arrayList2;
                                                                    str2 = name;
                                                                    compound2.onResource(str2);
                                                                    sink.retain(element2);
                                                                    r1 = this;
                                                                    origin2 = origin;
                                                                    compound3 = compound;
                                                                    sinkWrite = sink;
                                                                    dispatcherMake = dispatcher;
                                                                    i2 = i;
                                                                    arrayList2 = arrayList;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    dispatcher = dispatcher2;
                                                                    dispatcher.close();
                                                                    throw th;
                                                                }
                                                            } else {
                                                                classFileVersionOfJavaVersion = null;
                                                            }
                                                            if (classFileVersionOfJavaVersion == null
                                                                    || (classFileVersionOfJavaVersion
                                                                            .isAtLeast(ClassFileVersion.JAVA_V8)
                                                                            && (classFileVersion = r1.classFileVersion) != null
                                                                            && classFileVersion
                                                                                    .isAtLeast(ClassFileVersion.JAVA_V9)
                                                                            && classFileVersionOfJavaVersion
                                                                                    .isAtMost(r1.classFileVersion))) {
                                                                String strReplace = name
                                                                        .substring(name.startsWith(
                                                                                ClassFileLocator.META_INF_VERSIONS)
                                                                                        ? name.indexOf(47, 18) + 1
                                                                                        : 0,
                                                                                name.length() - 6)
                                                                        .replace('/',
                                                                                TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                                                                SourceEntryPrependingClassFileLocator sourceEntryPrependingClassFileLocator = new SourceEntryPrependingClassFileLocator(
                                                                        strReplace, element3, compound3);
                                                                dispatcher = dispatcher2;
                                                                compound = compound3;
                                                                element2 = element3;
                                                                ClassFileVersion classFileVersion2 = classFileVersionOfJavaVersion;
                                                                sink = sinkWrite;
                                                                arrayList = arrayList2;
                                                                str2 = name;
                                                                try {
                                                                    dispatcher.accept(new Preprocessor(element2,
                                                                            strReplace,
                                                                            sourceEntryPrependingClassFileLocator,
                                                                            classFileVersion2, typePool, compound2,
                                                                            arrayList4, arrayList6),
                                                                            arrayList6.isEmpty());
                                                                } catch (NumberFormatException unused2) {
                                                                    compound2.onResource(str2);
                                                                    sink.retain(element2);
                                                                }
                                                            } else {
                                                                compound2.onResource(name);
                                                                sinkWrite.retain(element3);
                                                                dispatcher = dispatcher2;
                                                                sink = sinkWrite;
                                                                compound = compound3;
                                                                arrayList = arrayList2;
                                                            }
                                                        } catch (NumberFormatException unused3) {
                                                            origin = origin2;
                                                            sink = sinkWrite;
                                                            compound = compound3;
                                                            dispatcher = dispatcherMake;
                                                            arrayList = arrayList2;
                                                            element2 = element3;
                                                        }
                                                        r1 = this;
                                                        origin2 = origin;
                                                        compound3 = compound;
                                                        sinkWrite = sink;
                                                        dispatcherMake = dispatcher;
                                                        i2 = i;
                                                        arrayList2 = arrayList;
                                                    } else {
                                                        origin = origin2;
                                                        sink = sinkWrite;
                                                        compound = compound3;
                                                        dispatcher = dispatcherMake;
                                                        arrayList = arrayList2;
                                                        element = element3;
                                                    }
                                                } else {
                                                    i = i2;
                                                    origin = origin2;
                                                    sink = sinkWrite;
                                                    compound = compound3;
                                                    arrayList = arrayList2;
                                                    element = element3;
                                                    dispatcher = dispatcherMake;
                                                }
                                                if (!str.equals("META-INF/MANIFEST.MF")) {
                                                    compound2.onResource(str);
                                                    sink.retain(element);
                                                }
                                                r1 = this;
                                                origin2 = origin;
                                                compound3 = compound;
                                                sinkWrite = sink;
                                                dispatcherMake = dispatcher;
                                                i2 = i;
                                                arrayList2 = arrayList;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                dispatcher.close();
                                                throw th;
                                            }
                                            str = name;
                                        }
                                        Source.Origin origin3 = origin2;
                                        Target.Sink sink3 = sinkWrite;
                                        Dispatcher dispatcher3 = dispatcherMake;
                                        ArrayList arrayList7 = arrayList2;
                                        dispatcher3.complete();
                                        dispatcher3.close();
                                        if (!linkedHashMap.isEmpty()) {
                                            compound2.onError(linkedHashMap);
                                        }
                                        sink3.close();
                                        origin3.close();
                                        Throwable th3 = null;
                                        for (Plugin plugin : arrayList4) {
                                            try {
                                                plugin.close();
                                            } catch (Throwable th4) {
                                                try {
                                                    compound2.onError(plugin, th4);
                                                } catch (Throwable th5) {
                                                    if (th3 == null) {
                                                        th3 = th5;
                                                    }
                                                }
                                            }
                                        }
                                        if (th3 == null) {
                                            return new Summary(arrayList7, linkedHashMap, arrayList3);
                                        }
                                        if (th3 instanceof IOException) {
                                            throw ((IOException) th3);
                                        }
                                        if (th3 instanceof RuntimeException) {
                                            throw ((RuntimeException) th3);
                                        }
                                        throw new IllegalStateException(th3);
                                    } catch (Throwable th6) {
                                        th = th6;
                                        dispatcher = dispatcherMake;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    sink2.close();
                                    throw th;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                sink2 = sinkWrite;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            source.close();
                            throw th;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        source = origin2;
                        source.close();
                        throw th;
                    }
                } catch (Throwable th11) {
                    for (Plugin plugin2 : arrayList4) {
                        try {
                            plugin2.close();
                        } catch (Throwable th12) {
                            try {
                                compound2.onError(plugin2, th12);
                            } catch (Throwable th13) {
                                if (obj == null) {
                                    obj = th13;
                                }
                            }
                        }
                    }
                    throw th11;
                }
            }

            /*
             * JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
             * 
             * if (r2 != null) goto L30;
             */
            /*
             * Code decompiled incorrectly, please refer to instructions dump.
             * To view partially-correct add '--show-bad-code' argument
             */
            public boolean equals(@net.bytebuddy.utility.nullability.MaybeNull java.lang.Object r5) {
                /*
                 * r4 = this;
                 * r0 = 1
                 * if (r4 != r5) goto L4
                 * return r0
                 * L4:
                 * r1 = 0
                 * if (r5 != 0) goto L8
                 * return r1
                 * L8:
                 * java.lang.Class r2 = r4.getClass()
                 * java.lang.Class r3 = r5.getClass()
                 * if (r2 == r3) goto L13
                 * return r1
                 * L13:
                 * net.bytebuddy.ByteBuddy r2 = r4.byteBuddy
                 * net.bytebuddy.build.Plugin$Engine$Default r5 =
                 * (net.bytebuddy.build.Plugin.Engine.Default) r5
                 * net.bytebuddy.ByteBuddy r3 = r5.byteBuddy
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L20
                 * return r1
                 * L20:
                 * net.bytebuddy.build.Plugin$Engine$TypeStrategy r2 = r4.typeStrategy
                 * net.bytebuddy.build.Plugin$Engine$TypeStrategy r3 = r5.typeStrategy
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L2b
                 * return r1
                 * L2b:
                 * net.bytebuddy.build.Plugin$Engine$PoolStrategy r2 = r4.poolStrategy
                 * net.bytebuddy.build.Plugin$Engine$PoolStrategy r3 = r5.poolStrategy
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L36
                 * return r1
                 * L36:
                 * net.bytebuddy.dynamic.ClassFileLocator r2 = r4.classFileLocator
                 * net.bytebuddy.dynamic.ClassFileLocator r3 = r5.classFileLocator
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L41
                 * return r1
                 * L41:
                 * net.bytebuddy.ClassFileVersion r2 = r4.classFileVersion
                 * net.bytebuddy.ClassFileVersion r3 = r5.classFileVersion
                 * if (r3 == 0) goto L50
                 * if (r2 == 0) goto L52
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L53
                 * return r1
                 * L50:
                 * if (r2 == 0) goto L53
                 * L52:
                 * return r1
                 * L53:
                 * net.bytebuddy.build.Plugin$Engine$Listener r2 = r4.listener
                 * net.bytebuddy.build.Plugin$Engine$Listener r3 = r5.listener
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L5e
                 * return r1
                 * L5e:
                 * net.bytebuddy.build.Plugin$Engine$ErrorHandler r2 = r4.errorHandler
                 * net.bytebuddy.build.Plugin$Engine$ErrorHandler r3 = r5.errorHandler
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L69
                 * return r1
                 * L69:
                 * net.bytebuddy.build.Plugin$Engine$Dispatcher$Factory r2 =
                 * r4.dispatcherFactory
                 * net.bytebuddy.build.Plugin$Engine$Dispatcher$Factory r3 =
                 * r5.dispatcherFactory
                 * boolean r2 = r2.equals(r3)
                 * if (r2 != 0) goto L74
                 * return r1
                 * L74:
                 * net.bytebuddy.matcher.ElementMatcher$Junction<? super
                 * net.bytebuddy.description.type.TypeDescription> r2 = r4.ignoredTypeMatcher
                 * net.bytebuddy.matcher.ElementMatcher$Junction<? super
                 * net.bytebuddy.description.type.TypeDescription> r5 = r5.ignoredTypeMatcher
                 * boolean r5 = r2.equals(r5)
                 * if (r5 != 0) goto L7f
                 * return r1
                 * L7f:
                 * return r0
                 */
                throw new UnsupportedOperationException(
                        "Method not decompiled: net.bytebuddy.build.Plugin.Engine.Default.equals(java.lang.Object):boolean");
            }

            public int hashCode() {
                int iHashCode = (this.classFileLocator.hashCode()
                        + ((this.poolStrategy.hashCode() + ((this.typeStrategy.hashCode()
                                + ((this.byteBuddy.hashCode() + (getClass().hashCode() * 31)) * 31)) * 31)) * 31))
                        * 31;
                ClassFileVersion classFileVersion = this.classFileVersion;
                if (classFileVersion != null) {
                    iHashCode += classFileVersion.hashCode();
                }
                return this.ignoredTypeMatcher.hashCode() + ((this.dispatcherFactory.hashCode()
                        + ((this.errorHandler.hashCode() + ((this.listener.hashCode() + (iHashCode * 31)) * 31)) * 31))
                        * 31);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine ignore(ElementMatcher<? super TypeDescription> elementMatcher) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, this.errorHandler, this.dispatcherFactory,
                        this.ignoredTypeMatcher.or(elementMatcher));
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(ByteBuddy byteBuddy) {
                return new Default(byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, this.errorHandler, this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine withErrorHandlers(List<? extends ErrorHandler> list) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, new ErrorHandler.Compound(list), this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine withoutErrorHandlers() {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, Listener.NoOp.INSTANCE, this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            public Default(ByteBuddy byteBuddy) {
                this(byteBuddy, TypeStrategy.Default.REBASE);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(TypeStrategy typeStrategy) {
                return new Default(this.byteBuddy, typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, this.errorHandler, this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            public Default(ByteBuddy byteBuddy, TypeStrategy typeStrategy) {
                this(byteBuddy, typeStrategy, PoolStrategy.Default.FAST, ClassFileLocator.NoOp.INSTANCE, null,
                        Listener.NoOp.INSTANCE,
                        new ErrorHandler.Compound(ErrorHandler.Failing.FAIL_FAST,
                                ErrorHandler.Enforcing.ALL_TYPES_RESOLVED, ErrorHandler.Enforcing.NO_LIVE_INITIALIZERS),
                        Dispatcher.ForSerialTransformation.Factory.INSTANCE, ElementMatchers.none());
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(PoolStrategy poolStrategy) {
                return new Default(this.byteBuddy, this.typeStrategy, poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, this.errorHandler, this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(ClassFileLocator classFileLocator) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy,
                        new ClassFileLocator.Compound(this.classFileLocator, classFileLocator), this.classFileVersion,
                        this.listener, this.errorHandler, this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(@MaybeNull ClassFileVersion classFileVersion) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        classFileVersion, this.listener, this.errorHandler, this.dispatcherFactory,
                        this.ignoredTypeMatcher);
            }

            public Default(ByteBuddy byteBuddy, TypeStrategy typeStrategy, PoolStrategy poolStrategy,
                    ClassFileLocator classFileLocator, @MaybeNull ClassFileVersion classFileVersion, Listener listener,
                    ErrorHandler errorHandler, Dispatcher.Factory factory,
                    ElementMatcher.Junction<? super TypeDescription> junction) {
                this.byteBuddy = byteBuddy;
                this.typeStrategy = typeStrategy;
                this.poolStrategy = poolStrategy;
                this.classFileLocator = classFileLocator;
                this.classFileVersion = classFileVersion;
                this.listener = listener;
                this.errorHandler = errorHandler;
                this.dispatcherFactory = factory;
                this.ignoredTypeMatcher = junction;
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(Listener listener) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, new Listener.Compound(this.listener, listener), this.errorHandler,
                        this.dispatcherFactory, this.ignoredTypeMatcher);
            }

            @Override // net.bytebuddy.build.Plugin.Engine
            public Engine with(Dispatcher.Factory factory) {
                return new Default(this.byteBuddy, this.typeStrategy, this.poolStrategy, this.classFileLocator,
                        this.classFileVersion, this.listener, this.errorHandler, factory, this.ignoredTypeMatcher);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Dispatcher extends Closeable {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Factory {
                Dispatcher make(Target.Sink sink, List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map,
                        List<String> list2);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class ForParallelTransformation implements Dispatcher {
                private int deferred;
                private final Map<TypeDescription, List<Throwable>> failed;
                private final Set<Future<?>> futures = new HashSet();
                private final CompletionService<Materializable> materializers;
                private final CompletionService<Callable<Materializable>> preprocessings;
                private final Target.Sink sink;
                private final List<TypeDescription> transformed;
                private final List<String> unresolved;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class EagerWork implements Callable<Materializable> {
                    private final Callable<? extends Callable<? extends Materializable>> work;

                    public EagerWork(Callable<? extends Callable<? extends Materializable>> callable) {
                        this.work = callable;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.work.equals(((EagerWork) obj).work);
                    }

                    public int hashCode() {
                        return this.work.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // java.util.concurrent.Callable
                    public Materializable call() {
                        return this.work.call().call();
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Factory implements Factory {
                    private final Executor executor;

                    public Factory(Executor executor) {
                        this.executor = executor;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.executor.equals(((Factory) obj).executor);
                    }

                    public int hashCode() {
                        return this.executor.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Factory
                    public Dispatcher make(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        return new ForParallelTransformation(this.executor, sink, list, map, list2);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WithThrowawayExecutorService extends ForParallelTransformation {
                    private final ExecutorService executorService;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Factory implements Factory {
                        private final int threads;

                        public Factory(int i) {
                            this.threads = i;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass()
                                    && this.threads == ((Factory) obj).threads;
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.threads;
                        }

                        @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Factory
                        public Dispatcher make(Target.Sink sink, List<TypeDescription> list,
                                Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                            return new WithThrowawayExecutorService(Executors.newFixedThreadPool(this.threads), sink,
                                    list, map, list2);
                        }
                    }

                    public WithThrowawayExecutorService(ExecutorService executorService, Target.Sink sink,
                            List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        super(executorService, sink, list, map, list2);
                        this.executorService = executorService;
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.ForParallelTransformation,
                              // java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                        try {
                            super.close();
                        } finally {
                            this.executorService.shutdown();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.executorService.equals(((WithThrowawayExecutorService) obj).executorService);
                    }

                    public int hashCode() {
                        return this.executorService.hashCode() + (getClass().hashCode() * 31);
                    }
                }

                public ForParallelTransformation(Executor executor, Target.Sink sink, List<TypeDescription> list,
                        Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                    this.sink = sink;
                    this.transformed = list;
                    this.failed = map;
                    this.unresolved = list2;
                    this.preprocessings = new ExecutorCompletionService(executor);
                    this.materializers = new ExecutorCompletionService(executor);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher
                public void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z) {
                    if (z) {
                        this.futures.add(this.materializers.submit(new EagerWork(callable)));
                    } else {
                        this.deferred++;
                        this.futures.add(this.preprocessings.submit(callable));
                    }
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    Iterator<Future<?>> it = this.futures.iterator();
                    while (it.hasNext()) {
                        it.next().cancel(true);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher
                public void complete() throws IOException {
                    try {
                        ArrayList arrayList = new ArrayList(this.deferred);
                        while (true) {
                            int i = this.deferred;
                            this.deferred = i - 1;
                            if (i <= 0) {
                                break;
                            }
                            Future<Callable<Materializable>> futureTake = this.preprocessings.take();
                            this.futures.remove(futureTake);
                            arrayList.add(futureTake.get());
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            this.futures.add(this.materializers.submit((Callable) it.next()));
                        }
                        while (!this.futures.isEmpty()) {
                            Future<Materializable> futureTake2 = this.materializers.take();
                            this.futures.remove(futureTake2);
                            futureTake2.get().materialize(this.sink, this.transformed, this.failed, this.unresolved);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new IllegalStateException(e);
                    } catch (ExecutionException e2) {
                        Throwable cause = e2.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        if (cause instanceof RuntimeException) {
                            throw ((RuntimeException) cause);
                        }
                        if (!(cause instanceof Error)) {
                            throw new IllegalStateException(cause);
                        }
                        throw ((Error) cause);
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class ForSerialTransformation implements Dispatcher {
                private final Map<TypeDescription, List<Throwable>> failed;
                private final List<Callable<? extends Materializable>> preprocessings = new ArrayList();
                private final Target.Sink sink;
                private final List<TypeDescription> transformed;
                private final List<String> unresolved;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum Factory implements Factory {
                    INSTANCE;

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Factory
                    public Dispatcher make(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        return new ForSerialTransformation(sink, list, map, list2);
                    }
                }

                public ForSerialTransformation(Target.Sink sink, List<TypeDescription> list,
                        Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                    this.sink = sink;
                    this.transformed = list;
                    this.failed = map;
                    this.unresolved = list2;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher
                public void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z)
                        throws IOException {
                    try {
                        Callable<? extends Materializable> callableCall = callable.call();
                        if (z) {
                            callableCall.call().materialize(this.sink, this.transformed, this.failed, this.unresolved);
                        } else {
                            this.preprocessings.add(callableCall);
                        }
                    } catch (Exception e) {
                        if (e instanceof IOException) {
                            throw ((IOException) e);
                        }
                        if (!(e instanceof RuntimeException)) {
                            throw new IllegalStateException(e);
                        }
                        throw ((RuntimeException) e);
                    }
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher
                public void complete() throws IOException {
                    for (Callable<? extends Materializable> callable : this.preprocessings) {
                        if (Thread.interrupted()) {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException("Interrupted during plugin engine completion");
                        }
                        try {
                            callable.call().materialize(this.sink, this.transformed, this.failed, this.unresolved);
                        } catch (Exception e) {
                            if (e instanceof IOException) {
                                throw ((IOException) e);
                            }
                            if (!(e instanceof RuntimeException)) {
                                throw new IllegalStateException(e);
                            }
                            throw ((RuntimeException) e);
                        }
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Materializable {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForFailedElement implements Materializable {
                    private final Source.Element element;
                    private final List<Throwable> errored;
                    private final TypeDescription typeDescription;

                    public ForFailedElement(Source.Element element, TypeDescription typeDescription,
                            List<Throwable> list) {
                        this.element = element;
                        this.typeDescription = typeDescription;
                        this.errored = list;
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Materializable
                    public void materialize(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        sink.retain(this.element);
                        map.put(this.typeDescription, this.errored);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForRetainedElement implements Materializable {
                    private final Source.Element element;

                    public ForRetainedElement(Source.Element element) {
                        this.element = element;
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Materializable
                    public void materialize(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        sink.retain(this.element);
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForTransformedElement implements Materializable {

                    @MaybeNull
                    private final ClassFileVersion classFileVersion;
                    private final DynamicType dynamicType;

                    public ForTransformedElement(@MaybeNull ClassFileVersion classFileVersion,
                            DynamicType dynamicType) {
                        this.classFileVersion = classFileVersion;
                        this.dynamicType = dynamicType;
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Materializable
                    public void materialize(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        ClassFileVersion classFileVersion = this.classFileVersion;
                        if (classFileVersion == null) {
                            sink.store(this.dynamicType.getAllTypes());
                        } else {
                            sink.store(classFileVersion, this.dynamicType.getAllTypes());
                        }
                        list.add(this.dynamicType.getTypeDescription());
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForUnresolvedElement implements Materializable {
                    private final Source.Element element;
                    private final String typeName;

                    public ForUnresolvedElement(Source.Element element, String str) {
                        this.element = element;
                        this.typeName = str;
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Dispatcher.Materializable
                    public void materialize(Target.Sink sink, List<TypeDescription> list,
                            Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                        sink.retain(this.element);
                        list2.add(this.typeName);
                    }
                }

                void materialize(Target.Sink sink, List<TypeDescription> list,
                        Map<TypeDescription, List<Throwable>> map, List<String> list2);
            }

            void accept(Callable<? extends Callable<? extends Materializable>> callable, boolean z);

            void complete();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface ErrorHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static class Compound implements ErrorHandler {
                private final List<ErrorHandler> errorHandlers;

                public Compound(ErrorHandler... errorHandlerArr) {
                    this((List<? extends ErrorHandler>) Arrays.asList(errorHandlerArr));
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onError(typeDescription, plugin, th);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onLiveInitializer(typeDescription, typeDescription2);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onManifest(manifest);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onResource(str);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onUnresolved(str);
                    }
                }

                public Compound(List<? extends ErrorHandler> list) {
                    this.errorHandlers = new ArrayList();
                    for (ErrorHandler errorHandler : list) {
                        if (errorHandler instanceof Compound) {
                            this.errorHandlers.addAll(((Compound) errorHandler).errorHandlers);
                        } else if (!(errorHandler instanceof Listener.NoOp)) {
                            this.errorHandlers.add(errorHandler);
                        }
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onError(typeDescription, list);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onError(map);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    Iterator<ErrorHandler> it = this.errorHandlers.iterator();
                    while (it.hasNext()) {
                        it.next().onError(plugin, th);
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Enforcing implements ErrorHandler {
                ALL_TYPES_RESOLVED { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.1
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing,
                              // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onUnresolved(String str) {
                        throw new IllegalStateException(yg.concat("Failed to resolve type description for ", str));
                    }
                },
                NO_LIVE_INITIALIZERS { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.2
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing,
                              // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                        throw new IllegalStateException("Failed to instrument " + typeDescription
                                + " due to live initializer for " + typeDescription2);
                    }
                },
                CLASS_FILES_ONLY { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.3
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing,
                              // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onResource(String str) {
                        throw new IllegalStateException(
                                yg.concat("Discovered a resource when only class files were allowed: ", str));
                    }
                },
                MANIFEST_REQUIRED { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing.4
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler.Enforcing,
                              // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onManifest(@MaybeNull Manifest manifest) {
                        if (manifest == null) {
                            throw new IllegalStateException("Required a manifest but no manifest was found");
                        }
                    }
                };

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Failing implements ErrorHandler {
                FAIL_FAST { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Failing.1
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                        throw new IllegalStateException("Failed to transform " + typeDescription + " using " + plugin,
                                th);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                        throw new IllegalStateException("Failed to transform " + typeDescription + ": " + list);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new IllegalStateException("Failed to transform at least one type: " + map);
                    }
                },
                FAIL_AFTER_TYPE { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Failing.2
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                        throw new IllegalStateException("Failed to transform " + typeDescription + ": " + list);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new IllegalStateException("Failed to transform at least one type: " + map);
                    }
                },
                FAIL_LAST { // from class: net.bytebuddy.build.Plugin.Engine.ErrorHandler.Failing.3
                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                    public void onError(Map<TypeDescription, List<Throwable>> map) {
                        throw new IllegalStateException("Failed to transform at least one type: " + map);
                    }
                };

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    throw new IllegalStateException("Failed to close plugin " + plugin, th);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(Manifest manifest) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                }
            }

            void onError(Map<TypeDescription, List<Throwable>> map);

            void onError(Plugin plugin, Throwable th);

            void onError(TypeDescription typeDescription, List<Throwable> list);

            void onError(TypeDescription typeDescription, Plugin plugin, Throwable th);

            void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2);

            void onManifest(@MaybeNull Manifest manifest);

            void onResource(String str);

            void onUnresolved(String str);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface PoolStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Default implements PoolStrategy {
                FAST(TypePool.Default.ReaderMode.FAST),
                EXTENDED(TypePool.Default.ReaderMode.EXTENDED);

                private final TypePool.Default.ReaderMode readerMode;

                Default(TypePool.Default.ReaderMode readerMode) {
                    this.readerMode = readerMode;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.PoolStrategy
                public TypePool typePool(ClassFileLocator classFileLocator) {
                    return new TypePool.Default.WithLazyResolution(new TypePool.CacheProvider.Simple(),
                            classFileLocator, this.readerMode, TypePool.ClassLoading.ofPlatformLoader());
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Eager implements PoolStrategy {
                FAST(TypePool.Default.ReaderMode.FAST),
                EXTENDED(TypePool.Default.ReaderMode.EXTENDED);

                private final TypePool.Default.ReaderMode readerMode;

                Eager(TypePool.Default.ReaderMode readerMode) {
                    this.readerMode = readerMode;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.PoolStrategy
                public TypePool typePool(ClassFileLocator classFileLocator) {
                    return new TypePool.Default(new TypePool.CacheProvider.Simple(), classFileLocator, this.readerMode,
                            TypePool.ClassLoading.ofPlatformLoader());
                }
            }

            TypePool typePool(ClassFileLocator classFileLocator);
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Source {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Source {
                private final Collection<? extends Source> sources;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Origin implements Origin {
                    private final List<Origin> origins;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class CompoundIterator implements Iterator<Element> {
                        private final Queue<? extends Iterable<? extends Element>> backlog;

                        @MaybeNull
                        private Iterator<? extends Element> current;

                        public CompoundIterator(List<? extends Iterable<? extends Element>> list) {
                            this.backlog = QueueFactory.make(list);
                            forward();
                        }

                        private void forward() {
                            while (true) {
                                Iterator<? extends Element> it = this.current;
                                if ((it != null && it.hasNext()) || this.backlog.isEmpty()) {
                                    return;
                                } else {
                                    this.current = this.backlog.remove().iterator();
                                }
                            }
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            Iterator<? extends Element> it = this.current;
                            return it != null && it.hasNext();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        @Override // java.util.Iterator
                        public Element next() {
                            try {
                                Iterator<? extends Element> it = this.current;
                                if (it == null) {
                                    throw new NoSuchElementException();
                                }
                                Element next = it.next();
                                forward();
                                return next;
                            } catch (Throwable th) {
                                forward();
                                throw th;
                            }
                        }
                    }

                    public Origin(List<Origin> list) {
                        this.origins = list;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        Iterator<Origin> it = this.origins.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.origins.equals(((Origin) obj).origins);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    public Manifest getManifest() {
                        Iterator<Origin> it = this.origins.iterator();
                        while (it.hasNext()) {
                            Manifest manifest = it.next().getManifest();
                            if (manifest != null) {
                                return manifest;
                            }
                        }
                        return Origin.NO_MANIFEST;
                    }

                    public int hashCode() {
                        return this.origins.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // java.lang.Iterable
                    public Iterator<Element> iterator() {
                        return new CompoundIterator(this.origins);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                        ArrayList arrayList = new ArrayList(this.origins.size());
                        Iterator<Origin> it = this.origins.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().toClassFileLocator(classFileVersion));
                        }
                        return new ClassFileLocator.Compound(arrayList);
                    }
                }

                public Compound(Collection<? extends Source> collection) {
                    this.sources = collection;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.sources.equals(((Compound) obj).sources);
                }

                public int hashCode() {
                    return this.sources.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() throws IOException {
                    if (this.sources.isEmpty()) {
                        return Empty.INSTANCE;
                    }
                    if (this.sources.size() == 1) {
                        return this.sources.iterator().next().read();
                    }
                    ArrayList arrayList = new ArrayList(this.sources.size());
                    try {
                        Iterator<? extends Source> it = this.sources.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().read());
                        }
                        return new Origin(arrayList);
                    } catch (IOException e) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((Origin) it2.next()).close();
                        }
                        throw e;
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Element {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForByteArray implements Element {
                    private final byte[] binaryRepresentation;
                    private final String name;

                    public ForByteArray(String str, byte[] bArr) {
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
                        ForByteArray forByteArray = (ForByteArray) obj;
                        return this.name.equals(forByteArray.name)
                                && Arrays.equals(this.binaryRepresentation, forByteArray.binaryRepresentation);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public InputStream getInputStream() {
                        return new ByteArrayInputStream(this.binaryRepresentation);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public String getName() {
                        return this.name;
                    }

                    public int hashCode() {
                        return Arrays.hashCode(this.binaryRepresentation)
                                + bjs.e(this.name, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    @AlwaysNull
                    public <T> T resolveAs(Class<T> cls) {
                        return null;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForFile implements Element {
                    private final File file;
                    private final File root;

                    public ForFile(File file, File file2) {
                        this.root = file;
                        this.file = file2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForFile forFile = (ForFile) obj;
                        return this.root.equals(forFile.root) && this.file.equals(forFile.file);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public InputStream getInputStream() {
                        return new FileInputStream(this.file);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public String getName() {
                        return this.root.getAbsoluteFile().toURI().relativize(this.file.getAbsoluteFile().toURI())
                                .getPath();
                    }

                    public int hashCode() {
                        return this.file.hashCode() + ((this.root.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    @MaybeNull
                    public <T> T resolveAs(Class<T> cls) {
                        if (File.class.isAssignableFrom(cls)) {
                            return (T) this.file;
                        }
                        return null;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForJarEntry implements Element {
                    private final JarEntry entry;
                    private final JarFile file;

                    public ForJarEntry(JarFile jarFile, JarEntry jarEntry) {
                        this.file = jarFile;
                        this.entry = jarEntry;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForJarEntry forJarEntry = (ForJarEntry) obj;
                        return this.file.equals(forJarEntry.file) && this.entry.equals(forJarEntry.entry);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public InputStream getInputStream() {
                        return this.file.getInputStream(this.entry);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    public String getName() {
                        return this.entry.getName();
                    }

                    public int hashCode() {
                        return this.entry.hashCode() + ((this.file.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Element
                    @MaybeNull
                    public <T> T resolveAs(Class<T> cls) {
                        if (JarEntry.class.isAssignableFrom(cls)) {
                            return (T) this.entry;
                        }
                        return null;
                    }
                }

                InputStream getInputStream();

                String getName();

                @MaybeNull
                <T> T resolveAs(Class<T> cls);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Empty implements Source, Origin {
                INSTANCE;

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                @MaybeNull
                public Manifest getManifest() {
                    return Origin.NO_MANIFEST;
                }

                @Override // java.lang.Iterable
                public Iterator<Element> iterator() {
                    return Collections.EMPTY_SET.iterator();
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() {
                    return this;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                    return ClassFileLocator.NoOp.INSTANCE;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Filtering implements Source {
                private final Source delegate;
                private final boolean manifest;
                private final ElementMatcher<Element> matcher;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class MultiReleaseVersionMatcher implements ElementMatcher<Element> {
                    private final ClassFileVersion classFileVersion;

                    public MultiReleaseVersionMatcher(ClassFileVersion classFileVersion) {
                        this.classFileVersion = classFileVersion;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass()
                                && this.classFileVersion.equals(((MultiReleaseVersionMatcher) obj).classFileVersion);
                    }

                    public int hashCode() {
                        return this.classFileVersion.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.matcher.ElementMatcher
                    public boolean matches(@MaybeNull Element element) {
                        if (element == null) {
                            return true;
                        }
                        String name = element.getName();
                        if (name.startsWith("/")) {
                            name = name.substring(1);
                        }
                        if (name.startsWith(ClassFileLocator.META_INF_VERSIONS)) {
                            try {
                                return Integer.parseInt(name.substring(18,
                                        name.indexOf(47, 18))) <= this.classFileVersion.getJavaVersion();
                            } catch (NumberFormatException unused) {
                            }
                        }
                        return true;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public enum NoFolderMatcher implements ElementMatcher<Element> {
                    INSTANCE;

                    @Override // net.bytebuddy.matcher.ElementMatcher
                    public boolean matches(@MaybeNull Element element) {
                        return element == null || !element.getName().endsWith("/");
                    }
                }

                public Filtering(Source source, ElementMatcher<Element> elementMatcher) {
                    this(source, elementMatcher, true);
                }

                public static Source dropFolders(Source source) {
                    return new Filtering(source, NoFolderMatcher.INSTANCE);
                }

                public static Source dropMultiReleaseClassFilesAbove(Source source, ClassFileVersion classFileVersion) {
                    return new Filtering(source, new MultiReleaseVersionMatcher(classFileVersion));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    Filtering filtering = (Filtering) obj;
                    return this.manifest == filtering.manifest && this.delegate.equals(filtering.delegate)
                            && this.matcher.equals(filtering.matcher);
                }

                public int hashCode() {
                    return StaticHelpers6.i(this.matcher, (this.delegate.hashCode() + (getClass().hashCode() * 31)) * 31, 31)
                            + (this.manifest ? 1 : 0);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() {
                    return new Origin.Filtering(this.delegate.read(), this.matcher, this.manifest);
                }

                public Filtering(Source source, ElementMatcher<Element> elementMatcher, boolean z) {
                    this.delegate = source;
                    this.matcher = elementMatcher;
                    this.manifest = z;
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFolder implements Source, Origin {
                private final File folder;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public class FolderIterator implements Iterator<Element> {
                    private final Queue<File> files = QueueFactory.make();

                    public FolderIterator(File file) {
                        File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles != null) {
                            for (File file2 : fileArrListFiles) {
                                if (!file2.equals(new File(file, "META-INF/MANIFEST.MF"))) {
                                    this.files.add(file2);
                                }
                            }
                        }
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return !this.files.isEmpty();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove");
                    }

                    @Override // java.util.Iterator
                    public Element next() {
                        File[] fileArrListFiles;
                        File fileRemove = this.files.remove();
                        if (fileRemove.isDirectory() && (fileArrListFiles = fileRemove.listFiles()) != null) {
                            for (File file : fileArrListFiles) {
                                if (!file.equals(new File(ForFolder.this.folder, "META-INF/MANIFEST.MF"))) {
                                    this.files.add(file);
                                }
                            }
                        }
                        return new Element.ForFile(ForFolder.this.folder, fileRemove);
                    }
                }

                public ForFolder(File file) {
                    this.folder = file;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.folder.equals(((ForFolder) obj).folder);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                @MaybeNull
                public Manifest getManifest() throws IOException {
                    File file = new File(this.folder, "META-INF/MANIFEST.MF");
                    if (!file.exists()) {
                        return Origin.NO_MANIFEST;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        return new Manifest(fileInputStream);
                    } finally {
                        fileInputStream.close();
                    }
                }

                public int hashCode() {
                    return this.folder.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // java.lang.Iterable
                public Iterator<Element> iterator() {
                    return new FolderIterator(this.folder);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() {
                    return this;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                    return classFileVersion == null ? new ClassFileLocator.ForFolder(this.folder)
                            : ClassFileLocator.ForFolder.of(this.folder, classFileVersion);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForJarFile implements Source {
                private final File file;

                public ForJarFile(File file) {
                    this.file = file;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.file.equals(((ForJarFile) obj).file);
                }

                public int hashCode() {
                    return this.file.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() {
                    return new Origin.ForJarFile(new JarFile(this.file, false));
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class InMemory implements Source, Origin {
                private final Map<String, byte[]> storage;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class MapEntryIterator implements Iterator<Element> {
                    private final Iterator<Map.Entry<String, byte[]>> iterator;

                    public MapEntryIterator(Iterator<Map.Entry<String, byte[]>> it) {
                        this.iterator = it;
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.iterator.hasNext();
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException("remove");
                    }

                    @Override // java.util.Iterator
                    public Element next() {
                        Map.Entry<String, byte[]> next = this.iterator.next();
                        return new Element.ForByteArray(next.getKey(), next.getValue());
                    }
                }

                public InMemory(Map<String, byte[]> map) {
                    this.storage = map;
                }

                public static Source ofTypes(Class<?>... clsArr) {
                    return ofTypes(Arrays.asList(clsArr));
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.storage.equals(((InMemory) obj).storage);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                @MaybeNull
                public Manifest getManifest() {
                    byte[] bArr = this.storage.get("META-INF/MANIFEST.MF");
                    return bArr == null ? Origin.NO_MANIFEST : new Manifest(new ByteArrayInputStream(bArr));
                }

                public int hashCode() {
                    return this.storage.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // java.lang.Iterable
                public Iterator<Element> iterator() {
                    return new MapEntryIterator(this.storage.entrySet().iterator());
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source
                public Origin read() {
                    return this;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                    return ClassFileLocator.Simple.ofResources(this.storage);
                }

                public static Source ofTypes(Collection<? extends Class<?>> collection) {
                    return ofTypes(collection,
                            (Map<ClassFileVersion, Collection<? extends Class<?>>>) Collections.EMPTY_MAP);
                }

                public static Source ofTypes(Collection<? extends Class<?>> collection,
                        Map<ClassFileVersion, Collection<? extends Class<?>>> map) {
                    HashMap map2 = new HashMap();
                    for (Map.Entry<ClassFileVersion, Collection<? extends Class<?>>> entry : map.entrySet()) {
                        HashMap map3 = new HashMap();
                        for (Class<?> cls : entry.getValue()) {
                            map3.put(TypeDescription.ForLoadedType.of(cls), ClassFileLocator.ForClassLoader.read(cls));
                        }
                        map2.put(entry.getKey(), map3);
                    }
                    HashMap map4 = new HashMap();
                    for (Class<?> cls2 : collection) {
                        map4.put(TypeDescription.ForLoadedType.of(cls2), ClassFileLocator.ForClassLoader.read(cls2));
                    }
                    return ofTypes(map4, map2);
                }

                public static Source ofTypes(Map<TypeDescription, byte[]> map) {
                    return ofTypes(map, (Map<ClassFileVersion, Map<TypeDescription, byte[]>>) Collections.EMPTY_MAP);
                }

                public static Source ofTypes(Map<TypeDescription, byte[]> map,
                        Map<ClassFileVersion, Map<TypeDescription, byte[]>> map2) {
                    HashMap map3 = new HashMap();
                    for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                        map3.put(entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION,
                                entry.getValue());
                    }
                    for (Map.Entry<ClassFileVersion, Map<TypeDescription, byte[]>> entry2 : map2.entrySet()) {
                        for (Map.Entry<TypeDescription, byte[]> entry3 : entry2.getValue().entrySet()) {
                            map3.put(
                                    ClassFileLocator.META_INF_VERSIONS + entry2.getKey().getJavaVersion() + "/"
                                            + entry3.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION,
                                    entry3.getValue());
                        }
                    }
                    return new InMemory(map3);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Origin extends Iterable<Element>, Closeable {

                @AlwaysNull
                public static final Manifest NO_MANIFEST = null;

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Filtering implements Origin {
                    private final Origin delegate;
                    private final boolean manifest;
                    private final ElementMatcher<Element> matcher;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public static class FilteringIterator implements Iterator<Element> {

                        @MaybeNull
                        private Element current;
                        private final Iterator<Element> iterator;
                        private final ElementMatcher<Element> matcher;

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return this.current != null;
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            this.iterator.remove();
                        }

                        private FilteringIterator(Iterator<Element> it, ElementMatcher<Element> elementMatcher) {
                            this.iterator = it;
                            this.matcher = elementMatcher;
                            while (it.hasNext()) {
                                Element next = it.next();
                                if (elementMatcher.matches(next)) {
                                    this.current = next;
                                    return;
                                }
                            }
                        }

                        @Override // java.util.Iterator
                        public Element next() {
                            Element element = this.current;
                            if (element == null) {
                                throw new NoSuchElementException();
                            }
                            this.current = null;
                            while (this.iterator.hasNext()) {
                                Element next = this.iterator.next();
                                if (this.matcher.matches(next)) {
                                    this.current = next;
                                    break;
                                }
                            }
                            return element;
                        }
                    }

                    public Filtering(Origin origin, ElementMatcher<Element> elementMatcher) {
                        this(origin, elementMatcher, true);
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        this.delegate.close();
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Filtering filtering = (Filtering) obj;
                        return this.manifest == filtering.manifest && this.delegate.equals(filtering.delegate)
                                && this.matcher.equals(filtering.matcher);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    @MaybeNull
                    public Manifest getManifest() {
                        return this.manifest ? this.delegate.getManifest() : Origin.NO_MANIFEST;
                    }

                    public int hashCode() {
                        return StaticHelpers6.i(this.matcher, (this.delegate.hashCode() + (getClass().hashCode() * 31)) * 31, 31)
                                + (this.manifest ? 1 : 0);
                    }

                    @Override // java.lang.Iterable
                    public Iterator<Element> iterator() {
                        return new FilteringIterator(this.delegate.iterator(), this.matcher);
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                        return this.delegate.toClassFileLocator(classFileVersion);
                    }

                    public Filtering(Origin origin, ElementMatcher<Element> elementMatcher, boolean z) {
                        this.delegate = origin;
                        this.matcher = elementMatcher;
                        this.manifest = z;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForJarFile implements Origin {
                    private final JarFile file;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public class JarFileIterator implements Iterator<Element> {
                        private final Enumeration<JarEntry> enumeration;

                        public JarFileIterator(Enumeration<JarEntry> enumeration) {
                            this.enumeration = enumeration;
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return this.enumeration.hasMoreElements();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            throw new UnsupportedOperationException("remove");
                        }

                        @Override // java.util.Iterator
                        public Element next() {
                            return new Element.ForJarEntry(ForJarFile.this.file, this.enumeration.nextElement());
                        }
                    }

                    public ForJarFile(JarFile jarFile) {
                        this.file = jarFile;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        this.file.close();
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    @MaybeNull
                    public Manifest getManifest() {
                        return this.file.getManifest();
                    }

                    @Override // java.lang.Iterable
                    public Iterator<Element> iterator() {
                        return new JarFileIterator(this.file.entries());
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Source.Origin
                    public ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion) {
                        return classFileVersion == null ? new ClassFileLocator.ForJarFile(this.file)
                                : ClassFileLocator.ForJarFile.of(this.file, classFileVersion);
                    }
                }

                @MaybeNull
                Manifest getManifest();

                ClassFileLocator toClassFileLocator(@MaybeNull ClassFileVersion classFileVersion);
            }

            Origin read();
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public static class Summary {
            private final Map<TypeDescription, List<Throwable>> failed;
            private final List<TypeDescription> transformed;
            private final List<String> unresolved;

            public Summary(List<TypeDescription> list, Map<TypeDescription, List<Throwable>> map, List<String> list2) {
                this.transformed = list;
                this.failed = map;
                this.unresolved = list2;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && getClass() == obj.getClass()) {
                    Summary summary = (Summary) obj;
                    if (this.transformed.equals(summary.transformed) && this.failed.equals(summary.failed)
                            && this.unresolved.equals(summary.unresolved)) {
                        return true;
                    }
                }
                return false;
            }

            public Map<TypeDescription, List<Throwable>> getFailed() {
                return this.failed;
            }

            public List<TypeDescription> getTransformed() {
                return this.transformed;
            }

            public List<String> getUnresolved() {
                return this.unresolved;
            }

            public int hashCode() {
                return this.unresolved.hashCode()
                        + ((this.failed.hashCode() + (this.transformed.hashCode() * 31)) * 31);
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface TypeStrategy {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Default implements TypeStrategy {
                REDEFINE { // from class: net.bytebuddy.build.Plugin.Engine.TypeStrategy.Default.1
                    @Override // net.bytebuddy.build.Plugin.Engine.TypeStrategy
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription,
                            ClassFileLocator classFileLocator) {
                        return byteBuddy.redefine(typeDescription, classFileLocator);
                    }
                },
                REBASE { // from class: net.bytebuddy.build.Plugin.Engine.TypeStrategy.Default.2
                    @Override // net.bytebuddy.build.Plugin.Engine.TypeStrategy
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription,
                            ClassFileLocator classFileLocator) {
                        return byteBuddy.rebase(typeDescription, classFileLocator);
                    }
                },
                DECORATE { // from class: net.bytebuddy.build.Plugin.Engine.TypeStrategy.Default.3
                    @Override // net.bytebuddy.build.Plugin.Engine.TypeStrategy
                    public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription,
                            ClassFileLocator classFileLocator) {
                        return byteBuddy.decorate(typeDescription, classFileLocator);
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForEntryPoint implements TypeStrategy {
                private final EntryPoint entryPoint;
                private final MethodNameTransformer methodNameTransformer;

                public ForEntryPoint(EntryPoint entryPoint, MethodNameTransformer methodNameTransformer) {
                    this.entryPoint = entryPoint;
                    this.methodNameTransformer = methodNameTransformer;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.TypeStrategy
                public DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription,
                        ClassFileLocator classFileLocator) {
                    return this.entryPoint.transform(typeDescription, byteBuddy, classFileLocator,
                            this.methodNameTransformer);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForEntryPoint forEntryPoint = (ForEntryPoint) obj;
                    return this.entryPoint.equals(forEntryPoint.entryPoint)
                            && this.methodNameTransformer.equals(forEntryPoint.methodNameTransformer);
                }

                public int hashCode() {
                    return this.methodNameTransformer.hashCode()
                            + ((this.entryPoint.hashCode() + (getClass().hashCode() * 31)) * 31);
                }
            }

            DynamicType.Builder<?> builder(ByteBuddy byteBuddy, TypeDescription typeDescription,
                    ClassFileLocator classFileLocator);
        }

        Summary apply(File file, File file2, List<? extends Factory> list);

        Summary apply(File file, File file2, Factory... factoryArr);

        Summary apply(Source source, Target target, List<? extends Factory> list);

        Summary apply(Source source, Target target, Factory... factoryArr);

        Engine ignore(ElementMatcher<? super TypeDescription> elementMatcher);

        Engine with(ByteBuddy byteBuddy);

        Engine with(@MaybeNull ClassFileVersion classFileVersion);

        Engine with(Dispatcher.Factory factory);

        Engine with(Listener listener);

        Engine with(PoolStrategy poolStrategy);

        Engine with(TypeStrategy typeStrategy);

        Engine with(ClassFileLocator classFileLocator);

        Engine withErrorHandlers(List<? extends ErrorHandler> list);

        Engine withErrorHandlers(ErrorHandler... errorHandlerArr);

        Engine withParallelTransformation(int i);

        Engine withoutErrorHandlers();

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Target {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum Discarding implements Target, Sink {
                INSTANCE;

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void retain(Source.Element element) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(Map<TypeDescription, byte[]> map) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target
                public Sink write(@MaybeNull Manifest manifest) {
                    return this;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(ClassFileVersion classFileVersion, Map<TypeDescription, byte[]> map) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForFolder implements Target, Sink {
                private final File folder;
                private final boolean link;

                public ForFolder(File file) {
                    this(file, false);
                }

                private static void doStore(File file, Map<TypeDescription, byte[]> map) throws IOException {
                    for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                        File file2 = new File(file,
                                entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION);
                        if (!file2.getParentFile().isDirectory() && !file2.getParentFile().mkdirs()) {
                            throw new IOException("Could not create directory: " + file2.getParent());
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            fileOutputStream.write(entry.getValue());
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            fileOutputStream.close();
                            throw th;
                        }
                    }
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForFolder forFolder = (ForFolder) obj;
                    return this.link == forFolder.link && this.folder.equals(forFolder.folder);
                }

                public int hashCode() {
                    return ((this.folder.hashCode() + (getClass().hashCode() * 31)) * 31) + (this.link ? 1 : 0);
                }

                /*
                 * JADX WARN: Undo finally extract visitor
                 * java.lang.NullPointerException: Cannot invoke
                 * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
                 * "finallyBlockTerminus" is null
                 * at
                 * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
                 * (TraverserActivePathState.java:253)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
                 * MarkFinallyVisitor.java:422)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
                 * MarkFinallyVisitor.java:302)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
                 * MarkFinallyVisitor.java:222)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
                 * java:150)
                 */
                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void retain(Source.Element element) throws IOException {
                    String name = element.getName();
                    File file = new File(this.folder, name);
                    if (name.endsWith("/")) {
                        if (file.isDirectory() || file.mkdirs()) {
                            return;
                        }
                        throw new IllegalStateException("Cannot create requested directory: " + file);
                    }
                    File file2 = (File) element.resolveAs(File.class);
                    if (!file.getCanonicalPath().startsWith(this.folder.getCanonicalPath() + File.separatorChar)) {
                        throw new IllegalArgumentException(file + " is not a subdirectory of " + this.folder);
                    }
                    if (!file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
                        throw new IOException("Could not create directory: " + file.getParent());
                    }
                    if (file2 != null && !file2.equals(file)) {
                        if (this.link) {
                            FileSystem.getInstance().link(file2, file);
                            return;
                        } else {
                            FileSystem.getInstance().copy(file2, file);
                            return;
                        }
                    }
                    if (file.equals(file2)) {
                        return;
                    }
                    InputStream inputStream = element.getInputStream();
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    fileOutputStream.close();
                                    inputStream.close();
                                    return;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th) {
                            fileOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        inputStream.close();
                        throw th2;
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(Map<TypeDescription, byte[]> map) throws IOException {
                    doStore(this.folder, map);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target
                public Sink write(@MaybeNull Manifest manifest) throws IOException {
                    if (manifest == null) {
                        return this;
                    }
                    File file = new File(this.folder, "META-INF/MANIFEST.MF");
                    if (!file.getParentFile().isDirectory() && !file.getParentFile().mkdirs()) {
                        throw new IOException("Could not create directory: " + file.getParent());
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        manifest.write(fileOutputStream);
                        return this;
                    } finally {
                        fileOutputStream.close();
                    }
                }

                public ForFolder(File file, boolean z) {
                    this.folder = file;
                    this.link = z;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(ClassFileVersion classFileVersion, Map<TypeDescription, byte[]> map)
                        throws IOException {
                    doStore(new File(this.folder,
                            ClassFileLocator.META_INF_VERSIONS + classFileVersion.getJavaVersion()), map);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForJarFile implements Target {
                private final File file;

                public ForJarFile(File file) {
                    this.file = file;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.file.equals(((ForJarFile) obj).file);
                }

                public int hashCode() {
                    return this.file.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target
                public Sink write(@MaybeNull Manifest manifest) throws IOException {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.file);
                    try {
                        return manifest == null ? new Sink.ForJarOutputStream(new JarOutputStream(fileOutputStream))
                                : new Sink.ForJarOutputStream(new JarOutputStream(fileOutputStream, manifest));
                    } catch (IOException e) {
                        fileOutputStream.close();
                        throw e;
                    } catch (Error e2) {
                        fileOutputStream.close();
                        throw e2;
                    } catch (RuntimeException e3) {
                        fileOutputStream.close();
                        throw e3;
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class InMemory implements Target, Sink {

                @HashCodeAndEqualsPlugin.Identity
                private final Map<String, byte[]> storage;

                public InMemory() {
                    this(new HashMap());
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.storage == ((InMemory) obj).storage;
                }

                public Map<String, byte[]> getStorage() {
                    return this.storage;
                }

                public int hashCode() {
                    return System.identityHashCode(this.storage) + (getClass().hashCode() * 31);
                }

                /*
                 * JADX WARN: Undo finally extract visitor
                 * java.lang.NullPointerException: Cannot invoke
                 * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
                 * "finallyBlockTerminus" is null
                 * at
                 * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
                 * (TraverserActivePathState.java:253)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
                 * MarkFinallyVisitor.java:422)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
                 * MarkFinallyVisitor.java:302)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
                 * MarkFinallyVisitor.java:222)
                 * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
                 * java:150)
                 */
                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void retain(Source.Element element) throws IOException {
                    if (element.getName().endsWith("/")) {
                        return;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        InputStream inputStream = element.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    inputStream.close();
                                    byteArrayOutputStream.close();
                                    this.storage.put(element.getName(), byteArrayOutputStream.toByteArray());
                                    return;
                                }
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        } catch (Throwable th) {
                            inputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        byteArrayOutputStream.close();
                        throw th2;
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(Map<TypeDescription, byte[]> map) {
                    for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                        this.storage.put(entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION,
                                entry.getValue());
                    }
                }

                public Map<String, byte[]> toTypeMap() {
                    HashMap map = new HashMap();
                    for (Map.Entry<String, byte[]> entry : this.storage.entrySet()) {
                        if (entry.getKey().endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)
                                && !entry.getKey().startsWith(ClassFileLocator.META_INF_VERSIONS)) {
                            map.put(entry.getKey().substring(0, entry.getKey().length() - 6).replace('/',
                                    TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH),
                                    entry.getValue());
                        }
                    }
                    return map;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target
                public Sink write(@MaybeNull Manifest manifest) throws IOException {
                    if (manifest == null) {
                        return this;
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        manifest.write(byteArrayOutputStream);
                        byteArrayOutputStream.close();
                        this.storage.put("META-INF/MANIFEST.MF", byteArrayOutputStream.toByteArray());
                        return this;
                    } catch (Throwable th) {
                        byteArrayOutputStream.close();
                        throw th;
                    }
                }

                public InMemory(Map<String, byte[]> map) {
                    this.storage = map;
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                public void store(ClassFileVersion classFileVersion, Map<TypeDescription, byte[]> map) {
                    for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                        this.storage.put(
                                ClassFileLocator.META_INF_VERSIONS + classFileVersion.getJavaVersion() + "/"
                                        + entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION,
                                entry.getValue());
                    }
                }

                public Map<String, byte[]> toTypeMap(ClassFileVersion classFileVersion) {
                    String key;
                    int i;
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    for (Map.Entry<String, byte[]> entry : this.storage.entrySet()) {
                        if (entry.getKey().endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                            if (entry.getKey().startsWith(ClassFileLocator.META_INF_VERSIONS)) {
                                key = entry.getKey().substring(entry.getKey().indexOf(47, 18) + 1);
                                try {
                                    i = Integer.parseInt(entry.getKey().substring(18, entry.getKey().indexOf(47, 18)));
                                    if (i < 7 || i > classFileVersion.getJavaVersion()) {
                                    }
                                } catch (NumberFormatException unused) {
                                }
                            } else {
                                key = entry.getKey();
                                i = 0;
                            }
                            Integer num = (Integer) map2.get(key);
                            if (num == null || num.intValue() < i) {
                                map2.put(key, Integer.valueOf(i));
                                map.put(key.substring(0, key.length() - 6).replace('/',
                                        TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH),
                                        entry.getValue());
                            }
                        }
                    }
                    return map;
                }
            }

            Sink write(@MaybeNull Manifest manifest);

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Sink extends Closeable {
                void retain(Source.Element element);

                void store(Map<TypeDescription, byte[]> map);

                void store(ClassFileVersion classFileVersion, Map<TypeDescription, byte[]> map);

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public static class ForJarOutputStream implements Sink {
                    private final JarOutputStream outputStream;

                    public ForJarOutputStream(JarOutputStream jarOutputStream) {
                        this.outputStream = jarOutputStream;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public void close() throws IOException {
                        this.outputStream.close();
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                    public void retain(Source.Element element) throws IOException {
                        JarEntry jarEntry = (JarEntry) element.resolveAs(JarEntry.class);
                        String name = element.getName();
                        this.outputStream.putNextEntry(jarEntry == null ? new JarEntry(name) : jarEntry);
                        if (jarEntry != null || !name.endsWith("/")) {
                            InputStream inputStream = element.getInputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        this.outputStream.write(bArr, 0, i);
                                    }
                                }
                                inputStream.close();
                            } catch (Throwable th) {
                                inputStream.close();
                                throw th;
                            }
                        }
                        this.outputStream.closeEntry();
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                    public void store(Map<TypeDescription, byte[]> map) throws IOException {
                        for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                            this.outputStream.putNextEntry(new JarEntry(
                                    entry.getKey().getInternalName() + ClassFileLocator.CLASS_FILE_EXTENSION));
                            this.outputStream.write(entry.getValue());
                            this.outputStream.closeEntry();
                        }
                    }

                    @Override // net.bytebuddy.build.Plugin.Engine.Target.Sink
                    public void store(ClassFileVersion classFileVersion, Map<TypeDescription, byte[]> map)
                            throws IOException {
                        for (Map.Entry<TypeDescription, byte[]> entry : map.entrySet()) {
                            this.outputStream.putNextEntry(new JarEntry(ClassFileLocator.META_INF_VERSIONS
                                    + classFileVersion.getJavaVersion() + "/" + entry.getKey().getInternalName()
                                    + ClassFileLocator.CLASS_FILE_EXTENSION));
                            this.outputStream.write(entry.getValue());
                            this.outputStream.closeEntry();
                        }
                    }
                }
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public interface Listener extends ErrorHandler {

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public static abstract class Adapter implements Listener {
                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onComplete(TypeDescription typeDescription) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onDiscovery(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class Compound implements Listener {
                private final List<Listener> listeners;

                public Compound(Listener... listenerArr) {
                    this((List<? extends Listener>) Arrays.asList(listenerArr));
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.listeners.equals(((Compound) obj).listeners);
                }

                public int hashCode() {
                    return this.listeners.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onComplete(TypeDescription typeDescription) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onComplete(typeDescription);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onDiscovery(String str) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onDiscovery(str);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onError(typeDescription, plugin, th);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onIgnored(typeDescription, plugin);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onLiveInitializer(typeDescription, typeDescription2);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onManifest(manifest);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onResource(str);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onTransformation(typeDescription, plugin);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onUnresolved(str);
                    }
                }

                public Compound(List<? extends Listener> list) {
                    this.listeners = new ArrayList();
                    for (Listener listener : list) {
                        if (listener instanceof Compound) {
                            this.listeners.addAll(((Compound) listener).listeners);
                        } else if (!(listener instanceof NoOp)) {
                            this.listeners.add(listener);
                        }
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onError(typeDescription, list);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onIgnored(typeDescription, list);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onTransformation(typeDescription, list);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onError(map);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    Iterator<Listener> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        it.next().onError(plugin, th);
                    }
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForErrorHandler extends Adapter {
                private final ErrorHandler errorHandler;

                public ForErrorHandler(ErrorHandler errorHandler) {
                    this.errorHandler = errorHandler;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.errorHandler.equals(((ForErrorHandler) obj).errorHandler);
                }

                public int hashCode() {
                    return this.errorHandler.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    this.errorHandler.onError(typeDescription, plugin, th);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    this.errorHandler.onLiveInitializer(typeDescription, typeDescription2);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                    this.errorHandler.onManifest(manifest);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                    this.errorHandler.onResource(str);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                    this.errorHandler.onUnresolved(str);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.errorHandler.onError(typeDescription, list);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.errorHandler.onError(map);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    this.errorHandler.onError(plugin, th);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public enum NoOp implements Listener {
                INSTANCE;

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onComplete(TypeDescription typeDescription) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onDiscovery(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, List<Plugin> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                }

                @Override // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class WithErrorsOnly extends Adapter {
                private final Listener delegate;

                public WithErrorsOnly(Listener listener) {
                    this.delegate = listener;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.delegate.equals(((WithErrorsOnly) obj).delegate);
                }

                public int hashCode() {
                    return this.delegate.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    this.delegate.onError(typeDescription, plugin, th);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.delegate.onError(typeDescription, list);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.delegate.onError(map);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    this.delegate.onError(plugin, th);
                }
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class WithTransformationsOnly extends Adapter {
                private final Listener delegate;

                public WithTransformationsOnly(Listener listener) {
                    this.delegate = listener;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.delegate.equals(((WithTransformationsOnly) obj).delegate);
                }

                public int hashCode() {
                    return this.delegate.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    this.delegate.onError(typeDescription, plugin, th);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    this.delegate.onTransformation(typeDescription, plugin);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, List<Throwable> list) {
                    this.delegate.onError(typeDescription, list);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, List<Plugin> list) {
                    this.delegate.onTransformation(typeDescription, list);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Map<TypeDescription, List<Throwable>> map) {
                    this.delegate.onError(map);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    this.delegate.onError(plugin, th);
                }
            }

            void onComplete(TypeDescription typeDescription);

            void onDiscovery(String str);

            void onIgnored(TypeDescription typeDescription, List<Plugin> list);

            void onIgnored(TypeDescription typeDescription, Plugin plugin);

            void onTransformation(TypeDescription typeDescription, List<Plugin> list);

            void onTransformation(TypeDescription typeDescription, Plugin plugin);

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @HashCodeAndEqualsPlugin.Enhance
            public static class StreamWriting extends Adapter {
                protected static final String PREFIX = "[Byte Buddy]";
                private final PrintStream printStream;

                public StreamWriting(PrintStream printStream) {
                    this.printStream = printStream;
                }

                public static StreamWriting toSystemError() {
                    return new StreamWriting(System.err);
                }

                public static StreamWriting toSystemOut() {
                    return new StreamWriting(System.out);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass()
                            && this.printStream.equals(((StreamWriting) obj).printStream);
                }

                public int hashCode() {
                    return this.printStream.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onComplete(TypeDescription typeDescription) {
                    this.printStream.printf("[Byte Buddy] COMPLETE %s", typeDescription);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onDiscovery(String str) {
                    this.printStream.printf("[Byte Buddy] DISCOVERY %s", str);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(TypeDescription typeDescription, Plugin plugin, Throwable th) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] ERROR %s for %s", typeDescription, plugin);
                        th.printStackTrace(this.printStream);
                    }
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onIgnored(TypeDescription typeDescription, Plugin plugin) {
                    this.printStream.printf("[Byte Buddy] IGNORE %s for %s", typeDescription, plugin);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onLiveInitializer(TypeDescription typeDescription, TypeDescription typeDescription2) {
                    this.printStream.printf("[Byte Buddy] LIVE %s on %s", typeDescription, typeDescription2);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onManifest(@MaybeNull Manifest manifest) {
                    this.printStream.printf("[Byte Buddy] MANIFEST %b", Boolean.valueOf(manifest != null));
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onResource(String str) {
                    this.printStream.printf("[Byte Buddy] RESOURCE %s", str);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.Listener
                public void onTransformation(TypeDescription typeDescription, Plugin plugin) {
                    this.printStream.printf("[Byte Buddy] TRANSFORM %s for %s", typeDescription, plugin);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onUnresolved(String str) {
                    this.printStream.printf("[Byte Buddy] UNRESOLVED %s", str);
                }

                public Listener withErrorsOnly() {
                    return new WithErrorsOnly(this);
                }

                public Listener withTransformationsOnly() {
                    return new WithTransformationsOnly(this);
                }

                @Override // net.bytebuddy.build.Plugin.Engine.Listener.Adapter,
                          // net.bytebuddy.build.Plugin.Engine.ErrorHandler
                public void onError(Plugin plugin, Throwable th) {
                    synchronized (this.printStream) {
                        this.printStream.printf("[Byte Buddy] ERROR %s", plugin);
                        th.printStackTrace(this.printStream);
                    }
                }
            }
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Factory {

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Factory {
            private final Plugin plugin;

            public Simple(Plugin plugin) {
                this.plugin = plugin;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.plugin.equals(((Simple) obj).plugin);
            }

            public int hashCode() {
                return this.plugin.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.build.Plugin.Factory
            public Plugin make() {
                return this.plugin;
            }
        }

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        @HashCodeAndEqualsPlugin.Enhance
        public static class UsingReflection implements Factory {
            private final List<ArgumentResolver> argumentResolvers;
            private final Class<? extends Plugin> type;

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface ArgumentResolver {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForIndex implements ArgumentResolver {
                    private static final Map<Class<?>, Class<?>> WRAPPER_TYPES;
                    private final int index;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final Object value;

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class WithDynamicType implements ArgumentResolver {
                        private final int index;

                        @MaybeNull
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final String value;

                        public WithDynamicType(int i, @MaybeNull String str) {
                            this.index = i;
                            this.value = str;
                        }

                        /* JADX WARN: Found duplicated region for block: B:22:0x002e A[RETURN] */
                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            WithDynamicType withDynamicType = (WithDynamicType) obj;
                            if (this.index != withDynamicType.index) {
                                return false;
                            }
                            String str = this.value;
                            String str2 = withDynamicType.value;
                            if (str2 != null) {
                                return str != null && str.equals(str2);
                            }
                            if (str != null) {
                                return false;
                            }
                        }

                        public int hashCode() {
                            int iHashCode = ((getClass().hashCode() * 31) + this.index) * 31;
                            String str = this.value;
                            return str != null ? str.hashCode() + iHashCode : iHashCode;
                        }

                        @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver
                        public Resolution resolve(int i, Class<?> cls) {
                            if (this.index != i) {
                                return Resolution.Unresolved.INSTANCE;
                            }
                            if (cls == Character.TYPE || cls == Character.class) {
                                String str = this.value;
                                return (str == null || str.length() != 1) ? Resolution.Unresolved.INSTANCE
                                        : new Resolution.Resolved(Character.valueOf(this.value.charAt(0)));
                            }
                            if (cls == String.class) {
                                return new Resolution.Resolved(this.value);
                            }
                            if (cls.isPrimitive()) {
                                cls = (Class) ForIndex.WRAPPER_TYPES.get(cls);
                            }
                            try {
                                Method method = cls.getMethod("valueOf", String.class);
                                return (Modifier.isStatic(method.getModifiers())
                                        && cls.isAssignableFrom(method.getReturnType()))
                                                ? new Resolution.Resolved(method.invoke(null, this.value))
                                                : Resolution.Unresolved.INSTANCE;
                            } catch (IllegalAccessException e) {
                                throw new IllegalStateException(e);
                            } catch (NoSuchMethodException unused) {
                                return Resolution.Unresolved.INSTANCE;
                            } catch (InvocationTargetException e2) {
                                throw new IllegalStateException(e2.getTargetException());
                            }
                        }
                    }

                    static {
                        HashMap map = new HashMap();
                        WRAPPER_TYPES = map;
                        map.put(Boolean.TYPE, Boolean.class);
                        map.put(Byte.TYPE, Byte.class);
                        map.put(Short.TYPE, Short.class);
                        map.put(Character.TYPE, Character.class);
                        map.put(Integer.TYPE, Integer.class);
                        map.put(Long.TYPE, Long.class);
                        map.put(Float.TYPE, Float.class);
                        map.put(Double.TYPE, Double.class);
                    }

                    public ForIndex(int i, @MaybeNull Object obj) {
                        this.index = i;
                        this.value = obj;
                    }

                    /* JADX WARN: Found duplicated region for block: B:22:0x002e A[RETURN] */
                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForIndex forIndex = (ForIndex) obj;
                        if (this.index != forIndex.index) {
                            return false;
                        }
                        Object obj2 = this.value;
                        Object obj3 = forIndex.value;
                        if (obj3 != null) {
                            return obj2 != null && obj2.equals(obj3);
                        }
                        if (obj2 != null) {
                            return false;
                        }
                    }

                    public int hashCode() {
                        int iHashCode = ((getClass().hashCode() * 31) + this.index) * 31;
                        Object obj = this.value;
                        return obj != null ? obj.hashCode() + iHashCode : iHashCode;
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver
                    public Resolution resolve(int i, Class<?> cls) {
                        if (this.index != i) {
                            return Resolution.Unresolved.INSTANCE;
                        }
                        if (cls.isPrimitive()) {
                            return WRAPPER_TYPES.get(cls).isInstance(this.value) ? new Resolution.Resolved(this.value)
                                    : Resolution.Unresolved.INSTANCE;
                        }
                        Object obj = this.value;
                        return (obj == null || cls.isInstance(obj)) ? new Resolution.Resolved(this.value)
                                : Resolution.Unresolved.INSTANCE;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForType<T> implements ArgumentResolver {
                    private final Class<? extends T> type;
                    private final T value;

                    public ForType(Class<? extends T> cls, T t) {
                        this.type = cls;
                        this.value = t;
                    }

                    public static <S> ArgumentResolver of(Class<? extends S> cls, S s) {
                        return new ForType(cls, s);
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForType forType = (ForType) obj;
                        return this.type.equals(forType.type) && this.value.equals(forType.value);
                    }

                    public int hashCode() {
                        return this.value.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.type);
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver
                    public Resolution resolve(int i, Class<?> cls) {
                        return cls == this.type ? new Resolution.Resolved(this.value) : Resolution.Unresolved.INSTANCE;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public enum NoOp implements ArgumentResolver {
                    INSTANCE;

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver
                    public Resolution resolve(int i, Class<?> cls) {
                        return Resolution.Unresolved.INSTANCE;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                public interface Resolution {

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Resolved implements Resolution {

                        @MaybeNull
                        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                        private final Object argument;

                        public Resolved(@MaybeNull Object obj) {
                            this.argument = obj;
                        }

                        /* JADX WARN: Found duplicated region for block: B:19:0x0027 A[RETURN] */
                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Object obj2 = this.argument;
                            Object obj3 = ((Resolved) obj).argument;
                            if (obj3 != null) {
                                return obj2 != null && obj2.equals(obj3);
                            }
                            if (obj2 != null) {
                                return false;
                            }
                        }

                        @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution
                        @MaybeNull
                        public Object getArgument() {
                            return this.argument;
                        }

                        public int hashCode() {
                            int iHashCode = getClass().hashCode() * 31;
                            Object obj = this.argument;
                            return obj != null ? obj.hashCode() + iHashCode : iHashCode;
                        }

                        @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution
                        public boolean isResolved() {
                            return true;
                        }
                    }

                    /*
                     * JADX INFO: compiled from:
                     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                     */
                    public enum Unresolved implements Resolution {
                        INSTANCE;

                        @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution
                        public Object getArgument() {
                            throw new IllegalStateException("Cannot get the argument for an unresolved parameter");
                        }

                        @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.ArgumentResolver.Resolution
                        public boolean isResolved() {
                            return false;
                        }
                    }

                    @MaybeNull
                    Object getArgument();

                    boolean isResolved();
                }

                Resolution resolve(int i, Class<?> cls);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            public interface Instantiator {

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Ambiguous implements Instantiator {
                    private final Constructor<?> left;
                    private final int parameters;
                    private final int priority;
                    private final Constructor<?> right;

                    public Ambiguous(Constructor<?> constructor, Constructor<?> constructor2, int i, int i2) {
                        this.left = constructor;
                        this.right = constructor2;
                        this.priority = i;
                        this.parameters = i2;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Ambiguous ambiguous = (Ambiguous) obj;
                        return this.priority == ambiguous.priority && this.parameters == ambiguous.parameters
                                && this.left.equals(ambiguous.left) && this.right.equals(ambiguous.right);
                    }

                    public int hashCode() {
                        return ((((this.right.hashCode() + ((this.left.hashCode() + (getClass().hashCode() * 31)) * 31))
                                * 31) + this.priority) * 31) + this.parameters;
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Plugin instantiate() {
                        throw new IllegalStateException("Ambiguous constructors " + this.left + " and " + this.right);
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Instantiator replaceBy(Resolved resolved) {
                        Priority priority = (Priority) resolved.getConstructor().getAnnotation(Priority.class);
                        if ((priority == null ? 0 : priority.value()) <= this.priority) {
                            if ((priority != null ? priority.value() : 0) < this.priority
                                    || resolved.getConstructor().getParameterTypes().length <= this.parameters) {
                                return this;
                            }
                        }
                        return resolved;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Resolved implements Instantiator {
                    private final List<?> arguments;
                    private final Constructor<? extends Plugin> constructor;

                    public Resolved(Constructor<? extends Plugin> constructor, List<?> list) {
                        this.constructor = constructor;
                        this.arguments = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Resolved resolved = (Resolved) obj;
                        return this.constructor.equals(resolved.constructor)
                                && this.arguments.equals(resolved.arguments);
                    }

                    public Constructor<? extends Plugin> getConstructor() {
                        return this.constructor;
                    }

                    public int hashCode() {
                        return this.arguments.hashCode()
                                + ((this.constructor.hashCode() + (getClass().hashCode() * 31)) * 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Plugin instantiate() {
                        try {
                            return this.constructor.newInstance(this.arguments.toArray(new Object[0]));
                        } catch (IllegalAccessException e) {
                            throw new IllegalStateException("Failed to access " + this.constructor, e);
                        } catch (InstantiationException e2) {
                            throw new IllegalStateException("Failed to instantiate plugin via " + this.constructor, e2);
                        } catch (InvocationTargetException e3) {
                            throw new IllegalStateException("Error during construction of" + this.constructor,
                                    e3.getTargetException());
                        }
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Instantiator replaceBy(Resolved resolved) {
                        Priority priority = (Priority) this.constructor.getAnnotation(Priority.class);
                        Priority priority2 = (Priority) resolved.getConstructor().getAnnotation(Priority.class);
                        int iValue = priority == null ? 0 : priority.value();
                        int iValue2 = priority2 != null ? priority2.value() : 0;
                        if (iValue <= iValue2) {
                            if (iValue >= iValue2) {
                                if (this.constructor.getParameterTypes().length <= resolved.getConstructor()
                                        .getParameterTypes().length) {
                                    if (this.constructor.getParameterTypes().length >= resolved.getConstructor()
                                            .getParameterTypes().length) {
                                        return new Ambiguous(this.constructor, resolved.getConstructor(), iValue,
                                                this.constructor.getParameterTypes().length);
                                    }
                                }
                            }
                            return resolved;
                        }
                        return this;
                    }
                }

                /*
                 * JADX INFO: compiled from:
                 * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
                 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class Unresolved implements Instantiator {
                    private final Class<? extends Plugin> type;

                    public Unresolved(Class<? extends Plugin> cls) {
                        this.type = cls;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.type.equals(((Unresolved) obj).type);
                    }

                    public int hashCode() {
                        return this.type.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Plugin instantiate() {
                        throw new IllegalStateException("No constructor resolvable for " + this.type);
                    }

                    @Override // net.bytebuddy.build.Plugin.Factory.UsingReflection.Instantiator
                    public Instantiator replaceBy(Resolved resolved) {
                        return resolved;
                    }
                }

                Plugin instantiate();

                Instantiator replaceBy(Resolved resolved);
            }

            /*
             * JADX INFO: compiled from:
             * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
             */
            @Target({ ElementType.CONSTRUCTOR })
            @Documented
            @Retention(RetentionPolicy.RUNTIME)
            public @interface Priority {
                public static final int DEFAULT = 0;

                int value();
            }

            public UsingReflection(Class<? extends Plugin> cls) {
                this(cls, Collections.EMPTY_LIST);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                UsingReflection usingReflection = (UsingReflection) obj;
                return this.type.equals(usingReflection.type)
                        && this.argumentResolvers.equals(usingReflection.argumentResolvers);
            }

            public int hashCode() {
                return this.argumentResolvers.hashCode() + bjs.d(getClass().hashCode() * 31, 31, this.type);
            }

            @Override // net.bytebuddy.build.Plugin.Factory
            public Plugin make() {
                ArgumentResolver.Resolution resolutionResolve;
                Instantiator unresolved = new Instantiator.Unresolved(this.type);
                for (Constructor<?> constructor : this.type.getConstructors()) {
                    if (!constructor.isSynthetic()) {
                        ArrayList arrayList = new ArrayList(constructor.getParameterTypes().length);
                        Class<?>[] parameterTypes = constructor.getParameterTypes();
                        int length = parameterTypes.length;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            if (i >= length) {
                                unresolved = unresolved.replaceBy(new Instantiator.Resolved(constructor, arrayList));
                                break;
                            }
                            Class<?> cls = parameterTypes[i];
                            Iterator<ArgumentResolver> it = this.argumentResolvers.iterator();
                            do {
                                if (!it.hasNext()) {
                                    break;
                                }
                                resolutionResolve = it.next().resolve(i2, cls);
                            } while (!resolutionResolve.isResolved());
                            arrayList.add(resolutionResolve.getArgument());
                            i2++;
                            i++;
                        }
                    }
                }
                return unresolved.instantiate();
            }

            public UsingReflection with(ArgumentResolver... argumentResolverArr) {
                return with(Arrays.asList(argumentResolverArr));
            }

            public UsingReflection(Class<? extends Plugin> cls, List<ArgumentResolver> list) {
                this.type = cls;
                this.argumentResolvers = list;
            }

            public UsingReflection with(List<? extends ArgumentResolver> list) {
                return new UsingReflection(this.type, CompoundList.of((List) list, (List) this.argumentResolvers));
            }
        }

        Plugin make();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class ForElementMatcher implements Plugin {
        private final ElementMatcher<? super TypeDescription> matcher;

        public ForElementMatcher(ElementMatcher<? super TypeDescription> elementMatcher) {
            this.matcher = elementMatcher;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass()
                    && this.matcher.equals(((ForElementMatcher) obj).matcher);
        }

        public int hashCode() {
            return this.matcher.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.matcher.ElementMatcher
        public boolean matches(@MaybeNull TypeDescription typeDescription) {
            return this.matcher.matches(typeDescription);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    @HashCodeAndEqualsPlugin.Enhance
    public static class NoOp implements Plugin, Factory {
        @Override // net.bytebuddy.build.Plugin
        public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription,
                ClassFileLocator classFileLocator) {
            throw new IllegalStateException("Cannot apply non-operational plugin");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
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

        @Override // net.bytebuddy.build.Plugin.Factory
        public Plugin make() {
            return this;
        }

        @Override // net.bytebuddy.matcher.ElementMatcher
        public boolean matches(@MaybeNull TypeDescription typeDescription) {
            return false;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface WithInitialization extends Plugin {
        Map<TypeDescription, byte[]> initialize(ClassFileLocator classFileLocator);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface WithPreprocessor extends Plugin {
        void onPreprocess(TypeDescription typeDescription, ClassFileLocator classFileLocator);
    }

    DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription,
            ClassFileLocator classFileLocator);
}
