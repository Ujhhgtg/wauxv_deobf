package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class div extends doo implements bob {
    public static final div a = new div("SnsEnhanceHook" /* cnb.z(-530952447064874L) */);
    public static final String b = "朋友圈" /* cnb.z(-528207962962730L) */;
    public static final String c = "朋友圈增强" /* cnb.z(-528156423355178L) */;
    public static final String h = "查看历史撤回以及缓存过的朋友圈内容" /* cnb.z(-528113473682218L) */;

    public static String i(String str) {
        if (!dnj.ab(str, "select *,rowid from SnsInfo" /* cnb.z(-530870842686250L) */, false)) {
            return str;
        }
        if (dnj.ab(str, "WHERE SnsInfo.userName=" /* cnb.z(-530235187526442L) */, false)) {
            str = dnr.bo(dnr.bo(str, "(sourceType in (8,264,10,266,12,268,14,270,24,280,26,282,28,284,30,286,72,328,74,330,76,332,78,334,88,344,90,346,92,348,94,350,136,392,138,394,140,396,142,398,152,408,154,410,156,412,158,414,200,456,202,458,204,460,206,462,216,472,218,474,220,476,222,478))" /* cnb.z(-530132108311338L) */, "(sourceType in (0,2,8,264,10,266,12,268,14,270,24,280,26,282,28,284,30,286,72,328,74,330,76,332,78,334,88,344,90,346,92,348,94,350,136,392,138,394,140,396,142,398,152,408,154,410,156,412,158,414,200,456,202,458,204,460,206,462,216,472,218,474,220,476,222,478))" /* cnb.z(-531175785364266L) */), "(snsId >= " /* cnb.z(-527890135382826L) */, "(1=1 or snsId >= " /* cnb.z(-527808531004202L) */);
        }
        return dnr.bo(str, "(sourceType & 2 != 0 )" /* cnb.z(-528298157275946L) */, "(1=1)" /* cnb.z(-528182193158954L) */);
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
