package me.hd.wauxv.obf;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class clo implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ clo(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        Class cls10;
        Class cls11;
        Class cls12;
        Class cls13;
        Class cls14;
        switch (this.a) {
            case 0:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.ChatroomMembersLogic" /* "MicroMsg.ChatroomMembersLogic" /* "MicroMsg.ChatroomMembersLogic" /* "MicroMsg.ChatroomMembersLogic" /* cnb.z(-113838108179242L)   */, "/cgi-bin/micromsg-bin/delchatroommember" /* "/cgi-bin/micromsg-bin/delchatroommember" /* "/cgi-bin/micromsg-bin/delchatroommember" /* "/cgi-bin/micromsg-bin/delchatroommember" /* cnb.z(-114310554581802L)   */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return Kotlin$Unit.INSTANCE;
            case 1:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cls = String.class;
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cls = clsBf != null ? clsBf : String.class;
                cls2 = List.class;
                Class<List> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cls2 = clsBf2 != null ? clsBf2 : List.class;
                cls3 = Integer.class;
                Class<Integer> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cdjVar.q(cls, cls2, clsBf3 != null ? clsBf3 : Integer.class);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return Kotlin$Unit.INSTANCE;
            case 2:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new clo(3);
                findDexClassMethodDslWrapperVar.onMethodCallback = new clo(4);
                return Kotlin$Unit.INSTANCE;
            case 3:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                String[] strArr = {"com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* cnb.z(-113335597005610L)   */};
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.NetSceneLuckyMoneyDetail" /* "MicroMsg.NetSceneLuckyMoneyDetail" /* "MicroMsg.NetSceneLuckyMoneyDetail" /* "MicroMsg.NetSceneLuckyMoneyDetail" /* cnb.z(-113700669225770L)   */, "/cgi-bin/mmpay-bin/qrydetailwxhb" /* "/cgi-bin/mmpay-bin/qrydetailwxhb" /* "/cgi-bin/mmpay-bin/qrydetailwxhb" /* "/cgi-bin/mmpay-bin/qrydetailwxhb" /* cnb.z(-113571820206890L)   */);
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return Kotlin$Unit.INSTANCE;
            case 4:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                cls4 = String.class;
                Class<String> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                if (clsBf4 == null) {
                    clsBf4 = cls4;
                }
                cls5 = Integer.class;
                Class<Integer> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                if (clsBf5 == null) {
                    clsBf5 = cls5;
                }
                Class<Integer> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                cls5 = clsBf6 != null ? clsBf6 : Integer.class;
                Class<String> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                if (clsBf7 == null) {
                    clsBf7 = cls4;
                }
                Class<String> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                cdjVar2.q(clsBf4, clsBf5, cls5, clsBf7, clsBf8 != null ? clsBf8 : String.class);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return Kotlin$Unit.INSTANCE;
            case 5:
                return (String) ((bzv) ((bzx) obj).e()).get(1);
            case 6:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar2 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar2.onClassCallback = new clo(7);
                findDexClassMethodDslWrapperVar2.onMethodCallback = new clo(8);
                return Kotlin$Unit.INSTANCE;
            case 7:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.NetSceneInviteChatRoomMember" /* "MicroMsg.NetSceneInviteChatRoomMember" /* "MicroMsg.NetSceneInviteChatRoomMember" /* "MicroMsg.NetSceneInviteChatRoomMember" /* cnb.z(-111037789502250L)   */, "/cgi-bin/micromsg-bin/invitechatroommember" /* "/cgi-bin/micromsg-bin/invitechatroommember" /* "/cgi-bin/micromsg-bin/invitechatroommember" /* "/cgi-bin/micromsg-bin/invitechatroommember" /* cnb.z(-110857400875818L)   */);
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return Kotlin$Unit.INSTANCE;
            case 8:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cls6 = String.class;
                Class<String> clsBf9 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                cls6 = clsBf9 != null ? clsBf9 : String.class;
                cls7 = List.class;
                Class<List> clsBf10 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls7));
                cls7 = clsBf10 != null ? clsBf10 : List.class;
                cls8 = Integer.class;
                Class<Integer> clsBf11 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls8));
                cls8 = clsBf11 != null ? clsBf11 : Integer.class;
                cls9 = Object.class;
                Class<Object> clsBf12 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls9));
                cdjVar3.q(cls6, cls7, cls8, clsBf12 != null ? clsBf12 : Object.class);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return Kotlin$Unit.INSTANCE;
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new clo(10);
                return Kotlin$Unit.INSTANCE;
            case 10:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("/cgi-bin/micromsg-bin/modifycontactlabellist" /* "/cgi-bin/micromsg-bin/modifycontactlabellist" /* "/cgi-bin/micromsg-bin/modifycontactlabellist" /* "/cgi-bin/micromsg-bin/modifycontactlabellist" /* cnb.z(-110436494080810L)   */);
                cls10 = LinkedList.class;
                Class<LinkedList> clsBf13 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls10));
                cdjVar4.q(clsBf13 != null ? clsBf13 : LinkedList.class);
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return Kotlin$Unit.INSTANCE;
            case 11:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar3 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar3.onClassCallback = new clo(12);
                findDexClassMethodDslWrapperVar3.onMethodCallback = new clo(13);
                return Kotlin$Unit.INSTANCE;
            case 12:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.NetSceneSendMsg" /* "MicroMsg.NetSceneSendMsg" /* "MicroMsg.NetSceneSendMsg" /* "MicroMsg.NetSceneSendMsg" /* cnb.z(-111609020152618L)   */, "/cgi-bin/micromsg-bin/newsendmsg" /* "/cgi-bin/micromsg-bin/newsendmsg" /* "/cgi-bin/micromsg-bin/newsendmsg" /* "/cgi-bin/micromsg-bin/newsendmsg" /* cnb.z(-112051401784106L)   */, "NetSceneSendMsg:MsgSource:%s" /* "NetSceneSendMsg:MsgSource:%s" /* "NetSceneSendMsg:MsgSource:%s" /* "NetSceneSendMsg:MsgSource:%s" /* cnb.z(-111926847732522L)   */);
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
                return Kotlin$Unit.INSTANCE;
            case 13:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar5 = new DexFinder();
                cls11 = String.class;
                Class<String> clsBf14 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls11));
                if (clsBf14 == null) {
                    clsBf14 = cls11;
                }
                Class<String> clsBf15 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls11));
                cls11 = clsBf15 != null ? clsBf15 : String.class;
                cls12 = Integer.class;
                Class<Integer> clsBf16 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls12));
                if (clsBf16 == null) {
                    clsBf16 = cls12;
                }
                Class<Integer> clsBf17 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls12));
                cls12 = clsBf17 != null ? clsBf17 : Integer.class;
                cls13 = Object.class;
                Class<Object> clsBf18 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls13));
                cdjVar5.q(clsBf14, cls11, clsBf16, cls12, clsBf18 != null ? clsBf18 : Object.class);
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return Kotlin$Unit.INSTANCE;
            case 14:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar4 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar4.onClassCallback = new clo(15);
                findDexClassMethodDslWrapperVar4.onMethodCallback = new clo(16);
                return Kotlin$Unit.INSTANCE;
            case 15:
                DexClassQueryBuilder dexClassQueryBuilderVar5 = (DexClassQueryBuilder) obj;
                String[] strArr2 = {"com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* cnb.z(-111583250348842L)   */};
                dexClassQueryBuilderVar5.getClass();
                dexClassQueryBuilderVar5.strings = SomeStaticHelpers.arrayToList(strArr2);
                DexMethodGroupMatcher zbVar5 = new DexMethodGroupMatcher();
                zbVar5.usingEqStrings("MicroMsg.NetSceneOpenLuckyMoney" /* "MicroMsg.NetSceneOpenLuckyMoney" /* "MicroMsg.NetSceneOpenLuckyMoney" /* "MicroMsg.NetSceneOpenLuckyMoney" /* cnb.z(-111398566755114L)   */, "/cgi-bin/mmpay-bin/openwxhb" /* "/cgi-bin/mmpay-bin/openwxhb" /* "/cgi-bin/mmpay-bin/openwxhb" /* "/cgi-bin/mmpay-bin/openwxhb" /* cnb.z(-134900627798826L)   */);
                dexClassQueryBuilderVar5.methodGroupMatcher = zbVar5;
                return Kotlin$Unit.INSTANCE;
            case 16:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar6 = new DexFinder();
                Class clsBf19 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Integer.class));
                Class cls15 = clsBf19 == null ? Integer.class : clsBf19;
                Class clsBf20 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Integer.class));
                Class cls16 = clsBf20 == null ? Integer.class : clsBf20;
                Class clsBf21 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls17 = clsBf21 == null ? String.class : clsBf21;
                Class clsBf22 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls18 = clsBf22 == null ? String.class : clsBf22;
                Class clsBf23 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls19 = clsBf23 == null ? String.class : clsBf23;
                Class clsBf24 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls20 = clsBf24 == null ? String.class : clsBf24;
                Class clsBf25 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls21 = clsBf25 == null ? String.class : clsBf25;
                Class clsBf26 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls22 = clsBf26 == null ? String.class : clsBf26;
                Class clsBf27 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                cdjVar6.q(cls15, cls16, cls17, cls18, cls19, cls20, cls21, cls22, clsBf27 == null ? String.class : clsBf27);
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
                return Kotlin$Unit.INSTANCE;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new clo(19);
                return Kotlin$Unit.INSTANCE;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new clo(20);
                return Kotlin$Unit.INSTANCE;
            case 19:
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("MicroMsg.NetSceneQueue" /* "MicroMsg.NetSceneQueue" /* "MicroMsg.NetSceneQueue" /* "MicroMsg.NetSceneQueue" /* cnb.z(-136305082104618L)   */, "forbid in waiting: type=" /* "forbid in waiting: type=" /* "forbid in waiting: type=" /* "forbid in waiting: type=" /* cnb.z(-136189117987626L)   */, "forbid in running: type=" /* "forbid in running: type=" /* "forbid in running: type=" /* "forbid in running: type=" /* cnb.z(-136098923674410L)   */);
                dexMethodQueryBuilderVar7.getClass();
                dexMethodQueryBuilderVar7.dexFinder = cdjVar7;
                return Kotlin$Unit.INSTANCE;
            case 20:
                DexMethodQueryBuilder dexMethodQueryBuilderVar8 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar8 = new DexFinder();
                cme.a.getClass();
                cdjVar8.setDeclaredClassName(StaticHelpers7.toDexMethod(NetSceneQueue$MethodAddNetSceneToQueue.INSTANCE).getDeclaringClass());
                MethodMatcher fjVar = new MethodMatcher();
                DexFinder cdjVar9 = new DexFinder();
                cdjVar9.usingStrings("MicroMsg.BigBallSysCmdMsgConsumer" /* "MicroMsg.BigBallSysCmdMsgConsumer" /* "MicroMsg.BigBallSysCmdMsgConsumer" /* "MicroMsg.BigBallSysCmdMsgConsumer" /* cnb.z(-135441793678122L)   */, "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]" /* "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]" /* "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]" /* "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]" /* cnb.z(-135244225182506L)   */);
                fjVar.f(cdjVar9);
                DexFinder cdjVar10 = new DexFinder();
                cdjVar10.usingStrings("MicroMsg.CommandProcessor" /* "MicroMsg.CommandProcessor" /* "MicroMsg.CommandProcessor" /* "MicroMsg.CommandProcessor" /* cnb.z(-135562052762410L)   */, "summer processed log level[%s], need open debug ret false" /* "summer processed log level[%s], need open debug ret false" /* "summer processed log level[%s], need open debug ret false" /* "summer processed log level[%s], need open debug ret false" /* cnb.z(-132718784412458L)   */);
                fjVar.f(cdjVar10);
                cdjVar8.j = fjVar;
                dexMethodQueryBuilderVar8.getClass();
                dexMethodQueryBuilderVar8.dexFinder = cdjVar8;
                return Kotlin$Unit.INSTANCE;
            case 21:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar5 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar5.onClassCallback = new clo(22);
                findDexClassMethodDslWrapperVar5.onMethodCallback = new clo(23);
                return Kotlin$Unit.INSTANCE;
            case 22:
                DexClassQueryBuilder dexClassQueryBuilderVar6 = (DexClassQueryBuilder) obj;
                String[] strArr3 = {"com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* "com.tencent.mm.plugin.luckymoney.model" /* cnb.z(-132778913954602L)   */};
                dexClassQueryBuilderVar6.getClass();
                dexClassQueryBuilderVar6.strings = SomeStaticHelpers.arrayToList(strArr3);
                DexMethodGroupMatcher zbVar6 = new DexMethodGroupMatcher();
                zbVar6.usingEqStrings("MicroMsg.NetSceneReceiveLuckyMoney" /* "MicroMsg.NetSceneReceiveLuckyMoney" /* "MicroMsg.NetSceneReceiveLuckyMoney" /* "MicroMsg.NetSceneReceiveLuckyMoney" /* cnb.z(-132061654416170L)   */, "/cgi-bin/mmpay-bin/receivewxhb" /* "/cgi-bin/mmpay-bin/receivewxhb" /* "/cgi-bin/mmpay-bin/receivewxhb" /* "/cgi-bin/mmpay-bin/receivewxhb" /* cnb.z(-132478266243882L)   */);
                dexClassQueryBuilderVar6.methodGroupMatcher = zbVar6;
                return Kotlin$Unit.INSTANCE;
            case 23:
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar11 = new DexFinder();
                Class clsBf28 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Integer.class));
                Class cls23 = clsBf28 == null ? Integer.class : clsBf28;
                Class clsBf29 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Integer.class));
                Class cls24 = clsBf29 == null ? Integer.class : clsBf29;
                Class clsBf30 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                if (clsBf30 == null) {
                    clsBf30 = String.class;
                }
                Class clsBf31 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                if (clsBf31 == null) {
                    clsBf31 = String.class;
                }
                Class clsBf32 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(Integer.class));
                if (clsBf32 == null) {
                    clsBf32 = Integer.class;
                }
                Class clsBf33 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                Class cls25 = clsBf33 == null ? String.class : clsBf33;
                Class clsBf34 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(String.class));
                cdjVar11.q(cls23, cls24, clsBf30, clsBf31, clsBf32, cls25, clsBf34 == null ? String.class : clsBf34);
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.dexFinder = cdjVar11;
                return Kotlin$Unit.INSTANCE;
            case 24:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar6 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar6.onClassCallback = new clo(25);
                findDexClassMethodDslWrapperVar6.onMethodCallback = new clo(26);
                return Kotlin$Unit.INSTANCE;
            case 25:
                DexClassQueryBuilder dexClassQueryBuilderVar7 = (DexClassQueryBuilder) obj;
                String[] strArr4 = {"com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* "com.tencent.mm.plugin.remittance.model" /* cnb.z(-133659382250282L)   */};
                dexClassQueryBuilderVar7.getClass();
                dexClassQueryBuilderVar7.strings = SomeStaticHelpers.arrayToList(strArr4);
                DexMethodGroupMatcher zbVar7 = new DexMethodGroupMatcher();
                zbVar7.usingEqStrings("Micromsg.NetSceneTenpayRemittanceGen" /* "Micromsg.NetSceneTenpayRemittanceGen" /* "Micromsg.NetSceneTenpayRemittanceGen" /* "Micromsg.NetSceneTenpayRemittanceGen" /* cnb.z(-134024454470442L)   */, "/cgi-bin/mmpay-bin/f2fplaceorder" /* "/cgi-bin/mmpay-bin/f2fplaceorder" /* "/cgi-bin/mmpay-bin/f2fplaceorder" /* "/cgi-bin/mmpay-bin/f2fplaceorder" /* cnb.z(-133298604997418L)   */, "/cgi-bin/mmpay-bin/transferplaceorder" /* "/cgi-bin/mmpay-bin/transferplaceorder" /* "/cgi-bin/mmpay-bin/transferplaceorder" /* "/cgi-bin/mmpay-bin/transferplaceorder" /* cnb.z(-133156871076650L)   */);
                dexClassQueryBuilderVar7.methodGroupMatcher = zbVar7;
                return Kotlin$Unit.INSTANCE;
            case 26:
                DexMethodQueryBuilder dexMethodQueryBuilderVar10 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar12 = new DexFinder();
                cdjVar12.p(new IntRange(29, 30, 1));
                dexMethodQueryBuilderVar10.getClass();
                dexMethodQueryBuilderVar10.dexFinder = cdjVar12;
                return Kotlin$Unit.INSTANCE;
            case 27:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar7 = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar7.onClassCallback = new clo(28);
                findDexClassMethodDslWrapperVar7.onMethodCallback = new clo(29);
                return Kotlin$Unit.INSTANCE;
            case 28:
                DexClassQueryBuilder dexClassQueryBuilderVar8 = (DexClassQueryBuilder) obj;
                String[] strArr5 = {"com.tencent.mm.modelsimple" /* "com.tencent.mm.modelsimple" /* "com.tencent.mm.modelsimple" /* "com.tencent.mm.modelsimple" /* cnb.z(-133320079833898L)   */};
                dexClassQueryBuilderVar8.getClass();
                dexClassQueryBuilderVar8.strings = SomeStaticHelpers.arrayToList(strArr5);
                DexMethodGroupMatcher zbVar8 = new DexMethodGroupMatcher();
                zbVar8.usingEqStrings("MicroMsg.NetSceneRevokeMsg" /* "MicroMsg.NetSceneRevokeMsg" /* "MicroMsg.NetSceneRevokeMsg" /* "MicroMsg.NetSceneRevokeMsg" /* cnb.z(-139285789408042L)   */, "/cgi-bin/micromsg-bin/revokemsg" /* "/cgi-bin/micromsg-bin/revokemsg" /* "/cgi-bin/micromsg-bin/revokemsg" /* "/cgi-bin/micromsg-bin/revokemsg" /* cnb.z(-139187005160234L)   */);
                dexClassQueryBuilderVar8.methodGroupMatcher = zbVar8;
                return Kotlin$Unit.INSTANCE;
            default:
                DexMethodQueryBuilder dexMethodQueryBuilderVar11 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar13 = new DexFinder();
                cls14 = String.class;
                Class<String> clsBf35 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls14));
                if (clsBf35 == null) {
                    clsBf35 = cls14;
                }
                Class<String> clsBf36 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls14));
                cdjVar13.q(null, clsBf35, clsBf36 != null ? clsBf36 : String.class);
                dexMethodQueryBuilderVar11.getClass();
                dexMethodQueryBuilderVar11.dexFinder = cdjVar13;
                return Kotlin$Unit.INSTANCE;
        }
    }
}
