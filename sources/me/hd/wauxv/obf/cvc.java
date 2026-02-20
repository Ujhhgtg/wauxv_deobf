package me.hd.wauxv.obf;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;
import me.hd.wauxv.data.bean.MsgInfoBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cvc implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ cvc(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, JSONException, InvocationTargetException {
        Class cls;
        Object objX;
        Object obj2;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Object objX7;
        Object objX8;
        Object objX9;
        Object objX10;
        Object objX11;
        Object objX12;
        Object objX13;
        Object objX14;
        Object objX15;
        Object objX16;
        Object objX17;
        Object objX18;
        Object objX19;
        Object objX20;
        Object objX21;
        Object objX22;
        Class cls2;
        Object objX23;
        Object objX24;
        Object objX25;
        Class cls3;
        Object objX26;
        Object objX27;
        int i = this.a;
        int i2 = 3;
        int i3 = 9;
        cls = String.class;
        Class cls4 = Integer.TYPE;
        int i4 = 4;
        int i5 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cdjVar.o(cvh.a.b());
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar.q(clsBf != null ? clsBf : String.class);
                cdjVar.usingStrings("Preference does not have a key assigned." /* "Preference does not have a key assigned." /* "Preference does not have a key assigned." /* cnb.z(-101232379165482L)  */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 1:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[2];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                obj2 = objX instanceof Failure ? null : objX;
                throwIfVar1IsNull(obj2);
                KeyEvent keyEvent = (KeyEvent) obj2;
                if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0) {
                    int i6 = 0;
                    FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam);
                    fieldResolverVarAa.b = new cvc(i2);
                    Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue();
                    throwIfVar1IsNull(objD);
                    FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objD).r();
                    uq.a.getClass();
                    fieldResolverVarR.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-75127567940394L)  */);
                    Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue_();
                    throwIfVar1IsNull(objE);
                    FrameLayout frameLayout = (FrameLayout) objE;
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(frameLayout).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.name = "getLastText" /* "getLastText" /* "getLastText" /* cnb.z(-76622216559402L)  */;
                    Object objJ = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ);
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(frameLayout).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.name = "getLastQuoteMsgId" /* "getLastQuoteMsgId" /* "getLastQuoteMsgId" /* cnb.z(-76536317213482L)  */;
                    Object objJ2 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ2);
                    long jLongValue = ((Number) objJ2).longValue();
                    if (((String) objJ).length() == 0 && jLongValue != 0) {
                        StaticHelpers7.toDexMethod(up.a).invoke(frameLayout, Boolean.FALSE, Boolean.TRUE);
                    }
                }
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(i4);
                return kotlinUnitVar;
            case 3:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(), "com.tencent.mm.pluginsdk.ui.chat." /*
                                                                                                            * cnb.z(-
                                                                                                            * 472016905829162L)
                                                                                                            */, false));
            case 4:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.pluginsdk.ui.chat" /* "com.tencent.mm.pluginsdk.ui.chat" /* "com.tencent.mm.pluginsdk.ui.chat" /* cnb.z(-460343184718634L)  */ };
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.a = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.s("onKey" /* "onKey" /* "onKey" /* cnb.z(-460201450797866L)  */);
                cdjVar2.usingStrings("ChatFooterKtHelper" /* "ChatFooterKtHelper" /* "ChatFooterKtHelper" /* cnb.z(-460158501124906L)  */, "supportAutoComplete err" /*
                                                                                                          * cnb.z(-
                                                                                                          * 460661012298538L)
                                                                                                          */);
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 5:
                StaticAndroidHelpers.runOnUiThread(cxb.b, new cwz((ConversationBean) obj, i5));
                return kotlinUnitVar;
            case 6:
                HookParam hookParam2 = (HookParam) obj;
                if (cnb.ab(ewk.j) || cnb.ac(ewh.j)) {
                    hookParam2.getClass();
                    try {
                        objX2 = hookParam2.getArgs()[0];
                        if (objX2 == null) {
                            objX2 = null;
                        }
                    } catch (Throwable th2) {
                        objX2 = FastKV.getFailureFromException(th2);
                    }
                    Object obj3 = objX2 instanceof Failure ? null : objX2;
                    try {
                        objX3 = hookParam2.getArgs()[2];
                        if (objX3 == null) {
                            objX3 = null;
                        }
                    } catch (Throwable th3) {
                        objX3 = FastKV.getFailureFromException(th3);
                    }
                    Object obj4 = objX3 instanceof Failure ? null : objX3;
                    try {
                        objX4 = hookParam2.getArgs()[3];
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
                    View view = (View) objX4;
                    try {
                        objX5 = hookParam2.getArgs()[4];
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
                    long jLongValue2 = ((Number) objX5).longValue();
                    try {
                        objX6 = hookParam2.getArgs()[5];
                        if (objX6 == null) {
                            objX6 = null;
                        }
                    } catch (Throwable th6) {
                        objX6 = FastKV.getFailureFromException(th6);
                    }
                    if (objX6 instanceof Failure) {
                        objX6 = null;
                    }
                    throwIfVar1IsNull(objX6);
                    String str = (String) objX6;
                    try {
                        objX7 = hookParam2.getArgs()[6];
                        if (objX7 == null) {
                            objX7 = null;
                        }
                    } catch (Throwable th7) {
                        objX7 = FastKV.getFailureFromException(th7);
                    }
                    Object obj5 = objX7 instanceof Failure ? null : objX7;
                    cgy.a.getClass();
                    StaticHelpers7.toDexMethod(cxf.a).invoke(null, obj3, obj4, cgy.b(jLongValue2), view, Long.valueOf(jLongValue2), str,
                            obj5);
                    hookParam2.setResult(null);
                } else if (cnb.ab(ewk.g) || cnb.ac(ewh.f)) {
                    hookParam2.getClass();
                    try {
                        objX8 = hookParam2.getArgs()[0];
                        if (objX8 == null) {
                            objX8 = null;
                        }
                    } catch (Throwable th8) {
                        objX8 = FastKV.getFailureFromException(th8);
                    }
                    Object obj6 = objX8 instanceof Failure ? null : objX8;
                    try {
                        objX9 = hookParam2.getArgs()[2];
                        if (objX9 == null) {
                            objX9 = null;
                        }
                    } catch (Throwable th9) {
                        objX9 = FastKV.getFailureFromException(th9);
                    }
                    Object obj7 = objX9 instanceof Failure ? null : objX9;
                    try {
                        objX10 = hookParam2.getArgs()[3];
                        if (objX10 == null) {
                            objX10 = null;
                        }
                    } catch (Throwable th10) {
                        objX10 = FastKV.getFailureFromException(th10);
                    }
                    if (objX10 instanceof Failure) {
                        objX10 = null;
                    }
                    throwIfVar1IsNull(objX10);
                    View view2 = (View) objX10;
                    try {
                        objX11 = hookParam2.getArgs()[4];
                        if (objX11 == null) {
                            objX11 = null;
                        }
                    } catch (Throwable th11) {
                        objX11 = FastKV.getFailureFromException(th11);
                    }
                    if (objX11 instanceof Failure) {
                        objX11 = null;
                    }
                    throwIfVar1IsNull(objX11);
                    long jLongValue3 = ((Number) objX11).longValue();
                    try {
                        objX12 = hookParam2.getArgs()[5];
                        if (objX12 == null) {
                            objX12 = null;
                        }
                    } catch (Throwable th12) {
                        objX12 = FastKV.getFailureFromException(th12);
                    }
                    if (objX12 instanceof Failure) {
                        objX12 = null;
                    }
                    throwIfVar1IsNull(objX12);
                    String str2 = (String) objX12;
                    try {
                        objX13 = hookParam2.getArgs()[6];
                        if (objX13 == null) {
                            objX13 = null;
                        }
                    } catch (Throwable th13) {
                        objX13 = FastKV.getFailureFromException(th13);
                    }
                    Object obj8 = objX13 instanceof Failure ? null : objX13;
                    try {
                        objX14 = hookParam2.getArgs()[7];
                        if (objX14 == null) {
                            objX14 = null;
                        }
                    } catch (Throwable th14) {
                        objX14 = FastKV.getFailureFromException(th14);
                    }
                    if (objX14 instanceof Failure) {
                        objX14 = null;
                    }
                    throwIfVar1IsNull(objX14);
                    cgy.a.getClass();
                    StaticHelpers7.toDexMethod(cxf.a).invoke(null, obj6, obj7, cgy.b(jLongValue3), view2, Long.valueOf(jLongValue3), str2,
                            obj8, (Boolean) objX14);
                    hookParam2.setResult(null);
                } else {
                    hookParam2.getClass();
                    try {
                        objX15 = hookParam2.getArgs()[0];
                        if (objX15 == null) {
                            objX15 = null;
                        }
                    } catch (Throwable th15) {
                        objX15 = FastKV.getFailureFromException(th15);
                    }
                    Object obj9 = objX15 instanceof Failure ? null : objX15;
                    try {
                        objX16 = hookParam2.getArgs()[2];
                        if (objX16 == null) {
                            objX16 = null;
                        }
                    } catch (Throwable th16) {
                        objX16 = FastKV.getFailureFromException(th16);
                    }
                    Object obj10 = objX16 instanceof Failure ? null : objX16;
                    try {
                        objX17 = hookParam2.getArgs()[3];
                        if (objX17 == null) {
                            objX17 = null;
                        }
                    } catch (Throwable th17) {
                        objX17 = FastKV.getFailureFromException(th17);
                    }
                    if (objX17 instanceof Failure) {
                        objX17 = null;
                    }
                    throwIfVar1IsNull(objX17);
                    View view3 = (View) objX17;
                    try {
                        objX18 = hookParam2.getArgs()[4];
                        if (objX18 == null) {
                            objX18 = null;
                        }
                    } catch (Throwable th18) {
                        objX18 = FastKV.getFailureFromException(th18);
                    }
                    if (objX18 instanceof Failure) {
                        objX18 = null;
                    }
                    throwIfVar1IsNull(objX18);
                    long jLongValue4 = ((Number) objX18).longValue();
                    try {
                        objX19 = hookParam2.getArgs()[5];
                        if (objX19 == null) {
                            objX19 = null;
                        }
                    } catch (Throwable th19) {
                        objX19 = FastKV.getFailureFromException(th19);
                    }
                    Object obj11 = objX19 instanceof Failure ? null : objX19;
                    try {
                        objX20 = hookParam2.getArgs()[6];
                        if (objX20 == null) {
                            objX20 = null;
                        }
                    } catch (Throwable th20) {
                        objX20 = FastKV.getFailureFromException(th20);
                    }
                    if (objX20 instanceof Failure) {
                        objX20 = null;
                    }
                    throwIfVar1IsNull(objX20);
                    cgy.a.getClass();
                    StaticHelpers7.toDexMethod(cxf.a).invoke(null, obj9, obj10, cgy.b(jLongValue4), view3, Long.valueOf(jLongValue4), obj11,
                            (Boolean) objX20);
                    hookParam2.setResult(null);
                }
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(10);
                return kotlinUnitVar;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(i3);
                return kotlinUnitVar;
            case 9:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-461640264842026L)  */ };
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* "MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* "MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* cnb.z(-460965954976554L)  */,
                        "handleItemClickToPositionEvent,quotedMsg is null!" /* "handleItemClickToPositionEvent,quotedMsg is null!" /* "handleItemClickToPositionEvent,quotedMsg is null!" /* cnb.z(-460746911644458L)  */);
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 10:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-459956637661994L)  */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* "MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* "MicroMsg.msgquote.QuoteMsgSourceClickLogic" /* cnb.z(-461481351052074L)  */,
                        "handleItemClickEvent,quotedMsg is null!" /* "handleItemClickEvent,quotedMsg is null!" /* "handleItemClickEvent,quotedMsg is null!" /* cnb.z(-461262307719978L)  */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return kotlinUnitVar;
            case 11:
                View view4 = (View) obj;
                View viewK = StaticHelpers6.k(view4, R.layout.module_dialog_quote_remind_msg, null, false);
                int i7 = R.id.moduleDialogEdtQuoteRemindMsgColor;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogEdtQuoteRemindMsgColor);
                if (textInputEditText != null) {
                    i7 = R.id.moduleDialogEdtQuoteRemindMsgText;
                    TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtQuoteRemindMsgText);
                    if (textInputEditText2 != null) {
                        i7 = R.id.moduleDialogInputQuoteRemindMsgColor;
                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputQuoteRemindMsgColor)) != null) {
                            i7 = R.id.moduleDialogInputQuoteRemindMsgText;
                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputQuoteRemindMsgText)) != null) {
                                LinearLayout linearLayout = (LinearLayout) viewK;
                                cem cemVar = new cem(linearLayout, textInputEditText, textInputEditText2, 4);
                                textInputEditText2.setText(cxk.a.o());
                                textInputEditText.setText(cxj.a.o());
                                bzy bzyVar = new bzy(view4.getContext());
                                eg egVar = (eg) bzyVar.d;
                                cxl.a.getClass();
                                egVar.d = cxl.c;
                                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-457641650289450L)  */, new amw(new cfx(cemVar, 9), 0));
                                bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-457663125125930L)  */, new amw(new Function1$VarIsInt$2(21), 2));
                                if (linearLayout != null) {
                                    egVar.r = linearLayout;
                                }
                                bzyVar.i().show();
                                return kotlinUnitVar;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-663314749193002L)  */.concat(viewK.getResources().getResourceName(i7)));
            case 12:
                HookParam hookParam3 = (HookParam) obj;
                Pair pairVar = (cnb.ab(ewk.n) || cnb.ac(ewh.q)) ? new Pair(1, 5) : new Pair(0, 4);
                int iIntValue = ((Number) pairVar.first).intValue();
                int iIntValue2 = ((Number) pairVar.second).intValue();
                hookParam3.getClass();
                try {
                    objX21 = hookParam3.getArgs()[iIntValue];
                    if (objX21 == null) {
                        objX21 = null;
                    }
                } catch (Throwable th21) {
                    objX21 = FastKV.getFailureFromException(th21);
                }
                if (objX21 instanceof Failure) {
                    objX21 = null;
                }
                throwIfVar1IsNull(objX21);
                int i8 = 0;
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objX21).r();
                fieldResolverVarR2.name = "field_unReadCount" /* "field_unReadCount" /* "field_unReadCount" /* cnb.z(-457542866041642L)  */;
                Object objE2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue_();
                throwIfVar1IsNull(objE2);
                int iIntValue3 = ((Number) objE2).intValue();
                FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objX21).r();
                fieldResolverVarR3.name = "field_unReadMuteCount" /* "field_unReadMuteCount" /* "field_unReadMuteCount" /* cnb.z(-457482736499498L)  */;
                Object objE3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
                throwIfVar1IsNull(objE3);
                int iIntValue4 = ((Number) objE3).intValue();
                FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(objX21).r();
                fieldResolverVarR4.name = "field_msgType" /* "field_msgType" /* "field_msgType" /* cnb.z(-457920823163690L)  */;
                String str3 = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue_();
                FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(objX21).r();
                fieldResolverVarR5.name = "field_content" /* "field_content" /* "field_content" /* cnb.z(-457912233229098L)  */;
                Object objE4 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue_();
                throwIfVar1IsNull(objE4);
                String str4 = (String) objE4;
                if ((iIntValue3 > 0 || iIntValue4 > 0) && nullSafeIsEqual(str3, String.valueOf(ewg.s.w))) {
                    String sendTalker = new MsgInfoBean.QuoteMsg(str4).getSendTalker();
                    acx.a.getClass();
                    if (nullSafeIsEqual(sendTalker, acx.b())) {
                        try {
                            objX22 = hookParam3.getArgs()[iIntValue2];
                            if (objX22 == null) {
                                objX22 = null;
                            }
                        } catch (Throwable th22) {
                            objX22 = FastKV.getFailureFromException(th22);
                        }
                        obj2 = objX22 instanceof Failure ? null : objX22;
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(cxk.a.o());
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(cxj.a.o())), 0,
                                spannableStringBuilder.length(), 33);
                        spannableStringBuilder.append((CharSequence) " " /* " " /* " " /* cnb.z(-457834923817770L)  */);
                        spannableStringBuilder.append((CharSequence) obj2);
                        hookParam3.dexFind(spannableStringBuilder);
                    }
                }
                return kotlinUnitVar;
            case 13:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new cvc(14);
                findDexClassMethodDslWrapperVar.onMethodCallback = new cvc(15);
                return kotlinUnitVar;
            case 14:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.ConversationWithCacheAdapter" /* "MicroMsg.ConversationWithCacheAdapter" /* "MicroMsg.ConversationWithCacheAdapter" /* cnb.z(-457843513752362L)  */,
                        "is transfer remind msg " /* "is transfer remind msg " /* "is transfer remind msg " /* cnb.z(-459312392567594L)  */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 15:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                cls2 = CharSequence.class;
                Class<CharSequence> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar5.r(clsBf2 != null ? clsBf2 : CharSequence.class);
                cdjVar5.p(new IntRange(7, 8, 1));
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return kotlinUnitVar;
            case 16:
                HookParam hookParam4 = (HookParam) obj;
                hookParam4.getClass();
                try {
                    objX23 = hookParam4.getArgs()[0];
                    if (objX23 == null) {
                        objX23 = null;
                    }
                } catch (Throwable th23) {
                    objX23 = FastKV.getFailureFromException(th23);
                }
                Object obj12 = objX23 instanceof Failure ? null : objX23;
                throwIfVar1IsNull(obj12);
                try {
                    objX24 = hookParam4.getArgs()[1];
                    if (objX24 == null) {
                        objX24 = null;
                    }
                } catch (Throwable th24) {
                    objX24 = FastKV.getFailureFromException(th24);
                }
                if (objX24 instanceof Failure) {
                    objX24 = null;
                }
                throwIfVar1IsNull(objX24);
                int i9 = 0;
                FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(obj12).r();
                fieldResolverVarR6.fieldType = dal.getKClassFromClass(View.class);
                Object objE5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR6)).getValue_();
                throwIfVar1IsNull(objE5);
                View viewB = erb.b((ViewGroup) objE5, "" /* "" /* "" /* cnb.z(-86539296045866L)  */, 0, 1, 1, 1, 1);
                throwIfVar1IsNull(viewB);
                TextView textView = (TextView) viewB;
                Field[] declaredFields = objX24.getClass().getDeclaredFields();
                int length = declaredFields.length;
                Field field = null;
                int i10 = 0;
                boolean z = false;
                while (i10 < length) {
                    field = declaredFields[i10];
                    field.setAccessible(true);
                    if (z) {
                        throw new IllegalArgumentException("Array contains more than one matching element." /*
                                                                                                             * cnb.z(-
                                                                                                             * 540817986943786L)
                                                                                                             */);
                    }
                    i10++;
                    z = true;
                }
                if (!z) {
                    throw new NoSuchElementException("Array contains no element matching the predicate." /*
                                                                                                          * cnb.z(-
                                                                                                          * 540066367666986L)
                                                                                                          */);
                }
                Object obj13 = field.get(objX24);
                throwIfVar1IsNull(obj13);
                int i11 = 0;
                FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(obj13).r();
                fieldResolverVarR7.fieldType = dal.getKClassFromClass(cls);
                Object obj14 = null;
                boolean z2 = false;
                for (Object obj15 : fieldResolverVarR7.resolve()) {
                    String str5 = (String) ((BoundField) obj15).getValue_();
                    if (str5 != null && str5.length() == 10) {
                        int i12 = 0;
                        while (true) {
                            if (i12 >= str5.length()) {
                                if (!z2) {
                                    obj14 = obj15;
                                    z2 = true;
                                    break;
                                }
                                throw new IllegalArgumentException(
                                        "Collection contains more than one matching element." /*
                                                                                               * cnb.z(-
                                                                                               * 540349835508522L)
                                                                                               */);
                            }
                            if (!Character.isDigit(str5.charAt(i12))) {
                            }
                            i12++;
                            break;
                        }
                    }
                }
                if (!z2) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                               * cnb.z(-
                                                                                                               * 540160856947498L)
                                                                                                               */);
                }
                Object objE6 = ((BoundField) obj14).getValue_();
                throwIfVar1IsNull(objE6);
                long j = Long.parseLong((String) objE6) * ((long) 1000);
                dad.a.getClass();
                int i13 = drv.a;
                textView.setText(cnh.ag(j,
                        nullSafeIsEqual(Instant.ofEpochMilli(j).atZone(ZoneId.systemDefault()).toLocalDate(),
                                LocalDate.now())
                                        ? "HH:mm:ss"
                                        /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-538786467412778L)  */ : Instant.ofEpochMilli(j)
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate().getYear() == LocalDate.now().getYear() ? "M月d日 HH:mm:ss"
                                                        /* "M月d日 HH:mm:ss" /* "M月d日 HH:mm:ss" /* cnb.z(-539297568521002L)  */ : "yyyy年M月d日 HH:mm:ss" /*
                                                                                                               * cnb.z(-
                                                                                                               * 539220259109674L)
                                                                                                               */,
                        null, 2));
                return kotlinUnitVar;
            case 17:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX25 = hookParam5.getArgs()[2];
                    if (objX25 == null) {
                        objX25 = null;
                    }
                } catch (Throwable th25) {
                    objX25 = FastKV.getFailureFromException(th25);
                }
                JSONObject jSONObject = (JSONObject) (objX25 instanceof Failure ? null : objX25);
                if (jSONObject != null) {
                    dad.a.getClass();
                    if (Math.random() > 0.65d) {
                        List listAg = OtherStaticHelpers.argsToList("Hd" /* "Hd" /* "Hd" /* cnb.z(-539173014469418L)  */, "久雾" /* "久雾" /* "久雾" /* cnb.z(-539108589959978L)  */,
                                "豆子" /* "豆子" /* "豆子" /* cnb.z(-539130064796458L)  */, "拖鞋" /* "拖鞋" /* "拖鞋" /* cnb.z(-539134359763754L)  */);
                        ae aeVar = cyj.f;
                        String str6 = (String) StaticHelpers5.q(listAg);
                        jSONObject.put("changeWording" /* "changeWording" /* "changeWording" /* cnb.z(-539087115123498L)  */,
                                "已存入" /* "已存入" /* "已存入" /* cnb.z(-540659073153834L)  */ + str6 + "的余额(WA)" /* "的余额(WA)" /* "的余额(WA)" /* cnb.z(-540676253023018L)  */);
                    }
                    double d = jSONObject.getInt("totalAmount" /* "totalAmount" /* "totalAmount" /* cnb.z(-540641893284650L)  */);
                    int i14 = jSONObject.getInt("totalNum" /* "totalNum" /* "totalNum" /* cnb.z(-540555993938730L)  */);
                    int i15 = jSONObject.getInt("recNum" /* "recNum" /* "recNum" /* cnb.z(-540517339233066L)  */);
                    double d2 = jSONObject.getInt("recAmount" /* "recAmount" /* "recAmount" /* cnb.z(-540487274461994L)  */);
                    jSONObject.getInt("amount" /* "amount" /* "amount" /* cnb.z(-540461504658218L)  */);
                    jSONObject.getJSONArray("record" /* "record" /* "record" /* cnb.z(-540414260017962L)  */);
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("金额:" /* "金额:" /* "金额:" /* cnb.z(-540933951060778L)  */);
                    double d3 = 100;
                    sb2.append(d2 / d3);
                    sb2.append('/');
                    sb2.append(d / d3);
                    sb2.append("元\n" /* "元\n" /* "元\n" /* cnb.z(-540951130929962L)  */);
                    sb.append(sb2.toString());
                    sb.append("数量:" /* "数量:" /* "数量:" /* cnb.z(-540955425897258L)  */ + i15 + '/' + i14 + '\n');
                    double d4 = (d - d2) / d3;
                    if (d4 > 0.0d) {
                        sb.append("剩余:" /* "剩余:" /* "剩余:" /* cnb.z(-540903886289706L)  */ + d4 + "元\n" /* "元\n" /* "元\n" /* cnb.z(-540921066158890L)  */);
                    }
                    jSONObject.put("headTitle" /* "headTitle" /* "headTitle" /* cnb.z(-540873821518634L)  */, sb.toString());
                }
                return kotlinUnitVar;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(19);
                return kotlinUnitVar;
            case 19:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.plugin.luckymoney.ui" /* "com.tencent.mm.plugin.luckymoney.ui" /* "com.tencent.mm.plugin.luckymoney.ui" /* cnb.z(-537158674807594L)  */ };
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.a = SomeStaticHelpers.arrayToList(strArr4);
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.LuckyMoneyDetailUI" /* "MicroMsg.LuckyMoneyDetailUI" /* "MicroMsg.LuckyMoneyDetailUI" /* cnb.z(-537588171537194L)  */, "try get user contact: %s" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 537433552714538L)
                                                                                                                    */);
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
                return kotlinUnitVar;
            case 20:
                ((HookParam) obj).setResult(Boolean.FALSE);
                return kotlinUnitVar;
            case 21:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(22);
                return kotlinUnitVar;
            case 22:
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar7 = new DexFinder();
                DexFinder.setClassEquals(cdjVar7, "com.tencent.mm.ui.transmit.SelectConversationUI" /* "com.tencent.mm.ui.transmit.SelectConversationUI" /* "com.tencent.mm.ui.transmit.SelectConversationUI" /* cnb.z(-497559076338474L)  */);
                cls3 = Boolean.class;
                Class<Boolean> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cdjVar7.r(clsBf3 != null ? clsBf3 : Boolean.class);
                cdjVar7.usingStrings("max_limit_num" /* "max_limit_num" /* "max_limit_num" /* cnb.z(-497902673722154L)  */);
                dexMethodQueryBuilderVar7.getClass();
                dexMethodQueryBuilderVar7.dexFinder = cdjVar7;
                return kotlinUnitVar;
            case 23:
                int i16 = 0;
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa((HookParam) obj);
                fieldResolverVarAa2.fieldType = dal.getKClassFromClass(cls4);
                for (BoundField boundFieldVar : fieldResolverVarAa2.resolve()) {
                    Integer num = (Integer) boundFieldVar.getValue_();
                    if (num != null && num.intValue() == 32) {
                        boundFieldVar.setValue(Integer.MAX_VALUE);
                    }
                }
                return kotlinUnitVar;
            case 24:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cvc(25);
                return kotlinUnitVar;
            case 25:
                DexMethodQueryBuilder dexMethodQueryBuilderVar8 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar8 = new DexFinder();
                cdjVar8.usingStrings("MicroMsg.InputTextBoundaryCheck" /* "MicroMsg.InputTextBoundaryCheck" /* "MicroMsg.InputTextBoundaryCheck" /* cnb.z(-497365802810154L)  */,
                        "edit text view is null" /* "edit text view is null" /* "edit text view is null" /* cnb.z(-498877631298346L)  */);
                dexMethodQueryBuilderVar8.getClass();
                dexMethodQueryBuilderVar8.dexFinder = cdjVar8;
                return kotlinUnitVar;
            case 26:
                int i17 = 0;
                FieldResolver fieldResolverVarAa3 = StaticHelpers6.aa((HookParam) obj);
                StaticHelpers2.addAllFromVar2ToVar1(fieldResolverVarAa3.modifiers, (AccessModifierEnum[]) Arrays.copyOf(new AccessModifierEnum[] { AccessModifierEnum.PUBLIC, AccessModifierEnum.FINAL}, 2));
                fieldResolverVarAa3.fieldType = dal.getKClassFromClass(cls4);
                for (BoundField boundFieldVar2 : fieldResolverVarAa3.resolve()) {
                    Integer num2 = (Integer) boundFieldVar2.getValue_();
                    if (num2 != null && num2.intValue() == 10) {
                        boundFieldVar2.setValue(Integer.MAX_VALUE);
                    }
                }
                return kotlinUnitVar;
            case 27:
                ((HookParam) obj).setResult(Boolean.FALSE);
                return kotlinUnitVar;
            case 28:
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar9 = new DexFinder();
                cdjVar9.s("callback" /* "callback" /* "callback" /* cnb.z(-519974510656298L)  */);
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.dexFinder = cdjVar9;
                return kotlinUnitVar;
            default:
                HookParam hookParam6 = (HookParam) obj;
                hookParam6.getClass();
                try {
                    objX26 = hookParam6.getArgs()[0];
                    if (objX26 == null) {
                        objX26 = null;
                    }
                } catch (Throwable th26) {
                    objX26 = FastKV.getFailureFromException(th26);
                }
                if (objX26 instanceof Failure) {
                    objX26 = null;
                }
                throwIfVar1IsNull(objX26);
                String str7 = (String) objX26;
                try {
                    objX27 = hookParam6.getArgs()[1];
                    if (objX27 == null) {
                        objX27 = null;
                    }
                } catch (Throwable th27) {
                    objX27 = FastKV.getFailureFromException(th27);
                }
                throwIfVar1IsNull(objX27 instanceof Failure ? null : objX27);
                for (IHandlesHookParam bnyVar : dbl.b) {
                    try {
                        bnyVar.d(hookParam6, str7);
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onGetRepairerConfig " /* "onGetRepairerConfig " /* "onGetRepairerConfig " /* cnb.z(-55997783604010L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3,
                                bnyVar instanceof SwitchHook ? ((SwitchHook) bnyVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 55873229552426L)
                                                                                                               */,
                                -55851754715946L), e, 12);
                    }
                }
                return kotlinUnitVar;
        }
    }
}
