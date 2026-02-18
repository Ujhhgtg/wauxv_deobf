package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agz implements bzs {
    public final /* synthetic */ aha a;

    public agz(aha ahaVar) {
        this.a = ahaVar;
    }

    @Override // me.hd.wauxv.obf.bzs
    public final void b(chm chmVar, coi coiVar) {
        String str = ((dqe) coiVar).d;
        ((dll) chmVar.e).a.append(str);
        ArrayList arrayList = this.a.a;
        if (arrayList.isEmpty()) {
            return;
        }
        chmVar.ai();
        str.getClass();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
    }
}
