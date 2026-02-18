package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zd {
    public final String a;
    public final ArrayList b;
    public final HashSet c;
    public final ArrayList d;
    public final ArrayList e;
    public final ArrayList f;

    public zd(String str) {
        bzo.q(str, "serialName");
        this.a = str;
        this.b = new ArrayList();
        this.c = new HashSet();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
    }

    public static void g(zd zdVar, String str, dfx dfxVar) {
        zdVar.getClass();
        bzo.q(dfxVar, "descriptor");
        if (!zdVar.c.add(str)) {
            StringBuilder sbZ = dkz.z("Element with name '", str, "' is already registered in ");
            sbZ.append(zdVar.a);
            throw new IllegalArgumentException(sbZ.toString().toString());
        }
        zdVar.b.add(str);
        zdVar.d.add(dfxVar);
        zdVar.e.add(avd.a);
        zdVar.f.add(false);
    }
}
