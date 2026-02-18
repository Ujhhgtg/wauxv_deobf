package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmk {
    public int a = 0;
    public boolean b = false;
    public ArrayList c = null;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dmk.class != obj.getClass()) {
            return false;
        }
        dmk dmkVar = (dmk) obj;
        return this.a == dmkVar.a && this.b == dmkVar.b;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.a), Boolean.valueOf(this.b));
    }
}
