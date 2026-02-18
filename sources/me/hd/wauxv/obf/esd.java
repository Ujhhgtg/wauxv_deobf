package me.hd.wauxv.obf;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esd extends RecyclerView {
    public final /* synthetic */ ViewPager2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public esd(ViewPager2 viewPager2, Context context) {
        super(context, null);
        this.d = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.d.t.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.d;
        accessibilityEvent.setFromIndex(viewPager2.d);
        accessibilityEvent.setToIndex(viewPager2.d);
        accessibilityEvent.setSource((ViewPager2) viewPager2.t.f);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.d.r && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.d.r && super.onTouchEvent(motionEvent);
    }
}
