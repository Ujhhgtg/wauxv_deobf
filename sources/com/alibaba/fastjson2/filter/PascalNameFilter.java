package com.alibaba.fastjson2.filter;

import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.util.BeanUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class PascalNameFilter implements NameFilter {
    @Override // com.alibaba.fastjson2.filter.NameFilter
    public String process(Object obj, String str, Object obj2) {
        return BeanUtils.fieldName(str, PropertyNamingStrategy.PascalCase.name());
    }
}
