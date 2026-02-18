package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ho {
    public static final hm a = new hm(new hn(0));
    public static final int b = -100;
    public static bwy c = null;
    public static bwy d = null;
    public static Boolean e = null;
    public static boolean f = false;
    public static final kz g = new kz(0);
    public static final Object h = new Object();
    public static final Object i = new Object();

    public static boolean j(Context context) {
        if (e == null) {
            try {
                int i2 = jz.a;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) jz.class), jy.a() | 128).metaData;
                if (bundle != null) {
                    e = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                e = Boolean.FALSE;
            }
        }
        return e.booleanValue();
    }

    public static void k(ic icVar) {
        synchronized (h) {
            try {
                kz kzVar = g;
                kzVar.getClass();
                kq kqVar = new kq(kzVar);
                while (kqVar.hasNext()) {
                    ho hoVar = (ho) ((WeakReference) kqVar.next()).get();
                    if (hoVar == icVar || hoVar == null) {
                        kqVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract boolean o(int i2);

    public abstract void p(int i2);

    public abstract void q(View view);

    public abstract void r(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void s(CharSequence charSequence);
}
