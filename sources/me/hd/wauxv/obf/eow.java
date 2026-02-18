package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eow implements btd {
    public static final eow b = new eow();
    public static final cvo d = new cvo("kotlin.uuid.Uuid", cvm.s);

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        String strConcat;
        String strV = ajtVar.v();
        bzo.q(strV, "uuidString");
        int length = strV.length();
        if (length == 32) {
            long jD = bkx.d(strV, 0, 16);
            long jD2 = bkx.d(strV, 16, 32);
            if (jD != 0 || jD2 != 0) {
                return new eov(jD, jD2);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                if (strV.length() <= 64) {
                    strConcat = strV;
                } else {
                    String strSubstring = strV.substring(0, 64);
                    bzo.p(strSubstring, "substring(...)");
                    strConcat = strSubstring.concat("...");
                }
                sb.append(strConcat);
                sb.append("\" of length ");
                sb.append(strV.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long jD3 = bkx.d(strV, 0, 8);
            cna.i(8, strV);
            long jD4 = bkx.d(strV, 9, 13);
            cna.i(13, strV);
            long jD5 = bkx.d(strV, 14, 18);
            cna.i(18, strV);
            long jD6 = bkx.d(strV, 19, 23);
            cna.i(23, strV);
            long j = (jD4 << 16) | (jD3 << 32) | jD5;
            long jD7 = bkx.d(strV, 24, 36) | (jD6 << 48);
            if (j != 0 || jD7 != 0) {
                return new eov(j, jD7);
            }
        }
        return eov.a;
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        eov eovVar = (eov) obj;
        bzo.q(eovVar, "value");
        avtVar.ad(eovVar.toString());
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
