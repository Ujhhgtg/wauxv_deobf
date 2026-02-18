package me.hd.wauxv.obf;

import java.io.IOException;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bch {
    public static String a(Request request) {
        bzo.q(request, "request");
        yg.t(request.tag(cmz.class));
        String str = request.method() + request.url();
        sj sjVar = sj.a;
        return nu.g(str).f("SHA-1").h();
    }

    public static int b(cyl cylVar) throws IOException {
        try {
            long jK = cylVar.k();
            String strM = cylVar.m(Long.MAX_VALUE);
            if (jK >= 0 && jK <= 2147483647L && strM.length() <= 0) {
                return (int) jK;
            }
            throw new IOException("expected an int but was \"" + jK + strM + '\"');
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }
}
