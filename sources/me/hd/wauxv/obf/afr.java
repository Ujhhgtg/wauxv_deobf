package me.hd.wauxv.obf;

import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afr implements bic {
    public final Object a;
    public volatile Object b;

    public /* synthetic */ afr(Object obj) {
        this.a = obj;
    }

    public aoh c() {
        if (((aoh) this.b) == null) {
            synchronized (this) {
                try {
                    if (((aoh) this.b) == null) {
                        File cacheDir = ((anr) ((SyntheticPileOfMess) this.a).obj).b.getCacheDir();
                        aop aopVar = null;
                        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
                        if (file != null && (file.isDirectory() || file.mkdirs())) {
                            aopVar = new aop(file);
                        }
                        this.b = aopVar;
                    }
                    if (((aoh) this.b) == null) {
                        this.b = new nu(19);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (aoh) this.b;
    }

    @Override // me.hd.wauxv.obf.bic
    public Object get() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        Object obj = ((bic) this.a).get();
                        cmz.n(obj, "Argument must not be null");
                        this.b = obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    public afr() {
        this.a = new CopyOnWriteArraySet();
    }
}
