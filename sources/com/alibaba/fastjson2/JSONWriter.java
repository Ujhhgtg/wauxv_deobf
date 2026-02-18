package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.filter.AfterFilter;
import com.alibaba.fastjson2.filter.BeforeFilter;
import com.alibaba.fastjson2.filter.ContextNameFilter;
import com.alibaba.fastjson2.filter.ContextValueFilter;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.filter.LabelFilter;
import com.alibaba.fastjson2.filter.NameFilter;
import com.alibaba.fastjson2.filter.PropertyFilter;
import com.alibaba.fastjson2.filter.PropertyPreFilter;
import com.alibaba.fastjson2.filter.ValueFilter;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.FieldWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import com.android.dx.io.Opcodes;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.yg;
import okhttp3.HttpUrl;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class JSONWriter implements Closeable {
    protected static final long MASK_BROWSER_COMPATIBLE = 32;
    protected static final long MASK_BROWSER_SECURE = 34359738368L;
    protected static final long MASK_ESCAPE_NONE_ASCII = 1073741824;
    protected static final long MASK_IGNORE_NON_FIELD_GETTER = 4294967296L;
    protected static final long MASK_NOT_WRITE_DEFAULT_VALUE = 4096;
    protected static final long MASK_NOT_WRITE_EMPTY_ARRAY = 67108864;
    protected static final long MASK_NOT_WRITE_NUMBER_CLASS_NAME = 1099511627776L;
    protected static final long MASK_NULL_AS_DEFAULT_VALUE = 64;
    protected static final long MASK_PRETTY_FORMAT = 65536;
    protected static final long MASK_REFERENCE_DETECTION = 131072;
    protected static final long MASK_USE_SINGLE_QUOTES = 1048576;
    protected static final long MASK_WRITE_BOOLEAN_AS_NUMBER = 128;
    protected static final long MASK_WRITE_CLASS_NAME = 512;
    protected static final long MASK_WRITE_ENUMS_USING_NAME = 8192;
    protected static final long MASK_WRITE_ENUM_USING_TO_STRING = 16384;
    protected static final long MASK_WRITE_LONG_AS_STRING = 17179869184L;
    protected static final long MASK_WRITE_MAP_NULL_VALUE = 16;
    protected static final long MASK_WRITE_NON_STRING_VALUE_AS_STRING = 256;
    protected static final long MASK_WRITE_NULL_BOOLEAN_AS_FALSE = 33554432;
    protected static final long MASK_WRITE_NULL_LIST_AS_EMPTY = 4194304;
    protected static final long MASK_WRITE_NULL_NUMBER_AS_ZERO = 16777216;
    protected static final long MASK_WRITE_NULL_STRING_AS_EMPTY = 8388608;
    static final byte PRETTY_2_SPACE = 2;
    static final byte PRETTY_4_SPACE = 4;
    static final byte PRETTY_NON = 0;
    static final byte PRETTY_TAB = 1;
    protected Object attachment;
    protected final Charset charset;
    public final Context context;
    public final boolean jsonb;
    protected String lastReference;
    protected int level;
    protected final int maxArraySize;
    protected int off;
    protected Path path;
    protected byte pretty;
    protected final char quote;
    protected IdentityHashMap<Object, Path> refs;
    protected Object rootObject;
    protected boolean startObject;
    public final SymbolTable symbolTable;
    public final boolean useSingleQuote;
    public final boolean utf16;
    public final boolean utf8;
    static final long WRITE_ARRAY_NULL_MASK = Feature.NullAsDefaultValue.mask | Feature.WriteNullListAsEmpty.mask;
    static final long NONE_DIRECT_FEATURES = (Feature.ReferenceDetection.mask | Feature.NotWriteEmptyArray.mask)
            | Feature.NotWriteDefaultValue.mask;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Context {
        static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();
        AfterFilter afterFilter;
        BeforeFilter beforeFilter;
        ContextNameFilter contextNameFilter;
        ContextValueFilter contextValueFilter;
        String dateFormat;
        boolean dateFormatISO8601;
        boolean dateFormatMillis;
        boolean dateFormatUnixTime;
        DateTimeFormatter dateFormatter;
        long features;
        boolean formatHasDay;
        boolean formatHasHour;
        boolean formatyyyyMMddhhmmss19;
        boolean hasFilter;
        LabelFilter labelFilter;
        Locale locale;
        int maxLevel;
        NameFilter nameFilter;
        PropertyFilter propertyFilter;
        PropertyPreFilter propertyPreFilter;
        public final ObjectWriterProvider provider;
        ValueFilter valueFilter;
        ZoneId zoneId;

        public Context(ObjectWriterProvider objectWriterProvider) {
            if (objectWriterProvider == null) {
                throw new IllegalArgumentException("objectWriterProvider must not null");
            }
            this.features = JSONFactory.defaultWriterFeatures;
            this.provider = objectWriterProvider;
            this.zoneId = JSONFactory.defaultWriterZoneId;
            this.maxLevel = JSONFactory.defaultMaxLevel;
            String str = JSONFactory.defaultWriterFormat;
            if (str != null) {
                setDateFormat(str);
            }
        }

        public void config(Feature... featureArr) {
            for (Feature feature : featureArr) {
                this.features |= feature.mask;
            }
        }

        public void configFilter(Filter... filterArr) {
            for (Filter filter : filterArr) {
                if (filter instanceof NameFilter) {
                    NameFilter nameFilter = this.nameFilter;
                    if (nameFilter == null) {
                        this.nameFilter = (NameFilter) filter;
                    } else {
                        this.nameFilter = NameFilter.compose(nameFilter, (NameFilter) filter);
                    }
                }
                if (filter instanceof ValueFilter) {
                    ValueFilter valueFilter = this.valueFilter;
                    if (valueFilter == null) {
                        this.valueFilter = (ValueFilter) filter;
                    } else {
                        this.valueFilter = ValueFilter.compose(valueFilter, (ValueFilter) filter);
                    }
                }
                if (filter instanceof PropertyFilter) {
                    this.propertyFilter = (PropertyFilter) filter;
                }
                if (filter instanceof PropertyPreFilter) {
                    this.propertyPreFilter = (PropertyPreFilter) filter;
                }
                if (filter instanceof BeforeFilter) {
                    this.beforeFilter = (BeforeFilter) filter;
                }
                if (filter instanceof AfterFilter) {
                    this.afterFilter = (AfterFilter) filter;
                }
                if (filter instanceof LabelFilter) {
                    this.labelFilter = (LabelFilter) filter;
                }
                if (filter instanceof ContextValueFilter) {
                    this.contextValueFilter = (ContextValueFilter) filter;
                }
                if (filter instanceof ContextNameFilter) {
                    this.contextNameFilter = (ContextNameFilter) filter;
                }
            }
            this.hasFilter = (this.propertyPreFilter == null && this.propertyFilter == null && this.nameFilter == null
                    && this.valueFilter == null && this.beforeFilter == null && this.afterFilter == null
                    && this.labelFilter == null && this.contextValueFilter == null && this.contextNameFilter == null)
                            ? false
                            : true;
        }

        public AfterFilter getAfterFilter() {
            return this.afterFilter;
        }

        public BeforeFilter getBeforeFilter() {
            return this.beforeFilter;
        }

        public ContextNameFilter getContextNameFilter() {
            return this.contextNameFilter;
        }

        public ContextValueFilter getContextValueFilter() {
            return this.contextValueFilter;
        }

        public String getDateFormat() {
            return this.dateFormat;
        }

        public DateTimeFormatter getDateFormatter() {
            String str;
            if (this.dateFormatter == null && (str = this.dateFormat) != null && !this.dateFormatMillis
                    && !this.dateFormatISO8601 && !this.dateFormatUnixTime) {
                Locale locale = this.locale;
                this.dateFormatter = locale == null ? DateTimeFormatter.ofPattern(str)
                        : DateTimeFormatter.ofPattern(str, locale);
            }
            return this.dateFormatter;
        }

        public long getFeatures() {
            return this.features;
        }

        public LabelFilter getLabelFilter() {
            return this.labelFilter;
        }

        public int getMaxLevel() {
            return this.maxLevel;
        }

        public NameFilter getNameFilter() {
            return this.nameFilter;
        }

        public <T> ObjectWriter<T> getObjectWriter(Class<T> cls) {
            return this.provider.getObjectWriter(cls, cls, (this.features & Feature.FieldBased.mask) != 0);
        }

        public PropertyFilter getPropertyFilter() {
            return this.propertyFilter;
        }

        public PropertyPreFilter getPropertyPreFilter() {
            return this.propertyPreFilter;
        }

        public ObjectWriterProvider getProvider() {
            return this.provider;
        }

        public ValueFilter getValueFilter() {
            return this.valueFilter;
        }

        public ZoneId getZoneId() {
            if (this.zoneId == null) {
                this.zoneId = DEFAULT_ZONE_ID;
            }
            return this.zoneId;
        }

        public boolean isDateFormatHasDay() {
            return this.formatHasDay;
        }

        public boolean isDateFormatHasHour() {
            return this.formatHasHour;
        }

        public boolean isDateFormatISO8601() {
            return this.dateFormatISO8601;
        }

        public boolean isDateFormatMillis() {
            return this.dateFormatMillis;
        }

        public boolean isDateFormatUnixTime() {
            return this.dateFormatUnixTime;
        }

        public boolean isEnabled(Feature feature) {
            return (this.features & feature.mask) != 0;
        }

        public boolean isFormatyyyyMMddhhmmss19() {
            return this.formatyyyyMMddhhmmss19;
        }

        public void setAfterFilter(AfterFilter afterFilter) {
            this.afterFilter = afterFilter;
            if (afterFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setBeforeFilter(BeforeFilter beforeFilter) {
            this.beforeFilter = beforeFilter;
            if (beforeFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setContextNameFilter(ContextNameFilter contextNameFilter) {
            this.contextNameFilter = contextNameFilter;
            if (contextNameFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setContextValueFilter(ContextValueFilter contextValueFilter) {
            this.contextValueFilter = contextValueFilter;
            if (contextValueFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setDateFormat(String str) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean zContains;
            boolean z5;
            if (str == null || !str.equals(this.dateFormat)) {
                this.dateFormatter = null;
            }
            if (str != null && !str.isEmpty()) {
                z = true;
                z2 = false;
                switch (str) {
                    case "millis":
                        z3 = false;
                        z4 = false;
                        zContains = z4;
                        z5 = zContains;
                        break;
                    case "unixtime":
                        z3 = true;
                        z = false;
                        z4 = false;
                        zContains = z4;
                        z5 = zContains;
                        break;
                    case "yyyy-MM-dd HH:mm:ss":
                        z4 = true;
                        zContains = true;
                        z5 = true;
                        z3 = false;
                        z = false;
                        break;
                    case "yyyy-MM-ddTHH:mm:ss":
                        str = "yyyy-MM-dd'T'HH:mm:ss";
                        z4 = true;
                        zContains = true;
                        z3 = false;
                        z = false;
                        z5 = false;
                        break;
                    case "iso8601":
                        z3 = false;
                        z4 = false;
                        zContains = false;
                        z5 = false;
                        z2 = true;
                        z = false;
                        break;
                    default:
                        boolean zContains2 = str.contains("d");
                        zContains = str.contains("H");
                        z4 = zContains2;
                        z3 = false;
                        z = false;
                        z5 = false;
                        break;
                }
                this.dateFormatMillis = z;
                this.dateFormatISO8601 = z2;
                this.dateFormatUnixTime = z3;
                this.formatHasDay = z4;
                this.formatHasHour = zContains;
                this.formatyyyyMMddhhmmss19 = z5;
            }
            this.dateFormat = str;
        }

        public void setFeatures(long j) {
            this.features = j;
        }

        public void setLabelFilter(LabelFilter labelFilter) {
            this.labelFilter = labelFilter;
            if (labelFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setMaxLevel(int i) {
            this.maxLevel = i;
        }

        public void setNameFilter(NameFilter nameFilter) {
            this.nameFilter = nameFilter;
            if (nameFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setPropertyFilter(PropertyFilter propertyFilter) {
            this.propertyFilter = propertyFilter;
            if (propertyFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setPropertyPreFilter(PropertyPreFilter propertyPreFilter) {
            this.propertyPreFilter = propertyPreFilter;
            if (propertyPreFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setValueFilter(ValueFilter valueFilter) {
            this.valueFilter = valueFilter;
            if (valueFilter != null) {
                this.hasFilter = true;
            }
        }

        public void setZoneId(ZoneId zoneId) {
            this.zoneId = zoneId;
        }

        public boolean isEnabled(long j) {
            return (j & this.features) != 0;
        }

        public void config(Feature feature, boolean z) {
            if (z) {
                this.features = feature.mask | this.features;
            } else {
                this.features = (~feature.mask) & this.features;
            }
        }

        public <T> ObjectWriter<T> getObjectWriter(Type type, Class<T> cls) {
            return this.provider.getObjectWriter(type, cls, (this.features & Feature.FieldBased.mask) != 0);
        }

        public Context(Feature... featureArr) {
            this.features = JSONFactory.defaultWriterFeatures;
            this.provider = JSONFactory.getDefaultObjectWriterProvider();
            this.zoneId = JSONFactory.defaultWriterZoneId;
            this.maxLevel = JSONFactory.defaultMaxLevel;
            String str = JSONFactory.defaultWriterFormat;
            if (str != null) {
                setDateFormat(str);
            }
            for (Feature feature : featureArr) {
                this.features |= feature.mask;
            }
        }

        public Context(String str, Feature... featureArr) {
            this.features = JSONFactory.defaultWriterFeatures;
            this.provider = JSONFactory.getDefaultObjectWriterProvider();
            this.zoneId = JSONFactory.defaultWriterZoneId;
            this.maxLevel = JSONFactory.defaultMaxLevel;
            for (Feature feature : featureArr) {
                this.features |= feature.mask;
            }
            str = str == null ? JSONFactory.defaultWriterFormat : str;
            if (str != null) {
                setDateFormat(str);
            }
        }

        public Context(ObjectWriterProvider objectWriterProvider, Feature... featureArr) {
            if (objectWriterProvider != null) {
                this.features = JSONFactory.defaultWriterFeatures;
                this.provider = objectWriterProvider;
                this.zoneId = JSONFactory.defaultWriterZoneId;
                this.maxLevel = JSONFactory.defaultMaxLevel;
                for (Feature feature : featureArr) {
                    this.features |= feature.mask;
                }
                String str = JSONFactory.defaultWriterFormat;
                if (str != null) {
                    setDateFormat(str);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("objectWriterProvider must not null");
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public enum Feature {
        FieldBased(1),
        IgnoreNoneSerializable(2),
        ErrorOnNoneSerializable(4),
        BeanToArray(8),
        WriteNulls(JSONWriter.MASK_WRITE_MAP_NULL_VALUE),
        WriteMapNullValue(JSONWriter.MASK_WRITE_MAP_NULL_VALUE),
        BrowserCompatible(JSONWriter.MASK_BROWSER_COMPATIBLE),
        NullAsDefaultValue(JSONWriter.MASK_NULL_AS_DEFAULT_VALUE),
        WriteBooleanAsNumber(JSONWriter.MASK_WRITE_BOOLEAN_AS_NUMBER),
        WriteNonStringValueAsString(JSONWriter.MASK_WRITE_NON_STRING_VALUE_AS_STRING),
        WriteClassName(JSONWriter.MASK_WRITE_CLASS_NAME),
        NotWriteRootClassName(RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE),
        NotWriteHashMapArrayListClassName(2048),
        NotWriteDefaultValue(JSONWriter.MASK_NOT_WRITE_DEFAULT_VALUE),
        WriteEnumsUsingName(JSONWriter.MASK_WRITE_ENUMS_USING_NAME),
        WriteEnumUsingToString(16384),
        IgnoreErrorGetter(32768),
        PrettyFormat(JSONWriter.MASK_PRETTY_FORMAT),
        ReferenceDetection(JSONWriter.MASK_REFERENCE_DETECTION),
        WriteNameAsSymbol(262144),
        WriteBigDecimalAsPlain(524288),
        UseSingleQuotes(JSONWriter.MASK_USE_SINGLE_QUOTES),
        MapSortField(2097152),
        WriteNullListAsEmpty(JSONWriter.MASK_WRITE_NULL_LIST_AS_EMPTY),
        WriteNullStringAsEmpty(JSONWriter.MASK_WRITE_NULL_STRING_AS_EMPTY),
        WriteNullNumberAsZero(JSONWriter.MASK_WRITE_NULL_NUMBER_AS_ZERO),
        WriteNullBooleanAsFalse(JSONWriter.MASK_WRITE_NULL_BOOLEAN_AS_FALSE),
        NotWriteEmptyArray(JSONWriter.MASK_NOT_WRITE_EMPTY_ARRAY),
        IgnoreEmpty(JSONWriter.MASK_NOT_WRITE_EMPTY_ARRAY),
        WriteNonStringKeyAsString(134217728),
        WritePairAsJavaBean(268435456),
        OptimizedForAscii(536870912),
        EscapeNoneAscii(JSONWriter.MASK_ESCAPE_NONE_ASCII),
        WriteByteArrayAsBase64(2147483648L),
        IgnoreNonFieldGetter(JSONWriter.MASK_IGNORE_NON_FIELD_GETTER),
        LargeObject(8589934592L),
        WriteLongAsString(JSONWriter.MASK_WRITE_LONG_AS_STRING),
        BrowserSecure(JSONWriter.MASK_BROWSER_SECURE),
        WriteEnumUsingOrdinal(68719476736L),
        WriteThrowableClassName(137438953472L),
        UnquoteFieldName(274877906944L),
        NotWriteSetClassName(549755813888L),
        NotWriteNumberClassName(JSONWriter.MASK_NOT_WRITE_NUMBER_CLASS_NAME),
        SortMapEntriesByKeys(2199023255552L),
        PrettyFormatWith2Space(4398046511104L),
        PrettyFormatWith4Space(8796093022208L),
        WriterUtilDateAsMillis(17592186044416L);

        public final long mask;

        Feature(long j) {
            this.mask = j;
        }

        public boolean isEnabled(long j) {
            return (j & this.mask) != 0;
        }
    }

    public JSONWriter(Context context, SymbolTable symbolTable, boolean z, Charset charset) {
        this.context = context;
        this.symbolTable = symbolTable;
        this.charset = charset;
        this.jsonb = z;
        this.utf8 = !z && charset == StandardCharsets.UTF_8;
        this.utf16 = !z && charset == StandardCharsets.UTF_16;
        boolean z2 = (z || (context.features & Feature.UseSingleQuotes.mask) == 0) ? false : true;
        this.useSingleQuote = z2;
        this.quote = z2 ? '\'' : '\"';
        long j = context.features;
        this.maxArraySize = (Feature.LargeObject.mask & j) != 0 ? 1073741824 : 67108864;
        if ((Feature.PrettyFormatWith4Space.mask & j) != 0) {
            this.pretty = (byte) 4;
            return;
        }
        if ((Feature.PrettyFormatWith2Space.mask & j) != 0) {
            this.pretty = (byte) 2;
        } else if ((j & Feature.PrettyFormat.mask) != 0) {
            this.pretty = (byte) 1;
        } else {
            this.pretty = (byte) 0;
        }
    }

    public static IllegalArgumentException illegalYear(int i) {
        return new IllegalArgumentException(concatVar2Var1(i, "Only 4 digits numbers are supported. Provided: "));
    }

    public static boolean isWriteAsString(long j, long j2) {
        if ((17179869440L & j2) == 0) {
            return ((j2 & MASK_BROWSER_COMPATIBLE) == 0 || TypeUtils.isJavaScriptSupport(j)) ? false : true;
        }
        return true;
    }

    private static boolean isWriteTypeInfoGenericArray(GenericArrayType genericArrayType, Class cls) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof ParameterizedType) {
            genericComponentType = ((ParameterizedType) genericComponentType).getRawType();
        }
        if (cls.isArray()) {
            return cls.getComponentType().equals(genericComponentType);
        }
        return false;
    }

    public static JSONWriter of() {
        Context context = new Context(JSONFactory.defaultObjectWriterProvider);
        return JDKUtils.JVM_VERSION == 8
                ? (JDKUtils.FIELD_STRING_VALUE == null || JDKUtils.ANDROID || JDKUtils.OPENJ9)
                        ? new JSONWriterUTF16JDK8(context)
                        : new JSONWriterUTF16JDK8UF(context)
                : (JSONFactory.defaultWriterFeatures & Feature.OptimizedForAscii.mask) != 0 ? ofUTF8(context)
                        : (JDKUtils.FIELD_STRING_VALUE == null || JDKUtils.STRING_CODER == null
                                || JDKUtils.STRING_VALUE == null) ? new JSONWriterUTF16(context)
                                        : new JSONWriterUTF16JDK9UF(context);
    }

    public static JSONWriter ofJSONB() {
        return new JSONWriterJSONB(new Context(JSONFactory.defaultObjectWriterProvider), null);
    }

    public static JSONWriter ofPretty() {
        return of(Feature.PrettyFormat);
    }

    public static JSONWriter ofUTF16(Feature... featureArr) {
        Context contextCreateWriteContext = JSONFactory.createWriteContext(featureArr);
        return JDKUtils.JVM_VERSION == 8
                ? (JDKUtils.FIELD_STRING_VALUE == null || JDKUtils.ANDROID || JDKUtils.OPENJ9)
                        ? new JSONWriterUTF16JDK8(contextCreateWriteContext)
                        : new JSONWriterUTF16JDK8UF(contextCreateWriteContext)
                : (JDKUtils.FIELD_STRING_VALUE == null || JDKUtils.STRING_CODER == null
                        || JDKUtils.STRING_VALUE == null) ? new JSONWriterUTF16(contextCreateWriteContext)
                                : new JSONWriterUTF16JDK9UF(contextCreateWriteContext);
    }

    public static JSONWriter ofUTF8() {
        return ofUTF8(JSONFactory.createWriteContext());
    }

    public final void addManagerReference(Object obj) {
        if (this.refs == null) {
            this.refs = new IdentityHashMap<>(8);
        }
        this.refs.putIfAbsent(obj, Path.MANGER_REFERNCE);
    }

    public final void checkAndWriteTypeName(Object obj, Class cls) {
        Class<?> cls2;
        long j = this.context.features;
        if ((Feature.WriteClassName.mask & j) == 0 || obj == null || (cls2 = obj.getClass()) == cls) {
            return;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j) == 0
                || !(cls2 == HashMap.class || cls2 == ArrayList.class)) {
            if ((j & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject) {
                writeTypeName(TypeUtils.getTypeName(cls2));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public final void config(Feature... featureArr) {
        this.context.config(featureArr);
    }

    public final boolean containsReference(Object obj) {
        IdentityHashMap<Object, Path> identityHashMap = this.refs;
        return identityHashMap != null && identityHashMap.containsKey(obj);
    }

    public final void decrementIdent() {
        this.level--;
    }

    public abstract void endArray();

    public abstract void endObject();

    public abstract Object ensureCapacity(int i);

    public abstract int flushTo(OutputStream outputStream);

    public abstract int flushTo(OutputStream outputStream, Charset charset);

    public void flushTo(Writer writer) {
        try {
            writer.write(toString());
            this.off = 0;
        } catch (IOException e) {
            throw new JSONException("flushTo error", e);
        }
    }

    public Object getAttachment() {
        return this.attachment;
    }

    public abstract byte[] getBytes();

    public abstract byte[] getBytes(Charset charset);

    public final Charset getCharset() {
        return this.charset;
    }

    public final Context getContext() {
        return this.context;
    }

    public final long getFeatures() {
        return this.context.features;
    }

    public final ObjectWriter getObjectWriter(Class cls) {
        Context context = this.context;
        return context.provider.getObjectWriter(cls, cls, (context.features & Feature.FieldBased.mask) != 0);
    }

    public int getOffset() {
        return this.off;
    }

    public final String getPath(Object obj) {
        Path path;
        IdentityHashMap<Object, Path> identityHashMap = this.refs;
        return (identityHashMap == null || (path = identityHashMap.get(obj)) == null) ? "$" : path.toString();
    }

    public final SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public final boolean hasFilter() {
        return this.context.hasFilter;
    }

    public final void incrementIndent() {
        this.level++;
    }

    public final boolean isBeanToArray() {
        return (this.context.features & Feature.BeanToArray.mask) != 0;
    }

    public final boolean isEnabled(Feature feature) {
        return (this.context.features & feature.mask) != 0;
    }

    public final boolean isIgnoreErrorGetter() {
        return (this.context.features & Feature.IgnoreErrorGetter.mask) != 0;
    }

    public final boolean isIgnoreNoneSerializable() {
        return (this.context.features & Feature.IgnoreNoneSerializable.mask) != 0;
    }

    public final boolean isRefDetect() {
        long j = this.context.features;
        return (Feature.ReferenceDetection.mask & j) != 0 && (j & FieldInfo.DISABLE_REFERENCE_DETECT) == 0;
    }

    public final boolean isUTF16() {
        return this.utf16;
    }

    public final boolean isUTF8() {
        return this.utf8;
    }

    public final boolean isUseSingleQuotes() {
        return this.useSingleQuote;
    }

    public final boolean isWriteMapTypeInfo(Object obj, Class cls, long j) {
        Class<?> cls2;
        if (obj == null || (cls2 = obj.getClass()) == cls) {
            return false;
        }
        long j2 = j | this.context.features;
        if ((Feature.WriteClassName.mask & j2) == 0) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j2) == 0 || cls2 != HashMap.class) {
            return (j2 & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
        }
        return false;
    }

    public final boolean isWriteNulls() {
        return (this.context.features & Feature.WriteNulls.mask) != 0;
    }

    public final boolean isWriteTypeInfo(Object obj, Class cls) {
        Class<?> cls2;
        long j = this.context.features;
        if ((Feature.WriteClassName.mask & j) == 0 || obj == null || (cls2 = obj.getClass()) == cls) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j) == 0
                || !(cls2 == HashMap.class || cls2 == ArrayList.class)) {
            return (j & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
        }
        return false;
    }

    public final int level() {
        return this.level;
    }

    public final int newCapacity(int i, int i2) {
        int i3 = i2 + (i2 >> 1);
        if (i3 - i < 0) {
            i3 = i;
        }
        int i4 = this.maxArraySize;
        if (i3 <= i4) {
            return i3;
        }
        if (i < i4) {
            return i4;
        }
        StringBuilder sbR = yg.r(i,
                "Maximum array size exceeded. Try enabling LargeObject feature instead. Requested size: ",
                ", max size: ");
        sbR.append(this.maxArraySize);
        throw new JSONLargeObjectException(sbR.toString());
    }

    public final void overflowLevel() {
        throw new JSONException("level too large : " + this.level);
    }

    public final void popPath(Object obj) {
        if (isRefDetect(obj)) {
            popPath0(obj);
        }
    }

    public final void popPath0(Object obj) {
        Path path = this.path;
        if (path == null || (this.context.features & MASK_REFERENCE_DETECTION) == 0 || obj == Collections.EMPTY_LIST
                || obj == Collections.EMPTY_SET) {
            return;
        }
        this.path = path.parent;
    }

    public void println() {
        writeRaw('\n');
        for (int i = 0; i < this.level; i++) {
            writeRaw('\t');
        }
    }

    public final boolean removeReference(Object obj) {
        IdentityHashMap<Object, Path> identityHashMap = this.refs;
        return (identityHashMap == null || identityHashMap.remove(obj) == null) ? false : true;
    }

    public void setAttachment(Object obj) {
        this.attachment = obj;
    }

    public void setOffset(int i) {
        this.off = i;
    }

    public final String setPath(String str, Object obj) {
        Path path;
        if (!isRefDetect(obj)) {
            return null;
        }
        this.path = new Path(this.path, str);
        if (obj == this.rootObject) {
            path = Path.ROOT;
        } else {
            IdentityHashMap<Object, Path> identityHashMap = this.refs;
            if (identityHashMap == null || (path = identityHashMap.get(obj)) == null) {
                if (this.refs == null) {
                    this.refs = new IdentityHashMap<>(8);
                }
                this.refs.put(obj, this.path);
                return null;
            }
        }
        return path.toString();
    }

    public final String setPath0(FieldWriter fieldWriter, Object obj) {
        IdentityHashMap<Object, Path> identityHashMap;
        Path path = this.path;
        Path path2 = Path.ROOT;
        this.path = path == path2 ? fieldWriter.getRootParentPath() : fieldWriter.getPath(path);
        if (obj == this.rootObject
                || ((identityHashMap = this.refs) != null && (path2 = identityHashMap.get(obj)) != null)) {
            return path2.toString();
        }
        if (this.refs == null) {
            this.refs = new IdentityHashMap<>(8);
        }
        this.refs.put(obj, this.path);
        return null;
    }

    public final void setRootObject(Object obj) {
        this.rootObject = obj;
        this.path = Path.ROOT;
    }

    public abstract int size();

    public abstract void startArray();

    public void startArray(int i) {
        throw new JSONException("UnsupportedOperation");
    }

    public void startArray0() {
        startArray(0);
    }

    public void startArray1() {
        startArray(1);
    }

    public void startArray10() {
        startArray(10);
    }

    public void startArray11() {
        startArray(11);
    }

    public void startArray12() {
        startArray(12);
    }

    public void startArray13() {
        startArray(13);
    }

    public void startArray14() {
        startArray(14);
    }

    public void startArray15() {
        startArray(15);
    }

    public void startArray2() {
        startArray(2);
    }

    public void startArray3() {
        startArray(3);
    }

    public void startArray4() {
        startArray(4);
    }

    public void startArray5() {
        startArray(5);
    }

    public void startArray6() {
        startArray(6);
    }

    public void startArray7() {
        startArray(7);
    }

    public void startArray8() {
        startArray(8);
    }

    public void startArray9() {
        startArray(9);
    }

    public abstract void startObject();

    public final void write(JSONObject jSONObject) {
        write((Map<?, ?>) jSONObject);
    }

    public abstract void write(List list);

    public abstract void write0(char c);

    public void writeAny(Object obj) {
        if (obj == null) {
            writeNull();
        } else {
            Class<?> cls = obj.getClass();
            this.context.getObjectWriter(cls, cls).write(this, obj, null, null, 0L);
        }
    }

    public void writeArrayNull() {
        writeArrayNull(this.context.features);
    }

    public final void writeAs(Object obj, Class cls) {
        if (obj == null) {
            writeNull();
        } else {
            this.context.getObjectWriter(cls).write(this, obj, null, null, 0L);
        }
    }

    public abstract void writeBase64(byte[] bArr);

    public final void writeBigInt(BigInteger bigInteger) {
        writeBigInt(bigInteger, 0L);
    }

    public abstract void writeBigInt(BigInteger bigInteger, long j);

    public void writeBinary(byte[] bArr) {
        if (bArr == null) {
            writeArrayNull();
            return;
        }
        if ((this.context.features & Feature.WriteByteArrayAsBase64.mask) != 0) {
            writeBase64(bArr);
            return;
        }
        startArray();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeInt32(bArr[i]);
        }
        endArray();
    }

    public abstract void writeBool(boolean z);

    public void writeBool(boolean[] zArr) {
        if (zArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < zArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeBool(zArr[i]);
        }
        endArray();
    }

    public final void writeBooleanNull() {
        if ((this.context.features & (Feature.WriteNullBooleanAsFalse.mask | MASK_NULL_AS_DEFAULT_VALUE)) != 0) {
            writeBool(false);
        } else {
            writeNull();
        }
    }

    public abstract void writeChar(char c);

    public abstract void writeColon();

    public abstract void writeComma();

    public abstract void writeDateTime14(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void writeDateTime19(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void writeDateTimeISO8601(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z);

    public abstract void writeDateYYYMMDD10(int i, int i2, int i3);

    public abstract void writeDateYYYMMDD8(int i, int i2, int i3);

    public final void writeDecimal(BigDecimal bigDecimal) {
        writeDecimal(bigDecimal, 0L, null);
    }

    public abstract void writeDecimal(BigDecimal bigDecimal, long j, DecimalFormat decimalFormat);

    public final void writeDecimalNull() {
        writeDecimalNull(this.context.features);
    }

    public abstract void writeDouble(double d);

    public final void writeDouble(double d, DecimalFormat decimalFormat) {
        if (decimalFormat == null || this.jsonb) {
            writeDouble(d);
        } else if (Double.isNaN(d) || Double.isInfinite(d)) {
            writeNull();
        } else {
            writeRaw(decimalFormat.format(d));
        }
    }

    public abstract void writeDouble(double[] dArr);

    public void writeDoubleArray(double d, double d2) {
        startArray();
        writeDouble(d);
        writeComma();
        writeDouble(d2);
        endArray();
    }

    public void writeEnum(Enum r7) {
        if (r7 == null) {
            writeNull();
            return;
        }
        long j = this.context.features;
        if ((Feature.WriteEnumUsingToString.mask & j) != 0) {
            writeString(r7.toString());
        } else if ((j & Feature.WriteEnumsUsingName.mask) != 0) {
            writeString(r7.name());
        } else {
            writeInt32(r7.ordinal());
        }
    }

    public abstract void writeFloat(float f);

    public final void writeFloat(float f, DecimalFormat decimalFormat) {
        if (decimalFormat == null || this.jsonb) {
            writeFloat(f);
        } else if (Float.isNaN(f) || Float.isInfinite(f)) {
            writeNull();
        } else {
            writeRaw(decimalFormat.format(f));
        }
    }

    public abstract void writeFloat(float[] fArr);

    public abstract void writeHex(byte[] bArr);

    public void writeInstant(Instant instant) {
        if (instant == null) {
            writeNull();
        } else {
            writeString(DateTimeFormatter.ISO_INSTANT.format(instant));
        }
    }

    public abstract void writeInt16(short s);

    public void writeInt16(short[] sArr) {
        if (sArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < sArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeInt16(sArr[i]);
        }
        endArray();
    }

    public abstract void writeInt32(int i);

    public final void writeInt32(int i, DecimalFormat decimalFormat) {
        if (decimalFormat == null || this.jsonb) {
            writeInt32(i);
        } else {
            writeString(decimalFormat.format(i));
        }
    }

    public abstract void writeInt32(Integer num);

    public abstract void writeInt32(int[] iArr);

    public abstract void writeInt64(long j);

    public abstract void writeInt64(Long l);

    public abstract void writeInt64(long[] jArr);

    public final void writeInt64Null() {
        if ((this.context.features & 16777280) != 0) {
            writeInt64(0L);
        } else {
            writeNull();
        }
    }

    public abstract void writeInt8(byte b);

    public abstract void writeInt8(byte[] bArr);

    public abstract void writeListInt32(List<Integer> list);

    public abstract void writeListInt64(List<Long> list);

    public abstract void writeLocalDate(LocalDate localDate);

    public abstract void writeLocalDateTime(LocalDateTime localDateTime);

    public final boolean writeLocalDateWithFormat(LocalDate localDate) {
        Context context = this.context;
        if (context.dateFormatUnixTime || context.dateFormatMillis) {
            long epochMilli = LocalDateTime.of(localDate, LocalTime.MIN).atZone(context.getZoneId()).toInstant()
                    .toEpochMilli();
            if (!context.dateFormatMillis) {
                epochMilli /= 1000;
            }
            writeInt64(epochMilli);
            return true;
        }
        DateTimeFormatter dateFormatter = context.getDateFormatter();
        if (dateFormatter == null) {
            return false;
        }
        writeString(context.isDateFormatHasHour() ? dateFormatter.format(LocalDateTime.of(localDate, LocalTime.MIN))
                : dateFormatter.format(localDate));
        return true;
    }

    public abstract void writeLocalTime(LocalTime localTime);

    public void writeMillis(long j) {
        writeInt64(j);
    }

    public void writeName(String str) {
        boolean z = false;
        if (this.startObject) {
            this.startObject = false;
        } else {
            writeComma();
        }
        boolean z2 = (this.context.features & Feature.UnquoteFieldName.mask) != 0;
        if (!z2 || (str.indexOf(this.quote) < 0 && str.indexOf(92) < 0)) {
            z = z2;
        }
        if (z) {
            writeRaw(str);
        } else {
            writeString(str);
        }
    }

    public abstract void writeName10Raw(long j, long j2);

    public abstract void writeName11Raw(long j, long j2);

    public abstract void writeName12Raw(long j, long j2);

    public abstract void writeName13Raw(long j, long j2);

    public abstract void writeName14Raw(long j, long j2);

    public abstract void writeName15Raw(long j, long j2);

    public abstract void writeName16Raw(long j, long j2);

    public abstract void writeName2Raw(long j);

    public abstract void writeName3Raw(long j);

    public abstract void writeName4Raw(long j);

    public abstract void writeName5Raw(long j);

    public abstract void writeName6Raw(long j);

    public abstract void writeName7Raw(long j);

    public abstract void writeName8Raw(long j);

    public abstract void writeName9Raw(long j, int i);

    public void writeNameAny(Object obj) {
        if (this.startObject) {
            this.startObject = false;
        } else {
            writeComma();
        }
        writeAny(obj);
    }

    public abstract void writeNameRaw(byte[] bArr);

    public void writeNameRaw(byte[] bArr, int i, int i2) {
        throw new JSONException("UnsupportedOperation");
    }

    public abstract void writeNameRaw(char[] cArr);

    public abstract void writeNameRaw(char[] cArr, int i, int i2);

    public final void writeNameValue(String str, Object obj) {
        writeName(str);
        writeColon();
        writeAny(obj);
    }

    public abstract void writeNull();

    public final void writeNumberNull() {
        writeNumberNull(this.context.features);
    }

    public void writeObjectNull(Class<?> cls) {
        if ((this.context.features & MASK_NULL_AS_DEFAULT_VALUE) == 0) {
            writeNull();
        } else if (cls == Character.class) {
            writeString("\u0000");
        } else {
            writeRaw('{', '}');
        }
    }

    public abstract void writeOffsetDateTime(OffsetDateTime offsetDateTime);

    public abstract void writeOffsetTime(OffsetTime offsetTime);

    public void writeRaw(byte b) {
        throw new JSONException("UnsupportedOperation");
    }

    public abstract void writeRaw(char c);

    public abstract void writeRaw(String str);

    public abstract void writeRaw(byte[] bArr);

    public abstract void writeReference(String str);

    public final boolean writeReference(int i, Object obj) {
        String path = setPath(i, obj);
        if (path == null) {
            return false;
        }
        writeReference(path);
        popPath(obj);
        return true;
    }

    public abstract void writeString(byte b);

    public abstract void writeString(int i);

    public abstract void writeString(long j);

    public final void writeString(Reader reader) {
        writeRaw(this.quote);
        try {
            char[] cArr = new char[2048];
            while (true) {
                int i = reader.read(cArr, 0, 2048);
                if (i < 0) {
                    writeRaw(this.quote);
                    return;
                } else if (i > 0) {
                    writeString(cArr, 0, i, false);
                }
            }
        } catch (Exception e) {
            throw new JSONException("read string from reader error", e);
        }
    }

    public abstract void writeString(String str);

    public abstract void writeString(short s);

    public abstract void writeString(boolean z);

    public abstract void writeString(char[] cArr);

    public abstract void writeString(char[] cArr, int i, int i2);

    public abstract void writeString(char[] cArr, int i, int i2, boolean z);

    public abstract void writeStringLatin1(byte[] bArr);

    public void writeStringNull() {
        long j = this.context.features;
        writeRaw((8388672 & j) != 0 ? (j & MASK_USE_SINGLE_QUOTES) != 0 ? "''" : "\"\"" : "null");
    }

    public abstract void writeStringUTF16(byte[] bArr);

    public void writeSymbol(int i) {
        throw new JSONException("UnsupportedOperation");
    }

    public abstract void writeTimeHHMMSS8(int i, int i2, int i3);

    public void writeTypeName(String str) {
        throw new JSONException("UnsupportedOperation");
    }

    public abstract void writeUUID(UUID uuid);

    public abstract void writeZonedDateTime(ZonedDateTime zonedDateTime);

    public static boolean isWriteAsString(BigInteger bigInteger, long j) {
        if ((MASK_WRITE_NON_STRING_VALUE_AS_STRING & j) == 0) {
            return ((j & MASK_BROWSER_COMPATIBLE) == 0 || TypeUtils.isJavaScriptSupport(bigInteger)) ? false : true;
        }
        return true;
    }

    public static JSONWriter ofJSONB(Context context) {
        return new JSONWriterJSONB(context, null);
    }

    public static JSONWriter ofPretty(JSONWriter jSONWriter) {
        if (jSONWriter.pretty == 0) {
            jSONWriter.pretty = (byte) 1;
            jSONWriter.context.features |= Feature.PrettyFormat.mask;
        }
        return jSONWriter;
    }

    public final void config(Feature feature, boolean z) {
        this.context.config(feature, z);
    }

    public final long getFeatures(long j) {
        return j | this.context.features;
    }

    public final boolean hasFilter(long j) {
        Context context = this.context;
        return context.hasFilter || (j & context.features) != 0;
    }

    public final boolean isEnabled(long j) {
        return (j & this.context.features) != 0;
    }

    public final boolean isIgnoreNoneSerializable(Object obj) {
        return ((this.context.features & Feature.IgnoreNoneSerializable.mask) == 0 || obj == null
                || Serializable.class.isAssignableFrom(obj.getClass())) ? false : true;
    }

    public final boolean isRefDetect(Object obj) {
        long j = this.context.features;
        return ((Feature.ReferenceDetection.mask & j) == 0 || (j & FieldInfo.DISABLE_REFERENCE_DETECT) != 0
                || obj == null || ObjectWriterProvider.isNotReferenceDetect(obj.getClass())) ? false : true;
    }

    public void startArray(Object obj, int i) {
        throw new JSONException("UnsupportedOperation");
    }

    public void write(Map<?, ?> map) {
        if (map == null) {
            writeNull();
            return;
        }
        if (map.isEmpty()) {
            writeRaw('{', '}');
            return;
        }
        Context context = this.context;
        if ((context.features & NONE_DIRECT_FEATURES) != 0) {
            context.getObjectWriter(map.getClass()).write(this, map, null, null, 0L);
            return;
        }
        startObject();
        boolean z = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null || (this.context.features & Feature.WriteMapNullValue.mask) != 0) {
                if (!z) {
                    writeComma();
                }
                Object key = entry.getKey();
                if (key instanceof String) {
                    writeString((String) key);
                } else {
                    writeAny(key);
                }
                writeColon();
                if (value == null) {
                    writeNull();
                } else {
                    Class<?> cls = value.getClass();
                    if (cls == String.class) {
                        writeString((String) value);
                    } else if (cls == Integer.class) {
                        writeInt32((Integer) value);
                    } else if (cls == Long.class) {
                        writeInt64((Long) value);
                    } else if (cls == Boolean.class) {
                        writeBool(((Boolean) value).booleanValue());
                    } else if (cls == BigDecimal.class) {
                        writeDecimal((BigDecimal) value, 0L, null);
                    } else if (cls == JSONArray.class) {
                        write((JSONArray) value);
                    } else if (cls == JSONObject.class) {
                        write((JSONObject) value);
                    } else {
                        this.context.getObjectWriter(cls, cls).write(this, value, null, null, 0L);
                    }
                }
                z = false;
            }
        }
        endObject();
    }

    public void writeArrayNull(long j) {
        writeRaw((j & 4194368) != 0 ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : "null");
    }

    public final void writeDecimal(BigDecimal bigDecimal, long j) {
        writeDecimal(bigDecimal, j, null);
    }

    public final void writeDecimalNull(long j) {
        if ((MASK_NULL_AS_DEFAULT_VALUE & j) != 0) {
            writeDouble(0.0d);
        } else if ((j & MASK_WRITE_NULL_NUMBER_AS_ZERO) != 0) {
            writeInt32(0);
        } else {
            writeNull();
        }
    }

    public void writeNameRaw(byte[] bArr, long j) {
        throw new JSONException("UnsupportedOperation");
    }

    public final void writeNumberNull(long j) {
        if ((j & 16777280) != 0) {
            writeInt32(0);
        } else {
            writeNull();
        }
    }

    public final void writeRaw(char[] cArr) {
        writeRaw(cArr, 0, cArr.length);
    }

    public void writeSymbol(String str) {
        writeString(str);
    }

    public boolean writeTypeName(byte[] bArr, long j) {
        throw new JSONException("UnsupportedOperation");
    }

    public static boolean isWriteAsString(BigDecimal bigDecimal, long j) {
        if ((MASK_WRITE_NON_STRING_VALUE_AS_STRING & j) == 0) {
            return ((j & MASK_BROWSER_COMPATIBLE) == 0 || TypeUtils.isJavaScriptSupport(bigDecimal)) ? false : true;
        }
        return true;
    }

    public static JSONWriter ofJSONB(Context context, SymbolTable symbolTable) {
        return new JSONWriterJSONB(context, symbolTable);
    }

    public static JSONWriter ofUTF8(Context context) {
        return new JSONWriterUTF8(context);
    }

    public final ObjectWriter getObjectWriter(Class cls, String str) {
        Context context = this.context;
        return context.provider.getObjectWriter(cls, cls, str, (context.features & Feature.FieldBased.mask) != 0);
    }

    public final boolean hasFilter(boolean z) {
        Context context = this.context;
        if (context.hasFilter) {
            return true;
        }
        return z && (context.features & Feature.IgnoreNonFieldGetter.mask) != 0;
    }

    public void writeRaw(char[] cArr, int i, int i2) {
        throw new JSONException("UnsupportedOperation");
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Path {
        Path child0;
        Path child1;
        String fullPath;
        final int index;
        final String name;
        public final Path parent;
        public static final Path ROOT = new Path((Path) null, "$");
        public static final Path MANGER_REFERNCE = new Path((Path) null, "#");

        public Path(Path path, String str) {
            this.parent = path;
            this.name = str;
            this.index = -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Path.class == obj.getClass()) {
                Path path = (Path) obj;
                if (this.index == path.index && Objects.equals(this.parent, path.parent)
                        && Objects.equals(this.name, path.name)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.parent, this.name, Integer.valueOf(this.index));
        }

        /* JADX WARN: Found duplicated region for block: B:139:0x02c9 A[FALL_THROUGH] */
        /* JADX WARN: Found duplicated region for block: B:141:0x02d6 */
        /* JADX WARN: Found duplicated region for block: B:142:0x02e2 */
        /* JADX WARN: Found duplicated region for block: B:81:0x018e A[FALL_THROUGH] */
        /* JADX WARN: Found duplicated region for block: B:83:0x0195 */
        public String toString() {
            char c;
            int i;
            int i2;
            int i3;
            int i4;
            char c2;
            int i5;
            int i6;
            int i7;
            String str = this.fullPath;
            if (str != null) {
                return str;
            }
            byte[] bArrCopyOf = new byte[16];
            Path[] pathArr = new Path[4];
            int i8 = 0;
            for (Path path = this; path != null; path = path.parent) {
                if (pathArr.length == i8) {
                    pathArr = (Path[]) Arrays.copyOf(pathArr, pathArr.length + 4);
                }
                pathArr[i8] = path;
                i8++;
            }
            char c3 = 1;
            int i9 = i8 - 1;
            boolean z = true;
            int i10 = i9;
            int i11 = 0;
            while (i10 >= 0) {
                Path path2 = pathArr[i10];
                String str2 = path2.name;
                if (str2 == null) {
                    int i12 = path2.index;
                    int iStringSize = IOUtils.stringSize(i12);
                    while (i11 + iStringSize + 2 >= bArrCopyOf.length) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + (bArrCopyOf.length >> c3));
                    }
                    bArrCopyOf[i11] = 91;
                    int i13 = i11 + 1 + iStringSize;
                    IOUtils.getChars(i12, i13, bArrCopyOf);
                    i11 = i13 + 1;
                    bArrCopyOf[i13] = 93;
                } else {
                    int i14 = i11 + 1;
                    if (i14 >= bArrCopyOf.length) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + (bArrCopyOf.length >> c3));
                    }
                    if (i10 != i9) {
                        bArrCopyOf[i11] = 46;
                        i11 = i14;
                    }
                    char c4 = 55296;
                    char c5 = 127;
                    char c6 = '~';
                    if (JDKUtils.JVM_VERSION == 8) {
                        char[] charArray = JDKUtils.getCharArray(str2);
                        int i15 = 0;
                        while (i15 < charArray.length) {
                            char c7 = charArray[i15];
                            if (c7 != '`' && c7 != '~') {
                                switch (c7) {
                                    default:
                                        switch (c7) {
                                            default:
                                                switch (c7) {
                                                    default:
                                                        switch (c7) {
                                                            case '[':
                                                            case '\\':
                                                            case ']':
                                                            case '^':
                                                                break;
                                                            default:
                                                                if (c7 < c3 || c7 > c5) {
                                                                    c2 = c3;
                                                                    if (c7 >= c4 && c7 < 57344) {
                                                                        if (c7 < 56320) {
                                                                            if (str2.length() - i15 < 2) {
                                                                                i7 = -1;
                                                                            } else {
                                                                                char cCharAt = str2.charAt(i15 + 1);
                                                                                if (cCharAt < 56320
                                                                                        || cCharAt >= 57344) {
                                                                                    i6 = i11 + 1;
                                                                                    bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                                } else {
                                                                                    i7 = ((c7 << '\n') + cCharAt)
                                                                                            - 56613888;
                                                                                }
                                                                            }
                                                                            if (i7 < 0) {
                                                                                if (i11 == bArrCopyOf.length) {
                                                                                    bArrCopyOf = Arrays.copyOf(
                                                                                            bArrCopyOf,
                                                                                            bArrCopyOf.length
                                                                                                    + (bArrCopyOf.length >> 1));
                                                                                }
                                                                                i6 = i11 + 1;
                                                                                bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                            } else {
                                                                                int i16 = i11 + 3;
                                                                                if (i16 >= bArrCopyOf.length) {
                                                                                    bArrCopyOf = Arrays.copyOf(
                                                                                            bArrCopyOf,
                                                                                            bArrCopyOf.length
                                                                                                    + (bArrCopyOf.length >> 1));
                                                                                }
                                                                                bArrCopyOf[i11] = (byte) ((i7 >> 18)
                                                                                        | 240);
                                                                                bArrCopyOf[i11
                                                                                        + 1] = (byte) (((i7 >> 12) & 63)
                                                                                                | 128);
                                                                                bArrCopyOf[i11
                                                                                        + 2] = (byte) (((i7 >> 6) & 63)
                                                                                                | 128);
                                                                                bArrCopyOf[i16] = (byte) ((i7 & 63)
                                                                                        | 128);
                                                                                i6 = i11 + 4;
                                                                                i15++;
                                                                            }
                                                                        } else {
                                                                            i6 = i11 + 1;
                                                                            bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                        }
                                                                        i11 = i6;
                                                                    } else if (c7 > 2047) {
                                                                        int i17 = i11 + 2;
                                                                        if (i17 >= bArrCopyOf.length) {
                                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                    bArrCopyOf.length
                                                                                            + (bArrCopyOf.length >> 1));
                                                                        }
                                                                        bArrCopyOf[i11] = (byte) (((c7 >> '\f') & 15)
                                                                                | Opcodes.SHL_INT_LIT8);
                                                                        bArrCopyOf[i11
                                                                                + 1] = (byte) (((c7 >> 6) & 63) | 128);
                                                                        bArrCopyOf[i17] = (byte) ((c7 & '?') | 128);
                                                                        i11 += 3;
                                                                    } else {
                                                                        int i18 = i11 + 1;
                                                                        if (i18 >= bArrCopyOf.length) {
                                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                    bArrCopyOf.length
                                                                                            + (bArrCopyOf.length >> 1));
                                                                        }
                                                                        bArrCopyOf[i11] = (byte) (((c7 >> 6) & 31)
                                                                                | 192);
                                                                        bArrCopyOf[i18] = (byte) ((c7 & '?') | 128);
                                                                        i11 += 2;
                                                                    }
                                                                    z = false;
                                                                } else {
                                                                    if (i11 == bArrCopyOf.length) {
                                                                        c2 = c3;
                                                                        bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                bArrCopyOf.length
                                                                                        + (bArrCopyOf.length >> 1));
                                                                    } else {
                                                                        c2 = c3;
                                                                    }
                                                                    bArrCopyOf[i11] = (byte) c7;
                                                                    i11++;
                                                                }
                                                                break;
                                                        }
                                                    case ':':
                                                    case ';':
                                                    case '<':
                                                    case '=':
                                                    case '>':
                                                    case '?':
                                                    case '@':
                                                        c2 = c3;
                                                        i5 = i11 + 1;
                                                        if (i5 >= bArrCopyOf.length) {
                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                    bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                                        }
                                                        bArrCopyOf[i11] = 92;
                                                        bArrCopyOf[i5] = (byte) c7;
                                                        i11 += 2;
                                                        break;
                                                }
                                            case '%':
                                            case '&':
                                            case '\'':
                                            case '(':
                                            case ')':
                                            case '*':
                                            case '+':
                                            case ',':
                                            case '-':
                                            case '.':
                                            case '/':
                                                c2 = c3;
                                                i5 = i11 + 1;
                                                if (i5 >= bArrCopyOf.length) {
                                                    bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                            bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                                }
                                                bArrCopyOf[i11] = 92;
                                                bArrCopyOf[i5] = (byte) c7;
                                                i11 += 2;
                                                break;
                                        }
                                    case '!':
                                    case '\"':
                                    case '#':
                                        c2 = c3;
                                        i5 = i11 + 1;
                                        if (i5 >= bArrCopyOf.length) {
                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                    bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                        }
                                        bArrCopyOf[i11] = 92;
                                        bArrCopyOf[i5] = (byte) c7;
                                        i11 += 2;
                                        break;
                                }
                            } else {
                                c2 = c3;
                                i5 = i11 + 1;
                                if (i5 >= bArrCopyOf.length) {
                                    bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                            bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                }
                                bArrCopyOf[i11] = 92;
                                bArrCopyOf[i5] = (byte) c7;
                                i11 += 2;
                            }
                            i15++;
                            c3 = c2;
                            c5 = 127;
                            c4 = 55296;
                        }
                    } else {
                        c = c3;
                        int i19 = 0;
                        while (i19 < str2.length()) {
                            char cCharAt2 = str2.charAt(i19);
                            if (cCharAt2 != '`' && cCharAt2 != c6) {
                                switch (cCharAt2) {
                                    default:
                                        switch (cCharAt2) {
                                            default:
                                                switch (cCharAt2) {
                                                    default:
                                                        switch (cCharAt2) {
                                                            case '[':
                                                            case '\\':
                                                            case ']':
                                                            case '^':
                                                                break;
                                                            default:
                                                                char c8 = c;
                                                                if (cCharAt2 < c8 || cCharAt2 > 127) {
                                                                    if (cCharAt2 >= 55296 && cCharAt2 < 57344) {
                                                                        if (cCharAt2 < 56320) {
                                                                            if (str2.length() - i19 < 2) {
                                                                                i3 = -1;
                                                                            } else {
                                                                                char cCharAt3 = str2.charAt(i19 + 1);
                                                                                if (cCharAt3 < 56320
                                                                                        || cCharAt3 >= 57344) {
                                                                                    i2 = i11 + 1;
                                                                                    bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                                } else {
                                                                                    i3 = ((cCharAt2 << '\n') + cCharAt3)
                                                                                            - 56613888;
                                                                                }
                                                                            }
                                                                            if (i3 < 0) {
                                                                                if (i11 == bArrCopyOf.length) {
                                                                                    bArrCopyOf = Arrays.copyOf(
                                                                                            bArrCopyOf,
                                                                                            bArrCopyOf.length
                                                                                                    + (bArrCopyOf.length >> 1));
                                                                                }
                                                                                i4 = i11 + 1;
                                                                                bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                            } else {
                                                                                i4 = i11 + 4;
                                                                                if (i4 >= bArrCopyOf.length) {
                                                                                    bArrCopyOf = Arrays.copyOf(
                                                                                            bArrCopyOf,
                                                                                            bArrCopyOf.length
                                                                                                    + (bArrCopyOf.length >> 1));
                                                                                }
                                                                                bArrCopyOf[i11] = (byte) ((i3 >> 18)
                                                                                        | 240);
                                                                                bArrCopyOf[i11
                                                                                        + 1] = (byte) (((i3 >> 12) & 63)
                                                                                                | 128);
                                                                                bArrCopyOf[i11
                                                                                        + 2] = (byte) (((i3 >> 6) & 63)
                                                                                                | 128);
                                                                                bArrCopyOf[i11
                                                                                        + 3] = (byte) ((i3 & 63) | 128);
                                                                                i19++;
                                                                            }
                                                                            i11 = i4;
                                                                        } else {
                                                                            i2 = i11 + 1;
                                                                            bArrCopyOf[i11] = JSONB.Constants.BC_INT32_BYTE_MAX;
                                                                        }
                                                                        i11 = i2;
                                                                    } else if (cCharAt2 > 2047) {
                                                                        int i20 = i11 + 2;
                                                                        if (i20 >= bArrCopyOf.length) {
                                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                    bArrCopyOf.length
                                                                                            + (bArrCopyOf.length >> 1));
                                                                        }
                                                                        bArrCopyOf[i11] = (byte) (((cCharAt2 >> '\f')
                                                                                & 15) | Opcodes.SHL_INT_LIT8);
                                                                        bArrCopyOf[i11
                                                                                + 1] = (byte) (((cCharAt2 >> 6) & 63)
                                                                                        | 128);
                                                                        bArrCopyOf[i20] = (byte) ((cCharAt2 & '?')
                                                                                | 128);
                                                                        i11 += 3;
                                                                    } else {
                                                                        int i21 = i11 + 1;
                                                                        if (i21 >= bArrCopyOf.length) {
                                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                    bArrCopyOf.length
                                                                                            + (bArrCopyOf.length >> 1));
                                                                        }
                                                                        bArrCopyOf[i11] = (byte) (((cCharAt2 >> 6) & 31)
                                                                                | 192);
                                                                        bArrCopyOf[i21] = (byte) ((cCharAt2 & '?')
                                                                                | 128);
                                                                        i11 += 2;
                                                                    }
                                                                    z = false;
                                                                } else {
                                                                    if (i11 == bArrCopyOf.length) {
                                                                        bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                                bArrCopyOf.length
                                                                                        + (bArrCopyOf.length >> c8));
                                                                    }
                                                                    bArrCopyOf[i11] = (byte) cCharAt2;
                                                                    i11++;
                                                                }
                                                                c = 1;
                                                                break;
                                                        }
                                                    case ':':
                                                    case ';':
                                                    case '<':
                                                    case '=':
                                                    case '>':
                                                    case '?':
                                                    case '@':
                                                        i = i11 + 1;
                                                        if (i >= bArrCopyOf.length) {
                                                            c = 1;
                                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                                    bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                                        } else {
                                                            c = 1;
                                                        }
                                                        bArrCopyOf[i11] = 92;
                                                        bArrCopyOf[i] = (byte) cCharAt2;
                                                        i11 += 2;
                                                        break;
                                                }
                                            case '%':
                                            case '&':
                                            case '\'':
                                            case '(':
                                            case ')':
                                            case '*':
                                            case '+':
                                            case ',':
                                            case '-':
                                            case '.':
                                            case '/':
                                                i = i11 + 1;
                                                if (i >= bArrCopyOf.length) {
                                                    c = 1;
                                                    bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                            bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                                } else {
                                                    c = 1;
                                                }
                                                bArrCopyOf[i11] = 92;
                                                bArrCopyOf[i] = (byte) cCharAt2;
                                                i11 += 2;
                                                break;
                                        }
                                    case '!':
                                    case '\"':
                                    case '#':
                                        i = i11 + 1;
                                        if (i >= bArrCopyOf.length) {
                                            c = 1;
                                            bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                                    bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                        } else {
                                            c = 1;
                                        }
                                        bArrCopyOf[i11] = 92;
                                        bArrCopyOf[i] = (byte) cCharAt2;
                                        i11 += 2;
                                        break;
                                }
                            } else {
                                i = i11 + 1;
                                if (i >= bArrCopyOf.length) {
                                    c = 1;
                                    bArrCopyOf = Arrays.copyOf(bArrCopyOf,
                                            bArrCopyOf.length + (bArrCopyOf.length >> 1));
                                } else {
                                    c = 1;
                                }
                                bArrCopyOf[i11] = 92;
                                bArrCopyOf[i] = (byte) cCharAt2;
                                i11 += 2;
                            }
                            i19++;
                            c6 = '~';
                        }
                    }
                    i10--;
                    c3 = c;
                }
                c = c3;
                i10--;
                c3 = c;
            }
            if (z) {
                BiFunction<byte[], Byte, String> biFunction = JDKUtils.STRING_CREATOR_JDK11;
                if (biFunction != null) {
                    if (i11 != bArrCopyOf.length) {
                        byte[] bArr = new byte[i11];
                        System.arraycopy(bArrCopyOf, 0, bArr, 0, i11);
                        bArrCopyOf = bArr;
                    }
                    String strApply = biFunction.apply(bArrCopyOf, JDKUtils.LATIN1);
                    this.fullPath = strApply;
                    return strApply;
                }
                if (JDKUtils.STRING_CREATOR_JDK8 != null) {
                    char[] cArr = new char[i11];
                    for (int i22 = 0; i22 < i11; i22++) {
                        cArr[i22] = (char) bArrCopyOf[i22];
                    }
                    String strApply2 = JDKUtils.STRING_CREATOR_JDK8.apply(cArr, Boolean.TRUE);
                    this.fullPath = strApply2;
                    return strApply2;
                }
            }
            String str3 = new String(bArrCopyOf, 0, i11, z ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8);
            this.fullPath = str3;
            return str3;
        }

        public Path(Path path, int i) {
            this.parent = path;
            this.name = null;
            this.index = i;
        }
    }

    public static JSONWriter ofJSONB(Feature... featureArr) {
        return new JSONWriterJSONB(new Context(JSONFactory.defaultObjectWriterProvider, featureArr), null);
    }

    public static JSONWriter ofUTF8(Feature... featureArr) {
        return ofUTF8(JSONFactory.createWriteContext(featureArr));
    }

    public String getPath() {
        Path path = this.path;
        if (path == null) {
            return null;
        }
        return path.toString();
    }

    public final void writeInt32(int i, String str) {
        if (str != null && !this.jsonb) {
            writeString(String.format(str, Integer.valueOf(i)));
        } else {
            writeInt32(i);
        }
    }

    public void writeRaw(char c, char c2) {
        throw new JSONException("UnsupportedOperation");
    }

    public final void writeReference(Object obj) {
        Path path;
        IdentityHashMap<Object, Path> identityHashMap = this.refs;
        if (identityHashMap == null || (path = identityHashMap.get(obj)) == null) {
            return;
        }
        writeReference(path.toString());
    }

    public static JSONWriter ofJSONB(SymbolTable symbolTable) {
        return new JSONWriterJSONB(new Context(JSONFactory.defaultObjectWriterProvider), symbolTable);
    }

    public final ObjectWriter getObjectWriter(Type type, Class cls) {
        Context context = this.context;
        return context.provider.getObjectWriter(type, cls, (context.features & Feature.FieldBased.mask) != 0);
    }

    public final boolean isWriteTypeInfo(Object obj, Type type) {
        Class<?> cls;
        long j = this.context.features;
        if ((Feature.WriteClassName.mask & j) == 0 || obj == null) {
            return false;
        }
        Class<?> cls2 = obj.getClass();
        if (type instanceof Class) {
            cls = (Class) type;
        } else {
            if (type instanceof GenericArrayType) {
                if (isWriteTypeInfoGenericArray((GenericArrayType) type, cls2)) {
                    return false;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    cls = (Class) rawType;
                }
            }
            cls = null;
        }
        if (cls2 == cls) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j) == 0
                || !(cls2 == HashMap.class || cls2 == ArrayList.class)) {
            return (j & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
        }
        return false;
    }

    public final void writeDouble(double[] dArr, DecimalFormat decimalFormat) {
        if (decimalFormat == null || this.jsonb) {
            writeDouble(dArr);
            return;
        }
        if (dArr == null) {
            writeNull();
            return;
        }
        startArray();
        for (int i = 0; i < dArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeRaw(decimalFormat.format(dArr[i]));
        }
        endArray();
    }

    public final void writeFloat(float[] fArr, DecimalFormat decimalFormat) {
        if (decimalFormat == null || this.jsonb) {
            writeFloat(fArr);
            return;
        }
        if (fArr == null) {
            writeNull();
            return;
        }
        startArray();
        for (int i = 0; i < fArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeRaw(decimalFormat.format(fArr[i]));
        }
        endArray();
    }

    public void writeString(boolean[] zArr) {
        if (zArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < zArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(zArr[i]);
        }
        endArray();
    }

    public final void writeName(long j) {
        if (this.startObject) {
            this.startObject = false;
        } else {
            writeComma();
        }
        writeInt64(j);
    }

    public final String setPath(FieldWriter fieldWriter, Object obj) {
        Path path;
        IdentityHashMap<Object, Path> identityHashMap;
        if (!isRefDetect(obj)) {
            return null;
        }
        Path path2 = this.path;
        Path path3 = Path.ROOT;
        if (path2 == path3) {
            path = fieldWriter.getRootParentPath();
        } else {
            path = fieldWriter.getPath(path2);
        }
        this.path = path;
        if (obj == this.rootObject
                || ((identityHashMap = this.refs) != null && (path3 = identityHashMap.get(obj)) != null)) {
            return path3.toString();
        }
        if (this.refs == null) {
            this.refs = new IdentityHashMap<>(8);
        }
        this.refs.put(obj, this.path);
        return null;
    }

    public final String setPath0(int i, Object obj) {
        Path path;
        Path path2;
        Path path3 = this.path;
        if (path3 == null) {
            return null;
        }
        if (i == 0) {
            path = path3.child0;
            if (path == null) {
                path = new Path(this.path, i);
                path3.child0 = path;
            }
        } else if (i == 1) {
            path = path3.child1;
            if (path == null) {
                path = new Path(this.path, i);
                path3.child1 = path;
            }
        } else {
            path = new Path(this.path, i);
        }
        this.path = path;
        if (obj == this.rootObject) {
            path2 = Path.ROOT;
        } else {
            IdentityHashMap<Object, Path> identityHashMap = this.refs;
            if (identityHashMap == null || (path2 = identityHashMap.get(obj)) == null) {
                if (this.refs == null) {
                    this.refs = new IdentityHashMap<>(8);
                }
                this.refs.put(obj, this.path);
                return null;
            }
        }
        return path2.toString();
    }

    public static JSONWriter of(ObjectWriterProvider objectWriterProvider, Feature... featureArr) {
        Context context = new Context(objectWriterProvider);
        context.config(featureArr);
        return of(context);
    }

    public final void writeName(int i) {
        if (this.startObject) {
            this.startObject = false;
        } else {
            writeComma();
        }
        writeInt32(i);
    }

    public void writeString(byte[] bArr) {
        if (bArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(bArr[i]);
        }
        endArray();
    }

    public static JSONWriter of(Context context) {
        if (context == null) {
            context = JSONFactory.createWriteContext();
        }
        if (JDKUtils.JVM_VERSION == 8) {
            if (JDKUtils.FIELD_STRING_VALUE != null && !JDKUtils.ANDROID && !JDKUtils.OPENJ9) {
                return new JSONWriterUTF16JDK8UF(context);
            }
            return new JSONWriterUTF16JDK8(context);
        }
        if ((context.features & Feature.OptimizedForAscii.mask) != 0) {
            return new JSONWriterUTF8(context);
        }
        if (JDKUtils.FIELD_STRING_VALUE != null && JDKUtils.STRING_CODER != null && JDKUtils.STRING_VALUE != null) {
            return new JSONWriterUTF16JDK9UF(context);
        }
        return new JSONWriterUTF16(context);
    }

    public final void writeFloat(Float f) {
        if (f == null) {
            writeNumberNull();
        } else {
            writeDouble(f.floatValue());
        }
    }

    public void writeString(short[] sArr) {
        if (sArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < sArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(sArr[i]);
        }
        endArray();
    }

    public final String setPath(int i, Object obj) {
        if (isRefDetect(obj)) {
            return setPath0(i, obj);
        }
        return null;
    }

    public final boolean isWriteTypeInfo(Object obj) {
        Class<?> cls;
        long j = this.context.features;
        if ((Feature.WriteClassName.mask & j) == 0) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j) == 0 || obj == null
                || !((cls = obj.getClass()) == HashMap.class || cls == ArrayList.class)) {
            return (j & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
        }
        return false;
    }

    public static JSONWriter of(Feature... featureArr) {
        Context contextCreateWriteContext = JSONFactory.createWriteContext(featureArr);
        if (JDKUtils.JVM_VERSION == 8) {
            if (JDKUtils.FIELD_STRING_VALUE != null && !JDKUtils.ANDROID && !JDKUtils.OPENJ9) {
                return new JSONWriterUTF16JDK8UF(contextCreateWriteContext);
            }
            return new JSONWriterUTF16JDK8(contextCreateWriteContext);
        }
        if ((contextCreateWriteContext.features & Feature.OptimizedForAscii.mask) != 0) {
            return ofUTF8(contextCreateWriteContext);
        }
        if (JDKUtils.FIELD_STRING_VALUE != null && JDKUtils.STRING_CODER != null && JDKUtils.STRING_VALUE != null) {
            return new JSONWriterUTF16JDK9UF(contextCreateWriteContext);
        }
        return new JSONWriterUTF16(contextCreateWriteContext);
    }

    public void writeString(int[] iArr) {
        if (iArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < iArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(iArr[i]);
        }
        endArray();
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x0031 */
    public final boolean isWriteTypeInfo(Object obj, Type type, long j) {
        Class<?> cls;
        long j2 = j | this.context.features;
        if ((Feature.WriteClassName.mask & j2) == 0 || obj == null) {
            return false;
        }
        Class<?> cls2 = obj.getClass();
        if (type instanceof Class) {
            cls = (Class) type;
        } else if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            cls = rawType instanceof Class ? (Class) rawType : null;
        }
        if (cls2 == cls) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j2) != 0) {
            if (cls2 == HashMap.class) {
                if (cls == null || cls == Object.class || cls == Map.class || cls == AbstractMap.class) {
                    return false;
                }
            } else if (cls2 == ArrayList.class) {
                return false;
            }
        }
        return (j2 & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
    }

    public void writeString(long[] jArr) {
        if (jArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < jArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(jArr[i]);
        }
        endArray();
    }

    public void writeString(float[] fArr) {
        if (fArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < fArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(fArr[i]);
        }
        endArray();
    }

    public final boolean isWriteTypeInfo(Object obj, Class cls, long j) {
        Class<?> cls2;
        if (obj == null || (cls2 = obj.getClass()) == cls) {
            return false;
        }
        long j2 = j | this.context.features;
        if ((Feature.WriteClassName.mask & j2) == 0) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j2) != 0) {
            if (cls2 == HashMap.class) {
                if (cls == null || cls == Object.class || cls == Map.class || cls == AbstractMap.class) {
                    return false;
                }
            } else if (cls2 == ArrayList.class) {
                return false;
            }
        }
        return (j2 & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
    }

    public void writeString(double[] dArr) {
        if (dArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < dArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(dArr[i]);
        }
        endArray();
    }

    public final boolean isWriteTypeInfo(Object obj, long j) {
        Class<?> cls;
        long j2 = j | this.context.features;
        if ((Feature.WriteClassName.mask & j2) == 0) {
            return false;
        }
        if ((Feature.NotWriteHashMapArrayListClassName.mask & j2) == 0 || obj == null
                || !((cls = obj.getClass()) == HashMap.class || cls == ArrayList.class)) {
            return (j2 & Feature.NotWriteRootClassName.mask) == 0 || obj != this.rootObject;
        }
        return false;
    }

    public void writeString(float f) {
        writeString(Float.toString(f));
    }

    public void writeString(double d) {
        writeString(Double.toString(d));
    }

    public void writeString(List<String> list) {
        startArray();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(list.get(i));
        }
        endArray();
    }

    public void writeString(String[] strArr) {
        if (strArr == null) {
            writeArrayNull();
            return;
        }
        startArray();
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                writeComma();
            }
            writeString(strArr[i]);
        }
        endArray();
    }
}
