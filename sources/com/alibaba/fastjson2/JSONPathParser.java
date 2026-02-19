package com.alibaba.fastjson2;

import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.TypeUtils;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.f;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class JSONPathParser {
    boolean dollar;
    int filterNests;
    JSONPathSegment first;
    final JSONReader jsonReader;
    boolean lax;
    boolean negative;
    final String path;
    JSONPathSegment second;
    int segmentIndex;
    List<JSONPathSegment> segments;
    boolean strict;

    /* JADX INFO: renamed from: com.alibaba.fastjson2.JSONPathParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator;

        static {
            int[] iArr = new int[JSONPathFilter.Operator.values().length];
            $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator = iArr;
            try {
                iArr[JSONPathFilter.Operator.STARTS_WITH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.ENDS_WITH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.REG_MATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.RLIKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.NOT_RLIKE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.NOT_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.CONTAINS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.BETWEEN.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson2$JSONPathFilter$Operator[JSONPathFilter.Operator.NOT_BETWEEN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public JSONPathParser(String str) {
        this.path = str;
        JSONReader jSONReaderOf = JSONReader.of(str, JSONPath.PARSE_CONTEXT);
        this.jsonReader = jSONReaderOf;
        if (jSONReaderOf.ch == 'l' && jSONReaderOf.nextIfMatchIdent('l', 'a', 'x')) {
            this.lax = true;
        } else if (jSONReaderOf.ch == 's' && jSONReaderOf.nextIfMatchIdent(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 'i', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL)) {
            this.strict = true;
        }
        if (jSONReaderOf.ch == '-') {
            jSONReaderOf.next();
            this.negative = true;
        }
        if (jSONReaderOf.ch == '$') {
            jSONReaderOf.next();
            this.dollar = true;
        }
    }

    public static boolean isOperator(char c) {
        return c == '=' || c == '<' || c == '>' || c == '!';
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x0216  */
    /* JADX WARN: Found duplicated region for block: B:122:0x0282  */
    /* JADX WARN: Found duplicated region for block: B:131:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:132:0x01b2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:133:0x01d1 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:65:0x014d  */
    /* JADX WARN: Found duplicated region for block: B:67:0x0159  */
    /* JADX WARN: Found duplicated region for block: B:69:0x0162  */
    /* JADX WARN: Found duplicated region for block: B:71:0x0166  */
    /* JADX WARN: Found duplicated region for block: B:73:0x016e  */
    /* JADX WARN: Found duplicated region for block: B:74:0x017a  */
    /* JADX WARN: Found duplicated region for block: B:76:0x0184  */
    /* JADX WARN: Found duplicated region for block: B:79:0x018d  */
    /* JADX WARN: Found duplicated region for block: B:80:0x0193  */
    /* JADX WARN: Found duplicated region for block: B:83:0x01a2  */
    /* JADX WARN: Found duplicated region for block: B:89:0x01c8  */
    /* JADX WARN: Found duplicated region for block: B:93:0x01dd A[LOOP:3: B:91:0x01d7->B:93:0x01dd, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:96:0x01f8  */
    /* JADX WARN: Found duplicated region for block: B:98:0x0204  */
    /* JADX WARN: Found duplicated region for block: B:99:0x020e  */
    private JSONPathSegment parseArrayAccess() {
        String string;
        ArrayList arrayList;
        JSONPathSegment multiNameSegment;
        int int32Value;
        JSONReader jSONReader;
        boolean zNextIfMatchIdent;
        ArrayList arrayList2;
        int[] iArr;
        this.jsonReader.next();
        JSONReader jSONReader2 = this.jsonReader;
        char c = jSONReader2.ch;
        if (c == '\"') {
            string = jSONReader2.readString();
            if (this.jsonReader.current() == ']') {
                multiNameSegment = new JSONPathSegmentName(string, Fnv.hashCode64(string));
            } else {
                if (this.jsonReader.isString()) {
                    throw new JSONException("TODO : " + this.jsonReader.current());
                }
                arrayList = new ArrayList();
                arrayList.add(string);
                do {
                    arrayList.add(this.jsonReader.readString());
                } while (this.jsonReader.isString());
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                multiNameSegment = new JSONPathSegment.MultiNameSegment(strArr);
            }
        } else if (c != '*') {
            if (c == '-') {
                int32Value = jSONReader2.readInt32Value();
                jSONReader = this.jsonReader;
                if (jSONReader.ch != ':') {
                    jSONReader.next();
                    JSONReader jSONReader3 = this.jsonReader;
                    multiNameSegment = jSONReader3.ch != ']' ? new JSONPathSegment.RangeIndexSegment(int32Value, int32Value >= 0 ? Integer.MAX_VALUE : 0) : new JSONPathSegment.RangeIndexSegment(int32Value, jSONReader3.readInt32Value());
                } else {
                    if (jSONReader.isNumber()) {
                        zNextIfMatchIdent = false;
                    } else {
                        zNextIfMatchIdent = this.jsonReader.nextIfMatchIdent('l', 'a', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL);
                        if (zNextIfMatchIdent) {
                            multiNameSegment = JSONPathSegmentIndex.of(int32Value);
                        }
                    }
                    arrayList2 = new ArrayList();
                    arrayList2.add(Integer.valueOf(int32Value));
                    if (zNextIfMatchIdent) {
                        arrayList2.add(-1);
                        this.jsonReader.nextIfComma();
                    }
                    while (true) {
                        if (this.jsonReader.isNumber()) {
                            arrayList2.add(Integer.valueOf(this.jsonReader.readInt32Value()));
                        } else if (!this.jsonReader.nextIfMatchIdent('l', 'a', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL)) {
                            arrayList2.add(-1);
                            this.jsonReader.nextIfComma();
                        } else {
                            iArr = new int[arrayList2.size()];
                            while (i < arrayList2.size()) {
                                iArr[i] = ((Integer) arrayList2.get(i)).intValue();
                                i++;
                            }
                            multiNameSegment = new JSONPathSegment.MultiIndexSegment(iArr);
                        }
                    }
                }
            } else if (c == '?') {
                jSONReader2.next();
                multiNameSegment = parseFilter();
            } else if (c == 'l') {
                String fieldNameUnquote = jSONReader2.readFieldNameUnquote();
                if (!"last".equals(fieldNameUnquote)) {
                    throw new JSONException(yg.concat("not support : ", fieldNameUnquote));
                }
                multiNameSegment = JSONPathSegmentIndex.of(-1);
            } else if (c == 'r') {
                String fieldNameUnquote2 = jSONReader2.readFieldNameUnquote();
                if (!"randomIndex".equals(fieldNameUnquote2) || !this.jsonReader.nextIfMatch('(') || !this.jsonReader.nextIfMatch(')') || this.jsonReader.ch != ']') {
                    throw new JSONException(yg.concat("not support : ", fieldNameUnquote2));
                }
                multiNameSegment = JSONPathSegment.RandomIndexSegment.INSTANCE;
            } else if (c == '\'') {
                string = jSONReader2.readString();
                if (this.jsonReader.current() == ']') {
                    multiNameSegment = new JSONPathSegmentName(string, Fnv.hashCode64(string));
                } else {
                    if (this.jsonReader.isString()) {
                        throw new JSONException("TODO : " + this.jsonReader.current());
                    }
                    arrayList = new ArrayList();
                    arrayList.add(string);
                    do {
                        arrayList.add(this.jsonReader.readString());
                    } while (this.jsonReader.isString());
                    String[] strArr2 = new String[arrayList.size()];
                    arrayList.toArray(strArr2);
                    multiNameSegment = new JSONPathSegment.MultiNameSegment(strArr2);
                }
            } else if (c != '(') {
                switch (c) {
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        int32Value = jSONReader2.readInt32Value();
                        jSONReader = this.jsonReader;
                        if (jSONReader.ch != ':') {
                            if (jSONReader.isNumber()) {
                                zNextIfMatchIdent = this.jsonReader.nextIfMatchIdent('l', 'a', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL);
                                if (zNextIfMatchIdent) {
                                    multiNameSegment = JSONPathSegmentIndex.of(int32Value);
                                    break;
                                }
                            } else {
                                zNextIfMatchIdent = false;
                            }
                            arrayList2 = new ArrayList();
                            arrayList2.add(Integer.valueOf(int32Value));
                            if (zNextIfMatchIdent) {
                                arrayList2.add(-1);
                                this.jsonReader.nextIfComma();
                            }
                            while (true) {
                                if (this.jsonReader.isNumber()) {
                                    arrayList2.add(Integer.valueOf(this.jsonReader.readInt32Value()));
                                } else if (!this.jsonReader.nextIfMatchIdent('l', 'a', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL)) {
                                    iArr = new int[arrayList2.size()];
                                    while (i < arrayList2.size()) {
                                        iArr[i] = ((Integer) arrayList2.get(i)).intValue();
                                        i++;
                                    }
                                    multiNameSegment = new JSONPathSegment.MultiIndexSegment(iArr);
                                } else {
                                    arrayList2.add(-1);
                                    this.jsonReader.nextIfComma();
                                }
                            }
                        } else {
                            jSONReader.next();
                            JSONReader jSONReader32 = this.jsonReader;
                            if (jSONReader32.ch != ']') {
                            }
                        }
                        break;
                    case ':':
                        jSONReader2.next();
                        JSONReader jSONReader4 = this.jsonReader;
                        int int32Value2 = jSONReader4.ch == ']' ? 0 : jSONReader4.readInt32Value();
                        multiNameSegment = int32Value2 <= 0 ? new JSONPathSegment.RangeIndexSegment(Integer.MIN_VALUE, int32Value2) : new JSONPathSegment.RangeIndexSegment(0, int32Value2);
                        break;
                    default:
                        throw new JSONException("TODO : " + this.jsonReader.current());
                }
            } else {
                jSONReader2.next();
                if (!this.jsonReader.nextIfMatch('@') || !this.jsonReader.nextIfMatch(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)) {
                    throw new JSONException("not support : " + this.path);
                }
                String fieldNameUnquote3 = this.jsonReader.readFieldNameUnquote();
                fieldNameUnquote3.getClass();
                if (!fieldNameUnquote3.equals("length") && !fieldNameUnquote3.equals("size")) {
                    throw new JSONException("not support : " + this.path);
                }
                int int32Value3 = this.jsonReader.readInt32Value();
                if (!this.jsonReader.nextIfMatch(')')) {
                    throw new JSONException("not support : ".concat(fieldNameUnquote3));
                }
                if (int32Value3 > 0) {
                    throw new JSONException("not support : ".concat(fieldNameUnquote3));
                }
                multiNameSegment = JSONPathSegmentIndex.of(int32Value3);
            }
        } else {
            jSONReader2.next();
            multiNameSegment = JSONPathSegment.AllSegment.INSTANCE_ARRAY;
        }
        while (true) {
            char c2 = this.jsonReader.ch;
            if (c2 != '&' && c2 != '|' && c2 != 'a' && c2 != 'o') {
                while (this.filterNests > 0) {
                    this.jsonReader.next();
                    this.filterNests--;
                }
                if (this.jsonReader.nextIfArrayEnd()) {
                    return multiNameSegment;
                }
                throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
            }
            this.filterNests--;
            multiNameSegment = parseFilterRest(multiNameSegment);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private JSONPathSegment parseProperty() {
        JSONPathSegment jSONPathFunction;
        JSONPathFunction jSONPathFunction2;
        Number numberValueOf;
        BigDecimal bigDecimalStripTrailingZeros;
        BigInteger bigIntegerUnscaledValue;
        int length;
        JSONReader jSONReader = this.jsonReader;
        char c = jSONReader.ch;
        if (c == '*') {
            jSONReader.next();
            return JSONPathSegment.AllSegment.INSTANCE;
        }
        if (c == '.') {
            jSONReader.next();
            JSONReader jSONReader2 = this.jsonReader;
            if (jSONReader2.ch != '*') {
                return new JSONPathSegment.CycleNameSegment(this.jsonReader.getFieldName(), jSONReader2.readFieldNameHashCodeUnquote());
            }
            jSONReader2.next();
            return new JSONPathSegment.CycleNameSegment("*", Fnv.hashCode64("*"));
        }
        boolean zIsNumber = jSONReader.isNumber();
        long fieldNameHashCodeUnquote = this.jsonReader.readFieldNameHashCodeUnquote();
        String fieldName = this.jsonReader.getFieldName();
        byte b = 9;
        if (zIsNumber && (length = fieldName.length()) <= 9) {
            for (int i = 0; i < length; i++) {
                char cCharAt = fieldName.charAt(i);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
            }
        }
        JSONReader jSONReader3 = this.jsonReader;
        if (jSONReader3.ch != '(') {
            return new JSONPathSegmentName(fieldName, fieldNameHashCodeUnquote);
        }
        jSONReader3.next();
        fieldName.getClass();
        switch (fieldName.hashCode()) {
            case -2093674864:
                b = fieldName.equals("entrySet") ? (byte) 0 : (byte) -1;
                break;
            case -1325958191:
                b = fieldName.equals("double") ? (byte) 1 : (byte) -1;
                break;
            case -1106363674:
                b = fieldName.equals("length") ? (byte) 2 : (byte) -1;
                break;
            case -823812830:
                b = fieldName.equals("values") ? (byte) 3 : (byte) -1;
                break;
            case 96370:
                b = fieldName.equals("abs") ? (byte) 4 : (byte) -1;
                break;
            case 107876:
                b = fieldName.equals("max") ? (byte) 5 : (byte) -1;
                break;
            case 108114:
                b = fieldName.equals("min") ? (byte) 6 : (byte) -1;
                break;
            case 114251:
                b = fieldName.equals("sum") ? (byte) 7 : (byte) -1;
                break;
            case 3049733:
                b = fieldName.equals("ceil") ? (byte) 8 : (byte) -1;
                break;
            case 3288564:
                if (!fieldName.equals("keys")) {
                    b = -1;
                }
                break;
            case 3314326:
                b = fieldName.equals("last") ? (byte) 10 : (byte) -1;
                break;
            case 3530753:
                b = fieldName.equals("size") ? (byte) 11 : (byte) -1;
                break;
            case 3568674:
                b = fieldName.equals("trim") ? (byte) 12 : (byte) -1;
                break;
            case 3575610:
                b = fieldName.equals(f.y) ? dn.k : (byte) -1;
                break;
            case 97440432:
                b = fieldName.equals("first") ? dn.l : (byte) -1;
                break;
            case 97526796:
                b = fieldName.equals("floor") ? dn.m : (byte) -1;
                break;
            case 100346066:
                b = fieldName.equals(com.umeng.ccg.a.H) ? (byte) 16 : (byte) -1;
                break;
            case 103164673:
                b = fieldName.equals("lower") ? (byte) 17 : (byte) -1;
                break;
            case 111499426:
                b = fieldName.equals("upper") ? (byte) 18 : (byte) -1;
                break;
            case 660387005:
                b = fieldName.equals("ceiling") ? (byte) 19 : (byte) -1;
                break;
            case 921111605:
                b = fieldName.equals("negative") ? (byte) 20 : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                jSONPathFunction = JSONPathSegment.EntrySetSegment.INSTANCE;
                break;
            case 1:
                jSONPathFunction = JSONPathFunction.FUNC_DOUBLE;
                break;
            case 2:
            case 11:
                jSONPathFunction = JSONPathSegment.LengthSegment.INSTANCE;
                break;
            case 3:
                jSONPathFunction = JSONPathSegment.ValuesSegment.INSTANCE;
                break;
            case 4:
                jSONPathFunction = JSONPathFunction.FUNC_ABS;
                break;
            case 5:
                jSONPathFunction = JSONPathSegment.MaxSegment.INSTANCE;
                break;
            case 6:
                jSONPathFunction = JSONPathSegment.MinSegment.INSTANCE;
                break;
            case 7:
                jSONPathFunction = JSONPathSegment.SumSegment.INSTANCE;
                break;
            case 8:
            case 19:
                jSONPathFunction = JSONPathFunction.FUNC_CEIL;
                break;
            case 9:
                jSONPathFunction = JSONPathSegment.KeysSegment.INSTANCE;
                break;
            case 10:
                jSONPathFunction = JSONPathFunction.FUNC_LAST;
                break;
            case 12:
                jSONPathFunction = JSONPathFunction.FUNC_TRIM;
                break;
            case 13:
                jSONPathFunction = JSONPathFunction.FUNC_TYPE;
                break;
            case 14:
                jSONPathFunction = JSONPathFunction.FUNC_FIRST;
                break;
            case 15:
                jSONPathFunction = JSONPathFunction.FUNC_FLOOR;
                break;
            case 16:
                if (!this.jsonReader.isNumber()) {
                    if (this.jsonReader.isString()) {
                        jSONPathFunction2 = new JSONPathFunction(new JSONPathFunction.IndexString(this.jsonReader.readString()));
                        jSONPathFunction = jSONPathFunction2;
                        break;
                    }
                    throw new JSONException("not support syntax, path : " + this.path);
                }
                Number number = this.jsonReader.readNumber();
                if (number instanceof BigDecimal) {
                    BigDecimal bigDecimal = (BigDecimal) number;
                    if (bigDecimal.signum() == 0) {
                        numberValueOf = number;
                        bigDecimalStripTrailingZeros = new BigDecimal(BigInteger.ZERO, 0);
                    } else {
                        numberValueOf = number;
                        bigDecimalStripTrailingZeros = bigDecimal.stripTrailingZeros();
                    }
                    if (bigDecimalStripTrailingZeros.scale() != 0) {
                        jSONPathFunction2 = new JSONPathFunction(new JSONPathFunction.IndexDecimal(bigDecimalStripTrailingZeros));
                        jSONPathFunction = jSONPathFunction2;
                    } else {
                        bigIntegerUnscaledValue = bigDecimalStripTrailingZeros.unscaledValue();
                        if (bigIntegerUnscaledValue.compareTo(TypeUtils.BIGINT_INT64_MIN) >= 0 && bigIntegerUnscaledValue.compareTo(TypeUtils.BIGINT_INT64_MAX) <= 0) {
                            numberValueOf = bigIntegerUnscaledValue;
                            numberValueOf = bigIntegerUnscaledValue;
                            numberValueOf = Long.valueOf(bigIntegerUnscaledValue.longValue());
                        }
                    }
                    break;
                }
                numberValueOf = bigIntegerUnscaledValue;
                numberValueOf = bigIntegerUnscaledValue;
                numberValueOf = bigIntegerUnscaledValue;
                numberValueOf = number;
                if ((numberValueOf instanceof Integer) || (numberValueOf instanceof Long)) {
                    jSONPathFunction = new JSONPathFunction(new JSONPathFunction.IndexInt(numberValueOf.longValue()));
                    break;
                }
                throw new JSONException("not support syntax, path : " + this.path);
            case 17:
                jSONPathFunction = JSONPathFunction.FUNC_LOWER;
                break;
            case 18:
                jSONPathFunction = JSONPathFunction.FUNC_UPPER;
                break;
            case 20:
                jSONPathFunction = JSONPathFunction.FUNC_NEGATIVE;
                break;
            default:
                throw new JSONException("not support syntax, path : " + this.path);
        }
        if (this.jsonReader.nextIfMatch(')')) {
            return jSONPathFunction;
        }
        throw new JSONException("not support syntax, path : " + this.path);
    }

    public JSONPath parse(JSONPath.Feature... featureArr) {
        char c;
        char c2;
        char c3;
        JSONPathSegment filter;
        int i;
        if (this.dollar && this.jsonReader.ch == 26) {
            return this.negative ? new JSONPathSingle(JSONPathFunction.FUNC_NEGATIVE, this.path, new JSONPath.Feature[0]) : JSONPath.RootPath.INSTANCE;
        }
        JSONReader jSONReader = this.jsonReader;
        if (jSONReader.ch == 'e') {
            c = 'a';
            c2 = '.';
            c3 = '@';
            if (jSONReader.nextIfMatchIdent('e', 'x', 'i', Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL)) {
                if (!this.jsonReader.nextIfMatch('(')) {
                    throw new JSONException("syntax error " + this.path);
                }
                JSONReader jSONReader2 = this.jsonReader;
                if (jSONReader2.ch == '@') {
                    jSONReader2.next();
                    if (!this.jsonReader.nextIfMatch(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)) {
                        throw new JSONException("syntax error " + this.path);
                    }
                }
                char c4 = this.jsonReader.ch;
                if ((c4 < 'a' || c4 > 'z') && !((c4 >= 'A' && c4 <= 'Z') || c4 == '_' || c4 == '@' || Character.isIdeographic(c4))) {
                    throw new JSONException("syntax error " + this.path);
                }
                JSONPathSegment property = parseProperty();
                if (this.jsonReader.nextIfMatch(')')) {
                    return new JSONPathTwoSegment(this.path, property, JSONPathFunction.FUNC_EXISTS, new JSONPath.Feature[0]);
                }
                throw new JSONException("syntax error " + this.path);
            }
        } else {
            c = 'a';
            c2 = '.';
            c3 = '@';
        }
        while (true) {
            JSONReader jSONReader3 = this.jsonReader;
            char c5 = jSONReader3.ch;
            if (c5 == 26) {
                if (this.negative) {
                    int i2 = this.segmentIndex;
                    if (i2 == 1) {
                        this.second = JSONPathFunction.FUNC_NEGATIVE;
                    } else if (i2 == 2) {
                        ArrayList arrayList = new ArrayList();
                        this.segments = arrayList;
                        arrayList.add(this.first);
                        this.segments.add(this.second);
                        this.segments.add(JSONPathFunction.FUNC_NEGATIVE);
                    } else {
                        this.segments.add(JSONPathFunction.FUNC_NEGATIVE);
                    }
                    this.segmentIndex++;
                }
                int i3 = this.segmentIndex;
                if (i3 != 1) {
                    return i3 == 2 ? new JSONPathTwoSegment(this.path, this.first, this.second, featureArr) : new JSONPathMulti(this.path, this.segments, featureArr);
                }
                JSONPathSegment jSONPathSegment = this.first;
                if (jSONPathSegment instanceof JSONPathSegmentName) {
                    return new JSONPathSingleName(this.path, (JSONPathSegmentName) this.first, featureArr);
                }
                if (jSONPathSegment instanceof JSONPathSegmentIndex) {
                    JSONPathSegmentIndex jSONPathSegmentIndex = (JSONPathSegmentIndex) jSONPathSegment;
                    if (jSONPathSegmentIndex.index >= 0) {
                        return new JSONPathSingleIndex(this.path, jSONPathSegmentIndex, featureArr);
                    }
                }
                return new JSONPathSingle(this.first, this.path, featureArr);
            }
            if (c5 == c2) {
                jSONReader3.next();
                filter = parseProperty();
            } else if (c5 == '[') {
                filter = parseArrayAccess();
            } else if ((c5 >= c && c5 <= 'z') || ((c5 >= 'A' && c5 <= 'Z') || c5 == '_' || Character.isIdeographic(c5))) {
                filter = parseProperty();
            } else if (c5 == '?') {
                if (this.dollar && (i = this.segmentIndex) == 0) {
                    this.first = JSONPathSegment.RootSegment.INSTANCE;
                    this.segmentIndex = i + 1;
                }
                this.jsonReader.next();
                filter = parseFilter();
            } else {
                if (c5 != c3) {
                    throw new JSONException("not support " + c5);
                }
                this.jsonReader.next();
                filter = JSONPathSegment.SelfSegment.INSTANCE;
            }
            int i4 = this.segmentIndex;
            if (i4 == 0) {
                this.first = filter;
            } else if (i4 == 1) {
                this.second = filter;
            } else if (i4 == 2) {
                ArrayList arrayList2 = new ArrayList();
                this.segments = arrayList2;
                arrayList2.add(this.first);
                this.segments.add(this.second);
                this.segments.add(filter);
            } else {
                this.segments.add(filter);
            }
            this.segmentIndex++;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0369, code lost:
    
        if (r12 != '&') goto L201;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Found duplicated region for block: B:208:0x0389  */
    /* JADX WARN: Found duplicated region for block: B:229:0x03c9  */
    /* JADX WARN: Found duplicated region for block: B:232:0x03d9  */
    /* JADX WARN: Found duplicated region for block: B:279:0x048a  */
    /* JADX WARN: Found duplicated region for block: B:293:0x050d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r28v0 */
    /* JADX WARN: Type inference failed for: r28v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r2v184 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r36v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r36v2 */
    /* JADX WARN: Type inference failed for: r36v3 */
    /* JADX WARN: Type inference failed for: r36v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r36v5 */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r39v0 */
    /* JADX WARN: Type inference failed for: r39v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r39v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.alibaba.fastjson2.JSONPathSegment parseFilter() {
        /*
            Method dump skipped, instruction units count: 2534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson2.JSONPathParser.parseFilter():com.alibaba.fastjson2.JSONPathSegment");
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Found duplicated region for block: B:24:0x0060  */
    /* JADX WARN: Found duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0077  */
    public JSONPathSegment parseFilterRest(JSONPathSegment jSONPathSegment) {
        String fieldNameUnquote;
        String fieldNameUnquote2;
        JSONReader jSONReader = this.jsonReader;
        char c = jSONReader.ch;
        boolean z = true;
        if (c == '&') {
            jSONReader.next();
            if (!this.jsonReader.nextIfMatch('&')) {
                throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
            }
        } else if (c == 'A') {
            fieldNameUnquote = jSONReader.readFieldNameUnquote();
            if (!"and".equalsIgnoreCase(fieldNameUnquote)) {
                throw new JSONException(yg.concat("syntax error : ", fieldNameUnquote));
            }
        } else {
            if (c == 'O') {
                fieldNameUnquote2 = jSONReader.readFieldNameUnquote();
                if (!"or".equalsIgnoreCase(fieldNameUnquote2)) {
                    throw new JSONException(yg.concat("syntax error : ", fieldNameUnquote2));
                }
            } else if (c == 'a') {
                fieldNameUnquote = jSONReader.readFieldNameUnquote();
                if (!"and".equalsIgnoreCase(fieldNameUnquote)) {
                    throw new JSONException(yg.concat("syntax error : ", fieldNameUnquote));
                }
            } else if (c == 'o') {
                fieldNameUnquote2 = jSONReader.readFieldNameUnquote();
                if (!"or".equalsIgnoreCase(fieldNameUnquote2)) {
                    throw new JSONException(yg.concat("syntax error : ", fieldNameUnquote2));
                }
            } else {
                if (c != '|') {
                    throw new JSONException("TODO : " + this.jsonReader.ch);
                }
                jSONReader.next();
                if (!this.jsonReader.nextIfMatch('|')) {
                    throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
                }
            }
            z = false;
        }
        JSONPathSegment filter = parseFilter();
        if (jSONPathSegment instanceof JSONPathFilter.GroupFilter) {
            JSONPathFilter.GroupFilter groupFilter = (JSONPathFilter.GroupFilter) jSONPathSegment;
            groupFilter.filters.add(((JSONPathFilter) filter).setAnd(z));
            return groupFilter;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add((JSONPathFilter) jSONPathSegment);
        if (filter instanceof JSONPathFilter.GroupFilter) {
            List<JSONPathFilter> list = ((JSONPathFilter.GroupFilter) filter).filters;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    JSONPathFilter jSONPathFilter = list.get(i);
                    if (i == 0) {
                        jSONPathFilter.setAnd(z);
                    }
                    arrayList.add(jSONPathFilter);
                }
            }
        } else {
            arrayList.add(((JSONPathFilter) filter).setAnd(z));
        }
        return new JSONPathFilter.GroupFilter(arrayList);
    }

    public JSONPathSegment parseSegment() {
        Object string;
        if (this.jsonReader.nextIfMatch('@')) {
            if (this.jsonReader.nextIfMatch(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)) {
                string = this.jsonReader.isNumber() ? this.jsonReader.readNumber() : this.jsonReader.readFieldNameUnquote();
            } else if (this.jsonReader.nextIfArrayStart()) {
                if (this.jsonReader.isNumber()) {
                    string = this.jsonReader.readNumber();
                } else {
                    if (!this.jsonReader.isString()) {
                        throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
                    }
                    string = this.jsonReader.readString();
                }
                if (!this.jsonReader.nextIfArrayEnd()) {
                    throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
                }
            } else {
                string = null;
            }
            if (string instanceof String) {
                String str = (String) string;
                return new JSONPathSegmentName(str, Fnv.hashCode64(str));
            }
            if (string instanceof Integer) {
                return new JSONPathSegmentIndex(((Integer) string).intValue());
            }
        }
        throw new JSONException(this.jsonReader.info("jsonpath syntax error"));
    }
}
