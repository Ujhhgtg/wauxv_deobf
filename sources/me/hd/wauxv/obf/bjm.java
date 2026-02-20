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
public final class bjm extends SwitchHook implements bnc {
    public static final bjm a;
    public static final String b;
    public static final String c;
    public static final String h;
    public static final bep j;
    public static final Kotlin$Lazy l;
    public static final Kotlin$Lazy m;
    public static final Kotlin$Lazy n;
    public static final Kotlin$Lazy r;
    public static final LinkedHashMap s;

    static {
        "#FFF9E8C8" /* "#FFF9E8C8" /* "#FFF9E8C8" /* cnb.z(-502317900102442L)  */;
        "#FFFEF3D6" /* "#FFFEF3D6" /* "#FFFEF3D6" /* cnb.z(-502292130298666L)  */;
        "#FFE87A20" /* "#FFE87A20" /* "#FFE87A20" /* cnb.z(-502266360494890L)  */;
        "#FFA3F0E6" /* "#FFA3F0E6" /* "#FFA3F0E6" /* cnb.z(-501622115400490L)  */;
        "#FFE0F7F4" /* "#FFE0F7F4" /* "#FFE0F7F4" /* cnb.z(-501596345596714L)  */;
        "#FF3AAE9D" /* "#FF3AAE9D" /* "#FF3AAE9D" /* cnb.z(-501570575792938L)  */;
        "#FFF2D5F8" /* "#FFF2D5F8" /* "#FFF2D5F8" /* cnb.z(-501544805989162L)  */;
        "#FFF9EBFC" /* "#FFF9EBFC" /* "#FFF9EBFC" /* cnb.z(-501450316708650L)  */;
        "#FFA64BDB" /* "#FFA64BDB" /* "#FFA64BDB" /* cnb.z(-501424546904874L)  */;
        "#FFD8D8D8" /* "#FFD8D8D8" /* "#FFD8D8D8" /* cnb.z(-501398777101098L)  */;
        "#FFE0E0E0" /* "#FFE0E0E0" /* "#FFE0E0E0" /* cnb.z(-501922763111210L)  */;
        "#FF666666" /* "#FF666666" /* "#FF666666" /* cnb.z(-501828273830698L)  */;
        "#FFFFD56A" /* "#FFFFD56A" /* "#FFFFD56A" /* cnb.z(-501802504026922L)  */;
        "#FFFFE87A" /* "#FFFFE87A" /* "#FFFFE87A" /* cnb.z(-501776734223146L)  */;
        "#FF4DD5CC" /* "#FF4DD5CC" /* "#FF4DD5CC" /* cnb.z(-501750964419370L)  */;
        "#FF68E8DF" /* "#FF68E8DF" /* "#FF68E8DF" /* cnb.z(-501656475138858L)  */;
        "#FFD0A3FF" /* "#FFD0A3FF" /* "#FFD0A3FF" /* cnb.z(-503279972776746L)  */;
        "#FFEFBFFF" /* "#FFEFBFFF" /* "#FFEFBFFF" /* cnb.z(-503254202972970L)  */;
        "#FF95A0B8" /* "#FF95A0B8" /* "#FF95A0B8" /* cnb.z(-503228433169194L)  */;
        "#FFA8B2C9" /* "#FFA8B2C9" /* "#FFA8B2C9" /* cnb.z(-503133943888682L)  */;
        "#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-503108174084906L)  */;
        a = new bjm("GroupOwnerTitleHook" /* "GroupOwnerTitleHook" /* "GroupOwnerTitleHook" /* cnb.z(-505320082242346L)  */);
        b = "群组" /* "群组" /* "群组" /* cnb.z(-503082404281130L)  */;
        c = "显示群头衔" /* "显示群头衔" /* "显示群头衔" /* cnb.z(-503035159640874L)  */;
        h = "在微信群成员聊天列表显示对应的头衔" /* "在微信群成员聊天列表显示对应的头衔" /* "在微信群成员聊天列表显示对应的头衔" /* cnb.z(-503060929444650L)  */;
        j = new bep(3);
        l = new Kotlin$Lazy(new amd(11));
        m = new Kotlin$Lazy(new amd(12));
        n = new Kotlin$Lazy(new amd(13));
        r = new Kotlin$Lazy(new amd(14));
        s = new LinkedHashMap();
    }

    public static final void t(bjm bjmVar) {
        bjmVar.getClass();
        for (Object obj : JSON.parseArray(bjk.a.o())) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString("id" /* "id" /* "id" /* cnb.z(-505749578971946L)  */);
                String string2 = jSONObject.getString("desc" /* "desc" /* "desc" /* cnb.z(-505753873939242L)  */);
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0) {
                    String strAz = StringsKt.az(6, string2);
                    a.getClass();
                    s.put(string, new Pair(strAz, (bix) n.getValue()));
                }
            }
        }
    }

    public static final void u(bjm bjmVar) {
        bjmVar.getClass();
        for (Object obj : JSON.parseArray(bjl.a.o())) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString("id" /* "id" /* "id" /* cnb.z(-505715219233578L)  */);
                String string2 = jSONObject.getString("title" /* "title" /* "title" /* cnb.z(-505719514200874L)  */);
                JSONArray jSONArray = jSONObject.getJSONArray("span" /* "span" /* "span" /* cnb.z(-505676564527914L)  */);
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0
                        && jSONArray != null && !jSONArray.isEmpty()) {
                    s.put(string,
                            new Pair(StringsKt.az(6, string2), new bix(new int[] { Color.parseColor(jSONArray.getString(0)),
                                    Color.parseColor(jSONArray.getString(1)) }, 0, 14)));
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        Dispatchers$Default alcVar = aou.a;
        KotlinHelpers2.bf(Dispatchers$IO.INSTANCE, new eq(2, (kotlinx$coroutines$internal$DispatchedContinuation) null));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    /* JADX WARN: Found duplicated region for block: B:34:0x010d */
    /* JADX WARN: Found duplicated region for block: B:46:0x017d */
    /* JADX WARN: Found duplicated region for block: B:47:0x0182 */
    /* JADX WARN: Found duplicated region for block: B:50:0x0189 */
    /* JADX WARN: Found duplicated region for block: B:52:0x01bc */
    /* JADX WARN: Found duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean)
            throws IllegalAccessException, InvocationTargetException {
        boolean zF;
        boolean zBooleanValue;
        Pair pairVar;
        String strZ;
        String str;
        bix bixVar;
        TextView textView;
        String strValueOf;
        String strZ2;
        if (getIsEnabled() && msgInfoBean.isGroupChat()) {
            Pair pairVar2 = (Pair) s.get(msgInfoBean.getSendTalker());
            mg mgVar = xh.a;
            String talker = msgInfoBean.getTalker();
            String sendTalker = msgInfoBean.getSendTalker();
            Pair pairVar3 = new Pair(talker, sendTalker);
            mg mgVar2 = xh.a;
            Boolean bool = (Boolean) mgVar2.get(pairVar3);
            if (bool != null) {
                zF = bool.booleanValue();
            } else {
                xp.a.getClass();
                Object objB = xp.b(talker);
                if (objB == null) {
                    zF = false;
                } else {
                    wv.a.getClass();
                    int i = 0;
                    FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objB).r();
                    fieldResolverVarR.name = "field_roomowner" /* "field_roomowner" /* "field_roomowner" /* cnb.z(-99733435579178L)  */;
                    zF = nullSafeIsEqual((String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_(), sendTalker);
                    mgVar2.put(pairVar3, Boolean.valueOf(zF));
                }
            }
            if (zF) {
                if (pairVar2 == null || (strZ2 = (String) pairVar2.a) == null) {
                    strZ2 = "群主" /* "群主" /* "群主" /* cnb.z(-505706629298986L)  */;
                }
                pairVar = new Pair(strZ2, (bix) l.getValue());
            } else {
                String talker2 = msgInfoBean.getTalker();
                String sendTalker2 = msgInfoBean.getSendTalker();
                Pair pairVar4 = new Pair(talker2, sendTalker2);
                mg mgVar3 = xh.b;
                Boolean bool2 = (Boolean) mgVar3.get(pairVar4);
                if (bool2 != null) {
                    zBooleanValue = bool2.booleanValue();
                } else {
                    xp.a.getClass();
                    Object objB2 = xp.b(talker2);
                    if (objB2 == null) {
                        zBooleanValue = false;
                    } else {
                        wv.a.getClass();
                        Object objInvoke = StaticHelpers7.toDexMethod(wu.a).invoke(objB2, sendTalker2);
                        if (objInvoke != null) {
                            int i2 = 0;
                            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objInvoke).r();
                            fieldResolverVarR2.name = "f" /* "f" /* "f" /* cnb.z(-99664716102442L)  */;
                            Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue_();
                            throwIfVar1IsNull(objE);
                            zBooleanValue = (((Number) objE).intValue() & 2048) != 0;
                        }
                        mgVar3.put(pairVar4, Boolean.valueOf(zBooleanValue));
                    }
                }
                if (!zBooleanValue) {
                    if (pairVar2 == null) {
                        pairVar = new Pair("群员" /* "群员" /* "群员" /* cnb.z(-505663679626026L)  */, (bix) r.getValue());
                    }
                    str = (String) pairVar2.a;
                    bixVar = (bix) pairVar2.b;
                    int i3 = 0;
                    FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).r();
                    fieldResolverVarR3.name = "userTV" /* "userTV" /* "userTV" /* cnb.z(-505667974593322L)  */;
                    textView = (TextView) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
                    strValueOf = String.valueOf(textView != null ? textView.getText() : null);
                    if (textView != null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                str + ' ' + strValueOf);
                        spannableStringBuilder.setSpan(bixVar, 0, str.length(), 33);
                        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 33);
                        textView.setText(spannableStringBuilder);
                    }
                    if (textView != null) {
                        textView.setEllipsize(null);
                    }
                }
                if (pairVar2 == null || (strZ = (String) pairVar2.a) == null) {
                    strZ = "管理" /* "管理" /* "管理" /* cnb.z(-505642204789546L)  */;
                }
                pairVar = new Pair(strZ, (bix) m.getValue());
            }
            pairVar2 = pairVar;
            str = (String) pairVar2.a;
            bixVar = (bix) pairVar2.b;
            int i32 = 0;
            FieldResolver fieldResolverVarR32 = dqc.getWrapperConfiguration(obj).r();
            fieldResolverVarR32.name = "userTV" /* "userTV" /* "userTV" /* cnb.z(-505667974593322L)  */;
            textView = (TextView) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR32)).getValue_();
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

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return j;
    }
}
