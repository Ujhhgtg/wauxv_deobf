package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import net.bytebuddy.asm.Advice;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
abstract class FieldWriterBoolean extends FieldWriter {
    final char[] utf16Value0;
    final char[] utf16Value1;
    final char[] utf16ValueFalse;
    final char[] utf16ValueTrue;
    final byte[] utf8Value0;
    final byte[] utf8Value1;
    final byte[] utf8ValueFalse;
    final byte[] utf8ValueTrue;

    public FieldWriterBoolean(String str, int i, long j, String str2, String str3, Type type, Class cls, Field field, Method method) {
        super(str, i, j, str2, null, str3, type, cls, field, method);
        byte[] bArr = this.nameWithColonUTF8;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + 4);
        byte[] bArr2 = this.nameWithColonUTF8;
        bArrCopyOf[bArr2.length] = 116;
        bArrCopyOf[bArr2.length + 1] = 114;
        bArrCopyOf[bArr2.length + 2] = 117;
        bArrCopyOf[bArr2.length + 3] = 101;
        this.utf8ValueTrue = bArrCopyOf;
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr2, bArr2.length + 5);
        byte[] bArr3 = this.nameWithColonUTF8;
        bArrCopyOf2[bArr3.length] = 102;
        bArrCopyOf2[bArr3.length + 1] = 97;
        bArrCopyOf2[bArr3.length + 2] = 108;
        bArrCopyOf2[bArr3.length + 3] = 115;
        bArrCopyOf2[bArr3.length + 4] = 101;
        this.utf8ValueFalse = bArrCopyOf2;
        byte[] bArrCopyOf3 = Arrays.copyOf(bArr3, bArr3.length + 1);
        byte[] bArr4 = this.nameWithColonUTF8;
        bArrCopyOf3[bArr4.length] = 49;
        this.utf8Value1 = bArrCopyOf3;
        byte[] bArrCopyOf4 = Arrays.copyOf(bArr4, bArr4.length + 1);
        bArrCopyOf4[this.nameWithColonUTF8.length] = JSONB.Constants.BC_INT32_BYTE_MIN;
        this.utf8Value0 = bArrCopyOf4;
        char[] cArr = this.nameWithColonUTF16;
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length + 4);
        char[] cArr2 = this.nameWithColonUTF16;
        cArrCopyOf[cArr2.length] = Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL;
        cArrCopyOf[cArr2.length + 1] = Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL;
        cArrCopyOf[cArr2.length + 2] = 'u';
        cArrCopyOf[cArr2.length + 3] = 'e';
        this.utf16ValueTrue = cArrCopyOf;
        char[] cArrCopyOf2 = Arrays.copyOf(cArr2, cArr2.length + 5);
        char[] cArr3 = this.nameWithColonUTF16;
        cArrCopyOf2[cArr3.length] = 'f';
        cArrCopyOf2[cArr3.length + 1] = 'a';
        cArrCopyOf2[cArr3.length + 2] = 'l';
        cArrCopyOf2[cArr3.length + 3] = Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL;
        cArrCopyOf2[cArr3.length + 4] = 'e';
        this.utf16ValueFalse = cArrCopyOf2;
        char[] cArrCopyOf3 = Arrays.copyOf(cArr3, cArr3.length + 1);
        char[] cArr4 = this.nameWithColonUTF16;
        cArrCopyOf3[cArr4.length] = '1';
        this.utf16Value1 = cArrCopyOf3;
        char[] cArrCopyOf4 = Arrays.copyOf(cArr4, cArr4.length + 1);
        cArrCopyOf4[this.nameWithColonUTF16.length] = '0';
        this.utf16Value0 = cArrCopyOf4;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public ObjectWriter getObjectWriter(JSONWriter jSONWriter, Class cls) {
        return cls == this.fieldClass ? ObjectWriterImplBoolean.INSTANCE : jSONWriter.getObjectWriter(cls);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, Object obj) {
        try {
            Boolean bool = (Boolean) getFieldValue(obj);
            if (bool != null) {
                if (this.fieldClass == Boolean.TYPE && !bool.booleanValue() && (jSONWriter.getFeatures(this.features) & JSONWriter.Feature.NotWriteDefaultValue.mask) != 0) {
                    return false;
                }
                writeBool(jSONWriter, bool.booleanValue());
                return true;
            }
            long features = this.features | jSONWriter.getFeatures();
            long j = JSONWriter.Feature.WriteNulls.mask | JSONWriter.Feature.NullAsDefaultValue.mask;
            JSONWriter.Feature feature = JSONWriter.Feature.WriteNullBooleanAsFalse;
            if (((j | feature.mask) & features) == 0) {
                return false;
            }
            writeFieldName(jSONWriter);
            if ((features & feature.mask) != 0) {
                jSONWriter.writeBool(false);
            } else {
                jSONWriter.writeBooleanNull();
            }
            return true;
        } catch (RuntimeException e) {
            if (jSONWriter.isIgnoreErrorGetter()) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public final void writeBool(JSONWriter jSONWriter, boolean z) {
        long features = jSONWriter.getFeatures(this.features);
        if ((JSONWriter.Feature.WriteNonStringValueAsString.mask & features) != 0) {
            writeFieldName(jSONWriter);
            jSONWriter.writeString(z ? "true" : "false");
        } else if (jSONWriter.utf8) {
            jSONWriter.writeNameRaw((features & JSONWriter.Feature.WriteBooleanAsNumber.mask) != 0 ? z ? this.utf8Value1 : this.utf8Value0 : z ? this.utf8ValueTrue : this.utf8ValueFalse);
        } else if (jSONWriter.utf16) {
            jSONWriter.writeNameRaw((features & JSONWriter.Feature.WriteBooleanAsNumber.mask) != 0 ? z ? this.utf16Value1 : this.utf16Value0 : z ? this.utf16ValueTrue : this.utf16ValueFalse);
        } else {
            writeFieldName(jSONWriter);
            jSONWriter.writeBool(z);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, Object obj) {
        Boolean bool = (Boolean) getFieldValue(obj);
        if (bool == null) {
            jSONWriter.writeNull();
        } else {
            jSONWriter.writeBool(bool.booleanValue());
        }
    }
}
