package com.alibaba.fastjson2;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import me.hd.wauxv.obf.bgf;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.uj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class JSONKt {
    public static final <T> T into(InputStream inputStream, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final boolean isJSONArray(String str) {
        return JSON.isValidArray(str);
    }

    public static final boolean isJSONObject(String str) {
        return JSON.isValidObject(str);
    }

    /* JADX INFO: renamed from: parseArray, reason: collision with other method in class */
    public static final <T> List<T> m4parseArray(String str) {
        bzo.aq();
        throw null;
    }

    /* JADX INFO: renamed from: parseObject, reason: collision with other method in class */
    public static final <T> T m5parseObject(String str) {
        bzo.aq();
        throw null;
    }

    public static Object parseObject$default(byte[] bArr, int i, int i2, Charset charset, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            int length = bArr.length;
        }
        if ((i3 & 4) != 0) {
            charset = uj.a;
        }
        bzo.q(bArr, "<this>");
        bzo.q(charset, "charset");
        bzo.aq();
        throw null;
    }

    public static final <T> T to(InputStream inputStream, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final byte[] toJSONByteArray(Object obj) {
        return JSON.toJSONBytes(obj);
    }

    public static final String toJSONString(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static final <T> T into(String str) {
        bzo.aq();
        throw null;
    }

    public static final boolean isJSONArray(byte[] bArr) {
        return JSON.isValidArray(bArr);
    }

    public static final boolean isJSONObject(byte[] bArr) {
        return JSON.isValidObject(bArr);
    }

    public static final <T> List<T> parseArray(String str, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final <T> T parseObject(String str, Filter filter, JSONReader.Feature... featureArr) {
        bzo.q(filter, "filter");
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final <T> T to(String str) {
        bzo.aq();
        throw null;
    }

    public static final byte[] toJSONByteArray(Object obj, Filter[] filterArr) {
        bzo.q(filterArr, "filters");
        return JSON.toJSONBytes(obj, filterArr, new JSONWriter.Feature[0]);
    }

    public static final String toJSONString(Object obj, Filter[] filterArr) {
        bzo.q(filterArr, "filters");
        return JSON.toJSONString(obj, filterArr, new JSONWriter.Feature[0]);
    }

    public static final <T> T into(URL url, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final <T> List<T> parseArray(byte[] bArr, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    /* JADX INFO: renamed from: parseObject, reason: collision with other method in class */
    public static final <T> T m6parseObject(String str, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final <T> T to(URL url, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final <T> T into(byte[] bArr) {
        bzo.q(bArr, "<this>");
        bzo.aq();
        throw null;
    }

    public static final JSONArray parseArray(String str) {
        return JSON.parseArray(str);
    }

    /* JADX INFO: renamed from: parseObject, reason: collision with other method in class */
    public static final <T> T m7parseObject(byte[] bArr) {
        bzo.aq();
        throw null;
    }

    public static final <T> T to(byte[] bArr) {
        bzo.aq();
        throw null;
    }

    public static final byte[] toJSONByteArray(Object obj, JSONWriter.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.toJSONBytes(obj, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final String toJSONString(Object obj, JSONWriter.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.toJSONString(obj, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final <T> T parseObject(byte[] bArr, int i, int i2, Charset charset) {
        bzo.q(bArr, "<this>");
        bzo.q(charset, "charset");
        bzo.aq();
        throw null;
    }

    public static void parseObject$default(Reader reader, char c, bgf bgfVar, int i, Object obj) {
        bzo.q(reader, "<this>");
        bzo.q(bgfVar, "consumer");
        bzo.aq();
        throw null;
    }

    public static final <T> T parseObject(byte[] bArr, Filter filter, JSONReader.Feature... featureArr) {
        bzo.q(filter, "filter");
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static final byte[] toJSONByteArray(Object obj, Filter[] filterArr, JSONWriter.Feature... featureArr) {
        bzo.q(filterArr, "filters");
        bzo.q(featureArr, "features");
        return JSON.toJSONBytes(obj, filterArr, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final String toJSONString(Object obj, Filter filter, JSONWriter.Feature... featureArr) {
        bzo.q(filter, "filter");
        bzo.q(featureArr, "features");
        return JSON.toJSONString(obj, filter, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    /* JADX INFO: renamed from: parseObject, reason: collision with other method in class */
    public static final <T> T m8parseObject(byte[] bArr, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        bzo.aq();
        throw null;
    }

    public static void parseObject$default(InputStream inputStream, Charset charset, char c, JSONReader.Feature[] featureArr, bgf bgfVar, int i, Object obj) {
        bzo.q(inputStream, "<this>");
        bzo.q(charset, "charset");
        bzo.q(featureArr, "features");
        bzo.q(bgfVar, "consumer");
        bzo.aq();
        throw null;
    }

    public static final <T> void parseObject(InputStream inputStream, Charset charset, char c, JSONReader.Feature[] featureArr, bgf bgfVar) {
        bzo.q(inputStream, "<this>");
        bzo.q(charset, "charset");
        bzo.q(featureArr, "features");
        bzo.q(bgfVar, "consumer");
        bzo.aq();
        throw null;
    }

    public static final String toJSONString(Object obj, Filter[] filterArr, JSONWriter.Feature... featureArr) {
        bzo.q(filterArr, "filters");
        bzo.q(featureArr, "features");
        return JSON.toJSONString(obj, filterArr, (JSONWriter.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final <T> void parseObject(InputStream inputStream, JSONReader.Feature[] featureArr, bgf bgfVar) {
        bzo.q(inputStream, "<this>");
        bzo.q(featureArr, "features");
        bzo.q(bgfVar, "consumer");
        bzo.aq();
        throw null;
    }

    public static final <T> void parseObject(Reader reader, char c, bgf bgfVar) {
        bzo.q(reader, "<this>");
        bzo.q(bgfVar, "consumer");
        bzo.aq();
        throw null;
    }

    public static final JSONObject parseObject(String str) {
        return JSON.parseObject(str);
    }

    public static final JSONObject parseObject(byte[] bArr) {
        return JSON.parseObject(bArr);
    }

    public static final JSONObject parseObject(String str, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.parseObject(str, (JSONReader.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final JSONObject parseObject(byte[] bArr, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.parseObject(bArr, (JSONReader.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final JSONObject parseObject(Reader reader, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.parseObject(reader, (JSONReader.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }

    public static final JSONObject parseObject(InputStream inputStream, JSONReader.Feature... featureArr) {
        bzo.q(featureArr, "features");
        return JSON.parseObject(inputStream, (JSONReader.Feature[]) Arrays.copyOf(featureArr, featureArr.length));
    }
}
