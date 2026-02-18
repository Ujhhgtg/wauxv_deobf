package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ent implements cdv {
    public static final ent a = new ent(0);
    public final /* synthetic */ int b;

    public /* synthetic */ ent(int i) {
        this.b = i;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        switch (this.b) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        switch (this.b) {
            case 0:
                return new cdu(new cpi(obj), new sa(obj, 1));
            case 1:
                File file = (File) obj;
                return new cdu(new cpi(file), new sa(file, 0));
            default:
                return null;
        }
    }
}
