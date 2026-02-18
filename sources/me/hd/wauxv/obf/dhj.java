package me.hd.wauxv.obf;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dhj extends doo implements bnd {
    public static final dhj b;
    public static final String c;
    public static final String h;
    public static final String i;

    static {
        cnb.z(-583320983305002L);
        b = new dhj(cnb.z(-595295352126250L));
        c = cnb.z(-583729005198122L);
        h = cnb.z(-583733300165418L);
        i = cnb.z(-583703235394346L);
    }

    @Override // me.hd.wauxv.obf.bnd
    public final List a(Activity activity) throws IllegalAccessException, InvocationTargetException {
        if (z()) {
            String stringExtra = activity.getIntent().getStringExtra(cnb.z(-595243812518698L));
            if (stringExtra == null) {
                stringExtra = cnb.z(-595170798074666L);
            }
            if (!dnr.bp(stringExtra, cnb.z(-595175093041962L), false)) {
                String strZ = cnb.z(-595123553434410L);
                String strZ2 = cnb.z(-583436947421994L);
                String strConcat = cnb.z(-583346753108778L).concat(stringExtra);
                Object objC = zf.c(cvh.a.b(), new Object[]{activity});
                emn.bb(cvd.a).invoke(objC, strZ2);
                emn.bb(cvf.a).invoke(objC, strConcat);
                return dqc.bf(new aep(strZ, objC, 1, new bka(stringExtra, 4, activity)));
            }
        }
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return h;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }
}
