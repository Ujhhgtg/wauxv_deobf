package com.chad.library.adapter4.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.f;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cwx;
import me.hd.wauxv.obf.cyw;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class QuickGridLayoutManager extends GridLayoutManager {
    public cyw dl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        bzo.q(context, f.X);
        cwx cwxVar = new cwx(this);
        cwxVar.a = this.h;
        this.h = cwxVar;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ba(cyw cywVar) {
        this.dl = cywVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void cd(RecyclerView recyclerView) {
        this.dl = null;
    }

    @Override // me.hd.wauxv.obf.czg
    public final void dm(RecyclerView recyclerView) {
        this.dl = recyclerView.getAdapter();
    }
}
