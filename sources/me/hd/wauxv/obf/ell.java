package me.hd.wauxv.obf;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ell implements Cloneable {
    public static final Animator[] ac = new Animator[0];
    public static final int[] ad = { 2, 1, 3, 4 };
    public static final dop ae = new dop(8);
    public static final ThreadLocal af = new ThreadLocal();
    public ArrayList aq;
    public ArrayList ar;
    public elk[] as;
    public long bc;
    public long bd;
    public final String ag = getClass().getName();
    public long ah = -1;
    public long ai = -1;
    public TimeInterpolator aj = null;
    public final ArrayList ak = new ArrayList();
    public final ArrayList al = new ArrayList();
    public chm am = new chm(12);
    public chm an = new chm(12);
    public mi ao = null;
    public final int[] ap = ad;
    public final ArrayList at = new ArrayList();
    public Animator[] au = ac;
    public int av = 0;
    public boolean aw = false;
    public boolean ax = false;
    public ell ay = null;
    public ArrayList az = null;
    public ArrayList ba = new ArrayList();
    public dop bb = ae;

    public static void be(chm chmVar, View view, elt eltVar) {
        ku kuVar = (ku) chmVar.c;
        ku kuVar2 = (ku) chmVar.f;
        SparseArray sparseArray = (SparseArray) chmVar.d;
        byc bycVar = (byc) chmVar.e;
        kuVar.put(view, eltVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = eqz.a;
        String strF = eqq.f(view);
        if (strF != null) {
            if (kuVar2.containsKey(strF)) {
                kuVar2.put(strF, null);
            } else {
                kuVar2.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (bycVar.g(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    bycVar.i(view, itemIdAtPosition);
                    return;
                }
                View view2 = (View) bycVar.f(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    bycVar.i(null, itemIdAtPosition);
                }
            }
        }
    }

    public static ku bf() {
        ThreadLocal threadLocal = af;
        ku kuVar = (ku) threadLocal.get();
        if (kuVar != null) {
            return kuVar;
        }
        ku kuVar2 = new ku(0);
        threadLocal.set(kuVar2);
        return kuVar2;
    }

    public static boolean bg(elt eltVar, elt eltVar2, String str) {
        Object obj = eltVar.a.get(str);
        Object obj2 = eltVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public Animator aa(ViewGroup viewGroup, elt eltVar, elt eltVar2) {
        return null;
    }

    public String[] ab() {
        return null;
    }

    public void bh(elk elkVar) {
        if (this.az == null) {
            this.az = new ArrayList();
        }
        this.az.add(elkVar);
    }

    public final void bi(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            elt eltVar = new elt(view);
            if (z) {
                h(eltVar);
            } else {
                f(eltVar);
            }
            eltVar.c.add(this);
            g(eltVar);
            if (z) {
                be(this.am, view, eltVar);
            } else {
                be(this.an, view, eltVar);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                bi(viewGroup.getChildAt(i), z);
            }
        }
    }

    public final void bj(ViewGroup viewGroup, boolean z) {
        bk(z);
        ArrayList arrayList = this.ak;
        int size = arrayList.size();
        ArrayList arrayList2 = this.al;
        if (size <= 0 && arrayList2.size() <= 0) {
            bi(viewGroup, z);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (viewFindViewById != null) {
                elt eltVar = new elt(viewFindViewById);
                if (z) {
                    h(eltVar);
                } else {
                    f(eltVar);
                }
                eltVar.c.add(this);
                g(eltVar);
                if (z) {
                    be(this.am, viewFindViewById, eltVar);
                } else {
                    be(this.an, viewFindViewById, eltVar);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            elt eltVar2 = new elt(view);
            if (z) {
                h(eltVar2);
            } else {
                f(eltVar2);
            }
            eltVar2.c.add(this);
            g(eltVar2);
            if (z) {
                be(this.am, view, eltVar2);
            } else {
                be(this.an, view, eltVar2);
            }
        }
    }

    public final void bk(boolean z) {
        if (z) {
            ((ku) this.am.c).clear();
            ((SparseArray) this.am.d).clear();
            ((byc) this.am.e).e();
        } else {
            ((ku) this.an.c).clear();
            ((SparseArray) this.an.d).clear();
            ((byc) this.an.e).e();
        }
    }

    public final void bl() {
        int i = this.av - 1;
        this.av = i;
        if (i == 0) {
            bq(this, df.b, false);
            for (int i2 = 0; i2 < ((byc) this.am.e).k(); i2++) {
                View view = (View) ((byc) this.am.e).l(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((byc) this.an.e).k(); i3++) {
                View view2 = (View) ((byc) this.an.e).l(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.ax = true;
        }
    }

    public final elt bm(View view, boolean z) {
        mi miVar = this.ao;
        if (miVar != null) {
            return miVar.bm(view, z);
        }
        ArrayList arrayList = z ? this.aq : this.ar;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            elt eltVar = (elt) arrayList.get(i);
            if (eltVar == null) {
                return null;
            }
            if (eltVar.b == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (elt) (z ? this.ar : this.aq).get(i);
        }
        return null;
    }

    public final ell bn() {
        mi miVar = this.ao;
        return miVar != null ? miVar.bn() : this;
    }

    public final elt bo(View view, boolean z) {
        mi miVar = this.ao;
        if (miVar != null) {
            return miVar.bo(view, z);
        }
        return (elt) ((ku) (z ? this.am : this.an).c).get(view);
    }

    public final boolean bp(View view) {
        int id = view.getId();
        ArrayList arrayList = this.ak;
        int size = arrayList.size();
        ArrayList arrayList2 = this.al;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id))
                || arrayList2.contains(view);
    }

    public final void bq(ell ellVar, df dfVar, boolean z) {
        ell ellVar2 = this.ay;
        if (ellVar2 != null) {
            ellVar2.bq(ellVar, dfVar, z);
        }
        ArrayList arrayList = this.az;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.az.size();
        elk[] elkVarArr = this.as;
        if (elkVarArr == null) {
            elkVarArr = new elk[size];
        }
        this.as = null;
        elk[] elkVarArr2 = (elk[]) this.az.toArray(elkVarArr);
        for (int i = 0; i < size; i++) {
            elk elkVar = elkVarArr2[i];
            switch (dfVar.f) {
                case 7:
                    elkVar.h(ellVar);
                    break;
                case 8:
                    elkVar.e(ellVar);
                    break;
                case 9:
                    elkVar.c(ellVar);
                    break;
                case 10:
                    elkVar.d();
                    break;
                default:
                    elkVar.f();
                    break;
            }
            elkVarArr2[i] = null;
        }
        this.as = elkVarArr2;
    }

    public final void br() {
        if (this.av == 0) {
            bq(this, df.a, false);
            this.ax = false;
        }
        this.av++;
    }

    public void cancel() {
        ArrayList arrayList = this.at;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.au);
        this.au = ac;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.au = animatorArr;
        bq(this, df.c, false);
    }

    public abstract void f(elt eltVar);

    public void g(elt eltVar) {
    }

    public abstract void h(elt eltVar);

    @Override //
    /*
     * JADX INFO: renamed from: i, reason: merged with bridge method
     * [inline-methods]
     */
    public ell clone() {
        try {
            ell ellVar = (ell) super.clone();
            ellVar.ba = new ArrayList();
            ellVar.am = new chm(12);
            ellVar.an = new chm(12);
            ellVar.aq = null;
            ellVar.ar = null;
            ellVar.ay = this;
            ellVar.az = null;
            return ellVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void j(ViewGroup viewGroup, chm chmVar, chm chmVar2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i2;
        View view;
        elt eltVar;
        Animator animator;
        elt eltVar2;
        ku kuVarBf = bf();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        bn().getClass();
        int i3 = 0;
        while (i3 < size) {
            elt eltVar3 = (elt) arrayList.get(i3);
            elt eltVar4 = (elt) arrayList2.get(i3);
            if (eltVar3 != null && !eltVar3.c.contains(this)) {
                eltVar3 = null;
            }
            if (eltVar4 != null && !eltVar4.c.contains(this)) {
                eltVar4 = null;
            }
            if ((eltVar3 != null || eltVar4 != null) && (eltVar3 == null || eltVar4 == null || y(eltVar3, eltVar4))) {
                Animator animatorAa = aa(viewGroup, eltVar3, eltVar4);
                if (animatorAa != null) {
                    String str = this.ag;
                    if (eltVar4 != null) {
                        view = eltVar4.b;
                        String[] strArrAb = ab();
                        if (strArrAb != null && strArrAb.length > 0) {
                            eltVar2 = new elt(view);
                            elt eltVar5 = (elt) ((ku) chmVar2.c).get(view);
                            i = size;
                            if (eltVar5 != null) {
                                int i4 = 0;
                                while (i4 < strArrAb.length) {
                                    String str2 = strArrAb[i4];
                                    int i5 = i3;
                                    eltVar2.a.put(str2, eltVar5.a.get(str2));
                                    i4++;
                                    i3 = i5;
                                    eltVar5 = eltVar5;
                                }
                            }
                            i2 = i3;
                            int i6 = kuVarBf.l;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    animator = animatorAa;
                                    break;
                                }
                                elh elhVar = (elh) kuVarBf.get((Animator) kuVarBf.r(i7));
                                if (elhVar.c != null && elhVar.a == view && elhVar.b.equals(str)
                                        && elhVar.c.equals(eltVar2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator = animatorAa;
                            eltVar2 = null;
                        }
                        animatorAa = animator;
                        eltVar = eltVar2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = eltVar3.b;
                        eltVar = null;
                    }
                    if (animatorAa != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        elh elhVar2 = new elh();
                        elhVar2.a = view;
                        elhVar2.b = str;
                        elhVar2.c = eltVar;
                        elhVar2.d = windowId;
                        elhVar2.e = this;
                        elhVar2.f = animatorAa;
                        kuVarBf.put(animatorAa, elhVar2);
                        this.ba.add(animatorAa);
                    }
                }
                i3 = i2 + 1;
                size = i;
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                elh elhVar3 = (elh) kuVarBf.get((Animator) this.ba.get(sparseIntArray.keyAt(i8)));
                elhVar3.f.setStartDelay(
                        elhVar3.f.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - Long.MAX_VALUE));
            }
        }
    }

    public boolean k() {
        return !this.at.isEmpty();
    }

    public void l(View view) {
        if (this.ax) {
            return;
        }
        ArrayList arrayList = this.at;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.au);
        this.au = ac;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.au = animatorArr;
        bq(this, df.d, false);
        this.aw = true;
    }

    public void m() {
        ku kuVarBf = bf();
        this.bc = 0L;
        for (int i = 0; i < this.ba.size(); i++) {
            Animator animator = (Animator) this.ba.get(i);
            elh elhVar = (elh) kuVarBf.get(animator);
            if (animator != null && elhVar != null) {
                Animator animator2 = elhVar.f;
                long j = this.ai;
                if (j >= 0) {
                    animator2.setDuration(j);
                }
                long j2 = this.ah;
                if (j2 >= 0) {
                    animator2.setStartDelay(animator2.getStartDelay() + j2);
                }
                TimeInterpolator timeInterpolator = this.aj;
                if (timeInterpolator != null) {
                    animator2.setInterpolator(timeInterpolator);
                }
                this.at.add(animator);
                this.bc = Math.max(this.bc, eli.a(animator));
            }
        }
        this.ba.clear();
    }

    public ell n(elk elkVar) {
        ell ellVar;
        ArrayList arrayList = this.az;
        if (arrayList != null) {
            if (!arrayList.remove(elkVar) && (ellVar = this.ay) != null) {
                ellVar.n(elkVar);
            }
            if (this.az.size() == 0) {
                this.az = null;
            }
        }
        return this;
    }

    public void o(View view) {
        if (this.aw) {
            if (!this.ax) {
                ArrayList arrayList = this.at;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.au);
                this.au = ac;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.au = animatorArr;
                bq(this, df.e, false);
            }
            this.aw = false;
        }
    }

    public void p() {
        br();
        ku kuVarBf = bf();
        for (Animator animator : this.ba) {
            if (kuVarBf.containsKey(animator)) {
                br();
                if (animator != null) {
                    animator.addListener(new elg(this, kuVarBf));
                    long j = this.ai;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.ah;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.aj;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new ci(this, 6));
                    animator.start();
                }
            }
        }
        this.ba.clear();
        bl();
    }

    public void q(long j, long j2) {
        long j3 = this.bc;
        int i = 0;
        boolean z = j < j2;
        if ((j2 < 0 && j >= 0) || (j2 > j3 && j <= j3)) {
            this.ax = false;
            bq(this, df.a, z);
        }
        ArrayList arrayList = this.at;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.au);
        this.au = ac;
        while (i < size) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            eli.tryGetClassByName(animator, Math.min(Math.max(0L, j), eli.a(animator)));
            i++;
            j3 = j3;
        }
        long j4 = j3;
        this.au = animatorArr;
        if ((j <= j4 || j2 > j4) && (j >= 0 || j2 < 0)) {
            return;
        }
        if (j > j4) {
            this.ax = true;
        }
        bq(this, df.b, z);
    }

    public void r(long j) {
        this.ai = j;
    }

    public void s(dqc dqcVar) {
    }

    public void t(TimeInterpolator timeInterpolator) {
        this.aj = timeInterpolator;
    }

    public final String toString() {
        return x("");
    }

    public void u(dop dopVar) {
        if (dopVar == null) {
            this.bb = ae;
        } else {
            this.bb = dopVar;
        }
    }

    public void v() {
    }

    public void w(long j) {
        this.ah = j;
    }

    public String x(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.ai != -1) {
            sb.append("dur(");
            sb.append(this.ai);
            sb.append(") ");
        }
        if (this.ah != -1) {
            sb.append("dly(");
            sb.append(this.ah);
            sb.append(") ");
        }
        if (this.aj != null) {
            sb.append("interp(");
            sb.append(this.aj);
            sb.append(") ");
        }
        ArrayList arrayList = this.ak;
        int size = arrayList.size();
        ArrayList arrayList2 = this.al;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public boolean y(elt eltVar, elt eltVar2) {
        if (eltVar != null && eltVar2 != null) {
            String[] strArrAb = ab();
            if (strArrAb != null) {
                for (String str : strArrAb) {
                    if (bg(eltVar, eltVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = eltVar.a.keySet().iterator();
                while (it.hasNext()) {
                    if (bg(eltVar, eltVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
