package com.drake.net.internal;

import android.content.Context;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.obf.bpf;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.ckv;
import me.hd.wauxv.obf.ens;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class NetInitializer implements bpf {
    @Override // me.hd.wauxv.obf.bpf
    public final List a() {
        return new ArrayList();
    }

    @Override // me.hd.wauxv.obf.bpf
    public final Object b(Context context) {
        throwIfVar1IsNull(context, "context");
        ckv.a = context;
        return ens.a;
    }
}
