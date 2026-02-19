package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ea {
    public int a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;
    public Object f;

    public ea(cjg cjgVar) {
        this.b = cjgVar;
        this.c = new ArrayList();
        this.e = new LinkedHashMap();
    }

    public static final Object g(ea eaVar, int i) {
        List list;
        if (((h) eaVar.f) == null || (list = xf.l) == null) {
            list = EmptyReadonlyList.INSTANCE;
        }
        return (!list.isEmpty() || eaVar.a <= 0) ? StaticHelpers5.h(i, list) : new Object();
    }

    public void aa(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((eke) this.d) == null) {
                this.d = new eke();
            }
            eke ekeVar = (eke) this.d;
            ekeVar.a = colorStateList;
            ekeVar.d = true;
        } else {
            this.d = null;
        }
        h();
    }

    public void ab(ColorStateList colorStateList) {
        if (((eke) this.e) == null) {
            this.e = new eke();
        }
        eke ekeVar = (eke) this.e;
        ekeVar.a = colorStateList;
        ekeVar.d = true;
        h();
    }

    public void ac(PorterDuff.Mode mode) {
        if (((eke) this.e) == null) {
            this.e = new eke();
        }
        eke ekeVar = (eke) this.e;
        ekeVar.b = mode;
        ekeVar.c = true;
        h();
    }

    public int ad(int i, int i2) {
        int i3;
        int i4;
        cuw cuwVar = (cuw) this.b;
        ArrayList arrayList = (ArrayList) this.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            dz dzVar = (dz) arrayList.get(size);
            int i5 = dzVar.a;
            if (i5 == 8) {
                int i6 = dzVar.b;
                int i7 = dzVar.c;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            dzVar.b = i6 + 1;
                            dzVar.c = i7 + 1;
                        } else if (i2 == 2) {
                            dzVar.b = i6 - 1;
                            dzVar.c = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        dzVar.c = i7 + 1;
                    } else if (i2 == 2) {
                        dzVar.c = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        dzVar.b = i6 + 1;
                    } else if (i2 == 2) {
                        dzVar.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = dzVar.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= dzVar.c;
                    } else if (i5 == 2) {
                        i += dzVar.c;
                    }
                } else if (i2 == 1) {
                    dzVar.b = i8 + 1;
                } else if (i2 == 2) {
                    dzVar.b = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            dz dzVar2 = (dz) arrayList.get(size2);
            if (dzVar2.a == 8) {
                int i9 = dzVar2.c;
                if (i9 == dzVar2.b || i9 < 0) {
                    arrayList.remove(size2);
                    cuwVar.l(dzVar2);
                }
            } else if (dzVar2.c <= 0) {
                arrayList.remove(size2);
                cuwVar.l(dzVar2);
            }
        }
        return i;
    }

    public void h() {
        View view = (View) this.b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((eke) this.d) != null) {
                if (((eke) this.f) == null) {
                    this.f = new eke();
                }
                eke ekeVar = (eke) this.f;
                ekeVar.a = null;
                ekeVar.d = false;
                ekeVar.b = null;
                ekeVar.c = false;
                WeakHashMap weakHashMap = ViewCompat.a;
                ColorStateList colorStateListC = eqq.c(view);
                if (colorStateListC != null) {
                    ekeVar.d = true;
                    ekeVar.a = colorStateListC;
                }
                PorterDuff.Mode modeD = eqq.d(view);
                if (modeD != null) {
                    ekeVar.c = true;
                    ekeVar.b = modeD;
                }
                if (ekeVar.d || ekeVar.c) {
                    C0023if.g(background, ekeVar, view.getDrawableState());
                    return;
                }
            }
            eke ekeVar2 = (eke) this.e;
            if (ekeVar2 != null) {
                C0023if.g(background, ekeVar2, view.getDrawableState());
                return;
            }
            eke ekeVar3 = (eke) this.d;
            if (ekeVar3 != null) {
                C0023if.g(background, ekeVar3, view.getDrawableState());
            }
        }
    }

    public boolean i(int i) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            dz dzVar = (dz) arrayList.get(i2);
            int i3 = dzVar.a;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = dzVar.b;
                    int i5 = dzVar.c + i4;
                    while (i4 < i5) {
                        if (n(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (n(dzVar.c, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void j() {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((cyv) this.e).b((dz) arrayList.get(i));
        }
        z(arrayList);
        this.a = 0;
    }

    public void k() {
        cyv cyvVar = (cyv) this.e;
        j();
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            dz dzVar = (dz) arrayList.get(i);
            int i2 = dzVar.a;
            if (i2 == 1) {
                cyvVar.b(dzVar);
                cyvVar.h(dzVar.b, dzVar.c);
            } else if (i2 == 2) {
                cyvVar.b(dzVar);
                int i3 = dzVar.b;
                int i4 = dzVar.c;
                RecyclerView recyclerView = cyvVar.a;
                recyclerView.eb(i3, i4, true);
                recyclerView.br = true;
                recyclerView.bo.c += i4;
            } else if (i2 == 4) {
                cyvVar.b(dzVar);
                cyvVar.d(dzVar.b, dzVar.c);
            } else if (i2 == 8) {
                cyvVar.b(dzVar);
                cyvVar.i(dzVar.b, dzVar.c);
            }
        }
        z(arrayList);
        this.a = 0;
    }

    public void l(dz dzVar) {
        int i;
        cuw cuwVar = (cuw) this.b;
        int i2 = dzVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iAd = ad(dzVar.b, i2);
        int i3 = dzVar.b;
        int i4 = dzVar.a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + dzVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < dzVar.c; i6++) {
            int iAd2 = ad((i * i6) + dzVar.b, dzVar.a);
            int i7 = dzVar.a;
            if (i7 == 2 ? iAd2 != iAd : !(i7 == 4 && iAd2 == iAd + 1)) {
                dz dzVarU = u(i7, iAd, i5);
                m(dzVarU, i3);
                cuwVar.l(dzVarU);
                if (dzVar.a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iAd = iAd2;
            } else {
                i5++;
            }
        }
        cuwVar.l(dzVar);
        if (i5 > 0) {
            dz dzVarU2 = u(dzVar.a, iAd, i5);
            m(dzVarU2, i3);
            cuwVar.l(dzVarU2);
        }
    }

    public void m(dz dzVar, int i) {
        cyv cyvVar = (cyv) this.e;
        cyvVar.b(dzVar);
        int i2 = dzVar.a;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            cyvVar.d(i, dzVar.c);
        } else {
            int i3 = dzVar.c;
            RecyclerView recyclerView = cyvVar.a;
            recyclerView.eb(i, i3, true);
            recyclerView.br = true;
            recyclerView.bo.c += i3;
        }
    }

    public int n(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.d;
        int size = arrayList.size();
        while (i2 < size) {
            dz dzVar = (dz) arrayList.get(i2);
            int i3 = dzVar.a;
            if (i3 == 8) {
                int i4 = dzVar.b;
                if (i4 == i) {
                    i = dzVar.c;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (dzVar.c <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = dzVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = dzVar.c;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += dzVar.c;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean o() {
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.c;
        if (linkedHashSet != null && linkedHashSet.isEmpty()) {
            return false;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((daa) it.next()).getClass();
        }
        return false;
    }

    public boolean p() {
        LinkedHashSet linkedHashSet = (LinkedHashSet) this.c;
        if (linkedHashSet != null && linkedHashSet.isEmpty()) {
            return false;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((daa) it.next()).getClass();
        }
        return false;
    }

    public ColorStateList q() {
        eke ekeVar = (eke) this.e;
        if (ekeVar != null) {
            return ekeVar.a;
        }
        return null;
    }

    public PorterDuff.Mode r() {
        eke ekeVar = (eke) this.e;
        if (ekeVar != null) {
            return ekeVar.b;
        }
        return null;
    }

    public boolean s() {
        return ((ArrayList) this.c).size() > 0;
    }

    public void t(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListN;
        View view = (View) this.b;
        Context context = view.getContext();
        int[] iArr = cyf.z;
        FactoryPools factoryPoolsVarK = FactoryPools.k(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        View view2 = (View) this.b;
        ViewCompat.r(view2, view2.getContext(), iArr, attributeSet, (TypedArray) factoryPoolsVarK.e, i, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.a = typedArray.getResourceId(0, -1);
                C0023if c0023if = (C0023if) this.c;
                Context context2 = view.getContext();
                int i2 = this.a;
                synchronized (c0023if) {
                    colorStateListN = c0023if.c.n(context2, i2);
                }
                if (colorStateListN != null) {
                    aa(colorStateListN);
                }
            }
            if (typedArray.hasValue(1)) {
                eqq.i(view, factoryPoolsVarK.r(1));
            }
            if (typedArray.hasValue(2)) {
                eqq.j(view, apy.f(typedArray.getInt(2, -1), null));
            }
            factoryPoolsVarK.ae();
        } catch (Throwable th) {
            factoryPoolsVarK.ae();
            throw th;
        }
    }

    public dz u(int i, int i2, int i3) {
        dz dzVar = (dz) ((cuw) this.b).acquire();
        if (dzVar != null) {
            dzVar.a = i;
            dzVar.b = i2;
            dzVar.c = i3;
            return dzVar;
        }
        dz dzVar2 = new dz();
        dzVar2.a = i;
        dzVar2.b = i2;
        dzVar2.c = i3;
        return dzVar2;
    }

    public void v() {
        this.a = -1;
        aa(null);
        h();
    }

    public void w(int i) {
        ColorStateList colorStateListN;
        this.a = i;
        C0023if c0023if = (C0023if) this.c;
        if (c0023if != null) {
            Context context = ((View) this.b).getContext();
            synchronized (c0023if) {
                colorStateListN = c0023if.c.n(context, i);
            }
        } else {
            colorStateListN = null;
        }
        aa(colorStateListN);
        h();
    }

    public void x(dz dzVar) {
        cyv cyvVar = (cyv) this.e;
        ((ArrayList) this.d).add(dzVar);
        int i = dzVar.a;
        if (i == 1) {
            cyvVar.h(dzVar.b, dzVar.c);
            return;
        }
        if (i == 2) {
            int i2 = dzVar.b;
            int i3 = dzVar.c;
            RecyclerView recyclerView = cyvVar.a;
            recyclerView.eb(i2, i3, false);
            recyclerView.br = true;
            return;
        }
        if (i == 4) {
            cyvVar.d(dzVar.b, dzVar.c);
        } else if (i == 8) {
            cyvVar.i(dzVar.b, dzVar.c);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + dzVar);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x017e  */
    /* JADX WARN: Found duplicated region for block: B:104:0x018c  */
    /* JADX WARN: Found duplicated region for block: B:105:0x0190  */
    /* JADX WARN: Found duplicated region for block: B:187:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:188:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:191:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:192:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:201:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:205:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Found duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Found duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Found duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Found duplicated region for block: B:37:0x009b  */
    /* JADX WARN: Found duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Found duplicated region for block: B:76:0x0126  */
    /* JADX WARN: Found duplicated region for block: B:77:0x0128  */
    /* JADX WARN: Found duplicated region for block: B:79:0x012e  */
    /* JADX WARN: Found duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Found duplicated region for block: B:85:0x0144  */
    /* JADX WARN: Found duplicated region for block: B:88:0x014f  */
    /* JADX WARN: Found duplicated region for block: B:89:0x0155  */
    /* JADX WARN: Found duplicated region for block: B:90:0x0157  */
    /* JADX WARN: Found duplicated region for block: B:92:0x015d  */
    /* JADX WARN: Found duplicated region for block: B:95:0x0168  */
    /* JADX WARN: Found duplicated region for block: B:98:0x0173  */
    public void y() {
        int i;
        boolean z;
        byte b;
        dz dzVarU;
        int i2;
        int i3;
        int i4;
        dz dzVarU2;
        boolean z2;
        boolean z3;
        dz dzVarU3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        cuw cuwVar = (cuw) this.b;
        cyv cyvVar = (cyv) this.e;
        SyntheticPileOfMess bmuVar = (SyntheticPileOfMess) this.f;
        ArrayList arrayList = (ArrayList) this.c;
        bmuVar.getClass();
        while (true) {
            int size = arrayList.size() - 1;
            boolean z4 = false;
            while (true) {
                i = 8;
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (((dz) arrayList.get(size)).a != 8) {
                    z4 = true;
                } else if (z4) {
                    break;
                }
                size--;
            }
            if (size == -1) {
                break;
            }
            int i13 = size + 1;
            ea eaVar = (ea) bmuVar.obj;
            cuw cuwVar2 = (cuw) eaVar.b;
            dz dzVar = (dz) arrayList.get(size);
            dz dzVar2 = (dz) arrayList.get(i13);
            int i14 = dzVar2.a;
            if (i14 == 1) {
                int i15 = dzVar.c;
                int i16 = dzVar2.b;
                int i17 = i15 < i16 ? -1 : 0;
                int i18 = dzVar.b;
                if (i18 < i16) {
                    i17++;
                }
                if (i16 <= i18) {
                    dzVar.b = i18 + dzVar2.c;
                }
                int i19 = dzVar2.b;
                if (i19 <= i15) {
                    dzVar.c = i15 + dzVar2.c;
                }
                dzVar2.b = i19 + i17;
                arrayList.set(size, dzVar2);
                arrayList.set(i13, dzVar);
            } else if (i14 == 2) {
                int i20 = dzVar.b;
                int i21 = dzVar.c;
                if (i20 < i21) {
                    z2 = dzVar2.b == i20 && dzVar2.c == i21 - i20;
                    z3 = false;
                } else {
                    z2 = dzVar2.b == i21 + 1 && dzVar2.c == i20 - i21;
                    z3 = true;
                }
                int i22 = dzVar2.b;
                if (i21 < i22) {
                    dzVar2.b = i22 - 1;
                } else {
                    int i23 = dzVar2.c;
                    if (i21 < i22 + i23) {
                        dzVar2.c = i23 - 1;
                        dzVar.a = 2;
                        dzVar.c = 1;
                        if (dzVar2.c == 0) {
                            arrayList.remove(i13);
                            cuwVar2.l(dzVar2);
                        }
                    }
                }
                int i24 = dzVar.b;
                int i25 = dzVar2.b;
                if (i24 <= i25) {
                    dzVar2.b = i25 + 1;
                } else {
                    int i26 = i25 + dzVar2.c;
                    if (i24 < i26) {
                        dzVarU3 = eaVar.u(2, i24 + 1, i26 - i24);
                        dzVar2.c = dzVar.b - dzVar2.b;
                    }
                    if (z2) {
                        arrayList.set(size, dzVar2);
                        arrayList.remove(i13);
                        cuwVar2.l(dzVar);
                    } else {
                        if (z3) {
                            if (dzVarU3 != null) {
                                i11 = dzVar.b;
                                if (i11 > dzVarU3.b) {
                                    dzVar.b = i11 - dzVarU3.c;
                                }
                                i12 = dzVar.c;
                                if (i12 > dzVarU3.b) {
                                    dzVar.c = i12 - dzVarU3.c;
                                }
                            }
                            i9 = dzVar.b;
                            if (i9 > dzVar2.b) {
                                dzVar.b = i9 - dzVar2.c;
                            }
                            i10 = dzVar.c;
                            if (i10 > dzVar2.b) {
                                dzVar.c = i10 - dzVar2.c;
                            }
                        } else {
                            if (dzVarU3 != null) {
                                i7 = dzVar.b;
                                if (i7 >= dzVarU3.b) {
                                    dzVar.b = i7 - dzVarU3.c;
                                }
                                i8 = dzVar.c;
                                if (i8 >= dzVarU3.b) {
                                    dzVar.c = i8 - dzVarU3.c;
                                }
                            }
                            i5 = dzVar.b;
                            if (i5 >= dzVar2.b) {
                                dzVar.b = i5 - dzVar2.c;
                            }
                            i6 = dzVar.c;
                            if (i6 >= dzVar2.b) {
                                dzVar.c = i6 - dzVar2.c;
                            }
                        }
                        arrayList.set(size, dzVar2);
                        if (dzVar.b != dzVar.c) {
                            arrayList.set(i13, dzVar);
                        } else {
                            arrayList.remove(i13);
                        }
                        if (dzVarU3 != null) {
                            arrayList.add(size, dzVarU3);
                        }
                    }
                }
                dzVarU3 = null;
                if (z2) {
                    arrayList.set(size, dzVar2);
                    arrayList.remove(i13);
                    cuwVar2.l(dzVar);
                } else {
                    if (z3) {
                        if (dzVarU3 != null) {
                            i11 = dzVar.b;
                            if (i11 > dzVarU3.b) {
                                dzVar.b = i11 - dzVarU3.c;
                            }
                            i12 = dzVar.c;
                            if (i12 > dzVarU3.b) {
                                dzVar.c = i12 - dzVarU3.c;
                            }
                        }
                        i9 = dzVar.b;
                        if (i9 > dzVar2.b) {
                            dzVar.b = i9 - dzVar2.c;
                        }
                        i10 = dzVar.c;
                        if (i10 > dzVar2.b) {
                            dzVar.c = i10 - dzVar2.c;
                        }
                    } else {
                        if (dzVarU3 != null) {
                            i7 = dzVar.b;
                            if (i7 >= dzVarU3.b) {
                                dzVar.b = i7 - dzVarU3.c;
                            }
                            i8 = dzVar.c;
                            if (i8 >= dzVarU3.b) {
                                dzVar.c = i8 - dzVarU3.c;
                            }
                        }
                        i5 = dzVar.b;
                        if (i5 >= dzVar2.b) {
                            dzVar.b = i5 - dzVar2.c;
                        }
                        i6 = dzVar.c;
                        if (i6 >= dzVar2.b) {
                            dzVar.c = i6 - dzVar2.c;
                        }
                    }
                    arrayList.set(size, dzVar2);
                    if (dzVar.b != dzVar.c) {
                        arrayList.set(i13, dzVar);
                    } else {
                        arrayList.remove(i13);
                    }
                    if (dzVarU3 != null) {
                        arrayList.add(size, dzVarU3);
                    }
                }
            } else if (i14 == 4) {
                int i27 = dzVar.c;
                int i28 = dzVar2.b;
                if (i27 < i28) {
                    dzVar2.b = i28 - 1;
                } else {
                    int i29 = dzVar2.c;
                    if (i27 < i28 + i29) {
                        dzVar2.c = i29 - 1;
                        dzVarU = eaVar.u(4, dzVar.b, 1);
                    }
                    i2 = dzVar.b;
                    i3 = dzVar2.b;
                    if (i2 <= i3) {
                        dzVar2.b = i3 + 1;
                    } else {
                        i4 = i3 + dzVar2.c;
                        if (i2 < i4) {
                            int i30 = i4 - i2;
                            dzVarU2 = eaVar.u(4, i2 + 1, i30);
                            dzVar2.c -= i30;
                        }
                        arrayList.set(i13, dzVar);
                        if (dzVar2.c > 0) {
                            arrayList.set(size, dzVar2);
                        } else {
                            arrayList.remove(size);
                            cuwVar2.l(dzVar2);
                        }
                        if (dzVarU != null) {
                            arrayList.add(size, dzVarU);
                        }
                        if (dzVarU2 != null) {
                            arrayList.add(size, dzVarU2);
                        }
                    }
                    dzVarU2 = null;
                    arrayList.set(i13, dzVar);
                    if (dzVar2.c > 0) {
                        arrayList.set(size, dzVar2);
                    } else {
                        arrayList.remove(size);
                        cuwVar2.l(dzVar2);
                    }
                    if (dzVarU != null) {
                        arrayList.add(size, dzVarU);
                    }
                    if (dzVarU2 != null) {
                        arrayList.add(size, dzVarU2);
                    }
                }
                dzVarU = null;
                i2 = dzVar.b;
                i3 = dzVar2.b;
                if (i2 <= i3) {
                    dzVar2.b = i3 + 1;
                } else {
                    i4 = i3 + dzVar2.c;
                    if (i2 < i4) {
                        int i302 = i4 - i2;
                        dzVarU2 = eaVar.u(4, i2 + 1, i302);
                        dzVar2.c -= i302;
                    }
                    arrayList.set(i13, dzVar);
                    if (dzVar2.c > 0) {
                        arrayList.set(size, dzVar2);
                    } else {
                        arrayList.remove(size);
                        cuwVar2.l(dzVar2);
                    }
                    if (dzVarU != null) {
                        arrayList.add(size, dzVarU);
                    }
                    if (dzVarU2 != null) {
                        arrayList.add(size, dzVarU2);
                    }
                }
                dzVarU2 = null;
                arrayList.set(i13, dzVar);
                if (dzVar2.c > 0) {
                    arrayList.set(size, dzVar2);
                } else {
                    arrayList.remove(size);
                    cuwVar2.l(dzVar2);
                }
                if (dzVarU != null) {
                    arrayList.add(size, dzVarU);
                }
                if (dzVarU2 != null) {
                    arrayList.add(size, dzVarU2);
                }
            }
        }
        int size2 = arrayList.size();
        int i31 = 0;
        while (i31 < size2) {
            dz dzVarU4 = (dz) arrayList.get(i31);
            int i32 = dzVarU4.a;
            if (i32 == 1) {
                x(dzVarU4);
            } else if (i32 == 2) {
                int i33 = dzVarU4.b;
                int i34 = dzVarU4.c + i33;
                int i35 = i33;
                byte b2 = -1;
                int i36 = 0;
                while (i35 < i34) {
                    if (cyvVar.c(i35) != null || i(i35)) {
                        if (b2 == 0) {
                            l(u(2, i33, i36));
                            z = true;
                        } else {
                            z = false;
                        }
                        b = 1;
                    } else {
                        if (b2 == 1) {
                            x(u(2, i33, i36));
                            z = true;
                        } else {
                            z = false;
                        }
                        b = 0;
                    }
                    if (z) {
                        i35 -= i36;
                        i34 -= i36;
                        i36 = 1;
                    } else {
                        i36++;
                    }
                    i35++;
                    b2 = b;
                }
                if (i36 != dzVarU4.c) {
                    cuwVar.l(dzVarU4);
                    dzVarU4 = u(2, i33, i36);
                }
                if (b2 == 0) {
                    l(dzVarU4);
                } else {
                    x(dzVarU4);
                }
            } else if (i32 == 4) {
                int i37 = dzVarU4.b;
                int i38 = dzVarU4.c + i37;
                int i39 = i37;
                byte b3 = -1;
                int i40 = 0;
                while (i37 < i38) {
                    if (cyvVar.c(i37) != null || i(i37)) {
                        if (b3 == 0) {
                            l(u(4, i39, i40));
                            i39 = i37;
                            i40 = 0;
                        }
                        b3 = 1;
                    } else {
                        if (b3 == 1) {
                            x(u(4, i39, i40));
                            i39 = i37;
                            i40 = 0;
                        }
                        b3 = 0;
                    }
                    i40++;
                    i37++;
                }
                if (i40 != dzVarU4.c) {
                    cuwVar.l(dzVarU4);
                    dzVarU4 = u(4, i39, i40);
                }
                if (b3 == 0) {
                    l(dzVarU4);
                } else {
                    x(dzVarU4);
                }
            } else if (i32 == i) {
                x(dzVarU4);
            }
            i31++;
            i = 8;
        }
        arrayList.clear();
    }

    public void z(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            dz dzVar = (dz) arrayList.get(i);
            dzVar.getClass();
            ((cuw) this.b).l(dzVar);
        }
        arrayList.clear();
    }

    public ea(View view) {
        this.a = -1;
        this.b = view;
        this.c = C0023if.d();
    }

    public ea(Context context) {
        this.b = context;
        this.c = new LinkedHashSet();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.a = -1;
    }

    public ea(cyv cyvVar) {
        this.b = new cuw(30);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.a = 0;
        this.e = cyvVar;
        this.f = new SyntheticPileOfMess(this);
    }
}
