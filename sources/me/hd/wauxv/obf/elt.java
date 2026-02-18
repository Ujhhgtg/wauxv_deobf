package me.hd.wauxv.obf;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class elt {
    public final View b;
    public final HashMap a = new HashMap();
    public final ArrayList c = new ArrayList();

    public elt(View view) {
        this.b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof elt)) {
            return false;
        }
        elt eltVar = (elt) obj;
        return this.b == eltVar.b && this.a.equals(eltVar.a);
    }

    public final int hashCode() {
        return this.a.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sbR = bjs.r("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbR.append(this.b);
        sbR.append("\n");
        String strS = dkz.s(sbR.toString(), "    values:");
        HashMap map = this.a;
        for (String str : map.keySet()) {
            strS = strS + "    " + str + ": " + map.get(str) + "\n";
        }
        return strS;
    }
}
