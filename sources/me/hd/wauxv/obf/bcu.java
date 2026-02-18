package me.hd.wauxv.obf;

import android.view.View;
import android.widget.TextView;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bcu extends doo implements bnc {
    public static final bcu a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final ayz j;

    static {
        cnb.z(-463680374307626L);
        a = new bcu(cnb.z(-462147070982954L));
        b = cnb.z(-463646014569258L);
        c = cnb.z(-463598769929002L);
        h = cnb.z(-463551525288746L);
        j = new ayz(29);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (z()) {
            int i = bte.a;
            azg azgVarR = dqc.bi(obj).r();
            azgVarR.ab = cnb.z(-462086941440810L);
            TextView textView = (TextView) ((azk) yg.e(azgVarR)).e();
            int iK = bcs.a.k();
            if (iK == bcr.a.e) {
                if (textView != null) {
                    textView.setVisibility(8);
                }
            } else if (iK == bcr.c.e && textView != null) {
                textView.setVisibility(0);
            }
            if (textView != null) {
                textView.setText(cnh.ag(msgInfoBean.getCreateTime(), bct.a.o(), null, 2));
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
