package me.hd.wauxv.obf;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class al implements Future {
    public static final boolean a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger b = Logger.getLogger(al.class.getName());
    public static final emc c;
    public static final Object d;
    public volatile Object e;
    public volatile ah f;
    public volatile ak g;

    static {
        emc ajVar;
        try {
            ajVar = new ai(AtomicReferenceFieldUpdater.newUpdater(ak.class, Thread.class, "ᛱᛱᛱᛱᛱ"), AtomicReferenceFieldUpdater.newUpdater(ak.class, ak.class, "ᛱᛱᛱᛱᛲ"), AtomicReferenceFieldUpdater.newUpdater(al.class, ak.class, "ᛱᛱᛱᛱᛳ"), AtomicReferenceFieldUpdater.newUpdater(al.class, ah.class, "ᛱᛱᛱᛱᛲ"), AtomicReferenceFieldUpdater.newUpdater(al.class, Object.class, "ᛱᛱᛱᛱᛱ"));
            th = null;
        } catch (Throwable th) {
            th = th;
            ajVar = new aj(3);
        }
        c = ajVar;
        if (th != null) {
            b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        d = new Object();
    }

    public static void h(al alVar) {
        ak akVar;
        ah ahVar;
        do {
            akVar = alVar.g;
        } while (!c.h(alVar, akVar, ak.a));
        while (akVar != null) {
            Thread thread = akVar.b;
            if (thread != null) {
                akVar.b = null;
                LockSupport.unpark(thread);
            }
            akVar = akVar.c;
        }
        do {
            ahVar = alVar.f;
        } while (!c.f(alVar, ahVar));
        ah ahVar2 = null;
        while (ahVar != null) {
            ah ahVar3 = ahVar.b;
            ahVar.b = ahVar2;
            ahVar2 = ahVar;
            ahVar = ahVar3;
        }
        while (ahVar2 != null) {
            ahVar2 = ahVar2.b;
            try {
                throw null;
            } catch (RuntimeException e) {
                b.log(Level.SEVERE, "RuntimeException while executing runnable null with executor null", (Throwable) e);
            }
        }
    }

    public static Object i(Object obj) throws ExecutionException {
        if (obj instanceof af) {
            Throwable th = ((af) obj).c;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof ag) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == d) {
            return null;
        }
        return obj;
    }

    public static Object j(al alVar) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = alVar.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.e;
        if (obj != null) {
            return false;
        }
        if (!c.g(this, obj, a ? new af(new CancellationException("Future.cancel() was called."), z) : z ? af.a : af.b)) {
            return false;
        }
        h(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        ak akVar = ak.a;
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.e;
        if (obj != null) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            ak akVar2 = this.g;
            if (akVar2 != akVar) {
                ak akVar3 = new ak();
                while (true) {
                    emc emcVar = c;
                    emcVar.i(akVar3, akVar2);
                    if (emcVar.h(this, akVar2, akVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(akVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.e;
                            if (obj2 != null) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(akVar3);
                        break;
                    }
                    akVar2 = this.g;
                    if (akVar2 == akVar) {
                    }
                }
            }
            return i(this.e);
        }
        while (nanos > 0) {
            Object obj3 = this.e;
            if (obj3 != null) {
                return i(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strS = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strS2 = StaticHelpers6.concat(strS, " (plus ");
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strS3 = strS2 + jConvert + " " + lowerCase;
                if (z) {
                    strS3 = StaticHelpers6.concat(strS3, ",");
                }
                strS2 = StaticHelpers6.concat(strS3, " ");
            }
            if (z) {
                strS2 = strS2 + nanos2 + " nanoseconds ";
            }
            strS = StaticHelpers6.concat(strS2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(StaticHelpers6.concat(strS, " but future completed as timeout expired"));
        }
        throw new TimeoutException(strS + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.e instanceof af;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.e != null;
    }

    public final void k(StringBuilder sb) {
        try {
            Object objJ = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(objJ == this ? "this future" : String.valueOf(objJ));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    public final void l(ak akVar) {
        akVar.b = null;
        while (true) {
            ak akVar2 = this.g;
            if (akVar2 == ak.a) {
                return;
            }
            ak akVar3 = null;
            while (akVar2 != null) {
                ak akVar4 = akVar2.c;
                if (akVar2.b != null) {
                    akVar3 = akVar2;
                } else if (akVar3 != null) {
                    akVar3.c = akVar4;
                    if (akVar3.b == null) {
                    }
                } else if (!c.h(this, akVar2, akVar4)) {
                }
                akVar2 = akVar4;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.e instanceof af) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e) {
                str = "Exception thrown from implementation: " + e.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                k(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        ak akVar = ak.a;
        if (!Thread.interrupted()) {
            Object obj2 = this.e;
            if (obj2 != null) {
                return i(obj2);
            }
            ak akVar2 = this.g;
            if (akVar2 != akVar) {
                ak akVar3 = new ak();
                do {
                    emc emcVar = c;
                    emcVar.i(akVar3, akVar2);
                    if (emcVar.h(this, akVar2, akVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.e;
                            } else {
                                l(akVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return i(obj);
                    }
                    akVar2 = this.g;
                } while (akVar2 != akVar);
            }
            return i(this.e);
        }
        throw new InterruptedException();
    }
}
