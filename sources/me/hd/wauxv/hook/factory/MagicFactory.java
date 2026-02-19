package me.hd.wauxv.hook.factory;

import me.hd.wauxv.obf.ajn;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MagicFactory {
    public static final MagicFactory INSTANCE = new MagicFactory();

    private MagicFactory() {
    }

    public static final Class<Object> toAppClass(String str) {
        return ajn.tryGetClassByClassName(str);
    }
}
