package me.hd.wauxv.obf;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bel implements bul {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bel(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
        switch (this.a) {
            case 0:
                beq beqVar = (beq) this.b;
                if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                    SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) bupVar;
                    Object obj = null;
                    for (Object obj2 : (Iterable) ((dml) beqVar.w().f.obj).c()) {
                        if (nullSafeIsEqual(((cio) obj2).f, someFragmentManagerVar.bs)) {
                            obj = obj2;
                        }
                    }
                    cio cioVar = (cio) obj;
                    if (cioVar != null) {
                        if (beq.p()) {
                            Log.v("FragmentNavigator", "Marking transition complete for entry " + cioVar
                                    + " due to fragment " + bupVar + " lifecycle reaching DESTROYED");
                        }
                        beqVar.w().k(cioVar);
                    }
                }
                break;
            case 1:
                cix cixVar = (cix) this.b;
                cixVar.p = lifeEventEnumVar.a();
                if (cixVar.c != null) {
                    for (cio cioVar2 : StaticHelpers5.ab(cixVar.f)) {
                        cioVar2.getClass();
                        ciq ciqVar = cioVar2.h;
                        ciqVar.getClass();
                        ciqVar.a.d = lifeEventEnumVar.a();
                        ciqVar.d = lifeEventEnumVar.a();
                        ciqVar.m();
                    }
                }
                break;
            default:
                deo deoVar = (deo) this.b;
                if (lifeEventEnumVar == LifeEventEnum.ON_START) {
                    deoVar.h = true;
                } else if (lifeEventEnumVar == LifeEventEnum.ON_STOP) {
                    deoVar.h = false;
                }
                break;
        }
    }
}
