package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djv extends BaseHook implements IRequiresDexLocate, IDatabaseOperationsListener {
    public static final djv a = new djv("SnsLabelFilterHook" /* cnb.z(-558045100768042L) */);
    public static final String b = "朋友圈" /* cnb.z(-556112365484842L) */;
    public static final String c = "朋友圈标签过滤" /* cnb.z(-555511070063402L) */;
    public static final String i = "可通过顶栏菜单过滤指定标签的朋友圈" /* cnb.z(-555476710325034L) */;

    public static String m(String str) {
        if (str.equals(
                "SELECT rowid, * FROM SnsInfo WHERE (SnsInfo.sourceType & 2) <> 0 ORDER BY SnsInfo.createTime DESC LIMIT 10 OFFSET 0" /*
                                                                                                                                       * cnb
                                                                                                                                       * .
                                                                                                                                       * z
                                                                                                                                       * (
                                                                                                                                       * -
                                                                                                                                       * 557731568155434L)
                                                                                                                                       */)) {
            Set<String> setN = dju.a.n();
            if (setN.isEmpty()) {
                setN = null;
            }
            if (setN != null && !setN.contains("default" /* cnb.z(-555068688431914L) */)) {
                ArrayList arrayList = new ArrayList();
                for (String str2 : setN) {
                    aeg.a.getClass();
                    abf.an(arrayList, aeg.b(str2));
                }
                String strK = aaz.k(new LinkedHashSet(arrayList), null, "(" /* cnb.z(-555034328693546L) */,
                        ")" /* cnb.z(-555042918628138L) */, new djk(4), 25);
                StringBuilder sb = new StringBuilder();
                sb.append(
                        "SELECT rowid, * FROM SnsInfo WHERE ((SnsInfo.sourceType & 2) <> 0) AND (SnsInfo.userName IN " /*
                                                                                                                        * cnb
                                                                                                                        * .
                                                                                                                        * z
                                                                                                                        * (
                                                                                                                        * -
                                                                                                                        * 554982789085994L)
                                                                                                                        */);
                sb.append(strK);
                return yg.h(-554634896735018L, sb);
            }
        }
        return str;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i2 = bte.a;
        cde cdeVarT = yg.s(-557521114757930L).t();
        cdeVarT.ab = "onCreate" /* cnb.z(-557770222861098L) */;
        cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
        exg exgVar = exg.a;
        djv djvVar = a;
        aki akiVarAd = djvVar.ad(cdkVar, exgVar);
        djvVar.x(akiVarAd, new djk(3));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void locateDex(DexKitBridge dexKitBridge) {
        emn.aj(djt.a, dexKitBridge, new djk(5));
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void n(HookParamWrapper hookParam, String str) {
        if (z()) {
            String strM = m(str);
            if (nullSafeIsEqual(strM, str)) {
                return;
            }
            hookParam.getClass();
            new ek(hookParam, 1, 8).q(strM);
        }
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void t(HookParamWrapper hookParam, String str) {
        if (z()) {
            String strM = m(str);
            if (nullSafeIsEqual(strM, str)) {
                return;
            }
            hookParam.getClass();
            new ek(hookParam, 0, 8).q(strM);
        }
    }
}
