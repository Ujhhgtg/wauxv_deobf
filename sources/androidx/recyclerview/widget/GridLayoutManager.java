package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import me.hd.wauxv.obf.ax;
import me.hd.wauxv.obf.bc;
import me.hd.wauxv.obf.bd;
import me.hd.wauxv.obf.biq;
import me.hd.wauxv.obf.bir;
import me.hd.wauxv.obf.bpq;
import me.hd.wauxv.obf.bvh;
import me.hd.wauxv.obf.bvi;
import me.hd.wauxv.obf.bvj;
import me.hd.wauxv.obf.cyw;
import me.hd.wauxv.obf.czg;
import me.hd.wauxv.obf.czh;
import me.hd.wauxv.obf.czo;
import me.hd.wauxv.obf.czt;
import me.hd.wauxv.obf.czx;
import me.hd.wauxv.obf.eqz;
import me.hd.wauxv.obf.hz;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set a = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public int[] _b;
    public boolean b;
    public int c;
    public View[] e;
    public final SparseIntArray f;
    public final SparseIntArray g;
    public hz h;
    public final Rect i;
    public int j;
    public int k;
    public int l;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new biq();
        this.i = new Rect();
        this.j = -1;
        this.k = -1;
        this.l = -1;
        _f(czg.em(context, attributeSet, i, i2).b);
    }

    public final int _c(int i, czo czoVar, czt cztVar) {
        if (!cztVar.g) {
            return this.h.n(i, this.c);
        }
        int i2 = this.g.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iJ = czoVar.j(i);
        if (iJ != -1) {
            return this.h.n(iJ, this.c);
        }
        Log.w("GridLayoutManager",
                "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int _d(int i, czo czoVar, czt cztVar) {
        if (!cztVar.g) {
            return this.h.o(i);
        }
        int i2 = this.f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iJ = czoVar.j(i);
        if (iJ != -1) {
            return this.h.o(iJ);
        }
        Log.w("GridLayoutManager",
                "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void _e(View view, int i, boolean z) {
        int iEe;
        int iEe2;
        bir birVar = (bir) view.getLayoutParams();
        Rect rect = birVar.d;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) birVar).topMargin
                + ((ViewGroup.MarginLayoutParams) birVar).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) birVar).leftMargin
                + ((ViewGroup.MarginLayoutParams) birVar).rightMargin;
        int iAw = aw(birVar.a, birVar.b);
        if (this.bd == 1) {
            iEe2 = czg.ee(iAw, i, i3, ((ViewGroup.MarginLayoutParams) birVar).width, false);
            iEe = czg.ee(this.bf.o(), this.ea, i2, ((ViewGroup.MarginLayoutParams) birVar).height, true);
        } else {
            int iEe3 = czg.ee(iAw, i, i2, ((ViewGroup.MarginLayoutParams) birVar).height, false);
            int iEe4 = czg.ee(this.bf.o(), this.dz, i3, ((ViewGroup.MarginLayoutParams) birVar).width, true);
            iEe = iEe3;
            iEe2 = iEe4;
        }
        czh czhVar = (czh) view.getLayoutParams();
        if (z ? fl(view, iEe2, iEe, czhVar) : fk(view, iEe2, iEe, czhVar)) {
            view.measure(iEe2, iEe);
        }
    }

    public final void _f(int i) {
        if (i == this.c) {
            return;
        }
        this.b = true;
        if (i < 1) {
            throw new IllegalArgumentException(concatVar2Var1(i, "Span count should be at least 1. Provided "));
        }
        this.c = i;
        this.h.q();
        ff();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void aa() {
        this.h.q();
        ((SparseIntArray) this.h.h).clear();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ab(int i, int i2) {
        this.h.q();
        ((SparseIntArray) this.h.h).clear();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ac(int i, int i2) {
        this.h.q();
        ((SparseIntArray) this.h.h).clear();
    }

    @Override // me.hd.wauxv.obf.czg
    public final void ad(int i, int i2) {
        this.h.q();
        ((SparseIntArray) this.h.h).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void ae(czo czoVar, czt cztVar) {
        boolean z = cztVar.g;
        SparseIntArray sparseIntArray = this.g;
        SparseIntArray sparseIntArray2 = this.f;
        if (z) {
            int iEs = es();
            for (int i = 0; i < iEs; i++) {
                bir birVar = (bir) er(i).getLayoutParams();
                int iZ = birVar.c.z();
                sparseIntArray2.put(iZ, birVar.b);
                sparseIntArray.put(iZ, birVar.a);
            }
        }
        super.ae(czoVar, cztVar);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void af(czt cztVar) {
        View viewCa;
        super.af(cztVar);
        this.b = false;
        int i = this.j;
        if (i == -1 || (viewCa = ca(i)) == null) {
            return;
        }
        viewCa.sendAccessibilityEvent(67108864);
        this.j = -1;
    }

    /* JADX WARN: Found duplicated region for block: B:118:0x01a1 */
    /* JADX WARN: Found duplicated region for block: B:121:0x01a7 */
    /* JADX WARN: Found duplicated region for block: B:121:0x01a7 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:122:0x01a9 A[EDGE_INSN:
     * B:122:0x01a9->B:166:0x027c BREAK A[LOOP:2: B:126:0x01b9->B:135:0x01e2,
     * LOOP_LABEL: LOOP:2: B:126:0x01b9->B:135:0x01e2]]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:123:0x01ac A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:128:0x01bf */
    /* JADX WARN: Found duplicated region for block: B:131:0x01cd */
    /*
     * JADX WARN: Found duplicated region for block: B:134:0x01da A[LOOP:3:
     * B:129:0x01c7->B:134:0x01da, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:139:0x01f3 */
    /* JADX WARN: Found duplicated region for block: B:142:0x0213 */
    /* JADX WARN: Found duplicated region for block: B:143:0x0215 */
    /* JADX WARN: Found duplicated region for block: B:143:0x0215 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:145:0x0218 A[ADDED_TO_REGION]
     */
    /* JADX WARN: Found duplicated region for block: B:150:0x0227 */
    /* JADX WARN: Found duplicated region for block: B:153:0x0235 */
    /* JADX WARN: Found duplicated region for block: B:156:0x0243 */
    /* JADX WARN: Found duplicated region for block: B:163:0x0262 */
    /* JADX WARN: Found duplicated region for block: B:167:0x027e */
    /* JADX WARN: Found duplicated region for block: B:206:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:207:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:208:0x01e2 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:209:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:210:0x01ff A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:211:? A[LOOP:4:
     * B:137:0x01ed->B:211:?, LOOP_END, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:212:0x0254 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:213:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:214:0x0251 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:215:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:217:0x022f A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:219:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:220:0x026e A[SYNTHETIC] */
    /*
     * JADX WARN: Found duplicated region for block: B:221:? A[LOOP:7:
     * B:161:0x025c->B:221:?, LOOP_END, SYNTHETIC]
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final boolean ag(int i, Bundle bundle) {
        View viewEr;
        czx czxVarDv;
        int iIntValue;
        int i2;
        TreeMap treeMap;
        int i3;
        Iterator it;
        Integer num;
        int iIntValue2;
        Iterator it2;
        Integer num2;
        TreeMap treeMap2;
        int i4;
        Iterator it3;
        Integer num3;
        int iIntValue3;
        Iterator it4;
        Integer num4;
        if (i == ax.k.p() && i != -1) {
            int i5 = 0;
            while (true) {
                if (i5 >= es()) {
                    viewEr = null;
                    break;
                }
                View viewEr2 = er(i5);
                Objects.requireNonNull(viewEr2);
                if (viewEr2.isAccessibilityFocused()) {
                    viewEr = er(i5);
                    break;
                }
                i5++;
            }
            if (viewEr != null && bundle != null) {
                int i6 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
                if (a.contains(Integer.valueOf(i6)) && (czxVarDv = this.dp.dv(viewEr)) != null) {
                    int iX = czxVarDv.x();
                    int iAt = at(iX);
                    int iAs = as(iX);
                    if (iAt >= 0 && iAs >= 0) {
                        if (!au(iX).contains(Integer.valueOf(this.k))
                                || !av(as(iX), iX).contains(Integer.valueOf(this.l))) {
                            this.k = iAt;
                            this.l = iAs;
                        }
                        int i7 = this.k;
                        if (i7 == -1) {
                            i7 = iAt;
                        }
                        int i8 = this.l;
                        if (i8 != -1) {
                            iAs = i8;
                        }
                        if (i6 == 17) {
                            iIntValue = iX - 1;
                            while (true) {
                                if (iIntValue >= 0) {
                                    int iAt2 = at(iIntValue);
                                    int iAs2 = as(iIntValue);
                                    if (iAt2 >= 0 && iAs2 >= 0) {
                                        if (this.bd != 1) {
                                            if (au(iIntValue).contains(Integer.valueOf(i7)) && iAs2 < iAs) {
                                                this.l = iAs2;
                                                break;
                                            }
                                            iIntValue--;
                                        } else {
                                            if ((iAt2 == i7 && iAs2 < iAs) || iAt2 < i7) {
                                                this.k = iAt2;
                                                this.l = iAs2;
                                                break;
                                            }
                                            iIntValue--;
                                        }
                                    }
                                }
                                iIntValue = -1;
                                break;
                            }
                            if (iIntValue == -1) {
                                if (i6 == 17) {
                                    if (i6 == 66) {
                                        if (iAt < 0) {
                                            treeMap = new TreeMap();
                                            i3 = 0;
                                            loop5: while (true) {
                                                if (i3 < et()) {
                                                    it2 = au(i3).iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            num2 = (Integer) it2.next();
                                                            if (num2.intValue() < 0) {
                                                                if (!treeMap.containsKey(num2)) {
                                                                    treeMap.put(num2, Integer.valueOf(i3));
                                                                }
                                                            }
                                                        } else {
                                                            i3++;
                                                        }
                                                    }
                                                } else {
                                                    it = treeMap.keySet().iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            num = (Integer) it.next();
                                                            iIntValue2 = num.intValue();
                                                            if (iIntValue2 > iAt) {
                                                                iIntValue = ((Integer) treeMap.get(num)).intValue();
                                                                this.k = iIntValue2;
                                                                this.l = 0;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                iIntValue = -1;
                                                break loop2;
                                            }
                                        }
                                        iIntValue = -1;
                                        break loop2;
                                    }
                                } else {
                                    if (iAt < 0) {
                                        treeMap2 = new TreeMap(Collections.reverseOrder());
                                        i4 = 0;
                                        loop2: while (true) {
                                            if (i4 < et()) {
                                                it4 = au(i4).iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        num4 = (Integer) it4.next();
                                                        if (num4.intValue() < 0) {
                                                            treeMap2.put(num4, Integer.valueOf(i4));
                                                        }
                                                    } else {
                                                        i4++;
                                                    }
                                                }
                                            } else {
                                                it3 = treeMap2.keySet().iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        num3 = (Integer) it3.next();
                                                        iIntValue3 = num3.intValue();
                                                        if (iIntValue3 < iAt) {
                                                            iIntValue = ((Integer) treeMap2.get(num3)).intValue();
                                                            this.k = iIntValue3;
                                                            this.l = as(iIntValue);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            iIntValue = -1;
                                            break loop2;
                                        }
                                    }
                                    iIntValue = -1;
                                    break loop2;
                                }
                            }
                            if (iIntValue != -1) {
                                ch(iIntValue);
                                this.j = iIntValue;
                                return true;
                            }
                        } else if (i6 == 33) {
                            iIntValue = iX - 1;
                            while (true) {
                                if (iIntValue >= 0) {
                                    int iAt3 = at(iIntValue);
                                    int iAs3 = as(iIntValue);
                                    if (iAt3 >= 0 && iAs3 >= 0) {
                                        if (this.bd != 1) {
                                            if (iAt3 < i7 && iAs3 == iAs) {
                                                this.k = ((Integer) Collections.max(au(iIntValue))).intValue();
                                                break;
                                            }
                                            iIntValue--;
                                        } else {
                                            if (iAt3 < i7
                                                    && av(as(iIntValue), iIntValue).contains(Integer.valueOf(iAs))) {
                                                this.k = iAt3;
                                                break;
                                            }
                                            iIntValue--;
                                        }
                                    }
                                }
                                iIntValue = -1;
                                break;
                            }
                            if (iIntValue == -1) {
                                if (i6 == 17) {
                                    if (i6 == 66) {
                                        if (iAt < 0) {
                                            treeMap = new TreeMap();
                                            i3 = 0;
                                            loop5: while (true) {
                                                if (i3 < et()) {
                                                    it2 = au(i3).iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            num2 = (Integer) it2.next();
                                                            if (num2.intValue() < 0) {
                                                                if (!treeMap.containsKey(num2)) {
                                                                    treeMap.put(num2, Integer.valueOf(i3));
                                                                }
                                                            }
                                                        } else {
                                                            i3++;
                                                        }
                                                    }
                                                } else {
                                                    it = treeMap.keySet().iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            num = (Integer) it.next();
                                                            iIntValue2 = num.intValue();
                                                            if (iIntValue2 > iAt) {
                                                                iIntValue = ((Integer) treeMap.get(num)).intValue();
                                                                this.k = iIntValue2;
                                                                this.l = 0;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                iIntValue = -1;
                                                break loop2;
                                            }
                                        }
                                        iIntValue = -1;
                                        break loop2;
                                    }
                                } else {
                                    if (iAt < 0) {
                                        treeMap2 = new TreeMap(Collections.reverseOrder());
                                        i4 = 0;
                                        loop2: while (true) {
                                            if (i4 < et()) {
                                                it4 = au(i4).iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        num4 = (Integer) it4.next();
                                                        if (num4.intValue() < 0) {
                                                            treeMap2.put(num4, Integer.valueOf(i4));
                                                        }
                                                    } else {
                                                        i4++;
                                                    }
                                                }
                                            } else {
                                                it3 = treeMap2.keySet().iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        num3 = (Integer) it3.next();
                                                        iIntValue3 = num3.intValue();
                                                        if (iIntValue3 < iAt) {
                                                            iIntValue = ((Integer) treeMap2.get(num3)).intValue();
                                                            this.k = iIntValue3;
                                                            this.l = as(iIntValue);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            iIntValue = -1;
                                            break loop2;
                                        }
                                    }
                                    iIntValue = -1;
                                    break loop2;
                                }
                            }
                            if (iIntValue != -1) {
                                ch(iIntValue);
                                this.j = iIntValue;
                                return true;
                            }
                        } else if (i6 == 66) {
                            iIntValue = iX + 1;
                            while (true) {
                                if (iIntValue < et()) {
                                    int iAt4 = at(iIntValue);
                                    int iAs4 = as(iIntValue);
                                    if (iAt4 >= 0 && iAs4 >= 0) {
                                        if (this.bd != 1) {
                                            if (iAs4 > iAs && au(iIntValue).contains(Integer.valueOf(i7))) {
                                                this.l = iAs4;
                                                break;
                                            }
                                            iIntValue++;
                                        } else {
                                            if ((iAt4 == i7 && iAs4 > iAs) || iAt4 > i7) {
                                                this.k = iAt4;
                                                this.l = iAs4;
                                                break;
                                            }
                                            iIntValue++;
                                        }
                                    }
                                }
                                iIntValue = -1;
                                break;
                            }
                            if (iIntValue == -1) {
                                if (i6 == 17) {
                                    if (i6 == 66) {
                                        if (iAt < 0) {
                                            treeMap = new TreeMap();
                                            i3 = 0;
                                            loop5: while (true) {
                                                if (i3 < et()) {
                                                    it2 = au(i3).iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            num2 = (Integer) it2.next();
                                                            if (num2.intValue() < 0) {
                                                                if (!treeMap.containsKey(num2)) {
                                                                    treeMap.put(num2, Integer.valueOf(i3));
                                                                }
                                                            }
                                                        } else {
                                                            i3++;
                                                        }
                                                    }
                                                } else {
                                                    it = treeMap.keySet().iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            num = (Integer) it.next();
                                                            iIntValue2 = num.intValue();
                                                            if (iIntValue2 > iAt) {
                                                                iIntValue = ((Integer) treeMap.get(num)).intValue();
                                                                this.k = iIntValue2;
                                                                this.l = 0;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                iIntValue = -1;
                                                break loop2;
                                            }
                                        }
                                        iIntValue = -1;
                                        break loop2;
                                    }
                                } else {
                                    if (iAt < 0) {
                                        treeMap2 = new TreeMap(Collections.reverseOrder());
                                        i4 = 0;
                                        loop2: while (true) {
                                            if (i4 < et()) {
                                                it4 = au(i4).iterator();
                                                while (true) {
                                                    if (it4.hasNext()) {
                                                        num4 = (Integer) it4.next();
                                                        if (num4.intValue() < 0) {
                                                            treeMap2.put(num4, Integer.valueOf(i4));
                                                        }
                                                    } else {
                                                        i4++;
                                                    }
                                                }
                                            } else {
                                                it3 = treeMap2.keySet().iterator();
                                                while (true) {
                                                    if (it3.hasNext()) {
                                                        num3 = (Integer) it3.next();
                                                        iIntValue3 = num3.intValue();
                                                        if (iIntValue3 < iAt) {
                                                            iIntValue = ((Integer) treeMap2.get(num3)).intValue();
                                                            this.k = iIntValue3;
                                                            this.l = as(iIntValue);
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            iIntValue = -1;
                                            break loop2;
                                        }
                                    }
                                    iIntValue = -1;
                                    break loop2;
                                }
                            }
                            if (iIntValue != -1) {
                                ch(iIntValue);
                                this.j = iIntValue;
                                return true;
                            }
                        } else if (i6 == 130) {
                            iIntValue = iX + 1;
                            while (true) {
                                if (iIntValue < et()) {
                                    int iAt5 = at(iIntValue);
                                    int iAs5 = as(iIntValue);
                                    if (iAt5 >= 0 && iAs5 >= 0) {
                                        if (this.bd != 1) {
                                            if (iAt5 > i7 && iAs5 == iAs) {
                                                this.k = at(iIntValue);
                                                break;
                                            }
                                            iIntValue++;
                                        } else {
                                            if (iAt5 > i7 && (iAs5 == iAs
                                                    || av(as(iIntValue), iIntValue).contains(Integer.valueOf(iAs)))) {
                                                this.k = iAt5;
                                                break;
                                            }
                                            iIntValue++;
                                        }
                                    }
                                }
                                iIntValue = -1;
                                break;
                            }
                            if (iIntValue == -1 && (i2 = this.bd) == 0) {
                                if (i6 == 17) {
                                    if (i6 == 66) {
                                        if (iAt < 0 || i2 == 1) {
                                            iIntValue = -1;
                                            break loop2;
                                        }
                                        treeMap = new TreeMap();
                                        i3 = 0;
                                        loop5: while (true) {
                                            if (i3 < et()) {
                                                it2 = au(i3).iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        num2 = (Integer) it2.next();
                                                        if (num2.intValue() < 0) {
                                                            if (!treeMap.containsKey(num2)) {
                                                                treeMap.put(num2, Integer.valueOf(i3));
                                                            }
                                                        }
                                                    } else {
                                                        i3++;
                                                    }
                                                }
                                            } else {
                                                it = treeMap.keySet().iterator();
                                                while (true) {
                                                    if (it.hasNext()) {
                                                        num = (Integer) it.next();
                                                        iIntValue2 = num.intValue();
                                                        if (iIntValue2 > iAt) {
                                                            iIntValue = ((Integer) treeMap.get(num)).intValue();
                                                            this.k = iIntValue2;
                                                            this.l = 0;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            iIntValue = -1;
                                            break loop2;
                                        }
                                    }
                                } else {
                                    if (iAt < 0 || i2 == 1) {
                                        iIntValue = -1;
                                        break loop2;
                                    }
                                    treeMap2 = new TreeMap(Collections.reverseOrder());
                                    i4 = 0;
                                    loop2: while (true) {
                                        if (i4 < et()) {
                                            it4 = au(i4).iterator();
                                            while (true) {
                                                if (it4.hasNext()) {
                                                    num4 = (Integer) it4.next();
                                                    if (num4.intValue() < 0) {
                                                        treeMap2.put(num4, Integer.valueOf(i4));
                                                    }
                                                } else {
                                                    i4++;
                                                }
                                            }
                                        } else {
                                            it3 = treeMap2.keySet().iterator();
                                            while (true) {
                                                if (it3.hasNext()) {
                                                    num3 = (Integer) it3.next();
                                                    iIntValue3 = num3.intValue();
                                                    if (iIntValue3 < iAt) {
                                                        iIntValue = ((Integer) treeMap2.get(num3)).intValue();
                                                        this.k = iIntValue3;
                                                        this.l = as(iIntValue);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        iIntValue = -1;
                                        break loop2;
                                    }
                                }
                            }
                            if (iIntValue != -1) {
                                ch(iIntValue);
                                this.j = iIntValue;
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            if (i != 16908343 || bundle == null) {
                return super.ag(i, bundle);
            }
            int i9 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
            int i10 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
            if (i9 != -1 && i10 != -1) {
                int iD = this.dp.w.d();
                int i11 = 0;
                while (true) {
                    if (i11 >= iD) {
                        i11 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.dp;
                    int i_c = _c(i11, recyclerView.m, recyclerView.bo);
                    RecyclerView recyclerView2 = this.dp;
                    int iAx = ax(i11, recyclerView2.m, recyclerView2.bo);
                    if (this.bd != 1) {
                        if (i_c == i9 && iAx == i10) {
                            break;
                        }
                        i11++;
                    } else {
                        if (i_c == i10 && iAx == i9) {
                            break;
                        }
                        i11++;
                    }
                }
                if (i11 > -1) {
                    dg(i11, 0);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int ah(int i, czo czoVar, czt cztVar) {
        bc();
        ar();
        return super.ah(i, czoVar, cztVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int ai(int i, czo czoVar, czt cztVar) {
        bc();
        ar();
        return super.ai(i, czoVar, cztVar);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void aj(Rect rect, int i, int i2) {
        int iEd;
        int iEd2;
        if (this._b == null) {
            super.aj(rect, i, i2);
        }
        int iEw = ew() + ev();
        int iEu = eu() + ex();
        if (this.bd == 1) {
            int iHeight = rect.height() + iEu;
            RecyclerView recyclerView = this.dp;
            WeakHashMap weakHashMap = eqz.a;
            iEd2 = czg.ed(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this._b;
            iEd = czg.ed(i, iArr[iArr.length - 1] + iEw, this.dp.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iEw;
            RecyclerView recyclerView2 = this.dp;
            WeakHashMap weakHashMap2 = eqz.a;
            iEd = czg.ed(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this._b;
            iEd2 = czg.ed(i2, iArr2[iArr2.length - 1] + iEu, this.dp.getMinimumHeight());
        }
        this.dp.setMeasuredDimension(iEd, iEd2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final boolean ak() {
        return this.bn == null && !this.b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void al(czt cztVar, bvj bvjVar, bpq bpqVar) {
        int i;
        int iO = this.c;
        for (int i2 = 0; i2 < this.c && (i = bvjVar.d) >= 0 && i < cztVar.p() && iO > 0; i2++) {
            int i3 = bvjVar.d;
            bpqVar.f(i3, Math.max(0, bvjVar.g));
            iO -= this.h.o(i3);
            bvjVar.d += bvjVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View am(czo czoVar, czt cztVar, boolean z, boolean z2) {
        int i;
        int iEs;
        int iEs2 = es();
        int i2 = 1;
        if (z2) {
            iEs = es() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iEs2;
            iEs = 0;
        }
        int iP = cztVar.p();
        cp();
        int iN = this.bf.n();
        int iJ = this.bf.j();
        View view = null;
        View view2 = null;
        while (iEs != i) {
            View viewEr = er(iEs);
            int iEl = czg.el(viewEr);
            if (iEl >= 0 && iEl < iP && _c(iEl, czoVar, cztVar) == 0) {
                if (((czh) viewEr.getLayoutParams()).c.af()) {
                    if (view2 == null) {
                        view2 = viewEr;
                    }
                } else {
                    if (this.bf.h(viewEr) < iJ && this.bf.e(viewEr) >= iN) {
                        return viewEr;
                    }
                    if (view == null) {
                        view = viewEr;
                    }
                }
            }
            iEs += i2;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v34 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void an(czo czoVar, czt cztVar, bvj bvjVar, bvi bviVar) {
        int i;
        int i2;
        int i3;
        int iG;
        int iEx;
        int iEv;
        int iG2;
        int iEe;
        int iEe2;
        ?? r12;
        int i4;
        View viewN;
        int iM = this.bf.m();
        boolean z = iM != 1073741824;
        int i5 = es() > 0 ? this._b[this.c] : 0;
        if (z) {
            bc();
        }
        boolean z2 = bvjVar.e == 1;
        int i_c = this.c;
        if (!z2) {
            i_c = _c(bvjVar.d, czoVar, cztVar) + _d(bvjVar.d, czoVar, cztVar);
        }
        int i6 = 0;
        while (i6 < this.c && (i4 = bvjVar.d) >= 0 && i4 < cztVar.p() && i_c > 0) {
            int i7 = bvjVar.d;
            int i_d = _d(i7, czoVar, cztVar);
            if (i_d > this.c) {
                throw new IllegalArgumentException(yg.concatToVar1(yg.concatVar31425(i7, i_d, "Item at position ", " requires ", " spans but GridLayoutManager has only "), " spans.", this.c));
            }
            i_c -= i_d;
            if (i_c < 0 || (viewN = bvjVar.n(czoVar)) == null) {
                break;
            }
            this.e[i6] = viewN;
            i6++;
        }
        if (i6 == 0) {
            bviVar.b = true;
            return;
        }
        if (z2) {
            i3 = 1;
            i2 = i6;
            i = 0;
        } else {
            i = i6 - 1;
            i2 = -1;
            i3 = -1;
        }
        int i8 = 0;
        while (i != i2) {
            View view = this.e[i];
            bir birVar = (bir) view.getLayoutParams();
            int i_d2 = _d(czg.el(view), czoVar, cztVar);
            birVar.b = i_d2;
            birVar.a = i8;
            i8 += i_d2;
            i += i3;
        }
        float f = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            View view2 = this.e[i10];
            if (bvjVar.k != null) {
                r12 = 0;
                r12 = 0;
                if (z2) {
                    ep(view2, -1, true);
                } else {
                    ep(view2, 0, true);
                }
            } else if (z2) {
                r12 = 0;
                ep(view2, -1, false);
            } else {
                r12 = 0;
                ep(view2, 0, false);
            }
            RecyclerView recyclerView = this.dp;
            Rect rect = this.i;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.dw(view2));
            }
            _e(view2, iM, r12);
            int iF = this.bf.f(view2);
            if (iF > i9) {
                i9 = iF;
            }
            float fG = (this.bf.g(view2) * 1.0f) / ((bir) view2.getLayoutParams()).b;
            if (fG > f) {
                f = fG;
            }
        }
        if (z) {
            aq(Math.max(Math.round(f * this.c), i5));
            i9 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                View view3 = this.e[i11];
                _e(view3, 1073741824, true);
                int iF2 = this.bf.f(view3);
                if (iF2 > i9) {
                    i9 = iF2;
                }
            }
        }
        for (int i12 = 0; i12 < i6; i12++) {
            View view4 = this.e[i12];
            if (this.bf.f(view4) != i9) {
                bir birVar2 = (bir) view4.getLayoutParams();
                Rect rect2 = birVar2.d;
                int i13 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) birVar2).topMargin + ((ViewGroup.MarginLayoutParams) birVar2).bottomMargin;
                int i14 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) birVar2).leftMargin + ((ViewGroup.MarginLayoutParams) birVar2).rightMargin;
                int iAw = aw(birVar2.a, birVar2.b);
                if (this.bd == 1) {
                    iEe2 = czg.ee(iAw, 1073741824, i14, ((ViewGroup.MarginLayoutParams) birVar2).width, false);
                    iEe = View.MeasureSpec.makeMeasureSpec(i9 - i13, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i14, 1073741824);
                    iEe = czg.ee(iAw, 1073741824, i13, ((ViewGroup.MarginLayoutParams) birVar2).height, false);
                    iEe2 = iMakeMeasureSpec;
                }
                if (fl(view4, iEe2, iEe, (czh) view4.getLayoutParams())) {
                    view4.measure(iEe2, iEe);
                }
            }
        }
        bviVar.a = i9;
        if (this.bd != 1) {
            if (bvjVar.f == -1) {
                int i15 = bvjVar.b;
                iEv = i15 - i9;
                iEx = 0;
                iG = i15;
            } else {
                int i16 = bvjVar.b;
                iG = i16 + i9;
                iEx = 0;
                iEv = i16;
            }
            iG2 = iEx;
        } else if (bvjVar.f == -1) {
            iG2 = bvjVar.b;
            iEx = iG2 - i9;
            iEv = 0;
            iG = 0;
        } else {
            int i17 = bvjVar.b;
            iG = 0;
            iEx = i17;
            iG2 = i17 + i9;
            iEv = 0;
        }
        for (int i18 = 0; i18 < i6; i18++) {
            View view5 = this.e[i18];
            bir birVar3 = (bir) view5.getLayoutParams();
            if (this.bd != 1) {
                iEx = ex() + this._b[birVar3.a];
                iG2 = this.bf.g(view5) + iEx;
            } else if (db()) {
                int iEv2 = ev() + this._b[this.c - birVar3.a];
                iG = iEv2;
                iEv = iEv2 - this.bf.g(view5);
            } else {
                iEv = ev() + this._b[birVar3.a];
                iG = this.bf.g(view5) + iEv;
            }
            czg.eo(view5, iEv, iEx, iG, iG2);
            if (birVar3.c.af() || birVar3.c.ai()) {
                bviVar.c = true;
            }
            bviVar.d = view5.hasFocusable() | bviVar.d;
        }
        Arrays.fill(this.e, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void ao(czo czoVar, czt cztVar, bvh bvhVar, int i) {
        bc();
        if (cztVar.p() > 0 && !cztVar.g) {
            boolean z = i == 1;
            int i_c = _c(bvhVar.b, czoVar, cztVar);
            if (z) {
                while (i_c > 0) {
                    int i2 = bvhVar.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    bvhVar.b = i3;
                    i_c = _c(i3, czoVar, cztVar);
                }
            } else {
                int iP = cztVar.p() - 1;
                int i4 = bvhVar.b;
                while (i4 < iP) {
                    int i5 = i4 + 1;
                    int i_c2 = _c(i5, czoVar, cztVar);
                    if (i_c2 <= i_c) {
                        break;
                    }
                    i4 = i5;
                    i_c = i_c2;
                }
                bvhVar.b = i4;
            }
        }
        ar();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void ap(boolean z) {
        if (z) {
            throw new UnsupportedOperationException(
                    "GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.ap(false);
    }

    public final void aq(int i) {
        int i2;
        int[] iArr = this._b;
        int i3 = this.c;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this._b = iArr;
    }

    public final void ar() {
        View[] viewArr = this.e;
        if (viewArr == null || viewArr.length != this.c) {
            this.e = new View[this.c];
        }
    }

    public final int as(int i) {
        if (this.bd == 0) {
            RecyclerView recyclerView = this.dp;
            return ax(i, recyclerView.m, recyclerView.bo);
        }
        RecyclerView recyclerView2 = this.dp;
        return _c(i, recyclerView2.m, recyclerView2.bo);
    }

    public final int at(int i) {
        if (this.bd == 1) {
            RecyclerView recyclerView = this.dp;
            return ax(i, recyclerView.m, recyclerView.bo);
        }
        RecyclerView recyclerView2 = this.dp;
        return _c(i, recyclerView2.m, recyclerView2.bo);
    }

    public final HashSet au(int i) {
        return av(at(i), i);
    }

    public final HashSet av(int i, int i2) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.dp;
        int i_d = _d(i2, recyclerView.m, recyclerView.bo);
        for (int i3 = i; i3 < i + i_d; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    public final int aw(int i, int i2) {
        if (this.bd != 1 || !db()) {
            int[] iArr = this._b;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this._b;
        int i3 = this.c;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int ax(int i, czo czoVar, czt cztVar) {
        if (!cztVar.g) {
            return this.h.m(i, this.c);
        }
        int iJ = czoVar.j(i);
        if (iJ != -1) {
            return this.h.m(iJ, this.c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    public final void bc() {
        int iEu;
        int iEx;
        if (this.bd == 1) {
            iEu = this.eb - ew();
            iEx = ev();
        } else {
            iEu = this.ec - eu();
            iEx = ex();
        }
        aq(iEu - iEx);
    }

    @Override // me.hd.wauxv.obf.czg
    public final boolean m(czh czhVar) {
        return czhVar instanceof bir;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int n(czt cztVar) {
        return cm(cztVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int o(czt cztVar) {
        return cn(cztVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int p(czt cztVar) {
        return cm(cztVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final int q(czt cztVar) {
        return cn(cztVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final czh r() {
        return this.bd == 0 ? new bir(-2, -1) : new bir(-1, -2);
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh s(Context context, AttributeSet attributeSet) {
        bir birVar = new bir(context, attributeSet);
        birVar.a = -1;
        birVar.b = 0;
        return birVar;
    }

    @Override // me.hd.wauxv.obf.czg
    public final czh t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            bir birVar = new bir((ViewGroup.MarginLayoutParams) layoutParams);
            birVar.a = -1;
            birVar.b = 0;
            return birVar;
        }
        bir birVar2 = new bir(layoutParams);
        birVar2.a = -1;
        birVar2.b = 0;
        return birVar2;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int u(czo czoVar, czt cztVar) {
        if (this.bd == 1) {
            return Math.min(this.c, et());
        }
        if (cztVar.p() < 1) {
            return 0;
        }
        return ax(cztVar.p() - 1, czoVar, cztVar) + 1;
    }

    @Override // me.hd.wauxv.obf.czg
    public final int v(czo czoVar, czt cztVar) {
        if (this.bd == 0) {
            return Math.min(this.c, et());
        }
        if (cztVar.p() < 1) {
            return 0;
        }
        return ax(cztVar.p() - 1, czoVar, cztVar) + 1;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
     * 
     * if (r13 == (r2 > r15)) goto L57;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final android.view.View w(android.view.View r23, int r24, me.hd.wauxv.obf.czo r25, me.hd.wauxv.obf.czt r26) {
        /*
         * Method dump skipped, instruction units count: 326
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.w(android.view.View, int, me.hd.wauxv.obf.czo, me.hd.wauxv.obf.czt):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, me.hd.wauxv.obf.czg
    public final void x(czo czoVar, czt cztVar, bd bdVar) {
        super.x(czoVar, cztVar, bdVar);
        bdVar.k(GridView.class.getName());
        cyw cywVar = this.dp.w;
        if (cywVar == null || cywVar.d() <= 1) {
            return;
        }
        bdVar.e(ax.k);
    }

    @Override // me.hd.wauxv.obf.czg
    public final void y(czo czoVar, czt cztVar, View view, bd bdVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof bir)) {
            ez(view, bdVar);
            return;
        }
        bir birVar = (bir) layoutParams;
        int iAx = ax(birVar.c.z(), czoVar, cztVar);
        if (this.bd == 0) {
            bdVar.l(bc.g(birVar.a, birVar.b, iAx, 1, false));
        } else {
            bdVar.l(bc.g(iAx, 1, birVar.a, birVar.b, false));
        }
    }

    @Override // me.hd.wauxv.obf.czg
    public final void z(int i, int i2) {
        this.h.q();
        ((SparseIntArray) this.h.h).clear();
    }

    public GridLayoutManager(int i) {
        super(1);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new biq();
        this.i = new Rect();
        this.j = -1;
        this.k = -1;
        this.l = -1;
        _f(i);
    }

    public GridLayoutManager() {
        super(1);
        this.b = false;
        this.c = -1;
        this.f = new SparseIntArray();
        this.g = new SparseIntArray();
        this.h = new biq();
        this.i = new Rect();
        this.j = -1;
        this.k = -1;
        this.l = -1;
        _f(2);
    }
}
