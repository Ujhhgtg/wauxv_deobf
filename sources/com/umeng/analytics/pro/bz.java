package com.umeng.analytics.pro;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum bz {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(5004),
    UnKnownHostException(5005),
    HttpError(5006),
    EmptyResponse(5007),
    ErrorResponse(5008),
    ErrorMakeRequestBody(5009);

    private final int k;

    bz(int i) {
        this.k = i;
    }

    private String b() {
        return yg.m(new StringBuilder("错误码："), " 错误信息：", this.k);
    }

    public String a() {
        return this == UnKnownCode ? yg.o(new StringBuilder(), b(), "--未知错误--") : this == Timeout ? yg.o(new StringBuilder(), b(), "--连接超时--") : this == NetworkUnavailable ? yg.o(new StringBuilder(), b(), "--网络不可用--") : this == SSLException ? yg.o(new StringBuilder(), b(), "--SSL证书认证失败--") : this == IOException ? yg.o(new StringBuilder(), b(), "--IO异常--") : this == HttpError ? yg.o(new StringBuilder(), b(), "--服务端返回HTTP错误--") : this == EmptyResponse ? yg.o(new StringBuilder(), b(), "--服务端返回数据为空--") : this == ErrorResponse ? yg.o(new StringBuilder(), b(), "--服务端返回错误数据--") : this == ErrorMakeRequestBody ? yg.o(new StringBuilder(), b(), "--请求报文构建错误--") : "unknown";
    }
}
