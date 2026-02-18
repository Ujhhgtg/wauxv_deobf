package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nt implements Handler.Callback {
    public final /* synthetic */ int a;

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.a) {
            case 0:
                int i = message.what;
                if (i == 0) {
                    message.obj.getClass();
                    throw new ClassCastException();
                }
                if (i != 1) {
                    return false;
                }
                message.obj.getClass();
                throw new ClassCastException();
            default:
                if (message.what != 1) {
                    return false;
                }
                ((dcg) message.obj).c();
                return true;
        }
    }
}
