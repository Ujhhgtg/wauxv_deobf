package net.bytebuddy.jar.asm;

import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSynthetic;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Attribute {
    private ByteVector cachedContent;
    Attribute nextAttribute;
    public final String type;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Set {
        private static final int SIZE_INCREMENT = 6;
        private Attribute[] data = new Attribute[6];
        private int size;

        private void add(Attribute attribute) {
            int i = this.size;
            Attribute[] attributeArr = this.data;
            if (i >= attributeArr.length) {
                Attribute[] attributeArr2 = new Attribute[attributeArr.length + 6];
                System.arraycopy(attributeArr, 0, attributeArr2, 0, i);
                this.data = attributeArr2;
            }
            Attribute[] attributeArr3 = this.data;
            int i2 = this.size;
            this.size = i2 + 1;
            attributeArr3[i2] = attribute;
        }

        private boolean contains(Attribute attribute) {
            for (int i = 0; i < this.size; i++) {
                if (this.data[i].type.equals(attribute.type)) {
                    return true;
                }
            }
            return false;
        }

        public void addAttributes(Attribute attribute) {
            while (attribute != null) {
                if (!contains(attribute)) {
                    add(attribute);
                }
                attribute = attribute.nextAttribute;
            }
        }

        public Attribute[] toArray() {
            int i = this.size;
            Attribute[] attributeArr = new Attribute[i];
            System.arraycopy(this.data, 0, attributeArr, 0, i);
            return attributeArr;
        }
    }

    public Attribute(String str) {
        this.type = str;
    }

    private ByteVector maybeWrite(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        Attribute attribute;
        if (this.cachedContent == null) {
            ByteVector byteVectorWrite = write(classWriter, bArr, i, i2, i3);
            attribute = this;
            attribute.cachedContent = byteVectorWrite;
        } else {
            attribute = this;
        }
        return attribute.cachedContent;
    }

    public static Label readLabel(ClassReader classReader, int i, Label[] labelArr) {
        return classReader.readLabel(i, labelArr);
    }

    public final int computeAttributesSize(SymbolTable symbolTable) {
        return computeAttributesSize(symbolTable, null, 0, -1, -1);
    }

    public final int getAttributeCount() {
        int i = 0;
        for (Attribute attribute = this; attribute != null; attribute = attribute.nextAttribute) {
            i++;
        }
        return i;
    }

    @Deprecated
    public Label[] getLabels() {
        return new Label[0];
    }

    public boolean isCodeAttribute() {
        return false;
    }

    public boolean isUnknown() {
        return true;
    }

    public final void putAttributes(SymbolTable symbolTable, ByteVector byteVector) {
        putAttributes(symbolTable, null, 0, -1, -1, byteVector);
    }

    public Attribute read(ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        Attribute attribute = new Attribute(this.type);
        attribute.cachedContent = new ByteVector(classReader.readBytes(i, i2));
        return attribute;
    }

    public ByteVector write(ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        return this.cachedContent;
    }

    public static byte[] write(Attribute attribute, ClassWriter classWriter, byte[] bArr, int i, int i2, int i3) {
        ByteVector byteVectorMaybeWrite = attribute.maybeWrite(classWriter, bArr, i, i2, i3);
        int i4 = byteVectorMaybeWrite.length;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(byteVectorMaybeWrite.data, 0, bArr2, 0, i4);
        return bArr2;
    }

    public final int computeAttributesSize(SymbolTable symbolTable, byte[] bArr, int i, int i2, int i3) {
        ClassWriter classWriter = symbolTable.classWriter;
        int i4 = 0;
        Attribute attribute = this;
        while (attribute != null) {
            symbolTable.addConstantUtf8(attribute.type);
            byte[] bArr2 = bArr;
            i4 += attribute.maybeWrite(classWriter, bArr2, i, i2, i3).length + 6;
            attribute = attribute.nextAttribute;
            bArr = bArr2;
        }
        return i4;
    }

    public final void putAttributes(SymbolTable symbolTable, byte[] bArr, int i, int i2, int i3, ByteVector byteVector) {
        ClassWriter classWriter = symbolTable.classWriter;
        Attribute attribute = this;
        while (attribute != null) {
            byte[] bArr2 = bArr;
            int i4 = i;
            int i5 = i2;
            ByteVector byteVectorMaybeWrite = attribute.maybeWrite(classWriter, bArr2, i4, i5, i3);
            byteVector.putShort(symbolTable.addConstantUtf8(attribute.type)).putInt(byteVectorMaybeWrite.length);
            byteVector.putByteArray(byteVectorMaybeWrite.data, 0, byteVectorMaybeWrite.length);
            attribute = attribute.nextAttribute;
            bArr = bArr2;
            i = i4;
            i2 = i5;
        }
    }

    public static Attribute read(Attribute attribute, ClassReader classReader, int i, int i2, char[] cArr, int i3, Label[] labelArr) {
        return attribute.read(classReader, i, i2, cArr, i3, labelArr);
    }

    public static int computeAttributesSize(SymbolTable symbolTable, int i, int i2) {
        int i3;
        if ((i & 4096) == 0 || symbolTable.getMajorVersion() >= 49) {
            i3 = 0;
        } else {
            symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME);
            i3 = 6;
        }
        if (i2 != 0) {
            symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME);
            i3 += 8;
        }
        if ((i & 131072) == 0) {
            return i3;
        }
        symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME);
        return i3 + 6;
    }

    public static void putAttributes(SymbolTable symbolTable, int i, int i2, ByteVector byteVector) {
        if ((i & 4096) != 0 && symbolTable.getMajorVersion() < 49) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME)).putInt(0);
        }
        if (i2 != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME)).putInt(2).putShort(i2);
        }
        if ((i & 131072) != 0) {
            byteVector.putShort(symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME)).putInt(0);
        }
    }
}
