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
public final class dpf extends SwitchHook implements IStartActivity {
    public static final dpf a = new dpf("SystemBrowserHook" /* "SystemBrowserHook" /* "SystemBrowserHook" /* "SystemBrowserHook" /* cnb.z(-516173464599338L)   */);
    public static final Set b;
    public static final Set c;
    public static final String i;
    public static final String j;
    public static final String m;
    public static final dos n;

    static {
        String[] strArr = { "weixin.com" /* "weixin.com" /* "weixin.com" /* "weixin.com" /* cnb.z(-539542381656874L)   */, "qq.com" /* "qq.com" /* "qq.com" /* "qq.com" /* cnb.z(-539512316885802L)   */,
                "weixin.qq.com.cn" /* "weixin.qq.com.cn" /* "weixin.qq.com.cn" /* "weixin.qq.com.cn" /* cnb.z(-539482252114730L)   */, "wechatpay.cn" /* "wechatpay.cn" /* "wechatpay.cn" /* "wechatpay.cn" /* cnb.z(-539409237670698L)   */,
                "tenpay.com" /* "tenpay.com" /* "tenpay.com" /* "tenpay.com" /* cnb.z(-539336223226666L)   */, "weixinbridge.com" /* "weixinbridge.com" /* "weixinbridge.com" /* "weixinbridge.com" /* cnb.z(-539855914269482L)   */ };
        LinkedHashSet linkedHashSet = new LinkedHashSet(KotlinHelpers.calcHashMapCapacity(6));
        for (int i2 = 0; i2 < 6; i2++) {
            linkedHashSet.add(strArr[i2]);
        }
        b = linkedHashSet;
        String[] strArr2 = { "test.com" /* "test.com" /* "test.com" /* "test.com" /* cnb.z(-539731360217898L)   */ };
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(KotlinHelpers.calcHashMapCapacity(1));
        linkedHashSet2.add(strArr2[0]);
        c = linkedHashSet2;
        i = "杂项" /* "杂项" /* "杂项" /* "杂项" /* cnb.z(-539692705512234L)   */;
        j = "系统浏览器" /* "系统浏览器" /* "系统浏览器" /* "系统浏览器" /* cnb.z(-539714180348714L)   */;
        m = "致敬经典模块 '去你大爷的内置浏览器' " /* "致敬经典模块 '去你大爷的内置浏览器' " /* "致敬经典模块 '去你大爷的内置浏览器' " /* "致敬经典模块 '去你大爷的内置浏览器' " /* cnb.z(-539671230675754L)   */;
        n = new dos(2);
    }

    @Override // me.hd.wauxv.obf.IStartActivity
    public final void onStartActivityIntent(HookParam hookParam, Intent intent) {
        String stringExtra;
        String shortClassName;
        ActivityOptions activityOptionsMakeBasic;
        if (!z() || (stringExtra = intent.getStringExtra("rawUrl" /* "rawUrl" /* "rawUrl" /* "rawUrl" /* cnb.z(-516070385384234L)   */)) == null
                || dnj.ak(stringExtra)) {
            return;
        }
        if (dnr.bp(stringExtra, "http://" /* "http://" /* "http://" /* "http://" /* cnb.z(-516040320613162L)   */, false)
                || dnr.bp(stringExtra, "https://" /* "https://" /* "https://" /* "https://" /* cnb.z(-516005960874794L)   */, false)) {
            String strAx = dnj.ax(dnj.au(stringExtra, "://" /* "://" /* "://" /* "://" /* cnb.z(-516113335057194L)   */, stringExtra), "/" /*
                                                                                                               * cnb.z(-
                                                                                                               * 516061795449642L)
                                                                                                               */);
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
            if (component == null || (shortClassName = component.getShortClassName()) == null
                    || !dnj.ab(shortClassName, "MMWebViewUI" /* "MMWebViewUI" /* "MMWebViewUI" /* "MMWebViewUI" /* cnb.z(-515967306169130L)   */, false)) {
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
                Bundle bundleExtra = intent2.hasExtra("com.android.browser.headers")
                        ? intent2.getBundleExtra("com.android.browser.headers")
                        : new Bundle();
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
                bb.e(activityOptionsMakeBasic, true ^ intent2
                        .getBooleanExtra("androidx.browser.customtabs.extra.DISABLE_BACKGROUND_INTERACTION", false));
            }
            Bundle bundle2 = activityOptionsMakeBasic != null ? activityOptionsMakeBasic.toBundle() : null;
            intent2.addFlags(268435456);
            bmo.a.getClass();
            Context contextN = bmo.n();
            intent2.setData(Uri.parse(stringExtra));
            contextN.startActivity(intent2, bundle2);
            hookParam.setResult(null);
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return m;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return n;
    }
}
