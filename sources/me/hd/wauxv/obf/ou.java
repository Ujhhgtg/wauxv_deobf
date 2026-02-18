package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ou implements dcj {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object e;

    public /* synthetic */ ou(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.e = obj2;
    }

    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        boolean z;
        cyp cypVar;
        axb axbVar;
        switch (this.a) {
            case 0:
                dcg dcgVarC = ((dcj) this.b).c(obj, i, i2, crwVar);
                Resources resources = (Resources) this.e;
                if (dcgVarC == null) {
                    return null;
                }
                return new pa(resources, dcgVarC);
            case 1:
                dcg dcgVarE = ((dcl) this.b).e((Uri) obj, crwVar);
                if (dcgVarE == null) {
                    return null;
                }
                return cnh.o((oz) this.e, (Drawable) ((bhb) dcgVarE).get(), i, i2);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof cyp) {
                    cypVar = (cyp) inputStream;
                    z = false;
                } else {
                    z = true;
                    cypVar = new cyp(inputStream, (bva) this.e);
                }
                ArrayDeque arrayDeque = axb.a;
                synchronized (arrayDeque) {
                    axbVar = (axb) arrayDeque.poll();
                    break;
                }
                if (axbVar == null) {
                    axbVar = new axb();
                }
                axb axbVar2 = axbVar;
                axbVar2.b = cypVar;
                bzp bzpVar = new bzp(axbVar2);
                but butVar = new but(cypVar, 14, axbVar2);
                try {
                    apq apqVar = (apq) this.b;
                    pa paVarO = apqVar.o(new jx(bzpVar, apqVar.j, apqVar.i), i, i2, crwVar, butVar);
                    axbVar2.c = null;
                    axbVar2.b = null;
                    synchronized (arrayDeque) {
                        arrayDeque.offer(axbVar2);
                        break;
                    }
                    return paVarO;
                } finally {
                    axbVar2.c = null;
                    axbVar2.b = null;
                    ArrayDeque arrayDeque2 = axb.a;
                    synchronized (arrayDeque2) {
                        arrayDeque2.offer(axbVar2);
                        if (z) {
                            cypVar.i();
                        }
                    }
                }
        }
    }

    @Override // me.hd.wauxv.obf.dcj
    public final boolean d(Object obj, crw crwVar) {
        switch (this.a) {
            case 0:
                return ((dcj) this.b).d(obj, crwVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                return true;
        }
    }

    public ou(Resources resources, dcj dcjVar) {
        this.a = 0;
        this.e = resources;
        this.b = dcjVar;
    }
}
