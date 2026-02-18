package me.hd.wauxv.obf;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dll implements Appendable, CharSequence {
    public final ArrayDeque b = new ArrayDeque(8);
    public final StringBuilder a = new StringBuilder((CharSequence) "");

    public dll() {
        e(0, "");
    }

    public static void c(dll dllVar, Object obj, int i, int i2) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                dllVar.b.push(new dli(obj, i, i2, 33));
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                c(dllVar, obj2, i, i2);
            }
        }
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        this.a.append(c);
        return this;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.a.charAt(i);
    }

    public final void d(char c) {
        this.a.append(c);
    }

    public final void e(int i, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z = spanned instanceof dlj;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                ArrayDeque arrayDeque = this.b;
                if (!z) {
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = spans[i2];
                        arrayDeque.push(new dli(obj, spanned.getSpanStart(obj) + i, spanned.getSpanEnd(obj) + i, spanned.getSpanFlags(obj)));
                    }
                    return;
                }
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    Object obj2 = spans[i3];
                    arrayDeque.push(new dli(obj2, spanned.getSpanStart(obj2) + i, spanned.getSpanEnd(obj2) + i, spanned.getSpanFlags(obj2)));
                }
            }
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.a.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        List<dli> listUnmodifiableList;
        int i3;
        StringBuilder sb = this.a;
        int length = sb.length();
        if (i2 <= i || i < 0 || i2 > length) {
            listUnmodifiableList = Collections.EMPTY_LIST;
        } else {
            ArrayDeque arrayDeque = this.b;
            if (i == 0 && length == i2) {
                ArrayList arrayList = new ArrayList(arrayDeque);
                Collections.reverse(arrayList);
                listUnmodifiableList = Collections.unmodifiableList(arrayList);
            } else {
                ArrayList arrayList2 = new ArrayList(0);
                Iterator itDescendingIterator = arrayDeque.descendingIterator();
                while (itDescendingIterator.hasNext()) {
                    dli dliVar = (dli) itDescendingIterator.next();
                    int i4 = dliVar.b;
                    if ((i4 >= i && i4 < i2) || (((i3 = dliVar.c) <= i2 && i3 > i) || (i4 < i && i3 > i2))) {
                        arrayList2.add(dliVar);
                    }
                }
                listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            return sb.subSequence(i, i2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.subSequence(i, i2));
        int length2 = spannableStringBuilder.length();
        for (dli dliVar2 : listUnmodifiableList) {
            int iMax = Math.max(0, dliVar2.b - i);
            spannableStringBuilder.setSpan(dliVar2.a, iMax, Math.min(length2, (dliVar2.c - dliVar2.b) + iMax), dliVar2.d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.a.toString();
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        StringBuilder sb = this.a;
        e(sb.length(), charSequenceSubSequence);
        sb.append(charSequenceSubSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        StringBuilder sb = this.a;
        e(sb.length(), charSequence);
        sb.append(charSequence);
        return this;
    }
}
