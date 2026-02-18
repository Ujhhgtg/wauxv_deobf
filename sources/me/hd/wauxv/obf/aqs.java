package me.hd.wauxv.obf;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqs implements aqt {
    public Long a;

    @Override // me.hd.wauxv.obf.aqt
    public final boolean isSupported() {
        if (this.a == null) {
            try {
                Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                declaredMethod.setAccessible(true);
                Long l = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                l.longValue();
                this.a = l;
            } catch (Exception unused) {
                this.a = -1L;
            }
        }
        return this.a.longValue() >= 40100;
    }
}
