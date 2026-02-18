package me.hd.wauxv.obf;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bka implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ bka(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        cjg cjgVarD;
        Class cls;
        int i = this.a;
        int i2 = 2;
        afw afwVar = null;
        ens ensVar = ens.a;
        Object obj2 = this.c;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                ((bkb) obj3).f.removeCallbacks((hl) obj2);
                return ensVar;
            case 1:
                ant antVar = (ant) obj3;
                int iIntValue = ((Integer) obj).intValue();
                antVar.ai();
                bbe bbeVar = (bbe) ((List) ((io) obj2).c).get(iIntValue);
                String str = bbeVar.d;
                String str2 = bbeVar.e;
                if (bzo.f(str, cnb.z(-550730771462954L))) {
                    Intent intent = new Intent();
                    intent.setClassName(antVar.getContext(), str2);
                    antVar.getContext().startActivity(intent);
                } else if (bzo.f(str, cnb.z(-550709296626474L))) {
                    bbj.a.getClass();
                    if (bzo.f(str2, cnb.z(-553591219682090L))) {
                        alc alcVar = aou.a;
                        cnd.bf(akq.f, new lw(i2, afwVar, 3));
                    } else if (bzo.f(str2, cnb.z(-553535385107242L))) {
                        Process.killProcess(Process.myPid());
                    }
                }
                return ensVar;
            case 2:
                cjg cjgVar = (cjg) obj3;
                cix cixVar = ((cjl) obj2).b;
                cjp cjpVar = (cjp) obj;
                bzo.q(cjpVar, "$this$navOptions");
                cjn cjnVar = cjpVar.a;
                cjnVar.a = 0;
                cjnVar.b = 0;
                if (cjgVar instanceof cji) {
                    int i3 = cjg.e;
                    for (cjg cjgVar2 : dfv.ai(cjgVar, new cgu(19))) {
                        cjg cjgVarAf = cixVar.af();
                        if (bzo.f(cjgVar2, cjgVarAf != null ? cjgVarAf.h : null)) {
                        }
                    }
                    int i4 = cji.a;
                    cjpVar.d = ((cjg) dfv.aj(dfv.ai(cixVar.ag(), new cgu(20)))).g.a;
                    cjpVar.e = true;
                }
                return ensVar;
            case 3:
                ckl cklVar = (ckl) obj3;
                cjo cjoVar = (cjo) obj2;
                cio cioVar = (cio) obj;
                bzo.q(cioVar, "backStackEntry");
                ciq ciqVar = cioVar.h;
                cjg cjgVar3 = cioVar.b;
                if (cjgVar3 == null) {
                    cjgVar3 = null;
                }
                if (cjgVar3 == null || (cjgVarD = cklVar.d(cjgVar3, ciqVar.l(), cjoVar)) == null) {
                    return null;
                }
                return cjgVarD.equals(cjgVar3) ? cioVar : cklVar.w().j(cjgVarD, cjgVarD.k(ciqVar.l()));
            case 4:
                Activity activity = (Activity) obj2;
                dnc.b(activity, (String) obj3);
                dnc.g(activity, 2, cnb.z(-583308098403114L));
                return ensVar;
            default:
                euh euhVar = (euh) obj2;
                aki.l((aki) obj3);
                Object objE = ((bmm) obj).e();
                if (!(objE instanceof Context)) {
                    objE = null;
                }
                Context context = (Context) objE;
                if (context == null) {
                    cls = Context.class;
                    Class<Context> clsBf = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf != null ? clsBf : Context.class).getName()).toString());
                }
                TextView textView = new TextView(context);
                textView.setTextSize(16.0f);
                textView.setText(cnb.z(-82948703386410L));
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(32, 32, 32, 32);
                progressBar.setLayoutParams(layoutParams);
                AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle(cnb.z(-82935818484522L));
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                linearLayout.setGravity(17);
                linearLayout.setPadding(32, 32, 32, 32);
                linearLayout.addView(textView);
                linearLayout.addView(progressBar);
                AlertDialog alertDialogShow = title.setView(linearLayout).setCancelable(false).show();
                alc alcVar2 = aou.a;
                akq akqVar = akq.f;
                bhp bhpVar = new bhp(euhVar, textView, progressBar, alertDialogShow, null);
                ahh ahhVarT = bzo.t(auz.a, akqVar, true);
                alc alcVar3 = aou.a;
                if (ahhVarT != alcVar3 && ahhVarT._w(arj.a) == null) {
                    ahhVarT = ahhVarT._v(alcVar3);
                }
                t dmfVar = new dmf(ahhVarT, true);
                dmfVar.h(ahs.a, dmfVar, bhpVar);
                return ensVar;
        }
    }
}
