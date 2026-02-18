package net.bytebuddy.pool;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nonnull;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.module.ModuleDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.TypeReference;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.AsmClassReader;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.nullability.UnknownNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface TypePool {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static abstract class AbstractBase implements TypePool {
        protected static final Map<String, String> PRIMITIVE_DESCRIPTORS;
        protected static final Map<String, TypeDescription> PRIMITIVE_TYPES;
        protected final CacheProvider cacheProvider;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ArrayTypeResolution implements Resolution {
            private final int arity;
            private final Resolution resolution;

            public ArrayTypeResolution(Resolution resolution, int i) {
                this.resolution = resolution;
                this.arity = i;
            }

            public static Resolution of(Resolution resolution, int i) {
                return i == 0 ? resolution : new ArrayTypeResolution(resolution, i);
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ArrayTypeResolution arrayTypeResolution = (ArrayTypeResolution) obj;
                return this.arity == arrayTypeResolution.arity && this.resolution.equals(arrayTypeResolution.resolution);
            }

            public int hashCode() {
                return ((this.resolution.hashCode() + (getClass().hashCode() * 31)) * 31) + this.arity;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return this.resolution.isResolved();
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return TypeDescription.ArrayProjection.of(this.resolution.resolve(), this.arity);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface ComponentTypeReference {

            @MaybeNull
            public static final String NO_ARRAY = null;

            @MaybeNull
            String resolve();
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static abstract class Hierarchical extends AbstractBase {
            private final TypePool parent;

            public Hierarchical(CacheProvider cacheProvider, TypePool typePool) {
                super(cacheProvider);
                this.parent = typePool;
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
            public void clear() {
                try {
                    this.parent.clear();
                } finally {
                    super.clear();
                }
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
            public Resolution describe(String str) {
                Resolution resolutionDescribe = this.parent.describe(str);
                return resolutionDescribe.isResolved() ? resolutionDescribe : super.describe(str);
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.parent.equals(((Hierarchical) obj).parent);
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            public int hashCode() {
                return this.parent.hashCode() + (super.hashCode() * 31);
            }
        }

        static {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            for (int i = 0; i < 9; i++) {
                Class cls = clsArr[i];
                map.put(cls.getName(), TypeDescription.ForLoadedType.of(cls));
                map2.put(Type.getDescriptor(cls), cls.getName());
            }
            PRIMITIVE_TYPES = Collections.unmodifiableMap(map);
            PRIMITIVE_DESCRIPTORS = Collections.unmodifiableMap(map2);
        }

        public AbstractBase(CacheProvider cacheProvider) {
            this.cacheProvider = cacheProvider;
        }

        @Override // net.bytebuddy.pool.TypePool
        public void clear() {
            this.cacheProvider.clear();
        }

        @Override // net.bytebuddy.pool.TypePool
        public Resolution describe(String str) {
            if (str.contains("/")) {
                throw new IllegalArgumentException(str.concat(" contains the illegal character '/'"));
            }
            int i = 0;
            while (str.startsWith("[")) {
                i++;
                str = str.substring(1);
            }
            if (i > 0) {
                String str2 = PRIMITIVE_DESCRIPTORS.get(str);
                if (str2 != null) {
                    str = str2;
                } else {
                    if (!str.startsWith("L") || !str.endsWith(";")) {
                        throw new IllegalArgumentException("Not a legitimate array type descriptor: ".concat(str));
                    }
                    str = yg.j(str, 1, 1);
                }
            }
            TypeDescription typeDescription = PRIMITIVE_TYPES.get(str);
            Resolution resolutionFind = typeDescription == null ? this.cacheProvider.find(str) : new Resolution.Simple(typeDescription);
            if (resolutionFind == null) {
                resolutionFind = doCache(str, doDescribe(str));
            }
            return ArrayTypeResolution.of(resolutionFind, i);
        }

        public Resolution doCache(String str, Resolution resolution) {
            return this.cacheProvider.register(str, resolution);
        }

        public abstract Resolution doDescribe(String str);

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cacheProvider.equals(((AbstractBase) obj).cacheProvider);
        }

        public int hashCode() {
            return this.cacheProvider.hashCode() + (getClass().hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface CacheProvider {

        @AlwaysNull
        public static final Resolution UNRESOLVED = null;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Discriminating implements CacheProvider {
            private final CacheProvider matched;
            private final ElementMatcher<String> matcher;
            private final CacheProvider unmatched;

            public Discriminating(ElementMatcher<String> elementMatcher, CacheProvider cacheProvider, CacheProvider cacheProvider2) {
                this.matcher = elementMatcher;
                this.matched = cacheProvider;
                this.unmatched = cacheProvider2;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
                try {
                    this.unmatched.clear();
                } finally {
                    this.matched.clear();
                }
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            @MaybeNull
            public Resolution find(String str) {
                return (this.matcher.matches(str) ? this.matched : this.unmatched).find(str);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String str, Resolution resolution) {
                return (this.matcher.matches(str) ? this.matched : this.unmatched).register(str, resolution);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements CacheProvider {
            INSTANCE;

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            @MaybeNull
            public Resolution find(String str) {
                return CacheProvider.UNRESOLVED;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String str, Resolution resolution) {
                return resolution;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Simple implements CacheProvider {
            private final ConcurrentMap<String, Resolution> storage;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class UsingSoftReference implements CacheProvider {
                private final AtomicReference<SoftReference<Simple>> delegate = new AtomicReference<>(new SoftReference(new Simple()));

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                public void clear() {
                    Simple simple = this.delegate.get().get();
                    if (simple != null) {
                        simple.clear();
                    }
                }

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                @MaybeNull
                public Resolution find(String str) {
                    Simple simple = this.delegate.get().get();
                    return simple == null ? CacheProvider.UNRESOLVED : simple.find(str);
                }

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                public Resolution register(String str, Resolution resolution) {
                    SoftReference<Simple> softReference = this.delegate.get();
                    Simple simple = softReference.get();
                    if (simple == null) {
                        Simple simple2 = new Simple();
                        loop0: do {
                            AtomicReference<SoftReference<Simple>> atomicReference = this.delegate;
                            SoftReference<Simple> softReference2 = new SoftReference<>(simple2);
                            do {
                                if (atomicReference.compareAndSet(softReference, softReference2)) {
                                    simple = simple2;
                                    break loop0;
                                }
                            } while (atomicReference.get() == softReference);
                            softReference = this.delegate.get();
                            simple = softReference.get();
                        } while (simple == null);
                    }
                    return simple.register(str, resolution);
                }
            }

            public Simple() {
                this(new ConcurrentHashMap());
            }

            public static CacheProvider withObjectType() {
                Simple simple = new Simple();
                simple.register(Object.class.getName(), new Resolution.Simple(TypeDescription.ForLoadedType.of(Object.class)));
                return simple;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
                this.storage.clear();
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            @MaybeNull
            public Resolution find(String str) {
                return this.storage.get(str);
            }

            public ConcurrentMap<String, Resolution> getStorage() {
                return this.storage;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String str, Resolution resolution) {
                Resolution resolutionPutIfAbsent = this.storage.putIfAbsent(str, resolution);
                return resolutionPutIfAbsent == null ? resolution : resolutionPutIfAbsent;
            }

            public Simple(ConcurrentMap<String, Resolution> concurrentMap) {
                this.storage = concurrentMap;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithIllegalResolutionReattempt implements CacheProvider {
            private final CacheProvider delegate;

            public WithIllegalResolutionReattempt(CacheProvider cacheProvider) {
                this.delegate = cacheProvider;
            }

            public static CacheProvider of(CacheProvider cacheProvider) {
                return cacheProvider instanceof WithIllegalResolutionReattempt ? cacheProvider : new WithIllegalResolutionReattempt(cacheProvider);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
                this.delegate.clear();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.delegate.equals(((WithIllegalResolutionReattempt) obj).delegate);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            @MaybeNull
            public Resolution find(String str) {
                Resolution resolutionFind = this.delegate.find(str);
                return (resolutionFind == null || resolutionFind.isResolved()) ? resolutionFind : CacheProvider.UNRESOLVED;
            }

            public int hashCode() {
                return this.delegate.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String str, Resolution resolution) {
                return resolution.isResolved() ? this.delegate.register(str, resolution) : resolution;
            }
        }

        void clear();

        @MaybeNull
        Resolution find(String str);

        Resolution register(String str, Resolution resolution);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ClassLoading extends AbstractBase.Hierarchical {

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;

        public ClassLoading(CacheProvider cacheProvider, TypePool typePool, @MaybeNull ClassLoader classLoader) {
            super(cacheProvider, typePool);
            this.classLoader = classLoader;
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader) {
            return of(classLoader, Empty.INSTANCE);
        }

        public static TypePool ofBootLoader() {
            return of(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        public static TypePool ofPlatformLoader() {
            return of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static TypePool ofSystemLoader() {
            return of(ClassLoader.getSystemClassLoader());
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public Resolution doDescribe(String str) {
            try {
                return new Resolution.Simple(TypeDescription.ForLoadedType.of(Class.forName(str, false, this.classLoader)));
            } catch (ClassNotFoundException unused) {
                return new Resolution.Illegal(str);
            }
        }

        /* JADX WARN: Found duplicated region for block: B:21:0x002e A[RETURN] */
        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassLoader classLoader = this.classLoader;
            ClassLoader classLoader2 = ((ClassLoading) obj).classLoader;
            if (classLoader2 != null) {
                return classLoader != null && classLoader.equals(classLoader2);
            }
            if (classLoader != null) {
                return false;
            }
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            return classLoader != null ? classLoader.hashCode() + iHashCode : iHashCode;
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader, TypePool typePool) {
            return new ClassLoading(new CacheProvider.Simple(), typePool, classLoader);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Default extends AbstractBase.Hierarchical {

        @AlwaysNull
        private static final MethodVisitor IGNORE_METHOD = null;
        protected final ClassFileLocator classFileLocator;
        protected final AsmClassReader.Factory classReaderFactory;
        protected final ReaderMode readerMode;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface AnnotationRegistrant {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class AbstractBase implements AnnotationRegistrant {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class ForTypeVariable extends AbstractBase {
                    private final String typePath;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static abstract class WithIndex extends ForTypeVariable {
                        private final int index;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static abstract class DoubleIndexed extends WithIndex {
                            private final int preIndex;

                            public DoubleIndexed(String str, @MaybeNull TypePath typePath, int i, int i2) {
                                super(str, typePath, i);
                                this.preIndex = i2;
                            }

                            public abstract Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap();

                            @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex
                            public Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                                Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap = getDoubleIndexedPathMap();
                                Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map = doubleIndexedPathMap.get(Integer.valueOf(this.preIndex));
                                if (map != null) {
                                    return map;
                                }
                                HashMap map2 = new HashMap();
                                doubleIndexedPathMap.put(Integer.valueOf(this.preIndex), map2);
                                return map2;
                            }
                        }

                        public WithIndex(String str, @MaybeNull TypePath typePath, int i) {
                            super(str, typePath);
                            this.index = i;
                        }

                        public abstract Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap();

                        @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable
                        public Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                            Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap = getIndexedPathMap();
                            Map<String, List<LazyTypeDescription.AnnotationToken>> map = indexedPathMap.get(Integer.valueOf(this.index));
                            if (map != null) {
                                return map;
                            }
                            HashMap map2 = new HashMap();
                            indexedPathMap.put(Integer.valueOf(this.index), map2);
                            return map2;
                        }
                    }

                    public ForTypeVariable(String str, @MaybeNull TypePath typePath) {
                        super(str);
                        this.typePath = typePath == null ? "" : typePath.toString();
                    }

                    public abstract Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap();

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                    public List<LazyTypeDescription.AnnotationToken> getTokens() {
                        Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap = getPathMap();
                        List<LazyTypeDescription.AnnotationToken> list = pathMap.get(this.typePath);
                        if (list != null) {
                            return list;
                        }
                        ArrayList arrayList = new ArrayList();
                        pathMap.put(this.typePath, arrayList);
                        return arrayList;
                    }
                }

                public AbstractBase(String str) {
                    this.descriptor = str;
                }

                public abstract List<LazyTypeDescription.AnnotationToken> getTokens();

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void onComplete() {
                    getTokens().add(new LazyTypeDescription.AnnotationToken(this.descriptor, this.values));
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void register(String str, AnnotationValue<?, ?> annotationValue) {
                    this.values.put(str, annotationValue);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class ForByteCodeElement extends AbstractBase {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class WithIndex extends AbstractBase {
                    private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> annotationTokens;
                    private final int index;

                    public WithIndex(String str, int i, Map<Integer, List<LazyTypeDescription.AnnotationToken>> map) {
                        super(str);
                        this.index = i;
                        this.annotationTokens = map;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                    public List<LazyTypeDescription.AnnotationToken> getTokens() {
                        List<LazyTypeDescription.AnnotationToken> list = this.annotationTokens.get(Integer.valueOf(this.index));
                        if (list != null) {
                            return list;
                        }
                        ArrayList arrayList = new ArrayList();
                        this.annotationTokens.put(Integer.valueOf(this.index), arrayList);
                        return arrayList;
                    }
                }

                public ForByteCodeElement(String str, List<LazyTypeDescription.AnnotationToken> list) {
                    super(str);
                    this.annotationTokens = list;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                public List<LazyTypeDescription.AnnotationToken> getTokens() {
                    return this.annotationTokens;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class ForTypeVariable extends AbstractBase.ForTypeVariable {
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class WithIndex extends AbstractBase.ForTypeVariable.WithIndex {
                    private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class DoubleIndexed extends AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed {
                        private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap;

                        public DoubleIndexed(String str, @MaybeNull TypePath typePath, int i, int i2, Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> map) {
                            super(str, typePath, i, i2);
                            this.doubleIndexedPathMap = map;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed
                        public Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap() {
                            return this.doubleIndexedPathMap;
                        }
                    }

                    public WithIndex(String str, @MaybeNull TypePath typePath, int i, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map) {
                        super(str, typePath, i);
                        this.indexedPathMap = map;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex
                    public Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                        return this.indexedPathMap;
                    }
                }

                public ForTypeVariable(String str, @MaybeNull TypePath typePath, Map<String, List<LazyTypeDescription.AnnotationToken>> map) {
                    super(str, typePath);
                    this.pathMap = map;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable
                public Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                    return this.pathMap;
                }
            }

            void onComplete();

            void register(String str, AnnotationValue<?, ?> annotationValue);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface ComponentTypeLocator {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForAnnotationProperty implements ComponentTypeLocator {
                private final String annotationName;
                private final TypePool typePool;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                public class Bound implements AbstractBase.ComponentTypeReference {
                    private final String name;

                    public Bound(String str) {
                        this.name = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Bound bound = (Bound) obj;
                        return this.name.equals(bound.name) && ForAnnotationProperty.this.equals(ForAnnotationProperty.this);
                    }

                    public int hashCode() {
                        return ForAnnotationProperty.this.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.AbstractBase.ComponentTypeReference
                    @MaybeNull
                    public String resolve() {
                        TypeDescription componentType = ((MethodDescription.InDefinedShape) ForAnnotationProperty.this.typePool.describe(ForAnnotationProperty.this.annotationName).resolve().getDeclaredMethods().filter(ElementMatchers.named(this.name)).getOnly()).getReturnType().asErasure().getComponentType();
                        return componentType == null ? AbstractBase.ComponentTypeReference.NO_ARRAY : componentType.getName();
                    }
                }

                public ForAnnotationProperty(TypePool typePool, String str) {
                    this.typePool = typePool;
                    this.annotationName = str.substring(1, str.length() - 1).replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String str) {
                    return new Bound(str);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    ForAnnotationProperty forAnnotationProperty = (ForAnnotationProperty) obj;
                    return this.annotationName.equals(forAnnotationProperty.annotationName) && this.typePool.equals(forAnnotationProperty.typePool);
                }

                public int hashCode() {
                    return this.annotationName.hashCode() + ((this.typePool.hashCode() + (getClass().hashCode() * 31)) * 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ForArrayType implements ComponentTypeLocator, AbstractBase.ComponentTypeReference {
                private final String componentType;

                public ForArrayType(String str) {
                    this.componentType = yg.j(Type.getMethodType(str).getReturnType().getClassName(), 2, 0);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String str) {
                    return this;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((ForArrayType) obj).componentType);
                }

                public int hashCode() {
                    return this.componentType.hashCode() + (getClass().hashCode() * 31);
                }

                @Override // net.bytebuddy.pool.TypePool.AbstractBase.ComponentTypeReference
                public String resolve() {
                    return this.componentType;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum Illegal implements ComponentTypeLocator {
                INSTANCE;

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String str) {
                    throw new IllegalStateException(yg.k("Unexpected lookup of component type for ", str));
                }
            }

            AbstractBase.ComponentTypeReference bind(String str);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class GenericTypeExtractor extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {
            private final GenericTypeRegistrant genericTypeRegistrant;

            @UnknownNull
            private IncompleteToken incompleteToken;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class ForSignature<T extends LazyTypeDescription.GenericTypeToken.Resolution> extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {

                @UnknownNull
                protected List<LazyTypeDescription.GenericTypeToken> currentBounds;

                @MaybeNull
                protected String currentTypeParameter;
                protected final List<LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens = new ArrayList();

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class OfField implements GenericTypeRegistrant {

                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken fieldTypeToken;

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForField extract(@MaybeNull String str) {
                        if (str == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(str);
                        OfField ofField = new OfField();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(ofField));
                            return ofField.resolve();
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                    public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                        this.fieldTypeToken = genericTypeToken;
                    }

                    public LazyTypeDescription.GenericTypeToken.Resolution.ForField resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForField.Tokenized(this.fieldTypeToken);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class OfMethod extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForMethod> {

                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken returnTypeToken;
                    private final List<LazyTypeDescription.GenericTypeToken> parameterTypeTokens = new ArrayList();
                    private final List<LazyTypeDescription.GenericTypeToken> exceptionTypeTokens = new ArrayList();

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ExceptionTypeRegistrant implements GenericTypeRegistrant {
                        public ExceptionTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return OfMethod.this.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfMethod.this.exceptionTypeTokens.add(genericTypeToken);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ParameterTypeRegistrant implements GenericTypeRegistrant {
                        public ParameterTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return OfMethod.this.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfMethod.this.parameterTypeTokens.add(genericTypeToken);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class ReturnTypeTypeRegistrant implements GenericTypeRegistrant {
                        public ReturnTypeTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return OfMethod.this.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfMethod.this.returnTypeToken = genericTypeToken;
                        }
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForMethod extract(@MaybeNull String str) {
                        try {
                            return str == null ? LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : (LazyTypeDescription.GenericTypeToken.Resolution.ForMethod) ForSignature.extract(str, new OfMethod());
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitExceptionType() {
                        return new GenericTypeExtractor(new ExceptionTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitParameterType() {
                        return new GenericTypeExtractor(new ParameterTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitReturnType() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new ReturnTypeTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.ForSignature
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForMethod resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForMethod.Tokenized(this.returnTypeToken, this.parameterTypeTokens, this.exceptionTypeTokens, this.typeVariableTokens);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class OfRecordComponent implements GenericTypeRegistrant {

                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken recordComponentType;

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent extract(@MaybeNull String str) {
                        if (str == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(str);
                        OfRecordComponent ofRecordComponent = new OfRecordComponent();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(ofRecordComponent));
                            return ofRecordComponent.resolve();
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                    public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                        this.recordComponentType = genericTypeToken;
                    }

                    public LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent.Tokenized(this.recordComponentType);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class OfType extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForType> {
                    private final List<LazyTypeDescription.GenericTypeToken> interfaceTypeTokens = new ArrayList();

                    @UnknownNull
                    private LazyTypeDescription.GenericTypeToken superClassToken;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class InterfaceTypeRegistrant implements GenericTypeRegistrant {
                        public InterfaceTypeRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return OfType.this.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfType.this.interfaceTypeTokens.add(genericTypeToken);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    public class SuperClassRegistrant implements GenericTypeRegistrant {
                        public SuperClassRegistrant() {
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return OfType.this.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            OfType.this.superClassToken = genericTypeToken;
                        }
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForType extract(@MaybeNull String str) {
                        try {
                            return str == null ? LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : (LazyTypeDescription.GenericTypeToken.Resolution.ForType) ForSignature.extract(str, new OfType());
                        } catch (RuntimeException unused) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitInterface() {
                        return new GenericTypeExtractor(new InterfaceTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitSuperclass() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new SuperClassRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.ForSignature
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForType resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForType.Tokenized(this.superClassToken, this.interfaceTypeTokens, this.typeVariableTokens);
                    }
                }

                public static <S extends LazyTypeDescription.GenericTypeToken.Resolution> S extract(String str, ForSignature<S> forSignature) {
                    new SignatureReader(str).accept(forSignature);
                    return (S) forSignature.resolve();
                }

                public void collectTypeParameter() {
                    String str = this.currentTypeParameter;
                    if (str != null) {
                        this.typeVariableTokens.add(new LazyTypeDescription.GenericTypeToken.ForTypeVariable.Formal(str, this.currentBounds));
                    }
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                    List<LazyTypeDescription.GenericTypeToken> list = this.currentBounds;
                    if (list != null) {
                        list.add(genericTypeToken);
                        return;
                    }
                    throw new IllegalStateException("Did not expect " + genericTypeToken + " before finding formal parameter");
                }

                public abstract T resolve();

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitClassBound() {
                    return new GenericTypeExtractor(this);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitFormalTypeParameter(String str) {
                    collectTypeParameter();
                    this.currentTypeParameter = str;
                    this.currentBounds = new ArrayList();
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterfaceBound() {
                    return new GenericTypeExtractor(this);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface IncompleteToken {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static abstract class AbstractBase implements IncompleteToken {
                    protected final List<LazyTypeDescription.GenericTypeToken> parameters = new ArrayList();

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public class ForDirectBound implements GenericTypeRegistrant {
                        public ForDirectBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(genericTypeToken);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public class ForLowerBound implements GenericTypeRegistrant {
                        public ForLowerBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForLowerBoundWildcard(genericTypeToken));
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public class ForUpperBound implements GenericTypeRegistrant {
                        public ForUpperBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForUpperBoundWildcard(genericTypeToken));
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendDirectBound() {
                        return new GenericTypeExtractor(new ForDirectBound());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendLowerBound() {
                        return new GenericTypeExtractor(new ForLowerBound());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public void appendPlaceholder() {
                        this.parameters.add(LazyTypeDescription.GenericTypeToken.ForUnboundWildcard.INSTANCE);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendUpperBound() {
                        return new GenericTypeExtractor(new ForUpperBound());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForInnerClass extends AbstractBase {
                    private static final char INNER_CLASS_SEPARATOR = '$';
                    private final String internalName;
                    private final IncompleteToken outerTypeToken;

                    public ForInnerClass(String str, IncompleteToken incompleteToken) {
                        this.internalName = str;
                        this.outerTypeToken = incompleteToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForInnerClass forInnerClass = (ForInnerClass) obj;
                        return this.internalName.equals(forInnerClass.internalName) && this.outerTypeToken.equals(forInnerClass.outerTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public String getName() {
                        return this.outerTypeToken.getName() + INNER_CLASS_SEPARATOR + this.internalName.replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    }

                    public int hashCode() {
                        return this.outerTypeToken.hashCode() + bjs.e(this.internalName, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public boolean isParameterized() {
                        return (this.parameters.isEmpty() && this.outerTypeToken.isParameterized()) ? false : true;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public LazyTypeDescription.GenericTypeToken toToken() {
                        return (isParameterized() || this.outerTypeToken.isParameterized()) ? new LazyTypeDescription.GenericTypeToken.ForParameterizedType.Nested(getName(), this.parameters, this.outerTypeToken.toToken()) : new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTopLevelType extends AbstractBase {
                    private final String internalName;

                    public ForTopLevelType(String str) {
                        this.internalName = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.internalName.equals(((ForTopLevelType) obj).internalName);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public String getName() {
                        return this.internalName.replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    }

                    public int hashCode() {
                        return this.internalName.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public boolean isParameterized() {
                        return !this.parameters.isEmpty();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public LazyTypeDescription.GenericTypeToken toToken() {
                        return isParameterized() ? new LazyTypeDescription.GenericTypeToken.ForParameterizedType(getName(), this.parameters) : new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }
                }

                SignatureVisitor appendDirectBound();

                SignatureVisitor appendLowerBound();

                void appendPlaceholder();

                SignatureVisitor appendUpperBound();

                String getName();

                boolean isParameterized();

                LazyTypeDescription.GenericTypeToken toToken();
            }

            public GenericTypeExtractor(GenericTypeRegistrant genericTypeRegistrant) {
                this.genericTypeRegistrant = genericTypeRegistrant;
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
            public void register(LazyTypeDescription.GenericTypeToken genericTypeToken) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForGenericArray(genericTypeToken));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public SignatureVisitor visitArrayType() {
                return new GenericTypeExtractor(this);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitBaseType(char c) {
                this.genericTypeRegistrant.register(LazyTypeDescription.GenericTypeToken.ForPrimitiveType.of(c));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitClassType(String str) {
                this.incompleteToken = new IncompleteToken.ForTopLevelType(str);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitEnd() {
                this.genericTypeRegistrant.register(this.incompleteToken.toToken());
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitInnerClassType(String str) {
                this.incompleteToken = new IncompleteToken.ForInnerClass(str, this.incompleteToken);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitTypeArgument() {
                this.incompleteToken.appendPlaceholder();
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitTypeVariable(String str) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForTypeVariable(str));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public SignatureVisitor visitTypeArgument(char c) {
                if (c == '+') {
                    return this.incompleteToken.appendUpperBound();
                }
                if (c == '-') {
                    return this.incompleteToken.appendLowerBound();
                }
                if (c == '=') {
                    return this.incompleteToken.appendDirectBound();
                }
                throw new IllegalArgumentException("Unknown wildcard: " + c);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public interface GenericTypeRegistrant {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class RejectingSignatureVisitor extends SignatureVisitor {
                private static final String MESSAGE = "Unexpected token in generic signature";

                public RejectingSignatureVisitor() {
                    super(OpenedClassReader.ASM_API);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitArrayType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitBaseType(char c) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitClassBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitClassType(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitEnd() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitExceptionType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitFormalTypeParameter(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitInnerClassType(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterface() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterfaceBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitParameterType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitReturnType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitSuperclass() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitTypeArgument() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitTypeVariable(String str) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitTypeArgument(char c) {
                    throw new IllegalStateException(MESSAGE);
                }
            }

            void register(LazyTypeDescription.GenericTypeToken genericTypeToken);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType {

            @AlwaysNull
            private static final String NO_TYPE = null;
            private final int actualModifiers;
            private final List<AnnotationToken> annotationTokens;
            private final boolean anonymousType;
            private final ClassFileVersion classFileVersion;
            private final List<String> declaredTypes;

            @MaybeNull
            private final String declaringTypeName;
            private final List<FieldToken> fieldTokens;

            @MaybeNull
            private final String genericSignature;
            private final Map<Integer, Map<String, List<AnnotationToken>>> interfaceAnnotationTokens;
            private final List<String> interfaceTypeDescriptors;
            private final List<MethodToken> methodTokens;
            private final int modifiers;

            @MaybeNull
            private final ModuleToken moduleToken;
            private final String name;

            @MaybeNull
            private final String nestHost;
            private final List<String> nestMembers;
            private final List<String> permittedSubclasses;
            private final List<RecordComponentToken> recordComponentTokens;
            private final GenericTypeToken.Resolution.ForType signatureResolution;
            private final Map<String, List<AnnotationToken>> superClassAnnotationTokens;

            @MaybeNull
            private final String superClassDescriptor;
            private final TypeContainment typeContainment;
            private final TypePool typePool;
            private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
            private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundsAnnotationTokens;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class AnnotationToken {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Resolution {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Illegal implements Resolution {
                        private final String annotationType;

                        public Illegal(String str) {
                            this.annotationType = str;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                        }

                        public int hashCode() {
                            return this.annotationType.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public boolean isResolved() {
                            return false;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public AnnotationDescription resolve() {
                            throw new IllegalStateException("Annotation type is not available: " + this.annotationType);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Simple implements Resolution {
                        private final AnnotationDescription annotationDescription;

                        public Simple(AnnotationDescription annotationDescription) {
                            this.annotationDescription = annotationDescription;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationDescription.equals(((Simple) obj).annotationDescription);
                        }

                        public int hashCode() {
                            return this.annotationDescription.hashCode() + (getClass().hashCode() * 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public boolean isResolved() {
                            return true;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public AnnotationDescription resolve() {
                            return this.annotationDescription;
                        }
                    }

                    boolean isResolved();

                    AnnotationDescription resolve();
                }

                public AnnotationToken(String str, Map<String, AnnotationValue<?, ?>> map) {
                    this.descriptor = str;
                    this.values = map;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public Resolution toAnnotationDescription(TypePool typePool) {
                    Resolution resolutionDescribe = typePool.describe(getBinaryName());
                    return resolutionDescribe.isResolved() ? new Resolution.Simple(new LazyAnnotationDescription(typePool, resolutionDescribe.resolve(), this.values)) : new Resolution.Illegal(getBinaryName());
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    AnnotationToken annotationToken = (AnnotationToken) obj;
                    return this.descriptor.equals(annotationToken.descriptor) && this.values.equals(annotationToken.values);
                }

                public String getBinaryName() {
                    String str = this.descriptor;
                    return str.substring(1, str.length() - 1).replace('/', GenericTypeToken.INNER_CLASS_PATH);
                }

                public int hashCode() {
                    return this.values.hashCode() + bjs.e(this.descriptor, getClass().hashCode() * 31, 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class FieldToken {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;

                @UnknownNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                public FieldToken(String str, int i, String str2, @MaybeNull String str3, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.modifiers = i & (-131073);
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfField.extract(str3);
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public LazyFieldDescription toFieldDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyFieldDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    FieldToken fieldToken = (FieldToken) obj;
                    return this.modifiers == fieldToken.modifiers && this.name.equals(fieldToken.name) && this.descriptor.equals(fieldToken.descriptor) && this.genericSignature.equals(fieldToken.genericSignature) && this.signatureResolution.equals(fieldToken.signatureResolution) && this.typeAnnotationTokens.equals(fieldToken.typeAnnotationTokens) && this.annotationTokens.equals(fieldToken.annotationTokens);
                }

                public int hashCode() {
                    return this.annotationTokens.hashCode() + yg.c(this.typeAnnotationTokens, (this.signatureResolution.hashCode() + bjs.e(this.genericSignature, bjs.e(this.descriptor, (bjs.e(this.name, getClass().hashCode() * 31, 31) + this.modifiers) * 31, 31), 31)) * 31, 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class FieldTokenList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                public FieldTokenList() {
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return LazyTypeDescription.this.fieldTokens.size();
                }

                @Override // java.util.AbstractList, java.util.List
                public FieldDescription.InDefinedShape get(int i) {
                    return ((FieldToken) LazyTypeDescription.this.fieldTokens.get(i)).toFieldDescription(LazyTypeDescription.this);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface GenericTypeToken {
                public static final char COMPONENT_TYPE_PATH = '[';
                public static final String EMPTY_TYPE_PATH = "";
                public static final char INDEXED_TYPE_DELIMITER = ';';
                public static final char INNER_CLASS_PATH = '.';
                public static final char WILDCARD_TYPE_PATH = '*';

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForGenericArray implements GenericTypeToken {
                    private final GenericTypeToken componentTypeToken;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyGenericArray extends TypeDescription.Generic.OfGenericArray {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken componentTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public LazyGenericArray(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.componentTypeToken = genericTypeToken;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription.Generic getComponentType() {
                            return this.componentTypeToken.toGenericType(this.typePool, this.typeVariableSource, bjs.q(new StringBuilder(), this.typePath, GenericTypeToken.COMPONENT_TYPE_PATH), this.annotationTokens);
                        }
                    }

                    public ForGenericArray(GenericTypeToken genericTypeToken) {
                        this.componentTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.componentTypeToken.equals(((ForGenericArray) obj).componentTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A generic array type cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return this.componentTypeToken.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A generic array type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyGenericArray(typePool, typeVariableSource, str, map, this.componentTypeToken);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForLowerBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyLowerBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public LazyLowerBoundWildcard(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.boundTypeToken = genericTypeToken;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
                        }
                    }

                    public ForLowerBoundWildcard(GenericTypeToken genericTypeToken) {
                        this.boundTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForLowerBoundWildcard) obj).boundTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A lower bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return this.boundTypeToken.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyLowerBoundWildcard(typePool, typeVariableSource, str, map, this.boundTypeToken);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForParameterizedType implements GenericTypeToken {
                    private final String name;
                    private final List<GenericTypeToken> parameterTypeTokens;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final String name;
                        private final List<GenericTypeToken> parameterTypeTokens;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public LazyParameterizedType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, String str2, List<GenericTypeToken> list) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.name = str2;
                            this.parameterTypeTokens = list;
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription asErasure() {
                            return this.typePool.describe(this.name).resolve();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        @MaybeNull
                        public TypeDescription.Generic getOwnerType() {
                            TypeDescription typeDescriptionResolve = this.typePool.describe(this.name).resolve();
                            if (typeDescriptionResolve.getTypeVariables().size() != this.parameterTypeTokens.size()) {
                                throw new MalformedParameterizedTypeException();
                            }
                            TypeDescription enclosingType = typeDescriptionResolve.getEnclosingType();
                            return enclosingType == null ? TypeDescription.Generic.UNDEFINED : enclosingType.asGenericType();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getTypeArguments() {
                            if (this.typePool.describe(this.name).resolve().getTypeVariables().size() == this.parameterTypeTokens.size()) {
                                return new LazyTokenList(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.parameterTypeTokens);
                            }
                            throw new MalformedParameterizedTypeException();
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Nested implements GenericTypeToken {
                        private final String name;
                        private final GenericTypeToken ownerTypeToken;
                        private final List<GenericTypeToken> parameterTypeTokens;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final String name;
                            private final GenericTypeToken ownerTypeToken;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final String typePath;
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;

                            public LazyParameterizedType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, String str2, List<GenericTypeToken> list, GenericTypeToken genericTypeToken) {
                                this.typePool = typePool;
                                this.typeVariableSource = typeVariableSource;
                                this.typePath = str;
                                this.annotationTokens = map;
                                this.name = str2;
                                this.parameterTypeTokens = list;
                                this.ownerTypeToken = genericTypeToken;
                            }

                            @Override // net.bytebuddy.description.type.TypeDefinition
                            public TypeDescription asErasure() {
                                return this.typePool.describe(this.name).resolve();
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath + this.ownerTypeToken.getTypePathPrefix()));
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            @MaybeNull
                            public TypeDescription.Generic getOwnerType() {
                                return this.ownerTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeList.Generic getTypeArguments() {
                                return new LazyTokenList(this.typePool, this.typeVariableSource, this.typePath + this.ownerTypeToken.getTypePathPrefix(), this.annotationTokens, this.parameterTypeTokens);
                            }
                        }

                        public Nested(String str, List<GenericTypeToken> list, GenericTypeToken genericTypeToken) {
                            this.name = str;
                            this.parameterTypeTokens = list;
                            this.ownerTypeToken = genericTypeToken;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Nested nested = (Nested) obj;
                            return this.name.equals(nested.name) && this.parameterTypeTokens.equals(nested.parameterTypeTokens) && this.ownerTypeToken.equals(nested.ownerTypeToken);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public String getTypePathPrefix() {
                            return this.ownerTypeToken.getTypePathPrefix() + GenericTypeToken.INNER_CLASS_PATH;
                        }

                        public int hashCode() {
                            return this.ownerTypeToken.hashCode() + bjs.g(this.parameterTypeTokens, bjs.e(this.name, getClass().hashCode() * 31, 31), 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public boolean isPrimaryBound(TypePool typePool) {
                            return !typePool.describe(this.name).resolve().isInterface();
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                            return new LazyParameterizedType(typePool, typeVariableSource, str, map, this.name, this.parameterTypeTokens, this.ownerTypeToken);
                        }
                    }

                    public ForParameterizedType(String str, List<GenericTypeToken> list) {
                        this.name = str;
                        this.parameterTypeTokens = list;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForParameterizedType forParameterizedType = (ForParameterizedType) obj;
                        return this.name.equals(forParameterizedType.name) && this.parameterTypeTokens.equals(forParameterizedType.parameterTypeTokens);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        return String.valueOf(GenericTypeToken.INNER_CLASS_PATH);
                    }

                    public int hashCode() {
                        return this.parameterTypeTokens.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyParameterizedType(typePool, typeVariableSource, str, map, this.name, this.parameterTypeTokens);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum ForPrimitiveType implements GenericTypeToken {
                    BOOLEAN(Boolean.TYPE),
                    BYTE(Byte.TYPE),
                    SHORT(Short.TYPE),
                    CHAR(Character.TYPE),
                    INTEGER(Integer.TYPE),
                    LONG(Long.TYPE),
                    FLOAT(Float.TYPE),
                    DOUBLE(Double.TYPE),
                    VOID(Void.TYPE);

                    private final TypeDescription typeDescription;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyPrimitiveType extends TypeDescription.Generic.OfNonGenericType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final TypeDescription typeDescription;
                        private final String typePath;
                        private final TypePool typePool;

                        public LazyPrimitiveType(TypePool typePool, String str, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                            this.typePool = typePool;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.typeDescription = typeDescription;
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription asErasure() {
                            return this.typeDescription;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        @MaybeNull
                        public TypeDescription.Generic getOwnerType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        @MaybeNull
                        public TypeDescription.Generic getComponentType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }
                    }

                    ForPrimitiveType(Class cls) {
                        this.typeDescription = TypeDescription.ForLoadedType.of(cls);
                    }

                    public static GenericTypeToken of(char c) {
                        if (c == 'F') {
                            return FLOAT;
                        }
                        if (c == 'S') {
                            return SHORT;
                        }
                        if (c == 'V') {
                            return VOID;
                        }
                        if (c == 'Z') {
                            return BOOLEAN;
                        }
                        if (c == 'I') {
                            return INTEGER;
                        }
                        if (c == 'J') {
                            return LONG;
                        }
                        switch (c) {
                            case 'B':
                                return BYTE;
                            case 'C':
                                return CHAR;
                            case 'D':
                                return DOUBLE;
                            default:
                                throw new IllegalArgumentException("Not a valid primitive type descriptor: " + c);
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A primitive type cannot be the owner of a nested type: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A primitive type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyPrimitiveType(typePool, str, map, this.typeDescription);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForRawType implements GenericTypeToken {
                    private final String name;

                    public ForRawType(String str) {
                        this.name = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((ForRawType) obj).name);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A non-generic type cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return this.name.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new Resolution.Raw.RawAnnotatedType(typePool, str, map, typePool.describe(this.name).resolve());
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForTypeVariable implements GenericTypeToken {
                    private final String symbol;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final List<AnnotationToken> annotationTokens;
                        private final TypePool typePool;
                        private final TypeDescription.Generic typeVariable;

                        public AnnotatedTypeVariable(TypePool typePool, List<AnnotationToken> list, TypeDescription.Generic generic) {
                            this.typePool = typePool;
                            this.annotationTokens = list;
                            this.typeVariable = generic;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public String getSymbol() {
                            return this.typeVariable.getSymbol();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariable.getTypeVariableSource();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return this.typeVariable.getUpperBounds();
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    @HashCodeAndEqualsPlugin.Enhance
                    public static class Formal implements OfFormalTypeVariable {
                        private final List<GenericTypeToken> boundTypeTokens;
                        private final String symbol;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static class LazyTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final List<GenericTypeToken> boundTypeTokens;
                            private final Map<Integer, Map<String, List<AnnotationToken>>> boundaryAnnotationTokens;
                            private final String symbol;
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public static class LazyBoundTokenList extends TypeList.Generic.AbstractBase {
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<GenericTypeToken> boundTypeTokens;
                                private final TypePool typePool;
                                private final TypeVariableSource typeVariableSource;

                                public LazyBoundTokenList(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, List<GenericTypeToken> list) {
                                    this.typePool = typePool;
                                    this.typeVariableSource = typeVariableSource;
                                    this.annotationTokens = map;
                                    this.boundTypeTokens = list;
                                }

                                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                                public int size() {
                                    return this.boundTypeTokens.size();
                                }

                                @Override // java.util.AbstractList, java.util.List
                                public TypeDescription.Generic get(int i) {
                                    Map<String, List<AnnotationToken>> map = (this.annotationTokens.containsKey(Integer.valueOf(i)) || this.annotationTokens.containsKey(Integer.valueOf(i + 1))) ? this.annotationTokens.get(Integer.valueOf((!this.boundTypeTokens.get(0).isPrimaryBound(this.typePool) ? 1 : 0) + i)) : Collections.EMPTY_MAP;
                                    GenericTypeToken genericTypeToken = this.boundTypeTokens.get(i);
                                    TypePool typePool = this.typePool;
                                    TypeVariableSource typeVariableSource = this.typeVariableSource;
                                    if (map == null) {
                                        map = Collections.EMPTY_MAP;
                                    }
                                    return genericTypeToken.toGenericType(typePool, typeVariableSource, "", map);
                                }
                            }

                            public LazyTypeVariable(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2, String str, List<GenericTypeToken> list) {
                                this.typePool = typePool;
                                this.typeVariableSource = typeVariableSource;
                                this.annotationTokens = map;
                                this.boundaryAnnotationTokens = map2;
                                this.symbol = str;
                                this.boundTypeTokens = list;
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(""));
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public String getSymbol() {
                                return this.symbol;
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeVariableSource getTypeVariableSource() {
                                return this.typeVariableSource;
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeList.Generic getUpperBounds() {
                                return new LazyBoundTokenList(this.typePool, this.typeVariableSource, this.boundaryAnnotationTokens, this.boundTypeTokens);
                            }
                        }

                        public Formal(String str, List<GenericTypeToken> list) {
                            this.symbol = str;
                            this.boundTypeTokens = list;
                        }

                        public boolean equals(@MaybeNull Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || getClass() != obj.getClass()) {
                                return false;
                            }
                            Formal formal = (Formal) obj;
                            return this.symbol.equals(formal.symbol) && this.boundTypeTokens.equals(formal.boundTypeTokens);
                        }

                        public int hashCode() {
                            return this.boundTypeTokens.hashCode() + bjs.e(this.symbol, getClass().hashCode() * 31, 31);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable
                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, @MaybeNull Map<String, List<AnnotationToken>> map, @MaybeNull Map<Integer, Map<String, List<AnnotationToken>>> map2) {
                            if (map == null) {
                                map = Collections.EMPTY_MAP;
                            }
                            Map<String, List<AnnotationToken>> map3 = map;
                            if (map2 == null) {
                                map2 = Collections.EMPTY_MAP;
                            }
                            return new LazyTypeVariable(typePool, typeVariableSource, map3, map2, this.symbol, this.boundTypeTokens);
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class UnresolvedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final List<AnnotationToken> annotationTokens;
                        private final String symbol;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public UnresolvedTypeVariable(TypeVariableSource typeVariableSource, TypePool typePool, String str, List<AnnotationToken> list) {
                            this.typeVariableSource = typeVariableSource;
                            this.typePool = typePool;
                            this.symbol = str;
                            this.annotationTokens = list;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public String getSymbol() {
                            return this.symbol;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariableSource;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            throw new TypeNotPresentException(this.symbol, null);
                        }
                    }

                    public ForTypeVariable(String str) {
                        this.symbol = str;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.symbol.equals(((ForTypeVariable) obj).symbol);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A type variable cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return this.symbol.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return true;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        TypeDescription.Generic genericFindVariable = typeVariableSource.findVariable(this.symbol);
                        return genericFindVariable == null ? new UnresolvedTypeVariable(typeVariableSource, typePool, this.symbol, map.get(str)) : new AnnotatedTypeVariable(typePool, map.get(str), genericFindVariable);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum ForUnboundWildcard implements GenericTypeToken {
                    INSTANCE;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyUnboundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final String typePath;
                        private final TypePool typePool;

                        public LazyUnboundWildcard(TypePool typePool, String str, Map<String, List<AnnotationToken>> map) {
                            this.typePool = typePool;
                            this.typePath = str;
                            this.annotationTokens = map;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OfNonGenericType.ForLoadedType.of(Object.class));
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An unbound wildcard cannot be the owner of a nested type: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, @MaybeNull Map<String, List<AnnotationToken>> map) {
                        if (map == null) {
                            map = Collections.EMPTY_MAP;
                        }
                        return new LazyUnboundWildcard(typePool, str, map);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForUpperBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class LazyUpperBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public LazyUpperBoundWildcard(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.boundTypeToken = genericTypeToken;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }
                    }

                    public ForUpperBoundWildcard(GenericTypeToken genericTypeToken) {
                        this.boundTypeToken = genericTypeToken;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForUpperBoundWildcard) obj).boundTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An upper bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    public int hashCode() {
                        return this.boundTypeToken.hashCode() + (getClass().hashCode() * 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map) {
                        return new LazyUpperBoundWildcard(typePool, typeVariableSource, str, map, this.boundTypeToken);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class LazyTokenList extends TypeList.Generic.AbstractBase {
                    private final Map<String, List<AnnotationToken>> annotationTokens;
                    private final List<GenericTypeToken> genericTypeTokens;
                    private final String typePath;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class ForWildcardBound extends TypeList.Generic.AbstractBase {
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken genericTypeToken;
                        private final String typePath;
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;

                        public ForWildcardBound(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = str;
                            this.annotationTokens = map;
                            this.genericTypeToken = genericTypeToken;
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                        public int size() {
                            return 1;
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int i) {
                            if (i == 0) {
                                return this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, bjs.q(new StringBuilder(), this.typePath, GenericTypeToken.WILDCARD_TYPE_PATH), this.annotationTokens);
                            }
                            throw new IndexOutOfBoundsException(bjs.i(i, "index = "));
                        }
                    }

                    public LazyTokenList(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map, List<GenericTypeToken> list) {
                        this.typePool = typePool;
                        this.typeVariableSource = typeVariableSource;
                        this.typePath = str;
                        this.annotationTokens = map;
                        this.genericTypeTokens = list;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return this.genericTypeTokens.size();
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int i) {
                        return this.genericTypeTokens.get(i).toGenericType(this.typePool, this.typeVariableSource, this.typePath + i + GenericTypeToken.INDEXED_TYPE_DELIMITER, this.annotationTokens);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface OfFormalTypeVariable {
                    TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2);
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public interface Resolution {

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface ForField {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForField {
                            private final GenericTypeToken fieldTypeToken;

                            public Tokenized(GenericTypeToken genericTypeToken) {
                                this.fieldTypeToken = genericTypeToken;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.fieldTypeToken.equals(((Tokenized) obj).fieldTypeToken);
                            }

                            public int hashCode() {
                                return this.fieldTypeToken.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                            public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.fieldTypeToken, str, map, inDefinedShape.getDeclaringType());
                            }
                        }

                        TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface ForMethod extends Resolution {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForMethod {
                            private final List<GenericTypeToken> exceptionTypeTokens;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final GenericTypeToken returnTypeToken;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            public Tokenized(GenericTypeToken genericTypeToken, List<GenericTypeToken> list, List<GenericTypeToken> list2, List<OfFormalTypeVariable> list3) {
                                this.returnTypeToken = genericTypeToken;
                                this.parameterTypeTokens = list;
                                this.exceptionTypeTokens = list2;
                                this.typeVariableTokens = list3;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Tokenized tokenized = (Tokenized) obj;
                                return this.returnTypeToken.equals(tokenized.returnTypeToken) && this.parameterTypeTokens.equals(tokenized.parameterTypeTokens) && this.exceptionTypeTokens.equals(tokenized.exceptionTypeTokens) && this.typeVariableTokens.equals(tokenized.typeVariableTokens);
                            }

                            public int hashCode() {
                                return this.typeVariableTokens.hashCode() + bjs.g(this.exceptionTypeTokens, bjs.g(this.parameterTypeTokens, (this.returnTypeToken.hashCode() + (getClass().hashCode() * 31)) * 31, 31), 31);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                return this.exceptionTypeTokens.isEmpty() ? Raw.INSTANCE.resolveExceptionTypes(list, typePool, map, inDefinedShape) : new TokenizedGenericType.TokenList(typePool, this.exceptionTypeTokens, map, list, inDefinedShape);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                return new TokenizedGenericType.TokenList(typePool, this.parameterTypeTokens, map, list, inDefinedShape);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.returnTypeToken, str, map, inDefinedShape);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, map, map2);
                            }
                        }

                        TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface ForRecordComponent {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForRecordComponent {
                            private final GenericTypeToken recordComponentTypeToken;

                            public Tokenized(GenericTypeToken genericTypeToken) {
                                this.recordComponentTypeToken = genericTypeToken;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.recordComponentTypeToken.equals(((Tokenized) obj).recordComponentTypeToken);
                            }

                            public int hashCode() {
                                return this.recordComponentTypeToken.hashCode() + (getClass().hashCode() * 31);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                            public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                                return TokenizedGenericType.of(typePool, this.recordComponentTypeToken, str, map, inDefinedShape.getDeclaringType());
                            }
                        }

                        TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public interface ForType extends Resolution {

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        @HashCodeAndEqualsPlugin.Enhance
                        public static class Tokenized implements ForType {
                            private final List<GenericTypeToken> interfaceTypeTokens;
                            private final GenericTypeToken superClassToken;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            public Tokenized(GenericTypeToken genericTypeToken, List<GenericTypeToken> list, List<OfFormalTypeVariable> list2) {
                                this.superClassToken = genericTypeToken;
                                this.interfaceTypeTokens = list;
                                this.typeVariableTokens = list2;
                            }

                            public boolean equals(@MaybeNull Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (obj == null || getClass() != obj.getClass()) {
                                    return false;
                                }
                                Tokenized tokenized = (Tokenized) obj;
                                return this.superClassToken.equals(tokenized.superClassToken) && this.interfaceTypeTokens.equals(tokenized.interfaceTypeTokens) && this.typeVariableTokens.equals(tokenized.typeVariableTokens);
                            }

                            public int hashCode() {
                                return this.typeVariableTokens.hashCode() + bjs.g(this.interfaceTypeTokens, (this.superClassToken.hashCode() + (getClass().hashCode() * 31)) * 31, 31);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                            public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                                return new TokenizedGenericType.TokenList(typePool, this.interfaceTypeTokens, map, list, typeDescription);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                            public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                                return TokenizedGenericType.of(typePool, this.superClassToken, str, map, typeDescription);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, map, map2);
                            }
                        }

                        TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription);

                        TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription);
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public enum Malformed implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                        public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                        public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                            return new TokenizedGenericType.Malformed(typePool, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                            throw new GenericSignatureFormatError();
                        }
                    }

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public enum Raw implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public static class RawAnnotatedType extends TypeDescription.Generic.OfNonGenericType {
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final TypeDescription typeDescription;
                            private final String typePath;
                            private final TypePool typePool;

                            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                            public static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase {
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<String> descriptors;
                                private final TypePool typePool;

                                public LazyRawAnnotatedTypeList(TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list) {
                                    this.typePool = typePool;
                                    this.annotationTokens = map;
                                    this.descriptors = list;
                                }

                                public static TypeList.Generic of(TypePool typePool, @MaybeNull Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list) {
                                    if (map == null) {
                                        map = Collections.EMPTY_MAP;
                                    }
                                    return new LazyRawAnnotatedTypeList(typePool, map, list);
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public TypeList asErasures() {
                                    return new LazyTypeList(this.typePool, this.descriptors);
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public TypeList.Generic asRawTypes() {
                                    return this;
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public int getStackSize() {
                                    Iterator<String> it = this.descriptors.iterator();
                                    int size = 0;
                                    while (it.hasNext()) {
                                        size += Type.getType(it.next()).getSize();
                                    }
                                    return size;
                                }

                                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                                public int size() {
                                    return this.descriptors.size();
                                }

                                @Override // java.util.AbstractList, java.util.List
                                public TypeDescription.Generic get(int i) {
                                    return RawAnnotatedType.of(this.typePool, this.annotationTokens.get(Integer.valueOf(i)), this.descriptors.get(i));
                                }
                            }

                            public RawAnnotatedType(TypePool typePool, String str, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                                this.typePool = typePool;
                                this.typePath = str;
                                this.annotationTokens = map;
                                this.typeDescription = typeDescription;
                            }

                            public static TypeDescription.Generic of(TypePool typePool, @MaybeNull Map<String, List<AnnotationToken>> map, String str) {
                                if (map == null) {
                                    map = Collections.EMPTY_MAP;
                                }
                                return new RawAnnotatedType(typePool, "", map, TokenizedGenericType.toErasure(typePool, str));
                            }

                            @Override // net.bytebuddy.description.type.TypeDefinition
                            public TypeDescription asErasure() {
                                return this.typeDescription;
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                StringBuilder sb = new StringBuilder(this.typePath);
                                for (int i = 0; i < this.typeDescription.getInnerClassCount(); i++) {
                                    sb.append(GenericTypeToken.INNER_CLASS_PATH);
                                }
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(sb.toString()));
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            @MaybeNull
                            public TypeDescription.Generic getOwnerType() {
                                TypeDescription declaringType = this.typeDescription.getDeclaringType();
                                return declaringType == null ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, declaringType);
                            }

                            @Override // net.bytebuddy.description.type.TypeDefinition
                            @MaybeNull
                            public TypeDescription.Generic getComponentType() {
                                TypeDescription componentType = this.typeDescription.getComponentType();
                                return componentType == null ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, bjs.q(new StringBuilder(), this.typePath, GenericTypeToken.COMPONENT_TYPE_PATH), this.annotationTokens, componentType);
                            }
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                        public TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.of(typePool, map, list);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                        public TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription) {
                            return RawAnnotatedType.of(typePool, map, str);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                            return new TypeList.Generic.Empty();
                        }
                    }

                    TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2);
                }

                String getTypePathPrefix();

                boolean isPrimaryBound(TypePool typePool);

                TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class LazyAnnotationDescription extends AnnotationDescription.AbstractBase {
                private final TypeDescription annotationType;
                protected final TypePool typePool;
                protected final Map<String, AnnotationValue<?, ?>> values;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class Loadable<S extends Annotation> extends LazyAnnotationDescription implements AnnotationDescription.Loadable<S> {
                    private final Class<S> annotationType;

                    @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
                    public S load() {
                        return (S) AnnotationDescription.AnnotationInvocationHandler.of(this.annotationType.getClassLoader(), this.annotationType, this.values);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationDescription, net.bytebuddy.description.annotation.AnnotationDescription
                    public /* bridge */ /* synthetic */ AnnotationDescription.Loadable prepare(Class cls) {
                        return super.prepare(cls);
                    }

                    private Loadable(TypePool typePool, Class<S> cls, Map<String, AnnotationValue<?, ?>> map) {
                        super(typePool, TypeDescription.ForLoadedType.of(cls), map);
                        this.annotationType = cls;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class UnresolvedAnnotationList extends AnnotationList.Explicit {
                    private final List<? extends AnnotationToken> tokens;

                    @Override // net.bytebuddy.description.annotation.AnnotationList.AbstractBase, net.bytebuddy.description.annotation.AnnotationList
                    public List<String> asTypeNames() {
                        ArrayList arrayList = new ArrayList(this.tokens.size());
                        Iterator<? extends AnnotationToken> it = this.tokens.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().getBinaryName());
                        }
                        return arrayList;
                    }

                    private UnresolvedAnnotationList(List<? extends AnnotationDescription> list, List<? extends AnnotationToken> list2) {
                        super(list);
                        this.tokens = list2;
                    }
                }

                public static AnnotationList asList(TypePool typePool, List<? extends AnnotationToken> list) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator<? extends AnnotationToken> it = list.iterator();
                    while (it.hasNext()) {
                        AnnotationToken.Resolution annotationDescription = it.next().toAnnotationDescription(typePool);
                        if (annotationDescription.isResolved() && annotationDescription.resolve().getAnnotationType().isAnnotation()) {
                            arrayList.add(annotationDescription.resolve());
                        }
                    }
                    return new UnresolvedAnnotationList(arrayList, list);
                }

                public static AnnotationList asListOfNullable(TypePool typePool, @MaybeNull List<? extends AnnotationToken> list) {
                    return list == null ? new AnnotationList.Empty() : asList(typePool, list);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public TypeDescription getAnnotationType() {
                    return this.annotationType;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape) {
                    if (inDefinedShape.getDeclaringType().asErasure().equals(this.annotationType)) {
                        AnnotationValue<?, ?> annotationValue = this.values.get(inDefinedShape.getName());
                        if (annotationValue != null) {
                            return annotationValue.filter(inDefinedShape);
                        }
                        AnnotationValue<?, ?> defaultValue = ((MethodDescription.InDefinedShape) getAnnotationType().getDeclaredMethods().filter(ElementMatchers.is(inDefinedShape)).getOnly()).getDefaultValue();
                        return defaultValue == null ? new AnnotationValue.ForMissingValue(this.annotationType, inDefinedShape.getName()) : defaultValue;
                    }
                    throw new IllegalArgumentException(inDefinedShape + " is not declared by " + getAnnotationType());
                }

                private LazyAnnotationDescription(TypePool typePool, TypeDescription typeDescription, Map<String, AnnotationValue<?, ?>> map) {
                    this.typePool = typePool;
                    this.annotationType = typeDescription;
                    this.values = map;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public <T extends Annotation> Loadable<T> prepare(Class<T> cls) {
                    if (this.annotationType.represents(cls)) {
                        return new Loadable<>(this.typePool, cls, this.values);
                    }
                    throw new IllegalArgumentException(cls + " does not represent " + this.annotationType);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static abstract class LazyAnnotationValue<U, V> extends AnnotationValue.AbstractBase<U, V> {
                private transient /* synthetic */ int hashCode;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class ForAnnotationValue extends LazyAnnotationValue<AnnotationDescription, Annotation> {
                    private final AnnotationToken annotationToken;
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final TypePool typePool;

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<AnnotationDescription, Annotation> doResolve() {
                        AnnotationValue<AnnotationDescription, Annotation> forMissingType = null;
                        Object[] objArr = 0;
                        if (this.resolved == null) {
                            AnnotationToken.Resolution annotationDescription = this.annotationToken.toAnnotationDescription(this.typePool);
                            forMissingType = !annotationDescription.isResolved() ? new AnnotationValue.ForMissingType<>(this.annotationToken.getBinaryName()) : !annotationDescription.resolve().getAnnotationType().isAnnotation() ? new ForMismatchedType(annotationDescription.resolve().getAnnotationType().getName(), AnnotationValue.Sort.ANNOTATION) : new AnnotationValue.ForAnnotationDescription<>(annotationDescription.resolve());
                        }
                        if (forMissingType == null) {
                            return this.resolved;
                        }
                        this.resolved = forMissingType;
                        return forMissingType;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ANNOTATION;
                    }

                    private ForAnnotationValue(TypePool typePool, AnnotationToken annotationToken) {
                        super();
                        this.typePool = typePool;
                        this.annotationToken = annotationToken;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class ForArray extends LazyAnnotationValue<Object, Object> {
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final TypePool typePool;
                    private final List<AnnotationValue<?, ?>> values;

                    /* JADX WARN: Found duplicated region for block: B:46:0x014d  */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<Object, Object> doResolve() {
                        AnnotationValue.Sort sort;
                        ListIterator<AnnotationValue<?, ?>> listIterator;
                        AnnotationValue<Object, Object> forMismatchedType = null;
                        Object[] objArr = 0;
                        if (this.resolved == null) {
                            String strResolve = this.componentTypeReference.resolve();
                            if (strResolve != null) {
                                Resolution resolutionDescribe = this.typePool.describe(strResolve);
                                if (!resolutionDescribe.isResolved()) {
                                    forMismatchedType = new AnnotationValue.ForMissingType<>(strResolve);
                                } else if (resolutionDescribe.resolve().isEnum()) {
                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(EnumerationDescription.class, resolutionDescribe.resolve(), this.values);
                                } else if (resolutionDescribe.resolve().isAnnotation()) {
                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(AnnotationDescription.class, resolutionDescribe.resolve(), this.values);
                                } else if (resolutionDescribe.resolve().represents(Class.class)) {
                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(TypeDescription.class, resolutionDescribe.resolve(), this.values);
                                } else if (resolutionDescribe.resolve().represents(String.class)) {
                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(String.class, resolutionDescribe.resolve(), this.values);
                                } else {
                                    TypeDescription typeDescriptionResolve = resolutionDescribe.resolve();
                                    Class cls = Boolean.TYPE;
                                    if (typeDescriptionResolve.represents(cls)) {
                                        forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls, resolutionDescribe.resolve(), this.values);
                                    } else {
                                        TypeDescription typeDescriptionResolve2 = resolutionDescribe.resolve();
                                        Class cls2 = Byte.TYPE;
                                        if (typeDescriptionResolve2.represents(cls2)) {
                                            forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls2, resolutionDescribe.resolve(), this.values);
                                        } else {
                                            TypeDescription typeDescriptionResolve3 = resolutionDescribe.resolve();
                                            Class cls3 = Short.TYPE;
                                            if (typeDescriptionResolve3.represents(cls3)) {
                                                forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls3, resolutionDescribe.resolve(), this.values);
                                            } else {
                                                TypeDescription typeDescriptionResolve4 = resolutionDescribe.resolve();
                                                Class cls4 = Character.TYPE;
                                                if (typeDescriptionResolve4.represents(cls4)) {
                                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls4, resolutionDescribe.resolve(), this.values);
                                                } else {
                                                    TypeDescription typeDescriptionResolve5 = resolutionDescribe.resolve();
                                                    Class cls5 = Integer.TYPE;
                                                    if (typeDescriptionResolve5.represents(cls5)) {
                                                        forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls5, resolutionDescribe.resolve(), this.values);
                                                    } else {
                                                        TypeDescription typeDescriptionResolve6 = resolutionDescribe.resolve();
                                                        Class cls6 = Long.TYPE;
                                                        if (typeDescriptionResolve6.represents(cls6)) {
                                                            forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls6, resolutionDescribe.resolve(), this.values);
                                                        } else {
                                                            TypeDescription typeDescriptionResolve7 = resolutionDescribe.resolve();
                                                            Class cls7 = Float.TYPE;
                                                            if (typeDescriptionResolve7.represents(cls7)) {
                                                                forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls7, resolutionDescribe.resolve(), this.values);
                                                            } else {
                                                                TypeDescription typeDescriptionResolve8 = resolutionDescribe.resolve();
                                                                Class cls8 = Double.TYPE;
                                                                if (typeDescriptionResolve8.represents(cls8)) {
                                                                    forMismatchedType = new AnnotationValue.ForDescriptionArray<>(cls8, resolutionDescribe.resolve(), this.values);
                                                                } else {
                                                                    sort = AnnotationValue.Sort.NONE;
                                                                    List<AnnotationValue<?, ?>> list = this.values;
                                                                    listIterator = list.listIterator(list.size());
                                                                    while (listIterator.hasPrevious() && !sort.isDefined()) {
                                                                        sort = listIterator.previous().getSort();
                                                                    }
                                                                    forMismatchedType = new ForMismatchedType(AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(sort), sort);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                sort = AnnotationValue.Sort.NONE;
                                List<AnnotationValue<?, ?>> list2 = this.values;
                                listIterator = list2.listIterator(list2.size());
                                while (listIterator.hasPrevious()) {
                                    sort = listIterator.previous().getSort();
                                }
                                forMismatchedType = new ForMismatchedType(AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(sort), sort);
                            }
                        }
                        if (forMismatchedType == null) {
                            return this.resolved;
                        }
                        this.resolved = forMismatchedType;
                        return forMismatchedType;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ARRAY;
                    }

                    private ForArray(TypePool typePool, AbstractBase.ComponentTypeReference componentTypeReference, List<AnnotationValue<?, ?>> list) {
                        super();
                        this.typePool = typePool;
                        this.componentTypeReference = componentTypeReference;
                        this.values = list;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class ForEnumerationValue extends LazyAnnotationValue<EnumerationDescription, Enum<?>> {
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final String typeName;
                    private final TypePool typePool;
                    private final String value;

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<EnumerationDescription, Enum<?>> doResolve() {
                        AnnotationValue<EnumerationDescription, Enum<?>> withUnknownConstant = null;
                        Object[] objArr = 0;
                        if (this.resolved == null) {
                            Resolution resolutionDescribe = this.typePool.describe(this.typeName);
                            if (!resolutionDescribe.isResolved()) {
                                withUnknownConstant = new AnnotationValue.ForMissingType<>(this.typeName);
                            } else if (resolutionDescribe.resolve().isEnum()) {
                                withUnknownConstant = resolutionDescribe.resolve().getDeclaredFields().filter(ElementMatchers.named(this.value)).isEmpty() ? new AnnotationValue.ForEnumerationDescription.WithUnknownConstant<>(resolutionDescribe.resolve(), this.value) : new AnnotationValue.ForEnumerationDescription<>(new EnumerationDescription.Latent(resolutionDescribe.resolve(), this.value));
                            } else {
                                withUnknownConstant = new ForMismatchedType(this.typeName + "." + this.value, AnnotationValue.Sort.ENUMERATION);
                            }
                        }
                        if (withUnknownConstant == null) {
                            return this.resolved;
                        }
                        this.resolved = withUnknownConstant;
                        return withUnknownConstant;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ENUMERATION;
                    }

                    private ForEnumerationValue(TypePool typePool, String str, String str2) {
                        super();
                        this.typePool = typePool;
                        this.typeName = str;
                        this.value = str2;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ForMismatchedType<W, X> extends AnnotationValue.AbstractBase<W, X> {
                    private final AnnotationValue.Sort sort;
                    private final String value;

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        ForMismatchedType forMismatchedType = (ForMismatchedType) obj;
                        return this.sort.equals(forMismatchedType.sort) && this.value.equals(forMismatchedType.value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue<W, X> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
                        return new AnnotationValue.ForMismatchedType(inDefinedShape, inDefinedShape.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(this.sort) : this.value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.NONE;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.State getState() {
                        return AnnotationValue.State.UNRESOLVED;
                    }

                    public int hashCode() {
                        return this.sort.hashCode() + bjs.e(this.value, getClass().hashCode() * 31, 31);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Loaded<X> load(@MaybeNull ClassLoader classLoader) {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public W resolve() {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }

                    private ForMismatchedType(String str, AnnotationValue.Sort sort) {
                        this.value = str;
                        this.sort = sort;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class ForTypeValue extends LazyAnnotationValue<TypeDescription, Class<?>> {
                    private transient /* synthetic */ AnnotationValue resolved;
                    private final String typeName;
                    private final TypePool typePool;

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    public AnnotationValue<TypeDescription, Class<?>> doResolve() {
                        AnnotationValue<TypeDescription, Class<?>> forTypeDescription;
                        if (this.resolved != null) {
                            forTypeDescription = null;
                        } else {
                            Resolution resolutionDescribe = this.typePool.describe(this.typeName);
                            forTypeDescription = resolutionDescribe.isResolved() ? new AnnotationValue.ForTypeDescription(resolutionDescribe.resolve()) : new AnnotationValue.ForMissingType<>(this.typeName);
                        }
                        if (forTypeDescription == null) {
                            return this.resolved;
                        }
                        this.resolved = forTypeDescription;
                        return forTypeDescription;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.TYPE;
                    }

                    private ForTypeValue(TypePool typePool, String str) {
                        super();
                        this.typePool = typePool;
                        this.typeName = str;
                    }
                }

                private LazyAnnotationValue() {
                }

                public abstract AnnotationValue<U, V> doResolve();

                public boolean equals(@MaybeNull Object obj) {
                    return doResolve().equals(obj);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape inDefinedShape, TypeDefinition typeDefinition) {
                    return doResolve().filter(inDefinedShape, typeDefinition);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue.State getState() {
                    return doResolve().getState();
                }

                @CachedReturnPlugin.Enhance("hashCode")
                public int hashCode() {
                    int iHashCode = this.hashCode != 0 ? 0 : doResolve().hashCode();
                    if (iHashCode == 0) {
                        return this.hashCode;
                    }
                    this.hashCode = iHashCode;
                    return iHashCode;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue.Loaded<V> load(@MaybeNull ClassLoader classLoader) {
                    return doResolve().load(classLoader);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public U resolve() {
                    return doResolve().resolve();
                }

                public String toString() {
                    return doResolve().toString();
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class LazyFieldDescription extends FieldDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;

                @MaybeNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.field.FieldDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return this.modifiers;
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.field.FieldDescription
                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveFieldType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                private LazyFieldDescription(String str, int i, String str2, @MaybeNull String str3, GenericTypeToken.Resolution.ForField forField, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.modifiers = i;
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = forField;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                @Override // net.bytebuddy.description.field.FieldDescription, net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                @Nonnull
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class LazyMethodDescription extends MethodDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;

                @MaybeNull
                private final AnnotationValue<?, ?> defaultValue;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;
                private final List<String> exceptionTypeDescriptors;

                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private final int modifiers;
                private final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                private final Integer[] parameterModifiers;
                private final String[] parameterNames;
                private final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                private final List<String> parameterTypeDescriptors;
                private final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final String returnTypeDescriptor;
                private final GenericTypeToken.Resolution.ForMethod signatureResolution;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyNonGenericReceiverType extends TypeDescription.Generic.OfNonGenericType {
                    private final TypeDescription typeDescription;

                    public LazyNonGenericReceiverType(LazyMethodDescription lazyMethodDescription) {
                        this(LazyTypeDescription.this);
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < this.typeDescription.getInnerClassCount(); i++) {
                            sb.append(GenericTypeToken.INNER_CLASS_PATH);
                        }
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(sb.toString()));
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    @MaybeNull
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        return declaringType == null ? TypeDescription.Generic.UNDEFINED : LazyMethodDescription.this.new LazyNonGenericReceiverType(declaringType);
                    }

                    public LazyNonGenericReceiverType(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    @MaybeNull
                    public TypeDescription.Generic getComponentType() {
                        return TypeDescription.Generic.UNDEFINED;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyParameterDescription extends ParameterDescription.InDefinedShape.AbstractBase {
                    private final int index;

                    public LazyParameterDescription(int i) {
                        this.index = i;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.parameterAnnotationTokens.get(Integer.valueOf(this.index)));
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public int getIndex() {
                        return this.index;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        return hasModifiers() ? LazyMethodDescription.this.parameterModifiers[this.index].intValue() : super.getModifiers();
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getName() {
                        return isNamed() ? LazyMethodDescription.this.parameterNames[this.index] : super.getName();
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public TypeDescription.Generic getType() {
                        return LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyTypeDescription.this.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this).get(this.index);
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public boolean hasModifiers() {
                        return LazyMethodDescription.this.parameterModifiers[this.index] != null;
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithOptionalName
                    public boolean isNamed() {
                        return LazyMethodDescription.this.parameterNames[this.index] != null;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
                    public MethodDescription.InDefinedShape getDeclaringMethod() {
                        return LazyMethodDescription.this;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyParameterList extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape> {
                    private LazyParameterList() {
                    }

                    @Override // net.bytebuddy.description.method.ParameterList.AbstractBase, net.bytebuddy.description.method.ParameterList
                    public TypeList.Generic asTypeList() {
                        return LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyTypeDescription.this.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this);
                    }

                    @Override // net.bytebuddy.description.method.ParameterList.AbstractBase, net.bytebuddy.description.method.ParameterList
                    public boolean hasExplicitMetaData() {
                        for (int i = 0; i < size(); i++) {
                            if (LazyMethodDescription.this.parameterNames[i] == null || LazyMethodDescription.this.parameterModifiers[i] == null) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return LazyMethodDescription.this.parameterTypeDescriptors.size();
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public ParameterDescription.InDefinedShape get(int i) {
                        return LazyMethodDescription.this.new LazyParameterDescription(i);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyParameterizedReceiverType extends TypeDescription.Generic.OfParameterizedType {
                    private final TypeDescription typeDescription;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public class TypeArgumentList extends TypeList.Generic.AbstractBase {
                        private final List<? extends TypeDescription.Generic> typeVariables;

                        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                        public class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final int index;
                            private final TypeDescription.Generic typeVariable;

                            public AnnotatedTypeVariable(TypeDescription.Generic generic, int i) {
                                this.typeVariable = generic;
                                this.index = i;
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(LazyParameterizedReceiverType.this.getTypePath() + this.index + GenericTypeToken.INDEXED_TYPE_DELIMITER));
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public String getSymbol() {
                                return this.typeVariable.getSymbol();
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeVariableSource getTypeVariableSource() {
                                return this.typeVariable.getTypeVariableSource();
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeList.Generic getUpperBounds() {
                                return this.typeVariable.getUpperBounds();
                            }
                        }

                        public TypeArgumentList(List<? extends TypeDescription.Generic> list) {
                            this.typeVariables = list;
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                        public int size() {
                            return this.typeVariables.size();
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int i) {
                            return new AnnotatedTypeVariable(this.typeVariables.get(i), i);
                        }
                    }

                    public LazyParameterizedReceiverType(LazyMethodDescription lazyMethodDescription) {
                        this(LazyTypeDescription.this);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public String getTypePath() {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < this.typeDescription.getInnerClassCount(); i++) {
                            sb.append(GenericTypeToken.INNER_CLASS_PATH);
                        }
                        return sb.toString();
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(getTypePath()));
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    @MaybeNull
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        return declaringType == null ? TypeDescription.Generic.UNDEFINED : (this.typeDescription.isStatic() || !declaringType.isGenerified()) ? LazyMethodDescription.this.new LazyNonGenericReceiverType(declaringType) : LazyMethodDescription.this.new LazyParameterizedReceiverType(declaringType);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeList.Generic getTypeArguments() {
                        return new TypeArgumentList(this.typeDescription.getTypeVariables());
                    }

                    public LazyParameterizedReceiverType(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                @MaybeNull
                public AnnotationValue<?, ?> getDefaultValue() {
                    return this.defaultValue;
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeList.Generic getExceptionTypes() {
                    return this.signatureResolution.resolveExceptionTypes(this.exceptionTypeDescriptors, LazyTypeDescription.this.typePool, this.exceptionTypeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getInternalName() {
                    return this.internalName;
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return this.modifiers;
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new LazyParameterList();
                }

                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
                @MaybeNull
                public TypeDescription.Generic getReceiverType() {
                    if (isStatic()) {
                        return TypeDescription.Generic.UNDEFINED;
                    }
                    if (!isConstructor()) {
                        return LazyTypeDescription.this.isGenerified() ? new LazyParameterizedReceiverType(this) : new LazyNonGenericReceiverType(this);
                    }
                    TypeDescription declaringType = getDeclaringType();
                    TypeDescription enclosingType = declaringType.getEnclosingType();
                    return enclosingType == null ? declaringType.isGenerified() ? new LazyParameterizedReceiverType(declaringType) : new LazyNonGenericReceiverType(declaringType) : (declaringType.isStatic() || !declaringType.isGenerified()) ? new LazyNonGenericReceiverType(enclosingType) : new LazyParameterizedReceiverType(enclosingType);
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReturnType() {
                    return this.signatureResolution.resolveReturnType(this.returnTypeDescriptor, LazyTypeDescription.this.typePool, this.returnTypeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.TypeVariableSource
                public TypeList.Generic getTypeVariables() {
                    return this.signatureResolution.resolveTypeVariables(LazyTypeDescription.this.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens);
                }

                private LazyMethodDescription(String str, int i, String str2, @MaybeNull String str3, GenericTypeToken.Resolution.ForMethod forMethod, @MaybeNull String[] strArr, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2, Map<String, List<AnnotationToken>> map3, Map<Integer, Map<String, List<AnnotationToken>>> map4, Map<Integer, Map<String, List<AnnotationToken>>> map5, Map<String, List<AnnotationToken>> map6, List<AnnotationToken> list, Map<Integer, List<AnnotationToken>> map7, List<MethodToken.ParameterToken> list2, @MaybeNull AnnotationValue<?, ?> annotationValue) {
                    this.modifiers = i;
                    this.internalName = str;
                    Type methodType = Type.getMethodType(str2);
                    Type returnType = methodType.getReturnType();
                    Type[] argumentTypes = methodType.getArgumentTypes();
                    this.returnTypeDescriptor = returnType.getDescriptor();
                    this.parameterTypeDescriptors = new ArrayList(argumentTypes.length);
                    int i2 = 0;
                    for (Type type : argumentTypes) {
                        this.parameterTypeDescriptors.add(type.getDescriptor());
                    }
                    this.genericSignature = str3;
                    this.signatureResolution = forMethod;
                    if (strArr == null) {
                        this.exceptionTypeDescriptors = Collections.EMPTY_LIST;
                    } else {
                        this.exceptionTypeDescriptors = new ArrayList(strArr.length);
                        for (String str4 : strArr) {
                            this.exceptionTypeDescriptors.add(Type.getObjectType(str4).getDescriptor());
                        }
                    }
                    this.typeVariableAnnotationTokens = map;
                    this.typeVariableBoundAnnotationTokens = map2;
                    this.returnTypeAnnotationTokens = map3;
                    this.parameterTypeAnnotationTokens = map4;
                    this.exceptionTypeAnnotationTokens = map5;
                    this.receiverTypeAnnotationTokens = map6;
                    this.annotationTokens = list;
                    this.parameterAnnotationTokens = map7;
                    this.parameterNames = new String[argumentTypes.length];
                    this.parameterModifiers = new Integer[argumentTypes.length];
                    if (list2.size() == argumentTypes.length) {
                        for (MethodToken.ParameterToken parameterToken : list2) {
                            this.parameterNames[i2] = parameterToken.getName();
                            this.parameterModifiers[i2] = parameterToken.getModifiers();
                            i2++;
                        }
                    }
                    this.defaultValue = annotationValue;
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                @Nonnull
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class LazyModuleDescription extends ModuleDescription.AbstractBase {
                private final Map<String, ModuleDescription.Exports> exports;

                @MaybeNull
                private final String mainClass;
                private final int modifiers;
                private final String name;
                private final Map<String, ModuleDescription.Opens> opens;
                private final Set<String> packages;
                private final Map<String, ModuleDescription.Provides> provides;
                private final Map<String, ModuleDescription.Requires> requires;
                private final Set<String> uses;

                @MaybeNull
                private final String version;

                public LazyModuleDescription(String str, int i, @MaybeNull String str2, @MaybeNull String str3, Set<String> set, Map<String, ModuleDescription.Requires> map, Map<String, ModuleDescription.Exports> map2, Map<String, ModuleDescription.Opens> map3, Set<String> set2, Map<String, ModuleDescription.Provides> map4) {
                    this.name = str;
                    this.modifiers = i;
                    this.version = str2;
                    this.mainClass = str3;
                    this.packages = set;
                    this.requires = map;
                    this.exports = map2;
                    this.opens = map3;
                    this.uses = set2;
                    this.provides = map4;
                }

                @Override // net.bytebuddy.description.NamedElement
                public String getActualName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, LazyTypeDescription.this.annotationTokens);
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Map<String, ModuleDescription.Exports> getExports() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, ModuleDescription.Exports> entry : this.exports.entrySet()) {
                        linkedHashMap.put(entry.getKey().replace('/', GenericTypeToken.INNER_CLASS_PATH), new ModuleDescription.Exports.Simple(new LinkedHashSet(entry.getValue().getTargets()), entry.getValue().getModifiers()));
                    }
                    return linkedHashMap;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                @MaybeNull
                public String getMainClass() {
                    String str = this.mainClass;
                    if (str == null) {
                        return null;
                    }
                    return str.replace('/', GenericTypeToken.INNER_CLASS_PATH);
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return this.modifiers;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Map<String, ModuleDescription.Opens> getOpens() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, ModuleDescription.Opens> entry : this.opens.entrySet()) {
                        linkedHashMap.put(entry.getKey().replace('/', GenericTypeToken.INNER_CLASS_PATH), new ModuleDescription.Opens.Simple(new LinkedHashSet(entry.getValue().getTargets()), entry.getValue().getModifiers()));
                    }
                    return linkedHashMap;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Set<String> getPackages() {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator<String> it = this.packages.iterator();
                    while (it.hasNext()) {
                        linkedHashSet.add(it.next().replace('/', GenericTypeToken.INNER_CLASS_PATH));
                    }
                    return linkedHashSet;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Map<String, ModuleDescription.Provides> getProvides() {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<String, ModuleDescription.Provides> entry : this.provides.entrySet()) {
                        LinkedHashSet linkedHashSet = new LinkedHashSet();
                        Iterator<String> it = entry.getValue().getProviders().iterator();
                        while (it.hasNext()) {
                            linkedHashSet.add(it.next().replace('/', GenericTypeToken.INNER_CLASS_PATH));
                        }
                        linkedHashMap.put(entry.getKey().replace('/', GenericTypeToken.INNER_CLASS_PATH), new ModuleDescription.Provides.Simple(linkedHashSet));
                    }
                    return linkedHashMap;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Map<String, ModuleDescription.Requires> getRequires() {
                    return new LinkedHashMap(this.requires);
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                public Set<String> getUses() {
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    Iterator<String> it = this.uses.iterator();
                    while (it.hasNext()) {
                        linkedHashSet.add(it.next().replace('/', GenericTypeToken.INNER_CLASS_PATH));
                    }
                    return linkedHashSet;
                }

                @Override // net.bytebuddy.description.module.ModuleDescription
                @MaybeNull
                public String getVersion() {
                    return this.version;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class LazyNestMemberList extends TypeList.AbstractBase {
                private final List<String> nestMembers;
                private final TypeDescription typeDescription;
                private final TypePool typePool;

                public LazyNestMemberList(TypeDescription typeDescription, TypePool typePool, List<String> list) {
                    this.typeDescription = typeDescription;
                    this.typePool = typePool;
                    this.nestMembers = list;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public int getStackSize() {
                    return this.nestMembers.size() + 1;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return this.nestMembers.size() + 1;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public String[] toInternalNames() {
                    int i = 1;
                    String[] strArr = new String[this.nestMembers.size() + 1];
                    strArr[0] = this.typeDescription.getInternalName();
                    Iterator<String> it = this.nestMembers.iterator();
                    while (it.hasNext()) {
                        strArr[i] = it.next().replace(GenericTypeToken.INNER_CLASS_PATH, '/');
                        i++;
                    }
                    return strArr;
                }

                @Override // java.util.AbstractList, java.util.List
                public TypeDescription get(int i) {
                    return i == 0 ? this.typeDescription : this.typePool.describe(this.nestMembers.get(i - 1)).resolve();
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class LazyPackageDescription extends PackageDescription.AbstractBase {
                private final String name;
                private final TypePool typePool;

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    Resolution resolutionDescribe = this.typePool.describe(this.name + ".package-info");
                    return resolutionDescribe.isResolved() ? resolutionDescribe.resolve().getDeclaredAnnotations() : new AnnotationList.Empty();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }

                private LazyPackageDescription(TypePool typePool, String str) {
                    this.typePool = typePool;
                    this.name = str;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class LazyRecordComponentDescription extends RecordComponentDescription.InDefinedShape.AbstractBase {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;

                @MaybeNull
                private final String genericSignature;
                private final String name;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                @Override // net.bytebuddy.description.NamedElement
                public String getActualName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.type.RecordComponentDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                @MaybeNull
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                @Override // net.bytebuddy.description.type.RecordComponentDescription
                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveRecordType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                private LazyRecordComponentDescription(String str, String str2, @MaybeNull String str3, GenericTypeToken.Resolution.ForRecordComponent forRecordComponent, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = forRecordComponent;
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                @Override // net.bytebuddy.description.DeclaredByType.WithMandatoryDeclaration, net.bytebuddy.description.DeclaredByType
                @Nonnull
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class LazyTypeList extends TypeList.AbstractBase {
                private final List<String> descriptors;
                private final TypePool typePool;

                public LazyTypeList(TypePool typePool, List<String> list) {
                    this.typePool = typePool;
                    this.descriptors = list;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public int getStackSize() {
                    Iterator<String> it = this.descriptors.iterator();
                    int size = 0;
                    while (it.hasNext()) {
                        size += Type.getType(it.next()).getSize();
                    }
                    return size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return this.descriptors.size();
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                @MaybeNull
                public String[] toInternalNames() {
                    int size = this.descriptors.size();
                    String[] strArr = new String[size];
                    Iterator<String> it = this.descriptors.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        strArr[i] = Type.getType(it.next()).getInternalName();
                        i++;
                    }
                    return size == 0 ? TypeList.NO_INTERFACES : strArr;
                }

                @Override // java.util.AbstractList, java.util.List
                public TypeDescription get(int i) {
                    return TokenizedGenericType.toErasure(this.typePool, this.descriptors.get(i));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class MethodToken {
                private final List<AnnotationToken> annotationTokens;

                @UnknownNull
                private final AnnotationValue<?, ?> defaultValue;
                private final String descriptor;

                @MaybeNull
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;

                @UnknownNull
                private final String genericSignature;
                private final int modifiers;
                private final String name;
                private final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                private final List<ParameterToken> parameterTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final GenericTypeToken.Resolution.ForMethod signatureResolution;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class ParameterToken {

                    @AlwaysNull
                    protected static final Integer NO_MODIFIERS = null;

                    @AlwaysNull
                    protected static final String NO_NAME = null;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final Integer modifiers;

                    @MaybeNull
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final String name;

                    public ParameterToken() {
                        this(NO_NAME);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
                    
                        if (r2 != null) goto L18;
                     */
                    /* JADX WARN: Found duplicated region for block: B:27:0x0039 A[RETURN] */
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
                            java.lang.Integer r2 = r4.modifiers
                            net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$MethodToken$ParameterToken r5 = (net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken) r5
                            java.lang.Integer r3 = r5.modifiers
                            if (r3 == 0) goto L24
                            if (r2 == 0) goto L26
                            boolean r2 = r2.equals(r3)
                            if (r2 != 0) goto L27
                            return r1
                        L24:
                            if (r2 == 0) goto L27
                        L26:
                            return r1
                        L27:
                            java.lang.String r2 = r4.name
                            java.lang.String r5 = r5.name
                            if (r5 == 0) goto L36
                            if (r2 == 0) goto L38
                            boolean r5 = r2.equals(r5)
                            if (r5 != 0) goto L39
                            return r1
                        L36:
                            if (r2 == 0) goto L39
                        L38:
                            return r1
                        L39:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.MethodToken.ParameterToken.equals(java.lang.Object):boolean");
                    }

                    @MaybeNull
                    public Integer getModifiers() {
                        return this.modifiers;
                    }

                    @MaybeNull
                    public String getName() {
                        return this.name;
                    }

                    public int hashCode() {
                        int iHashCode = getClass().hashCode() * 31;
                        String str = this.name;
                        if (str != null) {
                            iHashCode += str.hashCode();
                        }
                        int i = iHashCode * 31;
                        Integer num = this.modifiers;
                        return num != null ? num.hashCode() + i : i;
                    }

                    public ParameterToken(@MaybeNull String str) {
                        this(str, NO_MODIFIERS);
                    }

                    public ParameterToken(@MaybeNull String str, @MaybeNull Integer num) {
                        this.name = str;
                        this.modifiers = num;
                    }
                }

                public MethodToken(String str, int i, String str2, @MaybeNull String str3, @MaybeNull String[] strArr, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2, Map<String, List<AnnotationToken>> map3, Map<Integer, Map<String, List<AnnotationToken>>> map4, Map<Integer, Map<String, List<AnnotationToken>>> map5, Map<String, List<AnnotationToken>> map6, List<AnnotationToken> list, Map<Integer, List<AnnotationToken>> map7, List<ParameterToken> list2, @MaybeNull AnnotationValue<?, ?> annotationValue) {
                    this.modifiers = i & (-131073);
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfMethod.extract(str3);
                    this.exceptionName = strArr;
                    this.typeVariableAnnotationTokens = map;
                    this.typeVariableBoundAnnotationTokens = map2;
                    this.returnTypeAnnotationTokens = map3;
                    this.parameterTypeAnnotationTokens = map4;
                    this.exceptionTypeAnnotationTokens = map5;
                    this.receiverTypeAnnotationTokens = map6;
                    this.annotationTokens = list;
                    this.parameterAnnotationTokens = map7;
                    this.parameterTokens = list2;
                    this.defaultValue = annotationValue;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public MethodDescription.InDefinedShape toMethodDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyMethodDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.exceptionName, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens, this.returnTypeAnnotationTokens, this.parameterTypeAnnotationTokens, this.exceptionTypeAnnotationTokens, this.receiverTypeAnnotationTokens, this.annotationTokens, this.parameterAnnotationTokens, this.parameterTokens, this.defaultValue);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    MethodToken methodToken = (MethodToken) obj;
                    return this.modifiers == methodToken.modifiers && this.name.equals(methodToken.name) && this.descriptor.equals(methodToken.descriptor) && this.genericSignature.equals(methodToken.genericSignature) && this.signatureResolution.equals(methodToken.signatureResolution) && Arrays.equals(this.exceptionName, methodToken.exceptionName) && this.typeVariableAnnotationTokens.equals(methodToken.typeVariableAnnotationTokens) && this.typeVariableBoundAnnotationTokens.equals(methodToken.typeVariableBoundAnnotationTokens) && this.returnTypeAnnotationTokens.equals(methodToken.returnTypeAnnotationTokens) && this.parameterTypeAnnotationTokens.equals(methodToken.parameterTypeAnnotationTokens) && this.exceptionTypeAnnotationTokens.equals(methodToken.exceptionTypeAnnotationTokens) && this.receiverTypeAnnotationTokens.equals(methodToken.receiverTypeAnnotationTokens) && this.annotationTokens.equals(methodToken.annotationTokens) && this.parameterAnnotationTokens.equals(methodToken.parameterAnnotationTokens) && this.parameterTokens.equals(methodToken.parameterTokens) && this.defaultValue.equals(methodToken.defaultValue);
                }

                public int hashCode() {
                    return this.defaultValue.hashCode() + bjs.g(this.parameterTokens, yg.c(this.parameterAnnotationTokens, bjs.g(this.annotationTokens, yg.c(this.receiverTypeAnnotationTokens, yg.c(this.exceptionTypeAnnotationTokens, yg.c(this.parameterTypeAnnotationTokens, yg.c(this.returnTypeAnnotationTokens, yg.c(this.typeVariableBoundAnnotationTokens, yg.c(this.typeVariableAnnotationTokens, (((this.signatureResolution.hashCode() + bjs.e(this.genericSignature, bjs.e(this.descriptor, (bjs.e(this.name, getClass().hashCode() * 31, 31) + this.modifiers) * 31, 31), 31)) * 31) + Arrays.hashCode(this.exceptionName)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class MethodTokenList extends MethodList.AbstractBase<MethodDescription.InDefinedShape> {
                public MethodTokenList() {
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return LazyTypeDescription.this.methodTokens.size();
                }

                @Override // java.util.AbstractList, java.util.List
                public MethodDescription.InDefinedShape get(int i) {
                    return ((MethodToken) LazyTypeDescription.this.methodTokens.get(i)).toMethodDescription(LazyTypeDescription.this);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class ModuleToken {
                private final Map<String, ModuleDescription.Exports> exports;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final String mainClass;
                private final int modifiers;
                private final String name;
                private final Map<String, ModuleDescription.Opens> opens;
                private final Set<String> packages;
                private final Map<String, ModuleDescription.Provides> provides;
                private final Map<String, ModuleDescription.Requires> requires;
                private final Set<String> uses;

                @MaybeNull
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final String version;

                public ModuleToken(String str, int i, @MaybeNull String str2, @MaybeNull String str3, Set<String> set, Map<String, ModuleDescription.Requires> map, Map<String, ModuleDescription.Exports> map2, Map<String, ModuleDescription.Opens> map3, Set<String> set2, Map<String, ModuleDescription.Provides> map4) {
                    this.name = str;
                    this.modifiers = i;
                    this.version = str2;
                    this.mainClass = str3;
                    this.packages = set;
                    this.requires = map;
                    this.exports = map2;
                    this.opens = map3;
                    this.uses = set2;
                    this.provides = map4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public LazyModuleDescription toModuleDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return lazyTypeDescription.new LazyModuleDescription(this.name, this.modifiers, this.version, this.mainClass, this.packages, this.requires, this.exports, this.opens, this.uses, this.provides);
                }

                /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
                
                    if (r2 != null) goto L24;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
                
                    if (r2 != null) goto L32;
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
                        int r2 = r4.modifiers
                        net.bytebuddy.pool.TypePool$Default$LazyTypeDescription$ModuleToken r5 = (net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.ModuleToken) r5
                        int r3 = r5.modifiers
                        if (r2 == r3) goto L1c
                        return r1
                    L1c:
                        java.lang.String r2 = r4.name
                        java.lang.String r3 = r5.name
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L27
                        return r1
                    L27:
                        java.lang.String r2 = r4.version
                        java.lang.String r3 = r5.version
                        if (r3 == 0) goto L36
                        if (r2 == 0) goto L38
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L39
                        return r1
                    L36:
                        if (r2 == 0) goto L39
                    L38:
                        return r1
                    L39:
                        java.lang.String r2 = r4.mainClass
                        java.lang.String r3 = r5.mainClass
                        if (r3 == 0) goto L48
                        if (r2 == 0) goto L4a
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L4b
                        return r1
                    L48:
                        if (r2 == 0) goto L4b
                    L4a:
                        return r1
                    L4b:
                        java.util.Set<java.lang.String> r2 = r4.packages
                        java.util.Set<java.lang.String> r3 = r5.packages
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L56
                        return r1
                    L56:
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Requires> r2 = r4.requires
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Requires> r3 = r5.requires
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L61
                        return r1
                    L61:
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Exports> r2 = r4.exports
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Exports> r3 = r5.exports
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L6c
                        return r1
                    L6c:
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Opens> r2 = r4.opens
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Opens> r3 = r5.opens
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L77
                        return r1
                    L77:
                        java.util.Set<java.lang.String> r2 = r4.uses
                        java.util.Set<java.lang.String> r3 = r5.uses
                        boolean r2 = r2.equals(r3)
                        if (r2 != 0) goto L82
                        return r1
                    L82:
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Provides> r2 = r4.provides
                        java.util.Map<java.lang.String, net.bytebuddy.description.module.ModuleDescription$Provides> r5 = r5.provides
                        boolean r5 = r2.equals(r5)
                        if (r5 != 0) goto L8d
                        return r1
                    L8d:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.ModuleToken.equals(java.lang.Object):boolean");
                }

                public int hashCode() {
                    int iE = (bjs.e(this.name, getClass().hashCode() * 31, 31) + this.modifiers) * 31;
                    String str = this.version;
                    if (str != null) {
                        iE += str.hashCode();
                    }
                    int iHashCode = iE * 31;
                    String str2 = this.mainClass;
                    if (str2 != null) {
                        iHashCode += str2.hashCode();
                    }
                    return this.provides.hashCode() + ((this.uses.hashCode() + yg.c(this.opens, yg.c(this.exports, yg.c(this.requires, (this.packages.hashCode() + (iHashCode * 31)) * 31, 31), 31), 31)) * 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance
            public static class RecordComponentToken {
                private final List<AnnotationToken> annotationTokens;
                private final String descriptor;

                @UnknownNull
                private final String genericSignature;
                private final String name;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;

                public RecordComponentToken(String str, String str2, @MaybeNull String str3, Map<String, List<AnnotationToken>> map, List<AnnotationToken> list) {
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfRecordComponent.extract(str3);
                    this.typeAnnotationTokens = map;
                    this.annotationTokens = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public RecordComponentDescription.InDefinedShape toRecordComponentDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyRecordComponentDescription(this.name, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    RecordComponentToken recordComponentToken = (RecordComponentToken) obj;
                    return this.name.equals(recordComponentToken.name) && this.descriptor.equals(recordComponentToken.descriptor) && this.genericSignature.equals(recordComponentToken.genericSignature) && this.signatureResolution.equals(recordComponentToken.signatureResolution) && this.typeAnnotationTokens.equals(recordComponentToken.typeAnnotationTokens) && this.annotationTokens.equals(recordComponentToken.annotationTokens);
                }

                public int hashCode() {
                    return this.annotationTokens.hashCode() + yg.c(this.typeAnnotationTokens, (this.signatureResolution.hashCode() + bjs.e(this.genericSignature, bjs.e(this.descriptor, bjs.e(this.name, getClass().hashCode() * 31, 31), 31), 31)) * 31, 31);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class RecordComponentTokenList extends RecordComponentList.AbstractBase<RecordComponentDescription.InDefinedShape> {
                public RecordComponentTokenList() {
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return LazyTypeDescription.this.recordComponentTokens.size();
                }

                @Override // java.util.AbstractList, java.util.List
                public RecordComponentDescription.InDefinedShape get(int i) {
                    return ((RecordComponentToken) LazyTypeDescription.this.recordComponentTokens.get(i)).toRecordComponentDescription(LazyTypeDescription.this);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public static class TokenizedGenericType extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                private final Map<String, List<AnnotationToken>> annotationTokens;
                private transient /* synthetic */ TypeDescription erasure;
                private final GenericTypeToken genericTypeToken;
                private final String rawTypeDescriptor;
                private transient /* synthetic */ TypeDescription.Generic resolved;
                private final TypePool typePool;
                private final TypeVariableSource typeVariableSource;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class Malformed extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                    private final String rawTypeDescriptor;
                    private final TypePool typePool;

                    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                    public static class TokenList extends TypeList.Generic.AbstractBase {
                        private final List<String> rawTypeDescriptors;
                        private final TypePool typePool;

                        public TokenList(TypePool typePool, List<String> list) {
                            this.typePool = typePool;
                            this.rawTypeDescriptors = list;
                        }

                        @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                        public TypeList asErasures() {
                            return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                        }

                        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                        public int size() {
                            return this.rawTypeDescriptors.size();
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int i) {
                            return new Malformed(this.typePool, this.rawTypeDescriptors.get(i));
                        }
                    }

                    public Malformed(TypePool typePool, String str) {
                        this.typePool = typePool;
                        this.rawTypeDescriptor = str;
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptor);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        throw new GenericSignatureFormatError();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    public TypeDescription.Generic resolve() {
                        throw new GenericSignatureFormatError();
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class TokenList extends TypeList.Generic.AbstractBase {
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                    private final List<GenericTypeToken> genericTypeTokens;
                    private final List<String> rawTypeDescriptors;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;

                    @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                    public TypeList asErasures() {
                        return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return this.rawTypeDescriptors.size();
                    }

                    private TokenList(TypePool typePool, List<GenericTypeToken> list, Map<Integer, Map<String, List<AnnotationToken>>> map, List<String> list2, TypeVariableSource typeVariableSource) {
                        this.typePool = typePool;
                        this.genericTypeTokens = list;
                        this.annotationTokens = map;
                        this.rawTypeDescriptors = list2;
                        this.typeVariableSource = typeVariableSource;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int i) {
                        return this.rawTypeDescriptors.size() == this.genericTypeTokens.size() ? TokenizedGenericType.of(this.typePool, this.genericTypeTokens.get(i), this.rawTypeDescriptors.get(i), this.annotationTokens.get(Integer.valueOf(i)), this.typeVariableSource) : TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptors.get(i)).asGenericType();
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public static class TypeVariableList extends TypeList.Generic.AbstractBase {
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                    private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens;
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;
                    private final List<GenericTypeToken.OfFormalTypeVariable> typeVariables;

                    public TypeVariableList(TypePool typePool, List<GenericTypeToken.OfFormalTypeVariable> list, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2) {
                        this.typePool = typePool;
                        this.typeVariables = list;
                        this.typeVariableSource = typeVariableSource;
                        this.annotationTokens = map;
                        this.boundAnnotationTokens = map2;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return this.typeVariables.size();
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int i) {
                        return this.typeVariables.get(i).toGenericType(this.typePool, this.typeVariableSource, this.annotationTokens.get(Integer.valueOf(i)), this.boundAnnotationTokens.get(Integer.valueOf(i)));
                    }
                }

                public TokenizedGenericType(TypePool typePool, GenericTypeToken genericTypeToken, String str, Map<String, List<AnnotationToken>> map, TypeVariableSource typeVariableSource) {
                    this.typePool = typePool;
                    this.genericTypeToken = genericTypeToken;
                    this.rawTypeDescriptor = str;
                    this.annotationTokens = map;
                    this.typeVariableSource = typeVariableSource;
                }

                public static TypeDescription.Generic of(TypePool typePool, GenericTypeToken genericTypeToken, String str, @MaybeNull Map<String, List<AnnotationToken>> map, TypeVariableSource typeVariableSource) {
                    if (map == null) {
                        map = Collections.EMPTY_MAP;
                    }
                    return new TokenizedGenericType(typePool, genericTypeToken, str, map, typeVariableSource);
                }

                public static TypeDescription toErasure(TypePool typePool, String str) {
                    Type type = Type.getType(str);
                    return typePool.describe(type.getSort() == 9 ? type.getInternalName().replace('/', GenericTypeToken.INNER_CLASS_PATH) : type.getClassName()).resolve();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                @CachedReturnPlugin.Enhance("erasure")
                public TypeDescription asErasure() {
                    TypeDescription erasure = this.erasure != null ? null : toErasure(this.typePool, this.rawTypeDescriptor);
                    if (erasure == null) {
                        return this.erasure;
                    }
                    this.erasure = erasure;
                    return erasure;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return resolve().getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                public TypeDescription.Generic resolve() {
                    TypeDescription.Generic genericType = this.resolved != null ? null : this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, "", this.annotationTokens);
                    if (genericType == null) {
                        return this.resolved;
                    }
                    this.resolved = genericType;
                    return genericType;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public interface TypeContainment {

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public enum SelfContained implements TypeContainment {
                    INSTANCE;

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    @MaybeNull
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    @MaybeNull
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return TypeDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return false;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return true;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WithinMethod implements TypeContainment {
                    private final String methodDescriptor;
                    private final String methodName;
                    private final String name;

                    public WithinMethod(String str, String str2, String str3) {
                        this.name = str.replace('/', GenericTypeToken.INNER_CLASS_PATH);
                        this.methodName = str2;
                        this.methodDescriptor = str3;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithinMethod withinMethod = (WithinMethod) obj;
                        return this.name.equals(withinMethod.name) && this.methodName.equals(withinMethod.methodName) && this.methodDescriptor.equals(withinMethod.methodDescriptor);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        TypeDescription enclosingType = getEnclosingType(typePool);
                        if (enclosingType == null) {
                            throw new IllegalStateException("Could not resolve enclosing type " + this.name);
                        }
                        MethodList methodListFilter = enclosingType.getDeclaredMethods().filter(ElementMatchers.hasMethodName(this.methodName).and(ElementMatchers.hasDescriptor(this.methodDescriptor)));
                        if (!methodListFilter.isEmpty()) {
                            return (MethodDescription.InDefinedShape) methodListFilter.getOnly();
                        }
                        throw new IllegalStateException(this.methodName + this.methodDescriptor + " not declared by " + enclosingType);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    public int hashCode() {
                        return this.methodDescriptor.hashCode() + bjs.e(this.methodName, bjs.e(this.name, getClass().hashCode() * 31, 31), 31);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return true;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return false;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                @HashCodeAndEqualsPlugin.Enhance
                public static class WithinType implements TypeContainment {
                    private final boolean localType;
                    private final String name;

                    public WithinType(String str, boolean z) {
                        this.name = str.replace('/', GenericTypeToken.INNER_CLASS_PATH);
                        this.localType = z;
                    }

                    public boolean equals(@MaybeNull Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        WithinType withinType = (WithinType) obj;
                        return this.localType == withinType.localType && this.name.equals(withinType.name);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    @MaybeNull
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    public int hashCode() {
                        return bjs.e(this.name, getClass().hashCode() * 31, 31) + (this.localType ? 1 : 0);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return this.localType;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return false;
                    }
                }

                @MaybeNull
                MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool);

                @MaybeNull
                TypeDescription getEnclosingType(TypePool typePool);

                boolean isLocalType();

                boolean isSelfContained();
            }

            public LazyTypeDescription(TypePool typePool, int i, int i2, String str, @MaybeNull String str2, @MaybeNull String[] strArr, @MaybeNull String str3, TypeContainment typeContainment, @MaybeNull String str4, List<String> list, boolean z, @MaybeNull String str5, List<String> list2, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2, Map<Integer, Map<String, List<AnnotationToken>>> map3, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map4, List<AnnotationToken> list3, @MaybeNull ModuleToken moduleToken, List<FieldToken> list4, List<MethodToken> list5, List<RecordComponentToken> list6, List<String> list7, ClassFileVersion classFileVersion) {
                this.typePool = typePool;
                this.actualModifiers = i & (-33);
                this.modifiers = (-131105) & i2;
                this.name = Type.getObjectType(str).getClassName();
                this.superClassDescriptor = str2 == null ? NO_TYPE : Type.getObjectType(str2).getDescriptor();
                this.genericSignature = str3;
                this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfType.extract(str3);
                if (strArr == null) {
                    this.interfaceTypeDescriptors = Collections.EMPTY_LIST;
                } else {
                    this.interfaceTypeDescriptors = new ArrayList(strArr.length);
                    for (String str6 : strArr) {
                        this.interfaceTypeDescriptors.add(Type.getObjectType(str6).getDescriptor());
                    }
                }
                this.typeContainment = typeContainment;
                this.declaringTypeName = str4 == null ? NO_TYPE : str4.replace('/', GenericTypeToken.INNER_CLASS_PATH);
                this.declaredTypes = list;
                this.anonymousType = z;
                this.nestHost = str5 == null ? NO_TYPE : Type.getObjectType(str5).getClassName();
                this.nestMembers = new ArrayList(list2.size());
                Iterator<String> it = list2.iterator();
                while (it.hasNext()) {
                    this.nestMembers.add(Type.getObjectType(it.next()).getClassName());
                }
                this.superClassAnnotationTokens = map;
                this.interfaceAnnotationTokens = map2;
                this.typeVariableAnnotationTokens = map3;
                this.typeVariableBoundsAnnotationTokens = map4;
                this.annotationTokens = list3;
                this.moduleToken = moduleToken;
                this.fieldTokens = list4;
                this.methodTokens = list5;
                this.recordComponentTokens = list6;
                this.permittedSubclasses = new ArrayList(list7.size());
                Iterator<String> it2 = list7.iterator();
                while (it2.hasNext()) {
                    this.permittedSubclasses.add(Type.getObjectType(it2.next()).getDescriptor());
                }
                this.classFileVersion = classFileVersion;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public int getActualModifiers(boolean z) {
                return z ? this.actualModifiers | 32 : this.actualModifiers;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public ClassFileVersion getClassFileVersion() {
                return this.classFileVersion;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return LazyAnnotationDescription.asList(this.typePool, this.annotationTokens);
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                return new FieldTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                return new MethodTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getDeclaredTypes() {
                return new LazyTypeList(this.typePool, this.declaredTypes);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            @MaybeNull
            public MethodDescription.InDefinedShape getEnclosingMethod() {
                return this.typeContainment.getEnclosingMethod(this.typePool);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            @MaybeNull
            public TypeDescription getEnclosingType() {
                return this.typeContainment.getEnclosingType(this.typePool);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
            @MaybeNull
            public String getGenericSignature() {
                return this.genericSignature;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                return this.signatureResolution.resolveInterfaceTypes(this.interfaceTypeDescriptors, this.typePool, this.interfaceAnnotationTokens, this);
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return this.modifiers;
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getName() {
                return this.name;
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeDescription getNestHost() {
                String str = this.nestHost;
                return str == null ? this : this.typePool.describe(str).resolve();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getNestMembers() {
                String str = this.nestHost;
                return str == null ? new LazyNestMemberList(this, this.typePool, this.nestMembers) : this.typePool.describe(str).resolve().getNestMembers();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            @MaybeNull
            public PackageDescription getPackage() {
                String name = getName();
                int iLastIndexOf = name.lastIndexOf(46);
                return new LazyPackageDescription(this.typePool, iLastIndexOf == -1 ? "" : name.substring(0, iLastIndexOf));
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getPermittedSubtypes() {
                return new LazyTypeList(this.typePool, this.permittedSubclasses);
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                return new RecordComponentTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            @MaybeNull
            public TypeDescription.Generic getSuperClass() {
                return (this.superClassDescriptor == null || isInterface()) ? TypeDescription.Generic.UNDEFINED : this.signatureResolution.resolveSuperClass(this.superClassDescriptor, this.typePool, this.superClassAnnotationTokens, this);
            }

            @Override // net.bytebuddy.description.TypeVariableSource
            public TypeList.Generic getTypeVariables() {
                return this.signatureResolution.resolveTypeVariables(this.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public boolean isAnonymousType() {
                return this.anonymousType;
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public boolean isLocalType() {
                return !this.anonymousType && this.typeContainment.isLocalType();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return (this.actualModifiers & 65536) != 0 && JavaType.RECORD.getTypeStub().getDescriptor().equals(this.superClassDescriptor);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public boolean isSealed() {
                return !this.permittedSubclasses.isEmpty();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            @MaybeNull
            public ModuleDescription toModuleDescription() {
                ModuleToken moduleToken = this.moduleToken;
                return moduleToken == null ? ModuleDescription.UNDEFINED : moduleToken.toModuleDescription(this);
            }

            @Override // net.bytebuddy.description.DeclaredByType
            @MaybeNull
            public TypeDescription getDeclaringType() {
                String str = this.declaringTypeName;
                return str == null ? TypeDescription.UNDEFINED : this.typePool.describe(str).resolve();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class ParameterBag {
            private final Map<Integer, String> parameterRegistry = new HashMap();
            private final Type[] parameterType;

            public ParameterBag(Type[] typeArr) {
                this.parameterType = typeArr;
            }

            public void register(int i, String str) {
                this.parameterRegistry.put(Integer.valueOf(i), str);
            }

            public List<LazyTypeDescription.MethodToken.ParameterToken> resolve(boolean z) {
                ArrayList arrayList = new ArrayList(this.parameterType.length);
                int size = z ? StackSize.ZERO.getSize() : StackSize.SINGLE.getSize();
                for (Type type : this.parameterType) {
                    String str = this.parameterRegistry.get(Integer.valueOf(size));
                    arrayList.add(str == null ? new LazyTypeDescription.MethodToken.ParameterToken() : new LazyTypeDescription.MethodToken.ParameterToken(str));
                    size += type.getSize();
                }
                return arrayList;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum ReaderMode {
            EXTENDED(4),
            FAST(1);

            private final int flags;

            ReaderMode(int i) {
                this.flags = i;
            }

            public int getFlags() {
                return this.flags;
            }

            public boolean isExtended() {
                return this == EXTENDED;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public class TypeExtractor extends ClassVisitor {
            private static final int REAL_MODIFIER_MASK = 65535;
            private static final int SUPER_CLASS_INDEX = -1;
            private int actualModifiers;
            private final List<LazyTypeDescription.AnnotationToken> annotationTokens;
            private boolean anonymousType;

            @MaybeNull
            private ClassFileVersion classFileVersion;
            private final List<String> declaredTypes;

            @MaybeNull
            private String declaringTypeName;
            private final List<LazyTypeDescription.FieldToken> fieldTokens;

            @MaybeNull
            private String genericSignature;

            @MaybeNull
            private String[] interfaceName;

            @MaybeNull
            private String internalName;
            private final List<LazyTypeDescription.MethodToken> methodTokens;
            private int modifiers;

            @MaybeNull
            private LazyTypeDescription.ModuleToken moduleToken;

            @MaybeNull
            private String nestHost;
            private final List<String> nestMembers;
            private final List<String> permittedSubclasses;
            private final List<LazyTypeDescription.RecordComponentToken> recordComponentTokens;

            @MaybeNull
            private String superClassName;
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> superTypeAnnotationTokens;
            private LazyTypeDescription.TypeContainment typeContainment;
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
            private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundsAnnotationTokens;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class AnnotationExtractor extends AnnotationVisitor {
                private final AnnotationRegistrant annotationRegistrant;
                private final ComponentTypeLocator componentTypeLocator;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class AnnotationLookup implements AnnotationRegistrant {
                    private final String descriptor;
                    private final String name;
                    private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                    public AnnotationLookup(String str, String str2) {
                        this.descriptor = str;
                        this.name = str2;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForAnnotationValue(Default.this, new LazyTypeDescription.AnnotationToken(this.descriptor, this.values)));
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void register(String str, AnnotationValue<?, ?> annotationValue) {
                        this.values.put(str, annotationValue);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class ArrayLookup implements AnnotationRegistrant {
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private final String name;
                    private final List<AnnotationValue<?, ?>> values;

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForArray(Default.this, this.componentTypeReference, this.values));
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void register(String str, AnnotationValue<?, ?> annotationValue) {
                        this.values.add(annotationValue);
                    }

                    private ArrayLookup(String str, AbstractBase.ComponentTypeReference componentTypeReference) {
                        this.name = str;
                        this.componentTypeReference = componentTypeReference;
                        this.values = new ArrayList();
                    }
                }

                public AnnotationExtractor(TypeExtractor typeExtractor, String str, List<LazyTypeDescription.AnnotationToken> list, ComponentTypeLocator componentTypeLocator) {
                    this(new AnnotationRegistrant.ForByteCodeElement(str, list), componentTypeLocator);
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visit(String str, Object obj) {
                    if (!(obj instanceof Type)) {
                        this.annotationRegistrant.register(str, AnnotationValue.ForConstant.of(obj));
                    } else {
                        Type type = (Type) obj;
                        this.annotationRegistrant.register(str, new LazyTypeDescription.LazyAnnotationValue.ForTypeValue(Default.this, type.getSort() == 9 ? type.getInternalName().replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH) : type.getClassName()));
                    }
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public AnnotationVisitor visitAnnotation(String str, String str2) {
                    return TypeExtractor.this.new AnnotationExtractor(new AnnotationLookup(str2, str), new ComponentTypeLocator.ForAnnotationProperty(Default.this, str2));
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public AnnotationVisitor visitArray(String str) {
                    return TypeExtractor.this.new AnnotationExtractor(new ArrayLookup(str, this.componentTypeLocator.bind(str)), ComponentTypeLocator.Illegal.INSTANCE);
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visitEnd() {
                    this.annotationRegistrant.onComplete();
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visitEnum(String str, String str2, String str3) {
                    this.annotationRegistrant.register(str, new LazyTypeDescription.LazyAnnotationValue.ForEnumerationValue(Default.this, str2.substring(1, str2.length() - 1).replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), str3));
                }

                public AnnotationExtractor(TypeExtractor typeExtractor, String str, int i, Map<Integer, List<LazyTypeDescription.AnnotationToken>> map, ComponentTypeLocator componentTypeLocator) {
                    this(new AnnotationRegistrant.ForByteCodeElement.WithIndex(str, i, map), componentTypeLocator);
                }

                public AnnotationExtractor(AnnotationRegistrant annotationRegistrant, ComponentTypeLocator componentTypeLocator) {
                    super(OpenedClassReader.ASM_API);
                    this.annotationRegistrant = annotationRegistrant;
                    this.componentTypeLocator = componentTypeLocator;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class FieldExtractor extends FieldVisitor {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;
                private final String descriptor;

                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private final int modifiers;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;

                public FieldExtractor(int i, String str, String str2, @MaybeNull String str3) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = i;
                    this.internalName = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.typeAnnotationTokens = new HashMap();
                    this.annotationTokens = new ArrayList();
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public AnnotationVisitor visitAnnotation(String str, boolean z) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public void visitEnd() {
                    TypeExtractor.this.fieldTokens.add(new LazyTypeDescription.FieldToken(this.internalName, this.modifiers, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z) {
                    TypeReference typeReference = new TypeReference(i);
                    if (typeReference.getSort() == 19) {
                        AnnotationRegistrant.ForTypeVariable forTypeVariable = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.typeAnnotationTokens);
                        TypeExtractor typeExtractor = TypeExtractor.this;
                        return typeExtractor.new AnnotationExtractor(forTypeVariable, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                    }
                    throw new IllegalStateException("Unexpected type reference on field: " + typeReference.getSort());
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class MethodExtractor extends MethodVisitor implements AnnotationRegistrant {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;

                @MaybeNull
                private AnnotationValue<?, ?> defaultValue;
                private final String descriptor;

                @MaybeNull
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens;

                @MaybeNull
                private Label firstLabel;

                @MaybeNull
                private final String genericSignature;
                private final String internalName;
                private int invisibleParameterShift;
                private final ParameterBag legacyParameterBag;
                private final int modifiers;
                private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens;
                private final List<LazyTypeDescription.MethodToken.ParameterToken> parameterTokens;
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens;
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens;
                private int visibleParameterShift;

                public MethodExtractor(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = i;
                    this.internalName = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.exceptionName = strArr;
                    this.typeVariableAnnotationTokens = new HashMap();
                    this.typeVariableBoundAnnotationTokens = new HashMap();
                    this.returnTypeAnnotationTokens = new HashMap();
                    this.parameterTypeAnnotationTokens = new HashMap();
                    this.exceptionTypeAnnotationTokens = new HashMap();
                    this.receiverTypeAnnotationTokens = new HashMap();
                    this.annotationTokens = new ArrayList();
                    this.parameterAnnotationTokens = new HashMap();
                    this.parameterTokens = new ArrayList();
                    this.legacyParameterBag = new ParameterBag(Type.getMethodType(str2).getArgumentTypes());
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void onComplete() {
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void register(String str, AnnotationValue<?, ?> annotationValue) {
                    this.defaultValue = annotationValue;
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAnnotableParameterCount(int i, boolean z) {
                    if (z) {
                        this.visibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - i;
                    } else {
                        this.invisibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - i;
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotation(String str, boolean z) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotationDefault() {
                    return TypeExtractor.this.new AnnotationExtractor(this, new ComponentTypeLocator.ForArrayType(this.descriptor));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitEnd() {
                    String str;
                    List<LazyTypeDescription.MethodToken.ParameterToken> listResolve;
                    List list = TypeExtractor.this.methodTokens;
                    String str2 = this.internalName;
                    int i = this.modifiers;
                    String str3 = this.descriptor;
                    String str4 = this.genericSignature;
                    String[] strArr = this.exceptionName;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map = this.typeVariableAnnotationTokens;
                    Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> map2 = this.typeVariableBoundAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map3 = this.returnTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map4 = this.parameterTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map5 = this.exceptionTypeAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map6 = this.receiverTypeAnnotationTokens;
                    List<LazyTypeDescription.AnnotationToken> list2 = this.annotationTokens;
                    Map<Integer, List<LazyTypeDescription.AnnotationToken>> map7 = this.parameterAnnotationTokens;
                    if (this.parameterTokens.isEmpty()) {
                        str = str2;
                        listResolve = this.legacyParameterBag.resolve((this.modifiers & 8) != 0);
                    } else {
                        str = str2;
                        listResolve = this.parameterTokens;
                    }
                    list.add(new LazyTypeDescription.MethodToken(str, i, str3, str4, strArr, map, map2, map3, map4, map5, map6, list2, map7, listResolve, this.defaultValue));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitLabel(Label label) {
                    if (Default.this.readerMode.isExtended() && this.firstLabel == null) {
                        this.firstLabel = label;
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i) {
                    if (Default.this.readerMode.isExtended() && label == this.firstLabel) {
                        this.legacyParameterBag.register(i, str);
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitParameter(String str, int i) {
                    this.parameterTokens.add(new LazyTypeDescription.MethodToken.ParameterToken(str, Integer.valueOf(i)));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitParameterAnnotation(int i, String str, boolean z) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, i + (z ? this.visibleParameterShift : this.invisibleParameterShift), this.parameterAnnotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                @MaybeNull
                public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
                    String str2;
                    AnnotationRegistrant withIndex;
                    TypeReference typeReference = new TypeReference(i);
                    int sort = typeReference.getSort();
                    if (sort == 1) {
                        str2 = str;
                        withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex(str2, typePath, typeReference.getTypeParameterIndex(), this.typeVariableAnnotationTokens);
                    } else {
                        if (sort == 16) {
                            return null;
                        }
                        switch (sort) {
                            case 18:
                                str2 = str;
                                withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(str2, typePath, typeReference.getTypeParameterBoundIndex(), typeReference.getTypeParameterIndex(), this.typeVariableBoundAnnotationTokens);
                                break;
                            case 19:
                                return null;
                            case 20:
                                withIndex = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.returnTypeAnnotationTokens);
                                str2 = str;
                                break;
                            case 21:
                                withIndex = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.receiverTypeAnnotationTokens);
                                str2 = str;
                                break;
                            case 22:
                                withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex(str, typePath, typeReference.getFormalParameterIndex(), this.parameterTypeAnnotationTokens);
                                str2 = str;
                                break;
                            case 23:
                                withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex(str, typePath, typeReference.getExceptionIndex(), this.exceptionTypeAnnotationTokens);
                                str2 = str;
                                break;
                            default:
                                throw new IllegalStateException("Unexpected type reference on method: " + typeReference.getSort());
                        }
                    }
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return typeExtractor.new AnnotationExtractor(withIndex, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str2));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class ModuleExtractor extends ModuleVisitor {
                private final Map<String, ModuleDescription.Exports> exports;

                @MaybeNull
                private String mainClass;
                private final int modifiers;
                private final String name;
                private final Map<String, ModuleDescription.Opens> opens;
                private final Set<String> packages;
                private final Map<String, ModuleDescription.Provides> provides;
                private final Map<String, ModuleDescription.Requires> requires;
                private final Set<String> uses;

                @MaybeNull
                private final String version;

                public ModuleExtractor(String str, int i, @MaybeNull String str2) {
                    super(OpenedClassReader.ASM_API);
                    this.packages = new LinkedHashSet();
                    this.requires = new LinkedHashMap();
                    this.exports = new LinkedHashMap();
                    this.opens = new LinkedHashMap();
                    this.uses = new LinkedHashSet();
                    this.provides = new LinkedHashMap();
                    this.name = str;
                    this.modifiers = i;
                    this.version = str2;
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitEnd() {
                    TypeExtractor.this.moduleToken = new LazyTypeDescription.ModuleToken(this.name, this.modifiers, this.version, this.mainClass, this.packages, this.requires, this.exports, this.opens, this.uses, this.provides);
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitExport(String str, int i, @MaybeNull String... strArr) {
                    this.exports.put(str, new ModuleDescription.Exports.Simple(strArr == null ? Collections.EMPTY_SET : new LinkedHashSet(Arrays.asList(strArr)), i));
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitMainClass(String str) {
                    this.mainClass = str;
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitOpen(String str, int i, @MaybeNull String... strArr) {
                    this.opens.put(str, new ModuleDescription.Opens.Simple(strArr == null ? Collections.EMPTY_SET : new LinkedHashSet(Arrays.asList(strArr)), i));
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitPackage(String str) {
                    this.packages.add(str);
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitProvide(String str, String... strArr) {
                    this.provides.put(str, new ModuleDescription.Provides.Simple(new LinkedHashSet(Arrays.asList(strArr))));
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitRequire(String str, int i, @MaybeNull String str2) {
                    this.requires.put(str, new ModuleDescription.Requires.Simple(str2, i));
                }

                @Override // net.bytebuddy.jar.asm.ModuleVisitor
                public void visitUse(String str) {
                    this.uses.add(str);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class RecordComponentExtractor extends RecordComponentVisitor {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;
                private final String descriptor;

                @MaybeNull
                private final String genericSignature;
                private final String name;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens;

                public RecordComponentExtractor(String str, String str2, @MaybeNull String str3) {
                    super(OpenedClassReader.ASM_API);
                    this.name = str;
                    this.descriptor = str2;
                    this.genericSignature = str3;
                    this.typeAnnotationTokens = new HashMap();
                    this.annotationTokens = new ArrayList();
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public AnnotationVisitor visitAnnotation(String str, boolean z) {
                    TypeExtractor typeExtractor = TypeExtractor.this;
                    return new AnnotationExtractor(typeExtractor, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public void visitEnd() {
                    TypeExtractor.this.recordComponentTokens.add(new LazyTypeDescription.RecordComponentToken(this.name, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public AnnotationVisitor visitTypeAnnotation(int i, TypePath typePath, String str, boolean z) {
                    TypeReference typeReference = new TypeReference(i);
                    if (typeReference.getSort() == 19) {
                        AnnotationRegistrant.ForTypeVariable forTypeVariable = new AnnotationRegistrant.ForTypeVariable(str, typePath, this.typeAnnotationTokens);
                        TypeExtractor typeExtractor = TypeExtractor.this;
                        return typeExtractor.new AnnotationExtractor(forTypeVariable, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
                    }
                    throw new IllegalStateException("Unexpected type reference on record component: " + typeReference.getSort());
                }
            }

            public TypeExtractor() {
                super(OpenedClassReader.ASM_API);
                this.superTypeAnnotationTokens = new HashMap();
                this.typeVariableAnnotationTokens = new HashMap();
                this.typeVariableBoundsAnnotationTokens = new HashMap();
                this.annotationTokens = new ArrayList();
                this.fieldTokens = new ArrayList();
                this.methodTokens = new ArrayList();
                this.recordComponentTokens = new ArrayList();
                this.anonymousType = false;
                this.typeContainment = LazyTypeDescription.TypeContainment.SelfContained.INSTANCE;
                this.nestMembers = new ArrayList();
                this.declaredTypes = new ArrayList();
                this.permittedSubclasses = new ArrayList();
            }

            public TypeDescription toTypeDescription() {
                if (this.internalName == null || this.classFileVersion == null) {
                    throw new IllegalStateException("Internal name or class file version were not set");
                }
                Map<String, List<LazyTypeDescription.AnnotationToken>> mapRemove = this.superTypeAnnotationTokens.remove(-1);
                Default r3 = Default.this;
                int i = this.actualModifiers;
                int i2 = this.modifiers;
                String str = this.internalName;
                String str2 = this.superClassName;
                String[] strArr = this.interfaceName;
                String str3 = this.genericSignature;
                LazyTypeDescription.TypeContainment typeContainment = this.typeContainment;
                String str4 = this.declaringTypeName;
                List<String> list = this.declaredTypes;
                boolean z = this.anonymousType;
                String str5 = this.nestHost;
                List<String> list2 = this.nestMembers;
                if (mapRemove == null) {
                    mapRemove = Collections.EMPTY_MAP;
                }
                return new LazyTypeDescription(r3, i, i2, str, str2, strArr, str3, typeContainment, str4, list, z, str5, list2, mapRemove, this.superTypeAnnotationTokens, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens, this.annotationTokens, this.moduleToken, this.fieldTokens, this.methodTokens, this.recordComponentTokens, this.permittedSubclasses, this.classFileVersion);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visit(int i, int i2, String str, @MaybeNull String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                this.modifiers = 65535 & i2;
                this.actualModifiers = i2;
                this.internalName = str;
                this.genericSignature = str2;
                this.superClassName = str3;
                this.interfaceName = strArr;
                this.classFileVersion = ClassFileVersion.ofMinorMajor(i);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitAnnotation(String str, boolean z) {
                return new AnnotationExtractor(this, str, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str));
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
                return new FieldExtractor(i & 65535, str, str2, str3);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitInnerClass(String str, @MaybeNull String str2, @MaybeNull String str3, int i) {
                if (str.equals(this.internalName)) {
                    if (str2 != null) {
                        this.declaringTypeName = str2;
                        if (this.typeContainment.isSelfContained()) {
                            this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(str2, false);
                        }
                    }
                    if (str3 == null && !this.typeContainment.isSelfContained()) {
                        this.anonymousType = true;
                    }
                    this.modifiers = 65535 & i;
                    return;
                }
                if (str2 == null || str3 == null || !str2.equals(this.internalName)) {
                    return;
                }
                this.declaredTypes.add("L" + str + ";");
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @MaybeNull
            public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
                return str.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) ? Default.IGNORE_METHOD : new MethodExtractor(i & 65535, str, str2, str3, strArr);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public ModuleVisitor visitModule(String str, int i, @MaybeNull String str2) {
                return new ModuleExtractor(str, i, str2);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestHost(String str) {
                this.nestHost = str;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestMember(String str) {
                this.nestMembers.add(str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitOuterClass(@MaybeNull String str, @MaybeNull String str2, String str3) {
                if (str2 != null && !str2.equals(MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME)) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinMethod(str, str2, str3);
                } else if (str != null) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(str, true);
                }
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitPermittedSubclass(String str) {
                this.permittedSubclasses.add(str);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public RecordComponentVisitor visitRecordComponent(String str, String str2, @MaybeNull String str3) {
                return new RecordComponentExtractor(str, str2, str3);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitTypeAnnotation(int i, @MaybeNull TypePath typePath, String str, boolean z) {
                String str2;
                AnnotationRegistrant withIndex;
                TypeReference typeReference = new TypeReference(i);
                int sort = typeReference.getSort();
                if (sort == 0) {
                    str2 = str;
                    withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex(str2, typePath, typeReference.getTypeParameterIndex(), this.typeVariableAnnotationTokens);
                } else if (sort == 16) {
                    str2 = str;
                    withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex(str2, typePath, typeReference.getSuperTypeIndex(), this.superTypeAnnotationTokens);
                } else {
                    if (sort != 17) {
                        throw new IllegalArgumentException("Unexpected type reference: " + typeReference.getSort());
                    }
                    str2 = str;
                    withIndex = new AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(str2, typePath, typeReference.getTypeParameterBoundIndex(), typeReference.getTypeParameterIndex(), this.typeVariableBoundsAnnotationTokens);
                }
                return new AnnotationExtractor(withIndex, new ComponentTypeLocator.ForAnnotationProperty(Default.this, str2));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class WithLazyResolution extends Default {
            private final LazinessMode lazinessMode;

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class ExtendedLazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
                private Delegate delegate;

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public abstract class Delegate {
                    private Delegate() {
                    }

                    public abstract TypeList.Generic getInterfaces();

                    public abstract int getModifiers();

                    public abstract String getName();

                    @MaybeNull
                    public abstract TypeDescription.Generic getSuperClass();

                    public abstract ResolvedDelegate resolve();
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyInterface extends TypeDescription.Generic.LazyProjection.WithLazyNavigation {
                    private final int index;
                    private final String internalName;

                    public LazyInterface(String str, int i) {
                        this.internalName = str;
                        this.index = i;
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return WithLazyResolution.this.new LazyTypeDescription(this.internalName.replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    public TypeDescription.Generic resolve() {
                        return ExtendedLazyTypeDescription.this.delegate().getInterfaces().get(this.index);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazyInterfaceList extends TypeList.Generic.AbstractBase {
                    private final List<String> internalNames;

                    public LazyInterfaceList(List<String> list) {
                        this.internalNames = list;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return this.internalNames.size();
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int i) {
                        return ExtendedLazyTypeDescription.this.new LazyInterface(this.internalNames.get(i), i);
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class LazySuperClass extends TypeDescription.Generic.LazyProjection.WithLazyNavigation {
                    private final String internalName;

                    public LazySuperClass(String str) {
                        this.internalName = str;
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return WithLazyResolution.this.new LazyTypeDescription(this.internalName.replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    public TypeDescription.Generic resolve() {
                        return ExtendedLazyTypeDescription.this.delegate().getSuperClass();
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class ResolvedDelegate extends Delegate {
                    private final TypeDescription typeDescription;

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public TypeList.Generic getInterfaces() {
                        return this.typeDescription.getInterfaces();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public int getModifiers() {
                        return this.typeDescription.getModifiers();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public String getName() {
                        return this.typeDescription.getName();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    @MaybeNull
                    public TypeDescription.Generic getSuperClass() {
                        return this.typeDescription.getSuperClass();
                    }

                    public TypeDescription getTypeDescription() {
                        return this.typeDescription;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public ResolvedDelegate resolve() {
                        return this;
                    }

                    private ResolvedDelegate(TypeDescription typeDescription) {
                        super();
                        this.typeDescription = typeDescription;
                    }
                }

                /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
                public class UnresolvedDelegate extends Delegate {
                    private final AsmClassReader classReader;

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public TypeList.Generic getInterfaces() {
                        return ExtendedLazyTypeDescription.this.new LazyInterfaceList(this.classReader.getInterfaceInternalNames());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public int getModifiers() {
                        return this.classReader.getModifiers();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public String getName() {
                        return this.classReader.getInternalName().replace('/', LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    @MaybeNull
                    public TypeDescription.Generic getSuperClass() {
                        String superClassInternalName = this.classReader.getSuperClassInternalName();
                        return (superClassInternalName == null || ExtendedLazyTypeDescription.this.isInterface()) ? TypeDescription.Generic.UNDEFINED : ExtendedLazyTypeDescription.this.new LazySuperClass(superClassInternalName);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.WithLazyResolution.ExtendedLazyTypeDescription.Delegate
                    public ResolvedDelegate resolve() {
                        ExtendedLazyTypeDescription extendedLazyTypeDescription = ExtendedLazyTypeDescription.this;
                        return new ResolvedDelegate(WithLazyResolution.super.doParse(this.classReader));
                    }

                    private UnresolvedDelegate(AsmClassReader asmClassReader) {
                        super();
                        this.classReader = asmClassReader;
                    }
                }

                public ExtendedLazyTypeDescription(AsmClassReader asmClassReader) {
                    this.delegate = new UnresolvedDelegate(asmClassReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation
                public TypeDescription delegate() {
                    ResolvedDelegate resolvedDelegateResolve = this.delegate.resolve();
                    this.delegate = resolvedDelegateResolve;
                    return resolvedDelegateResolve.getTypeDescription();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return this.delegate.getInterfaces();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.delegate.getName();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.type.TypeDefinition
                @MaybeNull
                public TypeDescription.Generic getSuperClass() {
                    return this.delegate.getSuperClass();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.OfAbstraction
                public boolean isAbstract() {
                    return (this.delegate.getModifiers() & 1024) == 1024;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
                public boolean isAnnotation() {
                    return (this.delegate.getModifiers() & 8192) == 8192;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.OfEnumeration
                public boolean isEnum() {
                    return (this.delegate.getModifiers() & 16384) == 16384;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation, net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
                public boolean isInterface() {
                    return (this.delegate.getModifiers() & 512) == 512;
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public enum LazinessMode {
                NAME,
                EXTENDED
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            public class LazyResolution implements Resolution {
                private final String name;

                public LazyResolution(String str) {
                    this.name = str;
                }

                public boolean equals(@MaybeNull Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass()) {
                        return false;
                    }
                    LazyResolution lazyResolution = (LazyResolution) obj;
                    return this.name.equals(lazyResolution.name) && WithLazyResolution.this.equals(WithLazyResolution.this);
                }

                public int hashCode() {
                    return WithLazyResolution.this.hashCode() + bjs.e(this.name, getClass().hashCode() * 31, 31);
                }

                @Override // net.bytebuddy.pool.TypePool.Resolution
                public boolean isResolved() {
                    return WithLazyResolution.this.doResolve(this.name).isResolved();
                }

                @Override // net.bytebuddy.pool.TypePool.Resolution
                public TypeDescription resolve() {
                    return WithLazyResolution.this.new LazyTypeDescription(this.name);
                }
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            public class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
                private transient /* synthetic */ TypeDescription delegate;
                private final String name;

                public LazyTypeDescription(String str) {
                    this.name = str;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation
                @CachedReturnPlugin.Enhance(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
                public TypeDescription delegate() {
                    TypeDescription typeDescriptionResolve = this.delegate != null ? null : WithLazyResolution.this.doResolve(this.name).resolve();
                    if (typeDescriptionResolve == null) {
                        return this.delegate;
                    }
                    this.delegate = typeDescriptionResolve;
                    return typeDescriptionResolve;
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode) {
                this(cacheProvider, classFileLocator, readerMode, LazinessMode.NAME);
            }

            public static TypePool of(@MaybeNull ClassLoader classLoader) {
                return of(ClassFileLocator.ForClassLoader.of(classLoader));
            }

            public static TypePool ofBootLoader() {
                return of(ClassFileLocator.ForClassLoader.ofBootLoader());
            }

            public static TypePool ofPlatformLoader() {
                return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
            }

            public static TypePool ofSystemLoader() {
                return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            public Resolution doCache(String str, Resolution resolution) {
                return resolution;
            }

            @Override // net.bytebuddy.pool.TypePool.Default, net.bytebuddy.pool.TypePool.AbstractBase
            public Resolution doDescribe(String str) {
                return new LazyResolution(str);
            }

            @Override // net.bytebuddy.pool.TypePool.Default
            public TypeDescription doParse(AsmClassReader asmClassReader) {
                return this.lazinessMode == LazinessMode.EXTENDED ? new ExtendedLazyTypeDescription(asmClassReader) : super.doParse(asmClassReader);
            }

            public Resolution doResolve(String str) {
                Resolution resolutionFind = this.cacheProvider.find(str);
                return resolutionFind == null ? this.cacheProvider.register(str, super.doDescribe(str)) : resolutionFind;
            }

            @Override // net.bytebuddy.pool.TypePool.Default, net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
            public boolean equals(@MaybeNull Object obj) {
                if (!super.equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.lazinessMode.equals(((WithLazyResolution) obj).lazinessMode);
            }

            @Override // net.bytebuddy.pool.TypePool.Default, net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
            public int hashCode() {
                return this.lazinessMode.hashCode() + (super.hashCode() * 31);
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool typePool) {
                this(cacheProvider, classFileLocator, readerMode, typePool, LazinessMode.NAME);
            }

            public static TypePool of(ClassFileLocator classFileLocator) {
                return new WithLazyResolution(new CacheProvider.Simple(), classFileLocator, ReaderMode.FAST);
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory) {
                this(cacheProvider, classFileLocator, readerMode, factory, LazinessMode.NAME);
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory, TypePool typePool) {
                this(cacheProvider, classFileLocator, readerMode, factory, typePool, LazinessMode.NAME);
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, LazinessMode lazinessMode) {
                super(cacheProvider, classFileLocator, readerMode);
                this.lazinessMode = lazinessMode;
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool typePool, LazinessMode lazinessMode) {
                super(cacheProvider, classFileLocator, readerMode, typePool);
                this.lazinessMode = lazinessMode;
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory, LazinessMode lazinessMode) {
                super(cacheProvider, classFileLocator, readerMode, factory);
                this.lazinessMode = lazinessMode;
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory, TypePool typePool, LazinessMode lazinessMode) {
                super(cacheProvider, classFileLocator, readerMode, factory, typePool);
                this.lazinessMode = lazinessMode;
            }
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode) {
            this(cacheProvider, classFileLocator, readerMode, Empty.INSTANCE);
        }

        public static TypePool of(@MaybeNull ClassLoader classLoader) {
            return of(ClassFileLocator.ForClassLoader.of(classLoader));
        }

        public static TypePool ofBootLoader() {
            return of(ClassFileLocator.ForClassLoader.ofBootLoader());
        }

        public static TypePool ofPlatformLoader() {
            return of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
        }

        public static TypePool ofSystemLoader() {
            return of(ClassFileLocator.ForClassLoader.ofSystemLoader());
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public Resolution doDescribe(String str) {
            try {
                ClassFileLocator.Resolution resolutionLocate = this.classFileLocator.locate(str);
                return resolutionLocate.isResolved() ? new Resolution.Simple(doParse(this.classReaderFactory.make(resolutionLocate.resolve()))) : new Resolution.Illegal(str);
            } catch (IOException e) {
                throw new IllegalStateException("Error while reading class file", e);
            }
        }

        public TypeDescription doParse(AsmClassReader asmClassReader) {
            TypeExtractor typeExtractor = new TypeExtractor();
            asmClassReader.accept(typeExtractor, this.readerMode.getFlags());
            return typeExtractor.toTypeDescription();
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Default r5 = (Default) obj;
            return this.readerMode.equals(r5.readerMode) && this.classFileLocator.equals(r5.classFileLocator) && this.classReaderFactory.equals(r5.classReaderFactory);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return this.classReaderFactory.hashCode() + ((this.readerMode.hashCode() + ((this.classFileLocator.hashCode() + (super.hashCode() * 31)) * 31)) * 31);
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool typePool) {
            this(cacheProvider, classFileLocator, readerMode, AsmClassReader.Factory.Default.IMPLICIT, typePool);
        }

        public static TypePool of(ClassFileLocator classFileLocator) {
            return new Default(new CacheProvider.Simple(), classFileLocator, ReaderMode.FAST);
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory) {
            this(cacheProvider, classFileLocator, readerMode, factory, Empty.INSTANCE);
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, AsmClassReader.Factory factory, TypePool typePool) {
            super(cacheProvider, typePool);
            this.classFileLocator = classFileLocator;
            this.readerMode = readerMode;
            this.classReaderFactory = factory;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Empty implements TypePool {
        INSTANCE;

        @Override // net.bytebuddy.pool.TypePool
        public void clear() {
        }

        @Override // net.bytebuddy.pool.TypePool
        public Resolution describe(String str) {
            return new Resolution.Illegal(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Explicit extends AbstractBase.Hierarchical {
        private final Map<String, TypeDescription> types;

        public Explicit(Map<String, TypeDescription> map) {
            this(Empty.INSTANCE, map);
        }

        public static TypePool wrap(TypeDescription typeDescription, List<? extends DynamicType> list, TypePool typePool) {
            HashMap map = new HashMap();
            map.put(typeDescription.getName(), typeDescription);
            Iterator<? extends DynamicType> it = list.iterator();
            while (it.hasNext()) {
                for (TypeDescription typeDescription2 : it.next().getAllTypes().keySet()) {
                    map.put(typeDescription2.getName(), typeDescription2);
                }
            }
            return new Explicit(typePool, map);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public Resolution doDescribe(String str) {
            TypeDescription typeDescription = this.types.get(str);
            return typeDescription == null ? new Resolution.Illegal(str) : new Resolution.Simple(typeDescription);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return this.types.hashCode() + (super.hashCode() * 31);
        }

        public Explicit(TypePool typePool, Map<String, TypeDescription> map) {
            super(CacheProvider.NoOp.INSTANCE, typePool);
            this.types = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class LazyFacade extends AbstractBase {
        private final TypePool typePool;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class LazyResolution implements Resolution {
            private final String name;
            private final TypePool typePool;

            public LazyResolution(TypePool typePool, String str) {
                this.typePool = typePool;
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                LazyResolution lazyResolution = (LazyResolution) obj;
                return this.name.equals(lazyResolution.name) && this.typePool.equals(lazyResolution.typePool);
            }

            public int hashCode() {
                return this.name.hashCode() + ((this.typePool.hashCode() + (getClass().hashCode() * 31)) * 31);
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return this.typePool.describe(this.name).isResolved();
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return new LazyTypeDescription(this.typePool, this.name);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
            private transient /* synthetic */ TypeDescription delegate;
            private final String name;
            private final TypePool typePool;

            public LazyTypeDescription(TypePool typePool, String str) {
                this.typePool = typePool;
                this.name = str;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation
            @CachedReturnPlugin.Enhance(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
            public TypeDescription delegate() {
                TypeDescription typeDescriptionResolve = this.delegate != null ? null : this.typePool.describe(this.name).resolve();
                if (typeDescriptionResolve == null) {
                    return this.delegate;
                }
                this.delegate = typeDescriptionResolve;
                return typeDescriptionResolve;
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getName() {
                return this.name;
            }
        }

        public LazyFacade(TypePool typePool) {
            super(CacheProvider.NoOp.INSTANCE);
            this.typePool = typePool;
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
        public void clear() {
            this.typePool.clear();
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public Resolution doDescribe(String str) {
            return new LazyResolution(this.typePool, str);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(@MaybeNull Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typePool.equals(((LazyFacade) obj).typePool);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return this.typePool.hashCode() + (super.hashCode() * 31);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Resolution {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Illegal implements Resolution {
            private final String name;

            public Illegal(String str) {
                this.name = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((Illegal) obj).name);
            }

            public int hashCode() {
                return this.name.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return false;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                throw new NoSuchTypeException(this.name);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class NoSuchTypeException extends IllegalStateException {
            private static final long serialVersionUID = 1;
            private final String name;

            public NoSuchTypeException(String str) {
                super(yg.k("Cannot resolve type description for ", str));
                this.name = str;
            }

            public String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Simple implements Resolution {
            private final TypeDescription typeDescription;

            public Simple(TypeDescription typeDescription) {
                this.typeDescription = typeDescription;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Simple) obj).typeDescription);
            }

            public int hashCode() {
                return this.typeDescription.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return true;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return this.typeDescription;
            }
        }

        boolean isResolved();

        TypeDescription resolve();
    }

    void clear();

    Resolution describe(String str);
}
