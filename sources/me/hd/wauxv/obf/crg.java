package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crg extends cwl {
    public final long ac;
    public boolean ae;
    public boolean af;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public crg(cwd cwdVar, cwo cwoVar, long j, dfx dfxVar) {
        super(cwdVar, cwoVar, dfxVar);
        bzo.q(dfxVar, "descriptor");
        this.ac = j;
    }

    @Override // me.hd.wauxv.obf.cwl
    public final long ad(dfx dfxVar, int i) {
        bzo.q(dfxVar, "<this>");
        if (i == 0) {
            return 19501L;
        }
        return ajn.n(dfxVar, 0);
    }

    @Override // me.hd.wauxv.obf.cwl
    public final String ag(long j) {
        Object next;
        String strB;
        if (j != 19501) {
            return super.ag(j);
        }
        cbm cbmVar = this.ah.b;
        int i = (int) (this.ac & 2147483647L);
        dfx dfxVar = this.aj;
        bzo.q(dfxVar, "<this>");
        bzo.q(cbmVar, "serializersModule");
        Iterator it = ajn.p(dfxVar, cbmVar).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((int) (ajn.n((dfx) next, 0) & 2147483647L)) != i);
        dfx dfxVar2 = (dfx) next;
        if (dfxVar2 != null && (strB = dfxVar2.b()) != null) {
            return strB;
        }
        throw new dgb("Cannot find a subclass of " + dfxVar.b() + " annotated with @ProtoNumber(" + i + ").");
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        bzo.q(dfxVar, "descriptor");
        if (!this.ae) {
            this.ae = true;
            return 0;
        }
        if (this.af) {
            return -1;
        }
        this.af = true;
        return 1;
    }

    @Override // me.hd.wauxv.obf.cwl, me.hd.wauxv.obf.ajt
    public final acm p(dfx dfxVar) {
        bzo.q(dfxVar, "descriptor");
        if (dfxVar.equals(this.aj)) {
            return this;
        }
        cre creVar = new cre(this.ah, this.ai, dfxVar);
        if (dfxVar.i() != 1) {
            throw new IllegalArgumentException(("Implementation of oneOf type " + dfxVar.b() + " should contain only 1 element, but get " + dfxVar.i()).toString());
        }
        List listK = dfxVar.k(0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (obj instanceof cwg) {
                arrayList.add(obj);
            }
        }
        if (((cwg) aaz.s(arrayList)) != null) {
            return creVar;
        }
        throw new IllegalArgumentException(("Implementation of oneOf type " + dfxVar.b() + " should have @ProtoNumber annotation").toString());
    }
}
