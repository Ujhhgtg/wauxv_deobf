package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cco;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements cco {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // me.hd.wauxv.obf.cco
    public final void d(cbw cbwVar) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}
