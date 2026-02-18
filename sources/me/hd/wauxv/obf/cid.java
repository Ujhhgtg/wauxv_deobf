package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import java.util.ArrayList;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.info.FriendInfo;
import me.hd.wauxv.data.bean.info.GroupInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cid implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ays c;

    public /* synthetic */ cid(String str, ays aysVar, int i) {
        this.a = i;
        this.b = str;
        this.c = aysVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IOException {
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        switch (this.a) {
            case 0:
                cid cidVar = new cid(this.b, this.c, 1);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                cidVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                break;
            case 1:
                ael aelVar2 = (ael) obj;
                aelVar2.f = "搜索好友/群聊" /* cnb.z(-478678400105258L) */;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Cursor cursorAb = bmy.ab(new aer[]{aer.a, aer.b});
                if (cursorAb != null) {
                    while (cursorAb.moveToNext()) {
                        try {
                            if (dnr.bi(cursorAb.getString(cursorAb.getColumnIndex("username" /* cnb.z(-478644040366890L) */)), "@chatroom" /* cnb.z(-478622565530410L) */)) {
                                GroupInfo groupInfoT = cnb.t(cursorAb);
                                String roomId = groupInfoT.getRoomId();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(groupInfoT.getName());
                                String remark = groupInfoT.getRemark();
                                str = remark.length() > 0 ? remark : null;
                                if (str != null) {
                                    sb3.append('(' + str + ')');
                                }
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append('(');
                                sb4.append(groupInfoT.getGroupData().getMemberCount());
                                sb4.append(')');
                                sb3.append(sb4.toString());
                                adx adxVar = new adx(roomId, sb3.toString(), groupInfoT.getRoomId(), false);
                                arrayList3.add(adxVar);
                                arrayList2.add(adxVar);
                            } else {
                                FriendInfo friendInfoS = cnb.s(cursorAb);
                                String wxid = friendInfoS.getWxid();
                                StringBuilder sb5 = new StringBuilder();
                                String nickname = friendInfoS.getNickname();
                                if ((dfv.d(dap.b(new dap("\r\n|\r|\n" /* cnb.z(-478596795726634L) */), nickname)) > 3 ? nickname : null) != null) {
                                    sb5.append("已过滤此昵称..." /* cnb.z(-475800772016938L) */);
                                } else {
                                    String str3 = nickname.length() > 8 ? nickname : null;
                                    if (str3 != null) {
                                        String strSubstring = str3.substring(0, 8);
                                        bzo.p(strSubstring, "substring(...)" /* cnb.z(-475775002213162L) */);
                                        sb5.append(strSubstring);
                                        sb5.append("..." /* cnb.z(-475710577703722L) */);
                                        sb = sb5;
                                    } else {
                                        sb = null;
                                    }
                                    if (sb == null) {
                                        sb5.append(nickname);
                                    }
                                }
                                String remark2 = friendInfoS.getRemark();
                                str = remark2.length() > 0 ? remark2 : null;
                                if (str != null) {
                                    sb5.append('(' + str + ')');
                                }
                                adx adxVar2 = new adx(wxid, sb5.toString(), friendInfoS.getWxid(), false);
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
                aelVar2.m("好友" /* cnb.z(-475659038096170L) */, arrayList);
                aelVar2.m("群聊" /* cnb.z(-475663333063466L) */, arrayList2);
                aelVar2.g = R.drawable.ic_contact_send_24dp;
                String strZ = "转发" /* cnb.z(-475616088423210L) */;
                cic cicVar = new cic(this.b, this.c, 0);
                aelVar2.j = strZ;
                aelVar2.l = cicVar;
                break;
            case 2:
                cid cidVar2 = new cid(this.b, this.c, 3);
                aek aekVar2 = new aek();
                ael aelVar3 = new ael(aekVar2);
                cidVar2.invoke(aelVar3);
                aekVar2.a = aelVar3;
                aekVar2.m().bb(new qp(aekVar2, 1)).bm();
                break;
            default:
                ael aelVar4 = (ael) obj;
                aelVar4.f = "搜索好友/群聊" /* cnb.z(-475006203067178L) */;
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                Cursor cursorAb2 = bmy.ab(new aer[]{aer.a, aer.b});
                if (cursorAb2 != null) {
                    while (cursorAb2.moveToNext()) {
                        try {
                            if (dnr.bi(cursorAb2.getString(cursorAb2.getColumnIndex("username" /* cnb.z(-475521599142698L) */)), "@chatroom" /* cnb.z(-475482944437034L) */)) {
                                GroupInfo groupInfoT2 = cnb.t(cursorAb2);
                                String roomId2 = groupInfoT2.getRoomId();
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(groupInfoT2.getName());
                                String remark3 = groupInfoT2.getRemark();
                                str2 = remark3.length() > 0 ? remark3 : null;
                                if (str2 != null) {
                                    sb6.append('(' + str2 + ')');
                                }
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append('(');
                                sb7.append(groupInfoT2.getGroupData().getMemberCount());
                                sb7.append(')');
                                sb6.append(sb7.toString());
                                adx adxVar3 = new adx(roomId2, sb6.toString(), groupInfoT2.getRoomId(), false);
                                arrayList6.add(adxVar3);
                                arrayList5.add(adxVar3);
                            } else {
                                FriendInfo friendInfoS2 = cnb.s(cursorAb2);
                                String wxid2 = friendInfoS2.getWxid();
                                StringBuilder sb8 = new StringBuilder();
                                String nickname2 = friendInfoS2.getNickname();
                                if ((dfv.d(dap.b(new dap("\r\n|\r|\n" /* cnb.z(-475457174633258L) */), nickname2)) > 3 ? nickname2 : null) != null) {
                                    sb8.append("已过滤此昵称..." /* cnb.z(-475427109862186L) */);
                                } else {
                                    String str4 = nickname2.length() > 8 ? nickname2 : null;
                                    if (str4 != null) {
                                        String strSubstring2 = str4.substring(0, 8);
                                        bzo.p(strSubstring2, "substring(...)" /* cnb.z(-475401340058410L) */);
                                        sb8.append(strSubstring2);
                                        sb8.append("..." /* cnb.z(-475319735679786L) */);
                                        sb2 = sb8;
                                    } else {
                                        sb2 = null;
                                    }
                                    if (sb2 == null) {
                                        sb8.append(nickname2);
                                    }
                                }
                                String remark4 = friendInfoS2.getRemark();
                                str2 = remark4.length() > 0 ? remark4 : null;
                                if (str2 != null) {
                                    sb8.append('(' + str2 + ')');
                                }
                                adx adxVar4 = new adx(wxid2, sb8.toString(), friendInfoS2.getWxid(), false);
                                arrayList6.add(adxVar4);
                                arrayList4.add(adxVar4);
                            }
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                cnh.m(cursorAb2, th3);
                                throw th4;
                            }
                        }
                    }
                    cursorAb2.close();
                }
                aelVar4.b = true;
                aelVar4.c.addAll(arrayList6);
                aelVar4.m("好友" /* cnb.z(-475268196072234L) */, arrayList4);
                aelVar4.m("群聊" /* cnb.z(-475289670908714L) */, arrayList5);
                aelVar4.g = R.drawable.ic_contact_send_24dp;
                String strZ2 = "转发" /* cnb.z(-475293965876010L) */;
                cic cicVar2 = new cic(this.b, this.c, 1);
                aelVar4.j = strZ2;
                aelVar4.l = cicVar2;
                break;
        }
        return ens.a;
    }
}
