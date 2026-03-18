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
        "#FFEDEDED";
        "#FF006A62";
        "#FF161D1C";
        "#FF006A62";
        "#FF242424";
        "#FF81D5CB";
        "#FFDDE4E2";
        "#FF81D5CB";
        a = new vt("ChatGroupTabHook");
        b = "界面";
        c = "聊天分组标签";
        d = "添加分组顶部标签栏，顶部栏无法固定";
        i = new us(2);
        m = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(ChatGroupTabHook$MethodOnTabCreate.a));
        vt vtVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(vtVar, listBf);
        vtVar.hookAfter(hookManagerVarAb, new us(3));
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
        StaticHelpers7.resolveDexAndCache(ChatGroupTabHook$MethodOnTabCreate.a, dexKitBridge, new us(4));
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void n(HookParam hookParam, String str) {
        Object next;
        if (getIsEnabled()) {
            Object obj = null;
            if (dnr.bp(str,
                    "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation where ",
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
                            "select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed, remitMarkRed, parentRef from rconversation " + bivVar.g(vi.a.o()));
                }
            }
            if (!dnr.bp(str,
                    "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation where ",
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
                        "select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed, remitMarkRed, hasSpecialFollow, parentRef from rconversation " + bivVar2.g(vi.a.o()));
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return m;
    }
}
