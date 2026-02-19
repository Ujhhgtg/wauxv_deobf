package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class vt extends SwitchHook implements IDexFind, bob {
    public static final vt a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final us i;
    public static final boolean m;

    static {
        "#FFEDEDED" /* "#FFEDEDED" /* "#FFEDEDED" /* cnb.z(-568713799531306L)  */;
        "#FF006A62" /* "#FF006A62" /* "#FF006A62" /* cnb.z(-568688029727530L)  */;
        "#FF161D1C" /* "#FF161D1C" /* "#FF161D1C" /* cnb.z(-568593540447018L)  */;
        "#FF006A62" /* "#FF006A62" /* "#FF006A62" /* cnb.z(-568567770643242L)  */;
        "#FF242424" /* "#FF242424" /* "#FF242424" /* cnb.z(-568542000839466L)  */;
        "#FF81D5CB" /* "#FF81D5CB" /* "#FF81D5CB" /* cnb.z(-568516231035690L)  */;
        "#FFDDE4E2" /* "#FFDDE4E2" /* "#FFDDE4E2" /* cnb.z(-568971497569066L)  */;
        "#FF81D5CB" /* "#FF81D5CB" /* "#FF81D5CB" /* cnb.z(-568945727765290L)  */;
        a = new vt("ChatGroupTabHook" /* "ChatGroupTabHook" /* "ChatGroupTabHook" /* cnb.z(-563525479037738L)  */);
        b = "界面" /* "界面" /* "界面" /* cnb.z(-568919957961514L)  */;
        c = "聊天分组标签" /* "聊天分组标签" /* "聊天分组标签" /* cnb.z(-568924252928810L)  */;
        d = "添加分组顶部标签栏，顶部栏无法固定" /* "添加分组顶部标签栏，顶部栏无法固定" /* "添加分组顶部标签栏，顶部栏无法固定" /* cnb.z(-568894188157738L)  */;
        i = new us(2);
        m = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(vh.a));
        vt vtVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(vtVar, listBf);
        vtVar.x(hookManagerVarAb, new us(3));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(vh.a, dexKitBridge, new us(4));
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
                                                                                                                                                                                                                                                                       * 564002220407594L)
                                                                                                                                                                                                                                                                       */,
                    false)) {
                if (vi.a.o().equals(bis.a.d)) {
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
                } while (!nullSafeIsEqual(((biv) next).b, vi.a.o()));
                biv bivVar = (biv) next;
                if (bivVar != null) {
                    hookParam.getClass();
                    new ek(hookParam, 1, 8).q(
                            "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation "
                                    /* "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation " /* "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation " /* cnb.z(-564620695698218L)  */ + bivVar.g(vi.a.o()));
                }
            }
            if (!dnr.bp(str,
                    "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation where " /*
                                                                                                                                                                                                                                                                                                           * cnb
                                                                                                                                                                                                                                                                                                           * .
                                                                                                                                                                                                                                                                                                           * z
                                                                                                                                                                                                                                                                                                           * (
                                                                                                                                                                                                                                                                                                           * -
                                                                                                                                                                                                                                                                                                           * 570229922986794L)
                                                                                                                                                                                                                                                                                                           */,
                    false) || vi.a.o().equals(bis.a.d)) {
                return;
            }
            biw.a.getClass();
            for (Object obj2 : biw.f()) {
                if (nullSafeIsEqual(((biv) obj2).b, vi.a.o())) {
                    obj = obj2;
                    break;
                }
            }
            biv bivVar2 = (biv) obj;
            if (bivVar2 != null) {
                hookParam.getClass();
                new ek(hookParam, 1, 8).q(
                        "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation "
                                /* "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation " /* "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation " /* cnb.z(-571209175530282L)  */ + bivVar2.g(vi.a.o()));
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
