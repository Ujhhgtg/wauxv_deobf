package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wx implements bgk {
    public final /* synthetic */ int a;

    public /* synthetic */ wx(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.reflect.AccessibleObject] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v35 */
    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) throws IllegalAccessException, cth, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class cls;
        Class cls2;
        Class cls3;
        ?? r3;
        int i = this.a;
        Object obj4 = null;
        ens ensVar = ens.a;
        ?? r6 = 1;
        switch (i) {
            case 0:
                blu bluVar = (blu) obj;
                wz wzVar = (wz) obj2;
                String strZ = "layout" /* cnb.z(-546800876387114L) */;
                View viewJ = bluVar.j(strZ);
                if (!(viewJ instanceof LinearLayout)) {
                    viewJ = null;
                }
                LinearLayout linearLayout = (LinearLayout) viewJ;
                if (linearLayout == null) {
                    cls3 = LinearLayout.class;
                    Class<LinearLayout> clsBf = cnf.bf(dal.b(cls3));
                    throw new cth("View with id \"" + strZ + "\" is not a " + (clsBf != null ? clsBf : LinearLayout.class).getName() + ".");
                }
                linearLayout.setOnClickListener(new bq(wzVar, 1));
                String strZ2 = "icon" /* cnb.z(-546753631746858L) */;
                View viewJ2 = bluVar.j(strZ2);
                if (!(viewJ2 instanceof ImageView)) {
                    viewJ2 = null;
                }
                ImageView imageView = (ImageView) viewJ2;
                cls = ImageView.class;
                if (imageView == null) {
                    Class<ImageView> clsBf2 = cnf.bf(dal.b(cls));
                    throw new cth("View with id \"" + strZ2 + "\" is not a " + (clsBf2 != null ? clsBf2 : ImageView.class).getName() + ".");
                }
                imageView.setImageResource(wzVar.a);
                String strZ3 = "icon" /* cnb.z(-552762290993962L) */;
                View viewJ3 = bluVar.j(strZ3);
                if (!(viewJ3 instanceof ImageView)) {
                    viewJ3 = null;
                }
                ImageView imageView2 = (ImageView) viewJ3;
                if (imageView2 == null) {
                    Class<ImageView> clsBf3 = cnf.bf(dal.b(cls));
                    throw new cth("View with id \"" + strZ3 + "\" is not a " + (clsBf3 != null ? clsBf3 : ImageView.class).getName() + ".");
                }
                xb xbVar = xb.a;
                imageView2.setVisibility(xbVar.k() != wy.a.e ? 0 : 8);
                String strZ4 = "title" /* cnb.z(-552775175895850L) */;
                View viewJ4 = bluVar.j(strZ4);
                if (!(viewJ4 instanceof TextView)) {
                    viewJ4 = null;
                }
                TextView textView = (TextView) viewJ4;
                cls2 = TextView.class;
                if (textView == null) {
                    Class<TextView> clsBf4 = cnf.bf(dal.b(cls2));
                    throw new cth("View with id \"" + strZ4 + "\" is not a " + (clsBf4 != null ? clsBf4 : TextView.class).getName() + ".");
                }
                textView.setText(wzVar.b);
                String strZ5 = "title" /* cnb.z(-552732226222890L) */;
                View viewJ5 = bluVar.j(strZ5);
                TextView textView2 = (TextView) (viewJ5 instanceof TextView ? viewJ5 : null);
                if (textView2 != null) {
                    textView2.setVisibility(xbVar.k() == wy.c.e ? 8 : 0);
                    return ensVar;
                }
                Class<TextView> clsBf5 = cnf.bf(dal.b(cls2));
                throw new cth("View with id \"" + strZ5 + "\" is not a " + (clsBf5 != null ? clsBf5 : TextView.class).getName() + ".");
            case 1:
                int i2 = bte.a;
                azg azgVarR = dqc.bi(obj2).r();
                azgVarR.ab = "field_snsId" /* cnb.z(-535002601225002L) */;
                Object objE = ((azk) yg.e(azgVarR)).e();
                bzo.n(objE);
                ewz.aq(diz.b, new cuf(((Number) objE).longValue(), 3));
                return ensVar;
            default:
                Activity activity = (Activity) obj;
                dja djaVar = dja.b;
                int i3 = bte.a;
                cde cdeVarT = dqc.bi(obj2).t();
                cdeVarT.ab = "getLocalid" /* cnb.z(-534470025280298L) */;
                Object objJ = ((cdk) dkz.m(cdeVarT)).j(new Object[0]);
                bzo.n(objJ);
                String str = (String) objJ;
                cde cdeVarT2 = dqc.bi(obj2).t();
                cdeVarT2.ab = "getTypeFlag" /* cnb.z(-534457140378410L) */;
                Object objJ2 = ((cdk) dkz.m(cdeVarT2)).j(new Object[0]);
                bzo.n(objJ2);
                int iIntValue = ((Number) objJ2).intValue();
                cde cdeVarT3 = dqc.bi(obj3).t();
                cdeVarT3.ab = "toByteArray" /* cnb.z(-534371241032490L) */;
                Object objJ3 = ((cdk) dkz.m(cdeVarT3)).j(new Object[0]);
                bzo.n(objJ3);
                cwd cwdVar = cwd.a;
                cwdVar.getClass();
                ejy ejyVar = (ejy) cwdVar.c(ejy.Companion.serializer(), (byte[]) objJ3);
                azg azgVarR2 = dqc.bi(obj3).r();
                azgVarR2.ab = "ContentObj" /* cnb.z(-534903816977194L) */;
                Object objD = ((azk) yg.e(azgVarR2)).d();
                bzo.n(objD);
                azg azgVarR3 = dqc.bi(objD).r();
                azgVarR3.a = dal.b(LinkedList.class);
                Object objE2 = ((azk) aaz.e(azgVarR3.c())).e();
                bzo.n(objE2);
                LinkedList linkedList = (LinkedList) objE2;
                if (iIntValue == ewj.b.h) {
                    String str2 = ejyVar.e;
                    bzo.n(str2);
                    Intent intent = new Intent();
                    intent.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* cnb.z(-95086280964906L) */);
                    intent.putExtra("Ksnsupload_type" /* cnb.z(-94927367174954L) */, 9);
                    intent.putExtra("Kdescription" /* cnb.z(-94858647698218L) */, str2);
                    activity.startActivity(intent);
                } else {
                    int i4 = ewj.a.h;
                    cdy cdyVar = cdy.c;
                    if (iIntValue == i4) {
                        String str3 = ejyVar.e;
                        bzo.n(str3);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj5 : linkedList) {
                            bub.a.getClass();
                            Object objInvoke = emn.bb(btz.a).invoke(obj4, obj5);
                            bzo.o(objInvoke, "null cannot be cast to non-null type kotlin.String" /* cnb.z(-354047039109930L) */);
                            String str4 = (String) objInvoke;
                            diu diuVar = diu.a;
                            dkc.a.getClass();
                            int i5 = bte.a;
                            adt adtVarM = dqc.bh(emn.az(dkb.a)).m();
                            adtVarM.z(Arrays.copyOf(new Object[]{dal.b(String.class)}, (int) r6));
                            adu aduVar = (adu) aaz.e(adtVarM.a());
                            Object[] objArr = {"timeline" /* cnb.z(-353901010221866L) */};
                            Constructor constructor = aduVar.a;
                            if (constructor != null) {
                                r3 = obj4;
                                r3 = constructor;
                            }
                            if (r3 != 0 && !r3.isAccessible()) {
                                r3.setAccessible(r6);
                            }
                            Object objNewInstance = constructor.newInstance(Arrays.copyOf(objArr, (int) r6));
                            diuVar.getClass();
                            dit ditVar = dit.a;
                            Method methodBb = emn.bb(ditVar);
                            dis.a.getClass();
                            cde cdeVarT4 = dqc.bh(emn.az(dir.a)).t();
                            cdeVarT4.ak(cdyVar);
                            cdeVarT4.a = emn.bb(ditVar).getDeclaringClass();
                            Object objE3 = ((cdk) bjs.h(cdeVarT4)).e(new Object[0]);
                            bzo.n(objE3);
                            Object objInvoke2 = methodBb.invoke(objE3, obj5, 2, null, objNewInstance);
                            bzo.o(objInvoke2, "null cannot be cast to non-null type kotlin.Boolean" /* cnb.z(-352582455261994L) */);
                            if (!((Boolean) objInvoke2).booleanValue()) {
                                str4 = null;
                            }
                            if (str4 != null) {
                                arrayList.add(str4);
                            }
                            obj4 = null;
                            r6 = 1;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        aaz.x(arrayList, arrayList2);
                        ((Handler) bij.a.getValue()).postDelayed(new bjt(new ben(activity, arrayList2, str3, 2), djaVar, 1), 500L);
                    } else if (iIntValue == ewj.c.h) {
                        String str5 = ejyVar.e;
                        bzo.n(str5);
                        dss dssVar = ejyVar.h;
                        bzo.n(dssVar);
                        List list = dssVar.f;
                        bzo.n(list);
                        String str6 = dssVar.d;
                        bzo.n(str6);
                        String str7 = dssVar.e;
                        bzo.n(str7);
                        String str8 = ((dtv) aaz.e(list)).g;
                        bzo.n(str8);
                        Intent intent2 = new Intent();
                        intent2.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* cnb.z(-95721936124714L) */);
                        intent2.putExtra("Ksnsupload_type" /* cnb.z(-96044058671914L) */, 1);
                        intent2.putExtra("Ksnsupload_title" /* cnb.z(-95975339195178L) */, str6);
                        intent2.putExtra("Ksnsupload_link" /* cnb.z(-93153545681706L) */, str7);
                        intent2.putExtra("Ksnsupload_imgurl" /* cnb.z(-93084826204970L) */, str8);
                        intent2.putExtra("Kdescription" /* cnb.z(-93024696662826L) */, str5);
                        activity.startActivity(intent2);
                    } else if (iIntValue == ewj.d.h) {
                        String str9 = ejyVar.e;
                        bzo.n(str9);
                        Object objE4 = aaz.e(linkedList);
                        dkt.a.getClass();
                        Object objInvoke3 = emn.bb(dkr.a).invoke(null, objE4);
                        String str10 = objInvoke3 instanceof String ? (String) objInvoke3 : null;
                        Object objInvoke4 = emn.bb(dks.a).invoke(null, objE4);
                        bzo.o(objInvoke4, "null cannot be cast to non-null type kotlin.String" /* cnb.z(-360532439726890L) */);
                        String str11 = (String) objInvoke4;
                        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
                        dkv dkvVar = dkv.a;
                        String strZ6 = "" /* cnb.z(-534873752206122L) */;
                        dkvVar.getClass();
                        dku dkuVar = dku.a;
                        Method methodBb2 = emn.bb(dkuVar);
                        dis.a.getClass();
                        cde cdeVarT5 = dqc.bh(emn.az(dir.a)).t();
                        cdeVarT5.ak(cdyVar);
                        cdeVarT5.a = emn.bb(dkuVar).getDeclaringClass();
                        Object objE5 = ((cdk) bjs.h(cdeVarT5)).e(new Object[0]);
                        bzo.n(objE5);
                        Object objInvoke5 = methodBb2.invoke(objE5, objE4, Integer.valueOf(iCurrentTimeMillis), str, Boolean.FALSE, Boolean.TRUE, 30, strZ6);
                        bzo.o(objInvoke5, "null cannot be cast to non-null type kotlin.Boolean" /* cnb.z(-358419315817258L) */);
                        if (str10 != null) {
                            ((Handler) bij.a.getValue()).postDelayed(new bjt(new cbj(activity, str10, str11, str9), djaVar, 1), 500L);
                        } else {
                            dnc.g(null, 3, "视频暂未缓存或者获取路径失败" /* cnb.z(-534817917631274L) */);
                        }
                    } else if (iIntValue == ewj.e.h) {
                        dnc.g(null, 3, "暂不支持 视频号" /* cnb.z(-534805032729386L) */);
                    } else if (iIntValue == ewj.f.h) {
                        dnc.g(null, 3, "暂不支持 实况" /* cnb.z(-534714838416170L) */);
                    } else {
                        dnc.g(null, 3, "暂不支持的转圈类型: " /* cnb.z(-534680478677802L) */ + iIntValue);
                    }
                }
                return ensVar;
        }
    }
}
