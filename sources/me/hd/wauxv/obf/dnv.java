package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnv {
    public io a;
    public ArrayList b;
    public int c;

    public final void d() {
        if (this.b != null) {
            int i = -1;
            int i2 = 0;
            while (i2 < this.b.size() - 1) {
                i2++;
                int i3 = ((aah) this.b.get(i2)).e;
                if (i > i3) {
                    Collections.sort(this.b, aah.a);
                    break;
                }
                i = i3;
            }
            Collections.sort(new ArrayList(this.b), aah.b);
        }
    }
}
