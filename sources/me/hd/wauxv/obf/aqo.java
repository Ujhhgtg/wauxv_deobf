package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqo implements btd {
    public static final aqo b = new aqo();
    public static final cvo d = new cvo("kotlin.time.Duration", cvm.s);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        int i = aqm.c;
        String strV = ajtVar.v();
        throwIfVar1IsNull(strV, "value");
        try {
            return new aqm(cna.f(strV));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(concat("Invalid ISO duration string format: '", strV, "'."), e);
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        long j;
        long j2;
        int iJ;
        long j3 = ((aqm) obj).d;
        int i = aqm.c;
        StringBuilder sb = new StringBuilder();
        if (j3 < 0) {
            sb.append(SignatureVisitor.SUPER);
        }
        sb.append("PT");
        boolean z = true;
        if (j3 < 0) {
            j = ((-(j3 >> 1)) << 1) + ((long) (((int) j3) & 1));
            int i2 = aqn.a;
        } else {
            j = j3;
        }
        long j4 = aqm.j(j, aqp.HOURS);
        if (aqm.h(j)) {
            j2 = 0;
            iJ = 0;
        } else {
            j2 = 0;
            iJ = (int) (aqm.j(j, aqp.MINUTES) % ((long) 60));
        }
        int iJ2 = aqm.h(j) ? 0 : (int) (aqm.j(j, aqp.SECONDS) % ((long) 60));
        int iG = aqm.g(j);
        if (aqm.h(j3)) {
            j4 = 9999999999999L;
        }
        boolean z2 = j4 != j2;
        boolean z3 = (iJ2 == 0 && iG == 0) ? false : true;
        if (iJ == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(j4);
            sb.append('H');
        }
        if (z) {
            sb.append(iJ);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            aqm.f(sb, iJ2, iG, 9, "S", true);
        }
        avtVar.ad(sb.toString());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
