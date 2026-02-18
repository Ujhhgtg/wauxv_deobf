package net.bytebuddy.matcher;

import android.R;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.matcher.FilterableList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface FilterableList<T, S extends FilterableList<T, S>> extends List<T> {

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static abstract class AbstractBase<T, S extends FilterableList<T, S>> extends AbstractList<T>
            implements FilterableList<T, S> {
        private static final int ONLY = 0;

        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            ArrayList arrayList = new ArrayList(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                R.color colorVar = (Object) it.next();
                if (elementMatcher.matches(colorVar)) {
                    arrayList.add(colorVar);
                }
            }
            return arrayList.size() == size() ? this : (S) wrap(arrayList);
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            if (size() == 1) {
                return get(0);
            }
            throw new IllegalStateException("size = " + size());
        }

        public abstract S wrap(List<T> list);

        @Override // java.util.AbstractList, java.util.List
        public S subList(int i, int i2) {
            return (S) wrap(super.subList(i, i2));
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class Empty<T, S extends FilterableList<T, S>> extends AbstractList<T>
            implements FilterableList<T, S> {
        @Override // net.bytebuddy.matcher.FilterableList
        public S filter(ElementMatcher<? super T> elementMatcher) {
            return this;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            throw new IndexOutOfBoundsException(concatVar2Var1(i, "index = "));
        }

        @Override // net.bytebuddy.matcher.FilterableList
        public T getOnly() {
            throw new IllegalStateException("size = 0");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractList, java.util.List
        public S subList(int i, int i2) {
            if (i == i2 && i2 == 0) {
                return this;
            }
            if (i <= i2) {
                throw new IndexOutOfBoundsException(concatVar2Var1(i, "fromIndex = "));
            }
            throw new IllegalArgumentException("fromIndex(" + i + ") > toIndex(" + i2 + ")");
        }
    }

    S filter(ElementMatcher<? super T> elementMatcher);

    T getOnly();

    @Override // java.util.List
    S subList(int i, int i2);
}
