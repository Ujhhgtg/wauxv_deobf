package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.Arrays;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class gz implements den {
    public final /* synthetic */ int a;
    public final Object b;

    public gz(but butVar) {
        this.a = 1;
        this.b = new LinkedHashSet();
        butVar.ad("androidx.savedstate.Restarter", this);
    }

    @Override // me.hd.wauxv.obf.den
    public final Bundle c() {
        switch (this.a) {
            case 0:
                Bundle bundle = new Bundle();
                ((dg) this.b).j().getClass();
                return bundle;
            default:
                Bundle bundleR = bht.r((csm[]) Arrays.copyOf(new csm[0], 0));
                cnb.ai(bundleR, "classes_to_restore", aaz.z((LinkedHashSet) this.b));
                return bundleR;
        }
    }

    public gz(dg dgVar) {
        this.a = 0;
        this.b = dgVar;
    }
}
