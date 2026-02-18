package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Item {
    public abstract void addContents(DexFile dexFile);

    public abstract ItemType itemType();

    public final String typeName() {
        return itemType().toHuman();
    }

    public abstract int writeSize();

    public abstract void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput);
}
