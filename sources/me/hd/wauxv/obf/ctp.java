package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctp extends doo implements bnf, bng {
    public static final ctp b = new ctp(cnb.z(-525665342323498L));
    public static final String c = cnb.z(-526807803624234L);
    public static final String i = cnb.z(-526829278460714L);
    public static final String j = cnb.z(-526773443885866L);
    public static final crl m = new crl(13);

    @Override // me.hd.wauxv.obf.bnf
    public final List a(ConversationBean conversationBean) {
        if (!z()) {
            return avd.a;
        }
        ArrayList arrayList = new ArrayList();
        if (cto.a.i()) {
            if (arj.z(conversationBean.getFlag(), agd.b) == 0) {
                long flag = conversationBean.getFlag();
                if (0 <= flag && flag < 1152921504606846977L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_SetPlacedTopPro, cnb.z(-526086249118506L), new crl(15)));
                }
            } else {
                long flag2 = conversationBean.getFlag();
                if (6917529027641081856L <= flag2 && flag2 < 8070450532247928833L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_UnSetPlacedTopPro, cnb.z(-526116313889578L), new crl(16)));
                }
            }
        }
        if (ctn.a.i()) {
            arrayList.add(new agf(R.id.MenuItem_Conversation_ResetPlaced, cnb.z(-526069069249322L), new crl(17)));
        }
        if (ctm.a.i()) {
            if (arj.z(conversationBean.getFlag(), agd.a) == 0) {
                long flag3 = conversationBean.getFlag();
                if (0 <= flag3 && flag3 < 1152921504606846977L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_SetPlacedBottomPro, cnb.z(-526030414543658L), new crl(18)));
                    return arrayList;
                }
            } else {
                long flag4 = conversationBean.getFlag();
                if (-6917529027641081856L <= flag4 && flag4 < -5764607523034234879L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_UnSetPlacedBottomPro, cnb.z(-526043299445546L), new crl(19)));
                }
            }
        }
        return arrayList;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(ctl.a));
        ctp ctpVar = b;
        aki akiVarAb = csb.ab(ctpVar, listBf);
        ctpVar.x(akiVarAb, new crl(14));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(ctl.a, dexKitBridge, new crl(20));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return m;
    }
}
