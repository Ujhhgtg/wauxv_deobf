package me.hd.wauxv.obf;

import com.drake.net.exception.ConvertException;
import com.drake.net.exception.DownloadFileException;
import com.drake.net.exception.HttpFailureException;
import com.drake.net.exception.NetConnectException;
import com.drake.net.exception.NetException;
import com.drake.net.exception.NetSocketTimeoutException;
import com.drake.net.exception.NoCacheException;
import com.drake.net.exception.RequestParamsException;
import com.drake.net.exception.ResponseException;
import com.drake.net.exception.ServerResponseException;
import com.drake.net.exception.URLParseException;
import java.net.UnknownHostException;
import java.util.concurrent.CancellationException;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cky extends et {
    @Override // me.hd.wauxv.obf.et
    public final void c(CancellationException cancellationException) {
        cnf.ao(this.a);
        super.c(null);
    }

    @Override // me.hd.wauxv.obf.et
    public final void d(Throwable th) {
        throwIfVar1IsNull(th, "e");
        f(th);
    }

    @Override // me.hd.wauxv.obf.et
    public final void f(Throwable th) {
        throwIfVar1IsNull(th, "e");
        ckv.i.getClass();
        String string = th instanceof UnknownHostException ? ckv.j().getString(R.string.net_host_error)
                : th instanceof URLParseException ? ckv.j().getString(R.string.net_url_error)
                        : th instanceof NetConnectException ? ckv.j().getString(R.string.net_connect_error)
                                : th instanceof NetSocketTimeoutException
                                        ? ckv.j().getString(R.string.net_connect_timeout_error, th.getMessage())
                                        : th instanceof DownloadFileException
                                                ? ckv.j().getString(R.string.net_download_error)
                                                : th instanceof ConvertException
                                                        ? ckv.j().getString(R.string.net_parse_error)
                                                        : th instanceof RequestParamsException
                                                                ? ckv.j().getString(R.string.net_request_error)
                                                                : th instanceof ServerResponseException
                                                                        ? ckv.j().getString(R.string.net_server_error)
                                                                        : th instanceof NullPointerException
                                                                                ? ckv.j().getString(
                                                                                        R.string.net_null_error)
                                                                                : th instanceof NoCacheException
                                                                                        ? ckv.j().getString(
                                                                                                R.string.net_no_cache_error)
                                                                                        : th instanceof ResponseException
                                                                                                ? th.getMessage()
                                                                                                : th instanceof HttpFailureException
                                                                                                        ? ckv.j()
                                                                                                                .getString(
                                                                                                                        R.string.request_failure)
                                                                                                        : th instanceof NetException
                                                                                                                ? ckv.j()
                                                                                                                        .getString(
                                                                                                                                R.string.net_error)
                                                                                                                : ckv.j()
                                                                                                                        .getString(
                                                                                                                                R.string.net_other_error);
        cnf.ay(th);
        if (string == null) {
            return;
        }
        doh.b(new cle(string, 1));
    }
}
