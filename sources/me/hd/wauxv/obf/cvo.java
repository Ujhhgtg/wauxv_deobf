package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvo implements dfx {
    public final String a;
    public final cvn c;

    public cvo(String str, cvn cvnVar) {
        throwIfVar1IsNull(cvnVar, "kind");
        this.a = str;
        this.c = cvnVar;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    public final void e() {
        throw new IllegalStateException(
                yg.o(new StringBuilder("Primitive descriptor "), this.a, " does not have elements"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cvo)) {
            return false;
        }
        cvo cvoVar = (cvo) obj;
        return nullSafeIsEqual(this.a, cvoVar.a) && nullSafeIsEqual(this.c, cvoVar.c);
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        e();
        throw null;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return this.c;
    }

    public final int hashCode() {
        return (this.c.hashCode() * 31) + this.a.hashCode();
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        e();
        throw null;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        e();
        throw null;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        e();
        throw null;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        e();
        throw null;
    }

    public final String toString() {
        return concat(new StringBuilder("PrimitiveDescriptor("), this.a, ')');
    }
}
