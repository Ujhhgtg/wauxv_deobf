package me.hd.wauxv.obf;

import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class GenericMetadataIterator {
    public int b;
    public int c;
    public int d;
    public Object e;

    public GenericMetadataIterator() {
        if (dop.d == null) {
            dop.d = new dop(14);
        }
    }

    public int getVTableOffset(int i) {
        if (i < this.d) {
            return ((ByteBuffer) this.e).getShort(this.c + i);
        }
        return 0;
    }

    public void g() {
        if (((bzg) this.e).i != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object h(View view);

    public boolean hasNext() {
        return this.b < ((bzg) this.e).g;
    }

    public abstract void i(View view, Object obj);

    public void j() {
        while (true) {
            int i = this.b;
            bzg bzgVar = (bzg) this.e;
            if (i >= bzgVar.g || bzgVar.d[i] >= 0) {
                return;
            } else {
                this.b = i + 1;
            }
        }
    }

    public void setAccessibilityProperty(View view, Object obj) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.c) {
            i(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.c) {
            tag = dexFind(view);
        } else {
            tag = view.getTag(this.b);
            if (!((Class) this.e).isInstance(tag)) {
                tag = null;
            }
        }
        if (l(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateJ = ViewCompat.getAccessibilityDelegate(view);
            AccessibilityDelegateCompat aqVar = accessibilityDelegateJ == null ? null
                    : accessibilityDelegateJ instanceof AccessibilityDelegateCompat$AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat$AccessibilityDelegateAdapter) accessibilityDelegateJ).a
                            : new AccessibilityDelegateCompat(accessibilityDelegateJ);
            if (aqVar == null) {
                aqVar = new AccessibilityDelegateCompat();
            }
            ViewCompat.setAccessibilityDelegate(view, aqVar);
            view.setTag(this.b, obj);
            ViewCompat.notifyAccessibilityChange(view, this.d);
        }
    }

    public abstract boolean l(Object obj, Object obj2);

    public void remove() {
        bzg bzgVar = (bzg) this.e;
        g();
        if (this.c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        bzgVar.p();
        bzgVar.y(this.c);
        this.c = -1;
        this.d = bzgVar.i;
    }
}
