package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cw implements ccm {
    public final Context a;
    public Context b;
    public cbw c;
    public final LayoutInflater d;
    public ccl e;
    public cco h;
    public int i;
    public ct j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public cq t;
    public cq u;
    public cs v;
    public cr w;
    public int y;
    public final int f = R.layout.abc_action_menu_layout;
    public final int g = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray s = new SparseBooleanArray();
    public final erp x = new erp(this, 2);

    public cw(Context context) {
        this.a = context;
        this.d = LayoutInflater.from(context);
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void aa(cbw cbwVar, boolean z) {
        ag();
        cq cqVar = this.u;
        if (cqVar != null && cqVar.p()) {
            cqVar.l.dismiss();
        }
        ccl cclVar = this.e;
        if (cclVar != null) {
            cclVar.c(cbwVar, z);
        }
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ab(cbz cbzVar) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.ccm
    public final void ac(boolean z) {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.h;
        ArrayList arrayList = null;
        boolean z2 = false;
        if (viewGroup != null) {
            cbw cbwVar = this.c;
            if (cbwVar != null) {
                cbwVar.ah();
                ArrayList arrayListAk = this.c.ak();
                int size = arrayListAk.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    cbz cbzVar = (cbz) arrayListAk.get(i2);
                    if ((cbzVar.z & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        cbz itemData = childAt instanceof ccn ? ((ccn) childAt).getItemData() : null;
                        View viewZ = z(cbzVar, childAt, viewGroup);
                        if (cbzVar != itemData) {
                            viewZ.setPressed(false);
                            viewZ.jumpDrawablesToCurrentState();
                        }
                        if (viewZ != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) viewZ.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(viewZ);
                            }
                            ((ViewGroup) this.h).addView(viewZ, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.j) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.h).requestLayout();
        cbw cbwVar2 = this.c;
        if (cbwVar2 != null) {
            cbwVar2.ah();
            ArrayList arrayList2 = cbwVar2.j;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                cca ccaVar = ((cbz) arrayList2.get(i3)).ac;
            }
        }
        cbw cbwVar3 = this.c;
        if (cbwVar3 != null) {
            cbwVar3.ah();
            arrayList = cbwVar3.k;
        }
        if (this.m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z2 = !((cbz) arrayList.get(0)).ae;
            } else if (size3 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.j == null) {
                this.j = new ct(this, this.a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.j.getParent();
            if (viewGroup3 != this.h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.h;
                ct ctVar = this.j;
                actionMenuView.getClass();
                cy cyVarN = ActionMenuView.n();
                cyVarN.a = true;
                actionMenuView.addView(ctVar, cyVarN);
            }
        } else {
            ct ctVar2 = this.j;
            if (ctVar2 != null) {
                Object parent = ctVar2.getParent();
                Object obj = this.h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.j);
                }
            }
        }
        ((ActionMenuView) this.h).setOverflowReserved(this.m);
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ad() {
        int size;
        ArrayList arrayListAk;
        int i;
        boolean z;
        cw cwVar = this;
        cbw cbwVar = cwVar.c;
        if (cbwVar != null) {
            arrayListAk = cbwVar.ak();
            size = arrayListAk.size();
        } else {
            size = 0;
            arrayListAk = null;
        }
        int i2 = cwVar.q;
        int i3 = cwVar.p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cwVar.h;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = 2;
            z = true;
            if (i4 >= size) {
                break;
            }
            cbz cbzVar = (cbz) arrayListAk.get(i4);
            int i7 = cbzVar.aa;
            if ((i7 & 2) == 2) {
                i5++;
            } else if ((i7 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (cwVar.r && cbzVar.ae) {
                i2 = 0;
            }
            i4++;
        }
        if (cwVar.m && (z2 || i6 + i5 > i2)) {
            i2--;
        }
        int i8 = i2 - i5;
        SparseBooleanArray sparseBooleanArray = cwVar.s;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < size) {
            cbz cbzVar2 = (cbz) arrayListAk.get(i9);
            int i11 = cbzVar2.aa;
            boolean z3 = (i11 & 2) == i ? z : false;
            int i12 = cbzVar2.b;
            if (z3) {
                View viewZ = cwVar.z(cbzVar2, null, viewGroup);
                viewZ.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewZ.getMeasuredWidth();
                i3 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                if (i12 != 0) {
                    sparseBooleanArray.put(i12, z);
                }
                cbzVar2.aj(z);
            } else {
                if ((i11 & 1) == z) {
                    boolean z4 = sparseBooleanArray.get(i12);
                    boolean z5 = ((i8 > 0 || z4) && i3 > 0) ? z : false;
                    if (z5) {
                        View viewZ2 = cwVar.z(cbzVar2, null, viewGroup);
                        viewZ2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        int measuredWidth2 = viewZ2.getMeasuredWidth();
                        i3 -= measuredWidth2;
                        if (i10 == 0) {
                            i10 = measuredWidth2;
                        }
                        z5 &= i3 + i10 > 0;
                    }
                    if (z5 && i12 != 0) {
                        sparseBooleanArray.put(i12, true);
                    } else if (z4) {
                        sparseBooleanArray.put(i12, false);
                        for (int i13 = 0; i13 < i9; i13++) {
                            cbz cbzVar3 = (cbz) arrayListAk.get(i13);
                            if (cbzVar3.b == i12) {
                                if ((cbzVar3.z & 32) == 32) {
                                    i8++;
                                }
                                cbzVar3.aj(false);
                            }
                        }
                    }
                    if (z5) {
                        i8--;
                    }
                    cbzVar2.aj(z5);
                } else {
                    cbzVar2.aj(false);
                }
                i9++;
                i = 2;
                cwVar = this;
                z = true;
            }
            i9++;
            i = 2;
            cwVar = this;
            z = true;
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final boolean ae(cbz cbzVar) {
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void af(Context context, cbw cbwVar) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = cbwVar;
        Resources resources = context.getResources();
        if (!this.n) {
            this.m = true;
        }
        int i = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.q = i;
        int measuredWidth = this.o;
        if (this.m) {
            if (this.j == null) {
                ct ctVar = new ct(this, this.a);
                this.j = ctVar;
                if (this.l) {
                    ctVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = measuredWidth;
        float f = resources.getDisplayMetrics().density;
    }

    public final boolean ag() {
        Object obj;
        cs csVar = this.v;
        if (csVar != null && (obj = this.h) != null) {
            ((View) obj).removeCallbacks(csVar);
            this.v = null;
            return true;
        }
        cq cqVar = this.t;
        if (cqVar == null) {
            return false;
        }
        if (cqVar.p()) {
            cqVar.l.dismiss();
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ah(Parcelable parcelable) {
        int i;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof cv) && (i = ((cv) parcelable).a) > 0 && (menuItemFindItem = this.c.findItem(i)) != null) {
            aj((dnw) menuItemFindItem.getSubMenu());
        }
    }

    public final boolean ai() {
        cq cqVar = this.t;
        return cqVar != null && cqVar.p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.ccm
    public final boolean aj(dnw dnwVar) {
        boolean z;
        if (dnwVar.hasVisibleItems()) {
            dnw dnwVar2 = dnwVar;
            while (true) {
                cbw cbwVar = dnwVar2.aw;
                if (cbwVar == this.c) {
                    break;
                }
                dnwVar2 = (dnw) cbwVar;
            }
            cbz cbzVar = dnwVar2.ax;
            ViewGroup viewGroup = (ViewGroup) this.h;
            View view = null;
            view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof ccn) && ((ccn) childAt).getItemData() == cbzVar) {
                        view = childAt;
                        break;
                    }
                }
            }
            if (view != null) {
                this.y = dnwVar.ax.a;
                int size = dnwVar.g.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = dnwVar.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                cq cqVar = new cq(this, this.b, dnwVar, view);
                this.u = cqVar;
                cqVar.j = z;
                cce cceVar = cqVar.l;
                if (cceVar != null) {
                    cceVar.ao(z);
                }
                cq cqVar2 = this.u;
                if (!cqVar2.p()) {
                    if (cqVar2.h == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    cqVar2.q(0, 0, false, false);
                }
                ccl cclVar = this.e;
                if (cclVar != null) {
                    cclVar.d(dnwVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final void ak(ccl cclVar) {
        throw null;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final Parcelable al() {
        cv cvVar = new cv();
        cvVar.a = this.y;
        return cvVar;
    }

    public final boolean am() {
        cbw cbwVar;
        if (!this.m || ai() || (cbwVar = this.c) == null || this.h == null || this.v != null) {
            return false;
        }
        cbwVar.ah();
        if (cbwVar.k.isEmpty()) {
            return false;
        }
        cs csVar = new cs(this, 0, new cq(this, this.b, this.c, this.j));
        this.v = csVar;
        ((View) this.h).post(csVar);
        return true;
    }

    @Override // me.hd.wauxv.obf.ccm
    public final int getId() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View z(cbz cbzVar, View view, ViewGroup viewGroup) {
        View actionView = cbzVar.getActionView();
        if (actionView == null || cbzVar.ah()) {
            ccn ccnVar = view instanceof ccn ? (ccn) view : (ccn) this.d.inflate(this.g, viewGroup, false);
            ccnVar.n(cbzVar);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) ccnVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.h);
            if (this.w == null) {
                this.w = new cr(this);
            }
            actionMenuItemView.setPopupCallback(this.w);
            actionView = (View) ccnVar;
        }
        actionView.setVisibility(cbzVar.ae ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof cy)) {
            actionView.setLayoutParams(ActionMenuView.o(layoutParams));
        }
        return actionView;
    }
}
