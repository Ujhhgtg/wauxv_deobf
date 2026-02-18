package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class us implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ us(int i) {
        this.a = i;
    }

    private final Object b(Object obj) {
        bag bagVar = (bag) obj;
        String[] strArr = {cnb.z(-48872432859946L)};
        bagVar.getClass();
        bagVar.a = la.ab(strArr);
        zb zbVar = new zb();
        azl azlVar = new azl();
        azi aziVar = new azi();
        String strZ = cnb.z(-48696339200810L);
        dne dneVar = dne.Equals;
        aziVar.a = new dnf(strZ, dneVar, false);
        azlVar.e(aziVar);
        azi aziVar2 = new azi();
        aziVar2.a = new dnf(cnb.z(-48679159331626L), dneVar, false);
        azlVar.e(aziVar2);
        zbVar.e = azlVar;
        bagVar.b = zbVar;
        return ens.a;
    }

    private final Object c(Object obj) {
        Class cls;
        bah bahVar = (bah) obj;
        cdj cdjVar = new cdj();
        cdjVar.s(cnb.z(-50289772067626L));
        cls = View.class;
        Class<View> clsBf = cnf.bf(dal.b(cls));
        cdjVar.q(clsBf != null ? clsBf : View.class);
        bahVar.getClass();
        bahVar.d = cdjVar;
        return ens.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object d(Object obj) throws IllegalAccessException {
        Object objX;
        Object objX2;
        int iIntValue;
        Object objX3;
        Object objX4;
        bmm bmmVar = (bmm) obj;
        LinkedHashSet<bnc> linkedHashSet = wr.b;
        if (cnb.ab(ewk.d) || cnb.ac(ewh.d)) {
            bmmVar.getClass();
            try {
                objX = bmmVar.d()[0];
                if (objX == null) {
                    objX = null;
                }
            } catch (Throwable th) {
                objX = bhu.x(th);
            }
            if (objX instanceof dcx) {
                objX = null;
            }
            bzo.n(objX);
            try {
                objX2 = bmmVar.d()[2];
                if (objX2 == null) {
                    objX2 = null;
                }
            } catch (Throwable th2) {
                objX2 = bhu.x(th2);
            }
            Integer num = (Integer) (objX2 instanceof dcx ? null : objX2);
            iIntValue = num != null ? num.intValue() : 0;
            int i = bte.a;
            azg azgVarR = dqc.bi(objX).r();
            azgVarR.a = dal.b(View.class);
            Object objE = ((azk) yg.e(azgVarR)).e();
            bzo.n(objE);
            View view = (View) objE;
            Object tag = view.getTag();
            azg azgVarAa = dkz.aa(bmmVar);
            xr.a.getClass();
            azgVarAa.a = emn.az(xq.a);
            Object objD = ((azk) aaz.e(azgVarAa.c())).d();
            bzo.n(objD);
            azg azgVarR2 = dqc.bi(bmmVar.e()).r();
            xv.a.getClass();
            azgVarR2.a = emn.az(xu.a);
            Object objD2 = ((azk) aaz.e(azgVarR2.c())).d();
            bzo.n(objD2);
            cde cdeVarT = dqc.bi(objD2).t();
            cdeVarT.ab = cnb.z(-49624052136746L);
            Object objE2 = ((cdk) aaz.e(cdeVarT.aj())).e(Integer.valueOf(iIntValue));
            bzo.n(objE2);
            MsgInfoBean msgInfoBean = new MsgInfoBean(objE2);
            for (bnc bncVar : linkedHashSet) {
                try {
                    bncVar.i(view, tag, objD, msgInfoBean);
                } catch (Exception e) {
                    ArrayList arrayList = ewq.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(cnb.z(-49589692398378L));
                    ewq.e(yg.n(sb, bncVar instanceof doo ? ((doo) bncVar).f() : cnb.z(-49572512529194L), -49533857823530L), e, 12);
                }
            }
        } else {
            bmmVar.getClass();
            try {
                objX3 = bmmVar.d()[0];
                if (objX3 == null) {
                    objX3 = null;
                }
            } catch (Throwable th3) {
                objX3 = bhu.x(th3);
            }
            if (objX3 instanceof dcx) {
                objX3 = null;
            }
            bzo.n(objX3);
            try {
                objX4 = bmmVar.d()[1];
                if (objX4 == null) {
                    objX4 = null;
                }
            } catch (Throwable th4) {
                objX4 = bhu.x(th4);
            }
            Integer num2 = (Integer) (objX4 instanceof dcx ? null : objX4);
            iIntValue = num2 != null ? num2.intValue() : 0;
            int i2 = bte.a;
            azg azgVarR3 = dqc.bi(objX3).r();
            azgVarR3.a = dal.b(View.class);
            Object objE3 = ((azk) yg.e(azgVarR3)).e();
            bzo.n(objE3);
            View view2 = (View) objE3;
            Object tag2 = view2.getTag();
            azg azgVarAa2 = dkz.aa(bmmVar);
            xr.a.getClass();
            azgVarAa2.a = emn.az(xq.a);
            Object objD3 = ((azk) aaz.e(azgVarAa2.c())).d();
            bzo.n(objD3);
            cde cdeVarT2 = dqc.bi(bmmVar.e()).t();
            cdeVarT2.ab = cnb.z(-49499498085162L);
            Object objE4 = ((cdk) aaz.e(cdeVarT2.aj())).e(Integer.valueOf(iIntValue));
            bzo.n(objE4);
            MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE4);
            for (bnc bncVar2 : linkedHashSet) {
                try {
                    bncVar2.i(view2, tag2, objD3, msgInfoBean2);
                } catch (Exception e2) {
                    ArrayList arrayList2 = ewq.a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cnb.z(-50014894160682L));
                    ewq.e(yg.n(sb2, bncVar2 instanceof doo ? ((doo) bncVar2).f() : cnb.z(-49928994814762L), -49907519978282L), e2, 12);
                }
            }
        }
        return ens.a;
    }

    private final Object e(Object obj) {
        ((amm) obj).c = new us(26);
        return ens.a;
    }

    private final Object f(Object obj) {
        bah bahVar = (bah) obj;
        cdj cdjVar = new cdj();
        cdjVar.t((cnb.ab(ewk.d) || cnb.ac(ewh.d)) ? cnb.z(-49873160239914L) : cnb.z(-49778670959402L), cnb.z(-38083475012394L));
        cdj.k(cdjVar, cnb.z(-38010460568362L));
        bahVar.getClass();
        bahVar.d = cdjVar;
        return ens.a;
    }

    private final Object g(Object obj) {
        ((amm) obj).b = new us(29);
        return ens.a;
    }

    private final Object h(Object obj) {
        ((amm) obj).c = new ws(0);
        return ens.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Object obj2;
        Drawable drawable;
        boolean zIsAssignableFrom;
        Drawable drawable2;
        boolean zIsAssignableFrom2;
        Object objX;
        Object objX2;
        Object objX3;
        Object obj3;
        Object objE;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        Object objX8;
        int i = this.a;
        cdy cdyVar = cdy.d;
        int i2 = 9;
        int i3 = 22;
        int i4 = 21;
        char c = 3;
        int i5 = 1;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bmm bmmVar = (bmm) obj;
                int i6 = bte.a;
                azg azgVarAa = dkz.aa(bmmVar);
                azgVarAa.a = cnb.z(-576625129290538L);
                Object objE2 = ((azk) aaz.e(azgVarAa.c())).e();
                bzo.n(objE2);
                View view = (ListView) objE2;
                azg azgVarAa2 = dkz.aa(bmmVar);
                abf.ao(azgVarAa2.ae, (cdy[]) Arrays.copyOf(new cdy[]{cdyVar}, 1));
                boolean z = false;
                Object obj4 = null;
                for (Object obj5 : azgVarAa2.c()) {
                    Object objD = ((azk) obj5).d();
                    if (objD == null) {
                        zIsAssignableFrom = false;
                    } else {
                        zc zcVarB = dal.b(objD.getClass());
                        zc zcVarB2 = dal.b(BaseAdapter.class);
                        ConcurrentHashMap concurrentHashMap = zf.a;
                        zIsAssignableFrom = cnf.bd(zcVarB2).isAssignableFrom(cnf.bd(zcVarB));
                    }
                    if (zIsAssignableFrom) {
                        if (z) {
                            throw new IllegalArgumentException(cnb.z(-578016698694442L));
                        }
                        obj4 = obj5;
                        z = true;
                    }
                }
                if (!z) {
                    throw new NoSuchElementException(cnb.z(-577827720133418L));
                }
                Object objE3 = ((azk) obj4).e();
                bzo.n(objE3);
                BaseAdapter baseAdapter = (BaseAdapter) objE3;
                ViewParent parent = view.getParent();
                bzo.o(parent, cnb.z(-578124072876842L));
                RelativeLayout relativeLayout = (RelativeLayout) parent;
                relativeLayout.removeView(view);
                LinearLayout linearLayout = new LinearLayout(relativeLayout.getContext());
                linearLayout.setLayoutParams(view.getLayoutParams());
                linearLayout.setOrientation(0);
                ScrollView scrollView = new ScrollView(linearLayout.getContext());
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) cnh.r(Integer.valueOf(vc.a.k()), scrollView.getContext()), -1);
                scrollView.setPadding(0, (int) cnh.r(Integer.valueOf(vf.a.k()), scrollView.getContext()), 0, (int) cnh.r(56, scrollView.getContext()));
                if (cnh.aa(scrollView.getContext())) {
                    scrollView.setBackgroundColor(Color.parseColor(va.a.o()));
                } else {
                    scrollView.setBackgroundColor(Color.parseColor(vb.a.o()));
                }
                scrollView.setLayoutParams(layoutParams);
                ckj ckjVar = new ckj(aqu.e(cnf.am(scrollView.getContext())));
                ckjVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ckjVar.setLabelVisibilityMode(1);
                if (cnh.aa(ckjVar.getContext())) {
                    ckjVar.setBackgroundColor(Color.parseColor(va.a.o()));
                    ckjVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(uv.a.o())));
                    ckjVar.setItemIconTintList(emc.ai(Color.parseColor(uy.a.o())));
                    ckjVar.setItemTextColor(emc.ai(Color.parseColor(vd.a.o())));
                } else {
                    ckjVar.setBackgroundColor(Color.parseColor(vb.a.o()));
                    ckjVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(uw.a.o())));
                    ckjVar.setItemIconTintList(emc.ai(Color.parseColor(uz.a.o())));
                    ckjVar.setItemTextColor(emc.ai(Color.parseColor(ve.a.o())));
                }
                ckjVar.setOnItemSelectedListener(new ut(baseAdapter, view));
                ckjVar.getMenu().clear();
                biw.a.getClass();
                for (biv bivVar : aaz.u(7, biw.f())) {
                    biw.a.getClass();
                    File file = new File(biw.c, bivVar.d);
                    if (file.exists()) {
                        drawable = new BitmapDrawable(ckjVar.getContext().getResources(), BitmapFactory.decodeFile(file.getAbsolutePath()));
                    } else {
                        drawable = ckjVar.getContext().getDrawable(R.drawable.ic_chat_group_24dp);
                        bzo.n(drawable);
                    }
                    Menu menu = ckjVar.getMenu();
                    int i7 = bivVar.c;
                    menu.add(0, i7, i7, bivVar.b).setIcon(drawable);
                }
                biw.a.getClass();
                Iterator it = biw.f().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (bzo.f(((biv) next).b, ux.a.o())) {
                            obj2 = next;
                        }
                    } else {
                        obj2 = null;
                    }
                }
                biv bivVar2 = (biv) obj2;
                ckjVar.setSelectedItemId(bivVar2 != null ? bivVar2.c : 0);
                scrollView.addView(ckjVar);
                linearLayout.addView(scrollView);
                linearLayout.addView(view);
                relativeLayout.addView(linearLayout);
                return ensVar;
            case 1:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdj.l(cdjVar, cnb.z(-577252194515754L));
                cdjVar.t(cnb.z(-577690281179946L), cnb.z(-577621561703210L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 2:
                View view2 = (View) obj;
                View viewK = dkz.k(view2, R.layout.module_dialog_chat_group_tab, null, false);
                int i8 = R.id.moduleDialogCbChatGroupTabShowIcon;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbChatGroupTabShowIcon);
                if (materialCheckBox != null) {
                    i8 = R.id.moduleDialogEdtChatGroupTabIndicatorDarkColor;
                    TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabIndicatorDarkColor);
                    if (textInputEditText != null) {
                        i8 = R.id.moduleDialogEdtChatGroupTabIndicatorLightColor;
                        TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabIndicatorLightColor);
                        if (textInputEditText2 != null) {
                            i8 = R.id.moduleDialogEdtChatGroupTabNormalDarkColor;
                            TextInputEditText textInputEditText3 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabNormalDarkColor);
                            if (textInputEditText3 != null) {
                                i8 = R.id.moduleDialogEdtChatGroupTabNormalLightColor;
                                TextInputEditText textInputEditText4 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabNormalLightColor);
                                if (textInputEditText4 != null) {
                                    i8 = R.id.moduleDialogEdtChatGroupTabSelectedDarkColor;
                                    TextInputEditText textInputEditText5 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabSelectedDarkColor);
                                    if (textInputEditText5 != null) {
                                        i8 = R.id.moduleDialogEdtChatGroupTabSelectedLightColor;
                                        TextInputEditText textInputEditText6 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabSelectedLightColor);
                                        if (textInputEditText6 != null) {
                                            i8 = R.id.moduleDialogEdtChatGroupTabTabDarkColor;
                                            TextInputEditText textInputEditText7 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabTabDarkColor);
                                            if (textInputEditText7 != null) {
                                                i8 = R.id.moduleDialogEdtChatGroupTabTabLightColor;
                                                TextInputEditText textInputEditText8 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtChatGroupTabTabLightColor);
                                                if (textInputEditText8 != null) {
                                                    i8 = R.id.moduleDialogInputChatGroupTabIndicatorDarkColor;
                                                    if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabIndicatorDarkColor)) != null) {
                                                        i8 = R.id.moduleDialogInputChatGroupTabIndicatorLightColor;
                                                        if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabIndicatorLightColor)) != null) {
                                                            i8 = R.id.moduleDialogInputChatGroupTabNormalDarkColor;
                                                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabNormalDarkColor)) != null) {
                                                                i8 = R.id.moduleDialogInputChatGroupTabNormalLightColor;
                                                                if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabNormalLightColor)) != null) {
                                                                    i8 = R.id.moduleDialogInputChatGroupTabSelectedDarkColor;
                                                                    if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabSelectedDarkColor)) != null) {
                                                                        i8 = R.id.moduleDialogInputChatGroupTabSelectedLightColor;
                                                                        if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabSelectedLightColor)) != null) {
                                                                            i8 = R.id.moduleDialogInputChatGroupTabTabDarkColor;
                                                                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabTabDarkColor)) != null) {
                                                                                i8 = R.id.moduleDialogInputChatGroupTabTabLightColor;
                                                                                if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputChatGroupTabTabLightColor)) != null) {
                                                                                    LinearLayout linearLayout2 = (LinearLayout) viewK;
                                                                                    cej cejVar = new cej(linearLayout2, materialCheckBox, textInputEditText, textInputEditText2, textInputEditText3, textInputEditText4, textInputEditText5, textInputEditText6, textInputEditText7, textInputEditText8);
                                                                                    textInputEditText8.setText(vr.a.o());
                                                                                    textInputEditText2.setText(vk.a.o());
                                                                                    textInputEditText4.setText(vm.a.o());
                                                                                    textInputEditText6.setText(vo.a.o());
                                                                                    textInputEditText7.setText(vq.a.o());
                                                                                    textInputEditText.setText(vj.a.o());
                                                                                    textInputEditText3.setText(vl.a.o());
                                                                                    textInputEditText5.setText(vn.a.o());
                                                                                    materialCheckBox.setChecked(vp.a.i());
                                                                                    bzy bzyVar = new bzy(view2.getContext());
                                                                                    eg egVar = (eg) bzyVar.d;
                                                                                    vt.a.getClass();
                                                                                    egVar.d = vt.c;
                                                                                    bzyVar.t(cnb.z(-568383087049514L), new amw(new bp(cejVar, 8), 0));
                                                                                    bzyVar.s(cnb.z(-568404561885994L), new amw(new h(i4), 2));
                                                                                    bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                                                                                    if (linearLayout2 != null) {
                                                                                        egVar.r = linearLayout2;
                                                                                    }
                                                                                    bzyVar.i().show();
                                                                                    return ensVar;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-638575737568042L).concat(viewK.getResources().getResourceName(i8)));
            case 3:
                bmm bmmVar2 = (bmm) obj;
                int i9 = bte.a;
                azg azgVarAa3 = dkz.aa(bmmVar2);
                azgVarAa3.a = cnb.z(-567515503655722L);
                Object objE4 = ((azk) aaz.e(azgVarAa3.c())).e();
                bzo.n(objE4);
                ListView listView = (ListView) objE4;
                azg azgVarAa4 = dkz.aa(bmmVar2);
                abf.ao(azgVarAa4.ae, (cdy[]) Arrays.copyOf(new cdy[]{cdyVar}, 1));
                Object[] objArr = false;
                Object obj6 = null;
                for (Object obj7 : azgVarAa4.c()) {
                    Object objD2 = ((azk) obj7).d();
                    if (objD2 == null) {
                        zIsAssignableFrom2 = false;
                    } else {
                        zc zcVarB3 = dal.b(objD2.getClass());
                        zc zcVarB4 = dal.b(BaseAdapter.class);
                        ConcurrentHashMap concurrentHashMap2 = zf.a;
                        zIsAssignableFrom2 = cnf.bd(zcVarB4).isAssignableFrom(cnf.bd(zcVarB3));
                    }
                    if (zIsAssignableFrom2) {
                        if (objArr == true) {
                            throw new IllegalArgumentException(cnb.z(-567807561431850L));
                        }
                        obj6 = obj7;
                        objArr = true;
                    }
                }
                if (objArr != true) {
                    throw new NoSuchElementException(cnb.z(-569267850312490L));
                }
                Object objE5 = ((azk) obj6).e();
                bzo.n(objE5);
                BaseAdapter baseAdapter2 = (BaseAdapter) objE5;
                TabLayout tabLayout = new TabLayout(aqu.e(cnf.am(listView.getContext())), null);
                tabLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                tabLayout.setTabMode(2);
                tabLayout.setTabGravity(1);
                tabLayout.setTabRippleColor(emc.ai(0));
                tabLayout.setInlineLabel(true);
                if (cnh.aa(tabLayout.getContext())) {
                    tabLayout.setBackgroundColor(Color.parseColor(vq.a.o()));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor(vj.a.o()));
                    vl vlVar = vl.a;
                    tabLayout.setTabTextColors(TabLayout.aq(Color.parseColor(vlVar.o()), Color.parseColor(vn.a.o())));
                    tabLayout.setTabIconTint(emc.ai(Color.parseColor(vlVar.o())));
                } else {
                    tabLayout.setBackgroundColor(Color.parseColor(vr.a.o()));
                    tabLayout.setSelectedTabIndicatorColor(Color.parseColor(vk.a.o()));
                    vm vmVar = vm.a;
                    tabLayout.setTabTextColors(TabLayout.aq(Color.parseColor(vmVar.o()), Color.parseColor(vo.a.o())));
                    tabLayout.setTabIconTint(emc.ai(Color.parseColor(vmVar.o())));
                }
                vs vsVar = new vs(baseAdapter2, listView);
                ArrayList arrayList = tabLayout.am;
                if (!arrayList.contains(vsVar)) {
                    arrayList.add(vsVar);
                }
                biw.a.getClass();
                for (biv bivVar3 : biw.f()) {
                    if (vp.a.i()) {
                        biw.a.getClass();
                        File file2 = new File(biw.c, bivVar3.d);
                        if (file2.exists()) {
                            drawable2 = new BitmapDrawable(tabLayout.getContext().getResources(), BitmapFactory.decodeFile(file2.getAbsolutePath()));
                        } else {
                            drawable2 = tabLayout.getContext().getDrawable(R.drawable.ic_chat_group_24dp);
                            bzo.n(drawable2);
                        }
                    } else {
                        drawable2 = null;
                    }
                    dpl dplVarAw = tabLayout.aw();
                    dplVarAw.a = drawable2;
                    TabLayout tabLayout2 = dplVarAw.e;
                    if (tabLayout2.aa == 1 || tabLayout2.ad == 2) {
                        tabLayout2.ba(true);
                    }
                    dpn dpnVar = dplVarAw.f;
                    if (dpnVar != null) {
                        dpnVar.p();
                    }
                    String str = bivVar3.b;
                    if (TextUtils.isEmpty(null) && !TextUtils.isEmpty(str)) {
                        dplVarAw.f.setContentDescription(str);
                    }
                    dplVarAw.b = str;
                    dpn dpnVar2 = dplVarAw.f;
                    if (dpnVar2 != null) {
                        dpnVar2.p();
                    }
                    tabLayout.ar(dplVarAw, tabLayout.c.isEmpty());
                }
                listView.addHeaderView(tabLayout);
                return ensVar;
            case 4:
                ((amm) obj).c = new us(5);
                return ensVar;
            case 5:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdj.l(cdjVar2, cnb.z(-569031627111210L));
                cdjVar2.t(cnb.z(-569400994298666L), cnb.z(-569332274821930L));
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ensVar;
            case 6:
                View view3 = (View) obj;
                wh whVar = wh.a;
                View viewK2 = dkz.k(view3, R.layout.module_dialog_chat_input_hint, null, false);
                int i10 = R.id.moduleDialogCbChatInputHintHandleSendCount;
                MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) cnd.aq(viewK2, R.id.moduleDialogCbChatInputHintHandleSendCount);
                if (materialCheckBox2 != null) {
                    i10 = R.id.moduleDialogEdtChatInputHintTip;
                    TextInputEditText textInputEditText9 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtChatInputHintTip);
                    if (textInputEditText9 != null) {
                        i10 = R.id.moduleDialogInputChatInputHintTip;
                        if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputChatInputHintTip)) != null) {
                            i10 = R.id.moduleDialogTvChatInputHintPreview;
                            MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewK2, R.id.moduleDialogTvChatInputHintPreview);
                            if (materialTextView != null) {
                                i10 = R.id.moduleDialogTvChatInputHintTextPlaceholders;
                                MaterialTextView materialTextView2 = (MaterialTextView) cnd.aq(viewK2, R.id.moduleDialogTvChatInputHintTextPlaceholders);
                                if (materialTextView2 != null) {
                                    bqr bqrVar = new bqr((LinearLayout) viewK2, materialCheckBox2, textInputEditText9, materialTextView, materialTextView2);
                                    vz vzVar = vz.a;
                                    String strO = vzVar.o();
                                    whVar.getClass();
                                    materialTextView.setText(wh.l(strO));
                                    textInputEditText9.setText(vzVar.o());
                                    textInputEditText9.addTextChangedListener(new wg(bqrVar, i));
                                    materialCheckBox2.setChecked(vy.a.i());
                                    materialTextView2.setMovementMethod(LinkMovementMethod.getInstance());
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cnb.z(-423019918916394L));
                                    for (String str2 : wh.b) {
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (str2 + ' '));
                                        spannableStringBuilder.setSpan(new wf(bqrVar, str2, 0), length, spannableStringBuilder.length() - 1, 33);
                                        c = c;
                                    }
                                    materialTextView2.setText(spannableStringBuilder);
                                    bzy bzyVar2 = new bzy(view3.getContext());
                                    eg egVar2 = (eg) bzyVar2.d;
                                    egVar2.d = wh.d;
                                    bzyVar2.t(cnb.z(-422951199439658L), new amw(new bp(bqrVar, i2), 0));
                                    bzyVar2.s(cnb.z(-422955494406954L), new amw(new h(i3), 2));
                                    bjs.x((c & 2) != 0 ? new amd(i5) : null, bzyVar2, cnb.z(-47455093652266L));
                                    LinearLayout linearLayout3 = bqrVar.b;
                                    if (linearLayout3 != null) {
                                        egVar2.r = linearLayout3;
                                    }
                                    bzyVar2.i().show();
                                    return ensVar;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-637888542800682L).concat(viewK2.getResources().getResourceName(i10)));
            case 7:
                ((amm) obj).c = new us(i2);
                return ensVar;
            case 8:
                bmm bmmVar3 = (bmm) obj;
                bmmVar3.getClass();
                try {
                    objX = bmmVar3.d()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Boolean bool = (Boolean) (objX instanceof dcx ? null : objX);
                if (!(bool != null ? bool.booleanValue() : false)) {
                    int i11 = bte.a;
                    cde cdeVarT = dqc.bi(bmmVar3.e()).t();
                    cdeVarT.ab = cnb.z(-422835235322666L);
                    cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
                    wh whVar2 = wh.a;
                    String strO2 = vz.a.o();
                    whVar2.getClass();
                    cdkVar.e(wh.l(strO2));
                }
                return ensVar;
            case 9:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                uq.a.getClass();
                cdjVar3.o(ajn.ag(cnb.z(-75127567940394L)));
                cdjVar3.t(cnb.z(-422800875584298L), cnb.z(-423299091790634L));
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 10:
                bah bahVar4 = (bah) obj;
                String[] strArr = {cnb.z(-52514565126954L)};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr);
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-51788715653930L), cnb.z(-51745765980970L));
                bahVar4.d = cdjVar4;
                return ensVar;
            case 11:
                bmm bmmVar4 = (bmm) obj;
                bmmVar4.getClass();
                try {
                    objX2 = bmmVar4.d()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                Object obj8 = objX2 instanceof dcx ? null : objX2;
                bzo.n(obj8);
                int i12 = bte.a;
                azg azgVarR = dqc.bi(obj8).r();
                azgVarR.a = dal.b(Context.class);
                Object objE6 = ((azk) aaz.e(azgVarR.c())).e();
                bzo.n(objE6);
                Resources resources = ((Context) objE6).getResources();
                if (resources != null) {
                    cnf.bi(resources);
                }
                dov dovVar = new dov(new wi(obj8, i));
                try {
                    objX3 = bmmVar4.d()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                obj3 = objX3 instanceof dcx ? null : objX3;
                bzo.n(obj3);
                Object tag = ((View) obj3).getTag();
                cde cdeVarT2 = dqc.bi(tag).t();
                cdeVarT2.a = dal.b(Integer.TYPE);
                cdeVarT2.y();
                cdeVarT2.ah();
                Integer num = (Integer) ((cdk) aaz.e(cdeVarT2.aj())).j(new Object[0]);
                if (cnb.ab(ewk.p) || cnb.ac(ewh.s)) {
                    cde cdeVarT3 = dqc.bi(tag).t();
                    cge.a.getClass();
                    cdeVarT3.a = emn.az(cgd.a);
                    cdeVarT3.g = 0;
                    objE = ((cdk) dkz.m(cdeVarT3)).e(new Object[0]);
                    bzo.n(objE);
                } else {
                    azg azgVarR2 = dqc.bi(tag).r();
                    cge.a.getClass();
                    azgVarR2.a = emn.az(cgd.a);
                    objE = ((azk) yg.e(azgVarR2)).d();
                    bzo.n(objE);
                }
                MsgInfoBean msgInfoBean = new MsgInfoBean(objE);
                for (bna bnaVar : wm.b) {
                    try {
                        for (wj wjVar : bnaVar.l(msgInfoBean)) {
                            cdk cdkVarD = ((cdk) dovVar.getValue()).d();
                            cdkVarD.h(obj8);
                            cdkVarD.e(num, Integer.valueOf(wjVar.a), 0, wjVar.b, Integer.valueOf(wjVar.c));
                        }
                    } catch (Exception e) {
                        ArrayList arrayList2 = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cnb.z(-52308406696746L));
                        ewq.e(yg.n(sb, bnaVar instanceof doo ? ((doo) bnaVar).f() : cnb.z(-52261162056490L), -52772263164714L), e, 12);
                    }
                }
                return ensVar;
            case 12:
                bmm bmmVar5 = (bmm) obj;
                int i13 = bte.a;
                azg azgVarAa5 = dkz.aa(bmmVar5);
                azgVarAa5.b = new us(13);
                Object objE7 = ((azk) aaz.e(azgVarAa5.c())).e();
                bzo.n(objE7);
                azg azgVarR3 = dqc.bi((View.OnLongClickListener) objE7).r();
                xr.a.getClass();
                xq xqVar = xq.a;
                azgVarR3.a = emn.az(xqVar);
                Object objD3 = ((azk) yg.e(azgVarR3)).d();
                bzo.n(objD3);
                azg azgVarR4 = dqc.bi(objD3).r();
                gp.a.getClass();
                go goVar = go.a;
                azgVarR4.a = emn.bb(goVar).getDeclaringClass();
                Object objD4 = ((azk) aaz.e(azgVarR4.c())).d();
                bzo.n(objD4);
                xz.a.getClass();
                azg azgVarR5 = dqc.bi(gp.b((Class) la.p(emn.az(xy.a).getInterfaces()), objD4)).r();
                azgVarR5.a = emn.az(xqVar);
                Object objD5 = ((azk) yg.e(azgVarR5)).d();
                bzo.n(objD5);
                azg azgVarR6 = dqc.bi(objD5).r();
                azgVarR6.a = emn.bb(goVar).getDeclaringClass();
                Object objD6 = ((azk) aaz.e(azgVarR6.c())).d();
                bzo.n(objD6);
                xv.a.getClass();
                Object objB = gp.b((Class) la.p(emn.az(xu.a).getInterfaces()), objD6);
                try {
                    objX4 = bmmVar5.d()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                obj3 = objX4 instanceof dcx ? null : objX4;
                bzo.n(obj3);
                MenuItem menuItem = (MenuItem) obj3;
                cde cdeVarT4 = dqc.bi(objB).t();
                cdeVarT4.ab = cnb.z(-52737903426346L);
                Object objE8 = ((cdk) aaz.e(cdeVarT4.aj())).e(Integer.valueOf(menuItem.getGroupId()));
                bzo.n(objE8);
                MsgInfoBean msgInfoBean2 = new MsgInfoBean(objE8);
                for (bna bnaVar2 : wm.b) {
                    try {
                        for (wj wjVar2 : bnaVar2.l(msgInfoBean2)) {
                            if (menuItem.getItemId() == wjVar2.a) {
                                wjVar2.d.g(objD3, msgInfoBean2);
                            }
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList3 = ewq.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(cnb.z(-52703543687978L));
                        ewq.e(yg.n(sb2, bnaVar2 instanceof doo ? ((doo) bnaVar2).f() : cnb.z(-52587579570986L), -52548924865322L), e2, 12);
                    }
                }
                return ensVar;
            case 13:
                zc zcVarB5 = dal.b(View.OnLongClickListener.class);
                ConcurrentHashMap concurrentHashMap3 = zf.a;
                return Boolean.valueOf(cnf.bd(zcVarB5).isAssignableFrom((Class) obj));
            case 14:
                ((amm) obj).c = new us(10);
                return ensVar;
            case 15:
                ((amm) obj).c = new us(16);
                return ensVar;
            case 16:
                bah bahVar5 = (bah) obj;
                String[] strArr2 = {cnb.z(-52205327481642L)};
                bahVar5.getClass();
                bahVar5.a = la.ab(strArr2);
                cdj cdjVar5 = new cdj();
                cdjVar5.t(cnb.z(-52029233822506L), cnb.z(-51986284149546L));
                bahVar5.d = cdjVar5;
                return ensVar;
            case 17:
                bmm bmmVar6 = (bmm) obj;
                bmmVar6.getClass();
                try {
                    objX5 = bmmVar6.d()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                obj3 = objX5 instanceof dcx ? null : objX5;
                bzo.n(obj3);
                ViewGroup viewGroup = (ViewGroup) obj3;
                for (bnb bnbVar : wp.b) {
                    try {
                        bnbVar.a(viewGroup);
                    } catch (Exception e3) {
                        ArrayList arrayList4 = ewq.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cnb.z(-49267569851178L));
                        ewq.e(yg.n(sb3, bnbVar instanceof doo ? ((doo) bnbVar).f() : cnb.z(-48597554953002L), -48576080116522L), e3, 12);
                    }
                }
                return ensVar;
            case 18:
                bmm bmmVar7 = (bmm) obj;
                bmmVar7.getClass();
                try {
                    objX6 = bmmVar7.d()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                Object obj9 = objX6 instanceof dcx ? null : objX6;
                bzo.n(obj9);
                int i14 = bte.a;
                azg azgVarR7 = dqc.bi(obj9).r();
                azgVarR7.ab = cnb.z(-48541720378154L);
                Object objE9 = ((azk) yg.e(azgVarR7)).e();
                bzo.n(objE9);
                ViewGroup viewGroup2 = (ViewGroup) objE9;
                try {
                    objX7 = bmmVar7.d()[1];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = bhu.x(th7);
                }
                Object obj10 = objX7 instanceof dcx ? null : objX7;
                bzo.n(obj10);
                try {
                    objX8 = bmmVar7.d()[3];
                    if (objX8 == null) {
                        objX8 = null;
                    }
                } catch (Throwable th8) {
                    objX8 = bhu.x(th8);
                }
                obj3 = objX8 instanceof dcx ? null : objX8;
                bzo.n(obj3);
                MsgInfoBean msgInfoBean3 = new MsgInfoBean(obj3);
                for (bnb bnbVar2 : wp.b) {
                    try {
                        bnbVar2.b(obj9, viewGroup2, obj10, msgInfoBean3);
                    } catch (Exception e4) {
                        ArrayList arrayList5 = ewq.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(cnb.z(-48455821032234L));
                        ewq.e(yg.n(sb4, bnbVar2 instanceof doo ? ((doo) bnbVar2).f() : cnb.z(-48395691490090L), -48906792598314L), e4, 12);
                    }
                }
                return ensVar;
            case 19:
                amm ammVar = (amm) obj;
                ammVar.b = new us(i3);
                ammVar.c = new us(23);
                return ensVar;
            case 20:
                ((amm) obj).c = new us(i4);
                return ensVar;
            case 21:
                bah bahVar6 = (bah) obj;
                String[] strArr3 = {cnb.z(-50259707296554L)};
                bahVar6.getClass();
                bahVar6.a = la.ab(strArr3);
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-50066433768234L), cnb.z(-50573239909162L));
                bahVar6.d = cdjVar6;
                return ensVar;
            case 22:
                return b(obj);
            case 23:
                return c(obj);
            case 24:
                return d(obj);
            case 25:
                return e(obj);
            case 26:
                return f(obj);
            case 27:
                return g(obj);
            case 28:
                return h(obj);
            default:
                bag bagVar = (bag) obj;
                String[] strArr4 = {cnb.z(-99626061396778L)};
                bagVar.getClass();
                bagVar.a = la.ab(strArr4);
                zb zbVar = new zb();
                zbVar.k(cnb.z(-99510097279786L), cnb.z(-99956773878570L));
                bagVar.b = zbVar;
                return ensVar;
        }
    }
}
