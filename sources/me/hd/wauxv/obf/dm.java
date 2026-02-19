package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@ckk("activity")
public class dm extends ckl {
    public final Context a;
    public final Activity b;

    public dm(Context context) {
        this.a = context;
        for (Object obj : dfv.ai(context, new bn(3))) {
            if (((Context) obj) instanceof Activity) {
                this.b = (Activity) obj;
            }
        }
        obj = null;
        this.b = (Activity) obj;
    }

    @Override // me.hd.wauxv.obf.ckl
    public final cjg c() {
        return new dl(this);
    }

    @Override // me.hd.wauxv.obf.ckl
    public final cjg d(cjg cjgVar, Bundle bundle, cjo cjoVar) {
        Intent intent;
        int intExtra;
        dl dlVar = (dl) cjgVar;
        ea eaVar = dlVar.g;
        if (dlVar.a == null) {
            throw new IllegalStateException(
                    yg.concatToVar1(new StringBuilder("Destination "), " does not have an Intent set.", eaVar.a).toString());
        }
        Intent intent2 = new Intent(dlVar.a);
        if (bundle != null) {
            intent2.putExtras(bundle);
            String str = dlVar.b;
            if (str != null && str.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    throwIfVar1IsNull(strGroup);
                    if (!bundle.containsKey(strGroup)) {
                        throw new IllegalArgumentException(
                                ("Could not find " + strGroup + " in " + bundle + " to fill data pattern " + str)
                                        .toString());
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    cin cinVar = (cin) dlVar.n().get(strGroup);
                    cjv cjvVar = cinVar != null ? cinVar.a : null;
                    stringBuffer.append(cjvVar != null ? cjvVar.b(cjvVar.f(strGroup, bundle))
                            : Uri.encode(String.valueOf(bundle.get(strGroup))));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        Activity activity = this.b;
        if (activity == null) {
            intent2.addFlags(268435456);
        }
        if (cjoVar != null && cjoVar.a) {
            intent2.addFlags(536870912);
        }
        if (activity != null && (intent = activity.getIntent()) != null
                && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", eaVar.a);
        Context context = this.a;
        Resources resources = context.getResources();
        if (cjoVar != null) {
            int i = cjoVar.h;
            int i2 = cjoVar.i;
            if ((i <= 0 || !nullSafeIsEqual(resources.getResourceTypeName(i), "animator"))
                    && (i2 <= 0 || !nullSafeIsEqual(resources.getResourceTypeName(i2), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", i);
                throwIfVar1IsNull(intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", i2));
            } else {
                Log.w("ActivityNavigator",
                        "Activity destinations do not support Animator resource. Ignoring popEnter resource "
                                + resources.getResourceName(i) + " and popExit resource "
                                + resources.getResourceName(i2) + " when launching " + dlVar);
            }
        }
        context.startActivity(intent2);
        if (cjoVar != null && activity != null) {
            int i3 = cjoVar.f;
            int i4 = cjoVar.g;
            if ((i3 > 0 && nullSafeIsEqual(resources.getResourceTypeName(i3), "animator"))
                    || (i4 > 0 && nullSafeIsEqual(resources.getResourceTypeName(i4), "animator"))) {
                Log.w("ActivityNavigator",
                        "Activity destinations do not support Animator resource. Ignoring enter resource "
                                + resources.getResourceName(i3) + " and exit resource " + resources.getResourceName(i4)
                                + "when launching " + dlVar);
                return null;
            }
            if (i3 >= 0 || i4 >= 0) {
                if (i3 < 0) {
                    i3 = 0;
                }
                activity.overridePendingTransition(i3, i4 >= 0 ? i4 : 0);
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ckl
    public final boolean e() {
        Activity activity = this.b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
