package me.hd.wauxv.data.bean;

import me.hd.wauxv.obf.azg;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConversationBean {
    private final String content;
    private final long conversationTime;
    private final String digest;
    private final String digestUser;
    private final long flag;
    private final int isSendInt;
    private final int msgCount;
    private final String msgType;
    private final Object origin;
    private final String parentRef;
    private final int unReadCount;
    private final String username;

    public ConversationBean(Object obj) throws IllegalAccessException {
        this.origin = obj;
        int i = 0;
        azg azgVarR = dqc.bi(obj).r();
        azgVarR.ab = "field_msgCount" /* "field_msgCount" /* "field_msgCount" /* cnb.z(-12468290059050L)  */;
        Object objE = ((azk) yg.e(azgVarR)).e();
        throwIfVar1IsNull(objE);
        this.msgCount = ((Number) objE).intValue();
        azg azgVarR2 = dqc.bi(obj).r();
        azgVarR2.ab = "field_username" /* "field_username" /* "field_username" /* cnb.z(-12403865549610L)  */;
        Object objE2 = ((azk) yg.e(azgVarR2)).e();
        throwIfVar1IsNull(objE2);
        this.username = (String) objE2;
        azg azgVarR3 = dqc.bi(obj).r();
        azgVarR3.ab = "field_unReadCount" /* "field_unReadCount" /* "field_unReadCount" /* cnb.z(-9573482101546L)  */;
        Object objE3 = ((azk) yg.e(azgVarR3)).e();
        throwIfVar1IsNull(objE3);
        this.unReadCount = ((Number) objE3).intValue();
        azg azgVarR4 = dqc.bi(obj).r();
        azgVarR4.ab = "field_isSend" /* "field_isSend" /* "field_isSend" /* cnb.z(-9513352559402L)  */;
        Object objE4 = ((azk) yg.e(azgVarR4)).e();
        throwIfVar1IsNull(objE4);
        this.isSendInt = ((Number) objE4).intValue();
        azg azgVarR5 = dqc.bi(obj).r();
        azgVarR5.ab = "field_conversationTime" /* "field_conversationTime" /* "field_conversationTime" /* cnb.z(-9440338115370L)  */;
        Object objE5 = ((azk) yg.e(azgVarR5)).e();
        throwIfVar1IsNull(objE5);
        this.conversationTime = ((Number) objE5).longValue();
        azg azgVarR6 = dqc.bi(obj).r();
        azgVarR6.ab = "field_content" /* "field_content" /* "field_content" /* cnb.z(-9874129812266L)  */;
        this.content = (String) ((azk) yg.e(azgVarR6)).e();
        azg azgVarR7 = dqc.bi(obj).r();
        azgVarR7.ab = "field_msgType" /* "field_msgType" /* "field_msgType" /* cnb.z(-9796820400938L)  */;
        Object objE6 = ((azk) yg.e(azgVarR7)).e();
        throwIfVar1IsNull(objE6);
        this.msgType = (String) objE6;
        azg azgVarR8 = dqc.bi(obj).r();
        azgVarR8.ab = "field_flag" /* "field_flag" /* "field_flag" /* cnb.z(-9788230466346L)  */;
        Object objE7 = ((azk) yg.e(azgVarR8)).e();
        throwIfVar1IsNull(objE7);
        this.flag = ((Number) objE7).longValue();
        azg azgVarR9 = dqc.bi(obj).r();
        azgVarR9.ab = "field_digest" /* "field_digest" /* "field_digest" /* cnb.z(-9706626087722L)  */;
        this.digest = (String) ((azk) yg.e(azgVarR9)).e();
        azg azgVarR10 = dqc.bi(obj).r();
        azgVarR10.ab = "field_digestUser" /* "field_digestUser" /* "field_digestUser" /* cnb.z(-9685151251242L)  */;
        Object objE8 = ((azk) yg.e(azgVarR10)).e();
        throwIfVar1IsNull(objE8);
        this.digestUser = (String) objE8;
        azg azgVarR11 = dqc.bi(obj).r();
        azgVarR11.ab = "field_parentRef" /* "field_parentRef" /* "field_parentRef" /* cnb.z(-9010841385770L)  */;
        this.parentRef = (String) ((azk) yg.e(azgVarR11)).e();
    }

    public final String getContent() {
        return this.content;
    }

    public final long getConversationTime() {
        return this.conversationTime;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getDigestUser() {
        return this.digestUser;
    }

    public final long getFlag() {
        return this.flag;
    }

    public final int getMsgCount() {
        return this.msgCount;
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public final Object getOrigin() {
        return this.origin;
    }

    public final String getParentRef() {
        return this.parentRef;
    }

    public final int getUnReadCount() {
        return this.unReadCount;
    }

    public final String getUsername() {
        return this.username;
    }

    public final boolean isSend() {
        return this.isSendInt == 1;
    }

    public final int isSendInt() {
        return this.isSendInt;
    }
}
