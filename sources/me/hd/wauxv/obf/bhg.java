package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhg implements Handler.Callback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bhg(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.a) {
            case 0:
                bhh bhhVar = (bhh) this.b;
                int i = message.what;
                if (i == 1) {
                    bhhVar.r((bhe) message.obj);
                    return true;
                }
                if (i == 2) {
                    bhhVar.d.n((bhe) message.obj);
                }
                return false;
            default:
                if (message.what != 0) {
                    return false;
                }
                LateinitProperty lateinitPropertyVar = (LateinitProperty) this.b;
                if (message.obj != null) {
                    throw new ClassCastException();
                }
                synchronized (lateinitPropertyVar.e) {
                    try {
                        throw null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
