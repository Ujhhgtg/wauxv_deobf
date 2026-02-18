package com.alibaba.fastjson2.modules;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import com.alibaba.fastjson2.reader.ObjectReader;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ObjectReaderModule {
    default ObjectReaderAnnotationProcessor getAnnotationProcessor() {
        return null;
    }

    default void getBeanInfo(BeanInfo beanInfo, Class<?> cls) {
        ObjectReaderAnnotationProcessor annotationProcessor = getAnnotationProcessor();
        if (annotationProcessor != null) {
            annotationProcessor.getBeanInfo(beanInfo, cls);
        }
    }

    default void getFieldInfo(FieldInfo fieldInfo, Class cls, Field field) {
        ObjectReaderAnnotationProcessor annotationProcessor = getAnnotationProcessor();
        if (annotationProcessor != null) {
            annotationProcessor.getFieldInfo(fieldInfo, cls, field);
        }
    }

    default ObjectReader getObjectReader(Type type) {
        return null;
    }

    default ObjectReaderProvider getProvider() {
        return null;
    }

    default void init(ObjectReaderProvider objectReaderProvider) {
    }

    default ObjectReader getObjectReader(ObjectReaderProvider objectReaderProvider, Type type) {
        return getObjectReader(type);
    }
}
