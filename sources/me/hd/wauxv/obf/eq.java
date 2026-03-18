//
// Decompiled by Procyon - 1560ms
//
package me.hd.wauxv.obf;

import com.alibaba.fastjson2.JSONObject;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.alibaba.fastjson2.JSON;

public final class eq extends doi implements Function2
{
    public final int a;
    public int d;
    public Object e;
    public Object f;

    public eq(final int n, final DispatchedContinuation DispatchedContinuation) {
        super(n, DispatchedContinuation);
        this.a = 2;
    }

    public eq(final bgj bgj, final DispatchedContinuation DispatchedContinuation) {
        super(2, DispatchedContinuation);
        this.a = 0;
        this.f = bgj;
    }

    public eq(final bqq e, final zn f, final DispatchedContinuation DispatchedContinuation) {
        super(2, DispatchedContinuation);
        this.a = 1;
        this.e = e;
        this.f = f;
    }

    public final Object g(Object o, final Object o2) {
        final int a = this.a;
        final ahp ahp = (ahp)o;
        final DispatchedContinuation DispatchedContinuation = (DispatchedContinuation)o2;
        switch (a) {
            default: {
                o = ((eq)this.h(ahp, DispatchedContinuation)).i(DexFinder.a);
                return o;
            }
            case 1: {
                o = ((eq)this.h(ahp, DispatchedContinuation)).i(ens.a);
                return o;
            }
            case 0: {
                o = ((eq)this.h(ahp, DispatchedContinuation)).i(ens.a);
                return o;
            }
        }
    }

    public final DispatchedContinuation h(Object e, final DispatchedContinuation DispatchedContinuation) {
        switch (this.a) {
            default: {
                final eq eq = new eq(2, DispatchedContinuation);
                eq.e = e;
                return (DispatchedContinuation)eq;
            }
            case 1: {
                e = this.e;
                return (DispatchedContinuation)new eq((bqq)e, (zn)this.f, DispatchedContinuation);
            }
            case 0: {
                final eq eq2 = new eq((bgj)this.f, DispatchedContinuation);
                eq2.e = e;
                return (DispatchedContinuation)eq2;
            }
        }
    }

    public final Object i(Object o) {
        final int a = this.a;
        Object a2 = ens.a;
        final CoroutineStateEnum a3 = CoroutineStateEnum.a;
        switch (a) {
            default: {
                final ahp ahp = (ahp)this.e;
                final int d = this.d;
                Label_0422: {
                    cla f;
                    if (d != 0) {
                        if (d != 1) {
                            if (d == 2) {
                                bhu.bd(o);
                                break Label_0422;
                            }
                            throw new IllegalStateException(StaticUtils.decryptString(-480306192710442L));
                        }
                        else {
                            f = (cla)this.f;
                            bhu.bd(o);
                        }
                    }
                    else {
                        bhu.bd(o);
                        final bjm a4 = bjm.a;
                        bjm.t(a4);
                        bjm.u(a4);
                        final String z = "https://api.fpfast.top/shared/user/getallinfo";
                        final alc a5 = aou.a;
                        final akq f2 = akq.f;
                        final dob dob = new dob();
                        final cla cla = new cla(ajn.g(ahp, bmy.aa((ahf)f2, dob), (bgj)new bho(z, null, 1)));
                        f = new cla(ajn.g(ahp, bmy.aa((ahf)f2, new dob()), (bgj)new bho("https://hd.slzzs.me/wauxv/api/getGroupTitle.php", null, 2)));
                        this.e = null;
                        this.f = f;
                        this.d = 1;
                        o = cla._be((DispatchedContinuation)this);
                        if (o == a3) {
                            return a3;
                        }
                    }
                    final JSONObject object = JSON.parseObject((String)o);
                    if (bzo.f(object.get("code"), (Object)new Integer(0))) {
                        ((akf)bjk.a).u(object.getJSONArray("data").toString());
                        bjm.t(bjm.a);
                    }
                    this.e = null;
                    this.f = null;
                    this.d = 2;
                    if ((o = ((alp)f)._be(this)) != a3) {
                        break Label_0422;
                    }
                    return a3;
                }
                final JSONObject object2 = JSON.parseObject((String)o);
                final Object value = object2.get("code");
                o = new Integer(0);
                final boolean f3 = bzo.f(value, o);
                Object o2 = a2;
                if (f3) {
                    ((akf)bjl.a).u(object2.getJSONArray("data").toString());
                    bjm.u(bjm.a);
                    o2 = a2;
                }
                return o2;
            }
            case 1: {
                final zn zn = (zn)this.f;
                final int d2 = this.d;
                if (d2 != 0) {
                    if (d2 != 1) {
                        throw new IllegalStateException("");
                    }
                    bhu.bd(o);
                }
                else {
                    bhu.bd(o);
                    final zl zl = new zl(zn, null, 0);
                    this.d = 1;
                    final dov a6 = doh.a;
                    final alc a7 = aou.a;
                    if ((o = ajn.ak((ahh)akq.f, (bgj)zl, (doi)this)) == a3) {
                        a2 = a3;
                        return a2;
                    }
                }
                final String str = (String)o;
                final MaterialCheckBox materialCheckBox = (MaterialCheckBox)((bqq)this.e).c;
                final StringBuilder sb = new StringBuilder();
                sb.append(zn.a);
                sb.append(StaticUtils.decryptString(-11587821763370L));
                sb.append(str);
                sb.append(')');
                materialCheckBox.setText(sb.toString());
                return a2;
            }
            case 0: {
                final int d3 = this.d;
                if (d3 != 0) {
                    if (d3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bhu.bd(o);
                }
                else {
                    bhu.bd(o);
                    o = this.e;
                    final ahp ahp2 = (ahp)o;
                    final doi doi = (doi)this.f;
                    this.d = 1;
                    o = ((bgj)doi).g((Object)ahp2, (Object)this);
                    if (o == a3) {
                        a2 = a3;
                    }
                }
                return a2;
            }
        }
    }
}

