package bsh.org.objectweb.asm;

import bsh.org.objectweb.asm.Attribute;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSynthetic;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriter extends FieldVisitor {
    private final int accessFlags;
    private int constantValueIndex;
    private final int descriptorIndex;
    private Attribute firstAttribute;
    private final int nameIndex;
    private int signatureIndex;
    private final SymbolTable symbolTable;

    public FieldWriter(SymbolTable symbolTable, int i, String str, String str2, String str3, Object obj) {
        super(393216);
        this.symbolTable = symbolTable;
        this.accessFlags = i;
        this.nameIndex = symbolTable.addConstantUtf8(str);
        this.descriptorIndex = symbolTable.addConstantUtf8(str2);
        if (str3 != null) {
            this.signatureIndex = symbolTable.addConstantUtf8(str3);
        }
        if (obj != null) {
            this.constantValueIndex = symbolTable.addConstant(obj).index;
        }
    }

    public final void collectAttributePrototypes(Attribute.Set set) {
        set.addAttributes(this.firstAttribute);
    }

    public int computeFieldInfoSize() {
        int i;
        if (this.constantValueIndex != 0) {
            this.symbolTable.addConstantUtf8(AttConstantValue.ATTRIBUTE_NAME);
            i = 16;
        } else {
            i = 8;
        }
        if ((this.accessFlags & 4096) != 0 && this.symbolTable.getMajorVersion() < 49) {
            this.symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME);
            i += 6;
        }
        if (this.signatureIndex != 0) {
            this.symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME);
            i += 8;
        }
        if ((this.accessFlags & 131072) != 0) {
            this.symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME);
            i += 6;
        }
        Attribute attribute = this.firstAttribute;
        return attribute != null ? attribute.computeAttributesSize(this.symbolTable) + i : i;
    }

    public void putFieldInfo(ByteVector byteVector) {
        boolean z = this.symbolTable.getMajorVersion() < 49;
        byteVector.putShort((~(z ? 4096 : 0)) & this.accessFlags).putShort(this.nameIndex).putShort(this.descriptorIndex);
        int attributeCount = this.constantValueIndex == 0 ? 0 : 1;
        int i = this.accessFlags;
        if ((i & 4096) != 0 && z) {
            attributeCount++;
        }
        if (this.signatureIndex != 0) {
            attributeCount++;
        }
        if ((i & 131072) != 0) {
            attributeCount++;
        }
        Attribute attribute = this.firstAttribute;
        if (attribute != null) {
            attributeCount += attribute.getAttributeCount();
        }
        byteVector.putShort(attributeCount);
        if (this.constantValueIndex != 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8(AttConstantValue.ATTRIBUTE_NAME)).putInt(2).putShort(this.constantValueIndex);
        }
        if ((4096 & this.accessFlags) != 0 && z) {
            byteVector.putShort(this.symbolTable.addConstantUtf8(AttSynthetic.ATTRIBUTE_NAME)).putInt(0);
        }
        if (this.signatureIndex != 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8(AttSignature.ATTRIBUTE_NAME)).putInt(2).putShort(this.signatureIndex);
        }
        if ((this.accessFlags & 131072) != 0) {
            byteVector.putShort(this.symbolTable.addConstantUtf8(AttDeprecated.ATTRIBUTE_NAME)).putInt(0);
        }
        Attribute attribute2 = this.firstAttribute;
        if (attribute2 != null) {
            attribute2.putAttributes(this.symbolTable, byteVector);
        }
    }

    @Override // bsh.org.objectweb.asm.FieldVisitor
    public void visitAttribute(Attribute attribute) {
        attribute.nextAttribute = this.firstAttribute;
        this.firstAttribute = attribute;
    }

    @Override // bsh.org.objectweb.asm.FieldVisitor
    public void visitEnd() {
    }
}
