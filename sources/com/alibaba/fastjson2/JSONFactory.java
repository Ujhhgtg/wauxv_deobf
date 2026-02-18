package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.ExtraProcessor;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderCreator;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.ObjectWriter;
import com.alibaba.fastjson2.writer.ObjectWriterCreator;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class JSONFactory {
    static final ObjectReader<JSONArray> ARRAY_READER;
    static final AtomicReferenceFieldUpdater<CacheItem, byte[]> BYTES_UPDATER;
    static final CacheItem[] CACHE_ITEMS;
    static final int CACHE_THRESHOLD = 8388608;
    static final AtomicReferenceFieldUpdater<CacheItem, char[]> CHARS_UPDATER;
    public static final String CREATOR;
    static final byte[] NIBBLES;
    static final ObjectReader<JSONObject> OBJECT_READER;
    public static final String PROPERTY_AUTO_TYPE_ACCEPT = "fastjson2.autoTypeAccept";
    public static final String PROPERTY_AUTO_TYPE_BEFORE_HANDLER = "fastjson2.autoTypeBeforeHandler";
    public static final String PROPERTY_AUTO_TYPE_HANDLER = "fastjson2.autoTypeHandler";
    public static final String PROPERTY_DENY_PROPERTY = "fastjson2.parser.deny";
    static Supplier<List> defaultArraySupplier = null;
    static int defaultDecimalMaxScale = 2048;
    static final JSONPathCompiler defaultJSONPathCompiler;
    static int defaultMaxLevel;
    static final ObjectReaderProvider defaultObjectReaderProvider;
    static Supplier<Map> defaultObjectSupplier;
    static final ObjectWriterProvider defaultObjectWriterProvider;
    static long defaultReaderFeatures;
    static String defaultReaderFormat;
    static ZoneId defaultReaderZoneId;
    static boolean defaultSkipTransient;
    static boolean defaultWriterAlphabetic;
    static long defaultWriterFeatures;
    static String defaultWriterFormat;
    static ZoneId defaultWriterZoneId;
    static final boolean disableArrayMapping;
    static final boolean disableAutoType;
    static final boolean disableJSONB;
    static final boolean disableReferenceDetect;
    static final boolean disableSmartMatch;
    static volatile Throwable initErrorLast;
    private static volatile boolean jsonFieldDefaultValueCompatMode;
    static final ThreadLocal<JSONPathCompiler> jsonPathCompilerLocal;
    static final ThreadLocal<ObjectReaderCreator> readerCreatorLocal;
    static final ThreadLocal<ObjectReaderProvider> readerProviderLocal;
    static boolean useGsonAnnotation;
    static boolean useJacksonAnnotation;
    static final ThreadLocal<ObjectWriterCreator> writerCreatorLocal;
    static final NameCacheEntry[] NAME_CACHE = new NameCacheEntry[8192];
    static final NameCacheEntry2[] NAME_CACHE2 = new NameCacheEntry2[8192];
    static final char[] CA = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};
    static final int[] DIGITS2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 13, 14, 15};
    static final float[] FLOAT_10_POW = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
    static final double[] DOUBLE_10_POW = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class CacheItem {
        volatile byte[] bytes;
        volatile char[] chars;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Conf {
        static final Properties DEFAULT_PROPERTIES;

        static {
            Properties properties = new Properties();
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream resourceAsStream = contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson2.properties") : ClassLoader.getSystemResourceAsStream("fastjson2.properties");
            if (resourceAsStream != null) {
                try {
                    properties.load(resourceAsStream);
                } catch (IOException unused) {
                } finally {
                    IOUtils.close(resourceAsStream);
                }
            }
            DEFAULT_PROPERTIES = properties;
        }

        public static String getProperty(String str) {
            return DEFAULT_PROPERTIES.getProperty(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface JSONPathCompiler {
        JSONPath compile(Class cls, JSONPath jSONPath);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface JSONReaderUTF16Creator {
        JSONReader create(JSONReader.Context context, String str, char[] cArr, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface JSONReaderUTF8Creator {
        JSONReader create(JSONReader.Context context, String str, byte[] bArr, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class NameCacheEntry {
        final String name;
        final long value;

        public NameCacheEntry(String str, long j) {
            this.name = str;
            this.value = j;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class NameCacheEntry2 {
        final String name;
        final long value0;
        final long value1;

        public NameCacheEntry2(String str, long j, long j2) {
            this.name = str;
            this.value0 = j;
            this.value1 = j2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0095, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bf, code lost:
    
        r16 = r0;
     */
    static {
        /*
            Method dump skipped, instruction units count: 984
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONFactory.<clinit>():void");
    }

    public static JSONReader.Context createReadContext() {
        return new JSONReader.Context(getDefaultObjectReaderProvider());
    }

    public static JSONWriter.Context createWriteContext() {
        return new JSONWriter.Context(defaultObjectWriterProvider);
    }

    public static ObjectReaderCreator getContextReaderCreator() {
        return readerCreatorLocal.get();
    }

    public static ObjectWriterCreator getContextWriterCreator() {
        return writerCreatorLocal.get();
    }

    public static Supplier<List> getDefaultArraySupplier() {
        return defaultArraySupplier;
    }

    public static JSONPathCompiler getDefaultJSONPathCompiler() {
        JSONPathCompiler jSONPathCompiler = jsonPathCompilerLocal.get();
        return jSONPathCompiler != null ? jSONPathCompiler : defaultJSONPathCompiler;
    }

    public static int getDefaultMaxLevel() {
        return defaultMaxLevel;
    }

    public static ObjectReaderProvider getDefaultObjectReaderProvider() {
        ObjectReaderProvider objectReaderProvider = readerProviderLocal.get();
        return objectReaderProvider != null ? objectReaderProvider : defaultObjectReaderProvider;
    }

    public static Supplier<Map> getDefaultObjectSupplier() {
        return defaultObjectSupplier;
    }

    public static ObjectWriterProvider getDefaultObjectWriterProvider() {
        return defaultObjectWriterProvider;
    }

    public static long getDefaultReaderFeatures() {
        return defaultReaderFeatures;
    }

    public static String getDefaultReaderFormat() {
        return defaultReaderFormat;
    }

    public static ZoneId getDefaultReaderZoneId() {
        return defaultReaderZoneId;
    }

    public static long getDefaultWriterFeatures() {
        return defaultWriterFeatures;
    }

    public static String getDefaultWriterFormat() {
        return defaultWriterFormat;
    }

    public static ZoneId getDefaultWriterZoneId() {
        return defaultWriterZoneId;
    }

    public static ObjectReader getObjectReader(Type type, long j) {
        return getDefaultObjectReaderProvider().getObjectReader(type, JSONReader.Feature.FieldBased.isEnabled(j));
    }

    public static ObjectWriter getObjectWriter(Type type, long j) {
        return getDefaultObjectWriterProvider().getObjectWriter(type, TypeUtils.getClass(type), JSONWriter.Feature.FieldBased.isEnabled(j));
    }

    public static String getProperty(String str) {
        return Conf.getProperty(str);
    }

    private static boolean getPropertyBool(Properties properties, String str, boolean z) {
        String property = System.getProperty(str);
        if (property != null) {
            String strTrim = property.trim();
            if (strTrim.isEmpty() && (strTrim = properties.getProperty(str)) != null) {
                strTrim = strTrim.trim();
            }
            if (z) {
                if ("false".equals(strTrim)) {
                    return false;
                }
            } else if ("true".equals(strTrim)) {
                return true;
            }
        }
        return z;
    }

    private static int getPropertyInt(Properties properties, String str, int i) {
        String property = System.getProperty(str);
        if (property != null) {
            property = property.trim();
            if (property.isEmpty() && (property = properties.getProperty(str)) != null) {
                property = property.trim();
            }
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static boolean isDefaultSkipTransient() {
        return defaultSkipTransient;
    }

    public static boolean isDefaultWriterAlphabetic() {
        return defaultWriterAlphabetic;
    }

    public static boolean isDisableArrayMapping() {
        return disableArrayMapping;
    }

    public static boolean isDisableAutoType() {
        return disableAutoType;
    }

    public static boolean isDisableJSONB() {
        return disableJSONB;
    }

    public static boolean isDisableReferenceDetect() {
        return disableReferenceDetect;
    }

    public static boolean isDisableSmartMatch() {
        return disableSmartMatch;
    }

    public static boolean isJSONFieldDefaultValueCompatMode() {
        return jsonFieldDefaultValueCompatMode;
    }

    public static boolean isUseGsonAnnotation() {
        return useGsonAnnotation;
    }

    public static boolean isUseJacksonAnnotation() {
        return useJacksonAnnotation;
    }

    public static void setContextJSONPathCompiler(JSONPathCompiler jSONPathCompiler) {
        jsonPathCompilerLocal.set(jSONPathCompiler);
    }

    public static void setContextObjectReaderProvider(ObjectReaderProvider objectReaderProvider) {
        readerProviderLocal.set(objectReaderProvider);
    }

    public static void setContextReaderCreator(ObjectReaderCreator objectReaderCreator) {
        readerCreatorLocal.set(objectReaderCreator);
    }

    public static void setContextWriterCreator(ObjectWriterCreator objectWriterCreator) {
        writerCreatorLocal.set(objectWriterCreator);
    }

    public static void setDefaultArraySupplier(Supplier<List> supplier) {
        defaultArraySupplier = supplier;
    }

    public static void setDefaultMaxLevel(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(bjs.i(i, "maxLevel must be positive, maxLevel "));
        }
        defaultMaxLevel = i;
    }

    public static void setDefaultObjectSupplier(Supplier<Map> supplier) {
        defaultObjectSupplier = supplier;
    }

    public static void setDefaultSkipTransient(boolean z) {
        defaultSkipTransient = z;
        defaultObjectWriterProvider.setSkipTransient(z);
    }

    public static void setDefaultWriterAlphabetic(boolean z) {
        defaultWriterAlphabetic = z;
        defaultObjectWriterProvider.setAlphabetic(z);
    }

    public static void setDisableArrayMapping(boolean z) {
        defaultObjectWriterProvider.setDisableArrayMapping(z);
        defaultObjectReaderProvider.setDisableArrayMapping(z);
    }

    public static void setDisableAutoType(boolean z) {
        defaultObjectWriterProvider.setDisableAutoType(z);
        defaultObjectReaderProvider.setDisableAutoType(z);
    }

    public static void setDisableJSONB(boolean z) {
        defaultObjectWriterProvider.setDisableJSONB(z);
        defaultObjectReaderProvider.setDisableJSONB(z);
    }

    public static void setDisableReferenceDetect(boolean z) {
        defaultObjectWriterProvider.setDisableReferenceDetect(z);
        defaultObjectReaderProvider.setDisableReferenceDetect(z);
    }

    public static void setDisableSmartMatch(boolean z) {
        defaultObjectReaderProvider.setDisableSmartMatch(z);
    }

    public static void setJSONFieldDefaultValueCompatMode(boolean z) {
        jsonFieldDefaultValueCompatMode = z;
    }

    public static void setUseGsonAnnotation(boolean z) {
        useGsonAnnotation = z;
    }

    public static void setUseJacksonAnnotation(boolean z) {
        useJacksonAnnotation = z;
    }

    public static JSONWriter.Context createWriteContext(ObjectWriterProvider objectWriterProvider, JSONWriter.Feature... featureArr) {
        JSONWriter.Context context = new JSONWriter.Context(objectWriterProvider);
        context.config(featureArr);
        return context;
    }

    public static JSONReader.Context createReadContext(long j) {
        return new JSONReader.Context(getDefaultObjectReaderProvider(), j);
    }

    public static JSONWriter.Context createWriteContext(JSONWriter.Feature... featureArr) {
        return new JSONWriter.Context(defaultObjectWriterProvider, featureArr);
    }

    public static JSONReader.Context createReadContext(JSONReader.Feature... featureArr) {
        JSONReader.Context context = new JSONReader.Context(getDefaultObjectReaderProvider());
        for (JSONReader.Feature feature : featureArr) {
            context.features |= feature.mask;
        }
        return context;
    }

    public static JSONReader.Context createReadContext(Filter filter, JSONReader.Feature... featureArr) {
        JSONReader.Context context = new JSONReader.Context(getDefaultObjectReaderProvider());
        if (filter instanceof JSONReader.AutoTypeBeforeHandler) {
            context.autoTypeBeforeHandler = (JSONReader.AutoTypeBeforeHandler) filter;
        }
        if (filter instanceof ExtraProcessor) {
            context.extraProcessor = (ExtraProcessor) filter;
        }
        for (JSONReader.Feature feature : featureArr) {
            context.features |= feature.mask;
        }
        return context;
    }

    public static JSONReader.Context createReadContext(ObjectReaderProvider objectReaderProvider, JSONReader.Feature... featureArr) {
        if (objectReaderProvider == null) {
            objectReaderProvider = getDefaultObjectReaderProvider();
        }
        JSONReader.Context context = new JSONReader.Context(objectReaderProvider);
        context.config(featureArr);
        return context;
    }

    public static JSONReader.Context createReadContext(SymbolTable symbolTable) {
        return new JSONReader.Context(getDefaultObjectReaderProvider(), symbolTable);
    }

    public static JSONReader.Context createReadContext(SymbolTable symbolTable, JSONReader.Feature... featureArr) {
        JSONReader.Context context = new JSONReader.Context(getDefaultObjectReaderProvider(), symbolTable);
        context.config(featureArr);
        return context;
    }

    public static JSONReader.Context createReadContext(Supplier<Map> supplier, JSONReader.Feature... featureArr) {
        JSONReader.Context context = new JSONReader.Context(getDefaultObjectReaderProvider());
        context.setObjectSupplier(supplier);
        context.config(featureArr);
        return context;
    }

    public static JSONReader.Context createReadContext(Supplier<Map> supplier, Supplier<List> supplier2, JSONReader.Feature... featureArr) {
        JSONReader.Context context = new JSONReader.Context(getDefaultObjectReaderProvider());
        context.setObjectSupplier(supplier);
        context.setArraySupplier(supplier2);
        context.config(featureArr);
        return context;
    }
}
