package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.ajv;
import me.hd.wauxv.obf.bdy;
import me.hd.wauxv.obf.cag;
import me.hd.wauxv.obf.cbw;
import me.hd.wauxv.obf.cbz;
import me.hd.wauxv.obf.ch;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cw;
import me.hd.wauxv.obf.cyf;
import me.hd.wauxv.obf.dc;
import me.hd.wauxv.obf.ddp;
import me.hd.wauxv.obf.dof;
import me.hd.wauxv.obf.ekl;
import me.hd.wauxv.obf.ekm;
import me.hd.wauxv.obf.ekn;
import me.hd.wauxv.obf.eko;
import me.hd.wauxv.obf.ekp;
import me.hd.wauxv.obf.ekq;
import me.hd.wauxv.obf.ekr;
import me.hd.wauxv.obf.ekt;
import me.hd.wauxv.obf.eku;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.ij;
import me.hd.wauxv.obf.il;
import me.hd.wauxv.obf.jp;
import me.hd.wauxv.obf.FactoryPools;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ActionMenuView a;
    public ColorStateList aa;
    public boolean ab;
    public boolean ac;
    public final ArrayList ad;
    public final ArrayList ae;
    public final int[] af;
    public final FactoryPools ag;
    public ArrayList ah;
    public final ekm ai;
    public ekt aj;
    public cw ak;
    public eko al;
    public boolean am;
    public OnBackInvokedCallback an;
    public OnBackInvokedDispatcher ao;
    public boolean ap;
    public final dc aq;
    public jp b;
    public jp c;
    public ij d;
    public il e;
    public final Drawable f;
    public final CharSequence g;
    public ij h;
    public View i;
    public Context j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public ddp t;
    public int u;
    public int v;
    public final int w;
    public CharSequence x;
    public CharSequence y;
    public ColorStateList z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static ekp ar() {
        ekp ekpVar = new ekp(-2, -2);
        ekpVar.b = 0;
        ekpVar.a = 8388627;
        return ekpVar;
    }

    public static ekp as(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof ekp;
        if (z) {
            ekp ekpVar = (ekp) layoutParams;
            ekp ekpVar2 = new ekp(ekpVar);
            ekpVar2.b = 0;
            ekpVar2.b = ekpVar.b;
            return ekpVar2;
        }
        if (z) {
            ekp ekpVar3 = new ekp((ekp) layoutParams);
            ekpVar3.b = 0;
            return ekpVar3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ekp ekpVar4 = new ekp(layoutParams);
            ekpVar4.b = 0;
            return ekpVar4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        ekp ekpVar5 = new ekp(marginLayoutParams);
        ekpVar5.b = 0;
        ((ViewGroup.MarginLayoutParams) ekpVar5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) ekpVar5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) ekpVar5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) ekpVar5).bottomMargin = marginLayoutParams.bottomMargin;
        return ekpVar5;
    }

    public static int at(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int au(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new dof(getContext());
    }

    public final void av(int i, ArrayList arrayList) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ekp ekpVar = (ekp) childAt.getLayoutParams();
                if (ekpVar.b == 0 && bk(childAt)) {
                    int i3 = ekpVar.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            ekp ekpVar2 = (ekp) childAt2.getLayoutParams();
            if (ekpVar2.b == 0 && bk(childAt2)) {
                int i5 = ekpVar2.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void aw(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ekp ekpVarAr = layoutParams == null ? ar()
                : !checkLayoutParams(layoutParams) ? as(layoutParams) : (ekp) layoutParams;
        ekpVarAr.b = 1;
        if (!z || this.i == null) {
            addView(view, ekpVarAr);
        } else {
            view.setLayoutParams(ekpVarAr);
            this.ae.add(view);
        }
    }

    public final void ax() {
        if (this.h == null) {
            ij ijVar = new ij(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.h = ijVar;
            ijVar.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            ekp ekpVarAr = ar();
            ekpVarAr.a = (this.n & 112) | 8388611;
            ekpVarAr.b = 2;
            this.h.setLayoutParams(ekpVarAr);
            this.h.setOnClickListener(new ch(this, 5));
        }
    }

    public final void ay() {
        if (this.t == null) {
            ddp ddpVar = new ddp();
            ddpVar.a = 0;
            ddpVar.b = 0;
            ddpVar.c = Integer.MIN_VALUE;
            ddpVar.d = Integer.MIN_VALUE;
            ddpVar.e = 0;
            ddpVar.f = 0;
            ddpVar.g = false;
            ddpVar.h = false;
            this.t = ddpVar;
        }
    }

    public final void az() {
        ba();
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView.a == null) {
            cbw cbwVar = (cbw) actionMenuView.getMenu();
            if (this.al == null) {
                this.al = new eko(this);
            }
            this.a.setExpandedActionViewsExclusive(true);
            cbwVar.aa(this.al, this.j);
            bl();
        }
    }

    public final void ba() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.ai);
            ActionMenuView actionMenuView2 = this.a;
            ekm ekmVar = new ekm(this);
            actionMenuView2.getClass();
            actionMenuView2.h = ekmVar;
            ekp ekpVarAr = ar();
            ekpVarAr.a = (this.n & 112) | 8388613;
            this.a.setLayoutParams(ekpVarAr);
            aw(this.a, false);
        }
    }

    public final void bb() {
        if (this.d == null) {
            this.d = new ij(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            ekp ekpVarAr = ar();
            ekpVarAr.a = (this.n & 112) | 8388611;
            this.d.setLayoutParams(ekpVarAr);
        }
    }

    public final int bc(View view, int i) {
        ekp ekpVar = (ekp) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = ekpVar.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.w & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight)
                    - ((ViewGroup.MarginLayoutParams) ekpVar).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) ekpVar).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) ekpVar).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    public void bd(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final void be() {
        Iterator it = this.ah.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.ag.h).iterator();
        while (it2.hasNext()) {
            ((bdy) it2.next()).a.bg();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.ah = currentMenuItems2;
    }

    public final boolean bf(View view) {
        return view.getParent() == this || this.ae.contains(view);
    }

    public final int bg(View view, int i, int i2, int[] iArr) {
        ekp ekpVar = (ekp) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) ekpVar).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int iBc = bc(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iBc, iMax + measuredWidth, view.getMeasuredHeight() + iBc);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) ekpVar).rightMargin + iMax;
    }

    public final int bh(View view, int i, int i2, int[] iArr) {
        ekp ekpVar = (ekp) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) ekpVar).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iBc = bc(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iBc, iMax, view.getMeasuredHeight() + iBc);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) ekpVar).leftMargin);
    }

    public final int bi(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(
                ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2,
                        marginLayoutParams.width),
                ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin
                        + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void bj(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft()
                + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3,
                getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin,
                marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean bk(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final void bl() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = ekn.a(this);
            eko ekoVar = this.al;
            boolean z = (ekoVar == null || ekoVar.b == null || onBackInvokedDispatcherA == null || !isAttachedToWindow()
                    || !this.ap) ? false : true;
            if (z && this.ao == null) {
                if (this.an == null) {
                    this.an = ekn.b(new ekl(this, 0));
                }
                ekn.createInstanceWithArgs(onBackInvokedDispatcherA, this.an);
                this.ao = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.ao) == null) {
                return;
            }
            ekn.d(onBackInvokedDispatcher, this.an);
            this.ao = null;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof ekp);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return ar();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(
            ViewGroup.LayoutParams layoutParams) {
        return as(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        ij ijVar = this.h;
        if (ijVar != null) {
            return ijVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ij ijVar = this.h;
        if (ijVar != null) {
            return ijVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        ddp ddpVar = this.t;
        if (ddpVar != null) {
            return ddpVar.g ? ddpVar.a : ddpVar.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        ddp ddpVar = this.t;
        if (ddpVar != null) {
            return ddpVar.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        ddp ddpVar = this.t;
        if (ddpVar != null) {
            return ddpVar.b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        ddp ddpVar = this.t;
        if (ddpVar != null) {
            return ddpVar.g ? ddpVar.b : ddpVar.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        cbw cbwVar;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (cbwVar = actionMenuView.a) == null || !cbwVar.hasVisibleItems())
                ? getContentInsetEnd()
                : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0))
                : getContentInsetStart();
    }

    public Drawable getLogo() {
        il ilVar = this.e;
        if (ilVar != null) {
            return ilVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        il ilVar = this.e;
        if (ilVar != null) {
            return ilVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        az();
        return this.a.getMenu();
    }

    public View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        ij ijVar = this.d;
        if (ijVar != null) {
            return ijVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ij ijVar = this.d;
        if (ijVar != null) {
            return ijVar.getDrawable();
        }
        return null;
    }

    public cw getOuterActionMenuPresenter() {
        return this.ak;
    }

    public Drawable getOverflowIcon() {
        az();
        return this.a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public final TextView getTitleTextView() {
        return this.b;
    }

    public ajv getWrapper() {
        Drawable drawable;
        if (this.aj == null) {
            ekt ektVar = new ekt();
            ektVar.n = 0;
            ektVar.a = this;
            ektVar.h = getTitle();
            ektVar.i = getSubtitle();
            ektVar.g = ektVar.h != null;
            ektVar.f = getNavigationIcon();
            FactoryPools factoryPoolsVarK = FactoryPools.k(getContext(), null, cyf.a, R.attr.actionBarStyle);
            TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
            ektVar.o = factoryPoolsVarK.s(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                ektVar.g = true;
                ektVar.h = text;
                if ((ektVar.b & 8) != 0) {
                    setTitle(text);
                    if (ektVar.g) {
                        ViewCompat.setAccessibilityPaneTitle(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                ektVar.i = text2;
                if ((ektVar.b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable drawableS = factoryPoolsVarK.s(20);
            if (drawableS != null) {
                ektVar.e = drawableS;
                ektVar.r();
            }
            Drawable drawableS2 = factoryPoolsVarK.s(17);
            if (drawableS2 != null) {
                ektVar.d = drawableS2;
                ektVar.r();
            }
            if (ektVar.f == null && (drawable = ektVar.o) != null) {
                ektVar.f = drawable;
                if ((ektVar.b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            ektVar.p(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = ektVar.c;
                if (view != null && (ektVar.b & 16) != 0) {
                    removeView(view);
                }
                ektVar.c = viewInflate;
                if (viewInflate != null && (ektVar.b & 16) != 0) {
                    addView(viewInflate);
                }
                ektVar.p(ektVar.b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int iMax = Math.max(dimensionPixelOffset, 0);
                int iMax2 = Math.max(dimensionPixelOffset2, 0);
                ay();
                this.t.i(iMax, iMax2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.l = resourceId2;
                jp jpVar = this.b;
                if (jpVar != null) {
                    jpVar.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.m = resourceId3;
                jp jpVar2 = this.c;
                if (jpVar2 != null) {
                    jpVar2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            factoryPoolsVarK.ae();
            if (R.string.abc_action_bar_up_description != ektVar.n) {
                ektVar.n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i = ektVar.n;
                    ektVar.j = i != 0 ? getContext().getString(i) : null;
                    ektVar.q();
                }
            }
            ektVar.j = getNavigationContentDescription();
            setNavigationOnClickListener(new cag(ektVar));
            this.aj = ektVar;
        }
        return this.aj;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        bl();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.aq);
        bl();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.ac = false;
        }
        if (!this.ac) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.ac = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.ac = false;
        return true;
    }

    /* JADX WARN: Found duplicated region for block: B:100:0x027d */
    /*
     * JADX WARN: Found duplicated region for block: B:103:0x028f A[LOOP:0:
     * B:102:0x028d->B:103:0x028f, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:106:0x02a7 A[LOOP:1:
     * B:105:0x02a5->B:106:0x02a7, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:109:0x02c7 A[LOOP:2:
     * B:108:0x02c5->B:109:0x02c7, LOOP_END, MOVE_INLINED]
     */
    /* JADX WARN: Found duplicated region for block: B:113:0x030d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:114:0x030f */
    /* JADX WARN: Found duplicated region for block: B:115:0x0313 */
    /*
     * JADX WARN: Found duplicated region for block: B:118:0x031a A[LOOP:3:
     * B:117:0x0318->B:118:0x031a, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:19:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:20:0x0064 */
    /* JADX WARN: Found duplicated region for block: B:21:0x006b */
    /* JADX WARN: Found duplicated region for block: B:24:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:25:0x007b */
    /* JADX WARN: Found duplicated region for block: B:26:0x0082 */
    /* JADX WARN: Found duplicated region for block: B:29:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:30:0x00b8 */
    /* JADX WARN: Found duplicated region for block: B:31:0x00bf */
    /* JADX WARN: Found duplicated region for block: B:34:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:35:0x00cf */
    /* JADX WARN: Found duplicated region for block: B:36:0x00d6 */
    /* JADX WARN: Found duplicated region for block: B:39:0x00ea */
    /* JADX WARN: Found duplicated region for block: B:40:0x0101 */
    /* JADX WARN: Found duplicated region for block: B:42:0x0106 */
    /* JADX WARN: Found duplicated region for block: B:43:0x011f */
    /* JADX WARN: Found duplicated region for block: B:46:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:47:0x0127 */
    /* JADX WARN: Found duplicated region for block: B:48:0x012a */
    /* JADX WARN: Found duplicated region for block: B:50:0x012e */
    /* JADX WARN: Found duplicated region for block: B:51:0x0131 */
    /* JADX WARN: Found duplicated region for block: B:54:0x0143 */
    /*
     * JADX WARN: Found duplicated region for block: B:56:0x014b A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:63:0x0164 */
    /* JADX WARN: Found duplicated region for block: B:65:0x0168 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:67:0x0179 */
    /* JADX WARN: Found duplicated region for block: B:68:0x017b */
    /* JADX WARN: Found duplicated region for block: B:70:0x0187 */
    /* JADX WARN: Found duplicated region for block: B:72:0x0193 */
    /* JADX WARN: Found duplicated region for block: B:73:0x019d */
    /* JADX WARN: Found duplicated region for block: B:75:0x01aa A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:76:0x01ac */
    /* JADX WARN: Found duplicated region for block: B:77:0x01af */
    /* JADX WARN: Found duplicated region for block: B:80:0x01c2 */
    /* JADX WARN: Found duplicated region for block: B:81:0x01e6 */
    /* JADX WARN: Found duplicated region for block: B:83:0x01e9 */
    /* JADX WARN: Found duplicated region for block: B:84:0x020d */
    /* JADX WARN: Found duplicated region for block: B:86:0x0210 */
    /* JADX WARN: Found duplicated region for block: B:88:0x0218 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:89:0x021a */
    /* JADX WARN: Found duplicated region for block: B:91:0x021e */
    /* JADX WARN: Found duplicated region for block: B:94:0x0232 */
    /* JADX WARN: Found duplicated region for block: B:95:0x0255 */
    /* JADX WARN: Found duplicated region for block: B:97:0x0258 */
    /* JADX WARN: Found duplicated region for block: B:98:0x027a */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iBg;
        int iBh;
        int iMax;
        int iMin;
        boolean zBk;
        boolean zBk2;
        boolean z2;
        int measuredHeight;
        ekp ekpVar;
        ekp ekpVar2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        int i9;
        int i10;
        int i11;
        int iMax2;
        int i12;
        int i13;
        int i14;
        int i15;
        ArrayList arrayList;
        int size;
        int iBg2;
        int i16;
        int size2;
        int i17;
        int i18;
        int size3;
        int i19;
        int i20;
        int measuredWidth;
        int i21;
        int i22;
        int i23;
        int size4;
        boolean z4 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i24 = width - paddingRight;
        int[] iArr = this.af;
        iArr[1] = 0;
        iArr[0] = 0;
        WeakHashMap weakHashMap = ViewCompat.a;
        int minimumHeight = getMinimumHeight();
        int iMin2 = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (bk(this.d)) {
            if (z4) {
                iBh = bh(this.d, i24, iMin2, iArr);
                iBg = paddingLeft;
            } else {
                iBg = bg(this.d, paddingLeft, iMin2, iArr);
            }
            if (bk(this.h)) {
                if (z4) {
                    iBh = bh(this.h, iBh, iMin2, iArr);
                } else {
                    iBg = bg(this.h, iBg, iMin2, iArr);
                }
            }
            if (bk(this.a)) {
                if (z4) {
                    iBg = bg(this.a, iBg, iMin2, iArr);
                } else {
                    iBh = bh(this.a, iBh, iMin2, iArr);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iBg);
            iArr[1] = Math.max(0, currentContentInsetRight - (i24 - iBh));
            iMax = Math.max(iBg, currentContentInsetLeft);
            iMin = Math.min(iBh, i24 - currentContentInsetRight);
            if (bk(this.i)) {
                if (z4) {
                    iMin = bh(this.i, iMin, iMin2, iArr);
                } else {
                    iMax = bg(this.i, iMax, iMin2, iArr);
                }
            }
            if (bk(this.e)) {
                if (z4) {
                    iMin = bh(this.e, iMin, iMin2, iArr);
                } else {
                    iMax = bg(this.e, iMax, iMin2, iArr);
                }
            }
            zBk = bk(this.b);
            zBk2 = bk(this.c);
            if (zBk) {
                ekp ekpVar3 = (ekp) this.b.getLayoutParams();
                z2 = z4;
                measuredHeight = this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ekpVar3).topMargin
                        + ((ViewGroup.MarginLayoutParams) ekpVar3).bottomMargin;
            } else {
                z2 = z4;
                measuredHeight = 0;
            }
            if (zBk2) {
                ekp ekpVar4 = (ekp) this.c.getLayoutParams();
                measuredHeight = this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ekpVar4).topMargin
                        + ((ViewGroup.MarginLayoutParams) ekpVar4).bottomMargin + measuredHeight;
            }
            if (zBk || zBk2) {
                jp jpVar = zBk ? this.b : this.c;
                jp jpVar2 = zBk2 ? this.c : this.b;
                ekpVar = (ekp) jpVar.getLayoutParams();
                ekpVar2 = (ekp) jpVar2.getLayoutParams();
                i5 = measuredHeight;
                z3 = (!zBk && this.b.getMeasuredWidth() > 0) || (zBk2 && this.c.getMeasuredWidth() > 0);
                i6 = this.w & 112;
                i7 = iMax;
                if (i6 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
                } else if (i6 != 80) {
                    iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                    i12 = ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
                    if (iMax2 < i12) {
                        iMax2 = i12;
                    } else {
                        i13 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                        i14 = ((ViewGroup.MarginLayoutParams) ekpVar).bottomMargin;
                        i15 = this.s;
                        if (i13 < i14 + i15) {
                            iMax2 = Math.max(0,
                                    iMax2 - ((((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin + i15) - i13));
                        }
                    }
                    paddingTop = paddingTop2 + iMax2;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin)
                            - this.s) - i5;
                }
                if (z2) {
                    int i25 = (z3 ? this.p : 0) - iArr[1];
                    iMin -= Math.max(0, i25);
                    iArr[1] = Math.max(0, -i25);
                    if (zBk) {
                        ekp ekpVar5 = (ekp) this.b.getLayoutParams();
                        int measuredWidth2 = iMin - this.b.getMeasuredWidth();
                        int measuredHeight2 = this.b.getMeasuredHeight() + paddingTop;
                        this.b.layout(measuredWidth2, paddingTop, iMin, measuredHeight2);
                        i10 = measuredWidth2 - this.q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ekpVar5).bottomMargin;
                    } else {
                        i10 = iMin;
                    }
                    if (zBk2) {
                        int i26 = paddingTop
                                + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                        this.c.layout(iMin - this.c.getMeasuredWidth(), i26, iMin, this.c.getMeasuredHeight() + i26);
                        i11 = iMin - this.q;
                    } else {
                        i11 = iMin;
                    }
                    if (z3) {
                        iMin = Math.min(i10, i11);
                    }
                    iMax = i7;
                } else {
                    int i27 = (z3 ? this.p : 0) - iArr[0];
                    iMax = Math.max(0, i27) + i7;
                    iArr[0] = Math.max(0, -i27);
                    if (zBk) {
                        ekp ekpVar6 = (ekp) this.b.getLayoutParams();
                        int measuredWidth3 = this.b.getMeasuredWidth() + iMax;
                        int measuredHeight3 = this.b.getMeasuredHeight() + paddingTop;
                        this.b.layout(iMax, paddingTop, measuredWidth3, measuredHeight3);
                        i8 = measuredWidth3 + this.q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) ekpVar6).bottomMargin;
                    } else {
                        i8 = iMax;
                    }
                    if (zBk2) {
                        int i28 = paddingTop
                                + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                        int measuredWidth4 = this.c.getMeasuredWidth() + iMax;
                        this.c.layout(iMax, i28, measuredWidth4, this.c.getMeasuredHeight() + i28);
                        i9 = measuredWidth4 + this.q;
                    } else {
                        i9 = iMax;
                    }
                    if (z3) {
                        iMax = Math.max(i8, i9);
                    }
                }
            }
            arrayList = this.ad;
            av(3, arrayList);
            size = arrayList.size();
            iBg2 = iMax;
            for (i16 = 0; i16 < size; i16++) {
                iBg2 = bg((View) arrayList.get(i16), iBg2, iMin2, iArr);
            }
            av(5, arrayList);
            size2 = arrayList.size();
            for (i17 = 0; i17 < size2; i17++) {
                iMin = bh((View) arrayList.get(i17), iMin, iMin2, iArr);
            }
            av(1, arrayList);
            int i29 = iArr[0];
            i18 = iArr[1];
            size3 = arrayList.size();
            i19 = i29;
            i20 = 0;
            measuredWidth = 0;
            while (i20 < size3) {
                View view = (View) arrayList.get(i20);
                ekp ekpVar7 = (ekp) view.getLayoutParams();
                int i30 = i18;
                int i31 = ((ViewGroup.MarginLayoutParams) ekpVar7).leftMargin - i19;
                int i32 = ((ViewGroup.MarginLayoutParams) ekpVar7).rightMargin - i30;
                int iMax3 = Math.max(0, i31);
                int iMax4 = Math.max(0, i32);
                int iMax5 = Math.max(0, -i31);
                int iMax6 = Math.max(0, -i32);
                measuredWidth += view.getMeasuredWidth() + iMax3 + iMax4;
                i20++;
                i19 = iMax5;
                i18 = iMax6;
            }
            i22 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
            i23 = measuredWidth + i22;
            if (i22 >= iBg2) {
                iBg2 = i23 > iMin ? i22 - (i23 - iMin) : i22;
            }
            size4 = arrayList.size();
            for (i21 = 0; i21 < size4; i21++) {
                iBg2 = bg((View) arrayList.get(i21), iBg2, iMin2, iArr);
            }
            arrayList.clear();
        }
        iBg = paddingLeft;
        iBh = i24;
        if (bk(this.h)) {
            if (z4) {
                iBh = bh(this.h, iBh, iMin2, iArr);
            } else {
                iBg = bg(this.h, iBg, iMin2, iArr);
            }
        }
        if (bk(this.a)) {
            if (z4) {
                iBg = bg(this.a, iBg, iMin2, iArr);
            } else {
                iBh = bh(this.a, iBh, iMin2, iArr);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iBg);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i24 - iBh));
        iMax = Math.max(iBg, currentContentInsetLeft2);
        iMin = Math.min(iBh, i24 - currentContentInsetRight2);
        if (bk(this.i)) {
            if (z4) {
                iMin = bh(this.i, iMin, iMin2, iArr);
            } else {
                iMax = bg(this.i, iMax, iMin2, iArr);
            }
        }
        if (bk(this.e)) {
            if (z4) {
                iMin = bh(this.e, iMin, iMin2, iArr);
            } else {
                iMax = bg(this.e, iMax, iMin2, iArr);
            }
        }
        zBk = bk(this.b);
        zBk2 = bk(this.c);
        if (zBk) {
            ekp ekpVar32 = (ekp) this.b.getLayoutParams();
            z2 = z4;
            measuredHeight = this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ekpVar32).topMargin
                    + ((ViewGroup.MarginLayoutParams) ekpVar32).bottomMargin;
        } else {
            z2 = z4;
            measuredHeight = 0;
        }
        if (zBk2) {
            ekp ekpVar42 = (ekp) this.c.getLayoutParams();
            measuredHeight = this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) ekpVar42).topMargin
                    + ((ViewGroup.MarginLayoutParams) ekpVar42).bottomMargin + measuredHeight;
        }
        if (zBk) {
            if (zBk) {
            }
            if (zBk2) {
            }
            ekpVar = (ekp) jpVar.getLayoutParams();
            ekpVar2 = (ekp) jpVar2.getLayoutParams();
            i5 = measuredHeight;
            if (zBk) {
            }
            i6 = this.w & 112;
            i7 = iMax;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                i12 = ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
                if (iMax2 < i12) {
                    iMax2 = i12;
                } else {
                    i13 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                    i14 = ((ViewGroup.MarginLayoutParams) ekpVar).bottomMargin;
                    i15 = this.s;
                    if (i13 < i14 + i15) {
                        iMax2 = Math.max(0,
                                iMax2 - ((((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin + i15) - i13));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin)
                        - this.s) - i5;
            }
            if (z2) {
                int i252 = (z3 ? this.p : 0) - iArr[1];
                iMin -= Math.max(0, i252);
                iArr[1] = Math.max(0, -i252);
                if (zBk) {
                    ekp ekpVar52 = (ekp) this.b.getLayoutParams();
                    int measuredWidth22 = iMin - this.b.getMeasuredWidth();
                    int measuredHeight22 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth22, paddingTop, iMin, measuredHeight22);
                    i10 = measuredWidth22 - this.q;
                    paddingTop = measuredHeight22 + ((ViewGroup.MarginLayoutParams) ekpVar52).bottomMargin;
                } else {
                    i10 = iMin;
                }
                if (zBk2) {
                    int i262 = paddingTop + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                    this.c.layout(iMin - this.c.getMeasuredWidth(), i262, iMin, this.c.getMeasuredHeight() + i262);
                    i11 = iMin - this.q;
                } else {
                    i11 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i10, i11);
                }
                iMax = i7;
            } else {
                int i272 = (z3 ? this.p : 0) - iArr[0];
                iMax = Math.max(0, i272) + i7;
                iArr[0] = Math.max(0, -i272);
                if (zBk) {
                    ekp ekpVar62 = (ekp) this.b.getLayoutParams();
                    int measuredWidth32 = this.b.getMeasuredWidth() + iMax;
                    int measuredHeight32 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(iMax, paddingTop, measuredWidth32, measuredHeight32);
                    i8 = measuredWidth32 + this.q;
                    paddingTop = measuredHeight32 + ((ViewGroup.MarginLayoutParams) ekpVar62).bottomMargin;
                } else {
                    i8 = iMax;
                }
                if (zBk2) {
                    int i282 = paddingTop + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                    int measuredWidth42 = this.c.getMeasuredWidth() + iMax;
                    this.c.layout(iMax, i282, measuredWidth42, this.c.getMeasuredHeight() + i282);
                    i9 = measuredWidth42 + this.q;
                } else {
                    i9 = iMax;
                }
                if (z3) {
                    iMax = Math.max(i8, i9);
                }
            }
        } else {
            if (zBk) {
            }
            if (zBk2) {
            }
            ekpVar = (ekp) jpVar.getLayoutParams();
            ekpVar2 = (ekp) jpVar2.getLayoutParams();
            i5 = measuredHeight;
            if (zBk) {
            }
            i6 = this.w & 112;
            i7 = iMax;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
            } else if (i6 != 80) {
                iMax2 = (((height - paddingTop2) - paddingBottom) - i5) / 2;
                i12 = ((ViewGroup.MarginLayoutParams) ekpVar).topMargin + this.r;
                if (iMax2 < i12) {
                    iMax2 = i12;
                } else {
                    i13 = (((height - paddingBottom) - i5) - iMax2) - paddingTop2;
                    i14 = ((ViewGroup.MarginLayoutParams) ekpVar).bottomMargin;
                    i15 = this.s;
                    if (i13 < i14 + i15) {
                        iMax2 = Math.max(0,
                                iMax2 - ((((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin + i15) - i13));
                    }
                }
                paddingTop = paddingTop2 + iMax2;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) ekpVar2).bottomMargin)
                        - this.s) - i5;
            }
            if (z2) {
                int i2522 = (z3 ? this.p : 0) - iArr[1];
                iMin -= Math.max(0, i2522);
                iArr[1] = Math.max(0, -i2522);
                if (zBk) {
                    ekp ekpVar522 = (ekp) this.b.getLayoutParams();
                    int measuredWidth222 = iMin - this.b.getMeasuredWidth();
                    int measuredHeight222 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(measuredWidth222, paddingTop, iMin, measuredHeight222);
                    i10 = measuredWidth222 - this.q;
                    paddingTop = measuredHeight222 + ((ViewGroup.MarginLayoutParams) ekpVar522).bottomMargin;
                } else {
                    i10 = iMin;
                }
                if (zBk2) {
                    int i2622 = paddingTop
                            + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                    this.c.layout(iMin - this.c.getMeasuredWidth(), i2622, iMin, this.c.getMeasuredHeight() + i2622);
                    i11 = iMin - this.q;
                } else {
                    i11 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i10, i11);
                }
                iMax = i7;
            } else {
                int i2722 = (z3 ? this.p : 0) - iArr[0];
                iMax = Math.max(0, i2722) + i7;
                iArr[0] = Math.max(0, -i2722);
                if (zBk) {
                    ekp ekpVar622 = (ekp) this.b.getLayoutParams();
                    int measuredWidth322 = this.b.getMeasuredWidth() + iMax;
                    int measuredHeight322 = this.b.getMeasuredHeight() + paddingTop;
                    this.b.layout(iMax, paddingTop, measuredWidth322, measuredHeight322);
                    i8 = measuredWidth322 + this.q;
                    paddingTop = measuredHeight322 + ((ViewGroup.MarginLayoutParams) ekpVar622).bottomMargin;
                } else {
                    i8 = iMax;
                }
                if (zBk2) {
                    int i2822 = paddingTop
                            + ((ViewGroup.MarginLayoutParams) ((ekp) this.c.getLayoutParams())).topMargin;
                    int measuredWidth422 = this.c.getMeasuredWidth() + iMax;
                    this.c.layout(iMax, i2822, measuredWidth422, this.c.getMeasuredHeight() + i2822);
                    i9 = measuredWidth422 + this.q;
                } else {
                    i9 = iMax;
                }
                if (z3) {
                    iMax = Math.max(i8, i9);
                }
            }
        }
        arrayList = this.ad;
        av(3, arrayList);
        size = arrayList.size();
        iBg2 = iMax;
        while (i16 < size) {
            iBg2 = bg((View) arrayList.get(i16), iBg2, iMin2, iArr);
        }
        av(5, arrayList);
        size2 = arrayList.size();
        while (i17 < size2) {
            iMin = bh((View) arrayList.get(i17), iMin, iMin2, iArr);
        }
        av(1, arrayList);
        int i292 = iArr[0];
        i18 = iArr[1];
        size3 = arrayList.size();
        i19 = i292;
        i20 = 0;
        measuredWidth = 0;
        while (i20 < size3) {
            View view2 = (View) arrayList.get(i20);
            ekp ekpVar72 = (ekp) view2.getLayoutParams();
            int i302 = i18;
            int i312 = ((ViewGroup.MarginLayoutParams) ekpVar72).leftMargin - i19;
            int i322 = ((ViewGroup.MarginLayoutParams) ekpVar72).rightMargin - i302;
            int iMax32 = Math.max(0, i312);
            int iMax42 = Math.max(0, i322);
            int iMax52 = Math.max(0, -i312);
            int iMax62 = Math.max(0, -i322);
            measuredWidth += view2.getMeasuredWidth() + iMax32 + iMax42;
            i20++;
            i19 = iMax52;
            i18 = iMax62;
        }
        i22 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        i23 = measuredWidth + i22;
        if (i22 >= iBg2) {
            if (i23 > iMin) {
            }
        }
        size4 = arrayList.size();
        while (i21 < size4) {
            iBg2 = bg((View) arrayList.get(i21), iBg2, iMin2, iArr);
        }
        arrayList.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        Object[] objArr;
        int iAt;
        int iMax;
        int iCombineMeasuredStates;
        int iAt2;
        int iAu;
        int iCombineMeasuredStates2;
        int iMax2;
        int i3 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c = 0;
        } else {
            c = 1;
            objArr = false;
        }
        if (bk(this.d)) {
            bj(this.d, i, 0, i2, this.o);
            iAt = at(this.d) + this.d.getMeasuredWidth();
            iMax = Math.max(0, au(this.d) + this.d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            iAt = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (bk(this.h)) {
            bj(this.h, i, 0, i2, this.o);
            iAt = at(this.h) + this.h.getMeasuredWidth();
            iMax = Math.max(iMax, au(this.h) + this.h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iAt);
        int iMax4 = Math.max(0, currentContentInsetStart - iAt);
        Object[] objArr2 = objArr;
        int[] iArr = this.af;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (bk(this.a)) {
            bj(this.a, i, iMax3, i2, this.o);
            iAt2 = at(this.a) + this.a.getMeasuredWidth();
            iMax = Math.max(iMax, au(this.a) + this.a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.a.getMeasuredState());
        } else {
            iAt2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iAt2);
        iArr[c] = Math.max(0, currentContentInsetEnd - iAt2);
        if (bk(this.i)) {
            iMax5 += bi(this.i, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, au(this.i) + this.i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.i.getMeasuredState());
        }
        if (bk(this.e)) {
            iMax5 += bi(this.e, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, au(this.e) + this.e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((ekp) childAt.getLayoutParams()).b == 0 && bk(childAt)) {
                iMax5 += bi(childAt, i, iMax5, i2, 0, iArr);
                int iMax6 = Math.max(iMax, au(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i5 = iMax5;
        int i6 = this.r + this.s;
        int i7 = this.p + this.q;
        if (bk(this.b)) {
            bi(this.b, i, i5 + i7, i2, i6, iArr);
            int iAt3 = at(this.b) + this.b.getMeasuredWidth();
            iAu = au(this.b) + this.b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
            iMax2 = iAt3;
        } else {
            iAu = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (bk(this.c)) {
            iMax2 = Math.max(iMax2, bi(this.c, i, i5 + i7, i2, i6 + iAu, iArr));
            iAu += au(this.c) + this.c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.c.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iAu);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i5 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i,
                (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2,
                iCombineMeasuredStates2 << 16);
        if (!this.am) {
            i3 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            View childAt2 = getChildAt(i8);
            if (bk(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i3 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof ekr)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ekr ekrVar = (ekr) parcelable;
        super.onRestoreInstanceState(ekrVar.g);
        ActionMenuView actionMenuView = this.a;
        cbw cbwVar = actionMenuView != null ? actionMenuView.a : null;
        int i = ekrVar.a;
        if (i != 0 && this.al != null && cbwVar != null && (menuItemFindItem = cbwVar.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (ekrVar.b) {
            dc dcVar = this.aq;
            removeCallbacks(dcVar);
            post(dcVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        ay();
        ddp ddpVar = this.t;
        boolean z = i == 1;
        if (z == ddpVar.g) {
            return;
        }
        ddpVar.g = z;
        if (!ddpVar.h) {
            ddpVar.a = ddpVar.e;
            ddpVar.b = ddpVar.f;
            return;
        }
        if (z) {
            int i2 = ddpVar.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = ddpVar.e;
            }
            ddpVar.a = i2;
            int i3 = ddpVar.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = ddpVar.f;
            }
            ddpVar.b = i3;
            return;
        }
        int i4 = ddpVar.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = ddpVar.e;
        }
        ddpVar.a = i4;
        int i5 = ddpVar.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = ddpVar.f;
        }
        ddpVar.b = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        cw cwVar;
        cbz cbzVar;
        ekr ekrVar = new ekr(super.onSaveInstanceState());
        eko ekoVar = this.al;
        if (ekoVar != null && (cbzVar = ekoVar.b) != null) {
            ekrVar.a = cbzVar.a;
        }
        ActionMenuView actionMenuView = this.a;
        ekrVar.b = (actionMenuView == null || (cwVar = actionMenuView.g) == null || !cwVar.ai()) ? false : true;
        return ekrVar;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.ab = false;
        }
        if (!this.ab) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.ab = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.ab = false;
        return true;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.ap != z) {
            this.ap = z;
            bl();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(cmz.y(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.am = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(cmz.y(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(cmz.y(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        bb();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(ekq ekqVar) {
    }

    public void setOverflowIcon(Drawable drawable) {
        az();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.w = 8388627;
        this.ad = new ArrayList();
        this.ae = new ArrayList();
        this.af = new int[2];
        this.ag = new FactoryPools(new ekl(this, 1));
        this.ah = new ArrayList();
        this.ai = new ekm(this);
        this.aq = new dc(this, 18);
        Context context2 = getContext();
        int[] iArr = cyf.x;
        FactoryPools factoryPoolsVarK = FactoryPools.k(context2, attributeSet, iArr, R.attr.toolbarStyle);
        ViewCompat.r(this, context, iArr, attributeSet, (TypedArray) factoryPoolsVarK.e, R.attr.toolbarStyle, 0);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        this.l = typedArray.getResourceId(28, 0);
        this.m = typedArray.getResourceId(19, 0);
        this.w = typedArray.getInteger(0, 8388627);
        this.n = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset)
                : dimensionPixelOffset;
        this.s = dimensionPixelOffset;
        this.r = dimensionPixelOffset;
        this.q = dimensionPixelOffset;
        this.p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.s = dimensionPixelOffset5;
        }
        this.o = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        ay();
        ddp ddpVar = this.t;
        ddpVar.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            ddpVar.e = dimensionPixelSize;
            ddpVar.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            ddpVar.f = dimensionPixelSize2;
            ddpVar.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            ddpVar.i(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.u = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.v = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f = factoryPoolsVarK.s(4);
        this.g = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.j = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableS = factoryPoolsVarK.s(16);
        if (drawableS != null) {
            setNavigationIcon(drawableS);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableS2 = factoryPoolsVarK.s(11);
        if (drawableS2 != null) {
            setLogo(drawableS2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(factoryPoolsVarK.r(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(factoryPoolsVarK.r(20));
        }
        if (typedArray.hasValue(14)) {
            bd(typedArray.getResourceId(14, 0));
        }
        factoryPoolsVarK.ae();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ekp ekpVar = new ekp(context, attributeSet);
        ekpVar.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cyf.b);
        ekpVar.a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        ekpVar.b = 0;
        return ekpVar;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ax();
        }
        ij ijVar = this.h;
        if (ijVar != null) {
            ijVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ax();
            this.h.setImageDrawable(drawable);
        } else {
            ij ijVar = this.h;
            if (ijVar != null) {
                ijVar.setImageDrawable(this.f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.e == null) {
                this.e = new il(getContext());
            }
            if (!bf(this.e)) {
                aw(this.e, true);
            }
        } else {
            il ilVar = this.e;
            if (ilVar != null && bf(ilVar)) {
                removeView(this.e);
                this.ae.remove(this.e);
            }
        }
        il ilVar2 = this.e;
        if (ilVar2 != null) {
            ilVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.e == null) {
            this.e = new il(getContext());
        }
        il ilVar = this.e;
        if (ilVar != null) {
            ilVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            bb();
        }
        ij ijVar = this.d;
        if (ijVar != null) {
            ijVar.setContentDescription(charSequence);
            eku.a(this.d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            bb();
            if (!bf(this.d)) {
                aw(this.d, true);
            }
        } else {
            ij ijVar = this.d;
            if (ijVar != null && bf(ijVar)) {
                removeView(this.d);
                this.ae.remove(this.d);
            }
        }
        ij ijVar2 = this.d;
        if (ijVar2 != null) {
            ijVar2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            jp jpVar = this.c;
            if (jpVar != null && bf(jpVar)) {
                removeView(this.c);
                this.ae.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                jp jpVar2 = new jp(context, null);
                this.c = jpVar2;
                jpVar2.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.aa;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!bf(this.c)) {
                aw(this.c, true);
            }
        }
        jp jpVar3 = this.c;
        if (jpVar3 != null) {
            jpVar3.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.aa = colorStateList;
        jp jpVar = this.c;
        if (jpVar != null) {
            jpVar.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            jp jpVar = this.b;
            if (jpVar != null && bf(jpVar)) {
                removeView(this.b);
                this.ae.remove(this.b);
            }
        } else {
            if (this.b == null) {
                Context context = getContext();
                jp jpVar2 = new jp(context, null);
                this.b = jpVar2;
                jpVar2.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
            }
            if (!bf(this.b)) {
                aw(this.b, true);
            }
        }
        jp jpVar3 = this.b;
        if (jpVar3 != null) {
            jpVar3.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        jp jpVar = this.b;
        if (jpVar != null) {
            jpVar.setTextColor(colorStateList);
        }
    }
}
