package me.hd.wauxv.data.bean.db;

import java.util.Arrays;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.jar.asm.Opcodes;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ChatRoomInfo {
    private final Long addtime;
    private final String associateOpenIMRoomName;
    private final long chatroomLocalVersion;
    private final int chatroomNoticeNew;
    private final int chatroomStatus;
    private final int chatroomVersion;
    private final int chatroomdataflag;
    private final long chatroomfamilystatusmodifytime;
    private final String chatroomname;
    private final String chatroomnick;
    private final String chatroomnotice;
    private final String chatroomnoticeEditor;
    private final long chatroomnoticePublishTime;
    private final long compactFlag;
    private final String displayname;
    private final String handleByteVersion;
    private final int isShowname;
    private final byte[] localChatRoomWatchMembers;
    private final int memberCount;
    private final String memberlist;
    private final Long modifytime;
    private final int oldChatroomVersion;
    private final int openIMRoomMigrateStatus;
    private final byte[] roomInfoDetailResByte;
    private final byte[] roomdata;
    private final int roomflag;
    private final String roomowner;
    private final String saveByteVersion;
    private final String selfDisplayName;
    private final int spamStatus;
    private final int style;
    private final String xmlChatroomnotice;

    public ChatRoomInfo(String str, Long l, Long l2, long j, long j2, String str2, String str3, String str4,
            String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12,
            byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8,
            int i9, long j3, int i10, int i11, long j4) {
        this.chatroomname = str;
        this.addtime = l;
        this.modifytime = l2;
        this.chatroomnoticePublishTime = j;
        this.chatroomfamilystatusmodifytime = j2;
        this.memberlist = str2;
        this.displayname = str3;
        this.chatroomnick = str4;
        this.roomowner = str5;
        this.selfDisplayName = str6;
        this.chatroomnotice = str7;
        this.xmlChatroomnotice = str8;
        this.chatroomnoticeEditor = str9;
        this.associateOpenIMRoomName = str10;
        this.saveByteVersion = str11;
        this.handleByteVersion = str12;
        this.roomdata = bArr;
        this.roomInfoDetailResByte = bArr2;
        this.localChatRoomWatchMembers = bArr3;
        this.roomflag = i;
        this.isShowname = i2;
        this.style = i3;
        this.chatroomdataflag = i4;
        this.chatroomStatus = i5;
        this.openIMRoomMigrateStatus = i6;
        this.spamStatus = i7;
        this.chatroomVersion = i8;
        this.chatroomNoticeNew = i9;
        this.chatroomLocalVersion = j3;
        this.memberCount = i10;
        this.oldChatroomVersion = i11;
        this.compactFlag = j4;
    }

    public static /* synthetic */ ChatRoomInfo copy$default(ChatRoomInfo chatRoomInfo, String str, Long l, Long l2,
            long j, long j2, String str2, String str3, String str4, String str5, String str6, String str7, String str8,
            String str9, String str10, String str11, String str12, byte[] bArr, byte[] bArr2, byte[] bArr3, int i,
            int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, int i10, int i11, long j4, int i12,
            Object obj) {
        long j5;
        int i13;
        int i14;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        long j6;
        long j7;
        long j8;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        Long l3;
        Long l4;
        String str23 = (i12 & 1) != 0 ? chatRoomInfo.chatroomname : str;
        Long l5 = (i12 & 2) != 0 ? chatRoomInfo.addtime : l;
        Long l6 = (i12 & 4) != 0 ? chatRoomInfo.modifytime : l2;
        long j9 = (i12 & 8) != 0 ? chatRoomInfo.chatroomnoticePublishTime : j;
        long j10 = (i12 & 16) != 0 ? chatRoomInfo.chatroomfamilystatusmodifytime : j2;
        String str24 = (i12 & 32) != 0 ? chatRoomInfo.memberlist : str2;
        String str25 = (i12 & 64) != 0 ? chatRoomInfo.displayname : str3;
        String str26 = (i12 & 128) != 0 ? chatRoomInfo.chatroomnick : str4;
        String str27 = (i12 & 256) != 0 ? chatRoomInfo.roomowner : str5;
        String str28 = (i12 & 512) != 0 ? chatRoomInfo.selfDisplayName : str6;
        String str29 = (i12 & 1024) != 0 ? chatRoomInfo.chatroomnotice : str7;
        String str30 = (i12 & 2048) != 0 ? chatRoomInfo.xmlChatroomnotice : str8;
        String str31 = str23;
        String str32 = (i12 & 4096) != 0 ? chatRoomInfo.chatroomnoticeEditor : str9;
        String str33 = (i12 & 8192) != 0 ? chatRoomInfo.associateOpenIMRoomName : str10;
        String str34 = (i12 & 16384) != 0 ? chatRoomInfo.saveByteVersion : str11;
        String str35 = (i12 & 32768) != 0 ? chatRoomInfo.handleByteVersion : str12;
        byte[] bArr7 = (i12 & 65536) != 0 ? chatRoomInfo.roomdata : bArr;
        byte[] bArr8 = (i12 & 131072) != 0 ? chatRoomInfo.roomInfoDetailResByte : bArr2;
        byte[] bArr9 = (i12 & 262144) != 0 ? chatRoomInfo.localChatRoomWatchMembers : bArr3;
        int i24 = (i12 & Opcodes.ASM8) != 0 ? chatRoomInfo.roomflag : i;
        int i25 = (i12 & 1048576) != 0 ? chatRoomInfo.isShowname : i2;
        int i26 = (i12 & 2097152) != 0 ? chatRoomInfo.style : i3;
        int i27 = (i12 & 4194304) != 0 ? chatRoomInfo.chatroomdataflag : i4;
        int i28 = (i12 & 8388608) != 0 ? chatRoomInfo.chatroomStatus : i5;
        int i29 = (i12 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? chatRoomInfo.openIMRoomMigrateStatus : i6;
        int i30 = (i12 & 33554432) != 0 ? chatRoomInfo.spamStatus : i7;
        int i31 = (i12 & 67108864) != 0 ? chatRoomInfo.chatroomVersion : i8;
        int i32 = (i12 & 134217728) != 0 ? chatRoomInfo.chatroomNoticeNew : i9;
        String str36 = str34;
        long j11 = (i12 & 268435456) != 0 ? chatRoomInfo.chatroomLocalVersion : j3;
        int i33 = (i12 & 536870912) != 0 ? chatRoomInfo.memberCount : i10;
        int i34 = (i12 & 1073741824) != 0 ? chatRoomInfo.oldChatroomVersion : i11;
        if ((i12 & Integer.MIN_VALUE) != 0) {
            i13 = i33;
            i14 = i34;
            j5 = chatRoomInfo.compactFlag;
            bArr6 = bArr9;
            i15 = i24;
            i16 = i25;
            i17 = i26;
            i18 = i27;
            i19 = i28;
            i20 = i29;
            i21 = i30;
            i22 = i31;
            i23 = i32;
            j6 = j11;
            j8 = j10;
            str13 = str24;
            str14 = str25;
            str15 = str26;
            str16 = str27;
            str17 = str28;
            str18 = str29;
            str19 = str30;
            str20 = str33;
            str21 = str35;
            bArr4 = bArr7;
            bArr5 = bArr8;
            str22 = str36;
            l3 = l5;
            l4 = l6;
            j7 = j9;
        } else {
            j5 = j4;
            i13 = i33;
            i14 = i34;
            bArr4 = bArr7;
            bArr5 = bArr8;
            bArr6 = bArr9;
            i15 = i24;
            i16 = i25;
            i17 = i26;
            i18 = i27;
            i19 = i28;
            i20 = i29;
            i21 = i30;
            i22 = i31;
            i23 = i32;
            j6 = j11;
            j7 = j9;
            j8 = j10;
            str13 = str24;
            str14 = str25;
            str15 = str26;
            str16 = str27;
            str17 = str28;
            str18 = str29;
            str19 = str30;
            str20 = str33;
            str21 = str35;
            str22 = str36;
            l3 = l5;
            l4 = l6;
        }
        return chatRoomInfo.copy(str31, l3, l4, j7, j8, str13, str14, str15, str16, str17, str18, str19, str32, str20,
                str22, str21, bArr4, bArr5, bArr6, i15, i16, i17, i18, i19, i20, i21, i22, i23, j6, i13, i14, j5);
    }

    public final String component1() {
        return this.chatroomname;
    }

    public final String component10() {
        return this.selfDisplayName;
    }

    public final String component11() {
        return this.chatroomnotice;
    }

    public final String component12() {
        return this.xmlChatroomnotice;
    }

    public final String component13() {
        return this.chatroomnoticeEditor;
    }

    public final String component14() {
        return this.associateOpenIMRoomName;
    }

    public final String component15() {
        return this.saveByteVersion;
    }

    public final String component16() {
        return this.handleByteVersion;
    }

    public final byte[] component17() {
        return this.roomdata;
    }

    public final byte[] component18() {
        return this.roomInfoDetailResByte;
    }

    public final byte[] component19() {
        return this.localChatRoomWatchMembers;
    }

    public final Long component2() {
        return this.addtime;
    }

    public final int component20() {
        return this.roomflag;
    }

    public final int component21() {
        return this.isShowname;
    }

    public final int component22() {
        return this.style;
    }

    public final int component23() {
        return this.chatroomdataflag;
    }

    public final int component24() {
        return this.chatroomStatus;
    }

    public final int component25() {
        return this.openIMRoomMigrateStatus;
    }

    public final int component26() {
        return this.spamStatus;
    }

    public final int component27() {
        return this.chatroomVersion;
    }

    public final int component28() {
        return this.chatroomNoticeNew;
    }

    public final long component29() {
        return this.chatroomLocalVersion;
    }

    public final Long component3() {
        return this.modifytime;
    }

    public final int component30() {
        return this.memberCount;
    }

    public final int component31() {
        return this.oldChatroomVersion;
    }

    public final long component32() {
        return this.compactFlag;
    }

    public final long component4() {
        return this.chatroomnoticePublishTime;
    }

    public final long component5() {
        return this.chatroomfamilystatusmodifytime;
    }

    public final String component6() {
        return this.memberlist;
    }

    public final String component7() {
        return this.displayname;
    }

    public final String component8() {
        return this.chatroomnick;
    }

    public final String component9() {
        return this.roomowner;
    }

    public final ChatRoomInfo copy(String str, Long l, Long l2, long j, long j2, String str2, String str3, String str4,
            String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12,
            byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8,
            int i9, long j3, int i10, int i11, long j4) {
        return new ChatRoomInfo(str, l, l2, j, j2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12,
                bArr, bArr2, bArr3, i, i2, i3, i4, i5, i6, i7, i8, i9, j3, i10, i11, j4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!ChatRoomInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        throwIfVar1IsNull(obj, "null cannot be cast to non-null type me.hd.wauxv.data.bean.db.ChatRoomInfo" /*
                                                                                                             * cnb.z(-
                                                                                                             * 8942121909034L)
                                                                                                             */);
        ChatRoomInfo chatRoomInfo = (ChatRoomInfo) obj;
        if (!nullSafeIsEqual(this.addtime, chatRoomInfo.addtime)
                || !nullSafeIsEqual(this.modifytime, chatRoomInfo.modifytime)
                || this.chatroomnoticePublishTime != chatRoomInfo.chatroomnoticePublishTime
                || this.chatroomfamilystatusmodifytime != chatRoomInfo.chatroomfamilystatusmodifytime
                || this.roomflag != chatRoomInfo.roomflag || this.isShowname != chatRoomInfo.isShowname
                || this.style != chatRoomInfo.style || this.chatroomdataflag != chatRoomInfo.chatroomdataflag
                || this.chatroomStatus != chatRoomInfo.chatroomStatus
                || this.openIMRoomMigrateStatus != chatRoomInfo.openIMRoomMigrateStatus
                || this.spamStatus != chatRoomInfo.spamStatus || this.chatroomVersion != chatRoomInfo.chatroomVersion
                || this.chatroomNoticeNew != chatRoomInfo.chatroomNoticeNew
                || this.chatroomLocalVersion != chatRoomInfo.chatroomLocalVersion
                || this.memberCount != chatRoomInfo.memberCount
                || this.oldChatroomVersion != chatRoomInfo.oldChatroomVersion
                || this.compactFlag != chatRoomInfo.compactFlag
                || !nullSafeIsEqual(this.chatroomname, chatRoomInfo.chatroomname)
                || !nullSafeIsEqual(this.memberlist, chatRoomInfo.memberlist)
                || !nullSafeIsEqual(this.displayname, chatRoomInfo.displayname)
                || !nullSafeIsEqual(this.chatroomnick, chatRoomInfo.chatroomnick)
                || !nullSafeIsEqual(this.roomowner, chatRoomInfo.roomowner)
                || !nullSafeIsEqual(this.selfDisplayName, chatRoomInfo.selfDisplayName)
                || !nullSafeIsEqual(this.chatroomnotice, chatRoomInfo.chatroomnotice)
                || !nullSafeIsEqual(this.xmlChatroomnotice, chatRoomInfo.xmlChatroomnotice)
                || !nullSafeIsEqual(this.chatroomnoticeEditor, chatRoomInfo.chatroomnoticeEditor)
                || !nullSafeIsEqual(this.associateOpenIMRoomName, chatRoomInfo.associateOpenIMRoomName)
                || !nullSafeIsEqual(this.saveByteVersion, chatRoomInfo.saveByteVersion)
                || !nullSafeIsEqual(this.handleByteVersion, chatRoomInfo.handleByteVersion)) {
            return false;
        }
        byte[] bArr = this.roomdata;
        if (bArr != null) {
            byte[] bArr2 = chatRoomInfo.roomdata;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (chatRoomInfo.roomdata != null) {
            return false;
        }
        byte[] bArr3 = this.roomInfoDetailResByte;
        if (bArr3 != null) {
            byte[] bArr4 = chatRoomInfo.roomInfoDetailResByte;
            if (bArr4 == null || !Arrays.equals(bArr3, bArr4)) {
                return false;
            }
        } else if (chatRoomInfo.roomInfoDetailResByte != null) {
            return false;
        }
        byte[] bArr5 = this.localChatRoomWatchMembers;
        if (bArr5 != null) {
            byte[] bArr6 = chatRoomInfo.localChatRoomWatchMembers;
            if (bArr6 == null || !Arrays.equals(bArr5, bArr6)) {
                return false;
            }
        } else if (chatRoomInfo.localChatRoomWatchMembers != null) {
            return false;
        }
        return true;
    }

    public final Long getAddtime() {
        return this.addtime;
    }

    public final String getAssociateOpenIMRoomName() {
        return this.associateOpenIMRoomName;
    }

    public final long getChatroomLocalVersion() {
        return this.chatroomLocalVersion;
    }

    public final int getChatroomNoticeNew() {
        return this.chatroomNoticeNew;
    }

    public final int getChatroomStatus() {
        return this.chatroomStatus;
    }

    public final int getChatroomVersion() {
        return this.chatroomVersion;
    }

    public final int getChatroomdataflag() {
        return this.chatroomdataflag;
    }

    public final long getChatroomfamilystatusmodifytime() {
        return this.chatroomfamilystatusmodifytime;
    }

    public final String getChatroomname() {
        return this.chatroomname;
    }

    public final String getChatroomnick() {
        return this.chatroomnick;
    }

    public final String getChatroomnotice() {
        return this.chatroomnotice;
    }

    public final String getChatroomnoticeEditor() {
        return this.chatroomnoticeEditor;
    }

    public final long getChatroomnoticePublishTime() {
        return this.chatroomnoticePublishTime;
    }

    public final long getCompactFlag() {
        return this.compactFlag;
    }

    public final String getDisplayname() {
        return this.displayname;
    }

    public final String getHandleByteVersion() {
        return this.handleByteVersion;
    }

    public final byte[] getLocalChatRoomWatchMembers() {
        return this.localChatRoomWatchMembers;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final String getMemberlist() {
        return this.memberlist;
    }

    public final Long getModifytime() {
        return this.modifytime;
    }

    public final int getOldChatroomVersion() {
        return this.oldChatroomVersion;
    }

    public final int getOpenIMRoomMigrateStatus() {
        return this.openIMRoomMigrateStatus;
    }

    public final byte[] getRoomInfoDetailResByte() {
        return this.roomInfoDetailResByte;
    }

    public final byte[] getRoomdata() {
        return this.roomdata;
    }

    public final int getRoomflag() {
        return this.roomflag;
    }

    public final String getRoomowner() {
        return this.roomowner;
    }

    public final String getSaveByteVersion() {
        return this.saveByteVersion;
    }

    public final String getSelfDisplayName() {
        return this.selfDisplayName;
    }

    public final int getSpamStatus() {
        return this.spamStatus;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getXmlChatroomnotice() {
        return this.xmlChatroomnotice;
    }

    public int hashCode() {
        Long l = this.addtime;
        int iHashCode = (l != null ? Long.hashCode(l.longValue()) : 0) * 31;
        Long l2 = this.modifytime;
        int iE = bjs.e(this.chatroomname, (Long.hashCode(this.compactFlag) + ((((((Long.hashCode(
                this.chatroomLocalVersion)
                + ((((((((((((((((((((Long.hashCode(this.chatroomfamilystatusmodifytime)
                        + ((Long.hashCode(this.chatroomnoticePublishTime)
                                + ((iHashCode + (l2 != null ? Long.hashCode(l2.longValue()) : 0)) * 31)) * 31))
                        * 31) + this.roomflag) * 31) + this.isShowname) * 31) + this.style) * 31)
                        + this.chatroomdataflag) * 31) + this.chatroomStatus) * 31) + this.openIMRoomMigrateStatus)
                        * 31) + this.spamStatus) * 31) + this.chatroomVersion) * 31) + this.chatroomNoticeNew) * 31))
                * 31) + this.memberCount) * 31) + this.oldChatroomVersion) * 31)) * 31, 31);
        String str = this.memberlist;
        int iHashCode2 = (iE + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.displayname;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.chatroomnick;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.roomowner;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.selfDisplayName;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.chatroomnotice;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.xmlChatroomnotice;
        int iHashCode8 = (iHashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.chatroomnoticeEditor;
        int iHashCode9 = (iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.associateOpenIMRoomName;
        int iHashCode10 = (iHashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.saveByteVersion;
        int iHashCode11 = (iHashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.handleByteVersion;
        int iHashCode12 = (iHashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        byte[] bArr = this.roomdata;
        int iHashCode13 = (iHashCode12 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
        byte[] bArr2 = this.roomInfoDetailResByte;
        int iHashCode14 = (iHashCode13 + (bArr2 != null ? Arrays.hashCode(bArr2) : 0)) * 31;
        byte[] bArr3 = this.localChatRoomWatchMembers;
        return iHashCode14 + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
    }

    public final int isShowname() {
        return this.isShowname;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChatRoomInfo(chatroomname=" /* "ChatRoomInfo(chatroomname=" /* "ChatRoomInfo(chatroomname=" /* cnb.z(-9186935044906L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.chatroomname, -9105330666282L);
        StaticHelpers6.ad(sb, this.addtime, -10655813860138L);
        StaticHelpers6.ad(sb, this.modifytime, -10647223925546L);
        sb.append(this.chatroomnoticePublishTime);
        sb.append(", chatroomfamilystatusmodifytime=" /* ", chatroomfamilystatusmodifytime=" /* ", chatroomfamilystatusmodifytime=" /* cnb.z(-10505490004778L)  */);
        sb.append(this.chatroomfamilystatusmodifytime);
        sb.append(", memberlist=" /* ", memberlist=" /* ", memberlist=" /* cnb.z(-10926396799786L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.memberlist, -10849087388458L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.displayname, -10767483009834L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.chatroomnick, -10149007719210L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.roomowner, -10075993275178L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.selfDisplayName, -10011568765738L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.chatroomnotice, -9951439223594L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.xmlChatroomnotice, -10393820855082L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.chatroomnoticeEditor, -10290741639978L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.associateOpenIMRoomName, -10191957392170L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.saveByteVersion, -16123307227946L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.handleByteVersion, -16067472653098L);
        sb.append(Arrays.toString(this.roomdata));
        sb.append(", roomInfoDetailResByte=" /* ", roomInfoDetailResByte=" /* ", roomInfoDetailResByte=" /* cnb.z(-15981573307178L)  */);
        sb.append(Arrays.toString(this.roomInfoDetailResByte));
        sb.append(", localChatRoomWatchMembers=" /* ", localChatRoomWatchMembers=" /* ", localChatRoomWatchMembers=" /* cnb.z(-16441134807850L)  */);
        sb.append(Arrays.toString(this.localChatRoomWatchMembers));
        sb.append(", roomflag=" /* ", roomflag=" /* ", roomflag=" /* cnb.z(-16350940494634L)  */);
        StaticHelpers6.ac(sb, this.roomflag, -16265041148714L);
        StaticHelpers6.ac(sb, this.isShowname, -15637975923498L);
        StaticHelpers6.ac(sb, this.style, -15616501087018L);
        StaticHelpers6.ac(sb, this.chatroomdataflag, -15564961479466L);
        StaticHelpers6.ac(sb, this.chatroomStatus, -15436112460586L);
        StaticHelpers6.ac(sb, this.openIMRoomMigrateStatus, -15887084026666L);
        StaticHelpers6.ac(sb, this.spamStatus, -15809774615338L);
        StaticHelpers6.ac(sb, this.chatroomVersion, -15762529975082L);
        StaticHelpers6.ac(sb, this.chatroomNoticeNew, -17287243365162L);
        sb.append(this.chatroomLocalVersion);
        sb.append(", memberCount=" /* ", memberCount=" /* ", memberCount=" /* cnb.z(-17184164150058L)  */);
        StaticHelpers6.ac(sb, this.memberCount, -17119739640618L);
        StaticHelpers6.ac(sb, this.oldChatroomVersion, -17076789967658L);
        sb.append(this.compactFlag);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ChatRoomInfo(String str, Long l, Long l2, long j, long j2, String str2, String str3,
            String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11,
            String str12, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, int i4, int i5, int i6,
            int i7, int i8, int i9, long j3, int i10, int i11, long j4, int i12, akd akdVar) {
        this(str, l, l2, (i12 & 8) != 0 ? 0L : j, (i12 & 16) != 0 ? 0L : j2, str2, str3, str4, str5, str6, str7, str8,
                str9, str10, str11, str12, bArr, bArr2, bArr3, (i12 & Opcodes.ASM8) != 0 ? 0 : i,
                (i12 & 1048576) != 0 ? 0 : i2, (i12 & 2097152) != 0 ? 0 : i3, (i12 & 4194304) != 0 ? 0 : i4,
                (i12 & 8388608) != 0 ? 0 : i5, (i12 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? 0 : i6,
                (i12 & 33554432) != 0 ? 0 : i7, (i12 & 67108864) != 0 ? 0 : i8, (i12 & 134217728) != 0 ? 0 : i9,
                (i12 & 268435456) != 0 ? 0L : j3, (i12 & 536870912) != 0 ? -1 : i10, (i12 & 1073741824) != 0 ? 0 : i11,
                (i12 & Integer.MIN_VALUE) != 0 ? 0L : j4);
    }
}
