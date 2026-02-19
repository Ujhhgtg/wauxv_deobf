package me.hd.wauxv.plugin.api.method;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.EmptyReadonlyList;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.eog;
import me.hd.wauxv.obf.ewj;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginSnsMethod {
    @cty
    public final void uploadText(String str) {
        Object objC = eog.c(eog.a, ewj.b.h);
        eog.d(objC, str);
        eog.b(objC);
    }

    @cty
    public final void uploadTextAndPicList(String str, List<String> list) throws IllegalAccessException, InvocationTargetException {
        arj.aj(str, list, null, null);
    }

    @cty
    public final void uploadTextAndPicList(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        arj.aj(str, dqc.toSingletonList(str2), null, null);
    }

    @cty
    public final void uploadTextAndPicList(String str, String str2, String str3, String str4) throws IllegalAccessException, InvocationTargetException {
        arj.aj(str, dqc.toSingletonList(str2), str3, str4);
    }

    @cty
    public final void uploadTextAndPicList(String str, List<String> list, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        arj.aj(str, list, str2, str3);
    }

    @cty
    public final void uploadText(String str, String str2, String str3) {
        Object objC = eog.c(eog.a, ewj.b.h);
        eog.d(objC, str);
        if (str2 != null) {
            if (str2.length() == 0) {
                str2 = null;
            }
            if (str2 != null) {
                eog.i(objC, str2);
            }
        }
        if (str3 != null) {
            if (str3.length() == 0) {
                str3 = null;
            }
            if (str3 != null) {
                eog.g(objC, str3);
            }
        }
        eog.b(objC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [me.hd.wauxv.obf.avd] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    @cty
    public final void uploadTextAndPicList(JSONObject jSONObject) throws IllegalAccessException, InvocationTargetException {
        ?? arrayList;
        String strOptString = jSONObject.optString("content" /* "content" /* "content" /* cnb.z(-401321744137002L)  */);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("picPathList" /* "picPathList" /* "picPathList" /* cnb.z(-401287384398634L)  */);
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i));
            }
        } else {
            arrayList = 0;
        }
        if (arrayList == 0) {
            arrayList = EmptyReadonlyList.a;
        }
        arj.aj(strOptString, arrayList, jSONObject.optString("sdkId" /* "sdkId" /* "sdkId" /* cnb.z(-401201485052714L)  */), jSONObject.optString("sdkAppName" /* "sdkAppName" /* "sdkAppName" /* cnb.z(-401158535379754L)  */));
    }

    @cty
    public final void uploadText(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("content" /* "content" /* "content" /* cnb.z(-400862182636330L)  */);
        String strOptString2 = jSONObject.optString("sdkId" /* "sdkId" /* "sdkId" /* cnb.z(-400827822897962L)  */);
        String strOptString3 = jSONObject.optString("sdkAppName" /* "sdkAppName" /* "sdkAppName" /* cnb.z(-400784873225002L)  */);
        Object objC = eog.c(eog.a, ewj.b.h);
        eog.d(objC, strOptString);
        if (strOptString2 != null) {
            if (strOptString2.length() == 0) {
                strOptString2 = null;
            }
            if (strOptString2 != null) {
                eog.i(objC, strOptString2);
            }
        }
        if (strOptString3 != null) {
            if (strOptString3.length() == 0) {
                strOptString3 = null;
            }
            if (strOptString3 != null) {
                eog.g(objC, strOptString3);
            }
        }
        eog.b(objC);
    }
}
