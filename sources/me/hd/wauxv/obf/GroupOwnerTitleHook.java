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
public final class GroupOwnerTitleHook extends SwitchHook implements bnc {
    public static final GroupOwnerTitleHook a;
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
//        "#FFF9E8C8";
//        "#FFFEF3D6";
//        "#FFE87A20";
//        "#FFA3F0E6";
//        "#FFE0F7F4";
//        "#FF3AAE9D";
//        "#FFF2D5F8";
//        "#FFF9EBFC";
//        "#FFA64BDB";
//        "#FFD8D8D8";
//        "#FFE0E0E0";
//        "#FF666666";
//        "#FFFFD56A";
//        "#FFFFE87A";
//        "#FF4DD5CC";
//        "#FF68E8DF";
//        "#FFD0A3FF";
//        "#FFEFBFFF";
//        "#FF95A0B8";
//        "#FFA8B2C9";
//        "#FFFFFFFF";
        a = new GroupOwnerTitleHook("GroupOwnerTitleHook");
        b = "群组";
        c = "显示群头衔";
        h = "在微信群成员聊天列表显示对应的头衔";
        j = new bep(3);
        l = new Kotlin$Lazy(new amd(11));
        m = new Kotlin$Lazy(new amd(12));
        n = new Kotlin$Lazy(new amd(13));
        r = new Kotlin$Lazy(new amd(14));
        s = new LinkedHashMap();
    }

    public static final void t(GroupOwnerTitleHook groupOwnerTitleHookVar) {
        groupOwnerTitleHookVar.getClass();
        for (Object obj : JSON.parseArray(bjk.a.o())) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                String string = jSONObject.getString("id" /* "id" /* "id" /* cnb.z(-505749578971946L)  */);
                String string2 = jSONObject.getString("desc" /* "desc" /* "desc" /* cnb.z(-505753873939242L)  */);
                if (string != null && string.length() != 0 && string2 != null && string2.length() != 0) {
                    String strAz = StringsKt.az(6, string2);
                    a.getClass();
                    s.put(string, new Pair(strAz, n.getValue()));
                }
            }
        }
    }

    public static final void u(GroupOwnerTitleHook groupOwnerTitleHookVar) {
        groupOwnerTitleHookVar.getClass();
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
        Dispatchers$Default alcVar = StaticDefaultDispatcherProvider.DISPATCHERS_DEFAULT;
        KotlinHelpers2.bf(Dispatchers$IO.INSTANCE, new eq(2, null));
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
            String talker = msgInfoBean.getTalker();
            String sendTalker = msgInfoBean.getSendTalker();
            Pair pairVar3 = new Pair(talker, sendTalker);
            LruCacheMap lruCacheMapVar2 = StaticMapsProvider.MAP_1;
            Boolean bool = (Boolean) lruCacheMapVar2.get(pairVar3);
            if (bool != null) {
                zF = bool.booleanValue();
            } else {
                Object objB = xp.getChatroomMember(talker);
                if (objB == null) {
                    zF = false;
                } else {
                    FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objB).createFieldResolver();
                    fieldResolverVarR.name = "field_roomowner";
                    zF = nullSafeIsEqual((String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_(), sendTalker);
                    lruCacheMapVar2.put(pairVar3, zF);
                }
            }
            if (zF) {
                if (pairVar2 == null || (strZ2 = (String) pairVar2.first) == null) {
                    strZ2 = "群主";
                }
                pairVar = new Pair(strZ2, l.getValue());
            } else {
                String talker2 = msgInfoBean.getTalker();
                String sendTalker2 = msgInfoBean.getSendTalker();
                Pair pairVar4 = new Pair(talker2, sendTalker2);
                LruCacheMap lruCacheMapVar3 = StaticMapsProvider.MAP_2;
                Boolean bool2 = (Boolean) lruCacheMapVar3.get(pairVar4);
                if (bool2 != null) {
                    zBooleanValue = bool2;
                } else {
                    Object objB2 = xp.getChatroomMember(talker2);
                    if (objB2 == null) {
                        zBooleanValue = false;
                    } else {
                        Object objInvoke = StaticHelpers7.toDexMethod(ChatRoomMember$MethodGetChatRoomData.INSTANCE).invoke(objB2, sendTalker2);
                        if (objInvoke != null) {
                            FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objInvoke).createFieldResolver();
                            fieldResolverVarR2.name = "f";
                            Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue_();
                            throwIfVar1IsNull(objE);
                            zBooleanValue = (((Number) objE).intValue() & 2048) != 0;
                        }
                        lruCacheMapVar3.put(pairVar4, Boolean.valueOf(zBooleanValue));
                    }
                }
                if (!zBooleanValue) {
                    if (pairVar2 == null) {
                        pairVar = new Pair("群员", r.getValue());
                    }
                    str = (String) pairVar2.first;
                    bixVar = (bix) pairVar2.second;
                    FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).createFieldResolver();
                    fieldResolverVarR3.name = "userTV";
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
                if (pairVar2 == null || (strZ = (String) pairVar2.first) == null) {
                    strZ = "管理";
                }
                pairVar = new Pair(strZ, m.getValue());
            }
            pairVar2 = pairVar;
            str = (String) pairVar2.first;
            bixVar = (bix) pairVar2.second;
            FieldResolver fieldResolverVarR32 = dqc.getWrapperConfiguration(obj).createFieldResolver();
            fieldResolverVarR32.name = "userTV";
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
    public final IInvokable getOnClick() {
        return j;
    }
}
