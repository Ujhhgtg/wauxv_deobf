package me.hd.wauxv.data.bean.info;

import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FriendInfo {
    private String alias;
    private long createTime;
    private String nickname;
    private String remark;
    private String sourceExtInfo;
    private int type;
    private String wxid;

    public FriendInfo(String str, String str2, String str3, String str4, int i, String str5, long j) {
        this.wxid = str;
        this.alias = str2;
        this.remark = str3;
        this.nickname = str4;
        this.type = i;
        this.sourceExtInfo = str5;
        this.createTime = j;
    }

    public static /* synthetic */ FriendInfo copy$default(FriendInfo friendInfo, String str, String str2, String str3, String str4, int i, String str5, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = friendInfo.wxid;
        }
        if ((i2 & 2) != 0) {
            str2 = friendInfo.alias;
        }
        if ((i2 & 4) != 0) {
            str3 = friendInfo.remark;
        }
        if ((i2 & 8) != 0) {
            str4 = friendInfo.nickname;
        }
        if ((i2 & 16) != 0) {
            i = friendInfo.type;
        }
        if ((i2 & 32) != 0) {
            str5 = friendInfo.sourceExtInfo;
        }
        if ((i2 & 64) != 0) {
            j = friendInfo.createTime;
        }
        long j2 = j;
        int i3 = i;
        String str6 = str5;
        return friendInfo.copy(str, str2, str3, str4, i3, str6, j2);
    }

    public final String component1() {
        return this.wxid;
    }

    public final String component2() {
        return this.alias;
    }

    public final String component3() {
        return this.remark;
    }

    public final String component4() {
        return this.nickname;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.sourceExtInfo;
    }

    public final long component7() {
        return this.createTime;
    }

    public final FriendInfo copy(String str, String str2, String str3, String str4, int i, String str5, long j) {
        return new FriendInfo(str, str2, str3, str4, i, str5, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FriendInfo)) {
            return false;
        }
        FriendInfo friendInfo = (FriendInfo) obj;
        return bzo.f(this.wxid, friendInfo.wxid) && bzo.f(this.alias, friendInfo.alias) && bzo.f(this.remark, friendInfo.remark) && bzo.f(this.nickname, friendInfo.nickname) && this.type == friendInfo.type && bzo.f(this.sourceExtInfo, friendInfo.sourceExtInfo) && this.createTime == friendInfo.createTime;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getSourceExtInfo() {
        return this.sourceExtInfo;
    }

    public final int getType() {
        return this.type;
    }

    public final String getWxid() {
        return this.wxid;
    }

    public int hashCode() {
        return Long.hashCode(this.createTime) + bjs.e(this.sourceExtInfo, dts.a(this.type, bjs.e(this.nickname, bjs.e(this.remark, bjs.e(this.alias, this.wxid.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final void setSourceExtInfo(String str) {
        this.sourceExtInfo = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setWxid(String str) {
        this.wxid = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FriendInfo(wxid=" /* cnb.z(-14864881810218L) */);
        yg.u(sb, this.wxid, -15358803049258L);
        yg.u(sb, this.alias, -15320148343594L);
        yg.u(sb, this.remark, -15225659063082L);
        yg.u(sb, this.nickname, -15208479193898L);
        dkz.ac(sb, this.type, -15174119455530L);
        yg.u(sb, this.sourceExtInfo, -14568529066794L);
        sb.append(this.createTime);
        sb.append(')');
        return sb.toString();
    }
}
