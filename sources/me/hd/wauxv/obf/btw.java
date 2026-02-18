package me.hd.wauxv.obf;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class btw implements bkk {
    public final Map c;
    public volatile Map d;

    public btw(Map map) {
        this.c = Collections.unmodifiableMap(map);
    }

    @Override // me.hd.wauxv.obf.bkk
    public final Map b() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = Collections.unmodifiableMap(e());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.d;
    }

    public final HashMap e() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.c.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = ((btv) list.get(i)).a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                map.put((String) entry.getKey(), string);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof btw) {
            return this.c.equals(((btw) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }
}
