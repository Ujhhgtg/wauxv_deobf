package me.hd.wauxv.obf;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bus implements bun {
    public final /* synthetic */ bur a;
    public final /* synthetic */ but b;

    public bus(but butVar, bur burVar) {
        this.b = butVar;
        this.a = burVar;
    }

    @Override // me.hd.wauxv.obf.bun
    public final void j() {
        ((HashMap) this.b.b).remove(this.a);
    }

    @Override // me.hd.wauxv.obf.bun
    public final void m() {
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
    }
}
