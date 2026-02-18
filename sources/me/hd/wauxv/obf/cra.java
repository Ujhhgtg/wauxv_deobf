package me.hd.wauxv.obf;

import android.content.ContentValues;
import com.alibaba.fastjson2.JSONObject;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cra extends bws implements bob {
    public static final cra a = new cra();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bob
    public final void s(String str, ContentValues contentValues) throws IOException {
        if (str.equals(cnb.z(-396747603966762L))) {
            Object obj = contentValues.get(cnb.z(-396073294101290L));
            bzo.o(obj, cnb.z(-396094768937770L));
            if (((Integer) obj).intValue() == 0) {
                Object obj2 = contentValues.get(cnb.z(-395888610507562L));
                bzo.o(obj2, cnb.z(-396356761942826L));
                JSONObject jSONObjectE = dnc.e((String) obj2);
                Object byPath = jSONObjectE.getByPath(cnb.z(-396154898479914L));
                bzo.o(byPath, cnb.z(-397748331346730L));
                String str2 = (String) byPath;
                Object byPath2 = jSONObjectE.getByPath(cnb.z(-397477748407082L));
                bzo.o(byPath2, cnb.z(-398014619319082L));
                String str3 = (String) byPath2;
                Object byPath3 = jSONObjectE.getByPath(cnb.z(-397812755856170L));
                bzo.o(byPath3, cnb.z(-397168510761770L));
                int i = Integer.parseInt((String) byPath3);
                for (ctx ctxVar : cuk.a) {
                    ctxVar.getClass();
                    ctxVar.n(cnb.z(-402374011124522L), str2, str3, Integer.valueOf(i));
                }
            }
        }
    }
}
