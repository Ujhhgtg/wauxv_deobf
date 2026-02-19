package me.hd.wauxv.obf;

import java.io.IOException;
import java.util.ArrayList;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;
import me.hd.wauxv.data.bean.info.GroupInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cwz implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ConversationBean b;

    public /* synthetic */ cwz(ConversationBean conversationBean, int i) {
        this.a = i;
        this.b = conversationBean;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IOException {
        switch (this.a) {
            case 0:
                cwz cwzVar = new cwz(this.b, 1);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                cwzVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                break;
            default:
                ael aelVar2 = (ael) obj;
                aelVar2.f = "搜索群聊" /* "搜索群聊" /* "搜索群聊" /* cnb.z(-527117041269546L)  */;
                String strZ = "群聊" /* "群聊" /* "群聊" /* cnb.z(-527147106040618L)  */;
                ArrayList<GroupInfo> arrayListT = bmy.t();
                ArrayList arrayList = new ArrayList(StaticHelpers4.ak(arrayListT, 10));
                for (GroupInfo groupInfo : arrayListT) {
                    String roomId = groupInfo.getRoomId();
                    StringBuilder sb = new StringBuilder();
                    sb.append(groupInfo.getName());
                    String remark = groupInfo.getRemark();
                    if (remark.length() <= 0) {
                        remark = null;
                    }
                    if (remark != null) {
                        sb.append("(" + remark + ')');
                    }
                    sb.append("(" + groupInfo.getGroupData().getMemberCount() + ')');
                    arrayList.add(new adx(roomId, sb.toString(), groupInfo.getRoomId(), false));
                }
                aelVar2.m(strZ, arrayList);
                aelVar2.g = R.drawable.ic_contact_confirm_24dp;
                String strZ2 = "邀请" /* "邀请" /* "邀请" /* cnb.z(-527082681531178L)  */;
                cxa cxaVar = new cxa(this.b, 0);
                aelVar2.j = strZ2;
                aelVar2.l = cxaVar;
                break;
        }
        return Kotlin$Unit.INSTANCE;
    }
}
