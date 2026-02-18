package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjf implements Comparable {
    public final cjg a;
    public final Bundle b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final int f;

    public cjf(cjg cjgVar, Bundle bundle, boolean z, int i, boolean z2, int i2) {
        this.a = cjgVar;
        this.b = bundle;
        this.c = z;
        this.d = i;
        this.e = z2;
        this.f = i2;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final int compareTo(cjf cjfVar) {
        bzo.q(cjfVar, "other");
        boolean z = cjfVar.e;
        boolean z2 = cjfVar.c;
        Bundle bundle = cjfVar.b;
        boolean z3 = this.c;
        if (z3 && !z2) {
            return 1;
        }
        if (!z3 && z2) {
            return -1;
        }
        int i = this.d - cjfVar.d;
        if (i > 0) {
            return 1;
        }
        if (i < 0) {
            return -1;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null && bundle == null) {
            return 1;
        }
        if (bundle2 == null && bundle != null) {
            return -1;
        }
        if (bundle2 != null) {
            bzo.q(bundle2, "source");
            int size = bundle2.size();
            bzo.n(bundle);
            int size2 = size - bundle.size();
            if (size2 > 0) {
                return 1;
            }
            if (size2 < 0) {
                return -1;
            }
        }
        boolean z4 = this.e;
        if (z4 && !z) {
            return 1;
        }
        if (z4 || !z) {
            return this.f - cjfVar.f;
        }
        return -1;
    }
}
