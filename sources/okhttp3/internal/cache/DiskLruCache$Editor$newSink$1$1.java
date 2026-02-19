package okhttp3.internal.cache;

import java.io.IOException;
import me.hd.wauxv.obf.IInvokable;
import me.hd.wauxv.obf.btp;
import me.hd.wauxv.obf.Kotlin$Unit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DiskLruCache$Editor$newSink$1$1 extends btp implements IInvokable {
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Editor this$1;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public DiskLruCache$Editor$newSink$1$1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.this$0 = diskLruCache;
        this.this$1 = editor;
    }

    @Override // me.hd.wauxv.obf.bgf
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return Kotlin$Unit.INSTANCE;
    }

    public final void invoke(IOException iOException) {
        throwIfVar1IsNull(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
        }
    }
}
