package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.util.ArrayList;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.info.FriendInfo;
import me.hd.wauxv.data.bean.info.GroupInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cfb implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ cfb(ArrayList arrayList, ArrayList arrayList2, int i) {
        this.a = i;
        this.b = arrayList;
        this.c = arrayList2;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IOException {
        String str;
        StringBuilder sb;
        switch (this.a) {
            case 0:
                cfb cfbVar = new cfb(this.b, this.c, 1);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                cfbVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                break;
            default:
                ael aelVar2 = (ael) obj;
                aelVar2.f = "搜索好友/群聊" /* "搜索好友/群聊" /* "搜索好友/群聊" /* cnb.z(-514120470231850L)  */;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Cursor cursorAb = bmy.ab(new aer[] { aer.a, aer.b });
                if (cursorAb != null) {
                    while (cursorAb.moveToNext()) {
                        try {
                            if (dnr.bi(cursorAb.getString(cursorAb.getColumnIndex("username" /*
                                                                                              * "username" /* "username" /* cnb.z(-514086110493482L)  */
                                                                                              */)), "@chatroom" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 514545671994154L)
                                                                                                                 */)) {
                                GroupInfo groupInfoT = cnb.t(cursorAb);
                                String roomId = groupInfoT.getRoomId();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(groupInfoT.getName());
                                String remark = groupInfoT.getRemark();
                                str = remark.length() > 0 ? remark : null;
                                if (str != null) {
                                    sb2.append('(' + str + ')');
                                }
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append('(');
                                sb3.append(groupInfoT.getGroupData().getMemberCount());
                                sb3.append(')');
                                sb2.append(sb3.toString());
                                adx adxVar = new adx(roomId, sb2.toString(), groupInfoT.getRoomId(), false);
                                arrayList3.add(adxVar);
                                arrayList2.add(adxVar);
                            } else {
                                FriendInfo friendInfoS = cnb.s(cursorAb);
                                String wxid = friendInfoS.getWxid();
                                StringBuilder sb4 = new StringBuilder();
                                String nickname = friendInfoS.getNickname();
                                if ((dfv.d(dap.b(new dap("\r\n|\r|\n" /* "\r\n|\r|\n" /* "\r\n|\r|\n" /* cnb.z(-514519902190378L)  */), nickname)) > 3
                                        ? nickname
                                        : null) != null) {
                                    sb4.append("已过滤此昵称..." /* "已过滤此昵称..." /* "已过滤此昵称..." /* cnb.z(-514472657550122L)  */);
                                } else {
                                    String str2 = nickname.length() > 8 ? nickname : null;
                                    if (str2 != null) {
                                        String strSubstring = str2.substring(0, 8);
                                        throwIfVar1IsNull(strSubstring,
                                                "substring(...)" /* "substring(...)" /* "substring(...)" /* cnb.z(-514446887746346L)  */);
                                        sb4.append(strSubstring);
                                        sb4.append("..." /* "..." /* "..." /* cnb.z(-514382463236906L)  */);
                                        sb = sb4;
                                    } else {
                                        sb = null;
                                    }
                                    if (sb == null) {
                                        sb4.append(nickname);
                                    }
                                }
                                String remark2 = friendInfoS.getRemark();
                                str = remark2.length() > 0 ? remark2 : null;
                                if (str != null) {
                                    sb4.append('(' + str + ')');
                                }
                                adx adxVar2 = new adx(wxid, sb4.toString(), friendInfoS.getWxid(), false);
                                arrayList3.add(adxVar2);
                                arrayList.add(adxVar2);
                            }
                            break;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                cnh.m(cursorAb, th);
                                throw th2;
                            }
                        }
                    }
                    cursorAb.close();
                }
                aelVar2.b = true;
                aelVar2.c.addAll(arrayList3);
                aelVar2.m("好友" /* "好友" /* "好友" /* cnb.z(-514399643106090L)  */, arrayList);
                aelVar2.m("群聊" /* "群聊" /* "群聊" /* cnb.z(-514335218596650L)  */, arrayList2);
                aelVar2.g = R.drawable.ic_contact_send_24dp;
                String strZ = "转发" /* "转发" /* "转发" /* cnb.z(-514356693433130L)  */;
                cic cicVar = new cic(this.b, this.c, 2);
                aelVar2.j = strZ;
                aelVar2.l = cicVar;
                break;
        }
        return KotlinUnit.INSTANCE;
    }
}
