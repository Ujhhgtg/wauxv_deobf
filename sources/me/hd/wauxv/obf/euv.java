package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class euv implements View.OnApplyWindowInsetsListener {
    public final ua a;
    public evr b;

    public euv(View view, ua uaVar) {
        evr evrVarG;
        this.a = uaVar;
        WeakHashMap weakHashMap = eqz.a;
        evr evrVarA = eqr.a(view);
        if (evrVarA != null) {
            int i = Build.VERSION.SDK_INT;
            evrVarG = (i >= 34 ? new evf(evrVarA) : i >= 31 ? new eve(evrVarA) : i >= 30 ? new evd(evrVarA) : i >= 29 ? new evc(evrVarA) : new evb(evrVarA)).g();
        } else {
            evrVarG = null;
        }
        this.b = evrVarG;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int[] iArr;
        boolean z;
        if (!view.isLaidOut()) {
            this.b = evr.d(view, windowInsets);
            return euw.i(view, windowInsets);
        }
        evr evrVarD = evr.d(view, windowInsets);
        evo evoVar = evrVarD.b;
        if (this.b == null) {
            WeakHashMap weakHashMap = eqz.a;
            this.b = eqr.a(view);
        }
        if (this.b == null) {
            this.b = evrVarD;
            return euw.i(view, windowInsets);
        }
        ua uaVarJ = euw.j(view);
        if (uaVarJ != null && Objects.equals((evr) uaVarJ.c, evrVarD)) {
            return euw.i(view, windowInsets);
        }
        int[] iArr2 = new int[1];
        int[] iArr3 = new int[1];
        evr evrVar = this.b;
        int i = 1;
        while (i <= 512) {
            bps bpsVarN = evoVar.n(i);
            bps bpsVarN2 = evrVar.b.n(i);
            int i2 = bpsVarN.b;
            int i3 = bpsVarN.e;
            int i4 = bpsVarN.d;
            int i5 = bpsVarN.c;
            int i6 = bpsVarN2.b;
            int i7 = bpsVarN2.e;
            int i8 = bpsVarN2.d;
            int i9 = bpsVarN2.c;
            if (i2 > i6 || i5 > i9 || i4 > i8 || i3 > i7) {
                iArr = iArr2;
                z = true;
            } else {
                iArr = iArr2;
                z = false;
            }
            if (z != (i2 < i6 || i5 < i9 || i4 < i8 || i3 < i7)) {
                if (z) {
                    iArr[0] = iArr[0] | i;
                } else {
                    iArr3[0] = iArr3[0] | i;
                }
            }
            i <<= 1;
            iArr2 = iArr;
        }
        int i10 = iArr2[0];
        int i11 = iArr3[0];
        int i12 = i10 | i11;
        if (i12 == 0) {
            this.b = evrVarD;
            return euw.i(view, windowInsets);
        }
        evr evrVar2 = this.b;
        eva evaVar = new eva(i12, (i10 & 8) != 0 ? euw.a : (i11 & 8) != 0 ? euw._cg : (i10 & 519) != 0 ? euw._ch : (i11 & 519) != 0 ? euw._ci : null, (i12 & 8) != 0 ? 160L : 250L);
        evaVar.a.e(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(evaVar.a.b());
        bps bpsVarN3 = evoVar.n(i12);
        bps bpsVarN4 = evrVar2.b.n(i12);
        int iMin = Math.min(bpsVarN3.b, bpsVarN4.b);
        int i13 = bpsVarN3.c;
        int i14 = bpsVarN4.c;
        int iMin2 = Math.min(i13, i14);
        int i15 = bpsVarN3.d;
        int i16 = bpsVarN4.d;
        int iMin3 = Math.min(i15, i16);
        int i17 = bpsVarN3.e;
        int i18 = bpsVarN4.e;
        but butVar = new but(bps.g(iMin, iMin2, iMin3, Math.min(i17, i18)), 21, bps.g(Math.max(bpsVarN3.b, bpsVarN4.b), Math.max(i13, i14), Math.max(i15, i16), Math.max(i17, i18)));
        euw.f(view, evaVar, evrVarD, false);
        duration.addUpdateListener(new euu(evaVar, evrVarD, evrVar2, i12, view));
        duration.addListener(new elg(view, evaVar));
        crh.d(view, new tk(view, evaVar, butVar, duration));
        this.b = evrVarD;
        return euw.i(view, windowInsets);
    }
}
