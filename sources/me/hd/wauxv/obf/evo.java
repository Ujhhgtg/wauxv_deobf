package me.hd.wauxv.obf;

import android.os.Build;
import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class evo {
    public static final evr ao;
    public final evr ap;

    static {
        int i = Build.VERSION.SDK_INT;
        ao = (i >= 34 ? new evf() : i >= 31 ? new eve() : i >= 30 ? new evd() : i >= 29 ? new evc() : new evb()).g().b.ae().b.z().b.aa();
    }

    public evo(evr evrVar) {
        this.ap = evrVar;
    }

    public evr aa() {
        return this.ap;
    }

    public bps ab() {
        return bps.a;
    }

    public boolean ac() {
        return false;
    }

    public void ad(bps bpsVar) {
    }

    public evr ae() {
        return this.ap;
    }

    public aow af() {
        return null;
    }

    public bps aj() {
        return o();
    }

    public bps ak() {
        return o();
    }

    public bps al() {
        return o();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof evo)) {
            return false;
        }
        evo evoVar = (evo) obj;
        return q() == evoVar.q() && ac() == evoVar.ac() && Objects.equals(o(), evoVar.o()) && Objects.equals(ab(), evoVar.ab()) && Objects.equals(af(), evoVar.af());
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(q()), Boolean.valueOf(ac()), o(), ab(), af());
    }

    public void m(View view) {
    }

    public bps n(int i) {
        return bps.a;
    }

    public bps o() {
        return bps.a;
    }

    public evr p(int i, int i2, int i3, int i4) {
        return ao;
    }

    public boolean q() {
        return false;
    }

    public boolean r(int i) {
        return true;
    }

    public void s(bps[] bpsVarArr) {
    }

    public void t(evr evrVar) {
    }

    public void u(int i) {
    }

    public evr z() {
        return this.ap;
    }
}
