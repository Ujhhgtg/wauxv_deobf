package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csq extends doo implements bng {
    public static final csq a = new csq("PanelEmojiHook" /* cnb.z(-474439267384106L) */);
    public static final String b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final crl m;
    public static final boolean n;
    public static final ArrayList r;

    static {
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* cnb.z(-47987669596970L) */, "Panel" /* cnb.z(-47966194760490L) */);
        c = "聊天" /* cnb.z(-471926711515946L) */;
        i = "面板本地表情" /* cnb.z(-471879466875690L) */;
        j = "为聊天面板的表情分组添加相关表情包" /* cnb.z(-471832222235434L) */;
        m = new crl(1);
        n = true;
        r = new ArrayList();
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        alc alcVar = aou.a;
        cnd.bf(akq.f, new lw(2, null, 4));
        List listBf = dqc.bf(emn.bb(csp.a));
        csq csqVar = a;
        aki akiVarAb = csb.ab(csqVar, listBf);
        csqVar.x(akiVarAb, new crl(4));
        akiVarAb.o();
        aki akiVarAb2 = csb.ab(csqVar, dqc.bf(emn.bb(cso.a)));
        csqVar.y(akiVarAb2, new crl(5));
        akiVarAb2.o();
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
        emn.aj(csn.a, dexKitBridge, new crl(6));
        emn.aj(csp.a, dexKitBridge, new crl(7));
        emn.aj(cso.a, dexKitBridge, new crl(8));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return m;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return n;
    }
}
