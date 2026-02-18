package me.hd.wauxv.obf;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class btu {
    public static final Map a;

    static {
        String property = System.getProperty("http.agent");
        if (!TextUtils.isEmpty(property)) {
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            property = sb.toString();
        }
        HashMap map = new HashMap(2);
        if (!TextUtils.isEmpty(property)) {
            map.put("User-Agent", Collections.singletonList(new btv(property)));
        }
        a = Collections.unmodifiableMap(map);
    }
}
