package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ekd extends ContextWrapper {
    public static final Object a = null;

    public static void b(Context context) {
        if (context.getResources() instanceof ekf) {
            return;
        }
        context.getResources();
        int i = epm.a;
    }
}
