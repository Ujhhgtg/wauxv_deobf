package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import com.google.android.material.timepicker.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.bc;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.cae;
import me.hd.wauxv.obf.caf;
import me.hd.wauxv.obf.cmz;
import me.hd.wauxv.obf.cxs;
import me.hd.wauxv.obf.dgl;
import me.hd.wauxv.obf.dgm;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.o;
import me.hd.wauxv.obf.yb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final /* synthetic */ int a = 0;
    public final ArrayList b;
    public final bmu c;
    public final LinkedHashSet d;
    public final cae e;
    public Integer[] f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final int j;
    public HashSet k;

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(cmz.aq(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.b = new ArrayList();
        this.c = new bmu(this);
        this.d = new LinkedHashSet();
        this.e = new cae(this);
        this.g = false;
        this.k = new HashSet();
        TypedArray typedArrayAn = bhu.an(getContext(), attributeSet, cxs.s, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayAn.getBoolean(3, false));
        this.j = typedArrayAn.getResourceId(1, -1);
        this.i = typedArrayAn.getBoolean(2, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayAn.getBoolean(0, true));
        typedArrayAn.recycle();
        WeakHashMap weakHashMap = eqz.a;
        setImportantForAccessibility(1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (n(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (n(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && n(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = eqz.a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        m(materialButton.getId(), materialButton.n);
        dgm shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.b.add(new caf(shapeAppearanceModel.e, shapeAppearanceModel.h, shapeAppearanceModel.f, shapeAppearanceModel.g));
        materialButton.setEnabled(isEnabled());
        eqz.s(materialButton, new yb(this, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.e);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.f = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public int getCheckedButtonId() {
        if (!this.h || this.k.isEmpty()) {
            return -1;
        }
        return ((Integer) this.k.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            if (this.k.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.f;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i2;
    }

    public final void l() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public final void m(int i, boolean z) {
        if (i == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.k);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.h && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.i || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        o(hashSet);
    }

    public final boolean n(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    public final void o(Set set) {
        HashSet hashSet = this.k;
        this.k = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.g = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.g = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).a();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.j;
        if (i != -1) {
            o(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) bc.f(1, getVisibleButtonCount(), this.h ? 1 : 2).e);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        p();
        l();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.b.remove(iIndexOfChild);
        }
        p();
        l();
    }

    public final void p() {
        caf cafVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            if (materialButton.getVisibility() != 8) {
                dgl dglVarQ = materialButton.getShapeAppearanceModel().q();
                caf cafVar2 = (caf) this.b.get(i);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    o oVar = caf.a;
                    if (i == firstVisibleChildIndex) {
                        cafVar = z ? ewz.al(this) ? new caf(oVar, oVar, cafVar2.c, cafVar2.d) : new caf(cafVar2.b, cafVar2.e, oVar, oVar) : new caf(cafVar2.b, oVar, cafVar2.c, oVar);
                    } else if (i == lastVisibleChildIndex) {
                        cafVar = z ? ewz.al(this) ? new caf(cafVar2.b, cafVar2.e, oVar, oVar) : new caf(oVar, oVar, cafVar2.c, cafVar2.d) : new caf(oVar, cafVar2.e, oVar, cafVar2.d);
                    } else {
                        cafVar2 = null;
                    }
                    cafVar2 = cafVar;
                }
                if (cafVar2 == null) {
                    dglVarQ.n(0.0f);
                } else {
                    dglVarQ.e = cafVar2.b;
                    dglVarQ.h = cafVar2.e;
                    dglVarQ.f = cafVar2.c;
                    dglVarQ.g = cafVar2.d;
                }
                materialButton.setShapeAppearanceModel(dglVarQ.m());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setEnabled(z);
        }
    }

    public void setSelectionRequired(boolean z) {
        this.i = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.h != z) {
            this.h = z;
            o(new HashSet());
        }
        for (int i = 0; i < getChildCount(); i++) {
            ((MaterialButton) getChildAt(i)).setA11yClassName((this.h ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
