package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.slider.Slider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.lang.reflect.Method;
import me.hd.wauxv.R;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dbj implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ dbj(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        switch (this.a) {
            case 0:
                amm ammVar = (amm) obj;
                ammVar.b = new dbj(1);
                ammVar.c = new dbj(2);
                return ens.a;
            case 1:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k(cnb.z(-55817394977578L), cnb.z(-55211804588842L));
                bagVar.getClass();
                bagVar.b = zbVar;
                return ens.a;
            case 2:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cls = Object.class;
                Class<Object> clsBf = cnf.bf(dal.b(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cdjVar.r(clsBf);
                cls2 = String.class;
                Class<String> clsBf2 = cnf.bf(dal.b(cls2));
                cls2 = clsBf2 != null ? clsBf2 : String.class;
                Class<Object> clsBf3 = cnf.bf(dal.b(cls));
                cdjVar.q(cls2, clsBf3 != null ? clsBf3 : Object.class);
                cdjVar.t(cnb.z(-55147380079402L), cnb.z(-55100135439146L), cnb.z(-55048595831594L), cnb.z(-55078660602666L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ens.a;
            case 3:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_round_avatar, null, false);
                Slider slider = (Slider) cnd.aq(viewK, R.id.moduleDialogSliderRoundAvatar);
                if (slider == null) {
                    throw new NullPointerException(cnb.z(-660428531170090L).concat(viewK.getResources().getResourceName(R.id.moduleDialogSliderRoundAvatar)));
                }
                LinearLayout linearLayout = (LinearLayout) viewK;
                ceq ceqVar = new ceq(linearLayout, slider, 0);
                slider.setValue(ddg.a.j());
                bzy bzyVar = new bzy(view.getContext());
                eg egVar = (eg) bzyVar.d;
                ddh.a.getClass();
                egVar.d = ddh.c;
                bzyVar.t(cnb.z(-455653080431402L), new amw(new cfx(ceqVar, 10), 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return ens.a;
            case 4:
                String str = ((cdf) obj).h().b;
                return Boolean.valueOf((bzo.f(str, MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME) || bzo.f(str, MethodDescription.CONSTRUCTOR_INTERNAL_NAME)) ? false : true);
            case 5:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t(cnb.z(-455554296183594L), cnb.z(-455537116314410L));
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ens.a;
            case 6:
                return Boolean.valueOf(bzo.f(((cdf) obj).h().b, MethodDescription.CONSTRUCTOR_INTERNAL_NAME));
            case 7:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cls3 = ImageView.class;
                Class<ImageView> clsBf4 = cnf.bf(dal.b(cls3));
                cls3 = clsBf4 != null ? clsBf4 : ImageView.class;
                cls4 = String.class;
                Class<String> clsBf5 = cnf.bf(dal.b(cls4));
                cls4 = clsBf5 != null ? clsBf5 : String.class;
                cls5 = Float.class;
                Class<Float> clsBf6 = cnf.bf(dal.b(cls5));
                cls5 = clsBf6 != null ? clsBf6 : Float.class;
                cls6 = Boolean.class;
                Class<Boolean> clsBf7 = cnf.bf(dal.b(cls6));
                cdjVar3.q(cls3, cls4, cls5, clsBf7 != null ? clsBf7 : Boolean.class);
                cdjVar3.t(cnb.z(-455657375398698L));
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ens.a;
            case 8:
                ddh ddhVar = ddh.a;
                aki akiVarAb = csb.ab(ddhVar, dqc.bf((Method) obj));
                ddhVar.y(akiVarAb, new dbj(14));
                akiVarAb.o();
                return ens.a;
            case 9:
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                new ek(bmmVar, 2, 8).q(Float.valueOf(ddg.a.j()));
                return ens.a;
            case 10:
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                new ek(bmmVar2, 3, 8).q(Float.valueOf(ddg.a.j()));
                return ens.a;
            case 11:
                ((amm) obj).c = new dbj(7);
                return ens.a;
            case 12:
                amm ammVar2 = (amm) obj;
                ammVar2.c = new dbj(5);
                ammVar2.d = new dbj(6);
                return ens.a;
            case 13:
                amm ammVar3 = (amm) obj;
                ammVar3.c = new dbj(15);
                ammVar3.d = new dbj(4);
                return ens.a;
            case 14:
                bmm bmmVar3 = (bmm) obj;
                bmmVar3.getClass();
                new ek(bmmVar3, 2, 8).q(Float.valueOf(ddg.a.j()));
                return ens.a;
            case 15:
                bah bahVar4 = (bah) obj;
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-457096189442858L), cnb.z(-457079009573674L));
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return ens.a;
            case 16:
                ((amm) obj).c = new dbj(17);
                return ens.a;
            case 17:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                fj fjVar = new fj();
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-101528731908906L), cnb.z(-102993315756842L), cnb.z(-102830106999594L));
                fjVar.f(cdjVar6);
                cdjVar5.j = fjVar;
                cdj.m(cdjVar5, 9);
                cls7 = Runnable.class;
                Class<Runnable> clsBf8 = cnf.bf(dal.b(cls7));
                cls7 = clsBf8 != null ? clsBf8 : Runnable.class;
                cls8 = String.class;
                Class<String> clsBf9 = cnf.bf(dal.b(cls8));
                cdjVar5.q(cls7, clsBf9 != null ? clsBf9 : String.class);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ens.a;
            case 18:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_say_hi_remark_name, null, false);
                int i = R.id.moduleDialogEdtSayHiRemarkNameTextFormat;
                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtSayHiRemarkNameTextFormat);
                if (textInputEditText != null) {
                    i = R.id.moduleDialogEdtSayHiRemarkNameTextPlaceholders;
                    MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewK2, R.id.moduleDialogEdtSayHiRemarkNameTextPlaceholders);
                    if (materialTextView != null) {
                        i = R.id.moduleDialogEdtSayHiRemarkNameTimeFormat;
                        TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtSayHiRemarkNameTimeFormat);
                        if (textInputEditText2 != null) {
                            i = R.id.moduleDialogInputSayHiRemarkNameTextFormat;
                            if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputSayHiRemarkNameTextFormat)) != null) {
                                i = R.id.moduleDialogInputSayHiRemarkNameTimeFormat;
                                if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputSayHiRemarkNameTimeFormat)) != null) {
                                    cem cemVar = new cem((LinearLayout) viewK2, textInputEditText, materialTextView, textInputEditText2, 5);
                                    textInputEditText.setText(des.a.o());
                                    textInputEditText2.setText(det.a.o());
                                    materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cnb.z(-515219981859626L));
                                    for (String str2 : deu.b) {
                                        int length = spannableStringBuilder.length();
                                        spannableStringBuilder.append((CharSequence) (str2 + ' '));
                                        spannableStringBuilder.setSpan(new wf(cemVar, str2, 3), length, spannableStringBuilder.length() + (-1), 33);
                                    }
                                    materialTextView.setText(spannableStringBuilder);
                                    bzy bzyVar2 = new bzy(view2.getContext());
                                    eg egVar2 = (eg) bzyVar2.d;
                                    deu.a.getClass();
                                    egVar2.d = deu.h;
                                    bzyVar2.t(cnb.z(-515151262382890L), new amw(new cfx(cemVar, 13), 0));
                                    bzyVar2.s(cnb.z(-515653773556522L), new amw(new cfh(22), 2));
                                    bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                                    LinearLayout linearLayout2 = cemVar.b;
                                    if (linearLayout2 != null) {
                                        egVar2.r = linearLayout2;
                                    }
                                    bzyVar2.i().show();
                                    return ens.a;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-660291092216618L).concat(viewK2.getResources().getResourceName(i)));
            case 19:
                Object objE = ((bmm) obj).e();
                if (!(objE instanceof Activity)) {
                    objE = null;
                }
                Activity activity = (Activity) objE;
                if (activity == null) {
                    cls9 = Activity.class;
                    Class<Activity> clsBf10 = cnf.bf(dal.b(cls9));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf10 != null ? clsBf10 : Activity.class).getName()).toString());
                }
                String stringExtra = activity.getIntent().getStringExtra(cnb.z(-515507744668458L));
                bzo.n(stringExtra);
                Intent intent = activity.getIntent();
                String strZ = cnb.z(-515486269831978L);
                deu.a.getClass();
                intent.putExtra(strZ, dnr.bo(dnr.bo(des.a.o(), cnb.z(-518308063345450L), stringExtra), cnb.z(-518273703607082L), cnh.ag(System.currentTimeMillis(), det.a.o(), null, 2)));
                return ens.a;
            case 20:
                bzo.q(obj, "it");
                return Integer.valueOf(cyj.f.c(2147418112) + 65536);
            case 21:
                return Boolean.valueOf(obj == null);
            case 22:
                amm ammVar4 = (amm) obj;
                ammVar4.b = new dbj(23);
                ammVar4.c = new dbj(24);
                return ens.a;
            case 23:
                bag bagVar2 = (bag) obj;
                String[] strArr = {cnb.z(-370724397120298L)};
                bagVar2.getClass();
                bagVar2.a = la.ab(strArr);
                zb zbVar2 = new zb();
                zbVar2.k(cnb.z(-370608433003306L), cnb.z(-371033634765610L));
                bagVar2.b = zbVar2;
                return ens.a;
            case 24:
                bah bahVar6 = (bah) obj;
                cdj cdjVar7 = new cdj();
                cdj.k(cdjVar7, cnb.z(-370870426008362L));
                cdj.k(cdjVar7, cnb.z(-370840361237290L));
                cdj.k(cdjVar7, cnb.z(-376814660746026L));
                cdj.k(cdjVar7, cnb.z(-376771711073066L));
                cdj.k(cdjVar7, cnb.z(-376702991596330L));
                cdj.k(cdjVar7, cnb.z(-376651451988778L));
                bahVar6.getClass();
                bahVar6.d = cdjVar7;
                return ens.a;
            case 25:
                ((amm) obj).c = new dbj(26);
                return ens.a;
            case 26:
                bah bahVar7 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t(cnb.z(-368671402752810L));
                bahVar7.getClass();
                bahVar7.d = cdjVar8;
                return ens.a;
            case 27:
                ((bmm) obj).g();
                return ens.a;
            case 28:
                ((amm) obj).c = new dbj(29);
                return ens.a;
            default:
                bah bahVar8 = (bah) obj;
                String[] strArr2 = {cnb.z(-514867794541354L)};
                bahVar8.getClass();
                bahVar8.a = la.ab(strArr2);
                cdj cdjVar9 = new cdj();
                cdjVar9.t(cnb.z(-516332378389290L));
                bahVar8.d = cdjVar9;
                return ens.a;
        }
    }
}
