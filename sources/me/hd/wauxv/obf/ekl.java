package me.hd.wauxv.obf;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ekl implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ ekl(Toolbar toolbar, int i) {
        this.a = i;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                eko ekoVar = this.b.al;
                cbz cbzVar = ekoVar == null ? null : ekoVar.b;
                if (cbzVar != null) {
                    cbzVar.collapseActionView();
                }
                break;
            default:
                this.b.be();
                break;
        }
    }
}
