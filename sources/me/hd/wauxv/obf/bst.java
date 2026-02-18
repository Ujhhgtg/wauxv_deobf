package me.hd.wauxv.obf;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bst extends afx {
    public ajx a;
    public ek d;
    public LinkedHashMap e;
    public String f;
    public int g;
    public /* synthetic */ Object o;
    public final /* synthetic */ ek p;
    public int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bst(ek ekVar, nc ncVar) {
        super(ncVar);
        this.p = ekVar;
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) {
        this.o = obj;
        this.q |= Integer.MIN_VALUE;
        return ek.e(this.p, null, this);
    }
}
