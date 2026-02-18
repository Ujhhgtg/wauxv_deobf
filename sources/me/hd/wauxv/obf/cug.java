package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.info.FriendInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cug implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cug(Object obj, long j, int i) {
        this.a = i;
        this.c = obj;
        this.b = j;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        StringBuilder sb;
        switch (this.a) {
            case 0:
                Map map = (Map) this.c;
                eoj eojVar = (eoj) obj;
                eojVar.g(new cuf(this.b, 1));
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        bzo.q(str, "name");
                        bzo.q(str2, "value");
                        eojVar.d.addHeader(str, str2);
                    }
                }
                break;
            default:
                diz dizVar = (diz) this.c;
                ael aelVar = (ael) obj;
                aelVar.f = "搜索好友" /* cnb.z(-534916701879082L) */;
                String strZ = "好友" /* cnb.z(-534946766650154L) */;
                ArrayList arrayListS = bmy.s();
                ArrayList arrayList = new ArrayList(abb.ak(arrayListS, 10));
                Iterator it = arrayListS.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    final long j = this.b;
                    if (!zHasNext) {
                        aelVar.m(strZ, arrayList);
                        aelVar.g = R.drawable.ic_contact_confirm_24dp;
                        String strZ2 = "点赞" /* cnb.z(-535311838870314L) */;
                        bgj bgjVar = new bgj() { // from class: me.hd.wauxv.obf.dix
                            @Override // me.hd.wauxv.obf.bgj
                            public final Object g(Object obj2, Object obj3) {
                                long j2;
                                List list = (List) obj2;
                                ArrayList arrayList2 = new ArrayList(abb.ak(list, 10));
                                Iterator it2 = list.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(((adx) it2.next()).a);
                                }
                                Set setAd = aaz.ad(arrayList2);
                                diy diyVar = diy.a;
                                Set setN = diyVar.n();
                                ArrayList arrayList3 = new ArrayList();
                                Iterator it3 = setN.iterator();
                                while (true) {
                                    boolean zHasNext2 = it3.hasNext();
                                    j2 = j;
                                    if (!zHasNext2) {
                                        break;
                                    }
                                    Object next = it3.next();
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(j2);
                                    sb2.append('|');
                                    if (!dnr.bp((String) next, sb2.toString(), false)) {
                                        arrayList3.add(next);
                                    }
                                }
                                LinkedHashSet linkedHashSet = new LinkedHashSet(arrayList3);
                                if (!setAd.isEmpty()) {
                                    linkedHashSet.add(j2 + '|' + aaz.k(setAd, ";" /* cnb.z(-535264594230058L) */, null, null, null, 62));
                                }
                                diyVar.t(linkedHashSet);
                                dnc.g(null, 3, "已点赞" /* cnb.z(-535273184164650L) */);
                                return Boolean.FALSE;
                            }
                        };
                        aelVar.j = strZ2;
                        aelVar.l = bgjVar;
                    } else {
                        FriendInfo friendInfo = (FriendInfo) it.next();
                        String wxid = friendInfo.getWxid();
                        StringBuilder sb2 = new StringBuilder();
                        String nickname = friendInfo.getNickname();
                        if ((dfv.d(dap.b(new dap("\r\n|\r|\n" /* cnb.z(-535432097954602L) */), nickname)) > 3 ? nickname : null) != null) {
                            sb2.append("已过滤此昵称..." /* cnb.z(-535402033183530L) */);
                        } else {
                            String str3 = nickname.length() > 8 ? nickname : null;
                            if (str3 != null) {
                                String strSubstring = str3.substring(0, 8);
                                bzo.p(strSubstring, "substring(...)" /* cnb.z(-535376263379754L) */);
                                sb2.append(strSubstring);
                                sb2.append("..." /* cnb.z(-535294659001130L) */);
                                sb = sb2;
                            } else {
                                sb = null;
                            }
                            if (sb == null) {
                                sb2.append(nickname);
                            }
                        }
                        String remark = friendInfo.getRemark();
                        String str4 = remark.length() > 0 ? remark : null;
                        if (str4 != null) {
                            sb2.append("(" + str4 + ')');
                        }
                        String string = sb2.toString();
                        String wxid2 = friendInfo.getWxid();
                        dizVar.getClass();
                        arrayList.add(new adx(wxid, string, wxid2, diz.m(j).contains(friendInfo.getWxid())));
                    }
                    break;
                }
                break;
        }
        return ens.a;
    }
}
