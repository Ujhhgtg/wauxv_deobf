package me.hd.wauxv.obf;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.TextureView;
import android.view.View;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ccz extends abn {
    public float aa;
    public float ab;
    public ccv g;
    public long h;
    public long i;
    public long j;
    public int k;
    public int l;
    public Drawable m;
    public Interpolator n;
    public Interpolator o;
    public cuy p;
    public IInvokable q;
    public IInvokable r;
    public bfu s;
    public FrameLayout t;
    public ImageView u;
    public ArrayList v;
    public boolean w;
    public crk x;
    public float y;
    public float z;

    public static /* synthetic */ void ac(ccz cczVar, View view, float f, long j, long j2) {
        cczVar.af(view, f, j, j2, new PathInterpolator(0.95f, 0.0f, 0.07f, 1.0f));
    }

    private final int getLayoutGravity() {
        int iOrdinal = this.p.ordinal();
        if (iOrdinal == 1) {
            return 8388659;
        }
        if (iOrdinal == 2) {
            return 8388661;
        }
        if (iOrdinal != 3) {
            return iOrdinal != 4 ? 17 : 8388693;
        }
        return 8388691;
    }

    public final void ad(FrameLayout frameLayout) {
        this.w = false;
        frameLayout.removeAllViews();
        int dimension = (int) getResources().getDimension(R.dimen.menu_item_size);
        int dimension2 = (int) getResources().getDimension(R.dimen.main_button_size);
        int dimension3 = (int) getResources().getDimension(R.dimen.margins_to_compensate_cutoff);
        int layoutGravity = getLayoutGravity();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        int i = ((dimension2 - dimension) / 2) + dimension3;
        layoutParams.setMargins(((int) this.y) + i, ((int) this.aa) + i, ((int) this.z) + i, i + ((int) this.ab));
        layoutParams.gravity = layoutGravity;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dimension2, dimension2);
        layoutParams2.setMargins(((int) this.y) + dimension3, ((int) this.aa) + dimension3, ((int) this.z) + dimension3,
                dimension3 + ((int) this.ab));
        layoutParams2.gravity = layoutGravity;
        int iO = this.g.o();
        for (int i2 = 0; i2 < iO; i2++) {
            Context context = getContext();
            throwIfVar1IsNull(context, "getContext(...)");
            ajw ajwVar = new ajw(context, getResources().getDimension(R.dimen.menu_item_touch_area_size));
            ajwVar.setBackgroundResource(R.drawable.gradient_oval);
            ajwVar.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.button_scale));
            ajwVar.getBackground().setTint(this.g.m());
            ajwVar.setImageDrawable(this.g.j(i2));
            ajwVar.setColorFilter(this.g.s());
            int dimension4 = (int) getResources().getDimension(R.dimen.menu_item_padding);
            ajwVar.setPadding(dimension4, dimension4, dimension4, dimension4);
            ajwVar.setOnClickListener(new ccw(this, i2, 0));
            ajwVar.setEnabled(false);
            if (!this.a) {
                ajwVar.setLayerType(2, null);
            }
            frameLayout.addView(ajwVar, layoutParams);
        }
        Context context2 = getContext();
        throwIfVar1IsNull(context2, "getContext(...)");
        ajw ajwVar2 = new ajw(context2, getResources().getDimension(R.dimen.main_button_touch_area_size));
        ajwVar2.setBackgroundResource(R.drawable.gradient_oval);
        ajwVar2.getBackground().setTint(this.k);
        Drawable drawable = this.m;
        Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
        int i3 = this.l;
        Context context3 = getContext();
        throwIfVar1IsNull(context3, "getContext(...)");
        crk crkVar = new crk(drawableMutate, i3, context3);
        this.x = crkVar;
        ajwVar2.setImageDrawable(crkVar);
        int dimension5 = (int) getResources().getDimension(R.dimen.main_button_padding);
        ajwVar2.setPadding(dimension5, dimension5, dimension5, dimension5);
        ajwVar2.setOnClickListener(new bq(this, 10));
        this.u = ajwVar2;
        frameLayout.addView(ajwVar2, layoutParams2);
        if (this.a) {
            this.c = new TextureView(getContext());
            throwLateinitPropNotInitYet("textureViewRenderer");
            throw null;
        }
    }

    public final ObjectAnimator ae(View view, float f, float f2, long j, Interpolator interpolator, long j2) {
        throwIfVar1IsNull(interpolator, "interpolator");
        ObjectAnimator duration = ObjectAnimator
                .ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, view.getTranslationX(), f).setDuration(j2);
        throwIfVar1IsNull(duration, "setDuration(...)");
        duration.setInterpolator(interpolator);
        duration.setStartDelay(j);
        duration.start();
        ArrayList arrayList = this.v;
        arrayList.add(duration);
        ObjectAnimator duration2 = ObjectAnimator
                .ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getTranslationY(), f2).setDuration(j2);
        throwIfVar1IsNull(duration2, "setDuration(...)");
        duration2.setStartDelay(j);
        duration2.setInterpolator(interpolator);
        duration2.start();
        arrayList.add(duration2);
        return duration2;
    }

    public final ObjectAnimator af(View view, float f, long j, long j2, BaseInterpolator baseInterpolator) {
        throwIfVar1IsNull(view, "view");
        ObjectAnimator duration = ObjectAnimator
                .ofFloat(view, (Property<View, Float>) View.SCALE_X, view.getScaleX(), f).setDuration(j);
        throwIfVar1IsNull(duration, "setDuration(...)");
        duration.setStartDelay(j2);
        duration.setInterpolator(baseInterpolator);
        duration.start();
        ArrayList arrayList = this.v;
        arrayList.add(duration);
        ObjectAnimator duration2 = ObjectAnimator
                .ofFloat(view, (Property<View, Float>) View.SCALE_Y, view.getScaleY(), f).setDuration(j);
        throwIfVar1IsNull(duration2, "setDuration(...)");
        duration2.setStartDelay(j2);
        duration2.setInterpolator(baseInterpolator);
        duration2.start();
        arrayList.add(duration2);
        return duration;
    }

    public final void ag(final Drawable drawable, long j, long j2, int i, final boolean z) {
        ValueAnimator duration = ValueAnimator.ofInt(drawable.getAlpha(), i).setDuration(j2);
        if (z) {
            drawable.setAlpha(0);
        }
        final dag dagVar = new dag();
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: me.hd.wauxv.obf.ccx
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                throwIfVar1IsNull(valueAnimator, "animation");
                Object animatedValue = valueAnimator.getAnimatedValue();
                throwIfVar1IsNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) animatedValue).intValue();
                Drawable drawable2 = drawable;
                drawable2.setAlpha(iIntValue);
                if (z && (drawable2 instanceof AnimatedVectorDrawable)) {
                    dag dagVar2 = dagVar;
                    if (dagVar2.a) {
                        return;
                    }
                    AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable2;
                    if (animatedVectorDrawable.getAlpha() > 0) {
                        animatedVectorDrawable.start();
                        dagVar2.a = true;
                    }
                }
            }
        });
        duration.setStartDelay(j);
        duration.start();
        this.v.add(duration);
    }

    public final void ah() {
        ArrayList arrayList = this.v;
        Iterator it = arrayList.iterator();
        throwIfVar1IsNull(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            throwIfVar1IsNull(next, "next(...)");
            ValueAnimator valueAnimator = (ValueAnimator) next;
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        arrayList.clear();
    }

    public final void ai() {
        if (this.w) {
            ah();
            int i = 2;
            long j = 0;
            for (int childCount = getMetaBallsContainerFrameLayout().getChildCount()
                    - 2; -1 < childCount; childCount--) {
                View childAt = getMetaBallsContainerFrameLayout().getChildAt(childCount);
                throwIfVar1IsNull(childAt);
                long j2 = j;
                ObjectAnimator objectAnimatorAe = ae(childAt, 0.0f, 0.0f, j2, getCloseInterpolatorAnimator(), this.j);
                long j3 = (long) (this.j * 0.33f);
                af(childAt, 0.1f, j3, j2 + j3, new LinearInterpolator());
                Drawable drawable = ((ImageView) childAt).getDrawable();
                throwIfVar1IsNull(drawable, "getDrawable(...)");
                ag(drawable, j2, (long) (this.j * 0.16f), 0, false);
                j = j2 + this.h;
                if (childCount == 0) {
                    objectAnimatorAe.addListener(new ci(this, 5));
                }
            }
            long j4 = j;
            ImageView imageView = this.u;
            throwIfVar1IsNull(imageView, "null cannot be cast to non-null type android.view.View");
            ac(this, imageView, 1.0f, 300L, 0L);
            if (this.a) {
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 0.0f).setDuration(this.j + j4);
                duration.addUpdateListener(new aqi(this, i));
                duration.start();
            }
            crk crkVar = this.x;
            if (crkVar != null) {
                crkVar.n(0.0f);
            }
        } else {
            f();
            crk crkVar2 = this.x;
            if (crkVar2 != null) {
                crkVar2.n(1.0f);
            }
        }
        boolean z = !this.w;
        this.w = z;
        IInvokable bgfVar = this.r;
        if (bgfVar != null) {
            bgfVar.invoke(Boolean.valueOf(z));
        }
    }

    public abstract void getResult();

    public final ccv getAdapter() {
        return this.g;
    }

    public final long getCloseAnimationDuration() {
        return this.j;
    }

    public final Interpolator getCloseInterpolatorAnimator() {
        Interpolator interpolator = this.o;
        if (interpolator != null) {
            return interpolator;
        }
        throwLateinitPropNotInitYet("closeInterpolatorAnimator");
        throw null;
    }

    public final long getDelayBetweenItemsAnimation() {
        return this.h;
    }

    public final int getMainButtonColor() {
        return this.k;
    }

    public final Drawable getMainButtonIcon() {
        return this.m;
    }

    public final int getMainButtonIconColor() {
        return this.l;
    }

    public final ImageView getMenuButton() {
        return this.u;
    }

    public final FrameLayout getMetaBallsContainerFrameLayout() {
        FrameLayout frameLayout = this.t;
        if (frameLayout != null) {
            return frameLayout;
        }
        throwLateinitPropNotInitYet("metaBallsContainerFrameLayout");
        throw null;
    }

    public final IInvokable getOnItemSelectedListener() {
        return this.q;
    }

    public final bfu getOnMenuClosed() {
        return this.s;
    }

    public final IInvokable getOnMenuToggled() {
        return this.r;
    }

    public final long getOpenAnimationDuration() {
        return this.i;
    }

    public final Interpolator getOpenInterpolatorAnimator() {
        Interpolator interpolator = this.n;
        if (interpolator != null) {
            return interpolator;
        }
        throwLateinitPropNotInitYet("openInterpolatorAnimator");
        throw null;
    }

    public final cuy getPositionGravity() {
        return this.p;
    }

    public final void setAdapter(ccv ccvVar) {
        throwIfVar1IsNull(ccvVar, "value");
        this.g = ccvVar;
        ad(getMetaBallsContainerFrameLayout());
    }

    public final void setCloseAnimationDuration(long j) {
        this.j = j;
    }

    public final void setCloseInterpolatorAnimator(Interpolator interpolator) {
        throwIfVar1IsNull(interpolator, "<set-?>");
        this.o = interpolator;
    }

    public final void setDelayBetweenItemsAnimation(long j) {
        this.h = j;
    }

    public final void setMainButtonColor(int i) {
        Drawable background;
        this.k = i;
        ImageView imageView = this.u;
        if (imageView == null || (background = imageView.getBackground()) == null) {
            return;
        }
        background.setTint(i);
    }

    public final void setMainButtonIcon(Drawable drawable) {
        Drawable drawable2;
        this.m = drawable;
        crk crkVar = this.x;
        if (crkVar != null) {
            crkVar.a = drawable;
        }
        if (crkVar == null || (drawable2 = crkVar.a) == null) {
            return;
        }
        drawable2.setTint(this.l);
    }

    public final void setMainButtonIconColor(int i) {
        Drawable drawable;
        this.l = i;
        crk crkVar = this.x;
        if (crkVar == null || (drawable = crkVar.a) == null) {
            return;
        }
        drawable.setTint(i);
    }

    public final void setMenuButton(ImageView imageView) {
        this.u = imageView;
    }

    public final void setMetaBallsContainerFrameLayout(FrameLayout frameLayout) {
        throwIfVar1IsNull(frameLayout, "<set-?>");
        this.t = frameLayout;
    }

    public final void setOnItemSelectedListener(IInvokable bgfVar) {
        this.q = bgfVar;
    }

    public final void setOnMenuClosed(bfu bfuVar) {
        this.s = bfuVar;
    }

    public final void setOnMenuToggled(IInvokable bgfVar) {
        this.r = bgfVar;
    }

    public final void setOpenAnimationDuration(long j) {
        this.i = j;
    }

    public final void setOpenInterpolatorAnimator(Interpolator interpolator) {
        throwIfVar1IsNull(interpolator, "<set-?>");
        this.n = interpolator;
    }

    public final void setPositionGravity(cuy cuyVar) {
        throwIfVar1IsNull(cuyVar, "value");
        this.p = cuyVar;
        if (getMetaBallsContainerFrameLayout().getChildCount() != 0) {
            ad(getMetaBallsContainerFrameLayout());
        }
    }

    @Override // me.hd.wauxv.obf.abn
    public final void setupBaseViews(Context context) {
        throwIfVar1IsNull(context, "context");
        super.setupBaseViews(context);
        this.y = getPaddingLeft();
        this.z = getPaddingRight();
        this.aa = getPaddingTop();
        this.ab = getPaddingBottom();
        setPadding(0, 0, 0, 0);
        setMetaBallsContainerFrameLayout(new FrameLayout(context));
        addView(getMetaBallsContainerFrameLayout(), new FrameLayout.LayoutParams(-1, -1));
        if (this.a) {
            return;
        }
        FrameLayout metaBallsContainerFrameLayout = getMetaBallsContainerFrameLayout();
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 200.0f, -32640.0f })));
        metaBallsContainerFrameLayout.setLayerType(2, paint);
    }
}
