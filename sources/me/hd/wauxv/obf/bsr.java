package me.hd.wauxv.obf;

import android.util.Xml;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsr {
    public static final DecimalFormat a = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    public JSONObject b;
    public HashSet c;
    public HashSet d;

    public static void e(XmlSerializer xmlSerializer, coj cojVar) throws IOException {
        String str = cojVar.a;
        if (str != null) {
            xmlSerializer.startTag("", str);
            for (coh cohVar : cojVar.d) {
                xmlSerializer.attribute("", cohVar.a, cohVar.b);
            }
            String str2 = cojVar.c;
            if (str2 != null) {
                xmlSerializer.text(str2);
            }
        }
        Iterator it = cojVar.e.iterator();
        while (it.hasNext()) {
            e(xmlSerializer, (coj) it.next());
        }
        if (str != null) {
            xmlSerializer.endTag("", str);
        }
    }

    public final void f(coj cojVar, String str, JSONArray jSONArray) {
        int length = jSONArray.length();
        String str2 = cojVar.b + "/" + str;
        for (int i = 0; i < length; i++) {
            coj cojVar2 = new coj(str, str2);
            Object objOpt = jSONArray.opt(i);
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    g(cojVar2, (JSONObject) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    f(cojVar2, str, (JSONArray) objOpt);
                } else {
                    String string = objOpt.toString();
                    cojVar2.a = str;
                    cojVar2.c = string;
                }
            }
            cojVar.e.add(cojVar2);
        }
    }

    public final void g(coj cojVar, JSONObject jSONObject) {
        String string;
        ArrayList arrayList = cojVar.e;
        String str = cojVar.b;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    coj cojVar2 = new coj(next, str + "/" + next);
                    arrayList.add(cojVar2);
                    g(cojVar2, (JSONObject) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    f(cojVar, next, (JSONArray) objOpt);
                } else {
                    String str2 = str + "/" + next;
                    if (objOpt instanceof Double) {
                        double dDoubleValue = ((Double) objOpt).doubleValue();
                        if (dDoubleValue % 1.0d == 0.0d) {
                            string = Long.toString((long) dDoubleValue);
                        } else {
                            DecimalFormat decimalFormat = a;
                            if (decimalFormat.getMaximumFractionDigits() == 0) {
                                decimalFormat.setMaximumFractionDigits(20);
                            }
                            string = decimalFormat.format(dDoubleValue);
                        }
                    } else {
                        string = objOpt.toString();
                    }
                    if (this.c.contains(str2)) {
                        ArrayList arrayList2 = cojVar.d;
                        coh cohVar = new coh();
                        cohVar.a = next;
                        cohVar.b = string;
                        arrayList2.add(cohVar);
                    } else if (this.d.contains(str2)) {
                        cojVar.c = string;
                    } else {
                        coj cojVar3 = new coj(next, str);
                        cojVar3.c = string;
                        arrayList.add(cojVar3);
                    }
                }
            }
        }
    }

    public final String toString() {
        coj cojVar = new coj(null, "");
        g(cojVar, this.b);
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
            e(xmlSerializerNewSerializer, cojVar);
            xmlSerializerNewSerializer.endDocument();
            return stringWriter.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
