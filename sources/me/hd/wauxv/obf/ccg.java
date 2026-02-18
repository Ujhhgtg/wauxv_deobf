package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ccg {
    public final Context d;
    public final cbw e;
    public final boolean f;
    public final int g;
    public View h;
    public boolean j;
    public ccl k;
    public cce l;
    public PopupWindow.OnDismissListener m;
    public int i = 8388611;
    public final ccf n = new ccf(this);

    public ccg(Context context, cbw cbwVar, View view, boolean z, int i, int i2) {
        this.d = context;
        this.e = cbwVar;
        this.h = view;
        this.f = z;
        this.g = i;
    }

    public void c() {
        this.l = null;
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final cce o() {
        cce dmhVar;
        if (this.l == null) {
            Context context = this.d;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources()
                    .getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                dmhVar = new tm(context, this.h, this.g, this.f);
            } else {
                dmhVar = new dmh(this.d, this.e, this.h, this.g, this.f);
            }
            dmhVar.am(this.e);
            dmhVar.ar(this.n);
            dmhVar.an(this.h);
            dmhVar.ak(this.k);
            dmhVar.ao(this.j);
            dmhVar.ap(this.i);
            this.l = dmhVar;
        }
        return this.l;
    }

    public final boolean p() {
        cce cceVar = this.l;
        return cceVar != null && cceVar.getThisObject();
    }

    public final void q(int i, int i2, boolean z, boolean z2) {
        cce cceVarO = o();
        cceVarO.as(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.i, this.h.getLayoutDirection()) & 7) == 5) {
                i -= this.h.getWidth();
            }
            cceVarO.aq(i);
            cceVarO.at(i2);
            int i3 = (int) ((this.d.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            cceVarO.av = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        cceVarO.ag();
    }
}
