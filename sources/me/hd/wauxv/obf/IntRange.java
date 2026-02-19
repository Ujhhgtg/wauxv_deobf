package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class IntRange extends KotlinIntProgression {
    public static final IntRange EMPTY_RANGE_INSTANCE = new IntRange(1, 0, 1);

    @Override // me.hd.wauxv.obf.bqf
    public final boolean equals(Object obj) {
        if (!(obj instanceof IntRange)) {
            return false;
        }
        if (isEmpty() && ((IntRange) obj).isEmpty()) {
            return true;
        }
        IntRange intRangeVar = (IntRange) obj;
        return this.first == intRangeVar.first && this.last == intRangeVar.last;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final boolean isEmpty() {
        return this.first > this.last;
    }

    @Override // me.hd.wauxv.obf.bqf
    public final String toString() {
        return this.first + ".." + this.last;
    }
}
