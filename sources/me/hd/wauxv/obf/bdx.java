package me.hd.wauxv.obf;

import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdx {
    public boolean a = false;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public bgr c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public bdx(Object obj, int i) {
        this.d = i;
        this.e = obj;
    }

    public void f() {
        switch (this.d) {
            case 0:
                beg begVar = (beg) this.e;
                if (beg.ar(3)) {
                    Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + begVar);
                }
                if (beg.ar(3)) {
                    Log.d("FragmentManager", "cancelBackStackTransition for transition " + begVar.h);
                }
                mu muVar = begVar.h;
                if (muVar != null) {
                    muVar.s = false;
                    muVar.y();
                    mu muVar2 = begVar.h;
                    dh dhVar = new dh(begVar, 14);
                    if (muVar2.q == null) {
                        muVar2.q = new ArrayList();
                    }
                    muVar2.q.add(dhVar);
                    begVar.h.z();
                    begVar.i = true;
                    begVar.bw(true);
                    begVar.cc();
                    begVar.i = false;
                    begVar.h = null;
                }
                break;
        }
    }

    public final void g() {
    }
}
