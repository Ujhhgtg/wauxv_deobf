package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abj implements ahh, Serializable {
    public final ahh a;
    public final ahf f;

    public abj(ahf ahfVar, ahh ahhVar) {
        throwIfVar1IsNull(ahhVar, "left");
        throwIfVar1IsNull(ahfVar, "element");
        this.a = ahhVar;
        this.f = ahfVar;
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _t(IEmpty8 ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        ahf ahfVar = this.f;
        ahf ahfVar_w = ahfVar._w(ahgVar);
        ahh ahhVar = this.a;
        if (ahfVar_w != null) {
            return ahhVar;
        }
        ahh ahhVar_t = ahhVar._t(ahgVar);
        return ahhVar_t == ahhVar ? this : ahhVar_t == EmptyCoroutineContext.INSTANCE ? ahfVar : new abj(ahfVar, ahhVar_t);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return bgjVar.g(this.a._u(obj, bgjVar), this.f);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _v(ahh ahhVar) {
        throwIfVar1IsNull(ahhVar, "context");
        return ahhVar == EmptyCoroutineContext.INSTANCE ? this : (ahh) ahhVar._u(this, new fq(3));
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahf _w(IEmpty8 ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        abj abjVar = this;
        while (true) {
            ahf ahfVar_w = abjVar.f._w(ahgVar);
            if (ahfVar_w != null) {
                return ahfVar_w;
            }
            ahh ahhVar = abjVar.a;
            if (!(ahhVar instanceof abj)) {
                return ahhVar._w(ahgVar);
            }
            abjVar = (abj) ahhVar;
        }
    }

    public final boolean equals(Object obj) {
        boolean zF;
        if (this == obj) {
            return true;
        }
        if (obj instanceof abj) {
            abj abjVar = (abj) obj;
            int i = 2;
            abj abjVar2 = abjVar;
            int i2 = 2;
            while (true) {
                ahh ahhVar = abjVar2.a;
                abjVar2 = ahhVar instanceof abj ? (abj) ahhVar : null;
                if (abjVar2 == null) {
                    break;
                }
                i2++;
            }
            abj abjVar3 = this;
            while (true) {
                ahh ahhVar2 = abjVar3.a;
                abjVar3 = ahhVar2 instanceof abj ? (abj) ahhVar2 : null;
                if (abjVar3 == null) {
                    break;
                }
                i++;
            }
            if (i2 == i) {
                abj abjVar4 = this;
                while (true) {
                    ahf ahfVar = abjVar4.f;
                    if (!nullSafeIsEqual(abjVar._w(ahfVar.getKey()), ahfVar)) {
                        zF = false;
                        break;
                    }
                    ahh ahhVar3 = abjVar4.a;
                    if (!(ahhVar3 instanceof abj)) {
                        throwIfVar1IsNull(ahhVar3,
                                "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        ahf ahfVar2 = (ahf) ahhVar3;
                        zF = nullSafeIsEqual(abjVar._w(ahfVar2.getKey()), ahfVar2);
                        break;
                    }
                    abjVar4 = (abj) ahhVar3;
                }
                if (zF) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() + this.a.hashCode();
    }

    public final String toString() {
        return concat(new StringBuilder("["), (String) _u("", new fq(1)), ']');
    }
}
