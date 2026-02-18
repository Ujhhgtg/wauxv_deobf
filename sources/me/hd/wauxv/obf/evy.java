package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evy extends v {
    public final int e;
    public final int f;
    public final int g;
    public final csk h;
    public final /* synthetic */ ewa i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public evy(ewa ewaVar, x xVar, int i, int i2, int i3) {
        super(ewaVar, xVar);
        this.i = ewaVar;
        this.e = i2;
        this.g = i;
        this.f = i3;
        csk cskVar = new csk(ewaVar.b.bg);
        this.h = cskVar;
        cskVar.set(ewaVar.b.getTextPaint());
        cskVar.d();
    }

    @Override // me.hd.wauxv.obf.v
    public final Object c() {
        ArrayList arrayList = new ArrayList();
        this.i.c.ai(this.e, this.f, new ut(this, arrayList));
        evz evzVar = new evz();
        evzVar.a = this.g;
        evzVar.b = arrayList;
        return evzVar;
    }
}
