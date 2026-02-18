package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpu implements dft {
    public final /* synthetic */ int a;
    public final dft b;
    public final IHasInvokeMethod c;

    public /* synthetic */ dpu(dft dftVar, IHasInvokeMethod bgfVar, int i) {
        this.a = i;
        this.b = dftVar;
        this.c = bgfVar;
    }

    @Override // me.hd.wauxv.obf.dft
    public final Iterator iterator() {
        switch (this.a) {
            case 0:
                return new baa(this);
            default:
                return new elf(this);
        }
    }
}
