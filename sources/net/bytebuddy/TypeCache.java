package net.bytebuddy;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class TypeCache<T> extends ReferenceQueue<ClassLoader> {

    @AlwaysNull
    private static final Class<?> NOT_FOUND = null;
    protected final ConcurrentMap<StorageKey, ConcurrentMap<T, Object>> cache;
    protected final Sort sort;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class LookupKey {

        @MaybeNull
        private final ClassLoader classLoader;
        private final int hashCode;

        public LookupKey(@MaybeNull ClassLoader classLoader) {
            this.classLoader = classLoader;
            this.hashCode = System.identityHashCode(classLoader);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                return this.classLoader == ((LookupKey) obj).classLoader;
            }
            if (obj instanceof StorageKey) {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && this.classLoader == storageKey.get()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class SimpleKey {
        private transient /* synthetic */ int hashCode;
        private final Set<String> types;

        public SimpleKey(Class<?> cls, Class<?>... clsArr) {
            this(cls, Arrays.asList(clsArr));
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.types.equals(((SimpleKey) obj).types);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int iHashCode = this.hashCode != 0 ? 0 : this.types.hashCode();
            if (iHashCode == 0) {
                return this.hashCode;
            }
            this.hashCode = iHashCode;
            return iHashCode;
        }

        public SimpleKey(Class<?> cls, Collection<? extends Class<?>> collection) {
            this(CompoundList.of(cls, new ArrayList(collection)));
        }

        public SimpleKey(Collection<? extends Class<?>> collection) {
            this.types = new HashSet();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                this.types.add(it.next().getName());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Sort {
        WEAK { // from class: net.bytebuddy.TypeCache.Sort.1
            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new WeakReference(cls);
            }
        },
        SOFT { // from class: net.bytebuddy.TypeCache.Sort.2
            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public Reference<Class<?>> wrap(Class<?> cls) {
                return new SoftReference(cls);
            }
        },
        STRONG { // from class: net.bytebuddy.TypeCache.Sort.3
            @Override // net.bytebuddy.TypeCache.Sort
            public Class<?> wrap(Class<?> cls) {
                return cls;
            }

            @Override // net.bytebuddy.TypeCache.Sort
            public /* bridge */ /* synthetic */ Object wrap(Class cls) {
                return wrap((Class<?>) cls);
            }
        };

        public abstract Object wrap(Class<?> cls);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class StorageKey extends WeakReference<ClassLoader> {
        private final int hashCode;

        public StorageKey(@MaybeNull ClassLoader classLoader, ReferenceQueue<? super ClassLoader> referenceQueue) {
            super(classLoader, referenceQueue);
            this.hashCode = System.identityHashCode(classLoader);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LookupKey) {
                LookupKey lookupKey = (LookupKey) obj;
                return this.hashCode == lookupKey.hashCode && get() == lookupKey.classLoader;
            }
            if (obj instanceof StorageKey) {
                StorageKey storageKey = (StorageKey) obj;
                if (this.hashCode == storageKey.hashCode && get() == storageKey.get()) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class WithInlineExpunction<S> extends TypeCache<S> {
        public WithInlineExpunction() {
            this(Sort.STRONG);
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> find(@MaybeNull ClassLoader classLoader, S s) {
            try {
                return super.find(classLoader, s);
            } finally {
                expungeStaleEntries();
            }
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, S s, Callable<Class<?>> callable) {
            try {
                return super.findOrInsert(classLoader, s, callable);
            } finally {
                expungeStaleEntries();
            }
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> insert(@MaybeNull ClassLoader classLoader, S s, Class<?> cls) {
            try {
                return super.insert(classLoader, s, cls);
            } finally {
                expungeStaleEntries();
            }
        }

        public WithInlineExpunction(Sort sort) {
            super(sort);
        }

        @Override // net.bytebuddy.TypeCache
        public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, S s, Callable<Class<?>> callable, Object obj) {
            try {
                return super.findOrInsert(classLoader, s, callable, obj);
            } finally {
                expungeStaleEntries();
            }
        }
    }

    public TypeCache() {
        this(Sort.STRONG);
    }

    public void clear() {
        this.cache.clear();
    }

    public void expungeStaleEntries() {
        while (true) {
            Reference<? extends T> referencePoll = poll();
            if (referencePoll == null) {
                return;
            } else {
                this.cache.remove(referencePoll);
            }
        }
    }

    @MaybeNull
    public Class<?> find(@MaybeNull ClassLoader classLoader, T t) {
        ConcurrentMap<T, Object> concurrentMap = this.cache.get(new LookupKey(classLoader));
        if (concurrentMap == null) {
            return NOT_FOUND;
        }
        Object obj = concurrentMap.get(t);
        return obj == null ? NOT_FOUND : obj instanceof Reference ? (Class) ((Reference) obj).get() : (Class) obj;
    }

    public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, T t, Callable<Class<?>> callable) {
        Class<?> clsFind = find(classLoader, t);
        if (clsFind != null) {
            return clsFind;
        }
        try {
            return insert(classLoader, t, callable.call());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Could not create type", th);
        }
    }

    public Class<?> insert(@MaybeNull ClassLoader classLoader, T t, Class<?> cls) {
        ConcurrentMap<T, Object> concurrentMapPutIfAbsent;
        ConcurrentMap<T, Object> concurrentHashMap = this.cache.get(new LookupKey(classLoader));
        if (concurrentHashMap == null && (concurrentMapPutIfAbsent = this.cache.putIfAbsent(new StorageKey(classLoader, this), (concurrentHashMap = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap = concurrentMapPutIfAbsent;
        }
        Object objWrap = this.sort.wrap(cls);
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(t, objWrap);
        while (objPutIfAbsent != null) {
            Class<?> cls2 = (Class) (objPutIfAbsent instanceof Reference ? ((Reference) objPutIfAbsent).get() : objPutIfAbsent);
            if (cls2 != null) {
                return cls2;
            }
            if (concurrentHashMap.remove(t, objPutIfAbsent)) {
                objPutIfAbsent = concurrentHashMap.putIfAbsent(t, objWrap);
            } else {
                objPutIfAbsent = concurrentHashMap.get(t);
                if (objPutIfAbsent == null) {
                    objPutIfAbsent = concurrentHashMap.putIfAbsent(t, objWrap);
                }
            }
        }
        return cls;
    }

    public TypeCache(Sort sort) {
        this.sort = sort;
        this.cache = new ConcurrentHashMap();
    }

    public Class<?> findOrInsert(@MaybeNull ClassLoader classLoader, T t, Callable<Class<?>> callable, Object obj) {
        Class<?> clsFindOrInsert;
        Class<?> clsFind = find(classLoader, t);
        if (clsFind != null) {
            return clsFind;
        }
        synchronized (obj) {
            clsFindOrInsert = findOrInsert(classLoader, t, callable);
        }
        return clsFindOrInsert;
    }
}
