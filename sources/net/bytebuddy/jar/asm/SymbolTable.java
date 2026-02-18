package net.bytebuddy.jar.asm;

import com.android.dx.cf.attrib.AttBootstrapMethods;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class SymbolTable {
    private int bootstrapMethodCount;
    private ByteVector bootstrapMethods;
    private String className;
    final ClassWriter classWriter;
    private ByteVector constantPool;
    private int constantPoolCount;
    private Entry[] entries;
    private int entryCount;
    private int labelCount;
    private LabelEntry[] labelEntries;
    private LabelEntry[] labelTable;
    private int majorVersion;
    private final ClassReader sourceClassReader;
    private int typeCount;
    private Entry[] typeTable;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class LabelEntry {
        final int index;
        final Label label;
        LabelEntry next;

        public LabelEntry(int i, Label label) {
            this.index = i;
            this.label = label;
        }
    }

    public SymbolTable(ClassWriter classWriter) {
        this.classWriter = classWriter;
        this.sourceClassReader = null;
        this.entries = new Entry[256];
        this.constantPoolCount = 1;
        this.constantPool = new ByteVector();
    }

    private void add(Entry entry) {
        this.entryCount++;
        int i = entry.hashCode;
        Entry[] entryArr = this.entries;
        int length = i % entryArr.length;
        entry.next = entryArr[length];
        entryArr[length] = entry;
    }

    private Symbol addConstantDynamicOrInvokeDynamicReference(int i, String str, String str2, int i2) {
        int iHash = hash(i, str, str2, i2);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == i2 && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry;
            }
        }
        this.constantPool.put122(i, i2, addConstantNameAndType(str, str2));
        int i3 = this.constantPoolCount;
        this.constantPoolCount = i3 + 1;
        return put(new Entry(i3, i, null, str, str2, i2, iHash));
    }

    private Symbol addConstantIntegerOrFloat(int i, int i2) {
        int iHash = hash(i, i2);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == i2) {
                return entry;
            }
        }
        this.constantPool.putByte(i).putInt(i2);
        int i3 = this.constantPoolCount;
        this.constantPoolCount = i3 + 1;
        return put(new Entry(i3, i, i2, iHash));
    }

    private Symbol addConstantLongOrDouble(int i, long j) {
        int iHash = hash(i, j);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.data == j) {
                return entry;
            }
        }
        int i2 = this.constantPoolCount;
        this.constantPool.putByte(i).putLong(j);
        this.constantPoolCount += 2;
        return put(new Entry(i2, i, j, iHash));
    }

    private Entry addConstantMemberReference(int i, String str, String str2, String str3) {
        int iHash = hash(i, str, str2, str3);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        this.constantPool.put122(i, addConstantClass(str).index, addConstantNameAndType(str2, str3));
        int i2 = this.constantPoolCount;
        this.constantPoolCount = i2 + 1;
        return put(new Entry(i2, i, str, str2, str3, 0L, iHash));
    }

    private Symbol addConstantUtf8Reference(int i, String str) {
        int iHash = hash(i, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == i && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry;
            }
        }
        this.constantPool.put12(i, addConstantUtf8(str));
        int i2 = this.constantPoolCount;
        this.constantPoolCount = i2 + 1;
        return put(new Entry(i2, i, str, iHash));
    }

    private int addTypeInternal(Entry entry) {
        if (this.typeTable == null) {
            this.typeTable = new Entry[16];
        }
        int i = this.typeCount;
        Entry[] entryArr = this.typeTable;
        if (i == entryArr.length) {
            Entry[] entryArr2 = new Entry[entryArr.length * 2];
            System.arraycopy(entryArr, 0, entryArr2, 0, entryArr.length);
            this.typeTable = entryArr2;
        }
        Entry[] entryArr3 = this.typeTable;
        int i2 = this.typeCount;
        this.typeCount = i2 + 1;
        entryArr3[i2] = entry;
        return put(entry).index;
    }

    private void copyBootstrapMethods(ClassReader classReader, char[] cArr) {
        byte[] bArr = classReader.classFileBuffer;
        int firstAttributeOffset = classReader.getFirstAttributeOffset();
        for (int unsignedShort = classReader.readUnsignedShort(firstAttributeOffset - 2); unsignedShort > 0; unsignedShort--) {
            if (AttBootstrapMethods.ATTRIBUTE_NAME.equals(classReader.readUTF8(firstAttributeOffset, cArr))) {
                this.bootstrapMethodCount = classReader.readUnsignedShort(firstAttributeOffset + 6);
                break;
            }
            firstAttributeOffset += classReader.readInt(firstAttributeOffset + 2) + 6;
        }
        if (this.bootstrapMethodCount > 0) {
            int i = firstAttributeOffset + 8;
            int i2 = classReader.readInt(firstAttributeOffset + 2) - 2;
            ByteVector byteVector = new ByteVector(i2);
            this.bootstrapMethods = byteVector;
            byteVector.putByteArray(bArr, i, i2);
            int i3 = i;
            for (int i4 = 0; i4 < this.bootstrapMethodCount; i4++) {
                int i5 = i3 - i;
                int unsignedShort2 = classReader.readUnsignedShort(i3);
                int unsignedShort3 = classReader.readUnsignedShort(i3 + 2);
                i3 += 4;
                int iHashCode = classReader.readConst(unsignedShort2, cArr).hashCode();
                while (true) {
                    int i6 = unsignedShort3 - 1;
                    if (unsignedShort3 > 0) {
                        int unsignedShort4 = classReader.readUnsignedShort(i3);
                        i3 += 2;
                        iHashCode ^= classReader.readConst(unsignedShort4, cArr).hashCode();
                        unsignedShort3 = i6;
                    }
                }
                add(new Entry(i4, 64, i5, iHashCode & Integer.MAX_VALUE));
            }
        }
    }

    private Entry get(int i) {
        Entry[] entryArr = this.entries;
        return entryArr[i % entryArr.length];
    }

    private static int getConstantMethodHandleSymbolData(int i, boolean z) {
        return (i <= 4 || !z) ? i : i << 8;
    }

    private LabelEntry getOrAddLabelEntry(Label label) {
        if (this.labelEntries == null) {
            this.labelEntries = new LabelEntry[16];
            this.labelTable = new LabelEntry[16];
        }
        int iIdentityHashCode = System.identityHashCode(label);
        LabelEntry[] labelEntryArr = this.labelEntries;
        LabelEntry labelEntry = labelEntryArr[iIdentityHashCode % labelEntryArr.length];
        while (labelEntry != null && labelEntry.label != label) {
            labelEntry = labelEntry.next;
        }
        if (labelEntry != null) {
            return labelEntry;
        }
        int i = this.labelCount;
        LabelEntry[] labelEntryArr2 = this.labelEntries;
        if (i > (labelEntryArr2.length * 3) / 4) {
            int length = labelEntryArr2.length;
            int i2 = (length * 2) + 1;
            LabelEntry[] labelEntryArr3 = new LabelEntry[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                LabelEntry labelEntry2 = this.labelEntries[i3];
                while (labelEntry2 != null) {
                    int iIdentityHashCode2 = System.identityHashCode(labelEntry2.label) % i2;
                    LabelEntry labelEntry3 = labelEntry2.next;
                    labelEntry2.next = labelEntryArr3[iIdentityHashCode2];
                    labelEntryArr3[iIdentityHashCode2] = labelEntry2;
                    labelEntry2 = labelEntry3;
                }
            }
            this.labelEntries = labelEntryArr3;
        }
        int i4 = this.labelCount;
        LabelEntry[] labelEntryArr4 = this.labelTable;
        if (i4 == labelEntryArr4.length) {
            LabelEntry[] labelEntryArr5 = new LabelEntry[labelEntryArr4.length * 2];
            System.arraycopy(labelEntryArr4, 0, labelEntryArr5, 0, labelEntryArr4.length);
            this.labelTable = labelEntryArr5;
        }
        LabelEntry labelEntry4 = new LabelEntry(this.labelCount, label);
        LabelEntry[] labelEntryArr6 = this.labelEntries;
        int length2 = iIdentityHashCode % labelEntryArr6.length;
        labelEntry4.next = labelEntryArr6[length2];
        labelEntryArr6[length2] = labelEntry4;
        LabelEntry[] labelEntryArr7 = this.labelTable;
        int i5 = this.labelCount;
        this.labelCount = i5 + 1;
        labelEntryArr7[i5] = labelEntry4;
        return labelEntry4;
    }

    private static int hash(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    private Entry put(Entry entry) {
        int i = this.entryCount;
        Entry[] entryArr = this.entries;
        if (i > (entryArr.length * 3) / 4) {
            int length = entryArr.length;
            int i2 = (length * 2) + 1;
            Entry[] entryArr2 = new Entry[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                Entry entry2 = this.entries[i3];
                while (entry2 != null) {
                    int i4 = entry2.hashCode % i2;
                    Entry entry3 = entry2.next;
                    entry2.next = entryArr2[i4];
                    entryArr2[i4] = entry2;
                    entry2 = entry3;
                }
            }
            this.entries = entryArr2;
        }
        this.entryCount++;
        int i5 = entry.hashCode;
        Entry[] entryArr3 = this.entries;
        int length2 = i5 % entryArr3.length;
        entry.next = entryArr3[length2];
        entryArr3[length2] = entry;
        return entry;
    }

    private static /* synthetic */ String stringConcat$0(String str) {
        return yg.k("value ", str);
    }

    public Symbol addBootstrapMethod(Handle handle, Object... objArr) {
        ByteVector byteVector = this.bootstrapMethods;
        if (byteVector == null) {
            byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
        }
        int length = objArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = addConstant(objArr[i]).index;
        }
        int i2 = byteVector.length;
        byteVector.putShort(addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface()).index);
        byteVector.putShort(length);
        for (int i3 = 0; i3 < length; i3++) {
            byteVector.putShort(iArr[i3]);
        }
        int i4 = byteVector.length - i2;
        int iHashCode = handle.hashCode();
        for (Object obj : objArr) {
            iHashCode ^= obj.hashCode();
        }
        return addBootstrapMethod(i2, i4, iHashCode & Integer.MAX_VALUE);
    }

    public Symbol addConstant(Object obj) {
        if (obj instanceof Integer) {
            return addConstantInteger(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return addConstantInteger(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return addConstantInteger(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return addConstantInteger(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return addConstantInteger(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return addConstantFloat(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return addConstantLong(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return addConstantDouble(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return addConstantString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            int sort = type.getSort();
            return sort == 10 ? addConstantClass(type.getInternalName()) : sort == 11 ? addConstantMethodType(type.getDescriptor()) : addConstantClass(type.getDescriptor());
        }
        if (obj instanceof Handle) {
            Handle handle = (Handle) obj;
            return addConstantMethodHandle(handle.getTag(), handle.getOwner(), handle.getName(), handle.getDesc(), handle.isInterface());
        }
        if (!(obj instanceof ConstantDynamic)) {
            throw new IllegalArgumentException(stringConcat$0(String.valueOf(obj)));
        }
        ConstantDynamic constantDynamic = (ConstantDynamic) obj;
        return addConstantDynamic(constantDynamic.getName(), constantDynamic.getDescriptor(), constantDynamic.getBootstrapMethod(), constantDynamic.getBootstrapMethodArgumentsUnsafe());
    }

    public Symbol addConstantClass(String str) {
        return addConstantUtf8Reference(7, str);
    }

    public Symbol addConstantDouble(double d) {
        return addConstantLongOrDouble(6, Double.doubleToRawLongBits(d));
    }

    public Symbol addConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(17, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    public Symbol addConstantFieldref(String str, String str2, String str3) {
        return addConstantMemberReference(9, str, str2, str3);
    }

    public Symbol addConstantFloat(float f) {
        return addConstantIntegerOrFloat(4, Float.floatToRawIntBits(f));
    }

    public Symbol addConstantInteger(int i) {
        return addConstantIntegerOrFloat(3, i);
    }

    public Symbol addConstantInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return addConstantDynamicOrInvokeDynamicReference(18, str, str2, addBootstrapMethod(handle, objArr).index);
    }

    public Symbol addConstantLong(long j) {
        return addConstantLongOrDouble(5, j);
    }

    public Symbol addConstantMethodHandle(int i, String str, String str2, String str3, boolean z) {
        int constantMethodHandleSymbolData = getConstantMethodHandleSymbolData(i, z);
        int iHash = hash(15, str, str2, str3, constantMethodHandleSymbolData);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 15 && entry.hashCode == iHash && entry.data == constantMethodHandleSymbolData && entry.owner.equals(str) && entry.name.equals(str2) && entry.value.equals(str3)) {
                return entry;
            }
        }
        if (i <= 4) {
            this.constantPool.put112(15, i, addConstantFieldref(str, str2, str3).index);
        } else {
            this.constantPool.put112(15, i, addConstantMethodref(str, str2, str3, z).index);
        }
        int i2 = this.constantPoolCount;
        this.constantPoolCount = i2 + 1;
        return put(new Entry(i2, 15, str, str2, str3, constantMethodHandleSymbolData, iHash));
    }

    public Symbol addConstantMethodType(String str) {
        return addConstantUtf8Reference(16, str);
    }

    public Symbol addConstantMethodref(String str, String str2, String str3, boolean z) {
        return addConstantMemberReference(z ? 11 : 10, str, str2, str3);
    }

    public Symbol addConstantModule(String str) {
        return addConstantUtf8Reference(19, str);
    }

    public int addConstantNameAndType(String str, String str2) {
        int iHash = hash(12, str, str2);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 12 && entry.hashCode == iHash && entry.name.equals(str) && entry.value.equals(str2)) {
                return entry.index;
            }
        }
        this.constantPool.put122(12, addConstantUtf8(str), addConstantUtf8(str2));
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 12, str, str2, iHash)).index;
    }

    public Symbol addConstantPackage(String str) {
        return addConstantUtf8Reference(20, str);
    }

    public Symbol addConstantString(String str) {
        return addConstantUtf8Reference(8, str);
    }

    public int addConstantUtf8(String str) {
        int iHash = hash(1, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 1 && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        this.constantPool.putByte(1).putUTF8(str);
        int i = this.constantPoolCount;
        this.constantPoolCount = i + 1;
        return put(new Entry(i, 1, str, iHash)).index;
    }

    public int addForwardUninitializedType(String str, Label label) {
        int i = getOrAddLabelEntry(label).index;
        int iHash = hash(130, str, i);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 130 && entry.hashCode == iHash && entry.data == i && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 130, str, i, iHash));
    }

    public int addMergedType(int i, int i2) {
        long j;
        long j2;
        if (i < i2) {
            j = i;
            j2 = i2;
        } else {
            j = i2;
            j2 = i;
        }
        long j3 = j | (j2 << 32);
        int iHash = hash(131, i + i2);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 131 && entry.hashCode == iHash && entry.data == j3) {
                return entry.info;
            }
        }
        Entry[] entryArr = this.typeTable;
        int iAddType = addType(this.classWriter.getCommonSuperClass(entryArr[i].value, entryArr[i2].value));
        put(new Entry(this.typeCount, 131, j3, iHash)).info = iAddType;
        return iAddType;
    }

    public int addType(String str) {
        int iHash = hash(128, str);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 128 && entry.hashCode == iHash && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 128, str, iHash));
    }

    public int addUninitializedType(String str, int i) {
        int iHash = hash(129, str, i);
        for (Entry entry = get(iHash); entry != null; entry = entry.next) {
            if (entry.tag == 129 && entry.hashCode == iHash && entry.data == i && entry.value.equals(str)) {
                return entry.index;
            }
        }
        return addTypeInternal(new Entry(this.typeCount, 129, str, i, iHash));
    }

    public int computeBootstrapMethodsSize() {
        if (this.bootstrapMethods == null) {
            return 0;
        }
        addConstantUtf8(AttBootstrapMethods.ATTRIBUTE_NAME);
        return this.bootstrapMethods.length + 8;
    }

    public String getClassName() {
        return this.className;
    }

    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }

    public int getConstantPoolLength() {
        return this.constantPool.length;
    }

    public Label getForwardUninitializedLabel(int i) {
        return this.labelTable[(int) this.typeTable[i].data].label;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public ClassReader getSource() {
        return this.sourceClassReader;
    }

    public Symbol getType(int i) {
        return this.typeTable[i];
    }

    public void putBootstrapMethods(ByteVector byteVector) {
        if (this.bootstrapMethods != null) {
            ByteVector byteVectorPutShort = byteVector.putShort(addConstantUtf8(AttBootstrapMethods.ATTRIBUTE_NAME)).putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodCount);
            ByteVector byteVector2 = this.bootstrapMethods;
            byteVectorPutShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        }
    }

    public void putConstantPool(ByteVector byteVector) {
        ByteVector byteVectorPutShort = byteVector.putShort(this.constantPoolCount);
        ByteVector byteVector2 = this.constantPool;
        byteVectorPutShort.putByteArray(byteVector2.data, 0, byteVector2.length);
    }

    public int setMajorVersionAndClassName(int i, String str) {
        this.majorVersion = i;
        this.className = str;
        return addConstantClass(str).index;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Entry extends Symbol {
        final int hashCode;
        Entry next;

        public Entry(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.hashCode = i3;
        }

        public Entry(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.hashCode = i3;
        }

        public Entry(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.hashCode = i3;
        }

        public Entry(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.hashCode = i3;
        }

        public Entry(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.hashCode = i3;
        }
    }

    private static int hash(int i, long j) {
        return (i + ((int) j) + ((int) (j >>> 32))) & Integer.MAX_VALUE;
    }

    private static int hash(int i, String str) {
        return Integer.MAX_VALUE & (str.hashCode() + i);
    }

    private static int hash(int i, String str, int i2) {
        return Integer.MAX_VALUE & (str.hashCode() + i + i2);
    }

    private static int hash(int i, String str, String str2) {
        return Integer.MAX_VALUE & ((str2.hashCode() * str.hashCode()) + i);
    }

    private static int hash(int i, String str, String str2, int i2) {
        return Integer.MAX_VALUE & (((i2 + 1) * str2.hashCode() * str.hashCode()) + i);
    }

    /* JADX WARN: Found duplicated region for block: B:25:0x010e  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0114  */
    public SymbolTable(ClassWriter classWriter, ClassReader classReader) {
        byte b;
        int i;
        SymbolTable symbolTable;
        this.classWriter = classWriter;
        this.sourceClassReader = classReader;
        byte[] bArr = classReader.classFileBuffer;
        int item = classReader.getItem(1) - 1;
        int i2 = classReader.header - item;
        this.constantPoolCount = classReader.getItemCount();
        ByteVector byteVector = new ByteVector(i2);
        this.constantPool = byteVector;
        byteVector.putByteArray(bArr, item, i2);
        this.entries = new Entry[this.constantPoolCount * 2];
        char[] cArr = new char[classReader.getMaxStringLength()];
        int i3 = 1;
        boolean z = false;
        while (i3 < this.constantPoolCount) {
            int item2 = classReader.getItem(i3);
            byte b2 = bArr[item2 - 1];
            switch (b2) {
                case 1:
                    b = b2;
                    i = i3;
                    addConstantUtf8(i, classReader.readUtf(i, cArr));
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                    b = b2;
                    i = i3;
                    addConstantIntegerOrFloat(i, b, classReader.readInt(item2));
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 5:
                case 6:
                    b = b2;
                    i = i3;
                    addConstantLongOrDouble(i, b, classReader.readLong(item2));
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    b = b2;
                    i = i3;
                    addConstantUtf8Reference(i, b, classReader.readUTF8(item2, cArr));
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 9:
                case 10:
                case 11:
                    b = b2;
                    int item3 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    symbolTable = this;
                    i3 = i3;
                    symbolTable.addConstantMemberReference(i3, b, classReader.readClass(item2, cArr), classReader.readUTF8(item3, cArr), classReader.readUTF8(item3 + 2, cArr));
                    i = i3;
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 12:
                    b = b2;
                    i = i3;
                    addConstantNameAndType(i, classReader.readUTF8(item2, cArr), classReader.readUTF8(item2 + 2, cArr));
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 15:
                    b = b2;
                    int item4 = classReader.getItem(classReader.readUnsignedShort(item2 + 1));
                    int item5 = classReader.getItem(classReader.readUnsignedShort(item4 + 2));
                    int i4 = classReader.readByte(item2);
                    symbolTable = this;
                    symbolTable.addConstantMethodHandle(i3, i4, classReader.readClass(item4, cArr), classReader.readUTF8(item5, cArr), classReader.readUTF8(item5 + 2, cArr), classReader.readByte(item4 - 1) == 11);
                    i = i3;
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
                case 17:
                case 18:
                    int item6 = classReader.getItem(classReader.readUnsignedShort(item2 + 2));
                    i = i3;
                    addConstantDynamicOrInvokeDynamicReference(b2, i, classReader.readUTF8(item6, cArr), classReader.readUTF8(item6 + 2, cArr), classReader.readUnsignedShort(item2));
                    z = true;
                    b = b2;
                    i3 = ((b != 5 || b == 6) ? 2 : 1) + i;
                    break;
            }
        }
        if (z) {
            copyBootstrapMethods(classReader, cArr);
        }
    }

    private void addConstantIntegerOrFloat(int i, int i2, int i3) {
        add(new Entry(i, i2, i3, hash(i2, i3)));
    }

    private void addConstantUtf8Reference(int i, int i2, String str) {
        add(new Entry(i, i2, str, hash(i2, str)));
    }

    private static int hash(int i, String str, String str2, String str3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i);
    }

    private static int hash(int i, String str, String str2, String str3, int i2) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode() * i2) + i);
    }

    private void addConstantDynamicOrInvokeDynamicReference(int i, int i2, String str, String str2, int i3) {
        add(new Entry(i2, i, null, str, str2, i3, hash(i, str, str2, i3)));
    }

    private void addConstantLongOrDouble(int i, int i2, long j) {
        add(new Entry(i, i2, j, hash(i2, j)));
    }

    private void addConstantUtf8(int i, String str) {
        add(new Entry(i, 1, str, hash(1, str)));
    }

    private void addConstantNameAndType(int i, String str, String str2) {
        add(new Entry(i, 12, str, str2, hash(12, str, str2)));
    }

    private void addConstantMemberReference(int i, int i2, String str, String str2, String str3) {
        add(new Entry(i, i2, str, str2, str3, 0L, hash(i2, str, str2, str3)));
    }

    private void addConstantMethodHandle(int i, int i2, String str, String str2, String str3, boolean z) {
        int constantMethodHandleSymbolData = getConstantMethodHandleSymbolData(i2, z);
        add(new Entry(i, 15, str, str2, str3, constantMethodHandleSymbolData, hash(15, str, str2, str3, constantMethodHandleSymbolData)));
    }

    private Symbol addBootstrapMethod(int i, int i2, int i3) {
        byte[] bArr = this.bootstrapMethods.data;
        for (Entry entry = get(i3); entry != null; entry = entry.next) {
            if (entry.tag == 64 && entry.hashCode == i3) {
                int i4 = (int) entry.data;
                int i5 = 0;
                while (true) {
                    if (i5 < i2) {
                        if (bArr[i + i5] != bArr[i4 + i5]) {
                            break;
                        }
                        i5++;
                    } else {
                        this.bootstrapMethods.length = i;
                        return entry;
                    }
                }
            }
        }
        int i6 = this.bootstrapMethodCount;
        this.bootstrapMethodCount = i6 + 1;
        return put(new Entry(i6, 64, i, i3));
    }
}
