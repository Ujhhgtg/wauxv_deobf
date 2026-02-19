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
                final bvz bvzVar = new bv"[DECRYPT_ERROR: string index out of range]" /* z(10) */;
                String strZ = "default" /* "default" /* "default" /* "default" /* cnb.z(-556073710779178L)   */;
                String strZ2 = "默认" /* "默认" /* "默认" /* "默认" /* cnb.z(-556039351040810L)   */;
                djs djsVar = new djs();
                djsVar.a = "" /* "" /* "" /* "" /* cnb.z(-556370063522602L)   */;
                "" /* "" /* "" /* "" /* cnb.z(-556365768555306L)   */;
                djsVar.a = strZ;
                djsVar.b = strZ2;
                bvzVar.add(djsVar);
                aeg.a.getClass();
                Method methodBb = emn.bb(aed.a);
                aec.a.getClass();
                Object objInvoke = methodBb.invoke(aec.b(), null);
                throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>" /* "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>" /* "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>" /* "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>" /* cnb.z(-386645840886570L)   */);
                List list = (List) objInvoke;
                ArrayList arrayList = new ArrayList(abb.ak(list, 10));
                for (Object obj2 : list) {
                    djs djsVar2 = new djs();
                    djsVar2.a = "" /* "" /* "" /* "" /* cnb.z(-556378653457194L)   */;
                    djsVar2.b = "" /* "" /* "" /* "" /* cnb.z(-556374358489898L)   */;
                    int i3 = 0;
                    azg azgVarR = dqc.bi(obj2).r();
                    azgVarR.ab = "field_labelID" /* "field_labelID" /* "field_labelID" /* "field_labelID" /* cnb.z(-556387243391786L)   */;
                    djsVar2.a = String.valueOf(((azk) yg.e(azgVarR)).e());
                    azg azgVarR2 = dqc.bi(obj2).r();
                    azgVarR2.ab = "field_labelName" /* "field_labelName" /* "field_labelName" /* "field_labelName" /* cnb.z(-556859689794346L)   */;
                    Object objE = ((azk) yg.e(azgVarR2)).e();
                    throwIfVar1IsNull(objE);
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
                        if (!str.equals("default" /* "default" /* "default" /* "default" /* cnb.z(-558470302530346L)   */)) {
                            StringBuilder sbY = dkz.y(string);
                            sbY.append(" [" /* " [" /* " [" /* " [" /* cnb.z(-558435942791978L)   */);
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
                                builder.setTitle("请选择过滤标签" /* "请选择过滤标签" /* "请选择过滤标签" /* "请选择过滤标签" /* cnb.z(-558388698151722L)   */);
                                builder.setMultiChoiceItems(strArr, zArrV, new DialogInterface.OnMultiChoiceClickListener() { // from class: me.hd.wauxv.obf.djq
                                    @Override // android.content.DialogInterface.OnMultiChoiceClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i4, boolean z) {
                                        zArrV[i4] = z;
                                    }
                                });
                                builder.setPositiveButton("确定" /* "确定" /* "确定" /* "确定" /* cnb.z(-558354338413354L)   */, new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.djr
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
                                                OtherStaticHelpers.aj();
                                                throw null;
                                            }
                                            if (zArrV[i5]) {
                                                arrayList4.add(next);
                                            }
                                            i5 = i6;
                                        }
                                    }
                                });
                                builder.setNegativeButton("取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-558358633380650L)   */, (DialogInterface.OnClickListener) null);
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
                View viewV = cnh.v(activity, cnb.ac(ewh.q) ? "j90" /* "j90" /* "j90" /* "j90" /* cnb.z(-558380108217130L)   */ : cnb.ac(ewh.o) ? "j44" /* "j44" /* "j44" /* "j44" /* cnb.z(-558328568609578L)   */ : cnb.ac(ewh.n) ? "j17" /* "j17" /* "j17" /* "j17" /* cnb.z(-558345748478762L)   */ : cnb.ac(ewh.m) ? "j0_" /* "j0_" /* "j0_" /* "j0_" /* cnb.z(-558294208871210L)   */ : cnb.ac(ewh.l) ? "iw_" /* "iw_" /* "iw_" /* "iw_" /* cnb.z(-558311388740394L)   */ : cnb.ac(ewh.k) ? "ite" /* "ite" /* "ite" /* "ite" /* cnb.z(-557710093318954L)   */ : cnb.ac(ewh.j) ? "irm" /* "irm" /* "irm" /* "irm" /* cnb.z(-557727273188138L)   */ : cnb.ac(ewh.i) ? "iok" /* "iok" /* "iok" /* "iok" /* cnb.z(-557675733580586L)   */ : cnb.ac(ewh.h) ? "im3" /* "im3" /* "im3" /* "im3" /* cnb.z(-557692913449770L)   */ : cnb.ac(ewh.g) ? "iir" /* "iir" /* "iir" /* "iir" /* cnb.z(-557641373842218L)   */ : cnb.ac(ewh.f) ? "ifd" /* "ifd" /* "ifd" /* "ifd" /* cnb.z(-557658553711402L)   */ : cnb.ac(ewh.e) ? "i0z" /* "i0z" /* "i0z" /* "i0z" /* cnb.z(-557607014103850L)   */ : cnb.ac(ewh.d) ? "hzd" /* "hzd" /* "hzd" /* "hzd" /* cnb.z(-557624193973034L)   */ : cnb.ac(ewh.c) ? "hk5" /* "hk5" /* "hk5" /* "hk5" /* cnb.z(-557572654365482L)   */ : cnb.ac(ewh.b) ? "h1_" /* "h1_" /* "h1_" /* "h1_" /* cnb.z(-557589834234666L)   */ : cnb.ac(ewh.a) ? "gmh" /* "gmh" /* "gmh" /* "gmh" /* cnb.z(-557538294627114L)   */ : cnb.ab(ewk.c) ? "hbs" /* "hbs" /* "hbs" /* "hbs" /* cnb.z(-557555474496298L)   */ : "oez" /* "oez" /* "oez" /* "oez" /* cnb.z(-557503934888746L)   */);
                throwIfVar1IsNull(viewV);
                ViewGroup viewGroup = (ViewGroup) viewV;
                int i4 = 0;
                cde cdeVarT = dqc.bi(viewGroup).t();
                Class cls = Integer.TYPE;
                ((MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(cls), dal.b(cls)}, 3, cdeVarT)).e(0, 0, 0);
                cde cdeVarT2 = dqc.bi(viewGroup).t();
                cdeVarT2.ab = "getAdapter" /* "getAdapter" /* "getAdapter" /* "getAdapter" /* cnb.z(-555992106400554L)   */;
                Object objE2 = ((MethodHookWrapper) dkz.m(cdeVarT2)).e(new Object[0]);
                throwIfVar1IsNull(objE2);
                azg azgVarR3 = dqc.bi(objE2).r();
                azgVarR3.a = "com.tencent.mm.plugin.mvvmlist.MvvmList" /* "com.tencent.mm.plugin.mvvmlist.MvvmList" /* "com.tencent.mm.plugin.mvvmlist.MvvmList" /* "com.tencent.mm.plugin.mvvmlist.MvvmList" /* cnb.z(-555962041629482L)   */;
                Object objD = ((azk) yg.e(azgVarR3)).d();
                throwIfVar1IsNull(objD);
                Method methodBb2 = emn.bb(djt.a);
                if (methodBb2.getParameterCount() == 4) {
                    methodBb2.invoke(null, objD, null, 1, null);
                } else {
                    methodBb2.invoke(objD, null);
                }
                return KotlinUnit.INSTANCE;
        }
    }
}
