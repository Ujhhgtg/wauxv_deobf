package me.hd.wauxv.obf;

import android.widget.ListView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ajz implements Runnable {
    public final /* synthetic */ chm a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ ajz(chm chmVar, int i, int i2) {
        this.a = chmVar;
        this.b = i;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        chm chmVar = this.a;
        chmVar.getClass();
        int i = this.b;
        int i2 = this.c;
        if (i == 0 && i2 == 0) {
            ((ListView) chmVar.c).setSelectionFromTop(0, 0);
            return;
        }
        while (((ListView) chmVar.c).getFirstVisiblePosition() + 1 > i && ((ListView) chmVar.c).canScrollList(-1)) {
            chmVar.aq(i2 / 2);
        }
        while (((ListView) chmVar.c).getLastVisiblePosition() - 1 < i && ((ListView) chmVar.c).canScrollList(1)) {
            chmVar.aq((-i2) / 2);
        }
    }
}
