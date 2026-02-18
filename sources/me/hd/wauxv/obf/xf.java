package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.highcapable.betterandroid.ui.component.adapter.recycler.layoutmanager.LinearLayoutManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import me.hd.wauxv.R;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class xf extends doo implements bmz, bng {
    public static final xf a = new xf("ChatToolbarHook" /* cnb.z(-549064324152106L) */);
    public static final String b = "界面" /* cnb.z(-552998514195242L) */;
    public static final String c = "聊天工具栏" /* cnb.z(-553019989031722L) */;
    public static final String d = "聊天输入框顶部显示工具栏，可能串台" /* cnb.z(-552977039358762L) */;
    public static final ws i = new ws(1);
    public static final boolean j = true;
    public static final ArrayList l = new ArrayList();
    public static cyt m;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        aki akiVarAb = csb.ab(this, dqc.bf(emn.bb(xa.a)));
        ws wsVar = new ws(3);
        xf xfVar = a;
        xfVar.y(akiVarAb, wsVar);
        xfVar.x(akiVarAb, new ws(4));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(xa.a, dexKitBridge, new ws(5));
    }

    public final void n(FrameLayout frameLayout) throws cth {
        Class cls;
        Class cls2;
        if (z()) {
            LinearLayout linearLayout = (LinearLayout) cnh.v(frameLayout, cnb.ac(ewh.q) ? "c0p" /* cnb.z(-548995604675370L) */ : cnb.ac(ewh.o) ? "bzn" /* cnb.z(-548944065067818L) */ : cnb.ac(ewh.n) ? "byp" /* cnb.z(-548961244937002L) */ : cnb.ac(ewh.m) ? "by1" /* cnb.z(-546160926260010L) */ : cnb.ac(ewh.l) ? "bwr" /* cnb.z(-546178106129194L) */ : cnb.ac(ewh.k) ? "bw_" /* cnb.z(-546126566521642L) */ : cnb.ac(ewh.j) ? "bvs" /* cnb.z(-546143746390826L) */ : cnb.ac(ewh.i) ? "bv0" /* cnb.z(-546092206783274L) */ : cnb.ac(ewh.h) ? "bui" /* cnb.z(-546109386652458L) */ : cnb.ac(ewh.g) ? "bwa" /* cnb.z(-546057847044906L) */ : cnb.ac(ewh.f) ? "bvv" /* cnb.z(-546075026914090L) */ : cnb.ac(ewh.e) ? "brq" /* cnb.z(-546023487306538L) */ : cnb.ac(ewh.d) ? "br6" /* cnb.z(-546040667175722L) */ : cnb.ac(ewh.c) ? "bmw" /* cnb.z(-545989127568170L) */ : cnb.ac(ewh.b) ? "bip" /* cnb.z(-546006307437354L) */ : cnb.ac(ewh.a) ? "bej" /* cnb.z(-545954767829802L) */ : cnb.ab(ewk.c) ? "bl8" /* cnb.z(-545971947698986L) */ : "b4t" /* cnb.z(-545920408091434L) */);
            if (linearLayout == null || linearLayout.findViewWithTag("ChatToolbar" /* cnb.z(-545937587960618L) */) != null) {
                return;
            }
            cnf.bh(linearLayout.getContext());
            Context context = linearLayout.getContext();
            LinkedHashMap linkedHashMap = blu.a;
            cls = ViewGroup.LayoutParams.class;
            Class<ViewGroup.LayoutParams> clsBf = cnf.bf(dal.b(cls));
            if (clsBf == null) {
                clsBf = cls;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            if (blu.c) {
                arrayList.add(new blv(emn.an(context), i2));
            }
            blu bluVar = new blu(aaz.z(arrayList));
            blr blrVarI = blu.i(bluVar, clsBf, null, false, context);
            blu bluVar2 = blrVarI.f;
            LinkedHashMap linkedHashMap2 = bluVar2.f;
            blq blqVarD = awp.d(bluVar2, blrVarI.a, blrVarI.b, blr.g(blrVarI, 0, 0, null, 55));
            cls2 = RecyclerView.class;
            Class<RecyclerView> clsBf2 = cnf.bf(dal.b(cls2));
            if (clsBf2 == null) {
                clsBf2 = cls2;
            }
            View viewH = blu.h(bluVar2, clsBf2, null, blrVarI.j());
            viewH.setLayoutParams(blqVarD.f());
            Class<RecyclerView> clsBf3 = cnf.bf(dal.b(cls2));
            if (clsBf3 == null) {
                clsBf3 = cls2;
            }
            String name = clsBf3.getName();
            int size = linkedHashMap2.size();
            RecyclerView recyclerView = (RecyclerView) viewH;
            recyclerView.setTag("ChatToolbar" /* cnb.z(-546401444428586L) */);
            int iIntValue = blrVarI.k(8).intValue();
            recyclerView.setPadding(iIntValue, iIntValue, iIntValue, iIntValue);
            recyclerView.setFadingEdgeLength(blrVarI.k(10).intValue());
            int i3 = 1;
            recyclerView.setHorizontalFadingEdgeEnabled(true);
            recyclerView.setHorizontalScrollBarEnabled(false);
            int iIntValue2 = bhu.am(10, recyclerView.getContext()).intValue();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(0);
            bve bveVar = new bve();
            bveVar.a = iIntValue2;
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.cu(bveVar);
            ea eaVar = new ea(recyclerView.getContext());
            eaVar.f = new h(23);
            ws wsVar = new ws(6);
            wx wxVar = new wx(i2);
            bep bepVar = new bep(25);
            Class<ViewGroup.LayoutParams> clsBf4 = cnf.bf(dal.b(cls));
            ((LinkedHashSet) eaVar.c).add(new daa(new erp(new io(clsBf4 != null ? clsBf4 : ViewGroup.LayoutParams.class, bepVar, wsVar), 28), new byx(eaVar, new byx(wxVar, i3))));
            cyt cytVar = new cyt(eaVar);
            recyclerView.setAdapter(cytVar);
            m = cytVar;
            recyclerView.setAdapter(cytVar);
            a.getClass();
            cyt cytVar2 = m;
            bzo.n(cytVar2);
            bqx bqxVar = new bqx(new xe(recyclerView, l, cytVar2));
            RecyclerView recyclerView2 = bqxVar.s;
            if (recyclerView2 != recyclerView) {
                bqt bqtVar = bqxVar.aa;
                if (recyclerView2 != null) {
                    recyclerView2.em(bqxVar);
                    RecyclerView recyclerView3 = bqxVar.s;
                    recyclerView3.aa.remove(bqtVar);
                    if (recyclerView3.ab == bqtVar) {
                        recyclerView3.ab = null;
                    }
                    ArrayList arrayList2 = bqxVar.s.am;
                    if (arrayList2 != null) {
                        arrayList2.remove(bqxVar);
                    }
                    ArrayList arrayList3 = bqxVar.q;
                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                        bqu bquVar = (bqu) arrayList3.get(0);
                        bquVar.g.cancel();
                        czx czxVar = bquVar.e;
                        bqxVar.n.getClass();
                        xe.g(czxVar);
                    }
                    arrayList3.clear();
                    bqxVar.x = null;
                    VelocityTracker velocityTracker = bqxVar.u;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        bqxVar.u = null;
                    }
                    bqw bqwVar = bqxVar.z;
                    if (bqwVar != null) {
                        bqwVar.a = false;
                        bqxVar.z = null;
                    }
                    if (bqxVar.y != null) {
                        bqxVar.y = null;
                    }
                }
                bqxVar.s = recyclerView;
                Resources resources = recyclerView.getResources();
                bqxVar.g = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                bqxVar.h = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                bqxVar.r = ViewConfiguration.get(bqxVar.s.getContext()).getScaledTouchSlop();
                bqxVar.s.cu(bqxVar);
                bqxVar.s.aa.add(bqtVar);
                RecyclerView recyclerView4 = bqxVar.s;
                if (recyclerView4.am == null) {
                    recyclerView4.am = new ArrayList();
                }
                recyclerView4.am.add(bqxVar);
                bqxVar.z = new bqw(bqxVar);
                bqxVar.y = new GestureDetector(bqxVar.s.getContext(), bqxVar.z);
            }
            if (linkedHashMap2.size() != size) {
                throw new cth(bjs.o("Performers are not allowed to appear in ", name, " DSL creation process."));
            }
            Class<RecyclerView> clsBf5 = cnf.bf(dal.b(cls2));
            blr.i(blrVarI, null, clsBf5 != null ? clsBf5 : RecyclerView.class);
            blr.h(blrVarI, viewH);
            linearLayout.addView(bluVar.k(), 0);
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final boolean q() {
        return j;
    }
}
