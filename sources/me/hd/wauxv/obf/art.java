package me.hd.wauxv.obf;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class art {
    public final Context a;
    public String b = "";
    public boolean c = true;
    public int d;
    public ars e;

    public art(Context context) {
        this.a = context;
    }

    public final void f(int i) {
        String string = this.a.getString(i);
        throwIfVar1IsNull(string, "getString(...)");
        this.b = string;
    }
}
