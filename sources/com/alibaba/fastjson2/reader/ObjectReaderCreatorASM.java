package com.alibaba.fastjson2.reader;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONB;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.function.FieldBiConsumer;
import com.alibaba.fastjson2.function.FieldConsumer;
import com.alibaba.fastjson2.function.ObjBoolConsumer;
import com.alibaba.fastjson2.function.ObjByteConsumer;
import com.alibaba.fastjson2.function.ObjCharConsumer;
import com.alibaba.fastjson2.function.ObjFloatConsumer;
import com.alibaba.fastjson2.function.ObjShortConsumer;
import com.alibaba.fastjson2.internal.CodeGenUtils;
import com.alibaba.fastjson2.internal.asm.ASMUtils;
import com.alibaba.fastjson2.internal.asm.ClassWriter;
import com.alibaba.fastjson2.internal.asm.Label;
import com.alibaba.fastjson2.internal.asm.MethodWriter;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.alibaba.fastjson2.util.BeanUtils;
import com.alibaba.fastjson2.util.DynamicClassLoader;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.JDKUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

import me.hd.wauxv.obf.cpl;
import me.hd.wauxv.obf.cpt;
import me.hd.wauxv.obf.cpu;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.JavaConstant;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectReaderCreatorASM extends ObjectReaderCreator {
    static final String METHOD_DESC_ADAPTER_INIT;
    static final String METHOD_DESC_ADD_RESOLVE_TASK;
    static final String METHOD_DESC_CHECK_ARRAY_AUTO_TYPE;
    static final String METHOD_DESC_GET_FIELD_READER;
    static final String METHOD_DESC_GET_ITEM_OBJECT_READER;
    static final String METHOD_DESC_GET_OBJECT_READER_1;
    static final String METHOD_DESC_INIT;
    static final String METHOD_DESC_JSON_READER_CHECK_ARRAY_AUTO_TYPE;
    static final String METHOD_DESC_PROCESS_EXTRA;
    static final String METHOD_DESC_READ_ARRAY_MAPPING_JSONB_OBJECT0;
    static final String METHOD_DESC_READ_FIELD_VALUE;
    static final String METHOD_DESC_READ_OBJECT;
    static final String READ_FIELD_READER_UL;
    static final int THIS = 0;
    static final String[] fieldItemObjectReader;
    static final Map<Class, FieldReaderInfo> infos;
    static final String packageName;
    protected final DynamicClassLoader classLoader;
    public static final ObjectReaderCreatorASM INSTANCE = new ObjectReaderCreatorASM(DynamicClassLoader.getInstance());
    protected static final AtomicLong seed = new AtomicLong();

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class FieldReaderInfo {
        final String acceptDesc;
        final String interfaceDesc;
        final int loadCode;
        final String readMethodDesc;
        final String readMethodName;
        final String setterDesc;
        final int storeCode;

        public FieldReaderInfo(String str, String str2, String str3, int i, String str4, String str5, int i2) {
            this.interfaceDesc = str;
            this.acceptDesc = str2;
            this.setterDesc = str3;
            this.loadCode = i;
            this.readMethodName = str4;
            this.readMethodDesc = str5;
            this.storeCode = i2;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class ObjectReadContext {
        final BeanInfo beanInfo;
        final String classNameFull;
        final String classNameType;
        final ClassWriter cw;
        final Constructor defaultConstructor;
        final boolean externalClass;
        final int fieldNameLengthMax;
        final int fieldNameLengthMin;
        final FieldReader[] fieldReaders;
        final boolean hasStringField;
        final Class objectClass;
        ObjectReaderAdapter objectReaderAdapter;
        final String objectType;
        final boolean publicClass;

        public ObjectReadContext(BeanInfo beanInfo, Class cls, ClassWriter classWriter, boolean z,
                FieldReader[] fieldReaderArr, Constructor constructor) {
            this.beanInfo = beanInfo;
            this.objectClass = cls;
            this.cw = classWriter;
            this.publicClass = cls == null || Modifier.isPublic(cls.getModifiers());
            this.externalClass = z;
            this.fieldReaders = fieldReaderArr;
            this.defaultConstructor = constructor;
            this.objectType = cls == null ? "java/lang/Object" : ASMUtils.type(cls);
            boolean z2 = false;
            int iMin = 0;
            int iMax = 0;
            for (int i = 0; i < fieldReaderArr.length; i++) {
                FieldReader fieldReader = fieldReaderArr[i];
                z2 = fieldReader.fieldClass == String.class ? true : z2;
                byte[] bytes = fieldReader.fieldName.getBytes(StandardCharsets.UTF_8);
                int length = bytes.length;
                for (byte b : bytes) {
                    if (b <= 0) {
                        length = -1;
                        break;
                    }
                }
                if (i == 0) {
                    iMin = length;
                    iMax = iMin;
                } else {
                    iMin = Math.min(length, iMin);
                    iMax = Math.max(length, iMax);
                }
            }
            this.hasStringField = z2;
            this.fieldNameLengthMin = iMin;
            this.fieldNameLengthMax = iMax;
            StringBuilder sb = new StringBuilder("ORG_");
            sb.append(ObjectReaderCreatorASM.seed.incrementAndGet());
            sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
            sb.append(fieldReaderArr.length);
            sb.append(cls == null ? "" : JavaConstant.Dynamic.DEFAULT_NAME.concat(cls.getSimpleName()));
            String string = sb.toString();
            if (ObjectReaderCreatorASM.class.getPackage() == null) {
                this.classNameType = string;
                this.classNameFull = string;
                return;
            }
            String str = ObjectReaderCreatorASM.packageName
                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + string;
            this.classNameFull = str;
            this.classNameType = str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH,
                    '/');
        }

        public boolean disableAutoType() {
            return (this.beanInfo.readerFeatures & FieldInfo.DISABLE_AUTO_TYPE) != 0;
        }

        public boolean disableJSONB() {
            return (this.beanInfo.readerFeatures & FieldInfo.DISABLE_JSONB) != 0;
        }

        public boolean disableReferenceDetect() {
            return (this.beanInfo.readerFeatures & FieldInfo.DISABLE_REFERENCE_DETECT) != 0;
        }

        public boolean disableSmartMatch() {
            return (this.beanInfo.readerFeatures & FieldInfo.DISABLE_SMART_MATCH) != 0;
        }

        public boolean disableSupportArrayMapping() {
            return (this.beanInfo.readerFeatures & FieldInfo.DISABLE_ARRAY_MAPPING) != 0;
        }
    }

    static {
        StringBuilder sb = new StringBuilder("(");
        String str = ASMUtils.DESC_JSON_READER;
        sb.append(str);
        sb.append(")");
        String str2 = ASMUtils.DESC_OBJECT_READER;
        sb.append(str2);
        METHOD_DESC_GET_ITEM_OBJECT_READER = sb.toString();
        METHOD_DESC_GET_OBJECT_READER_1 = "(" + str + ")" + str2;
        StringBuilder sb2 = new StringBuilder("(Ljava/lang/Class;Ljava/util/function/Supplier;");
        String str3 = ASMUtils.DESC_FIELD_READER_ARRAY;
        METHOD_DESC_INIT = yg.concatToVar1(sb2, str3, ")V");
        METHOD_DESC_ADAPTER_INIT = "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;J" + ASMUtils.DESC_JSONSCHEMA
                + "Ljava/util/function/Supplier;Ljava/util/function/Function;" + str3 + ")V";
        METHOD_DESC_READ_OBJECT = concat("(", str, "Ljava/lang/reflect/Type;Ljava/lang/Object;J)Ljava/lang/Object;");
        StringBuilder sb3 = new StringBuilder("(J)");
        sb3.append(ASMUtils.DESC_FIELD_READER);
        METHOD_DESC_GET_FIELD_READER = sb3.toString();
        METHOD_DESC_READ_FIELD_VALUE = concat("(", str, "Ljava/lang/Object;)V");
        READ_FIELD_READER_UL = concat("(J", str, "JLjava/lang/Object;)V");
        METHOD_DESC_ADD_RESOLVE_TASK = concat("(", str, "Ljava/lang/Object;Ljava/lang/String;)V");
        METHOD_DESC_CHECK_ARRAY_AUTO_TYPE = "(" + str + ")" + str2;
        METHOD_DESC_PROCESS_EXTRA = concat("(", str, "Ljava/lang/Object;J)V");
        METHOD_DESC_JSON_READER_CHECK_ARRAY_AUTO_TYPE = "(" + str + "J)" + str2;
        METHOD_DESC_READ_ARRAY_MAPPING_JSONB_OBJECT0 = concat("(", str, "Ljava/lang/Object;I)V");
        HashMap map = new HashMap();
        infos = map;
        Package r1 = ObjectReaderCreatorASM.class.getPackage();
        packageName = r1 != null ? r1.getName() : "";
        map.put(Boolean.TYPE, new FieldReaderInfo(ASMUtils.type(ObjBoolConsumer.class), "(Ljava/lang/Object;Z)V",
                "(Z)V", 21, "readFieldBoolValue", "()Z", 54));
        map.put(Character.TYPE, new FieldReaderInfo(ASMUtils.type(ObjCharConsumer.class), "(Ljava/lang/Object;C)V",
                "(C)V", 21, "readInt32Value", "()C", 54));
        map.put(Byte.TYPE, new FieldReaderInfo(ASMUtils.type(ObjByteConsumer.class), "(Ljava/lang/Object;B)V", "(B)V",
                21, "readInt32Value", "()B", 54));
        map.put(Short.TYPE, new FieldReaderInfo(ASMUtils.type(ObjShortConsumer.class), "(Ljava/lang/Object;S)V", "(S)V",
                21, "readInt32Value", "()S", 54));
        map.put(Integer.TYPE, new FieldReaderInfo(ASMUtils.type(ObjIntConsumer.class), "(Ljava/lang/Object;I)V", "(I)V",
                21, "readInt32Value", "()I", 54));
        map.put(Long.TYPE, new FieldReaderInfo(ASMUtils.type(ObjLongConsumer.class), "(Ljava/lang/Object;J)V", "(J)V",
                22, "readInt64Value", "()V", 55));
        map.put(Float.TYPE, new FieldReaderInfo(ASMUtils.type(ObjFloatConsumer.class), "(Ljava/lang/Object;F)V", "(F)V",
                23, "readFieldFloatValue", "()F", 56));
        map.put(Double.TYPE, new FieldReaderInfo(ASMUtils.type(ObjDoubleConsumer.class), "(Ljava/lang/Object;D)V",
                "(D)V", 24, "readFloatDoubleValue", "()D", 57));
        map.put(String.class,
                new FieldReaderInfo(ASMUtils.type(BiConsumer.class), "(Ljava/lang/Object;Ljava/lang/Object;)V",
                        "(Ljava/lang/String;)V", 25, "readString", "()Ljava/lang/String;", 58));
        map.put(Integer.class,
                new FieldReaderInfo(ASMUtils.type(BiConsumer.class), "(Ljava/lang/Object;Ljava/lang/Integer;)V",
                        "(Ljava/lang/Integer;)V", 25, "readInt32", "()Ljava/lang/Integer;", 58));
        fieldItemObjectReader = new String[1024];
    }

    public ObjectReaderCreatorASM(ClassLoader classLoader) {
        this.classLoader = classLoader instanceof DynamicClassLoader ? (DynamicClassLoader) classLoader
                : new DynamicClassLoader(classLoader);
    }

    private void createObjectForNonConstructor(ObjectReadContext objectReadContext,
            MethodWriterContext methodWriterContext) {
        Constructor constructor;
        Class cls;
        Constructor constructor2;
        FieldReader[] fieldReaderArr = objectReadContext.fieldReaders;
        MethodWriter methodWriter = methodWriterContext.mw;
        ObjectReaderNoneDefaultConstructor objectReaderNoneDefaultConstructor = (ObjectReaderNoneDefaultConstructor) objectReadContext.objectReaderAdapter;
        int i = 0;
        if (!this.classLoader.isExternalClass(objectReadContext.objectClass)
                && objectReadContext.objectClass.getTypeParameters().length == 0
                && (((constructor = objectReaderNoneDefaultConstructor.constructor) == null
                        || Modifier.isPublic(constructor.getModifiers()))
                        && (((cls = objectReadContext.objectClass) == null || Modifier.isPublic(cls.getModifiers()))
                                && objectReaderNoneDefaultConstructor.factoryFunction == null
                                && ((constructor2 = objectReaderNoneDefaultConstructor.noneDefaultConstructor) == null
                                        || Modifier.isPublic(constructor2.getModifiers()))))) {
            methodWriter.new_(objectReadContext.objectType);
            methodWriter.dup();
            StringBuilder sb = new StringBuilder("(");
            int length = fieldReaderArr.length;
            while (i < length) {
                FieldReader fieldReader = fieldReaderArr[i];
                methodWriter.loadLocal(fieldReader.fieldClass, methodWriterContext.var(fieldReader));
                sb.append(ASMUtils.desc(fieldReader.fieldClass));
                i++;
            }
            sb.append(")V");
            methodWriter.invokespecial(objectReadContext.objectType, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                    sb.toString());
            return;
        }
        methodWriter.aload(0);
        methodWriter.iconst_n(fieldReaderArr.length);
        methodWriter.anewArray("java/lang/Object");
        while (i < fieldReaderArr.length) {
            FieldReader fieldReader2 = fieldReaderArr[i];
            methodWriter.dup();
            methodWriter.iconst_n(i);
            methodWriter.loadLocal(fieldReader2.fieldClass, methodWriterContext.var(fieldReader2));
            Class cls2 = fieldReader2.fieldClass;
            if (cls2 == Integer.TYPE) {
                methodWriter.invokestatic("java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else if (cls2 == Long.TYPE) {
                methodWriter.invokestatic("java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            } else if (cls2 == Float.TYPE) {
                methodWriter.invokestatic("java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            } else if (cls2 == Double.TYPE) {
                methodWriter.invokestatic("java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            } else if (cls2 == Boolean.TYPE) {
                methodWriter.invokestatic("java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            } else if (cls2 == Short.TYPE) {
                methodWriter.invokestatic("java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            } else if (cls2 == Byte.TYPE) {
                methodWriter.invokestatic("java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            } else if (cls2 == Character.TYPE) {
                methodWriter.invokestatic("java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            }
            methodWriter.aastore();
            i++;
        }
        methodWriter.invokevirtual(ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR, "createInstance",
                TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR);
    }

    private Function createValueConsumer0(Class cls, FieldReader[] fieldReaderArr, boolean z) {
        String strReplace;
        String strDesc;
        String strO;
        FieldReader[] fieldReaderArr2 = fieldReaderArr;
        Constructor defaultConstructor = BeanUtils.getDefaultConstructor(cls, false);
        if (defaultConstructor == null || !Modifier.isPublic(cls.getModifiers())) {
            return null;
        }
        ClassWriter classWriter = new ClassWriter(new cpu(cls, 0));
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "VBACG_" : "VCACG_");
        sb.append(seed.incrementAndGet());
        sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb.append(fieldReaderArr2.length);
        sb.append(JavaConstant.Dynamic.DEFAULT_NAME);
        sb.append(cls.getSimpleName());
        String string = sb.toString();
        if (ObjectReaderCreatorASM.class.getPackage() != null) {
            string = packageName + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + string;
            strReplace = string.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
        } else {
            strReplace = string;
        }
        String strType = ASMUtils.type(cls);
        String strDesc2 = ASMUtils.desc(cls);
        classWriter.visitField(17, "consumer", "Ljava/util/function/Consumer;");
        classWriter.visitField(1, "object", strDesc2);
        String str = "object";
        classWriter.visit(52, 49, strReplace, "java/lang/Object",
                new String[] { z ? ASMUtils.TYPE_BYTE_ARRAY_VALUE_CONSUMER : ASMUtils.TYPE_CHAR_ARRAY_VALUE_CONSUMER });
        MethodWriter methodWriterVisitMethod = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                "(Ljava/util/function/Consumer;)V", 32);
        methodWriterVisitMethod.aload(0);
        methodWriterVisitMethod.invokespecial("java/lang/Object", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V");
        methodWriterVisitMethod.aload(0);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.putfield(strReplace, "consumer", "Ljava/util/function/Consumer;");
        methodWriterVisitMethod.return_();
        methodWriterVisitMethod.visitMaxs(3, 3);
        String str2 = "(I)V";
        MethodWriter methodWriterVisitMethod2 = classWriter.visitMethod(1, "beforeRow", "(I)V", 32);
        methodWriterVisitMethod2.aload(0);
        newObject(methodWriterVisitMethod2, strType, defaultConstructor);
        methodWriterVisitMethod2.putfield(strReplace, str, strDesc2);
        methodWriterVisitMethod2.return_();
        methodWriterVisitMethod2.visitMaxs(3, 3);
        MethodWriter methodWriterVisitMethod3 = classWriter.visitMethod(1, "afterRow", "(I)V", 32);
        methodWriterVisitMethod3.aload(0);
        methodWriterVisitMethod3.getfield(strReplace, "consumer", "Ljava/util/function/Consumer;");
        methodWriterVisitMethod3.aload(0);
        methodWriterVisitMethod3.getfield(strReplace, str, strDesc2);
        methodWriterVisitMethod3.invokeinterface("java/util/function/Consumer", "accept", "(Ljava/lang/Object;)V");
        methodWriterVisitMethod3.aload(0);
        methodWriterVisitMethod3.aconst_null();
        methodWriterVisitMethod3.putfield(strReplace, str, strDesc2);
        methodWriterVisitMethod3.return_();
        methodWriterVisitMethod3.visitMaxs(3, 3);
        MethodWriter methodWriterVisitMethod4 = classWriter.visitMethod(1, "accept",
                z ? "(II[BIILjava/nio/charset/Charset;)V" : "(II[CII)V", 32);
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        methodWriterVisitMethod4.iload(5);
        methodWriterVisitMethod4.ifne(label2);
        methodWriterVisitMethod4.return_();
        methodWriterVisitMethod4.visitLabel(label2);
        methodWriterVisitMethod4.iload(2);
        methodWriterVisitMethod4.ifge(label3);
        methodWriterVisitMethod4.return_();
        methodWriterVisitMethod4.visitLabel(label3);
        methodWriterVisitMethod4.iload(2);
        methodWriterVisitMethod4.visitLdcInsn(fieldReaderArr2.length);
        methodWriterVisitMethod4.if_icmple(label);
        methodWriterVisitMethod4.return_();
        methodWriterVisitMethod4.visitLabel(label);
        Label label4 = new Label();
        int length = fieldReaderArr2.length;
        Label[] labelArr = new Label[length];
        int length2 = fieldReaderArr2.length;
        int[] iArr = new int[length2];
        for (int i = 0; i < length2; i++) {
            iArr[i] = i;
            labelArr[i] = new Label();
        }
        methodWriterVisitMethod4.iload(2);
        methodWriterVisitMethod4.visitLookupSwitchInsn(label4, iArr, labelArr);
        int i2 = 0;
        while (i2 < length) {
            methodWriterVisitMethod4.visitLabel(labelArr[i2]);
            FieldReader fieldReader = fieldReaderArr2[i2];
            Field field = fieldReader.field;
            Class cls2 = fieldReader.fieldClass;
            int i3 = i2;
            Type type = fieldReader.fieldType;
            ClassWriter classWriter2 = classWriter;
            methodWriterVisitMethod4.aload(0);
            methodWriterVisitMethod4.getfield(strReplace, str, strDesc2);
            String str3 = strDesc2;
            Class cls3 = Byte.TYPE;
            String str4 = str;
            String str5 = strReplace;
            Class cls4 = Short.TYPE;
            String str6 = str2;
            int i4 = length;
            Class cls5 = Integer.TYPE;
            Label[] labelArr2 = labelArr;
            if (type == Integer.class || type == cls5 || type == Short.class || type == cls4 || type == Byte.class
                    || type == cls3) {
                methodWriterVisitMethod4.aload(3);
                methodWriterVisitMethod4.iload(4);
                methodWriterVisitMethod4.iload(5);
                methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseInt", z ? "([BII)I" : "([CII)I");
                if (type == cls4) {
                    strDesc = "S";
                    strO = "(S)V";
                } else if (type == Short.class) {
                    methodWriterVisitMethod4.invokestatic("java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    strDesc = "Ljava/lang/Short;";
                    strO = "(Ljava/lang/Short;)V";
                } else if (type == cls3) {
                    strDesc = "B";
                    strO = "(B)V";
                } else if (type == Byte.class) {
                    methodWriterVisitMethod4.invokestatic("java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    strDesc = "Ljava/lang/Byte;";
                    strO = "(Ljava/lang/Byte;)V";
                } else if (type == cls5) {
                    strDesc = "I";
                    strO = str6;
                } else {
                    methodWriterVisitMethod4.invokestatic("java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    strDesc = "Ljava/lang/Integer;";
                    strO = "(Ljava/lang/Integer;)V";
                }
            } else {
                strO = "(J)V";
                Class cls6 = Long.TYPE;
                if (type == Long.class || type == cls6) {
                    methodWriterVisitMethod4.aload(3);
                    methodWriterVisitMethod4.iload(4);
                    methodWriterVisitMethod4.iload(5);
                    methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseLong",
                            z ? "([BII)J" : "([CII)J");
                    if (type == cls6) {
                        strDesc = "J";
                    } else {
                        methodWriterVisitMethod4.invokestatic("java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        strDesc = "Ljava/lang/Long;";
                        strO = "(Ljava/lang/Long;)V";
                    }
                } else {
                    Class cls7 = Float.TYPE;
                    if (type == Float.class || type == cls7) {
                        methodWriterVisitMethod4.aload(3);
                        methodWriterVisitMethod4.iload(4);
                        methodWriterVisitMethod4.iload(5);
                        methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseFloat",
                                z ? "([BII)F" : "([CII)F");
                        if (type == cls7) {
                            strDesc = "F";
                            strO = "(F)V";
                        } else {
                            methodWriterVisitMethod4.invokestatic("java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                            strDesc = "Ljava/lang/Float;";
                            strO = "(Ljava/lang/Float;)V";
                        }
                    } else {
                        Class cls8 = Double.TYPE;
                        if (type == Double.class || type == cls8) {
                            methodWriterVisitMethod4.aload(3);
                            methodWriterVisitMethod4.iload(4);
                            methodWriterVisitMethod4.iload(5);
                            methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseDouble",
                                    z ? "([BII)D" : "([CII)D");
                            if (type == cls8) {
                                strDesc = "D";
                                strO = "(D)V";
                            } else {
                                methodWriterVisitMethod4.invokestatic("java/lang/Double", "valueOf",
                                        "(D)Ljava/lang/Double;");
                                strDesc = "Ljava/lang/Double;";
                                strO = "(Ljava/lang/Double;)V";
                            }
                        } else {
                            Class cls9 = Boolean.TYPE;
                            if (type == Boolean.class || type == cls9) {
                                methodWriterVisitMethod4.aload(3);
                                methodWriterVisitMethod4.iload(4);
                                methodWriterVisitMethod4.iload(5);
                                methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseBoolean",
                                        z ? "([BII)Ljava/lang/Boolean;" : "([CII)Ljava/lang/Boolean;");
                                if (type == cls9) {
                                    methodWriterVisitMethod4.invokevirtual("java/lang/Boolean", "booleanValue", "()Z");
                                    strDesc = "Z";
                                    strO = "(Z)V";
                                } else {
                                    strDesc = "Ljava/lang/Boolean;";
                                    strO = "(Ljava/lang/Boolean;)V";
                                }
                            } else if (type == Date.class) {
                                methodWriterVisitMethod4.new_("java/util/Date");
                                methodWriterVisitMethod4.dup();
                                methodWriterVisitMethod4.aload(3);
                                methodWriterVisitMethod4.iload(4);
                                methodWriterVisitMethod4.iload(5);
                                if (z) {
                                    methodWriterVisitMethod4.aload(6);
                                    methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_DATE_UTILS, "parseMillis",
                                            "([BIILjava/nio/charset/Charset;)J");
                                } else {
                                    methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_DATE_UTILS, "parseMillis",
                                            "([CII)J");
                                }
                                methodWriterVisitMethod4.invokespecial("java/util/Date",
                                        MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(J)V");
                                strDesc = "Ljava/util/Date;";
                                strO = "(Ljava/util/Date;)V";
                            } else if (type == BigDecimal.class) {
                                methodWriterVisitMethod4.aload(3);
                                methodWriterVisitMethod4.iload(4);
                                methodWriterVisitMethod4.iload(5);
                                methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "parseBigDecimal",
                                        z ? "([BII)Ljava/math/BigDecimal;" : "([CII)Ljava/math/BigDecimal;");
                                strDesc = "Ljava/math/BigDecimal;";
                                strO = "(Ljava/math/BigDecimal;)V";
                            } else {
                                methodWriterVisitMethod4.new_("java/lang/String");
                                methodWriterVisitMethod4.dup();
                                methodWriterVisitMethod4.aload(3);
                                methodWriterVisitMethod4.iload(4);
                                methodWriterVisitMethod4.iload(5);
                                if (z) {
                                    methodWriterVisitMethod4.aload(6);
                                    methodWriterVisitMethod4.invokespecial("java/lang/String",
                                            MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                                            "([BIILjava/nio/charset/Charset;)V");
                                } else {
                                    methodWriterVisitMethod4.invokespecial("java/lang/String",
                                            MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "([CII)V");
                                }
                                if (type == String.class) {
                                    strDesc = "Ljava/lang/String;";
                                    strO = "(Ljava/lang/String;)V";
                                } else {
                                    strDesc = ASMUtils.desc(cls2);
                                    strO = cls2 == Character.TYPE ? "(C)V" : concat("(", strDesc, ")V");
                                    methodWriterVisitMethod4.visitLdcInsn(cls2);
                                    methodWriterVisitMethod4.invokestatic(ASMUtils.TYPE_TYPE_UTILS, "cast",
                                            "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
                                    methodWriterVisitMethod4.checkcast(ASMUtils.type(cls2));
                                }
                            }
                        }
                    }
                }
            }
            Method method = fieldReader.method;
            if (method != null) {
                if (method.getReturnType() != Void.TYPE) {
                    return null;
                }
                methodWriterVisitMethod4.invokevirtual(strType, fieldReader.method.getName(), strO);
                methodWriterVisitMethod4.goto_(label4);
                i2 = i3 + 1;
                fieldReaderArr2 = fieldReaderArr;
                classWriter = classWriter2;
                strDesc2 = str3;
                str = str4;
                strReplace = str5;
                str2 = str6;
                length = i4;
                labelArr = labelArr2;
            } else {
                if (field == null) {
                    return null;
                }
                methodWriterVisitMethod4.putfield(strType, field.getName(), strDesc);
                methodWriterVisitMethod4.goto_(label4);
                i2 = i3 + 1;
                fieldReaderArr2 = fieldReaderArr;
                classWriter = classWriter2;
                strDesc2 = str3;
                str = str4;
                strReplace = str5;
                str2 = str6;
                length = i4;
                labelArr = labelArr2;
            }
        }
        methodWriterVisitMethod4.visitLabel(label4);
        methodWriterVisitMethod4.return_();
        methodWriterVisitMethod4.visitMaxs(3, 3);
        byte[] byteArray = classWriter.toByteArray();
        try {
            return new cpt(this.classLoader.defineClassPublic(string, byteArray, 0, byteArray.length)
                    .getConstructor(Consumer.class), 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String fieldItemObjectReader(int i) {
        String[] strArr = fieldItemObjectReader;
        String str = strArr[i];
        if (str != null) {
            return str;
        }
        int iStringSize = IOUtils.stringSize(i) + 10;
        char[] cArr = new char[iStringSize];
        "itemReader".getChars(0, 10, cArr, 0);
        IOUtils.getChars(i, iStringSize, cArr);
        String str2 = new String(cArr);
        strArr[i] = str2;
        return str2;
    }

    public static String fieldObjectReader(int i) {
        switch (i) {
            case 0:
                return "objectReader0";
            case 1:
                return "objectReader1";
            case 2:
                return "objectReader2";
            case 3:
                return "objectReader3";
            case 4:
                return "objectReader4";
            case 5:
                return "objectReader5";
            case 6:
                return "objectReader6";
            case 7:
                return "objectReader7";
            case 8:
                return "objectReader8";
            case 9:
                return "objectReader9";
            case 10:
                return "objectReader10";
            case 11:
                return "objectReader11";
            case 12:
                return "objectReader12";
            case 13:
                return "objectReader13";
            case 14:
                return "objectReader14";
            case 15:
                return "objectReader15";
            default:
                int iStringSize = IOUtils.stringSize(i) + 12;
                char[] cArr = new char[iStringSize];
                "objectReader".getChars(0, 12, cArr, 0);
                IOUtils.getChars(i, iStringSize, cArr);
                return new String(cArr);
        }
    }

    private void genCheckAutoType(String str, MethodWriterContext methodWriterContext) {
        MethodWriter methodWriter = methodWriterContext.mw;
        int iVar = methodWriterContext.var("autoTypeObjectReader");
        Label label = new Label();
        methodWriter.aload(0);
        methodWriter.aload(1);
        methodWriter.lload(4);
        methodWriter.invokevirtual(str, "checkAutoType", METHOD_DESC_JSON_READER_CHECK_ARRAY_AUTO_TYPE);
        methodWriter.dup();
        methodWriter.astore(iVar);
        methodWriter.ifnull(label);
        methodWriter.aload(iVar);
        methodWriter.aload(1);
        methodWriter.aload(2);
        methodWriter.aload(3);
        methodWriter.lload(4);
        methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER, "readJSONBObject", METHOD_DESC_READ_OBJECT);
        methodWriter.areturn();
        methodWriter.visitLabel(label);
    }

    private <T> void genCreateObject(MethodWriter methodWriter, ObjectReadContext objectReadContext, String str) {
        Constructor constructor = objectReadContext.defaultConstructor;
        Supplier<T> supplier = objectReadContext.objectReaderAdapter.creator;
        Class<?> cls = objectReadContext.objectClass;
        boolean z = Modifier.isPublic(cls == null ? 1 : cls.getModifiers())
                && (cls == null || !this.classLoader.isExternalClass(cls));
        if (constructor != null && z && Modifier.isPublic(constructor.getModifiers())) {
            newObject(methodWriter, objectReadContext.objectType, objectReadContext.defaultConstructor);
        } else {
            if (supplier != null) {
                methodWriter.aload(0);
                methodWriter.getfield(str, "creator", ASMUtils.DESC_SUPPLIER);
                methodWriter.invokeinterface("java/util/function/Supplier", "get", "()Ljava/lang/Object;");
            } else {
                methodWriter.aload(0);
                methodWriter.aload(1);
                methodWriter.lload(4);
                methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "features", "(J)J");
                methodWriter.invokevirtual(str, "createInstance", "(J)Ljava/lang/Object;");
            }
            if (z) {
                methodWriter.checkcast(objectReadContext.objectType);
            }
        }
        if (objectReadContext.hasStringField) {
            Label label = new Label();
            methodWriter.lload(4);
            methodWriter.visitLdcInsn(JSONReader.Feature.InitStringFieldAsEmpty.mask);
            methodWriter.land();
            methodWriter.lconst_0();
            methodWriter.lcmp();
            methodWriter.ifeq(label);
            methodWriter.dup();
            methodWriter.aload(0);
            methodWriter.swap();
            methodWriter.invokevirtual(str, "initStringFieldAsEmpty", "(Ljava/lang/Object;)V");
            methodWriter.visitLabel(label);
        }
    }

    private void genFields(FieldReader[] fieldReaderArr, ClassWriter classWriter, String str) {
        if (str == ASMUtils.TYPE_OBJECT_READER_ADAPTER || str == ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR) {
            for (int i = 0; i < fieldReaderArr.length; i++) {
                classWriter.visitField(1, CodeGenUtils.fieldReader(i), ASMUtils.DESC_FIELD_READER);
            }
            for (int i2 = 0; i2 < fieldReaderArr.length; i2++) {
                classWriter.visitField(1, fieldObjectReader(i2), ASMUtils.DESC_OBJECT_READER);
            }
        }
        for (int i3 = 0; i3 < fieldReaderArr.length; i3++) {
            if (List.class.isAssignableFrom(fieldReaderArr[i3].fieldClass)) {
                classWriter.visitField(1, fieldItemObjectReader(i3), ASMUtils.DESC_OBJECT_READER);
            }
        }
    }

    private void genInitFields(FieldReader[] fieldReaderArr, String str, boolean z, int i, MethodWriter methodWriter,
            String str2) {
        if ((str2 == ASMUtils.TYPE_OBJECT_READER_ADAPTER
                || str2 == ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR) && z) {
            for (int i2 = 0; i2 < fieldReaderArr.length; i2++) {
                methodWriter.aload(0);
                methodWriter.aload(i);
                methodWriter.iconst_n(i2);
                methodWriter.aaload();
                methodWriter.putfield(str, CodeGenUtils.fieldReader(i2), ASMUtils.DESC_FIELD_READER);
            }
        }
    }

    private static void genInitForNonDefaultConstructor(FieldReader[] fieldReaderArr,
            MethodWriterContext methodWriterContext) {
        MethodWriter methodWriter = methodWriterContext.mw;
        for (FieldReader fieldReader : fieldReaderArr) {
            Class cls = fieldReader.fieldClass;
            int iVar = methodWriterContext.var(fieldReader);
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Boolean.TYPE
                    || cls == Character.TYPE) {
                methodWriter.iconst_0();
                methodWriter.istore(iVar);
            } else if (cls == Long.TYPE) {
                methodWriter.lconst_0();
                methodWriter.lstore(iVar);
            } else if (cls == Float.TYPE) {
                methodWriter.iconst_0();
                methodWriter.i2f();
                methodWriter.fstore(iVar);
            } else if (cls == Double.TYPE) {
                methodWriter.iconst_0();
                methodWriter.i2d();
                methodWriter.dstore(iVar);
            } else {
                methodWriter.aconst_null();
                methodWriter.astore(iVar);
            }
        }
    }

    private void genMethodGetFieldReader(ObjectReadContext objectReadContext) {
        ObjectReaderAdapter objectReaderAdapter = objectReadContext.objectReaderAdapter;
        FieldReader[] fieldReaderArr = objectReadContext.fieldReaders;
        int i = 1;
        MethodWriter methodWriterVisitMethod = objectReadContext.cw.visitMethod(1, "getFieldReader",
                "(J)" + ASMUtils.DESC_FIELD_READER, 512);
        Label label = new Label();
        if (fieldReaderArr.length > 6) {
            TreeMap treeMap = new TreeMap();
            int i2 = 0;
            while (true) {
                long[] jArr = objectReaderAdapter.hashCodes;
                if (i2 >= jArr.length) {
                    break;
                }
                long j = jArr[i2];
                ((List) treeMap.computeIfAbsent(Integer.valueOf((int) ((j >>> 32) ^ j)), new cpl(8)))
                        .add(Long.valueOf(j));
                i2++;
            }
            int size = treeMap.size();
            int[] iArr = new int[size];
            Iterator it = treeMap.keySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = ((Integer) it.next()).intValue();
                i3++;
            }
            Arrays.sort(iArr);
            methodWriterVisitMethod.lload(1);
            methodWriterVisitMethod.lload(1);
            methodWriterVisitMethod.bipush(32);
            methodWriterVisitMethod.lushr();
            methodWriterVisitMethod.lxor();
            methodWriterVisitMethod.l2i();
            methodWriterVisitMethod.istore(3);
            Label label2 = new Label();
            Label[] labelArr = new Label[size];
            for (int i4 = 0; i4 < size; i4++) {
                labelArr[i4] = new Label();
            }
            methodWriterVisitMethod.iload(3);
            methodWriterVisitMethod.visitLookupSwitchInsn(label2, iArr, labelArr);
            int i5 = 0;
            while (i5 < size) {
                methodWriterVisitMethod.visitLabel(labelArr[i5]);
                List list = (List) treeMap.get(Integer.valueOf(iArr[i5]));
                int size2 = list.size();
                int i6 = 0;
                while (i6 < size2) {
                    int i7 = i5;
                    long jLongValue = ((Long) list.get(i6)).longValue();
                    Label label3 = size2 > i ? new Label() : label2;
                    methodWriterVisitMethod.lload(i);
                    methodWriterVisitMethod.visitLdcInsn(jLongValue);
                    methodWriterVisitMethod.lcmp();
                    methodWriterVisitMethod.ifne(label3);
                    short s = objectReaderAdapter.mapping[Arrays.binarySearch(objectReaderAdapter.hashCodes,
                            jLongValue)];
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.getfield(objectReadContext.classNameType, CodeGenUtils.fieldReader(s),
                            ASMUtils.DESC_FIELD_READER);
                    methodWriterVisitMethod.goto_(label);
                    if (label3 != label2) {
                        methodWriterVisitMethod.visitLabel(label3);
                    }
                    i6++;
                    i5 = i7;
                    i = 1;
                }
                methodWriterVisitMethod.goto_(label2);
                i5++;
                i = 1;
            }
            methodWriterVisitMethod.visitLabel(label2);
        } else {
            for (int i8 = 0; i8 < fieldReaderArr.length; i8++) {
                Label label4 = new Label();
                Label label5 = new Label();
                FieldReader fieldReader = fieldReaderArr[i8];
                String str = fieldReader.fieldName;
                long j2 = fieldReader.fieldNameHash;
                methodWriterVisitMethod.lload(1);
                methodWriterVisitMethod.visitLdcInsn(j2);
                methodWriterVisitMethod.lcmp();
                methodWriterVisitMethod.ifne(label4);
                methodWriterVisitMethod.visitLabel(label5);
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.getfield(objectReadContext.classNameType, CodeGenUtils.fieldReader(i8),
                        ASMUtils.DESC_FIELD_READER);
                methodWriterVisitMethod.goto_(label);
                methodWriterVisitMethod.visitLabel(label4);
            }
        }
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitLabel(label);
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitMaxs(5, 5);
    }

    private void genMethodGetFieldReaderLCase(ObjectReadContext objectReadContext) {
        ObjectReaderAdapter objectReaderAdapter = objectReadContext.objectReaderAdapter;
        FieldReader[] fieldReaderArr = objectReadContext.fieldReaders;
        MethodWriter methodWriterVisitMethod = objectReadContext.cw.visitMethod(1, "getFieldReaderLCase",
                "(J)" + ASMUtils.DESC_FIELD_READER, 512);
        Label label = new Label();
        if (fieldReaderArr.length > 6) {
            TreeMap treeMap = new TreeMap();
            int i = 0;
            while (true) {
                long[] jArr = objectReaderAdapter.hashCodesLCase;
                if (i >= jArr.length) {
                    break;
                }
                long j = jArr[i];
                ((List) treeMap.computeIfAbsent(Integer.valueOf((int) ((j >>> 32) ^ j)), new cpl(9)))
                        .add(Long.valueOf(j));
                i++;
            }
            int size = treeMap.size();
            int[] iArr = new int[size];
            Iterator it = treeMap.keySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = ((Integer) it.next()).intValue();
                i2++;
            }
            Arrays.sort(iArr);
            methodWriterVisitMethod.lload(1);
            methodWriterVisitMethod.lload(1);
            methodWriterVisitMethod.bipush(32);
            methodWriterVisitMethod.lushr();
            methodWriterVisitMethod.lxor();
            methodWriterVisitMethod.l2i();
            methodWriterVisitMethod.istore(3);
            Label label2 = new Label();
            Label[] labelArr = new Label[size];
            for (int i3 = 0; i3 < size; i3++) {
                labelArr[i3] = new Label();
            }
            methodWriterVisitMethod.iload(3);
            methodWriterVisitMethod.visitLookupSwitchInsn(label2, iArr, labelArr);
            for (int i4 = 0; i4 < size; i4++) {
                methodWriterVisitMethod.visitLabel(labelArr[i4]);
                Iterator it2 = ((List) treeMap.get(Integer.valueOf(iArr[i4]))).iterator();
                while (it2.hasNext()) {
                    long jLongValue = ((Long) it2.next()).longValue();
                    methodWriterVisitMethod.lload(1);
                    methodWriterVisitMethod.visitLdcInsn(jLongValue);
                    methodWriterVisitMethod.lcmp();
                    methodWriterVisitMethod.ifne(label2);
                    short s = objectReaderAdapter.mappingLCase[Arrays.binarySearch(objectReaderAdapter.hashCodesLCase,
                            jLongValue)];
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.getfield(objectReadContext.classNameType, CodeGenUtils.fieldReader(s),
                            ASMUtils.DESC_FIELD_READER);
                    methodWriterVisitMethod.goto_(label);
                }
                methodWriterVisitMethod.goto_(label2);
            }
            methodWriterVisitMethod.visitLabel(label2);
        } else {
            for (int i5 = 0; i5 < fieldReaderArr.length; i5++) {
                Label label3 = new Label();
                Label label4 = new Label();
                FieldReader fieldReader = fieldReaderArr[i5];
                String str = fieldReader.fieldName;
                long j2 = fieldReader.fieldNameHashLCase;
                methodWriterVisitMethod.lload(1);
                methodWriterVisitMethod.visitLdcInsn(j2);
                methodWriterVisitMethod.lcmp();
                methodWriterVisitMethod.ifne(label3);
                methodWriterVisitMethod.visitLabel(label4);
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.getfield(objectReadContext.classNameType, CodeGenUtils.fieldReader(i5),
                        ASMUtils.DESC_FIELD_READER);
                methodWriterVisitMethod.goto_(label);
                methodWriterVisitMethod.visitLabel(label3);
            }
        }
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitLabel(label);
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitMaxs(5, 5);
    }

    private <T> void genMethodReadJSONBObject(ObjectReadContext objectReadContext, long j) {
        String str;
        int i;
        MethodWriterContext methodWriterContext;
        Label label;
        int i2;
        boolean z;
        Label label2;
        int i3;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        Label label3;
        int i6;
        Label label4;
        FieldReader[] fieldReaderArr;
        ObjectReaderCreatorASM objectReaderCreatorASM;
        ObjectReadContext objectReadContext2;
        MethodWriterContext methodWriterContext2;
        int i7;
        String str2 = objectReadContext.classNameType;
        FieldReader[] fieldReaderArr2 = objectReadContext.fieldReaders;
        Class cls = objectReadContext.objectClass;
        boolean z5 = (j & JSONReader.Feature.FieldBased.mask) != 0;
        ObjectReaderAdapter objectReaderAdapter = objectReadContext.objectReaderAdapter;
        ClassWriter classWriter = objectReadContext.cw;
        String str3 = METHOD_DESC_READ_OBJECT;
        MethodWriter methodWriterVisitMethod = classWriter.visitMethod(1, "readJSONBObject", str3, 2048);
        boolean zDisableSupportArrayMapping = objectReadContext.disableSupportArrayMapping();
        boolean zDisableAutoType = objectReadContext.disableAutoType();
        boolean z6 = z5;
        MethodWriterContext methodWriterContext3 = new MethodWriterContext(methodWriterVisitMethod, 6, true);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.lload(4);
        String str4 = ASMUtils.TYPE_JSON_READER;
        methodWriterVisitMethod.invokevirtual(str4, "features", "(J)J");
        methodWriterVisitMethod.lstore(4);
        int iVar = methodWriterContext3.var("object");
        int iVar2 = methodWriterContext3.var("I");
        int iVar22 = methodWriterContext3.var2("hashCode64");
        int iVar3 = methodWriterContext3.var("hashCode32");
        int iVar4 = methodWriterContext3.var("fieldReader");
        if (!zDisableAutoType) {
            genCheckAutoType(str2, methodWriterContext3);
        }
        Label label5 = new Label();
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str4, "nextIfNull", "()Z");
        methodWriterVisitMethod.ifeq(label5);
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitLabel(label5);
        if (cls != null && !Serializable.class.isAssignableFrom(cls)) {
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.getfield(str2, "objectClass", "Ljava/lang/Class;");
            methodWriterVisitMethod.invokevirtual(str4, "errorOnNoneSerializable", "(Ljava/lang/Class;)V");
        }
        if (!zDisableSupportArrayMapping) {
            Label label6 = new Label();
            new Label();
            Label label7 = new Label();
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str4, "isArray", "()Z");
            methodWriterVisitMethod.ifeq(label6);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str4, "isSupportBeanArray", "()Z");
            methodWriterVisitMethod.ifeq(label7);
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(2);
            methodWriterVisitMethod.aload(3);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokevirtual(str2, "readArrayMappingObject", str3);
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitLabel(label7);
            methodWriterVisitMethod.visitLabel(label6);
        }
        if (objectReadContext.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            Label label8 = new Label();
            Label label9 = new Label();
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str4, "hasAutoTypeBeforeHandler", "()Z");
            methodWriterVisitMethod.ifne(label8);
            methodWriterVisitMethod.lload(4);
            str = str4;
            i = iVar22;
            methodWriterVisitMethod
                    .visitLdcInsn(JSONReader.Feature.SupportSmartMatch.mask | JSONReader.Feature.SupportAutoType.mask);
            methodWriterVisitMethod.land();
            methodWriterVisitMethod.lconst_0();
            methodWriterVisitMethod.lcmp();
            methodWriterVisitMethod.ifeq(label9);
            methodWriterVisitMethod.visitLabel(label8);
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(2);
            methodWriterVisitMethod.aload(3);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokespecial(ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR,
                    "readJSONBObject", str3);
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitLabel(label9);
            genInitForNonDefaultConstructor(fieldReaderArr2, methodWriterContext3);
        } else {
            str = str4;
            i = iVar22;
            genCreateObject(methodWriterVisitMethod, objectReadContext, str2);
            methodWriterVisitMethod.astore(iVar);
        }
        methodWriterVisitMethod.aload(1);
        String str5 = str;
        methodWriterVisitMethod.invokevirtual(str5, "nextIfObjectStart", "()Z");
        methodWriterVisitMethod.pop();
        Label label10 = new Label();
        Label label11 = new Label();
        Label label12 = new Label();
        if (!zDisableAutoType) {
            methodWriterVisitMethod.iconst_0();
            methodWriterVisitMethod.istore(iVar2);
        }
        methodWriterVisitMethod.visitLabel(label10);
        Label label13 = new Label();
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str5, "nextIfObjectEnd", "()Z");
        methodWriterVisitMethod.ifne(label11);
        if (objectReadContext.fieldNameLengthMin < 2 || objectReadContext.fieldNameLengthMax > 43) {
            methodWriterContext = methodWriterContext3;
            label = label13;
            i2 = iVar4;
            z = z6;
            label2 = label12;
            i3 = iVar;
            i4 = iVar3;
            z2 = false;
        } else {
            i4 = iVar3;
            i2 = iVar4;
            genRead243(objectReadContext, z6, methodWriterContext3, iVar, label12, label13);
            label = label13;
            label2 = label12;
            i3 = iVar;
            methodWriterContext = methodWriterContext3;
            z = z6;
            z2 = true;
        }
        methodWriterVisitMethod.visitLabel(label);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str5, "readFieldNameHashCode", "()J");
        methodWriterVisitMethod.dup2();
        int i8 = i;
        methodWriterVisitMethod.lstore(i8);
        methodWriterVisitMethod.lconst_0();
        methodWriterVisitMethod.lcmp();
        methodWriterVisitMethod.ifeq(label2);
        if (zDisableAutoType || (objectReadContext.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
            i5 = i8;
            z3 = z2;
            z4 = z;
        } else {
            Label label14 = new Label();
            methodWriterVisitMethod.lload(i8);
            z3 = z2;
            methodWriterVisitMethod.aload(0);
            z4 = z;
            methodWriterVisitMethod.getfield(str2, "typeKeyHashCode", "J");
            methodWriterVisitMethod.lcmp();
            methodWriterVisitMethod.ifne(label14);
            methodWriterVisitMethod.lload(i8);
            methodWriterVisitMethod.lconst_0();
            methodWriterVisitMethod.lcmp();
            methodWriterVisitMethod.ifeq(label14);
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.aload(1);
            i5 = i8;
            methodWriterVisitMethod.invokevirtual(str2, "autoType",
                    yg.concatToVar1(new StringBuilder("("), ASMUtils.DESC_JSON_READER, ")Ljava/lang/Object;"));
            methodWriterVisitMethod.astore(i3);
            methodWriterVisitMethod.goto_(label11);
            methodWriterVisitMethod.visitLabel(label14);
        }
        if (z3) {
            if (objectReadContext.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                MethodWriterContext methodWriterContext4 = methodWriterContext;
                genReadHashCode64ValueForNonDefaultConstructor(objectReadContext, methodWriterContext4, i5, z4, i3,
                        label2);
                methodWriterContext = methodWriterContext4;
                label3 = label2;
            } else {
                label3 = label2;
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.lload(i5);
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.lload(4);
                methodWriterVisitMethod.aload(i3);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "readFieldValue",
                        READ_FIELD_READER_UL);
            }
            methodWriterVisitMethod.goto_(label3);
            objectReaderCreatorASM = this;
            objectReadContext2 = objectReadContext;
            i6 = iVar2;
            label4 = label11;
        } else {
            label3 = label2;
            boolean z7 = z4;
            int i9 = i5;
            String str6 = "(J)Z";
            String str7 = "getNameHashCodeLCase";
            if (fieldReaderArr2.length > 6) {
                TreeMap treeMap = new TreeMap();
                boolean z8 = z7;
                String str8 = "isSupportSmartMatch";
                ObjectReaderAdapter objectReaderAdapter2 = objectReaderAdapter;
                int i10 = 0;
                while (true) {
                    long[] jArr = objectReaderAdapter2.hashCodes;
                    methodWriterContext2 = methodWriterContext;
                    if (i10 >= jArr.length) {
                        break;
                    }
                    long j2 = jArr[i10];
                    ((List) treeMap.computeIfAbsent(Integer.valueOf((int) (j2 ^ (j2 >>> 32))), new cpl(7)))
                            .add(Long.valueOf(j2));
                    i10++;
                    methodWriterContext = methodWriterContext2;
                }
                int size = treeMap.size();
                int[] iArr = new int[size];
                Iterator it = treeMap.keySet().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    iArr[i11] = ((Integer) it.next()).intValue();
                    i11++;
                }
                Arrays.sort(iArr);
                methodWriterVisitMethod.lload(i9);
                methodWriterVisitMethod.lload(i9);
                methodWriterVisitMethod.bipush(32);
                methodWriterVisitMethod.lushr();
                methodWriterVisitMethod.lxor();
                methodWriterVisitMethod.l2i();
                methodWriterVisitMethod.istore(i4);
                Label label15 = new Label();
                label4 = label11;
                Label[] labelArr = new Label[size];
                int i12 = i3;
                for (int i13 = 0; i13 < size; i13++) {
                    labelArr[i13] = new Label();
                }
                methodWriterVisitMethod.iload(i4);
                methodWriterVisitMethod.visitLookupSwitchInsn(label15, iArr, labelArr);
                int i14 = 0;
                while (i14 < size) {
                    methodWriterVisitMethod.visitLabel(labelArr[i14]);
                    List list = (List) treeMap.get(Integer.valueOf(iArr[i14]));
                    int i15 = i14;
                    int size2 = list.size();
                    Label[] labelArr2 = labelArr;
                    int i16 = 0;
                    while (i16 < size2) {
                        TreeMap treeMap2 = treeMap;
                        int i17 = size;
                        long jLongValue = ((Long) list.get(i16)).longValue();
                        Label label16 = label15;
                        Label label17 = size2 > 1 ? new Label() : label16;
                        methodWriterVisitMethod.lload(i9);
                        methodWriterVisitMethod.visitLdcInsn(jLongValue);
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifne(label17);
                        int i18 = i9;
                        short s = objectReaderAdapter2.mapping[Arrays.binarySearch(objectReaderAdapter2.hashCodes,
                                jLongValue)];
                        FieldReader fieldReader = fieldReaderArr2[s];
                        ObjectReaderAdapter objectReaderAdapter3 = objectReaderAdapter2;
                        int i19 = iVar2;
                        Label label18 = label17;
                        boolean z9 = z8;
                        int i20 = i16;
                        MethodWriterContext methodWriterContext5 = methodWriterContext2;
                        int[] iArr2 = iArr;
                        int i21 = i12;
                        List list2 = list;
                        String str9 = str7;
                        int i22 = size2;
                        FieldReader[] fieldReaderArr3 = fieldReaderArr2;
                        int i23 = i2;
                        String str10 = str8;
                        String str11 = str6;
                        genReadFieldValue(objectReadContext, fieldReader, z9, methodWriterContext5, i21, s, true);
                        methodWriterVisitMethod.goto_(label3);
                        if (label18 != label16) {
                            methodWriterVisitMethod.visitLabel(label18);
                        }
                        int i24 = i20 + 1;
                        methodWriterContext2 = methodWriterContext5;
                        iArr = iArr2;
                        i12 = i21;
                        list = list2;
                        str7 = str9;
                        size2 = i22;
                        z8 = z9;
                        str6 = str11;
                        label15 = label16;
                        objectReaderAdapter2 = objectReaderAdapter3;
                        iVar2 = i19;
                        treeMap = treeMap2;
                        size = i17;
                        fieldReaderArr2 = fieldReaderArr3;
                        i16 = i24;
                        str8 = str10;
                        i9 = i18;
                        i2 = i23;
                    }
                    methodWriterVisitMethod.goto_(label3);
                    methodWriterContext2 = methodWriterContext2;
                    iArr = iArr;
                    label15 = label15;
                    labelArr = labelArr2;
                    treeMap = treeMap;
                    fieldReaderArr2 = fieldReaderArr2;
                    i14 = i15 + 1;
                    str8 = str8;
                    i9 = i9;
                    i2 = i2;
                }
                objectReadContext2 = objectReadContext;
                String str12 = str6;
                i6 = iVar2;
                int i25 = i2;
                String str13 = str8;
                String str14 = str7;
                methodWriterContext = methodWriterContext2;
                i3 = i12;
                methodWriterVisitMethod.visitLabel(label15);
                if (!objectReadContext2.disableSmartMatch()
                        && !(objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
                    Label label19 = new Label();
                    if ((j & JSONReader.Feature.SupportSmartMatch.mask) == 0) {
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.lload(4);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, str13, str12);
                        methodWriterVisitMethod.ifeq(label19);
                    }
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, str14, "()J");
                    methodWriterVisitMethod.invokeinterface(ASMUtils.TYPE_OBJECT_READER, "getFieldReaderLCase",
                            METHOD_DESC_GET_FIELD_READER);
                    methodWriterVisitMethod.dup();
                    methodWriterVisitMethod.astore(i25);
                    methodWriterVisitMethod.ifnull(label19);
                    methodWriterVisitMethod.aload(i25);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.aload(i3);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_FIELD_READE, "readFieldValueJSONB",
                            METHOD_DESC_READ_FIELD_VALUE);
                    methodWriterVisitMethod.goto_(label3);
                    methodWriterVisitMethod.visitLabel(label19);
                }
                objectReaderCreatorASM = this;
            } else {
                int i26 = i9;
                FieldReader[] fieldReaderArr4 = fieldReaderArr2;
                i6 = iVar2;
                label4 = label11;
                int i27 = 0;
                while (true) {
                    fieldReaderArr = fieldReaderArr4;
                    if (i27 >= fieldReaderArr.length) {
                        break;
                    }
                    Label label20 = new Label();
                    FieldReader fieldReader2 = fieldReaderArr[i27];
                    long jHashCode64 = Fnv.hashCode64(fieldReader2.fieldName);
                    int i28 = i26;
                    methodWriterVisitMethod.lload(i28);
                    methodWriterVisitMethod.visitLdcInsn(jHashCode64);
                    methodWriterVisitMethod.lcmp();
                    methodWriterVisitMethod.ifne(label20);
                    fieldReaderArr4 = fieldReaderArr;
                    genReadFieldValue(objectReadContext, fieldReader2, z7, methodWriterContext, i3, i27, false);
                    methodWriterVisitMethod.goto_(label3);
                    methodWriterVisitMethod.visitLabel(label20);
                    i27++;
                    i26 = i28;
                }
                int i29 = i26;
                Label label21 = new Label();
                if ((j & JSONReader.Feature.SupportSmartMatch.mask) == 0) {
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.lload(4);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "isSupportSmartMatch", "(J)Z");
                    methodWriterVisitMethod.ifeq(label21);
                }
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, str7, "()J");
                methodWriterVisitMethod.lstore(i29);
                for (int i30 = 0; i30 < fieldReaderArr.length; i30++) {
                    Label label22 = new Label();
                    FieldReader fieldReader3 = fieldReaderArr[i30];
                    long jHashCode642 = Fnv.hashCode64(fieldReader3.fieldName);
                    methodWriterVisitMethod.lload(i29);
                    methodWriterVisitMethod.visitLdcInsn(jHashCode642);
                    methodWriterVisitMethod.lcmp();
                    methodWriterVisitMethod.ifne(label22);
                    genReadFieldValue(objectReadContext, fieldReader3, z7, methodWriterContext, i3, i30, false);
                    methodWriterVisitMethod.goto_(label3);
                    methodWriterVisitMethod.visitLabel(label22);
                }
                objectReaderCreatorASM = this;
                objectReadContext2 = objectReadContext;
                methodWriterVisitMethod.visitLabel(label21);
            }
        }
        if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            i7 = 1;
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
        } else {
            i7 = 1;
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(i3);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "processExtra",
                    METHOD_DESC_PROCESS_EXTRA);
        }
        methodWriterVisitMethod.goto_(label3);
        methodWriterVisitMethod.visitLabel(label3);
        if (!zDisableAutoType) {
            methodWriterVisitMethod.visitIincInsn(i6, i7);
        }
        methodWriterVisitMethod.goto_(label10);
        methodWriterVisitMethod.visitLabel(label4);
        if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            objectReaderCreatorASM.createObjectForNonConstructor(objectReadContext2, methodWriterContext);
        } else {
            methodWriterVisitMethod.aload(i3);
        }
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitMaxs(5, 10);
    }

    private <T> void genMethodReadJSONBObjectArrayMapping(ObjectReadContext objectReadContext, long j) {
        ObjectReadContext objectReadContext2 = objectReadContext;
        FieldReader[] fieldReaderArr = objectReadContext2.fieldReaders;
        String str = objectReadContext2.classNameType;
        boolean z = (j & JSONReader.Feature.FieldBased.mask) != 0;
        MethodWriter methodWriterVisitMethod = objectReadContext2.cw.visitMethod(1, "readArrayMappingJSONBObject",
                METHOD_DESC_READ_OBJECT, 512);
        MethodWriterContext methodWriterContext = new MethodWriterContext(methodWriterVisitMethod, 6, true);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.lload(4);
        String str2 = ASMUtils.TYPE_JSON_READER;
        methodWriterVisitMethod.invokevirtual(str2, "features", "(J)J");
        methodWriterVisitMethod.lstore(4);
        int iVar = methodWriterContext.var("object");
        int iVar2 = methodWriterContext.var("entryCnt");
        if (!objectReadContext2.disableAutoType()) {
            genCheckAutoType(str, methodWriterContext);
        }
        Label label = new Label();
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str2, "nextIfNull", "()Z");
        methodWriterVisitMethod.ifeq(label);
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitLabel(label);
        genCreateObject(methodWriterVisitMethod, objectReadContext2, str);
        methodWriterVisitMethod.astore(iVar);
        Label label2 = new Label();
        Label label3 = new Label();
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str2, "startArray", "()I");
        methodWriterVisitMethod.dup();
        methodWriterVisitMethod.istore(iVar2);
        methodWriterVisitMethod.visitLdcInsn(fieldReaderArr.length);
        methodWriterVisitMethod.if_icmpne(label3);
        int i = 0;
        while (i < fieldReaderArr.length) {
            int i2 = iVar;
            genReadFieldValue(objectReadContext2, fieldReaderArr[i], z, methodWriterContext, i2, i, true);
            i++;
            objectReadContext2 = objectReadContext;
            iVar = i2;
        }
        int i3 = iVar;
        methodWriterVisitMethod.goto_(label2);
        methodWriterVisitMethod.visitLabel(label3);
        methodWriterVisitMethod.aload(0);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.aload(i3);
        methodWriterVisitMethod.iload(iVar2);
        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "readArrayMappingJSONBObject0",
                METHOD_DESC_READ_ARRAY_MAPPING_JSONB_OBJECT0);
        methodWriterVisitMethod.visitLabel(label2);
        methodWriterVisitMethod.aload(i3);
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitMaxs(5, 10);
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x0593 */
    /* JADX WARN: Found duplicated region for block: B:103:0x059d */
    /* JADX WARN: Found duplicated region for block: B:107:0x05c2 */
    /* JADX WARN: Found duplicated region for block: B:109:0x05e9 */
    /* JADX WARN: Found duplicated region for block: B:110:0x05f6 */
    /* JADX WARN: Found duplicated region for block: B:114:0x061b */
    /* JADX WARN: Found duplicated region for block: B:116:0x0621 */
    /* JADX WARN: Found duplicated region for block: B:117:0x062f */
    /* JADX WARN: Found duplicated region for block: B:121:0x064f */
    /* JADX WARN: Found duplicated region for block: B:124:0x066a */
    /* JADX WARN: Found duplicated region for block: B:125:0x066e */
    /*
     * JADX WARN: Found duplicated region for block: B:128:0x036f A[EDGE_INSN:
     * B:128:0x036f->B:67:0x036f BREAK A[LOOP:0: B:64:0x033a->B:66:0x0347],
     * SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:134:0x045b A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:52:0x02dc */
    /* JADX WARN: Found duplicated region for block: B:55:0x02e2 */
    /* JADX WARN: Found duplicated region for block: B:57:0x02e8 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:58:0x02f5 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:61:0x0324 */
    /* JADX WARN: Found duplicated region for block: B:63:0x0332 */
    /*
     * JADX WARN: Found duplicated region for block: B:66:0x0347 A[LOOP:0:
     * B:64:0x033a->B:66:0x0347, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:70:0x0387 A[LOOP:1:
     * B:68:0x0381->B:70:0x0387, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:73:0x03c0 A[LOOP:2:
     * B:72:0x03be->B:73:0x03c0, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:76:0x03d3 */
    /* JADX WARN: Found duplicated region for block: B:78:0x03ef */
    /* JADX WARN: Found duplicated region for block: B:80:0x0402 */
    /* JADX WARN: Found duplicated region for block: B:81:0x0408 */
    /* JADX WARN: Found duplicated region for block: B:84:0x0458 */
    /* JADX WARN: Found duplicated region for block: B:93:0x04f1 */
    /* JADX WARN: Found duplicated region for block: B:95:0x053f A[MOVE_INLINED] */
    /*
     * JADX WARN: Found duplicated region for block: B:98:0x0554 A[LOOP:5:
     * B:96:0x0551->B:98:0x0554, LOOP_END, MOVE_INLINED]
     */
    private <T> void genMethodReadObject(ObjectReadContext objectReadContext, long j) {
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        FieldReader[] fieldReaderArr;
        int i5;
        int i6;
        int i7;
        String str;
        String str2;
        FieldReader[] fieldReaderArr2;
        Label label;
        boolean z2;
        Label label2;
        int i8;
        MethodWriterContext methodWriterContext;
        boolean z3;
        boolean z4;
        MethodWriterContext methodWriterContext2;
        int i9;
        String str3;
        boolean z5;
        MethodWriterContext methodWriterContext3;
        int i10;
        MethodWriterContext methodWriterContext4;
        boolean z6;
        Label label3;
        Label label4;
        Label label5;
        boolean z7;
        int i11;
        Label label6;
        Label label7;
        int i12;
        Label label8;
        ObjectReaderCreatorASM objectReaderCreatorASM;
        JSONReader.Feature feature;
        int i13;
        Label label9;
        long j2;
        long j3;
        TreeMap treeMap;
        boolean z8;
        int i14;
        long[] jArr;
        MethodWriterContext methodWriterContext5;
        int i15;
        int size;
        int[] iArr;
        Iterator it;
        int i16;
        Label label10;
        String str4;
        Label[] labelArr;
        int i17;
        int i18;
        String str5;
        String str6;
        Label label11;
        JSONReader.Feature feature2;
        List list;
        int size2;
        int i19;
        Label label12;
        Label label13;
        Label label14;
        ObjectReadContext objectReadContext2 = objectReadContext;
        FieldReader[] fieldReaderArr3 = objectReadContext2.fieldReaders;
        String str7 = objectReadContext2.classNameType;
        boolean z9 = (j & JSONReader.Feature.FieldBased.mask) != 0;
        ClassWriter classWriter = objectReadContext2.cw;
        String str8 = METHOD_DESC_READ_OBJECT;
        MethodWriter methodWriterVisitMethod = classWriter.visitMethod(1, "readObject", str8, 2048);
        MethodWriterContext methodWriterContext6 = new MethodWriterContext(methodWriterVisitMethod, 6, false);
        int iVar = methodWriterContext6.var("object");
        int iVar2 = methodWriterContext6.var("I");
        int iVar22 = methodWriterContext6.var2("hashCode64");
        int iVar3 = methodWriterContext6.var("hashCode32");
        int iVar4 = methodWriterContext6.var("fieldReader");
        boolean zDisableSupportArrayMapping = objectReadContext2.disableSupportArrayMapping();
        boolean zDisableAutoType = objectReadContext2.disableAutoType();
        boolean zDisableJSONB = objectReadContext2.disableJSONB();
        boolean zDisableSmartMatch = objectReadContext2.disableSmartMatch();
        if (zDisableJSONB) {
            z = z9;
            i = 1;
            i2 = iVar4;
            i3 = 4;
        } else {
            Label label15 = new Label();
            methodWriterVisitMethod.aload(1);
            z = z9;
            i2 = iVar4;
            methodWriterVisitMethod.getfield(ASMUtils.TYPE_JSON_READER, "jsonb", "Z");
            methodWriterVisitMethod.ifeq(label15);
            methodWriterVisitMethod.aload(0);
            i = 1;
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(2);
            methodWriterVisitMethod.aload(3);
            i3 = 4;
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokevirtual(str7, "readJSONBObject", str8);
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitLabel(label15);
        }
        methodWriterVisitMethod.aload(i);
        methodWriterVisitMethod.lload(i3);
        String str9 = ASMUtils.TYPE_JSON_READER;
        methodWriterVisitMethod.invokevirtual(str9, "features", "(J)J");
        methodWriterVisitMethod.lstore(i3);
        if (zDisableSmartMatch && zDisableSupportArrayMapping) {
            fieldReaderArr = fieldReaderArr3;
            i5 = iVar22;
            i4 = iVar3;
        } else {
            Label label16 = new Label();
            i4 = iVar3;
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str9, "isArray", "()Z");
            methodWriterVisitMethod.ifeq(label16);
            if (zDisableSupportArrayMapping) {
                fieldReaderArr = fieldReaderArr3;
                i5 = iVar22;
                i6 = 0;
            } else {
                Label label17 = new Label();
                i5 = iVar22;
                fieldReaderArr = fieldReaderArr3;
                if ((j & JSONReader.Feature.SupportArrayToBean.mask) == 0) {
                    i7 = 1;
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.lload(4);
                    methodWriterVisitMethod.invokevirtual(str9, "isSupportBeanArray", "(J)Z");
                    methodWriterVisitMethod.ifeq(label17);
                } else {
                    i7 = 1;
                }
                i6 = 0;
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.aload(i7);
                methodWriterVisitMethod.aload(2);
                methodWriterVisitMethod.aload(3);
                methodWriterVisitMethod.lload(4);
                methodWriterVisitMethod.invokevirtual(str7, "readArrayMappingObject", str8);
                methodWriterVisitMethod.areturn();
                methodWriterVisitMethod.visitLabel(label17);
            }
            methodWriterVisitMethod.aload(i6);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(2);
            methodWriterVisitMethod.aload(3);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokevirtual(str7, "processObjectInputSingleItemArray", str8);
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitLabel(label16);
        }
        Label label18 = new Label();
        Label label19 = new Label();
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str9, "nextIfObjectStart", "()Z");
        methodWriterVisitMethod.ifne(label19);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str9, "nextIfNullOrEmptyString", "()Z");
        methodWriterVisitMethod.ifeq(label19);
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitLabel(label19);
        if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            Label label20 = new Label();
            Label label21 = new Label();
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str9, "hasAutoTypeBeforeHandler", "()Z");
            methodWriterVisitMethod.ifne(label20);
            methodWriterVisitMethod.lload(4);
            str = str9;
            str2 = "(J)Z";
            methodWriterVisitMethod
                    .visitLdcInsn(JSONReader.Feature.SupportSmartMatch.mask | JSONReader.Feature.SupportAutoType.mask);
            methodWriterVisitMethod.land();
            methodWriterVisitMethod.lconst_0();
            methodWriterVisitMethod.lcmp();
            methodWriterVisitMethod.ifeq(label21);
            methodWriterVisitMethod.visitLabel(label20);
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.aload(2);
            methodWriterVisitMethod.aload(3);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.invokespecial(ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR, "readObject",
                    str8);
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitLabel(label21);
            fieldReaderArr2 = fieldReaderArr;
            genInitForNonDefaultConstructor(fieldReaderArr2, methodWriterContext6);
        } else {
            str = str9;
            str2 = "(J)Z";
            fieldReaderArr2 = fieldReaderArr;
            genCreateObject(methodWriterVisitMethod, objectReadContext2, str7);
            methodWriterVisitMethod.astore(iVar);
        }
        Label label22 = new Label();
        Label label23 = new Label();
        Label label24 = new Label();
        if (!zDisableAutoType) {
            methodWriterVisitMethod.iconst_0();
            methodWriterVisitMethod.istore(iVar2);
        }
        methodWriterVisitMethod.visitLabel(label22);
        int i20 = iVar;
        Label label25 = label24;
        Label label26 = new Label();
        methodWriterVisitMethod.aload(1);
        String str10 = str;
        methodWriterVisitMethod.invokevirtual(str10, "nextIfObjectEnd", "()Z");
        methodWriterVisitMethod.ifne(label23);
        int i21 = objectReadContext2.fieldNameLengthMin;
        if (i21 < 5 || objectReadContext2.fieldNameLengthMax > 7) {
            label = label26;
            z2 = z;
            label2 = label25;
            i8 = i20;
            methodWriterContext = methodWriterContext6;
            if (i21 < 2 || objectReadContext2.fieldNameLengthMax > 43) {
                z3 = false;
            } else {
                z4 = z2;
                methodWriterContext2 = methodWriterContext;
                i20 = i8;
                label25 = label2;
                label26 = label;
                genRead243(objectReadContext2, z4, methodWriterContext2, i20, label25, label26);
            }
            methodWriterVisitMethod.visitLabel(label);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.invokevirtual(str10, "readFieldNameHashCode", "()J");
            methodWriterVisitMethod.dup2();
            i9 = i5;
            methodWriterVisitMethod.lstore(i9);
            str3 = "()J";
            z5 = z2;
            methodWriterVisitMethod.visitLdcInsn(-1L);
            methodWriterVisitMethod.lcmp();
            methodWriterVisitMethod.ifeq(label23);
            if (zDisableAutoType
                    && !(objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
                Label label27 = new Label();
                methodWriterVisitMethod.iload(iVar2);
                methodWriterVisitMethod.ifne(label27);
                methodWriterVisitMethod.lload(i9);
                methodWriterContext3 = methodWriterContext;
                methodWriterVisitMethod.visitLdcInsn(ObjectReader.HASH_TYPE);
                methodWriterVisitMethod.lcmp();
                methodWriterVisitMethod.ifne(label27);
                if ((j & JSONReader.Feature.SupportAutoType.mask) == 0) {
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.lload(4);
                    methodWriterVisitMethod.invokevirtual(str10, "isSupportAutoTypeOrHandler", str2);
                    methodWriterVisitMethod.ifeq(label27);
                }
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.getfield(str7, "objectClass", "Ljava/lang/Class;");
                methodWriterVisitMethod.lload(4);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "autoType",
                        "(" + ASMUtils.desc(JSONReader.class) + "Ljava/lang/Class;J)Ljava/lang/Object;");
                methodWriterVisitMethod.areturn();
                methodWriterVisitMethod.visitLabel(label27);
            }
            if (z3) {
                i10 = i9;
                methodWriterContext4 = methodWriterContext3;
                z6 = z5;
                label3 = label2;
                if (fieldReaderArr2.length > 6) {
                    treeMap = new TreeMap();
                    z8 = z6;
                    i14 = 0;
                    while (true) {
                        jArr = objectReadContext2.objectReaderAdapter.hashCodes;
                        methodWriterContext5 = methodWriterContext4;
                        if (i14 < jArr.length) {
                            break;
                        }
                        long j4 = jArr[i14];
                        ((List) treeMap.computeIfAbsent(Integer.valueOf((int) (j4 ^ (j4 >>> 32))), new cpl(10)))
                                .add(Long.valueOf(j4));
                        i14++;
                        methodWriterContext4 = methodWriterContext5;
                        i8 = i8;
                    }
                    i15 = i8;
                    size = treeMap.size();
                    iArr = new int[size];
                    it = treeMap.keySet().iterator();
                    i16 = 0;
                    while (it.hasNext()) {
                        iArr[i16] = ((Integer) it.next()).intValue();
                        i16++;
                    }
                    Arrays.sort(iArr);
                    methodWriterVisitMethod.lload(i10);
                    methodWriterVisitMethod.lload(i10);
                    methodWriterVisitMethod.bipush(32);
                    methodWriterVisitMethod.lushr();
                    methodWriterVisitMethod.lxor();
                    methodWriterVisitMethod.l2i();
                    int i22 = i4;
                    methodWriterVisitMethod.istore(i22);
                    label10 = new Label();
                    str4 = "getNameHashCodeLCase";
                    labelArr = new Label[size];
                    z7 = z3;
                    for (i17 = 0; i17 < size; i17++) {
                        labelArr[i17] = new Label();
                    }
                    methodWriterVisitMethod.iload(i22);
                    methodWriterVisitMethod.visitLookupSwitchInsn(label10, iArr, labelArr);
                    i18 = 0;
                    while (i18 < size) {
                        methodWriterVisitMethod.visitLabel(labelArr[i18]);
                        list = (List) treeMap.get(Integer.valueOf(iArr[i18]));
                        Label[] labelArr2 = labelArr;
                        size2 = list.size();
                        int i23 = i18;
                        i19 = 0;
                        while (i19 < size2) {
                            List list2 = list;
                            int i24 = size;
                            long jLongValue = ((Long) list.get(i19)).longValue();
                            TreeMap treeMap2 = treeMap;
                            Label label28 = size2 > 1 ? new Label() : label10;
                            methodWriterVisitMethod.lload(i10);
                            methodWriterVisitMethod.visitLdcInsn(jLongValue);
                            methodWriterVisitMethod.lcmp();
                            methodWriterVisitMethod.ifne(label28);
                            label12 = label28;
                            short s = objectReadContext2.objectReaderAdapter.mapping[Arrays
                                    .binarySearch(objectReadContext2.objectReaderAdapter.hashCodes, jLongValue)];
                            int i25 = i10;
                            int i26 = size2;
                            boolean z10 = z8;
                            Label label29 = label22;
                            String str11 = str4;
                            int i27 = iVar2;
                            int i28 = i19;
                            String str12 = str3;
                            int[] iArr2 = iArr;
                            int i29 = i15;
                            MethodWriterContext methodWriterContext7 = methodWriterContext5;
                            Label label30 = label18;
                            Label label31 = label3;
                            Label label32 = label23;
                            label13 = label10;
                            genReadFieldValue(objectReadContext2, fieldReaderArr2[s], z10, methodWriterContext7, i29, s,
                                    false);
                            methodWriterVisitMethod.goto_(label31);
                            if (label12 != label13) {
                                methodWriterVisitMethod.visitLabel(label12);
                            }
                            str4 = str11;
                            iVar2 = i27;
                            label10 = label13;
                            label23 = label32;
                            size2 = i26;
                            label22 = label29;
                            i10 = i25;
                            z8 = z10;
                            i15 = i29;
                            label3 = label31;
                            label18 = label30;
                            iArr = iArr2;
                            list = list2;
                            methodWriterContext5 = methodWriterContext7;
                            str3 = str12;
                            size = i24;
                            i19 = i28 + 1;
                            treeMap = treeMap2;
                        }
                        int i30 = size;
                        MethodWriterContext methodWriterContext8 = methodWriterContext5;
                        Label label33 = label18;
                        Label label34 = label3;
                        methodWriterVisitMethod.goto_(label34);
                        str4 = str4;
                        iVar2 = iVar2;
                        iArr = iArr;
                        label23 = label23;
                        labelArr = labelArr2;
                        i10 = i10;
                        z8 = z8;
                        label3 = label34;
                        str3 = str3;
                        label18 = label33;
                        i18 = i23 + 1;
                        methodWriterContext5 = methodWriterContext8;
                        treeMap = treeMap;
                        size = i30;
                    }
                    str5 = str4;
                    i11 = iVar2;
                    label5 = label22;
                    methodWriterContext4 = methodWriterContext5;
                    str6 = str3;
                    i8 = i15;
                    label4 = label18;
                    label6 = label3;
                    label7 = label23;
                    methodWriterVisitMethod.visitLabel(label10);
                    if (!zDisableSmartMatch
                            && !(objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
                        label11 = new Label();
                        feature2 = JSONReader.Feature.SupportSmartMatch;
                        if ((j & feature2.mask) == 0) {
                            methodWriterVisitMethod.lload(4);
                            methodWriterVisitMethod.visitLdcInsn(feature2.mask);
                            methodWriterVisitMethod.land();
                            methodWriterVisitMethod.lconst_0();
                            methodWriterVisitMethod.lcmp();
                            methodWriterVisitMethod.ifeq(label11);
                        }
                        methodWriterVisitMethod.aload(0);
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, str5, str6);
                        methodWriterVisitMethod.invokeinterface(ASMUtils.TYPE_OBJECT_READER, "getFieldReaderLCase",
                                METHOD_DESC_GET_FIELD_READER);
                        methodWriterVisitMethod.dup();
                        int i31 = i2;
                        methodWriterVisitMethod.astore(i31);
                        methodWriterVisitMethod.ifnull(label11);
                        methodWriterVisitMethod.aload(i31);
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.aload(i8);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_FIELD_READE, "readFieldValue",
                                METHOD_DESC_READ_FIELD_VALUE);
                        methodWriterVisitMethod.goto_(label6);
                        methodWriterVisitMethod.visitLabel(label11);
                    }
                } else {
                    label4 = label18;
                    label5 = label22;
                    z7 = z3;
                    i11 = iVar2;
                    label6 = label3;
                    label7 = label23;
                    i12 = 0;
                    while (i12 < fieldReaderArr2.length) {
                        Label label35 = new Label();
                        Label label36 = new Label();
                        FieldReader fieldReader = fieldReaderArr2[i12];
                        String str13 = fieldReader.fieldName;
                        boolean z11 = z6;
                        long j5 = fieldReader.fieldNameHash;
                        methodWriterVisitMethod.lload(i10);
                        methodWriterVisitMethod.visitLdcInsn(j5);
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifne(label35);
                        methodWriterVisitMethod.visitLabel(label36);
                        methodWriterContext4 = methodWriterContext4;
                        z6 = z11;
                        genReadFieldValue(objectReadContext2, fieldReader, z6, methodWriterContext4, i8, i12, false);
                        methodWriterVisitMethod.goto_(label6);
                        methodWriterVisitMethod.visitLabel(label35);
                        i12++;
                        objectReadContext2 = objectReadContext;
                    }
                    label8 = new Label();
                    if (!zDisableSmartMatch) {
                        feature = JSONReader.Feature.SupportSmartMatch;
                        if ((j & feature.mask) == 0) {
                            methodWriterVisitMethod.lload(4);
                            methodWriterVisitMethod.visitLdcInsn(feature.mask);
                            methodWriterVisitMethod.land();
                            methodWriterVisitMethod.lconst_0();
                            methodWriterVisitMethod.lcmp();
                            methodWriterVisitMethod.ifeq(label8);
                        }
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "getNameHashCodeLCase", str3);
                        methodWriterVisitMethod.lstore(i10);
                        i13 = 0;
                        while (i13 < fieldReaderArr2.length) {
                            label9 = new Label();
                            Label label37 = new Label();
                            FieldReader fieldReader2 = fieldReaderArr2[i13];
                            String str14 = fieldReader2.fieldName;
                            boolean z12 = z6;
                            MethodWriterContext methodWriterContext9 = methodWriterContext4;
                            j2 = fieldReader2.fieldNameHash;
                            int i32 = i8;
                            int i33 = i13;
                            j3 = fieldReader2.fieldNameHashLCase;
                            methodWriterVisitMethod.lload(i10);
                            methodWriterVisitMethod.visitLdcInsn(j2);
                            methodWriterVisitMethod.lcmp();
                            methodWriterVisitMethod.ifeq(label37);
                            if (j3 != j2) {
                                methodWriterVisitMethod.lload(i10);
                                methodWriterVisitMethod.visitLdcInsn(j3);
                                methodWriterVisitMethod.lcmp();
                                methodWriterVisitMethod.ifne(label9);
                            } else {
                                methodWriterVisitMethod.goto_(label9);
                            }
                            methodWriterVisitMethod.visitLabel(label37);
                            methodWriterContext4 = methodWriterContext9;
                            z6 = z12;
                            i8 = i32;
                            genReadFieldValue(objectReadContext, fieldReader2, z6, methodWriterContext4, i8, i33,
                                    false);
                            methodWriterVisitMethod.goto_(label6);
                            methodWriterVisitMethod.visitLabel(label9);
                            i13 = i33 + 1;
                        }
                    }
                    objectReaderCreatorASM = this;
                    objectReadContext2 = objectReadContext;
                    methodWriterVisitMethod.visitLabel(label8);
                }
                if (!z7) {
                    if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
                    } else {
                        methodWriterVisitMethod.aload(0);
                        methodWriterVisitMethod.aload(1);
                        methodWriterVisitMethod.aload(i8);
                        methodWriterVisitMethod.lload(4);
                        methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "processExtra",
                                METHOD_DESC_PROCESS_EXTRA);
                    }
                    methodWriterVisitMethod.goto_(label6);
                }
                methodWriterVisitMethod.visitLabel(label6);
                if (!zDisableAutoType) {
                    methodWriterVisitMethod.visitIincInsn(i11, 1);
                }
                methodWriterVisitMethod.goto_(label5);
                methodWriterVisitMethod.visitLabel(label7);
                methodWriterVisitMethod.visitLabel(label4);
                if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                    objectReaderCreatorASM.createObjectForNonConstructor(objectReadContext2, methodWriterContext4);
                } else {
                    methodWriterVisitMethod.aload(i8);
                }
                methodWriterVisitMethod.areturn();
                methodWriterVisitMethod.visitMaxs(5, 10);
            }
            if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                MethodWriterContext methodWriterContext10 = methodWriterContext3;
                genReadHashCode64ValueForNonDefaultConstructor(objectReadContext2, methodWriterContext10, i9, z5, i8,
                        label2);
                methodWriterContext4 = methodWriterContext10;
                label14 = label2;
            } else {
                label14 = label2;
                methodWriterContext4 = methodWriterContext3;
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.lload(i9);
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.lload(4);
                methodWriterVisitMethod.aload(i8);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "readFieldValue",
                        READ_FIELD_READER_UL);
            }
            methodWriterVisitMethod.goto_(label14);
            label4 = label18;
            label5 = label22;
            label7 = label23;
            z7 = z3;
            i11 = iVar2;
            label6 = label14;
            objectReaderCreatorASM = this;
            if (!z7) {
                if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
                } else {
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.aload(i8);
                    methodWriterVisitMethod.lload(4);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "processExtra",
                            METHOD_DESC_PROCESS_EXTRA);
                }
                methodWriterVisitMethod.goto_(label6);
            }
            methodWriterVisitMethod.visitLabel(label6);
            if (!zDisableAutoType) {
                methodWriterVisitMethod.visitIincInsn(i11, 1);
            }
            methodWriterVisitMethod.goto_(label5);
            methodWriterVisitMethod.visitLabel(label7);
            methodWriterVisitMethod.visitLabel(label4);
            if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                objectReaderCreatorASM.createObjectForNonConstructor(objectReadContext2, methodWriterContext4);
            } else {
                methodWriterVisitMethod.aload(i8);
            }
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitMaxs(5, 10);
        }
        methodWriterContext2 = methodWriterContext6;
        z4 = z;
        genRead57(objectReadContext2, z4, methodWriterContext2, i20, label25, label26);
        label = label26;
        label2 = label25;
        i8 = i20;
        methodWriterContext = methodWriterContext2;
        z2 = z4;
        z3 = true;
        methodWriterVisitMethod.visitLabel(label);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.invokevirtual(str10, "readFieldNameHashCode", "()J");
        methodWriterVisitMethod.dup2();
        i9 = i5;
        methodWriterVisitMethod.lstore(i9);
        str3 = "()J";
        z5 = z2;
        methodWriterVisitMethod.visitLdcInsn(-1L);
        methodWriterVisitMethod.lcmp();
        methodWriterVisitMethod.ifeq(label23);
        methodWriterContext3 = zDisableAutoType ? methodWriterContext : methodWriterContext;
        if (z3) {
            i10 = i9;
            methodWriterContext4 = methodWriterContext3;
            z6 = z5;
            label3 = label2;
            if (fieldReaderArr2.length > 6) {
                treeMap = new TreeMap();
                z8 = z6;
                i14 = 0;
                while (true) {
                    jArr = objectReadContext2.objectReaderAdapter.hashCodes;
                    methodWriterContext5 = methodWriterContext4;
                    if (i14 < jArr.length) {
                        break;
                        break;
                    }
                    long j42 = jArr[i14];
                    ((List) treeMap.computeIfAbsent(Integer.valueOf((int) (j42 ^ (j42 >>> 32))), new cpl(10)))
                            .add(Long.valueOf(j42));
                    i14++;
                    methodWriterContext4 = methodWriterContext5;
                    i8 = i8;
                }
                i15 = i8;
                size = treeMap.size();
                iArr = new int[size];
                it = treeMap.keySet().iterator();
                i16 = 0;
                while (it.hasNext()) {
                    iArr[i16] = ((Integer) it.next()).intValue();
                    i16++;
                }
                Arrays.sort(iArr);
                methodWriterVisitMethod.lload(i10);
                methodWriterVisitMethod.lload(i10);
                methodWriterVisitMethod.bipush(32);
                methodWriterVisitMethod.lushr();
                methodWriterVisitMethod.lxor();
                methodWriterVisitMethod.l2i();
                int i222 = i4;
                methodWriterVisitMethod.istore(i222);
                label10 = new Label();
                str4 = "getNameHashCodeLCase";
                labelArr = new Label[size];
                z7 = z3;
                while (i17 < size) {
                    labelArr[i17] = new Label();
                }
                methodWriterVisitMethod.iload(i222);
                methodWriterVisitMethod.visitLookupSwitchInsn(label10, iArr, labelArr);
                i18 = 0;
                while (i18 < size) {
                    methodWriterVisitMethod.visitLabel(labelArr[i18]);
                    list = (List) treeMap.get(Integer.valueOf(iArr[i18]));
                    Label[] labelArr22 = labelArr;
                    size2 = list.size();
                    int i232 = i18;
                    i19 = 0;
                    while (i19 < size2) {
                        List list22 = list;
                        int i242 = size;
                        long jLongValue2 = ((Long) list.get(i19)).longValue();
                        TreeMap treeMap22 = treeMap;
                        if (size2 > 1) {
                        }
                        methodWriterVisitMethod.lload(i10);
                        methodWriterVisitMethod.visitLdcInsn(jLongValue2);
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifne(label28);
                        label12 = label28;
                        short s2 = objectReadContext2.objectReaderAdapter.mapping[Arrays
                                .binarySearch(objectReadContext2.objectReaderAdapter.hashCodes, jLongValue2)];
                        int i252 = i10;
                        int i262 = size2;
                        boolean z102 = z8;
                        Label label292 = label22;
                        String str112 = str4;
                        int i272 = iVar2;
                        int i282 = i19;
                        String str122 = str3;
                        int[] iArr22 = iArr;
                        int i292 = i15;
                        MethodWriterContext methodWriterContext72 = methodWriterContext5;
                        Label label302 = label18;
                        Label label312 = label3;
                        Label label322 = label23;
                        label13 = label10;
                        genReadFieldValue(objectReadContext2, fieldReaderArr2[s2], z102, methodWriterContext72, i292,
                                s2, false);
                        methodWriterVisitMethod.goto_(label312);
                        if (label12 != label13) {
                            methodWriterVisitMethod.visitLabel(label12);
                        }
                        str4 = str112;
                        iVar2 = i272;
                        label10 = label13;
                        label23 = label322;
                        size2 = i262;
                        label22 = label292;
                        i10 = i252;
                        z8 = z102;
                        i15 = i292;
                        label3 = label312;
                        label18 = label302;
                        iArr = iArr22;
                        list = list22;
                        methodWriterContext5 = methodWriterContext72;
                        str3 = str122;
                        size = i242;
                        i19 = i282 + 1;
                        treeMap = treeMap22;
                    }
                    int i302 = size;
                    MethodWriterContext methodWriterContext82 = methodWriterContext5;
                    Label label332 = label18;
                    Label label342 = label3;
                    methodWriterVisitMethod.goto_(label342);
                    str4 = str4;
                    iVar2 = iVar2;
                    iArr = iArr;
                    label23 = label23;
                    labelArr = labelArr22;
                    i10 = i10;
                    z8 = z8;
                    label3 = label342;
                    str3 = str3;
                    label18 = label332;
                    i18 = i232 + 1;
                    methodWriterContext5 = methodWriterContext82;
                    treeMap = treeMap;
                    size = i302;
                }
                str5 = str4;
                i11 = iVar2;
                label5 = label22;
                methodWriterContext4 = methodWriterContext5;
                str6 = str3;
                i8 = i15;
                label4 = label18;
                label6 = label3;
                label7 = label23;
                methodWriterVisitMethod.visitLabel(label10);
                if (!zDisableSmartMatch) {
                    label11 = new Label();
                    feature2 = JSONReader.Feature.SupportSmartMatch;
                    if ((j & feature2.mask) == 0) {
                        methodWriterVisitMethod.lload(4);
                        methodWriterVisitMethod.visitLdcInsn(feature2.mask);
                        methodWriterVisitMethod.land();
                        methodWriterVisitMethod.lconst_0();
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifeq(label11);
                    }
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, str5, str6);
                    methodWriterVisitMethod.invokeinterface(ASMUtils.TYPE_OBJECT_READER, "getFieldReaderLCase",
                            METHOD_DESC_GET_FIELD_READER);
                    methodWriterVisitMethod.dup();
                    int i312 = i2;
                    methodWriterVisitMethod.astore(i312);
                    methodWriterVisitMethod.ifnull(label11);
                    methodWriterVisitMethod.aload(i312);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.aload(i8);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_FIELD_READE, "readFieldValue",
                            METHOD_DESC_READ_FIELD_VALUE);
                    methodWriterVisitMethod.goto_(label6);
                    methodWriterVisitMethod.visitLabel(label11);
                }
            } else {
                label4 = label18;
                label5 = label22;
                z7 = z3;
                i11 = iVar2;
                label6 = label3;
                label7 = label23;
                i12 = 0;
                while (i12 < fieldReaderArr2.length) {
                    Label label352 = new Label();
                    Label label362 = new Label();
                    FieldReader fieldReader3 = fieldReaderArr2[i12];
                    String str132 = fieldReader3.fieldName;
                    boolean z112 = z6;
                    long j52 = fieldReader3.fieldNameHash;
                    methodWriterVisitMethod.lload(i10);
                    methodWriterVisitMethod.visitLdcInsn(j52);
                    methodWriterVisitMethod.lcmp();
                    methodWriterVisitMethod.ifne(label352);
                    methodWriterVisitMethod.visitLabel(label362);
                    methodWriterContext4 = methodWriterContext4;
                    z6 = z112;
                    genReadFieldValue(objectReadContext2, fieldReader3, z6, methodWriterContext4, i8, i12, false);
                    methodWriterVisitMethod.goto_(label6);
                    methodWriterVisitMethod.visitLabel(label352);
                    i12++;
                    objectReadContext2 = objectReadContext;
                }
                label8 = new Label();
                if (!zDisableSmartMatch) {
                    feature = JSONReader.Feature.SupportSmartMatch;
                    if ((j & feature.mask) == 0) {
                        methodWriterVisitMethod.lload(4);
                        methodWriterVisitMethod.visitLdcInsn(feature.mask);
                        methodWriterVisitMethod.land();
                        methodWriterVisitMethod.lconst_0();
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifeq(label8);
                    }
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "getNameHashCodeLCase", str3);
                    methodWriterVisitMethod.lstore(i10);
                    i13 = 0;
                    while (i13 < fieldReaderArr2.length) {
                        label9 = new Label();
                        Label label372 = new Label();
                        FieldReader fieldReader22 = fieldReaderArr2[i13];
                        String str142 = fieldReader22.fieldName;
                        boolean z122 = z6;
                        MethodWriterContext methodWriterContext92 = methodWriterContext4;
                        j2 = fieldReader22.fieldNameHash;
                        int i322 = i8;
                        int i332 = i13;
                        j3 = fieldReader22.fieldNameHashLCase;
                        methodWriterVisitMethod.lload(i10);
                        methodWriterVisitMethod.visitLdcInsn(j2);
                        methodWriterVisitMethod.lcmp();
                        methodWriterVisitMethod.ifeq(label372);
                        if (j3 != j2) {
                            methodWriterVisitMethod.lload(i10);
                            methodWriterVisitMethod.visitLdcInsn(j3);
                            methodWriterVisitMethod.lcmp();
                            methodWriterVisitMethod.ifne(label9);
                        } else {
                            methodWriterVisitMethod.goto_(label9);
                        }
                        methodWriterVisitMethod.visitLabel(label372);
                        methodWriterContext4 = methodWriterContext92;
                        z6 = z122;
                        i8 = i322;
                        genReadFieldValue(objectReadContext, fieldReader22, z6, methodWriterContext4, i8, i332, false);
                        methodWriterVisitMethod.goto_(label6);
                        methodWriterVisitMethod.visitLabel(label9);
                        i13 = i332 + 1;
                    }
                }
                objectReaderCreatorASM = this;
                objectReadContext2 = objectReadContext;
                methodWriterVisitMethod.visitLabel(label8);
            }
            if (!z7) {
                if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
                } else {
                    methodWriterVisitMethod.aload(0);
                    methodWriterVisitMethod.aload(1);
                    methodWriterVisitMethod.aload(i8);
                    methodWriterVisitMethod.lload(4);
                    methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "processExtra",
                            METHOD_DESC_PROCESS_EXTRA);
                }
                methodWriterVisitMethod.goto_(label6);
            }
            methodWriterVisitMethod.visitLabel(label6);
            if (!zDisableAutoType) {
                methodWriterVisitMethod.visitIincInsn(i11, 1);
            }
            methodWriterVisitMethod.goto_(label5);
            methodWriterVisitMethod.visitLabel(label7);
            methodWriterVisitMethod.visitLabel(label4);
            if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                objectReaderCreatorASM.createObjectForNonConstructor(objectReadContext2, methodWriterContext4);
            } else {
                methodWriterVisitMethod.aload(i8);
            }
            methodWriterVisitMethod.areturn();
            methodWriterVisitMethod.visitMaxs(5, 10);
        }
        if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            MethodWriterContext methodWriterContext102 = methodWriterContext3;
            genReadHashCode64ValueForNonDefaultConstructor(objectReadContext2, methodWriterContext102, i9, z5, i8,
                    label2);
            methodWriterContext4 = methodWriterContext102;
            label14 = label2;
        } else {
            label14 = label2;
            methodWriterContext4 = methodWriterContext3;
            methodWriterVisitMethod.aload(0);
            methodWriterVisitMethod.lload(i9);
            methodWriterVisitMethod.aload(1);
            methodWriterVisitMethod.lload(4);
            methodWriterVisitMethod.aload(i8);
            methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "readFieldValue",
                    READ_FIELD_READER_UL);
        }
        methodWriterVisitMethod.goto_(label14);
        label4 = label18;
        label5 = label22;
        label7 = label23;
        z7 = z3;
        i11 = iVar2;
        label6 = label14;
        objectReaderCreatorASM = this;
        if (!z7) {
            if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
            } else {
                methodWriterVisitMethod.aload(0);
                methodWriterVisitMethod.aload(1);
                methodWriterVisitMethod.aload(i8);
                methodWriterVisitMethod.lload(4);
                methodWriterVisitMethod.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "processExtra",
                        METHOD_DESC_PROCESS_EXTRA);
            }
            methodWriterVisitMethod.goto_(label6);
        }
        methodWriterVisitMethod.visitLabel(label6);
        if (!zDisableAutoType) {
            methodWriterVisitMethod.visitIincInsn(i11, 1);
        }
        methodWriterVisitMethod.goto_(label5);
        methodWriterVisitMethod.visitLabel(label7);
        methodWriterVisitMethod.visitLabel(label4);
        if (objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            objectReaderCreatorASM.createObjectForNonConstructor(objectReadContext2, methodWriterContext4);
        } else {
            methodWriterVisitMethod.aload(i8);
        }
        methodWriterVisitMethod.areturn();
        methodWriterVisitMethod.visitMaxs(5, 10);
    }

    /* JADX WARN: Found duplicated region for block: B:140:0x0a8b */
    /* JADX WARN: Found duplicated region for block: B:141:0x0a8e */
    /* JADX WARN: Found duplicated region for block: B:144:0x0ab0 */
    /* JADX WARN: Found duplicated region for block: B:157:0x0ab5 A[SYNTHETIC] */
    private void genRead243(ObjectReadContext objectReadContext, boolean z, MethodWriterContext methodWriterContext,
            int i, Label label, Label label2) {
        boolean z2;
        Label label3;
        boolean z3;
        int i2;
        String str = objectReadContext.classNameType;
        FieldReader[] fieldReaderArr = objectReadContext.fieldReaders;
        boolean z4 = methodWriterContext.jsonb;
        MethodWriter methodWriter = methodWriterContext.mw;
        IdentityHashMap identityHashMap = new IdentityHashMap();
        TreeMap treeMap = new TreeMap();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            z2 = true;
            if (i4 >= fieldReaderArr.length) {
                break;
            }
            FieldReader fieldReader = fieldReaderArr[i4];
            identityHashMap.put(fieldReader, Integer.valueOf(i4));
            byte[] bArr = new byte[4];
            if (z4) {
                byte[] bytes = JSONB.toBytes(fieldReader.fieldName);
                System.arraycopy(bytes, 0, bArr, 0, Math.min(4, bytes.length));
            } else {
                byte[] bytes2 = fieldReader.fieldName.getBytes(StandardCharsets.UTF_8);
                bArr[0] = 34;
                if (bytes2.length == 2) {
                    System.arraycopy(bytes2, 0, bArr, 1, 2);
                    bArr[3] = 34;
                } else {
                    System.arraycopy(bytes2, 0, bArr, 1, 3);
                }
            }
            int i5 = JDKUtils.UNSAFE.getInt(bArr, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
            List arrayList = (List) treeMap.get(Integer.valueOf(i5));
            if (arrayList == null) {
                arrayList = new ArrayList();
                treeMap.put(Integer.valueOf(i5), arrayList);
            }
            arrayList.add(fieldReader);
            i4++;
        }
        Label label4 = new Label();
        int[] iArr = new int[treeMap.size()];
        int size = treeMap.size();
        Label[] labelArr = new Label[size];
        Iterator it = treeMap.keySet().iterator();
        for (int i6 = 0; i6 < size; i6++) {
            labelArr[i6] = new Label();
            iArr[i6] = ((Integer) it.next()).intValue();
        }
        methodWriter.aload(1);
        int i7 = 3;
        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "getRawInt", "()I");
        methodWriter.visitLookupSwitchInsn(label4, iArr, labelArr);
        int i8 = 0;
        while (i8 < size) {
            methodWriter.visitLabel(labelArr[i8]);
            List list = (List) treeMap.get(Integer.valueOf(iArr[i8]));
            int i9 = i3;
            while (i9 < list.size()) {
                int i10 = i9 + 1;
                Label label5 = i10 != list.size() ? new Label() : null;
                FieldReader fieldReader2 = (FieldReader) list.get(i9);
                int iIntValue = ((Integer) identityHashMap.get(fieldReader2)).intValue();
                Label label6 = label4;
                byte[] bytes3 = fieldReader2.fieldName.getBytes(StandardCharsets.UTF_8);
                int length = bytes3.length;
                int[] iArr2 = iArr;
                int i11 = size;
                Label[] labelArr2 = labelArr;
                boolean z5 = z4;
                IdentityHashMap identityHashMap2 = identityHashMap;
                TreeMap treeMap2 = treeMap;
                int i12 = i8;
                List list2 = list;
                switch (length) {
                    case 2:
                        label3 = label5;
                        z3 = true;
                        i2 = 0;
                        methodWriter.aload(1);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match2", "()Z");
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 3:
                        label3 = label5;
                        z3 = true;
                        i2 = 0;
                        methodWriter.aload(1);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match3", "()Z");
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 4:
                        label3 = label5;
                        z3 = true;
                        i2 = 0;
                        methodWriter.aload(1);
                        i7 = 3;
                        methodWriter.iconst_n(bytes3[3]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match4", "(B)Z");
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 5:
                        label3 = label5;
                        z3 = true;
                        byte b = bytes3[i7];
                        byte b2 = bytes3[4];
                        byte[] bArr2 = new byte[4];
                        i2 = 0;
                        bArr2[0] = b;
                        bArr2[1] = b2;
                        bArr2[2] = 34;
                        bArr2[i7] = 58;
                        int i13 = JDKUtils.UNSAFE.getInt(bArr2, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                        if (z5) {
                            i13 &= 65535;
                        }
                        methodWriter.aload(1);
                        methodWriter.iconst_n(i13);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match5", "(I)Z");
                        i7 = 3;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 6:
                        label3 = label5;
                        byte b3 = bytes3[i7];
                        byte b4 = bytes3[4];
                        byte b5 = bytes3[5];
                        byte[] bArr3 = new byte[4];
                        bArr3[0] = b3;
                        z3 = true;
                        bArr3[1] = b4;
                        bArr3[2] = b5;
                        bArr3[i7] = 34;
                        int i14 = JDKUtils.UNSAFE.getInt(bArr3, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                        if (z5) {
                            i14 &= 16777215;
                        }
                        methodWriter.aload(1);
                        methodWriter.iconst_n(i14);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match6", "(I)Z");
                        i7 = 3;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 7:
                        label3 = label5;
                        int i15 = JDKUtils.UNSAFE.getInt(bytes3, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                        methodWriter.aload(1);
                        methodWriter.iconst_n(i15);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match7", "(I)Z");
                        z3 = true;
                        i7 = 3;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 8:
                        label3 = label5;
                        int i16 = JDKUtils.UNSAFE.getInt(bytes3, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                        methodWriter.aload(1);
                        methodWriter.iconst_n(i16);
                        methodWriter.iconst_n(bytes3[7]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match8", "(IB)Z");
                        z3 = true;
                        i7 = 3;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 9:
                        label3 = label5;
                        byte[] bArr4 = new byte[8];
                        System.arraycopy(bytes3, 3, bArr4, 0, 6);
                        bArr4[6] = 34;
                        bArr4[7] = 58;
                        long j = JDKUtils.UNSAFE.getLong(bArr4, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                        if (z5) {
                            j &= 281474976710655L;
                        }
                        z3 = true;
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match9", "(J)Z");
                        i7 = 3;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 10:
                        label3 = label5;
                        byte[] bArr5 = new byte[8];
                        System.arraycopy(bytes3, i7, bArr5, 0, 7);
                        bArr5[7] = 34;
                        long j2 = JDKUtils.UNSAFE.getLong(bArr5, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                        if (z5) {
                            j2 &= 72057594037927935L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j2);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match10", "(J)Z");
                        z3 = true;
                        i7 = 3;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 11:
                        label3 = label5;
                        long j3 = JDKUtils.UNSAFE.getLong(bytes3, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j3);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match11", "(J)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 12:
                        label3 = label5;
                        long j4 = JDKUtils.UNSAFE.getLong(bytes3, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j4);
                        methodWriter.iconst_n(bytes3[11]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match12", "(JB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 13:
                        label3 = label5;
                        Unsafe unsafe = JDKUtils.UNSAFE;
                        long j5 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j6 = unsafe.getLong(bytes3, j5 + 3);
                        byte b6 = bytes3[11];
                        byte b7 = bytes3[12];
                        byte[] bArr6 = new byte[4];
                        bArr6[0] = b6;
                        bArr6[1] = b7;
                        bArr6[2] = 34;
                        bArr6[i7] = 58;
                        int i17 = unsafe.getInt(bArr6, j5);
                        if (z5) {
                            i17 &= 65535;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j6);
                        methodWriter.iconst_n(i17);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match13", "(JI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 14:
                        label3 = label5;
                        Unsafe unsafe2 = JDKUtils.UNSAFE;
                        long j7 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j8 = unsafe2.getLong(bytes3, j7 + 3);
                        byte b8 = bytes3[11];
                        byte b9 = bytes3[12];
                        byte b10 = bytes3[13];
                        byte[] bArr7 = new byte[4];
                        bArr7[0] = b8;
                        bArr7[1] = b9;
                        bArr7[2] = b10;
                        bArr7[i7] = 34;
                        int i18 = unsafe2.getInt(bArr7, j7);
                        if (z5) {
                            i18 &= 16777215;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j8);
                        methodWriter.iconst_n(i18);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match14", "(JI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 15:
                        label3 = label5;
                        Unsafe unsafe3 = JDKUtils.UNSAFE;
                        long j9 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j10 = unsafe3.getLong(bytes3, j9 + 3);
                        int i19 = unsafe3.getInt(bytes3, j9 + 11);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j10);
                        methodWriter.iconst_n(i19);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match15", "(JI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 16:
                        label3 = label5;
                        Unsafe unsafe4 = JDKUtils.UNSAFE;
                        long j11 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j12 = unsafe4.getLong(bytes3, j11 + 3);
                        int i20 = unsafe4.getInt(bytes3, j11 + 11);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j12);
                        methodWriter.iconst_n(i20);
                        methodWriter.visitLdcInsn((int) bytes3[15]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match16", "(JIB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 17:
                        label3 = label5;
                        Unsafe unsafe5 = JDKUtils.UNSAFE;
                        long j13 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j14 = unsafe5.getLong(bytes3, j13 + 3);
                        byte[] bArr8 = new byte[8];
                        System.arraycopy(bytes3, 11, bArr8, 0, 6);
                        bArr8[6] = 34;
                        bArr8[7] = 58;
                        long j15 = unsafe5.getLong(bArr8, j13);
                        if (z5) {
                            j15 &= 281474976710655L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j14);
                        methodWriter.visitLdcInsn(j15);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match17", "(JJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 18:
                        label3 = label5;
                        Unsafe unsafe6 = JDKUtils.UNSAFE;
                        long j16 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j17 = unsafe6.getLong(bytes3, j16 + 3);
                        byte[] bArr9 = new byte[8];
                        System.arraycopy(bytes3, 11, bArr9, 0, 7);
                        bArr9[7] = 34;
                        long j18 = unsafe6.getLong(bArr9, j16);
                        if (z5) {
                            j18 &= 72057594037927935L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j17);
                        methodWriter.visitLdcInsn(j18);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match18", "(JJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 19:
                        label3 = label5;
                        Unsafe unsafe7 = JDKUtils.UNSAFE;
                        long j19 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j20 = unsafe7.getLong(bytes3, j19 + 3);
                        long j21 = unsafe7.getLong(bytes3, j19 + 11);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j20);
                        methodWriter.visitLdcInsn(j21);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match19", "(JJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 20:
                        label3 = label5;
                        Unsafe unsafe8 = JDKUtils.UNSAFE;
                        long j22 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j23 = unsafe8.getLong(bytes3, j22 + 3);
                        long j24 = unsafe8.getLong(bytes3, j22 + 11);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j23);
                        methodWriter.visitLdcInsn(j24);
                        methodWriter.iconst_n(bytes3[19]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match20", "(JJB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 21:
                        label3 = label5;
                        Unsafe unsafe9 = JDKUtils.UNSAFE;
                        long j25 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j26 = unsafe9.getLong(bytes3, j25 + 3);
                        long j27 = unsafe9.getLong(bytes3, j25 + 11);
                        byte b11 = bytes3[19];
                        byte b12 = bytes3[20];
                        byte[] bArr10 = new byte[4];
                        bArr10[0] = b11;
                        bArr10[1] = b12;
                        bArr10[2] = 34;
                        bArr10[i7] = 58;
                        int i21 = unsafe9.getInt(bArr10, j25);
                        if (z5) {
                            i21 &= 65535;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j26);
                        methodWriter.visitLdcInsn(j27);
                        methodWriter.iconst_n(i21);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match21", "(JJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 22:
                        label3 = label5;
                        Unsafe unsafe10 = JDKUtils.UNSAFE;
                        long j28 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j29 = unsafe10.getLong(bytes3, j28 + 3);
                        long j30 = unsafe10.getLong(bytes3, j28 + 11);
                        byte b13 = bytes3[19];
                        byte b14 = bytes3[20];
                        byte b15 = bytes3[21];
                        byte[] bArr11 = new byte[4];
                        bArr11[0] = b13;
                        bArr11[1] = b14;
                        bArr11[2] = b15;
                        bArr11[i7] = 34;
                        int i22 = unsafe10.getInt(bArr11, j28);
                        if (z5) {
                            i22 &= 16777215;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j29);
                        methodWriter.visitLdcInsn(j30);
                        methodWriter.iconst_n(i22);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match22", "(JJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 23:
                        label3 = label5;
                        Unsafe unsafe11 = JDKUtils.UNSAFE;
                        long j31 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j32 = unsafe11.getLong(bytes3, j31 + 3);
                        long j33 = unsafe11.getLong(bytes3, j31 + 11);
                        int i23 = unsafe11.getInt(bytes3, j31 + 19);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j32);
                        methodWriter.visitLdcInsn(j33);
                        methodWriter.iconst_n(i23);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match23", "(JJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 24:
                        label3 = label5;
                        Unsafe unsafe12 = JDKUtils.UNSAFE;
                        long j34 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j35 = unsafe12.getLong(bytes3, j34 + 3);
                        long j36 = unsafe12.getLong(bytes3, j34 + 11);
                        int i24 = unsafe12.getInt(bytes3, j34 + 19);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j35);
                        methodWriter.visitLdcInsn(j36);
                        methodWriter.iconst_n(i24);
                        methodWriter.visitLdcInsn((int) bytes3[23]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match24", "(JJIB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 25:
                        label3 = label5;
                        Unsafe unsafe13 = JDKUtils.UNSAFE;
                        long j37 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j38 = unsafe13.getLong(bytes3, j37 + 3);
                        long j39 = unsafe13.getLong(bytes3, j37 + 11);
                        byte[] bArr12 = new byte[8];
                        System.arraycopy(bytes3, 19, bArr12, 0, 6);
                        bArr12[6] = 34;
                        bArr12[7] = 58;
                        long j40 = unsafe13.getLong(bArr12, j37);
                        if (z5) {
                            j40 &= 281474976710655L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j38);
                        methodWriter.visitLdcInsn(j39);
                        methodWriter.visitLdcInsn(j40);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match25", "(JJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 26:
                        label3 = label5;
                        Unsafe unsafe14 = JDKUtils.UNSAFE;
                        long j41 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j42 = unsafe14.getLong(bytes3, j41 + 3);
                        long j43 = unsafe14.getLong(bytes3, j41 + 11);
                        byte[] bArr13 = new byte[8];
                        System.arraycopy(bytes3, 19, bArr13, 0, 7);
                        bArr13[7] = 34;
                        long j44 = unsafe14.getLong(bArr13, j41);
                        if (z5) {
                            j44 &= 72057594037927935L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j42);
                        methodWriter.visitLdcInsn(j43);
                        methodWriter.visitLdcInsn(j44);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match26", "(JJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 27:
                        label3 = label5;
                        Unsafe unsafe15 = JDKUtils.UNSAFE;
                        long j45 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j46 = unsafe15.getLong(bytes3, j45 + 3);
                        long j47 = unsafe15.getLong(bytes3, j45 + 11);
                        long j48 = unsafe15.getLong(bytes3, j45 + 19);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j46);
                        methodWriter.visitLdcInsn(j47);
                        methodWriter.visitLdcInsn(j48);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match27", "(JJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 28:
                        label3 = label5;
                        Unsafe unsafe16 = JDKUtils.UNSAFE;
                        long j49 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j50 = unsafe16.getLong(bytes3, j49 + 3);
                        long j51 = unsafe16.getLong(bytes3, j49 + 11);
                        long j52 = unsafe16.getLong(bytes3, j49 + 19);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j50);
                        methodWriter.visitLdcInsn(j51);
                        methodWriter.visitLdcInsn(j52);
                        methodWriter.visitLdcInsn((int) bytes3[27]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match28", "(JJJB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 29:
                        label3 = label5;
                        Unsafe unsafe17 = JDKUtils.UNSAFE;
                        long j53 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j54 = unsafe17.getLong(bytes3, j53 + 3);
                        long j55 = unsafe17.getLong(bytes3, j53 + 11);
                        long j56 = unsafe17.getLong(bytes3, j53 + 19);
                        byte b16 = bytes3[27];
                        byte b17 = bytes3[28];
                        byte[] bArr14 = new byte[4];
                        bArr14[0] = b16;
                        bArr14[1] = b17;
                        bArr14[2] = 34;
                        bArr14[i7] = 58;
                        int i25 = unsafe17.getInt(bArr14, j53);
                        if (z5) {
                            i25 &= 65535;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j54);
                        methodWriter.visitLdcInsn(j55);
                        methodWriter.visitLdcInsn(j56);
                        methodWriter.iconst_n(i25);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match29", "(JJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 30:
                        label3 = label5;
                        Unsafe unsafe18 = JDKUtils.UNSAFE;
                        long j57 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j58 = unsafe18.getLong(bytes3, j57 + 3);
                        long j59 = unsafe18.getLong(bytes3, j57 + 11);
                        long j60 = unsafe18.getLong(bytes3, j57 + 19);
                        byte b18 = bytes3[27];
                        byte b19 = bytes3[28];
                        byte b20 = bytes3[29];
                        byte[] bArr15 = new byte[4];
                        bArr15[0] = b18;
                        bArr15[1] = b19;
                        bArr15[2] = b20;
                        bArr15[i7] = 34;
                        int i26 = unsafe18.getInt(bArr15, j57);
                        if (z5) {
                            i26 &= 16777215;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j58);
                        methodWriter.visitLdcInsn(j59);
                        methodWriter.visitLdcInsn(j60);
                        methodWriter.iconst_n(i26);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match30", "(JJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 31:
                        label3 = label5;
                        Unsafe unsafe19 = JDKUtils.UNSAFE;
                        long j61 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j62 = unsafe19.getLong(bytes3, j61 + 3);
                        long j63 = unsafe19.getLong(bytes3, j61 + 11);
                        long j64 = unsafe19.getLong(bytes3, j61 + 19);
                        int i27 = unsafe19.getInt(bytes3, j61 + 27);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j62);
                        methodWriter.visitLdcInsn(j63);
                        methodWriter.visitLdcInsn(j64);
                        methodWriter.iconst_n(i27);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match31", "(JJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 32:
                        label3 = label5;
                        Unsafe unsafe20 = JDKUtils.UNSAFE;
                        long j65 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j66 = unsafe20.getLong(bytes3, j65 + 3);
                        long j67 = unsafe20.getLong(bytes3, j65 + 11);
                        long j68 = unsafe20.getLong(bytes3, j65 + 19);
                        int i28 = unsafe20.getInt(bytes3, j65 + 27);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j66);
                        methodWriter.visitLdcInsn(j67);
                        methodWriter.visitLdcInsn(j68);
                        methodWriter.visitLdcInsn(i28);
                        methodWriter.iconst_n(bytes3[31]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match32", "(JJJIB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 33:
                        label3 = label5;
                        Unsafe unsafe21 = JDKUtils.UNSAFE;
                        long j69 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j70 = unsafe21.getLong(bytes3, j69 + 3);
                        long j71 = unsafe21.getLong(bytes3, j69 + 11);
                        long j72 = unsafe21.getLong(bytes3, j69 + 19);
                        byte[] bArr16 = new byte[8];
                        System.arraycopy(bytes3, 27, bArr16, 0, 6);
                        bArr16[6] = 34;
                        bArr16[7] = 58;
                        long j73 = unsafe21.getLong(bArr16, j69);
                        if (z5) {
                            j73 &= 281474976710655L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j70);
                        methodWriter.visitLdcInsn(j71);
                        methodWriter.visitLdcInsn(j72);
                        methodWriter.visitLdcInsn(j73);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match33", "(JJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 34:
                        label3 = label5;
                        Unsafe unsafe22 = JDKUtils.UNSAFE;
                        long j74 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j75 = unsafe22.getLong(bytes3, j74 + 3);
                        long j76 = unsafe22.getLong(bytes3, j74 + 11);
                        long j77 = unsafe22.getLong(bytes3, j74 + 19);
                        byte[] bArr17 = new byte[8];
                        System.arraycopy(bytes3, 27, bArr17, 0, 7);
                        bArr17[7] = 34;
                        long j78 = unsafe22.getLong(bArr17, j74);
                        if (z5) {
                            j78 &= 72057594037927935L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j75);
                        methodWriter.visitLdcInsn(j76);
                        methodWriter.visitLdcInsn(j77);
                        methodWriter.visitLdcInsn(j78);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match34", "(JJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 35:
                        label3 = label5;
                        Unsafe unsafe23 = JDKUtils.UNSAFE;
                        long j79 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j80 = unsafe23.getLong(bytes3, j79 + 3);
                        long j81 = unsafe23.getLong(bytes3, j79 + 11);
                        long j82 = unsafe23.getLong(bytes3, j79 + 19);
                        long j83 = unsafe23.getLong(bytes3, j79 + 27);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j80);
                        methodWriter.visitLdcInsn(j81);
                        methodWriter.visitLdcInsn(j82);
                        methodWriter.visitLdcInsn(j83);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match35", "(JJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 36:
                        label3 = label5;
                        Unsafe unsafe24 = JDKUtils.UNSAFE;
                        long j84 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j85 = unsafe24.getLong(bytes3, j84 + 3);
                        long j86 = unsafe24.getLong(bytes3, j84 + 11);
                        long j87 = unsafe24.getLong(bytes3, j84 + 19);
                        long j88 = unsafe24.getLong(bytes3, j84 + 27);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j85);
                        methodWriter.visitLdcInsn(j86);
                        methodWriter.visitLdcInsn(j87);
                        methodWriter.visitLdcInsn(j88);
                        methodWriter.iconst_n(bytes3[35]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match36", "(JJJJB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 37:
                        label3 = label5;
                        Unsafe unsafe25 = JDKUtils.UNSAFE;
                        long j89 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j90 = unsafe25.getLong(bytes3, j89 + 3);
                        long j91 = unsafe25.getLong(bytes3, j89 + 11);
                        long j92 = unsafe25.getLong(bytes3, j89 + 19);
                        long j93 = unsafe25.getLong(bytes3, j89 + 27);
                        byte b21 = bytes3[35];
                        byte b22 = bytes3[36];
                        byte[] bArr18 = new byte[4];
                        bArr18[0] = b21;
                        bArr18[1] = b22;
                        bArr18[2] = 34;
                        bArr18[i7] = 58;
                        int i29 = unsafe25.getInt(bArr18, j89);
                        if (z5) {
                            i29 &= 65535;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j90);
                        methodWriter.visitLdcInsn(j91);
                        methodWriter.visitLdcInsn(j92);
                        methodWriter.visitLdcInsn(j93);
                        methodWriter.iconst_n(i29);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match37", "(JJJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 38:
                        label3 = label5;
                        Unsafe unsafe26 = JDKUtils.UNSAFE;
                        long j94 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j95 = unsafe26.getLong(bytes3, j94 + 3);
                        long j96 = unsafe26.getLong(bytes3, j94 + 11);
                        long j97 = unsafe26.getLong(bytes3, j94 + 19);
                        long j98 = unsafe26.getLong(bytes3, j94 + 27);
                        byte b23 = bytes3[35];
                        byte b24 = bytes3[36];
                        byte b25 = bytes3[37];
                        byte[] bArr19 = new byte[4];
                        bArr19[0] = b23;
                        bArr19[1] = b24;
                        bArr19[2] = b25;
                        bArr19[i7] = 34;
                        int i30 = unsafe26.getInt(bArr19, j94);
                        if (z5) {
                            i30 &= 16777215;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j95);
                        methodWriter.visitLdcInsn(j96);
                        methodWriter.visitLdcInsn(j97);
                        methodWriter.visitLdcInsn(j98);
                        methodWriter.iconst_n(i30);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match38", "(JJJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 39:
                        label3 = label5;
                        Unsafe unsafe27 = JDKUtils.UNSAFE;
                        long j99 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j100 = unsafe27.getLong(bytes3, j99 + 3);
                        long j101 = unsafe27.getLong(bytes3, j99 + 11);
                        long j102 = unsafe27.getLong(bytes3, j99 + 19);
                        long j103 = unsafe27.getLong(bytes3, j99 + 27);
                        int i31 = unsafe27.getInt(bytes3, j99 + 35);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j100);
                        methodWriter.visitLdcInsn(j101);
                        methodWriter.visitLdcInsn(j102);
                        methodWriter.visitLdcInsn(j103);
                        methodWriter.iconst_n(i31);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match39", "(JJJJI)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 40:
                        label3 = label5;
                        Unsafe unsafe28 = JDKUtils.UNSAFE;
                        long j104 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j105 = unsafe28.getLong(bytes3, j104 + 3);
                        long j106 = unsafe28.getLong(bytes3, j104 + 11);
                        long j107 = unsafe28.getLong(bytes3, j104 + 19);
                        long j108 = unsafe28.getLong(bytes3, j104 + 27);
                        int i32 = unsafe28.getInt(bytes3, j104 + 35);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j105);
                        methodWriter.visitLdcInsn(j106);
                        methodWriter.visitLdcInsn(j107);
                        methodWriter.visitLdcInsn(j108);
                        methodWriter.iconst_n(i32);
                        methodWriter.iconst_n(bytes3[39]);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match40", "(JJJJIB)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 41:
                        label3 = label5;
                        Unsafe unsafe29 = JDKUtils.UNSAFE;
                        long j109 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j110 = unsafe29.getLong(bytes3, j109 + 3);
                        long j111 = unsafe29.getLong(bytes3, j109 + 11);
                        long j112 = unsafe29.getLong(bytes3, j109 + 19);
                        long j113 = unsafe29.getLong(bytes3, j109 + 27);
                        byte[] bArr20 = new byte[8];
                        System.arraycopy(bytes3, 35, bArr20, 0, 6);
                        bArr20[6] = 34;
                        bArr20[7] = 58;
                        long j114 = unsafe29.getLong(bArr20, j109);
                        if (z5) {
                            j114 &= 281474976710655L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j110);
                        methodWriter.visitLdcInsn(j111);
                        methodWriter.visitLdcInsn(j112);
                        methodWriter.visitLdcInsn(j113);
                        methodWriter.visitLdcInsn(j114);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match41", "(JJJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z6222222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z6222222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 42:
                        label3 = label5;
                        Unsafe unsafe30 = JDKUtils.UNSAFE;
                        long j115 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j116 = unsafe30.getLong(bytes3, j115 + 3);
                        long j117 = unsafe30.getLong(bytes3, j115 + 11);
                        long j118 = unsafe30.getLong(bytes3, j115 + 19);
                        long j119 = unsafe30.getLong(bytes3, j115 + 27);
                        byte[] bArr21 = new byte[8];
                        System.arraycopy(bytes3, 35, bArr21, 0, 7);
                        bArr21[7] = 34;
                        long j120 = unsafe30.getLong(bArr21, j115);
                        if (z5) {
                            j120 &= 72057594037927935L;
                        }
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j116);
                        methodWriter.visitLdcInsn(j117);
                        methodWriter.visitLdcInsn(j118);
                        methodWriter.visitLdcInsn(j119);
                        methodWriter.visitLdcInsn(j120);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match42", "(JJJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z62222222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z62222222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    case 43:
                        Unsafe unsafe31 = JDKUtils.UNSAFE;
                        long j121 = JDKUtils.ARRAY_BYTE_BASE_OFFSET;
                        long j122 = unsafe31.getLong(bytes3, j121 + 3);
                        long j123 = unsafe31.getLong(bytes3, j121 + 11);
                        long j124 = unsafe31.getLong(bytes3, j121 + 19);
                        long j125 = unsafe31.getLong(bytes3, j121 + 27);
                        label3 = label5;
                        long j126 = unsafe31.getLong(bytes3, j121 + 35);
                        methodWriter.aload(1);
                        methodWriter.visitLdcInsn(j122);
                        methodWriter.visitLdcInsn(j123);
                        methodWriter.visitLdcInsn(j124);
                        methodWriter.visitLdcInsn(j125);
                        methodWriter.visitLdcInsn(j126);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfName4Match43", "(JJJJJ)Z");
                        z3 = true;
                        i2 = 0;
                        methodWriter.ifeq(label3 != null ? label3 : label2);
                        boolean z622222222222222222222222222222222222222222 = z3;
                        genReadFieldValue(objectReadContext, fieldReader2, z, methodWriterContext, i, iIntValue, false);
                        methodWriter.goto_(label);
                        if (label3 != null) {
                            methodWriter.visitLabel(label3);
                        }
                        label4 = label6;
                        i3 = i2;
                        z2 = z622222222222222222222222222222222222222222;
                        iArr = iArr2;
                        size = i11;
                        labelArr = labelArr2;
                        z4 = z5;
                        identityHashMap = identityHashMap2;
                        treeMap = treeMap2;
                        i8 = i12;
                        i9 = i10;
                        list = list2;
                        break;
                    default:
                        throw new IllegalStateException(concatVar2Var1(length, "fieldNameLength "));
                }
            }
            boolean z7 = z4;
            Label label7 = label4;
            methodWriter.goto_(label7);
            i8++;
            label4 = label7;
            z4 = z7;
        }
        methodWriter.visitLabel(label4);
    }

    private void genRead57(ObjectReadContext objectReadContext, boolean z, MethodWriterContext methodWriterContext,
            int i, Label label, Label label2) {
        String str;
        MethodWriterContext methodWriterContext2 = methodWriterContext;
        ObjectReadContext objectReadContext2 = objectReadContext;
        FieldReader[] fieldReaderArr = objectReadContext2.fieldReaders;
        int iVar2 = methodWriterContext2.var2("RAW_LONG");
        MethodWriter methodWriter = methodWriterContext2.mw;
        methodWriter.aload(1);
        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "getRawLong", "()J");
        methodWriter.dup2();
        methodWriter.lstore(iVar2);
        methodWriter.lconst_0();
        methodWriter.lcmp();
        methodWriter.ifeq(label2);
        int i2 = 0;
        int i3 = 0;
        while (i3 < fieldReaderArr.length) {
            Label label3 = new Label();
            FieldReader fieldReader = fieldReaderArr[i3];
            byte[] bytes = fieldReader.fieldName.getBytes(StandardCharsets.UTF_8);
            int length = bytes.length;
            byte[] bArr = new byte[8];
            if (length == 5) {
                bArr[i2] = 34;
                System.arraycopy(bytes, i2, bArr, 1, 5);
                bArr[6] = 34;
                bArr[7] = 58;
                str = "nextIfName8Match0";
            } else if (length == 6) {
                bArr[i2] = 34;
                System.arraycopy(bytes, i2, bArr, 1, 6);
                bArr[7] = 34;
                str = "nextIfName8Match1";
            } else {
                if (length != 7) {
                    throw new IllegalStateException(concatVar2Var1(length, "length "));
                }
                bArr[i2] = 34;
                System.arraycopy(bytes, i2, bArr, 1, 7);
                str = "nextIfName8Match2";
            }
            long j = JDKUtils.UNSAFE.getLong(bArr, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
            methodWriter.lload(iVar2);
            methodWriter.visitLdcInsn(j);
            methodWriter.lcmp();
            methodWriter.ifne(label3);
            methodWriter.aload(1);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, str, "()Z");
            methodWriter.ifeq(label2);
            genReadFieldValue(objectReadContext2, fieldReader, z, methodWriterContext2, i, i3, false);
            methodWriter.goto_(label);
            methodWriter.visitLabel(label3);
            i3++;
            objectReadContext2 = objectReadContext;
            methodWriterContext2 = methodWriterContext;
            i2 = 0;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:55:0x02b5 */
    /* JADX WARN: Found duplicated region for block: B:56:0x02b7 */
    /* JADX WARN: Found duplicated region for block: B:59:0x02e2 */
    /* JADX WARN: Found duplicated region for block: B:76:0x02e5 A[SYNTHETIC] */
    private void genReadEnumValueRaw(FieldReader fieldReader, String str, MethodWriterContext methodWriterContext,
            int i, Type type, Class cls, long j, String str2) {
        int iMin;
        int iMax;
        Label[] labelArr;
        MethodWriter methodWriter = methodWriterContext.mw;
        boolean z = methodWriterContext.jsonb;
        Object[] enumConstants = cls.getEnumConstants();
        TreeMap treeMap = new TreeMap();
        int i2 = 2;
        int i3 = 4;
        int i4 = 0;
        if (enumConstants != null) {
            int i5 = 0;
            iMin = 0;
            iMax = 0;
            while (i5 < enumConstants.length) {
                Enum r15 = (Enum) enumConstants[i5];
                byte[] bytes = r15.name().getBytes(StandardCharsets.UTF_8);
                int length = bytes.length;
                if (i5 == 0) {
                    iMin = length;
                    iMax = iMin;
                } else {
                    iMin = Math.min(length, iMin);
                    iMax = Math.max(length, iMax);
                }
                byte[] bArr = new byte[i3];
                bArr[0] = 34;
                int i6 = i3;
                if (bytes.length == i2) {
                    System.arraycopy(bytes, 0, bArr, 1, i2);
                    bArr[3] = 34;
                } else if (bytes.length >= 3) {
                    System.arraycopy(bytes, 0, bArr, 1, 3);
                }
                int i7 = JDKUtils.UNSAFE.getInt(bArr, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                List arrayList = (List) treeMap.get(Integer.valueOf(i7));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    treeMap.put(Integer.valueOf(i7), arrayList);
                }
                arrayList.add(r15);
                i5++;
                i3 = i6;
                i2 = 2;
            }
        } else {
            iMin = 0;
            iMax = 0;
        }
        int i8 = i3;
        Label label = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        methodWriter.aload(0);
        String str3 = ASMUtils.DESC_OBJECT_READER;
        methodWriter.getfield(str, str2, str3);
        methodWriter.ifnonnull(label3);
        methodWriter.aload(0);
        methodWriter.aload(0);
        methodWriter.getfield(str, CodeGenUtils.fieldReader(i), ASMUtils.DESC_FIELD_READER);
        methodWriter.aload(1);
        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getObjectReader", METHOD_DESC_GET_OBJECT_READER_1);
        methodWriter.putfield(str, str2, str3);
        methodWriter.visitLabel(label3);
        methodWriter.aload(0);
        methodWriter.getfield(str, str2, str3);
        Class<ObjectReaderImplEnum> cls2 = ObjectReaderImplEnum.class;
        methodWriter.instanceOf(ASMUtils.type(cls2));
        methodWriter.ifeq(label);
        if (iMin >= 2 && iMax <= 11) {
            int[] iArr = new int[treeMap.size()];
            int size = treeMap.size();
            Label[] labelArr2 = new Label[size];
            Iterator it = treeMap.keySet().iterator();
            for (int i9 = 0; i9 < size; i9++) {
                labelArr2[i9] = new Label();
                iArr[i9] = ((Integer) it.next()).intValue();
            }
            methodWriter.aload(1);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "getRawInt", "()I");
            methodWriter.visitLookupSwitchInsn(label, iArr, labelArr2);
            int i10 = 0;
            while (i10 < size) {
                methodWriter.visitLabel(labelArr2[i10]);
                List list = (List) treeMap.get(Integer.valueOf(iArr[i10]));
                int i11 = i4;
                while (i11 < list.size()) {
                    Label label4 = i11 > 0 ? new Label() : null;
                    Enum r18 = (Enum) list.get(i11);
                    boolean z2 = z;
                    byte[] bytes2 = r18.name().getBytes(StandardCharsets.UTF_8);
                    int length2 = bytes2.length;
                    TreeMap treeMap2 = treeMap;
                    Class<ObjectReaderImplEnum> cls3 = cls2;
                    int[] iArr2 = iArr;
                    int i12 = size;
                    switch (length2) {
                        case 2:
                            labelArr = labelArr2;
                            methodWriter.aload(1);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match2", "()Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 3:
                            labelArr = labelArr2;
                            methodWriter.aload(1);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match3", "()Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 4:
                            labelArr = labelArr2;
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn((int) bytes2[3]);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match4", "(B)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 5:
                            labelArr = labelArr2;
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn((int) bytes2[3]);
                            i8 = 4;
                            methodWriter.visitLdcInsn((int) bytes2[4]);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match5", "(BB)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 6:
                            labelArr = labelArr2;
                            byte b = bytes2[3];
                            byte b2 = bytes2[i8];
                            byte b3 = bytes2[5];
                            byte[] bArr2 = new byte[i8];
                            bArr2[0] = b;
                            bArr2[1] = b2;
                            bArr2[2] = b3;
                            bArr2[3] = 34;
                            int i13 = JDKUtils.UNSAFE.getInt(bArr2, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(i13);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match6", "(I)Z");
                            i8 = 4;
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 7:
                            labelArr = labelArr2;
                            int i14 = JDKUtils.UNSAFE.getInt(bytes2, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(i14);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match7", "(I)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 8:
                            labelArr = labelArr2;
                            int i15 = JDKUtils.UNSAFE.getInt(bytes2, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(i15);
                            methodWriter.visitLdcInsn((int) bytes2[7]);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match8", "(IB)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 9:
                            labelArr = labelArr2;
                            int i16 = JDKUtils.UNSAFE.getInt(bytes2, JDKUtils.ARRAY_BYTE_BASE_OFFSET + 3);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(i16);
                            methodWriter.visitLdcInsn((int) bytes2[7]);
                            methodWriter.visitLdcInsn((int) bytes2[8]);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match9", "(IBB)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 10:
                            labelArr = labelArr2;
                            byte[] bArr3 = new byte[8];
                            System.arraycopy(bytes2, 3, bArr3, 0, 7);
                            bArr3[7] = 34;
                            long j2 = JDKUtils.UNSAFE.getLong(bArr3, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(j2);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match10", "(J)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        case 11:
                            byte[] bArr4 = new byte[8];
                            System.arraycopy(bytes2, 3, bArr4, 0, 8);
                            labelArr = labelArr2;
                            long j3 = JDKUtils.UNSAFE.getLong(bArr4, JDKUtils.ARRAY_BYTE_BASE_OFFSET);
                            methodWriter.aload(1);
                            methodWriter.visitLdcInsn(j3);
                            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfValue4Match11", "(J)Z");
                            methodWriter.ifeq(label4 != null ? label4 : label);
                            methodWriter.aload(0);
                            methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
                            methodWriter.checkcast(ASMUtils.type(cls3));
                            methodWriter.visitLdcInsn(r18.ordinal());
                            methodWriter.invokevirtual(ASMUtils.type(cls3), "getEnumByOrdinal", "(I)Ljava/lang/Enum;");
                            methodWriter.goto_(label2);
                            if (label4 != null) {
                                methodWriter.visitLabel(label4);
                            }
                            i11++;
                            z = z2;
                            treeMap = treeMap2;
                            cls2 = cls3;
                            iArr = iArr2;
                            size = i12;
                            labelArr2 = labelArr;
                            break;
                        default:
                            throw new IllegalStateException(concatVar2Var1(length2, "fieldNameLength "));
                    }
                }
                methodWriter.goto_(label);
                i10++;
                i4 = 0;
            }
        }
        boolean z3 = z;
        methodWriter.visitLabel(label);
        methodWriter.aload(0);
        methodWriter.getfield(str, str2, ASMUtils.DESC_OBJECT_READER);
        methodWriter.aload(1);
        gwGetFieldType(str, methodWriter, i, type);
        methodWriter.visitLdcInsn(fieldReader.fieldName);
        methodWriter.visitLdcInsn(j);
        methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER, z3 ? "readJSONBObject" : "readObject",
                METHOD_DESC_READ_OBJECT);
        methodWriter.visitLabel(label2);
    }

    /* JADX WARN: Found duplicated region for block: B:210:0x064d */
    /* JADX WARN: Found duplicated region for block: B:227:0x0688 */
    /* JADX WARN: Found duplicated region for block: B:229:0x068b */
    /* JADX WARN: Found duplicated region for block: B:230:0x0698 */
    /* JADX WARN: Found duplicated region for block: B:232:0x06a0 */
    /* JADX WARN: Found duplicated region for block: B:234:0x06ab */
    /* JADX WARN: Found duplicated region for block: B:236:0x06af */
    /* JADX WARN: Found duplicated region for block: B:237:0x06b9 */
    /* JADX WARN: Found duplicated region for block: B:239:0x06bd */
    /* JADX WARN: Found duplicated region for block: B:240:0x06c7 */
    /* JADX WARN: Found duplicated region for block: B:242:0x06cb */
    /* JADX WARN: Found duplicated region for block: B:243:0x06d5 */
    /* JADX WARN: Found duplicated region for block: B:245:0x06d9 */
    /* JADX WARN: Found duplicated region for block: B:246:0x06e1 */
    /* JADX WARN: Found duplicated region for block: B:248:0x06e5 */
    /* JADX WARN: Found duplicated region for block: B:249:0x06ed */
    /* JADX WARN: Found duplicated region for block: B:251:0x06f1 */
    /* JADX WARN: Found duplicated region for block: B:252:0x06f9 */
    /* JADX WARN: Found duplicated region for block: B:254:0x06fd */
    /* JADX WARN: Found duplicated region for block: B:255:0x0705 */
    /* JADX WARN: Found duplicated region for block: B:258:0x072f */
    /* JADX WARN: Found duplicated region for block: B:260:0x0747 */
    /* JADX WARN: Found duplicated region for block: B:262:0x074d */
    /* JADX WARN: Found duplicated region for block: B:264:0x075c */
    /* JADX WARN: Found duplicated region for block: B:272:0x076b */
    /* JADX WARN: Found duplicated region for block: B:274:0x0771 */
    /* JADX WARN: Found duplicated region for block: B:277:0x077a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:278:0x077c */
    /* JADX WARN: Found duplicated region for block: B:279:0x0782 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:280:0x0784 */
    /* JADX WARN: Found duplicated region for block: B:281:0x078a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:282:0x078c */
    /* JADX WARN: Found duplicated region for block: B:283:0x0792 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:284:0x0794 */
    /* JADX WARN: Found duplicated region for block: B:285:0x079c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:286:0x079e */
    /* JADX WARN: Found duplicated region for block: B:287:0x07a4 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:288:0x07a6 */
    /* JADX WARN: Found duplicated region for block: B:289:0x07ae A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:290:0x07b0 */
    /* JADX WARN: Found duplicated region for block: B:291:0x07b8 */
    /* JADX WARN: Found duplicated region for block: B:294:0x07d4 */
    /* JADX WARN: Found duplicated region for block: B:295:0x0813 */
    /* JADX WARN: Found duplicated region for block: B:296:0x0822 */
    /* JADX WARN: Found duplicated region for block: B:298:0x082e A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:299:0x0830 */
    /* JADX WARN: Found duplicated region for block: B:300:0x0834 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:301:0x0836 */
    /* JADX WARN: Found duplicated region for block: B:302:0x083a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:303:0x083c */
    /* JADX WARN: Found duplicated region for block: B:304:0x0840 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:305:0x0842 */
    /* JADX WARN: Found duplicated region for block: B:306:0x0846 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:307:0x0848 */
    /* JADX WARN: Found duplicated region for block: B:308:0x084c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:309:0x084e */
    /* JADX WARN: Found duplicated region for block: B:310:0x0851 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:311:0x0853 */
    /* JADX WARN: Found duplicated region for block: B:312:0x0856 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:313:0x0858 */
    /* JADX WARN: Found duplicated region for block: B:314:0x085b */
    /* JADX WARN: Found duplicated region for block: B:316:0x085f */
    /* JADX WARN: Found duplicated region for block: B:317:0x0862 */
    /* JADX WARN: Found duplicated region for block: B:319:0x0866 */
    /* JADX WARN: Found duplicated region for block: B:320:0x0869 */
    /* JADX WARN: Found duplicated region for block: B:322:0x086d */
    /* JADX WARN: Found duplicated region for block: B:323:0x0870 */
    /* JADX WARN: Found duplicated region for block: B:325:0x0874 */
    /* JADX WARN: Found duplicated region for block: B:326:0x0877 */
    /* JADX WARN: Found duplicated region for block: B:328:0x087b */
    /* JADX WARN: Found duplicated region for block: B:329:0x087e */
    /* JADX WARN: Found duplicated region for block: B:331:0x0882 */
    /* JADX WARN: Found duplicated region for block: B:332:0x0885 */
    /* JADX WARN: Found duplicated region for block: B:334:0x0889 */
    /* JADX WARN: Found duplicated region for block: B:335:0x088c */
    /* JADX WARN: Found duplicated region for block: B:337:0x0890 */
    /* JADX WARN: Found duplicated region for block: B:338:0x0893 */
    /* JADX WARN: Found duplicated region for block: B:340:0x0897 */
    /* JADX WARN: Found duplicated region for block: B:341:0x089a */
    /* JADX WARN: Found duplicated region for block: B:343:0x089e */
    /* JADX WARN: Found duplicated region for block: B:344:0x08a1 */
    /* JADX WARN: Found duplicated region for block: B:346:0x08a4 */
    /* JADX WARN: Found duplicated region for block: B:349:0x08be */
    private <T> void genReadFieldValue(ObjectReadContext objectReadContext, FieldReader fieldReader, boolean z,
            MethodWriterContext methodWriterContext, int i, int i2, boolean z2) {
        Class<?> cls;
        boolean z3;
        Class<?> cls2;
        Class<?> cls3;
        boolean z4;
        FieldReader fieldReader2;
        Class<?> cls4;
        Integer numValueOf;
        int i3;
        Class<?> cls5;
        Class<?> cls6;
        Label label;
        String str;
        ObjectReadContext objectReadContext2;
        Label label2;
        Label label3;
        Class<?> cls7;
        Class<?> cls8;
        Class<?> cls9;
        Class<?> cls10;
        Class<?> cls11;
        Field field;
        String str2;
        String str3;
        Class<?> cls12;
        Class<?> cls13;
        Class<?> cls14;
        Class<?> cls15;
        Class<?> cls16;
        Class<?> cls17;
        Class<?> cls18;
        Class<?> cls19;
        ObjectReadContext objectReadContext3;
        MethodWriter methodWriter;
        Class<?> cls20;
        ObjectReaderCreatorASM objectReaderCreatorASM;
        FieldReader fieldReader3;
        boolean z5;
        Label label4;
        MethodWriterContext methodWriterContext2;
        Class<?> mapping;
        Class<?> cls21;
        Field field2;
        String str4;
        Class<?> cls22;
        Class<?> cls23;
        Class<?> cls24;
        Class<?> cls25;
        Class<?> cls26;
        Class<?> cls27;
        Class<?> cls28;
        Class<?> cls29;
        Class<?> returnType;
        Class<?> cls30;
        String string;
        int iVar;
        String str5;
        int i4;
        BiConsumer function;
        int iVar2;
        String str6;
        String str7;
        int i5;
        String str8 = objectReadContext.classNameType;
        boolean z6 = methodWriterContext.jsonb;
        Class<?> cls31 = objectReadContext.objectClass;
        Class<?> cls32 = fieldReader.fieldClass;
        Type type = fieldReader.fieldType;
        long j = fieldReader.features;
        String str9 = fieldReader.format;
        Type type2 = fieldReader.itemType;
        MethodWriter methodWriter2 = methodWriterContext.mw;
        if ((j & JSONReader.Feature.NullOnError.mask) != 0) {
            methodWriter2.aload(0);
            methodWriter2.getfield(str8, CodeGenUtils.fieldReader(i2), ASMUtils.DESC_FIELD_READER);
            methodWriter2.aload(1);
            methodWriter2.aload(i);
            methodWriter2.invokevirtual(ASMUtils.TYPE_FIELD_READE, "readFieldValue", METHOD_DESC_READ_FIELD_VALUE);
            return;
        }
        Field field3 = fieldReader.field;
        Method method = fieldReader.method;
        Label label5 = new Label();
        String strType = ASMUtils.type(cls32);
        String strDesc = ASMUtils.desc(cls32);
        if (!(objectReadContext.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
            methodWriter2.aload(i);
        }
        int modifiers = ((z || method == null) && field3 != null) ? field3.getModifiers() : 0;
        if (z && Modifier.isPublic(cls31.getModifiers()) && Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers)
                && !this.classLoader.isExternalClass(cls31)) {
            methodWriter2.checkcast(objectReadContext.objectType);
        }
        Class<?> cls33 = Character.TYPE;
        Class<?> cls34 = Double.TYPE;
        Class<?> cls35 = Float.TYPE;
        Class<?> cls36 = Long.TYPE;
        Class<?> cls37 = cls31;
        Class<?> cls38 = Integer.TYPE;
        Class<?> cls39 = Short.TYPE;
        Class<?> cls40 = Byte.TYPE;
        Class<?> cls41 = Boolean.TYPE;
        if (cls32 == cls41) {
            methodWriter2.aload(1);
            methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readBoolValue", "()Z");
            fieldReader3 = fieldReader;
            cls17 = Integer.class;
            cls15 = cls35;
            cls14 = cls40;
            cls16 = cls36;
            cls18 = Long.class;
            cls19 = cls38;
            cls7 = Boolean.class;
            cls8 = cls34;
            cls9 = String.class;
            methodWriter = methodWriter2;
            cls10 = cls39;
            cls11 = cls33;
            field = field3;
            str2 = strDesc;
            label3 = label5;
            str3 = str8;
            cls12 = cls37;
            cls13 = cls41;
            z5 = true;
        } else {
            if (cls32 == cls40) {
                cls = cls40;
                z3 = true;
                methodWriter2.aload(1);
                methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt32Value", "()I");
            } else {
                cls = cls40;
                z3 = true;
                if (cls32 == cls39 || cls32 == cls38) {
                    methodWriter2.aload(1);
                    methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt32Value", "()I");
                } else if (cls32 == cls36) {
                    methodWriter2.aload(1);
                    methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt64Value", "()J");
                } else if (cls32 == cls35) {
                    methodWriter2.aload(1);
                    methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readFloatValue", "()F");
                } else {
                    if (cls32 != cls34) {
                        if (cls32 == cls33) {
                            methodWriter2.aload(1);
                            methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readCharValue", "()C");
                        } else {
                            if (cls32 == String.class) {
                                methodWriter2.aload(1);
                                Label label6 = new Label();
                                cls2 = cls35;
                                cls3 = cls36;
                                methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readString",
                                        "()Ljava/lang/String;");
                                methodWriter2.dup();
                                methodWriter2.ifnull(label6);
                                if ("trim".equals(str9)) {
                                    methodWriter2.invokevirtual("java/lang/String", "trim", "()Ljava/lang/String;");
                                } else if ("upper".equals(str9)) {
                                    methodWriter2.invokevirtual("java/lang/String", "toUpperCase",
                                            "()Ljava/lang/String;");
                                }
                                methodWriter2.visitLabel(label6);
                                fieldReader3 = fieldReader;
                                methodWriterContext2 = methodWriterContext;
                                cls17 = Integer.class;
                            } else {
                                cls2 = cls35;
                                cls3 = cls36;
                                if (cls32 == Boolean.class) {
                                    z4 = true;
                                    methodWriter2.aload(1);
                                    methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readBool",
                                            "()Ljava/lang/Boolean;");
                                } else {
                                    z4 = true;
                                    if (cls32 == Byte.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt8",
                                                "()Ljava/lang/Byte;");
                                    } else if (cls32 == Short.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt16",
                                                "()Ljava/lang/Short;");
                                    } else if (cls32 == Integer.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt32",
                                                "()Ljava/lang/Integer;");
                                    } else if (cls32 == Long.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt64",
                                                "()Ljava/lang/Long;");
                                    } else if (cls32 == Float.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readFloat",
                                                "()Ljava/lang/Float;");
                                    } else if (cls32 == Double.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readDouble",
                                                "()Ljava/lang/Double;");
                                    } else if (cls32 == BigDecimal.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readBigDecimal",
                                                "()Ljava/math/BigDecimal;");
                                    } else if (cls32 == BigInteger.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readBigInteger",
                                                "()Ljava/math/BigInteger;");
                                    } else if (cls32 == Number.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readNumber",
                                                "()Ljava/lang/Number;");
                                    } else if (cls32 == UUID.class) {
                                        methodWriter2.aload(1);
                                        methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readUUID",
                                                "()Ljava/util/UUID;");
                                    } else {
                                        if (cls32 == LocalDate.class) {
                                            fieldReader2 = fieldReader;
                                            if (fieldReader2.format == null) {
                                                methodWriter2.aload(1);
                                                methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readLocalDate",
                                                        "()Ljava/time/LocalDate;");
                                            }
                                            methodWriterContext2 = methodWriterContext;
                                            cls17 = Integer.class;
                                            fieldReader3 = fieldReader2;
                                        } else {
                                            fieldReader2 = fieldReader;
                                        }
                                        if (cls32 == OffsetDateTime.class && fieldReader2.format == null) {
                                            methodWriter2.aload(1);
                                            methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readOffsetDateTime",
                                                    "()Ljava/time/OffsetDateTime;");
                                        } else if (cls32 == Date.class && fieldReader2.format == null) {
                                            methodWriter2.aload(1);
                                            methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readDate",
                                                    "()Ljava/util/Date;");
                                        } else if (cls32 == Calendar.class && fieldReader2.format == null) {
                                            methodWriter2.aload(1);
                                            methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readCalendar",
                                                    "()Ljava/util/Calendar;");
                                        } else {
                                            Label label7 = new Label();
                                            boolean zDisableReferenceDetect = objectReadContext
                                                    .disableReferenceDetect();
                                            if (zDisableReferenceDetect) {
                                                cls4 = Integer.class;
                                                numValueOf = null;
                                            } else {
                                                cls4 = Integer.class;
                                                numValueOf = Integer.valueOf(methodWriterContext.var("REFERENCE"));
                                            }
                                            if (zDisableReferenceDetect
                                                    || ObjectWriterProvider.isPrimitiveOrEnum(cls32)) {
                                                i3 = i;
                                                cls5 = Long.class;
                                                cls6 = cls38;
                                                label = label5;
                                                str = "()Z";
                                                objectReadContext2 = objectReadContext;
                                            } else {
                                                Label label8 = new Label();
                                                Label label9 = new Label();
                                                cls5 = Long.class;
                                                methodWriter2.aload(1);
                                                String str10 = ASMUtils.TYPE_JSON_READER;
                                                Integer num = numValueOf;
                                                cls6 = cls38;
                                                str = "()Z";
                                                methodWriter2.invokevirtual(str10, "isReference", str);
                                                methodWriter2.ifeq(label8);
                                                methodWriter2.aload(1);
                                                methodWriter2.invokevirtual(str10, "readReference",
                                                        "()Ljava/lang/String;");
                                                objectReadContext2 = objectReadContext;
                                                Class<?> cls42 = objectReadContext2.objectClass;
                                                if (cls42 == null || cls32.isAssignableFrom(cls42)) {
                                                    methodWriter2.dup();
                                                    methodWriter2.astore(num.intValue());
                                                    methodWriter2.visitLdcInsn("..");
                                                    methodWriter2.invokevirtual("java/lang/String", "equals",
                                                            "(Ljava/lang/Object;)Z");
                                                    methodWriter2.ifeq(label9);
                                                    if (cls37 != null) {
                                                        cls21 = cls37;
                                                        if (cls32.isAssignableFrom(cls21)) {
                                                            i3 = i;
                                                            methodWriter2.aload(i3);
                                                            methodWriter2.goto_(label7);
                                                        } else {
                                                            i3 = i;
                                                        }
                                                    } else {
                                                        i3 = i;
                                                        cls21 = cls37;
                                                    }
                                                    methodWriter2.visitLabel(label9);
                                                } else {
                                                    methodWriter2.astore(num.intValue());
                                                    i3 = i;
                                                    cls21 = cls37;
                                                }
                                                methodWriter2.aload(0);
                                                cls37 = cls21;
                                                methodWriter2.getfield(str8, CodeGenUtils.fieldReader(i2),
                                                        ASMUtils.DESC_FIELD_READER);
                                                methodWriter2.aload(1);
                                                methodWriter2.aload(i3);
                                                methodWriter2.aload(num.intValue());
                                                methodWriter2.invokevirtual(ASMUtils.TYPE_FIELD_READE, "addResolveTask",
                                                        METHOD_DESC_ADD_RESOLVE_TASK);
                                                methodWriter2.pop();
                                                label = label5;
                                                methodWriter2.goto_(label);
                                                methodWriter2.visitLabel(label8);
                                            }
                                            if (fieldReader2.fieldClassSerializable) {
                                                label2 = label7;
                                            } else {
                                                Label label10 = new Label();
                                                methodWriter2.lload(4);
                                                label2 = label7;
                                                methodWriter2
                                                        .visitLdcInsn(JSONReader.Feature.IgnoreNoneSerializable.mask);
                                                methodWriter2.land();
                                                methodWriter2.lconst_0();
                                                methodWriter2.lcmp();
                                                methodWriter2.ifeq(label10);
                                                methodWriter2.aload(1);
                                                methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue",
                                                        "()V");
                                                if (!(objectReadContext2.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor)) {
                                                    methodWriter2.pop();
                                                }
                                                methodWriter2.goto_(label);
                                                methodWriter2.visitLabel(label10);
                                            }
                                            boolean z7 = List.class.isAssignableFrom(cls32)
                                                    && fieldReader.getInitReader() == null && !cls32.getName()
                                                            .startsWith("com.google.common.collect.Immutable");
                                            if (z7 && (mapping = TypeUtils.getMapping(type2)) != null
                                                    && (Collection.class.isAssignableFrom(mapping)
                                                            || !Modifier.isPublic(mapping.getModifiers()))) {
                                                z7 = false;
                                            }
                                            if (z7 && !cls32.isInterface()
                                                    && !BeanUtils.hasPublicDefaultConstructor(cls32)) {
                                                z7 = false;
                                            }
                                            if (z7) {
                                                fieldReader3 = fieldReader;
                                                methodWriterContext2 = methodWriterContext;
                                                label3 = label;
                                                cls7 = Boolean.class;
                                                cls8 = cls34;
                                                cls9 = String.class;
                                                Label label11 = label2;
                                                cls10 = cls39;
                                                cls11 = cls33;
                                                field = field3;
                                                str2 = strDesc;
                                                str3 = str8;
                                                Class<?> cls43 = cls37;
                                                cls13 = cls41;
                                                cls14 = cls;
                                                cls15 = cls2;
                                                cls16 = cls3;
                                                cls17 = cls4;
                                                cls18 = cls5;
                                                cls19 = cls6;
                                                objectReaderCreatorASM = this;
                                                objectReadContext3 = objectReadContext2;
                                                objectReaderCreatorASM.genReadFieldValueList(fieldReader3, str3,
                                                        methodWriterContext2, i3, i2, z2, cls43, cls32, type, j, type2,
                                                        strType, objectReadContext3, z);
                                                cls12 = cls43;
                                                cls20 = cls32;
                                                methodWriter = methodWriter2;
                                                label4 = label11;
                                                z5 = true;
                                            } else {
                                                label3 = label;
                                                cls7 = Boolean.class;
                                                cls8 = cls34;
                                                cls9 = String.class;
                                                Label label12 = label2;
                                                cls10 = cls39;
                                                cls11 = cls33;
                                                field = field3;
                                                str2 = strDesc;
                                                cls12 = cls37;
                                                cls13 = cls41;
                                                cls14 = cls;
                                                cls15 = cls2;
                                                cls16 = cls3;
                                                cls17 = cls4;
                                                cls18 = cls5;
                                                cls19 = cls6;
                                                objectReadContext3 = objectReadContext2;
                                                int i6 = i3;
                                                String strFieldObjectReader = fieldObjectReader(i2);
                                                Label label13 = new Label();
                                                methodWriter = methodWriter2;
                                                methodWriter.aload(1);
                                                String str11 = ASMUtils.TYPE_JSON_READER;
                                                methodWriter.invokevirtual(str11, "nextIfNull", str);
                                                methodWriter.ifeq(label13);
                                                if (cls32 == Optional.class) {
                                                    str3 = str8;
                                                    methodWriter.invokestatic("java/util/Optional", "empty",
                                                            "()Ljava/util/Optional;");
                                                } else if (cls32 == OptionalInt.class) {
                                                    str3 = str8;
                                                    methodWriter.invokestatic("java/util/OptionalInt", "empty",
                                                            "()Ljava/util/OptionalInt;");
                                                } else if (cls32 == OptionalLong.class) {
                                                    str3 = str8;
                                                    methodWriter.invokestatic("java/util/OptionalLong", "empty",
                                                            "()Ljava/util/OptionalLong;");
                                                } else if (cls32 == OptionalDouble.class) {
                                                    str3 = str8;
                                                    methodWriter.invokestatic("java/util/OptionalDouble", "empty",
                                                            "()Ljava/util/OptionalDouble;");
                                                } else {
                                                    str3 = str8;
                                                    methodWriter.aconst_null();
                                                }
                                                methodWriter.goto_(label12);
                                                methodWriter.visitLabel(label13);
                                                if (cls32 == String[].class) {
                                                    methodWriter.aload(1);
                                                    methodWriter.invokevirtual(str11, "readStringArray",
                                                            "()[Ljava/lang/String;");
                                                } else if (cls32 == int[].class) {
                                                    methodWriter.aload(1);
                                                    methodWriter.invokevirtual(str11, "readInt32ValueArray", "()[I");
                                                } else if (cls32 == long[].class) {
                                                    methodWriter.aload(1);
                                                    methodWriter.invokevirtual(str11, "readInt64ValueArray", "()[J");
                                                } else {
                                                    if (Enum.class.isAssignableFrom(cls32) && (!z6)) {
                                                        objectReaderCreatorASM = this;
                                                        fieldReader3 = fieldReader;
                                                        z5 = true;
                                                        label4 = label12;
                                                        methodWriterContext2 = methodWriterContext;
                                                        objectReaderCreatorASM.genReadEnumValueRaw(fieldReader3, str3,
                                                                methodWriterContext2, i2, type, cls32, j,
                                                                strFieldObjectReader);
                                                        cls20 = cls32;
                                                    } else {
                                                        cls20 = cls32;
                                                        objectReaderCreatorASM = this;
                                                        fieldReader3 = fieldReader;
                                                        z5 = true;
                                                        label4 = label12;
                                                        methodWriterContext2 = methodWriterContext;
                                                        objectReaderCreatorASM.genReadObject(fieldReader3, str3,
                                                                methodWriterContext2, i2, type, j,
                                                                strFieldObjectReader);
                                                    }
                                                    if (method != null || ((cls12 == null
                                                            || Modifier.isPublic(cls12.getModifiers()))
                                                            && Modifier.isPublic(modifiers)
                                                            && !Modifier.isFinal(modifiers)
                                                            && !objectReaderCreatorASM.classLoader
                                                                    .isExternalClass(cls12))) {
                                                        methodWriter.checkcast(strType);
                                                    }
                                                    if (fieldReader3.noneStaticMemberClass) {
                                                        try {
                                                            long jObjectFieldOffset = JDKUtils.UNSAFE.objectFieldOffset(
                                                                    cls20.getDeclaredField("this$0"));
                                                            Label label14 = new Label();
                                                            methodWriter.dup();
                                                            methodWriter.ifnull(label14);
                                                            methodWriter.dup();
                                                            methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE",
                                                                    "Lsun/misc/Unsafe;");
                                                            methodWriter.swap();
                                                            methodWriter.visitLdcInsn(jObjectFieldOffset);
                                                            methodWriter.aload(i6);
                                                            methodWriter.invokevirtual("sun/misc/Unsafe", "putObject",
                                                                    "(Ljava/lang/Object;JLjava/lang/Object;)V");
                                                            methodWriter.visitLabel(label14);
                                                        } catch (NoSuchFieldException unused) {
                                                        }
                                                    }
                                                }
                                                objectReaderCreatorASM = this;
                                                fieldReader3 = fieldReader;
                                                cls20 = cls32;
                                                z5 = true;
                                                label4 = label12;
                                                methodWriterContext2 = methodWriterContext;
                                            }
                                            methodWriter.visitLabel(label4);
                                        }
                                        methodWriterContext2 = methodWriterContext;
                                        cls17 = Integer.class;
                                        fieldReader3 = fieldReader2;
                                    }
                                }
                                fieldReader3 = fieldReader;
                                cls17 = Integer.class;
                                z5 = z4;
                                cls18 = Long.class;
                                cls19 = cls38;
                                cls7 = Boolean.class;
                                cls8 = cls34;
                                cls9 = String.class;
                                methodWriter = methodWriter2;
                                cls10 = cls39;
                                cls11 = cls33;
                                field = field3;
                                str2 = strDesc;
                                label3 = label5;
                                str3 = str8;
                                cls12 = cls37;
                                cls13 = cls41;
                                cls14 = cls;
                                cls15 = cls2;
                                cls16 = cls3;
                            }
                            cls18 = Long.class;
                            cls19 = cls38;
                            cls7 = Boolean.class;
                            cls8 = cls34;
                            cls9 = String.class;
                            methodWriter = methodWriter2;
                            cls10 = cls39;
                            cls11 = cls33;
                            field = field3;
                            str2 = strDesc;
                            label3 = label5;
                            str3 = str8;
                            cls12 = cls37;
                            cls13 = cls41;
                            cls14 = cls;
                            cls15 = cls2;
                            cls16 = cls3;
                            z5 = true;
                            objectReaderCreatorASM = this;
                            objectReadContext3 = objectReadContext;
                            cls20 = cls32;
                        }
                        field2 = field;
                        if (field2 != null) {
                            if (((cls12.getModifiers() & 1) == 0 && (modifiers & 1) != 0 && (modifiers & 16) == 0
                                    && (ObjectWriterProvider.isPrimitiveOrEnum(cls20)
                                            || cls20.getName().startsWith("java.")
                                            || cls20.getClassLoader() == ObjectReaderProvider.FASTJSON2_CLASS_LOADER)
                                    && !objectReaderCreatorASM.classLoader.isExternalClass(cls12)
                                    && field2.getDeclaringClass() == cls12) ? z5 : false) {
                                methodWriter.putfield(objectReadContext3.objectType, field2.getName(), str2);
                            } else {
                                iVar2 = methodWriterContext2.var(cls20);
                                if (cls20 == cls19) {
                                    methodWriter.istore(iVar2);
                                    str6 = "putInt";
                                    str7 = "(Ljava/lang/Object;JI)V";
                                } else {
                                    if (cls20 == cls16) {
                                        methodWriter.lstore(iVar2);
                                        str6 = "putLong";
                                        str7 = "(Ljava/lang/Object;JJ)V";
                                        i5 = 22;
                                    } else if (cls20 == cls15) {
                                        methodWriter.fstore(iVar2);
                                        str6 = "putFloat";
                                        str7 = "(Ljava/lang/Object;JF)V";
                                        i5 = 23;
                                    } else if (cls20 == cls8) {
                                        methodWriter.dstore(iVar2);
                                        str6 = "putDouble";
                                        str7 = "(Ljava/lang/Object;JD)V";
                                        i5 = 24;
                                    } else if (cls20 == cls11) {
                                        methodWriter.istore(iVar2);
                                        str6 = "putChar";
                                        str7 = "(Ljava/lang/Object;JC)V";
                                    } else if (cls20 == cls14) {
                                        methodWriter.istore(iVar2);
                                        str6 = "putByte";
                                        str7 = "(Ljava/lang/Object;JB)V";
                                    } else if (cls20 == cls10) {
                                        methodWriter.istore(iVar2);
                                        str6 = "putShort";
                                        str7 = "(Ljava/lang/Object;JS)V";
                                    } else if (cls20 == cls13) {
                                        methodWriter.istore(iVar2);
                                        str6 = "putBoolean";
                                        str7 = "(Ljava/lang/Object;JZ)V";
                                    } else {
                                        methodWriter.astore(iVar2);
                                        str6 = "putObject";
                                        str7 = "(Ljava/lang/Object;JLjava/lang/Object;)V";
                                        i5 = 25;
                                    }
                                    methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
                                    methodWriter.swap();
                                    methodWriter.visitLdcInsn(JDKUtils.UNSAFE.objectFieldOffset(field2));
                                    methodWriter.visitVarInsn(i5, iVar2);
                                    methodWriter.invokevirtual("sun/misc/Unsafe", str6, str7);
                                }
                                i5 = 21;
                                methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
                                methodWriter.swap();
                                methodWriter.visitLdcInsn(JDKUtils.UNSAFE.objectFieldOffset(field2));
                                methodWriter.visitVarInsn(i5, iVar2);
                                methodWriter.invokevirtual("sun/misc/Unsafe", str6, str7);
                            }
                        } else {
                            str4 = str2;
                            cls22 = cls11;
                            cls23 = cls8;
                            cls24 = cls15;
                            cls25 = cls16;
                            cls26 = cls19;
                            cls27 = cls10;
                            cls28 = cls14;
                            cls29 = cls13;
                            if (objectReadContext3.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                                if (!cls20.isPrimitive()) {
                                    methodWriter.checkcast(ASMUtils.type(cls20));
                                }
                                methodWriter.storeLocal(cls20, methodWriterContext2.var(fieldReader3));
                            } else {
                                if (!objectReadContext3.externalClass && method != null
                                        && objectReadContext3.publicClass) {
                                    z5 = false;
                                }
                                if (z5) {
                                    iVar = methodWriterContext2.var(cls20);
                                    if (cls20 == cls29) {
                                        methodWriter.istore(iVar);
                                        str5 = "(Ljava/lang/Object;Z)V";
                                    } else if (cls20 == cls28) {
                                        methodWriter.istore(iVar);
                                        str5 = "(Ljava/lang/Object;B)V";
                                    } else if (cls20 == cls27) {
                                        methodWriter.istore(iVar);
                                        str5 = "(Ljava/lang/Object;S)V";
                                    } else if (cls20 == cls26) {
                                        methodWriter.istore(iVar);
                                        str5 = "(Ljava/lang/Object;I)V";
                                    } else {
                                        if (cls20 == cls25) {
                                            methodWriter.lstore(iVar);
                                            str5 = "(Ljava/lang/Object;J)V";
                                            i4 = 22;
                                        } else if (cls20 == cls22) {
                                            methodWriter.istore(iVar);
                                            str5 = "(Ljava/lang/Object;C)V";
                                        } else if (cls20 == cls24) {
                                            methodWriter.fstore(iVar);
                                            str5 = "(Ljava/lang/Object;F)V";
                                            i4 = 23;
                                        } else if (cls20 == cls23) {
                                            methodWriter.dstore(iVar);
                                            str5 = "(Ljava/lang/Object;D)V";
                                            i4 = 24;
                                        } else {
                                            methodWriter.astore(iVar);
                                            str5 = "(Ljava/lang/Object;Ljava/lang/Object;)V";
                                            i4 = 25;
                                        }
                                        methodWriter.aload(0);
                                        methodWriter.getfield(str3, CodeGenUtils.fieldReader(i2),
                                                ASMUtils.DESC_FIELD_READER);
                                        function = fieldReader3.getFunction();
                                        if (function instanceof FieldBiConsumer) {
                                            methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getFunction",
                                                    "()Ljava/util/function/BiConsumer;");
                                            methodWriter.checkcast(ASMUtils.type(FieldBiConsumer.class));
                                            methodWriter.getfield(ASMUtils.type(FieldBiConsumer.class), "consumer",
                                                    ASMUtils.desc(FieldConsumer.class));
                                            methodWriter.swap();
                                            methodWriter.visitLdcInsn(((FieldBiConsumer) function).fieldIndex);
                                            methodWriter.visitVarInsn(i4, iVar);
                                            methodWriter.invokeinterface(ASMUtils.type(FieldConsumer.class), "accept",
                                                    "(Ljava/lang/Object;ILjava/lang/Object;)V");
                                        } else {
                                            methodWriter.swap();
                                            methodWriter.visitVarInsn(i4, iVar);
                                            methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "accept", str5);
                                        }
                                    }
                                    i4 = 21;
                                    methodWriter.aload(0);
                                    methodWriter.getfield(str3, CodeGenUtils.fieldReader(i2),
                                            ASMUtils.DESC_FIELD_READER);
                                    function = fieldReader3.getFunction();
                                    if (function instanceof FieldBiConsumer) {
                                        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getFunction",
                                                "()Ljava/util/function/BiConsumer;");
                                        methodWriter.checkcast(ASMUtils.type(FieldBiConsumer.class));
                                        methodWriter.getfield(ASMUtils.type(FieldBiConsumer.class), "consumer",
                                                ASMUtils.desc(FieldConsumer.class));
                                        methodWriter.swap();
                                        methodWriter.visitLdcInsn(((FieldBiConsumer) function).fieldIndex);
                                        methodWriter.visitVarInsn(i4, iVar);
                                        methodWriter.invokeinterface(ASMUtils.type(FieldConsumer.class), "accept",
                                                "(Ljava/lang/Object;ILjava/lang/Object;)V");
                                    } else {
                                        methodWriter.swap();
                                        methodWriter.visitVarInsn(i4, iVar);
                                        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "accept", str5);
                                    }
                                } else {
                                    returnType = method.getReturnType();
                                    String name = method.getName();
                                    cls30 = Void.TYPE;
                                    if (returnType != cls30) {
                                        string = cls20 == cls29 ? "(Z)V"
                                                : cls20 == cls28 ? "(B)V"
                                                        : cls20 == cls27 ? "(S)V"
                                                                : cls20 == cls26 ? "(I)V"
                                                                        : cls20 == cls25 ? "(J)V"
                                                                                : cls20 == cls22 ? "(C)V"
                                                                                        : cls20 == cls24 ? "(F)V"
                                                                                                : cls20 == cls23
                                                                                                        ? "(D)V"
                                                                                                        : cls20 == cls7
                                                                                                                ? "(Ljava/lang/Boolean;)V"
                                                                                                                : cls20 == cls17
                                                                                                                        ? "(Ljava/lang/Integer;)V"
                                                                                                                        : cls20 == cls18
                                                                                                                                ? "(Ljava/lang/Long;)V"
                                                                                                                                : cls20 == Float.class
                                                                                                                                        ? "(Ljava/lang/Float;)V"
                                                                                                                                        : cls20 == Double.class
                                                                                                                                                ? "(Ljava/lang/Double;)V"
                                                                                                                                                : cls20 == BigDecimal.class
                                                                                                                                                        ? "(Ljava/math/BigDecimal;)V"
                                                                                                                                                        : cls20 == cls9
                                                                                                                                                                ? "(Ljava/lang/String;)V"
                                                                                                                                                                : cls20 == UUID.class
                                                                                                                                                                        ? "(Ljava/util/UUID;)V"
                                                                                                                                                                        : cls20 == List.class
                                                                                                                                                                                ? "(Ljava/util/List;)V"
                                                                                                                                                                                : cls20 == Map.class
                                                                                                                                                                                        ? "(Ljava/util/Map;)V"
                                                                                                                                                                                        : null;
                                    }
                                    if (string == null) {
                                        StringBuilder sbZ = dkz.z("(", str4, ")");
                                        sbZ.append(ASMUtils.desc(returnType));
                                        string = sbZ.toString();
                                    }
                                    methodWriter.invokevirtual(objectReadContext3.objectType, name, string);
                                    if (returnType != cls30) {
                                        methodWriter.pop();
                                    }
                                }
                            }
                        }
                        methodWriter.visitLabel(label3);
                    }
                    methodWriter2.aload(1);
                    methodWriter2.invokevirtual(ASMUtils.TYPE_JSON_READER, "readDoubleValue", "()D");
                }
            }
            fieldReader3 = fieldReader;
            cls17 = Integer.class;
            cls15 = cls35;
            z5 = z3;
            cls16 = cls36;
            cls18 = Long.class;
            cls19 = cls38;
            cls7 = Boolean.class;
            cls8 = cls34;
            cls9 = String.class;
            methodWriter = methodWriter2;
            cls10 = cls39;
            cls11 = cls33;
            field = field3;
            str2 = strDesc;
            label3 = label5;
            str3 = str8;
            cls12 = cls37;
            cls13 = cls41;
            cls14 = cls;
        }
        objectReaderCreatorASM = this;
        objectReadContext3 = objectReadContext;
        methodWriterContext2 = methodWriterContext;
        cls20 = cls32;
        field2 = field;
        if (field2 != null) {
            if (((cls12.getModifiers() & 1) == 0 && (modifiers & 1) != 0 && (modifiers & 16) == 0
                    && (ObjectWriterProvider.isPrimitiveOrEnum(cls20) || cls20.getName().startsWith("java.")
                            || cls20.getClassLoader() == ObjectReaderProvider.FASTJSON2_CLASS_LOADER)
                    && !objectReaderCreatorASM.classLoader.isExternalClass(cls12)
                    && field2.getDeclaringClass() == cls12) ? z5 : false) {
                methodWriter.putfield(objectReadContext3.objectType, field2.getName(), str2);
            } else {
                iVar2 = methodWriterContext2.var(cls20);
                if (cls20 == cls19) {
                    methodWriter.istore(iVar2);
                    str6 = "putInt";
                    str7 = "(Ljava/lang/Object;JI)V";
                } else {
                    if (cls20 == cls16) {
                        methodWriter.lstore(iVar2);
                        str6 = "putLong";
                        str7 = "(Ljava/lang/Object;JJ)V";
                        i5 = 22;
                    } else if (cls20 == cls15) {
                        methodWriter.fstore(iVar2);
                        str6 = "putFloat";
                        str7 = "(Ljava/lang/Object;JF)V";
                        i5 = 23;
                    } else if (cls20 == cls8) {
                        methodWriter.dstore(iVar2);
                        str6 = "putDouble";
                        str7 = "(Ljava/lang/Object;JD)V";
                        i5 = 24;
                    } else if (cls20 == cls11) {
                        methodWriter.istore(iVar2);
                        str6 = "putChar";
                        str7 = "(Ljava/lang/Object;JC)V";
                    } else if (cls20 == cls14) {
                        methodWriter.istore(iVar2);
                        str6 = "putByte";
                        str7 = "(Ljava/lang/Object;JB)V";
                    } else if (cls20 == cls10) {
                        methodWriter.istore(iVar2);
                        str6 = "putShort";
                        str7 = "(Ljava/lang/Object;JS)V";
                    } else if (cls20 == cls13) {
                        methodWriter.istore(iVar2);
                        str6 = "putBoolean";
                        str7 = "(Ljava/lang/Object;JZ)V";
                    } else {
                        methodWriter.astore(iVar2);
                        str6 = "putObject";
                        str7 = "(Ljava/lang/Object;JLjava/lang/Object;)V";
                        i5 = 25;
                    }
                    methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
                    methodWriter.swap();
                    methodWriter.visitLdcInsn(JDKUtils.UNSAFE.objectFieldOffset(field2));
                    methodWriter.visitVarInsn(i5, iVar2);
                    methodWriter.invokevirtual("sun/misc/Unsafe", str6, str7);
                }
                i5 = 21;
                methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
                methodWriter.swap();
                methodWriter.visitLdcInsn(JDKUtils.UNSAFE.objectFieldOffset(field2));
                methodWriter.visitVarInsn(i5, iVar2);
                methodWriter.invokevirtual("sun/misc/Unsafe", str6, str7);
            }
        } else {
            str4 = str2;
            cls22 = cls11;
            cls23 = cls8;
            cls24 = cls15;
            cls25 = cls16;
            cls26 = cls19;
            cls27 = cls10;
            cls28 = cls14;
            cls29 = cls13;
            if (objectReadContext3.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
                if (!cls20.isPrimitive()) {
                    methodWriter.checkcast(ASMUtils.type(cls20));
                }
                methodWriter.storeLocal(cls20, methodWriterContext2.var(fieldReader3));
            } else {
                if (!objectReadContext3.externalClass) {
                    z5 = false;
                }
                if (z5) {
                    iVar = methodWriterContext2.var(cls20);
                    if (cls20 == cls29) {
                        methodWriter.istore(iVar);
                        str5 = "(Ljava/lang/Object;Z)V";
                    } else if (cls20 == cls28) {
                        methodWriter.istore(iVar);
                        str5 = "(Ljava/lang/Object;B)V";
                    } else if (cls20 == cls27) {
                        methodWriter.istore(iVar);
                        str5 = "(Ljava/lang/Object;S)V";
                    } else if (cls20 == cls26) {
                        methodWriter.istore(iVar);
                        str5 = "(Ljava/lang/Object;I)V";
                    } else {
                        if (cls20 == cls25) {
                            methodWriter.lstore(iVar);
                            str5 = "(Ljava/lang/Object;J)V";
                            i4 = 22;
                        } else if (cls20 == cls22) {
                            methodWriter.istore(iVar);
                            str5 = "(Ljava/lang/Object;C)V";
                        } else if (cls20 == cls24) {
                            methodWriter.fstore(iVar);
                            str5 = "(Ljava/lang/Object;F)V";
                            i4 = 23;
                        } else if (cls20 == cls23) {
                            methodWriter.dstore(iVar);
                            str5 = "(Ljava/lang/Object;D)V";
                            i4 = 24;
                        } else {
                            methodWriter.astore(iVar);
                            str5 = "(Ljava/lang/Object;Ljava/lang/Object;)V";
                            i4 = 25;
                        }
                        methodWriter.aload(0);
                        methodWriter.getfield(str3, CodeGenUtils.fieldReader(i2), ASMUtils.DESC_FIELD_READER);
                        function = fieldReader3.getFunction();
                        if (function instanceof FieldBiConsumer) {
                            methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getFunction",
                                    "()Ljava/util/function/BiConsumer;");
                            methodWriter.checkcast(ASMUtils.type(FieldBiConsumer.class));
                            methodWriter.getfield(ASMUtils.type(FieldBiConsumer.class), "consumer",
                                    ASMUtils.desc(FieldConsumer.class));
                            methodWriter.swap();
                            methodWriter.visitLdcInsn(((FieldBiConsumer) function).fieldIndex);
                            methodWriter.visitVarInsn(i4, iVar);
                            methodWriter.invokeinterface(ASMUtils.type(FieldConsumer.class), "accept",
                                    "(Ljava/lang/Object;ILjava/lang/Object;)V");
                        } else {
                            methodWriter.swap();
                            methodWriter.visitVarInsn(i4, iVar);
                            methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "accept", str5);
                        }
                    }
                    i4 = 21;
                    methodWriter.aload(0);
                    methodWriter.getfield(str3, CodeGenUtils.fieldReader(i2), ASMUtils.DESC_FIELD_READER);
                    function = fieldReader3.getFunction();
                    if (function instanceof FieldBiConsumer) {
                        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getFunction",
                                "()Ljava/util/function/BiConsumer;");
                        methodWriter.checkcast(ASMUtils.type(FieldBiConsumer.class));
                        methodWriter.getfield(ASMUtils.type(FieldBiConsumer.class), "consumer",
                                ASMUtils.desc(FieldConsumer.class));
                        methodWriter.swap();
                        methodWriter.visitLdcInsn(((FieldBiConsumer) function).fieldIndex);
                        methodWriter.visitVarInsn(i4, iVar);
                        methodWriter.invokeinterface(ASMUtils.type(FieldConsumer.class), "accept",
                                "(Ljava/lang/Object;ILjava/lang/Object;)V");
                    } else {
                        methodWriter.swap();
                        methodWriter.visitVarInsn(i4, iVar);
                        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "accept", str5);
                    }
                } else {
                    returnType = method.getReturnType();
                    String name2 = method.getName();
                    cls30 = Void.TYPE;
                    if (returnType != cls30) {
                        if (cls20 == cls29) {
                        }
                    }
                    if (string == null) {
                        StringBuilder sbZ2 = dkz.z("(", str4, ")");
                        sbZ2.append(ASMUtils.desc(returnType));
                        string = sbZ2.toString();
                    }
                    methodWriter.invokevirtual(objectReadContext3.objectType, name2, string);
                    if (returnType != cls30) {
                        methodWriter.pop();
                    }
                }
            }
        }
        methodWriter.visitLabel(label3);
    }

    private void genReadFieldValueList(FieldReader fieldReader, String str, MethodWriterContext methodWriterContext,
            int i, int i2, boolean z, Class cls, Class cls2, Type type, long j, Type type2, String str2,
            ObjectReadContext objectReadContext, boolean z2) {
        Class cls3;
        int iVar;
        String str3;
        String str4;
        int i3;
        String str5;
        Type type3;
        String str6;
        int i4;
        ObjectReaderCreatorASM objectReaderCreatorASM;
        FieldReader fieldReader2;
        int i5;
        Type type4;
        Label label;
        Label label2;
        int i6;
        String str7;
        String str8;
        String str9;
        String str10;
        Label label3;
        Field field;
        boolean z3 = methodWriterContext.jsonb;
        Type type5 = type2 == null ? Object.class : type2;
        Class<?> mapping = TypeUtils.getMapping(type5);
        String strFieldItemObjectReader = fieldItemObjectReader(i2);
        MethodWriter methodWriter = methodWriterContext.mw;
        if (objectReadContext.objectReaderAdapter instanceof ObjectReaderNoneDefaultConstructor) {
            iVar = methodWriterContext.var(fieldReader);
            cls3 = cls2;
        } else {
            cls3 = cls2;
            iVar = methodWriterContext.var(cls3);
        }
        int iVar2 = methodWriterContext.var(ObjectReader.class);
        String str11 = cls3.isInterface() ? "java/util/ArrayList" : str2;
        Label label4 = new Label();
        Label label5 = new Label();
        Type type6 = type5;
        Label label6 = new Label();
        boolean z4 = JDKUtils.JVM_VERSION == 8 && "java/util/ArrayList".equals(str11);
        int iVar3 = methodWriterContext.var("ITEM_CNT");
        boolean z5 = z4;
        String str12 = "java/util/List";
        String str13 = "(Ljava/lang/Object;)Z";
        String str14 = "add";
        Class<?> cls4 = String.class;
        if (z3) {
            if (objectReadContext.disableAutoType()) {
                str7 = "(I)V";
                str8 = "()V";
                str9 = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                str10 = str11;
            } else {
                str8 = "()V";
                Label label7 = new Label();
                str7 = "(I)V";
                methodWriter.aload(0);
                String strFieldReader = CodeGenUtils.fieldReader(i2);
                str9 = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
                methodWriter.getfield(str, strFieldReader, ASMUtils.DESC_FIELD_READER);
                methodWriter.aload(1);
                str10 = str11;
                methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "checkObjectAutoType",
                        METHOD_DESC_CHECK_ARRAY_AUTO_TYPE);
                methodWriter.dup();
                methodWriter.astore(iVar2);
                methodWriter.ifnull(label7);
                methodWriter.aload(iVar2);
                methodWriter.aload(1);
                gwGetFieldType(str, methodWriter, i2, type);
                methodWriter.visitLdcInsn(fieldReader.fieldName);
                methodWriter.visitLdcInsn(j);
                methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER, "readJSONBObject", METHOD_DESC_READ_OBJECT);
                methodWriter.checkcast(str2);
                methodWriter.astore(iVar);
                methodWriter.goto_(label4);
                methodWriter.visitLabel(label7);
            }
            methodWriter.aload(1);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "startArray", "()I");
            methodWriter.dup();
            methodWriter.istore(iVar3);
            methodWriter.visitLdcInsn(-1);
            methodWriter.if_icmpne(label5);
            methodWriter.aconst_null();
            methodWriter.astore(iVar);
            methodWriter.goto_(label4);
            methodWriter.visitLabel(label5);
            if (fieldReader.method != null || (field = fieldReader.field) == null) {
                label3 = label6;
            } else {
                long jObjectFieldOffset = JDKUtils.UNSAFE.objectFieldOffset(field);
                methodWriter.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
                methodWriter.aload(i);
                methodWriter.visitLdcInsn(jObjectFieldOffset);
                methodWriter.invokevirtual("sun/misc/Unsafe", "getObject", "(Ljava/lang/Object;J)Ljava/lang/Object;");
                methodWriter.dup();
                methodWriter.checkcast(str2);
                methodWriter.astore(iVar);
                Label label8 = new Label();
                methodWriter.ifnull(label8);
                methodWriter.aload(iVar);
                methodWriter.invokevirtual("java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodWriter.getstatic("java/util/Collections", "EMPTY_LIST", "Ljava/util/List;");
                methodWriter.invokevirtual("java/lang/Object", "getClass", "()Ljava/lang/Class;");
                label3 = label6;
                methodWriter.if_acmpne(label3);
                methodWriter.visitLabel(label8);
            }
            String str15 = str10;
            methodWriter.new_(str15);
            methodWriter.dup();
            if (z5) {
                methodWriter.iload(iVar3);
                methodWriter.invokespecial(str15, str9, str7);
            } else {
                methodWriter.invokespecial(str15, str9, str8);
            }
            methodWriter.astore(iVar);
            methodWriter.visitLabel(label3);
            type3 = type6;
            i3 = iVar3;
            str3 = "readJSONBObject";
            str5 = "readString";
            str4 = "()Z";
        } else {
            String str16 = str11;
            Label label9 = new Label();
            Label label10 = new Label();
            Label label11 = new Label();
            str3 = "readJSONBObject";
            methodWriter.aload(1);
            String str17 = ASMUtils.TYPE_JSON_READER;
            str4 = "()Z";
            methodWriter.invokevirtual(str17, "nextIfNull", str4);
            methodWriter.ifne(label11);
            methodWriter.aload(1);
            methodWriter.invokevirtual(str17, "nextIfArrayStart", str4);
            methodWriter.ifne(label9);
            if (mapping == cls4) {
                i3 = iVar3;
                methodWriter.aload(1);
                methodWriter.invokevirtual(str17, "isString", str4);
                methodWriter.ifeq(label10);
                methodWriter.new_(str16);
                methodWriter.dup();
                if (z5) {
                    methodWriter.visitLdcInsn(10);
                    methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(I)V");
                } else {
                    methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V");
                }
                methodWriter.astore(iVar);
                methodWriter.aload(1);
                methodWriter.invokevirtual(str17, "nextIfNullOrEmptyString", str4);
                methodWriter.ifne(label4);
                methodWriter.aload(iVar);
                methodWriter.aload(1);
                if (mapping == cls4) {
                    str6 = "readString";
                    methodWriter.invokevirtual(str17, str6, "()Ljava/lang/String;");
                } else {
                    str6 = "readString";
                }
                cls4 = cls4;
                methodWriter.invokeinterface(str12, str14, str13);
                methodWriter.pop();
                methodWriter.goto_(label4);
                str12 = str12;
                str14 = str14;
                str13 = str13;
                type3 = type6;
                str5 = str6;
            } else {
                i3 = iVar3;
                str5 = "readString";
                type3 = type6;
                if (type3 instanceof Class) {
                    methodWriter.aload(1);
                    methodWriter.invokevirtual(str17, "nextIfNullOrEmptyString", str4);
                    methodWriter.ifne(label11);
                    methodWriter.new_(str16);
                    methodWriter.dup();
                    if (z5) {
                        cls4 = cls4;
                        methodWriter.visitLdcInsn(10);
                        methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(I)V");
                    } else {
                        cls4 = cls4;
                        methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V");
                    }
                    methodWriter.astore(iVar);
                    methodWriter.aload(1);
                    methodWriter.aload(iVar);
                    methodWriter.visitLdcInsn((Class) type3);
                    methodWriter.invokevirtual(str17, "readArray", "(Ljava/util/List;Ljava/lang/reflect/Type;)V");
                    methodWriter.goto_(label4);
                }
            }
            cls4 = cls4;
            methodWriter.visitLabel(label10);
            methodWriter.aload(1);
            methodWriter.invokevirtual(str17, "skipValue", "()V");
            methodWriter.visitLabel(label11);
            methodWriter.aconst_null();
            methodWriter.astore(iVar);
            methodWriter.goto_(label4);
            methodWriter.visitLabel(label9);
            methodWriter.new_(str16);
            methodWriter.dup();
            if (z5) {
                methodWriter.visitLdcInsn(10);
                methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(I)V");
            } else {
                methodWriter.invokespecial(str16, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V");
            }
            methodWriter.astore(iVar);
        }
        int iVar4 = methodWriterContext.var("J");
        Label label12 = new Label();
        Label label13 = new Label();
        Label label14 = new Label();
        methodWriter.iconst_0();
        methodWriter.istore(iVar4);
        methodWriter.visitLabel(label12);
        if (z3) {
            methodWriter.iload(iVar4);
            methodWriter.iload(i3);
            methodWriter.if_icmpge(label13);
            i4 = 1;
        } else {
            i4 = 1;
            methodWriter.aload(1);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "nextIfArrayEnd", str4);
            methodWriter.ifne(label13);
        }
        if (type3 == cls4) {
            methodWriter.aload(iVar);
            methodWriter.aload(i4);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, str5, "()Ljava/lang/String;");
        } else {
            if (type3 != Integer.class) {
                if (type3 == Long.class) {
                    methodWriter.aload(iVar);
                    methodWriter.aload(i4);
                    methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt64", "()Ljava/lang/Long;");
                } else {
                    Label label15 = new Label();
                    methodWriter.aload(0);
                    String str18 = ASMUtils.DESC_OBJECT_READER;
                    methodWriter.getfield(str, strFieldItemObjectReader, str18);
                    methodWriter.ifnonnull(label15);
                    methodWriter.aload(0);
                    methodWriter.aload(0);
                    methodWriter.getfield(str, CodeGenUtils.fieldReader(i2), ASMUtils.DESC_FIELD_READER);
                    methodWriter.aload(1);
                    methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getItemObjectReader",
                            METHOD_DESC_GET_ITEM_OBJECT_READER);
                    methodWriter.putfield(str, strFieldItemObjectReader, str18);
                    methodWriter.visitLabel(label15);
                    if (!objectReadContext.disableReferenceDetect()) {
                        methodWriter.aload(1);
                        methodWriter.aload(iVar);
                        methodWriter.iload(iVar4);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "readReference", "(Ljava/util/List;I)Z");
                        methodWriter.ifne(label14);
                    }
                    methodWriter.aload(iVar);
                    Label label16 = new Label();
                    Label label17 = new Label();
                    if (z) {
                        methodWriter.aload(1);
                        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "isArray", str4);
                        methodWriter.ifeq(label16);
                        methodWriter.aload(0);
                        methodWriter.getfield(str, strFieldItemObjectReader, str18);
                        methodWriter.aload(1);
                        objectReaderCreatorASM = this;
                        i5 = i2;
                        type4 = type;
                        objectReaderCreatorASM.gwGetFieldType(str, methodWriter, i5, type4);
                        fieldReader2 = fieldReader;
                        i6 = iVar;
                        methodWriter.visitLdcInsn(fieldReader2.fieldName);
                        methodWriter.lload(4);
                        label = label13;
                        label2 = label4;
                        methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER,
                                z3 ? "readArrayMappingJSONBObject" : "readArrayMappingObject", METHOD_DESC_READ_OBJECT);
                        methodWriter.goto_(label17);
                        methodWriter.visitLabel(label16);
                    } else {
                        objectReaderCreatorASM = this;
                        fieldReader2 = fieldReader;
                        i5 = i2;
                        type4 = type;
                        label = label13;
                        label2 = label4;
                        i6 = iVar;
                    }
                    methodWriter.aload(0);
                    methodWriter.getfield(str, strFieldItemObjectReader, str18);
                    methodWriter.aload(1);
                    objectReaderCreatorASM.gwGetFieldType(str, methodWriter, i5, type4);
                    methodWriter.visitLdcInsn(fieldReader2.fieldName);
                    methodWriter.lload(4);
                    methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER, z3 ? str3 : "readObject",
                            METHOD_DESC_READ_OBJECT);
                    if (z) {
                        methodWriter.visitLabel(label17);
                    }
                }
                methodWriter.invokeinterface(str12, str14, str13);
                methodWriter.pop();
                methodWriter.visitLabel(label14);
                methodWriter.visitIincInsn(iVar4, 1);
                methodWriter.goto_(label12);
                methodWriter.visitLabel(label);
                methodWriter.visitLabel(label2);
                methodWriter.aload(i6);
            }
            methodWriter.aload(iVar);
            methodWriter.aload(i4);
            methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "readInt32", "()Ljava/lang/Integer;");
        }
        label = label13;
        label2 = label4;
        i6 = iVar;
        methodWriter.invokeinterface(str12, str14, str13);
        methodWriter.pop();
        methodWriter.visitLabel(label14);
        methodWriter.visitIincInsn(iVar4, 1);
        methodWriter.goto_(label12);
        methodWriter.visitLabel(label);
        methodWriter.visitLabel(label2);
        methodWriter.aload(i6);
    }

    private void genReadHashCode64ValueForNonDefaultConstructor(ObjectReadContext objectReadContext,
            MethodWriterContext methodWriterContext, int i, boolean z, int i2, Label label) {
        FieldReader[] fieldReaderArr = objectReadContext.fieldReaders;
        MethodWriter methodWriter = methodWriterContext.mw;
        methodWriter.aload(0);
        methodWriter.lload(i);
        methodWriter.invokevirtual(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "getFieldOrdinal", "(J)I");
        Label label2 = new Label();
        Label[] labelArr = new Label[fieldReaderArr.length];
        int[] iArr = new int[fieldReaderArr.length];
        for (int i3 = 0; i3 < fieldReaderArr.length; i3++) {
            labelArr[i3] = new Label();
            iArr[i3] = i3;
        }
        methodWriter.visitLookupSwitchInsn(label2, iArr, labelArr);
        for (int i4 = 0; i4 < fieldReaderArr.length; i4++) {
            methodWriter.visitLabel(labelArr[i4]);
            genReadFieldValue(objectReadContext, fieldReaderArr[i4], z, methodWriterContext, i2, i4, false);
            methodWriter.goto_(label);
        }
        methodWriter.visitLabel(label2);
        methodWriter.aload(1);
        methodWriter.invokevirtual(ASMUtils.TYPE_JSON_READER, "skipValue", "()V");
    }

    private void genReadObject(FieldReader fieldReader, String str, MethodWriterContext methodWriterContext, int i,
            Type type, long j, String str2) {
        Label label = new Label();
        MethodWriter methodWriter = methodWriterContext.mw;
        boolean z = methodWriterContext.jsonb;
        methodWriter.aload(0);
        String str3 = ASMUtils.DESC_OBJECT_READER;
        methodWriter.getfield(str, str2, str3);
        methodWriter.ifnonnull(label);
        methodWriter.aload(0);
        methodWriter.aload(0);
        methodWriter.getfield(str, CodeGenUtils.fieldReader(i), ASMUtils.DESC_FIELD_READER);
        methodWriter.aload(1);
        methodWriter.invokevirtual(ASMUtils.TYPE_FIELD_READE, "getObjectReader", METHOD_DESC_GET_OBJECT_READER_1);
        methodWriter.putfield(str, str2, str3);
        methodWriter.visitLabel(label);
        methodWriter.aload(0);
        methodWriter.getfield(str, str2, str3);
        methodWriter.aload(1);
        gwGetFieldType(str, methodWriter, i, type);
        methodWriter.visitLdcInsn(fieldReader.fieldName);
        methodWriter.visitLdcInsn(j);
        methodWriter.invokeinterface(ASMUtils.TYPE_OBJECT_READER, z ? "readJSONBObject" : "readObject",
                METHOD_DESC_READ_OBJECT);
    }

    private void gwGetFieldType(String str, MethodWriter methodWriter, int i, Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            String name = cls.getName();
            boolean zIsPublic = Modifier.isPublic(cls.getModifiers());
            boolean z = name.startsWith("java.") || cls == JSONArray.class || cls == JSONObject.class;
            if (zIsPublic && z) {
                methodWriter.visitLdcInsn(cls);
                return;
            }
        }
        methodWriter.aload(0);
        methodWriter.getfield(str, CodeGenUtils.fieldReader(i), ASMUtils.DESC_FIELD_READER);
        methodWriter.getfield(ASMUtils.TYPE_FIELD_READE, "fieldType", "Ljava/lang/reflect/Type;");
    }

    private <T> ObjectReaderBean jitObjectReader(Class<T> cls, Type type, boolean z, boolean z2, int i,
            BeanInfo beanInfo, Supplier<T> supplier, FieldReader[] fieldReaderArr, Constructor constructor)
            throws IllegalAccessException, NoSuchMethodException {
        String str;
        Supplier<T> supplierCreateSupplier;
        FieldReader[] fieldReaderArr2;
        Class<T> cls2;
        String str2;
        ClassWriter classWriter = new ClassWriter(new cpu(cls, 1));
        ObjectReadContext objectReadContext = new ObjectReadContext(beanInfo, cls, classWriter, z2, fieldReaderArr,
                constructor);
        boolean z3 = true;
        boolean z4 = fieldReaderArr.length <= 96;
        switch (fieldReaderArr.length) {
            case 1:
                str = ASMUtils.TYPE_OBJECT_READER_1;
                break;
            case 2:
                str = ASMUtils.TYPE_OBJECT_READER_2;
                break;
            case 3:
                str = ASMUtils.TYPE_OBJECT_READER_3;
                break;
            case 4:
                str = ASMUtils.TYPE_OBJECT_READER_4;
                break;
            case 5:
                str = ASMUtils.TYPE_OBJECT_READER_5;
                break;
            case 6:
                str = ASMUtils.TYPE_OBJECT_READER_6;
                break;
            case 7:
                str = ASMUtils.TYPE_OBJECT_READER_7;
                break;
            case 8:
                str = ASMUtils.TYPE_OBJECT_READER_8;
                break;
            case 9:
                str = ASMUtils.TYPE_OBJECT_READER_9;
                break;
            case 10:
                str = ASMUtils.TYPE_OBJECT_READER_10;
                break;
            case 11:
                str = ASMUtils.TYPE_OBJECT_READER_11;
                break;
            case 12:
                str = ASMUtils.TYPE_OBJECT_READER_12;
                break;
            default:
                str = ASMUtils.TYPE_OBJECT_READER_ADAPTER;
                break;
        }
        String str3 = str;
        if (z4) {
            genFields(fieldReaderArr, classWriter, str3);
        }
        classWriter.visit(52, 49, objectReadContext.classNameType, str3, new String[0]);
        MethodWriter methodWriterVisitMethod = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                METHOD_DESC_INIT, fieldReaderArr.length <= 12 ? 32 : 128);
        methodWriterVisitMethod.aload(0);
        methodWriterVisitMethod.aload(1);
        String str4 = beanInfo.typeKey;
        if (str4 != null) {
            methodWriterVisitMethod.visitLdcInsn(str4);
        } else {
            methodWriterVisitMethod.aconst_null();
        }
        methodWriterVisitMethod.aconst_null();
        boolean z5 = z4;
        methodWriterVisitMethod.visitLdcInsn(beanInfo.readerFeatures);
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.aload(2);
        methodWriterVisitMethod.aconst_null();
        methodWriterVisitMethod.aload(3);
        methodWriterVisitMethod.invokespecial(str3, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                METHOD_DESC_ADAPTER_INIT);
        genInitFields(fieldReaderArr, objectReadContext.classNameType, z5, 3, methodWriterVisitMethod, str3);
        methodWriterVisitMethod.return_();
        methodWriterVisitMethod.visitMaxs(3, 3);
        String str5 = (z && constructor == null) ? "createInstance0" : "createInstance";
        if ((z2 && constructor != null) || (z && (constructor == null || !Modifier.isPublic(constructor.getModifiers())
                || !Modifier.isPublic(cls.getModifiers())))) {
            MethodWriter methodWriterVisitMethod2 = classWriter.visitMethod(1, str5, "(J)Ljava/lang/Object;", 32);
            methodWriterVisitMethod2.getstatic(ASMUtils.TYPE_UNSAFE_UTILS, "UNSAFE", "Lsun/misc/Unsafe;");
            methodWriterVisitMethod2.aload(0);
            methodWriterVisitMethod2.getfield(ASMUtils.TYPE_OBJECT_READER_ADAPTER, "objectClass", "Ljava/lang/Class;");
            methodWriterVisitMethod2.invokevirtual("sun/misc/Unsafe", "allocateInstance",
                    "(Ljava/lang/Class;)Ljava/lang/Object;");
            methodWriterVisitMethod2.areturn();
            methodWriterVisitMethod2.visitMaxs(3, 3);
        } else if (constructor != null && Modifier.isPublic(constructor.getModifiers())
                && Modifier.isPublic(cls.getModifiers())) {
            MethodWriter methodWriterVisitMethod3 = classWriter.visitMethod(1, str5, "(J)Ljava/lang/Object;", 32);
            newObject(methodWriterVisitMethod3, objectReadContext.objectType, constructor);
            methodWriterVisitMethod3.areturn();
            methodWriterVisitMethod3.visitMaxs(3, 3);
        }
        if (constructor != null) {
            if (Modifier.isPublic(i) && !this.classLoader.isExternalClass(cls)
                    && Modifier.isPublic(constructor.getModifiers())) {
                z3 = false;
            }
            supplierCreateSupplier = createSupplier(constructor, z3);
        } else {
            supplierCreateSupplier = supplier;
        }
        if (z5) {
            long j = beanInfo.readerFeatures;
            if (z) {
                j |= JSONReader.Feature.FieldBased.mask;
            }
            long j2 = j;
            boolean zDisableSupportArrayMapping = objectReadContext.disableSupportArrayMapping();
            boolean zDisableJSONB = objectReadContext.disableJSONB();
            fieldReaderArr2 = fieldReaderArr;
            ObjectReaderAdapter objectReaderAdapter = new ObjectReaderAdapter(cls, beanInfo.typeKey, beanInfo.typeName,
                    j2, null, supplierCreateSupplier, null, fieldReaderArr2);
            cls2 = cls;
            objectReadContext.objectReaderAdapter = objectReaderAdapter;
            if (!zDisableJSONB) {
                genMethodReadJSONBObject(objectReadContext, j2);
                if (!zDisableSupportArrayMapping) {
                    genMethodReadJSONBObjectArrayMapping(objectReadContext, j2);
                }
            }
            genMethodReadObject(objectReadContext, j2);
            if (str3 == ASMUtils.TYPE_OBJECT_READER_ADAPTER || str3 == ASMUtils.TYPE_OBJECT_READER_1
                    || str3 == ASMUtils.TYPE_OBJECT_READER_2 || str3 == ASMUtils.TYPE_OBJECT_READER_3
                    || str3 == ASMUtils.TYPE_OBJECT_READER_4 || str3 == ASMUtils.TYPE_OBJECT_READER_5
                    || str3 == ASMUtils.TYPE_OBJECT_READER_6 || str3 == ASMUtils.TYPE_OBJECT_READER_7
                    || str3 == ASMUtils.TYPE_OBJECT_READER_8 || str3 == ASMUtils.TYPE_OBJECT_READER_9
                    || str3 == ASMUtils.TYPE_OBJECT_READER_10 || str3 == ASMUtils.TYPE_OBJECT_READER_11
                    || str3 == ASMUtils.TYPE_OBJECT_READER_12) {
                genMethodGetFieldReader(objectReadContext);
                genMethodGetFieldReaderLCase(objectReadContext);
            }
        } else {
            fieldReaderArr2 = fieldReaderArr;
            cls2 = cls;
        }
        byte[] byteArray = classWriter.toByteArray();
        try {
            return (ObjectReaderBean) this.classLoader
                    .defineClassPublic(objectReadContext.classNameFull, byteArray, 0, byteArray.length)
                    .getConstructors()[0].newInstance(cls2, supplierCreateSupplier, fieldReaderArr2);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("create objectReader error");
            if (type == null) {
                str2 = "";
            } else {
                str2 = ", objectType " + type.getTypeName();
            }
            sb.append(str2);
            throw new JSONException(sb.toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$createNoneDefaultConstructorObjectReader$0(Class cls, String str) {
        if (cls.getName().equals(str)) {
            return cls;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$createValueConsumer0$6(Class cls, String str) {
        if (cls.getName().equals(str)) {
            return cls;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$createValueConsumer0$7(Constructor constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new JSONException("create ByteArrayValueConsumer error", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$genMethodGetFieldReader$2(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$genMethodGetFieldReaderLCase$3(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$genMethodReadJSONBObject$4(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$genMethodReadObject$5(Integer num) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Class lambda$jitObjectReader$1(Class cls, String str) {
        if (cls.getName().equals(str)) {
            return cls;
        }
        return null;
    }

    private static void newObject(MethodWriter methodWriter, String str, Constructor constructor) {
        methodWriter.new_(str);
        methodWriter.dup();
        if (constructor.getParameterCount() == 0) {
            methodWriter.invokespecial(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V");
            return;
        }
        Class<?> cls = constructor.getParameterTypes()[0];
        methodWriter.aconst_null();
        methodWriter.invokespecial(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(" + ASMUtils.desc(cls) + ")V");
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderCreator
    public Function<Consumer, ByteArrayValueConsumer> createByteArrayValueConsumerCreator(Class cls,
            FieldReader[] fieldReaderArr) {
        return createValueConsumer0(cls, fieldReaderArr, true);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderCreator
    public Function<Consumer, CharArrayValueConsumer> createCharArrayValueConsumerCreator(Class cls,
            FieldReader[] fieldReaderArr) {
        return createValueConsumer0(cls, fieldReaderArr, false);
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderCreator
    public <T> ObjectReaderNoneDefaultConstructor createNoneDefaultConstructorObjectReader(Class cls, BeanInfo beanInfo,
            Function<Map<Long, Object>, T> function, List<Constructor> list, String[] strArr,
            FieldReader[] fieldReaderArr, FieldReader[] fieldReaderArr2) {
        Class<?> cls2;
        Constructor constructor;
        ObjectReaderNoneDefaultConstructor objectReaderNoneDefaultConstructor = new ObjectReaderNoneDefaultConstructor(
                cls, beanInfo.typeKey, beanInfo.typeName, beanInfo.readerFeatures, function, list, strArr,
                fieldReaderArr, fieldReaderArr2, beanInfo.seeAlso, beanInfo.seeAlsoNames);
        boolean z = beanInfo.autoTypeBeforeHandler == null && fieldReaderArr2.length == 0
                && ((function instanceof ConstructorFunction) || (function instanceof FactoryFunction))
                && ((list == null || list.isEmpty()) && !this.classLoader.isExternalClass(cls)
                        && (beanInfo.readerFeatures & JSONReader.Feature.SupportAutoType.mask) == 0
                        && (((constructor = objectReaderNoneDefaultConstructor.noneDefaultConstructor) == null
                                || constructor.getParameterCount() == fieldReaderArr.length)
                                && ((!(function instanceof FactoryFunction)
                                        || ((FactoryFunction) function).paramNames.length == fieldReaderArr.length)
                                        && fieldReaderArr.length <= 64)));
        if (z) {
            for (FieldReader fieldReader : fieldReaderArr) {
                if (fieldReader.getInitReader() != null || fieldReader.defaultValue != null
                        || fieldReader.schema != null
                        || (((cls2 = fieldReader.fieldClass) != null
                                && (!Modifier.isPublic(cls2.getModifiers()) || this.classLoader.isExternalClass(cls2)))
                                || (((fieldReader instanceof FieldReaderMapField)
                                        && ((FieldReaderMapField) fieldReader).arrayToMapKey != null)
                                        || ((fieldReader instanceof FieldReaderMapMethod)
                                                && ((FieldReaderMapMethod) fieldReader).arrayToMapKey != null)))) {
                    z = false;
                    break;
                }
            }
        }
        if (!z) {
            return objectReaderNoneDefaultConstructor;
        }
        boolean z2 = cls != null && this.classLoader.isExternalClass(cls);
        ClassWriter classWriter = new ClassWriter(new cpu(cls, 2));
        beanInfo.readerFeatures |= FieldInfo.DISABLE_REFERENCE_DETECT;
        ObjectReadContext objectReadContext = new ObjectReadContext(beanInfo, cls, classWriter, z2, fieldReaderArr,
                null);
        objectReadContext.objectReaderAdapter = objectReaderNoneDefaultConstructor;
        String str = ASMUtils.TYPE_OBJECT_READER_NONE_DEFAULT_CONSTRUCTOR;
        genFields(fieldReaderArr, classWriter, str);
        classWriter.visit(52, 49, objectReadContext.classNameType, str, new String[0]);
        MethodWriter methodWriterVisitMethod = classWriter.visitMethod(1, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;JLjava/util/function/Function;Ljava/util/List;[Ljava/lang/String;[Lcom/alibaba/fastjson2/reader/FieldReader;[Lcom/alibaba/fastjson2/reader/FieldReader;[Ljava/lang/Class;[Ljava/lang/String;)V",
                fieldReaderArr2.length <= 12 ? 32 : 128);
        methodWriterVisitMethod.aload(0);
        methodWriterVisitMethod.aload(1);
        methodWriterVisitMethod.aload(2);
        methodWriterVisitMethod.aload(3);
        methodWriterVisitMethod.lload(4);
        methodWriterVisitMethod.aload(6);
        methodWriterVisitMethod.aload(7);
        methodWriterVisitMethod.aload(8);
        methodWriterVisitMethod.aload(9);
        methodWriterVisitMethod.aload(10);
        methodWriterVisitMethod.aload(11);
        methodWriterVisitMethod.aload(12);
        methodWriterVisitMethod.invokespecial(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME,
                "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;JLjava/util/function/Function;Ljava/util/List;[Ljava/lang/String;[Lcom/alibaba/fastjson2/reader/FieldReader;[Lcom/alibaba/fastjson2/reader/FieldReader;[Ljava/lang/Class;[Ljava/lang/String;)V");
        genInitFields(fieldReaderArr, objectReadContext.classNameType, true, 9, methodWriterVisitMethod, str);
        methodWriterVisitMethod.return_();
        methodWriterVisitMethod.visitMaxs(3, 3);
        genMethodReadObject(objectReadContext, beanInfo.readerFeatures);
        if (!objectReadContext.disableJSONB()) {
            genMethodReadJSONBObject(objectReadContext, beanInfo.readerFeatures);
        }
        byte[] byteArray = classWriter.toByteArray();
        try {
            return (ObjectReaderNoneDefaultConstructor) this.classLoader
                    .defineClassPublic(objectReadContext.classNameFull, byteArray, 0, byteArray.length)
                    .getConstructors()[0].newInstance(cls, beanInfo.typeKey, beanInfo.typeName,
                            Long.valueOf(beanInfo.readerFeatures), function, list, strArr, fieldReaderArr,
                            fieldReaderArr2, null, null);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("create objectReader error");
            sb.append(cls == null ? "" : ", objectType " + cls.getTypeName());
            throw new JSONException(sb.toString(), th);
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderCreator
    public <T> ObjectReader<T> createObjectReader(Class<T> cls, Type type, boolean z,
            ObjectReaderProvider objectReaderProvider) {
        Constructor defaultConstructor;
        String str;
        Class cls2;
        Method method;
        boolean z2 = cls != null && this.classLoader.isExternalClass(cls);
        int modifiers = cls.getModifiers();
        if (Modifier.isAbstract(modifiers) || Modifier.isInterface(modifiers)) {
            return super.createObjectReader(cls, type, z, objectReaderProvider);
        }
        BeanInfo beanInfo = new BeanInfo(objectReaderProvider);
        objectReaderProvider.getBeanInfo(beanInfo, cls);
        if (z2 || !Modifier.isPublic(modifiers)) {
            beanInfo.readerFeatures |= FieldInfo.JIT;
        }
        Class cls3 = beanInfo.deserializer;
        if (cls3 != null && ObjectReader.class.isAssignableFrom(cls3)) {
            try {
                Constructor<T> declaredConstructor = beanInfo.deserializer.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                return (ObjectReader) declaredConstructor.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException
                    | InvocationTargetException e) {
                throw new JSONException("create deserializer error", e);
            }
        }
        boolean z3 = (z && (cls.isInterface() || BeanUtils.isRecord(cls))) ? false : z;
        if (Enum.class.isAssignableFrom(cls)
                && ((method = beanInfo.createMethod) == null || method.getParameterCount() == 1)) {
            return createEnumReader(cls, beanInfo.createMethod, objectReaderProvider);
        }
        if (beanInfo.creatorConstructor != null || beanInfo.createMethod != null) {
            return createObjectReaderWithCreator(cls, type, objectReaderProvider, beanInfo);
        }
        if (beanInfo.builder != null) {
            return createObjectReaderWithBuilder(cls, type, objectReaderProvider, beanInfo);
        }
        if (Throwable.class.isAssignableFrom(cls) || BeanUtils.isExtendedMap(cls)) {
            return super.createObjectReader(cls, type, z3, objectReaderProvider);
        }
        if (cls == Class.class) {
            return ObjectReaderImplClass.INSTANCE;
        }
        FieldReader[] fieldReaderArrCreateFieldReaders = createFieldReaders(cls, type, beanInfo, z3,
                objectReaderProvider);
        boolean z4 = fieldReaderArrCreateFieldReaders.length <= 96;
        if (!z3) {
            if (JDKUtils.JVM_VERSION >= 9 && cls == StackTraceElement.class) {
                try {
                    return createObjectReaderNoneDefaultConstructor(
                            StackTraceElement.class.getConstructor(String.class, String.class, String.class,
                                    String.class, String.class, String.class, Integer.TYPE),
                            "", "classLoaderName", "moduleName", "moduleVersion", "declaringClass", "methodName",
                            "fileName", "lineNumber");
                } catch (NoSuchMethodException | SecurityException unused) {
                }
            }
            for (FieldReader fieldReader : fieldReaderArrCreateFieldReaders) {
                if (fieldReader.isReadOnly() || fieldReader.isUnwrapped()
                        || (fieldReader.features & FieldInfo.READ_USING_MASK) != 0) {
                    z4 = false;
                    break;
                }
            }
        }
        if (beanInfo.autoTypeBeforeHandler != null) {
            z4 = false;
        }
        if (z4) {
            for (FieldReader fieldReader2 : fieldReaderArrCreateFieldReaders) {
                if (fieldReader2.defaultValue != null || fieldReader2.schema != null
                        || (((cls2 = fieldReader2.fieldClass) != null && !Modifier.isPublic(cls2.getModifiers()))
                                || (((fieldReader2 instanceof FieldReaderMapField)
                                        && ((FieldReaderMapField) fieldReader2).arrayToMapKey != null)
                                        || ((fieldReader2 instanceof FieldReaderMapMethod)
                                                && ((FieldReaderMapMethod) fieldReader2).arrayToMapKey != null)))) {
                    z4 = false;
                    break;
                }
            }
        }
        if (z4 && (beanInfo.rootName != null || ((str = beanInfo.schema) != null && !str.isEmpty()))) {
            z4 = false;
        }
        if (!z4) {
            return super.createObjectReader(cls, type, z3, objectReaderProvider);
        }
        if (Modifier.isInterface(modifiers) || Modifier.isAbstract(modifiers)
                || (defaultConstructor = BeanUtils.getDefaultConstructor(cls, true)) == null) {
            defaultConstructor = null;
        } else {
            try {
                defaultConstructor.setAccessible(true);
            } catch (SecurityException unused2) {
            }
        }
        Class[] clsArr = beanInfo.seeAlso;
        return (clsArr == null || clsArr.length == 0)
                ? (z3 || defaultConstructor != null)
                        ? jitObjectReader(cls, type, z3, z2, modifiers, beanInfo, null,
                                fieldReaderArrCreateFieldReaders, defaultConstructor)
                        : super.createObjectReader(cls, type, false, objectReaderProvider)
                : createObjectReaderSeeAlso(cls, beanInfo.typeKey, clsArr, beanInfo.seeAlsoNames,
                        beanInfo.seeAlsoDefault, fieldReaderArrCreateFieldReaders);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class MethodWriterContext {
        static final int FEATURES = 4;
        static final int FIELD_NAME = 3;
        static final int FIELD_TYPE = 2;
        static final int JSON_READER = 1;
        final boolean jsonb;
        int maxVariant;
        final MethodWriter mw;
        final Map<Object, Integer> variants = new LinkedHashMap();

        public MethodWriterContext(MethodWriter methodWriter, int i, boolean z) {
            this.mw = methodWriter;
            this.maxVariant = i;
            this.jsonb = z;
        }

        public int var(Object obj) {
            Integer numValueOf = this.variants.get(obj);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.maxVariant);
                this.variants.put(obj, numValueOf);
                if (obj == Long.TYPE || obj == Double.TYPE) {
                    this.maxVariant += 2;
                } else {
                    this.maxVariant++;
                }
            }
            return numValueOf.intValue();
        }

        public int var2(Object obj) {
            Integer numValueOf = this.variants.get(obj);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.maxVariant);
                this.variants.put(obj, numValueOf);
                this.maxVariant += 2;
            }
            return numValueOf.intValue();
        }

        public int var(FieldReader fieldReader) {
            return var("_param_" + fieldReader.fieldName, fieldReader.fieldClass);
        }

        public int var(String str, Class cls) {
            Integer numValueOf = this.variants.get(str);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.maxVariant);
                this.variants.put(str, numValueOf);
                if (cls != Long.TYPE && cls != Double.TYPE) {
                    this.maxVariant++;
                } else {
                    this.maxVariant += 2;
                }
            }
            return numValueOf.intValue();
        }
    }

    @Override // com.alibaba.fastjson2.reader.ObjectReaderCreator
    public <T> ObjectReader<T> createObjectReader(Class<T> cls, String str, String str2, long j, JSONSchema jSONSchema,
            Supplier<T> supplier, Function function, FieldReader... fieldReaderArr) {
        if (cls == null && supplier != null && function == null) {
            for (FieldReader fieldReader : fieldReaderArr) {
                if (fieldReader.getFunction() != null) {
                }
            }
            return jitObjectReader(cls, cls, false, false, 0,
                    new BeanInfo(JSONFactory.getDefaultObjectReaderProvider()), supplier, fieldReaderArr, null);
        }
        return super.createObjectReader(cls, str, str2, j, jSONSchema, supplier, function, fieldReaderArr);
    }
}
