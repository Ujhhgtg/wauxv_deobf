package me.hd.wauxv.obf;

import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dow extends btp implements IInvokable {
    public static final dow a = new dow(1);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Resources resources = (Resources) obj;
        throwIfVar1IsNull(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
