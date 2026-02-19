package me.hd.wauxv.obf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cop implements dfx {
    public static final cop a = new cop();

    @Override // me.hd.wauxv.obf.dfx
    public final String b() {
        return "kotlin.Nothing";
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean d() {
        return false;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean f() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int g(String str) {
        throwIfVar1IsNull(str, "name");
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List getAnnotations() {
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final emc h() {
        return dnt.n;
    }

    public final int hashCode() {
        return (dnt.n.hashCode() * 31) - 1818355776;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final int i() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.dfx
    public final String j(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // me.hd.wauxv.obf.dfx
    public final List k(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // me.hd.wauxv.obf.dfx
    public final dfx l(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // me.hd.wauxv.obf.dfx
    public final boolean m(int i) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }
}
