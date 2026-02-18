package me.hd.wauxv.obf;

import com.chad.library.adapter4.layoutmanager.QuickGridLayoutManager;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwx extends hz {
    public hz a;
    public final /* synthetic */ QuickGridLayoutManager b;

    public cwx(QuickGridLayoutManager quickGridLayoutManager) {
        this.b = quickGridLayoutManager;
    }

    @Override // me.hd.wauxv.obf.hz
    public final int o(int i) {
        QuickGridLayoutManager quickGridLayoutManager = this.b;
        cyw cywVar = quickGridLayoutManager.dl;
        if (cywVar == null) {
            return 1;
        }
        if (cywVar instanceof bfs) {
            return quickGridLayoutManager.c;
        }
        if (!(cywVar instanceof adw)) {
            hz hzVar = this.a;
            if (hzVar != null) {
                return hzVar.o(i);
            }
            return 1;
        }
        adw.c((adw) cywVar);
        if (i == R.id.BaseQuickAdapter_empty_view) {
            return quickGridLayoutManager.c;
        }
        hz hzVar2 = this.a;
        if (hzVar2 != null) {
            return hzVar2.o(i);
        }
        return 1;
    }
}
