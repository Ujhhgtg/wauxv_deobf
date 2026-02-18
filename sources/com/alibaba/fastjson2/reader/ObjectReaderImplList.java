package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.GuavaSupport;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cpl;
import me.hd.wauxv.obf.cpt;
import me.hd.wauxv.obf.cpv;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ObjectReaderImplList implements ObjectReader {
    static final Class CLASS_ARRAYS_LIST;
    static final Class CLASS_EMPTY_LIST;
    static final Class CLASS_EMPTY_SET;
    static final Class CLASS_SINGLETON;
    static final Class CLASS_SINGLETON_LIST;
    static final Class CLASS_UNMODIFIABLE_COLLECTION;
    static final Class CLASS_UNMODIFIABLE_LIST;
    static final Class CLASS_UNMODIFIABLE_NAVIGABLE_SET;
    static final Class CLASS_UNMODIFIABLE_SET;
    static final Class CLASS_UNMODIFIABLE_SORTED_SET;
    public static ObjectReaderImplList INSTANCE;
    static List kotlinEmptyList;
    static Set kotlinEmptySet;
    final Function builder;
    volatile Constructor constructor;
    volatile boolean instanceError;
    final Class instanceType;
    final long instanceTypeHash;
    final Class itemClass;
    final String itemClassName;
    final long itemClassNameHash;
    ObjectReader itemObjectReader;
    final Type itemType;
    final Class listClass;
    Object listSingleton;
    final Type listType;

    static {
        Set set = Collections.EMPTY_SET;
        CLASS_EMPTY_SET = set.getClass();
        List list = Collections.EMPTY_LIST;
        CLASS_EMPTY_LIST = list.getClass();
        CLASS_SINGLETON = Collections.singleton(0).getClass();
        CLASS_SINGLETON_LIST = Collections.singletonList(0).getClass();
        CLASS_ARRAYS_LIST = Arrays.asList(0).getClass();
        CLASS_UNMODIFIABLE_COLLECTION = Collections.unmodifiableCollection(list).getClass();
        CLASS_UNMODIFIABLE_LIST = Collections.unmodifiableList(list).getClass();
        CLASS_UNMODIFIABLE_SET = Collections.unmodifiableSet(set).getClass();
        CLASS_UNMODIFIABLE_SORTED_SET = Collections.unmodifiableSortedSet(Collections.emptySortedSet()).getClass();
        CLASS_UNMODIFIABLE_NAVIGABLE_SET = Collections.unmodifiableNavigableSet(Collections.emptyNavigableSet())
                .getClass();
        INSTANCE = new ObjectReaderImplList(ArrayList.class, ArrayList.class, ArrayList.class, Object.class, null);
    }

    public ObjectReaderImplList(Class cls, Object obj) {
        this(cls, cls, cls, Object.class, null);
        this.listSingleton = obj;
    }

    public static List getKotlinEmptyList(Class cls) {
        List list = kotlinEmptyList;
        if (list != null) {
            return list;
        }
        try {
            Field field = cls.getField("INSTANCE");
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            List list2 = (List) field.get(null);
            kotlinEmptyList = list2;
            return list2;
        } catch (IllegalAccessException e) {
            e = e;
            throw new IllegalStateException(concatVar2Var1(cls, "Failed to get singleton of "), e);
        } catch (NoSuchFieldException e2) {
            e = e2;
            throw new IllegalStateException(concatVar2Var1(cls, "Failed to get singleton of "), e);
        }
    }

    public static Set getKotlinEmptySet(Class cls) {
        Set set = kotlinEmptySet;
        if (set != null) {
            return set;
        }
        try {
            Field field = cls.getField("INSTANCE");
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            Set set2 = (Set) field.get(null);
            kotlinEmptySet = set2;
            return set2;
        } catch (IllegalAccessException e) {
            e = e;
            throw new IllegalStateException(concatVar2Var1(cls, "Failed to get singleton of "), e);
        } catch (NoSuchFieldException e2) {
            e = e2;
            throw new IllegalStateException(concatVar2Var1(cls, "Failed to get singleton of "), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$0(Type type, Object obj) {
        Collection collection = (Collection) obj;
        return (collection.isEmpty() && (type instanceof Class)) ? EnumSet.noneOf((Class) type)
                : EnumSet.copyOf(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$1(Object obj) {
        return Collections.singleton(((List) obj).get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$2(Object obj) {
        return Collections.singletonList(((List) obj).get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$3(Object obj) {
        return Arrays.asList(((List) obj).toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$4(Object obj) {
        return Collections.unmodifiableCollection((Collection) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$5(Object obj) {
        return Collections.unmodifiableList((List) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$6(Object obj) {
        return Collections.unmodifiableSet((Set) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$7(Object obj) {
        return Collections.unmodifiableSortedSet((SortedSet) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$8(Object obj) {
        return Collections.unmodifiableNavigableSet((NavigableSet) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$readJSONBObject$10(List list) {
        return Collections.singletonList(list.get(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$readJSONBObject$11(Collection collection) {
        return Collections.singletonList(collection.iterator().next());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$readJSONBObject$12(Object obj) {
        Collection collection = (Collection) obj;
        if (collection.isEmpty()) {
            Type type = this.itemType;
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
        }
        return EnumSet.copyOf(collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Collection lambda$readJSONBObject$9(Collection collection) {
        return Collections.singleton(collection.iterator().next());
    }

    /*
     * JADX WARN: Failed to clean up code after switch over string restore
     * jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v1
     * int, still in use, count: 2, list:
     * (r12v1 int) from 0x0218: PHI (r12v10 int) = (r12v1 int), (r12v2 int), (r12v3
     * int), (r12v4 int), (r12v6 int), (r12v7 int), (r12v8 int), (r12v9 int),
     * (r12v11 int) binds: [B:140:0x0215, B:166:?, B:165:?, B:138:0x020d, B:164:?,
     * B:134:0x0202, B:163:?, B:130:0x01f7, B:126:0x01ec] A[DONT_GENERATE,
     * DONT_INLINE, REMOVE]
     * (r12v1 int) from 0x00cf: CONSTRUCTOR (r3v22 java.util.function.Function) =
     * (r12v1 int) A[MD:(int):void (m), REMOVE] (LINE:208) call:
     * me.hd.wauxv.obf.cpv.<init>(int):void type: CONSTRUCTOR
     * at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
     * at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
     * at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
     * at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
     * at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
     * at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
     * at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:271)
     * at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.markCodeForRemoval(
     * SwitchOverStringVisitor.java:160)
     * at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.
     * restoreSwitchOverString(SwitchOverStringVisitor.java:124)
     * at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(
     * SwitchOverStringVisitor.java:71)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.
     * traverseIterativeStepInternal(DepthRegionTraversal.java:77)
     * at jadx.core.dex.visitors.regions.DepthRegionTraversal.
     * traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Found duplicated region for block: B:116:0x01a0 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:119:0x01b6 */
    /* JADX WARN: Found duplicated region for block: B:122:0x01ce */
    /* JADX WARN: Found duplicated region for block: B:126:0x01ec */
    /* JADX WARN: Found duplicated region for block: B:127:0x01ee */
    /* JADX WARN: Found duplicated region for block: B:130:0x01f7 */
    /* JADX WARN: Found duplicated region for block: B:131:0x01f9 */
    /* JADX WARN: Found duplicated region for block: B:134:0x0202 */
    /* JADX WARN: Found duplicated region for block: B:135:0x0204 */
    /* JADX WARN: Found duplicated region for block: B:138:0x020d */
    /* JADX WARN: Found duplicated region for block: B:139:0x020f */
    /* JADX WARN: Found duplicated region for block: B:143:0x021b */
    /*
     * JADX WARN: Found duplicated region for block: B:145:0x021f A[ADDED_TO_REGION]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:150:0x022b A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:155:0x0239 */
    /* JADX WARN: Found duplicated region for block: B:157:0x0245 */
    /* JADX WARN: Found duplicated region for block: B:159:0x024f */
    /* JADX WARN: Found duplicated region for block: B:161:0x0259 */
    /* JADX WARN: Found duplicated region for block: B:163:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:164:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:165:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:166:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:20:0x004e */
    /* JADX WARN: Found duplicated region for block: B:23:0x005b */
    /*
     * JADX WARN: Found duplicated region for block: B:56:0x00aa A[PHI: r0 r3
     * 0x00aa: PHI (r0v3 java.lang.Class) =
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v6 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * (r0v2 java.lang.Class)
     * binds: [B:22:0x0059, B:24:0x005d, B:26:0x0061, B:28:0x0065, B:30:0x0069,
     * B:80:0x0113, B:122:0x01ce, B:120:0x01bc, B:119:0x01b6, B:118:0x01ad,
     * B:98:0x015b, B:102:0x016b, B:104:0x0173, B:108:0x0183, B:71:0x00e1,
     * B:68:0x00d7, B:65:0x00cd, B:59:0x00b2, B:55:0x00a3] A[DONT_GENERATE,
     * DONT_INLINE]
     * 0x00aa: PHI (r3v2 java.util.function.Function) =
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v11 java.util.function.Function)
     * (r3v13 java.util.function.Function)
     * (r3v14 java.util.function.Function)
     * (r3v15 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v1 java.util.function.Function)
     * (r3v20 java.util.function.Function)
     * (r3v21 java.util.function.Function)
     * (r3v22 java.util.function.Function)
     * (r3v25 java.util.function.Function)
     * (r3v26 java.util.function.Function)
     * binds: [B:22:0x0059, B:24:0x005d, B:26:0x0061, B:28:0x0065, B:30:0x0069,
     * B:80:0x0113, B:122:0x01ce, B:120:0x01bc, B:119:0x01b6, B:118:0x01ad,
     * B:98:0x015b, B:102:0x016b, B:104:0x0173, B:108:0x0183, B:71:0x00e1,
     * B:68:0x00d7, B:65:0x00cd, B:59:0x00b2, B:55:0x00a3] A[DONT_GENERATE,
     * DONT_INLINE]]
     */
    public static ObjectReader of(Type type, Class cls, long j) {
        Type type2;
        Type rawType;
        Class cls2;
        Class cls3;
        Function cplVar;
        Function cplVar2;
        Class cls4;
        String typeName;
        if (cls == type && cls.getSimpleName().isEmpty()) {
            type = cls.getGenericSuperclass();
            cls = cls.getSuperclass();
        }
        Type type3 = type;
        int i = 1;
        Type type4 = Object.class;
        if (!(type3 instanceof ParameterizedType)) {
            if (cls != null) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
                    rawType = parameterizedType.getRawType();
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    if (actualTypeArguments.length == 1) {
                        type4 = actualTypeArguments[0];
                    }
                }
                if (cls == null) {
                    cls = TypeUtils.getClass(rawType);
                }
                cls2 = cls;
                int i2 = 2;
                cls3 = ArrayList.class;
                cplVar = null;
                if (cls2 != Iterable.class || cls2 == Collection.class || cls2 == List.class
                        || cls2 == AbstractCollection.class || cls2 == AbstractList.class) {
                    cplVar2 = cplVar;
                    cls4 = cls3;
                } else if (cls2 == Queue.class || cls2 == Deque.class || cls2 == AbstractSequentialList.class) {
                    cplVar2 = null;
                    cls4 = LinkedList.class;
                } else if (cls2 == Set.class || cls2 == AbstractSet.class) {
                    cplVar2 = cplVar;
                    cls4 = HashSet.class;
                } else {
                    if (cls2 == EnumSet.class) {
                        cplVar = new cpt(type2, i2);
                    } else if (cls2 == NavigableSet.class || cls2 == SortedSet.class) {
                        cplVar2 = cplVar;
                        cls4 = TreeSet.class;
                    } else {
                        if (cls2 == CLASS_SINGLETON) {
                            cplVar = new cpl(27);
                        } else if (cls2 == CLASS_SINGLETON_LIST) {
                            cplVar = new cpl(28);
                        } else {
                            Class cls5 = CLASS_ARRAYS_LIST;
                            if (cls2 == cls5) {
                                cplVar2 = new cpl(29);
                                cls4 = cls5;
                            } else if (cls2 == CLASS_UNMODIFIABLE_COLLECTION) {
                                cplVar = new cpv(r12);
                            } else if (cls2 == CLASS_UNMODIFIABLE_LIST) {
                                cplVar = new cpv(i);
                            } else if (cls2 == CLASS_UNMODIFIABLE_SET) {
                                cplVar = new cpl(11);
                                cls3 = LinkedHashSet.class;
                            } else {
                                if (cls2 == CLASS_UNMODIFIABLE_SORTED_SET) {
                                    cplVar = new cpl(12);
                                } else if (cls2 == CLASS_UNMODIFIABLE_NAVIGABLE_SET) {
                                    cplVar = new cpl(13);
                                } else {
                                    String typeName2 = cls2.getTypeName();
                                    typeName2.getClass();
                                    if (!typeName2.equals("java.util.AbstractList$RandomAccessSubList")) {
                                        if (typeName2.equals("java.util.Collections$SynchronizedSortedSet")) {
                                            cplVar = new cpl(25);
                                        } else if (typeName2.equals("com.google.common.collect.ImmutableList")) {
                                            cplVar = GuavaSupport.immutableListConverter();
                                        } else if (typeName2.equals("java.util.Collections$SynchronizedSet")) {
                                            cplVar = new cpl(24);
                                        } else if (typeName2.equals("com.google.common.collect.RegularImmutableList")) {
                                            cplVar = GuavaSupport.immutableListConverter();
                                        } else if (typeName2.equals("java.util.Collections$SynchronizedCollection")) {
                                            cplVar = new cpl(21);
                                        } else if (typeName2
                                                .equals("com.google.common.collect.SingletonImmutableSet")) {
                                            cplVar = GuavaSupport.immutableSetConverter();
                                        } else if (typeName2
                                                .equals("java.util.Collections$SynchronizedRandomAccessList")) {
                                            cplVar = new cpl(14);
                                        } else if (typeName2.equals("java.util.Collections$SynchronizedNavigableSet")) {
                                            cplVar = new cpl(26);
                                        } else if (!typeName2.equals("java.util.SubList")) {
                                            if (typeName2.equals("com.google.common.collect.SingletonImmutableList")) {
                                                cplVar = GuavaSupport.immutableListConverter();
                                            } else if (!typeName2.equals("java.util.RandomAccessSubList")
                                                    && !typeName2.equals("java.util.AbstractList$SubList")) {
                                                if (typeName2.equals("com.google.common.collect.ImmutableSet")) {
                                                    cplVar = GuavaSupport.immutableSetConverter();
                                                } else if (!typeName2.equals(
                                                        "com.google.common.collect.Lists$TransformingRandomAccessList")) {
                                                    if (typeName2.equals(
                                                            "com.google.common.collect.Lists.TransformingSequentialList")) {
                                                        cplVar2 = null;
                                                        cls4 = LinkedList.class;
                                                    } else if (typeName2.equals(
                                                            "com.google.common.collect.AbstractMapBasedMultimap$RandomAccessWrappedList")) {
                                                        cplVar = GuavaSupport.immutableListConverter();
                                                    } else if (typeName2
                                                            .equals("com.google.common.collect.RegularImmutableSet")) {
                                                        cplVar = GuavaSupport.immutableSetConverter();
                                                    } else {
                                                        cplVar2 = null;
                                                        cls4 = cls2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                cplVar2 = cplVar;
                                cls4 = TreeSet.class;
                            }
                        }
                        cplVar2 = cplVar;
                        cls4 = cls3;
                    }
                    cplVar2 = cplVar;
                    cls4 = HashSet.class;
                }
                typeName = type3.getTypeName();
                typeName.getClass();
                switch (typeName) {
                    case "kotlin.collections.EmptyList":
                        Class cls6 = (Class) type3;
                        return new ObjectReaderImplList(cls6, getKotlinEmptyList(cls6));
                    case "java.util.Collections$EmptySet":
                        return new ObjectReaderImplList((Class) type3, Collections.EMPTY_SET);
                    case "java.util.Collections$EmptyList":
                        return new ObjectReaderImplList((Class) type3, Collections.EMPTY_LIST);
                    case "kotlin.collections.EmptySet":
                        Class cls7 = (Class) type3;
                        return new ObjectReaderImplList(cls7, getKotlinEmptySet(cls7));
                    default:
                        return (type2 == String.class || cplVar2 != null)
                                ? (type2 == Long.class || cplVar2 != null)
                                        ? new ObjectReaderImplList(type3, cls2, cls4, type2, cplVar2)
                                        : new ObjectReaderImplListInt64(cls2, cls4)
                                : new ObjectReaderImplListStr(cls2, cls4);
                }
            }
            type2 = type4;
            rawType = type3;
            if (cls == null) {
                cls = TypeUtils.getClass(rawType);
            }
            cls2 = cls;
            int i22 = 2;
            cls3 = ArrayList.class;
            cplVar = null;
            if (cls2 != Iterable.class) {
                cplVar2 = cplVar;
                cls4 = cls3;
            } else {
                cplVar2 = cplVar;
                cls4 = cls3;
            }
            typeName = type3.getTypeName();
            typeName.getClass();
            switch (typeName) {
                case -1815537371:
                    if (!typeName.equals("kotlin.collections.EmptyList")) {
                        r12 = -1;
                    }
                    break;
                case -413656092:
                    if (!typeName.equals("java.util.Collections$EmptySet")) {
                        r12 = -1;
                    }
                    break;
                case 61358428:
                    if (!typeName.equals("java.util.Collections$EmptyList")) {
                        r12 = -1;
                    }
                    break;
                case 357082875:
                    if (!typeName.equals("kotlin.collections.EmptySet")) {
                        r12 = -1;
                    }
                    break;
                default:
                    r12 = -1;
                    break;
            }
            switch (r12) {
                case 0:
                    Class cls62 = (Class) type3;
                    return new ObjectReaderImplList(cls62, getKotlinEmptyList(cls62));
                case 1:
                    return new ObjectReaderImplList((Class) type3, Collections.EMPTY_SET);
                case 2:
                    return new ObjectReaderImplList((Class) type3, Collections.EMPTY_LIST);
                case 3:
                    Class cls72 = (Class) type3;
                    return new ObjectReaderImplList(cls72, getKotlinEmptySet(cls72));
                default:
                    if (type2 == String.class) {
                    }
            }
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) type3;
        rawType = parameterizedType2.getRawType();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        if (actualTypeArguments2.length == 1) {
            type4 = actualTypeArguments2[0];
        }
        type2 = type4;
        if (cls == null) {
            cls = TypeUtils.getClass(rawType);
        }
        cls2 = cls;
        int i222 = 2;
        cls3 = ArrayList.class;
        cplVar = null;
        if (cls2 != Iterable.class) {
            cplVar2 = cplVar;
            cls4 = cls3;
        } else {
            cplVar2 = cplVar;
            cls4 = cls3;
        }
        typeName = type3.getTypeName();
        typeName.getClass();
        switch (typeName) {
            case -1815537371:
                if (!typeName.equals("kotlin.collections.EmptyList")) {
                    r12 = -1;
                }
                break;
            case -413656092:
                if (!typeName.equals("java.util.Collections$EmptySet")) {
                    r12 = -1;
                }
                break;
            case 61358428:
                if (!typeName.equals("java.util.Collections$EmptyList")) {
                    r12 = -1;
                }
                break;
            case 357082875:
                if (!typeName.equals("kotlin.collections.EmptySet")) {
                    r12 = -1;
                }
                break;
            default:
                r12 = -1;
                break;
        }
        switch (r12) {
            case 0:
                Class cls622 = (Class) type3;
                return new ObjectReaderImplList(cls622, getKotlinEmptyList(cls622));
            case 1:
                return new ObjectReaderImplList((Class) type3, Collections.EMPTY_SET);
            case 2:
                return new ObjectReaderImplList((Class) type3, Collections.EMPTY_LIST);
            case 3:
                Class cls722 = (Class) type3;
                return new ObjectReaderImplList(cls722, getKotlinEmptySet(cls722));
            default:
                if (type2 == String.class) {
                }
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(Collection collection, long j) {
        if (collection.size() == 0 && this.listClass == List.class) {
            ArrayList arrayList = new ArrayList();
            Function function = this.builder;
            return function != null ? function.apply(arrayList) : arrayList;
        }
        ObjectReaderProvider defaultObjectReaderProvider = JSONFactory.getDefaultObjectReaderProvider();
        Collection arrayList2 = this.instanceType == ArrayList.class ? new ArrayList(collection.size())
                : (Collection) createInstance(0L);
        for (Object objCreateInstance : collection) {
            if (objCreateInstance == null) {
                arrayList2.add(null);
            } else {
                Class<?> cls = objCreateInstance.getClass();
                if ((cls == JSONObject.class || cls == TypeUtils.CLASS_JSON_OBJECT_1x) && this.itemClass != cls) {
                    if (this.itemObjectReader == null) {
                        this.itemObjectReader = defaultObjectReaderProvider.getObjectReader(this.itemType);
                    }
                    objCreateInstance = this.itemObjectReader.createInstance((Map) objCreateInstance, j);
                } else {
                    Type type = this.itemType;
                    if (cls != type) {
                        Function typeConvert = defaultObjectReaderProvider.getTypeConvert(cls, type);
                        if (typeConvert != null) {
                            objCreateInstance = typeConvert.apply(objCreateInstance);
                        } else if (objCreateInstance instanceof Map) {
                            Map map = (Map) objCreateInstance;
                            if (this.itemObjectReader == null) {
                                this.itemObjectReader = defaultObjectReaderProvider.getObjectReader(this.itemType);
                            }
                            objCreateInstance = this.itemObjectReader.createInstance(map, 0L);
                        } else if (objCreateInstance instanceof Collection) {
                            if (this.itemObjectReader == null) {
                                this.itemObjectReader = defaultObjectReaderProvider.getObjectReader(this.itemType);
                            }
                            objCreateInstance = this.itemObjectReader.createInstance((Collection) objCreateInstance, j);
                        } else if (!this.itemClass.isInstance(objCreateInstance)) {
                            if (!Enum.class.isAssignableFrom(this.itemClass)) {
                                throw new JSONException("can not convert from " + cls + " to " + this.itemType);
                            }
                            if (this.itemObjectReader == null) {
                                this.itemObjectReader = defaultObjectReaderProvider.getObjectReader(this.itemType);
                            }
                            ObjectReader objectReader = this.itemObjectReader;
                            if (!(objectReader instanceof ObjectReaderImplEnum)) {
                                throw new JSONException("can not convert from " + cls + " to " + this.itemType);
                            }
                            objCreateInstance = ((ObjectReaderImplEnum) objectReader)
                                    .getEnum((String) objCreateInstance);
                        }
                    }
                }
                arrayList2.add(objCreateInstance);
            }
        }
        Function function2 = this.builder;
        return function2 != null ? function2.apply(arrayList2) : arrayList2;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Function getBuildFunction() {
        return this.builder;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Class getObjectClass() {
        return this.listClass;
    }

    /* JADX WARN: Found duplicated region for block: B:113:0x01f5 */
    /* JADX WARN: Found duplicated region for block: B:119:0x020d */
    /* JADX WARN: Found duplicated region for block: B:121:0x0213 */
    /* JADX WARN: Found duplicated region for block: B:123:0x021d */
    /* JADX WARN: Found duplicated region for block: B:124:0x021f */
    /* JADX WARN: Found duplicated region for block: B:126:0x022a */
    /* JADX WARN: Found duplicated region for block: B:128:0x0230 */
    /* JADX WARN: Found duplicated region for block: B:129:0x0233 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:131:0x0241 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:132:0x0255 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:137:0x026f */
    /* JADX WARN: Found duplicated region for block: B:139:0x0274 A[RETURN] */
    /*
     * JADX WARN: Found duplicated region for block: B:146:0x026d A[EDGE_INSN:
     * B:146:0x026d->B:136:0x026d BREAK A[LOOP:1: B:135:0x026a->B:134:0x0266],
     * SYNTHETIC]
     */
    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readJSONBObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Type type2;
        Class cls;
        JSONReader jSONReader2;
        Collection arrayList;
        Function cplVar;
        JSONArray jSONArray;
        ObjectReader objectReader;
        Type type3;
        ObjectReader objectReader2;
        Type type4;
        ObjectReader objectReaderCheckAutoType;
        Object jSONBObject;
        String reference;
        Collection collection;
        Type[] actualTypeArguments;
        Collection kotlinEmptyList2;
        ArrayList arrayList2;
        Object jSONBObject2;
        if (jSONReader.nextIfNull()) {
            return null;
        }
        ObjectReader objectReaderCheckAutoType2 = jSONReader.checkAutoType(this.listClass, 0L, j);
        Function cptVar = this.builder;
        Class objectClass = this.instanceType;
        int i = 16;
        if (objectReaderCheckAutoType2 == null) {
            type2 = type;
            cls = objectClass;
            jSONReader2 = jSONReader;
        } else {
            if (objectReaderCheckAutoType2 instanceof ObjectReaderImplList) {
                ObjectReaderImplList objectReaderImplList = (ObjectReaderImplList) objectReaderCheckAutoType2;
                objectClass = objectReaderImplList.instanceType;
                cptVar = objectReaderImplList.builder;
            } else {
                objectClass = objectReaderCheckAutoType2.getObjectClass();
            }
            if (objectClass == CLASS_UNMODIFIABLE_COLLECTION) {
                cptVar = new cpl(15);
            } else if (objectClass == CLASS_UNMODIFIABLE_LIST) {
                cptVar = new cpl(i);
            } else if (objectClass == CLASS_UNMODIFIABLE_SET) {
                cptVar = new cpl(17);
                jSONReader2 = jSONReader;
                type2 = type;
                cls = LinkedHashSet.class;
            } else {
                if (objectClass == CLASS_UNMODIFIABLE_SORTED_SET) {
                    cptVar = new cpl(18);
                } else if (objectClass == CLASS_UNMODIFIABLE_NAVIGABLE_SET) {
                    cptVar = new cpl(19);
                } else if (objectClass == CLASS_SINGLETON) {
                    cptVar = new cpl(20);
                } else if (objectClass == CLASS_SINGLETON_LIST) {
                    cptVar = new cpl(22);
                } else {
                    String typeName = objectClass.getTypeName();
                    typeName.getClass();
                    if (typeName.equals("me.hd.wauxv.obf.avd") || typeName.equals("me.hd.wauxv.obf.avh")) {
                        return objectReaderCheckAutoType2.readObject(jSONReader, type, obj, j);
                    }
                    type2 = type;
                    cls = objectClass;
                    jSONReader2 = jSONReader;
                }
                jSONReader2 = jSONReader;
                type2 = type;
                cls = TreeSet.class;
            }
            jSONReader2 = jSONReader;
            type2 = type;
            cls = ArrayList.class;
        }
        int iStartArray = jSONReader2.startArray();
        if (iStartArray > 0 && this.itemObjectReader == null) {
            this.itemObjectReader = jSONReader2.getContext().getObjectReader(this.itemType);
        }
        int i2 = 0;
        if (cls == CLASS_ARRAYS_LIST) {
            Object[] objArr = new Object[iStartArray];
            List listAsList = Arrays.asList(objArr);
            while (i2 < iStartArray) {
                if (jSONReader2.isReference()) {
                    String reference2 = jSONReader2.readReference();
                    if ("..".equals(reference2)) {
                        jSONBObject2 = listAsList;
                    } else {
                        jSONReader2.addResolveTask(listAsList, i2, JSONPath.of(reference2));
                        jSONBObject2 = null;
                    }
                } else {
                    jSONBObject2 = this.itemObjectReader.readJSONBObject(jSONReader2, this.itemType,
                            Integer.valueOf(i2), j);
                }
                objArr[i2] = jSONBObject2;
                i2++;
            }
            return listAsList;
        }
        if (cls == ArrayList.class) {
            if (iStartArray > 0) {
                kotlinEmptyList2 = arrayList2;
                arrayList2 = new ArrayList(iStartArray);
            } else {
                kotlinEmptyList2 = arrayList2;
                arrayList2 = new ArrayList();
            }
        } else if (cls == JSONArray.class) {
            if (iStartArray > 0) {
                kotlinEmptyList2 = jSONArray;
                jSONArray = new JSONArray(iStartArray);
            } else {
                kotlinEmptyList2 = jSONArray;
                jSONArray = new JSONArray();
            }
        } else if (cls == HashSet.class) {
            kotlinEmptyList2 = new HashSet();
        } else if (cls == LinkedHashSet.class) {
            kotlinEmptyList2 = new LinkedHashSet();
        } else if (cls == TreeSet.class) {
            kotlinEmptyList2 = new TreeSet();
        } else if (cls == CLASS_EMPTY_SET) {
            kotlinEmptyList2 = Collections.EMPTY_SET;
        } else if (cls == CLASS_EMPTY_LIST) {
            kotlinEmptyList2 = Collections.EMPTY_LIST;
        } else {
            if (cls != CLASS_SINGLETON_LIST) {
                if (cls == CLASS_UNMODIFIABLE_LIST) {
                    arrayList = new ArrayList();
                    cplVar = new cpl(i);
                } else if (cls != null && EnumSet.class.isAssignableFrom(cls)) {
                    HashSet hashSet = new HashSet();
                    cptVar = new cpt(this, 3);
                    kotlinEmptyList2 = hashSet;
                } else if (cls == null || cls == this.listType) {
                    kotlinEmptyList2 = (Collection) createInstance(jSONReader2.getContext().getFeatures() | j);
                } else {
                    String name = cls.getName();
                    if (name.equals("me.hd.wauxv.obf.avd")) {
                        kotlinEmptyList2 = getKotlinEmptyList(cls);
                    } else if (name.equals("me.hd.wauxv.obf.avh")) {
                        kotlinEmptyList2 = getKotlinEmptySet(cls);
                    } else {
                        try {
                            kotlinEmptyList2 = (Collection) cls.newInstance();
                        } catch (IllegalAccessException | InstantiationException e) {
                            throw new JSONException(jSONReader2.info("create instance error " + cls), e);
                        }
                    }
                }
                objectReader = this.itemObjectReader;
                type3 = this.itemType;
                if (type2 instanceof ParameterizedType) {
                    actualTypeArguments = ((ParameterizedType) type2).getActualTypeArguments();
                    if (actualTypeArguments.length == 1 && (type3 = actualTypeArguments[0]) != this.itemType) {
                        objectReader = jSONReader2.getObjectReader(type3);
                    }
                }
                while (true) {
                    objectReader2 = objectReader;
                    type4 = type3;
                    if (i2 < iStartArray) {
                        break;
                    }
                    if (jSONReader2.isReference()) {
                        reference = jSONReader2.readReference();
                        if ("..".equals(reference)) {
                            collection = arrayList;
                        } else {
                            jSONReader2.addResolveTask(arrayList, i2, JSONPath.of(reference));
                            if (arrayList instanceof List) {
                                collection = null;
                            } else {
                                objectReader = objectReader2;
                                type3 = type4;
                            }
                            i2++;
                            jSONReader2 = jSONReader;
                        }
                        Collection collection2 = collection;
                        objectReader = objectReader2;
                        jSONBObject = collection2;
                        type3 = type4;
                    } else {
                        objectReaderCheckAutoType = jSONReader.checkAutoType(this.itemClass, this.itemClassNameHash, j);
                        if (objectReaderCheckAutoType != null) {
                            type3 = type4;
                            objectReader = objectReader2;
                            jSONBObject = objectReaderCheckAutoType.readJSONBObject(jSONReader, type3,
                                    Integer.valueOf(i2), j);
                        } else {
                            type3 = type4;
                            objectReader = objectReader2;
                            jSONBObject = objectReader.readJSONBObject(jSONReader, type3, Integer.valueOf(i2), j);
                        }
                    }
                    arrayList.add(jSONBObject);
                    i2++;
                    jSONReader2 = jSONReader;
                }
                return cplVar != null ? cplVar.apply(arrayList) : arrayList;
            }
            ArrayList arrayList3 = new ArrayList();
            cptVar = new cpl(23);
            kotlinEmptyList2 = arrayList3;
        }
        cplVar = cptVar;
        arrayList = kotlinEmptyList2;
        objectReader = this.itemObjectReader;
        type3 = this.itemType;
        if (type2 instanceof ParameterizedType) {
            actualTypeArguments = ((ParameterizedType) type2).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                objectReader = jSONReader2.getObjectReader(type3);
            }
        }
        while (true) {
            objectReader2 = objectReader;
            type4 = type3;
            if (i2 < iStartArray) {
                break;
                break;
            }
            if (jSONReader2.isReference()) {
                reference = jSONReader2.readReference();
                if ("..".equals(reference)) {
                    collection = arrayList;
                } else {
                    jSONReader2.addResolveTask(arrayList, i2, JSONPath.of(reference));
                    if (arrayList instanceof List) {
                        collection = null;
                    } else {
                        objectReader = objectReader2;
                        type3 = type4;
                    }
                    i2++;
                    jSONReader2 = jSONReader;
                }
                Collection collection22 = collection;
                objectReader = objectReader2;
                jSONBObject = collection22;
                type3 = type4;
            } else {
                objectReaderCheckAutoType = jSONReader.checkAutoType(this.itemClass, this.itemClassNameHash, j);
                if (objectReaderCheckAutoType != null) {
                    type3 = type4;
                    objectReader = objectReader2;
                    jSONBObject = objectReaderCheckAutoType.readJSONBObject(jSONReader, type3, Integer.valueOf(i2), j);
                } else {
                    type3 = type4;
                    objectReader = objectReader2;
                    jSONBObject = objectReader.readJSONBObject(jSONReader, type3, Integer.valueOf(i2), j);
                }
            }
            arrayList.add(jSONBObject);
            i2++;
            jSONReader2 = jSONReader;
        }
        if (cplVar != null) {
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object readObject(JSONReader jSONReader, Type type, Object obj, long j) {
        Object object;
        JSONReader.Context context = jSONReader.getContext();
        if (this.itemObjectReader == null) {
            this.itemObjectReader = context.getObjectReader(this.itemType);
        }
        if (jSONReader.jsonb) {
            return readJSONBObject(jSONReader, type, obj, 0L);
        }
        if (jSONReader.readIfNull()) {
            return null;
        }
        Collection hashSet = jSONReader.nextIfSet() ? new HashSet()
                : (Collection) createInstance(context.getFeatures() | j);
        char cCurrent = jSONReader.current();
        if (cCurrent == '\"') {
            String string = jSONReader.readString();
            if (this.itemClass == String.class) {
                jSONReader.nextIfComma();
                hashSet.add(string);
                return hashSet;
            }
            if (string.isEmpty()) {
                jSONReader.nextIfComma();
                return null;
            }
            ObjectReaderProvider provider = context.getProvider();
            if (this.itemClass.isEnum()) {
                ObjectReader objectReader = provider.getObjectReader(this.itemClass);
                if (objectReader instanceof ObjectReaderImplEnum) {
                    Enum r0 = ((ObjectReaderImplEnum) objectReader).getEnum(string);
                    if (r0 != null) {
                        hashSet.add(r0);
                        return hashSet;
                    }
                    if (JSONReader.Feature.ErrorOnEnumNotMatch.isEnabled(jSONReader.features(j))) {
                        throw new JSONException(jSONReader.info("enum not match : ".concat(string)));
                    }
                    return null;
                }
            }
            Function typeConvert = provider.getTypeConvert(String.class, this.itemType);
            if (typeConvert == null) {
                throw new JSONException(jSONReader.info());
            }
            Object objApply = typeConvert.apply(string);
            jSONReader.nextIfComma();
            hashSet.add(objApply);
            return hashSet;
        }
        int i = 0;
        if (cCurrent != '[') {
            Class cls = this.itemClass;
            if ((cls == Object.class || this.itemObjectReader == null)
                    && !(cls == Object.class && jSONReader.isObject())) {
                throw new JSONException(jSONReader.info());
            }
            hashSet.add(this.itemObjectReader.readObject(jSONReader, this.itemType, 0, 0L));
            Function function = this.builder;
            return function != null ? (Collection) function.apply(hashSet) : hashSet;
        }
        jSONReader.next();
        ObjectReader objectReader2 = this.itemObjectReader;
        Type type2 = this.itemType;
        if (type != this.listType && (type instanceof ParameterizedType)) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments.length == 1 && (type2 = actualTypeArguments[0]) != this.itemType) {
                objectReader2 = jSONReader.getObjectReader(type2);
            }
        }
        ObjectReader objectReader3 = objectReader2;
        Type type3 = type2;
        while (!jSONReader.nextIfArrayEnd()) {
            if (type3 == String.class) {
                object = jSONReader.readString();
            } else {
                if (objectReader3 == null) {
                    throw new JSONException(jSONReader.info("TODO : " + type3));
                }
                if (jSONReader.isReference()) {
                    String reference = jSONReader.readReference();
                    if ("..".equals(reference)) {
                        object = this;
                    } else {
                        jSONReader.addResolveTask(hashSet, i, JSONPath.of(reference));
                    }
                    i++;
                } else {
                    object = objectReader3.readObject(jSONReader, type3, Integer.valueOf(i), 0L);
                }
            }
            hashSet.add(object);
            i++;
        }
        jSONReader.nextIfComma();
        Function function2 = this.builder;
        return function2 != null ? function2.apply(hashSet) : hashSet;
    }

    public ObjectReaderImplList(Type type, Class cls, Class cls2, Type type2, Function function) {
        this.listType = type;
        this.listClass = cls;
        this.instanceType = cls2;
        this.instanceTypeHash = Fnv.hashCode64(TypeUtils.getTypeName(cls2));
        this.itemType = type2;
        Class<?> cls3 = TypeUtils.getClass(type2);
        this.itemClass = cls3;
        this.builder = function;
        String typeName = cls3 != null ? TypeUtils.getTypeName(cls3) : null;
        this.itemClassName = typeName;
        this.itemClassNameHash = typeName != null ? Fnv.hashCode64(typeName) : 0L;
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReader
    public Object createInstance(long j) {
        Class cls = this.instanceType;
        if (cls == ArrayList.class) {
            return JDKUtils.JVM_VERSION == 8 ? new ArrayList(10) : new ArrayList();
        }
        if (cls == LinkedList.class) {
            return new LinkedList();
        }
        if (cls == HashSet.class) {
            return new HashSet();
        }
        if (cls == LinkedHashSet.class) {
            return new LinkedHashSet();
        }
        if (cls == TreeSet.class) {
            return new TreeSet();
        }
        Object obj = this.listSingleton;
        if (obj != null) {
            return obj;
        }
        if (cls != null) {
            if (this.constructor == null && !BeanUtils.hasPublicDefaultConstructor(this.instanceType)) {
                this.constructor = BeanUtils.getDefaultConstructor(this.instanceType, false);
                this.constructor.setAccessible(true);
            }
            JSONException jSONException = null;
            if (!this.instanceError) {
                try {
                    if (this.constructor != null) {
                        return this.constructor.newInstance(null);
                    }
                    return this.instanceType.newInstance();
                } catch (IllegalAccessException | InstantiationException | RuntimeException
                        | InvocationTargetException unused) {
                    this.instanceError = true;
                    jSONException = new JSONException("create list error, type " + this.instanceType);
                }
            }
            if (this.instanceError && List.class.isAssignableFrom(this.instanceType.getSuperclass())) {
                try {
                    return this.instanceType.getSuperclass().newInstance();
                } catch (IllegalAccessException | InstantiationException unused2) {
                    this.instanceError = true;
                    jSONException = new JSONException("create list error, type " + this.instanceType);
                }
            }
            if (jSONException != null) {
                throw jSONException;
            }
        }
        return new ArrayList();
    }
}
