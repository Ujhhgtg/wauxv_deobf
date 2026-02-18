package me.hd.wauxv.obf;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ern extends dop {
    public static ern m;
    public static final dop n = new dop(19);
    public final Application o;

    public ern(Application application) {
        super(21);
        this.o = application;
    }

    @Override // me.hd.wauxv.obf.dop, me.hd.wauxv.obf.ero
    public final erk b(Class cls) {
        Application application = this.o;
        if (application != null) {
            return p(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // me.hd.wauxv.obf.dop, me.hd.wauxv.obf.ero
    public final erk l(Class cls, chq chqVar) {
        if (this.o != null) {
            return b(cls);
        }
        Application application = (Application) chqVar.c.get(n);
        if (application != null) {
            return p(cls, application);
        }
        if (ev.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        }
        return cnh.q(cls);
    }

    public final erk p(Class cls, Application application) {
        if (!ev.class.isAssignableFrom(cls)) {
            return cnh.q(cls);
        }
        try {
            erk erkVar = (erk) cls.getConstructor(Application.class).newInstance(application);
            bzo.n(erkVar);
            return erkVar;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e4);
        }
    }
}
