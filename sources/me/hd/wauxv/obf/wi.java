package me.hd.wauxv.obf;

import android.view.MenuItem;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wi implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ wi(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() throws IllegalAccessException {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                int i2 = bte.a;
                cde cdeVarT = dqc.bi(obj).t();
                cdeVarT.a = dal.b(MenuItem.class);
                Class cls = Integer.TYPE;
                return (cdk) dkz.n(new Object[]{dal.b(cls), dal.b(cls), dal.b(cls), dal.b(CharSequence.class), dal.b(cls)}, 5, cdeVarT);
            case 1:
                int i3 = bte.a;
                azg azgVarR = dqc.bi(obj).r();
                gp.a.getClass();
                azgVarR.a = emn.bb(go.a).getDeclaringClass();
                Object objD = ((azk) aaz.e(azgVarR.c())).d();
                bzo.n(objD);
                xx.a.getClass();
                azg azgVarR2 = dqc.bi(gp.b((Class) la.p(emn.az(xw.a).getInterfaces()), objD)).r();
                uq.a.getClass();
                azgVarR2.a = ajn.ag(cnb.z(-75127567940394L));
                Object objE = ((azk) aaz.e(azgVarR2.c())).e();
                bzo.n(objE);
                return (FrameLayout) objE;
            default:
                return obj;
        }
    }
}
