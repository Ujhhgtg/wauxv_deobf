package me.hd.wauxv.obf;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdf extends nd {
    public final int e;
    public final String f;
    public final Kotlin$Lazy g;

    public cdf(DexKitBridge dexKitBridge, int i, int i2, int i3, int i4, String str, int i5, ArrayList arrayList) {
        super(dexKitBridge, i, i2);
        this.e = i4;
        this.f = str;
        this.g = new Kotlin$Lazy(new bp(this, 27));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cdf) && nullSafeIsEqual(((cdf) obj).f, this.f);
    }

    public final amq h() {
        return (amq) this.g.getValue();
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.e;
        if (i != 0) {
            sb.append(Modifier.toString(i) + " ");
        }
        sb.append(h().d);
        sb.append(" ");
        sb.append(h().a);
        sb.append(".");
        sb.append(h().b);
        sb.append("(");
        return yg.concatToVar1(sb, StaticHelpers5.k(h().c, ", ", null, null, null, 62), ")");
    }
}
