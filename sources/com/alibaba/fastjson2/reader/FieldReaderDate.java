package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.DateUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.function.BiConsumer;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class FieldReaderDate<T> extends FieldReaderDateTimeCodec<T> {
    final BiConsumer<T, Date> function;

    public FieldReaderDate(String str, Type type, Class cls, int i, long j, String str2, Locale locale, Object obj, JSONSchema jSONSchema, Field field, Method method, BiConsumer<T, Date> biConsumer) {
        super(str, type, cls, i, j, str2, locale, obj, jSONSchema, method, field, ObjectReaderImplDate.of(str2, locale));
        this.function = biConsumer;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public void accept(T t, Date date) {
        BiConsumer<T, Date> biConsumer = this.function;
        if (biConsumer != null) {
            biConsumer.accept(t, date);
            return;
        }
        if (t == null) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error, object is null"));
        }
        Method method = this.method;
        if (method != null) {
            try {
                method.invoke(t, date);
                return;
            } catch (Exception e) {
                throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e);
            }
        }
        long j = this.fieldOffset;
        if (j != -1) {
            JDKUtils.UNSAFE.putObject(t, j, date);
            return;
        }
        try {
            this.field.set(t, date);
        } catch (Exception e2) {
            throw new JSONException(yg.o(new StringBuilder("set "), this.fieldName, " error"), e2);
        }
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public void acceptNull(T t) {
        accept((Object) t, (Date) null);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public Object apply(Date date) {
        return date;
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void readFieldValue(JSONReader jSONReader, T t) throws Exception {
        Date date;
        try {
            date = (Date) this.dateReader.readObject(jSONReader, this.fieldType, this.fieldName, this.features);
        } catch (Exception e) {
            if ((this.features & JSONReader.Feature.NullOnError.mask) == 0) {
                throw e;
            }
            date = null;
        }
        accept((Object) t, date);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public Object apply(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(DateUtils.DEFAULT_ZONE_ID.getRules().getOffset(localDateTime)));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public Object apply(Instant instant) {
        return Date.from(instant);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public Object apply(ZonedDateTime zonedDateTime) {
        return Date.from(zonedDateTime.toInstant());
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public Object apply(long j) {
        return new Date(j);
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public void accept(T t, Instant instant) {
        accept((Object) t, Date.from(instant));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReader
    public void accept(T t, long j) {
        accept((Object) t, new Date(j));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public void accept(T t, ZonedDateTime zonedDateTime) {
        accept((Object) t, new Date(zonedDateTime.toInstant().toEpochMilli()));
    }

    @Override // com.alibaba.fastjson2.reader.FieldReaderDateTimeCodec
    public void accept(T t, LocalDateTime localDateTime) {
        accept((Object) t, Date.from(localDateTime.toInstant(DateUtils.DEFAULT_ZONE_ID.getRules().getOffset(localDateTime))));
    }
}
