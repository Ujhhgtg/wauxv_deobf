package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnx implements bxs {
    public volatile bxs a;
    public Boolean b;
    public Method d;
    public axa f;
    public final Queue g;
    public final boolean h;

    public dnx(LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.g = linkedBlockingQueue;
        this.h = z;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean c() {
        return i().c();
    }

    @Override // me.hd.wauxv.obf.bxs
    public final void debug(String str) {
        i().debug(str);
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean e(int i) {
        return i().e(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || dnx.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 732274226;
    }

    public final bxs i() {
        if (this.a != null) {
            return this.a;
        }
        if (this.h) {
            return cig.a;
        }
        if (this.f == null) {
            Queue queue = this.g;
            axa axaVar = new axa();
            axaVar.a = this;
            axaVar.b = queue;
            this.f = axaVar;
        }
        return this.f;
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isDebugEnabled() {
        return i().isDebugEnabled();
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isErrorEnabled() {
        return i().isErrorEnabled();
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isInfoEnabled() {
        return i().isInfoEnabled();
    }

    @Override // me.hd.wauxv.obf.bxs
    public final boolean isWarnEnabled() {
        return i().isWarnEnabled();
    }

    public final boolean j() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.a.getClass().getMethod("log", dnz.class);
            this.b = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.b = Boolean.FALSE;
        }
        return this.b.booleanValue();
    }

    @Override // me.hd.wauxv.obf.bxs
    public final void warn(String str, Throwable th) {
        i().warn(str, th);
    }
}
