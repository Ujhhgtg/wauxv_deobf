package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class btp implements bgq, Serializable {
    private final int arity;

    public btp(int i) {
        this.arity = i;
    }

    @Override // me.hd.wauxv.obf.bgq
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        dal.a.getClass();
        String strA = dam.a(this);
        bzo.p(strA, "renderLambdaToString(...)");
        return strA;
    }
}
