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
    /*
     * JADX WARN: Type inference failed for: r3v31, types:
     * [java.lang.reflect.AccessibleObject]
     */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v26, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v35 */
    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) throws IllegalAccessException, cth,
            NoSuchMethodException, InstantiationException, InvocationTargetException {
        Class cls;
        Class cls2;
        Class cls3;
        // ?? r3;
        Object r3;
        int i = this.a;
        Object obj4 = null;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        // ?? r6 = 1;
        Object r6 = 1;
        switch (i) {
            case 0:
                blu bluVar = (blu) obj;
                wz wzVar = (wz) obj2;
                String strZ = "layout" /* "layout" /* "layout" /* cnb.z(-546800876387114L)  */;
                View viewJ = bluVar.j(strZ);
                if (!(viewJ instanceof LinearLayout)) {
                    viewJ = null;
                }
                LinearLayout linearLayout = (LinearLayout) viewJ;
                if (linearLayout == null) {
                    cls3 = LinearLayout.class;
                    Class<LinearLayout> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls3));
                    throw new cth("View with id \"" + strZ + "\" is not a "
                            + (clsBf != null ? clsBf : LinearLayout.class).getName() + ".");
                }
                linearLayout.setOnClickListener(new bq(wzVar, 1));
                String strZ2 = "icon" /* "icon" /* "icon" /* cnb.z(-546753631746858L)  */;
                View viewJ2 = bluVar.j(strZ2);
                if (!(viewJ2 instanceof ImageView)) {
                    viewJ2 = null;
                }
                ImageView imageView = (ImageView) viewJ2;
                cls = ImageView.class;
                if (imageView == null) {
                    Class<ImageView> clsBf2 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                    throw new cth("View with id \"" + strZ2 + "\" is not a "
                            + (clsBf2 != null ? clsBf2 : ImageView.class).getName() + ".");
                }
                imageView.setImageResource(wzVar.a);
                String strZ3 = "icon" /* "icon" /* "icon" /* cnb.z(-552762290993962L)  */;
                View viewJ3 = bluVar.j(strZ3);
                if (!(viewJ3 instanceof ImageView)) {
                    viewJ3 = null;
                }
                ImageView imageView2 = (ImageView) viewJ3;
                if (imageView2 == null) {
                    Class<ImageView> clsBf3 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                    throw new cth("View with id \"" + strZ3 + "\" is not a "
                            + (clsBf3 != null ? clsBf3 : ImageView.class).getName() + ".");
                }
                xb xbVar = xb.a;
                imageView2.setVisibility(xbVar.k() != wy.a.e ? 0 : 8);
                String strZ4 = "title" /* "title" /* "title" /* cnb.z(-552775175895850L)  */;
                View viewJ4 = bluVar.j(strZ4);
                if (!(viewJ4 instanceof TextView)) {
                    viewJ4 = null;
                }
                TextView textView = (TextView) viewJ4;
                cls2 = TextView.class;
                if (textView == null) {
                    Class<TextView> clsBf4 = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
                    throw new cth("View with id \"" + strZ4 + "\" is not a "
                            + (clsBf4 != null ? clsBf4 : TextView.class).getName() + ".");
                }
                textView.setText(wzVar.b);
                String strZ5 = "title" /* "title" /* "title" /* cnb.z(-552732226222890L)  */;
                View viewJ5 = bluVar.j(strZ5);
                TextView textView2 = (TextView) (viewJ5 instanceof TextView ? viewJ5 : null);
                if (textView2 != null) {
                    textView2.setVisibility(xbVar.k() == wy.c.e ? 8 : 0);
                    return kotlinUnitVar;
                }
                Class<TextView> clsBf5 = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
                throw new cth("View with id \"" + strZ5 + "\" is not a "
                        + (clsBf5 != null ? clsBf5 : TextView.class).getName() + ".");
            case 1:
                int i2 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj2).r();
                fieldResolverVarR.name = "field_snsId" /* "field_snsId" /* "field_snsId" /* cnb.z(-535002601225002L)  */;
                Object objE = ((azk) yg.e(fieldResolverVarR)).e();
                throwIfVar1IsNull(objE);
                ewz.aq(diz.b, new cuf(((Number) objE).longValue(), 3));
                return kotlinUnitVar;
            default:
                Activity activity = (Activity) obj;
                dja djaVar = dja.b;
                int i3 = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj2).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "getLocalid" /* "getLocalid" /* "getLocalid" /* cnb.z(-534470025280298L)  */;
                Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT)).j(new Object[0]);
                throwIfVar1IsNull(objJ);
                String str = (String) objJ;
                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(obj2).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.name = "getTypeFlag" /* "getTypeFlag" /* "getTypeFlag" /* cnb.z(-534457140378410L)  */;
                Object objJ2 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).j(new Object[0]);
                throwIfVar1IsNull(objJ2);
                int iIntValue = ((Number) objJ2).intValue();
                MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(obj3).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT3.name = "toByteArray" /* "toByteArray" /* "toByteArray" /* cnb.z(-534371241032490L)  */;
                Object objJ3 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).j(new Object[0]);
                throwIfVar1IsNull(objJ3);
                cwd cwdVar = cwd.a;
                cwdVar.getClass();
                ejy ejyVar = (ejy) cwdVar.c(ejy.Companion.serializer(), (byte[]) objJ3);
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj3).r();
                fieldResolverVarR2.name = "ContentObj" /* "ContentObj" /* "ContentObj" /* cnb.z(-534903816977194L)  */;
                Object objD = ((azk) yg.e(fieldResolverVarR2)).d();
                throwIfVar1IsNull(objD);
                FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objD).r();
                fieldResolverVarR3.fieldType = dal.b(LinkedList.class);
                Object objE2 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).e();
                throwIfVar1IsNull(objE2);
                LinkedList linkedList = (LinkedList) objE2;
                if (iIntValue == ewj.b.h) {
                    String str2 = ejyVar.e;
                    throwIfVar1IsNull(str2);
                    Intent intent = new Intent();
                    intent.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /*
                                                                                              * "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* cnb.z(-95086280964906L)  */
                                                                                              */);
                    intent.putExtra("Ksnsupload_type" /* "Ksnsupload_type" /* "Ksnsupload_type" /* cnb.z(-94927367174954L)  */, 9);
                    intent.putExtra("Kdescription" /* "Kdescription" /* "Kdescription" /* cnb.z(-94858647698218L)  */, str2);
                    activity.startActivity(intent);
                } else {
                    int i4 = ewj.a.h;
                    cdy cdyVar = cdy.c;
                    if (iIntValue == i4) {
                        String str3 = ejyVar.e;
                        throwIfVar1IsNull(str3);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj5 : linkedList) {
                            bub.a.getClass();
                            Object objInvoke = StaticHelpers7.bb(btz.a).invoke(obj4, obj5);
                            throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.String" /*
                                                                                                               * cnb.z(-
                                                                                                               * 354047039109930L)
                                                                                                               */);
                            String str4 = (String) objInvoke;
                            diu diuVar = diu.a;
                            dkc.a.getClass();
                            int i5 = 0;
                            adt adtVarM = dqc.bh(StaticHelpers7.az(dkb.a)).m();
                            adtVarM.setParams(Arrays.copyOf(new Object[] { dal.b(String.class) }, (int) r6));
                            ConstructorHookWrapper constructorHookWrapperVar = (ConstructorHookWrapper) StaticHelpers5.safeGetFirstInList(adtVarM.a());
                            Object[] objArr = { "timeline" /* "timeline" /* "timeline" /* cnb.z(-353901010221866L)  */ };
                            Constructor constructor = constructorHookWrapperVar.a;
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
                            Method methodBb = StaticHelpers7.bb(ditVar);
                            dis.a.getClass();
                            MethodResolver methodResolverVarT4 = dqc.bh(StaticHelpers7.az(dir.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
                            methodResolverVarT4.ak(cdyVar);
                            methodResolverVarT4.returnType = StaticHelpers7.bb(ditVar).getDeclaringClass();
                            Object objE3 = ((MethodHookWrapper) bjs.h(methodResolverVarT4)).e(new Object[0]);
                            throwIfVar1IsNull(objE3);
                            Object objInvoke2 = methodBb.invoke(objE3, obj5, 2, null, objNewInstance);
                            throwIfVar1IsNull(objInvoke2, "null cannot be cast to non-null type kotlin.Boolean" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 352582455261994L)
                                                                                                                 */);
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
                        StaticHelpers5.x(arrayList, arrayList2);
                        ((Handler) bij.a.getValue())
                                .postDelayed(new bjt(new ben(activity, arrayList2, str3, 2), djaVar, 1), 500L);
                    } else if (iIntValue == ewj.c.h) {
                        String str5 = ejyVar.e;
                        throwIfVar1IsNull(str5);
                        dss dssVar = ejyVar.h;
                        throwIfVar1IsNull(dssVar);
                        List list = dssVar.f;
                        throwIfVar1IsNull(list);
                        String str6 = dssVar.d;
                        throwIfVar1IsNull(str6);
                        String str7 = dssVar.e;
                        throwIfVar1IsNull(str7);
                        String str8 = ((dtv) StaticHelpers5.safeGetFirstInList(list)).g;
                        throwIfVar1IsNull(str8);
                        Intent intent2 = new Intent();
                        intent2.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /*
                                                                                                   * cnb.z(-
                                                                                                   * 95721936124714L)
                                                                                                   */);
                        intent2.putExtra("Ksnsupload_type" /* "Ksnsupload_type" /* "Ksnsupload_type" /* cnb.z(-96044058671914L)  */, 1);
                        intent2.putExtra("Ksnsupload_title" /* "Ksnsupload_title" /* "Ksnsupload_title" /* cnb.z(-95975339195178L)  */, str6);
                        intent2.putExtra("Ksnsupload_link" /* "Ksnsupload_link" /* "Ksnsupload_link" /* cnb.z(-93153545681706L)  */, str7);
                        intent2.putExtra("Ksnsupload_imgurl" /* "Ksnsupload_imgurl" /* "Ksnsupload_imgurl" /* cnb.z(-93084826204970L)  */, str8);
                        intent2.putExtra("Kdescription" /* "Kdescription" /* "Kdescription" /* cnb.z(-93024696662826L)  */, str5);
                        activity.startActivity(intent2);
                    } else if (iIntValue == ewj.d.h) {
                        String str9 = ejyVar.e;
                        throwIfVar1IsNull(str9);
                        Object objE4 = StaticHelpers5.safeGetFirstInList(linkedList);
                        dkt.a.getClass();
                        Object objInvoke3 = StaticHelpers7.bb(dkr.a).invoke(null, objE4);
                        String str10 = objInvoke3 instanceof String ? (String) objInvoke3 : null;
                        Object objInvoke4 = StaticHelpers7.bb(dks.a).invoke(null, objE4);
                        throwIfVar1IsNull(objInvoke4, "null cannot be cast to non-null type kotlin.String" /*
                                                                                                            * cnb.z(-
                                                                                                            * 360532439726890L)
                                                                                                            */);
                        String str11 = (String) objInvoke4;
                        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
                        dkv dkvVar = dkv.a;
                        String strZ6 = "" /* "" /* "" /* cnb.z(-534873752206122L)  */;
                        dkvVar.getClass();
                        dku dkuVar = dku.a;
                        Method methodBb2 = StaticHelpers7.bb(dkuVar);
                        dis.a.getClass();
                        MethodResolver methodResolverVarT5 = dqc.bh(StaticHelpers7.az(dir.a)).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT5.ak(cdyVar);
                        methodResolverVarT5.returnType = StaticHelpers7.bb(dkuVar).getDeclaringClass();
                        Object objE5 = ((MethodHookWrapper) bjs.h(methodResolverVarT5)).e(new Object[0]);
                        throwIfVar1IsNull(objE5);
                        Object objInvoke5 = methodBb2.invoke(objE5, objE4, Integer.valueOf(iCurrentTimeMillis), str,
                                Boolean.FALSE, Boolean.TRUE, 30, strZ6);
                        throwIfVar1IsNull(objInvoke5, "null cannot be cast to non-null type kotlin.Boolean" /*
                                                                                                             * cnb.z(-
                                                                                                             * 358419315817258L)
                                                                                                             */);
                        if (str10 != null) {
                            ((Handler) bij.a.getValue())
                                    .postDelayed(new bjt(new cbj(activity, str10, str11, str9), djaVar, 1), 500L);
                        } else {
                            dnc.g(null, 3, "视频暂未缓存或者获取路径失败" /* "视频暂未缓存或者获取路径失败" /* "视频暂未缓存或者获取路径失败" /* cnb.z(-534817917631274L)  */);
                        }
                    } else if (iIntValue == ewj.e.h) {
                        dnc.g(null, 3, "暂不支持 视频号" /* "暂不支持 视频号" /* "暂不支持 视频号" /* cnb.z(-534805032729386L)  */);
                    } else if (iIntValue == ewj.f.h) {
                        dnc.g(null, 3, "暂不支持 实况" /* "暂不支持 实况" /* "暂不支持 实况" /* cnb.z(-534714838416170L)  */);
                    } else {
                        dnc.g(null, 3, "暂不支持的转圈类型: " /* "暂不支持的转圈类型: " /* "暂不支持的转圈类型: " /* cnb.z(-534680478677802L)  */ + iIntValue);
                    }
                }
                return kotlinUnitVar;
        }
    }
}
