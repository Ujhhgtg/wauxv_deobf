package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ue implements Iterable, bsw {
    public final char a = (char) cnd.av(1, 0, 1);
    public final int b = 1;

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new uf(this.a, this.b);
    }
}
