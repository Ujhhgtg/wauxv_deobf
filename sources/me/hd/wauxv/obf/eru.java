package me.hd.wauxv.obf;

import android.view.ViewGroup;
import java.text.Bidi;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eru implements bnh {
    public final Object a;

    public /* synthetic */ eru(Object obj) {
        this.a = obj;
    }

    @Override // me.hd.wauxv.obf.bnh
    public int c() {
        return ((bpz[]) this.a).length;
    }

    @Override // me.hd.wauxv.obf.bnh
    public int d(int i) {
        return (int) (((bpz[]) this.a)[i].a >> 32);
    }

    @Override // me.hd.wauxv.obf.bnh
    public int e(int i) {
        return (int) (((bpz[]) this.a)[i].a & 4294967295L);
    }

    @Override // me.hd.wauxv.obf.bnh
    public boolean f(int i) {
        return (((bpz[]) this.a)[i].b & 1) != 0;
    }

    public eru(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    public eru(anu anuVar) {
        long[] jArr = anuVar.a;
        long[] jArr2 = anuVar.a;
        int length = jArr.length;
        this.a = new bpz[length];
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (jArr2[i] & 4294967295L);
            bpz[] bpzVarArr = (bpz[]) this.a;
            long jAl = bzo.al(anuVar.d(i), anuVar.e(i));
            int i2 = (int) (4294967295L & jArr2[i]);
            bpz bpzVar = new bpz();
            bpzVar.a = jAl;
            bpzVar.b = i2;
            bpzVarArr[i] = bpzVar;
        }
        Bidi.reorderVisually(bArr, 0, (bpz[]) this.a, 0, length);
    }
}
