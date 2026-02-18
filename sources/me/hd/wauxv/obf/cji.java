package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cji extends cjg implements Iterable, IEmpty {
    public static final /* synthetic */ int a = 0;
    public final xe b;

    public cji(cjk cjkVar) {
        super(cjkVar);
        this.b = new xe(this);
    }

    public final void c(cjg cjgVar) {
        throwIfVar1IsNull(cjgVar, "node");
        xe xeVar = this.b;
        dlo dloVar = (dlo) xeVar.e;
        cji cjiVar = (cji) xeVar.d;
        ea eaVar = cjgVar.g;
        int i = eaVar.a;
        String str = (String) eaVar.f;
        if (i == 0 && str == null) {
            throw new IllegalArgumentException(
                    "Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
        }
        String str2 = (String) cjiVar.g.f;
        if (str2 != null && nullSafeIsEqual(str, str2)) {
            throw new IllegalArgumentException(
                    ("Destination " + cjgVar + " cannot have the same route as graph " + cjiVar).toString());
        }
        if (i == cjiVar.g.a) {
            throw new IllegalArgumentException(
                    ("Destination " + cjgVar + " cannot have the same id as graph " + cjiVar).toString());
        }
        cjg cjgVar2 = (cjg) dloVar.f(i);
        if (cjgVar2 == cjgVar) {
            return;
        }
        if (cjgVar.h != null) {
            throw new IllegalStateException(
                    "Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (cjgVar2 != null) {
            cjgVar2.h = null;
        }
        cjgVar.h = cjiVar;
        dloVar.h(eaVar.a, cjgVar);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final void d(Context context, AttributeSet attributeSet) {
        String strValueOf;
        super.d(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, cyc.d);
        throwIfVar1IsNull(typedArrayObtainAttributes, "obtainAttributes(...)");
        int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
        xe xeVar = this.b;
        cji cjiVar = (cji) xeVar.d;
        if (resourceId == cjiVar.g.a) {
            throw new IllegalArgumentException(
                    ("Start destination " + resourceId + " cannot use the same id as the graph " + cjiVar).toString());
        }
        xeVar.c = resourceId;
        xeVar.f = null;
        if (resourceId <= 16777215) {
            strValueOf = String.valueOf(resourceId);
        } else {
            try {
                strValueOf = context.getResources().getResourceName(resourceId);
                throwIfVar1IsNull(strValueOf);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(resourceId);
            }
        }
        xeVar.f = strValueOf;
        typedArrayObtainAttributes.recycle();
    }

    @Override // me.hd.wauxv.obf.cjg
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof cji) || !super.equals(obj)) {
            return false;
        }
        xe xeVar = this.b;
        int i = ((dlo) xeVar.e).i();
        xe xeVar2 = ((cji) obj).b;
        if (i != ((dlo) xeVar2.e).i() || xeVar.c != xeVar2.c) {
            return false;
        }
        dlo dloVar = (dlo) xeVar.e;
        throwIfVar1IsNull(dloVar, "<this>");
        for (cjg cjgVar : (ada) dfv.a(new z(dloVar, 3))) {
            if (!cjgVar.equals(((dlo) xeVar2.e).f(cjgVar.g.a))) {
                return false;
            }
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.cjg
    public final int hashCode() {
        xe xeVar = this.b;
        int iG = xeVar.c;
        dlo dloVar = (dlo) xeVar.e;
        int i = dloVar.i();
        for (int i2 = 0; i2 < i; i2++) {
            iG = (((iG * 31) + dloVar.g(i2)) * 31) + ((cjg) dloVar.j(i2)).hashCode();
        }
        return iG;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        xe xeVar = this.b;
        xeVar.getClass();
        return new cjj(xeVar);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final cjf o(jx jxVar) {
        cjf cjfVarO = super.o(jxVar);
        xe xeVar = this.b;
        xeVar.getClass();
        return xeVar.m(cjfVarO, jxVar, false, (cji) xeVar.d);
    }

    public final cjg p(int i) {
        xe xeVar = this.b;
        return xeVar.k(i, (cji) xeVar.d, null, false);
    }

    public final cjf q(jx jxVar, cjg cjgVar) {
        return this.b.m(super.o(jxVar), jxVar, true, cjgVar);
    }

    @Override // me.hd.wauxv.obf.cjg
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        xe xeVar = this.b;
        xeVar.getClass();
        xeVar.getClass();
        cjg cjgVarP = p(xeVar.c);
        sb.append(" startDestination=");
        if (cjgVarP == null) {
            String str = (String) xeVar.f;
            if (str != null) {
                sb.append(str);
            } else {
                sb.append("0x" + Integer.toHexString(xeVar.c));
            }
        } else {
            sb.append("{");
            sb.append(cjgVarP.toString());
            sb.append("}");
        }
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }
}
