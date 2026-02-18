package me.hd.wauxv.obf;

import android.animation.ObjectAnimator;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.kongzue.dialogx.util.views.DialogScrollView;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfq implements View.OnTouchListener {
    public final /* synthetic */ bfo a;
    public final /* synthetic */ bfp b;
    public final /* synthetic */ bfr c;

    public bfq(bfr bfrVar, bfo bfoVar, bfp bfpVar) {
        this.c = bfrVar;
        this.a = bfoVar;
        this.b = bfpVar;
    }

    /* JADX WARN: Found duplicated region for block: B:47:0x00ea  */
    /* JADX WARN: Found duplicated region for block: B:49:0x00fc  */
    /* JADX WARN: Found duplicated region for block: B:51:0x010b  */
    /* JADX WARN: Found duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Found duplicated region for block: B:54:0x0134  */
    /* JADX WARN: Found duplicated region for block: B:55:0x0138  */
    /* JADX WARN: Found duplicated region for block: B:56:0x0151  */
    /* JADX WARN: Found duplicated region for block: B:58:0x0163  */
    /* JADX WARN: Found duplicated region for block: B:59:0x017e  */
    /* JADX WARN: Found duplicated region for block: B:61:0x0189  */
    /* JADX WARN: Found duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Found duplicated region for block: B:65:0x01a9  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        MaxRelativeLayout maxRelativeLayout;
        float y;
        float f;
        float f2;
        dfa dfaVar;
        MaxRelativeLayout maxRelativeLayout2;
        float y2;
        float f3;
        DialogScrollView dialogScrollView;
        View childAt;
        int action = motionEvent.getAction();
        bfr bfrVar = this.c;
        bfo bfoVar = this.a;
        if (action == 0) {
            bfrVar.b = motionEvent.getY();
            bfrVar.a = true;
            bfrVar.c = bfoVar.e.getY();
            return false;
        }
        bfp bfpVar = this.b;
        if (action == 1) {
            bfrVar.a = false;
            if (bfrVar.c == bfpVar.bg.o()) {
                MaxRelativeLayout maxRelativeLayout3 = bfoVar.e;
                maxRelativeLayout2 = bfoVar.e;
                y2 = maxRelativeLayout3.getY();
                f3 = anj.b;
                if (y2 < f3) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(maxRelativeLayout2, "y", maxRelativeLayout2.getY(), bfpVar.bg.o());
                    objectAnimatorOfFloat.setDuration(300L);
                    objectAnimatorOfFloat.start();
                } else if (maxRelativeLayout2.getY() > bfoVar.o() + f3) {
                    bfoVar.q();
                } else {
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(maxRelativeLayout2, "y", maxRelativeLayout2.getY(), bfoVar.o());
                    objectAnimatorOfFloat2.setDuration(300L);
                    objectAnimatorOfFloat2.start();
                }
            } else {
                MaxRelativeLayout maxRelativeLayout4 = bfoVar.e;
                maxRelativeLayout = bfoVar.e;
                y = maxRelativeLayout4.getY();
                f = bfrVar.c;
                f2 = anj.b;
                if (y < f - f2) {
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), bfpVar.bg.o());
                    objectAnimatorOfFloat3.setDuration(300L);
                    objectAnimatorOfFloat3.start();
                } else if (maxRelativeLayout.getY() > bfrVar.c + f2) {
                    bfoVar.q();
                } else {
                    ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), bfoVar.o());
                    objectAnimatorOfFloat4.setDuration(300L);
                    objectAnimatorOfFloat4.start();
                }
            }
            dfaVar = bfoVar.g;
            if (dfaVar != null) {
                ((DialogScrollView) dfaVar).a = false;
            }
        } else if (action != 2) {
            if (action == 3) {
                bfrVar.a = false;
                if (bfrVar.c == bfpVar.bg.o()) {
                    MaxRelativeLayout maxRelativeLayout32 = bfoVar.e;
                    maxRelativeLayout2 = bfoVar.e;
                    y2 = maxRelativeLayout32.getY();
                    f3 = anj.b;
                    if (y2 < f3) {
                        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(maxRelativeLayout2, "y", maxRelativeLayout2.getY(), bfpVar.bg.o());
                        objectAnimatorOfFloat5.setDuration(300L);
                        objectAnimatorOfFloat5.start();
                    } else if (maxRelativeLayout2.getY() > bfoVar.o() + f3) {
                        bfoVar.q();
                    } else {
                        ObjectAnimator objectAnimatorOfFloat22 = ObjectAnimator.ofFloat(maxRelativeLayout2, "y", maxRelativeLayout2.getY(), bfoVar.o());
                        objectAnimatorOfFloat22.setDuration(300L);
                        objectAnimatorOfFloat22.start();
                    }
                } else {
                    MaxRelativeLayout maxRelativeLayout42 = bfoVar.e;
                    maxRelativeLayout = bfoVar.e;
                    y = maxRelativeLayout42.getY();
                    f = bfrVar.c;
                    f2 = anj.b;
                    if (y < f - f2) {
                        ObjectAnimator objectAnimatorOfFloat32 = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), bfpVar.bg.o());
                        objectAnimatorOfFloat32.setDuration(300L);
                        objectAnimatorOfFloat32.start();
                    } else if (maxRelativeLayout.getY() > bfrVar.c + f2) {
                        bfoVar.q();
                    } else {
                        ObjectAnimator objectAnimatorOfFloat42 = ObjectAnimator.ofFloat(maxRelativeLayout, "y", maxRelativeLayout.getY(), bfoVar.o());
                        objectAnimatorOfFloat42.setDuration(300L);
                        objectAnimatorOfFloat42.start();
                    }
                }
                dfaVar = bfoVar.g;
                if (dfaVar != null) {
                    ((DialogScrollView) dfaVar).a = false;
                }
            }
        } else if (bfrVar.a) {
            MaxRelativeLayout maxRelativeLayout5 = bfoVar.e;
            MaxRelativeLayout maxRelativeLayout6 = bfoVar.e;
            float y3 = (motionEvent.getY() + maxRelativeLayout5.getY()) - bfrVar.b;
            dfa dfaVar2 = bfoVar.g;
            if (dfaVar2 != null && (childAt = (dialogScrollView = (DialogScrollView) dfaVar2).getChildAt(0)) != null && dialogScrollView.getHeight() < childAt.getHeight()) {
                View view2 = (View) bfoVar.g;
                RectF rectF = new RectF();
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view2.getLocationInWindow(iArr);
                view.getLocationInWindow(iArr2);
                float f4 = iArr[0] - iArr2[0];
                rectF.left = f4;
                rectF.top = iArr[1] - iArr2[1];
                rectF.right = f4 + view2.getWidth();
                rectF.bottom = rectF.top + view2.getHeight();
                if (motionEvent.getX() >= rectF.left && motionEvent.getX() <= rectF.right && motionEvent.getY() >= rectF.top && motionEvent.getY() <= rectF.bottom) {
                    if (y3 <= bfpVar.bg.o()) {
                        dfa dfaVar3 = bfoVar.g;
                        if (dfaVar3 != null) {
                            ((DialogScrollView) dfaVar3).a = false;
                        }
                        maxRelativeLayout6.setY(bfpVar.bg.o());
                        return false;
                    }
                    if (bfoVar.g.getScrollDistance() != 0) {
                        bfrVar.b = motionEvent.getY();
                        return false;
                    }
                    dfa dfaVar4 = bfoVar.g;
                    if (dfaVar4 != null) {
                        ((DialogScrollView) dfaVar4).a = true;
                    }
                    maxRelativeLayout6.setY(y3);
                    return false;
                }
            }
            if (y3 < bfpVar.bg.o()) {
                y3 = bfpVar.bg.o();
            }
            maxRelativeLayout6.setY(y3);
            return false;
        }
        return false;
    }
}
