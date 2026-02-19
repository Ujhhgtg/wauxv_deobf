package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bis {
    public static final bis a;
    public static final /* synthetic */ bis[] b;
    public static final /* synthetic */ awn c;
    public final String d;
    public final String e;

    static {
        bis bisVar = new bis("ALL" /* "ALL" /* "ALL" /* "ALL" /* cnb.z(-568765339138858L)   */, 0, "全部" /* "全部" /* "全部" /* "全部" /* cnb.z(-568782519008042L)   */, "" /* "" /* "" /* "" /* cnb.z(-568786813975338L)   */);
        a = bisVar;
        bis bisVar2 = new bis("GROUP" /* "GROUP" /* "GROUP" /* "GROUP" /* cnb.z(-568730979400490L)   */, 1, "群聊" /* "群聊" /* "群聊" /* "群聊" /* cnb.z(-568756749204266L)   */, " where (username like '%@im.chatroom' or username like '%@chatroom' ) order by flag desc" /* " where (username like '%@im.chatroom' or username like '%@chatroom' ) order by flag desc" /* " where (username like '%@im.chatroom' or username like '%@chatroom' ) order by flag desc" /* " where (username like '%@im.chatroom' or username like '%@chatroom' ) order by flag desc" /* cnb.z(-592331824692010L)   */);
        String strZ = "FRIEND" /* "FRIEND" /* "FRIEND" /* "FRIEND" /* cnb.z(-592516508285738L)   */;
        String strZ2 = "好友" /* "好友" /* "好友" /* "好友" /* cnb.z(-592469263645482L)   */;
        StringBuilder sb = new StringBuilder();
        sb.append(" where ((parentRef is null) or (parentRef != 'officialaccounts')) and (username like '%@openim' or username not like '%@%' ) and (username not like 'gh_%') and (username not in " /* " where ((parentRef is null) or (parentRef != 'officialaccounts')) and (username like '%@openim' or username not like '%@%' ) and (username not like 'gh_%') and (username not in " /* " where ((parentRef is null) or (parentRef != 'officialaccounts')) and (username like '%@openim' or username not like '%@%' ) and (username not like 'gh_%') and (username not in " /* " where ((parentRef is null) or (parentRef != 'officialaccounts')) and (username like '%@openim' or username not like '%@%' ) and (username not like 'gh_%') and (username not in " /* cnb.z(-592490738481962L)   */);
        bis[] bisVarArr = {bisVar, bisVar2, new bis(strZ, 2, strZ2, yg.decryptVar3UsingCnbZAndConcatToVar1(sb, biw.b, -593392681614122L)), new bis("OFFICIAL" /* "OFFICIAL" /* "OFFICIAL" /* "OFFICIAL" /* cnb.z(-593268127562538L)   */, 3, "官方" /* "官方" /* "官方" /* "官方" /* cnb.z(-593246652726058L)   */, " where (parentRef = 'officialaccounts') or (username like 'gh_%') order by flag desc" /* " where (parentRef = 'officialaccounts') or (username like 'gh_%') order by flag desc" /* " where (parentRef = 'officialaccounts') or (username like 'gh_%') order by flag desc" /* " where (parentRef = 'officialaccounts') or (username like 'gh_%') order by flag desc" /* cnb.z(-593250947693354L)   */)};
        b = bisVarArr;
        c = new awn(bisVarArr);
    }

    public bis(String str, int i, String str2, String str3) {
        this.d = str2;
        this.e = str3;
    }

    public static bis valueOf(String str) {
        return (bis) Enum.valueOf(bis.class, str);
    }

    public static bis[] values() {
        return (bis[]) b.clone();
    }
}
