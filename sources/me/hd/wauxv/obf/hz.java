package me.hd.wauxv.obf;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hz implements cdw {
    public Object g;
    public Object h;

    public hz(Context context) {
        this.g = context;
    }

    public abstract IntentFilter d();

    public abstract int e();

    public abstract void f();

    public void i() {
        hy hyVar = (hy) this.g;
        if (hyVar != null) {
            try {
                ((ic) this.h).x.unregisterReceiver(hyVar);
            } catch (IllegalArgumentException unused) {
            }
            this.g = null;
        }
    }

    public abstract void j(ud udVar, ud udVar2);

    public void k() {
        this.g = null;
        this.h = null;
    }

    public MenuItem l(MenuItem menuItem) {
        if (!(menuItem instanceof dog)) {
            return menuItem;
        }
        dog dogVar = (dog) menuItem;
        if (((dhq) this.h) == null) {
            this.h = new dhq(0);
        }
        MenuItem menuItem2 = (MenuItem) ((dhq) this.h).get(dogVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        ccd ccdVar = new ccd((Context) this.g, dogVar);
        ((dhq) this.h).put(dogVar, ccdVar);
        return ccdVar;
    }

    public int m(int i, int i2) {
        int iO = o(i);
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int iO2 = o(i5);
            i3 += iO2;
            if (i3 == i2) {
                i4++;
                i3 = 0;
            } else if (i3 > i2) {
                i4++;
                i3 = iO2;
            }
        }
        return i3 + iO > i2 ? i4 + 1 : i4;
    }

    public int n(int i, int i2) {
        int iO = o(i);
        if (iO == i2) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int iO2 = o(i4);
            i3 += iO2;
            if (i3 == i2) {
                i3 = 0;
            } else if (i3 > i2) {
                i3 = iO2;
            }
        }
        if (iO + i3 <= i2) {
            return i3;
        }
        return 0;
    }

    public abstract int o(int i);

    public abstract void p(ud udVar, ud udVar2, CharSequence charSequence);

    public void q() {
        ((SparseIntArray) this.g).clear();
    }

    public abstract void r();

    public void s(afq afqVar, Bundle bundle) {
        this.h = afqVar;
        r();
    }

    public void t() {
        i();
        IntentFilter intentFilterD = d();
        if (intentFilterD.countActions() == 0) {
            return;
        }
        if (((hy) this.g) == null) {
            this.g = new hy(this, 0);
        }
        ((ic) this.h).x.registerReceiver((hy) this.g, intentFilterD);
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        Context context = (Context) this.g;
        Class cls = (Class) this.h;
        return new cws(context, chmVar.w(File.class, cls), chmVar.w(Uri.class, cls), cls);
    }

    public hz(Context context, Class cls) {
        this.g = context;
        this.h = cls;
    }

    public hz() {
        this.g = new SparseIntArray();
        this.h = new SparseIntArray();
    }

    public hz(ic icVar) {
        this.h = icVar;
    }
}
