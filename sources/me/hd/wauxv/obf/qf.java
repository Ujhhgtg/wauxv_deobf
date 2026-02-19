package me.hd.wauxv.obf;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class qf {
    public final /* synthetic */ int a;
    public int b;
    public boolean c;
    public final Runnable d;
    public final /* synthetic */ agr e;

    public qf(SideSheetBehavior sideSheetBehavior) {
        this.a = 1;
        this.e = sideSheetBehavior;
        this.d = new dh(this, 17);
    }

    public final void f(int i) {
        int i2 = this.a;
        Runnable runnable = this.d;
        agr agrVar = this.e;
        switch (i2) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) agrVar;
                WeakReference weakReference = bottomSheetBehavior.bi;
                if (weakReference != null && weakReference.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        WeakHashMap weakHashMap = ViewCompat.a;
                        ((View) bottomSheetBehavior.bi.get()).postOnAnimation((dc) runnable);
                        this.c = true;
                    }
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) agrVar;
                WeakReference weakReference2 = sideSheetBehavior.ae;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        WeakHashMap weakHashMap2 = ViewCompat.a;
                        ((View) sideSheetBehavior.ae.get()).postOnAnimation((dh) runnable);
                        this.c = true;
                    }
                    break;
                }
                break;
        }
    }

    public qf(BottomSheetBehavior bottomSheetBehavior) {
        this.a = 0;
        this.e = bottomSheetBehavior;
        this.d = new dc(this, 3);
    }
}
