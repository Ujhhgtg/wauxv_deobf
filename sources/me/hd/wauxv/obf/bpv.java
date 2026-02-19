package me.hd.wauxv.obf;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bpv {
    public static final chm a = new chm(2);
    public static final Object b = KotlinHelpers.mapOf(new Pair("boolean", Boolean.TYPE), new Pair("byte", Byte.TYPE),
            new Pair("char", Character.TYPE), new Pair("short", Short.TYPE), new Pair("int", Integer.TYPE),
            new Pair("long", Long.TYPE), new Pair("float", Float.TYPE), new Pair("double", Double.TYPE),
            new Pair("void", Void.TYPE));

    /*
     * JADX WARN: Found duplicated region for block: B:17:0x0047 A[PHI: r3
     * 0x0047: PHI (r3v30 java.lang.Object) = (r3v42 java.lang.Object), (r3v43
     * java.lang.Object) binds: [B:24:0x0061, B:16:0x0045] A[DONT_GENERATE,
     * DONT_INLINE]]
     */
    /* JADX WARN: Found duplicated region for block: B:26:0x0064 */
    /*
     * JADX WARN: Found duplicated region for block: B:29:0x0079 A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:31:0x007f A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /* JADX WARN: Found duplicated region for block: B:34:0x0089 */
    /*
     * JADX WARN: Found duplicated region for block: B:36:0x008c A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /* JADX WARN: Found duplicated region for block: B:37:0x009b A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:38:0x009d A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:40:0x00be A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:42:0x00c4 A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:44:0x00cf A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /* JADX WARN: Found duplicated region for block: B:50:0x00e5 */
    /*
     * JADX WARN: Found duplicated region for block: B:53:0x00f0 A[Catch: all ->
     * 0x0086, LOOP:0: B:51:0x00e8->B:53:0x00f0, LOOP_END, TryCatch #0 {all ->
     * 0x0086, blocks: (B:27:0x0073, B:29:0x0079, B:31:0x007f, B:36:0x008c,
     * B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc, B:45:0x00d3, B:47:0x00db,
     * B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c, B:57:0x0110, B:59:0x0117,
     * B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:56:0x010c A[Catch: all ->
     * 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:27:0x0073, B:29:0x0079,
     * B:31:0x007f, B:36:0x008c, B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc,
     * B:45:0x00d3, B:47:0x00db, B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c,
     * B:57:0x0110, B:59:0x0117, B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:59:0x0117 A[Catch: all ->
     * 0x0086, LOOP:1: B:58:0x0115->B:59:0x0117, LOOP_END, TryCatch #0 {all ->
     * 0x0086, blocks: (B:27:0x0073, B:29:0x0079, B:31:0x007f, B:36:0x008c,
     * B:38:0x009d, B:40:0x00be, B:42:0x00c4, B:43:0x00cc, B:45:0x00d3, B:47:0x00db,
     * B:51:0x00e8, B:53:0x00f0, B:54:0x0102, B:56:0x010c, B:57:0x0110, B:59:0x0117,
     * B:60:0x0122, B:44:0x00cf), top: B:68:0x0073 }]
     */
    /*
     * JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object,
     * java.util.Map]
     */
    public static Class c(ClassLoader classLoader, String str) {
        ec ecVar;
        Object objB;
        WeakHashMap weakHashMap;
        Map map;
        ec ecVar2;
        String strSubstring;
        int i;
        Class<?> clsLoadClass;
        int i2;
        Class<?> cls;
        Object objB2;
        Object map2;
        ClassLoader classLoader2;
        Object obj;
        Object obj2;
        ec ecVar3;
        Object objB3;
        throwIfVar1IsNull(str, "typeName");
        chm chmVar = a;
        chmVar.getClass();
        ReentrantReadWriteLock reentrantReadWriteLock = (ReentrantReadWriteLock) chmVar.c;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        throwIfVar1IsNull(lock, "readLock(...)");
        lock.lock();
        try {
            WeakHashMap weakHashMap2 = (WeakHashMap) chmVar.f;
            if (weakHashMap2 == null) {
                WeakReference weakReference = (WeakReference) chmVar.d;
                if ((weakReference != null ? (ClassLoader) weakReference.get() : null) != classLoader
                        || (ecVar3 = (ec) ((HashMap) chmVar.e).get(str)) == null || (objB3 = ecVar3.b()) == null) {
                    obj2 = objB;
                    obj2 = objB3;
                    lock.unlock();
                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                    throwIfVar1IsNull(writeLock, "writeLock(...)");
                    writeLock.lock();
                    try {
                        weakHashMap = (WeakHashMap) chmVar.f;
                        if (weakHashMap == null) {
                            WeakReference weakReference2 = (WeakReference) chmVar.d;
                            classLoader2 = weakReference2 != null ? (ClassLoader) weakReference2.get() : null;
                            if (classLoader2 == null) {
                                chmVar.d = new WeakReference(classLoader);
                                ((HashMap) chmVar.e).clear();
                            } else if (classLoader2 != classLoader) {
                                weakHashMap = new WeakHashMap();
                                weakHashMap.put(classLoader2, (HashMap) chmVar.e);
                                weakHashMap.put(classLoader, new HashMap());
                                chmVar.f = weakHashMap;
                                chmVar.d = null;
                                chmVar.e = new HashMap();
                            }
                        }
                        if (weakHashMap != null) {
                            map2 = weakHashMap.get(classLoader);
                            if (map2 == null) {
                                map2 = new HashMap();
                                weakHashMap.put(classLoader, map2);
                            }
                            map = (Map) map2;
                        } else {
                            map = (HashMap) chmVar.e;
                        }
                        ecVar2 = (ec) map.get(str);
                        if (ecVar2 != null || (objB2 = ecVar2.b()) == null) {
                            Object obj3 = objB2;
                            strSubstring = str;
                            i = 0;
                            while (dnr.bi(strSubstring, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                                i++;
                                strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                                throwIfVar1IsNull(strSubstring, "substring(...)");
                            }
                            clsLoadClass = (Class) b.get(strSubstring);
                            if (clsLoadClass == null) {
                                clsLoadClass = classLoader.loadClass(strSubstring);
                            }
                            throwIfVar1IsNull(clsLoadClass);
                            i2 = 0;
                            cls = clsLoadClass;
                            while (i2 < i) {
                                i2++;
                                cls = Array.newInstance(cls, 0).getClass();
                            }
                            map.put(str, new ec(cls));
                            obj3 = cls;
                        }
                    } finally {
                        writeLock.unlock();
                    }
                } else {
                    obj2 = objB;
                    obj2 = objB3;
                    lock.unlock();
                    obj = obj2;
                }
            } else {
                Map map3 = (Map) weakHashMap2.get(classLoader);
                if (map3 == null || (ecVar = (ec) map3.get(str)) == null || (objB = ecVar.b()) == null) {
                    obj2 = objB;
                    obj2 = objB3;
                    lock.unlock();
                    ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock.writeLock();
                    throwIfVar1IsNull(writeLock2, "writeLock(...)");
                    writeLock2.lock();
                    weakHashMap = (WeakHashMap) chmVar.f;
                    if (weakHashMap == null) {
                        WeakReference weakReference22 = (WeakReference) chmVar.d;
                        if (weakReference22 != null) {
                        }
                        if (classLoader2 == null) {
                            chmVar.d = new WeakReference(classLoader);
                            ((HashMap) chmVar.e).clear();
                        } else if (classLoader2 != classLoader) {
                            weakHashMap = new WeakHashMap();
                            weakHashMap.put(classLoader2, (HashMap) chmVar.e);
                            weakHashMap.put(classLoader, new HashMap());
                            chmVar.f = weakHashMap;
                            chmVar.d = null;
                            chmVar.e = new HashMap();
                        }
                    }
                    if (weakHashMap != null) {
                        map2 = weakHashMap.get(classLoader);
                        if (map2 == null) {
                            map2 = new HashMap();
                            weakHashMap.put(classLoader, map2);
                        }
                        map = (Map) map2;
                    } else {
                        map = (HashMap) chmVar.e;
                    }
                    ecVar2 = (ec) map.get(str);
                    if (ecVar2 != null) {
                        Object obj32 = objB2;
                        strSubstring = str;
                        i = 0;
                        while (dnr.bi(strSubstring, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                            i++;
                            strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                            throwIfVar1IsNull(strSubstring, "substring(...)");
                        }
                        clsLoadClass = (Class) b.get(strSubstring);
                        if (clsLoadClass == null) {
                            clsLoadClass = classLoader.loadClass(strSubstring);
                        }
                        throwIfVar1IsNull(clsLoadClass);
                        i2 = 0;
                        cls = clsLoadClass;
                        while (i2 < i) {
                            i2++;
                            cls = Array.newInstance(cls, 0).getClass();
                        }
                        map.put(str, new ec(cls));
                        obj32 = cls;
                    } else {
                        Object obj322 = objB2;
                        strSubstring = str;
                        i = 0;
                        while (dnr.bi(strSubstring, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                            i++;
                            strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                            throwIfVar1IsNull(strSubstring, "substring(...)");
                        }
                        clsLoadClass = (Class) b.get(strSubstring);
                        if (clsLoadClass == null) {
                            clsLoadClass = classLoader.loadClass(strSubstring);
                        }
                        throwIfVar1IsNull(clsLoadClass);
                        i2 = 0;
                        cls = clsLoadClass;
                        while (i2 < i) {
                            i2++;
                            cls = Array.newInstance(cls, 0).getClass();
                        }
                        map.put(str, new ec(cls));
                        obj322 = cls;
                    }
                } else {
                    obj2 = objB;
                    obj2 = objB3;
                    lock.unlock();
                    obj = obj2;
                }
            }
            return (Class) obj;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    /*
     * JADX WARN: Type inference failed for: r3v3, types: [java.io.Serializable,
     * java.lang.Object[]]
     */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     * at java.base/java.util.Objects.requireNonNull(Objects.java:209)
     * at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
     * at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
     * at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(
     * TryCatchEdgeBlockMap.java:91)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:204)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    public static Serializable d(ClassLoader classLoader, ArrayList arrayList) {
        Object objX;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                objX = c(classLoader, (String) it.next());
            } catch (Throwable th) {
                objX = FastKV.x(th);
            }
            Throwable thB = dcy.b(objX);
            if (thB != null) {
                return FastKV.x(thB);
            }
            arrayList2.add((Class) objX);
        }
        return arrayList2.toArray(new Class[0]);
    }
}
