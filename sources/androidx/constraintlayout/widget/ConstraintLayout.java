package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import me.hd.wauxv.obf.add;
import me.hd.wauxv.obf.ade;
import me.hd.wauxv.obf.adf;
import me.hd.wauxv.obf.adg;
import me.hd.wauxv.obf.adh;
import me.hd.wauxv.obf.adi;
import me.hd.wauxv.obf.adp;
import me.hd.wauxv.obf.adq;
import me.hd.wauxv.obf.adr;
import me.hd.wauxv.obf.ads;
import me.hd.wauxv.obf.aly;
import me.hd.wauxv.obf.bbp;
import me.hd.wauxv.obf.bjo;
import me.hd.wauxv.obf.bjp;
import me.hd.wauxv.obf.bjq;
import me.hd.wauxv.obf.bkw;
import me.hd.wauxv.obf.bmn;
import me.hd.wauxv.obf.bvm;
import me.hd.wauxv.obf.cnf;
import me.hd.wauxv.obf.cxx;
import me.hd.wauxv.obf.dhc;
import me.hd.wauxv.obf.eps;
import me.hd.wauxv.obf.eun;
import me.hd.wauxv.obf.DefaultConfig;
import me.hd.wauxv.obf.jx;
import me.hd.wauxv.obf.nb;
import me.hd.wauxv.obf.tq;
import okhttp3.internal.http2.Http2Connection;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static dhc a;
    public final SparseArray b;
    public final ArrayList c;
    public final adr d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public adp k;
    public DefaultConfig l;
    public int m;
    public HashMap n;
    public final SparseArray o;
    public final adg p;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new adr();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 257;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = new SparseArray();
        this.p = new adg(this, this);
        s(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static dhc getSharedValues() {
        if (a == null) {
            dhc dhcVar = new dhc();
            new SparseIntArray();
            new HashMap();
            a = dhcVar;
        }
        return a;
    }

    public static adf q() {
        adf adfVar = new adf(-2, -2);
        adfVar.a = -1;
        adfVar.b = -1;
        adfVar.c = -1.0f;
        adfVar.d = true;
        adfVar.e = -1;
        adfVar.f = -1;
        adfVar.g = -1;
        adfVar.h = -1;
        adfVar.i = -1;
        adfVar.j = -1;
        adfVar.k = -1;
        adfVar.l = -1;
        adfVar.m = -1;
        adfVar.n = -1;
        adfVar.o = -1;
        adfVar.p = -1;
        adfVar.q = 0;
        adfVar.r = 0.0f;
        adfVar.s = -1;
        adfVar.t = -1;
        adfVar.u = -1;
        adfVar.v = -1;
        adfVar.w = Integer.MIN_VALUE;
        adfVar.x = Integer.MIN_VALUE;
        adfVar.y = Integer.MIN_VALUE;
        adfVar.z = Integer.MIN_VALUE;
        adfVar.aa = Integer.MIN_VALUE;
        adfVar.ab = Integer.MIN_VALUE;
        adfVar.ac = Integer.MIN_VALUE;
        adfVar.ad = 0;
        adfVar.ae = 0.5f;
        adfVar.af = 0.5f;
        adfVar.ag = null;
        adfVar.ah = -1.0f;
        adfVar.ai = -1.0f;
        adfVar.aj = 0;
        adfVar.ak = 0;
        adfVar.al = 0;
        adfVar.am = 0;
        adfVar.an = 0;
        adfVar.ao = 0;
        adfVar.ap = 0;
        adfVar.aq = 0;
        adfVar.ar = 1.0f;
        adfVar.as = 1.0f;
        adfVar.at = -1;
        adfVar.au = -1;
        adfVar.av = -1;
        adfVar.aw = false;
        adfVar.ax = false;
        adfVar.ay = null;
        adfVar.az = 0;
        adfVar.ba = true;
        adfVar.bb = true;
        adfVar.bc = false;
        adfVar.bd = false;
        adfVar.be = false;
        adfVar.bf = -1;
        adfVar.bg = -1;
        adfVar.bh = -1;
        adfVar.bi = -1;
        adfVar.bj = Integer.MIN_VALUE;
        adfVar.bk = Integer.MIN_VALUE;
        adfVar.bl = 0.5f;
        adfVar.bp = new adq();
        return adfVar;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof adf;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.c;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((add) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i3 = Integer.parseInt(strArrSplit[0]);
                        int i4 = Integer.parseInt(strArrSplit[1]);
                        int i5 = Integer.parseInt(strArrSplit[2]);
                        int i6 = (int) ((i3 / 1080.0f) * width);
                        int i7 = (int) ((i4 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i6;
                        float f2 = i7;
                        float f3 = i6 + ((int) ((i5 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float f4 = i7 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, f, f4, paint);
                        canvas.drawLine(f, f4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, f4, paint);
                        canvas.drawLine(f, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.i = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return q();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        adf adfVar = new adf(context, attributeSet);
        adfVar.a = -1;
        adfVar.b = -1;
        adfVar.c = -1.0f;
        adfVar.d = true;
        adfVar.e = -1;
        adfVar.f = -1;
        adfVar.g = -1;
        adfVar.h = -1;
        adfVar.i = -1;
        adfVar.j = -1;
        adfVar.k = -1;
        adfVar.l = -1;
        adfVar.m = -1;
        adfVar.n = -1;
        adfVar.o = -1;
        adfVar.p = -1;
        adfVar.q = 0;
        adfVar.r = 0.0f;
        adfVar.s = -1;
        adfVar.t = -1;
        adfVar.u = -1;
        adfVar.v = -1;
        adfVar.w = Integer.MIN_VALUE;
        adfVar.x = Integer.MIN_VALUE;
        adfVar.y = Integer.MIN_VALUE;
        adfVar.z = Integer.MIN_VALUE;
        adfVar.aa = Integer.MIN_VALUE;
        adfVar.ab = Integer.MIN_VALUE;
        adfVar.ac = Integer.MIN_VALUE;
        adfVar.ad = 0;
        adfVar.ae = 0.5f;
        adfVar.af = 0.5f;
        adfVar.ag = null;
        adfVar.ah = -1.0f;
        adfVar.ai = -1.0f;
        adfVar.aj = 0;
        adfVar.ak = 0;
        adfVar.al = 0;
        adfVar.am = 0;
        adfVar.an = 0;
        adfVar.ao = 0;
        adfVar.ap = 0;
        adfVar.aq = 0;
        adfVar.ar = 1.0f;
        adfVar.as = 1.0f;
        adfVar.at = -1;
        adfVar.au = -1;
        adfVar.av = -1;
        adfVar.aw = false;
        adfVar.ax = false;
        adfVar.ay = null;
        adfVar.az = 0;
        adfVar.ba = true;
        adfVar.bb = true;
        adfVar.bc = false;
        adfVar.bd = false;
        adfVar.be = false;
        adfVar.bf = -1;
        adfVar.bg = -1;
        adfVar.bh = -1;
        adfVar.bi = -1;
        adfVar.bj = Integer.MIN_VALUE;
        adfVar.bk = Integer.MIN_VALUE;
        adfVar.bl = 0.5f;
        adfVar.bp = new adq();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxx.b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i2 = ade.a.get(index);
            switch (i2) {
                case 1:
                    adfVar.av = typedArrayObtainStyledAttributes.getInt(index, adfVar.av);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.p);
                    adfVar.p = resourceId;
                    if (resourceId == -1) {
                        adfVar.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 3:
                    adfVar.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.q);
                    break;
                case 4:
                    float f = typedArrayObtainStyledAttributes.getFloat(index, adfVar.r) % 360.0f;
                    adfVar.r = f;
                    if (f < 0.0f) {
                        adfVar.r = (360.0f - f) % 360.0f;
                    }
                    break;
                case 5:
                    adfVar.a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adfVar.a);
                    break;
                case 6:
                    adfVar.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adfVar.b);
                    break;
                case 7:
                    adfVar.c = typedArrayObtainStyledAttributes.getFloat(index, adfVar.c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.e);
                    adfVar.e = resourceId2;
                    if (resourceId2 == -1) {
                        adfVar.e = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.f);
                    adfVar.f = resourceId3;
                    if (resourceId3 == -1) {
                        adfVar.f = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.g);
                    adfVar.g = resourceId4;
                    if (resourceId4 == -1) {
                        adfVar.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.h);
                    adfVar.h = resourceId5;
                    if (resourceId5 == -1) {
                        adfVar.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.i);
                    adfVar.i = resourceId6;
                    if (resourceId6 == -1) {
                        adfVar.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.j);
                    adfVar.j = resourceId7;
                    if (resourceId7 == -1) {
                        adfVar.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.k);
                    adfVar.k = resourceId8;
                    if (resourceId8 == -1) {
                        adfVar.k = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.l);
                    adfVar.l = resourceId9;
                    if (resourceId9 == -1) {
                        adfVar.l = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.m);
                    adfVar.m = resourceId10;
                    if (resourceId10 == -1) {
                        adfVar.m = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.s);
                    adfVar.s = resourceId11;
                    if (resourceId11 == -1) {
                        adfVar.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.t);
                    adfVar.t = resourceId12;
                    if (resourceId12 == -1) {
                        adfVar.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.u);
                    adfVar.u = resourceId13;
                    if (resourceId13 == -1) {
                        adfVar.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.v);
                    adfVar.v = resourceId14;
                    if (resourceId14 == -1) {
                        adfVar.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    break;
                case 21:
                    adfVar.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.w);
                    break;
                case 22:
                    adfVar.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.x);
                    break;
                case 23:
                    adfVar.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.y);
                    break;
                case 24:
                    adfVar.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.z);
                    break;
                case 25:
                    adfVar.aa = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.aa);
                    break;
                case 26:
                    adfVar.ab = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.ab);
                    break;
                case 27:
                    adfVar.aw = typedArrayObtainStyledAttributes.getBoolean(index, adfVar.aw);
                    break;
                case 28:
                    adfVar.ax = typedArrayObtainStyledAttributes.getBoolean(index, adfVar.ax);
                    break;
                case 29:
                    adfVar.ae = typedArrayObtainStyledAttributes.getFloat(index, adfVar.ae);
                    break;
                case 30:
                    adfVar.af = typedArrayObtainStyledAttributes.getFloat(index, adfVar.af);
                    break;
                case 31:
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    adfVar.al = i3;
                    if (i3 == 1) {
                        Log.e("ConstraintLayout",
                                "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                    }
                    break;
                case 32:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    adfVar.am = i4;
                    if (i4 == 1) {
                        Log.e("ConstraintLayout",
                                "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                    }
                    break;
                case 33:
                    try {
                        adfVar.an = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.an);
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, adfVar.an) == -2) {
                            adfVar.an = -2;
                        }
                    }
                    break;
                case 34:
                    try {
                        adfVar.ap = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.ap);
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, adfVar.ap) == -2) {
                            adfVar.ap = -2;
                        }
                    }
                    break;
                case 35:
                    adfVar.ar = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, adfVar.ar));
                    adfVar.al = 2;
                    break;
                case 36:
                    try {
                        adfVar.ao = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.ao);
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, adfVar.ao) == -2) {
                            adfVar.ao = -2;
                        }
                    }
                    break;
                case 37:
                    try {
                        adfVar.aq = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.aq);
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, adfVar.aq) == -2) {
                            adfVar.aq = -2;
                        }
                    }
                    break;
                case 38:
                    adfVar.as = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, adfVar.as));
                    adfVar.am = 2;
                    break;
                default:
                    switch (i2) {
                        case 44:
                            adp.k(adfVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            adfVar.ah = typedArrayObtainStyledAttributes.getFloat(index, adfVar.ah);
                            break;
                        case 46:
                            adfVar.ai = typedArrayObtainStyledAttributes.getFloat(index, adfVar.ai);
                            break;
                        case 47:
                            adfVar.aj = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            adfVar.ak = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            adfVar.at = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adfVar.at);
                            break;
                        case 50:
                            adfVar.au = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adfVar.au);
                            break;
                        case 51:
                            adfVar.ay = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.n);
                            adfVar.n = resourceId15;
                            if (resourceId15 == -1) {
                                adfVar.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, adfVar.o);
                            adfVar.o = resourceId16;
                            if (resourceId16 == -1) {
                                adfVar.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                            }
                            break;
                        case 54:
                            adfVar.ad = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.ad);
                            break;
                        case 55:
                            adfVar.ac = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adfVar.ac);
                            break;
                        default:
                            switch (i2) {
                                case 64:
                                    adp.j(adfVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    adp.j(adfVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    adfVar.az = typedArrayObtainStyledAttributes.getInt(index, adfVar.az);
                                    break;
                                case 67:
                                    adfVar.d = typedArrayObtainStyledAttributes.getBoolean(index, adfVar.d);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        adfVar.bq();
        return adfVar;
    }

    public int getMaxHeight() {
        return this.h;
    }

    public int getMaxWidth() {
        return this.g;
    }

    public int getMinHeight() {
        return this.f;
    }

    public int getMinWidth() {
        return this.e;
    }

    public int getOptimizationLevel() {
        return this.d.du;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        adr adrVar = this.d;
        if (adrVar.t == null) {
            int id2 = getId();
            if (id2 != -1) {
                adrVar.t = getContext().getResources().getResourceEntryName(id2);
            } else {
                adrVar.t = "parent";
            }
        }
        if (adrVar.br == null) {
            adrVar.br = adrVar.t;
            Log.v("ConstraintLayout", " setDebugName " + adrVar.br);
        }
        for (adq adqVar : adrVar.a) {
            View view = adqVar.bp;
            if (view != null) {
                if (adqVar.t == null && (id = view.getId()) != -1) {
                    adqVar.t = getContext().getResources().getResourceEntryName(id);
                }
                if (adqVar.br == null) {
                    adqVar.br = adqVar.t;
                    Log.v("ConstraintLayout", " setDebugName " + adqVar.br);
                }
            }
        }
        adrVar.cp(sb);
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            adf adfVar = (adf) childAt.getLayoutParams();
            adq adqVar = adfVar.bp;
            if (childAt.getVisibility() != 8 || adfVar.bd || adfVar.be || zIsInEditMode) {
                int iCr = adqVar.cr();
                int iCs = adqVar.cs();
                childAt.layout(iCr, iCs, adqVar.cq() + iCr, adqVar.cm() + iCs);
            }
        }
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((add) arrayList.get(i6)).getClass();
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:111:0x01cf */
    /* JADX WARN: Found duplicated region for block: B:125:0x0229 */
    /* JADX WARN: Found duplicated region for block: B:164:0x0334 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:166:0x033e A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:169:0x034c A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:176:0x036a A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:178:0x0374 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:179:0x0384 */
    /* JADX WARN: Found duplicated region for block: B:181:0x038c A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:186:0x03af */
    /* JADX WARN: Found duplicated region for block: B:189:0x03b7 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:191:0x03c1 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:192:0x03d1 */
    /* JADX WARN: Found duplicated region for block: B:194:0x03d4 */
    /* JADX WARN: Found duplicated region for block: B:201:0x03f6 */
    /* JADX WARN: Found duplicated region for block: B:203:0x0401 */
    /* JADX WARN: Found duplicated region for block: B:205:0x0405 */
    /* JADX WARN: Found duplicated region for block: B:206:0x040e */
    /* JADX WARN: Found duplicated region for block: B:208:0x0418 */
    /* JADX WARN: Found duplicated region for block: B:211:0x041f */
    /* JADX WARN: Found duplicated region for block: B:214:0x0427 */
    /* JADX WARN: Found duplicated region for block: B:287:0x054c */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        adq adqVar;
        int i4;
        adq adqVar2;
        int i5;
        int i6;
        int i7;
        adq adqVar3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        adq adqVar4;
        int i14;
        int i15;
        int i16;
        adq adqVar5;
        adf adfVar;
        int i17;
        int i18;
        int i19;
        adq adqVar6;
        int i20;
        float f;
        adq adqVar7;
        adq adqVar8;
        int i21;
        adq adqVar9;
        int i22;
        int i23;
        int i24;
        int i25;
        float fAbs;
        float f2;
        float f3;
        int i26;
        byte b;
        SparseArray sparseArray;
        ArrayList arrayList;
        ArrayList arrayList2;
        SparseArray sparseArray2;
        String str;
        int iQ;
        int i27;
        adq adqVar10;
        ConstraintLayout constraintLayout = this;
        boolean z3 = constraintLayout.i;
        constraintLayout.i = z3;
        int i28 = 1;
        int i29 = 0;
        if (!z3) {
            int childCount = constraintLayout.getChildCount();
            for (int i30 = 0; i30 < childCount; i30++) {
                if (constraintLayout.getChildAt(i30).isLayoutRequested()) {
                    constraintLayout.i = true;
                    break;
                }
            }
        }
        boolean z4 = (constraintLayout.getContext().getApplicationInfo().flags & 4194304) != 0
                && 1 == constraintLayout.getLayoutDirection();
        adr adrVar = constraintLayout.d;
        adrVar.j = z4;
        if (constraintLayout.i) {
            constraintLayout.i = false;
            int childCount2 = constraintLayout.getChildCount();
            int i31 = 0;
            while (true) {
                if (i31 >= childCount2) {
                    z = false;
                    break;
                } else {
                    if (constraintLayout.getChildAt(i31).isLayoutRequested()) {
                        z = true;
                        break;
                    }
                    i31++;
                }
            }
            if (z) {
                boolean zIsInEditMode = constraintLayout.isInEditMode();
                int childCount3 = constraintLayout.getChildCount();
                for (int i32 = 0; i32 < childCount3; i32++) {
                    adq adqVarR = constraintLayout.r(constraintLayout.getChildAt(i32));
                    if (adqVarR != null) {
                        adqVarR.da();
                    }
                }
                SparseArray sparseArray3 = constraintLayout.b;
                if (zIsInEditMode) {
                    int i33 = 0;
                    while (i33 < childCount3) {
                        View childAt = constraintLayout.getChildAt(i33);
                        try {
                            String resourceName = constraintLayout.getResources().getResourceName(childAt.getId());
                            Integer numValueOf = Integer.valueOf(childAt.getId());
                            if (resourceName != null) {
                                i27 = i28;
                                try {
                                    if (constraintLayout.n == null) {
                                        constraintLayout.n = new HashMap();
                                    }
                                    int iIndexOf = resourceName.indexOf("/");
                                    constraintLayout.n.put(
                                            iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName,
                                            numValueOf);
                                } catch (Resources.NotFoundException unused) {
                                }
                            } else {
                                i27 = i28;
                            }
                            int iIndexOf2 = resourceName.indexOf(47);
                            if (iIndexOf2 != -1) {
                                resourceName = resourceName.substring(iIndexOf2 + 1);
                            }
                            int id = childAt.getId();
                            if (id != 0) {
                                View viewFindViewById = (View) sparseArray3.get(id);
                                if (viewFindViewById == null
                                        && (viewFindViewById = constraintLayout.findViewById(id)) != null
                                        && viewFindViewById != constraintLayout
                                        && viewFindViewById.getParent() == constraintLayout) {
                                    constraintLayout.onViewAdded(viewFindViewById);
                                }
                                adqVar10 = viewFindViewById == constraintLayout ? adrVar
                                        : viewFindViewById == null ? null
                                                : ((adf) viewFindViewById.getLayoutParams()).bp;
                            }
                            adqVar10.br = resourceName;
                        } catch (Resources.NotFoundException unused2) {
                            i27 = i28;
                        }
                        i33++;
                        i28 = i27;
                    }
                }
                int i34 = i28;
                if (constraintLayout.m != -1) {
                    for (int i35 = 0; i35 < childCount3; i35++) {
                        constraintLayout.getChildAt(i35).getId();
                    }
                }
                adp adpVar = constraintLayout.k;
                if (adpVar != null) {
                    adpVar.l(constraintLayout);
                }
                adrVar.a.clear();
                ArrayList arrayList3 = constraintLayout.c;
                int size = arrayList3.size();
                if (size > 0) {
                    int i36 = 0;
                    while (i36 < size) {
                        add addVar = (add) arrayList3.get(i36);
                        HashMap map = addVar.k;
                        if (addVar.isInEditMode()) {
                            addVar.setIds(addVar.i);
                        }
                        bkw bkwVar = addVar.h;
                        if (bkwVar == null) {
                            sparseArray = sparseArray3;
                            arrayList = arrayList3;
                        } else {
                            bkwVar.ew = i29;
                            Arrays.fill(bkwVar.ev, (Object) null);
                            int i37 = i29;
                            while (i37 < addVar.f) {
                                int i38 = addVar.e[i37];
                                View view = (View) sparseArray3.get(i38);
                                if (view != null || (iQ = addVar.q(constraintLayout,
                                        (str = (String) map.get(Integer.valueOf(i38))))) == 0) {
                                    arrayList2 = arrayList3;
                                } else {
                                    arrayList2 = arrayList3;
                                    addVar.e[i37] = iQ;
                                    map.put(Integer.valueOf(iQ), str);
                                    view = (View) sparseArray3.get(iQ);
                                }
                                View view2 = view;
                                if (view2 != null) {
                                    bkw bkwVar2 = addVar.h;
                                    adq adqVarR2 = constraintLayout.r(view2);
                                    bkwVar2.getClass();
                                    if (adqVarR2 == bkwVar2 || adqVarR2 == null) {
                                        sparseArray2 = sparseArray3;
                                    } else {
                                        int i39 = bkwVar2.ew + 1;
                                        sparseArray2 = sparseArray3;
                                        adq[] adqVarArr = bkwVar2.ev;
                                        if (i39 > adqVarArr.length) {
                                            bkwVar2.ev = (adq[]) Arrays.copyOf(adqVarArr, adqVarArr.length * 2);
                                        }
                                        adq[] adqVarArr2 = bkwVar2.ev;
                                        int i40 = bkwVar2.ew;
                                        adqVarArr2[i40] = adqVarR2;
                                        bkwVar2.ew = i40 + 1;
                                    }
                                } else {
                                    sparseArray2 = sparseArray3;
                                }
                                i37++;
                                sparseArray3 = sparseArray2;
                                arrayList3 = arrayList2;
                            }
                            sparseArray = sparseArray3;
                            arrayList = arrayList3;
                            addVar.h.er();
                        }
                        i36++;
                        sparseArray3 = sparseArray;
                        arrayList3 = arrayList;
                        i29 = 0;
                    }
                }
                int i41 = 2;
                for (int i42 = 0; i42 < childCount3; i42++) {
                    constraintLayout.getChildAt(i42);
                }
                SparseArray sparseArray4 = constraintLayout.o;
                sparseArray4.clear();
                sparseArray4.put(0, adrVar);
                sparseArray4.put(constraintLayout.getId(), adrVar);
                for (int i43 = 0; i43 < childCount3; i43++) {
                    View childAt2 = constraintLayout.getChildAt(i43);
                    sparseArray4.put(childAt2.getId(), constraintLayout.r(childAt2));
                }
                int i44 = 0;
                while (i44 < childCount3) {
                    View childAt3 = constraintLayout.getChildAt(i44);
                    adq adqVarR3 = constraintLayout.r(childAt3);
                    if (adqVarR3 == null) {
                        i3 = i44;
                        z2 = z;
                        i23 = i41;
                    } else {
                        adf adfVar2 = (adf) childAt3.getLayoutParams();
                        adrVar.a.add(adqVarR3);
                        adq adqVar11 = adqVarR3.bd;
                        if (adqVar11 != null) {
                            ((adr) adqVar11).a.remove(adqVarR3);
                            adqVarR3.da();
                        }
                        adqVarR3.bd = adrVar;
                        adfVar2.bq();
                        adqVarR3.bq = childAt3.getVisibility();
                        adqVarR3.bp = childAt3;
                        if (childAt3 instanceof add) {
                            ((add) childAt3).b(adqVarR3, adrVar.j);
                        }
                        if (adfVar2.bd) {
                            bjp bjpVar = (bjp) adqVarR3;
                            int i45 = adfVar2.bm;
                            int i46 = adfVar2.bn;
                            float f4 = adfVar2.bo;
                            if (f4 == -1.0f) {
                                b = -1;
                                if (i45 != -1) {
                                    if (i45 > -1) {
                                        bjpVar.a = -1.0f;
                                        bjpVar.b = i45;
                                        bjpVar.c = -1;
                                    }
                                } else if (i46 != -1 && i46 > -1) {
                                    bjpVar.a = -1.0f;
                                    bjpVar.b = -1;
                                    bjpVar.c = i46;
                                    i3 = i44;
                                    z2 = z;
                                    i23 = i41;
                                }
                                i3 = i44;
                                z2 = z;
                                i23 = i41;
                            } else if (f4 > -1.0f) {
                                bjpVar.a = f4;
                                b = -1;
                                bjpVar.b = -1;
                                bjpVar.c = -1;
                                i3 = i44;
                                z2 = z;
                                i23 = i41;
                            } else {
                                i3 = i44;
                                z2 = z;
                                i23 = i41;
                            }
                        } else {
                            int i47 = adfVar2.bf;
                            int i48 = adfVar2.bg;
                            int i49 = adfVar2.bh;
                            int i50 = adfVar2.bi;
                            int i51 = adfVar2.bj;
                            int i52 = adfVar2.bk;
                            i3 = i44;
                            float f5 = adfVar2.bl;
                            int i53 = adfVar2.p;
                            z2 = z;
                            if (i53 != -1) {
                                adq adqVar12 = (adq) sparseArray4.get(i53);
                                if (adqVar12 != null) {
                                    float f6 = adfVar2.r;
                                    adqVarR3.cv(7, 7, adfVar2.q, 0, adqVar12);
                                    adqVarR3.an = f6;
                                }
                                constraintLayout = this;
                                adqVar6 = adqVarR3;
                                adfVar = adfVar2;
                                i8 = 4;
                                i7 = 2;
                            } else {
                                if (i47 != -1) {
                                    adq adqVar13 = (adq) sparseArray4.get(i47);
                                    if (adqVar13 != null) {
                                        adqVar = adqVarR3;
                                        i4 = 2;
                                        adqVar.cv(2, 2, ((ViewGroup.MarginLayoutParams) adfVar2).leftMargin, i51,
                                                adqVar13);
                                    } else {
                                        adqVar = adqVarR3;
                                        i4 = 2;
                                    }
                                } else {
                                    adqVar = adqVarR3;
                                    i4 = 2;
                                    if (i48 != -1 && (adqVar2 = (adq) sparseArray4.get(i48)) != null) {
                                        adqVar.cv(2, 4, ((ViewGroup.MarginLayoutParams) adfVar2).leftMargin, i51,
                                                adqVar2);
                                        i5 = 2;
                                        i6 = 4;
                                    }
                                    if (i49 != -1) {
                                        adqVar9 = (adq) sparseArray4.get(i49);
                                        if (adqVar9 != null) {
                                            adqVar.cv(i6, i5, ((ViewGroup.MarginLayoutParams) adfVar2).rightMargin, i52,
                                                    adqVar9);
                                        }
                                        i7 = i5;
                                    } else {
                                        i7 = i5;
                                        if (i50 != -1 && (adqVar3 = (adq) sparseArray4.get(i50)) != null) {
                                            adqVar.cv(i6, i6, ((ViewGroup.MarginLayoutParams) adfVar2).rightMargin, i52,
                                                    adqVar3);
                                        }
                                    }
                                    i8 = i6;
                                    i9 = adfVar2.i;
                                    if (i9 != -1) {
                                        adqVar8 = (adq) sparseArray4.get(i9);
                                        if (adqVar8 != null) {
                                            i21 = 3;
                                            adqVar.cv(3, 3, ((ViewGroup.MarginLayoutParams) adfVar2).topMargin,
                                                    adfVar2.x, adqVar8);
                                        } else {
                                            i21 = 3;
                                        }
                                        i12 = i21;
                                        i13 = 5;
                                        i11 = -1;
                                    } else {
                                        i10 = adfVar2.j;
                                        i11 = -1;
                                        if (i10 != -1 || (adqVar4 = (adq) sparseArray4.get(i10)) == null) {
                                            i12 = 3;
                                            i13 = 5;
                                        } else {
                                            adqVar.cv(3, 5, ((ViewGroup.MarginLayoutParams) adfVar2).topMargin,
                                                    adfVar2.x, adqVar4);
                                            i12 = 3;
                                            i13 = 5;
                                        }
                                    }
                                    i14 = adfVar2.k;
                                    if (i14 != i11) {
                                        adqVar7 = (adq) sparseArray4.get(i14);
                                        if (adqVar7 != null) {
                                            int i54 = i12;
                                            adqVar.cv(i13, i54, ((ViewGroup.MarginLayoutParams) adfVar2).bottomMargin,
                                                    adfVar2.z, adqVar7);
                                            i15 = i54;
                                        } else {
                                            i15 = i12;
                                        }
                                    } else {
                                        i15 = i12;
                                        i16 = adfVar2.l;
                                        if (i16 != i11 && (adqVar5 = (adq) sparseArray4.get(i16)) != null) {
                                            adqVar.cv(i13, i13, ((ViewGroup.MarginLayoutParams) adfVar2).bottomMargin,
                                                    adfVar2.z, adqVar5);
                                        }
                                    }
                                    adfVar = adfVar2;
                                    i17 = adfVar.m;
                                    if (i17 != -1) {
                                        constraintLayout = this;
                                        adqVar6 = adqVar;
                                        constraintLayout.v(adqVar6, adfVar, sparseArray4, i17, 6);
                                    } else {
                                        i18 = adfVar.n;
                                        if (i18 != -1) {
                                            constraintLayout = this;
                                            adqVar6 = adqVar;
                                            constraintLayout.v(adqVar6, adfVar, sparseArray4, i18, i15);
                                        } else {
                                            i19 = adfVar.o;
                                            constraintLayout = this;
                                            adqVar6 = adqVar;
                                            i20 = i13;
                                            if (i19 != -1) {
                                                constraintLayout.v(adqVar6, adfVar, sparseArray4, i19, i20);
                                            }
                                        }
                                        if (f5 >= 0.0f) {
                                            adqVar6.bn = f5;
                                        }
                                        f = adfVar.af;
                                        if (f >= 0.0f) {
                                            adqVar6.bo = f;
                                        }
                                    }
                                    if (f5 >= 0.0f) {
                                        adqVar6.bn = f5;
                                    }
                                    f = adfVar.af;
                                    if (f >= 0.0f) {
                                        adqVar6.bo = f;
                                    }
                                }
                                i5 = i4;
                                i6 = 4;
                                if (i49 != -1) {
                                    adqVar9 = (adq) sparseArray4.get(i49);
                                    if (adqVar9 != null) {
                                        adqVar.cv(i6, i5, ((ViewGroup.MarginLayoutParams) adfVar2).rightMargin, i52,
                                                adqVar9);
                                    }
                                    i7 = i5;
                                } else {
                                    i7 = i5;
                                    if (i50 != -1) {
                                        adqVar.cv(i6, i6, ((ViewGroup.MarginLayoutParams) adfVar2).rightMargin, i52,
                                                adqVar3);
                                    }
                                }
                                i8 = i6;
                                i9 = adfVar2.i;
                                if (i9 != -1) {
                                    adqVar8 = (adq) sparseArray4.get(i9);
                                    if (adqVar8 != null) {
                                        i21 = 3;
                                        adqVar.cv(3, 3, ((ViewGroup.MarginLayoutParams) adfVar2).topMargin, adfVar2.x,
                                                adqVar8);
                                    } else {
                                        i21 = 3;
                                    }
                                    i12 = i21;
                                    i13 = 5;
                                    i11 = -1;
                                } else {
                                    i10 = adfVar2.j;
                                    i11 = -1;
                                    if (i10 != -1) {
                                        i12 = 3;
                                        i13 = 5;
                                    } else {
                                        i12 = 3;
                                        i13 = 5;
                                    }
                                }
                                i14 = adfVar2.k;
                                if (i14 != i11) {
                                    adqVar7 = (adq) sparseArray4.get(i14);
                                    if (adqVar7 != null) {
                                        int i542 = i12;
                                        adqVar.cv(i13, i542, ((ViewGroup.MarginLayoutParams) adfVar2).bottomMargin,
                                                adfVar2.z, adqVar7);
                                        i15 = i542;
                                    } else {
                                        i15 = i12;
                                    }
                                } else {
                                    i15 = i12;
                                    i16 = adfVar2.l;
                                    if (i16 != i11) {
                                        adqVar.cv(i13, i13, ((ViewGroup.MarginLayoutParams) adfVar2).bottomMargin,
                                                adfVar2.z, adqVar5);
                                    }
                                }
                                adfVar = adfVar2;
                                i17 = adfVar.m;
                                if (i17 != -1) {
                                    constraintLayout = this;
                                    adqVar6 = adqVar;
                                    constraintLayout.v(adqVar6, adfVar, sparseArray4, i17, 6);
                                } else {
                                    i18 = adfVar.n;
                                    if (i18 != -1) {
                                        constraintLayout = this;
                                        adqVar6 = adqVar;
                                        constraintLayout.v(adqVar6, adfVar, sparseArray4, i18, i15);
                                    } else {
                                        i19 = adfVar.o;
                                        constraintLayout = this;
                                        adqVar6 = adqVar;
                                        i20 = i13;
                                        if (i19 != -1) {
                                            constraintLayout.v(adqVar6, adfVar, sparseArray4, i19, i20);
                                        }
                                    }
                                    if (f5 >= 0.0f) {
                                        adqVar6.bn = f5;
                                    }
                                    f = adfVar.af;
                                    if (f >= 0.0f) {
                                        adqVar6.bo = f;
                                    }
                                }
                                if (f5 >= 0.0f) {
                                    adqVar6.bn = f5;
                                }
                                f = adfVar.af;
                                if (f >= 0.0f) {
                                    adqVar6.bo = f;
                                }
                            }
                            if (zIsInEditMode && ((i26 = adfVar.at) != -1 || adfVar.au != -1)) {
                                int i55 = adfVar.au;
                                adqVar6.bi = i26;
                                adqVar6.bj = i55;
                            }
                            if (adfVar.ba) {
                                adqVar6.di(i34);
                                adqVar6.dk(((ViewGroup.MarginLayoutParams) adfVar).width);
                                if (((ViewGroup.MarginLayoutParams) adfVar).width == -2) {
                                    adqVar6.di(i41);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) adfVar).width == -1) {
                                if (adfVar.aw) {
                                    adqVar6.di(3);
                                } else {
                                    adqVar6.di(4);
                                }
                                adqVar6.ck(i7).g = ((ViewGroup.MarginLayoutParams) adfVar).leftMargin;
                                adqVar6.ck(i8).g = ((ViewGroup.MarginLayoutParams) adfVar).rightMargin;
                            } else {
                                adqVar6.di(3);
                                adqVar6.dk(0);
                            }
                            if (adfVar.bb) {
                                i22 = -1;
                                adqVar6.dj(1);
                                adqVar6.dh(((ViewGroup.MarginLayoutParams) adfVar).height);
                                if (((ViewGroup.MarginLayoutParams) adfVar).height == -2) {
                                    adqVar6.dj(2);
                                }
                            } else {
                                i22 = -1;
                                if (((ViewGroup.MarginLayoutParams) adfVar).height == -1) {
                                    if (adfVar.ax) {
                                        adqVar6.dj(3);
                                    } else {
                                        adqVar6.dj(4);
                                    }
                                    adqVar6.ck(3).g = ((ViewGroup.MarginLayoutParams) adfVar).topMargin;
                                    adqVar6.ck(5).g = ((ViewGroup.MarginLayoutParams) adfVar).bottomMargin;
                                } else {
                                    adqVar6.dj(3);
                                    adqVar6.dh(0);
                                }
                            }
                            String str2 = adfVar.ag;
                            if (str2 == null || str2.length() == 0) {
                                adqVar6.bg = 0.0f;
                            } else {
                                int length = str2.length();
                                int iIndexOf3 = str2.indexOf(44);
                                if (iIndexOf3 <= 0 || iIndexOf3 >= length - 1) {
                                    i24 = i22;
                                    i25 = 0;
                                } else {
                                    String strSubstring = str2.substring(0, iIndexOf3);
                                    i24 = strSubstring.equalsIgnoreCase("W") ? 0
                                            : strSubstring.equalsIgnoreCase("H") ? 1 : i22;
                                    i25 = iIndexOf3 + 1;
                                }
                                int iIndexOf4 = str2.indexOf(58);
                                if (iIndexOf4 < 0 || iIndexOf4 >= length - 1) {
                                    String strSubstring2 = str2.substring(i25);
                                    fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : 0.0f;
                                } else {
                                    String strSubstring3 = str2.substring(i25, iIndexOf4);
                                    String strSubstring4 = str2.substring(iIndexOf4 + 1);
                                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                        try {
                                            f2 = Float.parseFloat(strSubstring3);
                                            f3 = Float.parseFloat(strSubstring4);
                                        } catch (NumberFormatException unused3) {
                                        }
                                        if (f2 > 0.0f && f3 > 0.0f) {
                                            fAbs = i24 == 1 ? Math.abs(f3 / f2) : Math.abs(f2 / f3);
                                        }
                                    }
                                }
                                if (fAbs > 0.0f) {
                                    adqVar6.bg = fAbs;
                                    adqVar6.bh = i24;
                                }
                            }
                            float f7 = adfVar.ah;
                            float[] fArr = adqVar6.bu;
                            fArr[0] = f7;
                            i34 = 1;
                            fArr[1] = adfVar.ai;
                            adqVar6.bs = adfVar.aj;
                            adqVar6.bt = adfVar.ak;
                            int i56 = adfVar.az;
                            if (i56 >= 0 && i56 <= 3) {
                                adqVar6.aa = i56;
                            }
                            int i57 = adfVar.al;
                            int i58 = adfVar.an;
                            int i59 = adfVar.ap;
                            float f8 = adfVar.ar;
                            adqVar6.ab = i57;
                            adqVar6.ae = i58;
                            if (i59 == Integer.MAX_VALUE) {
                                i59 = 0;
                            }
                            adqVar6.af = i59;
                            adqVar6.ag = f8;
                            if (f8 > 0.0f && f8 < 1.0f && i57 == 0) {
                                adqVar6.ab = 2;
                            }
                            int i60 = adfVar.am;
                            int i61 = adfVar.ao;
                            int i62 = adfVar.aq;
                            float f9 = adfVar.as;
                            adqVar6.ac = i60;
                            adqVar6.ah = i61;
                            if (i62 == Integer.MAX_VALUE) {
                                i62 = 0;
                            }
                            adqVar6.ai = i62;
                            adqVar6.aj = f9;
                            if (f9 <= 0.0f || f9 >= 1.0f || i60 != 0) {
                                i23 = 2;
                            } else {
                                i23 = 2;
                                adqVar6.ac = 2;
                            }
                        }
                    }
                    i44 = i3 + 1;
                    i41 = i23;
                    z = z2;
                }
            }
            if (z) {
                adrVar.b.ah(adrVar);
            }
        }
        adrVar.dn.getClass();
        constraintLayout.u(adrVar, constraintLayout.j, i, i2);
        int iCq = adrVar.cq();
        int iCm = adrVar.cm();
        boolean z5 = adrVar.dv;
        boolean z6 = adrVar.dw;
        adg adgVar = constraintLayout.p;
        int i63 = adgVar.e;
        int iResolveSizeAndState = View.resolveSizeAndState(iCq + adgVar.d, i, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(iCm + i63, i2, 0) & 16777215;
        int iMin = Math.min(constraintLayout.g, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(constraintLayout.h, iResolveSizeAndState2);
        if (z5) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z6) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        constraintLayout.setMeasuredDimension(iMin, iMin2);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        adq adqVarR = r(view);
        if ((view instanceof bjo) && !(adqVarR instanceof bjp)) {
            adf adfVar = (adf) view.getLayoutParams();
            bjp bjpVar = new bjp();
            adfVar.bp = bjpVar;
            adfVar.bd = true;
            bjpVar.m11do(adfVar.av);
        }
        if (view instanceof add) {
            add addVar = (add) view;
            addVar.s();
            ((adf) view.getLayoutParams()).be = true;
            ArrayList arrayList = this.c;
            if (!arrayList.contains(addVar)) {
                arrayList.add(addVar);
            }
        }
        this.b.put(view.getId(), view);
        this.i = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.b.remove(view.getId());
        adq adqVarR = r(view);
        this.d.a.remove(adqVarR);
        adqVarR.da();
        this.c.remove(view);
        this.i = true;
    }

    public final adq r(View view) {
        if (view == this) {
            return this.d;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof adf) {
            return ((adf) view.getLayoutParams()).bp;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof adf) {
            return ((adf) view.getLayoutParams()).bp;
        }
        return null;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    public final void s(AttributeSet attributeSet, int i) {
        adr adrVar = this.d;
        adrVar.bp = this;
        adg adgVar = this.p;
        adrVar.i = adgVar;
        adrVar.c.f = adgVar;
        this.b.put(getId(), this);
        this.k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxx.b, i,
                    0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == 16) {
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                } else if (index == 17) {
                    this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == 14) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == 15) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == 113) {
                    this.j = typedArrayObtainStyledAttributes.getInt(index, this.j);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            t(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.l = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        adp adpVar = new adp();
                        this.k = adpVar;
                        adpVar.n(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.k = null;
                    }
                    this.m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        adrVar.du = this.j;
        bvm.a = adrVar.ei(512);
    }

    public void setConstraintSet(adp adpVar) {
        this.k = adpVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.b;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f) {
            return;
        }
        this.f = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.e) {
            return;
        }
        this.e = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(ads adsVar) {
        DefaultConfig ioVar = this.l;
        if (ioVar != null) {
            ioVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.j = i;
        adr adrVar = this.d;
        adrVar.du = i;
        bvm.a = adrVar.ei(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(int i) {
        String str;
        Context context = getContext();
        DefaultConfig ioVar = new DefaultConfig(12, false);
        ioVar.c = new SparseArray();
        ioVar.d = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            adh adhVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                ioVar.ar(context, xml);
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                adh adhVar2 = new adh(context, xml);
                                ((SparseArray) ioVar.c).put(adhVar2.b, adhVar2);
                                adhVar = adhVar2;
                            }
                            break;
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                adi adiVar = new adi(context, xml);
                                if (adhVar != null) {
                                    ((ArrayList) adhVar.d).add(adiVar);
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintLayoutStates", "Error parsing resource: " + i, e2);
        }
        this.l = ioVar;
    }

    /* JADX WARN: Found duplicated region for block: B:162:0x0308 */
    /* JADX WARN: Found duplicated region for block: B:164:0x0326 */
    /* JADX WARN: Found duplicated region for block: B:166:0x0329 */
    /* JADX WARN: Found duplicated region for block: B:171:0x034b */
    /* JADX WARN: Found duplicated region for block: B:180:0x0368 */
    /* JADX WARN: Found duplicated region for block: B:406:0x0397 A[SYNTHETIC] */
    public final void u(adr adrVar, int i, int i2, int i3) {
        int iMin;
        int iMax;
        int iMin2;
        int iMax2;
        int i4;
        char c;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        adg adgVar;
        int i7;
        boolean zEg;
        int i8;
        int i9;
        adg adgVar2;
        int i10;
        boolean z3;
        int i11;
        adg adgVar3;
        int i12;
        bmn bmnVar;
        eps epsVar;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z4;
        Iterator it;
        boolean z5;
        eun eunVar;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int iMax3 = Math.max(0, getPaddingTop());
        int iMax4 = Math.max(0, getPaddingBottom());
        int i20 = iMax3 + iMax4;
        int paddingWidth = getPaddingWidth();
        adg adgVar4 = this.p;
        adgVar4.b = iMax3;
        adgVar4.c = iMax4;
        adgVar4.d = paddingWidth;
        adgVar4.e = i20;
        adgVar4.f = i2;
        adgVar4.g = i3;
        int iMax5 = Math.max(0, getPaddingStart());
        int iMax6 = Math.max(0, getPaddingEnd());
        int i21 = 1;
        if (iMax5 <= 0 && iMax6 <= 0) {
            iMax5 = Math.max(0, getPaddingLeft());
        } else if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            iMax5 = iMax6;
        }
        int i22 = size - paddingWidth;
        int i23 = size2 - i20;
        int i24 = adgVar4.e;
        int i25 = adgVar4.d;
        int childCount = getChildCount();
        if (mode == Integer.MIN_VALUE) {
            if (childCount == 0) {
                iMax = Math.max(0, this.e);
                iMin = iMax;
            } else {
                iMin = i22;
            }
            i21 = 2;
        } else if (mode == 0) {
            if (childCount == 0) {
                iMax = Math.max(0, this.e);
                iMin = iMax;
            } else {
                iMin = 0;
            }
            i21 = 2;
        } else if (mode != 1073741824) {
            iMin = 0;
        } else {
            iMin = Math.min(this.g - i25, i22);
            i21 = 1;
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (childCount == 0) {
                iMax2 = Math.max(0, this.f);
                iMin2 = iMax2;
            } else {
                iMin2 = i23;
            }
            i4 = 2;
        } else if (mode2 != 0) {
            iMin2 = mode2 != 1073741824 ? 0 : Math.min(this.h - i24, i23);
            i4 = 1;
        } else {
            if (childCount == 0) {
                iMax2 = Math.max(0, this.f);
                iMin2 = iMax2;
            } else {
                iMin2 = 0;
            }
            i4 = 2;
        }
        int iCq = adrVar.cq();
        aly alyVar = adrVar.c;
        int[] iArr = adrVar.am;
        int i26 = iMin;
        if (i26 == iCq && iMin2 == adrVar.cm()) {
            c = 1;
        } else {
            alyVar.c = true;
            c = 1;
        }
        adrVar.bi = 0;
        adrVar.bj = 0;
        iArr[0] = this.g - i25;
        iArr[c] = this.h - i24;
        adrVar.bl = 0;
        adrVar.bm = 0;
        adrVar.di(i21);
        adrVar.dk(i26);
        adrVar.dj(i4);
        adrVar.dh(iMin2);
        int i27 = this.e - i25;
        if (i27 < 0) {
            adrVar.bl = 0;
        } else {
            adrVar.bl = i27;
        }
        int i28 = this.f - i24;
        if (i28 < 0) {
            adrVar.bm = 0;
        } else {
            adrVar.bm = i28;
        }
        adrVar.f0do = iMax5;
        adrVar.dp = iMax3;
        jx jxVar = adrVar.b;
        adr adrVar2 = (adr) jxVar.h;
        ArrayList arrayList = (ArrayList) jxVar.e;
        adg adgVar5 = adrVar.i;
        int size3 = adrVar.a.size();
        int iCq2 = adrVar.cq();
        int iCm = adrVar.cm();
        boolean zAz = cnf.az(i, 128);
        boolean z6 = zAz || cnf.az(i, 64);
        if (z6) {
            int i29 = 0;
            while (true) {
                if (i29 < size3) {
                    boolean z7 = z6;
                    adq adqVar = (adq) adrVar.a.get(i29);
                    int i30 = i29;
                    int[] iArr2 = adqVar.bz;
                    i5 = size3;
                    boolean z8 = (iArr2[0] == 3) && (iArr2[1] == 3) && adqVar.bg > 0.0f;
                    if ((adqVar.cx() && z8)
                            || ((adqVar.cy() && z8) || (adqVar instanceof bbp) || adqVar.cx() || adqVar.cy())) {
                        i6 = 1073741824;
                        z = false;
                    } else {
                        i29 = i30 + 1;
                        z6 = z7;
                        size3 = i5;
                    }
                } else {
                    z = z6;
                    i5 = size3;
                    i6 = 1073741824;
                }
            }
        } else {
            z = z6;
            i5 = size3;
            i6 = 1073741824;
        }
        boolean z9 = z & ((mode == i6 && mode2 == i6) || zAz);
        if (z9) {
            int iMin3 = Math.min(iArr[0], i22);
            int iMin4 = Math.min(iArr[1], i23);
            int i31 = 1073741824;
            if (mode == 1073741824) {
                if (adrVar.cq() != iMin3) {
                    adrVar.dk(iMin3);
                    alyVar.b = true;
                }
                i31 = 1073741824;
            }
            if (mode2 == i31 && adrVar.cm() != iMin4) {
                adrVar.dh(iMin4);
                alyVar.b = true;
            }
            if (mode == i31 && mode2 == i31) {
                ArrayList<eun> arrayList2 = alyVar.e;
                adr adrVar3 = alyVar.a;
                if (alyVar.b || alyVar.c) {
                    for (adq adqVar2 : adrVar3.a) {
                        adqVar2.cj();
                        adqVar2.k = false;
                        adqVar2.n.i();
                        adqVar2.o.i();
                        z9 = z9;
                    }
                    z2 = z9;
                    adrVar3.cj();
                    i15 = 0;
                    adrVar3.k = false;
                    adrVar3.n.i();
                    adrVar3.o.i();
                    alyVar.c = false;
                } else {
                    z2 = z9;
                    i15 = 0;
                }
                alyVar.j(alyVar.d);
                adrVar3.bi = i15;
                int[] iArr3 = adrVar3.bz;
                adrVar3.bj = i15;
                int iCl = adrVar3.cl(i15);
                int iCl2 = adrVar3.cl(1);
                if (alyVar.b) {
                    alyVar.k();
                }
                int iCr = adrVar3.cr();
                int iCs = adrVar3.cs();
                adgVar = adgVar5;
                adrVar3.n.r.p(iCr);
                adrVar3.o.r.p(iCs);
                alyVar.o();
                if (iCl == 2 || iCl2 == 2) {
                    if (zAz) {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (!((eun) it2.next()).h()) {
                                zAz = false;
                                break;
                            }
                        }
                    }
                    if (zAz && iCl == 2) {
                        adrVar3.di(1);
                        i16 = iCr;
                        adrVar3.dk(alyVar.l(adrVar3, 0));
                        adrVar3.n.o.p(adrVar3.cq());
                    } else {
                        i16 = iCr;
                    }
                    if (zAz && iCl2 == 2) {
                        i17 = 1;
                        adrVar3.dj(1);
                        adrVar3.dh(alyVar.l(adrVar3, 1));
                        adrVar3.o.o.p(adrVar3.cm());
                    }
                    i18 = iArr3[0];
                    if (i18 != i17 || i18 == 4) {
                        int iCq3 = adrVar3.cq() + i16;
                        adrVar3.n.s.p(iCq3);
                        adrVar3.n.o.p(iCq3 - i16);
                        alyVar.o();
                        i19 = iArr3[1];
                        if (i19 != 1 || i19 == 4) {
                            int iCm2 = adrVar3.cm() + iCs;
                            adrVar3.o.s.p(iCm2);
                            adrVar3.o.o.p(iCm2 - iCs);
                        }
                        alyVar.o();
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    for (eun eunVar2 : arrayList2) {
                        if (eunVar2.l == adrVar3 || eunVar2.q) {
                            eunVar2.e();
                        }
                    }
                    it = arrayList2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            z5 = true;
                            break;
                        }
                        eunVar = (eun) it.next();
                        if (!z4 || eunVar.l != adrVar3) {
                            if (eunVar.r.k || ((!eunVar.s.k && !(eunVar instanceof bjq))
                                    || (!eunVar.o.k && !(eunVar instanceof tq) && !(eunVar instanceof bjq)))) {
                                z5 = false;
                                break;
                            }
                        }
                    }
                    adrVar3.di(iCl);
                    adrVar3.dj(iCl2);
                    zEg = z5;
                    i7 = 2;
                    i14 = 1073741824;
                } else {
                    i16 = iCr;
                }
                i17 = 1;
                i18 = iArr3[0];
                if (i18 != i17) {
                    int iCq32 = adrVar3.cq() + i16;
                    adrVar3.n.s.p(iCq32);
                    adrVar3.n.o.p(iCq32 - i16);
                    alyVar.o();
                    i19 = iArr3[1];
                    if (i19 != 1) {
                        int iCm22 = adrVar3.cm() + iCs;
                        adrVar3.o.s.p(iCm22);
                        adrVar3.o.o.p(iCm22 - iCs);
                    } else {
                        int iCm222 = adrVar3.cm() + iCs;
                        adrVar3.o.s.p(iCm222);
                        adrVar3.o.o.p(iCm222 - iCs);
                    }
                    alyVar.o();
                    z4 = true;
                } else {
                    int iCq322 = adrVar3.cq() + i16;
                    adrVar3.n.s.p(iCq322);
                    adrVar3.n.o.p(iCq322 - i16);
                    alyVar.o();
                    i19 = iArr3[1];
                    if (i19 != 1) {
                        int iCm2222 = adrVar3.cm() + iCs;
                        adrVar3.o.s.p(iCm2222);
                        adrVar3.o.o.p(iCm2222 - iCs);
                    } else {
                        int iCm22222 = adrVar3.cm() + iCs;
                        adrVar3.o.s.p(iCm22222);
                        adrVar3.o.o.p(iCm22222 - iCs);
                    }
                    alyVar.o();
                    z4 = true;
                }
                while (r6.hasNext()) {
                    if (eunVar2.l == adrVar3) {
                    }
                    eunVar2.getThisObject();
                }
                it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        z5 = true;
                        break;
                    }
                    eunVar = (eun) it.next();
                    if (!z4) {
                    }
                    if (eunVar.r.k) {
                    }
                    z5 = false;
                    break;
                }
                adrVar3.di(iCl);
                adrVar3.dj(iCl2);
                zEg = z5;
                i7 = 2;
                i14 = 1073741824;
            } else {
                z2 = z9;
                adgVar = adgVar5;
                adr adrVar4 = alyVar.a;
                if (alyVar.b) {
                    for (adq adqVar3 : adrVar4.a) {
                        adqVar3.cj();
                        adqVar3.k = false;
                        bmn bmnVar2 = adqVar3.n;
                        bmnVar2.o.k = false;
                        bmnVar2.q = false;
                        bmnVar2.i();
                        eps epsVar2 = adqVar3.o;
                        epsVar2.o.k = false;
                        epsVar2.q = false;
                        epsVar2.i();
                    }
                    i13 = 0;
                    adrVar4.cj();
                    adrVar4.k = false;
                    bmn bmnVar3 = adrVar4.n;
                    bmnVar3.o.k = false;
                    bmnVar3.q = false;
                    bmnVar3.i();
                    eps epsVar3 = adrVar4.o;
                    epsVar3.o.k = false;
                    epsVar3.q = false;
                    epsVar3.i();
                    alyVar.k();
                } else {
                    i13 = 0;
                }
                alyVar.j(alyVar.d);
                adrVar4.bi = i13;
                adrVar4.bj = i13;
                adrVar4.n.r.p(i13);
                adrVar4.o.r.p(i13);
                i14 = 1073741824;
                if (mode == 1073741824) {
                    zEg = adrVar.eg(i13, zAz);
                    i7 = 1;
                } else {
                    i7 = 0;
                    zEg = true;
                }
                if (mode2 == 1073741824) {
                    zEg &= adrVar.eg(1, zAz);
                    i7++;
                }
            }
            if (zEg) {
                adrVar.dl(mode == i14, mode2 == i14);
            }
        } else {
            z2 = z9;
            adgVar = adgVar5;
            i7 = 0;
            zEg = false;
        }
        if (zEg && i7 == 2) {
            return;
        }
        int i32 = adrVar.du;
        if (i5 > 0) {
            int size4 = adrVar.a.size();
            boolean zEi = adrVar.ei(64);
            adg adgVar6 = adrVar.i;
            int i33 = 0;
            while (i33 < size4) {
                adq adqVar4 = (adq) adrVar.a.get(i33);
                if ((adqVar4 instanceof bjp) || (adqVar4 instanceof nb) || adqVar4.ap || (zEi
                        && (bmnVar = adqVar4.n) != null && (epsVar = adqVar4.o) != null && bmnVar.o.k && epsVar.o.k)) {
                    i12 = size4;
                } else {
                    int iCl3 = adqVar4.cl(0);
                    int iCl4 = adqVar4.cl(1);
                    i12 = size4;
                    boolean z10 = iCl3 == 3 && adqVar4.ab != 1 && iCl4 == 3 && adqVar4.ac != 1;
                    if (!z10 && adrVar.ei(1) && !(adqVar4 instanceof bbp)) {
                        if (iCl3 == 3 && adqVar4.ab == 0 && iCl4 != 3 && !adqVar4.cx()) {
                            z10 = true;
                        }
                        if (iCl4 == 3 && adqVar4.ac == 0 && iCl3 != 3 && !adqVar4.cx()) {
                            z10 = true;
                        }
                        if ((iCl3 == 3 || iCl4 == 3) && adqVar4.bg > 0.0f) {
                            z10 = true;
                        }
                    }
                    if (!z10) {
                        jxVar.ab(0, adgVar6, adqVar4);
                    }
                }
                i33++;
                size4 = i12;
            }
            ConstraintLayout constraintLayout = adgVar6.a;
            int childCount2 = constraintLayout.getChildCount();
            ArrayList arrayList3 = constraintLayout.c;
            for (int i34 = 0; i34 < childCount2; i34++) {
                constraintLayout.getChildAt(i34);
            }
            int size5 = arrayList3.size();
            if (size5 > 0) {
                for (int i35 = 0; i35 < size5; i35++) {
                    ((add) arrayList3.get(i35)).getClass();
                }
            }
        }
        jxVar.ah(adrVar);
        int size6 = arrayList.size();
        if (i5 > 0) {
            jxVar.ag(adrVar, 0, iCq2, iCm);
        }
        if (size6 > 0) {
            int[] iArr4 = adrVar.bz;
            boolean z11 = iArr4[0] == 2;
            boolean z12 = iArr4[1] == 2;
            int iMax7 = Math.max(adrVar.cq(), adrVar2.bl);
            int iMax8 = Math.max(adrVar.cm(), adrVar2.bm);
            int i36 = 0;
            boolean z13 = false;
            while (i36 < size6) {
                adq adqVar5 = (adq) arrayList.get(i36);
                if (adqVar5 instanceof bbp) {
                    int iCq4 = adqVar5.cq();
                    int iCm3 = adqVar5.cm();
                    z3 = z12;
                    i11 = i36;
                    adgVar3 = adgVar;
                    boolean zAb = z13 | jxVar.ab(1, adgVar3, adqVar5);
                    int iCq5 = adqVar5.cq();
                    boolean z14 = zAb;
                    int iCm4 = adqVar5.cm();
                    if (iCq5 != iCq4) {
                        adqVar5.dk(iCq5);
                        if (z11 && adqVar5.cr() + adqVar5.be > iMax7) {
                            iMax7 = Math.max(iMax7, adqVar5.ck(4).n() + adqVar5.cr() + adqVar5.be);
                        }
                        z14 = true;
                    }
                    if (iCm4 != iCm3) {
                        adqVar5.dh(iCm4);
                        if (z3 && adqVar5.cs() + adqVar5.bf > iMax8) {
                            iMax8 = Math.max(iMax8, adqVar5.ck(5).n() + adqVar5.cs() + adqVar5.bf);
                        }
                        z14 = true;
                    }
                    z13 = z14 | ((bbp) adqVar5).dn;
                } else {
                    z3 = z12;
                    i11 = i36;
                    adgVar3 = adgVar;
                }
                i36 = i11 + 1;
                adgVar = adgVar3;
                z12 = z3;
            }
            boolean z15 = z12;
            int i37 = 0;
            while (true) {
                adg adgVar7 = adgVar;
                if (i37 >= 2) {
                    break;
                }
                boolean zAb2 = z13;
                int i38 = 0;
                while (i38 < size6) {
                    adq adqVar6 = (adq) arrayList.get(i38);
                    if ((!(adqVar6 instanceof bkw) || (adqVar6 instanceof bbp)) && !(adqVar6 instanceof bjp)) {
                        i8 = size6;
                        if (adqVar6.bq != 8
                                && ((!z2 || !adqVar6.n.o.k || !adqVar6.o.o.k) && !(adqVar6 instanceof bbp))) {
                            int iCq6 = adqVar6.cq();
                            int iCm5 = adqVar6.cm();
                            i9 = i38;
                            int i39 = adqVar6.bk;
                            zAb2 |= jxVar.ab(i37 == 1 ? 2 : 1, adgVar7, adqVar6);
                            adgVar2 = adgVar7;
                            int iCq7 = adqVar6.cq();
                            i10 = i37;
                            int iCm6 = adqVar6.cm();
                            if (iCq7 != iCq6) {
                                adqVar6.dk(iCq7);
                                if (z11 && adqVar6.cr() + adqVar6.be > iMax7) {
                                    iMax7 = Math.max(iMax7, adqVar6.ck(4).n() + adqVar6.cr() + adqVar6.be);
                                }
                                zAb2 = true;
                            }
                            if (iCm6 != iCm5) {
                                adqVar6.dh(iCm6);
                                if (z15 && adqVar6.cs() + adqVar6.bf > iMax8) {
                                    iMax8 = Math.max(iMax8, adqVar6.ck(5).n() + adqVar6.cs() + adqVar6.bf);
                                }
                                zAb2 = true;
                            }
                            if (adqVar6.ao && i39 != adqVar6.bk) {
                                zAb2 = true;
                            }
                        }
                        i38 = i9 + 1;
                        size6 = i8;
                        i37 = i10;
                        adgVar7 = adgVar2;
                    } else {
                        i8 = size6;
                    }
                    adgVar2 = adgVar7;
                    i10 = i37;
                    i9 = i38;
                    i38 = i9 + 1;
                    size6 = i8;
                    i37 = i10;
                    adgVar7 = adgVar2;
                }
                int i40 = size6;
                adgVar = adgVar7;
                int i41 = i37;
                if (!zAb2) {
                    break;
                }
                int i42 = i41 + 1;
                jxVar.ag(adrVar, i42, iCq2, iCm);
                i37 = i42;
                size6 = i40;
                z13 = false;
            }
        }
        adrVar.du = i32;
        bvm.a = adrVar.ei(512);
    }

    public final void v(adq adqVar, adf adfVar, SparseArray sparseArray, int i, int i2) {
        View view = (View) this.b.get(i);
        adq adqVar2 = (adq) sparseArray.get(i);
        if (adqVar2 == null || view == null || !(view.getLayoutParams() instanceof adf)) {
            return;
        }
        adfVar.bc = true;
        if (i2 == 6) {
            adf adfVar2 = (adf) view.getLayoutParams();
            adfVar2.bc = true;
            adfVar2.bp.ao = true;
        }
        adqVar.ck(6).k(adqVar2.ck(i2), adfVar.ad, adfVar.ac, true);
        adqVar.ao = true;
        adqVar.ck(3).s();
        adqVar.ck(5).s();
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new SparseArray();
        this.c = new ArrayList(4);
        this.d = new adr();
        this.e = 0;
        this.f = 0;
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
        this.i = true;
        this.j = 257;
        this.k = null;
        this.l = null;
        this.m = -1;
        this.n = new HashMap();
        this.o = new SparseArray();
        this.p = new adg(this, this);
        s(attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        adf adfVar = new adf(layoutParams);
        adfVar.a = -1;
        adfVar.b = -1;
        adfVar.c = -1.0f;
        adfVar.d = true;
        adfVar.e = -1;
        adfVar.f = -1;
        adfVar.g = -1;
        adfVar.h = -1;
        adfVar.i = -1;
        adfVar.j = -1;
        adfVar.k = -1;
        adfVar.l = -1;
        adfVar.m = -1;
        adfVar.n = -1;
        adfVar.o = -1;
        adfVar.p = -1;
        adfVar.q = 0;
        adfVar.r = 0.0f;
        adfVar.s = -1;
        adfVar.t = -1;
        adfVar.u = -1;
        adfVar.v = -1;
        adfVar.w = Integer.MIN_VALUE;
        adfVar.x = Integer.MIN_VALUE;
        adfVar.y = Integer.MIN_VALUE;
        adfVar.z = Integer.MIN_VALUE;
        adfVar.aa = Integer.MIN_VALUE;
        adfVar.ab = Integer.MIN_VALUE;
        adfVar.ac = Integer.MIN_VALUE;
        adfVar.ad = 0;
        adfVar.ae = 0.5f;
        adfVar.af = 0.5f;
        adfVar.ag = null;
        adfVar.ah = -1.0f;
        adfVar.ai = -1.0f;
        adfVar.aj = 0;
        adfVar.ak = 0;
        adfVar.al = 0;
        adfVar.am = 0;
        adfVar.an = 0;
        adfVar.ao = 0;
        adfVar.ap = 0;
        adfVar.aq = 0;
        adfVar.ar = 1.0f;
        adfVar.as = 1.0f;
        adfVar.at = -1;
        adfVar.au = -1;
        adfVar.av = -1;
        adfVar.aw = false;
        adfVar.ax = false;
        adfVar.ay = null;
        adfVar.az = 0;
        adfVar.ba = true;
        adfVar.bb = true;
        adfVar.bc = false;
        adfVar.bd = false;
        adfVar.be = false;
        adfVar.bf = -1;
        adfVar.bg = -1;
        adfVar.bh = -1;
        adfVar.bi = -1;
        adfVar.bj = Integer.MIN_VALUE;
        adfVar.bk = Integer.MIN_VALUE;
        adfVar.bl = 0.5f;
        adfVar.bp = new adq();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) adfVar).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) adfVar).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) adfVar).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) adfVar).bottomMargin = marginLayoutParams.bottomMargin;
            adfVar.setMarginStart(marginLayoutParams.getMarginStart());
            adfVar.setMarginEnd(marginLayoutParams.getMarginEnd());
        }
        if (!(layoutParams instanceof adf)) {
            return adfVar;
        }
        adf adfVar2 = (adf) layoutParams;
        adfVar.a = adfVar2.a;
        adfVar.b = adfVar2.b;
        adfVar.c = adfVar2.c;
        adfVar.d = adfVar2.d;
        adfVar.e = adfVar2.e;
        adfVar.f = adfVar2.f;
        adfVar.g = adfVar2.g;
        adfVar.h = adfVar2.h;
        adfVar.i = adfVar2.i;
        adfVar.j = adfVar2.j;
        adfVar.k = adfVar2.k;
        adfVar.l = adfVar2.l;
        adfVar.m = adfVar2.m;
        adfVar.n = adfVar2.n;
        adfVar.o = adfVar2.o;
        adfVar.p = adfVar2.p;
        adfVar.q = adfVar2.q;
        adfVar.r = adfVar2.r;
        adfVar.s = adfVar2.s;
        adfVar.t = adfVar2.t;
        adfVar.u = adfVar2.u;
        adfVar.v = adfVar2.v;
        adfVar.w = adfVar2.w;
        adfVar.x = adfVar2.x;
        adfVar.y = adfVar2.y;
        adfVar.z = adfVar2.z;
        adfVar.aa = adfVar2.aa;
        adfVar.ab = adfVar2.ab;
        adfVar.ac = adfVar2.ac;
        adfVar.ad = adfVar2.ad;
        adfVar.ae = adfVar2.ae;
        adfVar.af = adfVar2.af;
        adfVar.ag = adfVar2.ag;
        adfVar.ah = adfVar2.ah;
        adfVar.ai = adfVar2.ai;
        adfVar.aj = adfVar2.aj;
        adfVar.ak = adfVar2.ak;
        adfVar.aw = adfVar2.aw;
        adfVar.ax = adfVar2.ax;
        adfVar.al = adfVar2.al;
        adfVar.am = adfVar2.am;
        adfVar.an = adfVar2.an;
        adfVar.ap = adfVar2.ap;
        adfVar.ao = adfVar2.ao;
        adfVar.aq = adfVar2.aq;
        adfVar.ar = adfVar2.ar;
        adfVar.as = adfVar2.as;
        adfVar.at = adfVar2.at;
        adfVar.au = adfVar2.au;
        adfVar.av = adfVar2.av;
        adfVar.ba = adfVar2.ba;
        adfVar.bb = adfVar2.bb;
        adfVar.bc = adfVar2.bc;
        adfVar.bd = adfVar2.bd;
        adfVar.bf = adfVar2.bf;
        adfVar.bg = adfVar2.bg;
        adfVar.bh = adfVar2.bh;
        adfVar.bi = adfVar2.bi;
        adfVar.bj = adfVar2.bj;
        adfVar.bk = adfVar2.bk;
        adfVar.bl = adfVar2.bl;
        adfVar.ay = adfVar2.ay;
        adfVar.az = adfVar2.az;
        adfVar.bp = adfVar2.bp;
        return adfVar;
    }
}
