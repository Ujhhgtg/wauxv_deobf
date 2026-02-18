package me.hd.wauxv.obf;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;
import me.hd.wauxv.data.bean.MsgInfoBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cvc implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ cvc(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, JSONException, InvocationTargetException {
        Class cls;
        Object objX;
        Object obj2;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        Object objX8;
        Object objX9;
        Object objX10;
        Object objX11;
        Object objX12;
        Object objX13;
        Object objX14;
        Object objX15;
        Object objX16;
        Object objX17;
        Object objX18;
        Object objX19;
        Object objX20;
        Object objX21;
        Object objX22;
        Class cls2;
        Object objX23;
        Object objX24;
        Object objX25;
        Class cls3;
        Object objX26;
        Object objX27;
        int i = this.a;
        int i2 = 3;
        int i3 = 9;
        cls = String.class;
        Class cls4 = Integer.TYPE;
        int i4 = 4;
        int i5 = 0;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.o(cvh.a.b());
                Class<String> clsBf = cnf.bf(dal.b(cls));
                cdjVar.q(clsBf != null ? clsBf : String.class);
                cdjVar.t(cnb.z(-101232379165482L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 1:
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[2];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                obj2 = objX instanceof dcx ? null : objX;
                bzo.n(obj2);
                KeyEvent keyEvent = (KeyEvent) obj2;
                if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0) {
                    int i6 = bte.a;
                    azg azgVarAa = dkz.aa(bmmVar);
                    azgVarAa.b = new cvc(i2);
                    Object objD = ((azk) aaz.e(azgVarAa.c())).d();
                    bzo.n(objD);
                    azg azgVarR = dqc.bi(objD).r();
                    uq.a.getClass();
                    azgVarR.a = ajn.ag(cnb.z(-75127567940394L));
                    Object objE = ((azk) aaz.e(azgVarR.c())).e();
                    bzo.n(objE);
                    FrameLayout frameLayout = (FrameLayout) objE;
                    cde cdeVarT = dqc.bi(frameLayout).t();
                    cdeVarT.ab = cnb.z(-76622216559402L);
                    Object objJ = ((cdk) aaz.e(cdeVarT.aj())).j(new Object[0]);
                    bzo.n(objJ);
                    cde cdeVarT2 = dqc.bi(frameLayout).t();
                    cdeVarT2.ab = cnb.z(-76536317213482L);
                    Object objJ2 = ((cdk) aaz.e(cdeVarT2.aj())).j(new Object[0]);
                    bzo.n(objJ2);
                    long jLongValue = ((Number) objJ2).longValue();
                    if (((String) objJ).length() == 0 && jLongValue != 0) {
                        emn.bb(up.a).invoke(frameLayout, Boolean.FALSE, Boolean.TRUE);
                    }
                }
                return ensVar;
            case 2:
                ((amm) obj).c = new cvc(i4);
                return ensVar;
            case 3:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(), cnb.z(-472016905829162L), false));
            case 4:
                bah bahVar2 = (bah) obj;
                String[] strArr = {cnb.z(-460343184718634L)};
                bahVar2.getClass();
                bahVar2.a = la.ab(strArr);
                cdj cdjVar2 = new cdj();
                cdjVar2.s(cnb.z(-460201450797866L));
                cdjVar2.t(cnb.z(-460158501124906L), cnb.z(-460661012298538L));
                bahVar2.d = cdjVar2;
                return ensVar;
            case 5:
                ewz.aq(cxb.b, new cwz((ConversationBean) obj, i5));
                return ensVar;
            case 6:
                bmm bmmVar2 = (bmm) obj;
                if (cnb.ab(ewk.j) || cnb.ac(ewh.j)) {
                    bmmVar2.getClass();
                    try {
                        objX2 = bmmVar2.d()[0];
                        if (objX2 == null) {
                            objX2 = null;
                        }
                    } catch (Throwable th2) {
                        objX2 = bhu.x(th2);
                    }
                    Object obj3 = objX2 instanceof dcx ? null : objX2;
                    try {
                        objX3 = bmmVar2.d()[2];
                        if (objX3 == null) {
                            objX3 = null;
                        }
                    } catch (Throwable th3) {
                        objX3 = bhu.x(th3);
                    }
                    Object obj4 = objX3 instanceof dcx ? null : objX3;
                    try {
                        objX4 = bmmVar2.d()[3];
                        if (objX4 == null) {
                            objX4 = null;
                        }
                    } catch (Throwable th4) {
                        objX4 = bhu.x(th4);
                    }
                    if (objX4 instanceof dcx) {
                        objX4 = null;
                    }
                    bzo.n(objX4);
                    View view = (View) objX4;
                    try {
                        objX5 = bmmVar2.d()[4];
                        if (objX5 == null) {
                            objX5 = null;
                        }
                    } catch (Throwable th5) {
                        objX5 = bhu.x(th5);
                    }
                    if (objX5 instanceof dcx) {
                        objX5 = null;
                    }
                    bzo.n(objX5);
                    long jLongValue2 = ((Number) objX5).longValue();
                    try {
                        objX6 = bmmVar2.d()[5];
                        if (objX6 == null) {
                            objX6 = null;
                        }
                    } catch (Throwable th6) {
                        objX6 = bhu.x(th6);
                    }
                    if (objX6 instanceof dcx) {
                        objX6 = null;
                    }
                    bzo.n(objX6);
                    String str = (String) objX6;
                    try {
                        objX7 = bmmVar2.d()[6];
                        if (objX7 == null) {
                            objX7 = null;
                        }
                    } catch (Throwable th7) {
                        objX7 = bhu.x(th7);
                    }
                    Object obj5 = objX7 instanceof dcx ? null : objX7;
                    cgy.a.getClass();
                    emn.bb(cxf.a).invoke(null, obj3, obj4, cgy.b(jLongValue2), view, Long.valueOf(jLongValue2), str, obj5);
                    bmmVar2.h(null);
                } else if (cnb.ab(ewk.g) || cnb.ac(ewh.f)) {
                    bmmVar2.getClass();
                    try {
                        objX8 = bmmVar2.d()[0];
                        if (objX8 == null) {
                            objX8 = null;
                        }
                    } catch (Throwable th8) {
                        objX8 = bhu.x(th8);
                    }
                    Object obj6 = objX8 instanceof dcx ? null : objX8;
                    try {
                        objX9 = bmmVar2.d()[2];
                        if (objX9 == null) {
                            objX9 = null;
                        }
                    } catch (Throwable th9) {
                        objX9 = bhu.x(th9);
                    }
                    Object obj7 = objX9 instanceof dcx ? null : objX9;
                    try {
                        objX10 = bmmVar2.d()[3];
                        if (objX10 == null) {
                            objX10 = null;
                        }
                    } catch (Throwable th10) {
                        objX10 = bhu.x(th10);
                    }
                    if (objX10 instanceof dcx) {
                        objX10 = null;
                    }
                    bzo.n(objX10);
                    View view2 = (View) objX10;
                    try {
                        objX11 = bmmVar2.d()[4];
                        if (objX11 == null) {
                            objX11 = null;
                        }
                    } catch (Throwable th11) {
                        objX11 = bhu.x(th11);
                    }
                    if (objX11 instanceof dcx) {
                        objX11 = null;
                    }
                    bzo.n(objX11);
                    long jLongValue3 = ((Number) objX11).longValue();
                    try {
                        objX12 = bmmVar2.d()[5];
                        if (objX12 == null) {
                            objX12 = null;
                        }
                    } catch (Throwable th12) {
                        objX12 = bhu.x(th12);
                    }
                    if (objX12 instanceof dcx) {
                        objX12 = null;
                    }
                    bzo.n(objX12);
                    String str2 = (String) objX12;
                    try {
                        objX13 = bmmVar2.d()[6];
                        if (objX13 == null) {
                            objX13 = null;
                        }
                    } catch (Throwable th13) {
                        objX13 = bhu.x(th13);
                    }
                    Object obj8 = objX13 instanceof dcx ? null : objX13;
                    try {
                        objX14 = bmmVar2.d()[7];
                        if (objX14 == null) {
                            objX14 = null;
                        }
                    } catch (Throwable th14) {
                        objX14 = bhu.x(th14);
                    }
                    if (objX14 instanceof dcx) {
                        objX14 = null;
                    }
                    bzo.n(objX14);
                    cgy.a.getClass();
                    emn.bb(cxf.a).invoke(null, obj6, obj7, cgy.b(jLongValue3), view2, Long.valueOf(jLongValue3), str2, obj8, (Boolean) objX14);
                    bmmVar2.h(null);
                } else {
                    bmmVar2.getClass();
                    try {
                        objX15 = bmmVar2.d()[0];
                        if (objX15 == null) {
                            objX15 = null;
                        }
                    } catch (Throwable th15) {
                        objX15 = bhu.x(th15);
                    }
                    Object obj9 = objX15 instanceof dcx ? null : objX15;
                    try {
                        objX16 = bmmVar2.d()[2];
                        if (objX16 == null) {
                            objX16 = null;
                        }
                    } catch (Throwable th16) {
                        objX16 = bhu.x(th16);
                    }
                    Object obj10 = objX16 instanceof dcx ? null : objX16;
                    try {
                        objX17 = bmmVar2.d()[3];
                        if (objX17 == null) {
                            objX17 = null;
                        }
                    } catch (Throwable th17) {
                        objX17 = bhu.x(th17);
                    }
                    if (objX17 instanceof dcx) {
                        objX17 = null;
                    }
                    bzo.n(objX17);
                    View view3 = (View) objX17;
                    try {
                        objX18 = bmmVar2.d()[4];
                        if (objX18 == null) {
                            objX18 = null;
                        }
                    } catch (Throwable th18) {
                        objX18 = bhu.x(th18);
                    }
                    if (objX18 instanceof dcx) {
                        objX18 = null;
                    }
                    bzo.n(objX18);
                    long jLongValue4 = ((Number) objX18).longValue();
                    try {
                        objX19 = bmmVar2.d()[5];
                        if (objX19 == null) {
                            objX19 = null;
                        }
                    } catch (Throwable th19) {
                        objX19 = bhu.x(th19);
                    }
                    Object obj11 = objX19 instanceof dcx ? null : objX19;
                    try {
                        objX20 = bmmVar2.d()[6];
                        if (objX20 == null) {
                            objX20 = null;
                        }
                    } catch (Throwable th20) {
                        objX20 = bhu.x(th20);
                    }
                    if (objX20 instanceof dcx) {
                        objX20 = null;
                    }
                    bzo.n(objX20);
                    cgy.a.getClass();
                    emn.bb(cxf.a).invoke(null, obj9, obj10, cgy.b(jLongValue4), view3, Long.valueOf(jLongValue4), obj11, (Boolean) objX20);
                    bmmVar2.h(null);
                }
                return ensVar;
            case 7:
                ((amm) obj).c = new cvc(10);
                return ensVar;
            case 8:
                ((amm) obj).c = new cvc(i3);
                return ensVar;
            case 9:
                bah bahVar3 = (bah) obj;
                String[] strArr2 = {cnb.z(-461640264842026L)};
                bahVar3.getClass();
                bahVar3.a = la.ab(strArr2);
                cdj cdjVar3 = new cdj();
                cdjVar3.t(cnb.z(-460965954976554L), cnb.z(-460746911644458L));
                bahVar3.d = cdjVar3;
                return ensVar;
            case 10:
                bah bahVar4 = (bah) obj;
                String[] strArr3 = {cnb.z(-459956637661994L)};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr3);
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-461481351052074L), cnb.z(-461262307719978L));
                bahVar4.d = cdjVar4;
                return ensVar;
            case 11:
                View view4 = (View) obj;
                View viewK = dkz.k(view4, R.layout.module_dialog_quote_remind_msg, null, false);
                int i7 = R.id.moduleDialogEdtQuoteRemindMsgColor;
                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtQuoteRemindMsgColor);
                if (textInputEditText != null) {
                    i7 = R.id.moduleDialogEdtQuoteRemindMsgText;
                    TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtQuoteRemindMsgText);
                    if (textInputEditText2 != null) {
                        i7 = R.id.moduleDialogInputQuoteRemindMsgColor;
                        if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputQuoteRemindMsgColor)) != null) {
                            i7 = R.id.moduleDialogInputQuoteRemindMsgText;
                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputQuoteRemindMsgText)) != null) {
                                LinearLayout linearLayout = (LinearLayout) viewK;
                                cem cemVar = new cem(linearLayout, textInputEditText, textInputEditText2, 4);
                                textInputEditText2.setText(cxk.a.o());
                                textInputEditText.setText(cxj.a.o());
                                bzy bzyVar = new bzy(view4.getContext());
                                eg egVar = (eg) bzyVar.d;
                                cxl.a.getClass();
                                egVar.d = cxl.c;
                                bzyVar.t(cnb.z(-457641650289450L), new amw(new cfx(cemVar, 9), 0));
                                bzyVar.s(cnb.z(-457663125125930L), new amw(new cfh(21), 2));
                                if (linearLayout != null) {
                                    egVar.r = linearLayout;
                                }
                                bzyVar.i().show();
                                return ensVar;
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-663314749193002L).concat(viewK.getResources().getResourceName(i7)));
            case 12:
                bmm bmmVar3 = (bmm) obj;
                csm csmVar = (cnb.ab(ewk.n) || cnb.ac(ewh.q)) ? new csm(1, 5) : new csm(0, 4);
                int iIntValue = ((Number) csmVar.a).intValue();
                int iIntValue2 = ((Number) csmVar.b).intValue();
                bmmVar3.getClass();
                try {
                    objX21 = bmmVar3.d()[iIntValue];
                    if (objX21 == null) {
                        objX21 = null;
                    }
                } catch (Throwable th21) {
                    objX21 = bhu.x(th21);
                }
                if (objX21 instanceof dcx) {
                    objX21 = null;
                }
                bzo.n(objX21);
                int i8 = bte.a;
                azg azgVarR2 = dqc.bi(objX21).r();
                azgVarR2.ab = cnb.z(-457542866041642L);
                Object objE2 = ((azk) yg.e(azgVarR2)).e();
                bzo.n(objE2);
                int iIntValue3 = ((Number) objE2).intValue();
                azg azgVarR3 = dqc.bi(objX21).r();
                azgVarR3.ab = cnb.z(-457482736499498L);
                Object objE3 = ((azk) yg.e(azgVarR3)).e();
                bzo.n(objE3);
                int iIntValue4 = ((Number) objE3).intValue();
                azg azgVarR4 = dqc.bi(objX21).r();
                azgVarR4.ab = cnb.z(-457920823163690L);
                String str3 = (String) ((azk) yg.e(azgVarR4)).e();
                azg azgVarR5 = dqc.bi(objX21).r();
                azgVarR5.ab = cnb.z(-457912233229098L);
                Object objE4 = ((azk) yg.e(azgVarR5)).e();
                bzo.n(objE4);
                String str4 = (String) objE4;
                if ((iIntValue3 > 0 || iIntValue4 > 0) && bzo.f(str3, String.valueOf(ewg.s.w))) {
                    String sendTalker = new MsgInfoBean.QuoteMsg(str4).getSendTalker();
                    acx.a.getClass();
                    if (bzo.f(sendTalker, acx.b())) {
                        try {
                            objX22 = bmmVar3.d()[iIntValue2];
                            if (objX22 == null) {
                                objX22 = null;
                            }
                        } catch (Throwable th22) {
                            objX22 = bhu.x(th22);
                        }
                        obj2 = objX22 instanceof dcx ? null : objX22;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cxk.a.o());
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(cxj.a.o())), 0, spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append((CharSequence) cnb.z(-457834923817770L));
                        spannableStringBuilder.append((CharSequence) obj2);
                        bmmVar3.h(spannableStringBuilder);
                    }
                }
                return ensVar;
            case 13:
                amm ammVar = (amm) obj;
                ammVar.b = new cvc(14);
                ammVar.c = new cvc(15);
                return ensVar;
            case 14:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k(cnb.z(-457843513752362L), cnb.z(-459312392567594L));
                bagVar.getClass();
                bagVar.b = zbVar;
                return ensVar;
            case 15:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cls2 = CharSequence.class;
                Class<CharSequence> clsBf2 = cnf.bf(dal.b(cls2));
                cdjVar5.r(clsBf2 != null ? clsBf2 : CharSequence.class);
                cdjVar5.p(new bqi(7, 8, 1));
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ensVar;
            case 16:
                bmm bmmVar4 = (bmm) obj;
                bmmVar4.getClass();
                try {
                    objX23 = bmmVar4.d()[0];
                    if (objX23 == null) {
                        objX23 = null;
                    }
                } catch (Throwable th23) {
                    objX23 = bhu.x(th23);
                }
                Object obj12 = objX23 instanceof dcx ? null : objX23;
                bzo.n(obj12);
                try {
                    objX24 = bmmVar4.d()[1];
                    if (objX24 == null) {
                        objX24 = null;
                    }
                } catch (Throwable th24) {
                    objX24 = bhu.x(th24);
                }
                if (objX24 instanceof dcx) {
                    objX24 = null;
                }
                bzo.n(objX24);
                int i9 = bte.a;
                azg azgVarR6 = dqc.bi(obj12).r();
                azgVarR6.a = dal.b(View.class);
                Object objE5 = ((azk) yg.e(azgVarR6)).e();
                bzo.n(objE5);
                View viewB = erb.b((ViewGroup) objE5, cnb.z(-86539296045866L), 0, 1, 1, 1, 1);
                bzo.n(viewB);
                TextView textView = (TextView) viewB;
                Field[] declaredFields = objX24.getClass().getDeclaredFields();
                int length = declaredFields.length;
                Field field = null;
                int i10 = 0;
                boolean z = false;
                while (i10 < length) {
                    field = declaredFields[i10];
                    field.setAccessible(true);
                    if (z) {
                        throw new IllegalArgumentException(cnb.z(-540817986943786L));
                    }
                    i10++;
                    z = true;
                }
                if (!z) {
                    throw new NoSuchElementException(cnb.z(-540066367666986L));
                }
                Object obj13 = field.get(objX24);
                bzo.n(obj13);
                int i11 = bte.a;
                azg azgVarR7 = dqc.bi(obj13).r();
                azgVarR7.a = dal.b(cls);
                Object obj14 = null;
                boolean z2 = false;
                for (Object obj15 : azgVarR7.c()) {
                    String str5 = (String) ((azk) obj15).e();
                    if (str5 != null && str5.length() == 10) {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= str5.length()) {
                                if (!z2) {
                                    obj14 = obj15;
                                    z2 = true;
                                    break;
                                }
                                throw new IllegalArgumentException(cnb.z(-540349835508522L));
                            }
                            if (!Character.isDigit(str5.charAt(i12))) {
                            }
                            i12++;
                            break;
                        }
                    }
                }
                if (!z2) {
                    throw new NoSuchElementException(cnb.z(-540160856947498L));
                }
                Object objE6 = ((azk) obj14).e();
                bzo.n(objE6);
                long j = Long.parseLong((String) objE6) * ((long) 1000);
                dad.a.getClass();
                int i13 = drv.a;
                textView.setText(cnh.ag(j, bzo.f(Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()) ? cnb.z(-538786467412778L) : Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate().getYear() == LocalDate.now().getYear() ? cnb.z(-539297568521002L) : cnb.z(-539220259109674L), null, 2));
                return ensVar;
            case 17:
                bmm bmmVar5 = (bmm) obj;
                bmmVar5.getClass();
                try {
                    objX25 = bmmVar5.d()[2];
                    if (objX25 == null) {
                        objX25 = null;
                    }
                } catch (Throwable th25) {
                    objX25 = bhu.x(th25);
                }
                JSONObject jSONObject = (JSONObject) (objX25 instanceof dcx ? null : objX25);
                if (jSONObject != null) {
                    dad.a.getClass();
                    if (Math.random() > 0.65d) {
                        List listAg = aba.ag(cnb.z(-539173014469418L), cnb.z(-539108589959978L), cnb.z(-539130064796458L), cnb.z(-539134359763754L));
                        ae aeVar = cyj.f;
                        String str6 = (String) aaz.q(listAg);
                        jSONObject.put(cnb.z(-539087115123498L), cnb.z(-540659073153834L) + str6 + cnb.z(-540676253023018L));
                    }
                    double d = jSONObject.getInt(cnb.z(-540641893284650L));
                    int i14 = jSONObject.getInt(cnb.z(-540555993938730L));
                    int i15 = jSONObject.getInt(cnb.z(-540517339233066L));
                    double d2 = jSONObject.getInt(cnb.z(-540487274461994L));
                    jSONObject.getInt(cnb.z(-540461504658218L));
                    jSONObject.getJSONArray(cnb.z(-540414260017962L));
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cnb.z(-540933951060778L));
                    double d3 = 100;
                    sb2.append(d2 / d3);
                    sb2.append('/');
                    sb2.append(d / d3);
                    sb2.append(cnb.z(-540951130929962L));
                    sb.append(sb2.toString());
                    sb.append(cnb.z(-540955425897258L) + i15 + '/' + i14 + '\n');
                    double d4 = (d - d2) / d3;
                    if (d4 > 0.0d) {
                        sb.append(cnb.z(-540903886289706L) + d4 + cnb.z(-540921066158890L));
                    }
                    jSONObject.put(cnb.z(-540873821518634L), sb.toString());
                }
                return ensVar;
            case 18:
                ((amm) obj).c = new cvc(19);
                return ensVar;
            case 19:
                bah bahVar6 = (bah) obj;
                String[] strArr4 = {cnb.z(-537158674807594L)};
                bahVar6.getClass();
                bahVar6.a = la.ab(strArr4);
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-537588171537194L), cnb.z(-537433552714538L));
                bahVar6.d = cdjVar6;
                return ensVar;
            case 20:
                ((bmm) obj).h(Boolean.FALSE);
                return ensVar;
            case 21:
                ((amm) obj).c = new cvc(22);
                return ensVar;
            case 22:
                bah bahVar7 = (bah) obj;
                cdj cdjVar7 = new cdj();
                cdj.l(cdjVar7, cnb.z(-497559076338474L));
                cls3 = Boolean.class;
                Class<Boolean> clsBf3 = cnf.bf(dal.b(cls3));
                cdjVar7.r(clsBf3 != null ? clsBf3 : Boolean.class);
                cdjVar7.t(cnb.z(-497902673722154L));
                bahVar7.getClass();
                bahVar7.d = cdjVar7;
                return ensVar;
            case 23:
                int i16 = bte.a;
                azg azgVarAa2 = dkz.aa((bmm) obj);
                azgVarAa2.a = dal.b(cls4);
                for (azk azkVar : azgVarAa2.c()) {
                    Integer num = (Integer) azkVar.e();
                    if (num != null && num.intValue() == 32) {
                        azkVar.f(Integer.MAX_VALUE);
                    }
                }
                return ensVar;
            case 24:
                ((amm) obj).c = new cvc(25);
                return ensVar;
            case 25:
                bah bahVar8 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t(cnb.z(-497365802810154L), cnb.z(-498877631298346L));
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return ensVar;
            case 26:
                int i17 = bte.a;
                azg azgVarAa3 = dkz.aa((bmm) obj);
                abf.ao(azgVarAa3.ad, (cdy[]) Arrays.copyOf(new cdy[]{cdy.b, cdy.d}, 2));
                azgVarAa3.a = dal.b(cls4);
                for (azk azkVar2 : azgVarAa3.c()) {
                    Integer num2 = (Integer) azkVar2.e();
                    if (num2 != null && num2.intValue() == 10) {
                        azkVar2.f(Integer.MAX_VALUE);
                    }
                }
                return ensVar;
            case 27:
                ((bmm) obj).h(Boolean.FALSE);
                return ensVar;
            case 28:
                bah bahVar9 = (bah) obj;
                cdj cdjVar9 = new cdj();
                cdjVar9.s(cnb.z(-519974510656298L));
                bahVar9.getClass();
                bahVar9.d = cdjVar9;
                return ensVar;
            default:
                bmm bmmVar6 = (bmm) obj;
                bmmVar6.getClass();
                try {
                    objX26 = bmmVar6.d()[0];
                    if (objX26 == null) {
                        objX26 = null;
                    }
                } catch (Throwable th26) {
                    objX26 = bhu.x(th26);
                }
                if (objX26 instanceof dcx) {
                    objX26 = null;
                }
                bzo.n(objX26);
                String str7 = (String) objX26;
                try {
                    objX27 = bmmVar6.d()[1];
                    if (objX27 == null) {
                        objX27 = null;
                    }
                } catch (Throwable th27) {
                    objX27 = bhu.x(th27);
                }
                bzo.n(objX27 instanceof dcx ? null : objX27);
                for (bny bnyVar : dbl.b) {
                    try {
                        bnyVar.d(bmmVar6, str7);
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(cnb.z(-55997783604010L));
                        ewq.e(yg.n(sb3, bnyVar instanceof doo ? ((doo) bnyVar).f() : cnb.z(-55873229552426L), -55851754715946L), e, 12);
                    }
                }
                return ensVar;
        }
    }
}
