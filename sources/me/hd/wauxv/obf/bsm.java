package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsm implements dfx {
    public static final bsm a = new bsm();
    public static final String c = "kotlinx.serialization.json.JsonObject";
    public final /* synthetic */ bvs e;

    public bsm() {
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        dnh dnhVar2 = dnh.b;
        bsb bsbVar2 = bsb.b;
        this.e = new bvs(dnh.d, bsb.d);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return c;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        this.e.getClass();
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        this.e.getClass();
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        return this.e.g(str);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        this.e.getClass();
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        this.e.getClass();
        return dnt.c;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        this.e.getClass();
        return 2;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        this.e.getClass();
        return String.valueOf(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        this.e.k(i);
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        return this.e.l(i);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        this.e.m(i);
        return false;
    }
}
