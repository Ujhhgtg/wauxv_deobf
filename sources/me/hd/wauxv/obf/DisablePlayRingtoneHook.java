package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DisablePlayRingtoneHook extends SwitchHook implements IDexFind {
    public static final DisablePlayRingtoneHook a = new DisablePlayRingtoneHook("DisablePlayRingtoneHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 445057396112170L)
                                                                                                           */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-444563474873130L)  */;
    public static final String c = "屏蔽通话铃声" /* "屏蔽通话铃声" /* "屏蔽通话铃声" /* cnb.z(-444567769840426L)  */;
    public static final String i = "屏蔽视频及语音通话时呼出呼入的铃声" /* "屏蔽视频及语音通话时呼出呼入的铃声" /* "屏蔽视频及语音通话时呼出呼入的铃声" /* cnb.z(-444537705069354L)  */;
    public static final amb j = new amb(12);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.bb(aob.a));
        DisablePlayRingtoneHook aoeVar = a;
        aki akiVarAb = PackageParam.ab(aoeVar, listBf);
        aoeVar.y(akiVarAb, new amb(13));
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
        StaticHelpers7.resolveDexAndCache(aob.a, dexKitBridge, new amb(14));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return j;
    }
}
