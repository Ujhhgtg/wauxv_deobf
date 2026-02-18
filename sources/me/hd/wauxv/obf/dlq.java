package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dlq {
    public boolean g;
    public boolean h;

    public abstract void b(ViewGroup viewGroup);

    public abstract void c(ViewGroup viewGroup);

    public void e(mt mtVar, ViewGroup viewGroup) {
        throwIfVar1IsNull(mtVar, "backEvent");
        throwIfVar1IsNull(viewGroup, "container");
    }

    public void f(ViewGroup viewGroup) {
        throwIfVar1IsNull(viewGroup, "container");
    }
}
