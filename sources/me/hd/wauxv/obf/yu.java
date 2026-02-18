package me.hd.wauxv.obf;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yu extends nd {
    public final int e;
    public final String f;
    public final Integer g;
    public final ArrayList h;
    public final dov i;
    public final dov j;
    public final dov k;

    public yu(DexKitBridge dexKitBridge, int i, int i2, int i3, String str, Integer num, ArrayList arrayList,
            ArrayList arrayList2, ArrayList arrayList3) {
        super(dexKitBridge, i, i2);
        this.e = i3;
        this.f = str;
        this.g = num;
        this.h = arrayList;
        this.i = new dov(new bp(this, 11));
        this.j = new dov(new yr(this, dexKitBridge, i2));
        this.k = new dov(new yr(dexKitBridge, this, i2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof yu) {
            return nullSafeIsEqual(this.f, ((yu) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.e;
        if (i > 0) {
            sb.append(Modifier.toString(i) + " ");
        }
        sb.append("class " + ((aml) this.i.getValue()).a);
        yu yuVar = (yu) this.j.getValue();
        if (yuVar != null) {
            sb.append(" extends ");
            sb.append(((aml) yuVar.i.getValue()).a);
        }
        if (this.h.size() > 0) {
            sb.append(" implements ");
            sb.append(aaz.k((yw) this.k.getValue(), ", ", null, null, new ws(22), 30));
        }
        return sb.toString();
    }
}
