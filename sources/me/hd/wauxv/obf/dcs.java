package me.hd.wauxv.obf;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcs {
    public final Resources a;
    public final Resources.Theme b;

    public dcs(Resources resources, Resources.Theme theme) {
        this.a = resources;
        this.b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && dcs.class == obj.getClass()) {
            dcs dcsVar = (dcs) obj;
            if (this.a.equals(dcsVar.a) && Objects.equals(this.b, dcsVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b);
    }
}
