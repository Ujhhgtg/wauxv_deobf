package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Iterator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cjl {
    public final Context a;
    public final cix b = new cix(this, new cis(this, 0));
    public final anr c;
    public final Activity d;
    public boolean e;
    public final bdx f;
    public final boolean g;
    public final Kotlin$Lazy h;

    public cjl(Context context) {
        this.a = context;
        this.c = new anr(context, 8);
        for (Object obj : dfv.ai(context, new cgu(12))) {
            if (((Context) obj) instanceof Activity) {
                this.d = (Activity) obj;
                this.f = new bdx(this, 1);
                this.g = true;
                ckm ckmVar = this.b.r;
                ckmVar.c(new cjk(ckmVar));
                this.b.r.c(new ActivityNavigator(this.a));
                this.h = new Kotlin$Lazy(new cis(this, 1));
            }
        }
        obj = null;
        this.d = (Activity) obj;
        this.f = new bdx(this, 1);
        this.g = true;
        ckm ckmVar2 = this.b.r;
        ckmVar2.c(new cjk(ckmVar2));
        this.b.r.c(new ActivityNavigator(this.a));
        this.h = new Kotlin$Lazy(new cis(this, 1));
    }

    public final int i() {
        km kmVar = this.b.f;
        int i = 0;
        if (kmVar != null && kmVar.isEmpty()) {
            return 0;
        }
        Iterator it = kmVar.iterator();
        while (it.hasNext()) {
            if (!(((cio) it.next()).b instanceof cji) && (i = i + 1) < 0) {
                throw new ArithmeticException("Count overflow has happened.");
            }
        }
        return i;
    }

    public final void j(int i, Bundle bundle) {
        int i2;
        cjo cjoVar;
        Bundle bundleR;
        cix cixVar = this.b;
        cjg cjgVar = cixVar.f.isEmpty() ? cixVar.c : ((cio) cixVar.f.last()).b;
        if (cjgVar == null) {
            throw new IllegalStateException(
                    "No current destination found. Ensure a navigation graph has been set for NavController " + this
                            + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
        }
        cim cimVarM = cjgVar.m(i);
        if (cimVarM != null) {
            cjoVar = cimVarM.b;
            i2 = cimVarM.a;
            Bundle bundle2 = cimVarM.c;
            if (bundle2 != null) {
                bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                bundleR.putAll(bundle2);
            } else {
                bundleR = null;
            }
        } else {
            i2 = i;
            cjoVar = null;
            bundleR = null;
        }
        if (bundle != null) {
            if (bundleR == null) {
                bundleR = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
            }
            bundleR.putAll(bundle);
        }
        if (i2 == 0 && cjoVar != null) {
            boolean z = cjoVar.d;
            int i3 = cjoVar.c;
            if (i3 != -1) {
                if (i3 == -1 || !cixVar.al(i3, z, false)) {
                    return;
                }
                cixVar.ac();
                return;
            }
        }
        if (i2 == 0) {
            throw new IllegalArgumentException(
                    "Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        cjg cjgVarAd = cixVar.ad(i2, null);
        if (cjgVarAd != null) {
            cixVar.ak(cjgVarAd, bundleR, cjoVar);
            return;
        }
        int i4 = cjg.e;
        anr anrVar = this.c;
        String strR = bmy.r(anrVar, i2);
        if (cimVarM == null) {
            throw new IllegalArgumentException("Navigation action/destination " + strR
                    + " cannot be found from the current destination " + cjgVar);
        }
        StringBuilder sbZ = StaticHelpers6.concatAndToSb("Navigation destination ", strR, " referenced from action ");
        sbZ.append(bmy.r(anrVar, i));
        sbZ.append(" cannot be found from the current destination ");
        sbZ.append(cjgVar);
        throw new IllegalArgumentException(sbZ.toString().toString());
    }
}
