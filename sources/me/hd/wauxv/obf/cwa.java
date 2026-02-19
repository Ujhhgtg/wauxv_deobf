package me.hd.wauxv.obf;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwa {
    public final String a;

    public cwa(String str) {
        this.a = str;
    }

    public final Object b(aji ajiVar) {
        Object obj = ajiVar.b.get(this);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(this.a);
    }

    public final void c(aji ajiVar, Object obj) {
        HashMap map = ajiVar.b;
        if (obj == null) {
            map.remove(this);
        } else {
            map.put(this, obj);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || cwa.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((cwa) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return yg.concatToVar1(new StringBuilder("Prop{name='"), this.a, "'}");
    }
}
