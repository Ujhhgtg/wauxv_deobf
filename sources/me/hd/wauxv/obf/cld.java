package me.hd.wauxv.obf;

import com.drake.net.exception.HttpFailureException;
import com.drake.net.exception.NetConnectException;
import com.drake.net.exception.NetException;
import com.drake.net.exception.NetSocketTimeoutException;
import com.drake.net.exception.NetUnknownHostException;
import com.drake.net.exception.NoCacheException;
import java.lang.ref.WeakReference;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cld implements Interceptor {
    public static final cld a = new cld();

    public static void b(Interceptor.Chain chain) {
        ckv.g.add(new WeakReference(chain.call()));
    }

    public static void c(Interceptor.Chain chain) {
        Iterator it = ckv.g.iterator();
        bzo.p(it, "NetConfig.runningCalls.iterator()");
        while (it.hasNext()) {
            Call call = (Call) ((WeakReference) it.next()).get();
            if (call == null) {
                it.remove();
            } else if (call.equals(chain.call())) {
                it.remove();
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4, types: [me.hd.wauxv.obf.bcm, okhttp3.Response] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        ConnectException connectException;
        Throwable th;
        Response responseProceed;
        Response response;
        bzo.q(chain, "chain");
        Request request = chain.request();
        RequestBody requestBodyBody = request.body();
        clg clgVar = requestBodyBody != null ? new clg(requestBodyBody, (ConcurrentLinkedQueue) request.tag(cnk.class)) : null;
        bcm bcmVar = (bcm) request.tag(bcm.class);
        ?? r1 = bcmVar;
        if (bcmVar == null) {
            r1 = ckv.d;
        }
        so soVar = (so) request.tag(so.class);
        Request.Builder builderNewBuilder = request.newBuilder();
        if (r1 != 0 && soVar != null) {
            builderNewBuilder.cacheControl(new CacheControl.Builder().noCache().noStore().build());
        }
        Request requestBuild = builderNewBuilder.method(request.method(), clgVar).build();
        try {
            try {
                try {
                    b(chain);
                    if (r1 != 0) {
                        int i = soVar == null ? -1 : clb.a[soVar.ordinal()];
                        if (i == 1) {
                            responseProceed = r1.b(requestBuild);
                            if (responseProceed == null) {
                                throw new NoCacheException(requestBuild, null, null, 6, null);
                            }
                        } else if (i == 2) {
                            responseProceed = r1.b(requestBuild);
                            if (responseProceed == null) {
                                responseProceed = r1.c(chain.proceed(requestBuild));
                            }
                        } else if (i != 3) {
                            responseProceed = i != 4 ? chain.proceed(requestBuild) : r1.c(chain.proceed(requestBuild));
                        } else {
                            try {
                                responseProceed = r1.c(chain.proceed(requestBuild));
                            } catch (Exception unused) {
                                responseProceed = r1.b(requestBuild);
                                if (responseProceed == null) {
                                    throw new NoCacheException(requestBuild, null, null, 6, null);
                                }
                            }
                        }
                    } else {
                        responseProceed = chain.proceed(requestBuild);
                    }
                    response = responseProceed;
                } catch (Throwable th2) {
                    if ((r1 != 0 ? r1.body() : null) == null) {
                        c(chain);
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (NetException e) {
            throw e;
        } catch (ConnectException e2) {
            connectException = e2;
        } catch (SocketTimeoutException e3) {
            e = e3;
        } catch (UnknownHostException e4) {
            e = e4;
        }
        try {
            ResponseBody responseBodyBody = response.body();
            Response responseBuild = response.newBuilder().body(responseBodyBody != null ? new clj(responseBodyBody, (ConcurrentLinkedQueue) requestBuild.tag(cng.class), new clc(chain)) : null).build();
            if ((responseBuild != null ? responseBuild.body() : null) == null) {
                c(chain);
            }
            return responseBuild;
        } catch (NetException e5) {
            throw e5;
        } catch (ConnectException e6) {
            connectException = e6;
            throw new NetConnectException(requestBuild, null, connectException, 2, null);
        } catch (SocketTimeoutException e7) {
            e = e7;
            throw new NetSocketTimeoutException(requestBuild, e.getMessage(), e);
        } catch (UnknownHostException e8) {
            e = e8;
            throw new NetUnknownHostException(requestBuild, e.getMessage(), null, 4, null);
        } catch (Throwable th4) {
            th = th4;
            throw new HttpFailureException(requestBuild, null, th, 2, null);
        }
    }
}
