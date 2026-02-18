package com.highcapable.betterandroid.ui.component.adapter.recycler.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.cyt;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.ea;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public RecyclerView a;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public final int b(int i) {
        cyw adapter;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            bmu bmuVar = adapter instanceof cyt ? ((cyt) adapter).a : null;
            if (bmuVar != null) {
                ((ea) bmuVar.h).p();
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void cd(RecyclerView recyclerView) {
        this.a = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void ch(int i) {
        b(i);
        super.ch(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void cj(RecyclerView recyclerView, czt cztVar, int i) {
        b(i);
        super.cj(recyclerView, cztVar, i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int ct() {
        cyw adapter;
        int iCt = super.ct();
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            bmu bmuVar = adapter instanceof cyt ? ((cyt) adapter).a : null;
            if (bmuVar != null) {
                ((ea) bmuVar.h).p();
            }
        }
        return iCt;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final int cu() {
        cyw adapter;
        int iCu = super.cu();
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            bmu bmuVar = adapter instanceof cyt ? ((cyt) adapter).a : null;
            if (bmuVar != null) {
                ((ea) bmuVar.h).p();
            }
        }
        return iCu;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void dg(int i, int i2) {
        b(i);
        super.dg(i, i2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void dm(RecyclerView recyclerView) {
        this.a = recyclerView;
    }
}
