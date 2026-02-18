package me.hd.wauxv.obf;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ekm implements cz, cbu {
    public final /* synthetic */ Toolbar a;

    public /* synthetic */ ekm(Toolbar toolbar) {
        this.a = toolbar;
    }

    @Override // me.hd.wauxv.obf.cbu
    public void bw(cbw cbwVar) {
        Toolbar toolbar = this.a;
        cw cwVar = toolbar.a.g;
        if (cwVar == null || !cwVar.ai()) {
            Iterator it = ((CopyOnWriteArrayList) toolbar.ag.h).iterator();
            while (it.hasNext()) {
                ((bdy) it.next()).a.bp();
            }
        }
    }

    @Override // me.hd.wauxv.obf.cbu
    public boolean bx(cbw cbwVar, MenuItem menuItem) {
        this.a.getClass();
        return false;
    }
}
