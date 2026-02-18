package me.hd.wauxv.obf;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bym extends bws implements bng {
    public static final bym a = new bym();

    public static String b(String str, boolean z) {
        Object objInvoke = emn.bb(byl.a).invoke(null, str);
        String string = objInvoke instanceof String ? (String) objInvoke : null;
        if (string != null) {
            String strZ = "/" /* cnb.z(-374168960891690L) */;
            String strZ2 = cnb.z(z ? -374177550826282L : -374117421284138L);
            int iAl = dnj.al(6, string, strZ);
            if (iAl != -1) {
                int length = strZ.length() + iAl;
                int length2 = string.length();
                if (length2 < length) {
                    throw new IndexOutOfBoundsException("End index (" + length2 + ") is less than start index (" + length + ").");
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) string, 0, length);
                sb.append((CharSequence) strZ2);
                sb.append((CharSequence) string, length2, string.length());
                string = sb.toString();
            }
            if (string != null) {
                return string;
            }
        }
        return "" /* cnb.z(-374134601153322L) */;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(byl.a, dexKitBridge, new bty(16));
    }
}
