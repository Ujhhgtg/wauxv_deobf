package me.hd.wauxv.obf;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class efq implements bfu {
    public final /* synthetic */ int a;

    public /* synthetic */ efq(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i = this.a;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                return new ko(eej.b);
            case 1:
                return new ko(dtc.b);
            case 2:
                return new ko(ebj.b);
            case 3:
                return new ko(dzt.b);
            case 4:
                return new ko(bqj.b);
            case 5:
                return new ko(egj.b);
            case 6:
                return new ko(dva.b);
            case 7:
                return new ko(dvy.b);
            case 8:
                return new ko(dvy.b);
            case 9:
                return new ko(ech.b);
            case 10:
                return new ko(ech.b);
            case 11:
                return new ko(eau.b);
            case 12:
                return new ko(eck.b);
            case 13:
                return new ko(dnh.b);
            case 14:
                return new ko(eac.b);
            case 15:
                eta.a.u(VnHomeShareMenuCopyOrDownHook.b);
                return kotlinUnitVar;
            case 16:
                etf.a.u(VnPreviewShareMenuCopyOrDownHook.b);
                return kotlinUnitVar;
            case 17:
                etv.a.u(etw.b);
                return kotlinUnitVar;
            case 18:
                StringBuilder sb = new StringBuilder();
                HostInfoRegistry.INSTANCE.getClass();
                sb.append(HostInfoRegistry.getVersionString());
                sb.append(".1238." /* ".1238." /* ".1238." /* cnb.z(-82995948026666L)  */);
                sb.append(exl.b);
                return sb.toString();
            default:
                int i2 = 0;
                ewm.a.getClass();
                FactoryPools factoryPoolsVar = ewm.d;
                IEmpty7 btcVar = ewm.b[1];
                SyntheticPileOfMess bmuVarBh = dqc.bh(factoryPoolsVar.w());
                ((Configuration) bmuVarBh.obj).processorResolver = ewm.h;
                bmuVarBh.setHookOptional(false);
                MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "newParser";
                methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(Integer.TYPE) }, 1));
                return (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
        }
    }
}
