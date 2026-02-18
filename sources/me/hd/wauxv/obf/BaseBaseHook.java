package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBaseHook extends ewy {
    public boolean v;

    public abstract String[] _aa();

    public abstract void initOnce();

    @Override // me.hd.wauxv.obf.ewy
    public final void w() {
        if (this.v) {
            return;
        }
        try {
            initOnce();
        } catch (Exception e) {
            ArrayList arrayList = ewq.a;
            StringBuilder sb = new StringBuilder();
            sb.append("initOnce " /* cnb.z(-51419348466474L) */);
            ewq.e(yg.n(sb, this instanceof SwitchHook ? ((SwitchHook) this).getResult() : "LoadHook" /*
                                                                                                      * cnb.z(-
                                                                                                      * 50843822848810L)
                                                                                                      */), e, 12);
        }
        this.v = true;
    }

    public final void x(aki akiVar, IHasInvokeMethod bgfVar) {
        akiVar.m(new bme(bgfVar, this, 0));
    }

    public final void y(aki akiVar, IHasInvokeMethod bgfVar) {
        akiVar.n(new bme(bgfVar, this, 1));
    }

    public abstract boolean z();
}
