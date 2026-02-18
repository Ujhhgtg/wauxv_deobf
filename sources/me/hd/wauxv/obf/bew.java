package me.hd.wauxv.obf;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bew implements eqj {
    public final CoordinatorLayout a;
    public final MaterialButton b;
    public final MaterialTextView c;

    public bew(CoordinatorLayout coordinatorLayout, MaterialButton materialButton, MaterialTextView materialTextView) {
        this.a = coordinatorLayout;
        this.b = materialButton;
        this.c = materialTextView;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
