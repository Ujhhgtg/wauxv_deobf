package me.hd.wauxv.obf;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dhg implements IHasInvokeMethod {
    public final /* synthetic */ int a;

    public /* synthetic */ dhg(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class cls;
        Class cls2;
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Class cls3;
        Object objX6;
        Object objX7;
        Object objX8;
        int i = this.a;
        int i2 = 15;
        int i3 = 24;
        int i4 = 23;
        cls = String.class;
        cls2 = Activity.class;
        int i5 = 4;
        int i6 = 1;
        int i7 = 0;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                Object objE = ((HookParam) obj).getThisObject();
                Activity activity = (Activity) (!(objE instanceof Activity) ? null : objE);
                if (activity == null) {
                    Class<Activity> clsBf = cnf.bf(dal.b(cls2));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf != null ? clsBf : Activity.class).getName()).toString());
                }
                int i8 = bte.a;
                cde cdeVarT = dqc.bi(activity).t();
                cdeVarT.ab = "getPreferenceScreen" /* cnb.z(-594711236573994L) */;
                Object objJ = ((cdk) dkz.m(cdeVarT)).j(new Object[0]);
                throwIfVar1IsNull(objJ);
                BaseAdapter baseAdapter = (BaseAdapter) objJ;
                String stringExtra = activity.getIntent().getStringExtra("Chat_User" /* cnb.z(-594659696966442L) */);
                if (stringExtra == null) {
                    stringExtra = "异常" /* cnb.z(-594565207685930L) */;
                }
                cnb.m(baseAdapter, cnb.y(activity, "WAuxiliary_chatroom_info_pref" /* cnb.z(-594586682522410L) */,
                        "ID: " /* cnb.z(-593890897820458L) */.concat(stringExtra)), 1);
                return ensVar;
            case 1:
                HookParam hookParam = (HookParam) obj;
                Object objE2 = hookParam.getThisObject();
                if (!(objE2 instanceof Activity)) {
                    objE2 = null;
                }
                Activity activity2 = (Activity) objE2;
                if (activity2 == null) {
                    Class<Activity> clsBf2 = cnf.bf(dal.b(cls2));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf2 != null ? clsBf2 : Activity.class).getName()).toString());
                }
                try {
                    objX = hookParam.getArgs()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                throwIfVar1IsNull(objX);
                int i9 = bte.a;
                azg azgVarR = dqc.bi(objX).r();
                azgVarR.a = dal.b(cls);
                azgVarR.ah();
                Iterator it = azgVarR.c().iterator();
                while (it.hasNext()) {
                    String str = (String) ((azk) it.next()).e();
                    if (str != null && str.equals("WAuxiliary_chatroom_info_pref" /* cnb.z(-593903782722346L) */)) {
                        String stringExtra2 = activity2.getIntent().getStringExtra("Chat_User" /*
                                                                                                * cnb.z(-
                                                                                                * 593757753834282L)
                                                                                                */);
                        if (stringExtra2 == null) {
                            stringExtra2 = "异常" /* cnb.z(-594281739844394L) */;
                        }
                        dnc.tryGetClassByName(activity2, stringExtra2);
                        dnc.g(activity2, 2, "复制成功" /* cnb.z(-594234495204138L) */);
                        hookParam.setResultTrue();
                    }
                }
                return ensVar;
            case 2:
                Object objF = ((HookParam) obj).getResult();
                if (!(objF instanceof List) || ((objF instanceof IEmpty) && !(objF instanceof IEmpty3))) {
                    objF = null;
                }
                List list = (List) objF;
                throwIfVar1IsNull(list);
                dov dovVar = new dov(new cfh(23));
                List list2 = dhm.j;
                ArrayList arrayList = new ArrayList(abb.ak(list2, 10));
                for (Object obj2 : list2) {
                    int i10 = i7 + 1;
                    if (i7 < 0) {
                        aba.aj();
                        throw null;
                    }
                    Constructor constructor = ((adu) dovVar.getValue()).a;
                    Object[] objArr = { Integer.valueOf(list.size() + i7), ((dhk) obj2).b };
                    Constructor constructor2 = constructor != null ? constructor : null;
                    if (constructor2 != null && !constructor2.isAccessible()) {
                        constructor2.setAccessible(true);
                    }
                    arrayList.add(constructor.newInstance(Arrays.copyOf(objArr, 2)));
                    i7 = i10;
                }
                list.addAll(arrayList);
                return ensVar;
            case 3:
                ((amm) obj).c = new dhg(i5);
                return ensVar;
            case 4:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t("MicroMsg.EmojiResHelper" /* cnb.z(-458960205249322L) */,
                        "parseSmileyPanelConfig parseXML exception:%s" /* cnb.z(-458857126034218L) */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 5:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[1];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                throwIfVar1IsNull(objX2);
                String str2 = (String) objX2;
                try {
                    objX3 = hookParam2.getArgs()[3];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                if (objX3 instanceof dcx) {
                    objX3 = null;
                }
                throwIfVar1IsNull(objX3);
                int iIntValue = ((Number) objX3).intValue();
                try {
                    objX4 = hookParam2.getArgs()[4];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                if (objX4 instanceof dcx) {
                    objX4 = null;
                }
                throwIfVar1IsNull(objX4);
                int iIntValue2 = ((Number) objX4).intValue();
                try {
                    objX5 = hookParam2.getArgs()[6];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                if (objX5 instanceof dcx) {
                    objX5 = null;
                }
                throwIfVar1IsNull(objX5);
                int i11 = bte.a;
                azg azgVarR2 = dqc.bi(objX5).r();
                azgVarR2.ab = "d" /* cnb.z(-465591634754346L) */;
                azk azkVar = (azk) aaz.e(azgVarR2.c());
                if (iIntValue == 4 && iIntValue2 == -2005) {
                    Object objE3 = azkVar.e();
                    throwIfVar1IsNull(objE3);
                    if (dnr.bp((String) objE3, "https://weixin110.qq.com/" /* cnb.z(-465600224688938L) */, false)) {
                        new ek(hookParam2, 3, 8).q(0);
                        new ek(hookParam2, 4, 8).q(0);
                        azkVar.f(str2);
                    }
                }
                return ensVar;
            case 6:
                ((amm) obj).c = new dhg(7);
                return ensVar;
            case 7:
                bah bahVar2 = (bah) obj;
                String[] strArr = { "com.tencent.mm.plugin.webview.permission" /* cnb.z(-465505735408426L) */ };
                bahVar2.getClass();
                bahVar2.a = la.ab(strArr);
                cdj cdjVar2 = new cdj();
                cdjVar2.t("MicroMsg.LuggageGetA8Key" /* cnb.z(-462580862679850L) */,
                        "WebView-Trace onSceneEnd resp or cb not found(%b/%b), reqUrl: %s, reason: %d" /*
                                                                                                        * cnb.z(-
                                                                                                        * 462421948889898L)
                                                                                                        */);
                bahVar2.d = cdjVar2;
                return ensVar;
            case 8:
                ((amm) obj).c = new dhg(9);
                return ensVar;
            case 9:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdj.l(cdjVar3, "com.tencent.mm.ui.HomeUI" /* cnb.z(-636376714312490L) */);
                cdjVar3.t("MicroMsg.LauncherUI.HomeUI" /* cnb.z(-635719584316202L) */,
                        "[initActionBar] isChattingForeground True!" /* cnb.z(-635569260460842L) */);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 10:
                View view = (View) obj;
                cee ceeVarE = cee.e(LayoutInflater.from(view.getContext()));
                ceeVarE.c.setText(dip.a.o());
                bzy bzyVar = new bzy(view.getContext());
                diq.a.getClass();
                String str3 = diq.h;
                eg egVar = (eg) bzyVar.d;
                egVar.d = str3;
                LinearLayout linearLayout = ceeVarE.b;
                bzyVar.t("保存" /* cnb.z(-542158016740138L) */, new amw(new aul(ceeVarE, 2), 0));
                bzyVar.s("重置" /* cnb.z(-542110772099882L) */, new amw(new cfh(24), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* cnb.z(-47455093652266L) */);
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return ensVar;
            case 11:
                final HookParam hookParam3 = (HookParam) obj;
                Object objE4 = hookParam3.getThisObject();
                ViewGroup viewGroup = (ViewGroup) (!(objE4 instanceof ViewGroup) ? null : objE4);
                if (viewGroup != null) {
                    viewGroup.setOnLongClickListener(new View.OnLongClickListener() { // from class: me.hd.wauxv.obf.dio
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view2) throws IllegalAccessException {
                            Object objX9;
                            diq diqVar = diq.a;
                            HookParam hookParam4 = hookParam3;
                            hookParam4.getClass();
                            try {
                                objX9 = hookParam4.getArgs()[0];
                                if (objX9 == null) {
                                    objX9 = null;
                                }
                            } catch (Throwable th6) {
                                objX9 = bhu.x(th6);
                            }
                            if (objX9 instanceof dcx) {
                                objX9 = null;
                            }
                            throwIfVar1IsNull(objX9);
                            int i12 = bte.a;
                            azg azgVarR3 = dqc.bi(objX9).r();
                            azgVarR3.ab = "field_userName" /* cnb.z(-542115067067178L) */;
                            Object objE5 = ((azk) yg.e(azgVarR3)).e();
                            throwIfVar1IsNull(objE5);
                            String str4 = (String) objE5;
                            azg azgVarR4 = dqc.bi(objX9).r();
                            azgVarR4.ab = "field_type" /* cnb.z(-542600398371626L) */;
                            Object objE6 = ((azk) yg.e(azgVarR4)).e();
                            throwIfVar1IsNull(objE6);
                            int iIntValue3 = ((Number) objE6).intValue();
                            azg azgVarR5 = dqc.bi(objX9).r();
                            azgVarR5.ab = "field_thumbUrl" /* cnb.z(-542570333600554L) */;
                            String str5 = (String) ((azk) yg.e(azgVarR5)).e();
                            azg azgVarR6 = dqc.bi(objX9).r();
                            azgVarR6.ab = "field_imageBgUrl" /* cnb.z(-542505909091114L) */;
                            String str6 = (String) ((azk) yg.e(azgVarR6)).e();
                            azg azgVarR7 = dqc.bi(objX9).r();
                            azgVarR7.ab = "field_videoBgUrl" /* cnb.z(-542432894647082L) */;
                            String str7 = (String) ((azk) yg.e(azgVarR7)).e();
                            if (iIntValue3 == 1 || iIntValue3 == 2 || iIntValue3 == 3) {
                                if (str5 != null) {
                                    String strConcat = str4.concat(".thumbUrl.png" /* cnb.z(-530763468503850L) */);
                                    diqVar.getClass();
                                    alc alcVar = aou.a;
                                    cnd.bf(akq.f, new ckx(str5, strConcat, (afw) null));
                                }
                                if (str6 != null) {
                                    String strConcat2 = str4.concat(".imageBgUrl.png" /* cnb.z(-530754878569258L) */);
                                    diqVar.getClass();
                                    alc alcVar2 = aou.a;
                                    cnd.bf(akq.f, new ckx(str6, strConcat2, (afw) null));
                                }
                                if (str7 != null) {
                                    String strConcat3 = str4.concat(".videoBgUrl.png" /* cnb.z(-530686159092522L) */);
                                    diqVar.getClass();
                                    alc alcVar3 = aou.a;
                                    cnd.bf(akq.f, new ckx(str7, strConcat3, (afw) null));
                                }
                                dnc.g(null, 3, "下载完成" /* cnb.z(-530617439615786L) */);
                            } else {
                                dnc.g(null, 3, "暂不支持的封面类型 " /* cnb.z(-530561605040938L) */ + iIntValue3);
                            }
                            return true;
                        }
                    });
                    return ensVar;
                }
                cls3 = ViewGroup.class;
                Class<ViewGroup> clsBf3 = cnf.bf(dal.b(cls3));
                throw new IllegalStateException("HookParam instance cannot cast to "
                        .concat((clsBf3 != null ? clsBf3 : ViewGroup.class).getName()).toString());
            case 12:
                ((amm) obj).b = new dhg(13);
                return ensVar;
            case 13:
                bag bagVar = (bag) obj;
                String[] strArr2 = { "com.tencent.mm.plugin.sns.model" /* cnb.z(-365694990416682L) */ };
                bagVar.getClass();
                bagVar.a = la.ab(strArr2);
                zb zbVar = new zb();
                zbVar.k("MicroMsg.SnsCore" /* cnb.z(-366107307277098L) */, "do SnsCore preload" /*
                                                                                                 * cnb.z(-
                                                                                                 * 366051472702250L)
                                                                                                 */);
                bagVar.b = zbVar;
                return ensVar;
            case 14:
                ((amm) obj).c = new dhg(i2);
                return ensVar;
            case 15:
                bah bahVar4 = (bah) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.sns.model" /* cnb.z(-352943232514858L) */ };
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr3);
                cdj cdjVar4 = new cdj();
                if (cdjVar4.f == null) {
                    cdjVar4.f = new fj(i5);
                }
                fj fjVar = cdjVar4.f;
                throwIfVar1IsNull(fjVar);
                fjVar.d = new bqh(4);
                cdjVar4.t("addDownLoadSns" /* cnb.z(-352805793561386L) */,
                        "com.tencent.mm.plugin.sns.model.DownloadManager" /* cnb.z(-352724189182762L) */);
                bahVar4.d = cdjVar4;
                return ensVar;
            case 16:
                View view2 = (View) obj;
                View viewK = dkz.k(view2, R.layout.module_dialog_sns_info, null, false);
                int i12 = R.id.moduleDialogCbSnsInfoHideGroupIcon;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) cnd.aq(viewK,
                        R.id.moduleDialogCbSnsInfoHideGroupIcon);
                if (materialCheckBox != null) {
                    i12 = R.id.moduleDialogEdtSnsInfoTextFormat;
                    TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK,
                            R.id.moduleDialogEdtSnsInfoTextFormat);
                    if (textInputEditText != null) {
                        i12 = R.id.moduleDialogEdtSnsInfoTextPlaceholders;
                        MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewK,
                                R.id.moduleDialogEdtSnsInfoTextPlaceholders);
                        if (materialTextView != null) {
                            i12 = R.id.moduleDialogEdtSnsInfoTimeFormat;
                            TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK,
                                    R.id.moduleDialogEdtSnsInfoTimeFormat);
                            if (textInputEditText2 != null) {
                                i12 = R.id.moduleDialogInputSnsInfoTextFormat;
                                if (((TextInputLayout) cnd.aq(viewK,
                                        R.id.moduleDialogInputSnsInfoTextFormat)) != null) {
                                    i12 = R.id.moduleDialogInputSnsInfoTimeFormat;
                                    if (((TextInputLayout) cnd.aq(viewK,
                                            R.id.moduleDialogInputSnsInfoTimeFormat)) != null) {
                                        bqr bqrVar = new bqr((LinearLayout) viewK, materialCheckBox, textInputEditText,
                                                materialTextView, textInputEditText2);
                                        textInputEditText.setText(djf.a.o());
                                        textInputEditText2.setText(djg.a.o());
                                        materialCheckBox.setChecked(dje.a.i());
                                        materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                                "点击占位符自动添加以下字段:\n" /* cnb.z(-533014031366954L) */);
                                        String[] strArr4 = djh.b;
                                        int length = strArr4.length;
                                        int i13 = 0;
                                        while (i13 < length) {
                                            String str4 = strArr4[i13];
                                            Object obj3 = obj;
                                            int length2 = spannableStringBuilder.length();
                                            spannableStringBuilder.append((CharSequence) (str4 + ' '));
                                            spannableStringBuilder.setSpan(new wf(bqrVar, str4, 4), length2,
                                                    spannableStringBuilder.length() + (-1), 33);
                                            i13++;
                                            obj = obj3;
                                            i6 = i6;
                                        }
                                        Object obj4 = obj;
                                        int i14 = i6;
                                        materialTextView.setText(spannableStringBuilder);
                                        bzy bzyVar2 = new bzy(view2.getContext());
                                        eg egVar2 = (eg) bzyVar2.d;
                                        djh.a.getClass();
                                        egVar2.d = djh.i;
                                        bzyVar2.t("保存" /* cnb.z(-532395556076330L) */, new amw(new cfx(bqrVar, 15), 0));
                                        bzyVar2.s("重置" /* cnb.z(-532399851043626L) */, new amw(new cfh(25), 2));
                                        bjs.x((3 & 2) != 0 ? new amd(i14) : obj4, bzyVar2, "取消" /*
                                                                                                 * cnb.z(-
                                                                                                 * 47455093652266L)
                                                                                                 */);
                                        LinearLayout linearLayout2 = bqrVar.b;
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
                throw new NullPointerException("Missing required view with ID: "
                        /* cnb.z(-660703409077034L) */.concat(viewK.getResources().getResourceName(i12)));
            case 17:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdjVar5.t("realTimeUpdate" /* cnb.z(-534272456784682L) */,
                        "com.tencent.mm.plugin.sns.ui.improve.item.ImproveTimelineItemMeasure" /*
                                                                                                * cnb.z(-
                                                                                                * 534208032275242L)
                                                                                                */);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ensVar;
            case 18:
                int i15 = bte.a;
                bmu bmuVarBi = dqc.bi(((HookParam) obj).getThisObject());
                azg azgVarR3 = bmuVarBi.r();
                djb djbVar = djb.a;
                azgVarR3.a = emn.bb(djbVar).getDeclaringClass();
                Object objD = ((azk) yg.e(azgVarR3)).d();
                throwIfVar1IsNull(objD);
                Object objInvoke = emn.bb(djbVar).invoke(objD, null);
                throwIfVar1IsNull(objInvoke);
                cde cdeVarT2 = bmuVarBi.t();
                cdeVarT2.ab = "getPublishTimeText" /* cnb.z(-532193692613418L) */;
                Object objJ2 = ((cdk) dkz.m(cdeVarT2)).j(new Object[0]);
                throwIfVar1IsNull(objJ2);
                TextView textView = (TextView) objJ2;
                djh.a.getClass();
                textView.setText(dnr.bo(djh.n(objInvoke), "${originalText}" /* cnb.z(-532627484310314L) */,
                        textView.getText().toString()));
                cde cdeVarT3 = bmuVarBi.t();
                cdeVarT3.ab = "getGroupImageStub" /* cnb.z(-532558764833578L) */;
                View view3 = (View) ((cdk) dkz.m(cdeVarT3)).j(new Object[0]);
                if (view3 != null && (view3 instanceof ImageView)) {
                    ((ImageView) view3).setVisibility(dje.a.i() ? 8 : 0);
                }
                return ensVar;
            case 19:
                HookParam hookParam4 = (HookParam) obj;
                int i16 = bte.a;
                bmu bmuVarBi2 = dqc.bi(hookParam4.getThisObject());
                try {
                    objX6 = hookParam4.getArgs()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                obj = objX6 instanceof dcx ? null : objX6;
                throwIfVar1IsNull(obj);
                azg azgVarR4 = dqc.bi(obj).r();
                azgVarR4.a = "com.tencent.mm.plugin.sns.storage.SnsInfo" /* cnb.z(-532498635291434L) */;
                Object objD2 = ((azk) yg.e(azgVarR4)).d();
                throwIfVar1IsNull(objD2);
                cde cdeVarT4 = bmuVarBi2.t();
                cdeVarT4.ab = "getPublishTimeText" /* cnb.z(-533984693975850L) */;
                Object objJ3 = ((cdk) dkz.m(cdeVarT4)).j(new Object[0]);
                throwIfVar1IsNull(objJ3);
                TextView textView2 = (TextView) objJ3;
                djh.a.getClass();
                textView2.setText(dnr.bo(djh.n(objD2), "${originalText}" /* cnb.z(-533851549989674L) */,
                        textView2.getText().toString()));
                cde cdeVarT5 = bmuVarBi2.t();
                cdeVarT5.ab = "getGroupImageStub" /* cnb.z(-534332586326826L) */;
                View view4 = (View) ((cdk) dkz.m(cdeVarT5)).j(new Object[0]);
                if (view4 != null && (view4 instanceof ImageView)) {
                    ((ImageView) view4).setVisibility(dje.a.i() ? 8 : 0);
                }
                return ensVar;
            case 20:
                ((amm) obj).c = new dhg(17);
                return ensVar;
            case 21:
                ((amm) obj).c = new dhg(i3);
                return ensVar;
            case 22:
                ((amm) obj).c = new dhg(i4);
                return ensVar;
            case 23:
                bah bahVar6 = (bah) obj;
                cdj cdjVar6 = new cdj();
                cdjVar6.t("updateStruct" /* cnb.z(-533636801624874L) */,
                        "com.tencent.mm.plugin.sns.ui.item.improve.TimelineItemMeasure" /* cnb.z(-533563787180842L) */);
                bahVar6.getClass();
                bahVar6.d = cdjVar6;
                return ensVar;
            case 24:
                bah bahVar7 = (bah) obj;
                cdj cdjVar7 = new cdj();
                cdjVar7.t("getInfo" /* cnb.z(-533396283456298L) */,
                        "com.tencent.mm.plugin.sns.ui.improve.repository.ImproveListItem" /* cnb.z(-533361923717930L) */);
                bahVar7.getClass();
                bahVar7.d = cdjVar7;
                return ensVar;
            case 25:
                ((amm) obj).c = new dhg(26);
                return ensVar;
            case 26:
                bah bahVar8 = (bah) obj;
                cdj cdjVar8 = new cdj();
                Class<String> clsBf4 = cnf.bf(dal.b(cls));
                cdjVar8.q(clsBf4 != null ? clsBf4 : String.class);
                cdjVar8.t("getByLocalId" /* cnb.z(-376969279568682L) */,
                        "com.tencent.mm.plugin.sns.storage.SnsInfoStorage" /* cnb.z(-376947804732202L) */);
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return ensVar;
            case 27:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX7 = hookParam5.getArgs()[0];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = bhu.x(th7);
                }
                obj = objX7 instanceof dcx ? null : objX7;
                throwIfVar1IsNull(obj);
                ContextMenu contextMenu = (ContextMenu) obj;
                for (boa boaVar : djo.b) {
                    try {
                        for (djl djlVar : boaVar.a()) {
                            contextMenu.add(R.id.MenuItem_Group, djlVar.a, 0, djlVar.b);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList2 = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onCreateMenuItems " /* cnb.z(-55310588836650L) */);
                        ewq.e(yg.n(sb,
                                boaVar instanceof SwitchHook ? ((SwitchHook) boaVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 56895431768874L)
                                                                                                               */,
                                -56805237455658L), e, 12);
                    }
                }
                return ensVar;
            case 28:
                HookParam hookParam6 = (HookParam) obj;
                hookParam6.getClass();
                try {
                    objX8 = hookParam6.getArgs()[0];
                    if (objX8 == null) {
                        objX8 = null;
                    }
                } catch (Throwable th8) {
                    objX8 = bhu.x(th8);
                }
                obj = objX8 instanceof dcx ? null : objX8;
                throwIfVar1IsNull(obj);
                MenuItem menuItem = (MenuItem) obj;
                for (boa boaVar2 : djo.b) {
                    try {
                        int i17 = bte.a;
                        azg azgVarR5 = dqc.bi(hookParam6.getThisObject()).r();
                        azgVarR5.a = dal.b(cls2);
                        Object objE5 = ((azk) aaz.e(azgVarR5.c())).e();
                        throwIfVar1IsNull(objE5);
                        Activity activity3 = (Activity) objE5;
                        azg azgVarR6 = dqc.bi(hookParam6.getThisObject()).r();
                        abf.ao(azgVarR6.ae, (cdy[]) Arrays.copyOf(new cdy[] { cdy.d }, 1));
                        azgVarR6.a = dal.b(cls);
                        Object objE6 = ((azk) aaz.e(azgVarR6.c())).e();
                        throwIfVar1IsNull(objE6);
                        djj.a.getClass();
                        Object objB = djj.b((String) objE6);
                        azg azgVarR7 = dqc.bi(hookParam6.getThisObject()).r();
                        azgVarR7.a = "com.tencent.mm.protocal.protobuf.TimeLineObject" /* cnb.z(-56770877717290L) */;
                        Object objD3 = ((azk) aaz.e(azgVarR7.c())).d();
                        throwIfVar1IsNull(objD3);
                        for (djl djlVar2 : boaVar2.a()) {
                            if (menuItem.getItemId() == djlVar2.a) {
                                djlVar2.c.b(activity3, objB, objD3);
                            }
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList3 = ewq.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onCreateMenuItems " /* cnb.z(-57114475100970L) */);
                        ewq.e(yg.n(sb2,
                                boaVar2 instanceof SwitchHook ? ((SwitchHook) boaVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 57050050591530L)
                                                                                                                 */,
                                -57028575755050L), e2, 12);
                    }
                }
                return ensVar;
            default:
                ((amm) obj).c = new djk(2);
                return ensVar;
        }
    }
}
