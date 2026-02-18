package me.hd.wauxv.obf;

import com.drake.net.exception.NetException;
import com.drake.net.exception.URLParseException;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cla implements alp {
    public final alq f;

    public cla(alq alqVar) {
        this.f = alqVar;
    }

    /* JADX WARN: Found duplicated region for block: B:7:0x0013 */
    @Override // me.hd.wauxv.obf.alp
    public final Object _be(afw afwVar) throws Exception {
        ckz ckzVar;
        String str;
        String str2;
        Exception e;
        if (afwVar instanceof ckz) {
            ckzVar = (ckz) afwVar;
            int i = ckzVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                ckzVar.f = i - Integer.MIN_VALUE;
            } else {
                ckzVar = new ckz(this, afwVar);
            }
        } else {
            ckzVar = new ckz(this, afwVar);
        }
        Object obj = ckzVar.d;
        int i2 = ckzVar.f;
        if (i2 == 0) {
            bhu.bd(obj);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            throwIfVar1IsNull(stackTrace, "Throwable().stackTrace");
            StackTraceElement stackTraceElement = (StackTraceElement) la.q(stackTrace, 1);
            if (stackTraceElement != null) {
                str = " ...(" + stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ')';
            } else {
                str = null;
            }
            try {
                alq alqVar = this.f;
                ckzVar.a = str;
                ckzVar.f = 1;
                Object obj_be = alqVar._be(ckzVar);
                ahq ahqVar = ahq.a;
                return obj_be == ahqVar ? ahqVar : obj_be;
            } catch (Exception e2) {
                str2 = str;
                e = e2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = ckzVar.a;
            try {
                bhu.bd(obj);
                return obj;
            } catch (Exception e3) {
                e = e3;
            }
        }
        if (str2 != null && (e instanceof NetException)) {
            ((NetException) e).setOccurred(str2);
        } else if (str2 != null && (e instanceof URLParseException)) {
            ((URLParseException) e).setOccurred(str2);
        }
        throw e;
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _t(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        return bmy.x(this.f, ahgVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final Object _u(Object obj, bgj bgjVar) {
        return bgjVar.g(obj, this.f);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahh _v(ahh ahhVar) {
        throwIfVar1IsNull(ahhVar, "context");
        return bmy.aa(this.f, ahhVar);
    }

    @Override // me.hd.wauxv.obf.ahh
    public final ahf _w(ahg ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        return this.f._w(ahgVar);
    }

    @Override // me.hd.wauxv.obf.ahf
    public final ahg getKey() {
        return arj.i;
    }

    @Override // me.hd.wauxv.obf.brf
    public final boolean m() {
        return this.f.m();
    }

    @Override // me.hd.wauxv.obf.brf
    public final CancellationException n() {
        return this.f.n();
    }

    @Override // me.hd.wauxv.obf.brf
    public final ye o(brm brmVar) {
        return this.f.o(brmVar);
    }

    @Override // me.hd.wauxv.obf.brf
    public final aox p(boolean z, boolean z2, brh brhVar) {
        return this.f.p(z, z2, brhVar);
    }

    @Override // me.hd.wauxv.obf.brf
    public final void q(CancellationException cancellationException) {
        this.f.q(cancellationException);
    }

    @Override // me.hd.wauxv.obf.brf
    public final boolean start() {
        return this.f.start();
    }
}
