package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.info.FriendInfo;
import me.hd.wauxv.data.bean.info.GroupInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class etk implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public /* synthetic */ etk(String str, int i, int i2) {
        this.a = i2;
        this.b = str;
        this.c = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IOException {
        String str;
        StringBuilder sb;
        switch (this.a) {
            case 0:
                etk etkVar = new etk(this.b, this.c, 1);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                etkVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                break;
            default:
                ael aelVar2 = (ael) obj;
                aelVar2.f = "搜索好友/群聊" /* "搜索好友/群聊" /* "搜索好友/群聊" /* cnb.z(-521065432349482L)  */;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Cursor cursorAb = bmy.ab(new aer[] { aer.a, aer.b });
                if (cursorAb != null) {
                    while (cursorAb.moveToNext()) {
                        try {
                            if (dnr.bi(cursorAb.getString(cursorAb.getColumnIndex("username" /*
                                                                                              * "username" /* "username" /* cnb.z(-521031072611114L)  */
                                                                                              */)), "@chatroom" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 520992417905450L)
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
                                if ((dfv.d(dap.b(new dap("\r\n|\r|\n" /* "\r\n|\r|\n" /* "\r\n|\r|\n" /* cnb.z(-520897928624938L)  */), nickname)) > 3
                                        ? nickname
                                        : null) != null) {
                                    sb4.append("已过滤此昵称..." /* "已过滤此昵称..." /* "已过滤此昵称..." /* cnb.z(-520318108039978L)  */);
                                } else {
                                    String str2 = nickname.length() > 8 ? nickname : null;
                                    if (str2 != null) {
                                        String strSubstring = str2.substring(0, 8);
                                        throwIfVar1IsNull(strSubstring,
                                                "substring(...)" /* "substring(...)" /* "substring(...)" /* cnb.z(-520292338236202L)  */);
                                        sb4.append(strSubstring);
                                        sb4.append("..." /* "..." /* "..." /* cnb.z(-520210733857578L)  */);
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
                aelVar2.m("好友" /* "好友" /* "好友" /* cnb.z(-520227913726762L)  */, arrayList);
                aelVar2.m("群聊" /* "群聊" /* "群聊" /* cnb.z(-520180669086506L)  */, arrayList2);
                aelVar2.g = R.drawable.ic_contact_send_24dp;
                String strZ = "转发" /* "转发" /* "转发" /* cnb.z(-520184964053802L)  */;
                final String str3 = this.b;
                final int i = this.c;
                bgj bgjVar = new bgj() { // from class: me.hd.wauxv.obf.etj
                    @Override // me.hd.wauxv.obf.bgj
                    public final Object g(Object obj2, Object obj3)
                            throws IllegalAccessException, InstantiationException, InvocationTargetException {
                        List list = (List) obj2;
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            arj.ah(((adx) it.next()).a, str3, i);
                        }
                        dnc.g(null, 3, "已转发至" /* "已转发至" /* "已转发至" /* cnb.z(-520206438890282L)  */ + list.size() + "个会话" /*
                                                                                                    * cnb.z(-
                                                                                                    * 520150604315434L)
                                                                                                    */);
                        return Boolean.FALSE;
                    }
                };
                aelVar2.j = strZ;
                aelVar2.l = bgjVar;
                break;
        }
        return KotlinUnit.INSTANCE;
    }
}
