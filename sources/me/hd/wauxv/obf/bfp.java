package me.hd.wauxv.obf;

import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfp extends ng {
    public or ba;
    public float bb;
    public float bc;
    public boolean bd;
    public bfk be;
    public bfp bf;
    public bfo bg;
    public Integer bh;

    @Override // me.hd.wauxv.obf.ng
    public final String ao() {
        return bfp.class.getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    @Override // me.hd.wauxv.obf.ng
    public final void ay() {
        if (ar() != null) {
            ng.x(ar());
            this.n = false;
        }
        RelativeLayout relativeLayout = this.bg.f;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        this.q = 0L;
        View viewAn = an(aq(ax()) != 0 ? aq(ax()) : ax() ? R.layout.layout_dialogx_fullscreen : R.layout.layout_dialogx_fullscreen_dark);
        this.bg = new bfo(this, viewAn);
        if (viewAn != null) {
            viewAn.setTag(this.bf);
        }
        ng.ak(viewAn);
    }

    public final int bi() {
        bfp bfpVar = this.bf;
        if (this.bh == null) {
            this.bh = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowInsets rootWindowInsets = au() == null ? null : au().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                    RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                    if (roundedCorner != null && roundedCorner2 != null) {
                        this.bh = Integer.valueOf(Math.max(roundedCorner.getRadius(), roundedCorner2.getRadius()));
                    }
                }
            }
            if (this.bh.intValue() == 0 && "xiaomi".equals(Build.MANUFACTURER.toLowerCase())) {
                try {
                    Integer num = (Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.miui.notch.radius", 0);
                    num.getClass();
                    this.bh = num;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.bh.intValue() == 0) {
                try {
                    int identifier = bfpVar.at().getIdentifier("rounded_corner_radius", "dimen", "android");
                    if (identifier > 0) {
                        this.bh = Integer.valueOf(bfpVar.at().getDimensionPixelSize(identifier));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return this.bh.intValue();
    }
}
