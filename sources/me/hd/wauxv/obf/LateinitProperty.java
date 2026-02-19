package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class LateinitProperty implements ajh {
    public static LateinitProperty a;
    public final /* synthetic */ int b;
    public Object e;

    public /* synthetic */ LateinitProperty(Object obj, int i) {
        this.b = i;
        this.e = obj;
    }

    public static LateinitProperty f(int i, int i2, int i3) {
        return new LateinitProperty(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, false, i3), 0);
    }

    public static LateinitProperty g(int i, int i2, int i3, int i4, boolean z) {
        return new LateinitProperty(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z), 1);
    }

    @Override // me.hd.wauxv.obf.ajh
    public void c() {
    }

    @Override // me.hd.wauxv.obf.ajh
    public Object d() {
        return this.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object h(IEmpty7 btcVar) {
        throwIfVar1IsNull(btcVar, "property");
        Object obj = this.e;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(
                yg.concatToVar1(new StringBuilder("Property "), ((sw) btcVar).f, " should be initialized before get."));
    }

    public void i(IEmpty7 btcVar, Object obj) {
        throwIfVar1IsNull(btcVar, "property");
        throwIfVar1IsNull(obj, "value");
        this.e = obj;
    }

    public String toString() {
        String str;
        switch (this.b) {
            case 4:
                StringBuilder sb = new StringBuilder("NotNullProperty(");
                if (this.e != null) {
                    str = "value=" + this.e;
                } else {
                    str = "value not initialized yet";
                }
                return concat(sb, str, ')');
            default:
                return super.toString();
        }
    }

    public LateinitProperty(int i) {
        this.b = i;
        if (i == 5) {
            this.e = new Object();
            new Handler(Looper.getMainLooper(), new bhg(this, 1));
        }
    }
}
