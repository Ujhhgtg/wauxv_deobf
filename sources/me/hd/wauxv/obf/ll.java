package me.hd.wauxv.obf;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ll extends Thread {
    public final /* synthetic */ int a = 1;

    public /* synthetic */ ll(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        lo loVarA;
        switch (this.a) {
            case 0:
                break;
            default:
                Process.setThreadPriority(9);
                super.run();
                return;
        }
        while (true) {
            try {
                lo.Companion.getClass();
                reentrantLock = lo.lock;
                reentrantLock.lock();
                try {
                    loVarA = lk.a();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
            }
            if (loVarA == lo.head) {
                lo.head = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (loVarA != null) {
                    loVarA.timedOut();
                }
            }
        }
    }

    public /* synthetic */ ll(String str) {
        super(str);
    }
}
