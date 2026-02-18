package me.hd.wauxv.obf;

import android.app.Application;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class kh extends nh {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh(ki kiVar, String str) {
        super(3);
        this.a = str;
    }

    @Override // me.hd.wauxv.obf.nh
    public final void c(blq blqVar) {
        Object objX;
        try {
            Object[] objArrI = blqVar.i();
            objX = null;
            Object obj = objArrI != null ? objArrI[0] : null;
            Application application = obj instanceof Application ? (Application) obj : null;
            if (application != null) {
                ki.f = application;
                Iterator it = ki.d.entrySet().iterator();
                if (it.hasNext()) {
                    if (((Map.Entry) it.next()).getValue() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
                try {
                    if (ki.c) {
                        return;
                    }
                    boolean zEquals = ki.i().equals("android");
                    String str = this.a;
                    if (zEquals && !str.equals("android")) {
                        return;
                    }
                    exf exfVar = exf.f;
                    if (exfVar == null) {
                        exfVar = new exf();
                        exf.f = exfVar;
                    }
                    exfVar.n(application, str);
                    ki.c = true;
                } catch (Throwable th) {
                    bhu.x(th);
                }
                objX = application;
            }
        } catch (Throwable th2) {
            objX = bhu.x(th2);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            blqVar.k(thB);
        }
    }
}
