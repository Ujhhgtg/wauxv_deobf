package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class df implements cqk, awz, bic, dqo {
    public static final df a = new df(7);
    public static final df b = new df(8);
    public static final df c = new df(9);
    public static final df d = new df(10);
    public static final df e = new df(11);
    public final /* synthetic */ int f;

    public /* synthetic */ df(int i) {
        this.f = i;
    }

    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        bps bpsVarN = evrVar.b.n(519);
        view.setPadding(bpsVarN.b, bpsVarN.c, bpsVarN.d, bpsVarN.e);
        return evrVar;
    }

    @Override // me.hd.wauxv.obf.awz
    public void g(ua uaVar, afc afcVar) {
    }

    @Override // me.hd.wauxv.obf.bic
    public Object get() {
        if (Build.VERSION.SDK_INT == 34) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            z = bitmapCopy == null;
            if (Log.isLoggable("GainmapWorkaroundCalc", 2)) {
                Log.v("GainmapWorkaroundCalc", "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
        }
        return Boolean.valueOf(z);
    }

    public /* synthetic */ df(asp aspVar) {
        this.f = 3;
    }
}
