package androidx.emoji2.text;

import android.content.Context;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import me.hd.wauxv.obf.anr;
import me.hd.wauxv.obf.atf;
import me.hd.wauxv.obf.atg;
import me.hd.wauxv.obf.bbv;
import me.hd.wauxv.obf.bpf;
import me.hd.wauxv.obf.bup;
import me.hd.wauxv.obf.bur;
import me.hd.wauxv.obf.FactoryPools;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements bpf {
    @Override // me.hd.wauxv.obf.bpf
    public final List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // me.hd.wauxv.obf.bpf
    public final Object b(Context context) {
        Object objQ;
        bbv bbvVar = new bbv(new anr(context));
        bbvVar.a = 1;
        if (atf.b == null) {
            synchronized (atf.a) {
                try {
                    if (atf.b == null) {
                        atf.b = new atf(bbvVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        FactoryPools factoryPoolsVarJ = FactoryPools.j(context);
        factoryPoolsVarJ.getClass();
        synchronized (FactoryPools.b) {
            try {
                objQ = ((HashMap) factoryPoolsVarJ.e).get(ProcessLifecycleInitializer.class);
                if (objQ == null) {
                    objQ = factoryPoolsVarJ.q(ProcessLifecycleInitializer.class, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        bur burVarAp = ((bup) objQ).ap();
        burVarAp.j(new atg(this, burVarAp));
        return Boolean.TRUE;
    }
}
