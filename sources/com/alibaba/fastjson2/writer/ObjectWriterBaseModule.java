package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.annotation.JSONCompiler;
import com.alibaba.fastjson2.annotation.JSONField;
import com.alibaba.fastjson2.annotation.JSONType;
import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.filter.Filter;
import com.alibaba.fastjson2.modules.ObjectWriterAnnotationProcessor;
import com.alibaba.fastjson2.modules.ObjectWriterModule;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.JdbcSupport;
import com.alibaba.fastjson2.util.JodaSupport;
import com.alibaba.fastjson2.util.KotlinUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.dn;
import com.umeng.ccg.a;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import me.hd.wauxv.obf.cpk;
import me.hd.wauxv.obf.cpz;
import me.hd.wauxv.obf.oh;
import me.hd.wauxv.obf.oi;
import net.bytebuddy.utility.JavaConstant;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectWriterBaseModule implements ObjectWriterModule {
    static ObjectWriterAdapter STACK_TRACE_ELEMENT_WRITER;
    final WriterAnnotationProcessor annotationProcessor = new WriterAnnotationProcessor();
    final ObjectWriterProvider provider;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class VoidObjectWriter implements ObjectWriter {
        public static final VoidObjectWriter INSTANCE = new VoidObjectWriter();

        @Override // com.alibaba.fastjson2.writer.ObjectWriter
        public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        }
    }

    public ObjectWriterBaseModule(ObjectWriterProvider objectWriterProvider) {
        this.provider = objectWriterProvider;
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0012  */
    private ObjectWriter createEnumWriter(Class cls) throws NoSuchMethodException {
        Class cls2;
        if (!cls.isEnum()) {
            Class superclass = cls.getSuperclass();
            cls2 = superclass.isEnum() ? superclass : cls;
        }
        Member enumValueField = BeanUtils.getEnumValueField(cls2, this.provider);
        if (enumValueField == null) {
            Member enumValueField2 = BeanUtils.getEnumValueField(this.provider.mixInCache.get(cls2), this.provider);
            if (enumValueField2 instanceof Field) {
                try {
                    enumValueField = cls2.getField(((Field) enumValueField2).getName());
                } catch (NoSuchFieldException | NoSuchMethodException unused) {
                }
            } else if (enumValueField2 instanceof Method) {
                enumValueField = cls2.getMethod(((Method) enumValueField2).getName(), null);
            }
        }
        Member member = enumValueField;
        BeanInfo beanInfoCreateBeanInfo = this.provider.createBeanInfo();
        for (Class<?> cls3 : cls2.getInterfaces()) {
            this.annotationProcessor.getBeanInfo(beanInfoCreateBeanInfo, cls3);
        }
        this.annotationProcessor.getBeanInfo(beanInfoCreateBeanInfo, cls2);
        if (beanInfoCreateBeanInfo.writeEnumAsJavaBean) {
            return null;
        }
        return new ObjectWriterImplEnum(null, cls2, member, BeanUtils.getEnumAnnotationNames(cls2), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$getObjectWriter$0(Object obj) {
        return ((ByteBuffer) obj).array();
    }

    @Override // com.alibaba.fastjson2.modules.ObjectWriterModule
    public ObjectWriterAnnotationProcessor getAnnotationProcessor() {
        return this.annotationProcessor;
    }

    public ObjectWriter getExternalObjectWriter(String str, Class cls) {
        str.getClass();
        switch (str) {
            case "org.joda.time.LocalDate":
                return JodaSupport.createLocalDateWriter(cls, null);
            case "org.joda.time.chrono.GregorianChronology":
                return JodaSupport.createGregorianChronologyWriter(cls);
            case "java.sql.Time":
                return JdbcSupport.createTimeWriter(null);
            case "org.joda.time.chrono.ISOChronology":
                return JodaSupport.createISOChronologyWriter(cls);
            case "org.joda.time.DateTime":
                return new ObjectWriterImplZonedDateTime(null, null, new JodaSupport.DateTime2ZDT());
            case "java.sql.Timestamp":
                return JdbcSupport.createTimestampWriter(cls, null);
            case "org.joda.time.LocalDateTime":
                return JodaSupport.createLocalDateTimeWriter(cls, null);
            default:
                if (JdbcSupport.isClob(cls)) {
                    return JdbcSupport.createClobWriter(cls);
                }
                return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x017f, code lost:
    
        if (r3.equals("gnu.trove.list.array.TDoubleArrayList") == false) goto L121;
     */
    @Override // com.alibaba.fastjson2.modules.ObjectWriterModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.fastjson2.writer.ObjectWriter getObjectWriter(java.lang.reflect.Type r20, java.lang.Class r21) {
        /*
            Method dump skipped, instruction units count: 1631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.writer.ObjectWriterBaseModule.getObjectWriter(java.lang.reflect.Type, java.lang.Class):com.alibaba.fastjson2.writer.ObjectWriter");
    }

    @Override // com.alibaba.fastjson2.modules.ObjectWriterModule
    public ObjectWriterProvider getProvider() {
        return this.provider;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class WriterAnnotationProcessor implements ObjectWriterAnnotationProcessor {
        public WriterAnnotationProcessor() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private void applyFeatures(FieldInfo fieldInfo, Enum[] enumArr) {
            for (Enum r0 : enumArr) {
                String strName = r0.name();
                strName.getClass();
                byte b = -1;
                switch (strName.hashCode()) {
                    case -2118604473:
                        if (strName.equals("DisableCircularReferenceDetect")) {
                            b = 0;
                        }
                        break;
                    case -1937516631:
                        if (strName.equals("WriteNullNumberAsZero")) {
                            b = 1;
                        }
                        break;
                    case -1779797023:
                        if (strName.equals("IgnoreErrorGetter")) {
                            b = 2;
                        }
                        break;
                    case -527123134:
                        if (strName.equals("UseISO8601DateFormat")) {
                            b = 3;
                        }
                        break;
                    case -348914872:
                        if (strName.equals("WriteBigDecimalAsPlain")) {
                            b = 4;
                        }
                        break;
                    case -335314544:
                        if (strName.equals("WriteEnumUsingToString")) {
                            b = 5;
                        }
                        break;
                    case -211922948:
                        if (strName.equals("BrowserCompatible")) {
                            b = 6;
                        }
                        break;
                    case -102443356:
                        if (strName.equals("WriteNullStringAsEmpty")) {
                            b = 7;
                        }
                        break;
                    case -62964779:
                        if (strName.equals("NotWriteRootClassName")) {
                            b = 8;
                        }
                        break;
                    case 1009181687:
                        if (strName.equals("WriteNullListAsEmpty")) {
                            b = 9;
                        }
                        break;
                    case 1519175029:
                        if (strName.equals("WriteNonStringValueAsString")) {
                            b = 10;
                        }
                        break;
                    case 1808123471:
                        if (strName.equals("WriteNullBooleanAsFalse")) {
                            b = 11;
                        }
                        break;
                    case 1879776036:
                        if (strName.equals("WriteClassName")) {
                            b = 12;
                        }
                        break;
                    case 2049970061:
                        if (strName.equals("WriteMapNullValue")) {
                            b = dn.k;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        fieldInfo.features |= FieldInfo.DISABLE_REFERENCE_DETECT;
                        break;
                    case 1:
                        fieldInfo.features |= JSONWriter.Feature.WriteNullNumberAsZero.mask;
                        break;
                    case 2:
                        fieldInfo.features |= JSONWriter.Feature.IgnoreErrorGetter.mask;
                        break;
                    case 3:
                        fieldInfo.format = "iso8601";
                        break;
                    case 4:
                        fieldInfo.features |= JSONWriter.Feature.WriteBigDecimalAsPlain.mask;
                        break;
                    case 5:
                        fieldInfo.features |= JSONWriter.Feature.WriteEnumUsingToString.mask;
                        break;
                    case 6:
                        fieldInfo.features |= JSONWriter.Feature.BrowserCompatible.mask;
                        break;
                    case 7:
                        fieldInfo.features |= JSONWriter.Feature.WriteNullStringAsEmpty.mask;
                        break;
                    case 8:
                        fieldInfo.features |= JSONWriter.Feature.NotWriteRootClassName.mask;
                        break;
                    case 9:
                        fieldInfo.features |= JSONWriter.Feature.WriteNullListAsEmpty.mask;
                        break;
                    case 10:
                        fieldInfo.features |= JSONWriter.Feature.WriteNonStringValueAsString.mask;
                        break;
                    case 11:
                        fieldInfo.features |= JSONWriter.Feature.WriteNullBooleanAsFalse.mask;
                        break;
                    case 12:
                        fieldInfo.features |= JSONWriter.Feature.WriteClassName.mask;
                        break;
                    case 13:
                        fieldInfo.features |= JSONWriter.Feature.WriteNulls.mask;
                        break;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public /* synthetic */ void lambda$processJSONField1x$8(Annotation annotation, FieldInfo fieldInfo, Method method) {
            int iIntValue;
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                switch (name.hashCode()) {
                    case -1371565692:
                        if (name.equals("serializeUsing")) {
                            Class<?> cls = (Class) objInvoke;
                            if (ObjectWriter.class.isAssignableFrom(cls)) {
                                fieldInfo.writeUsing = cls;
                            }
                        }
                        break;
                    case -1268779017:
                        if (name.equals("format")) {
                            loadJsonFieldFormat(fieldInfo, (String) objInvoke);
                        }
                        break;
                    case -1206994319:
                        if (name.equals("ordinal") && (iIntValue = ((Integer) objInvoke).intValue()) != 0) {
                            fieldInfo.ordinal = iIntValue;
                            break;
                        }
                        break;
                    case -987658292:
                        if (name.equals("unwrapped") && ((Boolean) objInvoke).booleanValue()) {
                            fieldInfo.features |= FieldInfo.UNWRAPPED_MASK;
                            break;
                        }
                        break;
                    case -940893828:
                        if (name.equals("serialzeFeatures")) {
                            applyFeatures(fieldInfo, (Enum[]) objInvoke);
                        }
                        break;
                    case -659125328:
                        if (name.equals("defaultValue")) {
                            String str = (String) objInvoke;
                            if (!str.isEmpty()) {
                                fieldInfo.defaultValue = str;
                            }
                        }
                        break;
                    case -573479200:
                        if (name.equals("serialize") && !((Boolean) objInvoke).booleanValue()) {
                            fieldInfo.ignore = true;
                            break;
                        }
                        break;
                    case 3373707:
                        if (name.equals("name")) {
                            String str2 = (String) objInvoke;
                            if (!str2.isEmpty()) {
                                fieldInfo.fieldName = str2;
                            }
                        }
                        break;
                    case 12396273:
                        if (name.equals("jsonDirect") && ((Boolean) objInvoke).booleanValue()) {
                            fieldInfo.features |= FieldInfo.RAW_VALUE_MASK;
                            break;
                        }
                        break;
                    case 102727412:
                        if (name.equals("label")) {
                            String str3 = (String) objInvoke;
                            if (!str3.isEmpty()) {
                                fieldInfo.label = str3;
                            }
                        }
                        break;
                    default:
                        break;
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$processJacksonJsonIgnoreProperties$7(Annotation annotation, BeanInfo beanInfo, Method method) {
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                if ("value".equals(name)) {
                    String[] strArr = (String[]) objInvoke;
                    if (strArr.length != 0) {
                        beanInfo.ignores = strArr;
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$processJacksonJsonProperty$6(Annotation annotation, FieldInfo fieldInfo, Method method) {
            int iIntValue;
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                int iHashCode = name.hashCode();
                if (iHashCode == -1423461020) {
                    if (name.equals(bt.Q)) {
                        fieldInfo.ignore = "WRITE_ONLY".equals(((Enum) objInvoke).name());
                        return;
                    }
                    return;
                }
                if (iHashCode == 100346066) {
                    if (!name.equals(a.H) || (iIntValue = ((Integer) objInvoke).intValue()) == -1) {
                        return;
                    }
                    fieldInfo.ordinal = iIntValue;
                    return;
                }
                if (iHashCode == 111972721 && name.equals("value")) {
                    String str = (String) objInvoke;
                    if (str.isEmpty()) {
                        return;
                    }
                    String str2 = fieldInfo.fieldName;
                    if (str2 == null || str2.isEmpty()) {
                        fieldInfo.fieldName = str;
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$processJacksonJsonPropertyOrder$4(Annotation annotation, BeanInfo beanInfo, AtomicBoolean atomicBoolean, Method method) {
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                if (!"value".equals(name)) {
                    if ("alphabetic".equals(name)) {
                        atomicBoolean.set(((Boolean) objInvoke).booleanValue());
                    }
                } else {
                    String[] strArr = (String[]) objInvoke;
                    if (strArr.length != 0) {
                        beanInfo.orders = strArr;
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processJacksonJsonSerialize$2(Annotation annotation, BeanInfo beanInfo, Method method) {
            Class clsProcessUsing;
            Class clsProcessUsing2;
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                int iHashCode = name.hashCode();
                if (iHashCode == 111582340) {
                    if (!name.equals("using") || (clsProcessUsing = processUsing((Class) objInvoke)) == null) {
                        return;
                    }
                    beanInfo.serializer = clsProcessUsing;
                    return;
                }
                if (iHashCode == 491860325 && name.equals("keyUsing") && (clsProcessUsing2 = processUsing((Class) objInvoke)) != null) {
                    beanInfo.serializer = clsProcessUsing2;
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public /* synthetic */ void lambda$processJacksonJsonSerialize$5(Annotation annotation, FieldInfo fieldInfo, Method method) {
            Class<?> cls;
            Class<?> clsProcessUsing;
            Class<?> clsProcessUsing2;
            Class<?> clsProcessUsing3;
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                switch (name.hashCode()) {
                    case -407108981:
                        if (name.equals("contentAs") && (cls = (Class) objInvoke) != Void.class) {
                            fieldInfo.contentAs = cls;
                            break;
                        }
                        break;
                    case 111582340:
                        if (name.equals("using") && (clsProcessUsing = processUsing((Class) objInvoke)) != null) {
                            fieldInfo.writeUsing = clsProcessUsing;
                            break;
                        }
                        break;
                    case 491860325:
                        if (name.equals("keyUsing") && (clsProcessUsing2 = processUsing((Class) objInvoke)) != null) {
                            fieldInfo.keyUsing = clsProcessUsing2;
                            break;
                        }
                        break;
                    case 2034063763:
                        if (name.equals("valueUsing") && (clsProcessUsing3 = processUsing((Class) objInvoke)) != null) {
                            fieldInfo.valueUsing = clsProcessUsing3;
                            break;
                        }
                        break;
                    default:
                        break;
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$processJacksonJsonSubTypes$1(Annotation annotation, BeanInfo beanInfo, Method method) {
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                if ("value".equals(name)) {
                    Annotation[] annotationArr = (Annotation[]) objInvoke;
                    if (annotationArr.length != 0) {
                        beanInfo.seeAlso = new Class[annotationArr.length];
                        beanInfo.seeAlsoNames = new String[annotationArr.length];
                        for (int i = 0; i < annotationArr.length; i++) {
                            BeanUtils.processJacksonJsonSubTypesType(beanInfo, i, annotationArr[i]);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$processJacksonJsonTypeInfo$3(Annotation annotation, BeanInfo beanInfo, Method method) {
            String name = method.getName();
            try {
                Object objInvoke = method.invoke(annotation, null);
                if ("property".equals(name)) {
                    String str = (String) objInvoke;
                    if (str.isEmpty()) {
                        return;
                    }
                    beanInfo.typeKey = str;
                    beanInfo.writerFeatures |= JSONWriter.Feature.WriteClassName.mask;
                }
            } catch (Throwable unused) {
            }
        }

        private void loadFieldInfo(FieldInfo fieldInfo, JSONField jSONField) {
            String strName = jSONField.name();
            if (!strName.isEmpty()) {
                fieldInfo.fieldName = strName;
            }
            String strDefaultValue = jSONField.defaultValue();
            if (!strDefaultValue.isEmpty()) {
                fieldInfo.defaultValue = strDefaultValue;
            }
            loadJsonFieldFormat(fieldInfo, jSONField.format());
            String strLabel = jSONField.label();
            if (!strLabel.isEmpty()) {
                fieldInfo.label = strLabel;
            }
            String strLocale = jSONField.locale();
            if (!strLocale.isEmpty()) {
                String[] strArrSplit = strLocale.split(JavaConstant.Dynamic.DEFAULT_NAME);
                if (strArrSplit.length == 2) {
                    fieldInfo.locale = new Locale(strArrSplit[0], strArrSplit[1]);
                }
            }
            boolean zSerialize = jSONField.serialize();
            boolean z = !zSerialize;
            if (!fieldInfo.ignore) {
                fieldInfo.ignore = z;
            }
            if (!jSONField.skipTransient()) {
                fieldInfo.skipTransient = false;
                if (fieldInfo.isTransient && !fieldInfo.isPrivate) {
                    fieldInfo.ignore = false;
                }
            }
            if (jSONField.unwrapped()) {
                fieldInfo.features |= FieldInfo.UNWRAPPED_MASK;
            }
            for (JSONWriter.Feature feature : jSONField.serializeFeatures()) {
                fieldInfo.features |= feature.mask;
                if (fieldInfo.ignore && !fieldInfo.isTransient && zSerialize && feature == JSONWriter.Feature.FieldBased) {
                    fieldInfo.ignore = false;
                }
            }
            int iOrdinal = jSONField.ordinal();
            if (iOrdinal != 0) {
                fieldInfo.ordinal = iOrdinal;
            }
            if (jSONField.value()) {
                fieldInfo.features |= FieldInfo.VALUE_MASK;
            }
            if (jSONField.jsonDirect()) {
                fieldInfo.features |= FieldInfo.RAW_VALUE_MASK;
            }
            Class<?> clsSerializeUsing = jSONField.serializeUsing();
            if (ObjectWriter.class.isAssignableFrom(clsSerializeUsing)) {
                fieldInfo.writeUsing = clsSerializeUsing;
            }
            Class<?> clsContentAs = jSONField.contentAs();
            if (clsContentAs != Void.class) {
                fieldInfo.contentAs = clsContentAs;
            }
        }

        private void loadJsonFieldFormat(FieldInfo fieldInfo, String str) {
            if (str.isEmpty()) {
                return;
            }
            String strTrim = str.trim();
            if (strTrim.indexOf(84) != -1 && !strTrim.contains("'T'")) {
                strTrim = strTrim.replace("T", "'T'");
            }
            if (strTrim.isEmpty()) {
                return;
            }
            fieldInfo.format = strTrim;
        }

        private void processAnnotations(FieldInfo fieldInfo, Annotation[] annotationArr) {
            for (Annotation annotation : annotationArr) {
                Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
                JSONField jSONField = (JSONField) BeanUtils.findAnnotation(annotation, JSONField.class);
                if (jSONField != null) {
                    loadFieldInfo(fieldInfo, jSONField);
                } else {
                    if (clsAnnotationType == JSONCompiler.class && ((JSONCompiler) annotation).value() == JSONCompiler.CompilerOption.LAMBDA) {
                        fieldInfo.features |= FieldInfo.JIT;
                    }
                    boolean zIsUseJacksonAnnotation = JSONFactory.isUseJacksonAnnotation();
                    String name = clsAnnotationType.getName();
                    if (name.equals("com.fasterxml.jackson.annotation.JsonInclude")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonInclude(fieldInfo, annotation);
                        }
                    } else if (name.equals("com.fasterxml.jackson.databind.annotation.JsonSerialize")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonSerialize(fieldInfo, annotation);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonFormat")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonFormat(fieldInfo, annotation);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonIgnore")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonIgnore(fieldInfo, annotation);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonValue")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.VALUE_MASK;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonAnyGetter")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.UNWRAPPED_MASK;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonProperty")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonProperty(fieldInfo, annotation);
                        }
                    } else if (name.equals("java.beans.Transient")) {
                        if (fieldInfo.skipTransient) {
                            fieldInfo.ignore = true;
                        }
                        fieldInfo.isTransient = true;
                    } else if (name.equals("com.alibaba.fastjson.annotation.JSONField")) {
                        processJSONField1x(fieldInfo, annotation);
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonRawValue")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.RAW_VALUE_MASK;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonUnwrapped") && zIsUseJacksonAnnotation) {
                        BeanUtils.processJacksonJsonUnwrapped(fieldInfo, annotation);
                    }
                }
            }
        }

        private void processJSONField1x(FieldInfo fieldInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new cpz(this, annotation, fieldInfo, 1));
        }

        private void processJacksonJsonIgnoreProperties(BeanInfo beanInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new oh(annotation, beanInfo, 10));
        }

        private void processJacksonJsonProperty(FieldInfo fieldInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new oi(annotation, fieldInfo, 8));
        }

        private void processJacksonJsonPropertyOrder(BeanInfo beanInfo, Annotation annotation) {
            Class<?> cls = annotation.getClass();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            BeanUtils.annotationMethods(cls, new cpk(annotation, beanInfo, atomicBoolean, 3));
            String[] strArr = beanInfo.orders;
            if (strArr == null || strArr.length == 0) {
                beanInfo.alphabetic = atomicBoolean.get();
            }
        }

        private void processJacksonJsonSerialize(BeanInfo beanInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new cpk(this, annotation, beanInfo));
        }

        private void processJacksonJsonSubTypes(BeanInfo beanInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new oh(annotation, beanInfo, 12));
        }

        private void processJacksonJsonTypeInfo(BeanInfo beanInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new oh(annotation, beanInfo, 13));
        }

        private Class processUsing(Class cls) {
            String name = cls.getName();
            if (!"com.fasterxml.jackson.databind.JsonSerializer$None".equals(name) && ObjectWriter.class.isAssignableFrom(cls)) {
                return cls;
            }
            if ("com.fasterxml.jackson.databind.ser.std.ToStringSerializer".equals(name)) {
                return ObjectWriterImplToString.class;
            }
            return null;
        }

        @Override // com.alibaba.fastjson2.modules.ObjectWriterAnnotationProcessor
        public void getBeanInfo(BeanInfo beanInfo, Class cls) {
            Class cls2;
            String str;
            if (cls != null) {
                Class superclass = cls.getSuperclass();
                if (superclass != Object.class && superclass != null && superclass != Enum.class) {
                    getBeanInfo(beanInfo, superclass);
                }
                for (Class<?> cls3 : cls.getInterfaces()) {
                    if (cls3 != Serializable.class) {
                        getBeanInfo(beanInfo, cls3);
                    }
                }
                if (beanInfo.seeAlso != null && beanInfo.seeAlsoNames != null) {
                    int i = 0;
                    while (true) {
                        Class[] clsArr = beanInfo.seeAlso;
                        if (i >= clsArr.length) {
                            break;
                        }
                        if (clsArr[i] == cls) {
                            String[] strArr = beanInfo.seeAlsoNames;
                            if (i < strArr.length && (str = strArr[i]) != null && str.length() != 0) {
                                beanInfo.typeName = str;
                                break;
                            }
                        }
                        i++;
                    }
                }
            }
            JSONType jSONType = null;
            Annotation annotation = null;
            for (Annotation annotation2 : BeanUtils.getAnnotations(cls)) {
                Class<? extends Annotation> clsAnnotationType = annotation2.annotationType();
                if (jSONType == null) {
                    jSONType = (JSONType) BeanUtils.findAnnotation(annotation2, JSONType.class);
                }
                if (jSONType != annotation2) {
                    if (clsAnnotationType == JSONCompiler.class && ((JSONCompiler) annotation2).value() == JSONCompiler.CompilerOption.LAMBDA) {
                        beanInfo.writerFeatures |= FieldInfo.JIT;
                    }
                    boolean zIsUseJacksonAnnotation = JSONFactory.isUseJacksonAnnotation();
                    String name = clsAnnotationType.getName();
                    if (name.equals("com.fasterxml.jackson.annotation.JsonInclude")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonInclude(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.databind.annotation.JsonSerialize")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonSerialize(beanInfo, annotation2);
                            if (beanInfo.serializer != null && Enum.class.isAssignableFrom(cls)) {
                                beanInfo.writeEnumAsJavaBean = true;
                            }
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonFormat")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonFormat(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonSubTypes")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonSubTypes(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonPropertyOrder")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonPropertyOrder(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonTypeInfo")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonTypeInfo(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonTypeName")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonTypeName(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonIgnoreProperties")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonIgnoreProperties(beanInfo, annotation2);
                        }
                    } else if (name.equals("me.hd.wauxv.obf.cda")) {
                        beanInfo.kotlin = true;
                        KotlinUtils.getConstructor(cls, beanInfo);
                    } else if (name.equals("com.alibaba.fastjson.annotation.JSONType")) {
                        annotation = annotation2;
                    }
                }
            }
            if (jSONType == null && (cls2 = ObjectWriterBaseModule.this.provider.mixInCache.get(cls)) != null) {
                beanInfo.mixIn = true;
                Annotation[] annotations = BeanUtils.getAnnotations(cls2);
                int i2 = 0;
                while (i2 < annotations.length) {
                    Annotation annotation3 = annotations[i2];
                    Class<? extends Annotation> clsAnnotationType2 = annotation3.annotationType();
                    JSONType jSONType2 = (JSONType) BeanUtils.findAnnotation(annotation3, JSONType.class);
                    if (jSONType2 != annotation3 && "com.alibaba.fastjson.annotation.JSONType".equals(clsAnnotationType2.getName())) {
                        annotation = annotation3;
                    }
                    i2++;
                    jSONType = jSONType2;
                }
            }
            if (jSONType != null) {
                Class<?>[] clsArrSeeAlso = jSONType.seeAlso();
                if (clsArrSeeAlso.length != 0) {
                    beanInfo.seeAlso = clsArrSeeAlso;
                }
                String strTypeKey = jSONType.typeKey();
                if (!strTypeKey.isEmpty()) {
                    beanInfo.typeKey = strTypeKey;
                }
                String strTypeName = jSONType.typeName();
                if (!strTypeName.isEmpty()) {
                    beanInfo.typeName = strTypeName;
                }
                for (JSONWriter.Feature feature : jSONType.serializeFeatures()) {
                    beanInfo.writerFeatures |= feature.mask;
                }
                beanInfo.namingStrategy = jSONType.naming().name();
                String[] strArrIgnores = jSONType.ignores();
                if (strArrIgnores.length > 0) {
                    beanInfo.ignores = strArrIgnores;
                }
                String[] strArrIncludes = jSONType.includes();
                if (strArrIncludes.length > 0) {
                    beanInfo.includes = strArrIncludes;
                }
                String[] strArrOrders = jSONType.orders();
                if (strArrOrders.length > 0) {
                    beanInfo.orders = strArrOrders;
                }
                Class<?> clsSerializer = jSONType.serializer();
                if (ObjectWriter.class.isAssignableFrom(clsSerializer)) {
                    beanInfo.serializer = clsSerializer;
                    beanInfo.writeEnumAsJavaBean = true;
                }
                Class<? extends Filter>[] clsArrSerializeFilters = jSONType.serializeFilters();
                if (clsArrSerializeFilters.length != 0) {
                    beanInfo.serializeFilters = clsArrSerializeFilters;
                }
                String str2 = jSONType.format();
                if (!str2.isEmpty()) {
                    beanInfo.format = str2;
                }
                String strLocale = jSONType.locale();
                if (!strLocale.isEmpty()) {
                    String[] strArrSplit = strLocale.split(JavaConstant.Dynamic.DEFAULT_NAME);
                    if (strArrSplit.length == 2) {
                        beanInfo.locale = new Locale(strArrSplit[0], strArrSplit[1]);
                    }
                }
                if (!jSONType.alphabetic()) {
                    beanInfo.alphabetic = false;
                }
                if (jSONType.writeEnumAsJavaBean()) {
                    beanInfo.writeEnumAsJavaBean = true;
                }
                String strRootName = jSONType.rootName();
                if (!strRootName.isEmpty()) {
                    beanInfo.rootName = strRootName;
                }
                if (beanInfo.skipTransient) {
                    beanInfo.skipTransient = jSONType.skipTransient();
                }
            } else if (annotation != null) {
                BeanUtils.annotationMethods(annotation.annotationType(), new oh(beanInfo, annotation, 11));
            }
            Class[] clsArr2 = beanInfo.seeAlso;
            if (clsArr2 == null || clsArr2.length == 0) {
                return;
            }
            String str3 = beanInfo.typeName;
            if (str3 == null || str3.length() == 0) {
                for (Class cls4 : beanInfo.seeAlso) {
                    if (cls4 == cls) {
                        beanInfo.typeName = cls.getSimpleName();
                        return;
                    }
                }
            }
        }

        @Override // com.alibaba.fastjson2.modules.ObjectWriterAnnotationProcessor
        public void getFieldInfo(BeanInfo beanInfo, FieldInfo fieldInfo, Class cls, Field field) {
            Class cls2;
            Field declaredField;
            JSONField jSONField = null;
            if (cls != null && (cls2 = ObjectWriterBaseModule.this.provider.mixInCache.get(cls)) != null && cls2 != cls) {
                try {
                    declaredField = cls2.getDeclaredField(field.getName());
                } catch (Exception unused) {
                    declaredField = null;
                }
                if (declaredField != null) {
                    getFieldInfo(beanInfo, fieldInfo, cls2, declaredField);
                }
            }
            if (ObjectWriterBaseModule.this.provider.mixInCache.get(field.getType()) != null) {
                fieldInfo.fieldClassMixIn = true;
            }
            if (Modifier.isTransient(field.getModifiers())) {
                fieldInfo.isTransient = true;
                if (fieldInfo.skipTransient && beanInfo.skipTransient) {
                    fieldInfo.ignore = true;
                }
            }
            Annotation[] annotations = BeanUtils.getAnnotations(field);
            if (annotations.length == 0 && KotlinUtils.isKotlin(cls)) {
                annotations = BeanUtils.getAnnotations(field.getType());
                Constructor kotlinConstructor = KotlinUtils.getKotlinConstructor(BeanUtils.getConstructor(cls));
                if (kotlinConstructor != null) {
                    String[] koltinConstructorParameters = KotlinUtils.getKoltinConstructorParameters(cls);
                    for (int i = 0; i < koltinConstructorParameters.length; i++) {
                        if (koltinConstructorParameters[i].equals(field.getName())) {
                            annotations = kotlinConstructor.getParameterAnnotations()[i];
                            break;
                        }
                    }
                    if (fieldInfo.ignore) {
                        for (Annotation annotation : annotations) {
                            if (annotation.annotationType() == JSONField.class) {
                                fieldInfo.ignore = !((JSONField) r6).serialize();
                            }
                        }
                    }
                }
            }
            for (Annotation annotation2 : annotations) {
                Class<? extends Annotation> clsAnnotationType = annotation2.annotationType();
                if (jSONField != null || (jSONField = (JSONField) BeanUtils.findAnnotation(annotation2, JSONField.class)) != annotation2) {
                    String name = clsAnnotationType.getName();
                    boolean zIsUseJacksonAnnotation = JSONFactory.isUseJacksonAnnotation();
                    if (name.equals("com.google.gson.annotations.SerializedName")) {
                        if (JSONFactory.isUseGsonAnnotation()) {
                            BeanUtils.processGsonSerializedName(fieldInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonInclude")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonInclude(beanInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonManagedReference")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= JSONWriter.Feature.ReferenceDetection.mask;
                        }
                    } else if (name.equals("com.fasterxml.jackson.databind.annotation.JsonSerialize")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonSerialize(fieldInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonFormat")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonFormat(fieldInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonIgnore")) {
                        if (zIsUseJacksonAnnotation) {
                            BeanUtils.processJacksonJsonIgnore(fieldInfo, annotation2);
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonValue")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.VALUE_MASK;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonAnyGetter")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.UNWRAPPED_MASK;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonProperty")) {
                        if (zIsUseJacksonAnnotation) {
                            processJacksonJsonProperty(fieldInfo, annotation2);
                        }
                    } else if (name.equals("com.alibaba.fastjson.annotation.JSONField")) {
                        processJSONField1x(fieldInfo, annotation2);
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonBackReference")) {
                        if (zIsUseJacksonAnnotation) {
                            fieldInfo.features |= FieldInfo.BACKR_EFERENCE;
                        }
                    } else if (name.equals("com.fasterxml.jackson.annotation.JsonRawValue") && zIsUseJacksonAnnotation) {
                        fieldInfo.features = FieldInfo.RAW_VALUE_MASK | fieldInfo.features;
                    }
                }
            }
            if (jSONField == null) {
                return;
            }
            loadFieldInfo(fieldInfo, jSONField);
            Class<?> clsWriteUsing = jSONField.writeUsing();
            if (ObjectWriter.class.isAssignableFrom(clsWriteUsing)) {
                fieldInfo.writeUsing = clsWriteUsing;
            }
            Class<?> clsSerializeUsing = jSONField.serializeUsing();
            if (ObjectWriter.class.isAssignableFrom(clsSerializeUsing)) {
                fieldInfo.writeUsing = clsSerializeUsing;
            }
            if (jSONField.jsonDirect()) {
                fieldInfo.features |= FieldInfo.RAW_VALUE_MASK;
            }
            if ((fieldInfo.features & JSONWriter.Feature.WriteNonStringValueAsString.mask) == 0 || String.class.equals(field.getType()) || fieldInfo.writeUsing != null) {
                return;
            }
            fieldInfo.writeUsing = ObjectWriterImplToString.class;
        }

        private void processJacksonJsonSerialize(FieldInfo fieldInfo, Annotation annotation) {
            BeanUtils.annotationMethods(annotation.getClass(), new cpz(this, annotation, fieldInfo, 0));
        }

        @Override // com.alibaba.fastjson2.modules.ObjectWriterAnnotationProcessor
        public void getFieldInfo(BeanInfo beanInfo, FieldInfo fieldInfo, Class cls, Method method) {
            Field field;
            Method declaredMethod;
            Class cls2 = ObjectWriterBaseModule.this.provider.mixInCache.get(cls);
            String name = method.getName();
            if ("getTargetSql".equals(name) && cls != null && cls.getName().startsWith("com.baomidou.mybatisplus.")) {
                fieldInfo.features |= JSONWriter.Feature.IgnoreErrorGetter.mask;
            }
            if (cls2 != null && cls2 != cls) {
                try {
                    declaredMethod = cls2.getDeclaredMethod(name, method.getParameterTypes());
                } catch (Exception unused) {
                    declaredMethod = null;
                }
                if (declaredMethod != null) {
                    getFieldInfo(beanInfo, fieldInfo, cls2, declaredMethod);
                }
            }
            if (ObjectWriterBaseModule.this.provider.mixInCache.get(method.getReturnType()) != null) {
                fieldInfo.fieldClassMixIn = true;
            }
            Class cls3 = JDKUtils.CLASS_TRANSIENT;
            int i = 0;
            if (cls3 != null && method.getAnnotation(cls3) != null) {
                fieldInfo.ignore = true;
                fieldInfo.isTransient = true;
                if (!beanInfo.skipTransient) {
                    fieldInfo.skipTransient = false;
                    fieldInfo.ignore = false;
                }
            }
            if (cls != null) {
                Class superclass = cls.getSuperclass();
                Method method2 = BeanUtils.getMethod(superclass, method);
                boolean z = fieldInfo.ignore;
                if (method2 != null) {
                    getFieldInfo(beanInfo, fieldInfo, superclass, method2);
                    Field field2 = BeanUtils.getField(cls, method);
                    int modifiers = method2.getModifiers();
                    if (field2 != null && z != fieldInfo.ignore && !Modifier.isAbstract(modifiers) && !method2.equals(method)) {
                        fieldInfo.ignore = z;
                    }
                }
                for (Class<?> cls4 : cls.getInterfaces()) {
                    Method method3 = BeanUtils.getMethod(cls4, method);
                    if (superclass != null && method3 != null) {
                        getFieldInfo(beanInfo, fieldInfo, superclass, method3);
                    }
                }
            }
            fieldInfo.isPrivate = false;
            processAnnotations(fieldInfo, BeanUtils.getAnnotations(method));
            if (!cls.getName().startsWith("java.lang") && !BeanUtils.isRecord(cls) && (field = BeanUtils.getField(cls, method)) != null) {
                fieldInfo.features |= FieldInfo.FIELD_MASK;
                getFieldInfo(beanInfo, fieldInfo, cls, field);
            }
            boolean z2 = beanInfo.kotlin;
            if (!z2 || beanInfo.creatorConstructor == null || beanInfo.createParameterNames == null) {
                return;
            }
            String str = BeanUtils.getterName(method, z2, null);
            while (true) {
                String[] strArr = beanInfo.createParameterNames;
                if (i >= strArr.length) {
                    return;
                }
                if (str.equals(strArr[i])) {
                    Annotation[][] parameterAnnotations = beanInfo.creatorConstructor.getParameterAnnotations();
                    if (i < parameterAnnotations.length) {
                        processAnnotations(fieldInfo, parameterAnnotations[i]);
                        return;
                    }
                }
                i++;
            }
        }
    }
}
