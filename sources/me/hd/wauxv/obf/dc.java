package me.hd.wauxv.obf;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Process;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.lang.ref.ReferenceQueue;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dc implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ dc(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    /* JADX WARN: Found duplicated region for block: B:56:0x012d */
    @Override // java.lang.Runnable
    public final void run() {
        int iL;
        cw cwVar;
        int i = this.a;
        int iL2 = 0;
        Object obj = this.b;
        switch (i) {
            case 0:
                Process.setThreadPriority(10);
                ((Runnable) obj).run();
                return;
            case 1:
                FactoryPools factoryPoolsVar = (FactoryPools) obj;
                factoryPoolsVar.getClass();
                while (true) {
                    try {
                        factoryPoolsVar.n((de) ((ReferenceQueue) factoryPoolsVar.f).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
            case 2:
                bwo bwoVar = (bwo) obj;
                aqe aqeVar = bwoVar.d;
                me meVar = bwoVar.b;
                if (bwoVar.p) {
                    if (bwoVar.n) {
                        bwoVar.n = false;
                        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        meVar.e = jCurrentAnimationTimeMillis;
                        meVar.g = -1L;
                        meVar.f = jCurrentAnimationTimeMillis;
                        meVar.h = 0.5f;
                    }
                    if ((meVar.g > 0 && AnimationUtils.currentAnimationTimeMillis() > meVar.g + ((long) meVar.i))
                            || !bwoVar.getAllBaseBaseHookInstances()) {
                        bwoVar.p = false;
                        return;
                    }
                    if (bwoVar.o) {
                        bwoVar.o = false;
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f,
                                0);
                        aqeVar.onTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                    }
                    if (meVar.f == 0) {
                        throw new RuntimeException("Cannot compute scroll delta before calling start()");
                    }
                    long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float fJ = meVar.j(jCurrentAnimationTimeMillis2);
                    long j = jCurrentAnimationTimeMillis2 - meVar.f;
                    meVar.f = jCurrentAnimationTimeMillis2;
                    bwoVar.r.scrollListBy((int) (j * ((fJ * 4.0f) + ((-4.0f) * fJ * fJ)) * meVar.d));
                    WeakHashMap weakHashMap = ViewCompat.a;
                    aqeVar.postOnAnimation(this);
                    return;
                }
                return;
            case 3:
                qf qfVar = (qf) obj;
                qfVar.c = false;
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) qfVar.e;
                era eraVar = bottomSheetBehavior.ba;
                if (eraVar != null && eraVar.ab()) {
                    qfVar.f(qfVar.b);
                    return;
                } else {
                    if (bottomSheetBehavior.az == 2) {
                        bottomSheetBehavior.cg(qfVar.b);
                        return;
                    }
                    return;
                }
            case 4:
                anc ancVar = (anc) obj;
                ancVar.d.onDismiss(ancVar.s);
                return;
            case 5:
                aqe aqeVar2 = (aqe) obj;
                aqeVar2.l = null;
                aqeVar2.drawableStateChanged();
                return;
            case 6:
                ayj ayjVar = (ayj) obj;
                ValueAnimator valueAnimator = ayjVar.ac;
                int i2 = ayjVar.ad;
                if (i2 == 1) {
                    valueAnimator.cancel();
                } else if (i2 != 2) {
                    return;
                }
                ayjVar.ad = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
                return;
            case 7:
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) obj;
                if (someFragmentManagerVar.cc != null) {
                    someFragmentManagerVar.co().getClass();
                    return;
                }
                return;
            case 8:
                ((beg) obj).bw(true);
                return;
            case 9:
                byu byuVar = (byu) obj;
                byuVar.r = false;
                byuVar.y();
                return;
            case 10:
                bfo bfoVar = ((bfp) obj).bg;
                if (bfoVar == null) {
                    return;
                }
                bfoVar.m(null);
                return;
            case 11:
                bqx bqxVar = (bqx) obj;
                if (bqxVar.d != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = bqxVar.ac;
                    long j3 = j2 != Long.MIN_VALUE ? jCurrentTimeMillis - j2 : 0L;
                    czg layoutManager = bqxVar.s.getLayoutManager();
                    if (bqxVar.ab == null) {
                        bqxVar.ab = new Rect();
                    }
                    View view = bqxVar.d.d;
                    Rect rect = bqxVar.ab;
                    RecyclerView recyclerView = layoutManager.dp;
                    if (recyclerView == null) {
                        rect.set(0, 0, 0, 0);
                    } else {
                        rect.set(recyclerView.dw(view));
                    }
                    if (layoutManager.bu()) {
                        int i3 = (int) (bqxVar.k + bqxVar.i);
                        int paddingLeft = (i3 - bqxVar.ab.left) - bqxVar.s.getPaddingLeft();
                        float f = bqxVar.i;
                        iL = ((f >= 0.0f || paddingLeft >= 0)
                                && (f <= 0.0f || (paddingLeft = ((bqxVar.d.d.getWidth() + i3) + bqxVar.ab.right)
                                        - (bqxVar.s.getWidth() - bqxVar.s.getPaddingRight())) <= 0)) ? 0 : paddingLeft;
                    }
                    if (layoutManager.bv()) {
                        int i4 = (int) (bqxVar.l + bqxVar.j);
                        int paddingTop = (i4 - bqxVar.ab.top) - bqxVar.s.getPaddingTop();
                        float f2 = bqxVar.j;
                        if ((f2 < 0.0f && paddingTop < 0)
                                || (f2 > 0.0f && (paddingTop = ((bqxVar.d.d.getHeight() + i4) + bqxVar.ab.bottom)
                                        - (bqxVar.s.getHeight() - bqxVar.s.getPaddingBottom())) > 0)) {
                            iL2 = paddingTop;
                        }
                    }
                    if (iL != 0) {
                        xe xeVar = bqxVar.n;
                        RecyclerView recyclerView2 = bqxVar.s;
                        int width = bqxVar.d.d.getWidth();
                        bqxVar.s.getWidth();
                        iL = xeVar.l(recyclerView2, width, iL, j3);
                    }
                    int i5 = iL;
                    if (iL2 != 0) {
                        xe xeVar2 = bqxVar.n;
                        RecyclerView recyclerView3 = bqxVar.s;
                        int height = bqxVar.d.d.getHeight();
                        bqxVar.s.getHeight();
                        iL2 = xeVar2.l(recyclerView3, height, iL2, j3);
                    }
                    if (i5 == 0 && iL2 == 0) {
                        bqxVar.ac = Long.MIN_VALUE;
                        return;
                    }
                    if (bqxVar.ac == Long.MIN_VALUE) {
                        bqxVar.ac = jCurrentTimeMillis;
                    }
                    bqxVar.s.scrollBy(i5, iL2);
                    SomeView someViewVar = bqxVar.d;
                    if (someViewVar != null) {
                        bqxVar.ao(someViewVar);
                    }
                    bqxVar.s.removeCallbacks(bqxVar.t);
                    RecyclerView recyclerView4 = bqxVar.s;
                    WeakHashMap weakHashMap2 = ViewCompat.a;
                    recyclerView4.postOnAnimation(this);
                    return;
                }
                return;
            case 12:
                bfl bflVar = (bfl) obj;
                EditText editText = ((cct) bflVar.ac).h;
                if (editText == null) {
                    return;
                }
                editText.requestFocus();
                ((cct) bflVar.ac).h.setFocusableInTouchMode(true);
                cct cctVar = (cct) bflVar.ac;
                cctVar.o.av(cctVar.h, true);
                EditText editText2 = ((cct) bflVar.ac).h;
                editText2.setSelection(editText2.getText().length());
                ((cct) bflVar.ac).o.getClass();
                return;
            case 13:
                cct cctVar2 = (cct) obj;
                DialogXBaseRelativeLayout dialogXBaseRelativeLayout = cctVar2.b;
                if (dialogXBaseRelativeLayout != null) {
                    dialogXBaseRelativeLayout.setVisibility(8);
                }
                ng.x(cctVar2.o.ar());
                return;
            case 14:
                dca dcaVar = (dca) obj;
                dcaVar.d.al(dcaVar);
                return;
            case 15:
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = (SearchView$SearchAutoComplete) obj;
                if (searchView$SearchAutoComplete.b) {
                    ((InputMethodManager) searchView$SearchAutoComplete.getContext().getSystemService("input_method"))
                            .showSoftInput(searchView$SearchAutoComplete, 0);
                    searchView$SearchAutoComplete.b = false;
                    return;
                }
                return;
            case 16:
                ((StaggeredGridLayoutManager) obj).bc();
                return;
            case 17:
                CheckableImageButton checkableImageButton = ((TextInputLayout) obj).d.g;
                checkableImageButton.performClick();
                checkableImageButton.jumpDrawablesToCurrentState();
                return;
            case 18:
                ActionMenuView actionMenuView = ((Toolbar) obj).a;
                if (actionMenuView == null || (cwVar = actionMenuView.g) == null) {
                    return;
                }
                cwVar.am();
                return;
            default:
                ((era) obj).aj(0);
                return;
        }
    }
}
