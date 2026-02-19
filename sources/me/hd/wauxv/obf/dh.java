package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.util.SparseIntArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dh implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ dh(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Found duplicated region for block: B:364:0x01cf */
    /* JADX WARN: Multi-variable type inference failed */
    /*
     * JADX WARN: Type inference failed for: r0v66, types: [me.hd.wauxv.obf.bfu,
     * me.hd.wauxv.obf.btp]
     */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException
     */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        ?? r7;
        ?? r4;
        cjn cjnVar;
        switch (this.a) {
            case 0:
                Activity activity = (Activity) this.b;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = AbstractC0022do.g;
                Method method = AbstractC0022do.f;
                ?? r72 = Build.VERSION.SDK_INT;
                if (r72 >= 28) {
                    activity.recreate();
                    return;
                }
                if ((r72 != 27 || method != null) && (AbstractC0022do.e != null || AbstractC0022do.d != null)) {
                    try {
                        Object obj2 = AbstractC0022do.c.get(activity);
                        if (obj2 != null && (obj = AbstractC0022do.b.get(activity)) != null) {
                            Application application = activity.getApplication();
                            dn dnVar = new dn(activity);
                            application.registerActivityLifecycleCallbacks(dnVar);
                            handler.post(new cs(dnVar, obj2, 1, false));
                            ?? r42 = r72 != 27 ? 0 : 1;
                            try {
                                if (r42 != 0) {
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        r42 = application;
                                        r72 = dnVar;
                                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                    } catch (Throwable th) {
                                        th = th;
                                        r4 = application;
                                        r7 = dnVar;
                                        handler.post(new cs(r4, r7, 2, false));
                                        throw th;
                                    }
                                } else {
                                    r42 = application;
                                    r72 = dnVar;
                                    activity.recreate();
                                }
                                handler.post(new cs(r42, r72, 2, false));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                r4 = r42;
                                r7 = r72;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                ((CarouselLayoutManager) this.b).ff();
                return;
            case 2:
                ((zv) this.b).t(true);
                return;
            case 3:
                ((byw) this.b).l();
                return;
            case 4:
                ace aceVar = (ace) this.b;
                throwIfVar1IsNull(aceVar, "this$0");
                Runnable runnable = aceVar.b;
                if (runnable != null) {
                    runnable.run();
                    aceVar.b = null;
                    return;
                }
                return;
            case 5:
                acj.l((acj) this.b);
                return;
            case 6:
                aql aqlVar = (aql) this.b;
                boolean zIsPopupShowing = aqlVar.d.isPopupShowing();
                aqlVar.ad(zIsPopupShowing);
                aqlVar.i = zIsPopupShowing;
                return;
            case 7:
                aro aroVar = ((arn) this.b).g;
                aroVar.p = false;
                ((ProgressBar) aroVar.j.d).setVisibility(8);
                return;
            case 8:
                arw arwVar = (arw) this.b;
                CodeEditor codeEditor = arwVar.aa;
                ud udVar = arwVar.e;
                if (!arwVar.z.isShowing()) {
                    if (udVar != null) {
                        codeEditor.getDiagnostics();
                        arwVar.k();
                        return;
                    }
                    return;
                }
                if (arwVar.c.b || udVar == null) {
                    return;
                }
                codeEditor.getDiagnostics();
                arwVar.k();
                return;
            case 9:
                ((CodeEditor) this.b).ek();
                return;
            case 10:
                FactoryPools factoryPoolsVar = (FactoryPools) this.b;
                SyntheticPileOfMess bmuVar = (SyntheticPileOfMess) factoryPoolsVar.h;
                CodeEditor codeEditor2 = (CodeEditor) ((WeakReference) factoryPoolsVar.e).get();
                if (bmuVar != null) {
                    SparseIntArray sparseIntArray = (SparseIntArray) bmuVar.obj;
                    if (codeEditor2 == null || codeEditor2.getCursor().h() || !codeEditor2.bd) {
                        return;
                    }
                    codeEditor2.getText();
                    int i = codeEditor2.getCursor().c.a;
                    int i2 = i - 1;
                    if (i2 >= 0) {
                        int i3 = sparseIntArray.get(i) - 1;
                        if (i3 <= i2) {
                            i3 = i2;
                            i2 = i3;
                        }
                        cjnVar = i2 != -1 ? new cjn(i3, i2) : null;
                    }
                    if (cjnVar == null) {
                        int i4 = sparseIntArray.get(i + 1) - 1;
                        if (i4 <= i) {
                            i = i4;
                            i4 = i;
                        }
                        cjnVar = i != -1 ? new cjn(i4, i) : null;
                    }
                    factoryPoolsVar.f = cjnVar;
                    codeEditor2.invalidate();
                    return;
                }
                return;
            case 11:
                ((ass) this.b).q();
                return;
            case 12:
                bbu bbuVar = (bbu) this.b;
                synchronized (bbuVar.e) {
                    try {
                        if (bbuVar.i == null) {
                            return;
                        }
                        try {
                            bce bceVarK = bbuVar.k();
                            int i5 = bceVarK.f;
                            if (i5 == 2) {
                                synchronized (bbuVar.e) {
                                    try {
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                            }
                            if (i5 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i5 + ")");
                            }
                            try {
                                Method method2 = TraceCompat.b;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                SyntheticClass syntheticClassVar = bbuVar.d;
                                Context context = bbuVar.a;
                                syntheticClassVar.getClass();
                                bce[] bceVarArr = {bceVarK};
                                StaticHelpers7 emnVar = TypefaceCompat.a;
                                HugeSyntheticPileOfHelpers.beginTrace("TypefaceCompat.createFromFontInfo");
                                try {
                                    Typeface typefaceT = TypefaceCompat.a.t(context, bceVarArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferAo = StaticAndroidHelpers.ao(bbuVar.a, bceVarK.a);
                                    if (mappedByteBufferAo == null || typefaceT == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        chm chmVar = new chm(typefaceT, emc.aw(mappedByteBufferAo));
                                        Trace.endSection();
                                        Trace.endSection();
                                        synchronized (bbuVar.e) {
                                            try {
                                                cnh cnhVar = bbuVar.i;
                                                if (cnhVar != null) {
                                                    cnhVar.c(chmVar);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                            break;
                                        }
                                        bbuVar.j();
                                        return;
                                    } catch (Throwable th5) {
                                        Method method3 = TraceCompat.b;
                                        Trace.endSection();
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    Trace.endSection();
                                    throw th6;
                                }
                            } catch (Throwable th7) {
                                Method method4 = TraceCompat.b;
                                Trace.endSection();
                                throw th7;
                            }
                            break;
                        } catch (Throwable th8) {
                            synchronized (bbuVar.e) {
                                try {
                                    cnh cnhVar2 = bbuVar.i;
                                    if (cnhVar2 != null) {
                                        cnhVar2.b(th8);
                                    }
                                    bbuVar.j();
                                    return;
                                } catch (Throwable th9) {
                                    throw th9;
                                }
                            }
                        }
                    } catch (Throwable th10) {
                        throw th10;
                    }
                }
            case 13:
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) this.b;
                someFragmentManagerVar.ci.e.aa(someFragmentManagerVar.av);
                someFragmentManagerVar.av = null;
                return;
            case 14:
                Iterator it = ((beg) this.b).n.iterator();
                while (it.hasNext()) {
                    ((bes) it.next()).getClass();
                }
                return;
            case 15:
                cvt cvtVar = (cvt) this.b;
                bur burVar = cvtVar.g;
                if (cvtVar.c == 0) {
                    cvtVar.d = true;
                    burVar.m(LifeEventEnum.ON_PAUSE);
                }
                if (cvtVar.b == 0 && cvtVar.d) {
                    burVar.m(LifeEventEnum.ON_STOP);
                    cvtVar.e = true;
                    return;
                }
                return;
            case 16:
                ((cyg) this.b).al();
                return;
            case 17:
                qf qfVar = (qf) this.b;
                qfVar.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) qfVar.e;
                era eraVar = sideSheetBehavior.x;
                if (eraVar != null && eraVar.ab()) {
                    qfVar.f(qfVar.b);
                    return;
                } else {
                    if (sideSheetBehavior.w == 2) {
                        sideSheetBehavior.al(qfVar.b);
                        return;
                    }
                    return;
                }
            case 18:
                ((btp) this.b).invoke();
                return;
            case 19:
                ((TextInputLayout) this.b).e.requestLayout();
                return;
            case 20:
                ((h) this.b).invoke();
                return;
            default:
                View view = (View) this.b;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ dh(bfu bfuVar) {
        this.a = 18;
        this.b = (btp) bfuVar;
    }
}
