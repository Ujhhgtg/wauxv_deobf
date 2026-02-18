package me.hd.wauxv.plugin.api.method;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import me.hd.wauxv.data.bean.MsgInfoBean;
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.acx;
import me.hd.wauxv.obf.akq;
import me.hd.wauxv.obf.alc;
import me.hd.wauxv.obf.aou;
import me.hd.wauxv.obf.arj;
import me.hd.wauxv.obf.aub;
import me.hd.wauxv.obf.auh;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.blv;
import me.hd.wauxv.obf.bmo;
import me.hd.wauxv.obf.bsr;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.byr;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cde;
import me.hd.wauxv.obf.cdk;
import me.hd.wauxv.obf.cdy;
import me.hd.wauxv.obf.cgy;
import me.hd.wauxv.obf.ckx;
import me.hd.wauxv.obf.cly;
import me.hd.wauxv.obf.cmd;
import me.hd.wauxv.obf.cme;
import me.hd.wauxv.obf.cmj;
import me.hd.wauxv.obf.cmk;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.cnh;
import me.hd.wauxv.obf.ctc;
import me.hd.wauxv.obf.ctd;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dgf;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.ewg;
import me.hd.wauxv.obf.kc;
import me.hd.wauxv.obf.kd;
import me.hd.wauxv.obf.q;
import me.hd.wauxv.plugin.api.callback.PluginCallBack;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginMsgMethod {
    @cty
    public final long insertSystemMsg(String str, String str2, long j) {
        return aye.w(ewg.j.w, str, str2, j);
    }

    @cty
    public final void revokeMsg(long j)
            throws IllegalAccessException, InstantiationException, IOException, InvocationTargetException {
        cmk cmkVar = cmk.a;
        String strZ = "你撤回了一条消息" /* cnb.z(-133358734539562L) */;
        cmkVar.getClass();
        cgy.a.getClass();
        cme.b(cme.a, emn.ba(cmj.a).newInstance(cgy.b(j), strZ, "" /* cnb.z(-133414569114410L) */));
    }

    @cty
    public final void sendAppBrandMsg(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strZ = "msg" /* cnb.z(-115100828564266L) */;
        JSONObject jSONObject2 = new JSONObject();
        String strZ2 = "appmsg" /* cnb.z(-115049288956714L) */;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type" /* cnb.z(-115019224185642L) */, 33);
        jSONObject3.put("title" /* cnb.z(-115032109087530L) */, str2);
        String strZ3 = "weappinfo" /* cnb.z(-114989159414570L) */;
        JSONObject jSONObject4 = new JSONObject();
        String strZ4 = "item" /* cnb.z(-114963389610794L) */;
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("pagepath" /* cnb.z(-114924734905130L) */,
                "<![CDATA[" /* cnb.z(-115435836013354L) */ + str3 + "]]>" /* cnb.z(-115410066209578L) */);
        jSONObject5.put("username" /* cnb.z(-115358526602026L) */, str4);
        jSONObject4.put(strZ4, jSONObject5);
        jSONObject3.put(strZ3, jSONObject4);
        jSONObject2.put(strZ2, jSONObject3);
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        arj.ai(str, bsrVar.toString());
    }

    @cty
    public final void sendCipherMsg(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strZ = "msg" /* cnb.z(-117699283778346L) */;
        JSONObject jSONObject2 = new JSONObject();
        String strZ2 = "appmsg" /* cnb.z(-117716463647530L) */;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type" /* cnb.z(-117669219007274L) */, 1);
        jSONObject3.put("title" /* cnb.z(-118180320115498L) */, str2);
        jSONObject3.put("des" /* cnb.z(-118137370442538L) */, str2);
        jSONObject3.put("content" /* cnb.z(-118154550311722L) */,
                "|WA|" /* cnb.z(-118120190573354L) */ + TextUtils.htmlEncode(str3));
        jSONObject2.put(strZ2, jSONObject3);
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        arj.ai(str, bsrVar.toString());
    }

    @cty
    public final void sendEmoji(String str, String str2) {
        auh auhVar = auh.a;
        auhVar.getClass();
        String strB = auh.b(str2);
        aub.a.getClass();
        auh.c(auhVar, str, aub.b(strB));
    }

    @cty
    public final void sendImage(String str, String str2, String str3)
            throws JSONException, IllegalAccessException, InstantiationException, InvocationTargetException {
        arj.ad(str, str2, str3);
    }

    @cty
    public final void sendLocation(String str, String str2, String str3, String str4, String str5, String str6)
            throws JSONException {
        arj.ae(str, str2, str3, str4, str5, str6);
    }

    @cty
    public final void sendNoteMsg(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String strZ = "msg" /* cnb.z(-115337051765546L) */;
        JSONObject jSONObject2 = new JSONObject();
        String strZ2 = "appmsg" /* cnb.z(-115285512157994L) */;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type" /* cnb.z(-115306986994474L) */, 53);
        jSONObject3.put("title" /* cnb.z(-115268332288810L) */, str2);
        String strZ3 = "extinfo" /* cnb.z(-115225382615850L) */;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("solitaire_info" /* cnb.z(-115191022877482L) */, "" /* cnb.z(-114559662684970L) */);
        jSONObject3.put(strZ3, jSONObject4);
        jSONObject2.put(strZ2, jSONObject3);
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add("/msg/appmsg/appid" /* cnb.z(-114572547586858L) */);
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        arj.ai(str, bsrVar.toString());
    }

    @cty
    public final void sendPat(String str, String str2) {
        ctd ctdVar = ctd.a;
        acx.a.getClass();
        String strB = acx.b();
        ctdVar.getClass();
        int i = bte.a;
        dgf.a.getClass();
        ctdVar.getClass();
        ctc ctcVar = ctc.a;
        cde cdeVarT = dqc.bi(dgf.b(emn.az(ctcVar))).t();
        cdeVarT.a = dal.b(String.class);
        Object objJ = ((cdk) dkz.n(new Object[] { dal.b(String.class), dal.b(String.class) }, 2, cdeVarT)).j(str2, str);
        throwIfVar1IsNull(objJ);
        String str3 = (String) objJ;
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
        ctdVar.getClass();
        cde cdeVarT2 = dqc.bi(dgf.b(emn.az(ctcVar))).t();
        cdeVarT2.a = dal.b(Pair.class);
        Object objJ2 = ((cdk) dkz.n(new Object[] { dal.b(String.class), dal.b(String.class), dal.b(String.class),
                dal.b(String.class), dal.b(Integer.TYPE), dal.b(Long.TYPE) }, 6, cdeVarT2))
                .j(str, strB, str2, str3, Integer.valueOf(iCurrentTimeMillis), 0L);
        throwIfVar1IsNull(objJ2);
        alc alcVar = aou.a;
        cnd.bf(akq.f, new ckx((Pair) objJ2, str, str2, null));
    }

    @cty
    public final void sendQuoteMsg(String str, long j, String str2) throws JSONException {
        cgy.a.getClass();
        MsgInfoBean msgInfoBean = new MsgInfoBean(cgy.b(j));
        JSONObject jSONObject = new JSONObject();
        String strZ = "msg" /* cnb.z(-114512418044714L) */;
        JSONObject jSONObject2 = new JSONObject();
        String strZ2 = "appmsg" /* cnb.z(-114460878437162L) */;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type" /* cnb.z(-114482353273642L) */, 57);
        jSONObject3.put("title" /* cnb.z(-114443698567978L) */, str2);
        String strZ3 = "refermsg" /* cnb.z(-114400748895018L) */;
        JSONObject jSONObject4 = new JSONObject();
        String strZ4 = "type" /* cnb.z(-114362094189354L) */;
        kd kdVar = kd.a;
        int type = msgInfoBean.getType();
        kdVar.getClass();
        int i = bte.a;
        cde cdeVarT = dqc.bh(emn.bb(kc.a).getDeclaringClass()).t();
        cdeVarT.ak(cdy.c);
        Class cls = Integer.TYPE;
        cdeVarT.a = dal.b(cls);
        Object objJ = ((cdk) dkz.n(new Object[] { dal.b(cls) }, 1, cdeVarT)).j(Integer.valueOf(type));
        throwIfVar1IsNull(objJ);
        jSONObject4.put(strZ4, ((Number) objJ).intValue());
        jSONObject4.put("svrid" /* cnb.z(-114873195297578L) */, msgInfoBean.getMsgSvrId());
        jSONObject4.put("fromusr" /* cnb.z(-114898965101354L) */, msgInfoBean.getTalker());
        jSONObject4.put("chatusr" /* cnb.z(-114864605362986L) */, msgInfoBean.getSendTalker());
        String strZ5 = "displayname" /* cnb.z(-114830245624618L) */;
        Cursor cursorAc = arj.ac("select * from rcontact where username = '"
                /* cnb.z(-85083302132522L) */ + msgInfoBean.getSendTalker() + '\'');
        cursorAc.moveToFirst();
        jSONObject4.put(strZ5, cnb.s(cursorAc).getNickname());
        jSONObject4.put("msgsource" /* cnb.z(-114744346278698L) */, "" /* cnb.z(-114718576474922L) */);
        jSONObject4.put("content" /* cnb.z(-114714281507626L) */, msgInfoBean.getContent());
        jSONObject4.put("strid" /* cnb.z(-114679921769258L) */, "" /* cnb.z(-114636972096298L) */);
        jSONObject4.put("createtime" /* cnb.z(-114649856998186L) */, msgInfoBean.getCreateTime());
        jSONObject3.put(strZ3, jSONObject4);
        jSONObject2.put(strZ2, jSONObject3);
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        arj.ai(str, bsrVar.toString());
    }

    @cty
    public final void sendShareCard(String str, String str2) throws JSONException {
        cly clyVar = cly.a;
        JSONObject jSONObject = new JSONObject();
        String strZ = "msg" /* cnb.z(-116977729272618L) */;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("username" /* cnb.z(-116994909141802L) */, str2);
        String strZ2 = "nickname" /* cnb.z(-116956254436138L) */;
        Cursor cursorAc = arj
                .ac("select * from rcontact where username = '" /* cnb.z(-85083302132522L) */ + str2 + '\'');
        cursorAc.moveToFirst();
        jSONObject2.put(strZ2, cnb.s(cursorAc).getNickname());
        jSONObject2.put("certflag" /* cnb.z(-116866060122922L) */, cnb
                .z(dnr.bp(str2, "gh_" /* cnb.z(-116827405417258L) */, false) ? -116844585286442L : -118446608087850L));
        jSONObject.put(strZ, jSONObject2);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        hashSet.add("/msg/username" /* cnb.z(-118455198022442L) */);
        hashSet.add("/msg/nickname" /* cnb.z(-118377888611114L) */);
        hashSet.add("/msg/certflag" /* cnb.z(-118369298676522L) */);
        bsr bsrVar = new bsr();
        bsrVar.b = jSONObject;
        bsrVar.c = hashSet;
        bsrVar.d = hashSet2;
        cme.b(cme.a, cly.c(clyVar, str, bsrVar.toString(), ewg.d.w, 24));
    }

    @cty
    public final void sendText(String str, String str2) {
        arj.af(str, str2);
    }

    @cty
    public final void sendTextWithCallBack(String str, String str2, PluginCallBack.SendTextCallback sendTextCallback) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        q qVar = new q(sendTextCallback, 9);
        Object objC = cly.c(cly.a, str, str2, ewg.a.w, 16);
        cme cmeVar = cme.a;
        final blv blvVar = new blv(qVar, 1);
        cmeVar.getClass();
        int i = bte.a;
        cde cdeVarT = dqc.bi(objC).t();
        cdeVarT.ab = "doScene" /* cnb.z(-135068131523370L) */;
        cdeVarT.g = 2;
        cdeVarT.ah();
        cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
        if (cdkVar == null) {
            return;
        }
        Class<?> cls = cdkVar.a.getParameterTypes()[1];
        bmo.a.getClass();
        Object objNewProxyInstance = Proxy.newProxyInstance(bmo.m(), new Class[]{cls}, new InvocationHandler() { // from class: me.hd.wauxv.obf.cmb
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v31, types: [byte[], java.io.Serializable] */
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                Object objX;
                blv blvVar2 = blvVar;
                String name = method.getName();
                if (name != null) {
                    switch (name.hashCode()) {
                        case -1776922004:
                            if (name.equals("toString" /* cnb.z(-134415296494378L) */)) {
                                return obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                            }
                            break;
                        case -1295482945:
                            if (name.equals("equals" /* cnb.z(-134995117079338L) */)) {
                                return Boolean.valueOf(obj == objArr[0]);
                            }
                            break;
                        case 147696667:
                            if (name.equals("hashCode" /* cnb.z(-135033771785002L) */)) {
                                return Integer.valueOf(System.identityHashCode(obj));
                            }
                            break;
                        case 1994440622:
                            if (name.equals("onSceneEnd" /* cnb.z(-134376641788714L) */)) {
                                try {
                                    Object obj2 = objArr[0];
                                    throwIfVar1IsNull(obj2, "null cannot be cast to non-null type kotlin.Int" /* cnb.z(-134295037410090L) */);
                                    Integer num = (Integer) obj2;
                                    Object obj3 = objArr[1];
                                    throwIfVar1IsNull(obj3, "null cannot be cast to non-null type kotlin.Int" /* cnb.z(-134638634793770L) */);
                                    Integer num2 = (Integer) obj3;
                                    Object obj4 = objArr[2];
                                    String str3 = obj4 instanceof String ? (String) obj4 : null;
                                    throwIfVar1IsNull(objArr[3], "null cannot be cast to non-null type kotlin.Any" /* cnb.z(-134432476363562L) */);
                                    int i2 = bte.a;
                                    cde cdeVarT2 = dqc.bi(objArr[3]).t();
                                    cdeVarT2.ab = "getReqResp" /* cnb.z(-135875585375018L) */;
                                    cdeVarT2.ah();
                                    Object objE = ((cdk) aaz.e(cdeVarT2.aj())).e(new Object[0]);
                                    if (objE != null) {
                                        cde cdeVarT3 = dqc.bi(objE).t();
                                        cdeVarT3.ab = "getRespObj" /* cnb.z(-135845520603946L) */;
                                        cdeVarT3.ah();
                                        Object objE2 = ((cdk) aaz.e(cdeVarT3.aj())).e(new Object[0]);
                                        if (objE2 != null) {
                                            azg azgVarR = dqc.bi(objE2).r();
                                            azgVarR.ab = "a" /* cnb.z(-136313672039210L) */;
                                            azgVarR.ah();
                                            Object objD = ((azk) aaz.e(azgVarR.c())).d();
                                            if (objD != null) {
                                                cde cdeVarT4 = dqc.bi(objD).t();
                                                cdeVarT4.ab = "toByteArray" /* cnb.z(-136322261973802L) */;
                                                cdeVarT4.ah();
                                                ?? r10 = (byte[]) ((cdk) aaz.e(cdeVarT4.aj())).j(new Object[0]);
                                                if (r10 != 0) {
                                                    blvVar2.c(num, num2, str3, r10);
                                                }
                                            }
                                        }
                                    }
                                    objX = ens.a;
                                    break;
                                } catch (Throwable th) {
                                    objX = bhu.x(th);
                                }
                                return new dcy(objX);
                            }
                            break;
                    }
                }
                return null;
            }
        });
        Method methodBb = emn.bb(cmd.a);
        byr.a.getClass();
        Object objInvoke = methodBb.invoke(byr.c(), null);
        throwIfVar1IsNull(objInvoke);
        cdkVar.e(objInvoke, objNewProxyInstance);
    }

    @cty
    public final void sendVideo(String str, String str2)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        arj.ag(str, str2);
    }

    @cty
    public final void sendVoice(String str, String str2, int i)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        arj.ah(str, str2, i);
    }

    @cty
    public final void sendImage(String str, String str2)
            throws JSONException, IllegalAccessException, InstantiationException, InvocationTargetException {
        arj.ad(str, str2, null);
    }

    @cty
    public final void sendLocation(String str, JSONObject jSONObject) throws JSONException {
        arj.ae(str, jSONObject.optString("poiName" /* cnb.z(-403885839612714L) */),
                jSONObject.optString("label" /* cnb.z(-403851479874346L) */),
                jSONObject.optString("x" /* cnb.z(-403808530201386L) */), jSONObject.optString(
                        "y" /* cnb.z(-403817120135978L) */),
                jSONObject.optString("scale" /* cnb.z(-403825710070570L) */));
    }

    @cty
    public final void sendVoice(String str, String str2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        arj.ah(str, str2, cnh.w(str2));
    }
}
