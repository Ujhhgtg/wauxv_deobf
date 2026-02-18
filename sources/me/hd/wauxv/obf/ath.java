package me.hd.wauxv.obf;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ath extends cnh {
    public final /* synthetic */ cnh a;
    public final /* synthetic */ ThreadPoolExecutor d;

    public ath(cnh cnhVar, ThreadPoolExecutor threadPoolExecutor) {
        this.a = cnhVar;
        this.d = threadPoolExecutor;
    }

    @Override // me.hd.wauxv.obf.cnh
    public final void b(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.d;
        try {
            this.a.b(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // me.hd.wauxv.obf.cnh
    public final void c(chm chmVar) {
        ThreadPoolExecutor threadPoolExecutor = this.d;
        try {
            this.a.c(chmVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
