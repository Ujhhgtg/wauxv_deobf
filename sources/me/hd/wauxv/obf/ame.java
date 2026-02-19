package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ame extends bgr implements bgk {
    public static final ame a = new ame(3, bdq.class, "inflate" /* "inflate" /* "inflate" /* cnb.z(-420099341155114L)  */, "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentDeveloperBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentDeveloperBinding;" /* "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lme/hd/wauxv/databinding/FragmentDeveloperBinding;" /* cnb.z(-420064981416746L)  */, 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_developer, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        RecyclerView recyclerView = (RecyclerView) KotlinHelpers2.aq(viewInflate, R.id.developerRecyclerView);
        if (recyclerView != null) {
            return new bdq((LinearLayout) viewInflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-634748921707306L)  */.concat(viewInflate.getResources().getResourceName(R.id.developerRecyclerView)));
    }
}
