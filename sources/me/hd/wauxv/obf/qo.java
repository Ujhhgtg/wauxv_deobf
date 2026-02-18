package me.hd.wauxv.obf;

import android.content.Context;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qo extends BaseHook {
    public static final qo a;
    public static final String b;
    public static final dov c;
    public static final dov d;
    public static final dov h;
    public static final dov i;
    public static final dov j;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final mj r;
    public static final boolean s;

    static {
        "微信" /* cnb.z(-439323614772010L) */;
        "通讯" /* cnb.z(-439259190262570L) */;
        "发现" /* cnb.z(-439280665099050L) */;
        "我的" /* cnb.z(-439284960066346L) */;
        a = new qo("BottomTabCustomHook" /* cnb.z(-438546225691434L) */);
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* cnb.z(-46621869996842L) */, "BottomTab" /* cnb.z(-46531675683626L) */);
        c = new dov(new h(8));
        d = new dov(new h(9));
        h = new dov(new h(10));
        i = new dov(new h(11));
        j = new dov(new h(12));
        l = "美化" /* cnb.z(-439787471239978L) */;
        m = "底栏自定义" /* cnb.z(-439791766207274L) */;
        n = "替换主页底部标签栏相关资源为自定义" /* cnb.z(-439748816534314L) */;
        r = new mj(11);
        s = true;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        int i2 = bte.a;
        adt adtVarM = yg.s(-438494686083882L).m();
        adtVarM.z(Arrays.copyOf(new Object[] { dal.b(Context.class) }, 1));
        adu aduVar = (adu) aaz.e(adtVarM.a());
        exg exgVar = exg.a;
        qo qoVar = a;
        aki akiVarAd = qoVar.ad(aduVar, exgVar);
        qoVar.x(akiVarAd, new mj(12));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return m;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return l;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return n;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final bgf p() {
        return r;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final boolean q() {
        return s;
    }
}
