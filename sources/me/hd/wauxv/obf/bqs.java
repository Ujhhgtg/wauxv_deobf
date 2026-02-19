package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bqs implements eqj {
    public final /* synthetic */ int a;
    public final LinearLayout b;
    public final View c;
    public final CompoundButton d;
    public final TextView e;
    public final View f;

    public /* synthetic */ bqs(LinearLayout linearLayout, View view, CompoundButton compoundButton, TextView textView, View view2, int i) {
        this.a = i;
        this.b = linearLayout;
        this.c = view;
        this.d = compoundButton;
        this.e = textView;
        this.f = view2;
    }

    public static bqs g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.item_rv_view_switch, viewGroup, false);
        int i = R.id.itemSwitchViewCanClick;
        LinearLayout linearLayout = (LinearLayout) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.itemSwitchViewCanClick);
        if (linearLayout != null) {
            i = R.id.itemSwitchViewSwitchFunc;
            MaterialSwitch materialSwitch = (MaterialSwitch) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.itemSwitchViewSwitchFunc);
            if (materialSwitch != null) {
                i = R.id.itemSwitchViewTextViewDesc;
                MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.itemSwitchViewTextViewDesc);
                if (materialTextView != null) {
                    i = R.id.itemSwitchViewTextViewTitle;
                    MaterialTextView materialTextView2 = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.itemSwitchViewTextViewTitle);
                    if (materialTextView2 != null) {
                        return new bqs((LinearLayout) viewInflate, linearLayout, materialSwitch, materialTextView, materialTextView2, 0);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-642033186241322L)  */.concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // me.hd.wauxv.obf.eqj
    public final View getRoot() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b;
    }
}
