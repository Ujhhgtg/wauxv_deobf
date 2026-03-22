//
// Decompiled by Procyon - 3774ms
//
package me.hd.wauxv.obf;

import android.widget.Adapter;
import android.app.Dialog;
import android.content.res.Resources;
import java.util.Iterator;

import android.view.LayoutInflater;
import android.content.Context;
import android.view.ContextMenu;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import android.view.ViewGroup;
import android.view.View;

public final synthetic class ayz implements bgf
{
    public final int a;

    public ayz(final int a) {
        this.a = a;
        super();
    }

    public final Object invoke(Object o) {
        final int a = this.a;
        final amd amd = null;
        final MenuItem menuItem = null;
        final ContextMenu contextMenu = null;
        final ContextMenu contextMenu2 = null;
        final MenuItem menuItem2 = null;
        final String s = null;
        final amd amd2 = null;
        final MenuItem menuItem3 = null;
        final Object o2 = null;
        final ens a2 = ens.a;
        switch (a) {
            default: {
                final View view = (View)o;
                final View k = dkz.k(view, 0x600c008d, (ViewGroup)null, false);
                int n = 0x600901fb;
                final TextInputEditText textInputEditText = (TextInputEditText)cnd.aq(k, 0x600901fb);
                if (textInputEditText != null) {
                    n = 0x60090276;
                    if (cnd.aq(k, 0x60090276) != null) {
                        n = 0x600902c0;
                        final MaterialRadioButton materialRadioButton = (MaterialRadioButton)cnd.aq(k, 0x600902c0);
                        if (materialRadioButton != null) {
                            n = 0x600902c1;
                            final MaterialRadioButton materialRadioButton2 = (MaterialRadioButton)cnd.aq(k, 0x600902c1);
                            if (materialRadioButton2 != null) {
                                n = 0x600902c2;
                                final MaterialRadioButton materialRadioButton3 = (MaterialRadioButton)cnd.aq(k, 0x600902c2);
                                if (materialRadioButton3 != null) {
                                    n = 0x600902cb;
                                    if (cnd.aq(k, 0x600902cb) != null) {
                                        final LinearLayout r = (LinearLayout)k;
                                        final bqs bqs = new bqs(r, (View)textInputEditText, (CompoundButton)materialRadioButton, (TextView)materialRadioButton2, (View)materialRadioButton3, 2);
                                        final int i = ((akf)bcs.a).k();
                                        if (i == bcr.a.e) {
                                            ((CompoundButton)materialRadioButton2).setChecked(true);
                                        }
                                        else if (i == bcr.b.e) {
                                            ((CompoundButton)materialRadioButton).setChecked(true);
                                        }
                                        else if (i == bcr.c.e) {
                                            ((CompoundButton)materialRadioButton3).setChecked(true);
                                        }
                                        ((TextView)textInputEditText).setText((CharSequence)((akf)bct.a).o());
                                        final bzy bzy = new bzy(view.getContext());
                                        o = ((ek)bzy).d;
                                        final eg eg = (eg)o;
                                        bcu.a.getClass();
                                        eg.d = bcu.c;
                                        ((ek)bzy).t(StaticUtils.decryptString(-463688964242218L), new amw((bfu)new bp((Object)bqs, 21), 0));
                                        ((ek)bzy).s(StaticUtils.decryptString(-463710439078698L), new amw((bfu)new amd(7), 2));
                                        final String z = StaticUtils.decryptString(-47455093652266L);
                                        o = o2;
                                        if ((0x3 & 0x2) != 0x0) {
                                            o = new amd(1);
                                        }
                                        bjs.x((amd)o, bzy, z);
                                        if (r != null) {
                                            eg.r = (View)r;
                                        }
                                        ((Dialog)bzy.i()).show();
                                        return a2;
                                    }
                                }
                            }
                        }
                    }
                }
                o = new NullPointerException(StaticUtils.decryptString(-639262932335402L).concat(k.getResources().getResourceName(n)));
                throw o;
            }
            case 28: {
                final bah bah = (bah)o;
                o = new Object();
                bcp.a.getClass();
                ((cdj)o).o((Class)emn.bb((amn)bcn.a).getDeclaringClass());
                ((cdj)o).t(new String[] { StaticUtils.decryptString(-368147416742698L), StaticUtils.decryptString(-367511761582890L) });
                bah.getClass();
                bah.d = (cdj)o;
                return a2;
            }
            case 27: {
                final bah bah2 = (bah)o;
                final Object d = new Object();
                ((cdj)d).t(new String[] { StaticUtils.decryptString(-367876833803050L), StaticUtils.decryptString(-368271970794282L) });
                bah2.getClass();
                bah2.d = (cdj)d;
                return a2;
            }
            case 26: {
                ((amm)o).c = (bgf)new ayz(28);
                return a2;
            }
            case 25: {
                ((amm)o).c = (bgf)new ayz(27);
                return a2;
            }
            case 24: {
                final View view2 = (View)o;
                final View j = dkz.k(view2, 0x600c008c, (ViewGroup)null, false);
                int n2 = 0x600901f7;
                final TextInputEditText textInputEditText2 = (TextInputEditText)cnd.aq(j, 0x600901f7);
                if (textInputEditText2 != null) {
                    n2 = 0x600901f8;
                    final TextInputEditText textInputEditText3 = (TextInputEditText)cnd.aq(j, 0x600901f8);
                    if (textInputEditText3 != null) {
                        n2 = 0x600901f9;
                        final TextInputEditText textInputEditText4 = (TextInputEditText)cnd.aq(j, 0x600901f9);
                        if (textInputEditText4 != null) {
                            n2 = 0x600901fa;
                            final TextInputEditText textInputEditText5 = (TextInputEditText)cnd.aq(j, 0x600901fa);
                            if (textInputEditText5 != null) {
                                n2 = 0x60090272;
                                if (cnd.aq(j, 0x60090272) != null) {
                                    n2 = 0x60090273;
                                    if (cnd.aq(j, 0x60090273) != null) {
                                        n2 = 0x60090274;
                                        if (cnd.aq(j, 0x60090274) != null) {
                                            n2 = 0x60090275;
                                            if (cnd.aq(j, 0x60090275) != null) {
                                                final LinearLayout r2 = (LinearLayout)j;
                                                final ceo ceo = new ceo(r2, textInputEditText2, textInputEditText3, textInputEditText4, textInputEditText5, 0);
                                                ((TextView)textInputEditText3).setText((CharSequence)((akf)bbg.a).o());
                                                ((TextView)textInputEditText5).setText((CharSequence)((akf)bbi.a).o());
                                                ((TextView)textInputEditText2).setText((CharSequence)((akf)bbf.a).o());
                                                ((TextView)textInputEditText4).setText((CharSequence)((akf)bbh.a).o());
                                                final bzy bzy2 = new bzy(view2.getContext());
                                                o = ((ek)bzy2).d;
                                                final eg eg2 = (eg)o;
                                                bbj.a.getClass();
                                                eg2.d = bbj.j;
                                                ((ek)bzy2).t(StaticUtils.decryptString(-550395764013866L), new amw((bfu)new bp((Object)ceo, 20), 0));
                                                ((ek)bzy2).s(StaticUtils.decryptString(-550348519373610L), new amw((bfu)new amd(6), 2));
                                                final String z2 = StaticUtils.decryptString(-47455093652266L);
                                                amd amd3 = amd;
                                                if ((0x3 & 0x2) != 0x0) {
                                                    amd3 = new amd(1);
                                                }
                                                bjs.x(amd3, bzy2, z2);
                                                if (r2 != null) {
                                                    eg2.r = (View)r2;
                                                }
                                                ((Dialog)bzy2.i()).show();
                                                return a2;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                o = new NullPointerException(StaticUtils.decryptString(-638850615474986L).concat(j.getResources().getResourceName(n2)));
                throw o;
            }
            case 23: {
                final bah bah3 = (bah)o;
                final String z3 = StaticUtils.decryptString(-62410169776938L);
                bah3.getClass();
                bah3.a = la.ab((Object[])new String[] { z3 });
                final Object d2 = new Object();
                ((cdj)d2).s(StaticUtils.decryptString(-61731564944170L));
                ((cdj)d2).t(new String[] { StaticUtils.decryptString(-61667140434730L) });
                bah3.d = (cdj)d2;
                return a2;
            }
            case 22: {
                final bah bah4 = (bah)o;
                final String z4 = StaticUtils.decryptString(-61589831023402L);
                bah4.getClass();
                bah4.a = la.ab((Object[])new String[] { z4 });
                final Object d3 = new Object();
                ((cdj)d3).s(StaticUtils.decryptString(-62010737818410L));
                ((cdj)d3).t(new String[] { StaticUtils.decryptString(-61886183766826L) });
                bah4.d = (cdj)d3;
                return a2;
            }
            case 21: {
                ((amm)o).c = (bgf)new ayz(22);
                return a2;
            }
            case 20: {
                ((amm)o).c = (bgf)new ayz(23);
                return a2;
            }
            case 19: {
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
                    x = menuItem;
                }
                bzo.n(x);
                final MenuItem menuItem4 = (MenuItem)x;
                final int a3 = bte.a;
                final azg aa = dkz.aa(bmm);
                aa.a = "com.tencent.mm.plugin.finder.model.BaseFinderFeed";
                o = aaz.e(aa.c());
                o = ((azk)o).d();
                bzo.n(o);
                final azg r3 = dqc.bi(o).r();
                r3.a = "com.tencent.mm.plugin.finder.storage.FinderItem";
                o = yg.e(r3);
                o = ((azk)o).d();
                bzo.n(o);
                final cde t2 = dqc.bi(o).t();
                ((cbh)t2).ab = "getMediaType";
                final Object l = ((cdk)aaz.e(t2.aj())).j(new Object[0]);
                bzo.n(l);
                final int intValue = ((Number)l).intValue();
                final cde t3 = dqc.bi(o).t();
                ((cbh)t3).ab = "getMediaList";
                o = aaz.e(t3.aj());
                o = ((cdk)o).j(new Object[0]);
                bzo.n(o);
                final List list = (List)o;
                final ArrayList list2 = new ArrayList<JSONObject>(abb.ak((Iterable)list, 10));
                for (final Object next : list) {
                    final int a4 = 0;
                    final cde t4 = dqc.bi(next).t();
                    ((cbh)t4).ab = "toJSON";
                    final Object m = ((cdk)dkz.m(t4)).j(new Object[0]);
                    bzo.n(m);
                    list2.add((JSONObject)m);
                }
                final Iterator iterator2 = bap.b.iterator();
                while (iterator2.hasNext()) {
                    o = iterator2.next();
                    o = o;
                    try {
                        for (final bam bam : ((ete)o).m()) {
                            if (menuItem4.getItemId() == bam.a) {
                                bam.d.g((Object)intValue, (Object)list2);
                            }
                        }
                        continue;
                    }
                    catch (final Exception ex) {
                        final ArrayList a5 = ewq.a;
                        final StringBuilder sb = new StringBuilder();
                        sb.append(StaticUtils.decryptString(-62599148337962L));
                        String s2;
                        if (o instanceof doo) {
                            s2 = ((doo)o).f();
                        }
                        else {
                            s2 = StaticUtils.decryptString(-62483184220970L);
                        }
                        ewq.e(yg.n(sb, s2, -62444529515306L), ex, 12);
                        continue;
                    }
                    break;
                }
                return a2;
            }
            case 18: {
                final bmm bmm2 = (bmm)o;
                bmm2.getClass();
                Object x2 = null;
                try {
                    if ((o = bmm2.d()[0]) == null) {}
                }
                finally {
                    final Throwable t5;
                    x2 = bhu.x(t5);
                }
                if (x2 instanceof dcx) {
                    x2 = contextMenu;
                }
                bzo.n(x2);
                final ContextMenu contextMenu3 = (ContextMenu)x2;
                final int a6 = bte.a;
                final azg r4 = dqc.bi((Object)contextMenu3).r();
                r4.a = dal.b((Class)Context.class);
                o = aaz.e(r4.c());
                o = ((azk)o).e();
                bzo.n(o);
                final Resources resources = ((Context)o).getResources();
                if (resources != null) {
                    cnf.bi(resources);
                }
                final dov dov = new dov((bfu)new ayu(contextMenu3, 3));
                final Iterator iterator4 = bap.b.iterator();
                while (iterator4.hasNext()) {
                    o = iterator4.next();
                    o = o;
                    try {
                        for (final bam bam2 : ((ete)o).m()) {
                            final cdk d4 = ((cdk)dov.getValue()).d();
                            ((bpu)d4).h((Object)contextMenu3);
                            d4.e(new Object[] { bam2.a, bam2.b, bam2.c });
                        }
                        continue;
                    }
                    catch (final Exception ex2) {
                        final ArrayList a7 = ewq.a;
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append(StaticUtils.decryptString(-64914135710506L));
                        String s3;
                        if (o instanceof doo) {
                            s3 = ((doo)o).f();
                        }
                        else {
                            s3 = StaticUtils.decryptString(-65399467014954L);
                        }
                        ewq.e(yg.n(sb2, s3, -65377992178474L), ex2, 12);
                        continue;
                    }
                    break;
                }
                return a2;
            }
            case 17: {
                final bah bah5 = (bah)o;
                final Object d5 = new Object();
                ((cdj)d5).t(new String[] { StaticUtils.decryptString(-65953517796138L) });
                bah5.getClass();
                bah5.d = (cdj)d5;
                return a2;
            }
            case 16: {
                final bag bag = (bag)o;
                final String z5 = StaticUtils.decryptString(-64287070485290L);
                bag.getClass();
                bag.a = la.ab((Object[])new String[] { z5 });
                final Object b = new Object();
                ((zb)b).k(new String[] { StaticUtils.decryptString(-64089501989674L), StaticUtils.decryptString(-65584150608682L) });
                bag.b = (zb)b;
                return a2;
            }
            case 15: {
                final bah bah6 = (bah)o;
                final String z6 = StaticUtils.decryptString(-64020782512938L);
                bah6.getClass();
                bah6.a = la.ab((Object[])new String[] { z6 });
                final Object d6 = new Object();
                ((cdj)d6).t(new String[] { StaticUtils.decryptString(-63891933494058L), StaticUtils.decryptString(-63904818395946L), StaticUtils.decryptString(-63866163690282L), StaticUtils.decryptString(-63823214017322L), StaticUtils.decryptString(-63775969377066L) });
                bah6.d = (cdj)d6;
                return a2;
            }
            case 14: {
                final amm amm = (amm)o;
                amm.b = (bgf)new ayz(16);
                amm.c = (bgf)new ayz(17);
                return a2;
            }
            case 13: {
                ((amm)o).c = (bgf)new ayz(15);
                return a2;
            }
            case 12: {
                final bmm bmm3 = (bmm)o;
                bmm3.getClass();
                Object x3 = null;
                try {
                    if ((o = bmm3.d()[1]) == null) {}
                }
                finally {
                    final Throwable t6;
                    x3 = bhu.x(t6);
                }
                if (x3 instanceof dcx) {
                    x3 = contextMenu2;
                }
                bzo.n(x3);
                final ContextMenu contextMenu4 = (ContextMenu)x3;
                final int a8 = bte.a;
                final azg r5 = dqc.bi((Object)contextMenu4).r();
                r5.a = dal.b((Class)Context.class);
                o = aaz.e(r5.c());
                o = ((azk)o).e();
                bzo.n(o);
                final Resources resources2 = ((Context)o).getResources();
                if (resources2 != null) {
                    cnf.bi(resources2);
                }
                final dov dov2 = new dov((bfu)new ayu(contextMenu4, 2));
                final Iterator iterator6 = bal.b.iterator();
                while (iterator6.hasNext()) {
                    o = iterator6.next();
                    for (final bai bai : ((etg)o).m()) {
                        final cdk d7 = ((cdk)dov2.getValue()).d();
                        ((bpu)d7).h((Object)contextMenu4);
                        d7.e(new Object[] { bai.a, bai.b, bai.c });
                    }
                    continue;
                    break;
                }
                return a2;
            }
            case 11: {
                final bmm bmm4 = (bmm)o;
                bmm4.getClass();
                dcx x4 = null;
                try {
                    if ((o = bmm4.d()[0]) == null) {}
                }
                finally {
                    final Throwable t7;
                    x4 = bhu.x(t7);
                }
                Object o3;
                if (x4 instanceof dcx) {
                    o3 = null;
                }
                else {
                    o3 = x4;
                }
                bzo.n(o3);
                Object x5 = null;
                try {
                    if ((o = bmm4.d()[1]) == null) {}
                }
                finally {
                    final Throwable t8;
                    x5 = bhu.x(t8);
                }
                if (x5 instanceof dcx) {
                    x5 = menuItem2;
                }
                bzo.n(x5);
                final MenuItem menuItem5 = (MenuItem)x5;
                final int a10 = bte.a;
                final azg r6 = dqc.bi(o3).r();
                r6.a = StaticUtils.decryptString(-64540473555754L);
                o = yg.e(r6);
                o = ((azk)o).d();
                bzo.n(o);
                final cde t9 = dqc.bi(o).t();
                ((cbh)t9).ab = StaticUtils.decryptString(-64334315125546L);
                final Object j2 = ((cdk)aaz.e(t9.aj())).j(new Object[0]);
                bzo.n(j2);
                final int intValue2 = ((Number)j2).intValue();
                final cde t10 = dqc.bi(o).t();
                ((cbh)t10).ab = StaticUtils.decryptString(-64811056495402L);
                o = aaz.e(t10.aj());
                o = ((cdk)o).j(new Object[0]);
                bzo.n(o);
                final List list3 = (List)o;
                final ArrayList list4 = new ArrayList<JSONObject>(abb.ak((Iterable)list3, 10));
                for (final Object next2 : list3) {
                    final int a11 = bte.a;
                    final cde t11 = dqc.bi(next2).t();
                    ((cbh)t11).ab = StaticUtils.decryptString(-64789581658922L);
                    final Object j3 = ((cdk)dkz.m(t11)).j(new Object[0]);
                    bzo.n(j3);
                    list4.add((JSONObject)j3);
                }
                final Iterator iterator9 = bal.b.iterator();
                while (iterator9.hasNext()) {
                    o = iterator9.next();
                    o = o;
                    try {
                        for (final bai bai2 : ((etg)o).m()) {
                            if (menuItem5.getItemId() == bai2.a) {
                                bai2.d.g((Object)intValue2, (Object)list4);
                            }
                        }
                        continue;
                    }
                    catch (final Exception ex4) {
                        final ArrayList a12 = ewq.a;
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append(StaticUtils.decryptString(-64759516887850L));
                        String s5;
                        if (o instanceof doo) {
                            s5 = ((doo)o).f();
                        }
                        else {
                            s5 = StaticUtils.decryptString(-64695092378410L);
                        }
                        ewq.e(yg.n(sb4, s5, -64604898065194L), ex4, 12);
                        continue;
                    }
                    break;
                }
                return a2;
            }
            case 10: {
                final bah bah7 = (bah)o;
                final Object d8 = new Object();
                cdj.m((cdj)d8, 8);
                final Class<String> clazz = String.class;
                Class<String> bf;
                if ((bf = cnf.bf(dal.b((Class)String.class))) == null) {
                    bf = String.class;
                }
                ((cdj)d8).r((Class)bf);
                Class<String> bf2 = cnf.bf(dal.b((Class)String.class));
                if (bf2 == null) {
                    bf2 = clazz;
                }
                ((cdj)d8).q(new Class[] { bf2 });
                bah7.getClass();
                bah7.d = (cdj)d8;
                return a2;
            }
            case 9: {
                final bag bag2 = (bag)o;
                o = new Object();
                ((zb)o).k(new String[] { StaticUtils.decryptString(-492065813166890L), StaticUtils.decryptString(-492546849504042L) });
                bag2.getClass();
                bag2.b = (zb)o;
                return a2;
            }
            case 8: {
                final bmm bmm5 = (bmm)o;
                bmm5.getClass();
                Object x6 = null;
                try {
                    if ((o = bmm5.d()[0]) == null) {}
                }
                finally {
                    final Throwable t12;
                    x6 = bhu.x(t12);
                }
                if (x6 instanceof dcx) {
                    x6 = s;
                }
                String s6;
                if ((s6 = (String)x6) == null) {
                    s6 = "";
                }
                if (s6.equals(StaticUtils.decryptString(-492078698068778L))) {
                    bmm5.h((Object)((akf)azq.a).o());
                }
                return a2;
            }
            case 7: {
                final amm amm2 = (amm)o;
                amm2.b = (bgf)new ayz(9);
                amm2.c = (bgf)new ayz(10);
                return a2;
            }
            case 6: {
                final View view3 = (View)o;
                final cee e = cee.e(LayoutInflater.from(view3.getContext()));
                ((TextView)e.c).setText((CharSequence)((akf)azq.a).o());
                final bzy bzy3 = new bzy(view3.getContext());
                azr.a.getClass();
                final String i2 = azr.i;
                final eg eg3 = (eg)((ek)bzy3).d;
                eg3.d = i2;
                final LinearLayout b2 = e.b;
                ((ek)bzy3).t(StaticUtils.decryptString(-492121647741738L), new amw((bfu)new aul(e, 1), 0));
                ((ek)bzy3).s(StaticUtils.decryptString(-492074403101482L), new amw((bfu)new amd(4), 2));
                final String z7 = StaticUtils.decryptString(-47455093652266L);
                amd amd4 = amd2;
                if ((0x3 & 0x2) != 0x0) {
                    amd4 = new amd(1);
                }
                bjs.x(amd4, bzy3, z7);
                if (b2 != null) {
                    eg3.r = (View)b2;
                }
                ((Dialog)bzy3.i()).show();
                return a2;
            }
            case 5: {
                final bah bah8 = (bah)o;
                final String z8 = StaticUtils.decryptString(-40054865001258L);
                bah8.getClass();
                bah8.a = la.ab((Object[])new String[] { z8 });
                final Object d9 = new Object();
                ((cdj)d9).t(new String[] { StaticUtils.decryptString(-39895951211306L), StaticUtils.decryptString(-41450729372458L) });
                bah8.d = (cdj)d9;
                return a2;
            }
            case 4: {
                final bah bah9 = (bah)o;
                final String z9 = StaticUtils.decryptString(-41261750811434L);
                bah9.getClass();
                bah9.a = la.ab((Object[])new String[] { z9 });
                final Object d10 = new Object();
                ((cdj)d10).t(new String[] { StaticUtils.decryptString(-41669772704554L), StaticUtils.decryptString(-41575283424042L) });
                bah9.d = (cdj)d10;
                return a2;
            }
            case 3: {
                ((amm)o).c = (bgf)new ayz(4);
                return a2;
            }
            case 2: {
                ((amm)o).c = (bgf)new ayz(5);
                return a2;
            }
            case 1: {
                return dnr.bp(((Class)o).getName(), StaticUtils.decryptString(-39685497813802L), false);
            }
            case 0: {
                final bmm bmm6 = (bmm)o;
                bmm6.getClass();
                Object x7 = null;
                try {
                    if ((o = bmm6.d()[0]) == null) {}
                }
                finally {
                    final Throwable t13;
                    x7 = bhu.x(t13);
                }
                if (x7 instanceof dcx) {
                    x7 = menuItem3;
                }
                bzo.n(x7);
                final MenuItem menuItem6 = (MenuItem)x7;
                final int a13 = bte.a;
                final azg aa2 = dkz.aa(bmm6);
                aa2.a = dal.b((Class)Integer.TYPE);
                o = aaz.e(aa2.c());
                o = ((azk)o).e();
                bzo.n(o);
                final int intValue3 = ((Number)o).intValue();
                final azg aa3 = dkz.aa(bmm6);
                ((cbh)aa3).ab = StaticUtils.decryptString(-39797166963498L);
                o = aaz.e(aa3.c());
                o = ((azk)o).d();
                bzo.n(o);
                final azg r7 = dqc.bi(o).r();
                r7.b = (bgf)new ayz(1);
                o = aaz.e(r7.c());
                o = ((azk)o).e();
                bzo.n(o);
                final Object item = ((Adapter)o).getItem(intValue3);
                final Iterator iterator11 = azd.b.iterator();
                while (iterator11.hasNext()) {
                    o = iterator11.next();
                    o = o;
                    try {
                        for (final aza aza : ((cie)o).i()) {
                            final int itemId = menuItem6.getItemId();
                            aza.getClass();
                            if (itemId == 0x6009001b) {
                                aza.b.invoke(item);
                            }
                        }
                        continue;
                    }
                    catch (final Exception ex5) {
                        final ArrayList a14 = ewq.a;
                        final StringBuilder sb5 = new StringBuilder();
                        sb5.append(StaticUtils.decryptString(-39805756898090L));
                        String s7;
                        if (o instanceof doo) {
                            s7 = ((doo)o).f();
                        }
                        else {
                            s7 = StaticUtils.decryptString(-39741332388650L);
                        }
                        ewq.e(yg.n(sb5, s7, -39719857552170L), ex5, 12);
                        continue;
                    }
                    break;
                }
                return a2;
            }
        }
    }
}

