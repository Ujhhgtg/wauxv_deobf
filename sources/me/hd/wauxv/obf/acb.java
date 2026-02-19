package me.hd.wauxv.obf;

import android.util.Log;
import android.window.OnBackInvokedDispatcher;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class acb implements bul {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ acb(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
        switch (this.a) {
            case 0:
                cqt cqtVar = (cqt) this.b;
                hb hbVar = (hb) this.c;
                if (lifeEventEnumVar == LifeEventEnum.ON_CREATE) {
                    OnBackInvokedDispatcher onBackInvokedDispatcherB = acc.a.b(hbVar);
                    throwIfVar1IsNull(onBackInvokedDispatcherB, "invoker");
                    cqtVar.e = onBackInvokedDispatcherB;
                    cqtVar.j(cqtVar.g);
                }
                break;
            default:
                beq beqVar = (beq) this.b;
                cio cioVar = (cio) this.c;
                if (lifeEventEnumVar == LifeEventEnum.ON_RESUME && ((List) ((dml) beqVar.w().e.obj).c()).contains(cioVar)) {
                    if (beq.p()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + cioVar
                                + " due to fragment " + bupVar + " view lifecycle reaching RESUMED");
                    }
                    beqVar.w().k(cioVar);
                }
                if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                    if (beq.p()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + cioVar
                                + " due to fragment " + bupVar + " view lifecycle reaching DESTROYED");
                    }
                    beqVar.w().k(cioVar);
                }
                break;
        }
    }
}
