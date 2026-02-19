package me.hd.wauxv.data.bean;

import me.hd.wauxv.obf.FieldResolver;
import me.hd.wauxv.obf.BoundField;
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
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR.name = "field_msgCount" /* "field_msgCount" /* "field_msgCount" /* cnb.z(-12468290059050L)  */;
        Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
        throwIfVar1IsNull(objE);
        this.msgCount = ((Number) objE).intValue();
        FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR2.name = "field_username" /* "field_username" /* "field_username" /* cnb.z(-12403865549610L)  */;
        Object objE2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue_();
        throwIfVar1IsNull(objE2);
        this.username = (String) objE2;
        FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR3.name = "field_unReadCount" /* "field_unReadCount" /* "field_unReadCount" /* cnb.z(-9573482101546L)  */;
        Object objE3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
        throwIfVar1IsNull(objE3);
        this.unReadCount = ((Number) objE3).intValue();
        FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR4.name = "field_isSend" /* "field_isSend" /* "field_isSend" /* cnb.z(-9513352559402L)  */;
        Object objE4 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue_();
        throwIfVar1IsNull(objE4);
        this.isSendInt = ((Number) objE4).intValue();
        FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR5.name = "field_conversationTime" /* "field_conversationTime" /* "field_conversationTime" /* cnb.z(-9440338115370L)  */;
        Object objE5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue_();
        throwIfVar1IsNull(objE5);
        this.conversationTime = ((Number) objE5).longValue();
        FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR6.name = "field_content" /* "field_content" /* "field_content" /* cnb.z(-9874129812266L)  */;
        this.content = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR6)).getValue_();
        FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR7.name = "field_msgType" /* "field_msgType" /* "field_msgType" /* cnb.z(-9796820400938L)  */;
        Object objE6 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR7)).getValue_();
        throwIfVar1IsNull(objE6);
        this.msgType = (String) objE6;
        FieldResolver fieldResolverVarR8 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR8.name = "field_flag" /* "field_flag" /* "field_flag" /* cnb.z(-9788230466346L)  */;
        Object objE7 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR8)).getValue_();
        throwIfVar1IsNull(objE7);
        this.flag = ((Number) objE7).longValue();
        FieldResolver fieldResolverVarR9 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR9.name = "field_digest" /* "field_digest" /* "field_digest" /* cnb.z(-9706626087722L)  */;
        this.digest = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR9)).getValue_();
        FieldResolver fieldResolverVarR10 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR10.name = "field_digestUser" /* "field_digestUser" /* "field_digestUser" /* cnb.z(-9685151251242L)  */;
        Object objE8 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR10)).getValue_();
        throwIfVar1IsNull(objE8);
        this.digestUser = (String) objE8;
        FieldResolver fieldResolverVarR11 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR11.name = "field_parentRef" /* "field_parentRef" /* "field_parentRef" /* cnb.z(-9010841385770L)  */;
        this.parentRef = (String) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR11)).getValue_();
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
