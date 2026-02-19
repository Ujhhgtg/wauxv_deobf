package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ckk("navigation")
public class cjk extends ckl {
    public final ckm a;

    public cjk(ckm ckmVar) {
        throwIfVar1IsNull(ckmVar, "navigatorProvider");
        this.a = ckmVar;
    }

    @Override // me.hd.wauxv.obf.ckl
    public final cjg c() {
        return new cji(this);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final void i(List list, cjo cjoVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            cio cioVar = (cio) it.next();
            cjg cjgVar = cioVar.b;
            throwIfVar1IsNull(cjgVar, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            cji cjiVar = (cji) cjgVar;
            Bundle bundleL = cioVar.h.l();
            xe xeVar = cjiVar.b;
            int i = xeVar.c;
            if (i == 0) {
                ea eaVar = cjiVar.g;
                String strValueOf = (String) eaVar.d;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(eaVar.a);
                }
                throwIfVar1IsNull(strValueOf, "superName");
                if (((cji) xeVar.d).g.a == 0) {
                    strValueOf = "the root navigation";
                }
                throw new IllegalStateException(
                        "no start destination defined via app:startDestination for ".concat(strValueOf).toString());
            }
            cjg cjgVar2 = (cjg) ((dlo) xeVar.e).f(i);
            if (cjgVar2 == null) {
                if (((String) xeVar.f) == null) {
                    xeVar.f = String.valueOf(xeVar.c);
                }
                String str = (String) xeVar.f;
                throwIfVar1IsNull(str);
                throw new IllegalArgumentException(
                        concat("navigation destination ", str, " is not a direct child of this NavGraph"));
            }
            this.a.d(cjgVar2.f).i(dqc.toSingletonList(w().j(cjgVar2, cjgVar2.k(bundleL))), cjoVar);
        }
    }
}
