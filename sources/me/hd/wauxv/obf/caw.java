package me.hd.wauxv.obf;

import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class caw extends bht {
    public final /* synthetic */ int a;

    public /* synthetic */ caw(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bht
    public final int[] aj() {
        switch (this.a) {
            case 0:
                break;
        }
        return new int[]{3, 4, 2, 1};
    }

    @Override // me.hd.wauxv.obf.bht
    public final int ak(boolean z) {
        switch (this.a) {
            case 0:
                return z ? R.layout.layout_dialogx_material : R.layout.layout_dialogx_material_dark;
            default:
                return z ? R.layout.layout_dialogx_material_you : R.layout.layout_dialogx_material_you_dark;
        }
    }

    @Override // me.hd.wauxv.obf.bht
    public final bhs al() {
        switch (this.a) {
            case 0:
                return new cav(0);
            default:
                return new cav(1);
        }
    }
}
