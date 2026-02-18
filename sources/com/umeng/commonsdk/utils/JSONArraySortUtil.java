package com.umeng.commonsdk.utils;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class JSONArraySortUtil implements Comparator<JSONObject> {
    private String mCompareKey;

    public void setCompareKey(String str) {
        this.mCompareKey = str;
    }

    @Override // java.util.Comparator
    public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            return (int) (jSONObject.getLong(this.mCompareKey) - jSONObject2.getLong(this.mCompareKey));
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
