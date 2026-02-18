package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsc implements dfx {
    public final dov a;

    public bsc(bfu bfuVar) {
        this.a = new dov(bfuVar);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return c().b();
    }

    public final dfx c() {
        return (dfx) this.a.getValue();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        return c().g(str);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return c().h();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return c().i();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        return c().j(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        return c().k(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        return c().l(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        return c().m(i);
    }
}
