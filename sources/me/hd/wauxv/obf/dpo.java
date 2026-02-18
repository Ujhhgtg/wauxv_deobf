package me.hd.wauxv.obf;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpo extends erz {
    public final WeakReference a;
    public int f = 0;
    public int b = 0;

    public dpo(TabLayout tabLayout) {
        this.a = new WeakReference(tabLayout);
    }

    @Override // me.hd.wauxv.obf.erz
    public final void c(int i) {
        this.b = this.f;
        this.f = i;
        TabLayout tabLayout = (TabLayout) this.a.get();
        if (tabLayout != null) {
            tabLayout.ao = this.f;
        }
    }

    @Override // me.hd.wauxv.obf.erz
    public final void d(int i, float f, int i2) {
        boolean z;
        TabLayout tabLayout = (TabLayout) this.a.get();
        if (tabLayout != null) {
            int i3 = this.f;
            boolean z2 = true;
            if (i3 != 2 || this.b == 1) {
                z = true;
            } else {
                z = true;
                z2 = false;
            }
            if (i3 == 2 && this.b == 0) {
                z = false;
            }
            tabLayout.az(i, f, z2, z, false);
        }
    }

    @Override // me.hd.wauxv.obf.erz
    public final void e(int i) {
        TabLayout tabLayout = (TabLayout) this.a.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.f;
        tabLayout.ay((i < 0 || i >= tabLayout.getTabCount()) ? null : (dpl) tabLayout.c.get(i), i2 == 0 || (i2 == 2 && this.b == 0));
    }
}
