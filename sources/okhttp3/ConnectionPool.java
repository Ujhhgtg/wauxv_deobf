package okhttp3;

import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.bzo;
import net.bytebuddy.implementation.MethodDelegation;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionPool {
    private final RealConnectionPool delegate;

    public ConnectionPool(RealConnectionPool realConnectionPool) {
        bzo.q(realConnectionPool, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.delegate = realConnectionPool;
    }

    public final int connectionCount() {
        return this.delegate.connectionCount();
    }

    public final void evictAll() {
        this.delegate.evictAll();
    }

    public final RealConnectionPool getDelegate$okhttp() {
        return this.delegate;
    }

    public final int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool(int i, long j, TimeUnit timeUnit) {
        this(new RealConnectionPool(TaskRunner.INSTANCE, i, j, timeUnit));
        bzo.q(timeUnit, "timeUnit");
    }

    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
