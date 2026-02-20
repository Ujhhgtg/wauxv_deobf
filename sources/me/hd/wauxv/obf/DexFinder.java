package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DexFinder extends dqc {
    public dnf a;
    public an b;
    public DexMethodGroupMatcher d;
    public DexMethodGroupMatcher e;
    public MethodMatcher f;
    public List g;
    public ArrayList h;
    public MethodMatcher i;
    public MethodMatcher j;

    public static void k(DexFinder cdjVar, String str) {
        List arrayList = cdjVar.g;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        cdjVar.g = arrayList;
        arrayList.add(new dnf(str, MatchTypeEnum.Contains, false));
    }

    public static void setClassEquals(DexFinder cdjVar, String str) {
        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
        zbVar.j(str, MatchTypeEnum.Equals);
        cdjVar.d = zbVar;
    }

    public static void m(DexFinder cdjVar, int i) {
        an anVar = new an();
        anVar.a = i;
        anVar.b = UsingStringsTypeEnum.Contains;
        cdjVar.b = anVar;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        int iT;
        int iV;
        int i;
        int iV2;
        throwIfVar1IsNull(bbbVar, "fbb");
        dnf dnfVar = this.a;
        int iC = dnfVar != null ? dnfVar.c(bbbVar) : 0;
        an anVar = this.b;
        int iC2 = anVar != null ? anVar.c(bbbVar) : 0;
        DexMethodGroupMatcher zbVar = this.d;
        int iC3 = zbVar != null ? zbVar.c(bbbVar) : 0;
        DexMethodGroupMatcher zbVar2 = this.e;
        int iC4 = zbVar2 != null ? zbVar2.c(bbbVar) : 0;
        MethodMatcher fjVar = this.f;
        int iC5 = fjVar != null ? fjVar.c(bbbVar) : 0;
        List list = this.g;
        if (list != null) {
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((dnf) it.next()).c(bbbVar)));
            }
            iT = bbbVar.t(StaticHelpers5.y(arrayList));
        } else {
            iT = 0;
        }
        ArrayList arrayList2 = this.h;
        if (arrayList2 != null) {
            ArrayList arrayList3 = new ArrayList(StaticHelpers4.ak(arrayList2, 10));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                cpg cpgVar = ((cpf) it2.next()).b;
                throwIfVar1IsNull(cpgVar);
                arrayList3.add(new emp(cpgVar.h));
            }
            byte[] bArrY = aye.y(arrayList3);
            bbbVar.ac(1, bArrY.length, 1);
            for (int length = bArrY.length - 1; -1 < length; length--) {
                bbbVar.n(bArrY[length]);
            }
            iV = bbbVar.v();
        } else {
            iV = 0;
        }
        ArrayList arrayList4 = this.h;
        if (arrayList4 != null) {
            i = 1;
            ArrayList arrayList5 = new ArrayList(StaticHelpers4.ak(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                DexBaseQuery dexBaseQueryVar = ((cpf) it3.next()).a;
                throwIfVar1IsNull(dexBaseQueryVar,
                        "null cannot be cast to non-null type org.luckypray.dexkit.query.base.BaseQuery");
                arrayList5.add(Integer.valueOf(dexBaseQueryVar.c(bbbVar)));
            }
            int[] iArrY = StaticHelpers5.y(arrayList5);
            bbbVar.ac(4, iArrY.length, 4);
            for (int length2 = iArrY.length - 1; -1 < length2; length2--) {
                bbbVar.p(iArrY[length2]);
            }
            iV2 = bbbVar.v();
        } else {
            i = 1;
            iV2 = 0;
        }
        MethodMatcher fjVar2 = this.i;
        int iC6 = fjVar2 != null ? fjVar2.c(bbbVar) : 0;
        MethodMatcher fjVar3 = this.j;
        int iC7 = fjVar3 != null ? fjVar3.c(bbbVar) : 0;
        bbbVar.ab(14);
        bbbVar.q(13, 0);
        bbbVar.q(12, iC7);
        bbbVar.q(11, iC6);
        bbbVar.q(10, iV2);
        bbbVar.q(9, iV);
        bbbVar.q(8, 0);
        bbbVar.q(7, iT);
        bbbVar.q(6, 0);
        bbbVar.q(5, 0);
        bbbVar.q(4, iC5);
        bbbVar.q(3, iC4);
        bbbVar.q(2, iC3);
        bbbVar.q(i, iC2);
        bbbVar.q(0, iC);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }

    public final void n(String str) {
        List arrayList = this.g;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.g = arrayList;
        arrayList.add(new dnf(str, MatchTypeEnum.Equals, false));
    }

    public final void setDeclaredClassName(Class cls) {
        throwIfVar1IsNull(cls, "clazz");
        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
        zbVar.j(ams.getClassPrimitiveTypeName(cls), MatchTypeEnum.Equals);
        this.d = zbVar;
    }

    public final void p(IntRange intRangeVar) {
        if (this.f == null) {
            this.f = new MethodMatcher(4);
        }
        MethodMatcher fjVar = this.f;
        throwIfVar1IsNull(fjVar);
        bqh bqhVar = new bqh();
        bqhVar.a = intRangeVar.first;
        bqhVar.b = intRangeVar.last;
        fjVar.usingStringsType = bqhVar;
    }

    public final void q(Class... clsArr) {
        cst cstVar;
        MethodMatcher fjVar = new MethodMatcher(4);
        fjVar.b = StaticHelpers5.ab(EmptyReadonlyList.INSTANCE);
        for (Class cls : clsArr) {
            if (cls != null) {
                cstVar = new cst();
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.j(ams.getClassPrimitiveTypeName(cls), MatchTypeEnum.Equals);
                cstVar.a = zbVar;
            } else {
                cstVar = null;
            }
            List arrayList = fjVar.b;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            fjVar.b = arrayList;
            arrayList.add(cstVar);
        }
        this.f = fjVar;
    }

    public final void r(Class cls) {
        throwIfVar1IsNull(cls, "clazz");
        DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
        zbVar.j(ams.getClassPrimitiveTypeName(cls), MatchTypeEnum.Equals);
        this.e = zbVar;
    }

    public final void s(String str) {
        this.a = new dnf(str, MatchTypeEnum.Equals, false);
    }

    public final void usingStrings(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new dnf(str, MatchTypeEnum.Equals, false));
        }
        this.g = StaticHelpers5.ab(arrayList);
    }

    public final void u(Number... numberArr) {
        ArrayList arrayList = new ArrayList(numberArr.length);
        for (Number number : numberArr) {
            cpf cpfVar = new cpf();
            throwIfVar1IsNull(number, "number");
            if (number instanceof Byte) {
                cpfVar.a = new avl(number.byteValue());
                cpfVar.b = cpg.ByteValue;
            } else if (number instanceof Short) {
                cpfVar.a = new avq(number.shortValue());
                cpfVar.b = cpg.ShortValue;
            } else if (number instanceof Integer) {
                cpfVar.a = new avo(number.intValue());
                cpfVar.b = cpg.IntValue;
            } else if (number instanceof Long) {
                cpfVar.a = new avp(number.longValue());
                cpfVar.b = cpg.LongValue;
            } else if (number instanceof Float) {
                cpfVar.a = new avn(number.floatValue());
                cpfVar.b = cpg.FloatValue;
            } else if (number instanceof Double) {
                cpfVar.a = new avm(number.doubleValue());
                cpfVar.b = cpg.DoubleValue;
            }
            arrayList.add(cpfVar);
        }
        this.h = StaticHelpers5.ab(arrayList);
    }

    public final void v(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new dnf(str, MatchTypeEnum.Contains, false));
        }
        this.g = StaticHelpers5.ab(arrayList);
    }
}
