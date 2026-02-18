package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.hd.wauxv.R;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class gi implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ gi(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v148 */
    /* JADX WARN: Type inference failed for: r0v168 */
    /* JADX WARN: Type inference failed for: r0v169 */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, JSONException, NoSuchMethodException, InvocationTargetException {
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        ?? r0;
        Class cls;
        int i = this.a;
        int i2 = 8;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                ((bmm) obj).h(null);
                return ensVar;
            case 1:
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
                if (objX instanceof dcx) {
                    objX = null;
                }
                if (objX != null) {
                    int i3 = bte.a;
                    cde cdeVarT = dqc.bi(objX).t();
                    cdeVarT.a = dal.b(Integer.TYPE);
                    Object objJ = ((cdk) dkz.m(cdeVarT)).j(new Object[0]);
                    bzo.n(objJ);
                    switch (((Number) objJ).intValue()) {
                        case 61:
                        case 62:
                        case 63:
                            new ek(bmmVar, 0, 8).q(null);
                        default:
                            return ensVar;
                    }
                }
                return ensVar;
            case 2:
                amm ammVar = (amm) obj;
                ammVar.b = new gi(5);
                ammVar.c = new gi(6);
                return ensVar;
            case 3:
                ((amm) obj).c = new gi(i2);
                return ensVar;
            case 4:
                ((amm) obj).c = new gi(7);
                return ensVar;
            case 5:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k(cnb.z(-636810506009386L), cnb.z(-636698836859690L));
                bagVar.getClass();
                bagVar.b = zbVar;
                return ensVar;
            case 6:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t(cnb.z(-637124038621994L), cnb.z(-637098268818218L), cnb.z(-637055319145258L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 7:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t(cnb.z(-634108971580202L), cnb.z(-633950057790250L));
                cdjVar2.u(8108);
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ensVar;
            case 8:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdjVar3.t(cnb.z(-637008074505002L), cnb.z(-634117561514794L));
                cdjVar3.u(771);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 9:
                ((amm) obj).c = new gi(10);
                return ensVar;
            case 10:
                bah bahVar4 = (bah) obj;
                String[] strArr = {cnb.z(-100351910869802L)};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr);
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-97418448206634L), cnb.z(-97439923043114L));
                bahVar4.d = cdjVar4;
                return ensVar;
            case 11:
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
                String str = (String) (objX3 instanceof dcx ? null : objX3);
                JSONObject jSONObject = new JSONObject(str != null ? str : "");
                if (bzo.f(jSONObject.get(cnb.z(-412488659106602L)), cnb.z(-412450004400938L))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(cnb.z(-412325450349354L));
                    jSONObject2.put(cnb.z(-412338335251242L), cnb.z(-412806486686506L));
                    jSONObject.put(cnb.z(-412802191719210L), jSONObject2);
                    new ek(bmmVar2, 1, 8).q(jSONObject.toString());
                }
                return ensVar;
            case 12:
                ((amm) obj).c = new gi(13);
                return ensVar;
            case 13:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdjVar5.v(cnb.z(-412832256490282L), cnb.z(-412729177275178L));
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ensVar;
            case 14:
                ((bmm) obj).h(null);
                return ensVar;
            case 15:
                ((amm) obj).c = new gi(16);
                return ensVar;
            case 16:
                bah bahVar6 = (bah) obj;
                String[] strArr2 = {cnb.z(-409525131672362L)};
                bahVar6.getClass();
                bahVar6.a = la.ab(strArr2);
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-409361922915114L), cnb.z(-410766377220906L));
                bahVar6.d = cdjVar6;
                return ensVar;
            case 17:
                bmm bmmVar3 = (bmm) obj;
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
                String str2 = (String) objX4;
                String str3 = str2 == null ? "" : str2;
                try {
                    objX5 = bmmVar3.d()[1];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                String str4 = (String) (objX5 instanceof dcx ? null : objX5);
                String str5 = str4 != null ? str4 : "";
                if (str3.equals(cnb.z(-434173948984106L))) {
                    ek ekVar = new ek(bmmVar3, 1, 8);
                    JSONObject jSONObject3 = new JSONObject(str5);
                    jSONObject3.put(cnb.z(-434113819441962L), 60);
                    jSONObject3.put(cnb.z(-434092344605482L), 1);
                    ekVar.q(jSONObject3.toString());
                }
                return ensVar;
            case 18:
                ((amm) obj).b = new gi(19);
                return ensVar;
            case 19:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k(cnb.z(-107103599459114L), cnb.z(-107052059851562L));
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return ensVar;
            case 20:
                ((amm) obj).c = new gi(21);
                return ensVar;
            case 21:
                bah bahVar7 = (bah) obj;
                String[] strArr3 = {cnb.z(-120147415137066L)};
                bahVar7.getClass();
                bahVar7.a = la.ab(strArr3);
                cdj cdjVar7 = new cdj();
                cdjVar7.t(cnb.z(-108469399059242L), cnb.z(-108362024876842L));
                bahVar7.d = cdjVar7;
                return ensVar;
            case 22:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_auto_clean, null, false);
                int i4 = R.id.moduleDialogEdtAutoCleanCycle;
                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtAutoCleanCycle);
                if (textInputEditText != null) {
                    i4 = R.id.moduleDialogInputAutoCleanCycle;
                    if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputAutoCleanCycle)) != null) {
                        i4 = R.id.moduleDialogRvAutoCleanConfig;
                        RecyclerView recyclerView = (RecyclerView) cnd.aq(viewK, R.id.moduleDialogRvAutoCleanConfig);
                        if (recyclerView != null) {
                            LinearLayout linearLayout = (LinearLayout) viewK;
                            cee ceeVar = new cee(linearLayout, textInputEditText, recyclerView);
                            textInputEditText.setText(String.valueOf(lu.a.l()));
                            view.getContext();
                            recyclerView.setLayoutManager(new GridLayoutManager());
                            zm zmVar = new zm(zo.c(), lt.a.n());
                            recyclerView.setAdapter(zmVar);
                            bzy bzyVar = new bzy(view.getContext());
                            eg egVar = (eg) bzyVar.d;
                            lx.a.getClass();
                            egVar.d = lx.c;
                            bzyVar.t(cnb.z(-511139762928426L), new amw(new ls(ceeVar, 0, zmVar), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                            if (linearLayout != null) {
                                egVar.r = linearLayout;
                            }
                            bzyVar.i().show();
                            return ensVar;
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-641461955590954L).concat(viewK.getResources().getResourceName(i4)));
            case 23:
                return Boolean.valueOf(lt.a.n().contains(((zn) obj).a));
            case 24:
                bmm bmmVar4 = (bmm) obj;
                bmmVar4.getClass();
                try {
                    objX6 = bmmVar4.d()[1];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                if (objX6 instanceof dcx) {
                    objX6 = null;
                }
                Boolean bool = (Boolean) objX6;
                if (!(bool != null ? bool.booleanValue() : false)) {
                    try {
                        objX7 = bmmVar4.d()[0];
                        if (objX7 == null) {
                            objX7 = null;
                        }
                    } catch (Throwable th7) {
                        objX7 = bhu.x(th7);
                    }
                    Object obj2 = objX7 instanceof dcx ? null : objX7;
                    bzo.n(obj2);
                    int i5 = bte.a;
                    azg azgVarR = dqc.bi(obj2).r();
                    azgVarR.ab = cnb.z(-443841920367402L);
                    Object objE = ((azk) yg.e(azgVarR)).e();
                    bzo.n(objE);
                    bcp.a.getClass();
                    Method methodBb = emn.bb(bco.a);
                    dgf.a.getClass();
                    methodBb.invoke(dgf.b(emn.bb(bcn.a).getDeclaringClass()), (String) objE);
                }
                return ensVar;
            case 25:
                ((amm) obj).c = new gi(26);
                return ensVar;
            case 26:
                bah bahVar8 = (bah) obj;
                cdj cdjVar8 = new cdj();
                cdjVar8.t(cnb.z(-443760315988778L), cnb.z(-443674416642858L));
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return ensVar;
            case 27:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_auto_login_win, null, false);
                int i6 = R.id.moduleDialogCbAutoLoginWinAutoLoginDevice;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) cnd.aq(viewK2, R.id.moduleDialogCbAutoLoginWinAutoLoginDevice);
                if (materialCheckBox != null) {
                    i6 = R.id.moduleDialogCbAutoLoginWinAutoSyncMsg;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) cnd.aq(viewK2, R.id.moduleDialogCbAutoLoginWinAutoSyncMsg);
                    if (materialCheckBox2 != null) {
                        i6 = R.id.moduleDialogCbAutoLoginWinShowLoginDevice;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) cnd.aq(viewK2, R.id.moduleDialogCbAutoLoginWinShowLoginDevice);
                        if (materialCheckBox3 != null) {
                            LinearLayout linearLayout2 = (LinearLayout) viewK2;
                            cef cefVar = new cef(linearLayout2, materialCheckBox, materialCheckBox2, materialCheckBox3, 0);
                            materialCheckBox2.setChecked(mb.a.i());
                            materialCheckBox3.setChecked(mc.a.i());
                            materialCheckBox.setChecked(ma.a.i());
                            bzy bzyVar2 = new bzy(view2.getContext());
                            eg egVar2 = (eg) bzyVar2.d;
                            md.a.getClass();
                            egVar2.d = md.c;
                            bzyVar2.t(cnb.z(-512346648738602L), new amw(new bp(cefVar, 4), 0));
                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                            if (linearLayout2 != null) {
                                egVar2.r = linearLayout2;
                            }
                            bzyVar2.i().show();
                            return ensVar;
                        }
                    }
                }
                throw new NullPointerException(cnb.z(-641324516637482L).concat(viewK2.getResources().getResourceName(i6)));
            case 28:
                Object objE2 = ((bmm) obj).e();
                Activity activity = (Activity) (objE2 instanceof Activity ? objE2 : null);
                if (activity == null) {
                    cls = Activity.class;
                    Class<Activity> clsBf = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf != null ? clsBf : Activity.class).getName()).toString());
                }
                boolean zI = mb.a.i();
                if (mc.a.i()) {
                    r0 = zI;
                    r0 = (zI ? 1 : 0) | 2;
                }
                r0 = zI;
                int i7 = r0;
                if (ma.a.i()) {
                    i7 = (r0 == true ? 1 : 0) | 4;
                }
                activity.getIntent().putExtra(cnb.z(-512350943705898L), i7);
                return ensVar;
            default:
                int i8 = bte.a;
                azg azgVarAa = dkz.aa((bmm) obj);
                azgVarAa.a = dal.b(Button.class);
                Object objE3 = ((azk) aaz.e(azgVarAa.c())).e();
                bzo.n(objE3);
                ((Button) objE3).callOnClick();
                return ensVar;
        }
    }
}
