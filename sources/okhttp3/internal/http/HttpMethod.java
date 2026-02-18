package okhttp3.internal.http;

import me.hd.wauxv.obf.bzo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        bzo.q(str, "method");
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String str) {
        bzo.q(str, "method");
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public final boolean invalidatesCache(String str) {
        bzo.q(str, "method");
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public final boolean redirectsToGet(String str) {
        bzo.q(str, "method");
        return !str.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        bzo.q(str, "method");
        return str.equals("PROPFIND");
    }
}
