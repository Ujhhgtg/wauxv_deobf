//
// Decompiled by Procyon - 2794ms
//
package me.hd.wauxv.obf;

import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import android.view.ViewGroup;
import java.util.Arrays;
import android.util.AttributeSet;
import java.io.Serializable;
import java.util.Collection;
import android.content.res.XmlResourceParser;
import android.view.View;
import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.LinkedHashMap;

public final class blu
{
    public static final LinkedHashMap a;
    public static final AtomicInteger b;
    public static final boolean c;
    public final List d;
    public final LinkedHashSet e;
    public final LinkedHashMap f;
    public final LinkedHashMap g;

    static {
        a = new LinkedHashMap();
        b = new AtomicInteger(0x07f00000);
        c = true;
    }

    public blu(final List d) {
        super();
        this.d = d;
        this.e = new LinkedHashSet();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public static final View h(final blu blu, final Class clazz, String name, final Context context) {
        final String s = name;
        ewm.a.getClass();
        XmlResourceParser xmlResourceParser = null;
        Label_0147: {
            if (eu.b(28)) {
                if (!ewm.g) {
                    xmlResourceParser = ewm.j(context);
                }
                else {
                    if (ewm.f != null) {
                        final cdk cdk = (cdk)ewm.i.getValue();
                        if (cdk != null) {
                            final cdk d = cdk.d();
                            ((bpu)d).h((Object)ewm.f);
                            xmlResourceParser = (XmlResourceParser)d.i(new Object[] { 0x01030012 });
                            if (xmlResourceParser != null) {
                                break Label_0147;
                            }
                        }
                        throw new IllegalStateException("Failed to create parser.");
                    }
                    throw new IllegalArgumentException("Hikage initialization failed.");
                }
            }
            else {
                xmlResourceParser = ewm.j(context);
            }
        }
        final blr blr = (blr)aaz.f((Collection)blu.e);
        final View view = null;
        ViewGroup b;
        if (blr != null) {
            b = blr.b;
        }
        else {
            b = null;
        }
        final Iterator iterator = blu.d.iterator();
        Object o = null;
        while (iterator.hasNext()) {
            final View view2 = (View)((blv)iterator.next()).c((Object)b, o, (Object)context, (Serializable)new bls(s, xmlResourceParser, clazz));
            if (view2 != null) {
                final Class<? extends View> class1 = view2.getClass();
                final ConcurrentHashMap a = zf.a;
                if (!clazz.isAssignableFrom(class1)) {
                    final Class<? extends View> class2 = view2.getClass();
                    final String name2 = clazz.getName();
                    final StringBuilder sb = new StringBuilder("HikageFactory cannot cast the created view type \"");
                    sb.append(class2);
                    sb.append("\" to \"");
                    sb.append(name2);
                    sb.append("\", please confirm that the view type you created is correct.");
                    throw new Exception(sb.toString());
                }
            }
            if (view2 != null) {
                o = view2;
            }
        }
        if (o == null) {
            name = clazz.getName();
            final LinkedHashMap a2 = blu.a;
            final Object value = a2.get(name);
            blt blt;
            if (value instanceof blt) {
                blt = (blt)value;
            }
            else {
                blt = null;
            }
            blt blt2 = blt;
            if (blt == null) {
                final int a3 = bte.a;
                final bmu bh = dqc.bh(clazz);
                bh.v(true);
                final adt m = bh.m();
                ((axd)m).z(Arrays.copyOf(new Object[] { dal.b((Class)Context.class), dal.b((Class)AttributeSet.class) }, 2));
                adu adu = (adu)aaz.g(m.a());
                final bmu bh2 = dqc.bh(clazz);
                bh2.v(true);
                final adt i = bh2.m();
                ((axd)i).z(Arrays.copyOf(new Object[] { dal.b((Class)Context.class) }, 1));
                final adu adu2 = (adu)aaz.g(i.a());
                int n;
                if (adu2 != null) {
                    adu = adu2;
                    n = 1;
                }
                else if (adu != null) {
                    n = 2;
                }
                else {
                    n = 0;
                    adu = null;
                }
                blt blt3;
                if (adu != null) {
                    blt3 = new blt(adu, n);
                }
                else {
                    blt3 = null;
                }
                blt2 = blt3;
                if (blt3 != null) {
                    a2.put(clazz.getName(), blt3);
                    blt2 = blt3;
                }
            }
            o = view;
            if (blt2 != null) {
                final adu a4 = blt2.a;
                final int b2 = blt2.b;
                if (b2 != 1) {
                    if (b2 != 2) {
                        o = view;
                    }
                    else {
                        o = a4.c(new Object[] { context, xmlResourceParser });
                    }
                }
                else {
                    o = a4.c(new Object[] { context });
                }
            }
        }
        if (o == null) {
            throw new Exception(bjs.o("Create view of type ", clazz.getName(), " failed. Please make sure the view class has a constructor with a single parameter of type Context."));
        }
        final LinkedHashMap g = blu.g;
        String concat;
        if ((concat = s) == null) {
            final int andIncrement = blu.b.getAndIncrement();
            final int[] a5 = bkx.a;
            final bla a6 = bla.a;
            bzo.q((Object)a6, "format");
            String s2;
            if (a6.b) {
                s2 = "0123456789ABCDEF";
            }
            else {
                s2 = "0123456789abcdef";
            }
            String str;
            if (a6.d.c) {
                str = new String(new char[] { s2.charAt(andIncrement >> 28 & 0xF), s2.charAt(andIncrement >> 24 & 0xF), s2.charAt(andIncrement >> 20 & 0xF), s2.charAt(andIncrement >> 16 & 0xF), s2.charAt(andIncrement >> 12 & 0xF), s2.charAt(andIncrement >> 8 & 0xF), s2.charAt(andIncrement >> 4 & 0xF), s2.charAt(andIncrement & 0xF) });
            }
            else {
                final long n2 = andIncrement;
                final long n3 = 0;
                final long n4 = n3 + n3 + 8 + n3;
                if (0L > n4 || n4 > 2147483647L) {
                    final StringBuilder sb2 = new StringBuilder("The resulting string length is too big: ");
                    sb2.append((Object)bhv.aj(10, n4));
                    throw new IllegalArgumentException(sb2.toString());
                }
                final int n5 = (int)n4;
                final char[] array = new char[n5];
                int n6 = 32;
                int j;
                int count;
                for (j = 0, count = 0; j < 8; ++j, ++count) {
                    n6 -= 4;
                    array[count] = s2.charAt((int)(n2 >> n6 & 0xFL));
                }
                if (count == n5) {
                    str = new String(array);
                }
                else {
                    cnh.j(0, count, n5);
                    str = new String(array, 0, count);
                }
            }
            concat = "anonymous@".concat(str);
        }
        final int generateViewId = View.generateViewId();
        if (!g.containsKey(concat)) {
            g.put(concat, generateViewId);
            ((View)o).setId(generateViewId);
            blu.f.put(concat, o);
            return (View)o;
        }
        throw new Exception(bjs.o("View with id \"", concat, "\" already exists."));
    }

    public static final blr i(final blu blu, Class clazz, final ViewGroup viewGroup, final boolean b, final Context context) {
        final blr e = new blr(blu, (Class)clazz, viewGroup, b, context);
        Label_0948: {
            if (context != null) {
                ewm.a.getClass();
                clazz = context.getClass();
                if (!dnr.bi(clazz.getName(), "BridgeContext")) {
                    final ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
                    final ewl h = ewm.h;
                    if (((Number)eu.a.getValue()).intValue() > 28) {
                        if (!ewm.g) {
                            final String sourceDir = applicationInfo.sourceDir;
                            final boolean b2 = eu.b(30);
                            final cdy e2 = cdy.e;
                            final Class<Boolean> type = Boolean.TYPE;
                            Object o = null;
                            Label_0602: {
                                if (b2) {
                                    final int a = bte.a;
                                    final jx c = ewm.c;
                                    final btc btc = ewm.b[0];
                                    final bmu bh = dqc.bh(c.w());
                                    ((cbg)bh.h).c = (cbm)h;
                                    bh.v(false);
                                    final cde t = bh.t();
                                    ((cbh)t).ab = "nativeLoad";
                                    final Class<Integer> type2 = Integer.TYPE;
                                    ((axd)t).z(Arrays.copyOf(new Object[] { dal.b((Class)type2), dal.b((Class)String.class), dal.b((Class)type2), dal.b(evt.b()) }, 4));
                                    t.ak(new cdy[] { e2 });
                                    final cdk cdk = (cdk)aaz.g(t.aj());
                                    if (cdk != null) {
                                        o = cdk.f(new Object[] { 0, sourceDir, 1, null });
                                        break Label_0602;
                                    }
                                }
                                else {
                                    if (!eu.b(28)) {
                                        throw new IllegalStateException("Unsupported Android version.");
                                    }
                                    final int a2 = bte.a;
                                    final jx c2 = ewm.c;
                                    final btc btc2 = ewm.b[0];
                                    final bmu bh2 = dqc.bh(c2.w());
                                    ((cbg)bh2.h).c = (cbm)h;
                                    bh2.v(false);
                                    final cde t2 = bh2.t();
                                    ((cbh)t2).ab = "nativeLoad";
                                    ((axd)t2).z(Arrays.copyOf(new Object[] { dal.b((Class)String.class), dal.b((Class)type), dal.b((Class)type), dal.b((Class)type) }, 4));
                                    t2.ak(new cdy[] { e2 });
                                    final cdk cdk2 = (cdk)aaz.g(t2.aj());
                                    if (cdk2 != null) {
                                        final Boolean false = Boolean.FALSE;
                                        o = cdk2.f(new Object[] { sourceDir, false, false, false });
                                        break Label_0602;
                                    }
                                }
                                o = null;
                            }
                            Long e3;
                            if (o instanceof Long) {
                                e3 = (Long)o;
                            }
                            else {
                                e3 = null;
                            }
                            if (e3 != null) {
                                ewm.e = e3;
                                final jx d = ewm.d;
                                final btc btc3 = ewm.b[1];
                                clazz = d.w();
                                final bmu bh3 = dqc.bh((Class)clazz);
                                ((cbg)bh3.h).c = (cbm)h;
                                bh3.v(false);
                                final adt m = bh3.m();
                                final boolean b3 = eu.b(36);
                                final Class<Long> type3 = Long.TYPE;
                                if (b3) {
                                    ((axd)m).z(Arrays.copyOf(new Object[] { dal.b((Class)AssetManager.class), dal.b((Class)type3), dal.b((Class)type) }, 3));
                                }
                                else {
                                    ((axd)m).z(Arrays.copyOf(new Object[] { dal.b((Class)AssetManager.class), dal.b((Class)type3) }, 2));
                                }
                                final adu adu = (adu)aaz.g(m.a());
                                if (adu != null) {
                                    AutoCloseable f;
                                    if (eu.b(36)) {
                                        f = (AutoCloseable)adu.c(new Object[] { null, ewm.e, Boolean.FALSE });
                                    }
                                    else {
                                        f = (AutoCloseable)adu.c(new Object[] { null, ewm.e });
                                    }
                                    if (f != null) {
                                        ewm.f = f;
                                        ewm.g = true;
                                        break Label_0948;
                                    }
                                }
                                throw new IllegalStateException("Failed to create XmlBlock$Parser.");
                            }
                            throw new IllegalStateException("Failed to create ApkAssets.");
                        }
                    }
                }
            }
        }
        blu.e.add(e);
        return e;
    }

    public final View j(String o) {
        final View view = this.f.get(o);
        if (view != null) {
            return view;
        }
        o = bjs.o("View with id \"", o, "\" not found.");
        throw new Exception(o);
    }

    public final View k() {
        final View view = (View)aaz.f((Collection)this.f.values());
        if (view != null) {
            return view;
        }
        throw new Exception("No root view found, are you sure you have provided any view?");
    }
}

