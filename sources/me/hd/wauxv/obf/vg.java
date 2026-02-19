package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class vg extends SwitchHook implements IDexFind, bob {
    public static final vg a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg i;
    public static final boolean m;

    static {
        "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-577552842226474L)  */;
        "#FFCCE8E3" /* "#FFCCE8E3" /* "#FFCCE8E3" /* cnb.z(-565913480854314L)  */;
        "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-565887711050538L)  */;
        "#FF006A62" /* "#FF006A62" /* "#FF006A62" /* cnb.z(-565861941246762L)  */;
        "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-565836171442986L)  */;
        "#FF324B48" /* "#FF324B48" /* "#FF324B48" /* cnb.z(-565741682162474L)  */;
        "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-565715912358698L)  */;
        "#FF81D5CB" /* "#FF81D5CB" /* "#FF81D5CB" /* cnb.z(-566239898368810L)  */;
        a = new vg("ChatGroupNavHook" /* "ChatGroupNavHook" /* "ChatGroupNavHook" /* cnb.z(-572617924803370L)  */);
        b = "界面" /* "界面" /* "界面" /* cnb.z(-566214128565034L)  */;
        c = "聊天分组导航" /* "聊天分组导航" /* "聊天分组导航" /* cnb.z(-566149704055594L)  */;
        d = "添加分组侧边导航栏，最多设七个分组" /* "添加分组侧边导航栏，最多设七个分组" /* "添加分组侧边导航栏，最多设七个分组" /* cnb.z(-566119639284522L)  */;
        i = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(28);
        m = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(uu.a));
        vg vgVar = a;
        aki akiVarAb = PackageParam.ab(vgVar, listBf);
        vgVar.x(akiVarAb, new us(0));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(uu.a, dexKitBridge, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(29));
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void n(HookParam hookParam, String str) {
        Object next;
        if (getIsEnabled()) {
            Object obj = null;
            if (dnr.bp(str,
                    "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation where " /*
                                                                                                                                                                                                                                                                       * cnb
                                                                                                                                                                                                                                                                       * .
                                                                                                                                                                                                                                                                       * z
                                                                                                                                                                                                                                                                       * (
                                                                                                                                                                                                                                                                       * -
                                                                                                                                                                                                                                                                       * 572012334414634L)
                                                                                                                                                                                                                                                                       */,
                    false)) {
                if (ux.a.o().equals(bis.a.d)) {
                    return;
                }
                biw.a.getClass();
                Iterator it = biw.f().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!nullSafeIsEqual(((biv) next).b, ux.a.o()));
                biv bivVar = (biv) next;
                if (bivVar != null) {
                    hookParam.getClass();
                    new ek(hookParam, 1, 8).q(
                            "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation "
                                    /* "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation " /* "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation " /* cnb.z(-573730321333034L)  */ + bivVar.g(ux.a.o()));
                }
            }
            if (!dnr.bp(str,
                    "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation where " /*
                                                                                                                                                                                                                                                                                                           * cnb
                                                                                                                                                                                                                                                                                                           * .
                                                                                                                                                                                                                                                                                                           * z
                                                                                                                                                                                                                                                                                                           * (
                                                                                                                                                                                                                                                                                                           * -
                                                                                                                                                                                                                                                                                                           * 579339548621610L)
                                                                                                                                                                                                                                                                                                           */,
                    false) || ux.a.o().equals(bis.a.d)) {
                return;
            }
            biw.a.getClass();
            for (Object obj2 : biw.f()) {
                if (nullSafeIsEqual(((biv) obj2).b, ux.a.o())) {
                    obj = obj2;
                    break;
                }
            }
            biv bivVar2 = (biv) obj;
            if (bivVar2 != null) {
                hookParam.getClass();
                new ek(hookParam, 1, 8).q(
                        "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation "
                                /* "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation " /* "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation " /* cnb.z(-580318801165098L)  */ + bivVar2.g(ux.a.o()));
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return m;
    }
}
