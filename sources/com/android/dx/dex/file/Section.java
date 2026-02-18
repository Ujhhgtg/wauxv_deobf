package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Section {
    private final int alignment;
    private final DexFile file;
    private int fileOffset;
    private final String name;
    private boolean prepared;

    public Section(String str, DexFile dexFile, int i) {
        if (dexFile == null) {
            throw new NullPointerException("file == null");
        }
        validateAlignment(i);
        this.name = str;
        this.file = dexFile;
        this.alignment = i;
        this.fileOffset = -1;
        this.prepared = false;
    }

    public static void validateAlignment(int i) {
        if (i <= 0 || (i & (i - 1)) != 0) {
            throw new IllegalArgumentException("invalid alignment");
        }
    }

    public final void align(AnnotatedOutput annotatedOutput) {
        annotatedOutput.alignTo(this.alignment);
    }

    public abstract int getAbsoluteItemOffset(Item item);

    public final int getAbsoluteOffset(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("relative < 0");
        }
        int i2 = this.fileOffset;
        if (i2 >= 0) {
            return i2 + i;
        }
        throw new RuntimeException("fileOffset not yet set");
    }

    public final int getAlignment() {
        return this.alignment;
    }

    public final DexFile getFile() {
        return this.file;
    }

    public final int getFileOffset() {
        int i = this.fileOffset;
        if (i >= 0) {
            return i;
        }
        throw new RuntimeException("fileOffset not set");
    }

    public final String getName() {
        return this.name;
    }

    public abstract Collection<? extends Item> items();

    public final void prepare() {
        throwIfPrepared();
        prepare0();
        this.prepared = true;
    }

    public abstract void prepare0();

    public final int setFileOffset(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("fileOffset < 0");
        }
        if (this.fileOffset >= 0) {
            throw new RuntimeException("fileOffset already set");
        }
        int i2 = this.alignment - 1;
        int i3 = (i + i2) & (~i2);
        this.fileOffset = i3;
        return i3;
    }

    public final void throwIfNotPrepared() {
        if (!this.prepared) {
            throw new RuntimeException("not prepared");
        }
    }

    public final void throwIfPrepared() {
        if (this.prepared) {
            throw new RuntimeException("already prepared");
        }
    }

    public abstract int writeSize();

    public final void writeTo(AnnotatedOutput annotatedOutput) {
        throwIfNotPrepared();
        align(annotatedOutput);
        int cursor = annotatedOutput.getCursor();
        int i = this.fileOffset;
        if (i < 0) {
            this.fileOffset = cursor;
        } else if (i != cursor) {
            throw new RuntimeException("alignment mismatch: for " + this + ", at " + cursor + ", but expected " + this.fileOffset);
        }
        if (annotatedOutput.annotates()) {
            if (this.name != null) {
                annotatedOutput.annotate(0, "\n" + this.name + ":");
            } else if (cursor != 0) {
                annotatedOutput.annotate(0, "\n");
            }
        }
        writeTo0(annotatedOutput);
    }

    public abstract void writeTo0(AnnotatedOutput annotatedOutput);
}
