package bsh.org.objectweb.asm;

import bsh.org.objectweb.asm.Attribute;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceDebugExtension;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_FRAMES = 2;
    public static final int COMPUTE_MAXS = 1;
    private int accessFlags;
    private int compute;
    private ByteVector debugExtension;
    private int enclosingClassIndex;
    private int enclosingMethodIndex;
    private Attribute firstAttribute;
    private FieldWriter firstField;
    private MethodWriter firstMethod;
    private ByteVector innerClasses;
    private int interfaceCount;
    private int[] interfaces;
    private FieldWriter lastField;
    private MethodWriter lastMethod;
    private int numberOfInnerClasses;
    private int signatureIndex;
    private int sourceFileIndex;
    private int superClass;
    private final SymbolTable symbolTable;
    private int thisClass;
    private int version;

    public ClassWriter(int i) {
        super(393216);
        this.symbolTable = new SymbolTable(this);
        if ((i & 2) != 0) {
            this.compute = 4;
        } else if ((i & 1) != 0) {
            this.compute = 1;
        } else {
            this.compute = 0;
        }
    }

    private Attribute[] getAttributePrototypes() {
        Attribute.Set set = new Attribute.Set();
        set.addAttributes(this.firstAttribute);
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.fv) {
            fieldWriter.collectAttributePrototypes(set);
        }
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.mv) {
            methodWriter.collectAttributePrototypes(set);
        }
        return set.toArray();
    }

    private byte[] replaceAsmInstructions(byte[] bArr, boolean z) {
        getAttributePrototypes();
        this.firstField = null;
        this.lastField = null;
        this.firstMethod = null;
        this.lastMethod = null;
        this.firstAttribute = null;
        this.compute = z ? 3 : 0;
        return toByteArray();
    }

    public String getCommonSuperClass(String str, String str2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> cls = Class.forName(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), false, classLoader);
            try {
                Class<?> cls2 = Class.forName(str2.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH), false, classLoader);
                if (cls.isAssignableFrom(cls2)) {
                    return str;
                }
                if (cls2.isAssignableFrom(cls)) {
                    return str2;
                }
                if (cls.isInterface() || cls2.isInterface()) {
                    return "java/lang/Object";
                }
                do {
                    cls = cls.getSuperclass();
                } while (!cls.isAssignableFrom(cls2));
                return cls.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
            } catch (Exception e) {
                throw new TypeNotPresentException(str2, e);
            }
        } catch (Exception e2) {
            throw new TypeNotPresentException(str, e2);
        }
    }

    public int newClass(String str) {
        return this.symbolTable.addConstantClass(str).index;
    }

    public int newConst(Object obj) {
        return this.symbolTable.addConstant(obj).index;
    }

    public int newField(String str, String str2, String str3) {
        return this.symbolTable.addConstantFieldref(str, str2, str3).index;
    }

    @Deprecated
    public int newHandle(int i, String str, String str2, String str3) {
        return newHandle(i, str, str2, str3, i == 9);
    }

    public int newInvokeDynamic(String str, String str2, Handle handle, Object... objArr) {
        return this.symbolTable.addConstantInvokeDynamic(str, str2, handle, objArr).index;
    }

    public int newMethod(String str, String str2, String str3, boolean z) {
        return this.symbolTable.addConstantMethodref(str, str2, str3, z).index;
    }

    public int newMethodType(String str) {
        return this.symbolTable.addConstantMethodType(str).index;
    }

    public int newModule(String str) {
        return this.symbolTable.addConstantModule(str).index;
    }

    public int newNameType(String str, String str2) {
        return this.symbolTable.addConstantNameAndType(str, str2);
    }

    public int newPackage(String str) {
        return this.symbolTable.addConstantPackage(str).index;
    }

    public int newUTF8(String str) {
        return this.symbolTable.addConstantUtf8(str);
    }

    public byte[] toByteArray() {
        int attributeCount;
        int i;
        int i2;
        int iComputeAttributesSize = (this.interfaceCount * 2) + 24;
        int i3 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = (FieldWriter) fieldWriter.fv) {
            i3++;
            iComputeAttributesSize += fieldWriter.computeFieldInfoSize();
        }
        int i4 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = (MethodWriter) methodWriter.mv) {
            i4++;
            iComputeAttributesSize += methodWriter.computeMethodInfoSize();
        }
        ByteVector byteVector = this.innerClasses;
        if (byteVector != null) {
            iComputeAttributesSize += byteVector.length + 8;
            this.symbolTable.addConstantUtf8(AttInnerClasses.ATTRIBUTE_NAME);
            attributeCount = 1;
        } else {
            attributeCount = 0;
        }
        if (this.enclosingClassIndex != 0) {
            attributeCount++;
            iComputeAttributesSize += 10;
            this.symbolTable.addConstantUtf8(AttEnclosingMethod.ATTRIBUTE_NAME);
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            attributeCount++;
            iComputeAttributesSize += 6;
            this.symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME);
        }
        if (this.signatureIndex != 0) {
            attributeCount++;
            iComputeAttributesSize += 8;
            this.symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME);
        }
        if (this.sourceFileIndex != 0) {
            attributeCount++;
            iComputeAttributesSize += 8;
            this.symbolTable.addConstantUtf8(AttSourceFile.ATTRIBUTE_NAME);
        }
        ByteVector byteVector2 = this.debugExtension;
        if (byteVector2 != null) {
            attributeCount++;
            iComputeAttributesSize += byteVector2.length + 6;
            this.symbolTable.addConstantUtf8(AttSourceDebugExtension.ATTRIBUTE_NAME);
        }
        if ((this.accessFlags & 131072) != 0) {
            attributeCount++;
            iComputeAttributesSize += 6;
            this.symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME);
        }
        if (this.symbolTable.computeBootstrapMethodsSize() > 0) {
            attributeCount++;
            iComputeAttributesSize += this.symbolTable.computeBootstrapMethodsSize();
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            attributeCount += attribute.getAttributeCount();
            iComputeAttributesSize += this.firstAttribute.computeAttributesSize(this.symbolTable);
        }
        int constantPoolLength = iComputeAttributesSize + this.symbolTable.getConstantPoolLength();
        if (this.symbolTable.getConstantPoolCount() > 65535) {
            throw new IndexOutOfBoundsException("Class file too large!");
        }
        ByteVector byteVector3 = new ByteVector(constantPoolLength);
        byteVector3.putInt(-889275714).putInt(this.version);
        this.symbolTable.putConstantPool(byteVector3);
        byteVector3.putShort((~((this.version & 65535) < 49 ? 4096 : 0)) & this.accessFlags).putShort(this.thisClass).putShort(this.superClass);
        byteVector3.putShort(this.interfaceCount);
        for (int i5 = 0; i5 < this.interfaceCount; i5++) {
            byteVector3.putShort(this.interfaces[i5]);
        }
        byteVector3.putShort(i3);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = (FieldWriter) fieldWriter2.fv) {
            fieldWriter2.putFieldInfo(byteVector3);
        }
        byteVector3.putShort(i4);
        boolean zHasFrames = false;
        boolean zHasAsmInstructions = false;
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = (MethodWriter) methodWriter2.mv) {
            zHasFrames |= methodWriter2.hasFrames();
            zHasAsmInstructions |= methodWriter2.hasAsmInstructions();
            methodWriter2.putMethodInfo(byteVector3);
        }
        byteVector3.putShort(attributeCount);
        if (this.innerClasses != null) {
            ByteVector byteVectorPutShort = byteVector3.putShort(this.symbolTable.addConstantUtf8(AttInnerClasses.ATTRIBUTE_NAME)).putInt(this.innerClasses.length + 2).putShort(this.numberOfInnerClasses);
            ByteVector byteVector4 = this.innerClasses;
            byteVectorPutShort.putByteArray(byteVector4.data, 0, byteVector4.length);
        }
        if (this.enclosingClassIndex != 0) {
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttEnclosingMethod.ATTRIBUTE_NAME)).putInt(4).putShort(this.enclosingClassIndex).putShort(this.enclosingMethodIndex);
        }
        if ((this.accessFlags & 4096) != 0 && (this.version & 65535) < 49) {
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME)).putInt(0);
        }
        if (this.signatureIndex != 0) {
            i = 2;
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME)).putInt(2).putShort(this.signatureIndex);
        } else {
            i = 2;
        }
        if (this.sourceFileIndex != 0) {
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttSourceFile.ATTRIBUTE_NAME)).putInt(i).putShort(this.sourceFileIndex);
        }
        ByteVector byteVector5 = this.debugExtension;
        if (byteVector5 != null) {
            int i6 = byteVector5.length;
            i2 = 0;
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttSourceDebugExtension.ATTRIBUTE_NAME)).putInt(i6).putByteArray(this.debugExtension.data, 0, i6);
        } else {
            i2 = 0;
        }
        if ((this.accessFlags & 131072) != 0) {
            byteVector3.putShort(this.symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME)).putInt(i2);
        }
        this.symbolTable.putBootstrapMethods(byteVector3);
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            attribute2.putAttributes(this.symbolTable, byteVector3);
        }
        return zHasAsmInstructions ? replaceAsmInstructions(byteVector3.data, zHasFrames) : byteVector3.data;
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visit(int i, int i2, String str, String str2, String str3, String[] strArr) {
        this.version = i;
        this.accessFlags = i2;
        int i3 = i & 65535;
        this.thisClass = this.symbolTable.setMajorVersionAndClassName(i3, str);
        if (str2 != null) {
            this.signatureIndex = this.symbolTable.addConstantUtf8(str2);
        }
        this.superClass = str3 == null ? 0 : this.symbolTable.addConstantClass(str3).index;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            this.interfaceCount = length;
            this.interfaces = new int[length];
            for (int i4 = 0; i4 < this.interfaceCount; i4++) {
                this.interfaces[i4] = this.symbolTable.addConstantClass(strArr[i4]).index;
            }
        }
        if (this.compute != 1 || i3 < 51) {
            return;
        }
        this.compute = 2;
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visitEnd() {
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final FieldVisitor visitField(int i, String str, String str2, String str3, Object obj) {
        FieldWriter fieldWriter = new FieldWriter(this.symbolTable, i, str, str2, str3, obj);
        if (this.firstField == null) {
            this.firstField = fieldWriter;
        } else {
            this.lastField.fv = fieldWriter;
        }
        this.lastField = fieldWriter;
        return fieldWriter;
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visitInnerClass(String str, String str2, String str3, int i) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Symbol symbolAddConstantClass = this.symbolTable.addConstantClass(str);
        if (symbolAddConstantClass.info == 0) {
            this.numberOfInnerClasses++;
            this.innerClasses.putShort(symbolAddConstantClass.index);
            this.innerClasses.putShort(str2 == null ? 0 : this.symbolTable.addConstantClass(str2).index);
            this.innerClasses.putShort(str3 != null ? this.symbolTable.addConstantUtf8(str3) : 0);
            this.innerClasses.putShort(i);
            symbolAddConstantClass.info = this.numberOfInnerClasses;
        }
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr) {
        MethodWriter methodWriter = new MethodWriter(this.symbolTable, i, str, str2, str3, strArr, this.compute);
        if (this.firstMethod == null) {
            this.firstMethod = methodWriter;
        } else {
            this.lastMethod.mv = methodWriter;
        }
        this.lastMethod = methodWriter;
        return methodWriter;
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visitOuterClass(String str, String str2, String str3) {
        this.enclosingClassIndex = this.symbolTable.addConstantClass(str).index;
        if (str2 == null || str3 == null) {
            return;
        }
        this.enclosingMethodIndex = this.symbolTable.addConstantNameAndType(str2, str3);
    }

    @Override // bsh.org.objectweb.asm.ClassVisitor
    public final void visitSource(String str, String str2) {
        if (str != null) {
            this.sourceFileIndex = this.symbolTable.addConstantUtf8(str);
        }
        if (str2 != null) {
            this.debugExtension = new ByteVector().encodeUTF8(str2, 0, Integer.MAX_VALUE);
        }
    }

    public int newHandle(int i, String str, String str2, String str3, boolean z) {
        return this.symbolTable.addConstantMethodHandle(i, str, str2, str3, z).index;
    }
}
