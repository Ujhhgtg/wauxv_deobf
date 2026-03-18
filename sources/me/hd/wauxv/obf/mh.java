package me.hd.wauxv.obf;

import android.view.View;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mh extends SwitchHook implements bnc {
    public static final mh a = new mh("AutoTransformVoiceHook" /* "AutoTransformVoiceHook" /* "AutoTransformVoiceHook" /* cnb.z(-440427421367082L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-440861213063978L)  */;
    public static final String c = "自动语音转文" /* "自动语音转文" /* "自动语音转文" /* cnb.z(-440865508031274L)  */;
    public static final String d = "自动将微信聊天列表的语音消息转文字" /* "自动将微信聊天列表的语音消息转文字" /* "自动将微信聊天列表的语音消息转文字" /* cnb.z(-440835443260202L)  */;
    public static final LruCacheMap h = new LruCacheMap(100, 0.75f, true, 0);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) throws NoSuchMethodException {
        if (getIsEnabled() && msgInfoBean.isVoice()) {
            Long lValueOf = Long.valueOf(msgInfoBean.getMsgId());
            LruCacheMap lruCacheMapVar = h;
            Object obj3 = lruCacheMapVar.get(lValueOf);
            Boolean bool = Boolean.TRUE;
            if (nullSafeIsEqual(obj3, bool)) {
                return;
            }
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj2).createFieldResolver();
            fieldResolverVarR.fieldType = StaticHelpers7.toDexMethod(ApiManager$MethodGetApi.INSTANCE).getDeclaringClass();
            Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
            throwIfVar1IsNull(objD);
            Object api = ApiManagerGetApiDexFindHook.getApi((Class) SomeStaticHelpers.getFirstInArray(StaticHelpers7.toDexClass(Transform$ClassTransform.a).getInterfaces()), objD);
            long msgId = msgInfoBean.getMsgId();
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(api).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.returnTypeCondition = new dos(4);
            Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(Long.TYPE) }, 1, methodResolverVarT)).invoke(Long.valueOf(msgId));
            throwIfVar1IsNull(objJ);
            if (nullSafeIsEqual(objJ.toString(), "NoTransform" /* "NoTransform" /* "NoTransform" /* cnb.z(-440878392933162L)  */)) {
                lruCacheMapVar.put(Long.valueOf(msgInfoBean.getMsgId()), true);
                Object origin = msgInfoBean.getInstance();
                MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(api).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT2.returnType = Void.TYPE;
                ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE), Boolean.TYPE, dal.getKClassFromClass(Integer.TYPE), dal.getKClassFromClass(Integer.TYPE) }, 4, methodResolverVarT2)).invokeAndThrowIfFailed(origin,
                        Boolean.FALSE, -1, 0);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
