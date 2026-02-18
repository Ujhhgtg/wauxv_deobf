package me.hd.wauxv.obf;

import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxl extends doo implements bng {
    public static final cxl a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final cvc j;

    static {
        cnb.z(-459209313352490L);
        cnb.z(-459162068712234L);
        a = new cxl(cnb.z(-458324550089514L));
        b = cnb.z(-459136298908458L);
        c = cnb.z(-459089054268202L);
        i = cnb.z(-459110529104682L);
        j = new cvc(11);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(cxi.a));
        cxl cxlVar = a;
        aki akiVarAb = csb.ab(cxlVar, listBf);
        cxlVar.y(akiVarAb, new cvc(12));
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
        emn.aj(cxi.a, dexKitBridge, new cvc(13));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
