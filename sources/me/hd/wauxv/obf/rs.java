package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class rs {
    public final /* synthetic */ int a;

    public final int b(Object obj) {
        switch (this.a) {
            case 0:
                return ((byte[]) obj).length;
            default:
                return ((int[]) obj).length;
        }
    }

    public final int c() {
        switch (this.a) {
            case 0:
                return 1;
            default:
                return 4;
        }
    }

    public final String d() {
        switch (this.a) {
            case 0:
                return "ByteArrayPool";
            default:
                return "IntegerArrayPool";
        }
    }
}
