package com.alibaba.fastjson2.schema;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.schema.JSONSchema;
import com.umeng.analytics.pro.f;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class NumberSchema extends JSONSchema {
    final boolean exclusiveMaximum;
    final boolean exclusiveMinimum;
    final BigDecimal maximum;
    final long maximumLongValue;
    final BigDecimal minimum;
    final long minimumLongValue;
    final BigDecimal multipleOf;
    final long multipleOfLongValue;
    final boolean typed;

    public NumberSchema(JSONObject jSONObject) {
        super(jSONObject);
        this.typed = "number".equals(jSONObject.get(f.y));
        Object obj = jSONObject.get("exclusiveMinimum");
        BigDecimal bigDecimal = jSONObject.getBigDecimal("minimum");
        Boolean bool = Boolean.TRUE;
        if (obj == bool) {
            this.minimum = bigDecimal;
            this.exclusiveMinimum = true;
        } else if (obj instanceof Number) {
            this.minimum = jSONObject.getBigDecimal("exclusiveMinimum");
            this.exclusiveMinimum = true;
        } else {
            this.minimum = bigDecimal;
            this.exclusiveMinimum = false;
        }
        BigDecimal bigDecimal2 = this.minimum;
        if (bigDecimal2 == null || bigDecimal2.compareTo(BigDecimal.valueOf(bigDecimal2.longValue())) != 0) {
            this.minimumLongValue = Long.MIN_VALUE;
        } else {
            this.minimumLongValue = this.minimum.longValue();
        }
        BigDecimal bigDecimal3 = jSONObject.getBigDecimal("maximum");
        Object obj2 = jSONObject.get("exclusiveMaximum");
        if (obj2 == bool) {
            this.maximum = bigDecimal3;
            this.exclusiveMaximum = true;
        } else if (obj2 instanceof Number) {
            this.maximum = jSONObject.getBigDecimal("exclusiveMaximum");
            this.exclusiveMaximum = true;
        } else {
            this.maximum = bigDecimal3;
            this.exclusiveMaximum = false;
        }
        BigDecimal bigDecimal4 = this.maximum;
        if (bigDecimal4 == null || bigDecimal4.compareTo(BigDecimal.valueOf(bigDecimal4.longValue())) != 0) {
            this.maximumLongValue = Long.MIN_VALUE;
        } else {
            this.maximumLongValue = this.maximum.longValue();
        }
        BigDecimal bigDecimal5 = jSONObject.getBigDecimal("multipleOf");
        this.multipleOf = bigDecimal5;
        if (bigDecimal5 == null) {
            this.multipleOfLongValue = Long.MIN_VALUE;
            return;
        }
        long jLongValue = bigDecimal5.longValue();
        if (bigDecimal5.compareTo(BigDecimal.valueOf(jLongValue)) == 0) {
            this.multipleOfLongValue = jLongValue;
        } else {
            this.multipleOfLongValue = Long.MIN_VALUE;
        }
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONSchema.Type getType() {
        return JSONSchema.Type.Number;
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public JSONObject toJSONObject() {
        JSONObject jSONObjectOf = JSONObject.of(f.y, (Object) "number");
        long j = this.minimumLongValue;
        if (j != Long.MIN_VALUE) {
            jSONObjectOf.put(this.exclusiveMinimum ? "exclusiveMinimum" : "minimum", Long.valueOf(j));
        } else {
            BigDecimal bigDecimal = this.minimum;
            if (bigDecimal != null) {
                jSONObjectOf.put(this.exclusiveMinimum ? "exclusiveMinimum" : "minimum", bigDecimal);
            }
        }
        long j2 = this.maximumLongValue;
        if (j2 != Long.MIN_VALUE) {
            jSONObjectOf.put(this.exclusiveMaximum ? "exclusiveMaximum" : "maximum", Long.valueOf(j2));
        } else {
            BigDecimal bigDecimal2 = this.maximum;
            if (bigDecimal2 != null) {
                jSONObjectOf.put(this.exclusiveMaximum ? "exclusiveMaximum" : "maximum", bigDecimal2);
            }
        }
        long j3 = this.multipleOfLongValue;
        if (j3 != Long.MIN_VALUE) {
            jSONObjectOf.put("multipleOf", Long.valueOf(j3));
            return jSONObjectOf;
        }
        BigDecimal bigDecimal3 = this.multipleOf;
        if (bigDecimal3 != null) {
            jSONObjectOf.put("multipleOf", bigDecimal3);
        }
        return jSONObjectOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0086, code lost:
    
        if (r4.exclusiveMaximum == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0088, code lost:
    
        r1 = "exclusiveMaximum not match, expect < %s, but %s";
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x008b, code lost:
    
        r1 = "maximum not match, expect <= %s, but %s";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0096, code lost:
    
        return new com.alibaba.fastjson2.schema.ValidateResult(false, r1, r4.maximum, r5);
     */
    @Override // com.alibaba.fastjson2.schema.JSONSchema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.fastjson2.schema.ValidateResult validate(java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.schema.NumberSchema.validate(java.lang.Object):com.alibaba.fastjson2.schema.ValidateResult");
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Integer num) {
        if (num == null) {
            return JSONSchema.SUCCESS;
        }
        return validate(num.longValue());
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Float f) {
        if (f == null) {
            return JSONSchema.SUCCESS;
        }
        return validate(f.doubleValue());
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Double d) {
        if (d == null) {
            return JSONSchema.SUCCESS;
        }
        return validate(d.doubleValue());
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(Long l) {
        if (l == null) {
            return JSONSchema.SUCCESS;
        }
        return validate(l.longValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0077, code lost:
    
        if (r7 == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        r8 = "exclusiveMaximum not match, expect < %s, but %s";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
    
        return new com.alibaba.fastjson2.schema.ValidateResult(false, r8, r4, java.lang.Long.valueOf(r11));
     */
    @Override // com.alibaba.fastjson2.schema.JSONSchema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.fastjson2.schema.ValidateResult validate(long r11) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.schema.NumberSchema.validate(long):com.alibaba.fastjson2.schema.ValidateResult");
    }

    @Override // com.alibaba.fastjson2.schema.JSONSchema
    public ValidateResult validate(double d) {
        BigDecimal bigDecimal = this.minimum;
        if (bigDecimal != null) {
            long j = this.minimumLongValue;
            if (j != Long.MIN_VALUE) {
                boolean z = this.exclusiveMinimum;
                double d2 = j;
                if (!z ? d < d2 : d <= d2) {
                    return new ValidateResult(false, z ? "exclusiveMinimum not match, expect > %s, but %s" : "minimum not match, expect >= %s, but %s", bigDecimal, Double.valueOf(d));
                }
            } else {
                double dDoubleValue = bigDecimal.doubleValue();
                boolean z2 = this.exclusiveMinimum;
                if (!z2 ? d < dDoubleValue : d <= dDoubleValue) {
                    return new ValidateResult(false, z2 ? "exclusiveMinimum not match, expect > %s, but %s" : "minimum not match, expect >= %s, but %s", this.minimum, Double.valueOf(d));
                }
            }
        }
        BigDecimal bigDecimal2 = this.maximum;
        if (bigDecimal2 != null) {
            long j2 = this.maximumLongValue;
            if (j2 != Long.MIN_VALUE) {
                boolean z3 = this.exclusiveMaximum;
                double d3 = j2;
                if (!z3 ? d > d3 : d >= d3) {
                    return new ValidateResult(false, z3 ? "exclusiveMaximum not match, expect < %s, but %s" : "maximum not match, expect <= %s, but %s", bigDecimal2, Double.valueOf(d));
                }
            } else {
                double dDoubleValue2 = bigDecimal2.doubleValue();
                boolean z4 = this.exclusiveMaximum;
                if (!z4 ? d > dDoubleValue2 : d >= dDoubleValue2) {
                    return new ValidateResult(false, z4 ? "exclusiveMaximum not match, expect < %s, but %s" : "maximum not match, expect <= %s, but %s", this.maximum, Double.valueOf(d));
                }
            }
        }
        BigDecimal bigDecimal3 = this.multipleOf;
        if (bigDecimal3 != null) {
            long j3 = this.multipleOfLongValue;
            if (j3 != Long.MIN_VALUE && d % j3 != 0.0d) {
                return new ValidateResult(false, "multipleOf not match, expect multipleOf %s, but %s", bigDecimal3, Double.valueOf(d));
            }
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(d);
            if (bigDecimalValueOf.divideAndRemainder(this.multipleOf)[1].abs().compareTo(BigDecimal.ZERO) > 0) {
                return new ValidateResult(false, "multipleOf not match, expect multipleOf %s, but %s", this.multipleOf, bigDecimalValueOf);
            }
        }
        return JSONSchema.SUCCESS;
    }
}
