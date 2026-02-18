package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cce implements dho, ccm, AdapterView.OnItemClickListener {
    public Rect av;

    public static int aw(ListAdapter listAdapter, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ab(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ae(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void af(Context context, cbw cbwVar) {
    }

    public abstract void am(cbw cbwVar);

    public abstract void an(View view);

    public abstract void ao(boolean z);

    public abstract void ap(int i);

    public abstract void aq(int i);

    public abstract void ar(PopupWindow.OnDismissListener onDismissListener);

    public abstract void as(boolean z);

    public abstract void at(int i);

    @Override // me.hd.wauxv.obf.ccm
    public final int getId() {
        return 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (cbt) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter()
                : (cbt) listAdapter).cachedConstructors
                .ap((MenuItem) listAdapter.getItem(i), this, !(this instanceof tm) ? 0 : 4);
    }
}
