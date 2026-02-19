package me.hd.wauxv.obf;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kg extends nh {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ kg(int i) {
        super(3);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.nh
    public final void c(blq blqVar) {
        Object objX;
        Object objX2;
        Object objX3;
        Object obj;
        Object objX4;
        Object obj2;
        Object objX5;
        switch (this.a) {
            case 0:
                try {
                    obj2 = ((bmh) blqVar.b).b.thisObject;
                } catch (Throwable th) {
                    objX4 = bhu.x(th);
                }
                if ((obj2 instanceof Application ? (Application) obj2 : null) == null) {
                    return;
                }
                Object[] objArrI = blqVar.i();
                Object obj3 = objArrI != null ? objArrI[0] : null;
                if ((obj3 instanceof Configuration ? (Configuration) obj3 : null) == null) {
                    return;
                }
                Iterator it = ki.d.entrySet().iterator();
                if (it.hasNext()) {
                    if (((Map.Entry) it.next()).getValue() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
                objX4 = KotlinUnit.INSTANCE;
                Throwable thB = dcy.b(objX4);
                if (thB != null) {
                    blqVar.k(thB);
                    return;
                }
                return;
            case 1:
                try {
                    Iterator it2 = ki.d.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (((Map.Entry) it2.next()).getValue() != null) {
                            throw new ClassCastException();
                        }
                        Object[] objArrI2 = blqVar.i();
                        Object obj4 = objArrI2 != null ? objArrI2[0] : null;
                        if ((obj4 instanceof Context ? (Context) obj4 : null) != null) {
                            throw null;
                        }
                    }
                    objX = KotlinUnit.INSTANCE;
                } catch (Throwable th2) {
                    objX = bhu.x(th2);
                }
                Throwable thB2 = dcy.b(objX);
                if (thB2 != null) {
                    blqVar.k(thB2);
                    return;
                }
                return;
            case 2:
                try {
                    Iterator it3 = ki.d.entrySet().iterator();
                    while (it3.hasNext()) {
                        if (((Map.Entry) it3.next()).getValue() != null) {
                            throw new ClassCastException();
                        }
                        Object obj5 = ((bmh) blqVar.b).b.thisObject;
                        if ((obj5 instanceof Application ? (Application) obj5 : null) != null) {
                            throw null;
                        }
                    }
                    objX2 = KotlinUnit.INSTANCE;
                } catch (Throwable th3) {
                    objX2 = bhu.x(th3);
                }
                Throwable thB3 = dcy.b(objX2);
                if (thB3 != null) {
                    blqVar.k(thB3);
                    return;
                }
                return;
            case 3:
                try {
                    Iterator it4 = ki.d.entrySet().iterator();
                    while (it4.hasNext()) {
                        if (((Map.Entry) it4.next()).getValue() != null) {
                            throw new ClassCastException();
                        }
                        Object obj6 = ((bmh) blqVar.b).b.thisObject;
                        if ((obj6 instanceof Application ? (Application) obj6 : null) != null) {
                            throw null;
                        }
                    }
                    objX5 = KotlinUnit.INSTANCE;
                } catch (Throwable th4) {
                    objX5 = bhu.x(th4);
                }
                Throwable thB4 = dcy.b(objX5);
                if (thB4 != null) {
                    blqVar.k(thB4);
                    return;
                }
                return;
            default:
                try {
                    obj = ((bmh) blqVar.b).b.thisObject;
                } catch (Throwable th5) {
                    objX3 = bhu.x(th5);
                }
                if ((obj instanceof Application ? (Application) obj : null) == null) {
                    return;
                }
                Object[] objArrI3 = blqVar.i();
                Object obj7 = objArrI3 != null ? objArrI3[0] : null;
                if ((obj7 instanceof Integer ? (Integer) obj7 : null) != null) {
                    Iterator it5 = ki.d.entrySet().iterator();
                    if (it5.hasNext()) {
                        if (((Map.Entry) it5.next()).getValue() != null) {
                            throw new ClassCastException();
                        }
                        throw null;
                    }
                    objX3 = KotlinUnit.INSTANCE;
                    Throwable thB5 = dcy.b(objX3);
                    if (thB5 != null) {
                        blqVar.k(thB5);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @Override // me.hd.wauxv.obf.nh
    public void d(blq blqVar) {
        Object objX;
        switch (this.a) {
            case 1:
                try {
                    Iterator it = ki.d.entrySet().iterator();
                    while (it.hasNext()) {
                        if (((Map.Entry) it.next()).getValue() != null) {
                            throw new ClassCastException();
                        }
                        Object[] objArrI = blqVar.i();
                        Object obj = objArrI != null ? objArrI[0] : null;
                        if ((obj instanceof Context ? (Context) obj : null) != null) {
                            throw null;
                        }
                    }
                    objX = KotlinUnit.INSTANCE;
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Throwable thB = dcy.b(objX);
                if (thB != null) {
                    blqVar.k(thB);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
