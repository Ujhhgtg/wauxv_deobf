package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class bwn implements dho {
    public static final Method s;
    public static final Method t;
    public int aa;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public bwk aj;
    public View ak;
    public AdapterView.OnItemClickListener al;
    public AdapterView.OnItemSelectedListener am;
    public final Handler ar;
    public Rect at;
    public boolean au;
    public final in av;
    public final Context u;
    public ListAdapter v;
    public aqe w;
    public int z;
    public final int x = -2;
    public int y = -2;
    public final int ab = 1002;
    public int af = 0;
    public final int ah = Integer.MAX_VALUE;
    public final bwj an = new bwj(this, 1);
    public final bwm ao = new bwm(this, 0);
    public final bwl ap = new bwl(this);
    public final bwj aq = new bwj(this, 0);
    public final Rect as = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                s = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                t = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public bwn(Context context, AttributeSet attributeSet, int i, int i2) {
        int resourceId;
        this.u = context;
        this.ar = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cyf.o, i, 0);
        this.z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.aa = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.ac = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        in inVar = new in(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cyf.s, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            inVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        inVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : cmz.y(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.av = inVar;
        inVar.setInputMethodMode(1);
    }

    @Override // me.hd.wauxv.obf.dho
    public final void ag() {
        int i;
        int paddingBottom;
        aqe aqeVar;
        aqe aqeVar2 = this.w;
        Context context = this.u;
        in inVar = this.av;
        if (aqeVar2 == null) {
            aqe aqeVarAw = aw(context, !this.au);
            this.w = aqeVarAw;
            aqeVarAw.setAdapter(this.v);
            this.w.setOnItemClickListener(this.al);
            this.w.setFocusable(true);
            this.w.setFocusableInTouchMode(true);
            this.w.setOnItemSelectedListener(new bwg(this));
            this.w.setOnScrollListener(this.ap);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.am;
            if (onItemSelectedListener != null) {
                this.w.setOnItemSelectedListener(onItemSelectedListener);
            }
            inVar.setContentView(this.w);
        }
        Drawable background = inVar.getBackground();
        Rect rect = this.as;
        if (background != null) {
            background.getPadding(rect);
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.ac) {
                this.aa = -i2;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int iA = bwh.a(inVar, this.ak, this.aa, inVar.getInputMethodMode() == 2);
        int i3 = this.x;
        if (i3 == -1) {
            paddingBottom = iA + i;
        } else {
            int i4 = this.y;
            int iM = this.w.m(i4 != -2 ? i4 != -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iM + (iM > 0 ? this.w.getPaddingBottom() + this.w.getPaddingTop() + i : 0);
        }
        boolean z = inVar.getInputMethodMode() == 2;
        inVar.setWindowLayoutType(this.ab);
        if (inVar.isShowing()) {
            if (this.ak.isAttachedToWindow()) {
                int width = this.y;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.ak.getWidth();
                }
                if (i3 == -1) {
                    i3 = z ? paddingBottom : -1;
                    if (z) {
                        inVar.setWidth(this.y == -1 ? -1 : 0);
                        inVar.setHeight(0);
                    } else {
                        inVar.setWidth(this.y == -1 ? -1 : 0);
                        inVar.setHeight(-1);
                    }
                } else if (i3 == -2) {
                    i3 = paddingBottom;
                }
                inVar.setOutsideTouchable(true);
                int i5 = width;
                View view = this.ak;
                int i6 = this.z;
                int i7 = this.aa;
                int i8 = i5 < 0 ? -1 : i5;
                if (i3 < 0) {
                    i3 = -1;
                }
                inVar.update(view, i6, i7, i8, i3);
                return;
            }
            return;
        }
        int width2 = this.y;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.ak.getWidth();
        }
        if (i3 == -1) {
            i3 = -1;
        } else if (i3 == -2) {
            i3 = paddingBottom;
        }
        inVar.setWidth(width2);
        inVar.setHeight(i3);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = s;
            if (method != null) {
                try {
                    method.invoke(inVar, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            bwi.b(inVar, true);
        }
        inVar.setOutsideTouchable(true);
        inVar.setTouchInterceptor(this.ao);
        if (this.ae) {
            inVar.setOverlapAnchor(this.ad);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = t;
            if (method2 != null) {
                try {
                    method2.invoke(inVar, this.at);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            bwi.a(inVar, this.at);
        }
        inVar.showAsDropDown(this.ak, this.z, this.aa, this.af);
        this.w.setSelection(-1);
        if ((!this.au || this.w.isInTouchMode()) && (aqeVar = this.w) != null) {
            aqeVar.setListSelectionHidden(true);
            aqeVar.requestLayout();
        }
        if (this.au) {
            return;
        }
        this.ar.post(this.aq);
    }

    @Override // me.hd.wauxv.obf.dho
    public final aqe ai() {
        return this.w;
    }

    public aqe aw(Context context, boolean z) {
        return new aqe(context, z);
    }

    public final void ax(int i) {
        Drawable background = this.av.getBackground();
        if (background == null) {
            this.y = i;
            return;
        }
        Rect rect = this.as;
        background.getPadding(rect);
        this.y = rect.left + rect.right + i;
    }

    @Override // me.hd.wauxv.obf.dho
    public final void dismiss() {
        in inVar = this.av;
        inVar.dismiss();
        inVar.setContentView(null);
        this.w = null;
        this.ar.removeCallbacks(this.an);
    }

    @Override // me.hd.wauxv.obf.dho
    public final boolean e() {
        return this.av.isShowing();
    }

    public final int f() {
        return this.z;
    }

    public final void g(int i) {
        this.z = i;
    }

    public final Drawable i() {
        return this.av.getBackground();
    }

    public final void k(Drawable drawable) {
        this.av.setBackgroundDrawable(drawable);
    }

    public final void l(int i) {
        this.aa = i;
        this.ac = true;
    }

    public final int o() {
        if (this.ac) {
            return this.aa;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        bwk bwkVar = this.aj;
        if (bwkVar == null) {
            this.aj = new bwk(this);
        } else {
            ListAdapter listAdapter2 = this.v;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(bwkVar);
            }
        }
        this.v = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.aj);
        }
        aqe aqeVar = this.w;
        if (aqeVar != null) {
            aqeVar.setAdapter(this.v);
        }
    }
}
