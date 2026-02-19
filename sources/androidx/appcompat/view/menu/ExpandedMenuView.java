package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import me.hd.wauxv.obf.cbv;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cbz;
import me.hd.wauxv.obf.cco;
import me.hd.wauxv.obf.FactoryPools;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements cbv, cco, AdapterView.OnItemClickListener {
    public static final int[] a = {R.attr.background, R.attr.divider};
    public cbw b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        FactoryPools factoryPoolsVarK = FactoryPools.k(context, attributeSet, a, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(factoryPoolsVarK.s(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(factoryPoolsVarK.s(1));
        }
        factoryPoolsVarK.ae();
    }

    @Override // me.hd.wauxv.obf.cbv
    public final boolean c(cbz cbzVar) {
        return this.b.ap(cbzVar, null, 0);
    }

    @Override // me.hd.wauxv.obf.cco
    public final void d(cbw cbwVar) {
        this.b = cbwVar;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c((cbz) getAdapter().getItem(i));
    }
}
