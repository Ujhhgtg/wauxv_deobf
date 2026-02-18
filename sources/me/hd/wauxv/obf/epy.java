package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.google.android.material.slider.Slider;
import com.umeng.commonsdk.UMConfigure;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.R;
import me.hd.wauxv.hook.core.p000native.LoaderNative;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpUtils;
import okhttp3.internal.cache.DiskLruCache;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class epy implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ epy(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:167:0x06be  */
    /* JADX WARN: Found duplicated region for block: B:173:0x06ca  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        Class cls;
        Class cls2;
        Object objX;
        Class cls3;
        Object objX2;
        bcm bcmVar;
        String strI;
        Class cls4;
        Object objX3;
        int i = this.a;
        int i2 = 7;
        Class cls5 = Integer.TYPE;
        cls = Context.class;
        int i3 = 5;
        cls2 = String.class;
        char c = 0;
        z = false;
        z = false;
        boolean z = false;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t((cnb.ab(ewk.l) || cnb.ac(ewh.m)) ? cnb.z(-374581277752106L) : cnb.z(-374392299191082L), cnb.z(-374847565724458L), cnb.z(-374860450626346L));
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 1:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t((cnb.ab(ewk.l) || cnb.ac(ewh.m)) ? cnb.z(-374705831803690L) : cnb.z(-374035816905514L), cnb.z(-373872608148266L), cnb.z(-373902672919338L));
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ensVar;
            case 2:
                View view = (View) obj;
                cee ceeVarE = cee.e(LayoutInflater.from(view.getContext()));
                ceeVarE.c.setText(eta.a.o());
                bzy bzyVar = new bzy(view.getContext());
                ete.a.getClass();
                String str = ete.h;
                eg egVar = (eg) bzyVar.d;
                egVar.d = str;
                LinearLayout linearLayout = ceeVarE.b;
                bzyVar.t(cnb.z(-588457764191018L), new amw(new aul(ceeVarE, 3), 0));
                bzyVar.s(cnb.z(-588479239027498L), new amw(new efq(15), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return ensVar;
            case 3:
                View view2 = (View) obj;
                cee ceeVarE2 = cee.e(LayoutInflater.from(view2.getContext()));
                ceeVarE2.c.setText(etf.a.o());
                bzy bzyVar2 = new bzy(view2.getContext());
                etg.a.getClass();
                String str2 = etg.h;
                eg egVar2 = (eg) bzyVar2.d;
                egVar2.d = str2;
                LinearLayout linearLayout2 = ceeVarE2.b;
                bzyVar2.t(cnb.z(-610237543349034L), new amw(new aul(ceeVarE2, 4), 0));
                bzyVar2.s(cnb.z(-610241838316330L), new amw(new efq(16), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                if (linearLayout2 != null) {
                    egVar2.r = linearLayout2;
                }
                bzyVar2.i().show();
                return ensVar;
            case 4:
                View view3 = (View) obj;
                View viewK = dkz.k(view3, R.layout.module_dialog_voice_length, null, false);
                Slider slider = (Slider) cnd.aq(viewK, R.id.moduleDialogSliderVoiceLength);
                if (slider == null) {
                    throw new NullPointerException(cnb.z(-660016214309674L).concat(viewK.getResources().getResourceName(R.id.moduleDialogSliderVoiceLength)));
                }
                LinearLayout linearLayout3 = (LinearLayout) viewK;
                ceq ceqVar = new ceq(linearLayout3, slider, 1);
                slider.setValue(etq.a.k());
                bzy bzyVar3 = new bzy(view3.getContext());
                eg egVar3 = (eg) bzyVar3.d;
                etr.a.getClass();
                egVar3.d = etr.c;
                bzyVar3.t(cnb.z(-500054452337450L), new amw(new cfx(ceqVar, 20), 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3, cnb.z(-47455093652266L));
                if (linearLayout3 != null) {
                    egVar3.r = linearLayout3;
                }
                bzyVar3.i().show();
                return ensVar;
            case 5:
                ((amm) obj).c = new epy(i2);
                return ensVar;
            case 6:
                bmm bmmVar = (bmm) obj;
                if (bmmVar.d().length == 1) {
                    objX = bmmVar.d()[c];
                    if (objX == null) {
                        objX = null;
                    }
                    if (objX instanceof dcx) {
                    }
                    bzo.n(obj);
                    int i4 = bte.a;
                    azg azgVarR = dqc.bi(obj).r();
                    azgVarR.ab = cnb.z(-500058747304746L);
                    azgVarR.a = dal.b(cls5);
                    ((azk) aaz.e(azgVarR.c())).f(Integer.valueOf(etq.a.k() * 1000));
                } else if (bmmVar.d().length == 2 && (bmmVar.d()[0] instanceof String)) {
                    c = 1;
                    try {
                        objX = bmmVar.d()[c];
                        if (objX == null) {
                            objX = null;
                        }
                    } catch (Throwable th) {
                        objX = bhu.x(th);
                    }
                    Object obj2 = objX instanceof dcx ? null : objX;
                    bzo.n(obj2);
                    int i42 = bte.a;
                    azg azgVarR2 = dqc.bi(obj2).r();
                    azgVarR2.ab = cnb.z(-500058747304746L);
                    azgVarR2.a = dal.b(cls5);
                    ((azk) aaz.e(azgVarR2.c())).f(Integer.valueOf(etq.a.k() * 1000));
                }
                return ensVar;
            case 7:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdjVar3.t(cnb.z(-500067337239338L), cnb.z(-499405912275754L));
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 8:
                List list = (List) obj;
                Object obj3 = list.get(0);
                Class<String> clsBf = cnf.bf(dal.b(cls2));
                if (bzo.f(obj3, clsBf != null ? clsBf : String.class)) {
                    Object obj4 = list.get(1);
                    cls3 = Integer.class;
                    Class<Integer> clsBf2 = cnf.bf(dal.b(cls3));
                    if (clsBf2 == null) {
                        clsBf2 = cls3;
                    }
                    if (bzo.f(obj4, clsBf2)) {
                        Object obj5 = list.get(2);
                        Class<Integer> clsBf3 = cnf.bf(dal.b(cls3));
                        if (bzo.f(obj5, clsBf3 != null ? clsBf3 : Integer.class)) {
                            z = true;
                        }
                    }
                }
                return Boolean.valueOf(z);
            case 9:
                ((amm) obj).b = new epy(12);
                return ensVar;
            case 10:
                ((amm) obj).c = new epy(11);
                return ensVar;
            case 11:
                bah bahVar4 = (bah) obj;
                cdj cdjVar4 = new cdj();
                cdjVar4.t(cnb.z(-107348412594986L));
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return ensVar;
            case 12:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k(cnb.z(-105939663321898L), cnb.z(-105888123714346L));
                bagVar.getClass();
                bagVar.b = zbVar;
                return ensVar;
            case 13:
                View view4 = (View) obj;
                cee ceeVarE3 = cee.e(LayoutInflater.from(view4.getContext()));
                ceeVarE3.c.setText(etv.a.o());
                bzy bzyVar4 = new bzy(view4.getContext());
                etw.a.getClass();
                String str3 = etw.h;
                eg egVar4 = (eg) bzyVar4.d;
                egVar4.d = str3;
                LinearLayout linearLayout4 = ceeVarE3.b;
                bzyVar4.t(cnb.z(-520404007385898L), new amw(new aul(ceeVarE3, 5), 0));
                bzyVar4.s(cnb.z(-520408302353194L), new amw(new efq(17), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar4, cnb.z(-47455093652266L));
                if (linearLayout4 != null) {
                    egVar4.r = linearLayout4;
                }
                bzyVar4.i().show();
                return ensVar;
            case 14:
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
                bzo.n(objX2);
                Context baseContext = ((Application) objX2).getBaseContext();
                eui euiVar = eui.a;
                euiVar.getClass();
                cnf.bh(baseContext);
                bmo bmoVar = bmo.a;
                String str4 = exm.i;
                bmoVar.getClass();
                bc bcVar = bmo.c;
                btc[] btcVarArr = bmo.b;
                bcVar.i(btcVarArr[0], str4);
                bmo.d.i(btcVarArr[1], baseContext);
                bmo.e.i(btcVarArr[2], baseContext.getPackageName());
                bmo.f.i(btcVarArr[3], baseContext.getClassLoader());
                bmo.g.i(btcVarArr[4], baseContext.getApplicationInfo().sourceDir);
                bmo.h.i(btcVarArr[5], baseContext.getPackageManager().getApplicationLabel(baseContext.getApplicationInfo()).toString());
                int i5 = bte.a;
                bmu bmuVarS = yg.s(-28930899704618L);
                azg azgVarR3 = bmuVarS.r();
                azgVarR3.ab = cnb.z(-30442728192810L);
                Object objE = ((azk) aaz.e(azgVarR3.c())).e();
                bzo.n(objE);
                bc bcVar2 = bmo.i;
                bcVar2.i(btcVarArr[6], (String) objE);
                azg azgVarR4 = bmuVarS.r();
                azgVarR4.ab = cnb.z(-30352533879594L);
                Object objE2 = ((azk) aaz.e(azgVarR4.c())).e();
                bzo.n(objE2);
                bmo.j.i(btcVarArr[7], Integer.valueOf(((Number) objE2).intValue()));
                azg azgVarR5 = bmuVarS.r();
                azgVarR5.ab = cnb.z(-30279519435562L);
                Object objE3 = ((azk) aaz.e(azgVarR5.c())).e();
                bzo.n(objE3);
                bc bcVar3 = bmo.k;
                bcVar3.i(btcVarArr[8], (String) objE3);
                azg azgVarR6 = bmuVarS.r();
                azgVarR6.ab = cnb.z(-30773440674602L);
                Object objE4 = ((azk) aaz.e(azgVarR6.c())).e();
                bzo.n(objE4);
                bmo.l.i(btcVarArr[9], Boolean.valueOf(dnj.ab((CharSequence) objE4, cnb.z(-30747670870826L), false)));
                bht bhtVar = anj.a;
                ng.af(baseContext);
                anj.g = 3;
                anj.a = new caw(1);
                anj.h = 2;
                ckv.b = "";
                ckv.a = baseContext;
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.connectTimeout(30L, timeUnit);
                builder.readTimeout(30L, timeUnit);
                builder.writeTimeout(30L, timeUnit);
                cqi.a(builder);
                OkHttpClient okHttpClientBuild = builder.build();
                bzo.q(okHttpClientBuild, "value");
                List<Interceptor> listInterceptors = okHttpClientBuild.interceptors();
                cld cldVar = cld.a;
                if (!listInterceptors.contains(cldVar)) {
                    okHttpClientBuild = okHttpClientBuild.newBuilder().addInterceptor(cldVar).build();
                }
                ckv.c = okHttpClientBuild;
                Cache cache = okHttpClientBuild.cache();
                if (cache != null) {
                    DiskLruCache diskLruCache = OkHttpUtils.diskLruCache(cache);
                    bzo.p(diskLruCache, "diskLruCache(it)");
                    bcmVar = new bcm(diskLruCache);
                } else {
                    bcmVar = null;
                }
                ckv.d = bcmVar;
                cnf.ah = new io(baseContext, cnb.z(-5665061862186L));
                emc.w = new io(baseContext, cnb.z(-5922759899946L));
                bhs.h = new io(baseContext, cnb.z(-29274497088298L));
                csc cscVar = euiVar.aa;
                if (cscVar != null) {
                    strI = cscVar.b;
                } else {
                    ki.a.getClass();
                    strI = ki.i();
                }
                if (euiVar.ac().equals(dnj.ba(strI).toString())) {
                    UMConfigure.preInit(baseContext, cnb.z(-72438918413098L), bmo.o());
                    ArrayList arrayList = ewq.a;
                    ewq.d(14, cnb.z(-81728932674346L) + Build.VERSION.RELEASE + SignatureVisitor.SUPER + bmo.s());
                    ewq.d(14, cnb.z(-83257941031722L));
                    StringBuilder sb = new StringBuilder();
                    sb.append(cnb.z(-83111912143658L));
                    sb.append(exl.c);
                    ewq.d(14, sb.toString());
                    System.loadLibrary(cnb.z(-83541408873258L));
                    LoaderNative.a.loaderInit((String) bcVar.h(btcVarArr[0]), baseContext.getDataDir().getAbsolutePath(), bmo.r(), (String) bcVar2.h(btcVarArr[6]), bmo.q(), (String) bcVar3.h(btcVarArr[8]));
                    dov dovVar = ctf.a;
                    cnh.g = ctf.c(cnb.z(-47098611366698L));
                    String str5 = cnh.g;
                    if (str5 == null) {
                        throw new IllegalArgumentException(cnb.z(-375221227879210L).toString());
                    }
                    File file = new File(str5);
                    if (!file.exists() && !file.mkdirs()) {
                        throw new IOException(cnb.z(-398761943628586L));
                    }
                    if (!file.canWrite()) {
                        throw new IOException(cnb.z(-398680339249962L));
                    }
                    if (!eui.c()) {
                        euh euhVar = new euh(3, null);
                        cde cdeVarT = dqc.bh(ajn.ag(cnb.z(-83528523971370L))).t();
                        cdeVarT.ab = cnb.z(-83369610181418L);
                        aki akiVarAd = euiVar.ad((cdk) aaz.e(cdeVarT.aj()), exg.a);
                        akiVarAd.m(new bka(akiVarAd, i3, euhVar));
                        akiVarAd.o();
                    }
                }
                if (eui.c()) {
                    eui.d();
                }
                return ensVar;
            case 15:
                bmm bmmVar3 = (bmm) obj;
                Object obj6 = ((bmh) bmmVar3.b.b).b.thisObject;
                if (bzo.f(obj6 != null ? obj6.getClass() : null, ajn.ag(cnb.z(-58080842742570L)))) {
                    Object objE5 = bmmVar3.e();
                    Activity activity = (Activity) (objE5 instanceof Activity ? objE5 : null);
                    if (activity == null) {
                        cls4 = Activity.class;
                        Class<Activity> clsBf4 = cnf.bf(dal.b(cls4));
                        throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf4 != null ? clsBf4 : Activity.class).getName()).toString());
                    }
                    euj eujVar = euj.a;
                    String strZ = cnb.z(-57307748629290L);
                    ars arsVar = new ars(activity, 2);
                    eujVar.getClass();
                    int i6 = bte.a;
                    cde cdeVarT2 = dqc.bi(activity).t();
                    cdeVarT2.ab = cnb.z(-57956288690986L);
                    cdeVarT2.z(Arrays.copyOf(new Object[]{dal.b(cls5), dal.b(cls2), dal.b(MenuItem.OnMenuItemClickListener.class)}, 3));
                    cdeVarT2.ah();
                    ((cdk) aaz.e(cdeVarT2.aj())).e(Integer.valueOf(R.id.Wauxv_Entry_Item), strZ, arsVar);
                }
                return ensVar;
            case 16:
                emn.ax((Context) obj);
                return ensVar;
            case 17:
                Object objE6 = ((bmm) obj).e();
                Context context = (Context) (objE6 instanceof Context ? objE6 : null);
                if (context == null) {
                    Class<Context> clsBf5 = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf5 != null ? clsBf5 : Context.class).getName()).toString());
                }
                int i7 = bte.a;
                azg azgVarR7 = dqc.bi(context).r();
                azgVarR7.ab = cnb.z(-58918361365290L);
                Object objE7 = ((azk) yg.e(azgVarR7)).e();
                bzo.n(objE7);
                BaseAdapter baseAdapter = (BaseAdapter) objE7;
                for (euk eukVar : eul.b) {
                    cnb.m(baseAdapter, cnb.y(context, eukVar.a, eukVar.b), 0);
                }
                return ensVar;
            default:
                bmm bmmVar4 = (bmm) obj;
                Object objE8 = bmmVar4.e();
                if (!(objE8 instanceof Context)) {
                    objE8 = null;
                }
                Context context2 = (Context) objE8;
                if (context2 == null) {
                    Class<Context> clsBf6 = cnf.bf(dal.b(cls));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf6 != null ? clsBf6 : Context.class).getName()).toString());
                }
                try {
                    objX3 = bmmVar4.d()[1];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                Object obj7 = objX3 instanceof dcx ? null : objX3;
                bzo.n(obj7);
                int i8 = bte.a;
                azg azgVarR8 = dqc.bi(obj7).r();
                azgVarR8.a = dal.b(cls2);
                azgVarR8.ah();
                Iterator it = azgVarR8.c().iterator();
                while (it.hasNext()) {
                    String str6 = (String) ((azk) it.next()).e();
                    if (str6 != null) {
                        for (euk eukVar2 : eul.b) {
                            if (str6.equals(eukVar2.a)) {
                                eukVar2.c.invoke(context2);
                                bmmVar4.g();
                            }
                        }
                    }
                }
                return ensVar;
        }
    }
}
