package me.hd.wauxv.obf;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ia extends ContentFrameLayout {
    public final /* synthetic */ AppCompatDelegate i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia(AppCompatDelegate appCompatDelegateVar, afv afvVar) {
        super(afvVar, null);
        this.i = appCompatDelegateVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.i.cd(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                AppCompatDelegate appCompatDelegateVar = this.i;
                appCompatDelegateVar.cc(appCompatDelegateVar.ci(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i) {
        setBackgroundDrawable(cmz.y(getContext(), i));
    }
}
