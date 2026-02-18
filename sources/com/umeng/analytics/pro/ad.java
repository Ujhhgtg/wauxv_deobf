package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ad extends ab {
    private String a;
    private String b;

    public ad(String str, ArrayList<ac> arrayList) {
        super(str, arrayList);
        this.a = "";
        this.b = "";
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectA = super.a(str, jSONObject);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put(com.umeng.ccg.a.y, this.a);
                jSONObjectA.put(com.umeng.ccg.a.z, this.b);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectA;
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(String str, JSONObject jSONObject) {
        super.tryGetClassByName(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.z)) {
            d(jSONObject.optString(com.umeng.ccg.a.z));
        }
        if (jSONObject.has(com.umeng.ccg.a.y)) {
            c(jSONObject.optString(com.umeng.ccg.a.y));
        }
    }

    public void c(String str) {
        this.a = str;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }
}
