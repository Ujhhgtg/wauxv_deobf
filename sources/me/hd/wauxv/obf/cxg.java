package me.hd.wauxv.obf;

import java.util.List;

import android.view.View;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxg extends SwitchHook implements IDexFind {
    public static final cxg a = new cxg("QuoteClickToPosHook" /* "QuoteClickToPosHook" /* "QuoteClickToPosHook" /* cnb.z(-460076896746282L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-461099098962730L)  */;
    public static final String c = "引用消息直达" /* "引用消息直达" /* "引用消息直达" /* cnb.z(-461103393930026L)  */;
    public static final String i = "点击引用消息内容直接定位到原文位置" /* "点击引用消息内容直接定位到原文位置" /* "点击引用消息内容直接定位到原文位置" /* cnb.z(-461073329158954L)  */;
    public static final boolean j;

    /* JADX WARN: Found duplicated region for block: B:11:0x005a */
    static {
        boolean z;
        ewk ver8061 = ewk.VER_8061;
        if (HostInfoRegistry.getVerCode() > ver8061.code || HostInfoRegistry.getIsPlay()) {
            ewh ver8058 = ewh.VER_8058;
            z = HostInfoRegistry.getVerCode() <= ver8058.code && HostInfoRegistry.getIsPlay();
        }
        j = z;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean _ab() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        if (j) {
            List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(QuoteClickToPosHook$MethodClickEvent.INSTANCE));
            cxg cxgVar = a;
            HookManager hookManagerVarAb = PackageParam.createHook(cxgVar, listBf);
            cxgVar.hookBefore(hookManagerVarAb, (obj -> {
                HookParam hookParam2 = (HookParam) obj;
                Object arg0 = hookParam2.getArgs()[0];
                Object arg2 = hookParam2.getArgs()[2];
                Object rawArg3 = hookParam2.getArgs()[3];
                View arg3 = (View) rawArg3;
                Object rawArg4 = hookParam2.getArgs()[4];
                long arg4 = ((Number) rawArg4).longValue();
                Object rawArg5 = hookParam2.getArgs()[5];
                String arg5 = (String) rawArg5;
                Object arg6 = hookParam2.getArgs()[6];
                StaticHelpers7.toDexMethod(QuoteClickToPosHook$MethodClickToPositionEvent.INSTANCE).invoke(null, arg0, arg2, cgy.b(arg4), arg3, Long.valueOf(arg4), arg5,
                        arg6);
                hookParam2.setResult(null);
            }));
            hookManagerVarAb.initInstantCollectionAndApplyHooks();
        }
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
        if (j) {
            StaticHelpers7.resolveDexAndCache(QuoteClickToPosHook$MethodClickEvent.INSTANCE, dexKitBridge,
                    (obj -> {
                        ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                            DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj1;
                            String[] strArr3 = { "com.tencent.mm.ui.chatting.viewitems" };
                            dexMethodQueryBuilderVar4.searchedPackages = SomeStaticHelpers.arrayToList(strArr3);
                            DexFinder cdjVar4 = new DexFinder();
                            cdjVar4.usingStrings("MicroMsg.msgquote.QuoteMsgSourceClickLogic",
                                    "handleItemClickEvent,quotedMsg is null!");
                            dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                        })
                    }));
            StaticHelpers7.resolveDexAndCache(QuoteClickToPosHook$MethodClickToPositionEvent.INSTANCE, dexKitBridge,
                    (obj -> {
                        ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                            DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj1;
                            String[] strArr2 = { "com.tencent.mm.ui.chatting.viewitems" };
                            dexMethodQueryBuilderVar3.searchedPackages = SomeStaticHelpers.arrayToList(strArr2);
                            DexFinder cdjVar3 = new DexFinder();
                            cdjVar3.usingStrings("MicroMsg.msgquote.QuoteMsgSourceClickLogic",
                                    "handleItemClickToPositionEvent,quotedMsg is null!");
                            dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                        })
                    }));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
