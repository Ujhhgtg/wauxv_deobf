package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwj implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bwn b;

    public /* synthetic */ bwj(bwn bwnVar, int i) {
        this.a = i;
        this.b = bwnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                aqe aqeVar = this.b.w;
                if (aqeVar != null) {
                    aqeVar.setListSelectionHidden(true);
                    aqeVar.requestLayout();
                }
                break;
            default:
                bwn bwnVar = this.b;
                aqe aqeVar2 = bwnVar.w;
                if (aqeVar2 != null && aqeVar2.isAttachedToWindow() && bwnVar.w.getCount() > bwnVar.w.getChildCount() && bwnVar.w.getChildCount() <= bwnVar.ah) {
                    bwnVar.av.setInputMethodMode(2);
                    bwnVar.ag();
                    break;
                }
                break;
        }
    }
}
