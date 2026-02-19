package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbu implements ate {
    public final Context a;
    public final bbt b;
    public final SyntheticClass d;
    public final Object e = new Object();
    public Handler f;
    public ThreadPoolExecutor g;
    public ThreadPoolExecutor h;
    public cnh i;

    public bbu(Context context, bbt bbtVar) {
        cna.j(context, "Context cannot be null");
        this.a = context.getApplicationContext();
        this.b = bbtVar;
        this.d = bbv.s;
    }

    @Override // me.hd.wauxv.obf.ate
    public final void c(cnh cnhVar) {
        synchronized (this.e) {
            this.i = cnhVar;
        }
        synchronized (this.e) {
            try {
                if (this.i == null) {
                    return;
                }
                if (this.g == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS,
                            new LinkedBlockingDeque(), new acq("emojiCompat"));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.h = threadPoolExecutor;
                    this.g = threadPoolExecutor;
                }
                this.g.execute(new dh(this, 12));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        synchronized (this.e) {
            try {
                this.i = null;
                Handler handler = this.f;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f = null;
                ThreadPoolExecutor threadPoolExecutor = this.h;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.g = null;
                this.h = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final bce k() {
        try {
            SyntheticClass syntheticClassVar = this.d;
            Context context = this.a;
            bbt bbtVar = this.b;
            syntheticClassVar.getClass();
            Object[] objArr = { bbtVar };
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            ek ekVarC = FontsProvider.createInstanceWithArgs(context, Collections.unmodifiableList(arrayList));
            int i = ekVarC.c;
            if (i != 0) {
                throw new RuntimeException(yg.f(i, "fetchFonts failed (", ")"));
            }
            bce[] bceVarArr = (bce[]) ((List) ekVarC.d).get(0);
            if (bceVarArr == null || bceVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return bceVarArr[0];
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("provider not found", e);
        }
    }
}
