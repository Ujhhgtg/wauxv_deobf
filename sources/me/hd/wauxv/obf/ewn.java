package me.hd.wauxv.obf;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewn {
    public HashSet a;
    public HashSet b;
    public HashMap c;
    public HashMap d;
    public HashMap e;
    public HashSet f;
    public HashSet g;
    public JSONObject h;

    public final JSONObject i(dpt dptVar) {
        JSONObject jSONObject = new JSONObject();
        if (dptVar.d != null) {
            String str = dptVar.a;
            String str2 = (String) this.d.get(str);
            if (str2 == null) {
                str2 = "content";
            }
            j(str, jSONObject, str2, dptVar.d);
        }
        try {
            HashMap map = new HashMap();
            for (dpt dptVar2 : dptVar.c) {
                String str3 = dptVar2.b;
                ArrayList arrayList = (ArrayList) map.get(str3);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(str3, arrayList);
                }
                arrayList.add(dptVar2);
            }
            for (ArrayList arrayList2 : map.values()) {
                if (arrayList2.size() == 1) {
                    dpt dptVar3 = (dpt) arrayList2.get(0);
                    String str4 = dptVar3.a;
                    String str5 = dptVar3.b;
                    if (!this.a.contains(str4)) {
                        Iterator it = this.b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                if (dptVar3.c.size() <= 0) {
                                    j(dptVar3.a, jSONObject, str5, dptVar3.d);
                                    break;
                                }
                                jSONObject.put(str5, i(dptVar3));
                                break;
                            }
                            if (((Pattern) it.next()).matcher(str4).find()) {
                            }
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(i(dptVar3));
                    jSONObject.put(str5, jSONArray);
                    break;
                }
                JSONArray jSONArray2 = new JSONArray();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(i((dpt) it2.next()));
                }
                jSONObject.put(((dpt) arrayList2.get(0)).b, jSONArray2);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void j(String str, JSONObject jSONObject, String str2, String str3) {
        try {
            Class cls = (Class) this.e.get(str);
            if (cls == null) {
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put(str2, str3);
            } else if (cls == Integer.class) {
                try {
                    jSONObject.put(str2, Integer.valueOf(Integer.parseInt(str3)));
                } catch (NumberFormatException unused) {
                    jSONObject.put(str2, 0);
                }
            } else if (cls == Long.class) {
                try {
                    jSONObject.put(str2, Long.valueOf(Long.parseLong(str3)));
                } catch (NumberFormatException unused2) {
                    jSONObject.put(str2, 0L);
                }
            } else if (cls == Double.class) {
                try {
                    jSONObject.put(str2, Double.valueOf(Double.parseDouble(str3)));
                } catch (NumberFormatException unused3) {
                    jSONObject.put(str2, 0.0d);
                }
            } else if (cls == Boolean.class) {
                if (str3 == null) {
                    jSONObject.put(str2, false);
                } else if (str3.equalsIgnoreCase("true")) {
                    jSONObject.put(str2, true);
                } else if (str3.equalsIgnoreCase("false")) {
                    jSONObject.put(str2, false);
                } else {
                    jSONObject.put(str2, false);
                }
            }
        } catch (JSONException unused4) {
        }
    }

    public final void k(dpt dptVar, XmlPullParser xmlPullParser) {
        int next;
        String str = dptVar.a;
        do {
            try {
                next = xmlPullParser.next();
                if (next == 2) {
                    String name = xmlPullParser.getName();
                    String str2 = str + "/" + name;
                    boolean zContains = this.g.contains(str2);
                    dpt dptVar2 = new dpt(str2, name);
                    if (!zContains) {
                        dptVar.c.add(dptVar2);
                    }
                    int attributeCount = xmlPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        String attributeName = xmlPullParser.getAttributeName(i);
                        String attributeValue = xmlPullParser.getAttributeValue(i);
                        String str3 = str + "/" + dptVar2.b + "/" + attributeName;
                        if (!this.f.contains(str3)) {
                            String str4 = (String) this.c.get(str3);
                            if (str4 != null) {
                                attributeName = str4;
                            }
                            dpt dptVar3 = new dpt(str3, attributeName);
                            dptVar3.e(attributeValue);
                            dptVar2.c.add(dptVar3);
                        }
                    }
                    k(dptVar2, xmlPullParser);
                } else {
                    if (next != 4) {
                        if (next != 3 && next != 1) {
                            Log.i("XmlToJson", "unknown xml eventType " + next);
                        }
                        return;
                    }
                    dptVar.e(xmlPullParser.getText());
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                return;
            } catch (NullPointerException e2) {
                e = e2;
                e.printStackTrace();
                return;
            } catch (XmlPullParserException e3) {
                e = e3;
                e.printStackTrace();
                return;
            }
        } while (next != 1);
    }

    public final String toString() {
        JSONObject jSONObject = this.h;
        if (jSONObject != null) {
            return jSONObject.toString();
        }
        return null;
    }
}
