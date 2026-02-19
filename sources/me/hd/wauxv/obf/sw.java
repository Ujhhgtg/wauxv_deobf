package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class sw implements bsu, Serializable {
    public transient bsu c;
    public final Object d;
    public final Class e;
    public final String f;
    public final String h;
    public final boolean i;

    public sw(Object obj, Class cls, String str, String str2, boolean z) {
        this.d = obj;
        this.e = cls;
        this.f = str;
        this.h = str2;
        this.i = z;
    }

    public bsu j() {
        bsu bsuVar = this.c;
        if (bsuVar != null) {
            return bsuVar;
        }
        bsu bsuVarK = k();
        this.c = bsuVarK;
        return bsuVarK;
    }

    public abstract bsu k();

    public final KClassContainer l() {
        boolean z = this.i;
        Class cls = this.e;
        if (!z) {
            return dal.b(cls);
        }
        dal.a.getClass();
        return new csd(cls);
    }
}
