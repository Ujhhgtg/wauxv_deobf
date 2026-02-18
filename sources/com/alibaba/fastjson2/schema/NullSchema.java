package com.alibaba.fastjson2.schema;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.schema.JSONSchema;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class NullSchema extends JSONSchema {
    public NullSchema(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONSchema.Type getType() {
        return JSONSchema.Type.Null;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Object obj) {
        return obj == null ? JSONSchema.SUCCESS : new ValidateResult(false, "expect type %s, but %s", JSONSchema.Type.Null, obj.getClass());
    }
}
