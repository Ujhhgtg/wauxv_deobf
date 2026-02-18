package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class brn {
    public static final brn a = new brn();
    public final brt b;
    public final cbm c;
    public final erp d;

    public brn() {
        brt brtVar = new brt();
        cbm cbmVar = bhs.g;
        this.b = brtVar;
        this.c = cbmVar;
        this.d = new erp(14);
    }

    public final Object e(ko koVar, String str) {
        this.b.getClass();
        yi yiVar = new yi(str);
        Object objT = new dmx(this, ewf.a, yiVar, (kl) koVar.k).t(koVar);
        if (yiVar.n() == 10) {
            return objT;
        }
        yi.g(yiVar, "Expected EOF after parsing, but had " + str.charAt(yiVar.b - 1) + " instead", 0, null, 6);
        throw null;
    }

    public final String f(ko koVar, Object obj) {
        char[] cArr;
        ek ekVar = new ek((char) 0, 9);
        tz tzVar = tz.a;
        synchronized (tzVar) {
            km kmVar = (km) tzVar.c;
            cArr = null;
            char[] cArr2 = (char[]) (kmVar.isEmpty() ? null : kmVar.removeLast());
            if (cArr2 != null) {
                tzVar.b -= cArr2.length;
                cArr = cArr2;
            }
        }
        if (cArr == null) {
            cArr = new char[128];
        }
        ekVar.d = cArr;
        try {
            ewf ewfVar = ewf.a;
            dmy[] dmyVarArr = new dmy[ewf.f.a()];
            this.b.getClass();
            new dmy(new cxc(ekVar), this, ewfVar, dmyVarArr).x(koVar, obj);
            return ekVar.toString();
        } finally {
            ekVar.p();
        }
    }
}
