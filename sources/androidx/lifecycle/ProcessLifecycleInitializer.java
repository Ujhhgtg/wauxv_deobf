package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.umeng.analytics.pro.f;
import java.util.HashSet;
import java.util.List;
import me.hd.wauxv.obf.avd;
import me.hd.wauxv.obf.bpf;
import me.hd.wauxv.obf.bug;
import me.hd.wauxv.obf.buj;
import me.hd.wauxv.obf.buk;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cvs;
import me.hd.wauxv.obf.cvt;
import me.hd.wauxv.obf.jx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements bpf {
    @Override // me.hd.wauxv.obf.bpf
    public final List a() {
        return avd.a;
    }

    @Override // me.hd.wauxv.obf.bpf
    public final Object b(Context context) {
        throwIfVar1IsNull(context, "context");
        jx jxVarJ = jx.j(context);
        throwIfVar1IsNull(jxVarJ, "getInstance(...)");
        if (!((HashSet) jxVarJ.f).contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException(
                    "ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        if (!buk.a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            throwIfVar1IsNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new buj());
        }
        cvt cvtVar = cvt.a;
        cvtVar.getClass();
        cvtVar.f = new Handler();
        cvtVar.g.m(bug.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        throwIfVar1IsNull(applicationContext2, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new cvs(cvtVar));
        return cvtVar;
    }
}
