package me.hd.wauxv.ui.fragment.module;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.aba;
import me.hd.wauxv.obf.abb;
import me.hd.wauxv.obf.abi;
import me.hd.wauxv.obf.acw;
import me.hd.wauxv.obf.acx;
import me.hd.wauxv.obf.amf;
import me.hd.wauxv.obf.bdo;
import me.hd.wauxv.obf.bek;
import me.hd.wauxv.obf.bez;
import me.hd.wauxv.obf.bku;
import me.hd.wauxv.obf.byu;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cer;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.Pair;
import me.hd.wauxv.obf.cua;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.dpo;
import me.hd.wauxv.obf.dpp;
import me.hd.wauxv.obf.dpq;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.eqj;
import me.hd.wauxv.obf.etz;
import me.hd.wauxv.obf.eua;
import me.hd.wauxv.obf.hb;
import me.hd.wauxv.obf.j;
import me.hd.wauxv.obf.qp;
import me.hd.wauxv.obf.ro;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ModuleNavFragment extends bdo {
    public ModuleNavFragment() {
        super(cer.a);
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) throws IllegalAccessException, InvocationTargetException {
        eqj eqjVar = this.d;
        throwIfVar1IsNull(eqjVar);
        CoordinatorLayout coordinatorLayout = ((bek) eqjVar).a;
        StringBuilder sb = new StringBuilder();
        sb.append("免费模块仅供学习,勿在国内平台传播\n" /* cnb.z(-394900768029482L) */);
        ro.a.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wxid:" /* cnb.z(-394853523389226L) */);
        acx.a.getClass();
        sb2.append(acx.b());
        sb2.append('\n');
        sb.append(sb2.toString());
        Object objInvoke = emn.bb(acw.a).invoke(null, null);
        throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.Map<*, *>" /*
                                                                                                          * cnb.z(-
                                                                                                          * 107949708016426L)
                                                                                                          */);
        Object obj = ((Map) objInvoke).get("last_login_alias" /* cnb.z(-109568910687018L) */);
        String str = obj instanceof String ? (String) obj : null;
        if (str != null) {
            String str2 = str.length() > 0 ? str : null;
            if (str2 != null) {
                sb.append("alias:" /* cnb.z(-394810573716266L) */ + str2 + '\n');
            }
        }
        etz etzVar = new etz(sb.toString(), abi.f(dc().getColor(R.color.md_theme_primary), 48), 60);
        FrameLayout frameLayout = new FrameLayout(coordinatorLayout.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setBackground(new eua(etzVar));
        coordinatorLayout.addView(frameLayout);
        eqj eqjVar2 = this.d;
        throwIfVar1IsNull(eqjVar2);
        MaterialToolbar materialToolbar = ((bek) eqjVar2).d;
        materialToolbar.setTitle("WAuxiliary" /* cnb.z(-394763329076010L) */);
        materialToolbar.setSubtitle("1.2.6.r1238.198c77c" /* cnb.z(-394750444174122L) */);
        eqj eqjVar3 = this.d;
        throwIfVar1IsNull(eqjVar3);
        ViewPager2 viewPager2 = ((bek) eqjVar3).c;
        viewPager2.setUserInputEnabled(true);
        List listAg = aba.ag(
                new Pair(new bku(), "辅助" /* cnb.z(-395179940903722L) */), new Pair(new cua(),
                        "插件" /* cnb.z(-395184235871018L) */),
                new Pair(new amf(), "开发" /* cnb.z(-395205710707498L) */), new Pair(new j(), "关于" /*
                                                                                                  * cnb.z(-
                                                                                                  * 395141286198058L)
                                                                                                  */));
        hb hbVarDb = db();
        ArrayList arrayList = new ArrayList(abb.ak(listAg, 10));
        Iterator it = listAg.iterator();
        while (it.hasNext()) {
            arrayList.add((bdo) ((Pair) it.next()).first);
        }
        viewPager2.setAdapter(new byu(hbVarDb, arrayList));
        eqj eqjVar4 = this.d;
        throwIfVar1IsNull(eqjVar4);
        TabLayout tabLayout = ((bek) eqjVar4).b;
        eqj eqjVar5 = this.d;
        throwIfVar1IsNull(eqjVar5);
        ViewPager2 viewPager22 = ((bek) eqjVar5).c;
        dpq dpqVar = new dpq(tabLayout, viewPager22, new qp(listAg, 10));
        if (dpqVar.e) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        cyw adapter = viewPager22.getAdapter();
        dpqVar.d = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        dpqVar.e = true;
        ((ArrayList) viewPager22.c.b).add(new dpo(tabLayout));
        dpp dppVar = new dpp(viewPager22);
        ArrayList arrayList2 = tabLayout.am;
        if (!arrayList2.contains(dppVar)) {
            arrayList2.add(dppVar);
        }
        dpqVar.d.ac.registerObserver(new bez(dpqVar, 2));
        dpqVar.f();
        tabLayout.az(viewPager22.getCurrentItem(), 0.0f, true, true, true);
    }
}
