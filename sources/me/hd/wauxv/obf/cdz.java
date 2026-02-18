package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentContainerView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cdz extends bgr implements bgf {
    public static final cdz a = new cdz(1, dk.class, "inflate" /* cnb.z(-387337330621226L) */, "inflate(Landroid/view/LayoutInflater;)Lme/hd/wauxv/databinding/ActivityModuleBinding;" /* cnb.z(-388952238324522L) */, 0);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.activity_module, (ViewGroup) null, false);
        if (((FragmentContainerView) cnd.aq(viewInflate, R.id.moduleContainerView)) != null) {
            return new dk((FrameLayout) viewInflate);
        }
        throw new NullPointerException("Missing required view with ID: " /* cnb.z(-635298677521194L) */.concat(viewInflate.getResources().getResourceName(R.id.moduleContainerView)));
    }
}
