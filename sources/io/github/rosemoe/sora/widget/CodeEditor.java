package io.github.rosemoe.sora.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.icu.lang.UCharacter;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.TransactionTooLargeException;
import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextThemeWrapper;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aah;
import me.hd.wauxv.obf.aaj;
import me.hd.wauxv.obf.aak;
import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.StaticHelpers2;
import me.hd.wauxv.obf.afe;
import me.hd.wauxv.obf.aff;
import me.hd.wauxv.obf.afh;
import me.hd.wauxv.obf.afo;
import me.hd.wauxv.obf.afp;
import me.hd.wauxv.obf.afq;
import me.hd.wauxv.obf.ahu;
import me.hd.wauxv.obf.ahy;
import me.hd.wauxv.obf.ahz;
import me.hd.wauxv.obf.aia;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.amu;
import me.hd.wauxv.obf.amv;
import me.hd.wauxv.obf.anq;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.aro;
import me.hd.wauxv.obf.arq;
import me.hd.wauxv.obf.arw;
import me.hd.wauxv.obf.arx;
import me.hd.wauxv.obf.arz;
import me.hd.wauxv.obf.asa;
import me.hd.wauxv.obf.asb;
import me.hd.wauxv.obf.asn;
import me.hd.wauxv.obf.aso;
import me.hd.wauxv.obf.asp;
import me.hd.wauxv.obf.ass;
import me.hd.wauxv.obf.asv;
import me.hd.wauxv.obf.avc;
import me.hd.wauxv.obf.GifEncoder;
import me.hd.wauxv.obf.awy;
import me.hd.wauxv.obf.bhs;
import me.hd.wauxv.obf.bjz;
import me.hd.wauxv.obf.blp;
import me.hd.wauxv.obf.SyntheticPileOfMess;
import me.hd.wauxv.obf.bmx;
import me.hd.wauxv.obf.bph;
import me.hd.wauxv.obf.bpi;
import me.hd.wauxv.obf.bqe;
import me.hd.wauxv.obf.bqg;
import me.hd.wauxv.obf.btk;
import me.hd.wauxv.obf.btm;
import me.hd.wauxv.obf.btq;
import me.hd.wauxv.obf.btr;
import me.hd.wauxv.obf.bvb;
import me.hd.wauxv.obf.bvc;
import me.hd.wauxv.obf.bvd;
import me.hd.wauxv.obf.bxt;
import me.hd.wauxv.obf.byw;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cba;
import me.hd.wauxv.obf.cbl;
import me.hd.wauxv.obf.cbr;
import me.hd.wauxv.obf.cfg;
import me.hd.wauxv.obf.chr;
import me.hd.wauxv.obf.chs;
import me.hd.wauxv.obf.chu;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.HugeSyntheticPileOfHelpers;
import me.hd.wauxv.obf.csk;
import me.hd.wauxv.obf.cxc;
import me.hd.wauxv.obf.cxu;
import me.hd.wauxv.obf.dbg;
import me.hd.wauxv.obf.dbh;
import me.hd.wauxv.obf.df;
import me.hd.wauxv.obf.dfb;
import me.hd.wauxv.obf.dfn;
import me.hd.wauxv.obf.dfo;
import me.hd.wauxv.obf.dfp;
import me.hd.wauxv.obf.dfs;
import me.hd.wauxv.obf.dh;
import me.hd.wauxv.obf.dhs;
import me.hd.wauxv.obf.dik;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.dnv;
import me.hd.wauxv.obf.dop;
import me.hd.wauxv.obf.dor;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.dqd;
import me.hd.wauxv.obf.dqq;
import me.hd.wauxv.obf.dqs;
import me.hd.wauxv.obf.dqz;
import me.hd.wauxv.obf.drd;
import me.hd.wauxv.obf.drg;
import me.hd.wauxv.obf.enm;
import me.hd.wauxv.obf.enr;
import me.hd.wauxv.obf.erp;
import me.hd.wauxv.obf.ewa;
import me.hd.wauxv.obf.ewz;
import me.hd.wauxv.obf.hz;
import me.hd.wauxv.obf.ik;
import me.hd.wauxv.obf.io;
import me.hd.wauxv.obf.FactoryPools;
import me.hd.wauxv.obf.SomeStaticHelpers;
import me.hd.wauxv.obf.pe;
import me.hd.wauxv.obf.pf;
import me.hd.wauxv.obf.pg;
import me.hd.wauxv.obf.pi;
import me.hd.wauxv.obf.rp;
import me.hd.wauxv.obf.ud;
import me.hd.wauxv.obf.y;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CodeEditor extends View implements afp, bph {
    public final io a;
    public float aa;
    public float ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;
    public boolean ag;
    public boolean ah;
    public boolean ai;
    public boolean aj;
    public volatile boolean ak;
    public boolean al;
    public int am;
    public int an;
    public int ao;
    public boolean ap;
    public boolean aq;
    public boolean ar;
    public boolean as;
    public boolean at;
    public boolean au;
    public boolean av;
    public boolean aw;
    public boolean ax;
    public boolean ay;
    public boolean az;
    public FactoryPools b;
    public boolean ba;
    public boolean bb;
    public boolean bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    public boolean bg;
    public boolean bh;
    public boolean bi;
    public final dfo bj;
    public final dfo bk;
    public final dfo bl;
    public final ClipboardManager bm;
    public final InputMethodManager bn;
    public ahy bo;
    public aff bp;
    public final Matrix bq;
    public arq br;
    public bvc bs;
    public String bt;
    public btq bu;
    public amu bv;
    public long bw;
    public final aro bx;
    public final asv by;
    public Paint.Align bz;
    public final ass c;
    public final GestureDetector ca;
    public final ScaleGestureDetector cb;
    public final CursorAnchorInfo.Builder cc;
    public final EdgeEffect cd;
    public final EdgeEffect ce;
    public ExtractedTextRequest cf;
    public final asp cg;
    public ahz ch;
    public dfp ci;
    public aia cj;
    public final anq ck;
    public Bundle cl;
    public dnv cm;
    public final dbg cn;
    public final asn co;
    public boolean cp;
    public float cq;
    public float cr;
    public boolean cs;
    public boolean ct;
    public bvd cu;
    public final dik cv;
    public final HashMap cw;
    public final arw d;
    public final ArrayList e;
    public final FactoryPools f;
    public ud g;
    public final asa h;
    public final awy i;
    public y j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public final float w;
    public float x;
    public float y;
    public float z;

    static {
        bxt.c("CodeEditor");
    }

    public CodeEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.codeEditorStyle, 0);
        this.a = new io(this);
        this.e = new ArrayList(2);
        this.m = 0;
        this.y = 1.0f;
        this.z = 0.0f;
        this.ab = 0.5f;
        this.bv = amu.a;
        this.bw = 0L;
        this.cw = new HashMap();
        Log.v("CodeEditor",
                "sora-editor\nCopyright (C) Rosemoe roses2020@qq.com\nThis project is distributed under the LGPL v2.1 license");
        this.i = new awy(null);
        this.bg = true;
        this.cn = new dbg(this);
        this.co = new asn(this);
        this.f = new FactoryPools(this, 7);
        this.w = ViewConfiguration.get(getContext()).getScaledVerticalScrollFactor();
        this.cu = bvd.LF;
        this.bs = arj.e;
        Context context2 = getContext();
        SparseIntArray sparseIntArray = bmx.a;
        int i = R.string.sora_editor_editor_formatting;
        int i2 = sparseIntArray.get(R.string.sora_editor_editor_formatting);
        this.bt = context2.getString(i2 != 0 ? i2 : i);
        this.ck = new anq();
        float fApplyDimension = TypedValue.applyDimension(1, 10.0f, Resources.getSystem().getDisplayMetrics()) / 10.0f;
        this.p = fApplyDimension;
        this.q = fApplyDimension;
        this.t = 1.5f * fApplyDimension;
        this.v = fApplyDimension;
        float f = fApplyDimension * 2.0f;
        this.s = f;
        this.r = f;
        this.bq = new Matrix();
        this.ci = new bjz(getContext());
        asp aspVar = new asp();
        this.i.l(afh.class, new df(aspVar));
        this.cg = aspVar;
        this.ch = new cfg(this);
        setCursorBlinkPeriod(500);
        this.cc = new CursorAnchorInfo.Builder();
        setTextSize(18.0f);
        setLineInfoTextSize(TypedValue.applyDimension(2, 21.0f, Resources.getSystem().getDisplayMetrics()));
        arq arqVar = arq.a;
        this.br = arqVar;
        arqVar.d(this);
        this.by = new asv(this);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this.by);
        this.ca = gestureDetector;
        gestureDetector.setOnDoubleTapListener(this.by);
        this.cb = new ScaleGestureDetector(getContext(), this.by);
        this.bl = new dfo();
        this.bj = new dfo();
        this.bk = new dfo();
        this.bz = Paint.Align.RIGHT;
        this.ac = false;
        this.ar = true;
        this.u = 1.0f;
        this.bn = (InputMethodManager) getContext().getSystemService("input_method");
        this.bm = (ClipboardManager) getContext().getSystemService("clipboard");
        setUndoEnabled(true);
        this.l = -1;
        setScalable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.bd = true;
        this.h = new asa(this);
        this.bx = new aro(this);
        this.cd = new EdgeEffect(getContext());
        this.ce = new EdgeEffect(getContext());
        this.c = new ass(this);
        this.d = new arw(this);
        new erp(this);
        setEditorLanguage(null);
        setText(null);
        setTabWidth(4);
        setHighlightCurrentLine(true);
        setVerticalScrollBarEnabled(true);
        setHighlightCurrentBlock(true);
        setDisplayLnPanel(true);
        setHorizontalScrollBarEnabled(true);
        setFirstLineNumberAlwaysVisible(true);
        setCursorAnimationEnabled(true);
        setEditable(true);
        setLineNumberEnabled(true);
        setHardwareAcceleratedDrawAllowed(true);
        setInterceptParentHorizontalScrollIfNeeded(false);
        setTypefaceText(Typeface.DEFAULT);
        setSoftKeyboardEnabled(true);
        setDisableSoftKbdIfHardKbdAvailable(true);
        setDefaultFocusHighlightEnabled(false);
        if (getContext() instanceof ContextThemeWrapper) {
            ContextThemeWrapper contextThemeWrapper = (ContextThemeWrapper) getContext();
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);
            setEdgeEffectColor(typedValue.data);
        }
        this.cb.setQuickScaleEnabled(false);
        this.cv = new dik(this);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxu.a,
                R.attr.codeEditorStyle, 0);
        setHorizontalScrollbarThumbDrawable(typedArrayObtainStyledAttributes.getDrawable(15));
        setHorizontalScrollbarTrackDrawable(typedArrayObtainStyledAttributes.getDrawable(17));
        setVerticalScrollbarThumbDrawable(typedArrayObtainStyledAttributes.getDrawable(16));
        setVerticalScrollbarTrackDrawable(typedArrayObtainStyledAttributes.getDrawable(18));
        setLnPanelPositionMode(typedArrayObtainStyledAttributes.getInt(11, 1));
        setLnPanelPosition(typedArrayObtainStyledAttributes.getInt(10, 15));
        setDividerWidth(typedArrayObtainStyledAttributes.getDimension(3, getDividerWidth()));
        eo(typedArrayObtainStyledAttributes.getDimension(2, this.r),
                typedArrayObtainStyledAttributes.getDimension(2, this.s));
        setPinLineNumber(typedArrayObtainStyledAttributes.getBoolean(12, false));
        setHighlightCurrentBlock(typedArrayObtainStyledAttributes.getBoolean(5, true));
        setHighlightCurrentLine(typedArrayObtainStyledAttributes.getBoolean(6, true));
        setHighlightBracketPair(typedArrayObtainStyledAttributes.getBoolean(4, true));
        setLigatureEnabled(typedArrayObtainStyledAttributes.getBoolean(8, true));
        setLineNumberEnabled(typedArrayObtainStyledAttributes.getBoolean(9, this.aq));
        aro aroVar = this.bx;
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, true);
        aroVar.o = z;
        aroVar.k.j(z);
        if (!z) {
            aroVar.s();
            aroVar.t();
        }
        this.ck.d = typedArrayObtainStyledAttributes.getBoolean(19, true);
        setRenderFunctionCharacters(typedArrayObtainStyledAttributes.getBoolean(13, this.bg));
        setScalable(typedArrayObtainStyledAttributes.getBoolean(14, this.ad));
        setTextSizePx(typedArrayObtainStyledAttributes.getDimension(22, getTextSizePx()));
        setCursorBlinkPeriod(typedArrayObtainStyledAttributes.getInt(1, getCursorBlink().e));
        setTabWidth(typedArrayObtainStyledAttributes.getInt(20, getTabWidth()));
        int i3 = typedArrayObtainStyledAttributes.getInt(24, 0);
        if (i3 != 0) {
            et(true, i3 > 1);
        }
        setText(typedArrayObtainStyledAttributes.getString(21));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int cx(int i, List list) {
        if (list.isEmpty()) {
            return -1;
        }
        int size = list.size() - 1;
        int i2 = 0;
        int i3 = size;
        while (i2 <= i3) {
            int i4 = ((i3 - i2) / 2) + i2;
            if (i4 >= 0 && i4 <= size) {
                aah aahVar = (aah) list.get(i4);
                if (aahVar == null) {
                    int i5 = i4 - 1;
                    while (true) {
                        i4++;
                        if (i5 < i2 && i4 > i3) {
                            return -1;
                        }
                        if (i5 >= i2 && list.get(i5) != null) {
                            i4 = i5;
                            break;
                        }
                        if (i4 <= i3 && list.get(i4) != null) {
                            break;
                        }
                        i5--;
                    }
                    aahVar = (aah) list.get(i4);
                }
                int i6 = aahVar.e;
                if (i6 <= i) {
                    if (i6 >= i) {
                        i2 = i4;
                        break;
                    }
                    i2 = i4 + 1;
                } else {
                    i3 = i4 - 1;
                }
            } else {
                return -1;
            }
        }
        if (i2 < 0 || i2 > size) {
            return -1;
        }
        return i2;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return Math.max(0, Math.min(getScrollMaxX(), getOffsetX()));
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return getScrollMaxX();
    }

    @Override // android.view.View
    public final void computeScroll() {
        aso asoVar = this.by.b;
        OverScroller overScroller = asoVar.b;
        OverScroller overScroller2 = asoVar.b;
        boolean zComputeScrollOffset = overScroller.computeScrollOffset();
        if (zComputeScrollOffset) {
            asoVar.c();
        }
        if (zComputeScrollOffset) {
            if (!overScroller2.isFinished() && (overScroller2.getStartX() != overScroller2.getFinalX()
                    || overScroller2.getStartY() != overScroller2.getFinalY())) {
                this.cq = overScroller2.getFinalX();
                this.cr = overScroller2.getFinalY();
                this.ct = ((float) Math.abs(overScroller2.getStartX() - overScroller2.getFinalX())) > getDpUnit()
                        * 5.0f;
                this.cs = ((float) Math.abs(overScroller2.getStartY() - overScroller2.getFinalY())) > getDpUnit()
                        * 5.0f;
            }
            if (overScroller2.getCurrX() > 0 || this.cq > 0.0f || !this.ce.isFinished() || !this.ct) {
                int scrollMaxX = getScrollMaxX();
                if (overScroller2.getCurrX() >= scrollMaxX && this.cq >= scrollMaxX && this.ce.isFinished()
                        && this.ct) {
                    this.ce.onAbsorb((int) overScroller2.getCurrVelocity());
                    this.by.j = true;
                }
            } else {
                this.ce.onAbsorb((int) overScroller2.getCurrVelocity());
                this.by.j = false;
            }
            if (overScroller2.getCurrY() > 0 || this.cr > 0.0f || !this.cd.isFinished() || !this.cs) {
                int scrollMaxY = getScrollMaxY();
                if (overScroller2.getCurrY() >= scrollMaxY && this.cr >= scrollMaxY && this.cd.isFinished()
                        && this.cs) {
                    this.cd.onAbsorb((int) overScroller2.getCurrVelocity());
                    this.by.i = true;
                }
            } else {
                this.cd.onAbsorb((int) overScroller2.getCurrVelocity());
                this.by.i = false;
            }
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, Math.min(getScrollMaxY(), getOffsetY()));
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        return getScrollMaxY();
    }

    @Override // android.view.View
    public final AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = super.createAccessibilityNodeInfo();
        if (isEnabled()) {
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setEditable(dw());
            ahy ahyVar = this.bo;
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setTextSelection(ahyVar.c.a, ahyVar.d.a);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setInputType(1);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setMultiLine(true);
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setText(getText().ao());
            accessibilityNodeInfoCreateAccessibilityNodeInfo.setLongClickable(true);
            accessibilityNodeInfoCreateAccessibilityNodeInfo
                    .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_COPY);
            accessibilityNodeInfoCreateAccessibilityNodeInfo
                    .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CUT);
            accessibilityNodeInfoCreateAccessibilityNodeInfo
                    .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_PASTE);
            accessibilityNodeInfoCreateAccessibilityNodeInfo
                    .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_TEXT);
            int scrollMaxY = getScrollMaxY();
            if (scrollMaxY > 0) {
                accessibilityNodeInfoCreateAccessibilityNodeInfo.setScrollable(true);
                int offsetY = getOffsetY();
                if (offsetY > 0) {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo
                            .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCreateAccessibilityNodeInfo
                            .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP);
                }
                if (offsetY < scrollMaxY) {
                    accessibilityNodeInfoCreateAccessibilityNodeInfo
                            .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCreateAccessibilityNodeInfo
                            .addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN);
                }
            }
        }
        return accessibilityNodeInfoCreateAccessibilityNodeInfo;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
        this.ac = true;
        this.j.cy(affVar);
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        ArrayList arrayList;
        FactoryPools factoryPoolsVar;
        int i5;
        dbg dbgVar = this.cn;
        ik ikVar = dbgVar.a;
        chs chsVar = (chs) ikVar.c;
        if (i != i3) {
            int i6 = i3 - i;
            if (i6 == 1) {
                if (i >= 0) {
                    int i7 = chsVar.b;
                    if (i <= i7) {
                        chsVar.c(i7 + 1);
                        int[] iArr = chsVar.a;
                        int i8 = chsVar.b;
                        if (i != i8) {
                            SomeStaticHelpers._al(iArr, i + 1, i, i8, iArr);
                        }
                        iArr[i] = 0;
                        chsVar.b++;
                    }
                } else {
                    chsVar.getClass();
                }
                throw new IndexOutOfBoundsException("Index must be between 0 and size");
            }
            int[] iArr2 = new int[i6];
            chsVar.getClass();
            if (i < 0 || i > (i5 = chsVar.b)) {
                throw new IndexOutOfBoundsException("");
            }
            if (i6 != 0) {
                chsVar.c(i5 + i6);
                int[] iArr3 = chsVar.a;
                int i9 = chsVar.b;
                if (i != i9) {
                    SomeStaticHelpers._al(iArr3, i + i6, i, i9, iArr3);
                }
                SomeStaticHelpers._ao(iArr2, i, 0, 12, iArr3);
                chsVar.b += i6;
            }
            for (cba cbaVar : (ArrayList) ikVar.d) {
                int i10 = cbaVar.a;
                if (i10 > i) {
                    cbaVar.a = i10 + i6;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (factoryPoolsVar = dbgVar.b) != null) {
            for (dbh dbhVar : (ArrayList) factoryPoolsVar.f) {
                int i11 = dbhVar.a;
                if (i11 == i) {
                    dbhVar.c = true;
                } else if (i11 > i) {
                    dbhVar.a = (i3 - i) + i11;
                }
            }
        }
        this.co.bn();
        this.f.getClass();
        ud udVarO = this.bp.x().o(i, i2);
        ud udVarO2 = this.bp.x().o(i3, i4);
        try {
            dnv dnvVar = this.cm;
            if (dnvVar != null) {
                int i12 = udVarO2.b;
                int i13 = udVarO.b;
                int i14 = i12 - i13;
                if (i14 != 0 && (arrayList = dnvVar.b) != null) {
                    ewz.ax(arrayList, i13, i14);
                }
            }
        } catch (Exception e) {
            Log.w("CodeEditor", "Update failure", e);
        }
        this.j.cz(affVar, i, i2, i3, i4, charSequence);
        asn asnVar = this.co;
        asnVar.an(i, i3, asnVar.ab, false);
        dc();
        ev();
        this.ac = false;
        ew();
        dn();
        this.bu.e().p(udVarO, udVarO2, charSequence);
        asv asvVar = this.by;
        if (asvVar.be()) {
            asvVar.p = 0L;
            asvVar.a.invalidate();
        }
        if (this.ae && !this.bo.h() && !this.h.c.e() && this.ao == 0) {
            ((cfg) this.ch).n();
            ((cfg) this.ch).p();
        }
        this.g = this.aj ? this.bo.c.d() : this.bo.d.d();
        this.i.g(new afh(this, 2, udVarO, udVarO2, charSequence, this.bp.i.h));
        ef(1);
        udVarO.d();
        udVarO2.d();
    }

    @Override // me.hd.wauxv.obf.afp
    public final void da(aff affVar) {
        this.ck.getClass();
        ((cfg) this.ch).o();
        this.aj = this.bo.c.d().equals(this.g);
    }

    @Override // me.hd.wauxv.obf.afp
    public final void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        int i6;
        ArrayList arrayList;
        FactoryPools factoryPoolsVar;
        dbg dbgVar = this.cn;
        ik ikVar = dbgVar.a;
        ArrayList<cba> arrayList2 = (ArrayList) ikVar.d;
        if (i != i3) {
            ((chs) ikVar.c).e(i, i3);
            StaticHelpers2.ap(arrayList2, new cbl(i, i3, 1));
            for (cba cbaVar : arrayList2) {
                int i7 = cbaVar.a;
                if (i7 > i3) {
                    cbaVar.a = i7 - (i3 - i);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (factoryPoolsVar = dbgVar.b) != null) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList<dbh> arrayList4 = (ArrayList) factoryPoolsVar.f;
            for (dbh dbhVar : arrayList4) {
                int i8 = dbhVar.a;
                if (i8 == i) {
                    dbhVar.c = true;
                } else if (i + 1 <= i8 && i8 <= i3) {
                    arrayList3.add(dbhVar);
                    dbhVar.b.discardDisplayList();
                } else if (i8 > i3) {
                    dbhVar.a = i8 - (i3 - i);
                }
            }
            arrayList4.removeAll(StaticHelpers5.ad(arrayList3));
            ((Stack) factoryPoolsVar.h).addAll(arrayList3);
        }
        this.co.bn();
        this.f.getClass();
        ud udVarO = this.bp.x().o(i, i2);
        ud udVarD = udVarO.d();
        udVarD.c = i4;
        udVarD.b = i3;
        udVarD.a = sb.length() + udVarO.a;
        try {
            dnv dnvVar = this.cm;
            if (dnvVar != null && (i6 = (i5 = udVarO.b) - udVarD.b) != 0 && (arrayList = dnvVar.b) != null) {
                ewz.ax(arrayList, i5, i6);
            }
        } catch (Exception e) {
            Log.w("CodeEditor", "Update failure", e);
        }
        this.j.db(affVar, i, i2, i3, i4, sb);
        asn asnVar = this.co;
        asnVar.an(i, i + 1, asnVar.ab, false);
        dc();
        ev();
        if (!this.ac) {
            ew();
            dn();
            asv asvVar = this.by;
            if (asvVar.be()) {
                asvVar.p = 0L;
                asvVar.a.invalidate();
            }
        }
        if (this.ae && !this.bo.h() && !this.ac && !this.h.c.e() && this.ao == 0) {
            ((cfg) this.ch).n();
            ((cfg) this.ch).p();
        }
        this.bu.e().j(udVarO, udVarD);
        this.g = this.aj ? this.bo.c.d() : this.bo.d.d();
        this.i.g(new afh(this, 3, udVarO, udVarD, sb, this.bp.i.h));
        ef(1);
    }

    public final void dc() {
        ViewGroup.LayoutParams layoutParams;
        if (!this.bf || (layoutParams = getLayoutParams()) == null) {
            return;
        }
        if (layoutParams.width == -2) {
            requestLayout();
        } else {
            if (layoutParams.height != -2 || getHeight() == this.j.g()) {
                return;
            }
            requestLayout();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:6:0x000b */
    public final boolean dd() {
        boolean z;
        if (this.bi) {
            Context context = getContext();
            if (context == null) {
                z = false;
            } else {
                Configuration configuration = context.getResources().getConfiguration();
                z = true;
                if (configuration.keyboard == 1 && configuration.hardKeyboardHidden != 1) {
                    z = false;
                }
            }
            if (z) {
                return false;
            }
        }
        return this.bh;
    }

    public final void de(CharSequence charSequence, boolean z) {
        dor dorVarZ;
        GifEncoder gifEncoderVarD;
        CharSequence charSequence2;
        char cCharAt;
        btq btqVar;
        afq afqVar;
        int i;
        int i2;
        int iC;
        boolean zH;
        cxc cxcVar;
        int i3;
        boolean z2;
        int i4 = 2;
        int i5 = 1;
        if (!getProps().d || charSequence.length() <= 0) {
            dorVarZ = null;
            break;
        }
        char cCharAt2 = charSequence.charAt(charSequence.length() - 1);
        char[] charArray = charSequence.length() > 1 ? charSequence.toString().toCharArray() : null;
        FactoryPools factoryPoolsVar = this.b;
        ud udVarD = this.bo.c.d();
        factoryPoolsVar.getClass();
        aff text = getText();
        dorVarZ = charArray == null ? factoryPoolsVar.z(cCharAt2) : null;
        if (dorVarZ == null) {
            Iterator it = factoryPoolsVar.aa(cCharAt2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    dorVarZ = null;
                    break;
                }
                dorVarZ = (dor) it.next();
                dop dopVar = dorVarZ.d;
                String str = dorVarZ.b;
                if (dopVar != null) {
                    aff text2 = getText();
                    text2.y(text2.w().c.b);
                    int i6 = text2.w().c.c;
                    char[] charArray2 = str.toCharArray();
                    int i7 = udVarD.a;
                    if (charArray == null) {
                        z2 = true;
                        for (int length = charArray2.length - i4; length >= 0; length--) {
                            if (i7 > 0) {
                                i7--;
                            }
                            z2 &= text.charAt(i7) == charArray2[length];
                        }
                    } else {
                        if (charArray.length <= charArray2.length) {
                            int length2 = charArray2.length - 1;
                            int length3 = charArray.length - 1;
                            z2 = true;
                            while (length3 > 0) {
                                z2 &= charArray[length3] == charArray2[length2];
                                length3--;
                                length2--;
                            }
                            if (z2 && length2 > 0) {
                                i7--;
                                while (length2 >= 0) {
                                    z2 &= text.charAt(i7) == charArray2[length2];
                                    i7--;
                                    length2--;
                                }
                            }
                        }
                        i4 = 2;
                    }
                    if (z2) {
                        dorVarZ.e = str.length() + i7;
                        dorVarZ.f = i7;
                        break;
                    }
                    i4 = 2;
                }
            }
        } else {
            int i8 = udVarD.a;
            dorVarZ.e = dorVarZ.b.length() + i8;
            dorVarZ.f = i8;
        }
        ahy ahyVar = this.bo;
        aff affVar = this.bp;
        try {
            gifEncoderVarD = this.bu.d();
        } catch (AbstractMethodError unused) {
            gifEncoderVarD = null;
        }
        if (dorVarZ != null) {
            String str2 = dorVarZ.b;
            String str3 = dorVarZ.c;
            if (dorVarZ != dor.a) {
                dop dopVar2 = dorVarZ.d;
                if (dopVar2 != null) {
                    switch (dopVar2.g) {
                        case 0:
                            zH = affVar.w().h();
                            break;
                        default:
                            zH = affVar.w().h();
                            break;
                    }
                } else {
                    zH = false;
                }
                if (zH && gifEncoderVarD == null) {
                    affVar.l();
                    ud udVar = ahyVar.c;
                    affVar.ab(udVar.b, udVar.c, str2);
                    ud udVar2 = ahyVar.d;
                    affVar.ab(udVar2.b, udVar2.c, str3);
                    affVar.u();
                    ud udVar3 = ahyVar.c;
                    int i9 = udVar3.b;
                    int i10 = udVar3.c;
                    ud udVar4 = ahyVar.d;
                    er(i9, i10, udVar4.b, udVar4.c - str3.length());
                    return;
                }
                if (!ahyVar.h() || gifEncoderVarD == null) {
                    affVar.l();
                    ud udVarN = affVar.x().n(dorVarZ.f);
                    int i11 = udVarN.b;
                    int i12 = udVarN.c;
                    ud udVar5 = ahyVar.d;
                    affVar.ah(i11, i12, dorVarZ.b, udVar5.b, udVar5.c);
                    affVar.ab(udVarN.b, str2.length() + udVarN.c, str3);
                    affVar.u();
                    ud udVarN2 = affVar.x().n(dorVarZ.e);
                    ep(udVarN2.b, udVarN2.c);
                    return;
                }
                if (charSequence.length() > 0 && charSequence.length() == 1) {
                    String string = charSequence.toString();
                    aff affVar2 = this.bp;
                    dqs cursorRange = getCursorRange();
                    dnv styles = getStyles();
                    ud udVar6 = cursorRange.a;
                    ud udVar7 = cursorRange.b;
                    if (bhs.m(styles, udVar6) || bhs.m(styles, udVar7) || !"\"".equals(string)
                            || (i3 = udVar6.b) != udVar7.b) {
                        cxcVar = cxc.g;
                    } else {
                        affVar2.ab(i3, udVar6.c, "\"");
                        affVar2.ab(udVar7.b, udVar7.c + 1, "\"");
                        cxcVar = new cxc(true, new dqs(affVar2.x().n(udVar6.a + 1), affVar2.x().n(udVar7.a + 1)));
                    }
                    if (cxcVar.h) {
                        dqs dqsVar = (dqs) cxcVar.i;
                        if (dqsVar != null) {
                            ud udVar8 = dqsVar.a;
                            int i13 = udVar8.b;
                            int i14 = udVar8.c;
                            ud udVar9 = dqsVar.b;
                            er(i13, i14, udVar9.b, udVar9.c);
                            return;
                        }
                        return;
                    }
                }
            }
        }
        if (ahyVar.h()) {
            ud udVar10 = ahyVar.c;
            int i15 = udVar10.b;
            int i16 = udVar10.c;
            ud udVar11 = ahyVar.d;
            affVar.ah(i15, i16, charSequence, udVar11.b, udVar11.c);
            return;
        }
        if (this.ck.f && charSequence.length() != 0 && z
                && ((cCharAt = charSequence.charAt(0)) == '\n' || cCharAt == '\r')) {
            String strAa = this.bp.aa(ahyVar.c.b);
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < ahyVar.c.c; i19++) {
                char cCharAt3 = strAa.charAt(i19);
                if (cCharAt3 == '\t' || cCharAt3 == ' ') {
                    if (strAa.charAt(i19) == '\t') {
                        i18++;
                    } else {
                        i17++;
                    }
                } else {
                    int i20 = (i18 * this.k) + i17;
                    btqVar = this.bu;
                    afqVar = new afq(this.bp);
                    ud udVar12 = ahyVar.c;
                    i = udVar12.b;
                    i2 = udVar12.c;
                    try {
                        iC = btqVar.c(afqVar, i, i2);
                    } catch (AbstractMethodError unused2) {
                        iC = btqVar.c(afqVar, i, i2);
                    }
                    i20 += iC;
                    if (cCharAt == '\r' && charSequence.length() >= 2 && charSequence.charAt(1) == '\n') {
                        i5 = 2;
                    }
                    StringBuilder sb = new StringBuilder(charSequence);
                    int i21 = this.k;
                    this.bu.getClass();
                    sb.insert(i5, cna.n(i20, i21, false));
                    charSequence2 = sb;
                }
            }
            int i202 = (i18 * this.k) + i17;
            try {
                btqVar = this.bu;
                afqVar = new afq(this.bp);
                ud udVar122 = ahyVar.c;
                i = udVar122.b;
                i2 = udVar122.c;
                iC = btqVar.c(afqVar, i, i2);
                i202 += iC;
            } catch (Exception e) {
                Log.w("CodeEditor", "Language object error", e);
            }
            if (cCharAt == '\r') {
                i5 = 2;
            }
            StringBuilder sb2 = new StringBuilder(charSequence);
            int i212 = this.k;
            this.bu.getClass();
            sb2.insert(i5, cna.n(i202, i212, false));
            charSequence2 = sb2;
        } else {
            charSequence2 = charSequence;
        }
        ud udVar13 = ahyVar.c;
        affVar.ab(udVar13.b, udVar13.c, charSequence2);
    }

    public final void df(boolean z) {
        if (this.bo.h()) {
            aff text = getText();
            ahy ahyVar = this.bo;
            dg(ahyVar.c.a, ahyVar.d.a, text);
        } else {
            if (!z) {
                String str = getLineSeparator().f;
                dg(0, str.length(), str);
                return;
            }
            ahy cursor = getCursor();
            if (cursor.h()) {
                df(true);
                return;
            }
            int i = cursor.c.d().b;
            er(i, 0, i, getText().y(i).b);
            df(false);
        }
    }

    public final void dg(int i, int i2, CharSequence charSequence) {
        if (i2 < i) {
            return;
        }
        int i3 = i2 - i;
        int i4 = this.ck.y;
        int i5 = R.string.sora_editor_clip_text_length_too_large;
        if (i3 > i4) {
            Context context = getContext();
            int i6 = bmx.a.get(R.string.sora_editor_clip_text_length_too_large);
            if (i6 != 0) {
                i5 = i6;
            }
            Toast.makeText(context, i5, 0).show();
            return;
        }
        try {
            String strAn = charSequence instanceof aff ? ((aff) charSequence).an(i, i2)
                    : charSequence.subSequence(i, i2).toString();
            this.bm.setPrimaryClip(ClipData.newPlainText(strAn, strAn));
        } catch (RuntimeException e) {
            if (!(e.getCause() instanceof TransactionTooLargeException)) {
                Log.w("CodeEditor", e);
                Toast.makeText(getContext(), e.getClass().toString(), 0).show();
                return;
            }
            Context context2 = getContext();
            int i7 = bmx.a.get(R.string.sora_editor_clip_text_length_too_large);
            if (i7 != 0) {
                i5 = i7;
            }
            Toast.makeText(context2, i5, 0).show();
        }
    }

    public final void dh(boolean z) {
        CodeEditor codeEditor;
        y yVar = this.j;
        if (yVar == null) {
            codeEditor = this;
        } else {
            if ((yVar instanceof bvb) && !this.af) {
                bvb bvbVar = (bvb) yVar;
                bvbVar.c = this.bp;
                bvbVar.t.getAndIncrement();
                dhs dhsVar = new dhs(bvbVar.b.getTabWidth());
                bvbVar.w = dhsVar;
                dhsVar.e = bvbVar.b.bg;
                try {
                    if (!bvbVar.u.a.tryLock(5L, TimeUnit.MILLISECONDS)) {
                        pi piVar = new pi();
                        bvbVar.u = piVar;
                        pi piVar2 = new pi();
                        bvbVar.v = piVar2;
                        bvbVar.y(piVar, piVar2);
                        return;
                    }
                    bvbVar.u.a.unlock();
                    pi piVar3 = bvbVar.u;
                    piVar3.getClass();
                    piVar3.g = new pg(piVar3);
                    piVar3.e = 0;
                    piVar3.d.clear();
                    piVar3.i = null;
                    piVar3.h = 0;
                    bvbVar.y(bvbVar.u, bvbVar.v);
                    return;
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to wait for lock", e);
                }
            }
            if ((yVar instanceof ewa) && this.af) {
                ewa ewaVar = new ewa(this, this.bp, this.az, (ewa) this.j, z);
                this.j.m();
                this.j = ewaVar;
                return;
            }
            codeEditor = this;
            yVar.m();
        }
        if (codeEditor.af) {
            codeEditor.co.ae = (int) ea();
            codeEditor.j = new ewa(codeEditor, codeEditor.bp, codeEditor.az, null, false);
        } else {
            codeEditor.j = new bvb(this, codeEditor.bp);
        }
        asv asvVar = codeEditor.by;
        if (asvVar != null) {
            asvVar.bb(0.0f, 0.0f, false);
        }
    }

    public final void di() {
        if (this.bo.h()) {
            df(true);
            dj();
            ee();
            return;
        }
        ahy cursor = getCursor();
        if (cursor.h()) {
            di();
            return;
        }
        ud udVarD = cursor.c.d();
        int i = udVarD.b;
        int i2 = getText().y(udVarD.b).b;
        int i3 = i + 1;
        if (i3 != getLineCount()) {
            er(i, 0, i3, 0);
        } else {
            if (getText().y(i).b == 0) {
                df(false);
                return;
            }
            er(i, 0, i, getText().y(i).b);
        }
        di();
        this.ck.getClass();
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.m = x;
            if (this.as) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 2) {
            int i = x - this.m;
            if (this.as && !this.by.ay() && ((i > 0 && getScroller().b.getCurrX() == 0)
                    || (i < 0 && getScroller().b.getCurrX() == getScrollMaxX()))) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /*
     * JADX WARN: Found duplicated region for block: B:160:0x023f A[PHI: r7
     * 0x023f: PHI (r7v6 int) = (r7v3 int), (r7v8 int) binds: [B:159:0x023d,
     * B:79:0x015a] A[DONT_GENERATE, DONT_INLINE]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:171:0x025a A[ADDED_TO_REGION]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:188:0x0264 A[ADDED_TO_REGION,
     * REMOVE, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:65:0x011a A[PHI: r7
     * 0x011a: PHI (r7v12 int) =
     * (r7v3 int)
     * (r7v2 int)
     * (r7v4 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v2 int)
     * (r7v13 int)
     * binds: [B:168:0x0254, B:144:0x0215, B:145:0x0217, B:142:0x020d, B:127:0x01e6,
     * B:115:0x01cc, B:103:0x01a5, B:93:0x0187, B:95:0x018d, B:85:0x016e,
     * B:82:0x0162, B:74:0x013a, B:70:0x012c, B:71:0x012e, B:67:0x0122, B:68:0x0124,
     * B:64:0x0119] A[DONT_GENERATE, DONT_INLINE]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:91:0x017f A[PHI: r7
     * 0x017f: PHI (r7v7 int) = (r7v3 int), (r7v5 int), (r7v8 int) binds:
     * [B:165:0x024d, B:90:0x017e, B:79:0x015a] A[DONT_GENERATE, DONT_INLINE]]
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v81 */
    /* JADX WARN: Type inference failed for: r5v82 */
    public final void dj() {
        boolean z;
        int iE;
        int iCharCount;
        int iCharCount2;
        ?? r5;
        int iCharCount3;
        boolean zHasBinaryProperty;
        ?? r52;
        boolean zHasBinaryProperty2;
        ahy ahyVar = this.bo;
        if (ahyVar.h()) {
            aff affVar = this.bp;
            ud udVar = ahyVar.c;
            int i = udVar.b;
            int i2 = udVar.c;
            ud udVar2 = ahyVar.d;
            affVar.r(i, i2, udVar2.b, udVar2.c);
            return;
        }
        ud udVar3 = ahyVar.c;
        int i3 = udVar3.c;
        int i4 = udVar3.b;
        anq anqVar = this.ck;
        int i5 = 1;
        if (anqVar.b || (anqVar.c != 1 && i3 > 0 && this.bp.m(i4, i3 - 1) == ' ')) {
            char[] cArr = this.bp.y(ahyVar.c.b).a;
            int i6 = i3 - 1;
            int i7 = i6;
            while (true) {
                if (i7 < 0) {
                    int i8 = this.bp.y(i4).b;
                    int i9 = i3;
                    while (true) {
                        if (i9 >= i8) {
                            z = true;
                            break;
                        }
                        char c = cArr[i9];
                        if (c != ' ' && c != '\t') {
                            z = false;
                            break;
                        }
                        i9++;
                    }
                    anq anqVar2 = this.ck;
                    if (!anqVar2.b || !z) {
                        if (anqVar2.c == 1 || i3 <= 0 || this.bp.m(i4, i6) != ' ') {
                            break;
                            break;
                            break;
                        }
                        aff affVar2 = this.bp;
                        int tabWidth = this.ck.c;
                        if (tabWidth == -1) {
                            tabWidth = getTabWidth();
                        }
                        affVar2.r(i4, Math.max(0, i3 - tabWidth), i4, i3);
                        return;
                    }
                    if (i4 == 0) {
                        this.bp.r(i4, 0, i4, i3);
                        return;
                    }
                    aff affVar3 = this.bp;
                    int i10 = i4 - 1;
                    affVar3.r(i10, affVar3.y(i10).b, i4, i8);
                    return;
                }
                char c2 = cArr[i7];
                if (c2 != ' ' && c2 != '\t') {
                    break;
                } else {
                    i7--;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            afo afoVarY = this.bp.y(ahyVar.c.b);
            if (i3 <= 1) {
                iE = 0;
            } else {
                int iCharCount4 = i3;
                int i11 = 0;
                int iCharCount5 = 0;
                int iCharCount6 = 0;
                while (true) {
                    int iCodePointBefore = Character.codePointBefore(afoVarY, iCharCount4);
                    iCharCount4 -= Character.charCount(iCodePointBefore);
                    int i12 = i5;
                    switch (i11) {
                        case 0:
                            iCharCount5 = Character.charCount(iCodePointBefore);
                            i11 = 10;
                            if (iCodePointBefore == 10) {
                                i11 = i12;
                            } else if (UCharacter.hasBinaryProperty(iCodePointBefore, 36)) {
                                i11 = 6;
                            } else if (((127462 > iCodePointBefore || iCodePointBefore > 127487) ? 0 : i12) == 0) {
                                if (!UCharacter.hasBinaryProperty(iCodePointBefore, 59)) {
                                    if (iCodePointBefore == 8419) {
                                        i11 = 2;
                                    } else if (!UCharacter.hasBinaryProperty(iCodePointBefore, 57)) {
                                        if (iCodePointBefore == 917631) {
                                            i11 = 12;
                                        } else {
                                            r5 = zHasBinaryProperty;
                                            r52 = zHasBinaryProperty2;
                                            i11 = 13;
                                        }
                                    }
                                }
                            }
                            if (iCharCount4 > 0 && i11 != 13) {
                                i5 = i12;
                            }
                            break;
                        case 1:
                            if (iCodePointBefore == 13) {
                                iCharCount5++;
                            }
                            r5 = zHasBinaryProperty;
                            r52 = zHasBinaryProperty2;
                            i11 = 13;
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 2:
                            if (UCharacter.hasBinaryProperty(iCodePointBefore, 36)) {
                                iCharCount6 = Character.charCount(iCodePointBefore);
                                i11 = 3;
                            } else {
                                if ((((48 <= iCodePointBefore && iCodePointBefore <= 57) || iCodePointBefore == 35 || iCodePointBefore == 42) ? i12 : 0) != 0) {
                                    iCharCount = Character.charCount(iCodePointBefore);
                                    iCharCount5 += iCharCount;
                                }
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 3:
                            if ((((48 <= iCodePointBefore && iCodePointBefore <= 57) || iCodePointBefore == 35 || iCodePointBefore == 42) ? i12 : 0) != 0) {
                                iCharCount2 = Character.charCount(iCodePointBefore);
                                iCharCount = iCharCount2 + iCharCount6;
                                iCharCount5 += iCharCount;
                            }
                            r5 = zHasBinaryProperty;
                            r52 = zHasBinaryProperty2;
                            i11 = 13;
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 4:
                            if (UCharacter.hasBinaryProperty(iCodePointBefore, 36)) {
                                iCharCount6 = Character.charCount(iCodePointBefore);
                                i11 = 5;
                            } else {
                                if (iCodePointBefore == 129309 || iCodePointBefore == 129340) {
                                    r5 = i12;
                                } else {
                                    zHasBinaryProperty = UCharacter.hasBinaryProperty(iCodePointBefore, 60);
                                }
                                if (r5 != 0) {
                                    r5 = zHasBinaryProperty;
                                    iCharCount3 = Character.charCount(iCodePointBefore);
                                    iCharCount5 += iCharCount3;
                                } else {
                                    r5 = zHasBinaryProperty;
                                    r52 = zHasBinaryProperty2;
                                    i11 = 13;
                                }
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 5:
                            if (iCodePointBefore == 129309 || iCodePointBefore == 129340) {
                                r52 = i12;
                            } else {
                                zHasBinaryProperty2 = UCharacter.hasBinaryProperty(iCodePointBefore, 60);
                            }
                            if (r52 != 0) {
                                r52 = zHasBinaryProperty2;
                                iCharCount2 = Character.charCount(iCodePointBefore);
                                iCharCount = iCharCount2 + iCharCount6;
                                iCharCount5 += iCharCount;
                            }
                            r5 = zHasBinaryProperty;
                            r52 = zHasBinaryProperty2;
                            i11 = 13;
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 6:
                            if (!UCharacter.hasBinaryProperty(iCodePointBefore, 57)) {
                                if (!UCharacter.hasBinaryProperty(iCodePointBefore, 36) && UCharacter.getCombiningClass(iCodePointBefore) == 0) {
                                    iCharCount = Character.charCount(iCodePointBefore);
                                    iCharCount5 += iCharCount;
                                }
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                                if (iCharCount4 > 0) {
                                }
                            } else {
                                iCharCount3 = Character.charCount(iCodePointBefore);
                                iCharCount5 += iCharCount3;
                                if (iCharCount4 > 0) {
                                }
                            }
                            break;
                        case 7:
                            if (iCodePointBefore == 8205) {
                                i11 = 8;
                            } else {
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 8:
                            if (UCharacter.hasBinaryProperty(iCodePointBefore, 57)) {
                                iCharCount5 += Character.charCount(iCodePointBefore) + 1;
                                i11 = UCharacter.hasBinaryProperty(iCodePointBefore, 59) ? 4 : 7;
                            } else if (UCharacter.hasBinaryProperty(iCodePointBefore, 36)) {
                                iCharCount6 = Character.charCount(iCodePointBefore);
                                i11 = 9;
                            } else {
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 9:
                            if (UCharacter.hasBinaryProperty(iCodePointBefore, 57)) {
                                iCharCount5 += Character.charCount(iCodePointBefore) + iCharCount6 + 1;
                                i11 = 7;
                                iCharCount6 = 0;
                            } else {
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 10:
                            if (127462 > iCodePointBefore || iCodePointBefore > 127487) {
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            } else {
                                iCharCount5 += 2;
                                i11 = 11;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 11:
                            if (127462 > iCodePointBefore || iCodePointBefore > 127487) {
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            } else {
                                iCharCount5 -= 2;
                                i11 = 10;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        case 12:
                            if (917536 <= iCodePointBefore && iCodePointBefore <= 917630) {
                                iCharCount5 += 2;
                            } else if (UCharacter.hasBinaryProperty(iCodePointBefore, 57)) {
                                iCharCount = Character.charCount(iCodePointBefore);
                                iCharCount5 += iCharCount;
                                r5 = zHasBinaryProperty;
                                r52 = zHasBinaryProperty2;
                                i11 = 13;
                            } else {
                                i11 = 13;
                                iCharCount5 = 2;
                            }
                            if (iCharCount4 > 0) {
                            }
                            break;
                        default:
                            throw new IllegalArgumentException(yg.f(i11, "state ", " is unknown"));
                    }
                }
                iE = i3 - iCharCount5;
            }
        } else {
            iE = dqq.d().e(i3, this.bp.y(ahyVar.c.b));
        }
        ud udVar4 = ahyVar.c;
        int i13 = udVar4.c;
        if (iE > i13) {
            i13 = iE;
            iE = i13;
        }
        if (iE != i13) {
            aff affVar4 = this.bp;
            int i14 = udVar4.b;
            affVar4.r(i14, iE, i14, i13);
            return;
        }
        int i15 = udVar4.b;
        if (i15 <= 0 || iE != 0) {
            return;
        }
        aff affVar5 = this.bp;
        int i16 = i15 - 1;
        affVar5.r(i16, affVar5.y(i16).b, ahyVar.c.b, 0);
    }

    public final void dk(String str, boolean z) {
        ahy cursor = getCursor();
        if (cursor.h()) {
            ud udVarD = cursor.c.d();
            ud udVarD2 = cursor.d.d().d();
            aff text = getText();
            int i = udVarD.b;
            int i2 = udVarD.c;
            int i3 = udVarD2.b;
            int i4 = udVarD2.c;
            text.ae(false);
            try {
                aff affVarAl = text.al(i, i2, i3, i4);
                text.ap(false);
                ep(udVarD2.b, udVarD2.c);
                de(str + ((Object) affVarAl), false);
                if (z) {
                    ud udVarD3 = cursor.d.d();
                    er(udVarD2.b, udVarD2.c, udVarD3.b, udVarD3.c);
                }
            } catch (Throwable th) {
                text.ap(false);
                throw th;
            }
        }
    }

    public final void dl(int i, int i2) {
        float width;
        aso scroller = getScroller();
        float[] fArrR = this.j.r(i, i2);
        float fEb = eb() + fArrR[1];
        float f = fArrR[0];
        OverScroller overScroller = scroller.b;
        OverScroller overScroller2 = scroller.b;
        float offsetY = overScroller.isFinished() ? getOffsetY() : overScroller.getFinalY();
        float offsetX = overScroller.isFinished() ? getOffsetX() : overScroller.getFinalX();
        this.ck.getClass();
        float rowHeight = f - ((float) (getRowHeight() * 2)) < offsetY ? f - (getRowHeight() * 2) : offsetY;
        if (f > getHeight() + offsetY) {
            rowHeight = (getRowHeight() * 1.0f) + (f - getHeight());
        }
        float fMeasureText = i2 == 0 ? 0.0f : getTextPaint().measureText(bt.at);
        if (fEb < (this.ay ? eb() : 0.0f) + offsetX) {
            int width2 = getWidth() / 2;
            width = ((this.ay ? -eb() : 0.0f) + fEb) - fMeasureText;
            float f2 = width2;
            if (Math.abs(width - offsetX) < f2) {
                width = Math.max(1.0f, offsetX - f2);
            }
        } else {
            width = offsetX;
        }
        if (fEb + fMeasureText > offsetX + getWidth()) {
            width = ((fMeasureText * 0.8f) + fEb) - getWidth();
        }
        float fMax = Math.max(0.0f, Math.min(getScrollMaxX(), width));
        float fMax2 = Math.max(0.0f, Math.min(getScrollMaxY(), rowHeight));
        if (Math.abs(fMax - getOffsetX()) < Math.abs(1.0f) && Math.abs(fMax2 - getOffsetY()) < Math.abs(1.0f)) {
            invalidate();
            return;
        }
        boolean z = System.currentTimeMillis() - this.bw >= 100;
        this.bw = System.currentTimeMillis();
        if (z) {
            overScroller2.forceFinished(true);
            scroller.c();
            scroller.d(getOffsetX(), getOffsetY(), (int) (fMax - getOffsetX()), (int) (fMax2 - getOffsetY()),
                    scroller.a.getProps().i);
            this.ck.getClass();
        } else {
            scroller.d(getOffsetX(), getOffsetY(), (int) (fMax - getOffsetX()), (int) (fMax2 - getOffsetY()), 0);
            overScroller2.abortAnimation();
            scroller.c();
        }
        this.i.g(new dfb(this, getOffsetX(), getOffsetY(), (int) fMax, (int) fMax2, 3));
        invalidate();
    }

    public final void dm() {
        ud udVar = this.g;
        if (udVar != null) {
            aff affVar = this.bp;
            affVar.getClass();
            int i = udVar.b;
            int i2 = udVar.c;
            int i3 = udVar.a;
            boolean z = false;
            affVar.ae(false);
            if (i >= 0) {
                try {
                    if (i < affVar.a.size()) {
                        afo afoVarY = affVar.y(i);
                        if (i2 <= afoVarY.b + afoVarY.g().g && i2 >= 0) {
                            boolean z2 = affVar.x().o(i, i2).a == i3;
                            affVar.ap(false);
                            z = z2;
                        }
                    }
                    affVar.ap(false);
                } catch (Throwable th) {
                    affVar.ap(false);
                    throw th;
                }
            } else {
                affVar.ap(false);
            }
            if (z) {
                return;
            }
        }
        this.g = this.bo.d.d();
    }

    public final void dn() {
        dl(getCursor().d.b, getCursor().d.c);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void m10do(dfs dfsVar) {
        dm();
        ud selectingTarget = getSelectingTarget();
        dfsVar.getClass();
        throwIfVar1IsNull(selectingTarget, "pos");
        ud udVar = (ud) dfsVar.r.g(this, selectingTarget);
        ud udVar2 = this.g;
        es(udVar2.b, false, udVar2.c, udVar.b, udVar.c, 7);
        if (dfsVar == dfs.g) {
            this.by.bb(0.0f, -getHeight(), true);
        } else if (dfsVar == dfs.h) {
            this.by.bb(0.0f, getHeight(), true);
        }
        if (this.bo.c.d().equals(this.g)) {
            dn();
        } else {
            ud udVar3 = this.bo.c;
            dl(udVar3.b, udVar3.c);
        }
    }

    public final ExtractedText dp(ExtractedTextRequest extractedTextRequest) {
        getProps().getClass();
        getProps().getClass();
        ahy cursor = getCursor();
        ExtractedText extractedText = new ExtractedText();
        int i = cursor.c.a;
        int i2 = cursor.d.a;
        if (extractedTextRequest.hintMaxChars == 0) {
            extractedTextRequest.hintMaxChars = this.ck.g;
        }
        int i3 = extractedTextRequest.hintMaxChars;
        int iMin = i3 < i ? Math.min(i - (i3 / 2), i) : 0;
        extractedText.text = this.h.g(iMin, extractedTextRequest.hintMaxChars + iMin, extractedTextRequest.flags);
        extractedText.startOffset = iMin;
        extractedText.selectionStart = i - iMin;
        extractedText.selectionEnd = i2 - iMin;
        btm keyMetaStates = getKeyMetaStates();
        if (keyMetaStates.e() && !keyMetaStates.d()) {
            extractedText.flags |= 2;
        }
        return extractedText;
    }

    public final int dq() {
        int i;
        dnv dnvVar = this.cm;
        ArrayList arrayList = dnvVar == null ? null : dnvVar.b;
        int i2 = -1;
        if (arrayList != null && !arrayList.isEmpty()) {
            int i3 = this.bo.c.b;
            int iCx = cx(i3, arrayList);
            int i4 = 0;
            if (iCx == -1) {
                iCx = 0;
            }
            int size = arrayList.size() - 1;
            dnv dnvVar2 = this.cm;
            int i5 = dnvVar2 != null ? dnvVar2.c : Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            while (iCx <= size) {
                aah aahVar = (aah) arrayList.get(iCx);
                if (aahVar != null) {
                    int i7 = aahVar.e;
                    if (i7 >= i3 && (i = aahVar.c) <= i3) {
                        int i8 = i7 - i;
                        if (i8 < i6) {
                            i2 = iCx;
                            i6 = i8;
                        }
                    } else if (i6 != Integer.MAX_VALUE && (i4 = i4 + 1) >= i5) {
                        break;
                    }
                }
                iCx++;
            }
        }
        return i2;
    }

    public final long dr(float f, float f2) {
        float fMax = Math.max(0.0f, f2);
        this.co.getClass();
        return this.j.f((f + getOffsetX()) - eb(), fMax + getOffsetY());
    }

    public final int ds(int i) {
        int lineSpacingPixels = getLineSpacingPixels();
        Paint.FontMetricsInt fontMetricsInt = this.co.t;
        return (((i + 1) * Math.max(1, (fontMetricsInt.descent - fontMetricsInt.ascent) + lineSpacingPixels))
                - fontMetricsInt.descent) - (lineSpacingPixels / 2);
    }

    public final int dt(int i) {
        return (i + 1) * getRowHeight();
    }

    public final int du(int i) {
        return (getLineSpacingPixels() / 2) + (getRowHeight() * i);
    }

    public final void dv(boolean z) {
        ahy cursor = getCursor();
        if (!z || cursor.h()) {
            btq editorLanguage = getEditorLanguage();
            int tabWidth = getTabWidth();
            int tabWidth2 = getTabWidth();
            editorLanguage.getClass();
            String strN = cna.n(tabWidth, tabWidth2, false);
            aff text = getText();
            int tabWidth3 = getTabWidth();
            text.l();
            for (int i = cursor.c.b; i <= cursor.d.b; i++) {
                long jM = cna.m(text.y(i));
                int i2 = (int) (jM >> 32);
                int i3 = (int) (jM & 4294967295L);
                int i4 = (i3 * tabWidth3) + i2;
                int i5 = i2 + i3;
                int i6 = tabWidth3 - (i4 % tabWidth3);
                if (i2 > 0 && i3 > 0) {
                    if (i6 == 0) {
                        i6 = tabWidth3;
                    }
                    text.ah(i, 0, dnr.bm((i6 + i4) / tabWidth3, strN), i, i5);
                } else if (i6 == 0) {
                    text.ab(i, i5, strN);
                } else {
                    text.ab(i, i5, dnr.bm(i6, " "));
                }
            }
            text.u();
        }
    }

    public final boolean dw() {
        if (!this.ae || this.ak) {
            return false;
        }
        dx();
        return true;
    }

    public final void dx() {
        this.bu.getClass();
    }

    public final boolean dy() {
        this.ck.getClass();
        return this.ah || this.ai;
    }

    public final boolean dz(float f, float f2) {
        long jDr = dr(f, f2);
        drd drdVarAo = this.co.ao(this.j.l(this.bp.v((int) (jDr >> 32), (int) (jDr & 4294967295L))));
        cbr cbrVar = new cbr(drdVarAo, new dqz());
        drdVarAo.aa(cbrVar, true);
        float f3 = cbrVar.a;
        float fEb = eb();
        float offsetX = getOffsetX() + f;
        return offsetX >= fEb && offsetX <= f3 + fEb;
    }

    public final float ea() {
        float fMax = 0.0f;
        if (!this.aq) {
            return 0.0f;
        }
        int i = 0;
        for (int lineCount = getLineCount(); lineCount > 0; lineCount /= 10) {
            i++;
        }
        float[] fArrB = dqd.b(19);
        this.co.e.getTextWidths("0 1 2 3 4 5 6 7 8 9", fArrB);
        dqd.c(fArrB);
        for (int i2 = 0; i2 < 19; i2 += 2) {
            fMax = Math.max(fMax, fArrB[i2]);
        }
        return (fMax * i) + this.aa;
    }

    public final float eb() {
        if (!this.aq) {
            return this.p * 5.0f;
        }
        float fEa = ea() + this.r + this.s + this.q;
        this.co.bi();
        return fEa + 0;
    }

    public final void ec(dfs dfsVar, boolean z) {
        if (z) {
            m10do(dfsVar);
        } else {
            ed(dfsVar);
        }
    }

    public final void ed(dfs dfsVar) {
        ud udVarD;
        if (this.bo.h()) {
            if (dfsVar == dfs.c) {
                ud udVar = this.bo.c;
                eq(udVar.b, udVar.c, 7, true);
                return;
            } else if (dfsVar == dfs.d) {
                ud udVar2 = this.bo.d;
                eq(udVar2.b, udVar2.c, 7, true);
                return;
            }
        }
        int iOrdinal = dfsVar.s.ordinal();
        if (iOrdinal == 0) {
            udVarD = this.bo.c.d();
        } else if (iOrdinal != 1) {
            dm();
            udVarD = this.g;
        } else {
            udVarD = this.bo.d.d();
        }
        throwIfVar1IsNull(udVarD, "pos");
        ud udVar3 = (ud) dfsVar.r.g(this, udVarD);
        if (dfsVar == dfs.g) {
            this.by.bb(0.0f, -getHeight(), true);
        } else if (dfsVar == dfs.h) {
            this.by.bb(0.0f, getHeight(), true);
        }
        eq(udVar3.b, udVar3.c, 7, true);
    }

    public final void ee() {
        ExtractedTextRequest extractedTextRequest = this.cf;
        if (extractedTextRequest != null) {
            ExtractedText extractedTextDp = dp(extractedTextRequest);
            this.bn.updateExtractedText(this, this.cf.token, extractedTextDp);
        }
        ex();
        ew();
        if (this.h.c.e()) {
            el();
        }
    }

    public final void ef(int i) {
        this.i.g(new dfn(this, i));
        getCursorRange();
    }

    public final void eg() {
        ClipData primaryClip;
        String strAt;
        asa asaVar;
        try {
            if (!this.bm.hasPrimaryClip() || (primaryClip = this.bm.getPrimaryClip()) == null
                    || (strAt = HugeSyntheticPileOfHelpers.at(primaryClip)) == null || (asaVar = this.h) == null) {
                return;
            }
            asaVar.commitText(strAt, 1);
            this.ck.getClass();
            ee();
        } catch (Exception e) {
            Log.w("CodeEditor", "Error pasting text to editor", e);
            Toast.makeText(getContext(), e.toString(), 0).show();
        }
    }

    public final void eh(Runnable runnable, long j) {
        arz.a.postDelayed(new aaj(this, runnable, 1), j);
    }

    public final void ei(Runnable runnable) {
        arz.a.post(new aaj(this, runnable, 0));
    }

    public final void ej() {
        aff affVar = this.bp;
        enr enrVar = affVar.i;
        ArrayList arrayList = enrVar.a;
        if (enrVar.b && enrVar.g < arrayList.size() && !enrVar.h) {
            enrVar.h = true;
            ((enm) arrayList.get(enrVar.g)).d(affVar);
            enrVar.g++;
            enrVar.h = false;
        }
        ee();
    }

    public final void ek() {
        if (this.bf) {
            requestLayout();
        }
    }

    public final void el() {
        asa asaVar = this.h;
        if (asaVar != null) {
            aff text = asaVar.b.getText();
            while (text.e > 0) {
                text.u();
            }
            pf pfVar = asaVar.c;
            pfVar.b = -1;
            pfVar.a = -1;
            asaVar.d = false;
        }
        InputMethodManager inputMethodManager = this.bn;
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
    }

    public final void em() {
        er(0, 0, getLineCount() - 1, getText().y(getLineCount() - 1).b);
    }

    public final void en(int i, int i2) {
        dqs dqsVarY = KotlinHelpers.y(getText(), i, i2, this.ck.o);
        ud udVar = dqsVarY.a;
        ud udVar2 = dqsVarY.b;
        es(udVar.b, true, udVar.c, udVar2.b, udVar2.c, 5);
    }

    public final void eo(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("margin can not be under zero");
        }
        this.r = f;
        this.s = f2;
        ek();
        invalidate();
    }

    public final void ep(int i, int i2) {
        eq(i, i2, 0, true);
    }

    public final void eq(int i, int i2, int i3, boolean z) {
        int i4;
        ((cfg) this.ch).o();
        if (i2 > 0 && Character.isHighSurrogate(this.bp.m(i, i2 - 1)) && (i4 = i2 + 1) <= this.bp.y(i).b) {
            i2 = i4;
        }
        ahy ahyVar = this.bo;
        ahyVar.c = ahyVar.b.o(i, i2).d();
        ahyVar.d = ahyVar.b.o(i, i2).d();
        if (this.at) {
            this.l = dq();
        }
        ev();
        ex();
        if (this.ae && !this.by.ay() && this.ao == 0) {
            ((cfg) this.ch).n();
            ((cfg) this.ch).p();
        }
        this.g = this.bo.d.d();
        this.cn.c();
        if (z) {
            dl(i, i2);
        } else {
            invalidate();
        }
        ef(i3);
    }

    public final void er(int i, int i2, int i3, int i4) {
        es(i, true, i2, i3, i4, 0);
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x0083 */
    /* JADX WARN: Found duplicated region for block: B:21:0x00a0 */
    public final void es(int i, boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        requestFocus();
        int iV = getText().v(i, i2);
        int iV2 = getText().v(i3, i4);
        if (iV == iV2) {
            eq(i, i2, i5, z);
            return;
        }
        if (iV > iV2) {
            es(i3, z, i4, i, i2, i5);
            StringBuilder sbQ = yg.concatVar31425(iV, iV2, "setSelectionRegion() error: start > end:start = ", " end = ",
                    " lineLeft = ");
            sbQ.append(i);
            sbQ.append(" columnLeft = ");
            sbQ.append(i2);
            sbQ.append(" lineRight = ");
            sbQ.append(i3);
            sbQ.append(" columnRight = ");
            sbQ.append(i4);
            Log.w("CodeEditor", sbQ.toString());
            return;
        }
        ((cfg) this.ch).l();
        this.bo.h();
        if (i2 <= 0) {
            i6 = i2;
        } else if (!Character.isHighSurrogate(this.bp.m(i, i2 - 1)) || (i6 = i2 + 1) > this.bp.y(i).b) {
            i6 = i2;
        }
        if (i4 <= 0) {
            i7 = i4;
        } else if (!Character.isHighSurrogate(this.bp.m(i3, i4 - 1)) || (i7 = i4 + 1) > this.bp.y(i3).b) {
            i7 = i4;
        }
        ahy ahyVar = this.bo;
        ahyVar.c = ahyVar.b.o(i, i6).d();
        ahy ahyVar2 = this.bo;
        ahyVar2.d = ahyVar2.b.o(i3, i7).d();
        ev();
        ex();
        this.cn.c();
        if (!this.bo.c.d().equals(this.g) && !this.bo.d.d().equals(this.g)) {
            this.g = this.bo.d.d();
        }
        if (!z) {
            invalidate();
        } else if (i5 == 6) {
            dl(i, i6);
            this.bw = 0L;
            dl(i3, i7);
        } else {
            dl(i3, i7);
        }
        ef(i5);
    }

    public final void et(boolean z, boolean z2) {
        if (this.af == z && this.az == z2) {
            return;
        }
        this.af = z;
        this.az = z2;
        ek();
        dh(true);
        if (!z) {
            this.cn.c();
        }
        invalidate();
    }

    public final void eu() {
        dqs dqsVar;
        int i;
        aff affVar = this.bp;
        enr enrVar = affVar.i;
        if (!enrVar.b || (i = enrVar.g) <= 0 || enrVar.h) {
            dqsVar = null;
        } else {
            enrVar.h = true;
            enm enmVar = (enm) enrVar.a.get(i - 1);
            enmVar.e(affVar);
            enrVar.g--;
            enrVar.h = false;
            dqsVar = enmVar.a;
        }
        if (dqsVar != null) {
            try {
                ud udVar = dqsVar.a;
                int i2 = udVar.b;
                int i3 = udVar.c;
                ud udVar2 = dqsVar.b;
                es(i2, true, i3, udVar2.b, udVar2.c, 1);
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        ee();
    }

    public final void ev() {
        ew();
        ExtractedTextRequest extractedTextRequest = this.cf;
        if (extractedTextRequest != null) {
            ExtractedText extractedTextDp = dp(extractedTextRequest);
            this.bn.updateExtractedText(this, this.cf.token, extractedTextDp);
        }
        if (this.bp.e > 1 || this.h.c.e()) {
            return;
        }
        ex();
    }

    public final float ew() {
        float f;
        boolean z;
        ud udVar = this.bo.d;
        float fEb = (eb() + this.j.r(udVar.b, udVar.c)[1]) - getOffsetX();
        if (fEb < 0.0f) {
            f = 0.0f;
            z = false;
        } else {
            f = fEb;
            z = true;
        }
        if (this.ck.ac) {
            CursorAnchorInfo.Builder builder = this.cc;
            builder.reset();
            this.bq.set(getMatrix());
            getLocationOnScreen(new int[2]);
            this.bq.postTranslate(r4[0], r4[1]);
            builder.setMatrix(this.bq);
            ahy ahyVar = this.bo;
            builder.setSelectionRange(ahyVar.c.a, ahyVar.d.a);
            builder.setInsertionMarkerLocation(f, (getRowHeight() * r1) - getOffsetY(), ds(r1) - getOffsetY(),
                    dt(r1) - getOffsetY(), z ? 1 : 2);
            this.bn.updateCursorAnchorInfo(this, builder.build());
        }
        return f;
    }

    public final void ex() {
        int i;
        int i2;
        int i3;
        this.ck.getClass();
        int i4 = -1;
        if (this.h.c.e()) {
            try {
                pf pfVar = this.h.c;
                i = pfVar.a;
                try {
                    i4 = pfVar.b;
                } catch (IndexOutOfBoundsException unused) {
                }
            } catch (IndexOutOfBoundsException unused2) {
                i = -1;
            }
            i2 = i4;
            i3 = i;
        } else {
            i3 = -1;
            i2 = -1;
        }
        ahy ahyVar = this.bo;
        this.bn.updateSelection(this, ahyVar.c.a, ahyVar.d.a, i3, i2);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return CodeEditor.class.getName();
    }

    public int getBlockIndex() {
        return this.l;
    }

    public float getBlockLineWidth() {
        return this.u;
    }

    public ClipboardManager getClipboardManager() {
        return this.bm;
    }

    public arq getColorScheme() {
        return this.br;
    }

    public int getCurrentCursorBlock() {
        return this.l;
    }

    public ahy getCursor() {
        return this.bo;
    }

    public ahz getCursorAnimator() {
        return this.ch;
    }

    public aia getCursorBlink() {
        return this.cj;
    }

    public dqs getCursorRange() {
        ahy ahyVar = this.bo;
        return new dqs(ahyVar.c.d(), ahyVar.d.d());
    }

    public amu getDiagnosticIndicatorStyle() {
        return this.bv;
    }

    public amv getDiagnostics() {
        return null;
    }

    public float getDividerMarginLeft() {
        return this.r;
    }

    public float getDividerMarginRight() {
        return this.s;
    }

    public float getDividerWidth() {
        return this.q;
    }

    public float getDpUnit() {
        return this.p;
    }

    public int getEdgeEffectColor() {
        return this.cd.getColor();
    }

    public boolean getEditable() {
        return this.ae;
    }

    public btq getEditorLanguage() {
        return this.bu;
    }

    public asv getEventHandler() {
        return this.by;
    }

    public Bundle getExtraArguments() {
        return this.cl;
    }

    public int getFirstVisibleLine() {
        try {
            return this.j.o(getFirstVisibleRow());
        } catch (IndexOutOfBoundsException unused) {
            return 0;
        }
    }

    public int getFirstVisibleRow() {
        return Math.max(0, getOffsetY() / getRowHeight());
    }

    public String getFormatTip() {
        return this.bt;
    }

    public csk getGraphPaint() {
        return this.co.i;
    }

    public dfp getHandleStyle() {
        return this.ci;
    }

    public blp getHighlightTexts() {
        return null;
    }

    public float getHighlightedDelimiterBorderWidth() {
        return this.v;
    }

    public EdgeEffect getHorizontalEdgeEffect() {
        return this.ce;
    }

    @Override // android.view.View
    public Drawable getHorizontalScrollbarThumbDrawable() {
        return this.co.u;
    }

    @Override // android.view.View
    public Drawable getHorizontalScrollbarTrackDrawable() {
        return this.co.v;
    }

    public List<Object> getInlayHintRenderers() {
        return new ArrayList(this.cw.values());
    }

    public bpi getInlayHints() {
        return null;
    }

    public InputMethodManager getInputMethodManager() {
        return this.bn;
    }

    public int getInputType() {
        return this.n;
    }

    public dfo getInsertHandleDescriptor() {
        return this.bl;
    }

    public float getInsertSelectionWidth() {
        return this.t;
    }

    public btm getKeyMetaStates() {
        return (btm) this.a.d;
    }

    public int getLastVisibleLine() {
        try {
            return this.j.o(getLastVisibleRow());
        } catch (IndexOutOfBoundsException unused) {
            return getLineCount() - 1;
        }
    }

    public int getLastVisibleRow() {
        return Math.max(0, Math.min(this.j.e() - 1, (getHeight() + getOffsetY()) / getRowHeight()));
    }

    public btr getLayout() {
        return this.j;
    }

    public dfo getLeftHandleDescriptor() {
        return this.bj;
    }

    public int getLineCount() {
        return this.bp.a.size();
    }

    public float getLineInfoTextSize() {
        return this.x;
    }

    public Paint.Align getLineNumberAlign() {
        return this.bz;
    }

    public float getLineNumberMarginLeft() {
        return this.aa;
    }

    public Paint.FontMetricsInt getLineNumberMetrics() {
        return this.co.ac;
    }

    public bvc getLineNumberTipTextProvider() {
        return this.bs;
    }

    public bvd getLineSeparator() {
        return this.cu;
    }

    public float getLineSpacingExtra() {
        return this.z;
    }

    public float getLineSpacingMultiplier() {
        return this.y;
    }

    public int getLineSpacingPixels() {
        Paint.FontMetricsInt fontMetricsInt = this.co.t;
        return (((int) (((this.y - 1.0f) * (fontMetricsInt.descent - fontMetricsInt.ascent)) + this.z)) / 2) * 2;
    }

    public int getLnPanelPosition() {
        return this.am;
    }

    public int getLnPanelPositionMode() {
        return this.an;
    }

    public int getNonPrintablePaintingFlags() {
        return this.o;
    }

    public int getOffsetX() {
        return this.by.b.b.getCurrX();
    }

    public int getOffsetY() {
        return this.by.b.b.getCurrY();
    }

    public csk getOtherPaint() {
        return this.co.e;
    }

    public anq getProps() {
        return this.ck;
    }

    public dbg getRenderContext() {
        return this.cn;
    }

    public asn getRenderer() {
        return this.co;
    }

    public dfo getRightHandleDescriptor() {
        return this.bk;
    }

    public int getRowHeight() {
        Paint.FontMetricsInt fontMetricsInt = this.co.t;
        return Math.max(1, getLineSpacingPixels() + (fontMetricsInt.descent - fontMetricsInt.ascent));
    }

    public int getRowHeightOfText() {
        Paint.FontMetricsInt fontMetricsInt = this.co.t;
        return fontMetricsInt.descent - fontMetricsInt.ascent;
    }

    public int getScrollMaxX() {
        return (int) Math.max(0.0f, (eb() + this.j.s()) - (getWidth() / 2.0f));
    }

    public int getScrollMaxY() {
        float height;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int iG = this.j.g();
        if (layoutParams == null || layoutParams.height == -2) {
            height = getHeight();
        } else {
            height = (1.0f - this.ab) * getHeight();
        }
        return Math.max(0, iG - ((int) height));
    }

    public aso getScroller() {
        return this.by.b;
    }

    public asp getSearcher() {
        return this.cg;
    }

    public ud getSelectingTarget() {
        return this.bo.c.d().equals(this.g) ? this.bo.d.d() : this.bo.c.d();
    }

    public dik getSnippetController() {
        return this.cv;
    }

    public dnv getStyles() {
        return this.cm;
    }

    public int getTabWidth() {
        return this.k;
    }

    public aff getText() {
        return this.bp;
    }

    public float getTextLetterSpacing() {
        return this.co.d.getLetterSpacing();
    }

    public csk getTextPaint() {
        return this.co.d;
    }

    public float getTextScaleX() {
        return this.co.d.getTextScaleX();
    }

    public float getTextSizePx() {
        return this.co.d.getTextSize();
    }

    public Typeface getTypefaceLineNumber() {
        return this.co.e.getTypeface();
    }

    public Typeface getTypefaceText() {
        return this.co.d.getTypeface();
    }

    public EdgeEffect getVerticalEdgeEffect() {
        return this.cd;
    }

    public float getVerticalExtraSpaceFactor() {
        return this.ab;
    }

    @Override // android.view.View
    public Drawable getVerticalScrollbarThumbDrawable() {
        return this.co.w;
    }

    @Override // android.view.View
    public Drawable getVerticalScrollbarTrackDrawable() {
        return this.co.x;
    }

    @Override // android.view.View
    public final boolean isHorizontalScrollBarEnabled() {
        return this.aw;
    }

    @Override // android.view.View
    public final boolean isVerticalScrollBarEnabled() {
        return this.av;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i.g(new rp(this));
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        return isEnabled() && dw();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.by.ba();
        this.ai = false;
        this.ah = false;
    }

    @Override // android.view.View
    public final void onCreateContextMenu(ContextMenu contextMenu) {
        super.onCreateContextMenu(contextMenu);
        PointF pointF = this.by.af;
        if (pointF == null) {
            return;
        }
        long jDr = dr(pointF.x, pointF.y);
        this.i.g(new ahu(this, contextMenu, this.bp.x().o((int) (jDr >> 32), (int) (jDr & 4294967295L))));
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (!dw() || !isEnabled()) {
            return null;
        }
        if (dd()) {
            int i = this.n;
            if (i == 0) {
                i = 131073;
            }
            editorInfo.inputType = i;
        } else {
            editorInfo.inputType = 0;
        }
        editorInfo.initialSelStart = getCursor() != null ? getCursor().c.a : 0;
        editorInfo.initialSelEnd = getCursor() != null ? getCursor().d.a : 0;
        editorInfo.initialCapsMode = this.h.getCursorCapsMode(0);
        this.ck.getClass();
        editorInfo.imeOptions = 301989888;
        this.i.g(new rp(this));
        asa asaVar = this.h;
        aff text = asaVar.b.getText();
        while (text.e > 0) {
            text.u();
        }
        pf pfVar = asaVar.c;
        pfVar.b = -1;
        pfVar.a = -1;
        asaVar.d = false;
        this.bp.e = 0;
        setExtracting(null);
        return this.h;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i.g(new rp(this));
        aia aiaVar = this.cj;
        aiaVar.c = false;
        removeCallbacks(aiaVar);
    }

    @Override // android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        asa asaVar;
        int action = dragEvent.getAction();
        if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 6) {
                        return super.onDragEvent(dragEvent);
                    }
                    this.by.ai = null;
                    postInvalidate();
                    return true;
                }
                asv asvVar = this.by;
                ud udVar = asvVar.ai;
                if (udVar == null) {
                    return false;
                }
                asvVar.ai = null;
                ep(udVar.b, udVar.c);
                String strAt = HugeSyntheticPileOfHelpers.at(dragEvent.getClipData());
                if (strAt != null && (asaVar = this.h) != null) {
                    asaVar.commitText(strAt, 1);
                    this.ck.getClass();
                    ee();
                }
                requestFocus();
                postInvalidate();
                super.onDragEvent(dragEvent);
                return true;
            }
            long jDr = dr(dragEvent.getX(), dragEvent.getY());
            this.by.ai = getText().x().o((int) (jDr >> 32), (int) (jDr & 4294967295L));
            postInvalidate();
            this.by.bc(null, dragEvent.getX(), dragEvent.getY());
        }
        return true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        asn asnVar = this.co;
        asnVar.getClass();
        int iSave = canvas.save();
        canvas.translate(asnVar.r.getOffsetX(), asnVar.r.getOffsetY());
        asnVar.ai = true;
        try {
            asnVar.bb(canvas);
            asnVar.ai = false;
            canvas.restoreToCount(iSave);
            if (!(this.bb == this.cj.b && this.by.b.b.isFinished()) && this.by.d.b.isShowing()) {
                this.bb = this.cj.b;
                byw bywVar = this.by.d;
                Objects.requireNonNull(bywVar);
                ei(new dh(bywVar, 3));
            }
        } catch (Throwable th) {
            asnVar.ai = false;
            throw th;
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            aia aiaVar = this.cj;
            boolean z2 = aiaVar.e > 0;
            aiaVar.c = z2;
            if (z2) {
                ei(aiaVar);
            }
        } else {
            aia aiaVar2 = this.cj;
            aiaVar2.c = false;
            aiaVar2.b = false;
            asv asvVar = this.by;
            if (asvVar.be()) {
                asvVar.p = 0L;
                asvVar.a.invalidate();
            }
            removeCallbacks(this.cj);
        }
        this.i.g(new arx(this, z));
        invalidate();
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(q.a.s)) {
            if (motionEvent.getAction() == 9) {
                this.ah = true;
            } else if (motionEvent.getAction() == 10) {
                this.ah = false;
            }
            if (motionEvent.getActionMasked() == 11 || motionEvent.getActionMasked() == 12) {
                this.ai = motionEvent.getButtonState() != 0;
            }
            int action = motionEvent.getAction();
            if (action == 7 || action == 9 || action == 10) {
                this.by.at(new aak(0), null, motionEvent);
                return true;
            }
        }
        if (motionEvent.getAction() == 8 && motionEvent.isFromSource(2)) {
            io ioVar = this.a;
            if (!((btm) ioVar.d).c) {
                float f = -motionEvent.getAxisValue(9);
                float f2 = -motionEvent.getAxisValue(10);
                float f3 = this.w;
                float f4 = this.ck.af;
                float f5 = f2 * f3 * f4;
                float f6 = f * f3 * f4;
                if (((btm) ioVar.d).d()) {
                    float f7 = this.ck.z;
                    f5 *= f7;
                    f6 *= f7;
                }
                if (((btm) ioVar.d).e()) {
                    float f8 = f6;
                    f6 = f5;
                    f5 = f8;
                }
                this.by.onScroll(motionEvent, motionEvent, f5, f6);
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int scrollMaxY = getScrollMaxY();
        accessibilityEvent.setScrollable(scrollMaxY > 0);
        accessibilityEvent.setMaxScrollX(getScrollMaxX());
        accessibilityEvent.setMaxScrollY(scrollMaxY);
    }

    /* JADX WARN: Found duplicated region for block: B:102:0x01a9 */
    /* JADX WARN: Found duplicated region for block: B:132:0x0222 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:22:0x007a */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Boolean boolValueOf;
        aff affVar;
        int i2;
        boolean z;
        boolean zOnKeyDown;
        boolean z2;
        int deadChar;
        boolean z3;
        char cCharAt;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        io ioVar = this.a;
        btm btmVar = (btm) ioVar.d;
        CodeEditor codeEditor = btmVar.a;
        Editable editable = btmVar.b;
        btmVar.onKeyDown(codeEditor, editable, keyEvent.getKeyCode(), keyEvent);
        btmVar.c = keyEvent.isCtrlPressed();
        CodeEditor codeEditor2 = (CodeEditor) ioVar.c;
        awy awyVar = codeEditor2.i;
        asb asbVar = new asb(codeEditor2, keyEvent, 2);
        keyEvent.isCtrlPressed();
        btmVar.e();
        btmVar.d();
        btk btkVar = new btk(codeEditor2, keyEvent, 2);
        if ((awyVar.g(asbVar) & 2) != 0) {
            return asbVar.p(false);
        }
        boolean zE = btmVar.e();
        boolean zD = btmVar.d();
        boolean zIsCtrlPressed = keyEvent.isCtrlPressed();
        if (ioVar.al(i, keyEvent) && (awyVar.g(btkVar) & 2) != 0) {
            return btkVar.p(false) || asbVar.p(false);
        }
        if (i != 122 && i != 123) {
            switch (i) {
                case 19:
                case 20:
                case 21:
                case 22:
                    MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
                    break;
            }
        } else {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        }
        asa asaVar = codeEditor2.h;
        ahy cursor = codeEditor2.getCursor();
        aff text = codeEditor2.getText();
        if (i != 4) {
            if (i == 61) {
                if (codeEditor2.dw() && !zD && !zIsCtrlPressed) {
                    if (codeEditor2.getSnippetController().l()) {
                        if (zE) {
                            dik snippetController = codeEditor2.getSnippetController();
                            if (snippetController.d != -1 && (i2 = snippetController.f) > 0) {
                                snippetController.n(i2 - 1);
                            }
                        } else {
                            dik snippetController2 = codeEditor2.getSnippetController();
                            if (snippetController2.d != -1) {
                                int i3 = snippetController2.f;
                                ArrayList arrayList = snippetController2.e;
                                throwIfVar1IsNull(arrayList);
                                if (i3 < arrayList.size() - 1) {
                                    snippetController2.n(snippetController2.f + 1);
                                }
                            }
                        }
                    } else if (zE) {
                        ahy cursor2 = codeEditor2.getCursor();
                        aff text2 = codeEditor2.getText();
                        int tabWidth = codeEditor2.getTabWidth();
                        btq editorLanguage = codeEditor2.getEditorLanguage();
                        int tabWidth2 = codeEditor2.getTabWidth();
                        int tabWidth3 = codeEditor2.getTabWidth();
                        editorLanguage.getClass();
                        String strN = cna.n(tabWidth2, tabWidth3, false);
                        text2.l();
                        int i4 = cursor2.c.b;
                        while (i4 <= cursor2.d.b) {
                            long jM = cna.m(text2.aa(i4));
                            int i5 = (int) (jM >> 32);
                            int i6 = (int) (jM & 4294967295L);
                            int i7 = (i6 * tabWidth) + i5;
                            if (i7 == 0) {
                                affVar = text2;
                            } else {
                                int i8 = i5 + i6;
                                int i9 = i7 % tabWidth;
                                if (i5 <= 0 || i6 <= 0) {
                                    affVar = text2;
                                    if (i9 == 0) {
                                        affVar.r(i4, i8 - (i6 > 0 ? 1 : tabWidth), i4, i8);
                                    } else {
                                        affVar.r(i4, i8 - i9, i4, i8);
                                    }
                                } else {
                                    if (i9 == 0) {
                                        i9 = tabWidth;
                                    }
                                    aff affVar2 = text2;
                                    affVar2.ah(i4, 0, dnr.bm(Math.abs(i7 - i9) / tabWidth, strN), i4, i8);
                                    affVar = affVar2;
                                }
                            }
                            i4++;
                            text2 = affVar;
                        }
                        text2.u();
                    } else {
                        ahy cursor3 = codeEditor2.getCursor();
                        if (cursor3.h()) {
                            codeEditor2.dv(true);
                        } else {
                            ud udVarD = cursor3.c.d();
                            long jM2 = cna.m(codeEditor2.getText().y(udVarD.b));
                            if (udVarD.c <= ((int) (jM2 >> 32)) + ((int) (jM2 & 4294967295L))) {
                                codeEditor2.dv(false);
                            } else if (codeEditor2.h != null && codeEditor2.dw()) {
                                asa asaVar2 = codeEditor2.h;
                                btq editorLanguage2 = codeEditor2.getEditorLanguage();
                                int tabWidth4 = codeEditor2.getTabWidth();
                                int tabWidth5 = codeEditor2.getTabWidth();
                                editorLanguage2.getClass();
                                asaVar2.e(cna.n(tabWidth4, tabWidth5, false));
                            }
                        }
                    }
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 62) {
                if (codeEditor2.dw()) {
                    codeEditor2.de(" ", true);
                    codeEditor2.ee();
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 66) {
                boolean z8 = true;
                ahy cursor4 = codeEditor2.getCursor();
                aff text3 = codeEditor2.getText();
                if (codeEditor2.dw()) {
                    String str = codeEditor2.getLineSeparator().f;
                    btq editorLanguage3 = codeEditor2.getEditorLanguage();
                    if (zE && !zD && !zIsCtrlPressed) {
                        boolValueOf = Boolean.valueOf(io.h(codeEditor2, cursor4, text3, asbVar, btkVar));
                    } else if (!zIsCtrlPressed || zE) {
                        GifEncoder[] gifEncoderVarArrB = editorLanguage3.b();
                        if (gifEncoderVarArrB == null || cursor4.h()) {
                            z = true;
                            codeEditor2.de(str, true);
                        } else {
                            int length = gifEncoderVarArrB.length;
                            int i10 = 0;
                            while (true) {
                                if (i10 >= length) {
                                    z = z8;
                                } else {
                                    GifEncoder gifEncoderVar = gifEncoderVarArrB[i10];
                                    if (gifEncoderVar != null) {
                                        ud udVarD2 = cursor4.c.d();
                                        dnv styles = codeEditor2.getStyles();
                                        afo afoVarY = text3.y(udVarD2.b);
                                        if (bhs.m(styles, udVarD2)) {
                                            continue;
                                        } else {
                                            int i11 = udVarD2.c;
                                            while (i11 > 0 && Character.isWhitespace(afoVarY.charAt(i11 - 1))) {
                                                i11--;
                                            }
                                            if (afoVarY.subSequence(Math.max(0, i11 - 1), i11).toString().equals("{")) {
                                                int i12 = udVarD2.c;
                                                while (i12 < afoVarY.b && Character.isWhitespace(afoVarY.charAt(i12))) {
                                                    i12++;
                                                }
                                                if (afoVarY.subSequence(i12, Math.min(i12 + 1, afoVarY.b)).toString()
                                                        .equals("}")) {
                                                    try {
                                                        ud udVarD3 = cursor4.c.d();
                                                        codeEditor2.getStyles();
                                                        pe peVarF = gifEncoderVar.f(text3, udVarD3, codeEditor2.getTabWidth());
                                                        codeEditor2.de(peVarF.a, false);
                                                        int i13 = peVarF.b;
                                                        if (i13 != 0) {
                                                            ud udVarN = cursor4.b.n(Math.max(cursor4.c.a - i13, 0));
                                                            codeEditor2.ep(udVarN.b, udVarN.c);
                                                        }
                                                        z = true;
                                                    } catch (Exception e) {
                                                        Log.w("EditorKeyEventHandler",
                                                                "Error occurred while calling Language's NewlineHandler",
                                                                e);
                                                        z = true;
                                                        codeEditor2.de(str, z);
                                                    }
                                                }
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                    i10++;
                                    z8 = true;
                                }
                                codeEditor2.de(str, z);
                            }
                        }
                        codeEditor2.ee();
                    } else if (zD) {
                        int i14 = cursor4.c.d().b;
                        if (i14 == 0) {
                            text3.ab(0, 0, str);
                            codeEditor2.ep(0, 0);
                            codeEditor2.dn();
                            boolValueOf = Boolean.valueOf(btkVar.p(true) || asbVar.p(true));
                        } else {
                            int i15 = i14 - 1;
                            codeEditor2.ep(i15, text3.y(i15).b);
                            boolValueOf = Boolean.valueOf(io.h(codeEditor2, cursor4, text3, asbVar, btkVar));
                        }
                    } else {
                        ud udVarD4 = cursor4.c.d().d();
                        codeEditor2.de(str, true);
                        codeEditor2.ep(udVarD4.b, udVarD4.c);
                        codeEditor2.dn();
                        boolValueOf = Boolean.valueOf(btkVar.p(true) || asbVar.p(true));
                    }
                } else {
                    z = true;
                }
                boolValueOf = Boolean.valueOf(asbVar.p(z));
            } else if (i == 67) {
                if (codeEditor2.dw()) {
                    if (!codeEditor2.bo.h() && zIsCtrlPressed) {
                        codeEditor2.m10do(dfs.e);
                        if (codeEditor2.bo.h()) {
                            codeEditor2.dj();
                        }
                    } else {
                        codeEditor2.dj();
                    }
                    codeEditor2.ee();
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 92) {
                if (zIsCtrlPressed) {
                    codeEditor2.ec(dfs.i, zE);
                } else {
                    codeEditor2.ec(dfs.g, zE);
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 93) {
                if (zIsCtrlPressed) {
                    codeEditor2.ec(dfs.j, zE);
                } else {
                    codeEditor2.ec(dfs.h, zE);
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 111) {
                if (cursor.h()) {
                    ud udVarD5 = codeEditor2.getProps().s ? cursor.d.d() : cursor.c.d();
                    codeEditor2.eq(udVarD5.b, udVarD5.c, 0, true);
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 112) {
                if (codeEditor2.dw()) {
                    if (codeEditor2.bo.h()) {
                        codeEditor2.dj();
                    } else if (zIsCtrlPressed) {
                        codeEditor2.m10do(dfs.f);
                        if (codeEditor2.bo.h()) {
                            codeEditor2.dj();
                        }
                    } else {
                        asaVar.deleteSurroundingText(0, 1);
                    }
                    codeEditor2.ee();
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 122) {
                if (zIsCtrlPressed) {
                    codeEditor2.ec(dfs.m, zE);
                } else {
                    codeEditor2.ec(codeEditor2.getProps().ag ? dfs.o : dfs.k, zE);
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 123) {
                if (zIsCtrlPressed) {
                    codeEditor2.ec(dfs.n, zE);
                } else {
                    codeEditor2.ec(codeEditor2.getProps().ag ? dfs.p : dfs.l, zE);
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i == 278) {
                codeEditor2.df(true);
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            } else if (i != 279) {
                switch (i) {
                    case 19:
                        if (!zIsCtrlPressed) {
                            codeEditor2.ec(dfs.a, zE);
                            boolValueOf = Boolean.valueOf(asbVar.p(true));
                        } else if (!zE) {
                            codeEditor2.getEventHandler().bb(0.0f, -codeEditor2.getRowHeight(), false);
                            boolValueOf = Boolean.valueOf(asbVar.p(true));
                        } else {
                            ud udVarD6 = cursor.c.d();
                            ud udVarD7 = cursor.d.d();
                            int i16 = udVarD6.b;
                            if (i16 != 0) {
                                String string = text.y(i16 - 1).toString();
                                text.l();
                                int i17 = udVarD6.b;
                                text.r(i17 - 1, 0, i17, 0);
                                int i18 = udVarD7.b - 1;
                                text.ab(i18, text.y(i18).b, codeEditor2.getLineSeparator().f.concat(string));
                                text.u();
                                ud udVarO = text.x().o(udVarD6.b - 1, udVarD6.c);
                                ud udVarO2 = text.x().o(udVarD7.b - 1, udVarD7.c);
                                if (udVarD6.a != udVarD7.a) {
                                    ud udVar = codeEditor2.g;
                                    codeEditor2.er(udVarO.b, udVarO.c, udVarO2.b, udVarO2.c);
                                    if (udVar != null) {
                                        if (udVar.equals(udVarD6)) {
                                            codeEditor2.g = udVarO;
                                        } else {
                                            codeEditor2.g = udVarO2;
                                        }
                                    }
                                } else {
                                    codeEditor2.ep(udVarO.b, udVarO.c);
                                }
                                boolValueOf = Boolean.valueOf(asbVar.p(true));
                            } else {
                                boolValueOf = Boolean.valueOf(asbVar.p(true));
                            }
                        }
                        break;
                    case 20:
                        if (!zIsCtrlPressed) {
                            codeEditor2.ec(dfs.b, zE);
                            boolValueOf = Boolean.valueOf(asbVar.p(true));
                        } else if (!zE) {
                            codeEditor2.getEventHandler().bb(0.0f, codeEditor2.getRowHeight(), false);
                            boolValueOf = Boolean.valueOf(asbVar.p(true));
                        } else {
                            ud udVarD8 = cursor.c.d();
                            ud udVarD9 = cursor.d.d();
                            int size = text.a.size();
                            int i19 = udVarD9.b;
                            if (i19 != size - 1) {
                                String string2 = text.y(i19 + 1).toString();
                                text.l();
                                int i20 = udVarD9.b;
                                text.r(i20, text.y(i20).b, udVarD9.b + 1, string2.length());
                                text.ab(udVarD8.b, 0, string2.concat(codeEditor2.getLineSeparator().f));
                                text.u();
                                ud udVarO3 = text.x().o(udVarD8.b + 1, udVarD8.c);
                                ud udVarO4 = text.x().o(udVarD9.b + 1, udVarD9.c);
                                if (udVarD8.a != udVarD9.a) {
                                    ud udVar2 = codeEditor2.g;
                                    codeEditor2.er(udVarO3.b, udVarO3.c, udVarO4.b, udVarO4.c);
                                    if (udVar2 != null) {
                                        if (udVar2.equals(udVarD8)) {
                                            codeEditor2.g = udVarO3;
                                        } else {
                                            codeEditor2.g = udVarO4;
                                        }
                                    }
                                } else {
                                    codeEditor2.ep(udVarO3.b, udVarO3.c);
                                }
                                boolValueOf = Boolean.valueOf(asbVar.p(true));
                            } else {
                                boolValueOf = Boolean.valueOf(asbVar.p(true));
                            }
                        }
                        break;
                    case 21:
                        if (zIsCtrlPressed) {
                            codeEditor2.ec(dfs.e, zE);
                        } else {
                            codeEditor2.ec(dfs.c, zE);
                        }
                        boolValueOf = Boolean.valueOf(asbVar.p(true));
                        break;
                    case 22:
                        if (zIsCtrlPressed) {
                            codeEditor2.ec(dfs.f, zE);
                        } else {
                            codeEditor2.ec(dfs.d, zE);
                        }
                        boolValueOf = Boolean.valueOf(asbVar.p(true));
                        break;
                    default:
                        if (keyEvent.isCtrlPressed() && !keyEvent.isAltPressed()) {
                            asa asaVar3 = codeEditor2.h;
                            aff text4 = codeEditor2.getText();
                            ahy cursor5 = codeEditor2.getCursor();
                            if (i == 29) {
                                z4 = false;
                                z5 = true;
                                codeEditor2.em();
                            } else if (i == 38) {
                                z4 = false;
                                z5 = true;
                                if (!zE || cursor5.h()) {
                                    z6 = false;
                                } else {
                                    int i21 = cursor5.c.b;
                                    codeEditor2.ep(i21, text4.y(i21).b);
                                    asaVar3.deleteSurroundingText(0, 1);
                                    codeEditor2.dn();
                                }
                                boolValueOf = Boolean.valueOf((!btkVar.p(z6) || asbVar.p(z6)) ? z5 : z4);
                            } else {
                                if (i != 31) {
                                    if (i != 32) {
                                        switch (i) {
                                            case 50:
                                                if (codeEditor2.dw()) {
                                                    codeEditor2.eg();
                                                }
                                                break;
                                            case 51:
                                                ud udVarD10 = codeEditor2.getCursor().c.d();
                                                codeEditor2.en(udVarD10.b, udVarD10.c);
                                                break;
                                            case 52:
                                                if (!codeEditor2.dw()) {
                                                    codeEditor2.df(true);
                                                    z5 = true;
                                                    z4 = false;
                                                } else {
                                                    codeEditor2.di();
                                                }
                                                break;
                                            case 53:
                                                if (codeEditor2.dw()) {
                                                    codeEditor2.ej();
                                                }
                                                break;
                                            case 54:
                                                if (codeEditor2.dw()) {
                                                    codeEditor2.eu();
                                                }
                                                break;
                                            default:
                                                boolValueOf = null;
                                                break;
                                        }
                                    } else if (codeEditor2.dw()) {
                                        ahy cursor6 = codeEditor2.getCursor();
                                        if (cursor6.h()) {
                                            z7 = true;
                                            codeEditor2.dk("", true);
                                            z4 = false;
                                        } else {
                                            z7 = true;
                                            ud udVarD11 = cursor6.c.d();
                                            int i22 = udVarD11.b;
                                            z4 = false;
                                            codeEditor2.es(i22, true, 0, i22, codeEditor2.getText().y(udVarD11.b).b, 0);
                                            codeEditor2.dk("\n", false);
                                        }
                                    }
                                    z4 = false;
                                    z5 = true;
                                } else {
                                    z7 = true;
                                    z4 = false;
                                    codeEditor2.df(true);
                                }
                                z5 = z7;
                            }
                            z6 = z5;
                            boolValueOf = Boolean.valueOf((!btkVar.p(z6) || asbVar.p(z6)) ? z5 : z4);
                        } else {
                            aff text5 = codeEditor2.getText();
                            ahy cursor7 = codeEditor2.getCursor();
                            int unicodeChar = keyEvent
                                    .getUnicodeChar(MetaKeyKeyListener.getMetaState(editable, keyEvent));
                            if (unicodeChar == 0 || !codeEditor2.dw() || unicodeChar == 61184 || unicodeChar == 61185) {
                                zOnKeyDown = super.onKeyDown(i, keyEvent);
                            } else {
                                if ((Integer.MIN_VALUE & unicodeChar) != 0) {
                                    unicodeChar &= Integer.MAX_VALUE;
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                int i23 = cursor7.c.a;
                                if (i23 + 1 == cursor7.d.a && (deadChar = KeyCharacterMap
                                        .getDeadChar((cCharAt = text5.charAt(i23)), unicodeChar)) != cCharAt
                                        && keyEvent.getRepeatCount() == 0) {
                                    z3 = false;
                                } else {
                                    deadChar = unicodeChar;
                                    z3 = z2;
                                }
                                if (z3) {
                                    ahy cursor8 = codeEditor2.getCursor();
                                    if (codeEditor2.bo.h()) {
                                        int i24 = cursor7.c.a;
                                        if (i24 + 1 == cursor7.d.a && text5.charAt(i24) == deadChar) {
                                            ud udVar3 = cursor7.d;
                                            codeEditor2.eq(udVar3.b, udVar3.c, 9, true);
                                            codeEditor2.de(String.valueOf(Character.toChars(deadChar)), true);
                                            int iCharCount = Character.charCount(Character.codePointBefore(
                                                    codeEditor2.getText().y(cursor8.d.b), cursor8.d.c));
                                            CodeEditor codeEditor3 = (CodeEditor) ioVar.c;
                                            ud udVar4 = cursor8.d;
                                            int i25 = udVar4.b;
                                            int i26 = udVar4.c;
                                            codeEditor3.es(i25, true, i26 - iCharCount, i25, i26, 9);
                                        }
                                    } else {
                                        ud udVar32 = cursor7.d;
                                        codeEditor2.eq(udVar32.b, udVar32.c, 9, true);
                                        codeEditor2.de(String.valueOf(Character.toChars(deadChar)), true);
                                        int iCharCount2 = Character.charCount(Character
                                                .codePointBefore(codeEditor2.getText().y(cursor8.d.b), cursor8.d.c));
                                        CodeEditor codeEditor32 = (CodeEditor) ioVar.c;
                                        ud udVar42 = cursor8.d;
                                        int i252 = udVar42.b;
                                        int i262 = udVar42.c;
                                        codeEditor32.es(i252, true, i262 - iCharCount2, i252, i262, 9);
                                    }
                                } else {
                                    codeEditor2.de(new String(Character.toChars(deadChar)), true);
                                    codeEditor2.ee();
                                }
                                zOnKeyDown = true;
                            }
                            if (zOnKeyDown) {
                                MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
                            }
                            boolValueOf = Boolean.valueOf(asbVar.p(zOnKeyDown));
                        }
                        break;
                }
            } else {
                if (codeEditor2.dw()) {
                    codeEditor2.eg();
                }
                boolValueOf = Boolean.valueOf(asbVar.p(true));
            }
        } else if (cursor.h()) {
            ud udVar5 = cursor.c;
            codeEditor2.ep(udVar5.b, udVar5.c);
            boolValueOf = Boolean.valueOf(asbVar.p(true));
        } else if (codeEditor2.be) {
            codeEditor2.be = false;
            boolValueOf = Boolean.valueOf(asbVar.p(true));
        } else {
            boolValueOf = Boolean.valueOf(asbVar.p(false));
        }
        return boolValueOf != null ? asbVar.p(boolValueOf.booleanValue()) : asbVar.p(super.onKeyDown(i, keyEvent));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        CodeEditor codeEditor = (CodeEditor) this.a.c;
        asb asbVar = new asb(codeEditor, keyEvent, 3);
        return (codeEditor.i.g(asbVar) & 2) != 0 ? asbVar.p(false) : asbVar.p(super.onKeyMultiple(i, i2, keyEvent));
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        io ioVar = this.a;
        btm btmVar = (btm) ioVar.d;
        btmVar.onKeyUp(btmVar.a, btmVar.b, keyEvent.getKeyCode(), keyEvent);
        btmVar.c = keyEvent.isCtrlPressed();
        CodeEditor codeEditor = (CodeEditor) ioVar.c;
        awy awyVar = codeEditor.i;
        codeEditor.getCursor();
        asb asbVar = new asb(codeEditor, keyEvent, 1);
        if ((awyVar.g(asbVar) & 2) != 0) {
            return asbVar.p(false);
        }
        if (ioVar.al(i, keyEvent)) {
            keyEvent.isCtrlPressed();
            btmVar.e();
            btmVar.d();
            btk btkVar = new btk(codeEditor, keyEvent, 1);
            if ((awyVar.g(btkVar) & 2) != 0) {
                return btkVar.p(false) || asbVar.p(false);
            }
        }
        return asbVar.p(super.onKeyUp(i, keyEvent));
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        boolean z;
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int i3;
        int i4;
        int iMakeMeasureSpec3;
        int i5;
        int i6 = 0;
        if (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) {
            this.bf = false;
            i3 = i;
            i4 = i2;
        } else {
            Log.w("CodeEditor", "use wrap_content in editor may cause layout lags");
            float fEb = eb();
            float rowHeight = getRowHeight();
            boolean z2 = this.af;
            int i7 = this.k;
            aff affVar = this.bp;
            final csk cskVar = this.co.d;
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = mode == 0 ? 1073741823 : View.MeasureSpec.getSize(i);
            int size2 = mode2 != 0 ? View.MeasureSpec.getSize(i2) : 1073741823;
            final dhs dhsVar = new dhs(i7);
            boolean z3 = true;
            if (!z2) {
                z = true;
                if (mode != 1073741824) {
                    final chr chrVar = new chr(0);
                    affVar.aj(affVar.a.size() - 1, new afe() { // from class: me.hd.wauxv.obf.erj
                        @Override // me.hd.wauxv.obf.afe
                        public final void a(int i8, afo afoVar, anu anuVar) {
                            int iCeil = (int) Math.ceil(dhsVar.h(afoVar.a, afoVar.b, cskVar));
                            chr chrVar2 = chrVar;
                            if (iCeil > chrVar2.a) {
                                chrVar2.a = iCeil;
                            }
                        }
                    });
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) Math.min(chrVar.a + fEb, size),
                            1073741824);
                } else {
                    iMakeMeasureSpec = i;
                }
                iMakeMeasureSpec2 = mode2 != 1073741824
                        ? View.MeasureSpec.makeMeasureSpec(Math.min(size2, (int) (rowHeight * affVar.a.size())),
                                1073741824)
                        : i2;
            } else if (mode != 1073741824) {
                final int[] iArr = mode2 != 1073741824 ? new int[affVar.a.size()] : null;
                final chr chrVar2 = new chr(0);
                affVar.aj(affVar.a.size() - 1, new afe() { // from class: me.hd.wauxv.obf.erh
                    @Override // me.hd.wauxv.obf.afe
                    public final void a(int i8, afo afoVar, anu anuVar) {
                        int iCeil = (int) Math.ceil(dhsVar.h(afoVar.a, afoVar.b, cskVar));
                        chr chrVar3 = chrVar2;
                        if (iCeil > chrVar3.a) {
                            chrVar3.a = iCeil;
                        }
                        int[] iArr2 = iArr;
                        if (iArr2 != null) {
                            iArr2[i8] = iCeil;
                        }
                    }
                });
                int iMin = (int) Math.min(size, chrVar2.a + fEb);
                int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
                if (iArr != null) {
                    int i8 = (int) (iMin - fEb);
                    if (i8 <= 0) {
                        i5 = affVar.d;
                    } else {
                        int iMax = 0;
                        while (i6 < iArr.length) {
                            iMax = (int) (Math.max(1.0d, Math.ceil((((double) iArr[i6]) * 1.0d) / ((double) i8)))
                                    + ((double) iMax));
                            i6++;
                            z3 = z3;
                        }
                        i5 = iMax;
                    }
                    z = z3;
                    iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(Math.min((int) (rowHeight * i5), size2),
                            1073741824);
                } else {
                    z = true;
                    iMakeMeasureSpec3 = i2;
                }
                iMakeMeasureSpec2 = iMakeMeasureSpec3;
                iMakeMeasureSpec = iMakeMeasureSpec4;
            } else {
                z = true;
                if (mode2 != 1073741824) {
                    final chr chrVar3 = new chr(0);
                    final int i9 = (int) (size - fEb);
                    if (i9 <= 0) {
                        chrVar3.a = affVar.d;
                    } else {
                        affVar.aj(affVar.a.size() - 1, new afe() { // from class: me.hd.wauxv.obf.eri
                            @Override // me.hd.wauxv.obf.afe
                            public final void a(int i10, afo afoVar, anu anuVar) {
                                int iCeil = (int) Math.ceil(dhsVar.h(afoVar.a, afoVar.b, cskVar));
                                chr chrVar4 = chrVar3;
                                chrVar4.a = (int) (Math.max(1.0d, Math.ceil((((double) iCeil) * 1.0d) / ((double) i9)))
                                        + ((double) chrVar4.a));
                            }
                        });
                    }
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.min((int) (rowHeight * chrVar3.a), size2),
                            1073741824);
                    iMakeMeasureSpec = i;
                } else {
                    iMakeMeasureSpec = i;
                }
            }
            long jAl = KotlinHelpers.al(iMakeMeasureSpec, iMakeMeasureSpec2);
            i3 = (int) (jAl >> 32);
            i4 = (int) (jAl & 4294967295L);
            this.bf = z;
        }
        super.onMeasure(i3, i4);
    }

    @Override // android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        int i2;
        if (!motionEvent.isFromSource(q.a.s)) {
            return super.onResolvePointerIcon(motionEvent, i);
        }
        dx();
        if (this.ak) {
            return PointerIcon.getSystemIcon(getContext(), 1004);
        }
        if (this.by.ay()) {
            return PointerIcon.getSystemIcon(getContext(), 1021);
        }
        if (getLeftHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY())
                || getRightHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY())
                || getInsertHandleDescriptor().a.contains(motionEvent.getX(), motionEvent.getY())) {
            return PointerIcon.getSystemIcon(getContext(), 1020);
        }
        long jAf = ajn.af(this, motionEvent, i);
        int i3 = (int) (jAf >> 32);
        boolean z = ((int) (jAf & 4294967295L)) == 0;
        if (i3 != 5 || !z) {
            return (i3 == 1 && ((i2 = this.ck.u) == 1 || i2 == 2)) ? PointerIcon.getSystemIcon(getContext(), 1002)
                    : super.onResolvePointerIcon(motionEvent, i);
        }
        asv asvVar = this.by;
        if (asvVar.ah && !asvVar.ag) {
            return PointerIcon.getSystemIcon(getContext(), 1021);
        }
        this.co.getClass();
        return PointerIcon.getSystemIcon(getContext(), 1008);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = this.co.f;
        rect.right = i;
        rect.bottom = i2;
        getVerticalEdgeEffect().setSize(i, i2);
        getHorizontalEdgeEffect().setSize(i2, i);
        getVerticalEdgeEffect().finish();
        getHorizontalEdgeEffect().finish();
        if (this.j == null || (this.af && i != i3)) {
            dh(true);
        } else {
            this.by.bb(getOffsetX() > getScrollMaxX() ? getScrollMaxX() - getOffsetX() : 0.0f,
                    getOffsetY() > getScrollMaxY() ? getScrollMaxY() - getOffsetY() : 0.0f, false);
        }
        this.cs = false;
        this.ct = false;
        if (i4 <= i2 || !this.ck.k) {
            return;
        }
        dn();
    }

    /* JADX WARN: Found duplicated region for block: B:110:0x0261 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        if (isEnabled()) {
            if (motionEvent.isFromSource(q.a.s)) {
                this.ck.getClass();
                asv asvVar = this.by;
                int i2 = asvVar.y;
                CodeEditor codeEditor = asvVar.a;
                codeEditor.dx();
                if (asvVar.r || asvVar.q) {
                    return asvVar.az(motionEvent);
                }
                asvVar.af = null;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    asvVar.aa = motionEvent.getX();
                    asvVar.ab = motionEvent.getY();
                    int buttonState = motionEvent.getButtonState();
                    asvVar.ac = buttonState;
                    asvVar.ag = true;
                    if ((buttonState & 1) != 0) {
                        if (asvVar.az(motionEvent) && (asvVar.r || asvVar.q)) {
                            return true;
                        }
                        if (SystemClock.uptimeMillis() - asvVar.ad < ViewConfiguration.getDoubleTapTimeout()) {
                            asvVar.ae = true;
                            asvVar.onDoubleTap(motionEvent);
                            return true;
                        }
                        long jDr = codeEditor.dr(asvVar.aa, asvVar.ab);
                        int i3 = (int) (jDr >> 32);
                        int i4 = (int) (jDr & 4294967295L);
                        ud udVarO = codeEditor.getText().x().o(i3, i4);
                        if (codeEditor.bo.h()) {
                            dqs cursorRange = codeEditor.getCursorRange();
                            cursorRange.getClass();
                            int i5 = udVarO.a;
                            if (i5 < cursorRange.a.a || i5 >= cursorRange.b.a || !codeEditor.dz(asvVar.aa, asvVar.ab)) {
                                asvVar.ah = false;
                                codeEditor.eq(i3, i4, 8, true);
                                codeEditor.requestFocus();
                            } else {
                                asvVar.ah = true;
                            }
                        } else {
                            asvVar.ah = false;
                            codeEditor.eq(i3, i4, 8, true);
                            codeEditor.requestFocus();
                        }
                        asvVar.ai = udVarO;
                        codeEditor.postInvalidate();
                        return true;
                    }
                } else {
                    if (actionMasked == 1) {
                        if (motionEvent.getEventTime() - motionEvent.getDownTime() > ViewConfiguration.getTapTimeout()
                                * 2.0f) {
                            asvVar.ag = false;
                        }
                        if (!asvVar.ae) {
                            if (asvVar.ah && !asvVar.ag && (asvVar.ac & 1) != 0) {
                                long jDr2 = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
                                ud udVarO2 = codeEditor.getText().x().o((int) (jDr2 >> 32), (int) (jDr2 & 4294967295L));
                                dqs cursorRange2 = codeEditor.getCursorRange();
                                cursorRange2.getClass();
                                ud udVar = cursorRange2.b;
                                int i6 = udVarO2.a;
                                ud udVar2 = cursorRange2.a;
                                if (!(i6 >= udVar2.a && i6 < udVar.a)
                                        && (codeEditor.getKeyMetaStates().c || !udVar.equals(udVarO2))) {
                                    int i7 = udVar.a - udVar2.a;
                                    if (codeEditor.getKeyMetaStates().c) {
                                        i = udVarO2.a;
                                    } else {
                                        i = udVarO2.a;
                                        if (i >= udVar2.a) {
                                            i -= i7;
                                        }
                                    }
                                    aff text = codeEditor.getText();
                                    String strAn = text.an(udVar2.a, udVar.a);
                                    if (codeEditor.getKeyMetaStates().c) {
                                        text.ab(udVarO2.b, udVarO2.c, strAn);
                                    } else {
                                        text.l();
                                        codeEditor.dj();
                                        udVarO2 = text.x().n(i);
                                        text.ab(udVarO2.b, udVarO2.c, strAn);
                                        text.u();
                                    }
                                    ud udVarN = text.x().n(i + i7);
                                    codeEditor.es(udVarO2.b, true, udVarO2.c, udVarN.b, udVarN.c, 8);
                                }
                            }
                            if (asvVar.ag) {
                                int i8 = asvVar.ac;
                                if ((i8 & 1) != 0) {
                                    asvVar.onSingleTapUp(motionEvent);
                                    asvVar.ad = motionEvent.getEventTime();
                                } else if ((i8 & 2) != 0) {
                                    asvVar.af = new PointF(motionEvent.getX(), motionEvent.getY());
                                    if ((asvVar.at(new aak(4), null, motionEvent) & 2) == 0) {
                                        codeEditor.performContextClick(motionEvent.getX(), motionEvent.getY());
                                        if (codeEditor.getProps().ad) {
                                            codeEditor.showContextMenu(motionEvent.getX(), motionEvent.getY());
                                        }
                                    }
                                }
                            }
                        }
                        asvVar.ba();
                        asvVar.x = 0;
                        return true;
                    }
                    if (actionMasked != 2) {
                        if (actionMasked == 3) {
                            asvVar.ba();
                            asvVar.x = 0;
                            return true;
                        }
                    } else if (!asvVar.ae) {
                        float f = i2;
                        if (Math.abs(motionEvent.getX() - asvVar.aa) > f
                                || Math.abs(motionEvent.getY() - asvVar.ab) > f) {
                            asvVar.ag = false;
                        }
                        if ((asvVar.ac & 1) != 0) {
                            long jDr3 = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
                            int i9 = (int) (jDr3 >> 32);
                            int i10 = (int) (jDr3 & 4294967295L);
                            ud udVarO3 = codeEditor.getText().x().o(i9, i10);
                            if (!asvVar.ag && !asvVar.ah) {
                                ud udVar3 = codeEditor.g;
                                codeEditor.es(udVar3.b, true, udVar3.c, i9, i10, 8);
                            }
                            asvVar.ai = udVarO3;
                            codeEditor.postInvalidate();
                            asvVar.bd(motionEvent);
                            return true;
                        }
                    }
                }
            } else {
                dx();
                asv asvVar2 = this.by;
                boolean z = asvVar2.r || asvVar2.q || asvVar2.ay();
                boolean zAz = this.by.az(motionEvent);
                asv asvVar3 = this.by;
                boolean z2 = asvVar3.r || asvVar3.q || asvVar3.ay();
                boolean zOnTouchEvent = this.cb.onTouchEvent(motionEvent);
                boolean zOnTouchEvent2 = (z2 || z) ? false : this.ca.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    this.cd.onRelease();
                    this.ce.onRelease();
                }
                if (zOnTouchEvent || zOnTouchEvent2 || zAz) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (i == 4096) {
            ed(dfs.g);
            return true;
        }
        if (i == 8192) {
            ed(dfs.h);
            return true;
        }
        if (i == 16384) {
            df(true);
            return true;
        }
        if (i == 32768) {
            eg();
            return true;
        }
        if (i == 65536) {
            di();
            return true;
        }
        if (i == 2097152) {
            setText(bundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"));
            return true;
        }
        if (i == 16908344) {
            ed(dfs.h);
            return true;
        }
        if (i != 16908346) {
            return super.performAccessibilityAction(i, bundle);
        }
        ed(dfs.g);
        return true;
    }

    @Override // android.view.View
    public final boolean removeCallbacks(Runnable runnable) {
        arz.a.removeCallbacks(runnable);
        return super.removeCallbacks(runnable);
    }

    public void setBlockLineEnabled(boolean z) {
        this.ar = z;
        invalidate();
    }

    public void setBlockLineWidth(float f) {
        this.u = f;
        invalidate();
    }

    public void setColorScheme(arq arqVar) {
        arq arqVar2 = this.br;
        if (arqVar2 != null) {
            Iterator it = arqVar2.c.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == this) {
                    it.remove();
                    break;
                }
            }
        }
        this.br = arqVar;
        arqVar.d(this);
        invalidate();
    }

    public void setCursorAnimationEnabled(boolean z) {
        if (!z) {
            ((cfg) this.ch).l();
        }
        this.ax = z;
    }

    public void setCursorAnimator(ahz ahzVar) {
        this.ch = ahzVar;
    }

    public void setCursorBlinkPeriod(int i) {
        aia aiaVar = this.cj;
        if (aiaVar == null) {
            this.cj = new aia(this, i);
            return;
        }
        int i2 = aiaVar.e;
        aiaVar.e = i;
        if (i <= 0) {
            aiaVar.b = true;
            aiaVar.c = false;
        } else {
            aiaVar.c = true;
        }
        if (i2 <= 0 && aiaVar.c && isAttachedToWindow()) {
            ei(this.cj);
        }
    }

    public void setCursorWidth(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("width can not be under zero");
        }
        this.t = f;
        invalidate();
    }

    public void setDiagnosticIndicatorStyle(amu amuVar) {
        this.bv = amuVar;
        invalidate();
    }

    public void setDiagnostics(amv amvVar) {
        invalidate();
    }

    public void setDisableSoftKbdIfHardKbdAvailable(boolean z) {
        if (this.bi == z) {
            return;
        }
        this.bi = z;
        this.bn.hideSoftInputFromWindow(getWindowToken(), 0);
        el();
    }

    public void setDisplayLnPanel(boolean z) {
        this.al = z;
        invalidate();
    }

    public void setDividerMargin(float f) {
        eo(f, f);
    }

    public void setDividerWidth(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("width can not be under zero");
        }
        this.q = f;
        ek();
        invalidate();
    }

    public void setEdgeEffectColor(int i) {
        this.cd.setColor(i);
        this.ce.setColor(i);
    }

    public void setEditable(boolean z) {
        this.ae = z;
        if (z) {
            return;
        }
        this.bn.hideSoftInputFromWindow(getWindowToken(), 0);
        this.cv.o();
    }

    public void setEditorLanguage(btq btqVar) {
        if (btqVar == null) {
            btqVar = new avc();
        }
        btq btqVar2 = this.bu;
        if (btqVar2 != null) {
            btqVar2.e().g = null;
            btqVar2.e().k();
            btqVar2.destroy();
        }
        FactoryPools factoryPoolsVar = this.f;
        factoryPoolsVar.f = null;
        factoryPoolsVar.h = null;
        this.bu = btqVar;
        this.cm = null;
        hz hzVarE = btqVar.e();
        hzVarE.g = this.f;
        aff affVar = this.bp;
        if (affVar != null) {
            hzVarE.s(new afq(affVar), this.cl);
        }
        FactoryPools factoryPoolsVar2 = this.b;
        if (factoryPoolsVar2 != null) {
            factoryPoolsVar2.h = null;
        }
        FactoryPools factoryPoolsVarG = this.bu.g();
        this.b = factoryPoolsVarG;
        if (factoryPoolsVarG == null) {
            Log.w("CodeEditor",
                    "Language(" + this.bu.toString() + ") returned null for symbol pairs. It is a mistake.");
            this.b = new FactoryPools(19);
        }
        this.b.h = this.ck.a;
        dik dikVar = this.cv;
        if (dikVar != null) {
            dikVar.o();
        }
        this.cn.c();
        invalidate();
    }

    public void setExtracting(ExtractedTextRequest extractedTextRequest) {
        getProps().getClass();
        this.cf = extractedTextRequest;
    }

    public void setFirstLineNumberAlwaysVisible(boolean z) {
        this.ba = z;
        if (this.af) {
            invalidate();
        }
    }

    public void setFontFeatureSettings(String str) {
        csk cskVar = this.co.d;
        cskVar.setFontFeatureSettings(str);
        cskVar.d();
        this.co.e.setFontFeatureSettings(str);
        this.co.i.setFontFeatureSettings(str);
        this.co.bn();
        invalidate();
    }

    public void setFormatTip(String str) {
        Objects.requireNonNull(str);
        this.bt = str;
    }

    public void setHardwareAcceleratedDrawAllowed(boolean z) {
        this.cp = z;
        if (!z || this.af) {
            return;
        }
        this.cn.c();
    }

    public void setHighlightBracketPair(boolean z) {
        this.bd = z;
        if (z) {
            FactoryPools factoryPoolsVar = this.f;
            factoryPoolsVar.getClass();
            factoryPoolsVar.af(new dh(factoryPoolsVar, 10));
        } else {
            this.f.f = null;
        }
        invalidate();
    }

    public void setHighlightCurrentBlock(boolean z) {
        this.at = z;
        if (z) {
            this.l = dq();
        } else {
            this.l = -1;
        }
        invalidate();
    }

    public void setHighlightCurrentLine(boolean z) {
        this.au = z;
        invalidate();
    }

    public void setHighlightTexts(blp blpVar) {
        new chu();
    }

    public void setHighlightedDelimiterBorderWidth(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("width can not be under zero");
        }
        this.v = f;
        invalidate();
    }

    @Override // android.view.View
    public void setHorizontalScrollBarEnabled(boolean z) {
        this.aw = z;
    }

    @Override // android.view.View
    public void setHorizontalScrollbarThumbDrawable(Drawable drawable) {
        this.co.u = drawable;
    }

    @Override // android.view.View
    public void setHorizontalScrollbarTrackDrawable(Drawable drawable) {
        this.co.v = drawable;
    }

    /*
     * JADX WARN: Found duplicated region for block: B:14:0x0056 A[DONT_INVERT, PHI:
     * r7
     * 0x0056: PHI (r7v2 int) = (r7v1 int), (r7v3 int) binds: [B:6:0x002b,
     * B:13:0x0054] A[DONT_GENERATE, DONT_INLINE]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:15:0x0058 A[LOOP:0:
     * B:5:0x001d->B:15:0x0058, LOOP_END]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:23:0x005b A[EDGE_INSN:
     * B:23:0x005b->B:16:0x005b BREAK A[LOOP:0: B:5:0x001d->B:15:0x0058], SYNTHETIC]
     */
    public void setInlayHints(bpi bpiVar) {
        chu chuVar = new chu();
        SyntheticPileOfMess bmuVar = new SyntheticPileOfMess();
        bmuVar.obj = new int[0];
        int[] iArr = chuVar.b;
        long[] jArr = chuVar.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i3 = 8 - ((~(i - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            ((int[]) bmuVar.obj)[i2] = iArr[(i << 3) + i4];
                            i2++;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        if (this.ak) {
            dh(true);
        } else {
            this.j.p(bmuVar);
        }
        this.cn.c();
    }

    public void setInputType(int i) {
        this.n = i;
        el();
    }

    public void setInterceptParentHorizontalScrollIfNeeded(boolean z) {
        ViewParent parent;
        this.as = z;
        if (z || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(false);
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x0062 */
    public void setLayoutBusy(boolean z) {
        CodeEditor codeEditor;
        if (!this.ak || z) {
            if (this.ak == z) {
                return;
            }
            this.ak = z;
            this.i.g(new rp(this));
            return;
        }
        if (this.af) {
            asv asvVar = this.by;
            if (asvVar.aq) {
                asvVar.aq = false;
                long j = asvVar.ap;
                float rowHeight = getRowHeight() * ((ewa) this.j).ab((int) (j >> 32), (int) (j & 4294967295L));
                asv asvVar2 = this.by;
                float f = rowHeight - asvVar2.ar;
                aso asoVar = asvVar2.b;
                int i = (int) f;
                codeEditor = this;
                codeEditor.i.g(new dfb(this, asoVar.b.getCurrX(), asoVar.b.getCurrY(), 0, i, 5));
                asoVar.d(0, i, 0, 0, 0);
                asoVar.b.abortAnimation();
                asoVar.c();
            } else {
                codeEditor = this;
            }
        } else {
            codeEditor = this;
        }
        codeEditor.ak = false;
        el();
        postInvalidate();
        codeEditor.i.g(new rp(this));
    }

    public void setLigatureEnabled(boolean z) {
        setFontFeatureSettings(z ? null : "'liga' 0,'calt' 0,'hlig' 0,'dlig' 0,'clig' 0");
    }

    public void setLineInfoTextSize(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException();
        }
        this.x = f;
    }

    public void setLineNumberAlign(Paint.Align align) {
        if (align == null) {
            align = Paint.Align.LEFT;
        }
        this.bz = align;
        invalidate();
    }

    public void setLineNumberEnabled(boolean z) {
        if (z != this.aq && this.af) {
            dh(true);
        }
        this.aq = z;
        invalidate();
    }

    public void setLineNumberMarginLeft(float f) {
        this.aa = f;
        ek();
        invalidate();
    }

    public void setLineNumberTipTextProvider(bvc bvcVar) {
        Objects.requireNonNull(bvcVar, "Provider can not be null");
        this.bs = bvcVar;
        invalidate();
    }

    public void setLineSeparator(bvd bvdVar) {
        Objects.requireNonNull(bvdVar);
        if (bvdVar == bvd.NONE) {
            throw new IllegalArgumentException();
        }
        this.cu = bvdVar;
    }

    public void setLineSpacingExtra(float f) {
        this.z = f;
        invalidate();
    }

    public void setLineSpacingMultiplier(float f) {
        this.y = f;
        invalidate();
    }

    public void setLnPanelPosition(int i) {
        this.am = i;
        invalidate();
    }

    public void setLnPanelPositionMode(int i) {
        this.an = i;
        invalidate();
    }

    public void setNonPrintablePaintingFlags(int i) {
        int i2 = this.o;
        this.o = i;
        if ((i2 & 128) != (i & 128)) {
            dh(true);
        }
        invalidate();
    }

    public void setPinLineNumber(boolean z) {
        this.ay = z;
        if (this.aq) {
            invalidate();
        }
    }

    public void setRenderFunctionCharacters(boolean z) {
        if (this.bg != z) {
            this.bg = z;
            this.co.bj();
            ek();
            dh(true);
            invalidate();
        }
    }

    public void setScalable(boolean z) {
        this.ad = z;
    }

    public void setScrollBarEnabled(boolean z) {
        this.aw = z;
        this.av = z;
        invalidate();
    }

    public void setSelectionHandleStyle(dfp dfpVar) {
        Objects.requireNonNull(dfpVar);
        this.ci = dfpVar;
        invalidate();
    }

    public void setSoftKeyboardEnabled(boolean z) {
        if (this.bh == z) {
            return;
        }
        this.bh = z;
        this.bn.hideSoftInputFromWindow(getWindowToken(), 0);
        el();
    }

    public void setStickyTextSelection(boolean z) {
        this.bc = z;
    }

    public void setStyles(dnv dnvVar) {
        this.cm = dnvVar;
        if (this.at) {
            this.l = dq();
        }
        this.cn.c();
        this.co.bn();
        invalidate();
    }

    public void setTabWidth(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("width can not be under 1");
        }
        this.k = i;
        this.cn.c();
        this.co.bn();
        ek();
        invalidate();
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        aff affVar = this.bp;
        if (affVar != null) {
            affVar.b.remove(this);
            this.bp.e = 0;
        }
        this.cl = new Bundle();
        if (charSequence instanceof aff) {
            aff affVar2 = (aff) charSequence;
            this.bp = affVar2;
            affVar2.e = 0;
            this.co.bn();
        } else {
            this.bp = new aff(charSequence, true);
        }
        FactoryPools factoryPoolsVar = this.f;
        factoryPoolsVar.f = null;
        factoryPoolsVar.h = null;
        this.cm = null;
        ahy ahyVarW = this.bp.w();
        this.bo = ahyVarW;
        this.g = ahyVarW.d.d();
        asv asvVar = this.by;
        asvVar.b.d(0, 0, 0, 0, 0);
        asvVar.q = false;
        asvVar.r = false;
        asvVar.e = -1;
        asvVar.aw();
        asvVar.d.j();
        this.bp.k(this);
        this.bp.ak(this.ag);
        aff affVar3 = this.bp;
        affVar3.h.b = true;
        int size = affVar3.a.size();
        ik ikVar = this.cn.a;
        chs chsVar = (chs) ikVar.c;
        int i = chsVar.b;
        if (i > size) {
            chsVar.e(size, i);
        } else if (i < size) {
            int i2 = size - i;
            for (int i3 = 0; i3 < i2; i3++) {
                chsVar.c(chsVar.b + 1);
                int[] iArr = chsVar.a;
                int i4 = chsVar.b;
                iArr[i4] = 0;
                chsVar.b = i4 + 1;
            }
        }
        Iterator it = dqc.bm(0, chsVar.b).iterator();
        while (((bqg) it).c) {
            int iNextInt = ((bqe) it).nextInt();
            if (iNextInt < 0 || iNextInt >= chsVar.b) {
                throw new IndexOutOfBoundsException("Index must be between 0 and size");
            }
            int[] iArr2 = chsVar.a;
            int i5 = iArr2[iNextInt];
            iArr2[iNextInt] = 0;
        }
        ((ArrayList) ikVar.d).clear();
        asn asnVar = this.co;
        CodeEditor codeEditor = asnVar.r;
        asnVar.af = codeEditor.getCursor();
        asnVar.ah = codeEditor.getText();
        btq btqVar = this.bu;
        if (btqVar != null) {
            btqVar.e().s(new afq(this.bp), this.cl);
            this.bu.getClass();
        }
        this.i.g(new afh(this, 1, new ud(), this.bp.x().o(getLineCount() - 1, this.bp.y(getLineCount() - 1).b), this.bp,
                false));
        dh(true);
        InputMethodManager inputMethodManager = this.bn;
        if (inputMethodManager != null) {
            inputMethodManager.restartInput(this);
        }
        requestLayout();
        this.cn.c();
        invalidate();
    }

    public void setTextLetterSpacing(float f) {
        asn asnVar = this.co;
        asnVar.d.setLetterSpacing(f);
        asnVar.e.setLetterSpacing(f);
        asnVar.bj();
        ek();
    }

    public void setTextScaleX(float f) {
        asn asnVar = this.co;
        asnVar.d.setTextScaleX(f);
        asnVar.e.setTextScaleX(f);
        asnVar.bj();
    }

    public void setTextSize(float f) {
        Context context = getContext();
        setTextSizePx(TypedValue.applyDimension(2, f,
                (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setTextSizePx(float f) {
        setTextSizePxDirect(f);
        ek();
        dh(true);
        invalidate();
    }

    public void setTextSizePxDirect(float f) {
        getTextSizePx();
        asn asnVar = this.co;
        csk cskVar = asnVar.d;
        cskVar.setTextSize(f);
        cskVar.d();
        csk cskVar2 = asnVar.e;
        cskVar2.setTextSize(f);
        csk cskVar3 = asnVar.i;
        CodeEditor codeEditor = asnVar.r;
        Objects.requireNonNull(codeEditor.getProps());
        cskVar3.setTextSize(f * 0.85f);
        asnVar.t = cskVar.getFontMetricsInt();
        asnVar.ac = cskVar2.getFontMetricsInt();
        asnVar.ad = cskVar3.getFontMetricsInt();
        codeEditor.getRenderContext().c();
        asnVar.bn();
        this.i.g(new drg(this));
    }

    public void setTypefaceLineNumber(Typeface typeface) {
        asn asnVar = this.co;
        csk cskVar = asnVar.e;
        if (typeface == null) {
            typeface = Typeface.MONOSPACE;
        }
        cskVar.setTypeface(typeface);
        asnVar.ac = cskVar.getFontMetricsInt();
        asnVar.r.invalidate();
        ek();
    }

    public void setTypefaceText(Typeface typeface) {
        asn asnVar = this.co;
        csk cskVar = asnVar.d;
        CodeEditor codeEditor = asnVar.r;
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        cskVar.setTypeface(typeface);
        cskVar.d();
        asnVar.t = cskVar.getFontMetricsInt();
        codeEditor.getRenderContext().c();
        asnVar.bn();
        codeEditor.dh(true);
        codeEditor.invalidate();
        ek();
    }

    public void setUndoEnabled(boolean z) {
        this.ag = z;
        aff affVar = this.bp;
        if (affVar != null) {
            affVar.ak(z);
        }
    }

    public void setVerticalExtraSpaceFactor(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("the factor should be in range [0.0, 1.0]");
        }
        this.ab = f;
        this.by.bb(0.0f, 0.0f, false);
    }

    @Override // android.view.View
    public void setVerticalScrollBarEnabled(boolean z) {
        this.av = z;
    }

    @Override // android.view.View
    public void setVerticalScrollbarThumbDrawable(Drawable drawable) {
        this.co.w = drawable;
    }

    @Override // android.view.View
    public void setVerticalScrollbarTrackDrawable(Drawable drawable) {
        this.co.x = drawable;
    }

    public void setWordwrap(boolean z) {
        et(z, true);
    }
}
