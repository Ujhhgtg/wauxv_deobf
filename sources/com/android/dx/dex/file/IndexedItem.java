package com.android.dx.dex.file;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class IndexedItem extends Item {
    private int index = -1;

    public final int getIndex() {
        int i = this.index;
        if (i >= 0) {
            return i;
        }
        throw new RuntimeException("index not yet set");
    }

    public final boolean hasIndex() {
        return this.index >= 0;
    }

    public final String indexString() {
        return "[" + Integer.toHexString(this.index) + ']';
    }

    public final void setIndex(int i) {
        if (this.index != -1) {
            throw new RuntimeException("index already set");
        }
        this.index = i;
    }
}
