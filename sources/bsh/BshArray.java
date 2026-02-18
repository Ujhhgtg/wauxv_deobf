package bsh;

import bsh.BshArray;
import bsh.Types;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.function.IntSupplier;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshArray {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class SteppedSubList extends AbstractList<Object> implements RandomAccess {
        private final List<Object> parent;
        private final List<Integer> steps;

        public SteppedSubList(List<Object> list, List<Integer> list2) {
            this.parent = list;
            this.steps = list2;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            int iIntValue = i == size() ? this.steps.get(i - 1).intValue() + 1 : this.steps.get(i).intValue();
            this.parent.add(iIntValue, obj);
            for (int i2 = i; i2 < size(); i2++) {
                List<Integer> list = this.steps;
                list.set(i2, Integer.valueOf(list.get(i2).intValue() + 1));
            }
            this.steps.add(i, Integer.valueOf(iIntValue));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends Object> collection) {
            return addAll(this.steps.size(), collection);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            return this.parent.get(this.steps.get(i).intValue());
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<Object> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<Object> listIterator(int i) {
            final ListIterator listIterator = new ArrayList(this.steps).listIterator(i);
            return new ListIterator<Object>() { // from class: bsh.BshArray.SteppedSubList.1
                int lastIndex = 0;

                @Override // java.util.ListIterator
                public void add(Object obj) {
                    SteppedSubList.this.add(this.lastIndex, obj);
                    listIterator.add((Integer) SteppedSubList.this.steps.get(this.lastIndex));
                    this.lastIndex = -1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public Object next() {
                    listIterator.next();
                    int iPreviousIndex = previousIndex();
                    this.lastIndex = iPreviousIndex;
                    return SteppedSubList.this.get(iPreviousIndex);
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return listIterator.nextIndex();
                }

                @Override // java.util.ListIterator
                public Object previous() {
                    listIterator.previous();
                    int iNextIndex = nextIndex();
                    this.lastIndex = iNextIndex;
                    return SteppedSubList.this.get(iNextIndex);
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return listIterator.previousIndex();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    SteppedSubList.this.remove(this.lastIndex);
                    listIterator.remove();
                    this.lastIndex = -1;
                }

                @Override // java.util.ListIterator
                public void set(Object obj) {
                    SteppedSubList.this.set(this.lastIndex, obj);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            int iIntValue = this.steps.get(i).intValue();
            for (int i2 = i + 1; i2 < size(); i2++) {
                this.steps.set(i2, Integer.valueOf(r2.get(i2).intValue() - 1));
            }
            this.steps.remove(i);
            return this.parent.remove(iIntValue);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            return this.parent.set(this.steps.get(i).intValue(), obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.steps.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Object> subList(int i, int i2) {
            return new SteppedSubList(this.parent, this.steps.subList(i, i2));
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends Object> collection) {
            Iterator<? extends Object> it = collection.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                add(i2 + i, it.next());
                i2++;
            }
            return i2 > 0;
        }
    }

    private BshArray() {
    }

    public static Object castArray(Class<?> cls, Class<?> cls2, Object obj) {
        int i = 0;
        if (Collection.class.isAssignableFrom(cls)) {
            if (List.class.isAssignableFrom(cls) || Queue.class == cls) {
                if (cls.isAssignableFrom(ArrayList.class)) {
                    return new ArrayList(Arrays.asList((Object[]) Types.castObject(obj, Object.class, 0)));
                }
                if (cls.isAssignableFrom(LinkedList.class)) {
                    return new LinkedList(Arrays.asList((Object[]) Types.castObject(obj, Object.class, 0)));
                }
            } else {
                if (cls.isAssignableFrom(ArrayDeque.class)) {
                    return new ArrayDeque(Arrays.asList((Object[]) Types.castObject(obj, Object.class, 0)));
                }
                if (cls.isAssignableFrom(LinkedHashSet.class)) {
                    return new LinkedHashSet(Arrays.asList((Object[]) Types.castObject(obj, Object.class, 0)));
                }
            }
        }
        Class<?> clsArrayElementType = Types.arrayElementType(cls2);
        if (Map.class.isAssignableFrom(cls)) {
            if (Map.Entry.class.isAssignableFrom(clsArrayElementType)) {
                return mapOfEntries((Map.Entry[]) obj);
            }
            if (cls.isAssignableFrom(LinkedHashMap.class)) {
                int length = Array.getLength(obj);
                LinkedHashMap linkedHashMap = new LinkedHashMap((int) Math.ceil((((double) length) + 0.0d) / 2.0d));
                while (i < length) {
                    int i2 = i + 1;
                    linkedHashMap.put(Array.get(obj, i), i2 < length ? Array.get(obj, i2) : null);
                    i += 2;
                }
                return linkedHashMap;
            }
        }
        int[] iArrDimensions = dimensions(obj);
        final int i3 = iArrDimensions[0];
        if (i3 == 0) {
            return Array.newInstance(cls, iArrDimensions);
        }
        Class<?> clsCommonType = commonType(clsArrayElementType, obj, new IntSupplier() { // from class: me.hd.wauxv.obf.qz
            @Override // java.util.function.IntSupplier
            public final int getAsInt() {
                return BshArray.lambda$castArray$0(i3);
            }
        });
        if (!Map.Entry.class.isAssignableFrom(cls)) {
            Class<?> clsArrayElementType2 = Types.arrayElementType(cls);
            Object objNewInstance = Array.newInstance(clsArrayElementType2, iArrDimensions);
            copy(clsArrayElementType2, objNewInstance, obj);
            return objNewInstance;
        }
        if (Map.Entry.class.isAssignableFrom(clsCommonType)) {
            if (Types.MapEntry.class != clsCommonType) {
                return obj;
            }
            Map.Entry[] entryArr = new Map.Entry[Array.getLength(obj)];
            copy(Map.Entry.class, entryArr, obj);
            return entryArr;
        }
        if (i3 == 1) {
            return new Types.MapEntry(Array.get(obj, 0), null);
        }
        if (i3 == 2) {
            return new Types.MapEntry(Array.get(obj, 0), Array.get(obj, 1));
        }
        Map.Entry[] entryArr2 = new Map.Entry[(int) Math.ceil((((double) i3) + 0.0d) / 2.0d)];
        int i4 = 0;
        while (i < i3) {
            int i5 = i4 + 1;
            int i6 = i + 1;
            entryArr2[i4] = new Types.MapEntry(Array.get(obj, i), i6 < i3 ? Array.get(obj, i6) : null);
            i += 2;
            i4 = i5;
        }
        return entryArr2;
    }

    public static Class<?> commonType(Class<?> cls, Object obj, IntSupplier intSupplier) {
        if (Object.class == cls) {
            int asInt = intSupplier.getAsInt();
            Class<?> commonType = null;
            for (int i = 0; i < asInt; i++) {
                commonType = Types.getCommonType(commonType, Types.getType(Array.get(obj, 0)));
                if (Object.class == commonType) {
                    break;
                }
            }
            if (commonType != null && commonType != cls) {
                return commonType;
            }
        }
        return cls;
    }

    public static Object concat(List<?> list, List<?> list2) {
        List linkedList = list instanceof Queue ? new LinkedList(list) : new ArrayList(list);
        linkedList.addAll(list2);
        return linkedList;
    }

    private static void copy(Class<?> cls, Object obj, Object... objArr) {
        int i;
        int i2;
        int length = Array.getLength(objArr[0]);
        int length2 = objArr.length > 1 ? Array.getLength(obj) : length;
        if (Types.arrayDimensions(obj.getClass()) != 1) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length2) {
                if (length < length2 && i4 == length && (i = i5 + 1) < objArr.length) {
                    length = Array.getLength(objArr[i]);
                    i4 = 0;
                    i5 = i;
                }
                int i6 = i4 + 1;
                Object obj2 = Array.get(objArr[i5], i4);
                if (obj2 == null) {
                    Array.set(obj, i3, null);
                } else {
                    Object objNewInstance = Array.get(obj, i3);
                    if (Array.getLength(obj2) != Array.getLength(objNewInstance)) {
                        objNewInstance = Array.newInstance(cls, dimensions(obj2));
                        Array.set(obj, i3, objNewInstance);
                    }
                    copy(cls, objNewInstance, obj2);
                }
                i3++;
                i4 = i6;
            }
            return;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length2; i9++) {
            int i10 = i8 + 1;
            Object objUnwrap = Array.get(objArr[i7], i8);
            try {
                objUnwrap = Primitive.unwrap(Types.castObject(objUnwrap, cls, 0));
            } catch (UtilEvalError unused) {
            }
            if (Byte.TYPE == cls) {
                Array.setByte(obj, i9, ((Byte) objUnwrap).byteValue());
            } else if (Short.TYPE == cls) {
                Array.setShort(obj, i9, ((Short) objUnwrap).shortValue());
            } else if (Integer.TYPE == cls) {
                Array.setInt(obj, i9, ((Integer) objUnwrap).intValue());
            } else if (Long.TYPE == cls) {
                Array.setLong(obj, i9, ((Long) objUnwrap).longValue());
            } else if (Float.TYPE == cls) {
                Array.setFloat(obj, i9, ((Float) objUnwrap).floatValue());
            } else if (Double.TYPE == cls) {
                Array.setDouble(obj, i9, ((Double) objUnwrap).doubleValue());
            } else if (Character.TYPE == cls) {
                Array.setChar(obj, i9, ((Character) objUnwrap).charValue());
            } else if (Boolean.TYPE == cls) {
                Array.setBoolean(obj, i9, ((Boolean) objUnwrap).booleanValue());
            } else {
                Array.set(obj, i9, objUnwrap);
            }
            if (length >= length2 || i10 != length || (i2 = i7 + 1) >= objArr.length) {
                i8 = i10;
            } else {
                length = Array.getLength(objArr[i2]);
                i7 = i2;
                i8 = 0;
            }
        }
    }

    public static int[] dimensions(Object obj) {
        int iArrayDimensions = Types.arrayDimensions(obj.getClass());
        int[] iArr = new int[iArrayDimensions];
        if (iArrayDimensions != 0) {
            int length = Array.getLength(obj);
            iArr[0] = length;
            if (length != 0) {
                for (int i = 1; i < iArrayDimensions; i++) {
                    obj = Array.get(obj, 0);
                    if (obj == null) {
                        break;
                    }
                    iArr[i] = Array.getLength(obj);
                }
            }
        }
        return iArr;
    }

    public static Object getIndex(Object obj, int i) throws UtilTargetError {
        Interpreter.debug("getIndex: ", obj, ", index=", Integer.valueOf(i));
        try {
            return obj instanceof List ? ((List) obj).get(i) : Primitive.wrap(Array.get(obj, i), Types.arrayElementType(obj.getClass()));
        } catch (IndexOutOfBoundsException e) {
            throw new UtilTargetError(dkz.p(i, "Index ", " out-of-bounds for length ", obj instanceof List ? ((List) obj).size() : Array.getLength(obj)), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$castArray$0(int i) {
        return i;
    }

    private static Map<?, ?> mapOfEntries(Map.Entry<?, ?>... entryArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(entryArr.length);
        for (Map.Entry<?, ?> entry : entryArr) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static Object repeat(List<Object> list, int i) {
        if (i < 1) {
            return list instanceof Queue ? new LinkedList() : new ArrayList(0);
        }
        List linkedList = list instanceof Queue ? new LinkedList(list) : new ArrayList(list);
        if (i != 1) {
            while (true) {
                int i2 = i - 1;
                if (i <= 1) {
                    break;
                }
                linkedList.addAll(list);
                i = i2;
            }
        }
        return linkedList;
    }

    public static void setIndex(Object obj, int i, Object obj2) throws UtilTargetError {
        try {
            Object objUnwrap = Primitive.unwrap(obj2);
            if (obj instanceof List) {
                ((List) obj).set(i, objUnwrap);
            } else {
                Array.set(obj, i, objUnwrap);
            }
        } catch (IllegalArgumentException e) {
            throw new UtilTargetError(new ArrayStoreException(e.getMessage()));
        } catch (IndexOutOfBoundsException e2) {
            throw new UtilTargetError(dkz.p(i, "Index ", " out-of-bounds for length ", obj instanceof List ? ((List) obj).size() : Array.getLength(obj)), e2);
        }
    }

    public static Object slice(List<Object> list, int i, int i2, int i3) {
        int size = list.size();
        if (i2 > size) {
            i2 = size;
        }
        if (i < 0) {
            i = 0;
        }
        int i4 = i2 - i;
        if (i4 <= 0) {
            return list.subList(0, 0);
        }
        if (i3 == 0 || i3 == 1) {
            return list.subList(i, i2);
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 % i3 == 0) {
                arrayList.add(Integer.valueOf(i3 < 0 ? (i4 - 1) - i5 : i5 + i));
            }
        }
        return new SteppedSubList(list, arrayList);
    }

    public static Object concat(Object obj, Object obj2) throws UtilEvalError {
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        if (Types.arrayDimensions(cls) == Types.arrayDimensions(cls2)) {
            Class<?> commonType = Types.getCommonType(Types.arrayElementType(cls), Types.arrayElementType(cls2));
            int[] iArrDimensions = dimensions(obj);
            iArrDimensions[0] = Array.getLength(obj2) + Array.getLength(obj);
            Object objNewInstance = Array.newInstance(commonType, iArrDimensions);
            copy(commonType, objNewInstance, obj, obj2);
            return objNewInstance;
        }
        throw new UtilEvalError("Cannot concat arrays with inconsistent dimensions. Attempting to concat array of type " + StringUtil.typeString(obj) + " with array of type " + StringUtil.typeString(obj2) + ".");
    }

    public static Object repeat(Object obj, int i) {
        Class<?> clsArrayElementType = Types.arrayElementType(obj.getClass());
        if (i < 1) {
            return Array.newInstance(clsArrayElementType, 0);
        }
        int[] iArrDimensions = dimensions(obj);
        int i2 = iArrDimensions[0];
        int i3 = i * i2;
        iArrDimensions[0] = i3;
        Object objNewInstance = Array.newInstance(clsArrayElementType, iArrDimensions);
        for (int i4 = 0; i4 < i3; i4 += i2) {
            System.arraycopy(obj, 0, objNewInstance, i4, i2);
        }
        return objNewInstance;
    }

    public static Object slice(Object obj, int i, int i2, int i3) {
        Class<?> clsArrayElementType = Types.arrayElementType(obj.getClass());
        int length = Array.getLength(obj);
        if (i2 > length) {
            i2 = length;
        }
        if (i < 0) {
            i = 0;
        }
        int i4 = i2 - i;
        if (i4 <= 0) {
            return Array.newInstance(clsArrayElementType, 0);
        }
        if (i3 != 0 && i3 != 1) {
            int iCeil = (int) Math.ceil((((double) i4) + 0.0d) / ((double) Math.abs(i3)));
            Object[] objArr = new Object[iCeil];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                if (i6 % i3 == 0) {
                    int i7 = i5 + 1;
                    objArr[i5] = Array.get(obj, i3 < 0 ? (i4 - 1) - i6 : i6 + i);
                    i5 = i7;
                }
            }
            Object objNewInstance = Array.newInstance(clsArrayElementType, iCeil);
            copy(clsArrayElementType, objNewInstance, objArr);
            return objNewInstance;
        }
        Object objNewInstance2 = Array.newInstance(clsArrayElementType, i4);
        System.arraycopy(obj, i, objNewInstance2, 0, i4);
        return objNewInstance2;
    }
}
