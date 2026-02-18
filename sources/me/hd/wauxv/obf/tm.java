package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tm extends cce implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public final Context a;
    public final int b;
    public final int c;
    public final boolean d;
    public final Handler f;
    public View n;
    public View o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public boolean v;
    public ccl w;
    public ViewTreeObserver x;
    public PopupWindow.OnDismissListener y;
    public boolean z;
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final iv i = new iv(this, 2);
    public final tj j = new tj(this, 0);
    public final erp k = new erp(this, 7);
    public int l = 0;
    public int m = 0;
    public boolean u = false;

    public tm(Context context, View view, int i, boolean z) {
        this.a = context;
        this.n = view;
        this.c = i;
        this.d = z;
        this.p = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.b = Math.max(resources.getDisplayMetrics().widthPixels / 2,
                resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f = new Handler();
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (cbwVar == ((tl) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((tl) arrayList.get(i2)).b.ab(false);
        }
        tl tlVar = (tl) arrayList.remove(i);
        cbw cbwVar2 = tlVar.b;
        cck cckVar = tlVar.a;
        in inVar = cckVar.av;
        cbwVar2.aq(this);
        if (this.z) {
            cch.tryGetClassByName(inVar, null);
            inVar.setAnimationStyle(0);
        }
        cckVar.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.p = ((tl) arrayList.get(size2 - 1)).c;
        } else {
            this.p = this.n.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((tl) arrayList.get(0)).b.ab(false);
                return;
            }
            return;
        }
        dismiss();
        ccl cclVar = this.w;
        if (cclVar != null) {
            cclVar.c(cbwVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.x.removeGlobalOnLayoutListener(this.i);
            }
            this.x = null;
        }
        this.o.removeOnAttachStateChangeListener(this.j);
        this.y.onDismiss();
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((tl) it.next()).a.w.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((cbt) adapter).notifyDataSetChanged();
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ad() {
        return false;
    }

    @Override // me.hd.wauxv.obf.dho
    public final void ag() {
        if (initOnce()) {
            return;
        }
        ArrayList arrayList = this.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            au((cbw) it.next());
        }
        arrayList.clear();
        View view = this.n;
        this.o = view;
        if (view != null) {
            boolean z = this.x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.x = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.i);
            }
            this.o.addOnAttachStateChangeListener(this.j);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
    }

    @Override // me.hd.wauxv.obf.dho
    public final aqe ai() {
        ArrayList arrayList = this.h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((tl) dkz.l(1, arrayList)).a.w;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        for (tl tlVar : this.h) {
            if (dnwVar == tlVar.b) {
                tlVar.a.w.requestFocus();
                return true;
            }
        }
        if (!dnwVar.hasVisibleItems()) {
            return false;
        }
        am(dnwVar);
        ccl cclVar = this.w;
        if (cclVar != null) {
            cclVar.d(dnwVar);
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ak(ccl cclVar) {
        this.w = cclVar;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        return null;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void am(cbw cbwVar) {
        cbwVar.aa(this, this.a);
        if (initOnce()) {
            au(cbwVar);
        } else {
            this.g.add(cbwVar);
        }
    }

    @Override // me.hd.wauxv.obf.cce
    public final void an(View view) {
        if (this.n != view) {
            this.n = view;
            this.m = Gravity.getAbsoluteGravity(this.l, view.getLayoutDirection());
        }
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ao(boolean z) {
        this.u = z;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ap(int i) {
        if (this.l != i) {
            this.l = i;
            this.m = Gravity.getAbsoluteGravity(i, this.n.getLayoutDirection());
        }
    }

    @Override // me.hd.wauxv.obf.cce
    public final void aq(int i) {
        this.q = true;
        this.s = i;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void ar(PopupWindow.OnDismissListener onDismissListener) {
        this.y = onDismissListener;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void as(boolean z) {
        this.v = z;
    }

    @Override // me.hd.wauxv.obf.cce
    public final void at(int i) {
        this.r = true;
        this.t = i;
    }

    /*
     * JADX WARN: Found duplicated region for block: B:103:0x0111
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:55:0x0105 */
    /* JADX WARN: Found duplicated region for block: B:57:0x010d */
    /* JADX WARN: Found duplicated region for block: B:62:0x0123 */
    /* JADX WARN: Found duplicated region for block: B:65:0x0152 */
    /* JADX WARN: Found duplicated region for block: B:67:0x015e */
    /* JADX WARN: Found duplicated region for block: B:68:0x0161 */
    /* JADX WARN: Found duplicated region for block: B:69:0x0164 */
    /* JADX WARN: Found duplicated region for block: B:73:0x016c */
    /* JADX WARN: Found duplicated region for block: B:74:0x016e */
    /* JADX WARN: Found duplicated region for block: B:77:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:79:0x017c */
    /* JADX WARN: Found duplicated region for block: B:80:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:81:0x0185 */
    /* JADX WARN: Found duplicated region for block: B:82:0x018a */
    /* JADX WARN: Found duplicated region for block: B:84:0x0197 */
    /* JADX WARN: Found duplicated region for block: B:86:0x019b */
    /* JADX WARN: Found duplicated region for block: B:89:0x01a3 */
    /* JADX WARN: Found duplicated region for block: B:92:0x01ac */
    /* JADX WARN: Found duplicated region for block: B:93:0x01b2 */
    public final void au(cbw cbwVar) {
        boolean z;
        int i;
        tl tlVar;
        View childAt;
        int i2;
        in inVar;
        aqe aqeVar;
        int[] iArr;
        Rect rect;
        int i3;
        int i4;
        boolean z2;
        Method method;
        MenuItem item;
        cbt cbtVar;
        int headersCount;
        int firstVisiblePosition;
        Context context = this.a;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        cbt cbtVar2 = new cbt(cbwVar, layoutInflaterFrom, this.d, R.layout.abc_cascading_menu_item_layout);
        if (!initOnce() && this.u) {
            cbtVar2.c = true;
        } else if (initOnce()) {
            int size = cbwVar.g.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    z = false;
                    break;
                }
                MenuItem item2 = cbwVar.getItem(i5);
                if (item2.isVisible() && item2.getIcon() != null) {
                    z = true;
                    break;
                }
                i5++;
            }
            cbtVar2.c = z;
        }
        int iAw = cce.aw(cbtVar2, context, this.b);
        cck cckVar = new cck(context, null, this.c, 0);
        cckVar.b = this.k;
        cckVar.al = this;
        cckVar.av.setOnDismissListener(this);
        cckVar.ak = this.n;
        cckVar.af = this.m;
        cckVar.au = true;
        cckVar.av.setFocusable(true);
        cckVar.av.setInputMethodMode(2);
        cckVar.p(cbtVar2);
        cckVar.ax(iAw);
        cckVar.af = this.m;
        ArrayList arrayList = this.h;
        if (arrayList.size() > 0) {
            tlVar = (tl) dkz.l(1, arrayList);
            cbw cbwVar2 = tlVar.b;
            int size2 = cbwVar2.g.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size2) {
                    item = null;
                    break;
                }
                item = cbwVar2.getItem(i6);
                if (item.hasSubMenu() && cbwVar == item.getSubMenu()) {
                    break;
                } else {
                    i6++;
                }
            }
            if (item == null) {
                i = 1;
                childAt = null;
            } else {
                aqe aqeVar2 = tlVar.a.w;
                ListAdapter adapter = aqeVar2.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    cbtVar = (cbt) headerViewListAdapter.getWrappedAdapter();
                } else {
                    cbtVar = (cbt) adapter;
                    headersCount = 0;
                }
                int count = cbtVar.getCount();
                i = 1;
                int i7 = 0;
                while (true) {
                    if (i7 >= count) {
                        i7 = -1;
                        break;
                    } else if (item == cbtVar.getItem(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
                if (i7 != -1 && (firstVisiblePosition = (i7 + headersCount) - aqeVar2.getFirstVisiblePosition()) >= 0
                        && firstVisiblePosition < aqeVar2.getChildCount()) {
                    childAt = aqeVar2.getChildAt(firstVisiblePosition);
                }
            }
            if (childAt != null) {
                i2 = Build.VERSION.SDK_INT;
                inVar = cckVar.av;
                if (i2 <= 28) {
                    method = cck.a;
                    if (method != null) {
                        try {
                            method.invoke(inVar, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    cci.a(inVar, false);
                }
                cch.a(cckVar.av, null);
                aqeVar = ((tl) arrayList.get(arrayList.size() - 1)).a.w;
                iArr = new int[2];
                aqeVar.getLocationOnScreen(iArr);
                rect = new Rect();
                this.o.getWindowVisibleDisplayFrame(rect);
                if (this.p == i) {
                    if (aqeVar.getWidth() + iArr[0] + iAw > rect.right) {
                        i4 = 0;
                        i3 = 1;
                    } else {
                        i3 = 1;
                        i4 = 1;
                    }
                } else if (iArr[0] - iAw < 0) {
                    i3 = 1;
                    i4 = 1;
                } else {
                    i4 = 0;
                    i3 = 1;
                }
                z2 = i4 == i3;
                this.p = i4;
                cckVar.ak = childAt;
                if ((this.m & 5) != 5) {
                    iAw = z2 ? childAt.getWidth() : 0 - iAw;
                } else if (!z2) {
                    iAw = 0 - childAt.getWidth();
                }
                cckVar.z = iAw;
                cckVar.ae = true;
                cckVar.ad = true;
                cckVar.l(0);
            } else {
                if (this.q) {
                    cckVar.z = this.s;
                }
                if (this.r) {
                    cckVar.l(this.t);
                }
                Rect rect2 = this.av;
                cckVar.at = rect2 != null ? new Rect(rect2) : null;
            }
            arrayList.add(new tl(cckVar, cbwVar, this.p));
            cckVar.ag();
            aqe aqeVar3 = cckVar.w;
            aqeVar3.setOnKeyListener(this);
            if (tlVar == null || !this.v || cbwVar.n == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom
                    .inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) aqeVar3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(cbwVar.n);
            aqeVar3.addHeaderView(frameLayout, null, false);
            cckVar.ag();
            return;
        }
        i = 1;
        tlVar = null;
        childAt = null;
        if (childAt != null) {
            i2 = Build.VERSION.SDK_INT;
            inVar = cckVar.av;
            if (i2 <= 28) {
                method = cck.a;
                if (method != null) {
                    method.invoke(inVar, Boolean.FALSE);
                }
            } else {
                cci.a(inVar, false);
            }
            cch.a(cckVar.av, null);
            aqeVar = ((tl) arrayList.get(arrayList.size() - 1)).a.w;
            iArr = new int[2];
            aqeVar.getLocationOnScreen(iArr);
            rect = new Rect();
            this.o.getWindowVisibleDisplayFrame(rect);
            if (this.p == i) {
                if (aqeVar.getWidth() + iArr[0] + iAw > rect.right) {
                    i4 = 0;
                    i3 = 1;
                } else {
                    i3 = 1;
                    i4 = 1;
                }
            } else if (iArr[0] - iAw < 0) {
                i3 = 1;
                i4 = 1;
            } else {
                i4 = 0;
                i3 = 1;
            }
            if (i4 == i3) {
            }
            this.p = i4;
            cckVar.ak = childAt;
            if ((this.m & 5) != 5) {
                if (!z2) {
                    iAw = 0 - childAt.getWidth();
                }
            } else if (z2) {
            }
            cckVar.z = iAw;
            cckVar.ae = true;
            cckVar.ad = true;
            cckVar.l(0);
        } else {
            if (this.q) {
                cckVar.z = this.s;
            }
            if (this.r) {
                cckVar.l(this.t);
            }
            Rect rect22 = this.av;
            cckVar.at = rect22 != null ? new Rect(rect22) : null;
        }
        arrayList.add(new tl(cckVar, cbwVar, this.p));
        cckVar.ag();
        aqe aqeVar32 = cckVar.w;
        aqeVar32.setOnKeyListener(this);
        if (tlVar == null) {
        }
    }

    @Override // me.hd.wauxv.obf.dho
    public final void dismiss() {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        if (size > 0) {
            tl[] tlVarArr = (tl[]) arrayList.toArray(new tl[size]);
            for (int i = size - 1; i >= 0; i--) {
                tl tlVar = tlVarArr[i];
                if (tlVar.a.av.isShowing()) {
                    tlVar.a.dismiss();
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.dho
    public final boolean getThisObject() {
        ArrayList arrayList = this.h;
        return arrayList.size() > 0 && ((tl) arrayList.get(0)).a.av.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        tl tlVar;
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tlVar = null;
                break;
            }
            tlVar = (tl) arrayList.get(i);
            if (!tlVar.a.av.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (tlVar != null) {
            tlVar.b.ab(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }
}
