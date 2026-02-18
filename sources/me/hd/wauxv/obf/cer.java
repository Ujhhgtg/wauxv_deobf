package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cer extends bgr implements bgk {
    public static final cer a = new cer(3, bek.class, cnb.z(-395476293647146L), cnb.z(-395441933908778L), 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_module_nav, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.moduleNavTabLayout;
        TabLayout tabLayout = (TabLayout) cnd.aq(viewInflate, R.id.moduleNavTabLayout);
        if (tabLayout != null) {
            i = R.id.moduleNavViewPager2;
            ViewPager2 viewPager2 = (ViewPager2) cnd.aq(viewInflate, R.id.moduleNavViewPager2);
            if (viewPager2 != null) {
                i = R.id.moduleToolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) cnd.aq(viewInflate, R.id.moduleToolbar);
                if (materialToolbar != null) {
                    return new bek((CoordinatorLayout) viewInflate, tabLayout, viewPager2, materialToolbar);
                }
            }
        }
        throw new NullPointerException(cnb.z(-640521357753130L).concat(viewInflate.getResources().getResourceName(i)));
    }
}
