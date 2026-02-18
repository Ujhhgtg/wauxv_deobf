package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pn {
    public final /* synthetic */ int a;

    public /* synthetic */ pn(int i) {
        this.a = i;
    }

    public final Object b(blq blqVar, aji ajiVar) {
        switch (this.a) {
            case 0:
                return new pm((bzr) blqVar.a, 0);
            case 1:
                return new aai((bzr) blqVar.a);
            case 2:
                return new aaq((bzr) blqVar.a);
            case 3:
                return new auw(0);
            case 4:
                return new bkn((bzr) blqVar.a, ((Integer) cmz.d.b(ajiVar)).intValue());
            case 5:
                return new bvr((bzr) blqVar.a, (String) cmz.e.b(ajiVar), (awp) blqVar.c);
            case 6:
                bzr bzrVar = (bzr) blqVar.a;
                return ahb.a == cmz.a.b(ajiVar) ? new rr(bzrVar, ((Integer) cmz.b.b(ajiVar)).intValue()) : new cry(bzrVar, String.valueOf(cmz.c.b(ajiVar)).concat(". "));
            case 7:
                return new auw(1);
            default:
                return new pm((bzr) blqVar.a, 1);
        }
    }
}
