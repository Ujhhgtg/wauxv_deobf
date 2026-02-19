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
    public static final mg h = new mg(100, 0.75f, true, 0);

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
            mg mgVar = h;
            Object obj3 = mgVar.get(lValueOf);
            Boolean bool = Boolean.TRUE;
            if (nullSafeIsEqual(obj3, bool)) {
                return;
            }
            int i = 0;
            azg azgVarR = dqc.bi(obj2).r();
            gp.a.getClass();
            azgVarR.a = emn.bb(go.a).getDeclaringClass();
            Object objD = ((azk) aaz.e(azgVarR.c())).d();
            throwIfVar1IsNull(objD);
            elb.a.getClass();
            Object objB = gp.b((Class) SomeStaticHelpers.p(emn.az(ela.a).getInterfaces()), objD);
            long msgId = msgInfoBean.getMsgId();
            cde cdeVarT = dqc.bi(objB).t();
            cdeVarT.ai = new dos(4);
            Object objJ = ((MethodHookWrapper) dkz.n(new Object[] { dal.b(Long.TYPE) }, 1, cdeVarT)).j(Long.valueOf(msgId));
            throwIfVar1IsNull(objJ);
            if (nullSafeIsEqual(objJ.toString(), "NoTransform" /* "NoTransform" /* "NoTransform" /* cnb.z(-440878392933162L)  */)) {
                mgVar.put(Long.valueOf(msgInfoBean.getMsgId()), bool);
                Object origin = msgInfoBean.getOrigin();
                cde cdeVarT2 = dqc.bi(objB).t();
                cdeVarT2.a = Void.TYPE;
                cge.a.getClass();
                Class clsAz = emn.az(cgd.a);
                zc zcVarB = dal.b(Boolean.TYPE);
                Class cls = Integer.TYPE;
                ((MethodHookWrapper) dkz.n(new Object[] { clsAz, zcVarB, dal.b(cls), dal.b(cls) }, 4, cdeVarT2)).e(origin,
                        Boolean.FALSE, -1, 0);
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }
}
