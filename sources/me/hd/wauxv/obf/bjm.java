package me.hd.wauxv.obf;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjm extends doo implements bnc {
    public static final bjm a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final bep j;
    public static final dov l;
    public static final dov m;
    public static final dov n;
    public static final dov r;
    public static final LinkedHashMap s;

    static {
        cnb.z(-502317900102442L);
        cnb.z(-502292130298666L);
        cnb.z(-502266360494890L);
        cnb.z(-501622115400490L);
        cnb.z(-501596345596714L);
        cnb.z(-501570575792938L);
        cnb.z(-501544805989162L);
        cnb.z(-501450316708650L);
        cnb.z(-501424546904874L);
        cnb.z(-501398777101098L);
        cnb.z(-501922763111210L);
        cnb.z(-501828273830698L);
        cnb.z(-501802504026922L);
        cnb.z(-501776734223146L);
        cnb.z(-501750964419370L);
        cnb.z(-501656475138858L);
        cnb.z(-503279972776746L);
        cnb.z(-503254202972970L);
        cnb.z(-503228433169194L);
        cnb.z(-503133943888682L);
        cnb.z(-503108174084906L);
        a = new bjm(cnb.z(-505320082242346L));
        b = cnb.z(-503082404281130L);
        c = cnb.z(-503035159640874L);
        h = cnb.z(-503060929444650L);
        j = new bep(3);
        l = new dov(new amd(11));
        m = new dov(new amd(12));
        n = new dov(new amd(13));
        r = new dov(new amd(14));
        s = new LinkedHashMap();
    }

    public static final void t(bjm bjmVar) {
        bjmVar.getClass();
        for (Object obj : JSON.parseArray(bjk.a.o())) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString(cnb.z(-505749578971946L));
                String string2 = jSONObject.getString(cnb.z(-505753873939242L));
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0) {
                    String strAz = dnj.az(6, string2);
                    a.getClass();
                    s.put(string, new csm(strAz, (bix) n.getValue()));
                }
            }
        }
    }

    public static final void u(bjm bjmVar) {
        bjmVar.getClass();
        for (Object obj : JSON.parseArray(bjl.a.o())) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString(cnb.z(-505715219233578L));
                String string2 = jSONObject.getString(cnb.z(-505719514200874L));
                JSONArray jSONArray = jSONObject.getJSONArray(cnb.z(-505676564527914L));
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0 && jSONArray != null && !jSONArray.isEmpty()) {
                    s.put(string, new csm(dnj.az(6, string2), new bix(new int[]{Color.parseColor(jSONArray.getString(0)), Color.parseColor(jSONArray.getString(1))}, 0, 14)));
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        alc alcVar = aou.a;
        cnd.bf(akq.f, new eq(2, (afw) null));
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x010d  */
    /* JADX WARN: Found duplicated region for block: B:46:0x017d  */
    /* JADX WARN: Found duplicated region for block: B:47:0x0182  */
    /* JADX WARN: Found duplicated region for block: B:50:0x0189  */
    /* JADX WARN: Found duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Found duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) throws IllegalAccessException, InvocationTargetException {
        boolean zF;
        boolean zBooleanValue;
        csm csmVar;
        String strZ;
        String str;
        bix bixVar;
        TextView textView;
        String strValueOf;
        String strZ2;
        if (z() && msgInfoBean.isGroupChat()) {
            csm csmVar2 = (csm) s.get(msgInfoBean.getSendTalker());
            mg mgVar = xh.a;
            String talker = msgInfoBean.getTalker();
            String sendTalker = msgInfoBean.getSendTalker();
            csm csmVar3 = new csm(talker, sendTalker);
            mg mgVar2 = xh.a;
            Boolean bool = (Boolean) mgVar2.get(csmVar3);
            if (bool != null) {
                zF = bool.booleanValue();
            } else {
                xp.a.getClass();
                Object objB = xp.b(talker);
                if (objB == null) {
                    zF = false;
                } else {
                    wv.a.getClass();
                    int i = bte.a;
                    azg azgVarR = dqc.bi(objB).r();
                    azgVarR.ab = cnb.z(-99733435579178L);
                    zF = bzo.f((String) ((azk) yg.e(azgVarR)).e(), sendTalker);
                    mgVar2.put(csmVar3, Boolean.valueOf(zF));
                }
            }
            if (zF) {
                if (csmVar2 == null || (strZ2 = (String) csmVar2.a) == null) {
                    strZ2 = cnb.z(-505706629298986L);
                }
                csmVar = new csm(strZ2, (bix) l.getValue());
            } else {
                String talker2 = msgInfoBean.getTalker();
                String sendTalker2 = msgInfoBean.getSendTalker();
                csm csmVar4 = new csm(talker2, sendTalker2);
                mg mgVar3 = xh.b;
                Boolean bool2 = (Boolean) mgVar3.get(csmVar4);
                if (bool2 != null) {
                    zBooleanValue = bool2.booleanValue();
                } else {
                    xp.a.getClass();
                    Object objB2 = xp.b(talker2);
                    if (objB2 == null) {
                        zBooleanValue = false;
                    } else {
                        wv.a.getClass();
                        Object objInvoke = emn.bb(wu.a).invoke(objB2, sendTalker2);
                        if (objInvoke != null) {
                            int i2 = bte.a;
                            azg azgVarR2 = dqc.bi(objInvoke).r();
                            azgVarR2.ab = cnb.z(-99664716102442L);
                            Object objE = ((azk) aaz.e(azgVarR2.c())).e();
                            bzo.n(objE);
                            zBooleanValue = (((Number) objE).intValue() & 2048) != 0;
                        }
                        mgVar3.put(csmVar4, Boolean.valueOf(zBooleanValue));
                    }
                }
                if (!zBooleanValue) {
                    if (csmVar2 == null) {
                        csmVar = new csm(cnb.z(-505663679626026L), (bix) r.getValue());
                    }
                    str = (String) csmVar2.a;
                    bixVar = (bix) csmVar2.b;
                    int i3 = bte.a;
                    azg azgVarR3 = dqc.bi(obj).r();
                    azgVarR3.ab = cnb.z(-505667974593322L);
                    textView = (TextView) ((azk) yg.e(azgVarR3)).e();
                    strValueOf = String.valueOf(textView != null ? textView.getText() : null);
                    if (textView != null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + ' ' + strValueOf);
                        spannableStringBuilder.setSpan(bixVar, 0, str.length(), 33);
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 33);
                        textView.setText(spannableStringBuilder);
                    }
                    if (textView != null) {
                        textView.setEllipsize(null);
                    }
                }
                if (csmVar2 == null || (strZ = (String) csmVar2.a) == null) {
                    strZ = cnb.z(-505642204789546L);
                }
                csmVar = new csm(strZ, (bix) m.getValue());
            }
            csmVar2 = csmVar;
            str = (String) csmVar2.a;
            bixVar = (bix) csmVar2.b;
            int i32 = bte.a;
            azg azgVarR32 = dqc.bi(obj).r();
            azgVarR32.ab = cnb.z(-505667974593322L);
            textView = (TextView) ((azk) yg.e(azgVarR32)).e();
            strValueOf = String.valueOf(textView != null ? textView.getText() : null);
            if (textView != null) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str + ' ' + strValueOf);
                spannableStringBuilder2.setSpan(bixVar, 0, str.length(), 33);
                spannableStringBuilder2.setSpan(new StyleSpan(1), 0, str.length(), 33);
                textView.setText(spannableStringBuilder2);
            }
            if (textView != null) {
                textView.setEllipsize(null);
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return j;
    }
}
