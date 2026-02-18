package me.hd.wauxv.obf;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ShowContactInfoHook extends SwitchHook implements bnd {
    public static final ShowContactInfoHook b;
    public static final String c;
    public static final String h;
    public static final String i;

    static {
        // "WAuxiliary_contact_info_pref" /* cnb.z(-583320983305002L) */;
        // b = new ShowContactInfoHook("ShowContactInfoHook" /* cnb.z(-595295352126250L)
        // */);
        c = "界面" /* cnb.z(-583729005198122L) */;
        h = "显示联系详情" /* cnb.z(-583733300165418L) */;
        i = "在对应的联系界面中显示 联系详情ID" /* cnb.z(-583703235394346L) */;
    }

    @Override // me.hd.wauxv.obf.bnd
    public final List a(Activity activity) throws IllegalAccessException, InvocationTargetException {
        if (getIsEnabled()) {
            String stringExtra = activity.getIntent().getStringExtra("Contact_User" /* cnb.z(-595243812518698L) */);
            if (stringExtra == null) {
                stringExtra = "异常" /* cnb.z(-595170798074666L) */;
            }
            if (!dnr.bp(stringExtra, "gh_" /* cnb.z(-595175093041962L) */, false)) {
                String prefKey1 = "WAuxiliary_contact_info_pref" /* cnb.z(-595123553434410L) */;
                String prefKey2 = "WAuxiliary_contact_info_pref" /* cnb.z(-583436947421994L) */;
                String idDisplayStr = "ID: " /* cnb.z(-583346753108778L) */.concat(stringExtra);
                Object objC = ReflectionWrapper.createInstanceWithArgs(cvh.a.b(), new Object[] { activity });
                emn.bb(cvd.a).invoke(objC, prefKey2);
                emn.bb(cvf.a).invoke(objC, idDisplayStr);
                return dqc.bf(new aep(prefKey1, objC, 1, new bka(stringExtra, 4, activity)));
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
