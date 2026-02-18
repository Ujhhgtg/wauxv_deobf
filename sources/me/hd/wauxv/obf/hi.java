package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hi implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Context b;

    public /* synthetic */ hi(Context context, int i) {
        this.a = i;
        this.b = context;
    }

    /* JADX WARN: Found duplicated region for block: B:28:0x008d  */
    @Override // java.lang.Runnable
    public final void run() {
        bwy bwyVar;
        Object systemService;
        Context context;
        switch (this.a) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    Context context2 = this.b;
                    ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i >= 33) {
                            kz kzVar = ho.g;
                            kzVar.getClass();
                            kq kqVar = new kq(kzVar);
                            while (true) {
                                if (kqVar.hasNext()) {
                                    ho hoVar = (ho) ((WeakReference) kqVar.next()).get();
                                    if (hoVar != null && (context = ((ic) hoVar).x) != null) {
                                        systemService = context.getSystemService("locale");
                                    }
                                } else {
                                    systemService = null;
                                }
                            }
                            bwyVar = systemService != null ? new bwy(new bwz(hk.a(systemService))) : bwy.a;
                        } else {
                            bwyVar = ho.c;
                            if (bwyVar == null) {
                            }
                        }
                        if (bwyVar.b.a.isEmpty()) {
                            String strAu = bhu.au(context2);
                            Object systemService2 = context2.getSystemService("locale");
                            if (systemService2 != null) {
                                hk.b(systemService2, hj.a(strAu));
                            }
                        }
                        context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                    }
                }
                ho.f = true;
                break;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new hi(this.b, 2));
                break;
            default:
                emc.bc(this.b, new cvu(), emc.v, false);
                break;
        }
    }
}
