package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ael {
    public final aek a;
    public boolean b;
    public final ArrayList c = new ArrayList();
    public final LinkedHashMap d = new LinkedHashMap();
    public final ArrayList e = new ArrayList();
    public String f = cnb.z(-395502063450922L);
    public int g = R.drawable.ic_contact_confirm_24dp;
    public final String h = cnb.z(-395514948352810L);
    public final int i = R.drawable.ic_contact_cancel_24dp;
    public String j = cnb.z(-395450523843370L);
    public final act k = new act(16);
    public bgj l = new fq(2);

    public ael(aek aekVar) {
        this.a = aekVar;
    }

    public final void m(String str, ArrayList arrayList) {
        this.d.put(str, arrayList);
        this.e.addAll(arrayList);
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0012  */
    public final ArrayList n() {
        ArrayList<adx> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (this.b) {
            arrayList = this.c;
            if (arrayList.isEmpty()) {
                arrayList = this.e;
            }
        } else {
            arrayList = this.e;
        }
        for (adx adxVar : arrayList) {
            if (adxVar.d) {
                arrayList2.add(adxVar);
            }
        }
        return arrayList2;
    }
}
