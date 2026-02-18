package me.hd.wauxv.obf;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bxq {
    public static final double a = 1.0d / Math.pow(10.0d, 6.0d);
    public static final /* synthetic */ int b = 0;

    public static double c(long j) {
        return (SystemClock.elapsedRealtimeNanos() - j) * a;
    }
}
