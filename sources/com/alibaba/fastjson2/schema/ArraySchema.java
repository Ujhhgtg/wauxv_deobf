package com.alibaba.fastjson2.schema;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.umeng.analytics.pro.f;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.kx;
import me.hd.wauxv.obf.ky;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ArraySchema extends JSONSchema {
    final JSONSchema additionalItem;
    final boolean additionalItems;
    final AllOf allOf;
    final AnyOf anyOf;
    final JSONSchema contains;
    final Map<String, JSONSchema> definitions;
    final Map<String, JSONSchema> defs;
    final boolean encoded;
    JSONSchema itemSchema;
    final int maxContains;
    final int maxLength;
    final int minContains;
    final int minLength;
    final OneOf oneOf;
    final JSONSchema[] prefixItems;
    final boolean typed;
    final boolean uniqueItems;

    /* JADX WARN: Found duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Found duplicated region for block: B:44:0x00fe  */
    /* JADX WARN: Found duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Found duplicated region for block: B:47:0x0109  */
    /* JADX WARN: Found duplicated region for block: B:49:0x010d  */
    /* JADX WARN: Found duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Found duplicated region for block: B:63:0x012d  */
    /* JADX WARN: Found duplicated region for block: B:64:0x0132  */
    /* JADX WARN: Found duplicated region for block: B:67:0x0140  */
    /* JADX WARN: Found duplicated region for block: B:69:0x0148  */
    /* JADX WARN: Found duplicated region for block: B:71:0x0150  */
    /* JADX WARN: Found duplicated region for block: B:72:0x0153  */
    /* JADX WARN: Found duplicated region for block: B:73:0x0156  */
    /* JADX WARN: Found duplicated region for block: B:75:0x015a  */
    /* JADX WARN: Found duplicated region for block: B:76:0x015c  */
    public ArraySchema(JSONObject jSONObject, JSONSchema jSONSchema) {
        boolean zBooleanValue;
        JSONSchema jSONSchema2;
        super(jSONObject);
        this.typed = "array".equals(jSONObject.get(f.y));
        this.definitions = new LinkedHashMap();
        this.defs = new LinkedHashMap();
        this.encoded = jSONObject.getBooleanValue("encoded", false);
        JSONObject jSONObject2 = jSONObject.getJSONObject("definitions");
        if (jSONObject2 != null) {
            for (Map.Entry<String, Object> entry : jSONObject2.entrySet()) {
                this.definitions.put(entry.getKey(), JSONSchema.of((JSONObject) entry.getValue(), jSONSchema == null ? this : jSONSchema));
            }
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("$defs");
        if (jSONObject3 != null) {
            for (Map.Entry<String, Object> entry2 : jSONObject3.entrySet()) {
                this.defs.put(entry2.getKey(), JSONSchema.of((JSONObject) entry2.getValue(), jSONSchema == null ? this : jSONSchema));
            }
        }
        this.minLength = jSONObject.getIntValue("minItems", -1);
        this.maxLength = jSONObject.getIntValue("maxItems", -1);
        Object obj = jSONObject.get("items");
        Object obj2 = jSONObject.get("additionalItems");
        JSONArray jSONArray = jSONObject.getJSONArray("prefixItems");
        boolean z = true;
        if (obj != null) {
            if (obj instanceof Boolean) {
                zBooleanValue = ((Boolean) obj).booleanValue();
                this.itemSchema = null;
            } else if (!(obj instanceof JSONArray)) {
                this.itemSchema = JSONSchema.of((JSONObject) obj, jSONSchema != null ? jSONSchema : this);
            } else {
                if (jSONArray != null) {
                    throw new JSONException(StaticHelpers6.concatVar2Var1(obj, "schema error, items : "));
                }
                jSONArray = (JSONArray) obj;
                this.itemSchema = null;
            }
            if (obj2 instanceof JSONObject) {
                this.additionalItem = JSONSchema.of((JSONObject) obj2, jSONSchema == null ? this : jSONSchema);
                zBooleanValue = true;
            } else if (obj2 instanceof Boolean) {
                zBooleanValue = ((Boolean) obj2).booleanValue();
                this.additionalItem = null;
            } else {
                this.additionalItem = null;
            }
            jSONSchema2 = this.itemSchema;
            if ((jSONSchema2 != null || (jSONSchema2 instanceof Any)) && (jSONArray != null || (obj instanceof Boolean))) {
            }
            this.additionalItems = z;
            if (jSONArray == null) {
                this.prefixItems = new JSONSchema[0];
            } else {
                this.prefixItems = new JSONSchema[jSONArray.size()];
                for (int i = 0; i < jSONArray.size(); i++) {
                    Object obj3 = jSONArray.get(i);
                    this.prefixItems[i] = !(obj3 instanceof Boolean) ? ((Boolean) obj3).booleanValue() ? Any.INSTANCE : Any.NOT_ANY : JSONSchema.of((JSONObject) obj3, jSONSchema == null ? this : jSONSchema);
                }
            }
            this.contains = (JSONSchema) jSONObject.getObject("contains", new ky(0));
            this.minContains = jSONObject.getIntValue("minContains", -1);
            this.maxContains = jSONObject.getIntValue("maxContains", -1);
            this.uniqueItems = jSONObject.getBooleanValue("uniqueItems");
            this.allOf = JSONSchema.allOf(jSONObject, null);
            this.anyOf = JSONSchema.anyOf(jSONObject, (Class) null);
            this.oneOf = JSONSchema.oneOf(jSONObject, (Class) null);
        }
        this.itemSchema = null;
        zBooleanValue = true;
        if (obj2 instanceof JSONObject) {
            this.additionalItem = JSONSchema.of((JSONObject) obj2, jSONSchema == null ? this : jSONSchema);
            zBooleanValue = true;
        } else if (obj2 instanceof Boolean) {
            zBooleanValue = ((Boolean) obj2).booleanValue();
            this.additionalItem = null;
        } else {
            this.additionalItem = null;
        }
        jSONSchema2 = this.itemSchema;
        z = jSONSchema2 != null ? zBooleanValue : zBooleanValue;
        this.additionalItems = z;
        if (jSONArray == null) {
            this.prefixItems = new JSONSchema[0];
        } else {
            this.prefixItems = new JSONSchema[jSONArray.size()];
            while (i < jSONArray.size()) {
                Object obj32 = jSONArray.get(i);
                if (!(obj32 instanceof Boolean)) {
                }
                this.prefixItems[i] = !(obj32 instanceof Boolean) ? ((Boolean) obj32).booleanValue() ? Any.INSTANCE : Any.NOT_ANY : JSONSchema.of((JSONObject) obj32, jSONSchema == null ? this : jSONSchema);
            }
        }
        this.contains = (JSONSchema) jSONObject.getObject("contains", new ky(0));
        this.minContains = jSONObject.getIntValue("minContains", -1);
        this.maxContains = jSONObject.getIntValue("maxContains", -1);
        this.uniqueItems = jSONObject.getBooleanValue("uniqueItems");
        this.allOf = JSONSchema.allOf(jSONObject, null);
        this.anyOf = JSONSchema.anyOf(jSONObject, (Class) null);
        this.oneOf = JSONSchema.oneOf(jSONObject, (Class) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$validate$0(Object[] objArr, int i) {
        return objArr[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$validate$2(Iterator it, int i) {
        return it.next();
    }

    private ValidateResult validateItems(Object obj, int i, IntFunction<Object> intFunction) {
        JSONSchema jSONSchema;
        int i2 = this.minLength;
        if (i2 >= 0 && i < i2) {
            return new ValidateResult(false, "minLength not match, expect >= %s, but %s", Integer.valueOf(i2), Integer.valueOf(i));
        }
        int i3 = this.maxLength;
        if (i3 >= 0 && i > i3) {
            return new ValidateResult(false, "maxLength not match, expect <= %s, but %s", Integer.valueOf(i3), Integer.valueOf(i));
        }
        if (!this.additionalItems) {
            JSONSchema[] jSONSchemaArr = this.prefixItems;
            if (i > jSONSchemaArr.length) {
                return new ValidateResult(false, "additional items not match, max size %s, but %s", Integer.valueOf(jSONSchemaArr.length), Integer.valueOf(i));
            }
        }
        boolean z = obj instanceof Collection;
        HashSet hashSet = null;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object objApply = intFunction.apply(i5);
            JSONSchema[] jSONSchemaArr2 = this.prefixItems;
            if (i5 < jSONSchemaArr2.length) {
                ValidateResult validateResultValidate = jSONSchemaArr2[i5].validate(objApply);
                if (!validateResultValidate.isSuccess()) {
                    return validateResultValidate;
                }
            } else {
                if (z && this.itemSchema == null && (jSONSchema = this.additionalItem) != null) {
                    ValidateResult validateResultValidate2 = jSONSchema.validate(objApply);
                    if (!validateResultValidate2.isSuccess()) {
                        return validateResultValidate2;
                    }
                }
                JSONSchema jSONSchema2 = this.itemSchema;
                if (jSONSchema2 != null) {
                    ValidateResult validateResultValidate3 = jSONSchema2.validate(objApply);
                    if (!validateResultValidate3.isSuccess()) {
                        return validateResultValidate3;
                    }
                }
            }
            JSONSchema jSONSchema3 = this.contains;
            if (jSONSchema3 != null && ((this.minContains > 0 || this.maxContains > 0 || i4 == 0) && jSONSchema3.validate(objApply) == JSONSchema.SUCCESS)) {
                i4++;
            }
            if (this.uniqueItems) {
                if (hashSet == null) {
                    hashSet = new HashSet(i, 1.0f);
                }
                if (objApply instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) objApply;
                    objApply = bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
                }
                if (!hashSet.add(objApply)) {
                    return JSONSchema.UNIQUE_ITEMS_NOT_MATCH;
                }
            }
        }
        if (!z || this.contains != null) {
            int i6 = this.minContains;
            if (i6 >= 0 && i4 < i6) {
                return new ValidateResult(false, "minContains not match, expect %s, but %s", Integer.valueOf(i6), Integer.valueOf(i4));
            }
            if (z) {
                if (i4 == 0 && i6 != 0) {
                    return JSONSchema.CONTAINS_NOT_MATCH;
                }
            } else if (this.contains != null && i4 == 0) {
                return JSONSchema.CONTAINS_NOT_MATCH;
            }
            int i7 = this.maxContains;
            if (i7 >= 0 && i4 > i7) {
                return new ValidateResult(false, "maxContains not match, expect %s, but %s", Integer.valueOf(i7), Integer.valueOf(i4));
            }
        }
        AllOf allOf = this.allOf;
        if (allOf != null) {
            ValidateResult validateResultValidate4 = allOf.validate(obj);
            if (!validateResultValidate4.isSuccess()) {
                return validateResultValidate4;
            }
        }
        AnyOf anyOf = this.anyOf;
        if (anyOf != null) {
            ValidateResult validateResultValidate5 = anyOf.validate(obj);
            if (!validateResultValidate5.isSuccess()) {
                return validateResultValidate5;
            }
        }
        OneOf oneOf = this.oneOf;
        if (oneOf != null) {
            ValidateResult validateResultValidate6 = oneOf.validate(obj);
            if (!validateResultValidate6.isSuccess()) {
                return validateResultValidate6;
            }
        }
        return JSONSchema.SUCCESS;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public void accept(Predicate<JSONSchema> predicate) {
        JSONSchema jSONSchema;
        if (!predicate.test(this) || (jSONSchema = this.itemSchema) == null) {
            return;
        }
        jSONSchema.accept(predicate);
    }

    public JSONSchema getItemSchema() {
        return this.itemSchema;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONSchema.Type getType() {
        return JSONSchema.Type.Array;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f.y, "array");
        int i = this.maxLength;
        if (i != -1) {
            jSONObject.put("maxLength", Integer.valueOf(i));
        }
        int i2 = this.minLength;
        if (i2 != -1) {
            jSONObject.put("minLength", Integer.valueOf(i2));
        }
        JSONSchema jSONSchema = this.itemSchema;
        if (jSONSchema != null) {
            jSONObject.put("items", jSONSchema);
        }
        JSONSchema[] jSONSchemaArr = this.prefixItems;
        if (jSONSchemaArr != null && jSONSchemaArr.length != 0) {
            jSONObject.put("prefixItems", jSONSchemaArr);
        }
        boolean z = this.additionalItems;
        if (!z) {
            jSONObject.put("additionalItems", Boolean.valueOf(z));
        }
        JSONSchema jSONSchema2 = this.additionalItem;
        if (jSONSchema2 != null) {
            jSONObject.put("additionalItem", jSONSchema2);
        }
        JSONSchema jSONSchema3 = this.contains;
        if (jSONSchema3 != null) {
            jSONObject.put("contains", jSONSchema3);
        }
        int i3 = this.minContains;
        if (i3 != -1) {
            jSONObject.put("minContains", Integer.valueOf(i3));
        }
        int i4 = this.maxContains;
        if (i4 != -1) {
            jSONObject.put("maxContains", Integer.valueOf(i4));
        }
        boolean z2 = this.uniqueItems;
        if (z2) {
            jSONObject.put("uniqueItems", Boolean.valueOf(z2));
        }
        return JSONSchema.injectIfPresent(jSONObject, this.allOf, this.anyOf, this.oneOf);
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Object obj) {
        if (obj == null) {
            return this.typed ? JSONSchema.FAIL_INPUT_NULL : JSONSchema.SUCCESS;
        }
        if (this.encoded) {
            if (!(obj instanceof String)) {
                return JSONSchema.FAIL_INPUT_NOT_ENCODED;
            }
            try {
                obj = JSON.parseArray((String) obj);
            } catch (JSONException unused) {
                return JSONSchema.FAIL_INPUT_NOT_ENCODED;
            }
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            return validateItems(obj, objArr.length, new kx(objArr, 0));
        }
        if (obj.getClass().isArray()) {
            return validateItems(obj, Array.getLength(obj), new kx(obj, 1));
        }
        if (!(obj instanceof Collection)) {
            return this.typed ? JSONSchema.FAIL_TYPE_NOT_MATCH : JSONSchema.SUCCESS;
        }
        Collection collection = (Collection) obj;
        return validateItems(obj, collection.size(), new kx(collection.iterator(), 2));
    }
}
