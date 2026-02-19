package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import java.util.HashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cka extends ViewGroup implements cco {
    public static final int[] i = { R.attr.state_checked };
    public static final int[] j = { -16842910 };
    public ColorStateList aa;
    public int ab;
    public final SparseArray ac;
    public int ad;
    public int ae;
    public int af;
    public boolean ag;
    public int ah;
    public int ai;
    public int aj;
    public dgm ak;
    public boolean al;
    public ColorStateList am;
    public ckc an;
    public cbw ao;
    public final mi k;
    public final ch l;
    public final cux m;
    public final SparseArray n;
    public int o;
    public cjy[] p;
    public int q;
    public int r;
    public ColorStateList s;
    public int t;
    public ColorStateList u;
    public final ColorStateList v;
    public int w;
    public int x;
    public boolean y;
    public Drawable z;

    public cka(Context context) {
        super(context);
        this.m = new cux(5);
        this.n = new SparseArray(5);
        this.q = 0;
        this.r = 0;
        this.ac = new SparseArray(5);
        this.ad = -1;
        this.ae = -1;
        this.af = -1;
        this.al = false;
        this.v = ar();
        if (isInEditMode()) {
            this.k = null;
        } else {
            mi miVar = new mi();
            this.k = miVar;
            miVar._at(0);
            miVar.r(ajn.ad(getContext(), me.hd.wauxv.R.attr.motionDurationMedium4,
                    getResources().getInteger(me.hd.wauxv.R.integer.material_motion_duration_long_1)));
            miVar.t(ajn.ae(getContext(), me.hd.wauxv.R.attr.motionEasingStandard, ff.b));
            miVar._ar(new drf());
        }
        this.l = new ch(this, 4);
        WeakHashMap weakHashMap = ViewCompat.a;
        setImportantForAccessibility(1);
    }

    public static boolean ap(int i2, int i3) {
        return i2 == -1 ? i3 > 3 : i2 == 0;
    }

    private cjy getNewItem() {
        cjy cjyVar = (cjy) this.m.acquire();
        return cjyVar == null ? dexFind(getContext()) : cjyVar;
    }

    private void setBadgeIfNeeded(cjy cjyVar) {
        mx mxVar;
        int id = cjyVar.getId();
        if (id == -1 || (mxVar = (mx) this.ac.get(id)) == null) {
            return;
        }
        cjyVar.setBadge(mxVar);
    }

    public final void aq() {
        removeAllViews();
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                if (cjyVar != null) {
                    this.m.l(cjyVar);
                    ImageView imageView = cjyVar.r;
                    if (cjyVar.aj != null) {
                        if (imageView != null) {
                            cjyVar.setClipChildren(true);
                            cjyVar.setClipToPadding(true);
                            mx mxVar = cjyVar.aj;
                            if (mxVar != null) {
                                if (mxVar.q() != null) {
                                    mxVar.q().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(mxVar);
                                }
                            }
                        }
                        cjyVar.aj = null;
                    }
                    cjyVar.x = null;
                    cjyVar.ad = 0.0f;
                    cjyVar.d = false;
                }
            }
        }
        if (this.ao.g.size() == 0) {
            this.q = 0;
            this.r = 0;
            this.p = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.ao.g.size(); i2++) {
            hashSet.add(Integer.valueOf(this.ao.getItem(i2).getItemId()));
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.ac;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i3++;
        }
        this.p = new cjy[this.ao.g.size()];
        boolean zAp = ap(this.o, this.ao.ak().size());
        for (int i4 = 0; i4 < this.ao.g.size(); i4++) {
            this.an.b = true;
            this.ao.getItem(i4).setCheckable(true);
            this.an.b = false;
            cjy newItem = getNewItem();
            this.p[i4] = newItem;
            newItem.setIconTintList(this.s);
            newItem.setIconSize(this.t);
            newItem.setTextColor(this.v);
            newItem.setTextAppearanceInactive(this.w);
            newItem.setTextAppearanceActive(this.x);
            newItem.setTextAppearanceActiveBoldEnabled(this.y);
            newItem.setTextColor(this.u);
            int i5 = this.ad;
            if (i5 != -1) {
                newItem.setItemPaddingTop(i5);
            }
            int i6 = this.ae;
            if (i6 != -1) {
                newItem.setItemPaddingBottom(i6);
            }
            int i7 = this.af;
            if (i7 != -1) {
                newItem.setActiveIndicatorLabelPadding(i7);
            }
            newItem.setActiveIndicatorWidth(this.ah);
            newItem.setActiveIndicatorHeight(this.ai);
            newItem.setActiveIndicatorMarginHorizontal(this.aj);
            newItem.setActiveIndicatorDrawable(as());
            newItem.setActiveIndicatorResizeable(this.al);
            newItem.setActiveIndicatorEnabled(this.ag);
            Drawable drawable = this.z;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.ab);
            }
            newItem.setItemRippleColor(this.aa);
            newItem.setShifting(zAp);
            newItem.setLabelVisibilityMode(this.o);
            cbz cbzVar = (cbz) this.ao.getItem(i4);
            newItem.n(cbzVar);
            newItem.setItemPosition(i4);
            int i8 = cbzVar.a;
            newItem.setOnTouchListener((View.OnTouchListener) this.n.get(i8));
            newItem.setOnClickListener(this.l);
            int i9 = this.q;
            if (i9 != 0 && i8 == i9) {
                this.r = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.ao.g.size() - 1, this.r);
        this.r = iMin;
        this.ao.getItem(iMin).setChecked(true);
    }

    public final ColorStateList ar() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListV = ResourcesCompat.v(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(me.hd.wauxv.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListV.getDefaultColor();
        int[] iArr = i;
        int[] iArr2 = ViewGroup.EMPTY_STATE_SET;
        int[] iArr3 = j;
        return new ColorStateList(new int[][] { iArr3, iArr, iArr2 },
                new int[] { colorStateListV.getColorForState(iArr3, defaultColor), i2, defaultColor });
    }

    public final cau as() {
        if (this.ak == null || this.am == null) {
            return null;
        }
        cau cauVar = new cau(this.ak);
        cauVar.dz(this.am);
        return cauVar;
    }

    @Override // me.hd.wauxv.obf.cco
    public final void d(cbw cbwVar) {
        this.ao = cbwVar;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.af;
    }

    public SparseArray<mx> getBadgeDrawables() {
        return this.ac;
    }

    public ColorStateList getIconTintList() {
        return this.s;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.am;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.ag;
    }

    public int getItemActiveIndicatorHeight() {
        return this.ai;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.aj;
    }

    public dgm getItemActiveIndicatorShapeAppearance() {
        return this.ak;
    }

    public int getItemActiveIndicatorWidth() {
        return this.ah;
    }

    public Drawable getItemBackground() {
        cjy[] cjyVarArr = this.p;
        return (cjyVarArr == null || cjyVarArr.length <= 0) ? this.z : cjyVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.ab;
    }

    public int getItemIconSize() {
        return this.t;
    }

    public int getItemPaddingBottom() {
        return this.ae;
    }

    public int getItemPaddingTop() {
        return this.ad;
    }

    public ColorStateList getItemRippleColor() {
        return this.aa;
    }

    public int getItemTextAppearanceActive() {
        return this.x;
    }

    public int getItemTextAppearanceInactive() {
        return this.w;
    }

    public ColorStateList getItemTextColor() {
        return this.u;
    }

    public int getLabelVisibilityMode() {
        return this.o;
    }

    public cbw getMenu() {
        return this.ao;
    }

    public int getSelectedItemId() {
        return this.q;
    }

    public int getSelectedItemPosition() {
        return this.r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public abstract cjy h(Context context);

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo
                .setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) LateinitProperty.f(1, this.ao.ak().size(), 1).e);
    }

    public void setActiveIndicatorLabelPadding(int i2) {
        this.af = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorLabelPadding(i2);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.am = colorStateList;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorDrawable(as());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.ag = z;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i2) {
        this.ai = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorHeight(i2);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i2) {
        this.aj = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorMarginHorizontal(i2);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.al = z;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(dgm dgmVar) {
        this.ak = dgmVar;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorDrawable(as());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i2) {
        this.ah = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setActiveIndicatorWidth(i2);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.z = drawable;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.ab = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(int i2) {
        this.t = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setIconSize(i2);
            }
        }
    }

    public void setItemPaddingBottom(int i2) {
        this.ae = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setItemPaddingBottom(i2);
            }
        }
    }

    public void setItemPaddingTop(int i2) {
        this.ad = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setItemPaddingTop(i2);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.aa = colorStateList;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.x = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.u;
                if (colorStateList != null) {
                    cjyVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.y = z;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setTextAppearanceActiveBoldEnabled(z);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.w = i2;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.u;
                if (colorStateList != null) {
                    cjyVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.u = colorStateList;
        cjy[] cjyVarArr = this.p;
        if (cjyVarArr != null) {
            for (cjy cjyVar : cjyVarArr) {
                cjyVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.o = i2;
    }

    public void setPresenter(ckc ckcVar) {
        this.an = ckcVar;
    }
}
