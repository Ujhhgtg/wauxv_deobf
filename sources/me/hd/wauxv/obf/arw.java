package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class arw extends ase {
    public final awy a;
    public final View b;
    public final HookManager c;
    public final int d;
    public ud e;
    public Pair f;

    public arw(CodeEditor codeEditor) {
        super(codeEditor, 6);
        awy awyVar = new awy(codeEditor.i);
        this.a = awyVar;
        this.c = new HookManager();
        this.d = (int) (codeEditor.getDpUnit() * 175);
        new ArrayList();
        Float fValueOf = Float.valueOf(0.0f);
        this.f = new Pair(fValueOf, fValueOf);
        final HookManager hookManagerVar = this.c;
        throwIfVar1IsNull(hookManagerVar, "value");
        if (this.b == null || this.c != hookManagerVar) {
            this.c = hookManagerVar;
            hookManagerVar.hookPriority = this;
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.aa.getContext());
            throwIfVar1IsNull(layoutInflaterFrom, "from(...)");
            arw arwVar = (arw) hookManagerVar.hookPriority;
            if (arwVar == null) {
                throwLateinitPropNotInitYet("window");
                throw null;
            }
            Context context = arwVar.aa.getContext();
            View viewInflate = layoutInflaterFrom.inflate(R.layout.diagnostic_tooltip_window, (ViewGroup) null);
            throwIfVar1IsNull(viewInflate, "inflate(...)");
            hookManagerVar.resolutionStrategy = viewInflate;
            viewInflate.setClipToOutline(true);
            View view = (View) hookManagerVar.resolutionStrategy;
            if (view == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            view.setOnGenericMotionListener(new View.OnGenericMotionListener() { // from class: me.hd.wauxv.obf.akg
                @Override // android.view.View.OnGenericMotionListener
                public final boolean onGenericMotion(View view2, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    HookManager hookManagerVar2 = hookManagerVar;
                    if (actionMasked == 9) {
                        hookManagerVar2.b = true;
                    } else if (actionMasked == 10) {
                        hookManagerVar2.b = false;
                    }
                    return false;
                }
            });
            View view2 = (View) hookManagerVar.resolutionStrategy;
            if (view2 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById = view2.findViewById(R.id.diagnostic_tooltip_brief_message);
            throwIfVar1IsNull(viewFindViewById, "findViewById(...)");
            hookManagerVar.instantCollection = (TextView) viewFindViewById;
            View view3 = (View) hookManagerVar.resolutionStrategy;
            if (view3 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById2 = view3.findViewById(R.id.diagnostic_tooltip_detailed_message);
            throwIfVar1IsNull(viewFindViewById2, "findViewById(...)");
            hookManagerVar.f = (TextView) viewFindViewById2;
            View view4 = (View) hookManagerVar.resolutionStrategy;
            if (view4 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById3 = view4.findViewById(R.id.diagnostic_tooltip_preferred_action);
            throwIfVar1IsNull(viewFindViewById3, "findViewById(...)");
            hookManagerVar.g = (TextView) viewFindViewById3;
            View view5 = (View) hookManagerVar.resolutionStrategy;
            if (view5 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById4 = view5.findViewById(R.id.diagnostic_tooltip_more_actions);
            throwIfVar1IsNull(viewFindViewById4, "findViewById(...)");
            hookManagerVar.activeUnhooks = (TextView) viewFindViewById4;
            View view6 = (View) hookManagerVar.resolutionStrategy;
            if (view6 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById5 = view6.findViewById(R.id.diagnostic_container_message);
            throwIfVar1IsNull(viewFindViewById5, "findViewById(...)");
            hookManagerVar.members = (ViewGroup) viewFindViewById5;
            View view7 = (View) hookManagerVar.resolutionStrategy;
            if (view7 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            View viewFindViewById6 = view7.findViewById(R.id.diagnostic_container_quickfix);
            throwIfVar1IsNull(viewFindViewById6, "findViewById(...)");
            hookManagerVar.hookingEngine = (ViewGroup) viewFindViewById6;
            TextView textView = (TextView) hookManagerVar.g;
            if (textView == null) {
                throwLateinitPropNotInitYet("quickfixText");
                throw null;
            }
            textView.setOnClickListener(new akh(hookManagerVar));
            TextView textView2 = (TextView) hookManagerVar.activeUnhooks;
            if (textView2 == null) {
                throwLateinitPropNotInitYet("moreActionText");
                throw null;
            }
            SparseIntArray sparseIntArray = bmx.a;
            int i = R.string.sora_editor_diagnostics_more_actions;
            int i2 = sparseIntArray.get(R.string.sora_editor_diagnostics_more_actions);
            textView2.setText(i2 != 0 ? i2 : i);
            TextView textView3 = (TextView) hookManagerVar.activeUnhooks;
            if (textView3 == null) {
                throwLateinitPropNotInitYet("moreActionText");
                throw null;
            }
            textView3.setOnClickListener(new akh(hookManagerVar, context));
            View view8 = (View) hookManagerVar.resolutionStrategy;
            if (view8 == null) {
                throwLateinitPropNotInitYet("root");
                throw null;
            }
            this.b = view8;
            this.z.setContentView(view8);
            j();
        }
        this.z.setAnimationStyle(R.style.diagnostic_popup_animation);
        final int i3 = 0;
        awyVar.l(dfn.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i4;
                int measuredHeight;
                int measuredWidth;
                switch (i3) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i4 = dfnVar.m) == 3 || i4 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i5 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i6 = i5 - measuredHeight;
                            if (i6 < 1) {
                                i6 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i6) {
                                i6 = measuredHeight2;
                            }
                            layoutParams.height = i6;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i6;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        final int i4 = 1;
        awyVar.l(dfb.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i42;
                int measuredHeight;
                int measuredWidth;
                switch (i4) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i42 = dfnVar.m) == 3 || i42 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i5 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i6 = i5 - measuredHeight;
                            if (i6 < 1) {
                                i6 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i6) {
                                i6 = measuredHeight2;
                            }
                            layoutParams.height = i6;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i6;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        awyVar.k(bmp.class, new ut(this, new dh(this, 8)));
        final int i5 = 2;
        awyVar.l(abg.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i42;
                int measuredHeight;
                int measuredWidth;
                switch (i5) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i42 = dfnVar.m) == 3 || i42 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i52 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i52, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i6 = i52 - measuredHeight;
                            if (i6 < 1) {
                                i6 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i6) {
                                i6 = measuredHeight2;
                            }
                            layoutParams.height = i6;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i6;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        final int i6 = 3;
        awyVar.l(drg.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i42;
                int measuredHeight;
                int measuredWidth;
                switch (i6) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i42 = dfnVar.m) == 3 || i42 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i52 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i52, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i62 = i52 - measuredHeight;
                            if (i62 < 1) {
                                i62 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i62, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i62) {
                                i62 = measuredHeight2;
                            }
                            layoutParams.height = i62;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i62;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        final int i7 = 4;
        awyVar.l(arx.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i42;
                int measuredHeight;
                int measuredWidth;
                switch (i7) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i42 = dfnVar.m) == 3 || i42 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i52 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i52, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i62 = i52 - measuredHeight;
                            if (i62 < 1) {
                                i62 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i62, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i62) {
                                i62 = measuredHeight2;
                            }
                            layoutParams.height = i62;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i62;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        final int i8 = 5;
        awyVar.l(asf.class, new awz(this) { // from class: me.hd.wauxv.obf.arv
            public final /* synthetic */ arw b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                int i42;
                int measuredHeight;
                int measuredWidth;
                switch (i8) {
                    case 0:
                        arw arwVar2 = this.b;
                        CodeEditor codeEditor2 = arwVar2.aa;
                        dfn dfnVar = (dfn) uaVar;
                        throwIfVar1IsNull(dfnVar, "event");
                        if (!arwVar2.a.f || codeEditor2.dy()) {
                            return;
                        }
                        if (dfnVar.n() || !((i42 = dfnVar.m) == 3 || i42 == 1)) {
                            arwVar2.k();
                            return;
                        }
                        throwIfVar1IsNull(dfnVar.a, "getLeft(...)");
                        codeEditor2.getDiagnostics();
                        arwVar2.k();
                        return;
                    case 1:
                        throwIfVar1IsNull((dfb) uaVar, "<unused var>");
                        this.b.aa.dy();
                        return;
                    case 2:
                        throwIfVar1IsNull((abg) uaVar, "<unused var>");
                        this.b.j();
                        return;
                    case 3:
                        throwIfVar1IsNull((drg) uaVar, "event");
                        arw arwVar3 = this.b;
                        arwVar3.c.getClass();
                        if (arwVar3.z.isShowing()) {
                            int width = (int) (((double) arwVar3.aa.getWidth()) * 0.9d);
                            HookManager hookManagerVar2 = arwVar3.c;
                            int i52 = arwVar3.d;
                            hookManagerVar2.getClass();
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE);
                            ViewGroup viewGroup = (ViewGroup) hookManagerVar2.hookingEngine;
                            if (viewGroup == null) {
                                throwLateinitPropNotInitYet("quickfixPanel");
                                throw null;
                            }
                            if (viewGroup.getVisibility() == 0) {
                                ViewGroup viewGroup2 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup2 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                viewGroup2.measure(iMakeMeasureSpec,
                                        View.MeasureSpec.makeMeasureSpec(i52, Integer.MIN_VALUE));
                                ViewGroup viewGroup3 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup3 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredHeight = viewGroup3.getMeasuredHeight();
                                ViewGroup viewGroup4 = (ViewGroup) hookManagerVar2.hookingEngine;
                                if (viewGroup4 == null) {
                                    throwLateinitPropNotInitYet("quickfixPanel");
                                    throw null;
                                }
                                measuredWidth = viewGroup4.getMeasuredWidth();
                                if (measuredWidth > width) {
                                    measuredWidth = width;
                                }
                            } else {
                                measuredHeight = 0;
                                measuredWidth = 0;
                            }
                            int i62 = i52 - measuredHeight;
                            if (i62 < 1) {
                                i62 = 1;
                            }
                            ViewGroup viewGroup5 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup5 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                            layoutParams.height = -2;
                            ViewGroup viewGroup6 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup6 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup6.setLayoutParams(layoutParams);
                            ViewGroup viewGroup7 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup7 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup7.measure(iMakeMeasureSpec,
                                    View.MeasureSpec.makeMeasureSpec(i62, Integer.MIN_VALUE));
                            ViewGroup viewGroup8 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup8 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredHeight2 = viewGroup8.getMeasuredHeight();
                            if (measuredHeight2 <= i62) {
                                i62 = measuredHeight2;
                            }
                            layoutParams.height = i62;
                            ViewGroup viewGroup9 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup9 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            viewGroup9.setLayoutParams(layoutParams);
                            ViewGroup viewGroup10 = (ViewGroup) hookManagerVar2.members;
                            if (viewGroup10 == null) {
                                throwLateinitPropNotInitYet("messagePanel");
                                throw null;
                            }
                            int measuredWidth2 = viewGroup10.getMeasuredWidth();
                            if (measuredWidth2 <= width) {
                                width = measuredWidth2;
                            }
                            arwVar3.al = Math.max(measuredWidth, width);
                            arwVar3.am = measuredHeight + i62;
                            arwVar3.an(false);
                            return;
                        }
                        return;
                    case 4:
                        arx arxVar = (arx) uaVar;
                        throwIfVar1IsNull(arxVar, "event");
                        if (arxVar.a) {
                            return;
                        }
                        this.b.i();
                        return;
                    default:
                        throwIfVar1IsNull((asf) uaVar, "<unused var>");
                        arw arwVar4 = this.b;
                        arwVar4.a.j(false);
                        arwVar4.i();
                        return;
                }
            }
        });
        this.z.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: me.hd.wauxv.obf.aru
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.a.c.second = false;
            }
        });
        j();
    }

    public static final void g(arw arwVar, bmp bmpVar) {
        arwVar.f = new Pair(Float.valueOf(bmpVar.l.getX()), Float.valueOf(bmpVar.l.getY()));
    }

    public static void h(arw arwVar, dh dhVar) {
        CodeEditor codeEditor = arwVar.aa;
        codeEditor.removeCallbacks(dhVar);
        codeEditor.eh(dhVar, 1000L);
    }

    @Override // me.hd.wauxv.obf.ase
    public final void i() {
        if (this.z.isShowing()) {
            super.i();
        }
    }

    public final void j() {
        arq colorScheme = this.aa.getColorScheme();
        throwIfVar1IsNull(colorScheme, "getColorScheme(...)");
        HookManager hookManagerVar = this.c;
        hookManagerVar.getClass();
        SparseIntArray sparseIntArray = colorScheme.b;
        arw arwVar = (arw) hookManagerVar.hookPriority;
        if (arwVar == null) {
            throwLateinitPropNotInitYet("window");
            throw null;
        }
        CodeEditor codeEditor = arwVar.aa;
        throwIfVar1IsNull(codeEditor, "getEditor(...)");
        TextView textView = (TextView) hookManagerVar.instantCollection;
        if (textView == null) {
            throwLateinitPropNotInitYet("briefMessageText");
            throw null;
        }
        textView.setTextColor(sparseIntArray.get(54));
        TextView textView2 = (TextView) hookManagerVar.f;
        if (textView2 == null) {
            throwLateinitPropNotInitYet("detailMessageText");
            throw null;
        }
        textView2.setTextColor(sparseIntArray.get(55));
        TextView textView3 = (TextView) hookManagerVar.g;
        if (textView3 == null) {
            throwLateinitPropNotInitYet("quickfixText");
            throw null;
        }
        textView3.setTextColor(sparseIntArray.get(56));
        TextView textView4 = (TextView) hookManagerVar.activeUnhooks;
        if (textView4 == null) {
            throwLateinitPropNotInitYet("moreActionText");
            throw null;
        }
        textView4.setTextColor(sparseIntArray.get(56));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(codeEditor.getDpUnit() * 5);
        gradientDrawable.setColor(sparseIntArray.get(53));
        View view = (View) hookManagerVar.resolutionStrategy;
        if (view != null) {
            view.setBackground(gradientDrawable);
        } else {
            throwLateinitPropNotInitYet("root");
            throw null;
        }
    }

    public final void k() {
        if (this.a.f) {
            CodeEditor codeEditor = this.aa;
            throwIfVar1IsNull(codeEditor, "getEditor(...)");
            aro aroVar = codeEditor.bx;
            throwIfVar1IsNull(aroVar, "getComponent(...)");
            if (aroVar.z.isShowing()) {
                i();
            }
        }
    }
}
