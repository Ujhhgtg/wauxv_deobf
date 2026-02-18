package me.hd.wauxv.obf;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbr {
    public String a;
    public String b;
    public List c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bbr)) {
            return false;
        }
        bbr bbrVar = (bbr) obj;
        return Objects.equals(this.a, bbrVar.a) && Objects.equals(this.b, bbrVar.b) && Objects.equals(this.c, bbrVar.c);
    }

    public final int hashCode() {
        return Objects.hash(this.a, this.b, this.c);
    }
}
