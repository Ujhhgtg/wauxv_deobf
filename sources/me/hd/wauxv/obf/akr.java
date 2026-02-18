package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akr implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ akx c;

    public /* synthetic */ akr(akx akxVar, ArrayList arrayList, int i) {
        this.a = i;
        this.c = akxVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ArrayList arrayList = this.b;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    akx akxVar = this.c;
                    if (!zHasNext) {
                        arrayList.clear();
                        akxVar.h.remove(arrayList);
                    } else {
                        akw akwVar = (akw) it.next();
                        czx czxVar = akwVar.a;
                        int i = akwVar.b;
                        int i2 = akwVar.c;
                        int i3 = akwVar.d;
                        int i4 = akwVar.e;
                        akxVar.getClass();
                        View view = czxVar.d;
                        int i5 = i3 - i;
                        int i6 = i4 - i2;
                        if (i5 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i6 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        akxVar.k.add(czxVar);
                        viewPropertyAnimatorAnimate.setDuration(akxVar.ab).setListener(new akt(akxVar, czxVar, i5, view, i6, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.b;
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    akx akxVar2 = this.c;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        akxVar2.i.remove(arrayList2);
                        break;
                    } else {
                        akv akvVar = (akv) it2.next();
                        ArrayList arrayList3 = akxVar2.m;
                        long j = akxVar2.ac;
                        czx czxVar2 = akvVar.a;
                        View view2 = czxVar2 == null ? null : czxVar2.d;
                        czx czxVar3 = akvVar.b;
                        View view3 = czxVar3 != null ? czxVar3.d : null;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j);
                            arrayList3.add(akvVar.a);
                            duration.translationX(akvVar.e - akvVar.c);
                            duration.translationY(akvVar.f - akvVar.d);
                            duration.alpha(0.0f).setListener(new aku(akxVar2, akvVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(akvVar.b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j).alpha(1.0f).setListener(new aku(akxVar2, akvVar, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                    }
                }
                break;
            default:
                ArrayList arrayList4 = this.b;
                Iterator it3 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it3.hasNext();
                    akx akxVar3 = this.c;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        akxVar3.g.remove(arrayList4);
                    } else {
                        czx czxVar4 = (czx) it3.next();
                        akxVar3.getClass();
                        View view4 = czxVar4.d;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        akxVar3.j.add(czxVar4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(akxVar3.z).setListener(new aks(akxVar3, czxVar4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}
