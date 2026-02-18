package me.hd.wauxv.obf;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dkw extends lo {
    public final Socket a;

    public dkw(Socket socket) {
        bzo.q(socket, "socket");
        this.a = socket;
    }

    @Override // me.hd.wauxv.obf.lo
    public final IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // me.hd.wauxv.obf.lo
    public final void timedOut() {
        Socket socket = this.a;
        try {
            socket.close();
        } catch (AssertionError e) {
            if (!emc.ar(e)) {
                throw e;
            }
            cqj.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e);
        } catch (Exception e2) {
            cqj.a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
        }
    }
}
