package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ap {
    private static HostnameVerifier a;

    private static HostnameVerifier a() {
        if (a == null) {
            a = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ap.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return "pre-ucc.umeng.com".equalsIgnoreCase(str) || "ucc.umeng.com".equalsIgnoreCase(str) || "aspect-upush.umeng.com".equalsIgnoreCase(str) || "pre-msg.umengcloud.com".equalsIgnoreCase(str) || "ulogs.umeng.com".equalsIgnoreCase(str) || "preulogs.umeng.com".equalsIgnoreCase(str) || "cnlogs.umeng.com".equalsIgnoreCase(str);
                }
            };
        }
        return a;
    }

    public static byte[] a(String str, String str2) {
        return a(str, str2.getBytes());
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] streamToByteArray;
        byte[] bArrA = null;
        try {
            HttpsURLConnection httpsURLConnectionA = a(str, "ak", ax.a(bArr, UMConfigure.sAppkey.getBytes()));
            if (httpsURLConnectionA != null && httpsURLConnectionA.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnectionA.getInputStream();
                try {
                    streamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    String headerField = httpsURLConnectionA.getHeaderField("ak");
                    if (!TextUtils.isEmpty(headerField)) {
                        bArrA = ax.a(streamToByteArray, headerField.getBytes());
                    } else {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "ccg 应答不包含ak!");
                    }
                    HelperUtils.safeClose(inputStream);
                    return bArrA;
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(inputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void a(String str, byte[] bArr, String str2) {
        byte[] bArrA;
        int responseCode;
        HttpsURLConnection httpsURLConnectionA = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ax.a(bArr, byteArrayOutputStream);
                bArrA = ax.a(byteArrayOutputStream.toByteArray(), UMConfigure.sAppkey.getBytes());
            } catch (Throwable unused) {
                bArrA = null;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "appkey";
            }
            httpsURLConnectionA = a(str, str2, bArrA);
            if (httpsURLConnectionA != null && (responseCode = httpsURLConnectionA.getResponseCode()) != 200) {
                String str3 = "SC";
                if (aq.b.equals(str)) {
                    str3 = "UMC";
                } else if (aq.c.equals(str)) {
                    str3 = "EkvError";
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, str3 + " event report error, http error code: " + responseCode);
            }
            if (httpsURLConnectionA == null) {
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                if (httpsURLConnectionA != null) {
                    try {
                        httpsURLConnectionA.disconnect();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    private static HttpsURLConnection a(String str, String str2, byte[] bArr) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e) {
            e = e;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(a());
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setConnectTimeout(by.b);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(by.b);
            httpsURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
            httpsURLConnection.addRequestProperty(str2, UMConfigure.sAppkey);
            httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            return httpsURLConnection;
        } catch (Exception e2) {
            e = e2;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            return httpsURLConnection2;
        }
    }
}
