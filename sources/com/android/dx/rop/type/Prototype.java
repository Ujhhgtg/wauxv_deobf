package com.android.dx.rop.type;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Prototype implements Comparable<Prototype> {
    private static final ConcurrentMap<String, Prototype> internTable = new ConcurrentHashMap(10000, 0.75f);
    private final String descriptor;
    private StdTypeList parameterFrameTypes;
    private final StdTypeList parameterTypes;
    private final Type returnType;

    private Prototype(String str, Type type, StdTypeList stdTypeList) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        if (type == null) {
            throw new NullPointerException("returnType == null");
        }
        if (stdTypeList == null) {
            throw new NullPointerException("parameterTypes == null");
        }
        this.descriptor = str;
        this.returnType = type;
        this.parameterTypes = stdTypeList;
        this.parameterFrameTypes = null;
    }

    public static void clearInternTable() {
        internTable.clear();
    }

    public static Prototype fromDescriptor(String str) {
        int i;
        Prototype prototype = internTable.get(str);
        if (prototype != null) {
            return prototype;
        }
        Type[] typeArrMakeParameterArray = makeParameterArray(str);
        int i2 = 0;
        int i3 = 1;
        while (true) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == ')') {
                Type typeInternReturnType = Type.internReturnType(str.substring(i3 + 1));
                StdTypeList stdTypeList = new StdTypeList(i2);
                for (int i4 = 0; i4 < i2; i4++) {
                    stdTypeList.set(i4, typeArrMakeParameterArray[i4]);
                }
                return new Prototype(str, typeInternReturnType, stdTypeList);
            }
            int i5 = i3;
            while (cCharAt == '[') {
                i5++;
                cCharAt = str.charAt(i5);
            }
            if (cCharAt == 'L') {
                int iIndexOf = str.indexOf(59, i5);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("bad descriptor");
                }
                i = iIndexOf + 1;
            } else {
                i = i5 + 1;
            }
            typeArrMakeParameterArray[i2] = Type.intern(str.substring(i3, i));
            i2++;
            i3 = i;
        }
    }

    public static Prototype intern(String str) {
        if (str == null) {
            throw new NullPointerException("descriptor == null");
        }
        Prototype prototype = internTable.get(str);
        return prototype != null ? prototype : putIntern(fromDescriptor(str));
    }

    public static Prototype internInts(Type type, int i) {
        StringBuilder sb = new StringBuilder(100);
        sb.append('(');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('I');
        }
        sb.append(')');
        sb.append(type.getDescriptor());
        return intern(sb.toString());
    }

    private static Type[] makeParameterArray(String str) {
        int length = str.length();
        int i = 0;
        if (str.charAt(0) != '(') {
            throw new IllegalArgumentException("bad descriptor");
        }
        int i2 = 0;
        for (int i3 = 1; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == ')') {
                i = i3;
                break;
            }
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                i2++;
            }
        }
        if (i == 0 || i == length - 1) {
            throw new IllegalArgumentException("bad descriptor");
        }
        if (str.indexOf(41, i + 1) == -1) {
            return new Type[i2];
        }
        throw new IllegalArgumentException("bad descriptor");
    }

    private static Prototype putIntern(Prototype prototype) {
        Prototype prototypePutIfAbsent = internTable.putIfAbsent(prototype.getDescriptor(), prototype);
        return prototypePutIfAbsent != null ? prototypePutIfAbsent : prototype;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Prototype) {
            return this.descriptor.equals(((Prototype) obj).descriptor);
        }
        return false;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public StdTypeList getParameterFrameTypes() {
        if (this.parameterFrameTypes == null) {
            int size = this.parameterTypes.size();
            StdTypeList stdTypeList = new StdTypeList(size);
            boolean z = false;
            for (int i = 0; i < size; i++) {
                Type type = this.parameterTypes.get(i);
                if (type.isIntlike()) {
                    type = Type.INT;
                    z = true;
                }
                stdTypeList.set(i, type);
            }
            if (!z) {
                stdTypeList = this.parameterTypes;
            }
            this.parameterFrameTypes = stdTypeList;
        }
        return this.parameterFrameTypes;
    }

    public StdTypeList getParameterTypes() {
        return this.parameterTypes;
    }

    public Type getReturnType() {
        return this.returnType;
    }

    public int hashCode() {
        return this.descriptor.hashCode();
    }

    public String toString() {
        return this.descriptor;
    }

    public Prototype withFirstParameter(Type type) {
        String str = "(" + type.getDescriptor() + this.descriptor.substring(1);
        StdTypeList stdTypeListWithFirst = this.parameterTypes.withFirst(type);
        stdTypeListWithFirst.setImmutable();
        return putIntern(new Prototype(str, this.returnType, stdTypeListWithFirst));
    }

    @Override // java.lang.Comparable
    public int compareTo(Prototype prototype) {
        if (this == prototype) {
            return 0;
        }
        int iCompareTo2 = this.returnType.compareTo(prototype.returnType);
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        int size = this.parameterTypes.size();
        int size2 = prototype.parameterTypes.size();
        int iMin = Math.min(size, size2);
        for (int i = 0; i < iMin; i++) {
            int iCompareTo22 = this.parameterTypes.get(i).compareTo(prototype.parameterTypes.get(i));
            if (iCompareTo22 != 0) {
                return iCompareTo22;
            }
        }
        if (size < size2) {
            return -1;
        }
        return size > size2 ? 1 : 0;
    }

    public static Prototype intern(String str, Type type, boolean z, boolean z2) {
        Prototype prototypeIntern = intern(str);
        if (z) {
            return prototypeIntern;
        }
        if (z2) {
            type = type.asUninitialized(Integer.MAX_VALUE);
        }
        return prototypeIntern.withFirstParameter(type);
    }
}
