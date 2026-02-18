package bsh.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ReferenceCache<K, V> {
    private static final ExecutorService taskService = Executors.newCachedThreadPool(new DaemonThreadFactory(0));
    private final ConcurrentMap<CacheReference<K>, Future<CacheReference<V>>> cache;
    private final ReferenceFactory<K, V> keyFactory;
    private final ReferenceFactory<K, V> lookupFactory;
    private final ReferenceCache<K, V>.ReferenceQueueMonitor<? super Object> queue;
    private final ReferenceFactory<K, V> valueFactory;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public abstract class CacheKey<T> implements CacheReference<T> {
        private final int hashCode;

        public CacheKey(T t) {
            this.hashCode = t.toString().chars().sum() + t.hashCode();
        }

        public boolean equals(Object obj) {
            return this.hashCode == obj.hashCode();
        }

        @Override // bsh.util.ReferenceCache.CacheReference
        public abstract T get();

        public int hashCode() {
            return this.hashCode;
        }

        public boolean removeCacheEntry() {
            return ReferenceCache.this.cache.remove(this) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface CacheReference<T> {
        T get();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class DaemonThreadFactory implements ThreadFactory {
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber;

        public /* synthetic */ DaemonThreadFactory(int i) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, "pool-referencecache-futuretask-thread-" + this.threadNumber.getAndIncrement(), 0L);
            if (!thread.isDaemon()) {
                thread.setDaemon(true);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        private DaemonThreadFactory() {
            this.group = Thread.currentThread().getThreadGroup();
            this.threadNumber = new AtomicInteger(1);
            this.namePrefix = "pool-referencecache-futuretask-thread-";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class HardReferenceFactory implements ReferenceFactory<K, V> {
        public /* synthetic */ HardReferenceFactory(ReferenceCache referenceCache, int i) {
            this();
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<K> createKey(final K k, ReferenceQueue<? super K> referenceQueue) {
            return new ReferenceCache<K, V>.CacheKey<K>(k) { // from class: bsh.util.ReferenceCache.HardReferenceFactory.1
                {
                    ReferenceCache referenceCache = ReferenceCache.this;
                }

                @Override // bsh.util.ReferenceCache.CacheKey, bsh.util.ReferenceCache.CacheReference
                public K get() {
                    return (K) k;
                }
            };
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<V> createValue(final V v, ReferenceQueue<? super V> referenceQueue) {
            return new CacheReference<V>() { // from class: bsh.util.ReferenceCache.HardReferenceFactory.2
                @Override // bsh.util.ReferenceCache.CacheReference
                public V get() {
                    return (V) v;
                }
            };
        }

        private HardReferenceFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface ReferenceFactory<K, V> {
        CacheReference<K> createKey(K k, ReferenceQueue<? super K> referenceQueue);

        CacheReference<V> createValue(V v, ReferenceQueue<? super V> referenceQueue);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class ReferenceQueueMonitor<T> extends ReferenceQueue<T> implements Runnable {
        public /* synthetic */ ReferenceQueueMonitor(ReferenceCache referenceCache, int i) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    super.remove().clear();
                } catch (InterruptedException unused) {
                }
            }
        }

        private ReferenceQueueMonitor() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class SoftReferenceFactory implements ReferenceFactory<K, V> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public class SoftReferenceValue<T> extends SoftReference<T> implements CacheReference<T> {
            public SoftReferenceValue(T t, ReferenceQueue<? super T> referenceQueue) {
                super(t, referenceQueue);
            }
        }

        public /* synthetic */ SoftReferenceFactory(ReferenceCache referenceCache, int i) {
            this();
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<K> createKey(K k, ReferenceQueue<? super K> referenceQueue) {
            return new ReferenceCache<K, V>.CacheKey<K>(k, k, referenceQueue) { // from class: bsh.util.ReferenceCache.SoftReferenceFactory.1
                final Reference<K> ref;
                final /* synthetic */ Object val$key;
                final /* synthetic */ ReferenceQueue val$queue;

                {
                    this.val$key = k;
                    this.val$queue = referenceQueue;
                    ReferenceCache referenceCache = ReferenceCache.this;
                    this.ref = new SoftReference<K>(k, referenceQueue) { // from class: bsh.util.ReferenceCache.SoftReferenceFactory.1.1
                        @Override // java.lang.ref.Reference
                        public void clear() {
                            removeCacheEntry();
                            super.clear();
                        }
                    };
                }

                @Override // bsh.util.ReferenceCache.CacheKey, bsh.util.ReferenceCache.CacheReference
                public K get() {
                    return this.ref.get();
                }
            };
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<V> createValue(V v, ReferenceQueue<? super V> referenceQueue) {
            return new SoftReferenceValue(v, referenceQueue);
        }

        private SoftReferenceFactory() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Type {
        Weak,
        Soft,
        Hard
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class WeakReferenceFactory implements ReferenceFactory<K, V> {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public class WeakReferenceValue<T> extends WeakReference<T> implements CacheReference<T> {
            public WeakReferenceValue(T t, ReferenceQueue<? super T> referenceQueue) {
                super(t, referenceQueue);
            }
        }

        public /* synthetic */ WeakReferenceFactory(ReferenceCache referenceCache, int i) {
            this();
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<K> createKey(K k, ReferenceQueue<? super K> referenceQueue) {
            return new ReferenceCache<K, V>.CacheKey<K>(k, k, referenceQueue) { // from class: bsh.util.ReferenceCache.WeakReferenceFactory.1
                final Reference<K> ref;
                final /* synthetic */ Object val$key;
                final /* synthetic */ ReferenceQueue val$queue;

                {
                    this.val$key = k;
                    this.val$queue = referenceQueue;
                    ReferenceCache referenceCache = ReferenceCache.this;
                    this.ref = new WeakReference<K>(k, referenceQueue) { // from class: bsh.util.ReferenceCache.WeakReferenceFactory.1.1
                        @Override // java.lang.ref.Reference
                        public void clear() {
                            removeCacheEntry();
                            super.clear();
                        }
                    };
                }

                @Override // bsh.util.ReferenceCache.CacheKey, bsh.util.ReferenceCache.CacheReference
                public K get() {
                    return this.ref.get();
                }
            };
        }

        @Override // bsh.util.ReferenceCache.ReferenceFactory
        public CacheReference<V> createValue(V v, ReferenceQueue<? super V> referenceQueue) {
            return new WeakReferenceValue(v, referenceQueue);
        }

        private WeakReferenceFactory() {
        }
    }

    public ReferenceCache(Type type, Type type2) {
        this(type, type2, 0);
    }

    private V dereferenceValue(CacheReference<V> cacheReference) {
        return cacheReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ CacheReference lambda$init$0(Object obj) {
        V vCreate = create(obj);
        Objects.requireNonNull(vCreate, "Reference cache create value may not return null.");
        return this.valueFactory.createValue(vCreate, this.queue);
    }

    private final ReferenceFactory<K, V> toFactory(Type type) {
        int iOrdinal = type.ordinal();
        int i = 0;
        if (iOrdinal == 0) {
            return new WeakReferenceFactory(this, i);
        }
        if (iOrdinal == 1) {
            return new SoftReferenceFactory(this, i);
        }
        if (iOrdinal != 2) {
            return null;
        }
        return new HardReferenceFactory(this, i);
    }

    public void clear() {
        this.cache.clear();
    }

    public abstract V create(K k);

    public V get(K k) {
        if (k == null) {
            return null;
        }
        CacheReference<K> cacheReferenceCreateKey = this.lookupFactory.createKey(k, this.queue);
        if (this.cache.containsKey(cacheReferenceCreateKey)) {
            V vDereferenceValue = dereferenceValue(this.cache.get(cacheReferenceCreateKey));
            if (vDereferenceValue != null) {
                return vDereferenceValue;
            }
            this.cache.remove(cacheReferenceCreateKey);
        }
        init(k);
        return dereferenceValue(this.cache.get(cacheReferenceCreateKey));
    }

    public void init(final K k) {
        if (k == null) {
            return;
        }
        CacheReference<K> cacheReferenceCreateKey = this.keyFactory.createKey(k, this.queue);
        if (this.cache.containsKey(cacheReferenceCreateKey)) {
            return;
        }
        FutureTask futureTask = new FutureTask(new Callable() { // from class: me.hd.wauxv.obf.dak
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.lambda$init$0(k);
            }
        });
        this.cache.put(cacheReferenceCreateKey, futureTask);
        taskService.execute(futureTask);
    }

    public boolean remove(K k) {
        if (k == null) {
            return false;
        }
        return ((CacheKey) CacheKey.class.cast(this.lookupFactory.createKey(k, this.queue))).removeCacheEntry();
    }

    public int size() {
        return this.cache.size();
    }

    public ReferenceCache(Type type, Type type2, int i) {
        this.keyFactory = toFactory(type);
        this.valueFactory = toFactory(type2);
        int i2 = 0;
        this.lookupFactory = new HardReferenceFactory(this, i2);
        this.cache = new ConcurrentHashMap(i);
        ReferenceCache<K, V>.ReferenceQueueMonitor<? super Object> referenceQueueMonitor = new ReferenceQueueMonitor<>(this, i2);
        this.queue = referenceQueueMonitor;
        Thread thread = new Thread(referenceQueueMonitor);
        thread.setDaemon(true);
        thread.start();
    }

    private V dereferenceValue(Future<CacheReference<V>> future) {
        if (future == null) {
            return null;
        }
        try {
            return dereferenceValue(future.get());
        } catch (Throwable th) {
            throw new CompletionException(th.getCause());
        }
    }
}
