package com.android.dx.dex.file;

import com.android.dx.dex.file.OffsettedItem;
import com.android.dx.util.AnnotatedOutput;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class UniformListItem<T extends OffsettedItem> extends OffsettedItem {
    private static final int HEADER_SIZE = 4;
    private final ItemType itemType;
    private final List<T> items;

    public UniformListItem(ItemType itemType, List<T> list) {
        super(getAlignment(list), writeSize(list));
        if (itemType == null) {
            throw new NullPointerException("itemType == null");
        }
        this.items = list;
        this.itemType = itemType;
    }

    private static int getAlignment(List<? extends OffsettedItem> list) {
        try {
            return Math.max(4, list.get(0).getAlignment());
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("items.size() == 0");
        } catch (NullPointerException unused2) {
            throw new NullPointerException("items == null");
        }
    }

    private int headerSize() {
        return getAlignment();
    }

    private static int writeSize(List<? extends OffsettedItem> list) {
        OffsettedItem offsettedItem = list.get(0);
        return (offsettedItem.writeSize() * list.size()) + getAlignment(list);
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            it.next().addContents(dexFile);
        }
    }

    public final List<T> getItems() {
        return this.items;
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return this.itemType;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void place0(Section section, int i) {
        int iHeaderSize = i + headerSize();
        boolean z = true;
        int i2 = -1;
        int alignment = -1;
        for (T t : this.items) {
            int iWriteSize = t.writeSize();
            if (z) {
                alignment = t.getAlignment();
                z = false;
                i2 = iWriteSize;
            } else {
                if (iWriteSize != i2) {
                    throw new UnsupportedOperationException("item size mismatch");
                }
                if (t.getAlignment() != alignment) {
                    throw new UnsupportedOperationException("item alignment mismatch");
                }
            }
            iHeaderSize = t.place(section, iHeaderSize) + iWriteSize;
        }
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public final String toHuman() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{");
        boolean z = true;
        for (T t : this.items) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(t.toHuman());
        }
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(UniformListItem.class.getName());
        sb.append(this.items);
        return sb.toString();
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int size = this.items.size();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, offsetString() + " " + typeName());
            dkz.ab(size, new StringBuilder("  size: "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(size);
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            it.next().writeTo(dexFile, annotatedOutput);
        }
    }
}
