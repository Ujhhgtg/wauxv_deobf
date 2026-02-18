package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import com.umeng.analytics.pro.f;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.bdj;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cfx;
import me.hd.wauxv.obf.cjl;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cyb;
import me.hd.wauxv.obf.cyd;
import me.hd.wauxv.obf.dov;
import me.hd.wauxv.obf.mu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NavHostFragment extends bdj {
    public final dov a = new dov(new cfx(this, 3));
    public View b;
    public int c;
    public boolean d;

    @Override // me.hd.wauxv.obf.bdj
    public final void e(Context context) {
        bzo.q(context, f.X);
        super.e(context);
        if (this.d) {
            mu muVar = new mu(cs());
            muVar.ag(this);
            muVar.z();
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void f(Bundle bundle) {
        l();
        if (bundle != null && bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
            this.d = true;
            mu muVar = new mu(cs());
            muVar.ag(this);
            muVar.z();
        }
        super.f(bundle);
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        bzo.q(layoutInflater, "inflater");
        Context context = layoutInflater.getContext();
        bzo.p(context, "getContext(...)");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int i = this.bq;
        if (i == 0 || i == -1) {
            i = R.id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(i);
        return fragmentContainerView;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void h() {
        this.bx = true;
        View view = this.b;
        if (view != null && cnb.u(view) == l()) {
            view.setTag(R.id.nav_controller_view_tag, null);
        }
        this.b = null;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void i(Context context, AttributeSet attributeSet, Bundle bundle) {
        bzo.q(context, f.X);
        bzo.q(attributeSet, "attrs");
        super.i(context, attributeSet, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cyb.b);
        bzo.p(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.c = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cyd.c);
        bzo.p(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(...)");
        if (typedArrayObtainStyledAttributes2.getBoolean(0, false)) {
            this.d = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void j(Bundle bundle) {
        if (this.d) {
            bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        bzo.q(view, "view");
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException(("created host view " + view + " is not a ViewGroup").toString());
        }
        view.setTag(R.id.nav_controller_view_tag, l());
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getParent() != null) {
            Object parent = viewGroup.getParent();
            bzo.o(parent, "null cannot be cast to non-null type android.view.View");
            View view2 = (View) parent;
            this.b = view2;
            if (view2.getId() == this.bq) {
                View view3 = this.b;
                bzo.n(view3);
                view3.setTag(R.id.nav_controller_view_tag, l());
            }
        }
    }

    public final cjl l() {
        return (cjl) this.a.getValue();
    }
}
