package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rv implements cdv {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ rv(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.cdv
    public final boolean d(Object obj) {
        switch (this.a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }

    @Override // me.hd.wauxv.obf.cdv
    public final cdu e(Object obj, int i, int i2, crw crwVar) {
        switch (this.a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new cdu(new cpi(bArr), new cbc(bArr, 1, (nu) this.b));
            case 1:
                return new cdu(new cpi(obj), new ThumbStreamOpener(obj.toString(), (nu) this.b, 0));
            default:
                File file = (File) obj;
                return new cdu(new cpi(file), new ThumbStreamOpener(file, (SyntheticClass) this.b, 1));
        }
    }
}
