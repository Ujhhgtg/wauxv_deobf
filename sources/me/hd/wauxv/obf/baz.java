package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class baz extends ContextWrapper {
    public final bba a;

    public baz(Context context) {
        super(context);
        this.a = new bba(context.getClassLoader());
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        bba bbaVar = this.a;
        return bbaVar != null ? bbaVar : super.getClassLoader();
    }
}
