package me.hd.wauxv.obf;

import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class czn {
    public SparseArray a;
    public int b;
    public Set c;

    public final czm d(int i) {
        SparseArray sparseArray = this.a;
        czm czmVar = (czm) sparseArray.get(i);
        if (czmVar != null) {
            return czmVar;
        }
        czm czmVar2 = new czm();
        sparseArray.put(i, czmVar2);
        return czmVar2;
    }
}
