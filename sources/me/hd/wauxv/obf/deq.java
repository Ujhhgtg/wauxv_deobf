package me.hd.wauxv.obf;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class deq implements ero {
    public final Application c;
    public final ern d;
    public final Bundle e;
    public final bur f;
    public final but g;

    public deq() {
        this.d = new ern(null);
    }

    @Override // me.hd.wauxv.obf.ero
    public final erk _bh(zc zcVar, chq chqVar) {
        return l(HugeSyntheticPileOfHelpers.getJavaClass(zcVar), chqVar);
    }

    @Override // me.hd.wauxv.obf.ero
    public final erk b(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return h(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final erk h(Class cls, String str) {
        AutoCloseable autoCloseable;
        Application application;
        bur burVar = this.f;
        if (burVar == null) {
            throw new UnsupportedOperationException(
                    "SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = ev.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || this.c == null) ? der.c(cls, der.b) : der.c(cls, der.a);
        if (constructorC == null) {
            if (this.c != null) {
                return this.d.b(cls);
            }
            if (dop.f == null) {
                dop.f = new dop(21);
            }
            throwIfVar1IsNull(dop.f);
            return cnh.q(cls);
        }
        but butVar = this.g;
        throwIfVar1IsNull(butVar);
        deh dehVarM = bmy.m(butVar.g(str), this.e);
        dei deiVar = new dei(str, dehVarM);
        deiVar.d(butVar, burVar);
        buh buhVar = burVar.c;
        if (buhVar == buh.b || buhVar.compareTo(buh.d) >= 0) {
            butVar.ag();
        } else {
            burVar.j(new akz(burVar, 3, butVar));
        }
        erk erkVarD = (!zIsAssignableFrom || (application = this.c) == null) ? der.d(cls, constructorC, dehVarM)
                : der.d(cls, constructorC, application, dehVarM);
        erkVarD.getClass();
        erl erlVar = erkVarD.m;
        if (erlVar == null) {
            return erkVarD;
        }
        if (erlVar.d) {
            erl.e(deiVar);
            return erkVarD;
        }
        synchronized (erlVar.a) {
            autoCloseable = (AutoCloseable) erlVar.b.put("androidx.lifecycle.savedstate.vm.tag", deiVar);
        }
        erl.e(autoCloseable);
        return erkVarD;
    }

    @Override // me.hd.wauxv.obf.ero
    public final erk l(Class cls, chq chqVar) {
        LinkedHashMap linkedHashMap = chqVar.c;
        String str = (String) linkedHashMap.get(erp.s);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(aye.d) == null || linkedHashMap.get(aye.e) == null) {
            if (this.f != null) {
                return h(cls, str);
            }
            throw new IllegalStateException(
                    "SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(ern.n);
        boolean zIsAssignableFrom = ev.class.isAssignableFrom(cls);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? der.c(cls, der.b) : der.c(cls, der.a);
        return constructorC == null ? this.d.l(cls, chqVar)
                : (!zIsAssignableFrom || application == null) ? der.d(cls, constructorC, aye.q(chqVar))
                        : der.d(cls, constructorC, application, aye.q(chqVar));
    }

    public deq(Application application, dep depVar, Bundle bundle) {
        ern ernVar;
        this.g = depVar.ak();
        this.f = depVar.ap();
        this.e = bundle;
        this.c = application;
        if (application != null) {
            if (ern.m == null) {
                ern.m = new ern(application);
            }
            ernVar = ern.m;
            throwIfVar1IsNull(ernVar);
        } else {
            ernVar = new ern(null);
        }
        this.d = ernVar;
    }
}
