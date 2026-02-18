package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aha {
    public final ArrayList a = new ArrayList(0);

    public static void b(chm chmVar, String str, String str2, pd pdVar) {
        chmVar.y();
        int iAi = chmVar.ai();
        dll dllVar = (dll) chmVar.e;
        StringBuilder sb = dllVar.a;
        sb.append((char) 160);
        sb.append('\n');
        ((dop) ((blq) chmVar.c).b).getClass();
        dllVar.e(sb.length(), str2);
        sb.append((CharSequence) str2);
        chmVar.y();
        dllVar.d((char) 160);
        cmz.g.c((aji) chmVar.d, str);
        chmVar.at(pdVar, iAi);
        chmVar.u(pdVar);
    }
}
