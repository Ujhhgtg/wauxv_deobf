package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afq extends dqt {
    public final aff a;

    public afq(aff affVar) {
        super(0, affVar.length(), affVar);
        this.a = affVar;
    }

    @Override // me.hd.wauxv.obf.dqt, java.lang.CharSequence
    public final char charAt(int i) {
        f();
        return this.a.charAt(i);
    }
}
