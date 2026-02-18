package me.hd.wauxv.obf;

import java.util.Map;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cue implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ cue(Map map, Object obj, long j, int i) {
        this.a = i;
        this.b = map;
        this.d = obj;
        this.c = j;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        String str;
        switch (this.a) {
            case 0:
                String str2 = (String) this.d;
                eoj eojVar = (eoj) obj;
                eojVar.g(new cuf(this.c, 0));
                Map map = this.b;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str3 = (String) entry.getKey();
                        String str4 = (String) entry.getValue();
                        bzo.q(str3, "name");
                        bzo.q(str4, "value");
                        eojVar.d.addHeader(str3, str4);
                    }
                }
                eojVar.h(str2);
                break;
            default:
                Map map2 = (Map) this.d;
                pq pqVar = (pq) obj;
                pqVar.g(new cuf(this.c, 2));
                Map map3 = this.b;
                if (map3 != null) {
                    for (Map.Entry entry2 : map3.entrySet()) {
                        String str5 = (String) entry2.getKey();
                        String str6 = (String) entry2.getValue();
                        bzo.q(str5, "name");
                        bzo.q(str6, "value");
                        pqVar.d.addHeader(str5, str6);
                    }
                }
                boolean z = false;
                if (map3 != null && (str = (String) map3.get("Content-Type" /* cnb.z(-404031868500778L) */)) != null && dnj.ab(str, "application/json" /* cnb.z(-403958854056746L) */, true)) {
                    z = true;
                }
                if (map2 != null) {
                    if (z) {
                        RequestBody.Companion companion = RequestBody.Companion;
                        String string = new JSONObject(map2).toString();
                        bzo.p(string, "JSONObject(body ?: return).toString()");
                        pqVar.l = companion.create(string, cbb.a);
                    } else {
                        for (Map.Entry entry3 : map2.entrySet()) {
                            String str7 = (String) entry3.getKey();
                            String string2 = ((String) entry3.getValue()).toString();
                            bzo.q(str7, "name");
                            FormBody.Builder builder = pqVar.n;
                            if (string2 != null) {
                                builder.add(str7, string2);
                            }
                        }
                    }
                }
                break;
        }
        return ens.a;
    }
}
