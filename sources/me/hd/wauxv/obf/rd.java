package me.hd.wauxv.obf;

import bsh.classpath.BshClassPath;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rd implements Consumer {
    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        ((BshClassPath) obj).insureInitialized(false);
    }
}
