package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bkt extends bgr implements bgk {
    public static final bkt a = new bkt(3, bdr.class, "inflate" /* "inflate" /* "inflate" /* cnb.z(-421791558269738L)  */, "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentHelperBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentHelperBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentHelperBinding;" /* cnb.z(-421757198531370L)  */, 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_helper, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        RecyclerView recyclerView = (RecyclerView) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.helperRecyclerView);
        if (recyclerView != null) {
            return new bdr((LinearLayout) viewInflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-640658796706602L)  */.concat(viewInflate.getResources().getResourceName(R.id.helperRecyclerView)));
    }
}
