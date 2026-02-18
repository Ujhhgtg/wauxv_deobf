package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ayz implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ ayz(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Object objX;
        Object objX2;
        Class cls;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        int i = this.a;
        int i2 = 4;
        int i3 = 10;
        int i4 = 1;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Object obj2 = objX instanceof dcx ? null : objX;
                bzo.n(obj2);
                MenuItem menuItem = (MenuItem) obj2;
                int i5 = bte.a;
                azg azgVarAa = dkz.aa(bmmVar);
                azgVarAa.a = dal.b(Integer.TYPE);
                Object objE = ((azk) aaz.e(azgVarAa.c())).e();
                bzo.n(objE);
                int iIntValue = ((Number) objE).intValue();
                azg azgVarAa2 = dkz.aa(bmmVar);
                azgVarAa2.ab = cnb.z(-39797166963498L);
                Object objD = ((azk) aaz.e(azgVarAa2.c())).d();
                bzo.n(objD);
                azg azgVarR = dqc.bi(objD).r();
                azgVarR.b = new ayz(i4);
                Object objE2 = ((azk) aaz.e(azgVarR.c())).e();
                bzo.n(objE2);
                Object item = ((BaseAdapter) objE2).getItem(iIntValue);
                for (bnk bnkVar : azd.b) {
                    try {
                        for (aza azaVar : ((cie) bnkVar).i()) {
                            int itemId = menuItem.getItemId();
                            azaVar.getClass();
                            if (itemId == R.id.MenuItem_Fav_Forward) {
                                azaVar.b.invoke(item);
                            }
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cnb.z(-39805756898090L));
                        ewq.e(yg.n(sb, bnkVar instanceof doo ? ((doo) bnkVar).f() : cnb.z(-39741332388650L), -39719857552170L), e, 12);
                    }
                }
                return ensVar;
            case 1:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(), cnb.z(-39685497813802L), false));
            case 2:
                ((amm) obj).c = new ayz(5);
                return ensVar;
            case 3:
                ((amm) obj).c = new ayz(i2);
                return ensVar;
            case 4:
                bah bahVar = (bah) obj;
                String[] strArr = {cnb.z(-41261750811434L)};
                bahVar.getClass();
                bahVar.a = la.ab(strArr);
                cdj cdjVar = new cdj();
                cdjVar.t(cnb.z(-41669772704554L), cnb.z(-41575283424042L));
                bahVar.d = cdjVar;
                return ensVar;
            case 5:
                bah bahVar2 = (bah) obj;
                String[] strArr2 = {cnb.z(-40054865001258L)};
                bahVar2.getClass();
                bahVar2.a = la.ab(strArr2);
                cdj cdjVar2 = new cdj();
                cdjVar2.t(cnb.z(-39895951211306L), cnb.z(-41450729372458L));
                bahVar2.d = cdjVar2;
                return ensVar;
            case 6:
                View view = (View) obj;
                cee ceeVarE = cee.e(LayoutInflater.from(view.getContext()));
                ceeVarE.c.setText(azq.a.o());
                bzy bzyVar = new bzy(view.getContext());
                azr.a.getClass();
                String str = azr.i;
                eg egVar = (eg) bzyVar.d;
                egVar.d = str;
                LinearLayout linearLayout = ceeVarE.b;
                bzyVar.t(cnb.z(-492121647741738L), new amw(new aul(ceeVarE, 1), 0));
                bzyVar.s(cnb.z(-492074403101482L), new amw(new amd(4), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return ensVar;
            case 7:
                amm ammVar = (amm) obj;
                ammVar.b = new ayz(9);
                ammVar.c = new ayz(i3);
                return ensVar;
            case 8:
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
                String str2 = (String) (objX2 instanceof dcx ? null : objX2);
                if (str2 == null) {
                    str2 = "";
                }
                if (str2.equals(cnb.z(-492078698068778L))) {
                    bmmVar2.h(azq.a.o());
                }
                return ensVar;
            case 9:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k(cnb.z(-492065813166890L), cnb.z(-492546849504042L));
                bagVar.getClass();
                bagVar.b = zbVar;
                return ensVar;
            case 10:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdj.m(cdjVar3, 8);
                cls = String.class;
                Class<String> clsBf = cnf.bf(dal.b(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cdjVar3.r(clsBf);
                Class<String> clsBf2 = cnf.bf(dal.b(cls));
                cdjVar3.q(clsBf2 != null ? clsBf2 : String.class);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 11:
                bmm bmmVar3 = (bmm) obj;
                bmmVar3.getClass();
                try {
                    objX3 = bmmVar3.d()[0];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                Object obj3 = objX3 instanceof dcx ? null : objX3;
                bzo.n(obj3);
                try {
                    objX4 = bmmVar3.d()[1];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                Object obj4 = objX4 instanceof dcx ? null : objX4;
                bzo.n(obj4);
                MenuItem menuItem2 = (MenuItem) obj4;
                int i6 = bte.a;
                azg azgVarR2 = dqc.bi(obj3).r();
                azgVarR2.a = cnb.z(-64540473555754L);
                Object objD2 = ((azk) yg.e(azgVarR2)).d();
                bzo.n(objD2);
                cde cdeVarT = dqc.bi(objD2).t();
                cdeVarT.ab = cnb.z(-64334315125546L);
                Object objJ = ((cdk) aaz.e(cdeVarT.aj())).j(new Object[0]);
                bzo.n(objJ);
                int iIntValue2 = ((Number) objJ).intValue();
                cde cdeVarT2 = dqc.bi(objD2).t();
                cdeVarT2.ab = cnb.z(-64811056495402L);
                Object objJ2 = ((cdk) aaz.e(cdeVarT2.aj())).j(new Object[0]);
                bzo.n(objJ2);
                List list = (List) objJ2;
                ArrayList arrayList2 = new ArrayList(abb.ak(list, 10));
                for (Object obj5 : list) {
                    int i7 = bte.a;
                    cde cdeVarT3 = dqc.bi(obj5).t();
                    cdeVarT3.ab = cnb.z(-64789581658922L);
                    Object objJ3 = ((cdk) dkz.m(cdeVarT3)).j(new Object[0]);
                    bzo.n(objJ3);
                    arrayList2.add((JSONObject) objJ3);
                }
                for (bnl bnlVar : bal.b) {
                    try {
                        for (bai baiVar : ((etg) bnlVar).m()) {
                            if (menuItem2.getItemId() == baiVar.a) {
                                baiVar.d.g(Integer.valueOf(iIntValue2), arrayList2);
                            }
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList3 = ewq.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(cnb.z(-64759516887850L));
                        ewq.e(yg.n(sb2, bnlVar instanceof doo ? ((doo) bnlVar).f() : cnb.z(-64695092378410L), -64604898065194L), e2, 12);
                    }
                }
                return ensVar;
            case 12:
                bmm bmmVar4 = (bmm) obj;
                bmmVar4.getClass();
                try {
                    objX5 = bmmVar4.d()[1];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                Object obj6 = objX5 instanceof dcx ? null : objX5;
                bzo.n(obj6);
                ContextMenu contextMenu = (ContextMenu) obj6;
                int i8 = bte.a;
                azg azgVarR3 = dqc.bi(contextMenu).r();
                azgVarR3.a = dal.b(Context.class);
                Object objE3 = ((azk) aaz.e(azgVarR3.c())).e();
                bzo.n(objE3);
                Resources resources = ((Context) objE3).getResources();
                if (resources != null) {
                    cnf.bi(resources);
                }
                dov dovVar = new dov(new ayu(contextMenu, 2));
                for (bnl bnlVar2 : bal.b) {
                    try {
                        for (bai baiVar2 : ((etg) bnlVar2).m()) {
                            cdk cdkVarD = ((cdk) dovVar.getValue()).d();
                            cdkVarD.h(contextMenu);
                            cdkVarD.e(Integer.valueOf(baiVar2.a), baiVar2.b, Integer.valueOf(baiVar2.c));
                        }
                    } catch (Exception e3) {
                        ArrayList arrayList4 = ewq.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cnb.z(-41089952119594L));
                        ewq.e(yg.n(sb3, bnlVar2 instanceof doo ? ((doo) bnlVar2).f() : cnb.z(-40973988002602L), -64574833294122L), e3, 12);
                    }
                }
                return ensVar;
            case 13:
                ((amm) obj).c = new ayz(15);
                return ensVar;
            case 14:
                amm ammVar2 = (amm) obj;
                ammVar2.b = new ayz(16);
                ammVar2.c = new ayz(17);
                return ensVar;
            case 15:
                bah bahVar4 = (bah) obj;
                String[] strArr3 = {cnb.z(-64020782512938L)};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr3);
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-63891933494058L), cnb.z(-63904818395946L), cnb.z(-63866163690282L), cnb.z(-63823214017322L), cnb.z(-63775969377066L));
                bahVar4.d = cdjVar4;
                return ensVar;
            case 16:
                bag bagVar2 = (bag) obj;
                String[] strArr4 = {cnb.z(-64287070485290L)};
                bagVar2.getClass();
                bagVar2.a = la.ab(strArr4);
                zb zbVar2 = new zb();
                zbVar2.k(cnb.z(-64089501989674L), cnb.z(-65584150608682L));
                bagVar2.b = zbVar2;
                return ensVar;
            case 17:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdjVar5.t(cnb.z(-65953517796138L));
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ensVar;
            case 18:
                bmm bmmVar5 = (bmm) obj;
                bmmVar5.getClass();
                try {
                    objX6 = bmmVar5.d()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                Object obj7 = objX6 instanceof dcx ? null : objX6;
                bzo.n(obj7);
                ContextMenu contextMenu2 = (ContextMenu) obj7;
                int i9 = bte.a;
                azg azgVarR4 = dqc.bi(contextMenu2).r();
                azgVarR4.a = dal.b(Context.class);
                Object objE4 = ((azk) aaz.e(azgVarR4.c())).e();
                bzo.n(objE4);
                Resources resources2 = ((Context) objE4).getResources();
                if (resources2 != null) {
                    cnf.bi(resources2);
                }
                dov dovVar2 = new dov(new ayu(contextMenu2, 3));
                for (bnm bnmVar : bap.b) {
                    try {
                        for (bam bamVar : ((ete) bnmVar).m()) {
                            cdk cdkVarD2 = ((cdk) dovVar2.getValue()).d();
                            cdkVarD2.h(contextMenu2);
                            cdkVarD2.e(Integer.valueOf(bamVar.a), bamVar.b, Integer.valueOf(bamVar.c));
                        }
                    } catch (Exception e4) {
                        ArrayList arrayList5 = ewq.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(cnb.z(-64914135710506L));
                        ewq.e(yg.n(sb4, bnmVar instanceof doo ? ((doo) bnmVar).f() : cnb.z(-65399467014954L), -65377992178474L), e4, 12);
                    }
                }
                return ensVar;
            case 19:
                bmm bmmVar6 = (bmm) obj;
                bmmVar6.getClass();
                try {
                    objX7 = bmmVar6.d()[0];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = bhu.x(th7);
                }
                Object obj8 = objX7 instanceof dcx ? null : objX7;
                bzo.n(obj8);
                MenuItem menuItem3 = (MenuItem) obj8;
                int i10 = bte.a;
                azg azgVarAa3 = dkz.aa(bmmVar6);
                azgVarAa3.a = cnb.z(-65343632440106L);
                Object objD3 = ((azk) aaz.e(azgVarAa3.c())).d();
                bzo.n(objD3);
                azg azgVarR5 = dqc.bi(objD3).r();
                azgVarR5.a = cnb.z(-62397284875050L);
                Object objD4 = ((azk) yg.e(azgVarR5)).d();
                bzo.n(objD4);
                cde cdeVarT4 = dqc.bi(objD4).t();
                cdeVarT4.ab = cnb.z(-62191126444842L);
                Object objJ4 = ((cdk) aaz.e(cdeVarT4.aj())).j(new Object[0]);
                bzo.n(objJ4);
                int iIntValue3 = ((Number) objJ4).intValue();
                cde cdeVarT5 = dqc.bi(objD4).t();
                cdeVarT5.ab = cnb.z(-62650687945514L);
                Object objJ5 = ((cdk) aaz.e(cdeVarT5.aj())).j(new Object[0]);
                bzo.n(objJ5);
                List list2 = (List) objJ5;
                ArrayList arrayList6 = new ArrayList(abb.ak(list2, 10));
                for (Object obj9 : list2) {
                    int i11 = bte.a;
                    cde cdeVarT6 = dqc.bi(obj9).t();
                    cdeVarT6.ab = cnb.z(-62577673501482L);
                    Object objJ6 = ((cdk) dkz.m(cdeVarT6)).j(new Object[0]);
                    bzo.n(objJ6);
                    arrayList6.add((JSONObject) objJ6);
                }
                for (bnm bnmVar2 : bap.b) {
                    try {
                        for (bam bamVar2 : ((ete) bnmVar2).m()) {
                            if (menuItem3.getItemId() == bamVar2.a) {
                                bamVar2.d.g(Integer.valueOf(iIntValue3), arrayList6);
                            }
                        }
                    } catch (Exception e5) {
                        ArrayList arrayList7 = ewq.a;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(cnb.z(-62599148337962L));
                        ewq.e(yg.n(sb5, bnmVar2 instanceof doo ? ((doo) bnmVar2).f() : cnb.z(-62483184220970L), -62444529515306L), e5, 12);
                    }
                }
                return ensVar;
            case 20:
                ((amm) obj).c = new ayz(23);
                return ensVar;
            case 21:
                ((amm) obj).c = new ayz(22);
                return ensVar;
            case 22:
                bah bahVar6 = (bah) obj;
                String[] strArr5 = {cnb.z(-61589831023402L)};
                bahVar6.getClass();
                bahVar6.a = la.ab(strArr5);
                cdj cdjVar6 = new cdj();
                cdjVar6.s(cnb.z(-62010737818410L));
                cdjVar6.t(cnb.z(-61886183766826L));
                bahVar6.d = cdjVar6;
                return ensVar;
            case 23:
                bah bahVar7 = (bah) obj;
                String[] strArr6 = {cnb.z(-62410169776938L)};
                bahVar7.getClass();
                bahVar7.a = la.ab(strArr6);
                cdj cdjVar7 = new cdj();
                cdjVar7.s(cnb.z(-61731564944170L));
                cdjVar7.t(cnb.z(-61667140434730L));
                bahVar7.d = cdjVar7;
                return ensVar;
            case 24:
                View view2 = (View) obj;
                View viewK = dkz.k(view2, R.layout.module_dialog_float_action_button, null, false);
                int i12 = R.id.moduleDialogEdtFloatActionButtonFabDarkColor;
                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtFloatActionButtonFabDarkColor);
                if (textInputEditText != null) {
                    i12 = R.id.moduleDialogEdtFloatActionButtonFabLightColor;
                    TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtFloatActionButtonFabLightColor);
                    if (textInputEditText2 != null) {
                        i12 = R.id.moduleDialogEdtFloatActionButtonIconDarkColor;
                        TextInputEditText textInputEditText3 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtFloatActionButtonIconDarkColor);
                        if (textInputEditText3 != null) {
                            i12 = R.id.moduleDialogEdtFloatActionButtonIconLightColor;
                            TextInputEditText textInputEditText4 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtFloatActionButtonIconLightColor);
                            if (textInputEditText4 != null) {
                                i12 = R.id.moduleDialogInputFloatActionButtonFabDarkColor;
                                if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputFloatActionButtonFabDarkColor)) != null) {
                                    i12 = R.id.moduleDialogInputFloatActionButtonFabLightColor;
                                    if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputFloatActionButtonFabLightColor)) != null) {
                                        i12 = R.id.moduleDialogInputFloatActionButtonIconDarkColor;
                                        if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputFloatActionButtonIconDarkColor)) != null) {
                                            i12 = R.id.moduleDialogInputFloatActionButtonIconLightColor;
                                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputFloatActionButtonIconLightColor)) != null) {
                                                LinearLayout linearLayout2 = (LinearLayout) viewK;
                                                ceo ceoVar = new ceo(linearLayout2, textInputEditText, textInputEditText2, textInputEditText3, textInputEditText4, 0);
                                                textInputEditText2.setText(bbg.a.o());
                                                textInputEditText4.setText(bbi.a.o());
                                                textInputEditText.setText(bbf.a.o());
                                                textInputEditText3.setText(bbh.a.o());
                                                bzy bzyVar2 = new bzy(view2.getContext());
                                                eg egVar2 = (eg) bzyVar2.d;
                                                bbj.a.getClass();
                                                egVar2.d = bbj.j;
                                                bzyVar2.t(cnb.z(-550395764013866L), new amw(new bp(ceoVar, 20), 0));
                                                bzyVar2.s(cnb.z(-550348519373610L), new amw(new amd(6), 2));
                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                                                if (linearLayout2 != null) {
                                                    egVar2.r = linearLayout2;
                                                }
                                                bzyVar2.i().show();
                                                return ensVar;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-638850615474986L).concat(viewK.getResources().getResourceName(i12)));
            case 25:
                ((amm) obj).c = new ayz(27);
                return ensVar;
            case 26:
                ((amm) obj).c = new ayz(28);
                return ensVar;
            case 27:
                bah bahVar8 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t(cnb.z(-367876833803050L), cnb.z(-368271970794282L));
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return ensVar;
            case 28:
                bah bahVar9 = (bah) obj;
                cdj cdjVar9 = new cdj();
                bcp.a.getClass();
                cdjVar9.o(emn.bb(bcn.a).getDeclaringClass());
                cdjVar9.t(cnb.z(-368147416742698L), cnb.z(-367511761582890L));
                bahVar9.getClass();
                bahVar9.d = cdjVar9;
                return ensVar;
            default:
                View view3 = (View) obj;
                View viewK2 = dkz.k(view3, R.layout.module_dialog_format_msg_time, null, false);
                int i13 = R.id.moduleDialogEdtFormatMsgTimeTimeFormat;
                TextInputEditText textInputEditText5 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtFormatMsgTimeTimeFormat);
                if (textInputEditText5 != null) {
                    i13 = R.id.moduleDialogInputFormatMsgTimeTimeFormat;
                    if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputFormatMsgTimeTimeFormat)) != null) {
                        i13 = R.id.moduleDialogRbFormatMsgTimeModeDefault;
                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) cnd.aq(viewK2, R.id.moduleDialogRbFormatMsgTimeModeDefault);
                        if (materialRadioButton != null) {
                            i13 = R.id.moduleDialogRbFormatMsgTimeModeGone;
                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) cnd.aq(viewK2, R.id.moduleDialogRbFormatMsgTimeModeGone);
                            if (materialRadioButton2 != null) {
                                i13 = R.id.moduleDialogRbFormatMsgTimeModeVisible;
                                MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) cnd.aq(viewK2, R.id.moduleDialogRbFormatMsgTimeModeVisible);
                                if (materialRadioButton3 != null) {
                                    i13 = R.id.moduleDialogRgFormatMsgTimeMode;
                                    if (((RadioGroup) cnd.aq(viewK2, R.id.moduleDialogRgFormatMsgTimeMode)) != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) viewK2;
                                        bqs bqsVar = new bqs(linearLayout3, textInputEditText5, materialRadioButton, materialRadioButton2, materialRadioButton3, 2);
                                        int iK = bcs.a.k();
                                        if (iK == bcr.a.e) {
                                            materialRadioButton2.setChecked(true);
                                        } else if (iK == bcr.b.e) {
                                            materialRadioButton.setChecked(true);
                                        } else if (iK == bcr.c.e) {
                                            materialRadioButton3.setChecked(true);
                                        }
                                        textInputEditText5.setText(bct.a.o());
                                        bzy bzyVar3 = new bzy(view3.getContext());
                                        eg egVar3 = (eg) bzyVar3.d;
                                        bcu.a.getClass();
                                        egVar3.d = bcu.c;
                                        bzyVar3.t(cnb.z(-463688964242218L), new amw(new bp(bqsVar, 21), 0));
                                        bzyVar3.s(cnb.z(-463710439078698L), new amw(new amd(7), 2));
                                        bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3, cnb.z(-47455093652266L));
                                        if (linearLayout3 != null) {
                                            egVar3.r = linearLayout3;
                                        }
                                        bzyVar3.i().show();
                                        return ensVar;
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-639262932335402L).concat(viewK2.getResources().getResourceName(i13)));
        }
    }
}
