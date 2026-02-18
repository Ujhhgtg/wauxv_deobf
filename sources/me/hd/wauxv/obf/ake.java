package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ake implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public /* synthetic */ ake(String str, int i) {
        this.a = i;
        this.b = str;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                return "val." /* cnb.z(-5510443039530L) */ + this.b;
            default:
                String str = this.b;
                throwIfVar1IsNull(str, "uriPattern");
                return new cjd(str, null, null);
        }
    }
}
