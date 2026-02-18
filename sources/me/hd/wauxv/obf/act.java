package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class act implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ act(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Class cls3;
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Class cls4;
        Class cls5;
        Class cls6;
        int i = this.a;
        int i2 = 8;
        cls = Activity.class;
        int i3 = 4;
        int i4 = 3;
        cls2 = Boolean.class;
        cls3 = String.class;
        int i5 = 1;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                ((amm) obj).b = new act(i5);
                return ensVar;
            case 1:
                bag bagVar = (bag) obj;
                String[] strArr = {cnb.z(-385584983964458L)};
                bagVar.getClass();
                bagVar.a = la.ab(strArr);
                zb zbVar = new zb();
                zbVar.k(cnb.z(-385469019847466L), cnb.z(-385919991413546L));
                bagVar.b = zbVar;
                return ensVar;
            case 2:
                ((amm) obj).c = new act(i4);
                return ensVar;
            case 3:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t(cnb.z(-109113644153642L), cnb.z(-109001975003946L), cnb.z(-108933255527210L), cnb.z(-109375637158698L), cnb.z(-109328392518442L), cnb.z(-109216723368746L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 4:
                ((amm) obj).b = new act(5);
                return ensVar;
            case 5:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                azl azlVar = new azl();
                Class<String> clsBf = cnf.bf(dal.b(cls3));
                if (clsBf == null) {
                    clsBf = cls3;
                }
                azlVar.f(clsBf);
                Class<String> clsBf2 = cnf.bf(dal.b(cls3));
                azlVar.f(clsBf2 != null ? clsBf2 : String.class);
                azlVar.d = new bqh(2);
                zbVar2.e = azlVar;
                fj fjVar = new fj();
                cdj cdjVar2 = new cdj();
                cdjVar2.s(cnb.z(-103521596734250L));
                fjVar.f(cdjVar2);
                cdj cdjVar3 = new cdj();
                cdjVar3.s(cnb.z(-103457172224810L));
                fjVar.f(cdjVar3);
                cdj cdjVar4 = new cdj();
                fj fjVar2 = new fj();
                cdj cdjVar5 = new cdj();
                cdjVar5.t(cnb.z(-103392747715370L), cnb.z(-103865194117930L));
                fjVar2.f(cdjVar5);
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-103736345099050L), cnb.z(-105218108816170L));
                fjVar2.f(cdjVar6);
                cdjVar4.j = fjVar2;
                fjVar.f(cdjVar4);
                zbVar2.f = fjVar;
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return ensVar;
            case 6:
                ((amm) obj).c = new act(i2);
                return ensVar;
            case 7:
                ((amm) obj).b = new act(9);
                return ensVar;
            case 8:
                bah bahVar2 = (bah) obj;
                String[] strArr2 = {cnb.z(-360983411292970L)};
                bahVar2.getClass();
                bahVar2.a = la.ab(strArr2);
                cdj cdjVar7 = new cdj();
                cdjVar7.t(cnb.z(-362516714617642L), cnb.z(-362332031023914L));
                bahVar2.d = cdjVar7;
                return ensVar;
            case 9:
                bag bagVar3 = (bag) obj;
                zb zbVar3 = new zb();
                azl azlVar2 = new azl();
                aeg.a.getClass();
                aee aeeVar = aee.a;
                azlVar2.f(emn.bb(aeeVar).getDeclaringClass());
                zbVar3.e = azlVar2;
                fj fjVar3 = new fj();
                cdj cdjVar8 = new cdj();
                cdj.m(cdjVar8, 8);
                cdjVar8.r(emn.bb(aeeVar).getDeclaringClass());
                fj fjVar4 = new fj(i3);
                fjVar4.b = aaz.ab(avd.a);
                cdjVar8.f = fjVar4;
                fjVar3.f(cdjVar8);
                zbVar3.f = fjVar3;
                bagVar3.getClass();
                bagVar3.b = zbVar3;
                return ensVar;
            case 10:
                ((amm) obj).c = new act(14);
                return ensVar;
            case 11:
                ((amm) obj).c = new act(13);
                return ensVar;
            case 12:
                ((amm) obj).c = new act(15);
                return ensVar;
            case 13:
                bah bahVar3 = (bah) obj;
                cdj cdjVar9 = new cdj();
                aeg.a.getClass();
                cdjVar9.o(emn.bb(aee.a).getDeclaringClass());
                cdjVar9.t(cnb.z(-386474042194730L), cnb.z(-386289358601002L), cnb.z(-383381665741610L));
                bahVar3.getClass();
                bahVar3.d = cdjVar9;
                return ensVar;
            case 14:
                bah bahVar4 = (bah) obj;
                String[] strArr3 = {cnb.z(-386830524480298L)};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr3);
                cdj cdjVar10 = new cdj();
                cdjVar10.t(cnb.z(-386783279840042L), cnb.z(-386048840432426L));
                bahVar4.d = cdjVar10;
                return ensVar;
            case 15:
                bah bahVar5 = (bah) obj;
                cdj cdjVar11 = new cdj();
                aeg.a.getClass();
                cdjVar11.o(emn.bb(aee.a).getDeclaringClass());
                cdjVar11.t(cnb.z(-383574939269930L), cnb.z(-382892039469866L));
                bahVar5.getClass();
                bahVar5.d = cdjVar11;
                return ensVar;
            case 16:
                return Boolean.FALSE;
            case 17:
                ((amm) obj).b = new act(20);
                return ensVar;
            case 18:
                ((amm) obj).c = new act(19);
                return ensVar;
            case 19:
                bah bahVar6 = (bah) obj;
                cdj cdjVar12 = new cdj();
                aeo.a.getClass();
                cdjVar12.o(emn.az(aem.a));
                Class<String> clsBf3 = cnf.bf(dal.b(cls3));
                cls3 = clsBf3 != null ? clsBf3 : String.class;
                Class<Boolean> clsBf4 = cnf.bf(dal.b(cls2));
                cdjVar12.q(cls3, clsBf4 != null ? clsBf4 : Boolean.class);
                cdjVar12.t(cnb.z(-384309378677546L));
                bahVar6.getClass();
                bahVar6.d = cdjVar12;
                return ensVar;
            case 20:
                bag bagVar4 = (bag) obj;
                String[] strArr4 = {cnb.z(-384549896846122L)};
                bagVar4.getClass();
                bagVar4.a = la.ab(strArr4);
                zb zbVar4 = new zb();
                zbVar4.k(cnb.z(-384451112598314L));
                bagVar4.b = zbVar4;
                return ensVar;
            case 21:
                Object objE = ((bmm) obj).e();
                Activity activity = (Activity) (objE instanceof Activity ? objE : null);
                if (activity == null) {
                    Class<Activity> clsBf5 = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf5 != null ? clsBf5 : Activity.class).getName()).toString());
                }
                int i6 = bte.a;
                cde cdeVarT = dqc.bi(activity).t();
                cdeVarT.ab = cnb.z(-37649683315498L);
                Object objJ = ((cdk) dkz.m(cdeVarT)).j(new Object[0]);
                bzo.n(objJ);
                BaseAdapter baseAdapter = (BaseAdapter) objJ;
                for (bnd bndVar : aeq.b) {
                    try {
                        for (aep aepVar : bndVar.a(activity)) {
                            cnb.m(baseAdapter, aepVar.b, aepVar.c);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cnb.z(-37529424231210L));
                        ewq.e(yg.n(sb, bndVar instanceof doo ? ((doo) bndVar).f() : cnb.z(-37512244362026L), -37473589656362L), e, 12);
                    }
                }
                return ensVar;
            case 22:
                bmm bmmVar = (bmm) obj;
                Object objE2 = bmmVar.e();
                if (!(objE2 instanceof Activity)) {
                    objE2 = null;
                }
                Activity activity2 = (Activity) objE2;
                if (activity2 == null) {
                    Class<Activity> clsBf6 = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf6 != null ? clsBf6 : Activity.class).getName()).toString());
                }
                try {
                    objX = bmmVar.d()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Object obj2 = objX instanceof dcx ? null : objX;
                bzo.n(obj2);
                int i7 = bte.a;
                azg azgVarR = dqc.bi(obj2).r();
                azgVarR.a = dal.b(cls3);
                azgVarR.ah();
                Iterator it = azgVarR.c().iterator();
                while (it.hasNext()) {
                    String str = (String) ((azk) it.next()).e();
                    if (str != null) {
                        for (bnd bndVar2 : aeq.b) {
                            try {
                                for (aep aepVar2 : bndVar2.a(activity2)) {
                                    if (str.equals(aepVar2.a)) {
                                        aepVar2.d.invoke(activity2);
                                        bmmVar.g();
                                    }
                                }
                            } catch (Exception e2) {
                                ArrayList arrayList2 = ewq.a;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(cnb.z(-37439229917994L));
                                ewq.e(yg.n(sb2, bndVar2 instanceof doo ? ((doo) bndVar2).f() : cnb.z(-37903086385962L), -37881611549482L), e2, 12);
                            }
                        }
                    }
                }
                return ensVar;
            case 23:
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                try {
                    objX2 = bmmVar2.d()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                try {
                    objX3 = bmmVar2.d()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                if (objX3 instanceof dcx) {
                    objX3 = null;
                }
                bzo.n(objX3);
                CharSequence charSequence = (CharSequence) objX3;
                try {
                    objX4 = bmmVar2.d()[2];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                if (objX4 instanceof dcx) {
                    objX4 = null;
                }
                try {
                    objX5 = bmmVar2.d()[3];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                if (objX5 instanceof dcx) {
                    objX5 = null;
                }
                try {
                    objX6 = bmmVar2.d()[4];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                Boolean bool = (Boolean) (objX6 instanceof dcx ? null : objX6);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                for (Object obj3 : afu.b) {
                    try {
                        ((gx) obj3).i(bmmVar2, charSequence, zBooleanValue);
                    } catch (Exception e3) {
                        ArrayList arrayList3 = ewq.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cnb.z(-39286065855274L));
                        ewq.e(yg.n(sb3, obj3 instanceof doo ? ((doo) obj3).f() : cnb.z(-39152921869098L), -39114267163434L), e3, 12);
                    }
                }
                return ensVar;
            case 24:
                ((amm) obj).c = new act(25);
                return ensVar;
            case 25:
                bah bahVar7 = (bah) obj;
                cdj cdjVar13 = new cdj();
                cls4 = MenuItem.class;
                Class<MenuItem> clsBf7 = cnf.bf(dal.b(cls4));
                cdjVar13.r(clsBf7 != null ? clsBf7 : MenuItem.class);
                cls5 = Integer.class;
                Class<Integer> clsBf8 = cnf.bf(dal.b(cls5));
                if (clsBf8 == null) {
                    clsBf8 = cls5;
                }
                cls6 = CharSequence.class;
                Class<CharSequence> clsBf9 = cnf.bf(dal.b(cls6));
                cls6 = clsBf9 != null ? clsBf9 : CharSequence.class;
                Class<Integer> clsBf10 = cnf.bf(dal.b(cls5));
                if (clsBf10 == null) {
                    clsBf10 = cls5;
                }
                Class<Integer> clsBf11 = cnf.bf(dal.b(cls5));
                cls5 = clsBf11 != null ? clsBf11 : Integer.class;
                Class<Boolean> clsBf12 = cnf.bf(dal.b(cls2));
                cdjVar13.q(clsBf8, cls6, clsBf10, cls5, clsBf12 != null ? clsBf12 : Boolean.class);
                bahVar7.getClass();
                bahVar7.d = cdjVar13;
                return ensVar;
            case 26:
                ((amm) obj).c = new act(27);
                return ensVar;
            case 27:
                bah bahVar8 = (bah) obj;
                String[] strArr5 = {cnb.z(-106210246261546L)};
                bahVar8.getClass();
                bahVar8.a = la.ab(strArr5);
                cdj cdjVar14 = new cdj();
                cdjVar14.t(cnb.z(-106626858089258L), cnb.z(-106583908416298L));
                bahVar8.d = cdjVar14;
                return ensVar;
            case 28:
                ((amm) obj).c = new act(29);
                return ensVar;
            default:
                bah bahVar9 = (bah) obj;
                String[] strArr6 = {cnb.z(-78988743539498L)};
                bahVar9.getClass();
                bahVar9.a = la.ab(strArr6);
                cdj cdjVar15 = new cdj();
                cdjVar15.t(cnb.z(-78340203477802L), cnb.z(-78207059491626L), cnb.z(-78202764524330L));
                bahVar9.d = cdjVar15;
                return ensVar;
        }
    }
}
