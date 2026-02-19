package me.hd.wauxv.obf;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akx extends czc {
    public static TimeInterpolator a;
    public boolean b;
    public ArrayList c;
    public ArrayList d;
    public ArrayList e;
    public ArrayList f;
    public ArrayList g;
    public ArrayList h;
    public ArrayList i;
    public ArrayList j;
    public ArrayList k;
    public ArrayList l;
    public ArrayList m;

    public static void n(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((SomeView) arrayList.get(size)).d.animate().cancel();
        }
    }

    @Override // me.hd.wauxv.obf.czc
    public final boolean o(SomeView someViewVar, SomeView someViewVar2, cjn cjnVar, cjn cjnVar2) {
        int i;
        int i2;
        int i3 = cjnVar.a;
        int i4 = cjnVar.b;
        if (someViewVar2.am()) {
            int i5 = cjnVar.a;
            i2 = cjnVar.b;
            i = i5;
        } else {
            i = cjnVar2.a;
            i2 = cjnVar2.b;
        }
        if (someViewVar == someViewVar2) {
            return s(someViewVar, i3, i4, i, i2);
        }
        View view = someViewVar.d;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        w(someViewVar);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = someViewVar2.d;
        w(someViewVar2);
        view2.setTranslationX(-((int) ((i - i3) - translationX)));
        view2.setTranslationY(-((int) ((i2 - i4) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f;
        akv akvVar = new akv();
        akvVar.a = someViewVar;
        akvVar.b = someViewVar2;
        akvVar.c = i3;
        akvVar.d = i4;
        akvVar.e = i;
        akvVar.f = i2;
        arrayList.add(akvVar);
        return true;
    }

    @Override // me.hd.wauxv.obf.czc
    public final void p(SomeView someViewVar) {
        ArrayList arrayList = this.g;
        ArrayList arrayList2 = this.h;
        ArrayList arrayList3 = this.i;
        View view = someViewVar.d;
        view.animate().cancel();
        ArrayList arrayList4 = this.e;
        int size = arrayList4.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((akw) arrayList4.get(size)).a == someViewVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                ae(someViewVar);
                arrayList4.remove(size);
            }
        }
        u(this.f, someViewVar);
        if (this.c.remove(someViewVar)) {
            view.setAlpha(1.0f);
            ae(someViewVar);
        }
        if (this.d.remove(someViewVar)) {
            view.setAlpha(1.0f);
            ae(someViewVar);
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList5 = (ArrayList) arrayList3.get(size2);
            u(arrayList5, someViewVar);
            if (arrayList5.isEmpty()) {
                arrayList3.remove(size2);
            }
        }
        for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList6 = (ArrayList) arrayList2.get(size3);
            for (int size4 = arrayList6.size() - 1; size4 >= 0; size4--) {
                if (((akw) arrayList6.get(size4)).a == someViewVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    ae(someViewVar);
                    arrayList6.remove(size4);
                    if (!arrayList6.isEmpty()) {
                        break;
                    }
                    arrayList2.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = arrayList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList.get(size5);
            if (arrayList7.remove(someViewVar)) {
                view.setAlpha(1.0f);
                ae(someViewVar);
                if (arrayList7.isEmpty()) {
                    arrayList.remove(size5);
                }
            }
        }
        this.l.remove(someViewVar);
        this.j.remove(someViewVar);
        this.m.remove(someViewVar);
        this.k.remove(someViewVar);
        t();
    }

    @Override // me.hd.wauxv.obf.czc
    public final void q() {
        ArrayList arrayList = this.i;
        ArrayList arrayList2 = this.g;
        ArrayList arrayList3 = this.h;
        ArrayList arrayList4 = this.f;
        ArrayList arrayList5 = this.d;
        ArrayList arrayList6 = this.c;
        ArrayList arrayList7 = this.e;
        int size = arrayList7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            akw akwVar = (akw) arrayList7.get(size);
            View view = akwVar.a.d;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            ae(akwVar.a);
            arrayList7.remove(size);
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            ae((SomeView) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            SomeView someViewVar = (SomeView) arrayList5.get(size3);
            someViewVar.d.setAlpha(1.0f);
            ae(someViewVar);
            arrayList5.remove(size3);
        }
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            akv akvVar = (akv) arrayList4.get(size4);
            SomeView someViewVar2 = akvVar.a;
            if (someViewVar2 != null) {
                v(akvVar, someViewVar2);
            }
            SomeView someViewVar3 = akvVar.b;
            if (someViewVar3 != null) {
                v(akvVar, someViewVar3);
            }
        }
        arrayList4.clear();
        if (r()) {
            for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList3.get(size5);
                for (int size6 = arrayList8.size() - 1; size6 >= 0; size6--) {
                    akw akwVar2 = (akw) arrayList8.get(size6);
                    View view2 = akwVar2.a.d;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    ae(akwVar2.a);
                    arrayList8.remove(size6);
                    if (arrayList8.isEmpty()) {
                        arrayList3.remove(arrayList8);
                    }
                }
            }
            for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList2.get(size7);
                for (int size8 = arrayList9.size() - 1; size8 >= 0; size8--) {
                    SomeView someViewVar4 = (SomeView) arrayList9.get(size8);
                    someViewVar4.d.setAlpha(1.0f);
                    ae(someViewVar4);
                    arrayList9.remove(size8);
                    if (arrayList9.isEmpty()) {
                        arrayList2.remove(arrayList9);
                    }
                }
            }
            for (int size9 = arrayList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    akv akvVar2 = (akv) arrayList10.get(size10);
                    SomeView someViewVar5 = akvVar2.a;
                    if (someViewVar5 != null) {
                        v(akvVar2, someViewVar5);
                    }
                    SomeView someViewVar6 = akvVar2.b;
                    if (someViewVar6 != null) {
                        v(akvVar2, someViewVar6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList.remove(arrayList10);
                    }
                }
            }
            n(this.l);
            n(this.k);
            n(this.j);
            n(this.m);
            ArrayList arrayList11 = this.y;
            if (arrayList11.size() > 0) {
                arrayList11.get(0).getClass();
                throw new ClassCastException();
            }
            arrayList11.clear();
        }
    }

    @Override // me.hd.wauxv.obf.czc
    public final boolean r() {
        return (this.d.isEmpty() && this.f.isEmpty() && this.e.isEmpty() && this.c.isEmpty() && this.k.isEmpty() && this.l.isEmpty() && this.j.isEmpty() && this.m.isEmpty() && this.h.isEmpty() && this.g.isEmpty() && this.i.isEmpty()) ? false : true;
    }

    public final boolean s(SomeView someViewVar, int i, int i2, int i3, int i4) {
        View view = someViewVar.d;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) someViewVar.d.getTranslationY());
        w(someViewVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            ae(someViewVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ArrayList arrayList = this.e;
        akw akwVar = new akw();
        akwVar.a = someViewVar;
        akwVar.b = translationX;
        akwVar.c = translationY;
        akwVar.d = i3;
        akwVar.e = i4;
        arrayList.add(akwVar);
        return true;
    }

    public final void t() {
        if (r()) {
            return;
        }
        ArrayList arrayList = this.y;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw new ClassCastException();
        }
    }

    public final void u(ArrayList arrayList, SomeView someViewVar) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            akv akvVar = (akv) arrayList.get(size);
            if (v(akvVar, someViewVar) && akvVar.a == null && akvVar.b == null) {
                arrayList.remove(akvVar);
            }
        }
    }

    public final boolean v(akv akvVar, SomeView someViewVar) {
        if (akvVar.b == someViewVar) {
            akvVar.b = null;
        } else {
            if (akvVar.a != someViewVar) {
                return false;
            }
            akvVar.a = null;
        }
        View view = someViewVar.d;
        View view2 = someViewVar.d;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        ae(someViewVar);
        return true;
    }

    public final void w(SomeView someViewVar) {
        if (a == null) {
            a = new ValueAnimator().getInterpolator();
        }
        someViewVar.d.animate().setInterpolator(a);
        p(someViewVar);
    }
}
