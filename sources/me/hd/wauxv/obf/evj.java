package me.hd.wauxv.obf;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evj extends evi {
    public evj(evr evrVar, WindowInsets windowInsets) {
        super(evrVar, windowInsets);
    }

    @Override // me.hd.wauxv.obf.evo
    public evr ae() {
        return evr.d(null, this.f.consumeDisplayCutout());
    }

    @Override // me.hd.wauxv.obf.evo
    public aow af() {
        DisplayCutout displayCutout = this.f.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new aow(displayCutout);
    }

    @Override // me.hd.wauxv.obf.evh, me.hd.wauxv.obf.evo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof evj)) {
            return false;
        }
        evj evjVar = (evj) obj;
        return Objects.equals(this.f, evjVar.f) && Objects.equals(this.j, evjVar.j) && evh.l(this.k, evjVar.k);
    }

    @Override // me.hd.wauxv.obf.evo
    public int hashCode() {
        return this.f.hashCode();
    }
}
