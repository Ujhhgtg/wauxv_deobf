package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsAnimation;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class but implements aja, app, cqk, evw {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;

    public /* synthetic */ but(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        esn esnVar = (esn) this.b;
        baw bawVar = (baw) this.c;
        baw bawVar2 = new baw();
        bawVar2.a = bawVar.a;
        bawVar2.b = bawVar.b;
        bawVar2.c = bawVar.c;
        bawVar2.d = bawVar.d;
        return esnVar.q(view, evrVar, bawVar2);
    }

    @Override // me.hd.wauxv.obf.aja
    public void _bo(Object obj) {
        dld dldVar = (dld) this.c;
        cdu cduVar = (cdu) this.b;
        cdu cduVar2 = dldVar.h;
        if (cduVar2 == null || cduVar2 != cduVar) {
            return;
        }
        dld dldVar2 = (dld) this.c;
        cdu cduVar3 = (cdu) this.b;
        aoi aoiVar = dldVar2.c.p;
        if (obj != null && aoiVar.e(cduVar3.c.e())) {
            dldVar2.g = obj;
            dldVar2.d.at(2);
        } else {
            ajr ajrVar = dldVar2.d;
            btj btjVar = cduVar3.a;
            ajb ajbVar = cduVar3.c;
            ajrVar.a(btjVar, obj, ajbVar, ajbVar.e(), dldVar2.i);
        }
    }

    public void aa(Bundle bundle) {
        deo deoVar = (deo) this.b;
        dep depVar = deoVar.a;
        if (!deoVar.e) {
            deoVar.i();
        }
        if (depVar.ap().c.compareTo(buh.d) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + depVar.ap().c).toString());
        }
        if (deoVar.g) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundle2 = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            if (bundle3 == null) {
                cmz.ad("androidx.lifecycle.BundlableSavedStateRegistry.key");
                throw null;
            }
            bundle2 = bundle3;
        }
        deoVar.f = bundle2;
        deoVar.g = true;
    }

    public void ab(Bundle bundle) {
        deo deoVar = (deo) this.b;
        Bundle bundleR = bht.r((csm[]) Arrays.copyOf(new csm[0], 0));
        Bundle bundle2 = deoVar.f;
        if (bundle2 != null) {
            bundleR.putAll(bundle2);
        }
        synchronized (deoVar.c) {
            for (Map.Entry entry : deoVar.d.entrySet()) {
                cnb.ag(bundleR, (String) entry.getKey(), ((den) entry.getValue()).c());
            }
        }
        if (bundleR.isEmpty()) {
            return;
        }
        cnb.ag(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key", bundleR);
    }

    public cjn ac(czx czxVar, int i) {
        erf erfVar;
        cjn cjnVar;
        dhq dhqVar = (dhq) this.b;
        int iP = dhqVar.p(czxVar);
        if (iP >= 0 && (erfVar = (erf) dhqVar.s(iP)) != null) {
            int i2 = erfVar.b;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                erfVar.b = i3;
                if (i == 4) {
                    cjnVar = erfVar.c;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cjnVar = erfVar.d;
                }
                if ((i3 & 12) == 0) {
                    dhqVar.h(iP);
                    erfVar.b = 0;
                    erfVar.c = null;
                    erfVar.d = null;
                    erf.a.l(erfVar);
                }
                return cjnVar;
            }
        }
        return null;
    }

    public void ad(String str, den denVar) {
        bzo.q(denVar, com.umeng.analytics.pro.f.M);
        deo deoVar = (deo) this.b;
        synchronized (deoVar.c) {
            if (deoVar.d.containsKey(str)) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            deoVar.d.put(str, denVar);
        }
    }

    public void ae(czx czxVar) {
        erf erfVar = (erf) ((dhq) this.b).get(czxVar);
        if (erfVar == null) {
            return;
        }
        erfVar.b &= -2;
    }

    public void af(czx czxVar) {
        byc bycVar = (byc) this.c;
        for (int iK = bycVar.k() - 1; iK >= 0; iK--) {
            if (czxVar == bycVar.l(iK)) {
                Object[] objArr = bycVar.c;
                Object obj = objArr[iK];
                Object obj2 = bzo.c;
                if (obj == obj2) {
                    break;
                }
                objArr[iK] = obj2;
                bycVar.a = true;
                break;
            }
        }
        erf erfVar = (erf) ((dhq) this.b).remove(czxVar);
        if (erfVar != null) {
            erfVar.b = 0;
            erfVar.c = null;
            erfVar.d = null;
            erf.a.l(erfVar);
        }
    }

    public void ag() {
        if (!((deo) this.b).h) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        gz gzVar = (gz) this.c;
        if (gzVar == null) {
            gzVar = new gz(this);
        }
        this.c = gzVar;
        try {
            bud.class.getDeclaredConstructor(null);
            gz gzVar2 = (gz) this.c;
            if (gzVar2 != null) {
                ((LinkedHashSet) gzVar2.b).add(bud.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + bud.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    @Override // me.hd.wauxv.obf.evw
    public int am(int i, int i2) {
        int iPreceding;
        int iMax;
        BreakIterator breakIterator = (BreakIterator) this.b;
        return (i2 <= 0 || Character.isWhitespace(((char[]) this.c)[i2 + (-1)]) || breakIterator.isBoundary(i2) || (iPreceding = breakIterator.preceding(i2)) == -1 || (iMax = Math.max(i, Math.min(i2, iPreceding))) <= i) ? i2 : iMax;
    }

    public void d(dmc dmcVar) {
        if (((ArrayList) this.c) == null) {
            this.c = new ArrayList();
        }
        int size = ((ArrayList) this.c).size();
        for (int i = 0; i < size; i++) {
            dmc dmcVar2 = (dmc) ((ArrayList) this.c).get(i);
            if (dmcVar2.a == dmcVar.a) {
                ((ArrayList) this.c).remove(i);
            }
            if (dmcVar2.a >= dmcVar.a) {
                ((ArrayList) this.c).add(i, dmcVar);
                return;
            }
        }
        ((ArrayList) this.c).add(dmcVar);
    }

    public void e(czx czxVar, cjn cjnVar) {
        dhq dhqVar = (dhq) this.b;
        erf erfVarE = (erf) dhqVar.get(czxVar);
        if (erfVarE == null) {
            erfVarE = erf.e();
            dhqVar.put(czxVar, erfVarE);
        }
        erfVarE.d = cjnVar;
        erfVarE.b |= 8;
    }

    public void f() {
        int[] iArr = (int[]) this.b;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.c = null;
    }

    public Bundle g(String str) {
        Bundle bundle;
        deo deoVar = (deo) this.b;
        if (!deoVar.g) {
            throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
        }
        Bundle bundle2 = deoVar.f;
        if (bundle2 == null) {
            return null;
        }
        if (bundle2.containsKey(str)) {
            bundle = bundle2.getBundle(str);
            if (bundle == null) {
                cmz.ad(str);
                throw null;
            }
        } else {
            bundle = null;
        }
        bundle2.remove(str);
        if (bundle2.isEmpty()) {
            deoVar.f = null;
        }
        return bundle;
    }

    public void i(int i) {
        int[] iArr = (int[]) this.b;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.b = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.b = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.b;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public View j(int i, int i2, int i3, int i4) {
        View viewEr;
        eqk eqkVar = (eqk) this.c;
        cze czeVar = (cze) this.b;
        int iF = czeVar.f();
        int iE = czeVar.e();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            switch (czeVar.a) {
                case 0:
                    viewEr = czeVar.b.er(i);
                    break;
                default:
                    viewEr = czeVar.b.er(i);
                    break;
            }
            int iD = czeVar.d(viewEr);
            int iC = czeVar.c(viewEr);
            eqkVar.b = iF;
            eqkVar.c = iE;
            eqkVar.d = iD;
            eqkVar.e = iC;
            if (i3 != 0) {
                eqkVar.a = i3;
                if (eqkVar.f()) {
                    return viewEr;
                }
            }
            if (i4 != 0) {
                eqkVar.a = i4;
                if (eqkVar.f()) {
                    view = viewEr;
                }
            }
            i += i5;
        }
        return view;
    }

    @Override // me.hd.wauxv.obf.aja
    public void k(Exception exc) {
        dld dldVar = (dld) this.c;
        cdu cduVar = (cdu) this.b;
        cdu cduVar2 = dldVar.h;
        if (cduVar2 == null || cduVar2 != cduVar) {
            return;
        }
        dld dldVar2 = (dld) this.c;
        cdu cduVar3 = (cdu) this.b;
        ajr ajrVar = dldVar2.d;
        aiz aizVar = dldVar2.i;
        ajb ajbVar = cduVar3.c;
        ajrVar.b(aizVar, exc, ajbVar, ajbVar.e());
    }

    @Override // me.hd.wauxv.obf.app
    public void l(Bitmap bitmap, oz ozVar) throws IOException {
        IOException iOException = ((axb) this.c).c;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            ozVar.p(bitmap);
            throw iOException;
        }
    }

    public void m(int i) {
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((dmc) ((ArrayList) this.c).get(size)).a >= i) {
                    ((ArrayList) this.c).remove(size);
                }
            }
        }
        u(i);
    }

    public Object n(char c) {
        for (elz elzVar = ((elz[]) this.b)[Math.abs(((c << 6) * ((c & 1) != 0 ? 3 : 1)) ^ c) % 64]; elzVar != null; elzVar = elzVar.a) {
            if (elzVar.b == c) {
                return elzVar.c;
            }
        }
        return null;
    }

    public dmc o(int i, int i2, int i3) {
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            dmc dmcVar = (dmc) ((ArrayList) this.c).get(i4);
            int i5 = dmcVar.a;
            if (i5 >= i2) {
                return null;
            }
            if (i5 >= i && (i3 == 0 || dmcVar.b == i3 || dmcVar.d)) {
                return dmcVar;
            }
        }
        return null;
    }

    public dmc p(int i) {
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            dmc dmcVar = (dmc) ((ArrayList) this.c).get(size);
            if (dmcVar.a == i) {
                return dmcVar;
            }
        }
        return null;
    }

    public synchronized List q(String str) {
        List arrayList;
        try {
            if (!((ArrayList) this.c).contains(str)) {
                ((ArrayList) this.c).add(str);
            }
            arrayList = (List) ((HashMap) this.b).get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                ((HashMap) this.b).put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized ArrayList r(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = ((ArrayList) this.c).iterator();
        while (it.hasNext()) {
            List<dck> list = (List) ((HashMap) this.b).get((String) it.next());
            if (list != null) {
                for (dck dckVar : list) {
                    if ((dckVar.a.isAssignableFrom(cls) && cls2.isAssignableFrom(dckVar.b)) && !arrayList.contains(dckVar.b)) {
                        arrayList.add(dckVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public String s(btj btjVar) {
        String str;
        synchronized (((byi) this.b)) {
            str = (String) ((byi) this.b).d(btjVar);
        }
        if (str == null) {
            def defVar = (def) ((jx) this.c).acquire();
            try {
                btjVar.d(defVar.a);
                byte[] bArrDigest = defVar.a.digest();
                char[] cArr = eot.b;
                synchronized (cArr) {
                    for (int i = 0; i < bArrDigest.length; i++) {
                        byte b = bArrDigest[i];
                        int i2 = i * 2;
                        char[] cArr2 = eot.a;
                        cArr[i2] = cArr2[(b & 255) >>> 4];
                        cArr[i2 + 1] = cArr2[b & com.umeng.analytics.pro.dn.m];
                    }
                    str = new String(cArr);
                }
                ((jx) this.c).l(defVar);
            } catch (Throwable th) {
                ((jx) this.c).l(defVar);
                throw th;
            }
        }
        synchronized (((byi) this.b)) {
            ((byi) this.b).g(btjVar, str);
        }
        return str;
    }

    public den t() {
        den denVar;
        deo deoVar = (deo) this.b;
        synchronized (deoVar.c) {
            Iterator it = deoVar.d.entrySet().iterator();
            do {
                denVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                den denVar2 = (den) entry.getValue();
                if (bzo.f(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    denVar = denVar2;
                }
            } while (denVar == null);
        }
        return denVar;
    }

    public String toString() {
        switch (this.a) {
            case 6:
                String string = "[ ";
                if (((dla) this.b) != null) {
                    for (int i = 0; i < 9; i++) {
                        StringBuilder sbY = dkz.y(string);
                        sbY.append(((dla) this.b).h[i]);
                        sbY.append(" ");
                        string = sbY.toString();
                    }
                }
                StringBuilder sbR = bjs.r(string, "] ");
                sbR.append((dla) this.b);
                return sbR.toString();
            case 21:
                return "Bounds{lower=" + ((bps) this.b) + " upper=" + ((bps) this.c) + "}";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:10:0x0012  */
    public int u(int i) {
        int i2;
        int[] iArr = (int[]) this.b;
        if (iArr == null || i >= iArr.length) {
            return -1;
        }
        if (((ArrayList) this.c) != null) {
            dmc dmcVarP = p(i);
            if (dmcVarP != null) {
                ((ArrayList) this.c).remove(dmcVarP);
            }
            int size = ((ArrayList) this.c).size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (((dmc) ((ArrayList) this.c).get(i3)).a >= i) {
                    break;
                }
                i3++;
            }
            if (i3 != -1) {
                dmc dmcVar = (dmc) ((ArrayList) this.c).get(i3);
                ((ArrayList) this.c).remove(i3);
                i2 = dmcVar.a;
            } else {
                i2 = -1;
            }
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            int[] iArr2 = (int[]) this.b;
            Arrays.fill(iArr2, i, iArr2.length, -1);
            return ((int[]) this.b).length;
        }
        int iMin = Math.min(i2 + 1, ((int[]) this.b).length);
        Arrays.fill((int[]) this.b, i, iMin, -1);
        return iMin;
    }

    @Override // me.hd.wauxv.obf.app
    public void v() {
        cyp cypVar = (cyp) this.b;
        synchronized (cypVar) {
            cypVar.c = cypVar.a.length;
        }
    }

    public boolean w(View view) {
        eqk eqkVar = (eqk) this.c;
        cze czeVar = (cze) this.b;
        int iF = czeVar.f();
        int iE = czeVar.e();
        int iD = czeVar.d(view);
        int iC = czeVar.c(view);
        eqkVar.b = iF;
        eqkVar.c = iE;
        eqkVar.d = iD;
        eqkVar.e = iC;
        eqkVar.a = 24579;
        return eqkVar.f();
    }

    public dle x(int i, long j) {
        dle dleVar = (dle) ((ArrayBlockingQueue) this.c).poll();
        if (dleVar == null) {
            return (dle) ((bgj) this.b).g(Integer.valueOf(i), Long.valueOf(j));
        }
        dleVar.h(i);
        dleVar.f(j);
        return dleVar;
    }

    public void y(int i, int i2) {
        int[] iArr = (int[]) this.b;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        i(i3);
        int[] iArr2 = (int[]) this.b;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.b, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            dmc dmcVar = (dmc) ((ArrayList) this.c).get(size);
            int i4 = dmcVar.a;
            if (i4 >= i) {
                dmcVar.a = i4 + i2;
            }
        }
    }

    public void z(int i, int i2) {
        int[] iArr = (int[]) this.b;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        i(i3);
        int[] iArr2 = (int[]) this.b;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.b;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.c;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            dmc dmcVar = (dmc) ((ArrayList) this.c).get(size);
            int i4 = dmcVar.a;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.c).remove(size);
                } else {
                    dmcVar.a = i4 - i2;
                }
            }
        }
    }

    public but(int i) {
        this.a = i;
        switch (i) {
            case 7:
                this.c = new ArrayList();
                this.b = new HashMap();
                break;
            case 8:
                this.b = new byi(1000L);
                this.c = ewz.aw(10, new cbm(17));
                break;
            case 13:
                break;
            case 16:
                this.b = new elz[64];
                this.c = new elz[64];
                break;
            case 17:
                this.b = new but(16);
                break;
            case 19:
                this.b = new dhq(0);
                this.c = new byc();
                break;
            default:
                this.b = new AtomicReference();
                this.c = new ku(0);
                break;
        }
    }

    public but(cbm cbmVar) {
        this.a = 0;
        this.b = new HashMap();
        this.c = cbmVar;
    }

    public but(deo deoVar, int i) {
        this.a = i;
        switch (i) {
            case 10:
                this.b = deoVar;
                this.c = new but(deoVar, 9);
                break;
            default:
                this.b = deoVar;
                break;
        }
    }

    public but(jx jxVar) {
        this.a = 1;
        cbm cbmVar = chm.a;
        chm chmVar = new chm();
        chmVar.c = new ArrayList();
        chmVar.e = new HashSet();
        chmVar.f = jxVar;
        chmVar.d = cbmVar;
        this.c = new aji(3);
        this.b = chmVar;
    }

    public but(bpy bpyVar) {
        this.a = 3;
        this.b = bpyVar;
        this.c = new dov(new cfx(this, 4));
    }

    public but(chm chmVar) {
        this.a = 5;
        this.b = chmVar;
        this.c = new dov(new cfx(this, 6));
    }

    public but(afo afoVar) {
        this.a = 22;
        this.c = afoVar.a;
        uh uhVar = new uh(afoVar);
        BreakIterator lineInstance = BreakIterator.getLineInstance();
        this.b = lineInstance;
        lineInstance.setText(uhVar);
    }

    public but(bgj bgjVar) {
        this.a = 12;
        this.b = bgjVar;
        this.c = new ArrayBlockingQueue(16384);
    }

    public but(cvr cvrVar) {
        this.a = 6;
        this.c = cvrVar;
    }

    public but(but butVar) {
        this.a = 4;
        this.b = butVar;
        this.c = new dov(new cfx(this, 5));
    }

    public but(csb csbVar, erp erpVar) {
        this.a = 23;
        this.b = csbVar;
        new LinkedHashSet();
        this.c = new LinkedHashMap();
    }

    public but(dld dldVar, cdu cduVar) {
        this.a = 11;
        this.c = dldVar;
        this.b = cduVar;
    }

    public but(cze czeVar) {
        this.a = 18;
        this.b = czeVar;
        eqk eqkVar = new eqk();
        eqkVar.a = 0;
        this.c = eqkVar;
    }

    public but(WindowInsetsAnimation.Bounds bounds) {
        this.a = 21;
        this.b = bps.h(bounds.getLowerBound());
        this.c = bps.h(bounds.getUpperBound());
    }
}
