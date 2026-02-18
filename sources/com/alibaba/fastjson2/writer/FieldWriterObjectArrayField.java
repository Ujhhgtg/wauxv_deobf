package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterObjectArrayField<T> extends FieldWriter<T> {
    final Class itemClass;
    ObjectWriter itemObjectWriter;
    final Type itemType;

    public FieldWriterObjectArrayField(String str, Type type, int i, long j, String str2, String str3, Type type2, Class cls, Field field) {
        super(str, i, j, str2, null, str3, type2, cls, field, null);
        this.itemType = type;
        if (type instanceof Class) {
            this.itemClass = (Class) type;
        } else {
            this.itemClass = TypeUtils.getMapping(type);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public ObjectWriter getItemWriter(JSONWriter jSONWriter, Type type) {
        if (type != null && type != this.itemType) {
            return jSONWriter.getObjectWriter(type, TypeUtils.getClass(type));
        }
        ObjectWriter objectWriter = this.itemObjectWriter;
        if (objectWriter != null) {
            return objectWriter;
        }
        if (type == Double.class) {
            this.itemObjectWriter = new ObjectWriterImplDouble(new DecimalFormat(this.format));
        } else if (type == Float.class) {
            this.itemObjectWriter = new ObjectWriterImplFloat(new DecimalFormat(this.format));
        } else if (type != BigDecimal.class || this.decimalFormat == null) {
            this.itemObjectWriter = jSONWriter.getObjectWriter(this.itemType, this.itemClass);
        } else {
            this.itemObjectWriter = new ObjectWriterImplBigDecimal(this.decimalFormat, null);
        }
        return this.itemObjectWriter;
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public ObjectWriter getObjectWriter(JSONWriter jSONWriter, Class cls) {
        return cls == String[].class ? ObjectWriterImplStringArray.INSTANCE : cls == Float[].class ? this.decimalFormat != null ? new ObjectWriterArrayFinal(Float.class, this.decimalFormat) : ObjectWriterArrayFinal.FLOAT_ARRAY : cls == Double[].class ? this.decimalFormat != null ? new ObjectWriterArrayFinal(Double.class, this.decimalFormat) : ObjectWriterArrayFinal.DOUBLE_ARRAY : cls == BigDecimal[].class ? this.decimalFormat != null ? new ObjectWriterArrayFinal(BigDecimal.class, this.decimalFormat) : ObjectWriterArrayFinal.DECIMAL_ARRAY : jSONWriter.getObjectWriter(cls);
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public boolean write(JSONWriter jSONWriter, T t) {
        Object[] objArr = (Object[]) getFieldValue(t);
        if (objArr != null) {
            writeArray(jSONWriter, true, objArr);
            return true;
        }
        if (((this.features | jSONWriter.getFeatures()) & (JSONWriter.Feature.WriteNulls.mask | JSONWriter.Feature.NullAsDefaultValue.mask | JSONWriter.Feature.WriteNullListAsEmpty.mask)) == 0) {
            return false;
        }
        writeFieldName(jSONWriter);
        jSONWriter.writeArrayNull();
        return true;
    }

    public void writeArray(JSONWriter jSONWriter, boolean z, Object[] objArr) {
        Class<?> cls;
        String path;
        String path2;
        long features = jSONWriter.getFeatures();
        boolean z2 = (JSONWriter.Feature.ReferenceDetection.mask & features) != 0;
        if (z) {
            if (objArr.length == 0 && (features & JSONWriter.Feature.NotWriteEmptyArray.mask) != 0) {
                return;
            } else {
                writeFieldName(jSONWriter);
            }
        }
        if (z2 && (path2 = jSONWriter.setPath(this.fieldName, objArr)) != null) {
            jSONWriter.writeReference(path2);
            return;
        }
        Class<?> cls2 = null;
        if (!jSONWriter.jsonb) {
            jSONWriter.startArray();
            ObjectWriter itemWriter = null;
            for (int i = 0; i < objArr.length; i++) {
                if (i != 0) {
                    jSONWriter.writeComma();
                }
                Object obj = objArr[i];
                if (obj == null) {
                    jSONWriter.writeNull();
                } else {
                    Class<?> cls3 = obj.getClass();
                    if (cls3 != cls2) {
                        itemWriter = getItemWriter(jSONWriter, cls3);
                        cls2 = cls3;
                    }
                    itemWriter.write(jSONWriter, obj);
                }
            }
            jSONWriter.endArray();
            return;
        }
        Class<?> cls4 = objArr.getClass();
        if (cls4 != this.fieldClass) {
            jSONWriter.writeTypeName(TypeUtils.getTypeName(cls4));
        }
        int length = objArr.length;
        jSONWriter.startArray(length);
        ObjectWriter objectWriter = null;
        boolean z3 = z2;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                jSONWriter.writeNull();
            } else {
                Class<?> cls5 = obj2.getClass();
                if (cls5 != cls2) {
                    boolean zIsRefDetect = jSONWriter.isRefDetect();
                    ObjectWriter itemWriter2 = getItemWriter(jSONWriter, cls5);
                    if (zIsRefDetect) {
                        zIsRefDetect = !ObjectWriterProvider.isNotReferenceDetect(cls5);
                    }
                    z3 = zIsRefDetect;
                    objectWriter = itemWriter2;
                    cls = cls5;
                } else {
                    cls = cls2;
                }
                boolean z4 = z3;
                if (!z4 || (path = jSONWriter.setPath(i2, obj2)) == null) {
                    objectWriter.writeJSONB(jSONWriter, obj2, Integer.valueOf(i2), this.itemType, this.features);
                    if (z4) {
                        jSONWriter.popPath(obj2);
                    }
                } else {
                    jSONWriter.writeReference(path);
                    jSONWriter.popPath(obj2);
                }
                cls2 = cls;
                z3 = z4;
            }
        }
        if (z2) {
            jSONWriter.popPath(objArr);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public void writeValue(JSONWriter jSONWriter, T t) {
        Object[] objArr = (Object[]) getFieldValue(t);
        if (objArr == null) {
            jSONWriter.writeNull();
        } else {
            writeArray(jSONWriter, false, objArr);
        }
    }
}
