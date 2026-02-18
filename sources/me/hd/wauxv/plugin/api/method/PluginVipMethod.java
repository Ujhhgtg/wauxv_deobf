package me.hd.wauxv.plugin.api.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.hd.wauxv.obf.aem;
import me.hd.wauxv.obf.aen;
import me.hd.wauxv.obf.aeo;
import me.hd.wauxv.obf.azg;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.bfu;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cde;
import me.hd.wauxv.obf.cdk;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dgf;
import me.hd.wauxv.obf.dmt;
import me.hd.wauxv.obf.dmu;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginVipMethod {
    public static void a(bfu bfuVar) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        aeo aeoVar = aeo.a;
        String strZ = cnb.z(-401128470608682L);
        aeoVar.getClass();
        Method methodBb = emn.bb(aen.a);
        dmu dmuVar = dmu.a;
        dmuVar.getClass();
        int i = bte.a;
        dgf.a.getClass();
        dmuVar.getClass();
        cde cdeVarT = dqc.bi(dgf.b(emn.az(dmt.a))).t();
        cdeVarT.a = emn.az(aem.a);
        Object objE = ((cdk) bjs.h(cdeVarT)).e(new Object[0]);
        bzo.n(objE);
        Object objInvoke = methodBb.invoke(objE, strZ, Boolean.FALSE);
        bzo.n(objInvoke);
        azg azgVarR = dqc.bi(objInvoke).r();
        azgVarR.ab = cnb.z(-382930694175530L);
        Object objE2 = ((azk) yg.e(azgVarR)).e();
        bzo.n(objE2);
        if ((((Number) objE2).intValue() & 1) == 0) {
            throw new RuntimeException(cnb.z(-401059751131946L));
        }
        bfuVar.invoke();
    }

    @cty
    public final void confirmTransfer(final String str, final String str2, final String str3, final int i) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        a(new bfu() { // from class: me.hd.wauxv.obf.cul
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws NoSuchMethodException {
                cme.b(cme.a, cmp.b(cmp.a, str, str2, cnb.z(-115594749803306L), str3, i));
                return ens.a;
            }
        });
    }

    @cty
    public final void refuseTransfer(final String str, final String str2, final String str3) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        a(new bfu() { // from class: me.hd.wauxv.obf.cum
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws NoSuchMethodException {
                cme.b(cme.a, cmp.b(cmp.a, str, str2, cnb.z(-115560390064938L), str3, 0));
                return ens.a;
            }
        });
    }
}
