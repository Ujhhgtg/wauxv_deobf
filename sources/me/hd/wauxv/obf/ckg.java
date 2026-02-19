package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ckg extends FrameLayout {
    public final cjz b;
    public final cka c;
    public final ckc d;
    public dof e;
    public cke f;

    public ckg(Context context, int i, int i2) {
        super(cmz.aq(context, null, i, i2), null, i);
        ckc ckcVar = new ckc();
        ckcVar.b = false;
        this.d = ckcVar;
        Context context2 = getContext();
        FactoryPools factoryPoolsVarAo = FastKV.ao(context2, null, cxs.ae, i, i2, 12, 10);
        cjz cjzVar = new cjz(context2, getClass(), getMaxItemCount());
        this.b = cjzVar;
        cka ckaVarA = a(context2);
        this.c = ckaVarA;
        ckcVar.a = ckaVarA;
        ckcVar.c = 1;
        ckaVarA.setPresenter(ckcVar);
        cjzVar.aa(ckcVar, cjzVar.b);
        getContext();
        ckcVar.a.ao = cjzVar;
        TypedArray typedArray = (TypedArray) factoryPoolsVarAo.e;
        if (typedArray.hasValue(6)) {
            ckaVarA.setIconTintList(factoryPoolsVarAo.r(6));
        } else {
            ckaVarA.setIconTintList(ckaVarA.ar());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(5, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(12)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(12, 0));
        }
        if (typedArray.hasValue(10)) {
            setItemTextAppearanceActive(typedArray.getResourceId(10, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(11, true));
        if (typedArray.hasValue(13)) {
            setItemTextColor(factoryPoolsVarAo.r(13));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListX = cmz.x(background);
        if (background == null || colorStateListX != null) {
            cau cauVar = new cau(dgm.n(context2, null, i, i2).m());
            if (colorStateListX != null) {
                cauVar.dz(colorStateListX);
            }
            cauVar.dx(context2);
            WeakHashMap weakHashMap = ViewCompat.a;
            setBackground(cauVar);
        }
        if (typedArray.hasValue(8)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(8, 0));
        }
        if (typedArray.hasValue(7)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(7, 0));
        }
        if (typedArray.hasValue(0)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(0, 0));
        }
        if (typedArray.hasValue(2)) {
            setElevation(typedArray.getDimensionPixelSize(2, 0));
        }
        getBackground().mutate().setTintList(cnb.w(context2, factoryPoolsVarAo, 1));
        setLabelVisibilityMode(typedArray.getInteger(14, -1));
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            ckaVarA.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(cnb.w(context2, factoryPoolsVarAo, 9));
        }
        int resourceId2 = typedArray.getResourceId(3, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, cxs.ad);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
            setItemActiveIndicatorColor(cnb.v(context2, typedArrayObtainStyledAttributes, 2));
            setItemActiveIndicatorShapeAppearance(dgm.m(context2, typedArrayObtainStyledAttributes.getResourceId(4, 0), 0, new o(0)).m());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(15)) {
            int resourceId3 = typedArray.getResourceId(15, 0);
            ckcVar.b = true;
            getMenuInflater().inflate(resourceId3, cjzVar);
            ckcVar.b = false;
            ckcVar.ac(true);
        }
        factoryPoolsVarAo.ae();
        addView(ckaVarA);
        cjzVar.f = new SyntheticPileOfMess(this);
    }

    private MenuInflater getMenuInflater() {
        if (this.e == null) {
            this.e = new dof(getContext());
        }
        return this.e;
    }

    public abstract cka a(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.c.getActiveIndicatorLabelPadding();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.c.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.c.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.c.getItemActiveIndicatorMarginHorizontal();
    }

    public dgm getItemActiveIndicatorShapeAppearance() {
        return this.c.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.c.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.c.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.c.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.c.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.c.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.c.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.c.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.c.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.c.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.c.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.c.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.c.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.b;
    }

    public cco getMenuView() {
        return this.c;
    }

    public ckc getPresenter() {
        return this.d;
    }

    public int getSelectedItemId() {
        return this.c.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        KotlinHelpers2.bj(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof ckf)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ckf ckfVar = (ckf) parcelable;
        super.onRestoreInstanceState(ckfVar.g);
        Bundle bundle = ckfVar.a;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.b.v;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar = (ccm) weakReference.get();
            if (ccmVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = ccmVar.getId();
                if (id > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    ccmVar.ah(parcelable2);
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableAl;
        ckf ckfVar = new ckf(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        ckfVar.a = bundle;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.b.v;
        if (copyOnWriteArrayList.isEmpty()) {
            return ckfVar;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar = (ccm) weakReference.get();
            if (ccmVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = ccmVar.getId();
                if (id > 0 && (parcelableAl = ccmVar.al()) != null) {
                    sparseArray.put(id, parcelableAl);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        return ckfVar;
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.c.setActiveIndicatorLabelPadding(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        KotlinHelpers2.bh(this, f);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.c.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.c.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.c.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.c.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(dgm dgmVar) {
        this.c.setItemActiveIndicatorShapeAppearance(dgmVar);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.c.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.c.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.c.setItemBackgroundRes(i);
    }

    public void setItemIconSize(int i) {
        this.c.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.c.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.c.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.c.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.c.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.c.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.c.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.c.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.c.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i) {
        cka ckaVar = this.c;
        if (ckaVar.getLabelVisibilityMode() != i) {
            ckaVar.setLabelVisibilityMode(i);
            this.d.ac(false);
        }
    }

    public void setOnItemReselectedListener(ckd ckdVar) {
    }

    public void setOnItemSelectedListener(cke ckeVar) {
        this.f = ckeVar;
    }

    public void setSelectedItemId(int i) {
        cjz cjzVar = this.b;
        MenuItem menuItemFindItem = cjzVar.findItem(i);
        if (menuItemFindItem == null || cjzVar.ap(menuItemFindItem, this.d, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
