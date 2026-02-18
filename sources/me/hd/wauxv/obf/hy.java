package me.hd.wauxv.obf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hy extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ hy(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                ((hz) this.b).f();
                break;
            default:
                if (context != null && intent != null) {
                    ((bgk) this.b).b(this, context, intent);
                    break;
                }
                break;
        }
    }
}
