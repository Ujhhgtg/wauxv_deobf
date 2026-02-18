package com.alibaba.fastjson2.modules;

import com.alibaba.fastjson2.codec.BeanInfo;
import com.alibaba.fastjson2.codec.FieldInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ObjectReaderAnnotationProcessor {
    default void getBeanInfo(BeanInfo beanInfo, Class<?> cls) {
    }

    default void getFieldInfo(FieldInfo fieldInfo, Class cls, Constructor constructor, int i, Parameter parameter) {
    }

    default void getFieldInfo(FieldInfo fieldInfo, Class cls, Field field) {
    }

    default void getFieldInfo(FieldInfo fieldInfo, Class cls, Method method) {
    }

    default void getFieldInfo(FieldInfo fieldInfo, Class cls, Method method, int i, Parameter parameter) {
    }
}
