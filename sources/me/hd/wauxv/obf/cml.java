package me.hd.wauxv.obf;

import android.util.Pair;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cml implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ cml(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Class cls;
        Class cls2;
        Class cls3;
        Object objX;
        Class cls4;
        int i = this.a;
        int i2 = 10;
        int i3 = 1;
        cls = String.class;
        cls2 = Integer.class;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new cml(i3);
                findDexClassMethodDslWrapperVar.onMethodCallback = new cml(2);
                return kotlinUnitVar;
            case 1:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.NetSceneSendPat" /* "MicroMsg.NetSceneSendPat" /* "MicroMsg.NetSceneSendPat" /* cnb.z(-139410343459626L)  */, "/cgi-bin/micromsg-bin/sendpat" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 138770393332522L)
                                                                                                                    */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 2:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cls3 = Pair.class;
                Class<Pair> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cls3 = clsBf != null ? clsBf : Pair.class;
                Class<String> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf2 == null) {
                    clsBf2 = cls;
                }
                Class<String> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cls = clsBf3 != null ? clsBf3 : String.class;
                Class<Integer> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar.q(cls3, clsBf2, cls, clsBf4 != null ? clsBf4 : Integer.class);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 3:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar2 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar2.onClassCallback = new cml(4);
                findDexClassMethodDslWrapperVar2.onMethodCallback = new cml(5);
                return kotlinUnitVar;
            case 4:
                bag bagVar2 = (bag) obj;
                String[] strArr = { "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* cnb.z(-138839112809258L)  */ };
                bagVar2.getClass();
                bagVar2.a = SomeStaticHelpers.ab(strArr);
                zb zbVar2 = new zb();
                zbVar2.k("Micromsg.NetSceneTenpayRemittanceConfirm" /* "Micromsg.NetSceneTenpayRemittanceConfirm" /* "Micromsg.NetSceneTenpayRemittanceConfirm" /* cnb.z(-140303696657194L)  */,
                        "/cgi-bin/mmpay-bin/transferoperation" /* "/cgi-bin/mmpay-bin/transferoperation" /* "/cgi-bin/mmpay-bin/transferoperation" /* cnb.z(-140694538681130L)  */);
                bagVar2.b = zbVar2;
                return kotlinUnitVar;
            case 5:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t("account click info , key is %s, value is %s" /* "account click info , key is %s, value is %s" /* "account click info , key is %s, value is %s" /* cnb.z(-140501265152810L)  */);
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 6:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar3 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar3.onClassCallback = new cml(7);
                findDexClassMethodDslWrapperVar3.onMethodCallback = new cml(8);
                return kotlinUnitVar;
            case 7:
                bag bagVar3 = (bag) obj;
                String[] strArr2 = { "com.tencent.mm.plugin.sport.model" /* "com.tencent.mm.plugin.sport.model" /* "com.tencent.mm.plugin.sport.model" /* cnb.z(-140063178488618L)  */ };
                bagVar3.getClass();
                bagVar3.a = SomeStaticHelpers.ab(strArr2);
                zb zbVar3 = new zb();
                zbVar3.k("MicroMsg.Sport.NetSceneUploadDeviceStep" /* "MicroMsg.Sport.NetSceneUploadDeviceStep" /* "MicroMsg.Sport.NetSceneUploadDeviceStep" /* cnb.z(-139934329469738L)  */,
                        "/cgi-bin/mmoc-bin/hardware/uploaddevicestep" /* "/cgi-bin/mmoc-bin/hardware/uploaddevicestep" /* "/cgi-bin/mmoc-bin/hardware/uploaddevicestep" /* cnb.z(-137013751708458L)  */);
                bagVar3.b = zbVar3;
                return kotlinUnitVar;
            case 8:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                Class<String> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls5 = clsBf5 == null ? cls : clsBf5;
                Class<String> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls6 = clsBf6 == null ? cls : clsBf6;
                Class<Integer> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls7 = clsBf7 == null ? cls2 : clsBf7;
                Class<Integer> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls8 = clsBf8 == null ? cls2 : clsBf8;
                Class<Integer> clsBf9 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls9 = clsBf9 == null ? cls2 : clsBf9;
                Class<String> clsBf10 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls10 = clsBf10 == null ? cls : clsBf10;
                Class<Integer> clsBf11 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar3.q(cls5, cls6, cls7, cls8, cls9, cls10, clsBf11 == null ? cls2 : clsBf11);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return kotlinUnitVar;
            case 9:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar4 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar4.onClassCallback = new cml(i2);
                findDexClassMethodDslWrapperVar4.onMethodCallback = new cml(11);
                return kotlinUnitVar;
            case 10:
                bag bagVar4 = (bag) obj;
                String[] strArr3 = { "com.tencent.mm.modelimage" /* "com.tencent.mm.modelimage" /* "com.tencent.mm.modelimage" /* cnb.z(-137176960465706L)  */ };
                bagVar4.getClass();
                bagVar4.a = SomeStaticHelpers.ab(strArr3);
                zb zbVar4 = new zb();
                zbVar4.k("MicroMsg.NetSceneUploadMsgImg" /* "MicroMsg.NetSceneUploadMsgImg" /* "MicroMsg.NetSceneUploadMsgImg" /* cnb.z(-136532715371306L)  */,
                        "/cgi-bin/micromsg-bin/uploadmsgimg" /* "/cgi-bin/micromsg-bin/uploadmsgimg" /* "/cgi-bin/micromsg-bin/uploadmsgimg" /* cnb.z(-136386686483242L)  */);
                bagVar4.b = zbVar4;
                return kotlinUnitVar;
            case 11:
                bah bahVar4 = (bah) obj;
                cdj cdjVar4 = new cdj();
                Class<Integer> clsBf12 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls11 = clsBf12 == null ? cls2 : clsBf12;
                Class<String> clsBf13 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls12 = clsBf13 == null ? cls : clsBf13;
                Class<String> clsBf14 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls13 = clsBf14 == null ? cls : clsBf14;
                Class<String> clsBf15 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls14 = clsBf15 == null ? cls : clsBf15;
                Class<Integer> clsBf16 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls15 = clsBf16 == null ? cls2 : clsBf16;
                Class<Integer> clsBf17 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                Class<Integer> cls16 = clsBf17 == null ? cls2 : clsBf17;
                Class<String> clsBf18 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls17 = clsBf18 == null ? cls : clsBf18;
                Class<String> clsBf19 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                Class<String> cls18 = clsBf19 == null ? cls : clsBf19;
                Class clsBf20 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Boolean.class));
                Class cls19 = clsBf20 == null ? Boolean.class : clsBf20;
                Class<Integer> clsBf21 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar4.q(cls11, cls12, cls13, cls14, cls15, null, cls16, cls17, cls18, cls19,
                        clsBf21 == null ? cls2 : clsBf21);
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return kotlinUnitVar;
            case 12:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar5 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar5.onClassCallback = new cml(13);
                findDexClassMethodDslWrapperVar5.onMethodCallback = new cml(14);
                return kotlinUnitVar;
            case 13:
                bag bagVar5 = (bag) obj;
                zb zbVar5 = new zb();
                zbVar5.k("MicroMsg.NetSceneUploadVoice" /* "MicroMsg.NetSceneUploadVoice" /* "MicroMsg.NetSceneUploadVoice" /* cnb.z(-136648679488298L)  */,
                        "/cgi-bin/micromsg-bin/uploadvoice" /* "/cgi-bin/micromsg-bin/uploadvoice" /* "/cgi-bin/micromsg-bin/uploadvoice" /* cnb.z(-138139033140010L)  */);
                bagVar5.getClass();
                bagVar5.b = zbVar5;
                return kotlinUnitVar;
            case 14:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                Class<String> clsBf22 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cls = clsBf22 != null ? clsBf22 : String.class;
                Class<Integer> clsBf23 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cdjVar5.q(cls, clsBf23 != null ? clsBf23 : Integer.class);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return kotlinUnitVar;
            case 15:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar6 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar6.onClassCallback = new cml(18);
                findDexClassMethodDslWrapperVar6.onMethodCallback = new cml(19);
                return kotlinUnitVar;
            case 16:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cml(17);
                return kotlinUnitVar;
            case 17:
                bah bahVar6 = (bah) obj;
                cdj cdjVar6 = new cdj();
                cmy.a.getClass();
                cdjVar6.o(StaticHelpers7.ba(cmw.a).getDeclaringClass());
                cdjVar6.t("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK" /*
                                                                                                     * cnb.z(-
                                                                                                     * 125602023602986L)
                                                                                                     */);
                bahVar6.getClass();
                bahVar6.d = cdjVar6;
                return kotlinUnitVar;
            case 18:
                bag bagVar6 = (bag) obj;
                String[] strArr4 = { "com.tencent.mm.pluginsdk.model" /* "com.tencent.mm.pluginsdk.model" /* "com.tencent.mm.pluginsdk.model" /* cnb.z(-137919989807914L)  */ };
                bagVar6.getClass();
                bagVar6.a = SomeStaticHelpers.ab(strArr4);
                zb zbVar6 = new zb();
                zbVar6.k("MicroMsg.NetSceneVerifyUser.dkverify" /* "MicroMsg.NetSceneVerifyUser.dkverify" /* "MicroMsg.NetSceneVerifyUser.dkverify" /* cnb.z(-137769665952554L)  */,
                        "/cgi-bin/micromsg-bin/verifyuser" /* "/cgi-bin/micromsg-bin/verifyuser" /* "/cgi-bin/micromsg-bin/verifyuser" /* cnb.z(-126048700201770L)  */);
                bagVar6.b = zbVar6;
                return kotlinUnitVar;
            case 19:
                bah bahVar7 = (bah) obj;
                cdj cdjVar7 = new cdj();
                cdjVar7.t("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK" /*
                                                                                                    * cnb.z(-
                                                                                                    * 125906966281002L)
                                                                                                    */);
                bahVar7.getClass();
                bahVar7.d = cdjVar7;
                return kotlinUnitVar;
            case 20:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[0];
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
                MsgInfoBean msgInfoBean = new MsgInfoBean(objX);
                for (Object obj2 : cos.b) {
                    try {
                        if (((fs) obj2).z() && msgInfoBean.isNotifyAll()
                                && fr.a.n().contains(msgInfoBean.getTalker())) {
                            hookParam.setResult(null);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onHandleMsg " /* "onHandleMsg " /* "onHandleMsg " /* cnb.z(-66288525245226L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                obj2 instanceof SwitchHook ? ((SwitchHook) obj2).getResult() : "LoadHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 66267050408746L)
                                                                                                           */,
                                -67894843013930L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 21:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cml(22);
                return kotlinUnitVar;
            case 22:
                bah bahVar8 = (bah) obj;
                String[] strArr5 = { "com.tencent.mm.booter.notification" /* "com.tencent.mm.booter.notification" /* "com.tencent.mm.booter.notification" /* cnb.z(-67860483275562L)  */ };
                bahVar8.getClass();
                bahVar8.a = SomeStaticHelpers.ab(strArr5);
                cdj cdjVar8 = new cdj();
                cdjVar8.t("MicroMsg.MMNotification" /* "MicroMsg.MMNotification" /* "MicroMsg.MMNotification" /* cnb.z(-67658619812650L)  */,
                        "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s" /* "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s" /* "notifyFirst talker:%s msgid:%d type:%d tipsFlag:%d content:%s" /* cnb.z(-68105296411434L)  */);
                bahVar8.d = cdjVar8;
                return kotlinUnitVar;
            case 23:
                HookParam hookParam2 = (HookParam) obj;
                int i4 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam2);
                uq.a.getClass();
                fieldResolverVarAa.fieldType = ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-75127567940394L)  */);
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration((FrameLayout) objE).r();
                fieldResolverVarR.b = new cml(24);
                Object obj3 = null;
                boolean z = false;
                for (Object obj4 : fieldResolverVarR.resolve()) {
                    Object objD = ((BoundField) obj4).getValue();
                    if (nullSafeIsEqual(objD != null ? objD.getClass().getSimpleName() : null, "MMFlexEditText" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 399947354602282L)
                                                                                                                 */)) {
                        if (z) {
                            throw new IllegalArgumentException(
                                    "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* cnb.z(-399865750223658L)  */);
                        }
                        z = true;
                        obj3 = obj4;
                    }
                }
                if (!z) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                               * cnb.z(-
                                                                                                               * 400157807999786L)
                                                                                                               */);
                }
                Object objE2 = ((BoundField) obj3).getValue_();
                throwIfVar1IsNull(objE2);
                FrameLayout frameLayout = (FrameLayout) objE2;
                int i5 = 0;
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(frameLayout).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "getText" /* "getText" /* "getText" /* cnb.z(-399371828984618L)  */;
                Object objJ = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).j(new Object[0]);
                throwIfVar1IsNull(objJ);
                String string = objJ.toString();
                if (string.length() > 0) {
                    ArrayList<ctx> arrayList2 = cuk.a;
                    ArrayList arrayList3 = new ArrayList(StaticHelpers4.ak(arrayList2, 10));
                    for (ctx ctxVar : arrayList2) {
                        ctxVar.getClass();
                        arrayList3.add(Boolean.valueOf(KotlinHelpers
                                .f(ctxVar.n("onClickSendBtn" /* "onClickSendBtn" /* "onClickSendBtn" /* cnb.z(-401970284198698L)  */, string), Boolean.TRUE)));
                    }
                    if (!arrayList3.isEmpty()) {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            if (((Boolean) it.next()).booleanValue()) {
                                int i6 = 0;
                                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(frameLayout).getMethodResolverBasedOnPreviouslyProvidedConfig();
                                methodResolverVarT2.name = "setText" /* "setText" /* "setText" /* cnb.z(-399337469246250L)  */;
                                ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).e("" /* "" /* "" /* cnb.z(-399303109507882L)  */);
                                hookParam2.setResult(null);
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 24:
                return Boolean.valueOf(((Class) obj).isInterface());
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cml(26);
                return kotlinUnitVar;
            case 26:
                bah bahVar9 = (bah) obj;
                String[] strArr6 = { "com.tencent.mm.pluginsdk.ui.chat" /* "com.tencent.mm.pluginsdk.ui.chat" /* "com.tencent.mm.pluginsdk.ui.chat" /* cnb.z(-399298814540586L)  */ };
                bahVar9.getClass();
                bahVar9.a = SomeStaticHelpers.ab(strArr6);
                cdj cdjVar9 = new cdj();
                cdjVar9.t("MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* cnb.z(-399174260489002L)  */, "send msg onClick" /*
                                                                                                    * cnb.z(-
                                                                                                    * 399672476695338L)
                                                                                                    */);
                bahVar9.d = cdjVar9;
                return kotlinUnitVar;
            case 27:
                HookParam hookParam3 = (HookParam) obj;
                int i7 = 0;
                MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(hookParam3.getThisObject()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT3.returnType = dal.getKClassFromClass(Integer.TYPE);
                Object objJ2 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT3)).j(new Object[0]);
                throwIfVar1IsNull(objJ2);
                int iIntValue = ((Number) objJ2).intValue();
                Object objF = hookParam3.getResult();
                throwIfVar1IsNull(objF, "null cannot be cast to non-null type kotlin.ByteArray" /*
                                                                                                 * cnb.z(-
                                                                                                 * 67186173410090L)
                                                                                                 */);
                byte[] bArr = (byte[]) objF;
                for (Object obj5 : crj.b) {
                    try {
                        ((zw) obj5).h(hookParam3, iIntValue, bArr);
                    } catch (Exception e2) {
                        ArrayList arrayList4 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onGetBuffer " /* "onGetBuffer " /* "onGetBuffer " /* cnb.z(-67486821120810L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                obj5 instanceof SwitchHook ? ((SwitchHook) obj5).getResult() : "LoadHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 67482526153514L)
                                                                                                           */,
                                -67443871447850L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new cml(29);
                return kotlinUnitVar;
            default:
                bah bahVar10 = (bah) obj;
                cdj cdjVar10 = new cdj();
                cls4 = byte[].class;
                Class<byte[]> clsBf24 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                cdjVar10.r(clsBf24 != null ? clsBf24 : byte[].class);
                cdjVar10.t("MicroMsg.OpLog.Operation" /* "MicroMsg.OpLog.Operation" /* "MicroMsg.OpLog.Operation" /* cnb.z(-67409511709482L)  */,
                        "summeroplog Operation toByteArray err: " /* "summeroplog Operation toByteArray err: " /* "summeroplog Operation toByteArray err: " /* cnb.z(-55705725827882L)  */);
                bahVar10.getClass();
                bahVar10.d = cdjVar10;
                return kotlinUnitVar;
        }
    }
}
