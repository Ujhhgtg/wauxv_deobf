package me.hd.wauxv.obf;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cic implements bgj {
    public final /* synthetic */ int a;
    public final /* synthetic */ Serializable b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cic(Serializable serializable, Object obj, int i) {
        this.a = i;
        this.b = serializable;
        this.c = obj;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        switch (this.a) {
            case 0:
                String str = (String) this.b;
                ays aysVar = (ays) this.c;
                List list = (List) obj;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arj.ah(((adx) it.next()).a, str, aysVar.a);
                }
                dnc.sendToast(null, 3, "已转发至" /* "已转发至" /* "已转发至" /* "已转发至" /* cnb.z(-475620383390506L)   */ + list.size() + "个会话" /*
                                                                                            * "个会话" /* "个会话" /* "个会话" /* cnb.z(-475581728684842L)  */
                                                                                            */);
                break;
            case 1:
                String str2 = (String) this.b;
                ays aysVar2 = (ays) this.c;
                List list2 = (List) obj;
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arj.ah(((adx) it2.next()).a, str2, aysVar2.a);
                }
                dnc.sendToast(null, 3, "已转发至" /* "已转发至" /* "已转发至" /* "已转发至" /* cnb.z(-476895988677418L)   */ + list2.size() + "个会话" /*
                                                                                             * "个会话" /* "个会话" /* "个会话" /* cnb.z(-476908873579306L)  */
                                                                                             */);
                break;
            default:
                ArrayList arrayList = (ArrayList) this.b;
                ArrayList arrayList2 = (ArrayList) this.c;
                List<adx> list3 = (List) obj;
                for (adx adxVar : list3) {
                    for (Pair pairVar : StaticHelpers5.ae(arrayList, arrayList2)) {
                        arj.ah(adxVar.a, (String) pairVar.first, ((Number) pairVar.second).intValue());
                    }
                }
                dnc.sendToast(null, 3, "已转发" /* "已转发" /* "已转发" /* "已转发" /* cnb.z(-514360988400426L)   */ + arrayList.size()
                        + "条语音至" /* "条语音至" /* "条语音至" /* "条语音至" /* cnb.z(-514309448792874L)   */ + list3.size() + "个会话" /* "个会话" /* "个会话" /* "个会话" /* cnb.z(-513721038273322L)   */);
                break;
        }
        return Boolean.FALSE;
    }
}
