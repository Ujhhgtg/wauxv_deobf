package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ContextThemeWrapper;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aqu {
    public static final int[] a = {R.attr.dynamicColorThemeOverlay};
    public static final Map b;
    public static final Map c;

    static {
        aqr aqrVar = new aqr();
        aqs aqsVar = new aqs();
        HashMap map = new HashMap();
        map.put("fcnt", aqrVar);
        map.put("google", aqrVar);
        map.put("hmd global", aqrVar);
        map.put("infinix", aqrVar);
        map.put("infinix mobility limited", aqrVar);
        map.put("itel", aqrVar);
        map.put("kyocera", aqrVar);
        map.put("lenovo", aqrVar);
        map.put("lge", aqrVar);
        map.put("meizu", aqrVar);
        map.put("motorola", aqrVar);
        map.put("nothing", aqrVar);
        map.put("oneplus", aqrVar);
        map.put("oppo", aqrVar);
        map.put("realme", aqrVar);
        map.put("robolectric", aqrVar);
        map.put("samsung", aqsVar);
        map.put("sharp", aqrVar);
        map.put("shift", aqrVar);
        map.put("sony", aqrVar);
        map.put("tcl", aqrVar);
        map.put("tecno", aqrVar);
        map.put("tecno mobile limited", aqrVar);
        map.put("vivo", aqrVar);
        map.put("wingtech", aqrVar);
        map.put("xiaomi", aqrVar);
        b = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", aqrVar);
        map2.put("jio", aqrVar);
        c = Collections.unmodifiableMap(map2);
    }

    public static boolean d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            int i2 = rn.a;
            if (i >= 33) {
                return true;
            }
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                bzo.p(str, "CODENAME");
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    bzo.p(upperCase, "toUpperCase(...)");
                    Integer num = upperCase.equals("BAKLAVA") ? num : null;
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    bzo.p(upperCase2, "toUpperCase(...)");
                    num = upperCase2.equals("BAKLAVA") ? 0 : null;
                    if (num == null || num == null) {
                        if (num == null && num == null) {
                            String upperCase3 = str.toUpperCase(locale);
                            bzo.p(upperCase3, "toUpperCase(...)");
                            String upperCase4 = "Tiramisu".toUpperCase(locale);
                            bzo.p(upperCase4, "toUpperCase(...)");
                            if (upperCase3.compareTo(upperCase4) >= 0) {
                                return true;
                            }
                        } else if (num != null) {
                            return true;
                        }
                    } else if (num.intValue() >= num.intValue()) {
                        return true;
                    }
                }
            }
            String str2 = Build.MANUFACTURER;
            Locale locale2 = Locale.ROOT;
            aqt aqtVar = (aqt) b.get(str2.toLowerCase(locale2));
            if (aqtVar == null) {
                aqtVar = (aqt) c.get(Build.BRAND.toLowerCase(locale2));
            }
            if (aqtVar != null && aqtVar.isSupported()) {
                return true;
            }
        }
        return false;
    }

    public static Context e(cec cecVar) {
        if (d()) {
            TypedArray typedArrayObtainStyledAttributes = cecVar.obtainStyledAttributes(a);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            if (resourceId != 0) {
                return new ContextThemeWrapper(cecVar, resourceId);
            }
        }
        return cecVar;
    }
}
