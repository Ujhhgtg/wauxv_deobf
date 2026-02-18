package me.hd.wauxv.obf;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import no.agens.depth.BearSceneView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dj implements eqj {
    public final CoordinatorLayout a;
    public final BearSceneView b;
    public final MaterialButton c;
    public final MaterialCardView d;
    public final View e;
    public final ShapeableImageView f;
    public final LinearLayout g;
    public final MaterialTextView h;
    public final MaterialTextView i;
    public final MaterialTextView j;
    public final MaterialTextView k;
    public final MaterialToolbar l;

    public dj(CoordinatorLayout coordinatorLayout, BearSceneView bearSceneView, MaterialButton materialButton, MaterialCardView materialCardView, View view, ShapeableImageView shapeableImageView, LinearLayout linearLayout, MaterialTextView materialTextView, MaterialTextView materialTextView2, MaterialTextView materialTextView3, MaterialTextView materialTextView4, MaterialToolbar materialToolbar) {
        this.a = coordinatorLayout;
        this.b = bearSceneView;
        this.c = materialButton;
        this.d = materialCardView;
        this.e = view;
        this.f = shapeableImageView;
        this.g = linearLayout;
        this.h = materialTextView;
        this.i = materialTextView2;
        this.j = materialTextView3;
        this.k = materialTextView4;
        this.l = materialToolbar;
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        return this.a;
    }
}
