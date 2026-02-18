package me.hd.wauxv.obf;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dx extends btp implements bfu {
    public static final dx a;
    public static final dx b;
    public final /* synthetic */ int c;

    static {
        int i = 0;
        a = new dx(i, 0);
        b = new dx(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dx(int i, int i2) {
        super(i);
        this.c = i2;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.c) {
            case 0:
                return Integer.valueOf(cyj.f.c(2147418112) + 65536);
            case 1:
                return new Handler(Looper.getMainLooper());
            default:
                return ens.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx(bug bugVar, et etVar) {
        super(0);
        this.c = 2;
    }
}
