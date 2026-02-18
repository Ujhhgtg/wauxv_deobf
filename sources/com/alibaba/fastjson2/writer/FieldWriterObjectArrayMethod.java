package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldWriterObjectArrayMethod<T> extends FieldWriter<T> {
    final Class itemClass;
    ObjectWriter itemObjectWriter;
    final Type itemType;

    public FieldWriterObjectArrayMethod(String str, Type type, int i, long j, String str2, String str3, Type type2, Class cls, Field field, Method method) {
        super(str, i, j, str2, null, str3, type2, cls, field, method);
        this.itemType = type;
        if (type instanceof Class) {
            this.itemClass = (Class) type;
        } else {
            this.itemClass = TypeUtils.getMapping(type);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public Object getFieldValue(Object obj) {
        try {
            return this.method.invoke(obj, null);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new JSONException("field.get error, " + this.fieldName, e);
        }
    }

    @Override // com.alibaba.fastjson2.writer.FieldWriter
    public ObjectWriter getItemWriter(JSONWriter jSONWriter, Type type) {
        if (type != null && type != this.itemType) {
            return jSONWriter.getObjectWriter(type, (Class) null);
        }
        ObjectWriter objectWriter = this.itemObjectWriter;
        if (objectWriter != null) {
            return objectWriter;
        }
        if (type == Float[].class) {
            return this.decimalFormat != null ? new ObjectWriterArrayFinal(Float.class, this.decimalFormat) : ObjectWriterArrayFinal.FLOAT_ARRAY;
        }
        if (type == Double[].class) {
            return this.decimalFormat != null ? new ObjectWriterArrayFinal(Double.class, this.decimalFormat) : ObjectWriterArrayFinal.DOUBLE_ARRAY;
        }
        if (type == BigDecimal[].class) {
            return this.decimalFormat != null ? new ObjectWriterArrayFinal(BigDecimal.class, this.decimalFormat) : ObjectWriterArrayFinal.DECIMAL_ARRAY;
        }
        if (type == Float.class) {
            return this.decimalFormat != null ? new ObjectWriterImplFloat(this.decimalFormat) : ObjectWriterImplFloat.INSTANCE;
        }
        if (type == Double.class) {
            return this.decimalFormat != null ? new ObjectWriterImplDouble(this.decimalFormat) : ObjectWriterImplDouble.INSTANCE;
        }
        if (type == BigDecimal.class) {
            return this.decimalFormat != null ? new ObjectWriterImplBigDecimal(this.decimalFormat, null) : ObjectWriterImplBigDecimal.INSTANCE;
        }
        ObjectWriter objectWriter2 = jSONWriter.getObjectWriter(this.itemType, this.itemClass);
        this.itemObjectWriter = objectWriter2;
        return objectWriter2;
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
        boolean z2;
        Class<?> cls;
        String path;
        String path2;
        if (z) {
            writeFieldName(jSONWriter);
        }
        boolean zIsRefDetect = jSONWriter.isRefDetect();
        if (zIsRefDetect && (path2 = jSONWriter.setPath(this.fieldName, objArr)) != null) {
            jSONWriter.writeReference(path2);
            return;
        }
        boolean z3 = (this.features & JSONWriter.Feature.WriteNonStringValueAsString.mask) != 0;
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
                } else if (z3) {
                    jSONWriter.writeString(obj.toString());
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
        boolean z4 = zIsRefDetect;
        for (int i2 = 0; i2 < length; i2++) {
            boolean z5 = z4;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                jSONWriter.writeNull();
                z4 = z5;
            } else {
                Class<?> cls5 = obj2.getClass();
                if (cls5 != cls2) {
                    boolean zIsRefDetect2 = jSONWriter.isRefDetect();
                    ObjectWriter itemWriter2 = getItemWriter(jSONWriter, cls5);
                    if (zIsRefDetect2) {
                        zIsRefDetect2 = !ObjectWriterProvider.isNotReferenceDetect(cls5);
                    }
                    z2 = zIsRefDetect2;
                    objectWriter = itemWriter2;
                    cls = cls5;
                } else {
                    z2 = z5;
                    cls = cls2;
                }
                if (!z2 || (path = jSONWriter.setPath(i2, obj2)) == null) {
                    objectWriter.writeJSONB(jSONWriter, obj2, Integer.valueOf(i2), this.itemType, this.features);
                    if (z2) {
                        jSONWriter.popPath(obj2);
                    }
                } else {
                    jSONWriter.writeReference(path);
                    jSONWriter.popPath(obj2);
                }
                z4 = z2;
                cls2 = cls;
            }
        }
        if (zIsRefDetect) {
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
