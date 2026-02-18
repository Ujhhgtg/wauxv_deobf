package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhh {
    public final dmg a;
    public final Handler b;
    public final ArrayList c;
    public final dca d;
    public final oz e;
    public boolean f;
    public boolean g;
    public dbu h;
    public bhe i;
    public boolean j;
    public bhe k;
    public Bitmap l;
    public bhe m;
    public int n;
    public int o;
    public int p;

    public bhh(com.bumptech.glide.a aVar, dmg dmgVar, int i, int i2, Bitmap bitmap) {
        oz ozVar = aVar.c;
        bhw bhwVar = aVar.e;
        Context baseContext = bhwVar.getBaseContext();
        cmz.n(baseContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        dca dcaVarF = com.bumptech.glide.a.j(baseContext).g.f(baseContext);
        Context baseContext2 = bhwVar.getBaseContext();
        cmz.n(baseContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        dca dcaVarF2 = com.bumptech.glide.a.j(baseContext2).g.f(baseContext2);
        dcaVarF2.getClass();
        dbu dbuVarAs = new dbu(dcaVarF2.b, dcaVarF2, Bitmap.class, dcaVarF2.c).q(dca.a).q(((dcd) ((dcd) ((dcd) new dcd().t(aoi.a)).ae()).ab()).w(i, i2));
        this.c = new ArrayList();
        this.d = dcaVarF;
        Handler handler = new Handler(Looper.getMainLooper(), new bhg(this, 0));
        this.e = ozVar;
        this.b = handler;
        this.h = dbuVarAs;
        this.a = dmgVar;
        s(env.b, bitmap);
    }

    public final void q() {
        int i;
        if (!this.f || this.g) {
            return;
        }
        bhe bheVar = this.m;
        if (bheVar != null) {
            this.m = null;
            r(bheVar);
            return;
        }
        this.g = true;
        dmg dmgVar = this.a;
        bhi bhiVar = dmgVar.l;
        int i2 = bhiVar.c;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) ((i2 <= 0 || (i = dmgVar.k) < 0) ? 0 : (i < 0 || i >= i2) ? -1 : ((bhd) bhiVar.e.get(i)).i));
        int i3 = (dmgVar.k + 1) % dmgVar.l.c;
        dmgVar.k = i3;
        this.k = new bhe(this.b, i3, jUptimeMillis);
        dbu dbuVarAw = this.h.q((dcd) new dcd().aa(new cpi(Double.valueOf(Math.random())))).aw(dmgVar);
        dbuVarAw.av(this.k, dbuVarAw);
    }

    public final void r(bhe bheVar) {
        this.g = false;
        boolean z = this.j;
        Handler handler = this.b;
        if (z) {
            handler.obtainMessage(2, bheVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.m = bheVar;
            return;
        }
        if (bheVar.g != null) {
            Bitmap bitmap = this.l;
            if (bitmap != null) {
                this.e.p(bitmap);
                this.l = null;
            }
            bhe bheVar2 = this.i;
            this.i = bheVar;
            ArrayList arrayList = this.c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                bha bhaVar = (bha) ((bhf) arrayList.get(size));
                Object callback = bhaVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    bhaVar.stop();
                    bhaVar.invalidateSelf();
                } else {
                    bhaVar.invalidateSelf();
                    bhe bheVar3 = ((bhh) bhaVar.a.b).i;
                    if ((bheVar3 != null ? bheVar3.e : -1) == r5.a.l.c - 1) {
                        bhaVar.f++;
                    }
                    int i = bhaVar.g;
                    if (i != -1 && bhaVar.f >= i) {
                        bhaVar.stop();
                    }
                }
            }
            if (bheVar2 != null) {
                handler.obtainMessage(2, bheVar2).sendToTarget();
            }
        }
        q();
    }

    public final void s(elc elcVar, Bitmap bitmap) {
        cmz.n(elcVar, "Argument must not be null");
        cmz.n(bitmap, "Argument must not be null");
        this.l = bitmap;
        this.h = this.h.q(new dcd().ad(elcVar, true));
        this.n = eot.f(bitmap);
        this.o = bitmap.getWidth();
        this.p = bitmap.getHeight();
    }
}
