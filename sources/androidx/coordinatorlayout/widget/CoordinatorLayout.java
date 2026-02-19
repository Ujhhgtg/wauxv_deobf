package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.agq;
import me.hd.wauxv.obf.agr;
import me.hd.wauxv.obf.ags;
import me.hd.wauxv.obf.agt;
import me.hd.wauxv.obf.agu;
import me.hd.wauxv.obf.agv;
import me.hd.wauxv.obf.agw;
import me.hd.wauxv.obf.chm;
import me.hd.wauxv.obf.cjn;
import me.hd.wauxv.obf.ckt;
import me.hd.wauxv.obf.cku;
import me.hd.wauxv.obf.cux;
import me.hd.wauxv.obf.cxy;
import me.hd.wauxv.obf.dhq;
import me.hd.wauxv.obf.eqo;
import me.hd.wauxv.obf.eqq;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.ere;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.evr;
import me.hd.wauxv.obf.ex;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements ckt, cku {
    public static final String a;
    public static final Class[] b;
    public static final ThreadLocal c;
    public static final ex d;
    public static final cux e;
    public final ArrayList f;
    public final chm g;
    public final ArrayList h;
    public final int[] i;
    public final int[] j;
    public final int[] k;
    public boolean l;
    public boolean m;
    public final int[] n;
    public View o;
    public View p;
    public agv q;
    public boolean r;
    public evr s;
    public boolean t;
    public Drawable u;
    public ViewGroup.OnHierarchyChangeListener v;
    public erp w;
    public final cjn x;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        a = r0 != null ? r0.getName() : null;
        d = new ex(1);
        b = new Class[] { Context.class, AttributeSet.class };
        c = new ThreadLocal();
        e = new cux(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f = new ArrayList();
        this.g = new chm(5);
        this.h = new ArrayList();
        this.i = new int[2];
        this.j = new int[2];
        this.k = new int[2];
        this.x = new cjn();
        int[] iArr = cxy.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr,
                R.attr.coordinatorLayoutStyle, 0);
        ViewCompat.r(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.n = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                this.n[i] = (int) (r1[i] * f);
            }
        }
        this.u = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        ax();
        super.setOnHierarchyChangeListener(new agt(this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static agu aa(View view) {
        agu aguVar = (agu) view.getLayoutParams();
        if (!aguVar.b) {
            if (view instanceof agq) {
                agr behavior = ((agq) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                agr agrVar = aguVar.a;
                if (agrVar != behavior) {
                    if (agrVar != null) {
                        agrVar.bv();
                    }
                    aguVar.a = behavior;
                    aguVar.b = true;
                    if (behavior != null) {
                        behavior.bu(aguVar);
                    }
                }
                aguVar.b = true;
                return aguVar;
            }
            ags agsVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                agsVar = (ags) superclass.getAnnotation(ags.class);
                if (agsVar != null) {
                    break;
                }
            }
            if (agsVar != null) {
                try {
                    agr agrVar2 = (agr) agsVar.value().getDeclaredConstructor(null).newInstance(null);
                    agr agrVar3 = aguVar.a;
                    if (agrVar3 != agrVar2) {
                        if (agrVar3 != null) {
                            agrVar3.bv();
                        }
                        aguVar.a = agrVar2;
                        aguVar.b = true;
                        if (agrVar2 != null) {
                            agrVar2.bu(aguVar);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("CoordinatorLayout", "Default behavior class " + agsVar.value().getName()
                            + " could not be instantiated. Did you forget a default constructor?", e2);
                }
            }
            aguVar.b = true;
        }
        return aguVar;
    }

    public static void ab(View view, int i) {
        agu aguVar = (agu) view.getLayoutParams();
        int i2 = aguVar.i;
        if (i2 != i) {
            WeakHashMap weakHashMap = ViewCompat.a;
            view.offsetLeftAndRight(i - i2);
            aguVar.i = i;
        }
    }

    public static void ac(View view, int i) {
        agu aguVar = (agu) view.getLayoutParams();
        int i2 = aguVar.j;
        if (i2 != i) {
            WeakHashMap weakHashMap = ViewCompat.a;
            view.offsetTopAndBottom(i - i2);
            aguVar.j = i;
        }
    }

    private int getFullContentHeight() {
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            agu aguVar = (agu) childAt.getLayoutParams();
            height += childAt.getHeight() + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                    + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin;
        }
        return height;
    }

    public static Rect y() {
        Rect rect = (Rect) e.acquire();
        return rect == null ? new Rect() : rect;
    }

    public static void z(int i, Rect rect, Rect rect2, agu aguVar, int i2, int i3) {
        int i4 = aguVar.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = aguVar.d;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & 112;
        int iWidth = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            iWidth -= i2 / 2;
        } else if (i6 != 5) {
            iWidth -= i2;
        }
        if (i7 == 16) {
            iHeight -= i3 / 2;
        } else if (i7 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    public final void ad(agu aguVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin, Math.min(rect.left,
                ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) aguVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) aguVar).topMargin, Math.min(rect.top,
                ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    public final void ae(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            am(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final List af(View view) {
        dhq dhqVar = (dhq) this.g.f;
        int i = dhqVar.l;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) dhqVar.s(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(dhqVar.r(i2));
            }
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    @Override // me.hd.wauxv.obf.cku
    public final void ag(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        agr agrVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                agu aguVar = (agu) childAt.getLayoutParams();
                if (aguVar.q(i5) && (agrVar = aguVar.a) != null) {
                    int[] iArr2 = this.i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    agrVar.l(this, childAt, i2, i3, i4, iArr2);
                    iMax = i3 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            aq(1);
        }
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ah(View view, int i, int i2, int i3, int i4, int i5) {
        ag(view, i, i2, i3, i4, 0, this.j);
    }

    @Override // me.hd.wauxv.obf.ckt
    public final boolean ai(View view, View view2, int i, int i2) {
        View view3;
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i3 = i;
                i4 = i2;
            } else {
                agu aguVar = (agu) childAt.getLayoutParams();
                agr agrVar = aguVar.a;
                if (agrVar != null) {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    boolean zO = agrVar.o(this, childAt, view3, i3, i4);
                    z |= zO;
                    if (i4 == 0) {
                        aguVar.m = zO;
                    } else if (i4 == 1) {
                        aguVar.n = zO;
                    }
                } else {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    if (i4 == 0) {
                        aguVar.m = false;
                    } else if (i4 == 1) {
                        aguVar.n = false;
                    }
                }
            }
            i5++;
            view = view3;
            i = i3;
            i2 = i4;
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void aj(View view, View view2, int i, int i2) {
        cjn cjnVar = this.x;
        if (i2 == 1) {
            cjnVar.b = i;
        } else {
            cjnVar.a = i;
        }
        this.p = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((agu) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void ak(View view, int i) {
        cjn cjnVar = this.x;
        if (i == 1) {
            cjnVar.b = 0;
        } else {
            cjnVar.a = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            agu aguVar = (agu) childAt.getLayoutParams();
            if (aguVar.q(i)) {
                agr agrVar = aguVar.a;
                if (agrVar != null) {
                    agrVar.p(this, childAt, view, i);
                }
                if (i == 0) {
                    aguVar.m = false;
                } else if (i == 1) {
                    aguVar.n = false;
                }
                aguVar.o = false;
            }
        }
        this.p = null;
    }

    @Override // me.hd.wauxv.obf.ckt
    public final void al(View view, int i, int i2, int[] iArr, int i3) {
        agr agrVar;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                agu aguVar = (agu) childAt.getLayoutParams();
                if (aguVar.q(i3) && (agrVar = aguVar.a) != null) {
                    int[] iArr2 = this.i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    agrVar.k(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            aq(1);
        }
    }

    public final void am(View view, Rect rect) {
        ThreadLocal threadLocal = ere.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = ere.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        ere.c(this, view, matrix);
        ThreadLocal threadLocal3 = ere.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f),
                (int) (rectF.bottom + 0.5f));
    }

    public final int an(int i) {
        int[] iArr = this.n;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean ao(View view, int i, int i2) {
        cux cuxVar = e;
        Rect rectY = y();
        am(view, rectY);
        try {
            return rectY.contains(i, i2);
        } finally {
            rectY.setEmpty();
            cuxVar.l(rectY);
        }
    }

    public final boolean ap(int i) {
        View view;
        View focusedChild = this;
        while (true) {
            if (focusedChild == null) {
                view = null;
                break;
            }
            if (focusedChild.isFocused()) {
                view = focusedChild;
                break;
            }
            focusedChild = focusedChild instanceof ViewGroup ? ((ViewGroup) focusedChild).getFocusedChild() : null;
        }
        ai(this, view, 2, 1);
        al(view, 0, i, this.k, 1);
        int[] iArr = this.k;
        int i2 = iArr[1];
        iArr[0] = 0;
        iArr[1] = 0;
        ag(view, 0, i2, 0, i, 1, iArr);
        ak(view, 1);
        return iArr[1] > 0;
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x00dc */
    public final void aq(int i) {
        int i2;
        Rect rect;
        int i3;
        ArrayList arrayList;
        boolean zC;
        boolean z;
        boolean z2;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        int i10;
        ArrayList arrayList2;
        int i11;
        Rect rect2;
        int i12;
        View view;
        agu aguVar;
        agr agrVar;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList3 = this.f;
        int size = arrayList3.size();
        Rect rectY = y();
        Rect rectY2 = y();
        Rect rectY3 = y();
        int i13 = 0;
        while (true) {
            cux cuxVar = e;
            if (i13 >= size) {
                Rect rect3 = rectY3;
                rectY.setEmpty();
                cuxVar.l(rectY);
                rectY2.setEmpty();
                cuxVar.l(rectY2);
                rect3.setEmpty();
                cuxVar.l(rect3);
                return;
            }
            View view2 = (View) arrayList3.get(i13);
            agu aguVar2 = (agu) view2.getLayoutParams();
            if (i != 0 || view2.getVisibility() != 8) {
                int i14 = 0;
                while (i14 < i13) {
                    if (aguVar2.l == ((View) arrayList3.get(i14))) {
                        agu aguVar3 = (agu) view2.getLayoutParams();
                        if (aguVar3.k != null) {
                            Rect rectY4 = y();
                            Rect rectY5 = y();
                            agu aguVar4 = aguVar2;
                            Rect rectY6 = y();
                            am(aguVar3.k, rectY4);
                            ae(view2, rectY5, false);
                            int measuredWidth = view2.getMeasuredWidth();
                            View view3 = view2;
                            int measuredHeight = view3.getMeasuredHeight();
                            i10 = i14;
                            layoutDirection = layoutDirection;
                            arrayList2 = arrayList3;
                            aguVar = aguVar4;
                            i12 = i13;
                            view = view3;
                            z(layoutDirection, rectY4, rectY6, aguVar3, measuredWidth, measuredHeight);
                            i11 = size;
                            rect2 = rectY3;
                            boolean z3 = (rectY6.left == rectY5.left && rectY6.top == rectY5.top) ? false : true;
                            ad(aguVar3, rectY6, measuredWidth, measuredHeight);
                            int i15 = rectY6.left - rectY5.left;
                            int i16 = rectY6.top - rectY5.top;
                            if (i15 != 0) {
                                WeakHashMap weakHashMap = ViewCompat.a;
                                view.offsetLeftAndRight(i15);
                            }
                            if (i16 != 0) {
                                WeakHashMap weakHashMap2 = ViewCompat.a;
                                view.offsetTopAndBottom(i16);
                            }
                            if (z3 && (agrVar = aguVar3.a) != null) {
                                agrVar.c(this, view, aguVar3.k);
                            }
                            rectY4.setEmpty();
                            cuxVar.l(rectY4);
                            rectY5.setEmpty();
                            cuxVar.l(rectY5);
                            rectY6.setEmpty();
                            cuxVar.l(rectY6);
                        } else {
                            i10 = i14;
                            arrayList2 = arrayList3;
                            i11 = size;
                            rect2 = rectY3;
                            i12 = i13;
                            view = view2;
                            aguVar = aguVar2;
                        }
                    } else {
                        i10 = i14;
                        arrayList2 = arrayList3;
                        i11 = size;
                        rect2 = rectY3;
                        i12 = i13;
                        view = view2;
                        aguVar = aguVar2;
                    }
                    i14 = i10 + 1;
                    aguVar2 = aguVar;
                    view2 = view;
                    arrayList3 = arrayList2;
                    size = i11;
                    i13 = i12;
                    rectY3 = rect2;
                }
                ArrayList arrayList4 = arrayList3;
                int i17 = size;
                Rect rect4 = rectY3;
                i2 = i13;
                View view4 = view2;
                agu aguVar5 = aguVar2;
                ae(view4, rectY2, true);
                if (aguVar5.g != 0 && !rectY2.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(aguVar5.g, layoutDirection);
                    int i18 = absoluteGravity & 112;
                    if (i18 == 48) {
                        rectY.top = Math.max(rectY.top, rectY2.bottom);
                    } else if (i18 == 80) {
                        rectY.bottom = Math.max(rectY.bottom, getHeight() - rectY2.top);
                    }
                    int i19 = absoluteGravity & 7;
                    if (i19 == 3) {
                        rectY.left = Math.max(rectY.left, rectY2.right);
                    } else if (i19 == 5) {
                        rectY.right = Math.max(rectY.right, getWidth() - rectY2.left);
                    }
                }
                if (aguVar5.h != 0 && view4.getVisibility() == 0 && view4.isLaidOut() && view4.getWidth() > 0
                        && view4.getHeight() > 0) {
                    agu aguVar6 = (agu) view4.getLayoutParams();
                    agr agrVar2 = aguVar6.a;
                    Rect rectY7 = y();
                    Rect rectY8 = y();
                    rectY8.set(view4.getLeft(), view4.getTop(), view4.getRight(), view4.getBottom());
                    if (agrVar2 == null || !agrVar2.a(view4)) {
                        rectY7.set(rectY8);
                    } else if (!rectY8.contains(rectY7)) {
                        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:"
                                + rectY7.toShortString() + " | Bounds:" + rectY8.toShortString());
                    }
                    rectY8.setEmpty();
                    cuxVar.l(rectY8);
                    if (rectY7.isEmpty()) {
                        rectY7.setEmpty();
                        cuxVar.l(rectY7);
                    } else {
                        int absoluteGravity2 = Gravity.getAbsoluteGravity(aguVar6.h, layoutDirection);
                        if ((absoluteGravity2 & 48) != 48
                                || (i8 = (rectY7.top - ((ViewGroup.MarginLayoutParams) aguVar6).topMargin)
                                        - aguVar6.j) >= (i9 = rectY.top)) {
                            z = false;
                        } else {
                            ac(view4, i9 - i8);
                            z = true;
                        }
                        if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - rectY7.bottom)
                                - ((ViewGroup.MarginLayoutParams) aguVar6).bottomMargin)
                                + aguVar6.j) < (i7 = rectY.bottom)) {
                            ac(view4, height - i7);
                            z = true;
                        }
                        if (!z) {
                            ac(view4, 0);
                        }
                        if ((absoluteGravity2 & 3) != 3
                                || (i5 = (rectY7.left - ((ViewGroup.MarginLayoutParams) aguVar6).leftMargin)
                                        - aguVar6.i) >= (i6 = rectY.left)) {
                            z2 = false;
                        } else {
                            ab(view4, i6 - i5);
                            z2 = true;
                        }
                        if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - rectY7.right)
                                - ((ViewGroup.MarginLayoutParams) aguVar6).rightMargin)
                                + aguVar6.i) < (i4 = rectY.right)) {
                            ab(view4, width - i4);
                            z2 = true;
                        }
                        if (!z2) {
                            ab(view4, 0);
                        }
                        rectY7.setEmpty();
                        cuxVar.l(rectY7);
                    }
                }
                if (i != 2) {
                    rect = rect4;
                    rect.set(((agu) view4.getLayoutParams()).p);
                    if (rect.equals(rectY2)) {
                        arrayList = arrayList4;
                        i3 = i17;
                    } else {
                        ((agu) view4.getLayoutParams()).p.set(rectY2);
                    }
                } else {
                    rect = rect4;
                }
                int i20 = i2 + 1;
                i3 = i17;
                while (true) {
                    arrayList = arrayList4;
                    if (i20 >= i3) {
                        break;
                    }
                    View view5 = (View) arrayList.get(i20);
                    agu aguVar7 = (agu) view5.getLayoutParams();
                    agr agrVar3 = aguVar7.a;
                    if (agrVar3 != null && agrVar3.tryGetClassByName(view5, view4)) {
                        if (i == 0 && aguVar7.o) {
                            aguVar7.o = false;
                        } else {
                            if (i != 2) {
                                zC = agrVar3.c(this, view5, view4);
                            } else {
                                agrVar3.d(this, view4);
                                zC = true;
                            }
                            if (i == 1) {
                                aguVar7.o = zC;
                            }
                        }
                    }
                    i20++;
                    arrayList4 = arrayList;
                }
            } else {
                arrayList = arrayList3;
                i3 = size;
                rect = rectY3;
                i2 = i13;
            }
            i13 = i2 + 1;
            rectY3 = rect;
            size = i3;
            arrayList3 = arrayList;
        }
    }

    public final void ar(View view, int i) {
        agu aguVar = (agu) view.getLayoutParams();
        View view2 = aguVar.k;
        if (view2 == null && aguVar.f != -1) {
            throw new IllegalStateException(
                    "An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        cux cuxVar = e;
        if (view2 != null) {
            Rect rectY = y();
            Rect rectY2 = y();
            try {
                am(view2, rectY);
                agu aguVar2 = (agu) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                z(i, rectY, rectY2, aguVar2, measuredWidth, measuredHeight);
                ad(aguVar2, rectY2, measuredWidth, measuredHeight);
                view.layout(rectY2.left, rectY2.top, rectY2.right, rectY2.bottom);
                return;
            } finally {
                rectY.setEmpty();
                cuxVar.l(rectY);
                rectY2.setEmpty();
                cuxVar.l(rectY2);
            }
        }
        int i2 = aguVar.e;
        if (i2 >= 0) {
            agu aguVar3 = (agu) view.getLayoutParams();
            int i3 = aguVar3.c;
            if (i3 == 0) {
                i3 = 8388661;
            }
            int absoluteGravity = Gravity.getAbsoluteGravity(i3, i);
            int i4 = absoluteGravity & 7;
            int i5 = absoluteGravity & 112;
            int width = getWidth();
            int height = getHeight();
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight2 = view.getMeasuredHeight();
            if (i == 1) {
                i2 = width - i2;
            }
            int iAn = an(i2) - measuredWidth2;
            if (i4 == 1) {
                iAn += measuredWidth2 / 2;
            } else if (i4 == 5) {
                iAn += measuredWidth2;
            }
            int i6 = i5 != 16 ? i5 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
            int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aguVar3).leftMargin,
                    Math.min(iAn, ((width - getPaddingRight()) - measuredWidth2)
                            - ((ViewGroup.MarginLayoutParams) aguVar3).rightMargin));
            int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) aguVar3).topMargin,
                    Math.min(i6, ((height - getPaddingBottom()) - measuredHeight2)
                            - ((ViewGroup.MarginLayoutParams) aguVar3).bottomMargin));
            view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
            return;
        }
        agu aguVar4 = (agu) view.getLayoutParams();
        Rect rectY3 = y();
        rectY3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) aguVar4).leftMargin,
                getPaddingTop() + ((ViewGroup.MarginLayoutParams) aguVar4).topMargin,
                (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) aguVar4).rightMargin,
                (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) aguVar4).bottomMargin);
        if (this.s != null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                rectY3.left = this.s.f() + rectY3.left;
                rectY3.top = this.s.h() + rectY3.top;
                rectY3.right -= this.s.g();
                rectY3.bottom -= this.s.e();
            }
        }
        Rect rectY4 = y();
        int i7 = aguVar4.c;
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        if ((i7 & 112) == 0) {
            i7 |= 48;
        }
        Gravity.apply(i7, view.getMeasuredWidth(), view.getMeasuredHeight(), rectY3, rectY4, i);
        view.layout(rectY4.left, rectY4.top, rectY4.right, rectY4.bottom);
        rectY3.setEmpty();
        cuxVar.l(rectY3);
        rectY4.setEmpty();
        cuxVar.l(rectY4);
    }

    public final void as(int i, int i2, int i3, View view) {
        measureChildWithMargins(view, i, i2, i3, 0);
    }

    public final boolean at(agr agrVar, View view, MotionEvent motionEvent, int i) {
        if (i == 0) {
            return agrVar.t(this, view, motionEvent);
        }
        if (i == 1) {
            return agrVar.u(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    public final boolean au(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.h;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        ex exVar = d;
        if (exVar != null) {
            Collections.sort(arrayList, exVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zAt = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            agr agrVar = ((agu) view.getLayoutParams()).a;
            if (zAt && actionMasked != 0) {
                if (agrVar != null) {
                    if (motionEventObtain == null) {
                        motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(3);
                    }
                    at(agrVar, view, motionEventObtain, i);
                }
            } else if (!zAt && agrVar != null && (zAt = at(agrVar, view, motionEvent, i))) {
                this.o = view;
                if (actionMasked != 3 && actionMasked != 1) {
                    for (int i4 = 0; i4 < i3; i4++) {
                        View view2 = (View) arrayList.get(i4);
                        agr agrVar2 = ((agu) view2.getLayoutParams()).a;
                        if (agrVar2 != null) {
                            if (motionEventObtain == null) {
                                motionEventObtain = MotionEvent.obtain(motionEvent);
                                motionEventObtain.setAction(3);
                            }
                            at(agrVar2, view2, motionEventObtain, i);
                        }
                    }
                }
            }
        }
        arrayList.clear();
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        return zAt;
    }

    /* JADX WARN: Found duplicated region for block: B:103:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:31:0x007c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:32:0x007e */
    /* JADX WARN: Found duplicated region for block: B:34:0x0084 */
    /* JADX WARN: Found duplicated region for block: B:37:0x0091 */
    /*
     * JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit
     * block: B:38:0x0095
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(
     * LoopRegionMaker.java:272)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(
     * LoopRegionMaker.java:237)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:80)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :118)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :112)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(
     * LoopRegionMaker.java:590)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:82)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :118)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java
     * :118)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 108)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.
     * java:162)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:
     * 91)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:
     * 68)
     * at
     * jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.
     * java:48)
     * at
     * jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.
     * java:25)
     */
    public final void av() {
        /*
         * Method dump skipped, instruction units count: 400
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.av():void");
    }

    public final void aw() {
        View view = this.o;
        if (view != null) {
            agr agrVar = ((agu) view.getLayoutParams()).a;
            if (agrVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                agrVar.u(this, this.o, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.o = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((agu) getChildAt(i).getLayoutParams()).getClass();
        }
        this.l = false;
    }

    public final void ax() {
        WeakHashMap weakHashMap = ViewCompat.a;
        if (!getFitsSystemWindows()) {
            eqq.l(this, null);
            return;
        }
        if (this.w == null) {
            this.w = new erp(this, 11);
        }
        eqq.l(this, this.w);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof agu) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean zDispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        if (!zDispatchKeyEvent && keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return keyEvent.isAltPressed() ? ap(-getHeight()) : ap(-((int) (getHeight() * 0.2f)));
            }
            if (keyCode == 20) {
                return keyEvent.isAltPressed() ? ap(getHeight()) : ap((int) (getHeight() * 0.2f));
            }
            if (keyCode == 62) {
                return keyEvent.isShiftPressed() ? ap(-getFullContentHeight())
                        : ap(getFullContentHeight() - getHeight());
            }
            if (keyCode == 92) {
                return ap(-getHeight());
            }
            if (keyCode == 93) {
                return ap(getHeight());
            }
            if (keyCode == 122) {
                return ap(-getFullContentHeight());
            }
            if (keyCode == 123) {
                return ap(getFullContentHeight() - getHeight());
            }
        }
        return zDispatchKeyEvent;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        agr agrVar = ((agu) view.getLayoutParams()).a;
        if (agrVar != null) {
            agrVar.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.u;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new agu();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new agu(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        av();
        return Collections.unmodifiableList(this.f);
    }

    public final evr getLastWindowInsets() {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        cjn cjnVar = this.x;
        return cjnVar.b | cjnVar.a;
    }

    public Drawable getStatusBarBackground() {
        return this.u;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        aw();
        if (this.r) {
            if (this.q == null) {
                this.q = new agv(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.q);
        }
        if (this.s == null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            if (getFitsSystemWindows()) {
                eqo.c(this);
            }
        }
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aw();
        if (this.r && this.q != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.q);
        }
        View view = this.p;
        if (view != null) {
            ak(view, 0);
        }
        this.m = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.t || this.u == null) {
            return;
        }
        evr evrVar = this.s;
        int iH = evrVar != null ? evrVar.h() : 0;
        if (iH > 0) {
            this.u.setBounds(0, 0, getWidth(), iH);
            this.u.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            aw();
        }
        boolean zAu = au(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zAu;
        }
        this.o = null;
        aw();
        return zAu;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        agr agrVar;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((agrVar = ((agu) view.getLayoutParams()).a) == null
                    || !agrVar.i(this, view, layoutDirection))) {
                ar(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:40:0x00ac */
    /* JADX WARN: Found duplicated region for block: B:70:0x012e */
    /* JADX WARN: Found duplicated region for block: B:72:0x0136 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:73:0x0161 */
    /* JADX WARN: Found duplicated region for block: B:76:0x016b A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:79:0x018a */
    /* JADX WARN: Found duplicated region for block: B:80:0x018d */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        agr agrVar;
        int i7;
        int i8;
        boolean z3;
        int i9;
        int i10;
        ArrayList arrayList;
        int i11;
        int i12;
        View view;
        int i13;
        boolean zJ;
        int iMax;
        CoordinatorLayout coordinatorLayout = this;
        coordinatorLayout.av();
        int childCount = coordinatorLayout.getChildCount();
        int i14 = 0;
        loop0: while (true) {
            if (i14 >= childCount) {
                z = false;
                break;
            }
            View childAt = coordinatorLayout.getChildAt(i14);
            dhq dhqVar = (dhq) coordinatorLayout.g.f;
            int i15 = dhqVar.l;
            for (int i16 = 0; i16 < i15; i16++) {
                ArrayList arrayList2 = (ArrayList) dhqVar.s(i16);
                if (arrayList2 != null && arrayList2.contains(childAt)) {
                    z = true;
                    break loop0;
                }
            }
            i14++;
        }
        if (z != coordinatorLayout.r) {
            if (z) {
                if (coordinatorLayout.m) {
                    if (coordinatorLayout.q == null) {
                        coordinatorLayout.q = new agv(coordinatorLayout);
                    }
                    coordinatorLayout.getViewTreeObserver().addOnPreDrawListener(coordinatorLayout.q);
                }
                coordinatorLayout.r = true;
            } else {
                if (coordinatorLayout.m && coordinatorLayout.q != null) {
                    coordinatorLayout.getViewTreeObserver().removeOnPreDrawListener(coordinatorLayout.q);
                }
                coordinatorLayout.r = false;
            }
        }
        int paddingLeft = coordinatorLayout.getPaddingLeft();
        int paddingTop = coordinatorLayout.getPaddingTop();
        int paddingRight = coordinatorLayout.getPaddingRight();
        int paddingBottom = coordinatorLayout.getPaddingBottom();
        int layoutDirection = coordinatorLayout.getLayoutDirection();
        boolean z4 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i17 = paddingLeft + paddingRight;
        int i18 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = coordinatorLayout.getSuggestedMinimumWidth();
        int suggestedMinimumHeight = coordinatorLayout.getSuggestedMinimumHeight();
        if (coordinatorLayout.s != null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            z2 = coordinatorLayout.getFitsSystemWindows();
        }
        ArrayList arrayList3 = coordinatorLayout.f;
        int size3 = arrayList3.size();
        int i19 = 0;
        int iCombineMeasuredStates = 0;
        while (i19 < size3) {
            View view2 = (View) arrayList3.get(i19);
            int i20 = suggestedMinimumWidth;
            if (view2.getVisibility() == 8) {
                arrayList = arrayList3;
                i6 = size3;
                i13 = i19;
                i7 = paddingLeft;
                suggestedMinimumWidth = i20;
                z3 = false;
                i9 = paddingRight;
            } else {
                agu aguVar = (agu) view2.getLayoutParams();
                int i21 = aguVar.e;
                if (i21 < 0 || mode == 0) {
                    i3 = suggestedMinimumHeight;
                } else {
                    int iAn = coordinatorLayout.an(i21);
                    int i22 = aguVar.c;
                    if (i22 == 0) {
                        i22 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i22, layoutDirection) & 7;
                    i3 = suggestedMinimumHeight;
                    if ((absoluteGravity != 3 || z4) && !(absoluteGravity == 5 && z4)) {
                        if ((absoluteGravity == 5 && !z4) || (absoluteGravity == 3 && z4)) {
                            iMax = Math.max(0, iAn - paddingLeft);
                        }
                        if (z2) {
                            WeakHashMap weakHashMap2 = ViewCompat.a;
                            if (view2.getFitsSystemWindows()) {
                                i6 = i4;
                                iMakeMeasureSpec = i;
                                iMakeMeasureSpec2 = i2;
                            } else {
                                i6 = i4;
                                int iG = coordinatorLayout.s.g() + coordinatorLayout.s.f();
                                int iE = coordinatorLayout.s.e() + coordinatorLayout.s.h();
                                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iG, mode);
                                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iE, mode2);
                            }
                        } else {
                            i6 = i4;
                            iMakeMeasureSpec = i;
                            iMakeMeasureSpec2 = i2;
                        }
                        agrVar = aguVar.a;
                        if (agrVar != null) {
                            z3 = false;
                            i7 = paddingLeft;
                            i8 = i20;
                            i9 = paddingRight;
                            i10 = i3;
                            arrayList = arrayList3;
                            int i23 = iMakeMeasureSpec;
                            i13 = i19;
                            int i24 = iMakeMeasureSpec2;
                            zJ = agrVar.j(this, view2, i23, i5, i24);
                            view = view2;
                            iMakeMeasureSpec = i23;
                            i11 = i5;
                            i12 = i24;
                            if (zJ) {
                                coordinatorLayout = this;
                            }
                            int iMax2 = Math.max(i8,
                                    view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                            + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                            int iMax3 = Math.max(i10,
                                    view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                            + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates,
                                    view.getMeasuredState());
                            suggestedMinimumWidth = iMax2;
                            suggestedMinimumHeight = iMax3;
                        } else {
                            i7 = paddingLeft;
                            i8 = i20;
                            z3 = false;
                            i9 = paddingRight;
                            i10 = i3;
                            arrayList = arrayList3;
                            i11 = i5;
                            i12 = iMakeMeasureSpec2;
                            view = view2;
                            i13 = i19;
                        }
                        coordinatorLayout = this;
                        coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i11, i12, 0);
                        int iMax22 = Math.max(i8,
                                view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                        + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                        int iMax32 = Math.max(i10,
                                view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                        + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates,
                                view.getMeasuredState());
                        suggestedMinimumWidth = iMax22;
                        suggestedMinimumHeight = iMax32;
                    } else {
                        iMax = Math.max(0, (size - paddingRight) - iAn);
                    }
                    int i25 = size3;
                    i5 = iMax;
                    i4 = i25;
                    if (z2) {
                        WeakHashMap weakHashMap22 = ViewCompat.a;
                        if (view2.getFitsSystemWindows()) {
                            i6 = i4;
                            int iG2 = coordinatorLayout.s.g() + coordinatorLayout.s.f();
                            int iE2 = coordinatorLayout.s.e() + coordinatorLayout.s.h();
                            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iG2, mode);
                            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iE2, mode2);
                        } else {
                            i6 = i4;
                            iMakeMeasureSpec = i;
                            iMakeMeasureSpec2 = i2;
                        }
                    } else {
                        i6 = i4;
                        iMakeMeasureSpec = i;
                        iMakeMeasureSpec2 = i2;
                    }
                    agrVar = aguVar.a;
                    if (agrVar != null) {
                        z3 = false;
                        i7 = paddingLeft;
                        i8 = i20;
                        i9 = paddingRight;
                        i10 = i3;
                        arrayList = arrayList3;
                        int i232 = iMakeMeasureSpec;
                        i13 = i19;
                        int i242 = iMakeMeasureSpec2;
                        zJ = agrVar.j(this, view2, i232, i5, i242);
                        view = view2;
                        iMakeMeasureSpec = i232;
                        i11 = i5;
                        i12 = i242;
                        if (zJ) {
                            coordinatorLayout = this;
                        }
                        int iMax222 = Math.max(i8,
                                view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                        + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                        int iMax322 = Math.max(i10,
                                view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                        + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates,
                                view.getMeasuredState());
                        suggestedMinimumWidth = iMax222;
                        suggestedMinimumHeight = iMax322;
                    } else {
                        i7 = paddingLeft;
                        i8 = i20;
                        z3 = false;
                        i9 = paddingRight;
                        i10 = i3;
                        arrayList = arrayList3;
                        i11 = i5;
                        i12 = iMakeMeasureSpec2;
                        view = view2;
                        i13 = i19;
                    }
                    coordinatorLayout = this;
                    coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i11, i12, 0);
                    int iMax2222 = Math.max(i8,
                            view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                    + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                    int iMax3222 = Math.max(i10,
                            view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                    + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates,
                            view.getMeasuredState());
                    suggestedMinimumWidth = iMax2222;
                    suggestedMinimumHeight = iMax3222;
                }
                i4 = size3;
                i5 = 0;
                if (z2) {
                    WeakHashMap weakHashMap222 = ViewCompat.a;
                    if (view2.getFitsSystemWindows()) {
                        i6 = i4;
                        int iG22 = coordinatorLayout.s.g() + coordinatorLayout.s.f();
                        int iE22 = coordinatorLayout.s.e() + coordinatorLayout.s.h();
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size - iG22, mode);
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size2 - iE22, mode2);
                    } else {
                        i6 = i4;
                        iMakeMeasureSpec = i;
                        iMakeMeasureSpec2 = i2;
                    }
                } else {
                    i6 = i4;
                    iMakeMeasureSpec = i;
                    iMakeMeasureSpec2 = i2;
                }
                agrVar = aguVar.a;
                if (agrVar != null) {
                    z3 = false;
                    i7 = paddingLeft;
                    i8 = i20;
                    i9 = paddingRight;
                    i10 = i3;
                    arrayList = arrayList3;
                    int i2322 = iMakeMeasureSpec;
                    i13 = i19;
                    int i2422 = iMakeMeasureSpec2;
                    zJ = agrVar.j(this, view2, i2322, i5, i2422);
                    view = view2;
                    iMakeMeasureSpec = i2322;
                    i11 = i5;
                    i12 = i2422;
                    if (zJ) {
                        coordinatorLayout = this;
                    }
                    int iMax22222 = Math.max(i8,
                            view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                    + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                    int iMax32222 = Math.max(i10,
                            view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                    + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates,
                            view.getMeasuredState());
                    suggestedMinimumWidth = iMax22222;
                    suggestedMinimumHeight = iMax32222;
                } else {
                    i7 = paddingLeft;
                    i8 = i20;
                    z3 = false;
                    i9 = paddingRight;
                    i10 = i3;
                    arrayList = arrayList3;
                    i11 = i5;
                    i12 = iMakeMeasureSpec2;
                    view = view2;
                    i13 = i19;
                }
                coordinatorLayout = this;
                coordinatorLayout.measureChildWithMargins(view, iMakeMeasureSpec, i11, i12, 0);
                int iMax222222 = Math.max(i8,
                        view.getMeasuredWidth() + i17 + ((ViewGroup.MarginLayoutParams) aguVar).leftMargin
                                + ((ViewGroup.MarginLayoutParams) aguVar).rightMargin);
                int iMax322222 = Math.max(i10,
                        view.getMeasuredHeight() + i18 + ((ViewGroup.MarginLayoutParams) aguVar).topMargin
                                + ((ViewGroup.MarginLayoutParams) aguVar).bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                suggestedMinimumWidth = iMax222222;
                suggestedMinimumHeight = iMax322222;
            }
            i19 = i13 + 1;
            paddingLeft = i7;
            paddingRight = i9;
            size3 = i6;
            arrayList3 = arrayList;
        }
        int i26 = iCombineMeasuredStates;
        coordinatorLayout.setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, (-16777216) & i26),
                View.resolveSizeAndState(suggestedMinimumHeight, i2, i26 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                agu aguVar = (agu) childAt.getLayoutParams();
                if (aguVar.q(0)) {
                    agr agrVar = aguVar.a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        agr agrVar;
        int childCount = getChildCount();
        boolean zBw = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                agu aguVar = (agu) childAt.getLayoutParams();
                if (aguVar.q(0) && (agrVar = aguVar.a) != null) {
                    zBw |= agrVar.bw(view);
                }
            }
        }
        return zBw;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        al(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        ah(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        aj(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof agw)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        agw agwVar = (agw) parcelable;
        super.onRestoreInstanceState(agwVar.g);
        SparseArray sparseArray = agwVar.a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            agr agrVar = aa(childAt).cachedConstructors;
            if (id != -1 && agrVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                agrVar.m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableN;
        agw agwVar = new agw(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            agr agrVar = ((agu) childAt.getLayoutParams()).a;
            if (id != -1 && agrVar != null && (parcelableN = agrVar.n(childAt)) != null) {
                sparseArray.append(id, parcelableN);
            }
        }
        agwVar.a = sparseArray;
        return agwVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return ai(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        ak(view, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zAu;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.o;
        boolean z = false;
        if (view != null) {
            agr agrVar = ((agu) view.getLayoutParams()).a;
            zAu = agrVar != null ? agrVar.u(this, this.o, motionEvent) : false;
        } else {
            zAu = au(motionEvent, 1);
            if (actionMasked != 0 && zAu) {
                z = true;
            }
        }
        if (this.o == null || actionMasked == 3) {
            zAu |= super.onTouchEvent(motionEvent);
        } else if (z) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return zAu;
        }
        this.o = null;
        aw();
        return zAu;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        agr agrVar = ((agu) view.getLayoutParams()).a;
        if (agrVar == null || !agrVar.e(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.l) {
            return;
        }
        if (this.o == null) {
            int childCount = getChildCount();
            MotionEvent motionEventObtain = null;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                agr agrVar = ((agu) childAt.getLayoutParams()).a;
                if (agrVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    agrVar.t(this, childAt, motionEventObtain);
                }
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
        }
        aw();
        this.l = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        ax();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.v = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.u = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.u.setState(getDrawableState());
                }
                this.u.setLayoutDirection(getLayoutDirection());
                this.u.setVisible(getVisibility() == 0, false);
                this.u.setCallback(this);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.u;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.u.setVisible(z, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof agu ? new agu((agu) layoutParams)
                : layoutParams instanceof ViewGroup.MarginLayoutParams
                        ? new agu((ViewGroup.MarginLayoutParams) layoutParams)
                        : new agu(layoutParams);
    }
}
