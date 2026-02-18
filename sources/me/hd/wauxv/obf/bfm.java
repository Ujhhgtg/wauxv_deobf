package me.hd.wauxv.obf;

import com.kongzue.dialogx.util.views.ActivityScreenShotImageView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfm implements ank, crc, caz {
    public final /* synthetic */ bfo b;

    public /* synthetic */ bfm(bfo bfoVar) {
        this.b = bfoVar;
    }

    @Override // me.hd.wauxv.obf.ank
    public void a() {
        bfp bfpVar = this.b.l;
        if (bfpVar.m) {
            ng.aj(new dc(bfpVar, 10));
        }
    }

    public void c(float f) {
        int iBi;
        bfo bfoVar = this.b;
        bfp bfpVar = bfoVar.l;
        ActivityScreenShotImageView activityScreenShotImageView = bfoVar.b;
        float top = f + bfoVar.e.getTop();
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = bfoVar.c;
        float height = 1.0f - ((dialogXBaseRelativeLayout.getHeight() - top) * 2.0E-5f);
        activityScreenShotImageView.setScale(height <= 1.0f ? height : 1.0f);
        float fBi = bfpVar.bi();
        float f2 = bfpVar.bc;
        if (f2 < 0.0f) {
            if (f2 == -2.0f) {
                iBi = bfpVar.bi();
            } else {
                f2 = bfpVar.bb;
                if (f2 < 0.0f) {
                    iBi = (int) ((15.0f * bfpVar.at().getDisplayMetrics().density) + 0.5f);
                }
            }
            f2 = iBi;
        }
        activityScreenShotImageView.setRadius(((f2 - fBi) * ((dialogXBaseRelativeLayout.getHeight() - top) / dialogXBaseRelativeLayout.getHeight())) + fBi);
    }
}
