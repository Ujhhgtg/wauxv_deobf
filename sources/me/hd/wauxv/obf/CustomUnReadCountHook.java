package me.hd.wauxv.obf;

import android.content.ContentValues;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CustomUnReadCountHook extends SwitchHook implements IDatabaseOperationsListener {
    public static final CustomUnReadCountHook a = new CustomUnReadCountHook("CustomUnReadCountHook" /*
                                                                                                     * cnb.z(-
                                                                                                     * 491305603955498L)
                                                                                                     */);
    public static final String b = "实验" /* "实验" /* "实验" /* cnb.z(-490450905463594L)  */;
    public static final String c = "自定义未读数" /* "自定义未读数" /* "自定义未读数" /* cnb.z(-490386480954154L)  */;
    public static final String d = "可自定义消息菜单 '标记未读' 的未读数" /* "可自定义消息菜单 '标记未读' 的未读数" /* "可自定义消息菜单 '标记未读' 的未读数" /* cnb.z(-490906171996970L)  */;
    public static final age h = new age(26);

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

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void j(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr, int i) {
        if (getIsEnabled() && str.equals("rconversation" /* "rconversation" /* "rconversation" /* cnb.z(-490644178991914L)  */)
                && nullSafeIsEqual(contentValues.get("unReadCount" /* "unReadCount" /* "unReadCount" /* cnb.z(-490566869580586L)  */), 1)
                && nullSafeIsEqual(contentValues.get("atCount" /* "atCount" /* "atCount" /* cnb.z(-490549689711402L)  */), 0)) {
            contentValues.put("unReadCount" /* "unReadCount" /* "unReadCount" /* cnb.z(-490515329973034L)  */, Integer.valueOf(ait.a.k()));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return h;
    }
}
