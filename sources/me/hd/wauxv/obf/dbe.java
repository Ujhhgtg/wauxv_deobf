package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.List;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dbe extends doo implements bng {
    public static final dbe a = new dbe(cnb.z(-522134879206186L));
    public static final String b = cnb.z(-519935855950634L);
    public static final String c = cnb.z(-519957330787114L);
    public static final String i = cnb.z(-519910086146858L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        Iterator it = aba.ag(dbc.a, dbd.a, dbb.a, dba.a).iterator();
        while (it.hasNext()) {
            List listBf = dqc.bf(emn.bb((amn) it.next()));
            dbe dbeVar = a;
            aki akiVarAb = csb.ab(dbeVar, listBf);
            dbeVar.y(akiVarAb, new cvc(27));
            akiVarAb.o();
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(dbc.a, dexKitBridge, new daz(0, cnb.z(-522083339598634L), cnb.z(-521353195158314L)));
        emn.aj(dbd.a, dexKitBridge, new daz(0, cnb.z(-521658137836330L), cnb.z(-521516403915562L)));
        emn.aj(dbb.a, dexKitBridge, new daz(0, cnb.z(-522942333057834L), cnb.z(-523350354950954L)));
        emn.aj(dba.a, dexKitBridge, new daz(0, (cnb.ab(ewk.f) || cnb.ac(ewh.f)) ? cnb.z(-523127016651562L) : cnb.z(-522418347047722L), cnb.z(-522766239398698L)));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
