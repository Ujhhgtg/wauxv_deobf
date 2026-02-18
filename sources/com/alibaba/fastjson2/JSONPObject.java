package com.alibaba.fastjson2;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class JSONPObject {
    private String function;
    private final List<Object> parameters = new ArrayList();

    public JSONPObject() {
    }

    public void addParameter(Object obj) {
        this.parameters.add(obj);
    }

    public String getFunction() {
        return this.function;
    }

    public List<Object> getParameters() {
        return this.parameters;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public JSONPObject(String str) {
        this.function = str;
    }
}
