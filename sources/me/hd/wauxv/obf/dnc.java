package me.hd.wauxv.obf;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Xml;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dnc {
    public static final String a(String str) {
        return dnj.ba(dnr.bo(dnr.bo(dnr.bo(dnr.bo(str, "\r" /* cnb.z(-80706730457898L) */, "" /* cnb.z(-80646600915754L) */), "\n" /* cnb.z(-80659485817642L) */, "" /* cnb.z(-80668075752234L) */), "\t" /* cnb.z(-80663780784938L) */, "" /* cnb.z(-80672370719530L) */), "<?xml version=\"1.0\"?>" /* cnb.z(-80616536144682L) */, "" /* cnb.z(-80573586471722L) */)).toString();
    }

    public static final void b(Context context, String str) {
        Object systemService = context.getSystemService("clipboard" /* cnb.z(-80474802223914L) */);
        bzo.o(systemService, "null cannot be cast to non-null type android.content.ClipboardManager" /* cnb.z(-80449032420138L) */);
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData clipDataNewPlainText = ClipData.newPlainText("label" /* cnb.z(-80680960654122L) */, str);
        if (clipDataNewPlainText != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }

    public static /* synthetic */ void c(String str) {
        bmo.a.getClass();
        b(bmo.n(), str);
    }

    public static final boolean d(String str) {
        if (dnj.ak(str)) {
            return false;
        }
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            while (xmlPullParserNewPullParser.getEventType() != 1) {
                xmlPullParserNewPullParser.next();
            }
            return true;
        } catch (IOException | XmlPullParserException unused) {
            return false;
        }
    }

    public static final JSONObject e(String str) {
        org.json.JSONObject jSONObjectI;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        StringReader stringReader = new StringReader(str);
        ewn ewnVar = new ewn();
        ewnVar.b = new HashSet();
        ewnVar.f = new HashSet();
        new HashSet();
        ewnVar.a = hashSet;
        ewnVar.b = hashSet2;
        ewnVar.c = map;
        ewnVar.d = map2;
        ewnVar.e = map3;
        ewnVar.f = hashSet3;
        ewnVar.g = hashSet4;
        try {
            try {
                dpt dptVar = new dpt("", "xml");
                XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                xmlPullParserFactoryNewInstance.setNamespaceAware(false);
                XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                try {
                    xmlPullParserNewPullParser.setInput(stringReader);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 0; eventType = xmlPullParserNewPullParser.next()) {
                }
                ewnVar.k(dptVar, xmlPullParserNewPullParser);
                stringReader.close();
                jSONObjectI = ewnVar.i(dptVar);
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                jSONObjectI = null;
            }
        } catch (XmlPullParserException e3) {
            e = e3;
            e.printStackTrace();
            jSONObjectI = null;
        }
        ewnVar.h = jSONObjectI;
        JSONObject object = JSON.parseObject(String.valueOf(jSONObjectI));
        f(object);
        return object;
    }

    public static final JSONObject f(JSONObject jSONObject) {
        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (d(str)) {
                    jSONObject.put(key, e(str));
                }
            } else if (value instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) value;
                f(jSONObject2);
                jSONObject.put(key, jSONObject2);
            }
        }
        return jSONObject;
    }

    public static void g(Context context, int i, String str) {
        if ((i & 1) != 0) {
            bmo.a.getClass();
            context = bmo.n();
        }
        ewz.aq(str, new q(context, 10));
    }
}
