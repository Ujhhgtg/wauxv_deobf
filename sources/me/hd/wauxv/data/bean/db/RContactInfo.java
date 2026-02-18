package me.hd.wauxv.data.bean.db;

import java.util.Arrays;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RContactInfo {
    private String alias;
    private int chatroomFlag;
    private String conRemark;
    private String conRemarkPYFull;
    private String conRemarkPYShort;
    private byte[] contactExtra;
    private String contactLabelIds;
    private long createTime;
    private int deleteFlag;
    private String descWordingId;
    private String domainList;
    private String encryptUsername;
    private byte[] lvbuff;
    private String nickname;
    private String openImAppid;
    private String pyInitial;
    private String quanPin;
    private int showHead;
    private String sourceExtInfo;
    private String ticket;
    private int type;
    private long uiType;
    private String username;
    private long usernameFlag;
    private int verifyFlag;
    private int weiboFlag;
    private String weiboNickname;

    public RContactInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, long j, int i3, String str8, String str9, String str10, byte[] bArr, int i4, String str11, int i5, int i6, String str12, String str13, String str14, String str15, String str16, long j2, byte[] bArr2, long j3) {
        this.username = str;
        this.alias = str2;
        this.conRemark = str3;
        this.domainList = str4;
        this.nickname = str5;
        this.pyInitial = str6;
        this.quanPin = str7;
        this.showHead = i;
        this.type = i2;
        this.uiType = j;
        this.weiboFlag = i3;
        this.weiboNickname = str8;
        this.conRemarkPYFull = str9;
        this.conRemarkPYShort = str10;
        this.lvbuff = bArr;
        this.verifyFlag = i4;
        this.encryptUsername = str11;
        this.chatroomFlag = i5;
        this.deleteFlag = i6;
        this.contactLabelIds = str12;
        this.descWordingId = str13;
        this.openImAppid = str14;
        this.sourceExtInfo = str15;
        this.ticket = str16;
        this.usernameFlag = j2;
        this.contactExtra = bArr2;
        this.createTime = j3;
    }

    public static /* synthetic */ RContactInfo copy$default(RContactInfo rContactInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, long j, int i3, String str8, String str9, String str10, byte[] bArr, int i4, String str11, int i5, int i6, String str12, String str13, String str14, String str15, String str16, long j2, byte[] bArr2, long j3, int i7, Object obj) {
        long j4;
        byte[] bArr3;
        String str17 = (i7 & 1) != 0 ? rContactInfo.username : str;
        String str18 = (i7 & 2) != 0 ? rContactInfo.alias : str2;
        String str19 = (i7 & 4) != 0 ? rContactInfo.conRemark : str3;
        String str20 = (i7 & 8) != 0 ? rContactInfo.domainList : str4;
        String str21 = (i7 & 16) != 0 ? rContactInfo.nickname : str5;
        String str22 = (i7 & 32) != 0 ? rContactInfo.pyInitial : str6;
        String str23 = (i7 & 64) != 0 ? rContactInfo.quanPin : str7;
        int i8 = (i7 & 128) != 0 ? rContactInfo.showHead : i;
        int i9 = (i7 & 256) != 0 ? rContactInfo.type : i2;
        long j5 = (i7 & 512) != 0 ? rContactInfo.uiType : j;
        int i10 = (i7 & 1024) != 0 ? rContactInfo.weiboFlag : i3;
        String str24 = (i7 & 2048) != 0 ? rContactInfo.weiboNickname : str8;
        String str25 = (i7 & 4096) != 0 ? rContactInfo.conRemarkPYFull : str9;
        String str26 = str17;
        String str27 = (i7 & 8192) != 0 ? rContactInfo.conRemarkPYShort : str10;
        byte[] bArr4 = (i7 & 16384) != 0 ? rContactInfo.lvbuff : bArr;
        int i11 = (i7 & 32768) != 0 ? rContactInfo.verifyFlag : i4;
        String str28 = (i7 & 65536) != 0 ? rContactInfo.encryptUsername : str11;
        int i12 = (i7 & 131072) != 0 ? rContactInfo.chatroomFlag : i5;
        int i13 = (i7 & 262144) != 0 ? rContactInfo.deleteFlag : i6;
        String str29 = (i7 & Opcodes.ASM8) != 0 ? rContactInfo.contactLabelIds : str12;
        String str30 = (i7 & 1048576) != 0 ? rContactInfo.descWordingId : str13;
        String str31 = (i7 & 2097152) != 0 ? rContactInfo.openImAppid : str14;
        String str32 = (i7 & 4194304) != 0 ? rContactInfo.sourceExtInfo : str15;
        String str33 = (i7 & 8388608) != 0 ? rContactInfo.ticket : str16;
        byte[] bArr5 = bArr4;
        long j6 = (i7 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? rContactInfo.usernameFlag : j2;
        byte[] bArr6 = (i7 & 33554432) != 0 ? rContactInfo.contactExtra : bArr2;
        if ((i7 & 67108864) != 0) {
            bArr3 = bArr6;
            j4 = rContactInfo.createTime;
        } else {
            j4 = j3;
            bArr3 = bArr6;
        }
        return rContactInfo.copy(str26, str18, str19, str20, str21, str22, str23, i8, i9, j5, i10, str24, str25, str27, bArr5, i11, str28, i12, i13, str29, str30, str31, str32, str33, j6, bArr3, j4);
    }

    public final String component1() {
        return this.username;
    }

    public final long component10() {
        return this.uiType;
    }

    public final int component11() {
        return this.weiboFlag;
    }

    public final String component12() {
        return this.weiboNickname;
    }

    public final String component13() {
        return this.conRemarkPYFull;
    }

    public final String component14() {
        return this.conRemarkPYShort;
    }

    public final byte[] component15() {
        return this.lvbuff;
    }

    public final int component16() {
        return this.verifyFlag;
    }

    public final String component17() {
        return this.encryptUsername;
    }

    public final int component18() {
        return this.chatroomFlag;
    }

    public final int component19() {
        return this.deleteFlag;
    }

    public final String component2() {
        return this.alias;
    }

    public final String component20() {
        return this.contactLabelIds;
    }

    public final String component21() {
        return this.descWordingId;
    }

    public final String component22() {
        return this.openImAppid;
    }

    public final String component23() {
        return this.sourceExtInfo;
    }

    public final String component24() {
        return this.ticket;
    }

    public final long component25() {
        return this.usernameFlag;
    }

    public final byte[] component26() {
        return this.contactExtra;
    }

    public final long component27() {
        return this.createTime;
    }

    public final String component3() {
        return this.conRemark;
    }

    public final String component4() {
        return this.domainList;
    }

    public final String component5() {
        return this.nickname;
    }

    public final String component6() {
        return this.pyInitial;
    }

    public final String component7() {
        return this.quanPin;
    }

    public final int component8() {
        return this.showHead;
    }

    public final int component9() {
        return this.type;
    }

    public final RContactInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, long j, int i3, String str8, String str9, String str10, byte[] bArr, int i4, String str11, int i5, int i6, String str12, String str13, String str14, String str15, String str16, long j2, byte[] bArr2, long j3) {
        return new RContactInfo(str, str2, str3, str4, str5, str6, str7, i, i2, j, i3, str8, str9, str10, bArr, i4, str11, i5, i6, str12, str13, str14, str15, str16, j2, bArr2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!RContactInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        bzo.o(obj, cnb.z(-17544941402922L));
        RContactInfo rContactInfo = (RContactInfo) obj;
        return this.showHead == rContactInfo.showHead && this.type == rContactInfo.type && this.uiType == rContactInfo.uiType && this.weiboFlag == rContactInfo.weiboFlag && this.verifyFlag == rContactInfo.verifyFlag && this.chatroomFlag == rContactInfo.chatroomFlag && this.deleteFlag == rContactInfo.deleteFlag && this.usernameFlag == rContactInfo.usernameFlag && this.createTime == rContactInfo.createTime && bzo.f(this.username, rContactInfo.username) && bzo.f(this.alias, rContactInfo.alias) && bzo.f(this.conRemark, rContactInfo.conRemark) && bzo.f(this.domainList, rContactInfo.domainList) && bzo.f(this.nickname, rContactInfo.nickname) && bzo.f(this.pyInitial, rContactInfo.pyInitial) && bzo.f(this.quanPin, rContactInfo.quanPin) && bzo.f(this.weiboNickname, rContactInfo.weiboNickname) && bzo.f(this.conRemarkPYFull, rContactInfo.conRemarkPYFull) && bzo.f(this.conRemarkPYShort, rContactInfo.conRemarkPYShort) && Arrays.equals(this.lvbuff, rContactInfo.lvbuff) && bzo.f(this.encryptUsername, rContactInfo.encryptUsername) && bzo.f(this.contactLabelIds, rContactInfo.contactLabelIds) && bzo.f(this.descWordingId, rContactInfo.descWordingId) && bzo.f(this.openImAppid, rContactInfo.openImAppid) && bzo.f(this.sourceExtInfo, rContactInfo.sourceExtInfo) && bzo.f(this.ticket, rContactInfo.ticket) && Arrays.equals(this.contactExtra, rContactInfo.contactExtra);
    }

    public final String getAlias() {
        return this.alias;
    }

    public final int getChatroomFlag() {
        return this.chatroomFlag;
    }

    public final String getConRemark() {
        return this.conRemark;
    }

    public final String getConRemarkPYFull() {
        return this.conRemarkPYFull;
    }

    public final String getConRemarkPYShort() {
        return this.conRemarkPYShort;
    }

    public final byte[] getContactExtra() {
        return this.contactExtra;
    }

    public final String getContactLabelIds() {
        return this.contactLabelIds;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getDeleteFlag() {
        return this.deleteFlag;
    }

    public final String getDescWordingId() {
        return this.descWordingId;
    }

    public final String getDomainList() {
        return this.domainList;
    }

    public final String getEncryptUsername() {
        return this.encryptUsername;
    }

    public final byte[] getLvbuff() {
        return this.lvbuff;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getOpenImAppid() {
        return this.openImAppid;
    }

    public final String getPyInitial() {
        return this.pyInitial;
    }

    public final String getQuanPin() {
        return this.quanPin;
    }

    public final int getShowHead() {
        return this.showHead;
    }

    public final String getSourceExtInfo() {
        return this.sourceExtInfo;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final int getType() {
        return this.type;
    }

    public final long getUiType() {
        return this.uiType;
    }

    public final String getUsername() {
        return this.username;
    }

    public final long getUsernameFlag() {
        return this.usernameFlag;
    }

    public final int getVerifyFlag() {
        return this.verifyFlag;
    }

    public final int getWeiboFlag() {
        return this.weiboFlag;
    }

    public final String getWeiboNickname() {
        return this.weiboNickname;
    }

    public int hashCode() {
        return Arrays.hashCode(this.contactExtra) + bjs.e(this.ticket, bjs.e(this.sourceExtInfo, bjs.e(this.openImAppid, bjs.e(this.descWordingId, bjs.e(this.contactLabelIds, bjs.e(this.encryptUsername, (Arrays.hashCode(this.lvbuff) + bjs.e(this.conRemarkPYShort, bjs.e(this.conRemarkPYFull, bjs.e(this.weiboNickname, bjs.e(this.quanPin, bjs.e(this.pyInitial, bjs.e(this.nickname, bjs.e(this.domainList, bjs.e(this.conRemark, bjs.e(this.alias, bjs.e(this.username, (Long.hashCode(this.createTime) + ((Long.hashCode(this.usernameFlag) + ((((((((((Long.hashCode(this.uiType) + (((this.showHead * 31) + this.type) * 31)) * 31) + this.weiboFlag) * 31) + this.verifyFlag) * 31) + this.chatroomFlag) * 31) + this.deleteFlag) * 31)) * 31)) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31)) * 31, 31), 31), 31), 31), 31), 31);
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChatroomFlag(int i) {
        this.chatroomFlag = i;
    }

    public final void setConRemark(String str) {
        this.conRemark = str;
    }

    public final void setConRemarkPYFull(String str) {
        this.conRemarkPYFull = str;
    }

    public final void setConRemarkPYShort(String str) {
        this.conRemarkPYShort = str;
    }

    public final void setContactExtra(byte[] bArr) {
        this.contactExtra = bArr;
    }

    public final void setContactLabelIds(String str) {
        this.contactLabelIds = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setDeleteFlag(int i) {
        this.deleteFlag = i;
    }

    public final void setDescWordingId(String str) {
        this.descWordingId = str;
    }

    public final void setDomainList(String str) {
        this.domainList = str;
    }

    public final void setEncryptUsername(String str) {
        this.encryptUsername = str;
    }

    public final void setLvbuff(byte[] bArr) {
        this.lvbuff = bArr;
    }

    public final void setNickname(String str) {
        this.nickname = str;
    }

    public final void setOpenImAppid(String str) {
        this.openImAppid = str;
    }

    public final void setPyInitial(String str) {
        this.pyInitial = str;
    }

    public final void setQuanPin(String str) {
        this.quanPin = str;
    }

    public final void setShowHead(int i) {
        this.showHead = i;
    }

    public final void setSourceExtInfo(String str) {
        this.sourceExtInfo = str;
    }

    public final void setTicket(String str) {
        this.ticket = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUiType(long j) {
        this.uiType = j;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void setUsernameFlag(long j) {
        this.usernameFlag = j;
    }

    public final void setVerifyFlag(int i) {
        this.verifyFlag = i;
    }

    public final void setWeiboFlag(int i) {
        this.weiboFlag = i;
    }

    public final void setWeiboNickname(String str) {
        this.weiboNickname = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-16638703303466L));
        yg.u(sb, this.username, -16591458663210L);
        yg.u(sb, this.alias, -16501264349994L);
        yg.u(sb, this.conRemark, -17029545327402L);
        yg.u(sb, this.domainList, -16952235916074L);
        yg.u(sb, this.nickname, -16935056046890L);
        yg.u(sb, this.pyInitial, -16862041602858L);
        yg.u(sb, this.quanPin, -16831976831786L);
        dkz.ac(sb, this.showHead, -13997298416426L);
        dkz.ac(sb, this.type, -13962938678058L);
        sb.append(this.uiType);
        sb.append(cnb.z(-13937168874282L));
        dkz.ac(sb, this.weiboFlag, -13864154430250L);
        yg.u(sb, this.weiboNickname, -13791139986218L);
        yg.u(sb, this.conRemarkPYFull, -14293651159850L);
        yg.u(sb, this.conRemarkPYShort, -14173392075562L);
        sb.append(Arrays.toString(this.lvbuff));
        sb.append(cnb.z(-14147622271786L));
        dkz.ac(sb, this.verifyFlag, -14070312860458L);
        yg.u(sb, this.encryptUsername, -13456132537130L);
        dkz.ac(sb, this.chatroomFlag, -13387413060394L);
        dkz.ac(sb, this.deleteFlag, -13310103649066L);
        yg.u(sb, this.contactLabelIds, -13262859008810L);
        yg.u(sb, this.descWordingId, -13739600378666L);
        yg.u(sb, this.openImAppid, -13675175869226L);
        yg.u(sb, this.sourceExtInfo, -13602161425194L);
        yg.u(sb, this.ticket, -13507672144682L);
        sb.append(this.usernameFlag);
        sb.append(cnb.z(-15088220109610L));
        sb.append(Arrays.toString(this.contactExtra));
        sb.append(cnb.z(-15019500632874L));
        sb.append(this.createTime);
        sb.append(')');
        return sb.toString();
    }
}
