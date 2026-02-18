package me.hd.wauxv.obf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class de extends WeakReference {
    public final btj a;
    public final boolean b;
    public dcg c;

    public de(btj btjVar, awl awlVar, ReferenceQueue referenceQueue) {
        super(awlVar, referenceQueue);
        cmz.n(btjVar, "Argument must not be null");
        this.a = btjVar;
        boolean z = awlVar.a;
        this.c = null;
        this.b = z;
    }
}
