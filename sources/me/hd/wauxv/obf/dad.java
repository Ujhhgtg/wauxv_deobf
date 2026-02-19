package me.hd.wauxv.obf;

import org.json.JSONObject;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dad extends SwitchHook implements IDexFind {
    public static final dad a = new dad("RedPacketDetailHook" /* "RedPacketDetailHook" /* "RedPacketDetailHook" /* cnb.z(-538838007020330L)  */);
    public static final String b = "红包" /* "红包" /* "红包" /* cnb.z(-536793602587434L)  */;
    public static final String c = "红包页面详情" /* "红包页面详情" /* "红包页面详情" /* cnb.z(-536797897554730L)  */;
    public static final String i = "红包领取页面显示更加详细的领取情况" /* "红包领取页面显示更加详细的领取情况" /* "红包领取页面显示更加详细的领取情况" /* cnb.z(-536767832783658L)  */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        aki akiVarAb = csb.ab(this, dqc.toSingletonList(emn.bb(dac.a)));
        cvc cvcVar = new cvc(16);
        dad dadVar = a;
        dadVar.x(akiVarAb, cvcVar);
        akiVarAb.o();
        cma.a.getClass();
        Class declaringClass = emn.ba(clz.a).getDeclaringClass();
        cls.a.getClass();
        for (Class cls : OtherStaticHelpers.argsToList(declaringClass, emn.ba(clr.a).getDeclaringClass())) {
            int i2 = 0;
            cde cdeVarT = dqc.bi(cls).t();
            cdeVarT.ab = "onGYNetEnd" /* "onGYNetEnd" /* "onGYNetEnd" /* cnb.z(-540848051714858L)  */;
            aki akiVarAd = dadVar.ad((MethodHookWrapper) dkz
                    .n(new Object[] { dal.b(Integer.TYPE), dal.b(String.class), dal.b(JSONObject.class) }, 3, cdeVarT),
                    exg.a);
            dadVar.y(akiVarAd, new cvc(17));
            akiVarAd.o();
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
        emn.aj(dac.a, dexKitBridge, new cvc(18));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
