package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SomeRunnable implements Runnable {
    public final /* synthetic */ IInvokable anInvokable;
    public final /* synthetic */ Object anObject;

    public /* synthetic */ SomeRunnable(IInvokable bgfVar, Object obj) {
        this.anInvokable = bgfVar;
        this.anObject = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.anInvokable.invoke(this.anObject);
    }
}
