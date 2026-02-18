package me.hd.wauxv.obf;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.android.dx.io.Opcodes;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayj extends czd implements czk {
    public static final int[] a = {R.attr.state_pressed};
    public static final int[] b = new int[0];
    public final ValueAnimator ac;
    public int ad;
    public final dc ae;
    public final int d;
    public final int e;
    public final StateListDrawable f;
    public final Drawable g;
    public final int h;
    public final int i;
    public final StateListDrawable j;
    public final Drawable k;
    public final int l;
    public final int m;
    public int n;
    public int o;
    public float p;
    public int q;
    public int r;
    public float s;
    public final RecyclerView v;
    public int t = 0;
    public int u = 0;
    public boolean w = false;
    public boolean x = false;
    public int y = 0;
    public int z = 0;
    public final int[] aa = new int[2];
    public final int[] ab = new int[2];

    public ayj(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ac = valueAnimatorOfFloat;
        this.ad = 0;
        dc dcVar = new dc(this, 6);
        this.ae = dcVar;
        ayh ayhVar = new ayh(this);
        this.f = stateListDrawable;
        this.g = drawable;
        this.j = stateListDrawable2;
        this.k = drawable2;
        this.h = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.i = Math.max(i, drawable.getIntrinsicWidth());
        this.l = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.m = Math.max(i, drawable2.getIntrinsicWidth());
        this.d = i2;
        this.e = i3;
        stateListDrawable.setAlpha(Opcodes.CONST_METHOD_TYPE);
        drawable.setAlpha(Opcodes.CONST_METHOD_TYPE);
        valueAnimatorOfFloat.addListener(new ayi(this));
        valueAnimatorOfFloat.addUpdateListener(new no(this, 3));
        RecyclerView recyclerView2 = this.v;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.em(this);
            RecyclerView recyclerView3 = this.v;
            recyclerView3.aa.remove(this);
            if (recyclerView3.ab == this) {
                recyclerView3.ab = null;
            }
            ArrayList arrayList = this.v.bq;
            if (arrayList != null) {
                arrayList.remove(ayhVar);
            }
            this.v.removeCallbacks(dcVar);
        }
        this.v = recyclerView;
        recyclerView.cu(this);
        this.v.aa.add(this);
        this.v.cv(ayhVar);
    }

    public static int af(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 != 0) {
            int i5 = i - i3;
            int i6 = (int) (((f2 - f) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 < i5 && i7 >= 0) {
                return i6;
            }
        }
        return 0;
    }

    @Override // me.hd.wauxv.obf.czk
    public final void ag(MotionEvent motionEvent) {
        if (this.y == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zAk = ak(motionEvent.getX(), motionEvent.getY());
            boolean zAj = aj(motionEvent.getX(), motionEvent.getY());
            if (zAk || zAj) {
                if (zAj) {
                    this.z = 1;
                    this.s = (int) motionEvent.getX();
                } else if (zAk) {
                    this.z = 2;
                    this.p = (int) motionEvent.getY();
                }
                al(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.y == 2) {
            this.p = 0.0f;
            this.s = 0.0f;
            al(1);
            this.z = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.y == 2) {
            am();
            int i = this.z;
            int i2 = this.e;
            if (i == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.ab;
                iArr[0] = i2;
                int i3 = this.t - i2;
                iArr[1] = i3;
                float fMax = Math.max(i2, Math.min(i3, x));
                if (Math.abs(this.r - fMax) >= 2.0f) {
                    int iAf = af(this.s, fMax, iArr, this.v.computeHorizontalScrollRange(), this.v.computeHorizontalScrollOffset(), this.t);
                    if (iAf != 0) {
                        this.v.scrollBy(iAf, 0);
                    }
                    this.s = fMax;
                }
            }
            if (this.z == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.aa;
                iArr2[0] = i2;
                int i4 = this.u - i2;
                iArr2[1] = i4;
                float fMax2 = Math.max(i2, Math.min(i4, y));
                if (Math.abs(this.o - fMax2) < 2.0f) {
                    return;
                }
                int iAf2 = af(this.p, fMax2, iArr2, this.v.computeVerticalScrollRange(), this.v.computeVerticalScrollOffset(), this.u);
                if (iAf2 != 0) {
                    this.v.scrollBy(0, iAf2);
                }
                this.p = fMax2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.czk
    public final boolean ah(MotionEvent motionEvent) {
        int i = this.y;
        if (i != 1) {
            return i == 2;
        }
        boolean zAk = ak(motionEvent.getX(), motionEvent.getY());
        boolean zAj = aj(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!zAk && !zAj) {
            return false;
        }
        if (zAj) {
            this.z = 1;
            this.s = (int) motionEvent.getX();
        } else if (zAk) {
            this.z = 2;
            this.p = (int) motionEvent.getY();
        }
        al(2);
        return true;
    }

    @Override // me.hd.wauxv.obf.czk
    public final void ai(boolean z) {
    }

    public final boolean aj(float f, float f2) {
        if (f2 < this.u - this.l) {
            return false;
        }
        int i = this.r;
        int i2 = this.q;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) ((i2 / 2) + i));
    }

    public final boolean ak(float f, float f2) {
        int layoutDirection = this.v.getLayoutDirection();
        int i = this.h;
        if (layoutDirection == 1) {
            if (f > i) {
                return false;
            }
        } else if (f < this.t - i) {
            return false;
        }
        int i2 = this.o;
        int i3 = this.n / 2;
        return f2 >= ((float) (i2 - i3)) && f2 <= ((float) (i3 + i2));
    }

    public final void al(int i) {
        dc dcVar = this.ae;
        StateListDrawable stateListDrawable = this.f;
        if (i == 2 && this.y != 2) {
            stateListDrawable.setState(a);
            this.v.removeCallbacks(dcVar);
        }
        if (i == 0) {
            this.v.invalidate();
        } else {
            am();
        }
        if (this.y == 2 && i != 2) {
            stateListDrawable.setState(b);
            this.v.removeCallbacks(dcVar);
            this.v.postDelayed(dcVar, 1200);
        } else if (i == 1) {
            this.v.removeCallbacks(dcVar);
            this.v.postDelayed(dcVar, 1500);
        }
        this.y = i;
    }

    public final void am() {
        int i = this.ad;
        ValueAnimator valueAnimator = this.ac;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.ad = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }

    @Override // me.hd.wauxv.obf.czd
    public final void c(Canvas canvas, RecyclerView recyclerView) {
        if (this.t != this.v.getWidth() || this.u != this.v.getHeight()) {
            this.t = this.v.getWidth();
            this.u = this.v.getHeight();
            al(0);
            return;
        }
        if (this.ad != 0) {
            if (this.w) {
                int i = this.t;
                int i2 = this.h;
                int i3 = i - i2;
                int i4 = this.o;
                int i5 = this.n;
                int i6 = i4 - (i5 / 2);
                StateListDrawable stateListDrawable = this.f;
                stateListDrawable.setBounds(0, 0, i2, i5);
                int i7 = this.i;
                int i8 = this.u;
                Drawable drawable = this.g;
                drawable.setBounds(0, 0, i7, i8);
                if (this.v.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i2, i6);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i2, -i6);
                } else {
                    canvas.translate(i3, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i6);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i3, -i6);
                }
            }
            if (this.x) {
                int i9 = this.u;
                int i10 = this.l;
                int i11 = i9 - i10;
                int i12 = this.r;
                int i13 = this.q;
                int i14 = i12 - (i13 / 2);
                StateListDrawable stateListDrawable2 = this.j;
                stateListDrawable2.setBounds(0, 0, i13, i10);
                int i15 = this.t;
                int i16 = this.m;
                Drawable drawable2 = this.k;
                drawable2.setBounds(0, 0, i15, i16);
                canvas.translate(0.0f, i11);
                drawable2.draw(canvas);
                canvas.translate(i14, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i14, -i11);
            }
        }
    }
}
