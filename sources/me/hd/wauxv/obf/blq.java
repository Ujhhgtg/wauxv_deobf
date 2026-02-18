package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blq {
    public final Object a;
    public final Object b;
    public final Object c;
    public Object d;
    public Object e;

    public blq(Map map) {
        bzo.q(map, "initialState");
        this.a = new LinkedHashMap(map);
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new bdv(this, 3);
    }

    public ViewGroup.LayoutParams f() throws cth {
        Class cls = (Class) this.b;
        po poVar = (po) this.d;
        if (poVar == null && ((erp) this.e) == null) {
            throw new cth("No layout params builder found.");
        }
        if (poVar != null) {
            int i = poVar.a;
            int i2 = poVar.b;
            boolean z = poVar.c;
            if (i == -3) {
                i = z ? -1 : -2;
            }
            ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) zf.e(cls, new Object[]{Integer.valueOf(i), Integer.valueOf(i2 != -3 ? i2 : -2)});
            if (layoutParams == null) {
                throw new IllegalStateException(("Create ViewGroup.LayoutParams failed. Could not found the default constructor LayoutParams(width, height) in " + cls + ".").toString());
            }
            LinkedHashMap linkedHashMap = ((blu) this.a).f;
            String name = layoutParams.getClass().getName();
            int size = linkedHashMap.size();
            ((bgf) poVar.d).invoke(layoutParams);
            if (linkedHashMap.size() == size) {
                return layoutParams;
            }
            throw new cth(bjs.o("Performers are not allowed to appear in ", name, " DSL creation process."));
        }
        erp erpVar = (erp) this.e;
        if (erpVar == null) {
            throw new cth("Internal error of build layout params.");
        }
        blq blqVar = (blq) erpVar.v;
        ViewGroup.LayoutParams layoutParams2 = null;
        ViewGroup.LayoutParams layoutParamsF = blqVar != null ? blqVar.f() : null;
        if (layoutParamsF != null) {
            ViewGroup viewGroup = (ViewGroup) this.c;
            if (viewGroup != null) {
                int i3 = bte.a;
                bmu bmuVarBi = dqc.bi(viewGroup);
                bmuVarBi.v(true);
                cde cdeVarT = bmuVarBi.t();
                cdeVarT.ab = "generateLayoutParams";
                cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(ViewGroup.LayoutParams.class)}, 1));
                cdeVarT.ah();
                cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
                if (cdkVar != null) {
                    layoutParams2 = (ViewGroup.LayoutParams) cdkVar.i(layoutParamsF);
                }
            }
            if (layoutParams2 != null) {
                layoutParamsF = layoutParams2;
            }
        }
        if (layoutParamsF != null) {
            return layoutParamsF;
        }
        ViewGroup.LayoutParams layoutParams3 = (ViewGroup.LayoutParams) zf.e(cls, new Object[]{-2, -2});
        if (layoutParams3 != null) {
            return layoutParams3;
        }
        throw new cth("Create default layout params failed.");
    }

    public dqa g() {
        ArrayList arrayList = (ArrayList) this.e;
        Intent intent = (Intent) this.c;
        cji cjiVar = (cji) this.d;
        if (cjiVar == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        }
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link");
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        cjg cjgVar = null;
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                intent.putExtra("android-support-nav:controller:deepLinkIds", aaz.y(arrayList2));
                intent.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList3);
                dqa dqaVar = new dqa((Context) this.a);
                Intent intent2 = new Intent(intent);
                ComponentName component = intent2.getComponent();
                if (component == null) {
                    component = intent2.resolveActivity(dqaVar.b.getPackageManager());
                }
                if (component != null) {
                    dqaVar.c(component);
                }
                ArrayList arrayList4 = dqaVar.a;
                arrayList4.add(intent2);
                int size = arrayList4.size();
                while (i < size) {
                    Intent intent3 = (Intent) arrayList4.get(i);
                    if (intent3 != null) {
                        intent3.putExtra("android-support-nav:controller:deepLinkIntent", intent);
                    }
                    i++;
                }
                return dqaVar;
            }
            cje cjeVar = (cje) it.next();
            int i2 = cjeVar.a;
            Bundle bundle = cjeVar.b;
            cjg cjgVarH = h(i2);
            if (cjgVarH == null) {
                int i3 = cjg.e;
                throw new IllegalArgumentException("Navigation destination " + bmy.r((anr) this.b, i2) + " cannot be found in the navigation graph " + cjiVar);
            }
            int[] iArrL = cjgVarH.l(cjgVar);
            int length = iArrL.length;
            while (i < length) {
                arrayList2.add(Integer.valueOf(iArrL[i]));
                arrayList3.add(bundle);
                i++;
            }
            cjgVar = cjgVarH;
        }
    }

    public cjg h(int i) {
        km kmVar = new km();
        cji cjiVar = (cji) this.d;
        bzo.n(cjiVar);
        kmVar.addLast(cjiVar);
        while (!kmVar.isEmpty()) {
            cjg cjgVar = (cjg) kmVar.removeFirst();
            if (cjgVar.g.a == i) {
                return cjgVar;
            }
            if (cjgVar instanceof cji) {
                Iterator it = ((cji) cjgVar).iterator();
                while (true) {
                    cjj cjjVar = (cjj) it;
                    if (cjjVar.hasNext()) {
                        kmVar.addLast((cjg) cjjVar.next());
                    }
                }
            }
        }
        return null;
    }

    public Object[] i() {
        return ((bmh) this.c).b.args;
    }

    public void j(String str, Object obj) {
        bzo.q(str, "key");
        ((LinkedHashMap) this.a).put(str, obj);
        chy chyVar = (chy) ((LinkedHashMap) this.c).get(str);
        if (chyVar != null) {
            ((dml) chyVar).g(obj);
        }
        chy chyVar2 = (chy) ((LinkedHashMap) this.d).get(str);
        if (chyVar2 != null) {
            ((dml) chyVar2).g(obj);
        }
    }

    public void k(Throwable th) {
        ((bmi) this.e).g(th, Boolean.TRUE);
    }

    public void l() {
        Iterator it = ((ArrayList) this.e).iterator();
        while (it.hasNext()) {
            int i = ((cje) it.next()).a;
            if (h(i) == null) {
                int i2 = cjg.e;
                StringBuilder sbZ = dkz.z("Navigation destination ", bmy.r((anr) this.b, i), " cannot be found in the navigation graph ");
                sbZ.append((cji) this.d);
                throw new IllegalArgumentException(sbZ.toString());
            }
        }
    }

    public blq(awc awcVar) {
        this.a = (bzr) awcVar.a;
        this.b = (dop) awcVar.c;
        this.c = (awp) awcVar.d;
        this.d = (awp) awcVar.e;
        this.e = (bib) awcVar.g;
    }

    public blq(cjl cjlVar) {
        Intent launchIntentForPackage;
        Context context = cjlVar.a;
        this.a = context;
        this.b = new anr(context, 8);
        Activity activity = (Activity) dfv.ah(new bae(new dpu(dfv.ai(context, new cgu(17)), new cgu(18), 1), false, new dbj(21)));
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null) {
                launchIntentForPackage = new Intent();
            }
        }
        launchIntentForPackage.addFlags(268468224);
        this.c = launchIntentForPackage;
        this.e = new ArrayList();
        this.d = cjlVar.b.ag();
    }

    public blq(bmh bmhVar, bmh bmhVar2, bmh bmhVar3, bmi bmiVar, bmi bmiVar2) {
        this.a = bmhVar;
        this.b = bmhVar2;
        this.c = bmhVar3;
        this.d = bmiVar;
        this.e = bmiVar2;
    }

    public blq(blu bluVar, Class cls, ViewGroup viewGroup) {
        this.a = bluVar;
        this.b = cls;
        this.c = viewGroup;
    }
}
