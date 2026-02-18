package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dek implements den {
    public final but a;
    public boolean b;
    public Bundle d;
    public final dov e;

    public dek(but butVar, err errVar) {
        bzo.q(butVar, "savedStateRegistry");
        this.a = butVar;
        this.e = new dov(new cfx(errVar, 11));
    }

    @Override // me.hd.wauxv.obf.den
    public final Bundle c() {
        Bundle bundleR = bht.r((csm[]) Arrays.copyOf(new csm[0], 0));
        Bundle bundle = this.d;
        if (bundle != null) {
            bundleR.putAll(bundle);
        }
        for (Map.Entry entry : ((del) this.e.getValue()).a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleC = ((bdv) ((deh) entry.getValue()).a.e).c();
            if (!bundleC.isEmpty()) {
                cnb.ag(bundleR, str, bundleC);
            }
        }
        this.b = false;
        return bundleR;
    }

    public final void f() {
        if (this.b) {
            return;
        }
        Bundle bundleG = this.a.g("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundleR = bht.r((csm[]) Arrays.copyOf(new csm[0], 0));
        Bundle bundle = this.d;
        if (bundle != null) {
            bundleR.putAll(bundle);
        }
        if (bundleG != null) {
            bundleR.putAll(bundleG);
        }
        this.d = bundleR;
        this.b = true;
    }
}
