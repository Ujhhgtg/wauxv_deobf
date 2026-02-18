package me.hd.wauxv.obf;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cf extends BaseHook {
    public static final cf a;
    public static final dov b;
    public static final dov c;
    public static final dov d;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final bn l;
    public static final boolean m;

    static {
        "#FFFFFFFF" /* cnb.z(-432709365136170L) */;
        "#FF191919" /* cnb.z(-432683595332394L) */;
        a = new cf("AccountInfoCenterHook" /* cnb.z(-431137407105834L) */);
        b = new dov(new h(2));
        c = new dov(new h(3));
        d = new dov(new h(4));
        dov dovVar = ctf.a;
        h = ctf.c("Resource" /* cnb.z(-48064979008298L) */, "Font" /* cnb.z(-47974784695082L) */);
        i = "美化" /* cnb.z(-433207581342506L) */;
        j = "资料卡居中" /* cnb.z(-433143156833066L) */;
        k = "居中我界面资料卡，与隐藏微信号冲突" /* cnb.z(-433168926636842L) */;
        l = new bn(1);
        m = true;
    }

    public static void n(cf cfVar, final blr blrVar, int i2, final int i3, final int i4, float f, String str, boolean z,
            File file, int i5) throws cth {
        Class cls;
        blu bluVar = blrVar.f;
        boolean z2 = (i5 & 64) != 0;
        int i6 = (i5 & 128) != 0 ? Integer.MAX_VALUE : 1;
        int i7 = (i5 & 256) != 0 ? 0 : 1;
        File file2 = (i5 & 512) != 0 ? null : file;
        cfVar.getClass();
        blq blqVarD = awp.d(bluVar, blrVar.a, blrVar.b, blr.g(blrVar, 0, 0, new bgf() { // from class:
                                                                                        // me.hd.wauxv.obf.bo
            @Override // me.hd.wauxv.obf.bgf
            public final Object invoke(Object obj) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) obj;
                layoutParams.addRule(14);
                layoutParams.addRule(3, i3);
                layoutParams.topMargin = blrVar.k(Integer.valueOf(i4)).intValue();
                return ens.a;
            }
        }, 31));
        cls = TextView.class;
        Class<TextView> clsBf = cnf.bf(dal.b(cls));
        if (clsBf == null) {
            clsBf = cls;
        }
        View viewH = blu.h(bluVar, clsBf, null, blrVar.j());
        LinkedHashMap linkedHashMap = bluVar.f;
        viewH.setLayoutParams(blqVarD.f());
        Class<TextView> clsBf2 = cnf.bf(dal.b(cls));
        if (clsBf2 == null) {
            clsBf2 = cls;
        }
        String name = clsBf2.getName();
        int size = linkedHashMap.size();
        TextView textView = (TextView) viewH;
        textView.setId(i2);
        textView.setGravity(17);
        textView.setTextSize(f);
        textView.setText(str);
        textView.setVisibility(z ? 0 : 8);
        if (z2) {
            textView.setTextColor(
                    Color.parseColor(cnb.z(cnh.aa(textView.getContext()) ? -432924113500970L : -432898343697194L)));
        }
        textView.setMaxLines(i6);
        textView.setTypeface(textView.getTypeface(), i7);
        if (file2 != null && file2.exists()) {
            textView.setTypeface(Typeface.createFromFile(file2));
        }
        if (linkedHashMap.size() != size) {
            throw new cth(concat("Performers are not allowed to appear in ", name, " DSL creation process."));
        }
        Class<TextView> clsBf3 = cnf.bf(dal.b(cls));
        blr.i(blrVar, null, clsBf3 != null ? clsBf3 : TextView.class);
        blr.h(blrVar, viewH);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        int i2 = bte.a;
        cdk cdkVar = (cdk) dkz.n(new Object[] { dal.b(View.class) }, 1, yg.s(-431025737956138L).t());
        exg exgVar = exg.a;
        cf cfVar = a;
        aki akiVarAd = cfVar.ad(cdkVar, exgVar);
        cfVar.x(akiVarAd, new bn(2));
        akiVarAd.o();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return k;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf p() {
        return l;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return m;
    }
}
