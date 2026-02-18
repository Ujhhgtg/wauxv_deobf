package com.alibaba.fastjson2.schema;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.umeng.analytics.pro.f;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class BooleanSchema extends JSONSchema {
    public BooleanSchema(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONSchema.Type getType() {
        return JSONSchema.Type.Boolean;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONObject toJSONObject() {
        return JSONObject.of(f.y, (Object) "boolean");
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Object obj) {
        return obj == null ? JSONSchema.FAIL_INPUT_NULL : obj instanceof Boolean ? JSONSchema.SUCCESS : new ValidateResult(false, "expect type %s, but %s", JSONSchema.Type.Boolean, obj.getClass());
    }
}
