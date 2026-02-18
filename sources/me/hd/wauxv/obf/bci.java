package me.hd.wauxv.obf;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.OkHttpUtils;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bci {
    public static final String a;
    public static final String b;
    public final String c;
    public final Headers d;
    public final String e;
    public final Protocol f;
    public final int g;
    public final String h;
    public final Headers i;
    public final Handshake j;
    public final long k;
    public final long l;

    static {
        StringBuilder sb = new StringBuilder();
        Platform.Companion companion = Platform.Companion;
        sb.append(companion.get().getPrefix());
        sb.append("-Sent-Millis");
        a = sb.toString();
        b = companion.get().getPrefix() + "-Received-Millis";
    }

    public bci(dlc dlcVar) throws IOException {
        bzo.q(dlcVar, "rawSource");
        try {
            cyl cylVarAh = emc.ah(dlcVar);
            this.c = cylVarAh.m(Long.MAX_VALUE);
            this.e = cylVarAh.m(Long.MAX_VALUE);
            Headers.Builder builder = new Headers.Builder();
            int iB = bch.b(cylVarAh);
            for (int i = 0; i < iB; i++) {
                OkHttpUtils.addLenient(builder, cylVarAh.m(Long.MAX_VALUE));
            }
            this.d = builder.build();
            StatusLine statusLine = StatusLine.Companion.parse(cylVarAh.m(Long.MAX_VALUE));
            this.f = statusLine.protocol;
            this.g = statusLine.code;
            this.h = statusLine.message;
            Headers.Builder builder2 = new Headers.Builder();
            int iB2 = bch.b(cylVarAh);
            for (int i2 = 0; i2 < iB2; i2++) {
                OkHttpUtils.addLenient(builder2, cylVarAh.m(Long.MAX_VALUE));
            }
            String str = a;
            String str2 = builder2.get(str);
            String str3 = b;
            String str4 = builder2.get(str3);
            builder2.removeAll(str);
            builder2.removeAll(str3);
            this.k = str2 != null ? Long.parseLong(str2) : 0L;
            this.l = str4 != null ? Long.parseLong(str4) : 0L;
            this.i = builder2.build();
            if (dnr.bp(this.c, "https://", false)) {
                String strM = cylVarAh.m(Long.MAX_VALUE);
                if (strM.length() > 0) {
                    throw new IOException("expected \"\" but was \"" + strM + '\"');
                }
                this.j = Handshake.Companion.get(!cylVarAh.i() ? TlsVersion.Companion.forJavaName(cylVarAh.m(Long.MAX_VALUE)) : TlsVersion.SSL_3_0, CipherSuite.Companion.forJavaName(cylVarAh.m(Long.MAX_VALUE)), m(cylVarAh), m(cylVarAh));
            } else {
                this.j = null;
            }
            dlcVar.close();
        } catch (Throwable th) {
            dlcVar.close();
            throw th;
        }
    }

    public static List m(cyl cylVar) throws IOException {
        int iB = bch.b(cylVar);
        if (iB == -1) {
            return avd.a;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList(iB);
            int i = 0;
            for (int i2 = 0; i2 < iB; i2++) {
                String strM = cylVar.m(Long.MAX_VALUE);
                rh rhVar = new rh();
                sj sjVar = sj.a;
                sj sjVarE = nu.e(strM);
                bzo.n(sjVarE);
                rhVar.al(sjVarE);
                arrayList.add(certificateFactory.generateCertificate(new rg(rhVar, i)));
            }
            return arrayList;
        } catch (CertificateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static void n(cyk cykVar, List list) throws IOException {
        try {
            cykVar.ai(list.size());
            cykVar.writeByte(10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                byte[] encoded = ((Certificate) it.next()).getEncoded();
                sj sjVar = sj.a;
                bzo.p(encoded, "bytes");
                cykVar.q(nu.i(encoded).e());
                cykVar.writeByte(10);
            }
        } catch (CertificateEncodingException e) {
            throw new IOException(e.getMessage());
        }
    }

    public final void o(DiskLruCache.Editor editor) {
        ens ensVar;
        String str = this.c;
        Handshake handshake = this.j;
        Headers headers = this.i;
        Headers headers2 = this.d;
        cyk cykVarAg = emc.ag(editor.newSink(0));
        Throwable th = null;
        try {
            cykVarAg.q(str);
            cykVarAg.writeByte(10);
            cykVarAg.q(this.e);
            cykVarAg.writeByte(10);
            cykVarAg.ai(headers2.size());
            cykVarAg.writeByte(10);
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                cykVarAg.q(headers2.name(i));
                cykVarAg.q(": ");
                cykVarAg.q(headers2.value(i));
                cykVarAg.writeByte(10);
            }
            cykVarAg.q(new StatusLine(this.f, this.g, this.h).toString());
            cykVarAg.writeByte(10);
            cykVarAg.ai(headers.size() + 2);
            cykVarAg.writeByte(10);
            int size2 = headers.size();
            for (int i2 = 0; i2 < size2; i2++) {
                cykVarAg.q(headers.name(i2));
                cykVarAg.q(": ");
                cykVarAg.q(headers.value(i2));
                cykVarAg.writeByte(10);
            }
            cykVarAg.q(a);
            cykVarAg.q(": ");
            cykVarAg.ai(this.k);
            cykVarAg.writeByte(10);
            cykVarAg.q(b);
            cykVarAg.q(": ");
            cykVarAg.ai(this.l);
            cykVarAg.writeByte(10);
            if (dnr.bp(str, "https://", false)) {
                cykVarAg.writeByte(10);
                bzo.n(handshake);
                cykVarAg.q(handshake.cipherSuite().javaName());
                cykVarAg.writeByte(10);
                n(cykVarAg, handshake.peerCertificates());
                n(cykVarAg, handshake.localCertificates());
                cykVarAg.q(handshake.tlsVersion().javaName());
                cykVarAg.writeByte(10);
            }
            ensVar = ens.a;
        } catch (Throwable th2) {
            th = th2;
            ensVar = null;
        }
        try {
            cykVarAg.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            } else {
                aye.j(th, th3);
            }
        }
        if (th != null) {
            throw th;
        }
        bzo.n(ensVar);
    }

    public bci(Response response) {
        Headers headersBuild;
        bzo.q(response, "response");
        this.c = response.request().url().toString();
        Response responseNetworkResponse = response.networkResponse();
        bzo.n(responseNetworkResponse);
        Headers headers = responseNetworkResponse.request().headers();
        Headers headers2 = response.headers();
        int size = headers2.size();
        Set treeSet = null;
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers2.name(i))) {
                String strValue = headers2.value(i);
                if (treeSet == null) {
                    dnr.bk();
                    treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                Iterator it = dnj.ar(strValue, new char[]{','}).iterator();
                while (it.hasNext()) {
                    treeSet.add(dnj.ba((String) it.next()).toString());
                }
            }
        }
        treeSet = treeSet == null ? avh.a : treeSet;
        if (treeSet.isEmpty()) {
            headersBuild = Util.EMPTY_HEADERS;
        } else {
            Headers.Builder builder = new Headers.Builder();
            int size2 = headers.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strName = headers.name(i2);
                if (treeSet.contains(strName)) {
                    builder.add(strName, headers.value(i2));
                }
            }
            headersBuild = builder.build();
        }
        this.d = headersBuild;
        this.e = response.request().method();
        this.f = response.protocol();
        this.g = response.code();
        this.h = response.message();
        this.i = response.headers();
        this.j = response.handshake();
        this.k = response.sentRequestAtMillis();
        this.l = response.receivedResponseAtMillis();
    }
}
