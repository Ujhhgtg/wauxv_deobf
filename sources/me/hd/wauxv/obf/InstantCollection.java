package me.hd.wauxv.obf;

import android.view.ViewGroup;
import java.text.Bidi;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class InstantCollection implements TimestampDataSource {
    public final Object instantBuilders;

    public /* synthetic */ InstantCollection(Object obj) {
        this.instantBuilders = obj;
    }

    @Override // me.hd.wauxv.obf.bnh
    public int size() {
        return ((InstantBuilder[]) this.instantBuilders).length;
    }

    @Override // me.hd.wauxv.obf.bnh
    public int getHighBits(int i) {
        return (int) (((InstantBuilder[]) this.instantBuilders)[i].seconds >> 32);
    }

    @Override // me.hd.wauxv.obf.bnh
    public int getLowBits(int i) {
        return (int) (((InstantBuilder[]) this.instantBuilders)[i].seconds & 4294967295L);
    }

    @Override // me.hd.wauxv.obf.bnh
    public boolean f(int i) {
        return (((InstantBuilder[]) this.instantBuilders)[i].nanoAdjustment & 1) != 0;
    }

    public InstantCollection(ViewGroup viewGroup) {
        this.instantBuilders = viewGroup.getOverlay();
    }

    public InstantCollection(anu anuVar) {
        long[] jArr = anuVar.a;
        long[] jArr2 = anuVar.a;
        int length = jArr.length;
        this.instantBuilders = new InstantBuilder[length];
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (jArr2[i] & 4294967295L);
            InstantBuilder[] bpzVarArr = (InstantBuilder[]) this.instantBuilders;
            long jAl = KotlinHelpers.al(anuVar.getHighBits(i), anuVar.getLowBits(i));
            int i2 = (int) (4294967295L & jArr2[i]);
            InstantBuilder bpzVar = new InstantBuilder();
            bpzVar.seconds = jAl;
            bpzVar.nanoAdjustment = i2;
            bpzVarArr[i] = bpzVar;
        }
        Bidi.reorderVisually(bArr, 0, (InstantBuilder[]) this.instantBuilders, 0, length);
    }
}
