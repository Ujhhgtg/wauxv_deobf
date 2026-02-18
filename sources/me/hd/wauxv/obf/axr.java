package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axr extends erp {
    public final /* synthetic */ axs m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public axr(axs axsVar) {
        super(1);
        this.m = axsVar;
    }

    @Override // me.hd.wauxv.obf.erp
    public final bd n(int i) {
        return new bd(AccessibilityNodeInfo.obtain(this.m.am(i).a));
    }

    @Override // me.hd.wauxv.obf.erp
    public final bd o(int i) {
        axs axsVar = this.m;
        int i2 = i == 2 ? axsVar.ad : axsVar.ae;
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        return n(i2);
    }

    @Override // me.hd.wauxv.obf.erp
    public final boolean p(int i, int i2, Bundle bundle) {
        int i3;
        axs axsVar = this.m;
        View view = axsVar.ab;
        if (i == -1) {
            WeakHashMap weakHashMap = eqz.a;
            return view.performAccessibilityAction(i2, bundle);
        }
        if (i2 == 1) {
            return axsVar.an(i);
        }
        if (i2 == 2) {
            return axsVar.ag(i);
        }
        if (i2 != 64) {
            if (i2 != 128) {
                return axsVar.q(i, i2, bundle);
            }
            if (axsVar.ad != i) {
                return false;
            }
            axsVar.ad = Integer.MIN_VALUE;
            view.invalidate();
            axsVar.ao(i, 65536);
            return true;
        }
        AccessibilityManager accessibilityManager = axsVar.aa;
        if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled() || (i3 = axsVar.ad) == i) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            axsVar.ad = Integer.MIN_VALUE;
            view.invalidate();
            axsVar.ao(i3, 65536);
        }
        axsVar.ad = i;
        view.invalidate();
        axsVar.ao(i, 32768);
        return true;
    }
}
