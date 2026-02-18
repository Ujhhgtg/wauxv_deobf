package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class div extends doo implements bob {
    public static final div a = new div(cnb.z(-530952447064874L));
    public static final String b = cnb.z(-528207962962730L);
    public static final String c = cnb.z(-528156423355178L);
    public static final String h = cnb.z(-528113473682218L);

    public static String i(String str) {
        if (!dnj.ab(str, cnb.z(-530870842686250L), false)) {
            return str;
        }
        if (dnj.ab(str, cnb.z(-530235187526442L), false)) {
            str = dnr.bo(dnr.bo(str, cnb.z(-530132108311338L), cnb.z(-531175785364266L)), cnb.z(-527890135382826L), cnb.z(-527808531004202L));
        }
        return dnr.bo(str, cnb.z(-528298157275946L), cnb.z(-528182193158954L));
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bob
    public final void n(bmm bmmVar, String str) {
        if (z()) {
            String strI = i(str);
            if (strI.equals(str)) {
                return;
            }
            bmmVar.getClass();
            new ek(bmmVar, 1, 8).q(strI);
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }

    @Override // me.hd.wauxv.obf.bob
    public final void t(bmm bmmVar, String str) {
        if (z()) {
            String strI = i(str);
            if (strI.equals(str)) {
                return;
            }
            bmmVar.getClass();
            new ek(bmmVar, 0, 8).q(strI);
        }
    }
}
