package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crf extends cwn {
    public final SyntheticPileOfMess af;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public crf(cwd cwdVar, SyntheticPileOfMess bmuVar, dfx dfxVar) {
        super(cwdVar, bmuVar, dfxVar);
        throwIfVar1IsNull(cwdVar, "proto");
        throwIfVar1IsNull(bmuVar, "parentWriter");
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.af = bmuVar;
        if (dfxVar.h() instanceof cur) {
            return;
        }
        throw new IllegalArgumentException(("The serializer of one of type " + dfxVar.b()
                + " should be using generic polymorphic serializer, but got " + dfxVar.h()
                + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }

    @Override // me.hd.wauxv.obf.cwn
    public final void _cb(long j, String str) {
        throwIfVar1IsNull(str, "value");
        if (j != 19501) {
            super._cb(j, str);
        }
    }

    @Override // me.hd.wauxv.obf.cwn
    public final long ae(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        if (i == 0) {
            return 19501L;
        }
        if (i == 1) {
            return ajn.n(dfxVar, i);
        }
        StringBuilder sbR = yg.concatVar213(i, "Unsupported index: ", " in a oneOf type ");
        sbR.append(dfxVar.b());
        sbR.append(", which should be using generic polymorphic serializer");
        throw new SomeIllegalArgumentException(sbR.toString());
    }

    @Override // me.hd.wauxv.obf.cwn, me.hd.wauxv.obf.avt
    public final acn o(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        if (dfxVar.equals(this.an)) {
            return this;
        }
        cwd cwdVar = this.al;
        throwIfVar1IsNull(cwdVar, "proto");
        SyntheticPileOfMess bmuVar = this.af;
        throwIfVar1IsNull(bmuVar, "parentWriter");
        crd crdVar = new crd(cwdVar, bmuVar, dfxVar);
        if (dfxVar.i() != 1) {
            throw new IllegalArgumentException(("Implementation of oneOf type " + dfxVar.b()
                    + " should contain only 1 element, but get " + dfxVar.i()).toString());
        }
        List listK = dfxVar.k(0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (obj instanceof cwg) {
                arrayList.add(obj);
            }
        }
        if (((cwg) StaticHelpers5.s(arrayList)) != null) {
            return crdVar;
        }
        throw new IllegalArgumentException(
                ("Implementation of oneOf type " + dfxVar.b() + " should have @ProtoNumber annotation").toString());
    }

    @Override // me.hd.wauxv.obf.cwn, me.hd.wauxv.obf.avt
    public final avt r(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        _by((_bw() & 1152921500311879680L) | ((long) ((int) (ajn.n(dfxVar, 0) & 2147483647L))));
        return this;
    }
}
