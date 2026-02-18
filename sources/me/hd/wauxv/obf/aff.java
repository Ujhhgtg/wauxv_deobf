package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aff implements CharSequence {
    public final ArrayList a;
    public final ArrayList b;
    public final ReentrantReadWriteLock c;
    public int d;
    public int e;
    public final AtomicLong f = new AtomicLong(1);
    public final sq g;
    public final afg h;
    public final enr i;
    public ahy j;

    public aff(CharSequence charSequence, boolean z) {
        charSequence = charSequence == null ? "" : charSequence;
        if (z) {
            this.c = new ReentrantReadWriteLock();
        } else {
            this.c = null;
        }
        this.d = 0;
        this.e = 0;
        ArrayList arrayList = new ArrayList(1000);
        this.a = arrayList;
        arrayList.add(new afo((Object) null));
        this.b = new ArrayList();
        this.h = new afg(this);
        enr enrVar = new enr();
        this.i = enrVar;
        enrVar.c = 500;
        enrVar.k();
        this.g = new sq(this);
        if (charSequence.length() == 0) {
            ak(true);
            return;
        }
        ak(false);
        ab(0, 0, charSequence);
        ak(true);
    }

    public final String aa(int i) {
        ae(false);
        try {
            o(i);
            return ((afo) this.a.get(i)).toString();
        } finally {
            ap(false);
        }
    }

    public final void ab(int i, int i2, CharSequence charSequence) {
        ae(true);
        this.f.getAndIncrement();
        try {
            ac(i, i2, charSequence);
        } finally {
            ap(true);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:74:0x0157  */
    public final void ac(int i, int i2, CharSequence charSequence) {
        Object obj;
        int i3;
        bpq bpqVar;
        aff affVar;
        bvd bvdVar;
        aff affVar2 = this;
        int i4 = i;
        p(i, i2);
        if (charSequence == null) {
            throw new IllegalArgumentException("text can not be null");
        }
        int i5 = i2;
        if (i5 > ((afo) affVar2.a.get(i4)).b) {
            i5 = ((afo) affVar2.a.get(i4)).b;
        }
        ahy ahyVar = affVar2.j;
        if (ahyVar != null) {
            ahyVar.e = ahyVar.b.o(i4, i5).d();
        }
        affVar2.t();
        afo afoVarAf = af(i);
        synchronized (bpq.class) {
            int i6 = 0;
            while (true) {
                bpq[] bpqVarArr = bpq.a;
                obj = null;
                i3 = 8;
                if (i6 >= 8) {
                    bpqVar = new bpq();
                    break;
                }
                bpqVar = bpqVarArr[i6];
                if (bpqVar != null) {
                    bpqVarArr[i6] = null;
                    break;
                }
                i6++;
            }
        }
        bpqVar.e = charSequence;
        bpqVar.b = -1;
        bpqVar.c = 0;
        bpqVar.d = charSequence.length();
        LinkedList linkedList = new LinkedList();
        bvd bvdVarG = afoVarAf.g();
        int i7 = i4;
        int i8 = i5;
        boolean z = false;
        int i9 = 2;
        while (true) {
            int iH = z ? i9 : bpqVar.h();
            if (iH == 2) {
                afoVarAf.d = bvdVarG;
                affVar2.a.addAll(i4 + 1, linkedList);
                synchronized (bpq.class) {
                    int i10 = 0;
                    while (true) {
                        try {
                            bpq[] bpqVarArr2 = bpq.a;
                            if (i10 >= i3) {
                                break;
                            }
                            if (bpqVarArr2[i10] == null) {
                                bpqVarArr2[i10] = bpqVar;
                                bpqVar.e = obj;
                                bpqVar.b = 0;
                                bpqVar.d = 0;
                                break;
                            }
                            i10++;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                affVar2.d = charSequence.length() + affVar2.d;
                int i11 = i8;
                int i12 = i7;
                affVar2.i.cz(affVar2, i4, i5, i12, i11, charSequence);
                aff affVar3 = affVar2;
                ahy ahyVar2 = affVar3.j;
                if (ahyVar2 != null) {
                    sq sqVar = ahyVar2.b;
                    sqVar.cz(ahyVar2.a, i, i5, i12, i11, charSequence);
                    int i13 = ahyVar2.e.a;
                    int i14 = ahyVar2.c.a;
                    if (i14 >= i13) {
                        ahyVar2.c = sqVar.n(charSequence.length() + i14).d();
                    }
                    int i15 = ahyVar2.d.a;
                    if (i15 >= i13) {
                        ahyVar2.d = sqVar.n(charSequence.length() + i15).d();
                    }
                }
                sq sqVar2 = affVar3.g;
                if (sqVar2 != null) {
                    affVar = affVar3;
                    sqVar2.cz(affVar, i, i5, i12, i11, charSequence);
                } else {
                    affVar = affVar3;
                }
                Iterator it = affVar.b.iterator();
                while (it.hasNext()) {
                    ((afp) it.next()).cz(affVar, i, i5, i12, i11, charSequence);
                    affVar = this;
                }
                return;
            }
            int i16 = i8;
            if (iH == 0) {
                afoVarAf.h(i16, bpqVar.b, bpqVar.c, charSequence);
                i8 = (bpqVar.c - bpqVar.b) + i16;
                affVar2 = this;
                i4 = i;
                z = false;
            } else {
                int i17 = bpqVar.b;
                int i18 = bpqVar.c;
                if (i18 != i17) {
                    int i19 = i18 - i17;
                    if (i19 == 1) {
                        char cCharAt = charSequence.charAt(i17);
                        if (cCharAt != '\r') {
                            if (cCharAt != '\n') {
                                if (i19 != 2) {
                                    break;
                                } else {
                                    break;
                                }
                            }
                            bvdVar = bvd.LF;
                        } else {
                            bvdVar = bvd.CR;
                        }
                    } else if (i19 != 2 || charSequence.charAt(i17) != '\r' || charSequence.charAt(i17 + 1) != '\n') {
                        break;
                    } else {
                        bvdVar = bvd.CRLF;
                    }
                } else {
                    bvdVar = bvd.NONE;
                }
                afoVarAf.d = bvdVar;
                int iH2 = bpqVar.h();
                afo afoVar = new afo((((afoVarAf.b - i16) + bpqVar.c) - bpqVar.b) + 10);
                afoVar.h(0, i16, afoVarAf.b, afoVarAf);
                afoVarAf.f(i16, afoVarAf.b);
                linkedList.add(afoVar);
                i7++;
                i3 = 8;
                affVar2 = this;
                i9 = iH2;
                afoVarAf = afoVar;
                z = true;
                obj = null;
                i4 = i;
                i8 = 0;
            }
        }
        throw new IllegalArgumentException("unknown line separator type");
    }

    public final boolean ad(int i, int i2) {
        anu anuVarZ = z(i);
        for (int i3 = 0; i3 < anuVarZ.a.length; i3++) {
            if (i2 >= anuVarZ.d(i3) && i2 < anuVarZ.e(i3)) {
                return anuVarZ.f(i3);
            }
        }
        return false;
    }

    public final void ae(boolean z) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.c;
        if (reentrantReadWriteLock == null) {
            return;
        }
        (z ? reentrantReadWriteLock.writeLock() : reentrantReadWriteLock.readLock()).lock();
    }

    public final afo af(int i) {
        afo afoVar = (afo) this.a.get(i);
        afoVar.getClass();
        return afoVar;
    }

    public final void ag(int i, int i2, CharSequence charSequence) {
        ud udVarN = x().n(i);
        ud udVarN2 = x().n(i2);
        ah(udVarN.b, udVarN.c, charSequence, udVarN2.b, udVarN2.c);
    }

    public final void ah(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (charSequence == null) {
            throw new IllegalArgumentException("text can not be null");
        }
        ae(true);
        this.f.getAndIncrement();
        try {
            this.i.cy(this);
            ahy ahyVar = this.j;
            if (ahyVar != null) {
                ahyVar.b.getClass();
            }
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((afp) it.next()).cy(this);
            }
            s(i, i2, i3, i4);
            ac(i, i2, charSequence);
        } finally {
            ap(true);
        }
    }

    public final void ai(int i, int i2, afd afdVar) {
        ae(false);
        try {
            afc afcVar = new afc(0);
            afcVar.b = false;
            while (i <= i2 && !afcVar.b) {
                afdVar.c(i, (afo) this.a.get(i), afcVar);
                i++;
            }
            ap(false);
        } catch (Throwable th) {
            ap(false);
            throw th;
        }
    }

    public final void aj(int i, afe afeVar) {
        ae(false);
        for (int i2 = 0; i2 <= i; i2++) {
            try {
                afo afoVar = (afo) this.a.get(i2);
                afeVar.a(i2, afoVar, this.h.c(i2, afoVar));
            } catch (Throwable th) {
                ap(false);
                throw th;
            }
        }
        ap(false);
    }

    public final void ak(boolean z) {
        enr enrVar = this.i;
        enrVar.b = z;
        if (z) {
            return;
        }
        enrVar.k();
    }

    public final aff al(int i, int i2, int i3, int i4) {
        aff affVar = new aff(null, true);
        affVar.ak(false);
        ArrayList arrayList = this.a;
        ArrayList arrayList2 = affVar.a;
        if (i == i3) {
            afo afoVar = (afo) arrayList.get(i);
            if (i4 != afoVar.b + 1 || afoVar.g() != bvd.CRLF) {
                affVar.ab(0, 0, afoVar.subSequence(i2, i4));
            } else if (i2 < i4) {
                affVar.ab(0, 0, afoVar.subSequence(i2, afoVar.b));
                ((afo) arrayList2.get(0)).d = bvd.CR;
                affVar.d++;
                arrayList2.add(new afo((Object) null));
            }
        } else {
            if (i >= i3) {
                throw new StringIndexOutOfBoundsException("start > end");
            }
            afo afoVar2 = (afo) arrayList.get(i);
            if (afoVar2.g() == bvd.CRLF) {
                int i5 = afoVar2.b;
                if (i2 <= i5) {
                    affVar.ab(0, 0, afoVar2.subSequence(i2, i5));
                    ((afo) arrayList2.get(0)).d = afoVar2.g();
                    affVar.d += afoVar2.g().g;
                } else {
                    if (i2 != i5 + 1) {
                        throw new IndexOutOfBoundsException();
                    }
                    afo afoVar3 = (afo) arrayList2.get(0);
                    bvd bvdVar = bvd.LF;
                    afoVar3.d = bvdVar;
                    affVar.d += bvdVar.g;
                }
            } else {
                affVar.ab(0, 0, afoVar2.subSequence(i2, afoVar2.b));
                ((afo) arrayList2.get(0)).d = afoVar2.g();
                affVar.d += afoVar2.g().g;
            }
            for (int i6 = i + 1; i6 < i3; i6++) {
                afo afoVar4 = (afo) arrayList.get(i6);
                arrayList2.add(new afo(afoVar4));
                affVar.d = afoVar4.b + afoVar4.g().g + affVar.d;
            }
            afo afoVar5 = (afo) arrayList.get(i3);
            if (i4 == afoVar5.b + 1 && afoVar5.g() == bvd.CRLF) {
                afo afoVar6 = new afo((Object) null);
                afoVar6.h(0, 0, i4 - 1, afoVar5);
                arrayList2.add(afoVar6);
                afoVar6.d = bvd.CR;
                affVar.d = i4 + 1 + affVar.d;
            } else {
                afo afoVar7 = new afo((Object) null);
                afoVar7.h(0, 0, i4, afoVar5);
                arrayList2.add(afoVar7);
                affVar.d += i4;
            }
        }
        affVar.ak(true);
        return affVar;
    }

    public final StringBuilder am(int i, int i2, int i3, int i4, int i5) {
        StringBuilder sb = new StringBuilder(i5);
        ArrayList arrayList = this.a;
        if (i == i3) {
            afo afoVar = (afo) arrayList.get(i);
            if (i4 != afoVar.b + 1 || afoVar.g() != bvd.CRLF) {
                sb.append((CharSequence) arrayList.get(i), i2, i4);
                return sb;
            }
            if (i2 < i4) {
                sb.append((CharSequence) arrayList.get(i), i2, afoVar.b);
                sb.append(bvd.CR.f);
            }
            return sb;
        }
        if (i >= i3) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        afo afoVar2 = (afo) arrayList.get(i);
        if (afoVar2.g() == bvd.CRLF) {
            int i6 = afoVar2.b;
            if (i2 <= i6) {
                sb.append((CharSequence) afoVar2, i2, i6);
                sb.append(afoVar2.g().f);
            } else {
                if (i2 != i6 + 1) {
                    throw new IndexOutOfBoundsException();
                }
                sb.append(bvd.LF.f);
            }
        } else {
            sb.append((CharSequence) afoVar2, i2, afoVar2.b);
            sb.append(afoVar2.g().f);
        }
        while (true) {
            i++;
            if (i >= i3) {
                break;
            }
            afo afoVar3 = (afo) arrayList.get(i);
            sb.append((CharSequence) afoVar3);
            sb.append(afoVar3.g().f);
        }
        afo afoVar4 = (afo) arrayList.get(i3);
        if (i4 != afoVar4.b + 1 || afoVar4.g() != bvd.CRLF) {
            sb.append((CharSequence) afoVar4, 0, i4);
            return sb;
        }
        sb.append((CharSequence) afoVar4, 0, i4);
        sb.append(bvd.CR.f);
        return sb;
    }

    public final String an(int i, int i2) {
        ud udVarN;
        ud udVarN2;
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        ae(false);
        try {
            udVarN = x().n(i);
            udVarN2 = x().n(i2);
        } catch (Throwable th) {
            th = th;
        }
        try {
            String string = am(udVarN.b, udVarN.c, udVarN2.b, udVarN2.c, (i2 - i) + 1).toString();
            ap(false);
            return string;
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            ap(false);
            throw th3;
        }
    }

    public final StringBuilder ao() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.a;
        sb.ensureCapacity(sb.length() + this.d);
        ae(false);
        try {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                afo afoVar = (afo) arrayList.get(i);
                sb.append(afoVar.a, 0, afoVar.b);
                sb.append(afoVar.g().f);
            }
            ap(false);
            return sb;
        } catch (Throwable th) {
            ap(false);
            throw th;
        }
    }

    public final void ap(boolean z) {
        ReentrantReadWriteLock reentrantReadWriteLock = this.c;
        if (reentrantReadWriteLock == null) {
            return;
        }
        (z ? reentrantReadWriteLock.writeLock() : reentrantReadWriteLock.readLock()).unlock();
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        n(i);
        ae(false);
        try {
            ud udVarN = x().n(i);
            return ((afo) this.a.get(udVarN.b)).charAt(udVarN.c);
        } finally {
            ap(false);
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aff) {
            aff affVar = (aff) obj;
            if (affVar.d == this.d) {
                int i = 0;
                while (true) {
                    ArrayList arrayList = this.a;
                    if (i >= arrayList.size()) {
                        return true;
                    }
                    afo afoVar = (afo) arrayList.get(i);
                    afo afoVar2 = (afo) affVar.a.get(i);
                    if (afoVar.b == afoVar2.b) {
                        if (afoVar != afoVar2) {
                            for (int i2 = 0; i2 < afoVar.b; i2++) {
                                if (afoVar.charAt(i2) == afoVar2.charAt(i2)) {
                                }
                            }
                        }
                        i++;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, Integer.valueOf(this.d));
    }

    public final void k(afp afpVar) {
        if (afpVar instanceof sq) {
            throw new IllegalArgumentException("Permission denied");
        }
        ArrayList arrayList = this.b;
        if (arrayList.contains(afpVar)) {
            return;
        }
        arrayList.add(afpVar);
    }

    public final boolean l() {
        int i = this.e + 1;
        this.e = i;
        return i > 0;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.d;
    }

    public final char m(int i, int i2) {
        ae(false);
        try {
            p(i, i2);
            return ((afo) this.a.get(i)).charAt(i2);
        } finally {
            ap(false);
        }
    }

    public final void n(int i) {
        if (i > this.d || i < 0) {
            StringBuilder sbR = yg.r(i, "Index ", " out of bounds. length:");
            sbR.append(this.d);
            throw new StringIndexOutOfBoundsException(sbR.toString());
        }
    }

    public final void o(int i) {
        ArrayList arrayList = this.a;
        if (i >= arrayList.size() || i < 0) {
            StringBuilder sbR = yg.r(i, "Line ", " out of bounds. line count:");
            sbR.append(arrayList.size());
            throw new StringIndexOutOfBoundsException(sbR.toString());
        }
    }

    public final void p(int i, int i2) {
        o(i);
        afo afoVar = (afo) this.a.get(i);
        int i3 = afoVar.b + afoVar.g().g;
        if (i2 > i3 || i2 < 0) {
            StringBuilder sbQ = yg.q(i2, i, "Column ", " out of bounds. line: ", " , column count (line separator included):");
            sbQ.append(i3);
            throw new StringIndexOutOfBoundsException(sbQ.toString());
        }
    }

    public final void q(int i, int i2) {
        ae(true);
        n(i);
        n(i2);
        this.f.getAndIncrement();
        try {
            ud udVarN = x().n(i);
            ud udVarN2 = x().n(i2);
            if (i != i2) {
                s(udVarN.b, udVarN.c, udVarN2.b, udVarN2.c);
            }
        } finally {
            ap(true);
        }
    }

    public final void r(int i, int i2, int i3, int i4) {
        ae(true);
        this.f.getAndIncrement();
        try {
            s(i, i2, i3, i4);
        } finally {
            ap(true);
        }
    }

    public final void s(int i, int i2, int i3, int i4) {
        int i5;
        p(i3, i4);
        p(i, i2);
        if (i == i3 && i2 == i4) {
            return;
        }
        ArrayList arrayList = this.a;
        if (i4 > ((afo) arrayList.get(i3)).b && (i5 = i3 + 1) < arrayList.size()) {
            s(i, i2, i5, 0);
            return;
        }
        int i6 = ((afo) arrayList.get(i)).b;
        if (i2 > i6) {
            s(i, i6, i3, i4);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (i == i3) {
            afo afoVarAf = af(i);
            int i7 = afoVarAf.b;
            if (i2 < 0 || i4 > i7 || i2 > i4) {
                throw new StringIndexOutOfBoundsException("invalid bounds");
            }
            ahy ahyVar = this.j;
            if (ahyVar != null) {
                sq sqVar = ahyVar.b;
                ahyVar.f = sqVar.o(i, i2).d();
                ahyVar.g = sqVar.o(i3, i4).d();
            }
            t();
            sb.append((CharSequence) afoVarAf, i2, i4);
            afoVarAf.f(i2, i4);
            this.d -= i4 - i2;
        } else {
            if (i >= i3) {
                throw new IllegalArgumentException("start line > end line");
            }
            ahy ahyVar2 = this.j;
            if (ahyVar2 != null) {
                sq sqVar2 = ahyVar2.b;
                ahyVar2.f = sqVar2.o(i, i2).d();
                ahyVar2.g = sqVar2.o(i3, i4).d();
            }
            t();
            int i8 = i + 1;
            for (int i9 = i8; i9 <= i3 - 1; i9++) {
                afo afoVar = (afo) arrayList.get(i9);
                bvd bvdVarG = ((afo) arrayList.get(i9)).g();
                int i10 = this.d;
                int i11 = afoVar.b;
                this.d = i10 - (bvdVarG.g + i11);
                sb.append(afoVar.a, 0, i11);
                sb.append(bvdVarG.f);
            }
            if (i3 > i8) {
                arrayList.subList(i8, i3).clear();
            }
            afo afoVarAf2 = af(i);
            afo afoVar2 = (afo) arrayList.get(i8);
            int i12 = this.d;
            int i13 = afoVarAf2.b;
            this.d = i12 - (i13 - i2);
            sb.insert(0, afoVarAf2, i2, i13).insert(afoVarAf2.b - i2, afoVarAf2.g().f);
            afoVarAf2.f(i2, afoVarAf2.b);
            this.d -= i4;
            sb.append((CharSequence) afoVar2, 0, i4);
            this.d -= afoVarAf2.g().g;
            arrayList.remove(i8);
            dqt dqtVar = new dqt(i4, afoVar2.b, afoVar2);
            afoVarAf2.h(afoVarAf2.b, 0, dqtVar.length(), dqtVar);
            afoVarAf2.d = afoVar2.g();
        }
        this.i.db(this, i, i2, i3, i4, sb);
        ahy ahyVar3 = this.j;
        if (ahyVar3 != null) {
            sq sqVar3 = ahyVar3.b;
            sqVar3.db(ahyVar3.a, i, i2, i3, i4, sb);
            int i14 = ahyVar3.f.a;
            int i15 = ahyVar3.g.a;
            int i16 = ahyVar3.c.a;
            int i17 = ahyVar3.d.a;
            if (i14 <= i17) {
                int i18 = i15 - i14;
                int iMax = i16 - Math.max(0, Math.min(i16 - i14, i18));
                int iMax2 = i17 - Math.max(0, Math.min(i17 - i14, i18));
                ahyVar3.c = sqVar3.n(iMax).d();
                ahyVar3.d = sqVar3.n(iMax2).d();
            }
        }
        sq sqVar4 = this.g;
        aff affVar = this;
        if (sqVar4 != null) {
            sqVar4.db(affVar, i, i2, i3, i4, sb);
        }
        Iterator it = affVar.b.iterator();
        while (it.hasNext()) {
            ((afp) it.next()).db(affVar, i, i2, i3, i4, sb);
            affVar = this;
        }
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("start > end");
        }
        ae(false);
        try {
            ud udVarN = x().n(i);
            ud udVarN2 = x().n(i2);
            return al(udVarN.b, udVarN.c, udVarN2.b, udVarN2.c);
        } finally {
            ap(false);
        }
    }

    public final void t() {
        this.i.da(this);
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((afp) it.next()).da(this);
        }
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return ao().toString();
    }

    public final boolean u() {
        int i = this.e - 1;
        this.e = i;
        if (i == 0) {
            enr enrVar = this.i;
            enrVar.i = true;
            ArrayList arrayList = enrVar.a;
            if (!arrayList.isEmpty() && (dkz.l(1, arrayList) instanceof enp)) {
                enp enpVar = (enp) dkz.l(1, arrayList);
                if (enpVar.f.size() == 1) {
                    arrayList.set(arrayList.size() - 1, (enm) enpVar.f.get(0));
                }
            }
        }
        if (this.e < 0) {
            this.e = 0;
        }
        return this.e > 0;
    }

    public final int v(int i, int i2) {
        ae(false);
        try {
            return x().o(i, i2).a;
        } finally {
            ap(false);
        }
    }

    public final ahy w() {
        if (this.j == null) {
            this.j = new ahy(this);
        }
        return this.j;
    }

    public final sq x() {
        ahy ahyVar = this.j;
        return ahyVar != null ? ahyVar.b : this.g;
    }

    public final afo y(int i) {
        ae(false);
        try {
            return (afo) this.a.get(i);
        } finally {
            ap(false);
        }
    }

    public final anu z(int i) {
        ae(false);
        try {
            return this.h.c(i, (afo) this.a.get(i));
        } finally {
            ap(false);
        }
    }
}
