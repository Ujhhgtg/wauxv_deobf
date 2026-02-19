package me.hd.wauxv.obf;

import java.io.IOException;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqx extends bws implements bns {
    public static final cqx a = new cqx();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.bns
    public final void m(MsgInfoBean msgInfoBean) throws IOException {
        for (ctx ctxVar : cuk.a) {
            ctxVar.getClass();
            ctxVar.n("onHandleMsg" /* "onHandleMsg" /* "onHandleMsg" /* cnb.z(-401987464067882L)  */, msgInfoBean);
        }
    }
}
