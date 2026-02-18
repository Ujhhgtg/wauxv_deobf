package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfa extends doo implements bnq {
    public static final cfa b = new cfa(cnb.z(-512814800173866L));
    public static final String c = cnb.z(-512716015926058L);
    public static final String h = cnb.z(-512651591416618L);
    public static final String i = cnb.z(-514270794087210L);

    @Override // me.hd.wauxv.obf.bnq
    public final List a(ArrayList arrayList) {
        if (z() && !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((MsgInfoBean) it.next()).isSend()) {
                    return dqc.bf(new cev(R.id.MenuItem_MoreBtnBar_Revoke, cnb.z(-512685951154986L), new cbk(10)));
                }
            }
        }
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
