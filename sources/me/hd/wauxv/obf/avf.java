package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avf implements dln {
    public static final avf a = new avf();
    public final ArrayList b;

    public avf() {
        ArrayList arrayList = new ArrayList(1);
        this.b = arrayList;
        arrayList.add(ajn.aa(0, 5L));
    }

    @Override // me.hd.wauxv.obf.dln
    public final void i(int i) {
    }

    @Override // me.hd.wauxv.obf.dln
    public final List l(int i) {
        return new ArrayList(this.b);
    }

    @Override // me.hd.wauxv.obf.dln
    public final int n() {
        return 1;
    }
}
