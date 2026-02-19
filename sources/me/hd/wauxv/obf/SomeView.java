package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SomeView {
    public static final List c = Collections.EMPTY_LIST;
    public final View d;
    public WeakReference e;
    public int m;
    public androidx.recyclerview.widget.RecyclerView u;
    public cyw v;
    public int f = -1;
    public int g = -1;
    public long h = -1;
    public int i = -1;
    public int j = -1;
    public SomeView k = null;
    public SomeView l = null;
    public final ArrayList n = null;
    public final List o = null;
    public int p = 0;
    public RecyclerView q = null;
    public boolean r = false;
    public int s = 0;
    public int t = -1;

    public SomeView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("itemView may not be null");
        }
        this.d = view;
    }

    public final List aa() {
        ArrayList arrayList;
        return ((this.m & 1024) != 0 || (arrayList = this.n) == null || arrayList.size() == 0) ? c : this.o;
    }

    public final boolean ab() {
        View view = this.d;
        return (view.getParent() == null || view.getParent() == this.u) ? false : true;
    }

    public final boolean ac() {
        return (this.m & 1) != 0;
    }

    public final boolean ad() {
        return (this.m & 4) != 0;
    }

    public final boolean ae() {
        if ((this.m & 16) != 0) {
            return false;
        }
        WeakHashMap weakHashMap = ViewCompat.a;
        return !this.d.hasTransientState();
    }

    public final boolean af() {
        return (this.m & 8) != 0;
    }

    public final boolean ag() {
        return this.q != null;
    }

    public final boolean ah() {
        return (this.m & 256) != 0;
    }

    public final boolean ai() {
        return (this.m & 2) != 0;
    }

    public final void aj(int i, boolean z) {
        if (this.g == -1) {
            this.g = this.f;
        }
        if (this.j == -1) {
            this.j = this.f;
        }
        if (z) {
            this.j += i;
        }
        this.f += i;
        View view = this.d;
        if (view.getLayoutParams() != null) {
            ((czh) view.getLayoutParams()).e = true;
        }
    }

    public final void ak() {
        if (androidx.recyclerview.widget.RecyclerView.a && ah()) {
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }
        this.m = 0;
        this.f = -1;
        this.g = -1;
        this.h = -1L;
        this.j = -1;
        this.p = 0;
        this.k = null;
        this.l = null;
        ArrayList arrayList = this.n;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.m &= -1025;
        this.s = 0;
        this.t = -1;
        androidx.recyclerview.widget.RecyclerView.cp(this);
    }

    public final void al(boolean z) {
        int i = this.p;
        int i2 = z ? i - 1 : i + 1;
        this.p = i2;
        if (i2 < 0) {
            this.p = 0;
            if (androidx.recyclerview.widget.RecyclerView.a) {
                throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            }
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        } else if (!z && i2 == 1) {
            this.m |= 16;
        } else if (z && i2 == 0) {
            this.m &= -17;
        }
        if (androidx.recyclerview.widget.RecyclerView.b) {
            Log.d("RecyclerView", "setIsRecyclable val:" + z + ":" + this);
        }
    }

    public final boolean am() {
        return (this.m & 128) != 0;
    }

    public final boolean an() {
        return (this.m & 32) != 0;
    }

    public final String toString() {
        StringBuilder sbR = concat(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
        sbR.append(Integer.toHexString(hashCode()));
        sbR.append(" position=");
        sbR.append(this.f);
        sbR.append(" id=");
        sbR.append(this.h);
        sbR.append(", oldPos=");
        sbR.append(this.g);
        sbR.append(", pLpos:");
        sbR.append(this.j);
        StringBuilder sb = new StringBuilder(sbR.toString());
        if (ag()) {
            sb.append(" scrap ");
            sb.append(this.r ? "[changeScrap]" : "[attachedScrap]");
        }
        if (ad()) {
            sb.append(" invalid");
        }
        if (!ac()) {
            sb.append(" unbound");
        }
        if ((this.m & 2) != 0) {
            sb.append(" update");
        }
        if (af()) {
            sb.append(" removed");
        }
        if (am()) {
            sb.append(" ignored");
        }
        if (ah()) {
            sb.append(" tmpDetached");
        }
        if (!ae()) {
            sb.append(" not recyclable(" + this.p + ")");
        }
        if ((this.m & 512) != 0 || ad()) {
            sb.append(" undefined adapter position");
        }
        if (this.d.getParent() == null) {
            sb.append(" no parent");
        }
        sb.append("}");
        return sb.toString();
    }

    public final void w(int i) {
        this.m = i | this.m;
    }

    public final int x() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.u;
        if (recyclerView == null) {
            return -1;
        }
        return recyclerView.dt(this);
    }

    public final int y() {
        androidx.recyclerview.widget.RecyclerView recyclerView;
        cyw adapter;
        int iDt;
        if (this.v == null || (recyclerView = this.u) == null || (adapter = recyclerView.getAdapter()) == null || (iDt = this.u.dt(this)) == -1 || this.v != adapter) {
            return -1;
        }
        return iDt;
    }

    public final int z() {
        int i = this.j;
        return i == -1 ? this.f : i;
    }
}
