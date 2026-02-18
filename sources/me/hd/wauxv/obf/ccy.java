package me.hd.wauxv.obf;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ccy implements Choreographer.FrameCallback {
    public final /* synthetic */ int a = 1;
    public final /* synthetic */ Object b;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        switch (this.a) {
            case 0:
                if (((ccz) this.b).a) {
                    bzo.ar("textureViewRenderer");
                    throw null;
                }
                return;
            default:
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new hi((Context) this.b, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
                return;
        }
    }
}
