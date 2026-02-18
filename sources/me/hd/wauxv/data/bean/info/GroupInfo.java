package me.hd.wauxv.data.bean.info;

import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class GroupInfo {
    private GroupData groupData;
    private String name;
    private String remark;
    private String roomId;

    public GroupInfo(String str, String str2, String str3, GroupData groupData) {
        this.roomId = str;
        this.remark = str2;
        this.name = str3;
        this.groupData = groupData;
    }

    public static /* synthetic */ GroupInfo copy$default(GroupInfo groupInfo, String str, String str2, String str3, GroupData groupData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupInfo.roomId;
        }
        if ((i & 2) != 0) {
            str2 = groupInfo.remark;
        }
        if ((i & 4) != 0) {
            str3 = groupInfo.name;
        }
        if ((i & 8) != 0) {
            groupData = groupInfo.groupData;
        }
        return groupInfo.copy(str, str2, str3, groupData);
    }

    public final String component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.remark;
    }

    public final String component3() {
        return this.name;
    }

    public final GroupData component4() {
        return this.groupData;
    }

    public final GroupInfo copy(String str, String str2, String str3, GroupData groupData) {
        return new GroupInfo(str, str2, str3, groupData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupInfo)) {
            return false;
        }
        GroupInfo groupInfo = (GroupInfo) obj;
        return bzo.f(this.roomId, groupInfo.roomId) && bzo.f(this.remark, groupInfo.remark) && bzo.f(this.name, groupInfo.name) && bzo.f(this.groupData, groupInfo.groupData);
    }

    public final GroupData getGroupData() {
        return this.groupData;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRemark() {
        return this.remark;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return this.groupData.hashCode() + bjs.e(this.name, bjs.e(this.remark, this.roomId.hashCode() * 31, 31), 31);
    }

    public final void setGroupData(GroupData groupData) {
        this.groupData = groupData;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRemark(String str) {
        this.remark = str;
    }

    public final void setRoomId(String str) {
        this.roomId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-2856153250602L));
        yg.u(sb, this.roomId, -2796023708458L);
        yg.u(sb, this.remark, -2770253904682L);
        yg.u(sb, this.name, -3285649980202L);
        sb.append(this.groupData);
        sb.append(')');
        return sb.toString();
    }
}
