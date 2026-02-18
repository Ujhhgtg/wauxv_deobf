package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import me.hd.wauxv.obf.dfa;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DialogScrollView extends ScrollView implements dfa {
    public boolean a;

    public DialogScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // me.hd.wauxv.obf.dfa
    public int getScrollDistance() {
        return getScrollY();
    }

    @Override // android.widget.ScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
