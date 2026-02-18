package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyu implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ RecyclerView b;

    public /* synthetic */ cyu(RecyclerView recyclerView, int i) {
        this.a = i;
        this.b = recyclerView;
    }

    /* JADX WARN: Found duplicated region for block: B:44:0x0119  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        int i = this.a;
        RecyclerView recyclerView = this.b;
        switch (i) {
            case 0:
                if (recyclerView.ae && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.ac) {
                        recyclerView.requestLayout();
                    } else if (recyclerView.ah) {
                        recyclerView.ag = true;
                    } else {
                        recyclerView.cz();
                    }
                    break;
                }
                break;
            default:
                czc czcVar = recyclerView.aw;
                if (czcVar != null) {
                    akx akxVar = (akx) czcVar;
                    long j = akxVar.aa;
                    ArrayList<czx> arrayList = akxVar.c;
                    boolean zIsEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = akxVar.e;
                    boolean zIsEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = akxVar.f;
                    boolean zIsEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = akxVar.d;
                    boolean zIsEmpty4 = arrayList4.isEmpty();
                    if (zIsEmpty && zIsEmpty2 && zIsEmpty4 && zIsEmpty3) {
                        z = false;
                    } else {
                        for (czx czxVar : arrayList) {
                            View view = czxVar.d;
                            ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                            akxVar.l.add(czxVar);
                            viewPropertyAnimatorAnimate.setDuration(j).alpha(0.0f).setListener(new aks(akxVar, czxVar, viewPropertyAnimatorAnimate, view)).start();
                            arrayList = arrayList;
                            zIsEmpty = zIsEmpty;
                        }
                        boolean z2 = zIsEmpty;
                        arrayList.clear();
                        if (!zIsEmpty2) {
                            ArrayList arrayList5 = new ArrayList();
                            arrayList5.addAll(arrayList2);
                            akxVar.h.add(arrayList5);
                            arrayList2.clear();
                            akr akrVar = new akr(akxVar, arrayList5, 0);
                            if (z2) {
                                akrVar.run();
                            } else {
                                View view2 = ((akw) arrayList5.get(0)).a.d;
                                WeakHashMap weakHashMap = eqz.a;
                                view2.postOnAnimationDelayed(akrVar, j);
                            }
                        }
                        if (!zIsEmpty3) {
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.addAll(arrayList3);
                            akxVar.i.add(arrayList6);
                            arrayList3.clear();
                            akr akrVar2 = new akr(akxVar, arrayList6, 1);
                            if (z2) {
                                akrVar2.run();
                            } else {
                                View view3 = ((akv) arrayList6.get(0)).a.d;
                                WeakHashMap weakHashMap2 = eqz.a;
                                view3.postOnAnimationDelayed(akrVar2, j);
                            }
                        }
                        if (zIsEmpty4) {
                            z = false;
                        } else {
                            ArrayList arrayList7 = new ArrayList();
                            arrayList7.addAll(arrayList4);
                            akxVar.g.add(arrayList7);
                            arrayList4.clear();
                            akr akrVar3 = new akr(akxVar, arrayList7, 2);
                            if (z2 && zIsEmpty2 && zIsEmpty3) {
                                akrVar3.run();
                                z = false;
                            } else {
                                if (z2) {
                                    j = 0;
                                }
                                long jMax = Math.max(!zIsEmpty2 ? akxVar.ab : 0L, zIsEmpty3 ? 0L : akxVar.ac) + j;
                                z = false;
                                View view4 = ((czx) arrayList7.get(0)).d;
                                WeakHashMap weakHashMap3 = eqz.a;
                                view4.postOnAnimationDelayed(akrVar3, jMax);
                            }
                        }
                    }
                } else {
                    z = false;
                }
                recyclerView.bu = z;
                break;
        }
    }
}
