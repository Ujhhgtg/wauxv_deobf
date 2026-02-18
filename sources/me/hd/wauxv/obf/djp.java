package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class djp implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ djp(Activity activity, int i) {
        this.a = i;
        this.b = activity;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        int i = this.a;
        Activity activity = this.b;
        int i2 = 1;
        switch (i) {
            case 0:
                final bvz bvzVar = new bvz(10);
                String strZ = cnb.z(-556073710779178L);
                String strZ2 = cnb.z(-556039351040810L);
                djs djsVar = new djs();
                djsVar.a = cnb.z(-556370063522602L);
                cnb.z(-556365768555306L);
                djsVar.a = strZ;
                djsVar.b = strZ2;
                bvzVar.add(djsVar);
                aeg.a.getClass();
                Method methodBb = emn.bb(aed.a);
                aec.a.getClass();
                Object objInvoke = methodBb.invoke(aec.b(), null);
                bzo.o(objInvoke, cnb.z(-386645840886570L));
                List list = (List) objInvoke;
                ArrayList arrayList = new ArrayList(abb.ak(list, 10));
                for (Object obj2 : list) {
                    djs djsVar2 = new djs();
                    djsVar2.a = cnb.z(-556378653457194L);
                    djsVar2.b = cnb.z(-556374358489898L);
                    int i3 = bte.a;
                    azg azgVarR = dqc.bi(obj2).r();
                    azgVarR.ab = cnb.z(-556387243391786L);
                    djsVar2.a = String.valueOf(((azk) yg.e(azgVarR)).e());
                    azg azgVarR2 = dqc.bi(obj2).r();
                    azgVarR2.ab = cnb.z(-556859689794346L);
                    Object objE = ((azk) yg.e(azgVarR2)).e();
                    bzo.n(objE);
                    djsVar2.b = (String) objE;
                    arrayList.add(djsVar2);
                }
                bvzVar.addAll(arrayList);
                bvzVar.j();
                bvzVar.f = true;
                if (bvzVar.e <= 0) {
                    bvzVar = bvz.c;
                }
                djv djvVar = djv.a;
                final djp djpVar = new djp(activity, i2);
                djvVar.getClass();
                ArrayList arrayList2 = new ArrayList(abb.ak(bvzVar, 10));
                ListIterator listIterator = bvzVar.listIterator(0);
                while (true) {
                    bvx bvxVar = (bvx) listIterator;
                    if (bvxVar.hasNext()) {
                        djs djsVar3 = (djs) bvxVar.next();
                        String str = djsVar3.a;
                        String string = djsVar3.b;
                        if (!str.equals(cnb.z(-558470302530346L))) {
                            StringBuilder sbY = dkz.y(string);
                            sbY.append(cnb.z(-558435942791978L));
                            aeg aegVar = aeg.a;
                            String str2 = djsVar3.a;
                            aegVar.getClass();
                            sbY.append(aeg.b(str2).size());
                            sbY.append(']');
                            string = sbY.toString();
                        }
                        arrayList2.add(string);
                    } else {
                        String[] strArr = (String[]) arrayList2.toArray(new String[0]);
                        ArrayList arrayList3 = new ArrayList(abb.ak(bvzVar, 10));
                        ListIterator listIterator2 = bvzVar.listIterator(0);
                        while (true) {
                            bvx bvxVar2 = (bvx) listIterator2;
                            if (!bvxVar2.hasNext()) {
                                final boolean[] zArrV = aaz.v(arrayList3);
                                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                                builder.setTitle(cnb.z(-558388698151722L));
                                builder.setMultiChoiceItems(strArr, zArrV, new DialogInterface.OnMultiChoiceClickListener() { // from class: me.hd.wauxv.obf.djq
                                    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i4, boolean z) {
                                        zArrV[i4] = z;
                                    }
                                });
                                builder.setPositiveButton(cnb.z(-558354338413354L), new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.djr
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i4) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
                                        ArrayList arrayList4 = new ArrayList();
                                        int i5 = 0;
                                        ListIterator listIterator3 = bvzVar.listIterator(0);
                                        while (true) {
                                            bvx bvxVar3 = (bvx) listIterator3;
                                            if (!bvxVar3.hasNext()) {
                                                ArrayList arrayList5 = new ArrayList(abb.ak(arrayList4, 10));
                                                Iterator it = arrayList4.iterator();
                                                while (it.hasNext()) {
                                                    arrayList5.add(((djs) it.next()).a);
                                                }
                                                Set setAd = aaz.ad(arrayList5);
                                                dju.a.t(setAd);
                                                djpVar.invoke(setAd);
                                                return;
                                            }
                                            Object next = bvxVar3.next();
                                            int i6 = i5 + 1;
                                            if (i5 < 0) {
                                                aba.aj();
                                                throw null;
                                            }
                                            if (zArrV[i5]) {
                                                arrayList4.add(next);
                                            }
                                            i5 = i6;
                                        }
                                    }
                                });
                                builder.setNegativeButton(cnb.z(-558358633380650L), (DialogInterface.OnClickListener) null);
                                builder.show();
                                return Boolean.TRUE;
                            }
                            arrayList3.add(Boolean.valueOf(dju.a.n().contains(((djs) bvxVar2.next()).a)));
                        }
                    }
                }
                break;
            default:
                djv.a.getClass();
                View viewV = cnh.v(activity, cnb.ac(ewh.q) ? cnb.z(-558380108217130L) : cnb.ac(ewh.o) ? cnb.z(-558328568609578L) : cnb.ac(ewh.n) ? cnb.z(-558345748478762L) : cnb.ac(ewh.m) ? cnb.z(-558294208871210L) : cnb.ac(ewh.l) ? cnb.z(-558311388740394L) : cnb.ac(ewh.k) ? cnb.z(-557710093318954L) : cnb.ac(ewh.j) ? cnb.z(-557727273188138L) : cnb.ac(ewh.i) ? cnb.z(-557675733580586L) : cnb.ac(ewh.h) ? cnb.z(-557692913449770L) : cnb.ac(ewh.g) ? cnb.z(-557641373842218L) : cnb.ac(ewh.f) ? cnb.z(-557658553711402L) : cnb.ac(ewh.e) ? cnb.z(-557607014103850L) : cnb.ac(ewh.d) ? cnb.z(-557624193973034L) : cnb.ac(ewh.c) ? cnb.z(-557572654365482L) : cnb.ac(ewh.b) ? cnb.z(-557589834234666L) : cnb.ac(ewh.a) ? cnb.z(-557538294627114L) : cnb.ab(ewk.c) ? cnb.z(-557555474496298L) : cnb.z(-557503934888746L));
                bzo.n(viewV);
                ViewGroup viewGroup = (ViewGroup) viewV;
                int i4 = bte.a;
                cde cdeVarT = dqc.bi(viewGroup).t();
                Class cls = Integer.TYPE;
                ((cdk) dkz.n(new Object[]{dal.b(cls), dal.b(cls), dal.b(cls)}, 3, cdeVarT)).e(0, 0, 0);
                cde cdeVarT2 = dqc.bi(viewGroup).t();
                cdeVarT2.ab = cnb.z(-555992106400554L);
                Object objE2 = ((cdk) dkz.m(cdeVarT2)).e(new Object[0]);
                bzo.n(objE2);
                azg azgVarR3 = dqc.bi(objE2).r();
                azgVarR3.a = cnb.z(-555962041629482L);
                Object objD = ((azk) yg.e(azgVarR3)).d();
                bzo.n(objD);
                Method methodBb2 = emn.bb(djt.a);
                if (methodBb2.getParameterCount() == 4) {
                    methodBb2.invoke(null, objD, null, 1, null);
                } else {
                    methodBb2.invoke(objD, null);
                }
                return ens.a;
        }
    }
}
