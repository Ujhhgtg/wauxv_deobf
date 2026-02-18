package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccj extends aqe {
    public final int o;
    public final int p;
    public cby q;
    public cbz r;

    public ccj(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.o = 21;
            this.p = 22;
        } else {
            this.o = 22;
            this.p = 21;
        }
    }

    @Override // me.hd.wauxv.obf.aqe, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        cbt cbtVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.q != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                cbtVar = (cbt) headerViewListAdapter.getWrappedAdapter();
            } else {
                cbtVar = (cbt) adapter;
                headersCount = 0;
            }
            cbz cbzVarH = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= cbtVar.getCount()) ? null : cbtVar.getItem(i);
            cbz cbzVar = this.r;
            if (cbzVar != cbzVarH) {
                cbw cbwVar = cbtVar.a;
                if (cbzVar != null) {
                    this.q.q(cbwVar, cbzVar);
                }
                this.r = cbzVarH;
                if (cbzVarH != null) {
                    this.q.r(cbwVar, cbzVarH);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.o) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.p) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (cbt) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (cbt) adapter).a.ab(false);
        return true;
    }

    public void setHoverListener(cby cbyVar) {
        this.q = cbyVar;
    }

    @Override // me.hd.wauxv.obf.aqe, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
