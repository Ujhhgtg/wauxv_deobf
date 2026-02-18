package me.hd.wauxv.obf;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmw implements ajb {
    public final bid a;
    public final int c;
    public HttpURLConnection g;
    public InputStream h;
    public volatile boolean i;

    public bmw(bid bidVar, int i) {
        this.a = bidVar;
        this.c = i;
    }

    public static int j(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        return InputStream.class;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        this.i = true;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        InputStream inputStream = this.h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.g;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.g = null;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return 2;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        bid bidVar = this.a;
        int i = bxq.b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            ajaVar._bo(k(bidVar.j(), 0, null, bidVar.a.b()));
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e);
            }
            ajaVar.k(e);
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + bxq.c(jElapsedRealtimeNanos));
            }
        }
    }

    public final InputStream k(URL url, int i, URL url2, Map map) throws azv {
        if (i >= 5) {
            throw new azv("Too many (> 5) redirects!", -1, (IOException) null);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new azv("In re-direct loop", -1, (IOException) null);
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i2 = this.c;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i2);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.g = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.h = this.g.getInputStream();
                if (this.i) {
                    return null;
                }
                int iJ = j(this.g);
                int i3 = iJ / 100;
                if (i3 == 2) {
                    HttpURLConnection httpURLConnection2 = this.g;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.h = new afn(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.h = httpURLConnection2.getInputStream();
                        }
                        return this.h;
                    } catch (IOException e) {
                        throw new azv("Failed to obtain InputStream", j(httpURLConnection2), e);
                    }
                }
                if (i3 != 3) {
                    if (iJ == -1) {
                        throw new azv("Http request failed", iJ, (IOException) null);
                    }
                    try {
                        throw new azv(this.g.getResponseMessage(), iJ, (IOException) null);
                    } catch (IOException e2) {
                        throw new azv("Failed to get a response message", iJ, e2);
                    }
                }
                String headerField = this.g.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new azv("Received empty or null redirect url", iJ, (IOException) null);
                }
                try {
                    URL url3 = new URL(url, headerField);
                    d();
                    return k(url3, i + 1, url, map);
                } catch (MalformedURLException e3) {
                    throw new azv(yg.k("Bad redirect url: ", headerField), iJ, e3);
                }
            } catch (IOException e4) {
                throw new azv("Failed to connect or obtain data", j(this.g), e4);
            }
        } catch (IOException e5) {
            throw new azv("URL.openConnection threw", 0, e5);
        }
    }
}
