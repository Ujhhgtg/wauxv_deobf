package me.hd.wauxv.obf;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class djk implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ djk(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v12, types: [java.lang.Object, java.util.Map] */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Object objX;
        Object objX2;
        Object objX3;
        String str;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        int i = this.a;
        int i2 = 16;
        long j = -47455093652266L;
        cls = String.class;
        char c = 3;
        Object[] objArr = 0;
        int i3 = 1;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                ((amm) obj).c = new djk(i3);
                return ensVar;
            case 1:
                bah bahVar = (bah) obj;
                String[] strArr = {cnb.z(-56500294777642L)};
                bahVar.getClass();
                bahVar.a = la.ab(strArr);
                cdj cdjVar = new cdj();
                cdjVar.t(cnb.z(-53571127081770L), cnb.z(-53403623357226L), cnb.z(-53824530152234L));
                bahVar.d = cdjVar;
                return ensVar;
            case 2:
                bah bahVar2 = (bah) obj;
                String[] strArr2 = {cnb.z(-56994216016682L)};
                bahVar2.getClass();
                bahVar2.a = la.ab(strArr2);
                cdj cdjVar2 = new cdj();
                cdjVar2.t(cnb.z(-56264071576362L), cnb.z(-56105157786410L));
                bahVar2.d = cdjVar2;
                return ensVar;
            case 3:
                Object objE = ((bmm) obj).e();
                Activity activity = (Activity) (!(objE instanceof Activity) ? null : objE);
                if (activity == null) {
                    cls2 = Activity.class;
                    Class<Activity> clsBf = cnf.bf(dal.b(cls2));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf != null ? clsBf : Activity.class).getName()).toString());
                }
                djv djvVar = djv.a;
                String strZ = cnb.z(-556069415811882L);
                djp djpVar = new djp(activity, objArr == true ? 1 : 0);
                djvVar.getClass();
                int i4 = bte.a;
                cde cdeVarT = dqc.bi(activity).t();
                cdeVarT.ab = cnb.z(-558530432072490L);
                cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(Integer.TYPE), dal.b(cls), dal.b(MenuItem.OnMenuItemClickListener.class)}, 3));
                cdeVarT.ah();
                ((cdk) aaz.e(cdeVarT.aj())).e(Integer.valueOf(R.id.MenuItem_Sns_LabelFilter), strZ, new ars(djpVar, 1));
                return ensVar;
            case 4:
                return dkz.o('\'', "'", (String) obj);
            case 5:
                ((amm) obj).c = new djk(6);
                return ensVar;
            case 6:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdj.l(cdjVar3, cnb.z(-556339998751530L));
                cls3 = Void.class;
                Class<Void> clsBf2 = cnf.bf(dal.b(cls3));
                cdjVar3.r(clsBf2 != null ? clsBf2 : Void.class);
                cdjVar3.t(cnb.z(-556168200059690L));
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 7:
                ((amm) obj).c = new djk(8);
                return ensVar;
            case 8:
                bah bahVar4 = (bah) obj;
                cdj cdjVar4 = new cdj();
                Class<String> clsBf3 = cnf.bf(dal.b(cls));
                cls = clsBf3 != null ? clsBf3 : String.class;
                cls4 = Integer.class;
                Class<Integer> clsBf4 = cnf.bf(dal.b(cls4));
                cdjVar4.q(cls, clsBf4 != null ? clsBf4 : Integer.class);
                fj fjVar = new fj();
                cdj cdjVar5 = new cdj();
                cdjVar5.t(cnb.z(-352380591799082L), cnb.z(-352268922649386L));
                fjVar.f(cdjVar5);
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-353724916562730L), cnb.z(-353660492053290L));
                fjVar.f(cdjVar6);
                cdjVar4.j = fjVar;
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return ensVar;
            case 9:
                ((amm) obj).c = new djk(10);
                return ensVar;
            case 10:
                bah bahVar5 = (bah) obj;
                cdj cdjVar7 = new cdj();
                Class<String> clsBf5 = cnf.bf(dal.b(cls));
                if (clsBf5 == null) {
                    clsBf5 = cls;
                }
                Class<String> clsBf6 = cnf.bf(dal.b(cls));
                cdjVar7.q(clsBf5, clsBf6 != null ? clsBf6 : String.class);
                cdjVar7.t(cnb.z(-377939942177578L), cnb.z(-377832567995178L));
                bahVar5.getClass();
                bahVar5.d = cdjVar7;
                return ensVar;
            case 11:
                ((amm) obj).b = new djk(12);
                return ensVar;
            case 12:
                bag bagVar = (bag) obj;
                String[] strArr3 = {cnb.z(-353810815908650L)};
                bagVar.getClass();
                bagVar.a = la.ab(strArr3);
                zb zbVar = new zb();
                zbVar.k(cnb.z(-353213815454506L), cnb.z(-353123621141290L), cnb.z(-353102146304810L), cnb.z(-353020541926186L), cnb.z(-353007657024298L), cnb.z(-353492988328746L), cnb.z(-353419973884714L), cnb.z(-353385614146346L), cnb.z(-353321189636906L), cnb.z(-353278239963946L), cnb.z(-353239585258282L), cnb.z(-359235359603498L), cnb.z(-359222474701610L));
                bagVar.b = zbVar;
                return ensVar;
            case 13:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_sns_upload_app_info, null, false);
                int i5 = R.id.moduleDialogEdtSnsUploadAppInfoPhone;
                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtSnsUploadAppInfoPhone);
                if (textInputEditText != null) {
                    i5 = R.id.moduleDialogEdtSnsUploadAppInfoTextPlaceholders;
                    MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewK, R.id.moduleDialogEdtSnsUploadAppInfoTextPlaceholders);
                    if (materialTextView != null) {
                        i5 = R.id.moduleDialogEdtSnsUploadAppInfoWindows;
                        TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtSnsUploadAppInfoWindows);
                        if (textInputEditText2 != null) {
                            i5 = R.id.moduleDialogInputSnsUploadAppInfoPhone;
                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputSnsUploadAppInfoPhone)) != null) {
                                i5 = R.id.moduleDialogInputSnsUploadAppInfoWindows;
                                if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputSnsUploadAppInfoWindows)) != null) {
                                    cem cemVar = new cem((LinearLayout) viewK, textInputEditText, materialTextView, textInputEditText2, 6);
                                    textInputEditText.setText(dkf.a.o());
                                    textInputEditText2.setText(dkg.a.o());
                                    materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cnb.z(-561369405455146L));
                                    for (Map.Entry entry : dkh.b.entrySet()) {
                                        long j2 = j;
                                        String str2 = (String) entry.getKey();
                                        csm csmVar = (csm) entry.getValue();
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) ("[" + str2 + cnb.z(-561850441792298L)));
                                        spannableStringBuilder.setSpan(new wf(cemVar, csmVar, 5), length, spannableStringBuilder.length() - 1, 33);
                                        j = j2;
                                        c = c;
                                    }
                                    long j3 = j;
                                    materialTextView.setText(spannableStringBuilder);
                                    bzy bzyVar = new bzy(view.getContext());
                                    eg egVar = (eg) bzyVar.d;
                                    dkh.a.getClass();
                                    egVar.d = dkh.i;
                                    bzyVar.t(cnb.z(-561786017282858L), new amw(new cfx(cemVar, 16), 0));
                                    bzyVar.s(cnb.z(-561807492119338L), new amw(new cfh(26), 2));
                                    bjs.x((c & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(j3));
                                    LinearLayout linearLayout = cemVar.b;
                                    if (linearLayout != null) {
                                        egVar.r = linearLayout;
                                    }
                                    bzyVar.i().show();
                                    return ensVar;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-660565970123562L).concat(viewK.getResources().getResourceName(i5)));
            case 14:
                bmm bmmVar = (bmm) obj;
                eog eogVar = eog.a;
                Object objE2 = bmmVar.e();
                String strO = dkf.a.o();
                eogVar.getClass();
                eog.i(objE2, strO);
                eog.g(bmmVar.e(), dkg.a.o());
                return ensVar;
            case 15:
                ((amm) obj).c = new djk(i2);
                return ensVar;
            case 16:
                bah bahVar6 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t(cnb.z(-561652873296682L), cnb.z(-561008628202282L));
                bahVar6.getClass();
                bahVar6.d = cdjVar8;
                return ensVar;
            case 17:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_sns_upload_original_photo, null, false);
                int i6 = R.id.moduleDialogRbSnsUploadOriginalPhotoConvert;
                MaterialRadioButton materialRadioButton = (MaterialRadioButton) cnd.aq(viewK2, R.id.moduleDialogRbSnsUploadOriginalPhotoConvert);
                if (materialRadioButton != null) {
                    i6 = R.id.moduleDialogRbSnsUploadOriginalPhotoCopy;
                    MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) cnd.aq(viewK2, R.id.moduleDialogRbSnsUploadOriginalPhotoCopy);
                    if (materialRadioButton2 != null) {
                        i6 = R.id.moduleDialogRgSnsUploadOriginalPhotoMode;
                        RadioGroup radioGroup = (RadioGroup) cnd.aq(viewK2, R.id.moduleDialogRgSnsUploadOriginalPhotoMode);
                        if (radioGroup != null) {
                            LinearLayout linearLayout2 = (LinearLayout) viewK2;
                            bqr bqrVar = new bqr(linearLayout2, materialRadioButton, materialRadioButton2, radioGroup, 3);
                            int iK = dkk.a.k();
                            if (iK == dkj.a.d) {
                                materialRadioButton.setChecked(true);
                            } else if (iK == dkj.b.d) {
                                materialRadioButton2.setChecked(true);
                            }
                            bzy bzyVar2 = new bzy(view2.getContext());
                            eg egVar2 = (eg) bzyVar2.d;
                            dkl.a.getClass();
                            egVar2.d = dkl.c;
                            bzyVar2.t(cnb.z(-548480208599850L), new amw(new cfx(bqrVar, 17), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                            if (linearLayout2 != null) {
                                egVar2.r = linearLayout2;
                            }
                            bzyVar2.i().show();
                            return ensVar;
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-659878775356202L).concat(viewK2.getResources().getResourceName(i6)));
            case 18:
                bmm bmmVar2 = (bmm) obj;
                if (dkk.a.k() == dkj.a.d) {
                    bmmVar2.getClass();
                    try {
                        objX = bmmVar2.d()[0];
                        if (objX == null) {
                            objX = null;
                        }
                    } catch (Throwable th) {
                        objX = bhu.x(th);
                    }
                    if (objX instanceof dcx) {
                        objX = null;
                    }
                    String str3 = (String) objX;
                    String str4 = str3 == null ? "" : str3;
                    try {
                        objX2 = bmmVar2.d()[1];
                        if (objX2 == null) {
                            objX2 = null;
                        }
                    } catch (Throwable th2) {
                        objX2 = bhu.x(th2);
                    }
                    if (objX2 instanceof dcx) {
                        objX2 = null;
                    }
                    String str5 = (String) objX2;
                    String str6 = str5 == null ? "" : str5;
                    try {
                        objX3 = bmmVar2.d()[2];
                        if (objX3 == null) {
                            objX3 = null;
                        }
                    } catch (Throwable th3) {
                        objX3 = bhu.x(th3);
                    }
                    if (objX3 instanceof dcx) {
                        objX3 = null;
                    }
                    String str7 = (String) objX3;
                    str = str7 != null ? str7 : "";
                    djz djzVar = djz.a;
                    String strConcat = str4.concat(str);
                    djzVar.getClass();
                    Object objInvoke = emn.bb(djy.a).invoke(null, str6, strConcat);
                    bzo.o(objInvoke, cnb.z(-376548372773674L));
                    bmmVar2.h((Boolean) objInvoke);
                }
                return ensVar;
            case 19:
                bmm bmmVar3 = (bmm) obj;
                if (dkk.a.k() == dkj.b.d) {
                    bmmVar3.getClass();
                    try {
                        objX4 = bmmVar3.d()[0];
                        if (objX4 == null) {
                            objX4 = null;
                        }
                    } catch (Throwable th4) {
                        objX4 = bhu.x(th4);
                    }
                    if (objX4 instanceof dcx) {
                        objX4 = null;
                    }
                    String str8 = (String) objX4;
                    String str9 = str8 == null ? "" : str8;
                    try {
                        objX5 = bmmVar3.d()[1];
                        if (objX5 == null) {
                            objX5 = null;
                        }
                    } catch (Throwable th5) {
                        objX5 = bhu.x(th5);
                    }
                    if (objX5 instanceof dcx) {
                        objX5 = null;
                    }
                    String str10 = (String) objX5;
                    String str11 = str10 == null ? "" : str10;
                    try {
                        objX6 = bmmVar3.d()[2];
                        if (objX6 == null) {
                            objX6 = null;
                        }
                    } catch (Throwable th6) {
                        objX6 = bhu.x(th6);
                    }
                    if (objX6 instanceof dcx) {
                        objX6 = null;
                    }
                    String str12 = (String) objX6;
                    str = str12 != null ? str12 : "";
                    try {
                        objX7 = bmmVar3.d()[3];
                        if (objX7 == null) {
                            objX7 = null;
                        }
                    } catch (Throwable th7) {
                        objX7 = bhu.x(th7);
                    }
                    if (objX7 instanceof dcx) {
                        objX7 = null;
                    }
                    Boolean bool = (Boolean) objX7;
                    if (bool != null ? bool.booleanValue() : false) {
                        File file = new File(str11);
                        eoy eoyVar = eoy.a;
                        String strConcat2 = str9.concat(str);
                        eoyVar.getClass();
                        Object objInvoke2 = emn.bb(eox.a).invoke(null, strConcat2, Boolean.TRUE);
                        bzo.o(objInvoke2, cnb.z(-107696304945962L));
                        bad.a(file, new File((String) objInvoke2));
                    }
                }
                return ensVar;
            case 20:
                ((amm) obj).c = new djk(21);
                return ensVar;
            case 21:
                bah bahVar7 = (bah) obj;
                cdj cdjVar9 = new cdj();
                cdjVar9.t(cnb.z(-548432963959594L), cnb.z(-547775833963306L), cnb.z(-547694229584682L), cnb.z(-548076481674026L), cnb.z(-547994877295402L));
                bahVar7.getClass();
                bahVar7.d = cdjVar9;
                return ensVar;
            case 22:
                ((amm) obj).b = new djk(23);
                return ensVar;
            case 23:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                fj fjVar2 = new fj();
                cdj cdjVar10 = new cdj();
                cdjVar10.s(cnb.z(-359033496140586L));
                fjVar2.f(cdjVar10);
                cdj cdjVar11 = new cdj();
                cdjVar11.s(cnb.z(-359020611238698L));
                fjVar2.f(cdjVar11);
                cdj cdjVar12 = new cdj();
                fj fjVar3 = new fj();
                cdj cdjVar13 = new cdj();
                cdjVar13.t(cnb.z(-359523122412330L), cnb.z(-359441518033706L));
                fjVar3.f(cdjVar13);
                cdj cdjVar14 = new cdj();
                cdjVar14.t(cnb.z(-359295489145642L), cnb.z(-358677013855018L));
                fjVar3.f(cdjVar14);
                cdjVar12.j = fjVar3;
                fjVar2.f(cdjVar12);
                zbVar2.f = fjVar2;
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return ensVar;
            case 24:
                ((amm) obj).c = new dko(0);
                return ensVar;
            case 25:
                ((amm) obj).c = new djk(28);
                return ensVar;
            case 26:
                ((amm) obj).c = new djk(29);
                return ensVar;
            case 27:
                ((amm) obj).c = new dko(1);
                return ensVar;
            case 28:
                bah bahVar8 = (bah) obj;
                String[] strArr4 = {cnb.z(-359858129861418L)};
                bahVar8.getClass();
                bahVar8.a = la.ab(strArr4);
                cdj cdjVar15 = new cdj();
                cdjVar15.t(cnb.z(-356971911838506L), cnb.z(-356920372230954L));
                bahVar8.d = cdjVar15;
                return ensVar;
            default:
                bah bahVar9 = (bah) obj;
                String[] strArr5 = {cnb.z(-357255379680042L)};
                bahVar9.getClass();
                bahVar9.a = la.ab(strArr5);
                cdj cdjVar16 = new cdj();
                cdjVar16.t(cnb.z(-357117940726570L), cnb.z(-356512350337834L));
                bahVar9.d = cdjVar16;
                return ensVar;
        }
    }
}
