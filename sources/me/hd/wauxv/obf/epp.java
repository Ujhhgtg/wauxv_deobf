package me.hd.wauxv.obf;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class epp {
    public final ku a;
    public final ku b;
    public final ku c;

    public epp(ku kuVar, ku kuVar2, ku kuVar3) {
        this.a = kuVar;
        this.b = kuVar2;
        this.c = kuVar3;
    }

    public abstract epq d();

    public final Class e(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ku kuVar = this.c;
        Class cls2 = (Class) kuVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        kuVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method f(String str) throws NoSuchMethodException {
        ku kuVar = this.a;
        Method method = (Method) kuVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, epp.class.getClassLoader()).getDeclaredMethod("read", epp.class);
        kuVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method g(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ku kuVar = this.b;
        Method method = (Method) kuVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsE = e(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsE.getDeclaredMethod("write", cls, epp.class);
        kuVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean h(int i);

    public final Parcelable i(Parcelable parcelable, int i) {
        if (!h(i)) {
            return parcelable;
        }
        return ((epq) this).n.readParcelable(epq.class.getClassLoader());
    }

    public final epr j() {
        String string = ((epq) this).n.readString();
        if (string == null) {
            return null;
        }
        try {
            return (epr) f(string).invoke(null, d());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public abstract void k(int i);

    public final void l(epr eprVar) {
        if (eprVar == null) {
            ((epq) this).n.writeString(null);
            return;
        }
        try {
            ((epq) this).n.writeString(e(eprVar.getClass()).getName());
            epq epqVarD = d();
            try {
                g(eprVar.getClass()).invoke(null, eprVar, epqVarD);
                Parcel parcel = epqVarD.n;
                int i = epqVarD.r;
                if (i >= 0) {
                    int i2 = epqVarD.m.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(eprVar.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
