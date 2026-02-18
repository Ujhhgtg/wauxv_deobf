package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dav extends doo implements bng, boc {
    public static final dav a = new dav("RemoveMultiSelectLimitHook" /* cnb.z(-500810366581546L) */);
    public static final String b = "限制" /* cnb.z(-497825364310826L) */;
    public static final String c = "移除多选限制" /* cnb.z(-497228363856682L) */;
    public static final String i = "移除选择好友群聊最多只能九个的限制" /* cnb.z(-497249838693162L) */;

    @Override // me.hd.wauxv.obf.boc
    public final void _cc(bmm bmmVar, Intent intent) {
        if (z()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != -1442966170) {
                    if (iHashCode != -604671604 || !className.equals("com.tencent.mm.ui.mvvm.MvvmSelectContactUI" /* cnb.z(-497803889474346L) */)) {
                        return;
                    }
                } else if (!className.equals("com.tencent.mm.ui.mvvm.MvvmContactListUI" /* cnb.z(-500711582333738L) */)) {
                    return;
                }
                intent.putExtra("max_limit_num" /* cnb.z(-497567666273066L) */, Integer.MAX_VALUE);
            }
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(dau.a));
        dav davVar = a;
        aki akiVarAb = csb.ab(davVar, listBf);
        davVar.y(akiVarAb, new cvc(20));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(dau.a, dexKitBridge, new cvc(21));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
