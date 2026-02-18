package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cec extends ContextThemeWrapper {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        ceb cebVar = ceb.a;
        if (cebVar != null) {
            return cebVar;
        }
        ceb cebVar2 = new ceb();
        ceb.a = cebVar2;
        return cebVar2;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }
}
