package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.SomeFragmentManager;
import me.hd.wauxv.obf.bdm;
import me.hd.wauxv.obf.bdz;
import me.hd.wauxv.obf.beg;
import me.hd.wauxv.obf.FragmentManager;
import me.hd.wauxv.obf.cya;
import me.hd.wauxv.obf.eqo;
import me.hd.wauxv.obf.ViewCompat;
import me.hd.wauxv.obf.evr;
import me.hd.wauxv.obf.hb;
import me.hd.wauxv.obf.mu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList a;
    public final ArrayList b;
    public View.OnApplyWindowInsetsListener c;
    public boolean d;

    public FragmentContainerView(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int i, ViewGroup.LayoutParams layoutParams) {
        throwIfVar1IsNull(child, "child");
        Object tag = child.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof SomeFragmentManager ? (SomeFragmentManager) tag : null) != null) {
            super.addView(child, i, layoutParams);
            return;
        }
        throw new IllegalStateException(
                ("Views added to a FragmentContainerView must be associated with a Fragment. View " + child
                        + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        evr evrVarD;
        throwIfVar1IsNull(insets, "insets");
        evr evrVarD2 = evr.d(null, insets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.c;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this,
                    insets);
            throwIfVar1IsNull(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            evrVarD = evr.d(null, windowInsetsOnApplyWindowInsets);
        } else {
            WeakHashMap weakHashMap = ViewCompat.a;
            WindowInsets windowInsetsI = evrVarD2.i();
            if (windowInsetsI != null) {
                WindowInsets windowInsetsB = eqo.tryGetClassByName(this, windowInsetsI);
                if (!windowInsetsB.equals(windowInsetsI)) {
                    evrVarD2 = evr.d(this, windowInsetsB);
                }
            }
            evrVarD = evrVarD2;
        }
        if (!evrVarD.b.ac()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.h(getChildAt(i), evrVarD);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        throwIfVar1IsNull(canvas, "canvas");
        if (this.d) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        throwIfVar1IsNull(canvas, "canvas");
        throwIfVar1IsNull(view, "child");
        if (this.d) {
            ArrayList arrayList = this.a;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public final void e(View view) {
        if (this.b.contains(view)) {
            this.a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        throwIfVar1IsNull(view, "view");
        this.b.remove(view);
        if (this.a.remove(view)) {
            this.d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends SomeFragmentManager> F getFragment() {
        hb hbVar;
        SomeFragmentManager someFragmentManagerVar;
        beg begVarCp;
        View view = this;
        while (true) {
            hbVar = null;
            if (view == null) {
                someFragmentManagerVar = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            someFragmentManagerVar = tag instanceof SomeFragmentManager ? (SomeFragmentManager) tag : null;
            if (someFragmentManagerVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (someFragmentManagerVar == null) {
            for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context)
                    .getBaseContext()) {
                if (context instanceof hb) {
                    hbVar = (hb) context;
                    break;
                }
            }
            if (hbVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            begVarCp = ((bdm) hbVar.c.v).g;
        } else {
            if (!someFragmentManagerVar.cv()) {
                throw new IllegalStateException("The Fragment " + someFragmentManagerVar + " that owns View " + this
                        + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            begVarCp = someFragmentManagerVar.cp();
        }
        return (F) begVarCp.ca(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        throwIfVar1IsNull(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                throwIfVar1IsNull(childAt, "view");
                e(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        throwIfVar1IsNull(view, "view");
        e(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        throwIfVar1IsNull(childAt, "view");
        e(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        throwIfVar1IsNull(view, "view");
        e(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            throwIfVar1IsNull(childAt, "view");
            e(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            throwIfVar1IsNull(childAt, "view");
            e(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException(
                "FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        throwIfVar1IsNull(view, "view");
        if (view.getParent() == this) {
            this.b.add(view);
        }
        super.startViewTransition(view);
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        throwIfVar1IsNull(context, "context");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cya.b, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use "
                    + str + "=\"" + classAttribute + '\"');
        }
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public FragmentContainerView(Context context, AttributeSet attributeSet, beg begVar) {
        View view;
        super(context, attributeSet);
        throwIfVar1IsNull(context, "context");
        throwIfVar1IsNull(attributeSet, "attrs");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cya.b, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(0) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(1);
        typedArrayObtainStyledAttributes.recycle();
        int id = getId();
        SomeFragmentManager someFragmentManagerVarCa = begVar.ca(id);
        if (classAttribute != null && someFragmentManagerVarCa == null) {
            if (id == -1) {
                throw new IllegalStateException(concat("FragmentContainerView must have an android:id to add Fragment ",
                        classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            bdz bdzVarCe = begVar.ce();
            context.getClassLoader();
            SomeFragmentManager someFragmentManagerVarE = bdzVarCe.e(classAttribute);
            throwIfVar1IsNull(someFragmentManagerVarE, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            someFragmentManagerVarE.bq = id;
            someFragmentManagerVarE.br = id;
            someFragmentManagerVarE.bs = string;
            someFragmentManagerVarE.bm = begVar;
            someFragmentManagerVarE.bn = begVar.w;
            someFragmentManagerVarE.i(context, attributeSet, null);
            mu muVar = new mu(begVar);
            muVar.p = true;
            someFragmentManagerVarE.by = this;
            someFragmentManagerVarE.bi = true;
            muVar.ac(getId(), someFragmentManagerVarE, string, 1);
            if (!muVar.g) {
                muVar.h = false;
                muVar.r.bx(muVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        for (FragmentManager fragmentManagerVar : begVar.c.ac()) {
            SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
            if (someFragmentManagerVar.br == getId() && (view = someFragmentManagerVar.bz) != null && view.getParent() == null) {
                someFragmentManagerVar.by = this;
                fragmentManagerVar.g();
                fragmentManagerVar.p();
            }
        }
    }
}
