package me.hd.wauxv.obf;

import bsh.Interpreter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cud extends BaseHook {
    public static final cud a = new cud("PluginHook" /* cnb.z(-485159505754922L) */);
    public static final String b = "核心" /* cnb.z(-485412908825386L) */;
    public static final String c = "插件" /* cnb.z(-485434383661866L) */;
    public static final String h = "相关说明:\n请确认插件安全再进行加载，\n否则造成的后果需自行承担。" /* cnb.z(-485369959152426L) */;
    public static final crl i = new crl(22);
    public static final boolean j = true;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        ArrayList arrayList = cuk.a;
        Interpreter.mainSecurityGuard.add(new cuj());
        List listD = cuk.d();
        ArrayList<ctx> arrayList2 = new ArrayList();
        for (Object obj : listD) {
            if (((ctx) obj).p()) {
                arrayList2.add(obj);
            }
        }
        for (ctx ctxVar : arrayList2) {
            if (!cuk.e(ctxVar)) {
                ctxVar.q(false);
            }
        }
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return h;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final IHasInvokeMethod p() {
        return i;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final boolean q() {
        return j;
    }
}
