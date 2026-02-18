package me.hd.wauxv.obf;

import android.os.Trace;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ati implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Method method = ekx.b;
            Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
            if (atf.b != null) {
                atf.l().n();
            }
        } finally {
            Method method2 = ekx.b;
            Trace.endSection();
        }
    }
}
