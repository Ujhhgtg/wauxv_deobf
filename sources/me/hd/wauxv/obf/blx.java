//
// Decompiled by Procyon - 1654ms
//
package me.hd.wauxv.obf;

import java.util.Random;
import java.util.Arrays;
import me.hd.wauxv.hook.HookEntry;
import android.content.Intent;
import java.util.List;
import android.content.Context;
import java.util.Map;
import java.io.File;

public final synthetic class blx implements IInvokable
{
    public final int a;

    public blx(final int a) {
        this.a = a;
        super();
    }

    public final Object invoke(Object key) {
        final int a = this.a;
        final Class<Boolean> clazz = Boolean.class;
        final boolean b = true;
        final boolean b2 = true;
        final boolean b3 = true;
        final boolean b4 = true;
        boolean b5 = true;
        boolean b6 = true;
        final boolean b7 = true;
        final ens a2 = ens.a;
        switch (a) {
            default: {
                final bah bah = (bah)key;
                final String z = cnb.z(-355395658840874L);
                bah.getClass();
                bah.a = la.ab((Object[])new String[] { z });
                final Object d = new Object();
                ((cdj)d).t(new String[] { cnb.z(-355258219887402L), cnb.z(-355146550737706L) });
                bah.d = (cdj)d;
                return a2;
            }
            case 28: {
                ((amm)key).c = (bgf)new blx(29);
                return a2;
            }
            case 27: {
                ((amm)key).c = (bgf)new bty(0);
                return a2;
            }
            case 26: {
                return ((File)key).isFile();
            }
            case 25: {
                final Map.Entry entry = (Map.Entry)key;
                bzo.q((Object)entry, "<destruct>");
                key = entry.getKey();
                final String s = (String)key;
                final brx obj = (brx)entry.getValue();
                final StringBuilder sb = new StringBuilder();
                dng.c(sb, s);
                sb.append(':');
                sb.append(obj);
                return sb.toString();
            }
            case 24: {
                final zd zd = (zd)key;
                bzo.q((Object)zd, "$this$buildSerialDescriptor");
                me.hd.wauxv.obf.zd.g(zd, "JsonPrimitive", (dfx)new bsc((bfu)new amd(21)));
                me.hd.wauxv.obf.zd.g(zd, "JsonNull", (dfx)new bsc((bfu)new amd(22)));
                me.hd.wauxv.obf.zd.g(zd, "JsonLiteral", (dfx)new bsc((bfu)new amd(23)));
                me.hd.wauxv.obf.zd.g(zd, "JsonObject", (dfx)new bsc((bfu)new amd(24)));
                me.hd.wauxv.obf.zd.g(zd, "JsonArray", (dfx)new bsc((bfu)new amd(25)));
                return a2;
            }
            case 23: {
                final char charValue = (char)key;
                return '0' <= charValue && charValue < ':' && b7;
            }
            case 22: {
                return (char)key == ':' && b;
            }
            case 21: {
                return (char)key == ':' && b2;
            }
            case 20: {
                final char charValue2 = (char)key;
                boolean b8 = b3;
                if (charValue2 != 'T') {
                    b8 = (charValue2 == 't' && b3);
                }
                return b8;
            }
            case 19: {
                return (char)key == '-' && b4;
            }
            case 18: {
                if ((char)key != '-') {
                    b5 = false;
                }
                return b5;
            }
            case 17: {
                final bah bah2 = (bah)key;
                final Object d2 = new Object();
                Class<Context> bf = cnf.bf(dal.b((Class)Context.class));
                if (bf == null) {
                    bf = Context.class;
                }
                Class<List> bf2 = cnf.bf(dal.b((Class)List.class));
                if (bf2 == null) {
                    bf2 = List.class;
                }
                Class<Intent> bf3 = cnf.bf(dal.b((Class)Intent.class));
                if (bf3 == null) {
                    bf3 = Intent.class;
                }
                Class<String> bf4 = cnf.bf(dal.b((Class)String.class));
                if (bf4 == null) {
                    bf4 = String.class;
                }
                Class<Integer> bf5 = cnf.bf(dal.b((Class)Integer.class));
                if (bf5 == null) {
                    bf5 = Integer.class;
                }
                Class<Boolean> bf6 = cnf.bf(dal.b((Class)Boolean.class));
                if (bf6 == null) {
                    bf6 = Boolean.class;
                }
                ((cdj)d2).q(new Class[] { bf, bf2, bf3, bf4, bf5, null, bf6 });
                bah2.getClass();
                bah2.d = (cdj)d2;
                return a2;
            }
            case 16: {
                final bag bag = (bag)key;
                final String z2 = cnb.z(-375040839252778L);
                bag.getClass();
                bag.a = la.ab((Object[])new String[] { z2 });
                final Object b9 = new Object();
                ((zb)b9).k(new String[] { cnb.z(-375457451080490L), cnb.z(-375362961799978L) });
                bag.b = (zb)b9;
                return a2;
            }
            case 15: {
                final amm amm = (amm)key;
                amm.b = (bgf)new blx(16);
                amm.c = (bgf)new blx(17);
                return a2;
            }
            case 14: {
                final bag bag2 = (bag)key;
                key = new Object();
                ((zb)key).k(new String[] { cnb.z(-373082334165802L), cnb.z(-370230475881258L) });
                bag2.getClass();
                bag2.b = (zb)key;
                return a2;
            }
            case 13: {
                ((amm)key).b = (bgf)new blx(14);
                return a2;
            }
            case 12: {
                final bag bag3 = (bag)key;
                final String z3 = cnb.z(-373632089979690L);
                bag3.getClass();
                bag3.a = la.ab((Object[])new String[] { z3 });
                final Object b10 = new Object();
                ((zb)b10).k(new String[] { cnb.z(-373000729787178L), cnb.z(-372897650572074L) });
                bag3.b = (zb)b10;
                return a2;
            }
            case 11: {
                ((amm)key).b = (bgf)new blx(12);
                return a2;
            }
            case 10: {
                final bag bag4 = (bag)key;
                final Object b11 = new Object();
                ((zb)b11).k(new String[] { cnb.z(-369100899482410L), cnb.z(-368997820267306L) });
                bag4.getClass();
                bag4.b = (zb)b11;
                return a2;
            }
            case 9: {
                final bag bag5 = (bag)key;
                key = new Object();
                final azl e = new azl();
                e.f(emn.az((amn)bok.a));
                e.f(emn.az((amn)boi.a));
                ((zb)key).e = e;
                bag5.getClass();
                bag5.b = (zb)key;
                return a2;
            }
            case 8: {
                final bag bag6 = (bag)key;
                final Object b12 = new Object();
                ((zb)b12).k(new String[] { cnb.z(-368946280659754L), cnb.z(-369350007585578L) });
                bag6.getClass();
                bag6.b = (zb)b12;
                return a2;
            }
            case 7: {
                ((amm)key).b = (bgf)new blx(9);
                return a2;
            }
            case 6: {
                ((amm)key).b = (bgf)new blx(8);
                return a2;
            }
            case 5: {
                ((amm)key).b = (bgf)new blx(10);
                return a2;
            }
            case 4: {
                final csb csb = (csb)key;
                HookEntry.a.getClass();
                final byte[] bytes = cnb.z(-71798968285994L).getBytes(uj.a);
                bzo.p((Object)bytes, cnb.z(-77764677860138L));
                final boolean equals = Arrays.equals(bytes, new byte[] { 87, 65, 117, 120, 105, 108, 105, 97, 114, 121 });
                if (System.currentTimeMillis() - exl.b <= 10368000000L) {
                    b6 = false;
                }
                if (!equals || b6) {
                    key = new Random();
                    if (((Random)key).nextFloat() < 0.25f) {
                        return a2;
                    }
                }
                final String z4 = cnb.z(-77756087925546L);
                final eui a3 = eui.a;
                final csc aa = csb.aa;
                bmk a4;
                if (aa != null) {
                    a4 = aa.a;
                }
                else {
                    a4 = null;
                }
                if (a4 != bmk.a) {
                    String s2;
                    if (aa != null) {
                        s2 = aa.b;
                    }
                    else {
                        ki.a.getClass();
                        s2 = ki.i();
                    }
                    if (s2.equals(z4) || StringsKt.isBlank((CharSequence)z4)) {
                        csb.ae((ewy)a3);
                    }
                }
                return a2;
            }
            case 3: {
                final DexMethodQueryBuilder bah3 = (DexMethodQueryBuilder)key;
                final String z5 = "com.tencent.mm.ui";
                bah3.getClass();
                bah3.a = SomeStaticHelpers.arrayToList(new String[] { z5 });
                final Object d3 = new Object();
                ((cdj)d3).t(new String[] { "MicroMsg.PlusSubMenuHelper", "processOnItemClick" });
                bah3.d = (cdj)d3;
            }
            case 2: {
                final DexMethodQueryBuilder bah4 = (DexMethodQueryBuilder)key;
                final String z6 = "com.tencent.mm.ui";
                bah4.a = SomeStaticHelpers.arrayToList(new String[] { z6 });
                final Object d4 = new Object();
                ((DexFinder)d4).t(new String[] { "MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one" });
                bah4.d = (DexFinder)d4;
            }
            case 1: {
                final Class clazz2 = (Class)key;
                Class<Boolean> bf7 = cnf.bf(dal.b((Class)Boolean.class));
                if (bf7 == null) {
                    bf7 = clazz;
                }
                return bzo.f((Object)clazz2, (Object)bf7) ^ true;
            }
            case 0: {
                ((amm)key).c = (bgf)new blx(3);
                return a2;
            }
        }
    }
}

