package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvo extends coi {
    public final String d;
    public final String e;

    public bvo(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    @Override // me.hd.wauxv.obf.coi
    public final void c(chm chmVar) {
        chmVar.aw(this);
    }

    @Override // me.hd.wauxv.obf.coi
    public final String f() {
        return "destination=" + this.d + ", title=" + this.e;
    }
}
