package me.hd.wauxv.obf;

import android.content.ContentValues;
import com.alibaba.fastjson2.JSONObject;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cra extends bws implements IDatabaseOperationsListener {
    public static final cra a = new cra();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void s(String str, ContentValues contentValues) throws IOException {
        if (str.equals("fmessage_msginfo" /* cnb.z(-396747603966762L) */)) {
            Object obj = contentValues.get("isSend" /* cnb.z(-396073294101290L) */);
            throwIfVar1IsNull(obj, "null cannot be cast to non-null type kotlin.Int" /* cnb.z(-396094768937770L) */);
            if (((Integer) obj).intValue() == 0) {
                Object obj2 = contentValues.get("msgContent" /* cnb.z(-395888610507562L) */);
                throwIfVar1IsNull(obj2, "null cannot be cast to non-null type kotlin.String" /*
                                                                                              * cnb.z(-396356761942826L)
                                                                                              */);
                JSONObject jSONObjectE = dnc.e((String) obj2);
                Object byPath = jSONObjectE.getByPath("msg.fromusername" /* cnb.z(-396154898479914L) */);
                throwIfVar1IsNull(byPath, "null cannot be cast to non-null type kotlin.String" /*
                                                                                                * cnb.z(-
                                                                                                * 397748331346730L)
                                                                                                */);
                String str2 = (String) byPath;
                Object byPath2 = jSONObjectE.getByPath("msg.ticket" /* cnb.z(-397477748407082L) */);
                throwIfVar1IsNull(byPath2, "null cannot be cast to non-null type kotlin.String" /*
                                                                                                 * cnb.z(-
                                                                                                 * 398014619319082L)
                                                                                                 */);
                String str3 = (String) byPath2;
                Object byPath3 = jSONObjectE.getByPath("msg.scene" /* cnb.z(-397812755856170L) */);
                throwIfVar1IsNull(byPath3, "null cannot be cast to non-null type kotlin.String" /*
                                                                                                 * cnb.z(-
                                                                                                 * 397168510761770L)
                                                                                                 */);
                int i = Integer.parseInt((String) byPath3);
                for (ctx ctxVar : cuk.a) {
                    ctxVar.getClass();
                    ctxVar.n("onNewFriend" /* cnb.z(-402374011124522L) */, str2, str3, Integer.valueOf(i));
                }
            }
        }
    }
}
