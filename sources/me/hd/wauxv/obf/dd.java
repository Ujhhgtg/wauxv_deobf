package me.hd.wauxv.obf;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dd implements ThreadFactory {
    public final /* synthetic */ int a;

    public /* synthetic */ dd(int i) {
        this.a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.a) {
            case 0:
                return new Thread(new dc(runnable, 0), "glide-active-resources");
            case 1:
                return new ll(runnable);
            default:
                return new dbx(runnable);
        }
    }
}
