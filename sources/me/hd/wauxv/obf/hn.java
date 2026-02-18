package me.hd.wauxv.obf;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hn implements Executor {
    public final /* synthetic */ int a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.a) {
            case 0:
                new Thread(runnable).start();
                break;
            case 1:
                eot.i().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
