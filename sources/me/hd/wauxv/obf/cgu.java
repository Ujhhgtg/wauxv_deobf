package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cgu implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ cgu(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, IOException {
        Class cls;
        Object objX;
        Object objX2;
        Class cls2;
        Class cls3;
        int i = this.a;
        cls = String.class;
        int i2 = 1;
        int i3 = 2;
        int i4 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cgy.a.getClass();
                cdjVar.setDeclaredClassName(StaticHelpers7.toDexClass(cgv.a));
                cdjVar.usingStrings("MsgInfo processAddMsg insert db error" /* "MsgInfo processAddMsg insert db error" /* "MsgInfo processAddMsg insert db error" /* cnb.z(-371609160383274L)  */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 1:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-369904058366762L)  */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* "MicroMsg.MsgInfoStorage" /* cnb.z(-369805274118954L)  */, "deleted dirty msg ,count is %d" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 371351462345514L)
                                                                                                                    */);
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 2:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                cgy.a.getClass();
                cdjVar2.setDeclaredClassName(StaticHelpers7.toDexClass(cgv.a));
                cdjVar2.p(new IntRange(2, 3, 1));
                cdjVar2.usingStrings("notifymessage" /* "notifymessage" /* "notifymessage" /* cnb.z(-371201138490154L)  */, "msgId=?" /* "msgId=?" /* "msgId=?" /* cnb.z(-371123829078826L)  */,
                        "update" /* "update" /* "update" /* cnb.z(-371089469340458L)  */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 3:
                ArrayList arrayList = new ArrayList();
                Cursor cursorAc = arj.ac("SELECT username FROM rconversation" /* "SELECT username FROM rconversation" /* "SELECT username FROM rconversation" /* cnb.z(-524896543177514L)  */);
                while (cursorAc.moveToNext()) {
                    try {
                        arrayList.add(cursorAc.getString(0));
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            cnh.m(cursorAc, th);
                            throw th2;
                        }
                    }
                }
                cursorAc.close();
                agp agpVar = agp.a;
                String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
                String strZ = "" /* "" /* "" /* cnb.z(-524763399191338L)  */;
                agpVar.getClass();
                agp.d(strZ, strArr2);
                return kotlinUnitVar;
            case 4:
                ArrayList arrayList2 = new ArrayList();
                Cursor cursorAc2 = arj.ac("SELECT username FROM rconversation" /* "SELECT username FROM rconversation" /* "SELECT username FROM rconversation" /* cnb.z(-524578715597610L)  */);
                while (cursorAc2.moveToNext()) {
                    try {
                        arrayList2.add(cursorAc2.getString(0));
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            cnh.m(cursorAc2, th3);
                            throw th4;
                        }
                    }
                }
                cursorAc2.close();
                agp agpVar2 = agp.a;
                String[] strArr3 = (String[]) arrayList2.toArray(new String[0]);
                String strZ2 = "hidden_conv_parent" /* "hidden_conv_parent" /* "hidden_conv_parent" /* cnb.z(-524995327425322L)  */;
                agpVar2.getClass();
                agp.d(strZ2, strArr3);
                return kotlinUnitVar;
            case 5:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_msg_tv_color, null, false);
                int i5 = R.id.moduleDialogEdtMsgTvColorLeftDarkTextColor;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogEdtMsgTvColorLeftDarkTextColor);
                if (textInputEditText != null) {
                    i5 = R.id.moduleDialogEdtMsgTvColorLeftLightTextColor;
                    TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtMsgTvColorLeftLightTextColor);
                    if (textInputEditText2 != null) {
                        i5 = R.id.moduleDialogEdtMsgTvColorRightDarkTextColor;
                        TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtMsgTvColorRightDarkTextColor);
                        if (textInputEditText3 != null) {
                            i5 = R.id.moduleDialogEdtMsgTvColorRightLightTextColor;
                            TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtMsgTvColorRightLightTextColor);
                            if (textInputEditText4 != null) {
                                i5 = R.id.moduleDialogInputMsgTvColorLeftDarkTextColor;
                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogInputMsgTvColorLeftDarkTextColor)) != null) {
                                    i5 = R.id.moduleDialogInputMsgTvColorLeftLightTextColor;
                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogInputMsgTvColorLeftLightTextColor)) != null) {
                                        i5 = R.id.moduleDialogInputMsgTvColorRightDarkTextColor;
                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogInputMsgTvColorRightDarkTextColor)) != null) {
                                            i5 = R.id.moduleDialogInputMsgTvColorRightLightTextColor;
                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogInputMsgTvColorRightLightTextColor)) != null) {
                                                LinearLayout linearLayout = (LinearLayout) viewK;
                                                ceo ceoVar = new ceo(linearLayout, textInputEditText,
                                                        textInputEditText2, textInputEditText3, textInputEditText4, 2);
                                                textInputEditText2.setText(che.a.o());
                                                textInputEditText4.setText(chg.a.o());
                                                textInputEditText.setText(chd.a.o());
                                                textInputEditText3.setText(chf.a.o());
                                                bzy bzyVar = new bzy(view.getContext());
                                                eg egVar = (eg) bzyVar.d;
                                                chh.a.getClass();
                                                egVar.d = chh.c;
                                                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-450138342423338L)  */,
                                                        new amw(new cfx(ceoVar, i3), 0));
                                                bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-450142637390634L)  */, new amw(new Function1$VarIsInt$2(9), 2));
                                                bjs.x((3 & 2) != 0 ? new amd(i2) : null, bzyVar, "取消" /*
                                                                                                       * cnb.z(-
                                                                                                       * 47455093652266L)
                                                                                                       */);
                                                if (linearLayout != null) {
                                                    egVar.r = linearLayout;
                                                }
                                                bzyVar.i().show();
                                                return kotlinUnitVar;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663589627099946L)  */.concat(viewK.getResources().getResourceName(i5)));
            case 6:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[2];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th5) {
                    objX = FastKV.getFailureFromException(th5);
                }
                if (objX instanceof Failure) {
                    objX = null;
                }
                String str = (String) objX;
                if (str == null) {
                    str = "";
                }
                if (str.equals(".ui.timeline.preload.ui.TmplWebViewMMUI" /* ".ui.timeline.preload.ui.TmplWebViewMMUI" /* ".ui.timeline.preload.ui.TmplWebViewMMUI" /* cnb.z(-517182781913898L)  */)) {
                    try {
                        objX2 = hookParam.getArgs()[3];
                        if (objX2 == null) {
                            objX2 = null;
                        }
                    } catch (Throwable th6) {
                        objX2 = FastKV.getFailureFromException(th6);
                    }
                    Object obj2 = objX2 instanceof Failure ? null : objX2;
                    throwIfVar1IsNull(obj2);
                    Intent intent = (Intent) obj2;
                    intent.addFlags(Opcodes.ASM8);
                    intent.addFlags(134217728);
                }
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cgu(8);
                return kotlinUnitVar;
            case 8:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("MicroMsg.PluginHelper" /* "MicroMsg.PluginHelper" /* "MicroMsg.PluginHelper" /* cnb.z(-518660250663722L)  */, "start multi webview!!!!!!!!!" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 518548581514026L)
                                                                                                                  */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 9:
                int i6 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
                fieldResolverVarR.name = "field_type" /* "field_type" /* "field_type" /* cnb.z(-478429292002090L)  */;
                Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
                throwIfVar1IsNull(objE);
                if (((Number) objE).intValue() == 3) {
                    FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj).r();
                    fieldResolverVarR2.name = "field_favProto" /* "field_favProto" /* "field_favProto" /* cnb.z(-478416407100202L)  */;
                    Object objD = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue();
                    throwIfVar1IsNull(objD);
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.name = "getData" /* "getData" /* "getData" /* cnb.z(-478334802721578L)  */;
                    Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT)).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ);
                    cwd cwdVar = cwd.a;
                    cwdVar.getClass();
                    ays aysVar = ((ayt) cwdVar.c(ayt.Companion.serializer(), (byte[]) objJ)).b;
                    String string = aysVar.f;
                    String str2 = aysVar.e;
                    if (string == null) {
                        String strZ3 = cmz.z();
                        String strValueOf = String
                                .valueOf(str2.hashCode() & com.android.dx.io.Opcodes.CONST_METHOD_TYPE);
                        StringBuilder sbY = StaticHelpers6.toSb(strZ3);
                        sbY.append("/favorite/" /* "/favorite/" /* "/favorite/" /* cnb.z(-478300442983210L)  */);
                        sbY.append(strValueOf);
                        sbY.append('/');
                        sbY.append(str2);
                        sbY.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                        sbY.append(aysVar.b);
                        string = sbY.toString();
                    }
                    if (new File(string).exists()) {
                        StaticAndroidHelpers.runOnUiThread(cie.a, new cid(string, aysVar, i4));
                    } else {
                        dnc.sendToast(null, 3, "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* cnb.z(-478837313895210L)  */);
                    }
                } else {
                    dnc.sendToast(null, 3, "暂不支持的转发类型" /* "暂不支持的转发类型" /* "暂不支持的转发类型" /* cnb.z(-478704169909034L)  */);
                }
                return kotlinUnitVar;
            case 10:
                int i7 = 0;
                FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).r();
                fieldResolverVarR3.name = "field_type" /* "field_type" /* "field_type" /* cnb.z(-475856606591786L)  */;
                Integer num = (Integer) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
                if (num != null && num.intValue() == 3) {
                    FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(obj).r();
                    fieldResolverVarR4.name = "field_favProto" /* "field_favProto" /* "field_favProto" /* cnb.z(-475826541820714L)  */;
                    Object objD2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue();
                    throwIfVar1IsNull(objD2);
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objD2).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.name = "getData" /* "getData" /* "getData" /* cnb.z(-475212361497386L)  */;
                    Object objJ2 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ2);
                    cwd cwdVar2 = cwd.a;
                    cwdVar2.getClass();
                    ays aysVar2 = ((ayt) cwdVar2.c(ayt.Companion.serializer(), (byte[]) objJ2)).b;
                    String string2 = aysVar2.f;
                    String str3 = aysVar2.e;
                    if (string2 == null) {
                        String strZ4 = cmz.z();
                        String strValueOf2 = String
                                .valueOf(str3.hashCode() & com.android.dx.io.Opcodes.CONST_METHOD_TYPE);
                        StringBuilder sbY2 = StaticHelpers6.toSb(strZ4);
                        sbY2.append("/favorite/" /* "/favorite/" /* "/favorite/" /* cnb.z(-475178001759018L)  */);
                        sbY2.append(strValueOf2);
                        sbY2.append('/');
                        sbY2.append(str3);
                        sbY2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                        sbY2.append(aysVar2.b);
                        string2 = sbY2.toString();
                    }
                    if (new File(string2).exists()) {
                        StaticAndroidHelpers.runOnUiThread(cif.a, new cid(string2, aysVar2, i3));
                    } else {
                        dnc.sendToast(null, 3, "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* cnb.z(-475147936987946L)  */);
                    }
                } else {
                    dnc.sendToast(null, 3, "暂不支持的转发类型" /* "暂不支持的转发类型" /* "暂不支持的转发类型" /* cnb.z(-475031972870954L)  */);
                }
                return kotlinUnitVar;
            case 11:
                ahx ahxVar = (ahx) obj;
                throwIfVar1IsNull(ahxVar, "$this$initializer");
                return new cip(aye.q(ahxVar));
            case 12:
                Context context = (Context) obj;
                throwIfVar1IsNull(context, "it");
                if (context instanceof ContextWrapper) {
                    return ((ContextWrapper) context).getBaseContext();
                }
                return null;
            case 13:
                cjg cjgVar = (cjg) obj;
                throwIfVar1IsNull(cjgVar, "destination");
                cji cjiVar = cjgVar.h;
                if (cjiVar == null || cjiVar.b.c != cjgVar.g.a) {
                    return null;
                }
                return cjiVar;
            case 14:
                cjg cjgVar2 = (cjg) obj;
                throwIfVar1IsNull(cjgVar2, "destination");
                cji cjiVar2 = cjgVar2.h;
                if (cjiVar2 == null || cjiVar2.b.c != cjgVar2.g.a) {
                    return null;
                }
                return cjiVar2;
            case 15:
                cjg cjgVar3 = (cjg) obj;
                throwIfVar1IsNull(cjgVar3, "it");
                return Integer.valueOf(cjgVar3.g.a);
            case 16:
                throwIfVar1IsNull((ahx) obj, "$this$initializer");
                return new ciy();
            case 17:
                Context context2 = (Context) obj;
                throwIfVar1IsNull(context2, "it");
                ContextWrapper contextWrapper = context2 instanceof ContextWrapper ? (ContextWrapper) context2 : null;
                if (contextWrapper != null) {
                    return contextWrapper.getBaseContext();
                }
                return null;
            case 18:
                Context context3 = (Context) obj;
                throwIfVar1IsNull(context3, "it");
                if (context3 instanceof Activity) {
                    return (Activity) context3;
                }
                return null;
            case 19:
                cjg cjgVar4 = (cjg) obj;
                throwIfVar1IsNull(cjgVar4, "it");
                return cjgVar4.h;
            case 20:
                cjg cjgVar5 = (cjg) obj;
                throwIfVar1IsNull(cjgVar5, "it");
                if (!(cjgVar5 instanceof cji)) {
                    return null;
                }
                cji cjiVar3 = (cji) cjgVar5;
                return cjiVar3.p(cjiVar3.b.c);
            case 21:
                View view2 = (View) obj;
                throwIfVar1IsNull(view2, "it");
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            case 22:
                View view3 = (View) obj;
                throwIfVar1IsNull(view3, "it");
                Object tag = view3.getTag(R.id.nav_controller_view_tag);
                if (tag instanceof WeakReference) {
                    return (cjl) ((WeakReference) tag).get();
                }
                if (tag instanceof cjl) {
                    return (cjl) tag;
                }
                return null;
            case 23:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new cgu(24);
                findDexClassMethodDslWrapperVar.onMethodCallback = new cgu(25);
                return kotlinUnitVar;
            case 24:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.NetSceneAddChatRoomMember" /* "MicroMsg.NetSceneAddChatRoomMember" /* "MicroMsg.NetSceneAddChatRoomMember" /* cnb.z(-112828790864682L)  */,
                        "/cgi-bin/micromsg-bin/addchatroommember" /* "/cgi-bin/micromsg-bin/addchatroommember" /* "/cgi-bin/micromsg-bin/addchatroommember" /* cnb.z(-113245402692394L)  */);
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 25:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar4 = new DexFinder();
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cls2 = List.class;
                Class<List> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cls2 = clsBf2 != null ? clsBf2 : List.class;
                Class<String> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cls = clsBf3 != null ? clsBf3 : String.class;
                cls3 = Object.class;
                Class<Object> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cdjVar4.q(clsBf, cls2, cls, clsBf4 != null ? clsBf4 : Object.class);
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 26:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar2 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar2.onClassCallback = new cgu(27);
                findDexClassMethodDslWrapperVar2.onMethodCallback = new cgu(28);
                return kotlinUnitVar;
            case 27:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* cnb.z(-112304804854570L)  */ };
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.NetSceneBeforeTransfer" /* "MicroMsg.NetSceneBeforeTransfer" /* "MicroMsg.NetSceneBeforeTransfer" /* cnb.z(-112669877074730L)  */,
                        "/cgi-bin/mmpay-bin/beforetransfer" /* "/cgi-bin/mmpay-bin/beforetransfer" /* "/cgi-bin/mmpay-bin/beforetransfer" /* cnb.z(-112532438121258L)  */);
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 28:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                Class<String> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf5 == null) {
                    clsBf5 = cls;
                }
                Class<String> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar5.q(clsBf5, clsBf6 != null ? clsBf6 : String.class);
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return kotlinUnitVar;
            default:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar3 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar3.onClassCallback = new clo(i4);
                findDexClassMethodDslWrapperVar3.onMethodCallback = new clo(i2);
                return kotlinUnitVar;
        }
    }
}
