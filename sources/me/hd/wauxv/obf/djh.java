package me.hd.wauxv.obf;

import java.util.Locale;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djh extends doo implements bng {
    public static final djh a;
    public static final String[] b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final dhg m;

    static {
        cnb.z(-556919819336490L);
        cnb.z(-557349316066090L);
        a = new djh(cnb.z(-535788580240170L));
        b = new String[]{cnb.z(-557310661360426L), cnb.z(-557241941883690L), cnb.z(-557207582145322L), cnb.z(-556623466593066L), cnb.z(-556533272279850L)};
        c = cnb.z(-556516092410666L);
        i = cnb.z(-556464552803114L);
        j = cnb.z(-556430193064746L);
        m = new dhg(16);
    }

    public static String n(Object obj) throws IllegalAccessException {
        int i2 = bte.a;
        azg azgVarR = dqc.bi(obj).r();
        azgVarR.ab = cnb.z(-535771400370986L);
        Object objE = ((azk) yg.e(azgVarR)).e();
        bzo.n(objE);
        long jLongValue = ((Number) objE).longValue();
        azg azgVarR2 = dqc.bi(obj).r();
        azgVarR2.ab = cnb.z(-532936721955626L);
        Object objE2 = ((azk) yg.e(azgVarR2)).e();
        bzo.n(objE2);
        azg azgVarR3 = dqc.bi(obj).r();
        azgVarR3.ab = cnb.z(-532855117577002L);
        Object objE3 = ((azk) yg.e(azgVarR3)).e();
        bzo.n(objE3);
        int iIntValue = ((Number) objE3).intValue();
        azg azgVarR4 = dqc.bi(obj).r();
        azgVarR4.ab = cnb.z(-532799283002154L);
        Object objE4 = ((azk) yg.e(azgVarR4)).e();
        bzo.n(objE4);
        int iIntValue2 = ((Number) objE4).intValue();
        String strBo = dnr.bo(djf.a.o(), cnb.z(-532769218231082L), cnh.ag(((long) iIntValue) * 1000, djg.a.o(), null, 2));
        String strZ = cnb.z(-532734858492714L);
        String strZ2 = cnb.z(-533250254568234L);
        cmz.o(16);
        String string = Integer.toString(iIntValue2, 16);
        bzo.p(string, cnb.z(-533203009927978L));
        String upperCase = string.toUpperCase(Locale.ROOT);
        bzo.p(upperCase, cnb.z(-533194419993386L));
        return dnr.bo(dnr.bo(dnr.bo(strBo, strZ, strZ2.concat(upperCase)), cnb.z(-533121405549354L), String.valueOf(jLongValue)), cnb.z(-533031211236138L), (String) objE2);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        boolean zAb = cnb.ab(ewk.d);
        djh djhVar = a;
        if (zAb || cnb.ac(ewh.d)) {
            aki akiVarAb = csb.ab(djhVar, dqc.bf(emn.bb(djc.a)));
            djhVar.x(akiVarAb, new dhg(18));
            akiVarAb.o();
        } else {
            aki akiVarAb2 = csb.ab(djhVar, dqc.bf(emn.bb(djd.a)));
            djhVar.x(akiVarAb2, new dhg(19));
            akiVarAb2.o();
        }
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
        if (!cnb.ab(ewk.d) && !cnb.ac(ewh.d)) {
            emn.aj(djd.a, dexKitBridge, new dhg(22));
        } else {
            emn.aj(djc.a, dexKitBridge, new dhg(20));
            emn.aj(djb.a, dexKitBridge, new dhg(21));
        }
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
