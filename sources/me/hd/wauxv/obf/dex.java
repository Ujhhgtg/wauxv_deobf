package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dex extends t implements ahr {
    public final doi aq;

    public dex(ahh ahhVar, doi doiVar) {
        super(ahhVar, true);
        this.aq = doiVar;
    }

    @Override // me.hd.wauxv.obf.brm
    public final boolean ah() {
        return true;
    }

    public void ar() {
    }

    @Override // me.hd.wauxv.obf.brm
    public void j(Object obj) {
        HugeSyntheticPileOfHelpers.resumeCoroutine(aye.x(obj), cmz.ab(this.aq));
    }

    @Override // me.hd.wauxv.obf.ahr
    public final ahr k() {
        doi doiVar = this.aq;
        if (doiVar != null) {
            return doiVar;
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.brm
    public void l(Object obj) {
        this.aq._bn(aye.x(obj));
    }
}
