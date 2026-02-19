package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class doh {
    public static final Kotlin$Lazy a = new Kotlin$Lazy(dx.b);

    public static final void b(bfu bfuVar) {
        if (nullSafeIsEqual(Looper.myLooper(), Looper.getMainLooper())) {
            bfuVar.invoke();
        } else {
            ((Handler) a.getValue()).post(new dh(bfuVar));
        }
    }
}
