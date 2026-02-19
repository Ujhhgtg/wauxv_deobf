package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ckl {
    public cit u;
    public boolean v;

    public abstract cjg c();

    public cjg d(cjg cjgVar, Bundle bundle, cjo cjoVar) {
        return cjgVar;
    }

    public boolean e() {
        return true;
    }

    public void i(List list, cjo cjoVar) {
        baa baaVar = new baa(new bae(new dpu(StaticHelpers5.a(list), new bka(this, 3, cjoVar), 1), false, new dbj(21)));
        while (baaVar.hasNext()) {
            w().o((cio) baaVar.next());
        }
    }

    public void j(cit citVar) {
        this.u = citVar;
        this.v = true;
    }

    public void k(cio cioVar) {
        cjg cjgVar = cioVar.b;
        if (cjgVar == null) {
            cjgVar = null;
        }
        if (cjgVar == null) {
            return;
        }
        cjp cjpVar = new cjp();
        cjpVar.b = true;
        boolean z = cjpVar.b;
        boolean z2 = cjpVar.c;
        int i = cjpVar.d;
        boolean z3 = cjpVar.e;
        cjn cjnVar = cjpVar.a;
        d(cjgVar, null, new cjo(z, z2, i, false, z3, cjnVar.a, cjnVar.b, -1, -1));
        w().l(cioVar);
    }

    public void l(cio cioVar, boolean z) {
        List list = (List) ((dml) w().e.obj).c();
        if (!list.contains(cioVar)) {
            throw new IllegalStateException(
                    ("popBackStack was called with " + cioVar + " which does not exist in back stack " + list)
                            .toString());
        }
        ListIterator listIterator = list.listIterator(list.size());
        cio cioVar2 = null;
        while (e()) {
            cioVar2 = (cio) listIterator.previous();
            if (nullSafeIsEqual(cioVar2, cioVar)) {
                break;
            }
        }
        if (cioVar2 != null) {
            w().m(cioVar2, z);
        }
    }

    public void q(Bundle bundle) {
    }

    public Bundle r() {
        return null;
    }

    public final cit w() {
        cit citVar = this.u;
        if (citVar != null) {
            return citVar;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }
}
