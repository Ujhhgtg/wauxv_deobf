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
public final /* synthetic */ class dhg implements IInvokable {
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
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                Object objE = ((HookParam) obj).getThisObject();
                Activity activity = (Activity) (!(objE instanceof Activity) ? null : objE);
                if (activity == null) {
                    Class<Activity> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf != null ? clsBf : Activity.class).getName()).toString());
                }
                int i8 = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(activity).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "getPreferenceScreen" /* "getPreferenceScreen" /* "getPreferenceScreen" /* "getPreferenceScreen" /* cnb.z(-594711236573994L)   */;
                Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT)).j(new Object[0]);
                throwIfVar1IsNull(objJ);
                BaseAdapter baseAdapter = (BaseAdapter) objJ;
                String stringExtra = activity.getIntent().getStringExtra("Chat_User" /* "Chat_User" /* "Chat_User" /* "Chat_User" /* cnb.z(-594659696966442L)   */);
                if (stringExtra == null) {
                    stringExtra = "异常" /* "异常" /* "异常" /* "异常" /* cnb.z(-594565207685930L)   */;
                }
                cnb.m(baseAdapter, cnb.y(activity, "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* cnb.z(-594586682522410L)   */,
                        "ID: " /* "ID: " /* "ID: " /* "ID: " /* cnb.z(-593890897820458L)   */.concat(stringExtra)), 1);
                return kotlinUnitVar;
            case 1:
                HookParam hookParam = (HookParam) obj;
                Object objE2 = hookParam.getThisObject();
                if (!(objE2 instanceof Activity)) {
                    objE2 = null;
                }
                Activity activity2 = (Activity) objE2;
                if (activity2 == null) {
                    Class<Activity> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf2 != null ? clsBf2 : Activity.class).getName()).toString());
                }
                try {
                    objX = hookParam.getArgs()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                if (objX instanceof Failure) {
                    objX = null;
                }
                throwIfVar1IsNull(objX);
                int i9 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objX).r();
                fieldResolverVarR.fieldType = dal.getKClassFromClass(cls);
                fieldResolverVarR.enableSuperclass();
                Iterator it = fieldResolverVarR.resolve().iterator();
                while (it.hasNext()) {
                    String str = (String) ((BoundField) it.next()).getValue_();
                    if (str != null && str.equals("WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* "WAuxiliary_chatroom_info_pref" /* cnb.z(-593903782722346L)   */)) {
                        String stringExtra2 = activity2.getIntent().getStringExtra("Chat_User" /*
                                                                                                * cnb.z(-
                                                                                                * 593757753834282L)
                                                                                                */);
                        if (stringExtra2 == null) {
                            stringExtra2 = "异常" /* "异常" /* "异常" /* "异常" /* cnb.z(-594281739844394L)   */;
                        }
                        dnc.tryGetClassByName(activity2, stringExtra2);
                        dnc.sendToast(activity2, 2, "复制成功" /* "复制成功" /* "复制成功" /* "复制成功" /* cnb.z(-594234495204138L)   */);
                        hookParam.setResultTrue();
                    }
                }
                return kotlinUnitVar;
            case 2:
                Object objF = ((HookParam) obj).getResult();
                if (!(objF instanceof List) || ((objF instanceof IEmpty) && !(objF instanceof IEmpty3))) {
                    objF = null;
                }
                List list = (List) objF;
                throwIfVar1IsNull(list);
                Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new Function1$VarIsInt$2(23));
                List list2 = dhm.j;
                ArrayList arrayList = new ArrayList(StaticHelpers4.ak(list2, 10));
                for (Object obj2 : list2) {
                    int i10 = i7 + 1;
                    if (i7 < 0) {
                        OtherStaticHelpers.aj();
                        throw null;
                    }
                    Constructor constructor = ((ConstructorHookWrapper) kotlin$LazyVar.getValue()).a;
                    Object[] objArr = { Integer.valueOf(list.size() + i7), ((dhk) obj2).b };
                    Constructor constructor2 = constructor != null ? constructor : null;
                    if (constructor2 != null && !constructor2.isAccessible()) {
                        constructor2.setAccessible(true);
                    }
                    arrayList.add(constructor.newInstance(Arrays.copyOf(objArr, 2)));
                    i7 = i10;
                }
                list.addAll(arrayList);
                return kotlinUnitVar;
            case 3:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(i5);
                return kotlinUnitVar;
            case 4:
                bah bahVar = (bah) obj;
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("MicroMsg.EmojiResHelper" /* "MicroMsg.EmojiResHelper" /* "MicroMsg.EmojiResHelper" /* "MicroMsg.EmojiResHelper" /* cnb.z(-458960205249322L)   */,
                        "parseSmileyPanelConfig parseXML exception:%s" /* "parseSmileyPanelConfig parseXML exception:%s" /* "parseSmileyPanelConfig parseXML exception:%s" /* "parseSmileyPanelConfig parseXML exception:%s" /* cnb.z(-458857126034218L)   */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 5:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[1];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
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
                    objX3 = FastKV.getFailureFromException(th3);
                }
                if (objX3 instanceof Failure) {
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
                    objX4 = FastKV.getFailureFromException(th4);
                }
                if (objX4 instanceof Failure) {
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
                    objX5 = FastKV.getFailureFromException(th5);
                }
                if (objX5 instanceof Failure) {
                    objX5 = null;
                }
                throwIfVar1IsNull(objX5);
                int i11 = 0;
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objX5).r();
                fieldResolverVarR2.name = "d" /* "d" /* "d" /* "d" /* cnb.z(-465591634754346L)   */;
                BoundField boundFieldVar = (BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve());
                if (iIntValue == 4 && iIntValue2 == -2005) {
                    Object objE3 = boundFieldVar.getValue_();
                    throwIfVar1IsNull(objE3);
                    if (dnr.bp((String) objE3, "https://weixin110.qq.com/" /* "https://weixin110.qq.com/" /* "https://weixin110.qq.com/" /* "https://weixin110.qq.com/" /* cnb.z(-465600224688938L)   */, false)) {
                        new ek(hookParam2, 3, 8).q(0);
                        new ek(hookParam2, 4, 8).q(0);
                        boundFieldVar.setValue(str2);
                    }
                }
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(7);
                return kotlinUnitVar;
            case 7:
                bah bahVar2 = (bah) obj;
                String[] strArr = { "com.tencent.mm.plugin.webview.permission" /* "com.tencent.mm.plugin.webview.permission" /* "com.tencent.mm.plugin.webview.permission" /* "com.tencent.mm.plugin.webview.permission" /* cnb.z(-465505735408426L)   */ };
                bahVar2.getClass();
                bahVar2.a = SomeStaticHelpers.ab(strArr);
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.usingStrings("MicroMsg.LuggageGetA8Key" /* "MicroMsg.LuggageGetA8Key" /* "MicroMsg.LuggageGetA8Key" /* "MicroMsg.LuggageGetA8Key" /* cnb.z(-462580862679850L)   */,
                        "WebView-Trace onSceneEnd resp or cb not found(%b/%b), reqUrl: %s, reason: %d" /*
                                                                                                        * cnb.z(-
                                                                                                        * 462421948889898L)
                                                                                                        */);
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(9);
                return kotlinUnitVar;
            case 9:
                bah bahVar3 = (bah) obj;
                DexFinder cdjVar3 = new DexFinder();
                DexFinder.setClassEquals(cdjVar3, "com.tencent.mm.ui.HomeUI" /* "com.tencent.mm.ui.HomeUI" /* "com.tencent.mm.ui.HomeUI" /* "com.tencent.mm.ui.HomeUI" /* cnb.z(-636376714312490L)   */);
                cdjVar3.usingStrings("MicroMsg.LauncherUI.HomeUI" /* "MicroMsg.LauncherUI.HomeUI" /* "MicroMsg.LauncherUI.HomeUI" /* "MicroMsg.LauncherUI.HomeUI" /* cnb.z(-635719584316202L)   */,
                        "[initActionBar] isChattingForeground True!" /* "[initActionBar] isChattingForeground True!" /* "[initActionBar] isChattingForeground True!" /* "[initActionBar] isChattingForeground True!" /* cnb.z(-635569260460842L)   */);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return kotlinUnitVar;
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
                bzyVar.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-542158016740138L)   */, new amw(new aul(ceeVarE, 2), 0));
                bzyVar.s("重置" /* "重置" /* "重置" /* "重置" /* cnb.z(-542110772099882L)   */, new amw(new Function1$VarIsInt$2(24), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)   */);
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return kotlinUnitVar;
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
                                objX9 = FastKV.getFailureFromException(th6);
                            }
                            if (objX9 instanceof Failure) {
                                objX9 = null;
                            }
                            throwIfVar1IsNull(objX9);
                            int i12 = 0;
                            FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objX9).r();
                            fieldResolverVarR3.name = "field_userName" /* "field_userName" /* "field_userName" /* "field_userName" /* cnb.z(-542115067067178L)   */;
                            Object objE5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
                            throwIfVar1IsNull(objE5);
                            String str4 = (String) objE5;
                            FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(objX9).r();
                            fieldResolverVarR4.name = "field_type" /* "field_type" /* "field_type" /* "field_type" /* cnb.z(-542600398371626L)   */;
                            Object objE6 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue_();
                            throwIfVar1IsNull(objE6);
                            int iIntValue3 = ((Number) objE6).intValue();
                            FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(objX9).r();
                            fieldResolverVarR5.name = "field_thumbUrl" /* "field_thumbUrl" /* "field_thumbUrl" /* "field_thumbUrl" /* cnb.z(-542570333600554L)   */;
                            String str5 = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue_();
                            FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(objX9).r();
                            fieldResolverVarR6.name = "field_imageBgUrl" /* "field_imageBgUrl" /* "field_imageBgUrl" /* "field_imageBgUrl" /* cnb.z(-542505909091114L)   */;
                            String str6 = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR6)).getValue_();
                            FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(objX9).r();
                            fieldResolverVarR7.name = "field_videoBgUrl" /* "field_videoBgUrl" /* "field_videoBgUrl" /* "field_videoBgUrl" /* cnb.z(-542432894647082L)   */;
                            String str7 = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR7)).getValue_();
                            if (iIntValue3 == 1 || iIntValue3 == 2 || iIntValue3 == 3) {
                                if (str5 != null) {
                                    String strConcat = str4.concat(".thumbUrl.png" /* ".thumbUrl.png" /* ".thumbUrl.png" /* ".thumbUrl.png" /* cnb.z(-530763468503850L)   */);
                                    diqVar.getClass();
                                    Dispatchers$Default alcVar = aou.a;
                                    KotlinHelpers2.bf(akq.f, new ckx(str5, strConcat, (kotlinx$coroutines$internal$DispatchedContinuation) null));
                                }
                                if (str6 != null) {
                                    String strConcat2 = str4.concat(".imageBgUrl.png" /* ".imageBgUrl.png" /* ".imageBgUrl.png" /* ".imageBgUrl.png" /* cnb.z(-530754878569258L)   */);
                                    diqVar.getClass();
                                    Dispatchers$Default alcVar2 = aou.a;
                                    KotlinHelpers2.bf(akq.f, new ckx(str6, strConcat2, (kotlinx$coroutines$internal$DispatchedContinuation) null));
                                }
                                if (str7 != null) {
                                    String strConcat3 = str4.concat(".videoBgUrl.png" /* ".videoBgUrl.png" /* ".videoBgUrl.png" /* ".videoBgUrl.png" /* cnb.z(-530686159092522L)   */);
                                    diqVar.getClass();
                                    Dispatchers$Default alcVar3 = aou.a;
                                    KotlinHelpers2.bf(akq.f, new ckx(str7, strConcat3, (kotlinx$coroutines$internal$DispatchedContinuation) null));
                                }
                                dnc.sendToast(null, 3, "下载完成" /* "下载完成" /* "下载完成" /* "下载完成" /* cnb.z(-530617439615786L)   */);
                            } else {
                                dnc.sendToast(null, 3, "暂不支持的封面类型 " /* "暂不支持的封面类型 " /* "暂不支持的封面类型 " /* "暂不支持的封面类型 " /* cnb.z(-530561605040938L)   */ + iIntValue3);
                            }
                            return true;
                        }
                    });
                    return kotlinUnitVar;
                }
                cls3 = ViewGroup.class;
                Class<ViewGroup> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                throw new IllegalStateException("HookParam instance cannot cast to "
                        .concat((clsBf3 != null ? clsBf3 : ViewGroup.class).getName()).toString());
            case 12:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new dhg(13);
                return kotlinUnitVar;
            case 13:
                bag bagVar = (bag) obj;
                String[] strArr2 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-365694990416682L)   */ };
                bagVar.getClass();
                bagVar.a = SomeStaticHelpers.ab(strArr2);
                zb zbVar = new zb();
                zbVar.k("MicroMsg.SnsCore" /* "MicroMsg.SnsCore" /* "MicroMsg.SnsCore" /* "MicroMsg.SnsCore" /* cnb.z(-366107307277098L)   */, "do SnsCore preload" /*
                                                                                                 * cnb.z(-
                                                                                                 * 366051472702250L)
                                                                                                 */);
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(i2);
                return kotlinUnitVar;
            case 15:
                bah bahVar4 = (bah) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-352943232514858L)   */ };
                bahVar4.getClass();
                bahVar4.a = SomeStaticHelpers.ab(strArr3);
                DexFinder cdjVar4 = new DexFinder();
                if (cdjVar4.f == null) {
                    cdjVar4.f = new fj(i5);
                }
                fj fjVar = cdjVar4.f;
                throwIfVar1IsNull(fjVar);
                fjVar.usingStringsType = new bqh(4);
                cdjVar4.usingStrings("addDownLoadSns" /* "addDownLoadSns" /* "addDownLoadSns" /* "addDownLoadSns" /* cnb.z(-352805793561386L)   */,
                        "com.tencent.mm.plugin.sns.model.DownloadManager" /* "com.tencent.mm.plugin.sns.model.DownloadManager" /* "com.tencent.mm.plugin.sns.model.DownloadManager" /* "com.tencent.mm.plugin.sns.model.DownloadManager" /* cnb.z(-352724189182762L)   */);
                bahVar4.d = cdjVar4;
                return kotlinUnitVar;
            case 16:
                View view2 = (View) obj;
                View viewK = StaticHelpers6.k(view2, R.layout.module_dialog_sns_info, null, false);
                int i12 = R.id.moduleDialogCbSnsInfoHideGroupIcon;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogCbSnsInfoHideGroupIcon);
                if (materialCheckBox != null) {
                    i12 = R.id.moduleDialogEdtSnsInfoTextFormat;
                    TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtSnsInfoTextFormat);
                    if (textInputEditText != null) {
                        i12 = R.id.moduleDialogEdtSnsInfoTextPlaceholders;
                        MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtSnsInfoTextPlaceholders);
                        if (materialTextView != null) {
                            i12 = R.id.moduleDialogEdtSnsInfoTimeFormat;
                            TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtSnsInfoTimeFormat);
                            if (textInputEditText2 != null) {
                                i12 = R.id.moduleDialogInputSnsInfoTextFormat;
                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogInputSnsInfoTextFormat)) != null) {
                                    i12 = R.id.moduleDialogInputSnsInfoTimeFormat;
                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogInputSnsInfoTimeFormat)) != null) {
                                        bqr bqrVar = new bqr((LinearLayout) viewK, materialCheckBox, textInputEditText,
                                                materialTextView, textInputEditText2);
                                        textInputEditText.setText(djf.a.o());
                                        textInputEditText2.setText(djg.a.o());
                                        materialCheckBox.setChecked(dje.a.i());
                                        materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                                "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* cnb.z(-533014031366954L)   */);
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
                                        bzyVar2.t("保存" /* "保存" /* "保存" /* "保存" /* cnb.z(-532395556076330L)   */, new amw(new cfx(bqrVar, 15), 0));
                                        bzyVar2.s("重置" /* "重置" /* "重置" /* "重置" /* cnb.z(-532399851043626L)   */, new amw(new Function1$VarIsInt$2(25), 2));
                                        bjs.x((3 & 2) != 0 ? new amd(i14) : obj4, bzyVar2, "取消" /*
                                                                                                 * cnb.z(-
                                                                                                 * 47455093652266L)
                                                                                                 */);
                                        LinearLayout linearLayout2 = bqrVar.b;
                                        if (linearLayout2 != null) {
                                            egVar2.r = linearLayout2;
                                        }
                                        bzyVar2.i().show();
                                        return kotlinUnitVar;
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-660703409077034L)   */.concat(viewK.getResources().getResourceName(i12)));
            case 17:
                bah bahVar5 = (bah) obj;
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.usingStrings("realTimeUpdate" /* "realTimeUpdate" /* "realTimeUpdate" /* "realTimeUpdate" /* cnb.z(-534272456784682L)   */,
                        "com.tencent.mm.plugin.sns.ui.improve.item.ImproveTimelineItemMeasure" /*
                                                                                                * cnb.z(-
                                                                                                * 534208032275242L)
                                                                                                */);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return kotlinUnitVar;
            case 18:
                int i15 = 0;
                SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(((HookParam) obj).getThisObject());
                FieldResolver fieldResolverVarR3 = bmuVarBi.r();
                djb djbVar = djb.a;
                fieldResolverVarR3.fieldType = StaticHelpers7.toDexMethod(djbVar).getDeclaringClass();
                Object objD = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue();
                throwIfVar1IsNull(objD);
                Object objInvoke = StaticHelpers7.toDexMethod(djbVar).invoke(objD, null);
                throwIfVar1IsNull(objInvoke);
                MethodResolver methodResolverVarT2 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.name = "getPublishTimeText" /* "getPublishTimeText" /* "getPublishTimeText" /* "getPublishTimeText" /* cnb.z(-532193692613418L)   */;
                Object objJ2 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).j(new Object[0]);
                throwIfVar1IsNull(objJ2);
                TextView textView = (TextView) objJ2;
                djh.a.getClass();
                textView.setText(dnr.bo(djh.n(objInvoke), "${originalText}" /* "${originalText}" /* "${originalText}" /* "${originalText}" /* cnb.z(-532627484310314L)   */,
                        textView.getText().toString()));
                MethodResolver methodResolverVarT3 = bmuVarBi.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT3.name = "getGroupImageStub" /* "getGroupImageStub" /* "getGroupImageStub" /* "getGroupImageStub" /* cnb.z(-532558764833578L)   */;
                View view3 = (View) ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).j(new Object[0]);
                if (view3 != null && (view3 instanceof ImageView)) {
                    ((ImageView) view3).setVisibility(dje.a.i() ? 8 : 0);
                }
                return kotlinUnitVar;
            case 19:
                HookParam hookParam4 = (HookParam) obj;
                int i16 = 0;
                SyntheticPileOfMess bmuVarBi2 = dqc.getWrapperConfiguration(hookParam4.getThisObject());
                try {
                    objX6 = hookParam4.getArgs()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = FastKV.getFailureFromException(th6);
                }
                obj = objX6 instanceof Failure ? null : objX6;
                throwIfVar1IsNull(obj);
                FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(obj).r();
                fieldResolverVarR4.fieldType = "com.tencent.mm.plugin.sns.storage.SnsInfo" /* "com.tencent.mm.plugin.sns.storage.SnsInfo" /* "com.tencent.mm.plugin.sns.storage.SnsInfo" /* "com.tencent.mm.plugin.sns.storage.SnsInfo" /* cnb.z(-532498635291434L)   */;
                Object objD2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue();
                throwIfVar1IsNull(objD2);
                MethodResolver methodResolverVarT4 = bmuVarBi2.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT4.name = "getPublishTimeText" /* "getPublishTimeText" /* "getPublishTimeText" /* "getPublishTimeText" /* cnb.z(-533984693975850L)   */;
                Object objJ3 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT4)).j(new Object[0]);
                throwIfVar1IsNull(objJ3);
                TextView textView2 = (TextView) objJ3;
                djh.a.getClass();
                textView2.setText(dnr.bo(djh.n(objD2), "${originalText}" /* "${originalText}" /* "${originalText}" /* "${originalText}" /* cnb.z(-533851549989674L)   */,
                        textView2.getText().toString()));
                MethodResolver methodResolverVarT5 = bmuVarBi2.getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT5.name = "getGroupImageStub" /* "getGroupImageStub" /* "getGroupImageStub" /* "getGroupImageStub" /* cnb.z(-534332586326826L)   */;
                View view4 = (View) ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT5)).j(new Object[0]);
                if (view4 != null && (view4 instanceof ImageView)) {
                    ((ImageView) view4).setVisibility(dje.a.i() ? 8 : 0);
                }
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(17);
                return kotlinUnitVar;
            case 21:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(i3);
                return kotlinUnitVar;
            case 22:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(i4);
                return kotlinUnitVar;
            case 23:
                bah bahVar6 = (bah) obj;
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("updateStruct" /* "updateStruct" /* "updateStruct" /* "updateStruct" /* cnb.z(-533636801624874L)   */,
                        "com.tencent.mm.plugin.sns.ui.item.improve.TimelineItemMeasure" /* "com.tencent.mm.plugin.sns.ui.item.improve.TimelineItemMeasure" /* "com.tencent.mm.plugin.sns.ui.item.improve.TimelineItemMeasure" /* "com.tencent.mm.plugin.sns.ui.item.improve.TimelineItemMeasure" /* cnb.z(-533563787180842L)   */);
                bahVar6.getClass();
                bahVar6.d = cdjVar6;
                return kotlinUnitVar;
            case 24:
                bah bahVar7 = (bah) obj;
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("getInfo" /* "getInfo" /* "getInfo" /* "getInfo" /* cnb.z(-533396283456298L)   */,
                        "com.tencent.mm.plugin.sns.ui.improve.repository.ImproveListItem" /* "com.tencent.mm.plugin.sns.ui.improve.repository.ImproveListItem" /* "com.tencent.mm.plugin.sns.ui.improve.repository.ImproveListItem" /* "com.tencent.mm.plugin.sns.ui.improve.repository.ImproveListItem" /* cnb.z(-533361923717930L)   */);
                bahVar7.getClass();
                bahVar7.d = cdjVar7;
                return kotlinUnitVar;
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dhg(26);
                return kotlinUnitVar;
            case 26:
                bah bahVar8 = (bah) obj;
                DexFinder cdjVar8 = new DexFinder();
                Class<String> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar8.q(clsBf4 != null ? clsBf4 : String.class);
                cdjVar8.usingStrings("getByLocalId" /* "getByLocalId" /* "getByLocalId" /* "getByLocalId" /* cnb.z(-376969279568682L)   */,
                        "com.tencent.mm.plugin.sns.storage.SnsInfoStorage" /* "com.tencent.mm.plugin.sns.storage.SnsInfoStorage" /* "com.tencent.mm.plugin.sns.storage.SnsInfoStorage" /* "com.tencent.mm.plugin.sns.storage.SnsInfoStorage" /* cnb.z(-376947804732202L)   */);
                bahVar8.getClass();
                bahVar8.d = cdjVar8;
                return kotlinUnitVar;
            case 27:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX7 = hookParam5.getArgs()[0];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = FastKV.getFailureFromException(th7);
                }
                obj = objX7 instanceof Failure ? null : objX7;
                throwIfVar1IsNull(obj);
                ContextMenu contextMenu = (ContextMenu) obj;
                for (boa boaVar : djo.b) {
                    try {
                        for (djl djlVar : boaVar.a()) {
                            contextMenu.add(R.id.MenuItem_Group, djlVar.a, 0, djlVar.b);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList2 = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-55310588836650L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                boaVar instanceof SwitchHook ? ((SwitchHook) boaVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 56895431768874L)
                                                                                                               */,
                                -56805237455658L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 28:
                HookParam hookParam6 = (HookParam) obj;
                hookParam6.getClass();
                try {
                    objX8 = hookParam6.getArgs()[0];
                    if (objX8 == null) {
                        objX8 = null;
                    }
                } catch (Throwable th8) {
                    objX8 = FastKV.getFailureFromException(th8);
                }
                obj = objX8 instanceof Failure ? null : objX8;
                throwIfVar1IsNull(obj);
                MenuItem menuItem = (MenuItem) obj;
                for (boa boaVar2 : djo.b) {
                    try {
                        int i17 = 0;
                        FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(hookParam6.getThisObject()).r();
                        fieldResolverVarR5.fieldType = dal.getKClassFromClass(cls2);
                        Object objE5 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR5.resolve())).getValue_();
                        throwIfVar1IsNull(objE5);
                        Activity activity3 = (Activity) objE5;
                        FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(hookParam6.getThisObject()).r();
                        StaticHelpers2.addAllFromVar2ToVar1(fieldResolverVarR6.modifiersNot, (AccessModifierEnum[]) Arrays.copyOf(new AccessModifierEnum[] { AccessModifierEnum.FINAL}, 1));
                        fieldResolverVarR6.fieldType = dal.getKClassFromClass(cls);
                        Object objE6 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR6.resolve())).getValue_();
                        throwIfVar1IsNull(objE6);
                        djj.a.getClass();
                        Object objB = djj.b((String) objE6);
                        FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(hookParam6.getThisObject()).r();
                        fieldResolverVarR7.fieldType = "com.tencent.mm.protocal.protobuf.TimeLineObject" /* "com.tencent.mm.protocal.protobuf.TimeLineObject" /* "com.tencent.mm.protocal.protobuf.TimeLineObject" /* "com.tencent.mm.protocal.protobuf.TimeLineObject" /* cnb.z(-56770877717290L)   */;
                        Object objD3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR7.resolve())).getValue();
                        throwIfVar1IsNull(objD3);
                        for (djl djlVar2 : boaVar2.a()) {
                            if (menuItem.getItemId() == djlVar2.a) {
                                djlVar2.c.b(activity3, objB, objD3);
                            }
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList3 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-57114475100970L)   */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                boaVar2 instanceof SwitchHook ? ((SwitchHook) boaVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 57050050591530L)
                                                                                                                 */,
                                -57028575755050L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            default:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new djk(2);
                return kotlinUnitVar;
        }
    }
}
