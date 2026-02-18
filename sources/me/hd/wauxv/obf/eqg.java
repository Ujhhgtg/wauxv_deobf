package me.hd.wauxv.obf;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eqg implements bfu {
    public final /* synthetic */ ob a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ eqe c;

    public /* synthetic */ eqg(ob obVar, boolean z, eqe eqeVar) {
        this.a = obVar;
        this.b = z;
        this.c = eqeVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        doo dooVar = this.a.c;
        boolean z = this.b;
        dooVar.aj(z);
        if (z && !dooVar.v) {
            dooVar.getAllBaseBaseHookInstances();
        }
        if (dooVar.getAllSwitchHookInstances()) {
            Context context = this.c.ao.b.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("重启 " /* cnb.z(-394359602150186L) */);
            bmo.a.getClass();
            sb.append(bmo.o());
            sb.append(" 生效" /* cnb.z(-394376782019370L) */);
            Toast.makeText(context, sb.toString(), 0).show();
        }
        return ens.a;
    }
}
