//
// Decompiled by Procyon - 4436ms
//
package me.hd.wauxv.obf;

import android.widget.Adapter;
import android.app.Dialog;
import android.widget.ListAdapter;
import java.util.LinkedHashMap;
import java.util.Iterator;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import java.util.Collection;
import android.widget.AdapterView$OnItemLongClickListener;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageView;
import android.content.Context;
import android.widget.LinearLayout$LayoutParams;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import android.view.ViewGroup;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
import android.app.Activity;
import android.widget.TextView;

public final class ws implements bgf
{
    public final int a;

    public ws(final int a) {
        this.a = a;
        super();
    }

    public final Object invoke(Object o) {
        final int a = this.a;
        final Class<TextView> clazz = TextView.class;
        Class<String> clazz2 = String.class;
        final amd amd = null;
        final Object o2 = null;
        final int n = 0;
        final ens a2 = ens.a;
        switch (a) {
            default: {
                final bah bah = (bah)o;
                final Object d = new Object();
                cdj.m((cdj)d, 8);
                Class<Boolean> clazz3 = Boolean.class;
                final Class bf = cnf.bf(dal.b((Class)Boolean.class));
                if (bf != null) {
                    clazz3 = bf;
                }
                ((cdj)d).r((Class)clazz3);
                final Class bf2 = cnf.bf(dal.b((Class)String.class));
                if (bf2 != null) {
                    clazz2 = bf2;
                }
                ((cdj)d).q(new Class[] { clazz2 });
                bah.getClass();
                bah.d = (cdj)d;
                return a2;
            }
            case 28: {
                final bag bag = (bag)o;
                final String z = cnb.z(-633524856027946L);
                bag.getClass();
                bag.a = la.ab((Object[])new String[] { z });
                final Object b = new Object();
                ((zb)b).k(new String[] { cnb.z(-633408891910954L), cnb.z(-633864158444330L) });
                bag.b = (zb)b;
                return a2;
            }
            case 27: {
                final amm amm = (amm)o;
                amm.b = (bgf)new ws(28);
                amm.c = (bgf)new ws(29);
                return a2;
            }
            case 26: {
                ((bmm)o).g();
                return a2;
            }
            case 25: {
                final bmm bmm = (bmm)o;
                bmm.getClass();
                Object x = null;
                try {
                    if ((o = bmm.d()[0]) == null) {}
                }
                finally {
                    final Throwable t;
                    x = bhu.x(t);
                }
                if (x instanceof dcx) {
                    x = null;
                }
                final Integer n2 = (Integer)x;
                int intValue;
                if (n2 != null) {
                    intValue = n2;
                }
                else {
                    intValue = 0;
                }
                if (intValue == 0 && ((akf)zq.a).i()) {
                    final int a3 = bte.a;
                    o = bmm.e();
                    final cde t2 = dqc.bi(o).t();
                    ((cbh)t2).ab = cnb.z(-523771261745962L);
                    o = dkz.m(t2);
                    o = ((cdk)o).j(new Object[0]);
                    bzo.n(o);
                    final Activity tag = (Activity)o;
                    o = bmm.f();
                    Object o3;
                    if ((o3 = o) == null) {
                        o3 = null;
                    }
                    bzo.n(o3);
                    final azg r = dqc.bi(o3).r();
                    r.a = dal.b((Class)TextView.class);
                    final Iterator iterator = r.c().iterator();
                    o = null;
                    int n3 = n;
                    while (iterator.hasNext()) {
                        final Object next = iterator.next();
                        final Object e = ((azk)next).e();
                        bzo.n(e);
                        final TextView textView = (TextView)e;
                        final int id = ((View)textView).getId();
                        final Integer u = cnh.u((Object)textView, cnb.z(-523741196974890L));
                        if (u != null) {
                            if (id == u) {
                                continue;
                            }
                        }
                        if (n3 != 0) {
                            o = new IllegalArgumentException(cnb.z(-523706837236522L));
                            throw o;
                        }
                        o = next;
                        n3 = 1;
                    }
                    if (n3 == 0) {
                        o = new NoSuchElementException(cnb.z(-525098406640426L));
                        throw o;
                    }
                    o = ((azk)o).e();
                    bzo.n(o);
                    final TextView textView2 = (TextView)o;
                    final WeakReference a4 = eki.a;
                    Label_0879: {
                        if (a4 != null) {
                            o = a4.get();
                            final Object o4 = o;
                            if (o4 != null) {
                                o = ((View)o4).getTag();
                                final boolean f = bzo.f(o, (Object)tag);
                                o = o2;
                                if (f) {
                                    o = o4;
                                }
                                if (o != null) {
                                    break Label_0879;
                                }
                            }
                        }
                        o = new eki(tag);
                        eki.a = new WeakReference((T)o);
                        ((View)o).setTag((Object)tag);
                        tag.addContentView((View)o, new ViewGroup$LayoutParams(-1, -1));
                    }
                    final h h = new h(24);
                    ((View)o).bringToFront();
                    o = new ekh((eki)o, textView2, h);
                    ((View)textView2).setOnTouchListener((View$OnTouchListener)o);
                }
                return a2;
            }
            case 24: {
                final View view = (View)o;
                final View k = dkz.k(view, 0x600c0086, (ViewGroup)null, false);
                int n4 = 0x600901b4;
                final MaterialCheckBox materialCheckBox = (MaterialCheckBox)cnd.aq(k, 0x600901b4);
                if (materialCheckBox != null) {
                    n4 = 0x600901b5;
                    final MaterialCheckBox materialCheckBox2 = (MaterialCheckBox)cnd.aq(k, 0x600901b5);
                    if (materialCheckBox2 != null) {
                        final LinearLayout r2 = (LinearLayout)k;
                        final cek cek = new cek(r2, materialCheckBox, materialCheckBox2, 0);
                        materialCheckBox2.setChecked(((akf)zq.a).i());
                        materialCheckBox.setChecked(((akf)zp.a).i());
                        final bzy bzy = new bzy(view.getContext());
                        final eg eg = (eg)((ek)bzy).d;
                        zr.a.getClass();
                        eg.d = zr.c;
                        ((ek)bzy).t(cnb.z(-523749786909482L), new amw((bfu)new bp((Object)cek, 12), 0));
                        final String z2 = cnb.z(-47455093652266L);
                        amd amd2 = amd;
                        if ((0x3 & 0x2) != 0x0) {
                            amd2 = new amd(1);
                        }
                        bjs.x(amd2, bzy, z2);
                        if (r2 != null) {
                            eg.r = (View)r2;
                        }
                        ((Dialog)bzy.i()).show();
                        return a2;
                    }
                }
                o = new NullPointerException(cnb.z(-638025981754154L).concat(k.getResources().getResourceName(n4)));
                throw o;
            }
            case 23: {
                return Modifier.isPublic(((Constructor)o).getModifiers());
            }
            case 22: {
                final yu yu = (yu)o;
                bzo.q((Object)yu, "it");
                o = yu.i.getValue();
                return ((aml)o).a;
            }
            case 21: {
                final bag bag2 = (bag)o;
                final String z3 = cnb.z(-98741298133802L);
                bag2.getClass();
                bag2.a = la.ab((Object[])new String[] { z3 });
                final Object b2 = new Object();
                ((zb)b2).k(new String[] { cnb.z(-97998268791594L), cnb.z(-97890894609194L) });
                bag2.b = (zb)b2;
                return a2;
            }
            case 20: {
                ((amm)o).b = (bgf)new ws(21);
                return a2;
            }
            case 19: {
                final bag bag3 = (bag)o;
                final String z4 = cnb.z(-97169340103466L);
                bag3.getClass();
                bag3.a = la.ab((Object[])new String[] { z4 });
                final Object b3 = new Object();
                ((zb)b3).k(new String[] { cnb.z(-98625334016810L), cnb.z(-98496484997930L) });
                bag3.b = (zb)b3;
                return a2;
            }
            case 18: {
                ((amm)o).b = (bgf)new ws(19);
                return a2;
            }
            case 17: {
                final bag bag4 = (bag)o;
                final Object b4 = new Object();
                String s;
                if (!cnb.isNewerThanArgVerAndNotPlay(ewk.d) && !cnb.isNewerThanArgVerAndPlay(ewh.d)) {
                    s = cnb.z(-96971771607850L);
                }
                else {
                    s = cnb.z(-97654671407914L);
                }
                ((zb)b4).k(new String[] { s, cnb.z(-96890167229226L) });
                bag4.getClass();
                bag4.b = (zb)b4;
                return a2;
            }
            case 16: {
                ((amm)o).b = (bgf)new ws(17);
                return a2;
            }
            case 15: {
                final bag bag5 = (bag)o;
                final Object b5 = new Object();
                ((zb)b5).k(new String[] { cnb.z(-76111115451178L), cnb.z(-76020921137962L) });
                bag5.getClass();
                bag5.b = (zb)b5;
                return a2;
            }
            case 14: {
                ((amm)o).b = (bgf)new ws(15);
                return a2;
            }
            case 13: {
                final bah bah2 = (bah)o;
                final String z5 = cnb.z(-379417410927402L);
                bah2.getClass();
                bah2.a = la.ab((Object[])new String[] { z5 });
                final Object d2 = new Object();
                ((cdj)d2).t(new String[] { cnb.z(-379851202624298L), cnb.z(-379761008311082L) });
                bah2.d = (cdj)d2;
                return a2;
            }
            case 12: {
                ((amm)o).c = (bgf)new ws(13);
                return a2;
            }
            case 11: {
                final bag bag6 = (bag)o;
                final Object b6 = new Object();
                ((zb)b6).k(new String[] { cnb.z(-100124277603114L), cnb.z(-100566659234602L) });
                bag6.getClass();
                bag6.b = (zb)b6;
                return a2;
            }
            case 10: {
                ((amm)o).b = (bgf)new ws(11);
                return a2;
            }
            case 9: {
                final bah bah3 = (bah)o;
                final Object d3 = new Object();
                Class<String> bf3;
                if ((bf3 = cnf.bf(dal.b((Class)String.class))) == null) {
                    bf3 = String.class;
                }
                final Class bf4 = cnf.bf(dal.b((Class)String.class));
                if (bf4 != null) {
                    clazz2 = bf4;
                }
                ((cdj)d3).q(new Class[] { bf3, clazz2 });
                o = new fj();
                final Object o5 = new Object();
                cdj.l((cdj)o5, cnb.z(-99265284143914L));
                ((cdj)o5).s(cnb.z(-100635378711338L));
                ((fj)o).f((cdj)o5);
                final Object o6 = new Object();
                cdj.l((cdj)o6, cnb.z(-101094940212010L));
                ((cdj)o6).s(cnb.z(-100304666229546L));
                ((fj)o).f((cdj)o6);
                ((cdj)d3).j = (fj)o;
                bah3.getClass();
                bah3.d = (cdj)d3;
                return a2;
            }
            case 8: {
                ((amm)o).c = (bgf)new ws(9);
                return a2;
            }
            case 7: {
                return ((wz)o).b;
            }
            case 6: {
                final blr blr = (blr)o;
                final Integer value = 3;
                final String z6 = cnb.z(-546534588414762L);
                final blq d4 = awp.d(blr.f, blr.a, blr.b, (blq)null);
                final blu f2 = blr.f;
                final Class<LinearLayout> clazz4 = LinearLayout.class;
                Class<LinearLayout> bf5;
                if ((bf5 = cnf.bf(dal.b((Class)LinearLayout.class))) == null) {
                    bf5 = LinearLayout.class;
                }
                final View h2 = blu.h(f2, (Class)bf5, z6, blr.j());
                final LinkedHashMap f3 = f2.f;
                final ViewGroup viewGroup = (ViewGroup)h2;
                ((View)viewGroup).setLayoutParams(d4.f());
                Class<LinearLayout> bf6;
                if ((bf6 = cnf.bf(dal.b((Class)LinearLayout.class))) == null) {
                    bf6 = LinearLayout.class;
                }
                final String name = bf6.getName();
                final int size = f3.size();
                final LinearLayout linearLayout = (LinearLayout)viewGroup;
                linearLayout.setOrientation(0);
                linearLayout.setGravity(17);
                final int intValue2 = blr.k(value).intValue();
                if (intValue2 >= 0) {
                    ajn.aj((ViewGroup)linearLayout, intValue2, 0, intValue2, 10);
                }
                final int intValue3 = blr.k(Integer.valueOf(6)).intValue();
                final int intValue4 = blr.k(value).intValue();
                if (intValue3 >= 0) {
                    ((View)linearLayout).setPadding(intValue3, ((View)linearLayout).getPaddingTop(), intValue3, ((View)linearLayout).getPaddingBottom());
                }
                if (intValue4 >= 0) {
                    ((View)linearLayout).setPadding(((View)linearLayout).getPaddingLeft(), intValue4, ((View)linearLayout).getPaddingRight(), intValue4);
                }
                final GradientDrawable background = new GradientDrawable();
                background.setShape(0);
                long n5;
                if (cnh.aa(((View)linearLayout).getContext())) {
                    n5 = -546556063251242L;
                }
                else {
                    n5 = -546461573970730L;
                }
                background.setColor(Color.parseColor(cnb.z(n5)));
                background.setCornerRadius(10.0f);
                ((View)linearLayout).setBackground((Drawable)background);
                if (f3.size() != size) {
                    o = new Exception(bjs.o("Performers are not allowed to appear in ", name, " DSL creation process."));
                    throw o;
                }
                Class<LinearLayout> bf7 = cnf.bf(dal.b((Class)LinearLayout.class));
                if (bf7 == null) {
                    bf7 = clazz4;
                }
                me.hd.wauxv.obf.blr.i(blr, z6, (Class)bf7);
                me.hd.wauxv.obf.blr.h(blr, (View)viewGroup);
                Class<LinearLayout$LayoutParams> clazz5 = LinearLayout$LayoutParams.class;
                final Class bf8 = cnf.bf(dal.b((Class)LinearLayout$LayoutParams.class));
                if (bf8 != null) {
                    clazz5 = bf8;
                }
                final blr i = blu.i(f2, (Class)clazz5, viewGroup, true, (Context)null);
                final ViewGroup b7 = i.b;
                final Class a5 = i.a;
                final blu f4 = i.f;
                final String z7 = cnb.z(-546985559980842L);
                final blq d5 = awp.d(f4, a5, b7, (blq)null);
                final Class<ImageView> clazz6 = ImageView.class;
                Class<ImageView> bf9;
                if ((bf9 = cnf.bf(dal.b((Class)ImageView.class))) == null) {
                    bf9 = ImageView.class;
                }
                final View h3 = blu.h(f4, (Class)bf9, z7, i.j());
                final LinkedHashMap f5 = f4.f;
                h3.setLayoutParams(d5.f());
                Class<ImageView> bf10;
                if ((bf10 = cnf.bf(dal.b((Class)ImageView.class))) == null) {
                    bf10 = ImageView.class;
                }
                final String name2 = bf10.getName();
                final int size2 = f5.size();
                final ImageView imageView = (ImageView)h3;
                long n6;
                if (cnh.aa(((View)imageView).getContext())) {
                    n6 = -546946905275178L;
                }
                else {
                    n6 = -546921135471402L;
                }
                imageView.setImageTintList(emc.ai(Color.parseColor(cnb.z(n6))));
                if (f5.size() != size2) {
                    o = new Exception(bjs.o("Performers are not allowed to appear in ", name2, " DSL creation process."));
                    throw o;
                }
                Class<ImageView> bf11 = cnf.bf(dal.b((Class)ImageView.class));
                if (bf11 == null) {
                    bf11 = clazz6;
                }
                me.hd.wauxv.obf.blr.i(i, z7, (Class)bf11);
                me.hd.wauxv.obf.blr.h(i, h3);
                final String z8 = cnb.z(-546895365667626L);
                final blq d6 = awp.d(f4, a5, b7, (blq)null);
                Class<TextView> bf12;
                if ((bf12 = cnf.bf(dal.b((Class)TextView.class))) == null) {
                    bf12 = TextView.class;
                }
                final View h4 = blu.h(f4, (Class)bf12, z8, i.j());
                h4.setLayoutParams(d6.f());
                Class<TextView> bf13;
                if ((bf13 = cnf.bf(dal.b((Class)TextView.class))) == null) {
                    bf13 = TextView.class;
                }
                final String name3 = bf13.getName();
                final int size3 = f5.size();
                final TextView textView3 = (TextView)h4;
                textView3.setGravity(17);
                long n7;
                if (cnh.aa(((View)textView3).getContext())) {
                    n7 = -546852415994666L;
                }
                else {
                    n7 = -546826646190890L;
                }
                textView3.setTextColor(Color.parseColor(cnb.z(n7)));
                if (f5.size() == size3) {
                    Class<TextView> bf14 = cnf.bf(dal.b((Class)TextView.class));
                    if (bf14 == null) {
                        bf14 = clazz;
                    }
                    me.hd.wauxv.obf.blr.i(i, z8, (Class)bf14);
                    me.hd.wauxv.obf.blr.h(i, h4);
                    return a2;
                }
                o = new Exception(bjs.o("Performers are not allowed to appear in ", name3, " DSL creation process."));
                throw o;
            }
            case 5: {
                ((amm)o).c = (bgf)new ws(2);
                return a2;
            }
            case 4: {
                final bmm bmm2 = (bmm)o;
                bmm2.getClass();
                Object x2 = null;
                try {
                    if ((o = bmm2.d()[0]) == null) {}
                }
                finally {
                    final Throwable t3;
                    x2 = bhu.x(t3);
                }
                if (x2 instanceof dcx) {
                    x2 = null;
                }
                bzo.n(x2);
                final LinearLayout linearLayout2 = (LinearLayout)x2;
                final int a6 = bte.a;
                final azg r3 = dqc.bi((Object)linearLayout2).r();
                ((cbh)r3).ab = cnb.z(-546302660180778L);
                o = aaz.e(r3.c());
                o = ((azk)o).e();
                bzo.n(o);
                final List list = (List)o;
                final ArrayList list2 = new ArrayList();
                final Iterator iterator2 = list.iterator();
                int n8 = 0;
                while (iterator2.hasNext()) {
                    o = iterator2.next();
                    if (n8 < 0) {
                        aba.aj();
                        throw null;
                    }
                    final GridView gridView = (GridView)o;
                    final ListAdapter adapter = gridView.getAdapter();
                    final int count = ((Adapter)adapter).getCount();
                    final int a7 = bte.a;
                    final azg r4 = dqc.bi((Object)gridView).r();
                    r4.a = dal.b((Class)AdapterView$OnItemClickListener.class);
                    o = aaz.e(r4.c());
                    o = ((azk)o).e();
                    bzo.n(o);
                    final AdapterView$OnItemClickListener adapterView$OnItemClickListener = (AdapterView$OnItemClickListener)o;
                    final azg r5 = dqc.bi((Object)gridView).r();
                    r5.a = dal.b((Class)AdapterView$OnItemLongClickListener.class);
                    o = aaz.e(r5.c());
                    o = ((azk)o).e();
                    bzo.n(o);
                    final AdapterView$OnItemLongClickListener adapterView$OnItemLongClickListener = (AdapterView$OnItemLongClickListener)o;
                    for (int j = 0; j < count; ++j) {
                        o = ((Adapter)adapter).getView(j, (View)null, (ViewGroup)gridView).getTag();
                        final int a8 = bte.a;
                        final azg r6 = dqc.bi(o).r();
                        ((cbh)r6).ab = cnb.z(-546311250115370L);
                        o = aaz.e(r6.c());
                        o = ((azk)o).e();
                        bzo.n(o);
                        final String string = ((TextView)o).getText().toString();
                        final int hashCode = string.hashCode();
                        int n9 = 0x600800a3;
                        Label_5321: {
                            Label_5317: {
                                Label_5310: {
                                    Label_5282: {
                                        Label_5251: {
                                            Label_5220: {
                                                Label_5189: {
                                                    Label_5134: {
                                                        Label_5103: {
                                                            Label_5048: {
                                                                Label_4969: {
                                                                    Label_4914: {
                                                                        Label_4835: {
                                                                            Label_4732: {
                                                                                Label_4677: {
                                                                                    Label_4598: {
                                                                                        switch (hashCode) {
                                                                                            default: {
                                                                                                break Label_5310;
                                                                                            }
                                                                                            case 2102144823: {
                                                                                                if (!string.equals(cnb.z(-547019919719210L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5189;
                                                                                            }
                                                                                            case 2011082565: {
                                                                                                if (!string.equals(cnb.z(-545422191885098L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5103;
                                                                                            }
                                                                                            case 1965687765: {
                                                                                                if (!string.equals(cnb.z(-547406466775850L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5220;
                                                                                            }
                                                                                            case 1382589264: {
                                                                                                if (!string.equals(cnb.z(-547088639195946L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5134;
                                                                                            }
                                                                                            case 1345526795: {
                                                                                                if (!string.equals(cnb.z(-547127293901610L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4732;
                                                                                            }
                                                                                            case 1105704745: {
                                                                                                if (!string.equals(cnb.z(-545572515740458L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 1105685592: {
                                                                                                if (!string.equals(cnb.z(-547384991939370L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            case 1095724396: {
                                                                                                if (!string.equals(cnb.z(-545864573516586L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 1095702786: {
                                                                                                if (!string.equals(cnb.z(-545611170446122L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            case 1089441742: {
                                                                                                if (!string.equals(cnb.z(-545898933254954L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 1084437451: {
                                                                                                if (!string.equals(cnb.z(-545791559072554L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 1005034066: {
                                                                                                if (!string.equals(cnb.z(-547217488214826L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4598;
                                                                                            }
                                                                                            case 937455802: {
                                                                                                if (!string.equals(cnb.z(-545435076786986L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4598;
                                                                                            }
                                                                                            case 777897260: {
                                                                                                if (!string.equals(cnb.z(-545701364759338L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4969;
                                                                                            }
                                                                                            case 418957516: {
                                                                                                if (!string.equals(cnb.z(-545645530184490L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 315964195: {
                                                                                                if (!string.equals(cnb.z(-547247552985898L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5321;
                                                                                            }
                                                                                            case 218729015: {
                                                                                                if (!string.equals(cnb.z(-547432236579626L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4969;
                                                                                            }
                                                                                            case 108713756: {
                                                                                                if (!string.equals(cnb.z(-545808738941738L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break;
                                                                                            }
                                                                                            case 74710533: {
                                                                                                if (!string.equals(cnb.z(-547148768738090L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4677;
                                                                                            }
                                                                                            case 67881559: {
                                                                                                if (!string.equals(cnb.z(-545392127114026L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5048;
                                                                                            }
                                                                                            case 63344207: {
                                                                                                if (!string.equals(cnb.z(-546281185344298L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4914;
                                                                                            }
                                                                                            case 32167638: {
                                                                                                if (!string.equals(cnb.z(-547492366121770L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4598;
                                                                                            }
                                                                                            case 2219344: {
                                                                                                if (!string.equals(cnb.z(-545671299988266L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4835;
                                                                                            }
                                                                                            case 1233007: {
                                                                                                if (!string.equals(cnb.z(-547509545990954L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4677;
                                                                                            }
                                                                                            case 1225917: {
                                                                                                if (!string.equals(cnb.z(-545735724497706L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4677;
                                                                                            }
                                                                                            case 1174330: {
                                                                                                if (!string.equals(cnb.z(-545752904366890L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4732;
                                                                                            }
                                                                                            case 1173187: {
                                                                                                if (!string.equals(cnb.z(-545538156002090L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4732;
                                                                                            }
                                                                                            case 1026211: {
                                                                                                if (!string.equals(cnb.z(-545757199334186L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5189;
                                                                                            }
                                                                                            case 1013408: {
                                                                                                if (!string.equals(cnb.z(-545714249661226L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5189;
                                                                                            }
                                                                                            case 994939: {
                                                                                                if (!string.equals(cnb.z(-547281912724266L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4835;
                                                                                            }
                                                                                            case 991405: {
                                                                                                if (!string.equals(cnb.z(-545843098680106L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4835;
                                                                                            }
                                                                                            case 975943: {
                                                                                                if (!string.equals(cnb.z(-546276890377002L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4914;
                                                                                            }
                                                                                            case 969785: {
                                                                                                if (!string.equals(cnb.z(-547174538541866L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5251;
                                                                                            }
                                                                                            case 965012: {
                                                                                                if (!string.equals(cnb.z(-545482321427242L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4914;
                                                                                            }
                                                                                            case 872500: {
                                                                                                if (!string.equals(cnb.z(-547015624751914L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5048;
                                                                                            }
                                                                                            case 837465: {
                                                                                                if (!string.equals(cnb.z(-545525271100202L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_4969;
                                                                                            }
                                                                                            case 831636: {
                                                                                                if (!string.equals(cnb.z(-545478026459946L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5282;
                                                                                            }
                                                                                            case 831624: {
                                                                                                if (!string.equals(cnb.z(-546255415540522L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5282;
                                                                                            }
                                                                                            case 825935: {
                                                                                                if (!string.equals(cnb.z(-546319840049962L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5048;
                                                                                            }
                                                                                            case 809968: {
                                                                                                if (!string.equals(cnb.z(-547556790631210L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5103;
                                                                                            }
                                                                                            case 809751: {
                                                                                                if (!string.equals(cnb.z(-545417896917802L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5103;
                                                                                            }
                                                                                            case 696282: {
                                                                                                if (!string.equals(cnb.z(-545585400642346L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5134;
                                                                                            }
                                                                                            case 682743: {
                                                                                                if (!string.equals(cnb.z(-547462301350698L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5317;
                                                                                            }
                                                                                            case 678182: {
                                                                                                if (!string.equals(cnb.z(-545709954693930L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5189;
                                                                                            }
                                                                                            case 661953: {
                                                                                                if (!string.equals(cnb.z(-545606875478826L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5220;
                                                                                            }
                                                                                            case -362284748: {
                                                                                                if (!string.equals(cnb.z(-545542450969386L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5251;
                                                                                            }
                                                                                            case -1078316749: {
                                                                                                if (!string.equals(cnb.z(-546238235671338L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5282;
                                                                                            }
                                                                                            case -1672428307: {
                                                                                                if (!string.equals(cnb.z(-547466596317994L))) {
                                                                                                    break Label_5310;
                                                                                                }
                                                                                                break Label_5317;
                                                                                            }
                                                                                        }
                                                                                        n9 = 0x600800b2;
                                                                                        break Label_5321;
                                                                                    }
                                                                                    n9 = 0x600800ab;
                                                                                    break Label_5321;
                                                                                }
                                                                                n9 = 0x600800ae;
                                                                                break Label_5321;
                                                                            }
                                                                            n9 = 0x600800b1;
                                                                            break Label_5321;
                                                                        }
                                                                        n9 = 0x600800a9;
                                                                        break Label_5321;
                                                                    }
                                                                    n9 = 0x600800a2;
                                                                    break Label_5321;
                                                                }
                                                                n9 = 0x600800a7;
                                                                break Label_5321;
                                                            }
                                                            n9 = 0x600800a8;
                                                            break Label_5321;
                                                        }
                                                        n9 = 0x600800a4;
                                                        break Label_5321;
                                                    }
                                                    n9 = 0x600800a5;
                                                    break Label_5321;
                                                }
                                                n9 = 0x600800b0;
                                                break Label_5321;
                                            }
                                            n9 = 0x600800ad;
                                            break Label_5321;
                                        }
                                        n9 = 0x600800ac;
                                        break Label_5321;
                                    }
                                    n9 = 0x600800aa;
                                    break Label_5321;
                                }
                                n9 = 0x600800af;
                                break Label_5321;
                            }
                            n9 = 0x600800a6;
                        }
                        list2.add(new wz(n9, string, (bfu)new ww((Object)adapterView$OnItemClickListener, gridView, j, 0)));
                        if (la.s((Object[])new String[] { cnb.z(-547329157364522L), cnb.z(-547350632201002L), cnb.z(-547286207691562L) }, (Object)string) >= 0) {
                            final int hashCode2 = string.hashCode();
                            String s2 = null;
                            Label_5545: {
                                if (hashCode2 != 965012) {
                                    if (hashCode2 != 975943) {
                                        if (hashCode2 == 0x03c68e4f) {
                                            if (string.equals(cnb.z(-546714977041194L))) {
                                                s2 = cnb.z(-546641962597162L);
                                                break Label_5545;
                                            }
                                        }
                                    }
                                    else if (string.equals(cnb.z(-547311977495338L))) {
                                        s2 = cnb.z(-546693502204714L);
                                        break Label_5545;
                                    }
                                }
                                else if (string.equals(cnb.z(-546672027368234L))) {
                                    s2 = cnb.z(-546676322335530L);
                                    break Label_5545;
                                }
                                s2 = cnb.z(-546629077695274L);
                            }
                            o = new wz(0x600800a4, s2, (bfu)new ww((Object)adapterView$OnItemLongClickListener, gridView, j, 1));
                            list2.add(o);
                        }
                    }
                    ++n8;
                }
                Object o7 = null;
                Label_5688: {
                    if (!list2.isEmpty()) {
                        final Iterator iterator3 = list2.iterator();
                        while (iterator3.hasNext()) {
                            if (((wz)iterator3.next()).b.equals(cnb.z(-546577538087722L))) {
                                o7 = xc.a;
                                break Label_5688;
                            }
                        }
                    }
                    o7 = xd.a;
                }
                final List as = dnj.as(((akf)o7).o(), new String[] { cnb.z(-546594717956906L) });
                final ArrayList<wz> list3 = new ArrayList<wz>();
                final Iterator iterator4 = as.iterator();
                Label_5734:
                while (iterator4.hasNext()) {
                    o = iterator4.next();
                    final String obj = (String)o;
                    final Iterator iterator5 = list2.iterator();
                    while (true) {
                        while (iterator5.hasNext()) {
                            o = iterator5.next();
                            if (((wz)o).b.equals(obj)) {
                                final wz e2 = (wz)o;
                                if (e2 != null) {
                                    list3.add(e2);
                                    continue Label_5734;
                                }
                                continue Label_5734;
                            }
                        }
                        o = null;
                        continue;
                    }
                }
                o = new ArrayList();
                for (final Object next2 : list2) {
                    if (!as.contains(((wz)next2).b)) {
                        ((ArrayList<wz>)o).add((wz)next2);
                    }
                }
                final ArrayList l = xf.l;
                l.clear();
                l.addAll(aaz.o((Collection)list3, (Iterable)o));
                final cyt m = xf.m;
                if (m != null) {
                    ((cyw)m).af();
                }
                return a2;
            }
            case 3: {
                final bmm bmm3 = (bmm)o;
                final Integer value2 = 1;
                bmm3.getClass();
                Object x3 = null;
                try {
                    if ((o = bmm3.d()[0]) == null) {}
                }
                finally {
                    final Throwable t4;
                    x3 = bhu.x(t4);
                }
                if (x3 instanceof dcx) {
                    x3 = null;
                }
                bzo.n(x3);
                final LinearLayout linearLayout3 = (LinearLayout)x3;
                final int a9 = bte.a;
                final bmu bi = dqc.bi((Object)linearLayout3);
                final azg r7 = bi.r();
                ((cbh)r7).ab = cnb.z(-546337019919146L);
                final Object e3 = ((azk)aaz.e(r7.c())).e();
                bzo.n(e3);
                final int intValue5 = ((Number)e3).intValue();
                final azg r8 = bi.r();
                ((cbh)r8).ab = cnb.z(-546345609853738L);
                final Object e4 = ((azk)aaz.e(r8.c())).e();
                bzo.n(e4);
                final int intValue6 = ((Number)e4).intValue();
                if (intValue5 == 0 || intValue6 == 0) {
                    final azg r9 = bi.r();
                    ((cbh)r9).ab = cnb.z(-546354199788330L);
                    ((azk)aaz.e(r9.c())).f((Object)value2);
                    final azg r10 = bi.r();
                    ((cbh)r10).ab = cnb.z(-546294070246186L);
                    o = aaz.e(r10.c());
                    ((azk)o).f((Object)value2);
                }
                return a2;
            }
            case 2: {
                final bah bah4 = (bah)o;
                final Object d7 = new Object();
                cdj.l((cdj)d7, cnb.z(-552689276549930L));
                ((cdj)d7).t(new String[] { cnb.z(-552526067792682L) });
                bah4.getClass();
                bah4.d = (cdj)d7;
                return a2;
            }
            case 1: {
                final View view2 = (View)o;
                final View k2 = dkz.k(view2, 0x600c0084, (ViewGroup)null, false);
                int n10 = 0x600902b1;
                final MaterialRadioButton materialRadioButton = (MaterialRadioButton)cnd.aq(k2, 0x600902b1);
                if (materialRadioButton != null) {
                    n10 = 0x600902b2;
                    final MaterialRadioButton materialRadioButton2 = (MaterialRadioButton)cnd.aq(k2, 0x600902b2);
                    if (materialRadioButton2 != null) {
                        n10 = 0x600902b3;
                        final MaterialRadioButton materialRadioButton3 = (MaterialRadioButton)cnd.aq(k2, 0x600902b3);
                        if (materialRadioButton3 != null) {
                            n10 = 0x600902c7;
                            final RadioGroup radioGroup = (RadioGroup)cnd.aq(k2, 0x600902c7);
                            if (radioGroup != null) {
                                final LinearLayout r11 = (LinearLayout)k2;
                                final bqs bqs = new bqs(r11, (View)materialRadioButton, (CompoundButton)materialRadioButton2, (TextView)materialRadioButton3, (View)radioGroup, 1);
                                final int k3 = ((akf)xb.a).k();
                                if (k3 == wy.a.e) {
                                    ((CompoundButton)materialRadioButton2).setChecked(true);
                                }
                                else if (k3 == wy.b.e) {
                                    ((CompoundButton)materialRadioButton).setChecked(true);
                                }
                                else if (k3 == wy.c.e) {
                                    ((CompoundButton)materialRadioButton3).setChecked(true);
                                }
                                final bzy bzy2 = new bzy(view2.getContext());
                                final eg eg2 = (eg)((ek)bzy2).d;
                                xf.a.getClass();
                                eg2.d = xf.c;
                                final String z9 = cnb.z(-546384264559402L);
                                o = new bp((Object)bqs, 10);
                                o = new amw((bfu)o, 0);
                                ((ek)bzy2).t(z9, (amw)o);
                                final String z10 = cnb.z(-47455093652266L);
                                if ((0x3 & 0x2) != 0x0) {
                                    o = new amd(1);
                                }
                                else {
                                    o = null;
                                }
                                bjs.x((amd)o, bzy2, z10);
                                if (r11 != null) {
                                    eg2.r = (View)r11;
                                }
                                ((Dialog)bzy2.i()).show();
                                return a2;
                            }
                        }
                    }
                }
                o = new NullPointerException(cnb.z(-637751103847210L).concat(k2.getResources().getResourceName(n10)));
                throw o;
            }
            case 0: {
                final bah bah5 = (bah)o;
                final Object d8 = new Object();
                wv.a.getClass();
                ((cdj)d8).o(emn.az((amn)wt.a));
                ((cdj)d8).t(new String[] { cnb.z(-99888054401834L), cnb.z(-99784975186730L) });
                bah5.getClass();
                bah5.d = (cdj)d8;
                return a2;
            }
        }
    }
}

