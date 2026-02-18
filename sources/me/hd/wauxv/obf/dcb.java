package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dcb implements Handler.Callback {
    public static final cbm a = new cbm(16);
    public volatile dca b;
    public final bfh c;
    public final but d = new but(a);

    public dcb() {
        this.c = (bkf.b && bkf.a) ? new bar() : new nu(20);
    }

    public static Activity e(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final dca f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = eot.a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof hb) {
                hb hbVar = (hb) context;
                if (!(Looper.myLooper() == Looper.getMainLooper())) {
                    return f(hbVar.getApplicationContext());
                }
                if (hbVar.isDestroyed()) {
                    throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
                }
                this.c.t(hbVar);
                Activity activityE = e(hbVar);
                boolean z = activityE == null || !activityE.isFinishing();
                com.bumptech.glide.a aVarJ = com.bumptech.glide.a.j(hbVar.getApplicationContext());
                but butVar = this.d;
                bur burVar = hbVar.q;
                beg begVar = ((bdm) hbVar.c.v).g;
                butVar.getClass();
                eot.d();
                eot.d();
                dca dcaVar = (dca) ((HashMap) butVar.b).get(burVar);
                if (dcaVar != null) {
                    return dcaVar;
                }
                bum bumVar = new bum(burVar);
                cbm cbmVar = (cbm) butVar.c;
                awp awpVar = new awp(butVar, begVar);
                cbmVar.getClass();
                dca dcaVar2 = new dca(aVarJ, bumVar, awpVar, hbVar);
                ((HashMap) butVar.b).put(burVar, dcaVar2);
                bumVar.al(new bus(butVar, burVar));
                if (z) {
                    dcaVar2.getAllSwitchHookInstances();
                }
                return dcaVar2;
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return f(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = new dca(com.bumptech.glide.a.j(context.getApplicationContext()), new arj(), new nu(27),
                                context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.b;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
