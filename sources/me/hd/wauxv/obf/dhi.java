package me.hd.wauxv.obf;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhi extends BaseHook implements bnd {
    public static final dhi b;
    public static final String c;
    public static final String h;
    public static final String i;

    static {
        "WAuxiliary_chatting_record_pref" /* cnb.z(-595037654088490L) */;
        b = new dhi("ShowChattingRecordHook" /* cnb.z(-595608884738858L) */);
        c = "界面" /* cnb.z(-594900215135018L) */;
        h = "历史发言记录" /* cnb.z(-594852970494762L) */;
        i = "在群聊的好友详情中显示历史发言记录" /* cnb.z(-595355481668394L) */;
    }

    @Override // me.hd.wauxv.obf.bnd
    public final List a(Activity activity) throws IllegalAccessException, InvocationTargetException {
        if (getIsEnabled()) {
            String stringExtra = activity.getIntent()
                    .getStringExtra("Contact_ChatRoomId" /* cnb.z(-595492920621866L) */);
            String stringExtra2 = activity.getIntent().getStringExtra("Contact_User" /* cnb.z(-595445675981610L) */);
            if (stringExtra2 == null) {
                stringExtra2 = "" /* cnb.z(-595905237482282L) */;
            }
            int intExtra = activity.getIntent().getIntExtra("Contact_Scene" /* cnb.z(-595918122384170L) */, -1);
            if (stringExtra != null && stringExtra.length() != 0 && stringExtra2.length() > 0 && intExtra == 14) {
                String strZ = "WAuxiliary_chatting_record_pref" /* cnb.z(-595840812972842L) */;
                String strZ2 = "WAuxiliary_chatting_record_pref" /* cnb.z(-595703374019370L) */;
                String strZ3 = "历史发言记录" /* cnb.z(-595016179252010L) */;
                Object objC = zf.c(cvh.a.b(), new Object[] { activity });
                emn.bb(cvd.a).invoke(objC, strZ2);
                emn.bb(cvf.a).invoke(objC, strZ3);
                return dqc.bf(new aep(strZ, objC, 2, new ben(activity, stringExtra, stringExtra2, 1)));
            }
        }
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return h;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }
}
