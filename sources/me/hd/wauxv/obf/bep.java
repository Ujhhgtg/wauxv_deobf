//
// Decompiled by Procyon - 4318ms
//
package me.hd.wauxv.obf;

import android.app.Dialog;
import java.util.regex.Matcher;
import java.util.concurrent.ConcurrentHashMap;
import android.content.res.Resources;
import java.util.NoSuchElementException;
import android.content.Intent;
import java.util.regex.Pattern;

import com.google.android.material.textfield.TextInputEditText;
import android.view.MenuItem;
import android.view.ContextMenu;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup$LayoutParams;
import java.util.Arrays;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import android.content.Context;

public final class bep implements IInvokable
{
    public final int a;

    public bep(final int a) {
        this.a = a;
        super();
    }

    public final Object invoke(Object d) {
        final int a = this.a;
        final amd amd = null;
        final Object o = null;
        final Object o2 = null;
        final amd amd2 = null;
        final Integer n = null;
        int i = 0;
        final ens a2 = ens.a;
        switch (a) {
            default: {
                ((amm)d).c = (IInvokable)new blx(2);
                return a2;
            }
            case 28: {
                final Class clazz = (Class)d;
                Class<Boolean> clazz2 = Boolean.class;
                final Class bf = cnf.bf(dal.b((Class)Boolean.class));
                if (bf != null) {
                    clazz2 = bf;
                }
                return bzo.f((Object)clazz, (Object)clazz2) ^ true;
            }
            case 27: {
                final bmm bmm = (bmm)d;
                final azg aa = dkz.aa(bmm);
                aa.a = dal.b((Class)Context.class);
                final Object e = ((azk)aaz.e(aa.c())).e();
                bzo.n(e);
                final Resources resources = ((Context)e).getResources();
                if (resources != null) {
                    cnf.bi(resources);
                }
                final cde t = dqc.bi(bmm.e()).t();
                t.a = dal.b((Class)BaseAdapter.class);
                final Object j = ((cdk)aaz.e(t.aj())).j(new Object[0]);
                bzo.n(j);
                final BaseAdapter baseAdapter = (BaseAdapter)j;
                final azg aa2 = dkz.aa(bmm);
                aa2.a = dal.b((Class)SparseArray.class);
                d = aaz.e(aa2.c());
                d = ((azk)d).e();
                bzo.n(d);
                final SparseArray sparseArray = (SparseArray)d;
                final Object value = sparseArray.get(sparseArray.size() - 1);
                final azg r = dqc.bi(value).r();
                r.b = (bgf)new bep(28);
                d = aaz.e(r.c());
                final Object d2 = ((azk)d).d();
                bzo.n(d2);
                final Iterator iterator = HomePopMenuApiHook.allHomePopMenuHooks.iterator();
                while (iterator.hasNext()) {
                    d = iterator.next();
                    final bnn bnn = (bnn)d;
                    int size = i;
                    Label_0809: {
                        try {
                            final List k = bnn.j();
                            size = i;
                            final Iterator iterator2 = k.iterator();
                            while (true) {
                                size = i;
                                if (!iterator2.hasNext()) {
                                    break;
                                }
                                size = i;
                                final Object next = iterator2.next();
                                size = i;
                                final bly bly = (bly)next;
                                size = i;
                                final Class<?> class1 = d2.getClass();
                                size = i;
                                final zc b = dal.b((Class)class1);
                                size = i;
                                final int a4 = bly.a;
                                size = i;
                                final String b2 = bly.b;
                                size = i;
                                final String z = cnb.z(-63690070031146L);
                                size = i;
                                final int c = bly.c;
                                try {
                                    final ConcurrentHashMap a5 = zf.a;
                                    final Object c2 = zf.c(cnf.bd((bsv)dal.b((Class)value.getClass())), Arrays.copyOf(new Object[] { zf.c(cnf.bd((bsv)b), Arrays.copyOf(new Object[] { a4, b2, z, c, i }, 5)) }, 1));
                                    size = sparseArray.size();
                                    sparseArray.put(size, c2);
                                    baseAdapter.notifyDataSetChanged();
                                }
                                catch (final Exception ex) {}
                            }
                        }
                        catch (final Exception ex) {
                            i = size;
                            break Label_0809;
                        }
                        continue;
                    }
                    final ArrayList a6 = ewq.a;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(cnb.z(-63702954933034L));
                    String s;
                    if (bnn instanceof doo) {
                        s = ((doo)bnn).f();
                    }
                    else {
                        s = cnb.z(-63569810946858L);
                    }
                    final Exception ex;
                    ewq.e(yg.n(sb, s, -63548336110378L), ex, 12);
                }
                return a2;
            }
            case 26: {
                final bmm bmm2 = (bmm)d;
                bmm2.getClass();
                Object x = null;
                try {
                    if ((d = bmm2.d()[2]) == null) {}
                }
                finally {
                    final Throwable t2;
                    x = bhu.x(t2);
                }
                if (x instanceof dcx) {
                    x = n;
                }
                final Integer n2 = (Integer)x;
                int intValue;
                if (n2 != null) {
                    intValue = n2;
                }
                else {
                    intValue = 0;
                }
                final int a7 = bte.a;
                final azg aa3 = dkz.aa(bmm2);
                aa3.a = dal.b((Class)SparseArray.class);
                d = aaz.e(aa3.c());
                d = ((azk)d).e();
                bzo.n(d);
                d = ((SparseArray)d).get(intValue);
                final azg r2 = dqc.bi(d).r();
                r2.b = (bgf)new blx(1);
                d = aaz.e(r2.c());
                d = ((azk)d).d();
                bzo.n(d);
                final azg r3 = dqc.bi(d).r();
                r3.a = dal.b((Class)Integer.TYPE);
                final Iterator iterator3 = r3.c().iterator();
                Label_1381:
                while (iterator3.hasNext()) {
                    d = iterator3.next();
                    d = ((azk)d).e();
                    final Integer n3 = (Integer)d;
                    final Iterator iterator4 = HomePopMenuApiHook.allHomePopMenuHooks.iterator();
                    while (iterator4.hasNext()) {
                        d = iterator4.next();
                        d = d;
                        try {
                            for (final bly bly2 : ((bnn)d).j()) {
                                final int a8 = bly2.a;
                                if (n3 == null) {
                                    continue;
                                }
                                if (n3 != a8) {
                                    continue;
                                }
                                bly2.d.invoke();
                            }
                            continue;
                        }
                        catch (final Exception ex2) {
                            final ArrayList a9 = ewq.a;
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(cnb.z(-63513976372010L));
                            String s2;
                            if (d instanceof doo) {
                                s2 = ((doo)d).f();
                            }
                            else {
                                s2 = cnb.z(-62899796048682L);
                            }
                            ewq.e(yg.n(sb2, s2, -62878321212202L), ex2, 12);
                            continue;
                        }
                        break Label_1381;
                    }
                }
                return a2;
            }
            case 25: {
                final blw blw = (blw)d;
                return a2;
            }
            case 24: {
                final ViewGroup$LayoutParams viewGroup$LayoutParams = (ViewGroup$LayoutParams)d;
                return a2;
            }
            case 23: {
                final bah bah = (bah)d;
                final String z2 = cnb.z(-484240382753578L);
                bah.getClass();
                bah.a = la.ab((Object[])new String[] { z2 });
                final Object d3 = new Object();
                ((cdj)d3).s(cnb.z(-484064289094442L));
                if (cnb.ab(ewk.i) || cnb.ac(ewh.h)) {
                    ((cdj)d3).t(new String[] { cnb.z(-485704966601514L), cnb.z(-485460153465642L) });
                }
                bah.d = (cdj)d3;
                return a2;
            }
            case 22: {
                ((amm)d).c = (bgf)new bep(23);
                return a2;
            }
            case 21: {
                final bmm bmm3 = (bmm)d;
                final int a10 = bte.a;
                final azg aa4 = dkz.aa(bmm3);
                aa4.a = dal.b((Class)TextView.class);
                final Iterator iterator6 = aa4.c().iterator();
                while (iterator6.hasNext()) {
                    final TextView textView = (TextView)((azk)iterator6.next()).e();
                    if (textView != null) {
                        ((View)textView).setVisibility(8);
                    }
                }
                return a2;
            }
            case 20: {
                final bah bah2 = (bah)d;
                final String z3 = cnb.z(-484575390202666L);
                bah2.getClass();
                bah2.a = la.ab((Object[])new String[] { z3 });
                final Object d4 = new Object();
                ((cdj)d4).t(new String[] { cnb.z(-484395001576234L), cnb.z(-484704239221546L) });
                bah2.d = (cdj)d4;
                return a2;
            }
            case 19: {
                ((amm)d).c = (bgf)new bep(20);
                return a2;
            }
            case 18: {
                final bmm bmm4 = (bmm)d;
                bmm4.getClass();
                new ek((Object)bmm4, 0, 8).q((Object)8);
                return a2;
            }
            case 17: {
                final View view = (View)d;
                final View l = dkz.k(view, 0x600c0091, (ViewGroup)null, false);
                int n4 = 0x600901b8;
                final MaterialCheckBox materialCheckBox = (MaterialCheckBox)cnd.aq(l, 0x600901b8);
                if (materialCheckBox != null) {
                    n4 = 0x600901b9;
                    final MaterialCheckBox materialCheckBox2 = (MaterialCheckBox)cnd.aq(l, 0x600901b9);
                    if (materialCheckBox2 != null) {
                        final LinearLayout r4 = (LinearLayout)l;
                        final cek cek = new cek(r4, materialCheckBox, materialCheckBox2, 2);
                        materialCheckBox.setChecked(((akf)bli.a).i());
                        materialCheckBox2.setChecked(((akf)blj.a).i());
                        final bzy bzy = new bzy(view.getContext());
                        final eg eg = (eg)((ek)bzy).d;
                        blk.a.getClass();
                        eg.d = blk.c;
                        ((ek)bzy).t(cnb.z(-487122305809194L), new amw((bfu)new bp((Object)cek, 25), 0));
                        final String z4 = cnb.z(-47455093652266L);
                        amd amd3 = amd;
                        if ((0x3 & 0x2) != 0x0) {
                            amd3 = new amd(1);
                        }
                        bjs.x(amd3, bzy, z4);
                        if (r4 != null) {
                            eg.r = (View)r4;
                        }
                        ((Dialog)bzy.i()).show();
                        return a2;
                    }
                }
                d = new NullPointerException(cnb.z(-662902432332586L).concat(l.getResources().getResourceName(n4)));
                throw d;
            }
            case 16: {
                final bmm bmm5 = (bmm)d;
                bmm5.getClass();
                Object x2 = null;
                try {
                    if ((d = bmm5.d()[0]) == null) {}
                }
                finally {
                    final Throwable t3;
                    x2 = bhu.x(t3);
                }
                if (x2 instanceof dcx) {
                    x2 = null;
                }
                bzo.n(x2);
                Object e2 = new z((Object)x2, 8);
                final ArrayList list = new ArrayList();
                Label_2211:
                while (((Iterator)e2).hasNext()) {
                    d = ((Iterator)e2).next();
                    final View view2 = (View)d;
                    ViewGroup viewGroup;
                    if (view2 instanceof ViewGroup) {
                        viewGroup = (ViewGroup)view2;
                    }
                    else {
                        viewGroup = null;
                    }
                    if (viewGroup != null) {
                        d = new z((Object)viewGroup, 8);
                    }
                    else {
                        d = null;
                    }
                    Iterator iterator7 = (Iterator)e2;
                    Label_2369: {
                        if (d != null) {
                            final boolean hasNext = ((z)d).hasNext();
                            iterator7 = (Iterator)e2;
                            if (hasNext) {
                                list.add(e2);
                                break Label_2369;
                            }
                        }
                        while (true) {
                            final boolean hasNext2 = iterator7.hasNext();
                            d = iterator7;
                            if (hasNext2) {
                                break;
                            }
                            final boolean empty = list.isEmpty();
                            d = iterator7;
                            if (empty) {
                                break;
                            }
                            d = aaz.l((List)list);
                            iterator7 = (Iterator)d;
                            abf.ar((List)list);
                        }
                    }
                    final boolean b3 = view2 instanceof TextView;
                    e2 = d;
                    if (b3) {
                        final List ag = aba.ag((Object[])new String[] { cnb.z(-487788025740074L), cnb.z(-487805205609258L), cnb.z(-487762255936298L), cnb.z(-487736486132522L) });
                        if (ag.isEmpty()) {
                            e2 = d;
                        }
                        else {
                            final Iterator iterator8 = ag.iterator();
                            TextView textView2;
                            String s3;
                            do {
                                final boolean hasNext3 = iterator8.hasNext();
                                e2 = d;
                                if (!hasNext3) {
                                    continue Label_2211;
                                }
                                s3 = (String)iterator8.next();
                                textView2 = (TextView)view2;
                            } while (!StringsKt.contains(textView2.getText(), (CharSequence)s3, true));
                            ((View)textView2).setVisibility(4);
                            e2 = d;
                        }
                    }
                }
                return a2;
            }
            case 15: {
                final bah bah3 = (bah)d;
                final String z5 = cnb.z(-486671334243114L);
                bah3.getClass();
                bah3.a = la.ab((Object[])new String[] { z5 });
                final Object d5 = new Object();
                ((cdj)d5).t(new String[] { cnb.z(-487070766201642L), cnb.z(-486890377575210L) });
                bah3.d = (cdj)d5;
                return a2;
            }
            case 14: {
                ((amm)d).c = (bgf)new bep(15);
                return a2;
            }
            case 13: {
                d = ((bmm)d).f();
                if (!(d instanceof ViewGroup)) {
                    d = o;
                }
                final ViewGroup viewGroup2 = (ViewGroup)d;
                bzo.n((Object)viewGroup2);
                final View c3 = erb.c(viewGroup2, new int[] { 0, 1, 1 });
                bzo.n((Object)c3);
                c3.setVisibility(8);
                return a2;
            }
            case 12: {
                final Class clazz3 = (Class)d;
                final zc b4 = dal.b((Class)ContextMenu.class);
                final ConcurrentHashMap a11 = zf.a;
                return cnf.bd((bsv)b4).isAssignableFrom(clazz3);
            }
            case 11: {
                final bah bah4 = (bah)d;
                final Object d6 = new Object();
                ((cdj)d6).t(new String[] { cnb.z(-463061899017002L), cnb.z(-462954524834602L) });
                bah4.getClass();
                bah4.d = (cdj)d6;
                return a2;
            }
            case 10: {
                final bmm bmm6 = (bmm)d;
                final int a12 = bte.a;
                final azg aa5 = dkz.aa(bmm6);
                aa5.b = (bgf)new bep(12);
                d = aaz.e(aa5.c());
                d = ((azk)d).e();
                bzo.n(d);
                final azg r5 = dqc.bi((Object)d).r();
                r5.a = dal.b((Class)List.class);
                d = aaz.e(r5.c());
                d = ((azk)d).e();
                bzo.n(d);
                final ArrayList list2 = (ArrayList)d;
                final ArrayList list3 = new ArrayList();
                for (final Object next2 : list2) {
                    if (aaz.b((Iterable)((akf)bld.a).n(), (Object)((MenuItem)next2).getTitle())) {
                        list3.add(next2);
                    }
                }
                list2.removeAll(aaz.ad((Iterable)list3));
                return a2;
            }
            case 9: {
                ((amm)d).c = (bgf)new bep(11);
                return a2;
            }
            case 8: {
                final View view3 = (View)d;
                final View m = dkz.k(view3, 0x600c0090, (ViewGroup)null, false);
                int n5 = 0x6009020a;
                final TextInputEditText textInputEditText = (TextInputEditText)cnd.aq(m, 0x6009020a);
                if (textInputEditText != null) {
                    n5 = 0x60090285;
                    if (cnd.aq(m, 0x60090285) != null) {
                        final LinearLayout r6 = (LinearLayout)m;
                        final cee cee = new cee(r6, textInputEditText, 4);
                        ((TextView)textInputEditText).setText((CharSequence)aaz.k((Iterable)((akf)bld.a).n(), cnb.z(-463087668820778L), (String)null, (String)null, (bgf)null, 62));
                        final bzy bzy2 = new bzy(view3.getContext());
                        final eg eg2 = (eg)((ek)bzy2).d;
                        ble.a.getClass();
                        eg2.d = ble.i;
                        ((ek)bzy2).t(cnb.z(-463096258755370L), new amw((bfu)new bp((Object)cee, 24), 0));
                        ((ek)bzy2).s(cnb.z(-463049014115114L), new amw((bfu)new amd(20), 2));
                        if (r6 != null) {
                            eg2.r = (View)r6;
                        }
                        ((Dialog)bzy2.i()).show();
                        return a2;
                    }
                }
                d = new NullPointerException(cnb.z(-662490115472170L).concat(m.getResources().getResourceName(n5)));
                throw d;
            }
            case 7: {
                final bah bah5 = (bah)d;
                d = new Object();
                cdj.l((cdj)d, cnb.z(-509112538364714L));
                ((cdj)d).t(new String[] { cnb.z(-509417481042730L), cnb.z(-506501198248746L) });
                bah5.getClass();
                bah5.d = (cdj)d;
                return a2;
            }
            case 6: {
                final bmm bmm7 = (bmm)d;
                bmm7.getClass();
                Object x3 = null;
                try {
                    if ((d = bmm7.d()[0]) == null) {}
                }
                finally {
                    final Throwable t4;
                    x3 = bhu.x(t4);
                }
                if (x3 instanceof dcx) {
                    x3 = null;
                }
                bzo.n(x3);
                final View view4 = (View)x3;
                dcx x4 = null;
                try {
                    if ((d = bmm7.d()[1]) == null) {}
                }
                finally {
                    final Throwable t5;
                    x4 = bhu.x(t5);
                }
                if (x4 instanceof dcx) {
                    x4 = null;
                }
                bzo.n((Object)x4);
                final int a13 = bte.a;
                final azg r7 = dqc.bi((Object)x4).r();
                r7.a = dal.b((Class)String.class);
                final Iterator iterator10 = r7.c().iterator();
                int n6 = 0;
                d = o2;
                while (iterator10.hasNext()) {
                    final Object next3 = iterator10.next();
                    final String s4 = (String)((azk)next3).e();
                    if (s4 != null && dnr.bp(s4, cnb.z(-508275019741994L), false)) {
                        if (n6 != 0) {
                            d = new IllegalArgumentException(cnb.z(-509898517379882L));
                            throw d;
                        }
                        d = next3;
                        n6 = 1;
                    }
                }
                if (n6 != 0) {
                    d = ((azk)d).e();
                    bzo.n(d);
                    final String input = (String)d;
                    if (dnr.bp(input, cnb.z(-509937172085546L), false)) {
                        final Pattern compile = Pattern.compile(cnb.z(-509181257841450L));
                        bzo.p((Object)compile, "compile(...)");
                        final Matcher matcher = compile.matcher(input);
                        bzo.p((Object)matcher, "matcher(...)");
                        final bzx y = ewz.y(matcher, 0, (CharSequence)input);
                        if (y != null) {
                            final String s5 = (String)((bzv)y.e()).get(1);
                            d = ((bzv)y.e()).get(2);
                            final String s6 = (String)d;
                            final Context context = view4.getContext();
                            final Intent intent = new Intent();
                            intent.setClassName(context, cnb.z(-89111981456170L));
                            intent.putExtra(cnb.z(-89442693937962L), s6);
                            context.startActivity(intent);
                            bmm7.g();
                        }
                    }
                    return a2;
                }
                d = new NoSuchElementException(cnb.z(-509640819342122L));
                break;
            }
            case 5: {
                ((amm)d).c = (bgf)new bep(7);
                return a2;
            }
            case 4: {
                final View view5 = (View)d;
                final View k2 = dkz.k(view5, 0x600c008f, (ViewGroup)null, false);
                int n7 = 0x60090208;
                final TextInputEditText textInputEditText2 = (TextInputEditText)cnd.aq(k2, 0x60090208);
                if (textInputEditText2 != null) {
                    n7 = 0x60090209;
                    final TextInputEditText textInputEditText3 = (TextInputEditText)cnd.aq(k2, 0x60090209);
                    if (textInputEditText3 != null) {
                        n7 = 0x60090283;
                        if (cnd.aq(k2, 0x60090283) != null) {
                            n7 = 0x60090284;
                            if (cnd.aq(k2, 0x60090284) != null) {
                                final LinearLayout r8 = (LinearLayout)k2;
                                final cem cem = new cem(r8, textInputEditText2, textInputEditText3, 1);
                                ((TextView)textInputEditText2).setText((CharSequence)((akf)bjv.a).o());
                                ((TextView)textInputEditText3).setText((CharSequence)((akf)bjw.a).o());
                                final bzy bzy3 = new bzy(view5.getContext());
                                d = ((ek)bzy3).d;
                                final eg eg3 = (eg)d;
                                bjx.a.getClass();
                                eg3.d = bjx.c;
                                ((ek)bzy3).t(cnb.z(-508326559349546L), new amw((bfu)new bp((Object)cem, 23), 0));
                                ((ek)bzy3).s(cnb.z(-508330854316842L), new amw((bfu)new amd(17), 2));
                                final String z6 = cnb.z(-47455093652266L);
                                amd amd4 = amd2;
                                if ((0x3 & 0x2) != 0x0) {
                                    amd4 = new amd(1);
                                }
                                bjs.x(amd4, bzy3, z6);
                                if (r8 != null) {
                                    eg3.r = (View)r8;
                                }
                                ((Dialog)bzy3.i()).show();
                                return a2;
                            }
                        }
                    }
                }
                d = new NullPointerException(cnb.z(-662627554425642L).concat(k2.getResources().getResourceName(n7)));
                throw d;
            }
            case 3: {
                final View view6 = (View)d;
                final View k3 = dkz.k(view6, 0x600c008e, (ViewGroup)null, false);
                int n8 = 0x600901fc;
                final TextInputEditText textInputEditText4 = (TextInputEditText)cnd.aq(k3, 0x600901fc);
                if (textInputEditText4 != null) {
                    n8 = 0x600901fd;
                    final TextInputEditText textInputEditText5 = (TextInputEditText)cnd.aq(k3, 0x600901fd);
                    if (textInputEditText5 != null) {
                        n8 = 0x600901fe;
                        final TextInputEditText textInputEditText6 = (TextInputEditText)cnd.aq(k3, 0x600901fe);
                        if (textInputEditText6 != null) {
                            n8 = 0x600901ff;
                            final TextInputEditText textInputEditText7 = (TextInputEditText)cnd.aq(k3, 0x600901ff);
                            if (textInputEditText7 != null) {
                                n8 = 0x60090200;
                                final TextInputEditText textInputEditText8 = (TextInputEditText)cnd.aq(k3, 0x60090200);
                                if (textInputEditText8 != null) {
                                    n8 = 0x60090201;
                                    final TextInputEditText textInputEditText9 = (TextInputEditText)cnd.aq(k3, 0x60090201);
                                    if (textInputEditText9 != null) {
                                        n8 = 0x60090202;
                                        final TextInputEditText textInputEditText10 = (TextInputEditText)cnd.aq(k3, 0x60090202);
                                        if (textInputEditText10 != null) {
                                            n8 = 0x60090203;
                                            final TextInputEditText textInputEditText11 = (TextInputEditText)cnd.aq(k3, 0x60090203);
                                            if (textInputEditText11 != null) {
                                                n8 = 0x60090204;
                                                final TextInputEditText textInputEditText12 = (TextInputEditText)cnd.aq(k3, 0x60090204);
                                                if (textInputEditText12 != null) {
                                                    n8 = 0x60090205;
                                                    final TextInputEditText textInputEditText13 = (TextInputEditText)cnd.aq(k3, 0x60090205);
                                                    if (textInputEditText13 != null) {
                                                        n8 = 0x60090206;
                                                        final TextInputEditText textInputEditText14 = (TextInputEditText)cnd.aq(k3, 0x60090206);
                                                        if (textInputEditText14 != null) {
                                                            n8 = 0x60090207;
                                                            final TextInputEditText textInputEditText15 = (TextInputEditText)cnd.aq(k3, 0x60090207);
                                                            if (textInputEditText15 != null) {
                                                                n8 = 0x60090277;
                                                                if (cnd.aq(k3, 0x60090277) != null) {
                                                                    n8 = 0x60090278;
                                                                    if (cnd.aq(k3, 0x60090278) != null) {
                                                                        n8 = 0x60090279;
                                                                        if (cnd.aq(k3, 0x60090279) != null) {
                                                                            n8 = 0x6009027a;
                                                                            if (cnd.aq(k3, 0x6009027a) != null) {
                                                                                n8 = 0x6009027b;
                                                                                if (cnd.aq(k3, 0x6009027b) != null) {
                                                                                    n8 = 0x6009027c;
                                                                                    if (cnd.aq(k3, 0x6009027c) != null) {
                                                                                        n8 = 0x6009027d;
                                                                                        if (cnd.aq(k3, 0x6009027d) != null) {
                                                                                            n8 = 0x6009027e;
                                                                                            if (cnd.aq(k3, 0x6009027e) != null) {
                                                                                                n8 = 0x6009027f;
                                                                                                if (cnd.aq(k3, 0x6009027f) != null) {
                                                                                                    n8 = 0x60090280;
                                                                                                    if (cnd.aq(k3, 0x60090280) != null) {
                                                                                                        n8 = 0x60090281;
                                                                                                        if (cnd.aq(k3, 0x60090281) != null) {
                                                                                                            n8 = 0x60090282;
                                                                                                            if (cnd.aq(k3, 0x60090282) != null) {
                                                                                                                final LinearLayout r9 = (LinearLayout)k3;
                                                                                                                final cep cep = new cep(r9, textInputEditText4, textInputEditText5, textInputEditText6, textInputEditText7, textInputEditText8, textInputEditText9, textInputEditText10, textInputEditText11, textInputEditText12, textInputEditText13, textInputEditText14, textInputEditText15);
                                                                                                                ((TextView)textInputEditText13).setText((CharSequence)((akf)bjh.a).o());
                                                                                                                ((TextView)textInputEditText14).setText((CharSequence)((akf)bji.a).o());
                                                                                                                ((TextView)textInputEditText15).setText((CharSequence)((akf)bjj.a).o());
                                                                                                                ((TextView)textInputEditText4).setText((CharSequence)((akf)biy.a).o());
                                                                                                                ((TextView)textInputEditText5).setText((CharSequence)((akf)biz.a).o());
                                                                                                                ((TextView)textInputEditText6).setText((CharSequence)((akf)bja.a).o());
                                                                                                                ((TextView)textInputEditText7).setText((CharSequence)((akf)bjb.a).o());
                                                                                                                ((TextView)textInputEditText8).setText((CharSequence)((akf)bjc.a).o());
                                                                                                                ((TextView)textInputEditText9).setText((CharSequence)((akf)bjd.a).o());
                                                                                                                ((TextView)textInputEditText10).setText((CharSequence)((akf)bje.a).o());
                                                                                                                ((TextView)textInputEditText11).setText((CharSequence)((akf)bjf.a).o());
                                                                                                                ((TextView)textInputEditText12).setText((CharSequence)((akf)bjg.a).o());
                                                                                                                final bzy bzy4 = new bzy(view6.getContext());
                                                                                                                final eg eg4 = (eg)((ek)bzy4).d;
                                                                                                                bjm.a.getClass();
                                                                                                                eg4.d = bjm.c;
                                                                                                                ((ek)bzy4).t(cnb.z(-505637909822250L), new amw((bfu)new bp((Object)cep, 22), 0));
                                                                                                                ((ek)bzy4).s(cnb.z(-505573485312810L), new amw((bfu)new amd(15), 2));
                                                                                                                ((ek)bzy4).r(cnb.z(-505603550083882L), new amw((bfu)new amd(16), 1));
                                                                                                                if (r9 != null) {
                                                                                                                    eg4.r = (View)r9;
                                                                                                                }
                                                                                                                ((Dialog)bzy4.i()).show();
                                                                                                                return a2;
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                d = new NullPointerException(cnb.z(-639125493381930L).concat(k3.getResources().getResourceName(n8)));
                throw d;
            }
            case 2: {
                return dkz.o('\'', "'", (String)d);
            }
            case 1: {
                return dkz.o('\'', "'", (String)d);
            }
            case 0: {
                bzo.q((Object)d, "$this$initializer");
                return new beq$a();
            }
        }
    }
}

