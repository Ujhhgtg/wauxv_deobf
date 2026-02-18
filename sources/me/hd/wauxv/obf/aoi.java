package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aoi {
    public static final aoi a = new aoi(0);
    public static final aoi b = new aoi(1);
    public static final aoi c = new aoi(2);
    public final /* synthetic */ int d;

    public /* synthetic */ aoi(int i) {
        this.d = i;
    }

    public final boolean e(int i) {
        switch (this.d) {
            case 0:
                return false;
            case 1:
                return (i == 3 || i == 5) ? false : true;
            default:
                return i == 2;
        }
    }
}
