package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AnnotationSetRefItem extends OffsettedItem {
    private static final int ALIGNMENT = 4;
    private static final int WRITE_SIZE = 4;
    private AnnotationSetItem annotations;

    public AnnotationSetRefItem(AnnotationSetItem annotationSetItem) {
        super(4, 4);
        if (annotationSetItem == null) {
            throw new NullPointerException("annotations == null");
        }
        this.annotations = annotationSetItem;
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        this.annotations = (AnnotationSetItem) dexFile.getWordData().intern(this.annotations);
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_ANNOTATION_SET_REF_ITEM;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public String toHuman() {
        return this.annotations.toHuman();
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int absoluteOffset = this.annotations.getAbsoluteOffset();
        if (annotatedOutput.annotates()) {
            dkz.ab(absoluteOffset, new StringBuilder("  annotations_off: "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(absoluteOffset);
    }
}
