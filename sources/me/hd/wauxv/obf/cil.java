package me.hd.wauxv.obf;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cil implements Comparator {
    public static final cil a = new cil(0);
    public static final cil b = new cil(1);
    public final /* synthetic */ int c;

    public /* synthetic */ cil(int i) {
        this.c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                bzo.q(comparable, com.umeng.analytics.pro.bt.at);
                bzo.q(comparable2, "b");
                return comparable.compareTo(comparable2);
            default:
                Comparable comparable3 = (Comparable) obj;
                Comparable comparable4 = (Comparable) obj2;
                bzo.q(comparable3, com.umeng.analytics.pro.bt.at);
                bzo.q(comparable4, "b");
                return comparable4.compareTo(comparable3);
        }
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        switch (this.c) {
            case 0:
                return b;
            default:
                return a;
        }
    }
}
