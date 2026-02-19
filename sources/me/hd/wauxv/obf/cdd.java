package me.hd.wauxv.obf;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdd {
    public final SparseArray a;
    public EmojiMetadata b;

    public cdd(int i) {
        this.a = new SparseArray(i);
    }

    public final void c(EmojiMetadata emojiMetadataVar, int i, int i2) {
        int iE = emojiMetadataVar.e(i);
        SparseArray sparseArray = this.a;
        cdd cddVar = sparseArray == null ? null : (cdd) sparseArray.get(iE);
        if (cddVar == null) {
            cddVar = new cdd(1);
            sparseArray.put(emojiMetadataVar.e(i), cddVar);
        }
        if (i2 > i) {
            cddVar.c(emojiMetadataVar, i + 1, i2);
        } else {
            cddVar.b = emojiMetadataVar;
        }
    }
}
