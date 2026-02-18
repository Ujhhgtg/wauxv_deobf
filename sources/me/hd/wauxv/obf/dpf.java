package me.hd.wauxv.obf;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dpf extends doo implements boc {
    public static final dpf a = new dpf(cnb.z(-516173464599338L));
    public static final Set b;
    public static final Set c;
    public static final String i;
    public static final String j;
    public static final String m;
    public static final dos n;

    static {
        String[] strArr = {cnb.z(-539542381656874L), cnb.z(-539512316885802L), cnb.z(-539482252114730L), cnb.z(-539409237670698L), cnb.z(-539336223226666L), cnb.z(-539855914269482L)};
        LinkedHashSet linkedHashSet = new LinkedHashSet(bzo.ah(6));
        for (int i2 = 0; i2 < 6; i2++) {
            linkedHashSet.add(strArr[i2]);
        }
        b = linkedHashSet;
        String[] strArr2 = {cnb.z(-539731360217898L)};
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(bzo.ah(1));
        linkedHashSet2.add(strArr2[0]);
        c = linkedHashSet2;
        i = cnb.z(-539692705512234L);
        j = cnb.z(-539714180348714L);
        m = cnb.z(-539671230675754L);
        n = new dos(2);
    }

    @Override // me.hd.wauxv.obf.boc
    public final void _cc(bmm bmmVar, Intent intent) {
        String stringExtra;
        String shortClassName;
        ActivityOptions activityOptionsMakeBasic;
        if (!z() || (stringExtra = intent.getStringExtra(cnb.z(-516070385384234L))) == null || dnj.ak(stringExtra)) {
            return;
        }
        if (dnr.bp(stringExtra, cnb.z(-516040320613162L), false) || dnr.bp(stringExtra, cnb.z(-516005960874794L), false)) {
            String strAx = dnj.ax(dnj.au(stringExtra, cnb.z(-516113335057194L), stringExtra), cnb.z(-516061795449642L));
            int iK = dpd.a.k();
            if (iK == doz.a.d) {
                Set setN = dpe.a.n();
                if (!setN.isEmpty()) {
                    Iterator it = setN.iterator();
                    while (it.hasNext()) {
                        if (dnr.bi(strAx, (String) it.next())) {
                            return;
                        }
                    }
                }
            } else if (iK == doz.b.d) {
                Set setN2 = dpc.a.n();
                if (setN2.isEmpty()) {
                    return;
                }
                Iterator it2 = setN2.iterator();
                while (it2.hasNext()) {
                    if (dnr.bi(strAx, (String) it2.next())) {
                    }
                }
                return;
            }
            ComponentName component = intent.getComponent();
            if (component == null || (shortClassName = component.getShortClassName()) == null || !dnj.ab(shortClassName, cnb.z(-515967306169130L), false)) {
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            if (!intent2.hasExtra("android.support.customtabs.extra.SESSION")) {
                Bundle bundle = new Bundle();
                bundle.putBinder("android.support.customtabs.extra.SESSION", null);
                intent2.putExtras(bundle);
            }
            intent2.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
            intent2.putExtras(new Bundle());
            intent2.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
            int i2 = Build.VERSION.SDK_INT;
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            String languageTag = adjustedDefault.size() > 0 ? adjustedDefault.get(0).toLanguageTag() : null;
            if (!TextUtils.isEmpty(languageTag)) {
                Bundle bundleExtra = intent2.hasExtra("com.android.browser.headers") ? intent2.getBundleExtra("com.android.browser.headers") : new Bundle();
                if (!bundleExtra.containsKey("Accept-Language")) {
                    bundleExtra.putString("Accept-Language", languageTag);
                    intent2.putExtra("com.android.browser.headers", bundleExtra);
                }
            }
            if (i2 >= 34) {
                activityOptionsMakeBasic = ActivityOptions.makeBasic();
                ba.i(activityOptionsMakeBasic);
            } else {
                activityOptionsMakeBasic = null;
            }
            if (i2 >= 36) {
                if (activityOptionsMakeBasic == null) {
                    activityOptionsMakeBasic = ActivityOptions.makeBasic();
                }
                bb.e(activityOptionsMakeBasic, true ^ intent2.getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
            }
            Bundle bundle2 = activityOptionsMakeBasic != null ? activityOptionsMakeBasic.toBundle() : null;
            intent2.addFlags(268435456);
            bmo.a.getClass();
            Context contextN = bmo.n();
            intent2.setData(Uri.parse(stringExtra));
            contextN.startActivity(intent2, bundle2);
            bmmVar.h(null);
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return j;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return m;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return n;
    }
}
