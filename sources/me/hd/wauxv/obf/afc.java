package me.hd.wauxv.obf;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afc {
    public final /* synthetic */ int a;
    public boolean b;

    public String toString() {
        switch (this.a) {
            case 1:
                return "Progress(currentByteCount=0, totalByteCount=0, finish=" + this.b + ')';
            default:
                return super.toString();
        }
    }

    public afc() {
        this.a = 1;
        SystemClock.elapsedRealtime();
    }
}
