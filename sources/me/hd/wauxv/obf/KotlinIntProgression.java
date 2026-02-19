package me.hd.wauxv.obf;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class KotlinIntProgression implements Iterable {
    public final int first;
    public final int last;
    public final int step;

    public KotlinIntProgression(int first, int last, int step) {
        if (step == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (step == Integer.MIN_VALUE) {
            throw new IllegalArgumentException(
                    "Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.first = first;
        this.last = KotlinHelpers2.getProgressionLastElement(first, last, step);
        this.step = step;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof KotlinIntProgression)) {
            return false;
        }
        if (isEmpty() && ((KotlinIntProgression) obj).isEmpty()) {
            return true;
        }
        KotlinIntProgression intRangeVar = (KotlinIntProgression) obj;
        return this.first == intRangeVar.first && this.last == intRangeVar.last && this.step == intRangeVar.step;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.first * 31) + this.last) * 31) + this.step;
    }

    public boolean isEmpty() {
        int i = this.step;
        int i2 = this.last;
        int i3 = this.first;
        return i > 0 ? i3 > i2 : i3 < i2;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new bqg(this.first, this.last, this.step);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.last;
        int i2 = this.first;
        int i3 = this.step;
        if (i3 > 0) {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i3);
        }
        return sb.toString();
    }
}
