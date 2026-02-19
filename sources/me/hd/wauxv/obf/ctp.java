package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctp extends SwitchHook implements bnf, bng {
    public static final ctp b = new ctp("PlacedSortProHook" /* "PlacedSortProHook" /* "PlacedSortProHook" /* cnb.z(-525665342323498L)  */);
    public static final String c = "菜单" /* "菜单" /* "菜单" /* cnb.z(-526807803624234L)  */;
    public static final String i = "列表排序" /* "列表排序" /* "列表排序" /* cnb.z(-526829278460714L)  */;
    public static final String j = "为聊天列表菜单添加列表排序聊天功能" /* "为聊天列表菜单添加列表排序聊天功能" /* "为聊天列表菜单添加列表排序聊天功能" /* cnb.z(-526773443885866L)  */;
    public static final Function1$VarIsObj m = new Function1$VarIsObj(13);

    @Override // me.hd.wauxv.obf.bnf
    public final List a(ConversationBean conversationBean) {
        if (!z()) {
            return EmptyReadonlyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        if (cto.a.i()) {
            if (arj.z(conversationBean.getFlag(), agd.b) == 0) {
                long flag = conversationBean.getFlag();
                if (0 <= flag && flag < 1152921504606846977L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_SetPlacedTopPro, "列表置顶" /*
                                                                                              * "列表置顶" /* "列表置顶" /* cnb.z(-526086249118506L)  */
                                                                                              */, new Function1$VarIsObj(15)));
                }
            } else {
                long flag2 = conversationBean.getFlag();
                if (6917529027641081856L <= flag2 && flag2 < 8070450532247928833L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_UnSetPlacedTopPro, "取消列表置顶" /*
                                                                                                  * cnb.z(-
                                                                                                  * 526116313889578L)
                                                                                                  */, new Function1$VarIsObj(16)));
                }
            }
        }
        if (ctn.a.i()) {
            arrayList.add(new agf(R.id.MenuItem_Conversation_ResetPlaced, "还原排序" /* "还原排序" /* "还原排序" /* cnb.z(-526069069249322L)  */,
                    new Function1$VarIsObj(17)));
        }
        if (ctm.a.i()) {
            if (arj.z(conversationBean.getFlag(), agd.a) == 0) {
                long flag3 = conversationBean.getFlag();
                if (0 <= flag3 && flag3 < 1152921504606846977L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_SetPlacedBottomPro, "列表置底" /*
                                                                                                 * cnb.z(-
                                                                                                 * 526030414543658L)
                                                                                                 */, new Function1$VarIsObj(18)));
                    return arrayList;
                }
            } else {
                long flag4 = conversationBean.getFlag();
                if (-6917529027641081856L <= flag4 && flag4 < -5764607523034234879L) {
                    arrayList.add(new agf(R.id.MenuItem_Conversation_UnSetPlacedBottomPro, "取消列表置底" /*
                                                                                                     * cnb.z(-
                                                                                                     * 526043299445546L)
                                                                                                     */, new Function1$VarIsObj(19)));
                }
            }
        }
        return arrayList;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void getThisObject() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(ctl.a));
        ctp ctpVar = b;
        HookManager hookManagerVarAb = PackageParam.createHook(ctpVar, listBf);
        ctpVar.hookAfter(hookManagerVarAb, new Function1$VarIsObj(14));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ctl.a, dexKitBridge, new Function1$VarIsObj(20));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return m;
    }
}
