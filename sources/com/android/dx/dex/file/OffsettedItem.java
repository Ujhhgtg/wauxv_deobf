package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import me.hd.wauxv.obf.axc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class OffsettedItem extends Item implements Comparable<OffsettedItem> {
    private Section addedTo;
    private final int alignment;
    private int offset;
    private int writeSize;

    public OffsettedItem(int i, int i2) {
        Section.validateAlignment(i);
        if (i2 < -1) {
            throw new IllegalArgumentException("writeSize < -1");
        }
        this.alignment = i;
        this.writeSize = i2;
        this.addedTo = null;
        this.offset = -1;
    }

    public static int getAbsoluteOffsetOr0(OffsettedItem offsettedItem) {
        if (offsettedItem == null) {
            return 0;
        }
        return offsettedItem.getAbsoluteOffset();
    }

    public int compareTo0(OffsettedItem offsettedItem) {
        throw new UnsupportedOperationException("unsupported");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsettedItem offsettedItem = (OffsettedItem) obj;
        return itemType() == offsettedItem.itemType() && compareTo0(offsettedItem) == 0;
    }

    public final int getAbsoluteOffset() {
        int i = this.offset;
        if (i >= 0) {
            return this.addedTo.getAbsoluteOffset(i);
        }
        throw new RuntimeException("offset not yet known");
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final int getRelativeOffset() {
        int i = this.offset;
        if (i >= 0) {
            return i;
        }
        throw new RuntimeException("offset not yet known");
    }

    public final String offsetString() {
        return "[" + Integer.toHexString(getAbsoluteOffset()) + ']';
    }

    public final int place(Section section, int i) {
        if (section == null) {
            throw new NullPointerException("addedTo == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("offset < 0");
        }
        if (this.addedTo != null) {
            throw new RuntimeException("already written");
        }
        int i2 = this.alignment - 1;
        int i3 = (i + i2) & (~i2);
        this.addedTo = section;
        this.offset = i3;
        place0(section, i3);
        return i3;
    }

    public void place0(Section section, int i) {
    }

    public final void setWriteSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeSize < 0");
        }
        if (this.writeSize >= 0) {
            throw new UnsupportedOperationException("writeSize already set");
        }
        this.writeSize = i;
    }

    public abstract String toHuman();

    @Override // com.android.dx.dex.file.Item
    public final int writeSize() {
        int i = this.writeSize;
        if (i >= 0) {
            return i;
        }
        throw new UnsupportedOperationException("writeSize is unknown");
    }

    @Override // com.android.dx.dex.file.Item
    public final void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        annotatedOutput.alignTo(this.alignment);
        try {
            if (this.writeSize < 0) {
                throw new UnsupportedOperationException("writeSize is unknown");
            }
            annotatedOutput.assertCursor(getAbsoluteOffset());
            writeTo0(dexFile, annotatedOutput);
        } catch (RuntimeException e) {
            throw axc.withContext(e, "...while writing " + this);
        }
    }

    public abstract void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput);

    @Override // java.lang.Comparable
    public final int compareTo(OffsettedItem offsettedItem) {
        if (this == offsettedItem) {
            return 0;
        }
        ItemType itemType = itemType();
        ItemType itemType2 = offsettedItem.itemType();
        return itemType != itemType2 ? itemType.compareTo(itemType2) : compareTo0(offsettedItem);
    }
}
