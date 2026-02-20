package me.hd.wauxv.obf;

import android.content.ContentValues;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class diz extends SwitchHook implements boa, IDatabaseOperationsListener {
    public static final diz b = new diz("SnsFakeLikeHook" /* "SnsFakeLikeHook" /* "SnsFakeLikeHook" /* cnb.z(-529616712235818L)  */);
    public static final String c = "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-535290364033834L)  */;
    public static final String h = "朋友圈伪点赞" /* "朋友圈伪点赞" /* "朋友圈伪点赞" /* cnb.z(-535238824426282L)  */;
    public static final String i = "支持朋友圈自定义消息的好友点赞数量" /* "支持朋友圈自定义消息的好友点赞数量" /* "支持朋友圈自定义消息的好友点赞数量" /* cnb.z(-535191579786026L)  */;

    public static Set m(long j) {
        Object next;
        StringBuilder sb;
        Iterator it = diy.a.n().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            sb = new StringBuilder();
            sb.append(j);
            sb.append('|');
        } while (!dnr.bp((String) next, sb.toString(), false));
        String str = (String) next;
        return str != null ? StaticHelpers5.ad(dnj.as(dnj.au(str, "|" /* "|" /* "|" /* cnb.z(-529547992759082L)  */, str),
                new String[] { ";" /* ";" /* ";" /* cnb.z(-529487863216938L)  */ })) : avh.a;
    }

    @Override // me.hd.wauxv.obf.boa
    public final List a() {
        return !z() ? EmptyReadonlyList.INSTANCE
                : dqc.toSingletonList(new djl(R.id.MenuItem_Sns_Like, "伪点赞[WA]" /* "伪点赞[WA]" /* "伪点赞[WA]" /* cnb.z(-529496453151530L)  */, new wx(1)));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void j(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr, int i2)
            throws IllegalAccessException {
        r(str, contentValues);
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void l(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr, int i2)
            throws IllegalAccessException {
        r(str, contentValues);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    public final void r(String str, ContentValues contentValues) throws IllegalAccessException {
        if (getIsEnabled() && str.equals("SnsInfo" /* "SnsInfo" /* "SnsInfo" /* cnb.z(-529462093413162L)  */)) {
            Object obj = contentValues.get("snsId" /* "snsId" /* "snsId" /* cnb.z(-529427733674794L)  */);
            throwIfVar1IsNull(obj, "null cannot be cast to non-null type kotlin.Long" /* "null cannot be cast to non-null type kotlin.Long" /* "null cannot be cast to non-null type kotlin.Long" /* cnb.z(-529934539815722L)  */);
            Set<String> setM = m(((Long) obj).longValue());
            if (setM.isEmpty()) {
                return;
            }
            Class clsAg = ajn.tryGetClassByClassName("com.tencent.mm.protocal.protobuf.SnsObject" /* "com.tencent.mm.protocal.protobuf.SnsObject" /* "com.tencent.mm.protocal.protobuf.SnsObject" /* cnb.z(-529741266287402L)  */);
            Object obj2 = contentValues.get("attrBuf" /* "attrBuf" /* "attrBuf" /* cnb.z(-529024006748970L)  */);
            throwIfVar1IsNull(obj2, "null cannot be cast to non-null type kotlin.ByteArray" /*
                                                                                             * "null cannot be cast to non-null type kotlin.ByteArray" /* "null cannot be cast to non-null type kotlin.ByteArray" /* cnb.z(-528989647010602L)  */
                                                                                             */);
            Object objC = ReflectionWrapper.createInstanceWithArgs(clsAg, new Object[0]);
            int i2 = 0;
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "parseFrom" /* "parseFrom" /* "parseFrom" /* cnb.z(-529290294721322L)  */;
            methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(byte[].class) }, 1));
            methodResolverVarT.enableSuperclass();
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed((byte[]) obj2);
            SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(objC);
            LinkedList linkedList = new LinkedList();
            for (String str2 : setM) {
                dkn.a.getClass();
                Object objC2 = ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.toDexClass(dkm.a), new Object[0]);
                int i3 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objC2).r();
                fieldResolverVarR.name = "d" /* "d" /* "d" /* cnb.z(-529264524917546L)  */;
                ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).setValue(str2);
                linkedList.push(objC2);
            }
            int size = linkedList.size();
            int i4 = !linkedList.isEmpty() ? 1 : 0;
            FieldResolver fieldResolverVarR2 = bmuVarBi.r();
            fieldResolverVarR2.name = "LikeUserList" /* "LikeUserList" /* "LikeUserList" /* cnb.z(-529273114852138L)  */;
            ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).setValue(linkedList);
            FieldResolver fieldResolverVarR3 = bmuVarBi.r();
            fieldResolverVarR3.name = "LikeUserListCount" /* "LikeUserListCount" /* "LikeUserListCount" /* cnb.z(-529200100408106L)  */;
            ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).setValue(Integer.valueOf(size));
            FieldResolver fieldResolverVarR4 = bmuVarBi.r();
            fieldResolverVarR4.name = "LikeCount" /* "LikeCount" /* "LikeCount" /* cnb.z(-535187284818730L)  */;
            ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).setValue(Integer.valueOf(size));
            FieldResolver fieldResolverVarR5 = bmuVarBi.r();
            fieldResolverVarR5.name = "LikeFlag" /* "LikeFlag" /* "LikeFlag" /* cnb.z(-535092795538218L)  */;
            ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR5.resolve())).setValue(Integer.valueOf(i4));
            int i5 = 0;
            MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.returnType = dal.getKClassFromClass(byte[].class);
            methodResolverVarT2.name = "toByteArray" /* "toByteArray" /* "toByteArray" /* cnb.z(-535054140832554L)  */;
            Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).invoke(new Object[0]);
            throwIfVar1IsNull(objJ);
            contentValues.put("attrBuf" /* "attrBuf" /* "attrBuf" /* cnb.z(-535036960963370L)  */, (byte[]) objJ);
        }
    }
}
